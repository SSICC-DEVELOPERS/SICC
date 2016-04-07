package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCargaListaClientesLocalHome extends EJBLocalHome 
{
    MONCargaListaClientesLocal create() throws CreateException;
}