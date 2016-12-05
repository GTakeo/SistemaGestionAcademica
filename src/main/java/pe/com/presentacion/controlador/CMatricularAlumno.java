package pe.com.presentacion.controlador;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import pe.com.negocio.bo.BOAlumno;
import pe.com.negocio.bo.BOModulo;
import pe.com.negocio.bo.BOPrograma;
import pe.com.negocio.servicio.NAlumno;
import pe.com.negocio.servicio.NGrupo;
import pe.com.negocio.servicio.NPrograma;
import pe.com.presentacion.form.FAlumno;
import pe.com.presentacion.form.FModulo;
import pe.com.presentacion.form.FPrograma;
import pe.com.util.Constantes;
import pe.com.util.PaginaUtil;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorBOForm;

@Controller("cMatricularAlumno")
public class CMatricularAlumno {

	@Autowired
	NAlumno nAlumno;

	@Autowired
	NPrograma nPrograma;
	
	@Autowired
	NGrupo nGrupo;
		
	@Autowired
	@Qualifier("tAlumnoBOForm")
	TransformadorBOForm<BOAlumno, FAlumno> transformar;
	
	@Autowired
	@Qualifier("tProgramaBOForm")
	TransformadorBOForm<BOPrograma, FPrograma> transfPro;
	
	@Autowired
	@Qualifier("tModuloBOForm")
	TransformadorBOForm<BOModulo, FModulo> transfMod;
	
	
	List<FAlumno> listaAlumno;
	FAlumno fAlumno;
	Integer idPrograma;
	Integer idModulo;
	Integer idGrupo;


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
	
	public void obtenerSelectItemsModulo(){
		fAlumno.obtenerSelectItemsModulo(transfMod.toForm(nPrograma.listarModulos(idPrograma)));
	}
	
	public void obtenerSelectItemsGrupo(){
		fAlumno.obtenerSelectItemsGrupo(nGrupo.listarGrupos(idModulo));
	}
	
	public void iniciarMatricula(FAlumno fAlumno){
		this.fAlumno = fAlumno;
		fAlumno.obtenerSelectItemsPrograma(transfPro.toForm(nPrograma.ListarProgramas()));;
		PaginaUtil.ejecutar("PF('wgvMAtricularAlumno').show()");
	}
	
	public void matricularAlumno(){
		try {
			nAlumno.matricularAlumno(fAlumno.getId(), idGrupo);
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Alumno matriculado exitosamente");
			PaginaUtil.ejecutar("PF('wgvMAtricularAlumno').hide()");
		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
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

	public Integer getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Integer idPrograma) {
		this.idPrograma = idPrograma;
	}

	public Integer getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Integer idModulo) {
		this.idModulo = idModulo;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}
	
	
}
