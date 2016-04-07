package es.indra.sicc.logicanegocio.mae;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.mae.DTOImpuestoUBIGEO;
import es.indra.mare.common.exception.MareException ;
import es.indra.sicc.dtos.mae.DTOCombosImpuestos;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.mae.DTOCargaInicialTerritorios;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mae.DTOModificarImpuesto;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.mae.DTOConsultaImpuestoUBIGEO;


public interface MONImpuestosUBIGEO extends EJBObject  {    

    DTOCombosImpuestos rellenarCombos(DTOBelcorp dto) throws RemoteException, MareException;

    DTOCargaInicialTerritorios cargaInicialTerritorios(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSalida obtenerTerritorio(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerNivelGeografico(DTOOID dto) throws RemoteException, MareException;

    void inserta(DTOImpuestoUBIGEO datos) throws RemoteException, MareException;

    void actualiza(DTOModificarImpuesto dto) throws RemoteException, MareException;

    void elimina(DTOOIDs oids) throws RemoteException, MareException;

    DTOConsultaImpuestoUBIGEO consultar(DTOOID oid) throws RemoteException, MareException;

    DTOSalida buscarPorCriterios(DTOImpuestoUBIGEO dto) throws RemoteException, MareException;

  DTOSalida obtenerTasasImpuesto(DTOBelcorp dto) throws MareException, RemoteException;
}