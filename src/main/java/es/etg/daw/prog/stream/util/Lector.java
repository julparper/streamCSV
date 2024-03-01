package es.etg.daw.prog.stream.util;

import es.etg.daw.prog.stream.exception.LectorException;
import es.etg.daw.prog.stream.model.Alumno;
import java.util.List;


/**
 * Gestiona ficheros con datos y los pasa a Alumno.
 * @author Julián
 */
public abstract class Lector {
    
    public abstract List<Alumno> leer(String codigo) throws LectorException;
}
