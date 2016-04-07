package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONFacturacionLocalHome extends EJBLocalHome 
{
    MONFacturacionLocal create() throws CreateException;
}