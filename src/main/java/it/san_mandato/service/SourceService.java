package it.san_mandato.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.san_mandato.dto.SourceEditDto;
import it.san_mandato.dto.SourceResponseDto;
import it.san_mandato.entity.SourceEntity;
import it.san_mandato.enumeration.SourceTypeEnum;
import it.san_mandato.repository.PoiRepository;
import it.san_mandato.repository.SourceRepository;

@Service
public class SourceService {

	private final SourceRepository sourceRepository;
	private final PoiRepository poiRepository;

	public SourceService(SourceRepository sourceRepository, PoiRepository poiRepository) {
		this.sourceRepository = sourceRepository;
		this.poiRepository = poiRepository;
	}

	public List<SourceResponseDto> getSourcesByPoiUuid(UUID poiUuid) {
		return sourceRepository.findByPoiUuid(poiUuid).stream().map(this::toDto).collect(Collectors.toList());
	}

	public List<SourceResponseDto> getSourcesByPoiAndType(UUID poiUuid, SourceTypeEnum tipologia) {
		return sourceRepository.findByPoiUuidAndTipologia(poiUuid, tipologia).stream().map(this::toDto)
				.collect(Collectors.toList());
	}

	@Transactional
	public SourceResponseDto addSourceToPoi(UUID poiUuid, SourceEditDto sourceDto) {
		var poi = poiRepository.findByUuid(poiUuid)
				.orElseThrow(() -> new RuntimeException("POI non trovato con UUID: " + poiUuid));

		SourceEntity newSource = toEntity(sourceDto, new SourceEntity());
		newSource.setPoi(poi);

		if (newSource.getUuid() == null) {
			newSource.setUuid(UUID.randomUUID());
		}

		SourceEntity saved = sourceRepository.save(newSource);
		return toDto(saved);
	}

	@Transactional
	public SourceResponseDto updateSource(UUID sourceUuid, SourceEditDto newDetails) {
		SourceEntity existingSource = sourceRepository.findByUuid(sourceUuid)
				.orElseThrow(() -> new RuntimeException("Fonte non trovata con UUID: " + sourceUuid));

		existingSource = toEntity(newDetails, existingSource);
		SourceEntity updated = sourceRepository.save(existingSource);
		return toDto(updated);
	}

	@Transactional
	public void deleteSource(UUID sourceUuid) {
		SourceEntity source = sourceRepository.findByUuid(sourceUuid)
				.orElseThrow(() -> new RuntimeException("Fonte non trovata con UUID: " + sourceUuid));
		sourceRepository.delete(source);
	}

	// ======= METODI DI MAPPING =======

	private SourceEntity toEntity(SourceEditDto dto, SourceEntity source) {
		source.setTitolo(dto.getTitolo());
		source.setTipologia(dto.getTipologia());
		source.setRiferimento(dto.getRiferimento());
		source.setSecolo(dto.getSecolo());
		source.setAnno(dto.getAnno());
		source.setTrascrizione(dto.getTrascrizione());
		return source;
	}

	public SourceResponseDto toDto(SourceEntity source) {
		SourceResponseDto dto = new SourceResponseDto();

		dto.setUuid(source.getUuid());
		dto.setTitolo(source.getTitolo());
		dto.setTipologia(source.getTipologia());
		dto.setRiferimento(source.getRiferimento());
		dto.setSecolo(source.getSecolo());
		dto.setAnno(source.getAnno());
		dto.setTrascrizione(source.getTrascrizione());

		return dto;
	}
}