package pe.com.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOAlumno;
import pe.com.negocio.bo.BOCurso;
import pe.com.persistencia.entity.BAlumno;
import pe.com.persistencia.entity.BCurso;
import pe.com.util.transformador.TransformadorEntityBO;

@Component("tCursoEntityBO")
public class TCurso implements TransformadorEntityBO<BCurso, BOCurso> {
	
	@Override
	public BOCurso toBO(BCurso input) {
		BOCurso boCurso = null;
		if (input != null) {
			boCurso = new BOCurso();
			boCurso.setId(input.getId());
			boCurso.setCodigo(input.getCodigo());
			boCurso.setNombre(input.getNombre());
		}
		return boCurso;
	}

	@Override
	public List<BOCurso> toBO(List<BCurso> lista) {
		List<BOCurso> listaBOCurso = new ArrayList<BOCurso>();
		for (BCurso bCurso : lista) {
			listaBOCurso.add(toBO(bCurso));
		}
		return listaBOCurso;
	}

	@Override
	public BCurso toEntity(BOCurso input) {
		BCurso bCurso = null;
		if (input != null) {
			bCurso = new BCurso();
			bCurso.setId(input.getId());
			bCurso.setCodigo(input.getCodigo());
			bCurso.setNombre(input.getNombre());
		}
		return bCurso;
	}

}
