package servicio;

import org.hibernate.*;
import Biblioteca.*;
import antlr.collections.List;

public class ServicioConsultas {
    
    // Variable para almacenar la sesión de Hibernate
    private final SessionFactory sessionFactory;
    
    public ServicioConsultas(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Método para obtener la lista de libros actualmente prestados a un lector
    @SuppressWarnings("deprecation")
    public List librosActualmentePrestadosALector(Lector lector) {
        try (Session session = sessionFactory.openSession()) {
            // Consulta Hibernate para obtener los préstamos activos para un lector específico
            Query<Prestamo> query = session.createQuery("FROM Prestamo p WHERE p.lector = :lector AND p.fechaDevolucion IS NULL", Prestamo.class);
            query.setParameter("lector", lector);
            return (List) query.getResultList();
        }
    }

    // Método para obtener la lista de libros disponibles para préstamo
    public List librosDisponiblesParaPrestamo() {
        try (Session session = sessionFactory.openSession()) {
            // Consulta Hibernate para obtener los libros que están disponibles para préstamo
            @SuppressWarnings("deprecation")
            Query<Libro> query = session.createQuery("FROM Libro l WHERE l.disponible = true", Libro.class);
            return (List) query.getResultList();
        }
    }

    // Método para obtener el historial de préstamos de un lector
    @SuppressWarnings("deprecation")
    public List historialPrestamosPorLector(Lector lector) {
        try (Session session = sessionFactory.openSession()) {
            // Consulta Hibernate para obtener el historial de préstamos de un lector específico
            Query<Prestamo> query = session.createQuery("FROM Prestamo p WHERE p.lector = :lector", Prestamo.class);
            query.setParameter("lector", lector);
            return (List) query.getResultList();
        }
    }
}