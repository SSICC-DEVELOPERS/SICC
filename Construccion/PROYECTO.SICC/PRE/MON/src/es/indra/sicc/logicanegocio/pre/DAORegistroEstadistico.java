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

package es.indra.sicc.logicanegocio.pre;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Vector;

/**
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */ 
public class DAORegistroEstadistico  {

    public DAORegistroEstadistico() {
    }
    
  /**
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param oidPeriodo
   */
    public Long obtenerNumeroRealPedidos(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealPedidos(Long oidPeriodo): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT COUNT(*) NUMERO_REAL_PEDIDOS ");

        consulta.append(" FROM "); 
        consulta.append(" PED_SOLIC_CABEC SC "); 
        
        consulta.append(" WHERE "); 

        if (oidPeriodo != null){
            consulta.append(" SC.PERD_OID_PERI = ? AND ");
            parametros.add(oidPeriodo);                           
        }
        consulta.append(" SC.FEC_FACT IS NOT NULL AND "); 
        consulta.append(" SC.IND_TS_NO_CONSO = 1 AND "); 
        consulta.append(" SC.IND_OC = 1 AND "); 
        consulta.append(" (SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) "); 

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerNumeroRealPedidos: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch

        Long resultado = null;
        if (rs != null){
            if (rs.getValueAt(0,"NUMERO_REAL_PEDIDOS") != null)
                resultado = new Long(((BigDecimal)rs.getValueAt(0,"NUMERO_REAL_PEDIDOS")).longValue());                                                        
        }        
        
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealPedidos(Long oidPeriodo): Salida");
        return resultado;
    }
    
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPeriodo
     */
    public Long obtenerNumeroRealClientes(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealClientes(Long oidPeriodo): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT COUNT(DISTINCT SC.CLIE_OID_CLIE) NUMERO_REAL_CLIENTES ");
         
        consulta.append(" FROM ");
        consulta.append(" PED_SOLIC_CABEC SC "); 
         
        consulta.append(" WHERE "); 
    
        if (oidPeriodo != null){
            consulta.append(" SC.PERD_OID_PERI = ? AND "); 
            parametros.add(oidPeriodo);                           
        }	
         
        consulta.append(" SC.FEC_FACT IS NOT NULL AND "); 
        consulta.append(" SC.IND_TS_NO_CONSO = 1 AND "); 
        consulta.append(" SC.IND_OC = 1 AND "); 
        consulta.append(" (SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) "); 
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerNumeroRealClientes: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        Long resultado = null;

        if (rs != null){
            if (rs.getValueAt(0,"NUMERO_REAL_CLIENTES") != null)
                resultado = new Long(((BigDecimal)rs.getValueAt(0,"NUMERO_REAL_CLIENTES")).longValue());                                                        
        }
                
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealClientes(Long oidPeriodo): Salida");
        return resultado;
    }
    
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPeriodo
     */
    public Long obtenerNumeroRealUnidades(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealUnidades(Long oidPeriodo): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT SUM(SP.NUM_UNID_ATEN) UNIDADES_ATENDIDAS ");
        
        consulta.append(" FROM "); 
        consulta.append(" PED_SOLIC_CABEC SC, "); 
        consulta.append(" PED_SOLIC_POSIC SP "); 
        
        consulta.append(" WHERE "); 

        if (oidPeriodo != null){
            consulta.append(" SC.PERD_OID_PERI = ? AND "); 
            parametros.add(oidPeriodo);                           
        }	        
        consulta.append(" SC.FEC_FACT IS NOT NULL AND "); 
        consulta.append(" SC.IND_TS_NO_CONSO = 1 AND "); 
        consulta.append(" SC.IND_OC = 1 AND "); 
        consulta.append(" (SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) AND "); 
        consulta.append(" SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE AND "); 
        consulta.append(" SP.ESPO_OID_ESTA_POSI <> ?"); 
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);                                   
            
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerNumeroRealUnidades : Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        Long resultado = null;

