package pe.com.presentacion.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOTema;
import pe.com.presentacion.form.FTema;
import pe.com.util.transformador.TransformadorBOForm;

@Component("tTemaBOForm")
public class TTema implements TransformadorBOForm<BOTema, FTema> {
	

	
	@Override
	public FTema toForm(BOTema input) {
		FTema fTema = null;
		if (input != null) {
			fTema = new FTema();
			fTema.setId(input.getId());
			fTema.setIdCurso(input.getIdCurso());
			fTema.setNombre(input.getNombre());
			fTema.setDuracion(input.getDuracion());
		}
		return fTema;
	}

	@Override
	public List<FTema> toForm(List<BOTema> lista) {
		List<FTema> listaFTema = new ArrayList<FTema>();
		for (BOTema boTema : lista) {
			listaFTema.add(toForm(boTema));
		}
		return listaFTema;
	}

	@Override
	public BOTema toBO(FTema input) {
		BOTema boTema = null;
		if (input != null) {
			boTema = new BOTema();
			boTema.setId(input.getId());
			boTema.setIdCurso(input.getIdCurso());
			boTema.setNombre(input.getNombre());
			boTema.setDuracion(input.getDuracion());
		}
		return boTema;
	}
}
