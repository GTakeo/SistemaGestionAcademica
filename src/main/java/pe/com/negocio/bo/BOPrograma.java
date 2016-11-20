package pe.com.negocio.bo;

import java.util.ArrayList;
import java.util.List;

public class BOPrograma {

	private Integer id;
	private String codigo;
	private String nombre;
	private Integer duracion;
	private List<BOModulo> listaModulo;

	public BOPrograma() {
		listaModulo = new ArrayList<BOModulo>();
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
	public List<BOModulo> getListaModulo() {
		return listaModulo;
	}
	public void setListaModulo(List<BOModulo> listaModulo) {
		this.listaModulo = listaModulo;
	}
	@Override
	public String toString() {
		return "BOPrograma [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", listaModulo=" + listaModulo + "]";
	}
}
