package pe.com.presentacion.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOCurso;
import pe.com.presentacion.form.FCurso;
import pe.com.util.transformador.TransformadorBOForm;

@Component("tCursoBOForm")
public class TCurso implements TransformadorBOForm<BOCurso, FCurso> {
	
	@Override
	public FCurso toForm(BOCurso input) {
		FCurso fCurso = null;
		if (input != null) {
			fCurso = new FCurso();
			fCurso.setId(input.getId());
			fCurso.setCodigo(input.getCodigo());
			fCurso.setNombre(input.getNombre());
			fCurso.setDuracion(input.getDuracion());
			fCurso.setFechaInicio(input.getFechaInicio());
			fCurso.setFechaTermino(input.getFechaTermino());
		}
		return fCurso;
	}

	@Override
	public List<FCurso> toForm(List<BOCurso> lista) {
		List<FCurso> listaFCurso = new ArrayList<FCurso>();
		for (BOCurso boCurso : lista) {
			listaFCurso.add(toForm(boCurso));
		}
		return listaFCurso;
	}

	@Override
	public BOCurso toBO(FCurso input) {
		BOCurso boCurso = null;
		if (input != null) {
			boCurso = new BOCurso();
			boCurso.setId(input.getId());
			boCurso.setCodigo(input.getCodigo());
			boCurso.setNombre(input.getNombre());
			boCurso.setDuracion(input.getDuracion());
			boCurso.setFechaInicio(input.getFechaInicio());
			boCurso.setFechaTermino(input.getFechaTermino());
		}
		return boCurso;
	}
}
