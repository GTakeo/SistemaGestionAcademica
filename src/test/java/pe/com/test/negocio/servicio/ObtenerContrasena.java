package pe.com.test.negocio.servicio;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class ObtenerContrasena {

	public static void main(String[] args) {
		System.out.println("Contraseña Encriptada: "+ BCrypt.hashpw("202020k123", BCrypt.gensalt(11)));

		String primerNombre = "GUSTAVO";
		//Primera letra en mayuscula y las demas en minuscula
		primerNombre = primerNombre.substring(0, 1).toUpperCase() + primerNombre.substring(1).toLowerCase();
		
		System.out.println("Nombre: "+primerNombre);
	}

}
