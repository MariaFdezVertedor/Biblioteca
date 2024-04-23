package servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.Date;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Biblioteca.Lector;
import Biblioteca.Libro;
import util.HibernateUtil;

public class ServicioTest {

    private SessionFactory sessionFactory;
    private ServicioPrestamo servicioPrestamo;

    @Before
    public void setUp() {
        // Configurar la sesión de Hibernate para las pruebas
        Configuration cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
        servicioPrestamo = new ServicioPrestamo();
    }

    @After
    public void tearDown() {
        // Cerrar la sesión de Hibernate después de las pruebas
        HibernateUtil.shutdown();
    }

    @Test
    public void testAsignarLibroALector() {
        // Crear un libro y un lector para la prueba
        Libro libro = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, true);
        Lector lector = new Lector("Juan", "Gómez", "juan@gmail.com");
        
        // Guardar el libro y el lector
        servicioPrestamo.guardar(libro);
        servicioPrestamo.guardar(lector);
        
        // Asignar el libro al lector
        servicioPrestamo.asignarLibroALector(libro, lector);
        
        // Comprobar que el préstamo se ha registrado correctamente
        assertNotNull(libro.getIdLibro());
        assertNotNull(lector.getIdLector());
    }

    @Test
    public void testRegistrarDevolucion() {
        // Crear un libro y un lector para la prueba
        Libro libro = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, true);
        Lector lector = new Lector("María", "López", "maria@gmail.com");
        
        // Guardar el libro y el lector
        servicioPrestamo.guardar(libro);
        servicioPrestamo.guardar(lector);
        
        // Asignar el libro al lector
        servicioPrestamo.asignarLibroALector(libro, lector);
        
        // Registrar la devolución del libro
        servicioPrestamo.registrarDevolucion(libro, lector);
        
        // Comprobar que la devolución se ha registrado correctamente
        assertNotNull(libro.getIdLibro());
        assertNotNull(lector.getIdLector());
    }
}