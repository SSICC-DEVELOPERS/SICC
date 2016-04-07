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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
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
import es.indra.sicc.dtos.rec.DTOEliminaLineaOperacion;
import es.indra.sicc.dtos.rec.DTOGeneraOperacionREC;
import es.indra.sicc.dtos.rec.DTOIndicadoresOperacionREC;
import es.indra.sicc.dtos.rec.DTOLineaOperacion;
import es.indra.sicc.dtos.rec.DTOOperacion;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;
import es.indra.sicc.dtos.rec.DTOReclamo;
import es.indra.sicc.dtos.rec.DTOTotalesReclamoREC;
//import es.indra.sicc.entidades.bel.OperacionesLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocal;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocalHome;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocal;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocalHome;
import es.indra.sicc.entidades.rec.OperacionReclamoLocal;
import es.indra.sicc.entidades.rec.OperacionReclamoLocalHome;
import es.indra.sicc.entidades.rec.OperacionesLocal;
import es.indra.sicc.entidades.rec.OperacionesLocalHome;
import es.indra.sicc.entidades.rec.SolicitudesOperacionLocalHome;
import es.indra.sicc.entidades.rec.TiposBloqueoLocal;
import es.indra.sicc.entidades.rec.TiposBloqueoLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacen;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenHome;
import es.indra.sicc.logicanegocio.rec.MONActualizarEstadoReclamos;
import es.indra.sicc.logicanegocio.rec.MONActualizarEstadoReclamosHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.ped.MONDigitacionInicialLocal;
import es.indra.sicc.logicanegocio.ped.MONDigitacionInicialLocalHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitud;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitudHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

