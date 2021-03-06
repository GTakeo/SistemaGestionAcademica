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
	@Select("INSERT INTO GRUPO (FK_GRU_CUR,GRU_CODIGO,GRU_NOMBRE,GRU_VACANTES,GRU_INSCRITOS) VALUES(#{idCurso},#{codigo},#{nombre},#{vacantes},#{inscritos})")
	public void agregarGrupo(BGrupo bGrupo);

	@ResultMap("bGrupo")
	@Select("SELECT ID_GRU,  FK_GRU_CUR,  GRU_CODIGO,  GRU_NOMBRE,  GRU_VACANTES,  GRU_INSCRITOS FROM GRUPO WHERE FK_GRU_CUR=#{idCurso}  ")
	public List<BGrupo> listarGruposXIdCurso(@Param("idCurso")Integer idCurso);
	

}
