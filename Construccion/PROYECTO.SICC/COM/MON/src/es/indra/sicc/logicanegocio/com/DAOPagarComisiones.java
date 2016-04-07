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
package es.indra.sicc.logicanegocio.com;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.com.DTOBuscarComisionesPagar;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.dtos.com.DTOClientPagadoCom;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;
import es.indra.sicc.dtos.com.DTODatosPagarComision;

public class DAOPagarComisiones {
    private String usuario;

	public DAOPagarComisiones()
	{
	}
    
    
    public DAOPagarComisiones(String usuario) {
        this.usuario=usuario;
    }
	
	public RecordSet obtenerComisionesPagar(DTOBuscarComisionesPagar DTOE) throws MareException {
        UtilidadesLog.info("DAOPagarComisiones.obtenerComisionesPagar(DTOBuscarComisionesPagar DTOE): Entrada");
		
        StringBuffer consulta = new StringBuffer();
        StringBuffer queryPaginado = new StringBuffer();
        String queryPagina = null;
        
        Vector parametros = new Vector();
        Vector parametros1= new Vector();
    
        consulta.append(" C.COD_COMI, ");
        consulta.append(" C.NUM_VERS, ");
        
        
        consulta.append("    (SELECT idio.VAL_I18N  ");
        consulta.append("     FROM V_GEN_I18N_SICC idio  "); 
        consulta.append("     WHERE idio.ATTR_ENTI = 'COM_COMIS'  ");
        consulta.append("     AND idio.IDIO_OID_IDIO = ?  ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append("     AND idio.VAL_OID = C.OID_COMI) DESC_COMIS,  ");
                
        consulta.append(" MAR.DES_MARC, ");
          
        consulta.append(" CAN.OID_CANA, ");
        consulta.append("    (SELECT idio.VAL_I18N  ");
        consulta.append("     FROM V_GEN_I18N_SICC idio  "); 
        consulta.append("     WHERE idio.ATTR_ENTI = 'SEG_CANAL'  ");
        consulta.append("     AND idio.IDIO_OID_IDIO = ?   ");
        consulta.append("     AND idio.VAL_OID = CAN.OID_CANA) DESC_CANAL, ");
        parametros.add(DTOE.getOidIdioma());   
               
        consulta.append(" ACC.OID_ACCE, ");
        consulta.append("    (SELECT idio.VAL_I18N  ");
        consulta.append("     FROM V_GEN_I18N_SICC idio    ");
        consulta.append("     WHERE idio.ATTR_ENTI = 'SEG_ACCES' "); 
        consulta.append("     AND idio.IDIO_OID_IDIO = ?   ");
        consulta.append("     AND idio.VAL_OID = ACC.OID_ACCE) DESC_ACCES,  ");
        parametros.add(DTOE.getOidIdioma());
        
        
        consulta.append("     (SELECT idio.VAL_I18N   ");
        consulta.append("     FROM V_GEN_I18N_SICC idio   ");
        consulta.append("     WHERE idio.ATTR_ENTI = 'COM_TIPO_PLANT'  ");
        consulta.append("     AND idio.IDIO_OID_IDIO = ?   ");
        parametros.add(DTOE.getOidIdioma());
        consulta.append("     AND idio.VAL_OID = PLA.OID_TIPO_PLAN) DESC_TIPO_PLANTILLA, ");
        
        
        consulta.append(" C.VAL_CONC, ");
        consulta.append(" COM.FEC_CALC,  ");
        consulta.append(" C.PLCO_OID_PLAN_COMI, ");        
        consulta.append(" C.OID_COMI OID_COMI ");
        
        consulta.append(" FROM  ");
         
        consulta.append(" COM_COMIS C, ");
        consulta.append(" COM_COMIS_CALCU COM, ");
        consulta.append(" COM_COMIS_ACCES CA, ");
        consulta.append(" COM_TIPO_PLANT PLA, ");
        consulta.append(" COM_PLANT_COMIS PC, ");
        consulta.append(" COM_PLANT_COMIS_ACCES PCA, ");//BELC300014726 
        consulta.append(" COM_PLANT_COMIS_MARCA PCM, ");
        consulta.append(" COM_PLANT_COMIS_PAIS PCP,  ");        

        consulta.append(" VCA_SEG_ACCES ACC,  ");
        consulta.append(" VCA_SEG_MARCA MAR,  ");
        consulta.append(" VCA_SEG_CANAL CAN ");
        
        consulta.append(" WHERE C.OID_COMI = COM.COMI_OID_COMI ");
        consulta.append(" AND com.ESCO_OID_ESTA_COMI_CLIE = " + ConstantesCOM.ESTADO_COMISION_CLIENTE_CALCULADA);
        consulta.append(" AND C.PLCO_OID_PLAN_COMI = PC.OID_PLAN_COMI ");
        consulta.append(" AND C.PLCM_OID_PLAN_COMI_MARC =PCM.OID_PLAN_COMI_MARC ");
        consulta.append(" AND COM.TPLA_OID_TIPO_PLAN = PLA.OID_TIPO_PLAN  ");
        consulta.append(" AND PCM.MARC_OID_MARC = MAR.OID_MARC  ");
        consulta.append(" AND PC.CANA_OID_CANA = CAN.OID_CANA ");
        consulta.append(" AND C.OID_COMI = CA.COMI_OID_COMI ");
        consulta.append(" AND CA.PLCA_OID_PLAN_COMI_ACCE =PCA.OID_PLAN_COMI_ACCE ");
        consulta.append(" AND PCA.ACCE_OID_ACCE = ACC.OID_ACCE ");
        consulta.append("AND C.PLCP_OID_PLAN_COMI_PAIS = PCP.OID_PLAN_COMI_PAIS  ");////BELC300014726 
        
        consulta.append(" AND ACC.COD_USUA= ? ");
        parametros.add(this.usuario);
        consulta.append(" AND MAR.COD_USUA= ? ");
        parametros.add(this.usuario);
        consulta.append(" AND CAN.COD_USUA= ? ");
        parametros.add(this.usuario);
        if(DTOE.getCodComision()!=null){
             consulta.append(" AND C.COD_COMI= ? ");
             parametros.add(DTOE.getCodComision());
        }
         if(DTOE.getDescripcion()!=null){
                consulta.append(" AND  (SELECT idio.VAL_I18N  ");
                consulta.append("     FROM V_GEN_I18N_SICC idio  "); 
                consulta.append("     WHERE idio.ATTR_ENTI = 'COM_COMIS'  ");
                consulta.append("     AND idio.IDIO_OID_IDIO = ?  ");
                parametros.add(DTOE.getOidIdioma());
                consulta.append("     AND idio.VAL_OID = C.OID_COMI) LIKE  ?  ");
                parametros.add(DTOE.getDescripcion());
        }
         
        if(DTOE.getOidPais()!=null){
            consulta.append("AND PCP.PAIS_OID_PAIS= ? "); //BELC300014726 
            parametros.add(DTOE.getOidPais());
        }
         
        if (DTOE.getFechaCalculo()!=null){
            consulta.append(" AND COM.FEC_CALC =  TO_DATE( '" + DTOE.getFechaCalculo() + "' ,'" + DTOE.getFormatoFecha() + "') ");             
        } else {
            consulta.append(" AND (com.COMI_OID_COMI, com.FEC_CALC) IN ( ");
            consulta.append("           SELECT  calc.COMI_OID_COMI , MIN(calc.FEC_CALC) ");
            consulta.append("           FROM com_comis_calcu calc ");
            consulta.append("           WHERE calc.ESCO_OID_ESTA_COMI_CLIE = " + ConstantesCOM.ESTADO_COMISION_CLIENTE_CALCULADA);
            consulta.append("           GROUP BY calc.COMI_OID_COMI) ");
        }
        
         // Ordena unicamente cuando no se filtra por fecha
         if (DTOE.getFechaCalculo()==null){
         
            consulta.append(" ORDER BY COM.FEC_CALC  ");
            
            queryPaginado.append(" SELECT * FROM ( ");
            queryPaginado.append("     SELECT ROWNUM AS linea, queryPrincipal.* ");
            queryPaginado.append("     FROM ( SELECT DISTINCT ");
            queryPaginado.append(consulta.toString());
            queryPaginado.append("     )  queryPrincipal ");
            
            //ak sacamos la cuenta del registro a partir del cual debemos mostrar
            //ojala que funcione (Gacevedo)
            
            //<Inicio> Incidencia DBLG700000292, problemas al paginar los datos.
            UtilidadesLog.debug("DAOPagarComisiones.obtenerComisionesPagar, indicador :" + DTOE.getIndicadorSituacion().toString());
            UtilidadesLog.debug("DAOPagarComisiones.obtenerComisionesPagar, tamanio :" + DTOE.getTamanioPagina().toString());
            
            int desde = DTOE.getIndicadorSituacion().intValue();
            /*int indicador=DTOE.getIndicadorSituacion().intValue(); 
            int tamanio = DTOE.getTamanioPagina().intValue();
            
            if(tamanio > indicador){
                //si el indicador de situacion es menor que el tamanio pagina
                //significa que no se completa la pagina, los muestro todos
                if((indicador%tamanio)==0){
                    //si el indicador de situacion, modulo el tamaño pagina es igual a cero,
                    //tons la cuenta es directa
                    desde = indicador-tamanio;
                }else{
                    //si no, busco el primer indicador de situacion
                    //que sea modulo del tamaño pagina.
                    int dif = indicador%tamanio;
                    desde = indicador-dif;
                }
            }
            if(desde < 0){
                desde = 0;
            }*/
            //<Fin> Incidencia DBLG700000292
             
            queryPaginado.append(" ) WHERE ROWNUM <= " + DTOE.getTamanioPagina() + " AND linea > " + desde);
            queryPagina = queryPaginado.toString();
         } else {
            queryPaginado.append(" SELECT DISTINCT C.OID_COMI OID, ");
            queryPaginado.append(consulta.toString());
              
            queryPagina = UtilidadesPaginacion.armarQueryPaginacion(queryPaginado.toString(), DTOE);
         }
         
		
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        
        try{
           
           rs =bs.dbService.executePreparedQuery(queryPagina,parametros);
           
           
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(e);
            this.logSql(" obtenerComisionesPagar. SQL: ",queryPagina,parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		 RecordSet rsAcceso=null;
         Long pComision=null;
         Long acceso=null;
         String strAcceso=null;
         StringBuffer consulta1=new StringBuffer();
         //rs.addColumn("CONCATENA");
         if(rs!=null){
             if(!rs.esVacio()){
                for( int i = 0; i< rs.getRowCount(); i++){
                    if(rs.getValueAt(i,"PLCO_OID_PLAN_COMI")!=null){
                             pComision=new Long(((BigDecimal)rs.getValueAt(i,"PLCO_OID_PLAN_COMI")).longValue());
                    }
                    if(rs.getValueAt(i,"OID_ACCE")!=null){
                             acceso=new Long(((BigDecimal)rs.getValueAt(i,"OID_ACCE")).longValue());
                    }
                            
                            consulta1=new StringBuffer();
                            parametros1=new Vector();
                            consulta1.append(" SELECT DISTINCT GEN.VAL_I18N  ");	    
                            consulta1.append(" FROM V_GEN_I18N_SICC GEN   ");           
                            consulta1.append(" WHERE GEN.VAL_OID IN (   ");             
                            consulta1.append(" SELECT DISTINCT ACCE_OID_ACCE   ");      
                            consulta1.append(" FROM COM_PLANT_COMIS_ACCES  ");         
                            consulta1.append(" WHERE PLCO_OID_PLAN_COMI = ?  ");
                            parametros1.add(pComision);
                            //consulta1.append(" AND ACCE_OID_ACCE = ?  ");
                            //parametros1.add(acceso);
                            consulta1.append(" )   ");                                  
                            consulta1.append(" AND GEN.ATTR_ENTI = 'SEG_ACCES'   ");    
                            consulta1.append(" AND GEN.ATTR_NUM_ATRI = 1  ");         
                            consulta1.append(" AND GEN.IDIO_OID_IDIO =  ? ");
                            parametros1.add(DTOE.getOidIdioma());
                            consulta1.append(" ORDER BY  GEN.VAL_I18N  "); 
                            
                            
                             try{
                               rsAcceso =bs.dbService.executePreparedQuery(consulta1.toString(),parametros1);
                            }catch (Exception e) {                            
                                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                                UtilidadesLog.error(e);
                                this.logSql(" obtenerComisionesPagar. SQL: ",consulta.toString(),parametros);
                                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                            }//catch

                            
                          for( int a=0; a<rsAcceso.getRowCount(); a++){
                                UtilidadesLog.debug(rsAcceso.getValueAt(a,0));
                          if(a==0){
                              strAcceso = String.valueOf(rsAcceso.getValueAt(a,0));
                          }else{
                              strAcceso = strAcceso+" "+ String.valueOf(rsAcceso.getValueAt(a,0));
                          }                 
                        }
                //AÑADIMOS AL RECORSET QUE VASMO A DEVOLVER  UNA COLUMNA NUEVA CON EL STRING DE LAS CONCATENACINES.
                rs.setValueAt(strAcceso,i,9);
                 }//for de rs
             }//rs.vacio
         }
         
        UtilidadesLog.info("DAOPagarComisiones.obtenerComisionesPagar(DTOBuscarComisionesPagar DTOE): Entrada");
		return rs;
	}
	
	public RecordSet obtenerDetalleComisionPagar (DTODatosPagarComision DTOE) throws MareException {
		UtilidadesLog.info("DAOPagarComisiones.obtenerDetalleComisionPagar(DTOOIDPaginado DTOE): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		
		consulta.append("SELECT  ");                                                                  

        consulta.append(" COM.OID_COMI_CALC OID,   ");                                                      
        consulta.append("   (SELECT idio.VAL_I18N  ");                                                 
        consulta.append("   FROM V_GEN_I18N_SICC idio   ");                                            
        consulta.append("   WHERE idio.ATTR_ENTI = 'MAE_TIPO_CLIEN'  ");                               
        consulta.append("   AND idio.IDIO_OID_IDIO = ? ");                                          
        parametros.add(DTOE.getOidIdioma());
        consulta.append("   AND idio.VAL_OID = TC.OID_TIPO_CLIE) DESC_TIPO,  ");                       

        consulta.append("CLI.COD_CLIE,  ");                                                            
        //consulta.append("PER.OID_PERI,  ");   // -- ATENCION AQUI PIDE EL CODIGO DE PERIODO BELC300014722  

        consulta.append(" CLI.VAL_APE1,  ");                                                            
        consulta.append(" CLI.VAL_APE2,  ");                                                           
        consulta.append(" CLI.VAL_NOM1,  ");                                                            
        consulta.append(" CLI.VAL_NOM2,  ");                                                            
        consulta.append(" SPC.COD_PERI,  ");                                  
        consulta.append(" VAL_DESC_ESTA_COMI_CLIE DESC_ESTADO, ");                                            
        consulta.append(" COM.IMP_COMI,  ");                                                          
        consulta.append(" COM.VAL_PORC_COMI, ");                             
        consulta.append("   (SELECT idio.VAL_I18N  ");                                                 
        consulta.append("   FROM V_GEN_I18N_SICC idio   ");                                            
        consulta.append("   WHERE idio.ATTR_ENTI = 'COM_FORMA_PAGO' ");                                
        consulta.append("   AND idio.IDIO_OID_IDIO = ?   ");                                           
        consulta.append("   AND idio.VAL_OID = COM.FORP_OID_FORMA_PAGO) DESC_FORMA_PAGO,  ");                
        parametros.add(DTOE.getOidIdioma());                                             

        consulta.append("   (SELECT idio.VAL_I18N      ");                                             
        consulta.append("   FROM V_GEN_I18N_SICC idio    ");                                           
        consulta.append("   WHERE idio.ATTR_ENTI = 'COM_TIPO_PLANT'  ");                               
        consulta.append("   AND idio.IDIO_OID_IDIO = ?  ");                                           
        consulta.append("   AND idio.VAL_OID = PLA.OID_TIPO_PLAN) DESC_TIPO_PLANTILLA,  ");            
        parametros.add(DTOE.getOidIdioma());                                                                         
                        
        consulta.append(" COM.FEC_CALC  ");                                                          
                                                                                 
        consulta.append(" FROM   ");                                                                    
                                                                                 
        consulta.append(" COM_COMIS_CALCU COM,  ");                                                    
        consulta.append(" MAE_CLIEN CLI,   ");                                                          
        consulta.append(" MAE_CLIEN_TIPO_SUBTI CTS,  ");                                                
        consulta.append(" MAE_TIPO_CLIEN TC,  ");                                                       
        consulta.append(" CRA_PERIO PER,   ");                                                          
        consulta.append(" COM_ESTAD_COMIS_CLIEN ECC,  ");                                               
        consulta.append(" COM_FORMA_PAGO FP,  ");                                                       
        consulta.append(" COM_TIPO_PLANT PLA,  ");                                                      
        consulta.append(" SEG_PERIO_CORPO SPC   ");                                                     
                                                                                 
        consulta.append(" WHERE   ");                                                                   
        consulta.append(" COM.FORP_OID_FORMA_PAGO = FP.OID_FORM_PAGO   ");                              
        consulta.append(" AND COM.ESCO_OID_ESTA_COMI_CLIE =ECC.OID_ESTA_COMI_CLIE  ");                  
        consulta.append(" AND COM.TPLA_OID_TIPO_PLAN = PLA.OID_TIPO_PLAN   ");                          
        consulta.append(" AND COM.CLIE_OID_CLIE = CLI.OID_CLIE  ");                                     
        consulta.append(" AND CLI.OID_CLIE =CTS.CLIE_OID_CLIE  ");                                     
        consulta.append(" AND CTS.TICL_OID_TIPO_CLIE =TC.OID_TIPO_CLIE  ");                             
        consulta.append(" AND COM.PERD_OID_PERI =PER.OID_PERI  ");                                       
        consulta.append(" AND SPC.OID_PERI = PER.PERI_OID_PERI  ");                                     
                                                                                  
      
        consulta.append("AND COM.COMI_OID_COMI = ? ");
        parametros.add(DTOE.getOidComision());                                                
        //consulta.append("AND CTS.IND_PPAL = 1  ");   // Eliminado por V-COM-01 eiraola 05/Ene/2007
        
        // Inicio  -  Agrega V-COM-01 eiraola 05/Ene/2007
        // Este agregado hace que si el cliente tenía un tipo/subtipo de cliente
        // marcado como principal sea este el que se muestra en el Detalle de
        // las comisiones calculadas... pero si no tenia un tipo/subtipo de cliente
        // principal entonces toma simplemente el primer registro
        consulta.append(" AND case when ( ");
        consulta.append(" 	             (SELECT count(*) AS cantTipifPpales ");
        consulta.append("                   FROM MAE_CLIEN_TIPO_SUBTI tst ");
        consulta.append("                  WHERE tst.CLIE_OID_CLIE = cli.oid_clie ");
        consulta.append("                    AND tst.IND_PPAL = 1) = 1 ");
        consulta.append("                ) ");
        consulta.append("     then 1 ");
        consulta.append("     else (case when ( ");
        consulta.append("                      (SELECT tst.OID_CLIE_TIPO_SUBT ");
        consulta.append("                         FROM MAE_CLIEN_TIPO_SUBTI tst ");
        consulta.append("                        WHERE tst.CLIE_OID_CLIE = cli.oid_clie ");
        consulta.append("                          AND rownum = 1) = cts.OID_CLIE_TIPO_SUBT	");
        consulta.append("                     ) ");
        consulta.append("           then 0 ");
        consulta.append("           else 1 "); // Esto es para que no lo considere como tipo/subtipo de cliente por no ser el primero
        consulta.append("           end ");
        consulta.append("          ) ");        
        consulta.append("     end ");
        consulta.append("     = cts.ind_ppal ");
        // Fin     -  Agrega V-COM-01 eiraola 05/Ene/2007
        
        
        if (DTOE.getFechaCalculo()!=null){
            consulta.append(" AND COM.FEC_CALC =  TO_DATE( '" + DTOE.getFechaCalculo() + "' ,'" + DTOE.getFormatoFecha() + "') ");             
        } 
                                                      
		
		 String sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),DTOE);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(sqlPaginacion,parametros);
           UtilidadesLog.debug("respuesta: " + rs);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(e);
            this.logSql(" obtenerDetalleComisionPagar. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch

      UtilidadesLog.info("DAOPagarComisiones.obtenerDetalleComisionPagar(DTOOIDPaginado DTOE): Entrada");
      return rs;
    }
	
	public ArrayList obtenerComisionesPagadasEmpleados(Long oidEmpleado) throws MareException {
		UtilidadesLog.info("DAOPagarComisiones.obtenerComisionesPagadasEmpleados(Long oidEmpleado): Entrada");
		
		StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = new ArrayList();
            consulta.append(" SELECT ");                                     
            consulta.append(" COM.CLIE_OID_CLIE,");                          
            consulta.append(" CDA.COD_EMPL,   ");                            
            consulta.append(" COM.IMP_COMI  ");                              
            consulta.append(" FROM ");                                       
            consulta.append(" COM_COMIS_CALCU COM,");                        
            consulta.append(" MAE_CLIEN CLI, ");                             
            consulta.append(" MAE_CLIEN_DATOS_ADICI CDA  ");                 
            consulta.append(" WHERE COM.CLIE_OID_CLIE = CLI.OID_CLIE");      
            consulta.append(" AND CLI.OID_CLIE = CDA.CLIE_OID_CLIE ");  
            consulta.append(" AND COM.COMI_OID_COMI = ? "); 
            parametros.add(oidEmpleado);
            consulta.append(" AND COM.FORP_OID_FORMA_PAGO = ? "); 
            parametros.add(ConstantesCOM.FORMA_PAGO_CON_PLANILLA);

		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(e);
            this.logSql(" obtenerComisionesPagadasEmpleados. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}//catch
		DTOClientPagadoCom   dto = null;
		
		if(rs!=null){
			if(!rs.esVacio()){
				int n=rs.getRowCount();
			
				for(int i= 0;i<n;i++){
					dto = new DTOClientPagadoCom();
					if(rs.getValueAt(i,"COD_EMPL")!=null){
                        dto.setCodPlanilla((String)rs.getValueAt(i,"COD_EMPL"));
                    }
                    if(rs.getValueAt(i,"IMP_COMI")!=null){
                        dto.setImpCalculado((BigDecimal)rs.getValueAt(i,"IMP_COMI"));
                    }
                    if(rs.getValueAt(i,"CLIE_OID_CLIE")!=null){
                        dto.setOidCliente(new Long(((BigDecimal)rs.getValueAt(i,"CLIE_OID_CLIE")).toString()));
					}
					array.add(dto);
				}
			}
		}
		
		UtilidadesLog.info("DAOPagarComisiones.obtenerComisionesPagadasEmpleados(Long oidEmpleado): Entrada");
		return array;
	}
	
	 private void logSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("DAOPagarComisiones.logSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
        UtilidadesLog.info("DAOPagarComisiones.logSql(String metodo, String sql, Vector params): Salida");
	}
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       9/01/2006
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public RecordSet obtenerComisionesFechasCalculadas(Long oidComision, String fechaCalculada, String formatoFecha) throws MareException {
  
      UtilidadesLog.info("DAOPagarComisiones.obtenerComisionesFechasCalculadas(Long oidComision, String fechaCalculada, String formatoFecha):Entrada");
  
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
    
      query.append(" SELECT cal.OID_COMI_CALC ");
      query.append(" FROM COM_COMIS_CALCU cal  ");
      query.append(" WHERE cal.COMI_OID_COMI = " + oidComision);
      query.append(" AND cal.FEC_CALC = TO_DATE('" + fechaCalculada + "','" + formatoFecha + "') ");
      query.append(" AND cal.ESCO_OID_ESTA_COMI_CLIE = " +  ConstantesCOM.ESTADO_COMISION_CLIENTE_CALCULADA);    
      
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          UtilidadesLog.error(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }      
     
      UtilidadesLog.debug("resultado: " + rs);
      
      UtilidadesLog.info("DAOPagarComisiones.obtenerComisionesFechasCalculadas(Long oidComision, String fechaCalculada, String formatoFecha):Salida");
      return rs;      
  }
  
}