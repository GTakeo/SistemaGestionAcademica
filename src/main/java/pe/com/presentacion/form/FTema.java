package pe.com.presentacion.form;

import java.io.Serializable;

public class FTema implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer idCurso;
	private String nombre;
	private Integer duracion;
	
	
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		return "FTema [id=" + id + ", idCurso=" + idCurso + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}
}
