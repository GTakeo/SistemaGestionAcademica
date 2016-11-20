package pe.com.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOModulo;
import pe.com.persistencia.entity.BModulo;
import pe.com.util.transformador.TransformadorEntityBO;

@Component("tModuloEntityBO")
public class TModulo implements TransformadorEntityBO<BModulo, BOModulo> {

	@Override
	public BOModulo toBO(BModulo input) {
		BOModulo boModulo;
		boModulo=null;
		if(input!=null){
			boModulo= new BOModulo();
			boModulo.setId(input.getId());
			boModulo.setCodigo(input.getCodigo());
			boModulo.setNombre(input.getNombre());
			boModulo.setDuracion(input.getDuracion());;
		}
		return boModulo;
	}

	@Override
	public List<BOModulo> toBO(List<BModulo> lista) {
		List<BOModulo> boModulo;
		boModulo=null;
		if(lista!=null){
			boModulo = new ArrayList<BOModulo>();
			for(BModulo bModulo :lista){
				boModulo.add(toBO(bModulo));
			}
		}
		return boModulo;
	}

	@Override
	public BModulo toEntity(BOModulo input) {
		BModulo bModulo;
		bModulo = null;
		if(input!=null){
			bModulo = new BModulo();
			bModulo.setId(input.getId());
			bModulo.setNombre(input.getNombre());
			bModulo.setCodigo(input.getCodigo());
			bModulo.setDuracion(input.getDuracion());
		}
		return bModulo;
	}
}
