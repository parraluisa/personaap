
package co.edu.javeriana.fbd.personapp.model.dao;

import co.edu.javeriana.fbd.personapp.model.dto.PersonaDTO;
import java.util.List;

/**
 *
 * @author aasanchez
 */
public interface PersonaDAO {
    
    public PersonaDTO create(PersonaDTO persona);
    
    public PersonaDTO edit(Long cedula, PersonaDTO persona);
    
    public Boolean delete(Long cedula);
    
    public PersonaDTO findById(Long cedula);
    
    public List<PersonaDTO> findAll();
    
    public Integer count();
    
}
