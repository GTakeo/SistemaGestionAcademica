package pe.com.negocio.servicio;

import java.util.List;
import java.util.Map;

import pe.com.negocio.bo.BOAlumno;

public interface NAlumno {

	public List<BOAlumno> listarAlumnos();

	public BOAlumno obtenerAlumnoXId(Integer id);

	public BOAlumno obtenerAlumnoXNombre(String nombreAlumno);

	public void insertarAlumno(BOAlumno Alumno);

	public void modificarAlumno(BOAlumno categoriaIFI);

	public void eliminarAlumno(Integer idCategoria);
	
	public void matricularAlumno(Integer idAlumno,Integer idGrupo);

	public List<Map<String, String>> listarAlumnosxGrupo(Integer idGrupo);

	public void agregarNotaAlumno(Integer codigoAlumno,Integer codigoGrupo,Integer nota);

}
