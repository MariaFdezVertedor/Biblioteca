package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Método para construir la fábrica de sesiones de Hibernate
    private static SessionFactory buildSessionFactory() {
        try {
            // Crear el registro de servicios de Hibernate
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // Configuración desde el archivo hibernate.cfg.xml por defecto
                    .build();
            // Crear la fábrica de sesiones
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            // Manejo de excepciones
            System.err.println("Error al inicializar la SessionFactory: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    // Método para obtener la fábrica de sesiones
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Método para cerrar la fábrica de sesiones
    public static void shutdown() {
        getSessionFactory().close();
    }
}