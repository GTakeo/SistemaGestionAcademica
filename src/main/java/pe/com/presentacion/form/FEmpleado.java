package pe.com.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import pe.com.negocio.bo.BOEmpleado;

public class FEmpleado implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÑñ]+((\\s)+[a-zA-ZáéíóúÁÉÍÓÚÑñ]+)*$", message = "Nombre no es válido")
	private String nombre;

	@Pattern(regexp = "^([a-zA-ZáéíóúÁÉÍÓÚÑñ]+((\\s)+[a-zA-ZáéíóúÁÉÍÓÚÑñ]+)*)?$", message = "Cargo no es válido")
	private String cargo;

	public FEmpleado() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "FCategoriaIFI [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + "]";
	}

	/*
	 * *** CONVERTIDOR DE -List<BOCategoriaIFI>- A -List<SelectItem>- PARA
	 * CATEGORIA IFI ********
	 */
	public List<SelectItem> convertirSelectItemsCategoriaIFI(List<BOEmpleado> lista) {
		List<SelectItem> listaItems = null;
		if (lista != null && lista.size() > 0) {
			listaItems = new ArrayList<SelectItem>();
			for (BOEmpleado boCategoriaIFI : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(boCategoriaIFI.getNombre());
				item.setValue(boCategoriaIFI.getId());
				listaItems.add(item);
			}
		}
		return listaItems;
	}

}
