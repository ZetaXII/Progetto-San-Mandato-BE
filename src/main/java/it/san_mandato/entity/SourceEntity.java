package it.san_mandato.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import it.san_mandato.enumeration.SourceTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fonti")
public class SourceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@UuidGenerator
	@Column(nullable = false, unique = true, updatable = false)
	private UUID uuid;

	@Column(nullable = false)
	private String titolo;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private SourceTypeEnum tipologia;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String riferimento;

	private Integer secolo;

	private Integer anno;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String trascrizione;

	@ManyToOne
	@JoinColumn(name = "poi_id", nullable = false)
	private PoiEntity poi;

	// Costruttore vuoto obbligatorio per JPA
	public SourceEntity() {
	}

	// Costruttore completo
	public SourceEntity(Long id, UUID uuid, String titolo, SourceTypeEnum tipologia, String riferimento, Integer secolo,
			Integer anno, String trascrizione, PoiEntity poi) {
		this.id = id;
		this.uuid = uuid;
		this.titolo = titolo;
		this.tipologia = tipologia;
		this.riferimento = riferimento;
		this.secolo = secolo;
		this.anno = anno;
		this.trascrizione = trascrizione;
		this.poi = poi;
	}

	// Getter e Setter

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

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public SourceTypeEnum getTipologia() {
		return tipologia;
	}

	public void setTipologia(SourceTypeEnum tipologia) {
		this.tipologia = tipologia;
	}

	public String getRiferimento() {
		return riferimento;
	}

	public void setRiferimento(String riferimento) {
		this.riferimento = riferimento;
	}

	public Integer getSecolo() {
		return secolo;
	}

	public void setSecolo(Integer secolo) {
		this.secolo = secolo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getTrascrizione() {
		return trascrizione;
	}

	public void setTrascrizione(String trascrizione) {
		this.trascrizione = trascrizione;
	}

	public PoiEntity getPoi() {
		return poi;
	}

	public void setPoi(PoiEntity poi) {
		this.poi = poi;
	}
}