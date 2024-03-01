package es.etg.daw.prog.stream.util;

import es.etg.daw.prog.stream.exception.LectorException;
import es.etg.daw.prog.stream.model.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



/**
 * Procesa ficheros en formato Json y los convierte en 
 * Alumnos.
 * 
 */
public class LectorJSON extends Lector{

    @Override
    /**
     * Este método procesa una fila en CSV, el primer valor es el
     * nombre, el segundo el apellido y el tercero el dni.
     * @param fila Es un String con los datos de un alumno separados por coma
     * @return Un objeto de tipo Alumno con los datos leídos de la fila.
     */
    public List<Alumno> leer(String codigo) throws LectorException {

        List<Alumno> alumnos = new ArrayList<>();

        //Comprobamos que la cadena tiene contenido, si no devuelve una excepción.
        comprobar(codigo);

        StringTokenizer st = new StringTokenizer(codigo, "{}",true);
        while(st.hasMoreTokens()){
            String token = st.nextToken();

            if(token.equals("{")){
                //Leo el siguiente que tendrá todos los datos a procesar (fila)
                token = st.nextToken();
                alumnos.add(procesar(token));
            }
        }

        return alumnos;
    }

    private void comprobar(String cadena) throws LectorException{

        if(cadena == null || cadena.trim().length()==0)
            throw new LectorException();

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

        nombre = procesarValor(st.nextToken());
        apellido = procesarValor(st.nextToken());
        dni = procesarValor(st.nextToken());

        return new Alumno(nombre, apellido, dni);

    }

    /**
     * Dada una pareja de clave valor, devuelve el valor. Formato "CAMPO": "valor".
     * @param pareja
     */
    private String procesarValor(String pareja){
        String valor = null;

        pareja = pareja.trim();//Quito los blancos

        StringTokenizer st = new StringTokenizer(pareja, ":");

        //Leo el valor del campo y lo ignoro:
        st.nextToken();

        //el siguiente campo tiene el valor, lo leo y le quito las comillas:
        valor = st.nextToken().trim();
        valor = valor.substring(1,valor.length()-1);

        return valor;
    }
    
}
