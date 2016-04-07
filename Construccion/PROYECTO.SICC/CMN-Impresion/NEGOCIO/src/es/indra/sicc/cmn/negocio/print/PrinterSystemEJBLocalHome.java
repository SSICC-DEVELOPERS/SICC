package es.indra.sicc.cmn.negocio.print;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface PrinterSystemEJBLocalHome extends EJBLocalHome 
{
  PrinterSystemEJBLocal create() throws CreateException;
}