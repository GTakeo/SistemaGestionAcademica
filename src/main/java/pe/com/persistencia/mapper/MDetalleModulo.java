package pe.com.persistencia.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.MANDATORY)
public interface MDetalleModulo {

	@Insert("INSERT INTO DETALLEMODULO(FK_DTM_CUR,FK_DTM_MOD) VALUES(#{idCurso},#{idModulo})")
	public void agregarDetalleModulo(@Param("idModulo")Integer idModulo,@Param("idCurso")Integer idCurso);

}
