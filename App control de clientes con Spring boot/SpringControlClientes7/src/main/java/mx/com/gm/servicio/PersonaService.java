
package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Persona;

public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardar(Persona Persona);
    
    public void eliminar(Persona Persona);
    
    public Persona encontrarPersona(Persona Persona);
    
}
