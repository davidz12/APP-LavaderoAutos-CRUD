
package mx.com.gm.jdbc.lavaderoautos.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.jdbc.lavaderoautos.logica.Coche;
import mx.com.gm.jdbc.lavaderoautos.logica.Duenio;
import mx.com.gm.jdbc.lavaderoautos.persistencia.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    CocheJpaController cocheJpa = new CocheJpaController();

    public void guardar(Duenio duenio, Coche coche) {
        
        //Crea en la BD el dueño
        duenioJpa.create(duenio);
        
        //Crea en la BD el coche
        cocheJpa.create(coche);
        
    }

    public List<Coche> traerCoches() {
        return cocheJpa.findCocheEntities();
    }

    public void eliminarRegistro(int num_cliente) {
        try {
            cocheJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Coche traerCoche(int num_cliente) {
        return cocheJpa.findCoche(num_cliente);
    }

    public void modificarCoche(Coche coche) {
        try {
            cocheJpa.edit(coche);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
