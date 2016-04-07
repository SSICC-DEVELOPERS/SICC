package es.indra.sicc.logicanegocio.bel;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.bel.DTOActualizarStockMinimo;
import es.indra.mare.common.exception.MareException;

public interface MONStock extends EJBObject 
{
  Long obtenerEADP(Long estimadoVenta, Float factorLocal) throws MareException, RemoteException;

  void actualizarStockMinimo(DTOActualizarStockMinimo dto) throws MareException, RemoteException;
}