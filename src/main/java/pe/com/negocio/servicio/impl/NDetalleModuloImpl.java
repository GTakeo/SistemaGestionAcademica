package pe.com.negocio.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.negocio.servicio.NDetalleModulo;
import pe.com.persistencia.mapper.MDetalleModulo;
import pe.com.util.Constantes;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NDetalleModuloImpl implements NDetalleModulo {
	@Autowired
	MDetalleModulo mDetalleModulo;

	@Override
	public void agregarDetalleModulo(Integer idModulo, Integer idCurso) {
		try {
			mDetalleModulo.agregarDetalleModulo(idModulo,idCurso);
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		
	}
	
	
	
	
}
