package it.san_mandato.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.san_mandato.dto.PoiEditDto;
import it.san_mandato.dto.PoiResponseDto;
import it.san_mandato.dto.PoiSearchDto;
import it.san_mandato.service.PoiService;

@RestController
@RequestMapping("/api/pois")
@CrossOrigin(origins = "*")
public class PoiController {

	private final PoiService poiService;

	public PoiController(PoiService poiService) {
		this.poiService = poiService;
	}

	// GET ALL
	@GetMapping("/getAll")
	public List<PoiResponseDto> getAllPois() {
		return poiService.getAllPois();
	}

	// GET ONE
	@GetMapping("/get/{uuid}")
	public PoiResponseDto getPoi(@PathVariable UUID uuid) {
		return poiService.getPoiByUuid(uuid);
	}

	// CREATE
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public PoiResponseDto createPoi(@RequestBody PoiEditDto dto) {
		return poiService.createPoi(dto);
	}

	// UPDATE
	@PutMapping("/update/{uuid}")
	public PoiResponseDto updatePoi(@PathVariable UUID uuid, @RequestBody PoiEditDto dto) {
		return poiService.updatePoi(uuid, dto);
	}

	// DELETE
	@DeleteMapping("/delete/{uuid}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePoi(@PathVariable UUID uuid) {
		poiService.deletePoiByUuid(uuid);
	}

	@GetMapping("/search")
	public ResponseEntity<Page<PoiResponseDto>> searchByFields(@RequestParam(required = false) String name,
			@RequestParam(required = false) String areaGroup,
			@RequestParam(required = false) String constructionCentury,
			@RequestParam(required = false) String generalDescription, @RequestParam(required = false) String address,
			@RequestParam(required = false) Boolean isLocalized, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "32") int size) {
		PoiSearchDto dto = new PoiSearchDto();
		dto.setName(name);
		dto.setAreaGroup(areaGroup);
		dto.setConstructionCentury(constructionCentury);
		dto.setGeneralDescription(generalDescription);
		dto.setAddress(address);
		dto.setIsLocalized(isLocalized);
		dto.setPage(page);
		dto.setSize(size);

		return ResponseEntity.ok(poiService.searchPoisByFields(dto));
	}
}
