package es.indra.sicc.logicanegocio.intsys;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.Date;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.text.SimpleDateFormat;


public class DAOCOR 
{
    public DAOCOR()
    {
    }
    public DTOOID buscarDatosRepartidor (Long oidPais, String docuIdent) throws MareException {

       UtilidadesLog.info("DAOCOR.buscarDatosRepartidor(Long oidPais, String docuIdent): Entrada");
    
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        

      
        
        consulta.append(" SELECT c.OID_CLIE, c.COD_CLIE ");           
        consulta.append(" FROM MAE_CLIEN c, MAE_CLIEN_IDENT ci ");    
        consulta.append(" WHERE  c.PAIS_OID_PAIS= ? "); 
        parametros.add(oidPais);
        consulta.append(" AND ci.NUM_DOCU_IDEN= ? ");
        parametros.add(docuIdent);
        consulta.append(" AND ci.VAL_IDEN_DOCU_PRIN= ? ");  
        parametros.add(new Long(1));
        consulta.append(" AND C.OID_CLIE=CI.CLIE_OID_CLIE ");         
        consulta.append(" ORDER BY OID_CLIE, COD_CLIE ");              
              
        
       

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
       DTOOID dto = null;
     if(rs!=null){
       if(!rs.esVacio()){
            
            dto = new DTOOID();
             if(rs.getValueAt(0,"OID_CLIE")!=null){
              dto.setOid(new Long(((BigDecimal)rs.getValueAt(0,"OID_CLIE")).longValue()));
            }
         
       }//(!rs.esVacio()
     }//(rs!=null)
      //Con los registros obtenidos, se crea una lista de objetos DTOPeriodo y se retorna.
        UtilidadesLog.info("DAOCOR.buscarDatosRepartidor(Long oidPais, String docuIdent): Salida");
        return dto;
     }    
      public DTOOID buscarPeriodoAsociado(Long oidTipoSolicitud, Long oidCliente, Long oidSociedad, Long numPedido) throws MareException
    {
        UtilidadesLog.info("DAOCOR.buscarPeriodoAsociado(Long oidTipoSolicitud, Long oidCliente, Long oidSociedad, Long numPedido): Entrada");
        
        /*//hacemos la consulta 
        Acceder a la entidad SolicitudCabecera (PED): 
        filtrando por: // los parametros recibidos 
        SolicitudCabecera.oidTipoSolicitudPais= oidTipoSolicitud 
        SolicitudCabecera.oidCliente= oidCliente 
        SolicitudCabecera.oidSociedad= oidSociedad 
        SolicitudCabecera.numeroSolicitud=numPed 

        Obteniendo: 
        SolicitudCabecera.oid 

        Con el primer registro obtenido devolver un objeto del tipo DTOOid con el atributo: 
        - oid=SolicitudCabecera.oid */
        
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        query.append(" SELECT S.OID_SOLI_CABE ");
        query.append(" FROM PED_SOLIC_CABEC S ");
        query.append(" WHERE S.TSPA_OID_TIPO_SOLI_PAIS = ? ");
        parametros.add(oidTipoSolicitud);
        query.append(" AND S.CLIE_OID_CLIE = ? ");
        parametros.add(oidCliente);
        query.append(" AND S.SOCI_OID_SOCI = ? ");
        parametros.add(oidSociedad);
        query.append(" AND S.VAL_NUME_SOLI = ? ");
        parametros.add(numPedido);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
                                                                  
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(query.toString(), parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerOperaciones: Exception",e);
            this.logSql(" obtenerOperaciones. SQL: ",query.toString(),
            parametros);                                                     
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        DTOOID dtoOid = null;
         if(resultado!=null){
            if(!resultado.esVacio()){
               
                dtoOid = new DTOOID();
                dtoOid.setOid(new Long (((BigDecimal)resultado.getValueAt(0,0)).longValue()));
            }
         }
        
        UtilidadesLog.info("DAOCOR.buscarPeriodoAsociado(Long oidTipoSolicitud, Long oidCliente, Long oidSociedad, Long numPedido): Salida");
        return dtoOid;
    }
      public DTOOID buscarNumeroSolicitud(Date fechaFacturacion, Integer numSecuencia, Long oidZona) throws MareException
    {
        UtilidadesLog.info("DAOCOR.buscarNumeroSolicitud(Date fechaFacturacion, Integer numSecuencia, Long oidZona): Entrada");
        /*Debemos obtener el numero de la solicitud que cumple con los criterios recibidos por el método 
        Acceder a las entidades SolicitudCabecera (PED), SolicitudCabeceraSecuencia (PED) haciendo join entre ellas 
        filtrando por: 
        SolicitudCabecera.fechaFacturacion=fechaFacturacion 
        SolicitudCabecera.oidZona=oidZona 
        SolicitudCabeceraSecuencia.numeroSecuenciaFacturacionDiaria=numSecuencia 
        y la join: SolicitudCabecera con SolicitudCabeceraSecuencia 
        Obtener: 
        SolicitudCabecera.oid 

        Devolver un objeto del tipo DTOOid con el primer registro que se encuentre en la consulta 
        DTOOid.oid=SolicitudCabecera.oid*/
        
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        query.append(" SELECT SC.OID_SOLI_CABE  ");
        query.append(" FROM PED_SOLIC_CABEC SC, PED_SOLIC_CABEC_SECUE SCS  ");
        query.append(" WHERE SC.ZZON_OID_ZONA = ?  ");
        parametros.add(oidZona);
        if(fechaFacturacion != null){   
            java.sql.Date fechaDesde =new java.sql.Date(fechaFacturacion.getTime());
            String sFechaDesde = sdf.format(fechaDesde);                                                          
            query.append(" AND SC.FEC_FACT =  TO_DATE( ? ,'YYYY-MM-DD')  "); 
            parametros.add(sFechaDesde);
        }
        query.append(" AND SCS.NUM_SECU_FACT_DIAR = ? ");
        parametros.add(numSecuencia);
        query.append(" AND SC.OID_SOLI_CABE = SCS.SOCA_OID_SOLI_CABE ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(query.toString(), parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerOperaciones: Exception",e);
            this.logSql(" obtenerOperaciones. SQL: ",query.toString(),
            parametros);                                                     
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        DTOOID dtoOid = null;
         if(resultado!=null){
            if(!resultado.esVacio()){
               
                dtoOid = new DTOOID();
                dtoOid.setOid(new Long (((BigDecimal)resultado.getValueAt(0,0)).longValue()));
            }
         }
        
        UtilidadesLog.info("DAOCOR.buscarNumeroSolicitud(Date fechaFacturacion, Integer numSecuencia, Long oidZona): Salida");
        return dtoOid;
    }
     public DTOOID obtenerZona(String codZona, String codMarca, Long oidPais) throws MareException
    {
        UtilidadesLog.info("DAOCOR.obtenerZona(String codZona, String codMarca, Long oidPais): Entrada");
        
        /*Debemos obtener el oidZona para la marca, el pais, el codigo de zona recibido por el método 
        Acceder a Zona (ZON), Canal (SEG), Marca (SEG) haciendo una join entre ellas 
        filtrando por: 
        Zona.codigo=codZona 
        Zona.oidPais=oidPais 
        Zona.indicadorActivo=1 
        Zona.indicadorBorrado=0 
        Marca.codigo=codMarca 
        Canal.codigo=ConstantesSEG.COD_CANAL_VD 
        y los de las join: Zona con Marca 
        Zona con Canal 
        Obtener: 
        Zona.oid 

        Devolver un objeto del tipo DTOOid con el registro recuperado 
        DTOOid.oid=Zona.oid*/

        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        query.append(" SELECT Z.OID_ZONA  ");
        query.append(" FROM ZON_ZONA Z, SEG_CANAL C, SEG_MARCA M  ");
        query.append(" WHERE Z.COD_ZONA = ?  ");
        parametros.add(codZona);
        query.append(" AND Z.PAIS_OID_PAIS = ?  ");
        parametros.add(oidPais);
        query.append(" AND Z.IND_ACTI = ?  ");
        parametros.add(new Long (1));//ojo aqui??
        query.append(" AND Z.IND_BORR = ?  ");
        parametros.add(new Long (0));
        query.append(" AND M.COD_MARC = ?  ");
        parametros.add(codMarca);
        query.append(" AND C.COD_CANA = ?  ");
        parametros.add(ConstantesSEG.COD_CANAL_VD);//incidencia 13288
        query.append(" AND Z.CANA_OID_CANA = C.OID_CANA  ");
        query.append(" AND Z.MARC_OID_MARC = M.OID_MARC  ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(query.toString(), parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerOperaciones: Exception",e);
            this.logSql(" obtenerOperaciones. SQL: ",query.toString(),
            parametros);                                                     
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        DTOOID dtoOid = null;
        if(resultado!=null){
            if(!resultado.esVacio()){
               
                dtoOid = new DTOOID();
                dtoOid.setOid(new Long (((BigDecimal)resultado.getValueAt(0,0)).longValue()));
            }
        }
        UtilidadesLog.info("DAOCOR.obtenerZona(String codZona, String codMarca, Long oidPais): Salida");
        return dtoOid;
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

    public DTOOID comprobarExistenciaRegistro(Long oidSolicitud) throws MareException
    {
        UtilidadesLog.info("DAOCOR.comprobarExistenciaRegistro(Long oidSolicitud): Entrada");
        
        /*vamos a comprobar si existe algun registro con los datos que tenemos. 
        Accedemos a la entidad SeguimientoPedidosINT (INT) 
        filtrando por: //el atributo recibido 
        SeguimientoPedidosINT.oidSolicitud 
        obteniendo: 
        SeguimientoPedidosINT.oid 

        Se devuelve un objeto del tipo DTOOid con el atributo: 
        DTOOid.oid=SeguimientoPedidosINT.oid
        */
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet resultado = new RecordSet();
        String codigoError = null;
        
        query.append(" SELECT SP.OID_SEGU_PEDI ");
        query.append(" FROM INT_SEGUI_PEDID SP ");
        query.append(" WHERE SP.SOCA_OID_SOLI_CABE = ? ");
        parametros.add(oidSolicitud);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
                                                                       
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(query.toString(), parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerOperaciones: Exception",e);
            this.logSql(" obtenerOperaciones. SQL: ",query.toString(),
            parametros);                                                     
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        DTOOID dtoOid = null;
        if(resultado!=null){
            if(!resultado.esVacio()){
               
                dtoOid = new DTOOID();
                dtoOid.setOid(new Long (((BigDecimal)resultado.getValueAt(0,0)).longValue()));
            }
        }
        
        UtilidadesLog.info("DAOCOR.comprobarExistenciaRegistro(Long oidSolicitud): Salida");
        return dtoOid;
    }
    
    
    
}
    
            /* Operation DTOOid buscarDatosRepartidor (Long oidPais, String docuIdent), in Class DAOCOR
                    
                    Documentation
                    //Se trata de recuperar el codigo de cliente que corresponde al documento de identidad del repartidor recibido en la interface. 
                    Acceder a las entidades ClienteIdentificacion (MAE), Cliente (MAE) haciendo join entre ellas 
                    filtrando por: //los parámetros recibidos 
                    Cliente.oidPais=oidPais 
                    ClienteIdentificacion.numeroDocumentoIdentidad=docuIdent 
                    ClienteIdentificacion.IdentificadorDocumentoPrincipal=1 
                    obtener: 
                    Cliente.oid 
                    Cliente.codigo 
                    ordenado por Cliente.codigo 
                    
                    Con el primer registro obtenido, devolver un objeto DTOOid con el atributo: 
                    DTOOid.oid=Cliente.oid 
                    
                    }
                    */