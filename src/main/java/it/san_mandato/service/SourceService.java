package it.san_mandato.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.san_mandato.dto.SourceEditDto;
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

	public List<SourceEntity> getSourcesByPoiUuid(UUID poiUuid) {
		return sourceRepository.findByPoiUuid(poiUuid);
	}

	public List<SourceEntity> getSourcesByPoiAndType(UUID poiUuid, SourceTypeEnum tipologia) {
		return sourceRepository.findByPoiUuidAndTipologia(poiUuid, tipologia);
	}

	@Transactional
	public SourceEntity addSourceToPoi(UUID poiUuid, SourceEditDto sourceDto) {
		var poi = poiRepository.findByUuid(poiUuid)
				.orElseThrow(() -> new RuntimeException("POI non trovato con UUID: " + poiUuid));

		SourceEntity newSource = new SourceEntity();

		newSource.setTitolo(sourceDto.getTitolo());
		newSource.setTipologia(sourceDto.getTipologia());
		newSource.setRiferimento(sourceDto.getRiferimento());
		newSource.setSecolo(sourceDto.getSecolo());
		newSource.setAnno(sourceDto.getAnno());
		newSource.setTrascrizione(sourceDto.getTrascrizione());
		newSource.setPoi(poi);

		return sourceRepository.save(newSource);
	}

	@Transactional
	public SourceEntity updateSource(UUID sourceUuid, SourceEditDto newDetails) {
		SourceEntity existingSource = sourceRepository.findByUuid(sourceUuid)
				.orElseThrow(() -> new RuntimeException("Fonte non trovata con UUID: " + sourceUuid));

		existingSource.setTitolo(newDetails.getTitolo());
		existingSource.setTipologia(newDetails.getTipologia());
		existingSource.setRiferimento(newDetails.getRiferimento());
		existingSource.setSecolo(newDetails.getSecolo());
		existingSource.setAnno(newDetails.getAnno());
		existingSource.setTrascrizione(newDetails.getTrascrizione());

		return sourceRepository.save(existingSource);
	}

	@Transactional
	public void deleteSource(UUID sourceUuid) {
		SourceEntity source = sourceRepository.findByUuid(sourceUuid)
				.orElseThrow(() -> new RuntimeException("Fonte non trovata"));
		sourceRepository.delete(source);
	}
}