/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.fbd.personapp.view;

import co.edu.javeriana.fbd.personapp.model.dao.PersonaDAO;
import co.edu.javeriana.fbd.personapp.model.dao.impl.PersonaDAOImpl;
import co.edu.javeriana.fbd.personapp.model.dto.PersonaDTO;

/**
 *
 * @author aasanchez
 */
public class Principal {
    public static void main(String[] args) {
        PersonaDTO p1 = new PersonaDTO((long) 2540, "Ana", "Lopez", (short) 20, 'O');
        System.out.println("p1: "+p1);
        PersonaDAO pdao = new PersonaDAOImpl();
        PersonaDTO p2 = pdao.create(p1);
        System.out.println("p2: "+p2);
        PersonaDTO p3 =pdao.findById((long)2540);
    }
}
