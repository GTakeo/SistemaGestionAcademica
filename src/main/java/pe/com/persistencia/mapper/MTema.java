package pe.com.persistencia.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.persistencia.entity.BTema;

@Transactional(propagation = Propagation.MANDATORY)
public interface MTema {
	
	@Insert("INSERT INTO TEMA(FK_TEM_CUR,TEM_NOMBRE,TEM_DURACION) VALUES (#{idCurso},#{nombre},#{duracion})")
	void agregarTema(BTema entity);

	@Delete("DELETE FROM TEMA WHERE FK_TEM_CUR = #{idCurso}")
	public int eliminarTemaXIdCurso(@Param("idCurso") Integer idCurso);
}
