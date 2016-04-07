package es.indra.sicc.logicanegocio.com;
//import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.com.DTOBusquedaAccesosPlantilla;
import es.indra.sicc.dtos.com.DTOBusquedaPlantillas;
import es.indra.sicc.entidades.com.PlantillasComisionesAccesoLocal;
import es.indra.sicc.entidades.com.PlantillasComisionesAccesoLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesLocal;
import es.indra.sicc.entidades.com.PlantillasComisionesLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesMarcaLocal;
import es.indra.sicc.entidades.com.PlantillasComisionesMarcaLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesPaisLocal;
import es.indra.sicc.entidades.com.PlantillasComisionesPaisLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
//import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.com.DTOPlantillaDetalle;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONPlantillasComBean implements SessionBean 
{
    private SessionContext sessionContext;
    SessionContext ctx = null;
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

    public void setSessionContext(SessionContext ctx)
    {
      this.ctx = ctx;
    
    }

    /*
     * Autor Marta Montiel
     * Fecha 14/02/05
     * */
    public DTOSalida obtenerTipoComision(DTOBelcorp dtoe) throws MareException {   
        UtilidadesLog.info("MONPlantillasComBean.obtenerTipoComision(DTOBelcorp dtoe): Entrada");
        DTOSalida dts = new DTOSalida();
        DAOPlantillasCom dao = new DAOPlantillasCom();
        dts.setResultado(dao.obtenerTipoComision(dtoe));
        UtilidadesLog.info("MONPlantillasComBean.obtenerTipoComision(DTOBelcorp dtoe): Salida");
        return dts;
    }

    /*
     * Autor Marta Montiel
     * Fecha 14/02/05
     * */
    public DTOSalida obtenerPlantillasCom(DTOSiccPaginacion dtoe) 
        throws MareException {
        UtilidadesLog.info("MONPlantillasComBean.obtenerPlantillasCom(DTOSiccPaginacion dtoe): Entrada");
        DTOSalida dtos = new DTOSalida();
        DAOPlantillasCom dao = new DAOPlantillasCom();
        dtos.setResultado(dao.obtenerPlantillasCom(dtoe));
        UtilidadesLog.info("MONPlantillasComBean.obtenerPlantillasCom(DTOSiccPaginacion dtoe): Salida");
        return dtos;
    }

    /*
     * Autor Marta Montiel
     * Fecha 14/02/05
     * */
    public DTOSalida obtenerEstadoPlantilla(DTOBelcorp dtoe) 
        throws MareException  {        
        UtilidadesLog.info("MONPlantillasComBean.obtenerEstadoPlantilla(): Entrada");
        DTOSalida dtos = new DTOSalida();
        DAOPlantillasCom  dao = new DAOPlantillasCom();
        dtos.setResultado(dao.obtenerEstadoPlantilla(dtoe));    
        UtilidadesLog.info("MONPlantillasComBean.obtenerEstadoPlantilla(): Salida");
        return dtos;
    }

    // idedough
    // TODO: ver. ErroresDeNegocio.COB_0008
    /* Modificado Marta Montiel  17/02/05 
     * Incidencia 14294*/
    public void eliminarPlantillasCom(DTOOIDs dtoe) throws MareException  {  
        UtilidadesLog.info("MONPlantillasComBean.eliminarPlantillasCom(DTOOIDs dtoe): Entrada");
        Long[] oids = dtoe.getOids();
        PlantillasComisionesLocalHome plant_comLHome = null;
        PlantillasComisionesLocal plant_comLocal = null;   
        plant_comLHome = this.getPlantillasComisionesLocalHome();
        for(int i = 0; i < oids.length; i++)
        {       Boolean correcto = comprobarEstadoComision(oids[i]);
                if(correcto.booleanValue())
                {   try
                    {   
                        plant_comLocal = plant_comLHome.findByPrimaryKey(oids[i]);
                        plant_comLocal.setOidEstado(ConstantesCOM.ESTADO_ELIMINADO);
                        Date fechaSistema = new Date(System.currentTimeMillis());                     
                        Timestamp ts1 = new Timestamp(fechaSistema.getTime()); 
                        plant_comLocal.setFecUltimoEstado(ts1);
                        
                        plant_comLHome.merge(plant_comLocal);
                        
                    } catch (NoResultException nre) {
                        ctx.setRollbackOnly();
                         UtilidadesLog.error("ERROR ", nre);
                        throw new MareException(nre,        
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        UtilidadesLog.error("ERROR ", pe);
                        throw new MareException(pe,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }  
                }
                else
                {   
                  /*throw new MareException(null, null, 
                                UtilidadesError.armarCodigoError(
                                ConstantesSEG.MODULO_COM, "", ErroresDeNegocio.COB_0008));  // Mostrar error: COM-0008   
                  */
                  // Modificado por ssantana, 15/3/2005 - Se llama a COM_0008.
                  throw new MareException(null, null, 
                                          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COM, 
                                                                           "", 
                                                                           ErroresDeNegocio.COM_0008));  // Mostrar error: COM-0008   

                }
        }
        UtilidadesLog.info("MONPlantillasComBean.eliminarPlantillasCom(DTOOIDs dtoe): Salida");
    }
  
    /* Autor Marta Montiel
     * Fecha 18/02/05
     */
    public Boolean comprobarEstadoComision(Long oid) throws MareException { 
        UtilidadesLog.info("MONPlantillasComBean.comprobarEstadoComision(Long oid): Entrada");
        DAOPlantillasCom  dao = new DAOPlantillasCom();
        RecordSet rs = new RecordSet();
        rs= dao.obtenerComActivasPorPlantilla(oid);
        if(!rs.esVacio()){
            UtilidadesLog.info("MONPlantillasComBean.comprobarEstadoComision(Long oid): Salida");
            return Boolean.FALSE;
        }else{
            UtilidadesLog.info("MONPlantillasComBean.comprobarEstadoComision(Long oid): Salida");
            return Boolean.TRUE;
        }        
    }
    
    
    /*
     * Marta Montiel
     * 15/02/05
     * */
    public DTOPlantillaDetalle obtenerDetallePlantilla(DTOOID dtoe) 
    throws MareException { 
        UtilidadesLog.info("MONPlantillasComBean.obtenerDetallePlantilla(DTOOID dtoe): Entrada");
        DAOPlantillasCom dao = new DAOPlantillasCom();
        DTOPlantillaDetalle dtos = new DTOPlantillaDetalle();
        dtos = dao.obtenerDetallePlantilla(dtoe);
        UtilidadesLog.info("MONPlantillasComBean.obtenerDetallePlantilla(DTOOID dtoe): Salida");
        return dtos;
    }
    
    // idedough  - metodo cual devuelve  DISTINCT tipo Long[] de valores de array-argumento de tipo Long[]
    private static Long[] diffArray(Long arr[])  {  
       UtilidadesLog.info("MONPlantillasComBean.diffArray(Long arr[]): Entrada");
       int len=arr.length;int b=0;int _result=0;
       for(int a=0;a<len;a++)
       {    if(arr[a]==null)continue;else _result++;
            for(b=a;b<len;b++)
            {    if(arr[b]==null)continue;
                 if(arr[a].longValue()==arr[b].longValue()&&a!=b)
                    arr[b]=null; 
            }           
       }        
       Long arrResult[]=new Long[_result];b=0;
       for(int n=0;n<len;n++)
           if(arr[n]!=null)
           {   arrResult[b]=new Long(arr[n].toString());b++;
           }
           
       UtilidadesLog.info("MONPlantillasComBean.diffArray(Long arr[]): Salida");
       return arrResult;
    }
    
    // Autor Marta Montiel
    //Fecha 09/02/05
    public void insertarPlantillaCom(DTOPlantillaDetalle dtoe) throws MareException  {
        UtilidadesLog.info("MONPlantillasComBean.insertarPlantillaCom(DTOPlantillaDetalle dtoe): Entrada");
    /*Inserta Plantilla*/
       Long comp = null;
       Long tratDif = null;
       String codigoError = "";              
       
       if( dtoe.getComparativo()!=null && dtoe.getComparativo().equals("COM_SI") ){
          comp = new Long(1);       
       }else if( dtoe.getComparativo()!=null && dtoe.getComparativo().equals("COM_NO") ){
          comp = new Long(0);      
       }       
       
       if( dtoe.getTratamientoDiferencial()!= null && dtoe.getTratamientoDiferencial().equals("COM_SI") ){
          tratDif = new Long(1);          
       }else if( dtoe.getTratamientoDiferencial()!= null && dtoe.getTratamientoDiferencial().equals("COM_NO") ){
          tratDif = new Long(0);
       }
       
       Date fechaSistema = new Date(System.currentTimeMillis());
       // cambialo 
       Timestamp ts1 = new Timestamp(fechaSistema.getTime()); 
       if( dtoe.getOidPlantilla()==null ){
                 //insertamos en Plantillas Comisiones
                 PlantillasComisionesLocalHome plantillasComisionesLocalHome = this.getPlantillasComisionesLocalHome();
                 PlantillasComisionesLocal plantillasComisionesLocal;
                 Long oidPlanti = null;                 
                 
                 try{           
                      plantillasComisionesLocal = plantillasComisionesLocalHome.create(dtoe.getCodPlantilla(), dtoe.getOidCanal());
                      plantillasComisionesLocal.setOidTipoPlantilla(dtoe.getOidTipoComision());
                      plantillasComisionesLocal.setComparativo( comp );                      
                      plantillasComisionesLocal.setTratamientoDiferencial( tratDif );                       
                      plantillasComisionesLocal.setFecUltimoEstado(ts1);
                      plantillasComisionesLocal.setOidEstado(new Long(1));  
                      
                      plantillasComisionesLocalHome.merge(plantillasComisionesLocal);
                     
                      oidPlanti = plantillasComisionesLocal.getOid();       
                      
                 } catch(PersistenceException e) {
                      ctx.setRollbackOnly();
                      UtilidadesLog.error("ERROR ", e);
                      throw new MareException(e,
                             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                 }    
              
                  //insertarmos la descripion internacionalizable que pertenece a la entidad plantillacomision
                  UtilidadesLog.info("ANTES DEL FOR");
                  UtilidadesLog.info("dtoe.getAttriTraducible().length  ++++++  " + dtoe.getAttriTraducible().length);
                  for ( int i=0; i<dtoe.getAttriTraducible().length; i++ ){
                      UtilidadesLog.info("dentro del FOR");
                      UtilidadesLog.info("(DTOI18nSICC)dtoe.getAttriTraducible()[i] **** " + (DTOI18nSICC)dtoe.getAttriTraducible()[i]);
                      DTOI18nSICC dTOI18nSICC =(DTOI18nSICC)dtoe.getAttriTraducible()[i];
                      UtilidadesLog.info(" dTOI18nSICC.getValorI18n() ------" + dTOI18nSICC.getValorI18n());
                      Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
                      try{
                          entidadi18nLocalHome.create("COM_PLANT_COMIS",  new Long(1), dTOI18nSICC.getOidIdioma(), dTOI18nSICC.getValorI18n(),plantillasComisionesLocal.getOid());
                      }catch ( PersistenceException e) {
                          UtilidadesLog.error(e);
                          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                      } 
                  }
                  
                  //insertamos en Plantillas Comisiones Acceso
                  PlantillasComisionesAccesoLocalHome plantillasComisionesAccesoLocalHome = this.getPlantillasComisionesAccesoLocalHome();
                  
                  for(int a=0; a< dtoe.getArrayAcceso().length; a++ ){
                     try{
                        PlantillasComisionesAccesoLocal  plantillasComisionesAccesoLocal = plantillasComisionesAccesoLocalHome.create(oidPlanti, dtoe.getArrayAcceso()[a], dtoe.getOidCanal());
                        plantillasComisionesAccesoLocal.setFecUltimoEstado(ts1);            
                        //plantillasComisionesAccesoLocal.setOidPlanComision(dtoe.getOidTipoComision());
                        
                         plantillasComisionesAccesoLocalHome.merge(plantillasComisionesAccesoLocal);
                        
                     } catch(PersistenceException e) {
                          ctx.setRollbackOnly();
                          UtilidadesLog.error("ERROR ", e);
                          throw new MareException(e,
                                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                     }    
                  }  
        
              //insertamos en Plantillas Comisiones Marca    
                PlantillasComisionesMarcaLocalHome plantillasComisionesMarcaLocalHome = this.getPlantillasComisionesMarcaLocalHome();
                    
                    for(int a=0; a< dtoe.getArrayMarca().length; a++ ){
                       try{                      
                          PlantillasComisionesMarcaLocal  plantillasComisionesMarcaLocal = plantillasComisionesMarcaLocalHome.create( dtoe.getArrayMarca()[a], oidPlanti);
                          plantillasComisionesMarcaLocal.setFecUltimoEstado(ts1);            
                        //  plantillasComisionesMarcaLocal.setOidPlantillaComision(dtoe.getOidTipoComision());
                        
                         plantillasComisionesMarcaLocalHome.merge(plantillasComisionesMarcaLocal);
                          
                     } catch(PersistenceException e) {
                          ctx.setRollbackOnly();
                          UtilidadesLog.error("ERROR ", e);
                          throw new MareException(e,
                                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                     }    
                    }  
          
                  //insertamos en Plantillas Comisiones Pais                   
                  PlantillasComisionesPaisLocalHome plantillasComisionesPaisLocalHome = this.getPlantillasComisionesPaisLocalHome();
                    
                    for(int a=0; a< dtoe.getArrayPais().length; a++ ){
                       try{
                          PlantillasComisionesPaisLocal  plantillasComisionesPaisLocal = plantillasComisionesPaisLocalHome.create(dtoe.getArrayPais()[a], oidPlanti );
                          plantillasComisionesPaisLocal.setFecUltimoEstado(ts1);   
                          
                          plantillasComisionesPaisLocalHome.merge(plantillasComisionesPaisLocal);
                          
                        } catch(PersistenceException e) {
                             ctx.setRollbackOnly();
                             UtilidadesLog.error("ERROR ", e);
                             throw new MareException(e,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }    
                    } 
        
        }//fin if( dtoe.getOidPlantilla()==null )
        else{                   
            if( comprobarEstadoComision(dtoe.getOidPlantilla()).booleanValue() ){
               //actualizamos la entidad PlantillaComisiones
                PlantillasComisionesLocalHome plantillasComisionesLocalHome = this.getPlantillasComisionesLocalHome();
                PlantillasComisionesLocal plantillasComisionesLocal;
                try {
                    plantillasComisionesLocal = plantillasComisionesLocalHome.findByPrimaryKey(dtoe.getOidPlantilla());
                    plantillasComisionesLocal.setOidCanal(dtoe.getOidCanal());
                    plantillasComisionesLocal.setComparativo( comp );
                    plantillasComisionesLocal.setTratamientoDiferencial( tratDif ); 
                    
                    plantillasComisionesLocal.setOidTipoPlantilla(dtoe.getOidTipoComision());
                    
                    plantillasComisionesLocalHome.merge(plantillasComisionesLocal);
                    
                    //  plantillasComisionesLocal.setFecUltimoEstado(ts1);                    
            
                 } catch (NoResultException nre) {
                     ctx.setRollbackOnly();
                      UtilidadesLog.error("ERROR ", nre);
                     throw new MareException(nre,        
                         UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                 } catch (PersistenceException pe) {
                     ctx.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", pe);
                     throw new MareException(pe,
                         UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                 }
            
                 //insertarmos la descripion internacionalizable que pertenece a la entidad plantillacomision
                  for ( int i=0; i<dtoe.getAttriTraducible().length; i++ ){
                      DTOI18nSICC dTOI18nSICC =(DTOI18nSICC)dtoe.getAttriTraducible()[i];
                      Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
                      try{                          
                          Entidadi18nLocal i18n = entidadi18nLocalHome.findByEntAtrIdioPK("COM_PLANT_COMIS",  new Long(1), dTOI18nSICC.getOidIdioma(), plantillasComisionesLocal.getOid() );
                          i18n.setDetalle(dTOI18nSICC.getValorI18n());
                          entidadi18nLocalHome.merge(i18n);
                      }catch ( NoResultException ex) {                        
                          UtilidadesLog.debug(ex);
                          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                          throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                      } catch ( PersistenceException ex) {                        
                          UtilidadesLog.debug(ex);
                          codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                          throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                      } 
                  }                 
                 
                  /*Tratamiento de la entidad Plantillas Comisiones Pais*/  
                  /*PlantillasComisionesPaisLocalHome plantillasComisionesPaisLocalHome = COMEjbLocators.getPlantillasComisionesPaisLocalHome();
                  PlantillasComisionesMarcaLocalHome plantillasComisionesMarcaLocalHome = COMEjbLocators.getPlantillasComisionesMarcaLocalHome();
                  PlantillasComisionesAccesoLocalHome plantillasComisionesAccesoLocalHome = COMEjbLocators.getPlantillasComisionesAccesoLocalHome();*/
                  
                  StringBuffer queryP  = new StringBuffer();
                  StringBuffer queryM  = new StringBuffer();
                  StringBuffer queryA  = new StringBuffer();                  
                  BelcorpService belcorpService = null;
                  
                  /*queryAcceso.append(" DELETE FROM COM_COMIS_ACCES ");
                  queryAcceso.append(" WHERE PLCA_OID_PLAN_COMI_ACCE IN ");
                  queryAcceso.append(" (SELECT OID_PLAN_COMI_ACCE ");
                  queryAcceso.append(" FROM COM_PLANT_COMIS_ACCES ");
                  queryAcceso.append(" WHERE  PLCO_OID_PLAN_COMI = " + dtoe.getOidPlantilla() );
                  queryAcceso.append(" ) ");
                  */
                  queryM.append("DELETE FROM COM_PLANT_COMIS_ACCES where PLCO_OID_PLAN_COMI = " + dtoe.getOidPlantilla() );
                  queryA.append("DELETE FROM COM_PLANT_COMIS_MARCA where PLCO_OID_PLAN_COMI = " + dtoe.getOidPlantilla() );
                  queryP.append("DELETE FROM COM_PLANT_COMIS_PAIS where PLCO_OID_PLAN_COMI = " + dtoe.getOidPlantilla() );
                  try {
                     belcorpService.getInstance().dbService.executeUpdate(queryP.toString());
                     belcorpService.getInstance().dbService.executeUpdate(queryM.toString());
                     belcorpService.getInstance().dbService.executeUpdate(queryA.toString());             
                  } catch (MareException me) {
                       UtilidadesLog.debug(me);
                       throw me;
                  } catch (Exception e) {
                       UtilidadesLog.error(e); 
                       throw new MareException(e, 
                       /* inc  BELC300024432 
                        * UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COM ,
                                                        "", ErroresDeNegocio.COM_0002));*/
                                                        
                       UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COM ,
                                                        "", CodigosError.ERROR_DE_BORRADO_DE_DATOS));   
                                                        
                  }                 
                  
                  //una vez removidos los registros, ingreso lo nuevos modificados  
               try {
                  for(int a=0; a< dtoe.getArrayPais().length; a++ ){
                      //INSERTA EN PLANTILLA COMISION PAIS
                      queryP  = new StringBuffer();
                      queryP.append(" INSERT INTO COM_PLANT_COMIS_PAIS (OID_PLAN_COMI_PAIS, ");
                      queryP.append(" FEC_ULTI_ESTA, ");
                      queryP.append(" PAIS_OID_PAIS, ");
                      queryP.append(" PLCO_OID_PLAN_COMI ");
                      queryP.append(" ) ");                                    
                      queryP.append(" VALUES (COM_PLCP_SEQ.nextval, ");
                      queryP.append(" SYSDATE , ");
                      queryP.append( dtoe.getArrayPais()[a] + " , " );
                      queryP.append( dtoe.getOidPlantilla() );
                      queryP.append(" ) ");    
                      belcorpService.getInstance().dbService.executeUpdate(queryP.toString());
                      
                  }
            
                /*  tratamiento de la entidad Plantilla Comisiones Acceso  */                
                  //una vez removidos los registros, ingreso lo nuevos modificados
                  for(int a=0; a< dtoe.getArrayAcceso().length; a++ ){
                      //INSERTA EN PLANTILLA COMISION ACCESO
                      queryA  = new StringBuffer();
                      queryA.append(" INSERT INTO COM_PLANT_COMIS_ACCES (OID_PLAN_COMI_ACCE, ");
                      queryA.append(" FEC_ULTI_ESTA, ");
                      queryA.append(" PLCO_OID_PLAN_COMI, ");
                      queryA.append(" ACCE_OID_ACCE, ");
                      queryA.append(" CANA_OID_CANA ");
                      queryA.append(" ) ");
                      queryA.append(" VALUES (COM_PLCA_SEQ.nextval,  ");
                      queryA.append(" SYSDATE , ");
                      queryA.append( dtoe.getOidPlantilla() + " , " );
                      queryA.append( dtoe.getArrayAcceso()[a] + " , " );                           
                      queryA.append( dtoe.getOidCanal() );
                      queryA.append(" ) ");                      
                      belcorpService.getInstance().dbService.executeUpdate(queryA.toString());    
                      
                  }
                
                /*  tratamiento de la entidad Plantilla Comisiones Marca  */                 
                //una vez removidos los registros, ingreso lo nuevos modificados
                  
                  for(int a=0; a< dtoe.getArrayMarca().length; a++ ){
                     //INSERTA EN PLANTILLA COMISION MARCA 
                      queryM  = new StringBuffer();
                      queryM.append(" INSERT INTO COM_PLANT_COMIS_MARCA (OID_PLAN_COMI_MARC, "); 
                      queryM.append(" FEC_ULTI_ESTA, ");
                      queryM.append(" MARC_OID_MARC, ");
                      queryM.append(" PLCO_OID_PLAN_COMI ");
                      queryM.append(" ) ");
                      queryM.append(" VALUES (COM_PLCM_SEQ.nextval, ");
                      queryM.append(" SYSDATE, ");
                      queryM.append( dtoe.getArrayMarca()[a] + " , ");
                      queryM.append( dtoe.getOidPlantilla() );
                      queryM.append(" ) ");                                           
                      belcorpService.getInstance().dbService.executeUpdate(queryM.toString());
                      
                  }             
                              
                  } catch (MareException me) {
                       UtilidadesLog.debug(me);
                       throw me;
                  } catch (Exception e) {
                       UtilidadesLog.error(e);
                       throw new MareException(e, 
                      /* inc 24432 
                       * UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COM , 
                                                        "", ErroresDeNegocio.COM_0002)); */
                                                        
                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COM ,
                                                        "", CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
                  }  
                  
            }//cierrea el if de comprobar
            // Cambio por la inc 24432 
            else{
              //la plantilla tiene comisiones activas, por lo que no se puede modificar
                                                        
              throw new MareException(null, null, 
                                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COM, 
                                              "", 
                                                ErroresDeNegocio.COM_0002));  // Mostrar error: COM_0002                                   
            }
        }//fin del else modificar
        UtilidadesLog.info("MONPlantillasComBean.insertarPlantillaCom(DTOPlantillaDetalle dtoe): Salida");
          
  }//fin metodo Insertar()


    // idedough
    public DTOSalida obtenerAccesosPlantilla(DTOBusquedaAccesosPlantilla dtoe) 
    throws MareException  {
        UtilidadesLog.info("MONPlantillasComBean.obtenerAccesosPlantilla(DTOBusquedaAccesosPlantilla dtoe): Entrada");
        DTOSalida dtos = new DTOSalida();
        DAOPlantillasCom dao = new DAOPlantillasCom();
        dtos.setResultado(dao.obtenerAccesosPlantilla(dtoe));
        UtilidadesLog.info("MONPlantillasComBean.obtenerAccesosPlantilla(DTOBusquedaAccesosPlantilla dtoe): Salida");
        return dtos;
    }

    // idedough
    public DTOPlantillaDetalle copiarPlantillaCom(DTOOID dtoe) throws MareException {   
         UtilidadesLog.info("MONPlantillasComBean.copiarPlantillaCom(DTOOID dtoe): Entrada");
         DTOPlantillaDetalle dtos = new DTOPlantillaDetalle(); 
         
         Long oid = dtoe.getOid();   
         PlantillasComisionesLocalHome plant_comLHome = null;
         PlantillasComisionesLocal plant_comLocal = null;          
         PlantillasComisionesLocal plant_comLocal_cr = null; 
         
         plant_comLHome = this.getPlantillasComisionesLocalHome();
         
         try {    
              Date fechaSistema = new Date(System.currentTimeMillis());                     
              Timestamp ts1 = new Timestamp(fechaSistema.getTime());
              plant_comLocal = plant_comLHome.findByPrimaryKey(oid); 
               
               /*  ojo para setear en la descripcion internacionalizable */
               
               // Collection String entidad, Long atributo, Long entidad_pk
               /* for(Iterator it = dtoe.getAttriTraducible().iterator();it.hasNext();)
                {
                  DTOI18nSICC dto = (DTOI18nSICC)it.next();
                  Entidadi18nLocalHome entidadi18nLocalHome = CMNEjbLocators.getEntidadi18nLocalHome();
                  Entidadi18nLocal i18n = entidadi18nLocalHome.create("INC_PLANT_CONCU", 
                                                                      new Long(1), 
                                                                      dto.getOidIdioma(),
                                                                      dto.getValorI18n(),
                                                                      plantilla.getOid());
                }*/         
              
             /* plant_comLocal_cr = plant_comLHome.create( plant_comLocal.getOid(), plant_comLocal.getOidCanal(),                                             
                                                      plant_comLocal.getOidTipoPlantilla());
                                                     
             */
             plant_comLocal_cr = plant_comLHome.create( null, plant_comLocal.getOidCanal());
             
             /*   se setean las descripciones internacionalizables  
              * crea por cada registro que existe en la entidad I18N la copia correspondiente
              * */
             Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
             Entidadi18nLocal entidadi18nLocal = null;
             Collection colPlantiComi;  
             colPlantiComi = entidadi18nLocalHome.findByEntAtrPK("COM_PLANT_COMIS", new Long(1), dtoe.getOid());
             Iterator ite = colPlantiComi.iterator();
                  while(ite.hasNext()){
                         entidadi18nLocal = (Entidadi18nLocal)ite.next();
                         try{
                              entidadi18nLocalHome.create("COM_PLANT_COMIS", new Long(1),entidadi18nLocal.getIdioma(),
                                                                           entidadi18nLocal.getDetalle(), plant_comLocal_cr.getOid());
                         }catch(PersistenceException e){
                              UtilidadesLog.error(e);
                              throw new MareException(e,UtilidadesError.armarCodigoError(
                                 CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                          }
                        
                  }         
             
             // plant_comLocal_cr.setCodigo(plant_comLocal.getCodigo());                                                      
              plant_comLocal_cr.setComparativo(plant_comLocal.getComparativo());
              plant_comLocal_cr.setTratamientoDiferencial(plant_comLocal.getTratamientoDiferencial());
              plant_comLocal_cr.setOidTipoPlantilla(plant_comLocal.getOidTipoPlantilla()); 
              plant_comLocal_cr.setFecUltimoEstado(ts1);              
              plant_comLocal_cr.setOidEstado(ConstantesCOM.ESTADO_ACTIVO);         
              
              plant_comLHome.merge(plant_comLocal_cr);
              
              // seteo datos de paises
              PlantillasComisionesPaisLocalHome plant_com_paisLHome = null;
              PlantillasComisionesPaisLocal plant_com_paisLocal = null; 
              plant_com_paisLHome = this.getPlantillasComisionesPaisLocalHome();
              Collection coll_plant_com_paisLocal = plant_com_paisLHome.findByPlantilla(oid);
              Long arrPaises[] = new Long[coll_plant_com_paisLocal.size()]; int m=0;
              
              for(Iterator it = coll_plant_com_paisLocal.iterator();it.hasNext();) {     
                    PlantillasComisionesPaisLocal loc_marca = (PlantillasComisionesPaisLocal)it.next();                  
                    plant_com_paisLocal = plant_com_paisLHome.create(loc_marca.getOidPais(),plant_comLocal_cr.getOid());                                
                    arrPaises[m] = loc_marca.getOidPais();
                    m++;
              } 
              // seteo datos de accesos
              PlantillasComisionesAccesoLocalHome plant_com_accesoLHome = null;
              PlantillasComisionesAccesoLocal plant_com_accesoLocal = null; 
              plant_com_accesoLHome = this.getPlantillasComisionesAccesoLocalHome();
              Collection coll_plant_com_accesoLocal = plant_com_accesoLHome.findByPlantilla(oid);
              Long arrAccesos[] = new Long[coll_plant_com_accesoLocal.size()]; m=0;
              
              for(Iterator it = coll_plant_com_accesoLocal.iterator();it.hasNext();) {     
                    PlantillasComisionesAccesoLocal loc_acceso = (PlantillasComisionesAccesoLocal)it.next();                  
                    //POR AHORA SE HARDCODEA EL OID DE CANAL HASTA QUE SE COMPLETE DOCUMENTACION
                    plant_com_accesoLocal = plant_com_accesoLHome.create(plant_comLocal_cr.getOid(), loc_acceso.getOidAcceso(), plant_comLocal.getOidCanal());                                
                    arrAccesos[m] = loc_acceso.getOidAcceso();
                    m++;
                    plant_com_paisLocal.setFecUltimoEstado(ts1);
                    
                    plant_com_paisLHome.merge(plant_com_paisLocal);
                    
                    plant_com_accesoLHome.merge(loc_acceso);
              }    
              
              // seteo datos de marcas
              PlantillasComisionesMarcaLocalHome plant_com_marcaLHome = null;
              PlantillasComisionesMarcaLocal plant_com_marcaLocal = null; 
              plant_com_marcaLHome = this.getPlantillasComisionesMarcaLocalHome();
              Collection coll_plant_com_marcaLocal = plant_com_marcaLHome.findByPlantilla(oid);
              Long arrMarcas[] = new Long[coll_plant_com_marcaLocal.size()]; m=0;
              for(Iterator it = coll_plant_com_marcaLocal.iterator();it.hasNext();)
              {     PlantillasComisionesMarcaLocal loc_marca = (PlantillasComisionesMarcaLocal)it.next();                  
                    plant_com_marcaLocal = plant_com_marcaLHome.create(loc_marca.getOidMarca(),plant_comLocal_cr.getOid());                                
                    arrMarcas[m] = loc_marca.getOidMarca(); 
                    m++;
              }
              // seteamos DTOPlantillaDetalle 
              dtos.setOidPlantilla(plant_comLocal_cr.getOid());
              dtos.setCodPlantilla(plant_comLocal_cr.getCodigo());  // codPlantilla ?
             // dtos.setDescripcion(plant_comLocal_cr.getDescripcion()); // descripcion ?                                  
              dtos.setFechaUltimoEstado(plant_comLocal_cr.getFecUltimoEstado());
              dtos.setArrayMarca(diffArray(arrMarcas));
              dtos.setArrayPais(diffArray(arrPaises));
              dtos.setArrayAcceso(diffArray(arrAccesos)); 
              //Incidencia de copiar 16898
              dtos.setOidCanal(plant_comLocal_cr.getOidCanal());              
              dtos.setOidTipoComision(plant_comLocal_cr.getOidTipoPlantilla());
              dtos.setDescripcion(descrInternacinalizable(plant_comLocal_cr.getOid(), dtoe.getOidIdioma() ));
              String comp = plant_comLocal_cr.getComparativo()==null?new String(""):plant_comLocal_cr.getComparativo().toString();
              if(comp != null)         
                  dtos.setComparativo(("1".equals(comp))?ConstantesCOM.COM_SI:("0".equals(comp))?ConstantesCOM.COM_NO:null);
              String td = plant_comLocal_cr.getTratamientoDiferencial()==null?new String(""):plant_comLocal_cr.getTratamientoDiferencial().toString();
              if(td != null)
                  dtos.setTratamientoDiferencial(("1".equals(td))?ConstantesCOM.COM_SI:("0".equals(comp))?ConstantesCOM.COM_NO:null);           
                  
         } catch (NoResultException nre) {
             ctx.setRollbackOnly();
              UtilidadesLog.error("ERROR ", nre);
             throw new MareException(nre,        
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
         } catch (PersistenceException pe) {
             ctx.setRollbackOnly();
             UtilidadesLog.error("ERROR ", pe);
             throw new MareException(pe,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }    
         UtilidadesLog.info("MONPlantillasComBean.copiarPlantillaCom(DTOOID dtoe): Salida");
         return dtos;
    }
    
    
    
    private String descrInternacinalizable(Long oidPlanti, Long idioma)
        throws MareException{
        UtilidadesLog.info("MONPlantillasComBean.descrInternacinalizable(Long oidPlanti, Long idioma): Entrada");
    
    String descripcion = "";
    StringBuffer query = new StringBuffer();
    RecordSet rs;
    try{
        query.append(" SELECT GEN.VAL_I18N DESCRIPCION ");
        query.append(" FROM  V_GEN_I18N_SICC gen , COM_PLANT_COMIS a  ");
        query.append(" WHERE gen.ATTR_ENTI = 'COM_PLANT_COMIS'  ");
        query.append(" AND gen.ATTR_NUM_ATRI = 1  ");
        query.append(" AND gen.IDIO_OID_IDIO =  " + idioma);
        query.append(" AND gen.VAL_OID = a.OID_PLAN_COMI  ");
        query.append(" AND a.OID_PLAN_COMI =  " + oidPlanti);
            
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        rs = bs.dbService.executeStaticQuery(query.toString());
        
    }
    catch (Exception e) {
         UtilidadesLog.error(e);
         throw new MareException(e, 
         UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
        if(!rs.esVacio()){
            descripcion = rs.getValueAt(0,"DESCRIPCION")!=null?(String)rs.getValueAt(0,"DESCRIPCION"):"";
        }
    UtilidadesLog.info("MONPlantillasComBean.descrInternacinalizable(Long oidPlanti, Long idioma): Salida");
    return descripcion;    
    }
    
    // Marta Montiel
    //14/02/05
    public DTOSalida buscarPlantillasComisiones(DTOBusquedaPlantillas dtoe) 
        throws MareException {
        
        UtilidadesLog.info("MONPlantillasComBean.buscarPlantillasComisiones(DTOBusquedaPlantillas dtoe): Entrada");
        DTOSalida dtos = new DTOSalida();
        DAOPlantillasCom dao = new DAOPlantillasCom();
        RecordSet rs = dao.buscarPlantillasComisiones(dtoe);
        if(rs.esVacio()){
            throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        dtos.setResultado(rs);
        UtilidadesLog.info("MONPlantillasComBean.buscarPlantillasComisiones(DTOBusquedaPlantillas dtoe): Salida");
        return dtos;
    }

  

   private PlantillasComisionesMarcaLocalHome getPlantillasComisionesMarcaLocalHome() throws MareException {      
      return new PlantillasComisionesMarcaLocalHome();
   }

   private PlantillasComisionesPaisLocalHome getPlantillasComisionesPaisLocalHome() throws MareException {      
      return new PlantillasComisionesPaisLocalHome();
   }

   private PlantillasComisionesAccesoLocalHome getPlantillasComisionesAccesoLocalHome() throws MareException {      
      return new PlantillasComisionesAccesoLocalHome();
   }

   private PlantillasComisionesLocalHome getPlantillasComisionesLocalHome() throws MareException {      
      return new PlantillasComisionesLocalHome();
   }
  
}