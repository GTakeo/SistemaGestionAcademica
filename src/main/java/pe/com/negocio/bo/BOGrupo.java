package pe.com.negocio.bo;

import java.util.Date;

public class BOGrupo {

	private Integer id;
	private Integer idCurso;
	private String codigo;
	private String nombre;
	private Integer vacantes;
	private Integer inscritos;
	private Date fechaInicio;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getVacantes() {
		return vacantes;
	}
	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}
	public Integer getInscritos() {
		return inscritos;
	}
	public void setInscritos(Integer inscritos) {
		this.inscritos = inscritos;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	@Override
	public String toString() {
		return "BOGrupo [id=" + id + ", idCurso=" + idCurso + ", codigo=" + codigo + ", nombre=" + nombre
				+ ", vacantes=" + vacantes + ", inscritos=" + inscritos + ", fechaInicio=" + fechaInicio + "]";
	}
}
