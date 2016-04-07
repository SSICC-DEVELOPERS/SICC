package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;

import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.util.DTOString;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONCargaListaClientes extends EJBObject {
    DTOManagerFileResult procesar(DTOFicheroDisp dto) throws RemoteException, MareException;

    DTOSalida busquedaListaClientes(DTOBusquedaRapidaCliente dto) throws MareException, 
                                                                         RemoteException;

    DTOString procesarLista(DTOString dto) throws MareException, 
                                                  RemoteException;
}
