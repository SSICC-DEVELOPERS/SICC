package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.ape.DTOBuscarCaja;
import es.indra.sicc.dtos.ape.DTODatosCajaCabecera;
import es.indra.sicc.dtos.ape.DTOBuscarProducto;
import es.indra.sicc.util.DTOSalida;


public interface MONChequeoCajas extends EJBObject {
  DTODatosCajaCabecera obtenerCajaChequear(DTOBuscarCaja dtoe) throws RemoteException, MareException;

  DTOSalida buscarProducto(DTOBuscarProducto dtoe) throws RemoteException, MareException;

  void actualizarCaja(DTODatosCajaCabecera dtoe) throws RemoteException, MareException;




}
