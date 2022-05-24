
package co.edu.javeriana.fbd.personapp.model.dto;

import java.util.Objects;

public class TelefonoDTO {
    
    private String numero;
    private String operador;
    private PersonaDTO duenio;

    public TelefonoDTO(String numero, String operador, PersonaDTO duenio) {
        this.numero = numero;
        this.operador = operador;
        this.duenio = duenio;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public PersonaDTO getDuenio() {

        return duenio;
    }

    public void setDuenio(PersonaDTO duenio) {
        this.duenio = duenio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.numero);
        hash = 29 * hash + Objects.hashCode(this.operador);
        hash = 29 * hash + Objects.hashCode(this.duenio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TelefonoDTO other = (TelefonoDTO) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.operador, other.operador)) {
            return false;
        }
        return Objects.equals(this.duenio, other.duenio);
    }

    @Override
    public String toString() {
        return "TelefonoDTO{" + "numero=" + numero + ", operador=" + operador + ", duenio=" + duenio + '}';
    }
    
}
