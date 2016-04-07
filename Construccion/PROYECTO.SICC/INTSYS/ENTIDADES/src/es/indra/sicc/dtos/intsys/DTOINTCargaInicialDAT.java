package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOINTCargaInicialDAT extends DTOBelcorp {
    public DTOINTCargaInicialDAT() 
    {
    }
    
    private Long marca;               
    private Long canal;               
    private Long acceso;              
    private String numeroLote;        
    private String descripcionLote;   
    private String observaciones;     
    private Date fechaFacturacion;    
    private Long periodoFacturacion;  
    private String codigosEnviar;
    
    public Long getAcceso()
    {
        return acceso;
    }

    public void setAcceso(Long acceso)
    {
        this.acceso = acceso;
    }

    public Long getCanal()
    {
        return canal;
    }

    public void setCanal(Long canal)
    {
        this.canal = canal;
    }

    public String getDescripcionLote()
    {
        return descripcionLote;
    }

    public void setDescripcionLote(String descripcionLote)
    {
        this.descripcionLote = descripcionLote;
    }

    public Date getFechaFacturacion()
    {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion)
    {
        this.fechaFacturacion = fechaFacturacion;
    }

    public Long getMarca()
    {
        return marca;
    }

    public void setMarca(Long marca)
    {
        this.marca = marca;
    }

    public String getNumeroLote()
    {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote)
    {
        this.numeroLote = numeroLote;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }

    public Long getPeriodoFacturacion()
    {
        return periodoFacturacion;
    }

    public void setPeriodoFacturacion(Long periodoFacturacion)
    {
        this.periodoFacturacion = periodoFacturacion;
    }

    //  Agregado por HRCS - Fecha 18/04/2007 - Cambio Sicc20070215
    public void setCodigosEnviar(String codigosEnviar) {
        this.codigosEnviar = codigosEnviar;
    }


    public String getCodigosEnviar() {
        return codigosEnviar;
    }

}