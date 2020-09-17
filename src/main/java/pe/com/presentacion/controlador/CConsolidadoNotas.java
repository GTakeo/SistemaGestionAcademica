package pe.com.presentacion.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import pe.com.negocio.bo.BOAlumno;
import pe.com.negocio.bo.BOGrupo;
import pe.com.negocio.bo.BOModulo;
import pe.com.negocio.bo.BOPrograma;
import pe.com.negocio.bo.BOTema;
import pe.com.negocio.servicio.NAlumno;
import pe.com.negocio.servicio.NCurso;
import pe.com.negocio.servicio.NGrupo;
import pe.com.negocio.servicio.NPrograma;
import pe.com.negocio.servicio.NTema;
import pe.com.presentacion.form.FAlumno;
import pe.com.presentacion.form.FModulo;
import pe.com.presentacion.form.FPrograma;
import pe.com.presentacion.form.FTema;
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
	NTema nTema;

	@Autowired
	@Qualifier("tAlumnoBOForm")
	TransformadorBOForm<BOAlumno, FAlumno> transformar;

	@Autowired
	@Qualifier("tProgramaBOForm")
	TransformadorBOForm<BOPrograma, FPrograma> transfPro;

	@Autowired
	@Qualifier("tModuloBOForm")
	TransformadorBOForm<BOModulo, FModulo> transfMod;
	
	@Autowired
	@Qualifier("tTemaBOForm")
	TransformadorBOForm<BOTema, FTema> transfTem;

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
	int alumnosAprobados;
	int alumnosDesaprobados;
	int notaAprobatoria=13;
	
	private List<Map<String, Object>> jasperLista;
	private List<Map<String, Object>> jasperLista2;
	private Map<String, Object> jasperInfo;
	private Map<String, Object> jasperInfo2;

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
	
	public void confirmarConsolidadoNotas() {

		
		alumnosAprobados = fAlumno.obtenerCantidadAprobados(listaAlumnoNota,notaAprobatoria);
		alumnosDesaprobados = fAlumno.obtenerCantidadDesaprobados(listaAlumnoNota,notaAprobatoria);
		
		PaginaUtil.ejecutar("PF('wgvEliminarConsolidadoNotas').show()");
		
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
			String nombre, apellido, correo, nombreCurso = null;

			// Obtener el nombre del Curso X id Curso o cod Grupo

			if (codGrupo.length() > 0) {
				nombreCurso = nCurso.obtenerNombreCursoXCodGrupo(codGrupo);
			}else {
				nombreCurso = fAlumno.obtenerNombreCursoXIdCurso(idCurso);
			}
			List<FTema> listaTema = null;
			for (Map<String, Object> map : listaAlumnoNota) {

				nota = Integer.parseInt(map.get("MTR_NOTA").toString());
				idAlumno = Integer.parseInt(map.get("ID_ALU").toString());
				nAlumno.agregarNotaAlumno(idAlumno, idGrupo, nota);

				jasperLista = new ArrayList<Map<String, Object>>();
				jasperInfo = new HashMap<String, Object>();
				
				nombre = map.get("ALU_NOMBRE").toString();
				apellido = map.get("ALU_APELLIDO").toString();
				correo = map.get("ALU_CORREO").toString();

				//REVISAR, SOLO VA NOMBRECURSO O CURSO
				jasperInfo.put("nombreAlumno", apellido + " " + nombre);
				jasperInfo.put("nombreCurso", nombreCurso);
				jasperInfo.put("fechaHoy", fechaHoy() );
				jasperInfo.put("fechaInicioFin", "10/10/2019 al 07/11/2019 ");
				jasperInfo.put("correo", correo);
				jasperInfo.put("curso", nombreCurso);

				jasperLista.add(jasperInfo);
				
				
				
				
				listaTema=transfTem.toForm(nTema.listarTemaXIdGrupo(idGrupo));
				
				
				
				
				jasperLista2 = new ArrayList<Map<String, Object>>();
				
				jasperInfo2  = new HashMap<String, Object>();
				jasperInfo2.put("curso","Microsoft Windows");
				jasperInfo2.put("duracion",8);
				jasperInfo2.put("totalHoras",50);
				jasperInfo2.put("promedioNumero",nota);
				jasperInfo2.put("promedioTexto",obtenerNombreNota(nota));
				
				jasperLista2.add(jasperInfo2);
				
				jasperInfo2  = new HashMap<String, Object>();
				jasperInfo2.put("curso","Microsoft Word");
				jasperInfo2.put("duracion",12);
				jasperInfo2.put("totalHoras",50);
				jasperInfo2.put("promedioNumero",nota);
				jasperInfo2.put("promedioTexto",obtenerNombreNota(nota));
				jasperLista2.add(jasperInfo2);
				
				jasperInfo2  = new HashMap<String, Object>();
				jasperInfo2.put("curso","Microsoft Excel");
				jasperInfo2.put("duracion",14);
				jasperInfo2.put("totalHoras",50);
				jasperInfo2.put("promedioNumero",nota);
				jasperInfo2.put("promedioTexto",obtenerNombreNota(nota));
				jasperLista2.add(jasperInfo2);
				
				jasperInfo2  = new HashMap<String, Object>();
				jasperInfo2.put("curso","Microsoft Power Point");
				jasperInfo2.put("duracion",8);
				jasperInfo2.put("totalHoras",50);
				jasperInfo2.put("promedioNumero",nota);
				jasperInfo2.put("promedioTexto",obtenerNombreNota(nota));
				jasperLista2.add(jasperInfo2);
				
				jasperInfo2  = new HashMap<String, Object>();
				jasperInfo2.put("curso","Nuevas Tecnologías");
				jasperInfo2.put("duracion",8);
				jasperInfo2.put("totalHoras",50);
				jasperInfo2.put("promedioNumero",nota);
				jasperInfo2.put("promedioTexto",obtenerNombreNota(nota));
				jasperLista2.add(jasperInfo2);
				
				
				
				
				
				if(nota>=notaAprobatoria) {
					fAlumno.exportarPDF(jasperLista,jasperLista2, apellido + "_" + nombre + "_" + nombreCurso);
				}else {
					fAlumno.enviarConstancia(jasperLista,apellido + "_" + nombre + "_" + nombreCurso);
				}
				
				
			}
			
			System.out.println(listaTema);

			// fAlumno.validarPDF();

			
			PaginaUtil.mensajeJSF(Constantes.INFORMACION, "Se registró con exito las notas de los alumnos");
		} catch (Exception e) {
			PaginaUtil.mensajeJSF(Constantes.ERROR, "Ocurrió un error: " + e.getMessage());
			System.out.println(e);
		}

	}

	private String obtenerNombreNota(Integer nota) {
		String nombreNota = "";
		
		switch(nota) {
			case 1 : nombreNota = "Uno";break;
			case 2 : nombreNota = "Dos";break;
			case 3 : nombreNota = "Tres";break;
			case 4 : nombreNota = "Cuatro";break;
			case 5 : nombreNota = "Cinco";break;
			case 6 : nombreNota = "Seis";break;
			case 7 : nombreNota = "Siete";break;
			case 8 : nombreNota = "Ocho";break;
			case 9 : nombreNota = "Nueve";break;
			case 10 : nombreNota = "Diez";break;
			case 11 : nombreNota = "Once";break;
			case 12 : nombreNota = "Doce";break;
			case 13 : nombreNota = "Trece";break;
			case 14 : nombreNota = "Catorce";break;
			case 15 : nombreNota = "Quince";break;
			case 16 : nombreNota = "Dieciséis";break;
			case 17 : nombreNota = "Diecisiete";break;
			case 18 : nombreNota = "Dieciocho";break;
			case 19 : nombreNota = "Diecinueve";break;
			case 20 : nombreNota = "Veinte";break;
		}
		
		return nombreNota;
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
	
	@SuppressWarnings("deprecation")
	public String fechaHoy() {
		java.util.Date fecha = new Date();
		
		String fechaString= "26 de Octubre del 2019";
		
		fechaString = fechaString.replaceAll("$dia", String.valueOf(fecha.getDay()))
			 .replaceAll("$mes", String.valueOf(fecha.getMonth()))
			 .replaceAll("$anio", String.valueOf(fecha.getYear()));
		
		return fechaString;
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

	public int getAlumnosAprobados() {
		return alumnosAprobados;
	}

	public void setAlumnosAprobados(int alumnosAprobados) {
		this.alumnosAprobados = alumnosAprobados;
	}

	public int getAlumnosDesaprobados() {
		return alumnosDesaprobados;
	}

	public void setAlumnosDesaprobados(int alumnosDesaprobados) {
		this.alumnosDesaprobados = alumnosDesaprobados;
	}
	
}
