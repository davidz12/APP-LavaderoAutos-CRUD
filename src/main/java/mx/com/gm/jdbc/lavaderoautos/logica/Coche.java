
package mx.com.gm.jdbc.lavaderoautos.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Coche implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int num_cliente;
    private String marca;
    private String modelo;
    private String color;
    private String esChocado;
    private String tratamientoEspecial;
    private String observaciones;
    @OneToOne
    private Duenio unDuenio;

    public Coche() {
    }

    public Coche(int num_cliente, String marca, String modelo, String color, String esChocado, String tratamientoEspecial, String observaciones, Duenio unDuenio) {
        this.num_cliente = num_cliente;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.esChocado = esChocado;
        this.tratamientoEspecial = tratamientoEspecial;
        this.observaciones = observaciones;
        this.unDuenio = unDuenio;
    }

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEsChocado() {
        return esChocado;
    }

    public void setEsChocado(String esChocado) {
        this.esChocado = esChocado;
    }

    public String getTratamientoEspecial() {
        return tratamientoEspecial;
    }

    public void setTratamientoEspecial(String tratamientoEspecial) {
        this.tratamientoEspecial = tratamientoEspecial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Duenio getUnDuenio() {
        return unDuenio;
    }

    public void setUnDuenio(Duenio unDuenio) {
        this.unDuenio = unDuenio;
    }

    
}
