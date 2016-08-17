package pe.com.negocio.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.negocio.bo.BOEmpleado;
import pe.com.negocio.servicio.NEmpleado;
import pe.com.persistencia.entity.BEmpleado;
import pe.com.persistencia.mapper.MEmpleado;
import pe.com.util.Constantes;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NEmpleadoImpl implements NEmpleado {

	@Autowired
	MEmpleado mEmpleado;

	@Autowired
	@Qualifier("tEmpleadoEntityBO")
	TransformadorEntityBO<BEmpleado, BOEmpleado> transformar;

	@Override
	public List<BOEmpleado> listarEmpleados() {
		List<BOEmpleado> listaCategoriasIFI = null;
		try {
			listaCategoriasIFI = transformar.toBO(mEmpleado.listarEmpleados());
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return listaCategoriasIFI;
	}

	@Override
	public BOEmpleado obtenerEmpleadoXId(Integer id) {
		BOEmpleado categoriaIFI = null;
		try {
			categoriaIFI = transformar.toBO(mEmpleado.obtenerEmpleadoXId(id));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return categoriaIFI;
	}

	@Override
	public BOEmpleado obtenerEmpleadoXNombre(String nombreEmpleado) {
		BOEmpleado empleado = null;
		try {
			empleado = transformar.toBO(mEmpleado.obtenerEmpleadoXNombre(nombreEmpleado));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return empleado;
	}

	@Override
	public void insertarEmpleado(BOEmpleado empleado) {
		try {
			mEmpleado.insertarEmpleado(transformar.toEntity(empleado));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void modificarEmpleado(BOEmpleado empleado) {
		try {
			mEmpleado.modificarEmpleado(transformar.toEntity(empleado));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void eliminarEmpleado(Integer idEmpleado) {
		try {
			mEmpleado.eliminarEmpleado(idEmpleado);
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

}
