package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGrupoProcesoLocalHome extends EJBLocalHome 
{
  MONGrupoProcesoLocal create() throws CreateException;
}