//import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCapturaProcesoReclamosBean implements SessionBean  {
    
    private DTOReclamo datosReclamo;
    // vbongiov -- SiCC 20090852 -- 6/03/2009
    private int decimales;
    
    private SessionContext ctx;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }
    
    public DTOSalida obtenerClientesREC(DTOBuscarClientesREC dtoE) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerClientesREC(DTOBuscarClientesREC):Entrada"); 
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(dao.obtenerClientesREC(dtoE));
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerClientesREC(DTOBuscarClientesREC):Salida"); 
        return dtoS;
    }

    public DTOSalida obtenerAsumePerdida(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerAsumePerdida(DTOBelcorp):Entrada"); 
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(dao.obtenerAsumePerdida(dtoE));
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerAsumePerdida(DTOBelcorp):Salida"); 
        return dtoS;
    }

    public DTOSalida obtenerPrecioCalculo(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerPrecioCalculo(DTOBelcorp):Entrada"); 
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(dao.obtenerPrecioCalculo(dtoE));
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerPrecioCalculo(DTOBelcorp):Salida"); 
        return dtoS;
    }

    public DTOSalida obtenerProductosREC(DTOBuscarProductosREC dtoE) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosREC(DTOBuscarProductosREC):Entrada"); 
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(dao.obtenerProductosREC(dtoE));
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosREC(DTOBuscarProductosREC):Salida"); 
        return dtoS;
    }

    
    public DTOOID comprobarProducto(DTOBuscarProductosREC dto) throws MareException {
        // BELC300014263
        UtilidadesLog.info("MONCapturaProcesoReclamos.comprobarProducto(DTOBuscarProductosREC):Entrada"); 
        MaestroProductosLocalHome maestroProductosLH = this.getMaestroProductosLocalHome();
        MaestroProductosLocal maestroProductos;
        DTOOID dtoOid = new DTOOID();
        try{
            maestroProductos = maestroProductosLH.findByUK(dto.getOidPais(), dto.getCodigoProducto());
            dtoOid.setOid(maestroProductos.getOid());
        } catch (FinderException ex){
            UtilidadesLog.error("comprobarProducto: FinderException MaestroProducti", ex);
            //String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            //throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONCapturaProcesoReclamos.comprobarProducto(DTOBuscarProductosREC):Salida"); 
        return dtoOid;
    }

    public DTOSalida obtenerReclamosREC(DTOBuscarReclamosREC dtoE) throws MareException {
       UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerReclamosREC(DTOBuscarProductosREC):Entrada"); 
        DTOSalida dtoSalida = new DTOSalida();
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();

        dtoSalida.setResultado(dao.obtenerReclamosREC(dtoE));

        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerReclamosREC(DTOBuscarProductosREC):Salida"); 
        return dtoSalida;
    }

    public DTOReclamo obtenerDetalleReclamosREC(DTODetalleReclamosREC dtoE) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDetalleReclamosREC(DTOBuscarProductosREC):Entrada"); 
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTOReclamo dtoS = new DTOReclamo();
        dtoS = dao.obtenerDetalleReclamosREC(dtoE);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDetalleReclamosREC(DTOBuscarProductosREC):Salida"); 
        return dtoS;
    }

    // 14497
    public DTOSalida obtenerDocumentoREC(DTOBuscarClientesREC dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDocumentoREC(DTOBuscarClientesREC ):Entrada"); 
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTOSalida dtoS = new DTOSalida();        
        dtoS.setResultado(dao.obtenerDocumento(dto));
        UtilidadesLog.info(" dtoS.getResultado " + dtoS.getResultado());
      
        if (dtoS==null || dtoS.getResultado() ==null || dtoS.getResultado().esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.info("****DAOCapturaProcesoReclamos.obtenerDocumentoReferencia: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
        } 
        
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDocumentoREC(DTOBuscarClientesREC ):Salida");
        return dtoS;
    }
    
    public DTOReclamo obtenerDetalleModificacionREC(DTODetalleReclamosREC dtoE) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDetalleModificacionREC(DTODetalleReclamosREC):Entrada"); 
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos(ctx.getCallerPrincipal().getName());
        DTOReclamo dtoR = new DTOReclamo();
        dtoR.setOperaciones(dao.obtenerDetalleModificacionREC(dtoE));
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDetalleModificacionREC(DTODetalleReclamosREC):Salida"); 
        return dtoR;
    }

    public void eliminarOperacion() throws MareException {
        //BELC300015140
        UtilidadesLog.info("MONCapturaProcesoReclamos.eliminarLineaOperacion(DTOEliminaLineaOperacion):Entrada"); 
        
        LineasOperacionReclamoLocalHome lorLH = new LineasOperacionReclamoLocalHome();        
        OperacionReclamoLocalHome orLH = new OperacionReclamoLocalHome();
        OperacionReclamoLocal operacionReclamo = null;
        
        
        for (int l=0 ;l<datosReclamo.getOperacionesAEliminar().size() ;l++ )  {
            Long oidE =(Long)datosReclamo.getOperacionesAEliminar().get(l);
                Collection lineas = null;
                try {
                    lineas = lorLH.findByOperacion(oidE);
                } catch (NoResultException ex) {
                    UtilidadesLog.error("MONCapturaProcesoReclamos.eliminarLineasOperacion: FinderException", ex);
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                }catch (PersistenceException re){
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                }
                Iterator itLineas = lineas.iterator();
                
                while (itLineas.hasNext()){
                    LineasOperacionReclamoLocal lineaOperacion = (LineasOperacionReclamoLocal)itLineas.next();
                    try {
                        
                        lorLH.remove(lineaOperacion);
                    } catch (PersistenceException re){
                        UtilidadesLog.error("MONCapturaProcesoReclamos.eliminarLineaOperacion: RemoveException de LineasOperacionReclamo", re);
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                    }
                }
                
                try{
                    operacionReclamo = orLH.findByPrimaryKey(oidE);
                } catch (NoResultException ex){
                    UtilidadesLog.error("MONCapturaProcesoReclamos.eliminarLineaOperacion: FinderException-> OperacionReclamo", ex);
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                } catch (PersistenceException re){
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                }
                
                try{
                    orLH.remove(operacionReclamo);
                    
                } catch (PersistenceException re){
                    UtilidadesLog.error("MONCapturaProcesoReclamos.eliminarLineaOperacion: RemoveException de OperacionReclamo", re);
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                }
                
          }
        
        
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.eliminarLineaOperacion(DTOEliminaLineaOperacion):Salida"); 
        
    }

 
   // incidencias BELC300014384 y BELC300014385
   // cuando implantaron la BELC300014384 enviaron un nuevo diseño del metodo
   // pero luego implantaron la BELC300014385 y enviaron otro diseño del metodo
   public void actualizarRegistros(DTOEliminaLineaOperacion dto) throws MareException {
   
      UtilidadesLog.info("MONCapturaProcesoReclamos.actualizarRegistros(DTOEliminaLineaOperacion):Entrada"); 

      // - Linea = hacer un findByPK sobre REC:LineasOperacionReclamo, enviando el dto.oid recibido
      // como entrada al metodo
      /*LineasOperacionReclamoLocal linea = null;
      try {
         linea = this.getLineasOperacionReclamoLocalHome().findByPrimaryKey(dto.getOidLinea()); 
      } catch (FinderException ex) {
         UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarRegistros: FinderException", ex);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }
      
      // - operacion = Linea.operacion
      OperacionReclamoLocal operacion = null;
      try {
         operacion = this.getOperacionReclamoLocalHome().findByPrimaryKey(linea.getOperacion()); 
      } catch (FinderException ex) {
         UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarRegistros: FinderException", ex);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }
      
      // - Reclamo = Operacion.numAtencion
      CabeceraReclamoLocal reclamo = null;
      try {
         reclamo = this.getCabeceraReclamoLocalHome().findByUK(operacion.getNumeroAtencion(), dto.getOidPais());
      } catch (FinderException ex) {
         UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarRegistros: FinderException", ex);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }

      // - con Reclamo.numeroDocumentoReferencia llamar al metodo del
      // DAOCapturaProcesoReclamos.obtenerDatosSolicitud(solicitud:Long):RecordSet
      //   - Recuperar del recordSet devuelto la marca, el pais y el canal
      RecordSet rs = new DAOCapturaProcesoReclamos().obtenerDatosSolicitud(reclamo.getNumeroDocumentoReferencia());

      //  - periodoActual = Llamar al metodo 'obtienePeriodoActual(pais : Long, marca : Long, canal : Long)
      // : DTOPeriodo' de la interfaz IPeriodos con el pais activo y la marca y canal del reclamo recibidos
      Long pais = new Long(((BigDecimal)rs.getValueAt(0, "PAIS")).longValue());
      Long marca = new Long(((BigDecimal)rs.getValueAt(0, "MARCA")).longValue()); 
      Long canal = new Long(((BigDecimal)rs.getValueAt(0, "CANAL")).longValue());
      DTOPeriodo periodoActual = null;
      try {
         periodoActual = this.getMONPeriodos().obtienePeriodoActual(pais, marca, canal);
      } catch (RemoteException e) {
         ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarRegistros: RemoteException", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }      

      //    - operacion.periodoReclamo = periodoActual.oid
      operacion.setPeriodoReclamo(periodoActual.getOid());

      //    - reclamo.periodoReclamo = periodoActual.oid
      reclamo.setPeriodoReclamo(periodoActual.getOid());
      //    - reclamo.totalEnvia = valor de lbEnviaTotal recibido de pantalla
      reclamo.setTotalEnvia(dto.getTotalEnvia());
      //    - reclamo.totalDevuelve = valor de lbDevuelveTotal recibido de pantalla
      reclamo.setTotalDevuelve(dto.getTotalDevuelve());
      //    - reclamo.saldoPagar = diferencia de los dos anteriores       
      reclamo.setSaldoPagar(dto.getTotalEnvia().add(dto.getTotalDevuelve().negate()));
        */ 
      UtilidadesLog.info("MONCapturaProcesoReclamos.actualizarRegistros(DTOEliminaLineaOperacion):Salida"); 
   }   

   public DTOSalida obtenerOperacionesREC(DTOBelcorp dtoE) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerOperacionesREC(DTOBelcorp):Entrada"); 
      RecordSet rs = new DAOCapturaProcesoReclamos(ctx).obtenerOperaciones(dtoE);
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerOperacionesREC(DTOBelcorp):Salida"); 
      return new DTOSalida(rs);
   }

   public DTOSalida obtenerTiposOperacionAgregar(DTOOID dto) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerTiposOperacionAgregar(DTOOID):Entrada"); 
      RecordSet rs = new DAOCapturaProcesoReclamos(ctx).obtenerTipoOperacion(dto);
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerTiposOperacionAgregar(DTOOID):Salida"); 
      return new DTOSalida(rs);
   }

   public void actualizarBloqueoOperacion(Long oidOperacion) throws MareException {
		UtilidadesLog.info("MONCapturaProcesoReclamos.actualizarBloqueoOperacion(Long):Entrada"); 
      
      OperacionReclamoLocal local = null;
      OperacionReclamoLocalHome opera = new OperacionReclamoLocalHome();
      
      try {
         local = opera.findByPrimaryKey(oidOperacion);
      } catch (NoResultException fe) {
         UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarBloqueoOperacion: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
          ctx.setRollbackOnly();
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }catch (PersistenceException re){
              ctx.setRollbackOnly();
              String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
      }
      local.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_BLOQUEO);
      opera.merge(local);
      UtilidadesLog.info("MONCapturaProcesoReclamos.actualizarBloqueoOperacion(Long):Salida"); 
    }

    public DTOSalida obtenerClientesIntroducir(DTOBuscarClientesREC dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerClientesIntroducir(DTOBuscarClientesREC):Entrada"); 
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(dao.obtenerClientesIntroducir(dto));
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerClientesIntroducir(DTOBuscarClientesREC):Salida"); 
        return dtoS;
    }

    public DTOSalida obtenerDocumentoCliente(DTOBuscarClientesREC dtoE) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDocumentoCliente(DTOBuscarClientesREC):Entrada"); 
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerDocumentoCliente(dtoE);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDocumentoCliente(DTOBuscarClientesREC):Salida"); 
        return new DTOSalida(rs);
    }
    
    public DTOString generarNumAtencion(DTONumeroSolicitud dto) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.generarNumAtencion(DTONumeroSolicitud):Entrada"); 
      
      // Llamar al método "generaNumeroDocumento()" de la interfaz 
      // IGenerarNumeroDocumento del modulo PED, pasandole como entrada el DTO generado 
      
      /*String numDocumento = null;
       
      try {
         numDocumento = this.getMONProcesoPED().generaNumeroDocumento(dto);
      } catch (RemoteException e) {
         ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         UtilidadesLog.error("MONCapturaProcesoReclamos.generarNumAtencion: RemoteException", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }      

      
      // Devolver respuesta a llamada anterior 
      DTOString devolucion = new DTOString();
      devolucion.setCadena(numDocumento);
      
      UtilidadesLog.info("MONCapturaProcesoReclamos.generarNumAtencion(DTONumeroSolicitud):Salida"); 
      return devolucion;
      
      */
        //jrivas 31/3/09 20090870 
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT ("); 
        query.append(" SELECT COD_PAIS"); 
        query.append(" FROM SEG_PAIS"); 
        query.append(" WHERE OID_PAIS = ").append(dto.getOidPais());
        query.append(" ) COD_PAIS,"); 
        query.append(" ("); 
        query.append(" SELECT COD_SBAC"); 
        query.append(" FROM SEG_SUBAC"); 
        query.append(" WHERE OID_SBAC = ").append(dto.getOidSubacceso());
        query.append(" ) COD_SBAC"); 
        query.append(" FROM DUAL");
        
        RecordSet rs = null;
        
        rs = UtilidadesBD.executeQuery(query.toString());
        ArrayList arrayParametros = new ArrayList();
        
        arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_PAIS")));

        if (rs.getValueAt(0, "COD_SBAC") != null) {
            arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_SBAC")));
        } else {
            arrayParametros.add("_");
        }
        
        arrayParametros.add(dto.getOperacion());
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Date currentYear = new Date( System.currentTimeMillis());
        String yy = sdf.format(currentYear);
        arrayParametros.add(new Integer(yy));
        
        String numeroSolicitud = null;
        try {
            numeroSolicitud = this.getMONDigitacionInicialLocal().ejecutarFuncionGeneraNumeros(arrayParametros);
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR al localizar un componente EJB",ne);
            throw new MareException(ne);
        }
        
        StringBuffer numeroFormateado = new StringBuffer();
        numeroFormateado.append(cerosIzq(yy.toString(), 2));
        numeroFormateado.append(cerosIzq(numeroSolicitud, 8));
        
        UtilidadesLog.debug("MONCapturaProcesoReclamos.generarNumAtencion = " + numeroFormateado); 
        
        // Devolver respuesta a llamada anterior 
        DTOString devolucion = new DTOString();
        devolucion.setCadena(numeroFormateado.toString());
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.generarNumAtencion(DTONumeroSolicitud):Salida"); 
        return devolucion;      
    }
    
    //jrivas 31/3/09 20090870
    private String cerosIzq(String cadenaEntrada, int cantidadCeros) {
        UtilidadesLog.info("MONDigitacionInicialBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Entrada ");
        StringBuffer cadenaSalida = new StringBuffer("");
        for(int i=0; i < cantidadCeros - cadenaEntrada.length() ;i++) {
            cadenaSalida.append("0");
        }
        UtilidadesLog.info("MONDigitacionInicialBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Salida ");
        return cadenaSalida.append(cadenaEntrada.toString()).toString();
    }    
    
    // BELC300014350
    public DTOSalida obtenerCampania(DTOOID dto) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerCampania(DTOOID):Entrada"); 
      RecordSet rs = new DAOCapturaProcesoReclamos().obtenerCampaña(dto);
      DTOSalida dtoSalida = new DTOSalida();
      dtoSalida.setResultado(rs);
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerCampania(DTOOID):Salida"); 
      return dtoSalida;
   }
    
   public DTOSalida obtenerDocumentosReferencia(DTODocumentoReferenciaREC dto) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDocumentosReferencia(DTODocumentoReferenciaREC):Entrada"); 
      
      /*Llamar al método "DAOCapturaProcesoReclamos.obtenerDocumentoReferencia(dto : DTODocumentoReferencia) : RecordSet " 
      -> devolver respuesta a llamada anterior */
      
      RecordSet rs = new DAOCapturaProcesoReclamos().obtenerDocumentoReferencia(dto);
        
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDocumentosReferencia(DTODocumentoReferenciaREC):Salida"); 
      return new DTOSalida(rs);
   }

    /** 
     * Método para obtener los motivos de devolución de un pais
     * @param dto DTOBelcorp con los criterios de pais e idioma
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public DTOSalida obtenerMotivosDevolucion(DTOOID dto) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerMotivosDevolucion(DTOBelcorp):Entrada"); 
      
      /*Llamar al método "DAOCapturaProcesoReclamos.obtenerMotivosDevolucion(dto : DTOBelcorp) : RecordSet " 
      -> devolver respuesta a llamada anterior */
      
      RecordSet rs = new DAOCapturaProcesoReclamos().obtenerMotivosDevolucion(dto);
      
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerMotivosDevolucion(DTOBelcorp):Salida"); 
      return new DTOSalida(rs);

    }
    
   public DTOSalida obtenerFechaCampania(DTOOID dto) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerFechaCampania(DTOOID):Entrada"); 
      // Llamar al método "DAOCapturaProcesoReclamos.obtenerFechaCampaña(dto : DTOOID) : Long " 
      Long numerodias = new DAOCapturaProcesoReclamos().obtenerFechaCampania(dto);
      
      if (numerodias == null) numerodias = new Long(0);
      // Recuperar valor devuelto 
      // numerodias = valor recuperado 
      // fechaFiltro = fecha del sistema - numerodias 
      Date fechaFiltro = UtilidadesFecha.minusDays(new Date(System.currentTimeMillis()), numerodias.intValue());
      
      // Encapsular valor calculado en paso anterior en dto de salida
      DTOSalida salida = new DTOSalida();
      RecordSet rs = new RecordSet();

      Vector v = new Vector();
      v.add("FECHA");

      rs.setColumnIdentifiers(v);

      v = new Vector();
      v.add(fechaFiltro);
      rs.addRow(v);
      
      salida.setResultado(rs);                  
      
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerFechaCampania(DTOOID):Salida");
      return salida;    
   }

   public DTOSalida obtenerSecuencial(DTOAtencionReclamoREC dto) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerSecuencial(DTOAtencionReclamoREC):Entrada");
      
      // Llamar al método "DAOCapturaProcesoReclamos.obtenerSecuencialOperacion(dto : DTOAtencionReclamoREC) : RecordSet " 
      RecordSet rs = new DAOCapturaProcesoReclamos().obtenerSecuencialOperacion(dto);
      // secuencial = valor del ultimo registro del RecordSet obtenido en llamada anterior 
      Integer secuencial = new Integer(0);
      if (!rs.esVacio() && rs.getValueAt(rs.getRowCount() - 1, 0) != null)
        secuencial = new Integer(((BigDecimal)rs.getValueAt(rs.getRowCount() - 1, 0)).intValue());   
      
      // Devolver DTOSalida, que contendra encapsulado el valor (secuencial + 1)      
      secuencial = new Integer(secuencial.intValue() + 1);
      
      DTOSalida salida = new DTOSalida();
      rs = new RecordSet();
      Vector v = new Vector();
      Vector columnas = new Vector();
      columnas.add("secuencial");

      v.add(secuencial);

      rs.setColumnIdentifiers(columnas);
      rs.addRow(v);
      
      salida.setResultado(rs);                  

      UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerSecuencial(DTOAtencionReclamoREC):Salida");
      return salida;
   }
    
    public void guardarReclamo(DTOReclamo dto) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.guardarReclamo(DTOReclamo):Entrada");
      UtilidadesLog.debug("DTOReclamo: " + dto);
      try{
          // vbongiov -- SiCC 20090852 -- 6/03/2009
          this.datosReclamo = dto;       
          DAOCapturaProcesoReclamos daoCapturaProcesoReclamos= new DAOCapturaProcesoReclamos();
          
          this.decimales = daoCapturaProcesoReclamos.obtenerDecimalesMonedaPais(datosReclamo.getOidPais());      
           
          // Asignar el dto de entrada a la propiedad "datosReclamo" de este MON 
          // Llamar al método "procesarReclamo()"
          if(dto.getOidReclamo()!=null){
            this.actualizarReclamo(dto);
          }else{
            this.procesarReclamo();
          }
      }catch (Exception e) {
          ctx.setRollbackOnly();
                    e.printStackTrace();
                     throw new MareException(e);
      }   
      UtilidadesLog.info("MONCapturaProcesoReclamos.guardarReclamo(DTOReclamo):Salida");
    }

   // BELC300014315 resuelta
   public void procesarReclamo() throws MareException {
      
      UtilidadesLog.info("MONCapturaProcesoReclamos.procesarReclamo():Entrada");

      // Si DTOReclamo.oidReclamo <> NULL { 
      if (this.datosReclamo.getOidReclamo() == null) {
         // -> Llamar al metodo grabarCabeceraReclamo() } 
         this.grabarCabeceraReclamo();
      }
      
      DTOOperacionReclamo dtoOperRec = null;
      DTOLineaOperacion dtoLinOper = null;
      DTOMovimientoAlmacenDetalle dtoMovAlmDetalle = null;
      
      RecordSet rs = null;
      
      DAOCapturaProcesoReclamos daoCapProcRec = new DAOCapturaProcesoReclamos();

      ArrayList detalles = new ArrayList();

      ArrayList operaciones = this.datosReclamo.getOperaciones();
      ArrayList lineas = null;
      
       UtilidadesLog.debug("operaciones: " + operaciones);

      //Cambio 20080765
      //HashMap prodNoRecogibles = this.obtenerNoRecogibles(this.datosReclamo.getOidPais(), this.datosReclamo.getPeriodoReclamo());
      //-Cambio 20080765
      // -> Recorrer el arrayList "datosReclamo.operaciones" 
      for (int i=0; i < operaciones.size(); i++) {
      
         // -> Para cada elemento DTOOperacionReclamo contenido en el array hacer: 
         dtoOperRec = (DTOOperacionReclamo)operaciones.get(i);
         
          UtilidadesLog.debug("dtoOperRec: " + dtoOperRec);
         
         // - Llamar al método grabarOperacion(I : int) pasando como parametro la posicion del objeto en el array 
         this.grabarOperacion(i);
         
         // - Recorrer el arrayList "datosReclamo.operaciones.lineas" 

         lineas = dtoOperRec.getLineas();
         
         for (int j=0; j < lineas.size(); j++) {
            
            // - Para cada elemento DTOLineaOperacion contenido en el array hacer: 
            dtoLinOper = (DTOLineaOperacion)lineas.get(j);
            
             UtilidadesLog.debug("dtoLinOper: " + dtoLinOper);
            
            // - Llamar al método grabarLinea(J : int) pasando como parametro la posicion del objeto en el array 
            this.grabarLinea(i,j);
            
            // - Si (dtoLineaOperacion.tipoMovimiento = ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE) y (dtoLineaOperacion.unidadesDevueltas<>0) { 
            if (dtoLinOper.getOidTipoMovimiento() != null
               && dtoLinOper.getOidTipoMovimiento().compareTo(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE) == 0 
               && dtoLinOper.getUnidadesDevueltas().intValue() != 0) 
            {
               // Llamar al metodo DAOCapturaProcesoReclamos.obtenerAlmacenOperacion( operacion:Long ) : RecordSet 
               DTOOID dtoi = new DTOOID();
               dtoi.setOid(dtoLinOper.getOperacion());
               dtoi.setOidPais(datosReclamo.getOidPais());
               dtoi.setOidIdioma(datosReclamo.getOidIdioma());
               rs = daoCapProcRec.obtenerAlmacenOperacion(dtoi);
               
                UtilidadesLog.debug("rs: " + rs);
               
               if (! rs.esVacio()) { 
               
                  for (int k=0; k < rs.getRowCount(); k++) {
                     // Crear un dto de tipo DTOMovimientoAlmacenDetalle: 
                     dtoMovAlmDetalle = new DTOMovimientoAlmacenDetalle();
            
                     dtoMovAlmDetalle.setOidIdioma(datosReclamo.getOidIdioma());
                     dtoMovAlmDetalle.setOidPais(datosReclamo.getOidPais());
                     // dto.oidAlmacenSalida = almacen devuelto en el recordSet 
                     //Cambio 20080765 - Boolean grabar = Boolean.TRUE;
                     
                     if(rs.getValueAt(k, "IND_RECO").toString().equals("1")){
                       if(rs.getValueAt(k, "ALMC_OID_ALMA_POSV")!=null){
                          dtoMovAlmDetalle.setOidAlmacenSalida(new Long(((BigDecimal)rs.getValueAt(k, "ALMC_OID_ALMA_POSV")).longValue()));
                       }
                        if(rs.getValueAt(k, "TMAL_OID_TIPO_ALMA_REC_INIC")!=null){
                          dtoMovAlmDetalle.setOidTipoMovimientoAlmacen(new Long(((BigDecimal)rs.getValueAt(k, "TMAL_OID_TIPO_ALMA_REC_INIC")).longValue()));
                       }
                       /*Cambio 20080765
                        if( prodNoRecogibles.get(dtoLinOper.getOidTpoOferta())!=null){
                           grabar = Boolean.FALSE;
                        }
                        if( prodNoRecogibles.get(dtoLinOper.getOidPremio())!=null){
                           grabar = Boolean.FALSE;
                        }
                        *///-Cambio 20080765
                      }else{
                       if(rs.getValueAt(k, "ALMACEN")!=null){
                          dtoMovAlmDetalle.setOidAlmacenSalida(new Long(((BigDecimal)rs.getValueAt(k, "ALMACEN")).longValue()));
                       }
                     
                       // dto.oidMovimientoCabecera = movimientoAlmacen devuelto en recordSet 
                       if(rs.getValueAt(k, "MOVIMIENTOALMACEN")!=null){
                          dtoMovAlmDetalle.setOidTipoMovimientoAlmacen(new Long(((BigDecimal)rs.getValueAt(k, "MOVIMIENTOALMACEN")).longValue()));
                       }
                     }
                     // dto.oidTipoOferta = DTOLineaOperacion.oidTipoOferta 
                     dtoMovAlmDetalle.setOidTipoOferta(dtoLinOper.getOidTpoOferta());
                     // dto.oidProducto = DTOLineaOperacion.oidCodProducto 
                     dtoMovAlmDetalle.setOidProducto(dtoLinOper.getOidCodProducto());
                     // dto.cantidad = DTOLineaOperacion.unidadesDevueltas 
                     if(dtoLinOper.getUnidadesDevueltas()!=null){
                        dtoMovAlmDetalle.setCantidad(new Long(dtoLinOper.getUnidadesDevueltas().longValue()));    
                     }
                     
                     dtoMovAlmDetalle.setNumeroDocumentoReferencia(this.datosReclamo.getNumeroDocumentoReferencia());    
                     // dto.operacion = 'REC034' 
                     dtoMovAlmDetalle.setOperacion("REC034");
                     //Cambio 20080765 -if(grabar.booleanValue()){
                        detalles.add(dtoMovAlmDetalle);
                     //-Cambio 20080765 -}
                  }

               }
            } 
         } // - FinPara // linea 
      
         // -> Si se ha creado algun DTOMovimientoAlmacenDetalle { 
         if (detalles.size() > 0) {
            // Por Incidencia 14497 se cambia el DTO de entrada a DAOCapturaProcesoReclamos.obtenerDocumentoREC
            // Llamar a DAOCapturaProcesoReclamos.obtenerDocumentoREC(dto : DTOOID ) : RecordSet con DTOReclamo.oidDocumentoReferencia 
            DTOBuscarClientesREC dtoBuscCliREC = new DTOBuscarClientesREC();
            dtoBuscCliREC.setNumDocumento(this.datosReclamo.getNumeroDocumentoReferencia());
            dtoBuscCliREC.setOidCliente(this.datosReclamo.getOidCliente());
            dtoBuscCliREC.setOidPais(this.datosReclamo.getOidPais());
            dtoBuscCliREC.setOidIdioma(this.datosReclamo.getOidIdioma());
            
            rs = daoCapProcRec.obtenerDocumento(dtoBuscCliREC);         
            
            if (! rs.esVacio()) {
   
               Long periodo = null;
               Long marca = null;
               
               for (int j=0; j < rs.getRowCount(); j++) {
                  if(rs.getValueAt(j, "OIDPERIODO")!=null){           
                    periodo = new Long(((BigDecimal)rs.getValueAt(j, "OIDPERIODO")).longValue());
                  }
                  // con pais oidPeriodo recuperado del recordSet , hacer un 'findByPrimaryKey' sobre CRA:Periodo, y obtener la marca 
                  try {
                     PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
                     marca = periodoLocalHome.findByPrimaryKey(periodo).getOidMarca();
                  } catch (NoResultException fe) {
                     UtilidadesLog.error("MONCapturaProcesoReclamos.procesarReclamo: FinderException", fe);
                      ctx.setRollbackOnly();
                     String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                     throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                  }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }               
                                       
                  // Crear un DTOMovimientoAlmacenCabecera: 
                  DTOMovimientoAlmacenCabecera dtoMovAlmCab = new DTOMovimientoAlmacenCabecera();
                  dtoMovAlmCab.setOidIdioma(datosReclamo.getOidIdioma());
                  dtoMovAlmCab.setOidPais(datosReclamo.getOidPais());
                  // dto.oidMarca = oidMarca obtenido 
                  dtoMovAlmCab.setOidMarca(marca);
                  // dto.oidCanal = oidCanal recuperado del recordSet 
                  if(rs.getValueAt(j, "OIDCANAL")!=null){
                    dtoMovAlmCab.setOidCanal(new Long(((BigDecimal)rs.getValueAt(j, "OIDCANAL")).longValue()));
                  }
                  // dto.oidAcceso = oidAcceso recuperado del recordSet
                  if(rs.getValueAt(j, "OIDACCESO")!=null){
                    dtoMovAlmCab.setOidAcceso(new Long(((BigDecimal)rs.getValueAt(j, "OIDACCESO")).longValue()));
                  }
                  // dto.oidSubacceso = oidSubacceso recuperado del recordSet 
                  if(rs.getValueAt(j, "OIDSUBACCESO")!=null){
                    dtoMovAlmCab.setOidSubacceso(new Long(((BigDecimal)rs.getValueAt(j, "OIDSUBACCESO")).longValue()));
                  }// dto.oidPeriodo = oidPeriodo recuperado del recordSet 
                  dtoMovAlmCab.setOidPeriodo(periodo);
                  // dto.fecha = fecha actual recuperado del recordSet 
                  dtoMovAlmCab.setFecha(new Date(System.currentTimeMillis()));
                  // Crear un DTOMovimientoAlmacen con el DTOCabecera y los CTODetalle creados 
                  
                  
                  DTOMovimientoAlmacen dtoMovAlm = new DTOMovimientoAlmacen();
                  dtoMovAlm.setCabecera(dtoMovAlmCab);
                  dtoMovAlm.setDetalle(detalles);
                  dtoMovAlm.setOidPais(this.datosReclamo.getOidPais());
                  dtoMovAlm.setOidIdioma(this.datosReclamo.getOidIdioma());
                  // invocar CU Generar Movimiento Almacen 
                  // Con el dto credo llamar al metodo grabarMovimientoAlmacenYStock(dto : DTOMovimientoAlmacen) : DTOReportePedidos de la interfaz IGenerarMovimientoAlmacen 
                  try {
                     this.getMONGenerarMovimientoAlmacen().grabarMovimientoAlmacenYStock(dtoMovAlm);
                  } catch (RemoteException e) {
                     ctx.setRollbackOnly();
                     String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                     UtilidadesLog.error("MONCapturaProcesoReclamos.procesarReclamo: RemoteException", e);
                     throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
                  }      
               }
            }
         }
      } // -> FinPara // operacion   
      
      UtilidadesLog.info("MONCapturaProcesoReclamos.procesarReclamo():Salida");
   }
    
    // BELC300014318 resuelta
    public void grabarCabeceraReclamo() throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.grabarCabeceraReclamo():Entrada");
        // Recuperar datos del documento de referencia 
 
        
        DTODatosDocumentoREC dtoDatosDR = new DTODatosDocumentoREC();
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        dtoDatosDR = dao.obtenerDatosDocumento(datosReclamo.getOidDocumentoReferencia());
        datosReclamo.setFechaDocumentoReferencia((java.sql.Date) dtoDatosDR.getFecha());
        datosReclamo.setPeriodoDocumentoReferencia(new Long(dtoDatosDR.getPeriodo()));
        datosReclamo.setTipoDocumento(dtoDatosDR.getOidTipoDocumento());
                
        this.validaAcceso(dtoDatosDR.getOidPais(),null,dtoDatosDR.getOidMarca(),dtoDatosDR.getOidCanal(),null,null,null,null,null,null,null);

        // Modificado por HRCS - Fecha 08/03/20007 - Cambio SICC-GCC-REC-007-Periodo de Reclamo_V3   
        // El periodo reclamo debe venir de la pagina, si no llega, se pone el periodo actual.
        if (datosReclamo.getPeriodoReclamo()==null) {
            //  Obtiene el periodo actual
            DTOPeriodo dtoPeriodo = null;
            try{  
                dtoPeriodo = this.getMONPeriodos().obtienePeriodoActual( dtoDatosDR.getOidPais()
                                                                        ,dtoDatosDR.getOidMarca()
                                                                        ,dtoDatosDR.getOidCanal());
            }catch (RemoteException rExc) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(
                    "****Metodo grabarCabeceraReclamo: ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
                    throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            Long periodoActual = dtoPeriodo.getOid();        
            datosReclamo.setPeriodoReclamo(periodoActual); // BELC300014318
        }
      
        Long cliente = datosReclamo.getOidCliente();

        //DTOOID dtoOid = dao.obtenerUnidadAdministrativaCliente(cliente,periodoActual);
        //datosReclamo.setUACliente(dtoOid.getOid()); //Se obtiene desde la LP
    
        DTODatosClienteREC dtoDatosCR = dao.obtenerDatosCliente(cliente);
        datosReclamo.setTipoCliente(dtoDatosCR.getTipoCliente());
        datosReclamo.setSubtipoCliente(dtoDatosCR.getSubtipoCliente());
            
        CabeceraReclamoLocalHome cabeceraReclamoLH = new CabeceraReclamoLocalHome();
        CabeceraReclamoLocal cabeceraReclamoLocal;
        /*
        CabeceraReclamoLocal create(Long numeroAtencion, 
                                    Long numeroReclamo, 
                                    Long pais, 
                                    Long numeroDocumentoReferencia, 
                                    Long periodoDocumentoReferencia, 
                                    Long cliente, 
                                    Long periodoReclamo, 
                                    Long subTipoCliente, 
                                    Long tipoDocumento, 
                                    Long estadoReclamo, 
                                    Long tipoCliente)
        */
            //BELC300018586
        /* - Si datosReclamo.chequeoFisico 
        { /* bloquear contendra el valor del oid correspondiente al bloqueo por chequeo fisico*/ /*
        bloquear = DAOCapturaProcesoReclamos.comprobarResultadoChequeoFisico(datosReclamo.oidDocumentoReferencia) 
        Si bloquear != null 
        { 
        - REC:CabeceraReclamo.estadoReclamo = ConstantesREC.ESTADO_RECLAMO_BLOQUEADO 
        - REC:CabeceraReclamo.motivoBloqueo = bloquear 
        } 
        }Sino 
        { 
        - REC:CabeceraReclamo.estadoReclamo = ConstantesREC.ESTADO_RECLAMO_INGRESADO 
        } */
        
        Long bloquear = null;
        if(datosReclamo.getChequeoFisico()!=null&&datosReclamo.getChequeoFisico().equals(Boolean.TRUE)){
            //bloquear = dao.comprobarResultadoChequeoFisico(datosReclamo.getOidDocumentoReferencia());
            /* Modificado por HRCS - Fecha 13/02/2007 */
            if ( dao.comprobarResultadoChequeoFisico(datosReclamo.getOidDocumentoReferencia()) ) {
                bloquear = dao.obtenerMotivoBloqueoChequeoDeOperaciones(datosReclamo);
            }
        }
        Long estadoReclamo = null;
        Long motivoBloqueo = null;
        if(bloquear!=null){
            estadoReclamo = ConstantesREC.ESTADO_RECLAMO_BLOQUEADO;
            // vbongiov -- DBLG700000171 -- 14/12/2006
            motivoBloqueo = bloquear;
        }else{
            estadoReclamo = ConstantesREC.ESTADO_RECLAMO_INGRESADO;
        }
        UtilidadesLog.debug("motivoBloqueo: " + motivoBloqueo + " - estadoReclamo: " + estadoReclamo );
        try{
            cabeceraReclamoLocal = cabeceraReclamoLH.create(datosReclamo.getNumAtencion(), //(1)
                                datosReclamo.getNumReclamo(),                           //(2)
                                datosReclamo.getOidPais(),//mirar pais activo
                                datosReclamo.getOidDocumentoReferencia(),               //(14)
                                datosReclamo.getPeriodoDocumentoReferencia(), //(16)
                                cliente, // (9)
                                datosReclamo.getPeriodoReclamo(),//periodoReclamo, BELC300014318 (17)
                                datosReclamo.getSubtipoCliente(), //(18)
                                datosReclamo.getTipoDocumento(),  //(20)
                                estadoReclamo, //estadoReclamo (10)
                                datosReclamo.getTipoCliente());// (19)
        
         } catch (PersistenceException e) {
                UtilidadesLog.error("actualizarCuenta: CreateException:grabarCabeceraReclamo",e);
                ctx.setRollbackOnly();
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 
        
        // vbongiov -- SiCC 20090852 -- 6/03/2009
        if(datosReclamo.getTotalEnvia()!=null){
            cabeceraReclamoLocal.setTotalEnvia(datosReclamo.getTotalEnvia().setScale(decimales, BigDecimal.ROUND_HALF_UP)); //(4)
        }        
        if(datosReclamo.getTotalDevuelve()!=null){
            cabeceraReclamoLocal.setTotalDevuelve(datosReclamo.getTotalDevuelve().setScale(decimales, BigDecimal.ROUND_HALF_UP)); //(5)
        }
        
        if(datosReclamo.getSaldoAPagar()!= null){
            cabeceraReclamoLocal.setSaldoPagar(datosReclamo.getSaldoAPagar().setScale(decimales, BigDecimal.ROUND_HALF_UP)); // (6)
        }
        
        cabeceraReclamoLocal.setUsuarioIngreso(ctx.getCallerPrincipal().getName()); //(7)
        Date fechaDia = new Date(System.currentTimeMillis()); // (8)   
        cabeceraReclamoLocal.setFechaDocumentoReferencia(datosReclamo.getFechaDocumentoReferencia());//(3)
        cabeceraReclamoLocal.setFechaIngreso(new java.sql.Date(fechaDia.getTime()));
        cabeceraReclamoLocal.setMotivoBloqueo(motivoBloqueo); // (11)
        cabeceraReclamoLocal.setMotivoDesbloqueo(null); // (12)
        cabeceraReclamoLocal.setMotivoRechazo(null); //(13)
        cabeceraReclamoLocal.setPais(datosReclamo.getOidPais()); //(15)
        cabeceraReclamoLocal.setTipoIngreso(ConstantesREC.TIPO_INGRESO_LINEA);//(21) (I)ntroduccion en linea
        cabeceraReclamoLocal.setUnidadAdministrativaCliente(datosReclamo.getUACliente()); //(22)
        cabeceraReclamoLH.merge(cabeceraReclamoLocal);
      
        Long oidCreado = cabeceraReclamoLocal.getOid();
        UtilidadesLog.debug("oidCreado: " + oidCreado);
        datosReclamo.setOidReclamo(oidCreado);
        
        UtilidadesLog.debug("datosReclamo: " + datosReclamo);
        
        //********
        // vbongiov -- SiCC 20090852 -- 6/03/2009
        UtilidadesLog.debug(
        "cabeceraReclamoLocal:"
        + " NumeroAtencion: " + cabeceraReclamoLocal.getNumeroAtencion()
        + " NumeroReclamo: " + cabeceraReclamoLocal.getNumeroReclamo()
        + " pais: " + cabeceraReclamoLocal.getPais()
        + " NumeroDocumentoReferencia: " + cabeceraReclamoLocal.getNumeroDocumentoReferencia()
        + " PeriodoDocumentoReferencia: " + cabeceraReclamoLocal.getPeriodoDocumentoReferencia()
        + " cliente: " + cabeceraReclamoLocal.getCliente()
        + " PeriodoReclamo: " + cabeceraReclamoLocal.getPeriodoReclamo()
        + " SubTipoCliente: " + cabeceraReclamoLocal.getSubTipoCliente()
        + " TipoDocumento: " + cabeceraReclamoLocal.getTipoDocumento()
        + " EstadoReclamo: " + cabeceraReclamoLocal.getEstadoReclamo()
        + " TipoCliente: " + cabeceraReclamoLocal.getTipoCliente()
        + " TotalEnvia: " + (cabeceraReclamoLocal.getTotalEnvia()!=null?cabeceraReclamoLocal.getTotalEnvia().setScale(decimales, BigDecimal.ROUND_HALF_UP):null)
        + " TotalDevuelve: " + (cabeceraReclamoLocal.getTotalDevuelve()!=null?cabeceraReclamoLocal.getTotalDevuelve().setScale(decimales, BigDecimal.ROUND_HALF_UP):null)
        + " SaldoPagar: " + (cabeceraReclamoLocal.getSaldoPagar()!=null?cabeceraReclamoLocal.getSaldoPagar().setScale(decimales, BigDecimal.ROUND_HALF_UP):null)
        + " UsuarioIngreso: " + cabeceraReclamoLocal.getUsuarioIngreso()
        + " FechaDocumentoReferencia: " + cabeceraReclamoLocal.getFechaDocumentoReferencia()
        + " FechaIngreso: " + cabeceraReclamoLocal.getFechaIngreso()
        + " MotivoBloqueo: " + cabeceraReclamoLocal.getMotivoBloqueo()
        + " MotivoDesbloqueo: " + cabeceraReclamoLocal.getMotivoDesbloqueo()
        + " MotivoRechazo: " + cabeceraReclamoLocal.getMotivoRechazo()
        + " TipoIngreso: " + cabeceraReclamoLocal.getTipoIngreso()
        + " UnidadAdministrativaCliente: " + cabeceraReclamoLocal.getUnidadAdministrativaCliente()
        );
        //********
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.grabarCabeceraReclamo():Salida");
    }

    public DTODatosDocumentoREC obtenerDatosDocumento(Long documento) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDatosDocumento(Long):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTODatosDocumentoREC resultado = dao.obtenerDatosDocumento(documento);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDatosDocumento(Long):Salida");
        return resultado;
    }

    public DTOOID obtenerUnidadAdministrativaCliente(Long cliente, Long periodo) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerUnidadAdministrativaCliente(Long , Long):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTOOID resultado = dao.obtenerUnidadAdministrativaCliente(cliente, periodo);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerUnidadAdministrativaCliente(Long , Long):Salida");
        return resultado;
    }

    public DTODatosClienteREC obtenerDatosCliente(Long cliente) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDatosCliente(Long):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTODatosClienteREC dto = dao.obtenerDatosCliente(cliente);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerDatosCliente(Long):Salida");
        return dto;
    }

    public DTOSalida obtenerProductosDevuelveSi(DTOBuscarClientesREC dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosDevuelveSi(DTOBuscarClientesREC):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = null;
        if(ConstantesREC.MATRIZ_PRECIOS.equals(dto.getIndicadorMatriz())){
            rs = dao.obtenerProductosDevuelveSi(dto);    
        }else{
            rs = dao.obtenerProductosDevuelveSiPremio(dto);
        }
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosDevuelveSi(DTOBuscarClientesREC):Salida");
        return new DTOSalida(rs);
    }



    public DTOSalida obtenerProductosCodigoVentaNo(DTOBuscarProductosDevuelveNoREC dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosCodigoVentaNo(DTOBuscarProductosDevuelveNoREC):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerProductosCodigoVentaNo(dto);
        //Falta el metodo del dao???
        if (rs.esVacio()){
            //GEN-0007 --> 005
			UtilidadesLog.debug("****MONCapturaProcesoReclamos.obtenerProductosCodigoVentaNo: No hay datos ");				
            throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
        }
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosCodigoVentaNo(DTOBuscarProductosDevuelveNoREC):Salida");
        return new DTOSalida(rs);
    }

        public DTOGeneraOperacionREC obtenerGeneraOperacion(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerGeneraOperacion(DTOOID):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerGeneraOperacion(dto);
        DTOGeneraOperacionREC dtoS = new DTOGeneraOperacionREC();
       if (!rs.esVacio()){ 
            if (rs.getValueAt(0,"DEVUELVEGENERAENVIA") != null) {
                if (((BigDecimal)rs.getValueAt(0,"DEVUELVEGENERAENVIA")).intValue() == 1)
                {
                    dtoS.setDevuelveGeneraEnvia(Boolean.TRUE);    
                }else {
                    dtoS.setDevuelveGeneraEnvia(Boolean.FALSE);    
                }
            }else {
                dtoS.setDevuelveGeneraEnvia(Boolean.FALSE);    
            }
            if (rs.getValueAt(0,"ENVIAGENERADEVUELVE") != null) {
                if (((BigDecimal)rs.getValueAt(0,"ENVIAGENERADEVUELVE")).intValue() == 1)
                {
                    dtoS.setEnviaGeneraDevuelve(Boolean.TRUE);    
                }else {
                    dtoS.setEnviaGeneraDevuelve(Boolean.FALSE);    
                }     
            }else {
                dtoS.setEnviaGeneraDevuelve(Boolean.FALSE);    
            } 
        }
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerGeneraOperacion(DTOOID):Salida");
        return dtoS;
    }

    public DTOSalida obtenerProductosEnvia(DTOBuscarEnvia dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosEnvia(DTOBuscarEnvia):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = null;
        if(ConstantesREC.MATRIZ_PRECIOS.equals(dto.getIndicadorMatriz())){
            rs = dao.obtenerProductosEnvia(dto);
        }else{
            rs = dao.obtenerProductosEnviaPremio(dto);    
        }
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosEnvia(DTOBuscarEnvia):Salida");
        return new DTOSalida(rs);
    }

    public DTOBloqueoTipoOperacionREC obtenerBloqueosTipo(DTOOperacionReclamo dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerBloqueosTipo(DTOOperacionReclamo):Entrada");
        //modificado por incidencia 15177        

        // Modificado por ssantana, 1/3/2006
        String sUsuario = dto.getUsuario();
        Long oidTipoOperacion = dto.getTipoOperacion();
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        DTOBloqueoTipoOperacionREC dtoS = dao.obtenerBloqueosTipo(oidTipoOperacion, 
                                                                  sUsuario);
        // Fin Modificado por ssantana, 1/3/2006
        
        
        // Comprueba si hay reclamos anteriores sobre productos de la operación recibida 
        ArrayList lineas = null;
        lineas = dto.getLineas();
        Boolean bloquear = Boolean.FALSE;
        DTOLineaOperacion dtoLinea = null; 
        RecordSet reclamos = null;
        int posicion = lineas.size();
        DAORec daoRec = new DAORec();
        for (int i=0; i<posicion; i++){
            dtoLinea = (DTOLineaOperacion)lineas.get(i);
            reclamos = daoRec.obtenerReclamosAnteriores(dto.getOidDocumentoReferencia(),dtoLinea.getOidCodVenta(),dtoLinea.getOidCodProducto(),dto.getOperacionesAEliminar());
            if (!reclamos.esVacio()){
                bloquear = Boolean.TRUE;
                break;
            }
        }
        
        if (!bloquear.booleanValue())  {
            dtoS.setBloqueoAnterior(null);
        }
                
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerBloqueosTipo(DTOOperacionReclamo):Salida");
        return dtoS;
    }

    public DTOSalida obtenerTiposBloqueo(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerTiposBloqueo(DTOBelcorp):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerTiposBloqueo(dto);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerTiposBloqueo(DTOBelcorp):Salida");
        return new DTOSalida(rs);
    }

    public DTOSalida obtenerOperacionesDescripcion(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerOperacionesDescripcion(DTOBelcorp):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerOperacionesDescripcion(dto);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerOperacionesDescripcion(DTOBelcorp):Salida");
        return new DTOSalida(rs);
    }

    public DTOSalida obtenerMotivosRechazoDesbloqueo(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerMotivosRechazoDesbloqueo(DTOBelcorp):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerMotivosRechazoDesbloqueo(dto);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerMotivosRechazoDesbloqueo(DTOBelcorp):Salida");
        return new DTOSalida(rs);
    }

    public DTOSalida obtenerReclamosGestion(DTOBuscarReclamosREC dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerReclamosGestion(DTOBuscarReclamosREC):Entrada");
        //modificado por incidencia 14671
        UtilidadesLog.debug("DTOBuscarReclamosREC = " +dto);
        if(dto.getStringOperaciones()!= null){
            if(!dto.getStringOperaciones().equals(""))
                dto.setOidsOperaciones(convertirStringTOArrayX(dto.getStringOperaciones()));
        }
        if(dto.getStringTiposBloqueo() != null){
            if(!dto.getStringTiposBloqueo().equals(""))
                dto.setOidsTiposBloqueo(convertirStringTOArrayX(dto.getStringTiposBloqueo()));
        }
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerReclamosGestion(dto);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerReclamosGestion(DTOBuscarReclamosREC):Salida");
        return new DTOSalida(rs);
    }

    public void obtenerAutorizacionAcceso(DTOBuscarReclamosREC dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerAutorizacionAcceso(DTOBuscarReclamosREC):Entrada");
        ArrayList oidsReclamo = dto.getOidsReclamo();
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        
        
        if (oidsReclamo != null && oidsReclamo.size() > 0){
            // validar acceso a Reclamos 
            OperacionReclamoLocalHome opLH = new OperacionReclamoLocalHome();
            for (int i=0; i < oidsReclamo.size(); i++){
                Collection operacionReclamoCol = null;
                try{
                    operacionReclamoCol = opLH.findByCabeceraReclamo((Long)oidsReclamo.get(i));
                } catch(NoResultException ex){
                    UtilidadesLog.error("obtenerAutorizacionAcceso: FinderException obtenerAutorizacionAcceso", ex);
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    ctx.setRollbackOnly();
                    throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                }catch (PersistenceException re){
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                }
                Iterator itOperacionReclamo = operacionReclamoCol.iterator();
                while(itOperacionReclamo.hasNext()){
                    RecordSet rs = null;
                    OperacionReclamoLocal operacionReclamo = (OperacionReclamoLocal)itOperacionReclamo.next();
                    
                    //Incidencia BELC300014307
                    rs = dao.obtenerAutorizacion(dto.getOidPais(),
                                                ctx.getCallerPrincipal().getName(),
                                                operacionReclamo.getTipoOperacion());
                    
                    if (rs.esVacio()){
                        throw new MareException(new Exception(),
									UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC,
                                    "",ErroresDeNegocio.USUARIO_NO_AUTORIZADO));
                    } else{
                        DTOOID dtoOidCabecera = new DTOOID();
                        dtoOidCabecera.setOidIdioma(dto.getOidIdioma());
                        dtoOidCabecera.setOidPais(dto.getOidPais());
                        dtoOidCabecera.setOid(operacionReclamo.getOid());
                        DTOTotalesReclamoREC dtoTotales = new DTOTotalesReclamoREC ();
                        dtoTotales = this.obtenerTotales(dtoOidCabecera);
                        //Incidencia BELC300015127
                        if (operacionReclamo.getTipoBloqueo() != null){
                            TiposBloqueoLocalHome tiposBloqueoLH = new TiposBloqueoLocalHome();
                            TiposBloqueoLocal tiposBloqueo = null;
                            try{
                                UtilidadesLog.debug("*** operacionReclamo.getTipoBloqueo() = "+operacionReclamo.getTipoBloqueo());
                                tiposBloqueo = tiposBloqueoLH.findByPrimaryKey(operacionReclamo.getTipoBloqueo());
                            } catch (NoResultException ex){
                                UtilidadesLog.error("obtenerAutorizacionAcceso: FinderException obtenerAutorizacionAcceso", ex);
                                ctx.setRollbackOnly();
                                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));    
                            }catch (PersistenceException re){
                                    ctx.setRollbackOnly();
                                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                            }
                            if (tiposBloqueo.getCodTipoBloqueo() != null &&
                                    tiposBloqueo.getCodTipoBloqueo().equals(ConstantesREC.BLOQUEO_IMPORTE_MAXIMO)){//ConstantesREC.BLOQUEO_IMPORTE_MAXIMO
                                if (dtoTotales.getTotalCargo().floatValue() > new Float(rs.getValueAt(0,"IMPORTEMAXIMO").toString()).floatValue()){ 
                                    throw new MareException(new Exception(),
                                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC,
                                        "",ErroresDeNegocio.SUPERADO_IMPORTE_AUTORIZADO));
                                }
                            } else if (tiposBloqueo.getCodTipoBloqueo() != null &&
                                        tiposBloqueo.getCodTipoBloqueo().equals(ConstantesREC.BLOQUEO_DIFERENCIA_IMPORTES)) {
                                if ((dtoTotales.getTotalCargo().floatValue() - 
                                    dtoTotales.getTotalAbono().floatValue()) > new Float(rs.getValueAt(0,"MONTOMAXIMODIFERENCIA").toString()).floatValue()){ 
                                    throw new MareException(new Exception(),
                                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC,
                                        "",ErroresDeNegocio.SUPERADA_DIFERENCIA_AUTORIZADA));    
                                }
                            }
                        }
                    }
                }
            }
        } else{
            // validar acceso a Operaciones de Reclamo 
            ArrayList oidsOperaciones = dto.getOidsOperaciones();
            if (oidsOperaciones != null && oidsOperaciones.size() > 0){
                OperacionReclamoLocalHome opLH = new OperacionReclamoLocalHome();
                for (int i=0; i < oidsOperaciones.size(); i++){
                    OperacionReclamoLocal operacionReclamo = null;
                    try{
                        operacionReclamo = opLH.findByPrimaryKey((Long)oidsOperaciones.get(i));
                    } catch(NoResultException ex){
                        UtilidadesLog.error("obtenerAutorizacionAcceso: FinderException obtenerAutorizacionAcceso", ex);
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                        throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));    
                    }catch (PersistenceException re){
                            ctx.setRollbackOnly();
                            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                    }
                    //Incidencia BELC300014307
                    RecordSet rs = null;
                    rs = dao.obtenerAutorizacion(dto.getOidPais(),
                                                ctx.getCallerPrincipal().getName(),
                                                operacionReclamo.getTipoOperacion());
                    
                    if (rs.esVacio()){
                        throw new MareException(new Exception(),
									UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC,
                                    "",ErroresDeNegocio.USUARIO_NO_AUTORIZADO));
                    } else{
                        DTOOID dtoOidCabecera = new DTOOID();
                        dtoOidCabecera.setOidIdioma(dto.getOidIdioma());
                        dtoOidCabecera.setOidPais(dto.getOidPais());
                        dtoOidCabecera.setOid(operacionReclamo.getOid());
                        DTOTotalesReclamoREC dtoTotales = new DTOTotalesReclamoREC ();
                        dtoTotales = this.obtenerTotales(dtoOidCabecera);
                        //Incidencia BELC300015127
                        if (operacionReclamo.getTipoBloqueo() != null) {
                            TiposBloqueoLocalHome tiposBloqueoLH = new TiposBloqueoLocalHome();
                            TiposBloqueoLocal tiposBloqueo = null;
                            try{
                                tiposBloqueo = tiposBloqueoLH.findByPrimaryKey(operacionReclamo.getTipoBloqueo());
                            } catch (NoResultException ex){
                                UtilidadesLog.error("obtenerAutorizacionAcceso: FinderException obtenerAutorizacionAcceso", ex);
                                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                                ctx.setRollbackOnly();
                                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));    
                            }catch (PersistenceException re){
                                    ctx.setRollbackOnly();
                                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                            }
                            if (tiposBloqueo.getCodTipoBloqueo() != null &&
                                tiposBloqueo.getCodTipoBloqueo() == ConstantesREC.BLOQUEO_IMPORTE_MAXIMO){
                                if (dtoTotales.getTotalCargo().floatValue() > new Float(rs.getValueAt(0,"IMPORTEMAXIMO").toString()).floatValue()){ //importeMaximo
                                    throw new MareException(new Exception(),
                                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC,
                                        "",ErroresDeNegocio.SUPERADO_IMPORTE_AUTORIZADO));
                                }
                            } else if (tiposBloqueo.getCodTipoBloqueo() != null &&
                                tiposBloqueo.getCodTipoBloqueo() == ConstantesREC.BLOQUEO_DIFERENCIA_IMPORTES) { 
                                if ((dtoTotales.getTotalCargo().floatValue() - 
                                    dtoTotales.getTotalAbono().floatValue()) > new Float(rs.getValueAt(0,"MONTOMAXIMODIFERENCIA").toString()).floatValue()){
                                    throw new MareException(new Exception(),
                                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC,
                                        "",ErroresDeNegocio.SUPERADA_DIFERENCIA_AUTORIZADA));    
                                }
                            }
                        }
                    }
                }
            }
        }
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerAutorizacionAcceso(DTOBuscarReclamosREC):Salida");
    }

    public void desbloquearReclamoGestion(DTODesbloqueoRechazoREC dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.desbloquearReclamoGestion(DTOBuscarReclamosREC):Entrada");
        ArrayList oidsOperacion = dto.getOidsOperacion();
        if (oidsOperacion == null || oidsOperacion.size() <= 0){
            UtilidadesLog.debug("dto.getOids()  " + dto.getOids() );
            ArrayList oids = dto.getOids();
            if (oids != null && oids.size()>0){
                CabeceraReclamoLocalHome crLH = new CabeceraReclamoLocalHome();
                for(int i=0; i < oids.size(); i++){
                    CabeceraReclamoLocal reclamo = null;
                    try{
                        reclamo = crLH.findByPrimaryKey((Long)oids.get(i));
                    } catch(NoResultException ex){
                        UtilidadesLog.error("obtenerAutorizacionAcceso: FinderException obtenerAutorizacionAcceso", ex);
                        String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                        ctx.setRollbackOnly();
                        throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));    
                    }catch (PersistenceException re){
                            ctx.setRollbackOnly();
                            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                    }
                   
                   
                    reclamo.setEstadoReclamo(ConstantesREC.ESTADO_RECLAMO_INGRESADO);
                    reclamo.setMotivoDesbloqueo(dto.getOidMotivo());
                    crLH.merge(reclamo);
                    
                    DTOAtencionReclamoREC dtoAtenRec = new DTOAtencionReclamoREC();
                    dtoAtenRec.setNumAtencion(reclamo.getNumeroAtencion());
                    dtoAtenRec.setOidPais(dto.getOidPais());
                    dtoAtenRec.setOidIdioma(dto.getOidIdioma());
                    this.generarSolicitudes(dtoAtenRec);
                }                
            }
        }else{
            UtilidadesLog.debug("oidsOperacion.size()  " + oidsOperacion.size());
            Long oidCabeceraOperacion = null;
            OperacionReclamoLocalHome orLH = new OperacionReclamoLocalHome();
            LineasOperacionReclamoLocalHome lorLH = new LineasOperacionReclamoLocalHome();
            for (int i=0; i < oidsOperacion.size(); i++){
                OperacionReclamoLocal operacion = null;
                try{
                    operacion = orLH.findByPrimaryKey((Long)oidsOperacion.get(i));
                }catch(NoResultException ex){
                    UtilidadesLog.error("obtenerAutorizacionAcceso: FinderException obtenerAutorizacionAcceso", ex);
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    ctx.setRollbackOnly();
                    throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));    
                }catch (PersistenceException re){
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                }
                operacion.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_INGRESADO);
                operacion.setMotivoDesbloqueo(dto.getOidMotivo ());
                orLH.merge(operacion);
                Long oidOperacion = (Long)oidsOperacion.get(i);
                UtilidadesLog.debug("oidOperacion  " + oidOperacion);
                               
                
                if (i==0){
                    oidCabeceraOperacion = operacion.getNumeroAtencion(); //se corresponde con el oid de la cabecera
                }
                
                LineasOperacionReclamoLocal linea = null;
                Collection lineasCol = null;
                
                try{
                    lineasCol = lorLH.findByOperacion((Long)oidsOperacion.get(i));
                } catch (NoResultException ex){
                    UtilidadesLog.error("obtenerAutorizacionAcceso: FinderException obtenerAutorizacionAcceso", ex);
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));    
                }catch (PersistenceException re){
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                }
                Iterator itLinea = lineasCol.iterator();
                
                while (itLinea.hasNext()){
                    linea = (LineasOperacionReclamoLocal)itLinea.next();
                    linea.setMotivoDesbloqueo(dto.getOidMotivo());
                    lorLH.merge(linea);
                }
            }
            CabeceraReclamoLocalHome crLH = new CabeceraReclamoLocalHome();
            CabeceraReclamoLocal reclamo = null;
            try{
                reclamo = crLH.findByPrimaryKey(oidCabeceraOperacion);
            } catch (NoResultException ex){
                UtilidadesLog.error("obtenerAutorizacionAcceso: FinderException obtenerAutorizacionAcceso", ex);
                 ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));    
             }catch (PersistenceException re){
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
             }
            
            DTOAtencionReclamoREC dtoAtenRec = new DTOAtencionReclamoREC();
            dtoAtenRec.setNumAtencion(reclamo.getNumeroAtencion());
            dtoAtenRec.setOidPais(dto.getOidPais());
            dtoAtenRec.setOidIdioma(dto.getOidIdioma());
            
            if(reclamo.getEstadoReclamo().longValue() !=
              ConstantesREC.ESTADO_RECLAMO_BLOQUEADO.longValue()) {
              this.generarSolicitudes(dtoAtenRec);  
            }            
        }
        UtilidadesLog.info("MONCapturaProcesoReclamos.desbloquearReclamoGestion(DTOBuscarReclamosREC):Salida");
    }

    public DTOTotalesReclamoREC obtenerTotales(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerTotales(DTOOID):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerTotales(dto);
        DTOTotalesReclamoREC dtoTR = new DTOTotalesReclamoREC();
        
         dtoTR.setTotalAbono(rs.getValueAt(0,"TOTALABONO") != null ?
                             (BigDecimal)rs.getValueAt(0,"TOTALABONO") :
                             new BigDecimal(0));
         dtoTR.setTotalCargo(rs.getValueAt(0,"TOTALCARGO") != null ?
                             (BigDecimal)rs.getValueAt(0,"TOTALCARGO") :
                             new BigDecimal(0));

        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerTotales(DTOOID):Salida");
        return dtoTR;
    }

    // incidencia BELC300014440
    public DTOSalida obtenerLineasOperacion(DTOOIDPaginado dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerLineasOperacion(DTOOIDPaginado):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerLineasOperacion(dto);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerLineasOperacion(DTOOIDPaginado):Salida");
        return new DTOSalida(rs);
    }

    public DTOSalida obtenerOperacionesReclamo(DTOBuscarReclamosREC dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerOperacionesReclamo(DTOBuscarReclamosREC):Entrada");
        UtilidadesLog.debug("DTOBuscarReclamosREC = " +dto);
        if(dto.getStringOperaciones() != null && !dto.getStringOperaciones().equals(""))
            dto.setOidsOperaciones(convertirStringTOArray(dto.getStringOperaciones()));
        if(dto.getStringTiposBloqueo() != null && !dto.getStringTiposBloqueo().equals(""))
            dto.setOidsTiposBloqueo(convertirStringTOArray(dto.getStringTiposBloqueo()));
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerOperacionesReclamo(dto);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerOperacionesReclamo(DTOBuscarReclamosREC):Salida");
        return new DTOSalida(rs);
    }

   // BELC300014317
   public void rechazarReclamoGestion(DTODesbloqueoRechazoREC dto) throws MareException {
      
      UtilidadesLog.info("MONCapturaProcesoReclamos.rechazarReclamoGestion(DTODesbloqueoRechazoREC):Salida");
      
      // Si dto.oidsOperacion[] vacio { 
      if (dto.getOidsOperacion() == null || dto.getOidsOperacion().isEmpty()) {

         CabeceraReclamoLocal reclamo = null;
         CabeceraReclamoLocalHome cabRecLocalHome = new CabeceraReclamoLocalHome();
      
         // -> Para cada elemento de dto.oids[] recibido: 
         if (dto.getOids() != null){
            for (int i=0; i < dto.getOids().size(); i++) {
                // reclamo = Hacer un 'findByPrimaryKey' sobre la entidad REC:CabeceraReclamo, 
                // pasandole como parametro el elemento de dto.oids[] 
                try {
                   reclamo = cabRecLocalHome.findByPrimaryKey((Long)dto.getOids().get(i));
                } catch (NoResultException ex){
                   UtilidadesLog.error("MONCapturaProcesoReclamos.rechazarReclamoGestion: FinderException", ex);
                    ctx.setRollbackOnly();
                   String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                   throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                }catch (PersistenceException re){
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                }
                // reclamo.estadoReclamo = ConstantesREC.ESTADO_RECLAMO_RECHAZADO 
                reclamo.setEstadoReclamo(ConstantesREC.ESTADO_RECLAMO_RECHAZADO);
                // reclamo.motivoRechazo = dto.oidMotivo
                reclamo.setMotivoRechazo(dto.getOidMotivo());
                cabRecLocalHome.merge(reclamo);
             } 
         }
      
      } else { // Si no { // oidsOperaciones[] tiene algun elemento 
      
         DAOCapturaProcesoReclamos daoCapProcRec = new DAOCapturaProcesoReclamos();

         boolean ebelNoticias=false;
         DTOOID dtoOID = null;
         
         OperacionReclamoLocal operacion = null;
         OperacionReclamoLocalHome operRecLocalHome = new OperacionReclamoLocalHome();
         LineasOperacionReclamoLocal linOperRecLocal = null;
         LineasOperacionReclamoLocalHome linOperRecLocalHome = new LineasOperacionReclamoLocalHome();
         
         Collection lineas = null;
         Iterator itLineas = null;
         
         DTOBuzonMensajes dtoBuzMsgs = null;
         
         DTOSalida dtoSal = null;
         
         RecordSet rs = null;
         
         Long oidOperacion = null;
         
         // -> Para cada elemento de dto.oidsOperacion[] recibido: 
         for (int i=0; i < dto.getOidsOperacion().size(); i++) {
            // - operacion = Hacer un 'findByPrimary' sobre la entidad REC:OperacionReclamo, 
            // pasandole como parametro el elemento de dto.oidsOperacion[] 
            
            oidOperacion = (Long)dto.getOidsOperacion().get(i);
            
            try {
               operacion = operRecLocalHome.findByPrimaryKey(oidOperacion); 
            } catch (NoResultException ex){
               UtilidadesLog.error("MONCapturaProcesoReclamos.rechazarReclamoGestion: FinderException", ex);
                ctx.setRollbackOnly();
               String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
            }catch (PersistenceException re){
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
         
            // - operacion.estadoOperacion = ConstantesREC.ESTADO_OPERACION_RECHAZADO 
            operacion.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_RECHAZADO);
            // - operacion.motivoRechazo = dto.oidMotivo 
            operacion.setMotivoRechazo(dto.getOidMotivo());
            // - ebelNoticias = Llamar al metodo "DAOCapturaProcesoReclamos.obtenerEbelNoticias(dto:DTOOID):boolean" pasandole el oid de la operacion tratada 
            operRecLocalHome.merge(operacion);
            
            dtoOID = new DTOOID();
            dtoOID.setOid(operacion.getOid());
            ebelNoticias = daoCapProcRec.obtenerEbelNoticias(dtoOID);
            
            // - linea[] = Hacer un 'findByOperacion' sobre la entidad REC:LineasOperacionReclamo, pasandole como parametro el elemento de dto.oidsOperacion[]
            try {
               lineas = linOperRecLocalHome.findByOperacion(oidOperacion);
            } catch (NoResultException ex){
               UtilidadesLog.error("MONCapturaProcesoReclamos.rechazarReclamoGestion: FinderException", ex);
               String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                ctx.setRollbackOnly();
               throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
            }catch (PersistenceException re){
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
            
            // - Para cada elemento i de la coleccion : 
            itLineas = lineas.iterator();
            int n =0;
            while (itLineas.hasNext()) {
               i++;
               UtilidadesLog.debug(" --- Bucle " + n);
               linOperRecLocal = (LineasOperacionReclamoLocal)itLineas.next();
               
               // - linea[i].motivoDesbloqueo = dto.oidMotivo 
               linOperRecLocal.setMotivoDesbloqueo(dto.getOidMotivo());
               linOperRecLocalHome.merge(linOperRecLocal);
               // - si ebelNoticias { 
               UtilidadesLog.debug("ebelNoticias: " + ebelNoticias);
               if (ebelNoticias) {
                  // si linea[i].tipoMovimiento = ConstantesREC.TIPO_MOVIMIENTO_ENVIA { 
                  UtilidadesLog.debug("linOperRecLocal.getTipoMovimiento(): " + linOperRecLocal.getTipoMovimiento());
                  if (linOperRecLocal.getTipoMovimiento().compareTo(ConstantesREC.TIPO_MOVIMIENTO_ENVIA) == 0) {
                     UtilidadesLog.debug("Envia mensaje...");
                     // con operacion:oid y linea:oid llamar al metodo obtenerParametrosMensaje() del DAOCapturaProcesoReclamos 
                     DTOOID dtoOidOperacion = new DTOOID();
                     dtoOidOperacion.setOid(operacion.getOid());
                     dtoOidOperacion.setOidIdioma(dto.getOidIdioma());
                     
                     dtoSal = daoCapProcRec.obtenerParametrosMensaje(dtoOidOperacion, linOperRecLocal.getOid());
                     
                     // Llamar al CU "Insertar en Buzon de Mensajes"
               
                     rs = dtoSal.getResultado();
                     UtilidadesLog.debug("rs: " + rs);
                     
                    
                     /* 
                     -> Devolver el RecordSet , que contendra 1 solo registro, 
                     // con los siguientes campos en este orden: 
                     0 - oidCliente = mc.OID_CLIE 
                     1 - codCliente = mc.COD_CLIE 
                     2 - nombreCliente = mc.VAL_NOM1 
                     3 - apellidoCliente = mc.VAL_APE1 
                     4 - numDocReferencia = sc2.VAL_NUME_SOLI // Documento de Referencia de Cabecera 
                     5 - periodoReferencia = descripcion internacionalizable correspondiente a pc.OID_PERI 
                     6 - periodoReclamo= descripcion internacionalizable correspondiente a pc2.OID_PERI 
                     7 - numReclamo = cr.NUM_RECL 
                     8 - operacion = op.COD_OPER 
                     9 - nombreOperacion = descripcion internacionalizable correspondiente a op.OID_OPER 
                     10 - codVenta = do.VAL_CODI_VENT 
                     11 - descProducto = mp.DES_CORT 
                     12 - uReclamadas = lo.NUM_UNID_RECL 
                     13 - uAtendidass = lo.NUM_UNID_DEVU 
                     14 - motivoRechazo = descripcion internacionalizable correspondiente a md.OID_MOTI_RECH_DESB 
                     */
                                                                                    
                     // - Con los campos del RecordSet devuelto crear un DTOBuzonMensajes con los siguientes parametros: 
                     dtoBuzMsgs = new DTOBuzonMensajes();
                     // pais=pais activo 
                     dtoBuzMsgs.setOidPais(dto.getOidPais());
                     // pais=pais activo 
                     dtoBuzMsgs.setOidIdioma(dto.getOidIdioma());                     
                     // codigoMensaje='REC05'
                     dtoBuzMsgs.setCodigoMensaje("REC05");
                     
                     
                     // moduloOrigen='REC' 
                     dtoBuzMsgs.setModuloOrigen(new Long(ConstantesSEG.MODULO_REC));
                     
                     
                     if (!rs.esVacio()){
                        // oidCliente=dto.oidCliente 
                        UtilidadesLog.debug("rs   " + rs);
                        dtoBuzMsgs.setOidCliente(new Long(((BigDecimal)rs.getValueAt(0, 0)).longValue()));
                        // datos variables: 
                        // - codigoCliente=dto.codigoCliente 
                        dtoBuzMsgs.setDatoVariable1(rs.getValueAt(0, "CODCLIENTE") != null ?
                                                    rs.getValueAt(0, "CODCLIENTE").toString() : "");
                        // - nombreCliente=dto.nombre1 
                        dtoBuzMsgs.setDatoVariable2(rs.getValueAt(0, "NOMBRECLIENTE") != null ?
                                                    rs.getValueAt(0, "NOMBRECLIENTE").toString() : "");
                        // - apellidoCliente=dto.apellido1 
                        dtoBuzMsgs.setDatoVariable3(rs.getValueAt(0, "APELLIDOCLIENTE") != null ?
                                                    rs.getValueAt(0, "APELLIDOCLIENTE").toString() : "");
                        // - documentoReferencia=dto.numeroDocumentoReferencia 
                        dtoBuzMsgs.setDatoVariable4(rs.getValueAt(0, "NUMDOCREFERENCIA") != null ?
                                                    rs.getValueAt(0, "NUMDOCREFERENCIA").toString() : "");
                        // - periodoReferencia=dto.periodoDocumentoReferencia 
                        dtoBuzMsgs.setDatoVariable5(rs.getValueAt(0, "PERIODOREFERENCIA") != null ?
                                                    rs.getValueAt(0, "PERIODOREFERENCIA").toString() : "");
                        // - periodoReclamo=dto.periodoReclamo 
                        dtoBuzMsgs.setDatoVariable6(rs.getValueAt(0, "PERIODORECLAMO") != null ? 
                                                    rs.getValueAt(0, "PERIODORECLAMO").toString() : "");
                        // - numReclamo=dto.numeroeclamo 
                        dtoBuzMsgs.setDatoVariable7(rs.getValueAt(0, "NUMRECLAMO") != null ?
                                                    rs.getValueAt(0, "NUMRECLAMO").toString() : "");
                        // - operacion=dto.operacion 
                        dtoBuzMsgs.setDatoVariable8(rs.getValueAt(0, "OPERACION") != null ?
                                                    rs.getValueAt(0, "OPERACION").toString() : "");
                        // - nombreOperacion=dto.nombreOperacion 
                        dtoBuzMsgs.setDatoVariable9(rs.getValueAt(0, "NOMBREOPERACION") != null ?
                                                    rs.getValueAt(0, "NOMBREOPERACION").toString() : "");
                        // - codVenta=dto.codVenta 
                        dtoBuzMsgs.setDatoVariable10(rs.getValueAt(0, "CODVENTA") != null ?
                                                    rs.getValueAt(0, "CODVENTA").toString() : "");
                        // - descProducto=dto.descProducto 
                        dtoBuzMsgs.setDatoVariable11(rs.getValueAt(0, "DESCPRODUCTO") != null ?
                                                    rs.getValueAt(0, "DESCPRODUCTO").toString() : "");
                        // - unidadesReclamadas=dto.uReclamadas 
                        dtoBuzMsgs.setDatoVariable12(rs.getValueAt(0, "URECLAMADAS") != null ?
                                                    rs.getValueAt(0, "URECLAMADAS").toString() : "");
                        // - unidadesAtendidas=dto.uAtendidas 
                        dtoBuzMsgs.setDatoVariable13(rs.getValueAt(0, "UATENDIDAS") != null ?
                                                    rs.getValueAt(0, "UATENDIDAS").toString() : "");
                        // - motivoRechazo=dto.motivoRechazo 
                        dtoBuzMsgs.setDatoVariable14(rs.getValueAt(0, "MOTIVORECHAZO") != null ?
                                                    rs.getValueAt(0, "MOTIVORECHAZO").toString() : "");
                        // - estadoOperacion='Rechazado' 
                        dtoBuzMsgs.setDatoVariable15("Rechazado");
                        // listaConsultoras='N' 
                        dtoBuzMsgs.setDatoVariable16("N");
                        // resto de parametros vacios     
                    
                        // - Con el dto creado invocar al metodo insertarDatosMensaje() de la interfaz IMSG 
                        try {
                            getMONGestionMensajes().insertaDatosMensaje(dtoBuzMsgs);
                        } catch (RemoteException e) {
                            ctx.setRollbackOnly();
                            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                            UtilidadesLog.error("MONCapturaProcesoReclamos.rechazarReclamoGestion: RemoteException", e);
                            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
                        }
                    
                     }                     
                  }
               } 
            } // - Fin Para
         } // -> Fin Para 
      }  
      
      UtilidadesLog.info("MONCapturaProcesoReclamos.rechazarReclamoGestion(DTODesbloqueoRechazoREC):Salida");
   }
   
    /**
    * @author Perez, Pablo
    * @since 11/03/2006
    * @param  dtoE
    * @return void 
    * @throws MareException
    */  
    public void generarSolicitudes(DTOAtencionReclamoREC dtoE) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.generarSolicitudes(DTOAtencionReclamoREC):Entrada");
        UtilidadesLog.debug("**** Recibido parametro numAtencion = " + dtoE.getNumAtencion());

        UtilidadesLog.debug(dtoE);

        //LineasOperacionReclamoLocalHome lorLH = null;
        //LineasOperacionReclamoLocal linea = null;        
        DTOLineaOperacion dtoLinea = null;
        CabeceraReclamoLocalHome cabeceraLHome = null;
        CabeceraReclamoLocal cabeceraL = null;
        ClienteDatosBasicosLocalHome clienteHome = null;
        ClienteDatosBasicosLocal clienteLocal = null;
        OperacionesLocalHome operaLhome = null;
        OperacionesLocal operaL = null;
        MONGenerarSolicitudModulosExternosHome monGenerSolicModExtHome = null;
        MONGenerarSolicitudModulosExternos monGenerSolicModExt = null;
        
        SolicitudesOperacionLocalHome solOpera= null;
        DTOOperacion dtoOperacion;
        HashMap grupoOperaFactura = new HashMap();

        Long oidBoletaRecojo = null;
        
        DAOGestionRecojos daoGR = new DAOGestionRecojos();
        DAOCapturaProcesoReclamos daoCaptura = new DAOCapturaProcesoReclamos();
        long tiempoInic = System.currentTimeMillis();
        DTOOID dtoOid = new DTOOID();
        
        try  {
            
            Boolean crearBoletaRecojo = Boolean.FALSE;
            
            //Cambio 20080765 
            DTOBelcorp dtoPais = new DTOBelcorp();
            dtoPais.setOidPais(dtoE.getOidPais());
            RecordSet rsParamIntPais = daoGR.obtenerParametriaIntPais(dtoPais);
            Long cantRecojo =  bigDecimalToLong(rsParamIntPais.getValueAt(0,"VAL_CANT_RECO"));
            //- Cambio 20080765
            
            dtoOid.setOid(dtoE.getNumAtencion());
            dtoOid.setOidPais(dtoE.getOidPais());
            
            RecordSet lineasReclamo = new RecordSet();
            if(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())
               || ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){
                  lineasReclamo = daoCaptura.obtenerLineasDevuelveFacturadas(dtoOid);
               }else{
                  lineasReclamo = daoCaptura.obtenerLineasReclamo(dtoOid);
               }
            int cant = lineasReclamo.getRowCount();
            
            UtilidadesLog.debug("cant  " + cant);
            
            
            if(cant==0){
              // No hay lineas
              UtilidadesLog.debug("no hay lineas, no se genera solicitud");
              UtilidadesLog.info("MONCapturaProcesoReclamos.generarSolicitudes(DTOAtencionReclamoREC):Salida");
              return;
            }

            int i=0;
            
            solOpera = new SolicitudesOperacionLocalHome();
            
            //Cambio 20080765.
            Boolean continuarConMensajes = Boolean.valueOf(false);
            if((ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo()))&&(!Long.valueOf("1").equals(cantRecojo))){
                //Punto 3.3 del DECU.
                /*
                 * 3.3 Si el parámetro numero_recojo es igual a ‘PRNE’ y el valor del campo ‘cantidad recojo’ es diferente de 1, 
                 * entonces se continúa en el punto 17 del Flujo Normal, caso contrario se continua en el siguiente punto del FN.
                 */
                //El punto 17 es la ultima linea antes del catch generaMensaje para cada operacion de acuerdo a EbelNoticias
                continuarConMensajes = Boolean.TRUE;
            }
            //-Cambio 20080765.
            
            while (i < cant)  {
                UtilidadesLog.debug(" Procesando las lineas del reclamo " +i);
                Long oidOperacionAnterior =  bigDecimalToLong(lineasReclamo.getValueAt(i,"OIDOPERACION"));
                                     
                Boolean actualizarIndRecogibleAFalso = Boolean.valueOf(false);//Cambio 20080765  
                Boolean recojo = Boolean.valueOf(false);
                if(lineasReclamo.getValueAt(i,"IND_RECO").toString().equals("1")){
                   UtilidadesLog.debug("ReCoJo TRUE  ");
                   recojo = Boolean.TRUE;
                   // agregado por que si 
                   if(!ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())
                      && !ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){
                      
                      dtoE.setNumRecojo(ConstantesREC.RECOJO_INICIAL);
                       actualizarIndRecogibleAFalso = Boolean.TRUE;//Cambio 20080765. Previo a chequear que el producto sea No recogible.
                       crearBoletaRecojo = Boolean.TRUE; //Cambio 20080765.
                   } else if(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){
                       crearBoletaRecojo = Boolean.TRUE;  //Cambio 20080765.                     
                   } else {
                       crearBoletaRecojo = Boolean.FALSE;//Cambio 20080765.
                   }
                   //fin                   
                } else {
                    crearBoletaRecojo = Boolean.FALSE;//Cambio 20080765.
                }
                Boolean atendida = Boolean.valueOf(true);
                Boolean unidadesIguales = Boolean.valueOf(false);
                
                while ( i < cant && bigDecimalToLong(lineasReclamo.getValueAt(i,"OIDOPERACION")).equals(oidOperacionAnterior)) {
                    UtilidadesLog.debug("Por operacion  ");
                    //lorLH = new LineasOperacionReclamoLocalHome();
                    Long oidLineaOpera = bigDecimalToLong(lineasReclamo.getValueAt(i,"LINEAOPERACION"));
                    // - linea = Hacer "findByPrimaryKey" sobre la entidad REC:LineasOperacionReclamo
                    //linea = lorLH.findByPrimaryKey(oidLineaOpera);
                    dtoLinea = daoCaptura.obtenerLineaOperacionReclamo(oidLineaOpera);
                    
                    if (!continuarConMensajes) {//Cambio 20080765.
                        Long tipoMovimiento = bigDecimalToLong(lineasReclamo.getValueAt(i,"TIPOMOVIMIENTO"));
                        UtilidadesLog.debug("tipoMovimiento:  " + tipoMovimiento);
                        
                        UtilidadesLog.debug("Antes de asignar unidadesIguales");
                        
                        if (tipoMovimiento.longValue() == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.longValue())  { //- Si tipoMovimiento = ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE
    
                            UtilidadesLog.debug("Entro por if");                        
    
                            if(recojo.booleanValue()){
                                if(ConstantesREC.RECOJO_INICIAL.equals(dtoE.getNumRecojo())){
                                  if(lineasReclamo.getValueAt(i,"TSPA_OID_TIPO_SOLI_REC_INIC")!=null){
                                      //linea.setTipoSolicitud(new Long(lineasReclamo.getValueAt(i,"TSPA_OID_TIPO_SOLI_REC_INIC").toString()));
                                      dtoLinea.setOidTipoSolicitud(UtilidadesBD.convertirALong(lineasReclamo.getValueAt(i,"TSPA_OID_TIPO_SOLI_REC_INIC")));
                                  }
                                    //crearBoletaRecojo = Boolean.TRUE;//Cambio 20080765.
                                }
                                if(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){
                                    if(lineasReclamo.getValueAt(i,"TSPA_OID_TIPO_SOLI_PRI_NO_EXIT")!=null){
                                      //linea.setTipoSolicitud(new Long (lineasReclamo.getValueAt(i,"TSPA_OID_TIPO_SOLI_PRI_NO_EXIT").toString()));
                                      dtoLinea.setOidTipoSolicitud(UtilidadesBD.convertirALong(lineasReclamo.getValueAt(i,"TSPA_OID_TIPO_SOLI_PRI_NO_EXIT")));
                                     }       
                                    //crearBoletaRecojo = Boolean.TRUE;//Cambio 20080765.
                                }
                                if(ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){
                                  if(lineasReclamo.getValueAt(i,"TSPA_OID_SOLI_PAIS_SEG_NO_EXIT")!= null){
                                      //linea.setTipoSolicitud(new Long(lineasReclamo.getValueAt(i,"TSPA_OID_SOLI_PAIS_SEG_NO_EXIT").toString()));
                                      dtoLinea.setOidTipoSolicitud(UtilidadesBD.convertirALong(lineasReclamo.getValueAt(i,"TSPA_OID_SOLI_PAIS_SEG_NO_EXIT")));
                                  }         
                                   //crearBoletaRecojo = Boolean.FALSE; //Cambio 20080765.
                                }
                                
                            }else{
                               //linea.setTipoSolicitud(bigDecimalToLong(lineasReclamo.getValueAt(i,"TIPOSOLICITUDGENERA")));  
                               dtoLinea.setOidTipoSolicitud(UtilidadesBD.convertirALong(lineasReclamo.getValueAt(i,"TIPOSOLICITUDGENERA")));
                            }
                  
                            //linea.setAtendido(Boolean.TRUE);
                            dtoLinea.setAtendido(Boolean.TRUE);
                            boolean devueltoFisicoEnFactura = bigDecimalToBoolean(lineasReclamo.getValueAt(i,"DEVUELTOFISICO")).booleanValue();
                            Double pUnitario = bigDecimalToDouble(lineasReclamo.getValueAt(i,"PRECIOUNITARIO"));
    
                            if (devueltoFisicoEnFactura || (!devueltoFisicoEnFactura && 
                                                             pUnitario != null && pUnitario.doubleValue() == 0))  { //Si (devueltoFisicoEnFactura) o (!devueltoFisicoEnFactura y precioUnitario == 0)   //   <<22135>>
                                Long uDevueltas = bigDecimalToLong(lineasReclamo.getValueAt(i,"UDEVUELTAS"));
                                Long uReclamadas = bigDecimalToLong(lineasReclamo.getValueAt(i,"URECLAMADAS"));
                                
                                UtilidadesLog.debug("uDevueltas: " + uDevueltas);
                                UtilidadesLog.debug("uReclamadas: " + uReclamadas);
                                
                                if (uDevueltas.longValue() != uReclamadas.longValue())  {
                                    unidadesIguales = Boolean.FALSE;
                                } else {
                                    unidadesIguales = Boolean.TRUE;
                                }
                                
                            }
                            
                        } else { // Si tipoMovimiento = envia
                        
                            UtilidadesLog.debug("Entro por else");
                                            
                            Long uDevueltas = bigDecimalToLong(lineasReclamo.getValueAt(i,"UDEVUELTAS"));
                            Long uReclamadas = bigDecimalToLong(lineasReclamo.getValueAt(i,"URECLAMADAS"));
                            
                            if(uDevueltas==null){
                                uDevueltas = new Long(0);
                            }
                            
                            if(uReclamadas==null){
                                uReclamadas = new Long(0);
                            }
                            
                            UtilidadesLog.debug("uDevueltas: " + uDevueltas);
                            UtilidadesLog.debug("uReclamadas: " + uReclamadas);
                            
                            if (uDevueltas.longValue() != uReclamadas.longValue())  {
                                unidadesIguales = Boolean.FALSE;
                            } else {
                                unidadesIguales = Boolean.TRUE;
                            } 
                            
                            Long tipoSolicitud2 = bigDecimalToLong(lineasReclamo.getValueAt(i,"TIPOSOLICITUD2"));
                            
                            UtilidadesLog.debug("tipoSolicitud2: " + tipoSolicitud2);
                            if (tipoSolicitud2 != null)  {  //Si tipoSolicitud2 <> NULL
                                Long saldo = bigDecimalToLong(lineasReclamo.getValueAt(i,"SALDO"));
                                UtilidadesLog.debug("saldo: " + saldo);
                                if (saldo.intValue() < uReclamadas.intValue())  { // no hay stock
                                    //linea.setTipoSolicitud(tipoSolicitud2);
                                    //linea.setAtendido(Boolean.FALSE);
                                    dtoLinea.setOidTipoSolicitud(tipoSolicitud2);
                                    dtoLinea.setAtendido(Boolean.FALSE);
                                    atendida = Boolean.FALSE;
                                } else {    // si hay stock
                                    //linea.setTipoSolicitud(bigDecimalToLong(lineasReclamo.getValueAt(i,"TIPOSOLICITUD1")));
                                    //linea.setAtendido(Boolean.TRUE);
                                    dtoLinea.setOidTipoSolicitud(UtilidadesBD.convertirALong(lineasReclamo.getValueAt(i,"TIPOSOLICITUD1")));
                                    dtoLinea.setAtendido(Boolean.TRUE);
                                }
                            } else { //Si tipoSolicitud2 == NULL 
                                //linea.setTipoSolicitud(bigDecimalToLong(lineasReclamo.getValueAt(i,"TIPOSOLICITUD1")));
                                //linea.setAtendido(Boolean.TRUE);
                                dtoLinea.setOidTipoSolicitud(UtilidadesBD.convertirALong(lineasReclamo.getValueAt(i,"TIPOSOLICITUD1")));
                                dtoLinea.setAtendido(Boolean.TRUE);
                            }
                            
                        }
                        UtilidadesLog.debug("unidadesIguales: " + unidadesIguales);
                    }
                    //Punto 3.2
                    if (actualizarIndRecogibleAFalso) {//Cambio 20080765  
                        if (!Long.valueOf("0").equals((bigDecimalToLong(lineasReclamo.getValueAt(i,"RECO"))))){
                            //linea.setIndicadorRecogible(new Character('N'));
                            dtoLinea.setIndicadorRecogible(Character.valueOf('N'));
                        }
                    }//-Cambio 20080765  
                    //lorLH.merge(linea);
                    daoCaptura.actualizarLineaOperacionReclamo(dtoLinea);
                    
                    i++;
                }
                
                if (!continuarConMensajes) {//Cambio 20080765.
                    Long oidOperacion = bigDecimalToLong(lineasReclamo.getValueAt(i-1,"OIDOPERACION"));
                    Boolean espera = bigDecimalToBoolean(lineasReclamo.getValueAt(i-1,"ESPERA"));
    
                    UtilidadesLog.debug("oidOperacion: " + oidOperacion);
                    UtilidadesLog.debug("espera: " + espera);
                    
                    //orLH = getOperacionReclamoLocalHome();
                    //operacion = orLH.findByPrimaryKey(oidOperacion);
                    
                    //operacion.setAtendido(atendida);
                    
                   Long operacionMercaderia = null;
                    if(!espera.booleanValue() && recojo.booleanValue()){
                          //operacion.setIndicativoEntregaMercaderia(ConstantesREC.IND_MERCADERIA_C); 
                           operacionMercaderia = ConstantesREC.IND_MERCADERIA_C;
    
                    }else{
                      if (!espera.booleanValue())  {
                          //operacion.setIndicativoEntregaMercaderia(ConstantesREC.IND_MERCADERIA_C);
                          operacionMercaderia = ConstantesREC.IND_MERCADERIA_C;
                      } else {
                           if (unidadesIguales.booleanValue())  {
                              //operacion.setIndicativoEntregaMercaderia(ConstantesREC.IND_MERCADERIA_S);
                              operacionMercaderia = ConstantesREC.IND_MERCADERIA_S;
                          } else {  // !unidadesIguales
                              //operacion.setIndicativoEntregaMercaderia(ConstantesREC.IND_MERCADERIA_N);
                              operacionMercaderia = ConstantesREC.IND_MERCADERIA_N;
                          }    
                      }
                    }
                    this.actualizarLineasOperacion(oidOperacion, null, atendida, operacionMercaderia);
                }
            }/* - Fin Para   operaciones */            
            
            //Codigo Movido X1 abajo por Cambio 20080765

            //Punto 3.1
            // vbongiov -- Cambio 20080765  RI SiCC 20091737 -- 25/11/2009
            if (Long.valueOf("1").equals(cantRecojo) && !ConstantesREC.RECOJO_INICIAL.equals(dtoE.getNumRecojo())){
                crearBoletaRecojo = Boolean.FALSE;
                //Si es distinto a 1 sigue como ya venia true o false.
            }//-Cambio 20080765  
            
            UtilidadesLog.debug("Crea Boleta ?  "+ crearBoletaRecojo);
             UtilidadesLog.debug("DTO para CrearBoleta: "+ dtoE);                    
             if(crearBoletaRecojo.booleanValue()){
                oidBoletaRecojo = this.crearBoletaRecojo(dtoE);
             }
             UtilidadesLog.debug("Creo Boleta ");
            //end Punto 3.1
            
             if (!continuarConMensajes) {//Cambio 20080765.
                //Movido X1 aqui por Cambio 20080765
                RecordSet lineasRecSolicitud = daoCaptura.obtenerLineasPorSolicitud(dtoE);
                UtilidadesLog.debug("despues de obtenerlineas por solicitud....  ");
                
                int cantLineasSol = lineasRecSolicitud.getRowCount();
                
                UtilidadesLog.debug("cantLineasSol: " +  cantLineasSol);
                
                /*-> Llamar al metodo DAOCapturaProcesoReclamos.obtenerLineasPorSolicitud() enviando el numAtencion recibido al inicio del metodo
                -> Recorrer RecordSet devuelto
                -> Para cada valor distinto de oidTipoSolicitud: */
                int j = 0;
                while (j<cantLineasSol)  {
                    UtilidadesLog.debug("Primer while: " + j);
                    Vector oidsOperacion = new Vector();
                    ArrayList arrPosiciones = new ArrayList();
                    DTOCabeceraSolicitud dtoCabeceraSolicitud = new DTOCabeceraSolicitud();
    
                    Long oidCliente = bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"OIDCLIENTE"));    
                    clienteHome = new ClienteDatosBasicosLocalHome();
                    clienteLocal = clienteHome.findByPrimaryKey(oidCliente);               
                    String codigoCliente = clienteLocal.getCod_clie();
                    dtoCabeceraSolicitud.setOidCliente(oidCliente);
                    dtoCabeceraSolicitud.setCliente(codigoCliente);
                    
                    dtoCabeceraSolicitud.setOidPais(dtoE.getOidPais());
                    dtoCabeceraSolicitud.setOidIdioma(dtoE.getOidIdioma());
                    dtoCabeceraSolicitud.setMarca(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"MARCA")));
                    dtoCabeceraSolicitud.setCanal(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"CANAL")));
                    dtoCabeceraSolicitud.setAcceso(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"ACCESO")));
                    dtoCabeceraSolicitud.setSubacceso(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"SUBACCESO")));
                    dtoCabeceraSolicitud.setPeriodo(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"OIDPERIODO")));
                    
                    if(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())
                       || ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){
                        dtoCabeceraSolicitud.setPeriodo(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"PERIODOFACTURACION")));
                        java.sql.Date fecha = (java.sql.Date) (lineasRecSolicitud.getValueAt(j,"FECHAFACT"));
                        java.util.Date fechaASetear = new Date(fecha.getTime());
                        dtoCabeceraSolicitud.setFecha(fechaASetear);                               
                        
                     } else {
                        // Modificado por HRCS - Fecha 08/03/2007 - Cambio SICC-GCC-REC-007-Periodo de Reclamo_V3
                        // Nuevo dato a enviar: Fecha en Cabecera Solicitud. Es utilizada en las validaciones cuando se genera la solicitud. 
                        // La validacion exacta es de Cronograma en validaciones generales. Se obtiene:
                        // Si el periodo reclamo es igual al actual, entonces no es necesario enviar fecha porque se obtendra del sistema. 
                        // Pero si el periodo reclamo es posterior al actual, entonces se debe enviar la fecha de inicio del periodo reclamo 
                        // como fecha en la cabecera.
                        DTOPeriodo dtoPeriodo = this.getMONPeriodos().obtienePeriodoActual( dtoE.getOidPais(), 
                                                                                            dtoCabeceraSolicitud.getMarca(), 
                                                                                            dtoCabeceraSolicitud.getCanal() );
                        Long periodoActual = dtoPeriodo.getOid();   // Oid del periodo actual
                        if ( dtoCabeceraSolicitud.getPeriodo().longValue() > periodoActual.longValue() ) {
                        
                            PeriodoLocalHome  pLH = new PeriodoLocalHome();
                            PeriodoLocal periodo = null;
                            try{
                                periodo = pLH.findByPrimaryKey( dtoCabeceraSolicitud.getPeriodo() );    // busca el periodo de reclamo
                            } catch (NoResultException ex){
                                UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitudes: FinderException -> Periodo:", ex);
                                ctx.setRollbackOnly();
                                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                            }catch(PersistenceException e) {
                               ctx.setRollbackOnly();
                               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                               throw new MareException(e, UtilidadesError.armarCodigoError(error));
                            }   
                            // Setea la fecha de inicio del periodo en la fecha de la cabecera solicitud
                            dtoCabeceraSolicitud.setFecha( periodo.getFechainicio() );
                        }
                    }
                   
                    dtoCabeceraSolicitud.setOidDocumentoReferencia(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"OIDSOLICITUDREFERENCIA")));
                    dtoCabeceraSolicitud.setNumeroDocumentoOrigen(dtoE.getNumAtencion());
                    dtoCabeceraSolicitud.setModulo(Long.valueOf(ConstantesSEG.MODULO_REC));
                    dtoCabeceraSolicitud.setOperacion(ConstantesBEL.REC039);
                    //dtoCabeceraSolicitud.setIndPedidoPrueba();
                    
                    Long oidTipoSolicitud = bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDTIPOSOLICITUD"));                
                    Long tipoSoliciAnterior =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDTIPOSOLICITUD"));
                    
                    while (j<cantLineasSol && bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDTIPOSOLICITUD")).equals(tipoSoliciAnterior)){
                        UtilidadesLog.debug("segundo while:  " + j);
                        /*Long operacionAnterior =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDOPERACION"));
                        while (j<cantLineasSol && bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDOPERACION")).equals(operacionAnterior)){   */
                        
                        dtoOperacion = new DTOOperacion();
                        dtoOperacion.setOidOperacion(bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDOPERACION")));
                        dtoOperacion.setOidPais(dtoE.getOidPais());
                        RecordSet rsOperacion = daoCaptura.obtenerDatosPerdida(dtoOperacion, bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDTIPOSOLICITUD")));
                        int k=0;
                        while (k < rsOperacion.getRowCount()) {
                            UtilidadesLog.debug("tercer while :  " + k);
                            DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud();
                            dtoPosicion.setCodigoVenta((String)rsOperacion.getValueAt(k, "CODVENTA"));
                            dtoPosicion.setProducto(bigDecimalToLong(rsOperacion.getValueAt(k, "OIDPRODUCTO")));
                            
                            
                            Long tipoMovimiento = bigDecimalToLong(rsOperacion.getValueAt(k, "TIPOMOVIMIENTO"));
                            Long devuelveEstaFact = bigDecimalToLong(rsOperacion.getValueAt(k, "IND_DEVU_ESTA_FACT"));
                            
                            //Cambio 20080545
                            if (tipoMovimiento.equals(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE) && 
                                rsOperacion.getValueAt(k,"IND_FALT_MERC").toString().equals("1") && 
                                rsOperacion.getValueAt(k,"IND_DEVU_FISI_FACT").toString().equals("0") && 
                                rsOperacion.getValueAt(k,"OIDPOSICION")==null){
                              UtilidadesLog.debug("Devuelve Logico del Error de Sacado ");
                              UtilidadesLog.debug("NO se genera la Posicion: " + k);
                              k++;
                              continue;
                            }
                            
                            //if(!ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){//Cambio 20080765  
                              if (tipoMovimiento.equals(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE) &&  
                                  devuelveEstaFact.equals(new Long(1)) && 
                                  rsOperacion.getValueAt(k,"OIDPOSICION")!=null)  {
                                  
                                  // vbongiov -- SiCC 20090852 -- 6/03/2009
                                  if(((BigDecimal)rsOperacion.getValueAt(k, "PRECIOCATAUNITARIOLOCAL"))!= null){
                                    dtoPosicion.setPrecioCatalogoUnitarioLocal(((BigDecimal)rsOperacion.getValueAt(k, "PRECIOCATAUNITARIOLOCAL")).setScale(decimales, BigDecimal.ROUND_HALF_UP));
                                  }
                              } else {
                                  dtoPosicion.setPrecioCatalogoUnitarioLocal((BigDecimal)rsOperacion.getValueAt(k, "PRECIO"));
                              }
                           /* }else{
                               dtoPosicion.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
                              }*///Cambio 20080765  
                            /*
                            val_prec_cata_unit_loca AS preciocataunitariolocal,
                            val_prec_cont_unit_loca AS preciocontunitariolocal, *
                            val_impo_desc_unit_loca AS impdescunilocal, 
                            val_porc_desc AS porcentajedesc,*
                            val_prec_cata_unit_docu AS preccataunidocu,
                            val_prec_conta_unit_docu AS preccontunidocu, 
                            val_impo_desc_unit_docu AS impdescunidocu 
                             */
                            //if(!ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){//Cambio 20080765  
                            
                              dtoPosicion.setPrecioContableUnitarioLocal((BigDecimal)rsOperacion.getValueAt(k, "PRECIOCONTUNITARIOLOCAL"));
                              dtoPosicion.setImporteDescuentoUnitarioLocal((BigDecimal)rsOperacion.getValueAt(k, "IMPDESCUNILOCAL"));
                              dtoPosicion.setPorcentajeDescuento(bigDecimalToDouble((BigDecimal)rsOperacion.getValueAt(k, "PORCENTAJEDESC")));
                              dtoPosicion.setPrecioCatalogoUnitarioDocumento((BigDecimal)rsOperacion.getValueAt(k, "PRECCATAUNIDOCU"));
                              dtoPosicion.setPrecioContableUnitarioDocumento((BigDecimal)rsOperacion.getValueAt(k, "PRECCONTUNIDOCU"));
                              dtoPosicion.setImporteDescuentoUnitarioDocumento((BigDecimal)rsOperacion.getValueAt(k, "IMPDESCUNIDOCU"));
                              
                            /*}else{
                              dtoPosicion.setPrecioContableUnitarioLocal(new BigDecimal(0));
                              dtoPosicion.setImporteDescuentoUnitarioLocal(new BigDecimal(0));
                              dtoPosicion.setPorcentajeDescuento(bigDecimalToDouble(new BigDecimal(0)));
                              dtoPosicion.setPrecioCatalogoUnitarioDocumento(new BigDecimal(0));
                              dtoPosicion.setPrecioContableUnitarioDocumento(new BigDecimal(0));
                              dtoPosicion.setImporteDescuentoUnitarioDocumento(new BigDecimal(0));
                            }*///Cambio 20080765  
                            //se agrega el dato del detalle de oferta en la posicion que se
                            //genera por reclamo por incidencia de aceptacion. (Gacevedo 04/10/2006)
                            if(rsOperacion.getValueAt(k, "DETALLEOFERTA")!=null){
                               dtoPosicion.setOidDetalleOferta(new Long(rsOperacion.getValueAt(k, "DETALLEOFERTA").toString()));
                            }
                            
                            long uDemandadas = bigDecimalToLong(rsOperacion.getValueAt(k, "UDEMANDADAS")).longValue();
                            
                           
                            // PTO 11 FN (Unid Deman) Cambio 20080765  
                            if (tipoMovimiento.intValue() == ConstantesREC.TIPO_MOVIMIENTO_ENVIA.intValue() )  {
                                dtoPosicion.setUnidadesDemandadas(new Long(uDemandadas));
                            }  else if (tipoMovimiento.intValue() == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.intValue() )  {
                                if ((dtoE.getNumRecojo().equals(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO))||
                                    (dtoE.getNumRecojo().equals(ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO))){
                                        dtoPosicion.setUnidadesDemandadas(new Long(uDemandadas));
                                    } else {//ConstantesREC.RECOJO_INICIAL
                                        dtoPosicion.setUnidadesDemandadas(new Long(uDemandadas* (-1)));//A pedido de Vanesa 20080765
                                    }
                            }                           
                           
                            //-Cambio 20080765  
        
                            arrPosiciones.add(dtoPosicion);
                            UtilidadesLog.debug("oidlinea " + rsOperacion.getValueAt(k, "OIDLINEA") );
                            //lorLH = new LineasOperacionReclamoLocalHome();                        
                            //linea = lorLH.findByPrimaryKey(bigDecimalToLong(rsOperacion.getValueAt(k, "OIDLINEA")));
                            dtoLinea = daoCaptura.obtenerLineaOperacionReclamo(UtilidadesBD.convertirALong(rsOperacion.getValueAt(k, "OIDLINEA")));
                            //UtilidadesLog.debug("linea  " + linea);
                            UtilidadesLog.debug("*** dtoLinea: " + dtoLinea);
                            if(!ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo()) || 
                                  ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){
                              //linea.setIndicadorEstado(ConstantesREC.ESTADO_LINEA_ENVIADO);
                              dtoLinea.setIndicadorEstado(ConstantesREC.ESTADO_LINEA_ENVIADO);
                              //lorLH.merge(linea);
                              daoCaptura.actualizarLineaOperacionReclamo(dtoLinea);
                            }
                            k++;
                        }     
                        
                        oidsOperacion.add(dtoOperacion.getOidOperacion());
                        
                        Boolean perdida = null;
                        Long asumePerdida = null;
    
                        if (rsOperacion != null && !rsOperacion.esVacio()){
                            perdida = bigDecimalToBoolean(rsOperacion.getValueAt(0,"PERDIDA"));
                            asumePerdida = bigDecimalToLong(rsOperacion.getValueAt(0,"ASUMEPERDIDA"));
                        }
                        
                        if ((!ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo()) || 
                                  ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo()))&&((perdida != null && perdida.booleanValue() == true) &&
                                (asumePerdida == null || asumePerdida.longValue() != ConstantesREC.ASUME_BELCORP.longValue()))){
    
                            Long solicitudPerdida = bigDecimalToLong(rsOperacion.getValueAt(0,"SOLICITUDPERDIDA"));
                            operaLhome = new OperacionesLocalHome();
                            operaL = operaLhome.findByPrimaryKey(bigDecimalToLong(rsOperacion.getValueAt(0,"OID_OPER")));
                            operaL.setTipoSolicitudPerdida(solicitudPerdida);
                            operaLhome.merge(operaL);
                            dtoCabeceraSolicitud.setTipoSolicitud(solicitudPerdida);
                            dtoCabeceraSolicitud.setOidTipoSolicitud(solicitudPerdida);
                            DTOPosicionSolicitud  posSolicitud = null;
                            
                            if (asumePerdida != null && asumePerdida.longValue() == ConstantesREC.ASUME_CLIENTE.longValue()) {
                                    posSolicitud = new DTOPosicionSolicitud();
                                    posSolicitud.setCodigoVenta((String)rsOperacion.getValueAt(0,"CODVENTA"));
                                    posSolicitud.setProducto(bigDecimalToLong(rsOperacion.getValueAt(0,"OIDPRODUCTO")));
                                    posSolicitud.setPrecioCatalogoUnitarioLocal((BigDecimal)rsOperacion.getValueAt(0,"MONTOPERDIDA"));
                                    posSolicitud.setUnidadesDemandadas(bigDecimalToLong(rsOperacion.getValueAt(0,"UDEMANDADAS")));
                                    dtoCabeceraSolicitud.setOidCliente(bigDecimalToLong(rsOperacion.getValueAt(0,"RESPONSABLEPERDIDA")));                                    
                            } else if (asumePerdida != null && asumePerdida.longValue() == ConstantesREC.ASUME_SEGURO.longValue())  {
                                posSolicitud = new DTOPosicionSolicitud();
                                posSolicitud.setProducto(bigDecimalToLong(rsOperacion.getValueAt(0,"OIDARTICULO")));
                                posSolicitud.setPrecioCatalogoUnitarioLocal((BigDecimal)rsOperacion.getValueAt(0,"MONTOPERDIDA"));
                                posSolicitud.setUnidadesDemandadas(new Long(1));
                                dtoCabeceraSolicitud.setOidCliente(bigDecimalToLong(rsOperacion.getValueAt(0,"CLIENTESEGURO")));
                            }
                            
                            if (posSolicitud != null)  {
                                monGenerSolicModExtHome = this.getMONGenerarSolicitudModulosExternosHome();
                                monGenerSolicModExt = monGenerSolicModExtHome.create();
                                ArrayList arr = new ArrayList();
                                arr.add(posSolicitud);
                                dtoCabeceraSolicitud.setPosiciones(arr);
                                UtilidadesLog.debug("Antes de generar modulos externos 1: " + dtoCabeceraSolicitud);    
                                monGenerSolicModExt.generaSolicitud(dtoCabeceraSolicitud);
                            }
                        }
                        
                        j = k > 0 ? j + k : j + 1;
                    }
                    
                    dtoCabeceraSolicitud.setOidCliente(oidCliente);
                    dtoCabeceraSolicitud.setCliente(codigoCliente);
                    dtoCabeceraSolicitud.setPosiciones(arrPosiciones);
                    dtoCabeceraSolicitud.setTipoSolicitud(oidTipoSolicitud);
                    dtoCabeceraSolicitud.setOidTipoSolicitud(oidTipoSolicitud);
                    
                    UtilidadesLog.debug("Antes de generar modulos externos: " + dtoCabeceraSolicitud);                
                    monGenerSolicModExtHome = this.getMONGenerarSolicitudModulosExternosHome();
                    monGenerSolicModExt = monGenerSolicModExtHome.create();
                    DTOOID dtoOidCabecera = monGenerSolicModExt.generaSolicitud(dtoCabeceraSolicitud);
                    
                    Long conso = daoCaptura.obtieneConsolidado(dtoOidCabecera.getOid(),oidBoletaRecojo); 
                    
                    HashMap grupo = new HashMap();
                   
                    for (int h=0; h<oidsOperacion.size(); h++)  {
                        if(grupo.get(new Long(oidsOperacion.get(h).toString()))==null)   {
                           grupo.put(new Long(oidsOperacion.get(h).toString()),new Long(oidsOperacion.get(h).toString()));
                           if(conso!=null){
                                grupoOperaFactura.put(new Long(oidsOperacion.get(h).toString()),new Long(oidsOperacion.get(h).toString()));
                           }
                         //solOpera.create((Long)oidsOperacion.get(h), dtoOidCabecera.getOid(), dtoCabeceraSolicitud.getTipoSolicitud() );
                        }
                    }
                   
                    Iterator k = grupo.keySet().iterator();
                    while(k.hasNext()){
                        String clave = k.next().toString();
                       
                        solOpera.create(new Long(clave), dtoOidCabecera.getOid(), dtoCabeceraSolicitud.getTipoSolicitud() );
                        //new DAORec().grabarSolicitudReclamo(new Long(clave), dtoOidCabecera.getOid(), dtoCabeceraSolicitud.getTipoSolicitud() );
                        
                    }
                    
                   
                }
               
               
               
               //REC-004
               //REC-004
               
               this.generarSolicitudesPremio(dtoE);
               
               //REC-004
               //REC-004
               
                
                long tiempoFin = System.currentTimeMillis();
                long tiempoTotal = tiempoFin - tiempoInic;
                UtilidadesLog.debug("Tiempo del procesamiento de las solicituds: " + tiempoTotal);
                RecordSet rsEstadoLineas = daoCaptura.obtenerEstadoLineasReclamo(dtoE.getNumAtencion());
                int cantLineasEnviadas = rsEstadoLineas.getRowCount();
                Long estadoOperaXlinea = new Long(0);
                if(cantLineasEnviadas > 0){
                    // se toma el estado de la operacion , de la primera linea. V-REC-15
                    estadoOperaXlinea = new Long(((BigDecimal)rsEstadoLineas.getValueAt(0,"OIDESTADOPERA")).longValue());
                }
                int h = 0;
                while (h<cantLineasEnviadas)  {
                    boolean lineasEnviadas = true;
                    Long oidOperAnterior = bigDecimalToLong(rsEstadoLineas.getValueAt(h,"OIDOPERACION"));
                    while (h<cantLineasEnviadas && oidOperAnterior.equals(bigDecimalToLong(rsEstadoLineas.getValueAt(h,"OIDOPERACION")))) {
                        if (lineasEnviadas){
                            String estado = (String)rsEstadoLineas.getValueAt(h,"ESTADOLINEA");
                            if (!estado.equals(String.valueOf(ConstantesREC.ESTADO_LINEA_ENVIADO)))  {
                                lineasEnviadas = false;
                            }
                        }
                        h++;
                    } 
                    
                    
                    //orLH = getOperacionReclamoLocalHome();
                    //operacion = orLH.findByPrimaryKey(oidOperAnterior);
                    if((grupoOperaFactura.get(oidOperAnterior))!=null){
                        this.actualizarLineasOperacion(oidOperAnterior,ConstantesREC.ESTADO_OPERACION_FACTURADO, null, null);
                    }else{
                        if ((!ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo()) || 
                                  ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())) && lineasEnviadas)  {
                            this.actualizarLineasOperacion(oidOperAnterior, ConstantesREC.ESTADO_OPERACION_ENVIADO, null, null);
                            //operacion.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_ENVIADO);
                        } else {
                            if(estadoOperaXlinea.longValue() != ConstantesREC.ESTADO_OPERACION_BLOQUEO.longValue()) {
                                //operacion.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_PARCIAL);  
                                this.actualizarLineasOperacion(oidOperAnterior, ConstantesREC.ESTADO_OPERACION_PARCIAL, null, null);
                            }                  
                        }
                     }
                }
    
                RecordSet rsEstadoOperaciones = daoCaptura.obtenerEstadoOperacionesReclamo(dtoE.getNumAtencion());
                int cantOperacionEnviadas = rsEstadoOperaciones.getRowCount();
                boolean operacionesEnviadas = true;
                boolean operacionesFacturadas = true;
                
                Long estadoOpera; 
                for (int f=0; f< cantOperacionEnviadas; f++)  {
                    estadoOpera =  bigDecimalToLong(rsEstadoOperaciones.getValueAt(f,"ESTADOOPERACION"));
                    if (estadoOpera.intValue() != ConstantesREC.ESTADO_OPERACION_FACTURADO.intValue())  {
                       operacionesFacturadas = false;
                       if (estadoOpera.intValue() != ConstantesREC.ESTADO_OPERACION_ENVIADO.intValue())  {
                            operacionesEnviadas = false;
                            break;
                        }
                    }
                }
    
                cabeceraLHome = new CabeceraReclamoLocalHome();
                cabeceraL = cabeceraLHome.findByUK(dtoE.getNumAtencion(), dtoE.getOidPais());
                
                
                    if (operacionesEnviadas)  {
                        if(operacionesFacturadas){
                            cabeceraL.setEstadoReclamo(ConstantesREC.ESTADO_RECLAMO_FACTURADO);
                        }else{
                            cabeceraL.setEstadoReclamo(ConstantesREC.ESTADO_RECLAMO_ENVIADO);
                        }
                    } else {
                        cabeceraL.setEstadoReclamo(ConstantesREC.ESTADO_RECLAMO_PARCIAL);
                    }
                
                cabeceraLHome.merge(cabeceraL);
            }
            DTOOID dtoOidNumeAtencion = new DTOOID();
            dtoOidNumeAtencion.setOid(dtoE.getNumAtencion());
            dtoOidNumeAtencion.setOidIdioma(dtoE.getOidIdioma());
            dtoOidNumeAtencion.setOidPais(dtoE.getOidPais());
            
            generarMensajes(dtoOidNumeAtencion, dtoE.getNumRecojo());


      
        /*} catch (NoResultException ex)  {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitud: FinderException", ex);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));*/
        }catch (RemoteException ex)  {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitud: RemoteException", ex);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        } catch (MareException ex)  {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitud: MareException", ex);
            throw ex;
        } catch (Exception ex)  {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitud: Exception", ex);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.generarSolicitudes(DTOAtencionReclamoREC):Salida");
    }
   

   
  /**
   * @author Emilio Noziglia
   * @since 18/10/2005
   * @param  dto  
   * @return void 
   * @throws MareException
   * @reference UBEL004
   */ 
   public void generarMensajes(DTOOID dto, String numeroRecojo) throws MareException {
      UtilidadesLog.info("MONCapturaProcesoReclamos.generarMensajes(DTOOID):Entrada");
      /*Con el parametro recibido llamar al metodo obtenerOperacionesLineaReclamo
       * (numAtencion:Long):RecordSet del DAOCapturaProcesoReclamos
       * */
       if(numeroRecojo==null){
         numeroRecojo = "";
       }
      DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
      RecordSet respuesta = null;
      BigDecimal precioEnvia = new BigDecimal(0);
      BigDecimal precioDevuelve = new BigDecimal(0); 
      respuesta = dao.obtenerOperacionesLineaReclamo(dto);
      boolean flag = false;
      if (!respuesta.esVacio()) {

        DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
        // int cantFilas = respuesta.getRowCount();
         for (int i=0; i<respuesta.getRowCount(); i++) {
            String codigoMensaje  = "";
            /*Si ebelNoticias=True { 
              Si tipoSolicitud2 <> NULL { 
              si saldo >= uReclamadas { // hay stock 
                codigoMensaje = "REC02" } 
              si no { // no hay stock 
                codigoMensaje = codigoTS2 } 
             } */
            Boolean ebelNoticias = 
                      Boolean.valueOf(respuesta.getValueAt(i,"EBELNOTICIAS") != null &&
                                      respuesta.getValueAt(i,"EBELNOTICIAS").toString().equals("1") ? true : false);
            if (ebelNoticias.booleanValue()&&
                  (!ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(numeroRecojo)||
                        !ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(numeroRecojo)) ) {   
            //comentado por PPerez
            /*   if (respuesta.getValueAt(i,"TIPOSOLICITUD2") != null) {
                  Long saldo = 
                         Long.valueOf(respuesta.getValueAt(i,"UATENDIDAS") != null ?
                                      respuesta.getValueAt(i,"UATENDIDAS").toString() : "0");
                        
                  Long uReclamadas = 
                         Long.valueOf(respuesta.getValueAt(i,"URECLAMADAS") != null ?
                                      respuesta.getValueAt(i,"URECLAMADAS").toString() : "0");
                        
                  if (saldo.longValue() >= uReclamadas.longValue()){
                     codigoMensaje = "REC02";
                  } else {
                     codigoMensaje = 
                                respuesta.getValueAt(i,"CODIGOTS2").toString();
                  }
               }*/
                    
               //Si (codigoMensaje = "REC02" o "REC03" o "REC04") 
              //y tipoMovimiento = ConstantesREC.TIPO_MOVIMIENTO_ENVIA { 
              /*BigDecimal bigTipoMov = 
                            (BigDecimal)respuesta.getValueAt(i,"TIPOMOVIMIENTO");*/
              Long tipoMovimiento = Long.valueOf(((BigDecimal)respuesta.getValueAt(i,"TIPOMOVIMIENTO")).toString());
                    
              // *********************************************************
              // Eliminado por ssantana, 20/9/2005, segun SICC-GCC-REC-003
              // *********************************************************
              /*if((codigoMensaje.equals("REC02")||codigoMensaje.equals("REC03")||
                  codigoMensaje.equals("REC04"))&& tipoMovimiento.longValue() ==  ConstantesREC.TIPO_MOVIMIENTO_ENVIA.longValue()){
                  //Para cada oidLinea // 1 mensaje por cada linea envia 
                      
                  //Crear un dto de tipo DTOBuzonMensajes con los valores del registro:
                  DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
                  dtoBuzon.setOidPais(dto.getOidPais());
                  dtoBuzon.setCodigoMensaje(codigoMensaje);
                  //dtoBuzon.setCodigoPatron((respuesta.getValueAt(i,"CODIGOCLIENTE")).toString());
                  dtoBuzon.setOidCliente(new Long(respuesta.getValueAt(i,"CODIGOCLIENTE").toString()));
                  dtoBuzon.setModuloOrigen(new Long(15));
                  //datos variables:
                  dtoBuzon.setDatoVariable1(respuesta.getValueAt(i,"CODIGOCLIENTE") != null ?
                                          respuesta.getValueAt(i,"CODIGOCLIENTE").toString() : "");
                  dtoBuzon.setDatoVariable2(respuesta.getValueAt(i,"NOMBRE") != null ?
                                          respuesta.getValueAt(i,"NOMBRE").toString() : "");
                  dtoBuzon.setDatoVariable3(respuesta.getValueAt(i,"APELLIDO") != null ? 
                                          respuesta.getValueAt(i,"APELLIDO").toString() : "");
                  dtoBuzon.setDatoVariable4(respuesta.getValueAt(i,"NUMDOCUREFERENCIA") != null ?
                                          respuesta.getValueAt(i,"NUMDOCUREFERENCIA").toString() : "");
                  dtoBuzon.setDatoVariable5(respuesta.getValueAt(i,"PERIDOREFERENCIA") != null ?
                                          respuesta.getValueAt(i,"PERIDOREFERENCIA").toString() : "");
                  dtoBuzon.setDatoVariable6(respuesta.getValueAt(i,"PERIODORECLAMO") != null ? 
                                          respuesta.getValueAt(i,"PERIODORECLAMO").toString() : "");
                  dtoBuzon.setDatoVariable7(respuesta.getValueAt(i,"CODOPERACION") != null ? 
                                          respuesta.getValueAt(i,"CODOPERACION").toString() : "");
                  dtoBuzon.setDatoVariable8(respuesta.getValueAt(i,"NOMBREOPERACION") != null ?
                                          respuesta.getValueAt(i,"NOMBREOPERACION").toString() : "");
                  dtoBuzon.setDatoVariable9(respuesta.getValueAt(i,"CODVENTA") != null ?
                                          respuesta.getValueAt(i,"CODVENTA").toString() : "");
                  dtoBuzon.setDatoVariable10(respuesta.getValueAt(i,"DESCPRODUCTO") != null ?
                                          respuesta.getValueAt(i,"DESCPRODUCTO").toString() : "");
                  dtoBuzon.setDatoVariable11(respuesta.getValueAt(i,"URECLAMADAS") != null ? 
                                          respuesta.getValueAt(i,"URECLAMADAS").toString() : "");
                  dtoBuzon.setDatoVariable12(respuesta.getValueAt(i,"UATENDIDAS") != null ?
                                          respuesta.getValueAt(i,"UATENDIDAS").toString() : "");
                  dtoBuzon.setDatoVariable13(respuesta.getValueAt(i,"MOTIVORECHAZODESBLOQUEO") != null ? 
                                          respuesta.getValueAt(i,"MOTIVORECHAZODESBLOQUEO").toString() : "");
                  dtoBuzon.setDatoVariable14(respuesta.getValueAt(i,"ESTADOOPERACION") != null ? 
                                          respuesta.getValueAt(i,"ESTADOOPERACION").toString() : "");
                  dtoBuzon.setListaConsultoras("N");
                  //codigo de patron, permanencia del mensaje, canal y periodo vacios
                  
                  //Añadido por la incidencia BELC300014171
                  MONGestionMensajes monGestionMensajes = null;
                  monGestionMensajes = this.getMONGestionMensajes();
                  try{
                      monGestionMensajes.insertaDatosMensaje(dtoBuzon);
                  }catch(RemoteException re){
                      
                      ctx.setRollbackOnly();
                      UtilidadesLog.error(
                      "****Metodo generarMensajes: ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
                      throw new MareException(new Exception(),
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  }
              }*/
              // *************************************************************
              // Fin Eliminado por ssantana, 20/9/2005, segun SICC-GCC-REC-003
              // *************************************************************
                     
              codigoMensaje = respuesta.getValueAt(i,"CODIGOTS2").toString();                     
                    //Si (codigoMensaje = "REC01" { // 1 mensaje por cada operacion 
              if (codigoMensaje.equals("REC01")) {
                 //Crear un dto de tipo DTOBuzonMensajes con los valores del registro:
                 flag = true;
                 dtoBuzon.setOidPais(dto.getOidPais());
                 
                 dtoBuzon.setCodigoMensaje(codigoMensaje);
                 //dtoBuzon.setCodigoPatron((respuesta.getValueAt(i,"CODIGOCLIENTE")).toString());
                 dtoBuzon.setOidCliente(new Long(respuesta.getValueAt(i,"CODIGOCLIENTE").toString()));
                 dtoBuzon.setModuloOrigen(new Long(ConstantesSEG.MODULO_REC));
                 //datos variables:
                 dtoBuzon.setDatoVariable1(respuesta.getValueAt(i,"NUMDOCUREFERENCIA") != null ?
                                         respuesta.getValueAt(i,"NUMDOCUREFERENCIA").toString() : "");
                 dtoBuzon.setDatoVariable2(respuesta.getValueAt(i,"MOTIVORECHAZODESBLOQUEO") != null ?
                                         respuesta.getValueAt(i,"MOTIVORECHAZODESBLOQUEO").toString() : "");
                 dtoBuzon.setDatoVariable3(respuesta.getValueAt(i,"ESTADOOPERACION") != null ?
                                         respuesta.getValueAt(i,"ESTADOOPERACION").toString() : "");
                 dtoBuzon.setDatoVariable4(respuesta.getValueAt(i,"NUMERORECLAMO") != null ?
                                         respuesta.getValueAt(i,"NUMERORECLAMO").toString() : "");
                       //dtoBuzon.setDatoVariable5((respuesta.getValueAt(i,"CODIGOCLIENTE")).toString());
                 dtoBuzon.setDatoVariable5(respuesta.getValueAt(i,"NOMBREOPERACION") != null ?
                                         respuesta.getValueAt(i,"NOMBREOPERACION").toString() : "");
                 dtoBuzon.setDatoVariable6(respuesta.getValueAt(i,"NOMBRE") != null ?
                                         respuesta.getValueAt(i,"NOMBRE").toString() : "");
                 dtoBuzon.setDatoVariable7(respuesta.getValueAt(i,"APELLIDO") != null ? 
                                         respuesta.getValueAt(i,"APELLIDO").toString() : "");
                 dtoBuzon.setDatoVariable8(respuesta.getValueAt(i,"PERIDOREFERENCIA") != null  ? 
                                         respuesta.getValueAt(i,"PERIDOREFERENCIA").toString() : "");
                 dtoBuzon.setDatoVariable9(respuesta.getValueAt(i,"PERIODORECLAMO") != null ? 
                                         respuesta.getValueAt(i,"PERIODORECLAMO").toString() : "");
             
                //20/09/2006 - mmaidana - se cambia NUMDOCUREFERENCIA por NUMSOLICITUD
                //por inc. DBLG500001059.
                 dtoBuzon.setDatoVariable10(respuesta.getValueAt(i,"NUMSOLICITUD") != null ? 
                                         respuesta.getValueAt(i,"NUMSOLICITUD").toString() : "");
                                         
                 if (tipoMovimiento.longValue() ==  
                                ConstantesREC.TIPO_MOVIMIENTO_ENVIA.longValue()) {
                    dtoBuzon.setDatoVariable12(respuesta.getValueAt(i,"DESCPRODUCTO") != null ?
                                             respuesta.getValueAt(i,"DESCPRODUCTO").toString() : "");
                    dtoBuzon.setDatoVariable14(respuesta.getValueAt(i,"URECLAMADAS") != null ?
                                              respuesta.getValueAt(i,"URECLAMADAS").toString() : "");
                    dtoBuzon.setDatoVariable16(respuesta.getValueAt(i,"PRECIO") != null ? 
                                            respuesta.getValueAt(i,"PRECIO").toString() : "");
                    if(respuesta.getValueAt(i,"PRECIO") != null ){
                        precioEnvia = (BigDecimal)respuesta.getValueAt(i,"PRECIO");
                    }
                    
                 } else {
                    dtoBuzon.setDatoVariable11(respuesta.getValueAt(i,"DESCPRODUCTO") != null ? 
                                              respuesta.getValueAt(i,"DESCPRODUCTO").toString() : "");
                    dtoBuzon.setDatoVariable13(respuesta.getValueAt(i,"URECLAMADAS") != null ? 
                                              respuesta.getValueAt(i,"URECLAMADAS").toString() : "");
                    dtoBuzon.setDatoVariable17(respuesta.getValueAt(i,"PRECIO") != null ?
                                             respuesta.getValueAt(i,"PRECIO").toString() : "");
                    if(respuesta.getValueAt(i,"PRECIO") != null ){
                        precioDevuelve = (BigDecimal)respuesta.getValueAt(i,"PRECIO");
                    }
                 }
                dtoBuzon.setDatoVariable15(respuesta.getValueAt(i,"UATENDIDAS") != null ? 
                                            respuesta.getValueAt(i,"UATENDIDAS").toString() : "");
                 //precio producto envia catalogo= a blancos 
                 //precio producto devuelve catalogo= a blancos 
                 dtoBuzon.setDatoVariable18("");
                 dtoBuzon.setDatoVariable19("");
                 //diferencia precio envia y devuelve= (precio producto con descuento envia) 
                 //- (precio producto con descuento devuelve)
                 //ni idea de como se saca esto
                 dtoBuzon.setListaConsultoras("N");
                 //codigo de patron, permanencia del mensaje, canal y periodo vacios
                 //Añadido por la incidencia BELC300014171


              }
           }else{
             if (ebelNoticias.booleanValue()&&
                  (ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(numeroRecojo)||
                        ConstantesREC.SEGUNDO_RECOJO_NO_EXITOSO.equals(numeroRecojo)) ) {
                 flag = true;
                 dtoBuzon.setOidPais(dto.getOidPais());
                 String filtroEstado = null;
                 if(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(numeroRecojo)){
                    filtroEstado = "PR";  
                    dtoBuzon.setCodigoMensaje("REC08");  
                 }else{
                    filtroEstado = "SR";
                    dtoBuzon.setCodigoMensaje("REC09");  
                 }
                 
                 
                 dtoBuzon.setOidCliente(new Long(respuesta.getValueAt(i,"CODIGOCLIENTE").toString()));
                 dtoBuzon.setModuloOrigen(new Long(ConstantesSEG.MODULO_REC));
                 //datos variables:
                 dtoBuzon.setDatoVariable1(respuesta.getValueAt(i,"NUMDOCUREFERENCIA") != null ?
                                         respuesta.getValueAt(i,"NUMDOCUREFERENCIA").toString() : "");

                 StringBuffer sql = new StringBuffer("");
                  Vector parametros = new Vector();
                  
                  sql.append(" SELECT BR.NUM_BOLE, ER.DESC_ESTA_RECO	");
                  sql.append("  FROM REC_BOLET_RECOJ BR, REC_NUMER_RECOJ NR, REC_ESTAD_RECOJ ER, REC_CABEC_RECLA CR	");
                   sql.append("WHERE BR.NURE_OID_NUME_RECO = NR.OID_NUME_RECO 	");
                  sql.append("   AND BR.EREC_OID_ESTA_RECO = ER.OID_ESTA_RECO(+)	");
                  sql.append("   AND BR.CARE_OID_CABE_RECL = CR.OID_CABE_RECL ");
                  sql.append("   AND CR.NUM_ATEN ="+dto.getOid());
                  sql.append("   AND NR.VAL_CODI = '"+filtroEstado+"'");
                  
                  
                  RecordSet rs = null;
                  BelcorpService bs = BelcorpService.getInstance();
                  
                  try {
                      rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
                  } catch (Exception e) {
                      String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                      ctx.setRollbackOnly();
                      throw new MareException(e, UtilidadesError.armarCodigoError(error));
                  }
                 
           
                 dtoBuzon.setDatoVariable2(rs.getValueAt(0,"NUM_BOLE") != null ?
                                         rs.getValueAt(0,"NUM_BOLE").toString() : "");
                 dtoBuzon.setDatoVariable3(rs.getValueAt(0,"DESC_ESTA_RECO") != null ?
                                         rs.getValueAt(0,"DESC_ESTA_RECO").toString() : "");
                 dtoBuzon.setDatoVariable4(respuesta.getValueAt(i,"NUMERORECLAMO") != null ?
                                         respuesta.getValueAt(i,"NUMERORECLAMO").toString() : "");

                 dtoBuzon.setDatoVariable5(respuesta.getValueAt(i,"CODIGOCLIENTE") != null ?
                                         respuesta.getValueAt(i,"CODIGOCLIENTE").toString() : "");
                 dtoBuzon.setDatoVariable6(respuesta.getValueAt(i,"NOMBRE") != null ?
                                         respuesta.getValueAt(i,"NOMBRE").toString() : "");
                 dtoBuzon.setDatoVariable7(respuesta.getValueAt(i,"APELLIDO") != null ? 
                                         respuesta.getValueAt(i,"APELLIDO").toString() : "");
                 dtoBuzon.setDatoVariable8(respuesta.getValueAt(i,"PERIDOREFERENCIA") != null  ? 
                                         respuesta.getValueAt(i,"PERIDOREFERENCIA").toString() : "");
                 dtoBuzon.setDatoVariable9(respuesta.getValueAt(i,"PERIODORECLAMO") != null ? 
                                         respuesta.getValueAt(i,"PERIODORECLAMO").toString() : "");
                 
                 dtoBuzon.setDatoVariable10("");
                 dtoBuzon.setDatoVariable11("");
                 dtoBuzon.setDatoVariable12("");
                 dtoBuzon.setDatoVariable13("");
                 dtoBuzon.setDatoVariable14("");
                 dtoBuzon.setDatoVariable15("");
                 dtoBuzon.setDatoVariable16("");
                 dtoBuzon.setDatoVariable17("");
                 dtoBuzon.setDatoVariable18("");
                 dtoBuzon.setDatoVariable19("");
                 
                 dtoBuzon.setListaConsultoras("N");
                 //codigo de patron, permanencia del mensaje, canal y periodo vacios
                 //Añadido por la incidencia BELC300014171

             
             
             
             
             
             
             
              }
           }
        }
      
      if(flag){
              dtoBuzon.setDatoVariable20((precioEnvia.subtract(precioDevuelve)).toString());
            try{
                MONGestionMensajes monGestionMensajes = null;
                monGestionMensajes = this.getMONGestionMensajes();
                monGestionMensajes.insertaDatosMensaje(dtoBuzon);
             }catch(RemoteException re) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(
                "****Metodo generarMensajes: ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
                throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
             }
      }
     }
         
     UtilidadesLog.info("MONCapturaProcesoReclamos.generarMensajes(DTOOID):Salida");
 }

    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws MareException {
      MaestroProductosLocalHome maestroProductosLocalHome = (MaestroProductosLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MaestroProductos");
      return maestroProductosLocalHome;
    }

    public DTOBoolean validarPerdida(DTOOID dto) throws MareException {

      UtilidadesLog.info("MONCapturaProcesoReclamos.validarPerdida(DTOOID):Entrada");
      
      OperacionesLocal operacion = null;
      
      try {
         operacion = new OperacionesLocalHome().findByPrimaryKey(dto.getOid()); 
      } catch (NoResultException ex){
         UtilidadesLog.error("MONCapturaProcesoReclamos.validarPerdida: FinderException", ex);
          ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }catch (PersistenceException re){
              ctx.setRollbackOnly();
              String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
      }

      DTOBoolean dtoBoolean = new DTOBoolean();
      
      // Si no hay valor en base de datos, devolvemos falso.
      dtoBoolean.setValor(operacion.getPerdida()!=null ?
                            operacion.getPerdida().booleanValue():false);  
      
      UtilidadesLog.info("MONCapturaProcesoReclamos.validarPerdida(DTOOID):Salida");
      return dtoBoolean;
    }

    public DTOSalida obtenerProductosCodigoVentSi(DTOBuscarProductosDevuelveNoREC dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosCodigoVentSi(DTOBuscarProductosDevuelveNoREC):Entrada");
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        RecordSet rs = dao.obtenerProductosCodigoVentaSi(dto);
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerProductosCodigoVentSi(DTOBuscarProductosDevuelveNoREC):Salida");
        return new DTOSalida(rs);
    }
    
 
    
    private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.validaAcceso:Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);

        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais +
            ",sociedad = " + sociedad + ", marca=" + marca + ", canal= " +
            canal + ", acceso=" + acceso + ",subacceso = " + subacceso +
            ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal,
                    acceso, subacceso, subgerencia, region, zona, seccion,
                    territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("MONCapturaProcesoReclamos.validaAcceso:Salida");
    }

    private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONValidacion",e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		
        return ejb;
	}
    
    private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
				
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome(
            "MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONPeriodos",e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		
        return ejb;
	}
    
      
   // MONProcesosPED implementa la interfaz IGenerarNumeroDocumento
   private MONProcesosPED getMONProcesoPED() throws MareException {
      // Se obtiene el interfaz home
      MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome("MONProcesosPED", MONProcesosPEDHome.class);
            
      // Se obtiene el interfaz remoto
      MONProcesosPED ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      UtilidadesLog.error("*** Error en MONCapturaProcesoReclamos.getMONProcesoPED",e);
          ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      return ejb;
	}


    // MONGenerarMovimientoAlmacen implementa la interfaz IGenerarMovimientoAlmacen
   private MONGenerarMovimientoAlmacen getMONGenerarMovimientoAlmacen() throws MareException {
      // Se obtiene el interfaz home
		UtilidadesLog.info("MONCapturaProcesoReclamos.getMONGenerarMovimientoAlmacen():Entrada");
      MONGenerarMovimientoAlmacenHome home = (MONGenerarMovimientoAlmacenHome)UtilidadesEJB.getHome("MONGenerarMovimientoAlmacen", MONGenerarMovimientoAlmacenHome.class);
            
      // Se obtiene el interfaz remoto
      MONGenerarMovimientoAlmacen ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      UtilidadesLog.error("*** Error en MONCapturaProcesoReclamos.getMONGenerarMovimientoAlmacen",e);
          ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      UtilidadesLog.info("MONCapturaProcesoReclamos.getMONGenerarMovimientoAlmacen():Salida");		        
      return ejb;
	}
   
   // MONGenerarSolicitudModulosExternos implementa la interfaz IPEDGenerarSolicitudesExternas
   /*private MONGenerarSolicitudModulosExternos getMONGenerarSolicitudModulosExternos() throws MareException {
      // Se obtiene el interfaz home
					
      MONGenerarSolicitudModulosExternosHome home = (MONGenerarSolicitudModulosExternosHome)UtilidadesEJB.getHome("MONGenerarSolicitudModulosExternos", MONGenerarSolicitudModulosExternosHome.class);
            
      // Se obtiene el interfaz remoto
      MONGenerarSolicitudModulosExternos ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      UtilidadesLog.error("*** Error en MONCapturaProcesoReclamos.getMONGenerarSolicitudModulosExternos",e);
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      return ejb;
	}*/   
 
    private MONGestionMensajes getMONGestionMensajes() throws MareException {
        // Se obtiene el interfaz home

        MONGestionMensajesHome home = (MONGestionMensajesHome)UtilidadesEJB.getHome(
            "MONGestionMensajes", MONGestionMensajesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestionMensajes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONGestionMensajes",e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
      return ejb;
	} 
    
    
    private void validaAccesoVinculos(Long pais,Long empresa,Long sociedad, Long marca, Long canal, Long acceso,Long subAcceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)throws RemoteException, MareException{
		UtilidadesLog.info("MONCapturaProcesoReclamos.validaAccesoVinculos:Entrada");
		validaAcceso(pais,empresa,marca,canal,acceso,subAcceso,subgerencia,region,zona,seccion,territorio);
		validaVinculos(pais,sociedad,marca,canal,acceso,subAcceso);
		UtilidadesLog.info("MONCapturaProcesoReclamos.validaAccesoVinculos:Salida");		
	}
    private void validaVinculos(Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso) throws RemoteException, MareException {
		UtilidadesLog.info("MONCapturaProcesoReclamos.validaVinculos:Entrada");
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);
		
		UtilidadesLog.debug("**** Llamada a validaVinculos(pais= "+ pais + ", marca= "+marca + ", canal= " + canal + ", acceso= "+ acceso+ ")");
		b = monValidacion.validarVinculos( pais, sociedad, marca, canal, acceso, subAcceso);
		UtilidadesLog.debug("**** Retorno validaVinculos:  " + b.toString());
		if (!b.booleanValue()){				
			ctx.setRollbackOnly();			
			UtilidadesLog.error("****Metodo validaVinculos: validarVinculos : ERROR_VINCULOS_INVALIDOS");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULOS_INVALIDOS) );
		} 					
		UtilidadesLog.info("MONCapturaProcesoReclamos.validaVinculos:Salida");		


   }   

   //añadido por incidencia 14671
    private ArrayList convertirStringTOArray(String cadena)throws MareException{
        //Recibe un string separado por # y lo convierte en un array de LONGS
        UtilidadesLog.info("MONCapturaProcesoReclamos.convertirStringTOArray(String):Entrada");
        StringTokenizer st = new StringTokenizer(cadena, "#");
        ArrayList array=new ArrayList();
          
        while (st.countTokens()> 0) {
            String fila = st.nextToken();
            if(fila!=null){
                Long longi=new Long(fila);
                array.add(longi);
                UtilidadesLog.debug("Long " +longi);
           }
         }
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.convertirStringTOArray(String):Salida");
        
        return array;
    }


   // creado por incidencia BELC300014390
    public DTOTotalesReclamoREC actualizarReclamo(DTOReclamo dto) throws MareException {
      
        UtilidadesLog.info("MONCapturaProcesoReclamos.actualizarReclamo(DTOReclamo):Salida");
      
        CabeceraReclamoLocalHome crLH = new CabeceraReclamoLocalHome();
        CabeceraReclamoLocal cabeceraReclamo = null;
        UtilidadesLog.debug("Actualizamos ----->"+dto.getOidReclamo());
        try{
            cabeceraReclamo = crLH.findByPrimaryKey(dto.getOidReclamo());
        } catch (NoResultException ex){
            UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarReclamo: FinderException -> CabeceraReclamo:", ex);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }catch (PersistenceException re){
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        
        PeriodoLocalHome  pLH = new PeriodoLocalHome();
        PeriodoLocal periodo = null;
        UtilidadesLog.debug("Buscamos Periodo REF ->>>>"+cabeceraReclamo.getPeriodoDocumentoReferencia());
        try{
            periodo = pLH.findByPrimaryKey(cabeceraReclamo.getPeriodoDocumentoReferencia());
        } catch (NoResultException ex){
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarReclamo: FinderException -> Periodo:", ex);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
        UtilidadesLog.debug("Encontramos  --->"+periodo.getOid());
        UtilidadesLog.debug("Que tiene Marca--->"+periodo.getOidMarca()+" Canal--->"+periodo.getOidCanal()+" Pais--->"+periodo.getOidPais());
        
        // Modificacion por HRCS - Fecha 12/03/2007 - Cambio SICC-GCC-REC-007-Periodo de Reclamo V3
        // Solo recupera el periodo actual si no se envia periodo de reclamo.
        if ( dto.getPeriodoReclamo()==null )   {
            MONPeriodos monPeriodos = this.getMONPeriodos();
            DTOPeriodo dtoPeriodo = null;
            try {
                dtoPeriodo = monPeriodos.obtienePeriodoActual(periodo.getOidPais(),
                                                            periodo.getOidMarca(),
                                                            periodo.getOidCanal()
                                                            );
            } catch (RemoteException re){
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarReclamo: RemoteException -> CRA.MONPeriodo", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
            UtilidadesLog.debug("Actualizamos con el periodo actual --->"+dtoPeriodo.getOid());
            /* Se asigna como paeriodo del reclamo el periodo en que se realiza la modificacion
             * Se hace un REC:CabeceraReclamo.setPeriodoReclamo con el oid 
             * del periodo actual contenido en el DTOPerido
             */
            //cabeceraReclamo.setPeriodoReclamo(dtoPeriodo.getOid());
            this.datosReclamo.setPeriodoReclamo(dtoPeriodo.getOid());
            dto.setPeriodoReclamo( dtoPeriodo.getOid() );
        }
        //  Se asgina el periodo de reclamo - Cambio SICC-GCC-REC-007-Periodo de Reclamo V3
        cabeceraReclamo.setPeriodoReclamo( dto.getPeriodoReclamo() );
        
        BigDecimal totalEnvia = dto.getTotalEnvia() != null ? 
                            dto.getTotalEnvia() : new BigDecimal(0) ;
        BigDecimal totalDevuelve = dto.getTotalDevuelve() != null ? 
                            dto.getTotalDevuelve() : new BigDecimal(0);
        this.datosReclamo = dto;
        
        if(dto.getOperacionesAEliminar()!=null){
            eliminarOperacion();
        }
            if(dto.getOperaciones()!=null){
                    OperacionReclamoLocal operacion = null;
                    OperacionReclamoLocalHome operRecLocalHome = new OperacionReclamoLocalHome();
                    ArrayList opera = dto.getOperaciones();
                    for (int m=0 ;m<dto.getOperaciones().size() ;m++ )  {
                       if(((DTOOperacionReclamo)opera.get(m)).getOidOperacionReclamo()!=null){
                           try{
                              operacion = operRecLocalHome.findByPrimaryKey(((DTOOperacionReclamo)opera.get(m)).getOidOperacionReclamo());
                           }catch(NoResultException ex){
                                UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarReclamo: FinderException Operacion", ex);
                               ctx.setRollbackOnly();
                                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                           }catch (PersistenceException re){
                                   ctx.setRollbackOnly();
                                   String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                                   throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                           }
                            operacion.setSecuencialOperacion(((DTOOperacionReclamo)opera.get(m)).getNumSecuencial());
                            operacion.setPeriodoReclamo( dto.getPeriodoReclamo() );   // Modificado por Cambio SICC-GCC-REC-007-Periodo de Reclamo V3
                            operRecLocalHome.merge(operacion);
                       }else{
                            DTOOperacionReclamo dtoOperacionReclamo = (DTOOperacionReclamo)dto.getOperaciones().get(m);
                            //dtoOperacionReclamo.setPeriodoReclamo(dtoPeriodo.getOid());
                            dtoOperacionReclamo.setPeriodoReclamo( dto.getPeriodoReclamo() );   // Modificado por Cambio SICC-GCC-REC-007-Periodo de Reclamo V3
                            this.grabarOperacion(m);               
                               ArrayList lineas = dtoOperacionReclamo.getLineas();
            
                            if (lineas != null && !lineas.isEmpty()){
                                for (int i = 0 ; i < lineas.size() ; i++){
                                    DTOLineaOperacion dtoLinea = (DTOLineaOperacion) lineas.get(i);
                                    dtoLinea.setOperacion(dtoOperacionReclamo.getOidOperacion());
                                    this.grabarLinea(m,i);
                                   
                                }
    
                            }
                       }
                    }
            }

        cabeceraReclamo.setTotalEnvia(datosReclamo.getTotalEnvia());
        cabeceraReclamo.setTotalDevuelve(datosReclamo.getTotalDevuelve());
        cabeceraReclamo.setSaldoPagar(datosReclamo.getSaldoAPagar());
        crLH.merge(cabeceraReclamo);
        DTOTotalesReclamoREC dtoTotales = new DTOTotalesReclamoREC();
        dtoTotales.setTotalAbono(totalEnvia);
        dtoTotales.setTotalCargo(totalDevuelve);

        UtilidadesLog.info("MONCapturaProcesoReclamos.actualizarReclamo(DTOReclamo):Salida");
        return dtoTotales;
   }


    public void grabarLinea(int i, int j) throws MareException
    {
            UtilidadesLog.info("MONCapturaProcesoReclamos.grabarLinea(int, int):Entrada");
         
  
        LineasOperacionReclamoLocalHome lineasOperacionReclamoLocalHome = new LineasOperacionReclamoLocalHome();
        LineasOperacionReclamoLocal lineasOperacionReclamoLocal;
        ArrayList operaciones = datosReclamo.getOperaciones();
        //DTOLineaOperacion
        
        DTOOperacionReclamo dtoOperacionRecolamo = (DTOOperacionReclamo) operaciones.get(i);
        ArrayList Delinea  = dtoOperacionRecolamo.getLineas();
        DTOLineaOperacion dtoLineaOperacion = (DTOLineaOperacion)Delinea.get(j);
        /*
         *     LineasOperacionReclamoLocal create(Integer numeroLinea,
         *                                        Long oidOperacion, 
         *                                        Long tipoOferta, 
         *                                        Long tipoPosicion, 
         *                                        Long tipoMovimiento, 
         *                                        Long motivoDevolucion, 
         *                                        Long motivoDesbloqueo) 
         *                                        throws MareException, CreateException;
    
         */
        Integer numeroLinea = new Integer(j+1); //(2)
     
        try{
            lineasOperacionReclamoLocal = lineasOperacionReclamoLocalHome.create(numeroLinea, //(1)
                                                                            dtoOperacionRecolamo.getOidOperacion(), //(1)
                                                                            dtoLineaOperacion.getOidTpoOferta(),//(3)
                                                                            dtoLineaOperacion.getOidTipoPosicion(),//(15) PONER INCIDENCIA
                                                                            dtoLineaOperacion.getOidTipoMovimiento(),//(13)
                                                                            dtoLineaOperacion.getOidMotivoDevolucion()); // motivoDesbloqueo(19) PONER INCIDENCIA
                                                                           
        } catch (PersistenceException e) {
                UtilidadesLog.error("actualizarCuenta: CreateException:grabarCabeceraReclamo",
                    e);
                ctx.setRollbackOnly();
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
    
        lineasOperacionReclamoLocal.setCodigoVenta(dtoLineaOperacion.getOidCodVenta());// (4)
        lineasOperacionReclamoLocal.setProducto(dtoLineaOperacion.getOidCodProducto()); // (5) 
        lineasOperacionReclamoLocal.setUnidadesReclamadas(dtoLineaOperacion.getUnidadesReclamadas()); // (6)
        
        // vbongiov -- SiCC 20090852 -- 6/03/2009
        if(dtoLineaOperacion.getPrecio()!= null){
            lineasOperacionReclamoLocal.setPrecio(dtoLineaOperacion.getPrecio().setScale(decimales, BigDecimal.ROUND_HALF_UP)); // (7)
        }
        
        if(dtoLineaOperacion.getImporteAbono()!=null){
            lineasOperacionReclamoLocal.setImporteAbono(dtoLineaOperacion.getImporteAbono().setScale(decimales, BigDecimal.ROUND_HALF_UP)); // (8) 
        }
        
        if(dtoLineaOperacion.getImporteCargo()!=null){
            lineasOperacionReclamoLocal.setImporteCargo(dtoLineaOperacion.getImporteCargo().setScale(decimales, BigDecimal.ROUND_HALF_UP)); // (9)
        }
        
        lineasOperacionReclamoLocal.setNumeroUnidadesDevueltas(dtoLineaOperacion.getUnidadesDevueltas()); // (10) 
        lineasOperacionReclamoLocal.setPrecioPerdida(dtoLineaOperacion.getPrecioPerdida()); //  (11)
        lineasOperacionReclamoLocal.setTipoSolicitud(dtoLineaOperacion.getOidTipoSolicitud());// (16)
        //Se agrega el Seteo de Monto Perdida
        // vbongiov -- SiCC 20090852 -- 6/03/2009
        if(dtoLineaOperacion.getMontoPerdida()!= null){
            lineasOperacionReclamoLocal.setMontoPerdida(dtoLineaOperacion.getMontoPerdida().setScale(decimales, BigDecimal.ROUND_HALF_UP)); //(19)
        }                
        
        UtilidadesLog.debug("Tipo solicitud " + dtoLineaOperacion.getOidTipoSolicitud() );
        lineasOperacionReclamoLocal.setPosicionReferencia(dtoLineaOperacion.getPosicionReferencia());
        UtilidadesLog.debug("Indicador estado" + dtoLineaOperacion.getIndicadorEstado());
        if (dtoLineaOperacion.getIndicadorEstado() != null){
            lineasOperacionReclamoLocal.setIndicadorEstado(dtoLineaOperacion.getIndicadorEstado()); // (17)    
        }else{
            lineasOperacionReclamoLocal.setIndicadorEstado(new Character(ConstantesREC.ESTADO_LINEA_INGRESADO.charAt(0)));
        }
        
        lineasOperacionReclamoLocal.setAtendido(dtoLineaOperacion.getAtendido()); // (18)       	
        
        lineasOperacionReclamoLocal.setOidConcurso(dtoLineaOperacion.getOidConcurso());
        lineasOperacionReclamoLocal.setOidNivel(dtoLineaOperacion.getOidNivel());
        lineasOperacionReclamoLocal.setOidPremio(dtoLineaOperacion.getOidPremio());
        // vbongiov -- SiCC 20090852 -- 6/03/2009
        if(dtoLineaOperacion.getPrecioContable()!= null){
            lineasOperacionReclamoLocal.setPrecioContable(dtoLineaOperacion.getPrecioContable().setScale(decimales, BigDecimal.ROUND_HALF_UP));
        }
        
        lineasOperacionReclamoLocalHome.merge(lineasOperacionReclamoLocal);
        //********************
        // vbongiov -- SiCC 20090852 -- 6/03/2009
        UtilidadesLog.debug(
        "lineasOperacionReclamoLocal ->"
        + " numero linea: " + lineasOperacionReclamoLocal.getNumeroLinea()
        + " operacion: " + lineasOperacionReclamoLocal.getOperacion()
        + " tipo oferta: " + lineasOperacionReclamoLocal.getTipoOferta()
        + " tipo posicion: " + lineasOperacionReclamoLocal.getTipoPosicion()
        + " tipo movimiento: " + lineasOperacionReclamoLocal.getTipoMovimiento()
        + " movimiento devolucion: " + lineasOperacionReclamoLocal.getMotivoDevolucion()
        + " codigo venta: " + lineasOperacionReclamoLocal.getCodigoVenta()
        + " producto: " + lineasOperacionReclamoLocal.getProducto()
        + " unidades reclamadas: " + lineasOperacionReclamoLocal.getUnidadesReclamadas()
        + " precio: " + (lineasOperacionReclamoLocal.getPrecio()!=null?lineasOperacionReclamoLocal.getPrecio().setScale(decimales, BigDecimal.ROUND_HALF_UP):null)
        + " importe abono: " + (lineasOperacionReclamoLocal.getImporteAbono()!=null?lineasOperacionReclamoLocal.getImporteAbono().setScale(decimales, BigDecimal.ROUND_HALF_UP):null)
        + " importe cargo: " + (lineasOperacionReclamoLocal.getImporteCargo()!=null?lineasOperacionReclamoLocal.getImporteCargo().setScale(decimales, BigDecimal.ROUND_HALF_UP):null)
        + " numero unidades devueltas: " + lineasOperacionReclamoLocal.getNumeroUnidadesDevueltas()
        + " precio perdida: " + lineasOperacionReclamoLocal.getPrecioPerdida()
        + " tipo solicitud: " + lineasOperacionReclamoLocal.getTipoSolicitud()
        + " monto perdida: " + (lineasOperacionReclamoLocal.getMontoPerdida()!=null?lineasOperacionReclamoLocal.getMontoPerdida().setScale(decimales, BigDecimal.ROUND_HALF_UP):null)
        + " posicion referencia: " + lineasOperacionReclamoLocal.getPosicionReferencia()
        + " indicador estado: " + lineasOperacionReclamoLocal.getIndicadorEstado()
        + " atendido: " + lineasOperacionReclamoLocal.getAtendido()
        );
        //********************
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.grabarLinea(int, int):Salida");
    }

    public void grabarOperacion(int i) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.grabarOperacion(int):Entrada");
        
   
        OperacionReclamoLocalHome operacionReclamoLocalHome = new OperacionReclamoLocalHome();
        OperacionReclamoLocal operacionReclamoLocal;
        ArrayList operaciones = datosReclamo.getOperaciones();
    
        DTOOperacionReclamo dtoOperacionR = (DTOOperacionReclamo) operaciones.get(i);
        /*
         OperacionReclamoLocal create(Integer secuencialOperacion, 
                                      Long numeroAtencion, 
                                      Long motivoRechazo, 
                                      Long periodoReclamo, 
                                      Long tipoOperacion)
        */
        
        
        try{
        //BELC300014735 
        operacionReclamoLocal = operacionReclamoLocalHome.create(dtoOperacionR.getNumSecuencial(),//(4)
                                         datosReclamo.getOidReclamo(),//(1)
                                         datosReclamo.getPeriodoReclamo(),//periodoReclamo, (22)
                                         dtoOperacionR.getTipoOperacion(),//(3)
                                         dtoOperacionR.getOidDocumentoReferencia()); // ¿se debe coger del dtoOperacionR?
        } catch (PersistenceException e) {
                    UtilidadesLog.error("actualizarCuenta: CreateException:grabarCabeceraReclamo",
                        e);
                    ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }     
        //Cambio por correo de Juan Francisco
        operacionReclamoLocal.setClienteSeguro(dtoOperacionR.getClienteSeguro());
        if (dtoOperacionR.getMotivoBloqueo()!= null){
            operacionReclamoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_BLOQUEO);    
            operacionReclamoLocal.setMotivoBloqueo(dtoOperacionR.getMotivoBloqueo());
            TiposBloqueoLocal tipoBloqueo = null;
            if (dtoOperacionR.getTipoBloqueo() != null){
                try{
                    tipoBloqueo = new TiposBloqueoLocalHome().findByUK(datosReclamo.getOidPais(),dtoOperacionR.getTipoBloqueo());
                } catch(NoResultException ex){
                    UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarReclamo: FinderException -> Tipo Bloqueo:", ex);
                    ctx.setRollbackOnly();
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                }catch (PersistenceException re){
                        ctx.setRollbackOnly();
                        String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
                }
                operacionReclamoLocal.setTipoBloqueo(tipoBloqueo.getOid());
            } else{
                operacionReclamoLocal.setTipoBloqueo(null);    
            }
            
        }else {
            operacionReclamoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_INGRESADO);
            operacionReclamoLocal.setMotivoBloqueo(null);
            operacionReclamoLocal.setTipoBloqueo(null);
        }
        
        //se elimina por BELC300014361
        //operacionReclamoLocal.setCodigoOperacion(dtoOperacionR.getCodigoOperacion()); (2)
        //operacionReclamoLocal.setDocumentoReferencia(dtoOperacionR.getOidDocumentoReferencia());// (5)
        //operacionReclamoLocal.setMotivoBloqueo(null); // (6)
        //operacionReclamoLocal.setTipoBloqueo(null);  //(7)
       //eliminado por modificacion de entity mamontie operacionReclamoLocal.setPeriodo(dtoOperacionR.getPeriodo()); // (8)
        operacionReclamoLocal.setIndicativoEntregaMercaderia(dtoOperacionR.getIndEntregaMercaderia());//(9)
        operacionReclamoLocal.setResponsablePerdida(dtoOperacionR.getResponsablePerdida()); // (10)
        operacionReclamoLocal.setTipoSolicitudPerdida(null);// (11)
        operacionReclamoLocal.setTipoPosicionPerdida(null); // (12)
        operacionReclamoLocal.setAsumePerdida(dtoOperacionR.getAsumePerdida()); // (13)
        operacionReclamoLocal.setArticulo(dtoOperacionR.getCodigoArticulo()); //(14)
        // vbongiov -- SiCC 20090852 -- 6/03/2009
        if(dtoOperacionR.getMontoPerdida()!=null){
            operacionReclamoLocal.setMontoPerdida(dtoOperacionR.getMontoPerdida().setScale(decimales, BigDecimal.ROUND_HALF_UP));// (15)
        }
        
        operacionReclamoLocal.setPrecioPerdida(dtoOperacionR.getPrecioPerdida()); // (16)
        operacionReclamoLocal.setPorcentajePerdida(dtoOperacionR.getPorcentajePerdida());// (17)
        operacionReclamoLocal.setAtendido(dtoOperacionR.getAtendido()); // (18)
        operacionReclamoLocal.setMotivoDesbloqueo(null); // (20)
        //operacionReclamoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_INGRESADO);//(21)
        operacionReclamoLocal.setClienteSeguro(dtoOperacionR.getClienteSeguro());// (23)
        
        operacionReclamoLocalHome.merge(operacionReclamoLocal);
        
        operacionReclamoLocalHome.merge(operacionReclamoLocal);
        //Asignar al atributo "datosReclamo.operaciones[I].oidOperacion" el oid del registro creado (24)
        dtoOperacionR.setOidOperacion(operacionReclamoLocal.getOid());
        
        //*************************
        // vbongiov -- SiCC 20090852 -- 6/03/2009
        UtilidadesLog.debug(
        "operacionReclamoLocal ->"
        + " SecuencialOperacion: " + operacionReclamoLocal.getSecuencialOperacion()
        + " numero atencion: " + operacionReclamoLocal.getNumeroAtencion()
        + " periodo reclamo: " + operacionReclamoLocal.getPeriodoReclamo()
        + " tipo operacion: " + operacionReclamoLocal.getTipoOperacion()
        + " documento referencia: " + operacionReclamoLocal.getDocumentoReferencia()
        + " cliente seguro: " + operacionReclamoLocal.getClienteSeguro()
        + " estado operacion: " + operacionReclamoLocal.getEstadoOperacion()
        + " motivo bloqueo: " + operacionReclamoLocal.getMotivoBloqueo()
        + " tipo bloqueo: " + operacionReclamoLocal.getTipoBloqueo()
        + " indicativo entrega mercaderia: " + operacionReclamoLocal.getIndicativoEntregaMercaderia()
        + " responsable perdida: " + operacionReclamoLocal.getResponsablePerdida()
        + " tipo solicitud perdida: " + operacionReclamoLocal.getTipoSolicitudPerdida()
        + " tipo posicion perdida: " + operacionReclamoLocal.getTipoPosicionPerdida()
        + " asume perdida: " + operacionReclamoLocal.getAsumePerdida()
        + " articulo: " + operacionReclamoLocal.getArticulo()
        + " monto perdida: " + (operacionReclamoLocal.getMontoPerdida()!=null?operacionReclamoLocal.getMontoPerdida().setScale(decimales, BigDecimal.ROUND_HALF_UP):null)
        + " precio perdida: " + operacionReclamoLocal.getPrecioPerdida()
        + " porcentaje perdida: " + operacionReclamoLocal.getPorcentajePerdida()
        + " atendido: " + operacionReclamoLocal.getAtendido()
        + " motivo desbloqueo: " + operacionReclamoLocal.getMotivoDesbloqueo()
        + " cliente seguro: " + operacionReclamoLocal.getClienteSeguro()
        + " oid: " + operacionReclamoLocal.getOid()
        );
        //*************************
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.grabarOperacion(int):Salida");
    }

/**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * @author Marcelo J. Maidana
     * @date 10/03/2006
     * Este método reemplaza a obtenerValidaOperacion(DTOValidaOperacionREC)
     */
    public DTOIndicadoresOperacionREC obtenerIndicadoresOperacion(DTOIndicadoresOperacionREC dto) throws MareException {
    
    
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerIndicadoresOperacion(DTOIndicadoresOperacionREC):Entrada");
    
        DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
        
        RecordSet rs = dao.obtenerIndicadoresOperacion(dto);
       
        if (!rs.esVacio()){
            if ((rs.getValueAt(0, "INGRESADEVUELVE") != null) &&
                    (rs.getValueAt(0, "INGRESADEVUELVE").toString().equals("1"))){
                dto.setIngresaDevuelve(Boolean.TRUE);
            } else {
                dto.setIngresaDevuelve(Boolean.FALSE);
            }
            if ((rs.getValueAt(0, "INGRESAENVIA") != null) &&
                    (rs.getValueAt(0, "INGRESAENVIA").toString().equals("1"))){
                dto.setIngresaEnvia(Boolean.TRUE);
            } else {
                dto.setIngresaEnvia(Boolean.FALSE);
            }
            if ((rs.getValueAt(0, "ENVIAGENERADEVUELVE") != null) &&
                    (rs.getValueAt(0, "ENVIAGENERADEVUELVE").toString().equals("1"))){
                dto.setEnviaGeneraDevuelve(Boolean.TRUE);
            } else {
                dto.setEnviaGeneraDevuelve(Boolean.FALSE);
            }
            if ((rs.getValueAt(0, "DEVUELVEGENERAENVIA") != null) &&
                    (rs.getValueAt(0, "DEVUELVEGENERAENVIA").toString().equals("1"))){
                dto.setDevuelveGeneraEnvia(Boolean.TRUE);
            } else {
                dto.setDevuelveGeneraEnvia(Boolean.FALSE);
            }
            if ((rs.getValueAt(0, "DEVUELVEFISICOFACTURA") != null) &&
                    (rs.getValueAt(0, "DEVUELVEFISICOFACTURA").toString().equals("1"))){
                dto.setDevuelveFisicoFactura(Boolean.TRUE);
            } else {
                dto.setDevuelveFisicoFactura(Boolean.FALSE);
            }
            if ((rs.getValueAt(0, "DEVUELVEFACTURA") != null) &&
                    (rs.getValueAt(0, "DEVUELVEFACTURA").toString().equals("1"))){
                dto.setDevuelveFactura(Boolean.TRUE);
            } else {
                dto.setDevuelveFactura(Boolean.FALSE);
            }
            if ((rs.getValueAt(0, "ENVIAFACTURA") != null) &&
                    (rs.getValueAt(0, "ENVIAFACTURA").toString().equals("1"))){
                dto.setEnviaFactura(Boolean.TRUE);
            } else {
                dto.setEnviaFactura(Boolean.FALSE);
            }
            
            Object oCampo = rs.getValueAt(0, "INDICADORANULACION");
            if (oCampo != null && oCampo.toString().equals("1")) {
                dto.setIndicadorAnulacion(Boolean.TRUE);
            } else {
                dto.setIndicadorAnulacion(Boolean.FALSE);
            }
            
            oCampo = rs.getValueAt(0, "INDICADORPERDIDA");
            if (oCampo != null && oCampo.toString().equals("1")) {
                dto.setIndicadorPerdida(Boolean.TRUE);
            } else {
                dto.setIndicadorPerdida(Boolean.FALSE);
            }
            
            oCampo = rs.getValueAt(0, "CHEQUEOFISICO");
            if ( oCampo != null) {
              dto.setChequeoFisico(oCampo.toString());
            }
                
            oCampo = rs.getValueAt(0, "PRECIOENVIA");
            if ( oCampo != null) {
              dto.setPrecioEnvia(oCampo.toString());
            }
            oCampo = rs.getValueAt(0, "MATRIZ");
            if ( oCampo != null) {
              dto.setMatriz(oCampo.toString());
            }
            
            //Cambio 20080765 
            if ((rs.getValueAt(0, "IND_RECO") != null) &&
                    (rs.getValueAt(0, "IND_RECO").toString().equals("1"))){
                dto.setIndicadorRecojo(Boolean.TRUE);
            } else {
                dto.setIndicadorRecojo(Boolean.FALSE);
            }       
            //-Cambio 20080765 
            
        }

        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerIndicadoresOperacion(DTOIndicadoresOperacionREC):Salida");

        return dto;
    }


    // BELC300018586
    public void bloquearReclamo(DTOAtencionReclamoREC dtoE) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.bloquearReclamo(DTOAtencionReclamoREC):Entrada");
        UtilidadesLog.debug("********** DTOAtencionReclamoREC " + dtoE);

        // Recuperar reclamo 
        CabeceraReclamoLocalHome crLH = new CabeceraReclamoLocalHome();
        CabeceraReclamoLocal cabeceraReclamo = null;
      
        try{
            cabeceraReclamo = crLH.findByUK(dtoE.getNumAtencion(), dtoE.getOidPais());
        } catch (NoResultException ex){
            UtilidadesLog.error("MONCapturaProcesoReclamos.actualizarReclamo: FinderException -> CabeceraReclamo:", ex);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }catch (PersistenceException re){
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        } 
        cabeceraReclamo.setEstadoReclamo(ConstantesREC.ESTADO_RECLAMO_BLOQUEADO);
        cabeceraReclamo.setMotivoBloqueo(dtoE.getOidMotivoBloqueo());
        crLH.merge(cabeceraReclamo);
        UtilidadesLog.info("MONCapturaProcesoReclamos.bloquearReclamo(DTOAtencionReclamoREC):Salida");
    }
        

  
    // Método añadido por la BELC300019018
    public DTOSalida validarReclamoAnulacion(DTOReclamo dtoR) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.validarReclamoAnulacion(DTOOIDPaginado):Entrada");

        // Verifica que no existe un reclamo previo sobre el documento que se quiere anular.
    
        // Busca si existe alguna operación de reclamos para el documento de referencia recibido
        OperacionReclamoLocalHome operacionReclamoLocalHome = new OperacionReclamoLocalHome();
        Vector vectorOperaciones = null;
        Boolean eliminadasOk = Boolean.TRUE;
        try {
            vectorOperaciones = new Vector(operacionReclamoLocalHome.findByDocumentoReferencia(dtoR.getOidDocumentoReferencia()));
        } catch(NoResultException e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }catch (PersistenceException re){
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        } 
        // Validar que lo que ya existe se haya eliminado en sesion 
        if(vectorOperaciones.size()!=0){
            eliminadasOk = this.validarOperacionesAEliminar(vectorOperaciones, dtoR.getOpeAEliminar()) ;
        }

    
        DTOSalida dtoSalida = null;
        if(vectorOperaciones.size()==0 || eliminadasOk.booleanValue() ) {
            // Si no ha sido reclamado, obtenemos los productos del documento de referencia
            //DTOSalida = IPedidosSolicitud.obtenerPosicionesReclamoAnulacion(DTOOID)     
            MONPedidosSolicitud monPedidosSolicitud = this.getMONPedidosSolicitud();
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(dtoR.getOidDocumentoReferencia());
            dtoOid.setOidPais(dtoR.getOidPais());
            dtoOid.setOidIdioma(dtoR.getOidIdioma());
            
            try{
                dtoSalida = monPedidosSolicitud.obtenerPosicionesReclamoAnulacion(dtoOid);
            } catch (RemoteException re){
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                ctx.setRollbackOnly();
                throw new MareException (re, UtilidadesError.armarCodigoError(error));
            }
        } else {
            // Si el documento ya ha sido reclamado no se puede anular
            String mensaje = "Error en MONCapturaProcesoReclamos.validarReclamoAnulacion. "
                            +"El documento "+dtoR.getOidDocumentoReferencia()+" ya ha sido reclamado y no se puede anular";
            
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC,
                                        "",ErroresDeNegocio.REC_0007));
        }
    
        UtilidadesLog.info("MONCapturaProcesoReclamos.validarReclamoAnulacion(DTOOIDPaginado):Salida");
        return dtoSalida;
    }
    
    private MONPedidosSolicitud getMONPedidosSolicitud() throws MareException {

        MONPedidosSolicitud monPedidosSolicitud = null;
        MONPedidosSolicitudHome monPedidosSolicitudHome = null;
        monPedidosSolicitudHome = (MONPedidosSolicitudHome) UtilidadesEJB.getHome("MONPedidosSolicitud", MONPedidosSolicitudHome.class);

        try {
            monPedidosSolicitud = monPedidosSolicitudHome.create();        
        } catch (CreateException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException (e, UtilidadesError.armarCodigoError(error));
        } catch (RemoteException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException (e, UtilidadesError.armarCodigoError(error));
        }

        return monPedidosSolicitud;
    }

    public DTOSalida obtenerIndicadorAnulacionOperacionesREC(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerIndicadorAnulacionOperacionesREC(DTOBelcorp):Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(new DAOCapturaProcesoReclamos().obtenerIndicadorAnulacionOperaciones(dto));
        dtoSalida.setOidIdioma(dto.getOidIdioma());
        dtoSalida.setOidPais(dto.getOidPais());
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.obtenerIndicadorAnulacionOperacionesREC(DTOBelcorp):Salida");
        return dtoSalida;
    }
    
    private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }

    private Integer bigDecimalToInteger(Object numero) {
    
        if (numero != null) {
            return new Integer(((BigDecimal) numero).intValue());
        } else {
            return null;
        }
    }
    
    private Double bigDecimalToDouble(Object numero) {    
        if (numero != null) {
            return new Double(((BigDecimal) numero).intValue());
        } else {
            return null;
        }
    }

    private Boolean bigDecimalToBoolean(Object indicador) {
    
        if (indicador != null) {
            if (((BigDecimal) indicador).intValue() == 1)  { 
                return Boolean.TRUE;
            } else if (((BigDecimal) indicador).intValue() == 0)  {
                return Boolean.FALSE;
            } else {
                return null;
            }           
        } else {
            return null;
        }
    }

    private MONGenerarSolicitudModulosExternosHome getMONGenerarSolicitudModulosExternosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGenerarSolicitudModulosExternosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGenerarSolicitudModulosExternos"), MONGenerarSolicitudModulosExternosHome.class);
    }
    /*
     Descripcion: valida que se esten eliminando en sesion todas las operaciones 
     del reclamo. 

    Implementacion: 

    Se debe validar que los registros de la coleccion operacion y los del
    ArrayList operacionesAEliminar coincidan exactamente de acuerdo al oid de
    cada operacion y las posiciones del ArrayList. 
    Si lo anterior se cumple, retornar "true" 
    Sino, retornar "false" // este valor tambien aplica en caso que el 
    ArrayList venga vacio
    */
    private Boolean validarOperacionesAEliminar(Vector operaciones, String opeAEliminar) {
    UtilidadesLog.info("MONCapturaProcesoReclamos.validarOperacionesAEliminar(DTOBelcorp):Entrada");
        Boolean encontro = Boolean.FALSE;
        UtilidadesLog.info("opeAEliminar "+opeAEliminar);

        ArrayList operacionesAEliminar = new ArrayList();
        
        if(operaciones!=null&&opeAEliminar!=null){
            
            String[] vOpeAEliminar = opeAEliminar.split(";");
            
            UtilidadesLog.info("vOpeAEliminar"+vOpeAEliminar);
            for(int a=0; a<vOpeAEliminar.length;a++){
                operacionesAEliminar.add(Long.valueOf(vOpeAEliminar[a]));
            }
            UtilidadesLog.info("operacionesAEliminar"+operacionesAEliminar);
            if(operaciones.size()==operacionesAEliminar.size()){
                int i=0;
                while(operacionesAEliminar.size()>0){
                    
                    if(((Long)operacionesAEliminar.get(0)).equals(((OperacionReclamoLocal)operaciones.get(i)).getOid())){
                        UtilidadesLog.info(operacionesAEliminar.get(0)+" equals  a "+((OperacionReclamoLocal)operaciones.get(i)).getOid());
                        operacionesAEliminar.remove(0);
                        operaciones.remove(i);
                        i=0;
                    }else{   
                        i++;
                        if(i>operaciones.size()-1){
                            break;
                        }
                    }
                }
               
            }
        
         UtilidadesLog.info("operacionesAEliminar"+operacionesAEliminar);
         UtilidadesLog.info("operaciones"+operaciones);
         if(operacionesAEliminar.size()==0&&operaciones.size()==0){
                    encontro = Boolean.TRUE;
         }
        }
    UtilidadesLog.info("MONCapturaProcesoReclamos.validarOperacionesAEliminar(DTOBelcorp):Salida "+encontro );        
        return encontro;
    }

  private ArrayList convertirStringTOArrayX(String cadena) throws MareException {
    //Recibe un string separado por # y lo convierte en un array de LONGS
        UtilidadesLog.info("MONCapturaProcesoReclamos.convertirStringTOArrayPipe(String):Entrada");
        StringTokenizer st = new StringTokenizer(cadena, "x");
        ArrayList array=new ArrayList();
          
        while (st.countTokens()> 0) {
            String fila = st.nextToken();
            if(fila!=null){
                Long longi=new Long(fila);
                array.add(longi);
                UtilidadesLog.debug("Long " +longi);
           }
         }
        
        UtilidadesLog.info("MONCapturaProcesoReclamos.convertirStringTOArrayPipe(String):Salida");
        
        return array;
  }

    public void actualizarLineasOperacion(Long oid, Long estado, Boolean atendido, Long entregaMercaderia) throws MareException{
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE REC_OPERA_RECLA SET ");
        if (estado!=null){
            sb.append(" ESOP_OID_ESTA_OPER = "+estado+",");
        }
        if (atendido!=null){
            if (atendido.booleanValue()){
                sb.append(" IND_ATEN = 1,");
            }else{
                sb.append(" IND_ATEN = 0,");
            }
        }
        if (entregaMercaderia!=null){
            sb.append(" INEM_OID_INDI_ENTR_MERC = "+entregaMercaderia+",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(" WHERE OID_OPER_RECL = "+oid);
        try {
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
			bs.dbService.executeUpdate(sb.toString());            
		} catch (Exception e) {
			UtilidadesLog.error("obtenerOperacionesSolicitud: ",e);
		    ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
    }
    
    

    private MONCapturaProcesoReclamosLocalHome getMONCapturaProcesoReclamosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCapturaProcesoReclamosLocalHome)context.lookup("java:comp/env/ejb/local/MONCapturaProcesoReclamos");
    }

    private MONActualizarEstadoReclamos getMONActualizarEstadoReclamos() throws MareException {
        // Se obtiene el interfaz home

        MONActualizarEstadoReclamosHome home = (MONActualizarEstadoReclamosHome)UtilidadesEJB.getHome(
            "MONActualizarEstadoReclamos", MONActualizarEstadoReclamosHome.class);
            
        // Se obtiene el interfaz remoto
        MONActualizarEstadoReclamos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONActualizarEstadoReclamos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
      return ejb;
	} 
    private void generarSolicitudesPremio(DTOAtencionReclamoREC dtoE) throws MareException {
     UtilidadesLog.debug("GENERANDO SOLICITUDES DE PREMIO - entrada"); 
     
        LineasOperacionReclamoLocalHome lorLH = null;
        LineasOperacionReclamoLocal linea = null;        
        ClienteDatosBasicosLocalHome clienteHome = null;
        ClienteDatosBasicosLocal clienteLocal = null;
        OperacionesLocalHome operaLhome = null;
        OperacionesLocal operaL = null;
        MONGenerarSolicitudModulosExternosHome monGenerSolicModExtHome = null;
        MONGenerarSolicitudModulosExternos monGenerSolicModExt = null;        
        SolicitudesOperacionLocalHome solOpera= null;
        DTOOperacion dtoOperacion;
        HashMap grupoOperaFactura = new HashMap();
     
     DAOCapturaProcesoReclamos daoCaptura = new DAOCapturaProcesoReclamos();
     try  {
         
                RecordSet lineasRecSolicitud = daoCaptura.obtenerLineasPorSolicitudPremio(dtoE);
                UtilidadesLog.debug("despues de obtenerlineas por solicitud PREMIO....  ");
                
                int cantLineasSol = lineasRecSolicitud.getRowCount();
                
                UtilidadesLog.debug("cantLineasSol Premio: " +  cantLineasSol);
                
                solOpera = new SolicitudesOperacionLocalHome();
    
                /*-> Llamar al metodo DAOCapturaProcesoReclamos.obtenerLineasPorSolicitud() enviando el numAtencion recibido al inicio del metodo
                -> Recorrer RecordSet devuelto
                -> Para cada valor distinto de oidTipoSolicitud: */
                int j = 0;
                while (j<cantLineasSol)  {
                    UtilidadesLog.debug("Primer while: " + j);
                    Vector oidsOperacion = new Vector();
                    ArrayList arrPosiciones = new ArrayList();
                    DTOCabeceraSolicitud dtoCabeceraSolicitud = new DTOCabeceraSolicitud();
    
                    Long oidCliente = bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"OIDCLIENTE"));    
                    clienteHome = new ClienteDatosBasicosLocalHome();
                    clienteLocal = clienteHome.findByPrimaryKey(oidCliente);               
                    String codigoCliente = clienteLocal.getCod_clie();
                    dtoCabeceraSolicitud.setOidCliente(oidCliente);
                    dtoCabeceraSolicitud.setCliente(codigoCliente);
                    
                    dtoCabeceraSolicitud.setOidPais(dtoE.getOidPais());
                    dtoCabeceraSolicitud.setOidIdioma(dtoE.getOidIdioma());
                    dtoCabeceraSolicitud.setMarca(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"MARCA")));
                    dtoCabeceraSolicitud.setCanal(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"CANAL")));
                    dtoCabeceraSolicitud.setAcceso(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"ACCESO")));
                    dtoCabeceraSolicitud.setSubacceso(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"SUBACCESO")));
                    dtoCabeceraSolicitud.setPeriodo(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"OIDPERIODO")));
                    
                    DTOPeriodo dtoPeriodo = this.getMONPeriodos().obtienePeriodoActual( dtoE.getOidPais(), 
                                                                                        dtoCabeceraSolicitud.getMarca(), 
                                                                                        dtoCabeceraSolicitud.getCanal() );
                    Long periodoActual = dtoPeriodo.getOid();   // Oid del periodo actual
                    if ( dtoCabeceraSolicitud.getPeriodo().longValue() > periodoActual.longValue() ) {
                    
                        PeriodoLocalHome  pLH = new PeriodoLocalHome();
                        PeriodoLocal periodo = null;
                        try{
                            periodo = pLH.findByPrimaryKey( dtoCabeceraSolicitud.getPeriodo() );    // busca el periodo de reclamo
                        } catch (NoResultException ex){
                            UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitudes: FinderException -> Periodo:", ex);
                            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                            ctx.setRollbackOnly();
                            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                        }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
                        // Setea la fecha de inicio del periodo en la fecha de la cabecera solicitud
                        dtoCabeceraSolicitud.setFecha( periodo.getFechainicio() );
                    }
                    
                    dtoCabeceraSolicitud.setOidDocumentoReferencia(bigDecimalToLong(lineasRecSolicitud.getValueAt(j,"OIDSOLICITUDREFERENCIA")));
                    dtoCabeceraSolicitud.setNumeroDocumentoOrigen(dtoE.getNumAtencion());
                    dtoCabeceraSolicitud.setModulo(Long.valueOf(ConstantesSEG.MODULO_REC));
                    dtoCabeceraSolicitud.setOperacion(ConstantesBEL.REC039);
                    //dtoCabeceraSolicitud.setIndPedidoPrueba();
                    
                    Long oidTipoSolicitud = bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDTIPOSOLICITUD"));                
                    Long tipoSoliciAnterior =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDTIPOSOLICITUD"));
                    
                    Long oidConcurso =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDCONCURSO"));
                    Long oidConcursoAnterior =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDCONCURSO"));
                    Long oidNivel =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDNIVEL"));
                    Long oidNivelAnterior =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDNIVEL"));
                    Long oidPremio =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDPREMIO"));
                    Long oidPremioAnterior =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDPREMIO"));
                    Integer numeroPremio =  bigDecimalToInteger(lineasRecSolicitud.getValueAt(j, "NUMPREMIO"));
                    
                    while (j<cantLineasSol && bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDTIPOSOLICITUD")).equals(tipoSoliciAnterior)
                            &&  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDCONCURSO")).equals(oidConcursoAnterior) 
                            &&  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDNIVEL")).equals(oidNivelAnterior) 
                            &&  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDPREMIO")).equals(oidPremioAnterior) ){
                        UtilidadesLog.debug("segundo while:  " + j);
                        /*Long operacionAnterior =  bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDOPERACION"));
                        while (j<cantLineasSol && bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDOPERACION")).equals(operacionAnterior)){   */
                        
                        dtoOperacion = new DTOOperacion();
                        dtoOperacion.setOidOperacion(bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDOPERACION")));
                        dtoOperacion.setOidPais(dtoE.getOidPais());
                        RecordSet rsOperacion = daoCaptura.obtenerDatosPerdidaPremios(dtoOperacion, bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDTIPOSOLICITUD")),
                        bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDCONCURSO")),bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDNIVEL")), bigDecimalToLong(lineasRecSolicitud.getValueAt(j, "OIDPREMIO")));
                        int k=0;
                        while (k < rsOperacion.getRowCount() ) {
                            UtilidadesLog.debug("tercer while :  " + k);
                            DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud();
                            if (rsOperacion.getValueAt(k, "CODVENTA")!=null)   {
                                dtoPosicion.setCodigoVentaFicticio( new Long(rsOperacion.getValueAt(k, "CODVENTA").toString()) );
                            }
                            dtoPosicion.setProducto(bigDecimalToLong(rsOperacion.getValueAt(k, "OIDPRODUCTO")));
                            
                            
                            Long tipoMovimiento = bigDecimalToLong(rsOperacion.getValueAt(k, "TIPOMOVIMIENTO"));
                            Long devuelveEstaFact = bigDecimalToLong(rsOperacion.getValueAt(k, "IND_DEVU_ESTA_FACT"));
                            
                            //Cambio 20080545
                            if (tipoMovimiento.equals(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE) && 
                                rsOperacion.getValueAt(k,"IND_FALT_MERC").toString().equals("1") && 
                                rsOperacion.getValueAt(k,"IND_DEVU_FISI_FACT").toString().equals("0") && 
                                rsOperacion.getValueAt(k,"OIDPOSICION")==null){
                              UtilidadesLog.debug("Devuelve Logico del Error de Sacado Premio");
                              UtilidadesLog.debug("NO se genera la Posicion: " + k);
                              k++;
                              continue;
                            }
                            
                            if (tipoMovimiento.equals(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE) &&  
                                devuelveEstaFact.equals(new Long(1)) && 
                                rsOperacion.getValueAt(k,"OIDPOSICION")!=null)  {
                                
                                 dtoPosicion.setPrecioCatalogoUnitarioLocal((BigDecimal)rsOperacion.getValueAt(k, "PRECIOCATAUNITARIOLOCAL"));
                            } else {
                                dtoPosicion.setPrecioCatalogoUnitarioLocal((BigDecimal)rsOperacion.getValueAt(k, "PRECIO"));
                            }
                            /*
                            val_prec_cata_unit_loca AS preciocataunitariolocal,
                            val_prec_cont_unit_loca AS preciocontunitariolocal, 
                            val_impo_desc_unit_loca AS impdescunilocal, 
                            val_porc_desc AS porcentajedesc,*
                            val_prec_cata_unit_docu AS preccataunidocu,
                            val_prec_conta_unit_docu AS preccontunidocu, 
                            val_impo_desc_unit_docu AS impdescunidocu 
                             */
                            
                            dtoPosicion.setPrecioContableUnitarioLocal((BigDecimal)rsOperacion.getValueAt(k, "PRECIOCONTUNITARIOLOCAL"));
                            dtoPosicion.setImporteDescuentoUnitarioLocal((BigDecimal)rsOperacion.getValueAt(k, "IMPDESCUNILOCAL"));
                            dtoPosicion.setPorcentajeDescuento(bigDecimalToDouble((BigDecimal)rsOperacion.getValueAt(k, "PORCENTAJEDESC")));
                            dtoPosicion.setPrecioCatalogoUnitarioDocumento((BigDecimal)rsOperacion.getValueAt(k, "PRECCATAUNIDOCU"));
                            dtoPosicion.setPrecioContableUnitarioDocumento((BigDecimal)rsOperacion.getValueAt(k, "PRECCONTUNIDOCU"));
                            dtoPosicion.setImporteDescuentoUnitarioDocumento((BigDecimal)rsOperacion.getValueAt(k, "IMPDESCUNIDOCU"));
                            //se agrega el dato del detalle de oferta en la posicion que se
                            //genera por reclamo por incidencia de aceptacion. (Gacevedo 04/10/2006)
                            if(rsOperacion.getValueAt(k, "DETALLEOFERTA")!=null){
                               dtoPosicion.setOidDetalleOferta(new Long(rsOperacion.getValueAt(k, "DETALLEOFERTA").toString()));
                            }
                            
                            long uDemandadas = bigDecimalToLong(rsOperacion.getValueAt(k, "UDEMANDADAS")).longValue();
                            
                           
                            if (tipoMovimiento.intValue() == ConstantesREC.TIPO_MOVIMIENTO_ENVIA.intValue() )  {
                                dtoPosicion.setUnidadesDemandadas(new Long(uDemandadas));
                            } else if (tipoMovimiento.intValue() == ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE.intValue() )  {
                                dtoPosicion.setUnidadesDemandadas(new Long(uDemandadas* (-1)));
                            }
        
                            arrPosiciones.add(dtoPosicion);
                            UtilidadesLog.debug("oidlinea " + rsOperacion.getValueAt(k, "OIDLINEA") );
                            lorLH = new LineasOperacionReclamoLocalHome();                        
                            linea = lorLH.findByPrimaryKey(bigDecimalToLong(rsOperacion.getValueAt(k, "OIDLINEA")));
                            UtilidadesLog.debug("linea  " + linea);
                            linea.setIndicadorEstado(ConstantesREC.ESTADO_LINEA_ENVIADO);
                            lorLH.merge(linea);
                            k++;
                        }     
                        
                        oidsOperacion.add(dtoOperacion.getOidOperacion());
                        
                        Boolean perdida = null;
                        Long asumePerdida = null;
    
                        if (rsOperacion != null && !rsOperacion.esVacio()){
                            perdida = bigDecimalToBoolean(rsOperacion.getValueAt(0,"PERDIDA"));
                            asumePerdida = bigDecimalToLong(rsOperacion.getValueAt(0,"ASUMEPERDIDA"));
                        }
                        
                        if ((perdida != null && perdida.booleanValue() == true) &&
                                (asumePerdida == null || asumePerdida.longValue() != ConstantesREC.ASUME_BELCORP.longValue()))  {
    
                            Long solicitudPerdida = bigDecimalToLong(rsOperacion.getValueAt(0,"SOLICITUDPERDIDA"));
                            operaLhome = new OperacionesLocalHome();
                            operaL = operaLhome.findByPrimaryKey(bigDecimalToLong(rsOperacion.getValueAt(0,"OID_OPER")));
                            operaL.setTipoSolicitudPerdida(solicitudPerdida);
                            operaLhome.merge(operaL);
                            dtoCabeceraSolicitud.setTipoSolicitud(solicitudPerdida);
                            DTOPosicionSolicitud  posSolicitud = null;
                            
                            if (asumePerdida != null && asumePerdida.longValue() == ConstantesREC.ASUME_CLIENTE.longValue()) {
                                    posSolicitud = new DTOPosicionSolicitud();
                                    posSolicitud.setCodigoVentaFicticio(bigDecimalToLong(rsOperacion.getValueAt(0,"CODVENTA")));
                                    posSolicitud.setProducto(bigDecimalToLong(rsOperacion.getValueAt(0,"OIDPRODUCTO")));
                                    posSolicitud.setPrecioCatalogoUnitarioLocal((BigDecimal)rsOperacion.getValueAt(0,"MONTOPERDIDA"));
                                    posSolicitud.setUnidadesDemandadas(bigDecimalToLong(rsOperacion.getValueAt(0,"UDEMANDADAS")));
                                    dtoCabeceraSolicitud.setOidCliente(bigDecimalToLong(rsOperacion.getValueAt(0,"RESPONSABLEPERDIDA")));                                    
                            } else if (asumePerdida != null && asumePerdida.longValue() == ConstantesREC.ASUME_SEGURO.longValue())  {
                                posSolicitud = new DTOPosicionSolicitud();
                                posSolicitud.setProducto(bigDecimalToLong(rsOperacion.getValueAt(0,"OIDARTICULO")));
                                posSolicitud.setPrecioCatalogoUnitarioLocal((BigDecimal)rsOperacion.getValueAt(0,"MONTOPERDIDA"));
                                posSolicitud.setUnidadesDemandadas(new Long(1));
                                dtoCabeceraSolicitud.setOidCliente(bigDecimalToLong(rsOperacion.getValueAt(0,"CLIENTESEGURO")));
                            }
                            
                            if (posSolicitud != null)  {
                                monGenerSolicModExtHome = this.getMONGenerarSolicitudModulosExternosHome();
                                monGenerSolicModExt = monGenerSolicModExtHome.create();
                                ArrayList arr = new ArrayList();
                                arr.add(posSolicitud);
                                dtoCabeceraSolicitud.setPosiciones(arr);
                                monGenerSolicModExt.generaSolicitud(dtoCabeceraSolicitud);
                            }
                        }
                        
                        j = k > 0 ? j + k : j + 1;
                    }
                    
                    dtoCabeceraSolicitud.setOidCliente(oidCliente);
                    dtoCabeceraSolicitud.setCliente(codigoCliente);
                    dtoCabeceraSolicitud.setPosiciones(arrPosiciones);
                    dtoCabeceraSolicitud.setTipoSolicitud(oidTipoSolicitud);
                    dtoCabeceraSolicitud.setOidTipoSolicitud(oidTipoSolicitud);
                    dtoCabeceraSolicitud.setOidConcursoParametros(oidConcurso);
                    dtoCabeceraSolicitud.setNumeroPremio(numeroPremio);
                    UtilidadesLog.debug("Antes de generar modulos externos: " + dtoCabeceraSolicitud);                
                    monGenerSolicModExtHome = this.getMONGenerarSolicitudModulosExternosHome();
                    monGenerSolicModExt = monGenerSolicModExtHome.create();
                    DTOOID dtoOidCabecera = monGenerSolicModExt.generaSolicitud(dtoCabeceraSolicitud);
                    
                    Long conso = daoCaptura.obtieneConsolidado(dtoOidCabecera.getOid(),null); 
                    
                    HashMap grupo = new HashMap();
                   
                    for (int h=0; h<oidsOperacion.size(); h++)  {
                        if(grupo.get(new Long(oidsOperacion.get(h).toString()))==null)   {
                           grupo.put(new Long(oidsOperacion.get(h).toString()),new Long(oidsOperacion.get(h).toString()));
                           if(conso!=null){
                                grupoOperaFactura.put(new Long(oidsOperacion.get(h).toString()),new Long(oidsOperacion.get(h).toString()));
                           }
                        
                        }
                    }
                   
                    Iterator k = grupo.keySet().iterator();
                    while(k.hasNext()){
                        String clave = k.next().toString();
                       
                        solOpera.create(new Long(clave), dtoOidCabecera.getOid(), dtoCabeceraSolicitud.getTipoSolicitud() );
                                                
                    }
                    
                   
                }
        }catch (NoResultException ex)  {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitud: FinderException", ex);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }catch (RemoteException ex)  {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitud: RemoteException", ex);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        } catch (MareException ex)  {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitud: MareException", ex);
            throw ex;
        } catch (Exception ex)  {
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCapturaProcesoReclamos.generarSolicitud: Exception", ex);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("GENERANDO SOLICITUDES DE PREMIO - Salida"); 
    }
