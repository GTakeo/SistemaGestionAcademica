package pe.com.presentacion.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOEmpleado;
import pe.com.presentacion.form.FEmpleado;
import pe.com.util.transformador.TransformadorBOForm;

@Component("tEmpleadoBOForm")
public class TEmpleado implements TransformadorBOForm<BOEmpleado, FEmpleado> {

	@Override
	public FEmpleado toForm(BOEmpleado input) {
		FEmpleado fCategoriaIFI = null;
		if (input != null) {
			fCategoriaIFI = new FEmpleado();
			fCategoriaIFI.setId(input.getId());
			fCategoriaIFI.setNombre(input.getNombre());
			fCategoriaIFI.setCargo(input.getCargo());
		}
		return fCategoriaIFI;
	}

	@Override
	public List<FEmpleado> toForm(List<BOEmpleado> lista) {
		List<FEmpleado> listaF = new ArrayList<FEmpleado>();
		for (BOEmpleado boCategoriaIFI : lista) {
			listaF.add(toForm(boCategoriaIFI));
		}
		return listaF;
	}

	@Override
	public BOEmpleado toBO(FEmpleado input) {
		BOEmpleado boCategoriaIFI = null;
		if (input != null) {
			boCategoriaIFI = new BOEmpleado();
			boCategoriaIFI.setId(input.getId());
			boCategoriaIFI.setNombre(input.getNombre());
			boCategoriaIFI.setCargo(input.getCargo());
		}
		return boCategoriaIFI;
	}

}
