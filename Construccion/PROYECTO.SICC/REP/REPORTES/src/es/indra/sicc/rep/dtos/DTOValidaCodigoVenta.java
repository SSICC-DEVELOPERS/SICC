package es.indra.sicc.rep.dtos;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOValidaCodigoVenta extends DTOAuditableSICC{
     private String  codigoVenta;
	 private Long periodoReferencia;
	 
    
     public DTOValidaCodigoVenta(){
     }
   
	
 	 public String getCodigoVenta(){
     return codigoVenta;
   }
  
   public void setCodigoVenta(String newCodigoVenta){
     codigoVenta = newCodigoVenta;
   }

	public Long getPeriodoReferencia(){
     return periodoReferencia;
   }
  
   public void setPeriodoReferencia(Long newPeriodoReferencia){
     periodoReferencia = newPeriodoReferencia;
   }
  
}