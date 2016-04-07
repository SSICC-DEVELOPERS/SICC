package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.ArrayList;

public class DTOEAlcanceAdministrativoDTO extends DTOAuditableSICC {

   private Long oidDescuento;
    private Boolean nacional;
    private ArrayList detalle;
   
   public DTOEAlcanceAdministrativoDTO() {
   }

   public Long getOidDescuento()
   {
      return this.oidDescuento;
   }

   public void setOidDescuento  (Long oidDescuento)
   {
      this.oidDescuento = oidDescuento;
   }

    public Boolean getNacional() {
        return nacional;
    }

    public void setNacional(Boolean newNacional) {
        nacional = newNacional;
    }

    public ArrayList getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList newDetalle) {
        detalle = newDetalle;
    }









}