/*
    Implementacion:
    
    Asignar la variable oidReclamo = DAOCapturaProcesoReclamos.existenProductosRecogibles()
    pasando como parametro el dto recibido.
    Si oidReclamo != null //se retorna el oidReclamo donde existen productos que deben recogerse
    {
    Crear un DTOE del tipo DTONumeroSolicitud con los datos:
    - DTOE.pais = pais activo
    - DTOE.operacion = "REC055"
    (demás campos del DTOE a NULL)
    Asignar la variable numeroBoleta = generarNumAtencion() pasando como parametro el DTOE creado
    Crear un registro en la Entidad REC:BoletaRecojo con los siguientes datos:
    - numeroAtencion = oidReclamo
    - numeroBoleta = numeroBoleta
    - estadoRecojo = oidEstadoRecojo correspondiente al valor 'PR' (Pendiente de Recojo) de la Entidad REC:EstadoRecojo
    Si (numeroRecojo == ConstantesREC.RECOJO_INICIAL o numeroRecojo == ConstantesREC.RECOJO_RECLAMO_LINEA o
    numeroRecojo == ConstantesREC.RECOJO_RECLAMO_MASIVO)
    - numeroRecojo = oidRecojo correspondiente al valor ConstantesREC.PRIMER_RECOJO de la Entidad REC:NumeroRecojo
    Si (numeroRecojo == ConstantesREC.PRIMER_RECOJO_NO_EXITOSO)
    - numeroRecojo = oidRecojo correspondiente al valor ConstantesREC.SEGUNDO_RECOJO de la Entidad REC:NumeroRecojo
    }

*/
  public Long crearBoletaRecojo (DTOAtencionReclamoREC dtoE) throws MareException {
    
    UtilidadesLog.debug("MONCapturaProcesoReclamos.crearBoletaRecojo (DTOAtencionReclamoREC dtoE) Entrada ");
    
    DAOCapturaProcesoReclamos dao = new DAOCapturaProcesoReclamos();
    Long numRecojo = null;
    //--try{
    /*--BoletaRecojoLocal boletaRecL = null;
    BoletaRecojoLocalHome boletaRecLH = this.getBoletaRecojoLocalHome();--*/
      Long oidReclamo = dao.existenProductosRecogibles(dtoE);
      
      //jrivas 29/1/2008 Si no encuentro, no hay productos recogibles en el reclamo.
      if (oidReclamo != null) {
          DTONumeroSolicitud dtoNS = new DTONumeroSolicitud();
          dtoNS.setOidPais(dtoE.getOidPais());
          dtoNS.setOperacion(ConstantesREC.OPERCION_REC055);
          DTOString dtoNumeroBoleta = this.generarNumAtencion(dtoNS);
       
         if(ConstantesREC.RECOJO_INICIAL.equals(dtoE.getNumRecojo()) || 
              ConstantesREC.RECOJO_RECLAMO_LINEA.equals(dtoE.getNumRecojo()) ||
               ConstantesREC.RECOJO_RECLAMO_MASIVO.equals(dtoE.getNumRecojo()) ){
                numRecojo = ConstantesREC.OID_PRIMER_RECOJO;
                 
               }
          if(ConstantesREC.PRIMER_RECOJO_NO_EXITOSO.equals(dtoE.getNumRecojo())){
                numRecojo = ConstantesREC.OID_SEGUNDO_RECOJO;
          }
    
            StringBuffer sql = new StringBuffer("");
            sql.append(" INSERT INTO REC_BOLET_RECOJ	");
            sql.append("             (OID_BOLE_RECO, 	");
            sql.append("              NUM_BOLE, 	");
            sql.append("              CARE_OID_CABE_RECL, 	");
            sql.append("              NURE_OID_NUME_RECO,	");
            sql.append("              EREC_OID_ESTA_RECO,	");
            sql.append("              IND_IMPR)   ");            
            //sql.append("      VALUES (REC_BORE_SEQ.NEXTVAL,	");
            Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_BORE_SEQ");
            sql.append("      VALUES ("+oid+",	");
            sql.append(              new Long(dtoNumeroBoleta.getCadena()) + "," );
            sql.append(              oidReclamo  + ","); 
            sql.append(              numRecojo + ",");
            sql.append("             (SELECT E.OID_ESTA_RECO	");
            sql.append("                FROM REC_ESTAD_RECOJ E	");
            sql.append("               WHERE E.VAL_CODI = '"+ConstantesREC.PENDIENTE_RECOJO+"'), ");
            sql.append("               'N')");//IND_IMPR = 'N' Cambio 20080765
    
         //--boletaRecL = boletaRecLH.create(new Long(dtoNumeroBoleta.getCadena()),oidReclamo,numRecojo); 
         
         // - estadoRecojo = oidEstadoRecojo correspondiente al valor 'PR' (Pendiente de Recojo) de la Entidad REC:EstadoRecojo
         /*--StringBuffer sql = new StringBuffer("");
          sql.append(" SELECT e.oid_esta_reco	");
          sql.append("  FROM rec_estad_recoj e	");
          sql.append(" WHERE e.val_codi = '"+ConstantesREC.PENDIENTE_RECOJO+"'");
          --*/
          //RecordSet rs = null;
          BelcorpService bs = BelcorpService.getInstance();
          
          try {
              bs.dbService.executeUpdate(sql.toString());
              
          } catch (Exception e) {
              String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              ctx.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(error));
          }
         //--boletaRecL.setOidEstado(new Long(rs.getValueAt(0,0).toString()));
          // -------------------
         
         
          
        /*}catch(NamingException ne){
          String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException(ne, UtilidadesError.armarCodigoError(error));
        }catch(CreateException ce){
          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
              throw new MareException(ce, UtilidadesError.armarCodigoError(error));
        }*/
       UtilidadesLog.debug("MONCapturaProcesoReclamos.crearBoletaRecojo (DTOAtencionReclamoREC dtoE) Salida ");
        return oid;
      } else {
       UtilidadesLog.debug("No hay producto recogibles. ");
       UtilidadesLog.debug("MONCapturaProcesoReclamos.crearBoletaRecojo (DTOAtencionReclamoREC dtoE) Salida ");
        return null;
        //No hay producto recogibles.
      }
    
    
  }

