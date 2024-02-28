package es.etg.daw.prog.stream.util;

import es.etg.daw.prog.stream.model.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class LectorCSV extends Lector{

    @Override
    public List<Alumno> leer(String codigo) {
        boolean primeraFila = true;
        List<Alumno> alumnos = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(codigo, "\n");
        while(st.hasMoreTokens()){
            String fila = st.nextToken();

            if(!primeraFila && !"".equals(fila))
                alumnos.add(procesar(fila));

            primeraFila = false;
        }

        return alumnos;
    }

    private Alumno procesar(String fila){
        String nombre;
        String apellido;
        String dni;

        StringTokenizer st = new StringTokenizer(fila, ",");

        nombre = st.nextToken();
        apellido = st.nextToken();
        dni = st.nextToken();

        return new Alumno(nombre, apellido, dni);

    }
    
}
