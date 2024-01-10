package Domain.Validacion;

import java.util.Set;

public class Validador{

    public boolean validar(String unTexto, Set<Validacion> unCriterio){

        return unCriterio.stream().map(unaValidacion -> unaValidacion.validar(unTexto)).allMatch(valores -> valores == true);

    }

}
