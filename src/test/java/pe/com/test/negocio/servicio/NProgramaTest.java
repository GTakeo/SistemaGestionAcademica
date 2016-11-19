package pe.com.test.negocio.servicio;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.negocio.bo.BOPrograma;
import pe.com.negocio.servicio.NPrograma;
import pe.com.util.excepcion.BusinessLogicException;
import pe.com.util.excepcion.DataAccessException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class NProgramaTest {

	@Autowired
	NPrograma nPrograma;

	BOPrograma boPrograma;

	@Before
	public void prepararPrueba() {
		boPrograma = new BOPrograma();
	}

	@Test
	public void listarAlumnoTest() {
		try {
			List<BOPrograma> listaPrograma;
			listaPrograma= null;
			listaPrograma=nPrograma.ListarProgramas();
			if(listaPrograma!=null){
				for(BOPrograma boPrograma :listaPrograma){
					System.out.println(boPrograma);
				}
			}
			
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		} catch (BusinessLogicException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
