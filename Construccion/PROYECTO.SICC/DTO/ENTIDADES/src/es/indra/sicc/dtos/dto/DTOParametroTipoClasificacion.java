package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Boolean;
import java.lang.Long;


public class DTOParametroTipoClasificacion extends DTOAuditableSICC {

    private Long oid;
    private Boolean valorPorDefecto;
    private Long oidTipoClasificacion;
    private Long oidSubtipoCliente;
    private String descripcionTipoClasificacion;

    public DTOParametroTipoClasificacion() {
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Boolean getValorPorDefecto() {
        return valorPorDefecto;
    }

    public void setValorPorDefecto(Boolean newValorPorDefecto) {
        valorPorDefecto = newValorPorDefecto;
    }

    public Long getOidTipoClasificacion() {
        return oidTipoClasificacion;
    }

    public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
        oidTipoClasificacion = newOidTipoClasificacion;
    }

    public Long getOidSubtipoCliente() {
        return oidSubtipoCliente;
    }

    public void setOidSubtipoCliente(Long newOidSubtipoCliente) {
        oidSubtipoCliente = newOidSubtipoCliente;
    }

    public String getDescripcionTipoClasificacion() {
        return descripcionTipoClasificacion;
    }

    public void setDescripcionTipoClasificacion(String newDescripcionTipoClasificacion) {
        descripcionTipoClasificacion = newDescripcionTipoClasificacion;
    }
}