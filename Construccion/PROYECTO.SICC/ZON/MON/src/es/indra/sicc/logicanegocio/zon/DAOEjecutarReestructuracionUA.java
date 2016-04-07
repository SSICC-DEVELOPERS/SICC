/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.logicanegocio.zon;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.zon.DTOCodUA;
import es.indra.sicc.dtos.zon.DTOEjecutarReestructuracionUAReg;

public class DAOEjecutarReestructuracionUA  {
  public DAOEjecutarReestructuracionUA() {
  }
  
  public DTOSalida recargaUAInferior(DTOUnidadAdministrativa dtoe, String user) throws MareException {
      UtilidadesLog.info("DAOEjecutarReestructuracionUA.recargaUAInferior(DTOUnidadAdministrativa dtoe):Entrada");
      BelcorpService bs;
      RecordSet respuesta;
      DTOSalida dtos = new DTOSalida();
      StringBuffer buf = new StringBuffer();

      try {
          bs = BelcorpService.getInstance();
      } catch(MareMiiServiceNotFoundException e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      try {
          if(dtoe.getOidSeccion()!=null){
              buf.append(" select terr.OID_TERR OID, terr.COD_TERR UAINFERIOR ");         
              buf.append(" from ZON_TERRI_ADMIN terrAdm, VCA_ZON_TERRI terr ");
              buf.append(" where terrAdm.ZSCC_OID_SECC = " + dtoe.getOidSeccion());  
              buf.append(" and terrAdm.TERR_OID_TERR = terr.OID_TERR ");
              buf.append(" and terrAdm.IND_BORR = 0 ");
              buf.append(" and terr.IND_BORR = 0 ");
              buf.append(" AND terr.COD_USUA = '"+ user +"' ");
              buf.append(" order by terr.COD_TERR ");
              
          } else  if(dtoe.getOidZona()!=null){
              buf.append(" select secc.OID_SECC OID, secc.COD_SECC UAINFERIOR ");         
              buf.append(" from VCA_ZON_SECCI secc ");
              buf.append(" where secc.ZZON_OID_ZONA = " + dtoe.getOidZona());  
              buf.append(" and secc.IND_ACTI = 1 ");
              buf.append(" and secc.IND_BORR = 0 ");
              buf.append(" AND secc.COD_USUA = '"+ user +"' ");
              buf.append(" order by secc.COD_SECC ");
              
          } else if(dtoe.getOidRegion()!=null){
              buf.append(" select zon.OID_ZONA OID, zon.COD_ZONA UAINFERIOR ");         
              buf.append(" from VCA_ZON_ZONA zon ");
              buf.append(" where zon.ZORG_OID_REGI = " + dtoe.getOidRegion());   
              buf.append(" and zon.IND_ACTI = 1 ");
              buf.append(" and zon.IND_BORR = 0 ");
              buf.append(" AND zon.COD_USUA = '"+ user +"' ");
              buf.append(" order by zon.COD_ZONA ");
              
          } else if(dtoe.getOidSGV()!=null){
              buf.append(" select reg.OID_REGI OID, reg.COD_REGI UAINFERIOR ");         
              buf.append(" from VCA_ZON_REGIO reg ");
              buf.append(" where reg.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
              buf.append(" and reg.IND_ACTI = 1 ");
              buf.append(" and reg.IND_BORR = 0 ");
              buf.append(" AND reg.COD_USUA = '"+ user +"' ");
              buf.append(" order by reg.COD_REGI ");
          }

          respuesta = bs.dbService.executeStaticQuery(buf.toString());
      } catch(Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      dtos.setResultado(respuesta);
      UtilidadesLog.info("DAOEjecutarReestructuracionUA.recargaUAInferior(DTOUnidadAdministrativa dtoe):Salida");
      return dtos;        
    }
    
  public DTOCodUA buscarCodUA(DTOCodUA dtoe) throws MareException {
    UtilidadesLog.info("DAOEjecutarReestructuracionUA.buscarCodUA(DTOCodUA dtoe): Entrada");   
    BelcorpService bs;
    RecordSet respuesta;
    DTOCodUA dtoCodUAOrigen = new DTOCodUA();
    StringBuffer buf = new StringBuffer();

    try {
        bs = BelcorpService.getInstance();
    } catch(MareMiiServiceNotFoundException e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }

    try {
        if(dtoe.getJerarquia().equals("oidSeccion")){
             buf.append(" select sgv.COD_SUBG_VENT||reg.COD_REGI||zon.COD_ZONA CODUAPADRE, ");
             buf.append(" sgv.COD_SUBG_VENT||reg.COD_REGI||zon.COD_ZONA||secc.COD_SECC CODUA ");         
             buf.append(" from ZON_SUB_GEREN_VENTA sgv, ZON_REGIO reg, ZON_ZONA zon,  ");
             buf.append(" ZON_SECCI secc ");
             buf.append(" where sgv.OID_SUBG_VENT = reg.ZSGV_OID_SUBG_VENT ");
             buf.append(" and reg.OID_REGI = zon.ZORG_OID_REGI ");          
             buf.append(" and zon.OID_ZONA = secc.ZZON_OID_ZONA ");
             buf.append(" and secc.OID_SECC = " + dtoe.getOidUA());
            
        } else if(dtoe.getJerarquia().equals("oidZona")){
             buf.append(" select sgv.COD_SUBG_VENT||reg.COD_REGI CODUAPADRE, ");
             buf.append(" sgv.COD_SUBG_VENT||reg.COD_REGI||zon.COD_ZONA CODUA ");         
             buf.append(" from ZON_SUB_GEREN_VENTA sgv, ZON_REGIO reg, ZON_ZONA zon ");
             buf.append(" where sgv.OID_SUBG_VENT = reg.ZSGV_OID_SUBG_VENT ");
             buf.append(" and reg.OID_REGI = zon.ZORG_OID_REGI ");          
             buf.append(" and zon.OID_ZONA = " + dtoe.getOidUA());
            
        } else if(dtoe.getJerarquia().equals("oidRegion")){
             buf.append(" select sgv.COD_SUBG_VENT CODUAPADRE, ");
             buf.append(" sgv.COD_SUBG_VENT||reg.COD_REGI CODUA ");         
             buf.append(" from ZON_SUB_GEREN_VENTA sgv, ZON_REGIO reg ");
             buf.append(" where sgv.OID_SUBG_VENT = reg.ZSGV_OID_SUBG_VENT ");
             buf.append(" and reg.OID_REGI = " + dtoe.getOidUA());
            
        } else if(dtoe.getJerarquia().equals("oidSGV")){
             buf.append(" select ' ' CODUAPADRE, ");
             buf.append(" sgv.COD_SUBG_VENT CODUA ");         
             buf.append(" from ZON_SUB_GEREN_VENTA sgv ");
             buf.append(" where sgv.OID_SUBG_VENT = " + dtoe.getOidUA());
        }

        respuesta = bs.dbService.executeStaticQuery(buf.toString());
    } catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    
    dtoCodUAOrigen = dtoe;    
    
    if(((String)respuesta.getValueAt(0,"CODUAPADRE")).equals(" ")){
        dtoCodUAOrigen.setCodUAPadre("");
    } else {
        dtoCodUAOrigen.setCodUAPadre((String)respuesta.getValueAt(0,"CODUAPADRE"));
    }
    dtoCodUAOrigen.setCodUA((String)respuesta.getValueAt(0,"CODUA"));
    
    UtilidadesLog.debug("dtoCodUAOrigen: " + dtoCodUAOrigen);
    
    UtilidadesLog.info("DAOEjecutarReestructuracionUA.buscarCodUA(DTOCodUA dtoe): Salida");
    return dtoCodUAOrigen;    
  }
  
  public RecordSet buscarClientesPorUA(DTOCodUA dtoe) throws MareException {
    UtilidadesLog.info("DAOEjecutarReestructuracionUA.buscarClientesPorUA(DTOCodUA dtoe): Entrada");   
    BelcorpService bs;
    RecordSet respuesta;
    StringBuffer buf = new StringBuffer();

    try {
        bs = BelcorpService.getInstance();
    } catch(MareMiiServiceNotFoundException e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }

    try {    
         buf.append(" select cli.COD_CLIE ");
         buf.append(" from MAE_CLIEN cli, MAE_CLIEN_UNIDA_ADMIN cliAdm, ZON_TERRI_ADMIN terrAdm, ");         
         buf.append(" ZON_SUB_GEREN_VENTA sgv, ZON_REGIO reg, ZON_ZONA zon, ZON_SECCI secc ");
         buf.append(" where cli.OID_CLIE = cliAdm.CLIE_OID_CLIE ");
         buf.append(" and cliAdm.IND_ACTI = 1 ");         
         buf.append(" and cliAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");
         buf.append(" and terrAdm.IND_BORR = 0 ");
         buf.append(" and terrAdm.ZSCC_OID_SECC = secc.OID_SECC ");
         
         if(dtoe.getJerarquia().equals("oidSeccion")){
            buf.append(" and terrAdm.TERR_OID_TERR = " + dtoe.getOidUA());
         }         
         
         if(dtoe.getJerarquia().equals("oidZona")){
            buf.append(" and secc.OID_SECC = " + dtoe.getOidUA());
         }
         
         buf.append(" and secc.ZZON_OID_ZONA = zon.OID_ZONA ");
         
         if(dtoe.getJerarquia().equals("oidRegion")){
            buf.append(" and zon.OID_ZONA = " + dtoe.getOidUA());
         }
         
         buf.append(" and zon.ZORG_OID_REGI = reg.OID_REGI ");
         
         if(dtoe.getJerarquia().equals("oidSGV")){
            buf.append(" and reg.OID_REGI = " + dtoe.getOidUA());
         }
         
         buf.append(" and reg.ZSGV_OID_SUBG_VENT  = sgv.OID_SUBG_VENT ");
        
         buf.append(" order by cli.COD_CLIE ");
    
        respuesta = bs.dbService.executeStaticQuery(buf.toString());
        
    } catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }    
    
    UtilidadesLog.debug("respuesta: " + respuesta);    
    
    UtilidadesLog.info("DAOEjecutarReestructuracionUA.buscarClientesPorUA(DTOCodUA dtoe): Salida");
    return respuesta;    
  }
  
  
   public HashMap obtenerUADestinos(ArrayList detalles) throws MareException {
      UtilidadesLog.info("DAOEjecutarReestructuracionUA.obtenerUAPadres(ArrayList detalle): Entrada");
      BelcorpService bs;
      RecordSet respuesta;
      HashMap UAPadres = new HashMap();
      StringBuffer buf = new StringBuffer();
      int cant = detalles.size();
      DTOEjecutarReestructuracionUAReg dtoEjecutarReestructuracionUAReg = null;
      String inOidUADestino = "";
      
      // Obtengo las UAs destino
      for(int i=0; i< cant; i++){
          dtoEjecutarReestructuracionUAReg = (DTOEjecutarReestructuracionUAReg)detalles.get(i);
      
          if(UAPadres.get(dtoEjecutarReestructuracionUAReg.getOidUADestTrasv())==null){
              UtilidadesLog.debug("UA Destino: " + dtoEjecutarReestructuracionUAReg.getOidUADestTrasv());
              UAPadres.put(dtoEjecutarReestructuracionUAReg.getOidUADestTrasv().toString(), "");
              
              inOidUADestino = inOidUADestino + "," + dtoEjecutarReestructuracionUAReg.getOidUADestTrasv();
          }
      }

      try {
          bs = BelcorpService.getInstance();
      } catch(MareMiiServiceNotFoundException e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      try {
          if(dtoEjecutarReestructuracionUAReg.getJerarquia().equals("oidSeccion")){
             buf.append(" select secc.OID_SECC UA, ");
             buf.append(" sgv.COD_SUBG_VENT||reg.COD_REGI||zon.COD_ZONA||secc.COD_SECC CODUA ");         
             buf.append(" from ZON_SUB_GEREN_VENTA sgv, ZON_REGIO reg, ZON_ZONA zon,  ");
             buf.append(" ZON_SECCI secc ");
             buf.append(" where sgv.OID_SUBG_VENT = reg.ZSGV_OID_SUBG_VENT ");
             buf.append(" and reg.OID_REGI = zon.ZORG_OID_REGI ");          
             buf.append(" and zon.OID_ZONA = secc.ZZON_OID_ZONA ");
             buf.append(" and secc.OID_SECC IN (" + inOidUADestino.substring(1) + ") ");
            
        } else if(dtoEjecutarReestructuracionUAReg.getJerarquia().equals("oidZona")){
             buf.append(" select zon.OID_ZONA UA, ");
             buf.append(" sgv.COD_SUBG_VENT||reg.COD_REGI||zon.COD_ZONA CODUA ");         
             buf.append(" from ZON_SUB_GEREN_VENTA sgv, ZON_REGIO reg, ZON_ZONA zon ");
             buf.append(" where sgv.OID_SUBG_VENT = reg.ZSGV_OID_SUBG_VENT ");
             buf.append(" and reg.OID_REGI = zon.ZORG_OID_REGI ");          
             buf.append(" and zon.OID_ZONA IN (" + inOidUADestino.substring(1) + ") ");
            
        } else if(dtoEjecutarReestructuracionUAReg.getJerarquia().equals("oidRegion")){
             buf.append(" select reg.OID_REGI UA, ");
             buf.append(" sgv.COD_SUBG_VENT||reg.COD_REGI CODUA ");         
             buf.append(" from ZON_SUB_GEREN_VENTA sgv, ZON_REGIO reg ");
             buf.append(" where sgv.OID_SUBG_VENT = reg.ZSGV_OID_SUBG_VENT ");
             buf.append(" and reg.OID_REGI IN (" + inOidUADestino.substring(1) + ") ");
            
        } else if(dtoEjecutarReestructuracionUAReg.getJerarquia().equals("oidSGV")){
             buf.append(" select sgv.OID_SUBG_VENT UA, ");
             buf.append(" sgv.COD_SUBG_VENT CODUA ");         
             buf.append(" from ZON_SUB_GEREN_VENTA sgv ");
             buf.append(" where sgv.OID_SUBG_VENT IN (" + inOidUADestino.substring(1) + ") ");
        }

          respuesta = bs.dbService.executeStaticQuery(buf.toString());
      } catch(Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      int cantR = respuesta.getRowCount();
      
      for(int j=0; j < cantR; j++){
      
          UAPadres.put(((BigDecimal)respuesta.getValueAt(j,"UA")).toString(), 
                       (String)respuesta.getValueAt(j,"CODUA"));
      }

      UtilidadesLog.info("DAOEjecutarReestructuracionUA.obtenerUAPadres(ArrayList detalle): Salida");
      return UAPadres;
  }
}