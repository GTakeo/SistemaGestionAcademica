package pe.com.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOPrograma;
import pe.com.persistencia.entity.BPrograma;
import pe.com.util.transformador.TransformadorEntityBO;

@Component("tProgramaEntityBO")
public class TPrograma implements TransformadorEntityBO<BPrograma, BOPrograma> {
	
	@Override
	public BOPrograma toBO(BPrograma input) {
		BOPrograma boPrograma = null;
		if (input != null) {
			boPrograma = new BOPrograma();
			boPrograma.setId(input.getId());
			boPrograma.setCodigo(input.getCodigo());
			boPrograma.setNombre(input.getNombre());
			boPrograma.setDuracion(input.getDuracion());
		}
		return boPrograma;
	}

	@Override
	public List<BOPrograma> toBO(List<BPrograma> lista) {
		List<BOPrograma> listaBOPrograma = new ArrayList<BOPrograma>();
		if(lista != null){
			for (BPrograma bPrograma : lista) {
				listaBOPrograma.add(toBO(bPrograma));
			}
		}
		return listaBOPrograma;
	}

	@Override
	public BPrograma toEntity(BOPrograma input) {
		BPrograma bPrograma = null;
		if (input != null) {
			bPrograma = new BPrograma();
			bPrograma.setId(input.getId());
			bPrograma.setCodigo(input.getCodigo());
			bPrograma.setNombre(input.getNombre());
			bPrograma.setDuracion(input.getDuracion());
		}
		return bPrograma;
	}

}
