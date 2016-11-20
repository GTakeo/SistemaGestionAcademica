package pe.com.negocio.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.negocio.bo.BOCurso;
import pe.com.negocio.bo.BOModulo;
import pe.com.negocio.bo.BOPrograma;
import pe.com.negocio.servicio.NCurso;
import pe.com.negocio.servicio.NPrograma;
import pe.com.persistencia.entity.BCurso;
import pe.com.persistencia.entity.BModulo;
import pe.com.persistencia.entity.BPrograma;
import pe.com.persistencia.mapper.MCurso;
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
			System.out.println(bo);
			mPrograma.agregarPrograma(transformar.toEntity(bo));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		
	}
	
	
}
