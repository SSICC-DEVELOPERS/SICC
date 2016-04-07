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
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.dtos.intsys.DTOBuscarSolicitudAdam;
import es.indra.sicc.dtos.intsys.DTOBusquedaDescuentos;
import es.indra.sicc.dtos.intsys.DTODescPers;
import es.indra.sicc.dtos.intsys.DTOEnviarComInc;
import es.indra.sicc.dtos.intsys.DTOEnvioComInc;
import es.indra.sicc.dtos.intsys.DTOEstatus;
import es.indra.sicc.dtos.intsys.DTOGenerarFichero;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOIndError;
import es.indra.sicc.dtos.intsys.DTOSolicitudAdam;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import es.indra.sicc.logicanegocio.ped.ErroresNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTODate;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.math.BigDecimal;

public class DAOAdam  {

    private String usuario;
    
    public DAOAdam(String usuario) {
        this.usuario=usuario;
    }
    
    public DTODate obtenerFechaDesde(DTOINT dtoe) throws MareException {
        UtilidadesLog.info("DAOAdam.obtenerFechaDesde(DTOINT dtoe): Entrada");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array=new ArrayList();
        DTODate dtoDate = new DTODate();

        consulta.append(" SELECT MAX(FEC_INIC_PROC) FROM INT_HISTO_LOTES WHERE ");   
        consulta.append(" PAIS_OID_PAIS = ? AND ");//pais   
        parametros.add(dtoe.getOidPais());
        
        consulta.append(" NUM_LOTE = ? AND ");//Numero lote   
        parametros.add(dtoe.getNumeroLote());
        
        consulta.append(" COD_INTE IN ( ?, ? )  ");//Codigo Interfaz
        parametros.add(IGestorInterfaces.COD_INTERFAZ_ADA1);
        parametros.add(IGestorInterfaces.COD_INTERFAZ_ADA2);
       

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerFechaDesde: Exception",e);
            this.logSql(" obtenerFechaDesde. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch
      
     if(rs!=null){
       if(!rs.esVacio()){
          for(int i=0;i<rs.getRowCount();i++){
            if(rs.getValueAt(i,"FEC_INIC_PROC")!=null){
                dtoDate.setFecha(new Date(((java.sql.Date)rs.getValueAt(i,"FEC_INIC_PROC")).getTime()));
            }
           }//for
       }
     }//(rs!=null)
      
    //Con el registro obtenido se devuelve un objeto de tipo DTODate con el atributo: 
    //- fecha= MAX (fechaFinProceso)
        
        UtilidadesLog.info("DAOAdam.obtenerFechaDesde(DTOINT dtoe): Salida");
        return dtoDate;
    }



    public ArrayList buscarRegistrosDesc () throws MareException {
        UtilidadesLog.info("DAOAdam.buscarRegistrosDesc(): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = null;
        DTODate dtoDate = new DTODate();

        consulta.append(" SELECT OID_DESC_PERS_CABE FROM INT_DESCU_PERSO_CABEC ");   
        consulta.append(" WHERE ");//pais   
        consulta.append(" ESDE_OID_ESTA_DESC = ? ");//Estado   
        parametros.add(ConstantesINT.ESTADO_PENDIENTE);        
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" buscarRegistrosDesc: Exception",e);
            this.logSql(" buscarRegistrosDesc. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch
      
     if(rs!=null){
       if(!rs.esVacio()){
          array = new ArrayList();
          for(int i=0;i<rs.getRowCount();i++){
            if(rs.getValueAt(i,"OID_DESC_PERS_CABE")!=null){
                DTOOID dtooid = new DTOOID();
                dtooid.setOid(new Long(((java.math.BigDecimal)rs.getValueAt(i,"OID_DESC_PERS_CABE")).longValue()));
                array.add(dtooid);      
            }
           }//for
       }
     }//(rs!=null)
      
    //Con el registro obtenido se devuelve un objeto de tipo DTODate con el atributo: 
    //- fecha= MAX (fechaFinProceso)
        
        UtilidadesLog.info("DAOAdam.buscarRegistrosDesc(): Salida");
        return array;
    }

    public DTODate buscarFechaDesde (String codInterfaz, DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOAdam.buscarFechaDesde(String codInterfaz, DTOBelcorp dtoe): Entrada");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array=new ArrayList();
        DTODate dtoDate = new DTODate();

        consulta.append(" SELECT MAX(FEC_FIN_PROC) FEC_FIN_PROC FROM INT_HISTO_LOTES WHERE ");   
        consulta.append(" PAIS_OID_PAIS = ? AND ");//pais   
        parametros.add(dtoe.getOidPais());
        
        consulta.append(" COD_INTE LIKE ? ");//Codigo Interfaz
        parametros.add(codInterfaz);
      
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" buscarFechaDesde: Exception",e);
            this.logSql(" buscarFechaDesde. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch
      
     if(rs!=null){
       if(!rs.esVacio()){
          for(int i=0;i<rs.getRowCount();i++){
            if(rs.getValueAt(i,"FEC_FIN_PROC")!=null){
                dtoDate.setFecha(new Date(((java.sql.Date)rs.getValueAt(i,"FEC_FIN_PROC")).getTime()));
            }
           }//for
       }
     }//(rs!=null)
      
    //Con el registro obtenido se devuelve un objeto de tipo DTODate con el atributo: 
    //- fecha= MAX (fechaFinProceso)
        
        UtilidadesLog.info("DAOAdam.buscarFechaDesde(String codInterfaz, DTOBelcorp dtoe): Salida");
        return dtoDate;
    }


    public ArrayList  obtenerTipoSolicitudProceso (DTOBuscarSolicitudAdam dtoe) throws MareException {
        UtilidadesLog.info("DAOAdam.obtenerTipoSolicitudProceso(DTOBuscarSolicitudAdam dtoe): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = null;

        /*
        Se recibe un DTOBuscarSolicitudAdam de donde tenemos que filtrar. 
        DTOBuscarSolicitudAdam DTE 
        */


        consulta.append(" SELECT ");
        consulta.append(" A.ticl_oid_tipo_clie TIPOCLIENTE,  ");
        consulta.append(" B.oid_tipo_soli_pais TIPOSOLICITUD,  ");
        consulta.append(" C.tpos_oid_tipo_posi TIPOPOSICION,  ");
        consulta.append(" C.stpo_oid_subt_posi SUBTIPOPOSICION, ");
        //consulta.append(" E.COD_PROC PROCESO "); // Incidencia BELC300014442
        consulta.append(" C.PROD_OID_PROD PRODUCTO"); // Incidencia BELC300014561 
        consulta.append(" FROM  ");

        
        consulta.append(" ped_tipo_solic A,  ");
        consulta.append(" ped_tipo_solic_pais B, "); 
        consulta.append(" ped_tipo_solic_proce C,  ");
        consulta.append(" bel_opera D  ");
        consulta.append(" WHERE  ");
        //columna oidTipoCliente del RecordSet DTOE.lstDetalle
        RecordSet rsDetalle = dtoe.getLstDetalle();
        
        ArrayList parIN = new ArrayList();
        for(int i=0;i<rsDetalle.getRowCount();i++){
            if(rsDetalle.getValueAt(i,"TIPOCLIENTE")!=null){
                parIN.add((Long)rsDetalle.getValueAt(i,"TIPOCLIENTE"));       
                parametros.add((Long)rsDetalle.getValueAt(i,"TIPOCLIENTE"));
            }
        }
        String cadena = this.convertirArrayToString(parIN);
        if (cadena.compareTo("")!=0){
            consulta.append(" A.ticl_oid_tipo_clie IN ( "+ cadena +" ) AND  ");
        }
       
        //DTOE.oidMarca
        consulta.append(" A.marc_oid_marc = ? AND  ");
        parametros.add(dtoe.getOidMarca());
        //DTOE.oidAcceso
        consulta.append(" A.acce_oid_acce = ? AND  ");
        parametros.add(dtoe.getOidAcceso());
        consulta.append(" B.tsol_oid_tipo_soli = A.oid_tipo_soli AND  ");
        //DTOE.oidPais
        consulta.append(" B.pais_oid_pais = ? AND  ");
        parametros.add(dtoe.getOidPais());
        //ConstantesBEL.COD_INT083
        consulta.append(" D.COD_OPER = ?  AND  "); // Cambio por incidencia BELC300014561
        parametros.add(ConstantesBEL.COD_INT083);
        consulta.append(" C.tspa_oid_tipo_soli_pais = B.oid_tipo_soli_pais AND  ");
        consulta.append(" C.OPER_OID_OPER = D.OID_OPER  ");
        

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerTipoSolicitudProceso: Exception",e);
            this.logSql(" obtenerTipoSolicitudProceso. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }//catch
      
         if(rs!=null){
           if(!rs.esVacio()){
              array = new ArrayList();
              for(int i=0;i<rs.getRowCount();i++){
                DTOSolicitudAdam dtoSolicitudAdam = new DTOSolicitudAdam();
                if(rs.getValueAt(i,"TIPOCLIENTE")!=null){
                    dtoSolicitudAdam.setOidTipoCliente(new Long(((java.math.BigDecimal)rs.getValueAt(i,"TIPOCLIENTE")).longValue()));
                }
                if(rs.getValueAt(i,"TIPOSOLICITUD")!=null){
                    dtoSolicitudAdam.setOidTipoSolicitud(new Long(((java.math.BigDecimal)rs.getValueAt(i,"TIPOSOLICITUD")).longValue()));
                }
                if(rs.getValueAt(i,"TIPOPOSICION")!=null){
                    dtoSolicitudAdam.setOidTipoPosicion(new Long(((java.math.BigDecimal)rs.getValueAt(i,"TIPOPOSICION")).longValue()));
                }
                if(rs.getValueAt(i,"SUBTIPOPOSICION")!=null){
                    dtoSolicitudAdam.setOidSubtipoPosicion(new Long(((java.math.BigDecimal)rs.getValueAt(i,"SUBTIPOPOSICION")).longValue()));
                }
                if(rs.getValueAt(i,"PRODUCTO")!=null){
                    dtoSolicitudAdam.setOidProducto(new Long(((java.math.BigDecimal)rs.getValueAt(i,"PRODUCTO")).longValue()));
                }
                array.add(dtoSolicitudAdam);                  
               }//for
           }else{
                UtilidadesLog.debug("****: No hay datos ");				
                throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "",
                    ErroresNegocio.PED_027));
           }
         }//(rs!=null)
        
        UtilidadesLog.info("DAOAdam.obtenerTipoSolicitudProceso(DTOBuscarSolicitudAdam dtoe): Salida");
        return array;
    }


    public ArrayList obtenerEnvioComision(DTOEnviarComInc dtoe) throws MareException {
        UtilidadesLog.info("DAOAdam.obtenerEnvioComision(DTOEnviarComInc dtoe): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = null;


        consulta.append(" SELECT CLI.OID_CLIE OIDCLIENTE, CDA.COD_EMPL CODEMPL, SUM(ICI.IMP_PAGA) SUMPAGA,");
        //añadido por incidencia 22281
        consulta.append(" ICI.DCOI_OID_COMI_INCE INDOIDINGRESOCOMINC");
        
        consulta.append(" FROM  ");
        consulta.append(" INT_INGRE_COMIS_INCEN ICI,  "); //--IngresoComisionesEIncentivos 
        consulta.append(" MAE_CLIEN_DATOS_ADICI CDA,  "); //--ClienteDatosAdicionales
        consulta.append(" MAE_CLIEN CLI,   ");//--Cliente
        consulta.append(" MAE_CLIEN_TIPO_SUBTI CTI  ");//-- ClienteTipoSubtipo
               
        //consulta.append(" WHERE ");
        //consulta.append("  ICI.OID_INGR_COMI_INCE = CTI.OID_CLIE_TIPO_SUBT AND ");// -- ESTE JOIN ESTA MAL
        //consulta.append("  ici.oid_ingr_comi_ince = cti.ticl_oid_tipo_clie AND  ");// -- ESTE JOIN ESTA MAL
        //consulta.append(" CLI.OID_CLIE = CTI.CLIE_OID_CLIE AND  ");
        //consulta.append(" CLI.OID_CLIE = CDA.OID_CLIE_DATO_ADIC ");
        
         consulta.append(" WHERE  ");
         consulta.append(" ICI.CTSU_OID_CLIE_TIPO_SUBT = CTI.OID_CLIE_TIPO_SUBT  ");
         consulta.append(" AND  CLI.OID_CLIE = CTI.CLIE_OID_CLIE  ");
         consulta.append(" AND  CLI.OID_CLIE = CDA.CLIE_OID_CLIE"); 
/*
- IngresoComisionesEIncentivos.fechaDesde= DTOEnviarComInc.fechaDesde 
- IngresoComisionesEIncentivos.fechaHasta= DTOEnviarComInc.fechaHasta 
- IngresoComisionesEIncentivos.oidIndComisionIncentivo=ConstantesCOM.MODULO_GENERADOR_COMISION 
- IngresoComisionesEIncentivos.numeroLote==null 
- ClienteTipoSubtipo.oidTipoCliente IN DTOEnviarComInc.arrayTiposClientes //debemos filtrar por los tipoClientes recibidos. Si viene a null, no se debe filtrar 
*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        if (dtoe.getFechaDesde()!=null){
            java.sql.Date fechaD = new java.sql.Date(dtoe.getFechaDesde().getTime());
            String sFechaDesde = sdf.format(fechaD);   
            consulta.append(" AND ICI.FEC_INGR_COMI_INCE >=  TO_DATE( ? ,'YYYY-MM-DD') ");             
            parametros.add(sFechaDesde);
        }

        if (dtoe.getFechaHasta()!=null){
            java.sql.Date fechaH = new java.sql.Date(dtoe.getFechaHasta().getTime());
            String sFechaHasta = sdf.format(fechaH);   
            consulta.append(" AND ICI.FEC_INGR_COMI_INCE <=  TO_DATE( ? ,'YYYY-MM-DD') ");               
            parametros.add(sFechaHasta);
        }
        
      //  consulta.append(" AND ICI.OID_INGR_COMI_INCE = ? ");   
      
        consulta.append(" AND ici.DCOI_OID_COMI_INCE  = ? ");
        parametros.add(ConstantesCOM.MODULO_GENERADOR_COMISION);

        consulta.append(" AND ICI.NUM_LOTE IS NULL ");
        
        //ClienteTipoSubtipo.oidTipoCliente IN DTOEnviarComInc.arrayTiposClientes 
        //debemos filtrar por los tipoClientes recibidos. Si viene a null, no se debe filtrar 
        
        Long oidsTC[] = dtoe.getArrayTiposClientes();
        if(oidsTC!=null){
            ArrayList aux = new ArrayList();
            if(oidsTC.length != 0){ //si hay oids de tipos de clientes
                for (int s=0;s<oidsTC.length;s++){
                    aux.add(oidsTC[s]);
                }
                String tiposCliente = this.convertirArrayToString(aux);
                consulta.append(" AND CTI.TICL_OID_TIPO_CLIE IN ("+ tiposCliente +")  ");
                for(int r=0;r<oidsTC.length;r++){
                    parametros.add(oidsTC[r]);
                }
            }
        }
        //modificada por inc 22281    
        consulta.append(" GROUP BY CLI.OID_CLIE, CDA.COD_EMPL, ICI.DCOI_OID_COMI_INCE");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerEnvioComision: Exception",e);
            this.logSql(" obtenerEnvioComision. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch

/*
Con los registros obtenidos se crea una lista de objetos DTOEnvioComInc y se retorna. 
DTOEnvioComInc.oidCliente.Cliente.oid 
DTOEnvioComInc.codPlanilla=ClienteDatosAdicionales.codEmpleado 
DTOEnvioComInc.importePagar=IngresoComisionesEIncentivos.importePagar 
DTOEnvioComInc.fallido=false 
seteamos false en todos los objetos. Este flag, lo utilizaremos para controlar en 
que registros ha fallado el envio y asi actualizarlos posteriormente
 */
     if(rs!=null){
       if(!rs.esVacio()){
          array = new ArrayList();
          for(int i=0;i<rs.getRowCount();i++){
            DTOEnvioComInc dtoEnvioComInc = new DTOEnvioComInc();
            if(rs.getValueAt(i,"OIDCLIENTE")!=null){
                dtoEnvioComInc.setOidCliente(new Long(((java.math.BigDecimal)rs.getValueAt(i,"OIDCLIENTE")).longValue()));
            }
            if(rs.getValueAt(i,"CODEMPL")!=null){
                dtoEnvioComInc.setCodPlanilla((String)rs.getValueAt(i,"CODEMPL"));
            }
            if(rs.getValueAt(i,"SUMPAGA")!=null){
                dtoEnvioComInc.setImportePagar(new Long(((java.math.BigDecimal)rs.getValueAt(i,"SUMPAGA")).longValue()));
            }
            //añadido por incidencia 22281
            if(rs.getValueAt(i,"INDOIDINGRESOCOMINC")!=null){
                dtoEnvioComInc.setOidIngresoComInc(new Long(((BigDecimal)rs.getValueAt(i,"INDOIDINGRESOCOMINC")).longValue()));
            }
            dtoEnvioComInc.setFallido(Boolean.FALSE);
            array.add(dtoEnvioComInc);
           }//for
       }
     }//(rs!=null)
      
     UtilidadesLog.info("DAOAdam.obtenerEnvioComision(DTOEnviarComInc dtoe): Salida");
     return array;
    }



    public ArrayList obtenerEnvioIncentivo (DTOEnviarComInc dtoe) throws MareException {
        UtilidadesLog.info("DAOAdam.obtenerEnvioIncentivo(DTOEnviarComInc dtoe): Entrada");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array = null;

        consulta.append(" SELECT CLI.OID_CLIE OIDCLIENTE, CDA.COD_EMPL CODEMPL, SUM(ICI.IMP_PAGA) SUMPAGA,");
        //añadido por incidencia 22281
        consulta.append(" ICI.DCOI_OID_COMI_INCE INDOIDINGRESOCOMINC");
        consulta.append(" FROM  ");
        consulta.append(" INT_INGRE_COMIS_INCEN ICI,  "); //--IngresoComisionesEIncentivos 
        consulta.append(" MAE_CLIEN_DATOS_ADICI CDA,  "); //--ClienteDatosAdicionales
        consulta.append(" MAE_CLIEN CLI,   ");//--Cliente
        consulta.append(" MAE_CLIEN_TIPO_SUBTI CTI  ");//-- ClienteTipoSubtipo
               
               
        consulta.append(" WHERE  ");
        consulta.append(" ICI.CTSU_OID_CLIE_TIPO_SUBT = CTI.OID_CLIE_TIPO_SUBT  ");
        consulta.append(" AND  CLI.OID_CLIE = CTI.CLIE_OID_CLIE  ");
        consulta.append(" AND  CLI.OID_CLIE = CDA.CLIE_OID_CLIE "); 

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        if (dtoe.getFechaDesde()!=null){
            java.sql.Date fechaD = new java.sql.Date(dtoe.getFechaDesde().getTime());
            String sFechaDesde = sdf.format(fechaD);   
            consulta.append(" AND ICI.FEC_INGR_COMI_INCE >=  TO_DATE( ? ,'YYYY-MM-DD') ");             
            parametros.add(sFechaDesde);
        }

        if (dtoe.getFechaHasta()!=null){
            java.sql.Date fechaH = new java.sql.Date(dtoe.getFechaHasta().getTime());
            String sFechaHasta = sdf.format(fechaH);   
            consulta.append(" AND ICI.FEC_INGR_COMI_INCE <=  TO_DATE( ? ,'YYYY-MM-DD') ");               
            parametros.add(sFechaHasta);
        }
        

        //Jrivas 19/10/2005
        //consulta.append(" AND ICI.OID_INGR_COMI_INCE = ? ");               
        
        consulta.append(" AND ici.DCOI_OID_COMI_INCE  = ? ");
        parametros.add(ConstantesCOM.MODULO_GENERADOR_INCENTIVO);

        consulta.append(" AND ICI.NUM_LOTE IS NULL ");               
        
        //ClienteTipoSubtipo.oidTipoCliente IN DTOEnviarComInc.arrayTiposClientes 
        //debemos filtrar por los tipoClientes recibidos. Si viene a null, no se debe filtrar 
        
        Long oidsTC[] = dtoe.getArrayTiposClientes();
        if(oidsTC!=null){
            ArrayList aux = new ArrayList();
            if(oidsTC.length != 0){ //si hay oids de tipos de clientes
                for (int s=0;s<oidsTC.length;s++){
                    aux.add(oidsTC[s]);
                }
                String tiposCliente = this.convertirArrayToString(aux);
                consulta.append(" AND CTI.TICL_OID_TIPO_CLIE IN ("+ tiposCliente +")  ");
                for(int r=0;r<oidsTC.length;r++){
                    parametros.add(oidsTC[r]);
                }
            }
        }
        //modificada por inc 22281
        //consulta.append(" GROUP BY CLI.OID_CLIE, CDA.COD_EMPL ");
        consulta.append(" GROUP BY CLI.OID_CLIE, CDA.COD_EMPL, ICI.DCOI_OID_COMI_INCE");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerEnvioIncentivo: Exception",e);
            this.logSql(" obtenerEnvioIncentivo. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch

/*
Con los registros obtenidos se crea una lista de objetos DTOEnvioComInc y se retorna. 
DTOEnvioComInc.oidCliente.Cliente.oid 
DTOEnvioComInc.codPlanilla=ClienteDatosAdicionales.codEmpleado 
DTOEnvioComInc.importePagar=IngresoComisionesEIncentivos.importePagar 
DTOEnvioComInc.fallido=false 
seteamos false en todos los objetos. Este flag, lo utilizaremos para controlar en 
que registros ha fallado el envio y asi actualizarlos posteriormente
 */
     if(rs!=null){
       if(!rs.esVacio()){
          array = new ArrayList();
          for(int i=0;i<rs.getRowCount();i++){
            DTOEnvioComInc dtoEnvioComInc = new DTOEnvioComInc();
            if(rs.getValueAt(i,"OIDCLIENTE")!=null){
                dtoEnvioComInc.setOidCliente(new Long(((java.math.BigDecimal)rs.getValueAt(i,"OIDCLIENTE")).longValue()));
            }
            if(rs.getValueAt(i,"CODEMPL")!=null){
                dtoEnvioComInc.setCodPlanilla((String)rs.getValueAt(i,"CODEMPL"));
            }
            if(rs.getValueAt(i,"SUMPAGA")!=null){
                dtoEnvioComInc.setImportePagar(new Long(((java.math.BigDecimal)rs.getValueAt(i,"SUMPAGA")).longValue()));
            }
            //añadido por incidencia 22281
            if(rs.getValueAt(i,"INDOIDINGRESOCOMINC")!=null){
                dtoEnvioComInc.setOidIngresoComInc(new Long(((BigDecimal)rs.getValueAt(i,"INDOIDINGRESOCOMINC")).longValue()));
            }
            dtoEnvioComInc.setFallido(Boolean.FALSE);
            array.add(dtoEnvioComInc);
           }//for
       }
     }//(rs!=null)
      
     UtilidadesLog.info("DAOAdam.obtenerEnvioIncentivo(DTOEnviarComInc dtoe): Salida");
     return array;
    }

    public RecordSet buscarDescuentos(DTOBusquedaDescuentos dtoe) throws MareException {
        UtilidadesLog.info("DAOAdam.buscarDescuentos(DTOBusquedaDescuentos dtoe): Entrada");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        ArrayList array=new ArrayList();
        DTODate dtoDate = new DTODate();


        consulta.append(" SELECT DPC.OID_DESC_PERS_CABE OID, ");
        consulta.append(" MA.DES_MARC, ");
        
        //canal
        consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC V ");
        consulta.append(" WHERE V.VAL_OID=CA.OID_CANA ");
        consulta.append(" AND v.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        consulta.append(" AND v.ATTR_NUM_ATRI = 1 ");
        consulta.append(" AND v.ATTR_ENTI = 'SEG_CANAL') AS CANAL, ");

        //acceso
        consulta.append(" (SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
        consulta.append(" WHERE V.VAL_OID=ACC.OID_ACCE ");
        consulta.append(" AND V.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        consulta.append(" AND V.ATTR_NUM_ATRI = 1 ");
        consulta.append(" AND V.ATTR_ENTI = 'SEG_ACCES') AS ACCESO, ");

        
        consulta.append(" DPC.NUM_DOCU, ");
        consulta.append(" DPC.NUM_LOTE, ");
        consulta.append(" DPC.FEC_CREA, ");
        
        consulta.append(" DPC.FEC_VENC_DESD, ");
        consulta.append(" DPC.FEC_VENC_HAST, ");
        // DescuentosPersonalCabecera.fechaVencimientoHasta 
        // DescuentosPersonalCabecera.fechaVencimientoDesde.
        consulta.append(" (SELECT V.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append(" WHERE V.VAL_OID=ed.OID_ESTA_DESC ");
        consulta.append(" AND V.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        consulta.append(" AND V.ATTR_NUM_ATRI = 1 ");
        consulta.append(" AND V.ATTR_ENTI = 'INT_ESTAD_DESCU') AS ESTADO ");
        
        consulta.append(" FROM ");
        consulta.append(" INT_DESCU_PERSO_CABEC DPC, ");
        consulta.append(" VCA_SEG_ACCES ACC, ");
        consulta.append(" VCA_SEG_CANAL CA, ");
        consulta.append(" VCA_SEG_MARCA MA, ");
        consulta.append(" INT_ESTAD_DESCU ED ");
        
        consulta.append(" WHERE ");
        consulta.append(" DPC.ESDE_OID_ESTA_DESC = ED.OID_ESTA_DESC AND ");
        consulta.append(" DPC.ACCE_OID_ACCE = ACC.OID_ACCE AND ");
        consulta.append(" ACC.COD_USUA = ? AND ");
        parametros.add(this.usuario);
        consulta.append(" ACC.CANA_OID_CANA = CA.OID_CANA AND ");
        consulta.append(" CA.COD_USUA = ? AND ");
        parametros.add(this.usuario);
        consulta.append(" DPC.MARC_OID_MARC = MA.OID_MARC AND ");
        consulta.append(" MA.COD_USUA = ? ");
        parametros.add(this.usuario);

        
        consulta.append(" AND DPC.MARC_OID_MARC = MA.OID_MARC ");
        
        if (dtoe.getNumeroLote()!=null){
            consulta.append(" AND DPC.NUM_LOTE LIKE ? ");
            parametros.add(dtoe.getNumeroLote());
        }
        if (dtoe.getNumeroDocumento()!=null){        
            consulta.append(" AND DPC.NUM_DOCU = ? ");
            parametros.add(dtoe.getNumeroDocumento());
        }
        
        if(dtoe.getDescripcionLote()!=null){
            consulta.append(" AND DPC.VAL_DESC_LOTE LIKE '" + dtoe.getDescripcionLote() + "' ");
        }
        
        if (dtoe.getOidPais()!=null){        
            consulta.append(" AND DPC.PAIS_OID_PAIS = ? ");
            parametros.add(dtoe.getOidPais());
        }
        if (dtoe.getOidAcceso()!=null){        
            consulta.append(" AND DPC.ACCE_OID_ACCE = ? ");
            parametros.add(dtoe.getOidAcceso());
        }
        if (dtoe.getOidMarca()!=null){        
            consulta.append(" AND DPC.MARC_OID_MARC = ? ");
            parametros.add(dtoe.getOidMarca());
        }
        
        if(dtoe.getFechaVencimientoDesde()!=null){
            consulta.append(" AND DPC.FEC_VENC_DESD =  TO_DATE( '" + dtoe.getFechaVencimientoDesde() + "' ,'" + dtoe.getFormatoFecha() + "') ");             
        }
        
        if(dtoe.getFechaVencimientoHasta()!=null){
            consulta.append(" AND DPC.FEC_VENC_HAST =  TO_DATE( '" + dtoe.getFechaVencimientoHasta() + "' ,'" + dtoe.getFormatoFecha() + "') ");             
        }
        
       
        ArrayList oidsEstados = dtoe.getEstados();
        if(oidsEstados!=null){
            ArrayList aux = new ArrayList();
            if(oidsEstados.size() != 0){ //si hay oids de tipos de clientes

                String estados = this.convertirArrayToString(oidsEstados);
                consulta.append(" AND DPC.ESDE_OID_ESTA_DESC IN ("+ estados +")  ");
                Long oid = null;
                for(int r=0;r<oidsEstados.size();r++){
                    parametros.add(oidsEstados.get(r));
                }
            }
        }
/*
filtrando por: Aquellos filtros que no sean nulos 
- DescuentosPersonalCabecera.numeroDocumento = DTOBusquedaDescuentos.numeroDocumento 
- DescuentosPersonalCabecera.numeroLote = DTOBusquedaDescuentos.numeroLote 
- DescuentosPersonalCabecera.pais = DTOBusquedaDescuentos.pais 
- DescuentosPersonalCabecera.oidAcceso = DTOBusquedaDescuentos.oidAcceso 
- DescuentosPersonalCabeceraoidMarca = DTOBusquedaDescuentos.oidMarca 
- DescuentosPersonalCabecera.oidEstado IN DTOBusquedaDescuentos.estados 
*/
        String sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dtoe);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(sqlPaginacion,parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" buscarDescuentos: Exception",e);
            this.logSql(" buscarDescuentos. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }//catch
      UtilidadesLog.debug("***DAOAdam.buscarDescuentos  - Salida   rs "+rs);
      UtilidadesLog.info("DAOAdam.buscarDescuentos(DTOBusquedaDescuentos dtoe): Salida");
      return rs;
    }
    
    
    public  DTOGenerarFichero recuperarCabecera(DTOOID dto) throws MareException {                                                      
        UtilidadesLog.info("DAOAdam.recuperarCabecera(DTOOID dto): Entrada");                                                                                                                                        
       
                                                                                                                                         
        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();                                                                                                
                                                                                                                                         
        consulta.append(" SELECT ");                                                                                                     
        consulta.append(" cab.NUM_DOCU, ");                                                                                              
        consulta.append(" cab.NUM_LOTE, ");                                                                                              
        consulta.append(" cab.VAL_DESC_LOTE, ");                                                                                         
        consulta.append(" cab.FEC_CREA, ");                                                                                              
        consulta.append(" cab.ESDE_OID_ESTA_DESC,");                                                                                     
        consulta.append(" cab.MARC_OID_MARC, ");                                                                                         
        consulta.append(" cab.VAL_OBSE, ");                                                                                              
        consulta.append(" cab.ACCE_OID_ACCE, ");                                                                                         
        consulta.append(" cab.fec_venc_desd, ");
        consulta.append(" cab.fec_venc_hast, ");                                                
                                                                                                                                         
        consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");                                                                  
        consulta.append(" WHERE v.VAL_OID=est.OID_ESTA_DESC ");                                                                          
        consulta.append(" AND v.IDIO_OID_IDIO = ? ");                                                                                    
        parametros.add(dto.getOidIdioma());                                                                                              
        consulta.append(" AND v.ATTR_NUM_ATRI = 1 ");                                                                                    
        consulta.append(" AND v.ATTR_ENTI = 'INT_ESTAD_DESCU') AS DESCRIPCIONESTADO,");                                                  
                                                                                                                                         
        consulta.append(" a.CANA_OID_CANA ");                                                                                            
        consulta.append(" FROM ");                                                                                                       
        consulta.append(" INT_DESCU_PERSO_CABEC cab, ");                                                                                 
        consulta.append(" INT_ESTAD_DESCU est, ");                                                                                       
        consulta.append(" VCA_SEG_ACCES a ");                                                                                            
                                                                                                                                         
        consulta.append(" WHERE ");                                                                                                      
                                                                                                                                         
        consulta.append(" cab.ESDE_OID_ESTA_DESC = est.OID_ESTA_DESC ");                                                                 
        consulta.append(" AND cab.acce_oid_acce = a.oid_acce ");                                                                         
        consulta.append(" AND cab.OID_DESC_PERS_CABE = ? "); 
        parametros.add(dto.getOid());
        consulta.append(" AND a.cod_usua= ? ");                                                                                          
        parametros.add(this.usuario);                                                                                                    
                                                                                                                                         
                                                                                                                                         
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOADAM.recuperarDetalle: Exception",e);                                                           
            this.logSql(" DAOADAM.recuperarDetalle. SQL: ",consulta.toString(),parametros);                                              
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }//catch                                                                                                                           
                                                                                                                                         
       DTOGenerarFichero dtoG= null;                                                                                                     
        if(rs!=null){                                                                                                                    
       if(!rs.esVacio()){                                                                                                                
           for(int i=0;i<rs.getRowCount();i++){                                                                                          
                dtoG = new DTOGenerarFichero();                                                                                          
                if(rs.getValueAt(i,"NUM_LOTE")!=null){                                                                                   
                    dtoG.setNumeroLote((String)rs.getValueAt(i,"NUM_LOTE"));                                                             
                }                                                                                                                        
                if(rs.getValueAt(i,"NUM_DOCU")!=null){                                                                                   
                     dtoG.setNumeroDocumento(((BigDecimal)rs.getValueAt(i,"NUM_DOCU")).toString());                                                       
                }                                                                                                                        
                 if(rs.getValueAt(i,"VAL_DESC_LOTE")!=null){                                                                             
                    dtoG.setDescripcionLote((String)rs.getValueAt(i,"VAL_DESC_LOTE"));                                                   
                }                                                                                                                        
                 if(rs.getValueAt(i,"FEC_CREA")!=null){                                                                                  
                    dtoG.setFechaCreacion(new Date(((java.sql.Date)rs.getValueAt(i,"FEC_CREA")).getTime()));                             
                }                                                                                                                        
                 if(rs.getValueAt(i,"FEC_VENC_DESD")!=null){                                                                                  
                    dtoG.setFechaVencimientoDesde(new Date(((java.sql.Date)rs.getValueAt(i,"FEC_VENC_DESD")).getTime()));                             
                }                                                                                                                        
                 if(rs.getValueAt(i,"FEC_VENC_HAST")!=null){                                                                                  
                    dtoG.setFechaVencimientoHasta(new Date(((java.sql.Date)rs.getValueAt(i,"FEC_VENC_HAST")).getTime()));                             
                }                                                                                                                        
                 if(rs.getValueAt(i,"ESDE_OID_ESTA_DESC")!=null){                                                                        
                     dtoG.setOidEstatus(new Long(((BigDecimal)rs.getValueAt(i,"ESDE_OID_ESTA_DESC")).longValue()));                      
                }                                                                                                                        
                 if(rs.getValueAt(i,"DESCRIPCIONESTADO")!=null){                                                                         
                    dtoG.setEstatus((String)rs.getValueAt(i,"DESCRIPCIONESTADO"));                                                       
                }                                                                                                                        
                 if(rs.getValueAt(i,"MARC_OID_MARC")!=null){                                                                             
                     dtoG.setOidMarca(new Long(((BigDecimal)rs.getValueAt(i,"MARC_OID_MARC")).longValue()));                             
                }                                                                                                                        
                if(rs.getValueAt(i,"CANA_OID_CANA")!=null){                                                                              
                     dtoG.setOidCanal(new Long(((BigDecimal)rs.getValueAt(i,"CANA_OID_CANA")).longValue()));                             
                }                                                                                                                        
                 if(rs.getValueAt(i,"ACCE_OID_ACCE")!=null){                                                                             
                     dtoG.setOidAcceso(new Long(((BigDecimal)rs.getValueAt(i,"ACCE_OID_ACCE")).longValue()));                             
                }                                                                                                                        
                if(rs.getValueAt(i,"VAL_OBSE")!=null){                                                                                   
                     dtoG.setObservaciones((String)rs.getValueAt(i,"VAL_OBSE"));                                                         
                }                                                                                                                        
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
           }//for                                                                                                                        
       }                                                                                                                                                                                                                                                                                                                                                                                                               
                                                                                                                                         
     }//(rs!=null)                                                                                                                       
      UtilidadesLog.info("DAOAdam.recuperarCabecera(DTOOID dto): Salida");	                                                                 
      return dtoG;                                                                                                                     
     }                                                                                                                                   
                                                                                                                                         
                                                                                                                                         
          public RecordSet recuperarDetalle (DTOOID dto) throws MareException {                                                          
          UtilidadesLog.info("DAOAdam.recuperarDetalle(DTOOID dto): Entrada");
                                                                                                                                        
                                                                                                                                         
        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();                                                                                                
        consulta.append(" SELECT ");                                                                                                     
        consulta.append(" des.CLIE_OID_CLIE,");                                                                                          
        consulta.append(" clie.COD_CLIE, ");                                                                                             
        consulta.append(" clie.VAL_NOM1,");                                                                                              
        consulta.append(" clie.VAL_NOM2,");                                                                                              
        consulta.append(" clie.VAL_APE1,");                                                                                              
        consulta.append(" clie.VAL_APE2,");                                                                                              
        consulta.append(" adic.COD_EMPL, ");// NO LO ENCUENTRO                                                                            
        consulta.append(" tipo.OID_TIPO_CLIE,");                                                                                         
        consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v");                                                                   
        consulta.append(" WHERE v.VAL_OID=tipo.OID_TIPO_CLIE");                                                                          
        consulta.append(" AND v.IDIO_OID_IDIO = ? ");                                                                                    
        parametros.add(dto.getOidIdioma());                                                                                              
        consulta.append(" AND v.ATTR_NUM_ATRI = 1");                                                                                     
        consulta.append(" AND v.ATTR_ENTI = 'MAE_TIPO_CLIEN') AS DESCRIPCIONTIPO,");                                                     
        consulta.append(" subtipo.OID_SUBT_CLIE,");                                                                                      
        consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v");                                                                   
        consulta.append(" WHERE v.VAL_OID=subtipo.OID_SUBT_CLIE");                                                                       
        consulta.append(" AND v.IDIO_OID_IDIO = ? ");                                                                                    
        parametros.add(dto.getOidIdioma());                                                                                              
        consulta.append(" AND v.ATTR_NUM_ATRI = 1  ");                                                                                   
        consulta.append(" AND v.ATTR_ENTI = 'MAE_SUBTI_CLIEN') AS DESCRIPCIONSUBTIPO,");                                                 
        consulta.append(" adic.IMP_MONT_LINE_CRED, ");
        consulta.append(" 'LINEACREDITODISPONIBLE', ");  
        consulta.append(" des.IMP_DEUD_CALC,");                                                                                          
        consulta.append(" des.IMP_DEUD_ENVI_ADAM,");                                                                                     
        consulta.append(" des.IMP_DEUD_DESC ");                                                                                          
                                                                                                                                         
        consulta.append(" FROM ");                                                                                                       
                                                                                                                                         
        consulta.append(" INT_DESCU_PERSO_DETAL des, ");                                                                                 
        consulta.append(" MAE_CLIEN clie, ");                                                                                            
        consulta.append(" MAE_CLIEN_DATOS_ADICI adic,");                                                                                 
        consulta.append(" MAE_SUBTI_CLIEN subtipo,");                                                                                    
        consulta.append(" MAE_TIPO_CLIEN tipo,");                                                                                        
        consulta.append(" MAE_CLIEN_TIPO_SUBTI tiposub");                                                                                
                                                                                                                                         
        consulta.append(" WHERE des.DPEC_OID_DESC_PERS_CABE= ? ");                                                                       
        parametros.add(dto.getOid());                                           
        

        consulta.append("  AND clie.OID_CLIE = adic.CLIE_OID_CLIE ");
                                                                        
        consulta.append(" AND des.CTSU_OID_CLIE_TIPO_SUBT = tiposub.OID_CLIE_TIPO_SUBT  ");
        consulta.append(" AND tiposub.ticl_oid_tipo_clie = tipo.OID_TIPO_CLIE ");    
        consulta.append(" AND tiposub.sbti_oid_subt_clie = subtipo.OID_SUBT_CLIE ");    
        consulta.append(" AND tiposub.clie_oid_clie = clie.oid_clie ");        
                                                                                                                                         
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOADAM.recuperarDetalle: Exception",e);                                                           
            this.logSql(" DAOADAM.recuperarDetalle. SQL: ",consulta.toString(),parametros);                                              
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }//catch                                                                                                                           
                                                                                                                                         
                                                                                                                                         
       // if(rs!=null){                                                                                                                    
/*       if(!rs.esVacio()){                                                                                                                
            rs.addColumn("LINEACREDITODISPONIBLE");                                                                                      
       }                                                                                                                                 
*/
          UtilidadesLog.debug("RS que devolvemos RS " + rs);                                                                              
                                                                                                                                         
     //}//(rs!=null)                                                                                                                       
        UtilidadesLog.info("DAOAdam.recuperarDetalle(DTOOID dto): Salida");      	                                                                 
        return rs;                                                                                                                       
     }                                                                                                                                   
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
     public DTOIndError comprobarBatch (DTOINT dto)throws MareException {                                                                
        UtilidadesLog.info("DAOAdam.comprobarBatch(DTOINT dto): Entrada");                                                                                                                                         
                                                                                                                                         
        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();                                                                                                
                                                                                                                                         
        consulta.append(" SELECT IND_LOG_ERRO, NUM_LOTE ");                                                                              
        consulta.append(" FROM INT_HISTO_LOTES ");                                                                                       
        consulta.append(" WHERE NUM_LOTE = ? ");                                                                                         
         parametros.add(dto.getNumeroLote());                                                                                            
        consulta.append(" AND PAIS_OID_PAIS = ? ");                                                                                      
        parametros.add(dto.getOidPais());                                                                                                
        consulta.append(" AND COD_INTE = ? ");                                                                                           
        parametros.add(IGestorInterfaces.COD_INTERFAZ_ADA3 );                                                                            
                                                                                                                                         
                                                                                                                                         
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOADAM.comprobarBatch: Exception",e);                                                             
            this.logSql(" DAOADAM.comprobarBatch. SQL: ",consulta.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }//catch                                                                                                                           
        DTOIndError dtoIndError=null;                                                                                                    
        UtilidadesLog.debug("***DAOADAM.comprobarBatch  - salida");	                                                                 
        if(rs!=null){                                                                                                                    
       if(!rs.esVacio()){                                                                                                                
          dtoIndError=new DTOIndError();                                                                                                 
          for(int i=0;i<rs.getRowCount();i++){                                                                                           
            if(rs.getValueAt(i,"IND_LOG_ERRO")!=null){                                                                                   
                dtoIndError.setIndLog(new Long(((BigDecimal)rs.getValueAt(i,"IND_LOG_ERRO")).longValue()));                              
            }                                                                                                                            
            if(rs.getValueAt(i,"NUM_LOTE")!=null){                                                                                       
                 dtoIndError.setNumeroLote((String)rs.getValueAt(i,"NUM_LOTE"));                                                         
            }                                                                                                                            
                                                                                                                                         
           }//for                                                                                                                        
       }                                                                                                                                 
     }//(rs!=null)          
        UtilidadesLog.info("DAOAdam.comprobarBatch(DTOINT dto): Salida");
        return dtoIndError;                                                                                                              
     }                                                                                                                                   
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
      public RecordSet recuperarEstatus (DTOBelcorp dto)throws MareException {                                                           
       UtilidadesLog.info("DAOAdam.recuperarEstatus(DTOBelcorp dto): Entrada");                                                                                                                                  
                                                                                                                                         
        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();                                                                                                
                                                                                                                                         
                                                                                                                                         
        consulta.append(" SELECT OID_ESTA_DESC,");                                                                                       
                                                                                                                                         
        consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v");                                                                   
        consulta.append(" WHERE v.VAL_OID=es.OID_ESTA_DESC");                                                                            
        consulta.append(" AND v.IDIO_OID_IDIO = 1 ");                                                                                    
        consulta.append(" AND v.ATTR_NUM_ATRI = ? ");                                                                                    
        parametros.add(dto.getOidIdioma());                                                                                              
        consulta.append(" AND v.ATTR_ENTI = 'INT_ESTAD_DESCU') AS DESCRIPCION ");                                                        
                                                                                                                                         
        consulta.append(" FROM INT_ESTAD_DESCU  es ");                                                                                   
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOADAM.recuperarEstatus: Exception",e);                                                           
            this.logSql(" DAOADAM.recuperarEstatus. SQL: ",consulta.toString(),parametros);                                              
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }//catch                                                                                                                           
                                                                                                                                         
        UtilidadesLog.info("DAOAdam.recuperarEstatus(DTOBelcorp dto): Salida");	                                                                 
                                                                                                                                         
        return rs;                                                                                                                       
     }                                                                                                                                   
                                                                                                                                         
      public DTOEstatus obtenerEstatus (DTOOID dto)throws MareException {                                                                
       UtilidadesLog.info("DAOAdam.obtenerEstatus(DTOOID dto): Entrada");                                                                                                                                         
                                                                                                                                         
        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();                                                                                                
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
        consulta.append(" SELECT OID_ESTA_DESC,");                                                                                       
                                                                                                                                         
        consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v");                                                                   
        consulta.append(" WHERE v.VAL_OID=es.OID_ESTA_DESC");                                                                            
        consulta.append(" AND v.IDIO_OID_IDIO = ? ");                                                                                    
        parametros.add(dto.getOidIdioma());                                                                                              
        consulta.append(" AND v.ATTR_NUM_ATRI = 1 ");                                                                                    
        consulta.append(" AND v.ATTR_ENTI = 'INT_ESTAD_DESCU') AS DESCRIPCION ");                                                        
                                                                                                                                         
        consulta.append(" FROM INT_ESTAD_DESCU  es ");                                                                                   
        consulta.append(" WHERE OID_ESTA_DESC = ? ");                                                                                    
        parametros.add(dto.getOid());                                                                                                    
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
                                                                                                                                         
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{                                                                                                                             
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOADAM.obtenerEstatus: Exception",e);                                                             
            this.logSql(" DAOADAM.obtenerEstatus. SQL: ",consulta.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
      }//catch                                                                                                                           
        DTOEstatus dtoEstatus=null;                                                                                                      
        UtilidadesLog.debug("***DAOADAM.obtenerEstatus - salida");	                                                                 
        if(rs!=null){                                                                                                                    
       if(!rs.esVacio()){                                                                                                                
          dtoEstatus=new DTOEstatus();                                                                                                   
          for(int i=0;i<rs.getRowCount();i++){                                                                                           
            if(rs.getValueAt(i,"OID_ESTA_DESC")!=null){                                                                                  
                dtoEstatus.setOidEstatus(new Long(((BigDecimal)rs.getValueAt(i,"OID_ESTA_DESC")).longValue()));                          
                dtoEstatus.setCadena((String)rs.getValueAt(i,"DESCRIPCION"));                                                            
            }                                                                                                                            
           }//for                                                                                                                        
       }                                                                                                                                 
     }//(rs!=null)     
        UtilidadesLog.info("DAOAdam.obtenerEstatus(DTOOID dto): Salida");
        return dtoEstatus;                                                                                                               
     }                              

        // se cambia parametro de entrada al metodo del dao Inc 22280
        public void actualizarRegistrosLeidos (ArrayList ListaCliente, String numeroLote, Date fechaDesde, Date fechaHasta)throws MareException {                                                                
        UtilidadesLog.info("DAOAdam.actualizarRegistrosLeidos(ArrayList ListaCliente, String numeroLote, Date fechaDesde, Date fechaHasta): Entrada");
                                                                                                                                                                                         
/*
//Vamos a actualizar los registros correspondientes a el empleado para el que hemos 
generado el envio. Se recibe: ListaCliente y numeroLote 

update IngresoComisionesEIncentivos (INT) 
set numeroLote=numeroLote recibido 
where oidClienteTipoSubTipo in (select ClienteTipoSubTipo.oid 
from ClienteTipoSubTipo (MAE) 
where ClienteTipoSubTipo.oidCliente IN ListaCliente) 

 */
         ArrayList oidsClientes = new ArrayList();
         for (int i=0 ; i<ListaCliente.size() ; i++){
             if (((DTOEnvioComInc)ListaCliente.get(i)).getOidCliente()!=null){
                 oidsClientes.add(((DTOEnvioComInc)ListaCliente.get(i)).getOidCliente());
             }
         }
         StringBuffer consulta = new StringBuffer();
         Vector parametros = new Vector();
         consulta.append("UPDATE INT_INGRE_COMIS_INCEN i"); 
         consulta.append(" SET  ");
         consulta.append(" i.NUM_LOTE = ?  ");  
         parametros.add(numeroLote);
         consulta.append(" WHERE ");
        // consulta.append(" WHERE  i.CTSU_OID_CLIE_TIPO_SUBT  IN ( "+convertirArrayToString(ListaCliente) +" ) ");
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         if (fechaDesde!=null){
            java.sql.Date fechaD = new java.sql.Date(fechaDesde.getTime());
            String sFechaDesde = sdf.format(fechaD);   
            consulta.append("   i.FEC_INGR_COMI_INCE >= TO_DATE( ? ,'YYYY-MM-DD') AND  ");
            parametros.add(sFechaDesde);
         }
         if (fechaHasta!=null){
            java.sql.Date fechaH = new java.sql.Date(fechaHasta.getTime());
            String sFechaHasta = sdf.format(fechaH);   
            consulta.append("   i.FEC_INGR_COMI_INCE <= TO_DATE( ? ,'YYYY-MM-DD') AND ");
            parametros.add(sFechaHasta);
         }
         consulta.append("  i.ctsu_oid_clie_tipo_subt IN (");
         /*modificado 14/10/2005 mdolce*/
         /*este update esta mal, esta comparando oids de clientes contra oids de tiposubtipocliente*/
         consulta.append(" SELECT ts.oid_clie_tipo_subt ");
         consulta.append(" FROM mae_clien_tipo_subti ts ");
         consulta.append(" WHERE ts.clie_oid_clie IN (" +convertirArrayToString(oidsClientes) +" )");
         for(int i=0;i<oidsClientes.size();i++){
		 	 if(oidsClientes.get(i)!=null){
				//si es distinto de null lo pasamos a vector de la select.
				parametros.add(oidsClientes.get(i));
			 }
		 }
         //añadido por incidencia 22281
         consulta.append(" AND i.DCOI_OID_COMI_INCE = ? )");
         parametros.add(((DTOEnvioComInc)ListaCliente.get(0)).getOidIngresoComInc());
 		 // Se ejecuta la consulta 
 		 BelcorpService bs = UtilidadesEJB.getBelcorpService();
		 try {
			bs.dbService.executePreparedUpdate(consulta.toString(),parametros);
		 } catch (Exception e) {
			 UtilidadesLog.error("actualizarRegistrosLeidos: Exception",e);
			 this.logSql("actualizarRegistrosLeidos. SQL: ",consulta.toString(),
				parametros);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
		 }
		UtilidadesLog.info("DAOAdam.actualizarRegistrosLeidos(ArrayList ListaCliente, String numeroLote, Date fechaDesde, Date fechaHasta): Salida");
      }

      
       public RecordSet obtenerDatos(DTODescPers dtoe, RecordSet marcas)throws MareException {                                                                
       UtilidadesLog.info("DAOAdam.obtenerDatos(DTODescPers dtoe, RecordSet marcas): Entrada");      
        ArrayList arrayMarcas=null;
        Long tipo = null;
        Long subtipo = null; 
        Vector vectorTipoSubtipo = null;
        StringBuffer consulta2 = null;
        String metomarcas =null;
         arrayMarcas= new ArrayList();
         //comprobamos el recordSet de las marcas  
         if(marcas!=null){
         if(!marcas.esVacio()){
            int n= marcas.getRowCount();
            for(int i=0;i<n;i++){
                   arrayMarcas.add(new Long(((BigDecimal)marcas.getValueAt(i,"OID_MARC_SITU")).longValue()));
              }
            }
         }
         
                                                                                                                                         
        StringBuffer consulta = new StringBuffer();                                                                                      
        Vector parametros = new Vector();                                                                                                
                             
        //jrivas 19/10/2005
        consulta.append("select * from ( "); 
        
        consulta.append(" SELECT DISTINCT CLI.OID_CLIE, CLI.COD_CLIE, CLI.VAL_NOM1, ");     // Modificado por HRCS - Fecha 26/03/2007 - Incidencia Sicc20070161
        consulta.append("  CLI.VAL_NOM2, CLI.VAL_APE1, CLI.VAL_APE2, "); 
        consulta.append(" ADI.COD_EMPL, ");  
        consulta.append(" V.TICL_OID_TIPO_CLIE, "); 
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_TIPO_CLIEN' "); 
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = V.TICL_OID_TIPO_CLIE) DESC_TIPO, ");
        consulta.append(" V.SBTI_OID_SUBT_CLIE,  ");
        consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio  ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'MAE_SUBTI_CLIEN' "); 
        consulta.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = V.SBTI_OID_SUBT_CLIE) DESC_SUBTIPO, ");
        consulta.append(" ADI.IMP_MONT_LINE_CRED, ");
        consulta.append(" 'LINEACREDITODISPONIBLE', ");  
        //SIN COMA consulta.append(" ADI.IMP_MONT_LINE_CRED ");
        consulta.append("   NVL((SELECT SUM(MCC.IMP_PEND)    ");
        consulta.append("      FROM CCC_MOVIM_CUENT_CORRI MCC ");
        consulta.append("      WHERE MCC.CLIE_OID_CLIE = CLI.OID_CLIE ");
        consulta.append("      AND MCC.TICL_OID_TIPO_CLIE = V.TICL_OID_TIPO_CLIE ");
        consulta.append("      AND MCC.SBTI_OID_SUBT_CLIE = V.SBTI_OID_SUBT_CLIE ");
       
        
        if(marcas!=null){
           if(!marcas.esVacio()){
             metomarcas = this.convertirArrayToString(arrayMarcas);
               consulta.append(" AND MCC.MASI_OID_MARC_SITU IN ("+ metomarcas +")  ");
                for(int r=0;r<arrayMarcas.size();r++){
                   parametros.add((Long)arrayMarcas.get(r));
                }
            }
         }
       
        
         
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         if (dtoe.getFechaVencimientoDesde()!=null){
            java.sql.Date fechaD = new java.sql.Date(dtoe.getFechaVencimientoDesde().getTime());
            String sFechaDesde = sdf.format(fechaD);   
            consulta.append("      AND MCC.FEC_VENC >= TO_DATE( ? ,'YYYY-MM-DD')  ");
            parametros.add(sFechaDesde);
        }
        
         
         if (dtoe.getFechaVencimientoHasta()!=null){
            java.sql.Date fechaD1 = new java.sql.Date(dtoe.getFechaVencimientoHasta().getTime());
            String sFechaDesde1 = sdf.format(fechaD1);   
             consulta.append("   AND MCC.FEC_VENC <= TO_DATE( ? ,'YYYY-MM-DD')),0) AS SUM_PEND  ");
            parametros.add(sFechaDesde1);
        }
    
    
        //consulta.append(" ''
        consulta.append(" FROM V_MAE_TIPIF_CLIEN V, MAE_CLIEN CLI, MAE_CLIEN_DATOS_ADICI ADI ");
        consulta.append(" WHERE V.clie_oid_clie = CLI.OID_CLIE ");
        consulta.append(" AND CLI.OID_CLIE = ADI.CLIE_OID_CLIE ");
        consulta.append(" AND ADI.COD_EMPL IS NOT null ");
       consulta.append(" AND CLI.PAIS_OID_PAIS =  "+dtoe.getOidPais());
        //consulta.append(" --FILTRAR por parejas TIPO/SUBTIPO QUE VIENEN EN EL DTO ");
       
       //dtoDescPersonas.setListaTS(arrayTiposSubtipos); // arrayTiposSubtipos
          
      
        ArrayList arrayTiposSubtipos=dtoe.getListaTS();
        
        if(arrayTiposSubtipos!=null){
        
            int ni=arrayTiposSubtipos.size();
            if(ni!=0){
                consulta.append("      AND (  ");
               for(int j=0;j<ni;j++){
                   vectorTipoSubtipo=(Vector)arrayTiposSubtipos.get(j);
                   if(vectorTipoSubtipo!=null){
                       tipo = (Long)vectorTipoSubtipo.get(0);
                       subtipo =(Long)vectorTipoSubtipo.get(1);
                       if((tipo!=null) && (subtipo!=null)){
                            consulta.append("  (V.TICL_OID_TIPO_CLIE = ? ");
                             parametros.add(tipo);
                             UtilidadesLog.debug("tipo " +tipo );
                             consulta.append(" AND  V.SBTI_OID_SUBT_CLIE = ? )   OR  ");
                                                      
                             parametros.add(subtipo);
                             UtilidadesLog.debug("subtipo " +subtipo );
                       }
                   }//if(vectorTipo
                            
               }//for
           //quitamos el ultimo OR y añadimos el cierre del AND primero
             UtilidadesLog.debug("consulta " +consulta );
             UtilidadesLog.debug("parametros " +parametros );
             consulta2=new StringBuffer(consulta.substring(0,consulta.length()-6));
             UtilidadesLog.debug("consulta2 " +consulta2 );
            consulta2.append("  )  ");
          }

          
          
          UtilidadesLog.debug("consulta2 " +consulta2 );
        }
                                                                                                      
         //jrivas 19/10/2005
         consulta2.append(" ) where sum_pend > 0");                                                                                          
         
        BelcorpService bs = UtilidadesEJB.getBelcorpService();                                                                           
        RecordSet rs = null;                                                                                                             
        String codigoError = null;                                                                                                       
        try{   
            UtilidadesLog.debug("parametros " +parametros );
           rs =bs.dbService.executePreparedQuery(consulta2.toString(), parametros);                                                        
        }catch (Exception e) {                                                                                                           
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                                                                  
           	UtilidadesLog.error(" DAOADAM.obtenerDatos: Exception",e);                                                             
            this.logSql(" DAOADAM.obtenerDatos. SQL: ",consulta2.toString(),parametros);                                                
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));                                                   
        }//catch                                                                                                                           
/*            
            if(!rs.esVacio()){                                                                                                                
                rs.addColumn("LINEACREDITODISPONIBLE");                                                                                      
            }                 
*/
          UtilidadesLog.info("DAOAdam.obtenerDatos(DTODescPers dtoe, RecordSet marcas): Salida");      
          return rs;
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
    
    private  String convertirArrayToString(ArrayList array){
        UtilidadesLog.info("DAOAdam.convertirArrayToString(ArrayList array): Entrada");
        
		String retorno = "";
        if((array!=null)&&(array.size()!=0)){
			
        	StringBuffer sentencia = new StringBuffer("");
			for(int i=0;i<array.size();i++){
            		UtilidadesLog.debug("\n array[ ]=" + (array.get(i)));
            		if(array.get(i) !=null){
            		      	sentencia.append(" ?, ");
                	}
           	}
            	//Quitamos la coma y el espacio del final
            	retorno= sentencia.substring(0,sentencia.length()-2);
				UtilidadesLog.debug(retorno);
         
        }else{
            UtilidadesLog.info("DAOAdam.convertirArrayToString(ArrayList array): Salida");
			return "";
			}
		UtilidadesLog.info("DAOAdam.convertirArrayToString(ArrayList array): Salida");
		return retorno;
	}
    
    
}