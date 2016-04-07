package es.indra.sicc.rep.dtos;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOPeriodoCorporativos extends DTOAuditableSICC{
     private String  anio;
	 private Long oidCanal;
	 
    
     public DTOPeriodoCorporativos(){
     }
   
	
 	 public String getAnio(){
     return anio;
   }
  
   public void setAnio(String newAnio){
     anio = newAnio;
   }

	public Long getOidCanal(){
     return oidCanal;
   }
  
   public void setOidCanal(Long newOidCanal){
     oidCanal = newOidCanal;
   }
  
}