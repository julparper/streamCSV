package es.etg.daw.prog.stream.model.comparador;

import java.util.Comparator;

import es.etg.daw.prog.stream.model.Alumno;

public class ApellidoComparator implements Comparator<Alumno>{

    @Override
    public int compare(Alumno arg0, Alumno arg1) {
        return arg0.getApellidos().compareTo(arg1.getApellidos());
    }
    
}
