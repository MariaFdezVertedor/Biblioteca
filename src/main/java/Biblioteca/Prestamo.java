package Biblioteca;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;
    
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;
    
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    
    @ManyToOne
    private Libro idLibro;
    
    @ManyToOne
    private Lector idLector;
    
    // Constructores, getters y setters
    // Constructor vacío
    public Prestamo() {
    }
    
    // Constructor con todos los atributos
    public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Libro libro, Lector lector) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.idLibro = libro;
        this.idLector = lector;
    }
    
    // Getters y setters
    public Long getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Long id) {
        this.idPrestamo = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return idLibro;
    }

    public void setLibro(Libro libro) {
        this.idLibro = libro;
    }

    public Lector getLector() {
        return idLector;
    }

    public void setLector(Lector lector) {
        this.idLector = lector;
    }

}