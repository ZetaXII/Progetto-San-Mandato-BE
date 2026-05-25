package it.san_mandato.dto;

import it.san_mandato.enumeration.SourceTypeEnum;

public class SourceEditDto {

	private String titolo;
	private SourceTypeEnum tipologia;
	private String riferimento;
	private Integer secolo;
	private Integer anno;
	private String trascrizione;

	public SourceEditDto() {
		super();
	}

	public SourceEditDto(String titolo, SourceTypeEnum tipologia, String riferimento, Integer secolo, Integer anno,
			String trascrizione) {
		super();
		this.titolo = titolo;
		this.tipologia = tipologia;
		this.riferimento = riferimento;
		this.secolo = secolo;
		this.anno = anno;
		this.trascrizione = trascrizione;
	}

	// --- GETTER E SETTER ---

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