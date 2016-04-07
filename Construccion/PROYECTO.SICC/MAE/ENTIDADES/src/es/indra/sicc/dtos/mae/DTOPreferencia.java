package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOPreferencia extends DTOAuditableSICC  {

private String descripcion;
private Long tipo;
private Long oid;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String newDescripcion) {
        descripcion = newDescripcion;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long newTipo) {
        tipo = newTipo;
    }

}