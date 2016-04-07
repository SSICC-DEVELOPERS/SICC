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
 *
 */
package es.indra.sicc.logicanegocio.intsys;

import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.util.BelcorpService;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.intsys.DTOINTRecepcionarClasificacion;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.logicanegocio.intsys.DAORecepcionarClasificacion;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.intsys.ConstantesCPR;
import java.util.Collection;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import java.math.BigDecimal;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;

public class MONINTCPRBean implements SessionBean  {
  private SessionContext sessionContext;
  
  public void ejbCreate() { }
  public void ejbActivate() { }
  public void ejbPassivate() { }
  public void ejbRemove() { }
  public void setSessionContext(SessionContext ctx) {  this.sessionContext = ctx; }

  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       12/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */      
  private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
    UtilidadesLog.info("MONINTCPRBean.getMONGestorInterfaces(): Entrada");
    MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);            
    MONGestorInterfaces ejb = null;
    try {
        ejb = home.create();
    }
    catch (Exception e) {
        UtilidadesLog.error("*** Error en getMONGestorInterfaces",e);
        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    } 
    UtilidadesLog.info("MONINTCPRBean.getMONGestorInterfaces(): Salida");
    return ejb;
  }  
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       12/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */      
  public DTOSalidaBatch recepcionarClasificacion(DTOINTRecepcionarClasificacion dtoe) 
    throws MareException {        
        DTOSalidaBatch dtoSalidaBatch = null;
        try {
            UtilidadesLog.info("MONINTBean.recepcionarClasificacion(DTOINTRecepcionarClasificacion dtoe): Entrada");
            UtilidadesLog.debug("DTOINTRecepcionarClasificacion : " + dtoe );
            
            MareBusinessID IDOnline = new MareBusinessID("INTCPRRecepcionarClasificacionBatch");
            
            String mensaje = null;    
            String nombre = "Recepcionar Clasificación (CPR)";
            
            IMareDTO DTOOnline = (IMareDTO)dtoe;
            DTOBatch dtoBach = new DTOBatch(nombre,IDOnline,DTOOnline);   
            
            MareBusinessID IDProceso = new MareBusinessID("INTProcesoInterfaces");
            
            UtilidadesLog.debug("Antes de BatchUtil.executeMLN"); 
            BatchUtil.executeMLN(dtoBach,IDProceso);
    
            mensaje += "Recepcionar Clasificación - ";
            UtilidadesLog.debug("Luego de BatchUtil.executeMLN");
    
            dtoSalidaBatch = new DTOSalidaBatch(0, mensaje);
            UtilidadesLog.debug("dtoSalidaBatch: " + dtoSalidaBatch);                
            
        }catch (RemoteException e){
         UtilidadesLog.error(e);
        }

        UtilidadesLog.info("MONINTBean.recepcionarClasificacion(DTOINTRecepcionarClasificacion dtoe): Salida");
        return dtoSalidaBatch;           
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       09/01/2007
    * @version     1.0
    * @autor       SCS
    * 
    *              SCS; se hace Batch la ejecucion de la interfaz
    */      
  public DTOSalidaBatch recepcionarClasificacionBatch(DTOBatch dtoBtch) throws MareException {
     UtilidadesLog.info("MONINTCPRBean.recepcionarClasificacionBatch(DTOBatch dtoBtch):Entrada");
     DTOSalidaBatch dtoSalidaBatch = null;
     
     MONGestorInterfaces gi = this.getMONGestorInterfaces();
     DAORecepcionarClasificacion dao = new DAORecepcionarClasificacion();     
     IRegistroSicc irc = null;
     InterfazInfo info = null;     
     DTOINTRecepcionarClasificacion dtoe = (DTOINTRecepcionarClasificacion) dtoBtch.getDTOOnline();
     try {
        InterfazInfo interfaz = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_CPR1, 
                                                 dtoe.getNumeroLote().toString(),
                                                 Long.valueOf(dtoe.getPais()));          
        
        UtilidadesLog.debug("*** Llamando a importarInterfaz");
        info = gi.importarInterfaz(interfaz);        
        info.setDescripcionLote(dtoe.getDescripcionLote());
        info.setObservaciones(dtoe.getObservaciones());
     }
     catch (InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
            UtilidadesLog.debug("Excepcion de la Interfaz: "+ ie.getMotivo());
            throw new MareException(ie.getMotivo(), ie);
     }
     catch (RemoteException ne) {
            if ( ne.detail != null && (ne.detail instanceof InterfacesException ) ) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );
            } else {                
                throw new MareException(ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
     }          
     
     //1° Obtendra los OID_TIPO_CLAS de la tabla MAE_TIPO_CLASI_CLIEN
     //filtrando por el modo ejecucion que haya seleccionado en la pantalla
     UtilidadesLog.debug("*** Llamando a obtenerTipoClasificacion");
     RecordSet tiposClasificaciones = dao.obtenerTipoClasificacion(dtoe);     
     
     //2° Si eligio Clasificaciones Privilege...
     if(dtoe.getModoEjecucion().longValue() == ConstantesCPR.CPR1_CLASIF_PRIV1.longValue())  {
        //2°.1 Borra de la tabla MAE_TIPO_CLASI_CLIEN segun el OID_CLIE_CLAS
        UtilidadesLog.debug("*** Llamando a eliminarClienteClasificacion con clientes null");
        //  Modificado por HRCS - Fecha 12/06/2007 - Cambio Sicc20070302
        BelcorpService belcorpService = null;
        try {
           belcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",
                                        dao.eliminarClienteClasificacion(null, tiposClasificaciones, dtoe.getPais()).toString() );
        }catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
     }
    
     //3° Si eligio Clasificaciones Segmentacion...
     if(dtoe.getModoEjecucion().longValue() == ConstantesCPR.CPR1_CLASIF_PRIV2.longValue())  {
         ArrayList clientes = new ArrayList();
         
         try{       
            UtilidadesLog.debug("*** Llamando a cargarRegistro");
            int count = 0;
            StringBuffer insert = new StringBuffer();
            
            while ((irc = gi.cargarRegistro(info, false)) != null) {
                clientes.add(irc.obtenerCampo(ConstantesCPR.CPR1_COD_CONSULTORA));
                count++;
                if (count == 900) {
                    count = 0;
                    UtilidadesLog.debug("*** Llamando a eliminarClienteClasificacion, con: " + clientes.size() + " clientes...");
                    insert.append(dao.eliminarClienteClasificacion(clientes, tiposClasificaciones, dtoe.getPais()));            
                    clientes.clear();
                }
            }
            if (clientes.size()>0) {
                UtilidadesLog.debug("*** Llamando a eliminarClienteClasificacion, con: " + clientes.size() + " clientes...");
                insert.append(dao.eliminarClienteClasificacion(clientes, tiposClasificaciones, dtoe.getPais()));            
                clientes.clear();
            }
            BelcorpService belcorpService = null;
            try {
               belcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",insert.toString());
            }catch (Exception e) {
                UtilidadesLog.error("ERROR",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }            
            
            //3°.1 Borra de la tabla MAE_TIPO_CLASI_CLIEN segun el OID_CLIE_CLAS
            //esta vez se filtra por los clientes
            //UtilidadesLog.debug("*** Llamando a eliminarClienteClasificacion, con: " + clientes.size() + " clientes...");
            //SCS 28/12/2006, la idea es mandar a deletear de a 1000 registros de mae clasi., mandar 45000 de una
            //puede que cuelgue al oracle.
            
            //dao.eliminarClienteClasificacion(clientes, tiposClasificaciones, dtoe.getPais());            
         }
         catch (InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
            UtilidadesLog.debug("Excepcion de la Interfaz: "+ ie.getMotivo());
            throw new MareException(ie.getMotivo(), ie);
         }
         catch (RemoteException re) {
            UtilidadesLog.error("recepcionarClasificacion: RemoteException:gi.importarInterfaz",re);
            throw new MareException(re,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }         
     }
     
     RecordSet clientes; 
     Long oidPais; 
     Long oidTipoClasificacion; 
     Long oidPeriodo; 
     Long oidClasificacion; 
     Hashtable paises = new Hashtable();
     Hashtable periodos = new Hashtable();
     Hashtable clasificaciones = new Hashtable();
     StringBuffer insert2 = new StringBuffer();
     
     //SCS
     ArrayList noRepetidosClienClasiUK = new ArrayList();     
     try {        
         //Resetea la lectura del fichero
         UtilidadesLog.debug("*** Llamando a reset");
         gi.reset(info);
         
         while ((irc = gi.cargarRegistro(info)) != null) {
            //4° Trae un RecordSet con OID_CLIE_TIPO_SUBT de 
            //la tabla MAE_CLIEN_TIPO_SUBTI
            UtilidadesLog.debug("*** Llamando a obtenerClienteTipoSubTipo");
            clientes = dao.obtenerClienteTipoSubTipo((String)irc.obtenerCampo(ConstantesCPR.CPR1_COD_CONSULTORA), 
            dtoe.getPais());
            
            if(clientes.esVacio()) {
                //(Se ha modificado el codigo 89 por 93, debido a que ya existia
                //ese codigo con otro mensaje)
                UtilidadesLog.debug("*** RecordSet clientes - vacio");
                DTOINTError dtoError = new DTOINTError(info,irc,ErroresDeNegocio.INT_0093 + 
                irc.obtenerCampo(ConstantesCPR.CPR1_COD_CONSULTORA));
                gi.registrarError(dtoError);
            }
            
            //5° Recorre el RecordSet clientes
            //(Se puso el resto del codigo dentro del for
            //debido a la incidencia 21202)
            int cantRegistros = clientes.getRowCount();
            for(int i=0; i< cantRegistros; i++) {                
                Long oidCliente = Long.valueOf(((BigDecimal)clientes.getValueAt(i, "OID_CLIE_TIPO_SUBT")).toString());
                
                //6° Obtiene oidPais
                UtilidadesLog.debug("*** Llamando a obtenerPais");
                String paisR = (String)irc.obtenerCampo(ConstantesCPR.CPR1_PAIS);
                if (paises.contains(paisR)){
                    oidPais = (Long)paises.get(paisR);
                }else{
                    oidPais = dao.obtenerPais(paisR); 
                    paises.put(paisR, oidPais);
                }
                               
                if(oidPais==null) {
                    UtilidadesLog.debug("*** pais nulo");
                    DTOINTError dtoError = new DTOINTError(info,irc,ErroresDeNegocio.INT_0091 + 
                    irc.obtenerCampo(ConstantesCPR.CPR1_PAIS));
                    gi.registrarError(dtoError);                
                }
            
                //7° Obtiene oidTipoClasificacion
                UtilidadesLog.debug("*** Llamando a obtenerOIDTipoClasificacion");
                oidTipoClasificacion = dao.obtenerOIDTipoClasificacion((String)irc.obtenerCampo(ConstantesCPR.CPR1_TIPO_CLASIFICACION), 
                oidCliente);            
                if(oidTipoClasificacion==null) {
                    UtilidadesLog.debug("*** oidTipoClasificacion nulo");
                    DTOINTError dtoError = new DTOINTError(info,irc,ErroresDeNegocio.INT_0090 + 
                    irc.obtenerCampo(ConstantesCPR.CPR1_TIPO_CLASIFICACION));
                    gi.registrarError(dtoError);                
                }
            
                //8° Obtiene oidPeriodo
                UtilidadesLog.debug("*** Llamando a obtenerPeriodo");
                String periodoR = (String)irc.obtenerCampo(ConstantesCPR.CPR1_CAMPANIA);
                if (periodos.contains(periodoR)){
                    oidPeriodo = (Long)periodos.get(periodoR);
                }else{
                    oidPeriodo = dao.obtenerPeriodo(periodoR,Long.valueOf(dtoe.getPais())); 
                    periodos.put(periodoR, oidPeriodo);
                }
                if(oidPeriodo==null) {
                    UtilidadesLog.debug("*** oidPeriodo nulo");
                    DTOINTError dtoError = new DTOINTError(info,irc,ErroresDeNegocio.INT_0092 + 
                    irc.obtenerCampo(ConstantesCPR.CPR1_CAMPANIA));
                    gi.registrarError(dtoError);             
                }
            
                //9° Obtiene oidClasificacion
                UtilidadesLog.debug("*** Llamando a obtenerClasificacion");
                if (clasificaciones.contains(oidTipoClasificacion)){
                    oidClasificacion = (Long)clasificaciones.get(periodoR);
                }else{
                    oidClasificacion = dao.obtenerClasificacion(oidTipoClasificacion); 
                    clasificaciones.put(periodoR, oidClasificacion);
                }
                
                //10° Si todos los oid son distintos de nulo...
                if (!noRepetidosClienClasiUK.contains(oidCliente + "-" + oidTipoClasificacion)){
                     noRepetidosClienClasiUK.add(oidCliente + "-" + oidTipoClasificacion);
                     if(oidCliente!=null && oidPais!=null && oidTipoClasificacion!=null &&
                         oidPeriodo!=null && oidClasificacion!=null) {
                         
                         UtilidadesLog.debug("SCS, no contenido y campos no nulos, adhiero y genero linea de insert!");
                         
                         //11° Se crea un registro en la tabla MAE_CLIEN_CLASI
                         UtilidadesLog.debug("*** Antes de hacer el create en ClienteClasificacion con: ");
                         UtilidadesLog.debug("*** oidCliente " + oidCliente + " oidClasificacion " + oidClasificacion);
                         UtilidadesLog.debug("*** oidPeriodo " + oidPeriodo + " oidTipoClasificacion " + oidTipoClasificacion);
                          
                         /*ClienteClasificacionLocalHome cclh = this.getClienteClasificacionLocalHome();
                         ClienteClasificacionLocal ccl = cclh.create(oidCliente, oidClasificacion, 
                         oidPeriodo, oidTipoClasificacion, new Long(0), fecha);    
                  
                         Date fechaTemp = this.truncarFecha(new Date(System.currentTimeMillis()));
                         ccl.setFec_clas(new Timestamp(fechaTemp.getTime()));        */       
                         insert2.append(generaInsert(oidCliente, oidClasificacion, oidPeriodo, oidTipoClasificacion));
                     }//fin del if
                }
                
            }//fin del for            
         }//fin del while     
         BelcorpService belcorpService = null;
         try {
            belcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",insert2.toString());
         }catch (Exception e) {
             UtilidadesLog.error("ERROR",e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }
     }catch (InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
            UtilidadesLog.debug("Excepcion de la Interfaz: "+ ie.getMotivo());
            throw new MareException(ie.getMotivo(), ie);
     }catch (RemoteException re) {
        UtilidadesLog.error("recepcionarClasificacion: RemoteException:gi.importarInterfaz",re);
        throw new MareException(re,
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
     } 
  
     UtilidadesLog.info("MONINTCPRBean.recepcionarClasificacionBatch(DTOBatch dtoBtch):Salida");
     
     String mensaje = new String();
     mensaje = "recepcionarClasificacionBatch procesado - ";
     
     return new DTOSalidaBatch(0, mensaje);
  }
  
    private StringBuffer generaInsert(Long oidCliente, Long oidClasificacion, Long periodo, Long oidTipoClasificacion){
        StringBuffer sb = new StringBuffer("INSERT INTO MAE_CLIEN_CLASI ( OID_CLIE_CLAS, CTSU_OID_CLIE_TIPO_SUBT, CLAS_OID_CLAS, PERD_OID_PERI, ");
        sb.append(" TCCL_OID_TIPO_CLASI, FEC_CLAS, IND_PPAL, FEC_ULTI_ACTU ) VALUES ( ");
        sb.append(" MAE_CLCL_SEQ.nextval, ").append(oidCliente).append(" , ").append(oidClasificacion).append(" , ").append(periodo);
        sb.append(" , ").append(oidTipoClasificacion).append(" , ").append("trunc(SYSDATE)").append(" , ").append(new Long(0));
        sb.append(" , ").append( " SYSDATE );");
        return sb;
    }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       14/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */      
    
  private java.sql.Date truncarFecha(java.sql.Date fecha){
        UtilidadesLog.info("MONINTCPRBean.truncarFecha(java.sql.Date fecha): Entrada");
		if (fecha!=null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date fechaTruncada = java.sql.Date.valueOf(sdf.format(fecha));
            UtilidadesLog.info("MONINTCPRBean.truncarFecha(java.sql.Date fecha): Salida");
			return fechaTruncada;
		}
        else {
            UtilidadesLog.info("MONINTCPRBean.truncarFecha(java.sql.Date fecha): Salida");
            return null;
        }
	}

  /**
    * Sistema:     Belcorp
    * Modulo:      INTSYS
    * Fecha:       12/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */      
  public DTOSalida cargarPantalla(DTOBelcorp dtoe) throws MareException  {   
    UtilidadesLog.info("MONINTCPRBean.cargarPantalla(DTOBelcorp dtoe):Entrada");
    DAORecepcionarClasificacion dao = new DAORecepcionarClasificacion();
    RecordSet rs = dao.obtenerModosEjecucion();
    DTOSalida dtoSalida = new DTOSalida();
    dtoSalida.setResultado(rs);
    UtilidadesLog.info("MONINTCPRBean.cargarPantalla(DTOBelcorp dtoe):Salida");
    return dtoSalida;    
  }


    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }

}