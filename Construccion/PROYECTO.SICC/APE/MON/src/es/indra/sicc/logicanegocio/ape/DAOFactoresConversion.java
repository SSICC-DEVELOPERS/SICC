package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOFactoresConversion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.util.Vector;

/**
 * @author Rafael Romero
 * @date 14/02/2007
 */
public class DAOFactoresConversion  {
  public DAOFactoresConversion() {
  }
  public RecordSet buscarFactoresConversion (DTOFactoresConversion dtoe) throws MareException{
    UtilidadesLog.debug("DAOFactoresConversion.buscarFactoresConversion(DTOFactoresConversion dtoe): Entrada");
    Vector parametros = new Vector();
    StringBuffer query = new StringBuffer();

    query.append("SELECT factor.oid_fact_conv OID, ");
    query.append("       (SELECT inter.val_i18n ");
    query.append("          FROM v_gen_i18n_sicc inter ");
    query.append("         WHERE inter.attr_enti = 'MAE_MAGNI' ");
    query.append("           AND inter.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
    query.append("           AND inter.val_oid = magnitud.oid_magn) AS des_magn, ");
    query.append("       (SELECT inter.val_i18n ");
    query.append("          FROM v_gen_i18n_sicc inter ");
    query.append("         WHERE inter.attr_enti = 'MAE_UNIDA_MEDID' ");
    query.append("           AND inter.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
    query.append("           AND inter.val_oid = factor.unmd_oid_unid_medi_orig) AS des_unid_med_orig, ");
    query.append("       (SELECT inter.val_i18n ");
    query.append("          FROM v_gen_i18n_sicc inter ");
    query.append("         WHERE inter.attr_enti = 'MAE_UNIDA_MEDID' ");
    query.append("           AND inter.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
    query.append("           AND inter.val_oid = factor.unmd_oid_unid_medi_dest) AS des_unid_med_dest, ");
    query.append("       factor.num_fact_conv, factor.magn_oid_magn oid_magn, ");
    query.append("       factor.unmd_oid_unid_medi_orig oid_unid_medi_orig, ");
    query.append("       factor.unmd_oid_unid_medi_dest oid_unid_medi_dest ");
    query.append("  FROM ape_facto_conve factor, ");
    query.append("       mae_magni magnitud, ");
    query.append("       mae_unida_medid umedorig, ");
    query.append("       mae_unida_medid umeddest ");
    query.append(" WHERE factor.magn_oid_magn = magnitud.oid_magn ");
    query.append("   AND factor.unmd_oid_unid_medi_orig = umedorig.oid_unid_medi ");
    query.append("   AND factor.unmd_oid_unid_medi_dest = umeddest.oid_unid_medi ");
    if(dtoe.getOidMagnitud()!=null){
      query.append("   AND factor.magn_oid_magn = ? ");
      parametros.add(dtoe.getOidMagnitud());
    }
    if(dtoe.getOidUnidadMedidaOrigen()!=null){
      query.append("   AND factor.unmd_oid_unid_medi_orig = ? ");
      parametros.add(dtoe.getOidUnidadMedidaOrigen());
    }
    if(dtoe.getOidUnidadMedidaDestino()!=null){
      query.append("   AND factor.unmd_oid_unid_medi_dest = ? ");
      parametros.add(dtoe.getOidUnidadMedidaDestino());
    }

    String sql = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dtoe);
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    RecordSet rs = null;
    try {
      rs = bs.dbService.executePreparedQuery(sql,parametros);
    } catch (Exception e) {
      UtilidadesLog.error("DAOFactoresConversion.buscarFactoresConversion(DTOFactoresConversion dtoe): Exception",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    if (rs.esVacio()) {
      UtilidadesLog.debug("DAOFactoresConversion.buscarFactoresConversion: no hay datos ");				
      throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    UtilidadesLog.debug("DAOFactoresConversion.buscarFactoresConversion(DTOFactoresConversion dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
    UtilidadesLog.debug("DAOFactoresConversion.buscarFactoresConversion(DTOFactoresConversion dtoe): Salida");
    return rs;
  }
  
  public void eliminarFactoresConversion(DTOOIDs dtoe) throws MareException{
    UtilidadesLog.debug("DAOFactoresConversion.eliminarFactoresConversion(DTOOIDs dtoe): Entrada");
    StringBuffer query = new StringBuffer();
    Long[] oids = dtoe.getOids();
    if(oids.length>0){ // Si hay OIDs en el DTO
      // Se extraen los OIDs del DTO
      StringBuffer sOids = new StringBuffer();
      for(int i=0;i<oids.length;i++){
        sOids.append(oids[i]+",");
      }
      // Se completa la instruccion SQL
      query.append("DELETE FROM ape_facto_conve ");
      query.append("      WHERE oid_fact_conv IN ("+sOids.substring(0,sOids.length()-1)+") ");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      try {
        int reg = bs.dbService.executeUpdate(query.toString());
        UtilidadesLog.debug("DAOFactoresConversion.eliminarFactoresConversion(DTOOIDs dtoe): Se han eliminado ["+reg+"] registros");
      } catch (Exception e) {
        UtilidadesLog.error("DAOFactoresConversion.eliminarFactoresConversion(DTOOIDs dtoe): Exception",e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
    }else{
      UtilidadesLog.debug("DAOFactoresConversion.eliminarFactoresConversion(DTOOIDs dtoe): No hay OIDs en el DTO, length=0");
    }
   
    UtilidadesLog.debug("DAOFactoresConversion.eliminarFactoresConversion(DTOOIDs dtoe): Salida");
  }
  public DTOSalida obtenerMagnitudes(DTOBelcorp dtoe) throws MareException{
    UtilidadesLog.debug("DAOFactoresConversion.obtenerMagnitudes(DTOBelcorp dtoe): Entrada");
    
     StringBuffer query = new StringBuffer();

    query.append("SELECT magnitud.oid_magn, ");
    query.append("       (SELECT inter.val_i18n ");
    query.append("          FROM v_gen_i18n_sicc inter ");
    query.append("         WHERE inter.attr_enti = 'MAE_MAGNI' ");
    query.append("           AND inter.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
    query.append("           AND inter.val_oid = magnitud.oid_magn) AS des_magn ");
    query.append("  FROM mae_magni magnitud ");

    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    RecordSet rs = null;
    try {
      rs = bs.dbService.executeStaticQuery(query.toString());
    } catch (Exception e) {
      UtilidadesLog.error("DAOFactoresConversion.obtenerMagnitudes(DTOBelcorp dtoe): Exception",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    if (rs.esVacio()) {
      UtilidadesLog.debug("DAOFactoresConversion.obtenerMagnitudes(DTOBelcorp dtoe): no hay datos ");				
      throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    UtilidadesLog.debug("DAOFactoresConversion.obtenerMagnitudes(DTOBelcorp dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
    DTOSalida dtoSalida = new DTOSalida(rs);
    UtilidadesLog.debug("DAOFactoresConversion.obtenerMagnitudes(DTOBelcorp dtoe): Salida");
    return dtoSalida;
  }
  public DTOSalida obtenerUnidadesMedidaPorMagnitud (DTOBelcorp dtoe) throws MareException{
    UtilidadesLog.debug("DAOFactoresConversion.obtenerUnidadesMedidaPorMagnitud(DTOBelcorp dtoe): Entrada");
    
     StringBuffer query = new StringBuffer();

    query.append("SELECT unidmedi.oid_unid_medi, ");
    query.append("       (SELECT inter.val_i18n ");
    query.append("          FROM v_gen_i18n_sicc inter ");
    query.append("         WHERE inter.attr_enti = 'MAE_UNIDA_MEDID' ");
    query.append("           AND inter.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
    query.append("           AND inter.val_oid = unidmedi.oid_unid_medi) AS des_unid_medi ");
    query.append("  FROM mae_unida_medid unidmedi ");
    // vbongiov -- BELC400000548 -- 4/07/2007
    if(dtoe instanceof DTOString) {
        query.append(" , MAE_MAGNI mag ");
    }
    
    query.append(" WHERE unidmedi.pais_oid_pais = "+dtoe.getOidPais()+" ");
    
    // vbongiov -- BELC400000548 -- 4/07/2007
    if(dtoe instanceof DTOString) {    
        DTOString dtoString= (DTOString)dtoe;
        
        query.append(" AND unidmedi.magn_oid_magn = mag.OID_MAGN ");
        query.append(" AND mag.COD_MAGN = '"+dtoString.getCadena()+"' ");
        
    } else if(dtoe instanceof DTOOID) {
        DTOOID dtoOid= (DTOOID)dtoe;
        
        query.append(" AND unidmedi.magn_oid_magn =" + dtoOid.getOid());
    }

    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    RecordSet rs = null;
    try {
      rs = bs.dbService.executeStaticQuery(query.toString());
    } catch (Exception e) {
      UtilidadesLog.error("DAOFactoresConversion.obtenerUnidadesMedidaPorMagnitud(DTOBelcorp dtoe): Exception",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    if (rs.esVacio()) {
      UtilidadesLog.debug("DAOFactoresConversion.obtenerUnidadesMedidaPorMagnitud(DTOBelcorp dtoe): no hay datos ");				
      throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    UtilidadesLog.debug("DAOFactoresConversion.obtenerUnidadesMedidaPorMagnitud(DTOBelcorp dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
    DTOSalida dtoSalida = new DTOSalida(rs);
    UtilidadesLog.debug("DAOFactoresConversion.obtenerUnidadesMedidaPorMagnitud(DTOBelcorp dtoe): Salida");
    return dtoSalida;
  }
}