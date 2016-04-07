package es.indra.sicc.logicanegocio.bel;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.bel.DTOParametrosBEL;
import es.indra.sicc.dtos.bel.DTOBusquedaParametrosBEL;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;


public interface MONMantenimientoParametrosBel extends EJBObject 
{
    DTOParametrosBEL buscarParametrosBel(DTOOID dtoE) throws RemoteException, MareException;

    void guardarParametros(DTOParametrosBEL dtoE) throws RemoteException, MareException;

    DTOSalida obtenerParametrosBel(DTOBusquedaParametrosBEL dtoE) throws RemoteException, MareException;

    void eliminarParametrosBEL(DTOOIDs dto) throws MareException, RemoteException;



}