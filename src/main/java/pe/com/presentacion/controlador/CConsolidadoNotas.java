package pe.com.presentacion.controlador;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

@Controller("cConsolidadoNotas")
public class CConsolidadoNotas {

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
	
	
	FAlumno fAlumno;
	Integer idPrograma;
	Integer idModulo;
	Integer idGrupo;
	
	List<Map<String,Object>> listaAlumnoNota;
	boolean programaDesactivado;
	boolean guardarDesactivado;




	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			fAlumno = new FAlumno();
			listaAlumnoNota = null;
			fAlumno.obtenerSelectItemsPrograma(transfPro.toForm(nPrograma.ListarProgramas()));;
			programaDesactivado=false;
			guardarDesactivado=true;
			

		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}
	
	public void consultarNotas(){
		guardarDesactivado=false;
		programaDesactivado=true;
		listaAlumnoNota = nAlumno.listarAlumnosxGrupo(idGrupo);
	}
	
	public void guardarNotas(){
		Integer nota,idAlumno;
		for(Map<String, Object> map:listaAlumnoNota){		
			nota = Integer.parseInt(map.get("MTR_NOTA").toString());
			idAlumno = Integer.parseInt(map.get("ID_ALU").toString());
			nAlumno.agregarNotaAlumno(idAlumno,idGrupo,nota);
		}
	}
		
	public void obtenerSelectItemsModulo(){

		fAlumno.obtenerSelectItemsModulo(transfMod.toForm(nPrograma.listarModulos(idPrograma)));
	}
	
	public void obtenerSelectItemsGrupo(){

		fAlumno.obtenerSelectItemsGrupo(nGrupo.listarGrupos(idModulo));
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
	
	public List<Map<String, Object>> getListaAlumnoNota() {
		return listaAlumnoNota;
	}

	public void setLista(List<Map<String, Object>> listaAlumnoNota) {
		this.listaAlumnoNota = listaAlumnoNota;
	}
	
	public boolean isProgramaDesactivado() {
		return programaDesactivado;
	}

	public void setProgramaDesactivado(boolean programaDesactivado) {
		this.programaDesactivado = programaDesactivado;
	}
	
	public boolean isGuardarDesactivado() {
		return guardarDesactivado;
	}

	public void setGuardarDesactivado(boolean guardarDesactivado) {
		this.guardarDesactivado = guardarDesactivado;
	}

}
