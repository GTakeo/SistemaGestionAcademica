package pe.com.persistencia.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.persistencia.entity.BTema;

@Transactional(propagation = Propagation.MANDATORY)
public interface MTema {
	
	@Insert("INSERT INTO TEMA(FK_TEM_CUR,TEM_NOMBRE,TEM_DURACION) VALUES (#{idCurso},#{nombre},#{duracion})")
	void agregarTema(BTema entity);

}
