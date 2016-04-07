package es.indra.sicc.cmn.negocio.comun.DTOComunes;
import es.indra.sicc.util.DTOBusquedaGenerica;

public class DTOGenBusquedaClieMetaTipoVta  extends DTOBusquedaGenerica{
    public DTOGenBusquedaClieMetaTipoVta() {
        super();
    }
    String oidConcurso = null;

    public String obtenerSQL(){
        StringBuffer query = new StringBuffer();
    
        String  codigo = null;
        if (this.getCodigo() != null ){
            codigo = this.getCodigo().toString();
        }else if (this.getStrCodigo() != null && !getStrCodigo().trim().equalsIgnoreCase("")){
            codigo = this.getStrCodigo();
        }
    
        query.append(" SELECT DISTINCT MET.CLIE_OID_CLIE as OID, MAE.COD_CLIE , ");
        query.append("        MAE.VAL_APE1 || ' ' || MAE.VAL_APE2 || ', ' || MAE.VAL_NOM1 || ' ' || MAE.VAL_NOM2 as DESCRIPCION ");
        query.append("  FROM INC_METAS_TIPO_VENTA MET, MAE_CLIEN MAE ");
        query.append(" WHERE MAE.OID_CLIE = MET.CLIE_OID_CLIE AND MET.COPA_OID_PARA_GRAL = "+ this.getOidConcurso() );
    
        if (codigo != null && !codigo.trim().equalsIgnoreCase("")){
            query.append(" AND MAE.COD_CLIE like '%" + codigo.trim().toString() + "%' ");
        }
        
        if(this.getDescripcion() != null && !getDescripcion().trim().equalsIgnoreCase("")) {
            query.append(" AND MAE.VAL_APE1 || ' ' || MAE.VAL_APE2 || ', ' || MAE.VAL_NOM1 || ' ' || MAE.VAL_NOM2 like '%" + getDescripcion().trim().toString() + "%' ");
        }
        query.append(" ORDER BY MAE.COD_CLIE ");
        return query.toString();
    }



    public void setOidConcurso(String oidConcurso) {
        this.oidConcurso = oidConcurso;
    }


    public String getOidConcurso() {
        return oidConcurso;
    }
    
    
}