package pe.com.negocio.servicio;

import pe.com.negocio.bo.BOTema;

public interface NTema {

	void agregarTema(BOTema boTema);
	void eliminarTemaXIdCurso(Integer idCurso);
}
