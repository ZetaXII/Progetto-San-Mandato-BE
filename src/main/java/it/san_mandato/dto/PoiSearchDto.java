package it.san_mandato.dto;

import lombok.Data;

@Data
public class PoiSearchDto {
	private String name;
	private String areaGroup;
	private String constructionCentury;
	private String generalDescription;
	private String address;
	private Boolean isLocalized; // Boolean per poter essere null (non filtrare)
	private int page = 0;
	private int size = 10;

	public PoiSearchDto() {
		super();
	}

	public PoiSearchDto(String name, String areaGroup, String constructionCentury, String generalDescription,
			String address, Boolean isLocalized, int page, int size) {
		super();
		this.name = name;
		this.areaGroup = areaGroup;
		this.constructionCentury = constructionCentury;
		this.generalDescription = generalDescription;
		this.address = address;
		this.isLocalized = isLocalized;
		this.page = page;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaGroup() {
		return areaGroup;
	}

	public void setAreaGroup(String areaGroup) {
		this.areaGroup = areaGroup;
	}

	public String getConstructionCentury() {
		return constructionCentury;
	}

	public void setConstructionCentury(String constructionCentury) {
		this.constructionCentury = constructionCentury;
	}

	public String getGeneralDescription() {
		return generalDescription;
	}

	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIsLocalized() {
		return isLocalized;
	}

	public void setIsLocalized(Boolean isLocalized) {
		this.isLocalized = isLocalized;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}