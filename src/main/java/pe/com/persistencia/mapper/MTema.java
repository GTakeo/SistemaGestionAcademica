package pe.com.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.persistencia.entity.BTema;

@Transactional(propagation = Propagation.MANDATORY)
public interface MTema {
	
	@Insert("INSERT INTO TEMA(FK_TEM_CUR,TEM_NOMBRE,TEM_DURACION) VALUES (#{idCurso},#{nombre},#{duracion})")
	void agregarTema(BTema entity);

	@Delete("DELETE FROM TEMA WHERE FK_TEM_CUR = #{idCurso}")
	public int eliminarTemaXIdCurso(@Param("idCurso") Integer idCurso);
	
	@ResultMap("bTema")
	@Select("SELECT TEMA.ID_TEM, TEMA.FK_TEM_CUR, TEMA.TEM_NOMBRE, TEMA.TEM_DURACION FROM GRUPO, CURSO, TEMA WHERE TEMA.FK_TEM_CUR=CURSO.ID_CUR AND CURSO.ID_CUR=GRUPO.FK_GRU_CUR AND GRUPO.ID_GRU=#{idGrupo}")
	public List<BTema> listarTemaXIdGrupo(@Param("idGrupo")Integer idGrupo);
}
