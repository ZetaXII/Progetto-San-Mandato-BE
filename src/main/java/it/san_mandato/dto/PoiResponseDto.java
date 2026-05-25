package it.san_mandato.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import it.san_mandato.entity.SourceEntity;
import lombok.Data;

@Data
public class PoiResponseDto {

	private UUID uuid;
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
	private List<SourceEntity> sources = new ArrayList<>();
	private List<String> architects;

	public PoiResponseDto() {
		super();
	}

	public PoiResponseDto(UUID uuid, String name, boolean isLocalized, String address, Double latitude,
			Double longitude, String constructionCentury, String areaGroup, String generalDescription,
			String currentStatus, String bibliography, String coverImageUrl, List<String> architects) {
		super();
		this.uuid = uuid;
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
		this.architects = architects;
	}
	
	public PoiResponseDto(UUID uuid, String name, boolean isLocalized, String address, Double latitude,
			Double longitude, String constructionCentury, String areaGroup, String generalDescription,
			String currentStatus, String bibliography, String coverImageUrl, List<String> architects, List<SourceEntity> sources) {
		super();
		this.uuid = uuid;
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
		this.architects = architects;
		this.sources = sources;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
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

	public void setIsLocalized(boolean isLocalized) {
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

	public void setLocalized(boolean isLocalized) {
		this.isLocalized = isLocalized;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

	public List<String> getArchitects() {
		return architects;
	}

	public void setArchitects(List<String> architects) {
		this.architects = architects;
	}

	public List<SourceEntity> getSources() {
		return sources;
	}

	public void setSources(List<SourceEntity> sources) {
		this.sources = sources;
	}

}
