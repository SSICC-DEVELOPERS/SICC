/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.rec;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.ped.DTONumeroSolicitud;

import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;
import es.indra.sicc.dtos.rec.DTOBloqueoTipoOperacionREC;
import es.indra.sicc.dtos.rec.DTOBuscarClientesREC;
import es.indra.sicc.dtos.rec.DTOBuscarEnvia;
import es.indra.sicc.dtos.rec.DTOBuscarProductosDevuelveNoREC;
import es.indra.sicc.dtos.rec.DTOBuscarProductosREC;
import es.indra.sicc.dtos.rec.DTOBuscarReclamosREC;
import es.indra.sicc.dtos.rec.DTODatosClienteREC;
import es.indra.sicc.dtos.rec.DTODatosDocumentoREC;
import es.indra.sicc.dtos.rec.DTODesbloqueoRechazoREC;
import es.indra.sicc.dtos.rec.DTODetalleReclamosREC;
import es.indra.sicc.dtos.rec.DTODocumentoReferenciaREC;
import es.indra.sicc.dtos.rec.DTOGeneraOperacionREC;
import es.indra.sicc.dtos.rec.DTOReclamo;
import es.indra.sicc.dtos.rec.DTOTotalesReclamoREC;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.rec.DTOEliminaLineaOperacion;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;

import es.indra.sicc.dtos.rec.DTOIndicadoresOperacionREC;

public interface MONCapturaProcesoReclamos extends EJBObject  {
    DTOSalida obtenerClientesREC(DTOBuscarClientesREC dtoE) throws MareException, RemoteException;

    DTOSalida obtenerAsumePerdida(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerPrecioCalculo(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerProductosREC(DTOBuscarProductosREC dtoE) throws MareException, RemoteException;

    DTOOID comprobarProducto(DTOBuscarProductosREC dto) throws RemoteException, MareException;

    DTOSalida obtenerReclamosREC(DTOBuscarReclamosREC dtoE) throws MareException, RemoteException;

    DTOReclamo obtenerDetalleReclamosREC(DTODetalleReclamosREC dtoE) throws MareException, RemoteException;

    DTOSalida obtenerDocumentoREC(DTOBuscarClientesREC dto) throws MareException, RemoteException;
    
    DTOReclamo obtenerDetalleModificacionREC(DTODetalleReclamosREC dtoE) throws MareException, RemoteException;

    void eliminarOperacion()  throws RemoteException, MareException;

    DTOSalida obtenerOperacionesREC(DTOBelcorp dtoE) throws MareException, RemoteException;

    DTOSalida obtenerTiposOperacionAgregar(DTOOID dto) throws MareException, RemoteException;

    void actualizarBloqueoOperacion(Long oidOperacion) throws MareException, RemoteException;

    DTOSalida obtenerClientesIntroducir(DTOBuscarClientesREC dto) throws MareException, RemoteException;

    DTOSalida obtenerDocumentoCliente(DTOBuscarClientesREC dtoE) throws MareException, RemoteException;
    
    DTOString generarNumAtencion(DTONumeroSolicitud dto) throws MareException, RemoteException;
    
    DTOSalida obtenerCampania(DTOOID dto) throws RemoteException, MareException;
    
    DTOSalida obtenerDocumentosReferencia(DTODocumentoReferenciaREC dto) throws MareException, RemoteException;

    DTOSalida obtenerMotivosDevolucion(DTOOID dto) throws MareException, RemoteException;

    DTOSalida obtenerFechaCampania(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerSecuencial(DTOAtencionReclamoREC dto) throws MareException, RemoteException;

    void guardarReclamo(DTOReclamo dto) throws MareException, RemoteException;

    void procesarReclamo() throws MareException, RemoteException;

    void grabarCabeceraReclamo() throws MareException, RemoteException;

    DTODatosDocumentoREC obtenerDatosDocumento(Long documento) throws MareException, RemoteException;

    DTOOID obtenerUnidadAdministrativaCliente(Long cliente, Long periodo) throws MareException, RemoteException;

    DTODatosClienteREC obtenerDatosCliente(Long cliente) throws MareException, RemoteException;

    DTOSalida obtenerProductosDevuelveSi(DTOBuscarClientesREC dto) throws MareException, RemoteException;

    DTOSalida obtenerProductosCodigoVentaNo(DTOBuscarProductosDevuelveNoREC dto) throws MareException, RemoteException;

    DTOGeneraOperacionREC obtenerGeneraOperacion(DTOOID dto) throws MareException, RemoteException;

    DTOSalida obtenerProductosEnvia(DTOBuscarEnvia dto) throws MareException, RemoteException;

    DTOBloqueoTipoOperacionREC obtenerBloqueosTipo(DTOOperacionReclamo dto) throws RemoteException, MareException;

    DTOSalida obtenerTiposBloqueo(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida obtenerOperacionesDescripcion(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida obtenerMotivosRechazoDesbloqueo(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida obtenerReclamosGestion(DTOBuscarReclamosREC dto) throws MareException, RemoteException;

    void obtenerAutorizacionAcceso(DTOBuscarReclamosREC dto) throws MareException, RemoteException;

    void desbloquearReclamoGestion(DTODesbloqueoRechazoREC dto) throws MareException, RemoteException;

    DTOTotalesReclamoREC obtenerTotales(DTOOID dto) throws MareException, RemoteException;

    DTOSalida obtenerLineasOperacion(DTOOIDPaginado dto) throws MareException, RemoteException;

    DTOSalida obtenerOperacionesReclamo(DTOBuscarReclamosREC dto) throws MareException, RemoteException;

    void rechazarReclamoGestion(DTODesbloqueoRechazoREC dto) throws MareException, RemoteException;

    void generarSolicitudes(DTOAtencionReclamoREC dtoE) throws MareException, RemoteException;

    void generarMensajes(DTOOID dto,String numeroRecojo) throws RemoteException, MareException;

    DTOBoolean validarPerdida(DTOOID dto) throws RemoteException, MareException;

    DTOSalida obtenerProductosCodigoVentSi(DTOBuscarProductosDevuelveNoREC dto) throws MareException, RemoteException;

    DTOTotalesReclamoREC actualizarReclamo(DTOReclamo dto) throws RemoteException, MareException;

    void grabarLinea(int i, int j) throws MareException, RemoteException;

   void actualizarRegistros(DTOEliminaLineaOperacion dto) throws RemoteException, MareException;

   void grabarOperacion(int i) throws MareException, RemoteException;

   void bloquearReclamo(DTOAtencionReclamoREC dtoE) throws MareException, RemoteException;

    DTOSalida validarReclamoAnulacion(DTOReclamo dtoE) throws RemoteException, MareException;

    DTOSalida obtenerIndicadorAnulacionOperacionesREC(DTOBelcorp dto) throws MareException, RemoteException;
    
    DTOIndicadoresOperacionREC obtenerIndicadoresOperacion(DTOIndicadoresOperacionREC dto) throws MareException, RemoteException;
    
    Long crearBoletaRecojo(DTOAtencionReclamoREC dtoE)  throws MareException, RemoteException;
    
  
}