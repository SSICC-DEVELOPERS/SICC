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
package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.intsys.DTOINTCargaInicialLarissa;
import es.indra.sicc.dtos.intsys.DTOINTDatosImpresionGuias;
import es.indra.sicc.dtos.intsys.DTOINTDatosMaestro;
import es.indra.sicc.dtos.intsys.DTOINTDatosMaestroTerritorio;
import es.indra.sicc.dtos.intsys.DTOINTDocumento;
import es.indra.sicc.dtos.intsys.DTOINTDocumentoIdendidad;
import es.indra.sicc.dtos.intsys.DTOINTProductoEstimado;
import es.indra.sicc.dtos.intsys.DTOINTClaseTipoSolicitud;
import es.indra.sicc.dtos.intsys.DTOINTDestinosClientes;
import es.indra.sicc.dtos.fac.DTOFACReasignarNumeroDocContable;
import es.indra.sicc.dtos.intsys.DTOINTProductoVentaReal;
import es.indra.sicc.dtos.intsys.DTOINTSecuenciaPedido;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.sicc.logicanegocio.ped.ConstantesPED;

public class DAOINTLAR {
    public DAOINTLAR()
    {
    }
    
    /*
     * Se modifica la consulta por incidencia SiCC 20070285
     * Rafael Romero - 05/06/20047
     */
      public ArrayList obtenerZonas (Long periodo, Long oidPais) throws MareException {

       UtilidadesLog.info("DAOINTLAR.obtenerZonas(Long periodo): Entrada");
    
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append(" SELECT DISTINCT * ");
        consulta.append("            FROM (SELECT zon.oid_zona oid_zona, zon.cod_zona codigozona, ");
        consulta.append("                         zon.des_zona descripcionzona ");
        consulta.append("                    FROM int_lar_tipo_solici_pedido_dis tspd, ");
        consulta.append("                         ped_solic_cabec soc, ");
        consulta.append("                         zon_zona zon ");
        consulta.append("                   WHERE soc.zzon_oid_zona = zon.oid_zona ");
        consulta.append("                     AND soc.perd_oid_peri = "+periodo+" ");
        consulta.append("                     AND soc.ind_inte_lari_gene = 0 ");
        consulta.append("                     AND soc.ind_ts_no_conso = 0 ");
        consulta.append("                     AND soc.num_unid_aten_tota > 0 ");
        consulta.append("                     AND (soc.ind_pedi_prue = 0 OR soc.ind_pedi_prue IS NULL) ");
        consulta.append("                     AND zon.pais_oid_pais = "+oidPais+" ");
        consulta.append("                     AND soc.fec_fact IS NOT NULL ");
        consulta.append("                     AND soc.tspa_oid_tipo_soli_pais = tspd.tspa_oid_tipo_soli_pais ");
        consulta.append("                     AND NOT EXISTS ( ");
        consulta.append("                            SELECT 1 ");
        consulta.append("                              FROM mav_param_geren_zona pagz ");
        consulta.append("                             WHERE pagz.sbti_oid_subt_clie = soc.sbti_oid_subt_clie) ");
        consulta.append("                  UNION ALL ");
        consulta.append("                  SELECT zon1.oid_zona oid_zona, zon1.cod_zona codigozona, ");
        consulta.append("                         zon1.des_zona descripcionzona ");
        consulta.append("                    FROM int_lar_tipo_solici_pedido_dis tspd1, ");
        consulta.append("                         ped_solic_cabec soc1, ");
        consulta.append("                         zon_zona zon1 ");
        consulta.append("                   WHERE soc1.clie_oid_clie = zon1.clie_oid_clie ");
        consulta.append("                     AND soc1.perd_oid_peri = "+periodo+" ");
        consulta.append("                     AND soc1.ind_inte_lari_gene = 0 ");
        consulta.append("                     AND soc1.ind_ts_no_conso = 0 ");
        consulta.append("                     AND soc1.num_unid_aten_tota > 0 ");
        consulta.append("                     AND (soc1.ind_pedi_prue = 0 OR soc1.ind_pedi_prue IS NULL) ");
        consulta.append("                     AND zon1.pais_oid_pais = "+oidPais+" ");
        consulta.append("                     AND soc1.fec_fact IS NOT NULL ");
        consulta.append("                     AND soc1.tspa_oid_tipo_soli_pais = tspd1.tspa_oid_tipo_soli_pais ");
        consulta.append("                     AND EXISTS ( ");
        consulta.append("                            SELECT 1 ");
        consulta.append("                              FROM mav_param_geren_zona pagz1 ");
        consulta.append("                             WHERE pagz1.sbti_oid_subt_clie = soc1.sbti_oid_subt_clie)) ");
        consulta.append("        ORDER BY 2 ");

                                                                                
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch
       ArrayList array = new ArrayList();
       DTOINTDatosMaestro  dto=null;
     if(rs!=null){
       if(!rs.esVacio()){
             int n=rs.getRowCount();
             //array = new ArrayList(); eliminado y definido antes INC 16916 y 16738
             
            for(int i=0;i<n;i++){
                 dto=new DTOINTDatosMaestro ();
                 if(rs.getValueAt(i,"OID_ZONA")!=null){
                    dto.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID_ZONA")).longValue()));//Atencion aqui con el alias
                }
                 if(rs.getValueAt(i,"CODIGOZONA")!=null){
                    dto.setCodigo((String)rs.getValueAt(i,"CODIGOZONA"));//Atencion aqui con EL alias
                }
                if(rs.getValueAt(i,"DESCRIPCIONZONA")!=null){
                    dto.setDescripcion((String)rs.getValueAt(i,"DESCRIPCIONZONA"));//Atencion aqui con EL alias
                }
                
            array.add(dto); 
            
            }//for
        }//(!rs.esVacio()
      } //(rs!=null)
      //Con los registros obtenidos, se crea una lista de objetos DTOPeriodo y se retorna.
        UtilidadesLog.info("DAOINTLAR.obtenerZonas(Long periodo): Salida");
        return array;
     }    
     
      public ArrayList obtenerTerritorios  (Long periodo, Long oidPais) throws MareException {
       UtilidadesLog.info("DAOINTLAR.obtenerTerritorios(Long periodo , Long oidPais): Entrada");
    
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();



        consulta.append(" SELECT DISTINCT * ");
        consulta.append("            FROM (SELECT ter.oid_terr oidterritorio, ");
        consulta.append("                         ter.cod_terr codigoterritorio, zon.oid_zona oidzona, ");
        consulta.append("                         zon.cod_zona codzona ");
        consulta.append("                    FROM int_lar_tipo_solici_pedido_dis tspd, ");
        consulta.append("                         ped_solic_cabec soc, ");
        consulta.append("                         zon_zona zon, ");
        consulta.append("                         zon_terri ter ");
        consulta.append("                   WHERE soc.terr_oid_terr = ter.oid_terr ");
        consulta.append("                     AND soc.zzon_oid_zona = zon.oid_zona ");
        consulta.append("                     AND soc.perd_oid_peri = "+periodo+" ");
        consulta.append("                     AND soc.ind_inte_lari_gene = 0 ");
        consulta.append("                     AND soc.ind_ts_no_conso = 0 ");
        consulta.append("                     AND soc.num_unid_aten_tota > 0 ");
        consulta.append("                     AND (soc.ind_pedi_prue = 0 OR soc.ind_pedi_prue IS NULL) ");
        consulta.append("                     AND zon.pais_oid_pais = "+oidPais+" ");
        consulta.append("                     AND soc.fec_fact IS NOT NULL ");
        consulta.append("                     AND soc.tspa_oid_tipo_soli_pais = tspd.tspa_oid_tipo_soli_pais ");
        consulta.append("                     AND NOT EXISTS ( ");
        consulta.append("                            SELECT 1 ");
        consulta.append("                              FROM mav_param_geren_zona pagz ");
        consulta.append("                             WHERE pagz.sbti_oid_subt_clie = soc.sbti_oid_subt_clie) ");
        consulta.append("                  UNION ALL ");
        consulta.append("                  SELECT 0 oidterritorio, ");
        consulta.append("                         0 codigoterritorio, zon1.oid_zona oidzona, ");
        consulta.append("                         zon1.cod_zona codzona ");
        consulta.append("                    FROM int_lar_tipo_solici_pedido_dis tspd1, ");
        consulta.append("                         ped_solic_cabec soc1, ");
        consulta.append("                         zon_zona zon1 ");
        consulta.append("                   WHERE soc1.clie_oid_clie = zon1.clie_oid_clie ");
        consulta.append("                     AND soc1.perd_oid_peri = "+periodo+" ");
        consulta.append("                     AND soc1.ind_inte_lari_gene = 0 ");
        consulta.append("                     AND soc1.ind_ts_no_conso = 0 ");
        consulta.append("                     AND soc1.num_unid_aten_tota > 0 ");
        consulta.append("                     AND (soc1.ind_pedi_prue = 0 OR soc1.ind_pedi_prue IS NULL) ");
        consulta.append("                     AND zon1.pais_oid_pais = "+oidPais+" ");
        consulta.append("                     AND soc1.fec_fact IS NOT NULL ");
        consulta.append("                     AND soc1.tspa_oid_tipo_soli_pais = tspd1.tspa_oid_tipo_soli_pais ");
        consulta.append("                     AND EXISTS ( ");
        consulta.append("                            SELECT 1 ");
        consulta.append("                              FROM mav_param_geren_zona pagz1 ");
        consulta.append("                             WHERE pagz1.sbti_oid_subt_clie = soc1.sbti_oid_subt_clie)) ");
        consulta.append("        ORDER BY 2 ");

/*
        //MODIFICADO POR LA INCIDENCIA 19921
        consulta.append(" SELECT DISTINCT ");                                                                   
        consulta.append(" SOC.TERR_OID_TERR OIDTERRITORIO, ");                                         
        consulta.append(" TER.COD_TERR CODIGOTERRITORIO, ");
        //MODIFICADO BELC300024162  pzerbino 18/9/2006
        consulta.append(" ZONA.OID_ZONA OIDZONA, ");
        consulta.append(" ZONA.COD_ZONA CODZONA ");
        
        consulta.append(" FROM ");                                                                     
        consulta.append(" PED_SOLIC_CABEC SOC, ");                                                     
        consulta.append(" ZON_TERRI TER, "); 
        //MODIFICADO BELC300024162  pzerbino 18/9/2006        
        consulta.append(" INT_LAR_TIPO_SOLICI_PEDIDO_DIS TSPD, "); 
        consulta.append(" ZON_ZONA ZONA "); 

        consulta.append(" WHERE ");                                                                    
        consulta.append(" SOC.TERR_OID_TERR = TER.OID_TERR ");                                                                
                                                                                                       
        consulta.append(" AND SOC.PERD_OID_PERI = ? ");                                    
        parametros.add(periodo);                                                                                              
        consulta.append(" AND SOC.FEC_FACT IS NOT NULL ");                                             
        consulta.append(" AND SOC.IND_INTE_LARI_GENE = 0 ");                                           

        consulta.append(" AND SOC.IND_TS_NO_CONSO = 0 ");                                              
        consulta.append(" AND (SOC.IND_PEDI_PRUE = 0 OR SOC.IND_PEDI_PRUE IS NULL)");
        
        //AGREGADO POR LA INCIDENCIA 21122
        consulta.append(" AND TER.PAIS_OID_PAIS = ? ");                                                                                                        
        //----
        parametros.add(oidPais);
        //MODIFICADO BELC300024162  pzerbino 18/9/2006
        consulta.append(" AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSPD.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append(" AND SOC.ZZON_OID_ZONA = ZONA.OID_ZONA ");
        consulta.append(" ORDER BY ");                                                                 
        consulta.append(" TER.COD_TERR ");                                                             
*/

                                                                                
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           //rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
           rs =bs.dbService.executeStaticQuery(consulta.toString());
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch
       ArrayList array = new ArrayList();
        //MODIFICADO PZERBINO BELC300024162 
       //DTOINTDatosMaestro  dto=null;
       DTOINTDatosMaestroTerritorio  dto = null;
     if(rs!=null){
       if(!rs.esVacio()){
             int n=rs.getRowCount();
             //array = new ArrayList(); eliminado y definido antes INC 16916 y 16738
             
            for(int i=0;i<n;i++){
                  //MODIFICADO PZERBINO BELC300024162 
                 //dto=new DTOINTDatosMaestro ();
                 dto=new DTOINTDatosMaestroTerritorio ();
                 if(rs.getValueAt(i,"OIDTERRITORIO")!=null){
                    dto.setOidTerritorio(new Long(((BigDecimal)rs.getValueAt(i,"OIDTERRITORIO")).longValue()));
                    //dto.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OIDTERRITORIO")).longValue()));//Atencion aqui con lo alias
                }
                 if(rs.getValueAt(i,"CODIGOTERRITORIO")!=null){
                    dto.setCodigoTerritorio((String)rs.getValueAt(i,"CODIGOTERRITORIO").toString());
                    //dto.setCodigo((String)rs.getValueAt(i,"CODIGOTERRITORIO").toString());//Atencion aqui con EL alias
                
                }
                if(rs.getValueAt(i,"OIDZONA")!=null){
                    dto.setOidZona(new Long(((BigDecimal)rs.getValueAt(i,"OIDZONA")).longValue()));
                }
                 if(rs.getValueAt(i,"CODZONA")!=null){
                    dto.setCodigoZona((String)rs.getValueAt(i,"CODZONA").toString());
                }
                               
            array.add(dto); 
            
            }//for
        }//(!rs.esVacio()
      } //(rs!=null)
      //Con los registros obtenidos, se crea una lista de objetos DTOPeriodo y se retorna.
        UtilidadesLog.info("DAOINTLAR.obtenerTerritorios(Long periodo, Long oidPais): Salida");	
        return array;
     }  
     
     
     
     
     
