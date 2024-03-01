package es.etg.daw.prog.stream.model;

import java.util.Comparator;

/**
 * Comparable define un orden natural -> compareTo(o)
 * Comparator ordenación secundaria, se comparan dos objetos. compare(o, o)
 */
public class Alumno implements Comparator<Alumno>,
                         Comparable<Alumno>{
    
    private String nombre;
    private String apellidos;
    private String dni;
    
    public Alumno(String nombre, String apellidos, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    @Override
    public int compareTo(Alumno o) {
        return nombre.compareTo(o.nombre);
    }
    @Override
    public int compare(Alumno al1, Alumno al2) {
        return al1.getNombre().compareTo(al2.getNombre());
    }

}
