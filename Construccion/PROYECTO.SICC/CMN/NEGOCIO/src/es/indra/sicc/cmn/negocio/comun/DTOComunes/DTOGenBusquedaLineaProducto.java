package es.indra.sicc.cmn.negocio.comun.DTOComunes;
import es.indra.sicc.util.DTOBusquedaGenerica;

public class DTOGenBusquedaLineaProducto extends DTOBusquedaGenerica {
  public DTOGenBusquedaLineaProducto() {
    super();
  }
  
  public String obtenerSQL() {
    StringBuffer buf = new StringBuffer();
    String  codigo = null;
    if (this.getCodigo() != null){
        codigo = this.getCodigo().toString();
    }else if (this.getStrCodigo() != null && !getStrCodigo().trim().equalsIgnoreCase("")){
        codigo = this.getStrCodigo();
    }
    buf.append("Select i.VAL_OID OID, i.VAL_OID VAL_OID, i.VAL_I18N VAL_I18N ");
    buf.append("From V_GEN_I18N_SICC i, MAE_LINEA_PRODU t ");
    buf.append("WHERE i.VAL_OID = t.OID_LINE_PROD ");
    buf.append("AND i.ATTR_ENTI = 'MAE_LINEA_PRODU' ");
    buf.append("AND i.ATTR_NUM_ATRI = 1 ");
    buf.append("AND i.IDIO_OID_IDIO = " + getOidIdioma().toString()  + " ");
    buf.append("AND t.PAIS_OID_PAIS = " + getOidPais().toString()+ " ");
    if(this.getDescripcion() != null && !getDescripcion().trim().equalsIgnoreCase("")) {
      buf.append("AND VAL_I18N like '" + getDescripcion().trim().toString() + "' ");
    }
    if(codigo != null && !codigo.trim().equalsIgnoreCase("")){
      buf.append("AND i.val_oid = " + codigo.toString() + " ");
    }
    buf.append("ORDER BY VAL_I18N ASC");
    return buf.toString();
  }
}