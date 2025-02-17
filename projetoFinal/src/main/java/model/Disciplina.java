package model;

public class Disciplina {
	
	private String id;
	private String nome;
	private String semestre;
	private String carga_horaria;
	public Disciplina(String id, String nome, String semestre, String carga_horaria) {
		super();
		this.id = id;
		this.nome = nome;
		this.semestre = semestre;
		this.carga_horaria = carga_horaria;
	}
	public Disciplina() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(String carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	
}
