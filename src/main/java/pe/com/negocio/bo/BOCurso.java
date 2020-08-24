package pe.com.negocio.bo;

import java.util.Date;

public class BOCurso {

	private Integer id;
	private String codigo;
	private String nombre;
	private Integer duracion;
	private Date fechaInicio;
	private Date fechaTermino;
	
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "BOCurso [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", fechaInicio=" + fechaInicio + ", fechaTermino=" + fechaTermino + "]";
	}	
}
