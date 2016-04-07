package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTOEBuscarEstadosMAV;
import es.indra.sicc.dtos.mav.DTOEstadoMAV;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONMantenimientoEstadosMAV extends EJBObject {
    void eliminarEstados(DTOOIDs dto) throws RemoteException, MareException;

    void guardarEstados(DTOEstadoMAV dto) throws RemoteException, MareException;

    DTOEstadoMAV consultarEstado(DTOOID dto) throws RemoteException, MareException;

    DTOSalida buscarEstados(DTOEBuscarEstadosMAV dto) throws RemoteException, MareException;
}