package it.san_mandato.dto;

import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class PoiEditDto {

	private String name;
	private boolean isLocalized;
	private String address;
	private Double latitude;
	private Double longitude;
	private String constructionCentury;
	private String areaGroup;
	private String generalDescription;
	private String currentStatus;
	private String bibliography;
	private String coverImageUrl;

	private List<UUID> architectIds; // lista di architetti da associare

	public PoiEditDto() {
		super();
	}

	public PoiEditDto(String name, boolean isLocalized, String address, Double latitude, Double longitude,
			String constructionCentury, String areaGroup, String generalDescription, String currentStatus,
			String bibliography, String coverImageUrl, List<UUID> architectIds) {
		super();
		this.name = name;
		this.isLocalized = isLocalized;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.constructionCentury = constructionCentury;
		this.areaGroup = areaGroup;
		this.generalDescription = generalDescription;
		this.currentStatus = currentStatus;
		this.bibliography = bibliography;
		this.coverImageUrl = coverImageUrl;
		this.architectIds = architectIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLocalized() {
		return isLocalized;
	}

	public void setLocalized(boolean isLocalized) {
		this.isLocalized = isLocalized;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getConstructionCentury() {
		return constructionCentury;
	}

	public void setConstructionCentury(String constructionCentury) {
		this.constructionCentury = constructionCentury;
	}

	public String getAreaGroup() {
		return areaGroup;
	}

	public void setAreaGroup(String areaGroup) {
		this.areaGroup = areaGroup;
	}

	public String getGeneralDescription() {
		return generalDescription;
	}

	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getBibliography() {
		return bibliography;
	}

	public void setBibliography(String bibliography) {
		this.bibliography = bibliography;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

	public List<UUID> getArchitectIds() {
		return architectIds;
	}

	public void setArchitectIds(List<UUID> architectIds) {
		this.architectIds = architectIds;
	}

}
