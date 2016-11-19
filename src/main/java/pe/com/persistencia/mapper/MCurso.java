package pe.com.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.persistencia.entity.BCurso;

@Transactional(propagation = Propagation.MANDATORY)
public interface MCurso {

	
	@ResultMap("bCurso")
	@Select("SELECT ID_CUR ,CUR_CODIGO ,CUR_NOMBRE FROM CURSO ORDER BY CUR_CODIGO ASC")
	public List<BCurso> listarCursos();

	@Delete("DELETE FROM CURSO WHERE ID_CUR = #{id}")
	public void eliminarCurso(@Param("id")Integer id);

	@Insert("INSERT INTO CURSO(CUR_CODIGO,CUR_NOMBRE) VALUES(#{codigo},#{nombre})")
	public void agregarCurso(BCurso entity);

}
