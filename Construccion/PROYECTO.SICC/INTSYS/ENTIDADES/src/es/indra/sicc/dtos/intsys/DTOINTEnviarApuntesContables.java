package es.indra.sicc.dtos.intsys;

import es.indra.sicc.util.DTOBelcorp;

import java.util.Date;

public class DTOINTEnviarApuntesContables extends DTOBelcorp {
    private String numeroLote;
    private String descripcion;
    private String observaciones;
    private Date fecha;
    
    //incidencia SiCC-2007023, (Sapaza)
    private Date fechaHasta;

    public DTOINTEnviarApuntesContables() {
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


  public void setFechaHasta(Date fechaHasta)
  {
    this.fechaHasta = fechaHasta;
  }


  public Date getFechaHasta()
  {
    return fechaHasta;
  }
}