package es.etg.daw.prog.stream.model;

import java.util.ArrayList;
import java.util.List;

public class Instituto implements Matriculable{
    
    private List<Alumno> alumnos = new ArrayList<>();

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public void matricular(Alumno a) {
        alumnos.add(a);
    }

    @Override
    public void matricular(List<Alumno> l) {
        alumnos.addAll(l);
    }



}
