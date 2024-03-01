
package es.etg.daw.prog.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.stream.model.Alumno;
import es.etg.daw.prog.stream.model.Instituto;
import es.etg.daw.prog.stream.util.Lector;
import es.etg.daw.prog.stream.util.LectorCSV;

/**
 * LectorTest
 */
public class LectorCSVTest {

    private static final String cadena = "Nombre,Apellidos,DNI\n" + //
                                        "Julián,Parra,1a\n" + //
                                        "Ana,García,2b\n" + //
                                        "Pedro,López,2c\n" + //
                                        "Laura,Gómez,4d\n" + //
                                        "";
    private static Instituto instituto;

    
    
    @BeforeAll
    public static void cargarFicheroCSV(){
        
        Lector lector = new LectorCSV();
        instituto = new Instituto();

        instituto.matricular(lector.leer(cadena));

        
    }

    @Test
    public void comprobarInstitutoTest(){

        int regEsperados = 4;
        

        List<Alumno> alumnos = instituto.getAlumnos();

        //Comprobamos que se han leído 4 registros
        assertEquals(regEsperados, alumnos.size());

        //Comprobamos que está ordenado por nombre
        assertEquals("Ana", alumnos.get(0).getNombre());
        assertEquals("Julián", alumnos.get(1).getNombre());
        assertEquals("Laura", alumnos.get(2).getNombre());
        assertEquals("Pedro", alumnos.get(3).getNombre());
    }
}