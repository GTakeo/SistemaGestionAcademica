package pe.com.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import pe.com.negocio.bo.BOPrograma;
import pe.com.negocio.servicio.NPrograma;
import pe.com.presentacion.form.FModulo;
import pe.com.presentacion.form.FPrograma;
import pe.com.util.Constantes;
import pe.com.util.PaginaUtil;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorBOForm;

@Controller("cMantenerPrograma")
public class CMantenerPrograma {

	@Autowired
	NPrograma nPrograma;

	@Autowired
	@Qualifier("tProgramaBOForm")
	TransformadorBOForm<BOPrograma, FPrograma> transformar;

	List<FPrograma> listaPrograma;
	FPrograma fPrograma;
	FModulo fModulo;
	
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listaPrograma=transformar.toForm(nPrograma.ListarProgramas());
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void iniciarAgregarPrograma(){
		fPrograma = new FPrograma();
		PaginaUtil.ejecutar("PF('wgvAgregarPrograma').show()");
		
	}
	
	public void agregarPrograma(){
		try {
			nPrograma.agregarPrograma(transformar.toBO(fPrograma));
			listaPrograma=transformar.toForm(nPrograma.ListarProgramas());
			PaginaUtil.ejecutar("PF('wgvAgregarPrograma').hide()");
			fPrograma = null;
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void iniciarAgregarModulo(){
		fModulo = new FModulo();
		PaginaUtil.ejecutar("PF('wgvAgregarModulo').show()");
	}

	public void agregarModulo(){
		fPrograma.getListaModulo().add(fModulo);
		fModulo = null;
		PaginaUtil.ejecutar("PF('wgvAgregarModulo').hide()");
	}
	public List<FPrograma> getListaPrograma() {
		return listaPrograma;
	}

	public void setListaPrograma(List<FPrograma> listaPrograma) {
		this.listaPrograma = listaPrograma;
	}

	public FPrograma getfPrograma() {
		return fPrograma;
	}

	public void setfPrograma(FPrograma fPrograma) {
		this.fPrograma = fPrograma;
	}

	public FModulo getfModulo() {
		return fModulo;
	}

	public void setfModulo(FModulo fModulo) {
		this.fModulo = fModulo;
	}
					
}
