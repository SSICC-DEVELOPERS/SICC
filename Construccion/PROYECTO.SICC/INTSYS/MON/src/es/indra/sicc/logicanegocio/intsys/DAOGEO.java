package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.intsys.DTOINTDirecciones;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.util.Vector;
import java.util.ArrayList;


public class DAOGEO{
  
  
  public DAOGEO(){
  }


  public ArrayList obtenerDirecciones () throws MareException{
    
    UtilidadesLog.info("DAOGEO.obtenerDirecciones(): Entrada");
    
    StringBuffer consulta = new StringBuffer();
    
    consulta.append(" SELECT mcd.OID_CLIE_DIRE, sp.COD_PAIS, mc.COD_CLIE, ");
	  consulta.append(" mtd.COD_TIPO_DIRE, stv.COD_TIPO_VIA, mcd.VAL_NOMB_VIA, ");
    consulta.append(" mcd.NUM_PPAL, mcd.VAL_INTE, mcd.VAL_MANZ, mcd.VAL_LOTE, ");
    consulta.append(" mcd.VAL_KM, mcd.COD_UNID_GEOG ");
    consulta.append(" FROM mae_clien_direc mcd, mae_clien mc, seg_pais sp, ");
    consulta.append(" mae_tipo_direc mtd, seg_tipo_via stv ");
    consulta.append(" WHERE mcd.IND_CTRL_INTE_GEOR is null "); 
    consulta.append(" and mcd.CLIE_OID_CLIE = mc.OID_CLIE ");
    consulta.append(" and mc.PAIS_OID_PAIS = sp.OID_PAIS ");
    consulta.append(" and mcd.TIDC_OID_TIPO_DIRE = mtd.OID_TIPO_DIRE ");
    consulta.append(" and mcd.TIVI_OID_TIPO_VIA = stv.OID_TIPO_VIA ");
    consulta.append(" and mcd.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    RecordSet rs = null;
    String codigoError = null;
    DTOSalida dtoSalida = null;
    
    
    try {
      rs = bs.dbService.executeStaticQuery(consulta.toString());
    }catch (Exception e){
      codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
      UtilidadesLog.error(" obtenerMarcasCanalesCliente: Exception", e);
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    
    
    ArrayList direcciones = new ArrayList();
    
    if (rs!=null){
      
      int filas = rs.getRowCount();
      
      for (int i = 0; i < filas; i++) {
        
        DTOINTDirecciones dto = new DTOINTDirecciones();
        
        if (rs.getValueAt(i, "OID_CLIE_DIRE") != null) {
          dto.setOid(new Long(((BigDecimal)rs.getValueAt(i, "OID_CLIE_DIRE") ).longValue()));
        }
        
        if (rs.getValueAt(i, "COD_PAIS") != null) {
          dto.setCodPais(rs.getValueAt(i, "COD_PAIS").toString());
        }
        
        if (rs.getValueAt(i, "COD_CLIE") != null) {
          dto.setCodClie(rs.getValueAt(i, "COD_CLIE").toString());
        }
        
        if (rs.getValueAt(i, "COD_TIPO_DIRE") != null) {
          dto.setCodTipoDir(rs.getValueAt(i, "COD_TIPO_DIRE").toString());
        }
        
        if (rs.getValueAt(i, "COD_TIPO_VIA") != null) {
          dto.setTipoVia(rs.getValueAt(i, "COD_TIPO_VIA").toString());
        }
        
        if (rs.getValueAt(i, "VAL_NOMB_VIA") != null) {
          String via = rs.getValueAt(i, "VAL_NOMB_VIA").toString();
          if (via.length()>50){
              dto.setNombreVia(via.substring(0,50));
          }else{
              dto.setNombreVia(via);
          }
        }else{
          dto.setNombreVia(" ");
        }
        
        if (rs.getValueAt(i, "NUM_PPAL") != null) {
          dto.setNumero(rs.getValueAt(i, "NUM_PPAL").toString());
        }else{
          dto.setNumero(" ");
        }
        
        if (rs.getValueAt(i, "VAL_INTE") != null) {
          dto.setInterior(new Integer(((BigDecimal) rs.getValueAt(i, "VAL_INTE") ).intValue()));
        }else{
          dto.setInterior(new Integer(0));
        }
        
        if (rs.getValueAt(i, "VAL_MANZ") != null) {
          dto.setManzana(new Integer(((BigDecimal) rs.getValueAt(i, "VAL_MANZ") ).intValue()));
        }else{
          dto.setManzana(new Integer(0));
        }
        
        if (rs.getValueAt(i, "VAL_LOTE") != null) {
          dto.setLote(new Integer(((BigDecimal) rs.getValueAt(i, "VAL_LOTE") ).intValue()));
        }else{
          dto.setLote(new Integer(0));
        }
        
        if (rs.getValueAt(i, "VAL_KM") != null) {
          dto.setKilometro(new Integer(((BigDecimal) rs.getValueAt(i, "VAL_KM") ).intValue()));
        }else{
          dto.setKilometro(new Integer(0));
        }
        
        
        if (rs.getValueAt(i, "COD_UNID_GEOG") != null) {
          
          String cadena = rs.getValueAt(i, "COD_UNID_GEOG").toString();
          
          int cantCaracteres = cadena.length();
          
          if(cantCaracteres >= 6){
            dto.setCodUbiNivel1(cadena.substring(0,6));
          }else{
            dto.setCodUbiNivel1(null);
          }
          
          if(cantCaracteres >= 12){
            dto.setCodUbiNivel2(cadena.substring(6,12));
          }else{
            dto.setCodUbiNivel2(null);
          }
          
          if(cantCaracteres >= 18){
            dto.setCodUbiNivel3(cadena.substring(12,18));
          }else{
            dto.setCodUbiNivel3(null);
          }
          
          if(cantCaracteres >= 24){
            dto.setCodUbiNivel4(cadena.substring(18,24));
          }else{
            dto.setCodUbiNivel4(null);
          }
          
        }//cierro if
        
        direcciones.add(dto);
      
      }//cierro for

    }//cierro(rs!=null)
    
    UtilidadesLog.info("DAOGEO.obtenerDirecciones(): Salida");
    
    return direcciones;

  }

  public RecordSet obtenerMarcasCanalesCliente(Long cliente, Long pais) throws MareException{
    
    UtilidadesLog.info("DAOGEO.obtenerMarcasCanalesCliente(Long cliente, Long pais): Entrada");
    
    StringBuffer consulta = new StringBuffer();
    Vector parametros = new Vector();
    
    consulta.append(" SELECT DISTINCT cra.marc_oid_marc marca, cra.cana_oid_cana canal ");
    consulta.append(" FROM cra_perio cra,mae_clien_tipo_subti mts,mae_clien_clasi clas,mae_clien_marca clim ");
    consulta.append(" WHERE clas.ctsu_oid_clie_tipo_subt = mts.oid_clie_tipo_subt  ");
    consulta.append(" AND cra.oid_peri = clas.perd_oid_peri ");
    consulta.append(" AND clim.marc_oid_marc = cra.marc_oid_marc ");
    consulta.append(" AND mts.clie_oid_clie = clim.clie_oid_clie  ");
    
    if (cliente != null) {
      consulta.append(" AND mts.clie_oid_clie = ? ");
      parametros.add(cliente);
    }
    
    if (pais != null) {
      consulta.append(" AND cra.pais_oid_pais = ? ");
      parametros.add(pais);
    }
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    RecordSet rs = null;
    String codigoError = null;
    
    try {
      rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
    }catch (Exception e){
      codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
      UtilidadesLog.error(" obtenerMarcasCanalesCliente: Exception", e);
      this.logSql(" obtenerMarcasCanalesCliente SQL: ", consulta.toString(), parametros);
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    
    UtilidadesLog.debug("DAOGEO.obtenerMarcasCanalesCliente, rs --> " + rs);
    UtilidadesLog.info("DAOGEO.obtenerMarcasCanalesCliente(Long cliente, Long pais): Salida");
    
    return rs;
  
  
  }
  
  public RecordSet obtenerOidTipoDireccion(String codTipoDireccion) throws MareException{
  
    UtilidadesLog.info("DAOGEO.obtenerOidTipoDireccion(String codTipoDireccion): Entrada");
    
    StringBuffer consulta = new StringBuffer();
    Vector parametros = new Vector();
    
    consulta.append(" SELECT mtd.OID_TIPO_DIRE ");
    consulta.append(" FROM mae_tipo_direc mtd ");
    consulta.append(" WHERE ");
    
    if (codTipoDireccion != null) {
      consulta.append(" mtd.COD_TIPO_DIRE = ? ");
      parametros.add(codTipoDireccion);
    }
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    RecordSet rs = null;
    String codigoError = null;
    
    try {
      rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
    }catch (Exception e){
      codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
      UtilidadesLog.error(" obtenerOidTipoDireccion: Exception", e);
      this.logSql(" obtenerOidTipoDireccion SQL: ", consulta.toString(), parametros);
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    
    UtilidadesLog.info("DAOGEO.obtenerOidTipoDireccion(String codTipoDireccion): Salida");
    
    return rs;
    
  }
  
  public RecordSet obtenerValorSICC(String codigo) throws MareException{
  
    UtilidadesLog.info("DAOGEO.obtenerValorSICC(String codigo): Entrada");
    
    StringBuffer consulta = new StringBuffer();
    Vector parametros = new Vector();
    
    consulta.append(" SELECT i.VAL_VALO ");
    consulta.append(" FROM int_param_estad_geore i ");
    consulta.append(" WHERE ");
    
    if (codigo != null) {
      consulta.append(" i.COD_GEOR = ? ");
      parametros.add(codigo);
    }
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    RecordSet rs = null;
    String codigoError = null;
    
    try {
      rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
    }catch (Exception e){
      codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
      UtilidadesLog.error(" obtenerCodigoGeo: Exception", e);
      this.logSql(" obtenerCodigoGeo SQL: ", consulta.toString(), parametros);
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    
    UtilidadesLog.debug("DAOGEO.obtenerValorSICC, rs --> " + rs);
    
    UtilidadesLog.info("DAOGEO.obtenerValorSICC(String codigo): Salida");
    
    return rs;
    
  }
  
  
  private void logSql(String metodo, String sql, Vector params) {
  
    UtilidadesLog.debug(metodo + sql);
    
    if ((params != null) && (params.size() > 0)) {
      String sParams = "";
      
      for (int i = 0; i < params.size(); i++) {
        sParams += ("param " + (i + 1) + ": " + params.elementAt(i) + ", ");
      }
      
      UtilidadesLog.debug(metodo + sParams);
    
    }
      
  }




}