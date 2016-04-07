package es.indra.sicc.util;

import es.indra.sicc.cmn.negocio.auditoria.*;


public class DTOOIDs extends DTOAuditableSICC {
   private Long[] oids;

   public DTOOIDs() {
   }

   public void setOids(Long[] newOids) {
      this.oids = newOids;
   }

   public Long[] getOids() {
      return this.oids;
   }
}
