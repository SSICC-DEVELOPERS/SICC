/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;

import es.indra.sicc.dtos.bel.DTOAnadirProductosRA;
import es.indra.sicc.dtos.bel.DTOEBuscarHojaDemandaDetalle;
import es.indra.sicc.dtos.bel.DTOEObtenerRegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTOERecuperarRegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTOERellenarRegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTOERellenarRegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTORegistroInterface;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.bel.DTORegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTORegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTOEBuscarHDDetalleFlag;
import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.mae.DTOProducto;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion;

import es.indra.sicc.entidades.bel.AgrupacionStockCabeceraLocal;
import es.indra.sicc.entidades.bel.AgrupacionStockCabeceraLocalHome;
import es.indra.sicc.entidades.bel.AlertasStockLocal;
import es.indra.sicc.entidades.bel.AlertasStockLocalHome;
import es.indra.sicc.entidades.bel.ControlesDeAlmacenLocal;
import es.indra.sicc.entidades.bel.ControlesDeAlmacenLocalHome;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocalHome;
import es.indra.sicc.entidades.bel.RegistroAbastecimientoCabeceraLocal;
import es.indra.sicc.entidades.bel.RegistroAbastecimientoCabeceraLocalHome;
import es.indra.sicc.entidades.bel.RegistroAbastecimientoDetalleLocal;
import es.indra.sicc.entidades.bel.RegistroAbastecimientoDetalleLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.ped.AsignacionAlmacenLocal;
import es.indra.sicc.entidades.ped.AsignacionAlmacenLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudProcesoLocal;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;

import es.indra.sicc.logicanegocio.bel.MONServicioBEL;
import es.indra.sicc.logicanegocio.bel.MONServicioBELHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.MONProductos;
import es.indra.sicc.logicanegocio.mae.MONProductosHome;
import es.indra.sicc.logicanegocio.ped.DAOPosicion;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.ped.MONTiposSolicitudPais;
import es.indra.sicc.logicanegocio.ped.MONTiposSolicitudPaisHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.bel.DAOServicioBel;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;
import java.sql.Timestamp;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.sql.Date;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.RemoveException;

