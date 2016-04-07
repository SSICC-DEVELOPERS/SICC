package es.indra.sicc.cmn.negocio.comun.DTOComunes;

import es.indra.sicc.util.DTOBusquedaGenerica;

public class DTOGenBusquedaGenerico extends DTOBusquedaGenerica{
  public DTOGenBusquedaGenerico()  {
    super();
  }
  
  public String obtenerSQL() {
    StringBuffer buf = new StringBuffer();
    String  codigo = null;
    if (this.getCodigo() != null ){
        codigo = this.getCodigo().toString();
    }else if (this.getStrCodigo() != null && !getStrCodigo().trim().equalsIgnoreCase("")){
        codigo = this.getStrCodigo();
    }
    buf.append("SELECT   i.val_oid oid, i.val_oid val_oid, i.val_i18n val_i18n ");
    buf.append("FROM v_gen_i18n_sicc i, mae_gener t ");
    buf.append("WHERE i.val_oid = t.oid_gene ");
    buf.append("AND i.ATTR_ENTI = 'MAE_GENER' ");
    buf.append("AND i.ATTR_NUM_ATRI = 1 ");
    buf.append("AND i.IDIO_OID_IDIO = " + getOidIdioma().toString()  + " ");
    buf.append("AND t.PAIS_OID_PAIS = " + getOidPais().toString()+ " ");
    if(this.getDescripcion() != null && !getDescripcion().trim().equalsIgnoreCase("")) {
      buf.append("AND VAL_I18N like '" + getDescripcion().trim().toString() + "' ");
    }
    /*if(this.getCodigo() != null && !getCodigo().trim().equalsIgnoreCase("")){
      buf.append("AND i.VAL_OID = " + getCodigo().trim().toString() + " ");
    }*/
    if(codigo != null && !codigo.trim().equalsIgnoreCase("")){
       buf.append("AND i.VAL_OID = '" + codigo.trim().toString() + "' ");
    }

    buf.append("ORDER BY VAL_I18N ASC");
    return buf.toString();
  }

}