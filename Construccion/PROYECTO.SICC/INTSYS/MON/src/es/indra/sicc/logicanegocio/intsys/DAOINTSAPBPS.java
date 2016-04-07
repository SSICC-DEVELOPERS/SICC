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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.intsys.DTODatosPedSAP;
import es.indra.sicc.dtos.intsys.DTOINTDemandaAnormal;
import es.indra.sicc.dtos.intsys.DTOINTEstrategia;
import es.indra.sicc.dtos.intsys.DTOINTPantallaSAPBPS;
import es.indra.sicc.dtos.intsys.DTOEnviarPedidosSAP;
import es.indra.sicc.dtos.intsys.DTOMaestroRegiones;
import es.indra.sicc.dtos.intsys.DTOMaestroTerritorios;
import es.indra.sicc.dtos.intsys.DTOMaestroZonas;
import es.indra.sicc.dtos.intsys.DTOVentaDiaProducto;
import es.indra.sicc.entidades.intsys.FuenteVentasRealLocal;
import es.indra.sicc.entidades.intsys.FuenteVentasRealLocalHome;
import es.indra.sicc.entidades.intsys.FuenteVentasRealVentaAcumuladaLocal;
import es.indra.sicc.entidades.intsys.FuenteVentasRealVentaAcumuladaLocalHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.intsys.ConstantesINT;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.math.BigDecimal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class DAOINTSAPBPS 
{
    public DAOINTSAPBPS()
    {
    }
    
     public ArrayList obtenerEstrategia (Long pais, Long tipoEstrategia, Long tipoProducto)throws MareException {                                                                
                                                                                                                                         
        UtilidadesLog.info("DAOINTSAPBPS.obtenerEstrategia(Long pais, Long tipoEstrategia, Long tipoProducto): Entrada");                                                                              
                                                                                                                                         
        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();                                                                                                
                                                                                                                                         
        consulta.append(" SELECT * ");                   
        consulta.append(" FROM PRE_ESTRA ");             
        consulta.append(" WHERE ");                      
        consulta.append(" PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append(" AND TIES_OID_TIPO_ESTR = ? "); 
        parametros.add(tipoEstrategia);
        consulta.append(" AND TIPR_OID_TIPO_PROD = ? "); 
        parametros.add(tipoProducto);                                                                                                                         
                                                                                                                                          
                                                                                                                     
                                                                                                                                         
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOINTSAPBPS.obtenerEstrategia: Exception",e);                                                             
            this.logSql(" DAOINTSAPBPS.obtenerEstrategia. SQL: ",consulta.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }//catch                                                                                                                           
        DTOINTEstrategia  dto=null; 
        ArrayList array =  new ArrayList();
        UtilidadesLog.debug("***DAOINTSAPBPS.obtenerEstrategia- salida");	                                                                 
        if(rs!=null){                                                                                                                    
       if(!rs.esVacio()){                                                                                                                
          dto=new DTOINTEstrategia(); 
          int n=rs.getRowCount();
          for(int i=0;i<n;i++){                                                                                           
                dto=new DTOINTEstrategia();                                                                              
                //ELEMENTOS OBLIGATORIOS
                dto.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID_ESTR")).longValue()));                          
                dto.setCodigo((String)rs.getValueAt(i,"COD_ESTR"));
                dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).longValue())); 
                dto.setTipoEstrategia(new Long(((BigDecimal)rs.getValueAt(i,"TIES_OID_TIPO_ESTR")).longValue()));
                
                //ELEMENTOS NO NULABLES
                 if(rs.getValueAt(i,"TIPR_OID_TIPO_PROD")!=null){
                    dto.setTipoProducto(new Long(((BigDecimal)rs.getValueAt(i,"TIPR_OID_TIPO_PROD")).intValue()));
                 }
                 if(rs.getValueAt(i,"NUM_MAXI_GRUP")!=null){
                    dto.setMaxGrupos(new Integer(((BigDecimal)rs.getValueAt(i,"NUM_MAXI_GRUP")).intValue()));
                 }
                  if(rs.getValueAt(i,"NUM_MAXI_GRUP_CNDT")!=null){
                    dto.setMaxGruposCondicionantes(new Integer(((BigDecimal)rs.getValueAt(i,"NUM_MAXI_GRUP_CNDT")).intValue()));
                 }
                  if(rs.getValueAt(i,"NUM_MAXI_GRUP_CNDO")!=null){
                    dto.setMaxGruposCondicionados(new Integer(((BigDecimal)rs.getValueAt(i,"NUM_MAXI_GRUP_CNDO")).intValue()));
                 }
                 
                 //bboleanos
                  if(rs.getValueAt(i,"IND_LIST_RANK")!=null){
                    dto.setListaRanking(new Boolean(((BigDecimal)rs.getValueAt(i,"IND_LIST_RANK")).intValue()==1 ? true : false));             
                 }
                  if(rs.getValueAt(i,"IND_CUAD_GRUP")!=null){
                    dto.setCuadreGrupos(new Boolean(((BigDecimal)rs.getValueAt(i,"IND_CUAD_GRUP")).intValue()==1 ? true : false));             
                 }
                  if(rs.getValueAt(i,"IND_CV_IMPR")!=null){
                    dto.setCvImprimible(new Boolean(((BigDecimal)rs.getValueAt(i,"IND_CV_IMPR")).intValue()==1 ? true : false));             
                 }
                 
                 
                  if(rs.getValueAt(i,"IND_MODI_IMPR")!=null){
                    dto.setModificableImprimible(new Boolean(((BigDecimal)rs.getValueAt(i,"IND_MODI_IMPR")).intValue()==1 ? true : false));             
                 }
                  if(rs.getValueAt(i,"IND_CV_DIGI")!=null){
                    dto.setCvDigitable(new Boolean(((BigDecimal)rs.getValueAt(i,"IND_CV_DIGI")).intValue()==1 ? true : false));             
                 }
                  if(rs.getValueAt(i,"IND_MODI_DIGI")!=null){
                    dto.setModificableDigitable(new Boolean(((BigDecimal)rs.getValueAt(i,"IND_MODI_DIGI")).intValue()==1 ? true : false));             
                 }
                  if(rs.getValueAt(i,"IND_CV_DESP_AUTO")!=null){
                    dto.setCvDespachoAutomatico(new Boolean(((BigDecimal)rs.getValueAt(i,"IND_CV_DESP_AUTO")).intValue()==1 ? true : false));             
                 }
                 if(rs.getValueAt(i,"IND_MODI_DESP")!=null){
                    dto.setModificableDespachoAutomatico(new Boolean(((BigDecimal)rs.getValueAt(i,"IND_MODI_DESP")).intValue()==1 ? true : false));             
                 }
            array.add(dto);                                                                                            
           }//for                                                                                                                        
       }                                                                                                                                 
     }//(rs!=null) 
          
     
     UtilidadesLog.debug("***DAOINTSAPBPS.obtenerEstrategia - Salida    ---> array " +array); 
     UtilidadesLog.info("DAOINTSAPBPS.obtenerEstrategia(Long pais, Long tipoEstrategia, Long tipoProducto): Salida");
        return array;                                                                                                               
     }    //metodo
   /**
    * @autor Noziglia C.
    * @throws MareException
    * @documentation Se Modifico el metodo completo Segun diseño
    * 
    * @date
    */   
     public ArrayList obtenerMaestroZonas (Long pais, Long marca, Long canal, Boolean indicadorActivo, Long idioma, Long periodo)throws MareException{
          UtilidadesLog.info("DAOINTSAPBPS.obtenerMaestroZonas(Long pais, Long marca, Long canal, Boolean indicadorActivo, Long idioma): Entrada");                                                                        

        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();   
        
         consulta.append(" SELECT   fvra.pais_oid_pais PAIS , fvra.soci_oid_soci SOCIEDAD , m.cod_marc MARCA, ");
         consulta.append("           fvra.zzon_oid_zona ZONA , fvra.tspa_oid_tipo_soli_pais TIPOSOLICPAIS , ");
         consulta.append("         fvra.ticl_oid_tipo_clie TIPOCLIENTE , p.cod_pais CODPAIS , z.cod_zona CODZONA, r.cod_regi CODREGI , ");
         consulta.append("         z.des_zona DESZONA , s.cod_soci CODSOCI, sgv.cod_subg_vent CODSUBGERENTEV , cb.val_cana_bps CANALBPS");
         consulta.append("    FROM int_fuent_venta_real_vacum fvra, ");
         consulta.append("         cra_perio per, ");
         consulta.append("         seg_marca m, ");
         consulta.append("         seg_pais p, ");
         consulta.append("         zon_sub_geren_venta sgv, ");
         consulta.append("         zon_regio r, ");
         consulta.append("         zon_zona z, ");
         consulta.append("         seg_socie s,  ");
         consulta.append("         int_canal_bps cb ");
         consulta.append("   WHERE fvra.pais_oid_pais = ?  ");                     
         parametros.add(pais);
         consulta.append("     AND fvra.perd_oid_peri = per.oid_peri  ");
         consulta.append("     AND per.oid_peri = ? ");
         parametros.add(periodo);
         consulta.append("     AND per.marc_oid_marc = m.oid_marc ");
         if(canal!=null){
            consulta.append(" 	   AND per.CANA_OID_CANA = ? ");
            parametros.add(canal);
         }
         if(marca!=null){
            consulta.append("	   AND per.MARC_OID_MARC = ? ");
            parametros.add(marca);
         }
         consulta.append("     AND z.IND_ACTI = ? ");
         if(indicadorActivo.equals(Boolean.TRUE)){
            parametros.add(new Long(1)); 
         }else{
            parametros.add(new Long(0));  
         }
         consulta.append("     AND sgv.oid_subg_vent = r.zsgv_oid_subg_vent ");
         consulta.append("     AND r.oid_regi = z.zorg_oid_regi ");
         consulta.append("     AND fvra.zzon_oid_zona = z.oid_zona ");
         consulta.append("     AND s.oid_soci = fvra.soci_oid_soci ");
         consulta.append("     AND p.oid_pais = fvra.pais_oid_pais ");
         consulta.append("     AND cb.tspa_oid_tipo_soli_pais = fvra.tspa_oid_tipo_soli_pais ");
         consulta.append("     AND cb.ticl_oid_tipo_clie = fvra.ticl_oid_tipo_clie ");
         consulta.append("GROUP BY fvra.pais_oid_pais, ");
         consulta.append("         fvra.soci_oid_soci, ");
         consulta.append("         m.cod_marc, ");
         consulta.append("         fvra.zzon_oid_zona, ");
         consulta.append("         fvra.tspa_oid_tipo_soli_pais, ");
         consulta.append("         fvra.ticl_oid_tipo_clie, ");
         consulta.append("         p.cod_pais, ");
         consulta.append("         z.cod_zona, ");
         consulta.append("         r.cod_regi, ");
         consulta.append("         z.des_zona, ");
         consulta.append("         s.cod_soci, ");
         consulta.append("         sgv.cod_subg_vent, ");
         consulta.append("         cb.val_cana_bps");
                                                             
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOINTSAPBPS.3: Exception",e);                                                             
            this.logSql(" DAOINTSAPBPS.obtenerMaestroZonas. SQL: ",consulta.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }//catch                                                                                                                           
        DTOMaestroZonas dto =null; 
        ArrayList array =  new ArrayList();
        
        if(rs!=null){                                                                                                                    
        if(!rs.esVacio()){                                                                                                                
          int n=rs.getRowCount();
          for(int i=0;i<n;i++){                                                                                           
                dto = new DTOMaestroZonas();                  
                 if(rs.getValueAt(i,"CODPAIS")!=null){
                    dto.setCodPais(rs.getValueAt(i,"CODPAIS").toString());
                 }
                 if(rs.getValueAt(i,"CANALBPS")!=null){
                    dto.setCanalBPS(rs.getValueAt(i,"CANALBPS").toString());
                 }
                 if(rs.getValueAt(i,"CODREGI")!=null){
                    dto.setCodRegion(rs.getValueAt(i,"CODREGI").toString());
                 }
                 if(rs.getValueAt(i,"CODSOCI")!=null){
                    dto.setCodSociedad(rs.getValueAt(i,"CODSOCI").toString());
                 }
                 if(rs.getValueAt(i,"CODZONA")!=null){
                    dto.setCodZona(rs.getValueAt(i,"CODZONA").toString());
                 }
                 if(rs.getValueAt(i,"DESZONA")!=null){
                    dto.setDescripcionZona(rs.getValueAt(i,"DESZONA").toString());
                 }
                 if(rs.getValueAt(i,"MARCA")!=null){
                    dto.setMarcaEstructural(rs.getValueAt(i,"MARCA").toString());
                 }
                 if(rs.getValueAt(i,"CODSUBGERENTEV")!=null){
                    dto.setSubgerenciaVentas(rs.getValueAt(i,"CODSUBGERENTEV").toString());
                 }
                 array.add(dto);                                                                                            
           }//for                                                                                                                        
       }                                                                                                                                 
     }//(rs!=null) 
          
     
     UtilidadesLog.debug("***DAOINTSAPBPS.obtenerMaestroZonas - Salida    ---> array " +array); 
     UtilidadesLog.info("DAOINTSAPBPS.obtenerMaestroZonas(Long pais, Long marca, Long canal, Boolean indicadorActivo, Long idioma): Salida");
        return array;           
     }
     
     /**
      * CHANGELOG
      * ---------
      * 29/04/2009 - dmorello, Cambio 20080824
      *     - Se agrega recuperacion de solicitudes con IND_OC = 0
      *       haciendo outer join con INT_PARAM_TIPO_SOLIC
      *     - Se modifican calculos segun valor del campo NUM_UNID_VEND_OTRO
      * 28/05/2009 - dmorello, Cambio 20080824
      *     - Se corrigen errores detectados por el cliente
      */
     public ArrayList obtenerFuenteVentaRealAcumulada (Long periodo)throws MareException{
         UtilidadesLog.info("DAOINTSAPBPS.obtenerFuenteVentaRealAcumulada(Long periodo): Entrada");                                                                        
                                                                                                                                         
        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();   
        
        consulta.append(" SELECT ");                                                                   
        consulta.append("   PAI.COD_PAIS CODIGOPAIS, ");                                               
        consulta.append("   PERI.MARC_OID_MARC MARCA, ");                                              
        consulta.append("   SOC.PERD_OID_PERI PERIODO, ");                                             
        consulta.append("   SOCI.COD_SOCI CODIGOSOCIEDAD, ");                                          
        consulta.append("   ALM.COD_ALMA CODIGOALMACEN, ");                                            
        consulta.append("   ZON.COD_ZONA CODIGOZONA, ");                                               
        consulta.append("   REG.COD_REGI CODIGOREGION, ");                                             
        consulta.append("   (SELECT CBPS.VAL_CANA_BPS ");                                              
        consulta.append("    FROM INT_CANAL_BPS CBPS ");                                               
        consulta.append("    WHERE CBPS.TSPA_OID_TIPO_SOLI_PAIS = SOC.TSPA_OID_TIPO_SOLI_PAIS ");      
        consulta.append("          AND CBPS.TICL_OID_TIPO_CLIE = SOC.TICL_OID_TIPO_CLIE ) CANALBPS, ");
        // dmorello, 28/05/2009: Estos valores se recuperan mas adelante en query aparte
        // ya que no deben calcularse sobre solicitudes que no sean ordenes de compra
        //consulta.append("    COUNT (DISTINCT (soc.OID_SOLI_CABE)) NUMEROORDENES, ");
        //consulta.append("   COUNT(DISTINCT(SOC.CLIE_OID_CLIE)) NUMEROPEDIDOS, ");                      
        //consulta.append("   COUNT(DISTINCT(SOC.CLIE_OID_CLIE)) NUMEROCLIENTES, ");                     
        consulta.append("   SUM (CASE WHEN PT.NUM_UNID_VEND = 1 OR PT.NUM_UNID_VEND_OTRO = 1 THEN ");
        consulta.append("          DECODE (TOF.IND_ESTA, 1, POS.NUM_UNID_ATEN, 0) ");
        consulta.append("      ELSE 0 ");
        consulta.append("      END ");
        consulta.append("   ) UNIDADESVENDIDAS, ");
         //Se vuelve a modificar por RI 20080797 - enozigli 20/11/2008
        consulta.append("   NVL ((SELECT SUM ( ");
        consulta.append("            CASE WHEN PT2.NUM_UNID_VEND = 1 OR PT2.NUM_UNID_VEND_OTRO = 1 THEN ");
        consulta.append("                 DECODE (tof2.ind_esta, 1, pos2.val_prec_neto_tota_loca, 0) ");
        consulta.append("            ELSE 0 END ");
        consulta.append("         ) ");
                 consulta.append(" FROM ped_solic_cabec soc2, ");
                      consulta.append(" ped_solic_posic pos2, ");
                      consulta.append(" seg_pais pai2, ");
                      consulta.append(" seg_socie soci2, ");
                      consulta.append(" pre_ofert_detal ofd2, ");
                      consulta.append(" pre_tipo_ofert tof2, ");
                      consulta.append(" cra_perio peri2, ");
                      consulta.append(" ped_tipo_solic ts2, ");
                      consulta.append(" int_param_tipo_solic pt2, ");
                      consulta.append(" bel_almac alm2, ");
                      consulta.append(" zon_zona zon2, ");
                      consulta.append(" zon_regio reg2, ");
                      consulta.append(" zon_terri ter2, ");
                      consulta.append(" ped_tipo_solic_pais tsp2 ");
                consulta.append(" WHERE pos2.soca_oid_soli_cabe = soc2.oid_soli_cabe ");
                  consulta.append(" AND soc2.tspa_oid_tipo_soli_pais = pt2.tspa_oid_tipo_soli_pais ");
                  consulta.append(" AND ( (pt2.num_unid_vend = 1 AND soc2.ind_oc = 1) OR (pt2.num_unid_vend_otro = 1) ) ");
                  consulta.append(" AND pos2.espo_oid_esta_posi <>  "+ ConstantesPED.ESTADO_POSICION_ANULADO );
                  consulta.append(" AND soc2.perd_oid_peri = peri2.oid_peri ");
                  consulta.append(" AND pos2.ofde_oid_deta_ofer = ofd2.oid_deta_ofer ");
                  consulta.append(" AND ofd2.tofe_oid_tipo_ofer = tof2.oid_tipo_ofer ");
                  consulta.append(" AND soc2.pais_oid_pais = pai2.oid_pais ");
                  consulta.append(" AND soc2.soci_oid_soci = soci2.oid_soci ");
                  consulta.append(" AND soc2.almc_oid_alma = alm2.oid_alma ");
                  consulta.append(" AND soc2.zzon_oid_zona = zon2.oid_zona ");
                  consulta.append(" AND soc2.tspa_oid_tipo_soli_pais = tsp2.oid_tipo_soli_pais ");
                  consulta.append(" AND zon2.zorg_oid_regi = reg2.oid_regi ");
                  consulta.append(" AND soc2.perd_oid_peri = soc.perd_oid_peri ");
                  consulta.append(" AND soc2.perd_oid_peri = soc.perd_oid_peri ");
                  consulta.append(" AND soc2.fec_fact IS NOT NULL ");
                  consulta.append(" AND soc2.ind_ts_no_conso = 1 ");
                  consulta.append(" AND soc2.ind_pedi_prue = 0 ");
                  consulta.append(" AND pos2.val_codi_vent IS NOT NULL ");
                  consulta.append(" AND soc2.pais_oid_pais = zon2.pais_oid_pais ");
                  consulta.append(" AND soc2.terr_oid_terr = ter2.oid_terr ");
                  consulta.append(" AND tsp2.tsol_oid_tipo_soli = ts2.oid_tipo_soli ");
                  consulta.append(" AND ts2.ind_anul = 0 ");
                  consulta.append(" AND ts2.ind_devo = 0 ");
                  consulta.append(" AND pos2.val_prec_cata_unit_loca > 0 ");
                  consulta.append(" AND pai.cod_pais = pai2.cod_pais ");
                  consulta.append(" AND peri.marc_oid_marc = peri2.marc_oid_marc ");
                  consulta.append(" AND peri.cana_oid_cana = peri2.cana_oid_cana ");
                  consulta.append(" AND peri.peri_oid_peri = peri2.peri_oid_peri ");
                  consulta.append(" AND soc.perd_oid_peri = soc2.perd_oid_peri ");
                  consulta.append(" AND reg.cod_regi = reg2.cod_regi ");
                  consulta.append(" AND zon.cod_zona = zon2.cod_zona ");
                  consulta.append(" AND alm.cod_alma = alm2.cod_alma ");
                  consulta.append(" AND soci.cod_soci = soci2.cod_soci ");
                  consulta.append(" AND soc.tspa_oid_tipo_soli_pais = soc2.tspa_oid_tipo_soli_pais ");
                  consulta.append(" AND tsp.tsol_oid_tipo_soli = tsp2.tsol_oid_tipo_soli ");
                  consulta.append(" AND soc.ticl_oid_tipo_clie = soc2.ticl_oid_tipo_clie ");
                  consulta.append(" AND soc.soci_oid_soci = soc2.soci_oid_soci ");
                  consulta.append(" AND zon.oid_zona = zon2.oid_zona ");
                  consulta.append(" AND reg.oid_regi = reg2.oid_regi ");
                  consulta.append(" AND ter.oid_terr = ter2.oid_terr ");
                  consulta.append(" AND ter.cod_terr = ter2.cod_terr ");
                  consulta.append(" AND alm.oid_alma = alm2.oid_alma ");
                  consulta.append(" AND pai.oid_pais =   pai2.oid_pais    ), 0 ");
             consulta.append(" ) ventanetaestadisticable, ");  
        consulta.append("   ( SELECT MAX( ctr.fec_cier )  ");
		consulta.append("      FROM fac_contr_cierr ctr, fac_tipos_cierr tipocierre ");
		consulta.append("      WHERE ctr.pais_oid_pais = pai.oid_pais ");
		consulta.append("      		 AND ctr.perd_oid_peri = soc.perd_oid_peri  ");
		consulta.append("   		 AND tcie_oid_tipo_cier = tipocierre.oid_tipo_cier ");
		consulta.append("   		 AND tipocierre.cod_tipo_cier = ? ");
        parametros.add(ConstantesFAC.TIPO_CIERRE_REGION);
		consulta.append("   		 AND ctr.zorg_oid_regi = reg.oid_regi) FECHACIERRE, ");
        
        //18713
        consulta.append("   SOC.TSPA_OID_TIPO_SOLI_PAIS TIPOSOLICITUDPAIS, ");
        consulta.append("   SOC.TICL_OID_TIPO_CLIE TIPOCLIENTE, ");
        consulta.append("   SOC.SOCI_OID_SOCI OIDSOCIEDAD, ");
        consulta.append("   ZON.OID_ZONA OIDZONA , ");
        consulta.append("   REG.OID_REGI OIDREGION , ");
        consulta.append("   TER.OID_TERR OIDTERRITORIO, ");
        consulta.append("   TER.COD_TERR CODTERRITORIO, ");
        consulta.append("   ALM.OID_ALMA OIDALMA, ");
        consulta.append("   PAI.OID_PAIS OIDPAIS ");
        consulta.append(" FROM ");                                                                     
        consulta.append("   PED_SOLIC_CABEC SOC, ");                                                   
        consulta.append("   PED_SOLIC_POSIC POS, ");                                                   
        consulta.append("   SEG_PAIS PAI, ");                                                          
        consulta.append("   SEG_SOCIE SOCI, ");                                                        
        consulta.append("   PRE_OFERT_DETAL OFD, ");                                                   
        consulta.append("   PRE_TIPO_OFERT TOF, ");                                                    
        consulta.append("   CRA_PERIO PERI, ");                                                        
        consulta.append("   PED_TIPO_SOLIC TS, ");
        consulta.append("   INT_PARAM_TIPO_SOLIC PT, ");
        consulta.append("   BEL_ALMAC ALM, ");                                                         
        consulta.append("   ZON_ZONA ZON, ");                                                          
        consulta.append("   ZON_REGIO REG, ");                                                         
        consulta.append("   ZON_TERRI TER, ");
        consulta.append("   PED_TIPO_SOLIC_PAIS TSP ");                                                
        consulta.append(" WHERE ");                                                                    
        consulta.append("   POS.SOCA_OID_SOLI_CABE = SOC.OID_SOLI_CABE ");     
        consulta.append("   AND SOC.TSPA_OID_TIPO_SOLI_PAIS = PT.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append("   AND ( (PT.NUM_UNID_VEND = 1 AND SOC.IND_OC = 1) OR (PT.NUM_UNID_VEND_OTRO = 1) ) ");
        consulta.append("   AND POS.ESPO_OID_ESTA_POSI <> "+ ConstantesPED.ESTADO_POSICION_ANULADO );
        consulta.append("   AND SOC.PERD_OID_PERI = PERI.OID_PERI ");                                  
        consulta.append("   AND POS.OFDE_OID_DETA_OFER = OFD.OID_DETA_OFER ");                         
        consulta.append("   AND OFD.TOFE_OID_TIPO_OFER = TOF.OID_TIPO_OFER ");                         
        consulta.append("   AND SOC.PAIS_OID_PAIS = PAI.OID_PAIS ");                                   
        consulta.append("   AND SOC.SOCI_OID_SOCI = SOCI.OID_SOCI ");                                  
        consulta.append("   AND SOC.ALMC_OID_ALMA = ALM.OID_ALMA ");                                   
        consulta.append("   AND SOC.ZZON_OID_ZONA = ZON.OID_ZONA ");                                   
        consulta.append("   AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");               
        consulta.append("   AND ZON.ZORG_OID_REGI = REG.OID_REGI ");                                   
        if (periodo != null) {
            consulta.append("   AND SOC.PERD_OID_PERI = ? ");
            parametros.add(periodo);
        }
        consulta.append("   AND SOC.FEC_FACT IS NOT NULL ");                                           
        consulta.append("   AND SOC.IND_TS_NO_CONSO = 1 ");                                            
        consulta.append("   AND SOC.IND_PEDI_PRUE = 0 ");                                              
        consulta.append("   AND POS.VAL_CODI_VENT IS NOT NULL ");                                      
        consulta.append("   AND SOC.PAIS_OID_PAIS =  ZON.PAIS_OID_PAIS ");
        consulta.append("   AND SOC.TERR_OID_TERR = TER.OID_TERR ");
        consulta.append("   AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        consulta.append("   AND TS.IND_ANUL = 0 ");
        consulta.append("   AND TS.IND_DEVO = 0 ");
        consulta.append(" GROUP BY ");                                                                 
        consulta.append("   PAI.COD_PAIS, ");                                                          
        consulta.append("   PERI.MARC_OID_MARC, ");                                                    
        consulta.append("   PERI.CANA_OID_CANA, ");                                                    
        consulta.append("   PERI.PERI_OID_PERI, ");                                                    
        consulta.append("   SOC.PERD_OID_PERI, ");                                                     
        consulta.append("   REG.COD_REGI, ");                                                          
        consulta.append("   ZON.COD_ZONA, ");                                                          
        consulta.append("   ALM.COD_ALMA, ");                                                          
        consulta.append("   SOCI.COD_SOCI, ");                                                         
        consulta.append("   SOC.TSPA_OID_TIPO_SOLI_PAIS, ");                                           
        consulta.append("   TSP.TSOL_OID_TIPO_SOLI, ");                                                
        consulta.append("   SOC.TICL_OID_TIPO_CLIE, ");   
        consulta.append("   SOC.SOCI_OID_SOCI, ");
        consulta.append("   ZON.OID_ZONA, ");
        consulta.append("   REG.OID_REGI, ");
        consulta.append("   TER.OID_TERR, ");
        consulta.append("   TER.COD_TERR, ");
        consulta.append("   ALM.OID_ALMA, ");
        consulta.append("   PAI.OID_PAIS ");
        consulta.append(" , PT.NUM_UNID_VEND_OTRO ");
                                                        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOINTSAPBPS.obtenerFuenteVentaRealAcumulada: Exception",e);                                                             
            this.logSql(" DAOINTSAPBPS.obtenerFuenteVentaRealAcumulada. SQL: ",consulta.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }//catch       
      
      
      // dmorello, 28/05/2009: Nueva query para calcular nos. de ordenes, clientes y pedidos.
      consulta.delete(0, consulta.length());
      parametros.clear();
      consulta.append(" SELECT ");
      consulta.append(" COUNT (DISTINCT (soc.OID_SOLI_CABE)) NUMEROORDENES, ");
      consulta.append(" COUNT(DISTINCT(SOC.CLIE_OID_CLIE)) NUMEROPEDIDOS, ");                      
      consulta.append(" COUNT(DISTINCT(SOC.CLIE_OID_CLIE)) NUMEROCLIENTES ");                     
      consulta.append(" FROM ");                                                                     
      consulta.append("   PED_SOLIC_CABEC SOC, ");                                                   
      consulta.append("   PED_SOLIC_POSIC POS, ");                                                   
      consulta.append("   SEG_PAIS PAI, ");                                                          
      consulta.append("   SEG_SOCIE SOCI, ");                                                        
      consulta.append("   PRE_OFERT_DETAL OFD, ");                                                   
      consulta.append("   PRE_TIPO_OFERT TOF, ");                                                    
      consulta.append("   CRA_PERIO PERI, ");                                                        
      consulta.append("   PED_TIPO_SOLIC TS, ");
      consulta.append("   INT_PARAM_TIPO_SOLIC PT, ");
      consulta.append("   BEL_ALMAC ALM, ");                                                         
      consulta.append("   ZON_ZONA ZON, ");                                                          
      consulta.append("   ZON_REGIO REG, ");                                                         
      consulta.append("   ZON_TERRI TER, ");
      consulta.append("   PED_TIPO_SOLIC_PAIS TSP ");                                                
      consulta.append(" WHERE ");                                                                    
      consulta.append("   POS.SOCA_OID_SOLI_CABE = SOC.OID_SOLI_CABE ");     
      consulta.append("   AND SOC.TSPA_OID_TIPO_SOLI_PAIS = PT.TSPA_OID_TIPO_SOLI_PAIS ");
      consulta.append("   AND (PT.NUM_UNID_VEND = 1 AND SOC.IND_OC = 1)");
      consulta.append("   AND POS.ESPO_OID_ESTA_POSI <> "+ ConstantesPED.ESTADO_POSICION_ANULADO );
      consulta.append("   AND SOC.PERD_OID_PERI = PERI.OID_PERI ");                                  
      consulta.append("   AND POS.OFDE_OID_DETA_OFER = OFD.OID_DETA_OFER ");                         
      consulta.append("   AND OFD.TOFE_OID_TIPO_OFER = TOF.OID_TIPO_OFER ");                         
      consulta.append("   AND SOC.PAIS_OID_PAIS = PAI.OID_PAIS ");                                   
      consulta.append("   AND SOC.SOCI_OID_SOCI = SOCI.OID_SOCI ");                                  
      consulta.append("   AND SOC.ALMC_OID_ALMA = ALM.OID_ALMA ");                                   
      consulta.append("   AND SOC.ZZON_OID_ZONA = ZON.OID_ZONA ");                                   
      consulta.append("   AND SOC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");               
      consulta.append("   AND ZON.ZORG_OID_REGI = REG.OID_REGI ");                                   
      if (periodo != null) {
          consulta.append("   AND SOC.PERD_OID_PERI = ? ");
          parametros.add(periodo);
      }
      consulta.append("   AND SOC.FEC_FACT IS NOT NULL ");                                           
      consulta.append("   AND SOC.IND_TS_NO_CONSO = 1 ");                                            
      consulta.append("   AND SOC.IND_PEDI_PRUE = 0 ");                                              
      consulta.append("   AND POS.VAL_CODI_VENT IS NOT NULL ");                                      
      consulta.append("   AND SOC.PAIS_OID_PAIS =  ZON.PAIS_OID_PAIS ");
      consulta.append("   AND SOC.TERR_OID_TERR = TER.OID_TERR ");
      consulta.append("   AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
      consulta.append("   AND TS.IND_ANUL = 0 ");
      consulta.append("   AND TS.IND_DEVO = 0 ");
      consulta.append(" GROUP BY ");                                                                 
      consulta.append("   PAI.COD_PAIS, ");                                                          
      consulta.append("   PERI.MARC_OID_MARC, ");                                                    
      consulta.append("   PERI.CANA_OID_CANA, ");                                                    
      consulta.append("   PERI.PERI_OID_PERI, ");                                                    
      consulta.append("   SOC.PERD_OID_PERI, ");                                                     
      consulta.append("   REG.COD_REGI, ");                                                          
      consulta.append("   ZON.COD_ZONA, ");                                                          
      consulta.append("   ALM.COD_ALMA, ");                                                          
      consulta.append("   SOCI.COD_SOCI, ");                                                         
      consulta.append("   SOC.TSPA_OID_TIPO_SOLI_PAIS, ");                                           
      consulta.append("   TSP.TSOL_OID_TIPO_SOLI, ");                                                
      consulta.append("   SOC.TICL_OID_TIPO_CLIE, ");   
      consulta.append("   SOC.SOCI_OID_SOCI, ");
      consulta.append("   ZON.OID_ZONA, ");
      consulta.append("   REG.OID_REGI, ");
      consulta.append("   TER.OID_TERR, ");
      consulta.append("   TER.COD_TERR, ");
      consulta.append("   ALM.OID_ALMA, ");
      consulta.append("   PAI.OID_PAIS ");
      
      RecordSet rs2 = null;
      try{
         rs2 = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
      }catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error(" DAOINTSAPBPS.obtenerFuenteVentaRealAcumulada: Exception",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch
       
      UtilidadesLog.debug("rs.getRowCount(): " + rs.getRowCount());
      UtilidadesLog.debug("rs2.getRowCount(): " + rs2.getRowCount());
      
       FuenteVentasRealAcumulada fuenteVenta=null;
       ArrayList array =  new ArrayList();
        
       if(rs!=null){                                                                                                                    
       if(!rs.esVacio()){                                                                                                                
          int n=rs.getRowCount();
          for(int i=0;i<n;i++){                                                        
            fuenteVenta=new FuenteVentasRealAcumulada();
                 
                 if(rs.getValueAt(i,"CANALBPS")!=null){
                    fuenteVenta.setCanalBPS(rs.getValueAt(i,"CANALBPS").toString());
                 }
                 if(rs.getValueAt(i,"CODIGOALMACEN")!=null){
                    fuenteVenta.setCodigoAlmacen(rs.getValueAt(i,"CODIGOALMACEN").toString());
                 }
                 if(rs.getValueAt(i,"CODIGOPAIS")!=null){
                    fuenteVenta.setCodigoPais(rs.getValueAt(i,"CODIGOPAIS").toString());
                 }
                 if(rs.getValueAt(i,"CODIGOREGION")!=null){
                    fuenteVenta.setCodigoRegion(rs.getValueAt(i,"CODIGOREGION").toString());
                 }
                 if(rs.getValueAt(i,"CODIGOSOCIEDAD")!=null){
                    fuenteVenta.setCodigoSociedad(rs.getValueAt(i,"CODIGOSOCIEDAD").toString());
                 }
                 if(rs.getValueAt(i,"CODIGOZONA")!=null){
                    fuenteVenta.setCodigoZona(rs.getValueAt(i,"CODIGOZONA").toString());
                 }
                 if(rs.getValueAt(i,"FECHACIERRE")!=null){
                    fuenteVenta.setFechaCierre(new Date(((java.sql.Date)rs.getValueAt(i,"FECHACIERRE")).getTime()));
                 }
                 if(rs2.getValueAt(i,"NUMEROCLIENTES")!=null){
                    fuenteVenta.setNumeroClientes(new Long(((BigDecimal)rs2.getValueAt(i,"NUMEROCLIENTES")).longValue()));
                 }
                 if(rs2.getValueAt(i,"NUMEROORDENES")!=null){
                    fuenteVenta.setNumeroOrdenes(new Long(((BigDecimal)rs2.getValueAt(i,"NUMEROORDENES")).longValue()));
                 }
                 if(rs2.getValueAt(i,"NUMEROPEDIDOS")!=null){
                    fuenteVenta.setNumeroPedidos(new Long(((BigDecimal)rs2.getValueAt(i,"NUMEROPEDIDOS")).longValue()));
                 }
                 if(rs.getValueAt(i,"UNIDADESVENDIDAS")!=null){
                    fuenteVenta.setUnidadesVendidas(new Long(((BigDecimal)rs.getValueAt(i,"UNIDADESVENDIDAS")).longValue()));
                 }
                 if(rs.getValueAt(i,"VENTANETAESTADISTICABLE")!=null){
                    fuenteVenta.setVentaNetaEstadisticable((BigDecimal)rs.getValueAt(i,"VENTANETAESTADISTICABLE"));
                 }
                 if(rs.getValueAt(i,"MARCA")!=null){
                    fuenteVenta.setMarca(new Long(((BigDecimal)rs.getValueAt(i,"MARCA")).longValue()));
                 }
                 if(rs.getValueAt(i,"PERIODO")!=null){
                    fuenteVenta.setPeriodo(new Long(((BigDecimal)rs.getValueAt(i,"PERIODO")).longValue()));
                 }
                 
                 //18713
                 if(rs.getValueAt(i,"TIPOSOLICITUDPAIS")!=null){
                    fuenteVenta.setTipoSolicitudPais(new Long(((BigDecimal)rs.getValueAt(i,"TIPOSOLICITUDPAIS")).longValue()));
                 }
                 if(rs.getValueAt(i,"TIPOCLIENTE")!=null){
                    fuenteVenta.setTipoCliente(new Long(((BigDecimal)rs.getValueAt(i,"TIPOCLIENTE")).longValue()));
                 }
                 if(rs.getValueAt(i,"OIDSOCIEDAD")!=null){
                    fuenteVenta.setSociedad(new Long(((BigDecimal)rs.getValueAt(i,"OIDSOCIEDAD")).longValue()));
                 }
                 if(rs.getValueAt(i,"OIDZONA")!=null){
                    fuenteVenta.setZona(new Long(((BigDecimal)rs.getValueAt(i,"OIDZONA")).longValue()));
                 }
                 if(rs.getValueAt(i,"OIDREGION")!=null){
                    fuenteVenta.setRegion(new Long(((BigDecimal)rs.getValueAt(i,"OIDREGION")).longValue()));
                 }
                 if(rs.getValueAt(i,"OIDALMA")!=null){
                    fuenteVenta.setAlmacen(new Long(((BigDecimal)rs.getValueAt(i,"OIDALMA")).longValue()));
                 }
                 if(rs.getValueAt(i,"OIDPAIS")!=null){
                    fuenteVenta.setPais(new Long(((BigDecimal)rs.getValueAt(i,"OIDPAIS")).longValue()));
                 }
                 
                 // 23122 - dmorello, 16/05/2006: Se setea el territorio en fuenteVenta
                 if(rs.getValueAt(i,"OIDTERRITORIO")!=null){
                    fuenteVenta.setOidTerritorio(new Long(((BigDecimal)rs.getValueAt(i,"OIDTERRITORIO")).longValue()));
                 }
                 
                 if(rs.getValueAt(i,"CODTERRITORIO")!=null){
                    fuenteVenta.setTerritorio(rs.getValueAt(i,"CODTERRITORIO").toString());
                 }
                 
                 array.add(fuenteVenta);                                                                                            
                 
           }//for                                                                                                                        
       }                                                                                                                                 
     }//(rs!=null) 
          
     
     UtilidadesLog.debug("***DAOINTSAPBPS.obtenerFuenteVentaRealAcumulada - Salida    ---> array " +array); 
     UtilidadesLog.info("DAOINTSAPBPS.obtenerFuenteVentaRealAcumulada(Long periodo): Salida");
        return array;           
     }
     
     public void guardarFuenteVentaRealAcumulada (ArrayList ventaReal) throws MareException{
        UtilidadesLog.info("DAOINTSAPBPS.guardarFuenteVentaRealAcumulada(ArrayList ventaReal): Entrada");
        
        if(ventaReal != null && !ventaReal.isEmpty()) {
            try {
                Context ctx =  new InitialContext();
            }
            catch (NamingException e) {
                throw new MareException("Excepción en método DAOINTSAPBPS.guardarFuenteVentaRealAcumulada", e);
            }
            FuenteVentasRealVentaAcumuladaLocalHome fVentaRealAcumuladaLocalHome = this.getFuenteVentasRealVentaAcumuladaLocalHome();
            FuenteVentasRealVentaAcumuladaLocal fVentaRealAcumuladaLocal = null;
                    
            int tamano = ventaReal.size();
            UtilidadesLog.warn("Son ..... " + tamano);
            for(int i=0; i<tamano; i++) {
                FuenteVentasRealAcumulada venta = (FuenteVentasRealAcumulada)ventaReal.get(i);
                //UtilidadesLog.debug("Posicion 222" + i + ": " + venta);
                //UtilidadesLog.warn("Posicion Acum: " + i);
                                           
                try {
                    fVentaRealAcumuladaLocal = fVentaRealAcumuladaLocalHome.create(venta.getTipoSolicitudPais(), venta.getTipoCliente(), venta.getRegion(), venta.getSociedad(), venta.getZona(), venta.getAlmacen(), venta.getPais(), venta.getPeriodo(), venta.getOidTerritorio());
                }
                catch (PersistenceException e) {
                    throw new MareException("Excepción en método DAOINTSAPBPS.guardarFuenteVentaRealAcumulada al realizar el create", e);
                }
                
                fVentaRealAcumuladaLocal.setNumeroOrdenes(venta.getNumeroOrdenes());
                fVentaRealAcumuladaLocal.setNumeroPedidos(venta.getNumeroPedidos());
                fVentaRealAcumuladaLocal.setNumeroClientes(venta.getNumeroClientes());
                fVentaRealAcumuladaLocal.setUnidadesVendidas(venta.getUnidadesVendidas());
                if(venta.getVentaNetaEstadisticable()!=null) {
                    fVentaRealAcumuladaLocal.setVentaNetaEstadisticable(new Double(venta.getVentaNetaEstadisticable().doubleValue()));
                }
                if(venta.getFechaCierre()!=null) {
                    fVentaRealAcumuladaLocal.setFechaCierre(new java.sql.Date(venta.getFechaCierre().getTime()));
                }
                fVentaRealAcumuladaLocal.setTipoSolicitud(venta.getTipoSolicitudPais());
                fVentaRealAcumuladaLocal.setTipoCliente(venta.getTipoCliente());
                fVentaRealAcumuladaLocal.setRegion(venta.getRegion());
                fVentaRealAcumuladaLocal.setSociedad(venta.getSociedad());
                fVentaRealAcumuladaLocal.setZona(venta.getZona());
                fVentaRealAcumuladaLocal.setAlmacen(venta.getAlmacen());
                fVentaRealAcumuladaLocal.setPais(venta.getPais());
                fVentaRealAcumuladaLocal.setPeriodo(venta.getPeriodo());
                fVentaRealAcumuladaLocalHome.merge(fVentaRealAcumuladaLocal);
            }
            
        }
        
        UtilidadesLog.info("DAOINTSAPBPS.guardarFuenteVentaRealAcumulada(ArrayList ventaReal): Salida");
    }
    
    private FuenteVentasRealVentaAcumuladaLocalHome getFuenteVentasRealVentaAcumuladaLocalHome() throws MareException  {
        return new FuenteVentasRealVentaAcumuladaLocalHome();
      
      /*  FuenteVentasRealVentaAcumuladaLocalHome home = (FuenteVentasRealVentaAcumuladaLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/FuenteVentasRealVentaAcumulada");
        return home; */
    }     
     
    /**
     * @cambio Cambio de firma, y eliminacion de la creacion del arraylist de dtos
     * @autor gPineda - 17/01/2007 - Performance
     * @cambio por peticion de cambio, se modifico la agrupacion de la informacion que envia SAB-14.
     * @autor gdmarzi (in situ)
     */
    public RecordSet calcularVentaDia(DTOEnviarPedidosSAP dtoe, String codigo) throws MareException{
        UtilidadesLog.info("DAOINTSAPBPS.calcularVentaDia(DTOEnviarPedidosSAP dtoe): Entrada");
        UtilidadesLog.debug("***DAOINTSAPBPS.calcularVentaDia - Entrada    ---> dtoe " +dtoe); 

        Vector parametros = new Vector();
        ArrayList array = new ArrayList();

        StringBuffer sql = new StringBuffer();        
        
        sql = this.armarSelectVentaDiaSAPBPS14(sql, parametros, dtoe, codigo );
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(sql.toString(),parametros);
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOINTSAPBPS.obtenerFuenteVentaRealAcumulada: Exception",e);                                                             
            this.logSql(" DAOINTSAPBPS.obtenerFuenteVentaRealAcumulada. SQL: ",sql.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
        }
        UtilidadesLog.debug("DAOINTSAPBPS.calcularVentaDia - Salida    ---> rs.getRowCount() " +rs.getRowCount() ); 
        UtilidadesLog.info("DAOINTSAPBPS.calcularVentaDia(DTOEnviarPedidosSAP dtoe): Salida");
        return rs;
    }

    
    public void borrarRegistrosFuenteVentas (Long periodo)throws MareException{
        UtilidadesLog.info("DAOINTSAPBPS.borrarRegistrosFuenteVentas(Long periodo): Entrada");
        long a = System.currentTimeMillis();
        StringBuffer consulta = new StringBuffer();
        StringBuffer consulta2 = new StringBuffer();
        Vector parametros = new Vector();
        Vector parametros2 = new Vector();
        
        consulta.append(" DELETE FROM ");                
        consulta.append(" INT_FUENT_VENTAS_REAL ");      
        consulta.append(" WHERE ");                      
        consulta.append(" PERD_OID_PERI = ? ");
        parametros.add(periodo);
                                                         
        consulta2.append(" DELETE FROM ");                
        consulta2.append(" INT_FUENT_VENTA_REAL_VACUM "); 
        consulta2.append(" WHERE ");                      
        consulta2.append(" PERD_OID_PERI = ? ");
        parametros2.add(periodo);
        
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           bs.dbService.executePreparedUpdate(consulta.toString(),parametros);
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOINTSAPBPS.borrarRegistrosFuenteVentas: Exception",e);                                                             
            this.logSql(" DAOINTSAPBPS.borrarRegistrosFuenteVentas. SQL: ",consulta.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
        }
        
        try{                                                                                                                             
           bs.dbService.executePreparedUpdate(consulta2.toString(),parametros2);
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOINTSAPBPS.borrarRegistrosFuenteVentas: Exception",e);                                                             
            this.logSql(" DAOINTSAPBPS.borrarRegistrosFuenteVentas. SQL: ",consulta2.toString(),parametros2);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
        }
        UtilidadesLog.warn("borrarRegistrosFuenteVentas TIEMPO = " + (System.currentTimeMillis() - a)); 
        UtilidadesLog.info("DAOINTSAPBPS.borrarRegistrosFuenteVentas(Long periodo): Salida"); 
    }
    
    public void borrarVentasTotalesCampania(Long periodo)throws MareException{
        UtilidadesLog.info("DAOINTSAPBPS.borrarVentasTotalesCampania(Long periodo): Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();
        
        sql.append(" DELETE INT_VENTA_TOTAL_CAMPA VTC WHERE VTC.PERD_OID_PERI = ? ");
        parametros.add(periodo);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           bs.dbService.executePreparedUpdate(sql.toString(),parametros);
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOINTSAPBPS.borrarVentasTotalesCampania: Exception",e);                                                             
            this.logSql(" DAOINTSAPBPS.borrarVentasTotalesCampania. SQL: ",sql.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
        }
        UtilidadesLog.info("DAOINTSAPBPS.borrarVentasTotalesCampania(Long periodo): Salida");
    }
        
    //Incidencias 17107, 17111, 17115, BELC300016766, 18713
    public ArrayList obtenerFuenteVentaReal (Long periodo) throws MareException {
            UtilidadesLog.info("DAOINTSAPBPS.obtenerFuenteVentaReal(Long periodo): Entrada");
            
            /* 
             * 03/03/2007 - gPineda
             * SICC-GCC-INT-SAB-004 - dmorello, 04/12/2006 
             * Se deja sin efecto el cambio, en base a otro nuevo cambio pidiendo expresamente esto.
             * Ademas, se realizan correcciones generales a la consulta para que cuadren los valores.
             */            
            ArrayList resultado=new ArrayList();            
            StringBuffer consulta = new StringBuffer();
            Vector parametros = new Vector();
            
            //Incio Consulta
            consulta.append(" SELECT SAB27.*,  ");
            //Modificado por Sapaza - fecha 31-07-2007 - cambio Sicc20070355
            consulta.append("     (SAB27.activasiniciales + SAB27.ingresos + SAB27.reingresos - SAB27.egresos )activasfinales ");
            //consulta.append("     (SAB27.activasfinales - SAB27.ingresos - SAB27.reingresos + SAB27.egresos )activasiniciales ");            
            consulta.append(" FROM ( ");
            consulta.append(" SELECT   pai.cod_pais codigopais, ");
            consulta.append(" 		 pai.oid_pais oidpais, ");
            consulta.append("          peri.marc_oid_marc marca,  ");
            consulta.append(" 		 peri.cana_oid_cana canal, ");
            consulta.append(" 		 PERI.OID_PERI periodo,  ");
            consulta.append(" 		 reg.cod_regi codigoregion, ");
            consulta.append("          reg.oid_regi oidregion,  ");
            consulta.append(" 		 ZON.OID_ZONA zona, ");
            consulta.append("          zon.cod_zona codigozona, ");
            consulta.append(" 		 ter.cod_terr territorio, ");
            consulta.append("          ter.oid_terr oidterritorio, ");
            consulta.append(" 		 sm.COD_MARC codmarca, ");
            
            // 20070185-Cambio SiCC 20070403 - hhernandez
            consulta.append("   ( SELECT MAX( cie.fec_cier )  ");
            consulta.append("      FROM fac_contr_cierr cie, fac_tipos_cierr tcie ");
            consulta.append("      WHERE cie.pais_oid_pais = pai.oid_pais ");
            if( periodo != null ){
                consulta.append(" 		    AND cie.PERD_OID_PERI = ? ");
                parametros.add( periodo );
            }
            //consulta.append("      		 AND ctr.perd_oid_peri = soc.perd_oid_peri  ");
            consulta.append("   		 AND cie.tcie_oid_tipo_cier = tcie.oid_tipo_cier ");
            consulta.append("   		 AND tcie.cod_tipo_cier = ? ");
            parametros.add(ConstantesFAC.TIPO_CIERRE_REGION);
            consulta.append("   		 AND cie.zorg_oid_regi = reg.oid_regi) FECHACIERRE, ");                        
            
            // 20070185-Cambio SiCC 20070409 - hhernandez
            consulta.append("   (SELECT CBPS.VAL_CANA_BPS  ");
            consulta.append("      FROM INT_CANAL_BPS CBPS, INT_PARAM_PAIS PRPA ");
            consulta.append("      WHERE CBPS.OID_CANA_BPS= PRPA.CBPS_OID_CANA_BPS AND ");
            consulta.append("      PRPA.PAIS_OID_PAIS = PAI.OID_PAIS ) CANALBPS,  ");
            
            // 20070185-Cambio SiCC 20070409 - hhernandez
            consulta.append("   (SELECT SOCI.COD_SOCI  ");
            consulta.append("      FROM SEG_SOCIE SOCI, INT_PARAM_PAIS PRPA ");
            consulta.append("      WHERE SOCI.OID_SOCI = PRPA.SOCI_OID_SOCI AND ");
            consulta.append("       PRPA.PAIS_OID_PAIS = PAI.OID_PAIS ) CODIGOSOCIEDAD, ");            
            
            // 20070185-Cambio SiCC 20070409 - hhernandez
            consulta.append("   (SELECT ALM.COD_ALMA  ");
            consulta.append("      FROM BEL_ALMAC ALM, INT_PARAM_PAIS PRPA ");
            consulta.append("      WHERE ALM.OID_ALMA = PRPA.ALMC_OID_ALMA AND ");
            consulta.append("       PRPA.PAIS_OID_PAIS = PAI.OID_PAIS) CODIGOALMACEN, ");            
            
            //Modificado por Sapaza - fecha 31-07-2007 - cambio Sicc20070355
            consulta.append("          NVL ((SELECT fvr.num_acti_fina ");
            consulta.append("                  FROM int_fuent_ventas_real fvr,  ");
            consulta.append(" 				 	  ZON_TERRI_ADMIN ZTA,  ");
            consulta.append(" 					  ZON_SECCI ZS ");
            consulta.append("                 WHERE FVR.ZZON_OID_ZONA = ZS.ZZON_OID_ZONA   ");
            consulta.append("                   AND fvr.terr_oid_terr = ter.oid_terr ");
            consulta.append(" 				  AND TER.OID_TERR = ZTA.TERR_OID_TERR ");
            consulta.append(" 				  AND ZTA.IND_BORR = 0 ");
            consulta.append(" 				  AND ZTA.ZSCC_OID_SECC = ZS.OID_SECC ");
            consulta.append(" 				  AND ZS.IND_BORR = 0 ");
            consulta.append(" 				  AND ZS.IND_ACTI = 1 ");
            consulta.append("                   AND fvr.perd_oid_peri = ");
            consulta.append("                          (SELECT oid_peri ");
            consulta.append("                             FROM (SELECT   cra2.oid_peri ");
            consulta.append("                                       FROM cra_perio cra2, ");
            consulta.append("                                            seg_perio_corpo pcor2, ");
            consulta.append("                                            (SELECT spca.cod_peri, ");
            consulta.append("                                                    cpa.pais_oid_pais, ");
            consulta.append("                                                    cpa.marc_oid_marc, ");
            consulta.append("                                                    cpa.cana_oid_cana ");
            consulta.append("                                               FROM seg_perio_corpo spca, ");
            consulta.append("                                                    cra_perio cpa ");
            consulta.append("                                              WHERE cpa.peri_oid_peri = spca.oid_peri ");
            
            if( periodo != null ){
                consulta.append("                                                AND cpa.oid_peri = ? ) pcora ");
                parametros.add( periodo );
            }
            consulta.append("                                      WHERE cra2.peri_oid_peri = pcor2.oid_peri ");
            consulta.append("                                        AND pcor2.cod_peri < pcora.cod_peri ");
            consulta.append("                                        AND cra2.pais_oid_pais = ");
            consulta.append("                                                            pcora.pais_oid_pais ");
            consulta.append("                                        AND cra2.marc_oid_marc = ");
            consulta.append("                                                            pcora.marc_oid_marc ");
            consulta.append("                                        AND cra2.cana_oid_cana = ");
            consulta.append("                                                            pcora.cana_oid_cana ");
            consulta.append("                                   ORDER BY pcor2.cod_peri DESC) ");
            consulta.append("                            WHERE ROWNUM = 1)), ");
            consulta.append("               0 ");
            consulta.append("              ) activasiniciales, ");
            consulta.append("          (SELECT COUNT (DISTINCT ADI.CLIE_OID_CLIE)   ");
            consulta.append("             FROM mae_clien_unida_admin adm, ");
            consulta.append("                  mae_clien cli, ");
            consulta.append("                  mae_clien_datos_adici adi, ");
            consulta.append("                  mae_estat_clien est, ");
            consulta.append("                  cra_perio periini, ");
            consulta.append("                  cra_perio perifin, ");
            consulta.append("                  cra_perio periactual, ");
            consulta.append("                  zon_terri_admin terri, ");
            consulta.append("                  zon_secci secc ");
            //consulta.append("                  mae_clien_histo_estat histo ");
            consulta.append("            WHERE adm.clie_oid_clie = cli.oid_clie ");
            consulta.append("              AND adi.clie_oid_clie = cli.oid_clie ");
            consulta.append("              AND adm.perd_oid_peri_ini = periini.oid_peri ");
            consulta.append("              AND adm.ztad_oid_terr_admi = terri.oid_terr_admi ");
            //consulta.append(" 			 and adm.IND_ACTI = 1  ");      // Comentado por HRCS - Incidencia SiCC20080606
            consulta.append(" 			 AND TER.OID_TERR = TERRI.TERR_OID_TERR  ");
            consulta.append("              AND terri.zscc_oid_secc = secc.oid_secc ");
            consulta.append("              AND adi.esta_oid_esta_clie = est.oid_esta_clie ");
            
            if( periodo != null){
                consulta.append("              AND periactual.oid_peri = ? ");
                parametros.add( periodo );
            }
            consulta.append("              AND secc.zzon_oid_zona = zon.oid_zona ");
            consulta.append("              AND periactual.fec_inic >= periini.fec_inic ");
            consulta.append("              AND (   (adm.perd_oid_peri_fin IS NULL) ");
            consulta.append("                   OR (    adm.perd_oid_peri_fin = perifin.oid_peri ");
            consulta.append("                       AND perifin.fec_fina >= periactual.fec_fina ");
            consulta.append("                      ) ");
            consulta.append("                  ) ");
            consulta.append("              AND est.oid_esta_clie = ? ");
            parametros.add(ConstantesMAE.OID_ESTATUS_EGRESADA);
            //consulta.append("              AND histo.clie_oid_clie = cli.oid_clie ");
            // gPineda - 06/03/2007 - Cambio pedido sobre Estatus de consultoras
            consulta.append("              AND adi.NUM_CAMP_SIN_PEDI = ? ");
            parametros.add(ConstantesINT.NRO_CAMP_SIN_PEDI);
            consulta.append("               AND terri.IND_BORR = 0 AND secc.IND_BORR = 0 AND secc.IND_ACTI = 1 AND ADI.IND_ACTI = 1 ");
            //consulta.append(" 			    and adm.IND_ACTI = 1  ");   // Comentado por HRCS - Incidencia SiCC20080606
            consulta.append("                   ) egresos, ");
            consulta.append("          (SELECT COUNT (DISTINCT ADI.CLIE_OID_CLIE)  ");
            consulta.append("             FROM mae_clien_unida_admin adm, ");
            consulta.append("                  mae_clien cli, ");
            consulta.append("                  mae_clien_datos_adici adi, ");
            consulta.append("                  mae_estat_clien est, ");
            consulta.append("                  cra_perio periini, ");
            consulta.append("                  cra_perio perifin, ");
            consulta.append("                  cra_perio periactual, ");
            consulta.append("                  zon_terri_admin terri, ");
            consulta.append("                  zon_secci secc ");
            consulta.append("            WHERE adm.clie_oid_clie = cli.oid_clie ");
            consulta.append("              AND adi.clie_oid_clie = cli.oid_clie ");
            consulta.append("              AND adm.perd_oid_peri_ini = periini.oid_peri ");
            consulta.append("              AND adm.ztad_oid_terr_admi = terri.oid_terr_admi ");
            consulta.append("              AND terri.zscc_oid_secc = secc.oid_secc ");
            consulta.append("              AND adi.esta_oid_esta_clie = est.oid_esta_clie ");
            consulta.append("              AND ter.oid_terr = terri.terr_oid_terr ");

            if( periodo != null ){
                consulta.append("              AND periactual.oid_peri = ? ");
                parametros.add( periodo );
            }
            consulta.append("              AND secc.zzon_oid_zona = zon.oid_zona ");
            consulta.append("              AND periactual.fec_inic >= periini.fec_inic ");
            consulta.append("              AND (   (adm.perd_oid_peri_fin IS NULL) ");
            consulta.append("                   OR (    adm.perd_oid_peri_fin = perifin.oid_peri ");
            consulta.append("                       AND perifin.fec_fina >= periactual.fec_fina ");
            consulta.append("                      ) ");
            consulta.append("                  ) ");
            //consulta.append("              AND adm.IND_ACTI = 1 "); // Comentado por HRCS - Incidencia SiCC20080606
            consulta.append("              AND terri.IND_BORR = 0 AND ADI.IND_ACTI = 1 ");
            consulta.append("              AND est.oid_esta_clie IN ( ?, ? ) ) ingresos, ");
            parametros.add(ConstantesMAE.OID_ESTATUS_NUEVA);
            parametros.add(ConstantesMAE.OID_ESTATUS_REACTIVADA);
            consulta.append("          (SELECT COUNT (DISTINCT ADI.CLIE_OID_CLIE)  ");
            consulta.append("             FROM mae_clien_unida_admin adm, ");
            consulta.append("                  mae_clien cli, ");
            consulta.append("                  mae_clien_datos_adici adi, ");
            consulta.append("                  mae_estat_clien est, ");
            consulta.append("                  cra_perio periini, ");
            consulta.append("                  cra_perio perifin, ");
            consulta.append("                  cra_perio periactual, ");
            consulta.append("                  zon_terri_admin terri, ");
            consulta.append("                  zon_secci secc ");
            consulta.append("            WHERE adm.clie_oid_clie = cli.oid_clie ");
            consulta.append("              AND adi.clie_oid_clie = cli.oid_clie ");
            consulta.append("              AND adm.perd_oid_peri_ini = periini.oid_peri ");
            consulta.append("              AND adm.ztad_oid_terr_admi = terri.oid_terr_admi ");
            consulta.append("              AND terri.zscc_oid_secc = secc.oid_secc ");
            consulta.append("              AND adi.esta_oid_esta_clie = est.oid_esta_clie ");
            
            if( periodo != null){
                consulta.append("              AND periactual.oid_peri = ? ");
                parametros.add( periodo );
            }
            
            consulta.append("              AND secc.zzon_oid_zona = zon.oid_zona ");
            consulta.append("              AND periactual.fec_inic >= periini.fec_inic ");
            consulta.append("              AND (   (adm.perd_oid_peri_fin IS NULL) ");
            consulta.append("                   OR (    adm.perd_oid_peri_fin = perifin.oid_peri ");
            consulta.append("                       AND perifin.fec_fina >= periactual.fec_fina ");
            consulta.append("                      ) ");
            consulta.append("                  ) ");
            consulta.append("              AND est.oid_esta_clie = ? ");
            parametros.add(ConstantesMAE.OID_ESTATUS_REINGRESADA);
            consulta.append("              AND TERRI.IND_BORR = 0 AND SECC.IND_BORR = 0 AND SECC.IND_ACTI = 1 ");
            //consulta.append(" 			   and adm.IND_ACTI = 1 "); // Comentado por HRCS - Incidencia SiCC20080606
            consulta.append("              AND ADI.IND_ACTI =1 ");
            consulta.append("              AND ter.oid_terr = terri.terr_oid_terr) reingresos, ");
            consulta.append("          (SELECT COUNT (*) ");
            consulta.append("             FROM mae_clien_unida_admin adm, ");
            consulta.append("                  zon_terri_admin terri, ");
            consulta.append("                  zon_secci secc, ");
            consulta.append("                  mae_clien_datos_adici adi ");
            consulta.append("            WHERE adi.clie_oid_clie = adm.clie_oid_clie ");
            
            if( periodo != null){
                consulta.append(" 			 AND adm.perd_oid_peri_ini = ?  ");
                parametros.add( periodo );
            }
            
            consulta.append("              AND adi.esta_oid_esta_clie != ? ");
            parametros.add(ConstantesMAE.OID_ESTATUS_NUEVA);
            consulta.append("              AND adi.esta_oid_esta_clie != ? ");
            parametros.add(ConstantesMAE.OID_ESTATUS_REGISTRADA);
            consulta.append("              AND adm.ztad_oid_terr_admi = terri.oid_terr_admi ");
            consulta.append("              AND terri.zscc_oid_secc = secc.oid_secc ");
            consulta.append("              AND ter.oid_terr = terri.terr_oid_terr ");
            consulta.append("              AND ADM.IND_ACTI = 1 AND TERRI.IND_BORR = 0 AND SECC.IND_ACTI = 1 AND SECC.IND_BORR = 0 AND ADI.IND_ACTI = 1 ");
            consulta.append("              AND secc.zzon_oid_zona = zon.oid_zona) rezonificadasrecibidas, ");
            consulta.append("          (SELECT COUNT (*) ");
            consulta.append("             FROM mae_clien_unida_admin adm, ");
            consulta.append("                  zon_terri_admin terri, ");
            consulta.append("                  zon_secci secc, ");
            consulta.append("                  mae_clien_datos_adici adi ");
            consulta.append("            WHERE adi.clie_oid_clie = adm.clie_oid_clie  ");
            
            if( periodo != null ){
                consulta.append("              AND adm.perd_oid_peri_fin = ? ");
                parametros.add( periodo );
            }
            consulta.append("              AND adi.esta_oid_esta_clie != ? ");
            parametros.add(ConstantesMAE.OID_ESTATUS_NUEVA);
            consulta.append("              AND adi.esta_oid_esta_clie != ? ");
            parametros.add(ConstantesMAE.OID_ESTATUS_REGISTRADA);
            consulta.append("              AND ter.oid_terr = terri.terr_oid_terr ");
            consulta.append("              AND adm.ztad_oid_terr_admi = terri.oid_terr_admi ");
            consulta.append("              AND terri.zscc_oid_secc = secc.oid_secc ");
            consulta.append("              AND TERRI.IND_BORR = 0 AND ADM.IND_ACTI = 1 AND SECC.IND_ACTI = 1 AND SECC.IND_BORR = 0 AND ADI.IND_ACTI = 1 ");
            consulta.append("              AND secc.zzon_oid_zona = zon.oid_zona) rezonificadasentregadas ");
            consulta.append("     FROM cra_perio peri, ");
            consulta.append(" 		 seg_marca sm, ");
            consulta.append("          seg_pais pai, ");
            consulta.append("          zon_regio reg, ");
            consulta.append("          zon_zona zon, ");
            consulta.append(" 		 zon_secci zs, ");
            consulta.append(" 		 ZON_TERRI_ADMIN zta, ");
            consulta.append(" 		 ZON_TERRI TER, ");
            // Cambio SiCC 20070125
            consulta.append(" 	    (SELECT DISTINCT CIE.ZORG_OID_REGI  ");
            consulta.append(" 		   FROM FAC_CONTR_CIERR cie, ");
            consulta.append("               FAC_TIPOS_CIERR tcie ");
            consulta.append(" 	      WHERE CIE.ZORG_OID_REGI IS NOT NULL  ");
            if( periodo != null ){
                consulta.append(" 		    AND CIE.PERD_OID_PERI = ? ");
                parametros.add( periodo );
            }
            consulta.append(" 		  AND cie.tcie_oid_tipo_cier = tcie.OID_TIPO_CIER ");
            consulta.append("         AND tcie.COD_TIPO_CIER = 'R' ) REGCIERRE ");
            
            consulta.append("    WHERE PERI.PAIS_OID_PAIS = PAI.OID_PAIS ");
            //fin cambio SiCC 20070125
            if( periodo != null ){
                consulta.append(" 	 AND PERI.OID_PERI = ? ");
                parametros.add( periodo );
            }
            consulta.append(" 	 and sm.oid_marc = peri.marc_oid_marc ");
            consulta.append(" 	 and zon.ZORG_OID_REGI = reg.OID_REGI ");
            consulta.append(" 	 and zs.ZZON_OID_ZONA = zon.OID_ZONA ");
            consulta.append(" 	 and zta.TERR_OID_TERR = TER.oid_terr ");
            consulta.append(" 	 and zta.ZSCC_OID_SECC = zs.oid_secc ");
            consulta.append(" 	 and zta.ind_borr = 0 ");
            consulta.append(" 	 and TER.IND_BORR = 0 ");
            consulta.append(" 	 AND TER.PAIS_OID_PAIS = PERI.PAIS_OID_PAIS ");
        	consulta.append(" 	 AND REGCIERRE.ZORG_OID_REGI = REG.OID_REGI ");// cambio SiCC 20070125
            consulta.append(" GROUP BY pai.cod_pais, ");
            consulta.append(" 	     pai.oid_pais, ");
            consulta.append("          peri.marc_oid_marc, ");
            consulta.append(" 		 sm.COD_MARC, ");
            consulta.append("          peri.cana_oid_cana, ");
            consulta.append("          PERI.OID_PERI, ");
            consulta.append("          reg.cod_regi, ");
            consulta.append(" 		 reg.oid_regi, ");
            consulta.append(" 		 zon.oid_zona,  ");
            consulta.append("          zon.cod_zona, ");
            consulta.append(" 		 ter.cod_terr, ");
            consulta.append("          ter.oid_terr ");
            consulta.append(" 		 )SAB27 ");
            //Fin Consulta
            
             BelcorpService bs = UtilidadesEJB.getBelcorpService();
             RecordSet rs = null;
             String codigoError = null;
             try{
                rs =bs.dbService.executePreparedQuery(consulta.toString().toUpperCase(),parametros);
                UtilidadesLog.warn(" obtenerFuenteVentaReal  SQL:" + consulta.toString().toUpperCase());
                UtilidadesLog.warn(" obtenerFuenteVentaReal parametros:" + parametros);
             }catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                UtilidadesLog.error(" obtenerFuenteVentaReal  : Exception",e);
                this.logSql(" obtenerFuenteVentaReal  SQL: ",consulta.toString().toUpperCase(),parametros);
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
             }//catch
             
             //UtilidadesLog.debug("rs: " + rs);
             
             FuenteVentasRealAcumulada fuenteVentas=null;
             if(rs!=null){           
               int n=rs.getRowCount();
                   for(int i=0;i<n;i++){
                   fuenteVentas=new FuenteVentasRealAcumulada();
                    if(rs.getValueAt(i,"CODIGOPAIS")!=null){
                        fuenteVentas.setCodigoPais((String)rs.getValueAt(i,"CODIGOPAIS"));
                    }
                    if(rs.getValueAt(i,"MARCA")!=null){                        
                        fuenteVentas.setMarca(new Long(((BigDecimal)rs.getValueAt(i,"MARCA")).longValue()));
                    }
                    if(rs.getValueAt(i,"CANAL")!=null){
                        //BELC300017190
                        fuenteVentas.setCanal(new Long(((BigDecimal)rs.getValueAt(i,"CANAL")).longValue()));                        
                    }
                    if(rs.getValueAt(i,"PERIODO")!=null){
                        fuenteVentas.setPeriodo(new Long(((BigDecimal)rs.getValueAt(i,"PERIODO")).longValue()));
                    }
                    if(rs.getValueAt(i,"CODIGOREGION")!=null){
                        fuenteVentas.setCodigoRegion((String)rs.getValueAt(i,"CODIGOREGION"));   
                    }
                    if(rs.getValueAt(i,"ZONA")!=null){
                        // BELC300017111
                        fuenteVentas.setZona(new Long(((BigDecimal)rs.getValueAt(i,"ZONA")).longValue()));
                    }
                    if(rs.getValueAt(i,"CODIGOZONA")!=null){
                        fuenteVentas.setCodigoZona((String)rs.getValueAt(i,"CODIGOZONA"));
                    }      
                    //Cambio
                    if(rs.getValueAt(i,"TERRITORIO")!=null){
                        fuenteVentas.setTerritorio(rs.getValueAt(i,"TERRITORIO").toString());
                    }      
                    
                    /*
                     * SC-INT-SAB-001-2 - dmorello, 12/05/2006
                     * Se quito el atributo marcaProducto de la clase FuenteVentasRealAcumulada.
                     */
                    /*
                    if(rs.getValueAt(i,"MARCAPRODUCTO")!=null){
                        fuenteVentas.setMarcaProducto(rs.getValueAt(i,"MARCAPRODUCTO").toString());
                    }*/                         
                    //---
                    if(rs.getValueAt(i,"ACTIVASINICIALES")!=null){
                        fuenteVentas.setActivasIniciales(new Long(((BigDecimal)rs.getValueAt(i,"ACTIVASINICIALES")).longValue()));
                    }
                    if(rs.getValueAt(i,"ACTIVASFINALES")!=null){
                        fuenteVentas.setActivasFinales(new Long(((BigDecimal)rs.getValueAt(i,"ACTIVASFINALES")).longValue()));
                    }
                    if(rs.getValueAt(i,"EGRESOS")!=null){
                        fuenteVentas.setEgresos(new Long(((BigDecimal)rs.getValueAt(i,"EGRESOS")).longValue()));
                    }
                    if(rs.getValueAt(i,"INGRESOS")!=null){
                        fuenteVentas.setIngresos(new Long(((BigDecimal)rs.getValueAt(i,"INGRESOS")).longValue()));
                    }
                    if(rs.getValueAt(i,"REINGRESOS")!=null){
                        fuenteVentas.setReingresos(new Long(((BigDecimal)rs.getValueAt(i,"REINGRESOS")).longValue()));
                    }
                    if(rs.getValueAt(i,"REZONIFICADASRECIBIDAS")!=null){
                        fuenteVentas.setRezonificadasRecibidas(new Long(((BigDecimal)rs.getValueAt(i,"REZONIFICADASRECIBIDAS")).longValue()));
                    }
                    if(rs.getValueAt(i,"REZONIFICADASENTREGADAS")!=null){
                        fuenteVentas.setRezonificadasEntregadas(new Long(((BigDecimal)rs.getValueAt(i,"REZONIFICADASENTREGADAS")).longValue()));
                    }
                    
                    //18713
                    if(rs.getValueAt(i,"OIDPAIS")!=null){
                        fuenteVentas.setPais(new Long(((BigDecimal)rs.getValueAt(i,"OIDPAIS")).longValue()));
                    }
                    if(rs.getValueAt(i,"OIDREGION")!=null){
                        fuenteVentas.setRegion(new Long(((BigDecimal)rs.getValueAt(i,"OIDREGION")).longValue()));
                    }

                    // 23122 - dmorello, 16/05/2006: Seteo en fuenteVentas el territorio
                    if(rs.getValueAt(i,"OIDTERRITORIO")!=null){
                        fuenteVentas.setOidTerritorio(new Long(((BigDecimal)rs.getValueAt(i,"OIDTERRITORIO")).longValue()));
                    }
                    
                    // 23122 - dmorello, 16/05/2006: Seteo el codigo de marca...
                    if(rs.getValueAt(i,"CODMARCA")!=null){
                        fuenteVentas.setCodMarca((String)rs.getValueAt(i,"CODMARCA"));
                    }
                    
                    //20070185 - hhernandez - 20070403
                     if(rs.getValueAt(i,"FECHACIERRE")!=null){
                        fuenteVentas.setFechaCierre(new Date(((java.sql.Date)rs.getValueAt(i,"FECHACIERRE")).getTime()));
                     }
                    //20070185 - hhernandez - 20070404
                    //fuenteVentas.setCanalBPS(ConstantesINT.CANAL_BPS);
                    //20070185 - hhernandez - 20070409
                    if(rs.getValueAt(i,"CANALBPS")!=null){
                        fuenteVentas.setCanalBPS(rs.getValueAt(i,"CANALBPS").toString());
                    }
                     
                    //20070185 - hhernandez - 20070409
                    if(rs.getValueAt(i,"CODIGOSOCIEDAD")!=null){
                        fuenteVentas.setCodigoSociedad(rs.getValueAt(i,"CODIGOSOCIEDAD").toString());
                    }
                     
                    //20070185 - hhernandez - 20070409
                    if(rs.getValueAt(i,"CODIGOALMACEN")!=null){
                        fuenteVentas.setCodigoAlmacen(rs.getValueAt(i,"CODIGOALMACEN").toString());
                    }
                    resultado.add(fuenteVentas);
                   }
             }
            
            UtilidadesLog.info("DAOINTSAPBPS.obtenerFuenteVentaReal(Long periodo): Salida");
            return resultado;
    }
    
    public void guardarFuenteVentaReal (ArrayList ventaReal, String anioComercial) throws  MareException{
        UtilidadesLog.info("DAOINTSAPBPS.guardarFuenteVentaReal(ArrayList ventaReal, String anioComercial): Entrada");
        
        if(ventaReal != null && !ventaReal.isEmpty()) {
            try {
                Context ctx =  new InitialContext();
            }
            catch (NamingException e) {
                throw new MareException("Excepción en método DAOINTSAPBPS.guardarFuenteVentaReal", e);
            }
            FuenteVentasRealLocalHome fVentaRealLocalHome = this.getFuenteVentasRealLocalHome();
            FuenteVentasRealLocal fVentaRealLocal = null;
                    
            // 23122 - dmorello, 15/05/2006: No se ordena la lista.
            //ventaReal = ordenaFuenteVentas(ventaReal);
            int tamano = ventaReal.size();
            UtilidadesLog.warn("       FVR se van a insertar "+ tamano + " filas en INT_FUENT_VENTAS_REAL");
            for(int i=0; i<tamano; i++) {
                FuenteVentasRealAcumulada venta = (FuenteVentasRealAcumulada)ventaReal.get(i);
                //UtilidadesLog.debug("Posición " + i + ": " + venta);
                //UtilidadesLog.warn("Posición " + i);
                
                /* dmorello, 04/01/2007 */
                //try {
                //    UtilidadesLog.debug("       FVR.create(UK: Pais_"+venta.getPais()+" Zona_"+venta.getZona()+" Region_"+venta.getRegion()+" Periodo_"+venta.getPeriodo() +" Territorio_"+venta.getOidTerritorio()+" )");
                //    fVentaRealLocal = fVentaRealLocalHome.create(venta.getZona(), venta.getPais(), venta.getPeriodo(), venta.getRegion(), venta.getOidTerritorio());
                //}
                //catch (CreateException e) {
                //    /*
                //     * SICC-GCC-INT-SAB-004 - dmorello, 06/12/2006
                //     * Si ya existe un registro, se actualiza con la nueva información.
                //     */
                //    UtilidadesLog.debug("Fallo el create por duplicacion de UK - Se actualiza el registro con los datos nuevos...");
                //    try {
                //        fVentaRealLocal = fVentaRealLocalHome.findByUK(venta.getPais(), venta.getPeriodo(), venta.getRegion(), venta.getZona(), venta.getOidTerritorio());
                //    } catch (FinderException fe) {
                //        throw new MareException("Excepción en método DAOINTSAPBPS.guardarFuenteVentaReal al realizar el findByUK", e);
                //    }
                //}
                try {
                    UtilidadesLog.debug("FVR.findByUK(UK: Pais_"+venta.getPais()+" Zona_"+venta.getZona()+" Region_"+venta.getRegion()+" Periodo_"+venta.getPeriodo() +" Territorio_"+venta.getOidTerritorio()+" )");
                    fVentaRealLocal = fVentaRealLocalHome.findByUK(venta.getPais(), venta.getPeriodo(), venta.getRegion(), venta.getZona(), venta.getOidTerritorio());
                } catch (NoResultException fe) {
                    try {
                        fVentaRealLocal = fVentaRealLocalHome.create(venta.getZona(), venta.getPais(), venta.getPeriodo(), venta.getRegion(), venta.getOidTerritorio());                            
                    } catch (PersistenceException e) {
                        throw new MareException("Error en DAOINTSAPBPS.guardarFuenteVentaREal al insertar nuevo registro en FVR", e);
                    }
                }  catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                if(anioComercial!=null) {
                    fVentaRealLocal.setAnnioComercial(new Integer(anioComercial));        
                }
                else{
                    fVentaRealLocal.setAnnioComercial(null);
                }
                fVentaRealLocal.setActivasIniciales(venta.getActivasIniciales());
                fVentaRealLocal.setActivasFinales(venta.getActivasFinales());
                fVentaRealLocal.setIngresos(venta.getIngresos());
                fVentaRealLocal.setReingresos(venta.getReingresos());
                fVentaRealLocal.setEgresos(venta.getEgresos());
                fVentaRealLocal.setRezonificadasEntregadas(venta.getRezonificadasEntregadas());
                fVentaRealLocal.setRezonificadasRecibidas(venta.getRezonificadasRecibidas());
                fVentaRealLocal.setZona(venta.getZona());
                fVentaRealLocal.setPais(venta.getPais());
                fVentaRealLocal.setPeriodo(venta.getPeriodo());
                fVentaRealLocal.setRegion(venta.getRegion());
                fVentaRealLocalHome.merge(fVentaRealLocal);
            }
            
        }
        
        UtilidadesLog.info("DAOINTSAPBPS.guardarFuenteVentaReal(ArrayList ventaReal, String anioComercial): Salida");
    }
    
    private FuenteVentasRealLocalHome getFuenteVentasRealLocalHome() throws MareException{
        return new FuenteVentasRealLocalHome();
    }
    
    /**
     * Datos utlizados para poder realizar las pruebas del metodo obtenerNumeroOrdenes
     * oidPeriodo = 57
     * oidPais = 1
     * fechaFacturacion = 2005-11-11
     */
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     */
    public Integer obtenerNumeroOrdenes(DTOEnviarPedidosSAP dtoe)throws MareException{
        UtilidadesLog.info("DAOINTSAPBPS.obtenerNumeroOrdenes(DTOEnviarPedidosSAP dtoe): Entrada");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT COUNT(*) FROM ( ");
        consulta.append(" 	SELECT "); 
        consulta.append(" 		sc.PAIS_OID_PAIS, sc.PERD_OID_PERI, "); 
        consulta.append(" 		sc.CLAS_OID_CLAS_FLET ");
        consulta.append(" 		,sc.ALMC_OID_ALMA, sc.SOCI_OID_SOCI, ");
        consulta.append(" 		sc.TSPA_OID_TIPO_SOLI_PAIS, sc.TICL_OID_TIPO_CLIE ");
        
        consulta.append(" 	FROM ");	
        consulta.append(" 		ped_solic_cabec sc ");

        consulta.append(" 	WHERE ");
       
        if (dtoe.getOidPais() != null){
            consulta.append(" 		sc.PAIS_OID_PAIS = ? AND ");
            parametros.add(dtoe.getOidPais());                           
        }        
        
        if (dtoe.getOidPeriodo() != null){
            consulta.append(" 		sc.PERD_OID_PERI = ? AND ");
            parametros.add(dtoe.getOidPeriodo());                           
        }           
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
        
        if (dtoe.getFechaFacturacion() != null){
            java.sql.Date fechaDesde = new java.sql.Date(dtoe.getFechaFacturacion().getTime());            
            String sFechaDesde = sdf.format(fechaDesde);    
            consulta.append(" 		(sc.FEC_FACT = TO_DATE ( ? , 'YYYY-MM-DD') )AND ");
            parametros.add(sFechaDesde);
        }                
        
        consulta.append(" 		sc.IND_TS_NO_CONSO = 1 AND ");
        consulta.append(" 		sc.IND_OC = 1 AND ");
        consulta.append(" 		sc.IND_PEDI_PRUE = 0 AND ");
        /* BELC300024595 - dmorello, 04/01/2007: Módulo no debe ser INC */
        //consulta.append(" 		sc.MODU_OID_MODU = ? ");
        consulta.append(" 		sc.MODU_OID_MODU != ? ");
        //parametros.add(new Long(ConstantesSEG.MODULO_PED));
        parametros.add(new Long(ConstantesSEG.MODULO_INC));
        /* Fin BELC300024595 dmorello 04/01/2007 */
        
        consulta.append(" 	GROUP BY ");
        consulta.append(" 		sc.PAIS_OID_PAIS, sc.PERD_OID_PERI, sc.CLAS_OID_CLAS_FLET,sc.ALMC_OID_ALMA, ");
        consulta.append(" 		      sc.SOCI_OID_SOCI,TSPA_OID_TIPO_SOLI_PAIS,sc.TICL_OID_TIPO_CLIE) ");
   
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerNumeroOrdenes: Exception",e);
            this.logSql(" obtenerNumeroOrdenes. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        Integer resultado = null;
        
        if (rs != null){
            if (rs.getValueAt(0,0) != null)
                resultado = new Integer(((BigDecimal)rs.getValueAt(0,0)).intValue());                                    
        }

        UtilidadesLog.info("DAOINTSAPBPS.obtenerNumeroOrdenes(DTOEnviarPedidosSAP dtoe): Salida");   
        return resultado;
    }
    
    /**
     * BELC300024598 - dmorello, 04/01/2007: Se cambia el tipo de objeto retornado
     * pasando de ArrayList a HashMap
     */
    public HashMap obtenerDatosPedSAP (DTOEnviarPedidosSAP dtoe) 
		throws MareException{
        UtilidadesLog.info("DAOINTSAPBPS.obtenerDatosPedSAP(DTOEnviarPedidosSAP dtoe): Entrada");
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		
    /* BELC300024598 - dmorello, 04/01/2007 */
    //ArrayList datosRetorno = null;
    HashMap hashRetorno = null;
		
		consulta.append(" SELECT SC.PAIS_OID_PAIS, SC.PERD_OID_PERI, ");
		consulta.append(" SC.SBAC_OID_SBAC, SC.ALMC_OID_ALMA, SC.SOCI_OID_SOCI, ");
		consulta.append(" SC.TSPA_OID_TIPO_SOLI_PAIS , SC.TICL_OID_TIPO_CLIE ");
    
    /* gPineda - 25/01/2007 
     * Se filtraran los que no sean de la fecha de facturacion.
    /*
     * BELC300024598 - dmorello, 04/01/2007
     * Para cada agrupación se contarán las solicitudes que fueron facturadas
     * en la fecha que viene en el DTO
     * /
    consulta.append(" , SUM (CASE WHEN sc.fec_fact = TO_DATE (?, 'DD/MM/YYYY')");
    parametros.add(new SimpleDateFormat("dd/MM/yyyy").format(dtoe.getFechaFacturacion()));
    consulta.append("       THEN 1 ELSE 0 END) AS numordenesdia ");*/
    consulta.append(" , COUNT(sc.OID_SOLI_CABE ) AS numordenesdia  ");
    
		consulta.append(" FROM PED_SOLIC_CABEC SC ");
		consulta.append(" WHERE SC.IND_TS_NO_CONSO = 1 AND SC.IND_OC = 1 ");
        consulta.append(" AND sc.fec_fact = TO_DATE (?, 'DD/MM/YYYY') ");
        parametros.add(new SimpleDateFormat("dd/MM/yyyy").format(dtoe.getFechaFacturacion()));
    /*
     * BELC300024598 - dmorello, 04/01/2007
     * Se filtra por módulo <> INC
     * Se toman solo registros con fecha facturacion no nula
     */
    //consulta.append(" AND SC.IND_PEDI_PRUE = 0 AND SC.MODU_OID_MODU = ? ");
		//parametros.add(new Long(ConstantesSEG.MODULO_PED));
		consulta.append(" AND SC.IND_PEDI_PRUE = 0 AND SC.MODU_OID_MODU != ? ");
		parametros.add(new Long(ConstantesSEG.MODULO_INC));
    consulta.append(" AND SC.FEC_FACT IS NOT NULL ");
    /* Fin dmorello 04/01/2007 */
		
    if(dtoe != null){
			if(dtoe.getOidPais() != null){
			  consulta.append(" AND SC.PAIS_OID_PAIS = ? ");
			  parametros.add(dtoe.getOidPais());
			}
			if(dtoe.getOidPeriodo() != null){
			  consulta.append(" AND SC.PERD_OID_PERI = ? ");
			  parametros.add(dtoe.getOidPeriodo());
			}
		}
    
    /* Bloq. SiCC-GCC-SAB-01  23/05/2006 @eiraola */
    consulta.append(" GROUP BY SC.PAIS_OID_PAIS, SC.PERD_OID_PERI,  ");
    consulta.append("    SC.SBAC_OID_SBAC, SC.ALMC_OID_ALMA, SC.SOCI_OID_SOCI,  ");
    consulta.append("    SC.TSPA_OID_TIPO_SOLI_PAIS, SC.TICL_OID_TIPO_CLIE");    
    
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try{
		  rs =bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		}catch (Exception e) {
		  codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
		  UtilidadesLog.error(" obtenerDatosPedSAP: Exception",e);
		  this.logSql(" obtenerDatosPedSAP. SQL: ", consulta.toString(),parametros);
		  throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));  
		}//catch
		
    /* BELC300024598 - dmorello, 28/12/2006 */
    //datosRetorno = new ArrayList();
    hashRetorno = new HashMap();
		
    
    if(rs != null /*&& !rs.esVacio()*/){
			int numResultados = rs.getRowCount();
      StringBuffer sb = new StringBuffer();
			for(int i=0; i < numResultados; i++){
				DTODatosPedSAP dTODatosPedSAP = new DTODatosPedSAP();
				if (rs.getValueAt(i, "PAIS_OID_PAIS") != null)  {
					dTODatosPedSAP.setOidPais(new Long(((BigDecimal)rs.getValueAt(i, "PAIS_OID_PAIS")).longValue()));
				}
				if (rs.getValueAt(i, "PERD_OID_PERI") != null)  {
					dTODatosPedSAP.setOidPeriodo(new Long(((BigDecimal)rs.getValueAt(i, "PERD_OID_PERI")).longValue()));
				}
				if (rs.getValueAt(i, "SBAC_OID_SBAC") != null)  {
					dTODatosPedSAP.setOidSubAcceso(new Long(((BigDecimal)rs.getValueAt(i, "SBAC_OID_SBAC")).longValue()));
				}
				if (rs.getValueAt(i, "ALMC_OID_ALMA") != null)  {
					dTODatosPedSAP.setOidAlmacen(new Long(((BigDecimal)rs.getValueAt(i, "ALMC_OID_ALMA")).longValue()));
				}
				if (rs.getValueAt(i, "SOCI_OID_SOCI") != null)  {
					dTODatosPedSAP.setOidSociedad(new Long(((BigDecimal)rs.getValueAt(i, "SOCI_OID_SOCI")).longValue()));
				}
				if (rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS") != null)  {
					dTODatosPedSAP.setOidTipoSolicitud(new Long(((BigDecimal)rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS")).longValue()));
				}
				if (rs.getValueAt(i, "TICL_OID_TIPO_CLIE") != null)  {
					dTODatosPedSAP.setOidTipoCliente(new Long(((BigDecimal)rs.getValueAt(i, "TICL_OID_TIPO_CLIE")).longValue()));
				}

        /*
         * BELC300024598 - dmorello, 04/01/2007
         * Agrego al DTO el numero de ordenes y armo la key con los restantes
         * atributos del DTO para guardar en el HashMap
         */
        if (rs.getValueAt(i, "NUMORDENESDIA") != null) {
            dTODatosPedSAP.setNumOrdenesDia(new Long(((BigDecimal)rs.getValueAt(i, "NUMORDENESDIA")).longValue()));
        }
         
        sb.delete(0,sb.length());
        sb.append(dTODatosPedSAP.getOidPais()).append('|');
        sb.append(dTODatosPedSAP.getOidPeriodo()).append('|');
        sb.append(dTODatosPedSAP.getOidSubAcceso()).append('|');
        sb.append(dTODatosPedSAP.getOidAlmacen()).append('|');
        sb.append(dTODatosPedSAP.getOidSociedad()).append('|');
        sb.append(dTODatosPedSAP.getOidTipoSolicitud()).append('|');
        sb.append(dTODatosPedSAP.getOidTipoCliente());
        
        UtilidadesLog.debug("Voy a guardar en el hashmap con la clave: " + sb);
        String key = sb.toString();
        UtilidadesLog.debug("hashCode: " + key.hashCode());
        
        hashRetorno.put(key, dTODatosPedSAP);
        
        //datosRetorno.add(dTODatosPedSAP);
        
        
			}//for
		}//if(rs!=null)
	
		UtilidadesLog.info("DAOINTSAPBPS.obtenerDatosPedSAP(DTOEnviarPedidosSAP dtoe): Salida");
		//return datosRetorno;
    return hashRetorno;
	}//obtenerDatosPedSAP
    
     
    //Datos Pruebas : PAIS = 1, PERIODO = 57
    public Integer obtenerNumeroPedidos (DTOEnviarPedidosSAP dtoe) throws MareException{
        UtilidadesLog.info("DAOINTSAPBPS.obtenerNumeroPedidos(DTOEnviarPedidosSAP dtoe): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append(" SELECT COUNT(DISTINCT CLI.COD_CLIE)  ");          
        consulta.append(" FROM   MAE_CLIEN CLI, PED_SOLIC_CABEC SLC  ");
        
        /* SICC-GCC-INT-SAB-004 - dmorello, 04/12/2006 */
        consulta.append(" , PED_TIPO_SOLIC_PAIS TSP, PED_TIPO_SOLIC TS ");
        
        consulta.append(" WHERE  CLI.OID_CLIE = SLC.CLIE_OID_CLIE AND IND_TS_NO_CONSO = 1  ");
        consulta.append("        AND SLC.IND_OC = 1 AND SLC.IND_PEDI_PRUE = 0  ");

        consulta.append("        AND MODU_OID_MODU = ?  ");
        parametros.add(new Long(ConstantesSEG.MODULO_PED));
        
        if(dtoe != null && dtoe.getOidPais() != null){
            consulta.append("    AND SLC.PAIS_OID_PAIS = ? ");
            parametros.add(dtoe.getOidPais());
        }

        if(dtoe != null && dtoe.getOidPeriodo() != null){
            consulta.append("    AND SLC.PERD_OID_PERI = ? ");
            parametros.add(dtoe.getOidPeriodo());
        }
        
        /* SICC-GCC-INT-SAB-004 - dmorello, 04/12/2006 */
        consulta.append("        AND SLC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        consulta.append("        AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        consulta.append("        AND TS.IND_ANUL = 0 ");
        consulta.append("        AND TS.IND_DEVO = 0 ");
        // Fin SAB-004 dmorello 04/12/2006

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
            rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }
        catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerNumeroPedidos: Exception",e);
            this.logSql(" obtenerNumeroPedidos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        Integer resultado = new Integer(0);
        if(rs != null){
            if(rs.getValueAt(0,0) != null){
                resultado = new Integer(((BigDecimal) rs.getValueAt(0,0)).intValue());
            }
        }
        UtilidadesLog.info("DAOINTSAPBPS.obtenerNumeroPedidos(DTOEnviarPedidosSAP dtoe): Salida");
        return resultado;
         
    }
    
    
    /**
    * @cambio Se realizan dos query nuevas para obtener informacion a nivel cabeceras y posiones.
    *         A nivel posiciones de obtienes las unidades y las ventas netas.
    *         A nivel cabecera se obienen las zonas facturadas, numero de ordenes y de pedidos.
    * @autor gdmarzi
    * Criterio de agrupacion: canal, pais, sociedad, centro(almacen), medio(canalbps), añoComercial, campaña.
    */
    public ArrayList obtenerVentasTotalesCampania(Long periodo) throws MareException {
        UtilidadesLog.info("DAOINTSAPBPS.obtenerVentasTotalesCampania(Long periodo): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs;
        RecordSet rsCabeceras;
        VentaTotalCampania ventaTotal;
        ArrayList resultado = new ArrayList();
        StringBuffer consulta = new StringBuffer();
        StringBuffer query = new StringBuffer();

        /*
         * 1.- Consulta a nivel posiciones de solicitud.
         */
        consulta.append(" SELECT ");
        consulta.append("   pai.cod_pais codigopais, ");
        consulta.append("   soc.almc_oid_alma almacen, ");
        consulta.append("   alm.cod_alma codigoalmacen, ");
        consulta.append("   canalbps.val_cana_bps canalbps, ");
        consulta.append("   codmediosap.val_medi codigomedio, ");
        consulta.append("   soc.soci_oid_soci sociedad, ");
        consulta.append("   soci.cod_soci codigosociedad, ");
        consulta.append("   periodo.cana_oid_cana canal, ");
        consulta.append("   SUM (CASE WHEN num_unid_vend = 1 AND soc.ind_oc = 1 THEN posi.num_unid_aten ELSE 0 END) AS unidadesVendidasVendidas, ");
        //Gacevedo 21/03/2007 Modificado segun correo de Sandra Woolcott (se cambian num_unid_aten POR NUM_UNID_DEMA_REAL)
        consulta.append("   SUM (CASE WHEN num_unid_falt = 1 AND soc.ind_oc = 1 THEN (posi.NUM_UNID_DEMA_REAL - posi.num_unid_compr) ELSE 0 END) AS unidadesVendidasFaltantes, ");
        //****************************************************************************************************************
        consulta.append("   ABS (SUM (CASE WHEN num_unid_devu = 1 AND soc.modu_oid_modu = " + ConstantesSEG.MODULO_REC + " THEN posi.num_unid_aten ELSE 0 END)) AS unidadesVendidasDevueltas, ");
        consulta.append("   ABS (SUM (CASE WHEN num_unid_anul = 1 AND soc.modu_oid_modu = " + ConstantesSEG.MODULO_REC + " THEN posi.num_unid_aten ELSE 0 END)) AS unidadesVendidasAnuladas, ");
        consulta.append("   ABS (SUM (CASE WHEN num_unid_canj = 1 AND soc.modu_oid_modu = " + ConstantesSEG.MODULO_REC + " THEN posi.num_unid_aten ELSE 0 END)) AS unidadesVendidasCanje, ");
        consulta.append("   ABS (SUM (CASE WHEN num_unid_true = 1 AND soc.modu_oid_modu = " + ConstantesSEG.MODULO_REC + " THEN posi.num_unid_aten ELSE 0 END)) AS unidadesVendidasTrueque, ");
        consulta.append("   SUM (CASE WHEN num_unid_vend = 1 AND soc.ind_oc = 1 AND posi.val_prec_cata_unit_loca <> 0 THEN posi.val_prec_neto_tota_loca ELSE 0 END) AS ventaNetaVendidas, ");
        //Gacevedo 21/03/2007 Modificado segun correo de Sandra Woolcott (se cambian num_unid_aten POR NUM_UNID_DEMA_REAL)
        consulta.append("   SUM (CASE WHEN num_unid_falt = 1 AND soc.ind_oc = 1 AND posi.val_prec_cata_unit_loca<>0 THEN   (posi.NUM_UNID_DEMA_REAL - posi.num_unid_compr) * posi.val_prec_neto_unit_loca ELSE 0 END) AS ventaNetaFaltantes, ");
        //*****************************************************************************************************************
        consulta.append("   ABS (SUM (CASE WHEN num_unid_devu = 1 AND soc.modu_oid_modu = " + ConstantesSEG.MODULO_REC + " AND posi.val_prec_cata_unit_loca <> 0 THEN posi.val_prec_neto_tota_loca ELSE 0 END)) AS ventaNetaDevueltas, ");
        consulta.append("   ABS (SUM (CASE WHEN num_unid_anul = 1 AND soc.modu_oid_modu = " + ConstantesSEG.MODULO_REC + " AND posi.val_prec_cata_unit_loca <> 0 THEN posi.val_prec_neto_tota_loca ELSE 0 END)) AS ventaNetaAnuladas, ");
        consulta.append("   ABS (SUM (CASE WHEN num_unid_canj = 1 AND soc.modu_oid_modu = " + ConstantesSEG.MODULO_REC + " AND posi.val_prec_cata_unit_loca <> 0 THEN posi.val_prec_neto_tota_loca ELSE 0 END)) AS ventaNetaCanje, ");
        consulta.append("   ABS (SUM (CASE WHEN num_unid_true = 1 AND soc.modu_oid_modu = " + ConstantesSEG.MODULO_REC + " AND posi.val_prec_cata_unit_loca <> 0 THEN posi.val_prec_neto_tota_loca ELSE 0 END)) AS ventaNetaTrueque, ");
        consulta.append("   SUM (CASE WHEN NUM_UNID_VEND = 1 AND soc.ind_oc = 1 THEN posi.VAL_PREC_CATA_TOTA_LOCA ELSE 0 END) AS ventaBrutaReal, ");
        consulta.append("   SUM(CASE WHEN NUM_UNID_FALT = 1 AND soc.ind_oc = 1 THEN (posi.num_unid_dema_real - posi.num_unid_compr) * posi.val_prec_cata_unit_loca ELSE 0 END) AS ventaBrutaFaltante ");
        consulta.append(" FROM ");
        consulta.append("   ped_solic_cabec soc, ");           
        consulta.append("   ped_solic_posic posi, ");
        consulta.append("   ped_tipo_solic_pais tsolp, ");                                                
        consulta.append("   int_param_tipo_solic ptsol, ");                                              
        consulta.append("   mae_clien cli, ");                                             
        consulta.append("   seg_pais pai, ");                                            
        consulta.append("   seg_socie soci, ");                                            
        consulta.append("   bel_almac alm, ");                                           
        consulta.append("   int_codig_medio_sapbp codmediosap, ");                                           
        consulta.append("   int_canal_bps canalbps, ");                                     
        consulta.append("   cra_perio periodo, ");                               
        consulta.append("   ped_tipo_solic tsol ");
        consulta.append(" WHERE "); 
        consulta.append("   ptsol.tspa_oid_tipo_soli_pais = tsolp.oid_tipo_soli_pais ");
        consulta.append("   AND posi.soca_oid_soli_cabe = soc.oid_soli_cabe ");
        consulta.append("   AND soc.clie_oid_clie = cli.oid_clie ");
        consulta.append("   AND soc.tspa_oid_tipo_soli_pais = tsolp.oid_tipo_soli_pais ");
        consulta.append("   AND soc.pais_oid_pais = pai.oid_pais ");
        consulta.append("   AND soc.soci_oid_soci = soci.oid_soci ");
        consulta.append("   AND soc.almc_oid_alma = alm.oid_alma ");
        consulta.append("   AND soc.pais_oid_pais = codmediosap.pais_oid_pais ");
        consulta.append("   AND soc.sbac_oid_sbac = codmediosap.sbac_oid_sbac ");
        consulta.append("   AND soc.ticl_oid_tipo_clie = canalbps.ticl_oid_tipo_clie ");
        consulta.append("   AND soc.tspa_oid_tipo_soli_pais = canalbps.tspa_oid_tipo_soli_pais ");
        consulta.append("   AND soc.perd_oid_peri = periodo.oid_peri ");
        consulta.append("   AND soc.perd_oid_peri =" + periodo );
        consulta.append("   AND soc.fec_fact IS NOT NULL ");
        consulta.append("   AND soc.ind_ts_no_conso = 1 ");
        consulta.append("   AND soc.ind_pedi_prue = 0 ");
        consulta.append("   AND posi.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
        consulta.append("   AND tsolp.tsol_oid_tipo_soli = tsol.oid_tipo_soli ");
        consulta.append("   AND posi.OFDE_OID_DETA_OFER is not null ");
        consulta.append("   AND ( ");
        consulta.append("         ( ");
        consulta.append("            PTSOL.NUM_UNID_VEND = 1 ");
        consulta.append("            AND tsol.IND_ANUL = 0 ");
        consulta.append("            AND tsol.IND_DEVO = 0 ");
        consulta.append("            AND soc.IND_OC = 1 ");
        consulta.append("         ) OR ( ");
        consulta.append("            PTSOL.NUM_UNID_FALT = 1  ");
        consulta.append("            AND tsol.IND_ANUL = 0 ");
        consulta.append("            AND tsol.IND_DEVO = 0 ");
        consulta.append("            AND soc.IND_OC = 1 ");
        consulta.append("         ) OR ( ");
        consulta.append("            PTSOL.NUM_UNID_DEVU = 1  ");
        consulta.append("            AND soc.IND_OC = 1 ");
        //(05-07-2007) agregado por Sapaza, incidencia SiCC-20070309        
        consulta.append("            AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc.OID_SOLI_CABE, posi.OID_SOLI_POSI)>0 ");        
        consulta.append("         ) OR ( ");
        consulta.append("            PTSOL.NUM_UNID_ANUL = 1  ");
        consulta.append("            AND soc.IND_OC = 1 ");
        //(18-07-2007) agregado por Sapaza, incidencia SiCC-20070309        
        consulta.append("            AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(soc.OID_SOLI_CABE, posi.OID_SOLI_POSI)>0 ");        
        consulta.append("         ) OR ( ");
        consulta.append("            PTSOL.NUM_UNID_CANJ = 1  ");
        consulta.append("            AND tsol.IND_ANUL = 0 ");
        consulta.append("            AND tsol.IND_DEVO = 0 ");
        consulta.append("            AND soc.IND_OC = 0 ");
        consulta.append("         ) OR ( ");
        consulta.append("            PTSOL.NUM_UNID_TRUE = 1 ");
        consulta.append("            AND tsol.IND_ANUL = 0 ");
        consulta.append("            AND tsol.IND_DEVO = 0 ");
        consulta.append("            AND soc.IND_OC = 0 ");
        consulta.append("         ) ");
        consulta.append("   )");
        consulta.append(" GROUP BY ");                                                             
        consulta.append("    soc.pais_oid_pais, ");
        consulta.append("    pai.cod_pais, ");
        consulta.append("    periodo.cana_oid_cana, ");
        consulta.append("    soc.soci_oid_soci, ");
        consulta.append("    soci.cod_soci, ");
        consulta.append("    soc.almc_oid_alma, ");
        consulta.append("    alm.cod_alma, ");
        consulta.append("    canalbps.val_cana_bps, ");
        consulta.append("    codmediosap.val_medi ");
        consulta.append(" ORDER BY ");                                                             
        consulta.append("    soc.pais_oid_pais, ");
        consulta.append("    periodo.cana_oid_cana, ");
        consulta.append("    soc.soci_oid_soci, ");
        consulta.append("    soc.almc_oid_alma, ");
        consulta.append("    canalbps.val_cana_bps, ");
        consulta.append("    codmediosap.val_medi ");
        
        try{
           rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        /*
         * 2.- Consulta a nivel cabeceras de solicitud.
         */
        query.append(" SELECT ");
        query.append("   COUNT (DISTINCT oid_soli_cabe) numeroordenes, ");
        query.append("   COUNT (DISTINCT clie_oid_clie) numeropedidos, ");
        query.append("   COUNT (DISTINCT zzon_oid_zona) numerozonasfacturadas ");
        query.append(" FROM ");
        query.append("   ped_solic_cabec soc, ");
        query.append("   cra_perio peri, ");
        query.append("   int_codig_medio_sapbp codmediosap, ");
        query.append("   int_canal_bps canalbps, ");
        query.append("   ped_tipo_solic_pais tsp, ");
        query.append("   ped_tipo_solic ts ");
        query.append(" WHERE ");
        query.append("   perd_oid_peri = " + periodo);
        query.append("   AND soc.fec_fact IS NOT NULL ");
        query.append("   AND peri.oid_peri = soc.perd_oid_peri ");
        query.append("   AND soc.pais_oid_pais = codmediosap.pais_oid_pais ");
        query.append("   AND soc.sbac_oid_sbac = codmediosap.sbac_oid_sbac ");
        query.append("   AND soc.ticl_oid_tipo_clie = canalbps.ticl_oid_tipo_clie ");
        query.append("   AND soc.tspa_oid_tipo_soli_pais = canalbps.tspa_oid_tipo_soli_pais ");
        query.append("   AND soc.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        query.append("   AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli ");
        query.append("   AND ind_oc = 1 ");
        query.append("   AND soc.ind_ts_no_conso = 1 ");
        query.append("   AND soc.ind_pedi_prue = 0 ");
        query.append("   AND soc.fec_fact IS NOT NULL ");
        query.append("   AND ts.ind_anul = 0 ");
        query.append("   AND ts.ind_devo = 0 ");
        query.append("   AND modu_oid_modu <> " + ConstantesSEG.MODULO_REC );
        query.append(" GROUP BY ");
        query.append("    soc.pais_oid_pais, ");
        query.append("    peri.cana_oid_cana, ");
        query.append("    soc.soci_oid_soci, ");
        query.append("    soc.almc_oid_alma, ");
        query.append("    canalbps.val_cana_bps, ");
        query.append("    codmediosap.val_medi ");
        query.append(" ORDER BY ");                                                             
        query.append("    soc.pais_oid_pais, ");
        query.append("    peri.cana_oid_cana, ");
        query.append("    soc.soci_oid_soci, ");
        query.append("    soc.almc_oid_alma, ");
        query.append("    canalbps.val_cana_bps, ");
        query.append("    codmediosap.val_medi ");

        try{
           rsCabeceras = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        /*
         * Completamos cada Venta Total Campania con las consulta a nivel posicion y cabecera.
         * Las consultas poseen el mismo orden para obtener la informacion de manera agrupada.
         */
        for (int i=0; i < rs.getRowCount(); i++) {
            ventaTotal = new VentaTotalCampania();              
            /*
             * Sobre query de datos a nivel posiciones de solicitud.
             */
            if(rs.getValueAt(i,"CODIGOPAIS")!=null){
                ventaTotal.setCodigoPais((String)rs.getValueAt(i,"CODIGOPAIS"));
            }
            if(rs.getValueAt(i,"ALMACEN")!=null){
                ventaTotal.setAlmacen(new Long(((BigDecimal)rs.getValueAt(i,"ALMACEN")).longValue()));
            }
            if(rs.getValueAt(i,"CODIGOALMACEN")!=null){
                ventaTotal.setCodigoAlmacen((String)rs.getValueAt(i,"CODIGOALMACEN"));
            }
            if(rs.getValueAt(i,"CANALBPS")!=null){
                ventaTotal.setCanalBPS((String)rs.getValueAt(i,"CANALBPS"));
            }
            if(rs.getValueAt(i,"CODIGOMEDIO")!=null){
                ventaTotal.setCodigoMedio((String)rs.getValueAt(i,"CODIGOMEDIO"));
            }
            if(rs.getValueAt(i,"SOCIEDAD")!=null){
                ventaTotal.setSociedad(new Long(((BigDecimal)rs.getValueAt(i,"SOCIEDAD")).longValue()));
            }
            if(rs.getValueAt(i,"CODIGOSOCIEDAD")!=null){
                ventaTotal.setCodigoSociedad((String)rs.getValueAt(i,"CODIGOSOCIEDAD"));
            }
            if (rs.getValueAt(i, "UNIDADESVENDIDASVENDIDAS") != null) {
                ventaTotal.setUnidadesVendidasVendidas(new Long(((BigDecimal)rs.getValueAt(i, "UNIDADESVENDIDASVENDIDAS")).longValue()));
            }
            if (rs.getValueAt(i, "UNIDADESVENDIDASFALTANTES") != null) {
                ventaTotal.setUnidadesVendidasFaltantes(new Long(((BigDecimal)rs.getValueAt(i, "UNIDADESVENDIDASFALTANTES")).longValue()));
            }
            if (rs.getValueAt(i, "UNIDADESVENDIDASDEVUELTAS") != null) {
                ventaTotal.setUnidadesVendidasDevueltas(new Long(((BigDecimal)rs.getValueAt(i, "UNIDADESVENDIDASDEVUELTAS")).longValue()));
            }
            if (rs.getValueAt(i, "UNIDADESVENDIDASANULADAS") != null) {
                ventaTotal.setUnidadesVendidasAnuladas(new Long(((BigDecimal)rs.getValueAt(i, "UNIDADESVENDIDASANULADAS")).longValue()));
            }
            if (rs.getValueAt(i, "UNIDADESVENDIDASCANJE") != null) {
                ventaTotal.setUnidadesVendidasCanje(new Long(((BigDecimal)rs.getValueAt(i, "UNIDADESVENDIDASCANJE")).longValue()));
            }
            if (rs.getValueAt(i, "UNIDADESVENDIDASTRUEQUE") != null) {
                ventaTotal.setUnidadesVendidasTrueque(new Long(((BigDecimal)rs.getValueAt(i, "UNIDADESVENDIDASTRUEQUE")).longValue()));
            }
            if (rs.getValueAt(i, "VENTANETAVENDIDAS") != null) {
                ventaTotal.setPrecioFacturaTotalLocalVendidas((BigDecimal)rs.getValueAt(i, "VENTANETAVENDIDAS"));
            }
            if (rs.getValueAt(i, "VENTANETAFALTANTES") != null) {
                ventaTotal.setPrecioFacturaTotalLocalFaltantes((BigDecimal)rs.getValueAt(i, "VENTANETAFALTANTES"));
            }
            if (rs.getValueAt(i, "VENTANETADEVUELTAS") != null) {
                ventaTotal.setPrecioFacturaTotalLocalDevueltas((BigDecimal)rs.getValueAt(i, "VENTANETADEVUELTAS"));
            }
            if (rs.getValueAt(i, "VENTANETAANULADAS") != null) {
                ventaTotal.setPrecioFacturaTotalLocalAnuladas((BigDecimal)rs.getValueAt(i, "VENTANETAANULADAS"));
            }
            if (rs.getValueAt(i, "VENTANETACANJE") != null) {
                ventaTotal.setPrecioFacturaTotalLocalCanje((BigDecimal)rs.getValueAt(i, "VENTANETACANJE"));
            }
            if (rs.getValueAt(i, "VENTANETATRUEQUE") != null) {
                ventaTotal.setPrecioFacturaTotalLocalTrueque((BigDecimal)rs.getValueAt(i, "VENTANETATRUEQUE"));
            }
            if (rs.getValueAt(i, "VENTABRUTAREAL") != null) {
                ventaTotal.setPrecioCatalogoTotalLocalVendidas((BigDecimal)rs.getValueAt(i, "VENTABRUTAREAL"));
            }
            if (rs.getValueAt(i, "VENTABRUTAFALTANTE") != null) {
                ventaTotal.setPrecioCatalogoTotalLocalFaltantes((BigDecimal)rs.getValueAt(i, "VENTABRUTAFALTANTE"));
            }
            /*
             * Sobre query de datos a nivel cabeceras de solicitud.
             */
            if(rsCabeceras.getValueAt(i,"NUMEROORDENES")!=null){
                ventaTotal.setNumeroOrdenes(new Long(((BigDecimal)rsCabeceras.getValueAt(i,"NUMEROORDENES")).longValue()));
            }
            if(rsCabeceras.getValueAt(i,"NUMEROPEDIDOS")!=null){
                ventaTotal.setNumeroPedidos(new Long(((BigDecimal)rsCabeceras.getValueAt(i,"NUMEROPEDIDOS")).longValue()));
            }               
            if(rsCabeceras.getValueAt(i,"NUMEROZONASFACTURADAS")!=null){
                ventaTotal.setNumeroZonas(new Long(((BigDecimal)rsCabeceras.getValueAt(i,"NUMEROZONASFACTURADAS")).longValue()));
            }
            resultado.add(ventaTotal);
        }
        UtilidadesLog.info("DAOINTSAPBPS.obtenerVentasTotalesCampania(Long periodo): Salida");
        return resultado;
    }


    public ArrayList obtenerDemandaAnormal (Long periodo) throws MareException{
        UtilidadesLog.info("DAOINTSAPBPS.obtenerDemandaAnormal(Long periodo): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        // Consulta SQL (Incidencia BELC300016449)
        consulta.append(" SELECT ");
        consulta.append("   PAI.COD_PAIS CODIGOPAIS, ");
        consulta.append("   SOCI.COD_SOCI CODIGOSOCIEDAD, ");
        consulta.append("   ALM.COD_ALMA CODIGOALMACEN, ");
   
        consulta.append("   (SELECT CBPS.VAL_CANA_BPS ");
        consulta.append("    FROM INT_CANAL_BPS CBPS ");
        consulta.append("    WHERE CBPS.TSPA_OID_TIPO_SOLI_PAIS = SOC.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append("          AND CBPS.TICL_OID_TIPO_CLIE = SOC.TICL_OID_TIPO_CLIE ) CANALBPS, ");
		 
        consulta.append("   (SELECT SAP.VAL_MEDI ");
        consulta.append("    FROM INT_CODIG_MEDIO_SAPBP SAP ");
        consulta.append("    WHERE SOC.PAIS_OID_PAIS = SAP.PAIS_OID_PAIS ");
        consulta.append("          AND SOC.SBAC_OID_SBAC = SAP.SBAC_OID_SBAC) MEDIO, ");
        
        consulta.append("   PRO.COD_SAP CODIGOPRODUCTO, ");
        consulta.append("   TOFER.COD_TIPO_OFER CODIGOTIPOOFERTA, ");
        consulta.append("   CICL.COD_CICL_VIDA CODIGOCICLOVIDA, ");
        consulta.append("   FALT.COD_FALT CODIGODEMANDAANORMAL ");

        consulta.append(" FROM ");
        consulta.append("   PED_SOLIC_CABEC SOC, ");
        consulta.append("   PED_SOLIC_POSIC POS, ");
        consulta.append("   PED_TIPO_SOLIC TSOL, ");
        consulta.append("   SEG_PAIS PAI, ");
        consulta.append("   SEG_SOCIE SOCI, ");
        consulta.append("   CRA_PERIO PER, ");
        consulta.append("   BEL_ALMAC ALM, ");
        consulta.append("   PRE_OFERT_DETAL OFDE, ");
        consulta.append("   PRE_TIPO_OFERT TOFER, ");
        consulta.append("   PRE_CICLO_VIDA CICL, ");
        consulta.append("   MAE_PRODU PRO, ");
        consulta.append("   INT_CODIG_FABPS FALT ");
 
        consulta.append(" WHERE ");
        consulta.append("   POS.SOCA_OID_SOLI_CABE = SOC.OID_SOLI_CABE ");
        consulta.append("   AND SOC.PERD_OID_PERI = PER.OID_PERI ");
        consulta.append("   AND SOC.PAIS_OID_PAIS = PAI.OID_PAIS ");
        consulta.append("   AND SOC.SOCI_OID_SOCI = SOCI.OID_SOCI ");
        consulta.append("   AND SOC.ALMC_OID_ALMA = ALM.OID_ALMA ");
        consulta.append("   AND POS.OFDE_OID_DETA_OFER = OFDE.OID_DETA_OFER ");
        consulta.append("   AND OFDE.PROD_OID_PROD = PRO.OID_PROD ");
        consulta.append("   AND OFDE.CIVI_OID_CICLO_VIDA = CICL.OID_CICL_VIDA ");
        consulta.append("   AND OFDE.TOFE_OID_TIPO_OFER = TOFER.OID_TIPO_OFER ");  
        consulta.append("   AND FALT.TSPA_OID_TIPO_SOLI_PAIS = SOC.TSPA_OID_TIPO_SOLI_PAIS ");
        consulta.append("   AND FALT.TPOS_OID_TIPO_POSI = POS.TPOS_OID_TIPO_POSI ");
        
        if (periodo != null){
            consulta.append("   AND SOC.PERD_OID_PERI = ? ");
            parametros.add(periodo);
        }
        consulta.append("   AND SOC.FEC_FACT IS NOT NULL ");
        consulta.append("   AND SOC.IND_TS_NO_CONSO = 1 ");
        consulta.append("   AND SOC.IND_OC = 1 ");
        consulta.append("   AND SOC.IND_PEDI_PRUE = 0 ");
        consulta.append("   AND POS.ESPO_OID_ESTA_POSI <> ? ");
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
   
        consulta.append(" GROUP BY ");
        consulta.append("   SOC.PAIS_OID_PAIS, ");
        consulta.append("   PAI.COD_PAIS, ");
        consulta.append("   PER.MARC_OID_MARC, ");
        consulta.append("   PER.CANA_OID_CANA, ");
        consulta.append("   PER.ACCE_OID_ACCE, ");
        consulta.append("   SOC.SBAC_OID_SBAC, ");
        consulta.append("   SOC.PERD_OID_PERI, ");
        consulta.append("   ALM.COD_ALMA, ");
        consulta.append("   SOCI.COD_SOCI, ");
        consulta.append("   SOC.TSPA_OID_TIPO_SOLI_PAIS, ");
        consulta.append("   SOC.TICL_OID_TIPO_CLIE, ");
        consulta.append("   OFDE.VAL_CODI_VENT, ");
        consulta.append("   PRO.COD_SAP, ");
        consulta.append("   TOFER.COD_TIPO_OFER, ");
        consulta.append("   CICL.COD_CICL_VIDA, ");
        consulta.append("   POS.TPOS_OID_TIPO_POSI, ");
        consulta.append("   FALT.COD_FALT ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
            rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerDemandaAnormal: Exception",e);
            this.logSql(" obtenerDemandaAnormal. SQL: ",
            consulta.toString(),parametros);
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        ArrayList lista = new ArrayList();
        
        // Rellenamos el ArrayList con objetos 'DTOINTDemandaAnormal'
        if(rs != null){
            int x = rs.getRowCount();
            for(int i = 0; i < x; i++){
                DTOINTDemandaAnormal dto = new DTOINTDemandaAnormal();
                
                if(rs.getValueAt(i,"CANALBPS") != null){
                    dto.setCanalBPS(rs.getValueAt(i,"CANALBPS").toString());
                    
                    if(rs.getValueAt(i,"CODIGOPAIS") != null){                
                        dto.setCodigoPais(rs.getValueAt(i,"CODIGOPAIS").toString());
                    }
                    if(rs.getValueAt(i,"CODIGOSOCIEDAD") != null){
                        dto.setCodigoSociedad(rs.getValueAt(i,"CODIGOSOCIEDAD").toString());
                    }
                    if(rs.getValueAt(i,"CODIGOALMACEN") != null){
                        dto.setCodigoAlmacen(rs.getValueAt(i,"CODIGOALMACEN").toString());
                    }
                    if(rs.getValueAt(i,"MEDIO") != null){
                        dto.setMedio(rs.getValueAt(i,"MEDIO").toString());
                    }
                    if(rs.getValueAt(i,"CODIGOPRODUCTO") != null){
                        dto.setCodigoProducto(rs.getValueAt(i,"CODIGOPRODUCTO").toString());
                    }
                    if(rs.getValueAt(i,"CODIGOTIPOOFERTA") != null){
                        dto.setCodigoTipoOferta(rs.getValueAt(i,"CODIGOTIPOOFERTA").toString());
                    }
                    if(rs.getValueAt(i,"CODIGOCICLOVIDA") != null){
                        dto.setCodigoCicloVida(rs.getValueAt(i,"CODIGOCICLOVIDA").toString());
                    }
                    if(rs.getValueAt(i,"CODIGODEMANDAANORMAL") != null){
                        dto.setCodigoDemandaAnormal(rs.getValueAt(i,"CODIGODEMANDAANORMAL").toString());
                    }
                    lista.add(dto);
                }
            }
            
        }
        
        UtilidadesLog.info("DAOINTSAPBPS.obtenerDemandaAnormal(Long periodo): Salida");
        return lista;
    }
    
    public ArrayList obtenerMaestroRegiones (Long pais, Long marca, Long canal, Boolean indicadorActivo, Long idioma, Long periodo) throws MareException{
        //Traza de entrada
        UtilidadesLog.info("DAOINTSAPBPS.obtenerMaestroRegiones(Long pais, Long marca, Long canal, Boolean indicadorActivo, Long idioma): Entrada");
        
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
               
        consulta.append(" SELECT   fvra.pais_oid_pais pais, fvra.soci_oid_soci sociedad, ");
        consulta.append("         m.cod_marc marca, r.OID_REGI REGI, ");
        consulta.append("         fvra.tspa_oid_tipo_soli_pais tiposolicpais, ");
        consulta.append("         fvra.ticl_oid_tipo_clie tipocliente, p.cod_pais codpais, ");
        consulta.append("         r.cod_regi codregi, r.DES_REGI desregi, ");
        consulta.append("         s.cod_soci codsoci, sgv.cod_subg_vent codsubgerentev, ");
        consulta.append("         cb.val_cana_bps canalbps ");
        consulta.append("    FROM int_fuent_venta_real_vacum fvra, ");
        consulta.append("         cra_perio per, ");
        consulta.append("         seg_marca m, ");
        consulta.append("         seg_pais p, ");
        consulta.append("         zon_sub_geren_venta sgv, ");
        consulta.append("         zon_regio r, ");
        consulta.append("         zon_zona z, ");
        consulta.append("         seg_socie s, ");
        consulta.append("         int_canal_bps cb ");
        consulta.append("   WHERE fvra.pais_oid_pais = ? ");
        parametros.add(pais);
        consulta.append("     AND fvra.perd_oid_peri = per.oid_peri ");
        consulta.append("     AND per.oid_peri = ? ");
        parametros.add(periodo);
        consulta.append("     AND per.marc_oid_marc = m.oid_marc ");
        consulta.append("     AND per.cana_oid_cana = ? ");
        parametros.add(canal);
        consulta.append("     AND per.marc_oid_marc = ? ");
        parametros.add(marca);
        consulta.append("     AND r.ind_acti = ? ");
        if(indicadorActivo.equals(Boolean.TRUE)){
            parametros.add(new Long(1));
        }else{
            parametros.add(new Long(0));
        }
        consulta.append("     AND sgv.oid_subg_vent = r.zsgv_oid_subg_vent ");
        consulta.append("     AND r.oid_regi = z.zorg_oid_regi ");
        consulta.append("     AND fvra.zzon_oid_zona = z.oid_zona ");
        consulta.append("     AND s.oid_soci = fvra.soci_oid_soci ");
        consulta.append("     AND p.oid_pais = fvra.pais_oid_pais ");
        consulta.append("     AND cb.tspa_oid_tipo_soli_pais = fvra.tspa_oid_tipo_soli_pais ");
        consulta.append("     AND cb.ticl_oid_tipo_clie = fvra.ticl_oid_tipo_clie ");
        consulta.append(" GROUP BY fvra.pais_oid_pais, ");
        consulta.append("         fvra.soci_oid_soci, ");
        consulta.append("         m.cod_marc, ");
        consulta.append("         r.OID_REGI, ");
        consulta.append("         fvra.tspa_oid_tipo_soli_pais, ");
        consulta.append("         fvra.ticl_oid_tipo_clie, ");
        consulta.append("         p.cod_pais, ");
        consulta.append("         r.cod_regi, ");
        consulta.append("         r.DES_REGI, ");
        consulta.append("         s.cod_soci, ");
        consulta.append("         sgv.cod_subg_vent, ");
        consulta.append("         cb.val_cana_bps ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
            rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerMaestroRegiones: Exception",e);
            this.logSql(" obtenerMaestroRegiones. SQL: ",
            consulta.toString(),parametros);
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));  
        }//catch
        
        ArrayList lista = new ArrayList();
        
        // Rellenamos el ArrayList con objetos 'DTOINTRegiones'
        if(rs != null){
            int x = rs.getRowCount();
            for(int i = 0; i < x; i++){
                DTOMaestroRegiones dto = new DTOMaestroRegiones();
                
                    if(rs.getValueAt(i,"CODPAIS") != null){                
                        dto.setCodPais(rs.getValueAt(i,"CODPAIS").toString());
                    }
                    if(rs.getValueAt(i,"CODREGI") != null){
                        dto.setCodRegion(rs.getValueAt(i,"CODREGI").toString());
                    }
                    if(rs.getValueAt(i,"CANALBPS") != null){
                        dto.setCanalBPS(rs.getValueAt(i,"CANALBPS").toString());
                    }
                    if(rs.getValueAt(i,"CODSOCI") != null){
                        dto.setCodSociedad(rs.getValueAt(i,"CODSOCI").toString());
                    }
                    if(rs.getValueAt(i,"DESREGI") != null){
                        dto.setDescripcionRegion(rs.getValueAt(i,"DESREGI").toString());
                    }
                    if(rs.getValueAt(i,"MARCA") != null){
                        dto.setMarcaEstructural(rs.getValueAt(i,"MARCA").toString());
                    }
                    if(rs.getValueAt(i,"CODSUBGERENTEV") != null){
                        dto.setSubgerenciaVentas(rs.getValueAt(i,"CODSUBGERENTEV").toString());
                    }
                    lista.add(dto);
                }
            }
        // Traza de salida
        UtilidadesLog.info("DAOINTSAPBPS.obtenerMaestroRegiones(Long pais, Long marca, Long canal, Boolean indicadorActivo, Long idioma): Salida");
        return lista;
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
    
    private String convierteFecha(Date fecha){
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");        
        java.sql.Date fechasql = new java.sql.Date(fecha.getTime());            
        return sdf5.format(fechasql);   
    }

    /*
     * SICC-GCC-INT-SAB-004 - dmorello, 05/12/2006
     * Se agrega el parametro de entrada "codigo".
     */
    public RecordSet obtenerMaestroTerritorios(DTOINTPantallaSAPBPS dtoe, String codigo, Boolean indicadorActivo) throws MareException {
                 UtilidadesLog.info("DAOINTSAPBPS.obtenerMaestroTerritorios(Long pais, Long marca, Long canal, Boolean indicadorActivo, Long idioma): Entrada");                                                                        

        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();   
        
        // sapaza -- PER-SiCC-2011-0148 -- 24/08/2011
        //se obtine el codigo periodo
        String codigoPeriodo = "";
        Long indicadorCruce = null;
        Long periodoSiguiente= null;
        try{
          codigoPeriodo = obtenerCodigoPeriodo(dtoe.getPeriodo());
          indicadorCruce = obtenerIndicadorCruce(dtoe.getPeriodo());//SI ESTA DESACTIVADO SE REALIZA EL NUEVO FILTRO
          periodoSiguiente= obtenerNPeriodo(codigoPeriodo,dtoe.getOidPais(),1);        
          UtilidadesLog.info("codigoPeriodo "+codigoPeriodo+" periodoSiguiente "+periodoSiguiente+" indicadorCruce "+indicadorCruce);
        }catch(Exception e){
          e.printStackTrace();    
        }
                
        /*
         * SICC-GCC-INT-SAB-004 - dmorello, 05/12/2006: Modificación de la query
         * Si codigo = ISAPBPS.COD_INTERFAZ_SAB28 se accede a INT_FUENT_VENTA_REAL_ACUMU (como antes)
         * En caso contrario, se accede a INT_VENTA_DIAPR_PRODU.
         */
         if (codigo.equals(ISAPBPS.COD_INTERFAZ_SAB28)) {
            consulta.append(" SELECT   fvra.pais_oid_pais PAIS , fvra.soci_oid_soci SOCIEDAD , m.cod_marc MARCA, ");
            consulta.append("           fvra.zzon_oid_zona ZONA , p.cod_pais CODPAIS , ");
         } else {
            consulta.append(" SELECT   per.pais_oid_pais PAIS , vdp.oidsociedad SOCIEDAD , m.cod_marc MARCA, ");
            consulta.append("           vdp.oid_zona ZONA , p.cod_pais CODPAIS , ");         
         }
         consulta.append("         z.cod_zona CODZONA, r.cod_regi CODREGI , ");
         consulta.append("         z.des_zona DESZONA , s.cod_soci CODSOCI, ");
         consulta.append("         sgv.cod_subg_vent CODSUBGERENTEV , cb.val_cana_bps CANALBPS, ");
         consulta.append("         sec.COD_SECC CODSECCION, ter.COD_TERR CODTERR ");
         if (codigo.equals(ISAPBPS.COD_INTERFAZ_SAB28)) {
            consulta.append("    FROM int_fuent_venta_real_vacum fvra, ");
         } else {
            // ISAPBPS.COD_INTERFAZ_SAB29
            consulta.append("    FROM (  ");
            this.armarSelectVentaDiaSAPBPS29(consulta, parametros,dtoe, codigo);
            consulta.append("    )vdp, " );
         }
         consulta.append("         cra_perio per, ");
         consulta.append("         seg_marca m, ");
         consulta.append("         seg_pais p, ");
         consulta.append("         zon_sub_geren_venta sgv, ");
         consulta.append("         zon_regio r, ");
         consulta.append("         zon_zona z, ");
         consulta.append("         seg_socie s,  ");
         consulta.append("         zon_terri ter, ");
         consulta.append("         zon_terri_admin ta, ");
         consulta.append("         int_canal_bps cb, ");
         consulta.append("	       ZON_SECCI sec ");
         if (codigo.equals(ISAPBPS.COD_INTERFAZ_SAB28)) {
             consulta.append("   WHERE fvra.pais_oid_pais = ?  ");                     
             parametros.add( dtoe.getOidPais() );
             consulta.append("     AND fvra.perd_oid_peri = per.oid_peri  ");
         } else {
             consulta.append("   WHERE vdp.oidperiodo = per.oid_peri  ");            
         }
         /*consulta.append("     AND per.oid_peri = ? ");
         parametros.add( dtoe.getPeriodo() );*/
         
         // sapaza -- PER-SiCC-2011-0148 -- 24/08/2011
         if (dtoe.getPeriodo() != null){
            consulta.append(" AND (per.oid_peri = ? ");
            parametros.add(dtoe.getPeriodo());            
            consulta.append("     OR ( "+indicadorCruce +"=0 AND per.OID_PERI = " + periodoSiguiente+") )");             
         }
                
         consulta.append("     AND per.marc_oid_marc = m.oid_marc ");
         if( dtoe.getCanal() !=null){
            consulta.append(" 	   AND per.CANA_OID_CANA = ? ");
            parametros.add(dtoe.getCanal());
         }
         if(dtoe.getMarca() !=null){
            consulta.append("	   AND per.MARC_OID_MARC = ? ");
            parametros.add(dtoe.getMarca());
         }
         consulta.append("     AND z.IND_ACTI = ? ");
         if(indicadorActivo.equals(Boolean.TRUE)){
            parametros.add(new Long(1)); 
         }else{
            parametros.add(new Long(0));  
         }
         consulta.append("     AND sgv.oid_subg_vent = r.zsgv_oid_subg_vent ");
         consulta.append("     AND r.oid_regi = z.zorg_oid_regi ");
         if (codigo.equals(ISAPBPS.COD_INTERFAZ_SAB28)) {
             consulta.append("     AND fvra.zzon_oid_zona = z.oid_zona ");
             consulta.append("     AND s.oid_soci = fvra.soci_oid_soci ");
             consulta.append("     AND p.oid_pais = fvra.pais_oid_pais ");
             consulta.append("     AND cb.tspa_oid_tipo_soli_pais = fvra.tspa_oid_tipo_soli_pais ");
             consulta.append("     AND cb.ticl_oid_tipo_clie = fvra.ticl_oid_tipo_clie ");
         } else {
             consulta.append("     AND ter.oid_terr = vdp.oidTerritorio ");//17/01/2007
             consulta.append("     AND vdp.oid_zona = z.oid_zona ");
             consulta.append("     AND s.oid_soci = vdp.oidsociedad ");
             consulta.append("     AND p.oid_pais = per.pais_oid_pais ");
             consulta.append("     AND cb.tspa_oid_tipo_soli_pais = vdp.oidtiposolicitudpais ");
             consulta.append("     AND cb.ticl_oid_tipo_clie = vdp.oidtipocliente ");
         }
         consulta.append("     AND sec.ZZON_OID_ZONA = z.OID_ZONA ");
         consulta.append("     AND ter.OID_TERR = ta.TERR_OID_TERR ");
         consulta.append("	   and ta.ZSCC_OID_SECC = sec.OID_SECC ");

         //20-07-2007 (Sapaza), modificado por incidencia SiCC-20070364   
         consulta.append("     AND sec.IND_BORR = 0 ");
         consulta.append("	   AND ta.IND_BORR = 0 ");
         
         if (codigo.equals(ISAPBPS.COD_INTERFAZ_SAB28)) {
             consulta.append("GROUP BY fvra.pais_oid_pais, ");
             consulta.append("         fvra.soci_oid_soci, ");
             consulta.append("         m.cod_marc, ");
             consulta.append("         fvra.zzon_oid_zona, ");
         } else {
             consulta.append("GROUP BY per.pais_oid_pais, ");
             consulta.append("         vdp.oidsociedad, ");
             consulta.append("         m.cod_marc, ");
             consulta.append("         vdp.oid_zona, ");
         }
         consulta.append("         p.cod_pais, ");
         consulta.append("         z.cod_zona, ");
         consulta.append("         r.cod_regi, ");
         consulta.append("         z.des_zona, ");
         consulta.append("         s.cod_soci, ");
         consulta.append("         sgv.cod_subg_vent, ");
         consulta.append("         cb.val_cana_bps,");
         consulta.append("         sec.COD_SECC, ");
         consulta.append("         ter.COD_TERR ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOINTSAPBPS.3: Exception",e);                                                             
            this.logSql(" DAOINTSAPBPS.obtenerMaestroZonas. SQL: ",consulta.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }     
     UtilidadesLog.warn(" ggg DAOINTSAPBPS.obtenerMaestroTerritorios - Salida    ---> rs.getRowCount() " +rs.getRowCount() ); 
     UtilidadesLog.info("DAOINTSAPBPS.obtenerMaestroTerritorios(Long pais, Long marca, Long canal, Boolean indicadorActivo, Long idioma): Salida");
        return rs;           
    }

   
    public ArrayList completarNumeroPedidos(DTOEnviarPedidosSAP dtoe, HashMap hashPedSAP) throws MareException {
        UtilidadesLog.info("DAOINTSAPBPS.completarNumeroPedidos(DTOEnviarPedidosSAP dtoe, HashMap hashPedSAP): Entrada");
        
        ArrayList listaPedSAPRetorno = new ArrayList();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        
        query.append(" SELECT   sol.pais_oid_pais, sol.perd_oid_peri, sol.sbac_oid_sbac, ");
        query.append("          sol.almc_oid_alma, sol.soci_oid_soci, sol.tspa_oid_tipo_soli_pais, ");
        query.append("          sol.ticl_oid_tipo_clie, ");
        query.append("          COUNT (sol.oid_soli_cabe) AS numpedidosacumulados ");
        query.append("     FROM ped_solic_cabec sol, ped_tipo_solic_pais tsp, ped_tipo_solic ts ");
        query.append("    WHERE sol.pais_oid_pais = ? ");
        parametros.add(dtoe.getOidPais());
        query.append("      AND sol.perd_oid_peri = ? ");
        parametros.add(dtoe.getOidPeriodo());
        query.append("      AND sol.ind_ts_no_conso = 1 ");
        query.append("      AND sol.ind_oc = 1 ");
        query.append("      AND sol.ind_pedi_prue = 0 ");
        query.append("      AND sol.modu_oid_modu != ? ");
        query.append("      AND sol.fec_fact IS NOT NULL ");
        parametros.add(new Long(ConstantesSEG.MODULO_INC));
        query.append("      AND sol.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        query.append("      AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli ");
        query.append("      AND ts.ind_anul = 0 ");
        query.append("      AND ts.ind_devo = 0 ");
        // gPineda - 25/01/2007 - Se filtran los registros que no pertenezcan a la fecha de facturacion.
        query.append("      AND sol.fec_fact = TO_DATE (?, 'DD/MM/YYYY') ");
        parametros.add(new SimpleDateFormat("dd/MM/yyyy").format(dtoe.getFechaFacturacion()));
        query.append(" GROUP BY sol.pais_oid_pais, ");
        query.append("          sol.perd_oid_peri, ");
        query.append("          sol.sbac_oid_sbac, ");
        query.append("          sol.almc_oid_alma, ");
        query.append("          sol.soci_oid_soci, ");
        query.append("          sol.tspa_oid_tipo_soli_pais, ");
        query.append("          sol.ticl_oid_tipo_clie ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try {                                                                                                                             
           rs =bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (rs != null && !rs.esVacio()) {
        
            StringBuffer sb = new StringBuffer();

            int rowCount = rs.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                // Armo la key para buscar en el hashmap
                Long oidPais = new Long(((BigDecimal)rs.getValueAt(i, "PAIS_OID_PAIS")).longValue());
                Long oidPeriodo = new Long(((BigDecimal)rs.getValueAt(i, "PERD_OID_PERI")).longValue());
                Long oidSubAcceso = new Long(((BigDecimal)rs.getValueAt(i, "SBAC_OID_SBAC")).longValue());
                Long oidAlmacen = new Long(((BigDecimal)rs.getValueAt(i, "ALMC_OID_ALMA")).longValue());
                Long oidSociedad = new Long(((BigDecimal)rs.getValueAt(i, "SOCI_OID_SOCI")).longValue());
                Long oidTipoSolicitud = new Long(((BigDecimal)rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS")).longValue());
                Long oidTipoCliente = new Long(((BigDecimal)rs.getValueAt(i, "TICL_OID_TIPO_CLIE")).longValue());
                
                sb.delete(0,sb.length());
                sb.append(oidPais).append('|');
                sb.append(oidPeriodo).append('|');
                sb.append(oidSubAcceso).append('|');
                sb.append(oidAlmacen).append('|');
                sb.append(oidSociedad).append('|');
                sb.append(oidTipoSolicitud).append('|');
                sb.append(oidTipoCliente);
                
                UtilidadesLog.debug("Voy a buscar por la clave: " + sb);
                String key = sb.toString();
                UtilidadesLog.debug("hashCode de la clave a buscar: " + key.hashCode());
                
                // Actualizo el número de pedidos acumulados en el DTO
                Long numPedidosAcumulados = new Long(((BigDecimal)rs.getValueAt(i, "NUMPEDIDOSACUMULADOS")).longValue());
                DTODatosPedSAP dtoDatosPedSAP = (DTODatosPedSAP)hashPedSAP.get(sb.toString());
                UtilidadesLog.debug("DTODatosPedSAP hallado en el hashmap: " + dtoDatosPedSAP);
                dtoDatosPedSAP.setNumPedidosAcumulados(numPedidosAcumulados);
            }
            
            Iterator it = hashPedSAP.values().iterator();
            while (it.hasNext()) {
                Long cero = new Long(0);
                DTODatosPedSAP dto = (DTODatosPedSAP)it.next();
                if (dto.getNumPedidosAcumulados() == null) {
                    dto.setNumPedidosAcumulados(cero);
                }
                listaPedSAPRetorno.add(dto);
            }
        }

        
        UtilidadesLog.info("DAOINTSAPBPS.completarNumeroPedidos(DTOEnviarPedidosSAP dtoe, HashMap hashPedSAP): Salida");
        return listaPedSAPRetorno;
    }
    
    
    /**
    * Calcula la venta dia por producto a nivel de territorio.
    * @cambio por peticion de cambio, se modifico la agrupacion de la informacion que envia SAB-14.
    * @autor gdmarzi (in situ)
    * 
    * Criterio de Agrupacion: marca, pais, sociedad(sociedadFi), almacen(centro), falg de venta, 
    * fecha facturacion, periodo(campaña + año comercial), codigo producto sap, tipo oferta,
    * canal bps(medio), condicion promocion, ciclo de vida, marca, territorio.
    * 
    * CHANGELOG
    * ---------
    * 28/04/2009 - dmorello, Cambio 20080824
    *     - Se agrega recuperacion de INT_PARAM_TIPO_SOLIC con NUM_UNID_VEND_VEND_OTRO y/o NUM_UNID_VEND_FALT_OTRO activos
    *     - Se modifican SUMs segun el valor de los flags anteriores.
    * 11/05/2009 - dmorello, Cambio 20080824
    *     - Se corrigen calculos
     * 26/05/2009 - dmorello, Cambio 20080824
     *     - Se corrigen errores detectados por el cliente
    */
    public StringBuffer armarSelectVentaDiaSAPBPS14(StringBuffer sql, Vector parametros, DTOEnviarPedidosSAP dtoe, String codigo){
            UtilidadesLog.info("DAOINTSAPBPS.armarSelectVentaDiaSAPBPS14() - Entrada");
      
        //PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS , 
        //se obtine el codigo periodo
         String codigoPeriodo = "";
         Long indicadorCruce = null;
         Long periodoSiguiente= null;
         String valParametro="";
       try{
        codigoPeriodo = obtenerCodigoPeriodo(dtoe.getOidPeriodo());
        indicadorCruce = obtenerIndicadorCruce(dtoe.getOidPeriodo());//SI ESTA DESACTIVADO SE REALIZA EL NUEVO FILTRO
        periodoSiguiente= obtenerNPeriodo(codigoPeriodo,dtoe.getOidPais(),1);      
        valParametro = obtenerParametroGenerico(dtoe.getOidPais(),"SAB","001");
        UtilidadesLog.info("codigoPeriodo "+codigoPeriodo+" periodoSiguiente "+periodoSiguiente+" indicadorCruce "+indicadorCruce);
       }catch(Exception e){
         e.printStackTrace();    
       }
        
        //  
        if("0".equals(valParametro)){
            sql.append(" SELECT sc.PAIS_OID_PAIS PAIS, ");
            sql.append(" sc.PERD_OID_PERI OIDPERIODO, ");
            sql.append(" MIN(sc.ALMC_OID_ALMA) OIDALMACEN, ");
            sql.append(" sc.SOCI_OID_SOCI OIDSOCIEDAD, ");
            sql.append(" sp.PROD_OID_PROD OIDPRODUCTO, ");
            sql.append(" sc.FEC_FACT FECHAFACTURACION, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_VEND_OTRO = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END) AS unid_aten_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.num_unid_falt = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_FALT_OTRO = 1 THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) ELSE 0 END) AS unid_aten_faltantes, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_DEVU = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_devueltas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_ANUL = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_anuladas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_CANJ = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_canje, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_TRUE = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_trueque, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_VEND_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END) AS venta_neta_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_FALT_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) * sp.val_prec_neto_unit_loca ELSE 0 END) AS venta_neta_faltantes, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_DEVU = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_devueltas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_ANUL = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_anuladas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_CANJ = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_canje, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_TRUE = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_trueque, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_VEND_OTRO = 1 THEN sp.VAL_PREC_CATA_TOTA_LOCA ELSE 0 END) AS prec_cata_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_FALT_OTRO = 1 THEN (sp.num_unid_dema_real - sp.num_unid_compr) * sp.val_prec_cata_unit_loca ELSE 0 END) AS prec_cata_faltantes, ");
            sql.append(" od.CIVI_OID_CICLO_VIDA OIDCICLOVIDA, ");
            sql.append(" od.TOFE_OID_TIPO_OFER OIDTIPOOFERTA, ");
            sql.append(" od.cndp_oid_cond_prom oidcondicionpromocion, ");
            sql.append(" 1 FLAGVENTA, ");
            sql.append(" ter.COD_TERR territorio, ");
            sql.append(" ter.OID_TERR OIDTERRITORIO ");
            sql.append(" , sociedad.cod_soci CODIGOSOCIEDAD");
            sql.append(" , MIN(almacen.cod_alma) CODIGOALMACEM");
            sql.append(" , codmedioSap.val_medi MEDIO");
            sql.append(" , 1 canalBPS");
            sql.append(" , periodoCorpo.cod_peri codPeriodo");
            sql.append(" , maeProd.cod_sap codSap");
            sql.append(" , cicloVida.cod_cicl_vida codCicloVida");
            sql.append(" , tipoOferta.cod_tipo_ofer codTipoOfer");
            sql.append(" , NVL(condProm.cod_cond_prom, '00' ) codCondProm");
            sql.append(" , marca.cod_marc codMarca");
            sql.append(" , SUM(CASE WHEN pt.NUM_UNID_FALT = 1 OR pt.NUM_UNID_FALT_OTRO = 1 THEN (sp.num_unid_dema_real - sp.num_unid_compr) ELSE 0 END) AS NUM_UNID_POR_ATEN ");
            sql.append(" ,pais.MONE_OID_MONE oidMoneda");
            sql.append(" ,periodo.cana_oid_cana ");
            sql.append(" FROM  ");
            sql.append(" PED_SOLIC_CABEC sc, ");
            sql.append(" PED_SOLIC_POSIC sp, ");
            sql.append(" PED_TIPO_SOLIC_PAIS ts, ");
            sql.append(" INT_PARAM_TIPO_SOLIC pt, ");
            sql.append(" (SELECT pod.oid_deta_ofer, pod.val_codi_vent, pod.civi_oid_ciclo_vida, pod.tofe_oid_tipo_ofer, ");
            sql.append("    (CASE WHEN pod.cndp_oid_cond_prom IS NULL ");
            sql.append("          THEN (SELECT oid_cond_prom FROM pre_condi_promo WHERE cod_cond_prom = '00') ");
            sql.append("          ELSE pod.cndp_oid_cond_prom ");
            sql.append("     END) cndp_oid_cond_prom ");
            sql.append("  FROM pre_ofert_detal pod) od, ");
            sql.append(" zon_terri ter ");        
            sql.append(" ,seg_pais pais ");
            sql.append(", seg_socie sociedad ");        
            sql.append(", bel_almac almacen ");        
            sql.append(", int_codig_medio_sapbp codmedioSap ");
            //sql.append(", int_canal_bps canalBPS ");
            sql.append(", cra_perio periodo ");
            sql.append(", seg_perio_corpo periodoCorpo ");
            sql.append(", mae_produ maeProd ");
            sql.append(", pre_ciclo_vida cicloVida ");
            sql.append(", pre_tipo_ofert tipoOferta ");
            sql.append(", pre_condi_promo condProm ");
            sql.append(", seg_marca marca ");
            sql.append(", PED_TIPO_SOLIC tsol ");            
            sql.append(" WHERE  ");
            sql.append(" sp.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
            sql.append(" AND sp.OFDE_OID_DETA_OFER = od.OID_DETA_OFER (+) ");
            sql.append(" AND sc.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
            sql.append(" AND pt.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
            sql.append(" AND sc.PAIS_OID_PAIS = ? ");
            sql.append(" AND sc.pais_oid_pais = pais.OID_PAIS ");
            parametros.add(dtoe.getOidPais());
            if (dtoe.getOidPeriodo() != null){
                sql.append(" AND (sc.PERD_OID_PERI = ? ");
                parametros.add(dtoe.getOidPeriodo());            
                sql.append("     OR ( "+indicadorCruce +"=0 AND sc.PERD_OID_PERI = " + periodoSiguiente+") )");             
            }
            if (dtoe.getFechaFacturacion() != null){
                String fecha = convierteFecha(dtoe.getFechaFacturacion());
                sql.append(" AND sc.FEC_FACT = TO_DATE( ? ,'YYYY-MM-DD') ");
                parametros.add(fecha);
            }
            sql.append(" AND sc.IND_TS_NO_CONSO = 1  ");
            sql.append(" AND sc.IND_PEDI_PRUE = 0  ");
            sql.append(" AND sp.ESPO_OID_ESTA_POSI <> ? ");
            parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
            sql.append(" AND sp.VAL_CODI_VENT = od.VAL_CODI_VENT (+) ");
            sql.append(" AND ter.OID_TERR = sc.TERR_OID_TERR ");
            sql.append(" AND sc.SOCI_OID_SOCI = sociedad.oid_soci ");
            sql.append(" AND sc.ALMC_OID_ALMA =  almacen.oid_alma ");
            sql.append(" AND sc.PAIS_OID_PAIS = codmedioSap.pais_oid_pais AND sc.SBAC_OID_SBAC = codmedioSap.sbac_oid_sbac ");
            //sql.append(" AND sc.TICL_OID_TIPO_CLIE = canalBPS.ticl_oid_tipo_clie AND sc.TSPA_OID_TIPO_SOLI_PAIS = canalBPS.TSPA_OID_TIPO_SOLI_PAIS ");
            sql.append(" AND sc.PERD_OID_PERI = periodo.oid_peri ");
            sql.append(" AND periodo.peri_oid_peri = periodoCorpo.oid_peri ");
            sql.append(" AND sp.PROD_OID_PROD = maeProd.oid_prod ");
            sql.append(" AND od.CIVI_OID_CICLO_VIDA = cicloVida.oid_cicl_vida (+) ");
            sql.append(" AND od.TOFE_OID_TIPO_OFER = tipoOferta.oid_tipo_ofer (+) ");
            sql.append(" AND od.CNDP_OID_COND_PROM = condProm.oid_cond_prom (+) ");
            sql.append(" AND periodo.marc_oid_marc = marca.oid_marc ");
            sql.append(" AND TS.TSOL_OID_TIPO_SOLI = tsol.OID_TIPO_SOLI "); 
            sql.append(" AND ( ");
            sql.append("       ( ");
            sql.append("          pt.NUM_UNID_VEND = 1 ");
            sql.append("          AND tsol.IND_ANUL = 0 ");
            sql.append("          AND tsol.IND_DEVO = 0 ");
            sql.append("          AND sc.IND_OC = 1 ");
            sql.append("       ) OR ( ");
            sql.append("          pt.NUM_UNID_FALT = 1  ");
            sql.append("          AND tsol.IND_ANUL = 0 ");
            sql.append("          AND tsol.IND_DEVO = 0 ");
            sql.append("          AND sc.IND_OC = 1 ");
            sql.append("       ) OR ( ");
            
            sql.append("             (pt.NUM_UNID_DEVU = 1 OR pt.NUM_UNID_ANUL = 1 OR pt.NUM_UNID_CANJ = 1 ");
            sql.append("              OR pt.NUM_UNID_TRUE = 1) AND ");
            sql.append("              FN_DAT_VALIDAR_PROD_SOLI_DEVO(sc.OID_SOLI_CABE, sp.OID_SOLI_POSI) > 0 ");
            sql.append("            ) ");
            sql.append(" )");
    
    
            sql.append(" GROUP BY sc.PAIS_OID_PAIS , ");
            sql.append(" sc.PERD_OID_PERI, ");
            //sql.append(" sc.ALMC_OID_ALMA, ");
            sql.append(" sc.SOCI_OID_SOCI, ");
            sql.append(" sp.PROD_OID_PROD, ");
            sql.append(" sc.FEC_FACT, ");
            sql.append(" od.CIVI_OID_CICLO_VIDA, ");
            sql.append(" od.TOFE_OID_TIPO_OFER, ");
            sql.append(" od.CNDP_OID_COND_PROM, ");
            //sql.append(" ts.IND_VENT_INTE_SAB_14, ");
            sql.append(" ter.COD_TERR, ");        
            sql.append(" ter.OID_TERR ");
            sql.append(" , sociedad.cod_soci");
            //sql.append(" , almacen.cod_alma");
            sql.append(" , codmedioSap.val_medi");
            //sql.append(" , canalBPS.val_cana_bps");
            sql.append(" , periodoCorpo.cod_peri");
            sql.append(" , maeProd.cod_sap");
            sql.append(" , cicloVida.cod_cicl_vida");
            sql.append(" , tipoOferta.cod_tipo_ofer");
            sql.append(" , condProm.cod_cond_prom");
            sql.append(" , marca.cod_marc");
            sql.append(" , pais.MONE_OID_MONE ");
            sql.append(" ,periodo.cana_oid_cana ");
        }else{
           //se agrega join con la tabla fac docum_linea
            sql.append(" SELECT sc.PAIS_OID_PAIS PAIS, ");
            sql.append(" sc.PERD_OID_PERI OIDPERIODO, ");
            sql.append(" MIN(sc.ALMC_OID_ALMA) OIDALMACEN, ");
            sql.append(" sc.SOCI_OID_SOCI OIDSOCIEDAD, ");
            sql.append(" sp.PROD_OID_PROD OIDPRODUCTO, ");
            sql.append(" sc.FEC_FACT FECHAFACTURACION, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_VEND_OTRO = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END) AS unid_aten_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.num_unid_falt = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_FALT_OTRO = 1 THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) ELSE 0 END) AS unid_aten_faltantes, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_DEVU = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_devueltas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_ANUL = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_anuladas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_CANJ = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_canje, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_TRUE = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_trueque, ");
            sql.append(" SUM(ABS(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_VEND_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END)) AS venta_neta_vendidas, ");
            
            if (dtoe.getFechaFacturacion() != null){
                String fecha = convierteFecha(dtoe.getFechaFacturacion());            
                sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_FALT_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) * (sp.val_prec_neto_unit_loca - NVL((SELECT x.val_impu_prod_naci FROM INT_IMPUE_PRODU_NACIO x WHERE x.prod_oid_prod  = SP.PROD_OID_PROD  AND x.fec_carg = (SELECT MAX(y.fec_carg) FROM int_impue_produ_nacio y WHERE y.prod_oid_prod = SP.PROD_OID_PROD AND y.fec_carg <=  TO_DATE( ? ,'YYYY-MM-DD'))),0)) ELSE 0 END) AS venta_neta_faltantes, ");
                parametros.add(fecha);
            }else{
                sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_FALT_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) * (sp.val_prec_neto_unit_loca - NVL((SELECT x.val_impu_prod_naci FROM INT_IMPUE_PRODU_NACIO x WHERE x.prod_oid_prod  = SP.PROD_OID_PROD  AND x.fec_carg = (SELECT MAX(y.fec_carg) FROM int_impue_produ_nacio y WHERE y.prod_oid_prod = SP.PROD_OID_PROD AND TRUNC(y.fec_carg) <=  TRUNC(SYSDATE) )),0)) ELSE 0 END) AS venta_neta_faltantes, ");
            }
                                    
            sql.append(" (SUM(ABS(CASE WHEN pt.NUM_UNID_DEVU = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END))) AS venta_neta_devueltas, ");
            sql.append(" (SUM(ABS(CASE WHEN pt.NUM_UNID_ANUL = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END))) AS venta_neta_anuladas, ");
            sql.append(" (SUM(ABS(CASE WHEN pt.NUM_UNID_CANJ = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END))) AS venta_neta_canje, ");
            sql.append(" (SUM(ABS(CASE WHEN pt.NUM_UNID_TRUE = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END))) AS venta_neta_trueque, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_VEND_OTRO = 1 THEN sp.VAL_PREC_CATA_TOTA_LOCA ELSE 0 END) AS prec_cata_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_FALT_OTRO = 1 THEN (sp.num_unid_dema_real - sp.num_unid_compr) * sp.val_prec_cata_unit_loca ELSE 0 END) AS prec_cata_faltantes, ");
            sql.append(" od.CIVI_OID_CICLO_VIDA OIDCICLOVIDA, ");
            sql.append(" od.TOFE_OID_TIPO_OFER OIDTIPOOFERTA, ");
            sql.append(" od.cndp_oid_cond_prom oidcondicionpromocion, ");
            sql.append(" 1 FLAGVENTA, ");
            sql.append(" ter.COD_TERR territorio, ");
            sql.append(" ter.OID_TERR OIDTERRITORIO ");
            sql.append(" , sociedad.cod_soci CODIGOSOCIEDAD");
            sql.append(" , MIN(almacen.cod_alma) CODIGOALMACEM");
            sql.append(" , codmedioSap.val_medi MEDIO");
            sql.append(" , 1 canalBPS");
            sql.append(" , periodoCorpo.cod_peri codPeriodo");
            sql.append(" , maeProd.cod_sap codSap");
            sql.append(" , cicloVida.cod_cicl_vida codCicloVida");
            sql.append(" , tipoOferta.cod_tipo_ofer codTipoOfer");
            sql.append(" , NVL(condProm.cod_cond_prom, '00' ) codCondProm");
            sql.append(" , marca.cod_marc codMarca");
            sql.append(" , SUM(CASE WHEN pt.NUM_UNID_FALT = 1 OR pt.NUM_UNID_FALT_OTRO = 1 THEN (sp.num_unid_dema_real - sp.num_unid_compr) ELSE 0 END) AS NUM_UNID_POR_ATEN ");
            sql.append(" ,pais.MONE_OID_MONE oidMoneda");
            sql.append(" ,periodo.cana_oid_cana ");
            sql.append(" FROM  ");
            sql.append(" PED_SOLIC_CABEC sc, ");
            sql.append(" PED_SOLIC_POSIC sp, ");
            sql.append(" PED_TIPO_SOLIC_PAIS ts, ");
            sql.append(" INT_PARAM_TIPO_SOLIC pt, ");
            sql.append(" (SELECT pod.oid_deta_ofer, pod.val_codi_vent, pod.civi_oid_ciclo_vida, pod.tofe_oid_tipo_ofer, ");
            sql.append("    (CASE WHEN pod.cndp_oid_cond_prom IS NULL ");
            sql.append("          THEN (SELECT oid_cond_prom FROM pre_condi_promo WHERE cod_cond_prom = '00') ");
            sql.append("          ELSE pod.cndp_oid_cond_prom ");
            sql.append("     END) cndp_oid_cond_prom ");
            sql.append("  FROM pre_ofert_detal pod) od, ");
            sql.append(" zon_terri ter ");        
            sql.append(" ,seg_pais pais ");
            sql.append(", seg_socie sociedad ");        
            sql.append(", bel_almac almacen ");        
            sql.append(", int_codig_medio_sapbp codmedioSap ");
            //sql.append(", int_canal_bps canalBPS ");
            sql.append(", cra_perio periodo ");
            sql.append(", seg_perio_corpo periodoCorpo ");
            sql.append(", mae_produ maeProd ");
            sql.append(", pre_ciclo_vida cicloVida ");
            sql.append(", pre_tipo_ofert tipoOferta ");
            sql.append(", pre_condi_promo condProm ");
            sql.append(", seg_marca marca ");
            sql.append(", PED_TIPO_SOLIC tsol ");
            sql.append(", FAC_DOCUM_CONTA_LINEA fdl");
            sql.append(" WHERE  ");
            sql.append(" sp.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
            sql.append(" AND sp.OFDE_OID_DETA_OFER = od.OID_DETA_OFER (+) ");
            sql.append(" AND sc.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
            sql.append(" AND pt.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
            sql.append(" AND sc.PAIS_OID_PAIS = ? ");
            sql.append(" AND sc.pais_oid_pais = pais.OID_PAIS ");
            parametros.add(dtoe.getOidPais());
            if (dtoe.getOidPeriodo() != null){
                sql.append(" AND (sc.PERD_OID_PERI = ? ");
                parametros.add(dtoe.getOidPeriodo());            
                sql.append("     OR ( "+indicadorCruce +"=0 AND sc.PERD_OID_PERI = " + periodoSiguiente+") )");             
            }
            if (dtoe.getFechaFacturacion() != null){
                String fecha = convierteFecha(dtoe.getFechaFacturacion());
                sql.append(" AND sc.FEC_FACT = TO_DATE( ? ,'YYYY-MM-DD') ");
                parametros.add(fecha);
            }
            sql.append(" AND sc.IND_TS_NO_CONSO = 1  ");
            sql.append(" AND sc.IND_PEDI_PRUE = 0  ");
            sql.append(" AND sp.ESPO_OID_ESTA_POSI <> ? ");
            parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
            sql.append(" AND sp.VAL_CODI_VENT = od.VAL_CODI_VENT (+) ");
            sql.append(" AND ter.OID_TERR = sc.TERR_OID_TERR ");
            sql.append(" AND sc.SOCI_OID_SOCI = sociedad.oid_soci ");
            sql.append(" AND sc.ALMC_OID_ALMA =  almacen.oid_alma ");
            sql.append(" AND sc.PAIS_OID_PAIS = codmedioSap.pais_oid_pais AND sc.SBAC_OID_SBAC = codmedioSap.sbac_oid_sbac ");
            //sql.append(" AND sc.TICL_OID_TIPO_CLIE = canalBPS.ticl_oid_tipo_clie AND sc.TSPA_OID_TIPO_SOLI_PAIS = canalBPS.TSPA_OID_TIPO_SOLI_PAIS ");
            sql.append(" AND sc.PERD_OID_PERI = periodo.oid_peri ");
            sql.append(" AND periodo.peri_oid_peri = periodoCorpo.oid_peri ");
            sql.append(" AND sp.PROD_OID_PROD = maeProd.oid_prod ");
            sql.append(" AND od.CIVI_OID_CICLO_VIDA = cicloVida.oid_cicl_vida (+) ");
            sql.append(" AND od.TOFE_OID_TIPO_OFER = tipoOferta.oid_tipo_ofer (+) ");
            sql.append(" AND od.CNDP_OID_COND_PROM = condProm.oid_cond_prom (+) ");
            sql.append(" AND periodo.marc_oid_marc = marca.oid_marc ");
            sql.append(" AND TS.TSOL_OID_TIPO_SOLI = tsol.OID_TIPO_SOLI "); 
            sql.append(" and fdl.SOPO_OID_SOLI_POSI(+) = sp.OID_SOLI_POSI "); 
            sql.append(" AND ( ");
            sql.append("       ( ");
            sql.append("          pt.NUM_UNID_VEND = 1 ");
            sql.append("          AND tsol.IND_ANUL = 0 ");
            sql.append("          AND tsol.IND_DEVO = 0 ");
            sql.append("          AND sc.IND_OC = 1 ");
            sql.append("       ) OR ( ");
            sql.append("          pt.NUM_UNID_FALT = 1  ");
            sql.append("          AND tsol.IND_ANUL = 0 ");
            sql.append("          AND tsol.IND_DEVO = 0 ");
            sql.append("          AND sc.IND_OC = 1 ");
            sql.append("       ) OR ( ");
            
            sql.append("             (pt.NUM_UNID_DEVU = 1 OR pt.NUM_UNID_ANUL = 1 OR pt.NUM_UNID_CANJ = 1 ");
            sql.append("              OR pt.NUM_UNID_TRUE = 1) AND ");
            sql.append("              FN_DAT_VALIDAR_PROD_SOLI_DEVO(sc.OID_SOLI_CABE, sp.OID_SOLI_POSI) > 0 ");
            sql.append("            ) ");
            sql.append(" )");
            
            
            sql.append(" GROUP BY sc.PAIS_OID_PAIS , ");
            sql.append(" sc.PERD_OID_PERI, ");
            //sql.append(" sc.ALMC_OID_ALMA, ");
            sql.append(" sc.SOCI_OID_SOCI, ");
            sql.append(" sp.PROD_OID_PROD, ");
            sql.append(" sc.FEC_FACT, ");
            sql.append(" od.CIVI_OID_CICLO_VIDA, ");
            sql.append(" od.TOFE_OID_TIPO_OFER, ");
            sql.append(" od.CNDP_OID_COND_PROM, ");
            //sql.append(" ts.IND_VENT_INTE_SAB_14, ");
            sql.append(" ter.COD_TERR, ");        
            sql.append(" ter.OID_TERR ");
            sql.append(" , sociedad.cod_soci");
            //sql.append(" , almacen.cod_alma");
            sql.append(" , codmedioSap.val_medi");
            //sql.append(" , canalBPS.val_cana_bps");
            sql.append(" , periodoCorpo.cod_peri");
            sql.append(" , maeProd.cod_sap");
            sql.append(" , cicloVida.cod_cicl_vida");
            sql.append(" , tipoOferta.cod_tipo_ofer");
            sql.append(" , condProm.cod_cond_prom");
            sql.append(" , marca.cod_marc");
            sql.append(" , pais.MONE_OID_MONE ");
            sql.append(" ,periodo.cana_oid_cana ");            
        }
        UtilidadesLog.info("DAOINTSAPBPS.armarSelectVentaDiaSAPBPS14() - Salida");
        return sql;
    }


    /**
    * Utilizada para verificar simplemente si hay facturacion para un codigo de venta en cada terriotorio.
    */
    public StringBuffer armarSelectVentaDiaSAPBPS29(StringBuffer sql, Vector parametros, DTOEnviarPedidosSAP dtoe, String codigo){
        UtilidadesLog.info("DAOINTSAPBPS.armarSelectVentaDiaSAPBPS29() - Entrada");
        sql.append(" SELECT sc.PAIS_OID_PAIS PAIS, ");
        sql.append(" sc.PERD_OID_PERI OIDPERIODO, ");
        sql.append(" sc.ALMC_OID_ALMA OIDALMACEN, ");
        sql.append(" sc.SOCI_OID_SOCI OIDSOCIEDAD, ");
        sql.append(" sc.tspa_oid_tipo_soli_pais oidtiposolicitudpais, ");
        sql.append(" sc.ticl_oid_tipo_clie oidtipocliente, ");
        sql.append(" sp.PROD_OID_PROD OIDPRODUCTO, ");
        sql.append(" sp.val_codi_vent CODVENTA, ");
        sql.append(" sc.FEC_FACT FECHAFACTURACION, ");
        sql.append(" SUM(CASE WHEN pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END) AS unid_aten_vendidas, ");
        sql.append(" SUM(CASE WHEN pt.num_unid_falt = 1 AND sc.ind_oc = 1 THEN (sp.num_unid_por_aten - sp.num_unid_compr) ELSE 0 END) AS unid_aten_faltantes, ");
        sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_DEVU = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_devueltas, ");
        sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_ANUL = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_anuladas, ");
        sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_CANJ = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_canje, ");
        sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_TRUE = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_trueque, ");
        sql.append(" SUM(CASE WHEN pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END) AS venta_neta_vendidas, ");
        sql.append(" SUM(CASE WHEN pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1 THEN (sp.num_unid_por_aten - sp.num_unid_compr) * sp.val_prec_neto_unit_loca ELSE 0 END) AS venta_neta_faltantes, ");
        sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_DEVU = 1 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_devueltas, ");
        sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_ANUL = 1 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_anuladas, ");
        sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_CANJ = 1 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_canje, ");
        sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_TRUE = 1 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_trueque, ");
        sql.append(" SUM(CASE WHEN pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1 THEN sp.VAL_PREC_CATA_TOTA_LOCA ELSE 0 END) AS prec_cata_vendidas, ");
        sql.append(" SUM(CASE WHEN pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1 THEN (sp.num_unid_por_aten - sp.num_unid_compr) * sp.val_prec_cata_unit_loca ELSE 0 END) AS prec_cata_faltantes, ");
        sql.append(" od.CIVI_OID_CICLO_VIDA OIDCICLOVIDA, ");
        sql.append(" od.TOFE_OID_TIPO_OFER OIDTIPOOFERTA, ");
        sql.append(" (CASE ");
        sql.append("    WHEN od.cndp_oid_cond_prom is null ");
        sql.append("        THEN (Select OID_COND_PROM ");
        sql.append("                from pre_condi_promo ");
        sql.append("               where COD_COND_PROM = '00') ");
        sql.append("    ELSE od.cndp_oid_cond_prom ");
        sql.append("   END ) oidcondicionpromocion, ");
        //sql.append(" ts.IND_VENT_INTE_SAB_14 FLAGVENTA, ");
        sql.append(" 1 FLAGVENTA, ");
        sql.append(" ter.COD_TERR territorio, ");
        sql.append(" ter.OID_TERR OIDTERRITORIO ");
        sql.append(" , sociedad.cod_soci CODIGOSOCIEDAD");
        sql.append(" , almacen.cod_alma CODIGOALMACEM");
        sql.append(" , codmedioSap.val_medi MEDIO");
        //sql.append(" , canalBPS.val_cana_bps canalBPS");
        sql.append(" , 1 canalBPS");
        sql.append(" , periodoCorpo.cod_peri codPeriodo");
        sql.append(" , maeProd.cod_sap codSap");
        sql.append(" , cicloVida.cod_cicl_vida codCicloVida");
        sql.append(" , tipoOferta.cod_tipo_ofer codTipoOfer");
        sql.append(" , NVL(condProm.cod_cond_prom, '00' ) codCondProm");
        sql.append(" , marca.cod_marc codMarca");
        sql.append(" , region.oid_regi");
        sql.append(" , zona.oid_zona");
        sql.append(" , SUM(CASE WHEN pt.NUM_UNID_FALT = 1 THEN sp.NUM_UNID_POR_ATEN ELSE 0 END) AS NUM_UNID_POR_ATEN ");
        sql.append(" ,pais.MONE_OID_MONE oidMoneda");
        sql.append(" ,periodo.cana_oid_cana ");
        sql.append(" FROM  ");
        sql.append(" PED_SOLIC_CABEC sc, ");
        sql.append(" PED_SOLIC_POSIC sp, ");
        sql.append(" PED_TIPO_SOLIC_PAIS ts, ");
        sql.append(" INT_PARAM_TIPO_SOLIC pt, ");
        sql.append(" PRE_OFERT_DETAL OD, ");
        sql.append(" zon_terri ter ");        
        sql.append(" ,seg_pais pais ");
        sql.append(", seg_socie sociedad ");        
        sql.append(", bel_almac almacen ");        
        sql.append(", int_codig_medio_sapbp codmedioSap ");
        //sql.append(", int_canal_bps canalBPS ");
        sql.append(", cra_perio periodo ");
        sql.append(", seg_perio_corpo periodoCorpo ");
        sql.append(", mae_produ maeProd ");
        sql.append(", pre_ciclo_vida cicloVida ");
        sql.append(", pre_tipo_ofert tipoOferta ");
        sql.append(", pre_condi_promo condProm ");
        sql.append(", seg_marca marca ");
        sql.append(", zon_regio region ");
        sql.append(", zon_zona zona ");
        sql.append(", PED_TIPO_SOLIC tsol ");
        sql.append(" WHERE  ");
        sql.append(" sp.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
        sql.append(" AND sp.OFDE_OID_DETA_OFER = od.OID_DETA_OFER (+) ");
        sql.append(" AND sc.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
        sql.append(" AND pt.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
        sql.append(" AND sc.PAIS_OID_PAIS = ? ");
        sql.append(" AND sc.pais_oid_pais = pais.OID_PAIS ");
        parametros.add(dtoe.getOidPais());
        if (dtoe.getOidPeriodo() != null){
            sql.append(" AND sc.PERD_OID_PERI = ? ");
            parametros.add(dtoe.getOidPeriodo());
        }
        if (dtoe.getFechaFacturacion() != null){
            String fecha = convierteFecha(dtoe.getFechaFacturacion());
            sql.append(" AND sc.FEC_FACT = TO_DATE( ? ,'YYYY-MM-DD') ");
            parametros.add(fecha);
        }
        sql.append(" AND sc.IND_TS_NO_CONSO = 1  ");
        sql.append(" AND sc.IND_PEDI_PRUE = 0  ");
        sql.append(" AND sp.ESPO_OID_ESTA_POSI <> ? ");
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
        sql.append(" AND sp.VAL_CODI_VENT = od.VAL_CODI_VENT (+) ");
        sql.append(" AND ter.OID_TERR = sc.TERR_OID_TERR ");
        sql.append(" AND sc.SOCI_OID_SOCI = sociedad.oid_soci ");
        sql.append(" AND sc.ALMC_OID_ALMA =  almacen.oid_alma ");
        sql.append(" AND sc.PAIS_OID_PAIS = codmedioSap.pais_oid_pais AND sc.SBAC_OID_SBAC = codmedioSap.sbac_oid_sbac ");
        //sql.append(" AND sc.TICL_OID_TIPO_CLIE = canalBPS.ticl_oid_tipo_clie AND sc.TSPA_OID_TIPO_SOLI_PAIS = canalBPS.TSPA_OID_TIPO_SOLI_PAIS ");
        sql.append(" AND sc.PERD_OID_PERI = periodo.oid_peri ");
        sql.append(" AND periodo.peri_oid_peri = periodoCorpo.oid_peri ");
        sql.append(" AND sp.PROD_OID_PROD = maeProd.oid_prod ");
        sql.append(" AND od.CIVI_OID_CICLO_VIDA = cicloVida.oid_cicl_vida (+) ");
        sql.append(" AND od.TOFE_OID_TIPO_OFER = tipoOferta.oid_tipo_ofer (+) ");
        sql.append(" AND od.CNDP_OID_COND_PROM = condProm.oid_cond_prom (+) ");
        sql.append(" AND periodo.marc_oid_marc = marca.oid_marc ");
        sql.append(" AND TS.TSOL_OID_TIPO_SOLI = tsol.OID_TIPO_SOLI ");
        sql.append(" AND ( ");
        sql.append("       ( ");
        sql.append("          pt.NUM_UNID_VEND = 1 ");
        sql.append("          AND tsol.IND_ANUL = 0 ");
        sql.append("          AND tsol.IND_DEVO = 0 ");
        sql.append("          AND sc.IND_OC = 1 ");
        sql.append("       ) OR ( ");
        sql.append("          pt.NUM_UNID_FALT = 1  ");
        sql.append("          AND tsol.IND_ANUL = 0 ");
        sql.append("          AND tsol.IND_DEVO = 0 ");
        sql.append("          AND sc.IND_OC = 1 ");
        sql.append("       ) OR ( ");
        sql.append("          pt.NUM_UNID_DEVU = 1  ");
        //sql.append("          AND sc.IND_OC = 1 ");
        sql.append("       ) OR ( ");
        sql.append("          pt.NUM_UNID_ANUL = 1  ");
        //sql.append("          AND sc.IND_OC = 1 ");
        sql.append("       ) OR ( ");
        sql.append("          pt.NUM_UNID_CANJ = 1  ");
        //sql.append("          AND tsol.IND_ANUL = 0 ");
        //sql.append("          AND tsol.IND_DEVO = 0 ");
        //sql.append("          AND sc.IND_OC = 0 ");
        sql.append("       ) OR ( ");
        sql.append("          pt.NUM_UNID_TRUE = 1 ");
        //sql.append("          AND tsol.IND_ANUL = 0 ");
        //sql.append("          AND tsol.IND_DEVO = 0 ");
        //sql.append("          AND sc.IND_OC = 0 ");
        sql.append("       ) ");
        sql.append(" )");
        sql.append(" AND sc.zzon_oid_zona = zona.oid_zona ");
        sql.append(" AND zona.zorg_oid_regi = region.oid_regi ");
        sql.append(" GROUP BY sc.PAIS_OID_PAIS , ");
        sql.append(" sc.PERD_OID_PERI, ");
        sql.append(" sc.ALMC_OID_ALMA, ");
        sql.append(" sc.SOCI_OID_SOCI, ");
        sql.append(" sc.tspa_oid_tipo_soli_pais, ");
        sql.append(" sc.ticl_oid_tipo_clie, ");
        sql.append(" sp.PROD_OID_PROD, ");
        sql.append(" sp.val_codi_vent, ");
        sql.append(" sc.FEC_FACT, ");
        sql.append(" od.CIVI_OID_CICLO_VIDA, ");
        sql.append(" od.TOFE_OID_TIPO_OFER, ");
        sql.append(" od.CNDP_OID_COND_PROM, ");
        //sql.append(" ts.IND_VENT_INTE_SAB_14, ");
        sql.append(" ter.COD_TERR, ");        
        sql.append(" ter.OID_TERR ");
        sql.append(" , sociedad.cod_soci");
        sql.append(" , almacen.cod_alma");
        sql.append(" , codmedioSap.val_medi");
        //sql.append(" , canalBPS.val_cana_bps");
        sql.append(" , periodoCorpo.cod_peri");
        sql.append(" , maeProd.cod_sap");
        sql.append(" , cicloVida.cod_cicl_vida");
        sql.append(" , tipoOferta.cod_tipo_ofer");
        sql.append(" , condProm.cod_cond_prom");
        sql.append(" , marca.cod_marc");
        sql.append(" , pais.MONE_OID_MONE ");
        sql.append(" , region.oid_regi ");
        sql.append(" , zona.oid_zona ");
        sql.append(" , periodo.cana_oid_cana ");
        UtilidadesLog.info("DAOINTSAPBPS.armarSelectVentaDiaSAPBPS29() - Salida");
        return sql;
    }


    /**
     * 
     */
    public ArrayList obtenerDatosPedidosSAP(DTOEnviarPedidosSAP dtoe, String codigoInterfaz) throws MareException{
        UtilidadesLog.info("DAOINTSAPBPS.obtenerDatosPedidosSAP(DTOEnviarPedidosSAP dtoe, String codigoInterfaz):Entrada");
        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer();
        
        sql.append(" SELECT  sol.pais_oid_pais, sol.perd_oid_peri, sol.sbac_oid_sbac, ");
        sql.append("         sol.almc_oid_alma, sol.soci_oid_soci, sol.tspa_oid_tipo_soli_pais, ");
        sql.append("         sol.ticl_oid_tipo_clie, ");
        if( ISAPBPS.COD_INTERFAZ_SAB13.equals( codigoInterfaz ) ){
            sql.append("         prd.mapr_oid_marc_prod, ");
        }
        sql.append("         COUNT (DISTINCT sol.oid_soli_cabe) AS numordenesdia ");
        sql.append("    FROM ped_solic_cabec sol, ");
        sql.append("         ped_tipo_solic_pais tsp, ");
        sql.append("         ped_tipo_solic ts, ");
        sql.append("         ped_solic_posic psp, ");
        sql.append("         mae_produ prd, int_param_tipo_solic pt  ");
        
        // gPineda - 19/02/2007 - INT-PRD-4
        sql.append("         , PRE_OFERT_DETAL POD, ");
        sql.append("         PRE_TIPO_OFERT OFE, ");
        sql.append("         PRE_CATAL CAT ");
        
        sql.append("   WHERE sol.pais_oid_pais = ? ");
        parametros.add( dtoe.getOidPais() );
        sql.append("     AND sol.perd_oid_peri = ? ");
        parametros.add( dtoe.getOidPeriodo() );
        sql.append("     AND sol.ind_oc = 1 ");
        sql.append("     AND sol.ind_pedi_prue = 0 ");
        sql.append("     AND sol.modu_oid_modu != ? ");
        parametros.add( new Long(ConstantesSEG.MODULO_INC) );
        sql.append("     AND sol.fec_fact IS NOT NULL ");
        sql.append("     AND sol.ind_ts_no_conso = 1 ");
        sql.append("     AND sol.fec_fact = TO_DATE (?, 'DD/MM/YYYY') ");
        parametros.add(new SimpleDateFormat("dd/MM/yyyy").format(dtoe.getFechaFacturacion()));
        sql.append("     AND psp.ESPO_OID_ESTA_POSI <> ? ");
        parametros.add( ConstantesPED.ESTADO_POSICION_ANULADO );
        sql.append("     AND sol.oid_soli_cabe = psp.soca_oid_soli_cabe ");
        sql.append("     AND psp.prod_oid_prod = prd.oid_prod ");
        sql.append("     AND prd.mapr_oid_marc_prod IS NOT NULL ");
        sql.append("     AND sol.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        sql.append("     AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli AND pt.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        
        // gPineda - 19/02/2007 - INT-PRD-4
        sql.append("     AND psp.OFDE_OID_DETA_OFER = POD.OID_DETA_OFER ");
        sql.append("     AND POD.TOFE_OID_TIPO_OFER = OFE.OID_TIPO_OFER ");
        sql.append("     AND POD.OCAT_OID_CATAL = CAT.OID_CATA(+) ");
        sql.append("     AND (NOT(OFE.COD_TIPO_OFER = '21' AND CAT.COD_CATA = 5) AND NOT(OFE.COD_TIPO_OFER = '23' AND CAT.COD_CATA = 5)) ");
        
        //jrivas 27/2/2007 Filtro de anul y devo
        sql.append("     AND ts.ind_anul = 0 ");
        sql.append("     AND ts.ind_devo = 0 ");
        
        sql.append(" GROUP BY sol.pais_oid_pais, ");
        sql.append("         sol.perd_oid_peri, ");
        sql.append("         sol.sbac_oid_sbac, ");
        sql.append("         sol.almc_oid_alma, ");
        sql.append("         sol.soci_oid_soci, ");
        sql.append("         sol.tspa_oid_tipo_soli_pais, ");
        sql.append("         ts.ind_anul, ts.ind_devo, ");
        sql.append("         sol.ticl_oid_tipo_clie ");
        if( ISAPBPS.COD_INTERFAZ_SAB13.equals( codigoInterfaz ) ){
            sql.append("         ,prd.mapr_oid_marc_prod ");
        }
                                                      
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
            rs =UtilidadesEJB.getBelcorpService().dbService.executePreparedQuery(sql.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
            UtilidadesLog.error(" DAOINTSAPBPS.obtenerDatosPedidosSAP() : Exception ",e);                                                             
            this.logSql(" DAOINTSAPBPS.obtenerDatosPedidosSAP() SQL: ",sql.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
        }
        
        ArrayList resultado = new ArrayList();
        Object obj;
        DTODatosPedSAP dtoDatosPedSAP;
        int tamanio = rs.getRowCount();
        HashMap hashDatos = new HashMap();
        UtilidadesLog.debug("DAOINTSAPBPS.obtenerDatosPedidosSAP() : rs.getRownCount() = "+ tamanio );
        for(int i = 0; i < tamanio ; i++){
            dtoDatosPedSAP = new DTODatosPedSAP();
            
            obj = rs.getValueAt(i, "PAIS_OID_PAIS");
            if (obj != null)  {
                dtoDatosPedSAP.setOidPais(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "PERD_OID_PERI");
            if ( obj != null)  {
                dtoDatosPedSAP.setOidPeriodo(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "SBAC_OID_SBAC");
            if ( obj != null)  {
                dtoDatosPedSAP.setOidSubAcceso(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "ALMC_OID_ALMA");
            if ( obj != null)  {
                dtoDatosPedSAP.setOidAlmacen(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "SOCI_OID_SOCI");
            if ( obj != null)  {
                dtoDatosPedSAP.setOidSociedad(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS");
            if ( obj != null)  {
                dtoDatosPedSAP.setOidTipoSolicitud(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "TICL_OID_TIPO_CLIE");
            if ( obj != null)  {
                dtoDatosPedSAP.setOidTipoCliente(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "NUMORDENESDIA");
            if ( obj != null) {
                dtoDatosPedSAP.setNumOrdenesDia(new Long(((BigDecimal)obj).longValue()));
            }
            if( ISAPBPS.COD_INTERFAZ_SAB13.equals( codigoInterfaz ) ){
                obj = rs.getValueAt(i, "MAPR_OID_MARC_PROD");
                if ( obj != null) {
                    dtoDatosPedSAP.setOidMarcaProducto(new Long(((BigDecimal)obj).longValue()));
                }
            }
            dtoDatosPedSAP.setNumPedidosAcumulados(new Long(0));
            String key = dtoDatosPedSAP.getOidSubAcceso() + "-" + dtoDatosPedSAP.getOidAlmacen() + "-" +
                         dtoDatosPedSAP.getOidSociedad() + "-" + dtoDatosPedSAP.getOidTipoSolicitud() + "-" +
                         dtoDatosPedSAP.getOidTipoCliente() + "-" + dtoDatosPedSAP.getOidMarcaProducto();
            hashDatos.put(key, dtoDatosPedSAP);            
        }
        parametros = new Vector();
        sql = new StringBuffer();
        
        sql.append(" SELECT  sol.pais_oid_pais, sol.perd_oid_peri, sol.sbac_oid_sbac, ");
        sql.append("         sol.almc_oid_alma, sol.soci_oid_soci, sol.tspa_oid_tipo_soli_pais, ");
        sql.append("         sol.ticl_oid_tipo_clie, ");
        if( ISAPBPS.COD_INTERFAZ_SAB13.equals( codigoInterfaz ) ){
            sql.append("         prd.mapr_oid_marc_prod, ");
        }
        sql.append(" COUNT ( DISTINCT sol.oid_soli_cabe) ");
        sql.append("    AS numpedidosacumulados ");
        sql.append("    FROM ped_solic_cabec sol, ");
        sql.append("         ped_tipo_solic_pais tsp, ");
        sql.append("         ped_tipo_solic ts, ");
        sql.append("         ped_solic_posic psp, ");
        sql.append("         mae_produ prd, int_param_tipo_solic pt  ");

        // jrivas - 27/02/2007 - INT-PRD-4
        sql.append("         , PRE_OFERT_DETAL POD, ");
        sql.append("         PRE_TIPO_OFERT OFE, ");
        sql.append("         PRE_CATAL CAT ");
        
        sql.append("   WHERE sol.pais_oid_pais = ? ");
        parametros.add( dtoe.getOidPais() );
        sql.append("     AND sol.perd_oid_peri = ? ");
        parametros.add( dtoe.getOidPeriodo() );
        sql.append("     AND sol.ind_oc = 1 ");
        sql.append("     AND sol.ind_pedi_prue = 0 ");
        sql.append("     AND sol.modu_oid_modu != ? ");
        parametros.add( new Long(ConstantesSEG.MODULO_INC) );
        sql.append("     AND sol.fec_fact IS NOT NULL ");
        sql.append("     AND sol.ind_ts_no_conso = 1 ");
        sql.append("     AND sol.fec_fact <= TO_DATE (?, 'DD/MM/YYYY') ");
        parametros.add(new SimpleDateFormat("dd/MM/yyyy").format(dtoe.getFechaFacturacion()));
        sql.append("     AND psp.ESPO_OID_ESTA_POSI <> ? ");
        parametros.add( ConstantesPED.ESTADO_POSICION_ANULADO );
        sql.append("     AND sol.oid_soli_cabe = psp.soca_oid_soli_cabe ");
        sql.append("     AND psp.prod_oid_prod = prd.oid_prod ");
        sql.append("     AND prd.mapr_oid_marc_prod IS NOT NULL ");
        sql.append("     AND sol.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        sql.append("     AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli AND pt.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais");
        sql.append("    and ts.ind_anul = 0 AND ts.ind_devo = 0 ");
        
        // jrivas - 27/02/2007 - INT-PRD-4
        sql.append("     AND psp.OFDE_OID_DETA_OFER = POD.OID_DETA_OFER ");
        sql.append("     AND POD.TOFE_OID_TIPO_OFER = OFE.OID_TIPO_OFER ");
        sql.append("     AND POD.OCAT_OID_CATAL = CAT.OID_CATA(+) ");
        sql.append("     AND (NOT(OFE.COD_TIPO_OFER = '21' AND CAT.COD_CATA = 5) AND NOT(OFE.COD_TIPO_OFER = '23' AND CAT.COD_CATA = 5)) ");
        
        sql.append("GROUP BY sol.pais_oid_pais, ");
        sql.append("         sol.perd_oid_peri, ");
        sql.append("         sol.sbac_oid_sbac, ");
        sql.append("         sol.almc_oid_alma, ");
        sql.append("         sol.soci_oid_soci, ");
        sql.append("         sol.tspa_oid_tipo_soli_pais, ");
        sql.append("         ts.ind_anul, ts.ind_devo, ");
        sql.append("         sol.ticl_oid_tipo_clie ");
        if( ISAPBPS.COD_INTERFAZ_SAB13.equals( codigoInterfaz ) ){
            sql.append("         ,prd.mapr_oid_marc_prod ");
        }
                                                      
        rs = null;                                                                                                             
        codigoError = null;                                                                                                       
        try{                                                                                                                             
            rs =UtilidadesEJB.getBelcorpService().dbService.executePreparedQuery(sql.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
            UtilidadesLog.error(" DAOINTSAPBPS.obtenerDatosPedidosSAP() : Exception ",e);                                                             
            this.logSql(" DAOINTSAPBPS.obtenerDatosPedidosSAP() SQL: ",sql.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
        }
        
        tamanio = rs.getRowCount();                
        for(int i = 0; i < tamanio ; i++){
            DTODatosPedSAP dtoDatosPedSAPaux = new DTODatosPedSAP();
            
            obj = rs.getValueAt(i, "PAIS_OID_PAIS");
            if (obj != null)  {
                dtoDatosPedSAPaux.setOidPais(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "PERD_OID_PERI");
            if ( obj != null)  {
                dtoDatosPedSAPaux.setOidPeriodo(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "SBAC_OID_SBAC");
            if ( obj != null)  {
                dtoDatosPedSAPaux.setOidSubAcceso(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "ALMC_OID_ALMA");
            if ( obj != null)  {
                dtoDatosPedSAPaux.setOidAlmacen(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "SOCI_OID_SOCI");
            if ( obj != null)  {
                dtoDatosPedSAPaux.setOidSociedad(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS");
            if ( obj != null)  {
                dtoDatosPedSAPaux.setOidTipoSolicitud(new Long(((BigDecimal)obj).longValue()));
            }
            obj = rs.getValueAt(i, "TICL_OID_TIPO_CLIE");
            if ( obj != null)  {
                dtoDatosPedSAPaux.setOidTipoCliente(new Long(((BigDecimal)obj).longValue()));
            }
            if( ISAPBPS.COD_INTERFAZ_SAB13.equals( codigoInterfaz ) ){
                obj = rs.getValueAt(i, "MAPR_OID_MARC_PROD");
                if ( obj != null) {
                    dtoDatosPedSAPaux.setOidMarcaProducto(new Long(((BigDecimal)obj).longValue()));
                }
            }
            obj = rs.getValueAt(i, "NUMPEDIDOSACUMULADOS");
            if ( obj != null) {
                dtoDatosPedSAPaux.setNumPedidosAcumulados(new Long(((BigDecimal)obj).longValue()));
            }
            
            dtoDatosPedSAPaux.setNumOrdenesDia(new Long(0));
            
            String key = dtoDatosPedSAPaux.getOidSubAcceso() + "-" + dtoDatosPedSAPaux.getOidAlmacen() + "-" +
                         dtoDatosPedSAPaux.getOidSociedad() + "-" + dtoDatosPedSAPaux.getOidTipoSolicitud() + "-" +
                         dtoDatosPedSAPaux.getOidTipoCliente() + "-" + dtoDatosPedSAPaux.getOidMarcaProducto();
            
            if (hashDatos.containsKey(key)) {
              dtoDatosPedSAP = (DTODatosPedSAP)hashDatos.get(key);
              obj = rs.getValueAt(i, "NUMPEDIDOSACUMULADOS");
              if ( obj != null) {
                  dtoDatosPedSAP.setNumPedidosAcumulados(dtoDatosPedSAPaux.getNumPedidosAcumulados());
              }
              hashDatos.put(key, dtoDatosPedSAP);
            } else {
              hashDatos.put(key, dtoDatosPedSAPaux);
            }
        }
        Iterator it = (Iterator)((Collection)hashDatos.values()).iterator();
        while (it.hasNext()) {
           resultado.add((DTODatosPedSAP)it.next());
        }
        
        UtilidadesLog.info("DAOINTSAPBPS.obtenerDatosPedidosSAP(DTOEnviarPedidosSAP dtoe, String codigoInterfaz):Salida");
        return resultado;
    }
    
     /**
      * CHANGELOG
      * ---------
      * dmorello, 23/12/2008 - Cambio RI 20080796 - Modifico obtencion de num. ordenes y num. pedidos:
      *     - Num. ordenes: cantidad de solicitudes (distintas) halladas
      *     - Num. pedidos: cantidad de clientes (distintos) hallados
      */
     public ArrayList obtenerDatosTotalesSAM17(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOINTSAPBPS.obtenerDatosTotalesSAM17(Long periodo):Entrada");
        StringBuffer query = new StringBuffer();
        ArrayList arrayDatos = new ArrayList();
        VentaTotalCampania ventaTotal;
        
        query.append("SELECT PAIS.COD_PAIS, ");
        query.append("       VAL_CANA_BPS,  ");     
        query.append("       SOC.COD_SOCI,");
        query.append("       MIN(ALM.COD_ALMA) COD_ALMA,");
        query.append("       VAL_MEDI, ");
        query.append("       SOC.OID_SOCI, ");
        query.append("       MIN(ALM.OID_ALMA) OID_ALMA, ");
        query.append("       SUM(NVL(VAL_NUME_UNID_PROY, 0)) VAL_NUME_UNID_PROY, ");
        query.append("       SUM(NVL(VAL_NUME_UNID_VEND, 0)) VAL_NUME_UNID_VEND, ");
        query.append("       SUM(NVL(VAL_NUME_UNID_FALT, 0)) VAL_NUME_UNID_FALT, ");
        query.append("       SUM(NVL(VAL_NUME_UNID_DEVU, 0)) VAL_NUME_UNID_DEVU, ");
        query.append("       SUM(NVL(VAL_NUME_UNID_ANUL, 0)) VAL_NUME_UNID_ANUL, ");
        query.append("       SUM(NVL(VAL_NUME_UNID_CANJ, 0)) VAL_NUME_UNID_CANJ, ");
        query.append("       SUM(NVL(VAL_NUME_UNID_TRUE, 0)) VAL_NUME_UNID_TRUE, ");
        query.append("       SUM(NVL(VAL_IMPO_VENT_NETA_PROY, 0)) VAL_IMPO_VENT_NETA_PROY, ");
        query.append("       SUM(NVL(VAL_IMPO_VENT_NETA_ATEN, 0)) VAL_IMPO_VENT_NETA_ATEN, ");
        query.append("       SUM(NVL(VAL_IMPO_VENT_NETA_FALT, 0)) VAL_IMPO_VENT_NETA_FALT, ");
        query.append("       SUM(NVL(VAL_IMPO_VENT_NETA_DEVO, 0)) VAL_IMPO_VENT_NETA_DEVO, ");
        query.append("       SUM(NVL(VAL_IMPO_VENT_NETA_ANUL, 0)) VAL_IMPO_VENT_NETA_ANUL, ");
        query.append("       SUM(NVL(VAL_IMPO_VENT_NETA_CANJ, 0)) VAL_IMPO_VENT_NETA_CANJ, ");
        query.append("       SUM(NVL(VAL_IMPO_VENT_NETA_TRUE, 0)) VAL_IMPO_VENT_NETA_TRUE, ");
        query.append("       SUM(NVL(VAL_IMPO_VENT_BRUT_REAL, 0)) VAL_IMPO_VENT_BRUT_REAL, ");
        query.append("       SUM(NVL(VAL_IMPO_VENT_BRUT_FALT, 0)) VAL_IMPO_VENT_BRUT_FALT ");
        query.append("FROM INT_VENTA_DIARI_TOTAL VDT, ");
        query.append("     SEG_PAIS PAIS, ");
        query.append("     SEG_SOCIE SOC, ");
        query.append("     BEL_ALMAC ALM ");
        query.append("WHERE VDT.PAIS_OID_PAIS = PAIS.OID_PAIS ");
        query.append("  AND VDT.SOCI_OID_SOCI = SOC.OID_SOCI ");
        query.append("  AND VDT.ALMC_OID_ALMA = ALM.OID_ALMA ");
        query.append("  AND VDT.PERD_OID_PERI = ").append(oidPeriodo);     
        query.append(" GROUP BY PAIS.COD_PAIS, ");
        query.append("       VAL_CANA_BPS,  ");     
        query.append("       SOC.COD_SOCI, ");
        //query.append("       ALM.COD_ALMA, ");
        query.append("       VAL_MEDI,  ");
        query.append("       SOC.OID_SOCI ");
        //query.append("       ALM.OID_ALMA ");
        
        RecordSet rs = null;
        
        rs = UtilidadesBD.executeQuery(query.toString());
        
        if (rs != null && !rs.esVacio()) {
            query = new StringBuffer();
            
            query.append("SELECT COUNT(DISTINCT ZZON_OID_ZONA) CANT_ZONAS ");
            query.append("     , COUNT(DISTINCT OID_SOLI_CABE) CANT_ORDENES ");
            query.append("     , COUNT(DISTINCT CLIE_OID_CLIE) CANT_PEDIDOS ");
            query.append("FROM PED_SOLIC_CABEC PSC, ");
            query.append("     SEG_MODUL SM, ");
            query.append("     PED_TIPO_SOLIC_PAIS TSP, ");
            query.append("     PED_TIPO_SOLIC PTS ");
            query.append("WHERE PSC.PERD_OID_PERI = ").append(oidPeriodo);            
            query.append("  AND PSC.IND_TS_NO_CONSO = 1 ");
            query.append("  AND PSC.IND_OC = 1 ");
            query.append("  AND PSC.IND_PEDI_PRUE <> 1   ");
            query.append("  AND PSC.FEC_FACT IS NOT NULL ");
            query.append("  AND PSC.MODU_OID_MODU = SM.OID_MODU ");
            query.append("  AND SM.COD_MODU <> 15 ");
            query.append("  AND PSC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
            query.append("  AND TSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
            query.append("  AND PTS.IND_ANUL <> 1 ");
            query.append("  AND PTS.IND_DEVO <> 1 ");
        
            RecordSet rs2 = null;
            rs2 = UtilidadesBD.executeQuery(query.toString());
            
            long cantZonas = 0;
            long cantOrdenes = 0;
            long cantPedidos = 0;
            
            if (rs2 != null && !rs2.esVacio()) {
                cantZonas = ((BigDecimal)rs2.getValueAt(0, "CANT_ZONAS")).longValue();
                cantOrdenes = ((BigDecimal)rs2.getValueAt(0, "CANT_ORDENES")).longValue();
                cantPedidos = ((BigDecimal)rs2.getValueAt(0, "CANT_PEDIDOS")).longValue();
            }            
            
            int rsSize = rs.getRowCount();
            for (int i = 0; i < rsSize; i++) {
                ventaTotal = new VentaTotalCampania();                  
                ventaTotal.setSociedad(UtilidadesBD.convertirALong(rs.getValueAt(i, "OID_SOCI")));
                ventaTotal.setAlmacen(UtilidadesBD.convertirALong(rs.getValueAt(i, "OID_ALMA")));
                ventaTotal.setCodigoPais(UtilidadesBD.convertirAString(rs.getValueAt(i, "COD_PAIS")));
                ventaTotal.setCodigoAlmacen(UtilidadesBD.convertirAString(rs.getValueAt(i, "COD_ALMA")));
                ventaTotal.setCanalBPS(UtilidadesBD.convertirAString(rs.getValueAt(i, "VAL_CANA_BPS")));
                ventaTotal.setCodigoMedio(UtilidadesBD.convertirAString(rs.getValueAt(i, "VAL_MEDI")));
                ventaTotal.setCodigoSociedad(UtilidadesBD.convertirAString(rs.getValueAt(i, "COD_SOCI")));
                ventaTotal.setUnidadesVendidasVendidas(UtilidadesBD.convertirALong(rs.getValueAt(i, "VAL_NUME_UNID_VEND")));
                ventaTotal.setUnidadesVendidasFaltantes(UtilidadesBD.convertirALong(rs.getValueAt(i, "VAL_NUME_UNID_FALT")));
                ventaTotal.setUnidadesVendidasDevueltas(UtilidadesBD.convertirALong(rs.getValueAt(i, "VAL_NUME_UNID_DEVU")));
                ventaTotal.setUnidadesVendidasAnuladas(UtilidadesBD.convertirALong(rs.getValueAt(i, "VAL_NUME_UNID_ANUL")));
                ventaTotal.setUnidadesVendidasCanje(UtilidadesBD.convertirALong(rs.getValueAt(i, "VAL_NUME_UNID_CANJ")));
                ventaTotal.setUnidadesVendidasTrueque(UtilidadesBD.convertirALong(rs.getValueAt(i, "VAL_NUME_UNID_TRUE")));
                ventaTotal.setPrecioFacturaTotalLocalVendidas(this.convertiraBigDecimal(rs.getValueAt(i, "VAL_IMPO_VENT_NETA_ATEN")));
                ventaTotal.setPrecioFacturaTotalLocalFaltantes(this.convertiraBigDecimal(rs.getValueAt(i, "VAL_IMPO_VENT_NETA_FALT")));
                ventaTotal.setPrecioFacturaTotalLocalDevueltas(this.convertiraBigDecimal(rs.getValueAt(i, "VAL_IMPO_VENT_NETA_DEVO")));
                ventaTotal.setPrecioFacturaTotalLocalAnuladas(this.convertiraBigDecimal(rs.getValueAt(i, "VAL_IMPO_VENT_NETA_ANUL")));
                ventaTotal.setPrecioFacturaTotalLocalCanje(this.convertiraBigDecimal(rs.getValueAt(i, "VAL_IMPO_VENT_NETA_CANJ")));
                ventaTotal.setPrecioFacturaTotalLocalTrueque(this.convertiraBigDecimal(rs.getValueAt(i, "VAL_IMPO_VENT_NETA_TRUE")));
                ventaTotal.setPrecioCatalogoTotalLocalVendidas(this.convertiraBigDecimal(rs.getValueAt(i, "VAL_IMPO_VENT_BRUT_REAL")));
                ventaTotal.setPrecioCatalogoTotalLocalFaltantes(this.convertiraBigDecimal(rs.getValueAt(i, "VAL_IMPO_VENT_BRUT_FALT")));
                ventaTotal.setNumeroZonas(new Long(cantZonas));
                ventaTotal.setNumeroOrdenes(new Long(cantOrdenes));
                ventaTotal.setNumeroPedidos(new Long(cantPedidos));
                arrayDatos.add(ventaTotal);
            }
        }
        
        
        UtilidadesLog.info("DAOINTSAPBPS.obtenerDatosTotalesSAM17(Long periodo):Salida");  
        return arrayDatos;
     }
     
    private BigDecimal convertiraBigDecimal(Object dato) {
        BigDecimal datoConvertido = new BigDecimal(0);
        if (dato != null) {
            datoConvertido = new BigDecimal(dato.toString());
        }
        return datoConvertido;
    }     

    
    public DTOPeriodo obtenerPeriodoCorporativo(DTOOID dtoe) throws MareException {
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String query = "SELECT * FROM seg_perio_corpo WHERE oid_peri = " + dtoe.getOid();
        
        try {
            rs = bs.dbService.executeStaticQuery(query);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        DTOPeriodo dtoPeriodo = null;
        if (!rs.esVacio()) {
            dtoPeriodo = new DTOPeriodo();
            dtoPeriodo.setOidPeriodoCorporativo(new Long(((BigDecimal)rs.getValueAt(0, "OID_PERI")).longValue()));
            dtoPeriodo.setTipo(new Long(((BigDecimal)rs.getValueAt(0, "TIPE_OID_TIPO_PERI")).longValue()));
            dtoPeriodo.setCodigoPeriodo(rs.getValueAt(0, "COD_PERI").toString());
            dtoPeriodo.setAnio(new Integer(((BigDecimal)rs.getValueAt(0, "VAL_ANIO")).intValue()));
        }
        
        UtilidadesLog.info("DAOCRA.obtenerPeriodo(DTOOID dtoe): Salida");
        return dtoPeriodo;
    }
    
    //20090063 jrivas 18/3/09
    public void guardarFuenteVentaRealMasivo (ArrayList ventaReal, String anioComercial) throws  MareException{
        UtilidadesLog.info("DAOINTSAPBPS.guardarFuenteVentaRealMasivo(ArrayList ventaReal, String anioComercial): Entrada");
        
        if(ventaReal != null && !ventaReal.isEmpty()) {
            Integer anio = null;
            if(anioComercial!=null) {
                anio = new Integer(anioComercial);        
            }    
            StringBuffer insertMasivo = new StringBuffer();
            
            int tamano = ventaReal.size();
            for(int i=0; i<tamano; i++) {
                FuenteVentasRealAcumulada venta = (FuenteVentasRealAcumulada)ventaReal.get(i);
            
                StringBuffer query = new StringBuffer();
                
                query.append("INSERT INTO INT_FUENT_VENTAS_REAL (OID_FUEN_VENT_REAL, VAL_ANIO_COME, NUM_ACTI_INIC,");
                query.append("NUM_ACTI_FINA, NUM_INGR, NUM_REIN, NUM_EGRE, NUM_REZO_RECI, NUM_REZO_ENTR, ");
                query.append("ZZON_OID_ZONA, PAIS_OID_PAIS, PERD_OID_PERI, ZORG_OID_REGI, TERR_OID_TERR ");
                query.append(") VALUES (");
                query.append(" INT_FVRL_SEQ.nextval, " + anio);
                query.append(", " + venta.getActivasIniciales());
                query.append(", " + venta.getActivasFinales());
                query.append(", " + venta.getIngresos());
                query.append(", " + venta.getReingresos());            
                query.append(", " + venta.getEgresos());
                query.append(", " + venta.getRezonificadasRecibidas());
                query.append(", " + venta.getRezonificadasEntregadas());                
                query.append(", " + venta.getZona());                
                query.append(", " + venta.getPais());                
                query.append(", " + venta.getPeriodo());                
                query.append(", " + venta.getRegion());                
                query.append(", " + venta.getOidTerritorio() + " )");
                query.append(";");
    
                insertMasivo.append(query);   
            }
            BelcorpService bs;
            try {
                bs = BelcorpService.getInstance();
            } catch (MareException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            try {
                bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", insertMasivo.toString());
            } catch (Exception e) {
                UtilidadesLog.error("Error en guardarFuenteVentaRealMasivo ",e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
        }
        UtilidadesLog.info("DAOINTSAPBPS.guardarFuenteVentaRealMasivo(ArrayList ventaReal, String anioComercial): Salida");
    }    
    
    //20090063 jrivas 18/3/09
    public void guardarFuenteVentaRealAcumuladaMasivo (ArrayList ventaReal) throws MareException{
       UtilidadesLog.info("DAOINTSAPBPS.guardarFuenteVentaRealAcumuladaMasivo(ArrayList ventaReal): Entrada");


        if(ventaReal != null && !ventaReal.isEmpty()) {
            StringBuffer insertMasivo = new StringBuffer();
            
            int tamano = ventaReal.size();
            for(int i=0; i<tamano; i++) {
                FuenteVentasRealAcumulada venta = (FuenteVentasRealAcumulada)ventaReal.get(i);
            
                StringBuffer query = new StringBuffer();

                Double ventaNeta = null;
                java.sql.Date fechaCierre = null;
                if(venta.getVentaNetaEstadisticable()!=null) {
                    ventaNeta = (new Double(venta.getVentaNetaEstadisticable().doubleValue()));
                }
                if(venta.getFechaCierre()!=null) {
                    fechaCierre = (new java.sql.Date(venta.getFechaCierre().getTime()));
                }
                
                query.append("INSERT INTO INT_FUENT_VENTA_REAL_VACUM (OID_FUEN_VENT_REAL_VACU, NUM_ORDE, NUM_PEDI, ");
                query.append("NUM_UNID_VEND, NUM_CLIE, IMP_VENT_NETA_ESTA, FEC_CIER, TSPA_OID_TIPO_SOLI_PAIS, ");
                query.append("TICL_OID_TIPO_CLIE, ZORG_OID_REGI, SOCI_OID_SOCI, ZZON_OID_ZONA, ALMC_OID_ALMA,  ");
                query.append("PAIS_OID_PAIS, PERD_OID_PERI, TERR_OID_TERR ");                
                query.append(") VALUES (");
                query.append(" INT_FVRA_SEQ.nextval, " + venta.getNumeroOrdenes());
                query.append(", " + venta.getNumeroPedidos());
                query.append(", " + venta.getUnidadesVendidas());
                query.append(", " + venta.getNumeroClientes());
                query.append(", " + ventaNeta);            
                if(venta.getFechaCierre()!=null) {                
                    query.append(", TO_DATE('"+fechaCierre+"' ,'YYYY-MM-DD') ");
                } else {
                    query.append(", NULL ");
                }
                query.append(", " + venta.getTipoSolicitudPais());
                query.append(", " + venta.getTipoCliente());                
                query.append(", " + venta.getRegion());                
                query.append(", " + venta.getSociedad());                
                query.append(", " + venta.getZona());                
                query.append(", " + venta.getAlmacen());    
                query.append(", " + venta.getPais());  
                query.append(", " + venta.getPeriodo());  
                query.append(", " + venta.getOidTerritorio() + " )");
                query.append(";");
        
                insertMasivo.append(query);   
            }
            BelcorpService bs;
            try {
                bs = BelcorpService.getInstance();
            } catch (MareException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            try {
                bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", insertMasivo.toString());
            } catch (Exception e) {
                UtilidadesLog.error("Error en guardarFuenteVentaRealAcumuladaMasivo ",e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
        }
       
       UtilidadesLog.info("DAOINTSAPBPS.guardarFuenteVentaRealAcumulada(ArrayList ventaReal): Salida");
    }    
 
    /**
     * 23-11-2010       Agregado por DOliva, cambio PER-SiCC-2010-0658 Modificar Interfase de ventas para Ecuador.
     *                  Devuelve la cantidad de registros
     * @throws es.indra.mare.common.exception.MareException
     */
    public int obtenerCantidadEquivalencias() throws MareException {
        UtilidadesLog.info("DAOINTSAPBPS.obtenerCantidadEquivalencias(): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        consulta.append(" select 1                                      ");
        consulta.append("   from pre_matri_factu_cabec a,               ");
        consulta.append("        pre_ofert             b,               ");
        consulta.append("        pre_ofert_detal       c,               ");
        consulta.append("        pre_matri_factu       d,               ");
        consulta.append("        cra_perio             e,               ");
        consulta.append("        seg_perio_corpo       f,               ");
        consulta.append("        pre_ofert_detal       g,               ");
        consulta.append("        pre_matri_factu       h,               ");
        consulta.append("        pre_matri_codig_alter i,               ");
        consulta.append("        mae_produ             j,               ");
        consulta.append("        mae_produ             k,               ");
        consulta.append("        gen_i18n_sicc_pais    l,               ");
        consulta.append("        gen_i18n_sicc_pais    m,               ");
        consulta.append("        pre_tipo_ofert        t,               ");
        consulta.append("        pre_tipo_ofert        u,               ");
        consulta.append("        pre_prod_alter_ice    equi             ");
        consulta.append("  where a.OID_CABE = b.MFCA_OID_CABE           ");
        consulta.append("    and b.OID_OFER = c.OFER_OID_OFER           ");
        consulta.append("    and c.OID_DETA_OFER = d.OFDE_OID_DETA_OFER ");
        consulta.append("    and a.PERD_OID_PERI = e.OID_PERI           ");
        consulta.append("    and i.MAFA_OID_COD_PPAL = d.OID_MATR_FACT  ");
        consulta.append("    and i.MAFA_OID_COD_ALTE = h.OID_MATR_FACT  ");
        consulta.append("    and h.OFDE_OID_DETA_OFER = g.OID_DETA_OFER ");
        consulta.append("    and f.OID_PERI = e.PERI_OID_PERI           ");
        consulta.append("    and c.PROD_OID_PROD = j.OID_PROD           ");
        consulta.append("    and j.OID_PROD = l.VAL_OID                 ");
        consulta.append("    and l.ATTR_ENTI = 'MAE_PRODU'              ");
        consulta.append("    and g.PROD_OID_PROD = k.OID_PROD           ");
        consulta.append("    and k.OID_PROD = m.VAL_OID                 ");
        consulta.append("    and m.ATTR_ENTI = 'MAE_PRODU'              ");
        consulta.append("    and g.tofe_oid_tipo_ofer = t.oid_tipo_ofer ");
        consulta.append("    and c.tofe_oid_tipo_ofer = u.oid_tipo_ofer ");
        consulta.append("    and j.COD_SAP = equi.COD_SAP_PPAL          ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerCantidadEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {
            return rs.getRowCount();            
        }

        UtilidadesLog.info("DAOINTSAPBPS.obtenerCantidadEquivalencias(): Salida");

        return 0;
    }
 
     /**
      * 24-11-2010       Agregado por DOliva, cambio PER-SiCC-2010-0658 Modificar Interfase de ventas para Ecuador.
      *                  Limpia la tabla e inserta los valores a la tabla temporal que se utilizara en el proceso
      *                  de reemplazo de equivalencias
      * @throws es.indra.mare.common.exception.MareException
      */    
    public void cargarTemporalVentaDia(DTOEnviarPedidosSAP dtoe, String codigo) throws MareException {
                 UtilidadesLog.info("DAOINTSAPBPS.cargarTemporalVentaDia(DTOEnviarPedidosSAP dtoe, String codigo): Entrada");                                                                        
        
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();

        StringBuffer sql = new StringBuffer();        
        StringBuffer insertsql = new StringBuffer(); 
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();   
        // Limpia tabla temporal
        try {
            UtilidadesLog.info("borrar");        
            bs.dbService.executeUpdate("DELETE TMP_VENTA_DIARI");
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("Dennys INSERTA EN TEMPORAL");     
        
        //PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS , 
        //se obtine el codigo periodo
         String codigoPeriodo = "";
         Long indicadorCruce = null;
         Long periodoSiguiente= null;
        String valParametro="";
        try{
        codigoPeriodo = obtenerCodigoPeriodo(dtoe.getOidPeriodo());
        indicadorCruce = obtenerIndicadorCruce(dtoe.getOidPeriodo());//SI ESTA DESACTIVADO SE REALIZA EL NUEVO FILTRO
        periodoSiguiente= obtenerNPeriodo(codigoPeriodo,dtoe.getOidPais(),1);        
        valParametro = obtenerParametroGenerico(dtoe.getOidPais(),"SAB","001");
        UtilidadesLog.info("codigoPeriodo "+codigoPeriodo+" periodoSiguiente "+periodoSiguiente+" indicadorCruce "+indicadorCruce + " parametroPais " +valParametro);
        }catch(Exception e){
         e.printStackTrace();    
        }
        if("0".equals(valParametro)){
            sql.append("insert into TMP_VENTA_DIARI");      
            sql.append("(pais_oid_pais, perd_oid_peri, almc_oid_alma, soci_oid_soci, prod_oid_prod, fec_fact, val_unid_aten_vend,");
            sql.append("val_unid_aten_falt, val_unid_aten_devu, val_unid_aten_anul, val_unid_aten_canj, val_unid_aten_true, val_vent_neta_vend, ");
            sql.append("val_vent_neta_falt, val_vent_neta_devu, val_vent_neta_anul, val_vent_neta_canj, val_vent_neta_true, val_prec_cata_vend, ");
            sql.append("val_prec_cata_falt, civi_oid_ciclo_vida, tofe_oid_tipo_ofer, cndp_oid_cond_prom, ind_vent_inte_sab_14, cod_terr, oid_terr, ");
            sql.append("cod_soci, cod_alma, val_medi, val_cana_bps, cod_peri, cod_sap, cod_cicl_vida, cod_tipo_ofer, cod_cond_prom, cod_marc, ");
            sql.append("num_unid_por_aten, mone_oid_mone, cana_oid_cana, val_codi_vent, cod_peri_refe)");
            sql.append("(SELECT sc.PAIS_OID_PAIS PAIS, ");
            sql.append(" sc.PERD_OID_PERI OIDPERIODO, ");
            sql.append(" MIN(sc.ALMC_OID_ALMA) OIDALMACEN, ");
            sql.append(" sc.SOCI_OID_SOCI OIDSOCIEDAD, ");
            sql.append(" sp.PROD_OID_PROD OIDPRODUCTO, ");
            sql.append(" sc.FEC_FACT FECHAFACTURACION, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_VEND_OTRO = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END) AS unid_aten_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.num_unid_falt = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_FALT_OTRO = 1 THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) ELSE 0 END) AS unid_aten_faltantes, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_DEVU = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_devueltas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_ANUL = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_anuladas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_CANJ = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_canje, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_TRUE = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_trueque, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_VEND_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END) AS venta_neta_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_FALT_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) * sp.val_prec_neto_unit_loca ELSE 0 END) AS venta_neta_faltantes, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_DEVU = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_devueltas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_ANUL = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_anuladas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_CANJ = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_canje, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_TRUE = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)) AS venta_neta_trueque, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_VEND_OTRO = 1 THEN sp.VAL_PREC_CATA_TOTA_LOCA ELSE 0 END) AS prec_cata_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_FALT_OTRO = 1 THEN (sp.num_unid_dema_real - sp.num_unid_compr) * sp.val_prec_cata_unit_loca ELSE 0 END) AS prec_cata_faltantes, ");
            sql.append(" od.CIVI_OID_CICLO_VIDA OIDCICLOVIDA, ");
            sql.append(" od.TOFE_OID_TIPO_OFER OIDTIPOOFERTA, ");
            sql.append(" od.cndp_oid_cond_prom oidcondicionpromocion, ");
            sql.append(" 1 FLAGVENTA, ");
            sql.append(" ter.COD_TERR territorio, ");
            sql.append(" ter.OID_TERR OIDTERRITORIO ");
            sql.append(" , sociedad.cod_soci CODIGOSOCIEDAD");
            sql.append(" , MIN(almacen.cod_alma) CODIGOALMACEM");
            sql.append(" , codmedioSap.val_medi MEDIO");
            sql.append(" , 1 canalBPS");
            sql.append(" , periodoCorpo.cod_peri codPeriodo");
            sql.append(" , maeProd.cod_sap codSap");
            sql.append(" , cicloVida.cod_cicl_vida codCicloVida");
            sql.append(" , tipoOferta.cod_tipo_ofer codTipoOfer");
            sql.append(" , NVL(condProm.cod_cond_prom, '00' ) codCondProm");
            sql.append(" , marca.cod_marc codMarca");
            sql.append(" , SUM(CASE WHEN pt.NUM_UNID_FALT = 1 OR pt.NUM_UNID_FALT_OTRO = 1 THEN (sp.num_unid_dema_real - sp.num_unid_compr) ELSE 0 END) AS NUM_UNID_POR_ATEN ");
            sql.append(" ,pais.MONE_OID_MONE oidMoneda");
            sql.append(" ,periodo.cana_oid_cana ");
            sql.append(" ,sp.val_codi_vent ");
            
            // sapaza -- PER-SiCC-2011-0148 -- 03/03/2011
            sql.append(" ,(select s1.cod_peri from ped_solic_cabec c1, cra_perio p1, seg_perio_corpo s1 ");
            sql.append("    where c1.oid_soli_cabe = sc.soca_oid_docu_refe and c1.perd_oid_peri = p1.oid_peri and p1.peri_oid_peri = s1.oid_peri) cod_peri_refe ");
    
            sql.append(" FROM  ");
            sql.append(" PED_SOLIC_CABEC sc, ");
            sql.append(" PED_SOLIC_POSIC sp, ");
            sql.append(" PED_TIPO_SOLIC_PAIS ts, ");
            sql.append(" INT_PARAM_TIPO_SOLIC pt, ");
            sql.append(" (SELECT pod.oid_deta_ofer, pod.val_codi_vent, pod.civi_oid_ciclo_vida, pod.tofe_oid_tipo_ofer, ");
            sql.append("    (CASE WHEN pod.cndp_oid_cond_prom IS NULL ");
            sql.append("          THEN (SELECT oid_cond_prom FROM pre_condi_promo WHERE cod_cond_prom = '00') ");
            sql.append("          ELSE pod.cndp_oid_cond_prom ");
            sql.append("     END) cndp_oid_cond_prom ");
            sql.append("  FROM pre_ofert_detal pod) od, ");
            sql.append(" zon_terri ter ");        
            sql.append(" ,seg_pais pais ");
            sql.append(", seg_socie sociedad ");        
            sql.append(", bel_almac almacen ");        
            sql.append(", int_codig_medio_sapbp codmedioSap ");
            //sql.append(", int_canal_bps canalBPS ");
            sql.append(", cra_perio periodo ");
            sql.append(", seg_perio_corpo periodoCorpo ");
            sql.append(", mae_produ maeProd ");
            sql.append(", pre_ciclo_vida cicloVida ");
            sql.append(", pre_tipo_ofert tipoOferta ");
            sql.append(", pre_condi_promo condProm ");
            sql.append(", seg_marca marca ");
            sql.append(", PED_TIPO_SOLIC tsol ");
            sql.append(" WHERE  ");
            sql.append(" sp.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
            sql.append(" AND sp.OFDE_OID_DETA_OFER = od.OID_DETA_OFER (+) ");
            sql.append(" AND sc.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
            sql.append(" AND pt.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
            sql.append(" AND sc.PAIS_OID_PAIS = ? ");
            sql.append(" AND sc.pais_oid_pais = pais.OID_PAIS ");
            parametros.add(dtoe.getOidPais());
         /*   if (dtoe.getOidPeriodo() != null){
                sql.append(" AND sc.PERD_OID_PERI = ? ");
                parametros.add(dtoe.getOidPeriodo());            
            }*/
            if (dtoe.getOidPeriodo() != null){
                sql.append(" AND (sc.PERD_OID_PERI = ? ");
                parametros.add(dtoe.getOidPeriodo());            
                sql.append("     OR ( "+indicadorCruce +"=0 AND sc.PERD_OID_PERI = " + periodoSiguiente+") )");             
            }        
            if (dtoe.getFechaFacturacion() != null){
                String fecha = convierteFecha(dtoe.getFechaFacturacion());
                sql.append(" AND sc.FEC_FACT = TO_DATE( ? ,'YYYY-MM-DD') ");
                parametros.add(fecha);
            }
            sql.append(" AND sc.IND_TS_NO_CONSO = 1  ");
            sql.append(" AND sc.IND_PEDI_PRUE = 0  ");
            sql.append(" AND sp.ESPO_OID_ESTA_POSI <> ? ");
            parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
            sql.append(" AND sp.VAL_CODI_VENT = od.VAL_CODI_VENT (+) ");
            sql.append(" AND ter.OID_TERR = sc.TERR_OID_TERR ");
            sql.append(" AND sc.SOCI_OID_SOCI = sociedad.oid_soci ");
            sql.append(" AND sc.ALMC_OID_ALMA =  almacen.oid_alma ");
            sql.append(" AND sc.PAIS_OID_PAIS = codmedioSap.pais_oid_pais AND sc.SBAC_OID_SBAC = codmedioSap.sbac_oid_sbac ");
            //sql.append(" AND sc.TICL_OID_TIPO_CLIE = canalBPS.ticl_oid_tipo_clie AND sc.TSPA_OID_TIPO_SOLI_PAIS = canalBPS.TSPA_OID_TIPO_SOLI_PAIS ");
            sql.append(" AND sc.PERD_OID_PERI = periodo.oid_peri ");
            sql.append(" AND periodo.peri_oid_peri = periodoCorpo.oid_peri ");
            sql.append(" AND sp.PROD_OID_PROD = maeProd.oid_prod ");
            sql.append(" AND od.CIVI_OID_CICLO_VIDA = cicloVida.oid_cicl_vida (+) ");
            sql.append(" AND od.TOFE_OID_TIPO_OFER = tipoOferta.oid_tipo_ofer (+) ");
            sql.append(" AND od.CNDP_OID_COND_PROM = condProm.oid_cond_prom (+) ");
            sql.append(" AND periodo.marc_oid_marc = marca.oid_marc ");
            sql.append(" AND TS.TSOL_OID_TIPO_SOLI = tsol.OID_TIPO_SOLI ");
            sql.append(" AND ( ");
            sql.append("       ( ");
            sql.append("          pt.NUM_UNID_VEND = 1 ");
            sql.append("          AND tsol.IND_ANUL = 0 ");
            sql.append("          AND tsol.IND_DEVO = 0 ");
            sql.append("          AND sc.IND_OC = 1 ");
            sql.append("       ) OR ( ");
            sql.append("          pt.NUM_UNID_FALT = 1  ");
            sql.append("          AND tsol.IND_ANUL = 0 ");
            sql.append("          AND tsol.IND_DEVO = 0 ");
            sql.append("          AND sc.IND_OC = 1 ");
            sql.append("       ) OR ( ");
            
            sql.append("              (pt.NUM_UNID_DEVU = 1 OR pt.NUM_UNID_ANUL = 1 OR pt.NUM_UNID_CANJ = 1 ");
            sql.append("               OR pt.NUM_UNID_TRUE = 1) AND ");
            sql.append("              FN_DAT_VALIDAR_PROD_SOLI_DEVO(sc.OID_SOLI_CABE, sp.OID_SOLI_POSI) > 0 ");
            sql.append("            ) ");
            sql.append(" )");
            
            sql.append(" GROUP BY sc.PAIS_OID_PAIS , ");
            sql.append(" sc.PERD_OID_PERI, ");
            //sql.append(" sc.ALMC_OID_ALMA, ");
            sql.append(" sc.SOCI_OID_SOCI, ");
            sql.append(" sp.PROD_OID_PROD, ");
            sql.append(" sc.FEC_FACT, ");
            sql.append(" od.CIVI_OID_CICLO_VIDA, ");
            sql.append(" od.TOFE_OID_TIPO_OFER, ");
            sql.append(" od.CNDP_OID_COND_PROM, ");
            //sql.append(" ts.IND_VENT_INTE_SAB_14, ");
            sql.append(" ter.COD_TERR, ");        
            sql.append(" ter.OID_TERR ");
            sql.append(" , sociedad.cod_soci");
            //sql.append(" , almacen.cod_alma");
            sql.append(" , codmedioSap.val_medi");
            //sql.append(" , canalBPS.val_cana_bps");
            sql.append(" , periodoCorpo.cod_peri");
            sql.append(" , maeProd.cod_sap");
            sql.append(" , cicloVida.cod_cicl_vida");
            sql.append(" , tipoOferta.cod_tipo_ofer");
            sql.append(" , condProm.cod_cond_prom");
            sql.append(" , marca.cod_marc");
            sql.append(" , pais.MONE_OID_MONE ");
            sql.append(" ,periodo.cana_oid_cana ");
            sql.append(" ,sp.val_codi_vent ");
            
             // sapaza -- PER-SiCC-2011-0148 -- 03/03/2011
            sql.append(" ,sc.soca_oid_docu_refe" + ")");
        }else {//realizando join con el fac_doucm_linea
        
            sql.append("insert into TMP_VENTA_DIARI");      
            sql.append("(pais_oid_pais, perd_oid_peri, almc_oid_alma, soci_oid_soci, prod_oid_prod, fec_fact, val_unid_aten_vend,");
            sql.append("val_unid_aten_falt, val_unid_aten_devu, val_unid_aten_anul, val_unid_aten_canj, val_unid_aten_true, val_vent_neta_vend, ");
            sql.append("val_vent_neta_falt, val_vent_neta_devu, val_vent_neta_anul, val_vent_neta_canj, val_vent_neta_true, val_prec_cata_vend, ");
            sql.append("val_prec_cata_falt, civi_oid_ciclo_vida, tofe_oid_tipo_ofer, cndp_oid_cond_prom, ind_vent_inte_sab_14, cod_terr, oid_terr, ");
            sql.append("cod_soci, cod_alma, val_medi, val_cana_bps, cod_peri, cod_sap, cod_cicl_vida, cod_tipo_ofer, cod_cond_prom, cod_marc, ");
            sql.append("num_unid_por_aten, mone_oid_mone, cana_oid_cana, val_codi_vent, cod_peri_refe)");
            sql.append("(SELECT sc.PAIS_OID_PAIS PAIS, ");
            sql.append(" sc.PERD_OID_PERI OIDPERIODO, ");
            sql.append(" MIN(sc.ALMC_OID_ALMA) OIDALMACEN, ");
            sql.append(" sc.SOCI_OID_SOCI OIDSOCIEDAD, ");
            sql.append(" sp.PROD_OID_PROD OIDPRODUCTO, ");
            sql.append(" sc.FEC_FACT FECHAFACTURACION, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_VEND_OTRO = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END) AS unid_aten_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.num_unid_falt = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_FALT_OTRO = 1 THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) ELSE 0 END) AS unid_aten_faltantes, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_DEVU = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_devueltas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_ANUL = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_anuladas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_CANJ = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_canje, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_TRUE = 1 THEN sp.NUM_UNID_ATEN ELSE 0 END)) AS unid_aten_trueque, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_VEND_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END) AS venta_neta_vendidas, ");
            //sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_FALT_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) * sp.val_prec_neto_unit_loca - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END) AS venta_neta_faltantes, ");                        
            if (dtoe.getFechaFacturacion() != null){
                String fecha = convierteFecha(dtoe.getFechaFacturacion());            
                sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_FALT_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) * (sp.val_prec_neto_unit_loca - NVL((SELECT x.val_impu_prod_naci FROM INT_IMPUE_PRODU_NACIO x WHERE x.prod_oid_prod  = SP.PROD_OID_PROD  AND x.fec_carg = (SELECT MAX(y.fec_carg) FROM int_impue_produ_nacio y WHERE y.prod_oid_prod = SP.PROD_OID_PROD AND y.fec_carg <=  TO_DATE( ? ,'YYYY-MM-DD'))),0)) ELSE 0 END) AS venta_neta_faltantes, ");
                parametros.add(fecha);
            }else{
                sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1 AND sp.val_prec_cata_unit_loca<>0) OR (PT.NUM_UNID_FALT_OTRO = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA <> 0) THEN (sp.NUM_UNID_DEMA_REAL - sp.num_unid_compr) * (sp.val_prec_neto_unit_loca - NVL((SELECT x.val_impu_prod_naci FROM INT_IMPUE_PRODU_NACIO x WHERE x.prod_oid_prod  = SP.PROD_OID_PROD  AND x.fec_carg = (SELECT MAX(y.fec_carg) FROM int_impue_produ_nacio y WHERE y.prod_oid_prod = SP.PROD_OID_PROD AND TRUNC(y.fec_carg) <=  TRUNC(SYSDATE) )),0)) ELSE 0 END) AS venta_neta_faltantes, ");
            }            
                        
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_DEVU = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END)) AS venta_neta_devueltas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_ANUL = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END)) AS venta_neta_anuladas, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_CANJ = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END)) AS venta_neta_canje, ");
            sql.append(" ABS(SUM(CASE WHEN pt.NUM_UNID_TRUE = 1 AND sp.val_prec_cata_unit_loca<>0 THEN sp.VAL_PREC_NETO_TOTA_LOCA - NVL(fdl.iMP_IMPU_TOTA_PROD_NACI,0) ELSE 0 END)) AS venta_neta_trueque, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_VEND = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_VEND_OTRO = 1 THEN sp.VAL_PREC_CATA_TOTA_LOCA ELSE 0 END) AS prec_cata_vendidas, ");
            sql.append(" SUM(CASE WHEN (pt.NUM_UNID_FALT = 1 AND sc.ind_oc = 1) OR PT.NUM_UNID_FALT_OTRO = 1 THEN (sp.num_unid_dema_real - sp.num_unid_compr) * sp.val_prec_cata_unit_loca ELSE 0 END) AS prec_cata_faltantes, ");
            sql.append(" od.CIVI_OID_CICLO_VIDA OIDCICLOVIDA, ");
            sql.append(" od.TOFE_OID_TIPO_OFER OIDTIPOOFERTA, ");
            sql.append(" od.cndp_oid_cond_prom oidcondicionpromocion, ");
            sql.append(" 1 FLAGVENTA, ");
            sql.append(" ter.COD_TERR territorio, ");
            sql.append(" ter.OID_TERR OIDTERRITORIO ");
            sql.append(" , sociedad.cod_soci CODIGOSOCIEDAD");
            sql.append(" , MIN(almacen.cod_alma) CODIGOALMACEM");
            sql.append(" , codmedioSap.val_medi MEDIO");
            sql.append(" , 1 canalBPS");
            sql.append(" , periodoCorpo.cod_peri codPeriodo");
            sql.append(" , maeProd.cod_sap codSap");
            sql.append(" , cicloVida.cod_cicl_vida codCicloVida");
            sql.append(" , tipoOferta.cod_tipo_ofer codTipoOfer");
            sql.append(" , NVL(condProm.cod_cond_prom, '00' ) codCondProm");
            sql.append(" , marca.cod_marc codMarca");
            sql.append(" , SUM(CASE WHEN pt.NUM_UNID_FALT = 1 OR pt.NUM_UNID_FALT_OTRO = 1 THEN (sp.num_unid_dema_real - sp.num_unid_compr) ELSE 0 END) AS NUM_UNID_POR_ATEN ");
            sql.append(" ,pais.MONE_OID_MONE oidMoneda");
            sql.append(" ,periodo.cana_oid_cana ");
            sql.append(" ,sp.val_codi_vent ");
            
            // sapaza -- PER-SiCC-2011-0148 -- 03/03/2011
            sql.append(" ,(select s1.cod_peri from ped_solic_cabec c1, cra_perio p1, seg_perio_corpo s1 ");
            sql.append("    where c1.oid_soli_cabe = sc.soca_oid_docu_refe and c1.perd_oid_peri = p1.oid_peri and p1.peri_oid_peri = s1.oid_peri) cod_peri_refe ");
            
            sql.append(" FROM  ");
            sql.append(" PED_SOLIC_CABEC sc, ");
            sql.append(" PED_SOLIC_POSIC sp, ");
            sql.append(" PED_TIPO_SOLIC_PAIS ts, ");
            sql.append(" INT_PARAM_TIPO_SOLIC pt, ");
            sql.append(" (SELECT pod.oid_deta_ofer, pod.val_codi_vent, pod.civi_oid_ciclo_vida, pod.tofe_oid_tipo_ofer, ");
            sql.append("    (CASE WHEN pod.cndp_oid_cond_prom IS NULL ");
            sql.append("          THEN (SELECT oid_cond_prom FROM pre_condi_promo WHERE cod_cond_prom = '00') ");
            sql.append("          ELSE pod.cndp_oid_cond_prom ");
            sql.append("     END) cndp_oid_cond_prom ");
            sql.append("  FROM pre_ofert_detal pod) od, ");
            sql.append(" zon_terri ter ");        
            sql.append(" ,seg_pais pais ");
            sql.append(", seg_socie sociedad ");        
            sql.append(", bel_almac almacen ");        
            sql.append(", int_codig_medio_sapbp codmedioSap ");
            //sql.append(", int_canal_bps canalBPS ");
            sql.append(", cra_perio periodo ");
            sql.append(", seg_perio_corpo periodoCorpo ");
            sql.append(", mae_produ maeProd ");
            sql.append(", pre_ciclo_vida cicloVida ");
            sql.append(", pre_tipo_ofert tipoOferta ");
            sql.append(", pre_condi_promo condProm ");
            sql.append(", seg_marca marca ");
            sql.append(", PED_TIPO_SOLIC tsol ");
            sql.append(", FAC_DOCUM_CONTA_LINEA fdl ");
            sql.append(" WHERE  ");
            sql.append(" sp.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
            sql.append(" AND sp.OFDE_OID_DETA_OFER = od.OID_DETA_OFER (+) ");
            sql.append(" AND sc.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
            sql.append(" AND pt.TSPA_OID_TIPO_SOLI_PAIS = ts.OID_TIPO_SOLI_PAIS ");
            sql.append(" AND sc.PAIS_OID_PAIS = ? ");
            sql.append(" AND sc.pais_oid_pais = pais.OID_PAIS ");
            parametros.add(dtoe.getOidPais());
            /*   if (dtoe.getOidPeriodo() != null){
                sql.append(" AND sc.PERD_OID_PERI = ? ");
                parametros.add(dtoe.getOidPeriodo());            
            }*/
            if (dtoe.getOidPeriodo() != null){
                sql.append(" AND (sc.PERD_OID_PERI = ? ");
                parametros.add(dtoe.getOidPeriodo());            
                sql.append("     OR ( "+indicadorCruce +"=0 AND sc.PERD_OID_PERI = " + periodoSiguiente+") )");             
            }        
            if (dtoe.getFechaFacturacion() != null){
                String fecha = convierteFecha(dtoe.getFechaFacturacion());
                sql.append(" AND sc.FEC_FACT = TO_DATE( ? ,'YYYY-MM-DD') ");
                parametros.add(fecha);
            }
            sql.append(" AND sc.IND_TS_NO_CONSO = 1  ");
            sql.append(" AND sc.IND_PEDI_PRUE = 0  ");
            sql.append(" AND sp.ESPO_OID_ESTA_POSI <> ? ");
            parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
            sql.append(" AND sp.VAL_CODI_VENT = od.VAL_CODI_VENT (+) ");
            sql.append(" AND ter.OID_TERR = sc.TERR_OID_TERR ");
            sql.append(" AND sc.SOCI_OID_SOCI = sociedad.oid_soci ");
            sql.append(" AND sc.ALMC_OID_ALMA =  almacen.oid_alma ");
            sql.append(" AND sc.PAIS_OID_PAIS = codmedioSap.pais_oid_pais AND sc.SBAC_OID_SBAC = codmedioSap.sbac_oid_sbac ");
            //sql.append(" AND sc.TICL_OID_TIPO_CLIE = canalBPS.ticl_oid_tipo_clie AND sc.TSPA_OID_TIPO_SOLI_PAIS = canalBPS.TSPA_OID_TIPO_SOLI_PAIS ");
            sql.append(" AND sc.PERD_OID_PERI = periodo.oid_peri ");
            sql.append(" AND periodo.peri_oid_peri = periodoCorpo.oid_peri ");
            sql.append(" AND sp.PROD_OID_PROD = maeProd.oid_prod ");
            sql.append(" AND od.CIVI_OID_CICLO_VIDA = cicloVida.oid_cicl_vida (+) ");
            sql.append(" AND od.TOFE_OID_TIPO_OFER = tipoOferta.oid_tipo_ofer (+) ");
            sql.append(" AND od.CNDP_OID_COND_PROM = condProm.oid_cond_prom (+) ");
            sql.append(" AND periodo.marc_oid_marc = marca.oid_marc ");
            sql.append(" AND TS.TSOL_OID_TIPO_SOLI = tsol.OID_TIPO_SOLI ");
            sql.append("  and fdl.SOPO_OID_SOLI_POSI(+) = sp.OID_SOLI_POSI  ");
            sql.append(" AND ( ");
            sql.append("       ( ");
            sql.append("          pt.NUM_UNID_VEND = 1 ");
            sql.append("          AND tsol.IND_ANUL = 0 ");
            sql.append("          AND tsol.IND_DEVO = 0 ");
            sql.append("          AND sc.IND_OC = 1 ");
            sql.append("       ) OR ( ");
            sql.append("          pt.NUM_UNID_FALT = 1  ");
            sql.append("          AND tsol.IND_ANUL = 0 ");
            sql.append("          AND tsol.IND_DEVO = 0 ");
            sql.append("          AND sc.IND_OC = 1 ");
            sql.append("       ) OR ( ");
            
            sql.append("              (pt.NUM_UNID_DEVU = 1 OR pt.NUM_UNID_ANUL = 1 OR pt.NUM_UNID_CANJ = 1 ");
            sql.append("               OR pt.NUM_UNID_TRUE = 1) AND ");
            sql.append("              FN_DAT_VALIDAR_PROD_SOLI_DEVO(sc.OID_SOLI_CABE, sp.OID_SOLI_POSI) > 0 ");
            sql.append("            ) ");
            sql.append(" )");
            
            sql.append(" GROUP BY sc.PAIS_OID_PAIS , ");
            sql.append(" sc.PERD_OID_PERI, ");
            //sql.append(" sc.ALMC_OID_ALMA, ");
            sql.append(" sc.SOCI_OID_SOCI, ");
            sql.append(" sp.PROD_OID_PROD, ");
            sql.append(" sc.FEC_FACT, ");
            sql.append(" od.CIVI_OID_CICLO_VIDA, ");
            sql.append(" od.TOFE_OID_TIPO_OFER, ");
            sql.append(" od.CNDP_OID_COND_PROM, ");
            //sql.append(" ts.IND_VENT_INTE_SAB_14, ");
            sql.append(" ter.COD_TERR, ");        
            sql.append(" ter.OID_TERR ");
            sql.append(" , sociedad.cod_soci");
            //sql.append(" , almacen.cod_alma");
            sql.append(" , codmedioSap.val_medi");
            //sql.append(" , canalBPS.val_cana_bps");
            sql.append(" , periodoCorpo.cod_peri");
            sql.append(" , maeProd.cod_sap");
            sql.append(" , cicloVida.cod_cicl_vida");
            sql.append(" , tipoOferta.cod_tipo_ofer");
            sql.append(" , condProm.cod_cond_prom");
            sql.append(" , marca.cod_marc");
            sql.append(" , pais.MONE_OID_MONE ");
            sql.append(" ,periodo.cana_oid_cana ");
            sql.append(" ,sp.val_codi_vent ");
            
             // sapaza -- PER-SiCC-2011-0148 -- 03/03/2011
            sql.append(" ,sc.soca_oid_docu_refe" + ")");

            
        }
        String codigoError = null;                                                                                                                                                            
        try{                                                                                                                             
           bs.dbService.executePreparedUpdate(sql.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
                UtilidadesLog.error(" DAOINTSAPBPS.3: Exception",e);                                                             
            this.logSql(" DAOINTSAPBPS.cargarTemporalVentaDia. SQL: ",insertsql.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }     
      
     UtilidadesLog.info("DAOINTSAPBPS.cargarTemporalVentaDia(DTOEnviarPedidosSAP dtoe, String codigo): Salida");     
    }
    
    /**
     * 24-11-2010       Agregado por DOliva, cambio PER-SiCC-2010-0658 Modificar Interfase de ventas para Ecuador.
     *                  Ejecuta el proceso de reemplazo de equivalencias
     *                  
     * 03-03-2011       Agregado por Sapaza, cambio PER-SiCC-2011-0148
     *                  
     * @throws es.indra.mare.common.exception.MareException
     */    
    public void ejecutarProcesoEquivalencia(Long oidPais) throws MareException { 
        UtilidadesLog.info("DAOINTSAPBPS.ejecutarProcesoEquivalencia(Long oidPais): Entrada");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        java.sql.Connection connection = null;
        java.sql.CallableStatement pstmt = null;
        try {
            bs.dbService.executeProcedure("SAP_EJEC_EQUI", oidPais.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" ejecutarProcesoEquivalencia  : Exception", e);            
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } finally{
           if (connection != null){
                try {connection.close();}catch (Exception e) {;}
           }
        }
        // Traza de salida 
        UtilidadesLog.info("DAOINTSAPBPS.ejecutarProcesoEquivalencia(Long oidPais): Salida"); 
        
    }
 
    public RecordSet obtenerEquivalenciaVentaDia() throws MareException {
                 UtilidadesLog.info("DAOINTSAPBPS.obtenerEquivalenciaMaestroTerritorios(): Entrada");                                                                        

        StringBuffer consulta = new StringBuffer();                                                                                      
        
        consulta.append("select pais_oid_pais PAIS, ");
        consulta.append("       perd_oid_peri OIDPERIODO, ");
        consulta.append("       MIN(almc_oid_alma) OIDALMACEN, ");
        consulta.append("       soci_oid_soci OIDSOCIEDAD, ");
        consulta.append("       prod_oid_prod OIDPRODUCTO, ");
        consulta.append("       fec_fact FECHAFACTURACION , ");
        consulta.append("       sum(val_unid_aten_vend) unid_aten_vendidas, ");
        consulta.append("       sum(val_unid_aten_falt) unid_aten_faltantes, ");
        consulta.append("       sum(val_unid_aten_devu) unid_aten_devueltas, ");
        consulta.append("       sum(val_unid_aten_anul) unid_aten_anuladas, ");
        consulta.append("       sum(val_unid_aten_canj) unid_aten_canje, ");
        consulta.append("       sum(val_unid_aten_true) unid_aten_trueque, ");
        consulta.append("       sum(val_vent_neta_vend) venta_neta_vendidas, ");
        consulta.append("       sum(val_vent_neta_falt) venta_neta_faltantes, ");
        consulta.append("       sum(val_vent_neta_devu) venta_neta_devueltas, ");
        consulta.append("       sum(val_vent_neta_anul) venta_neta_anuladas, ");
        consulta.append("       sum(val_vent_neta_canj) venta_neta_canje, ");
        consulta.append("       sum(val_vent_neta_true) venta_neta_trueque, ");
        consulta.append("       sum(val_prec_cata_vend) prec_cata_vendidas, ");
        consulta.append("       sum(val_prec_cata_falt) prec_cata_faltantes, ");
        consulta.append("       civi_oid_ciclo_vida OIDCICLOVIDA, ");
        consulta.append("       tofe_oid_tipo_ofer OIDTIPOOFERTA, ");
        consulta.append("       cndp_oid_cond_prom oidcondicionpromocion, ");
        consulta.append("       ind_vent_inte_sab_14 FLAGVENTA, ");
        consulta.append("       cod_terr territorio, ");
        consulta.append("       oid_terr OIDTERRITORIO, ");
        consulta.append("       cod_soci  CODIGOSOCIEDAD, ");
        consulta.append("       MIN(cod_alma) CODIGOALMACEM, ");
        consulta.append("       val_medi MEDIO, ");
        consulta.append("       val_cana_bps canalBPS, ");
        consulta.append("       cod_peri codPeriodo, ");
        consulta.append("       cod_sap codSap, ");
        consulta.append("       cod_cicl_vida codCicloVida, ");
        consulta.append("       cod_tipo_ofer codTipoOfer, ");
        consulta.append("       cod_cond_prom codCondProm, ");
        consulta.append("       cod_marc codMarca, ");
        consulta.append("       sum(num_unid_por_aten) NUM_UNID_POR_ATEN, ");
        consulta.append("       mone_oid_mone oidMoneda, ");
        consulta.append("       cana_oid_cana ");
        consulta.append("  from tmp_venta_diari ");
        consulta.append("group by pais_oid_pais, ");
        consulta.append("         perd_oid_peri, ");
        //consulta.append("         almc_oid_alma, ");
        consulta.append("         soci_oid_soci, ");
        consulta.append("         prod_oid_prod, ");
        consulta.append("         fec_fact, ");
        consulta.append("         civi_oid_ciclo_vida, ");
        consulta.append("       tofe_oid_tipo_ofer, ");
        consulta.append("       cndp_oid_cond_prom, ");
        consulta.append("       ind_vent_inte_sab_14, ");
        consulta.append("       cod_terr, ");
        consulta.append("       oid_terr, ");
        consulta.append("       cod_soci, ");
        //consulta.append("       cod_alma, ");
        consulta.append("       val_medi, ");
        consulta.append("       val_cana_bps, ");
        consulta.append("       cod_peri, ");
        consulta.append("       cod_sap, ");
        consulta.append("       cod_cicl_vida, ");
        consulta.append("       cod_tipo_ofer, ");
        consulta.append("       cod_cond_prom, ");
        consulta.append("       cod_marc, ");
        consulta.append("       mone_oid_mone, ");
        consulta.append("       cana_oid_cana ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
        RecordSet rs = null; 
        String codigoError = null; 
        try{ 
            rs =bs.dbService.executeStaticQuery(consulta.toString()); 
        }catch (Exception e) { 
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
            UtilidadesLog.error("obtenerEquivalenciaMaestroTerritorios: Exception",e); 
            throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));   
        }
       
         UtilidadesLog.warn(" ggg DAOINTSAPBPS.obtenerEquivalenciaMaestroTerritorios - Salida    ---> rs.getRowCount() " +rs.getRowCount() ); 
         UtilidadesLog.info("DAOINTSAPBPS.obtenerEquivalenciaMaestroTerritorios(): Salida");
        return rs;           
    }
 
    /**
     * 19-01-2011       Agregado por DOliva, cambio RCR PER-SiCC-2011-0044 ajuste de equivalencias con uso de indicador.
     *                  Devuelve el indicador de ejecucion de equivalencias
     * @throws es.indra.mare.common.exception.MareException
     */
    public String obtenerIndicadorEquivalencias(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOINTSAPBPS.obtenerIndicadorEquivalencias(Long oidPais): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append(" select nvl(bp.ind_equi,'0')      ");
        consulta.append("   from bas_pais bp, seg_pais sp  ");
        consulta.append("  where sp.cod_pais = bp.cod_pais ");
        consulta.append("    and sp.oid_pais =  ?          ");
        
        parametros.add(oidPais);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {                 
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOINTSAPBPS.obtenerIndicadorEquivalencias(Long oidPais): Salida");

        return "0";
    }
    
    /**
     * 30-06-2011       Agregado por SBuchelli, cambio PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS.
     *                  Devuelve el codigo Periodo Facturacion
     * @throws es.indra.mare.common.exception.MareException
     */
    public String obtenerCodigoPeriodo(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerCodigoPeriodo(Long oidPeriodo): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append("  SELECT A.COD_PERI      ");
        consulta.append("  FROM SEG_PERIO_CORPO A,CRA_PERIO B,SEG_CANAL C, SEG_MARCA D  ");
        consulta.append("  WHERE A.OID_PERI = B.PERI_OID_PERI ");
        consulta.append("   AND B.OID_PERI = ?          ");
        consulta.append("   AND B.CANA_OID_CANA = C.OID_CANA ");
        consulta.append("   AND B.MARC_OID_MARC = D.OID_MARC ");
        consulta.append("   AND C.COD_CANA = 'VD' ");
        consulta.append("   AND D.COD_MARC = 'T' ");
        
        
        parametros.add(oidPeriodo);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerCodigoPeriodo: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {                 
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOINTDAT.obtenerCodigoPeriodo(Long oidPeriodo): Salida");

        return "";
    }
    
    
    /**
     * 30-06-2011       Agregado por SBuchelli, cambio PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS.
     *                  Devuelve el codigo Periodo Facturacion
     * @throws es.indra.mare.common.exception.MareException
     */
    public Long obtenerNPeriodo(String codPeriodo,Long oidPais,Integer ncampanha) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerNPeriodo(String codPeriodo,Long oidPais,int ncampanha): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append("  SELECT GEN_PKG_GENER.GEN_FN_DEVUELVE_ID_CRA_PERIO2(   ");
        consulta.append("    PER_PKG_REPOR_PERCE.PER_FN_OBTIE_PERIO(?,  ");
        consulta.append("  ?, ");
        consulta.append("   GEN_PKG_GENER.GEN_FN_DEVUELVE_ID_MARCA('T'),");
        consulta.append("   GEN_PKG_GENER.GEN_FN_DEVUELVE_ID_CANAL('VD'), ");
        consulta.append("  ? )) ");
        consulta.append("   FROM DUAL ");        
        
        parametros.add(codPeriodo);
        parametros.add(oidPais);
        parametros.add(ncampanha);


        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerNPeriodo: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {                 
            return ((BigDecimal)rs.getValueAt(0,0)).longValue();        
        }

        UtilidadesLog.info("DAOINTDAT.obtenerNPeriodo(String codPeriodo,Long oidPais,int ncampanha): Salida");

        return null;
    }
    
    
    /**
     * 30-06-2011       Agregado por SBuchelli, cambio PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS.
     *                  Devuelve el codigo Periodo Facturacion
     * @throws es.indra.mare.common.exception.MareException
     */
    public Long obtenerIndicadorCruce(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerIndicadorCruce(Long oidPeriodo): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append("  SELECT IND_PERI_CRUC   ");
        consulta.append("   FROM CRA_PERIO  ");
        consulta.append("  WHERE OID_PERI =? ");
        
        parametros.add(oidPeriodo);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorCruce: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {                 
            return ((BigDecimal)rs.getValueAt(0,0)).longValue();        
        }

        UtilidadesLog.info("DAOINTDAT.obtenerIndicadorCruce(Long oidPeriodo): Salida");

        return new Long(0);
    }

    /**
     * 05-03-2012       Agregado por SBuchelli, cambio PER-SiCC-2011-0458 Ajuste interfaces SICC DAT y BPS.
     *                  Devuelve el parametro por pais
     * @throws es.indra.mare.common.exception.MareException
     */
    private String obtenerParametroGenerico(Long oidPais, String sistema, String codigo) throws MareException {
        UtilidadesLog.info("DAOINTSAPBPS.obtenerParametroGenerico(Long oidPais, String sistema, String codigo): Entrada");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append("  SELECT VAL_PARA   ");
        consulta.append("   from bas_param_pais b,SEG_PAIS s  ");
        consulta.append("  WHERE s.oid_pais =? ");
        consulta.append("  and s.COD_PAIS = b.cod_pais ");
        consulta.append("  and b.COD_SIST =? ");
        consulta.append("  and b.COD_PARA =? ");
        
        parametros.add(oidPais);
        parametros.add(sistema);
        parametros.add(codigo);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerParametroGenerico: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if (rs != null) {                 
            return ((String)rs.getValueAt(0,0));        
        }

        UtilidadesLog.info("DAOINTSAPBPS.obtenerParametroGenerico(Long oidPais, String sistema, String codigo): Salida");

        return "0";//se devuelve por default
    }   
}
