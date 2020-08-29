package pe.com.negocio.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.negocio.bo.BOCurso;
import pe.com.negocio.bo.BOTema;
import pe.com.negocio.servicio.NCurso;
import pe.com.negocio.servicio.NTema;
import pe.com.persistencia.entity.BCurso;
import pe.com.persistencia.mapper.MCurso;
import pe.com.util.Constantes;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NCursoImpl implements NCurso {
	@Autowired
	MCurso mCurso;
	
	@Autowired
	NTema nTema;

	@Autowired
	@Qualifier("tCursoEntityBO")
	TransformadorEntityBO<BCurso, BOCurso> transformar;

	@Override
	public List<BOCurso> listarCursos() {
		List<BOCurso> listaCurso = null;
		try {
			listaCurso = transformar.toBO(mCurso.listarCursos());
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return listaCurso;
	}

	@Override
	public void eleminarCurso(Integer id) {
		try {
			mCurso.eliminarCurso(id);
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void agregarCurso(BOCurso boCurso) {
		try {
			Integer idCurso;
			mCurso.agregarCurso(transformar.toEntity(boCurso));
			
			idCurso=mCurso.obtenerUltimoId();
			
			for(BOTema boTema: boCurso.getListaTema()) {
				boTema.setIdCurso(idCurso);
				nTema.agregarTema(boTema);
			}
			
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}

	}

	@Override
	public List<BOCurso> listarCursoXIdModulo(Integer idModulo) {
		List<BOCurso> listaCurso = null;
		try {
			listaCurso = transformar.toBO(mCurso.listarCursoXIdModulo(idModulo));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return listaCurso;
	}

	@Override
	public String obtenerNombreCursoXCodGrupo(String codGrupo) {
		String nombreCurso = null;
		try {
			nombreCurso = mCurso.obtenerNombreCursoXCodGrupo(codGrupo);
			
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return nombreCurso;
	}

}
