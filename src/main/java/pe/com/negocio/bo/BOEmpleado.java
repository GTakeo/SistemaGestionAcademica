package pe.com.negocio.bo;

public class BOEmpleado {

	private Integer id;
	private String nombre;
	private String cargo;

	public BOEmpleado() {
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

	public void setCargo(String descripcion) {
		this.cargo = descripcion;
	}

	@Override
	public String toString() {
		return "BOEmpleado [id=" + id + ", nombre=" + nombre + ", cargo=" + cargo + "]";
	}

}
