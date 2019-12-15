package pe.com.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOGrupo;
import pe.com.persistencia.entity.BGrupo;
import pe.com.util.transformador.TransformadorEntityBO;

@Component("tGrupoEntityBO")
public class TGrupo implements TransformadorEntityBO<BGrupo, BOGrupo> {

	@Override
	public BOGrupo toBO(BGrupo input) {
		BOGrupo boGrupo = null;
		if(input != null){
			boGrupo = new BOGrupo();
			boGrupo.setId(input.getId());
			boGrupo.setIdCurso(input.getIdCurso());
			boGrupo.setCodigo(input.getCodigo());
			boGrupo.setNombre(input.getNombre());
			boGrupo.setVacantes(input.getVacantes());
			boGrupo.setInscritos(input.getInscritos());			
		}
		return boGrupo;
	}

	@Override
	public List<BOGrupo> toBO(List<BGrupo> lista) {
		List<BOGrupo> listaGrupo=null;
		if(lista != null){
			listaGrupo = new ArrayList<BOGrupo>();
			for(BGrupo bGrupo:lista){
				listaGrupo.add(toBO(bGrupo));
			}
		}
		return listaGrupo;
	}

	@Override
	public BGrupo toEntity(BOGrupo input) {
		BGrupo bGrupo = null;
		if(input != null){
			bGrupo = new BGrupo();
			bGrupo.setId(input.getId());
			bGrupo.setIdCurso(input.getIdCurso());
			bGrupo.setCodigo(input.getCodigo());
			bGrupo.setNombre(input.getNombre());
			bGrupo.setVacantes(input.getVacantes());
			bGrupo.setInscritos(input.getInscritos());			
		}
		return bGrupo;
	}
}
