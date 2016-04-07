package es.indra.sicc.dtos.intsys;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;


public class DTOINT extends DTOBelcorp {
    private Long   numeroLote;
    private String descripcionLote;
    private String observaciones;
    
    //incidencia SiCC-2007023, (Sapaza)
    private Date fechaHasta;
    
    //incidencia SiCC-20070396, (Sapaza)
    private String nombreArchivo;
    
    public DTOINT() {
    }

    public String getDescripcionLote() {
        return descripcionLote;
    }

    public void setDescripcionLote(String newDescripcionLote)
        throws MareException {
        descripcionLote = newDescripcionLote;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String newObservaciones) {
        observaciones = newObservaciones;
    }


  public void setNumeroLote(Long numeroLote) {
    this.numeroLote = numeroLote;
  }


  public Long getNumeroLote() {
    return numeroLote;
  }


  public void setFechaHasta(Date fechaHasta)
  {
    this.fechaHasta = fechaHasta;
  }


  public Date getFechaHasta()
  {
    return fechaHasta;
  }

    public void setNombreArchivo(String nombreArchivo)
    {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo()
    {
        return nombreArchivo;
    }
}
