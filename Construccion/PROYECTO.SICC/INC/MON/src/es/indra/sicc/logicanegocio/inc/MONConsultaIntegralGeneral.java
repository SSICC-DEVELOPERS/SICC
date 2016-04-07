package es.indra.sicc.logicanegocio.inc;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;

public interface MONConsultaIntegralGeneral extends EJBObject {
    DTOCabeceraConsultaIntegral obtenerDatosClienteConcurso(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida obtenerConcursosBusquedaGeneral(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarDetallePremiosProcesadosGral(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOOIDs recuperarValoresUA(DTOOID dtoe) throws MareException, RemoteException;

    DTOSalida consultarDetallePremiosAsociadosNivel(DTOCabeceraConsultaIntegral dtoe) throws MareException, 
                                                                                             RemoteException;
}
