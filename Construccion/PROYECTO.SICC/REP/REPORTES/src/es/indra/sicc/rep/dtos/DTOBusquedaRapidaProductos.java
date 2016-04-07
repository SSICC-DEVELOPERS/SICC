package es.indra.sicc.rep.dtos;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBusquedaRapidaProductos extends DTOSiccPaginacion{
   private String  codSap;
   private String  descCort;
   private Long    marcaProducto;
   private Long    negocio;
   private Long    unidadNegocio;
   
    
   public DTOBusquedaRapidaProductos(){
      
   }
	
 	 public String getCodSap(){
     return codSap;
   }
  
   public void setCodSap(String newCodSap){
     codSap = newCodSap;
   }

   public String getDescCort(){
     return descCort;
   }
  
   public void setDescCort(String newDescCort){
     descCort = newDescCort;
   }

   public Long getMarcaProducto(){
     return marcaProducto;
   }
  
   public void setMarcaProducto(Long newMarcaProducto){
     marcaProducto = newMarcaProducto;
   }
   
   public Long getNegocio(){
     return negocio;
   }
  
   public void setNegocio(Long newNegocio){
     negocio = newNegocio;
   }
   
   public Long getUnidadNegocio(){
     return unidadNegocio;
   }
  
   public void setUnidadNegocio(Long newUnidadNegocio){
     unidadNegocio = newUnidadNegocio;
   }


}