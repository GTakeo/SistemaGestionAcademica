package pe.com.presentacion.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOCurso;
import pe.com.negocio.bo.BOModulo;
import pe.com.presentacion.form.FCurso;
import pe.com.presentacion.form.FModulo;
import pe.com.util.transformador.TransformadorBOForm;

@Component("tModuloBOForm")
public class TModulo implements TransformadorBOForm<BOModulo, FModulo> {
	@Autowired
	@Qualifier("tCursoBOForm")
	TransformadorBOForm<BOCurso, FCurso> transformar;
	
	@Override
	public FModulo toForm(BOModulo input) {
		FModulo fModulo;
		fModulo=null;
		if(input != null){
			fModulo = new FModulo();
			fModulo.setId(input.getId());
			fModulo.setNombre(input.getNombre());
			fModulo.setCodigo(input.getCodigo());
			fModulo.setDuracion(input.getDuracion());
			fModulo.setListaCurso(transformar.toForm(input.getListaCurso()));
		}
		return fModulo;
	}

	@Override
	public List<FModulo> toForm(List<BOModulo> lista) {
		List<FModulo> listaModulo;
		listaModulo = null;
		if(lista != null){
			listaModulo = new ArrayList<FModulo>();
			for(BOModulo boModulo:lista){
				listaModulo.add(toForm(boModulo));
			}
		}
		return listaModulo;
	}

	@Override
	public BOModulo toBO(FModulo input) {
		BOModulo boModulo;
		boModulo=null;
		if(input != null){
			boModulo = new BOModulo();
			boModulo.setId(input.getId());
			boModulo.setNombre(input.getNombre());
			boModulo.setCodigo(input.getCodigo());
			boModulo.setDuracion(input.getDuracion());
			for(FCurso fCurso :input.getListaCurso()){
				boModulo.getListaCurso().add(transformar.toBO(fCurso));
			}			
		}
		return boModulo;
	}
	

}
