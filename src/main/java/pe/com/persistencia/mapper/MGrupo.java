package pe.com.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.persistencia.entity.BGrupo;

@Transactional(propagation = Propagation.MANDATORY)
public interface MGrupo {

	@ResultMap("bGrupo")
	@Select("INSERT INTO GRUPO (FK_GRU_MOD,GRU_CODIGO,GRU_NOMBRE,GRU_VACANTES,GRU_INSCRITOS,GRU_FINICIO) VALUES(#{idModulo},#{codigo},#{nombre},#{vacantes},#{inscritos},#{fechaInicio})")
	public void agregarGrupo(BGrupo bGrupo);

	@ResultMap("bGrupo")
	@Select("SELECT ID_GRU,  FK_GRU_MOD,  GRU_CODIGO,  GRU_NOMBRE,  GRU_VACANTES,  GRU_INSCRITOS,  GRU_FINICIO FROM GRUPO WHERE FK_GRU_MOD=#{id}  ")
	public List<BGrupo> listarGrupos(@Param("id")Integer idModulo);
	

}
