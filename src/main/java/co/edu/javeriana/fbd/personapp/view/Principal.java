package co.edu.javeriana.fbd.personapp.view;

import co.edu.javeriana.fbd.personapp.model.dao.PersonaDAO;
import co.edu.javeriana.fbd.personapp.model.dao.impl.PersonaDAOImpl;
import co.edu.javeriana.fbd.personapp.model.dto.PersonaDTO;
public class Principal {
    public static void main(String[] args) {
        PersonaDTO p1 = new PersonaDTO((long) 2540, "Ana", "Lopez", (short) 20, 'O');
        System.out.println("p1: "+p1);
        PersonaDAO pdao = new PersonaDAOImpl();
        Integer result= pdao.count();
        System.out.println("Esto es lo que hay "+ result);
}
}
