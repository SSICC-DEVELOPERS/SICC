/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no pRecordSet ermitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.util.Vector;
import es.indra.sicc.dtos.rec.DTOBusqueda;
import es.indra.sicc.dtos.rec.DTOOperacion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;


public class DAOOperacion  {
    public DAOOperacion() {
    }
    
    public RecordSet obtenerOperaciones (DTOBusqueda dtoE)throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerOperaciones (DTOBusqueda):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        sql.append("    SELECT O.OID_OPER AS OID, O.COD_OPER, I.VAL_I18N  AS DES ,   ");
        sql.append("    O.VAL_DESC_LARG   ");
        sql.append("    FROM REC_OPERA O, V_GEN_I18N_SICC I   ");
        sql.append("    WHERE I.ATTR_ENTI = 'REC_OPERA'   ");
        sql.append("    AND I.IDIO_OID_IDIO = ?  ");
        parametros.add(dtoE.getOidIdioma()); 
        sql.append("   AND I.VAL_OID = O.OID_OPER ");
        sql.append("   AND PAIS_OID_PAIS = ? ");
        parametros.add(dtoE.getOidPais());
        
        if(dtoE.getCodOperacion() != null){
            sql.append("    AND O.COD_OPER LIKE '" + dtoE.getCodOperacion() + "' ");
       
        }
        if(dtoE.getDescripcionCorta() != null){
            sql.append("    AND I.VAL_I18N LIKE '" + dtoE.getDescripcionCorta() + "' ");
            //incidencia 12870
        
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoE);
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerOperaciones: Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerOperaciones (DTOBusqueda):Salida");
        return resultado;
    }
    
    /*
     * @ssaavedr, 26/06/2006; se const. de acuerdo a inc.: BELC300021659
     */
    public DTOSalida obtenerOperacionesDescLarga(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerOperacionesDescLarga(DTOBelcorp dtoE): Entrada");
        
        StringBuffer sql = new StringBuffer();
        RecordSet rs = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        
        sql.append("SELECT OID_OPER, VAL_DESC_LARG");
        sql.append(" FROM REC_OPERA");
        sql.append(" WHERE PAIS_OID_PAIS = " + dtoE.getOidPais().longValue());
        sql.append(" ORDER BY VAL_DESC_LARG");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
                                                                       
         try {
             rs = (RecordSet) bs.dbService.executeStaticQuery(sql.toString());
             if(!rs.esVacio()){
                dtos.setResultado(rs);
             }
         }catch (Exception e) {
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }           
         UtilidadesLog.info("DAOOperacion.obtenerOperacionesDescLarga(DTOBelcorp dtoE): Salida");
         return dtos;   
         
    }
    
    /*
     * @ssaavedr, 26/06/2006; se const. de acuerdo a inc.: BELC300021659
     */
    public DTOSalida recargaTipoOperacion(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOOperacion.recargaTipoOperacion(DTOOID dto): Entrada");
        
        StringBuffer sql = new StringBuffer();
        RecordSet rs = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        
        sql.append("SELECT OID_TIPO_OPER, VAL_TIPO_OPER");
        sql.append(" FROM REC_TIPOS_OPERA");
        sql.append(" WHERE ROPE_OID_OPER = " + dto.getOid().longValue());

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
                                                                       
         try {
             rs = (RecordSet) bs.dbService.executeStaticQuery(sql.toString());
             if(!rs.esVacio()){
                dtos.setResultado(rs);
             }
         }catch (Exception e) {
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }           
         UtilidadesLog.info("DAOOperacion.recargaTipoOperacion(DTOOID dto): Salida");
         return dtos;   
         
    }
    
    public RecordSet obtenerTiposOperacion (DTOOID dtoE)throws MareException{
        UtilidadesLog.info("DAOOperacion.obtenerTiposOperacion (DTOOID):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
                
        sql.append(" SELECT T.OID_TIPO_OPER, T.VAL_TIPO_OPER,   ");   
        //sql.append(" T.VAL_DESC_TIPO_OPER, T.IND_CAMP_REFE_UNIC, "); 
        sql.append(" (SELECT idio.VAL_I18N  ");
        sql.append(" FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_TIPOS_OPERA' ");
        sql.append(" AND idio.ATTR_NUM_ATRI = 1 ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND T.OID_TIPO_OPER = idio.VAL_OID) AS descripcionOperacion, ");
        
        sql.append(" T.IND_CAMP_REFE_UNIC, ");
        sql.append(" T.NUM_DIAS_HACI_ATRA, T.VAL_INFO_EBEL_NOTI,  ");   
        sql.append(" T.IND_DEVU_ESTA_FACT, T.IND_ENVI_ESTA_FACT, ");   
       
        sql.append(" T.MOBL_OID_BLOQ_DIFE, "); 
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_MOTIV_BLOQU' "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = T.MOBL_OID_BLOQ_DIFE), ");      
        
        sql.append(" T.MOBL_OID_RECL_ANTE, ");  
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_MOTIV_BLOQU' "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = T.MOBL_OID_RECL_ANTE), ");   
        
        sql.append(" T.MOBL_OID_BLOQ_IMPO, "); 
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_MOTIV_BLOQU' "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = T.MOBL_OID_BLOQ_IMPO), ");   
          
        sql.append(" T.MOBL_OID_BLOQ_UNID, ");     
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_MOTIV_BLOQU' "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = T.MOBL_OID_BLOQ_UNID),  ");  
             
        sql.append(" T.MRDB_OID_MOTI_RECH_DESB,");     
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio "); 
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_MOTIV_RECHA_DESBL' "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.VAL_OID = T.MRDB_OID_MOTI_RECH_DESB)  ");  
            
        sql.append(" FROM REC_TIPOS_OPERA T   ");        
        sql.append(" WHERE  T.ROPE_OID_OPER = ?   ");  
        parametros.add(dtoE.getOid());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerTiposOperacion: Exception",e);                                                    
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerTiposOperacion (DTOOID):Salida");
        return resultado;
    }
    
    
    public RecordSet obtenerMovimientoAlmacen (DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerMovimientoAlmacen (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        sql.append("    SELECT T.OID_TIPO_MOVI_ALMA,    ");
        sql.append("    (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        sql.append("    WHERE idio.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC'   ");
        sql.append("    AND idio.IDIO_OID_IDIO = ?  ");
        parametros.add(dtoE.getOidIdioma());
        sql.append("    AND idio.VAL_OID = T.OID_TIPO_MOVI_ALMA  ) as descripcion ");
        sql.append("    FROM BEL_TIPO_MOVIM_ALMAC T ");
        sql.append("    WHERE T.PAIS_OID_PAIS = ?   ");
        parametros.add(dtoE.getOidPais());
        sql.append("    ORDER BY descripcion   ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerMovimientoAlmacen: Exception",e);                                                     
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerMovimientoAlmacen (DTOBelcorp):Salida");
        return resultado;
    }
    
     public RecordSet obtenerMotivosBloqueo  (DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerMotivosBloqueo (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        sql.append("    SELECT M.OID_MOTI_BLOQ, I.VAL_I18N AS DESCRIPCION    ");
        sql.append("    FROM REC_MOTIV_BLOQU M , V_GEN_I18N_SICC I ");
        sql.append("    WHERE I.ATTR_ENTI = 'REC_MOTIV_BLOQU'   ");
        sql.append("    AND I.IDIO_OID_IDIO = ?  ");
        parametros.add(dtoE.getOidIdioma());
        sql.append("    AND I.VAL_OID = M.OID_MOTI_BLOQ ");
        sql.append("    AND M.PAIS_OID_PAIS = ?   ");
        parametros.add(dtoE.getOidPais());
        sql.append("    ORDER BY DESCRIPCION   ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerMotivosBloqueo : Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerMotivosBloqueo (DTOBelcorp):Salida");
        return resultado;
    }
    
     public RecordSet obtenerPrecioEnvia  (DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerPrecioEnvia (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        sql.append("    SELECT PE.OID_PREC_ENVI,    ");
        sql.append("   I.VAL_I18N   AS DESCRIPCION ");
        sql.append("    FROM REC_PRECI_ENVIA PE , V_GEN_I18N_SICC I   ");
        sql.append("    WHERE I.ATTR_ENTI = 'REC_PRECI_ENVIA'   ");
        sql.append("    AND I.IDIO_OID_IDIO = ?");
        parametros.add(dtoE.getOidIdioma());
        sql.append("    AND I.VAL_OID = PE.OID_PREC_ENVI ");
        sql.append("    ORDER BY DESCRIPCION     ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerPrecioEnvia : Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerPrecioEnvia (DTOBelcorp):Salida");
        return resultado;
    }
    
    public RecordSet obtenerPrecios  (DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerPrecios (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();  
        
        sql.append("    SELECT P.OID_PREC,    ");
        sql.append("    I.VAL_I18N  AS  DESCRIPCION ");
        sql.append("    FROM REC_PRECI P , V_GEN_I18N_SICC I");
        sql.append("    WHERE I.ATTR_ENTI = 'REC_PRECI'   ");
        sql.append("    AND I.IDIO_OID_IDIO = ?  ");
        parametros.add(dtoE.getOidIdioma());
        sql.append("    AND I.VAL_OID = P.OID_PREC   ");
        sql.append("    ORDER BY DESCRIPCION   ");

                                                                  
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerPrecios : Exception",e);                                                  
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerPrecios (DTOBelcorp):Salida");
        return resultado;
    }
    
     public RecordSet obtenerTipoSolicitud  (DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerTipoSolicitud (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        //Se obtiene el oid de la tabla ped_tipo_solic_pais y la descripcion 
        //de la tabla ped_solic_pais
        sql.append("    SELECT TSP.OID_TIPO_SOLI_PAIS,     ");
        sql.append("    (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  ");
        sql.append("    WHERE idio.ATTR_ENTI = 'PED_TIPO_SOLIC'    ");
        sql.append("    AND idio.IDIO_OID_IDIO = ?  ");
        parametros.add(dtoE.getOidIdioma());
        sql.append("    AND idio.VAL_OID = TS.OID_TIPO_SOLI) as descripcion ");
        sql.append("    FROM PED_TIPO_SOLIC ts, PED_TIPO_SOLIC_PAIS TSP ");
        sql.append("    WHERE TS.OID_TIPO_SOLI = TSP.TSOL_OID_TIPO_SOLI   ");
        sql.append("    AND TSP.PAIS_OID_PAIS = ?   ");
        parametros.add(dtoE.getOidPais());
        sql.append("    ORDER BY descripcion   ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerTipoSolicitud : Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerTipoSolicitud (DTOBelcorp):Salida");
        return resultado;
    }
    
    public RecordSet obtenerTipoSolicitudGenera (DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerTipoSolicitudGenera (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        sql.append("    SELECT TSP.OID_TIPO_SOLI_PAIS,     ");
        sql.append("    (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  ");
        sql.append("    WHERE idio.ATTR_ENTI = 'PED_TIPO_SOLIC'    ");
        sql.append("    AND idio.IDIO_OID_IDIO = ?  ");
        parametros.add(dtoE.getOidIdioma());
        sql.append("    AND idio.VAL_OID = TS.OID_TIPO_SOLI) as descripcion ");
        sql.append("    FROM PED_TIPO_SOLIC ts, PED_TIPO_SOLIC_PAIS TSP ");
        sql.append("    WHERE TS.OID_TIPO_SOLI = TSP.TSOL_OID_TIPO_SOLI   ");
        sql.append("    AND TS.IND_SOLI_NEGA = 1   ");
        sql.append("    AND TSP.PAIS_OID_PAIS = ?   ");
        parametros.add(dtoE.getOidPais());
        sql.append("    ORDER BY descripcion   ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerTipoSolicitudGenera : Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerTipoSolicitudGenera (DTOBelcorp):Salida");
        return resultado;
    }
    
    public RecordSet obtenerAlmacen (DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerAlmacen (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        sql.append("    SELECT A.OID_ALMA,    ");
        sql.append("    (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        sql.append("    WHERE idio.ATTR_ENTI = 'BEL_ALMAC'   ");
        sql.append("    AND idio.IDIO_OID_IDIO = ?  ");
        parametros.add(dtoE.getOidIdioma());
        sql.append("    AND idio.VAL_OID = A.OID_ALMA  ) as descripcion ");
        sql.append("    FROM BEL_ALMAC A ");
        sql.append("    WHERE A.PAIS_OID_PAIS = ?   ");
        parametros.add(dtoE.getOidPais());
        sql.append("    ORDER BY descripcion   ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerAlmacen : Exception",e);                                                  
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerAlmacen (DTOBelcorp):Salida");
        return resultado;
    }
    
    public RecordSet obtenerMensajes (DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.obtenerMensajes (DTOBelcorp):Entrada");
                
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        sql.append("    SELECT M.OID_MENS,    ");
        //sql.append("    M.DES_MENS AS DESCRIPCION ");
        //modificado por incidencia 19567
        sql.append("    M.COD_MENS AS DESCRIPCION ");
        sql.append("    FROM  MSG_MENSA M   ");
        sql.append("    WHERE M.PAIS_OID_PAIS = ?  ");
        parametros.add(dtoE.getOidPais());
        sql.append("    ORDER BY DESCRIPCION ");
       
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerMensajes : Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }                                                                      
                                                                       
        UtilidadesLog.info("DAOOperacion.obtenerMensajes (DTOBelcorp):Salida");
        return resultado;
    }
    
    public  DTOOperacion detalleOperaciones (DTOOID dtoE) throws MareException {
        UtilidadesLog.info("DAOOperacion.detalleOperaciones (DTOOID):Entrada");
        
        DTOOperacion dtoOperacion = new DTOOperacion();
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
           
        sql.append("    SELECT O.OID_OPER, O.COD_OPER ,   ");
        sql.append("    (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  ");
        sql.append("    WHERE idio.ATTR_ENTI = 'REC_OPERA'    ");
        sql.append("    AND idio.IDIO_OID_IDIO = ?  ");
        parametros.add(dtoE.getOidIdioma());
        sql.append("    AND idio.VAL_OID = O.OID_OPER) AS DESC_CORT, ");
        sql.append("    O.VAL_DESC_LARG,");
        sql.append("    O.PECI_OID_PECI, O.IND_ANUL, O.VAL_PERD,    ");
        sql.append("    O.TSPA_OID_SOLI_PAIS_PERD, O.IND_ESPE_MERC_FISI,    ");
        //incidencia BELC300012909
        sql.append("    O.IND_DEVU_FISI_FACT,    ");
        sql.append("    O.NUM_CAMP_HIST, O.PENV_OID_PRECIO_ENVIA,   ");
        sql.append("    O.MOBL_OID_MOTI_BLOQ, O.IND_FALT_MERC, O.IND_INGR_ENVI, ");
        sql.append("    O.TSPA_OID_SOLI_CON_STOC, O.TSPA_OID_SOLI_SIN_STOC,   ");
        sql.append("    O.MENS_OID_MENS, O.IND_ENVI_GENE_DEVU,  ");
        sql.append("    O.VAL_INGR_DEVU, O.TSPA_OID_SOLI_PAIS_GENE, ");
        sql.append("    O.ALMC_OID_ALMA, O.TMAL_OID_TIPO_MOVI_ALMA, ");
        sql.append("    O.IND_DEVU_GENE_ENVI,    ");
        
        //vbongiov -- GCC-COL-REC-001-- 17/12/2007        
        sql.append("    O.IND_RECO,    ");
        sql.append("    O.TSPA_OID_TIPO_SOLI_REC_INIC, ");
        sql.append("    O.TSPA_OID_TIPO_SOLI_PRI_NO_EXIT, ");
        sql.append("    O.TSPA_OID_SOLI_PAIS_SEG_NO_EXIT, ");
        sql.append("    O.ALMC_OID_ALMA_POSV, ");
        sql.append("    O.TMAL_OID_TIPO_ALMA_REC_INIC, ");
        sql.append("    O.TMAL_OID_TIPO_ALMA_REC_EXIT, ");
        sql.append("    O.TMAL_OID_TIPO_ALMA_REC_NO_EXIT ");
                
        sql.append("    FROM REC_OPERA O    ");
        sql.append("    WHERE O.PAIS_OID_PAIS = ?   ");
        parametros.add(dtoE.getOidPais());
        sql.append("    AND O.OID_OPER = ?  ");
        parametros.add(dtoE.getOid());

        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" detalleOperaciones : Exception",e);                                                   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }  
        
        if (!resultado.esVacio()) {
            for (int i = 0; i < resultado.getRowCount(); i++) {
                 if (resultado.getValueAt(i, "OID_OPER") != null) {
                    Long oidOperacion = new Long(((BigDecimal) resultado.getValueAt(
                                i, "OID_OPER")).longValue());
                    dtoOperacion.setOidOperacion(oidOperacion);
                }
                if (resultado.getValueAt(i, "COD_OPER") != null) {
                    String codOperacion = resultado.getValueAt(i, "COD_OPER")
                                            .toString();
                    dtoOperacion.setCodOperacion(codOperacion);
                }
                if (resultado.getValueAt(i, "DESC_CORT") != null) {
                    String descripcionCorta = resultado.getValueAt(i, "DESC_CORT")
                                            .toString();
                    dtoOperacion.setDescripcionCorta(descripcionCorta);
                }
                if (resultado.getValueAt(i, "VAL_DESC_LARG") != null) {
                    String descripcionLarga = resultado.getValueAt(i, "VAL_DESC_LARG")
                                            .toString();
                    dtoOperacion.setDescripcionLarga(descripcionLarga);
                }
                if (resultado.getValueAt(i, "PECI_OID_PECI") != null) {
                    Long oidPrecios = new Long(((BigDecimal) resultado.getValueAt(
                                i, "PECI_OID_PECI")).longValue());
                    dtoOperacion.setOidPrecios(oidPrecios);
                }
                Boolean anulacion;
                if (resultado.getValueAt(i, "IND_ANUL") != null) {
                    anulacion = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "IND_ANUL")).intValue() == 1)
                            ? true : false);
                    dtoOperacion.setAnulacion(anulacion);
                }
                Boolean perdida;
                if (resultado.getValueAt(i, "VAL_PERD") != null) {
                    perdida = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "VAL_PERD")).intValue() == 1)
                            ? true : false);
                    dtoOperacion.setPerdida(perdida);
                }
                if (resultado.getValueAt(i, "TSPA_OID_SOLI_PAIS_PERD") != null) {
                    Long oidTIpoSolicitudPerdida = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TSPA_OID_SOLI_PAIS_PERD")).longValue());
                    dtoOperacion.setOidTIpoSolicitudPerdida(oidTIpoSolicitudPerdida);
                }
                Boolean esperarMercaderiaFisica;
                if (resultado.getValueAt(i, "IND_ESPE_MERC_FISI") != null) {
                    esperarMercaderiaFisica = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "IND_ESPE_MERC_FISI")).intValue() == 1)
                            ? true : false);
                    dtoOperacion.setEsperarMercaderiaFisica(esperarMercaderiaFisica);
                }
                //incidencia BELC300012909
                Boolean devueltoFisicoFactura;
                if (resultado.getValueAt(i, "IND_DEVU_FISI_FACT") != null) {
                    devueltoFisicoFactura = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "IND_DEVU_FISI_FACT")).intValue() == 1)
                            ? true : false);
                    dtoOperacion.setDevueltoFisicoFactura(devueltoFisicoFactura);
                }
                
                if (resultado.getValueAt(i, "NUM_CAMP_HIST") != null) {
                    Integer numeroCampaniasHistoria = new Integer(resultado.getValueAt(i,
                                "NUM_CAMP_HIST").toString());
                    dtoOperacion.setNumeroCampaniasHistoria(numeroCampaniasHistoria);    
                }
                if (resultado.getValueAt(i, "PENV_OID_PRECIO_ENVIA") != null) {
                    Long oidPrecioEnvia = new Long(((BigDecimal) resultado.getValueAt(
                                i, "PENV_OID_PRECIO_ENVIA")).longValue());
                    dtoOperacion.setOidPrecioEnvia(oidPrecioEnvia);
                }
                if (resultado.getValueAt(i, "MOBL_OID_MOTI_BLOQ") != null) {
                    Long oidBloqueoChequeo = new Long(((BigDecimal) resultado.getValueAt(
                                i, "MOBL_OID_MOTI_BLOQ")).longValue());
                    dtoOperacion.setOidBloqueoChequeo(oidBloqueoChequeo);
                }
                Boolean faltanteMercaderia;
                if (resultado.getValueAt(i, "IND_FALT_MERC") != null) {
                    faltanteMercaderia = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "IND_FALT_MERC")).intValue() == 1)
                            ? true : false);
                    dtoOperacion.setFaltanteMercaderia(faltanteMercaderia);
                }
                Boolean ingresaEnvia;
                if (resultado.getValueAt(i, "IND_INGR_ENVI") != null) {
                    ingresaEnvia = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "IND_INGR_ENVI")).intValue() == 1)
                            ? true : false);
                    dtoOperacion.setIngresaEnvia(ingresaEnvia);
                }
                if (resultado.getValueAt(i, "TSPA_OID_SOLI_CON_STOC") != null) {
                    Long oidTipoSolicitud1 = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TSPA_OID_SOLI_CON_STOC")).longValue());
                    dtoOperacion.setOidTipoSolicitud1(oidTipoSolicitud1);
                }
                if (resultado.getValueAt(i, "TSPA_OID_SOLI_SIN_STOC") != null) {
                    Long oidTipoSolicitud2 = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TSPA_OID_SOLI_SIN_STOC")).longValue());
                    dtoOperacion.setOidTipoSolicitud2(oidTipoSolicitud2);
                }
                if (resultado.getValueAt(i, "MENS_OID_MENS") != null) {
                    Long oidMensajeGenerar = new Long(((BigDecimal) resultado.getValueAt(
                                i, "MENS_OID_MENS")).longValue());
                    dtoOperacion.setOidMensajeGenerar(oidMensajeGenerar);
                }
                Boolean enviaGeneraDevuelve;
                if (resultado.getValueAt(i, "IND_ENVI_GENE_DEVU") != null) {
                    enviaGeneraDevuelve = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "IND_ENVI_GENE_DEVU")).intValue() == 1)
                            ? true : false);
                    dtoOperacion.setEnviaGeneraDevuelve(enviaGeneraDevuelve);
                }
                Boolean ingresaDevuelve;
                if (resultado.getValueAt(i, "VAL_INGR_DEVU") != null) {
                    ingresaDevuelve = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "VAL_INGR_DEVU")).intValue() == 1)
                            ? true : false);
                    dtoOperacion.setIngresaDevuelve(ingresaDevuelve);
                }
                if (resultado.getValueAt(i, "TSPA_OID_SOLI_PAIS_GENE") != null) {
                    Long oidTipoSolicitudGenera = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TSPA_OID_SOLI_PAIS_GENE")).longValue());
                    dtoOperacion.setOidTipoSolicitudGenera(oidTipoSolicitudGenera);
                }
                if (resultado.getValueAt(i, "ALMC_OID_ALMA") != null) {
                    Long oidAlmacen = new Long(((BigDecimal) resultado.getValueAt(
                                i, "ALMC_OID_ALMA")).longValue());
                    dtoOperacion.setOidAlmacen(oidAlmacen);
                }
                if (resultado.getValueAt(i, "TMAL_OID_TIPO_MOVI_ALMA") != null) {
                    Long oidMovimientoAlmacen = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TMAL_OID_TIPO_MOVI_ALMA")).longValue());
                    dtoOperacion.setOidMovimientoAlmacen(oidMovimientoAlmacen);
                }
                Boolean devuelveGeneraEnvia;
                if (resultado.getValueAt(i, "IND_DEVU_GENE_ENVI") != null) {
                    devuelveGeneraEnvia = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "IND_DEVU_GENE_ENVI")).intValue() == 1)
                            ? true : false);
                    dtoOperacion.setDevuelveGeneraEnvia(devuelveGeneraEnvia);
                }   
                
                //vbongiov -- GCC-COL-REC-001-- 17/12/2007   
                Boolean recojo = new Boolean((((BigDecimal) resultado.getValueAt(
                                i, "IND_RECO")).intValue() == 1)
                            ? true : false);
                dtoOperacion.setRecojo(recojo);                
                
                if (resultado.getValueAt(i, "TSPA_OID_TIPO_SOLI_REC_INIC") != null) {
                    Long oidTipoSolicitudRecojoInicial = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TSPA_OID_TIPO_SOLI_REC_INIC")).longValue());
                    dtoOperacion.setOidTipoSolicitudRecojoInicial(oidTipoSolicitudRecojoInicial);
                }
                
                if (resultado.getValueAt(i, "TSPA_OID_TIPO_SOLI_PRI_NO_EXIT") != null) {
                    Long oidTipoSolicitudPrimerRecojoNoExitoso = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TSPA_OID_TIPO_SOLI_PRI_NO_EXIT")).longValue());
                    dtoOperacion.setOidTipoSolicitudPrimerRecojoNoExitoso(oidTipoSolicitudPrimerRecojoNoExitoso);
                }
                
                if (resultado.getValueAt(i, "TSPA_OID_SOLI_PAIS_SEG_NO_EXIT") != null) {
                    Long oidTipoSolicitudSegundoRecojoNoExitoso = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TSPA_OID_SOLI_PAIS_SEG_NO_EXIT")).longValue());
                    dtoOperacion.setOidTipoSolicitudSegundoRecojoNoExitoso(oidTipoSolicitudSegundoRecojoNoExitoso);
                }
                
                if (resultado.getValueAt(i, "ALMC_OID_ALMA_POSV") != null) {
                    Long oidAlmacenPostVenta = new Long(((BigDecimal) resultado.getValueAt(
                                i, "ALMC_OID_ALMA_POSV")).longValue());
                    dtoOperacion.setOidAlmacenPostVenta(oidAlmacenPostVenta);
                }
                
                if (resultado.getValueAt(i, "TMAL_OID_TIPO_ALMA_REC_INIC") != null) {
                    Long oidMovimientoAlmacenRecojoInicial = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TMAL_OID_TIPO_ALMA_REC_INIC")).longValue());
                    dtoOperacion.setOidMovimientoAlmacenRecojoInicial(oidMovimientoAlmacenRecojoInicial);
                }
                
                if (resultado.getValueAt(i, "TMAL_OID_TIPO_ALMA_REC_EXIT") != null) {
                    Long oidMovimientoAlmacenRecojoExitoso = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TMAL_OID_TIPO_ALMA_REC_EXIT")).longValue());
                    dtoOperacion.setOidMovimientoAlmacenRecojoExitoso(oidMovimientoAlmacenRecojoExitoso);
                }
                
                if (resultado.getValueAt(i, "TMAL_OID_TIPO_ALMA_REC_NO_EXIT") != null) {
                    Long oidMovimientoAlmacenRecojoNoExitoso = new Long(((BigDecimal) resultado.getValueAt(
                                i, "TMAL_OID_TIPO_ALMA_REC_NO_EXIT")).longValue());
                    dtoOperacion.setOidMovimientoAlmacenRecojoNoExitoso(oidMovimientoAlmacenRecojoNoExitoso);
                }
            }   
        }
        UtilidadesLog.info("DAOOperacion.detalleOperaciones (DTOOID):Salida");
        return dtoOperacion;
   
    }
    
     private void logSql(String metodo, String sql, Vector params) {            
     UtilidadesLog.info(metodo + sql);                                      
                                                                            
     if ((params != null) && (params.size() > 0)) {                         
         String sParams = "";                                               
                                                                            
         for (int i = 0; i < params.size(); i++) {                          
             sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +  
             ", ");                                                         
         }                                                                  
                                                                            
         UtilidadesLog.info(metodo + sParams);                              
     }                                                                      
 }                                                                          
 
    public RecordSet obtenerTipoSolicitudNoNegativa(DTOBelcorp dtoE) throws MareException {
        
        UtilidadesLog.info("DAOOperacion.obtenerTipoSolicitudNoNegativa(DTOBelcorp):Entrada");
        
		// Acceder a la entidad PED:TipoSolicitud y entidad PED:TipoSolicitudPais haciendo join entre ellas, filtrando por: 
		// - IND_SOLI_NEGA = 0 (pertenece a la entidad PED:TipoSolicitud) 
		// - pais = DTOE.pais 
		// 
		// Obtener: 
		// - oid (de la entidad PED:TipoSolicitudPais) 
		// - descripcion (entidad PED:TipoSolicitud) 
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
		consulta.append("SELECT tsp.OID_TIPO_SOLI_PAIS, (SELECT t.VAL_I18N ");
		consulta.append("FROM GEN_I18N_SICC_COMUN t ");
		consulta.append("WHERE t.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
		consulta.append("AND t.ATTR_NUM_ATRI = 1 ");
		consulta.append("AND t.IDIO_OID_IDIO = ? ");
        parametros.add(dtoE.getOidIdioma());
		consulta.append("AND t.VAL_OID = ts.OID_TIPO_SOLI) AS DESCRIPCION ");
        consulta.append("FROM PED_TIPO_SOLIC ts, PED_TIPO_SOLIC_PAIS tsp ");
        consulta.append("WHERE tsp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");
		consulta.append("AND ts.IND_SOLI_NEGA = 0 ");
		consulta.append("AND tsp.PAIS_OID_PAIS = ?");
        parametros.add(dtoE.getOidPais());
        
        RecordSet resultado = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);                                                       
            UtilidadesLog.debug("******* RecordSet obtenido: " + resultado);
        } catch (Exception e) {
			UtilidadesLog.error("DAOOperacion.obtenerTipoSolicitudNoNegativa: ", e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOOperacion.obtenerTipoSolicitudNoNegativa(DTOBelcorp):Salida");
        
        return resultado;
    }
     public DTOSalida obtenerOperacionesPremio(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("DAORec.obtenerOperacionesPremio(DTOBelcorp):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        DTOSalida dtos = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        query.append(" select opera.OID_OPER, opera.VAL_DESC_LARG ");
        query.append(" from rec_opera opera, rec_preci precio ");
        query.append(" where opera.PECI_OID_PECI = precio.OID_PREC ");
        query.append(" and   precio.COD_PREC = 'I' ");
        query.append(" and opera.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" order by 2 ");

            
         try {
             rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
             if(!rs.esVacio()){
                dtos.setResultado(rs);
             }
         }catch (Exception e) {
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }           
         UtilidadesLog.info("DAORec.obtenerOperacionesPremio(DTOBelcorp):Salida");
         return dtos;   

        
    }

    public RecordSet obtenerTipoSolicitudNegativa(DTOBelcorp dtoE) throws MareException {
        
        UtilidadesLog.info("DAOOperacion.obtenerTipoSolicitudNegativa(DTOBelcorp):Entrada");
        
		// Acceder a la entidad PED:TipoSolicitud y entidad PED:TipoSolicitudPais haciendo join entre ellas, filtrando por: 
		// - IND_SOLI_NEGA = 0 (pertenece a la entidad PED:TipoSolicitud) 
		// - pais = DTOE.pais 
		// 
		// Obtener: 
		// - oid (de la entidad PED:TipoSolicitudPais) 
		// - descripcion (entidad PED:TipoSolicitud) 
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
		consulta.append("SELECT tsp.OID_TIPO_SOLI_PAIS, (SELECT t.VAL_I18N ");
		consulta.append("FROM GEN_I18N_SICC_COMUN t ");
		consulta.append("WHERE t.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
		consulta.append("AND t.ATTR_NUM_ATRI = 1 ");
		consulta.append("AND t.IDIO_OID_IDIO = ? ");
        parametros.add(dtoE.getOidIdioma());
		consulta.append("AND t.VAL_OID = ts.OID_TIPO_SOLI) AS DESCRIPCION ");
        consulta.append("FROM PED_TIPO_SOLIC ts, PED_TIPO_SOLIC_PAIS tsp ");
        consulta.append("WHERE tsp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");
		consulta.append("AND ts.IND_SOLI_NEGA = 1 ");
		consulta.append("AND tsp.PAIS_OID_PAIS = ?");
        parametros.add(dtoE.getOidPais());
        
        RecordSet resultado = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                            
                                                                       
        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);                                                       
            UtilidadesLog.debug("******* RecordSet obtenido: " + resultado);
        } catch (Exception e) {
			UtilidadesLog.error("DAOOperacion.obtenerTipoSolicitudNegativa: ", e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOOperacion.obtenerTipoSolicitudNegativa(DTOBelcorp):Salida");
        
        return resultado;
    }

}
