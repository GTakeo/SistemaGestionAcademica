package pe.com.persistencia.entity;

public class BEmpleado {

	private Integer id;
	private String nombre;
	private String cargo;

	public BEmpleado() {
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

	public String getDescripcion() {
		return cargo;
	}

	public void setDescripcion(String descripcion) {
		this.cargo = descripcion;
	}

	@Override
	public String toString() {
		return "BCategoriaIFI [id=" + id + ", nombre=" + nombre + ", descripcion=" + cargo + "]";
	}

}
