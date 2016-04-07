package es.indra.sicc.logicanegocio.app;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.app.DTOTerritorio;
import es.indra.sicc.dtos.app.DTOTerritorioRuta;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;



public interface MONTerritoriosRutas extends EJBObject {
    DTOSalida obtenerRutas(DTOBelcorp DTOE)
        throws RemoteException, MareException;

    DTOSalida obtenerTerritoriosAsociados(DTOOID DTOE)
        throws RemoteException, MareException;

    DTOSalida buscarTerritoriosNoAsociados(DTOTerritorio DTOE)
        throws RemoteException, MareException;

    DTOSalida consultarTerritoriosAsociados(DTOTerritorio DTOE)
        throws RemoteException, MareException;

	void guardarTerritoriosAsociados(DTOSalida DTOE) throws RemoteException, MareException;

	void insertarTerritorioRuta(DTOTerritorioRuta DTOE) throws RemoteException, MareException;

	void modificarTerritorioRuta(DTOTerritorioRuta DTOE) throws RemoteException, MareException;

	void eliminarTerritoriosAsociados(DTOOIDs DTOE) throws RemoteException, MareException;


}