        if (rs != null){
            if (rs.getValueAt(0,"UNIDADES_ATENDIDAS") != null)
                resultado = new Long(((BigDecimal)rs.getValueAt(0,"UNIDADES_ATENDIDAS")).longValue());                                                        
        }
                
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealUnidades(Long oidPeriodo): Salida");
        return resultado;
    }
    
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPeriodo
     */
    public BigDecimal obtenerMontoFacturadoRealLocal(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerMontoFacturadoRealLocal(Long oidPeriodo): Entrada");
        
        //INCIDENCIA BELC300016582
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT SUM(SP.VAL_PREC_CATA_TOTA_LOCA) MONTO_FACTURADO_REAL_LOCAL "); 
        
        consulta.append(" FROM "); 
        consulta.append(" PED_SOLIC_CABEC SC, "); 
        consulta.append(" PED_SOLIC_POSIC SP "); 
        
        consulta.append(" WHERE "); 
        if (oidPeriodo != null){
            consulta.append(" SC.PERD_OID_PERI = ? AND "); 
            parametros.add(oidPeriodo);                           
        }	                
        
        consulta.append(" SC.FEC_FACT IS NOT NULL AND "); 
        consulta.append(" SC.IND_TS_NO_CONSO = 1 AND "); 
        consulta.append(" SC.IND_OC = 1 AND "); 
        consulta.append(" (SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) AND "); 
        consulta.append(" SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE AND "); 
        consulta.append(" SP.ESPO_OID_ESTA_POSI <> ? ");   
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);                                   
            
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerMontoFacturadoRealLocal : Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }
        
        BigDecimal resultado = null;

        if (rs != null){
            if (rs.getValueAt(0,"MONTO_FACTURADO_REAL_LOCALS") != null)
                resultado = ((BigDecimal)rs.getValueAt(0,"MONTO_FACTURADO_REAL_LOCAL"));                                                        
        }
                
        UtilidadesLog.info("DAORegistroEstadistico.obtenerMontoFacturadoRealLocal(Long oidPeriodo): Salida");
        return resultado;
    }
    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPeriodo
     */
    public Long obtenerNumeroRealPedidosAnulados(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealPedidosAnulados(Long oidPeriodo): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT COUNT(*) NUMERO_REAL_PEDIDOS_ANULADOS ");
        
        consulta.append(" FROM "); 
        consulta.append(" PED_SOLIC_CABEC SC, "); 
        consulta.append(" PED_TIPO_SOLIC TS, "); 
        consulta.append(" PED_TIPO_SOLIC_PAIS TSP "); 
         
        consulta.append(" WHERE "); 
        if (oidPeriodo != null){
            consulta.append(" SC.PERD_OID_PERI = ? AND "); 
            parametros.add(oidPeriodo);                           
        }	                        
        
        consulta.append(" SC.FEC_FACT IS NOT NULL AND "); 
        consulta.append(" SC.IND_TS_NO_CONSO = 1 AND "); 
        consulta.append(" SC.IND_OC = 1 AND "); 
        consulta.append(" (SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) AND "); 
        consulta.append(" SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS AND "); 
        consulta.append(" TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI AND "); 
        consulta.append(" TS.IND_ANUL = 1 "); 

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerNumeroRealPedidosAnulados : Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        Long resultado = null;

        if (rs != null){
            if (rs.getValueAt(0,"NUMERO_REAL_PEDIDOS_ANULADOS") != null)
                resultado = new Long(((BigDecimal)rs.getValueAt(0,"NUMERO_REAL_PEDIDOS_ANULADOS")).longValue());                                                                        
        }
                
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealPedidosAnulados(Long oidPeriodo): Salida");
        return resultado;
    }
    
    public BigDecimal obtenerMontoLocalAnulaciones(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerMontoLocalAnulaciones(Long oidPeriodo): Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT NVL(SUM(SP.VAL_PREC_CATA_TOTA_LOCA),0) MONTO_LOCAL_ANULACIONES ");
        sql.append(" FROM PED_SOLIC_CABEC SC, "); 
        sql.append(" PED_TIPO_SOLIC TS, "); 
        sql.append(" PED_TIPO_SOLIC_PAIS TSP, "); 
        sql.append(" PED_SOLIC_POSIC SP ");
        sql.append(" WHERE SC.PERD_OID_PERI = ? AND ");
        parametros.add(oidPeriodo);
        sql.append(" SC.FEC_FACT IS NOT NULL AND ");
        sql.append(" SC.IND_TS_NO_CONSO = 1 AND "); 
        sql.append(" SC.IND_OC = 1 AND "); 
        sql.append(" (SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) AND ");
        sql.append(" SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS AND "); 
        sql.append(" TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI AND ");
        sql.append(" TS.IND_ANUL = 1 AND ");
        sql.append(" SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(sql.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerMontoLocalAnulaciones: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        BigDecimal resultado = null;

        if (rs != null){
            if (rs.getValueAt(0,"MONTO_LOCAL_ANULACIONES") != null)
                resultado = (BigDecimal)rs.getValueAt(0,"MONTO_LOCAL_ANULACIONES");                                                        
        }
        
        UtilidadesLog.info("DAORegistroEstadistico.obtenerMontoLocalAnulaciones(Long oidPeriodo): Salida");        
        return resultado;
    }
    
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPeriodo
     */
    public Long obtenerNumeroRealPedidosDevueltos(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealPedidosDevueltos(Long oidPeriodo): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT "); 
        consulta.append(" 	COUNT(*) NUMERO_REAL_PEDIDOS_DEVUELTOS "); 
        consulta.append(" FROM ");
        consulta.append(" 	PED_SOLIC_CABEC SC, "); 
        consulta.append(" 	PED_TIPO_SOLIC TS, "); 
        consulta.append(" 	PED_TIPO_SOLIC_PAIS TSP "); 
        consulta.append(" WHERE "); 
        if (oidPeriodo != null){
            consulta.append(" 	SC.PERD_OID_PERI = ? AND "); 
            parametros.add(oidPeriodo);                           
        }	                              
        consulta.append(" 	SC.FEC_FACT IS NOT NULL AND "); 
        consulta.append(" 	SC.IND_TS_NO_CONSO = 1 AND "); 
        consulta.append(" 	SC.IND_OC = 1 AND "); 
        consulta.append(" 	(SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) AND "); 
        consulta.append(" 	SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS AND "); 
        consulta.append(" 	TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI AND "); 
        consulta.append(" 	TS.IND_DEVO = 1 "); 
  
        

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerNumeroRealPedidosDevueltos : Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        Long resultado = null;

        if (rs != null){
            if (rs.getValueAt(0,"NUMERO_REAL_PEDIDOS_DEVUELTOS") != null)
                resultado = new Long(((BigDecimal)rs.getValueAt(0,"NUMERO_REAL_PEDIDOS_DEVUELTOS")).longValue());                                                                        
        }
                
        UtilidadesLog.info("DAORegistroEstadistico.obtenerNumeroRealPedidosDevueltos(Long oidPeriodo): Salida");
        return resultado;
    }
    
    public BigDecimal obtenerMontoLocalDevoluciones(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerMontoLocalDevoluciones(Long oidPeriodo): Entrada");
        
        //INCIDENCIA BELC300016582
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT NVL(SUM(SP.VAL_PREC_CATA_TOTA_LOCA),0) MONTO_LOCAL_ANULACIONES "); 
        consulta.append(" FROM "); 
        consulta.append(" 	PED_SOLIC_CABEC SC, "); 
        consulta.append(" 	PED_TIPO_SOLIC TS, "); 
        consulta.append(" 	PED_TIPO_SOLIC_PAIS TSP, "); 
        consulta.append(" 	PED_SOLIC_POSIC SP "); 
        consulta.append(" WHERE "); 
         if (oidPeriodo != null){
            consulta.append(" SC.PERD_OID_PERI = ? AND "); 
            parametros.add(oidPeriodo);                           
        }	                        
        consulta.append(" 	SC.FEC_FACT IS NOT NULL AND "); 
        consulta.append(" 	SC.IND_TS_NO_CONSO = 1 AND "); 
        consulta.append(" 	SC.IND_OC = 1 AND "); 
        consulta.append(" 	(SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) AND "); 
        consulta.append(" 	SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS AND "); 
        consulta.append(" 	TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI AND "); 
        consulta.append(" 	TS.IND_DEVO = 1 AND "); 
        consulta.append(" 	SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE "); 
        
            
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerMontoLocalDevoluciones : Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }
        
        BigDecimal resultado = null;

        if (rs != null){
            if (rs.getValueAt(0,"MONTO_LOCAL_ANULACIONES") != null)
                resultado = ((BigDecimal)rs.getValueAt(0,"MONTO_LOCAL_ANULACIONES"));                                                        
        }
                
        UtilidadesLog.info("DAORegistroEstadistico.obtenerMontoLocalDevoluciones(Long oidPeriodo): Salida");
        return resultado;
    }
    
    //BELC300016600
	//BELC300016600
	public RecordSet obtenerEstadisticasCV(Long oidPeriodo) throws MareException {
      UtilidadesLog.info("DAORegistroEstadistico.obtenerEstadisticasCV(Long oidPeriodo): Entrada");
      
      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      consulta.append(" select ");
      consulta.append(" MF.OID_MATR_FACT OID_MF, ");
      consulta.append(" OD.VAL_CODI_VENT CODIGO_VENTA, ");
      consulta.append(" NVL(OD.NUM_UNID_ESTI,0) UNIDADES_ESTIMADAS, ");
      consulta.append(" NVL((OD.NUM_UNID_ESTI * OD.IMP_PREC_CATA),0) MONTO_ESTIMADO_LOCAL, ");
      consulta.append(" NVL(SUM(SP.NUM_UNID_ATEN),0) UNIDADES_FACTURADAS, ");
      consulta.append(" NVL((SUM(SP.NUM_UNID_POR_ATEN) - SUM(SP.NUM_UNID_ATEN)),0) UNIDADES_FALTANTES, ");
      consulta.append(" NVL(SUM(SP.VAL_PREC_CATA_TOTA_LOCA),0) MONTO_FACTURADO ");
      consulta.append(" from ");
      consulta.append(" PRE_MATRI_FACTU_CABEC CMF, ");
      consulta.append(" PRE_MATRI_FACTU MF, ");
      consulta.append(" PRE_OFERT O, ");
      consulta.append(" PRE_OFERT_DETAL OD, ");
      consulta.append(" PED_SOLIC_CABEC SC, ");
      consulta.append(" PED_SOLIC_POSIC SP ");
      consulta.append(" where ");
      if(oidPeriodo != null){
        consulta.append(" CMF.PERD_OID_PERI = ? AND ");//--57
        parametros.add(oidPeriodo);
      }
      consulta.append(" SC.PERD_OID_PERI = CMF.PERD_OID_PERI ");
      consulta.append(" AND O.MFCA_OID_CABE = CMF.OID_CABE ");
      consulta.append(" AND OD.OFER_OID_OFER = O.OID_OFER ");
      consulta.append(" AND MF.MFCA_OID_CABE = CMF.OID_CABE ");
      consulta.append(" AND MF.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER ");
      consulta.append(" AND SC.FEC_FACT IS NOT NULL ");
      consulta.append(" AND SC.IND_TS_NO_CONSO = 1 ");
      consulta.append(" AND SC.IND_OC = 1  ");
      consulta.append(" AND (SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL)  ");
      consulta.append(" AND SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
      consulta.append(" AND SP.ESPO_OID_ESTA_POSI != ? ");
      parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
      consulta.append(" and SP.VAL_CODI_VENT = OD.VAL_CODI_VENT ");
      consulta.append(" group by MF.OID_MATR_FACT, OD.VAL_CODI_VENT, "+
              " OD.NUM_UNID_ESTI, (OD.NUM_UNID_ESTI * OD.IMP_PREC_CATA)");
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;
      String codigoError = null;
      try{
        rs =bs.dbService.executePreparedQuery(consulta.toString(), 
                            parametros);
      }catch (Exception e) {
        codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
        UtilidadesLog.error(" nombreDAOnombreDelMetodo: Exception",e);
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
      }//catch
    
      UtilidadesLog.info("DAORegistroEstadistico.obtenerEstadisticasCV(Long oidPeriodo): Salida");
      return rs;
  }//obtenerEstadisticasCV
    
	public RecordSet obtenerEstadisticasCVanuladas(Long oidPeriodo) throws MareException{
		UtilidadesLog.info("DAORegistroEstadistico.obtenerEstadisticasCVanuladas(Long oidPeriodo): Entrada");
    
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		consulta.append(" select ");
		consulta.append(" OD.VAL_CODI_VENT CODIGO_VENTA, ");
		consulta.append(" NVL(ABS(SUM(SP.VAL_PREC_CATA_TOTA_LOCA)),0) MONTO_ANULADO, ");
		consulta.append(" NVL(ABS(SUM(SP.NUM_UNID_ATEN)),0) UNIDADES_ANULADAS ");
		consulta.append(" from ");
		consulta.append(" PRE_MATRI_FACTU_CABEC CMF, ");
		consulta.append(" PRE_OFERT O, ");
		consulta.append(" PRE_OFERT_DETAL OD, ");
		consulta.append(" PED_SOLIC_CABEC SC, ");
		consulta.append(" PED_SOLIC_POSIC SP, ");
		consulta.append(" PED_TIPO_SOLIC TS, ");
		consulta.append(" PED_TIPO_SOLIC_PAIS TSP ");
		consulta.append(" where ");
		if(oidPeriodo != null){
			consulta.append(" CMF.PERD_OID_PERI = ? ");//--oidPeriodo RECIBIDO
			parametros.add(oidPeriodo);
		}
		consulta.append(" AND O.MFCA_OID_CABE = CMF.OID_CABE ");
		consulta.append(" AND OD.OFER_OID_OFER = O.OID_OFER ");
		consulta.append(" AND SC.PERD_OID_PERI = CMF.PERD_OID_PERI ");
		consulta.append(" AND SC.FEC_FACT IS NOT NULL ");
		consulta.append(" AND SC.IND_TS_NO_CONSO = 1 ");
		consulta.append(" AND SC.IND_OC = 1 ");
		consulta.append(" AND (SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) ");
		consulta.append(" AND SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
		consulta.append(" AND SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
		consulta.append(" AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
		consulta.append(" AND TS.IND_ANUL = 1 ");
		consulta.append(" AND SP.VAL_CODI_VENT = OD.VAL_CODI_VENT ");



		consulta.append(" GROUP BY OD.VAL_CODI_VENT ");
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try{
			rs =bs.dbService.executePreparedQuery(consulta.toString(), 
												  parametros);
		}catch (Exception e) {
		  codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
		  UtilidadesLog.error(" nombreDAOnombreDelMetodo: Exception",e);
		  throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
		}//catch

		UtilidadesLog.info("DAORegistroEstadistico.obtenerEstadisticasCVanuladas(Long oidPeriodo): Salida");
		return rs;
  }
    
    public RecordSet obtenerEstadisticasCVdevueltas(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerEstadisticasCVdevueltas(Long oidPeriodo): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append(" SELECT ");                                                     
        consulta.append(" OD.VAL_CODI_VENT CODIGO_VENTA, ");
        consulta.append(" NVL(ABS(SUM(SP.VAL_PREC_CATA_TOTA_LOCA)),0) MONTO_DEVUELTO, ");
        consulta.append(" NVL(ABS(SUM(SP.NUM_UNID_ATEN)),0) UNIDADES_DEVUELTAS ");
        
        consulta.append(" FROM ");                                                           
        consulta.append(" PRE_MATRI_FACTU_CABEC CMF, ");                                     
        consulta.append(" PRE_OFERT O, ");                                                   
        consulta.append(" PRE_OFERT_DETAL OD,  ");                                           
        consulta.append(" PED_SOLIC_CABEC SC, ");                                            
        consulta.append(" PED_SOLIC_POSIC SP, ");                                            
        consulta.append(" PED_TIPO_SOLIC TS, ");                                             
        consulta.append(" PED_TIPO_SOLIC_PAIS TSP   ");                                      
                                                                  
        consulta.append(" WHERE ");                                                         
        
        consulta.append(" CMF.PERD_OID_PERI = ? AND  "); //oidPerido
        parametros.add(oidPeriodo);
        consulta.append(" O.MFCA_OID_CABE = CMF.OID_CABE AND  ");                             
        consulta.append(" OD.OFER_OID_OFER = O.OID_OFER AND  ");                              
             
        consulta.append(" SC.PERD_OID_PERI = ? AND  "); //oidPeriodo
        parametros.add(oidPeriodo);
        consulta.append(" SC.FEC_FACT IS NOT NULL AND  ");                                    
        consulta.append(" SC.IND_TS_NO_CONSO = 1 AND  ");                                     
        consulta.append(" SC.IND_OC = 1 AND   ");                                             
        consulta.append(" (SC.IND_PEDI_PRUE = 0 OR SC.IND_PEDI_PRUE IS NULL) AND  ");         
        consulta.append(" SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE AND  ");                   
        consulta.append(" SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS AND  ");        
        consulta.append(" TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI AND  ");                  
        consulta.append(" TS.IND_DEVO = 1 AND  ");                                           
        consulta.append(" SP.VAL_CODI_VENT = OD.VAL_CODI_VENT  ");                           
        consulta.append(" GROUP BY OD.VAL_CODI_VENT  ");                                      
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerEstadisticasCVdevueltas: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        UtilidadesLog.info("DAORegistroEstadistico.obtenerEstadisticasCVdevueltas(Long oidPeriodo): Salida");
        return rs;
    }
    
    public RecordSet obtenerEstadisticasDevoluciones(Long oidPeriodo) throws MareException{
        UtilidadesLog.info("DAORegistroEstadistico.obtenerEstadisticasDevoluciones(Long oidPeriodo): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
       //Inicio Consulta
       consulta.append(" SELECT ");
       consulta.append(" NVL(SUM(LOP.NUM_UNID_DEVU),0) UNIDADES_DEVUELTAS, ");                             
       consulta.append(" NVL(SUM(LOP.IMP_MONT_PERD),0) MONTO_PERDIDA, ");                                  
       consulta.append(" OP.TIOP_OID_TIPO_OPER OID_TIPO_OPERACION, ");                              
       consulta.append(" LOP.PROD_OID_PROD OID_PRODUCTO,  ");                                      
       consulta.append(" LOP.MODV_OID_MOTI_DEVO OID_MOTIVO_DEVOLUCION  ");                          
       
       consulta.append(" FROM  ");                                                                  
       consulta.append(" REC_OPERA_RECLA OP, ");                                                    
       consulta.append(" REC_LINEA_OPERA_RECLA LOP ");                                              
       
       consulta.append(" WHERE ");                                                             
       if(oidPeriodo!=null){
        //el campo tal cual estaba (PERD_OID_PERI) no existe en la tabla. (Gacevedo)
        consulta.append(" OP.PERD_OID_PERI_RECL = ? AND  ");
        parametros.add(oidPeriodo);
       }
       consulta.append(" LOP.OPRE_OID_OPER_RECL = OP.OID_OPER_RECL AND ");                       
       consulta.append(" OP.ESOP_OID_ESTA_OPER = ? AND ");
       parametros.add(ConstantesREC.ESTADO_OPERACION_ENVIADO);
       consulta.append(" LOP.TIMO_OID_TIPO_MOVI = ? ");
       parametros.add(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
       consulta.append(" GROUP BY OP.TIOP_OID_TIPO_OPER,LOP.PROD_OID_PROD,LOP.MODV_OID_MOTI_DEVO ");
       //Fin Consulta
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerEstadisticasDevoluciones: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        UtilidadesLog.info("DAORegistroEstadistico.obtenerEstadisticasDevoluciones(Long oidPeriodo): Salida");
        return rs;
    } 

    /**    
     *@Author: pperez 
     *@Fecha: 08/11/2006
     *@throws: 
     *@return: 
     *@param: 
     *@Observaciones: 
    */ 
    
    public RecordSet obtenerDatosEstadísticos(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAORegistroEstadistico.obtenerDatosEstadísticos(Long oidPeriodo): Entrada");
        StringBuffer consulta = new StringBuffer();

        consulta.append("   SELECT SUM(acum.VAL_CANT_PEDI) NREALSOLIC,    ");
        consulta.append("   	   COUNT(acum.CLIE_OID_CLIE) NREALCLIENTES,    ");
        consulta.append("   	   SUM(acum.VAL_SUM_UNID) NREALUNID,    ");
        consulta.append("   	   SUM(acum.VAL_SUM_MONT_TOTA) MONTOFACTREAL,    ");
        consulta.append("   	   SUM(acum.VAL_CANT_PEDI_ANUL) NREALPEDIANULA,    ");
        consulta.append("   	   SUM(acum.VAL_SUM_MONT_TOTA_ANUL) MONTOREALANUL,    ");
        consulta.append("   	   SUM(acum.VAL_CANT_PEDI_DEVO) NREALPEDIDEVO,   ");
        consulta.append("   	   SUM(acum.VAL_SUM_MONT_TOTA_DEVO) MONTOREALDEVO    ");
        consulta.append("   FROM PED_SOLIC_CABEC_ACUM3 acum   ");
        consulta.append("   WHERE acum.PERD_OID_PERI =  " + oidPeriodo);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executeStaticQuery(consulta.toString());
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerEstadisticasDevoluciones: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        UtilidadesLog.info("DAORegistroEstadistico.obtenerDatosEstadísticos(Long oidPeriodo): Salida");
        return rs;
    }
    
    /**    
     *@Author: pperez 
     *@Fecha: 15/11/2006
     *@throws: 
     *@return: 
     *@param: 
     *@Observaciones: 
    */ 

    public void generarEstadisticasDevolucion(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAORegistroEstadistico.generarEstadisticasDevolucion(Long oidPeriodo): Entrada");
        StringBuffer consulta = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;

        try{

            consulta.append("   DELETE FROM PRE_MATRI_ESTAD_PRODU_DEVOL med WHERE  med.PERD_OID_PERI = " + oidPeriodo);
            bs.dbService.executeUpdate(consulta.toString());
            
            consulta = new StringBuffer();
            consulta.append("   INSERT INTO PRE_MATRI_ESTAD_PRODU_DEVOL   ");
            consulta.append("               (oid_matr_esta_prod_devo, prod_oid_prod, num_unid, imp_mont_devo,   ");
            consulta.append("                tiop_oid_tipo_oper, perd_oid_peri, modv_oid_moti_devo)   ");
            consulta.append("      SELECT pre_mepd_seq.NEXTVAL, vvv.*   ");
            consulta.append("        FROM (SELECT   lop.prod_oid_prod oid_producto,   ");
            consulta.append("                       NVL (SUM (lop.num_unid_devu), 0) unidades_devueltas,   ");
            consulta.append("                       NVL (SUM (lop.imp_mont_perd), 0) monto_perdida,   ");
            consulta.append("                       op.tiop_oid_tipo_oper oid_tipo_operacion, " + oidPeriodo + ",   ");
            consulta.append("                       lop.modv_oid_moti_devo oid_motivo_devolucion   ");
            consulta.append("                  FROM REC_OPERA_RECLA op, REC_LINEA_OPERA_RECLA lop   ");
            consulta.append("                 WHERE op.perd_oid_peri_recl = " + oidPeriodo);
            consulta.append("                   AND lop.opre_oid_oper_recl = op.oid_oper_recl   ");
            consulta.append("                   AND op.esop_oid_esta_oper = " + ConstantesREC.ESTADO_OPERACION_ENVIADO);
            consulta.append("                   AND lop.timo_oid_tipo_movi = " + ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
            consulta.append("              GROUP BY op.tiop_oid_tipo_oper,   ");
            consulta.append("                       lop.prod_oid_prod,   ");
            consulta.append("                       lop.modv_oid_moti_devo) vvv   ");
            bs.dbService.executeUpdate(consulta.toString());

        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" generarEstadisticasDevolucion: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
    
    
    }    
}