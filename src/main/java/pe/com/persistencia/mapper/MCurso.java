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
	@Select("SELECT ID_CUR ,CUR_CODIGO ,CUR_NOMBRE ,CUR_DURACION ,CUR_FINICIO ,CUR_FTERMINO	 FROM CURSO ORDER BY CUR_CODIGO ASC")
	public List<BCurso> listarCursos();

	@Delete("DELETE FROM CURSO WHERE ID_CUR = #{id}")
	public void eliminarCurso(@Param("id")Integer id);

	@Insert("INSERT INTO CURSO(CUR_CODIGO,CUR_NOMBRE,CUR_DURACION,CUR_FINICIO,CUR_FTERMINO) VALUES(#{codigo},#{nombre},#{duracion},#{fechaInicio},#{fechaTermino})")
	public void agregarCurso(BCurso entity);

	@ResultMap("bCurso")
	@Select("SELECT ID_CUR ,CUR_CODIGO ,CUR_NOMBRE FROM CURSO , DETALLEMODULO WHERE DETALLEMODULO.FK_DTM_MOD=#{idModulo} AND DETALLEMODULO.FK_DTM_CUR=CURSO.ID_CUR ")
	public List<BCurso> listarCursoXIdModulo(@Param("idModulo")Integer idModulo);

	@Select("SELECT CUR.CUR_NOMBRE FROM GRUPO GRU, CURSO CUR WHERE GRU.FK_GRU_CUR=CUR.ID_CUR AND GRU.GRU_CODIGO = #{codGrupo} ")
	public String obtenerNombreCursoXCodGrupo(@Param("codGrupo")String codGrupo);

}



