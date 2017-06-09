package pe.com.presentacion.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.validation.constraints.Pattern;

import pe.com.negocio.bo.BOGrupo;

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
	private List<SelectItem> listaSelectPrograma;
	private List<SelectItem> listaSelectModulo;
	private List<SelectItem> listaSelectGrupo;
	
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
	
	public List<SelectItem> getListaSelectPrograma() {
		return listaSelectPrograma;
	}

	public void setListaSelectPrograma(List<SelectItem> listaSelectPrograma) {
		this.listaSelectPrograma = listaSelectPrograma;
	}

	public List<SelectItem> getListaSelectModulo() {
		return listaSelectModulo;
	}

	public void setListaSelectModulo(List<SelectItem> listaSelectModulo) {
		this.listaSelectModulo = listaSelectModulo;
	}
	
	public List<SelectItem> getListaSelectGrupo() {
		return listaSelectGrupo;
	}

	public void setListaSelectGrupo(List<SelectItem> listaSelectGrupo) {
		this.listaSelectGrupo = listaSelectGrupo;
	}

	@Override
	public String toString() {
		return "FAlumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", celular=" + celular + ", fechaNacimiento=" + fechaNacimiento + ", dni="
				+ dni + ", correo=" + correo + "]";
	}

	public void obtenerSelectItemsPrograma(List<FPrograma> lista) {
		if (lista != null && lista.size() > 0) {
			listaSelectPrograma = new ArrayList<SelectItem>();
			for (FPrograma fPrograma : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(fPrograma.getNombre());
				item.setValue(fPrograma.getId());
				listaSelectPrograma.add(item);
			}
		}
	}	
	
	public void obtenerSelectItemsModulo(List<FModulo> lista) {
		listaSelectModulo = new ArrayList<SelectItem>();
		if (lista != null && lista.size() > 0) {
			for (FModulo fModulo : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(fModulo.getNombre());
				item.setValue(fModulo.getId());
				listaSelectModulo.add(item);
			}
		}
	}	
	
	public void obtenerSelectItemsGrupo(List<BOGrupo> lista) {
		listaSelectGrupo = new ArrayList<SelectItem>();
		if (lista != null && lista.size() > 0) {
			for (BOGrupo fGrupo : lista) {
				SelectItem item = new SelectItem();
				item.setLabel(fGrupo.getNombre());
				item.setValue(fGrupo.getId());
				listaSelectGrupo.add(item);
			}
		}
	}	
	

}
