package pe.com.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class FModulo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String codigo;
	private String nombre;
	private Integer duracion;
	private List<FCurso> listaCurso;
	private List<SelectItem> listaSelectCurso;
	
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
	public List<SelectItem> getListaSelectCurso() {
		return listaSelectCurso;
	}
	public void setListaSelectCurso(List<SelectItem> listaSelectCurso) {
		this.listaSelectCurso = listaSelectCurso;
	}
	
	@Override
	public String toString() {
		return "FModulo [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", listaCurso=" + listaCurso + "]";
	}
	
	public void obtenerSelectItemsCurso(List<FCurso> lista) {
		if (lista != null && lista.size() > 0) {
			listaSelectCurso = new ArrayList<SelectItem>();
			for (FCurso fCurso : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(fCurso.getNombre());
				item.setValue(fCurso.getId());
				listaSelectCurso.add(item);
			}
		}
	}	


	
}
