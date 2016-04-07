package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.PedGrupoProceData;
import es.indra.belcorp.mso.PedProceData;
import es.indra.belcorp.mso.PedProceViewData;
import es.indra.belcorp.mso.PedProgrData;
import es.indra.belcorp.mso.PedSubtiPosicViewData;
import es.indra.belcorp.mso.PedTipoPosicData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class DAOProceso {
    public DAOProceso() {
    }
    public Vector obtenerGrupoProceso(PedGrupoProceData pedGrupoProceFrom,PedGrupoProceData pedGrupoProceTo, HashMap userProperties) throws MareException
     {
       UtilidadesLog.info("DAOProceso.obtenerGrupoProceso(PedGrupoProceData pedGrupoProceFrom,PedGrupoProceData pedGrupoProceTo, HashMap userProperties): Entrada");
             RecordSet rs = new RecordSet();
             StringBuffer query = new StringBuffer();
             Vector parametros = new Vector();
             BelcorpService bs;
             
             //int i = 0;
            try{
                 bs = BelcorpService.getInstance();
           
             } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
             }
             query.append(" SELECT PED_GRUPO_PROCE.OID_GRUP_PROC, PED_GRUPO_PROCE.DES_GRUP_PROC ");
             query.append(" FROM    PED_GRUPO_PROCE ");
             try{
             
                 rs = bs.dbService.executeStaticQuery(query.toString());
              
             } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
             if(!rs.esVacio())
             { 
               for(int i= 0; i < rs.getRowCount(); i++){
                 PedGrupoProceData salida = new PedGrupoProceData();
                  salida.setId(new Long (((BigDecimal) rs.getValueAt(i,"OID_GRUP_PROC")).toString()));
                  salida.setDesGrupProc((String) rs.getValueAt(i, "DES_GRUP_PROC"));          
                  parametros.add(salida); 
               }
              
             }
             UtilidadesLog.info("DAOMantenimientoMotivoRechPais.obtenerProcesos(DTOBelcorp dtoe): Salida");
             
             return parametros; 
     }
     public Vector obtenerPrograma(PedProgrData  pedProgrFrom, PedProgrData  pedProgrTo, HashMap userProperties) throws MareException
     {
       UtilidadesLog.info("DAOProceso.obtenerPrograma(PedProgrData pedGrupoProceFrom,PedProgrData pedGrupoProceTo, HashMap userProperties): Entrada");
       RecordSet rs = new RecordSet();
       StringBuffer query = new StringBuffer();
       Vector parametros = new Vector();
       BelcorpService bs;
       
             
            try{
                 bs = BelcorpService.getInstance();
           
             } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
             }
            query.append(" SELECT PED_PROGR.OID_PROG, PED_PROGR.VAL_NOMB ");
            query.append(" FROM PED_PROGR");
            query.append(" ORDER BY PED_PROGR.VAL_NOMB ");
            try
            {
              rs = bs.dbService.executeStaticQuery(query.toString());
            }catch(Exception ex)
            {
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             if(!rs.esVacio())
             {
              
               for(int i = 0;  i < rs.getRowCount(); i++){ 
                 PedProgrData salida = new PedProgrData();
                 salida.setId(new Long (((BigDecimal) rs.getValueAt(i,"OID_PROG")).toString()));
                 salida.setValNomb((String) rs.getValueAt(i,"VAL_NOMB"));
                 parametros.add(salida);
               }
                        
             }
            
             UtilidadesLog.info("DAOProceso.obtenerPrograma(PedGrupoProceData pedGrupoProceFrom,PedGrupoProceData pedGrupoProceTo, HashMap userProperties): Salida");
             return parametros; 
     }
     public Vector obtenerCodigoProcesoRevision(PedProceViewData pedProceViewFrom, PedProceViewData pedProceViewTo, HashMap userProperties) throws MareException
     {
             UtilidadesLog.info("DAOProceso.obtenerCodigoProcesoRevision(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedTipoPosicTo, HashMap userProperties): Entrada");
             RecordSet rs = new RecordSet();
             StringBuffer query = new StringBuffer();
             Vector parametros = new Vector();
             BelcorpService bs;
             DTOSalida dtoSalida = new DTOSalida();
             
             try{
                 bs = BelcorpService.getInstance();
             
             } catch(MareMiiServiceNotFoundException ex){
             
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
             }
             query.append(" select PED_PROCE.OID_PROC, V_GEN_I18N_SICC.VAL_I18N ");
             query.append(" from V_GEN_I18N_SICC, PED_PROCE ");
             query.append(" where V_GEN_I18N_SICC.ATTR_ENTI = 'PED_PROCE' and ");
             query.append(" V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 and ");
             query.append(" V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 and ");
             query.append(" V_GEN_I18N_SICC.VAL_OID = PED_PROCE.OID_PROC ");
             query.append(" ORDER BY V_GEN_I18N_SICC.VAL_I18N ");
             
             try
             {
                 rs = bs.dbService.executeStaticQuery(query.toString());
             }catch(Exception ex)
             {
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
             if(!rs.esVacio())
             {
              
               for(int i = 0;  i < rs.getRowCount(); i++){ 
                 PedProceViewData salida = new PedProceViewData();
                 salida.setId(new Long (((BigDecimal) rs.getValueAt(i,"OID_PROC")).toString()));
                 salida.setDescripcion((String) rs.getValueAt(i,"VAL_I18N"));
                 parametros.add(salida);
               }
                        
             }
             UtilidadesLog.info("DAOProceso.obtenerCodigoProcesoRevision(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedTipoPosicTo, HashMap userProperties): Entrada");
             return parametros;
     }
     public Vector obtenerTipoPosicion(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedTipoPosicTo, HashMap userProperties)throws MareException
     {
             UtilidadesLog.info("DAOProceso.obtenerCodigoProcesoRevision(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedTipoPosicTo, HashMap userProperties): Entrada");
             RecordSet rs = new RecordSet();
             StringBuffer query = new StringBuffer();
             Vector parametros = new Vector();
             BelcorpService bs;
             
             int cont = 0;
             try{
                 bs = BelcorpService.getInstance();
             
             } catch(MareMiiServiceNotFoundException ex){
             
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
             }
             query.append(" select ped_tipo_posic.OID_TIPO_POSI, V_GEN_I18N_SICC.VAL_I18N    ");
             query.append(" from V_GEN_I18N_SICC, ped_tipo_posic ");
             query.append("  where V_GEN_I18N_SICC.ATTR_ENTI = 'PED_TIPO_POSIC' and   ");
             query.append("  V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 and  ");
             query.append("  V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 and ");
             query.append("  V_GEN_I18N_SICC.VAL_OID = ped_tipo_posic.OID_TIPO_POSI ");
            
             try
             {
                 rs = bs.dbService.executeStaticQuery(query.toString());
               
             }catch(Exception ex)
             {
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
             if(!rs.esVacio())
             { 
              for(int i = 0; i < rs.getRowCount(); i++){ 
                 PedTipoPosicData salida = new PedTipoPosicData();
                 salida.setId(new Long (((BigDecimal) rs.getValueAt(i,"OID_TIPO_POSI")).toString()));
                 salida.setDescripcion((String)  rs.getValueAt(i,"VAL_I18N"));
                 parametros.add(salida);
              }
             
             }
             UtilidadesLog.info("DAOProceso.obtenerCodigoProcesoRevision(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedTipoPosicTo, HashMap userProperties): Entrada");
             return parametros;
     }
     public Vector obtenerSubtipoPosicion(PedSubtiPosicViewData pedSubtiPosicViewFrom, PedSubtiPosicViewData pedSubtiPosicViewTo, HashMap userProperties)throws MareException
     {
             UtilidadesLog.info("DAOProceso.obtenerSubtipoPosicion(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedTipoPosicTo, HashMap userProperties): Entrada");
             RecordSet rs = new RecordSet();
             StringBuffer query = new StringBuffer();
             Vector parametros = new Vector();
             BelcorpService bs;
             
             
             try{
                 bs = BelcorpService.getInstance();
             
             } catch(MareMiiServiceNotFoundException ex){
             
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
             }
             query.append(" select PED_SUBTI_POSIC.OID_SUBT_POSI, V_GEN_I18N_SICC.VAL_I18N  ");
             query.append(" from V_GEN_I18N_SICC, PED_SUBTI_POSIC ");
             query.append(" where V_GEN_I18N_SICC.ATTR_ENTI = 'PED_SUBTI_POSIC' and ");
             query.append(" V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 and ");
             query.append(" V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 and ");
             query.append(" V_GEN_I18N_SICC.VAL_OID = PED_SUBTI_POSIC.OID_SUBT_POSI ");
             try
             {
                 rs = bs.dbService.executeStaticQuery(query.toString());
             }catch(Exception ex)
             {
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
             if(!rs.esVacio())
             {
               for(int i = 0; i < rs.getRowCount(); i++){
                 PedSubtiPosicViewData salida = new PedSubtiPosicViewData();
                 salida.setId(new Long(((BigDecimal) rs.getValueAt(i,"OID_SUBT_POSI")).toString()));
                 salida.setDescripcion((String) rs.getValueAt(i,"VAL_I18N"));
                 parametros.add(salida);
              }
              
             }
             UtilidadesLog.info("DAOProceso.obtenerSubtipoPosiocion(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedTipoPosicTo, HashMap userProperties): Salida");
             return parametros;
     }
     
     public Hashtable guardarProceso(PedProceData pedProce, Vector localizationLabels, HashMap userProperties) throws MareException
     {
        UtilidadesLog.info("DAOProceso.guardarProceData(PedProceData pedProce): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT PED_PROC_SEQ.NEXTVAL FROM DUAL ");
        try {
              rsPK = bs.dbService.executeStaticQuery(query.toString());
                   
           } catch (Exception ex) {
               ex.printStackTrace();
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
        if(rsPK != null && !rsPK.esVacio()) {
               id = Long.valueOf(((BigDecimal)rsPK.getValueAt(0,0)).toString());
           }
        update.append(" INSERT INTO PED_PROCE ( ");
        update.append("OID_PROC,  ");
        update.append("COD_PROC, ");
        update.append("GRPR_OID_GRUP_PROC, ");
        update.append("PROG_OID_PROG,  ");
        update.append("TPOS_OID_TIPO_POSI, ");
        update.append("PROC_OID_PROC,  ");
        update.append("STPO_OID_SUBT_POSI ");
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + pedProce.getCodProc() + "' ");
        
        if(pedProce.getGrprOidGrupProc() != null ){ 
            update.append( "," + pedProce.getGrprOidGrupProc().getId() );
        }else
        {
          update.append(", NULL");
        }
        
        if(pedProce.getProgOidProg() != null)
        {
          update.append(", " + pedProce.getProgOidProg().getId() );
        }else
        {
           update.append(", NULL");
        }
        if(pedProce.getTposOidTipoPosi() != null)
        {
          update.append(" , " + pedProce.getTposOidTipoPosi().getId());
        }else
        {
          update.append(" , NULL");
        }
        if( pedProce.getProcOidProc() != null){
          update.append("," + pedProce.getProcOidProc().getId()); 
        }else
        {
          update.append(" , NULL");
        }
        
        if( pedProce.getStpoOidSubtPosi() != null )
        {
          update.append(" ," + pedProce.getStpoOidSubtPosi().getId());
        }else
        {
          update.append(" ,NULL");
        }
         update.append( " ) ");
        
        try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
              ex.printStackTrace();
          if(ex.toString().indexOf("ORA-00001")!= -1) {
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_CLAVE_DUPLICADA));
               } else {
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }
        }
        // Internacionalización
           int cant = localizationLabels.size();
           GenDetaSiccData genDetaSiccData = null;
           RecordSet rsPKInter = null;
           StringBuffer queryInter = null;
           Long idInter = null;        
           StringBuffer updateInter = null;
           
           for(int i= 0; i< cant; i++){
                         
               queryInter = new StringBuffer();             
               queryInter.append(" SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");         
               
               try {
                   rsPKInter = bs.dbService.executeStaticQuery(queryInter.toString());
                       
               } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }
               
               if(rsPKInter != null && !rsPKInter.esVacio()) {
                   idInter = Long.valueOf(((BigDecimal)rsPKInter.getValueAt(0,0)).toString());
               }      
               
               genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
               updateInter = new StringBuffer();    
                   
               updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
               updateInter.append("OID_I18N, "); 
               updateInter.append("ATTR_ENTI, "); 
               updateInter.append("ATTR_NUM_ATRI, "); 
               updateInter.append("IDIO_OID_IDIO, "); 
               updateInter.append("VAL_I18N, ");                 
               updateInter.append("VAL_OID "); 
               updateInter.append(" ) VALUES ( ");
               updateInter.append(idInter + ", ");
               updateInter.append(" 'PED_PROCE', ");
               updateInter.append(" 1, ");            
               updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
               updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
               updateInter.append(id + " )");  
               try {
                   int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
               } catch (Exception ex) {
                   ex.printStackTrace();
                   
                   if(ex.toString().indexOf("ORA-00001")!= -1) {
                       throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                   } else {
                       throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                   }
               }
           }
           
         Hashtable primaryKey = new Hashtable();
         primaryKey.put("id", id);        
       
         UtilidadesLog.info("DAOProceso.guardarProceData(PedProceData pedProce): Salida");
         return primaryKey;
      }
     public Vector query(PedProceData pedProceFrom, PedProceData pedProceTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
        UtilidadesLog.info("DAOProceso.guardarProceData(PedProceData pedProceFrom, PedProceData pedProceTo, HashMap userProperties, int pageCount, int pageSize): Entrada");
       if(pageCount == null)
           {
               pageCount = new Integer(1);
           }
           if(pageSize == null)
           {
               pageSize = new Integer(0x7fffffff);
           }
           
           RecordSet rs = new RecordSet();
           StringBuffer query = new StringBuffer();
           BelcorpService bs;
           try {
             bs = BelcorpService.getInstance();
           } catch (MareMiiServiceNotFoundException e) {
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
           }
          query.append("SELECT des.oid_proc, des.cod_proc, descripcion.val_i18n DESCRIPCION, ");
          query.append(" ped_grupo_proce.des_grup_proc, ped_progr.val_nomb, ");
          query.append(" codigo.val_i18n CODIGO, tipoposi.val_i18n TIPO, ");
          query.append(" subtipoposi.val_i18n SUBTIPO , b.oid_proc,");
          query.append(" ped_grupo_proce.oid_grup_proc, ped_progr.oid_prog,  ");
          query.append(" tipo.oid_tipo_posi, subtipoposi.val_oid ");
          
          query.append(" from   ped_proce des, v_gen_i18n_sicc descripcion, ped_grupo_proce, ");
          query.append(" ped_progr, ped_proce b, v_gen_i18n_sicc codigo, v_gen_i18n_sicc tipoPosi, ped_tipo_posic tipo, ");
          query.append(" v_gen_i18n_sicc subTipoPosi, ped_subti_posic");
          query.append(" where ");
          query.append(" des.GRPR_OID_GRUP_PROC = ped_grupo_proce.OID_GRUP_PROC(+) and ");
          query.append(" des.PROC_OID_PROC = b.OID_PROC (+)and");
          query.append(" des.PROG_OID_PROG = ped_progr.OID_PROG(+) and ");
          query.append(" des.TPOS_OID_TIPO_POSI = tipo.OID_TIPO_POSI(+) and");
          query.append(" des.STPO_OID_SUBT_POSI = ped_subti_posic.OID_SUBT_POSI(+) and ");
          
          query.append(" descripcion.ATTR_ENTI(+) = 'PED_PROCE' and  ");
          query.append(" descripcion.IDIO_OID_IDIO(+) = 1 and ");
          query.append(" descripcion.ATTR_NUM_ATRI (+)= 1 and");
          query.append(" descripcion.VAL_OID(+) = des.OID_PROC and ");
          
          query.append(" codigo.ATTR_ENTI(+) = 'PED_PROCE' and ");
          query.append(" codigo.IDIO_OID_IDIO(+) = 1 and  ");
          query.append(" codigo.ATTR_NUM_ATRI(+) = 1 and ");
          query.append(" codigo.VAL_OID(+) = des.OID_PROC and ");
          
          query.append(" tipoPosi.ATTR_ENTI(+) = 'PED_TIPO_POSIC' and ");
          query.append(" tipoPosi.IDIO_OID_IDIO(+) = 1 and ");
          query.append(" tipoPosi.ATTR_NUM_ATRI(+) = 1 and ");
          query.append(" tipoPosi.VAL_OID(+) = tipo.OID_TIPO_POSI and ");
          
          query.append(" subTipoPosi.ATTR_ENTI(+) = 'PED_SUBTI_POSIC' and ");
          query.append(" subTipoPosi.IDIO_OID_IDIO(+) = 1 and ");
          query.append(" subTipoPosi.ATTR_NUM_ATRI(+) = 1 and ");
          query.append(" subTipoPosi.VAL_OID(+) = ped_subti_posic.OID_SUBT_POSI ");
          
          if(pedProceFrom.getCodProc() != null )
          {
            query.append(" and  des.COD_PROC = '" + pedProceFrom.getCodProc() + "'");
          }
          if(pedProceFrom.getDescripcion() != null){
           query.append( "and descripcion.VAL_I18N  = '" + pedProceFrom.getDescripcion() + "'");
          }
          if(pedProceFrom.getGrprOidGrupProc() != null )
          {
            query.append(" and des.GRPR_OID_GRUP_PROC = " + pedProceFrom.getGrprOidGrupProc().getId());
          }
          if(pedProceFrom.getProgOidProg() != null){
             query.append(" and des.PROG_OID_PROG = " + pedProceFrom.getProgOidProg().getId());
          }
          if(pedProceFrom.getTposOidTipoPosi() != null )
          {
             query.append(" and des.TPOS_OID_TIPO_POSI = " + pedProceFrom.getTposOidTipoPosi().getId());
          }
          if(pedProceFrom.getStpoOidSubtPosi() != null)
          {
             query.append(" and des.STPO_OID_SUBT_POSI =" + pedProceFrom.getStpoOidSubtPosi().getId());
          }
          if(pedProceFrom.getProcOidProc() != null)
          {
             query.append(" and codigo.VAL_OID =  " + pedProceFrom.getProcOidProc().getId() );
          }
          if(pedProceFrom.getId() != null)
          {
            query.append(" and des.OID_PROC = " + pedProceFrom.getId());
          }
          query.append(" order by des.COD_proc desc");
          try {
              rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
           
           int cant = rs.getRowCount();
           Vector result = new Vector();
           PedProceData proceso = null;
           PedSubtiPosicViewData subTipoPosic = null;
           PedTipoPosicData tipoPosic = null;
           PedProceViewData codiProce = null;
           PedProgrData programa = null;
           PedGrupoProceData  grupoProce = null;
           BigDecimal oidSubTipo = null;
           BigDecimal oidCodProce = null;
           BigDecimal oidPrograma = null;
           BigDecimal oidGrupoProce = null;
           BigDecimal oidTipoPosic = null;
           
           
           int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
           int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
           
           UtilidadesLog.debug("rsSaltar: " + rsSaltar);
           UtilidadesLog.debug("rsMostrar: " + rsMostrar);
           
           for(int i=0; i < cant; i++){
           
               if(i < rsSaltar ) {
                 continue;
               }
               if(i < rsMostrar){
               try{
                   proceso = new PedProceData(); 
                   proceso.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PROC")).toString()));
                   proceso.setCodProc((String)rs.getValueAt(i,"COD_PROC"));
                   proceso.setDescripcion((String)rs.getValueAt(i,"DESCRIPCION"));                
                   
                   oidGrupoProce = (BigDecimal)rs.getValueAt(i,"OID_GRUP_PROC");
                   
                   if(oidGrupoProce != null){
                   
                       grupoProce = new PedGrupoProceData();
                       grupoProce.setId(Long.valueOf(oidGrupoProce.toString()) );
                       grupoProce.setDesGrupProc((String)rs.getValueAt(i,"DES_GRUP_PROC"));                
                       proceso.setGrprOidGrupProc(grupoProce);
                   }
                   oidPrograma = (BigDecimal)rs.getValueAt(i,"OID_PROG");
                   if(oidPrograma != null){
                   
                       programa = new PedProgrData();
                       programa.setId(Long.valueOf(oidPrograma.toString()));
                       programa.setValNomb((String)rs.getValueAt(i,"VAL_NOMB"));
                       proceso.setProgOidProg(programa);
                   }
                   oidCodProce = (BigDecimal)rs.getValueAt(i,"OID_PROC");
                   if(oidCodProce != null){
                       codiProce = new PedProceViewData();
                       codiProce.setId(Long.valueOf(oidCodProce.toString()));
                       codiProce.setDescripcion((String)rs.getValueAt(i,"CODIGO"));
                       proceso.setProcOidProc(codiProce);
                   }
                   oidTipoPosic = (BigDecimal)rs.getValueAt(i,"OID_TIPO_POSI");
                   if(oidTipoPosic != null){
                       tipoPosic =  new PedTipoPosicData();
                       tipoPosic.setId(Long.valueOf(oidTipoPosic.toString()));
                       tipoPosic.setDescripcion((String)rs.getValueAt(i,"TIPO"));
                       proceso.setTposOidTipoPosi(tipoPosic);
                   }
                   oidSubTipo = (BigDecimal)rs.getValueAt(i,"VAL_OID");
                   if(oidSubTipo != null){
                       subTipoPosic = new PedSubtiPosicViewData();
                       subTipoPosic.setId(Long.valueOf(oidSubTipo.toString()));
                       subTipoPosic.setDescripcion((String)rs.getValueAt(i,"SUBTIPO"));
                       proceso.setStpoOidSubtPosi(subTipoPosic);
                   }
                   
                   result.add(proceso);
               }catch(Exception ex)
               {
                  ex.printStackTrace();
                  UtilidadesLog.error("ERROR ", ex);
               }
               }else
               {
                 break;
               }
           }
            UtilidadesLog.debug("result: " + result);
            UtilidadesLog.info("DAOProceso.query(PedProceData pedProceFrom, PedProceData pedProceTo, HashMap userProperties, int pageCount, int pageSize): Salida");
            return result; 
     }
     public void remove(Vector pedProceFrom) throws MareException
     {
           UtilidadesLog.info("DAOProceso.remove(Vector pedProceFrom): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = pedProceFrom.size();
           PedProceData pedFormuData = null;
           String oidProceso = "";
           
           for (int j = 0; j < cant; j++) {
               pedFormuData = (PedProceData)pedProceFrom.get(j);
                
               oidProceso = oidProceso + "," + pedFormuData.getId();
           }
           
           update.append("delete PED_PROCE  ");
           update.append("where OID_PROC in ( " + oidProceso.substring(1) + ") ");
           
           updateInter.append("delete GEN_I18N_SICC_COMUN ");
           updateInter.append(" where VAL_OID in ( " + oidProceso.substring(1) + ") ");
           updateInter.append(" and ATTR_NUM_ATRI = 1 ");
           updateInter.append(" and ATTR_ENTI = 'PED_PROCE' ");
           
           try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
               int cantRegActualizados1 = bs.dbService.executeUpdate(updateInter.toString());
           } catch (Exception ex) {
               ex.printStackTrace();          
               if(ex.toString().indexOf("ORA-02292")!= -1) {
                     throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_BORRADO_DE_DATOS));
               } else {
                     throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }                   
           }
           
           UtilidadesLog.info("DAOProceso.remove(Vector pedProceFrom): Salida");
     }
     public void update(PedProceData pedProce, Vector localizationLabels) throws MareException
     {
        UtilidadesLog.info("DAOProceso.update(PedProceData pedProce): Entrada");
          
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
           StringBuffer queryInter = null;
           StringBuffer deleteInter = null;
           try{
           deleteInter = new StringBuffer();
           deleteInter.append(" delete GEN_I18N_SICC_COMUN ");
           deleteInter.append(" where VAL_OID = " + pedProce.getId());
           deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
           deleteInter.append(" and ATTR_ENTI = 'PED_PROCE' ");
           }catch(Exception ex)
           {
             ex.printStackTrace();
           }
          try {
               int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
               
           } catch (Exception ex) {
               ex.printStackTrace();                      
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                   CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
           }
           
           update.append("UPDATE PED_PROCE SET");
           update.append(" COD_PROC = '" + pedProce.getCodProc() + "'");
           update.append(" , GRPR_OID_GRUP_PROC =" + pedProce.getGrprOidGrupProc().getId());
           if(pedProce.getProgOidProg() != null){
           update.append(" , PROG_OID_PROG = " + pedProce.getProgOidProg().getId());
           } else
           {
              update.append(" , PROG_OID_PROG = NULL" );
           }
           if(pedProce.getTposOidTipoPosi() != null)
           {
              update.append(" , TPOS_OID_TIPO_POSI  =" + pedProce.getTposOidTipoPosi().getId());
           }else
           {
              update.append("  , TPOS_OID_TIPO_POSI = NULL ");
           }
           if(pedProce.getStpoOidSubtPosi() != null)
           {
              update.append(" , STPO_OID_SUBT_POSI = " + pedProce.getStpoOidSubtPosi().getId());
           
           }else
           {
              update.append(" , STPO_OID_SUBT_POSI = NULL ");
           }
           update.append(" where OID_PROC = "+ pedProce.getId());
           try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
               
           } catch (Exception ex) {
               ex.printStackTrace();
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
          
           int cant = localizationLabels.size();
           GenDetaSiccData genDetaSiccData = null;
           RecordSet rsPKInter = null;
           Long idInter = null;   
           StringBuffer updateInter = null;
            
           for(int i = 0; i < cant; i++){
           
               genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);                    
               queryInter = new StringBuffer();   
               queryInter.append(" SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");  
                
                try {
                   rsPKInter = bs.dbService.executeStaticQuery(queryInter.toString());
                       
               } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }
               
               if(rsPKInter != null && !rsPKInter.esVacio()) {
                   idInter = Long.valueOf(((BigDecimal)rsPKInter.getValueAt(0,0)).toString());
               }      
               updateInter = new StringBuffer(); 
               updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
               updateInter.append("OID_I18N, "); 
               updateInter.append("ATTR_ENTI, "); 
               updateInter.append("ATTR_NUM_ATRI, "); 
               updateInter.append("IDIO_OID_IDIO, "); 
               updateInter.append("VAL_I18N, ");                 
               updateInter.append("VAL_OID "); 
               updateInter.append(" ) VALUES ( ");
               updateInter.append(idInter + ", ");
               updateInter.append(" 'PED_PROCE', ");
               updateInter.append(" 1, ");            
               updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
               updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
               updateInter.append(pedProce.getId() + " )");   
               
               try {
                   int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
               } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }
             
           }
          
                  
           UtilidadesLog.info("DAOProceso.update( PedProceData pedProce ): Salida");
          
     }
}
