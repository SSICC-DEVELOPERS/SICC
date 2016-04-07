package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCierreFacturacionLocalHome extends EJBLocalHome  {
    MONCierreFacturacionLocal create() throws CreateException;
}