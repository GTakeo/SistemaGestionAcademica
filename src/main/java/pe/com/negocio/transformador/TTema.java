package pe.com.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOTema;
import pe.com.persistencia.entity.BTema;
import pe.com.util.transformador.TransformadorEntityBO;

@Component("tTemaEntityBO")
public class TTema implements TransformadorEntityBO<BTema, BOTema>{

	@Override
	public BOTema toBO(BTema input) {
		BOTema boTema = null;
		if(input != null) {
			boTema = new BOTema();
			boTema.setId(input.getId());
			boTema.setIdCurso(input.getIdCurso());
			boTema.setDuracion(input.getDuracion());
			boTema.setNombre(input.getNombre());
		}
		return boTema;
	}

	@Override
	public List<BOTema> toBO(List<BTema> lista) {
		List<BOTema> listaBOTema = new ArrayList<BOTema>();
		for (BTema bTema : lista) {
			listaBOTema.add(toBO(bTema));
		}
		return listaBOTema;
	}

	@Override
	public BTema toEntity(BOTema input) {
		BTema bTema = null;
		if(input != null) {
			bTema = new BTema();
			bTema.setId(input.getId());
			bTema.setIdCurso(input.getIdCurso());
			bTema.setDuracion(input.getDuracion());
			bTema.setNombre(input.getNombre());
		}
		return bTema;
	}

}
