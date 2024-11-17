
package mx.com.gm.peliculas.domain;

public class Pelicula {
    // Usamos el concepto de Java Bean
    private String nombre;
    
    // Generamos un constructor vacio y uno con argumentos
    public Pelicula() {
    }   

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }
    
    // Getter & setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Metodo ToString
    @Override
    public String toString() {
        return this.nombre;
    }  
}
