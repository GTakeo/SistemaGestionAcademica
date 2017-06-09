package pe.com.negocio.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.negocio.bo.BOCurso;
import pe.com.negocio.bo.BOGrupo;
import pe.com.negocio.servicio.NGrupo;
import pe.com.persistencia.entity.BCurso;
import pe.com.persistencia.entity.BGrupo;
import pe.com.persistencia.mapper.MCurso;
import pe.com.persistencia.mapper.MGrupo;
import pe.com.util.Constantes;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;
import pe.com.util.transformador.TransformadorEntityBO;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class NGrupoImpl implements NGrupo {
	@Autowired
	MGrupo mGrupo;
	
	@Autowired
	@Qualifier("tGrupoEntityBO")
	TransformadorEntityBO<BGrupo, BOGrupo> transformar;

	@Override
	public void agregarGrupo(BOGrupo bo) {
		try {
			mGrupo.agregarGrupo(transformar.toEntity(bo));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
//		catch (DataAccessException dae) {
//			throw dae;
//		} catch (Exception e) {
//			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
//		}
	}

	@Override
	public List<BOGrupo> listarGrupos(Integer idModulo) {
		List<BOGrupo> lista=null;
		try {
			lista = new ArrayList<BOGrupo>();
		    lista = transformar.toBO(mGrupo.listarGrupos(idModulo));
		} catch (DataAccessException dae) {
			throw dae;
		} catch (Exception e) {
			throw new BusinessLogicException(Constantes.ERROR_LOGICA_NEGOCIO_OTRO, e);
		}
		return lista;
	}
}
