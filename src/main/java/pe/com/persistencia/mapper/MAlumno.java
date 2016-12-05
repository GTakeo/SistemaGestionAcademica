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

import pe.com.persistencia.entity.BAlumno;

@Transactional(propagation = Propagation.MANDATORY)
public interface MAlumno {

	@ResultMap("bAlumno")
	@Select("SELECT ID_ALU ,ALU_NOMBRE ,ALU_APELLIDO ,ALU_DIRECCION ,ALU_TELEFONO ,ALU_CELULAR ,ALU_FEC_NAC ,ALU_DNI ,ALU_CORREO  FROM ALUMNO ORDER BY ALU_APELLIDO ASC")
	public List<BAlumno> listarAlumnos();

	@ResultMap("bAlumno")
	@Select("SELECT ID_ALU ,ALU_NOMBRE ,ALU_APELLIDO ,ALU_DIRECCION ,ALU_TELEFONO ,ALU_CELULAR ,ALU_FEC_NAC ,ALU_DNI ,ALU_CORREO  FROM ALUMNO "
			+ "WHERE ID_ALU = #{id}")
	public BAlumno obtenerAlumnoXId(@Param("id") Integer id);

	@ResultMap("bAlumno")
	@Select("SELECT ID_ALU ,ALU_NOMBRE ,ALU_APELLIDO ,ALU_DIRECCION ,ALU_TELEFONO ,ALU_CELULAR ,ALU_FEC_NAC ,ALU_DNI ,ALU_CORREO  FROM ALUMNO  "
			+ "WHERE ALU_NOMBRE = #{nombreAlumno}")
	public BAlumno obtenerAlumnoXNombre(@Param("nombreAlumno") String nombreAlumno);

	@Insert("INSERT INTO ALUMNO (ALU_NOMBRE ,ALU_APELLIDO ,ALU_DIRECCION ,ALU_TELEFONO ,ALU_CELULAR ,ALU_FEC_NAC ,ALU_DNI ,ALU_CORREO) "
			+ "values (#{nombre}, #{apellido}, #{direccion}, #{telefono}, #{celular}, #{fechaNacimiento}, #{dni},#{correo} )")
	public int insertarAlumno(BAlumno Alumno);

	@Update("UPDATE ALUMNO SET ALU_NOMBRE = #{nombre}, ALU_APELLIDO = #{apellido}, ALU_DIRECCION = #{direccion}, ALU_TELEFONO = #{telefono}, ALU_CELULAR = #{celular}, ALU_FEC_NAC = #{fechaNacimiento}, ALU_DNI = #{dni}, ALU_CORREO = #{correo} "
			+ "	WHERE ID_ALU = #{id}")
	public int modificarAlumno(BAlumno Alumno);

	@Delete("DELETE FROM ALUMNO WHERE ID_ALU = #{id}")
	public int eliminarAlumno(@Param("id") Integer idAlumno);
	
	@Select("INSERT INTO MATRICULA (FK_MTR_ALU,FK_MTR_GRU,MTR_NOTA) VALUES (#{idAlumno},#{idGrupo},#{nota})")
	public void matricularAlumno(@Param("idAlumno") Integer idAlumno,@Param("idGrupo") Integer idGrupo,@Param("nota") Integer nota);
}
