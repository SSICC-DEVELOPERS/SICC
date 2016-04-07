package es.indra.sicc.logicanegocio.ndg;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import  es.indra.mare.common.exception.MareException;
import  es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public interface MONRecepcionNDG extends EJBObject  {
  void recibirOrdenesDeCompra() throws  MareException, RemoteException, InterfacesException;

  void recibirEstadisticas() throws RemoteException, MareException, InterfacesException;


  void cargarOrdenesDeCompra(DTOAuditableSICC dto) throws RemoteException, MareException;

  DTOSalida cargarEstadisticasLote(DTOAuditableSICC dto) throws RemoteException, MareException, InterfacesException;

  void cargarEstadisticasRegistros(DTOSalida dtos) throws RemoteException, MareException, InterfacesException;
}
