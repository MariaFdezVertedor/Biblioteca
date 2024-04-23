package Biblioteca;

import javax.persistence.*;

@Entity
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro; 
    
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private boolean disponible;
    
    // Constructores, getters y setters
    // Constructor vacío
    public Libro() {
    }
    
    // Constructor con todos los atributos
    public Libro(String titulo, String autor, int anioPublicacion, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.disponible = disponible;
    }
    
    // Getters y setters
    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long id) {
        this.idLibro = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}