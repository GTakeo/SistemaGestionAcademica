package pe.com.persistencia.entity;

public class BPrograma {

	private Integer id;
	private String codigo;
	private String nombre;
	private Integer duracion;
	
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
	
	@Override
	public String toString() {
		return "BPrograma [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}


}
