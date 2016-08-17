package pe.com.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOEmpleado;
import pe.com.persistencia.entity.BEmpleado;
import pe.com.util.PaginaUtil;
import pe.com.util.transformador.TransformadorEntityBO;

@Component("tEmpleadoEntityBO")
public class TEmpleado implements TransformadorEntityBO<BEmpleado, BOEmpleado> {

	@Override
	public BOEmpleado toBO(BEmpleado input) {
		BOEmpleado boEmpleado = null;
		if (input != null) {
			boEmpleado = new BOEmpleado();
			boEmpleado.setId(input.getId());
			boEmpleado.setNombre(input.getNombre());
			boEmpleado.setCargo(input.getDescripcion());
		}
		return boEmpleado;
	}

	@Override
	public List<BOEmpleado> toBO(List<BEmpleado> lista) {
		List<BOEmpleado> listaBO = new ArrayList<BOEmpleado>();
		for (BEmpleado bEmpleado : lista) {
			listaBO.add(toBO(bEmpleado));
		}
		return listaBO;
	}

	@Override
	public BEmpleado toEntity(BOEmpleado input) {
		BEmpleado bEmpleado = null;
		if (input != null) {
			bEmpleado = new BEmpleado();
			bEmpleado.setId(input.getId());
			bEmpleado.setNombre(PaginaUtil.convertirAMayusculas(input.getNombre()));
			bEmpleado.setDescripcion(PaginaUtil.convertirAMayusculas(input.getCargo()));
		}
		return bEmpleado;
	}

}
