package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCuadreCompuestaFijaLocalHome extends EJBLocalHome 
{
    MONCuadreCompuestaFijaLocal create() throws CreateException;
}