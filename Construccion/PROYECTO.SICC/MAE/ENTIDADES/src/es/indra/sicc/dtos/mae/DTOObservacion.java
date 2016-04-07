package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOObservacion extends DTOAuditableSICC  {

private Integer numero;
private Long marca;
private String texto;
private Long oid;

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer newNumero) {
        numero = newNumero;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String newTexto) {
        texto = newTexto;
    }



}