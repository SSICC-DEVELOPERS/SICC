package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOIdentificacion extends DTOAuditableSICC  {


private Long tipoDocumento;
private Boolean esPrincipal;
private String numeroDocumento;
private String indPersonaEmpresa;
private Long oid;

    public Boolean getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(Boolean newEsPrincipal) {
        esPrincipal = newEsPrincipal;
    }

    public String getIndPersonaEmpresa() {
        return indPersonaEmpresa;
    }

    public void setIndPersonaEmpresa(String newIndPersonaEmpresa) {
        indPersonaEmpresa = newIndPersonaEmpresa;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String newNumeroDocumento) {
        numeroDocumento = newNumeroDocumento;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Long newTipoDocumento) {
        tipoDocumento = newTipoDocumento;
    }


}