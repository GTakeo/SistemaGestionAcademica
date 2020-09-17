package pe.com.negocio.servicio;

import java.util.List;

import pe.com.negocio.bo.BOTema;

public interface NTema {

	public void agregarTema(BOTema boTema);
	public void eliminarTemaXIdCurso(Integer idCurso);
	public List<BOTema> listarTemaXIdGrupo(Integer idGrupo);
	
}