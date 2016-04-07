package es.indra.sicc.logicanegocio.cal;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONRecepcionLlamadasLocalHome extends EJBLocalHome 
{
    MONRecepcionLlamadasLocal create() throws CreateException;
}