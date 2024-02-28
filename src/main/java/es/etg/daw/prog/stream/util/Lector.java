package es.etg.daw.prog.stream.util;

import es.etg.daw.prog.stream.model.Alumno;
import java.util.List;


public abstract class Lector {
    
    public abstract List<Alumno> leer(String codigo);
}
