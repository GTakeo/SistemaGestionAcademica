package pe.com.test.negocio.servicio;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class ObtenerContrasena {

	public static void main(String[] args) {
		System.out.println("Contraseña Encriptada: "+ BCrypt.hashpw("202020k123", BCrypt.gensalt(11)));

	}

}
