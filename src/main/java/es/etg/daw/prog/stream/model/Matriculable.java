package es.etg.daw.prog.stream.model;

import java.util.List;

public interface Matriculable {
    
    public void matricular(Alumno a) ;
    public void matricular(List<Alumno> l);
}
