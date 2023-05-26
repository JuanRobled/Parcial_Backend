import com.example.controllers.*;
import com.example.yourapp.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class LibroRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LibroRepository libroRepository;

    @Test
    public void testGuardarLibro() {
        Libro libro = new Libro();
        libro.setTitulo("Dracula");
        libro.setReferencia("edicion-1");
        libro.setAutor("Bram-Stoper");
        libro.setPrecio(100000);
        libro.setUbicacion("Rumania");

        Libro libroGuardado = libroRepository.save(libro);

        assertEquals("Dracula", libroGuardado.getTitulo());
        assertEquals("edicion-1", libroGuardado.getReferencia());
        assertEquals("Bram-Stoper", libroGuardado.getAutor());
        assertEquals(100000, libroGuardado.getPrecio());
        assertEquals("Rumania", libroGuardado.getUbicacion());
    }
    @Test
    public void testBuscarLibroPorReferencia() {
        // Crear un nuevo libro
        Libro libro = new Libro();
        libro.setTitulo("Dracula");
        libro.setReferencia("edicion-1");
        libro.setAutor("Bram-Stoper");
        libro.setPrecio(100000);
        libro.setUbicacion("Rumania");

        // Guardar el libro en la base de datos
        libroRepository.save(libro);

        // Buscar el libro por su referencia
        Libro libroEncontrado = libroRepository.findByReferencia("REF-001");

        // Verificar que se haya encontrado el libro correctamente
        assertNotNull(libroEncontrado);
        assertEquals("Dracula", libroEncontrado.getTitulo());
        assertEquals("edicion-1", libroEncontrado.getReferencia());
        assertEquals("Bram-Stoper", libroEncontrado.getAutor());
        assertEquals(100000, libroEncontrado.getPrecio());
        assertEquals("Rumania", libroEncontrado.getUbicacion());
    }

    // Otros métodos de prueba para las operaciones CRUD

}
