package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOMovimientoCtaCte extends DTOBelcorp 
{
  private Long oidMarca;
  private Long oidCanal;
  private Long numMovimiento;
  private Long numPuntos;
  private Long numPuntosExigidos;
  private String fechaMovimiento;
  private Long oidConcurso;
  private Long oidCliente;
  private Long oidPeriodo;
  private Long oidTipoMovimiento;
  private String descripcion;
  private String codCliente;

  public DTOMovimientoCtaCte()
  {
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public void setNumMovimiento(Long numMovimiento)
  {
    this.numMovimiento = numMovimiento;
  }

  public Long getNumPuntos()
  {
    return numPuntos;
  }

  public void setNumPuntos(Long numPuntos)
  {
    this.numPuntos = numPuntos;
  }

  public Long getNumPuntosExigidos()
  {
    return numPuntosExigidos;
  }

  public void setNumPuntosExigidos(Long numPuntosExigidos)
  {
    this.numPuntosExigidos = numPuntosExigidos;
  }

  public String getFechaMovimiento()
  {
    return fechaMovimiento;
  }

  public void setFechaMovimiento(String fechaMovimiento)
  {
    this.fechaMovimiento = fechaMovimiento;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidTipoMovimiento()
  {
    return oidTipoMovimiento;
  }

  public void setOidTipoMovimiento(Long oidTipoMovimiento)
  {
    this.oidTipoMovimiento = oidTipoMovimiento;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }

  public String getCodCliente()
  {
    return codCliente;
  }

  public void setCodCliente(String codCliente)
  {
    this.codCliente = codCliente;
  }

  public Long getNumMovimiento()
  {
    return numMovimiento;
  }
}