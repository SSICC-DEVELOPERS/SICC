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
 
package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOTiposImpuestosUbigeo;
import es.indra.sicc.logicanegocio.fac.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.sql.SQLException;
import java.util.Vector;
import javax.ejb.EJBException;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DAOTiposImpuestosUbigeo  {

  public DAOTiposImpuestosUbigeo() {
  }
 /**
  * @author Emilio Noziglia (Soy un manfloro que pongo los DAO en cualquier lado, esto va en el MON)
  * @date 15/08/2007
  * @throws MareException
  */    
  public RecordSet buscaTiposImpuestosPorUbigeo(DTOBelcorp dtoE) throws MareException {
  
        UtilidadesLog.info("DAOTiposImpuestosUbigeo.buscaTiposImpuestosPorUbigeo(): Entrada");
        
        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT TI.OID_TASA_IMPU OID, ITI.VAL_I18N DESCRIPCION ");
        sql.append(" FROM PED_TASA_IMPUE TI, V_GEN_I18N_SICC ITI "); 
        sql.append(" WHERE TI.OID_TASA_IMPU = ITI.VAL_OID ");
        sql.append(" AND ITI.ATTR_ENTI = 'PED_TASA_IMPUE' ");
        sql.append(" AND ITI.IDIO_OID_IDIO = "+dtoE.getOidIdioma()+" ");
        sql.append(" AND TI.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");        

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("rs: " + rs);

        if (rs.esVacio()) {
            UtilidadesLog.debug("****buscaTiposImpuestosPorUbigeo: no hay datos ");
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOTiposImpuestosUbigeo.buscaTiposImpuestosPorUbigeo(): Salida");
        return rs;  
  }

  public RecordSet consultarTiposImpuestosPorUbigeo(DTOSiccPaginacion dtoE) throws MareException {
        UtilidadesLog.info("DAOTiposImpuestosUbigeo.consultarTiposImpuestosPorUbigeo(DTOBelcorp dtoE): Entrada");
        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer();
        
        Long si = new Long(1);
        Long no = new Long(0);
        
        sql.append(" SELECT  TI.OID_TIPO_IMPU_UBIG OID, ICA.VAL_I18N CANAL, IAC.VAL_I18N ACCESO, ISB.VAL_I18N SUBACCESO, ");
        sql.append(" (SELECT zveg1.COD_UNID_GEOG||'/'||zveg1.des_geog ");
        sql.append(" FROM zon_valor_estru_geopo zveg1 ");
        sql.append(" WHERE zveg1.orde_1 = zveg.orde_1 ");
        sql.append(" AND zveg1.orde_2 IS NULL ");
        sql.append(" AND zveg1.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
        sql.append(" AND zveg1.IND_ACTI = "+si+" ");
        sql.append(" AND zveg1.IND_BORR = "+no+") ");
        sql.append(" || (SELECT ', ' || zveg1.COD_UNID_GEOG||'/'||zveg1.des_geog ");
        sql.append(" FROM zon_valor_estru_geopo zveg1 ");
        sql.append(" WHERE zveg1.orde_1 = zveg.orde_1 ");
        sql.append(" AND zveg1.orde_2 = zveg.orde_2 ");
        sql.append(" AND zveg1.orde_3 IS NULL ");
        sql.append(" AND zveg1.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
        sql.append(" AND zveg1.IND_ACTI = "+si+" ");
        sql.append(" AND zveg1.IND_BORR = "+no+") ");
        sql.append(" || (SELECT ', ' || zveg1.COD_UNID_GEOG||'/'||zveg1.des_geog ");
        sql.append(" FROM zon_valor_estru_geopo zveg1 ");
        sql.append(" WHERE zveg1.orde_1 = zveg.orde_1 ");
        sql.append(" AND zveg1.orde_2 = zveg.orde_2 ");
        sql.append(" AND zveg1.orde_3 = zveg.orde_3 ");
        sql.append(" AND zveg1.orde_4 IS NULL ");
        sql.append(" AND zveg1.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
        sql.append(" AND zveg1.IND_ACTI = "+si+" ");
        sql.append(" AND zveg1.IND_BORR = "+no+") ");
        sql.append(" || (SELECT ', ' || zveg1.COD_UNID_GEOG||'/'||zveg1.des_geog ");
        sql.append(" FROM zon_valor_estru_geopo zveg1 ");
        sql.append(" WHERE zveg1.orde_1 = zveg.orde_1 ");
        sql.append(" AND zveg1.orde_2 = zveg.orde_2 ");
        sql.append(" AND zveg1.orde_3 = zveg.orde_3 ");
        sql.append(" AND zveg1.orde_4 = zveg.orde_4 ");
        sql.append(" AND zveg1.orde_5 IS NULL ");
        sql.append(" AND zveg1.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
        sql.append(" AND zveg1.IND_ACTI = "+si+" ");
        sql.append(" AND zveg1.IND_BORR = "+no+") ");
        sql.append(" || (SELECT ', ' || zveg1.COD_UNID_GEOG||'/'||zveg1.des_geog ");
        sql.append(" FROM zon_valor_estru_geopo zveg1 ");
        sql.append(" WHERE zveg1.orde_1 = zveg.orde_1 ");
        sql.append(" AND zveg1.orde_2 = zveg.orde_2 ");
        sql.append(" AND zveg1.orde_3 = zveg.orde_3 ");
        sql.append(" AND zveg1.orde_4 = zveg.orde_4 ");
        sql.append(" AND zveg1.orde_5 = zveg.orde_5 ");
        sql.append(" AND zveg1.orde_6 IS NULL ");
        sql.append(" AND zveg1.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
        sql.append(" AND zveg1.IND_ACTI = "+si+" ");
        sql.append(" AND zveg1.IND_BORR = "+no+") ");
        sql.append(" || (SELECT ', ' || zveg1.COD_UNID_GEOG||'/'||zveg1.des_geog ");
        sql.append(" FROM zon_valor_estru_geopo zveg1 ");
        sql.append(" WHERE zveg1.orde_1 = zveg.orde_1 ");
        sql.append(" AND zveg1.orde_2 = zveg.orde_2 ");
        sql.append(" AND zveg1.orde_3 = zveg.orde_3 ");
        sql.append(" AND zveg1.orde_4 = zveg.orde_4 ");
        sql.append(" AND zveg1.orde_5 = zveg.orde_5 ");
        sql.append(" AND zveg1.orde_6 = zveg.orde_6 ");
        sql.append(" AND zveg1.orde_7 IS NULL ");
        sql.append(" AND zveg1.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
        sql.append(" AND zveg1.IND_ACTI = "+si+" ");
        sql.append(" AND zveg1.IND_BORR = "+no+") ");
        sql.append(" || (SELECT ', ' || zveg1.COD_UNID_GEOG||'/'||zveg1.des_geog ");
        sql.append(" FROM zon_valor_estru_geopo zveg1 ");
        sql.append(" WHERE zveg1.orde_1 = zveg.orde_1 ");
        sql.append(" AND zveg1.orde_2 = zveg.orde_2 ");
        sql.append(" AND zveg1.orde_3 = zveg.orde_3 ");
        sql.append(" AND zveg1.orde_4 = zveg.orde_4 ");
        sql.append(" AND zveg1.orde_5 = zveg.orde_5 ");
        sql.append(" AND zveg1.orde_6 = zveg.orde_6 ");
        sql.append(" AND zveg1.orde_7 = zveg.orde_7 ");
        sql.append(" AND zveg1.orde_8 IS NULL ");
        sql.append(" AND zveg1.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
        sql.append(" AND zveg1.IND_ACTI = "+si+" ");
        sql.append(" AND zveg1.IND_BORR = "+no+") ");
        sql.append(" || (SELECT ', ' || zveg1.COD_UNID_GEOG||'/'||zveg1.des_geog ");
        sql.append(" FROM zon_valor_estru_geopo zveg1 ");
        sql.append(" WHERE zveg1.orde_1 = zveg.orde_1 ");
        sql.append(" AND zveg1.orde_2 = zveg.orde_2 ");
        sql.append(" AND zveg1.orde_3 = zveg.orde_3 ");
        sql.append(" AND zveg1.orde_4 = zveg.orde_4 ");
        sql.append(" AND zveg1.orde_5 = zveg.orde_5 ");
        sql.append(" AND zveg1.orde_6 = zveg.orde_6 ");
        sql.append(" AND zveg1.orde_7 = zveg.orde_7 ");
        sql.append(" AND zveg1.orde_8 = zveg.orde_8 ");
        sql.append(" AND zveg1.orde_9 IS NULL ");
        sql.append(" AND zveg1.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
        sql.append(" AND zveg1.IND_ACTI = "+si+" ");
        sql.append(" AND zveg1.IND_BORR = "+no+") ");
        sql.append(" || (SELECT ', ' || zveg1.COD_UNID_GEOG||'/'||zveg1.des_geog ");
        sql.append(" FROM zon_valor_estru_geopo zveg1 ");
        sql.append(" WHERE zveg1.orde_1 = zveg.orde_1 ");
        sql.append(" AND zveg1.orde_2 = zveg.orde_2 ");
        sql.append(" AND zveg1.orde_3 = zveg.orde_3 ");
        sql.append(" AND zveg1.orde_4 = zveg.orde_4 ");
        sql.append(" AND zveg1.orde_5 = zveg.orde_5 ");
        sql.append(" AND zveg1.orde_6 = zveg.orde_6 ");
        sql.append(" AND zveg1.orde_7 = zveg.orde_7 ");
        sql.append(" AND zveg1.orde_8 = zveg.orde_8 ");
        sql.append(" AND zveg1.orde_9 = zveg.orde_9 ");
        sql.append(" AND zveg1.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");
        sql.append(" AND zveg1.IND_ACTI = "+si+" ");
        sql.append(" AND zveg1.IND_BORR = "+no+") DES_GEOG, ");
        sql.append(" INIM.VAL_I18N IND_IMPU ");
        sql.append(" FROM zon_valor_estru_geopo zveg, ");
        sql.append(" fac_tipos_impue_ubige ti, ");
        sql.append(" seg_subac sb, ");
        sql.append(" seg_acces ac, ");
        sql.append(" v_gen_i18n_sicc ica, ");
        sql.append(" v_gen_i18n_sicc iac, ");
        sql.append(" v_gen_i18n_sicc isb, ");
        sql.append(" v_gen_i18n_sicc inim ");
        sql.append(" WHERE zveg.oid_valo_estr_geop = ti.vepo_oid_valo_estr_geop ");
        sql.append(" and sb.ACCE_OID_ACCE = ac.oid_acce ");
        sql.append(" and ti.SBAC_OID_SBAC = sb.OID_SBAC ");
        sql.append(" AND ac.cana_oid_cana = ica.val_oid ");
        sql.append(" AND ica.attr_enti = 'SEG_CANAL' ");
        sql.append(" AND ica.idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        sql.append(" AND sb.acce_oid_acce = iac.val_oid ");
        sql.append(" AND iac.attr_enti = 'SEG_ACCES' ");
        sql.append(" AND iac.idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        sql.append(" AND ti.sbac_oid_sbac = isb.val_oid ");
        sql.append(" AND isb.attr_enti = 'SEG_SUBAC' ");
        sql.append(" AND isb.idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        sql.append(" AND ti.TAIM_OID_TASA_IMPU = inim.val_oid ");
        sql.append(" AND inim.attr_enti = 'PED_TASA_IMPUE' ");
        sql.append(" AND inim.idio_oid_idio = "+dtoE.getOidIdioma()+" ");
        sql.append(" AND ti.PAIS_OID_PAIS = "+dtoE.getOidPais()+" ");    
      
        String sqlPag = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoE);
      
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executeStaticQuery(sqlPag);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("Tipos de Impuesto Por UBIGEO: " + rs);

        if (rs.esVacio()) {
            UtilidadesLog.debug("****consultarTiposImpuestosPorUbigeo: no hay datos ");
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOTiposImpuestosUbigeo.consultarTiposImpuestosPorUbigeo(DTOBelcorp dtoE): Salida");
        return rs;    
  }  
  
  public void eliminarTiposImpuestosUbigeo(DTOOIDs dtoE) throws MareException {  
      UtilidadesLog.info("DAOTiposImpuestosUbigeo.eliminarTiposImpuestosUbigeo(DTOOIDs dtoE): Entrada");
      
      StringBuffer query = new StringBuffer();
      Long[] oids = dtoE.getOids();
      if(oids.length>0) { // Si hay OIDs en el DTO
        // Se extraen los OIDs del DTO
        StringBuffer sOids = new StringBuffer();
        for(int i=0;i<oids.length;i++) {
          sOids.append(oids[i]+",");
        }
        query.append(" BEGIN ");
        query.append(" DELETE FROM FAC_TIPOS_IMPUE_UBIGE ");
        query.append(" WHERE OID_TIPO_IMPU_UBIG IN ("+sOids.substring(0,sOids.length()-1)+"); ");
        query.append(" END; ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          int reg = bs.dbService.executeUpdate(query.toString());
          UtilidadesLog.debug("DAOTiposImpuestosUbigeo.eliminarTiposImpuestosUbigeo(DTOOIDs dtoE): Se han eliminado ["+reg+"] registros");
        } catch (Exception e) {
          UtilidadesLog.error("DAOTiposImpuestosUbigeo.eliminarTiposImpuestosUbigeo(DTOOIDs dtoE): Exception",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
      } else {
        UtilidadesLog.debug("DAOTiposImpuestosUbigeo.eliminarTiposImpuestosUbigeo(DTOOIDs dtoE): No hay OIDs en el DTO, length=0");
      }
        UtilidadesLog.info("DAOTiposImpuestosUbigeo.eliminarTiposImpuestosUbigeo(DTOOIDs dtoE): Salida");    
  }
  
  public void guardarTiposImpuestosPorUbigeo(DTOTiposImpuestosUbigeo dtoE) throws MareException {
        UtilidadesLog.info("DAOTiposImpuestosUbigeo.guardarTiposImpuestosPorUbigeo(DTOTiposImpuestosUbigeo dtoE): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        if (Boolean.TRUE.equals(dtoE.getModificacion())) {
          UtilidadesLog.debug("guardarTiposImpuestosPorUbigeo - modificacion");
          update.append(" UPDATE FAC_TIPOS_IMPUE_UBIGE ");
          update.append(" SET TAIM_OID_TASA_IMPU = "+dtoE.getIndicadorImpuesto()+" ");
          update.append(" WHERE OID_TIPO_IMPU_UBIG = "+dtoE.getOidTipoImpuestoUbigeo()+" ");
        } else {
          UtilidadesLog.debug("guardarTiposImpuestosPorUbigeo - insercion");
          update.append(" INSERT INTO FAC_TIPOS_IMPUE_UBIGE lpd ( ");
          update.append("   lpd.OID_TIPO_IMPU_UBIG, ");          // PK        
          update.append("   lpd.PAIS_OID_PAIS, ");               // UK
          update.append("   lpd.SBAC_OID_SBAC, ");               // UK
          update.append("   lpd.VEPO_OID_VALO_ESTR_GEOP, ");     // UK
          update.append("   lpd.TAIM_OID_TASA_IMPU ");           // UK
          update.append(" ) VALUES ( ");
          update.append("   FAC_FTIU_SEQ.nextval, ");        
          update.append(dtoE.getOidPais() + ", ");
          update.append(dtoE.getSubacceso() + ", ");
          update.append(dtoE.getOidValEstruGeopo() + ", ");
          update.append(dtoE.getIndicadorImpuesto() + " ");        
          update.append(" ) ");        
        }

        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            if (ex instanceof SQLException) {
                if (ex.toString().indexOf("FTIU_UK")>=0) {
                    throw new MareException(ex,
                      UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_FAC, "", ErroresDeNegocio.FAC_0008));
                }
            }
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOTiposImpuestosUbigeo.guardarTiposImpuestosPorUbigeo(DTOTiposImpuestosUbigeo dtoE): Salida");
  }
  
  private BelcorpService getBelcorpService() {
       try  {
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe)  {
            throw new EJBException( "MareMiiServiceNotFoundException: "
                        + mmsnfe.getMessage(), mmsnfe);
        } 
  }  
}