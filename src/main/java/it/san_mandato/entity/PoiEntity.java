package it.san_mandato.entity;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.locationtech.jts.geom.Point;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "poi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoiEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@UuidGenerator
	@Column(nullable = false, unique = true, updatable = false)
	private UUID uuid;

	@Column(name = "cover_image_url", columnDefinition = "TEXT")
	private String coverImageUrl;

	@Column(nullable = false)
	private String name;

	@Column(name = "is_localized", nullable = false)
	private boolean isLocalized;

	private String address;

	@Column(columnDefinition = "geometry(Point, 4326)")
	private Point coordinates;

	@Column(name = "construction_century")
	private String constructionCentury;

	@Column(name = "area_group")
	private String areaGroup;

	@Column(name = "general_description", columnDefinition = "TEXT")
	private String generalDescription;

	@Column(name = "current_status", columnDefinition = "TEXT")
	private String currentStatus;

	@Column(name = "bibliography", columnDefinition = "TEXT")
	private String bibliography;

	@OneToMany(mappedBy = "poi", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PhotoEntity> photoGallery;

	@ManyToMany
	@JoinTable(name = "poi_architect", joinColumns = @JoinColumn(name = "poi_id"), inverseJoinColumns = @JoinColumn(name = "architect_id"))
	private List<ArchitectEntity> architects;

	public PoiEntity() {
		super();
	}

	public PoiEntity(Long id, UUID uuid, String coverImageUrl, String name, boolean isLocalized, String address,
			Point coordinates, String constructionCentury, String areaGroup, String generalDescription,
			String currentStatus, String bibliography, List<PhotoEntity> photoGallery,
			List<ArchitectEntity> architects) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.coverImageUrl = coverImageUrl;
		this.name = name;
		this.isLocalized = isLocalized;
		this.address = address;
		this.coordinates = coordinates;
		this.constructionCentury = constructionCentury;
		this.areaGroup = areaGroup;
		this.generalDescription = generalDescription;
		this.currentStatus = currentStatus;
		this.bibliography = bibliography;
		this.photoGallery = photoGallery;
		this.architects = architects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
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

	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
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

	public List<PhotoEntity> getPhotoGallery() {
		return photoGallery;
	}

	public void setPhotoGallery(List<PhotoEntity> photoGallery) {
		this.photoGallery = photoGallery;
	}

	public List<ArchitectEntity> getArchitects() {
		return architects;
	}

	public void setArchitects(List<ArchitectEntity> architects) {
		this.architects = architects;
	}

}
