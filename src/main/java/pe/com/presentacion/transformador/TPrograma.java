package pe.com.presentacion.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOModulo;
import pe.com.negocio.bo.BOPrograma;
import pe.com.presentacion.form.FModulo;
import pe.com.presentacion.form.FPrograma;
import pe.com.util.transformador.TransformadorBOForm;

@Component("tProgramaBOForm")
public class TPrograma implements TransformadorBOForm<BOPrograma, FPrograma> {
	@Autowired
	@Qualifier("tModuloBOForm")
	TransformadorBOForm<BOModulo, FModulo> transformar;
	
	@Override
	public FPrograma toForm(BOPrograma input) {
		FPrograma fPrograma = null;
		if(input != null){
			fPrograma = new FPrograma();
			fPrograma.setId(input.getId());
			fPrograma.setNombre(input.getNombre());
			fPrograma.setCodigo(input.getCodigo());
			fPrograma.setDuracion(input.getDuracion());
			fPrograma.setListaModulo(transformar.toForm(input.getListaModulo()));
		}
		return fPrograma;
	}

	@Override
	public List<FPrograma> toForm(List<BOPrograma> lista) {
		List<FPrograma> listaPrograma=new ArrayList<FPrograma>();
		if(!lista.isEmpty()){
			for(BOPrograma boPrograma :lista){
				listaPrograma.add(toForm(boPrograma));
			}
		}
		return listaPrograma;
	}

	@Override
	public BOPrograma toBO(FPrograma input) {
		BOPrograma boPrograma;
		boPrograma = null;
		if(input != null){
			boPrograma = new BOPrograma();
			boPrograma.setId(input.getId());
			boPrograma.setCodigo(input.getCodigo());
			boPrograma.setNombre(input.getNombre());
			boPrograma.setDuracion(input.getDuracion());
			for(FModulo fModulo :input.getListaModulo()){
				boPrograma.getListaModulo().add(transformar.toBO(fModulo));
			}
		}
		return boPrograma;
	}
}
