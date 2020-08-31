package pe.com.negocio.bo;

public class BOTema {
	private Integer id;
	private Integer idCurso;
	private String nombre;
	private Integer duracion;

	
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
	public Integer getDuracion() {
		return duracion;
	}
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	@Override
	public String toString() {
		return "BOTema [id=" + id + ", idCurso=" + idCurso + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}
}
