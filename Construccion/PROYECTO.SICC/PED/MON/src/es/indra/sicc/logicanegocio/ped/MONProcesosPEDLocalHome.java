package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONProcesosPEDLocalHome extends EJBLocalHome  {
  MONProcesosPEDLocal create() throws CreateException;
}