package Biblioteca;

import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("INICIO DEL PROGRAMA...");

        // Configurar la sesión de Hibernate
        Configuration cfg = new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
        Session session = sessionFactory.openSession();

        System.out.println("CONFIGURACIÓN REALIZADA");

        // Crear y guardar un lector
        Transaction tx = session.beginTransaction();
        Lector lector = new Lector("Juan", "Lopez", "julo@gmail.com");
        session.save(lector);
        tx.commit();

        // Crear y guardar un libro
        tx = session.beginTransaction();
        Libro libro = new Libro("Te daré la tierra", "Ildefonso Falcones", 2010, true);
        session.save(libro);
        tx.commit();

        // Crear y guardar un prestamo
        tx = session.beginTransaction();
        Prestamo prestamo = new Prestamo(new Date(), new Date(), libro, lector);
        session.save(prestamo);
        tx.commit();

        // Consultar y mostrar todos los prestamos
        List<Prestamo> prestamos = session.createQuery("FROM Prestamo", Prestamo.class).getResultList();
        for (Prestamo p : prestamos) {
            System.out.println("Prestamo - Fecha de préstamo: " + p.getFechaPrestamo() + ", Fecha de devolución: " + p.getFechaDevolucion() + ", Libro: " + p.getLibro().getTitulo() + ", Lector: " + p.getLector().getNombre());
        }

        // Consultar y mostrar todos los libros
        List<Libro> libros = session.createQuery("FROM Libro", Libro.class).getResultList();
        for (Libro l : libros) {
            System.out.println("Libro - Título: " + l.getTitulo() + ", Autor: " + l.getAutor() + ", Año de publicación: " + l.getAnioPublicacion());
        }

        // Consultar y mostrar todos los lectores
        List<Lector> lectores = session.createQuery("FROM Lector", Lector.class).getResultList();
        for (Lector l : lectores) {
            System.out.println("Lector - Nombre: " + l.getNombre() + ", Apellido: " + l.getApellido() + ", Email: " + l.getEmail());
        }

        session.close();
        sessionFactory.close();
    }
}