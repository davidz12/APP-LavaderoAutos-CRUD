package mx.com.gm.jdbc.lavaderoautos.logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.com.gm.jdbc.lavaderoautos.logica.Duenio;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-12-15T16:50:21", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Coche.class)
public class Coche_ { 

    public static volatile SingularAttribute<Coche, String> marca;
    public static volatile SingularAttribute<Coche, Integer> num_cliente;
    public static volatile SingularAttribute<Coche, String> color;
    public static volatile SingularAttribute<Coche, String> observaciones;
    public static volatile SingularAttribute<Coche, Duenio> unDuenio;
    public static volatile SingularAttribute<Coche, String> modelo;
    public static volatile SingularAttribute<Coche, String> tratamientoEspecial;
    public static volatile SingularAttribute<Coche, String> esChocado;

}