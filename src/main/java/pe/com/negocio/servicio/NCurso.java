package pe.com.negocio.servicio;

import java.util.List;

import pe.com.negocio.bo.BOCurso;

public interface NCurso {

	public List<BOCurso> listarCursos();
	public void eliminarCurso(Integer id);
	public void agregarCurso(BOCurso boCurso);
	public List<BOCurso> listarCursoXIdModulo(Integer idModulo);
	public String obtenerNombreCursoXCodGrupo(String codGrupo);

}
