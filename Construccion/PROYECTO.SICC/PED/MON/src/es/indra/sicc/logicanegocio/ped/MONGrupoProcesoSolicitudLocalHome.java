package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGrupoProcesoSolicitudLocalHome extends EJBLocalHome 
{
    MONGrupoProcesoSolicitudLocal create() throws CreateException;
}