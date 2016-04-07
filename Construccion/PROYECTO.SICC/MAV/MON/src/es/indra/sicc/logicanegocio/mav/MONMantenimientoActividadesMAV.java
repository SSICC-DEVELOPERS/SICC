package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.dtos.mav.DTOEBuscarActividadesMAV;
import es.indra.sicc.dtos.mav.DTOSCargaPaginaInsertarActividades;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONMantenimientoActividadesMAV extends EJBObject {
    void eliminarActividades(DTOOIDs dto) throws RemoteException, MareException;

    DTOSalida buscarActividades(DTOEBuscarActividadesMAV dto)
        throws RemoteException, MareException;

    void guardarActividad(DTOActividadMAV dto) throws RemoteException, MareException;

    DTOActividadMAV consultarActividad(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerSubtiposCliente(DTOBelcorp dto) throws RemoteException, MareException;

    DTOSalida obtieneActividadesMAV(DTOActividadMAV dto) throws RemoteException, MareException;

    DTOSCargaPaginaInsertarActividades cargaPaginaInsertarActividades(DTOBelcorp dto)
        throws RemoteException, MareException;

  DTOSalida obtenerSubtiposClienteMAV(DTOOID DTOE) throws RemoteException, MareException;

  DTOSalida obtenerActividadesTipoDespacho(DTOEBuscarActividadesMAV dto) throws MareException, RemoteException;
}