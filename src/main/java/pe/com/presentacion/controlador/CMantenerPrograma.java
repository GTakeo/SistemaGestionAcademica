package pe.com.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import pe.com.negocio.bo.BOCurso;
import pe.com.negocio.bo.BOPrograma;
import pe.com.negocio.servicio.NCurso;
import pe.com.negocio.servicio.NPrograma;
import pe.com.presentacion.form.FCurso;
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
	NCurso nCurso;

	@Autowired
	@Qualifier("tProgramaBOForm")
	TransformadorBOForm<BOPrograma, FPrograma> transformar;
	
	@Autowired
	@Qualifier("tCursoBOForm")
	TransformadorBOForm<BOCurso, FCurso> transfCurso;

	List<FPrograma> listaPrograma;
	FPrograma fPrograma;
	FModulo fModulo;
	FCurso fCurso;
	Integer id;
	List<FCurso> listaAuxiliar;
	
	
	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listaAuxiliar=transfCurso.toForm(nCurso.listarCursos());
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
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Programa agregado exitosamente");
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
		PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Modulo agregado exitosamente");
	}
	
	public void iniciarAgregarCurso(){
		fModulo.obtenerSelectItemsCurso(listaAuxiliar);
		fCurso = new FCurso();
		PaginaUtil.ejecutar("PF('wgvAgregarCurso').show()");

	}
	
	public void agregarCurso(){
		fCurso = obtenerCurso(id);
		fModulo.getListaCurso().add(fCurso);
		fCurso = null;
		id=null;
		PaginaUtil.ejecutar("PF('wgvAgregarCurso').hide()");
		PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Curso agregado exitosamente");
	}
	
	private FCurso obtenerCurso(Integer id) {
		for(FCurso fCurso:listaAuxiliar){
			if(fCurso.getId()==id){
				return fCurso;
			}
		}
		return null;
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

	public FCurso getfCurso() {
		return fCurso;
	}

	public void setfCurso(FCurso fCurso) {
		this.fCurso = fCurso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
						
}
