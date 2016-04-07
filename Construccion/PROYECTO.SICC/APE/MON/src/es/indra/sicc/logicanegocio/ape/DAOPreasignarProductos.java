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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.ape.DTOPreasignarProducto;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelDetalle;
import java.util.ArrayList;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOOID;

public class DAOPreasignarProductos  {
  public DAOPreasignarProductos() {
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       6/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOSalida obtenerFuentesPeriodoPreasignacion(DTOBelcorp dtoe) throws MareException {
      UtilidadesLog.info("DAOPreasignarProductos.obtenerFuentesPeriodoPreasignacion(DTOBelcorp dtoe): Entrada");
        
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

      query.append(" SELECT fuent.VAL_CODI, i.val_i18n DESCRIPCION ");
      query.append(" FROM APE_FUENT_PERIO_PREAS fuent, v_gen_i18n_sicc i  ");
      query.append(" WHERE i.attr_enti = 'APE_FUENT_PERIO_PREAS' ");
      query.append(" and i.idio_oid_idio =" + dtoe.getOidIdioma());
      query.append(" and i.attr_num_atri = 1 ");
      query.append(" AND i.val_oid = fuent.OID_FUENT_PERIO_PREAS ");
      query.append(" order by i.val_i18n ");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
     
      dtoSalida.setResultado(rs);

      UtilidadesLog.info("DAOPreasignarProductos.obtenerFuentesPeriodoPreasignacion(DTOBelcorp dtoe): Salida");
      return dtoSalida;
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       6/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public ArrayList obtenerProductosMapaCDPeriodoActual(DTOPreasignarProducto dtoe) throws MareException {
      UtilidadesLog.info("DAOPreasignarProductos.obtenerProductosMapaCDPeriodoActual(DTOPreasignarProducto dtoe): Entrada");
        
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      ArrayList productos = new ArrayList();

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT DISTINCT det.PROD_OID_PROD ");
      query.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC cab, ");
      query.append(" APE_ASIGN_PRODU_ANAQU_DETAL det ");
      query.append(" WHERE det.APAC_OID_ASIG_PROD_ANAQ_CABE = cab.OID_ASIG_PROD_ANAQ_CABE ");
      query.append(" AND cab.PERD_OID_PERI = " + dtoe.getOidPeriodoDestino());
      query.append(" AND cab.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoe.getOidMapaCD());

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();      
      for(int i=0; i<cant; i++){      
          productos.add(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PROD_OID_PROD")).toString()));
      }
      
      UtilidadesLog.debug("productos: " + productos);

      UtilidadesLog.info("DAOPreasignarProductos.obtenerProductosMapaCDPeriodoActual(DTOPreasignarProducto dtoe): Salida");
      return productos;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       6/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    
     /* Modificado por: Cristian Valenzuela
       Incidencia: BELC400000347
       Fecha: 20/04/2007 */

  public ArrayList obtenerProductosAPreasignar(DTOPreasignarProducto dtoe) throws MareException {
      UtilidadesLog.info("DAOPreasignarProductos.obtenerProductosAPreasignar(DTOPreasignarProducto dtoe): Entrada");
      
      String fuenteOrigen = null;
      String fuenteOrigenUnidadesEstimadas = null;
      String fuenteDestino = null;
      String fuenteDestinoUnidadesEstimadas = null;
      
      if(dtoe.getCodFuentePeriodoOrigen().equals(ConstantesAPE.FUENTE_ESTIMADO)){
          fuenteOrigen = "APE_ESTIM_PRODU fuenteOrigen";
          fuenteOrigenUnidadesEstimadas = "fuenteOrigen.NUM_UNID_ESTI";
          fuenteDestino = "APE_ESTIM_PRODU fuenteDestino";
          fuenteDestinoUnidadesEstimadas = "fuenteDestino.NUM_UNID_ESTI";
      } else if(dtoe.getCodFuentePeriodoOrigen().equals(ConstantesAPE.FUENTE_FACT_PROY)){
          fuenteOrigen = "INT_FACTU_PROYE fuenteOrigen";
          fuenteOrigenUnidadesEstimadas = "fuenteOrigen.NUM_UNID_PROY";
          fuenteDestino = "INT_FACTU_PROYE fuenteDestino";
          fuenteDestinoUnidadesEstimadas = "fuenteDestino.NUM_UNID_PROY";
      }
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      ArrayList productos = new ArrayList();
      String inOidProd = "";

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT " + fuenteDestinoUnidadesEstimadas + " UNIDADESESTIMADASACTUAL, fuenteDestino.PROD_OID_PROD, ");
      query.append(" mapCenDet.IND_EXPA, mapCenDet.OID_MAPA_CENT_DIST_DETA, mapCenDet.MCDD_OID_MAPA_CENT_DIST_DETA ");
      query.append(" FROM APE_ASIGN_PRODU_ANAQU_CABEC cab, APE_ASIGN_PRODU_ANAQU_DETAL det, ");
      query.append(" APE_MAPA_CENTR_DISTR_DETAL mapCenDet, " + fuenteDestino + ", " + fuenteOrigen);
      query.append(" WHERE det.APAC_OID_ASIG_PROD_ANAQ_CABE = cab.OID_ASIG_PROD_ANAQ_CABE ");
      query.append(" AND det.MCDD_OID_MAPA_CENT_DIST_DETA = mapCenDet.OID_MAPA_CENT_DIST_DETA ");
      query.append(" AND cab.PERD_OID_PERI = " + dtoe.getOidPeriodoOrigen());
      query.append(" AND cab.OID_ASIG_PROD_ANAQ_CABE = " + dtoe.getVersionOrigen());
      query.append(" AND cab.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoe.getOidMapaCD());
      
      query.append(" AND det.PROD_OID_PROD = fuenteDestino.PROD_OID_PROD ");
      query.append(" AND fuenteDestino.PERD_OID_PERI = " + dtoe.getOidPeriodoDestino());
      query.append(" AND " + fuenteDestinoUnidadesEstimadas + " IS NOT NULL ");
      
      if(dtoe.getCodFuentePeriodoOrigen().equals(ConstantesAPE.FUENTE_ESTIMADO)){
          query.append(" AND fuenteDestino.LIAR_OID_LINE_ARMA = " + dtoe.getOidLinea());
      }
      
      query.append(" AND fuenteOrigen.PERD_OID_PERI = " + dtoe.getOidPeriodoOrigen());
      query.append(" AND " + fuenteOrigenUnidadesEstimadas + " IS NOT NULL ");
      
      if(dtoe.getCodFuentePeriodoOrigen().equals(ConstantesAPE.FUENTE_ESTIMADO)){
          query.append(" AND fuenteOrigen.LIAR_OID_LINE_ARMA = " + dtoe.getOidLinea());
      }
      
      query.append(" AND fuenteDestino.PROD_OID_PROD = fuenteOrigen.PROD_OID_PROD ");
      query.append(" AND (ABS(" + fuenteOrigenUnidadesEstimadas + " - " + fuenteDestinoUnidadesEstimadas + " ) / ");
      query.append("  " + fuenteOrigenUnidadesEstimadas + " * 100 ) <= " + dtoe.getPorcentajeVariacionEstimado());
      
      query.append(" AND DECODE(mapcendet.IND_EXPA, 1, ");
      query.append("               (SELECT COUNT(1) ");
      query.append("               FROM APE_ASIGN_PRODU_ANAQU_CABEC cabAct, "); 
      query.append("               APE_ASIGN_PRODU_ANAQU_DETAL detAct, "); 
      query.append("               APE_MAPA_CENTR_DISTR_DETAL mapCenDet1 ");
      query.append("               WHERE detAct.APAC_OID_ASIG_PROD_ANAQ_CABE = cabAct.OID_ASIG_PROD_ANAQ_CABE ");
      query.append("               AND cabAct.PERD_OID_PERI = " + dtoe.getOidPeriodoDestino());
      // vbongiov -- BELC400000619 -- 6/08/2007
      query.append("               AND cabAct.OID_ASIG_PROD_ANAQ_CABE = " + dtoe.getOidAsignacionProductoAnaquelCabDestino());
      query.append("               AND cabAct.MCDC_OID_MAPA_CENT_DIST_CABE = mapCenDet1.MCDC_OID_MAPA_CENT_DIST_CABE ");
			query.append("		           AND mapCenDet1.OID_MAPA_CENT_DIST_DETA= mapcendet.mcdd_oid_mapa_cent_dist_deta ");
      query.append("		           AND mapcendet1.OID_MAPA_CENT_DIST_DETA = detact.MCDD_OID_MAPA_CENT_DIST_DETA) ");
      query.append("    ,0, ");
      query.append("               (SELECT COUNT(1) ");
      query.append("               FROM APE_ASIGN_PRODU_ANAQU_CABEC cabAct, "); 
      query.append("               APE_ASIGN_PRODU_ANAQU_DETAL detAct, "); 
      query.append("               APE_MAPA_CENTR_DISTR_DETAL mapCenDet1 ");
      query.append("               WHERE detAct.APAC_OID_ASIG_PROD_ANAQ_CABE = cabAct.OID_ASIG_PROD_ANAQ_CABE ");
      query.append("               AND cabAct.PERD_OID_PERI = " + dtoe.getOidPeriodoDestino());
      // vbongiov -- BELC400000619 -- 6/08/2007
      query.append("               AND cabAct.OID_ASIG_PROD_ANAQ_CABE = " + dtoe.getOidAsignacionProductoAnaquelCabDestino());
      query.append("               AND cabAct.MCDC_OID_MAPA_CENT_DIST_CABE = mapCenDet1.MCDC_OID_MAPA_CENT_DIST_CABE ");
			query.append("		           AND mapCenDet1.OID_MAPA_CENT_DIST_DETA= mapcendet.OID_MAPA_CENT_DIST_DETA ");
      query.append("		           AND mapcendet1.OID_MAPA_CENT_DIST_DETA = detact.MCDD_OID_MAPA_CENT_DIST_DETA) ");
      query.append("    )= 0 ");
     
      ArrayList prodPerDestino = dtoe.getLstProdAnaqPerioActual();
      int cant = prodPerDestino.size();
      
      for (int i = 0; i < cant; i++) {
           inOidProd = inOidProd + "," + (Long)prodPerDestino.get(i);
      }
      
      if(cant!=0){
          query.append("  AND fuenteDestino.PROD_OID_PROD NOT IN ( " + inOidProd.substring(1) + ") ");      
      }

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      ArrayList lstRetorno = new ArrayList();      
      int cantRs = rs.getRowCount();
      DTOAsignacionProductoAnaquelDetalle dtoAsignacionProductoAnaquelDetalle = null;
      Boolean indExp = null;
      
      for(int j=0; j< cantRs; j++){
          dtoAsignacionProductoAnaquelDetalle = new DTOAsignacionProductoAnaquelDetalle();
          
          dtoAsignacionProductoAnaquelDetalle.setOidAsignacionProductoCabecera(dtoe.getOidAsignacionProductoAnaquelCabecera());
          
          //dtoAsignacionProductoAnaquelDetalle.setProcedencia(ConstantesAPE.COD_PREASIGNACION);
          dtoAsignacionProductoAnaquelDetalle.setProcedencia(ConstantesAPE.OID_PROCEDENCIA_PREASIGNACION.toString());
          
          dtoAsignacionProductoAnaquelDetalle.setUnidades(Long.valueOf(((BigDecimal)rs.getValueAt(j,"UNIDADESESTIMADASACTUAL")).toString()));
          dtoAsignacionProductoAnaquelDetalle.setOidProducto(Long.valueOf(((BigDecimal)rs.getValueAt(j,"PROD_OID_PROD")).toString()));
          
          indExp = ((BigDecimal)rs.getValueAt(j,"IND_EXPA")).toString().equals("1")?Boolean.TRUE:Boolean.FALSE;
          
          UtilidadesLog.debug("IND_EXPA: " + (BigDecimal)rs.getValueAt(j,"IND_EXPA"));
          UtilidadesLog.debug("indExp: " + indExp);
          
          if(indExp.booleanValue()){
              dtoAsignacionProductoAnaquelDetalle.setOidMapaCDDetalle(Long.valueOf(((BigDecimal)rs.getValueAt(j,"MCDD_OID_MAPA_CENT_DIST_DETA")).toString()));
          } else {
              dtoAsignacionProductoAnaquelDetalle.setOidMapaCDDetalle(Long.valueOf(((BigDecimal)rs.getValueAt(j,"OID_MAPA_CENT_DIST_DETA")).toString()));
          }
          
          lstRetorno.add(dtoAsignacionProductoAnaquelDetalle);          
      }
      
      UtilidadesLog.debug("lstRetorno: " + lstRetorno);
      
      UtilidadesLog.info("DAOPreasignarProductos.obtenerProductosAPreasignar(DTOPreasignarProducto dtoe): Salida");
      return lstRetorno;
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       4/05/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOSalida obtenerPeriodoSiguiente(DTOOID oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOPreasignarProductos.obtenerPeriodoSiguiente(DTOOID oidPeriodo:Entrada");
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida= new DTOSalida();
        
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            query.append(" SELECT B.oid_peri, B.val_nomb_peri ");
            query.append(" FROM cra_perio A, cra_perio B ");
            query.append(" WHERE A.oid_peri = " + oidPeriodo.getOid());
            query.append(" AND B.pais_oid_pais = A.pais_oid_pais ");
            query.append(" AND B.marc_oid_marc = A.marc_oid_marc ");
            query.append(" AND B.cana_oid_cana = A.cana_oid_cana ");
            query.append(" AND B.fec_inic > A.fec_inic ");
            query.append(" ORDER BY B.fec_inic ");                        

            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        dtoSalida.setResultado(respuesta);
        UtilidadesLog.info("DAOPreasignarProductos.obtenerPeriodoSiguiente(DTOOID oidPeriodo:Salida");
        
        return dtoSalida;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       26/07/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    *  Inc  BELC400000599
    */
  public RecordSet existeProductosPreasignados(DTOPreasignarProducto dtoe) throws MareException {
        UtilidadesLog.info("DAOPreasignarProductos.existeProductosPreasignados(DTOPreasignarProducto dtoe):Entrada");
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            query.append(" SELECT det.OID_ASIG_PROD_ANAQ ");
            query.append(" FROM APE_ASIGN_PRODU_ANAQU_DETAL det, APE_ASIGN_PRODU_ANAQU_CABEC cab ");
            query.append(" WHERE det.APAC_OID_ASIG_PROD_ANAQ_CABE = cab.OID_ASIG_PROD_ANAQ_CABE ");
            query.append(" AND cab.PERD_OID_PERI = " + dtoe.getOidPeriodoDestino());
            query.append(" AND cab.VAL_VERS = '" + dtoe.getVersionDestino() + "' ");
            query.append(" AND cab.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoe.getOidMapaCD());

            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOPreasignarProductos.existeProductosPreasignados(DTOPreasignarProducto dtoe):Salida");
        
        return respuesta;
    }
  
}