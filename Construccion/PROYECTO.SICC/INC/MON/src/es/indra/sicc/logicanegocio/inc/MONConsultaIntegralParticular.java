package es.indra.sicc.logicanegocio.inc;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;

public interface MONConsultaIntegralParticular extends EJBObject {
    DTOSalida consultarDetalleConcursoSeleccionado(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarConcursoSeleccionado(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarDetalleMultinivel(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarMultinivel(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarDetallePremioArticulo(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarDetallePremioMonetario(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarDetallePremioPuntos(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;
    DTOSalida consultarDetallePremioDescuento(DTOCabeceraConsultaIntegral dto) throws MareException, RemoteException;

    DTOSalida consultarDetalleSolicitudes(DTOCabeceraConsultaIntegral dto) throws MareException, 
                                                                                  RemoteException;
}
