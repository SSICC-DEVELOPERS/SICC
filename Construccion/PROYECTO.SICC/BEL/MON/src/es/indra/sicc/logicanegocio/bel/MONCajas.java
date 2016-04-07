package es.indra.sicc.logicanegocio.bel;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOCaja;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.bel.DTOCargaPaginaMCD;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.dtos.bel.DTOMovimientoCaja;
import es.indra.sicc.dtos.bel.DTOImportesFisicos;
import java.math.BigDecimal;
import es.indra.sicc.dtos.bel.DTOMantenimientoCaja;

public interface MONCajas extends EJBObject  {
  DTOSalida abrirCajasConsulta(DTOString dto) throws  MareException, RemoteException;

  void abrirCajas(DTOOIDs dto) throws MareException, RemoteException;

    DTOCaja obtenerDatosCaja(DTOString dto) throws MareException, RemoteException;

    void guardarMovimientoCaja(DTOMovimientoCaja dto) throws MareException, RemoteException;

    DTOCargaPaginaMCD cargaPaginaMCD(DTOOID dto) throws MareException, RemoteException;

    DTOBoolean cerrarCaja(DTOImportesFisicos dto) throws MareException, RemoteException;

    DTOSalida cerrarCajasBELC(DTOCaja dto) throws MareException, RemoteException;

    DTOSalida cerrarCajasBELCResumen(DTOCaja dto) throws MareException, RemoteException;

  Boolean cuadrarImportesMedioPago(Long medioPagoBelcenter, DTOImportesFisicos dto, Boolean divisa) throws MareException, RemoteException;

  BigDecimal obtenerImporteFisicoMedioPago(Long medioPagoBelcenter, DTOImportesFisicos dto, Boolean divisa) throws MareException, RemoteException;

  void actualizarDatos(Boolean cuadrada, DTOImportesFisicos dto) throws MareException, RemoteException;

  void generaLog(Long oidCaja, Long medioPago, Long oidMoneda, Long idioma) throws RemoteException, MareException;

  DTOSalida obtenerCajas(DTOCaja dtoin) throws MareException, RemoteException;

  DTOSalida buscarCajas(DTOMantenimientoCaja dtoEntrada) throws MareException, RemoteException;

  void eliminarCajas(DTOOIDs dtoEntrada) throws MareException, RemoteException;

  void actualizarCaja(DTOMantenimientoCaja dtoEntrada) throws RemoteException, MareException;

  DTOSalida obtenerTiposCaja(DTOOID dtoEntrada) throws MareException, RemoteException;
  
}