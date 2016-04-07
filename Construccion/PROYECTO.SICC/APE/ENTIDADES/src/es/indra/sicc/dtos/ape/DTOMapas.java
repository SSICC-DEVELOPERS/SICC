package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTOMapas extends DTOBelcorp {

    private Long oidMapaZonas;
    private String descripcionMapaZonas;
    private Long oidMapaCD;
    private String descripcionMapaCD; 

    public DTOMapas() {}

    public void setOidMapaZonas(Long oidMapaZonas){
            this.oidMapaZonas = oidMapaZonas;
    }
    public Long getOidMapaZonas(){
           return oidMapaZonas;
    }
    
    public void setOidDescripcionMapaZonas(String descripcionMapaZonas){
            this.descripcionMapaZonas = descripcionMapaZonas;
    }
    public String getOidDescripcionMapaZonas(){
           return descripcionMapaZonas;
    }

    public void setOidMapaCD(Long oidMapaCD){
            this.oidMapaCD = oidMapaCD;
    }
    public Long getOidMapaCD(){
           return oidMapaCD;
    }
    
    public void setDescripcionMapaCD(String descripcionMapaCD){
            this.descripcionMapaCD = descripcionMapaCD;
    }
    public String getDescripcionMapaCD(){
           return descripcionMapaCD;
    }    
    



}