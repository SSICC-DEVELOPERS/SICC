package es.indra.sicc.rep.dtos;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.sql.Date;

public class DTOCriteriosReportes extends DTOSiccPaginacion{
   private String  codModulo;
	 private Date  fechaDesde;
	 private Date  fechaHasta;
    
   public DTOCriteriosReportes(){
      
   }
	
 	 public String getCodModulo(){
     return codModulo;
   }
  
   public void setCodModulo(String newCodModulo){
     codModulo = newCodModulo;
   }

	 public Date getFechaDesde(){
     return fechaDesde;
   }
  
   public void setFechaDesde(Date newFechaDesde){
     fechaDesde = newFechaDesde;
   }

   public Date getFechaHasta(){
     return fechaHasta;
   }
  
   public void setFechaHasta(Date newFechaHasta){
     fechaHasta = newFechaHasta;
   }

}