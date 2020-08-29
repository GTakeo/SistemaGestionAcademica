package pe.com.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import pe.com.negocio.bo.BOCurso;
import pe.com.negocio.servicio.NCurso;
import pe.com.presentacion.form.FCurso;
import pe.com.presentacion.form.FTema;
import pe.com.util.Constantes;
import pe.com.util.PaginaUtil;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorBOForm;

@Controller("cMantenerCurso")
public class CMantenerCurso {

	@Autowired
	NCurso nCurso;

	@Autowired
	@Qualifier("tCursoBOForm")
	TransformadorBOForm<BOCurso, FCurso> transformar;

	List<FCurso> listaCurso;
	FCurso fCurso;
	FTema fTema;
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listaCurso = transformar.toForm(nCurso.listarCursos());
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void iniciarAgregarCurso(){
		fCurso = new FCurso();		
		PaginaUtil.ejecutar("PF('wgvAgregarCurso').show()");
	}

	public void agregarCurso(){
		try {
			nCurso.agregarCurso(transformar.toBO(fCurso));
			PaginaUtil.ejecutar("PF('wgvAgregarCurso').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Curso agregado exitosamente");
			listaCurso = transformar.toForm(nCurso.listarCursos());
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarEliminarCurso(FCurso fCurso) {
		this.fCurso = fCurso;
		PaginaUtil.ejecutar("PF('wgvEliminarCurso').show()");
	}

	public void eliminarCurso() {
		try {
			nCurso.eleminarCurso(fCurso.getId());
			PaginaUtil.ejecutar("PF('wgvEliminarCurso').hide()");
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Curso eliminado exitosamente");
			listaCurso = transformar.toForm(nCurso.listarCursos());
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void iniciarAgregarTema() {
		fTema = new FTema();
		PaginaUtil.ejecutar("PF('wgvAgregarTema').show()");
	}
	
	public void agregarTema() {
		fCurso.getListaTema().add(fTema);
		fTema = null;
		PaginaUtil.ejecutar("PF('wgvAgregarTema').hide()");
		PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Tema agregado exitosamente");
	}
	
	public List<FCurso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<FCurso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public FCurso getfCurso() {
		return fCurso;
	}

	public void setfCurso(FCurso fCurso) {
		this.fCurso = fCurso;
	}

	public FTema getfTema() {
		return fTema;
	}

	public void setfTema(FTema fTema) {
		this.fTema = fTema;
	}
		
}
