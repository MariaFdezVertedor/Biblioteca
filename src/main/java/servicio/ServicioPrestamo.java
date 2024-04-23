package servicio;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Biblioteca.Lector;
import Biblioteca.Libro;
import Biblioteca.Prestamo;
import util.HibernateUtil;

public class ServicioPrestamo {

    // Método para asignar un libro a un lector
    public void asignarLibroALector(Libro libro, Lector lector) {
        // Guardar el libro en la base de datos
        guardar(libro);
        
        // Crear un nuevo préstamo
        Prestamo prestamo = new Prestamo();
        
        // Establecer la fecha de préstamo como la fecha actual
        prestamo.setFechaPrestamo(new Date());
        
        // Establecer el libro y el lector para el préstamo
        prestamo.setLibro(libro);
        prestamo.setLector(lector);
        
        // Guardar el préstamo en la base de datos
        guardar(prestamo);
    }

    // Método para registrar la devolución de un libro
    public void registrarDevolucion(Libro libro, Lector lector) {
        // Obtener el préstamo activo para el libro y el lector
        Prestamo prestamo = obtenerPrestamoActivoPorLibroYLector(libro, lector);
        
        // Si se encuentra un préstamo activo, registrar la devolución
        if (prestamo != null) {
            // Establecer la fecha de devolución como la fecha actual
            prestamo.setFechaDevolucion(new Date());
            
            // Actualizar el préstamo en la base de datos
            actualizar(prestamo);
        } else {
            // Si no se encuentra un préstamo activo, mostrar un mensaje de error
            System.out.println("Error: No se encontró un préstamo activo para este libro y lector.");
        }
    }

    // Método para guardar un objeto en la base de datos
    void guardar(Object objeto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Iniciar una transacción
            transaction = session.beginTransaction();
            
            // Guardar el objeto en la base de datos
            session.save(objeto);
            
            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            // En caso de error, hacer rollback de la transacción y mostrar el error
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para actualizar un objeto en la base de datos
    private void actualizar(Object objeto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Iniciar una transacción
            transaction = session.beginTransaction();
            
            // Actualizar el objeto en la base de datos
            session.update(objeto);
            
            // Confirmar la transacción
            transaction.commit();
        } catch (Exception e) {
            // En caso de error, hacer rollback de la transacción y mostrar el error
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para obtener un préstamo activo por libro y lector
    private Prestamo obtenerPrestamoActivoPorLibroYLector(Libro libro, Lector lector) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Consultar la base de datos para obtener un préstamo activo para el libro y el lector especificados
            String hql = "FROM Prestamo p WHERE p.libro = :libro AND p.lector = :lector AND p.fechaDevolucion IS NULL";
            return session.createQuery(hql, Prestamo.class)
                    .setParameter("libro", libro)
                    .setParameter("lector", lector)
                    .uniqueResult();
        } catch (Exception e) {
            // En caso de error, mostrar el error
            e.printStackTrace();
        }
        return null;
    }
}