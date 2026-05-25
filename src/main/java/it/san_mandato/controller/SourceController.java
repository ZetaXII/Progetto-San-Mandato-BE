package it.san_mandato.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.san_mandato.dto.SourceEditDto;
import it.san_mandato.entity.SourceEntity;
import it.san_mandato.enumeration.SourceTypeEnum;
import it.san_mandato.service.SourceService;

@RestController
@RequestMapping("/api/pois/{poiUuid}/sources")
public class SourceController {

	private final SourceService sourceService;

	public SourceController(SourceService sourceService) {
		this.sourceService = sourceService;
	}

	@GetMapping
	public ResponseEntity<List<SourceEntity>> getSources(@PathVariable UUID poiUuid,
			@RequestParam(required = false) SourceTypeEnum type) {

		List<SourceEntity> sources;
		if (type != null) {
			sources = sourceService.getSourcesByPoiAndType(poiUuid, type);
		} else {
			sources = sourceService.getSourcesByPoiUuid(poiUuid);
		}
		return ResponseEntity.ok(sources);
	}

	@PostMapping
	public ResponseEntity<SourceEntity> createSource(@PathVariable UUID poiUuid, @RequestBody SourceEditDto source) {
		SourceEntity createdSource = sourceService.addSourceToPoi(poiUuid, source);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdSource);
	}

	@PutMapping("/{sourceUuid}")
	public ResponseEntity<SourceEntity> updateSource(@PathVariable UUID poiUuid, @PathVariable UUID sourceUuid,
			@RequestBody SourceEditDto sourceDetails) {

		SourceEntity updatedSource = sourceService.updateSource(sourceUuid, sourceDetails);
		return ResponseEntity.ok(updatedSource);
	}

	@DeleteMapping("/{sourceUuid}")
	public ResponseEntity<Void> deleteSource(@PathVariable UUID poiUuid, @PathVariable UUID sourceUuid) {
		sourceService.deleteSource(sourceUuid);
		return ResponseEntity.noContent().build();
	}
}