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
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Vector;
import java.math.BigDecimal;

/**
 * @author Emilio Noziglia
 * @since 29/11/2005
 * @reference SICC-DMCO-INTSAB-GCC-001-003
 */ 
 
public class DAOINTRET  {

  public DAOINTRET() {
  }

  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param String codigoPais  
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad SEG Pais o lanza una excepción de 
   *              Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerPais(String codigoPais) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerPais(String codigoPais): Entrada");

      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      Long oidPais = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT p.OID_PAIS ");
      consulta.append(" FROM seg_pais p ");

      if (codigoPais != null && !codigoPais.equals("")) {
          consulta.append(" WHERE p.COD_PAIS = ? ");
          parametros.add(codigoPais);
          UtilidadesLog.debug("codigoPais:"+codigoPais);          
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerPais: El codigo de pais vino a null o vacio.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));      
      }

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerPais: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidPais = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerPais: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerPais(String codigoPais): Salida");
      return oidPais;
  }  
  
  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param Long oidPais, String codigoMarca, String codigoCanal, String codigoPeriodo
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad CRA Periodo o lanza una excepción
   *              de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerPeriodo(Long oidPais, String codigoMarca, String codigoCanal, String codigoPeriodo) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerPeriodo(Long oidPais, String codigoMarca, String codigoCanal, String codigoPeriodo): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidPeriodo = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT p.OID_PERI ");
      consulta.append(" FROM cra_perio p, seg_marca m, seg_canal c, seg_perio_corpo pc ");
      consulta.append(" WHERE p.MARC_OID_MARC = m.OID_MARC ");
      consulta.append(" AND p.CANA_OID_CANA = c.OID_CANA ");
      consulta.append(" AND p.PERI_OID_PERI = pc.OID_PERI ");
      consulta.append(" AND p.PAIS_OID_PAIS = "+oidPais+" ");
      consulta.append(" AND pc.COD_PERI = '"+codigoPeriodo+"' ");
      consulta.append(" AND m.COD_MARC = '"+codigoMarca+"' ");
      consulta.append(" AND c.COD_CANA = '"+codigoCanal+"' ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerPeriodo: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidPeriodo = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerPeriodo: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerPeriodo(Long oidPais, String codigoMarca, String codigoCanal, String codigoPeriodo): Salida");
      return oidPeriodo;
  }    
  
  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param Long oidPais, String codigoSubacceso, String numeroSolicitud, String codigoAcceso, String codigoCanal
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad PED Cabecera Solicitud o lanza 
   *              una excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerSolicitudCabecera(Long oidPais, String codigoSubacceso, String numeroSolicitud, String codigoAcceso, String codigoCanal) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerSolicitudCabecera(Long oidPais, String codigoSubacceso, String numeroSolicitud, String codigoAcceso, String codigoCanal): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidSoliCabe = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT p.OID_SOLI_CABE ");
      consulta.append(" FROM ped_solic_cabec p, seg_canal c, seg_acces a, seg_subac s ");
      consulta.append(" WHERE p.SBAC_OID_SBAC = s.OID_SBAC ");
      consulta.append(" AND s.ACCE_OID_ACCE = a.OID_ACCE ");
      consulta.append(" AND a.CANA_OID_CANA = c.OID_CANA ");
      consulta.append(" AND p.PAIS_OID_PAIS = "+oidPais+"  ");
      consulta.append(" AND s.COD_SBAC = '"+codigoSubacceso+"' ");
      consulta.append(" AND a.COD_ACCE = '"+codigoAcceso+"' ");
      consulta.append(" AND c.COD_CANA = '"+codigoCanal+"' ");
      consulta.append(" AND p.VAL_NUME_SOLI = "+numeroSolicitud+" ");
      

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerSolicitudCabecera: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidSoliCabe = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerSolicitudCabecera: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerSolicitudCabecera(Long oidPais, String codigoSubacceso, String numeroSolicitud, String codigoAcceso, String codigoCanal): Saldia");
      return oidSoliCabe;
  }    

  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param String codigoTipoCliente
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad MAE Tipo Cliente o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla.  
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerTipoCliente(String codigoTipoCliente) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTipoCliente(String codigoTipoCliente): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTipoClien = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT tc.OID_TIPO_CLIE ");
      consulta.append(" FROM mae_tipo_clien tc ");
      consulta.append(" WHERE tc.COD_TIPO_CLIE = '"+codigoTipoCliente+"' ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoCliente: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTipoClien = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoCliente: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTipoCliente(String codigoTipoCliente): Salida");
      return oidTipoClien;
  }

  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param Long oidTipoCliente, String codigoSubtipoCliente
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad MAE Subtipo Cliente o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla.
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerSubtipoCliente(Long oidTipoCliente, String codigoSubtipoCliente) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerSubtipoCliente(Long oidTipoCliente, String codigoSubtipoCliente): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidSubTipoClien = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT stc.OID_SUBT_CLIE ");
      consulta.append(" FROM mae_subti_clien stc ");
      consulta.append(" WHERE stc.TICL_OID_TIPO_CLIE = "+oidTipoCliente+" ");
      consulta.append(" AND stc.COD_SUBT_CLIE = '"+codigoSubtipoCliente+"' ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerSubtipoCliente: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidSubTipoClien = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerSubtipoCliente: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerSubtipoCliente(Long oidTipoCliente, String codigoSubtipoCliente): Salida");
      return oidSubTipoClien;
  }  

  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param Long oidPais, String codigoCliente
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad MAE Cliente o lanza una excepción 
   *              de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerCliente(Long oidPais, String codigoCliente) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerCliente(Long oidPais, String codigoCliente): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidClien = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT c.OID_CLIE ");
      consulta.append(" FROM mae_clien c ");
      consulta.append(" WHERE c.PAIS_OID_PAIS = "+oidPais+" ");
      consulta.append(" AND c.COD_CLIE = '"+codigoCliente+"' ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerCliente: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidClien = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerCliente: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerCliente(Long oidPais, String codigoCliente): Salida");
      return oidClien;
  }

  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param String codigoTipoDocumento
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad FAC Tipo Documento o lanza una
   *              excepción de Base de Datos en caso de no encontrarla.
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerTipoDocumento(String codigoTipoDocumento) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTipoDocumento(String codigoTipoDocumento): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTipoDocu = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT td.OID_TIPO_DOCU ");
      consulta.append(" FROM fac_tipo_docum td ");
      consulta.append(" WHERE td.COD_TIPO_DOCU = '"+codigoTipoDocumento+"' ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoDocumento: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTipoDocu = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoDocumento: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTipoDocumento(String codigoTipoDocumento): Salida");
      return oidTipoDocu;
  }  

  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param String codigoEstadoReclamo
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Estado Reclamo o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerEstadoReclamo(String codigoEstadoReclamo) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerEstadoReclamo(String codigoEstadoReclamo): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidEstadoReclamo = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT er.OID_ESTA_RECL ");
      consulta.append(" FROM REC_ESTAD_RECLA er ");
      consulta.append(" WHERE er.COD_ESTA = '"+codigoEstadoReclamo+"' ");    

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerEstadoReclamo: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidEstadoReclamo = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerEstadoReclamo: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerEstadoReclamo(String codigoEstadoReclamo): Salida");
      return oidEstadoReclamo;
  }

  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param Long oidPais, String motivoBloqueo
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Motivo Bloqueo o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla.
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerMotivoBloqueo(Long oidPais, String motivoBloqueo) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerMotivoBloqueo(Long oidPais, String motivoBloqueo): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidMotiBloq = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT mb.OID_MOTI_BLOQ ");
      consulta.append(" FROM REC_MOTIV_BLOQU mb ");
      consulta.append(" WHERE mb.PAIS_OID_PAIS = "+oidPais+" ");  
      consulta.append(" AND mb.VAL_MOTI_BLOQ = '"+motivoBloqueo+"' ");   

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerMotivoBloqueo: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidMotiBloq = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerMotivoBloqueo: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerMotivoBloqueo(Long oidPais, String motivoBloqueo): Salida");
      return oidMotiBloq;
  }

  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param Long oidPais, String codigoMotivo
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Motivo Rechazo Desbloqueo o 
   *              lanza una excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerMotivoRechazoDesbloqueo(Long oidPais, String codigoMotivo) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerMotivoRechazoDesbloqueo(Long oidPais, String codigoMotivo): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidMotiRechDesBloq = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT mr.OID_MOTI_RECH_DESB ");
      consulta.append(" FROM REC_MOTIV_RECHA_DESBL mr ");
      consulta.append(" WHERE mr.PAIS_OID_PAIS = "+oidPais+" ");  
      consulta.append(" AND mr.COD_RECH_DESB = '"+codigoMotivo+"' ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerMotivoRechazoDesbloqueo: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidMotiRechDesBloq = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerMotivoRechazoDesbloqueo: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerMotivoRechazoDesbloqueo(Long oidPais, String codigoMotivo): Salida");
      return oidMotiRechDesBloq;
  }  

  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param String codigoTipoIngreso
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Tipo Ingreso o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerTipoIngreso(String codigoTipoIngreso) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTipoIngreso(String codigoTipoIngreso): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTipoIngr = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT ti.OID_TIPO_INGR ");
      consulta.append(" FROM REC_TIPO_INGRE ti ");
      consulta.append(" WHERE ti.COD_TIPO_INGR = '"+codigoTipoIngreso+"' ");  

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoIngreso: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTipoIngr = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoIngreso: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTipoIngreso(String codigoTipoIngreso): Salida");
      return oidTipoIngr;
  }  

  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param Long oidPais, Long codigoMarca, Long codigoCanal , String codigoTerritorio
   * @return Long 
   * @throws MareException
   * @description  Obtiene el OID de la entidad ZON Territorio Administrativo o 
   *               lanza una excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003, BELC300022140
   */ 
  public Long obtenerTerritorioAdministrativo(Long oidPais, String codigoMarca, String codigoCanal , String codigoTerritorio) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTerritorioAdministrativo(Long oidPais, Long codigoMarca, Long codigoCanal , String codigoTerritorio): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTerrAdm = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT ta.OID_TERR_ADMI ");
      consulta.append(" FROM ZON_TERRI_ADMIN ta, SEG_MARCA m, SEG_CANAL c, ZON_TERRI t ");
      consulta.append(" WHERE ta.PAIS_OID_PAIS = "+oidPais+" "); 
      consulta.append(" AND ta.MARC_OID_MARC = m.OID_MARC ");
      consulta.append(" AND m.COD_MARC = '"+codigoMarca+"' "); 
      consulta.append(" AND ta.CANA_OID_CANA = c.OID_CANA ");
      consulta.append(" AND c.COD_CANA = '"+codigoCanal+"' "); 
      consulta.append(" AND ta.TERR_OID_TERR = t.OID_TERR ");
      consulta.append(" AND t.PAIS_OID_PAIS = "+oidPais+" "); 
      consulta.append(" AND t.COD_TERR = '"+codigoTerritorio+"' "); 
      consulta.append(" ORDER BY ta.FEC_RTZ DESC, t.FEC_RTZ DESC ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTerritorioAdministrativo: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTerrAdm = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTerritorioAdministrativo: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTerritorioAdministrativo(Long oidPais, Long codigoMarca, Long codigoCanal , String codigoTerritorio): Salida");
      return oidTerrAdm;
  }  

  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param String codigoAsume
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Asume Perdida o lanza una
   *              excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerAsumePerdida(String codigoAsume) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerAsumePerdida(String codigoAsume): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidAsuPerd = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT ap.OID_ASUM_PERD "); 
      consulta.append(" FROM REC_ASUME_PERDI ap "); 
      consulta.append(" WHERE ap.COD_PERI_RECL = '"+codigoAsume+"' "); 

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerAsumePerdida: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidAsuPerd = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerAsumePerdida: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerAsumePerdida(String codigoAsume): Salida");
      return oidAsuPerd;
  }  

  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param String codigoIndicador
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Indicador Entrega Mercaderia
   *              o lanza una excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerIndicadorEntregaMercaderia(String codigoIndicador) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerIndicadorEntregaMercaderia(String codigoIndicador): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidIndEntMerc = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT iem.OID_INDI_ENTR_MERC "); 
      consulta.append(" FROM REC_INDIC_ENTRE_MERCA iem "); 
      consulta.append(" WHERE iem.COD_INDI = '"+codigoIndicador+"' "); 

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerIndicadorEntregaMercaderia: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidIndEntMerc = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerIndicadorEntregaMercaderia: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerIndicadorEntregaMercaderia(String codigoIndicador): Salida");
      return oidIndEntMerc;
  }  
  
  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param String codigoPrecioPerdida
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Precio Perdida o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerPrecioPerdida(String codigoPrecioPerdida) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerPrecioPerdida(String codigoPrecioPerdida): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidPrecPerd = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT pp.OID_PREC_PERD "); 
      consulta.append(" FROM REC_PRECI_PERDI pp "); 
      consulta.append(" WHERE pp.COD_PREC_PERD = '"+codigoPrecioPerdida+"' "); 

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerPrecioPerdida: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidPrecPerd = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerPrecioPerdida: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerPrecioPerdida(String codigoPrecioPerdida): Salida");
      return oidPrecPerd;
  }  
  
  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param Long oidPais, String codigoProducto
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad MAE Producto o lanza una excepción 
   *              de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerProducto(Long oidPais, String codigoProducto) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerProducto(Long oidPais, String codigoProducto): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidProd = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT mp.OID_PROD "); 
      consulta.append(" FROM MAE_PRODU mp "); 
      consulta.append(" WHERE mp.PAIS_OID_PAIS = "+oidPais+" "); 
      consulta.append(" AND mp.COD_SAP = '"+codigoProducto+"' "); 

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerProducto: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidProd = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerProducto: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerProducto(Long oidPais, String codigoProducto): Salida");
      return oidProd;
  }  
  
  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param Long oidPais, String codigoTipoBloqueo
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Tipos Bloqueo o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla.
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerTipoBloqueo(Long oidPais, String codigoTipoBloqueo) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTipoBloqueo(Long oidPais, String codigoTipoBloqueo): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTipoBloq = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT tb.OID_TIPO_BLOQ "); 
      consulta.append(" FROM REC_TIPOS_BLOQU tb "); 
      consulta.append(" WHERE tb.PAIS_OID_PAIS = "+oidPais+" "); 
      consulta.append(" AND tb.COD_TIPO_BLOQ = '"+codigoTipoBloqueo+"' "); 

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoBloqueo: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTipoBloq = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoBloqueo: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTipoBloqueo(Long oidPais, String codigoTipoBloqueo): Salida");
      return oidTipoBloq;
  }  
  
  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param Long oidPais, String codigoOperacion, String codigoTipoOperacion
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Tipos Operacion o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla.
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerTipoOperacion(Long oidPais, String codigoOperacion, String codigoTipoOperacion) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTipoOperacion(Long oidPais, String codigoOperacion, String codigoTipoOperacion): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTipoOper = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT top.OID_TIPO_OPER "); 
      consulta.append(" FROM REC_TIPOS_OPERA top, REC_OPERA op "); 
      consulta.append(" WHERE top.VAL_TIPO_OPER = '"+codigoTipoOperacion+"' ");
      consulta.append(" AND top.ROPE_OID_OPER = op.OID_OPER "); 
      consulta.append(" AND op.PAIS_OID_PAIS = "+oidPais+" "); 
      consulta.append(" AND op.COD_OPER = '"+codigoOperacion+"' ");  

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoOperacion: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTipoOper = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoOperacion: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTipoOperacion(Long oidPais, String codigoOperacion, String codigoTipoOperacion): Salida");
      return oidTipoOper;
  }  
    
  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param String codigoTipoPosicion
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad PED Tipo Posicion o lanza una
   *              excepción de Base de Datos en caso de no encontrarla.
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerTipoPosicion(String codigoTipoPosicion) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTipoPosicion(String codigoTipoPosicion): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTipoPosi = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT tp.OID_TIPO_POSI ");
      consulta.append(" FROM PED_TIPO_POSIC tp ");
      consulta.append(" WHERE tp.COD_TIPO_POSI = '"+codigoTipoPosicion+"' ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoPosicion: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTipoPosi = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoPosicion: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTipoPosicion(String codigoTipoPosicion): Salida");
      return oidTipoPosi;
  } 
    
  /**
   * @author Emilio Noziglia
   * @since 30/11/2005
   * @param Long oidPais, String codigoTipoSolicitud
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad PED Tipo Solicitud Pais o lanza
   *              una excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public Long obtenerTipoSolicitud(Long oidPais, String codigoTipoSolicitud) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTipoSolicitud(Long oidPais, String codigoTipoSolicitud): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTipoSoli = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT tsp.OID_TIPO_SOLI_PAIS ");
      consulta.append(" FROM PED_TIPO_SOLIC_PAIS tsp, PED_TIPO_SOLIC ts ");
      consulta.append(" WHERE tsp.PAIS_OID_PAIS = "+oidPais+" ");
      consulta.append(" AND tsp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI ");
      consulta.append(" AND ts.COD_TIPO_SOLI = '"+codigoTipoSolicitud+"' ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoSolicitud: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTipoSoli = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoSolicitud: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTipoSolicitud(Long oidPais, String codigoTipoSolicitud): Salida");
      return oidTipoSoli;
  } 
    
  /**
   * @author Emilio Noziglia
   * @since 01/12/2005
   * @param Long oidPeriodo, Long oidPais, String codigoEstrategia, Integer numeroOferta, Long oidProducto
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad PRE Matriz Facturacion o lanza 
   *              una excepción de Base de Datos en caso de no encontrarla.
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   * Modificado por Rafael Romero (17-01-2007). Se ha incluido el parametro 
   * numero_linea_oferta, este valor viene en el archivo y garantiza obtener un 
   * unico OID_MATR_FACT.
   */
  public Long obtenerMatrizFacturacion(
          Long oidPeriodo, 
          Long oidPais, 
          String codigoEstrategia, 
          Integer numeroOferta, 
          Long oidProducto,
          Integer numLineaOferta) 
  throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerMatrizFacturacion(Long oidPeriodo, Long oidPais, String codigoEstrategia, Integer numeroOferta, Long oidProducto, Integer numLineaOferta): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidMF = null;
      String codigoError = null;

      consulta.append(" SELECT mf.OID_MATR_FACT ");
      consulta.append("   FROM pre_matri_factu_cabec mfc, ");
      consulta.append("        pre_matri_factu mf, ");
      consulta.append("        pre_ofert ofer, ");
      consulta.append("        pre_ofert_detal od, ");
      consulta.append("        pre_estra estra ");
      consulta.append("  WHERE mf.mfca_oid_cabe = mfc.oid_cabe ");
      consulta.append("    AND mfc.perd_oid_peri = "+oidPeriodo+" ");
      consulta.append("    AND mf.ofde_oid_deta_ofer = od.oid_deta_ofer ");
      consulta.append("    AND ofer.mfca_oid_cabe = mfc.oid_cabe ");
      consulta.append("    AND ofer.coes_oid_estr = estra.oid_estr ");
      consulta.append("    AND estra.cod_estr = '"+codigoEstrategia+"' ");
      consulta.append("    AND ofer.num_ofer = "+numeroOferta+" ");
      consulta.append("    AND od.ofer_oid_ofer = ofer.oid_ofer ");
      consulta.append("    AND od.prod_oid_prod = "+oidProducto+" ");
      consulta.append("    AND od.NUM_LINE_OFER = "+numLineaOferta+" ");

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerMatrizFacturacion: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidMF = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerMatrizFacturacion: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerMatrizFacturacion(Long oidPeriodo, Long oidPais, String codigoEstrategia, Integer numeroOferta, Long oidProducto, Integer numLineaOferta): Salida");
      return oidMF;
  } 
  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param Object  
   * @return Long
   * @description metodo de apoyo para transformar BigDecimal a Long.
   */ 
  private Long BigToLong(Object num) {
      if (num != null) {
          return (new Long(((BigDecimal) num).longValue()));
      } else {
          return null;
      }
  }  
  /**
   * @author Emilio Noziglia
   * @since 01/12/2005
   * @param String codigoTipoMovimiento
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Tipo Movimiento o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */
  
  public Long obtenerTipoMovimiento(String codigoTipoMovimiento) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTipoMovimiento(String codigoTipoMovimiento): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTM = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT tm.OID_TIPO_MOVI ");
      consulta.append(" FROM REC_TIPO_MOVIM tm");
  	  consulta.append(" WHERE tm.COD_TIPO_MOVI = '"+codigoTipoMovimiento+"' ");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoMovimiento: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTM = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoMovimiento: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTipoMovimiento(String codigoTipoMovimiento): Salida");
      return oidTM;
  }  
  
  /**
   * @author Emilio Noziglia
   * @since 01/12/2005
   * @param String codigoTipoOferta, String codigoCanal  
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad PRE Tipo Oferta o lanza una
   *              excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */   
 public Long obtenerTipoOferta(String codigoTipoOferta, String codigoCanal) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerTipoOferta(String codigoTipoOferta, String codigoCanal): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidTO = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT tm.OID_TIPO_OFER ");
      consulta.append(" FROM PRE_TIPO_OFERT tm, SEG_CANAL sc ");
  	  consulta.append(" WHERE tm.COD_TIPO_OFER = '"+codigoTipoOferta+"' ");
      //enozigli 01/12/2005 cambio por incidencia BELC300022064 
		  consulta.append(" AND tm.CANA_OID_CANA = sc.OID_CANA");
      //enozigli 01/12/2005 fin cambio por incidencia BELC300022064 
      consulta.append(" AND sc.COD_CANA ='" +codigoCanal+"' ");
      //consulta.append(" AND gof.NUM_GRUP IS NULL ");
			   
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoOferta: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidTO = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerTipoOferta: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerTipoOferta(String codigoTipoOferta, String codigoCanal): Salida");
      return oidTO;
  } 

 /**
   * @author Emilio Noziglia
   * @since 01/12/2005
   * @param Long oidPais, String codigoMotivo  
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Motivo Devolucion o lanza una
   *              excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */   
 public Long obtenerMotivoDevolucion(Long oidPais, String codigoMotivo) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerMotivoDevolucion(Long oidPais, String codigoMotivo): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidMD = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT md.OID_MOTI_DEVO ");
      consulta.append(" FROM REC_MOTIV_DEVOL md ");
  	  consulta.append(" WHERE md.PAIS_OID_PAIS = "+oidPais+" ");
		  consulta.append(" AND md.COD_MOTI_DEVO = '"+codigoMotivo+"' ");
			            
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerMotivoDevolucion: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidMD = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerMotivoDevolucion: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerMotivoDevolucion (Long oidPais, String codigoMotivo): Salida");
      return oidMD;
  } 

  /**
   * @author Emilio Noziglia
   * @since 29/11/2005
   * @param String codigoEstadoOperacion
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Estado Operacion o lanza una 
   *              excepción de Base de Datos en caso de no encontrarla. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */
  public Long obtenerEstadoOperacion(String codigoEstadoOperacion) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerEstadoOperacion(String codigoEstadoOperacion): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidEstadoOperacion = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT eo.OID_ESTA_OPER ");
      consulta.append(" FROM REC_ESTAD_OPERA eo ");
      consulta.append(" WHERE eo.COD_ESTA_OPER = '"+codigoEstadoOperacion+"' ");    

      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerEstadoOperacion: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidEstadoOperacion = BigToLong(rs.getValueAt(0,0));
      } else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerEstadoOperacion: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }

      UtilidadesLog.info("DAOINTRET.obtenerEstadoOperacion(String codigoEstadoOperacion): Salida");
      return oidEstadoOperacion;
  }
 
  public Long obtenerOidCabeceraReclamo(String numeroAtencion, Long oidPais) throws MareException {
    return this.obtenerOidCabeceraReclamo(numeroAtencion, null, oidPais);
  }
  
  
  /**
   * @author Emilio Noziglia
   * @since 24/02/2006
   * @param String numeroAtencion, Long oidPais
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Cabecera reclamo.
   * @modificacion Inc.DBLG500001068 - Se recupera Cabecera con numeroAtencion
   *                                   del archivo, comparado a NUM_ATEN_INTE y
   *                                   no NUM_ATEN
   * @modificacion CAMBIO IN-001 gPineda - 09/02/2007 -
   *            NUM_ATEN_INTE == NUM_ATEN_INTE sino NUM_ATEN == NUM_ATEN
   * Modificado por: Cristian Valenzuela
   * Fecha: 7/11/2006
   * Incidencia: RET_01
   * Comentario: Se vuelve a filtrar por NUM_ATEN
   */ 
  public Long obtenerOidCabeceraReclamo(String numeroAtencion, String numeroAtencionInterfaz, Long oidPais) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerOidCabeceraReclamo(String numeroAtencion, Long oidPais): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidCabeceraReclamo = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT cab.OID_CABE_RECL  ");
      consulta.append(" FROM REC_CABEC_RECLA cab "); 
      
      if( numeroAtencionInterfaz != null && ! numeroAtencionInterfaz.equals("") ){
        consulta.append(" WHERE cab.NUM_ATEN_INTE = '"+numeroAtencionInterfaz+"' "); 
      }else{
        consulta.append(" WHERE cab.NUM_ATEN = '"+numeroAtencion+"' ");
      }
      
      consulta.append(" AND cab.PAIS_OID_PAIS = "+oidPais+" ");  
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerOidCabeceraReclamo: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidCabeceraReclamo = BigToLong(rs.getValueAt(0,0));
      }/* else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerOidCabeceraReclamo: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }*/

      UtilidadesLog.info("DAOINTRET.obtenerOidCabeceraReclamo(String numeroAtencion, Long oidPais): Salida");

      return oidCabeceraReclamo;
  }  

  public Long obtenerOidOperacionReclamo(String numeroAtencion, Integer numSecOper, Long oidPais) throws MareException {
    return obtenerOidOperacionReclamo(numeroAtencion, null, numSecOper, oidPais);
  }
  /**
   * @author Emilio Noziglia
   * @since 24/02/2006
   * @param String numeroAtencion, Integer numSecOper, Long oidPais
   * @return Long 
   * @throws MareException
   * @description Obtiene el OID de la entidad REC Cabecera reclamo.
   * @modificacion Inc.DBLG500001068 - El numeroAtencion del archivo se compara
   *                                   con NUM_ATEN_INTE y no NUM_ATEN de la cabecera
   * @modificacion CAMBIO IN-001 gPineda - 09/02/2007 -
   *                NUM_ATEN_INTE == NUM_ATEN_INTE sino NUM_ATEN == NUM_ATEN
   * Modificado por: Cristian Valenzuela
   * Fecha: 7/11/2006
   * Incidencia: RET_01
   * Comentario: Se vuelve a filtrar por num_aten
   */ 
  public Long obtenerOidOperacionReclamo(String numeroAtencion, String numeroAtencionInterfaz, Integer numSecOper, Long oidPais) throws MareException {
      UtilidadesLog.info("DAOINTRET.obtenerOidOperacionReclamo(String numeroAtencion, Integer numSecOper, Long oidPais): Entrada");

      StringBuffer consulta = new StringBuffer();
      Long oidOperacionReclamo = null;
      String codigoError = null;

      // Consulta SQL
      consulta.append(" SELECT ope.OID_OPER_RECL ");
      consulta.append(" FROM rec_opera_recla ope, rec_cabec_recla cab ");
      consulta.append(" WHERE ope.CARE_OID_CABE_RECL = cab.OID_CABE_RECL ");
      consulta.append(" AND ope.NUM_SECU_OPER = "+numSecOper+" ");
      
      if( numeroAtencionInterfaz != null && ! numeroAtencionInterfaz.equals("") ){
        consulta.append(" AND cab.NUM_ATEN_INTE = '"+numeroAtencionInterfaz+"' ");
      } else{
        consulta.append(" AND cab.num_aten = '"+numeroAtencion+"' ");
      }
      
      consulta.append(" AND cab.pais_oid_pais = "+oidPais+" ");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;

      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerOidOperacionReclamo: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } //catch

      if (rs != null && !rs.esVacio() && rs.getValueAt(0,0)!=null) {
          oidOperacionReclamo = BigToLong(rs.getValueAt(0,0));
      } /*else {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("obtenerOidOperacionReclamo: La consulta no trajo nada.");
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));        
      }*/

      UtilidadesLog.info("DAOINTRET.obtenerOidOperacionReclamo(String numeroAtencion, Integer numSecOper, Long oidPais): Salida");

      return oidOperacionReclamo;
  }    
}