package pe.com.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.negocio.bo.BOCurso;
import pe.com.negocio.bo.BOGrupo;
import pe.com.negocio.bo.BOModulo;
import pe.com.negocio.bo.BOPrograma;
import pe.com.negocio.servicio.NDetalleModulo;
import pe.com.negocio.servicio.NGrupo;
import pe.com.negocio.servicio.NPrograma;
import pe.com.persistencia.entity.BModulo;
import pe.com.persistencia.entity.BPrograma;
import pe.com.persistencia.mapper.MModulo;
import pe.com.persistencia.mapper.MPrograma;
import pe.com.util.Constantes;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NProgramaImpl implements NPrograma {
	@Autowired
	MPrograma mPrograma;
	
	@Autowired
	MModulo mModulo;
	
	@Autowired
	NDetalleModulo nDetalleModulo;
	
	@Autowired
	NGrupo nGrupo;
	
	@Autowired
	@Qualifier("tProgramaEntityBO")
	TransformadorEntityBO<BPrograma, BOPrograma> transformar;
	
	@Autowired
	@Qualifier("tModuloEntityBO")
	TransformadorEntityBO<BModulo, BOModulo> transformarModulo;
	
	@Override
	public List<BOPrograma> ListarProgramas() {
		List<BOPrograma> listaPrograma=null;
		try {
			listaPrograma = transformar.toBO(mPrograma.listarProgramas());
			for(BOPrograma boPrograma :listaPrograma){
				boPrograma.setListaModulo(transformarModulo.toBO(mModulo.obtenerModulosPorPrograma(boPrograma.getId())));
			}
			
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return listaPrograma;
	}

	@Override
	public void agregarPrograma(BOPrograma bo) {
		try {
			Integer idPrograma,idModulo;
			BOGrupo boGrupo;

			mPrograma.agregarPrograma(transformar.toEntity(bo));

			idPrograma=mPrograma.obtenerUltimoId();
			
			for(BOModulo boModulo :bo.getListaModulo()){
				boModulo.setIdPro(idPrograma);
				mModulo.agregarModulo(boModulo);
				
				idModulo=mModulo.obtenerUltimoId();
				
				for(BOCurso boCurso:boModulo.getListaCurso()){
					nDetalleModulo.agregarDetalleModulo(idModulo, boCurso.getId());
					
					boGrupo = new BOGrupo();
					
					boGrupo.setIdCurso(boCurso.getId());
					boGrupo.setCodigo(boCurso.getCodigo());
					boGrupo.setNombre("Grupo 1 - "+boCurso.getNombre());
					boGrupo.setVacantes(30);
					boGrupo.setInscritos(0);
					
					nGrupo.agregarGrupo(boGrupo);
					
				}
			}
			
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		
	}

	@Override
	public List<BOModulo> listarModulos(Integer idPrograma) {
		List<BOModulo> lista = null;
		try {
			lista = new ArrayList<BOModulo>();
			lista = transformarModulo.toBO(mModulo.listarModulos(idPrograma));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return lista;
	}
	
	
}
