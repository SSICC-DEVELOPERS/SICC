package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

public class DTOVinculo extends DTOAuditableSICC  {

        private Long pais;
        private Long oidCliente;
        private Boolean principal;
        private Date fechaDesde;
        private Date fechaHasta;
        private String codigoCliente;
        private Long tipo;
        private Long oid;

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String newCodigoCliente) {
        codigoCliente = newCodigoCliente;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date newFechaDesde) {
        fechaDesde = newFechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date newFechaHasta) {
        fechaHasta = newFechaHasta;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean newPrincipal) {
        principal = newPrincipal;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long newTipo) {
        tipo = newTipo;
    }




}