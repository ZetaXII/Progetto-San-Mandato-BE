package it.san_mandato.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import it.san_mandato.dto.PoiCreateDto;
import it.san_mandato.dto.PoiResponseDto;
import it.san_mandato.dto.PoiSearchDto;
import it.san_mandato.entity.PoiEntity;
import it.san_mandato.repository.PoiRepository;
import it.san_mandato.specifications.PoiSpecifications;

@Service
public class PoiService {

	private final PoiRepository poiRepository;

	public PoiService(PoiRepository poiRepository) {
		this.poiRepository = poiRepository;
	}

	// GET all POI → DTO
	public List<PoiResponseDto> getAllPois() {
		return poiRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
	}

	// GET POI by UUID → DTO
	public PoiResponseDto getPoiByUuid(UUID uuid) {
		PoiEntity poi = poiRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("POI non trovato"));
		return toDto(poi);
	}

	// CREATE POI da DTO
	public PoiResponseDto createPoi(PoiCreateDto dto) {
		PoiEntity poi = toEntity(dto, new PoiEntity());

		if (poi.getUuid() == null) {
			poi.setUuid(UUID.randomUUID());
		}

		PoiEntity saved = poiRepository.save(poi);
		return toDto(saved);
	}

	// UPDATE POI da DTO + UUID
	public PoiResponseDto updatePoi(UUID uuid, PoiCreateDto dto) {
		PoiEntity poi = poiRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("POI non trovato"));

		poi = toEntity(dto, poi); // sovrascrivi i campi
		PoiEntity updated = poiRepository.save(poi);
		return toDto(updated);
	}

	// DELETE POI by UUID
	public void deletePoiByUuid(UUID uuid) {
		PoiEntity poi = poiRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("POI non trovato"));
		poiRepository.delete(poi);
	}

	// SEARCH PAGINATA E FILTRABILE
    public Page<PoiResponseDto> searchPoisByFields(PoiSearchDto dto) {
        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize());

        Specification<PoiEntity> spec = Specification.where(PoiSpecifications.hasName(dto.getName()))
                .and(PoiSpecifications.hasAreaGroup(dto.getAreaGroup()))
                .and(PoiSpecifications.hasConstructionCentury(dto.getConstructionCentury()))
                .and(PoiSpecifications.hasGeneralDescription(dto.getGeneralDescription()))
                .and(PoiSpecifications.hasAddress(dto.getAddress()))
                .and(PoiSpecifications.isLocalized(dto.getIsLocalized()));

        return poiRepository.findAll(spec, pageable)
                .map(this::toDto);
    }

	// ======= METODI DI MAPPING =======

	private static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory();

	private PoiEntity toEntity(PoiCreateDto dto, PoiEntity poi) {

		poi.setName(dto.getName());
		poi.setIsLocalized(dto.isLocalized());
		poi.setAddress(dto.getAddress());

		// ===== coordinates =====
		if (dto.getLatitude() != null && dto.getLongitude() != null) {
			Point point = GEOMETRY_FACTORY.createPoint(new Coordinate(dto.getLongitude(), dto.getLatitude()));
			poi.setCoordinates(point);
		} else {
			poi.setCoordinates(null);
		}

		poi.setConstructionCentury(dto.getConstructionCentury());
		poi.setAreaGroup(dto.getAreaGroup());
		poi.setGeneralDescription(dto.getGeneralDescription());
		poi.setCurrentStatus(dto.getCurrentStatus());
		poi.setBibliography(dto.getBibliography());
		poi.setCoverImageUrl(dto.getCoverImageUrl());

		return poi;
	}

	private PoiResponseDto toDto(PoiEntity poi) {
		PoiResponseDto dto = new PoiResponseDto();

		dto.setUuid(poi.getUuid());
		dto.setName(poi.getName());
		dto.setIsLocalized(poi.isLocalized());
		dto.setAddress(poi.getAddress());

		// ===== coordinates =====
		if (poi.getCoordinates() != null) {
			dto.setLatitude(poi.getCoordinates().getY()); // lat
			dto.setLongitude(poi.getCoordinates().getX()); // lon
		}

		dto.setConstructionCentury(poi.getConstructionCentury());
		dto.setAreaGroup(poi.getAreaGroup());
		dto.setGeneralDescription(poi.getGeneralDescription());
		dto.setCurrentStatus(poi.getCurrentStatus());
		dto.setBibliography(poi.getBibliography());
		dto.setCoverImageUrl(poi.getCoverImageUrl());

		if (poi.getArchitects() != null && !poi.getArchitects().isEmpty()) {
			dto.setArchitects(poi.getArchitects().stream().map(a -> a.getName()).collect(Collectors.toList()));
		}

		return dto;
	}

}
