package co.edu.javeriana.fbd.personapp.model.dao.impl;

import co.edu.javeriana.fbd.personapp.model.dao.PersonaDAO;
import co.edu.javeriana.fbd.personapp.model.dto.PersonaDTO;
import co.edu.javeriana.fbd.personapp.util.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAOImpl implements PersonaDAO {

    private final MySQL mysql;

    public PersonaDAOImpl() {
        this.mysql = new MySQL();
    }

    @Override
    public PersonaDTO create(PersonaDTO persona) {
        try {
            this.mysql.conectar();
            String query = "INSERT INTO persona(cedula,nombre,apellido,edad,genero) VALUES("
                    + "'" + persona.getCedula() + "',"
                    + "'" + persona.getNombre() + "',"
                    + "'" + persona.getApellido() + "',"
                    + "'" + persona.getEdad() + "',"
                    + "'" + persona.getGenero() + "');";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.mysql.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se creo la persona");
                    return findById(persona.getCedula());
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public PersonaDTO edit(Long cedula, PersonaDTO persona) {
        try {
            this.mysql.conectar();
            String query = "update persona set "
                    +"cedula ="+ persona.getCedula()+","
                    +" nombre ="+ "'" + persona.getNombre() + "',"
                    +"apellido ="+ "'" + persona.getApellido() + "',"
                    +"edad =" + persona.getEdad()+","
                    +"genero ="+ "'" + persona.getGenero() + "' where cedula ='"+cedula+"';";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.mysql.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se actualizo la persona");
                    return findById(persona.getCedula());
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean delete(Long cedula) {
        try {
            this.mysql.conectar();
            String query = "DELETE FROM persona WHERE cedula='"
                    + cedula + "';";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.mysql.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se eliminó la persona");
                    return true;
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public PersonaDTO findById(Long cedula) {
        try {
            this.mysql.conectar();
            String query = "SELECT * FROM persona WHERE cedula = '" + cedula + "';";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                PersonaDTO persona = new PersonaDTO(
                        rs.getLong("cedula"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getShort("edad"),
                        rs.getString("genero").charAt(0));
                rs.close();
                stmt.close();
                return persona;
            } else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<PersonaDTO> findAll() {
        List<PersonaDTO> personasList=new ArrayList<PersonaDTO>();
        try {
            this.mysql.conectar();
            String query = "SELECT * FROM persona;";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()){
                while (rs.next()) {
                    PersonaDTO persona = new PersonaDTO(
                            rs.getLong("cedula"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getShort("edad"),
                            rs.getString("genero").charAt(0));
                    personasList.add(persona);
                }
                rs.close();
                stmt.close();
                return personasList;
            }
            else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Integer count() {
        try {
            this.mysql.conectar();
            String query = "SELECT COUNT(*) FROM persona;";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int num=rs.getInt("count(*)");
            rs.close();
            stmt.close();
            return num;

        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}