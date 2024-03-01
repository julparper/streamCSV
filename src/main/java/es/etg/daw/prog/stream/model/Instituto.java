package es.etg.daw.prog.stream.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Instituto implements Matriculable{
    
    private List<Alumno> alumnos = new ArrayList<>();

    /**
     * Devuelve la lista ordenada por nombre ascendente
     * @return lista de alumnos ordenada de forma ascendente por nombre
     */
    public List<Alumno> getAlumnos() {
        Collections.sort(alumnos);
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