       public ArrayList obtenerProductosEstimados  (Long periodo) throws MareException {

       UtilidadesLog.info("DAOINTLAR.obtenerProductosEstimados(Long periodo): Entrada");
    
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        //MODIFICADO POR INCIDENCIA 19986
        consulta.append(" SELECT  ");                                          
        consulta.append(" PRO.OID_PROD OIDPRODUCTO, ");                        
        consulta.append(" PRO.COD_SAP CODIGOITEM, ");                          
        consulta.append(" PRO.DES_CORT DESCRIPCIONPRODUCTO, ");                
        consulta.append(" MPR.COD_MARC_PROD MARCA, ");                         
        consulta.append(" UNE.COD_UNID_NEGO UNIDADNEGOCIO, ");                 
        consulta.append(" NEG.COD_NEGO NEGOCIO, ");                            
        consulta.append(" ESP.COD_ESTA_PROD ESTATUSPRODUCTO, ");               
        consulta.append(" SUM(MFC.NUM_UNID_ESTI) TOTALUNIDADESPRODUCTO, ");          
        consulta.append(" PRO.COD_IND_DENT_CAJA INDICADORDENTROFUERACAJA, ");  
        consulta.append(" PRO.VAL_DIME_LARG LARGOCENTIMETROS,");               
        consulta.append(" PRO.VAL_DIME_ANCH ANCHOCENTIMETROS, ");              
        consulta.append(" PRO.VAL_DIME_ALTO ALTOCENTIMETROS, ");               
        consulta.append(" PRO.VAL_PESO PESOBRUTOGRAMOS  "); 
		consulta.append(" FROM PRE_MATRI_FACTU_CABEC MFC, PRE_MATRI_FACTU MF, ");
        consulta.append(" CRA_PERIO PER, PRE_OFERT_DETAL OFD, ");
		consulta.append(" MAE_PRODU PRO, MAE_NEGOC NEG, SEG_MARCA_PRODU MPR, ");
        consulta.append(" MAE_UNIDA_NEGOC UNE, MAE_ESTAT_PRODU ESP ");
		consulta.append(" WHERE MFC.PERD_OID_PERI = PER.OID_PERI ");
        consulta.append(" AND MF.MFCA_OID_CABE = MFC.OID_CABE ");
        consulta.append(" AND MF.OFDE_OID_DETA_OFER = OFD.OID_DETA_OFER ");
		consulta.append(" AND OFD.PROD_OID_PROD = PRO.OID_PROD ");
        consulta.append(" AND PRO.NEGO_OID_NEGO = NEG.OID_NEGO (+) ");
        consulta.append(" AND PRO.MAPR_OID_MARC_PROD = MPR.OID_MARC_PROD(+) ");
		consulta.append(" AND PRO.UNEG_OID_UNID_NEGO = UNE.OID_UNID_NEGO(+) ");
        consulta.append(" AND PRO.MEUD_OID_ESTA_PROD = ESP.OID_ESTA_PROD(+) ");
		consulta.append(" AND MFC.PERD_OID_PERI = ? ");
		parametros.add(periodo);
        consulta.append(" GROUP BY ");
        consulta.append(" PRO.OID_PROD, PRO.COD_SAP, PRO.DES_CORT, MPR.COD_MARC_PROD,  ");
        consulta.append(" UNE.COD_UNID_NEGO, NEG.COD_NEGO, ESP.COD_ESTA_PROD, ");
        consulta.append(" PRO.COD_IND_DENT_CAJA, PRO.VAL_DIME_LARG, PRO.VAL_DIME_ANCH, ");
        consulta.append(" PRO.VAL_DIME_ALTO, PRO.VAL_PESO ");
		consulta.append(" ORDER BY PRO.COD_SAP ");                                        
                                                                                
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch
       ArrayList array = new ArrayList();
       DTOINTProductoEstimado   dto=null;
     if(rs!=null){
       if(!rs.esVacio()){
             int n=rs.getRowCount();
             //array = new ArrayList(); eliminado y definido antes inc 16916 y 16738
             
            for(int i=0;i<n;i++){
                 dto=new DTOINTProductoEstimado();
                 if(rs.getValueAt(i,"OIDPRODUCTO")!=null){
                    dto.setOidProducto(new Long(((BigDecimal)rs.getValueAt(i,"OIDPRODUCTO")).longValue()));//Atencion aqui con lo alias
                }
                 if(rs.getValueAt(i,"CODIGOITEM")!=null){
                    dto.setCodigoSAP((String)rs.getValueAt(i,"CODIGOITEM"));//Atencion aqui con EL alias
                }
                 if(rs.getValueAt(i,"DESCRIPCIONPRODUCTO")!=null){
                    dto.setDescripcionProducto((String)rs.getValueAt(i,"DESCRIPCIONPRODUCTO"));//Atencion aqui con EL alias
                }
                if(rs.getValueAt(i,"MARCA")!=null){
                    dto.setMarca((String)rs.getValueAt(i,"MARCA"));//Atencion aqui con EL alias
                }
				if(rs.getValueAt(i,"UNIDADNEGOCIO")!=null){
                    dto.setUnidadNegocio((String)rs.getValueAt(i,"UNIDADNEGOCIO"));//Atencion aqui con EL alias
                }
				if(rs.getValueAt(i,"NEGOCIO")!=null){
                    dto.setNegocio((String)rs.getValueAt(i,"NEGOCIO"));//Atencion aqui con EL alias
                }
				if(rs.getValueAt(i,"ESTATUSPRODUCTO")!=null){
                    dto.setEstatusProducto((String)rs.getValueAt(i,"ESTATUSPRODUCTO"));//Atencion aqui con EL alias
                }
				if(rs.getValueAt(i,"TOTALUNIDADESPRODUCTO")!=null){
                    dto.setTotalUnidadesProducto(new Integer(((BigDecimal)rs.getValueAt(i,"TOTALUNIDADESPRODUCTO")).toString()));//Atencion aqui con EL alias
                }
				if(rs.getValueAt(i,"INDICADORDENTROFUERACAJA")!=null){
                    dto.setIndicadorDentroFueraCaja((String)rs.getValueAt(i,"INDICADORDENTROFUERACAJA"));//Atencion aqui con EL alias
                }
				if(rs.getValueAt(i,"LARGOCENTIMETROS")!=null){
                    dto.setLargoCentimetros(new Integer(((BigDecimal)rs.getValueAt(i,"LARGOCENTIMETROS")).toString()));//Atencion aqui con EL alias
                }
				if(rs.getValueAt(i,"ANCHOCENTIMETROS")!=null){
                    dto.setAnchoCentimetros(new Integer(((BigDecimal)rs.getValueAt(i,"ANCHOCENTIMETROS")).toString()));//Atencion aqui con EL alias
                }
				if(rs.getValueAt(i,"ALTOCENTIMETROS")!=null){
                    dto.setAltoCentimetros(new Integer(((BigDecimal)rs.getValueAt(i,"ALTOCENTIMETROS")).toString()));//Atencion aqui con EL alias
                }
                if(rs.getValueAt(i,"PESOBRUTOGRAMOS") != null){
					dto.setPesoBrutoGramos(new Integer(((BigDecimal)rs.getValueAt(i,"PESOBRUTOGRAMOS")).toString()));
				}
               
                
            array.add(dto); 
            
            }//for
        }//(!rs.esVacio()
      } //(rs!=null)
      //Con los registros obtenidos, se crea una lista de objetos DTOPeriodo y se retorna.
        UtilidadesLog.info("DAOINTLAR.obtenerProductosEstimados(Long periodo): Salida");	
        return array;
     }
     
