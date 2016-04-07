package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOMapaZonasLineasArmado;
import es.indra.sicc.dtos.ape.DTOMapaZonasDetalleSubLineas;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.ape.DTOCopiarMapaZonas;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionCabecera;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import java.util.ArrayList;
import es.indra.sicc.dtos.ape.DTOExpandirAnaquel;
import es.indra.sicc.dtos.ape.DTOMantenerConfiguracionBalanceo;

public interface MONMantenimientoMapas extends EJBObject  {
  DTOSalida obtenerMapasCDPorCD(DTOOID dtoe) throws RemoteException, MareException;
  DTOSalida obtenerMapaZonaPorMapaCD(DTOOID dtoe) throws MareException, RemoteException;
  void insertarMapaZonas(DTOMapaZonasLineasArmado dtoe) throws RemoteException, MareException;
  void modificarMapaZonas(DTOMapaZonasLineasArmado dtoe) throws RemoteException, MareException;
  DTOSalida obtenerMapaZonasCabecera(DTOOID dtoe) throws RemoteException, MareException;
  DTOMapaZonasDetalleSubLineas obtenerMapaZonasDetalle(DTOOID dtoe) throws RemoteException, MareException;
  void eliminarDetalles(DTOOIDs detallesEliminados) throws RemoteException, MareException;
  void eliminarMapaZonas(DTOOID dtoe) throws RemoteException, MareException;
  void copiarMapaZonas(DTOCopiarMapaZonas dtoe) throws RemoteException, MareException;
  DTOSalida obtenerProximoCodigoMapaCD(DTOBelcorp dtoe) throws MareException, RemoteException;
  DTOOID generarMapaCentroDistribucion(DTOMapaCentroDistribucionCabecera dtoe) throws MareException, RemoteException;
  void insertarCabeceraMapaCD(DTOMapaCentroDistribucionCabecera dtoe) throws MareException, RemoteException;
  ArrayList generarDetallesMapaCD(DTOMapaCentroDistribucionCabecera dtoe, DTOSublineaArmado sublinea, Boolean frente) throws RemoteException, MareException;
  void insertarDetallesMapaCD(ArrayList detalles) throws MareException, RemoteException;
  DTOSalida obtenerNumerosAnaquelPorMapaCD(DTOOID oidMapaCD) throws MareException, RemoteException;
  DTOSalida buscarAnaquelesExpandidos(DTOOID dtoe) throws MareException, RemoteException;
  DTOExpandirAnaquel expandirAnaquel(DTOExpandirAnaquel dtoe) throws RemoteException, MareException;
  void dividirAnaquel(DTOOIDs anaquelesDividir) throws MareException, RemoteException;
  void moverExpandir(DTOExpandirAnaquel dtoe) throws MareException, RemoteException;
  void copiarMapaCentroDistribucion(DTOMapaCentroDistribucionCabecera dtoe) throws MareException, RemoteException;

  DTOSalida obtenerMapaCDPorCDYLinea(DTOMantenerConfiguracionBalanceo dtoe) throws RemoteException, MareException;
}