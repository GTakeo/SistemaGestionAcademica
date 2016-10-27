package pe.com.presentacion.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Pattern;

public class FAlumno implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;

	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚÑñ]+((\\s)+[a-zA-ZáéíóúÁÉÍÓÚÑñ]+)*$", message = "Nombre no es válido")
	private String nombre;

	private String apellido;
	private String direccion;
	private String telefono;
	private String celular;
	private Date fechaNacimiento;
	private Integer dni;
	private String correo;
	
	public FAlumno() {
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "FAlumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", celular=" + celular + ", fechaNacimiento=" + fechaNacimiento + ", dni="
				+ dni + ", correo=" + correo + "]";
	}

	/*
	 * *** CONVERTIDOR DE -List<BOCategoriaIFI>- A -List<SelectItem>- PARA
	 * CATEGORIA IFI ********
	 */
//	public List<SelectItem> convertirSelectItemsCategoriaIFI(List<BOAlumno> lista) {
//		List<SelectItem> listaItems = null;
//		if (lista != null && lista.size() > 0) {
//			listaItems = new ArrayList<SelectItem>();
//			for (BOAlumno boCategoriaIFI : lista) {
//				SelectItem item = new SelectItem();
//				item.setLabel(boCategoriaIFI.getNombre());
//				item.setValue(boCategoriaIFI.getId());
//				listaItems.add(item);
//			}
//		}
//		return listaItems;
//	}

}
