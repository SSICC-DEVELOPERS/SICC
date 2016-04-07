/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOBuscarGestionesDeCobranza;
import es.indra.sicc.dtos.cob.DTOGestionDeCobranza;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.cob.DTOEBuscarCompromisosPago;
import es.indra.sicc.dtos.cob.DTOUsuariosPerfil;
import es.indra.sicc.dtos.cob.DTOUsuariosCobComboPerfil;

public interface MONGestionesDeCobranza extends EJBObject 
{
  DTOSalida obtenerUsuariosCobCombo(DTOBelcorp dto) throws MareException, RemoteException;

  DTOSalida buscarGestionesDeCobranzaSB(DTOBuscarGestionesDeCobranza dto) throws MareException, RemoteException;

  DTOSalida buscarGestionesDeCobranzaPG(DTOBuscarGestionesDeCobranza dto) throws MareException, RemoteException;

  void guardarGestion(DTOGestionDeCobranza dto) throws MareException, RemoteException;

  DTOGestionDeCobranza detalleGestion(DTOOID dto) throws MareException, RemoteException;

  DTOSalida obtenerUsuariosCobComboMenos1(DTOOID dto) throws MareException, RemoteException;

    DTOSalida compromisoPago(DTOEBuscarCompromisosPago dto) throws MareException, RemoteException;

    void crearGestion(DTOGestionDeCobranza dto) throws MareException, RemoteException;

    void guardarBloqueoDesbloqueo(DTOGestionDeCobranza dto) throws MareException, RemoteException;

  DTOSalida obtenerMotivosNoCobro(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida buscarGestionesDeCobranzaTC(DTOBuscarGestionesDeCobranza dto) throws RemoteException, MareException;

  DTOUsuariosCobComboPerfil obtenerUsuariosCobComboPerfil(DTOUsuariosPerfil dtoEntrada) throws RemoteException, MareException;
  
  DTOSalida obtenerTiposBloqueo(DTOOID dto) throws RemoteException, MareException;
  
  DTOSalida obtenerBloqueoCliente(DTOGestionDeCobranza dto) throws RemoteException, MareException;
}