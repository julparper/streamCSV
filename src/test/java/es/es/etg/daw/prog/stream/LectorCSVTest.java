package es.es.etg.daw.prog.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import es.etg.daw.prog.stream.model.Alumno;
import es.etg.daw.prog.stream.util.Lector;
import es.etg.daw.prog.stream.util.LectorCSV;
import java.util.List;
import org.junit.jupiter.api.Test;



public class LectorCSVTest {
    
    
    @Test
    public void leerTest(){
        int numEsperado = 4;
        int numReal = 0;
        String cadena = "Nombre,Apellidos,DNI\n" + //
                        "Julián,Parra,1a\n" + //
                        "Ana,García,2b\n" + //
                        "Pedro,López,2c\n" + //
                        "Laura,Gómez,4d\n" + //
                        "";

        Lector lector = new LectorCSV();
        List<Alumno> alumnos = lector.leer(cadena);

        numReal = alumnos.size();

        assertEquals(numEsperado, numReal);
    }
    
}
