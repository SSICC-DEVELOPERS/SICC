package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;


public class DTOCORRecepcionar extends DTOBelcorp {
    public DTOCORRecepcionar()
    {
    }
    
   
    private Date fechaGenerar;
    private Long numLote;
    private String descripcionLote;
    private String observaciones;
    private Boolean seguimientoPedidos;
    private Boolean confirmacionPedidos;

    

    public Date getFechaGenerar()
    {
        return fechaGenerar;
    }

    public void setFechaGenerar(Date fechaGenerar)
    {
        this.fechaGenerar = fechaGenerar;
    }

    public Long getNumLote()
    {
        return numLote;
    }

    public void setNumLote(Long numLote)
    {
        this.numLote = numLote;
    }

    public String getDescripcionLote()
    {
        return descripcionLote;
    }

    public void setDescripcionLote(String descripcionLote)
    {
        this.descripcionLote = descripcionLote;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }

    public Boolean getSeguimientoPedidos()
    {
        return seguimientoPedidos;
    }

    public void setSeguimientoPedidos(Boolean seguimientoPedidos)
    {
        this.seguimientoPedidos = seguimientoPedidos;
    }

    public Boolean getConfirmacionPedidos()
    {
        return confirmacionPedidos;
    }

    public void setConfirmacionPedidos(Boolean confirmacionPedidos)
    {
        this.confirmacionPedidos = confirmacionPedidos;
    }
}

