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
 */
 
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTOExpandirAnaquel;
import es.indra.sicc.dtos.ape.DTOMantenerConfiguracionBalanceo;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionCabecera;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionDetalle;
import es.indra.sicc.dtos.ape.DTOMapaZonasCabecera;
import es.indra.sicc.dtos.ape.DTOMapaZonasDetalle;
import es.indra.sicc.dtos.ape.DTOMapaZonasDetalleSubLineas;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.dtos.ape.DTOMapaZonaCombo;
import es.indra.sicc.entidades.ape.MapaCentroDistribucionCabeceraLocal;
import es.indra.sicc.entidades.ape.MapaCentroDistribucionCabeceraLocalHome;
import es.indra.sicc.entidades.ape.MapaCentroDistribucionDetalleLocal;
import es.indra.sicc.entidades.ape.MapaCentroDistribucionDetalleLocalHome;
import es.indra.sicc.entidades.ape.MapaZonaCabeceraLocal;
import es.indra.sicc.entidades.ape.MapaZonaCabeceraLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class DAOMantenimientoMapas  {

    public DAOMantenimientoMapas() {

    }
  
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       23/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOSalida obtenerMapasCDPorCD(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapasCDPorCD(DTOOID dtoe): Entrada");
        
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

        query.append(" SELECT DISTINCT cab.OID_MAPA_CENT_DIST_CABE, i18n.VAL_I18N ");
        query.append(" FROM APE_MAPA_CENTR_DISTR_CABEC cab, ");
        query.append(" APE_MAPA_CENTR_DISTR_DETAL det, v_gen_i18n_sicc i18n ");
        query.append(" WHERE det.MCDC_OID_MAPA_CENT_DIST_CABE = cab.OID_MAPA_CENT_DIST_CABE ");        
        query.append(" AND cab.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOid());
        query.append(" AND cab.OID_MAPA_CENT_DIST_CABE = i18n.VAL_OID ");
        query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
        query.append(" AND i18n.attr_num_atri = 1  ");
        query.append(" AND i18n.attr_enti = 'APE_MAPA_CENTR_DISTR_CABEC' ");
        query.append(" ORDER BY i18n.VAL_I18N ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapasCDPorCD(DTOOID dtoe): Salida");
        return dtoSalida;
    }
    
    /**
     * Para la recarga del combo 'Mapa de zonas' a partir de un valor seleccionado
     * en el combo 'Mapa centro distribucion'
     * Sistema:     Belcorp
     * Modulo:      APE
     * Fecha:       24/01/2007
     * @version     1.0
     * @autor       Emilio Iraola
     */
    public DTOSalida obtenerMapaZonaPorMapaCD(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapaZonaPorMapaCD(DTOOID dtoe): Entrada");
        
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

        if(dtoe instanceof DTOMapaZonaCombo){
            query.append(" select mz.oid_mapa_zona_cabe||'|'||mz.VAL_DEFE OID, i.val_i18n DESCRIPCION ");
            
        } else {
            query.append(" select mz.oid_mapa_zona_cabe OID, i.val_i18n DESCRIPCION ");
        }
        
        query.append("   from ape_mapa_zona_cabec mz, ");
        query.append("        v_gen_i18n_sicc i ");
        query.append("  where mz.mcdc_oid_mapa_cent_dist_cabe = " + dtoe.getOid());
        query.append("    and i.attr_enti = 'APE_MAPA_ZONA_CABEC' ");
        query.append("    and i.idio_oid_idio =" + dtoe.getOidIdioma());
        query.append("    and i.attr_num_atri = 1 ");
        query.append("    and i.val_oid = mz.oid_mapa_zona_cabe ");
        query.append(" order by i.val_i18n ");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapaZonaPorMapaCD(DTOOID dtoe): Salida");
        return dtoSalida;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public Long obtenerOIDMapaZonasDefault(DTOOID oidMapaCD) throws MareException {
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerOIDMapaZonasDefault(DTOOID oidMapaCD): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT cab.OID_MAPA_ZONA_CABE ");
        query.append(" FROM APE_MAPA_ZONA_CABEC cab ");
        query.append(" WHERE cab.MCDC_OID_MAPA_CENT_DIST_CABE = " + oidMapaCD.getOid());
        query.append(" AND cab.VAL_DEFE = '1' ");        

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if(!rs.esVacio()){
          UtilidadesLog.info("DAOMantenimientoMapas.obtenerOIDMapaZonasDefault(DTOOID oidMapaCD): Salida");
          return Long.valueOf(((BigDecimal)rs.getValueAt(0,"OID_MAPA_ZONA_CABE")).toString());
        } else {
          UtilidadesLog.info("DAOMantenimientoMapas.obtenerOIDMapaZonasDefault(DTOOID oidMapaCD): Salida");       
          return null;
        }
    }
    
    /**
    * Modificado por BELC400000321 - dmorello, 25/04/2007
    * Pasa a devolver un ArrayList de objetos de tipo DatosZona
    * 
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/01/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public ArrayList obtenerDatosZona(DTOOIDs oidsSublinea, Long oidMapaCentroDistribucionCab) throws MareException {
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerDatosZona(DTOOIDs oidsSublinea, Long oidMapaCentroDistribucionCab): Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        String inOidSublineas = "";
        /* BELC400000321 - dmorello, 25/04/2007: Este objeto queda sin uso */
        //DatosZona datosZona = new DatosZona();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        // Armo el IN
        int cant = oidsSublinea.getOids().length;
        Long[] oidSublineas = oidsSublinea.getOids();
        
        for (int i = 0; i < cant; i++) {
           inOidSublineas = inOidSublineas + "," + oidSublineas[i];
        }

        /*
         * dmorello, 27/04/2007
         * Se corrige query para recuperar un solo registro para cada sublínea
         * y para no omitir sublíneas.
         */
        //query.append(" SELECT sublin.OID_SUBL_ARMA, SUBSTR(det.NUM_ANAQ,2,2) BAHIAMAYOR, ");
        query.append(" SELECT sublin.OID_SUBL_ARMA, MAX(SUBSTR(det.NUM_ANAQ,2,2)) BAHIAMAYOR, "); /* dmorello 27/04/07 */
        query.append(" DECODE(sublin.IND_FREN_ESPA,1,1,2) INCREMENTO ");
        /* BELC400000321 - dmorello, 25/04/2007 */
        query.append(" , sublin.ind_fren_espa ");
        query.append(" , ( (sublin.num_bahi_fren * 2) - 1 ) AS maxBahiaImpar ");
        query.append(" , DECODE( sublin.ind_fren_espa,1,(sublin.num_bahi_espa * 2),null ) AS maxBahiaPar ");
        /* Fin BELC400000321 dmorello 25/04/2007 */
        query.append(" FROM APE_MAPA_CENTR_DISTR_DETAL det, APE_SUBLI_ARMAD sublin ");
        query.append(" WHERE det.SBAR_OID_SUBL_ARMA = sublin.OID_SUBL_ARMA ");   
        // vbongiov -- LG_V400000053 -- 6/11/2007
        query.append(" AND det.MCDC_OID_MAPA_CENT_DIST_CABE = " + oidMapaCentroDistribucionCab);
        query.append(" AND det.SBAR_OID_SUBL_ARMA IN ( " + inOidSublineas.substring(1) + ") ");
        /* dmorello, 27/04/2007: Agrego group by para los valores maximos */
        query.append(" GROUP BY sublin.oid_subl_arma, sublin.ind_fren_espa, ");
        query.append("          sublin.num_bahi_fren, sublin.num_bahi_espa ");
        //query.append(" AND SUBSTR(det.NUM_ANAQ,2,2) = ( ");
        //query.append("           SELECT MAX(SUBSTR(det.NUM_ANAQ,2,2)) ");
        //query.append("           FROM APE_MAPA_CENTR_DISTR_DETAL det, APE_SUBLI_ARMAD sublin ");
        //query.append("           WHERE det.SBAR_OID_SUBL_ARMA = sublin.OID_SUBL_ARMA ");
        //query.append("           AND det.SBAR_OID_SUBL_ARMA IN ( " + inOidSublineas.substring(1) + ")) ");
        /* Fin dmorello 27/04/2007 */

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        

        /*
         * BELC400000321 - dmorello, 25/04/2007
         * Armo un DatosZona por cada registro del recordset y lo agrego
         * a la siguiente lista:
         */
        ArrayList listaDatosZonas = new ArrayList();
        
        if(!rs.esVacio()){
        
          /* dmorello, 25/04/2007: Tomo todos los registros del recordset */
          
          //datosZona.setOidSublinea(Long.valueOf(((BigDecimal)rs.getValueAt(0,"OID_SUBL_ARMA")).toString()));
          //datosZona.setBahiaMayor(Integer.valueOf((String)rs.getValueAt(0,"BAHIAMAYOR")));
          //datosZona.setIncremento(Integer.valueOf(((BigDecimal)rs.getValueAt(0,"INCREMENTO")).toString()));      
          
          DatosZona datosZona = null;
          int size = rs.getRowCount();
          for (int i = 0; i < size; i++) {
              datosZona = new DatosZona();
              
              datosZona.setOidSublinea(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_SUBL_ARMA")).toString()));
              datosZona.setBahiaMayor(Integer.valueOf((String)rs.getValueAt(i,"BAHIAMAYOR")));
              datosZona.setIncremento(Integer.valueOf(((BigDecimal)rs.getValueAt(i,"INCREMENTO")).toString()));
              
              int indFrenteEspalda = ((BigDecimal)rs.getValueAt(i, "IND_FREN_ESPA")).intValue();
              datosZona.setFrenteEspalda(Boolean.valueOf(ConstantesAPE.TRUE.intValue() == indFrenteEspalda));
              
              datosZona.setMaxBahiaImpar(new Integer(((BigDecimal)rs.getValueAt(i, "MAXBAHIAIMPAR")).intValue()));
              if (datosZona.getFrenteEspalda().booleanValue()) {
                  datosZona.setMaxBahiaPar(new Integer(((BigDecimal)rs.getValueAt(i, "MAXBAHIAPAR")).intValue()));
              }
              
              UtilidadesLog.debug("DatosZonas creado:");
              UtilidadesLog.debug("oidSublinea: " + datosZona.getOidSublinea());
              UtilidadesLog.debug("bahiaMayor: " + datosZona.getBahiaMayor());
              UtilidadesLog.debug("incremento: " + datosZona.getIncremento());
              UtilidadesLog.debug("frenteEspalda: " + datosZona.getFrenteEspalda());
              UtilidadesLog.debug("maxBahiaImpar: " + datosZona.getMaxBahiaImpar());
              UtilidadesLog.debug("maxBahiaPar: " + datosZona.getMaxBahiaPar());
              
              listaDatosZonas.add(datosZona);
          }
          
          //UtilidadesLog.info("DAOMantenimientoMapas.obtenerDatosZona(DTOOIDs oidsSublinea): Salida");
          //return datosZona;
          
        } else {
          /* BELC400000321 - dmorello, 25/04/2007: Bloque sin sentido */
          //UtilidadesLog.info("DAOMantenimientoMapas.obtenerDatosZona(DTOOIDs oidsSublinea): Salida");       
          //return datosZona;
        }
        
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerDatosZona(DTOOIDs oidsSublinea, Long oidMapaCentroDistribucionCab): Salida");
        return listaDatosZonas;
        /* Fin BELC400000321 dmorello 25/04/2007 */
    }
    
  /**
  * Sistema:     Belcorp
  * Modulo:      APE
  * Fecha:       30/01/2007
  * @version     1.0
  * @autor       Viviana Bongiovanni
  */
  public DTOSalida obtenerMapaZonasCabecera(DTOOID dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapaZonasCabecera(DTOOID dtoe): Entrada");
        
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      DTOSalida dtoSalida = new DTOSalida();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT map.OID_MAPA_ZONA_CABE, i18n.VAL_I18N DESC_MAPZONA, map.VAL_DEFE, ");
      query.append(" map.MCDC_OID_MAPA_CENT_DIST_CABE, i18n_1.VAL_I18N DESC_MAPCEN, ");
      query.append(" mapCen.CCDI_OID_CONF_CENT_DIST, i18n_2.VAL_I18N DESC_CONFCEN ");
      query.append(" FROM APE_MAPA_ZONA_CABEC map, APE_MAPA_CENTR_DISTR_CABEC mapCen, ");        
      query.append(" v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n_1, v_gen_i18n_sicc i18n_2 ");    
      query.append(" WHERE MAP.OID_MAPA_ZONA_CABE = " + dtoe.getOid());    
      query.append(" AND map.OID_MAPA_ZONA_CABE = i18n.VAL_OID ");    
      query.append(" AND i18n.attr_enti = 'APE_MAPA_ZONA_CABEC' ");    
      query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());    
      query.append(" AND i18n.attr_num_atri = 1 ");    
      query.append(" AND map.MCDC_OID_MAPA_CENT_DIST_CABE = i18n_1.VAL_OID ");   
      query.append(" AND i18n_1.attr_enti = 'APE_MAPA_CENTR_DISTR_CABEC' ");    
      query.append(" AND i18n_1.idio_oid_idio = " + dtoe.getOidIdioma());    
      query.append(" AND i18n_1.attr_num_atri = 1 ");    
      query.append(" AND map.MCDC_OID_MAPA_CENT_DIST_CABE = mapCen.OID_MAPA_CENT_DIST_CABE ");    
      query.append(" AND mapCen.CCDI_OID_CONF_CENT_DIST = i18n_2.VAL_OID ");    
      query.append(" AND i18n_2.attr_enti = 'APP_CONFI_CENTR_DISTR' ");    
      query.append(" AND i18n_2.idio_oid_idio = " + dtoe.getOidIdioma());    
      query.append(" AND i18n_2.attr_num_atri = 1 ");   

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("rs: " + rs);
      dtoSalida.setResultado(rs);
      
      UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapaZonasCabecera(DTOOID dtoe): Salida");       
      return dtoSalida;
  }
  
  /**
  * Sistema:     Belcorp
  * Modulo:      APE
  * Fecha:       30/01/2007
  * @version     1.0
  * @autor       Viviana Bongiovanni
  */
  public DTOMapaZonasDetalleSubLineas obtenerMapaZonasDetalle(DTOOID dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapaZonasDetalle(DTOOID dtoe): Entrada");
        
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      DTOMapaZonasDetalleSubLineas dtoSalida = new DTOMapaZonasDetalleSubLineas();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT mapDet.OID_MAPA_ZONA_DETA, mapDet.SBAR_OID_SUBL_ARMA, ");
      query.append(" mapDet.NUM_IDZO, mapDet.NUM_BAHI_DESD, ");
      query.append(" mapDet.NUM_BAHI_HAST, subLin.LIAR_OID_LINE_ARMA, i18n.val_i18n DESC_LIN ");
      query.append(" FROM APE_MAPA_ZONA_DETAL mapDet, APE_SUBLI_ARMAD subLin, v_gen_i18n_sicc i18n ");        
      query.append(" WHERE mapDet.SBAR_OID_SUBL_ARMA = subLin.OID_SUBL_ARMA	 ");    
      query.append(" AND mapDet.MZCA_OID_MAPA_ZONA_CABE = " + dtoe.getOid());  
      query.append(" AND subLin.LIAR_OID_LINE_ARMA = i18n.val_oid ");   
      query.append(" AND i18n.attr_enti = 'APE_LINEA_ARMAD' ");   
      query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());   
      query.append(" AND i18n.attr_num_atri = 1 ");   
      query.append(" ORDER BY mapDet.SBAR_OID_SUBL_ARMA, mapDet.NUM_BAHI_DESD ");   

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      // Detalles de Mapa Zonas
      UtilidadesLog.debug("rs: " + rs);
      dtoSalida.setMapaZonasDetalle(rs);
      
      
      // Busca las SubLineas
      DAOMantenimientoLineaSublinea daoMantenimientoLineaSublinea = new DAOMantenimientoLineaSublinea();
      DTOOID dtoid= new DTOOID();
      dtoid.setOid(Long.valueOf(((BigDecimal)rs.getValueAt(0,"LIAR_OID_LINE_ARMA")).toString()));
      dtoid.setOidIdioma(dtoe.getOidIdioma());
      
      // Datos del combo subLineas
      dtoSalida.setSubLineas(daoMantenimientoLineaSublinea.obtenerSublineasLinea(dtoid).getResultado());
      
      UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapaZonasDetalle(DTOOID dtoe): Salida");       
      return dtoSalida;
  }
  
  /**
  * Sistema:     Belcorp
  * Modulo:      APE
  * Fecha:       2/02/2007
  * @version     1.0
  * @autor       Viviana Bongiovanni
  */
  public ArrayList obtenerDetallesACopiar(DTOMapaZonasDetalle dtoe, DTOMapaZonasCabecera dtoMapaZonasCabeceraDestino) throws MareException {
      UtilidadesLog.info("DAOMantenimientoMapas.obtenerDetallesACopiar(DTOMapaZonasDetalle dtoe): Entrada");
        
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      ArrayList detalles = new ArrayList();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT det.SBAR_OID_SUBL_ARMA, det.NUM_IDZO, ");
      query.append(" det.NUM_BAHI_DESD, det.NUM_BAHI_HAST ");
      query.append(" FROM APE_MAPA_ZONA_DETAL det, APE_SUBLI_ARMAD sublin ");   
      query.append(" WHERE det.MZCA_OID_MAPA_ZONA_CABE = " + dtoe.getMapaZonaCabecera().getOid());  
      query.append(" AND det.SBAR_OID_SUBL_ARMA = sublin.OID_SUBL_ARMA ");   
      query.append(" AND sublin.LIAR_OID_LINE_ARMA = " + dtoe.getSublineaArmado().getLineaArmado().getOid());   

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      // Detalles de Mapa Zonas
      UtilidadesLog.debug("rs: " + rs);
      
      int cant = rs.getRowCount();
      DTOSublineaArmado dtoSublineaArmado = null;
      DTOMapaZonasDetalle dtoMapaZonasDetalle = null;
      
      for(int i=0; i< cant; i++){
          dtoSublineaArmado = new DTOSublineaArmado();
          dtoSublineaArmado.setOid(Long.valueOf(((BigDecimal)rs.getValueAt(i,"SBAR_OID_SUBL_ARMA")).toString()));
          
          dtoMapaZonasDetalle = new DTOMapaZonasDetalle();          
          dtoMapaZonasDetalle.setSublineaArmado(dtoSublineaArmado);
          dtoMapaZonasDetalle.setOidZona(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_IDZO")).toString()));
          dtoMapaZonasDetalle.setBahiaDesde(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_BAHI_DESD")).toString()));
          dtoMapaZonasDetalle.setBahiaHasta(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_BAHI_HAST")).toString()));
          dtoMapaZonasDetalle.setMapaZonaCabecera(dtoMapaZonasCabeceraDestino);
          
          detalles.add(dtoMapaZonasDetalle);
      }      
     
      UtilidadesLog.info("DAOMantenimientoMapas.obtenerDetallesACopiar(DTOMapaZonasDetalle dtoe): Salida");       
      return detalles;
  }
  
  
  /**
  * Sistema:     Belcorp
  * Modulo:      APE
  * Fecha:       31/01/2007
  * @version     1.0
  * @autor       Viviana Bongiovanni
  */
  public void eliminarMapaZonasCabecera(DTOOID dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoMapas.eliminarMapaZonasCabecera(DTOOID dtoe): Entrada");
      
      try {
          MapaZonaCabeceraLocalHome mapaZonaCabLH = new MapaZonaCabeceraLocalHome();
          Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
          
          UtilidadesLog.debug("dtoe.getOid(): " + dtoe.getOid());  
          UtilidadesLog.debug("dtoe.getOidIdioma(): " + dtoe.getOidIdioma());  
          MapaZonaCabeceraLocal mapaZonaCabL = mapaZonaCabLH.findByPrimaryKey(dtoe.getOid());
          
          try {
              mapaZonaCabLH.remove(mapaZonaCabL);
          } catch (PersistenceException e) {
              UtilidadesLog.error("Error al eliminar: ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          }
              
          // Elimino descripcion internacionalizada
          Entidadi18nLocal entidadi18n = null;
          Collection col = entidadi18nLocalHome.findByEntAtrPK("APE_MAPA_ZONA_CABEC", new Long(1), dtoe.getOid());
              
          try {
              Iterator it = col.iterator();
              while (it.hasNext()){
                  entidadi18n= (Entidadi18nLocal)it.next();
                  entidadi18nLocalHome.remove(entidadi18n);
              }
          } catch (PersistenceException e) {
              UtilidadesLog.error("Error al eliminar: ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          }
          
      }   catch (NoResultException e){  
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }   catch (PersistenceException e){  
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("DAOMantenimientoMapas.eliminarMapaZonasCabecera(DTOOID dtoe): Salida");  
  }
  
  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 5/2/2007
   */
    public DTOSalida obtenerProximoCodigoMapaCD(DTOBelcorp dtoe) 
        throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerProximoCodigoMapaCD"+
        "(DTOBelcorp dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT DECODE(MAX (AMCDC.NUM_CODI_MAPA), NULL, 0, ");
        query.append(" MAX (AMCDC.NUM_CODI_MAPA)) AS CODIGOMAPA ");
        query.append(" FROM APE_MAPA_CENTR_DISTR_CABEC AMCDC ");
        
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
    
        Long codigo = new Long(((BigDecimal)rs.getValueAt(0,"CODIGOMAPA")).longValue());
        UtilidadesLog.debug("******** codigo " + codigo);
        Long proxCodigo = new Long(codigo.longValue() + 1);
        rs.setValueAt(proxCodigo,0,0);     
        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOMantenimientoMapas.obtenerProximoCodigoMapaCD"+
        "(DTOBelcorp dtoe): Salida");        
        
        return dtoSalida;    
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 12/2/2007
   */
    public DTOSalida obtenerNumerosAnaquelPorMapaCD(DTOOID oidMapaCD) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerNumerosAnaquelPorMapaCD"+
        "(DTOOID oidMapaCD): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT MAPADETALLE.OID_MAPA_CENT_DIST_DETA, ");
        query.append(" MAPADETALLE.NUM_ANAQ ");
        query.append(" FROM APE_MAPA_CENTR_DISTR_DETAL MAPADETALLE ");
        query.append(" WHERE MAPADETALLE.MCDC_OID_MAPA_CENT_DIST_CABE = " + oidMapaCD.getOid());
        query.append(" ORDER BY MAPADETALLE.NUM_ANAQ ");        
        
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

        UtilidadesLog.info("DAOMantenimientoMapas.obtenerNumerosAnaquelPorMapaCD"+
        "(DTOOID oidMapaCD): Entrada");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 12/2/2007
   */
    public DTOSalida buscarAnaquelesExpandidos(DTOOID dtoe) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.buscarAnaquelesExpandidos"+
        "(DTOOID dtoe): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT MAPADETALLE.OID_MAPA_CENT_DIST_DETA AS OID, ");
        query.append(" MAPADETALLE.NUM_ANAQ, 1 AS NUM_CAPA ");
        query.append(" FROM APE_MAPA_CENTR_DISTR_DETAL MAPADETALLE ");
        query.append(" WHERE MAPADETALLE.OID_MAPA_CENT_DIST_DETA = " + dtoe.getOid());
        query.append(" OR MAPADETALLE.MCDD_OID_MAPA_CENT_DIST_DETA = " + dtoe.getOid());
        
        String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);
        
        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(queryPaginada.toString());
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

        UtilidadesLog.info("DAOMantenimientoMapas.buscarAnaquelesExpandidos"+
        "(DTOOID dtoe): Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 13/2/2007
   */
    public void expandirAnaquel(DTOExpandirAnaquel dtoe) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.expandirAnaquel"+
        "(DTOExpandirAnaquel dtoe): Entrada");
            
        try {           
            DTOMapaCentroDistribucionDetalle anaquelDestino = dtoe.getAnaquelDestino();
            DTOOIDs anaquelesOrigen = dtoe.getAnaquelesOrigen();
            
            UtilidadesLog.debug("**** DTOMapaCentroDistribucionDetalle " + anaquelDestino);
            UtilidadesLog.debug("**** DTOOIDs " + anaquelesOrigen);
            
            MapaCentroDistribucionDetalleLocalHome mcddlh = new MapaCentroDistribucionDetalleLocalHome();    
            
            MapaCentroDistribucionDetalleLocal mcddl = mcddlh.findByPrimaryKey(anaquelDestino.getOid());
            mcddl.setCapacidad(anaquelDestino.getCapacidad());
            try {
                mcddlh.merge(mcddl);
            } catch (PersistenceException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            Long[] oids = anaquelesOrigen.getOids();
            int cant = oids.length;
            UtilidadesLog.debug("**** DTOOIDs.oids.length: " + cant);
            
            for(int i=0; i<cant; i++) {
                 MapaCentroDistribucionDetalleLocal mapaLocal = mcddlh.findByPrimaryKey(oids[i]);
                 mapaLocal.setExpandido(Boolean.TRUE);
                 mapaLocal.setAnaquelDestino(anaquelDestino.getOid());                
                    try {
                        mcddlh.merge(mapaLocal);
                    } catch (PersistenceException e) {
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
            }           
        }
        catch (NoResultException e) {
            UtilidadesLog.error("DAOAsignacionProductos.eliminarEstimadosProducto: NoResultException", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch (PersistenceException e) {
            UtilidadesLog.error("DAOAsignacionProductos.eliminarEstimadosProducto: NoResultException", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMantenimientoMapas.expandirAnaquel"+
        "(DTOExpandirAnaquel dtoe): Salida");
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 13/2/2007
   */
    public void dividirAnaquel(DTOOIDs anaquelesDividir) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.dividirAnaquel"+
        "(DTOOIDs anaquelesDividir): Entrada");
        
        try  {
            Long[] oids = anaquelesDividir.getOids();
            int cant = oids.length;
            UtilidadesLog.debug("**** DTOOIDs.oids.length " + cant);
            
            MapaCentroDistribucionDetalleLocalHome mcddlh = new MapaCentroDistribucionDetalleLocalHome();   
            
            /* BELC400000660 - dmorello, 05/09/2007 */
            if (cant > 1) {
                for(int i=0; i<cant; i++) {
                    MapaCentroDistribucionDetalleLocal mcddl = mcddlh.findByPrimaryKey(oids[i]);
                    mcddl.setExpandido(Boolean.FALSE);
                    mcddl.setAnaquelDestino(null);
                    mcddl.setCapacidad(new Long(1));
                    try {
                        mcddlh.merge(mcddl);
                    } catch (PersistenceException e) {
                        UtilidadesLog.error("Error en merge: ", e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }      
            } else {
                // dmorello, 05/09/2007
                // Se recibió un único anaquel; si el mismo tiene IND_EXPA activo,
                // hay que actualizar la capacidad del anaquel destino restándole 1.
                MapaCentroDistribucionDetalleLocal detalle = mcddlh.findByPrimaryKey(oids[0]);
                UtilidadesLog.debug("Anaquel a actualizar: " + detalle);
                if (detalle.getExpandido().booleanValue()) {
                    UtilidadesLog.debug("Voy a actualizar anaquel destino!");
                    MapaCentroDistribucionDetalleLocal destino = mcddlh.findByPrimaryKey(detalle.getAnaquelDestino());
                    destino.setCapacidad(new Long(destino.getCapacidad().longValue() - 1));
                    UtilidadesLog.debug("Anaquel destino luego de actualizar: " + destino);
                }
                detalle.setExpandido(Boolean.FALSE);
                detalle.setAnaquelDestino(null);
                detalle.setCapacidad(new Long(1));
                
                try {
                    mcddlh.merge(detalle);
                } catch (PersistenceException e) {
                    UtilidadesLog.error("Error en merge: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                UtilidadesLog.debug("Anaquel luego de actualizar: " + detalle);
            }
            /* Fin BELC400000660 - dmorello, 05/09/2007 */
        }
         catch (NoResultException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch (PersistenceException e) {
            UtilidadesLog.error("DAOAsignacionProductos.eliminarEstimadosProducto: PersistenceException", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        
        UtilidadesLog.info("DAOMantenimientoMapas.dividirAnaquel"+
        "(DTOOIDs anaquelesDividir): Salida");        
    }
    
 /** 
   * Autor: Cristian Valenzuela
   * Fecha: 13/2/2007
   */
   
   /* Modificado por: Cristian Valenzuela
      Fecha: 4/5/2007  */
    public Boolean existenProductosEnAnaqueles(DTOOIDs anaqueles, Long oidPeriodo) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.existenProductosEnAnaqueles "+
        "(DTOOIDs anaqueles): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        Long[] oids = anaqueles.getOids();
        int cant = oids.length;
        UtilidadesLog.debug("**** DTOOIDs.oids.length " + cant);
        
        String strOids = this.generaINClause(oids);
        
        query.append(" SELECT DETALLE.OID_ASIG_PROD_ANAQ  ");
        query.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC CABECERA,  ");
        query.append(" APE_ASIGN_PRODU_ANAQU_DETAL DETALLE,  ");
        query.append(" CRA_PERIO PERIODO  ");
        query.append(" WHERE CABECERA.PERD_OID_PERI = " + oidPeriodo);
		query.append(" AND CABECERA.PERD_OID_PERI = PERIODO.OID_PERI  ");
        query.append(" AND PERIODO.FEC_FINA >=TRUNC(SYSDATE)  ");
        query.append(" AND DETALLE.APAC_OID_ASIG_PROD_ANAQ_CABE = CABECERA.OID_ASIG_PROD_ANAQ_CABE  ");
        query.append(" AND DETALLE.MCDD_OID_MAPA_CENT_DIST_DETA " + strOids);               
        
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
        
        Boolean respuesta;
        
        if(rs.esVacio()) {
            respuesta = Boolean.FALSE;
        }
        else  {
            respuesta = Boolean.TRUE;
        }
        
        UtilidadesLog.info("DAOMantenimientoMapas.existenProductosEnAnaqueles "+
        "(DTOOIDs anaqueles): Salida");
        return respuesta;
    }
    
    private String generaINClause(Long[] oids) throws MareException {
        UtilidadesLog.info("DAOMantenimientoMapas.generaINClause(Long[] oids): Entrada");
        StringBuffer sClausula = new StringBuffer("");

        try {
            sClausula.append(" IN ( ");
            for (int i = 0; i < oids.length; i++) {
                Long oid = oids[i];
                if (i != 0) {
                    sClausula.append(", ");
                }
                sClausula.append("" + oid);
            }
            sClausula.append(")");
        }
        catch (Exception ex) {            
        }

        UtilidadesLog.info("DAOMantenimientoMapas.generaINClause(Long[] oids): Salida");
        return sClausula.toString();
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 13/2/2007
   */
    public void moverProductos (DTOOIDs anaquelesOrigen, DTOMapaCentroDistribucionDetalle anaquelDestino) 
    throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.moverProductos"+
        "(DTOOIDs anaquelesOrigen, DTOMapaCentroDistribucionDetalle anaquelDestino): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        Long[] oids = anaquelesOrigen.getOids();
        int cant = oids.length;
        UtilidadesLog.debug("**** DTOOIDs.oids.length " + cant);
        
        String strOids = this.generaINClause(oids);
        
        UtilidadesLog.debug("***** Obteniendo oids de APE_ASIGN_PRODU_ANAQU_DETAL...");
        
        query.append(" SELECT DETALLE.OID_ASIG_PROD_ANAQ ");
        query.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC CABECERA, ");
        query.append(" APE_ASIGN_PRODU_ANAQU_DETAL DETALLE, ");
        query.append(" CRA_PERIO PERIODO ");
        query.append(" WHERE CABECERA.PERD_OID_PERI = PERIODO.OID_PERI ");
        query.append(" AND PERIODO.FEC_FINA >=TRUNC(SYSDATE) ");
        query.append(" AND DETALLE.APAC_OID_ASIG_PROD_ANAQ_CABE = CABECERA.OID_ASIG_PROD_ANAQ_CABE ");
        query.append(" AND DETALLE.MCDD_OID_MAPA_CENT_DIST_DETA " + strOids);     
        
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
        
        int longitud = rs.getRowCount();
        UtilidadesLog.debug("**** longitud " + longitud);
        Long[] oidsRecuperados = new Long[longitud];
        for(int i=0; i<longitud; i++) {
            oidsRecuperados[i] = new Long(((BigDecimal)rs.getValueAt(i,"OID_ASIG_PROD_ANAQ")).longValue());
        }
        
        String strOidsRecuperados = this.generaINClause(oidsRecuperados);
        
        UtilidadesLog.debug("***** Actualizando APE_ASIGN_PRODU_ANAQU_DETAL...");
        StringBuffer sqlQuery = new StringBuffer("");
        
        sqlQuery.append(" UPDATE APE_ASIGN_PRODU_ANAQU_DETAL ");
        sqlQuery.append(" SET APE_ASIGN_PRODU_ANAQU_DETAL.MCDD_OID_MAPA_CENT_DIST_DETA = " + anaquelDestino.getOid());
        sqlQuery.append(" WHERE APE_ASIGN_PRODU_ANAQU_DETAL.OID_ASIG_PROD_ANAQ " + strOidsRecuperados);
        
        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            belcorpService.dbService.executeUpdate(sqlQuery.toString());       
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
        
        UtilidadesLog.info("DAOMantenimientoMapas.moverProductos"+
        "(DTOOIDs anaquelesOrigen, DTOMapaCentroDistribucionDetalle anaquelDestino): Salida");
    }
    
  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 19/2/2007
   */
    public void obtenerCopiaCabeceraMapaCD(DTOMapaCentroDistribucionCabecera dtoe) 
    throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerCopiaCabeceraMapaCD"+
        "(DTOMapaCentroDistribucionCabecera dtoe): Entrada");     
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT CABECERA.CCDI_OID_CONF_CENT_DIST, ");
        query.append(" CABECERA.NUM_CODI_MAPA ");        
        query.append(" FROM APE_MAPA_CENTR_DISTR_CABEC CABECERA ");
        query.append(" WHERE CABECERA.OID_MAPA_CENT_DIST_CABE = " + dtoe.getOid());
        
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
        
        DTOConfiguracionCentroDistribucion configuracionCD =  new DTOConfiguracionCentroDistribucion();
        configuracionCD.setOidCentroDistribucion(new Long((((BigDecimal)rs.getValueAt(0,"CCDI_OID_CONF_CENT_DIST")).longValue())));
        dtoe.setCentroDistribucion(configuracionCD); 
        
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        DTOSalida dtoSalida = this.obtenerProximoCodigoMapaCD(dtoBelcorp);
        RecordSet resultado = dtoSalida.getResultado();
		Long codigo = (Long)resultado.getValueAt(0,"CODIGOMAPA");
        dtoe.setCodigoMapa(codigo);        
        
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerCopiaCabeceraMapaCD"+
        "(DTOMapaCentroDistribucionCabecera dtoe): Salida");
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 19/2/2007
   */
    public ArrayList obtenerCopiaDetalleMapaCD(DTOMapaCentroDistribucionCabecera dtoe) 
    throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerCopiaDetalleMapaCD"+
        "(DTOMapaCentroDistribucionCabecera dtoe): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        /* BELC400000661 - dmorello, 28/08/2007
         * Se agrega recuperacion de número de anaquel destino */
        query.append(" SELECT DETALLE.NUM_CAPA, ");
        query.append(" DETALLE.IND_EXPA, ");
        query.append(" DETALLE.NUM_ANAQ, ");
        query.append(" DETALLE.MCDD_OID_MAPA_CENT_DIST_DETA, ");
        query.append(" DETALLE.SBAR_OID_SUBL_ARMA ");
        query.append(" , DETALLE_DESTINO.NUM_ANAQ AS NUM_ANAQ_DESTINO ");  // dmorello 28/08/2007
        query.append(" FROM APE_MAPA_CENTR_DISTR_DETAL DETALLE ");
        query.append(" , APE_MAPA_CENTR_DISTR_DETAL DETALLE_DESTINO ");  // dmorello 28/08/2007
        query.append(" WHERE DETALLE.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoe.getOid());
        // dmorello 28/08/2007
        query.append("   AND DETALLE.MCDD_OID_MAPA_CENT_DIST_DETA = DETALLE_DESTINO.OID_MAPA_CENT_DIST_DETA (+) ");
        /* Fin BELC400000661 dmorello 28/08/2007 */
        
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
        
        ArrayList dtos = new ArrayList();
        int cant = rs.getRowCount();
        UtilidadesLog.debug("************ cant " + cant);
        
        for(int i=0; i<cant; i++) {
            DTOMapaCentroDistribucionDetalle dtoTemp = new DTOMapaCentroDistribucionDetalle();
            dtoTemp.setCapacidad(new Long(((BigDecimal)rs.getValueAt(i,"NUM_CAPA")).longValue())) ;
        
            BigDecimal valor = (BigDecimal)rs.getValueAt(i,"IND_EXPA");
            if(valor.longValue()==1){
                dtoTemp.setExpandido(Boolean.TRUE);    
            }
            else{
                dtoTemp.setExpandido(Boolean.FALSE);
            }            
            
            dtoTemp.setNumeroAnaquel((String)rs.getValueAt(i,"NUM_ANAQ"));
            
            if(rs.getValueAt(i,"MCDD_OID_MAPA_CENT_DIST_DETA")!=null) {
                DTOMapaCentroDistribucionDetalle dtoAnaquelDestino = new DTOMapaCentroDistribucionDetalle();
                dtoAnaquelDestino.setOid(new Long(((BigDecimal)rs.getValueAt(i,"MCDD_OID_MAPA_CENT_DIST_DETA")).longValue()));
                dtoTemp.setAnaquelDestino(dtoAnaquelDestino);
            }
            
            /* BELC400000661 - dmorello, 29/08/2007 */
            Object numAnaqDestino = rs.getValueAt(i, "NUM_ANAQ_DESTINO");
            if (numAnaqDestino != null) {
                DTOMapaCentroDistribucionDetalle dtoDetalle = new DTOMapaCentroDistribucionDetalle();
                dtoDetalle.setNumeroAnaquel(numAnaqDestino.toString());
                dtoTemp.setAnaquelDestino(dtoDetalle);
            }
            /* Fin BELC400000661 dmorello 29/08/2007 */
            
            DTOSublineaArmado dtoSublinea = new DTOSublineaArmado();
            dtoSublinea.setOid(new Long(((BigDecimal)rs.getValueAt(i,"SBAR_OID_SUBL_ARMA")).longValue()));
            dtoTemp.setSublineaArmado(dtoSublinea);
            
            dtos.add(dtoTemp);        
        }
        
        UtilidadesLog.info("DAOMantenimientoMapas.obtenerCopiaDetalleMapaCD"+
        "(DTOMapaCentroDistribucionCabecera dtoe): Salida");
        
        return dtos;
    }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 19/2/2007
   */
    public void copiarMapaCentroDistribucion (DTOMapaCentroDistribucionCabecera dtoe,
    ArrayList detalles) throws MareException {             
        UtilidadesLog.info("DAOMantenimientoMapas.copiarMapaCentroDistribucion"+       
        "(DTOMapaCentroDistribucionCabecera dtoe, ArrayList detalles): Entrada");
        
        UtilidadesLog.debug("********** DTOMapaCentroDistribucionCabecera " + dtoe);
        
        try {
            MapaCentroDistribucionCabeceraLocalHome mcdclh = new MapaCentroDistribucionCabeceraLocalHome();     
            MapaCentroDistribucionCabeceraLocal mcdcl;
            
            try {
                mcdcl = mcdclh.create(dtoe.getCodigoMapa(),
                    dtoe.getCentroDistribucion().getOidCentroDistribucion());
            } catch (PersistenceException e) {
                UtilidadesLog.error("Error en create: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            //Este campo es internacionalizable
            Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
            Iterator it = dtoe.getAttriTraducible().iterator();
            while (it.hasNext()) {
                DTOI18nSICC dto = (DTOI18nSICC) it.next();                
                try {
                    UtilidadesLog.debug("************* Antes de hacer el create en Entidad i18n");
                    entidadi18nLocalHome.create("APE_MAPA_CENTR_DISTR_CABEC", 
                        new Long(1), dto.getOidIdioma(), dto.getValorI18n(), mcdcl.getOid());
                    UtilidadesLog.debug("************* Despues de hacer el create en Entidad i18n");
                } catch (PersistenceException e) {
                    UtilidadesLog.error("Error al crear en EntidadI18n: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
            
            int cant = detalles.size();
            UtilidadesLog.debug("************* cant " + cant);
            
            /* BELC400000661 - dmorello, 29/08/2007 */
            HashMap hashAnaquelesDestino = new HashMap();
            MapaCentroDistribucionDetalleLocalHome mcddlh = new MapaCentroDistribucionDetalleLocalHome();
            
            for(int i=0; i<cant; i++) {
                DTOMapaCentroDistribucionDetalle unDetalle = (DTOMapaCentroDistribucionDetalle)detalles.get(i);
                DTOSublineaArmado dtoSublinea = unDetalle.getSublineaArmado();
                DTOMapaCentroDistribucionDetalle anaquelDestino = unDetalle.getAnaquelDestino();
                
                UtilidadesLog.debug("********** DTOMapaCentroDistribucionDetalle " + unDetalle);
                UtilidadesLog.debug("********** DTOSublineaArmado " + dtoSublinea);
                UtilidadesLog.debug("********** DTOMapaCentroDistribucionDetalle " + anaquelDestino);
                
                MapaCentroDistribucionDetalleLocal mcddl;
                try {
                    mcddl = mcddlh.create(unDetalle.getNumeroAnaquel(), 
                        unDetalle.getCapacidad(), mcdcl.getOid(), dtoSublinea.getOid(), unDetalle.getExpandido());
                } catch (PersistenceException e) {
                    UtilidadesLog.error("Error en create: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                /* BELC400000661 - dmorello, 29/08/2007
                 * Se guarda el número de anaquel destino en el HashMap para setearlo bien más adelante */
                //if(anaquelDestino!=null && anaquelDestino.getOid()!=null) {
                //    mcddl.setAnaquelDestino(anaquelDestino.getOid());
                //}
                if (anaquelDestino != null && anaquelDestino.getNumeroAnaquel() != null) {
                    hashAnaquelesDestino.put(mcddl.getOid(), anaquelDestino.getNumeroAnaquel());
                }
            }

            /* BELC400000661 - dmorello, 29/08/2007 */
            Iterator it2 = hashAnaquelesDestino.keySet().iterator();
            while (it2.hasNext()) {
                // Busco el anaquel para setearle el anaquel destino
                Long oidAnaquel = (Long)it2.next();
                MapaCentroDistribucionDetalleLocal origen = mcddlh.findByPrimaryKey(oidAnaquel);
                
                // Busco el anaquel destino por UK para obtener su OID
                String numAnaqDest = hashAnaquelesDestino.get(oidAnaquel).toString();
                MapaCentroDistribucionDetalleLocal destino = mcddlh.findByUK(numAnaqDest, mcdcl.getOid());
                
                // Seteo el OID de anaquel destino en el primer anaquel
                origen.setAnaquelDestino(destino.getOid());
                
                try {
                    mcddlh.merge(origen);
                } catch (PersistenceException e) {
                    UtilidadesLog.error("Error en merge: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
            /* Fin BELC400000661 dmorello 29/08/2007 */
        }
        catch (NoResultException ne) {
          UtilidadesLog.error("ERROR ", ne);
          throw new MareException(ne, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (PersistenceException e) {
            UtilidadesLog.error("ERROR: " , e);
            throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOMantenimientoMapas.copiarMapaCentroDistribucion"+
        "(DTOMapaCentroDistribucionCabecera dtoe, ArrayList detalles): Salida");
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       22/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOSalida obtenerMapaCDPorCDYLinea(DTOMantenerConfiguracionBalanceo dtoe) throws MareException {
      UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapaCDPorCDYLinea(DTOMantenerConfiguracionBalanceo dtoe): Entrada");
      
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
  
      query.append(" SELECT DISTINCT cab.OID_MAPA_CENT_DIST_CABE, i18n.VAL_I18N ");
      query.append(" FROM APE_MAPA_CENTR_DISTR_CABEC cab, APE_MAPA_CENTR_DISTR_DETAL det, ");
      query.append(" APE_SUBLI_ARMAD sublin, v_gen_i18n_sicc i18n ");
      query.append(" WHERE det.MCDC_OID_MAPA_CENT_DIST_CABE = cab.OID_MAPA_CENT_DIST_CABE ");
      query.append(" AND det.SBAR_OID_SUBL_ARMA = sublin.OID_SUBL_ARMA  ");
      query.append(" AND cab.CCDI_OID_CONF_CENT_DIST = " + dtoe.getOidCentroDistribucion());
      query.append(" AND sublin.LIAR_OID_LINE_ARMA =  " + dtoe.getOidLineaArmado());
      query.append(" AND cab.OID_MAPA_CENT_DIST_CABE = i18n.VAL_OID ");
      query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
      query.append(" AND i18n.attr_num_atri = 1  ");
      query.append(" AND i18n.attr_enti = 'APE_MAPA_CENTR_DISTR_CABEC' ");
      query.append(" ORDER BY i18n.VAL_I18N ");
  
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
  
      dtoSalida.setResultado(rs);
  
      UtilidadesLog.info("DAOMantenimientoMapas.obtenerMapaCDPorCDYLinea(DTOMantenerConfiguracionBalanceo dtoe)): Salida");
      return dtoSalida;
  }
}