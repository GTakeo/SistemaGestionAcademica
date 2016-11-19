package pe.com.persistencia.mapper;


import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.persistencia.entity.BPrograma;

@Transactional(propagation = Propagation.MANDATORY)
public interface MPrograma {

	@ResultMap("bPrograma")
	@Select("SELECT ID_PRO,PRO_CODIGO,PRO_NOMBRE,PRO_DURACION FROM PROGRAMA ORDER BY PRO_NOMBRE")
	public List<BPrograma> listarProgramas();
}
