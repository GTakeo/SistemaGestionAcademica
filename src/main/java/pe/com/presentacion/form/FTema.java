package pe.com.presentacion.form;

import java.io.Serializable;

public class FTema implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private Integer duracion;
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
		return "FTema [nombre=" + nombre + ", duracion=" + duracion + "]";
	}
}
