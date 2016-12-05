package pe.com.negocio.bo;

import java.util.ArrayList;
import java.util.List;

public class BOModulo {

	private Integer id;
	private Integer idPro;
	private String codigo;
	private String nombre;
	private Integer duracion;
	private List<BOCurso> listaCurso;
	
	public BOModulo() {
		listaCurso = new ArrayList<BOCurso>();
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
	public List<BOCurso> getListaCurso() {
		return listaCurso;
	}
	public void setListaCurso(List<BOCurso> listaCurso) {
		this.listaCurso = listaCurso;
	}
	public Integer getIdPro() {
		return idPro;
	}
	public void setIdPro(Integer idPro) {
		this.idPro = idPro;
	}
	@Override
	public String toString() {
		return "BOModulo [id=" + id + ", idPro=" + idPro + ", codigo=" + codigo + ", nombre=" + nombre + ", duracion="
				+ duracion + ", listaCurso=" + listaCurso + "]";
	}

}
