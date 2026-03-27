package it.san_mandato.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "photo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String url;

	private String caption;

	@ManyToOne
	@JoinColumn(name = "poi_id")
	private PoiEntity poi;

	public PhotoEntity() {
		super();
	}

	public PhotoEntity(Long id, String url, String caption, PoiEntity poi) {
		super();
		this.id = id;
		this.url = url;
		this.caption = caption;
		this.poi = poi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public PoiEntity getPoi() {
		return poi;
	}

	public void setPoi(PoiEntity poi) {
		this.poi = poi;
	}
}
