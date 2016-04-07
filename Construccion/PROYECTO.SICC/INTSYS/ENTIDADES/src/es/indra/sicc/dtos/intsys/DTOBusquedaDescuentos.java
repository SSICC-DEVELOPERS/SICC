package es.indra.sicc.dtos.intsys;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
import java.util.Date;

public class DTOBusquedaDescuentos extends DTOSiccPaginacion 
{
    public DTOBusquedaDescuentos()
    {
    }
    
    private Long numeroDocumento;       
    private String numeroLote;          
    private String descripcionLote;     
    private Long oidMarca;              
    private Long oidCanal;              
    private Long oidAcceso;             
  private String fechaVencimientoDesde;
  private String fechaVencimientoHasta;
    private ArrayList estados;          
    private String stringStatus;
  private String formatoFecha;

    public String getDescripcionLote()
    {
        return descripcionLote;
    }

    public void setDescripcionLote(String descripcionLote)
    {
        this.descripcionLote = descripcionLote;
    }

    public ArrayList getEstados()
    {
        return estados;
    }

    public void setEstados(ArrayList estados)
    {
        this.estados = estados;
    }

    public String getFechaVencimientoDesde()
    {
        return fechaVencimientoDesde;
    }

    public void setFechaVencimientoDesde(String fechaVencimientoDesde)
    {
        this.fechaVencimientoDesde = fechaVencimientoDesde;
    }

    public String getFechaVencimientoHasta()
    {
        return fechaVencimientoHasta;
    }

    public void setFechaVencimientoHasta(String fechaVencimientoHasta)
    {
        this.fechaVencimientoHasta = fechaVencimientoHasta;
    }

    public Long getNumeroDocumento()
    {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento)
    {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroLote()
    {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote)
    {
        this.numeroLote = numeroLote;
    }

    public Long getOidAcceso()
    {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso)
    {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidCanal()
    {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal)
    {
        this.oidCanal = oidCanal;
    }

    public Long getOidMarca()
    {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca)
    {
        this.oidMarca = oidMarca;
    }

    public String getStringStatus()
    {
        return stringStatus;
    }

    public void setStringStatus(String stringStatus)
    {
        this.stringStatus = stringStatus;
    }

  public String getFormatoFecha() {
    return formatoFecha;
  }

  public void setFormatoFecha(String formatoFecha) {
    this.formatoFecha = formatoFecha;
  }

}