package es.indra.sicc.rep.dtos;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEstructuraFacturacion extends DTOAuditableSICC{

    private String anio;
    private String canales;
    private Long marca;
    
    public DTOEstructuraFacturacion() {
    }

    public String getAnio(){
        return anio;
    }

    public void setAnio(String anio){
        this.anio = anio;
    }

    public String getCanales(){
        return canales;
    }

    public void setCanales(String canales){
        this.canales = canales;
    }

    public Long getMarca(){
        return marca;
    }

    public void setMarca(Long marca){
        this.marca = marca;
    }
    
  
}