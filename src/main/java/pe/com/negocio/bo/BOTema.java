package pe.com.negocio.bo;

public class BOTema {
	private String nombre;
	private Integer duracion;
	private Integer idCurso;
	
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
		return "BOTema [nombre=" + nombre + ", duracion=" + duracion + ", idCurso=" + idCurso + "]";
	}
}
