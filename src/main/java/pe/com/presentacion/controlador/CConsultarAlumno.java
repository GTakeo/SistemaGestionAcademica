package pe.com.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import pe.com.negocio.bo.BOAlumno;
import pe.com.negocio.servicio.NAlumno;
import pe.com.presentacion.form.FAlumno;
import pe.com.util.Constantes;
import pe.com.util.PaginaUtil;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorBOForm;

@Controller("cConsultarAlumno")
public class CConsultarAlumno {

	@Autowired
	NAlumno nAlumno;

	@Autowired
	@Qualifier("tAlumnoBOForm")
	TransformadorBOForm<BOAlumno, FAlumno> transformar;

	List<FAlumno> listaAlumno;

	FAlumno fAlumno;

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			listaAlumno = transformar.toForm(nAlumno.listarAlumnos());
			fAlumno = new FAlumno();
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void iniciarConsultarAlumno(FAlumno alumno){
		this.fAlumno=alumno;
		PaginaUtil.ejecutar("PF('wgvConsularAlumno').show()");
	}


	public List<FAlumno> getListaAlumno() {
		return listaAlumno;
	}

	public void setListaAlumno(List<FAlumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}

	public FAlumno getfAlumno() {
		return fAlumno;
	}

	public void setfAlumno(FAlumno fAlumno) {
		this.fAlumno = fAlumno;
	}

}
