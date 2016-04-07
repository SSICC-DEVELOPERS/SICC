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

import es.indra.sicc.dtos.intsys.DTOINTAsignacionAlmacen;
import es.indra.sicc.dtos.intsys.DTOINTCargosAbonos;
import es.indra.sicc.dtos.intsys.DTOINTDatosCliente;
import es.indra.sicc.dtos.intsys.DTOINTEnviarConsultorasDeuda;
import es.indra.sicc.dtos.intsys.DTOINTMovimientosCC;
import es.indra.sicc.dtos.intsys.DTOINTParametrosContablesFAC;
import es.indra.sicc.dtos.intsys.DTOINTDocumentosContables;
import es.indra.sicc.dtos.intsys.DTOINTDocumentoContable;
import es.indra.sicc.dtos.intsys.DTOINTParametrosContablesCCC;

import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;


import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;

import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;

import java.sql.Timestamp;

public class DAOINT 
{
  public DAOINT()
  {
  }
  /*
   * Operation ArrayList obtenerPeriodos (Long pais, Long canal, java.util.Date fecha), in Class DAOINT

Documentation
Mediante DBService, hace una consulta a la tabla CRA_PERIO, buscando los registros que cumplan las siguientes condiciones: 

PAIS_OID_PAIS = pais 
CANA_OID_CANA = canal 
FEC_INIC <= fecha 
FEC_FINA >= fecha 

Con los registros obtenidos, se crea una lista de objetos DTOPeriodo y se retorna.
*/
public ArrayList obtenerPeriodos(Long pais, Long canal, java.util.Date fecha) throws MareException {

       UtilidadesLog.info("DAOINT.obtenerPeriodos(Long pais, Long canal, java.util.Date fecha): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array=new ArrayList();

       consulta.append(" SELECT * FROM CRA_PERIO WHERE ");   
       consulta.append(" PAIS_OID_PAIS = ? ");//pais   
       parametros.add(pais);
       consulta.append(" AND CANA_OID_CANA = ? ");//canal   
        parametros.add(canal);        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fechaD = new java.sql.Date(fecha.getTime());
        String sFechaDesde = sdf.format(fechaD);   
       consulta.append(" AND FEC_INIC <=  TO_DATE( ? ,'YYYY-MM-DD') ");             
        parametros.add(sFechaDesde);
       consulta.append(" AND FEC_FINA >=  TO_DATE( ? ,'YYYY-MM-DD') ");               
        parametros.add(sFechaDesde);
       

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
      
     if(rs!=null){
       if(!rs.esVacio()){

          for(int i=0;i<rs.getRowCount();i++){
          
            DTOPeriodo dto=new DTOPeriodo();
            if(rs.getValueAt(i,"OID_PERI")!=null){
              dto.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID_PERI")).longValue()));
            }
            if(rs.getValueAt(i,"CANA_OID_CANA")!=null){
              dto.setCanal(new Long(((BigDecimal)rs.getValueAt(i,"CANA_OID_CANA")).longValue()));
            }
            if(rs.getValueAt(i,"PAIS_OID_PAIS")!=null){
              dto.setPais(new Long(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).longValue()));
            }
            if(rs.getValueAt(i,"ACCE_OID_ACCE")!=null){
              dto.setAcceso(new Long(((BigDecimal)rs.getValueAt(i,"ACCE_OID_ACCE")).longValue()));
            }
            if(rs.getValueAt(i,"PERI_OID_PERI")!=null){
              dto.setOidPeriodoCorporativo(new Long(((BigDecimal)rs.getValueAt(i,"PERI_OID_PERI")).longValue()));
            }
            Boolean indPeriCorto;
            if(rs.getValueAt(i,"IND_PERI_CORTO")!=null){
            	indPeriCorto=new Boolean(((BigDecimal)rs.getValueAt(i,"IND_PERI_CORTO")).intValue() == 1 ? true : false);		
               dto.setPeriodoCorto(indPeriCorto);
            }
             Boolean indPeriCruce;
            if(rs.getValueAt(i,"IND_PERI_CRUC")!=null){
            	indPeriCruce=new Boolean(((BigDecimal)rs.getValueAt(i,"IND_PERI_CRUC")).intValue() == 1 ? true : false);		
              dto.setPeriodoCruce(indPeriCruce);
            }
            Boolean estatus;
            if(rs.getValueAt(i,"VAL_ESTA")!=null){
            	estatus=new Boolean(((BigDecimal)rs.getValueAt(i,"VAL_ESTA")).intValue() == 1 ? true : false);		
              dto.setStatus(estatus);
            }
            	//fecha
            if(rs.getValueAt(i,"FEC_INIC")!=null){
                        dto.setFechaInicio((java.sql.Date)rs.getValueAt(i,"FEC_INIC"));
            }
            if(rs.getValueAt(i,"FEC_FINA")!=null){
                        dto.setFechaFin((java.sql.Date)rs.getValueAt(i,"FEC_FINA"));
            }
            array.add(dto);
           }//for
       }//(!rs.esVacio()
     }//(rs!=null)
      //Con los registros obtenidos, se crea una lista de objetos DTOPeriodo y se retorna.
        UtilidadesLog.info("DAOINT.obtenerPeriodos(Long pais, Long canal, java.util.Date fecha): Salida");	
        return array;
     }    
     
     
     
