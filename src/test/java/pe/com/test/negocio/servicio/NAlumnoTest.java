package pe.com.test.negocio.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.negocio.bo.BOAlumno;
import pe.com.negocio.servicio.NAlumno;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class NAlumnoTest {

	@Autowired
	NAlumno nAlumno;

	BOAlumno Alumno;

	@Before
	public void prepararPrueba() {
		Alumno = new BOAlumno();
	}

	@Test
	public void listarAlumnoTest() {
		try {
			List<BOAlumno> listaEmpelados = nAlumno.listarAlumnos();
			for (BOAlumno bAlumnos : listaEmpelados) {
				System.out.println(bAlumnos);
			}
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		} catch (BusinessLogicException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void insertarAlumnoTest() {
		String nombreAlumno = "Brayan";
		String cargoAlumno = "Programador";
		Alumno.setNombre(nombreAlumno);
		try {
			nAlumno.insertarAlumno(Alumno);
			BOAlumno emp = new BOAlumno();
			emp = nAlumno.obtenerAlumnoXNombre(nombreAlumno);
			assertEquals(nombreAlumno, emp.getNombre());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		} catch (BusinessLogicException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// @Test
	public void obtenerAlumnoXIdTest() {
		Integer id = 41;
		try {
			BOAlumno Alumno = nAlumno.obtenerAlumnoXId(id);
			if (Alumno == null) {
				fail("No existe la categoría IFI");
			} else {
				assertEquals("BRAYAN", Alumno.getNombre());
				System.out.println(Alumno);
			}
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		} catch (BusinessLogicException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void obtenerAlumnoXNombreTest() {
		Integer idCategoria = 41;
		String nombreAlumno = "BRAYAN";
		String cargoAlumno = "PROGRAMADOR";
		try {
			BOAlumno emp = nAlumno.obtenerAlumnoXNombre(nombreAlumno);
			if (emp == null) {
				fail("No se encontró categoría IFI");
			} else {
				assertEquals(idCategoria.intValue(), emp.getId().intValue());
				assertEquals(nombreAlumno, emp.getNombre());
				System.out.println(emp);
			}
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		} catch (BusinessLogicException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void modificarAlumnoTest() {
		Integer idCategoria = 1;
		String nombreAlumno = "GUSTAVO";
		String cargoAlumno = "PROGRAMADOR";
		Alumno.setId(idCategoria);
		Alumno.setNombre(nombreAlumno);
		try {
			nAlumno.modificarAlumno(Alumno);
			BOAlumno emp = nAlumno.obtenerAlumnoXNombre(nombreAlumno);
			assertEquals(idCategoria, emp.getId());
			assertEquals(nombreAlumno, emp.getNombre());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		} catch (BusinessLogicException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void eliminarAlumnoTest() {
		Integer id = 1;
		String nombreAlumno = "GUSTAVO";
		try {
			nAlumno.eliminarAlumno(id);
			BOAlumno emp = nAlumno.obtenerAlumnoXNombre(nombreAlumno);
			assertNull(emp);
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		} catch (BusinessLogicException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
