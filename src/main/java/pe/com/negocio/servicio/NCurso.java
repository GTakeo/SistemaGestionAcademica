package pe.com.negocio.servicio;

import java.util.List;

import pe.com.negocio.bo.BOCurso;

public interface NCurso {

	public List<BOCurso> listarCursos();
	public void eleminarCurso(Integer id);
	public void agregarCurso(BOCurso boCurso);
}
