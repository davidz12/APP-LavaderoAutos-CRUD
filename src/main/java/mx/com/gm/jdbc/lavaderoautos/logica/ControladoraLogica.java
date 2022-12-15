package mx.com.gm.jdbc.lavaderoautos.logica;

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
}
