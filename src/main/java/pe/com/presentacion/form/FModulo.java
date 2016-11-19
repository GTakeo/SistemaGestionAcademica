package pe.com.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FModulo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String codigo;
	private String nombre;
	private Integer duracion;
	private List<FCurso> listaCurso;
	
	public FModulo() {
		listaCurso = new ArrayList<FCurso>();
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
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public List<FCurso> getListaCurso() {
		return listaCurso;
	}
	public void setListaCurso(List<FCurso> listaCurso) {
		this.listaCurso = listaCurso;
	}
	@Override
	public String toString() {
		return "FModulo [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", listaCurso=" + listaCurso + "]";
	}

	
}
