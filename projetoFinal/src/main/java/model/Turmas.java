package model;

public class Turmas {
	
	private String id;
	private String sala;
	private String quant;
	private String disc;
	private String prof;
	public Turmas(String id, String sala, String quant, String disc, String prof) {
		super();
		this.id = id;
		this.sala = sala;
		this.quant = quant;
		this.disc = disc;
		this.prof = prof;
	}
	public Turmas() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getQuant() {
		return quant;
	}
	public void setQuant(String quant) {
		this.quant = quant;
	}
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	
	
	
}
