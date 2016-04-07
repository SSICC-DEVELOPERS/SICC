package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTODesasignarProductosAnaqueles extends DTOSiccPaginacion {

    private java.lang.Long oid;
    private java.lang.String numAnaq;
    private java.lang.String codSAP;
    private java.lang.String descripcion;
    
    public DTODesasignarProductosAnaqueles() {
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    public void setNumAnaq(String numAnaq) {
        this.numAnaq = numAnaq;
    }

    public String getNumAnaq() {
        return numAnaq;
    }

    public void setCodSAP(String codSAP) {
        this.codSAP = codSAP;
    }

    public String getCodSAP() {
        return codSAP;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
