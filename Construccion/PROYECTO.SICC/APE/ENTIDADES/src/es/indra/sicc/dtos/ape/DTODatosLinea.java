package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosLinea extends DTOBelcorp { 
    
    private Long oidLinea; 
    private String descripcionLinea; 
    private Long oidProgramaCubicaje;
    private Long oidMapaCD; 
    private Boolean imprimirListaPicado; 
    
    public DTODatosLinea(){}
    
    public void setOidLinea(Long oidLinea){
            this.oidLinea = oidLinea;
    }
    public Long getOidLinea(){
           return oidLinea;
    }    

    public void setDescripcionLinea(String descripcionLinea){
            this.descripcionLinea = descripcionLinea;
    }
    public String getDescripcionLinea(){
           return descripcionLinea;
    }       
    
    public void setOidProgramaCubicaje(Long oidProgramaCubicaje){
            this.oidProgramaCubicaje = oidProgramaCubicaje;
    }
    public Long getOidProgramaCubicaje(){
           return oidProgramaCubicaje;
    }       

    public void setOidMapaCD(Long oidMapaCD){
            this.oidMapaCD = oidMapaCD;
    }
    public Long getOidMapaCD(){
           return oidMapaCD;
    }   

    public void setImprimirListaPicado(Boolean imprimirListaPicado){
            this.imprimirListaPicado = imprimirListaPicado;
    }
    public Boolean getImprimirListaPicado(){
           return imprimirListaPicado;
    }      
    
    
    

    
}