
package mx.com.gm.jdbc.lavaderoautos.persistencia;

import mx.com.gm.jdbc.lavaderoautos.logica.Coche;
import mx.com.gm.jdbc.lavaderoautos.logica.Duenio;


public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    CocheJpaController cocheJpa = new CocheJpaController();

    public void guardar(Duenio duenio, Coche coche) {
        
        //Crea en la BD el dueño
        duenioJpa.create(duenio);
        
        //Crea en la BD el coche
        cocheJpa.create(coche);
        
    }
}
