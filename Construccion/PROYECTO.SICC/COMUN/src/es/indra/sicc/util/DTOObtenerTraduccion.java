package es.indra.sicc.util;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOObtenerTraduccion extends DTOAuditableSICC {
   private String esntidad;
   private Long oid;

   public DTOObtenerTraduccion() {
   }

   public String getEsntidad() {
      return esntidad;
   }

   public void setEsntidad(String newEsntidad) {
      esntidad = newEsntidad;
   }

   public Long getOid() {
      return oid;
   }

   public void setOid(Long newOid) {
      oid = newOid;
   }
}
