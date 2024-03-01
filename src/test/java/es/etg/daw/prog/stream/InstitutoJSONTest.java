
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
import es.etg.daw.prog.stream.util.LectorJSON;

/**
 * LectorTest
 */
public class InstitutoJSONTest {

    private static final String cadena = "[\n" + //
                                        "    {\n" + //
                                        "      \"Nombre\": \"Julián\",\n" + //
                                        "      \"Apellidos\": \"Parra\",\n" + //
                                        "      \"DNI\": \"1a\"\n" + //
                                        "    },\n" + //
                                        "    {\n" + //
                                        "      \"Nombre\": \"Ana\",\n" + //
                                        "      \"Apellidos\": \"García\",\n" + //
                                        "      \"DNI\": \"2b\"\n" + //
                                        "    },\n" + //
                                        "    {\n" + //
                                        "      \"Nombre\": \"Pedro\",\n" + //
                                        "      \"Apellidos\": \"López\",\n" + //
                                        "      \"DNI\": \"2c\"\n" + //
                                        "    },\n" + //
                                        "    {\n" + //
                                        "      \"Nombre\": \"Laura\",\n" + //
                                        "      \"Apellidos\": \"Gómez\",\n" + //
                                        "      \"DNI\": \"4d\"\n" + //
                                        "    }\n" + //
                                        "  ]";
    private static Instituto instituto;

    
    
    @BeforeAll
    public static void cargarFicheroJSON() throws Exception{
        
        Lector lector = new LectorJSON();
        instituto = new Instituto();

        instituto.matricular(lector.leer(cadena));

        
    }

    @Test 
    public void cargarCadenaVaciaTest(){
        String cadena = "";
        Lector lector = new LectorJSON();

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