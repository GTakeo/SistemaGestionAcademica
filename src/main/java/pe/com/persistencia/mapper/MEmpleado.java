package pe.com.persistencia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.persistencia.entity.BEmpleado;

@Transactional(propagation = Propagation.MANDATORY)
public interface MEmpleado {

	@ResultMap("bEmpleado")
	@Select("SELECT ID_EMPLEADO, NOMBRE_EMPLEADO, CARGO_EMPLEADO FROM EMPLEADO ORDER BY NOMBRE_EMPLEADO ASC")
	public List<BEmpleado> listarEmpleados();

	@ResultMap("bEmpleado")
	@Select("SELECT ID_EMPLEADO, NOMBRE_EMPLEADO, CARGO_EMPLEADO FROM EMPLEADO " + "WHERE ID_EMPLEADO = #{id}")
	public BEmpleado obtenerEmpleadoXId(@Param("id") Integer id);

	@ResultMap("bEmpleado")
	@Select("SELECT ID_EMPLEADO, NOMBRE_EMPLEADO, CARGO_EMPLEADO FROM EMPLEADO "
			+ "WHERE NOMBRE_EMPLEADO = #{nombreEmpleado}")
	public BEmpleado obtenerEmpleadoXNombre(@Param("nombreEmpleado") String nombreEmpleado);

	@Insert("INSERT INTO EMPLEADO (NOMBRE_EMPLEADO, CARGO_EMPLEADO) " + "values (#{nombre}, #{cargo})")
	public int insertarEmpleado(BEmpleado empleado);

	@Update("UPDATE EMPLEADO SET NOMBRE_EMPLEADO = #{nombre}, CARGO_EMPLEADO = #{cargo} "
			+ "	WHERE ID_EMPLEADO = #{id}")
	public int modificarEmpleado(BEmpleado empleado);

	@Delete("DELETE FROM EMPLEADO WHERE ID_EMPLEADO = #{id}")
	public int eliminarEmpleado(@Param("id") Integer idEmpleado);

}
