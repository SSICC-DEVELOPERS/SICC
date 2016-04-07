package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCuadreCompuestaVariableLocalHome extends EJBLocalHome 
{
    MONCuadreCompuestaVariableLocal create() throws CreateException;
}