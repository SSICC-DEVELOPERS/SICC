package es.indra.sicc.dtos.intsys;

import java.util.Date;


public class DTORecepcionarMovimientos extends DTOINT {
    private Date fechaGenerar;
    private Long numeroLote;
    private String descripcionLote;
    private String observaciones;

    public DTORecepcionarMovimientos() {
    }

    public Date getFechaGenerar() {
        return fechaGenerar;
    }

    public void setFechaGenerar(Date newFechaGenerar) {
        fechaGenerar = newFechaGenerar;
    }
    
    public Long getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(Long newNumeroLote) {
        numeroLote = newNumeroLote;
    }
    
    public String getDescripcionLote() {
        return descripcionLote;
    }

    public void setDescripcionLote(String newDescripcionLote) {
        descripcionLote = newDescripcionLote;
    }
    
    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String newObservaciones) {
        observaciones = newObservaciones;
    }
}
