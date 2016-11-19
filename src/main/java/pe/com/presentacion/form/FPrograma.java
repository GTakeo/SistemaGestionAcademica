package pe.com.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FPrograma implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String codigo;
	private String nombre;
	private Integer duracion;
	private List<FModulo> listaModulo;
	
	public FPrograma() {
		listaModulo = new ArrayList<FModulo>();
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
	public List<FModulo> getListaModulo() {
		return listaModulo;
	}
	public void setListaModulo(List<FModulo> listaModulo) {
		this.listaModulo = listaModulo;
	}

	@Override
	public String toString() {
		return "FPrograma [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", listaModulo=" + listaModulo + "]";
	}
	
}
