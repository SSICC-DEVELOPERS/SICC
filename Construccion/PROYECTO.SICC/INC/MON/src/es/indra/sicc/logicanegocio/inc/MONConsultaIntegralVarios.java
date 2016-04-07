package es.indra.sicc.logicanegocio.inc;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;

public interface MONConsultaIntegralVarios extends EJBObject {
    DTOSalida consultarDetalleRecomendacion(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarPremiosSeleccionados(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarDetalleMotivosDescalificacion(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;

    DTOSalida consultarDetallePremiosSeleccionados(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;

    DTOSalida consultarRecomendacionPart(DTOCabeceraConsultaIntegral dtoe) throws MareException, 
                                                                                  RemoteException;

    DTOSalida consultarDetallePedidosRecomendadas(DTOCabeceraConsultaIntegral dtoe) throws MareException, 
                                                                                           RemoteException;

    DTOSalida consultarDetallePedidosRecomendante(DTOCabeceraConsultaIntegral dtoe) throws MareException, 
                                                                                           RemoteException;
}
