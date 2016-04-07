package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSubEstructura extends DTOAuditableSICC  {
    private Integer cod;
    private String desc;
    private Long oid;

    public DTOSubEstructura() {
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer newCod) {
        cod = newCod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String newDesc) {
        desc = newDesc;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }
}