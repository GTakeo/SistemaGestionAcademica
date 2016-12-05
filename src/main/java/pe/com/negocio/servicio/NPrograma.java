package pe.com.negocio.servicio;

import java.util.List;

import pe.com.negocio.bo.BOModulo;
import pe.com.negocio.bo.BOPrograma;

public interface NPrograma {

	List<BOPrograma> ListarProgramas();

	void agregarPrograma(BOPrograma bo);

	List<BOModulo> listarModulos(Integer idPrograma);


}
