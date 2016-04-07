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
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.zon.DTOEjecutarReterritorializacionCab;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DAOEjecutarReterritorializacion  {
  public DAOEjecutarReterritorializacion() {
  }
  
  public DTOSalida recuperarNivelesSocioEconomicosBelcorp() throws MareException {
      UtilidadesLog.info("DAOEjecutarReterritorializacion.recuperarNivelesSocioEconomicosBelcorp():Entrada");
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
          buf.append("select COD_NIVE_SOCI_ECON_BELC, DES_NIVE_SOCI_ECON_BELC ");         
          buf.append("from SEG_NIVEL_SOCIO_ECONO_BELCO");
          buf.append(" order by DES_NIVE_SOCI_ECON_BELC");

          respuesta = bs.dbService.executeStaticQuery(buf.toString());
      } catch(Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      dtos.setResultado(respuesta);
      UtilidadesLog.info("DAOEjecutarReterritorializacion.recuperarNivelesSocioEconomicosBelcorp():Salida");
      return dtos;        
    }
    
    
    public DTOSalida recargaConsultoras(DTOOID dtoe) throws MareException {
      UtilidadesLog.info("DAOEjecutarReterritorializacion.recargaConsultoras(DTOOID dtoe):Entrada");
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
          buf.append("SELECT  cli.OID_CLIE, cli.COD_CLIE ");         
          buf.append("FROM MAE_CLIEN_UNIDA_ADMIN cliAdm, MAE_CLIEN cli, ZON_TERRI_ADMIN terrAdm ");
          buf.append("where cli.OID_CLIE = cliAdm.CLIE_OID_CLIE ");
          buf.append("and cliAdm.IND_ACTI = 1 ");
          buf.append("and cliAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");
          buf.append("and terrAdm.IND_BORR = 0 ");
          buf.append("and terrAdm.TERR_OID_TERR = " + dtoe.getOid());
          buf.append(" order by cli.COD_CLIE ");

          respuesta = bs.dbService.executeStaticQuery(buf.toString());
      } catch(Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      dtos.setResultado(respuesta);
      UtilidadesLog.info("DAOEjecutarReterritorializacion.recargaConsultoras(DTOOID dtoe):Salida");
      return dtos;        
    }
    
    public DTOString buscarUAPadre(DTOOID dtoe) throws MareException {
      UtilidadesLog.info("MONEjecutarReterritorializacion.buscarUAPadre(DTOOID dtoe): Entrada");
      BelcorpService bs;
      RecordSet respuesta;
      DTOString dtoString = new DTOString();
      StringBuffer buf = new StringBuffer();

      try {
          bs = BelcorpService.getInstance();
      } catch(MareMiiServiceNotFoundException e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      try {
          buf.append("select sgv.COD_SUBG_VENT||reg.COD_REGI||zon.COD_ZONA||secc.COD_SECC UAPADRE ");         
          buf.append("from ZON_SUB_GEREN_VENTA sgv, ZON_REGIO reg, ZON_ZONA zon,  ");
          buf.append("ZON_SECCI secc, ZON_TERRI_ADMIN terrAdm ");
          buf.append("where sgv.OID_SUBG_VENT = reg.ZSGV_OID_SUBG_VENT ");
          buf.append("and reg.OID_REGI = zon.ZORG_OID_REGI ");          
          buf.append("and zon.OID_ZONA = secc.ZZON_OID_ZONA ");
          buf.append("and secc.OID_SECC = terrAdm.ZSCC_OID_SECC ");
          buf.append("and terrAdm.TERR_OID_TERR =  " + dtoe.getOid());

          respuesta = bs.dbService.executeStaticQuery(buf.toString());
      } catch(Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      dtoString.setCadena((String)respuesta.getValueAt(0,"UAPADRE"));
      UtilidadesLog.info("MONEjecutarReterritorializacion.buscarUAPadre(DTOOID dtoe): Salida");
      return dtoString;
  }
  
  public HashMap obtenerUAPadres(ArrayList detalles) throws MareException {
      UtilidadesLog.info("MONEjecutarReterritorializacion.obtenerUAPadres(ArrayList detalle): Entrada");
      BelcorpService bs;
      RecordSet respuesta;
      HashMap UAPadres = new HashMap();
      StringBuffer buf = new StringBuffer();
      int cant = detalles.size();
      DTORezonificacionRegistro dtoRezonificacionRegistro = null;
      String inCodTerr = "";
      
      // Obtengo los territorios
      for(int i=0; i< cant; i++){
          dtoRezonificacionRegistro = (DTORezonificacionRegistro)detalles.get(i);
      
          if(UAPadres.get(dtoRezonificacionRegistro.getDatoOrigen2())==null){
              UtilidadesLog.debug("Terr Destino: " + dtoRezonificacionRegistro.getDatoOrigen2());
              UAPadres.put(dtoRezonificacionRegistro.getDatoOrigen2().toString(), "");
              
              inCodTerr = inCodTerr + "," + dtoRezonificacionRegistro.getDatoOrigen2();
          }
      }

      try {
          bs = BelcorpService.getInstance();
      } catch(MareMiiServiceNotFoundException e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      try {
          buf.append("select terr.COD_TERR, sgv.COD_SUBG_VENT||reg.COD_REGI||zon.COD_ZONA||secc.COD_SECC UAPADRE ");         
          buf.append("from ZON_SUB_GEREN_VENTA sgv, ZON_REGIO reg, ZON_ZONA zon, ");
          buf.append("ZON_SECCI secc, ZON_TERRI_ADMIN terrAdm, ZON_TERRI terr ");
          buf.append("where sgv.OID_SUBG_VENT = reg.ZSGV_OID_SUBG_VENT ");
          buf.append("and reg.OID_REGI = zon.ZORG_OID_REGI ");          
          buf.append("and zon.OID_ZONA = secc.ZZON_OID_ZONA ");
          buf.append("and secc.OID_SECC = terrAdm.ZSCC_OID_SECC ");
          buf.append("and terrAdm.TERR_OID_TERR =  terr.OID_TERR ");
          buf.append("and terr.COD_TERR IN (" + inCodTerr.substring(1) + ") ");

          respuesta = bs.dbService.executeStaticQuery(buf.toString());
      } catch(Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      int cantR = respuesta.getRowCount();
      
      for(int j=0; j < cantR; j++){
      
          UAPadres.put(((BigDecimal)respuesta.getValueAt(j,"COD_TERR")).toString(), 
                       (String)respuesta.getValueAt(j,"UAPADRE"));
      }

      UtilidadesLog.info("MONEjecutarReterritorializacion.obtenerUAPadres(ArrayList detalle): Salida");
      return UAPadres;
  }
  
public void obtenerCodCab(DTOEjecutarReterritorializacionCab cab) throws MareException {
      UtilidadesLog.info("MONEjecutarReterritorializacion.obtenerCodCab(DTOEjecutarReterritorializacionCab cab): Entrada");
      
      BelcorpService bs;
      RecordSet respuesta;
      StringBuffer buf = new StringBuffer();

      try {
          bs = BelcorpService.getInstance();
      } catch(MareMiiServiceNotFoundException e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      try {
          buf.append(" select  pais.COD_PAIS, marca.COD_MARC, canal.COD_CANA, ");
          buf.append(" tipoPer.COD_TIPO_PERI, perCor.COD_PERI ");    
          buf.append(" from CRA_PERIO per, SEG_PERIO_CORPO perCor, SEG_TIPO_PERIO tipoPer, ");
          buf.append(" SEG_PAIS pais, SEG_MARCA marca, SEG_CANAL canal  ");
          buf.append(" where per.OID_PERI = " + cab.getOidPeriodoInicio());
          buf.append(" and per.PERI_OID_PERI = perCor.OID_PERI ");
          buf.append(" and perCor.TIPE_OID_TIPO_PERI = tipoPer.OID_TIPO_PERI ");
          buf.append(" and pais.OID_PAIS = " + cab.getOidPais());
          buf.append(" and marca.OID_MARC = " + cab.getOidMarca());
          buf.append(" and canal.OID_CANA = " + cab.getOidCanal());

          respuesta = bs.dbService.executeStaticQuery(buf.toString());
      } catch(Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      cab.setCodPais((String)respuesta.getValueAt(0,"COD_PAIS"));
      cab.setCodMarca((String)respuesta.getValueAt(0,"COD_MARC"));
      cab.setCodCanal((String)respuesta.getValueAt(0,"COD_CANA"));      
      cab.setCodTipoPeriodo((String)respuesta.getValueAt(0,"COD_TIPO_PERI"));
      cab.setCodPeriodo((String)respuesta.getValueAt(0,"COD_PERI"));
      
      UtilidadesLog.info("MONEjecutarReterritorializacion.obtenerCodCab(DTOEjecutarReterritorializacionCab cab): Salida");   
   }
  
  public String fechaHora(Date fecha) throws Exception {

     SimpleDateFormat formatter = new SimpleDateFormat ("yyyy.MM.dd 'at' HH:mm:ss");
     
     String dateString = formatter.format(fecha);

     String anio = dateString.substring(0,4);        
     String mes  = dateString.substring(5,7);
     String dia = dateString.substring(8,10);

     int index = dateString.indexOf(":");

     String hora = dateString.substring((index-2),index);         
     String minutos  = dateString.substring((index+1),(index+3));
     String segundos = dateString.substring((index+4),(index+6));

     String fechaHora = dia + mes + anio + hora + minutos + segundos;
     
     return  fechaHora;
  }  
  
  public String fechaActualizacion(Date fecha) throws Exception {

     SimpleDateFormat formatter = new SimpleDateFormat ("yyyy.MM.dd 'at' HH:mm:ss");
     
     String dateString = formatter.format(fecha);

     String anio = dateString.substring(0,4);        
     String mes  = dateString.substring(5,7);
     String dia = dateString.substring(8,10);

     String fechaS = anio + mes + dia;
     
     return  fechaS;
  }  
  

      /**
       * Creado por migración a EJB 3.0
       * Sustituye al viejo método finder TerritorioLocalHome.findByCodigoPaisBorradoRTZ
       * 
       * @author dmorello
       * @since 11-ago-2008
       */
      public RecordSet buscarTerritorioPorCodigoPaisBorradoRTZ(Long codTerritorio, Long oidPais,
            String fechaAct) throws MareException {
            
        UtilidadesLog.info("DAOEjecutarReterritorializacion.buscarTerritorioPorCodigoPaisBorradoRTZ("
                + "Long codTerritorio, Long oidPais, String fechaAct): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT * ");
        query.append("   FROM zon_terri terr ");
        query.append("  WHERE terr.pais_oid_pais = ").append(oidPais);
        query.append("    AND terr.cod_terr = ").append(codTerritorio);
        query.append("    AND terr.ind_borr = 1 ");
        query.append("    AND TRUNC (TO_DATE ('").append(fechaAct).append("', 'dd/mm/yyyy')) = TRUNC (terr.fec_rtz)");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        UtilidadesLog.info("DAOEjecutarReterritorializacion.buscarTerritorioPorCodigoPaisBorradoRTZ("
                + "Long codTerritorio, Long oidPais, String fechaAct): Salida");
                
        return rs;
      }
      
      /**
       * Creado por migración a EJB 3.0
       * Sustituye al viejo método finder TerritorioAdministrativoLocalHome.findBySeccionTerritorioBorrRTZ
       * 
       * @author dmorello
       * @since 11-ago-2008
       */
      public RecordSet obtenerTerriAdminPorSeccionTerritorioBorrRTZ(Long oidSeccion, Long oidTerritorio, String fechaAct)
            throws MareException {
      
        UtilidadesLog.info("DAOEjecutarReterritorializacion.obtenerTerriAdminPorSeccionTerritorioBorrRTZ("
              + "Long oidSeccion, Long oidTerritorio, String fechaAct): Entrada");
                  
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT * ");
        query.append("   FROM zon_terri_admin tad ");
        query.append("  WHERE tad.zscc_oid_secc = ").append(oidSeccion);
        query.append("    AND tad.terr_oid_terr = ").append(oidTerritorio);
        query.append("    AND tad.ind_borr = 1 ");
        query.append("    AND TRUNC (TO_DATE ('").append(fechaAct).append("', 'dd/mm/yyyy')) = TRUNC (tad.fec_rtz) ");
          
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        UtilidadesLog.info("DAOEjecutarReterritorializacion.obtenerTerriAdminPorSeccionTerritorioBorrRTZ("
                + "Long oidSeccion, Long oidTerritorio, String fechaAct): Salida");
                  
        return rs;
      }
        
}