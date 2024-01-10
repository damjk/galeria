package APIs.Entidades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import APIs.APIRefugio.Servicie.ServicioRefugio;

public class Consola {

	public static void main(String[] args) throws IOException {
		ServicioRefugio servicioRefugio = ServicioRefugio.instancia();
		List<Refugio> hogaresAll = new ArrayList<>();
		RefugiosApi listado = servicioRefugio.listadoDeHogares(1);
		int cantidadPagina = 4;
		int x;
		System.out.println(listado);
		/*
		for (x = 1; x <= cantidadPagina; x++) {

			RefugiosApi listado = servicioRefugio.listadoDeHogares(x);

			listado.ListaRefugios();
			System.out.print("CantidadHogares : ");
			System.out.println(listado.getTotal());
			System.out.print("Pagina : ");
			System.out.println(listado.getOffset());
			int k;
			List<Refugio> hogares = listado.ListaRefugios();
			for (k = 0; k < hogares.size(); k++) {

				//System.out.println(hogares.get(k).getId());
				System.out.println(hogares.get(k).nombre);
			}

		}
		/*
		 * int i; for (i = 0; i < hogaresAll.size(); i++) {
		 * System.out.println(hogaresAll.get(i).getId());
		 * 
		 */

	}
}
