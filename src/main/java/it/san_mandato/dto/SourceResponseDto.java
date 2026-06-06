package it.san_mandato.dto;

import java.util.UUID;

import it.san_mandato.enumeration.SourceTypeEnum;

public class SourceResponseDto {

	private UUID uuid;
	private String titolo;
	private SourceTypeEnum tipologia;
	private String riferimento;
	private Integer secolo;
	private Integer anno;
	private String trascrizione;

	public SourceResponseDto() {
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

}