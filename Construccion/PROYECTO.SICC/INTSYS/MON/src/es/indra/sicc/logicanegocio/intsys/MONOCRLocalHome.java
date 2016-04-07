package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONOCRLocalHome extends EJBLocalHome 
{
  MONOCRLocal create() throws CreateException;
}