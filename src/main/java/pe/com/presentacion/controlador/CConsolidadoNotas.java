package pe.com.presentacion.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import pe.com.negocio.bo.BOAlumno;
import pe.com.negocio.bo.BOGrupo;
import pe.com.negocio.bo.BOModulo;
import pe.com.negocio.bo.BOPrograma;
import pe.com.negocio.servicio.NAlumno;
import pe.com.negocio.servicio.NCurso;
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
	NCurso nCurso;

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
	Integer idCurso;
	Integer idGrupo;
	String codGrupo;

	List<Map<String, Object>> listaAlumnoNota;
	boolean programaDesactivado;
	boolean moduloDesactivado;
	boolean cursoDesactivado;
	boolean grupoDesactivado;
	boolean guardarDesactivado;
	boolean consultarXCodGrupoDesactivado;
	boolean consultarXIdGrupoDesactivado;

	private List<Map<String, Object>> jasperLista;
	private Map<String, Object> jasperInfo;

	List<BOGrupo> listaGrupo;

	@PostConstruct
	public void init() {
		inicializarObjetos();
	}

	public void inicializarObjetos() {
		try {
			fAlumno = new FAlumno();
			listaAlumnoNota = null;
			fAlumno.obtenerSelectItemsPrograma(transfPro.toForm(nPrograma.ListarProgramas()));
			programaDesactivado = false;
			moduloDesactivado = true;
			cursoDesactivado = true;
			grupoDesactivado = true;

			// buttons
			consultarXCodGrupoDesactivado = false;
			consultarXIdGrupoDesactivado = true;
			guardarDesactivado = true;

		} catch (DataAccessException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (BusinessLogicException e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, e.getMessage());
		}
	}

	public void consultarNotas() {

		listaAlumnoNota = nAlumno.listarAlumnosxGrupo(idGrupo);

		if (listaAlumnoNota.size() == 0) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, "El grupo seleccionado no cuenta con alumnos matriculados");
		} else {
			programaDesactivado = true;
			moduloDesactivado = true;
			cursoDesactivado = true;
			grupoDesactivado = true;

			consultarXCodGrupoDesactivado = true;
			consultarXIdGrupoDesactivado = true;
			guardarDesactivado = false;

		}
	}

	public void consultarNotasxCodGrupo() {
		// Se asumira que cada curso tiene el mismo codigo de grupo
		listaAlumnoNota = nAlumno.listarAlumnosxCodGrupo(codGrupo);

		if (listaAlumnoNota.size() == 0) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, "El codigo ingresado no existe o no tiene alumnos matriculados");
		} else {
			programaDesactivado = true;
			moduloDesactivado = true;
			cursoDesactivado = true;
			grupoDesactivado = true;

			consultarXCodGrupoDesactivado = true;
			consultarXIdGrupoDesactivado = true;
			guardarDesactivado = false;

		}
	}

	public void guardarNotas() {
		try {
			Integer nota, idAlumno;
			String nombre, apellido, correo, curso = null;

			// Obtener el nombre del Curso X id Curso o cod Grupo

			if (codGrupo.length() > 0) {
				curso = nCurso.obtenerNombreCursoXCodGrupo(codGrupo);
			}

			for (Map<String, Object> map : listaAlumnoNota) {

				nota = Integer.parseInt(map.get("MTR_NOTA").toString());
				idAlumno = Integer.parseInt(map.get("ID_ALU").toString());
				nAlumno.agregarNotaAlumno(idAlumno, idGrupo, nota);

				jasperLista = new ArrayList<Map<String, Object>>();
				jasperInfo = new HashMap<String, Object>();

				nombre = map.get("ALU_APELLIDO").toString();
				apellido = map.get("ALU_NOMBRE").toString();
				correo = map.get("ALU_CORREO").toString();

				jasperInfo.put("nombreAlumno", apellido + " " + nombre);
				jasperInfo.put("nombreCurso", curso);
				jasperInfo.put("fechaHoy", "21 de Abril del 2019");
				jasperInfo.put("fechaInicioFin", "10/02/2019 al 10/04/2019 ");
				jasperInfo.put("correo", correo);

				jasperLista.add(jasperInfo);

				fAlumno.exportarPDF(jasperLista, apellido + "_" + nombre + "_" + curso);

			}

			// fAlumno.validarPDF();

			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Se registró con exito las notas de los alumnos");
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, "Ocurrió un error: " + e.getMessage());
		}

	}

	public void obtenerSelectItemsModulo() {

		fAlumno.obtenerSelectItemsModulo(transfMod.toForm(nPrograma.listarModulos(idPrograma)));
		moduloDesactivado = false;
	}

	public void obtenerSelectItemsCurso() {

		fAlumno.obtenerSelectItemsCurso(nCurso.listarCursoXIdModulo(idModulo));
		cursoDesactivado = false;
	}

	public void obtenerSelectItemsGrupo() {
		fAlumno.obtenerSelectItemsGrupo(nGrupo.listarGrupoXIdCurso(idCurso));
		grupoDesactivado = false;
		consultarXIdGrupoDesactivado = false;
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

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getCodGrupo() {
		return codGrupo;
	}

	public void setCodGrupo(String codGrupo) {
		this.codGrupo = codGrupo;
	}

	public boolean isCursoDesactivado() {
		return cursoDesactivado;
	}

	public void setCursoDesactivado(boolean cursoDesactivado) {
		this.cursoDesactivado = cursoDesactivado;
	}

	public boolean isGrupoDesactivado() {
		return grupoDesactivado;
	}

	public void setGrupoDesactivado(boolean grupoDesactivado) {
		this.grupoDesactivado = grupoDesactivado;
	}

	public boolean isConsultarXCodGrupoDesactivado() {
		return consultarXCodGrupoDesactivado;
	}

	public void setConsultarXCodGrupoDesactivado(boolean consultarXCodGrupoDesactivado) {
		this.consultarXCodGrupoDesactivado = consultarXCodGrupoDesactivado;
	}

	public boolean isConsultarXIdGrupoDesactivado() {
		return consultarXIdGrupoDesactivado;
	}

	public void setConsultarXIdGrupoDesactivado(boolean consultarXIdGrupoDesactivado) {
		this.consultarXIdGrupoDesactivado = consultarXIdGrupoDesactivado;
	}

	
	public boolean isModuloDesactivado() {
		return moduloDesactivado;
	}
	

	public void setModuloDesactivado(boolean moduloDesactivado) {
		this.moduloDesactivado = moduloDesactivado;
	}
	
	
}
