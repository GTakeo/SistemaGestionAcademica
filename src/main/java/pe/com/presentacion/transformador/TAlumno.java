package pe.com.presentacion.transformador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.negocio.bo.BOAlumno;
import pe.com.presentacion.form.FAlumno;
import pe.com.util.transformador.TransformadorBOForm;

@Component("tAlumnoBOForm")
public class TAlumno implements TransformadorBOForm<BOAlumno, FAlumno> {

	@Override
	public FAlumno toForm(BOAlumno input) {
		FAlumno falumno = null;
		if (input != null) {
			falumno = new FAlumno();
			falumno.setId(input.getId());
			falumno.setNombre(input.getNombre());
			falumno.setApellido(input.getApellido());
			falumno.setDireccion(input.getDireccion());
			falumno.setTelefono(input.getTelefono());
			falumno.setCelular(input.getCelular());
			falumno.setFechaNacimiento(input.getFechaNacimiento());
			falumno.setDni(input.getDni());
			falumno.setCorreo(input.getCorreo());
		}
		return falumno;
	}

	@Override
	public List<FAlumno> toForm(List<BOAlumno> lista) {
		List<FAlumno> listaFAlumno = new ArrayList<FAlumno>();
		for (BOAlumno boAlumno : lista) {
			listaFAlumno.add(toForm(boAlumno));
		}
		return listaFAlumno;
	}

	@Override
	public BOAlumno toBO(FAlumno input) {
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

}
