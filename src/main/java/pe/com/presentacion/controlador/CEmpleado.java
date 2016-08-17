package pe.com.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import pe.com.negocio.bo.BOEmpleado;
import pe.com.negocio.servicio.NEmpleado;
import pe.com.presentacion.form.FEmpleado;
import pe.com.util.Constantes;
import pe.com.util.PaginaUtil;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorBOForm;

@Controller("cMantenerEmpleado")
public class CEmpleado {

	@Autowired
	NEmpleado nEmpleado;

	@Autowired
	@Qualifier("tEmpleadoBOForm")
	TransformadorBOForm<BOEmpleado, FEmpleado> transformar;

	List<FEmpleado> listaEmpleado;

	FEmpleado fEmpleado;

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listaEmpleado = transformar.toForm(nEmpleado.listarEmpleados());
			fEmpleado = new FEmpleado();
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarAgregarEmpleado() {
		fEmpleado = new FEmpleado();
		PaginaUtil.ejecutar("PF('wgvAgregarEmpleado').show()");
	}

	public void agregarEmpleado() {
		try {
			nEmpleado.insertarEmpleado(transformar.toBO(fEmpleado));
			listaEmpleado = transformar.toForm(nEmpleado.listarEmpleados());
			PaginaUtil.ejecutar("PF('wgvAgregarEmpleado').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Empleado agregado exitosamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarModificarEmpleado(FEmpleado fEmpleado) {
		this.fEmpleado = fEmpleado;
		PaginaUtil.ejecutar("PF('wgvModificarEmpleado').show()");
	}

	public void modificarEmpleado() {
		try {
			nEmpleado.modificarEmpleado(transformar.toBO(fEmpleado));
			listaEmpleado = transformar.toForm(nEmpleado.listarEmpleados());
			PaginaUtil.ejecutar("PF('wgvModificarEmpleado').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Empleado modificado exitosamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarEliminarEmpleado(FEmpleado fEmpleado) {
		this.fEmpleado = fEmpleado;
		PaginaUtil.ejecutar("PF('wgvEliminarEmpleado').show()");
	}

	public void eliminarEmpleado() {
		try {
			nEmpleado.eliminarEmpleado(fEmpleado.getId());
			listaEmpleado = transformar.toForm(nEmpleado.listarEmpleados());
			PaginaUtil.ejecutar("PF('wgvEliminarEmpleado').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Empleado eliminado exitosamente");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public List<FEmpleado> getlistaEmpleado() {
		return listaEmpleado;
	}

	public void setlistaEmpleado(List<FEmpleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}

	public FEmpleado getfEmpleado() {
		return fEmpleado;
	}

	public void setfEmpleado(FEmpleado fEmpleado) {
		this.fEmpleado = fEmpleado;
	}

}
