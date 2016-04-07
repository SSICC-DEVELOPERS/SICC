package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONBolsaFaltantesLocalHome extends EJBLocalHome 
{
    MONBolsaFaltantesLocal create() throws CreateException;
}