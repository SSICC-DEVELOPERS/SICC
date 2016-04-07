package es.indra.sicc.rep.dtos;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOReportID extends DTOAuditableSICC{
   private Long  id;
  
   public DTOReportID(){
   }
  
   public Long getId(){
     return id;
   }
  
   public void setId(Long newId){
    id = newId;
   }
}