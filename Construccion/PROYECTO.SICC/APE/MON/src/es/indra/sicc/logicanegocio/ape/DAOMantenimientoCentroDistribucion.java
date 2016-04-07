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
 */
 
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;

public class DAOMantenimientoCentroDistribucion {
  public DAOMantenimientoCentroDistribucion()  {  }

  /** 
   * Método para buscar centros de Distribucion.
   * @author Carlos Daniel Iglesias
   * @since 09-01-2007
   * @observaciones
   *     BELC400000355 - ciglesias
   *     excepcion si resultado es vacio - raromero - 07/03/2007
   *     filtro por pais e idioma - dmorello - 02/05/2007
   *     BELC400000417 (cambio APE-009) - eiraola - 21/05/2007
   */
  public DTOSalida buscarCentroDistribucion(DTOConfiguracionCentroDistribucion dtoE)  throws MareException {
      UtilidadesLog.info("DAOMantenimientoCentroDistribucion.buscarCentroDistribucion(): Entrada");
      BelcorpService bs;
      RecordSet resultado = new RecordSet();
      DTOSalida dtoS = new DTOSalida();
      bs = UtilidadesEJB.getBelcorpService();
      
      StringBuffer query = new StringBuffer();
      
      try {
          bs = BelcorpService.getInstance();
          
          query.append("SELECT cd.OID_CONF_CENT_DIST OID, ");
          query.append(       "cd.COD_CENT_DIST, ");
          query.append(       "pq_apl_aux.valor_gen_i18n_sicc(1, cd.OID_CONF_CENT_DIST," +
                                      "'APP_CONFI_CENTR_DISTR') DESC_CENT_DIST, ");
          query.append(       "cd.VAL_DEFE, ");
          query.append(       "cd.NIOU_OID_NIVE_OUTS, ");                       // HIDDEN
          query.append(       "pq_apl_aux.valor_gen_i18n_sicc(1, cd.NIOU_OID_NIVE_OUTS, " + 
                                      "'APE_NIVEL_OUTSO') DESC_NIVE_OUTS, ");
          query.append(       "cd.ORLP_OID_ORDE_LIST_PICA, ");                  // HIDDEN
          query.append(       "pq_apl_aux.valor_gen_i18n_sicc(1, cd.ORLP_OID_ORDE_LIST_PICA, " +
                                      "'APE_ORDEN_LISTA_PICAD') DESC_ORDE_LIST_PICA, ");
          query.append(       "cd.ORPR_OID_ORDE_PROD, ");                       // HIDDEN  
          query.append(       "pq_apl_aux.valor_gen_i18n_sicc(1, cd.ORPR_OID_ORDE_PROD, " + 
                                      "'APE_ORDEN_PRODU') DESC_ORDE_PROD, ");
          query.append(       "cd.VAL_TEXT_CHEQ, ");
          query.append(       "cd.VAL_TEXT_PRIM_PEDI, ");
          query.append(       "cd.AAFP_OID_AAFP, ");                            // HIDDEN
          query.append(       "pq_apl_aux.valor_gen_i18n_sicc(1, cd.AAFP_OID_AAFP, " + 
                                      "'APE_AGRUP_AFP') DESC_AAFP, ");
         //Agregado por cambio 20090839                             
          query.append("            decode(cd.ind_impr_dato_basi_clie, 1, 'SI',0,'NO') impre,  ");
          query.append("            ordVisu.OID_ORDE_VISU_CHEQ,  ");
          query.append("            ordVisu.DES_VISU_CHEQ, ");
          query.append("            decode(cd.val_orde_visu_cheq,'A','Ascendente','D','Descendente') orden ");
          
          query.append(  "FROM APP_CONFI_CENTR_DISTR cd, ");
          query.append(       "APE_NIVEL_OUTSO nOut, ");
          query.append(       "APE_ORDEN_LISTA_PICAD oLP, ");
          query.append(       "APE_ORDEN_PRODU oProd, ");
          query.append(       "APE_AGRUP_AFP aAfp, ");
          //Se agrega por cambio 20090839
          query.append("      APE_ORDEN_VISUA_CHEQU ordVisu ");
          query.append( "WHERE cd.NIOU_OID_NIVE_OUTS = nOut.OID_NIVE_OUTS ");
          query.append(   "AND cd.ORLP_OID_ORDE_LIST_PICA = oLP.OID_ORDE_LIST_PICA (+) ");
          query.append(   "AND cd.ORPR_OID_ORDE_PROD = oProd.OID_ORDE_PROD (+) ");
          query.append(   "AND cd.AAFP_OID_AAFP = aAfp.OID_AAFP (+) ");
          query.append("   AND cd.OVCH_OID_ORDE_VISU_CHEQ = ordVisu.OID_ORDE_VISU_CHEQ ");
          query.append(   " AND cd.PAIS_OID_PAIS = " + dtoE.getOidPais() + " ");
          
          if (dtoE.getCodigoCentroDistribucion() != null) {
              query.append("AND cd.COD_CENT_DIST LIKE '" + dtoE.getCodigoCentroDistribucion() + "' ");
          }
          
          if (dtoE.getDescripcion() != null) {
              query.append("AND pq_apl_aux.valor_gen_i18n_sicc(1, cd.OID_CONF_CENT_DIST, " + 
                                   "'APP_CONFI_CENTR_DISTR') = '" + dtoE.getDescripcion() + "' ");
          }
          
          if (dtoE.getOidCentroDistribucion() != null) {
              query.append("AND cd.OID_CONF_CENT_DIST = " + dtoE.getOidCentroDistribucion());
          }
          
          String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoE);
          resultado = bs.dbService.executeStaticQuery(queryPaginada);
          
      } catch(Exception e) {
          UtilidadesLog.debug(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      if (resultado.esVacio()) {
          UtilidadesLog.debug("<dao>.buscarCentroDistribucion(dtoE): no hay datos ");				
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      dtoS.setResultado(resultado);
      
      UtilidadesLog.info("DAOMantenimientoCentroDistribucion.buscarCentroDistribucion(): Salida");
      return dtoS;
  }
  
   /** 
   * Autor: Carlos Daniel Iglesias
   * Fecha: 09-01-2007
   * Recupera los niveles de outsourcing para el país e idioma recibidos.
   * @param dtoE DTOBelcorp 
   * @return DTOSalida el resultado de la busqueda
   * @exception MareException 
   */
  
  public DTOSalida obtenerNivelesOutSourcing(DTOBelcorp dtoE) throws MareException {

     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerNivelesOutSourcing():Entrada");
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
          bs = BelcorpService.getInstance();
          
          query.append(" SELECT OID_NIVE_OUTS, VAL_I18N ");
          query.append(" FROM APE_NIVEL_OUTSO, V_GEN_I18N_SICC ");
          query.append(" WHERE ATTR_ENTI = 'APE_NIVEL_OUTSO' ");
          query.append(" AND OID_NIVE_OUTS = VAL_OID ");
          query.append(" AND IDIO_OID_IDIO = '" + dtoE.getOidIdioma() +"' " );
  
          resultado = bs.dbService.executeStaticQuery(query.toString());    
     }
     catch(Exception e) {
          UtilidadesLog.debug(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

      dtoS.setResultado(resultado);

     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerNivelesOutSourcing():Salida");
     return dtoS;  
  }
  
  
  
   /** 
   * Autor: Carlos Daniel Iglesias
   * Fecha: 09-01-2007
   * Comprueba si existe el CD Default para el país recibido
   * @param pais Long
   * @return Boolean si hay o no valores en respuesta
   * @exception MareException 
   */
  
  public Boolean existeCDDefault(Long pais) throws MareException {
   
     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.existeCDDefault():Entrada");
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
          bs = BelcorpService.getInstance();
          
          query.append(" SELECT CCD.OID_CONF_CENT_DIST OID ");
          query.append(" FROM APP_CONFI_CENTR_DISTR CCD ");
          query.append(" WHERE CCD.PAIS_OID_PAIS = '" + pais + "' ");
          query.append(" AND VAL_DEFE = 'S' ");

          resultado = bs.dbService.executeStaticQuery(query.toString());    
     }
     catch(Exception e) {
          UtilidadesLog.debug(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.existeCDDefault():Salida");
     UtilidadesLog.info("Resultado " + !resultado.esVacio());
     
     return new Boolean(!resultado.esVacio());
  }
  
  
  
  
   /** 
   * Autor: Carlos Daniel Iglesias
   * Fecha: 09-01-2007
   * Comprueba si existe el CD Default para el país recibido
   * @param pais Long
   * @return Long devuelve el oid
   * @exception MareException 
   */
  
  public Long obtenerOIDCDDefault(Long pais) throws MareException {

     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerOIDCDDefault():Entrada");
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
          bs = BelcorpService.getInstance();
          
          query.append(" SELECT CCD.OID_CONF_CENT_DIST OID ");
          query.append(" FROM APP_CONFI_CENTR_DISTR CCD ");
          query.append(" WHERE CCD.PAIS_OID_PAIS = '" + pais + "' ");
          query.append(" AND VAL_DEFE = 'S' ");
   
          resultado = bs.dbService.executeStaticQuery(query.toString());    
     }
     catch(Exception e) {
          UtilidadesLog.debug(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerOIDCDDefault():Salida");
     UtilidadesLog.info("Resultado " + !resultado.esVacio());
     
     if (!resultado.esVacio()) 
     {
       return new Long(((BigDecimal)resultado.getValueAt(0,"OID")).toString());
     } else
     {
       return null;
     }
  }  
  
   /** 
   * Autor: Carlos Daniel Iglesias
   * Fecha: 09-01-2007
   * Obtiene código y valor por defecto de los centros de distribución para el país indicado en el DTO
   * @param dtoE DTOBelcorp 
   * @return DTOSalida el resultado de la busqueda
   * @exception MareException 
   */
  public DTOSalida obtenerCodigoCentrosDistribucion(DTOBelcorp dtoE)  throws MareException {
  
     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerCodigoCentrosDistribucion():Entrada");
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
          bs = BelcorpService.getInstance();
          
          query.append(" SELECT CCD.OID_CONF_CENT_DIST OID,  CCD.COD_CENT_DIST,");
          query.append(" CCD.VAL_DEFE ");
          query.append(" FROM APP_CONFI_CENTR_DISTR CCD ");
          query.append(" WHERE CCD.PAIS_OID_PAIS = '" + dtoE.getOidPais() + "' ");
          query.append(" ORDER BY CCD.COD_CENT_DIST ");

          resultado = bs.dbService.executeStaticQuery(query.toString());    
     }
     catch(Exception e) {
          UtilidadesLog.debug(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     if (!resultado.esVacio()){
        dtoS.setResultado(resultado);
     }else{
          throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }        
     
     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerCodigoCentrosDistribucion():Salida");
     return dtoS;  
  
  } 
  
  
   /** 
   * Autor: Carlos Daniel Iglesias
   * Fecha: 09-01-2007
   * Recupera las descripciones de los Centros de distribución
   * @param dtoE DTOBelcorp 
   * @return DTOSalida el resultado de la busqueda
   * @exception MareException 
   */
  public DTOSalida obtenerDescripcionesCD(DTOBelcorp dtoE)  throws MareException {
     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerDescripcionesCD"+
     "(DTOBelcorp dtoE):Entrada");
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOSalida dtoS = new DTOSalida();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
          bs = BelcorpService.getInstance();
          
          query.append(" SELECT CCD.OID_CONF_CENT_DIST OID, ");
          query.append(" IDIOM.VAL_I18N DESCRIPCION, CCD.VAL_DEFE ");
          query.append(" FROM APP_CONFI_CENTR_DISTR CCD, V_GEN_I18N_SICC IDIOM ");
          query.append(" WHERE IDIOM.ATTR_ENTI = 'APP_CONFI_CENTR_DISTR' ");
          query.append(" AND IDIOM.VAL_OID = CCD.OID_CONF_CENT_DIST ");
          query.append(" AND IDIOM.IDIO_OID_IDIO = " + dtoE.getOidIdioma());
          // dmorello, 17/01/2007: Se ordena para que aparezcan ordenados en el combo
          query.append(" ORDER BY DESCRIPCION ASC ");
   
          resultado = bs.dbService.executeStaticQuery(query.toString());    
     }
     catch(Exception e) {
          UtilidadesLog.debug(e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     dtoS.setResultado(resultado);    
     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerDescripcionesCD"+
     "(DTOBelcorp dtoE):Entrada");
     return dtoS;  
  
  }    
  
  /**
   * @author dmorello
   * @since 17-01-2007
   */
  public DTOSalida obtenerValoresDefecto(DTOBelcorp dtoe) throws MareException {
     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerValoresDefecto(DTOBelcorp dtoe): Entrada");
     
     BelcorpService bs = UtilidadesEJB.getBelcorpService();
     RecordSet rs = null;
     StringBuffer query = new StringBuffer();
     
      query.append(" SELECT '").append(ConstantesAPE.LINEA_ARMADO).append("' AS combo, ");
      query.append(" linea.oid_line_arma AS OID ");
      query.append("   FROM ape_linea_armad linea, app_confi_centr_distr centro ");
      query.append("  WHERE linea.num_valo_defe = 1 ");
      query.append("    AND linea.ccdi_oid_conf_cent_dist = centro.oid_conf_cent_dist ");
      query.append("    AND centro.pais_oid_pais = ");
      query.append(dtoe.getOidPais());
      /*
       * dmorello, 17/01/2007      
       */
      query.append(" UNION ");
      query.append(" SELECT '").append(ConstantesAPE.CONFIGURACION_CD).append("' AS combo, ");
      query.append(" centro.oid_conf_cent_dist ");
      query.append("   FROM app_confi_centr_distr centro ");
      query.append("  WHERE val_defe = 'S' AND pais_oid_pais = ");
      query.append(dtoe.getOidPais());
      
      // vbongiov -- 23/01/2007
      query.append(" UNION ");
      query.append(" SELECT '").append(ConstantesAPE.MAPA_ZONA).append("' AS combo, ");
      query.append(" map.OID_MAPA_ZONA_CABE ");
      query.append(" FROM APE_MAPA_ZONA_CABEC map, ");
      query.append(" APE_MAPA_CENTR_DISTR_CABEC cendist, ");
      query.append(" APP_CONFI_CENTR_DISTR conf ");
      query.append(" WHERE map.MCDC_OID_MAPA_CENT_DIST_CABE = cendist.OID_MAPA_CENT_DIST_CABE ");
      query.append(" AND cendist.CCDI_OID_CONF_CENT_DIST = conf.OID_CONF_CENT_DIST ");
      query.append(" AND conf.PAIS_OID_PAIS = " + dtoe.getOidPais());
      query.append(" AND map.VAL_DEFE = '1' ");
      
      query.append(" UNION ");
      query.append(" SELECT '").append(ConstantesAPE.ORDEN_ANAQUEL).append("' AS combo, ");
      query.append(" anaq.OID_ANAQ_CABE ");
      query.append(" FROM APE_ORDEN_ANAQU_CABEC anaq, ");
      query.append(" APE_MAPA_ZONA_CABEC map, ");
      query.append(" APE_MAPA_CENTR_DISTR_CABEC cendist, ");
      query.append(" APP_CONFI_CENTR_DISTR conf ");
      query.append(" WHERE anaq.MZCA_OID_MAPA_ZONA_CABE = map.OID_MAPA_ZONA_CABE ");
      query.append(" AND map.MCDC_OID_MAPA_CENT_DIST_CABE = cendist.OID_MAPA_CENT_DIST_CABE ");
      query.append(" AND cendist.CCDI_OID_CONF_CENT_DIST = conf.OID_CONF_CENT_DIST ");
      query.append(" AND conf.PAIS_OID_PAIS = " + dtoe.getOidPais());
      query.append(" AND anaq.VAL_DEFE = 'S' ");
        
     try {
          rs = bs.dbService.executeStaticQuery(query.toString());    
     } catch(Exception e) {
          UtilidadesLog.debug(e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     DTOSalida dtoSalida = new DTOSalida();
     dtoSalida.setResultado(rs);
     UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerValoresDefecto(DTOBelcorp dtoe): Salida");
     return dtoSalida;
  }
  
  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 18/1/2007
   */
    public DTOOID obtenerCentrosDistribucionXDefecto(DTOBelcorp dtoe) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerCentrosDistribucionXDefecto"+
        "(DTOBelcorp dtoe): Entrada");
        
        DTOOID dtoOid = new DTOOID();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT centro.OID_CONF_CENT_DIST ");
        query.append(" FROM APP_CONFI_CENTR_DISTR centro ");
        query.append(" WHERE centro.PAIS_OID_PAIS = " + dtoe.getOidPais());
        query.append(" AND centro.VAL_DEFE = 'S'");
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if(!rs.esVacio()) {
            dtoOid.setOid(new Long(((BigDecimal)rs.getValueAt(0,"OID_CONF_CENT_DIST")).toString()));         
        }
        
        UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerCentrosDistribucionXDefecto"+
        "(DTOBelcorp dtoe): Salida");
        
        return dtoOid;    
    }
    
    
    /**
     * Recupera OID y descripción i18n del centro de distribucion por defecto
     * para el pais recibido en el parámetro. Creado por BELC400000198
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet que contiene OID y descripcion del centro por defecto
     * @param dtoe DTOBelcorp con país e idioma
     * @author dmorello
     * @since 06-03-2007
     */
    public RecordSet obtenerCentrosDistribucionXDefectoMasDescripcion(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerCentrosDistribucionXDefectoMasDescripcion(DTOBelcorp dtoe): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT centro.oid_conf_cent_dist, gen.val_i18n ");
        query.append("  FROM app_confi_centr_distr centro, v_gen_i18n_sicc gen ");
        query.append(" WHERE centro.pais_oid_pais = ").append(dtoe.getOidPais());
        query.append("   AND centro.val_defe = 'S' ");
        query.append("   AND centro.oid_conf_cent_dist = gen.val_oid ");
        query.append("   AND gen.idio_oid_idio = ").append(dtoe.getOidIdioma());
        query.append("   AND gen.attr_enti = 'APP_CONFI_CENTR_DISTR'");
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerCentrosDistribucionXDefectoMasDescripcion(DTOBelcorp dtoe): Salida");
        return rs;
    }

    /**
     * Se hace una consulta en la entidad AgrupacionAFP y se obtiene oid y descripcion(i18N).
     * Se utiliza para: carga de combo "Agrupacion default para AFP (Region/Zona/Seccion)".
     * @autor eiraola
     * @since 17/05/2007
     */   
    public DTOSalida obtenerAgrupacionAFP(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerAgrupacionAFP" + 
                           "(DTOBelcorp dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet rs = null;
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT aafp.OID_AAFP AS OID, ");
        query.append(       "i18n.VAL_I18N AS DESCRIPCION ");
        query.append(  "FROM APE_AGRUP_AFP aafp, ");
        query.append(       "V_GEN_I18N_SICC i18n ");
        query.append( "WHERE i18n.VAL_OID = aafp.OID_AAFP ");
        query.append(   "AND i18n.ATTR_ENTI = 'APE_AGRUP_AFP' ");
        query.append(   "AND i18n.ATTR_NUM_ATRI = 1 ");
        query.append(   "AND i18n.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.obtenerAgrupacionAFP: Exception ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerAgrupacionAFP" + 
                           "(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

    /**
     * Se hace una consulta en la entidad OrdenListaPicado y se obtiene oid y descripcion 
     * (i18N). Se utiliza para: carga de combo "Orden lista de picado".
     * @autor eiraola
     * @since 17/05/2007
     */   
    public DTOSalida obtenerOrdenListaPicado(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerOrdenListaPicado" + 
                           "(DTOBelcorp dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet rs = null;
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT olp.OID_ORDE_LIST_PICA AS OID, ");
        query.append(       "i18n.VAL_I18N AS DESCRIPCION ");
        query.append(  "FROM APE_ORDEN_LISTA_PICAD olp, ");
        query.append(       "V_GEN_I18N_SICC i18n ");
        query.append( "WHERE i18n.VAL_OID = olp.OID_ORDE_LIST_PICA ");
        query.append(   "AND i18n.ATTR_ENTI = 'APE_ORDEN_LISTA_PICAD' ");
        query.append(   "AND i18n.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18n.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("<dao>.obtenerOrdenListaPicado: Exception ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOMantenimientoCentroDistribucion.obtenerOrdenListaPicado" + 
                           "(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
    public DTOSalida codigoVisualizacionCheque(DTOBelcorp dtoe) throws MareException{
        UtilidadesLog.info("DAOManteniminetoCentroDistribucion.codigoVisualizacionCheque(DTOBelcorp dtoe): Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet rs = null;        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT APE_ORDEN_VISUA_CHEQU.OID_ORDE_VISU_CHEQ, APE_ORDEN_VISUA_CHEQU.DES_VISU_CHEQ");
        query.append("        FROM APE_ORDEN_VISUA_CHEQU ");
        //query.append(" ");
         try {
             rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception e) {
             UtilidadesLog.error("<dao>.obtenerOrdenListaPicado: Exception ", e);
             throw new MareException(e, UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
         
         dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOManteniminetoCentroDistribucion.codigoVisualizacionCheque(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
}