/*Cambio 20080765
  private HashMap obtenerNoRecogibles(Long oidPais, Long oidPeriodo) throws MareException{
    UtilidadesLog.debug("MONCapturaProcesoReclamos.obtenerNoRecogibles () Entrada ");
      HashMap detallesOfertaYPremiosArticulo = new HashMap();
      
      StringBuffer sql = new StringBuffer("");
      sql.append(" SELECT NVL(PNR.OFDE_OID_DETA_OFER, AL.LOPA_OID_LOTE_PREM_ARTI) VALOR	");
      sql.append("   FROM REC_PRODU_NO_RECOG PNR, INC_ARTIC_LOTE AL	");
      sql.append(" WHERE PNR.ARLO_OID_ARTI_LOTE = AL.OID_ARTI_LOTE(+)	");
      if(oidPeriodo!=null){
        sql.append("   AND PNR.PERD_OID_PERI ="+oidPeriodo);
      }
      if(oidPais!=null){
        sql.append("   AND PNR.PAIS_OID_PAIS ="+oidPais );
      }
      BelcorpService bs = BelcorpService.getInstance();
      
      try {
         
         RecordSet rs = bs.dbService.executeStaticQuery(sql.toString());
         
          
          
          for(int i = 0; i < rs.getRowCount();i++  ){
            if(rs.getValueAt(i,"VALOR")!=null){
              if(detallesOfertaYPremiosArticulo.get(new Long(rs.getValueAt(i,"VALOR").toString()))==null)   {
              detallesOfertaYPremiosArticulo.put(new Long(rs.getValueAt(i,"VALOR").toString()),new Long(rs.getValueAt(i,"VALOR").toString()));
              
              }
            }
          }

      }catch(Exception e){
          String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          ctx.setRollbackOnly();
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
    UtilidadesLog.debug("MONCapturaProcesoReclamos.obtenerNoRecogibles () Salida ");  
    return detallesOfertaYPremiosArticulo;
  }
  */
    private MONDigitacionInicialLocal getMONDigitacionInicialLocal() throws NamingException, MareException {

        MONDigitacionInicialLocalHome localHome = this.getMONDigitacionInicialLocalHome();
        // Se obtiene el interfaz remoto
        MONDigitacionInicialLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONDigitacionInicialLocalHome",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }
    
    private MONDigitacionInicialLocalHome getMONDigitacionInicialLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONDigitacionInicialLocalHome) context.lookup( "java:comp/env/ejb/local/MONDigitacionInicial" );
    }
    
  
}