	public ArrayList obtenerClasesTiposSolicitud (Long pais,Long idioma, Long marca, Long canal) throws MareException {
		UtilidadesLog.info("DAOINTLAR.obtenerClasesTiposSolicitud(Long pais,Long idioma, Long marca, Long canal): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		
        //modificado por incidencia 20159
        consulta.append(" SELECT TS.OID_TIPO_SOLI, TS.COD_TIPO_SOLI, ");
        consulta.append(" (SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
        consulta.append(" WHERE V.VAL_OID = TS.OID_TIPO_SOLI ");
        consulta.append(" AND V.IDIO_OID_IDIO = ? ");
        parametros.add(idioma);
        consulta.append(" AND V.ATTR_NUM_ATRI = 1 ");
        consulta.append(" AND V.ATTR_ENTI = 'PED_TIPO_SOLIC') AS DESCRIPSOLIC, ");
        consulta.append(" CS.OID_CLAS_SOLI, CS.COD_CLAS_SOLI, ");
        consulta.append(" (SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
        consulta.append(" WHERE V.VAL_OID = CS.OID_CLAS_SOLI ");
        consulta.append(" AND V.IDIO_OID_IDIO = ? ");
        parametros.add(idioma);
        consulta.append(" AND V.ATTR_NUM_ATRI = 1 ");
        consulta.append(" AND V.ATTR_ENTI = 'PED_CLASE_SOLIC') AS DESCRIPCLASE ");
        consulta.append(" FROM PED_TIPO_SOLIC_PAIS TSP,PED_TIPO_SOLIC TS, PED_CLASE_SOLIC CS, ");
        consulta.append(" SEG_ACCES ACC  ");
        consulta.append(" WHERE TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        consulta.append(" AND TS.CLSO_OID_CLAS_SOLI = CS.OID_CLAS_SOLI ");
        consulta.append(" AND TS.ACCE_OID_ACCE = ACC.OID_ACCE ");
        consulta.append(" AND TSP.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append(" AND TS.MARC_OID_MARC = ? ");
        parametros.add(marca);
        consulta.append(" AND ACC.CANA_OID_CANA = ? ");
        parametros.add(canal);
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		ArrayList array = new ArrayList();
		DTOINTClaseTipoSolicitud   dto = null;
		if(rs!=null){
			if(!rs.esVacio()){
				int n=rs.getRowCount();
				//array = new ArrayList(); se elimina y se define antes inc 16916 y 16738
             
				for(int i=0;i<n;i++){
					dto= new DTOINTClaseTipoSolicitud();
					
					dto.setCodigoClaseSolicitud((String)rs.getValueAt(i,"COD_CLAS_SOLI"));
					dto.setCodigoTipoSolicitud((String)rs.getValueAt(i,"COD_TIPO_SOLI"));
					dto.setOidClaseSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"OID_CLAS_SOLI")).longValue()));
					dto.setOidTipoSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_SOLI")).longValue()));
					if(rs.getValueAt(i,"DESCRIPSOLIC") != null){
						dto.setDescripcionTipoSolicitud((String)rs.getValueAt(i,"DESCRIPSOLIC"));
					}
					if(rs.getValueAt(i,"DESCRIPCLASE") != null){
						dto.setDescripcionClaseSolicitud((String)rs.getValueAt(i,"DESCRIPCLASE"));
					}
					array.add(dto); 
				}
			}
		}
				
		UtilidadesLog.info("DAOINTLAR.obtenerClasesTiposSolicitud(Long pais,Long idioma, Long marca, Long canal): Salida");
		return array;
	 }


    /**
     * 
     * @cambio segun incidencia SiCC 20070146 de modifica completamente la consulta para obtener las direcciones..
     * @autor lortiz
     */
    /*
     * Se modifica la consulta por incidencia SiCC 20070285
     * Rafael Romero - 05/06/20047
     */
    public ArrayList obtenerDestinosClientes (Long pais, Long periodo, Long oidIdioma) throws MareException {
        UtilidadesLog.info("DAOINTLAR.obtenerDestinosClientes(): Entrada");
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT DISTINCT con.clie_oid_clie AS oidcliente, ");
        consulta.append("                 cli.cod_clie AS codigocliente, ");
        consulta.append("                 pq_apl_aux.valor_gen_i18n_sicc ");
        consulta.append("                                           ("+oidIdioma+", ");
        consulta.append("                                            trat.oid_tipo_trat, ");
        consulta.append("                                            'MAE_TIPO_TRATA' ");
        consulta.append("                                           ) AS tratamiento, ");
        consulta.append("                 cli.val_ape1 AS apellidopaterno, ");
        consulta.append("                 cli.val_ape2 AS apellidomaterno, ");
        consulta.append("                 cli.val_apel_casa AS apellidocasada, val_nom1 AS nombre1, ");
        consulta.append("                 val_nom2 AS nombre2, via.cod_tipo_via AS codigotipovia, ");
        consulta.append("                 dir.val_nomb_via AS nombrevia, ");
        consulta.append("                 dir.num_ppal AS numeroprincipal, ");
        consulta.append("                 dir.val_inte AS numerointerior, dir.val_manz AS manzana, ");
        consulta.append("                 dir.val_lote AS lote, dir.val_km AS km, ");
        consulta.append("                 dir.val_manz AS bloque, dir.val_obse AS referencia, ");
        consulta.append("                 CASE ");
        consulta.append("                    WHEN EXISTS ( ");
        consulta.append("                           SELECT 1 ");
        consulta.append("                             FROM mav_param_geren_zona pagz ");
        consulta.append("                            WHERE pagz.sbti_oid_subt_clie = con.sbti_oid_subt_clie) ");
        consulta.append("                       THEN (SELECT zon.cod_zona ");
        consulta.append("                               FROM zon_zona zon ");
        consulta.append("                              WHERE zon.clie_oid_clie = con.clie_oid_clie ");

        //Modificado por Sapaza, fecha 06-05-2008, se agrega Indicador de Zona Activo
        consulta.append("                                AND zon.ind_acti = 1) ");
        
        consulta.append("                    ELSE (SELECT zon.cod_zona ");
        consulta.append("                            FROM mae_clien_unida_admin uad, ");
        consulta.append("                                 zon_terri_admin zta, ");
        consulta.append("                                 zon_secci sec, ");
        consulta.append("                                 zon_zona zon ");
        consulta.append("                           WHERE uad.clie_oid_clie = con.clie_oid_clie ");
        //modificado por Sapaza - fecha 15/08/2007 - cambio SiCC-20070384
        //consulta.append("                             AND uad.ind_acti = 1 ");
        consulta.append("                             AND uad.perd_oid_peri_fin IS NULL ");
        consulta.append("                             AND zta.oid_terr_admi = uad.ztad_oid_terr_admi ");
        consulta.append("                             AND sec.oid_secc = zta.zscc_oid_secc ");
        
        //Modificado por Sapaza, fecha 06-05-2008, se agrega Indicador de Zona Activo
        consulta.append("                             AND zon.ind_acti = 1 ");
        
        consulta.append("                             AND zon.oid_zona = sec.zzon_oid_zona) ");
        consulta.append("                 END codigozona, ");
        consulta.append("                 CASE ");
        consulta.append("                    WHEN EXISTS ( ");
        consulta.append("                           SELECT 1 ");
        consulta.append("                             FROM mav_param_geren_zona pagz ");
        consulta.append("                            WHERE pagz.sbti_oid_subt_clie = con.sbti_oid_subt_clie) ");
        consulta.append("                       THEN 0 ");
        consulta.append("                    ELSE (SELECT terr.cod_terr ");
        consulta.append("                            FROM mae_clien_unida_admin uad, ");
        consulta.append("                                 zon_terri_admin zta, ");
        consulta.append("                                 zon_terri terr ");
        consulta.append("                           WHERE uad.clie_oid_clie = con.clie_oid_clie ");
        //modificado por Sapaza - fecha 15/08/2007 - cambio SiCC-20070384        
        //consulta.append("                             AND uad.ind_acti = 1 ");
        consulta.append("                             AND uad.perd_oid_peri_fin IS NULL ");
        consulta.append("                             AND zta.oid_terr_admi = uad.ztad_oid_terr_admi ");
        consulta.append("                             AND terr.oid_terr = zta.terr_oid_terr) ");
        consulta.append("                 END codigoterritorio, ");
        consulta.append("                 0 AS indicadorvip, SUBSTR (dir.cod_unid_geog, 1, ");
        consulta.append("                                            6) AS ubigeo1, ");
        consulta.append("                 SUBSTR (dir.cod_unid_geog, 7, 6) AS ubigeo2, ");
        consulta.append("                 SUBSTR (dir.cod_unid_geog, 13, 6) AS ubigeo3, ");
        consulta.append("                 SUBSTR (dir.cod_unid_geog, 19, 6) AS ubigeo4, ");
        consulta.append("                 SUBSTR (dir.cod_unid_geog, 25, 6) AS ubigeo5, ");
        consulta.append("                 SUBSTR (dir.cod_unid_geog, 31, 6) AS ubigeo6, ");
        consulta.append("                 SUBSTR (dir.cod_unid_geog, 37, 6) AS ubigeo7, ");
        consulta.append("                 SUBSTR (dir.cod_unid_geog, 43, 6) AS ubigeo8 ");
        consulta.append("            FROM ped_solic_cabec con, ");
        consulta.append("                 mae_clien cli, ");
        consulta.append("                 mae_tipo_trata trat, ");
        consulta.append("                 mae_clien_direc dir, ");
        consulta.append("                 seg_tipo_via via ");
        consulta.append("           WHERE con.perd_oid_peri = "+periodo+" ");
        consulta.append("             AND con.tspa_oid_tipo_soli_pais IN ( ");
        consulta.append("                                            SELECT tspa_oid_tipo_soli_pais ");
        consulta.append("                                              FROM int_lar_tipo_solici_pedido_dis) ");
        consulta.append("             AND con.fec_fact IS NOT NULL ");
        consulta.append("             AND con.ind_inte_lari_gene = 0 ");
        consulta.append("             AND con.num_unid_aten_tota > 0 ");
        consulta.append("             AND con.clie_oid_clie = cli.oid_clie ");
        consulta.append("             AND cli.val_trat = trat.cod_tipo_trat ");
        consulta.append("             AND con.clie_oid_clie = dir.clie_oid_clie ");
        consulta.append("             AND (dir.ind_elim = 0 OR dir.ind_elim <> 1) ");
        consulta.append("             AND dir.ind_dire_ppal = 1 ");
        consulta.append("             AND via.oid_tipo_via = dir.tivi_oid_tipo_via ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs;
        try {
            rs =bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        ArrayList destinosClientes = new ArrayList();
        DTOINTDestinosClientes dto = null;
        
        if(!rs.esVacio()) {
            int cant = rs.getRowCount();
            for(int i = 0; i < cant; i++) {
                dto = new DTOINTDestinosClientes();
        
                dto.setOidCliente(new Long(((BigDecimal)rs.getValueAt(i,"OIDCLIENTE")).longValue()));
                dto.setCodigoCliente((String)rs.getValueAt(i,"CODIGOCLIENTE"));
                if (rs.getValueAt(i,"TRATAMIENTO") != null) {
                    dto.setTratamiento((String)rs.getValueAt(i,"TRATAMIENTO"));
                }
                if(rs.getValueAt(i,"APELLIDOPATERNO") != null) {
                    dto.setApellidoPaterno((String)rs.getValueAt(i,"APELLIDOPATERNO"));
                }
                if(rs.getValueAt(i,"APELLIDOMATERNO") != null) {
                    dto.setApellidoMaterno((String)rs.getValueAt(i,"APELLIDOMATERNO"));
                }
                if(rs.getValueAt(i,"APELLIDOCASADA") != null) {
                    dto.setApellidoCasada((String)rs.getValueAt(i,"APELLIDOCASADA"));
                }
                if(rs.getValueAt(i,"NOMBRE1") != null){
                    dto.setNombre1((String)rs.getValueAt(i,"NOMBRE1"));
                }
                if(rs.getValueAt(i,"NOMBRE2") != null) {
                    dto.setNombre2((String)rs.getValueAt(i,"NOMBRE2"));
                }
                dto.setCodigoTipoVia((String)rs.getValueAt(i,"CODIGOTIPOVIA"));
                dto.setNombreVia((String)rs.getValueAt(i,"NOMBREVIA"));
                if(rs.getValueAt(i,"NUMEROPRINCIPAL") != null) {
                    dto.setNumeroPrincipal((String)rs.getValueAt(i,"NUMEROPRINCIPAL").toString());
                }
                if(rs.getValueAt(i,"NUMEROINTERIOR") != null) {
                    dto.setNumeroInterior(((BigDecimal)rs.getValueAt(i,"NUMEROINTERIOR")).toString());
                }
                if(rs.getValueAt(i,"MANZANA") != null) {
                    dto.setManzana(((BigDecimal)rs.getValueAt(i,"MANZANA")).toString());
                }
                if(rs.getValueAt(i,"LOTE") != null) {
                    dto.setLote(((BigDecimal)rs.getValueAt(i,"LOTE")).toString());
                }
                if(rs.getValueAt(i,"KM") != null) {
                    dto.setKm(((BigDecimal)rs.getValueAt(i,"KM")).toString());
                }
                if(rs.getValueAt(i,"REFERENCIA") != null) {
                    dto.setReferencia((String)rs.getValueAt(i,"REFERENCIA"));
                }
                dto.setCodigoZona((String)rs.getValueAt(i,"CODIGOZONA"));
                dto.setCodigoTerritorio((String)rs.getValueAt(i,"CODIGOTERRITORIO").toString());
                
                if (((BigDecimal)rs.getValueAt(i,"INDICADORVIP")).compareTo(new BigDecimal(0))==0) {
                    dto.setIndicadorVIP(new Boolean(false));
                } else {
                    dto.setIndicadorVIP(new Boolean(true));
                }

                if(rs.getValueAt(i,"UBIGEO1") != null) {
                    dto.setUbigeo1((String)rs.getValueAt(i,"UBIGEO1"));
                }
                if(rs.getValueAt(i,"UBIGEO2") != null) {
                    dto.setUbigeo2((String)rs.getValueAt(i,"UBIGEO2"));
                }
                if(rs.getValueAt(i,"UBIGEO3") != null) {
                    dto.setUbigeo3((String)rs.getValueAt(i,"UBIGEO3"));
                }
                if(rs.getValueAt(i,"UBIGEO4") != null) {
                    dto.setUbigeo4((String)rs.getValueAt(i,"UBIGEO4"));
                }
                if(rs.getValueAt(i,"UBIGEO5") != null) {
                    dto.setUbigeo5((String)rs.getValueAt(i,"UBIGEO5"));
                }
                if(rs.getValueAt(i,"UBIGEO6") != null) {
                    dto.setUbigeo6((String)rs.getValueAt(i,"UBIGEO6"));
                }
                if(rs.getValueAt(i,"UBIGEO7") != null) {
                    dto.setUbigeo7((String)rs.getValueAt(i,"UBIGEO7"));
                }
                if(rs.getValueAt(i,"UBIGEO8") != null) {
                    dto.setUbigeo8((String)rs.getValueAt(i,"UBIGEO8"));
                }
                destinosClientes.add(dto);
            }
        }
        UtilidadesLog.info("DAOINTLAR.obtenerDestinosClientes(): Salida");
        return destinosClientes;
    }

	
	public ArrayList obtenerDetallesDocumento(Long periodo) throws MareException {
		UtilidadesLog.info("DAOINTLAR.obtenerDetallesDocumento(Long periodo): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		
        //MODIFICADO POR INCIDENCIA 19925
		      
        consulta.append(" SELECT DISTINCT ");
        
        consulta.append(" EMP.COD_SOCI codigoEmpresa, ");
        consulta.append(" SOC2.VAL_NUME_SOLI numeroPedido, PRO.COD_SAP codigoItem, ");
        consulta.append(" SOP.NUM_UNID_ATEN unidadesPorAtender, ");
        consulta.append(" PRO.COD_IND_DENT_CAJA indicadorDentroFueraCaja,  ");
        consulta.append(" CLAS.COD_CLAS_SOLI claseSolicitud, TS.COD_TIPO_SOLI codigoTipoSolicitud  ");
        
        consulta.append(" FROM ");
        
        consulta.append(" PED_SOLIC_POSIC SOP, PED_SOLIC_CABEC SOC, ");
        consulta.append(" PED_SOLIC_CABEC SOC2, PED_CLASE_SOLIC CLAS, ");
        consulta.append(" MAE_PRODU PRO, SEG_SOCIE EMP, ");
        consulta.append(" PED_TIPO_SOLIC_PAIS TSP, PED_TIPO_SOLIC TS ");
        
        consulta.append(" WHERE ");
        
        consulta.append(" SOC2.CLSO_OID_CLAS_SOLI = CLAS.OID_CLAS_SOLI ");
        consulta.append(" AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        consulta.append(" AND SOC2.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        consulta.append(" AND SOC2.SOCI_OID_SOCI = EMP.OID_SOCI ");
        consulta.append(" AND SOP.PROD_OID_PROD = PRO.OID_PROD ");
        consulta.append(" AND SOP.SOCA_OID_SOLI_CABE = SOC.OID_SOLI_CABE ");
        consulta.append(" AND SOC.SOCA_OID_SOLI_CABE = SOC2.OID_SOLI_CABE ");
        consulta.append(" AND SOC2.PERD_OID_PERI = ? ");
        parametros.add(periodo);
        consulta.append(" AND SOC2.IND_INTE_LARI_GENE = 0 ");
        consulta.append(" AND SOC2.FEC_FACT IS NOT NULL ");
        consulta.append(" AND SOC2.IND_TS_NO_CONSO = 0 ");
        consulta.append(" AND (SOC2.IND_PEDI_PRUE = 0 OR SOC2.IND_PEDI_PRUE IS NULL)");
        consulta.append(" AND SOP.ESPO_OID_ESTA_POSI <> ? ");
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
        
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		ArrayList array = new ArrayList();
		DTOINTDocumento   dto = null;
		
		if(rs!=null){
			if(!rs.esVacio()){
				int n=rs.getRowCount();
				//array = new ArrayList(); se elimina y se define antes INC 16916 y 16738
				
				for(int i= 0;i<n;i++){
					dto = new DTOINTDocumento();
					
					dto.setCodigoEmpresa((String)rs.getValueAt(i,"CODIGOEMPRESA"));
					if(rs.getValueAt(i,"NUMEROPEDIDO") != null){
						dto.setNumeroPedido(((BigDecimal)rs.getValueAt(i,"NUMEROPEDIDO")).toString());
					}
					dto.setCodigoItem((String)rs.getValueAt(i,"CODIGOITEM"));
					if(rs.getValueAt(i,"UNIDADESPORATENDER") != null){
						dto.setUnidadesPorAtender((String)rs.getValueAt(i,"UNIDADESPORATENDER").toString());
					}
					if(rs.getValueAt(i,"INDICADORDENTROFUERACAJA") != null){
						dto.setIndicadorDentroFueraCaja((String)rs.getValueAt(i,"INDICADORDENTROFUERACAJA"));
					}
					dto.setClaseSolicitud((String)rs.getValueAt(i,"CLASESOLICITUD"));
					dto.setTipoSolicitud((String)rs.getValueAt(i,"CODIGOTIPOSOLICITUD"));
					
					array.add(dto);
				}
			}
		}
		
		UtilidadesLog.info("DAOINTLAR.obtenerDetallesDocumento(Long periodo): Salida");
		return array;
	}
	
	public ArrayList obtenerDatosImpresionGuias(Long periodo) throws MareException {
		UtilidadesLog.info("DAOINTLAR.obtenerDatosImpresionGuias(Long periodo): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		//MODIFICADO POR LA INCIDENCIA 19923
		
        consulta.append(" SELECT SOC.OID_SOLI_CABE OIDCABECERA, EMP.COD_SOCI CODIGOEMPRESA, ");
        consulta.append(" SOC.VAL_NUME_SOLI NUMEROPEDIDO,  ");
		consulta.append(" DOC.COD_TIPO_DOCU TIPOFORMULARIO, ");
        consulta.append(" TRIM(SUBSTR(DOCC.VAL_SERI_DOCU_LEGA, 1,5)) || TRIM(TO_CHAR(DOCC.NUM_DOCU_LEGA,'0000000000')) NUMEROFORMULARIO, ");
        consulta.append(" CLAS.COD_CLAS_SOLI CLASESSOLICITUD, ");
		consulta.append(" TS.COD_TIPO_SOLI TIPOSOLICITUD ");
		consulta.append(" FROM PED_SOLIC_CABEC SOC, SEG_SOCIE EMP,  ");
        consulta.append(" FAC_TIPO_DOCUM DOC, PED_CLASE_SOLIC CLAS,  ");
        consulta.append(" PED_TIPO_SOLIC_PAIS TSP, PED_TIPO_SOLIC TS, ");
        consulta.append(" FAC_DOCUM_CONTA_CABEC DOCC ");
        consulta.append(" WHERE SOC.SOCI_OID_SOCI = EMP.OID_SOCI(+) ");
        consulta.append(" AND DOCC.SOCA_OID_SOLI_CABE(+) = SOC.OID_SOLI_CABE ");
        consulta.append(" AND SOC.TIDO_OID_TIPO_DOCU = DOC.OID_TIPO_DOCU(+) ");
        consulta.append(" AND SOC.CLSO_OID_CLAS_SOLI = CLAS.OID_CLAS_SOLI(+) ");
        consulta.append(" AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS(+) ");
        consulta.append(" AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        consulta.append(" AND SOC.IND_TS_NO_CONSO = 0 "); //INC BELC300021120
        consulta.append(" AND (SOC.IND_PEDI_PRUE = 0 OR SOC.IND_PEDI_PRUE IS NULL)");
        consulta.append(" AND SOC.PERD_OID_PERI = ? ");
        parametros.add(periodo);
        consulta.append(" AND SOC.FEC_FACT IS NOT NULL ");
        consulta.append(" AND SOC.IND_INTE_LARI_GENE = 0 ");
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		ArrayList array = new ArrayList();
		DTOINTDatosImpresionGuias   dto = null;
		
		if(rs!=null){
			if(!rs.esVacio()){
				int n=rs.getRowCount();
				//array = new ArrayList(); se elimina y se define antes INC 16916 y 16738
				
				for(int i= 0;i<n;i++){
					dto = new DTOINTDatosImpresionGuias();
					
					dto.setOidCabecera(new Long(((BigDecimal)rs.getValueAt(i,"OIDCABECERA")).longValue()));
					dto.setCodigoEmpresa((String)rs.getValueAt(i,"CODIGOEMPRESA"));
					if(rs.getValueAt(i,"NUMEROPEDIDO") != null){
						dto.setNumeroPedido(((BigDecimal)rs.getValueAt(i,"NUMEROPEDIDO")).toString());
					}
					dto.setTipoFormulario((String)rs.getValueAt(i,"TIPOFORMULARIO"));
					if(rs.getValueAt(i,"NUMEROFORMULARIO") != null){
						dto.setNumeroFormulario((String)rs.getValueAt(i,"NUMEROFORMULARIO"));
					}
					dto.setClaseSolicitud((String)rs.getValueAt(i,"CLASESSOLICITUD"));
					dto.setTipoSolicitud((String)rs.getValueAt(i,"TIPOSOLICITUD"));
					
					array.add(dto);
				}
			}
		}
		
		UtilidadesLog.info("DAOINTLAR.obtenerDatosImpresionGuias(Long periodo): Salida");
		return array;
	}
		public ArrayList obtenerDatosImpresionGuias(DTOFACReasignarNumeroDocContable dtoE) throws MareException {
		UtilidadesLog.info("DAOINTLAR.obtenerDatosImpresionGuias(DTOFACReasignarNumeroDocContable dto): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		//MODIFICADO POR LA INCIDENCIA 19923
		
        consulta.append(" SELECT SOC.OID_SOLI_CABE OIDCABECERA,  ");
        consulta.append(" SOC.VAL_NUME_SOLI NUMEROPEDIDO,  ");
        consulta.append(" DOC.COD_TIPO_DOCU TIPOFORMULARIO, ");
        consulta.append(" TRIM(SUBSTR(DOCC.VAL_SERI_DOCU_LEGA, 1,5)) || TRIM(TO_CHAR(DOCC.NUM_DOCU_LEGA,'0000000000')) NUMEROFORMULARIO ");
        consulta.append(" FROM PED_SOLIC_CABEC SOC,  ");
        consulta.append(" FAC_TIPO_DOCUM DOC,  ");        
        consulta.append(" FAC_DOCUM_CONTA_CABEC DOCC ");
        consulta.append(" WHERE DOCC.SOCA_OID_SOLI_CABE = SOC.OID_SOLI_CABE ");
//        consulta.append(" AND SOC.TIDO_OID_TIPO_DOCU = DOC.OID_TIPO_DOCU(+) ");
        consulta.append(" AND DOC.OID_TIPO_DOCU = DOCC.TIDO_OID_TIPO_DOCU ");
        consulta.append(" AND SOC.IND_TS_NO_CONSO = 0 "); //INC BELC300021120
        consulta.append(" AND (SOC.IND_PEDI_PRUE = 0 OR SOC.IND_PEDI_PRUE IS NULL)");
        consulta.append(" AND SOC.FEC_FACT IS NOT NULL ");
      // consulta.append(" AND SOC.IND_INTE_LARI_GENE = 0 ");
        consulta.append(" AND DOC.COD_TIPO_DOCU IN ('001','002','003','011','012') ");
        consulta.append(" AND DOCC.SBAC_OID_SBAC = " + dtoE.getOidSubAcceso());      
        consulta.append("AND DOCC.TIDO_OID_TIPO_DOCU = " + dtoE.getOidTipoDocContable());
        consulta.append("AND DOCC.VAL_EJER_DOCU_INTE = " + dtoE.getEjercicio());
        consulta.append("AND DOCC.NUM_DOCU_CONT_INTE BETWEEN " + dtoE.getRangoDocInternoDesde() + " AND " + dtoE.getRangoDocInternoHasta());	
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		ArrayList array = new ArrayList();
		DTOINTDatosImpresionGuias   dto = null;
		
		if(rs!=null){
			if(!rs.esVacio()){
				int n=rs.getRowCount();
				//array = new ArrayList(); se elimina y se define antes INC 16916 y 16738
				
				for(int i= 0;i<n;i++){
					dto = new DTOINTDatosImpresionGuias();
					
					dto.setOidCabecera(new Long(((BigDecimal)rs.getValueAt(i,"OIDCABECERA")).longValue()));
					if(rs.getValueAt(i,"NUMEROPEDIDO") != null){
						dto.setNumeroPedido(((BigDecimal)rs.getValueAt(i,"NUMEROPEDIDO")).toString());
					}
					dto.setTipoFormulario((String)rs.getValueAt(i,"TIPOFORMULARIO"));
					if(rs.getValueAt(i,"NUMEROFORMULARIO") != null){
						dto.setNumeroFormulario((String)rs.getValueAt(i,"NUMEROFORMULARIO"));
					}
					array.add(dto);
				}
			}
		}
		
		UtilidadesLog.info("DAOINTLAR.obtenerDatosImpresionGuias(DTOFACReasignarNumeroDocContable dto): Salida");
		return array;
	}
	public ArrayList obtenerProductosVentaReal(DTOINTCargaInicialLarissa dtoL ) throws MareException {
		UtilidadesLog.info("DAOINTLAR.obtenerProductosVentaReal(Long periodo): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		//MODIFICADO POR LA INCIDENCIA 19985
        /*mdolce 10/10/2006 Se agrega els elect * para que no devuelva los  
         * tienen total unidades = 0
         * */
        consulta.append(" SELECT * FROM( ");
        consulta.append(" SELECT PRO.OID_PROD PRODUCTO, PRO.COD_SAP CODIGOSAP, ");
        
        // gPineda - 15/03/2007 - SiCC 20070119
        //consulta.append(" PRO.DES_CORT DESCRIPCIONSAP, MARC.COD_MARC_PROD CODIGOMARCA, ");
        consulta.append("      (SELECT GEN.VAL_I18N ");
        consulta.append("         FROM GEN_I18N_SICC_PAIS GEN ");
        consulta.append("        WHERE GEN.ATTR_ENTI = 'MAE_PRODU' AND GEN.ATTR_NUM_ATRI = 1 AND GEN.VAL_OID = PRO.OID_PROD ");
        consulta.append("          AND GEN.IDIO_OID_IDIO = "+ dtoL.getOidIdioma() +" ) DESCRIPCIONSAP, MARC.COD_MARC_PROD CODIGOMARCA, ");
        
        consulta.append(" UNEG.COD_UNID_NEGO CODIGOUNIDADNEGOCIO, NEGO.COD_NEGO CODIGONEGOCIO, ");
        consulta.append(" ESTA.COD_ESTA_PROD ESTATUSPRODUCTO, ");
        consulta.append(" SUM(POS.NUM_UNID_ATEN) TOTALUNIDADES, DECODE(PRO.COD_IND_DENT_CAJA, NULL, 0, 1) INDICADORDENTROFUERACAJABOLSA, ");
        consulta.append(" VAL_DIME_LARG LARGOCENTIMETROS, ");
        consulta.append(" VAL_DIME_ANCH ANCHOCENTIMETROS, ");
        consulta.append(" VAL_DIME_ALTO ALTOCENTIMETROS, ");
        consulta.append(" VAL_PESO PESOBRUTOGRAMOS ");        
        consulta.append(" FROM ");
        consulta.append(" PED_SOLIC_CABEC CAB, PED_SOLIC_CABEC CONS, ");
        consulta.append(" PED_SOLIC_POSIC POS, ");
        consulta.append(" MAE_PRODU PRO, SEG_MARCA_PRODU MARC, ");
        consulta.append(" MAE_UNIDA_NEGOC UNEG, MAE_NEGOC NEGO,  ");
        consulta.append(" MAE_ESTAT_PRODU ESTA, PED_TIPO_SOLIC_PAIS TSP, ");
        consulta.append(" PED_TIPO_SOLIC TS, ");
        //MODIFICADO INCIDENCIA BELC300024162 pzerbino 18/09/2006
        consulta.append(" INT_LAR_TIPO_SOLICI_PEDIDO_DIS TSPD ");
        
        consulta.append(" WHERE ");
        consulta.append(" POS.SOCA_OID_SOLI_CABE = CAB.OID_SOLI_CABE ");
        consulta.append(" AND CAB.SOCA_OID_SOLI_CABE = CONS.OID_SOLI_CABE ");
        consulta.append(" AND POS.PROD_OID_PROD = PRO.OID_PROD ");
        consulta.append(" AND PRO.MAPR_OID_MARC_PROD = MARC.OID_MARC_PROD ");
        consulta.append(" AND PRO.UNEG_OID_UNID_NEGO = UNEG.OID_UNID_NEGO(+) ");
        consulta.append(" AND PRO.NEGO_OID_NEGO = NEGO.OID_NEGO(+) ");
        consulta.append(" AND PRO.MEUD_OID_ESTA_PROD = ESTA.OID_ESTA_PROD(+) ");
        consulta.append(" AND CAB.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        consulta.append(" AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI");
        consulta.append(" AND CONS.PERD_OID_PERI = ? ");
        parametros.add( dtoL.getPeriodo() );
        consulta.append(" AND CONS.IND_INTE_LARI_GENE = 0 ");
        consulta.append(" AND CONS.FEC_FACT IS NOT NULL ");
        consulta.append(" AND CONS.IND_TS_NO_CONSO = 0 ");
        consulta.append(" AND (CONS.IND_PEDI_PRUE = 0 OR CONS.IND_PEDI_PRUE IS NULL)");
        //MODIFICADO INCIDENCIA BELC300024162 pzerbino 18/09/2006
        consulta.append(" AND CONS.TSPA_OID_TIPO_SOLI_PAIS = TSPD.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append(" AND CONS.PAIS_OID_PAIS = ? ");
        parametros.add( dtoL.getOidPais() );
        
        // gPineda - 13/03/2007 - SiCC 20070112
        consulta.append(" AND POS.ESPO_OID_ESTA_POSI <> ? ");
        parametros.add( ConstantesPED.ESTADO_POSICION_ANULADO );
        
        consulta.append(" GROUP BY");
        consulta.append(" PRO.OID_PROD, PRO.COD_SAP, PRO.DES_CORT, ");
        consulta.append(" MARC.COD_MARC_PROD, UNEG.COD_UNID_NEGO, ");
        consulta.append(" NEGO.COD_NEGO, ESTA.COD_ESTA_PROD, ");
        consulta.append(" PRO.COD_IND_DENT_CAJA, VAL_DIME_LARG, VAL_DIME_ANCH, ");
        consulta.append(" VAL_DIME_ALTO, VAL_PESO ");
        consulta.append(" ) where TOTALUNIDADES > 0");
        		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		ArrayList array =  new ArrayList();
		DTOINTProductoVentaReal   dto = null;
		
		if(rs!=null){
			if(!rs.esVacio()){
				int n=rs.getRowCount();
				//array = new ArrayList(); //se elimina y se define antes INC 16916	y 16738
				for(int i= 0;i<n;i++){
					dto = new DTOINTProductoVentaReal();
					
					dto.setOid(new Long(((BigDecimal)rs.getValueAt(i,"PRODUCTO")).longValue()));
					dto.setCodigoSAP((String)rs.getValueAt(i,"CODIGOSAP"));
					dto.setCodigoMarca((String)rs.getValueAt(i,"CODIGOMARCA"));
					if(rs.getValueAt(i,"DESCRIPCIONSAP") != null){
						dto.setDescripcionSAP((String)rs.getValueAt(i,"DESCRIPCIONSAP"));
					}
					dto.setCodigoUnidadNegocio((String)rs.getValueAt(i,"CODIGOUNIDADNEGOCIO"));
					dto.setCodigoNegocio((String)rs.getValueAt(i,"CODIGONEGOCIO"));
					dto.setEstatusProducto((String)rs.getValueAt(i,"ESTATUSPRODUCTO"));
					if(rs.getValueAt(i,"TOTALUNIDADES") != null){
						dto.setTotalUnidades(new Integer(((BigDecimal)rs.getValueAt(i,"TOTALUNIDADES")).toString()));
					}
					if(rs.getValueAt(i,"INDICADORDENTROFUERACAJABOLSA") != null){
						dto.setIndicadorDentroFueraCajaBolsa(((BigDecimal)rs.getValueAt(i,"INDICADORDENTROFUERACAJABOLSA")).toString());
					}
					if(rs.getValueAt(i,"LARGOCENTIMETROS") != null){
						dto.setLargoCentimetros(new Integer(((BigDecimal)rs.getValueAt(i,"LARGOCENTIMETROS")).toString()));
					}
					if(rs.getValueAt(i,"ANCHOCENTIMETROS") != null){
						dto.setAnchoCentimetros(new Integer(((BigDecimal)rs.getValueAt(i,"ANCHOCENTIMETROS")).toString()));
					}
					if(rs.getValueAt(i,"ALTOCENTIMETROS") != null){
						dto.setAltoCentimetros(new Integer(((BigDecimal)rs.getValueAt(i,"ALTOCENTIMETROS")).toString()));
					}
					if(rs.getValueAt(i,"PESOBRUTOGRAMOS") != null){
						dto.setPesoBrutoGramos(new Integer(((BigDecimal)rs.getValueAt(i,"PESOBRUTOGRAMOS")).toString()));
					}
                
					array.add(dto);
				}
			}
		}
		
		UtilidadesLog.info("DAOINTLAR.obtenerProductosVentaReal(Long periodo): Salida");
		return array;
	}
	
	public ArrayList obtenerCabeceraDocumento(Long periodo) throws MareException{
		UtilidadesLog.info("DAOINTLAR.obtenerCabeceraDocumento(Long periodo): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		
        //MODIFICADO POR INCIDENCIA 19925        
        consulta.append(" SELECT EMP.COD_SOCI CODIGOEMPRESA, SOC2.VAL_NUME_SOLI NUMEROPEDIDO, ");
        consulta.append(" CLI.COD_CLIE CODIGOCLIENTE, SOC.FEC_CRON FECHAPEDIDO, ");
        consulta.append(" REV.COD_INDI_REVI INDICADORPEDIDOACHEQUEAR, ");
        consulta.append(" COUNT(SOP.OID_SOLI_POSI) TOTALITEMSPEDIDO, ");
        consulta.append(" SUM(SOP.NUM_UNID_DEMA) TOTALUNIDADESPEDIDO, ");
        consulta.append(" DECODE (TD.COD_TIPO_DESP,'EX',1,0) INDICADORPEDIDOEXPRESS, ");
        consulta.append(" CLAS.COD_CLAS_SOLI CLASESOLICITUD, TS.COD_TIPO_SOLI CODIGOTIPOSOLICITUD ");
        consulta.append(" FROM PED_SOLIC_POSIC SOP, PED_SOLIC_CABEC SOC, ");
        consulta.append(" PED_SOLIC_CABEC SOC2, MAE_CLIEN CLI, ");
        consulta.append(" PED_INDIC_REVIS REV, PED_CLASE_SOLIC CLAS, ");
        consulta.append(" PED_TIPO_DESPA TD, SEG_SOCIE EMP, ");
        consulta.append(" PED_TIPO_SOLIC_PAIS TSP, PED_TIPO_SOLIC TS ");
        consulta.append(" WHERE ");
        consulta.append(" SOC2.CLSO_OID_CLAS_SOLI = CLAS.OID_CLAS_SOLI ");
        consulta.append(" AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        consulta.append(" AND SOC2.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        consulta.append(" AND SOC2.SOCI_OID_SOCI = EMP.OID_SOCI ");
        consulta.append(" AND TD.OID_TIPO_DESP=soc.TIDS_OID_TIPO_DESP ");
        consulta.append(" AND SOC.INRE_OID_INDI_REVI = REV.OID_INDI_REVI (+) ");
        consulta.append(" AND SOC.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND SOP.SOCA_OID_SOLI_CABE = SOC.OID_SOLI_CABE ");
        consulta.append(" AND SOC.SOCA_OID_SOLI_CABE = SOC2.OID_SOLI_CABE ");
        consulta.append(" AND SOC2.PERD_OID_PERI = ? "); //codigoPeriodo
        parametros.add(periodo);
        consulta.append(" AND SOC2.IND_INTE_LARI_GENE = 0 ");
        consulta.append(" AND SOC2.FEC_FACT IS NOT NULL ");
        consulta.append(" AND SOC2.IND_TS_NO_CONSO = 0 ");
        consulta.append(" AND (SOC2.IND_PEDI_PRUE = 0 OR SOC2.IND_PEDI_PRUE IS NULL)");
        consulta.append(" AND SOP.ESPO_OID_ESTA_POSI <> ? "); //ConstantesPED.ESTADO_POSICION_ANULADO
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
        consulta.append(" GROUP BY ");
        consulta.append(" EMP.COD_SOCI, SOC2.VAL_NUME_SOLI, CLI.COD_CLIE, SOC.FEC_CRON,  ");
        consulta.append(" REV.COD_INDI_REVI, DECODE (TD.COD_TIPO_DESP,'EX',1,0),  ");
        consulta.append(" CLAS.COD_CLAS_SOLI, TS.COD_TIPO_SOLI ");
        
        
        
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		ArrayList array = new ArrayList();
		DTOINTDocumento   dto = null;
		
		if(rs!=null){
			if(!rs.esVacio()){
				int n=rs.getRowCount();
				//array = new ArrayList(); se elimina y se define antes INC 16916 y 16738
				
				for(int i= 0;i<n;i++){
					dto = new DTOINTDocumento();
					
                    dto.setCodigoEmpresa((String)rs.getValueAt(i,"CODIGOEMPRESA"));
                    if(rs.getValueAt(i,"NUMEROPEDIDO") != null){
						dto.setNumeroPedido(((BigDecimal)rs.getValueAt(i,"NUMEROPEDIDO")).toString());
					}
                    dto.setCodigoCliente((String)rs.getValueAt(i,"CODIGOCLIENTE"));
                    dto.setFechaPedido(new java.util.Date(((Date)rs.getValueAt(i,"FECHAPEDIDO")).getTime()));
                    dto.setIndicadorPedidoAChequear((String)rs.getValueAt(i,"INDICADORPEDIDOACHEQUEAR"));
                    if (rs.getValueAt(i,"TOTALITEMSPEDIDO") != null)
                    {
                        dto.setTotalItemsPedido(new Integer(((BigDecimal)rs.getValueAt(i,"TOTALITEMSPEDIDO")).intValue()));
                    }
                    if(rs.getValueAt(i,"TOTALUNIDADESPEDIDO") != null){
						dto.setTotalUnidadesPedido(new Integer(((BigDecimal)rs.getValueAt(i,"TOTALUNIDADESPEDIDO")).intValue()));
					}
                    if (rs.getValueAt(i,"INDICADORPEDIDOEXPRESS")!= null)
                    {
                        dto.setIndicadorPedidoExpress((String)rs.getValueAt(i,"INDICADORPEDIDOEXPRESS").toString());
                    }
                    
                    
                    dto.setClaseSolicitud((String)rs.getValueAt(i,"CLASESOLICITUD"));
                    dto.setTipoSolicitud((String)rs.getValueAt(i,"CODIGOTIPOSOLICITUD"));
					
					array.add(dto);
				}
			}
		}
		
		UtilidadesLog.info("DAOINTLAR.obtenerCabeceraDocumento(Long periodo): Salida");
		return array;
	}
	
	public void actualizarCabecerasDocumento (ArrayList listaOIDs) throws MareException {
		UtilidadesLog.info("DAOINTLAR.actualizarCabecerasDocumento(ArrayList listaOIDs): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

		consulta.append("UPDATE PED_SOLIC_CABEC ");
		consulta.append("SET IND_INTE_LARI_GENE = 1 ");
    consulta.append("WHERE OID_SOLI_CABE IN (");
		
    /* cdos gPineda 28/06/2006 - DBLG500000727
     * No se permite más de 1000 parametros dentro del IN()
     */
		String oids = this.convertirArrayToString(listaOIDs);
		StringTokenizer stk = new StringTokenizer( oids, "," );
    if( stk.countTokens() > 1000 ){
      for( int iToken = 1; stk.hasMoreTokens(); iToken++ ){
        consulta.append( stk.nextToken() + "," );
        if( iToken == 1000 ){
          iToken = 1;
          consulta.deleteCharAt( consulta.lastIndexOf(",") );
          consulta.append(") OR OID_SOLI_CABE IN (");
        }
      }
      consulta.deleteCharAt( consulta.lastIndexOf(",") );
    }else{
      consulta.append( oids );
    }
    consulta.append( ") " );
    // FIN - DBLG500000727
		
		for(int i=0;i< listaOIDs.size();i++){
			if(listaOIDs.get(i)!=null){
				//si es distinto de null lo pasamos a vector de la select.
				parametros.add(listaOIDs.get(i));
			}
		}
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        try{
           bs.dbService.executePreparedUpdate(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		
		UtilidadesLog.info("DAOINTLAR.actualizarCabecerasDocumento(ArrayList listaOIDs): Salida");
	}

    public DTOColeccion obtenerInterfacesParametrizadas  (Long idioma) throws MareException {
        UtilidadesLog.info("DAOINTLAR.obtenerInterfacesParametrizadas(Long idioma): Entrada");
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
			
        consulta.append("SELECT v.VAL_I18N ");
        consulta.append("FROM V_GEN_I18N_SICC v, int_laris_param i ");
        consulta.append("WHERE v.VAL_OID= i.oid_lari_para ");
        consulta.append("AND v.IDIO_OID_IDIO = ? ");
        parametros.add(idioma);
        consulta.append("AND v.ATTR_NUM_ATRI = 1 ");
        consulta.append("AND v.ATTR_ENTI = 'INT_LARIS_PARAM' ");

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerPeriodos: Exception",e);
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
        
        ArrayList array = new ArrayList();
		DTOColeccion dto = new DTOColeccion();
		if(rs!=null){
			if(!rs.esVacio()){
				int n=rs.getRowCount();  
				for(int i= 0;i<n;i++){                
                    array.add((String)rs.getValueAt(i,0));
                }
                dto.setLista(array);
            }
        }
        UtilidadesLog.info("DAOINTLAR.obtenerInterfacesParametrizadas(Long idioma): Salida");
        return dto;
    }    
	 
     
     
    /**
     * Creado por incidencia 21887
     * @author dmorello
     * @date   07/06/2006
     */
    public ArrayList obtenerDocumento(Long periodo, Long pais) throws MareException {
    
        UtilidadesLog.info("DAOINTLAR.obtenerDocumento(Long periodo): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;
            
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e,error);
        }

        query.append(" SELECT ");
        //MODIFICADO BELC300024162  pzerbino 18/9/2006
        query.append("     SOC2.OID_SOLI_CABE OIDCABECERA, ");
        
        query.append("     emp.cod_soci codigoempresa, soc2.val_nume_soli numeropedido, ");
        query.append("     cli.cod_clie codigocliente, soc.fec_cron fechapedido, ");
        query.append("     rev.cod_indi_revi indicadorpedidoachequear, ");
        query.append("     sop.num_unid_dema totalunidadespedido, ");
        query.append("     DECODE (td.cod_tipo_desp, 'EX', 1, 0) indicadorpedidoexpress, ");
        query.append("     pro.cod_sap codigoitem, sop.num_unid_aten unidadesporatender, ");
        query.append("     pro.cod_ind_dent_caja indicadordentrofueracaja, ");
        query.append("     clas.cod_clas_soli clasesolicitud, ");
        query.append("     ts.cod_tipo_soli codigotiposolicitud ");
        query.append(" FROM ");
        query.append("     ped_solic_posic sop, ");
        query.append("     ped_solic_cabec soc, ");
        query.append("     ped_solic_cabec soc2, ");
        query.append("     mae_clien cli, ");
        query.append("     ped_indic_revis rev, ");
        query.append("     ped_clase_solic clas, ");
        query.append("     ped_tipo_despa td, ");
        query.append("     seg_socie emp, ");
        query.append("     ped_tipo_solic_pais tsp, ");
        query.append("     mae_produ pro, ");
        query.append("     ped_tipo_solic ts, ");
        //MODIFCICADO BELC300024162 pzerbino 18/9/2006
        query.append("     INT_LAR_TIPO_SOLICI_PEDIDO_DIS TSPD ");
        
        query.append(" WHERE soc2.clso_oid_clas_soli = clas.oid_clas_soli ");
        query.append("   AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli ");
        query.append("   AND soc2.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        query.append("   AND soc2.soci_oid_soci = emp.oid_soci ");
        query.append("   AND td.oid_tipo_desp = soc.tids_oid_tipo_desp ");
        query.append("   AND soc.inre_oid_indi_revi = rev.oid_indi_revi(+) ");
        query.append("   AND soc.clie_oid_clie = cli.oid_clie ");
        query.append("   AND sop.soca_oid_soli_cabe = soc.oid_soli_cabe ");
        query.append("   AND soc.soca_oid_soli_cabe = soc2.oid_soli_cabe ");
        query.append("   AND soc2.perd_oid_peri = " + periodo);
        query.append("   AND soc2.ind_inte_lari_gene = 0 ");
        query.append("   AND soc2.fec_fact IS NOT NULL ");
        query.append("   AND soc2.ind_ts_no_conso = 0 ");
        // query.append("   AND soc2.ind_pedi_prue = 0 ");
        query.append(" AND (SOC2.IND_PEDI_PRUE = 0 OR SOC2.IND_PEDI_PRUE IS NULL)");
        query.append("   AND sop.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
        query.append("   AND sop.prod_oid_prod = pro.oid_prod ");
        //MODIFCICADO BELC300024162 pzerbino 18/9/2006
        query.append("   AND SOC2.TSPA_OID_TIPO_SOLI_PAIS = TSPD.TSPA_OID_TIPO_SOLI_PAIS ");
        query.append("    AND SOC2.PAIS_OID_PAIS = " + pais);             
        query.append(" ORDER BY soc2.val_nume_soli ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e,error);
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        ArrayList list = new ArrayList();
        
        int size = rs.getRowCount();
        for (int i = 0; i < size; i++) {
            DTOINTDocumento dto = new DTOINTDocumento();
            
            dto.setCodigoEmpresa((String)rs.getValueAt(i,"CODIGOEMPRESA"));
            
            Object numPed = rs.getValueAt(i,"NUMEROPEDIDO");
            dto.setNumeroPedido((numPed != null)? numPed.toString() : null);
            
            dto.setCodigoCliente((String)rs.getValueAt(i,"CODIGOCLIENTE"));
            
            java.util.Date fechaPed = (Date)rs.getValueAt(i,"FECHAPEDIDO");
            dto.setFechaPedido((fechaPed != null)? new java.util.Date(fechaPed.getTime()) : null);
            
            dto.setIndicadorPedidoAChequear((String)rs.getValueAt(i,"INDICADORPEDIDOACHEQUEAR"));
            
            BigDecimal totalUniPed = (BigDecimal)rs.getValueAt(i,"TOTALUNIDADESPEDIDO");
            Integer totUni = (totalUniPed != null)? new Integer(totalUniPed.intValue()) : null;
            dto.setTotalUnidadesPedido(totUni);
            
            Object indPedExp = rs.getValueAt(i,"INDICADORPEDIDOEXPRESS");
            dto.setIndicadorPedidoExpress(indPedExp != null? indPedExp.toString() : null);
            
            dto.setCodigoItem((String)rs.getValueAt(i,"CODIGOITEM"));
                        
            Object unidPorAt = rs.getValueAt(i,"UNIDADESPORATENDER");
            dto.setUnidadesPorAtender((unidPorAt != null)? unidPorAt.toString() : null);
            
            dto.setIndicadorDentroFueraCaja((String)rs.getValueAt(i,"INDICADORDENTROFUERACAJA"));
            
            dto.setClaseSolicitud((String)rs.getValueAt(i,"CLASESOLICITUD"));
            
            dto.setTipoSolicitud((String)rs.getValueAt(i,"CODIGOTIPOSOLICITUD"));
            
            list.add(dto);
        }
        
        
                
        UtilidadesLog.info("DAOINTLAR.obtenerDocumento(Long periodo): Salida");
        return list;
    }
     
     private  String convertirArrayToString(ArrayList array){
        UtilidadesLog.info("DAOINTLAR.convertirArrayToString(ArrayList array): Entrada");
		String retorno = "";
		if((array!=null)&&(array.size()!=0)){
			
			StringBuffer sentencia = new StringBuffer("");
			for(int i=0;i<array.size();i++){
            	UtilidadesLog.debug("\n array[ ]=" + array.get(i));
            	if(array.get(i)!=null){
					sentencia.append(" ?, ");
                }
           	}
            //Quitamos la coma y el espacio del final
			if (sentencia.length() > 0)
				retorno= sentencia.substring(0,sentencia.length()-2);
				 
		}else{
            UtilidadesLog.info("DAOINTLAR.convertirArrayToString(ArrayList array): Salida");
			return "";
		}
		UtilidadesLog.info("DAOINTLAR.convertirArrayToString(ArrayList array): Salida");
		return retorno;
	}

       private void logSql(String metodo, String sql, Vector params){
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
	}
        public ArrayList obtieneCabeceras(Long periodo) throws MareException
    {
      		UtilidadesLog.info("DAOINTLAR.obtieneCabecera(Long periodo): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

		
        consulta.append(" SELECT SOC.OID_SOLI_CABE OIDCABECERA ");
		consulta.append(" FROM PED_SOLIC_CABEC SOC, SEG_SOCIE EMP,  ");
        consulta.append(" FAC_TIPO_DOCUM DOC, PED_CLASE_SOLIC CLAS,  ");
        consulta.append(" PED_TIPO_SOLIC_PAIS TSP, PED_TIPO_SOLIC TS, ");
        consulta.append(" FAC_DOCUM_CONTA_CABEC DOCC ");
        consulta.append(" WHERE SOC.SOCI_OID_SOCI = EMP.OID_SOCI(+) ");
        consulta.append(" AND DOCC.SOCA_OID_SOLI_CABE(+) = SOC.OID_SOLI_CABE ");
        consulta.append(" AND SOC.TIDO_OID_TIPO_DOCU = DOC.OID_TIPO_DOCU(+) ");
        consulta.append(" AND SOC.CLSO_OID_CLAS_SOLI = CLAS.OID_CLAS_SOLI(+) ");
        consulta.append(" AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS(+) ");
        consulta.append(" AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        consulta.append(" AND SOC.IND_TS_NO_CONSO = 0 "); 
        consulta.append(" AND (SOC.IND_PEDI_PRUE = 0 OR SOC.IND_PEDI_PRUE IS NULL)");
        consulta.append(" AND SOC.PERD_OID_PERI = ? ");
        parametros.add(periodo);
        consulta.append(" AND SOC.IND_INTE_LARI_GENE = 0 ");
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql(" obtenerPeriodos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		ArrayList array = new ArrayList();
			
		if(rs!=null){
			if(!rs.esVacio()){
				int n=rs.getRowCount();
					for(int i= 0;i<n;i++){
               			array.add(new Long(((BigDecimal)rs.getValueAt(i,"OIDCABECERA")).longValue()));
                    }
            }
		}
        UtilidadesLog.info("DAOINTLAR.obtieneCabecera(Long periodo): Salida");
        return array;
    }
    
    /**
     * Indica si un oid de cliente está presente en el array.
     */
    private boolean esVip(long oid, long oids[]) {
        int cantVips = oids.length;
        for (int i = 0; i < cantVips; i++) {
            if (oid == oids[i]) {
                return true;
            }
        }
        return false;
    }

    //Agregado por Sapaza, fecha 29-04-2008, Nueva Interface LAR-9
    public ArrayList obtenerSecuenciaPedidos (Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOINTLAR.obtenerSecuenciaPedidos(): Entrada");
        StringBuffer consulta = new StringBuffer();

      /*  consulta.append(" SELECT ZON_ZONA.COD_ZONA as codigozona, ");
        consulta.append(" 		 PED_SOLIC_CABEC_SECUE.NUM_SECU_ZONA_RUTA as ruta, ");
        consulta.append("        ZON_TERRI.COD_TERR as codigoterritorio, ");
        consulta.append("        PED_SOLIC_CABEC.VAL_NUME_SOLI as numeropedido, ");
        consulta.append("        PED_SOLIC_CABEC_SECUE.NUM_SECU_FACT_DIAR as secuenciaterritorio, ");
        consulta.append("        LAR_FN_IND_SERV_RECL(PED_SOLIC_CABEC.OID_SOLI_CABE, '" + codigoPeriodo + "') as indicadorpedidoservicio ");
        consulta.append("   FROM PED_SOLIC_CABEC, ");
        consulta.append("        PED_SOLIC_CABEC_SECUE, ");
        consulta.append("        ZON_ZONA, ");
        consulta.append("        ZON_TERRI, ");
        consulta.append("        CRA_PERIO, ");
        consulta.append("        SEG_PERIO_CORPO, ");
        consulta.append("        INT_LAR_TIPO_SOLICI_PEDIDO_DIS ");
        consulta.append("  WHERE (  (PED_SOLIC_CABEC.OID_SOLI_CABE = PED_SOLIC_CABEC_SECUE.SOCA_OID_SOLI_CABE) ");
        consulta.append("    AND (ZON_ZONA.OID_ZONA = PED_SOLIC_CABEC.ZZON_OID_ZONA) ");
        consulta.append("    AND (ZON_TERRI.OID_TERR = PED_SOLIC_CABEC.TERR_OID_TERR) ");
        consulta.append("    AND (CRA_PERIO.OID_PERI = PED_SOLIC_CABEC.PERD_OID_PERI) ");
        consulta.append("    AND (SEG_PERIO_CORPO.OID_PERI = CRA_PERIO.PERI_OID_PERI) ");
        consulta.append("    AND (PED_SOLIC_CABEC.TSPA_OID_TIPO_SOLI_PAIS = INT_LAR_TIPO_SOLICI_PEDIDO_DIS.TSPA_OID_TIPO_SOLI_PAIS) ");
        consulta.append("    AND (PED_SOLIC_CABEC.IND_INTE_LARI_GENE = 0) ");
        consulta.append("    AND (PED_SOLIC_CABEC.NUM_UNID_ATEN_TOTA > 0) ");
        consulta.append("    AND (SEG_PERIO_CORPO.COD_PERI = '" + codigoPeriodo + "') ");
        consulta.append("    AND (PED_SOLIC_CABEC.FEC_FACT IS NOT NULL) ");
        consulta.append("    AND NOT EXISTS ( ");
        consulta.append("        SELECT M.SBTI_OID_SUBT_CLIE ");
        consulta.append("        FROM MAV_PARAM_GEREN_ZONA M, ");
        consulta.append("             ZON_ZONA Z ");
        consulta.append("        WHERE (PED_SOLIC_CABEC.SBTI_OID_SUBT_CLIE = M.SBTI_OID_SUBT_CLIE) ");
        consulta.append("          AND (PED_SOLIC_CABEC.CLIE_OID_CLIE = Z.CLIE_OID_CLIE))) ");
        consulta.append("    UNION ALL ");
        consulta.append("    SELECT ZON_ZONA.COD_ZONA, ");
        consulta.append("           PED_SOLIC_CABEC_SECUE.NUM_SECU_ZONA_RUTA, ");
        consulta.append("           0 COD_TERR, ");
        consulta.append("           PED_SOLIC_CABEC.VAL_NUME_SOLI, ");
        consulta.append("           PED_SOLIC_CABEC_SECUE.NUM_SECU_FACT_DIAR, ");
        consulta.append("           LAR_FN_IND_SERV_RECL(PED_SOLIC_CABEC.OID_SOLI_CABE, '" + codigoPeriodo + "') IND_SERV_RECL ");
        consulta.append("      FROM PED_SOLIC_CABEC, ");
        consulta.append("           PED_SOLIC_CABEC_SECUE, ");
        consulta.append("           ZON_ZONA, ");
        consulta.append("           CRA_PERIO, ");
        consulta.append("           SEG_PERIO_CORPO, ");
        consulta.append("           INT_LAR_TIPO_SOLICI_PEDIDO_DIS ");
        consulta.append("     WHERE (  (PED_SOLIC_CABEC.OID_SOLI_CABE = PED_SOLIC_CABEC_SECUE.SOCA_OID_SOLI_CABE) ");
        consulta.append("      AND (PED_SOLIC_CABEC.CLIE_OID_CLIE = ZON_ZONA.CLIE_OID_CLIE) ");
        consulta.append("      AND (CRA_PERIO.OID_PERI = PED_SOLIC_CABEC.PERD_OID_PERI) ");
        consulta.append("      AND (SEG_PERIO_CORPO.OID_PERI = CRA_PERIO.PERI_OID_PERI) ");
        consulta.append("      AND (PED_SOLIC_CABEC.TSPA_OID_TIPO_SOLI_PAIS = INT_LAR_TIPO_SOLICI_PEDIDO_DIS.TSPA_OID_TIPO_SOLI_PAIS) ");
        consulta.append("      AND (PED_SOLIC_CABEC.IND_INTE_LARI_GENE = 0) ");
        consulta.append("      AND (PED_SOLIC_CABEC.NUM_UNID_ATEN_TOTA > 0) ");
        consulta.append("      AND (SEG_PERIO_CORPO.COD_PERI = '" + codigoPeriodo + "') ");
        consulta.append("      AND (PED_SOLIC_CABEC.FEC_FACT IS NOT NULL) ");
        consulta.append("      AND (ZON_ZONA.IND_ACTI = 1) ");
        consulta.append("      AND EXISTS ( ");
        consulta.append("          SELECT M.SBTI_OID_SUBT_CLIE ");
        consulta.append("            FROM MAV_PARAM_GEREN_ZONA M, ");
        consulta.append("                 ZON_ZONA Z ");
        consulta.append("           WHERE (PED_SOLIC_CABEC.SBTI_OID_SUBT_CLIE = M.SBTI_OID_SUBT_CLIE) ");
        consulta.append("             AND (PED_SOLIC_CABEC.CLIE_OID_CLIE = Z.CLIE_OID_CLIE))) ");
        consulta.append(" ORDER BY 2, 5 ");*/
        
        
        // query nueva
        
        consulta.append(" SELECT   zon_zona.cod_zona CODIGOZONA , ped_solic_cabec_secue.num_secu_zona_ruta RUTA, ");
        consulta.append("          zon_terri.cod_terr CODIGOTERRITORIO, ped_solic_cabec.val_nume_soli NUMEROPEDIDO, ");
        consulta.append("          ped_solic_cabec_secue.num_secu_fact_diar SECUENCIATERRITORIO, ");
        consulta.append("          lar_fn_ind_serv_recl(ped_solic_cabec.oid_soli_cabe,"+oidPeriodo);
        consulta.append(" 		 ) INDICADORPEDIDOSERVICIO ");
        consulta.append("     FROM ped_solic_cabec, ");
        consulta.append("          ped_solic_cabec_secue, ");
        consulta.append("          zon_zona, ");
        consulta.append("          zon_terri, ");
        consulta.append("          int_lar_tipo_solici_pedido_dis ");
         
        consulta.append("    WHERE     ped_solic_cabec.oid_soli_cabe = ped_solic_cabec_secue.soca_oid_soli_cabe ");
        consulta.append("           AND zon_zona.oid_zona = ped_solic_cabec.zzon_oid_zona ");
        consulta.append("           AND zon_terri.oid_terr = ped_solic_cabec.terr_oid_terr ");
        consulta.append("           AND ped_solic_cabec.perd_oid_peri = "+oidPeriodo );
        consulta.append("           AND ped_solic_cabec.tspa_oid_tipo_soli_pais = int_lar_tipo_solici_pedido_dis.tspa_oid_tipo_soli_pais ");
              
        consulta.append("           AND ped_solic_cabec.ind_inte_lari_gene = 0 ");
        consulta.append("           AND ped_solic_cabec.num_unid_aten_tota > 0 ");
        consulta.append("           AND ped_solic_cabec.fec_fact IS NOT NULL ");
        consulta.append("           AND NOT EXISTS ( ");
        consulta.append("                  SELECT m.sbti_oid_subt_clie ");
        consulta.append("                    FROM mav_param_geren_zona m, zon_zona z ");
        consulta.append("                   WHERE (ped_solic_cabec.sbti_oid_subt_clie = m.sbti_oid_subt_clie ) ");
        consulta.append("                     AND ped_solic_cabec.clie_oid_clie = z.clie_oid_clie) ");
         
        consulta.append(" UNION ALL ");
        consulta.append(" SELECT   zon_zona.cod_zona CODIGOZONA, ped_solic_cabec_secue.num_secu_zona_ruta RUTA, ");
        consulta.append("          0 CODIGOTERRITORIO, ped_solic_cabec.val_nume_soli NUMEROPEDIDO, ");
        consulta.append("          ped_solic_cabec_secue.num_secu_fact_diar SECUENCIATERRITORIO, ");
        consulta.append("          lar_fn_ind_serv_recl ");
        consulta.append("                                 (ped_solic_cabec.oid_soli_cabe, "+oidPeriodo);
        consulta.append("                                 ) INDICADORPEDIDOSERVICIO ");
        consulta.append("     FROM ped_solic_cabec, ");
        consulta.append("          ped_solic_cabec_secue, ");
        consulta.append("          zon_zona, ");
        consulta.append("          int_lar_tipo_solici_pedido_dis ");
        consulta.append("    WHERE     ped_solic_cabec.oid_soli_cabe =  ped_solic_cabec_secue.soca_oid_soli_cabe ");
              
        consulta.append("           AND ped_solic_cabec.clie_oid_clie = zon_zona.clie_oid_clie ");
        consulta.append("           AND ped_solic_cabec.perd_oid_peri = "+oidPeriodo);
        consulta.append("           AND ped_solic_cabec.tspa_oid_tipo_soli_pais = int_lar_tipo_solici_pedido_dis.tspa_oid_tipo_soli_pais ");

        consulta.append("           AND ped_solic_cabec.ind_inte_lari_gene = 0 ");
        consulta.append("           AND ped_solic_cabec.num_unid_aten_tota > 0 ");
        consulta.append("           AND ped_solic_cabec.fec_fact IS NOT NULL ");
        consulta.append("           AND EXISTS ( ");
        consulta.append("                  SELECT m.sbti_oid_subt_clie ");
        consulta.append("                    FROM mav_param_geren_zona m, zon_zona z ");
        consulta.append("                   WHERE (ped_solic_cabec.sbti_oid_subt_clie = m.sbti_oid_subt_clie ) ");
        consulta.append("                     AND ped_solic_cabec.clie_oid_clie = z.clie_oid_clie) ");
        
        consulta.append(" ORDER BY 2, 5  ");
                 
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs;
        try {
            rs =bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerSecuenciaPedidos: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        ArrayList secuenciaPedidos = new ArrayList();
        DTOINTSecuenciaPedido dto = null;
        
        if(!rs.esVacio()) {
            int cant = rs.getRowCount();
            for(int i = 0; i < cant; i++) {
                dto = new DTOINTSecuenciaPedido();
        
                if (rs.getValueAt(i,"CODIGOZONA") != null) {
                    dto.setCodigoZona((String)rs.getValueAt(i,"CODIGOZONA"));
                }
                if(rs.getValueAt(i,"RUTA") != null) {
                    dto.setRuta(new Integer(((BigDecimal)rs.getValueAt(i,"RUTA")).toString()));
                }
                if(rs.getValueAt(i,"CODIGOTERRITORIO") != null) {
                    dto.setCodigoTerritorio(rs.getValueAt(i,"CODIGOTERRITORIO").toString());
                }
                if(rs.getValueAt(i,"NUMEROPEDIDO") != null) {
                    dto.setNumeroPedido(rs.getValueAt(i,"NUMEROPEDIDO").toString());
                }
                if(rs.getValueAt(i,"SECUENCIATERRITORIO") != null){
                    dto.setSecuenciaTerritorio(new Integer(((BigDecimal)rs.getValueAt(i,"SECUENCIATERRITORIO")).toString()));
                }
                if(rs.getValueAt(i,"INDICADORPEDIDOSERVICIO") != null) {
                    dto.setIndicadorPedidoServicio((String)rs.getValueAt(i,"INDICADORPEDIDOSERVICIO"));
                }

                secuenciaPedidos.add(dto);
            }
        }
        
        UtilidadesLog.info("DAOINTLAR.obtenerSecuenciaPedidos(): Salida");
        return secuenciaPedidos;
    }

    /**
     * Agregado por Sapaza, fecha 29-04-2008, Nueva Interface LAR-10
     * 
     * CHANGELOG
     * ---------
     * Error Nro. SiCC 20080762 - dmorello, 10/10/2008
     *    - Se obtienen clientes y sus datos mediante queries separadas con operador WITH
     */
    public ArrayList obtenerDocumentoIdentidadClientes (Long oidPais, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOINTLAR.obtenerDocumentoIdentidadClientes(): Entrada");
        StringBuffer consulta = new StringBuffer();

        consulta.append(" WITH clientes AS ( ");
        consulta.append("     SELECT DISTINCT b.clie_oid_clie ");
        // vbongiov -- SiCC 20080762 -- 20/10/2008
        consulta.append("      FROM ped_solic_cabec b ");
        consulta.append("      WHERE b.perd_oid_peri = " + oidPeriodo);
        consulta.append("        AND b.fec_fact IS NOT NULL ");
        consulta.append("        AND b.ind_inte_lari_gene = 0 ");
        consulta.append("        AND b.num_unid_aten_tota > 0 ");
        consulta.append("        AND b.tspa_oid_tipo_soli_pais IN (SELECT tspa_oid_tipo_soli_pais FROM int_lar_tipo_solici_pedido_dis)), ");
        consulta.append(" datos AS ( ");
        consulta.append("     SELECT a.cod_clie cod, mb.num_docu_iden dni, ");
        consulta.append("            SUBSTR (mc.cod_unid_geog, 1, 6) cn1, ");
        consulta.append("            SUBSTR (mc.cod_unid_geog, 7, 6) cn2, ");
        consulta.append("            SUBSTR (mc.cod_unid_geog, 13, 6) cn3, ");
        consulta.append("            (SELECT val_text_comu ");
        consulta.append("               FROM mae_clien_comun ");
        consulta.append("              WHERE clie_oid_clie = a.oid_clie ");
        consulta.append("                AND ticm_oid_tipo_comu = 1) telf ");
        consulta.append("       FROM mae_clien a, ");
        consulta.append("            mae_clien_ident mb, ");
        consulta.append("            mae_clien_direc mc, ");
        consulta.append("            clientes c ");
        consulta.append("      WHERE a.oid_clie = c.clie_oid_clie ");
        consulta.append("        AND mb.clie_oid_clie = a.oid_clie ");
        consulta.append("        AND mb.val_iden_docu_prin = 1 ");
        consulta.append("        AND mc.clie_oid_clie = a.oid_clie ");
        consulta.append("        AND mc.ind_dire_ppal = 1 ");
        consulta.append("        AND mc.ind_elim = 0) ");
        consulta.append(" SELECT datos.cod, datos.dni, datos.cn1 cn1, datos.cn2 cn2, datos.cn3 cn3, ");
        consulta.append("        nivel1.des_geog DES1 , nivel2.des_geog DES2 , nivel3.des_geog DES3, ");
        consulta.append("        REPLACE (datos.telf, CHR (10), '') telf ");
        consulta.append("   FROM datos, ");
        consulta.append("        zon_valor_estru_geopo nivel1, ");
        consulta.append("        zon_valor_estru_geopo nivel2, ");
        consulta.append("        zon_valor_estru_geopo nivel3 ");
        consulta.append("  WHERE (nivel1.orde_1 = datos.cn1 AND nivel1.orde_2 IS NULL) ");
        consulta.append("    AND (    nivel2.orde_1 = datos.cn1 AND nivel2.orde_2 = datos.cn2 ");
        consulta.append("         AND nivel2.orde_3 IS NULL ");
        consulta.append("        ) ");
        consulta.append("    AND (    nivel3.orde_1 = datos.cn1 AND nivel3.orde_2 = datos.cn2 ");
        consulta.append("         AND nivel3.orde_3 = datos.cn3 AND nivel3.orde_4 IS NULL ");
        consulta.append("        ) ");
        consulta.append("    AND nivel1.pais_oid_pais = nivel2.pais_oid_pais ");
        consulta.append("    AND nivel1.pais_oid_pais = nivel3.pais_oid_pais ");
        consulta.append("    AND nivel1.pais_oid_pais = ").append(oidPais);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs;
        try {
            rs =bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerDocumentoIdentidadClientes: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        ArrayList identidadesClientes = new ArrayList();
        DTOINTDocumentoIdendidad dto = null;

        if(!rs.esVacio()) {
            int cant = rs.getRowCount();
            for(int i = 0; i < cant; i++) {
                dto = new DTOINTDocumentoIdendidad();
        
                if (rs.getValueAt(i,"COD") != null) {
                    dto.setCodigoCliente((String)rs.getValueAt(i,"COD"));
                }
                if(rs.getValueAt(i,"DNI") != null) {
                    dto.setNumeroDocumentoIdentidad((String)rs.getValueAt(i,"DNI"));
                }
                if(rs.getValueAt(i,"CN1") != null) {
                    dto.setCodigoUnidadGeografica1((String)rs.getValueAt(i,"CN1"));
                }
                if(rs.getValueAt(i,"CN2") != null) {
                    dto.setCodigoUnidadGeografica2((String)rs.getValueAt(i,"CN2"));
                }
                if(rs.getValueAt(i,"CN3") != null){
                    dto.setCodigoUnidadGeografica3((String)rs.getValueAt(i,"CN3"));
                }
                if(rs.getValueAt(i,"DES1") != null) {
                    dto.setDescripcionUnidadGeografica1((String)rs.getValueAt(i,"DES1"));
                }
                if(rs.getValueAt(i,"DES2") != null) {
                    dto.setDescripcionUnidadGeografica2((String)rs.getValueAt(i,"DES2"));
                }
                if(rs.getValueAt(i,"DES3") != null) {
                    dto.setDescripcionUnidadGeografica3((String)rs.getValueAt(i,"DES3"));
                }
                if(rs.getValueAt(i,"TELF") != null){
                    dto.setTelefono((String)rs.getValueAt(i,"TELF"));
                }

                identidadesClientes.add(dto);
            }
        }
        
        UtilidadesLog.info("DAOINTLAR.obtenerDocumentoIdentidadClientes(): Salida");
        return identidadesClientes;
    }
    
    /**
     * Creado por Cambio 20090891
     * Recupera la información para la interfaz LAR-7, solo cabeceras de documentos.
     * @author dmorello
     * @since 14-may-2009
     */
    public RecordSet obtenerCabecerasDocumentosLAR7(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOINTLAR.obtenerCabecerasDocumentosLAR7(Long oidPeriodo, Long oidPais): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT DISTINCT ");
        query.append("     emp.cod_soci codigoempresa, soc2.val_nume_soli numeropedido,  ");
        query.append("     cli.cod_clie codigocliente, soc.fec_fact fechapedido,  ");
        query.append("     rev.cod_indi_revi indicadorpedidoachequear,  ");
        query.append("     DECODE (td.cod_tipo_desp, 'EX', 1, 0) indicadorpedidoexpress,  ");
        query.append("     clas.cod_clas_soli clasesolicitud,  ");
        query.append("     ts.cod_tipo_soli codigotiposolicitud,  ");
        query.append("     SUM (sop.num_unid_aten) OVER (PARTITION BY soc2.val_nume_soli ORDER BY 1) totalunixpedido,  ");
        query.append("     COUNT (sop.oid_soli_posi) OVER (PARTITION BY soc2.val_nume_soli ORDER BY 1) totalitemxpedido  ");
        query.append(" FROM  ");
        query.append("     ped_solic_posic sop,  ");
        query.append("     ped_solic_cabec soc,  ");
        query.append("     ped_solic_cabec soc2,  ");
        query.append("     mae_clien cli,  ");
        query.append("     ped_indic_revis rev,  ");
        query.append("     ped_clase_solic clas,  ");
        query.append("     ped_tipo_despa td,  ");
        query.append("     seg_socie emp,  ");
        query.append("     ped_tipo_solic_pais tsp,  ");
        query.append("     mae_produ pro,  ");
        query.append("     ped_tipo_solic ts,  ");
        query.append("     int_lar_tipo_solici_pedido_dis tspd ");
        query.append(" WHERE soc2.clso_oid_clas_soli = clas.oid_clas_soli  ");
        query.append("   AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli  ");
        query.append("   AND soc2.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais  ");
        query.append("   AND soc2.soci_oid_soci = emp.oid_soci  ");
        query.append("   AND td.oid_tipo_desp = soc.tids_oid_tipo_desp  ");
        query.append("   AND soc2.inre_oid_indi_revi = rev.oid_indi_revi(+) "); 
        query.append("   AND soc.clie_oid_clie = cli.oid_clie  ");
        query.append("   AND sop.soca_oid_soli_cabe = soc.oid_soli_cabe  ");
        query.append("   AND soc.soca_oid_soli_cabe = soc2.oid_soli_cabe  ");
        query.append("   AND soc2.perd_oid_peri = ").append(oidPeriodo);
        query.append("   AND soc2.ind_inte_lari_gene = 0 ");
        query.append("   AND soc2.fec_fact IS NOT NULL  ");
        query.append("   AND soc2.ind_ts_no_conso = 0  ");
        query.append("   AND (soc2.ind_pedi_prue = 0 OR soc2.ind_pedi_prue IS NULL) ");
        query.append("   AND sop.espo_oid_esta_posi <> ").append(ConstantesPED.ESTADO_POSICION_ANULADO);
        query.append("   AND sop.prod_oid_prod = pro.oid_prod  ");
        query.append("   AND soc2.tspa_oid_tipo_soli_pais = tspd.tspa_oid_tipo_soli_pais  ");
        query.append("   AND sop.num_unid_aten > 0  ");
        query.append(" ORDER BY soc2.val_nume_soli  ");

        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOINTLAR.obtenerCabecerasDocumentosLAR7(Long oidPeriodo, Long oidPais): Salida");
        return rs;
    }
    
    /**
     * Creado por Cambio 20090891
     * Recupera la información para la interfaz LAR-7 (detalles de documentos)
     * @author dmorello
     * @since 14-may-2009
     */
    public RecordSet obtenerDetallesDocumentosLAR7(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOINTLAR.obtenerDetallesDocumentosLAR7(Long oidPeriodo, Long oidPais): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
                query.append(" SELECT   emp.cod_soci codigoempresa, soc2.val_nume_soli numeropedido, ");
                query.append("          pro.cod_sap codigoitem, sop.num_unid_aten unidadesporatender, ");
                query.append("          pro.cod_ind_dent_caja indicadordentrofueracaja, ");
                query.append("          clas.cod_clas_soli clasesolicitud, ");
                query.append("          ts.cod_tipo_soli codigotiposolicitud ");
                query.append("     FROM ped_solic_posic sop, ");
                query.append("          ped_solic_cabec soc, ");
                query.append("          ped_solic_cabec soc2, ");
                query.append("          ped_clase_solic clas, ");
                query.append("          seg_socie emp, ");
                query.append("          ped_tipo_solic_pais tsp, ");
                query.append("          mae_produ pro, ");
                query.append("          ped_tipo_solic ts, ");
                query.append("          int_lar_tipo_solici_pedido_dis tspd ");
                query.append("    WHERE soc2.clso_oid_clas_soli = clas.oid_clas_soli ");
                query.append("      AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli ");
                query.append("      AND soc2.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
                query.append("      AND soc2.soci_oid_soci = emp.oid_soci ");
                query.append("      AND sop.soca_oid_soli_cabe = soc.oid_soli_cabe ");
                query.append("      AND soc.soca_oid_soli_cabe = soc2.oid_soli_cabe ");
                query.append("      AND soc2.perd_oid_peri = ").append(oidPeriodo);
                query.append("      AND soc2.ind_inte_lari_gene = 0 ");
                query.append("      AND soc2.fec_fact IS NOT NULL ");
                query.append("      AND soc2.ind_ts_no_conso = 0 ");
                query.append("      AND (soc2.ind_pedi_prue = 0 OR soc2.ind_pedi_prue IS NULL) ");
                query.append("      AND sop.espo_oid_esta_posi <> ").append(ConstantesPED.ESTADO_POSICION_ANULADO);
                query.append("      AND sop.prod_oid_prod = pro.oid_prod ");
                query.append("      AND soc2.tspa_oid_tipo_soli_pais = tspd.tspa_oid_tipo_soli_pais ");
                query.append("      AND sop.num_unid_aten > 0 ");
                query.append(" ORDER BY soc2.val_nume_soli ");

        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOINTLAR.obtenerDetallesDocumentosLAR7(Long oidPeriodo, Long oidPais): Salida");
        return rs;
    }
}