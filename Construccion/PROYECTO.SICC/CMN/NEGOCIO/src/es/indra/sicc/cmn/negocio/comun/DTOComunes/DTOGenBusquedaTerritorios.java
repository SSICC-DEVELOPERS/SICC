package es.indra.sicc.cmn.negocio.comun.DTOComunes;

import es.indra.sicc.util.DTOBusquedaGenerica;

public class DTOGenBusquedaTerritorios extends DTOBusquedaGenerica {
  public DTOGenBusquedaTerritorios()  {
    super();
  }
  
  String secciones = new String();  
  
  
  public String obtenerSQL() {
    StringBuffer buf = new StringBuffer();
    String  codigo = null;
    if (this.getCodigo() != null ){
        codigo = this.getCodigo().toString();
    }else if (this.getStrCodigo() != null && !getStrCodigo().trim().equalsIgnoreCase("")){
        codigo = this.getStrCodigo();
    }
   
    buf.append(" SELECT DISTINCT ta.terr_oid_terr as OID, t.cod_terr as codigo, t.cod_terr as descripcion");
    buf.append(" FROM zon_terri t, ");
    buf.append(" zon_terri_admin ta, ");
    buf.append(" zon_regio r, ");
    buf.append(" zon_zona z, ");
    buf.append(" zon_sub_geren_venta sgv, ");
    buf.append(" zon_secci s ");
    buf.append(" WHERE sgv.pais_oid_pais = 1 ");
    buf.append(" AND r.zsgv_oid_subg_vent = sgv.oid_subg_vent ");
    buf.append(" AND r.oid_regi = z.zorg_oid_regi ");
    buf.append(" AND s.zzon_oid_zona = z.oid_zona ");
    buf.append(" AND s.oid_secc = ta.zscc_oid_secc ");
    buf.append(" AND t.oid_terr = ta.terr_oid_terr ");
    buf.append(" AND sgv.ind_acti = 1 ");
    buf.append(" AND sgv.ind_borr = 0 ");
    buf.append(" AND r.ind_acti = 1 ");
    buf.append(" AND r.ind_borr = 0 ");
    buf.append(" AND z.ind_acti = 1 "); 
    buf.append(" AND z.ind_borr = 0 ");
    buf.append(" AND s.ind_acti = 1 ");
    buf.append(" AND s.ind_borr = 0 ");
    buf.append(" AND t.ind_borr = 0 ");
    buf.append(" AND ta.ind_borr = 0 ");
    buf.append(" and ta.ZSCC_OID_SECC in(" + this.getSecciones() + ")");
        
    if (codigo != null && !codigo.trim().equalsIgnoreCase("")){
       buf.append(" AND t.cod_terr like '%" + codigo.trim().toString() + "%' ");
    }    
         
    buf.append(" ORDER BY t.cod_terr ");
    
    return buf.toString();
  }


  public void setSecciones(String secciones){
    this.secciones = secciones;
  }


  public String getSecciones(){
    return secciones;
  }
}