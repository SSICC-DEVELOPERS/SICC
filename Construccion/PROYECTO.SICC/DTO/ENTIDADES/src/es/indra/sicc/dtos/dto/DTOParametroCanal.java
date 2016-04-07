package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.lang.Long;
import java.lang.String;

public class DTOParametroCanal extends DTOAuditableSICC {

   private Long oid;
   private Long oidCanal;
   private String codigo;
   private String descripcion;
   private Boolean valorPorDefecto;
   
   public DTOParametroCanal() {
   }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String newCodigo) {
        codigo = newCodigo;
    }

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

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long newOidCanal) {
        oidCanal = newOidCanal;
    }

    public Boolean getValorPorDefecto() {
        return valorPorDefecto;
    }

    public void setValorPorDefecto(Boolean newValorPorDefecto) {
        valorPorDefecto = newValorPorDefecto;
    }
}