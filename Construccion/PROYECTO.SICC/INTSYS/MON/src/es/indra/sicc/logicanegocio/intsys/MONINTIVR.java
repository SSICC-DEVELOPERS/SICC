package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.intsys.DTOEnvioInterfacesIVR;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.intsys.DTOLlamadaTelecobro;
import es.indra.sicc.dtos.intsys.DTOEINTIVR;

public interface MONINTIVR extends EJBObject  {

    DTOSalida obtenerInterfacesIVR(DTOString dto) throws RemoteException, MareException;

    DTOSalidaBatch enviarTablaRegiones(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarTablaCartera(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarTablaMotivosAtencion(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarTablaCronogramaOperaciones(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarTablaGerentes(DTOBatch dtoBatch) throws RemoteException, MareException;

    DTOSalidaBatch enviarTablaConsultoras(DTOBatch dtoBatch) throws RemoteException, MareException;

    void enviarIVRInterfaz(DTOEnvioInterfacesIVR dto) throws RemoteException, MareException;

    DTOSalidaBatch enviarIVRSistema(DTOEINTIVR dtoe) throws RemoteException, MareException;

    DTOSalidaBatch enviarIVR(DTOEnvioInterfacesIVR dto) throws RemoteException, MareException;

   void recibirEstadoLlamadas(DTOOID dtoOid) throws MareException, RemoteException;

   DTOSalidaBatch recibirEstadoLlamadaBatch(DTOBatch dtoe) throws MareException, RemoteException;

    DTOSalidaBatch enviarTablaServiciosPostVenta(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch generarLlamadasParaTelecobro(DTOBatch dto) throws RemoteException, MareException;

    void generarLlamadasParaTelecobroOnLine(DTOLlamadaTelecobro dto) throws RemoteException, MareException;

    void enviarIVRSistemaNovedad(MareDTO dtoe) throws RemoteException, MareException;

    void enviarIVRSistemaCompleto(MareDTO dtoe) throws RemoteException, MareException;

    DTOSalidaBatch enviarTablaProductos(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarConsultoraCuentaCastigada(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarTablaLineaCredito(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarTablaConcursos(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarTablaBasesIncumplidas(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarTablaNiveles(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarTablaPremios(DTOBatch dtoBatch) throws MareException, RemoteException;



}