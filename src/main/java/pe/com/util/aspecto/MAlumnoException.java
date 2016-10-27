package pe.com.util.aspecto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.stereotype.Component;

import pe.com.util.Constantes;
import pe.com.util.excepcion.DataAccessException;

@Component
@Aspect
public class MAlumnoException {

	@AfterThrowing(pointcut = "execution(* pe.com.persistencia.mapper.MAlumno.listarAlumnos())", throwing = "error")
	public void listarCategoriasIFI(JoinPoint joinPoint, Throwable error) {
		if (error instanceof UncategorizedDataAccessException) {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}

	@AfterThrowing(pointcut = "execution(* pe.com.persistencia.mapper.MAlumno.obtenerAlumnoXId(..))", throwing = "error")
	public void obtenerCategoriaIFIXId(JoinPoint joinPoint, Throwable error) {
		if (error instanceof UncategorizedDataAccessException) {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}

	@AfterThrowing(pointcut = "execution(* pe.com.persistencia.mapper.MAlumno.obtenerAlumnoXNombre(..))", throwing = "error")
	public void obtenerCategoriaIFIXNombre(JoinPoint joinPoint, Throwable error) {
		if (error instanceof UncategorizedDataAccessException) {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}

	@AfterThrowing(pointcut = "execution(* pe.com.persistencia.mapper.MAlumno.insertarAlumno(..))", throwing = "error")
	public void insertarEmpleado(JoinPoint joinPoint, Throwable error) {
		if (error instanceof DuplicateKeyException) {
			throw new DataAccessException("Nombre debe ser único", error);
		} else if (error instanceof DataIntegrityViolationException) {
			throw new DataAccessException("Nombre no debe ser nuloX", error);
		} else if (error instanceof UncategorizedDataAccessException) {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}

	@AfterThrowing(pointcut = "execution(* pe.com.persistencia.mapper.MAlumno.modificarAlumno(..))", throwing = "error")
	public void modificarCategoriaIFI(JoinPoint joinPoint, Throwable error) {
		if (error instanceof DuplicateKeyException) {
			throw new DataAccessException("Nombre debe ser único", error);
		} else if (error instanceof DataIntegrityViolationException) {
			throw new DataAccessException("Nombre no debe ser nulo", error);
		} else if (error instanceof UncategorizedDataAccessException) {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}

	@AfterThrowing(pointcut = "execution(* pe.com.persistencia.mapper.MAlumno.eliminarAlumno(..))", throwing = "error")
	public void eliminarCategoriaIFI(JoinPoint joinPoint, Throwable error) {
		if (error instanceof DataIntegrityViolationException) {
			throw new DataAccessException("No se pudo eliminar categoría IFI porque está siendo usada actualmente",
					error);
		} else if (error instanceof UncategorizedDataAccessException) {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_NO_CATEGORIZADO, error);
		} else {
			throw new DataAccessException(Constantes.ERROR_ACCESO_DATOS_OTRO, error);
		}
	}

}
