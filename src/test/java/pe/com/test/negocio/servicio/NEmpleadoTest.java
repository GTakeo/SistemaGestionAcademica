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

import pe.com.negocio.bo.BOEmpleado;
import pe.com.negocio.servicio.NEmpleado;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class NEmpleadoTest {

	@Autowired
	NEmpleado nEmpleado;

	BOEmpleado empleado;

	@Before
	public void prepararPrueba() {
		empleado = new BOEmpleado();
	}

	@Test
	public void listarEmpleadoTest() {
		try {
			List<BOEmpleado> listaEmpelados = nEmpleado.listarEmpleados();
			for (BOEmpleado bEmpleados : listaEmpelados) {
				System.out.println(bEmpleados);
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
	public void insertarEmpleadoTest() {
		String nombreEmpleado = "Brayan";
		String cargoEmpleado = "Programador";
		empleado.setNombre(nombreEmpleado);
		empleado.setCargo(cargoEmpleado);
		try {
			nEmpleado.insertarEmpleado(empleado);
			BOEmpleado emp = new BOEmpleado();
			emp = nEmpleado.obtenerEmpleadoXNombre(nombreEmpleado);
			assertEquals(nombreEmpleado, emp.getNombre());
			assertEquals(cargoEmpleado, emp.getCargo());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		} catch (BusinessLogicException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// @Test
	public void obtenerEmpleadoXIdTest() {
		Integer id = 41;
		try {
			BOEmpleado empleado = nEmpleado.obtenerEmpleadoXId(id);
			if (empleado == null) {
				fail("No existe la categoría IFI");
			} else {
				assertEquals("BRAYAN", empleado.getNombre());
				assertEquals("PROGRAMADOR", empleado.getCargo());
				System.out.println(empleado);
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
	public void obtenerEmpleadoXNombreTest() {
		Integer idCategoria = 41;
		String nombreEmpleado = "BRAYAN";
		String cargoEmpleado = "PROGRAMADOR";
		try {
			BOEmpleado emp = nEmpleado.obtenerEmpleadoXNombre(nombreEmpleado);
			if (emp == null) {
				fail("No se encontró categoría IFI");
			} else {
				assertEquals(idCategoria.intValue(), emp.getId().intValue());
				assertEquals(nombreEmpleado, emp.getNombre());
				assertEquals(cargoEmpleado, emp.getCargo());
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
	public void modificarEmpleadoTest() {
		Integer idCategoria = 1;
		String nombreEmpleado = "GUSTAVO";
		String cargoEmpleado = "PROGRAMADOR";
		empleado.setId(idCategoria);
		empleado.setNombre(nombreEmpleado);
		empleado.setCargo(cargoEmpleado);
		try {
			nEmpleado.modificarEmpleado(empleado);
			BOEmpleado emp = nEmpleado.obtenerEmpleadoXNombre(nombreEmpleado);
			assertEquals(idCategoria, emp.getId());
			assertEquals(nombreEmpleado, emp.getNombre());
			assertEquals(cargoEmpleado, emp.getCargo());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		} catch (BusinessLogicException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// @Test
	public void eliminarEmpleadoTest() {
		Integer id = 1;
		String nombreEmpleado = "GUSTAVO";
		try {
			nEmpleado.eliminarEmpleado(id);
			BOEmpleado emp = nEmpleado.obtenerEmpleadoXNombre(nombreEmpleado);
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
