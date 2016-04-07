package es.indra.sicc.logicanegocio.ndg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.ndg.DTOInformacionDeFiltrado;
import es.indra.sicc.util.DTOSalida;

import java.io.File;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public interface MONGeneracionInformacionNDG extends EJBObject  {
  void eliminarRegistrosDeUsuarios() throws MareException, RemoteException;

  void cargarUsuarios() throws MareException, RemoteException;

  RecordSet obtenerInformacionDeUsuarios(DTOAuditableSICC dto) throws RemoteException, MareException;

  void generarFicherosDeUsuariosNdg(DTOAuditableSICC dto) throws RemoteException, MareException;

  File crearArchivo(String nombreArchivo) throws MareException, RemoteException;

  RecordSet obtenerInformacionConsultoras(DTOInformacionDeFiltrado dto) throws RemoteException, MareException;

  DTOSalidaBatch generarFicheroDeEnviarConsultoras(DTOInformacionDeFiltrado dto) throws RemoteException, MareException;

  DTOSalida obtenerInformacionCriteriosDeSeleccion(DTOInformacionDeFiltrado dto) throws RemoteException, MareException;

  DTOSalidaBatch generarFicherosMatrizDePrecios(DTOBatch dto) throws RemoteException, MareException;
 
  DTOSalidaBatch generarFicherosMatrizDePreciosBatch(DTOInformacionDeFiltrado dto) throws MareException ,RemoteException;

  RecordSet obtenerInformacionMatrizPrecios(DTOInformacionDeFiltrado dto) throws RemoteException, MareException;

  DTOSalidaBatch generarFicheroRangoPeriodos(DTOInformacionDeFiltrado dto) throws RemoteException, MareException;
  

  RecordSet obtenerInformacionRangoPeriodos(DTOInformacionDeFiltrado dto) throws RemoteException, MareException;

  String getNombreArchivo(int n) throws MareException, RemoteException;
  
}
