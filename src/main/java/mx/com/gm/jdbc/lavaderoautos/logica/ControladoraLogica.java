package mx.com.gm.jdbc.lavaderoautos.logica;

import java.util.List;
import mx.com.gm.jdbc.lavaderoautos.persistencia.ControladoraPersistencia;


public class ControladoraLogica {
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();

    public void guardar(String marca, String modelo, String color, String observaciones, String chocado, String tratamiento, String nombreDuenio, String celDuenio) {
        
        //Creacion del dueño y asignamos valores.
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        //Creacion del coche y asignamos valores.
        Coche coche = new Coche();
        coche.setMarca(marca);
        coche.setColor(color);
        coche.setModelo(modelo);
        coche.setObservaciones(observaciones);
        coche.setEsChocado(chocado);
        coche.setTratamientoEspecial(tratamiento);
        coche.setUnDuenio(duenio);
        
        controlPersistencia.guardar(duenio, coche);
        
    }

    public List<Coche> traerCoches() {
       
        return controlPersistencia.traerCoches();

    }

    public void eliminarRegistro(int num_cliente) {
        controlPersistencia.eliminarRegistro(num_cliente);
    }

    public Coche traerCoche(int num_cliente) {
        return controlPersistencia.traerCoche(num_cliente);
    }

    public void modificarCoche(Coche coche, String marca, String modelo, String color, String observaciones, String chocado, String tratamiento, String nombreDuenio, String celDuenio) {
    
        coche.setMarca(marca);
        coche.setModelo(modelo);
        coche.setColor(color);
        coche.setObservaciones(observaciones);
        coche.setEsChocado(chocado);
        coche.setTratamientoEspecial(tratamiento);
        
        controlPersistencia.modificarCoche(coche);
        
        Duenio duenio = this.buscarDuenio(coche.getUnDuenio().getId_duenio());
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(nombreDuenio);
        
        this.modificarDuenio(duenio);
        
    
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersistencia.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersistencia.modificarDuenio(duenio);
    }
}
