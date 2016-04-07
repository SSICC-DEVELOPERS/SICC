package es.indra.sicc.logicanegocio.app;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.app.DTOTerritorio;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.app.DTOTerritorioRuta;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;

public interface MONTerritoriosRutasLocal extends EJBLocalObject 
{
    DTOSalida buscarTerritoriosNoAsociados(DTOTerritorio DTOE) throws MareException;

    DTOSalida consultarTerritoriosAsociados(DTOTerritorio DTOE) throws MareException;

    void eliminarTerritoriosAsociados(DTOOIDs DTOE) throws MareException;

    void guardarTerritoriosAsociados(DTOSalida DTOE) throws MareException;

    void insertarTerritorioRuta(DTOTerritorioRuta DTOE) throws MareException;

    void modificarTerritorioRuta(DTOTerritorioRuta DTOE) throws MareException;

    DTOSalida obtenerRutas(DTOBelcorp DTOE) throws MareException;

    DTOSalida obtenerTerritoriosAsociados(DTOOID DTOE) throws MareException;
}