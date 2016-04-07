package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOMovimientoDetalle extends DTOBelcorp 
{
    public DTOMovimientoDetalle()
    {
    }
    private Date FechaMovimiento;
    private Double importeMovimiento;
    private String codProceso;
    private String numIdentCuota;
    private String valIndConsulta;
    private String descripcionTipoCargoAbono;
    private String ejercicioIdentificadorCuota;
    private Date fechaVencimiento;
    //  Agregado por HRCS - Fecha 19/06/2007 - Cambio Sicc20070296
    private Long consolidado;
    
  private Date fechaUltimaGeneracion;

    public Date getFechaMovimiento()
    {
        return FechaMovimiento;
    }

    public void setFechaMovimiento(Date FechaMovimiento)
    {
        this.FechaMovimiento = FechaMovimiento;
    }

    public String getCodProceso()
    {
        return codProceso;
    }

    public void setCodProceso(String codProceso)
    {
        this.codProceso = codProceso;
    }

    public Double getImporteMovimiento()
    {
    return importeMovimiento;
    }

    public void setImporteMovimiento(Double importeMovimiento)
    {
    this.importeMovimiento = importeMovimiento;
    }

    public String getNumIdentCuota()
    {
        return numIdentCuota;
    }

    public void setNumIdentCuota(String numIdentCuota)
    {
        this.numIdentCuota = numIdentCuota;
    }

    public String getValIndConsulta()
    {
        return valIndConsulta;
    }

    public void setValIndConsulta(String valIndConsulta)
    {
        this.valIndConsulta = valIndConsulta;
    }

    public String getDescripcionTipoCargoAbono()
    {
        return descripcionTipoCargoAbono;
    }

    public void setDescripcionTipoCargoAbono(String descripcionTipoCargoAbono)
    {
        this.descripcionTipoCargoAbono = descripcionTipoCargoAbono;
    }

  public String getEjercicioIdentificadorCuota()
  {
    return ejercicioIdentificadorCuota;
  }

  public void setEjercicioIdentificadorCuota(String ejercicioIdentificadorCuota)
  {
    this.ejercicioIdentificadorCuota = ejercicioIdentificadorCuota;
  }

  public Date getFechaVencimiento()
  {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(Date fechaVencimiento)
  {
    this.fechaVencimiento = fechaVencimiento;
  }

  public Date getFechaUltimaGeneracion()
  {
    return fechaUltimaGeneracion;
  }

  public void setFechaUltimaGeneracion(Date fechaUltimaGeneracion)
  {
    this.fechaUltimaGeneracion = fechaUltimaGeneracion;
  }


    public void setConsolidado(Long consolidado) {
        this.consolidado = consolidado;
    }


    public Long getConsolidado() {
        return consolidado;
    }
}