
package es.etg.daw.prog.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import es.etg.daw.prog.stream.exception.LectorException;
import es.etg.daw.prog.stream.model.Alumno;
import es.etg.daw.prog.stream.model.Instituto;
import es.etg.daw.prog.stream.model.comparador.ApellidoComparator;
import es.etg.daw.prog.stream.model.comparador.DniComparator;
import es.etg.daw.prog.stream.util.Lector;
import es.etg.daw.prog.stream.util.LectorCSV;

/**
 * LectorTest
 */
public class InstitutoCSVTest {

    private static final String cadena = "Nombre,Apellidos,DNI\n" + //
                                        "Julián,Parra,1a\n" + //
                                        "Ana,García,2b\n" + //
                                        "Pedro,López,2c\n" + //
                                        "Laura,Gómez,4d\n" + //
                                        "";
    private static Instituto instituto;

    
    
    @BeforeAll
    public static void cargarFicheroCSV() throws Exception{
        
        Lector lector = new LectorCSV();
        instituto = new Instituto();

        instituto.matricular(lector.leer(cadena));

        
    }

    @Test 
    public void cargarCadenaVaciaTest(){
        String cadena = "";
        Lector lector = new LectorCSV();

        LectorException thorwn = Assertions.assertThrows(LectorException.class, () -> {
            lector.leer(cadena);
        });

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

    @Test
    public void comprobarInstOrdApellidoTest(){

        int regEsperados = 4;
        

        List<Alumno> alumnos = instituto.getAlumnos();
        Collections.sort(alumnos, new ApellidoComparator());

        //Comprobamos que se han leído 4 registros
        assertEquals(regEsperados, alumnos.size());

        //Comprobamos que está ordenado por nombre
        assertEquals("Ana", alumnos.get(0).getNombre());
        assertEquals("Laura", alumnos.get(1).getNombre());
        assertEquals("Pedro", alumnos.get(2).getNombre());
        assertEquals("Julián", alumnos.get(3).getNombre());
    }

    @Test
    public void comprobarInstOrdDniTest(){

        int regEsperados = 4;
        

        List<Alumno> alumnos = instituto.getAlumnos();
        Collections.sort(alumnos, new DniComparator());

        //Comprobamos que se han leído 4 registros
        assertEquals(regEsperados, alumnos.size());

        //Comprobamos que está ordenado por nombre
        assertEquals("Julián", alumnos.get(0).getNombre());
        assertEquals("Ana", alumnos.get(1).getNombre());
        assertEquals("Pedro", alumnos.get(2).getNombre());
        assertEquals("Laura", alumnos.get(3).getNombre());
    }
}