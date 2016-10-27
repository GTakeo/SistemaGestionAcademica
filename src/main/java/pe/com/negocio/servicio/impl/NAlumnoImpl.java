package pe.com.negocio.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.negocio.bo.BOAlumno;
import pe.com.negocio.servicio.NAlumno;
import pe.com.persistencia.entity.BAlumno;
import pe.com.persistencia.mapper.MAlumno;
import pe.com.util.Constantes;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NAlumnoImpl implements NAlumno {

	@Autowired
	MAlumno mAlumno;

	@Autowired
	@Qualifier("tAlumnoEntityBO")
	TransformadorEntityBO<BAlumno, BOAlumno> transformar;

	@Override
	public List<BOAlumno> listarAlumnos() {
		List<BOAlumno> listarAlumnos = null;
		try {
			listarAlumnos = transformar.toBO(mAlumno.listarAlumnos());
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return listarAlumnos;
	}

	@Override
	public BOAlumno obtenerAlumnoXId(Integer id) {
		BOAlumno boAlumno = null;
		try {
			boAlumno = transformar.toBO(mAlumno.obtenerAlumnoXId(id));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return boAlumno;
	}

	@Override
	public BOAlumno obtenerAlumnoXNombre(String nombreAlumno) {
		BOAlumno boAlumno = null;
		try {
			boAlumno = transformar.toBO(mAlumno.obtenerAlumnoXNombre(nombreAlumno));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return boAlumno;
	}

	@Override
	public void insertarAlumno(BOAlumno Alumno) {
		try {
			mAlumno.insertarAlumno(transformar.toEntity(Alumno));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void modificarAlumno(BOAlumno Alumno) {
		try {
			mAlumno.modificarAlumno(transformar.toEntity(Alumno));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

	@Override
	public void eliminarAlumno(Integer idAlumno) {
		try {
			mAlumno.eliminarAlumno(idAlumno);
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
	}

}
