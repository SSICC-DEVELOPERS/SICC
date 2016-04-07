package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.cra.DTOCronogramaFecha;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.cra.CabeceraGruposZonasLocal;
import es.indra.sicc.entidades.cra.CabeceraGruposZonasLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.cra.TipoFacturacionLocal;
import es.indra.sicc.entidades.cra.TipoFacturacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.ped.AsignacionAlmacenLocal;
import es.indra.sicc.entidades.ped.AsignacionAlmacenLocalHome;
import es.indra.sicc.entidades.ped.AtributosEspecialesLocal;
import es.indra.sicc.entidades.ped.AtributosEspecialesLocalHome;
import es.indra.sicc.entidades.ped.ClaseSolicitudLocal;
import es.indra.sicc.entidades.ped.ClaseSolicitudLocalHome;
import es.indra.sicc.entidades.ped.TiposDespachoLocal;
import es.indra.sicc.entidades.ped.TiposDespachoLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.ped.ValoresPorDefectoLocal;
import es.indra.sicc.entidades.ped.ValoresPorDefectoLocalHome;
import es.indra.sicc.entidades.pre.CabeceraMFLocal;
import es.indra.sicc.entidades.pre.CabeceraMFLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.cra.MONCronograma;
import es.indra.sicc.logicanegocio.cra.MONCronogramaHome;
import es.indra.sicc.logicanegocio.cra.MONMantenimientoGruposZonas;
import es.indra.sicc.logicanegocio.cra.MONMantenimientoGruposZonasHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.men.MONUsuarios;
import es.indra.sicc.logicanegocio.men.MONUsuariosHome;
import es.indra.sicc.logicanegocio.ped.DAOValidaciones;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.HashMap;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONValidacionesGeneralesSolicitudBean implements SessionBean  {

	private SessionContext ctx;
	private final static long CONSTANTE_DIA = 86400000;
	private final static String CU = "Validaciones generales";
	private final static String ERROR1 = "Moneda documento no es moneda de Matriz de Precios";
	private final static String ERROR2 = "Almacén no parametrizado";
        private UtilidadesLog log = new UtilidadesLog();
 
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

    public Boolean validarAcceso(Long tipoSolicitud) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarAcceso(Long tipoSolicitud): Entrada ");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        
        query.append(" SELECT COD_ACCE ");
		    query.append(" FROM PED_TIPO_SOLIC PTS, ");  
			 	query.append("      SEG_ACCES ACC, ");
				query.append("      PED_TIPO_SOLIC_PAIS TSP ");        
		    query.append(" WHERE PTS.OID_TIPO_SOLI = TSP.TSOL_OID_TIPO_SOLI ");
		   	query.append("   AND PTS.ACCE_OID_ACCE = ACC.OID_ACCE ");
			  query.append("   AND TSP.OID_TIPO_SOLI_PAIS = " + tipoSolicitud);

        rs = this.executeQuery(query.toString());
        Boolean valAcceso = Boolean.TRUE;
        
        if (!rs.esVacio()){
            String codigoAcceso = this.objectToString(rs.getValueAt(0,"COD_ACCE")); 
            if (codigoAcceso.equals(ConstantesSEG.ACCESO_CALLCENTER)  ||
                codigoAcceso.equals(ConstantesSEG.ACCESO_BELCENTER)){             
                valAcceso = Boolean.FALSE;
            } 
        }
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarAcceso(Long tipoSolicitud): Salida ");
        return valAcceso;
    }   
    
    public Long obtenerOidCliente(Long oidPais, String codCliente) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.obtenerOidCliente(Long oidPais, String codCliente): Entrada ");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        
        query.append(" SELECT OID_CLIE ");
		    query.append(" FROM MAE_CLIEN ");  
		    query.append(" WHERE PAIS_OID_PAIS = " + oidPais);
		   	query.append("   AND COD_CLIE = '" + codCliente + "'");

        rs = this.executeQuery(query.toString());
        Long oidClie = null;
        
        if (!rs.esVacio()){
            oidClie = this.bigDecimalToLong(rs.getValueAt(0,"OID_CLIE")); 
        }
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.obtenerOidCliente(Long oidPais, String codCliente): Salida ");
        return oidClie;
    } 
    
    public String validarOidCliente(Long oidCliente) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarOidCliente(Long oidCliente): Entrada ");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        
        query.append(" SELECT COD_CLIE ");
		    query.append(" FROM MAE_CLIEN ");  
		    query.append(" WHERE OID_CLIE = " + oidCliente);		   	

        rs = this.executeQuery(query.toString());
        String codClie = null;
        
        if (!rs.esVacio()){
            codClie = this.objectToString(rs.getValueAt(0,"COD_CLIE")); 
        }
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarOidCliente(Long oidCliente): Salida ");
        return codClie;
    } 
    
    
    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
        
 /*       
    public Boolean validarAcceso(Long tipoSolicitud) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarAcceso(Long tipoSolicitud): Entrada ");                    
                
        //Documentation
        // Si el acceso asociado al tipo de solicitud es CallCenter o Belcenter devuelve False 
        //codigoAcceso = DAOValidaciones.obtenerAcceso(tipoSolicitud) 

        //Si codigoAcceso == ConstantesSEG.ACCESO_CALLCENTER OR ConstantesSEG.ACCESO_BELCENTER 
        //Devuelve False 
        //sino 
        //Devuelve True 
        ///
        DAOValidaciones daoValidaciones = new DAOValidaciones();
        String codigoAcceso = daoValidaciones.obtenerAcceso(tipoSolicitud);
        
        if (codigoAcceso.equals(ConstantesSEG.ACCESO_CALLCENTER)  ||
            codigoAcceso.equals(ConstantesSEG.ACCESO_BELCENTER)){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarAcceso(Long tipoSolicitud): Salida ");
            return Boolean.FALSE;
        } else {
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarAcceso(Long tipoSolicitud): Salida ");
            return Boolean.TRUE;
        }
    }
 */  
    private RecordSet executeQuery(String query) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternos.executeQuery(String query): Entrada");
        RecordSet rs = null;
        
        try {
          BelcorpService belcorpService = BelcorpService.getInstance();
          rs = belcorpService.dbService.executeStaticQuery( query );
        } catch ( Exception ex ) {
          throw new MareException( ex, 
              UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }       
        UtilidadesLog.info("MONGenerarSolicitudModulosExternos.executeQuery(String query): Salida");  
        return rs;
   }
      
   private String objectToString(Object ob) {
               if (ob != null) {
                return (String) ob;
            } else {
                return null;
            }
   }

    public DTOCabeceraSolicitud validarSubacceso(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSubacceso(DTOCabeceraSolicitud DTOE): Entrada ");
        /*
        Documentation
        // Valida el subacceso de la solicitud 

        OK = DAOValidaciones.validarSubacceso(DTOE.tipoSolicitud) 

        Si OK == False 
        DTOE = validacionKO(DTOE) 

        Devuelve DTOE
        */
        DAOValidaciones daoValidaciones = new DAOValidaciones();
        Boolean OK = daoValidaciones.validarSubacceso(DTOE.getTipoSolicitud());

        if (OK.booleanValue() == false)
            DTOE = this.validacionKO(DTOE);
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSubacceso(DTOCabeceraSolicitud DTOE): Salida ");
        return DTOE;
    }

    public DTOCabeceraSolicitud validacionKO(DTOCabeceraSolicitud DTOE) throws MareException {
        /*
        Documentation
        DTOE.OK = False 
        Coloco todos los atributos de DTOE a Null excepto mensajeError 
        Devuelve DTOE
        */

        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validacionKO(DTOCabeceraSolicitud DTOE): Entrada ");

        DTOE.setOK(Boolean.FALSE);
        DTOE.setAcceso(null);
        DTOE.setAccesoFisico(null);
        DTOE.setAlmacen(null);
        DTOE.setCanal(null);
        DTOE.setClaseSolicitud(null);
        DTOE.setCliente(null);
        DTOE.setConsultoraAsociada(null);
        DTOE.setDestinatario(null);
        DTOE.setDestino(null);
        DTOE.setEstado(null);
        DTOE.setFecha(null);
        DTOE.setFechaPrevistaFacturacion(null);
        DTOE.setFormaPago(null);
        DTOE.setIndicadorDigitacion(null);
        DTOE.setIndMasSolicitudes(null);
        DTOE.setIndPedidoPrueba(null);
        DTOE.setIndTSNoConsolidado(null);
        DTOE.setMarca(null);
        DTOE.setModulo(null);
        DTOE.setMoneda(null);
        DTOE.setNumeroClientes(null);
        DTOE.setNumeroDocumentoOrigen(null);
        DTOE.setNumeroPremio(null);
        DTOE.setNumeroSolicitud(null);
        DTOE.setObservaciones(null);
        DTOE.setOidCabeceraSolicitud(null);
        DTOE.setOidCliente(null);
        DTOE.setOidConcursoParametros(null);
        DTOE.setOidDocumentoReferencia(null);
        DTOE.setOidPagadorFactura(null);
        DTOE.setOidReceptorFactura(null);
        DTOE.setOperacion(null);
        DTOE.setOrdenCompra(null);
        DTOE.setPagadorFactura(null);
        DTOE.setPeriodo(null);
        DTOE.setPermiteUnionSolicitudes(null);
        DTOE.setPosiciones(null);
        DTOE.setProceso(null);
        DTOE.setReceptorFactura(null);
        DTOE.setRegion(null);
        DTOE.setSeccion(null);
        DTOE.setSociedad(null);
        DTOE.setSubacceso(null);
        DTOE.setSubgerencia(null);
        DTOE.setSubtipoCliente(null);
        DTOE.setTerritorio(null);
        DTOE.setTipoCliente(null);
        DTOE.setTipoConsolidado(null);
        DTOE.setTipoDespacho(null);
        DTOE.setTipoDocumento(null);
        DTOE.setTipoDocumentoLegal(null);
        DTOE.setTipoSolicitud(null);
        DTOE.setUbigeo(null);
        DTOE.setUsuario(null);
        DTOE.setZona(null);
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validacionKO(DTOCabeceraSolicitud DTOE): Salida ");
        return DTOE;
    }

    public DTOCabeceraSolicitud validacionOK(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validacionOK(DTOCabeceraSolicitud DTOE): Entrada ");
        DTOE.setOK(Boolean.TRUE);
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validacionOK(DTOCabeceraSolicitud DTOE): Salida ");
        return DTOE;
    }

    public DTOCabeceraSolicitud validarTipoSolicitud(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarTipoSolicitud(DTOCabeceraSolicitud DTOE): Entrada ");

        TiposSolicitudPaisLocalHome tspLHome = null;
        TiposSolicitudPaisLocal tspLocal = null;
        TiposSolicitudLocalHome tsLHome = null;
        TiposSolicitudLocal tsLocal = null;		
        AtributosEspecialesLocalHome aeLHome = null;
        AtributosEspecialesLocal aeLocal = null;
        ValoresPorDefectoLocalHome vpdLHome = null;
        ValoresPorDefectoLocal vpdLocal = null;
        ClaseSolicitudLocalHome csLHome = null;
        ClaseSolicitudLocal csLocal = null;
        
        try{
          //Tipo solicitud
          tspLHome = new TiposSolicitudPaisLocalHome();
          tsLHome = new TiposSolicitudLocalHome();
        
          tspLocal = tspLHome.findByPrimaryKey(DTOE.getTipoSolicitud());
          tsLocal = tsLHome.findByPrimaryKey(tspLocal.getOidTipoSolicitud());
          
          //Clase solicitud 
          csLHome = new ClaseSolicitudLocalHome();
          DTOE.setClaseSolicitud( tsLocal.getOidClaseSolicitud() );
          csLocal = csLHome.findByPrimaryKey(DTOE.getClaseSolicitud()); 
          DTOE.setOrdenCompra( csLocal.getIndOrdenCompra() ); 
    
          // Indicadores 
          DTOE.setPermiteUnionSolicitudes( tspLocal.getPermiteUnionSolicitudes());
          DTOE.setIndPedidoPrueba( tspLocal.getIndPedidoPrueba()); 
          DTOE.setTipoConsolidado( tspLocal.getOidTipoConsolidado() ); 
          if ( DTOE.getTipoDocumentoLegal() == null ){
              DTOE.setTipoDocumentoLegal( tspLocal.getOidTipoDocumentoLegal()); 
          }
    
          // Sociedad 
          if ( tspLocal.getOidSociedad() != null ){
              DTOE.setSociedad( tspLocal.getOidSociedad() );
          }else{
              // Se obtiene de valores por defecto 
              aeLHome = new AtributosEspecialesLocalHome();
              vpdLHome = new ValoresPorDefectoLocalHome();
      
              try{
                  aeLocal = aeLHome.findByUK(ConstantesValoresDefecto.SOCIEDAD);
                  vpdLocal = vpdLHome.findByUK(aeLocal.getOid(), DTOE.getTipoSolicitud()); 
        
                  DTOE.setSociedad( vpdLocal.getOid() ); 
              }catch(NoResultException e){				
                  // Se obtiene el valor correspondiente al usuario
                  try{
                      UtilidadesLog.debug("Se obtiene el valor correspondiente al usuario");
                      MONUsuarios monUsu = this.getMONUsuariosHome().create();
                     
                      String uName = ctx.getCallerPrincipal().getName();
                                
                      UtilidadesLog.debug("Nombre de Usuario:  " + uName);
                      
                      HashMap propiedades = monUsu.getProperties(new UserIDImpl(uName));                    
            
                      UtilidadesLog.debug(" Sociedad por defecto del usuario: ");
                      UtilidadesLog.debug((String) ((Property) propiedades.get(ConstantesPED.SOCIEDAD_DEFECTO)).getValue());
            
                      UtilidadesLog.debug(" Se setea en el DTO. ");
                      DTOE.setSociedad( new Long( (String) ((Property) propiedades.get(ConstantesPED.SOCIEDAD_DEFECTO)).getValue() )  );
                  }catch(Exception ex){
                      UtilidadesLog.error("ERROR AL OBTENER EL VALOR POR DEFECTO DEL USUARIO: "+ctx.getCallerPrincipal().getName(), ex);
                  }
              } catch (PersistenceException e) {
                  ctx.setRollbackOnly();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
          } 
    
            // Glosa 
            if (tspLocal.getGlosa() != null && DTOE.getObservaciones() == null ){
                DTOE.setObservaciones( tspLocal.getGlosa() );
            }
    
            // Módulo 
            if ( DTOE.getModulo() == null ){
                DTOE.setModulo( ConstantesPED.MODULO_PEDIDOS); 
            }
    
            // Operación 
            if (DTOE.getOperacion() == null){
                DTOE.setOperacion( ConstantesBEL.PED001 ); 
            }
    
            // Indicador consolidado 
            DTOE.setIndTSNoConsolidado( Boolean.TRUE );
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarTipoSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
            return DTOE;
        
        }catch(NoResultException e){
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch(PersistenceException e){
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
    }

   public DTOCabeceraSolicitud validarAlmacen(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarAlmacen(DTOCabeceraSolicitud DTOE): Entrada ");
		TiposSolicitudPaisLocalHome tspLHome = null;
		TiposSolicitudPaisLocal tspLocal = null;
		TiposSolicitudLocalHome tsLHome = null;
		TiposSolicitudLocal tsLocal = null;		
		AsignacionAlmacenLocalHome aaLHome = null;
		AsignacionAlmacenLocal aaLocal = null;

        // Obtiene el almacén del tipo de solicitud 
        UtilidadesLog.debug("Obtiene el almacén del tipo de solicitud ");

                tspLHome = new TiposSolicitudPaisLocalHome();
                tsLHome = new TiposSolicitudLocalHome();
                aaLHome = new AsignacionAlmacenLocalHome();

		try  {
			tspLocal = tspLHome.findByPrimaryKey(DTOE.getTipoSolicitud());
			if (tspLocal.getOidAlmacen() != null)  {
                            DTOE.setAlmacen( tspLocal.getOidAlmacen());					
			} else {
			    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                            UtilidadesLog.debug("TipoSolicitud: "+tspLocal.getOidTipoSolicitud());
                             
                            tsLocal = tsLHome.findByPrimaryKey(tspLocal.getOidTipoSolicitud());
                            
			    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("Pais: "+tspLocal.getOidPais()+" - Marca: "+tsLocal.getOidMarca()+" - Subacceso: "+tsLocal.getOidSubacceso());
                              
                            aaLocal = aaLHome.findByUK(tspLocal.getOidPais(), tsLocal.getOidMarca(), tsLocal.getOidSubacceso());				
                            
                            if (aaLocal.getAlmacen() != null)  {
                                DTOE.setAlmacen( aaLocal.getAlmacen());
                            } else {
                                //Agregado BELC300023761
                                String numSolic = DTOE.getNumeroSolicitud();
                                DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), 
                                ErroresNegocio.PED_077, ErroresNegocio.PED_078));                       
                                LogAPP.error( "PED " + CU + " " + DTOE.getMensajeError());
                                DTOE = validacionKO(DTOE);
                                DTOE.setNumeroSolicitud(numSolic);
                                //Fin - Agregado BELC300023761                
                            }				
			}
			
		} catch (NoResultException e) {
                    //Agregado BELC300023761
                    // vbongiov -- 30/10/2006 -- DBLG500001029
                    String numSolic = DTOE.getNumeroSolicitud();
                    DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), 
                    ErroresNegocio.PED_077, ErroresNegocio.PED_078));                       
                    LogAPP.error( "PED " + CU + " " + DTOE.getMensajeError());
                    DTOE = validacionKO(DTOE);
                    DTOE.setNumeroSolicitud(numSolic);
		} catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarAlmacen(DTOCabeceraSolicitud DTOE): Salida ");
        return DTOE;
}
  public DTOCabeceraSolicitud validarFormaPago(DTOCabeceraSolicitud DTOE) 
		throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarFormaPago(DTOCabeceraSolicitud DTOE): Entrada ");
		TiposSolicitudPaisLocalHome tspLHome = null;
		TiposSolicitudPaisLocal tspLocal = null;
		ClienteDatosBasicosLocalHome cdbLHome = null;
		ClienteDatosBasicosLocal cdbLocal = null;
		PaisLocalHome pLHome = null;
		PaisLocal pLocal = null;

		try{
                    UtilidadesLog.debug("Valida la forma de pago de la solicitud ");
                    // Valida la forma de pago de la solicitud 
                    if ( DTOE.getFormaPago() == null) { 
                        tspLHome = new TiposSolicitudPaisLocalHome();
                        UtilidadesLog.debug("Obtiene la forma de pago del tipo de solicitud ");
                        //Obtiene la forma de pago del tipo de solicitud 
                        tspLocal = tspLHome.findByPrimaryKey(DTOE.getTipoSolicitud());
                        if (  tspLocal.getOidFormaPago() != null ){
                            DTOE.setFormaPago( tspLocal.getOidFormaPago()); 
                        } else { 
                            UtilidadesLog.debug("Obtiene la forma de pago del cliente ");
                            // Obtiene la forma de pago del cliente 
                            cdbLHome = new ClienteDatosBasicosLocalHome();
                            cdbLocal = cdbLHome.findByCodigoYPais(DTOE.getOidPais(), DTOE.getCliente());
                            
                            if ( cdbLocal.getFopa_oid_form_pago() != null ){
                                DTOE.setFormaPago(cdbLocal.getFopa_oid_form_pago());
                            }else{ 
                                UtilidadesLog.debug("Obtiene la forma de pago del pais");
                                // Obtiene la forma de pago del pais 
                                pLHome = new PaisLocalHome();
                                pLocal = pLHome.findByPrimaryKey(DTOE.getOidPais());
                                if ( pLocal.getFopa_oid_form_pago() != null ) {
                                    DTOE.setFormaPago( pLocal.getFopa_oid_form_pago() );
                                } else  { // Agregado por BELC300023761                         
                                    String numSolic = DTOE.getNumeroSolicitud();
                                    DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), 
                                    ErroresNegocio.PED_075, ErroresNegocio.PED_076));   
                                    DTOE = validacionKO(DTOE);
                                    DTOE.setNumeroSolicitud(numSolic);                            
                                }
                                //Fin - Agregado por BELC300023761
                            } 
                        } 
                    }
                    
		}catch(NoResultException e){
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}catch(PersistenceException e){
                    ctx.setRollbackOnly();
                    throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarFormaPago(DTOCabeceraSolicitud DTOE): Salida ");
        return DTOE;
    }

    public DTOCabeceraSolicitud validarTipoFacturacion(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarTipoFacturacion(DTOCabeceraSolicitud DTOE): Entrada ");
        
        // Valida el tipo de facturación 
        UtilidadesLog.debug("Valida el tipo de facturación ");
        // Si el canal es venta directa, se establece el esquema de facturación (mono o multifacturación) 
        // Si no, no se hace nada 
		CabeceraGruposZonasLocalHome cgzLHome = null;
		CabeceraGruposZonasLocal cgzLocal = null;
		TipoFacturacionLocalHome tfLHome = null;
		TipoFacturacionLocal tfLocal = null;


        if (  (DTOE.getCanal().longValue() == (new Long(ConstantesSEG.CANAL_VD)).longValue()) && 
			  ((DTOE.getModulo() == null) || (DTOE.getModulo().longValue() == ConstantesPED.MODULO_PEDIDOS.longValue()))
		   ) {



			UtilidadesLog.debug("Esta dentro del if!!!");
			DAOValidaciones daoValidaciones = new DAOValidaciones();
			try{
				MONMantenimientoGruposZonasHome mmgzHome = 
					(MONMantenimientoGruposZonasHome) UtilidadesEJB.getHome(
												"MONMantenimientoGruposZonas",
												MONMantenimientoGruposZonasHome.class);
				MONMantenimientoGruposZonas mmgz = mmgzHome.create();
			
				Long oidGrupoZona = mmgz.obtieneGrupoPMCZ(	DTOE.getOidPais(), 
															DTOE.getMarca(), 
															DTOE.getCanal(),
															DTOE.getZona());

			        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
				  UtilidadesLog.debug("Este es el oidGrupoZOna: " + oidGrupoZona);

				if (oidGrupoZona != null)  {
					cgzLHome = new CabeceraGruposZonasLocalHome();
					tfLHome = new TipoFacturacionLocalHome();
			
					cgzLocal = cgzLHome.findByPrimaryKey(oidGrupoZona);
				        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
					  UtilidadesLog.debug("Este es el TipoFacturacion: " + cgzLocal.getTipoFacturacion());
                                          
					tfLocal = tfLHome.findByPrimaryKey(cgzLocal.getTipoFacturacion());

				        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
					  UtilidadesLog.debug("Este es el tfLocal.getOid(): " + tfLocal.getOid());

					if ( tfLocal.getOid().longValue() == ConstantesCRA.TIPO_FAC_MONO.longValue() ) { 
						DTOE.setIndMasSolicitudes( 
							daoValidaciones.validarSolicitudCliente(
									DTOE.getPeriodo(),
									DTOE.getOidPais(),
									DTOE.getCliente(),
									DTOE.getTipoSolicitud()));
					} 						
				}
				
			}catch(CreateException ce){
                                ctx.setRollbackOnly();
				throw new MareException(ce,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}catch(RemoteException re){
                                ctx.setRollbackOnly();
				throw new MareException(re,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}catch(NoResultException e){
                                ctx.setRollbackOnly();
				throw new MareException(e,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
			}catch(PersistenceException e){
                                ctx.setRollbackOnly();
				throw new MareException(e,
					UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
			}
		}
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarTipoFacturacion(DTOCabeceraSolicitud DTOE): Salida ");
        return DTOE;		
    }


    /**
     * Valida el cronograma.
     * Establece la fecha prevista de facturación.
     */
     /*
      * Autor: Cortaberria
      * Fecha: 13/06/2005
      * Si al obtener el cronograma se produce una excepcion por no entonctrar datos o 
      * retorna null se genera una excecion con codigo ped_028. Incidencia BELC300018056
      */
     public DTOCabeceraSolicitud validarCronograma(DTOCabeceraSolicitud DTOE) throws MareException {
      UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCronograma(DTOCabeceraSolicitud DTOE): Entrada ");
      PeriodoLocalHome pLHome = null;
      PeriodoLocal pLocal = null;
      TiposDespachoLocalHome tdLHome = null;
      TiposDespachoLocal tdLocal = null;
      TiposSolicitudPaisLocalHome tspLHome = null;
      TiposSolicitudPaisLocal tspLocal = null;
      Boolean cronogramaActivo = Boolean.FALSE;
      // Validaciones del cronograma 
      UtilidadesLog.debug("Validaciones del cronograma ");

      try {
        // ---> Comprueba el periodo 
        UtilidadesLog.debug("Comprueba el periodo ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        pLHome = new PeriodoLocalHome();
        pLocal = pLHome.findByPrimaryKey(DTOE.getPeriodo());

        String sFechaCabecera = sdf.format(DTOE.getFecha());
        Date dFechaCabecera = new Date(sdf.parse(sFechaCabecera).getTime())  ;
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("Este es el periodo de la cabecera: " + DTOE.getPeriodo());
          UtilidadesLog.debug("Estatus del periodo: " + pLocal.getStatus());
          UtilidadesLog.debug("Fecha inicio del Periodo: " + pLocal.getFechainicio());
          UtilidadesLog.debug("Fecha fin del Periodo: " + pLocal.getFechaFin());
          UtilidadesLog.debug("Fecha de la cabecera: " + dFechaCabecera);
        }  
        
        //<inicio>Sergio Apaza PER-SiCC-2010-0079 Eliminar Validacion de Cronograma
        /*if ( pLocal.getStatus().booleanValue() == false || 
           (pLocal.getFechainicio().getTime() > dFechaCabecera.getTime()) ||
           (dFechaCabecera.getTime() > pLocal.getFechaFin().getTime())){ 
					UtilidadesLog.debug("validarCronograma ...1 ");			
          
          String numSolic = DTOE.getNumeroSolicitud();
          DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), 
          ErroresNegocio.PED_071, ErroresNegocio.PED_072));                   
          DTOE = validacionKO(DTOE);
          DTOE.setNumeroSolicitud(numSolic);
          return DTOE;
        } */
        //<fin>Sergio Apaza PER-SiCC-2010-0079 Eliminar Validacion de Cronograma

        // ---> Establece la fecha prevista de facturación 
        UtilidadesLog.debug("Establece la fecha prevista de facturación ");
        // Si DTOE.fechaPrevistaFacturacion == null { 
        if ( DTOE.getFechaPrevistaFacturacion() == null ){ 
					UtilidadesLog.debug("validarCronograma ...2 ");						
          Boolean indicadorCronograma = null;
          // Si DTOE.tipoDespacho != null { 
          if (DTOE.getTipoDespacho() != null)  {
  					UtilidadesLog.debug("validarCronograma ...3 ");						
            tdLHome = new TiposDespachoLocalHome();
            tdLocal = tdLHome.findByPrimaryKey(DTOE.getTipoDespacho());
            String tipoDespacho = tdLocal.getTipoDespacho();
            indicadorCronograma = tdLocal.getIndCronograma(); 
            UtilidadesLog.debug("validarCronograma ...4 ");						
        
            // Si indicadorCronograma == True { 
            if (indicadorCronograma.booleanValue() == true) {
              UtilidadesLog.debug("validarCronograma ...5 ");						
              cronogramaActivo = Boolean.TRUE;
            } else {
              UtilidadesLog.debug("validarCronograma ...6 ");						
              // DTOE.fechaPrevistaFacturacion = Fecha del sistema;
              DTOE.setFechaPrevistaFacturacion( new Timestamp(System.currentTimeMillis())); 
            } 
          } else {
            UtilidadesLog.debug("validarCronograma ...7 ");						
            //Si DTOE.tipoDespacho == null
            if (DTOE.getTipoDespacho() == null) {
              UtilidadesLog.debug("validarCronograma ...8 ");						
              cronogramaActivo = Boolean.TRUE;
            }
          }

          //Si cronogramaActivo == True { 
          if (cronogramaActivo.booleanValue()) {
            UtilidadesLog.debug("validarCronograma ...9 ");						
            tspLHome = new TiposSolicitudPaisLocalHome();
            tspLocal = tspLHome.findByPrimaryKey(DTOE.getTipoSolicitud());
            Long actividad = tspLocal.getOidActividad();
            MONCronogramaHome mcHome = (MONCronogramaHome) UtilidadesEJB.getHome("MONCronograma", MONCronogramaHome.class);
            MONCronograma mc = mcHome.create();
            DTOCronogramaFecha dtoCronogramaFecha = new DTOCronogramaFecha();
            try  {
              UtilidadesLog.debug("validarCronograma ...10 ");						
              dtoCronogramaFecha = mc.obtieneFechaInicioCronograma( DTOE.getZona(), DTOE.getPeriodo(), actividad); 
            } catch (MareException me)  {
              if (me.getCode() == Integer.parseInt(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)){
                dtoCronogramaFecha = null;
              } else{
                throw me;
              }
            }
            // Si DTOCronogramaFecha == null { 
            if ( dtoCronogramaFecha == null ) {
              //<inicio>Sergio Apaza PER-SiCC-2010-0015 Modificacion de Determinacion de Fecha Programada de Facturacion
              /*UtilidadesLog.debug("validarCronograma ...11 ");						
              //Agregado BELC300023761
              String numSolic = DTOE.getNumeroSolicitud();
              DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), 
              ErroresNegocio.PED_073, ErroresNegocio.PED_074));   
			  DTOE = validacionKO(DTOE);
              DTOE.setNumeroSolicitud(numSolic);
              //Fin - Agregado BELC300023761
              return DTOE;*/

              UtilidadesLog.debug("validarCronograma ...11 - seleccionando FechaPrevistaFacturacio");
              Calendar cal = Calendar.getInstance();              
              cal.add(Calendar.DATE, 1);
              
              Long fechaHoraActualMasUnDia = cal.getTime().getTime();

              if (pLocal.getFechaFin().getTime()>=fechaHoraActualMasUnDia){ 
                  DTOE.setFechaPrevistaFacturacion(new Timestamp(pLocal.getFechaFin().getTime()));   
              }
              else {
                DTOE.setFechaPrevistaFacturacion(new Timestamp(fechaHoraActualMasUnDia));   
              }
              //<fin>Sergio Apaza PER-SiCC-2010-0015 Modificacion de Determinacion de Fecha Programada de Facturacion
                
              //throw new MareException(new Exception(),UtilidadesError.armarCodigoError(
                //ErroresNegocio.PED_028));
            } else { 
              UtilidadesLog.debug("validarCronograma ...12 ");						
              DTOE.setFechaPrevistaFacturacion(dtoCronogramaFecha.getFechaIni()); 
            } 
          }
        } 

        // DTOE.fecha = fecha del sistema 
        DTOE.setFecha( new java.sql.Date(System.currentTimeMillis())); 
        UtilidadesLog.debug("validarCronograma ...13 ");						
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCronograma(DTOCabeceraSolicitud DTOE): Salida ");
        return DTOE;	
        
      }catch(NoResultException e){
          ctx.setRollbackOnly();
          throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }catch(PersistenceException e){
          ctx.setRollbackOnly();
          throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }catch(CreateException ce){
          ctx.setRollbackOnly();
          throw new MareException(ce,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }catch(RemoteException re){
          ctx.setRollbackOnly();
          throw new MareException(re,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }catch(Exception e){
          ctx.setRollbackOnly();
          throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }




/**

			// Establece la fecha prevista de facturación
			if ( DTOE.getFechaPrevistaFacturacion() == null ){ 
				Boolean indicadorCronograma = null;
				if (DTOE.getTipoDespacho() != null)  {
					tdLHome = getTiposDespachoLocalHome();
					tdLocal = tdLHome.findByPrimaryKey(DTOE.getTipoDespacho());
					indicadorCronograma = tdLocal.getIndCronograma(); 
					System.out.println("validarCronograma ...1 ");						
				}
				
				if (DTOE.getTipoDespacho() == null || indicadorCronograma.booleanValue() == true){ 
					System.out.println("validarCronograma ...2 ");
					tspLHome = getTiposSolicitudPaisLocalHome();
					tspLocal = tspLHome.findByPrimaryKey(DTOE.getTipoSolicitud());
					System.out.println("validarCronograma ...3 ");
					Long actividad = tspLocal.getOidActividad();
					System.out.println("validarCronograma ...4 ");

					MONCronogramaHome mcHome = 
						(MONCronogramaHome) UtilidadesEJB.getHome(
													"MONCronograma",
													MONCronogramaHome.class);
					MONCronograma mc = mcHome.create();
					System.out.println("validarCronograma ...5 ");
					DTOCronogramaFecha dtoCronogramaFecha = new DTOCronogramaFecha();
					try  {
						
						dtoCronogramaFecha = mc.obtieneFechaInicioCronograma( DTOE.getZona(), 
																						DTOE.getPeriodo(), 
																						actividad); 
					} catch (MareException me)  {
						if (me.getCode() == Integer.parseInt(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)){
							DTOE = validacionKO(DTOE);
							return DTOE;						
						} else{
							throw me;
						}
					}

					System.out.println("validarCronograma ...6 ");
					String sFechaSistema = sdf.format(new Date(System.currentTimeMillis()));
					long lFechaSistema = sdf.parse(sFechaSistema).getTime();

                    //  se elimina validacion sobre de la fecha de fin, segun incidencia 11261.
					if (dtoCronogramaFecha != null){
						System.out.println("validarCronograma ...7 ");
                        // si la fecha de inicio de la actividad recuperado es diferente de NULL entonces
    					if ( dtoCronogramaFecha.getFechaIni() != null ) { 
							System.out.println("validarCronograma ...8 ");
                            // si la fecha de inicio de la actividad es menor a la fecha de hoy
							if ( dtoCronogramaFecha.getFechaIni().getTime() < lFechaSistema){
								System.out.println("validarCronograma ...9 ");
                                // a la fecha prevista de facturacion le ponemos la fecha de hoy (dado que la la actividad de facturacion ya paso)
								DTOE.setFechaPrevistaFacturacion( new Timestamp( System.currentTimeMillis()));	
							}else{  
                                // a la fecha prevista de facturacion le asignamo la fecha de inicio de la actividad 
								System.out.println("validarCronograma ...10 ");
								DTOE.setFechaPrevistaFacturacion( dtoCronogramaFecha.getFechaIni() );
							}
						} else { 
							System.out.println("validarCronograma ...11 ");
							DTOE = validacionKO(DTOE);
							return DTOE;
						} 
					} else {
						System.out.println("validarCronograma ...12 ");
						throw new MareException(null,null,
							UtilidadesError.armarCodigoError(
							ConstantesSEG.MODULO_PED + ErroresNegocio.PED_028));
					}
				} else {
					System.out.println("validarCronograma ...13 ");
					DTOE.setFechaPrevistaFacturacion(  new Timestamp(System.currentTimeMillis())); 
				}
			} 

//			System.out.println("validarCronograma ...14 ");
//			DTOE.setFecha( new java.sql.Date(System.currentTimeMillis())); 


*/
    }
     public DTOCabeceraSolicitud validarZona(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarZona(DTOCabeceraSolicitud DTOE): Entrada ");
        // Comprueba si la zona está activa 
        UtilidadesLog.debug("Comprueba si la zona está activa ");
		ZonaLocalHome zLHome = null;
		ZonaLocal zLocal = null;

		try{
			zLHome = new ZonaLocalHome();
			zLocal = zLHome.findByPrimaryKey(DTOE.getZona()); 

			if (zLocal.getActiva().intValue() == 0){
                //Agregado BELC300023761
                String numSolic = DTOE.getNumeroSolicitud();
                DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), 
                ErroresNegocio.PED_069, ErroresNegocio.PED_070));   
				DTOE = validacionKO(DTOE);
                DTOE.setNumeroSolicitud(numSolic);
                //Fin - Agregado BELC300023761
			}
            
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarZona(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}
        catch(NoResultException e){
            ctx.setRollbackOnly();
            throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
        catch(PersistenceException e){
            ctx.setRollbackOnly();
            throw new MareException(e,
			UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
    }
    public DTOCabeceraSolicitud validarMoneda(DTOCabeceraSolicitud DTOE) 
		throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarMoneda(DTOCabeceraSolicitud DTOE): Entrada ");
		CabeceraMFLocalHome cMFLHome = null;
		CabeceraMFLocal cMFLocal = null;

        // Validación de la moneda de la solicitud 

        // Obtenemos la moneda del tipo de solicitud por pais 
        // En primer lugar valida el acceso 

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" Validación de la moneda de la solicitud ");
          UtilidadesLog.debug("                                           ");
          UtilidadesLog.debug(" Obtenemos la moneda del tipo de solicitud por pais ");
          UtilidadesLog.debug(" En primer lugar valida el acceso ");
        }  

		try{
			Boolean acceso = validarAcceso(DTOE.getTipoSolicitud());
			Long monedaTipoSolicitud = null;
		
			if ( acceso.booleanValue() == false || 
				 DTOE.getModulo() != ConstantesPED.MODULO_RECLAMOS){ 
				DAOValidaciones daoValidaciones = new DAOValidaciones();
				monedaTipoSolicitud = daoValidaciones.obtenerMonedaTipoSolicitud(DTOE.getTipoSolicitud());
			} 
      
      /**
       * Cortaberria
       * 22/02/2005
       * Compraba objetos Long con ==
       */
			if ( 	DTOE.getModulo() == null || 
					!DTOE.getModulo().equals(ConstantesPED.MODULO_RECLAMOS) ){ 

				// Obtenemos la moneda y el tipo de cambio de la matriz de facturación para el periodo indicado 
                UtilidadesLog.debug("Obtenemos la moneda y el tipo de cambio de la matriz de facturación para el periodo indicado ");
				cMFLHome = new CabeceraMFLocalHome();

				cMFLocal = cMFLHome.findByUK(DTOE.getPeriodo());
				Long monedaMF = cMFLocal.getMoneda();
				Double tipoCambioMF = cMFLocal.getTipoCambio();

			        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
				  UtilidadesLog.debug("Este es el acceso: " + acceso);
				  UtilidadesLog.debug("Esta es la monedaTipoSolicitud: " + monedaTipoSolicitud);
				  UtilidadesLog.debug("Esta es la monedaMF: " + monedaMF);
                                }  

				if (monedaTipoSolicitud == null){

					if (monedaMF == null){
						DTOE.setMoneda( null );
						DTOE.setTipoCambio( new Double(1) );
					}else{
                        //Agregado por BELC300023761
                        String numSolic = DTOE.getNumeroSolicitud();
                        DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_067, 
                        ErroresNegocio.PED_068));                           
                        LogAPP.error( "PED " + CU + " " + DTOE.getMensajeError());						                       
                        DTOE = validacionKO(DTOE);
                        DTOE.setNumeroSolicitud(numSolic);
                        //Fin - Agregado por BELC300023761
                        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarMoneda(DTOCabeceraSolicitud DTOE): Salida ");
						return DTOE;
					} 
				}else{ 
					if ( monedaMF != null ){
						DTOE.setMoneda( monedaMF );
						DTOE.setTipoCambio( tipoCambioMF );
					} else { 
                        //Agregado por BELC300023761
                        String numSolic = DTOE.getNumeroSolicitud();
                        DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_067, 
                        ErroresNegocio.PED_068));                           
                        LogAPP.error( "PED " + CU + " " + DTOE.getMensajeError());						                       
                        DTOE = validacionKO(DTOE);
                        DTOE.setNumeroSolicitud(numSolic);
                        //Fin - Agregado por BELC300023761               
                        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarMoneda(DTOCabeceraSolicitud DTOE): Salida ");
						return DTOE;
					} 
				} 
			} 
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarMoneda(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
			
		}catch(NoResultException e){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Excepcion: ", e);
                    throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresNegocio.PED_032));
		}catch(PersistenceException e){
		    ctx.setRollbackOnly();
		    UtilidadesLog.error("Excepcion: ", e);
                    throw new MareException(e,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
    }
    

    public DTOCabeceraSolicitud validarCliente(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Entrada ");
		
        // Valida la información del cliente
        UtilidadesLog.debug("Valida la información del cliente");
        String cliente = DTOE.getCliente(); 
        Long marca = DTOE.getMarca();
        Long pais = DTOE.getOidPais(); 
        Long periodo = DTOE.getPeriodo(); 

        // Comprobar si existe el cliente 
        UtilidadesLog.debug("Comprobar si existe el cliente ");
    		      
        if (DTOE.getOidCliente() != null){
            UtilidadesLog.debug("El oidCliente es diferente de null ");
            DTOE.setCliente(this.validarOidCliente(DTOE.getOidCliente()));
            if (DTOE.getCliente() == null){
                UtilidadesLog.debug("No se encontro el oid de cliente en ClienteDatosBasicos ");
                              //Agregado por BELC300023761
              String numSolic = DTOE.getNumeroSolicitud();
              DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_082, 
              ErroresNegocio.PED_056));   
              //Fin - Agregado por BELC300023761
              DTOE = validacionKO(DTOE);
              DTOE.setNumeroSolicitud(numSolic);
              UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
              return DTOE;               
            }
        } else {
             UtilidadesLog.debug("El oidCliente es igual a null ");
             DTOE.setOidCliente(this.obtenerOidCliente(pais, cliente));
             if (DTOE.getOidCliente() == null){
                UtilidadesLog.debug("No se encontro el codigo y pais en la entidad ClienteDatosBasicos ");
                             //Agregado por BELC300023761
              String numSolic = DTOE.getNumeroSolicitud();
              DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_082, 
              ErroresNegocio.PED_056));   
              //Fin - Agregado por BELC300023761
              DTOE = validacionKO(DTOE);
              DTOE.setNumeroSolicitud(numSolic);
              UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
              return DTOE;
             }
        }      
        
        UtilidadesLog.debug("Comprobar si la marca del cliente es compatible con la marca de la solicitud");            
        Long marcaCliente = this.validarMarcaCliente(DTOE.getOidCliente(), marca);
        
        if (marcaCliente == null ) {
          DTOE = validacionKO(DTOE);
          UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
          return DTOE;
        } 
        
  // Comprobar Receptor factura 
        UtilidadesLog.debug("Comprobar Receptor factura ");
        if ( DTOE.getCliente() != null &&   !(DTOE.getCliente().equals(DTOE.getReceptorFactura())) ){ 
            if (DTOE.getReceptorFactura() == null || DTOE.getReceptorFactura().equals("") ){ 
                DTOE.setReceptorFactura( DTOE.getCliente() ); 
                DTOE.setOidReceptorFactura( DTOE.getOidCliente() ); 
            } else { 
                DTOE.setOidReceptorFactura(this.obtenerOidCliente(pais, DTOE.getReceptorFactura()));
                if (DTOE.getOidReceptorFactura() == null) {
                   //Agregado por BELC300023761
                    String numSolic = DTOE.getNumeroSolicitud();
                    DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_057, 
                    ErroresNegocio.PED_058));   
                    //Fin - Agregado por BELC300023761
                    DTOE = validacionKO(DTOE);
                    DTOE.setNumeroSolicitud(numSolic);
                    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
                    return DTOE;
                }
            }
        } else {
          if(DTOE.getReceptorFactura() == null || DTOE.getOidReceptorFactura() == null || DTOE.getCliente().equals(DTOE.getReceptorFactura())) {
              DTOE.setReceptorFactura(DTOE.getCliente());
              DTOE.setOidReceptorFactura(DTOE.getOidCliente());
          }
          if (DTOE.getOidReceptorFactura() != null && !DTOE.getOidReceptorFactura().equals(DTOE.getOidCliente())){
              if (this.validarOidCliente(DTOE.getOidCliente()) == null){
                  UtilidadesLog.debug("No se encontro el oid de Receptor de Factura en ClienteDatosBasicos ");
                  //Agregado por BELC300023761
                    String numSolic = DTOE.getNumeroSolicitud();
                    DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_059, 
                    ErroresNegocio.PED_058));   
                    //Fin - Agregado por BELC300023761
                    DTOE = validacionKO(DTOE);
                    DTOE.setNumeroSolicitud(numSolic);
                    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");

                  return DTOE;
              }
          }
      }
  
      // Comprobar Pagador factura 
      UtilidadesLog.debug("Comprobar Pagador factura ");
      if (DTOE.getCliente() != null  &&  !(DTOE.getCliente().equals( DTOE.getPagadorFactura() ))){ 
          if ( DTOE.getPagadorFactura() == null || DTOE.getPagadorFactura().equals("")){ 
              DTOE.setPagadorFactura( DTOE.getCliente() ); 
              DTOE.setOidPagadorFactura( DTOE.getOidCliente() ); 
          } else { 
              DTOE.setOidPagadorFactura(this.obtenerOidCliente(pais, DTOE.getPagadorFactura()));
              if (DTOE.getOidPagadorFactura() == null) {
                  //Agregado por BELC300023761
                    String numSolic = DTOE.getNumeroSolicitud();
                    DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_059, ErroresNegocio.PED_060));   
                    //Fin - Agregado por BELC300023761
                    DTOE = validacionKO(DTOE);
                    DTOE.setNumeroSolicitud(numSolic);
                    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
                return DTOE;
              }
          } 
      } else {
          if(DTOE.getPagadorFactura() == null || DTOE.getOidPagadorFactura() == null || DTOE.getCliente().equals(DTOE.getPagadorFactura())) {
              DTOE.setPagadorFactura(DTOE.getCliente());
              DTOE.setOidPagadorFactura(DTOE.getOidCliente());
          }
          if (DTOE.getOidPagadorFactura() != null && !DTOE.getOidPagadorFactura().equals(DTOE.getOidCliente())) {// DTOE.getOidCliente() != DTOE.getOidPagadorFactura()){
              if (this.validarOidCliente(DTOE.getOidPagadorFactura()) == null){
                  UtilidadesLog.debug("No se encontro el oid de Pagador Factoura en ClienteDatosBasicos ");
                  //Agregado por BELC300023761
                  String numSolic = DTOE.getNumeroSolicitud();
                  DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_059, 
                  ErroresNegocio.PED_060));   
                  //Fin - Agregado por BELC300023761
                  DTOE = validacionKO(DTOE);
                  DTOE.setNumeroSolicitud(numSolic);
                  UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
                  return DTOE;
              }
          }       
      }

      // Consultora de referencia 
      if (DTOE.getCodigoConsultoraAsociada() != null && !DTOE.getCodigoConsultoraAsociada().equals(""))  {
          DTOE.setConsultoraAsociada(this.obtenerOidCliente(pais, DTOE.getCodigoConsultoraAsociada()));
          if (DTOE.getConsultoraAsociada() == null){
                   //Agregado por BELC300023761
            String numSolic = DTOE.getNumeroSolicitud();
            DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_061, 
            ErroresNegocio.PED_062));   
            //Fin - Agregado por BELC300023761
            DTOE = validacionKO(DTOE);
            DTOE.setNumeroSolicitud(numSolic);
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
             return DTOE;
          }
      }
  
      //jrivas 16/07/2008  20080652 Se quita la validación cliente activo
      // Comprobar si el cliente esta activo y no esta bloqueado 
      /*UtilidadesLog.debug("Comprobar si el cliente esta activo y no esta bloqueado ");
      if (this.validarIndActivoCliente(DTOE.getOidCliente()).booleanValue() == false){
        UtilidadesLog.debug("El Cliente no se encuentra Activo ");
        //Agregado por BELC300023761
        // vbongiov -- 30/10/2006 -- DBLG500001029           
        String numSolic = DTOE.getNumeroSolicitud();
        DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_083, 
        ErroresNegocio.PED_084));   
        //Fin - Agregado por BELC300023761
        DTOE = validacionKO(DTOE);
        DTOE.setNumeroSolicitud(numSolic);
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
        return DTOE;
      }*/
      
      //Gacevedo. Se anula la validacion de bloqueo de cliente
      //segun pedido de cambio SICC 20070279
      
      /*if (this.validarBloqueoCliente(DTOE.getOidCliente()).booleanValue() == false){
        UtilidadesLog.debug("El Cliente esta bloqueado ");
        //Agregado por BELC300023761
        // vbongiov -- 30/10/2006 -- DBLG500001029
        String numSolic = DTOE.getNumeroSolicitud();
        DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_063, 
        ErroresNegocio.PED_064));   
        //Fin - Agregado por BELC300023761
        DTOE = validacionKO(DTOE);
        DTOE.setNumeroSolicitud(numSolic);
     
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
        return DTOE;          
      }*/
      
      // Obtener subtipo cliente
      UtilidadesLog.debug("Obtener subtipo cliente ");
      DTOE.setSubtipoCliente(this.validarSubtipoCliente(DTOE.getOidCliente(), DTOE.getTipoCliente()));
      if (DTOE.getSubtipoCliente()== null){
        // vbongiov -- 30/10/2006 -- DBLG500001029
        String numSolic = DTOE.getNumeroSolicitud();
        DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_083, 
        ErroresNegocio.PED_084));   
        DTOE = validacionKO(DTOE);
        DTOE.setNumeroSolicitud(numSolic);
        
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
        return DTOE;
      }
      
      // Comprobar Unidad Administrativa del cliente
      UtilidadesLog.debug("Comprobar Unidad Administrativa del cliente");
      DTOUnidadAdministrativa dtoUAdm = this.obtenerUnidadAdministrativa(DTOE.getOidCliente(), periodo);
      
      UtilidadesLog.debug("dtoUAdm" + dtoUAdm);
      
      if ( dtoUAdm != null ){
        UtilidadesLog.debug("estoy aca dtoUAdm" );      
        DTOE.setSubgerencia( dtoUAdm.getOidSGV() ); 
        DTOE.setRegion( dtoUAdm.getOidRegion() ); 
        DTOE.setZona( dtoUAdm.getOidZona() ); 
        DTOE.setSeccion( dtoUAdm.getOidSeccion() ); 
        DTOE.setTerritorio( dtoUAdm.getOidTerritorio() ); 
        DTOE.setOidTerritorioAdministrativo(dtoUAdm.getOidTerritorioAdministrativo());
      } else { 
             //Agregado por BELC300023761
        UtilidadesLog.debug("es null dtoUAdm" );
        String numSolic = DTOE.getNumeroSolicitud();
        DTOE.setMensajeError(armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_065, 
        ErroresNegocio.PED_066));   
        //Fin - Agregado por BELC300023761
        DTOE = validacionKO(DTOE);
        DTOE.setNumeroSolicitud(numSolic);
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
           return DTOE;
      } 

			// Recuperar el UBIGEO del cliente 
      UtilidadesLog.debug("Recuperar el UBIGEO del cliente ");
      DTOE.setUbigeo(this.obtenerUbigeo(DTOE.getOidCliente()));
      if (DTOE.getUbigeo() == null) {
        DTOE = validacionKO(DTOE);
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
				return DTOE;
      }
		
      UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarCliente(DTOCabeceraSolicitud DTOE) : Salida ");
      return DTOE;
  }

    public DTOCabeceraSolicitud validarSecuenciaProcesos(DTOCabeceraSolicitud DTOE) 
		throws MareException {
		        //Agregado por BELC300023761
        String mensajeError = "";
        //Fin Agregado por BELC300023761
        

        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSecuenciaProcesos(DTOCabeceraSolicitud DTOE) : Entrada ");
	//	ClienteDatosBasicosLocalHome cdbLHome = null;
	//	ClienteDatosBasicosLocal cdbLocal = null;

	if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          // Valida la secuencia de procesos 
          UtilidadesLog.debug("Valida la secuencia de procesos ");

          // En primer lugar valida el acceso 
          UtilidadesLog.debug("En primer lugar valida el acceso ");
        }
        
        Boolean acceso = validarAcceso(DTOE.getTipoSolicitud());

        if (acceso.booleanValue() == false ){
          UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSecuenciaProcesos(DTOCabeceraSolicitud DTOE) : Salida ");
          return DTOE;
        }

        // Se comprueba que el proceso esta definido para el tipo de solicitud 
        UtilidadesLog.debug("Se comprueba que el proceso esta definido para el tipo de solicitud ");
        Long tipoSolicitud = DTOE.getTipoSolicitud(); 
        Long proceso = DTOE.getProceso();

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                       
          UtilidadesLog.debug("Este es el tipoSolicitud: " + tipoSolicitud);            
          UtilidadesLog.debug("Este es el proceso: " + proceso);            
            
          UtilidadesLog.debug("Creo la entidad... ");
        } 
        
        Long cliente = null;            
        if (DTOE.getOidCliente()==null){
            cliente = this.obtenerOidCliente(DTOE.getOidPais(), DTOE.getCliente());
        }else{
            cliente = DTOE.getOidCliente();
        }

        DAOValidaciones daoValidaciones = new DAOValidaciones();
        Boolean OK = daoValidaciones.validarProceso(tipoSolicitud, ConstantesPED.GP1, proceso);
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("Antes de entrar al if...");

          UtilidadesLog.debug("Este es el OK: " + OK.booleanValue());
        }  
        
        if (OK.booleanValue() == true){
            long fecha1 = System.currentTimeMillis();
            long fecha2 = System.currentTimeMillis() - CONSTANTE_DIA;

            // Si el proceso es "digitacion" y en la secuencia de procesos se encuentra "registro" 
            UtilidadesLog.debug("Si el proceso es digitacion y en la secuencia de procesos se encuentra registro ");
            if (proceso.longValue() == ConstantesProcesosPED.DIGITAR_SOLICITUD.longValue() && 
                daoValidaciones.validarProceso(tipoSolicitud, ConstantesPED.GP1, ConstantesProcesosPED.REGISTRAR_SOLICITUD).booleanValue()){ 

            // Verificar que la solicitud se ha registrado previamente 
                UtilidadesLog.debug("Verificar que la solicitud se ha registrado previamente ");
                OK = daoValidaciones.validarRegistroSolicitud(	cliente, 1, 0, new Date(fecha1), new Date(fecha2) );
                mensajeError = armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_051, 
                    ErroresNegocio.PED_052);    

            } else {
            // Si el proceso es "validar" y en la secuencia de procesos se encuentra "digitacion" 
                UtilidadesLog.debug("Si el proceso es validar y en la secuencia de procesos se encuentra digitacion ");
                if ( (proceso.longValue() == ConstantesProcesosPED.VERIFICAR_SOLICITUD.longValue()) && 
                   daoValidaciones.validarProceso(tipoSolicitud, ConstantesPED.GP1, ConstantesProcesosPED.DIGITAR_SOLICITUD).booleanValue() &&
                   daoValidaciones.validarProceso(tipoSolicitud, ConstantesPED.GP1, ConstantesProcesosPED.REGISTRAR_SOLICITUD).booleanValue()) { 

                  // Verificar que la solicitud se ha digitado previamente 
                              UtilidadesLog.debug("Verificar que la solicitud se ha digitado previamente ");
                  OK = daoValidaciones.validarRegistroSolicitud( cliente, 1, 1, new Date(fecha1), new Date(fecha2));
                                          //Agregado por BELC300023761    
                        mensajeError = armarMensajeError(DTOE.getNumeroSolicitud(), ErroresNegocio.PED_053, 
                        ErroresNegocio.PED_054);    
                        //Fin - Agregado por BELC300023761

                }
            }
        }

        if (OK.booleanValue() == false) {
                 //Agregado por BELC300023761    
                DTOE.setMensajeError(mensajeError);
                String numSolic = DTOE.getNumeroSolicitud();
                //Fin - Agregado por BELC300023761    
                DTOE = validacionKO(DTOE);
                DTOE.setNumeroSolicitud(numSolic);
        }
        
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSecuenciaProcesos(DTOCabeceraSolicitud DTOE) : Salida ");
        return DTOE;
    }

    public DTOCabeceraSolicitud validarSolicitud(DTOCabeceraSolicitud DTOE) throws MareException {
        // Realiza las validaciones generales a una solicitud 

        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Entrada ");
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("Este es el DTO que recibo:  " + DTOE);
          // Inicial la validación 
          UtilidadesLog.debug("Inicial la validación ");
        }  
        DTOE = validacionOK(DTOE);


        // SECUENCIA DE PROCESOS 
        UtilidadesLog.debug("SECUENCIA DE PROCESOS");
        DTOE = validarSecuenciaProcesos(DTOE);
        if (DTOE.getOK().booleanValue() == false){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}

        // CLIENTE 
        UtilidadesLog.debug("CLIENTE ");
        DTOE = validarCliente(DTOE);
        if (DTOE.getOK().booleanValue() == false){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}


        // MONEDA 
        UtilidadesLog.debug("MONEDA ");
        DTOE = validarMoneda(DTOE);
        if (DTOE.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}

        // ZONA 
        UtilidadesLog.debug("ZONA ");
        DTOE = validarZona(DTOE);
        if (DTOE.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}


        // CRONOGRAMA 
        UtilidadesLog.debug("CRONOGRAMA ");
        DTOE = validarCronograma(DTOE);
        if (DTOE.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}


        // TIPO FACTURACION 
        UtilidadesLog.debug("TIPO FACTURACION");
        DTOE = validarTipoFacturacion(DTOE);
        if (DTOE.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}


        // FORMA PAGO 
        UtilidadesLog.debug("FORMA PAGO ");
        DTOE = validarFormaPago(DTOE);
        if (DTOE.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}


        // ALMACEN 
        UtilidadesLog.debug("ALMACEN ");
        DTOE = validarAlmacen(DTOE);
        if (DTOE.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}


        // TIPO SOLICITUD 
        UtilidadesLog.debug("TIPO SOLICITUD ");
        DTOE = validarTipoSolicitud(DTOE);
        if (DTOE.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}
        
        //jrivas 16/07/2007 FAC-003
        UtilidadesLog.debug("TIPO PROGRAMA ");
        DTOE = validarTipoPrograma(DTOE);


        // SUBACCESO 
        UtilidadesLog.debug("SUBACCESO ");
        DTOE = validarSubacceso(DTOE);
        if (DTOE.getOK().booleanValue() == false ){
            UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
			return DTOE;
		}


        // USUARIO 
        UtilidadesLog.debug("USUARIO");
        DTOE.setUsuario( ctx.getCallerPrincipal().getName() );
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSolicitud(DTOCabeceraSolicitud DTOE): Salida ");
        return DTOE;
    }


    private Long validarMarcaCliente(Long oidCliente, Long marca) throws MareException {
    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarMarcaCliente(Long oidCliente, Long marca): Entrada ");
    StringBuffer query = new StringBuffer();
    RecordSet rs;
    
    query.append(" SELECT MARC_OID_MARC ");
    query.append(" FROM MAE_CLIEN_MARCA ");
    query.append(" WHERE CLIE_OID_CLIE = " + oidCliente );  
    query.append("    AND MARC_OID_MARC = " + marca );
  
    rs = this.executeQuery(query.toString());
    Long oidMarca = null;
        
    if (!rs.esVacio()){
        oidMarca = this.bigDecimalToLong(rs.getValueAt(0,"MARC_OID_MARC")); 
    }
    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarMarcaCliente(Long oidCliente, Long marca): Salida ");
    return oidMarca;
  }
  
  private Boolean validarIndActivoCliente(Long oidCliente) throws MareException {
    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarIndActivoCliente(Long oidCliente): Entrada ");
    StringBuffer query = new StringBuffer();
    RecordSet rs;
    
    query.append(" SELECT CLIE_OID_CLIE ");
    query.append(" FROM MAE_CLIEN_DATOS_ADICI MDA ");
    query.append(" WHERE MDA.CLIE_OID_CLIE = " + oidCliente );
	  query.append(" AND MDA.IND_ACTI = 1 ");
    
    rs = this.executeQuery(query.toString());
    Boolean indActivoOK = Boolean.FALSE; 
        
    if (!rs.esVacio()){
       indActivoOK = Boolean.TRUE;
    }
    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarIndActivoCliente(Long oidCliente): Salida ");
    return indActivoOK;
  }
  
  private Boolean validarBloqueoCliente(Long oidCliente) throws MareException {
    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarBloqueoCliente(Long oidCliente): Entrada ");
    StringBuffer query = new StringBuffer();
    RecordSet rs;
    
    query.append(" SELECT MTB.COD_TIPO_BLOQ ");
    query.append(" FROM MAE_CLIEN_BLOQU MCB, ");
    query.append("      MAE_TIPO_BLOQU MTB ");
    query.append(" WHERE MCB.TIBQ_OID_TIPO_BLOQ = MTB.OID_TIPO_BLOQ ");
	  query.append("   AND MCB.CLIE_OID_CLIE = " + oidCliente);
	  query.append("   AND MTB.COD_TIPO_BLOQ IN ('" + ConstantesMAE.BLOQUEO_FINANCIERO + "','" + ConstantesMAE.BLOQUEO_ADMINISTRATIVO + "')");

    rs = this.executeQuery(query.toString());
    Boolean indBloqueoOK = Boolean.TRUE; 
        
    if (!rs.esVacio()){
       if (this.objectToString(rs.getValueAt(0,"COD_TIPO_BLOQ")).equals(ConstantesMAE.BLOQUEO_FINANCIERO)){
          UtilidadesLog.debug("Cliente con Bloqueo Financiero");
       } else {
          if (this.objectToString(rs.getValueAt(0,"COD_TIPO_BLOQ")).equals(ConstantesMAE.BLOQUEO_ADMINISTRATIVO)){
              UtilidadesLog.debug("Cliente con Bloqueo Administrativo");
          }
       }
       indBloqueoOK = Boolean.FALSE;
    }
    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarBloqueoCliente(Long oidCliente): Salida ");
    return indBloqueoOK;
  }
  
  private Long validarSubtipoCliente(Long oidCliente, Long oidTipoCliente) throws MareException{
     UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSubtipoCliente(Long oidCliente, Long oidTipoCliente): Entrada ");
    StringBuffer query = new StringBuffer();
    RecordSet rs;
    
    query.append(" SELECT SBTI_OID_SUBT_CLIE ");
    query.append(" FROM MAE_CLIEN_TIPO_SUBTI ");
    query.append(" WHERE CLIE_OID_CLIE = " + oidCliente);
	  query.append(" AND TICL_OID_TIPO_CLIE = " + oidTipoCliente); 
  
    rs = this.executeQuery(query.toString());
    Long oidSubtipoCliente = null;
        
    if (!rs.esVacio()){
        oidSubtipoCliente = this.bigDecimalToLong(rs.getValueAt(0,"SBTI_OID_SUBT_CLIE")); 
    }
    UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarSubtipoCliente(Long oidCliente, Long oidTipoCliente): Salida ");
    return oidSubtipoCliente;  
  }
  
  
  private DTOUnidadAdministrativa obtenerUnidadAdministrativa(Long cliente, Long periodo) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.obtenerUnidadAdministrativa(cliente, periodo): Entrada"); 
        RecordSet resultado;
        DTOUnidadAdministrativa dtoS = null;
        StringBuffer query = new StringBuffer();

        /*query.append(" SELECT distinct OID_SUBG_VENT,   ");
        query.append(" OID_REGI, OID_ZONA, OID_SECC, TERR_OID_TERR,  ");
        query.append(" OID_TERR_ADMI, pi.FEC_INIC ");
        query.append(" FROM MAE_CLIEN_UNIDA_ADMIN unid,  ");
        query.append("   ZON_TERRI_ADMIN tadm,    ");
        query.append(" 	 ZON_TERRI t,   ");
        query.append(" 	 ZON_SECCI,   ");
        query.append(" 	 ZON_ZONA,    ");
        query.append(" 	 ZON_REGIO,  ");
        query.append(" 	 ZON_SUB_GEREN_VENTA sub,  ");
        query.append("   CRA_PERIO pi,   ");
        query.append(" 	 CRA_PERIO pi2  ");
        query.append(" WHERE  ");
        query.append(" unid.CLIE_OID_CLIE = " + cliente);
        //pzerbino 18/10/2006 DBLG700000136
        query.append(" AND unid.IND_ACTI = 1  ");
        
        query.append(" AND ZTAD_OID_TERR_ADMI = OID_TERR_ADMI  ");
        query.append(" AND TERR_OID_TERR = OID_TERR  ");
        query.append(" AND ZSCC_OID_SECC = OID_SECC  ");
        query.append(" AND ZZON_OID_ZONA= OID_ZONA  ");
        query.append(" AND ZORG_OID_REGI = OID_REGI  ");
        query.append(" AND ZSGV_OID_SUBG_VENT = OID_SUBG_VENT   ");
        query.append(" AND unid.PERD_OID_PERI_INI = pi.OID_PERI  ");
        query.append(" AND pi.FEC_INIC <= (SELECT FEC_INIC FROM CRA_PERIO WHERE OID_PERI = " + periodo + ")");
        query.append(" AND ((unid.PERD_OID_PERI_FIN = pi2.OID_PERI   ");
        query.append("     AND pi2.FEC_FINA >= (SELECT FEC_FINA FROM CRA_PERIO WHERE OID_PERI = " + periodo + "))");
        query.append(" OR unid.PERD_OID_PERI_FIN is NULL)  ");
        query.append(" order by pi.FEC_INIC desc  ");*/
        
        // sapaza -- PER-SiCC-2013-0608 -- 03/06/2013
        query.append(" SELECT distinct sub.OID_SUBG_VENT, reg.OID_REGI, zon.OID_ZONA, ");
        query.append("        sec.OID_SECC, tadm.TERR_OID_TERR, tadm.OID_TERR_ADMI ");        
        query.append("   FROM MAE_CLIEN_UNIDA_ADMIN unid, "); 
        query.append("        ZON_TERRI_ADMIN tadm, "); 
        query.append("        ZON_TERRI ter, "); 
        query.append("        ZON_SECCI sec, "); 
        query.append("        ZON_ZONA zon, "); 
        query.append("        ZON_REGIO reg, "); 
        query.append("        ZON_SUB_GEREN_VENTA sub "); 
        query.append("  WHERE unid.CLIE_OID_CLIE = " + cliente); 
        query.append("    AND unid.ZTAD_OID_TERR_ADMI = tadm.OID_TERR_ADMI "); 
        query.append("    AND tadm.TERR_OID_TERR = ter.OID_TERR "); 
        query.append("    AND tadm.ZSCC_OID_SECC = sec.OID_SECC "); 
        query.append("    AND sec.ZZON_OID_ZONA = zon.OID_ZONA "); 
        query.append("    AND zon.ZORG_OID_REGI = reg.OID_REGI "); 
        query.append("    AND reg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT "); 
        query.append("    AND unid.PERD_OID_PERI_FIN is NULL "); 
        
        resultado = this.executeQuery(query.toString());

        if (!resultado.esVacio()) {
            dtoS = new DTOUnidadAdministrativa();
            dtoS.setOidRegion(this.bigDecimalToLong(resultado.getValueAt(0, "OID_REGI")));
            dtoS.setOidSeccion(this.bigDecimalToLong(resultado.getValueAt(0, "OID_SECC")));
            dtoS.setOidSGV(this.bigDecimalToLong(resultado.getValueAt(0, "OID_SUBG_VENT")));
            dtoS.setOidTerritorio(this.bigDecimalToLong(resultado.getValueAt(0, "TERR_OID_TERR")));
            dtoS.setOidTerritorioAdministrativo(this.bigDecimalToLong(resultado.getValueAt(0, "OID_TERR_ADMI")));
            dtoS.setOidZona(this.bigDecimalToLong(resultado.getValueAt(0, "OID_ZONA")));
        }
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.obtenerUnidadAdministrativa(cliente, periodo): Salida"); 
        return dtoS;
    }

  
    private Long obtenerUbigeo(Long oidCliente) throws MareException{
      UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.obtenerUbigeo(Long oidCliente): Entrada ");
      StringBuffer query = new StringBuffer();
      RecordSet rs;
     
       /* Modificado por Incidencia SiCC 20070126 --- Alorenzo 20/03/2007
      query.append(" SELECT TER.VEPO_OID_VALO_ESTR_GEOP ");
      query.append(" FROM MAE_CLIEN_DIREC MCD, ");
      query.append(" ZON_TERRI TER  ");
      query.append(" WHERE MCD.IND_DIRE_PPAL = 1 ");
      query.append(" AND MCD.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
      query.append(" AND MCD.CLIE_OID_CLIE = " + oidCliente);
      query.append(" AND TER.OID_TERR = MCD.TERR_OID_TERR ");
      */

      query.append(" SELECT CASE WHEN (SUBSTR(MCD.COD_UNID_GEOG,19,6) IS NULL) THEN ");
      query.append("			 (");
			query.append("        SELECT VEG.OID_VALO_ESTR_GEOP");
			query.append("        FROM ZON_VALOR_ESTRU_GEOPO VEG");
			query.append("        WHERE VEG.ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG,0,6)");
			query.append("          AND VEG.ORDE_2 = SUBSTR(MCD.COD_UNID_GEOG,7,6)");
			query.append("          AND VEG.ORDE_3 = SUBSTR(MCD.COD_UNID_GEOG,13,6)");
			query.append("          AND VEG.ORDE_4 IS NULL					 						  ");
  		query.append("       )  ");
			query.append("      ELSE ");
			query.append("        (");
			query.append("          SELECT VEG.OID_VALO_ESTR_GEOP");
			query.append("          FROM ZON_VALOR_ESTRU_GEOPO VEG");
			query.append("          WHERE VEG.ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG,0,6)");
			query.append("            AND VEG.ORDE_2 = SUBSTR(MCD.COD_UNID_GEOG,7,6)");
			query.append("            AND VEG.ORDE_3 = SUBSTR(MCD.COD_UNID_GEOG,13,6)");
			query.append("            AND VEG.ORDE_4 = SUBSTR(MCD.COD_UNID_GEOG,19,6)		");		 						  
  		query.append("        )  ");
			query.append("      END VEPO_OID_VALO_ESTR_GEOP ");			
      query.append(" FROM MAE_CLIEN_DIREC MCD ");
      query.append(" WHERE MCD.IND_DIRE_PPAL = 1 "); 
      query.append("  AND MCD.IND_ELIM = 0 ");
		  query.append("  AND MCD.CLIE_OID_CLIE = " + oidCliente);
     
      
      rs = this.executeQuery(query.toString());
      Long oidEstrGeo = null;
          
      if (!rs.esVacio()){
          oidEstrGeo = this.bigDecimalToLong(rs.getValueAt(0,"VEPO_OID_VALO_ESTR_GEOP")); 
      }
      UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.obtenerUbigeo(Long oidCliente): Salida ");
      return oidEstrGeo;  
    }
    public String armarMensajeError(String numeroSolicitud, String mensaje, String alternativo) 
        throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.armarMensajeError"+
        "(String numeroSolicitud, String mensaje, String alternativo): Entrada");
        
        String mensajeError = "";
        
        if(numeroSolicitud!=null) {
            mensajeError = mensaje;
        }
        else {
            mensajeError = alternativo;
        }       
        
        UtilidadesLog.debug("*** mensajeError " + mensajeError);
        
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.armarMensajeError"+
        "(String numeroSolicitud, String mensaje, String alternativo): Salida");       
        return mensajeError;
    }
    
    //jrivas 16/07/2007 FAC-003
    public DTOCabeceraSolicitud validarTipoPrograma(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarTipoPrograma(DTOCabeceraSolicitud DTOE): Entrada ");
        DAOValidaciones daoValidaciones = new DAOValidaciones();
        DTOE.setOidTipoProgramaIncentivos(daoValidaciones.obtenerTipoPrograma(DTOE.getOidConcursoParametros(), DTOE.getTipoSolicitud()) );
        UtilidadesLog.info("MONValidacionesGeneralesSolicitudBean.validarTipoPrograma(DTOCabeceraSolicitud DTOE): Salida ");
        return DTOE;
    }

    private MONUsuariosHome getMONUsuariosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONUsuariosHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/MONUsuarios" ), MONUsuariosHome.class );
    }
}
