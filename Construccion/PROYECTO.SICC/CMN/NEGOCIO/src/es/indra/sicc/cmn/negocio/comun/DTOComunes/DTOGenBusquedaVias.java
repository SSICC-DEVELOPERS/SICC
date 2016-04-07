package es.indra.sicc.cmn.negocio.comun.DTOComunes;

import es.indra.sicc.util.DTOBusquedaGenerica;

public class DTOGenBusquedaVias extends DTOBusquedaGenerica {
  public DTOGenBusquedaVias()  {
    super();
  }
  
  String codigoVia = new String();
  
  
  
  
  public String obtenerSQL() {
    StringBuffer buf = new StringBuffer();
    String  codigo = null;
    if (this.getCodigo() != null ){
        codigo = this.getCodigo().toString();
    }else if (this.getStrCodigo() != null && !getStrCodigo().trim().equalsIgnoreCase("")){
        codigo = this.getStrCodigo();
    }
   
    buf.append(" select c.OID_VIA as OID,cod_via, c.nom_via ");
    buf.append("   from zon_via c ");
    buf.append("   where  c.TIVI_OID_TIPO_VIA = " + this.getCodigoVia());
    
    if (codigo != null && !codigo.trim().equalsIgnoreCase("")){
    buf.append(" AND c.COD_VIA like '%" + codigo.trim().toString() + "%' ");
    }
    
    if(this.getDescripcion() != null && !getDescripcion().trim().equalsIgnoreCase("")) {
      buf.append("AND c.NOM_VIA like '%" + getDescripcion().trim().toString() + "%' ");
    }
    return buf.toString();
  }


  public void setCodigoVia(String codigoVia){
    this.codigoVia = codigoVia;
  }


  public String getCodigoVia(){
    return codigoVia;
  }
}