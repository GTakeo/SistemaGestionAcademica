package pe.com.negocio.servicio;

import java.util.List;

import pe.com.negocio.bo.BOGrupo;

public interface NGrupo {

	void agregarGrupo(BOGrupo bo);

	List<BOGrupo> listarGrupoXIdCurso(Integer idCurso);


}
