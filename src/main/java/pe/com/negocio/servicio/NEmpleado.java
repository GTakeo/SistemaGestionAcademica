package pe.com.negocio.servicio;

import java.util.List;

import pe.com.negocio.bo.BOEmpleado;

public interface NEmpleado {

	public List<BOEmpleado> listarEmpleados();

	public BOEmpleado obtenerEmpleadoXId(Integer id);

	public BOEmpleado obtenerEmpleadoXNombre(String nombreEmpleado);

	public void insertarEmpleado(BOEmpleado empleado);

	public void modificarEmpleado(BOEmpleado categoriaIFI);

	public void eliminarEmpleado(Integer idCategoria);

}
