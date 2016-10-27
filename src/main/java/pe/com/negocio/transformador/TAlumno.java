package pe.com.negocio.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOAlumno;
import pe.com.persistencia.entity.BAlumno;
import pe.com.util.transformador.TransformadorEntityBO;

@Component("tAlumnoEntityBO")
public class TAlumno implements TransformadorEntityBO<BAlumno, BOAlumno> {
	
	@Override
	public BOAlumno toBO(BAlumno input) {
		BOAlumno boAlumno = null;
		if (input != null) {
			boAlumno = new BOAlumno();
			boAlumno.setId(input.getId());
			boAlumno.setNombre(input.getNombre());
			boAlumno.setApellido(input.getApellido());
			boAlumno.setDireccion(input.getDireccion());
			boAlumno.setTelefono(input.getTelefono());
			boAlumno.setCelular(input.getCelular());
			boAlumno.setFechaNacimiento(input.getFechaNacimiento());
			boAlumno.setDni(input.getDni());
			boAlumno.setCorreo(input.getCorreo());
		}
		return boAlumno;
	}

	@Override
	public List<BOAlumno> toBO(List<BAlumno> lista) {
		List<BOAlumno> listaBOAlumno = new ArrayList<BOAlumno>();
		for (BAlumno bAlumno : lista) {
			listaBOAlumno.add(toBO(bAlumno));
		}
		return listaBOAlumno;
	}

	@Override
	public BAlumno toEntity(BOAlumno input) {
		BAlumno bAlumno = null;
		if (input != null) {
			bAlumno = new BAlumno();
			bAlumno.setId(input.getId());
			bAlumno.setNombre(input.getNombre());
			bAlumno.setApellido(input.getApellido());
			bAlumno.setDireccion(input.getDireccion());
			bAlumno.setTelefono(input.getTelefono());
			bAlumno.setCelular(input.getCelular());
			bAlumno.setFechaNacimiento(input.getFechaNacimiento());
			bAlumno.setDni(input.getDni());
			bAlumno.setCorreo(input.getCorreo());
		}
		return bAlumno;
	}

}
