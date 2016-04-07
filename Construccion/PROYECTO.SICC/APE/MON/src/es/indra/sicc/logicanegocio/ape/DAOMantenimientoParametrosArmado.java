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
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.ape.DTOAgrupacionEspecifica;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.util.ArrayList;

public class DAOMantenimientoParametrosArmado  {
  public DAOMantenimientoParametrosArmado() {
  }

  public void eliminarListaAFPDetalles(Long oidCabecera) throws MareException {
      UtilidadesLog.info("DAOMantenimientoParametrosArmado.eliminarListaAFPDetalles(Long oidCabecera): Entrada");
      
      StringBuffer query = new StringBuffer();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" DELETE APE_CONFI_LIAFP_DETAL det ");
      query.append(" WHERE det.LIAC_OID_CONF_LAFP_CABE =  " + oidCabecera);
      
      try {
          int cant = bs.dbService.executeUpdate(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOMantenimientoParametrosArmado.eliminarListaAFPDetalles(Long oidCabecera): Salida");
  }
  
  public DTOSalida recuperarConfiguracionesAFP(DTOAgrupacionEspecifica dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoParametrosArmado.recuperarConfiguracionesAFP(DTOAgrupacionEspecifica dtoe): Entrada");
      UtilidadesLog.debug("DTOAgrupacionEspecifica: " + dtoe);
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      DTOSalida dtoSalida = new DTOSalida();

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT cab.OID_CONF_LAFP_CABE OID, i18n.VAL_I18N DESC_CD, cab.NUM_AGRU, ");
      query.append(" cab.CCDI_OID_CONF_CENT_DIST, cab.MARC_OID_MARC, cab.CANA_OID_CANA ");
      query.append(" FROM APE_CONFI_LIAFP_CABEC cab, v_gen_i18n_sicc i18n ");     
      query.append(" WHERE cab.NUM_AGRU LIKE '" + dtoe.getDescAgrupacionEspecifica() + "' ");
      
      if(dtoe.getOidCentroDistribucion()!=null){
          query.append(" AND cab.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOidCentroDistribucion());
      }
      
      query.append(" AND cab.CCDI_OID_CONF_CENT_DIST = i18n.VAL_OID ");
      query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
      query.append(" AND i18n.attr_num_atri = 1 ");
      query.append(" AND i18n.attr_enti = 'APP_CONFI_CENTR_DISTR' ");
      
      try {
          rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe));
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      dtoSalida.setResultado(rs);

      UtilidadesLog.info("DAOMantenimientoParametrosArmado.recuperarConfiguracionesAFP(DTOAgrupacionEspecifica dtoe): Salida");
      return dtoSalida;
  }
  
  public DTOSalida recuperarAgrupacinesAFP(DTOAgrupacionEspecifica dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoParametrosArmado.recuperarAgrupacinesAFP(DTOAgrupacionEspecifica dtoe): Entrada");
      UtilidadesLog.debug("DTOAgrupacionEspecifica: " + dtoe);
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      DTOSalida dtoSalida = new DTOSalida();

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT reg.OID_REGI ||'-'||NVL(zon.OID_ZONA,0)||'-'||NVL(sec.OID_SECC,0) OID, ");
      query.append(" reg.DES_REGI, zon.DES_ZONA, sec.DES_SECCI ");
      query.append(" FROM APE_CONFI_LIAFP_DETAL det, ZON_REGIO reg, ZON_ZONA zon, ZON_SECCI sec ");     
      query.append(" WHERE det.LIAC_OID_CONF_LAFP_CABE = " + dtoe.getOidConfiguracionListaAFPCabecera());
      query.append(" AND det.ZORG_OID_REGI = reg.OID_REGI ");
      query.append(" AND det.ZZON_OID_ZONA = zon.OID_ZONA(+) ");
      query.append(" AND det.ZSCC_OID_SECC = sec.OID_SECC(+) ");
      query.append(" ORDER BY reg.DES_REGI, zon.DES_ZONA, sec.DES_SECCI ");
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      dtoSalida.setResultado(rs);

      UtilidadesLog.info("DAOMantenimientoParametrosArmado.recuperarAgrupacinesAFP(DTOAgrupacionEspecifica dtoe): Salida");
      return dtoSalida;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       13/07/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Inc BELC400000561
    */
  public Boolean validarDetalleAgrupacion(DTOColeccion coleccion) throws MareException {
      UtilidadesLog.info("DAOMantenimientoParametrosArmado.validarDetalleAgrupacion(DTOColeccion coleccion): Entrada");
      UtilidadesLog.debug("DTOColeccion: " + coleccion);
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      ArrayList detalles = coleccion.getLista();
      DTOAgrupacionEspecifica dtoAgrupacionEspecifica = null;      
      String inOidReg = "";
      String inOidZona = "";
      String inOidSecc = "";
      Long oidCanal = null;
      Long oidMarca = null;
      
      int cant = detalles.size();
      
      for (int i = 0; i < cant; i++) {
         dtoAgrupacionEspecifica = (DTOAgrupacionEspecifica)detalles.get(i);   
         
         if(i==0){
            oidMarca = dtoAgrupacionEspecifica.getOidMarca();
            oidCanal = dtoAgrupacionEspecifica.getOidCanal();
         }
              
         if(dtoAgrupacionEspecifica.getOidRegion()!=null){     
            inOidReg = inOidReg + "," + dtoAgrupacionEspecifica.getOidRegion();
         }
         
         if(dtoAgrupacionEspecifica.getOidZona()!=null){    
            inOidZona = inOidZona + "," + dtoAgrupacionEspecifica.getOidZona();
         }
         
         if(dtoAgrupacionEspecifica.getOidSeccion()!=null){    
            inOidSecc = inOidSecc + "," + dtoAgrupacionEspecifica.getOidSeccion();         
         }
      }

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT det.OID_CONF_LAFP_DETA ");
      query.append(" FROM APE_CONFI_LIAFP_CABEC cab, APE_CONFI_LIAFP_DETAL det ");
      query.append(" WHERE det.LIAC_OID_CONF_LAFP_CABE = cab.OID_CONF_LAFP_CABE ");     
      query.append(" AND cab.CANA_OID_CANA = " + oidCanal);
      query.append(" AND cab.MARC_OID_MARC =  " + oidMarca);
      query.append(" AND det.ZORG_OID_REGI IN ( " + inOidReg.substring(1) + ") ");
      
      if(!inOidZona.equals("")){
          // vbongiov -- LG_V400000051 -- 2/01/2008
          query.append(" AND det.ZZON_OID_ZONA IN ( " + inOidZona.substring(1) + ") ");   
          
       } else {
          // vbongiov -- LG_V400000051 -- 5/11/2007
          query.append(" AND det.ZZON_OID_ZONA IS NULL ");
      }
      
      if(!inOidSecc.equals("")){
          // vbongiov -- LG_V400000051 -- 2/01/2008
          query.append(" AND det.ZSCC_OID_SECC IN ( " + inOidSecc.substring(1) + ") ");
          
      } else {
          // vbongiov -- LG_V400000051 -- 5/11/2007
          query.append(" AND det.ZSCC_OID_SECC IS NULL ");
      }
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("rs: " + rs);

      UtilidadesLog.info("DAOMantenimientoParametrosArmado.validarDetalleAgrupacion(DTOColeccion coleccion): Salida");
      
      if(rs.esVacio()){
          return Boolean.TRUE;
      } else {
          return Boolean.FALSE;
      }
  }
}