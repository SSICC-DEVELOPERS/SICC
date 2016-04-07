package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;

public class DTOExpandirAnaquel extends DTOBelcorp {
    private DTOMapaCentroDistribucionDetalle anaquelDestino;
    private DTOOIDs anaquelesOrigen;
    private Boolean mostrarMensaje;
    private Long oidPeriodo;

    public DTOExpandirAnaquel()   {   }
    
    public Long getOidPeriodo() {
        return this.oidPeriodo;
    }
    
    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }
    
    public Boolean getMostrarMensaje() {
        return this.mostrarMensaje;
    }
    
    public void setMostrarMensaje(Boolean mostrarMensaje) {
        this.mostrarMensaje = mostrarMensaje;
    }
    
    public DTOMapaCentroDistribucionDetalle getAnaquelDestino() {
        return this.anaquelDestino;
    }
    
    public void setAnaquelDestino(DTOMapaCentroDistribucionDetalle anaquelDestino) {
        this.anaquelDestino = anaquelDestino;
    }
    
    public DTOOIDs getAnaquelesOrigen() {
        return this.anaquelesOrigen;
    }
    
    public void setAnaquelesOrigen(DTOOIDs anaquelesOrigen) {
        this.anaquelesOrigen = anaquelesOrigen;
    }
}