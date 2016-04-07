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
package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.bel.DTOAlmacen;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.DTOOID;
import java.math.BigDecimal;

public class DAOAlmacen  {
  public DAOAlmacen() {
  }
  
  public DTOSalida buscarAlmacen(DTOAlmacen dtoe) throws MareException {
      UtilidadesLog.info("DAOAlmacen.buscarAlmacen(DTOAlmacen dtoe): Entrada");
      UtilidadesLog.debug("dtoe: " + dtoe);
        
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

        query.append(" SELECT alm.OID_ALMA OID, alm.COD_ALMA, i18n.VAL_I18N DESC_ALM, ");
        query.append(" alm.IND_INFO_SAP, i18n1.VAL_I18N DESC_CD ");
        query.append(" FROM BEL_ALMAC alm, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
        query.append(" WHERE alm.OID_ALMA = i18n.VAL_OID ");          
        query.append(" AND i18n.idio_oid_idio = 1 ");  
        query.append(" AND i18n.attr_num_atri = 1   ");  
        query.append(" AND i18n.attr_enti = 'BEL_ALMAC' ");  
        query.append(" AND alm.CCDI_OID_CONFI_CENTR_DISTR = i18n1.VAL_OID(+) ");  
        query.append(" AND i18n1.idio_oid_idio(+) = " + dtoe.getOidIdioma());  
        query.append(" AND i18n1.attr_num_atri(+) = 1 ");  
        query.append(" AND i18n1.attr_enti(+) = 'APP_CONFI_CENTR_DISTR' ");  
        
        if(dtoe.getCodAlmacen()!= null){
            query.append(" AND alm.COD_ALMA LIKE '" + dtoe.getCodAlmacen().toUpperCase() + "' ");  
        }
        
        if(dtoe.getDescripcion()!= null){
            query.append("AND i18n.VAL_I18N LIKE '" + dtoe.getDescripcion() + "' ");  
        }
        
        if(dtoe.getInfSAP().booleanValue()){
            query.append("AND alm.IND_INFO_SAP = 1 ");
        } else {
            query.append("AND alm.IND_INFO_SAP = 0 ");
        }
                
        if(dtoe.getOidCentroDistribucion()!= null){
            query.append(" AND alm.CCDI_OID_CONFI_CENTR_DISTR = " + dtoe.getOidCentroDistribucion());
        }

        try {
            rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe));
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.info("DAOAlmacen.buscarAlmacen(DTOAlmacen dtoe): Salida");
        return dtoSalida;
  }
  
  public DTOAlmacen obtenerAlmacen(DTOOID dtoe) throws MareException {
      UtilidadesLog.info("DAOAlmacen.obtenerAlmacen(DTOOID dtoe): Entrada");
        
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      DTOAlmacen dtoAlmacen = new DTOAlmacen();

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT alm.COD_ALMA, i18n.VAL_I18N DESC_ALM, ");
      query.append(" alm.IND_INFO_SAP, alm.CCDI_OID_CONFI_CENTR_DISTR ");
      query.append(" FROM BEL_ALMAC alm, v_gen_i18n_sicc i18n ");
      query.append(" WHERE alm.OID_ALMA = i18n.VAL_OID ");          
      query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
      query.append(" AND i18n.attr_num_atri = 1   ");  
      query.append(" AND i18n.attr_enti = 'BEL_ALMAC' "); 
      query.append(" AND alm.OID_ALMA =" + dtoe.getOid());        

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      dtoAlmacen.setCodAlmacen(rs.getValueAt(0,"COD_ALMA").toString());
      dtoAlmacen.setDescripcion(rs.getValueAt(0,"DESC_ALM").toString());
      dtoAlmacen.setInfSAP(((BigDecimal)rs.getValueAt(0,"IND_INFO_SAP")).equals(new BigDecimal(1))?Boolean.TRUE:Boolean.FALSE);
      
      BigDecimal oidCentroDistribucion = (BigDecimal)rs.getValueAt(0,"CCDI_OID_CONFI_CENTR_DISTR");      
      dtoAlmacen.setOidCentroDistribucion(oidCentroDistribucion!=null?Long.valueOf(oidCentroDistribucion.toString()):null);

      UtilidadesLog.debug("dtoAlmacen: " + dtoAlmacen);
      
      UtilidadesLog.info("DAOAlmacen.obtenerAlmacen(DTOOID dtoe): Salida");
      return dtoAlmacen;
  }
  
}