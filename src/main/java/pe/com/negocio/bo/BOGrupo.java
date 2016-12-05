package pe.com.negocio.bo;

import java.util.Date;

public class BOGrupo {

	private Integer id;
	private Integer idModulo;
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
	public Integer getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
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
		return "BOGrupo [id=" + id + ", idModulo=" + idModulo + ", codigo=" + codigo + ", nombre=" + nombre
				+ ", vacantes=" + vacantes + ", inscritos=" + inscritos + ", fechaInicio=" + fechaInicio + "]";
	}
}
