package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.dtos.ape.DTOBuscarAnaqueles;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesCabeceraDetalles;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesCabecera;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesDetalle;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionDetalle;
import es.indra.sicc.dtos.ape.DTOCopiaOrdenAnaqueles;

public interface MONMantenimientoOrdenAnaqueles extends EJBObject  {

  DTOSalida obtenerNroAnaquelesAOrdenar(DTOMapaCentroDistribucionDetalle dtoE) throws MareException, RemoteException;

  void actualizarOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabeceraDetalles DTOE) throws MareException, RemoteException;

  Long actualizarOrdenAnaquelesCabecera(DTOOrdenAnaquelesCabecera DTOE) throws MareException, RemoteException;

  void actualizarOrdenAnaquelesDetalle(DTOOrdenAnaquelesDetalle DTOE) throws MareException, RemoteException;

  DTOOrdenAnaquelesCabeceraDetalles obtenerOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabecera dtoE) throws MareException, RemoteException;

  DTOSalida obtenerMapasOrdenPorMapaZonas(DTOOID dtoE) throws MareException, RemoteException;

  void eliminarOrdenAnaquelesCabeceraDetalles(DTOOrdenAnaquelesCabeceraDetalles dtoE) throws MareException, RemoteException;

  DTOOrdenAnaquelesCabecera obtenerDefaultOrdenAnaqueles(DTOOID dtoE) throws MareException, RemoteException;

  void copiarOrdenAnaqueles(DTOCopiaOrdenAnaqueles dtoe) throws RemoteException, MareException;

  DTOSalida obtenerNumerosAnaquelesAOrdenar(DTOBuscarAnaqueles dtoE) throws MareException, RemoteException;
}