package es.indra.sicc.cmn.negocio.comun.DTOComunes;
import es.indra.sicc.util.DTOBusquedaGenerica;
import es.indra.sicc.util.UtilidadesLog;

public class DTOGenBusquedaProducto extends DTOBusquedaGenerica 
{
  public DTOGenBusquedaProducto()
  {
    super();
  }
  
  public String obtenerSQL() {
    UtilidadesLog.info("DTOGenBusquedaProducto.obtenerSQL: Entrada");
    StringBuffer buf = new StringBuffer();
    String  codigo = null;
    if (this.getCodigo() != null ){
        codigo = this.getCodigo().toString();
    }else if (this.getStrCodigo() != null && !getStrCodigo().trim().equalsIgnoreCase("")){
        codigo = this.getStrCodigo();
    }
    buf.append("SELECT  i.val_oid OID, mp.cod_sap CODIGO, i.val_i18n val_i18n ");
    buf.append("FROM v_gen_i18n_sicc i, mae_produ mp ");
    buf.append("WHERE i.val_oid = mp.OID_PROD ");
    buf.append("AND i.ATTR_ENTI = 'MAE_PRODU' ");
    buf.append("AND i.ATTR_NUM_ATRI = 1 ");
    buf.append("AND i.IDIO_OID_IDIO = " + getOidIdioma().toString()  + " ");
    buf.append("AND mp.PAIS_OID_PAIS = " + getOidPais().toString()+ " ");
    if(this.getDescripcion() != null && !getDescripcion().trim().equalsIgnoreCase("")) {
      buf.append("AND VAL_I18N like '" + getDescripcion().trim().toString() + "' ");
    }
    //pzerbino 6/10/2006
    /*if(this.getStrCodigo() != null && !getStrCodigo().trim().equalsIgnoreCase("")){
      buf.append("AND mp.COD_SAP = '" + getStrCodigo().trim().toString() + "' ");
    }*/
     if(codigo != null && !codigo.trim().equalsIgnoreCase("")){
       // DBLG700000164 - gPineda - 26/10/2006
       //buf.append("AND mp.COD_SAP = '" + codigo.trim().toString() + "' ");
       buf.append("AND mp.COD_SAP  LIKE '" + codigo.trim().toString() + "' ");
    }
    buf.append("ORDER BY VAL_I18N ASC");
    
    UtilidadesLog.info("buf.toString" + buf.toString());
    UtilidadesLog.info("DTOGenBusquedaProducto.obtenerSQL: Salida");
    return buf.toString();
  }

}
