package es.indra.sicc.logicanegocio.bel;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOCobroBelcenter;
import es.indra.sicc.dtos.bel.DTOComprobarInicioCobro;
import es.indra.sicc.dtos.bel.DTOObtenerNotasCreditoPendientes;
import es.indra.sicc.dtos.bel.DTOObtenerSolicitudCobro;
import es.indra.sicc.util.DTOOID;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.bel.DTOApplet;
import es.indra.sicc.dtos.bel.DTOContinuarFacturacion;

public interface MONCobrarBelcenter extends EJBObject 
{
  es.indra.sicc.dtos.bel.DTOComprobarInicioCobro  comprobarInicioCobro(DTOComprobarInicioCobro dtoE) throws RemoteException, MareException;

  es.indra.sicc.dtos.bel.DTOCargaCobroBelcenter  cargaInicialCobro(DTOApplet dtoa) throws RemoteException, MareException;

  DTOOID obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE) throws MareException, RemoteException;

  void grabarCobro(DTOCobroBelcenter dtoE) throws MareException, RemoteException;

  DTOSalida obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE) throws MareException, RemoteException;

  void continuarFacturacion(DTOContinuarFacturacion dto) throws MareException, RemoteException;
}