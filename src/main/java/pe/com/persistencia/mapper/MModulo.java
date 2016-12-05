package pe.com.persistencia.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.negocio.bo.BOModulo;
import pe.com.persistencia.entity.BModulo;

@Transactional(propagation = Propagation.MANDATORY)
public interface MModulo {
	@ResultMap("bModulo")
	@Select("SELECT ID_MOD,MOD_CODIGO,MOD_NOMBRE,MOD_DURACION FROM MODULO WHERE FK_MOD_PRO = #{idPrograma}")
	List<BModulo> obtenerModulosPorPrograma(@Param("idPrograma") Integer id);

	@Select("INSERT INTO MODULO(FK_MOD_PRO,MOD_CODIGO,MOD_NOMBRE,MOD_DURACION) VALUES (#{idPro},#{codigo},#{nombre},#{duracion})")
	void agregarModulo(BOModulo boModulo);
	
	@Select("SELECT MAX(ID_MOD) FROM MODULO")
	public Integer obtenerUltimoId();

	
	@ResultMap("bModulo")
	@Select("SELECT ID_MOD, FK_MOD_PRO, MOD_CODIGO, MOD_NOMBRE, MOD_DURACION FROM MODULO WHERE FK_MOD_PRO = #{idPrograma}")
	public List<BModulo> listarModulos(@Param("idPrograma") Integer idPrograma);
	
}
