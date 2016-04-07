package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONSimulacionDescuentoLocalHome extends EJBLocalHome 
{
    MONSimulacionDescuentoLocal create() throws CreateException;
}