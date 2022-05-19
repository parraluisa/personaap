
package co.edu.javeriana.fbd.personapp.model.dao.impl;

import co.edu.javeriana.fbd.personapp.model.dao.TelefonoDAO;
import co.edu.javeriana.fbd.personapp.model.dto.PersonaDTO;
import co.edu.javeriana.fbd.personapp.model.dto.TelefonoDTO;
import co.edu.javeriana.fbd.personapp.util.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelefonoDAOImpl implements TelefonoDAO{

    private final MySQL mysql;

    public TelefonoDAOImpl() {

        this.mysql = new MySQL();
    }


    @Override
    public TelefonoDTO create(TelefonoDTO telefono) {
        try {
            this.mysql.conectar();
            String query = "INSERT INTO telefono(numero,operador,duenio) VALUES("
                    + "'" + telefono.getNumero() + "',"
                    + "'" + telefono.getOperador() + "',"
                    + "'" + telefono.getDuenio() + "');";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.mysql.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se creo el telefono");
                    return findByNum(telefono.getNumero());
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public TelefonoDTO edit(String numero, TelefonoDTO telefono) {
        try {
            this.mysql.conectar();
            String query = "update telefono set"
                    +"Numero ="+ "'" + telefono.getNumero() + "',"
                    +"operador ="+ "'" + telefono.getOperador()+ "',"
                    +"duenio ="+ "'" + telefono.getDuenio() + "' where numero ='"+numero+"';";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.mysql.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se actualizo el telefono");
                    return findByNum(telefono.getNumero());
                default:
                    return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Boolean delete(String numero) {
        try {
            this.mysql.conectar();
            String query = "DELETE FROM telefono WHERE numero='"
                    + numero + "';";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement();
            int code = stmt.executeUpdate(query);
            stmt.close();
            this.mysql.desconectar();
            switch (code) {
                case 1:
                    System.out.println("Se eliminó el telefono");
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
    public TelefonoDTO findByNum(String numero) {
        try {
            this.mysql.conectar();
            String query = "SELECT * FROM telefono WHERE numero = '" + numero + "';";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                TelefonoDTO telefono = new TelefonoDTO(
                        rs.getString("numero"),
                        rs.getString("operador"),
                        rs.getLong("duenio"));
                rs.close();
                stmt.close();
                return telefono;
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
    public List<TelefonoDTO> findByDuenio(Long cedulaDuenio) {
        List<TelefonoDTO> telefonosLista =new ArrayList<TelefonoDTO>();
        try {
            this.mysql.conectar();
            String query = "SELECT * FROM telefono WHERE duenio = '" + cedulaDuenio + "';";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()) {
                while (rs.next()) {
                    TelefonoDTO telefono = new TelefonoDTO(
                            rs.getString("numero"),
                            rs.getString("operador"),
                            rs.getLong("duenio"));
                    telefonosLista.add(telefono);
                }
                rs.close();
                stmt.close();
            } else {
                rs.close();
                stmt.close();
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return telefonosLista;
    }

    @Override
    public List<TelefonoDTO> findAll() {
        List<TelefonoDTO> telefonos=new ArrayList<TelefonoDTO>();
        try {
            this.mysql.conectar();
            String query = "SELECT * FROM telefono;";
            System.out.println(query);
            Statement stmt = this.mysql.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(query);
            if (rs.first()){
                while (rs.next()) {
                    TelefonoDTO telefono = new TelefonoDTO(
                            rs.getString("numero"),
                            rs.getString("operador"),
                            rs.getLong("duenio"));
                    telefonos.add(telefono);
                }
                rs.close();
                stmt.close();
                return telefonos;
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
            String query = "SELECT count(*) FROM telefono;";
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
