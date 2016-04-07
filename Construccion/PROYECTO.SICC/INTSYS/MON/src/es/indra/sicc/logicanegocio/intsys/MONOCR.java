package es.indra.sicc.logicanegocio.intsys;

import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

import es.indra.sicc.dtos.intsys.DTOCargarOrdenesDeCompra;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.intsys.DTOGenerarFicheroDeEnviarConsultoras;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.intsys.DTOEntradaConsultaDatosCampana;
import es.indra.sicc.dtos.intsys.DTOEntradaGenerarFicheroMatrizPrecios;
import es.indra.sicc.dtos.intsys.DTOGenerarFicheroRangoCampanya;

import es.indra.sicc.dtos.intsys.DTOInterfaz;
import es.indra.sicc.dtos.intsys.DTOObtenerUltimaFecha;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.intsys.DTOOCRCadenasInsercionSolicitudes;
import java.util.HashMap;

public interface MONOCR extends EJBObject  {
  void cargarOrdenesDeCompra(DTOCargarOrdenesDeCompra dto) throws MareException, RemoteException;

  void generarFicheroDeEnviarConsultoras(DTOGenerarFicheroDeEnviarConsultoras dtoGenerarFicheroDeEnviarConsultoras) throws MareException, RemoteException;

  RecordSet obtenerInformacionConsultoras(DTOGenerarFicheroDeEnviarConsultoras dtoGenerarFicheroDeEnviarConsultoras) throws MareException, RemoteException;

  DTOSalida obtenerValoresPorDefecto(DTOInterfaz dtoNumLote) throws RemoteException, MareException;

   DTOSalida obtenerDatosDeCampana(DTOEntradaConsultaDatosCampana dtoEntradaConsultaDatosCampana) throws  RemoteException, MareException, RemoteException;

   RecordSet obtenerInformacionMatrizPrecios(DTOEntradaGenerarFicheroMatrizPrecios dtoEntradaGenerarFicheroMatrizPrecios) throws  RemoteException, MareException, RemoteException;

   void generarFicheroEnviarMatrizDePrecios(DTOEntradaGenerarFicheroMatrizPrecios dtoEntradaGenerarFicheroMatrizPrecios) throws  RemoteException, MareException, RemoteException;

  void generarFicheroRangoCompanya(DTOGenerarFicheroRangoCampanya dtoe) throws RemoteException, MareException;

  DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws MareException, RemoteException;


  DTOSalidaBatch segmentarCargaSolicitudes(DTOBatch dtoin) throws RemoteException, Exception;

  DTOOCRCadenasInsercionSolicitudes cargarSolicitud(DTOCabeceraSolicitud dtoS) throws MareException, RemoteException;

  void ejecutarInsercionSolicitudes(StringBuffer cadenasInsercionSolicitudes) throws RemoteException, MareException;

  DTOSalidaBatch procesarSubSegmentos(DTOBatch dtoin) throws MareException, RemoteException;

  void insertarSolicitudesOnLine(HashMap hashOnLine) throws Exception, RemoteException;


    DTOCabeceraSolicitud generaNumeroSolicitudCabecera(DTOCabeceraSolicitud dtoCabecera) throws MareException, 
                                                                                                RemoteException;
}
