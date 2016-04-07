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
 
package es.indra.sicc.logicanegocio.car;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

public class ExtensionCARBean implements SessionBean {
  public void ejbCreate() {
  }
  
  public void ejbActivate() {
  }
  
  public void ejbPassivate() {
  }
  
  public void ejbRemove() {
  }
  
  public void setSessionContext(SessionContext ctx) {
  }
  /**
     * @author pperanzola
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     * 
     * @author splatas
     *         17/10/2005 - se modifica segun incidencia BELC300020800
     */
  public void validarInsertarSolapamientoCodEvaluacion(MareDTO datos) throws MareException {
    UtilidadesLog.info("ExtensionCARBean.validarInsertarSolapamientoCodEvaluacion(MareDTO):Entrada");
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    Vector params = new Vector();
    BelcorpService bs;
    //    Obtenemos la propiedad "penrOidParaEvalNr" de datos. -> paramEvalNR
    Long paramEvalNR = (Long) datos.getProperty("penrOidParaEvalNr");
    //    Obtenemos la propiedad "valMini" de datos. -> valMini
    Double valMini = (Double) datos.getProperty("valMini");
    //    Obtenemos la propiedad "valMaxi" de datos. -> valMaxi
    Double valMaxi = (Double) datos.getProperty("valMaxi");
  
  /*    VERSIÓN ANTERIOR:
  //        SELECT * FROM CAR_CONDI_EVALU_NR EV
  //        WHERE ((VAL_MINI<? [valMini] AND VAL_MAXI>? [valMini])
  //        OR (VAL_MINI<? [valMaxi] AND VAL_MAXI>? [valMaxi])) 
  //        AND PENR_OID_PARA_EVAL_NR=? (paramEvalNR)
    query.append(" SELECT * FROM CAR_CONDI_EVALU_NR EV \n");
    query.append(" WHERE ((VAL_MINI<?  AND VAL_MAXI>? ) \n");
    params.add(valMini);
    params.add(valMini);
    if (valMaxi!= null){
        query.append(" OR (VAL_MINI<? AND VAL_MAXI>? )) \n");
        params.add(valMaxi);
        params.add(valMaxi);
    }
    query.append(" AND PENR_OID_PARA_EVAL_NR=? \n");
    params.add(paramEvalNR);
    */
    
    /*  MODIFICADO - splatas - 17/10/2005:
        SELECT oid_cond_eval_nr FROM car_condi_evalu_nr ev
        if (valMaxi!= null){
            WHERE (   (val_mini < MINIMO AND val_maxi >= MINIMO)       
                   OR (val_mini <= MAXIMO AND (val_maxi > MAXIMO or val_maxi is null))
                   OR (val_mini >= MINIMO AND val_maxi <= MAXIMO))       
                   
        }else{
            WHERE ((val_mini <= MINIMO AND (val_maxi >= MINIMO or val_maxi is null))
                   or (val_mini >= MINIMO AND (val_maxi >= MINIMO or val_maxi is null)))                   
        }
          AND penr_oid_para_eval_nr = ?
                 
    */
    query.append(" SELECT OID_COND_EVAL_NR FROM CAR_CONDI_EVALU_NR EV \n");
    if (valMaxi!= null){
        query.append("WHERE ( (val_mini < ? AND val_maxi >= ?) \n");
        params.add(valMini);
        params.add(valMini);
        query.append(" OR (val_mini <= ? AND (val_maxi > ? or val_maxi is null)) \n");
        params.add(valMaxi);
        params.add(valMaxi);
        query.append(" OR (val_mini >= ? AND val_maxi <= ?)) \n");
        params.add(valMini);
        params.add(valMaxi);
        
    }else{
        query.append("WHERE ((val_mini <= ? AND (val_maxi >= ? or val_maxi is null)) \n");
        params.add(valMini);
        params.add(valMini);
        query.append(" or (val_mini >= ? AND (val_maxi >= ? or val_maxi is null))) \n");
        params.add(valMini);
        params.add(valMini);
    }    
    query.append(" AND PENR_OID_PARA_EVAL_NR = ? \n");
    params.add(paramEvalNR);

    try {  
      bs = BelcorpService.getInstance();
    }
    catch (MareMiiServiceNotFoundException ex) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
      
    try {
      rs = bs.dbService.executePreparedQuery(query.toString(), params);
    }
    catch (Exception ex) {
      throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    if ( rs.getRowCount() > 0 ) {
      //    Si obtenemos algún registro {
      //     Lanzamos una MareException con el mensaje  CAR-0004 
      //    }
      throw new MareException
                ( null
                , null
                , UtilidadesError.armarCodigoError
                    ( ConstantesSEG.MODULO_CAR
                    , ""
                    , ErroresDeNegocio.CAR_0004));
    }
    UtilidadesLog.info("ExtensionCARBean.validarInsertarSolapamientoCodEvaluacion(MareDTO):Salida");
  }
  /**
     * @author pperanzola
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     * @author pperanzola
     *         01/09/2005 - se modifica segun incidencia BELC300020800

     */
  public void validarInsertarSolapamientoParamNR(MareDTO datos) throws MareException {
    UtilidadesLog.info("ExtensionCARBean.validarInsertarSolapamientoParamNR(MareDTO):Entrada");
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    Vector params = new Vector();
    BelcorpService bs;
    //    Obtenemos la propiedad "valMini" de datos. -> valMini
    Double valMini = (Double) datos.getProperty("valMini");
    //    Obtenemos la propiedad "valMaxi" de datos. -> valMaxi
    Double valMaxi = (Double) datos.getProperty("valMaxi");
  
    //  SELECT * FROM CAR_PARAM_NR EV 
    //  WHERE ((VAL_MINI<? [valMini] AND VAL_MAXI>? [valMini]) 
    //  OR (VAL_MINI<? [valMaxi] AND VAL_MAXI>? [valMaxi])) 

    query.append(" SELECT * FROM CAR_PARAM_NR EV \n");
    query.append(" WHERE ((VAL_MINI<?  AND VAL_MAXI>? ) \n");
    params.add(valMini);
    params.add(valMini);
    if (valMaxi != null) {
        query.append(" OR (VAL_MINI<? AND VAL_MAXI>? )) \n");
        params.add(valMaxi);
        params.add(valMaxi);
        
    } else {
        query.append(" ) ");
    }

    try {  
      bs = BelcorpService.getInstance();
    }
    catch (MareMiiServiceNotFoundException ex) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
      
    try {
      rs = bs.dbService.executePreparedQuery(query.toString(), params);
    }
    catch (Exception ex) {
      throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    if ( rs.getRowCount() > 0 ) {
      //    Si obtenemos algún registro {
      //     Lanzamos una MareException con el mensaje  CAR-0005  
      //    }
      throw new MareException
                ( null
                , null
                , UtilidadesError.armarCodigoError
                    ( ConstantesSEG.MODULO_CAR
                    , ""
                    , ErroresDeNegocio.CAR_0005));
    }
    UtilidadesLog.info("ExtensionCARBean.validarInsertarSolapamientoParamNR(MareDTO):Salida");
  }
  
  /**
     * @author pperanzola
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     */
  public void  validarInsertarParamCalculoLC(MareDTO datos) throws MareException {
    UtilidadesLog.info("ExtensionCARBean.validarInsertarParamCalculoLC(MareDTO):Entrada");
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    Vector params = new Vector();
    BelcorpService bs;
    //    Obtenemos la propiedad "niriOidNiveRies" de datos. -> nivelRiesgo 
    Long nivelRiesgo = (Long) datos.getProperty("niriOidNiveRies");
    //    Obtenemos la propiedad "valTope" de datos. -> valTope 
    Double valTope = (Double) datos.getProperty("valTope");
  
    //  SELECT * FROM CAR_PARAM_CALCU_LC EV 
    //  WHERE 
    //  NIRI_OID_NIVE_RIES = ? [nivelRiesgo] 
    //  AND VAL_TOPE= ? [valTope] 

    query.append(" SELECT * FROM CAR_PARAM_CALCU_LC EV  \n");
    query.append(" WHERE \n");
    query.append(" NIRI_OID_NIVE_RIES = ? \n");
    params.add(nivelRiesgo);
    query.append(" AND VAL_TOPE= ? \n");
    params.add(valTope);

    try {  
      bs = BelcorpService.getInstance();
    }
    catch (MareMiiServiceNotFoundException ex) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
      
    try {
      rs = bs.dbService.executePreparedQuery(query.toString(), params);
    }
    catch (Exception ex) {
      throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    if ( rs.getRowCount() > 0 ) {
      //    Si obtenemos algún registro { 
      //    Lanzamos una MareException con el mensaje CAR-0006 
      //    } 

      throw new MareException
                ( null
                , null
                , UtilidadesError.armarCodigoError
                    ( ConstantesSEG.MODULO_CAR
                    , ""
                    , ErroresDeNegocio.CAR_0006));
    }
    UtilidadesLog.info("ExtensionCARBean.validarInsertarParamCalculoLC(MareDTO):Salida");
  }
  /**
     * @author pperanzola
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     * 
     * @author splatas
     *         17/10/2005 - se modifica segun incidencia BELC300020800
     */
  public void  validarModSolapamientoCodEvaluacion(MareDTO datos) throws MareException {
    UtilidadesLog.info("ExtensionCARBean.validarModSolapamientoCodEvaluacion(MareDTO):Entrada");
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    Vector params = new Vector();
    BelcorpService bs;
    //    Obtenemos la propiedad "penrOidParaEvalNr" de datos. -> paramEvalNR
    Long paramEvalNR = (Long) datos.getProperty("penrOidParaEvalNr");
    //    Obtenemos la propiedad "valMini" de datos. -> valMini
    Double valMini = (Double) datos.getProperty("valMini");
    //    Obtenemos la propiedad "valMaxi" de datos. -> valMaxi
    Double valMaxi = (Double) datos.getProperty("valMaxi");
    //    Obtenemos la propiedad "id" de datos. -> oid 
    Long oid = (Long) datos.getProperty("id");

    /*  VERSION ANTERIOR:
    //    SELECT * FROM CAR_CONDI_EVALU_NR EV 
    //    WHERE ((VAL_MINI<? [valMini] AND VAL_MAXI>? [valMini]) 
    //    OR (VAL_MINI<? [valMaxi] AND VAL_MAXI>? [valMaxi]))
    //    AND PENR_OID_PARA_EVAL_NR=? (paramEvalNR) 
    //    AND OID_COND_EVAL_NR<> ? [oid] 
    
    query.append(" SELECT * FROM CAR_CONDI_EVALU_NR EV  \n");
    query.append("  WHERE ((VAL_MINI<? AND VAL_MAXI>? \n");
    params.add(valMini);
    params.add(valMini);
    if (valMaxi!= null){
        query.append(" OR (VAL_MINI<? AND VAL_MAXI>? ))  \n");
        params.add(valMaxi);
        params.add(valMaxi);
    }
    query.append(" AND PENR_OID_PARA_EVAL_NR=? \n");
    params.add(paramEvalNR);
    query.append(" AND OID_COND_EVAL_NR<> ? \n");
    params.add(oid);
    */
    
    /*  MODIFICADO - SPLATAS - 07/10/2005:
            SELECT oid_cond_eval_nr FROM car_condi_evalu_nr ev
            if (valMaxi!= null){
                WHERE (  (val_mini < MINIMO AND val_maxi >= MINIMO)       
                       OR (val_mini <= MAXIMO AND (val_maxi > MAXIMO or val_maxi is null))       
                       OR (val_mini >= MINIMO AND val_maxi <= MAXIMO)	   	   
                      )
            }else{
                WHERE ((val_mini <= MINIMO AND (val_maxi >= MINIMO or val_maxi is null))
                        or (val_mini >= MINIMO AND (val_maxi >= MINIMO or val_maxi is null)))
            }
                  AND penr_oid_para_eval_nr = ? (paramEvalNR)
                  and oid_cond_eval_nr <> ? [oid]
    */
    query.append(" SELECT OID_COND_EVAL_NR FROM CAR_CONDI_EVALU_NR EV \n");
    if (valMaxi!= null){
        query.append("WHERE ( (val_mini < ? AND val_maxi >= ?) \n");
        params.add(valMini);
        params.add(valMini);
        query.append(" OR (val_mini <= ? AND (val_maxi > ? or val_maxi is null)) \n");
        params.add(valMaxi);
        params.add(valMaxi);
        query.append(" OR (val_mini >= ? AND val_maxi <= ?)) \n");
        params.add(valMini);
        params.add(valMaxi);
        
    }else{
        query.append("WHERE ((val_mini <= ? AND (val_maxi >= ? or val_maxi is null)) \n");
        params.add(valMini);
        params.add(valMini);
        query.append(" or (val_mini >= ? AND (val_maxi >= ? or val_maxi is null))) \n");
        params.add(valMini);
        params.add(valMini);
    }  
    query.append(" AND PENR_OID_PARA_EVAL_NR = ? \n");
    params.add(paramEvalNR);
    query.append(" AND OID_COND_EVAL_NR <> ? \n");
    params.add(oid);

    try {  
      bs = BelcorpService.getInstance();
    }
    catch (MareMiiServiceNotFoundException ex) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
      
    try {
      rs = bs.dbService.executePreparedQuery(query.toString(), params);
    }
    catch (Exception ex) {
      throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    if ( rs.getRowCount() > 0 ) {
      //    Si obtenemos algún registro { 
      //      Lanzamos una MareException con el mensaje CAR-0004 
      //    } 

      throw new MareException
                ( null
                , null
                , UtilidadesError.armarCodigoError
                    ( ConstantesSEG.MODULO_CAR
                    , ""
                    , ErroresDeNegocio.CAR_0004));
    }
   UtilidadesLog.info("ExtensionCARBean.validarModSolapamientoCodEvaluacion(MareDTO):Salida");
  }
  /**
     * @author pperanzola
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     * @author pperanzola
     *         01/09/2005 - se modifica segun incidencia BELC300020800

     */
  public void  validarModSolapamientoParamNR(MareDTO datos) throws MareException {
    UtilidadesLog.info("ExtensionCARBean.validarModSolapamientoParamNR(MareDTO):Entrada");
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    Vector params = new Vector();
    BelcorpService bs;
    //    Obtenemos la propiedad "valMini" de datos. -> valMini
    Double valMini = (Double) datos.getProperty("valMini");
    //    Obtenemos la propiedad "valMaxi" de datos. -> valMaxi
    Double valMaxi = (Double) datos.getProperty("valMaxi");
    //    Obtenemos la propiedad "id" de datos. -> oid 
    Long oid = (Long) datos.getProperty("id");

    //  SELECT * FROM CAR_PARAM_NR EV 
    //  WHERE ((VAL_MINI<? [valMini] AND VAL_MAXI>? [valMini]) 
    //  OR (VAL_MINI<? [valMaxi] AND VAL_MAXI>? [valMaxi])) 
    //  AND OID_PARA_NR<>oid 

    query.append(" SELECT * FROM CAR_PARAM_NR EV  \n");
    query.append(" WHERE ((VAL_MINI<?  AND VAL_MAXI>? ) \n");
    params.add(valMini);
    params.add(valMini);
    if (valMaxi!=null){
        query.append(" OR (VAL_MINI<? AND VAL_MAXI>? )) \n");
        params.add(valMaxi);
        params.add(valMaxi);
    }
    query.append(" AND OID_PARA_NR<> ? \n");
    params.add(oid);

    try {  
      bs = BelcorpService.getInstance();
    }
    catch (MareMiiServiceNotFoundException ex) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
      
    try {
      rs = bs.dbService.executePreparedQuery(query.toString(), params);
    }
    catch (Exception ex) {
      throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    if ( rs.getRowCount() > 0 ) {
      //    Si obtenemos algún registro { 
      //      Lanzamos una MareException con el mensaje CAR-0005  
      //    } 

      throw new MareException
                ( null
                , null
                , UtilidadesError.armarCodigoError
                    ( ConstantesSEG.MODULO_CAR
                    , ""
                    , ErroresDeNegocio.CAR_0005));
    }
    UtilidadesLog.info("ExtensionCARBean.validarModSolapamientoParamNR(MareDTO):Salida");
  }
  /**
     * @author pperanzola
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param datos
     */
  public void  validarModParamCalculoLC(MareDTO datos) throws MareException {
  UtilidadesLog.info("ExtensionCARBean.validarModParamCalculoLC(MareDTO):Entrada");
    RecordSet rs = new RecordSet();
    StringBuffer query = new StringBuffer();
    Vector params = new Vector();
    BelcorpService bs;
    //    Obtenemos la propiedad "niriOidNiveRies" de datos. -> nivelRiesgo 
    Long nivelRiesgo = (Long) datos.getProperty("niriOidNiveRies");
    //    Obtenemos la propiedad "valTope" de datos. -> valTope 
    Double valTope = (Double) datos.getProperty("valTope");
    //    Obtenemos la propiedad "id" de datos. -> oid
    Long oid = (Long) datos.getProperty("id");
  
    //  SELECT * FROM CAR_PARAM_CALCU_LC EV 
    //  WHERE 
    //  NIRI_OID_NIVE_RIES = ? [nivelRiesgo] 
    //  AND VAL_TOPE= ? [valTope] 
    //  AND OID_PARA_CALC_LC<>oid 

    query.append(" SELECT * FROM CAR_PARAM_CALCU_LC EV  \n");
    query.append(" WHERE \n");
    query.append(" NIRI_OID_NIVE_RIES = ? \n");
    params.add(nivelRiesgo);
    query.append(" AND VAL_TOPE= ? \n");
    params.add(valTope);
    query.append(" AND OID_PARA_CALC_LC<> ? \n");
    params.add(oid);

    try {  
      bs = BelcorpService.getInstance();
    }
    catch (MareMiiServiceNotFoundException ex) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
      
    try {
      rs = bs.dbService.executePreparedQuery(query.toString(), params);
    }
    catch (Exception ex) {
      throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    if ( rs.getRowCount() > 0 ) {
      //    Si obtenemos algún registro { 
      //    Lanzamos una MareException con el mensaje CAR-0006 
      //    } 

      throw new MareException
                ( null
                , null
                , UtilidadesError.armarCodigoError
                    ( ConstantesSEG.MODULO_CAR
                    , ""
                    , ErroresDeNegocio.CAR_0006));
    }
    UtilidadesLog.info("ExtensionCARBean.validarModParamCalculoLC(MareDTO):Salida");
  }
}