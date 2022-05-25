package co.edu.javeriana.fbd.personapp.model.dao;


import co.edu.javeriana.fbd.personapp.model.dto.PersonaDTO;
import co.edu.javeriana.fbd.personapp.model.dto.TelefonoDTO;
import java.util.List;

public interface TelefonoDAO {

    public TelefonoDTO create(TelefonoDTO telefono);

    public TelefonoDTO edit(String numero, TelefonoDTO telefono);

    public Boolean delete(String numero);

    public TelefonoDTO findByNum(String numero);

    public List<TelefonoDTO> findByDuenio(Long cedulaDuenio);

    public List<TelefonoDTO> findAll();

    public Integer count();

}