     public ArrayList obtenerAsignacionAlmacen(Long pais, Long almacen) throws MareException {
       UtilidadesLog.info("DAOINT.obtenerAsignacionAlmacen(Long pais, Long almacen): Entrada");    
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array=new ArrayList();

            consulta.append(" SELECT  ");              
            consulta.append(" AA.OID_ASIG_ALMA oid,  ");              
            consulta.append(" AC.CANA_OID_CANA oidCanal, ");          
            consulta.append(" SA.ACCE_OID_ACCE oidAcceso, ");        
            consulta.append(" AA.SBAC_OID_SBAC oidSubacceso,  ");     
            consulta.append(" AA.MARC_OID_MARC oidMarca, ");          
            consulta.append(" AA.ALMC_OID_ALMA oidAlmacen, ");        
            consulta.append(" AA.PAIS_OID_PAIS oidPais  ");           
                                           
            consulta.append(" FROM   ");                              
            consulta.append(" PED_ASIGN_ALMAC AA, ");                 
            consulta.append(" SEG_CANAL CA,  ");                      
            consulta.append(" SEG_ACCES AC, ");                       
            consulta.append(" SEG_SUBAC SA  ");                       
                                            
            consulta.append(" WHERE  ");                              
            consulta.append(" AA.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
            consulta.append(" AND  AA.ALMC_OID_ALMA = ?");  
             parametros.add(almacen);
            consulta.append(" AND AA.SBAC_OID_SBAC = SA.OID_SBAC "); 
            consulta.append(" AND SA.ACCE_OID_ACCE = AC.OID_ACCE ");  
            consulta.append(" AND AC.CANA_OID_CANA = CA.OID_CANA ");
                   

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
      
     if(rs!=null){
       if(!rs.esVacio()){
       
          for(int i=0;i<rs.getRowCount();i++){
          
            DTOINTAsignacionAlmacen dto=new DTOINTAsignacionAlmacen();
            if(rs.getValueAt(i,"OID")!=null){
              dto.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID")).longValue()));
            }
            if(rs.getValueAt(i,"OIDCANAL")!=null){
              dto.setOidCanal(new Long(((BigDecimal)rs.getValueAt(i,"OIDCANAL")).longValue()));
            }
            if(rs.getValueAt(i,"OIDACCESO")!=null){
              dto.setOidAcceso(new Long(((BigDecimal)rs.getValueAt(i,"OIDACCESO")).longValue()));
            }
            if(rs.getValueAt(i,"oidSubacceso")!=null){
              dto.setOidSubacceso(new Long(((BigDecimal)rs.getValueAt(i,"oidSubacceso")).longValue()));
            }
                          
            if(rs.getValueAt(i,"oidMarca")!=null){
              dto.setOidMarca(new Long(((BigDecimal)rs.getValueAt(i,"oidMarca")).longValue()));
            }
            
            if(rs.getValueAt(i,"oidAlmacen")!=null){
              dto.setOidAlmacen(new Long(((BigDecimal)rs.getValueAt(i,"oidAlmacen")).longValue()));
            }
            if(rs.getValueAt(i,"oidPais")!=null){
              dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(i,"oidPais")).longValue()));
            }

            array.add(dto);
           }//for
       }//(!rs.esVacio()
     }//(rs!=null)
      //Con los registros obtenidos, se crea una lista de objetos DTOPeriodo y se retorna.
        UtilidadesLog.info("DAOINT.obtenerAsignacionAlmacen(Long pais, Long almacen): Salida");    		
        return array;
     }  
     


    /**
     * 03-10-2007       Modificada por Sapaza, cambio Sicc20070441. Se debe enviar a consultoras que 
     *                  no estén bloqueados financieramente 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param listaMarcas
     * @param dtoe
     */
    public ArrayList obtenerClientes(DTOINTEnviarConsultorasDeuda dtoe, DTOOIDs listaMarcas) throws MareException{
        UtilidadesLog.info("DAOINT.obtenerClientes(DTOINTEnviarConsultorasDeuda dtoe): Entrada");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
       
        ArrayList aux = new ArrayList(); 
        ArrayList array = new ArrayList(); 
        // Se cambia la SQL por incidencia BELC300012392 
        
        consulta.append("SELECT * FROM ( SELECT DISTINCT ");
        consulta.append(" TST.CLIE_OID_CLIE OIDCLIENTE, ");
        consulta.append(" CLI.COD_CLIE CODCLI, ");
        consulta.append(" DC.COD_TIPO_DOCU TIPODOCU, ");
        consulta.append(" ID.NUM_DOCU_IDEN NUMDOCU, ");
        consulta.append(" CLI.COD_DIGI_CTRL DIGCTRL, ");
        consulta.append(" CLI.VAL_APE1 APE1, ");
        consulta.append(" CLI.VAL_APE2 APE2, ");
        consulta.append(" CLI.VAL_NOM1 NOM1, ");
        consulta.append(" CLI.VAL_NOM2 NOM2, ");
        consulta.append(" ZON.COD_ZONA ZONA, ");
        consulta.append(" REG.COD_REGI REGI, ");
        consulta.append(" NVL((SELECT SUM( NVL(MCC.IMP_PEND,0) ) SUMA ");
        consulta.append(" FROM CCC_MOVIM_CUENT_CORRI MCC ");
        consulta.append(" WHERE ");
        consulta.append(" MCC.CLIE_OID_CLIE = CLI.OID_CLIE ");
        Long oidsMarcas[] = listaMarcas.getOids();
        if (oidsMarcas!=null){
            if(oidsMarcas.length != 0){ //si hay oids de marcas
                for (int k=0;k<oidsMarcas.length;k++){
                    aux.add(oidsMarcas[k]);
                }
                String marcas = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND MCC.MASI_OID_MARC_SITU IN ("+ marcas +")  ");
                for(int h=0;h<oidsMarcas.length;h++){
                    parametros.add(oidsMarcas[h]);
                }
            }
        }
        DTOOIDs dtooidsEmpresa = dtoe.getListaEmpresa();
        if (dtooidsEmpresa!=null){
            Long oidsEM[] = dtooidsEmpresa.getOids();
            if(oidsEM!=null){
                if(oidsEM.length != 0){ //si hay oids de tipos de clientes
                    for (int s=0;s<oidsEM.length;s++){
                        aux.add(oidsEM[s]);
                    }
                    String empresas = this.convertirArrayToString(aux);
                    aux.clear();
                    consulta.append(" AND MCC.SOCI_OID_SOCI IN ("+ empresas +")  ");
                    for(int r=0;r<oidsEM.length;r++){
                        parametros.add(oidsEM[r]);
                    }
                }
            }
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(dtoe.getFechaDesde() != null){
            java.sql.Date fechaD = new java.sql.Date(dtoe.getFechaDesde().getTime());
            String sFechaDesde = sdf.format(fechaD);
            consulta.append(" AND MCC.FEC_DOCU >=  TO_DATE( ? ,'YYYY-MM-DD') ");             
            parametros.add(sFechaDesde);
        }
        if(dtoe.getFechaHasta() != null){
            java.sql.Date fechaH = new java.sql.Date(dtoe.getFechaHasta().getTime());
            String sFechaHasta = sdf.format(fechaH);
            consulta.append(" AND MCC.FEC_DOCU <=  TO_DATE( ? ,'YYYY-MM-DD') ");               
            parametros.add(sFechaHasta);
        }
       
        DTOOIDs dtooidsTC = dtoe.getListaTiposCliente();
        if (dtooidsTC!=null){
            Long oidsTC[] = dtooidsTC.getOids();
            if(oidsTC!=null){
                if(oidsTC.length != 0){ //si hay oids de tipos de clientes
                    for (int s=0;s<oidsTC.length;s++){
                        aux.add(oidsTC[s]);
                    }
                    String tiposCliente = this.convertirArrayToString(aux);
                    aux.clear();
                    consulta.append(" AND MCC.TICL_OID_TIPO_CLIE IN ("+ tiposCliente +")  ");
                    for(int r=0;r<oidsTC.length;r++){
                        parametros.add(oidsTC[r]);
                    }
                }
            }
        }
        consulta.append(" ),0) AS SUMA ");
        consulta.append(" FROM ");
        consulta.append(" MAE_CLIEN_TIPO_SUBTI TST, ");
        consulta.append(" MAE_SUBTI_CLIEN SUBT, ");
        consulta.append(" MAE_TIPO_CLIEN TIPO, ");
        
        //Modificado por Sapaza, fecha 03-10-2007, cambio Sicc20070441        
        //consulta.append(" MAE_CLIEN_DATOS_ADICI ADI, ");
        consulta.append(" MAE_CLIEN_BLOQU BLO, ");
        consulta.append(" MAE_TIPO_BLOQU MTB, ");
        
        consulta.append(" MAE_CLIEN CLI, ");
        consulta.append(" MAE_CLIEN_UNIDA_ADMIN ADM, ");
        consulta.append(" MAE_CLIEN_IDENT ID, ");
        consulta.append(" MAE_TIPO_DOCUM DC, ");
        consulta.append(" ZON_TERRI_ADMIN TER, ");
        consulta.append(" ZON_SECCI SEC, ");
        consulta.append(" ZON_ZONA ZON, ");
        consulta.append(" ZON_REGIO REG, ");
        consulta.append(" MAE_CLIEN_CLASI CCLAS, ");
        consulta.append(" MAE_CLASI CLAS, ");
        consulta.append(" MAE_TIPO_CLASI_CLIEN TCLAS ");
        consulta.append(" WHERE TST.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND TST.SBTI_OID_SUBT_CLIE = SUBT.OID_SUBT_CLIE ");
        consulta.append(" AND SUBT.TICL_OID_TIPO_CLIE = TIPO.OID_TIPO_CLIE ");

        //Modificado por Sapaza, fecha 03-10-2007, cambio Sicc20070441                
        //consulta.append(" AND ADI.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND BLO.CLIE_OID_CLIE(+) = CLI.OID_CLIE ");
        consulta.append(" AND MTB.OID_TIPO_BLOQ(+) = BLO.TIBQ_OID_TIPO_BLOQ ");
        consulta.append(" AND ((MTB.COD_TIPO_BLOQ IS NULL OR MTB.COD_TIPO_BLOQ <> '" + ConstantesMAE.BLOQUEO_FINANCIERO +"') ");
        consulta.append("      OR ( MTB.cod_tipo_bloq = '"+ ConstantesMAE.BLOQUEO_FINANCIERO + "' ");
        consulta.append(" AND BLO.fec_desb IS NOT NULL )) ");
        
        consulta.append(" AND CLI.OID_CLIE = ADM.CLIE_OID_CLIE ");
        consulta.append(" AND ADM.ZTAD_OID_TERR_ADMI = TER.OID_TERR_ADMI ");
        consulta.append(" AND TER.ZSCC_OID_SECC = SEC.OID_SECC ");
        consulta.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA ");
        consulta.append(" AND ZON.ZORG_OID_REGI = REG.OID_REGI ");
        consulta.append(" AND ID.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND ID.TDOC_OID_TIPO_DOCU = DC.OID_TIPO_DOCU");
        /* mdolce 21/06/2006 Se modifico para que si el cliente no tiene una clasificacion
         * de todas maneras lo devuelva, dado que no es obligatorio que el cliente tenga 
         * un registro en MAE_CLIEN_CLASI
         * */
        consulta.append(" AND TST.OID_CLIE_TIPO_SUBT = CCLAS.CTSU_OID_CLIE_TIPO_SUBT(+)");
        consulta.append(" AND CCLAS.CLAS_OID_CLAS = CLAS.OID_CLAS(+)");
        consulta.append(" AND CLAS.TCCL_OID_TIPO_CLAS = TCLAS.OID_TIPO_CLAS(+)");
        consulta.append(" AND ID.VAL_IDEN_DOCU_PRIN = 1 ");
        consulta.append(" AND CLI.PAIS_OID_PAIS = ? ");
        parametros.add(dtoe.getOidPais());
        //consulta.append(" AND ADI.IND_ACTI = 1 "); //true 
        /* mdolce 22/06/2006
         * Segun conversacion con hmansi, se agregan estos indicandores para que no repita clientes.
         * Segun yo si no le bolamos el indidcador de tipo subtipo no traera ningun registro.
         * */
			  consulta.append(" and adm.IND_ACTI = 1 ");
        if (dtoe.getListaTiposCliente()!=null){
            Long oidsTC[] = dtoe.getListaTiposCliente().getOids();
            if(oidsTC.length != 0){ //si hay oids de tipo de cliente
                for (int i=0;i<oidsTC.length;i++){
                    aux.add(oidsTC[i]);
                }
                String listaTiposCliente = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND TST.TICL_OID_TIPO_CLIE IN ("+ listaTiposCliente +")  ");//dtoe.listaTiposCliente 
                for(int j=0;j<oidsTC.length;j++){
                    parametros.add(oidsTC[j]);
                }
            }
        }
		
        if (dtoe.getListaSubtiposCliente()!=null){
            Long oidsSTC[] = dtoe.getListaSubtiposCliente().getOids();
            if((oidsSTC!=null)&&(oidsSTC.length != 0)){ // si hay oids de subtipocliente
                for (int k=0;k<oidsSTC.length;k++){
                    aux.add(oidsSTC[k]);
                }
                String listaSubTiposCliente = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND TST.SBTI_OID_SUBT_CLIE IN ("+ listaSubTiposCliente +")  "); //dtoe.listaSubtiposCliente 
                for(int h=0;h<oidsSTC.length;h++){
                    parametros.add(oidsSTC[h]);
                }
            }
        }
        
        if (dtoe.getListaZonas()!=null){
            Long oidsZonas[] = dtoe.getListaZonas().getOids();
            if(oidsZonas.length != 0){ //si hay oids de zonas
                for (int n=0;n<oidsZonas.length;n++){
                    aux.add(oidsZonas[n]);
                }
                String listaZonas = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND ZON.OID_ZONA IN ("+ listaZonas +") "); //dtoe.listaZonas 
                for(int m=0;m<oidsZonas.length;m++){
                    parametros.add(oidsZonas[m]);
                }
            }
        }
    
        if (dtoe.getListaRegiones()!=null){    
            Long oidsRegiones[] = dtoe.getListaRegiones().getOids();
            if(oidsRegiones.length != 0){ //si hay oids de regiones 
                for(int s=0;s<oidsRegiones.length;s++){
                    aux.add(oidsRegiones[s]);
                }
                String listaRegiones = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND ZON.ZORG_OID_REGI IN ("+ listaRegiones +") "); //listaRegiones 
                for(int r=0;r<oidsRegiones.length;r++){
                    parametros.add(oidsRegiones[r]);
                }
            }
        }
       /*mdolce 21/06/2006
        * Se agrego el filtrado por clasificacion y tipo clasificacion
        * que misteriosamente no estaba hecho.
        * */
        if (dtoe.getListaTiposClasificacion()!=null){    
            Long oidsTipoClasificaciones[] = dtoe.getListaTiposClasificacion().getOids();
            if(oidsTipoClasificaciones.length != 0){ //si hay oids de regiones 
                for(int s=0;s<oidsTipoClasificaciones.length;s++){
                    aux.add(oidsTipoClasificaciones[s]);
                }
                String listaTipoClasificaciones = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND TCLAS.OID_TIPO_CLAS IN ("+ listaTipoClasificaciones +") "); //listaRegiones 
                for(int r=0;r<oidsTipoClasificaciones.length;r++){
                    parametros.add(oidsTipoClasificaciones[r]);
                }
            }
        }

         if (dtoe.getListaClasificacion()!=null){    
            Long oidsClasificaciones[] = dtoe.getListaClasificacion().getOids();
            if(oidsClasificaciones.length != 0){ //si hay oids de regiones 
                for(int s=0;s<oidsClasificaciones.length;s++){
                    aux.add(oidsClasificaciones[s]);
                }
                String listaClasificaciones = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND CLAS.OID_CLAS IN ("+ listaClasificaciones +") "); //listaRegiones 
                for(int r=0;r<oidsClasificaciones.length;r++){
                    parametros.add(oidsClasificaciones[r]);
                }
            }
        }
        
        consulta.append(" ) WHERE SUMA > 0");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerClientes: Exception",e);
            this.logSql(" obtenerClientes. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }//catch
       
        if(rs!=null){
       if(!rs.esVacio()){
          for(int d=0;d<rs.getRowCount();d++){
            DTOINTDatosCliente dto = new DTOINTDatosCliente();
            if(rs.getValueAt(d,"OIDCLIENTE") != null ){
                    dto.setOidCliente(new Long(((BigDecimal)rs.getValueAt(d,"OIDCLIENTE")).longValue()));
                }
                if(rs.getValueAt(d,"CODCLI") != null){
                    dto.setCodigoCliente(rs.getValueAt(d,"CODCLI").toString());
                }               
                if(rs.getValueAt(d,"TIPODOCU") != null){
                    dto.setTipoDocumento(rs.getValueAt(d,"TIPODOCU").toString());
                }
                if(rs.getValueAt(d,"NUMDOCU") != null){
                    dto.setNumeroDocumento(rs.getValueAt(d,"NUMDOCU").toString());
                }
                if(rs.getValueAt(d,"DIGCTRL") != null){
                    dto.setDigitoControlDocumento(rs.getValueAt(d,"DIGCTRL").toString());
                }
                if(rs.getValueAt(d,"APE1") != null){
                    dto.setApellido1(rs.getValueAt(d,"APE1").toString());
                }
                if(rs.getValueAt(d,"APE2") != null){
                    dto.setApellido2(rs.getValueAt(d,"APE2").toString());
                }                
                if(rs.getValueAt(d,"NOM1") != null){
                    dto.setNombre1(rs.getValueAt(d,"NOM1").toString());
                }                
                if(rs.getValueAt(d,"NOM2") != null){
                    dto.setNombre2(rs.getValueAt(d,"NOM2").toString());
                }
                 if(rs.getValueAt(d,"ZONA") != null){
                    dto.setZonaConsultora(rs.getValueAt(d,"ZONA").toString());
                }
                 if(rs.getValueAt(d,"REGI") != null){
                    dto.setCodigoRegion(rs.getValueAt(d,"REGI").toString());
                }
                if(rs.getValueAt(d,"SUMA") != null){
                    dto.setImportePendiente(new Double(rs.getValueAt(d,"SUMA").toString()));
                }
                
                
            array.add(dto);
          }//for
        }//(!rs.esVacio()
      }//(rs!=null)
      
        UtilidadesLog.info("DAOINT.obtenerClientes(DTOINTEnviarConsultorasDeuda dtoe): Salida");
        return array;
    }


     
     
     
    public ArrayList obtenerClientes(DTOINTEnviarConsultorasDeuda dtoe) throws MareException{
        UtilidadesLog.info("DAOINT.obtenerClientes(DTOINTEnviarConsultorasDeuda dtoe): Entrada");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
       
        ArrayList aux = new ArrayList(); 
        ArrayList array = new ArrayList(); 
        // Se cambia la SQL por incidencia BELC300012392 
        
        consulta.append(" SELECT DISTINCT ");
        consulta.append(" TST.CLIE_OID_CLIE OIDCLIENTE, ");
        consulta.append(" CLI.COD_CLIE CODCLI, ");
        consulta.append(" DC.COD_TIPO_DOCU TIPODOCU, ");
        consulta.append(" ID.NUM_DOCU_IDEN NUMDOCU, ");
        consulta.append(" CLI.COD_DIGI_CTRL DIGCTRL, ");
        consulta.append(" CLI.VAL_APE1 APE1, ");
        consulta.append(" CLI.VAL_APE2 APE2, ");
        consulta.append(" CLI.VAL_NOM1 NOM1, ");
        consulta.append(" CLI.VAL_NOM2 NOM2, ");
        consulta.append(" ZON.COD_ZONA ZONA, ");
        consulta.append(" REG.COD_REGI REGI, ");
        consulta.append(" TIPO.COD_TIPO_CLIE TIPOCLI, ");
        consulta.append(" SUBT.COD_SUBT_CLIE SUBTIPOCLI ");

        //Modificado por Sapaza, fecha 09-10-2007, cambio Sicc20070441                        
        //consulta.append(" CLAS.COD_CLAS CLAS, ");
        //consulta.append(" TCLAS.COD_TIPO_CLAS TIPOCLAS ");
        
        consulta.append(" FROM ");
        consulta.append(" MAE_CLIEN_TIPO_SUBTI TST, ");
        consulta.append(" MAE_SUBTI_CLIEN SUBT, ");
        consulta.append(" MAE_TIPO_CLIEN TIPO, ");

        //Modificado por Sapaza, fecha 03-10-2007, cambio Sicc20070441
        //consulta.append(" MAE_CLIEN_DATOS_ADICI ADI, ");
        consulta.append(" MAE_CLIEN_BLOQU BLO, ");
        consulta.append(" MAE_TIPO_BLOQU MTB, ");
        
        consulta.append(" MAE_CLIEN CLI, ");
        consulta.append(" MAE_CLIEN_UNIDA_ADMIN ADM, ");
        consulta.append(" MAE_CLIEN_IDENT ID, ");
        consulta.append(" MAE_TIPO_DOCUM DC, ");
        consulta.append(" ZON_TERRI_ADMIN TER, ");
        consulta.append(" ZON_SECCI SEC, ");
        consulta.append(" ZON_ZONA ZON, ");
        consulta.append(" ZON_REGIO REG, ");
        consulta.append(" MAE_CLIEN_CLASI CCLAS, ");
        consulta.append(" MAE_CLASI CLAS, ");
        consulta.append(" MAE_TIPO_CLASI_CLIEN TCLAS ");
        consulta.append(" WHERE TST.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND TST.SBTI_OID_SUBT_CLIE = SUBT.OID_SUBT_CLIE ");
        consulta.append(" AND SUBT.TICL_OID_TIPO_CLIE = TIPO.OID_TIPO_CLIE ");
        
        //Modificado por Sapaza, fecha 03-10-2007, cambio Sicc20070441                
        //consulta.append(" AND ADI.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND BLO.CLIE_OID_CLIE(+) = CLI.OID_CLIE ");
        consulta.append(" AND MTB.OID_TIPO_BLOQ(+) = BLO.TIBQ_OID_TIPO_BLOQ ");
        consulta.append(" AND ((MTB.COD_TIPO_BLOQ IS NULL OR MTB.COD_TIPO_BLOQ <> '" + ConstantesMAE.BLOQUEO_FINANCIERO +"') ");
        consulta.append("      OR ( MTB.cod_tipo_bloq = '"+ ConstantesMAE.BLOQUEO_FINANCIERO + "' ");
        consulta.append(" AND BLO.fec_desb IS NOT NULL )) ");
        
        consulta.append(" AND CLI.OID_CLIE = ADM.CLIE_OID_CLIE ");
        consulta.append(" AND ADM.ZTAD_OID_TERR_ADMI = TER.OID_TERR_ADMI ");
        consulta.append(" AND TER.ZSCC_OID_SECC = SEC.OID_SECC ");
        consulta.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA ");
        consulta.append(" AND ZON.ZORG_OID_REGI = REG.OID_REGI ");
        consulta.append(" AND ID.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append(" AND ID.TDOC_OID_TIPO_DOCU = DC.OID_TIPO_DOCU");
        /* mdolce 21/06/2006 Se modifico para que si el cliente no tiene una clasificacion
         * de todas maneras lo devuelva, dado que no es obligatorio que el cliente tenga 
         * un registro en MAE_CLIEN_CLASI
         * */
        consulta.append(" AND TST.OID_CLIE_TIPO_SUBT = CCLAS.CTSU_OID_CLIE_TIPO_SUBT(+)");
        consulta.append(" AND CCLAS.CLAS_OID_CLAS = CLAS.OID_CLAS(+)");
        consulta.append(" AND CLAS.TCCL_OID_TIPO_CLAS = TCLAS.OID_TIPO_CLAS(+)");
        consulta.append(" AND ID.VAL_IDEN_DOCU_PRIN = 1 ");
        consulta.append(" AND CLI.PAIS_OID_PAIS = ? ");
        parametros.add(dtoe.getOidPais());
        //consulta.append(" AND ADI.IND_ACTI = 1 "); //true 
        /* mdolce 22/06/2006
         * Segun conversacion con hmansi, se agregan estos indicandores para que no repita clientes
         * */
        consulta.append(" and tst.IND_PPAL = 1 ");
			  consulta.append(" and adm.IND_ACTI = 1 ");
        if (dtoe.getListaTiposCliente()!=null){
            Long oidsTC[] = dtoe.getListaTiposCliente().getOids();
            if(oidsTC.length != 0){ //si hay oids de tipo de cliente
                for (int i=0;i<oidsTC.length;i++){
                    aux.add(oidsTC[i]);
                }
                String listaTiposCliente = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND TST.TICL_OID_TIPO_CLIE IN ("+ listaTiposCliente +")  ");//dtoe.listaTiposCliente 
                for(int j=0;j<oidsTC.length;j++){
                    parametros.add(oidsTC[j]);
                }
            }
        }
		
        if (dtoe.getListaSubtiposCliente()!=null){
            Long oidsSTC[] = dtoe.getListaSubtiposCliente().getOids();
            if((oidsSTC!=null)&&(oidsSTC.length != 0)){ // si hay oids de subtipocliente
                for (int k=0;k<oidsSTC.length;k++){
                    aux.add(oidsSTC[k]);
                }
                String listaSubTiposCliente = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND TST.SBTI_OID_SUBT_CLIE IN ("+ listaSubTiposCliente +")  "); //dtoe.listaSubtiposCliente 
                for(int h=0;h<oidsSTC.length;h++){
                    parametros.add(oidsSTC[h]);
                }
            }
        }
        
        if (dtoe.getListaZonas()!=null){
            Long oidsZonas[] = dtoe.getListaZonas().getOids();
            if(oidsZonas.length != 0){ //si hay oids de zonas
                for (int n=0;n<oidsZonas.length;n++){
                    aux.add(oidsZonas[n]);
                }
                String listaZonas = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND ZON.OID_ZONA IN ("+ listaZonas +") "); //dtoe.listaZonas 
                for(int m=0;m<oidsZonas.length;m++){
                    parametros.add(oidsZonas[m]);
                }
            }
        }
    
        if (dtoe.getListaRegiones()!=null){    
            Long oidsRegiones[] = dtoe.getListaRegiones().getOids();
            if(oidsRegiones.length != 0){ //si hay oids de regiones 
                for(int s=0;s<oidsRegiones.length;s++){
                    aux.add(oidsRegiones[s]);
                }
                String listaRegiones = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND ZON.ZORG_OID_REGI IN ("+ listaRegiones +") "); //listaRegiones 
                for(int r=0;r<oidsRegiones.length;r++){
                    parametros.add(oidsRegiones[r]);
                }
            }
        }
       /*mdolce 21/06/2006
        * Se agrego el filtrado por clasificacion y tipo clasificacion
        * que misteriosamente no estaba hecho.
        * */
        if (dtoe.getListaTiposClasificacion()!=null){    
            Long oidsTipoClasificaciones[] = dtoe.getListaTiposClasificacion().getOids();
            if(oidsTipoClasificaciones.length != 0){ //si hay oids de regiones 
                for(int s=0;s<oidsTipoClasificaciones.length;s++){
                    aux.add(oidsTipoClasificaciones[s]);
                }
                String listaTipoClasificaciones = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND TCLAS.OID_TIPO_CLAS IN ("+ listaTipoClasificaciones +") "); //listaRegiones 
                for(int r=0;r<oidsTipoClasificaciones.length;r++){
                    parametros.add(oidsTipoClasificaciones[r]);
                }
            }
        }
        
         if (dtoe.getListaClasificacion()!=null){    
            Long oidsClasificaciones[] = dtoe.getListaClasificacion().getOids();
            if(oidsClasificaciones.length != 0){ //si hay oids de regiones 
                for(int s=0;s<oidsClasificaciones.length;s++){
                    aux.add(oidsClasificaciones[s]);
                }
                String listaClasificaciones = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND CLAS.OID_CLAS IN ("+ listaClasificaciones +") "); //listaRegiones 
                for(int r=0;r<oidsClasificaciones.length;r++){
                    parametros.add(oidsClasificaciones[r]);
                }
            }
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerClientes: Exception",e);
            this.logSql(" obtenerClientes. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }//catch
       
        if(rs!=null){
       if(!rs.esVacio()){
          for(int d=0;d<rs.getRowCount();d++){
            DTOINTDatosCliente dto = new DTOINTDatosCliente();
            if(rs.getValueAt(d,"OIDCLIENTE") != null ){
                    dto.setOidCliente(new Long(((BigDecimal)rs.getValueAt(d,"OIDCLIENTE")).longValue()));
                }
                if(rs.getValueAt(d,"CODCLI") != null){
                    dto.setCodigoCliente(rs.getValueAt(d,"CODCLI").toString());
                }               
                if(rs.getValueAt(d,"TIPODOCU") != null){
                    dto.setTipoDocumento(rs.getValueAt(d,"TIPODOCU").toString());
                }
                if(rs.getValueAt(d,"NUMDOCU") != null){
                    dto.setNumeroDocumento(rs.getValueAt(d,"NUMDOCU").toString());
                }
                if(rs.getValueAt(d,"DIGCTRL") != null){
                    dto.setDigitoControlDocumento(rs.getValueAt(d,"DIGCTRL").toString());
                }
                if(rs.getValueAt(d,"APE1") != null){
                    dto.setApellido1(rs.getValueAt(d,"APE1").toString());
                }
                if(rs.getValueAt(d,"APE2") != null){
                    dto.setApellido2(rs.getValueAt(d,"APE2").toString());
                }                
                if(rs.getValueAt(d,"NOM1") != null){
                    dto.setNombre1(rs.getValueAt(d,"NOM1").toString());
                }                
                if(rs.getValueAt(d,"NOM2") != null){
                    dto.setNombre2(rs.getValueAt(d,"NOM2").toString());
                }
                 if(rs.getValueAt(d,"ZONA") != null){
                    dto.setZonaConsultora(rs.getValueAt(d,"ZONA").toString());
                }
                 if(rs.getValueAt(d,"REGI") != null){
                    dto.setCodigoRegion(rs.getValueAt(d,"REGI").toString());
                }
                 if(rs.getValueAt(d,"TIPOCLI") != null){
                    dto.setTipoCliente(rs.getValueAt(d,"TIPOCLI").toString());
                }
                if(rs.getValueAt(d,"SUBTIPOCLI") != null){
                    dto.setSubtipoCliente(rs.getValueAt(d,"SUBTIPOCLI").toString());
                }
                /*if(rs.getValueAt(d,"CLAS") != null){
                    dto.setClasificacion(rs.getValueAt(d,"CLAS").toString());
                }
                if(rs.getValueAt(d,"TIPOCLAS") != null){
                    dto.setTipoClasificacion(rs.getValueAt(d,"TIPOCLAS").toString());
                }*/
            array.add(dto);
          }//for
        }//(!rs.esVacio()
      }//(rs!=null)
      
        UtilidadesLog.info("DAOINT.obtenerClientes(DTOINTEnviarConsultorasDeuda dtoe): Salida");
        return array;
    }
    
    public  DTOOIDs obtenerMarcas (String codigoProceso, String codigoSubproceso, String identificadorES) throws MareException {
      UtilidadesLog.info("DAOINT.obtenerMarcas(String codigoProceso, String codigoSubproceso, String identificadorES): Entrada");
      
      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      consulta.append(" SELECT  ");
      consulta.append(" MSIT.OID_MARC_SITU  ");

      consulta.append(" FROM  ");
      consulta.append(" CCC_MARCA_TIPO_ABONO MTAB,  ");
      consulta.append(" CCC_MARCA_SITUA MSIT,  ");
      consulta.append(" CCC_TIPO_ABONO_SUBPR TSUB,  ");
      consulta.append(" CCC_SUBPR SUB,  ");
      consulta.append(" CCC_PROCE PRO  ");

      consulta.append(" WHERE  ");
      consulta.append(" MTAB.MASI_OID_MARC_SALI = MSIT.OID_MARC_SITU AND  ");
      consulta.append(" MTAB.TASP_OID_TIPO_ABON_SUBP = TSUB.OID_TIPO_ABON_SUBP AND  ");
      consulta.append(" TSUB.SUBP_OID_SUBP = SUB.OID_SUBP AND  ");
      consulta.append(" SUB.CCPR_OID_PROC = PRO.OID_PROC AND  ");
      
      consulta.append(" PRO.COD_PROC = ? AND  ");
      parametros.add(codigoProceso);
      
      consulta.append(" SUB.COD_SUBP = ? ");
      parametros.add(codigoSubproceso);
      
      if(identificadorES!=null){
        consulta.append(" AND MTAB.IND_ENTR_SALI = ?  ");
        parametros.add(identificadorES);
      }
      // Se ejecuta la consulta 
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;
      String codigoError = null;
      
      try{
          rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
      }catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error(" obtenerMarcas: Exception",e);
          this.logSql(" obtenerMarcas. SQL: ",consulta.toString(),parametros);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
  
      Long oids[] = null;
      if (!rs.esVacio()) {
        oids = new Long[rs.getRowCount()];
        for (int i=0; i < rs.getRowCount(); i++) {
          Vector fila = rs.getRow(i);
          oids[i] = new Long(((BigDecimal)fila.elementAt(0)).longValue());
        }
      }
      
      DTOOIDs dto = new DTOOIDs();
      dto.setOids(oids);
		
      UtilidadesLog.info("DAOINT.obtenerMarcas(String codigoProceso, String codigoSubproceso, String identificadorES): Salida");
      return dto;
	 }
     
     public ArrayList obtenerMovimientosCC (DTOINTEnviarConsultorasDeuda dtoe, DTOOIDs listaClientes, DTOOIDs listaMarcas) throws MareException {
      //Código modificado por incidencia 12330
      //Se vuelve a modificar la consulta por la incidencia 13165
      UtilidadesLog.info("DAOINT.obtenerMovimientosCC(DTOINTEnviarConsultorasDeuda dtoe, DTOOIDs listaClientes, DTOOIDs listaMarcas): Entrada");
      
      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      ArrayList array=new ArrayList();

      consulta.append(" SELECT ");
      consulta.append("   CLI.OID_CLIE OIDCLIENTE, ");
      consulta.append("   MC.IMP_PEND IMP, ");
      /*mdolce 21/06/2006
       * Se concatena el valor de ejercicio cuota al numero identificador de cuota
       * porque asi se debe hacer, se le completan ceros a la izquierda de ambos
       * */
      consulta.append("   ( LPAD(mc.val_ejer_cuot,2,0)|| LPAD(mc.num_iden_cuot, 8, 0)) NUM, ");
      consulta.append("   TP.COD_TIPO_PERI CODTIP, ");
      consulta.append("   PE.VAL_NOMB_PERI NOM, ");
      consulta.append("   MC.FEC_DOCU FECDOCU, ");
      consulta.append("   MC.FEC_VENC FECVENC, ");
      consulta.append("   MP.COD_MEDI_PAGO CODMED, ");
      consulta.append("   MC.VAL_REFE_NUME_DOCU_EXTE REFE, ");
      consulta.append("   PC.COD_PERI CODPED " );

      consulta.append(" FROM ");
      consulta.append("   CCC_MOVIM_CUENT_CORRI MC, ");
      consulta.append("   MAE_CLIEN CLI, ");
      consulta.append("   SEG_TIPO_PERIO TP, ");
      consulta.append("   CRA_PERIO PE, ");
      consulta.append("   BEL_MEDIO_PAGO MP, ");
      consulta.append("   ZON_TERRI_ADMIN TERR, ");
      consulta.append("   ZON_SECCI SEC, ");
      consulta.append("   ZON_ZONA ZO, ");
      consulta.append("   ZON_REGIO RE, ");
      consulta.append("     CCC_MARCA_SITUA MS, ");
      consulta.append("     SEG_SUBAC SBAC, ");
      consulta.append("     SEG_ACCES ACCE, ");
      consulta.append("     SEG_CANAL CAN, ");
      consulta.append("     SEG_PERIO_CORPO PC ");

      consulta.append("   WHERE ");
      consulta.append("     MC.CLIE_OID_CLIE = CLI.OID_CLIE ");
      consulta.append("     AND MC.MASI_OID_MARC_SITU = MS.OID_MARC_SITU ");
      consulta.append("     AND MC.PERD_OID_PERI = PE.OID_PERI ");
      consulta.append("     AND MC.MPAB_OID_MEDI_PAGO = MP.OID_MEDI_PAGO(+) ");
      consulta.append("     AND TERR.ZSCC_OID_SECC = SEC.OID_SECC ");
      consulta.append("     AND SEC.ZZON_OID_ZONA = ZO.OID_ZONA ");
      consulta.append("     AND MC.ZTAD_OID_TERR_ADMI = TERR.OID_TERR_ADMI ");
      consulta.append("     AND MC.ZORG_OID_REGI = RE.OID_REGI ");
      consulta.append("     AND MC.SBAC_OID_SBAC = SBAC.OID_SBAC ");
      consulta.append("     AND SBAC.ACCE_OID_ACCE = ACCE.OID_ACCE ");
      consulta.append("     AND ACCE.CANA_OID_CANA = CAN.OID_CANA ");
      consulta.append("     AND CAN.TIPE_OID_TIPO_PERI = TP.OID_TIPO_PERI ");
      consulta.append("     AND PE.PERI_OID_PERI = PC.OID_PERI ");




/* Filtros
  AND MC.CLIE_OID_CLIE IN listaClientes
  AND MS.OID_MARC_SITU IN listaMarcas
  AND MC.SOCI_OID_SOCI IN dtoe.listaEmpresas
  AND MC.FEC_DOCU >= dtoe.fechaDesde
  AND MC.FEC_DOCU <= dtoe.fechaHasta
*/

      //Añadimos a la consulta los clientes
      ArrayList aux = new ArrayList();
      Long oidsClientes[] = listaClientes.getOids();
      if (oidsClientes!=null){
          if(oidsClientes.length != 0){ 
              for (int i=0;i<oidsClientes.length;i++){
                  aux.add(oidsClientes[i]);
              }
              String clientes = this.convertirArrayToString(aux);
              aux.clear();
              consulta.append(" AND MC.CLIE_OID_CLIE IN ("+ clientes +")  ");
              for(int j=0;j<oidsClientes.length;j++){
                  parametros.add(oidsClientes[j]);
              }
          }
          aux.clear();
      }
      
      //Añadimos a la consulta las marcas 
      Long oidsMarcas[] = listaMarcas.getOids();
      if (oidsMarcas != null){
          if(oidsMarcas.length != 0){ 
              for (int k=0;k<oidsMarcas.length;k++){
                  aux.add(oidsMarcas[k]);
              }
              String marcas = this.convertirArrayToString(aux);
              aux.clear();
              consulta.append(" AND MS.OID_MARC_SITU IN ("+ marcas +")  ");
              for(int h=0;h<oidsMarcas.length;h++){
                  parametros.add(oidsMarcas[h]);
              }
          }
          aux.clear();
      }

      //Añadimos a la consulta las empresas 
      DTOOIDs dtooidsEmpresa = dtoe.getListaEmpresa();
      if (dtooidsEmpresa!=null){
          Long oidsEM[] = dtooidsEmpresa.getOids();
          if(oidsEM!=null){
              if(oidsEM.length != 0){ //si hay oids de tipos de clientes
                  for (int s=0;s<oidsEM.length;s++){
                      aux.add(oidsEM[s]);
                  }
                  String empresas = this.convertirArrayToString(aux);
                  aux.clear();
                  consulta.append(" AND MC.SOCI_OID_SOCI IN ("+ empresas +")  ");
                  for(int r=0;r<oidsEM.length;r++){
                      parametros.add(oidsEM[r]);
                  }
              }
          }
      }

      //Añadimos a la consulta los tipos de clientes
      ArrayList str = new ArrayList();
      if (dtoe.getListaTiposCliente() != null) {
          Long oidsTiposCliente[] = dtoe.getListaTiposCliente().getOids();
          if (oidsTiposCliente != null){
              if (oidsTiposCliente.length != 0){ //si hay oids de tipos de clientes
                  for (int s=0;s<oidsTiposCliente.length;s++){
                      str.add(oidsTiposCliente[s]);
                  }
                  String tiposCliente = this.convertirArrayToString(str);
                  str.clear();
                  consulta.append(" AND MC.TICL_OID_TIPO_CLIE IN ("+ tiposCliente +")  ");
                  for (int r=0;r<oidsTiposCliente.length;r++) {
                      parametros.add(oidsTiposCliente[r]);
                  }
              }
          }
      }

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      if(dtoe.getFechaDesde() != null){
          java.sql.Date fechaD = new java.sql.Date(dtoe.getFechaDesde().getTime());
          String sFechaDesde = sdf.format(fechaD);
          //consulta.append(" AND MC.FEC_DOCU >=  TO_DATE( ? ,'YYYY-MM-DD') ");      
          consulta.append(" AND TO_DATE(TO_CHAR(MC.FEC_DOCU, 'YYYY-MM-DD'), 'YYYY-MM-DD')  >=  TO_DATE( ? ,'YYYY-MM-DD') ");      
          parametros.add(sFechaDesde);
      }
      if(dtoe.getFechaHasta() != null){
          java.sql.Date fechaH = new java.sql.Date(dtoe.getFechaHasta().getTime());
          String sFechaHasta = sdf.format(fechaH);
          //consulta.append(" AND MC.FEC_DOCU <=  TO_DATE( ? ,'YYYY-MM-DD') ");               
          consulta.append(" AND TO_DATE(TO_CHAR(MC.FEC_DOCU, 'YYYY-MM-DD'), 'YYYY-MM-DD')  <=  TO_DATE( ? ,'YYYY-MM-DD') ");                
          parametros.add(sFechaHasta);
      }          
      
       // Se ejecuta la consulta 
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;
      String codigoError = null;
      
      try{
          rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
      }catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error(" obtenerMovimientosCC: Exception",e);
          this.logSql(" obtenerMovimientosCC. SQL: ",consulta.toString(),parametros);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      //Con los registros obtenidos se crea una lista de objetos DTOINTMovimientosCC y se retorna.

      if(rs!=null){
       if(!rs.esVacio()){
          for(int d=0;d<rs.getRowCount();d++){
            DTOINTMovimientosCC dto = new DTOINTMovimientosCC();
            if(rs.getValueAt(d,"OIDCLIENTE") != null ){
                    dto.setCliente(new Long(((BigDecimal)rs.getValueAt(d,"OIDCLIENTE")).longValue()));
                }
                if(rs.getValueAt(d,"IMP") != null){
                    dto.setImportePendiente((BigDecimal)rs.getValueAt(d,"IMP"));
                }               
                if(rs.getValueAt(d,"NUM") != null){
                   dto.setNumeroIdentificadorCuota(rs.getValueAt(d, "NUM").toString());
                    
                }
                if(rs.getValueAt(d,"CODTIP") != null){
                    dto.setCodigoTipoPeriodo(rs.getValueAt(d,"CODTIP").toString());
                }
                if(rs.getValueAt(d,"CODPED") != null){
                    dto.setCodigoPeriodo(rs.getValueAt(d,"CODPED").toString());
                }
                if(rs.getValueAt(d,"FECDOCU") != null){
                    dto.setFechaDocumento((java.sql.Date)rs.getValueAt(d,"FECDOCU"));
                }
                if(rs.getValueAt(d,"FECVENC") != null){
                    dto.setFechaVencimiento((java.sql.Date)rs.getValueAt(d,"FECVENC"));
                }
                if(rs.getValueAt(d,"CODMED") != null){
                    dto.setMedioPago(rs.getValueAt(d,"CODMED").toString());
                }
                if(rs.getValueAt(d,"REFE") != null){
                    dto.setReferenciaNumeroDocumentoExterno(rs.getValueAt(d,"REFE").toString());
                }
            array.add(dto);
          }//for
        }//(!rs.esVacio()
      }//(rs!=null)
     
      UtilidadesLog.info("DAOINT.obtenerMovimientosCC(DTOINTEnviarConsultorasDeuda dtoe, DTOOIDs listaClientes, DTOOIDs listaMarcas): Salida");
      return array;
  }
  
    public ArrayList obtenerMovimientosCCAgrupados(DTOINTEnviarConsultorasDeuda dtoe, DTOOIDs listaClientes, DTOOIDs listaMarcas) throws MareException{
        UtilidadesLog.info("DAOINT.obtenerMovimientosCCAgrupados(DTOINTEnviarConsultorasDeuda dtoe, DTOOIDs listaClientes, DTOOIDs listaMarcas): Entrada");
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList aux = new ArrayList();
                
        consulta.append(" SELECT CLI.PAIS_OID_PAIS PAIS, CLI.OID_CLIE OIDCLIENTE, ");
        consulta.append(" CLI.COD_CLIE CODCLIENTE, SUM( MCC.IMP_PEND ) SUMA ");
        
        consulta.append(" FROM CCC_MOVIM_CUENT_CORRI MCC, MAE_CLIEN CLI ");
        
        consulta.append(" WHERE ");
        consulta.append(" MCC.CLIE_OID_CLIE = CLI.OID_CLIE ");
        
        Long oidsClientes[] = listaClientes.getOids();
        if(oidsClientes.length != 0){ //si hay oids de clientes
            for (int i=0;i<oidsClientes.length;i++){
                aux.add(oidsClientes[i]);
            }
            String clientes = this.convertirArrayToString(aux);
            aux.clear();
            consulta.append(" AND MCC.CLIE_OID_CLIE IN ("+ clientes +")  ");
            for(int j=0;j<oidsClientes.length;j++){
                parametros.add(oidsClientes[j]);
            }
        }

        Long oidsMarcas[] = listaMarcas.getOids();
        if (oidsMarcas!=null){
            if(oidsMarcas.length != 0){ //si hay oids de marcas
                for (int k=0;k<oidsMarcas.length;k++){
                    aux.add(oidsMarcas[k]);
                }
                String marcas = this.convertirArrayToString(aux);
                aux.clear();
                consulta.append(" AND MCC.MASI_OID_MARC_SITU IN ("+ marcas +")  ");
                for(int h=0;h<oidsMarcas.length;h++){
                    parametros.add(oidsMarcas[h]);
                }
            }
        }


        DTOOIDs dtooidsEmpresa = dtoe.getListaEmpresa();
        if (dtooidsEmpresa!=null){
            Long oidsEM[] = dtooidsEmpresa.getOids();
            if(oidsEM!=null){
                if(oidsEM.length != 0){ //si hay oids de tipos de clientes
                    for (int s=0;s<oidsEM.length;s++){
                        aux.add(oidsEM[s]);
                    }
                    String empresas = this.convertirArrayToString(aux);
                    aux.clear();
                    consulta.append(" AND MCC.SOCI_OID_SOCI IN ("+ empresas +")  ");
                    for(int r=0;r<oidsEM.length;r++){
                        parametros.add(oidsEM[r]);
                    }
                }
            }
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(dtoe.getFechaDesde() != null){
            java.sql.Date fechaD = new java.sql.Date(dtoe.getFechaDesde().getTime());
            String sFechaDesde = sdf.format(fechaD);
            consulta.append(" AND MCC.FEC_DOCU >=  TO_DATE( ? ,'YYYY-MM-DD') ");             
            parametros.add(sFechaDesde);
        }
        if(dtoe.getFechaHasta() != null){
            java.sql.Date fechaH = new java.sql.Date(dtoe.getFechaHasta().getTime());
            String sFechaHasta = sdf.format(fechaH);
            consulta.append(" AND MCC.FEC_DOCU <=  TO_DATE( ? ,'YYYY-MM-DD') ");               
            parametros.add(sFechaHasta);
        }
       
        DTOOIDs dtooidsTC = dtoe.getListaTiposCliente();
        if (dtooidsTC!=null){
            Long oidsTC[] = dtooidsTC.getOids();
            if(oidsTC!=null){
                if(oidsTC.length != 0){ //si hay oids de tipos de clientes
                    for (int s=0;s<oidsTC.length;s++){
                        aux.add(oidsTC[s]);
                    }
                    String tiposCliente = this.convertirArrayToString(aux);
                    aux.clear();
                    consulta.append(" AND MCC.TICL_OID_TIPO_CLIE IN ("+ tiposCliente +")  ");
                    for(int r=0;r<oidsTC.length;r++){
                        parametros.add(oidsTC[r]);
                    }
                }
            }
        }
        consulta.append(" GROUP BY CLI.PAIS_OID_PAIS, CLI.OID_CLIE, CLI.COD_CLIE ");
 
        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
          
        try{
            rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerMovimientosCCAgrupados: Exception",e);
            this.logSql(" obtenerMovimientosCCAgrupados. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        ArrayList salida = new ArrayList();
        
        if(!rs.esVacio()){
            for(int d=0;d<rs.getRowCount();d++){
                DTOINTMovimientosCC dto = new DTOINTMovimientosCC();
                if(rs.getValueAt(d,"PAIS") != null ){
                    dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(d,"PAIS")).longValue()));
                }
                if(rs.getValueAt(d,"OIDCLIENTE") != null){
                    dto.setCliente(new Long(((BigDecimal)rs.getValueAt(d,"OIDCLIENTE")).longValue()));
                }
                if(rs.getValueAt(d,"CODCLIENTE") != null){
                    dto.setCodigoCliente(rs.getValueAt(d,"CODCLIENTE").toString());
                }
                if(rs.getValueAt(d,"SUMA") != null){
                    dto.setImportePendiente((BigDecimal)rs.getValueAt(d,"SUMA"));
                }
                salida.add(dto);
                
            }    
        }         
        UtilidadesLog.info("DAOINT.obtenerMovimientosCCAgrupados(DTOINTEnviarConsultorasDeuda dtoe, DTOOIDs listaClientes, DTOOIDs listaMarcas): Salida");
        return salida;
     }
     
     public ArrayList obtenerParametrosFAC (Long pais, String indicadorCabeceraDetalle, String tipoAsientos) throws MareException{
         UtilidadesLog.info("DAOINT.obtenerParametrosFAC(Long pais, String indicadorCabeceraDetalle, String tipoAsientos): Entrada");
         
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append(" SELECT PCF.*, ICF.COD_IMPO_CONT ");
        
        consulta.append(" FROM INT_PARAM_CONTA_FACTU PCF,  ");
        consulta.append(" INT_IMPOR_CONTA_FACTU ICF ");
        
        consulta.append(" WHERE PCF.IMCF_OID_IMPO_CONT_FACT = ICF.OID_IMPO_CONT_FACT ");
        consulta.append(" AND PCF.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append(" AND PCF.VAL_IDEN_CABE_DETA = ? ");
        parametros.add(indicadorCabeceraDetalle);
        consulta.append(" AND PCF.VAL_TIPO_ASIE = ?  ");
        parametros.add(tipoAsientos);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerParametrosFAC: Exception",e);
            this.logSql(" obtenerParametrosFAC. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }//catch
        
        ArrayList salida = new ArrayList();
        
        if(!rs.esVacio()){
            for(int d=0;d<rs.getRowCount();d++){
                DTOINTParametrosContablesFAC dto = new DTOINTParametrosContablesFAC();
                
                dto.setOid(new Long(((BigDecimal)rs.getValueAt(d,"OID_PARA_CONT_FACT")).longValue()));

                dto.setCodigoApunte((rs.getValueAt(d,"COD_APUN")).toString());

                dto.setTipoAsiento(rs.getValueAt(d,"VAL_TIPO_ASIE").toString());

                dto.setIdentificadorCabeceraDetalle(rs.getValueAt(d,"VAL_IDEN_CABE_DETA").toString());

                dto.setDescripcion(rs.getValueAt(d,"VAL_DESC").toString());

                if(rs.getValueAt(d,"VAL_GRUP_ARTI") != null){
                    dto.setGrupoArticulos(rs.getValueAt(d,"VAL_GRUP_ARTI").toString());
                }
                
                dto.setIndicadorDebeHaber(rs.getValueAt(d,"VAL_INDI_DEBE_HABE").toString());
                
                dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(d,"PAIS_OID_PAIS")).longValue()));
                
                if(rs.getValueAt(d,"PROD_OID_PROD") != null){
                    dto.setProducto(new Long(((BigDecimal)rs.getValueAt(d,"PROD_OID_PROD")).longValue()));
                }
                dto.setCuentaContable(new Long(((BigDecimal)rs.getValueAt(d,"CUCO_OID_CUEN_CONT")).longValue()));
                if(rs.getValueAt(d,"MAPR_OID_MARC_PROD") != null){
                    dto.setMarcaProducto(new Long(((BigDecimal)rs.getValueAt(d,"MAPR_OID_MARC_PROD")).longValue()));
                }
                if(rs.getValueAt(d,"NEGO_OID_NEGO") != null){
                    dto.setNegocio(new Long(((BigDecimal)rs.getValueAt(d,"NEGO_OID_NEGO")).longValue()));
                }
                dto.setImporteAContabilizar(new Long(((BigDecimal)rs.getValueAt(d,"IMCF_OID_IMPO_CONT_FACT")).longValue()));                
                dto.setPais(pais);
                dto.setCodigoImporteAContabilizar(rs.getValueAt(d,"COD_IMPO_CONT").toString());
                
                salida.add(dto);       
            }    
        }
         UtilidadesLog.info("DAOINT.obtenerParametrosFAC(Long pais, String indicadorCabeceraDetalle, String tipoAsientos): Salida");
         return salida;
     }
 
    public ArrayList obtenerProcesosCCC () throws MareException{
        UtilidadesLog.info("DAOINT.obtenerProcesosCCC(): Entrada");
       
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(" SELECT PAC.OID_PARA_CONT OID, ");
        consulta.append(" SUB.CCPR_OID_PROC PROCESO,  ");
        consulta.append(" PAC.SUBP_OID_SUBP SUBPROCESO,  ");
        consulta.append(" PAC.VAL_DEBE_HABE INDICATIVODEBEHABER , ");
        consulta.append(" PAC.VAL_OBTE_CUEN OBTENCIONCUENTA,  ");
        consulta.append(" PAC.CUCO_OID_CUEN_CONT_DIRE CUENTADIRECTA  ");
        consulta.append(" FROM CCC_PARAM_CONTA PAC, CCC_SUBPR SUB  ");
        consulta.append(" WHERE PAC.SUBP_OID_SUBP = SUB.OID_SUBP  ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executeStaticQuery(consulta.toString());
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerProcesosCCC: Exception",e);
            this.logSql(" obtenerProcesosCCC. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }//catch
        
        ArrayList salida = new ArrayList();
   
        //Con el RecordSet obtenido se construye una lista de objetos DTOINTParametrosContablesCCC y se retorna.
        if(!rs.esVacio()){
         
            UtilidadesLog.debug("*** Metodo DAOINT.obtenerProcesosCCC. Numero de registros en el RecordSet: " + rs.getRowCount());
        
            for(int d=0;d<rs.getRowCount();d++){
                DTOINTParametrosContablesCCC dto = new DTOINTParametrosContablesCCC();
                
                if (rs.getValueAt(d,"OID")!=null){
                    dto.setOid(new Long(((BigDecimal)rs.getValueAt(d,"OID")).longValue()));
                }
                if (rs.getValueAt(d,"PROCESO")!=null){
                    dto.setProceso(new Long(((BigDecimal)rs.getValueAt(d,"PROCESO")).longValue()));
                }
                if (rs.getValueAt(d,"SUBPROCESO")!=null){
                    dto.setSubproceso(new Long(((BigDecimal)rs.getValueAt(d,"SUBPROCESO")).longValue()));
                }
                if (rs.getValueAt(d,"INDICATIVODEBEHABER")!=null){
                    dto.setIndicativoDebeHaber(rs.getValueAt(d,"INDICATIVODEBEHABER").toString());
                }
                if (rs.getValueAt(d,"OBTENCIONCUENTA")!=null){                
                    dto.setObtencionCuenta(rs.getValueAt(d,"OBTENCIONCUENTA").toString());
                }
                if (rs.getValueAt(d,"CUENTADIRECTA")!=null){                
                    dto.setCuentaDirecta(new Long(((BigDecimal)rs.getValueAt(d,"CUENTADIRECTA")).longValue()));
                }
                
                salida.add(dto);       
            }    
        }
    
        UtilidadesLog.info("DAOINT.obtenerProcesosCCC(): Salida");
        return salida;
    }

    /**
     * Retorna las distintas zonas para el pais indicado y con lote de contabilizacion en nulo.
     * @autor gdmarzi
     */
    public RecordSet obtenerZonasSinContabilizar(Long pais) throws MareException  {
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer consulta;
        RecordSet rs;
        String codigoError;
        consulta = new StringBuffer();
        consulta.append(" SELECT DISTINCT cab.zzon_oid_zona zona ");
        consulta.append(" FROM fac_docum_conta_cabec cab ");
        consulta.append(" WHERE cab.pais_oid_pais = " + pais);
        consulta.append("  AND cab.num_lote_cont IS NULL ");
        try{
           rs = bs.dbService.executeStaticQuery(consulta.toString());
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerDocumentosContables0: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        return rs;
    }


    /**
     * Obtiene los documentos contables para Ventas, Abonos y Transportistas.
     * Incidencias BELC300013744, BELC300013389 para el campo RUC, BELC300013913.
     * Indicencia BELC300017884, los atributos de DTOINTDocumentosContables que se 
     * puedan rellenar con valores null de BBDD se completan con la cadena vacia.
     * @cambio se filtra por zona por necesidad de performance de obtener menos registros a procesar.
     */
    public DTOINTDocumentosContables obtenerDocumentosContables(Long pais, Long zona, Date fechaHasta) throws MareException  {
        UtilidadesLog.info("DAOINT.obtenerDocumentosContables(Long pais): Entrada");
        DTOINTDocumentosContables dtoDC = new DTOINTDocumentosContables(); 
        StringBuffer consulta = null;
        Vector parametros = null;
        DTOINTDocumentoContable dto = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        ArrayList salida = new ArrayList();
        ArrayList listaAuxiliar = null;
        RecuperadorIdiomaDefectoServidor recuperadorIdioma = new RecuperadorIdiomaDefectoServidor();
        Long idiomaPorDefecto = recuperadorIdioma.getIdiomaDefectoServidor();

        //<inicio>incidencia SiCC-20070233 (Sapaza), se agrega filtro fechaHasta
        String sFechaHasta = null;
        if (fechaHasta != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date dFechaHasta = new java.sql.Date(fechaHasta.getTime());
            sFechaHasta = sdf.format(dFechaHasta);
        }      
        //<fin>incidencia SiCC-20070233 (Sapaza)

        /*
         * 1.- Primero se obtienen los documentos contables para ventas sin transportista: 
         */
        consulta = new StringBuffer();
        parametros = new Vector();
        consulta.append("SELECT ");
        consulta.append("CAB.PAIS_OID_PAIS PAIS, ");
        consulta.append("PAI.COD_PAIS CODIGOPAIS, ");
        consulta.append("CAB.FEC_FACT FECHA, ");
        consulta.append("CAB.SOCI_OID_SOCI SOCIEDAD, ");
        consulta.append("SOC.COD_SOCI CODIGOEMPRESA, ");
        consulta.append("CANA.COD_CANA CODIGOCANAL, ");
        consulta.append("ACCE.COD_ACCE CODIGOACCESO, ");
        consulta.append("CAB.SBAC_OID_SBAC SUBACCESO, ");
        consulta.append("SBAC.COD_SBAC CODIGOSUBACCESO, ");
        consulta.append("TPE.COD_TIPO_PERI CODIGOTIPOPERIODO, ");
        consulta.append("PERI.PERI_OID_PERI PERIODO, ");
        consulta.append("PCOR.COD_PERI CODIGOPERIODO, ");
        consulta.append("PCOR.VAL_ANIO EJERCICIOCOMERCIAL, ");
        consulta.append("CAB.VAL_NUME_IDEN_FISC RUC, ");
        consulta.append("LIN.PROD_OID_PROD PRODUCTO, ");
        consulta.append("PRO.MAPR_OID_MARC_PROD MARCAPRODUCTO, ");
        consulta.append("MPRO.COD_MARC_PROD CODIGOMARCAPRODUCTO, ");
        consulta.append("PRO.VAL_GRUP_ARTI GRUPOPRODUCTOS, ");               
        consulta.append("PRO.NEGO_OID_NEGO NEGOCIO, ");
        consulta.append("NEGO.COD_NEGO CODIGONEGOCIO, ");            
        consulta.append("TOF.OID_TIPO_OFER TIPOOFERTA, ");
        consulta.append("TOF.COD_TIPO_OFER CODIGOTIPOOFERTA, ");
        consulta.append("dof.CIVI_OID_CICLO_VIDA ciclovida, ");
        consulta.append("CVI.COD_CICL_VIDA CODIGOCICLOVIDA, ");
        // vbongiov -- Cambio 20090922 -- 28/05/2009
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("     else (LIN.VAL_PREC_SIN_IMPU_TOTA_LOCA ");       
        consulta.append(" - DECODE ((SELECT  NVL(par.IND_IMPU_PROD_NACI,0) FROM  SEG_PARAM_INTER_PAIS par WHERE par.PAIS_OID_PAIS = " + pais);
        consulta.append(" ),1, NVL(LIN.IMP_IMPU_TOTA_PROD_NACI,0) ,0)) ");
        consulta.append(" end IMPORTE01, ");
        
        // vbongiov -- Cambio 20090905 -- 10/06/2009
        consulta.append(" DECODE ((SELECT  NVL(par.IND_IMPU_PROD_GRAT,0) FROM  SEG_PARAM_INTER_PAIS par WHERE par.PAIS_OID_PAIS = " + pais);
        consulta.append(" ),1, (LIN.IMP_IMPU_TOTA_LOCA * DECODE(LiN.VAL_PREC_CATA_UNIT_LOCA, 0, 1,0)),LIN.IMP_IMPU_TOTA_LOCA) IMPORTE03, ");       
        
        // vbongiov -- Cambio 20090922 -- 28/05/2009
        consulta.append(" DECODE ((SELECT  NVL(par.IND_IMPU_PROD_NACI,0) FROM  SEG_PARAM_INTER_PAIS par WHERE par.PAIS_OID_PAIS = " + pais);
        consulta.append(" ),1, NVL(LIN.IMP_IMPU_TOTA_PROD_NACI,0) ,0) IMPORTE04, ");
        
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else lin.IMP_DESC_SIN_IMPU_TOTA_LOCA end IMPORTE05, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('C','R') then 0 ");
        consulta.append("    else lin.val_prec_cont_tota_loca end CONDICIONIMPORTE07, ");

        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.VAL_TOTA_PAGA_LOCA end IMPORTE50, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_REDO_LOCA end IMPORTE55, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_IMPU_TOTA_LOCA end IMPORTE60, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_FLET_IMPU_TOTA_LOCA end IMPORTE70, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_DES1_SIN_IMPU_TOTA end IMPORTE80, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.VAL_PREC_CONT_SIN_IMPU_TOTA end IMPORTE84, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_DES3_SIN_IMPU_TOTA end IMPORTE88, ");
        //cambio SAPFI-001  (SCS-07/05/08)
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.VAL_IMPO_IVA_ASUM_EMPR end IMPORTE90, ");

        consulta.append("PRO.COD_SAP CODIGOPRODUCTO, ");
        consulta.append("   (SELECT idio.val_i18n  ");
        consulta.append("   FROM v_gen_i18n_sicc idio    ");
        consulta.append("   WHERE idio.attr_enti = 'SEG_CANAL'    ");
        consulta.append("   AND idio.idio_oid_idio = ?    ");
        parametros.add(idiomaPorDefecto);  
        consulta.append("   AND idio.val_oid = cana.OID_CANA ) AS DESCRIPCIONCANAL, ");              
        consulta.append("  cab.OID_CABE OIDCABECERA, ");
        consulta.append("  lin.OID OIDLINEA ");
        consulta.append("FROM ");
        consulta.append("FAC_DOCUM_CONTA_CABEC CAB, ");
        consulta.append("FAC_DOCUM_CONTA_LINEA LIN, ");
        consulta.append("SEG_PAIS PAI, ");
        consulta.append("SEG_SOCIE SOC, ");
        consulta.append("MAE_PRODU PRO, ");
        consulta.append("PED_SOLIC_CABEC PSC, ");
        consulta.append("PED_SOLIC_POSIC SOP, ");
        consulta.append("PRE_OFERT_DETAL DOF, ");
        consulta.append("SEG_SUBAC SBAC, ");
        consulta.append("SEG_ACCES ACCE, ");
        consulta.append("SEG_CANAL CANA, ");
        consulta.append("CRA_PERIO PERI, ");
        consulta.append("SEG_PERIO_CORPO PCOR, ");
        consulta.append("SEG_TIPO_PERIO TPE, ");
        consulta.append("SEG_MARCA_PRODU MPRO, ");
        consulta.append("MAE_NEGOC NEGO, ");
        consulta.append("PRE_TIPO_OFERT TOF, ");
        consulta.append("PRE_CICLO_VIDA CVI, ");
        consulta.append("INC_CONCU_TIPO_PROG CON "); //agregado por Sapaza, fecha 19-09-2007, incidencia Sicc20070435
        
        consulta.append("WHERE ");
  			consulta.append("CAB.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append("AND CAB.NUM_LOTE_CONT IS NULL ");
        consulta.append("AND nvl(CAB.VAL_TOTA_PAGA_LOCA,0) >= 0 ");
        consulta.append("AND PSC.TICL_OID_TIPO_CLIE <> ? ");
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_TRANSPORTISTA); // 6
        consulta.append("AND CAB.TIDO_OID_TIPO_DOCU <> ? ");
        parametros.add(ConstantesFAC.OID_GUIA_REMISION); // 8
        consulta.append("AND LIN.DCCA_OID_CABE = CAB.OID_CABE ");
        consulta.append("AND CAB.PAIS_OID_PAIS = PAI.OID_PAIS ");
        consulta.append("AND CAB.SOCI_OID_SOCI = SOC.OID_SOCI ");
        consulta.append("AND LIN.PROD_OID_PROD = PRO.OID_PROD ");
        consulta.append("AND SOP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE ");
        consulta.append("AND LIN.SOPO_OID_SOLI_POSI = SOP.OID_SOLI_POSI ");
        consulta.append("AND SOP.OFDE_OID_DETA_OFER = DOF.OID_DETA_OFER (+) ");
        consulta.append("AND CAB.SBAC_OID_SBAC = SBAC.OID_SBAC ");
        consulta.append("AND CAB.PERD_OID_PERI = PERI.OID_PERI ");
        consulta.append("AND PERI.PERI_OID_PERI = PCOR.OID_PERI ");
        consulta.append("AND SBAC.ACCE_OID_ACCE = ACCE.OID_ACCE ");
        consulta.append("AND ACCE.CANA_OID_CANA = CANA.OID_CANA ");
        consulta.append("AND PCOR.TIPE_OID_TIPO_PERI = TPE.OID_TIPO_PERI ");
        consulta.append("AND PRO.MAPR_OID_MARC_PROD = MPRO.OID_MARC_PROD (+) ");
        consulta.append("AND PRO.NEGO_OID_NEGO = NEGO.OID_NEGO (+) ");
        consulta.append("AND DOF.TOFE_OID_TIPO_OFER = TOF.OID_TIPO_OFER (+) ");
        consulta.append("AND dof.CIVI_OID_CICLO_VIDA = CVI.OID_CICL_VIDA (+) ");                 
        consulta.append("AND cab.ZZON_OID_ZONA = ? " );                 
        parametros.add(zona);
        consulta.append("AND cab.ICTP_OID_TIPO_PROG  = CON.OID_TIPO_PROG(+)  " ); //agregado por Sapaza, fecha 19-09-2007, incidencia Sicc20070435                
        
        //<inicio>incidencia SiCC-20070233 (Sapaza), se agrega filtro fechaHasta
        if (fechaHasta != null){
            consulta.append("AND trunc(CAB.FEC_FACT) <= TO_DATE (?, 'YYYY-MM-DD') " );    
            parametros.add(sFechaHasta);
        }      
        //<fin>incidencia SiCC-20070233 (Sapaza)
   
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerDocumentosContables0: Exception",e);
            this.logSql(" obtenerDocumentosContables. SQL0: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug("Documentos Ventas Sin Transportista: " + rs);
        /*
         * con el RecordSet devuelto por la consulta se construyen objetos de tipo DTOINTDocumentoContable 
         * y se guardan en dtoDC.documentosVentasSinTransportista. En estos objetos hay que asignar 
         * valor nulo al atributo 'RUC'.
         */
        for(int d=0;d<rs.getRowCount();d++) {
            dto = new DTOINTDocumentoContable ();
            dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(d,"PAIS")).longValue()));
            dto.setCodigoPais(rs.getValueAt(d,"CODIGOPAIS").toString());
            dto.setFecha(new Timestamp(((Date)rs.getValueAt(d, "FECHA")).getTime()) );
            dto.setEmpresa(new Long(((BigDecimal)rs.getValueAt(d,"SOCIEDAD")).longValue()));
            dto.setCodigoEmpresa(rs.getValueAt(d,"CODIGOEMPRESA").toString());
            dto.setSubacceso(new Long(((BigDecimal)rs.getValueAt(d,"SUBACCESO")).longValue()));
            dto.setCodigoSubacceso(rs.getValueAt(d,"CODIGOSUBACCESO").toString());
            dto.setPeriodo(new Long(((BigDecimal)rs.getValueAt(d,"PERIODO")).longValue()));
            dto.setCodigoPeriodo(rs.getValueAt(d,"CODIGOPERIODO").toString());
            dto.setCodigoAcceso((String)rs.getValueAt(d, "CODIGOACCESO"));
            dto.setCodigoCanal((String)rs.getValueAt(d, "CODIGOCANAL"));
            //Incidencia BELC300013389
            dto.setRUC(null);
            dto.setProducto(new Long(((BigDecimal)rs.getValueAt(d,"PRODUCTO")).longValue()));
            if(rs.getValueAt(d,"MARCAPRODUCTO") != null){
                dto.setMarcaProducto(new Long(((BigDecimal)rs.getValueAt(d,"MARCAPRODUCTO")).longValue()));
            }
            if(rs.getValueAt(d,"NEGOCIO") != null){
                dto.setNegocio(new Long(((BigDecimal)rs.getValueAt(d,"NEGOCIO")).longValue()));
            }
            if(rs.getValueAt(d,"TIPOOFERTA") != null){
                dto.setTipoOferta(new Long(((BigDecimal)rs.getValueAt(d,"TIPOOFERTA")).longValue()));
            }
            if(rs.getValueAt(d,"CICLOVIDA") != null){
                dto.setCicloVida(new Long(((BigDecimal)rs.getValueAt(d,"CICLOVIDA")).longValue()));
            }
            if(rs.getValueAt(d,"IMPORTE01") != null){
                dto.setImporte01((BigDecimal)rs.getValueAt(d,"IMPORTE01"));
            }
            if(rs.getValueAt(d,"IMPORTE03") != null){
                dto.setImporte03((BigDecimal)rs.getValueAt(d,"IMPORTE03"));
            }
            
            // vbongiov -- Cambio 20090922 -- 28/05/2009
            if(rs.getValueAt(d,"IMPORTE04") != null){
                dto.setImporte04((BigDecimal)rs.getValueAt(d,"IMPORTE04"));
            }
            
            if(rs.getValueAt(d,"IMPORTE05") != null){
                dto.setImporte05((BigDecimal)rs.getValueAt(d,"IMPORTE05"));
            }else{
                dto.setImporte05(new BigDecimal(0));
            }
            /*
             * Si lin.VAL_PREC_CONT_TOTA_LOCA eq CONDICIONIMPORTE07 es <> 0
             * entonces importe07 es lin.VAL_PREC_SIN_IMPU_TOTA_LOCA eq IMPORTE01 
             */
            if(rs.getValueAt(d,"CONDICIONIMPORTE07") != null && rs.getValueAt(d,"IMPORTE01")!=null ){
                if(((BigDecimal)rs.getValueAt(d,"CONDICIONIMPORTE07")).equals(new BigDecimal(0))){
                    dto.setImporte07((BigDecimal)rs.getValueAt(d,"CONDICIONIMPORTE07"));
                }else{
                    dto.setImporte07((BigDecimal)rs.getValueAt(d,"IMPORTE01"));
                }
            }else{
                dto.setImporte07(new BigDecimal(0));
            }
            dto.setCodigoTipoPeriodo((String)rs.getValueAt(d, "CODIGOTIPOPERIODO"));
            dto.setCodigoMarcaProducto((String)rs.getValueAt(d, "CODIGOMARCAPRODUCTO"));
            // BELC300013913 
            if(rs.getValueAt(d, "GRUPOPRODUCTOS") != null){
                dto.setCodigoGrupoProductos((String)rs.getValueAt(d, "GRUPOPRODUCTOS"));
            } else {
                dto.setCodigoGrupoProductos("");
            }
            if (rs.getValueAt(d, "CODIGONEGOCIO") != null) {
               dto.setCodigoNegocio((String)rs.getValueAt(d, "CODIGONEGOCIO"));
            } else {
               dto.setCodigoNegocio("");
            }
            if (rs.getValueAt(d, "CODIGOTIPOOFERTA") != null) {
               dto.setCodigoTipoOferta((String)rs.getValueAt(d, "CODIGOTIPOOFERTA"));
            } else {
               dto.setCodigoTipoOferta("");
            }
            if (rs.getValueAt(d, "CODIGOCICLOVIDA") != null) {
              dto.setCodigoCicloVida((String)rs.getValueAt(d, "CODIGOCICLOVIDA"));
            } else {
              dto.setCodigoCicloVida(""); 
            }
            if(rs.getValueAt(d, "IMPORTE50") != null) {
                dto.setImporte50((BigDecimal)rs.getValueAt(d, "IMPORTE50"));
            }
            if(rs.getValueAt(d, "IMPORTE55") != null) {
                dto.setImporte55((BigDecimal)rs.getValueAt(d, "IMPORTE55"));
            }
            if(rs.getValueAt(d, "IMPORTE60") != null) {
                dto.setImporte60((BigDecimal)rs.getValueAt(d, "IMPORTE60"));
            }
            if(rs.getValueAt(d, "IMPORTE70") != null) {
                dto.setImporte70((BigDecimal)rs.getValueAt(d, "IMPORTE70"));
            }
            if(rs.getValueAt(d, "IMPORTE80") != null) {
                dto.setImporte80((BigDecimal)rs.getValueAt(d, "IMPORTE80"));
            }
            if(rs.getValueAt(d, "IMPORTE84") != null) {
                dto.setImporte84((BigDecimal)rs.getValueAt(d, "IMPORTE84"));
            }
            if(rs.getValueAt(d, "IMPORTE88") != null) {
                dto.setImporte88((BigDecimal)rs.getValueAt(d, "IMPORTE88"));
            }
            //cambio SAPFI-001  (SCS-07/05/08)
            if(rs.getValueAt(d, "IMPORTE90") != null) {
                dto.setImporte90((BigDecimal)rs.getValueAt(d, "IMPORTE90"));
            }
            dto.setCodigoProducto(rs.getValueAt(d,"CODIGOPRODUCTO").toString());
            // incidencia 18180
            dto.setEjercicioComercial(((BigDecimal)rs.getValueAt(d, "EJERCICIOCOMERCIAL")).toString());
            //--Se modifica por inc BELC300021244
            if(rs.getValueAt(d, "DESCRIPCIONCANAL") != null) {
                dto.setDescripcionCanal((String)rs.getValueAt(d, "DESCRIPCIONCANAL"));
            }  
            dto.setOidCabecera(new Long(((BigDecimal)rs.getValueAt(d,"OIDCABECERA")).longValue()));                
                      
            salida.add(dto);
        }
        listaAuxiliar = new ArrayList(salida);
        dtoDC.setDocumentosVentasSinTransportista(listaAuxiliar);
        salida.clear();

        /*
         * 2.- obtención de los documentos contables para abonos sin transportista:
         */
        consulta = new StringBuffer();
        parametros = new Vector();
        consulta.append("SELECT ");
        consulta.append("CAB.PAIS_OID_PAIS PAIS, ");
        consulta.append("PAI.COD_PAIS CODIGOPAIS, ");
        consulta.append("CAB.FEC_FACT FECHA, ");
        consulta.append("CAB.SOCI_OID_SOCI SOCIEDAD, ");
        consulta.append("SOC.COD_SOCI CODIGOEMPRESA, ");
        consulta.append("CANA.COD_CANA CODIGOCANAL, ");
        consulta.append("ACCE.COD_ACCE CODIGOACCESO, ");
        consulta.append("CAB.SBAC_OID_SBAC SUBACCESO, ");
        consulta.append("SBAC.COD_SBAC CODIGOSUBACCESO, ");
        consulta.append("TPE.COD_TIPO_PERI CODIGOTIPOPERIODO, ");
        consulta.append("PERI.PERI_OID_PERI PERIODO, ");
        consulta.append("PCOR.COD_PERI CODIGOPERIODO, ");
        consulta.append("PCOR.VAL_ANIO EJERCICIOCOMERCIAL, ");
        consulta.append("CAB.VAL_NUME_IDEN_FISC RUC, ");
        consulta.append("LIN.PROD_OID_PROD PRODUCTO, ");
        consulta.append("PRO.MAPR_OID_MARC_PROD MARCAPRODUCTO, ");
        consulta.append("MPRO.COD_MARC_PROD CODIGOMARCAPRODUCTO, ");
        consulta.append("PRO.VAL_GRUP_ARTI GRUPOPRODUCTOS, ");
        consulta.append("PRO.NEGO_OID_NEGO NEGOCIO, ");
        consulta.append("NEGO.COD_NEGO CODIGONEGOCIO, ");
        consulta.append("TOF.OID_TIPO_OFER TIPOOFERTA, ");
        consulta.append("TOF.COD_TIPO_OFER CODIGOTIPOOFERTA, ");
        consulta.append("dof.CIVI_OID_CICLO_VIDA ciclovida, ");
        consulta.append("CVI.COD_CICL_VIDA CODIGOCICLOVIDA, ");
        
        // vbongiov -- Cambio 20090922 -- 28/05/2009
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("     else (LIN.VAL_PREC_SIN_IMPU_TOTA_LOCA ");       
        consulta.append(" - DECODE ((SELECT  NVL(par.IND_IMPU_PROD_NACI,0) FROM  SEG_PARAM_INTER_PAIS par WHERE par.PAIS_OID_PAIS = " + pais);
        consulta.append(" ),1, NVL(LIN.IMP_IMPU_TOTA_PROD_NACI,0) ,0)) ");
        consulta.append(" end IMPORTE01, ");
        
        // vbongiov -- Cambio 20090905 -- 10/06/2009
        consulta.append(" DECODE ((SELECT  NVL(par.IND_IMPU_PROD_GRAT,0) FROM  SEG_PARAM_INTER_PAIS par WHERE par.PAIS_OID_PAIS = " + pais);
        consulta.append(" ),1, (LIN.IMP_IMPU_TOTA_LOCA * DECODE(LiN.VAL_PREC_CATA_UNIT_LOCA, 0, 1,0)),LIN.IMP_IMPU_TOTA_LOCA) IMPORTE03, ");       
        
        // vbongiov -- Cambio 20090922 -- 28/05/2009
        consulta.append(" DECODE ((SELECT  NVL(par.IND_IMPU_PROD_NACI,0) FROM  SEG_PARAM_INTER_PAIS par WHERE par.PAIS_OID_PAIS = " + pais);
        consulta.append(" ),1, NVL(LIN.IMP_IMPU_TOTA_PROD_NACI,0) ,0) IMPORTE04, ");
        
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else lin.IMP_DESC_SIN_IMPU_TOTA_LOCA end IMPORTE05, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('C','R') then 0 ");
        consulta.append("    else lin.val_prec_cont_tota_loca end CONDICIONIMPORTE07, ");

        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.VAL_TOTA_PAGA_LOCA end IMPORTE50, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_REDO_LOCA end IMPORTE55, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_IMPU_TOTA_LOCA end IMPORTE60, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_FLET_IMPU_TOTA_LOCA end IMPORTE70, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_DES1_SIN_IMPU_TOTA end IMPORTE80, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.VAL_PREC_CONT_SIN_IMPU_TOTA end IMPORTE84, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_DES3_SIN_IMPU_TOTA end IMPORTE88, ");
        //cambio SAPFI-001  (SCS-07/05/08)
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.VAL_IMPO_IVA_ASUM_EMPR end IMPORTE90, ");        

        consulta.append("PRO.COD_SAP CODIGOPRODUCTO, ");
        consulta.append("   (SELECT idio.val_i18n  ");
        consulta.append("   FROM v_gen_i18n_sicc idio    ");
        consulta.append("   WHERE idio.attr_enti = 'SEG_CANAL'    ");
        consulta.append("   AND idio.idio_oid_idio = ?    ");
        parametros.add(idiomaPorDefecto);  
        consulta.append("   AND idio.val_oid = cana.OID_CANA ) AS DESCRIPCIONCANAL, ");              
        consulta.append("  cab.OID_CABE OIDCABECERA, ");
        consulta.append("  lin.OID OIDLINEA ");

        consulta.append("FROM ");
        consulta.append("FAC_DOCUM_CONTA_CABEC CAB, ");
        consulta.append("FAC_DOCUM_CONTA_LINEA LIN, ");
        consulta.append("SEG_PAIS PAI, ");
        consulta.append("SEG_SOCIE SOC, ");
        consulta.append("MAE_PRODU PRO, ");
        consulta.append("PED_SOLIC_CABEC PSC, ");
        consulta.append("PED_SOLIC_POSIC SOP, ");
        consulta.append("PRE_OFERT_DETAL DOF, ");
        consulta.append("SEG_SUBAC SBAC, ");
        consulta.append("SEG_ACCES ACCE, ");
        consulta.append("SEG_CANAL CANA, ");
        consulta.append("CRA_PERIO PERI, ");
        consulta.append("SEG_PERIO_CORPO PCOR, ");
        consulta.append("SEG_TIPO_PERIO TPE, ");
        consulta.append("SEG_MARCA_PRODU MPRO, ");
        consulta.append("MAE_NEGOC NEGO, ");
        consulta.append("PRE_TIPO_OFERT TOF, ");
        consulta.append("PRE_CICLO_VIDA CVI, ");
        consulta.append("PED_SOLIC_CABEC SOCA, ");
        consulta.append("INC_CONCU_TIPO_PROG CON "); //agregado por Sapaza, fecha 19-09-2007, incidencia Sicc20070435

        consulta.append("WHERE ");
        consulta.append("CAB.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append("AND SOCA.IND_TS_NO_CONSO = 0 ");
        consulta.append("AND CAB.NUM_LOTE_CONT IS NULL ");
        consulta.append("AND nvl(CAB.VAL_TOTA_PAGA_LOCA,0) < 0 ");
        consulta.append("AND PSC.TICL_OID_TIPO_CLIE <> ? ");
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_TRANSPORTISTA); // 6
        consulta.append("AND CAB.TIDO_OID_TIPO_DOCU <> ? ");
        parametros.add(ConstantesFAC.OID_GUIA_REMISION); // 8
        consulta.append("AND LIN.DCCA_OID_CABE = CAB.OID_CABE ");
        consulta.append("AND CAB.PAIS_OID_PAIS = PAI.OID_PAIS ");           
        consulta.append("AND CAB.SOCI_OID_SOCI = SOC.OID_SOCI ");
        consulta.append("AND LIN.PROD_OID_PROD = PRO.OID_PROD ");
        consulta.append("AND SOP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE ");
        consulta.append("AND LIN.SOPO_OID_SOLI_POSI = SOP.OID_SOLI_POSI ");
        consulta.append("AND SOP.OFDE_OID_DETA_OFER = DOF.OID_DETA_OFER (+) ");
        consulta.append("AND CAB.SBAC_OID_SBAC = SBAC.OID_SBAC ");
        consulta.append("AND CAB.PERD_OID_PERI = PERI.OID_PERI ");
        consulta.append("AND PERI.PERI_OID_PERI = PCOR.OID_PERI ");
        consulta.append("AND SBAC.ACCE_OID_ACCE = ACCE.OID_ACCE ");
        consulta.append("AND ACCE.CANA_OID_CANA = CANA.OID_CANA ");
        consulta.append("AND PCOR.TIPE_OID_TIPO_PERI = TPE.OID_TIPO_PERI ");
        consulta.append("AND PRO.MAPR_OID_MARC_PROD = MPRO.OID_MARC_PROD ");
        consulta.append("AND PRO.NEGO_OID_NEGO = NEGO.OID_NEGO (+) ");
        consulta.append("AND DOF.TOFE_OID_TIPO_OFER = TOF.OID_TIPO_OFER (+) ");
        consulta.append("AND dof.CIVI_OID_CICLO_VIDA  = CVI.OID_CICL_VIDA (+) ");
        consulta.append("AND CAB.SOCA_OID_SOLI_CABE = SOCA.OID_SOLI_CABE ");			                 
        consulta.append("AND cab.ZZON_OID_ZONA = ? " );                 
        parametros.add(zona);
        consulta.append("AND cab.ICTP_OID_TIPO_PROG  = CON.OID_TIPO_PROG(+)  " ); //agregado por Sapaza, fecha 19-09-2007, incidencia Sicc20070435                        

        //<inicio>incidencia SiCC-20070233 (Sapaza), se agrega filtro fechaHasta
        if (fechaHasta != null){
            consulta.append("AND trunc(CAB.FEC_FACT) <= TO_DATE (?, 'YYYY-MM-DD') " );    
            parametros.add(sFechaHasta);
        }      
        //<fin>incidencia SiCC-20070233 (Sapaza)
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerDocumentosContables0: Exception",e);
            this.logSql(" obtenerDocumentosContables. SQL1: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug("Documentos Abonos Sin Transportista: " + rs);
        
        /*
         * con los registros obtenidos, se construyen objetos de tipo DTOINTDocumentoContable 
         * y se guardan en dtoDC.documentosAbonosSinTransportista. 
         * En estos objetos hay que asignar valor nulo al atributo 'codigoCliente'.
         */     
        // Por incidencia BELC300013389 'codigoCliente' es 'RUC'
        for(int d=0;d<rs.getRowCount();d++) {
            dto = new DTOINTDocumentoContable();
            dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(d,"PAIS")).longValue()));
            dto.setCodigoPais(rs.getValueAt(d,"CODIGOPAIS").toString());
            dto.setFecha(new Timestamp(((Date)rs.getValueAt(d, "FECHA")).getTime()) );
            dto.setEmpresa(new Long(((BigDecimal)rs.getValueAt(d,"SOCIEDAD")).longValue()));
            dto.setCodigoEmpresa(rs.getValueAt(d,"CODIGOEMPRESA").toString());
            dto.setSubacceso(new Long(((BigDecimal)rs.getValueAt(d,"SUBACCESO")).longValue()));
            dto.setCodigoSubacceso(rs.getValueAt(d,"CODIGOSUBACCESO").toString());
            dto.setPeriodo(new Long(((BigDecimal)rs.getValueAt(d,"PERIODO")).longValue()));
            dto.setCodigoPeriodo(rs.getValueAt(d,"CODIGOPERIODO").toString());
            dto.setCodigoAcceso((String)rs.getValueAt(d, "CODIGOACCESO"));
            dto.setCodigoCanal((String)rs.getValueAt(d, "CODIGOCANAL"));
            //Incidencia BELC300013389
            dto.setRUC(null);
            dto.setProducto(new Long(((BigDecimal)rs.getValueAt(d,"PRODUCTO")).longValue()));
            if(rs.getValueAt(d,"MARCAPRODUCTO") != null){
                dto.setMarcaProducto(new Long(((BigDecimal)rs.getValueAt(d,"MARCAPRODUCTO")).longValue()));
            }
            if(rs.getValueAt(d,"NEGOCIO") != null){
                dto.setNegocio(new Long(((BigDecimal)rs.getValueAt(d,"NEGOCIO")).longValue()));
            }
            if(rs.getValueAt(d,"TIPOOFERTA") != null){
                dto.setTipoOferta(new Long(((BigDecimal)rs.getValueAt(d,"TIPOOFERTA")).longValue()));
            }
            if(rs.getValueAt(d,"CICLOVIDA") != null){
                dto.setCicloVida(new Long(((BigDecimal)rs.getValueAt(d,"CICLOVIDA")).longValue()));
            }
            if(rs.getValueAt(d,"IMPORTE01") != null){
                dto.setImporte01((BigDecimal)rs.getValueAt(d,"IMPORTE01"));
            }
            if(rs.getValueAt(d,"IMPORTE03") != null){
                dto.setImporte03((BigDecimal)rs.getValueAt(d,"IMPORTE03"));
            }
            
            // vbongiov -- Cambio 20090922 -- 28/05/2009
            if(rs.getValueAt(d,"IMPORTE04") != null){
                dto.setImporte04((BigDecimal)rs.getValueAt(d,"IMPORTE04"));
            }            
            
            if(rs.getValueAt(d,"IMPORTE05") != null){
                dto.setImporte05((BigDecimal)rs.getValueAt(d,"IMPORTE05"));
            }else{
                dto.setImporte05(new BigDecimal(0));
            }
            /*
             * Si lin.VAL_PREC_CONT_TOTA_LOCA eq CONDICIONIMPORTE07 es <> 0
             * entonces importe07 es lin.VAL_PREC_SIN_IMPU_TOTA_LOCA eq IMPORTE01 
             */
            if(rs.getValueAt(d,"CONDICIONIMPORTE07") != null && rs.getValueAt(d,"IMPORTE01")!=null ){
                if(((BigDecimal)rs.getValueAt(d,"CONDICIONIMPORTE07")).equals(new BigDecimal(0))){
                    dto.setImporte07((BigDecimal)rs.getValueAt(d,"CONDICIONIMPORTE07"));
                }else{
                    dto.setImporte07((BigDecimal)rs.getValueAt(d,"IMPORTE01"));
                }
            }else{
                dto.setImporte07(new BigDecimal(0));
            }
            dto.setCodigoTipoPeriodo((String)rs.getValueAt(d, "CODIGOTIPOPERIODO"));
            dto.setCodigoMarcaProducto((String)rs.getValueAt(d, "CODIGOMARCAPRODUCTO"));
            // BELC300013913 
            if(rs.getValueAt(d, "GRUPOPRODUCTOS") != null){
                dto.setCodigoGrupoProductos((String)rs.getValueAt(d, "GRUPOPRODUCTOS"));
            } else {
                dto.setCodigoGrupoProductos("");
            }
            if (rs.getValueAt(d, "CODIGONEGOCIO") != null) {
               dto.setCodigoNegocio((String)rs.getValueAt(d, "CODIGONEGOCIO"));
            } else {
               dto.setCodigoNegocio("");
            }
            if (rs.getValueAt(d, "CODIGOTIPOOFERTA") != null) {
               dto.setCodigoTipoOferta((String)rs.getValueAt(d, "CODIGOTIPOOFERTA"));
            } else {
               dto.setCodigoTipoOferta("");
            }
            if (rs.getValueAt(d, "CODIGOCICLOVIDA") != null) {
              dto.setCodigoCicloVida((String)rs.getValueAt(d, "CODIGOCICLOVIDA"));
            } else {
              dto.setCodigoCicloVida(""); 
            }
            if(rs.getValueAt(d, "IMPORTE50") != null) {
                dto.setImporte50((BigDecimal)rs.getValueAt(d, "IMPORTE50"));
            }
            if(rs.getValueAt(d, "IMPORTE55") != null) {
                dto.setImporte55((BigDecimal)rs.getValueAt(d, "IMPORTE55"));
            }
            if(rs.getValueAt(d, "IMPORTE60") != null) {
                dto.setImporte60((BigDecimal)rs.getValueAt(d, "IMPORTE60"));
            }
            if(rs.getValueAt(d, "IMPORTE70") != null) {
                dto.setImporte70((BigDecimal)rs.getValueAt(d, "IMPORTE70"));
            }
            if(rs.getValueAt(d, "IMPORTE80") != null) {
                dto.setImporte80((BigDecimal)rs.getValueAt(d, "IMPORTE80"));
            }
            if(rs.getValueAt(d, "IMPORTE84") != null) {
                dto.setImporte84((BigDecimal)rs.getValueAt(d, "IMPORTE84"));
            }
            if(rs.getValueAt(d, "IMPORTE88") != null) {
                dto.setImporte88((BigDecimal)rs.getValueAt(d, "IMPORTE88"));
            }
            //cambio SAPFI-001  (SCS-07/05/08)
            if(rs.getValueAt(d, "IMPORTE90") != null) {
                dto.setImporte90((BigDecimal)rs.getValueAt(d, "IMPORTE90"));
            }
            dto.setCodigoProducto(rs.getValueAt(d,"CODIGOPRODUCTO").toString());
            // incidencia 18180
            dto.setEjercicioComercial(((BigDecimal)rs.getValueAt(d, "EJERCICIOCOMERCIAL")).toString());
            //--Se modifica por inc BELC300021244
            if(rs.getValueAt(d, "DESCRIPCIONCANAL") != null) {
                dto.setDescripcionCanal((String)rs.getValueAt(d, "DESCRIPCIONCANAL"));
            }  
            dto.setOidCabecera(new Long(((BigDecimal)rs.getValueAt(d,"OIDCABECERA")).longValue()));                

            salida.add(dto);
        }
            
        listaAuxiliar = new ArrayList(salida);
        dtoDC.setDocumentosAbonosSinTransportista(listaAuxiliar);
        salida.clear();        

        /*
         * 3.- obtención de los documentos contables para transportistas:
         */
        consulta = new StringBuffer();
        parametros = new Vector();
        
        consulta.append("SELECT ");
        consulta.append("CAB.PAIS_OID_PAIS PAIS, ");
        consulta.append("PAI.COD_PAIS CODIGOPAIS, ");
        consulta.append("CAB.FEC_FACT FECHA, ");
        consulta.append("CAB.SOCI_OID_SOCI SOCIEDAD, ");
        consulta.append("SOC.COD_SOCI CODIGOEMPRESA, ");
        consulta.append("CANA.COD_CANA CODIGOCANAL, ");
        consulta.append("ACCE.COD_ACCE CODIGOACCESO, ");
        consulta.append("CAB.SBAC_OID_SBAC SUBACCESO, ");
        consulta.append("SBAC.COD_SBAC CODIGOSUBACCESO, ");
        consulta.append("TPE.COD_TIPO_PERI CODIGOTIPOPERIODO, ");
        consulta.append("PERI.PERI_OID_PERI PERIODO, ");
        consulta.append("PCOR.COD_PERI CODIGOPERIODO, ");
        consulta.append("PCOR.VAL_ANIO EJERCICIOCOMERCIAL, ");
        consulta.append("CAB.VAL_NUME_IDEN_FISC RUC, ");
        consulta.append("LIN.PROD_OID_PROD PRODUCTO, ");
        consulta.append("PRO.MAPR_OID_MARC_PROD MARCAPRODUCTO, ");
        consulta.append("MPRO.COD_MARC_PROD CODIGOMARCAPRODUCTO, ");
        consulta.append("PRO.VAL_GRUP_ARTI GRUPOPRODUCTOS, ");
        consulta.append("PRO.NEGO_OID_NEGO NEGOCIO, ");
        consulta.append("NEGO.COD_NEGO CODIGONEGOCIO, ");
        consulta.append("TOF.OID_TIPO_OFER TIPOOFERTA, ");
        consulta.append("TOF.COD_TIPO_OFER CODIGOTIPOOFERTA, ");
        consulta.append("dof.CIVI_OID_CICLO_VIDA ciclovida, ");
        consulta.append("CVI.COD_CICL_VIDA CODIGOCICLOVIDA, ");

        // vbongiov -- Cambio 20090922 -- 28/05/2009
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("     else (LIN.VAL_PREC_SIN_IMPU_TOTA_LOCA ");       
        consulta.append(" - DECODE ((SELECT  NVL(par.IND_IMPU_PROD_NACI,0) FROM  SEG_PARAM_INTER_PAIS par WHERE par.PAIS_OID_PAIS = " + pais);
        consulta.append(" ),1, NVL(LIN.IMP_IMPU_TOTA_PROD_NACI,0) ,0)) ");
        consulta.append(" end IMPORTE01, ");        
        
        // vbongiov -- Cambio 20090905 -- 10/06/2009
        consulta.append(" DECODE ((SELECT  NVL(par.IND_IMPU_PROD_GRAT,0) FROM  SEG_PARAM_INTER_PAIS par WHERE par.PAIS_OID_PAIS = " + pais);
        consulta.append(" ),1, (LIN.IMP_IMPU_TOTA_LOCA * DECODE(LiN.VAL_PREC_CATA_UNIT_LOCA, 0, 1,0)),LIN.IMP_IMPU_TOTA_LOCA) IMPORTE03, ");       
        
        // vbongiov -- Cambio 20090922 -- 28/05/2009
        consulta.append(" DECODE ((SELECT  NVL(par.IND_IMPU_PROD_NACI,0) FROM  SEG_PARAM_INTER_PAIS par WHERE par.PAIS_OID_PAIS = " + pais);
        consulta.append(" ),1, NVL(LIN.IMP_IMPU_TOTA_PROD_NACI,0) ,0) IMPORTE04, ");
        
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else lin.IMP_DESC_SIN_IMPU_TOTA_LOCA end IMPORTE05, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('C','R') then 0 ");
        consulta.append("    else lin.val_prec_cont_tota_loca end CONDICIONIMPORTE07, ");
        
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.VAL_TOTA_PAGA_LOCA end IMPORTE50, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_REDO_LOCA end IMPORTE55, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_IMPU_TOTA_LOCA end IMPORTE60, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_FLET_IMPU_TOTA_LOCA end IMPORTE70, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_DES1_SIN_IMPU_TOTA end IMPORTE80, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.VAL_PREC_CONT_SIN_IMPU_TOTA end IMPORTE84, ");
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.IMP_DES3_SIN_IMPU_TOTA end IMPORTE88, ");
        //cambio SAPFI-001  (SCS-07/05/08)
        consulta.append("case when CON.COD_TIPO_PROG in ('B','C','R') then 0 ");
        consulta.append("    else CAB.VAL_IMPO_IVA_ASUM_EMPR end IMPORTE90, ");

        consulta.append("PRO.COD_SAP CODIGOPRODUCTO, ");
        consulta.append("   (SELECT idio.val_i18n  ");
        consulta.append("   FROM v_gen_i18n_sicc idio    ");
        consulta.append("   WHERE idio.attr_enti = 'SEG_CANAL'    ");
        consulta.append("   AND idio.idio_oid_idio = ?    ");
        parametros.add(idiomaPorDefecto);  
        consulta.append("   AND idio.val_oid = cana.OID_CANA ) AS DESCRIPCIONCANAL, ");              
        consulta.append("  cab.OID_CABE OIDCABECERA, ");
        consulta.append(" CLI.COD_CLIE CODIGOCLIENTE, ");      
        consulta.append("  lin.OID OIDLINEA ");
        
        consulta.append("FROM ");
        consulta.append("FAC_DOCUM_CONTA_CABEC CAB, ");
        consulta.append("FAC_DOCUM_CONTA_LINEA LIN, ");
        consulta.append("SEG_PAIS PAI, ");
        consulta.append("SEG_SOCIE SOC, ");
        consulta.append("MAE_PRODU PRO, ");
        consulta.append("MAE_CLIEN CLI, ");        
        consulta.append("PED_SOLIC_CABEC PSC, ");
        consulta.append("PED_SOLIC_POSIC SOP, ");
        consulta.append("PRE_OFERT_DETAL DOF, ");
        consulta.append("SEG_SUBAC SBAC, ");
        consulta.append("SEG_ACCES ACCE, ");
        consulta.append("SEG_CANAL CANA, ");
        consulta.append("CRA_PERIO PERI, ");
        consulta.append("SEG_PERIO_CORPO PCOR, ");
        consulta.append("SEG_TIPO_PERIO TPE, ");
        consulta.append("SEG_MARCA_PRODU MPRO, ");
        consulta.append("MAE_NEGOC NEGO, ");
        consulta.append("PRE_TIPO_OFERT TOF, ");
        consulta.append("PRE_CICLO_VIDA CVI, ");
        consulta.append("INC_CONCU_TIPO_PROG CON "); //agregado por Sapaza, fecha 19-09-2007, incidencia Sicc20070435

        consulta.append("WHERE ");
        consulta.append("CAB.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append("AND CAB.NUM_LOTE_CONT IS NULL ");
        consulta.append("AND PSC.TICL_OID_TIPO_CLIE = ? ");
        parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_TRANSPORTISTA); // 6
        consulta.append("AND CAB.TIDO_OID_TIPO_DOCU <> ? ");
        parametros.add(ConstantesFAC.OID_GUIA_REMISION); // 8
        consulta.append("AND LIN.DCCA_OID_CABE = CAB.OID_CABE ");
        consulta.append("AND CAB.PAIS_OID_PAIS = PAI.OID_PAIS ");
        consulta.append("AND CAB.SOCI_OID_SOCI = SOC.OID_SOCI ");
        consulta.append("AND LIN.PROD_OID_PROD = PRO.OID_PROD ");
        consulta.append("AND PSC.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append("AND SOP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE ");
        consulta.append("AND LIN.SOPO_OID_SOLI_POSI = SOP.OID_SOLI_POSI ");
        consulta.append("AND SOP.OFDE_OID_DETA_OFER = DOF.OID_DETA_OFER (+) "); 
        consulta.append("AND CAB.SBAC_OID_SBAC = SBAC.OID_SBAC ");
        consulta.append("AND CAB.PERD_OID_PERI = PERI.OID_PERI ");
        consulta.append("AND PERI.PERI_OID_PERI = PCOR.OID_PERI ");
        consulta.append("AND SBAC.ACCE_OID_ACCE = ACCE.OID_ACCE ");
        consulta.append("AND ACCE.CANA_OID_CANA = CANA.OID_CANA ");
        consulta.append("AND PCOR.TIPE_OID_TIPO_PERI = TPE.OID_TIPO_PERI ");
        consulta.append("AND PRO.MAPR_OID_MARC_PROD = MPRO.OID_MARC_PROD (+) ");
        consulta.append("AND PRO.NEGO_OID_NEGO = NEGO.OID_NEGO (+) ");
        consulta.append("AND DOF.TOFE_OID_TIPO_OFER = TOF.OID_TIPO_OFER (+) ");
        consulta.append("AND dof.CIVI_OID_CICLO_VIDA = CVI.OID_CICL_VIDA (+)");                 
        consulta.append("AND cab.ZZON_OID_ZONA = ? ");                 
        parametros.add(zona);
        consulta.append("AND cab.ICTP_OID_TIPO_PROG  = CON.OID_TIPO_PROG(+)  " ); //agregado por Sapaza, fecha 19-09-2007, incidencia Sicc20070435                

        //<inicio>incidencia SiCC-20070233 (Sapaza), se agrega filtro fechaHasta
        if (fechaHasta != null){
            consulta.append("AND trunc(CAB.FEC_FACT) <= TO_DATE (?, 'YYYY-MM-DD') " );    
            parametros.add(sFechaHasta);
        }      
        //<fin>incidencia SiCC-20070233 (Sapaza)
        
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerDocumentosContables0: Exception",e);
            this.logSql(" obtenerDocumentosContables. SQL2: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("Documentos Transportista: " + rs);
        
        /*
         * con el RecordSet devuelto por la consulta se construyen objetos de tipo DTOINTDocumentoContable 
         * y se guardan en dtoDC.documentosVentasSinTransportista. En estos objetos hay que asignar 
         * valor nulo al atributo 'RUC'.        
         */
        for(int d=0;d<rs.getRowCount();d++){
            dto = new DTOINTDocumentoContable ();
            dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(d,"PAIS")).longValue()));
            dto.setCodigoPais(rs.getValueAt(d,"CODIGOPAIS").toString());
            dto.setFecha(new Timestamp(((Date)rs.getValueAt(d, "FECHA")).getTime()) );
            dto.setEmpresa(new Long(((BigDecimal)rs.getValueAt(d,"SOCIEDAD")).longValue()));
            dto.setCodigoEmpresa(rs.getValueAt(d,"CODIGOEMPRESA").toString());
            dto.setSubacceso(new Long(((BigDecimal)rs.getValueAt(d,"SUBACCESO")).longValue()));
            dto.setCodigoSubacceso(rs.getValueAt(d,"CODIGOSUBACCESO").toString());
            dto.setPeriodo(new Long(((BigDecimal)rs.getValueAt(d,"PERIODO")).longValue()));
            dto.setCodigoPeriodo(rs.getValueAt(d,"CODIGOPERIODO").toString());
            dto.setCodigoAcceso((String)rs.getValueAt(d, "CODIGOACCESO"));
            dto.setCodigoCanal((String)rs.getValueAt(d, "CODIGOCANAL"));
            //Incidencia BELC300013389
            dto.setRUC((String)rs.getValueAt(d, "RUC"));
            dto.setProducto(new Long(((BigDecimal)rs.getValueAt(d,"PRODUCTO")).longValue()));
            if(rs.getValueAt(d,"MARCAPRODUCTO") != null){
                dto.setMarcaProducto(new Long(((BigDecimal)rs.getValueAt(d,"MARCAPRODUCTO")).longValue()));
            }
            if(rs.getValueAt(d,"NEGOCIO") != null){
                dto.setNegocio(new Long(((BigDecimal)rs.getValueAt(d,"NEGOCIO")).longValue()));
            }
            if(rs.getValueAt(d,"TIPOOFERTA") != null){
                dto.setTipoOferta(new Long(((BigDecimal)rs.getValueAt(d,"TIPOOFERTA")).longValue()));
            }
            if(rs.getValueAt(d,"CICLOVIDA") != null){
                dto.setCicloVida(new Long(((BigDecimal)rs.getValueAt(d,"CICLOVIDA")).longValue()));
            }
            if(rs.getValueAt(d,"IMPORTE01") != null){
                dto.setImporte01((BigDecimal)rs.getValueAt(d,"IMPORTE01"));
            }
            if(rs.getValueAt(d,"IMPORTE03") != null){
                dto.setImporte03((BigDecimal)rs.getValueAt(d,"IMPORTE03"));
            }
            
            // vbongiov -- Cambio 20090922 -- 28/05/2009
            if(rs.getValueAt(d,"IMPORTE04") != null){
                dto.setImporte04((BigDecimal)rs.getValueAt(d,"IMPORTE04"));
            }
            
            if(rs.getValueAt(d,"IMPORTE05") != null){
                dto.setImporte05((BigDecimal)rs.getValueAt(d,"IMPORTE05"));
            }else{
                dto.setImporte05(new BigDecimal(0));
            }
            /*
             * Si lin.VAL_PREC_CONT_TOTA_LOCA eq CONDICIONIMPORTE07 es <> 0
             * entonces importe07 es lin.VAL_PREC_SIN_IMPU_TOTA_LOCA eq IMPORTE01 
             */
            if(rs.getValueAt(d,"CONDICIONIMPORTE07") != null && rs.getValueAt(d,"IMPORTE01")!=null ){
                if(((BigDecimal)rs.getValueAt(d,"CONDICIONIMPORTE07")).equals(new BigDecimal(0))){
                    dto.setImporte07((BigDecimal)rs.getValueAt(d,"CONDICIONIMPORTE07"));
                }else{
                    dto.setImporte07((BigDecimal)rs.getValueAt(d,"IMPORTE01"));
                }
            }else{
                dto.setImporte07(new BigDecimal(0));
            }
            dto.setCodigoTipoPeriodo((String)rs.getValueAt(d, "CODIGOTIPOPERIODO"));
            dto.setCodigoMarcaProducto((String)rs.getValueAt(d, "CODIGOMARCAPRODUCTO"));
            // BELC300013913 
            if(rs.getValueAt(d, "GRUPOPRODUCTOS") != null){
                dto.setCodigoGrupoProductos((String)rs.getValueAt(d, "GRUPOPRODUCTOS"));
            } else {
                dto.setCodigoGrupoProductos("");
            }                
            if (rs.getValueAt(d, "CODIGONEGOCIO") != null) {
               dto.setCodigoNegocio((String)rs.getValueAt(d, "CODIGONEGOCIO"));
            } else {
               dto.setCodigoNegocio("");
            }
            if (rs.getValueAt(d, "CODIGOTIPOOFERTA") != null) {
               dto.setCodigoTipoOferta((String)rs.getValueAt(d, "CODIGOTIPOOFERTA"));
            } else {
               dto.setCodigoTipoOferta("");
            }
            if (rs.getValueAt(d, "CODIGOCICLOVIDA") != null) {
              dto.setCodigoCicloVida((String)rs.getValueAt(d, "CODIGOCICLOVIDA"));
            } else {
              dto.setCodigoCicloVida(""); 
            }
            if(rs.getValueAt(d, "IMPORTE50") != null) {
                dto.setImporte50((BigDecimal)rs.getValueAt(d, "IMPORTE50"));
            }
            if(rs.getValueAt(d, "IMPORTE55") != null) {
                dto.setImporte55((BigDecimal)rs.getValueAt(d, "IMPORTE55"));
            }
            if(rs.getValueAt(d, "IMPORTE60") != null) {
                dto.setImporte60((BigDecimal)rs.getValueAt(d, "IMPORTE60"));
            }
            if(rs.getValueAt(d, "IMPORTE70") != null) {
                dto.setImporte70((BigDecimal)rs.getValueAt(d, "IMPORTE70"));
            }
            if(rs.getValueAt(d, "IMPORTE80") != null) {
                dto.setImporte80((BigDecimal)rs.getValueAt(d, "IMPORTE80"));
            }
            if(rs.getValueAt(d, "IMPORTE84") != null) {
                dto.setImporte84((BigDecimal)rs.getValueAt(d, "IMPORTE84"));
            }
            if(rs.getValueAt(d, "IMPORTE88") != null) {
                dto.setImporte88((BigDecimal)rs.getValueAt(d, "IMPORTE88"));
            }
            //cambio SAPFI-001  (SCS-07/05/08)
            if(rs.getValueAt(d, "IMPORTE90") != null) {
                dto.setImporte90((BigDecimal)rs.getValueAt(d, "IMPORTE90"));
            }
            dto.setCodigoProducto(rs.getValueAt(d,"CODIGOPRODUCTO").toString());
            // incidencia 18180
            dto.setEjercicioComercial(((BigDecimal)rs.getValueAt(d, "EJERCICIOCOMERCIAL")).toString());
            if(rs.getValueAt(d, "CODIGOCLIENTE") !=null){
                dto.setCodigoCliente((String)rs.getValueAt(d, "CODIGOCLIENTE"));
            }
            if(rs.getValueAt(d, "DESCRIPCIONCANAL") != null) {
                dto.setDescripcionCanal((String)rs.getValueAt(d, "DESCRIPCIONCANAL"));
            }  
            dto.setOidCabecera(new Long(((BigDecimal)rs.getValueAt(d,"OIDCABECERA")).longValue()));                
            salida.add(dto);
        }
            
        listaAuxiliar = new ArrayList(salida);
        dtoDC.setDocumentosTransportistas(listaAuxiliar);
        salida.clear();
        
        UtilidadesLog.info("DAOINT.obtenerDocumentosContables(Long pais): Salida");
        return dtoDC;
    }


    /*
     * 
     */
    private void logSql(String metodo, String sql, Vector params){
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			//UtilidadesLog.debug(metodo + sParams);
         UtilidadesLog.warn(metodo + sParams);
		}
	}
    private  String convertirArrayToString(ArrayList array) throws MareException {
        UtilidadesLog.info("DAOINT.convertirArrayToString(ArrayList array): Entrada");
		String retorno = "";
        if((array!=null)&&(array.size()!=0)){
			
        	StringBuffer sentencia = new StringBuffer("");
			for(int i=0;i<array.size();i++){
            		UtilidadesLog.debug("\n -  array[ ]=" + array.get(i));
            		if(array.get(i)!=null){
            		      	sentencia.append(" ?, ");
                	}
           	}
            	//Quitamos la coma y el espacio del final
            	retorno= sentencia.substring(0,sentencia.length()-2);
				UtilidadesLog.debug(retorno);
         
        }else{
            UtilidadesLog.info("DAOINT.convertirArrayToString(ArrayList array): Salida");
			return "";
			}
			
        UtilidadesLog.info("DAOINT.convertirArrayToString(ArrayList array): Salida");
		return retorno;
	}
      
   /**
    *  Se actualiza los registros de la entidad Movimientos Bancarios, 
    *  los registros de la entidad Movimientos en Cuenta Corriente,
    *  los registros de cabecera de cargos y abonos directos, 
    *  asignándoos numero de lote de contabilización y fecha de contabilización.
    *  @mejora incidencia 20070233 se agrega filtro fechaHasta, se cambia el orden de los updates.
    *  @autor gdmarzi
    */
   public void actualizarRegistros(String numeroLoteContabilizacion, Date fechaContabilizacion, Long pais, Date fechaHasta) throws MareException {
      UtilidadesLog.info("DAOINT.actualizarRegistros(ArrayList listaOidCabecera, String numeroLoteContabilizacion,  Date fechaContabilizacion): Entrada");
      StringBuffer consulta = new StringBuffer(); 
      Vector parametros = new Vector();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

      /*
       * Se actualizan los registros de la entidad Movimientos Bancarios, 
       * siempre que tengan numero lote de contabilización y fecha de 
       * contabilización a nulo, y el campo Identificador de Proceso = "P"
       */
      consulta.append("UPDATE CCC_MOVIM_BANCA MB ");
      consulta.append("SET ");
      consulta.append("   MB.VAL_NUME_LOTE_CONT = ?, ");
      parametros.add(numeroLoteContabilizacion);
      consulta.append("   MB.FEC_CONT = TO_DATE(?, 'YYYY-MM-DD') ");
      parametros.add(sdf.format(fechaContabilizacion));
      consulta.append("WHERE MB.COD_IDEN_PROC = ? ");
      parametros.add(CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO);
      consulta.append("  AND MB.OID_MOVI_BANC IN ( ");
      consulta.append("      SELECT MOV.OID_MOVI_BANC ");
      consulta.append("      FROM CCC_MOVIM_BANCA MOV, ");
      consulta.append("         CCC_CABEC_CARGA_ABONO_DIREC CAB, ");
      consulta.append("         CCC_DETAL_CARGO_ABONO_DIREC DET ");
      consulta.append("      WHERE MOV.VAL_NUME_LOTE_CONT IS NULL ");
      consulta.append("      AND MOV.FEC_CONT IS NULL ");

      consulta.append("      AND CAB.OID_CABE_CARG = DET.CCAD_OID_CABE_CARG ");
      consulta.append("      AND DET.CMBA_OID_MOVI_BANC = MOV.OID_MOVI_BANC ");
      consulta.append("      AND CAB.PAIS_OID_PAIS = " + pais);
      consulta.append("      AND CAB.VAL_NUME_LOTE_CONT IS NULL ");
      if (fechaHasta != null) {
          java.sql.Date dFechaHasta = new java.sql.Date(fechaHasta.getTime());
          String sFechaHasta = sdf.format(dFechaHasta);
          consulta.append("     AND trunc(CAB.FEC_DOCU) <= TO_DATE (?, 'YYYY-MM-DD') ");
          parametros.add(sFechaHasta);
      }      
      consulta.append("   ) ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      String codigoError = null;
      try {
         bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
      } catch(Exception e) {
         UtilidadesLog.error(e);
         codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;         
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }      

      /*
       * Se actualizan los registros de la entidad Movimientos en Cuenta Corriente, 
       * siempre que tengan numero lote de contabilización y fecha de contabilización a nulo:
       */
      consulta = new StringBuffer(); 
      parametros = new Vector();
      
      consulta.append("UPDATE CCC_MOVIM_CUENT_CORRI MCC ");
      consulta.append("SET ");
      consulta.append("   MCC.VAL_NUME_LOTE_CONT = ?, ");
      parametros.add(numeroLoteContabilizacion);
      consulta.append("   MCC.FEC_CONTA = TO_DATE(?, 'YYYY-MM-DD') ");
      parametros.add(sdf.format(fechaContabilizacion));
      consulta.append("WHERE ");
      consulta.append("   MCC.OID_MOVI_CC IN ( ");
      consulta.append("      SELECT MOVCC.OID_MOVI_CC ");
      consulta.append("      FROM CCC_MOVIM_CUENT_CORRI MOVCC, ");
      consulta.append("         CCC_CABEC_CARGA_ABONO_DIREC CAB, ");
      consulta.append("         CCC_DETAL_CARGO_ABONO_DIREC DET ");
      consulta.append("      WHERE MOVCC.VAL_NUME_LOTE_CONT IS NULL ");
      consulta.append("      AND MOVCC.FEC_CONTA IS NULL ");
      consulta.append("      AND CAB.OID_CABE_CARG = DET.CCAD_OID_CABE_CARG ");
      consulta.append("      AND DET.MVCC_OID_MOVI_CC = MOVCC.OID_MOVI_CC ");
      consulta.append("      AND CAB.PAIS_OID_PAIS = " + pais);
      consulta.append("      AND CAB.VAL_NUME_LOTE_CONT IS NULL ");
      if (fechaHasta != null) {
          java.sql.Date dFechaHasta = new java.sql.Date(fechaHasta.getTime());
          String sFechaHasta = sdf.format(dFechaHasta);
          consulta.append("     AND trunc(CAB.FEC_DOCU) <= TO_DATE (?, 'YYYY-MM-DD') ");
          parametros.add(sFechaHasta);
      }      
      consulta.append("   ) ");
      
      try {
         bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
      } catch(Exception e) {
         UtilidadesLog.error(e);
         codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;         
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }      

      /*
       * Se actualiza los registros de cabecera de cargos y abonos directos, 
       * asignándoos numero de lote de contabilización y fecha de contabilización:
       */
      consulta = new StringBuffer(); 
      parametros = new Vector();
      consulta.append(" UPDATE CCC_CABEC_CARGA_ABONO_DIREC CAB ");
      consulta.append(" SET ");
      consulta.append("   CAB.VAL_NUME_LOTE_CONT = ?, ");
      parametros.add(numeroLoteContabilizacion);
      consulta.append("   CAB.FEC_CONT = TO_DATE(?, 'YYYY-MM-DD') ");
      parametros.add(sdf.format(fechaContabilizacion));
      consulta.append(" WHERE ");
      consulta.append("   PAIS_OID_PAIS = " + pais);
      consulta.append("   AND VAL_NUME_LOTE_CONT IS NULL ");
      if (fechaHasta != null) {
          java.sql.Date dFechaHasta = new java.sql.Date(fechaHasta.getTime());
          String sFechaHasta = sdf.format(dFechaHasta);
          consulta.append("   AND trunc(FEC_DOCU) <= TO_DATE (?, 'YYYY-MM-DD') ");
          parametros.add(sFechaHasta);
      }      

        try {
           bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
      } catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
         UtilidadesLog.error(e);         
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }      

      UtilidadesLog.info("DAOINT.actualizarRegistros(ArrayList listaOidCabecera, String numeroLoteContabilizacion,  Date fechaContabilizacion): Salida");
   }

   
   /**
    * incidencia BELC300013442, BELC300013662, BELC300018795
    */
   public ArrayList obtenerCargosAbonos(Long pais, Date fechaHasta) throws MareException {
      UtilidadesLog.info("DAOINT.obtenerCargosAbonos(Long pais): Entrada");
      String consulta = new String();
      Vector parametros = new Vector();
      
      consulta = "SELECT ";
      consulta += "CAB.OID_CABE_CARG OIDCABECERA, ";
      consulta += "CAB.PAIS_OID_PAIS PAIS, ";
      consulta += "PAI.COD_PAIS CODIGOPAIS, "; 
      consulta += "PAI.MONE_OID_MONE MONEDA, "; 
      consulta += "MONE.COD_MONE CODIGOMONEDA, ";
      consulta += "CAB.FEC_DOCU FECHADOCUMENTO, "; 
      consulta += "CAB.FEC_VALO FECHAVALOR, ";
      consulta += "CAB.SOCI_OID_SOCI EMPRESA, ";
      consulta += "SOCI.COD_SOCI CODIGOEMPRESA, ";
      consulta += "ACC.CANA_OID_CANA CANAL, ";
      consulta += "SBAC.ACCE_OID_ACCE ACCESO, ";
      consulta += "CAB.SBAC_OID_SBAC SUBACCESO, ";
      consulta += "PRO.OID_PROC PROCESO, ";
      consulta += "PRO.COD_PROC CODIGOPROCESO, ";
      consulta += "TASP.SUBP_OID_SUBP SUBPROCESO, ";
      consulta += "SUBPR.COD_SUBP CODIGOSUBPROCESO, ";
      consulta += "DET.CCBA_OID_CUEN_CORR_BANC BANCO, ";
      consulta += "CC.COD_CC CODIGOBANCO, ";
      consulta += "DET.FEC_PAGO_BANC FECHAPAGOBANCOS, ";
      consulta += "DET.TASP_OID_TIPO_ABON_SUBP TIPOABONOSUBPROCESODETALLE, ";
      consulta += "DET.CUCO_OID_CUEN_CONT_CUOT_ANTE CUENTACONTABLECUOTAANTERIOR, ";
      consulta += "DET.CUCO_OID_CUEN_CONT_CUOT_NUEV CUENTACONTABLECUOTANUEVA, ";
      consulta += "TCA.COD_TIPO_CARG_ABON TIPOCARGOABONO, ";
      consulta += "CC.DES_CC DESCRIPCIONCUENTACORRIENTE, ";
      consulta += "nvl(DET.IMP,0) IMPORTE, ";       //pzerbino Incidencia rechazada la 137 23/10/2006
      consulta += "SBAC.COD_SBAC CODIGOSUBACCESO, ";
      consulta += "ACC.COD_ACCE CODIGOACCESO, ";
      consulta += "CAN.COD_CANA CODIGOCANAL ";
      
      consulta += "FROM ";
      consulta += "CCC_CABEC_CARGA_ABONO_DIREC CAB, ";
      consulta += "CCC_DETAL_CARGO_ABONO_DIREC DET, ";
      consulta += "SEG_ACCES ACC, ";
      consulta += "SEG_SUBAC SBAC, ";
      consulta += "CCC_TIPO_ABONO_SUBPR TASP, ";
      consulta += "CCC_TIPO_CARGO_ABONO TCA, ";
      consulta += "CCC_PROCE PRO, ";
      consulta += "CCC_SUBPR SUBPR, ";
      consulta += "CCC_CUENT_CORRI_BANCA CC, ";
      consulta += "SEG_PAIS PAI, ";
      consulta += "SEG_SOCIE SOCI, ";
      consulta += "SEG_MONED MONE, ";
      consulta += "SEG_CANAL CAN ";
      
      consulta += "WHERE ";
      consulta += "CAB.PAIS_OID_PAIS = PAI.OID_PAIS ";
      consulta += "AND PAI.MONE_OID_MONE = MONE.OID_MONE ";
      consulta += "AND CAB.SBAC_OID_SBAC = SBAC.OID_SBAC(+) ";
      consulta += "AND SBAC.ACCE_OID_ACCE = ACC.OID_ACCE(+) ";
      consulta += "AND ACC.CANA_OID_CANA = CAN.OID_CANA(+) ";
      consulta += "AND DET.CCAD_OID_CABE_CARG = CAB.OID_CABE_CARG ";
      consulta += "AND DET.TASP_OID_TIPO_ABON_SUBP = TASP.OID_TIPO_ABON_SUBP ";
      consulta += "AND TASP.TCAB_OID_TCAB = TCA.OID_TIPO_CARG_ABON ";
      consulta += "AND TASP.SUBP_OID_SUBP = SUBPR.OID_SUBP ";
      consulta += "AND subpr.CCPR_OID_PROC = pro.OID_PROC ";
      consulta += "AND CAB.SOCI_OID_SOCI = SOCI.OID_SOCI ";
      consulta += "AND DET.CCBA_OID_CUEN_CORR_BANC = CC.OID_CUEN_CORR_BANC(+) ";
      consulta += "AND CAB.PAIS_OID_PAIS = ? ";
      parametros.add(pais);
      consulta += "AND CAB.VAL_NUME_LOTE_CONT IS NULL ";
      
      //<inicio>incidencia SiCC-20070233 (Sapaza), se agrega filtro fechaHasta
      if (fechaHasta != null){
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          java.sql.Date dFechaHasta = new java.sql.Date(fechaHasta.getTime());
          String sFechaHasta = sdf.format(dFechaHasta);
        
          consulta += "AND trunc(CAB.FEC_DOCU) <= TO_DATE (?, 'YYYY-MM-DD') ";
          parametros.add(sFechaHasta);
      }      
      //<fin>incidencia SiCC-20070233 (Sapaza)
      
      // se ejecuta la consulta
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;
      String codigoError = null;
      
      try {
         rs = bs.dbService.executePreparedQuery(consulta, parametros);
      } catch(Exception e) {
         UtilidadesLog.error(e);
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;         
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      ArrayList listaDtos = new ArrayList();
      
      if (! rs.esVacio()) {
         
         UtilidadesLog.debug("*** Metodo DAOINT.obtenerCargosAbonos. Numero de registros en el RecordSet: " + rs.getRowCount());
      
         // con el RecordSet obtenido se construye una lista de objetos 
         // DTOINTCargosAbonos y se retorna.
         listaDtos = new ArrayList();
         DTOINTCargosAbonos dtoINTCyA = null;
         
         for (int i=0; i < rs.getRowCount(); i++) {
            dtoINTCyA = new DTOINTCargosAbonos();
            
            if (rs.getValueAt(i, "CODIGOPAIS") != null) {
                dtoINTCyA.setCodigoPais((String)rs.getValueAt(i, "CODIGOPAIS")); // obligatorio
            }
            if (rs.getValueAt(i, "FECHADOCUMENTO") != null) {
                dtoINTCyA.setFechaDocumento((Date)rs.getValueAt(i, "FECHADOCUMENTO")); // obligatorio
            }
            if (rs.getValueAt(i, "FECHAVALOR") != null) {
                dtoINTCyA.setFechaValor((Date)rs.getValueAt(i, "FECHAVALOR")); // obligatorio
            }
            if (rs.getValueAt(i, "EMPRESA") != null) {
                dtoINTCyA.setEmpresa(new Long(((BigDecimal)rs.getValueAt(i, "EMPRESA")).longValue())); // obligatorio
            }
            if (rs.getValueAt(i, "CODIGOEMPRESA") != null) {
                dtoINTCyA.setCodigoEmpresa((String)rs.getValueAt(i, "CODIGOEMPRESA")); // obligatorio
            }
            if (rs.getValueAt(i, "CANAL") != null) {
                dtoINTCyA.setCanal(new Long(((BigDecimal)rs.getValueAt(i, "CANAL")).longValue())); // obligatorio
            }
            if (rs.getValueAt(i, "CODIGOCANAL") != null) {
                dtoINTCyA.setCodigoCanal((String)rs.getValueAt(i, "CODIGOCANAL"));
            }else{
                dtoINTCyA.setCodigoCanal("-");
            }
            if (rs.getValueAt(i, "ACCESO") != null) {
                dtoINTCyA.setAcceso(new Long(((BigDecimal)rs.getValueAt(i, "ACCESO")).longValue())); // obligatorio
            }
            if (rs.getValueAt(i, "CODIGOACCESO") != null) {
                dtoINTCyA.setCodigoAcceso((String)rs.getValueAt(i, "CODIGOACCESO"));
            }else{
                dtoINTCyA.setCodigoAcceso("-");
            }
            if (rs.getValueAt(i, "SUBACCESO") != null) {
               dtoINTCyA.setSubacceso(new Long(((BigDecimal)rs.getValueAt(i, "SUBACCESO")).longValue())); // NO obligatorio
            }
            if (rs.getValueAt(i, "CODIGOSUBACCESO") != null) {
                dtoINTCyA.setCodigoSubacceso((String)rs.getValueAt(i, "CODIGOSUBACCESO"));
            }else{
                dtoINTCyA.setCodigoSubacceso("-");
            }
            if (rs.getValueAt(i, "PROCESO") != null) {
                dtoINTCyA.setProceso(new Long(((BigDecimal)rs.getValueAt(i, "PROCESO")).longValue())); // obligatorio
            }
            if (rs.getValueAt(i, "CODIGOPROCESO") != null) {
                dtoINTCyA.setCodigoProceso((String)rs.getValueAt(i, "CODIGOPROCESO")); // obligatorio
            }
            if (rs.getValueAt(i, "SUBPROCESO") != null) {
                dtoINTCyA.setSubproceso(new Long(((BigDecimal)rs.getValueAt(i, "SUBPROCESO")).longValue())); // obligatorio
            }
            if (rs.getValueAt(i, "CODIGOSUBPROCESO") != null) {
                dtoINTCyA.setCodigoSubproceso(new String(((BigDecimal)rs.getValueAt(i, "CODIGOSUBPROCESO")).toString())); // obligatorio
            }
            dtoINTCyA.setCuentaContable(null);
            dtoINTCyA.setCodigoCuentaContable(null);
            if (rs.getValueAt(i, "BANCO") != null) {         
               dtoINTCyA.setBanco(new Long(((BigDecimal)rs.getValueAt(i, "BANCO")).longValue())); // NO obligatorio
            }
            if (rs.getValueAt(i, "CODIGOBANCO") != null) {         
                dtoINTCyA.setCodigoBanco((String)rs.getValueAt(i, "CODIGOBANCO")); // obligatorio
            }else{
                dtoINTCyA.setCodigoBanco("-");
            }
            if (rs.getValueAt(i, "FECHAPAGOBANCOS") != null) {
               dtoINTCyA.setFechaPagoBancos((Date)rs.getValueAt(i, "FECHAPAGOBANCOS")); // NO obligatorio
            }
            dtoINTCyA.setIndicadorDebeHaber(null);
            if (rs.getValueAt(i, "IMPORTE") != null) {
               dtoINTCyA.setImporte((BigDecimal)rs.getValueAt(i, "IMPORTE"));
            }
            if (rs.getValueAt(i, "TIPOABONOSUBPROCESODETALLE") != null) {
                dtoINTCyA.setTipoAbonoSubprocesoDetalle(new Long(((BigDecimal)rs.getValueAt(i, "TIPOABONOSUBPROCESODETALLE")).longValue())); // obligatorio
            }
            if (rs.getValueAt(i, "CUENTACONTABLECUOTAANTERIOR") != null) {
               dtoINTCyA.setCuentaContableCuotaAnterior(new Long(((BigDecimal)rs.getValueAt(i, "CUENTACONTABLECUOTAANTERIOR")).longValue())); // NO obligatorio
            }
            if (rs.getValueAt(i, "CUENTACONTABLECUOTANUEVA") != null) {
               dtoINTCyA.setCuentaContableCuotaNueva(new Long(((BigDecimal)rs.getValueAt(i, "CUENTACONTABLECUOTANUEVA")).longValue())); // NO obligatorio
            }
            if (rs.getValueAt(i, "TIPOCARGOABONO") != null) {
               dtoINTCyA.setTipoCargoAbono((String)rs.getValueAt(i, "TIPOCARGOABONO")); // NO obligatorio
            }
            if (rs.getValueAt(i, "DESCRIPCIONCUENTACORRIENTE") != null) {
                dtoINTCyA.setDescripcionCuentaCorriente((String)rs.getValueAt(i, "DESCRIPCIONCUENTACORRIENTE")); // obligatorio
            }
            if (rs.getValueAt(i, "MONEDA") != null) {
                dtoINTCyA.setMoneda(new Long(((BigDecimal)rs.getValueAt(i, "MONEDA")).longValue())); // obligatorio
            }
            if (rs.getValueAt(i, "CODIGOMONEDA") != null) {
                dtoINTCyA.setCodigoMoneda((String)rs.getValueAt(i, "CODIGOMONEDA")); // obligatorio
            }
            if (rs.getValueAt(i, "OIDCABECERA") != null) {
                dtoINTCyA.setOidCabecera(new Long(((BigDecimal)rs.getValueAt(i, "OIDCABECERA")).longValue())); // obligatorio            
            }
            // falta asignar pais e idioma
            dtoINTCyA.setOidPais(pais);
            //dtoINTCyA.setOidIdioma();
            
            // se añade el dto creado al arrayList
            listaDtos.add(dtoINTCyA);
         }
      }
      
      UtilidadesLog.info("DAOINT.obtenerCargosAbonos(Long pais): Salida");
      return listaDtos;
   }   
   
    /**
     * Este metodo ataca la BBDD directamente con JDBC debido a un problema
     * de MARE con el formateo de fechas.
     * 
     * Incidencia: 17531
     */
   public Date obtenerUltimaFecha(Long pais, String codigoInterfaz, String criterios) throws MareException {
      UtilidadesLog.info("DAOINT.obtenerUltimaFecha(Long pais, String codigoInterfaz, String criterios): Entrada");
        
        
      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      
      consulta.append(" SELECT ");
      consulta.append(" MAX(FEC_FIN_PROC) ");
      consulta.append(" FROM ");
      consulta.append(" INT_HISTO_LOTES ");
      consulta.append(" WHERE ");
      consulta.append(" PAIS_OID_PAIS = "+pais.longValue());
      consulta.append(" AND COD_INTE = '"+codigoInterfaz+"'");
      if (criterios != null && criterios != "") {
         consulta.append(" AND VAL_CRIT_CONS = '"+criterios+"'");
      }

        //Vamos a utilizar JDBC en vez de MARE (Inc 17531)

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Date ultimaFecha = null;
      String codigoError = null;
      Connection con = null;
      Statement sta =  null;
      ResultSet rst = null;
      try {
         con = bs.dbService.getConnection();
         sta = con.createStatement();
         rst = sta.executeQuery(consulta.toString());
         //rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        // con el registro obtenido se construye un objeto java.util.Date y se retorna. 
        // si no se obtiene ningún registro, se retorna null. 
        
         rst.next();
         Timestamp ultimaTimeStamp = (Timestamp)rst.getTimestamp(1);
         if (ultimaTimeStamp!=null){
            UtilidadesLog.debug("Milisecs: "+ultimaTimeStamp.getTime());
            ultimaFecha = new Date(ultimaTimeStamp.getTime());
            UtilidadesLog.debug("FECHA: "+ultimaFecha);
        }
        rst.close();
        sta.close();
        con.close();
      } catch(Exception e) {
         UtilidadesLog.error(e);
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;         
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      UtilidadesLog.info("DAOINT.obtenerUltimaFecha(Long pais, String codigoInterfaz, String criterios): Salida");      
      return ultimaFecha;
   }

    /**
     * Se actualiza la descripcion internazionable del registro correspondiente a la entidad
     * buscada y oid correspondiente de la vista i18n.
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @param descripcion
     * @param entidad
     * @param oid
     */
   public void actualizarDescripcion18n(Long oid, String entidad, String descripcion) throws MareException {
      UtilidadesLog.info("DAOINT.actualizarDescripcion18n(Long oid, String entidad, String descripcion): Entrada");
      StringBuffer consulta = new StringBuffer(); 
      Vector parametros = new Vector();

      consulta.append("UPDATE GEN_I18N_SICC ");
      consulta.append("SET VAL_I18N = ? ");
      parametros.add(descripcion);
      consulta.append("WHERE OID_I18N = ? ");
      parametros.add(oid);
      consulta.append("  AND ATTR_ENTI = ? ");
      parametros.add(entidad);

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      String codigoError = null;
      try {
         bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
      } catch(Exception e) {
         UtilidadesLog.error(e);
         codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;         
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }      

      UtilidadesLog.info("DAOINT.actualizarDescripcion18n(Long oid, String entidad, String descripcion): Entrada");
   }

    /**
     * Ejecuta el procedimiento SQL APE_PR_ACTUA_MAEST_PRODU pasándole OID de pais
     * @throws es.indra.mare.common.exception.MareException
     * @param oidPais
     * @author sapaza
     * @cambio Cambio APE
     * @since 20/07/2010
     */
    public void actualizarMaestrosProductosAPE(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOINT.actualizarMaestrosProductosAPE(Long oidPais): Entrada");
        UtilidadesLog.debug("oidPais: " + oidPais);
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            bs.dbService.executeProcedure("APE_PR_ACTUA_MAEST_PRODU", oidPais.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOINT.actualizarMaestrosProductosAPE(Long oidPais): Salida");
    }
 
    // sapaza -- PER-SiCC-2011-0056 -- 22/11/2011
    public String obtenerIndicadorActualizacion(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOINTDAT.obtenerIndicadorActualizacion(Long oidPais): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();        
        
        consulta.append(" SELECT COD_MODA_DIST ");
        consulta.append("   FROM FAC_PARAM_FACTU   ");
        consulta.append("  where PAIS_OID_PAIS = ?          ");
        
        parametros.add(oidPais);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if ((rs != null) && !rs.esVacio()) {                 
            return (String)rs.getValueAt(0,0);        
        }

        UtilidadesLog.info("DAOINTDAT.obtenerIndicadorActualizacion(Long oidPais): Salida");

        return null;
    }  
    
}