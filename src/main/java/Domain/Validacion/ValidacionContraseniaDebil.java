package Domain.Validacion;

import Domain.Excepcion.ValidacionContraseniaException;

import java.io.*;
// import java.net.URL;

/**
 * Valida que la contrasenia contra un archivo txt de contrasenias débiles
 */
public class ValidacionContraseniaDebil implements Validacion {
	File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;

	@Override
	public boolean validar(String contrasenia) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			String pathClaves = System.getProperty("user.dir");

			archivo = new File(pathClaves + "/src/main/java/claves/contrasenias.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			String linea;
			while ((linea = br.readLine()) != null) {
				if (linea.equals(contrasenia)) {
					return false;
//					throw new Exception("La clave: "+contrasenia+" es una clave débil");
				}
			}
			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidacionContraseniaException(e.getMessage());
		}

		return true;
	}
}

