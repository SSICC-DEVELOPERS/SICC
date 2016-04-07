package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOTipoSubtipoCliente extends DTOAuditableSICC  {

        private Long tipo;
        private Long subtipo;
        private Boolean principal;
        private Long oid;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean newPrincipal) {
        principal = newPrincipal;
    }

    public Long getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(Long newSubtipo) {
        subtipo = newSubtipo;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long newTipo) {
        tipo = newTipo;
    }


        
        
}