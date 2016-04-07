package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEBuscarDescuentosOrdenacion  extends DTOAuditableSICC{

      private Long oidCanal;
      private Long oidMarca;

   public DTOEBuscarDescuentosOrdenacion() {
   }

   public Long getOidCanal()
   {
      return this.oidCanal;
   }

   public Long getOidMarca()
   {
      return this.oidMarca;
   }

   public void setOidCanal(Long oidCanal)
   {
      this.oidCanal = oidCanal;
   }

   public void setOidMarca(Long oidMarca)
   {
      this.oidMarca = oidMarca;
   }

}