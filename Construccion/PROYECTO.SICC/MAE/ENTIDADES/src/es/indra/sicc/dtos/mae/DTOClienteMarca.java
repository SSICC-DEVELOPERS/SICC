package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOClienteMarca extends DTOAuditableSICC  {

private Long marca;
private Long oid;
private Boolean principal;

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

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


}