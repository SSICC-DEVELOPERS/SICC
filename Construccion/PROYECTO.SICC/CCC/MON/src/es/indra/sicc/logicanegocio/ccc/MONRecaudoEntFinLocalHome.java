package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONRecaudoEntFinLocalHome extends EJBLocalHome  {
   MONRecaudoEntFinLocal create() throws CreateException;
}