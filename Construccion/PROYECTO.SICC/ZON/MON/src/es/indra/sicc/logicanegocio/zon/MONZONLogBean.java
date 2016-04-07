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
 
package es.indra.sicc.logicanegocio.zon;
//EJB
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.RemoveException;
import javax.ejb.FinderException;

//ZON
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.entidades.zon.ZonLogLocalHome;
import es.indra.sicc.entidades.zon.ZonLogLocal;
import es.indra.sicc.entidades.zon.ZonLogDetalleLocalHome;
import es.indra.sicc.entidades.zon.ZonLogDetalleLocal;


//MARE
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.ejbservice.EJBLocator;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;

//Belcorp
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.zon.IManagerFileInterface;
import java.sql.Date;
import java.sql.Timestamp;
import javax.ejb.CreateException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Collection;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.text.SimpleDateFormat;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/**
 * Sistema:       Belcorp
 * Modulo:        ZON
 * Componente:    MONZonLog - Clase Bean
 * Fecha:         07/11/2003
 * Observaciones:
 * 
 * 
 * 
 * @version       1.0
 * @author        Fernando Laffaye
 */

public class MONZONLogBean implements SessionBean  {

    private SessionContext ctx = null;
    private final static String SEP = ";";
    private final static String FORMATO_FECHA = "yyyy.MM.dd 'at' HH:mm:ss";   
    
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

    
    /**
   * El método inserta un nuevo registro en la tabla ZON_LOG
   * si el registro no exitiera. Si el registro exite, entonces
   * realiza una actualizacion de los capos 'val_esta' , 'val_mens'
   * asi tambien actualiza el campo 'fec_log'.
   * 
   * 
   * @param Long oid,String valTipoProc,Long valEstado,String mensaje
   * @return void
   * @throws MareException
  */
    public void reportarResultado(Long oid, String valTipoProc, Long valEstado, String mensaje) throws MareException{
            UtilidadesLog.info("MONZONLogBean.reportarResultado(Long oid, String valTipoProc, Long valEstado, String mensaje): Entrada");
            
            ZonLogLocalHome localHome = null;
            ZonLogLocal zonLocal      = null;            
            Timestamp date = new Timestamp(System.currentTimeMillis());
            String codigoError;
            
            try{
                    localHome = this.getZonLogLocalHome();
                    zonLocal = null;            
                    zonLocal = localHome.findByPrimaryKey(oid);                
                    zonLocal.setValEstado(valEstado);
                    zonLocal.setValMensaje(mensaje);
                    zonLocal.setFechaLog(date);
                    localHome.merge(zonLocal);
                    
                    UtilidadesLog.info("MONZONLogBean.reportarResultado(Long oid, String valTipoProc, Long valEstado, String mensaje): Salida");
                    
            }catch(NoResultException fe){
                //El entity no existe => se crea el entity.
                UtilidadesLog.error("ERROR en el finder, se crea la entidad");       
                try {
                    //todo: Proceso de  Auditoria !!!.
                    //localHome.parametrosAuditoria( dtoEntrada );                      
                    zonLocal = localHome.create(oid,valTipoProc,valEstado,date);
                    UtilidadesLog.info("MONZONLogBean.reportarResultado(Long oid, String valTipoProc, Long valEstado, String mensaje): Salida");

                }catch(PersistenceException e){
                    UtilidadesLog.error("ERROR",e);
                    UtilidadesLog.info("MONZONLogBean.reportarResultado(Long oid, String valTipoProc, Long valEstado, String mensaje): Salida");
                    codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(e,  UtilidadesError.armarCodigoError(codigoError));
                } catch(Exception e){
                    UtilidadesLog.error("ERROR",e);
                    UtilidadesLog.info("MONZONLogBean.reportarResultado(Long oid, String valTipoProc, Long valEstado, String mensaje): Salida");
                    codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(e,  UtilidadesError.armarCodigoError(codigoError));
                }                 
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    }

   /**
   * 
   * El método inserta un nuevo registro en la tabla ZON_LOG_DETAL
   * 
   * @param Long oid,String typeProc,String mensaje,Object datos.
   * @return void
   * @throws MareException
  */
    public void agregarDetalle(Long oid, String typeProc, String mensaje, Object datos) 
        throws MareException
    {            
            UtilidadesLog.info("MONZONLogBean.agregarDetalle(Long oid, String typeProc, String mensaje, Object datos): Entrada");
            
            Timestamp time = new Timestamp(System.currentTimeMillis());
            String codigoError;
            ZonLogDetalleLocalHome homeEnt;
            ZonLogDetalleLocal zonDLocal;

        try{
                homeEnt = this.getZonLogDetalle();
                zonDLocal =  homeEnt.create(oid,time,typeProc,mensaje,datos);
                UtilidadesLog.info("MONZONLogBean.agregarDetalle(Long oid, String typeProc, String mensaje, Object datos): Salida");

        }catch(PersistenceException me){
            UtilidadesLog.error("ERROR", me);
            UtilidadesLog.info("MONZONLogBean.agregarDetalle(Long oid, String typeProc, String mensaje, Object datos): Salida");
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(me,  UtilidadesError.armarCodigoError(codigoError));
        }catch(Exception me){
            UtilidadesLog.error("ERROR", me);
            UtilidadesLog.info("MONZONLogBean.agregarDetalle(Long oid, String typeProc, String mensaje, Object datos): Salida");
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(me,  UtilidadesError.armarCodigoError(codigoError));
        }        
    }

    /**
    * 
    * El método inserta un nuevo registro en la tabla ZON_LOG_DETAL
    * 
    * @param Long oid,String typeProc,String mensaje,Object datos.
    * @return void
    * @throws MareException
    */
    public DTOManagerFileResult obtenerResultado(Long oId, String typProc)
        throws MareException
    {
        try{
            UtilidadesLog.info("MONZONLogBean.obtenerResultado(Long oId, String typProc): Entrada");
            
            DTOManagerFileResult dtoSalida = new DTOManagerFileResult();
            ZonLogLocalHome homeZonLog =  this.getZonLogLocalHome();
            ZonLogLocal zonLocal = null;
            Collection collection = null;
            String codigoError = null;
            StringBuffer reporteR = new StringBuffer();
    
            zonLocal = homeZonLog.findByPrimaryKey(oId);
    
            SimpleDateFormat formatter = new SimpleDateFormat (FORMATO_FECHA);
            
            dtoSalida.setIDProc(oId);
            dtoSalida.setTypeProc(zonLocal.getValTipoProc());
            dtoSalida.setFechaLog(formatter.format(zonLocal.getFechaLog()));
            dtoSalida.setEstatus(zonLocal.getValEstado());
            dtoSalida.setMensajeError(zonLocal.getValMensaje());
            
            //Datos Obtenidos de la tabla ZON_LOG_DETAL
            ZonLogDetalleLocalHome homeZonLogD = this.getZonLogDetalle();
            collection = homeZonLogD.findByLogId(oId);
                  
            if ( collection != null )
            {
                Iterator it = collection.iterator();
                boolean first = true;
                if ( it != null ){
                    while( it.hasNext() )
                    {
                        ZonLogDetalleLocal e = (ZonLogDetalleLocal)it.next();
                        if ( first ) {         
                            // 23002 - dmorello, 16/06/2006
                            // En el dato se reemplazarán los ; por \n
                            reporteR.append(formatter.format(e.getFechaLog()) + SEP 
                                            + (e.getValDato()==null?" ":e.getValDato().replaceAll(SEP,"\n")) 
                                            + SEP + e.getMensajeError());
                            first = !first; 
                        }
                        else{
                            // 23002 - dmorello, 16/06/2006
                            // En el dato se reemplazarán los ; por \n
                            reporteR.append(SEP + formatter.format(e.getFechaLog()) + SEP
                                            + (e.getValDato()==null?" ":e.getValDato().replaceAll(SEP,"\n")) 
                                            + SEP+ e.getMensajeError());
                        }
                    }
                }
            }
    
            dtoSalida.setReporteRegistros(reporteR.toString());  
            UtilidadesLog.debug("DTOManagerFileResult: " + dtoSalida);
            UtilidadesLog.info("MONZONLogBean.obtenerResultado(Long oId, String typProc): Salida");
            return dtoSalida;
        }catch(NoResultException e){
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e,  UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(Exception e){
                UtilidadesLog.error("ERROR",e);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e,  UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public Long crearLogProceso(String valTipoProc) throws MareException {
    
        UtilidadesLog.info("MONZONLogBean.crearLogProceso(String valTipoProc): Entrada");
        
        ZonLogLocalHome localHome = null;
        ZonLogLocal zonLocal      = null;            
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String codigoError;
        try {
            localHome = getZonLogLocalHome();                      
            zonLocal = localHome.create(valTipoProc,
                                        IManagerFileInterface.NO_INICIADO,
                                        date);

        }catch(PersistenceException e){
            UtilidadesLog.error("ERROR",e);
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,  UtilidadesError.armarCodigoError(codigoError));
        } catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,  UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONZONLogBean.crearLogProceso(String valTipoProc): Salida");
        return zonLocal.getOidZonLog();
    }
    
    private ZonLogLocalHome getZonLogLocalHome() {
        return new ZonLogLocalHome();
    }
    
     private ZonLogDetalleLocalHome getZonLogDetalle() {
       return new ZonLogDetalleLocalHome();
     }
    
    
 
}