import java.lang.Math;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.entidades.ped.TiposSolicitudProcesoLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONRegistroAbastecimientoBean implements SessionBean 
{

   private SessionContext ctx;

   private DTOMovimientoAlmacen movimientoAlmacen;
   private DTOCabeceraSolicitud solicitudTipoActuacion3;
   private DTOCabeceraSolicitud solicitudTipoActuacion4;

   public void ejbCreate()
   {
   }

   public void ejbActivate()
   {
   }

   public void ejbPassivate()
   {
   }

   public void ejbRemove()
   {
   }

   public void setSessionContext(SessionContext ctx) {
      this.ctx = ctx;
   }

    private MONValidacion getMONValidacion() throws MareException {
        UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONValidacion: Entrada");

    
        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion",
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            this.logearError("*** Error en MONRegistroAbastecimiento.getMONValidacion", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("****Metodo MONRegistroAbastecimiento.getMONValidacion: Salida");

        return ejb;
    }


    // Validaciones
    private void validaAccesos(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio) throws MareException 
	{
        UtilidadesLog.info("MONRegistroAbastecimientoBean.validaAccesos(Long pais, Long sociedad, " +
                           " Long marca, Long canal, Long acceso, Long subacceso, " + 
                           " Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = new Boolean(true);

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
            UtilidadesLog.error(rExc);
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo MONRegistroAbastecimiento.validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo MONRegistroAbastecimiento.validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("MONRegistroAbastecimientoBean.validaAccesos(Long pais, Long sociedad, " +
                           " Long marca, Long canal, Long acceso, Long subacceso, " + 
                           " Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Salida");
    }
    
	private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		UtilidadesLog.error(e);
	}

	private void logearStackTrace(Throwable e){
		try{						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			/*e.printStackTrace(out);
			UtilidadesLog.error(pila.toString());*/
      UtilidadesLog.error(e);
		}catch(Exception ex){
			UtilidadesLog.error("Error Logeando Pila: "+ex.getMessage());
		}			
	}    
   
   public DTORegistroAbastecimiento rellenarRegistroAbastecimiento(DTOERellenarRegistroAbastecimiento dto) throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.rellenarRegistroAbastecimiento(DTOERellenarRegistroAbastecimiento dto):Entrada");
      SubaccesoLocal subaccesoLocal = null;
      AccesoLocal accesoLocal = null;
      
      DTORegistroAbastecimiento respuesta = null;

      try 
      {
         // Llamar al método "findByPrimaryKey()" de la entidad Subacceso tomando dto.subacceso 
         subaccesoLocal = getSubaccesoLocalHome().findByPrimaryKey(dto.getSubacceso()); 
         
         // Llamar al método "findByPrimaryKey()" de la entidad Acceso tomando Subacceso.oidAcceso 
         accesoLocal = getAccesoLocalHome().findByPrimaryKey(subaccesoLocal.getOidAcceso()); 

      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.rellenarRegistroAbastecimiento: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }            
      
      // se validan los accesos
      // se utlizan en el metodo: 
      // marca, 
      // subacceso, 
      // acceso (se obtiene a partir del subacceso), 
      // pais, 
      // canal (se obtiene a partir del acceso) 
      /*validaAccesos(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio)*/
      validaAccesos(dto.getOidPais(), null, dto.getMarca(), accesoLocal.getOidCanal(),
         subaccesoLocal.getOidAcceso(), dto.getSubacceso(), null, null, null, null, null); 
      
      try 
      {
         // Crear variable "respuesta" de tipo DTOSRellenarRegistroAbastecimiento
         // incidencia BELC300011895
         respuesta = new DTORegistroAbastecimiento();
         
         // Llamar al método "findByPrimaryKey()" de la entidad Marca tomando dto.marca
         MarcaLocal marcaLocal = getMarcaLocalHome().findByPrimaryKey(dto.getMarca()); 
         //respuesta.oidMarca = dto.marca 
         //respuesta.descripcionMarca = Marca.descripcion 
         respuesta.setOidMarca(dto.getMarca());
         respuesta.setDescripcionMarca(marcaLocal.getDes_marc());
         // asigno el pais y el idioma
         respuesta.setOidPais(dto.getOidPais());
         respuesta.setOidIdioma(dto.getOidIdioma());
         
         // Llamar al método "findByPrimaryKey()" de la entidad Subacceso tomando dto.subacceso 
         // ya lo he hecho antes porque necesito obtener el acceso a partir del subacceso para validar accesos
         
         // respuesta.oidSubacceso = dto.subacceso 
         respuesta.setOidSubacceso(dto.getSubacceso());
         // respuesta.descripcionSubacceso = descripción internacionalizada de subacceso para dto.subacceso 
         respuesta.setDescripcionSubacceso(UtilidadesI18N.recuperarTraducciones("SEG_SUBAC", dto.getSubacceso(), dto.getOidIdioma(), new Long(1)));         
         // respuesta.descripcionAcceso = descripción internacionalizada de acceso para Subacceso.oidAcceso 
         respuesta.setDescripcionAcceso(UtilidadesI18N.recuperarTraducciones("SEG_ACCES", subaccesoLocal.getOidAcceso(), dto.getOidIdioma(), new Long(1)));
         
         // Llamar al método "findByPrimaryKey()" de la entidad Acceso tomando Subacceso.oidAcceso 
         // ya lo he hecho antes porque necesito obtener el canal a partir del acceso para validar accesos
         
         // respuesta.oidCanal = Acceso.oidCanal 
         respuesta.setOidCanal(accesoLocal.getOidCanal());
         // respuesta.descripcionCanal = descripción internacionalizada de canal para Acceso.oidCanal 
         respuesta.setDescripcionCanal(UtilidadesI18N.recuperarTraducciones("SEG_CANAL", accesoLocal.getOidCanal(), dto.getOidIdioma(), new Long(1)));        
                  
         // Tomar los valores de dto.pais, dto.marca y dto.subacceso para la siguiente llamada 
         // Llamar al método "findByUK(pais : Long, marca : Long, subacceso : Long) : AsignacionAlmacen" de la entidad AsignacionAlmacen 
         AsignacionAlmacenLocal asignacionAlmacenLocal = null;
		 try{
			asignacionAlmacenLocal = getAsignacionAlmacenLocalHome().findByUK(dto.getOidPais(), dto.getMarca(), dto.getSubacceso());          
		 }catch(NoResultException fe){
			 this.logearError("MONRegistroAbastecimiento.rellenarRegistroAbastecimiento: FinderException", fe);
			throw new MareException(fe, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "",
                                ErroresDeNegocio.BEL_0019));
                 }  catch (PersistenceException ce) {   
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, 
                     UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		 }
         // respuesta.almacen = AsignacionAlmacen.oidAlmacen 
         respuesta.setOidAlmacen(asignacionAlmacenLocal.getAlmacen());
         // respuesta.descripcionAlmacen = descripción internacionalizada de almacén para AsignacionAlmacen.oidAlmacen 
         respuesta.setDescripcionAlmacen(UtilidadesI18N.recuperarTraducciones("BEL_ALMAC", asignacionAlmacenLocal.getAlmacen(), dto.getOidIdioma(), new Long(1)));                 
         
         // Crear variable llamada "numeroSolicitud" de tipo DTONumeroSolicitud haciendo el siguiente mapeo: 
         DTONumeroSolicitud numeroSolicitud = new DTONumeroSolicitud();
         // numeroSolicitud.pais = dto.pais 
         numeroSolicitud.setOidPais(dto.getOidPais());
         // numeroSolicitud.idioma = dto.idioma 
         numeroSolicitud.setOidIdioma(dto.getOidIdioma());
         // numeroSolicitud.operacion = "BEL006" 
         numeroSolicitud.setOperacion("BEL006");
         // numeroSolicitud.oidCanal = Acceso.oidCanal 
         numeroSolicitud.setOidCanal(accesoLocal.getOidCanal());
         // numeroSolicitud.oidAcceso = Subacceso.oidAcceso 
         numeroSolicitud.setOidAcceso(subaccesoLocal.getOidAcceso());
         // numeroSolicitud.oidSubacceso = dto.subacceso 
         numeroSolicitud.setOidSubacceso(dto.getSubacceso());
         // asigno el pais y el idioma
         numeroSolicitud.setOidPais(dto.getOidPais());
         numeroSolicitud.setOidIdioma(dto.getOidIdioma());
         
         // Tomar "numeroSolicitud" como parámetro para la siguiente llamada 
         // Llamar al método "MONProcesoPED.generaNumeroDocumento(dto : DTONumeroSolicitud) : String" 
         String nSolicitud = getMONProcesosPED().generaNumeroDocumento(numeroSolicitud);
         // respuesta.nSolicitud = respuesta a la llamada anterior de tipo String convertida a Long 
         respuesta.setNSolicitud(new Long(nSolicitud));
         // respuesta.oidAgrupacionStock = dto.agrupacionStock 
         respuesta.setOidAgrupacionStock(dto.getAgrupacionStock());
         
         UtilidadesLog.debug("****Metodo MONRegistroAbastecimiento.rellenarRegistroAbastecimiento: Salida");         

      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.rellenarRegistroAbastecimiento: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException e) {
         ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         this.logearError("MONRegistroAbastecimiento.rellenarRegistroAbastecimiento: RemoteException", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }
      // Devolver "respuesta" 
      UtilidadesLog.info("MONRegistroAbastecimientoBean.rellenarRegistroAbastecimiento(DTOERellenarRegistroAbastecimiento dto):Salida");
      return respuesta;
   }
 
   private MONGenerarSolicitudModulosExternos getMONGenerarSolicitudModulosExternos() throws MareException {
      // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONGenerarSolicitudModulosExternos: Entrada");				
      MONGenerarSolicitudModulosExternosHome home = (MONGenerarSolicitudModulosExternosHome)UtilidadesEJB.getHome("MONGenerarSolicitudModulosExternos", MONGenerarSolicitudModulosExternosHome.class);
            
      // Se obtiene el interfaz remoto
      MONGenerarSolicitudModulosExternos ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      	this.logearError("*** Error en MONRegistroAbastecimiento.getMONGenerarSolicitudModulosExternos",e);
      	String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       	throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONGenerarSolicitudModulosExternos: Salida");		        
      return ejb;
	}
   
   private MONProcesosPED getMONProcesosPED() throws MareException {
      // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONProcesosPED: Entrada");				
      MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome("MONProcesosPED", MONProcesosPEDHome.class);
            
      // Se obtiene el interfaz remoto
      MONProcesosPED ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      this.logearError("*** Error en MONRegistroAbastecimiento.getMONProcesosPED",e);
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONProcesosPED: Salida");		        
      return ejb;
	}
   
   private MONProductos getMONProductos() throws MareException {
      // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONProductos: Entrada");				
      MONProductosHome home = (MONProductosHome)UtilidadesEJB.getHome("MONProductos", MONProductosHome.class);
            
      // Se obtiene el interfaz remoto
      MONProductos ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      	this.logearError("*** Error en MONRegistroAbastecimiento.getMONProductos",e);
      	String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       	throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONProductos: Salida");		        
      return ejb;
	}

   public DTOSalida rellenarRegistroAbastecimientoDetalle(DTOERellenarRegistroAbastecimientoDetalle dto) 
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.rellenarRegistroAbastecimientoDetalle(DTOERellenarRegistroAbastecimientoDetalle dto):Entrada");
      
      UtilidadesLog.debug("DTOERellenarRegistroAbastecimientoDetalle: " + dto);
      /////////////////////////////////////////////////////////////
      //         se validan los vinculos
      /////////////////////////////////////////////////////////////

      try { 
         // a partir del subacceso obtengo el acceso
         Long acceso = this.getSubaccesoLocalHome().findByPrimaryKey(dto.getSubacceso()).getOidAcceso();
         // a partir del acceso obtengo el canal
         Long canal = this.getAccesoLocalHome().findByPrimaryKey(acceso).getOidCanal(); 
         
         // Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso
         validaVinculos(dto.getOidPais(), null, dto.getMarca(), canal, acceso, dto.getSubacceso());      
         
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.rellenarRegistroAbastecimientoDetalle: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException e)  {
         ctx.setRollbackOnly();
         this.logearError("*** Error en MONRegistroAbastecimiento.guardarRegistroAbastecimiento", e);
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
		}     
      

      RecordSet rs = null;
            
      try 
      {
         // -> Tomar el dto de entrada como parámetro para la siguiente llamada 
         // -> Llamar al método "DAORegistroAbastecimiento.rellenarRegistroAbastecimientoDetalle(dto : DTOEDetalleAbastecimiento) : DTOSalida" 
         // -> Crear variable llamada "rs" de tipo RecordSet y asignarle el RecordSet contenido en el DTOSalida de respuesta a la llamada anterior 
         String usuario = ctx.getCallerPrincipal().getName();
         DAORegistroAbastecimiento daoRA = new DAORegistroAbastecimiento(usuario);         
         rs = daoRA.rellenarRegistroAbastecimientoDetalle(dto).getResultado();
            
         // -> Llamar al método "findByPrimaryKey()" de la entidad AgrupacionCabecera tomando el valor dto.agrupacionStock 
         AgrupacionStockCabeceraLocal ascl = getAgrupacionStockCabeceraLocalHome().findByPrimaryKey(dto.getAgrupacionStock());
         
         // -> Crear variable llamada "codigoAgrupacion" de tipo String 
         // -> codigoAgrupacion = AgrupacionCabecera.codigoASC 
         String codigoAgrupacion = ascl.getCodigoASC();
         
         // -> Crear variable llamada "stockMinimo" de tipo Long inicializada a 0 
         Long stockMinimo = new Long(0);
         // -> Crear variable llamada "stockMaximo" de tipo Long inicializada a 0 
         Long stockMaximo = new Long(0);
         // -> Crear variable llamada "stockActual" de tipo Long inicializada a 0 
         Long stockActual = new Long(0);
         // -> Crear variable llamada "stockReposicion" de tipo Long inicializada a 0 
         Long stockReposicion = new Long(0);
         // -> Crear variable llamada "producto" de tipo Long inicializada a 0 
         Long producto = new Long(0);
         
         // obtenemos la interfaz local de MONServicioBEL
         MONServicioBEL monServicioBELLocal = getMONServicioBEL();
         
         // (1)Para cada registro i-ésimo de rs hacer 
         for (int i = 0; i < rs.getRowCount(); i++) {
            
            stockMinimo = new Long(((BigDecimal)rs.getValueAt(i, "VAL_STOC_MINI")).longValue());
            stockMaximo = new Long(((BigDecimal)rs.getValueAt(i, "VAL_STOC_MAXI")).longValue());
            producto = new Long(((BigDecimal)rs.getValueAt(i, "OID_PROD")).longValue());
            
            // -> Tomar los valores de dto.pais, dto.almacen, producto y codigoAgrupacion para la siguiente llamada 
            // -> Llamar al método "MONServicioBEL.recuperarStockEstadosAgrupados(pais : Long, almacen : Long, producto : Long, codigoAgrupacion : String) : Long" 
            // -> stockActual = respuesta a la llamada anterior 
            stockActual = monServicioBELLocal.recuperarStockEstadosAgrupados(dto.getOidPais(), dto.getAlmacen(), producto, codigoAgrupacion);
                        
            // -> Actualizar la columna "SALDO_ACTUAL" de "rs" de la fila i-ésima con el valor de "stockActual" 
            rs.setValueAt(stockActual, i, rs.getColumnPosition("SALDO_ACTUAL"));
            
            // (2)Si (stockActual <= stockMinimo) entonces 
            if (stockActual.longValue() <= stockMinimo.longValue()) {
               // -> stockReposicion = stockMaximo 
               stockReposicion = new Long(stockMaximo.longValue()); 
            } else { // (2)Si no 
               stockReposicion = new Long(0); 
            } // (2)Fin Si 
            
            // -> Actualizar la columna "UNIDADES_REPOSICION" de "rs" de la fila i-ésima con el valor de "stockReposicion" 
            rs.setValueAt(stockReposicion, i, rs.getColumnPosition("UNIDADES_REPOSICION"));            
		 } // (1)Fin Para 
      
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.rellenarRegistroAbastecimientoDetalle: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException e) {
         ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         this.logearError("MONRegistroAbastecimiento.rellenarRegistroAbastecimientoDetalle: RemoteException", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }

      UtilidadesLog.info("MONRegistroAbastecimientoBean.rellenarRegistroAbastecimientoDetalle(DTOERellenarRegistroAbastecimientoDetalle dto):Salida");
      
      // Devolver devolver el RecordSet "rs" encapsulado en un objeto DTOSalida      
      
      return new DTOSalida(rs);
   }

   private MONGenerarMovimientoAlmacen getMONGenerarMovimientoAlmacen() throws MareException {
      // Se obtiene el interfaz home
		  UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONGenerarMovimientoAlmacen: Entrada");				
      MONGenerarMovimientoAlmacenHome home = (MONGenerarMovimientoAlmacenHome)UtilidadesEJB.getHome("MONGenerarMovimientoAlmacen", MONGenerarMovimientoAlmacenHome.class);
            
      // Se obtiene el interfaz remoto
      MONGenerarMovimientoAlmacen ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      	this.logearError("*** Error en MONRegistroAbastecimiento.getMONGenerarMovimientoAlmacen",e);
      	String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
       	throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONGenerarMovimientoAlmacen: Salida");		        
      return ejb;
   }
 
   private MONServicioBEL getMONServicioBEL() throws MareException {
      // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONServicioBEL: Entrada");				
      MONServicioBELHome home = (MONServicioBELHome)UtilidadesEJB.getHome("MONServicioBEL", MONServicioBELHome.class);
            
      // Se obtiene el interfaz remoto
      MONServicioBEL ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      this.logearError("*** Error en MONRegistroAbastecimiento.getMONServicioBEL",e);
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONServicioBEL: Salida");		        
      return ejb;
	}
   
   public DTOSalida recuperarRegistroAbastecimiento(DTOERecuperarRegistroAbastecimiento dto) 
      throws MareException   
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.recuperarRegistroAbastecimiento(DTOERecuperarRegistroAbastecimiento dto):Entrada");
      
      // Tomar dto de entrada como parámetro para la siguiente llamada 
      // Llamar al método "DAORegistroAbastecimiento.recuperarRegistroAbastecimiento(dto : DTOERecuperacionRegistroAbastecimiento) : DTOSalida" 
      String usuario = ctx.getCallerPrincipal().getName();
      DAORegistroAbastecimiento daoRA = new DAORegistroAbastecimiento(usuario);         
      DTOSalida resultado = daoRA.recuperarRegistroAbastecimiento(dto);
      
      UtilidadesLog.info("MONRegistroAbastecimientoBean.recuperarRegistroAbastecimiento(DTOERecuperarRegistroAbastecimiento dto):Salida");
      // Devolver DTOSalida obtenido de la llamada anterior
      return resultado;
   }
   
   public DTORegistroAbastecimiento obtenerRegistroAbastecimiento(DTOOID dto) 
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.obtenerRegistroAbastecimiento(DTOOID dto):Entrada");
      DTORegistroAbastecimiento respuesta = null;            

      try {
        
                
        // Tomar dto.oid y llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoCabecera" 
         //RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().findByPrimaryKey(dto.getOid());
         RegistroAbastecimientoCabeceraLocalHome regAbastCabecLocalHome = this.getRegistroAbastecimientoCabeceraLocalHome();
         RegistroAbastecimientoCabeceraLocal regAbastCabecLocal=null;
         
         regAbastCabecLocal=regAbastCabecLocalHome.findByPrimaryKey(dto.getOid());
         
         // Crear variable llamada "respuesta" del tipo DTORegistroAbastecimiento y hacer el siguiente mapeo: 
         respuesta = new DTORegistroAbastecimiento();
         // asigno el pais y el idioma
         respuesta.setOidPais(dto.getOidPais());
         respuesta.setOidIdioma(dto.getOidIdioma());

         // respuesta.oid = RegistroAbastecimientoCabecera.oid 
         respuesta.setOid(regAbastCabecLocal.getOid());
         // respuesta.nSolicitud = RegistroAbastecimientoCabecera.nSolicitud 
         respuesta.setNSolicitud(regAbastCabecLocal.getNSolicitud());
         // respuesta.fechaCreado = RegistroAbastecimientoCabecera.fechaCreado 
         respuesta.setFechaCreado(regAbastCabecLocal.getFechaCreado());
         // respuesta.fechaEnviado = RegistroAbastecimientoCabecera.fechaEnviado 
         respuesta.setFechaEnviado(regAbastCabecLocal.getFechaEnviado());
         // respuesta.fechaConfirmado = RegistroAbastecimientoCabecera.fechaConfirmado 
         respuesta.setFechaConfirmado(regAbastCabecLocal.getFechaConfirmado());
         // respuesta.fechaIngresado = RegistroAbastecimientoCabecera.fechaIngresado 
         respuesta.setFechaIngresado(regAbastCabecLocal.getFechaIngresado());
         // respuesta.indicadorSAP = RegistroAbastecimientoCabecera.indicadorSAP 
         respuesta.setIndicadorSAP(regAbastCabecLocal.getIndicadorSAP());
         // respuesta.oidEstadoHojaDemanda = RegistroAbastecimientoCabecera.oidEstadoHojaDemanda 
         respuesta.setOidEstadoHojaDemanda(regAbastCabecLocal.getEstadoHojaDemanda());
         //respuesta.oidPeriodo = RegistroAbastecimientoCabecera.oidPeriodo 
         respuesta.setOidPeriodo(regAbastCabecLocal.getPeriodo());
         
         // Llamar al método "findByPrimaryKey()" de la entidad Periodo (CRA) tomando RegistroAbastecimientoCabecera.oidPeriodo 
         PeriodoLocal periodoLocal = getPeriodoLocalHome().findByPrimaryKey(regAbastCabecLocal.getPeriodo());        
         // respuesta.oidMarca = Periodo.oidMarca 
         // respuesta.oidCanal = Periodo.oidCanal 
         respuesta.setOidMarca(periodoLocal.getOidMarca());
         respuesta.setOidCanal(periodoLocal.getOidCanal());
            
         // Llamar al método "findByPrimaryKey()" de la entidad Marca tomando Periodo.oidMarca 
         MarcaLocal marcaLocal = getMarcaLocalHome().findByPrimaryKey(periodoLocal.getOidMarca());
         // respuesta.descripcionMarca = Marca.descripcion 
         respuesta.setDescripcionMarca(marcaLocal.getDes_marc());
         // respuesta.descripcionCanal = descripción internacionalizada de canal tomando Periodo.oidCanal 
         respuesta.setDescripcionCanal(UtilidadesI18N.recuperarTraducciones("SEG_CANAL", periodoLocal.getOidCanal(), dto.getOidIdioma(), new Long(1)));
         // respuesta.oidSubacceso = RegistroAbastecimientoCabecera.oidSubacceso 
         respuesta.setOidSubacceso(regAbastCabecLocal.getSubacceso());
         // respuesta.descripcionSubacceso = descripción internacionalizada de subacceso tomando RegistroAbastecimientoCabecera.oidSubacceso 
         respuesta.setDescripcionSubacceso(UtilidadesI18N.recuperarTraducciones("SEG_SUBAC", regAbastCabecLocal.getSubacceso(), dto.getOidIdioma(), new Long(1)));
                           
         // Llamar al método "findByPrimaryKey()" de la entidad Subacceso tomando RegistroAbastecimientoCabecera.oidSubacceso 
         SubaccesoLocal subaccLocal = getSubaccesoLocalHome().findByPrimaryKey(regAbastCabecLocal.getSubacceso());
         // respuesta.oidAcceso = Subacceso.oidAcceso 
         // incidencia BELC300011916
         respuesta.setOidAcceso(subaccLocal.getOidAcceso());
         
         // respuesta.descripcionAcceso = descripción internacionalizada de acceso tomando Subacceso.oidAcceso 
         respuesta.setDescripcionAcceso(UtilidadesI18N.recuperarTraducciones("SEG_ACCES", subaccLocal.getOidAcceso(), dto.getOidIdioma(), new Long(1)));
         // respuesta.oidAlmacen = RegistroAbastecimientoCabecera.oidAlmacen 
         respuesta.setOidAlmacen(regAbastCabecLocal.getAlmacen());
         // respuesta.descripcionAlmacen = descripción internacionalizada de almacén tomando RegistroAbastecimientoCabecera.oidAlmacen 
         respuesta.setDescripcionAlmacen(UtilidadesI18N.recuperarTraducciones("BEL_ALMAC", regAbastCabecLocal.getAlmacen(), dto.getOidIdioma(), new Long(1)));
         // respuesta.oidAgrupacionStock = RegistroAbastecimientoCabecera.oidAgrupacionStockCabecera 
         respuesta.setOidAgrupacionStock(regAbastCabecLocal.getAgrupacionStockCabecera());
         
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.obtenerRegistroAbastecimiento: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }   
      UtilidadesLog.info("MONRegistroAbastecimientoBean.obtenerRegistroAbastecimiento(DTOOID dto):Salida");
      return respuesta;
   }
   
   public DTOSalida obtenerRegistroAbastecimientoDetalle(DTOEObtenerRegistroAbastecimientoDetalle dto) 
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.obtenerRegistroAbastecimientoDetalle(DTOEObtenerRegistroAbastecimientoDetalle dto):Entrada");
      
      RecordSet rs = null;
      
      try 
      {
         // -> Tomar dto de entrada como parámetro en la siguiente llamada 
         // -> Llamar al método "DAORegistroAbastecimiento.obtenerRegistroAbastecimientoDetalle(dto : DTOEObtenerRegistroAbastecimientoDetalle) : DTOSalida" 
         // -> Crear variable llamada "rs" de tipo RecordSet y asignarle el RecordSet contenido en el DTOSalida de respuesta a la llamada anterior 
         String usuario = ctx.getCallerPrincipal().getName();
         DAORegistroAbastecimiento daoRA = new DAORegistroAbastecimiento(usuario);         
         rs = daoRA.obtenerRegistroAbastecimientoDetalle(dto).getResultado();

         // -> Llamar al método "findByPrimaryKey()" de la entidad AgrupacionCabecera tomando el valor dto.agrupacionStock 
         AgrupacionStockCabeceraLocal agrupStockCabecLocal = getAgrupacionStockCabeceraLocalHome().findByPrimaryKey(dto.getAgrupacionStock());
         
         // -> Crear variable llamada "codigoAgrupacion" de tipo String 
         // -> codigoAgrupacion = AgrupacionCabecera.codigoASC 
         String codigoAgrupacion = agrupStockCabecLocal.getCodigoASC();
                  
         // -> Crear variable llamada "stockActual" de tipo Long inicializada a 0 
         // -> Crear variable llamada "stockReposicion" de tipo Long inicializada a 0 
         // -> Crear variable llamada "producto" de tipo Long inicializada a 0 
         Long stockActual = new Long(0);
         Long stockReposicion = new Long(0);
         Long producto = new Long(0);
         
         // (1)Para (i = 0; i < longitud de rs; i++) hacer 
         for (int i=0; i < rs.getRowCount(); i++) {
         
            producto = new Long(((BigDecimal)rs.getValueAt(i, "PROD_OID_PROD")).longValue());

            // -> Tomar los valores de dto.pais, dto.almacen, producto y codigoAgrupacion para la siguiente llamada 
            // -> Llamar al método "MONServicioBEL.recuperarStockEstadosAgrupados(pais : Long, almacen : Long, producto : Long, codigoAgrupacion : String) : Long" 
            // -> stockActual = respuesta a la llamada anterior 
            stockActual = getMONServicioBEL().recuperarStockEstadosAgrupados(dto.getOidPais(), dto.getAlmacen(), producto, codigoAgrupacion);
            
            // -> Actualizar la columna "SALDO_ACTUAL" de "rs" de la fila i-ésima con el valor de "stockActual" 
            rs.setValueAt(stockActual, i, rs.getColumnPosition("SALDO_ACTUAL"));            
         } // (1)Fin Para 
         
         UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.obtenerRegistroAbastecimientoDetalle: Salida");		        
      
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.obtenerRegistroAbastecimientoDetalle: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException e) {
         ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         this.logearError("MONRegistroAbastecimiento.obtenerRegistroAbastecimientoDetalle: RemoteException", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }
      
      // Devolver DTOSalida de respuesta de la llamada anterior         
      UtilidadesLog.info("MONRegistroAbastecimientoBean.obtenerRegistroAbastecimientoDetalle(DTOEObtenerRegistroAbastecimientoDetalle dto):Salida");
      return new DTOSalida(rs);
   }
   
   public DTORegistroAbastecimientoDetalle anadirProductosRA(DTOAnadirProductosRA dto)
      throws MareException 
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.anadirProductosRA(DTOAnadirProductosRA dto):Entrada");
      
      UtilidadesLog.debug("DTOAnadirProductosRA: " + dto);

      ///////////////////////////////////////////////////////////////
      // se validan los vinculos
      // los accesos no los validamos porque no se modifica la BBDD
      try {
         // a partir del subacceso obtendo el acceso
         Long acceso = this.getSubaccesoLocalHome().findByPrimaryKey(dto.getSubacceso()).getOidAcceso();
         // a partir del acceso obtendo el canal
         Long canal = this.getAccesoLocalHome().findByPrimaryKey(acceso).getOidCanal();
         
         // Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso
         validaVinculos(dto.getOidPais(), null, dto.getMarca(), canal, acceso, dto.getSubacceso());

      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.rellenarRegistroAbastecimiento: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException e)  {
         ctx.setRollbackOnly();
         this.logearError("*** Error en MONRegistroAbastecimiento.anadirProductosRA", e);
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
		}

      DTORegistroAbastecimientoDetalle registroDetalle = null;
      MaestroProductosLocal maestProdLocal = null;
      
      try {
         // -> Crear variable llamada "registroDetalle" de tipo DTORegistroAbastecimientoDetalle 
         registroDetalle = new DTORegistroAbastecimientoDetalle();
         
         // -> Tomar dto.pais y dto.codigoProducto 
         // -> Llamar al método "findByUK(pais : Long, codigoSAP : String) : MaestroProductos" de la entidad "MaestroProductos" 
         maestProdLocal = getMaestroProductosLocalHome().findByUK(dto.getOidPais(), dto.getCodigoProducto());

      // -> Capturar la exception de la llamada anterior 
      } catch (FinderException fe) {
         
         this.logearError("MONRegistroAbastecimiento.anadirProductosRA: FinderException", fe);

         // (1) Si se produce una FinderExcepcion entonces 
         // -> Lanzar una MareException con código de error "BEL-0009" 
         // BEL-0009	Producto no existe	

         throw new MareException (new Exception(),
         	UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "",
            ErroresDeNegocio.PRODUCTO_NO_EXISTE));
      }         

      // (1) Si no entonces 

      // asigno el pais y el idioma
      registroDetalle.setOidPais(dto.getOidPais());
      registroDetalle.setOidIdioma(dto.getOidIdioma());
      // registroDetalle.oidProducto = MaestroProductos.oid 
      registroDetalle.setOidProducto(maestProdLocal.getOid());
      // registroDetalle.unidadesConfirmadas = 0 
      registroDetalle.setUnidadesConfirmadas(new Long(0));
      // registroDetalle.unidadesAtendidas = 0 
      registroDetalle.setUnidadesAtendidas(new Long(0));
      // registroDetalle.codigoSAP = MaestroProductos.codigoSAP 
      registroDetalle.setCodigoSAP(maestProdLocal.getCodigoSAP());
      // registroDetalle.descripcionCorta = MaestroProductos.descripcionCorta 
      registroDetalle.setDescripcionCorta(maestProdLocal.getDescripcionCorta());
      
      ControlesDeAlmacenLocal controlAlmacLocal = null;
      
      boolean seProdujoFinderException = false;

      try {         
         // Tomar dto.subacceso y MaestroProductos.oid como parámetros para la siguiente llamada 
         // Llamar al método "findByUK(subacceso : Long, producto : Long) : ControlesDeAlmacen" de la entidad "ControlesDeAlmacen" 
         // incidencia BELC300012171
         controlAlmacLocal = getControlesDeAlmacenLocalHome().findByUK(dto.getSubacceso(), maestProdLocal.getOid(), dto.getAlmacen());
         
         // Captuar la exception de la llamada anterior 
      } catch (NoResultException fe) {

         this.logearError("MONRegistroAbastecimiento.anadirProductosRA: FinderException", fe);         // (2) Si se produce una FinderException entonces 
         
         seProdujoFinderException = true;
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

      }
      
      // (2) Si se produce una FinderException entonces 
      if (seProdujoFinderException) {   
         // registroDetalle.unidadesEnviadas = 0 
         registroDetalle.setUnidadesEnviadas(new Long(0));
         // registroDetalle.stockMinimo = 0 
         registroDetalle.setStockMinimo(new Long(0));
         // registroDetalle.stockMaximo = 0 
         registroDetalle.setStockMaximo(new Long(0));
      } else { // (2) Si no entonces 
         // -> registroDetalle.unidadesEnviadas = ControlesDeAlmacen.stockReposicion 
         registroDetalle.setUnidadesEnviadas(controlAlmacLocal.getStockReposicion());
         // -> registroDetalle.stockMinimo = ControlesDeAlmacen.stockMinimo 
         registroDetalle.setStockMinimo(controlAlmacLocal.getStockMinimo());
         // -> registroDetalle.stockMaximo = ControlesDeAlmacen.stockMaximo 
         registroDetalle.setStockMaximo(controlAlmacLocal.getStockMaximo());
      } // (2) Fin Si 

      UtilidadesLog.info("MONRegistroAbastecimientoBean.anadirProductosRA(DTOAnadirProductosRA dto):Salida");

      // -> Devolver "registroDetalle" 
      return registroDetalle;
   }
   
   public void guardarRegistroAbastecimiento(DTORegistroAbastecimiento dto)
      throws MareException 
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.guardarRegistroAbastecimiento(DTORegistroAbastecimiento dto):Entrada");

      try { 
         // a partir del subacceso obtengo el acceso
         Long acceso = this.getSubaccesoLocalHome().findByPrimaryKey(dto.getOidSubacceso()).getOidAcceso();
         // a partir del acceso obtengo el canal
         Long canal = this.getAccesoLocalHome().findByPrimaryKey(acceso).getOidCanal(); 
      
         // se validan los accesos
         /* Long pais, Long sociedad, Long marca, Long canal,
           Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
           Long seccion, Long territorio */
         validaAccesos(dto.getOidPais(), null, dto.getOidMarca(), canal, 
            acceso, dto.getOidSubacceso(), null, null, null, null, null); 
      
         // se validan los vinculos
         // Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso
         validaVinculos(dto.getOidPais(), null, dto.getOidMarca(), canal, acceso, dto.getOidSubacceso());      
      
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.guardarRegistroAbastecimiento: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException e)  {
         this.logearError("*** Error en MONRegistroAbastecimiento.guardarRegistroAbastecimiento", e);
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
      }     
      
      DTORegistroAbastecimientoDetalle dtoRegAbastDetalle = null;
      RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = null;
      RegistroAbastecimientoDetalleLocal regAbastDetLocal = null;
      RegistroAbastecimientoDetalleLocalHome regAbastDetLocalHome = null;
      
      // se obtienen los detalles del registro de abastecimiento
      ArrayList regAbastDetalles = dto.getDetalle();

      // (1) Si (dto.oid == null) entonces 
      if (dto.getOid() == null) {
         
         // incidencia BELC300012945: se busca el periodo actual
         // Tomar dto.pais, dto.marca y dto.canal
         // Llamar al método IPeriodos.obtienePeriodoActual(pais : Long, marca : Long, canal : Long) : DTOPeriodo
         DTOPeriodo dtoPeriodo = null;         
         try {
            dtoPeriodo = getMONPeriodos().obtienePeriodoActual(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal());
         } catch (RemoteException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            this.logearError("MONRegistroAbastecimiento.guardarRegistroAbastecimiento: RemoteException", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
         }
         
         // Tomar DTOPeriodo.oid y asignarlo al atributo del dto de entrada "dto.oidPeriodo"
         dto.setOidPeriodo(dtoPeriodo.getOid());      
         
         // Se crea el Registro de Abastecimiento 
         // Llamar al método "MONRegistroAbastecimiento.crearRegistroAbastecimientoCabecera(dto : DTORegistroAbastecimiento) : Long" 
         Long oidCabeceraCreada = this.crearRegistroAbastecimientoCabecera(dto);
         UtilidadesLog.debug("**** oidCabeceraCreada: " + oidCabeceraCreada);
         // (2) Para cada DTORegistroAbastecimientoDetalle contenido en el arrayList "dto.detalle" hacer 
        
         // compruebo que hay detalles introducidos
         if (regAbastDetalles != null) {
         
            for (int i=0; i < regAbastDetalles.size(); i++) {
               // Tomar el dto de detalle para la siguiente llamada 
               dtoRegAbastDetalle = (DTORegistroAbastecimientoDetalle)regAbastDetalles.get(i);
               
               // y llenar su atributo "oidRegistroAbastecimientoCabecera" con el oid devuelto por la llamada anterior 
               dtoRegAbastDetalle.setOidRegistroAbastecimientoCabecera(oidCabeceraCreada);
               
               // Llamar al método "MONRegistroAbastecimiento.crearRegistroAbastecimientoDetalle(dto : DTORegistroAbastecimientoDetalle) : void" 
               this.crearRegistroAbastecimientoDetalle(dtoRegAbastDetalle);            
            } // (2) Fin Para 
         }
      
      ///////////////////////////////////////////////////////////////////////////////////
      ///////////            la cabecera ya existe
      ///////////////////////////////////////////////////////////////////////////////////
      } else { // oid de cabecera distinto de null
         
         // Se busca la cabecera y se actualiza el estado de hoja de demanda 
         // Llamar al método "findByPrimaryKey" de la entidad RegistroAbastecimientoCabecera tomando el valor de dto.oid 
         try {
            regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().findByPrimaryKey(dto.getOid());
         } catch (NoResultException fe) {
            ctx.setRollbackOnly();
            this.logearError("MONRegistroAbastecimiento.guardarRegistroAbastecimiento: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }   
         
         // RegistroAbastecimientoCabecera.oidEstadoHojaDemanda = ConstantesBEL.ESTADO_HOJA_DEMANDA_ENVIADO 
         regAbastCabecLocal.setEstadoHojaDemanda(ConstantesBEL.ESTADO_HOJA_DEMANDA_ENVIADO);
	 regAbastCabecLocal.setFechaEnviado(dto.getFechaEnviado());
         
         this.getRegistroAbastecimientoCabeceraLocalHome().merge(regAbastCabecLocal);
      
         ///////////////////////////////////////////////////////////////////////
         // BELC300013122. Eliminacion de registros
         this.borrarDeBBDDDetallesEliminadosEnLista(dto.getOid(), regAbastDetalles);
         ///////////////////////////////////////////////////////////////////////
         
         
         regAbastDetLocalHome = this.getRegistroAbastecimientoDetalleLocalHome();

         ///////////////////////////////////////////////////////////////////////
         // incidencia BELC300013014. Se guardan los nuevos detalles añadidos 
         // al registro de abastecimiento existente. 
         // Los que ya existian se modifican
         //////////////////////////////////////////////////////////////////////////
         
         // Para cada DTORegistroAbastecimientoDetalle contenido en el arrayList "dto.detalle" hacer
         for (int i=0; i < regAbastDetalles.size(); i++) {
            
            // Si (DTORegistroAbastecimientoDetalle.oid == null) entonces
            dtoRegAbastDetalle = (DTORegistroAbastecimientoDetalle)regAbastDetalles.get(i);
            
            if (dtoRegAbastDetalle.getOid() == null) { // se añade un nuevo detalle
               // Tomar el DTORegistroAbastecimientoDetalle como parámetro para la siguiente llamada
               // Llamar al método "MONRegistroAbastecimiento.crearRegistroAbastecimientoDetalle(dto : DTORegistroAbastecimientoDetalle) : void"
               this.crearRegistroAbastecimientoDetalle(dtoRegAbastDetalle);            
                              
            } else { // se modifica un detalle existente
               // Tomar DTORegistroAbastecimientoDetalle.oid
               // Hacer findByPrimaryKey() sobre la entidad RegistroAbstecimientoDetalle
               try {
                  regAbastDetLocal = regAbastDetLocalHome.findByPrimaryKey(dtoRegAbastDetalle.getOid());
               } catch (NoResultException fe) {
                  ctx.setRollbackOnly();
                  this.logearError("MONRegistroAbastecimiento.guardarRegistroAbastecimiento: FinderException", fe);
                  String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                  throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
               }  catch (PersistenceException ce) {   
                   UtilidadesLog.error("ERROR ", ce);
                   throw new MareException(ce, 
                   UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
               }            
              
               //  Actualizar la entidad con los datos del dto
               //regAbastDetLocal.setNumeroLinea(dtoRegAbastDetalle.getNumeroLinea());
               //regAbastDetLocal.setProducto(dtoRegAbastDetalle.getOidProducto());
               //regAbastDetLocal.setRegistroAbastecimientoCabecera(dtoRegAbastDetalle.getOidRegistroAbastecimientoCabecera());
               regAbastDetLocal.setStockMaximo(dtoRegAbastDetalle.getStockMaximo());
               regAbastDetLocal.setStockMinimo(dtoRegAbastDetalle.getStockMinimo());
               regAbastDetLocal.setTipoActuacion(dtoRegAbastDetalle.getOidTipoActuacion());
               regAbastDetLocal.setUnidadesAtendidas(dtoRegAbastDetalle.getUnidadesAtendidas());
               regAbastDetLocal.setUnidadesConfirmadas(dtoRegAbastDetalle.getUnidadesConfirmadas());
               regAbastDetLocal.setUnidadesEnviadas(dtoRegAbastDetalle.getUnidadesEnviadas());
               regAbastDetLocalHome.merge(regAbastDetLocal);
            }
         } 

         // Se genera un movimiento de almacén 
         // Llamar al método "MONRegistroAbastecimiento.generarMovimientosAlmacen(dto : DTORegistroAbastecimiento) : void" 
         this.generarMovimientosAlmacen(dto);         
      } // (1) Fin Si
            
      UtilidadesLog.info("MONRegistroAbastecimientoBean.guardarRegistroAbastecimiento(DTORegistroAbastecimiento dto):Salida");
   }
   
   private void borrarDeBBDDDetallesEliminadosEnLista(Long oidCabec, ArrayList detallesDePresentacion) 
      throws MareException
   {

      UtilidadesLog.info("MONRegistroAbastecimientoBean.borrarDeBBDDDetallesEliminadosEnLista(Long oidCabec, ArrayList detallesDePresentacion):Entrada");
      
      DTORegistroAbastecimientoDetalle dtoRegAbastDetalle = null;
      
      // se buscan todos los detalles que hasta ahora pertenecen al registro de abastecimiento
      String usuario = ctx.getCallerPrincipal().getName();
      DTOEObtenerRegistroAbastecimientoDetalle dtoe = new DTOEObtenerRegistroAbastecimientoDetalle();
      dtoe.setOidRegistroAbastecimientoCabecera(oidCabec);
      RecordSet rs = new DAORegistroAbastecimiento(usuario).obtenerRegistroAbastecimientoDetalle(dtoe).getResultado();
      
      UtilidadesLog.debug("****devuelto el dao: ");
      ArrayList detallesEnBBDD = new ArrayList();
      for (int i=0; i < rs.getRowCount(); i++) {
         detallesEnBBDD.add(new Long(((BigDecimal)rs.getValueAt(i, 0)).longValue()));
      }
      UtilidadesLog.debug("****despues del primer for: ");         
      // se obtienen los oids de los detalles que vienen de presentacion. 
      ArrayList detallesEnLista = new ArrayList();
      if(detallesDePresentacion.size() > 0){
      UtilidadesLog.debug("****dentro del if: ");
        for (int i=0; i < detallesDePresentacion.size(); i++) {
            dtoRegAbastDetalle = (DTORegistroAbastecimientoDetalle)detallesDePresentacion.get(i);
            if (dtoRegAbastDetalle.getOid() != null) {
                detallesEnLista.add(dtoRegAbastDetalle.getOid());
            }
         }
      }
      UtilidadesLog.debug("****pasado segundo for: ");
      
      // se hace un findByPrimaryKey de los que aparezcan en la primera lista y no en la segunda
      // se eliminan
      
      RegistroAbastecimientoDetalleLocal regAbastDetLocal = null;
      RegistroAbastecimientoDetalleLocalHome regAbastDetLocalHome = this.getRegistroAbastecimientoDetalleLocalHome();
      
      Long oidDetTemp = null;
      
      for (int i=0; i < detallesEnBBDD.size(); i++) {
        UtilidadesLog.debug("****dentro tercer for: ");
         oidDetTemp = (Long)detallesEnBBDD.get(i);

         if (! detallesEnLista.contains(oidDetTemp)) {
            
            try {
               regAbastDetLocal = regAbastDetLocalHome.findByPrimaryKey(oidDetTemp);
               regAbastDetLocalHome.remove(regAbastDetLocal);
            } catch (NoResultException fe) {
               ctx.setRollbackOnly();
               this.logearError("MONRegistroAbastecimiento.borrarDeBBDDDetallesEliminadosEnLista: FinderException", fe);
               String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            } catch (PersistenceException re) {
               ctx.setRollbackOnly();
               this.logearError("MONRegistroAbastecimiento.borrarDeBBDDDetallesEliminadosEnLista: RemoveException", re);
               String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
               throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }            
         }
      }
      
      UtilidadesLog.info("MONRegistroAbastecimientoBean.borrarDeBBDDDetallesEliminadosEnLista(Long oidCabec, ArrayList detallesDePresentacion):Salida");
   }
   
   private Long crearRegistroAbastecimientoCabecera(DTORegistroAbastecimiento dto) 
      throws MareException   
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.crearRegistroAbastecimientoCabecera(DTORegistroAbastecimiento dto):Entrada");
      UtilidadesLog.debug("****DTOEntrada: "+dto);
      
      // Hacer create sobre la entidad RegistroAbastecimientoCabecera haciendo el siguiente mapeo: 

      RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = null;
      
      try {
      
         regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().create(
               dto.getNSolicitud(),
               dto.getOidPeriodo(),
               dto.getOidAlmacen(),
               dto.getOidSubacceso(),
               dto.getOidPais(),
               dto.getOidEstadoHojaDemanda(),
               dto.getOidAgrupacionStock()
            );
            
         // RegistroAbastecimientoCabecera.oidMarca = dto.oidMarca 
         // RegistroAbastecimientoCabecera.fechaCreado = dto.fechaCreado 
         // RegistroAbastecimientoCabecera.fechaEnviado = dto.fechaEnviado 
         // RegistroAbastecimientoCabecera.fechaConfirmado = dto.fechaConfirmado 
         // RegistroAbastecimientoCabecera.fechaIngresado = dto.fechaIngresado 
         // RegistroAbastecimientoCabecera.indicadorSAP = dto.indicadorSAP 
         // RegistroAbastecimientoCabecera.observaciones = dto.observaciones 
         
         // no se asigna valor al atributo marca por incidencia BELC300011950
         //regAbastCabecLocal.setMarca(dto.getOidMarca());
         regAbastCabecLocal.setFechaCreado(dto.getFechaCreado());
         regAbastCabecLocal.setFechaEnviado(dto.getFechaEnviado());
         regAbastCabecLocal.setFechaConfirmado(dto.getFechaConfirmado());
         regAbastCabecLocal.setFechaIngresado(dto.getFechaIngresado());
         regAbastCabecLocal.setIndicadorSAP(dto.getIndicadorSAP());
         // incidencia BELC300011950
         regAbastCabecLocal.setObservaciones(dto.getObservaciones());
         
         this.getRegistroAbastecimientoCabeceraLocalHome().merge(regAbastCabecLocal);
               

      } catch (PersistenceException e) {
         this.logearError("MONRegistroAbastecimiento.crearRegistroAbastecimientoCabecera: CreateException", e);
         ctx.setRollbackOnly();
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
         
      // Devolver RegistroAbastecimientoCabecera.oid del registro creado
      UtilidadesLog.info("MONRegistroAbastecimientoBean.crearRegistroAbastecimientoCabecera(DTORegistroAbastecimiento dto):Salida");
      return regAbastCabecLocal.getOid();
   }
   
   private void crearRegistroAbastecimientoDetalle(DTORegistroAbastecimientoDetalle dto)   
      throws MareException   
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.crearRegistroAbastecimientoDetalle(DTORegistroAbastecimientoDetalle dto):Entrada");
      UtilidadesLog.debug("****DTOEntrada: "+dto);
      // Tomar el valor de "dto.oidRegistroAbastecimientoCabecera" como parámetro para la siguiente llamada 
      // Llamar al método "DAORegistroAbastecimientoDetalle.obtenerMaximaLineaHojaDemanda(oidHojaDemanda : Long) : Integer" 
      // dto.numeroLinea = valor recuperado de la llamada anterior + 1 
      
      String usuario = ctx.getCallerPrincipal().getName();
      DAORegistroAbastecimiento daoRegAbast = new DAORegistroAbastecimiento(usuario);
      dto.setNumeroLinea(new Integer(daoRegAbast.obtenerMaximaLineaHojaDemanda(dto.getOidRegistroAbastecimientoCabecera()).intValue() + 1));
      
      try {
         // Llamar al método "create()" de la entidad RegistroAbastecimientoDetalle haciendo el siguiente mapeo: 
         RegistroAbastecimientoDetalleLocal regAbastDetaLocal = getRegistroAbastecimientoDetalleLocalHome().create(
            dto.getOidRegistroAbastecimientoCabecera(),
            dto.getOidProducto(),
            dto.getNumeroLinea()
         );
         // RegistroAbastecimientoDetalle.unidadesEnviadas = dto.unidadesEnviadas 
         // RegistroAbastecimientoDetalle.unidadesConfirmadas = dto.unidadesConfirmadas 
         // RegistroAbastecimientoDetalle.unidadesAtendidas = dto.unidadesAtendidas 
         // RegistroAbastecimientoDetalle.oidTipoActuacion = dto.oidTipoActuacion
         regAbastDetaLocal.setUnidadesEnviadas(dto.getUnidadesEnviadas());
         regAbastDetaLocal.setUnidadesConfirmadas(dto.getUnidadesConfirmadas());
         regAbastDetaLocal.setUnidadesAtendidas(dto.getUnidadesAtendidas());
         regAbastDetaLocal.setTipoActuacion(dto.getOidTipoActuacion());
         regAbastDetaLocal.setStockMaximo(dto.getStockMaximo());
         regAbastDetaLocal.setStockMinimo(dto.getStockMinimo());
         
         this.getRegistroAbastecimientoDetalleLocalHome().merge(regAbastDetaLocal);
      
      } catch (PersistenceException e) {
         this.logearError("MONRegistroAbastecimiento.crearRegistroAbastecimientoCabecera: CreateException", e);
         ctx.setRollbackOnly();
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      UtilidadesLog.info("MONRegistroAbastecimientoBean.crearRegistroAbastecimientoDetalle(DTORegistroAbastecimientoDetalle dto):Salida");
   }
   
   public DTOSalida obtenerHojaDemanda(DTOERecuperarRegistroAbastecimiento dto) 
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.obtenerHojaDemanda(DTOERecuperarRegistroAbastecimiento dto):Entrada");
      
      // Llamar al método "DAORegistroAbastecimiento.obtenerHojaDemanda(dto : DTOERecuperarRegistroAbastecimiento) : DTOSalida" 
      // Devolver el DTOSalida obtenido en la llamada anterior
      String usuario = ctx.getCallerPrincipal().getName();
      DAORegistroAbastecimiento daoRegAbast = new DAORegistroAbastecimiento(usuario);
         
      
      DTOSalida dtoSalida = daoRegAbast.obtenerHojaDemanda(dto);
      UtilidadesLog.info("MONRegistroAbastecimientoBean.obtenerHojaDemanda(DTOERecuperarRegistroAbastecimiento dto):Salida");
      return dtoSalida;
   }
   
   
   // enviaron diseño nuevo de este método en un correo de Antonio Poyato del
   // dia 10/01/2005. Esta subido en el servidor de ficheros
   public void actualizarHojaDemanda(DTORegistroAbastecimiento dto) 
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.actualizarHojaDemanda(DTORegistroAbastecimiento dto):Entrada");
      
      // se validan los accesos
      /*validaAccesos(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio)*/
      validaAccesos(dto.getOidPais(), null, dto.getOidMarca(), dto.getOidCanal(),
        dto.getOidAcceso(), dto.getOidSubacceso(), null, null, null, null, null);
      
      RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = null;      
      
      try {
         // Llamar al método "findByPrimaryKey()" de la entidad RegistroAbastecimientoCabecera tomando dto.oid 
         regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().findByPrimaryKey(dto.getOid());
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.actualizarHojaDemanda: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }         
      // RegistroAbastecimientoCabecera.oidEstadoHojaDemanda = dto.oidEstadoHojaDemanda 
      regAbastCabecLocal.setEstadoHojaDemanda(dto.getOidEstadoHojaDemanda());
      // RegistroAbastecimientoCabecera.fechaConfirmado = dto.fechaConfirmado 
      regAbastCabecLocal.setFechaConfirmado(dto.getFechaConfirmado());
      
      this.getRegistroAbastecimientoCabeceraLocalHome().merge(regAbastCabecLocal);
      
      // Llamar al CU Generar Solicitud desde módulos externos
      // Llamar al método "MONRegistroAbastecimiento.generarSolicitudAHD(dto : DTORegistroAbastecimiento) : void"
      this.generarSolicitudAHD(dto);

      // Llamar al CU Grabar Movimiento de almacén y stock
      // Llamar al método "MONRegistroAbastecimiento.generarMovimientosAlmacen(dto : DTORegistroAbastecimiento) : void"
      this.generarMovimientosAlmacen(dto);

                  
      UtilidadesLog.info("MONRegistroAbastecimientoBean.actualizarHojaDemanda(DTORegistroAbastecimiento dto):Salida");
   }
   
   public DTOSalida buscarHojaDemadaDetalle(DTOEBuscarHojaDemandaDetalle dto) 
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.buscarHojaDemadaDetalle(DTOEBuscarHojaDemandaDetalle dto):Entrada");
      
      // Tomar el dto de entrada como parámetro para la siguiente llamada 
      // Llamar al método "MONRegistroAbastecimiento.buscarHojaDemadaDetalle(dto : DTOEBuscarHojaDemandaDetalle) : DTOSalida" 
      String usuario = ctx.getCallerPrincipal().getName();
      DAORegistroAbastecimiento daoRegAbast = new DAORegistroAbastecimiento(usuario);
      
      // Devolver el DTOSalida obtenido como respuesta a la llamada anterior      
      DTOSalida dtoSalida = daoRegAbast.buscarHojaDemadaDetalle(dto);
      UtilidadesLog.info("MONRegistroAbastecimientoBean.buscarHojaDemadaDetalle(DTOEBuscarHojaDemandaDetalle dto):Salida");
      return dtoSalida;
   }
 
   public DTOProducto buscarProductoHDDetalle(DTOString dto) 
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.buscarProductoHDDetalle(DTOString dto):Entrada");
      
      // -> Crear variable llamada "respuesta" de tipo DTOProducto inicializada a null 
      DTOProducto respuesta = null;
      MaestroProductosLocal maeProdLocal = null;
      
      try {
         // Tomar los valores dto.pais y dto.cadena para la siguiente llamada 
         // Llamar al método "findByUK(pais : Long, codigoSAP : String) : MaestroProductos" de la entidad MaestroProductos 
         maeProdLocal = getMaestroProductosLocalHome().findByUK(dto.getOidPais(), dto.getCadena());
      } catch (FinderException fe) {
         this.logearError("MONRegistroAbastecimiento.buscarProductoHDDetalle: FinderException", fe);
         String codigoError = ErroresDeNegocio.PRODUCTO_NO_EXISTE;
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(
                  ConstantesSEG.MODULO_BEL, "", codigoError));
      }         

      // (1) Si no se producen excepciones entonces 
      // Tomar el valor de "MaestroProductos.oid" y crear un objeto DTOOID para la siguiente llamada                
      DTOOID dtoOID = new DTOOID();
      dtoOID.setOid(maeProdLocal.getOid());
      // asigno el pais y el idioma
      dtoOID.setOidPais(dto.getOidPais());
      dtoOID.setOidIdioma(dto.getOidIdioma());
      
      // Llamar al método "MONProductos.consultar(dto : DTOOID) : DTOProducto" 
      // respuesta = DTOProducto obtenido de la llamada anterior 
      try {
         respuesta = getMONProductos().consultar(dtoOID);
         // (1) Fin Si 
      } catch (RemoteException e) {
         ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         this.logearError("MONRegistroAbastecimiento.buscarProductoHDDetalle: RemoteException", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }
            
      UtilidadesLog.info("MONRegistroAbastecimientoBean.buscarProductoHDDetalle(DTOString dto):Salida");
      
      return respuesta;
   }
   
   public void guardarHDDetalle(DTORegistroAbastecimientoDetalle dto)
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.guardarHDDetalle(DTORegistroAbastecimientoDetalle dto):Entrada");
      UtilidadesLog.debug("****DTOEntrada: "+dto);
      
      // se validan los accesos
      /*validaAccesos(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio)*/
      validaAccesos(dto.getOidPais(), null, null, null, null, null, null, null, null, null, null); 
      
      // (1) Si (dto.oid == null) entonces 
      if (dto.getOid() == null) {
         // -> Llamar al método "MONRegistroAbastecimiento.crearRegistroAbastecimientoDetalle(dto : DTORegistroAbastecimientoDetalle) : void" 
         this.crearRegistroAbastecimientoDetalle(dto);         
      } else { // (1) Si no entonces 
         try {
            // -> Llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoDetalle" tomando dto.oid 
            RegistroAbastecimientoDetalleLocal regAbastDetalLocal = getRegistroAbastecimientoDetalleLocalHome().findByPrimaryKey(dto.getOid());
            // -> RegistroAbastecimientoDetalle.unidadesAtendidas = dto.unidadesAtendidas 
            regAbastDetalLocal.setUnidadesAtendidas(dto.getUnidadesAtendidas()); 
            //Agregado por pzerbino para incidencia 21740
            regAbastDetalLocal.setTipoActuacion(dto.getOidTipoActuacion());
            
            this.getRegistroAbastecimientoDetalleLocalHome().merge(regAbastDetalLocal);
            
         } catch (NoResultException fe) {
            this.logearError("MONRegistroAbastecimiento.guardarHDDetalle: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }         
      } // (1) Fin Si

      UtilidadesLog.info("MONRegistroAbastecimientoBean.guardarHDDetalle(DTORegistroAbastecimientoDetalle dto):Salida");
   }
   
   public void guardarIngresoFisicoHD(DTORegistroAbastecimiento dto)
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.guardarIngresoFisicoHD(DTORegistroAbastecimiento dto):Entrada");
      // se validan los accesos
      /*validaAccesos(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio)*/
      validaAccesos(dto.getOidPais(), null, dto.getOidMarca(), dto.getOidCanal(), 
         dto.getOidAcceso(), dto.getOidSubacceso(), null, null, null, null, null); 
      
      try {
         // Tomar el valor de dto.oid 
         // Llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoCabecera" 
         RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().findByPrimaryKey(dto.getOid());
         // RegistroAbastecimientoCabecera.oidEstadoHojaDemanda = dto.oidEstadoHojaDemanda
         regAbastCabecLocal.setEstadoHojaDemanda(dto.getOidEstadoHojaDemanda());
         // RegistroAbastecimientoCabecera.fechaIngresado = dto.fechaIngresado 
         regAbastCabecLocal.setFechaIngresado(dto.getFechaIngresado());
         
         this.getRegistroAbastecimientoCabeceraLocalHome().merge(regAbastCabecLocal);
      
         // Crear objeto DTOOID con dto.oid y tomarlo como parámetro para las siguientes llamadas 
         DTOOID dtoOID = new DTOOID();
         dtoOID.setOid(dto.getOid());
         UtilidadesLog.debug("****Oid para pasar"+ dto.getOid());		                              
         // asigno el pais y el idioma
         dtoOID.setOidPais(dto.getOidPais());
         dtoOID.setOidIdioma(dto.getOidIdioma());
         
         // Llamar al método "MONRegistroAbastecimiento.generarMovimientoAlmacenCabeceraIFHD(dto : DTOOID) : void" 
         this.generarMovimientoAlmacenCabeceraIFHD(dtoOID);         
         // Llamar al método "MONRegistroAbastecimiento.generarDetalleMovimientoAlmacenIFHD(dto : DTOOID) : void" 
         this.generarDetalleMovimientoAlmacenIFHD(dtoOID);

        UtilidadesLog.debug("****Metodo  guardarIngresoFisicoHD: detalles: " + this.movimientoAlmacen.getDetalle());
         if (this.movimientoAlmacen.getDetalle() != null)
            UtilidadesLog.debug("****Metodo  guardarIngresoFisicoHD: detalles: " + this.movimientoAlmacen.getDetalle().size());		                              
         
         // Tomar el valor de la variable local de este MON "movimientoAlmacen" 
         // Llamar al método "MONGenerarMovimientoAlmacen.grabarMovimientoAlmacenYStock(dto : DTOMovimientoAlmacen) : DTOReportePedidos" 
         getMONGenerarMovimientoAlmacen().grabarMovimientoAlmacenYStock(this.movimientoAlmacen);
         
        // (1) Si (solicitudTipoActuacion3 <> null) entonces 
         if (this.solicitudTipoActuacion3 != null) {
            // Tomar solicitudTipoActuacion3 como parámetro para la siguiente llamada 
            // Llamar al método "IPEDGenerarSolicitudesExternas.generaSolicitud(DTOE : DTOCabeceraSolicitud) : DTOOID" 

            MONGenerarSolicitudModulosExternosHome home = (MONGenerarSolicitudModulosExternosHome) UtilidadesEJB.getHome("MONGenerarSolicitudModulosExternos",MONGenerarSolicitudModulosExternosHome.class);                  
            
            MONGenerarSolicitudModulosExternos solExter = null;
            try{
              solExter = home.create();
            } catch (Exception e) {
              this.logearError("*** Error enMONRegistroAbastecimiento.guardarIngresoFisicoHD", e);
  
              String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(codigoError));
            }
            solExter.generaSolicitud(this.solicitudTipoActuacion3);
         } // (1) Fin Si 
         // (2) Si (solicitudTipoActuacion4 <> null) entonces 
         if (this.solicitudTipoActuacion4 != null) {
            // Tomar solicitudTipoActuacion4 como parámetro para la siguiente llamada 
            // Llamar al método "IPEDGenerarSolicitudesExternas.generaSolicitud(DTOE : DTOCabeceraSolicitud) : DTOOID" 
            MONGenerarSolicitudModulosExternosHome home = (MONGenerarSolicitudModulosExternosHome) UtilidadesEJB.getHome("MONGenerarSolicitudModulosExternos",MONGenerarSolicitudModulosExternosHome.class);                  
            
            MONGenerarSolicitudModulosExternos solExter = null;
            try{
              solExter = home.create();
            } catch (Exception e) {
              this.logearError("*** Error enMONRegistroAbastecimiento.guardarIngresoFisicoHD", e);
  
              String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(codigoError));
            }
            solExter.generaSolicitud(this.solicitudTipoActuacion4);      
         }
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.guardarIngresoFisicoHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException e) {
         ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         this.logearError("MONRegistroAbastecimiento.guardarIngresoFisicoHD: RemoteException", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }
      
      UtilidadesLog.info("MONRegistroAbastecimientoBean.guardarIngresoFisicoHD(DTORegistroAbastecimiento dto):Salida");
   }
   
   private void generarMovimientoAlmacenCabeceraIFHD(DTOOID dto)
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientoAlmacenCabeceraIFHD(DTOOID dto):Entrada");
      
      // (1) Si la variable de este MON llamada "movimientoAlmacen" == null entonces 
      if (this.movimientoAlmacen == null) {
         // -> Asignar un nuevo DTOMovimientoAlmacen a "movimientoAlmacen" 
         this.movimientoAlmacen = new DTOMovimientoAlmacen();
         // -> Asignar un nuevo DTOMovimientoAlmacenCabecera a "movimientoAlmacen.cabecera" 
         this.movimientoAlmacen.setCabecera(new DTOMovimientoAlmacenCabecera());
      } // (1) Fin Si 
      
      try {
         // -> Tomar dto.oid y llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoCabecera" 
         RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().findByPrimaryKey(dto.getOid());
         // -> Tomar dto.pais y RegistroAbastecimientoCabecera.oidSubacceso para la siguiente llamada 
         // -> Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad "ParametrosBelcenter" 
         UtilidadesLog.debug("****subacceso pasado"+ regAbastCabecLocal.getSubacceso());
         UtilidadesLog.debug("****pais pasado"+ dto.getOidPais());

         // Se construye la cabecera del movimiento de almacén 
         // movimientoAlmacen.cabecera.numeroMovimiento = NULL 
         movimientoAlmacen.getCabecera().setNumeroMovimiento(null);
         // movimientoAlmacen.cabecera.numeroDocumento = NULL 
         movimientoAlmacen.getCabecera().setNumeroDocumento(null);
         // movimientoAlmacen.cabecera.oidTipoMovimientoAlmacen = NULL 
         movimientoAlmacen.getCabecera().setOidTipoMovimientoAlmacen(null);
         // movimientoAlmacen.cabecera.fecha = fecha del sistema 
         movimientoAlmacen.getCabecera().setFecha(new Date(System.currentTimeMillis()));
         // movimientoAlmacen.cabecera.oidAlmacenSalida = RegistroAbastecimientoCabecera.oidAlmacen 
         movimientoAlmacen.getCabecera().setOidAlmacenSalida(regAbastCabecLocal.getAlmacen());
         // movimientoAlmacen.cabecera.oidAlmacenEntrada = NULL 
         movimientoAlmacen.getCabecera().setOidAlmacenEntrada(null);
         // asigno el pais y el idioma
         movimientoAlmacen.setOidPais(dto.getOidPais());
         movimientoAlmacen.setOidIdioma(dto.getOidIdioma());
         movimientoAlmacen.getCabecera().setOidPais(dto.getOidPais());
         movimientoAlmacen.getCabecera().setOidIdioma(dto.getOidIdioma());

         // Tomar el valor RegistroAbastecimientoCabecera.oidPeriodo y llamar al método "findByPrimaryKey()" de la entidad "Periodo" 
         PeriodoLocal periodoLocal = getPeriodoLocalHome().findByPrimaryKey(regAbastCabecLocal.getPeriodo());
         // movimientoAlmacen.cabecera.oidMarca = Periodo.oidMarca 
         movimientoAlmacen.getCabecera().setOidMarca(periodoLocal.getOidMarca());
         // movimientoAlmacen.cabecera.oidCanal = Periodo.oidCanal 
         movimientoAlmacen.getCabecera().setOidCanal(periodoLocal.getOidCanal());
   
         // Tomar el valor RegistroAbastecimientoCabecera.oidSubacceso y llamar al método "findByPrimaryKey()" de la entidad "Subacceso" 
         // movimientoAlmacen.cabecera.oidAcceso = Subacceso.oidAcceso 
         movimientoAlmacen.getCabecera().setOidAcceso(getSubaccesoLocalHome().findByPrimaryKey(regAbastCabecLocal.getSubacceso()).getOidAcceso());
         // movimientoAlmacen.cabecera.oidSubacceso = RegistroAbastecimientoCabecera.oidSubacceso 
         movimientoAlmacen.getCabecera().setOidSubacceso(regAbastCabecLocal.getSubacceso());
         // movimientoAlmacen.cabecera.oidPeriodo = RegistroAbastecimientoCabecera.oidPeriodo 
         movimientoAlmacen.getCabecera().setOidPeriodo(regAbastCabecLocal.getPeriodo());
         // movimientoAlmacen.cabecera.observaciones = NULL 
         movimientoAlmacen.getCabecera().setObservaciones(null);
         // movimientoAlmacen.cabecera.indicadorNoGenerarCabecera = "false"             
         movimientoAlmacen.getCabecera().setIndicadorNoGenerarCabecera(Boolean.FALSE);

      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarMovimientoAlmacenCabeceraIFHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }      

      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientoAlmacenCabeceraIFHD(DTOOID dto):Salida");
   }
   
   private void generarDetalleMovimientoAlmacenIFHD(DTOOID dto)
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarDetalleMovimientoAlmacenIFHD(DTOOID dto):Entrada");
      
      // Llamar al método "DAORegistroAbastecimiento.obtenerDetalleHojaDemanda(dto : DTOOID) : DTOSalida" 
      String usuario = ctx.getCallerPrincipal().getName();
      DAORegistroAbastecimiento daoRA = new DAORegistroAbastecimiento(usuario);
      RecordSet rs = daoRA.obtenerDetalleHojaDemanda(dto).getResultado();
 
      // Crear variable llamada "raDetalle" de tipo DTORegistroAbastecimientoDetalle inicializada a null 
      DTORegistroAbastecimientoDetalle raDetalle = null;

      // (1) Para cada Registro hacer: 
      for (int i=0; i < rs.getRowCount(); i++) {
         // raDetalle = nuevo DTORegistroAbastecimientoDetalle mapeando todos los campos del registro en él y tomándolo como parámetro para la llamada siguiente 
         raDetalle = new DTORegistroAbastecimientoDetalle();

         raDetalle.setCodigoSAP(null);
         raDetalle.setDescripcionCorta(null);
         raDetalle.setNumeroLinea(new Integer(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("NUM_LINE"))).intValue()));
         raDetalle.setOid(new Long(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("OID_REGI_ABAS_DETA"))).longValue()));
         raDetalle.setOidProducto(new Long(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("PROD_OID_PROD"))).longValue()));
         raDetalle.setOidRegistroAbastecimientoCabecera(new Long(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("RABC_OID_REGI_ABAS_CABE"))).longValue()));
         raDetalle.setOidTipoActuacion((rs.getValueAt(i, rs.getColumnPosition("DEAT_OID_ESTA_ACTU")) != null) ? (new Long(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("DEAT_OID_ESTA_ACTU"))).longValue())) : null);         
         raDetalle.setStockMaximo((rs.getValueAt(i, rs.getColumnPosition("NUM_STOC_MAXI")) != null) ? (new Long(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("NUM_STOC_MAXI"))).longValue())) : null);
         raDetalle.setStockMinimo((rs.getValueAt(i, rs.getColumnPosition("NUM_STOC_MINI")) != null) ? (new Long(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("NUM_STOC_MINI"))).longValue())) : null);
         raDetalle.setUnidadesAtendidas((rs.getValueAt(i, rs.getColumnPosition("NUM_UNID_ATEN")) != null) ? (new Long(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("NUM_UNID_ATEN"))).longValue())) : null);         
         raDetalle.setUnidadesConfirmadas((rs.getValueAt(i, rs.getColumnPosition("NUM_UNID_CONF")) != null) ? (new Long(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("NUM_UNID_CONF"))).longValue())) : null);
         raDetalle.setUnidadesEnviadas((rs.getValueAt(i, rs.getColumnPosition("NUM_UNID_ENVI")) != null) ? (new Long(((BigDecimal)rs.getValueAt(i, rs.getColumnPosition("NUM_UNID_ENVI"))).longValue())) : null);
         // asigno el pais y el idioma
         raDetalle.setOidPais(dto.getOidPais());
         raDetalle.setOidIdioma(dto.getOidIdioma());
         
         // Llamar al método "MONRegistroAbastecimiento.gnerarMovimientoAlmacenDetalle(dto : DTORegistroAbastecimientoDetalle) : void" 
         this.generarMovimientoAlmacenDetalle(raDetalle);
      } // (1) Fin Para
      
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarDetalleMovimientoAlmacenIFHD(DTOOID dto):Salida");
   }
   
   // cambia el diseño de este metodo por incidencia BELC300012639
   private void generarMovimientosAlmacen(DTORegistroAbastecimiento dto)
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientosAlmacen(DTORegistroAbastecimiento dto):Entrada");
      
      // Tomar dto.oid y crear un DTOOID con él, depués usarlo como parámetro en la siguiente llamada 
      DTOOID dtoOID = new DTOOID();
      dtoOID.setOid(dto.getOid());
      dtoOID.setOidPais(dto.getOidPais());
      dtoOID.setOidIdioma(dto.getOidIdioma());
 
      // Llamar al método "MONRegistroAbastecimiento.generarMovimientoAlmacenCabeceraIFHD(dto : DTOOID) : void" 
      this.generarMovimientoAlmacenCabeceraIFHD(dtoOID);      
      
      // Llamar al método "DAORegistroAbastecimiento.obtenerDetalleHojaDemanda(dto : DTOOID) : DTOSalida"
      // Crear variable llamada "detalleHojaDemanda" de tipo RecordSet y asignar el RecordSet 
      // contenido por el DTOSalida obtenido en la línea anterior      
      String usuario = ctx.getCallerPrincipal().getName();
      RecordSet detalleHojaDemanda = (new DAORegistroAbastecimiento(usuario).obtenerDetalleHojaDemanda(dtoOID)).getResultado();
 
      RegistroAbastecimientoDetalleLocal regAbastDetLocal = null;
      DTORegistroAbastecimientoDetalle registroAbastecimientoDetalle = null;
      Long oidDetalleBuscado = null;
      RegistroAbastecimientoDetalleLocalHome regAbastDetLocalHome = getRegistroAbastecimientoDetalleLocalHome();    
 
      // (1)Para cada registro de "detalleHojaDemanda" hacer
      for (int i=0; i < detalleHojaDemanda.getRowCount(); i++) {
         
         // Hacer "findByPrimaryKey()" sobre la entidad RegistroAbastecimientoDetalle tomando
         // detalleHojaDemanda[i].get("OID_REGI_ABAS_DETA")
         try {
            oidDetalleBuscado = new Long(((BigDecimal)detalleHojaDemanda.getValueAt(i, "OID_REGI_ABAS_DETA")).longValue());
            UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.generarMovimientosAlmacen: oid del detalle que buscamos: " + oidDetalleBuscado);		                                                     
            regAbastDetLocal = regAbastDetLocalHome.findByPrimaryKey(oidDetalleBuscado);
         } catch (NoResultException fe) {
            this.logearError("MONRegistroAbastecimiento.generarMovimientosAlmacen: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }       
         
         // Crear variable llamada "registroAbastecimientoDetalle" de tipo 
         // DTORegistroAbastecimientoDetalle  y setear en él todos los atributos del 
         // entity RegistroAbastecimientoDetalle
         // Los atributos que no tengan correspondencia dejarlos a NULL
         registroAbastecimientoDetalle = new DTORegistroAbastecimientoDetalle();
         registroAbastecimientoDetalle.setOid(regAbastDetLocal.getOid());   
         registroAbastecimientoDetalle.setNumeroLinea(regAbastDetLocal.getNumeroLinea());   
         registroAbastecimientoDetalle.setStockMinimo(regAbastDetLocal.getStockMinimo());     
         registroAbastecimientoDetalle.setStockMaximo(regAbastDetLocal.getStockMaximo());   
         registroAbastecimientoDetalle.setUnidadesEnviadas(regAbastDetLocal.getUnidadesEnviadas());   
         registroAbastecimientoDetalle.setUnidadesConfirmadas(regAbastDetLocal.getUnidadesConfirmadas());   
         registroAbastecimientoDetalle.setUnidadesAtendidas(regAbastDetLocal.getUnidadesAtendidas());   
         registroAbastecimientoDetalle.setOidRegistroAbastecimientoCabecera(regAbastDetLocal.getRegistroAbastecimientoCabecera());   
         registroAbastecimientoDetalle.setOidProducto(regAbastDetLocal.getProducto());   
         registroAbastecimientoDetalle.setCodigoSAP(null);   
         registroAbastecimientoDetalle.setDescripcionCorta(null);   
         registroAbastecimientoDetalle.setOidTipoActuacion(regAbastDetLocal.getTipoActuacion()); 
         registroAbastecimientoDetalle.setOidPais(dto.getOidPais());
         registroAbastecimientoDetalle.setOidIdioma(dto.getOidIdioma());
         
         UtilidadesLog.debug("****registroAbastecimientoDetalle creado: " + registroAbastecimientoDetalle);		                                                     
            
         // Tomar "registroAbastecimientoDetalle" como parámetro para la siguiente llamada
         // Llamar al método "MONRegistroAbastecimiento.generarDetalleMovimientoAlmacen(dto :
         // DTORegistroAbastecimientoDetalle) : void"      
         this.generarDetalleMovimientoAlmacen(registroAbastecimientoDetalle);
      } // (1)Fin Para 
      
      try {
         // Tomar el valor de la variable local de este MON "movimientoAlmacen"
         // Llamar al método "MONGenerarMovimientoAlmacen.grabarMovimientoAlmacenYStock(dto :
         // DTOMovimientoAlmacen) : DTOReportePedidos"
         getMONGenerarMovimientoAlmacen().grabarMovimientoAlmacenYStock(this.movimientoAlmacen);
      } catch (RemoteException e) {
         ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         this.logearError("MONRegistroAbastecimiento.generarMovimientosAlmacen: RemoteException", e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }
      
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientosAlmacen(DTORegistroAbastecimiento dto):Salida");
   }
   
   
   private void generarDetalleMovimientoAlmacen(DTORegistroAbastecimientoDetalle dto)
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarDetalleMovimientoAlmacen(DTORegistroAbastecimientoDetalle dto):Entrada");
      ArrayList detalles = new ArrayList(); // se asigna al ArrayList movimientoAlmacen.detalle
      
      try {
      
         // incidencia BELC300012133
         // obtengo el subacceso a partir de RegistroAbastecimientoCabecera
         // Tomar dto.oidRegistroAbastecimientoCabecera y llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoCabecera" 
         UtilidadesLog.debug("***** OidRegistroAbastecimientoCabecera = " + dto.getOidRegistroAbastecimientoCabecera());		                                                     
         RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().findByPrimaryKey(dto.getOidRegistroAbastecimientoCabecera());
      
         // Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad ParametrosBelcenter 
         UtilidadesLog.debug("***** pais = " + dto.getOidPais() + "    subacceso = " + regAbastCabecLocal.getSubacceso());		                                            
         ParametrosBelcenterLocal paramBelCentLocal = getParametrosBelcenterLocalHome().findByUK(dto.getOidPais(), regAbastCabecLocal.getSubacceso());   
         
         // Llamar al método "MONGenerarRegistroAbastecimiento.generarDetalleMovimientoAlmacen1(dto : DTORegistroAbastecimiento) : DTOMovimientoAlmacenDetalle" 
         // Asignar respuesta al arrayList "movimientoAlmacen.detalle" 
         detalles.add(this.generarDetalleMovimientoAlmacen1(dto));
         this.movimientoAlmacen.setDetalle(detalles);
         
         // (1)Si ((dto.unidadesEnviadas <> dto.unidadesConfirmadas)|| 
         // ((ParametrosBelcenter.oidTipoMovimientoDevolverStocks <> null)&& 
         // (ParametrosBelcenter.oidTipoMovimientoConfirmarStockEnTransito <> null))) entonces 
         if(dto.getUnidadesEnviadas() == null){
           dto.setUnidadesEnviadas(new Long(0));
         }
         if ( (dto.getUnidadesEnviadas().longValue() != dto.getUnidadesConfirmadas().longValue())
               || ( (paramBelCentLocal.getMovimientoDevolverStockExistencias() != null) 
                     && (paramBelCentLocal.getMovimientoConfirmarStockEnTransito() != null)) ) 
         {
            // Llamar al método "MONGenerarRegistroAbastecimiento.generarDetalleMovimientoAlmacen2(dto : DTORegistroAbastecimiento) : DTOMovimientoAlmacenDetalle" 
            // Asignar respuesta al arrayList "movimientoAlmacen.detalle" 
            detalles.add(this.generarDetalleMovimientoAlmacen2(dto));
            this.movimientoAlmacen.setDetalle(detalles);
         } // (1)Fin Si 
         
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarDetalleMovimientoAlmacen: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarDetalleMovimientoAlmacen(DTORegistroAbastecimientoDetalle dto):Salida");
   }
   
   private DTOMovimientoAlmacenDetalle generarDetalleMovimientoAlmacen1(DTORegistroAbastecimientoDetalle dto)
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarDetalleMovimientoAlmacen1(DTORegistroAbastecimientoDetalle dto):Entrada");
      
      DTOMovimientoAlmacenDetalle detalle1 = null;

      try {
         
         // Crear variable llamada "detalle1" de tipo DTOMovimientoAlmacenDetalle 
         detalle1 = new DTOMovimientoAlmacenDetalle();
         // Tomar dto.oidRegistroAbastecimientoCabecera y llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoCabecera" 
         RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().findByPrimaryKey(dto.getOidRegistroAbastecimientoCabecera());
      
         // Tomar dto.pais y RegistroAbastecimientoCabecera.oidSubacceso para la siguiente llamada 
         // Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad "ParametrosBelcenter" 
         ParametrosBelcenterLocal paramBelCentLocal = getParametrosBelcenterLocalHome().findByUK(dto.getOidPais(), regAbastCabecLocal.getSubacceso());
 
         // detalle1.oidTipoMovimiento = ParametrosBelcenter.oidTipoMovimientoDeStockEnTransito 
         detalle1.setOidTipoMovimientoAlmacen(paramBelCentLocal.getMovimientoConfirmarStockEnTransito());
         // detalle1.oidAlmacenSalida = movimientoAlmacen.cabecera.oidAlmacenSalida 
         detalle1.setOidAlmacenSalida(movimientoAlmacen.getCabecera().getOidAlmacenSalida());
         // detalle1.oidAlmacenEntrada = movimientoAlmacen.cabecera.oidAlmacenEntrada 
         detalle1.setOidAlmacenEntrada(movimientoAlmacen.getCabecera().getOidAlmacenEntrada());
         // detalle1.oidProducto = dto.oidProducto 
         detalle1.setOidProducto(dto.getOidProducto());
         
         // (1) Si ((dto.unidadesEnviadas <> dto.unidadesConfirmadas)|| 
            // ((ParametrosBelcenter.oidTipoMovimientoDevolverStocks <> null)&& 
            // (ParametrosBelcenter.oidTipoMovimientoConfirmarStockEnTransito <> null))) entonces 
         //Modificado por incidencia 13194
         if(dto.getUnidadesEnviadas() != null){
            if ( (dto.getUnidadesEnviadas().compareTo(dto.getUnidadesConfirmadas()) != 0)  
               || ( (paramBelCentLocal.getMovimientoDevolverStockExistencias() != null)
                     && (paramBelCentLocal.getMovimientoConfirmarStockEnTransito() != null) ) ) 
            {
            // detalle1.cantidad = dto.unidadesEnviadas 
                detalle1.setCantidad(dto.getUnidadesEnviadas());
            } else { 
            // detalle1.cantidad = dto.unidadesConfirmadas 
                detalle1.setCantidad(dto.getUnidadesConfirmadas());
            } 
         }else{
              detalle1.setCantidad(new Long(0));
         }
         
         // detalle1.precioVentaNeto = NULL 
         // detalle1.precioVentaContable = NULL 
         // detalle1.observaciones = NULL 
         // detalle1.numeroPosicionReferencia = dto.numeroLinea 
         detalle1.setNumeroPosicionReferencia(dto.getNumeroLinea());
         // detalle1.numeroDocumentoReferencia = RegistroAbastecimientoCabecera.nSolicitud 
         detalle1.setNumeroDocumentoReferencia(regAbastCabecLocal.getNSolicitud());
         // detalle1.operacion = "BEL003" 
         detalle1.setOperacion("BEL003");
         // detalle1.oidTipoOferta = NULL 
         // pais e idioma
         detalle1.setOidPais(dto.getOidPais());
         detalle1.setOidIdioma(dto.getOidIdioma());
         
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarMovimientoAlmacenCabeceraIFHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }            
      
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarDetalleMovimientoAlmacen1(DTORegistroAbastecimientoDetalle dto):Salida");
 
      // Devolver "detalle1"     
      return detalle1;
   }
   
   public void generarEntradaSAP(DTORegistroInterface dto) throws MareException {
    
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarEntradaSAP(DTORegistroInterface dto):Entrada");
        //-> Llamar al método "DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoCabecera
        //(dto : DTORegistroInterface) : Long" pasando el dto de entrada
        String usuario = ctx.getCallerPrincipal().getName();
        DAORegistroAbastecimiento daoRegistroAbastecimiento = new DAORegistroAbastecimiento(usuario);
        Long registroAbastecimientoCabecera = daoRegistroAbastecimiento.obtenerOIDRegistroAbastecimientoCabecera(
        dto);
        
        //Llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoCabecera" 
        //tomando el oid recuperado de la llamada anterior
        RegistroAbastecimientoCabeceraLocalHome registroAbastecimientoCabeceraLocalHome = null;
        RegistroAbastecimientoCabeceraLocal registroAbastecimientoCabeceraLocal = null;
        
        registroAbastecimientoCabeceraLocalHome = this.getRegistroAbastecimientoCabeceraLocalHome();
        try{
            registroAbastecimientoCabeceraLocal = registroAbastecimientoCabeceraLocalHome.findByPrimaryKey(
            registroAbastecimientoCabecera);
        }catch(NoResultException fe){
            
            this.logearError("MONRegistroAbastecimiento.generarEntradaSAP: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //RegistroAbastecimientoCabecera.fechaRecepcionInterface = dto.fechaRecepcionInterface 
        //RegistroAbastecimientoCabecera.indicadorSAP = "true" 
        registroAbastecimientoCabeceraLocal.setFechaRecepcionInterface(dto.getFechaRecepcionInteface());
        registroAbastecimientoCabeceraLocal.setIndicadorSAP(new Boolean(true));
        
        this.getRegistroAbastecimientoCabeceraLocalHome().merge(registroAbastecimientoCabeceraLocal);
        
        //Tomar el dto de entrada y RegistroAbastecimientoCabecera.oid 
        //como parámetros para la siguiente llamada 
        //Llamar al método "DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoDetalle
        //(dto : DTORegistroInterface, oidRegistroAbastecimientoCabecera : Long) : Long" 
        Long registroAbastecimientoDetalle = daoRegistroAbastecimiento.obtenerOIDRegistroAbastecimientoDetalle(
        dto, registroAbastecimientoCabeceraLocal.getOid());
        
        //Llamar al método "findByPrimaryKey()" de la entidad 
        //"RegistroAbastecimientoDetalle" tomando el oid recuperado de la llamada anterior 
        
        RegistroAbastecimientoDetalleLocalHome registroAbastecimientoDetalleLocalHome = null;
        RegistroAbastecimientoDetalleLocal registroAbastecimientoDetalleLocal = null;
        
        registroAbastecimientoDetalleLocalHome = this.getRegistroAbastecimientoDetalleLocalHome();
        try{
            registroAbastecimientoDetalleLocal = registroAbastecimientoDetalleLocalHome.findByPrimaryKey(
            registroAbastecimientoDetalle);
        }catch(NoResultException fe){
            
            this.logearError("MONRegistroAbastecimiento.generarEntradaSAP: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //RegistroAbastecimientoDetalle.unidadesConfirmadas = dto.unidadesConfirmadas
        registroAbastecimientoDetalleLocal.setUnidadesConfirmadas(
        new Long((dto.getUnidadesConfirmadas()).toString()));
        
        registroAbastecimientoDetalleLocalHome.merge(registroAbastecimientoDetalleLocal);
        
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarEntradaSAP(DTORegistroInterface dto):Salida");
    }
    
    private DTOMovimientoAlmacenDetalle generarMovimientoAlmacenDetalle2(DTORegistroAbastecimientoDetalle dto) throws MareException  {
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientoAlmacenDetalle2(DTORegistroAbastecimientoDetalle dto):Entrada");
        //Crear variable llamada "detalle2" de tipo DTOMovimientoAlmacenDetalle 
        //-> Tomar dto.oidRegistroAbastecimientoCabecera y llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoCabecera" 
        DTOMovimientoAlmacenDetalle detalle2 = new DTOMovimientoAlmacenDetalle();
        
        RegistroAbastecimientoCabeceraLocalHome registroAbastecimientoCabeceraLocalHome = null;
        RegistroAbastecimientoCabeceraLocal registroAbastecimientoCabeceraLocal = null;
        
        registroAbastecimientoCabeceraLocalHome = this.getRegistroAbastecimientoCabeceraLocalHome();
        try{
            registroAbastecimientoCabeceraLocal = registroAbastecimientoCabeceraLocalHome.findByPrimaryKey(
            dto.getOidRegistroAbastecimientoCabecera());
        }catch(NoResultException fe){
            
            this.logearError("MONRegistroAbastecimiento.generarMovimientoAlmacenDetalle2: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //Tomar dto.pais y RegistroAbastecimientoCabecera.oidSubacceso para la siguiente llamada 
        //-> Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad "ParametrosBelcenter" 
        ParametrosBelcenterLocalHome parametrosBelcenterLocalHome = null;
        ParametrosBelcenterLocal parametrosBelcenterLocal = null;
        
        parametrosBelcenterLocalHome = this.getParametrosBelcenterLocalHome();
        try{
            parametrosBelcenterLocal = parametrosBelcenterLocalHome.findByUK(dto.getOidPais(),
            registroAbastecimientoCabeceraLocal.getSubacceso());
        }catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarMovimientoAlmacenDetalle2: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //Si (dto.oidTipoActuacion == 2) entonces 
        //-> detalle2.oidTipoMovimiento = ParametrosBelcenter.oidTipoMovimientoStockDevolucion 
        //-> detalle2.cantidad = dto.unidadesConfirmadas - dto.unidadesAtendidas 
        if(dto.getOidTipoActuacion().longValue() == 2){
            
            detalle2.setOidTipoMovimientoAlmacen(parametrosBelcenterLocal.getMovimientoStockDevolucion());
            detalle2.setCantidad(new Long(dto.getUnidadesConfirmadas().longValue()
            -dto.getUnidadesAtendidas().longValue()));
        }
        else{
            //Si no Si ((dto.oidTipoActuacion == 3) || (dto.oidTipoActuacion == 4)) entonces 
            //-> detalle2.oidTipoMovimiento = ParametrosBelcenter.oidTipoMovimientoRegularizacion 
            //-> detalle2.cantidad = ABS(dto.unidadesAtendidas - dto.unidadesConfirmadas)
            if(dto.getOidTipoActuacion().longValue() == 3 || 
            dto.getOidTipoActuacion().longValue() == 4){
                
                detalle2.setOidTipoMovimientoAlmacen(parametrosBelcenterLocal.getMovimientoRegularizacion());
                detalle2.setCantidad(new Long(Math.abs(dto.getUnidadesAtendidas().longValue()
                -dto.getUnidadesConfirmadas().longValue())));
            }
        }
       
        detalle2.setOidAlmacenSalida(this.movimientoAlmacen.getCabecera().getOidAlmacenSalida());
        detalle2.setOidAlmacenEntrada(this.movimientoAlmacen.getCabecera().getOidAlmacenEntrada());
        
        detalle2.setOidProducto(dto.getOidProducto());
        detalle2.setPrecioVentaNeto(null);
        detalle2.setPrecioContable(null);
        detalle2.setObservaciones(null);
        detalle2.setNumeroPosicionReferencia(dto.getNumeroLinea());
        detalle2.setNumeroDocumentoReferencia(registroAbastecimientoCabeceraLocal.getNSolicitud());
        detalle2.setOperacion("BEL004");
        detalle2.setOidTipoOferta(null);
        detalle2.setOidPais(dto.getOidPais());
        detalle2.setOidIdioma(dto.getOidIdioma());
        
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientoAlmacenDetalle2(DTORegistroAbastecimientoDetalle dto):Salida");
        return detalle2;
    }
    
   private DTOMovimientoAlmacenDetalle generarDetalleMovimientoAlmacen2(DTORegistroAbastecimientoDetalle dto)
      throws MareException
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarDetalleMovimientoAlmacen2(DTORegistroAbastecimientoDetalle dto):Entrada");

      // Crear variable llamada "detalle2" de tipo DTOMovimientoAlmacenDetalle 
      DTOMovimientoAlmacenDetalle detalle2 = new DTOMovimientoAlmacenDetalle();
      
      try {
         // Tomar dto.oidRegistroAbastecimientoCabecera y llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoCabecera" 
         RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().findByPrimaryKey(dto.getOidRegistroAbastecimientoCabecera());
         
         // Tomar dto.pais y RegistroAbastecimientoCabecera.oidSubacceso para la siguiente llamada 
         // Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad "ParametrosBelcenter" 
         // detalle2.oidTipoMovimiento = ParametrosBelcenter.oidTipoMovimientoConfirmarStockEnTransito 
         detalle2.setOidTipoMovimientoAlmacen(getParametrosBelcenterLocalHome().findByUK(dto.getOidPais(), regAbastCabecLocal.getSubacceso()).getMovimientoConfirmarStockEnTransito());
         // detalle2.cantidad = dto.unidadesConfirmadas 
         detalle2.setCantidad(dto.getUnidadesConfirmadas());
         // detalle2.oidAlmacenSalida = movimientoAlmacen.cabecera.oidAlmacenSalida 
         detalle2.setOidAlmacenSalida(movimientoAlmacen.getCabecera().getOidAlmacenSalida());
         // detalle2.oidAlmacenEntrada = movimientoAlmacen.cabecrea.oidAlmacenEntrada 
         detalle2.setOidAlmacenEntrada(movimientoAlmacen.getCabecera().getOidAlmacenEntrada());
         // detalle2.oidProducto = dto.oidProducto 
         detalle2.setOidProducto(dto.getOidProducto());
         // detalle2.precioVentaNeto = NULL 
         // detalle2.precioVentaContable = NULL 
         // detalle2.observaciones = NULL 
         // detalle2.numeroPosicionReferencia = dto.numeroLinea 
         detalle2.setNumeroPosicionReferencia(dto.getNumeroLinea());
         // detalle2.numeroDocumentoReferencia = RegistroAbastecimientoCabecera.nSolicitud 
         detalle2.setNumeroDocumentoReferencia(regAbastCabecLocal.getNSolicitud());
         // detalle2.operacion = "BEL003" 
         detalle2.setOperacion("BEL003");
         // detalle2.oidTipoOferta = NULL 
         // pais e idioma
         detalle2.setOidPais(dto.getOidPais());
         detalle2.setOidIdioma(dto.getOidIdioma());


      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarMovimientoAlmacenCabeceraIFHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }            

      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarDetalleMovimientoAlmacen2(DTORegistroAbastecimientoDetalle dto):Salida");
      
      // Devolver "detalle2" 
      return detalle2;
   }

    private DTOMovimientoAlmacenDetalle generarMovimientoAlmacenDetalle1(DTORegistroAbastecimientoDetalle dto) throws MareException {
        
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientoAlmacenDetalle1(DTORegistroAbastecimientoDetalle dto):Entrada");
        //-> Crear variable llamada "detalle1" de tipo DTOMovimientoAlmacenDetalle 
        //-> Tomar dto.oidRegistroAbastecimientoCabecera y llamar al método "findByPrimaryKey()" de la entidad "RegistroAbastecimientoCabecera"
        DTOMovimientoAlmacenDetalle detalle1 = new DTOMovimientoAlmacenDetalle();
        
        RegistroAbastecimientoCabeceraLocalHome registroAbastecimientoCabeceraLocalHome = null;
        RegistroAbastecimientoCabeceraLocal registroAbastecimientoCabeceraLocal = null;
        
        registroAbastecimientoCabeceraLocalHome = this.getRegistroAbastecimientoCabeceraLocalHome();
        try{
            registroAbastecimientoCabeceraLocal = registroAbastecimientoCabeceraLocalHome.findByPrimaryKey(
            dto.getOidRegistroAbastecimientoCabecera());
        }catch(NoResultException fe){
            
            this.logearError("MONRegistroAbastecimiento.generarMovimientoAlmacenDetalle1: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //-> Tomar dto.pais y RegistroAbastecimientoCabecera.oidSubacceso para la siguiente llamada 
        //-> Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad "ParametrosBelcenter" 
        ParametrosBelcenterLocalHome parametrosBelcenterLocalHome = null;
        ParametrosBelcenterLocal parametrosBelcenterLocal = null;
        
        parametrosBelcenterLocalHome = this.getParametrosBelcenterLocalHome();
        try{
            parametrosBelcenterLocal = parametrosBelcenterLocalHome.findByUK(dto.getOidPais(),
            registroAbastecimientoCabeceraLocal.getSubacceso());
        }catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarMovimientoAlmacenDetalle1: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        detalle1.setOidTipoMovimientoAlmacen(parametrosBelcenterLocal.getMovimientoConfirmarStock());
        detalle1.setOidAlmacenSalida(this.movimientoAlmacen.getCabecera().getOidAlmacenSalida());
        detalle1.setOidAlmacenEntrada(this.movimientoAlmacen.getCabecera().getOidAlmacenEntrada());
        detalle1.setOidProducto(dto.getOidProducto());
        if(dto.getOidTipoActuacion()!=null){
          if(dto.getOidTipoActuacion().longValue() == 1){
             
             detalle1.setCantidad(dto.getUnidadesAtendidas()); 
          }else{
              
             detalle1.setCantidad(dto.getUnidadesConfirmadas());
          }
        }
        detalle1.setPrecioVentaNeto(null);
        detalle1.setPrecioContable(null);
        detalle1.setObservaciones(null);
        detalle1.setNumeroPosicionReferencia(dto.getNumeroLinea());
        detalle1.setNumeroDocumentoReferencia(registroAbastecimientoCabeceraLocal.getNSolicitud());
        detalle1.setOperacion("BEL004");
        detalle1.setOidTipoOferta(null);
        detalle1.setOidIdioma(dto.getOidIdioma());
        detalle1.setOidPais(dto.getOidPais());
        
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientoAlmacenDetalle1(DTORegistroAbastecimientoDetalle dto):Salida");
        return detalle1;
    }

    private DTOCabeceraSolicitud generarCabeceraSolicitud(DTORegistroAbastecimientoDetalle dto) throws MareException {
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarCabeceraSolicitud(DTORegistroAbastecimientoDetalle dto):Entrada");
        //Crear variable llamada "cabeceraSolicitud" de tipo DTOCabeceraSolicitud
        //-> Tomar dto.oidRegistroAbastecimientoCabecera y hacer "findByPrimaryKey()" sobre la entidad "RegistroAbastecimientoCabecera"
        DTOCabeceraSolicitud cabeceraSolicitud = new DTOCabeceraSolicitud();
        
        RegistroAbastecimientoCabeceraLocalHome registroAbastecimientoCabeceraLocalHome = null;
        RegistroAbastecimientoCabeceraLocal registroAbastecimientoCabeceraLocal = null;
        
        registroAbastecimientoCabeceraLocalHome = this.getRegistroAbastecimientoCabeceraLocalHome();
        try{
            registroAbastecimientoCabeceraLocal = registroAbastecimientoCabeceraLocalHome.findByPrimaryKey(
            dto.getOidRegistroAbastecimientoCabecera());
        }catch(NoResultException fe){
            
            this.logearError("MONRegistroAbastecimiento.generarCabeceraSolicitud: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        //Tomar dto.pais y RegistroAbastecimientoCabecera.oidSubacceso como parámetros para la siguiente llamada
        //-> Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad ParametrosBelcenter
        ParametrosBelcenterLocalHome parametrosBelcenterLocalHome = null;
        ParametrosBelcenterLocal parametrosBelcenterLocal = null;
        
        parametrosBelcenterLocalHome = this.getParametrosBelcenterLocalHome();
        try{
            parametrosBelcenterLocal = parametrosBelcenterLocalHome.findByUK(dto.getOidPais(),
            registroAbastecimientoCabeceraLocal.getSubacceso());
        }catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarCabeceraSolicitud: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //Llamar al método "DAOServicioBEL.obtenerPrimerTipoCliente(oidCliente : Long) : Long" pasando ParametrosBelcenter.oidClienteDatosBasicos
        //-> Crear variable llamada "tipoClienteBelcenter" asignándole la respuesta de la llamada anterior
        
        String usuario = ctx.getCallerPrincipal().getName();
        DAOServicioBel daoServicioBel = new DAOServicioBel(usuario);
        Long tipoClienteBelcenter = daoServicioBel.obtenerPrimerTipoCliente(parametrosBelcenterLocal.getCliente());
        
        //Crear variable llamada "tipoSolicitudOperacion" de tipo DTOTipoSolicitudOperacion haciendo el siguiente mapeo:
        //-> tipoSolicitudOperacion.pais = dto.pais
        DTOTipoSolicitudOperacion tipoSolicitudOperacion = new DTOTipoSolicitudOperacion();
        tipoSolicitudOperacion.setOidPais(dto.getOidPais());
         //Es necesario pasarle tambien el idioma para que no falle la consulta
        tipoSolicitudOperacion.setOidIdioma(dto.getOidIdioma());
        
        //Tomar RegistroAbastecimientoCabecera.oidPeriodo y hacer "findByPrimaryKey()" sobre la entidad Periodo
        PeriodoLocalHome periodoLocalHome = null;
        PeriodoLocal periodoLocal = null;
        
        periodoLocalHome = this.getPeriodoLocalHome();
        try{
            periodoLocal = periodoLocalHome.findByPrimaryKey(registroAbastecimientoCabeceraLocal.getPeriodo());
        }catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarCabeceraSolicitud: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        //tipoSolicitudOperacion.oidMarca = Periodo.oidMarca
        //-> tipoSolicitudOperacion.oidCanal = Periodo.oidCanal
        //-> tipoSolicitudOperacion.oidOperacion = ConstantesBEL.BEL004
        //-> tipoSolicitudOperacion.oitTipoCliente = tipoClienteBelcenter
        tipoSolicitudOperacion.setOidMarca(periodoLocal.getOidMarca());
        tipoSolicitudOperacion .setOidCanal(periodoLocal.getOidCanal());
        tipoSolicitudOperacion.setOidOperacion(ConstantesBEL.BEL004);
        tipoSolicitudOperacion.setOidTipoCliente(tipoClienteBelcenter);
        
        //Tomar "tipoSolicitudOperacion" como parámetro para la siguiente llamada
        //-> Llamar al método "IPEDTiposSolicitud.obtieneTipoSolicitudOperacion(dto : DTOTipoSolicitudOperacion) : DTOSalida"
        MONTiposSolicitudPais monTipoSolicitudPais = null;
        DTOSalida dtoSalida = null;
        monTipoSolicitudPais = this.getMONTiposSolicitudPais();
        try{
            dtoSalida = monTipoSolicitudPais.obtieneTipoSolicitudOperacion(tipoSolicitudOperacion);
        }catch (RemoteException rExc) {
            UtilidadesLog.error(rExc);
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo MONRegistroAbastecimiento.generarCabeceraSolicitud: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //-> Recuperar RecordSet del DTOSalida obtenido y tomar del primer registro el valor del campo "TSPA_OID_TIPO_SOLI_PAIS"
        //-> Crear variable llamada "tipoSolicitudPais" y asignarle el valor obtenido en la línea anterior
        Long tipoSolicitudPais =new Long(((BigDecimal) dtoSalida.getResultado().getValueAt(0, "OID")).longValue());
        
        cabeceraSolicitud.setTipoSolicitud(tipoSolicitudPais);
        cabeceraSolicitud.setOidCliente(parametrosBelcenterLocal.getCliente());
        cabeceraSolicitud.setOidPais(dto.getOidPais());
        cabeceraSolicitud.setOidIdioma(dto.getOidIdioma());
        cabeceraSolicitud.setMarca(periodoLocal.getOidMarca());
        cabeceraSolicitud.setCanal(periodoLocal.getOidCanal());
        cabeceraSolicitud.setOperacion(ConstantesBEL.BEL004);
        cabeceraSolicitud.setPeriodo(registroAbastecimientoCabeceraLocal.getPeriodo());
        //Tomar dto.oidSubacceso y hacer "findByPrimarykey()" sobre la entidad Subacceso
        SubaccesoLocalHome subaccesoLocalHome = null;
        SubaccesoLocal subaccesoLocal = null;
        subaccesoLocalHome= this.getSubaccesoLocalHome();
        try{
            
            subaccesoLocal = subaccesoLocalHome.findByPrimaryKey(registroAbastecimientoCabeceraLocal.getSubacceso());
        }catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarCabeceraSolicitud: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //incidencia 12132
        cabeceraSolicitud.setAcceso(subaccesoLocal.getOidAcceso());
        cabeceraSolicitud.setSubacceso(registroAbastecimientoCabeceraLocal.getSubacceso());
        cabeceraSolicitud.setFecha(new Date(System.currentTimeMillis()));
        cabeceraSolicitud.setModulo(new Long(ConstantesSEG.MODULO_BEL));
        cabeceraSolicitud.setNumeroDocumentoOrigen(registroAbastecimientoCabeceraLocal.getNSolicitud());
        try {
            cabeceraSolicitud.setCliente(
            getClienteDatosBasicosLocalHome().findByPrimaryKey(
               parametrosBelcenterLocal.getCliente() 
            ).getCod_clie());
        } catch (NoResultException fe) {
            this.logearError("MONRegistroAbastecimiento.generarSolicitudAHD: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarCabeceraSolicitud(DTORegistroAbastecimientoDetalle dto):Salida");
        return cabeceraSolicitud;
    }
    private MONTiposSolicitudPais getMONTiposSolicitudPais() throws MareException {
      // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONTiposSolicitudPaisL: Entrada");				
      MONTiposSolicitudPaisHome home = (MONTiposSolicitudPaisHome)UtilidadesEJB.getHome("MONTiposSolicitudPais", MONTiposSolicitudPaisHome.class);
            
      // Se obtiene el interfaz remoto
      MONTiposSolicitudPais ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      this.logearError("*** Error en MONRegistroAbastecimiento.getMONTiposSolicitudPais",e);
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONServicioBEL: Salida");		        
      return ejb;
	}

    private DTOPosicionSolicitud generarPosicionSolicitud(DTORegistroAbastecimientoDetalle dto) throws MareException {
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarPosicionSolicitud(DTORegistroAbastecimientoDetalle dto):Entrada");
        //Crear variable llamada "posicion" de tipo DTOPosicionSolicitud y hacer el siguiente mapeo:
        //-> Crear variable llamada "tipoSolicitudOperacion" de tipo DTOTipoSolicitudOperacion haciendo el siguiente mapeo
        DTOPosicionSolicitud posicion = new DTOPosicionSolicitud();
        DTOTipoSolicitudOperacion  tipoSolicitudOperacion = new DTOTipoSolicitudOperacion();
        
        //tipoSolicitudOperacion.pais = dto.pais
        tipoSolicitudOperacion.setOidPais(dto.getOidPais());
        //Es necesario pasarle tambien el idioma para que no falle la consulta
        tipoSolicitudOperacion.setOidIdioma(dto.getOidIdioma());
        
        //Tomar dto.oidRegistroAbastecimientoCabecera y hacer "findByPrimaryKey()" sobre la entidad "RegistroAbastecimientoCabecera"
        RegistroAbastecimientoCabeceraLocalHome registroAbastecimientoCabeceraLocalHome = null;
        RegistroAbastecimientoCabeceraLocal registroAbastecimientoCabeceraLocal = null;
        
        registroAbastecimientoCabeceraLocalHome = this.getRegistroAbastecimientoCabeceraLocalHome();
        try{
            registroAbastecimientoCabeceraLocal = registroAbastecimientoCabeceraLocalHome.findByPrimaryKey(
            dto.getOidRegistroAbastecimientoCabecera());
        }catch(NoResultException fe){
            
            this.logearError("MONRegistroAbastecimiento.generarPosicionSolicitud: FinderException", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        //Tomar RegistroAbastecimientoCabecera.oidPeriodo y hacer "findByPrimaryKey()" sobre la entidad Periodo
        PeriodoLocalHome periodoLocalHome = null;
        PeriodoLocal periodoLocal = null;
        
        periodoLocalHome = this.getPeriodoLocalHome();
        try{
            periodoLocal = periodoLocalHome.findByPrimaryKey(registroAbastecimientoCabeceraLocal.getPeriodo());
        }catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarPosicionSolicitud: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //tipoSolicitudOperacion.oidMarca = Periodo.oidMarca
        tipoSolicitudOperacion.setOidMarca(periodoLocal.getOidMarca());
        
        //tipoSolicitudOperacion.oidCanal = Periodo.oidCanal
        tipoSolicitudOperacion.setOidCanal(periodoLocal.getOidCanal());
        
        //tipoSolicitudOperacion.oidOperacion = ConstantesBEL.BEL004
        tipoSolicitudOperacion.setOidOperacion(ConstantesBEL.BEL004);
        
        //Agregado por la incidencia 12141
        //Tomar dto.pais y RegistroAbastecimientoCabecera.oidSubacceso como parámetros para la siguiente llamada
        //Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad ParametrosBelcenter
        ParametrosBelcenterLocalHome parametrosBelcenterLocalHome = null;
        ParametrosBelcenterLocal parametrosBelcenterLocal = null;
        
        parametrosBelcenterLocalHome = this.getParametrosBelcenterLocalHome();
        try{
            parametrosBelcenterLocal = parametrosBelcenterLocalHome.findByUK(dto.getOidPais(),
            registroAbastecimientoCabeceraLocal.getSubacceso());
        }catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarCabeceraSolicitud: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        // Llamar al método "DAOServicioBEL.obtenerPrimerTipoCliente(oidCliente : Long) : Long" pasando
        //ParametrosBelcenter.oidClienteDatosBasicos
        String usuario = ctx.getCallerPrincipal().getName();
        DAOServicioBel daoServicioBel = new DAOServicioBel(usuario);
        Long tipoClienteBelcenter = daoServicioBel.obtenerPrimerTipoCliente(parametrosBelcenterLocal.getCliente());
        //fin codifo añadido por 12141
        //tipoSolicitudOperacion.oitTipoCliente = tipoClienteBelcenter
        tipoSolicitudOperacion.setOidTipoCliente(tipoClienteBelcenter);
        //Tomar "tipoSolicitudOperacion" como parámetro para la siguiente llamada
        //-> Llamar al método "IPEDTiposSolicitud.obtieneTipoSolicitudOperacion(dto : DTOTipoSolicitudOperacion) : DTOSalida"
        MONTiposSolicitudPais monTipoSolicitudPais = null;
        DTOSalida dtoSalida = null;
        monTipoSolicitudPais = this.getMONTiposSolicitudPais();
        try{
            dtoSalida = monTipoSolicitudPais.obtieneTipoSolicitudOperacion(tipoSolicitudOperacion);
        }catch (RemoteException rExc) {
            UtilidadesLog.error(rExc);
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo MONRegistroAbastecimiento.generarPosicionSolicitud: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //Recuperar RecordSet del DTOSalida obtenido y tomar del primer registro el valor del campo "TSPA_OID_TIPO_SOLI_PAIS"
        //-> Crear variable llamada "tipoSolicitudPais" y asignarle el valor obtenido en la línea anterior
        Long tipoSolicitudPais =new Long(((BigDecimal) dtoSalida.getResultado().getValueAt(0, "OID")).longValue());
        
        //Tomar ConstantesBEL.BEL004 y tipoSolicitudPais como parámetros para la siguiente llamada
        //-> Llamar al método "findByUK(operacion : Long, tipoSolicitudPais : Long) : TiposSolicitudProceso" de la entidad TipoSolicitudProceso
        
        TiposSolicitudProcesoLocalHome tiposSolicitudProcesoLocalHome = null;
        TiposSolicitudProcesoLocal tiposSolicitudProcesoLocal = null;
        
        tiposSolicitudProcesoLocalHome = this.getTiposSolicitudProcesoLocalHome();
        try{
            tiposSolicitudProcesoLocal = tiposSolicitudProcesoLocalHome.findByUKProceso(ConstantesBEL.BEL004, tipoSolicitudPais ); 
        }catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarPosicionSolicitud: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //posicion.tipoPosicion = TiposSolicitudProceso.oidTipoPosicion
        posicion.setTipoPosicion(tiposSolicitudProcesoLocal.getOidTipoPosicion());
        //posicion.subtipoPosicion = TipoSolicitudProceso.oidSubtipoPosicion
        posicion.setSubtipoPosicion(tiposSolicitudProcesoLocal.getOidSubTipoPosicion());
        //posicion.producto = dto.oidProducto
        posicion.setProducto(dto.getOidProducto());
        //posicion.unidadesDemandadas = dto.unidadesConfirmadas
        posicion.setUnidadesDemandadas(dto.getUnidadesConfirmadas());
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarPosicionSolicitud(DTORegistroAbastecimientoDetalle dto):Salida");
        return posicion;
    }

   
    public DTOSalida buscarHDDetalleFlag(DTOEBuscarHDDetalleFlag dto) throws MareException {
        UtilidadesLog.info("MONRegistroAbastecimientoBean.buscarHDDetalleFlag(DTOEBuscarHDDetalleFlag dto):Entrada");
        //Llamar al método "DAORegistroAbastecimiento.buscarHDDetalleFlag(dto : DTOEBuscarHDDetalleFlag) : DTOSalida" 
        //-> Devolver el DTOSalida obtenido en la llamada anterior
        String usuario = ctx.getCallerPrincipal().getName();
        DAORegistroAbastecimiento daoRegistroAbastecimiento = new DAORegistroAbastecimiento(usuario);
        DTOSalida salida = daoRegistroAbastecimiento.buscarHDDetalleFlag(dto);
        
        UtilidadesLog.info("MONRegistroAbastecimientoBean.buscarHDDetalleFlag(DTOEBuscarHDDetalleFlag dto):Entrada");
        return salida;
    }

    private void generarMovimientoAlmacenDetalle(DTORegistroAbastecimientoDetalle dto) throws MareException {
       
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientoAlmacenDetalle(DTORegistroAbastecimientoDetalle dto):Entrada");
        
        //Llamar al método "MONGenerarRegistroAbastecimiento.generarMovimientoAlmacenDetalle1(dto : DTORegistroAbastecimientoDetalle) : DTOMovimientoAlmacenDetalle" 
        //-> Asignar respuesta al arrayList "movimientoAlmacen.detalle"
        DTOMovimientoAlmacenDetalle dtoMovAlmacendetalle1 = this.generarMovimientoAlmacenDetalle1(dto);
            UtilidadesLog.debug("****Metodo  generarMovimientoAlmacenDetalle: detalle1: " + dtoMovAlmacendetalle1);
        ArrayList array1 = (this.movimientoAlmacen.getDetalle()==null) ? new ArrayList() : this.movimientoAlmacen.getDetalle();        
        array1.add(dtoMovAlmacendetalle1);
        this.movimientoAlmacen.setDetalle(array1);
        //2) Si (dto.oidTipoActuacion <> 1) entonces 
        //-> Llamar al método "MONGenerarRegistroAbastecimiento.
        //generarMovimientoAlmacenDetalle2(dto : DTORegistroAbastecimientoDetalle) : DTOMovimientoAlmacenDetalle"
        if(dto.getOidTipoActuacion()!=null){
          if(dto.getOidTipoActuacion().longValue() != 1){
              
              DTOMovimientoAlmacenDetalle dtoMovAlmacendetalle2 = this.generarMovimientoAlmacenDetalle2(dto);
            UtilidadesLog.debug("****Metodo  generarMovimientoAlmacenDetalle: detalle2: " + dtoMovAlmacendetalle2);
              //-> Asignar respuesta al arrayList "movimientoAlmacen.detalle" 
              ArrayList array2 = (this.movimientoAlmacen.getDetalle()==null) ? new ArrayList() : this.movimientoAlmacen.getDetalle();        
              array2.add(dtoMovAlmacendetalle2);
              this.movimientoAlmacen.setDetalle(array2);
              // Generación de guías de remisión llamando al CU Generar Solicitud desde Módulos Externos
              //(4) Si (dto.oidTipoActuacion == 3) entonces 
              if(dto.getOidTipoActuacion().longValue()==3){
                  
                  //(5) Si (solicitudTipoActuacion3 == NULL) entonces
                  if(this.solicitudTipoActuacion3 == null){
                      //Tomar dto como parámetro para la siguiente llamada 
                      //-> Llamar al método "MONRegistroAbastecimiento.generarCabeceraSolicitud(dto : DTORegistroAbastecimientoDetalle) : DTOCabeceraSolicitud" 
                      //-> Asignar respuesta a "solicitudTipoActuacion3"
                      this.solicitudTipoActuacion3 = this.generarCabeceraSolicitud(dto);
                      //(5) Si no entonces 
                  }
                      // Tomar dto como parámetro para la siguiente llamada 
                      //-> Llamar al método "MONRegistroAbastecimiento.generarPosicionSolicitud(dto : DTORegistroAbastecimientoDetalle) : DTOPosicionSolicitud" 
                      //-> Añadir respuesta a la llamada anterior a "solicitudTipoActuacion3.posiciones"
                      DTOPosicionSolicitud dtoPosicion3 = this.generarPosicionSolicitud(dto);                    
                      ArrayList array3 = (this.solicitudTipoActuacion3.getPosiciones()==null) ? new ArrayList() : this.solicitudTipoActuacion3.getPosiciones();        
                      array3.add(dtoPosicion3);
                      this.solicitudTipoActuacion3.setPosiciones(array3);
                  //(4) Si no Si (dto.oidTipoActuacion == 4) entonces 
              }else if(dto.getOidTipoActuacion().longValue()== 4){
                  
                  //6) Si (solicitudTipoActuacion4 == NULL) entonces 
                  if(this.solicitudTipoActuacion4 == null){
                      //Tomar dto como parámetro para la siguiente llamada 
                      //-> Llamar al método "MONRegistroAbastecimiento.generarCabeceraSolicitud(dto : DTORegistroAbastecimientoDetalle) : DTOCabeceraSolicitud" 
                      //-> Asignar respuesta a "solicitudTipoActuacion4"
                      this.solicitudTipoActuacion4 = this.generarCabeceraSolicitud(dto);
                      //(6) Si no entonces 
                  }
                      //Tomar dto como parámetro para la siguiente llamada 
                      //-> Llamar al método "MONRegistroAbastecimiento.generarPosicionSolicitud(dto : DTORegistroAbastecimientoDetalle) : DTOPosicionSolicitud" 
                      //-> Añadir respuesta a la llamada anterior a "solicitudTipoActuacion4.posiciones"
                      DTOPosicionSolicitud dtoPosicion4 = this.generarPosicionSolicitud(dto);
                      ArrayList array4 = (this.solicitudTipoActuacion4.getPosiciones()==null) ? new ArrayList() : this.solicitudTipoActuacion4.getPosiciones();        
                      array4.add(dtoPosicion4);
                      this.solicitudTipoActuacion4.setPosiciones(array4);
              }
          }
        }
        UtilidadesLog.info("MONRegistroAbastecimientoBean.generarMovimientoAlmacenDetalle(DTORegistroAbastecimientoDetalle dto):Salida");
    }

    // El diseño de este metodo aparece en BELC300012398 
    private void generarSolicitudAHD(DTORegistroAbastecimiento dto) throws MareException 
    {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarSolicitudAHD(DTORegistroAbastecimiento dto):Entrada");
        
      // Tomar dto.oid y hacer "findByPrimaryKey()" sobre la entidad RegistroAbastecimientoCabecera
      RegistroAbastecimientoCabeceraLocal regAbastCabecLocal = null;
      try {
         regAbastCabecLocal = getRegistroAbastecimientoCabeceraLocalHome().findByPrimaryKey(dto.getOid());
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarSolicitudAHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
        
      // Tomar dto.pais y RegistroAbastecimientoCabecera.oidSubacceso como parámetros para la siguiente llamada
      // Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad ParametrosBelcenter
      ParametrosBelcenterLocalHome parametrosBelcenterLocalHome = null;
      ParametrosBelcenterLocal parametrosBelcenterLocal = null;
      
      parametrosBelcenterLocalHome = this.getParametrosBelcenterLocalHome();
      try {
         parametrosBelcenterLocal = parametrosBelcenterLocalHome.findByUK(dto.getOidPais(),
                                             regAbastCabecLocal.getSubacceso());
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarSolicitudAHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      
      //Llamar al método "DAOServicioBEL.obtenerPrimerTipoCliente(oidCliente : Long) : Long" 
      //pasando ParametrosBelcenter.oidClienteDatosBasicos
      //Crear variable llamada "tipoClienteBelcenter" asignándole la respuesta de la llamada anterior 
      String usuario = ctx.getCallerPrincipal().getName();
      DAOServicioBel dapServicioBel = new DAOServicioBel(usuario);
      Long tipoClienteBelcenter = dapServicioBel.obtenerPrimerTipoCliente(
                        parametrosBelcenterLocal.getCliente());

      //Crear variable llamada "tipoSolicitudOperacion" de tipo 
      //DTOTipoSolicitudOperacion haciendo el siguiente mapeo:
      DTOTipoSolicitudOperacion tipoSolicitudOperacion = new DTOTipoSolicitudOperacion();
      //tipoSolicitudOperacion.pais = dto.pais 
      tipoSolicitudOperacion.setOidPais(dto.getOidPais());
      tipoSolicitudOperacion.setOidIdioma(dto.getOidIdioma());

      // Tomar RegistroAbastecimientoCabecera.oidPeriodo y hacer "findByPrimaryKey()" sobre la entidad Periodo
      PeriodoLocalHome periodoLocalHome = null;
      PeriodoLocal periodoLocal = null;
      periodoLocalHome = this.getPeriodoLocalHome();
      try {
         periodoLocal = periodoLocalHome.findByPrimaryKey(regAbastCabecLocal.getPeriodo());
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarSolicitudAHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      //tipoSolicitudOperacion.oidMarca = Periodo.oidMarca 
      tipoSolicitudOperacion.setOidMarca(periodoLocal.getOidMarca());
      //tipoSolicitudOperacion.oidCanal = Periodo.oidCanal
      tipoSolicitudOperacion.setOidCanal(periodoLocal.getOidCanal());
      //tipoSolicitudOperacion.oidOperacion = ConstantesBEL.BEL003 
      tipoSolicitudOperacion.setOidOperacion(ConstantesBEL.BEL003);
      // tipoSolicitudOperacion.oitTipoCliente = tipoClienteBelcenter 
      tipoSolicitudOperacion.setOidTipoCliente(tipoClienteBelcenter);

      //Tomar "tipoSolicitudOperacion" como parámetro para la siguiente llamada 
      //Llamar al método "IPEDTiposSolicitud.obtieneTipoSolicitudOperacion(dto : DTOTipoSolicitudOperacion) : DTOSalida"
      MONTiposSolicitudPais monTipoSolicitudPais = null;
      DTOSalida dtoSalida = null;
      monTipoSolicitudPais = this.getMONTiposSolicitudPais();
      try {
         dtoSalida = monTipoSolicitudPais.obtieneTipoSolicitudOperacion(tipoSolicitudOperacion);
      } catch (RemoteException rExc) {
         UtilidadesLog.error(rExc);
         ctx.setRollbackOnly();
         UtilidadesLog.error(
             "****Metodo MONRegistroAbastecimiento.generarSolicitudAHD: obtieneTipoSolicitudOperacion : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
         throw new MareException(new Exception(),
             UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }

      //Recuperar RecordSet del DTOSalida obtenido y tomar del primer registro 
      //el valor del campo "TSPA_OID_TIPO_SOLI_PAIS"
      //Crear variable llamada "tipoSolicitudPais" y asignarle el valor obtenido en la línea anterior
      RecordSet rs = dtoSalida.getResultado();
      Long tipoSolicitudPais =new Long(((BigDecimal) rs.getValueAt(0, "OID")).longValue());

      //Crear variable llamada "cabeceraSolicitud" de tipo DTOCabeceraSolicitud
      DTOCabeceraSolicitud cabeceraSolicitud = new DTOCabeceraSolicitud();
      //cabeceraSolicitud.tipoSolicitud = tipoSolicitudPais 
      cabeceraSolicitud.setTipoSolicitud(tipoSolicitudPais);
      //cabeceraSolicitud.oidCliente = ParametrosBelcenter.oidClienteDatosBasicos 
      cabeceraSolicitud.setOidCliente(parametrosBelcenterLocal.getCliente());
      // asignamos tambien valor al atributo cliente del DTOCabeceraSolicitud porque
      // es necesario mas adelante
      // lo obtenemos haciendo un findByPrimaryKey en ClienteDatosBasicos con el parametro
      // ParametrosBelcenter.oidClienteDatosBasicos
      try {
         cabeceraSolicitud.setCliente(
            getClienteDatosBasicosLocalHome().findByPrimaryKey(
               parametrosBelcenterLocal.getCliente() 
            ).getCod_clie());
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarSolicitudAHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      //cabeceraSolicitud.pais = dto.pais 
      cabeceraSolicitud.setOidPais(dto.getOidPais());
      // asignamos valor al idioma porque se necesita mas adelante
      cabeceraSolicitud.setOidIdioma(dto.getOidIdioma());
      //cabeceraSolicitud.marca = Periodo.oidMarca 
      cabeceraSolicitud.setMarca(periodoLocal.getOidMarca());
      //cabeceraSolicitud.canal = Periodo.oidCanal
      cabeceraSolicitud.setCanal(periodoLocal.getOidCanal());
      //cabeceraSolicitud.operacion = ConstantesBEL.BEL003
      cabeceraSolicitud.setOperacion(ConstantesBEL.BEL003);
      // cabeceraSolicitud.periodo = RegistroAbastecimientoCabecera.oidPeriodo 
      cabeceraSolicitud.setPeriodo(regAbastCabecLocal.getPeriodo());
        
      // Tomar RegistroAbastecimientoCabecera.oidSubacceso y hacer 
      // "findByPrimarykey()" sobre la entidad Subacceso
      SubaccesoLocalHome subaccesoLocalHome = null;
      SubaccesoLocal subaccesoLocal = null;
      subaccesoLocalHome= this.getSubaccesoLocalHome();
      try{
         subaccesoLocal = subaccesoLocalHome.findByPrimaryKey(regAbastCabecLocal.getSubacceso());
      }catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarSolicitudAHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }

      //cabeceraSolicitud.acceso = Subacceso.oidAcceso 
      cabeceraSolicitud.setAcceso(subaccesoLocal.getOidAcceso());
      // cabeceraSolicitud.subacceso = RegistroAbastecimientoCabecera.oidSubacceso
      cabeceraSolicitud.setSubacceso(regAbastCabecLocal.getSubacceso());
      //cabeceraSolicitud.fecha = fecha del sistema 
      cabeceraSolicitud.setFecha(new Date(System.currentTimeMillis()));
      //cabeceraSolicitud.modulo = ConstantesSEG.MODULO_BEL 
      cabeceraSolicitud.setModulo(new Long(ConstantesSEG.MODULO_BEL));
      // cabeceraSolicitud.numeroDocumentoOrigen = RegistroAbastecimientoCabecera.nSolicitud
      cabeceraSolicitud.setNumeroDocumentoOrigen(regAbastCabecLocal.getNSolicitud());
        
      //Hallamos totales y generamos las posiciones
      //Tomar ConstantesBEL.BEL003 y tipoSolicitudPais como parámetros para la siguiente llamada 
      //Llamar al método "findByUK(operacion : Long, tipoSolicitudPais : Long) : TiposSolicitudProceso" de la entidad TipoSolicitudProceso 
      TiposSolicitudProcesoLocalHome tiposSolicitudProcesoLocalHome = null;
      TiposSolicitudProcesoLocal tiposSolicitudProcesoLocal = null;
      tiposSolicitudProcesoLocalHome = this.getTiposSolicitudProcesoLocalHome();
      try {
         tiposSolicitudProcesoLocal = tiposSolicitudProcesoLocalHome.findByUKProceso(ConstantesBEL.BEL003, tipoSolicitudPais); 
      } catch (NoResultException fe) {
         this.logearError("MONRegistroAbastecimiento.generarSolicitudAHD: FinderException", fe);
         String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
         throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }

      // Llamar al método "DAORegistroAbastecimiento.obtenerDetalleHojaDemanda(dto : DTOOID) : DTOSalida"
      DTOOID dtoOid = new DTOOID();
      dtoOid.setOid(dto.getOid());
      dtoOid.setOidPais(dto.getOidPais());
      dtoOid.setOidIdioma(dto.getOidIdioma());
      rs = (new DAORegistroAbastecimiento(usuario)).obtenerDetalleHojaDemanda(dtoOid).getResultado();

       // Crear variable llamada "posiciones" de tipo arrayList
      ArrayList posiciones = new ArrayList();
 
      DTOPosicionSolicitud posicion = null;
 
      // Para cada posición i-ésima del registro del RecordSet obtenido en la llamada anterior hacer
      for (int i=0; i < rs.getRowCount(); i++) {
         // Crear variable llamada "posicion" de tipo DTOPosicionSolicitud y hacer el siguiente mapeo:
         posicion = new DTOPosicionSolicitud();
         // posicion.tipoPosicion = TiposSolicitudProceso.oidTipoPosicion
         posicion.setTipoPosicion(tiposSolicitudProcesoLocal.getOidTipoPosicion());
         // posicion.subtipoPosicion = TipoSolicitudProceso.oidSubtipoPosicion
         posicion.setSubtipoPosicion(tiposSolicitudProcesoLocal.getOidSubTipoPosicion());
         // posicion.producto = recordSet.getRow(i).get("PROD_OID_PROD");
         posicion.setProducto(new Long(((BigDecimal)rs.getValueAt(i, "PROD_OID_PROD")).longValue()));
         // posicion.unidadesDemandadas = recordSet.getRow(i).get("NUM_UNID_CONF");
         posicion.setUnidadesDemandadas(new Long(((BigDecimal)rs.getValueAt(i, "NUM_UNID_CONF")).longValue()));
         // añadir "posicion" al arrayList "cabeceraSolicitud.posiciones"
         posiciones.add(posicion);
      } 
      // añadir "posiciones" al arrayList "cabeceraSolicitud.posiciones"
      cabeceraSolicitud.setPosiciones(posiciones);   
      
      //Tomar el valor de "cabeceraSolicitud" para la siguiente llamada 
      // Llamar al método "IPEDGenerarSolicitudesExternas.generaSolicitud(DTOE : DTOCabeceraSolicitud) : DTOOID"
      MONGenerarSolicitudModulosExternos monSolicitudModulosExt = this.getMONGenerarSolicitudModulosExternos();
      try{
         dtoOid = monSolicitudModulosExt.generaSolicitud(cabeceraSolicitud);
      }catch (RemoteException rExc) {
         UtilidadesLog.error(rExc);
         ctx.setRollbackOnly();
         UtilidadesLog.error(
             "****Metodo MONRegistroAbastecimiento.generarSolicitudAHD: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
         throw new MareException(new Exception(),
             UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      
      UtilidadesLog.info("MONRegistroAbastecimientoBean.generarSolicitudAHD(DTORegistroAbastecimiento dto):Salida");
   }

    public void alertaCalculoSalidaSuperiorAlPrevisto(Long pais, Long subacceso) throws MareException {
        
        UtilidadesLog.info("MONRegistroAbastecimientoBean.alertaCalculoSalidaSuperiorAlPrevisto(Long pais, Long subacceso):Entrada");
        
        // Crear variable llamada "alertaStock" de tipo BigDecimal 
        BigDecimal alertaStock = null;
        //-> Llamar al método "findByUK(pais : Long, subacceso : Long)" de la entidad ParametrosBelcenter
        ParametrosBelcenterLocalHome parametrosBelcenterLocalHome = null;
        ParametrosBelcenterLocal parametrosBelcenterLocal = null;
        try{  
        
                parametrosBelcenterLocalHome = this.getParametrosBelcenterLocalHome();
                try{
                    parametrosBelcenterLocal = parametrosBelcenterLocalHome.findByUK(pais, subacceso);
                }catch (NoResultException fe) {
                 this.logearError("MONRegistroAbastecimiento.generarSolicitudAHD: FinderException", fe);
                 String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                 throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                //alertaStock = ParametrosBelcenter.alertaStock 
                alertaStock = parametrosBelcenterLocal.getAlertaStock();
                //Crear variable llamada "criteriosPeriodo" de tipo DTOCriteriosPeriodo 
                DTOCriteriosPeriodo criteriosPeriodo = new DTOCriteriosPeriodo();
                //criteriosPeriodo.pais = pais 
                criteriosPeriodo.setOidPais(pais);
                //Llamar al método "findByPrimaryKey()" de la entidad Subacceso usando el subacceso de entrada 
                SubaccesoLocalHome subaccesoLocalHome = null;
                SubaccesoLocal subaccesoLocal = null;
                subaccesoLocalHome= this.getSubaccesoLocalHome();
                try{
                    
                        subaccesoLocal = subaccesoLocalHome.findByPrimaryKey(subacceso);
                    }catch (NoResultException fe) {
                        this.logearError("MONRegistroAbastecimiento.alertaCalculoSalidaSuperiorAlPrevisto: FinderException", fe);
                        String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                        throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                //Llamar al método "findByPrimaryKey()" de la entidad Acceso usando Subacceso.oidAcceso 
                AccesoLocalHome accesoLocalHome = null;
                AccesoLocal accesoLocal = null;
                accesoLocalHome = this.getAccesoLocalHome();
                try{
                    accesoLocal = accesoLocalHome.findByPrimaryKey(subaccesoLocal.getOidAcceso());
                }catch (NoResultException fe) {
                        this.logearError("MONRegistroAbastecimiento.alertaCalculoSalidaSuperiorAlPrevisto: FinderException", fe);
                        String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                        throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                    
                // criteriosPeriodo.canal = Acceso.oidCanal 
                criteriosPeriodo.setCanal(accesoLocal.getOidCanal());
                //Tomar criteriosPeriodo como parámetro para la siguiente llamada 
                //Llamar al método "MONPeriodos.obtienePeriodosConsulta(dtoEntrada : DTOCriteriosPeriodo) : DTOSalida" 
                MONPeriodos monPeriodos = null;
                DTOSalida salida = null;
                monPeriodos = this.getMONPeriodos();
                try{
                    salida = monPeriodos.obtienePeriodosConsulta(criteriosPeriodo);
                }catch (RemoteException rExc) {
                    UtilidadesLog.error(rExc);
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(
                        "****Metodo MONRegistroAbastecimiento.alertaCalculoSalidaSuperiorAlPrevisto: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
                    throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                //Obtener el primer registro del RecordSet obtenido en la llamada anterior 
                //donde la fecha actual del sistema esté entre la fecha de inicio y la fecha 
                //de fin del período contenido en dicho registro y obtener de este el oid del periodo 
                RecordSet resultado = salida.getResultado();
                Long oidPeriodo = null;
                for(int i = 0; i<resultado.getRowCount(); i++){
                    
                    Date fechaInicio = (Date)resultado.getValueAt(i,"FEC_INIC");
                    Date fechaFin = (Date)resultado.getValueAt(i,"FEC_FINA");
                    Date fechaActual = new Date(System.currentTimeMillis());
                    if((fechaActual.getTime() > fechaInicio.getTime()) && (fechaActual.getTime() < fechaFin.getTime())) {
                        oidPeriodo = new Long(((BigDecimal)resultado.getValueAt(i,"OID")).longValue());
                        break;
                    }
                }
                //Llamar al método "findByPrimaryKey()" de la entidad Periodo usando el oid de periodo obtenido en la línea anterior
                PeriodoLocalHome periodoLocalHome = null;
                PeriodoLocal periodoLocal = null;
                
                periodoLocalHome = this.getPeriodoLocalHome();
                try{
                    periodoLocal = periodoLocalHome.findByPrimaryKey(oidPeriodo);
                }catch (NoResultException fe) {
                 this.logearError("MONRegistroAbastecimiento.alertaCalculoSalidaSuperiorAlPrevisto: FinderException", fe);
                 String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                 throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                //Tomar Periodo.fechaInicio y fecha actual respectivamente como parámetros para la llamada siguiente 
                //Llamar al método "MONPeriodos.dayDiff(fecha1 : Date, fecha2 : Date) : Integer" 
                //Crear variable llamada "diasPeriodo" de tipo Integer y asignarle el resultado de la llamada anterior
                 Integer diasPeriodo = null;
                try{
                    diasPeriodo = monPeriodos.dayDiff(periodoLocal.getFechainicio(),new Date (System.currentTimeMillis()));
                }catch (RemoteException rExc) {
                    UtilidadesLog.error(rExc);
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(
                        "****Metodo MONRegistroAbastecimiento.alertaCalculoSalidaSuperiorAlPrevisto: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
                    throw new MareException(new Exception(),
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                //Incidencia 12204
                //Tomar subacceso y Periodo.oid respectivamente como parámetros para la siguiente llamada 
                //Llamar al método "DAORegistroAbastecimiento.obtenerEstimadosVenta(subacceso : Long, periodo : Long) : RecordSet"
                String usuario = ctx.getCallerPrincipal().getName();
                DAORegistroAbastecimiento daoRegistroAbastecimiento = new DAORegistroAbastecimiento(usuario);
                RecordSet recordSet = daoRegistroAbastecimiento.obtenerEstimadosVenta(subacceso,periodoLocal.getOid());
                //Recorrer RecordSet obtenido en llamada anterior
                //Crear variable llamada "mediaDiariaReal" de tipo BigDecimal inicializada a 0 
                BigDecimal mediaDiariaReal = new BigDecimal("0");
                //Crear variable llamada "mediaDiariaPrevista" de tipo BigDecimal inicializada a 0
                BigDecimal mediaDiariaPrevista = new BigDecimal("0");
                //Crear variable llamada "unidadesEstimadas" de tipo Long inicializada a 0
                Long unidadesEstimadas = new Long("0");
                //Crear variable llamada "unidadesAtendidas" de tipo Long inicializada a 0
                Long unidadesAtendidas = new Long("0");
                //Crear variable llamada "indicador" de tipo BigDecimal
                BigDecimal indicador;
                //(1) Para cada registro del RecordSet hacer
                for(int j = 0; j<recordSet.getRowCount(); j++){
                    //unidadesEstimadas = valor del campo "NUM_UNID_ESTI"
                   
                        unidadesEstimadas = new Long(((BigDecimal)recordSet.getValueAt(j,"NUM_UNID_ESTI")).longValue());
                        //Tomar Periodo.oid, subacceso y el valor del campo "PROD_OID_PROD" 
                        //respectivamente como parámetros para la siguiente llamada 
                        //Llamar al método "DAOPosicion.obtenerUnidadesAtendidasPorProducto
                        //(periodo : Long, subacceso : Long, producto : Long) : RecordSet"
                        Long producto = new Long(((BigDecimal)recordSet.getValueAt(j,"PROD_OID_PROD")).longValue());
                        DAOPosicion daoPosicion = new DAOPosicion();
                        RecordSet resultadoPosicion = daoPosicion.obtenerUnidadesAtendidasPorProducto(
                                                            periodoLocal.getOid(),subacceso, producto);
                        //unidadesAtentidas = valor de campo "UNIDADES_ATENDIDAS" del primer registro (y único) del RecordSet obtenido 
                        UtilidadesLog.info("valor de UNIDADES ATENDIDAS+-" + resultadoPosicion.getValueAt(0,"UNIDADES_ATENDIDAS") + "******");
                        
                        if (resultadoPosicion.getValueAt(0,"UNIDADES_ATENDIDAS") != null)
                            unidadesAtendidas = new Long(((BigDecimal) resultadoPosicion.getValueAt(0,"UNIDADES_ATENDIDAS")).longValue());
            
                        //mediaDiariaReal = unidadesAtendidas / diasPeriodo 
                        UtilidadesLog.info("diasPeriodo*********" + diasPeriodo );
                        UtilidadesLog.info("unidadesAtendidas*********" + unidadesAtendidas );
                        mediaDiariaReal = new BigDecimal((double)unidadesAtendidas.longValue()/(double)diasPeriodo.longValue());
            
                        //mediaDiariaEstimada = unidadesEstimadas / diasPeriodo 
                        mediaDiariaPrevista = new BigDecimal((double)unidadesEstimadas.longValue()/(double)diasPeriodo.longValue());
            
                        // indicador = mediaDiariaReal / mediaDiariaEstimada 
                        //indicador = new BigDecimal(mediaDiariaReal.longValue()/mediaDiariaPrevista.longValue());
                        UtilidadesLog.info("mediaDiariaReal*********" + mediaDiariaReal );
                        indicador =  mediaDiariaReal.divide(mediaDiariaPrevista,2,BigDecimal.ROUND_HALF_UP);
        
                    // Si (|1 - indicador| >= alertaStock) entonces 
                    if(Math.abs(1-indicador.longValue()) >= alertaStock.longValue()){
                        //Hacer un "create()" sobre la entidad "AlertasStock" tomando 
                        //los valores de "pais", "subacceso" y el valor del campo "PROD_OID_PROD" del registro 
                        //incidencia 12170
                        AlertasStockLocalHome alertasStockLocalHome = null;
                        AlertasStockLocal alertasStockLocal = null;
                        
                        alertasStockLocalHome = this.getAlertasStockLocalHome();
                        try{//Timestamp fecAler, Long prodOidProd, Long subacceso, Long pais, BigDecimal indicador
                             Long prodTemp =  new Long(((BigDecimal)recordSet.getValueAt(0,"PROD_OID_PROD")).longValue());
                              /*alertasStockLocal = alertasStockLocalHome.create(new Timestamp(
                              System.currentTimeMillis()), new Long (((BigDecimal)recordSet.getValueAt(0,"PROD_OID_PROD")).longValue() ),
                              subacceso, pais, indicador);*/
                              Timestamp tiempoTemp = new Timestamp(System.currentTimeMillis());
                             alertasStockLocal = alertasStockLocalHome.create(tiempoTemp, prodTemp, subacceso, pais, indicador);                      
                        }catch (PersistenceException e) {
                             ctx.setRollbackOnly();
                              this.logearError("MONRegistroAbastecimiento.alertaCalculoSalidaSuperiorAlPrevisto: CreateException", e);
                              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                        //Incidencia 12397  
                    }
                }
        }catch(Exception e){
            ctx.setRollbackOnly();
            e.printStackTrace();
            UtilidadesLog.info("exception ------- " + e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONRegistroAbastecimientoBean.alertaCalculoSalidaSuperiorAlPrevisto(Long pais, Long subacceso):Salida");
    }
    
    private MONPeriodos getMONPeriodos() throws MareException {
      // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONPeriodos: Entrada");				
      MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome("MONPeriodos", MONPeriodosHome.class);
            
      // Se obtiene el interfaz remoto
      MONPeriodos ejb = null;
      try {
         ejb = home.create();
      } catch (Exception e) {
      this.logearError("*** Error en MONRegistroAbastecimiento.getMONPeriodos",e);
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      UtilidadesLog.debug("****Metodo  MONRegistroAbastecimiento.getMONPeriodos: Salida");		        
      return ejb;
	}

   private void validaVinculos(Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso) 
      throws RemoteException, MareException 
   {
      UtilidadesLog.info("MONRegistroAbastecimientoBean.validaVinculos(Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso):Entrada");

      MONValidacion monValidacion = this.getMONValidacion();
      Boolean b = new Boolean(true);
   
      UtilidadesLog.debug("**** Llamada a validaVinculos(pais= "+ pais + ", marca= "+marca + ", canal= " + canal + ", acceso= "+ acceso+ ")");
      b = monValidacion.validarVinculos( pais, sociedad, marca, canal, acceso, subAcceso);
      UtilidadesLog.debug("**** Retorno validaVinculos:  " + b.toString());
      if (!b.booleanValue()) {				
         ctx.setRollbackOnly();			
         UtilidadesLog.error("****Metodo validaVinculos: validarVinculos : ERROR_VINCULOS_INVALIDOS");
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULOS_INVALIDOS) );
      } 					

     UtilidadesLog.info("MONRegistroAbastecimientoBean.validaVinculos(Long pais,Long sociedad,Long marca, Long canal, Long acceso,Long subAcceso):Salida");
   }


    private MarcaLocalHome getMarcaLocalHome() {
           return new MarcaLocalHome();
        }

    private SubaccesoLocalHome getSubaccesoLocalHome() {
       return new SubaccesoLocalHome();
    }
    
    private AccesoLocalHome getAccesoLocalHome() {
       return new AccesoLocalHome();
    } 

    private PeriodoLocalHome getPeriodoLocalHome() {
       return new PeriodoLocalHome();
    }
    
    private ControlesDeAlmacenLocalHome getControlesDeAlmacenLocalHome() {
       return new ControlesDeAlmacenLocalHome();
    }   
    
    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws MareException {
       UtilidadesLog.debug("****Metodo MONRegistroAbastecimiento.getMaestroProductosLocalHome: Entrada");
       MaestroProductosLocalHome maestroProductosLocalHome = (MaestroProductosLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MaestroProductos");
       UtilidadesLog.debug("****Metodo MONRegistroAbastecimiento.getMaestroProductosLocalHome: Salida");
       return maestroProductosLocalHome;
    } 
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
       return new ClienteDatosBasicosLocalHome();
    }      
    
    private AsignacionAlmacenLocalHome getAsignacionAlmacenLocalHome() {
       return new AsignacionAlmacenLocalHome();
    }
    
    private AgrupacionStockCabeceraLocalHome getAgrupacionStockCabeceraLocalHome() {
       return new AgrupacionStockCabeceraLocalHome();
    }

    private RegistroAbastecimientoCabeceraLocalHome getRegistroAbastecimientoCabeceraLocalHome() {
       return new RegistroAbastecimientoCabeceraLocalHome();
    }
    
    private RegistroAbastecimientoDetalleLocalHome getRegistroAbastecimientoDetalleLocalHome() {
       return new RegistroAbastecimientoDetalleLocalHome();
    }
    
    private ParametrosBelcenterLocalHome getParametrosBelcenterLocalHome() {
       return new ParametrosBelcenterLocalHome();
    }  
    
    private TiposSolicitudProcesoLocalHome getTiposSolicitudProcesoLocalHome() {
        return new TiposSolicitudProcesoLocalHome();
    }  
    
    private AlertasStockLocalHome getAlertasStockLocalHome() {
        return new AlertasStockLocalHome();
    }


}
