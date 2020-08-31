package pe.com.negocio.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.negocio.bo.BOTema;
import pe.com.negocio.servicio.NTema;
import pe.com.persistencia.entity.BTema;
import pe.com.persistencia.mapper.MTema;
import pe.com.util.Constantes;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NTemaImpl implements NTema {
	@Autowired
	MTema mTema;

	@Autowired
	@Qualifier("tTemaEntityBO")
	TransformadorEntityBO<BTema, BOTema> transformar;
	
	
	@Override
	public void agregarTema(BOTema boTema) {
		try {
			mTema.agregarTema(transformar.toEntity(boTema));
			
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		
	}


	@Override
	public void eliminarTemaXIdCurso(Integer idCurso) {
		try {
			mTema.eliminarTemaXIdCurso(idCurso);
			
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

}
