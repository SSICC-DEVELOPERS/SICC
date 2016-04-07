package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOProductoDTO extends DTOAuditableSICC  {
    private Long oidProducto;
    private String codigoSAP;
    private String descripcion;

   public DTOProductoDTO() {
   }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long newOidProducto) {
        oidProducto = newOidProducto;
    }

    public String getCodigoSAP() {
        return codigoSAP;
    }

    public void setCodigoSAP(String newCodigoSAP) {
        codigoSAP = newCodigoSAP;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String newDescripcion) {
        descripcion = newDescripcion;
    }

}