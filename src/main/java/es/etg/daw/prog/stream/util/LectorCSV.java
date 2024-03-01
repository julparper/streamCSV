package es.etg.daw.prog.stream.util;

import es.etg.daw.prog.stream.model.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



/**
 * Procesa ficheros en formato CSV y los convierte en 
 * Alumnos.
 * 
 */
public class LectorCSV extends Lector{

    @Override
    /**
     * Este método procesa una fila en CSV, el primer valor es el
     * nombre, el segundo el apellido y el tercero el dni.
     * @param fila Es un String con los datos de un alumno separados por coma
     * @return Un objeto de tipo Alumno con los datos leídos de la fila.
     */
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

    /**
     * Este método procesa una fila en CSV, el primer valor es el
     * nombre, el segundo el apellido y el tercero el dni.
     * @param fila Es un String con los datos de un alumno separados por coma
     * @return Un objeto de tipo Alumno con los datos leídos de la fila.
     */
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
