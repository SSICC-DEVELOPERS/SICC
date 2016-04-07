package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOMetasVentaProyectada extends DTOBelcorp 
{
  private Long oid;
  private Long oidUA;
  private Long oidPeriodo;
  private Long oidCliente;
  private String codigoCliente;
  private Long numActivasIniciales;
  private Long numActivasFinales;
  private BigDecimal impIngreso;
  private BigDecimal impReingreso;
  private BigDecimal impEgresos;
  private Long numOrdenes;
  private Long numPedidos;
  private Long numUnidadesVendidas;
  private Long numClientes;
  private BigDecimal impVentaEstadisticable;
  private BigDecimal impCapitalizacion;
  private BigDecimal precioPromedioUnitario;
  private BigDecimal promedioVentaPedido;
  private BigDecimal promedioUnidadesPedido;
  private BigDecimal promedioOrdenesPedido;
  private BigDecimal impRetencion;
  private Long capitalizacion;
  private Double retencion;
  private Long numEntregadas;
  private Long numRecibidas;
  private String nombrePeriodo;

  private BigDecimal actividad;
  
  // vbongiov -- 14/09/2006 -- Inc DBLG500000222
  private Boolean dentroRangoEvaluacion;
  private Boolean primerPeriodo;

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidUA()
  {
    return oidUA;
  }

  public void setOidUA(Long oidUA)
  {
    this.oidUA = oidUA;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public String getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }

  public Long getNumActivasIniciales()
  {
    return numActivasIniciales;
  }

  public void setNumActivasIniciales(Long numActivasIniciales)
  {
    this.numActivasIniciales = numActivasIniciales;
  }

  public Long getNumActivasFinales()
  {
    return numActivasFinales;
  }

  public void setNumActivasFinales(Long numActivasFinales)
  {
    this.numActivasFinales = numActivasFinales;
  }

  public BigDecimal getImpIngreso()
  {
    return impIngreso;
  }

  public void setImpIngreso(BigDecimal impIngreso)
  {
    this.impIngreso = impIngreso;
  }

  public BigDecimal getImpReingreso()
  {
    return impReingreso;
  }

  public void setImpReingreso(BigDecimal impReingreso)
  {
    this.impReingreso = impReingreso;
  }

  public BigDecimal getImpEgresos()
  {
    return impEgresos;
  }

  public void setImpEgresos(BigDecimal impEgresos)
  {
    this.impEgresos = impEgresos;
  }

  public Long getNumOrdenes()
  {
    return numOrdenes;
  }

  public void setNumOrdenes(Long numOrdenes)
  {
    this.numOrdenes = numOrdenes;
  }

  public Long getNumPedidos()
  {
    return numPedidos;
  }

  public void setNumPedidos(Long numPedidos)
  {
    this.numPedidos = numPedidos;
  }

  public Long getNumUnidadesVendidas()
  {
    return numUnidadesVendidas;
  }

  public void setNumUnidadesVendidas(Long numUnidadesVendidas)
  {
    this.numUnidadesVendidas = numUnidadesVendidas;
  }

  public Long getNumClientes()
  {
    return numClientes;
  }

  public void setNumClientes(Long numClientes)
  {
    this.numClientes = numClientes;
  }

  public BigDecimal getImpVentaEstadisticable()
  {
    return impVentaEstadisticable;
  }

  public void setImpVentaEstadisticable(BigDecimal impVentaEstadisticable)
  {
    this.impVentaEstadisticable = impVentaEstadisticable;
  }

  public BigDecimal getImpCapitalizacion()
  {
    return impCapitalizacion;
  }

  public void setImpCapitalizacion(BigDecimal impCapitalizacion)
  {
    this.impCapitalizacion = impCapitalizacion;
  }

  public BigDecimal getPrecioPromedioUnitario()
  {
    return precioPromedioUnitario;
  }

  public void setPrecioPromedioUnitario(BigDecimal precioPromedioUnitario)
  {
    this.precioPromedioUnitario = precioPromedioUnitario;
  }

  public BigDecimal getPromedioVentaPedido()
  {
    return promedioVentaPedido;
  }

  public void setPromedioVentaPedido(BigDecimal promedioVentaPedido)
  {
    this.promedioVentaPedido = promedioVentaPedido;
  }

  public BigDecimal getPromedioUnidadesPedido()
  {
    return promedioUnidadesPedido;
  }

  public void setPromedioUnidadesPedido(BigDecimal promedioUnidadesPedido)
  {
    this.promedioUnidadesPedido = promedioUnidadesPedido;
  }

  public BigDecimal getPromedioOrdenesPedido()
  {
    return promedioOrdenesPedido;
  }

  public void setPromedioOrdenesPedido(BigDecimal promedioOrdenesPedido)
  {
    this.promedioOrdenesPedido = promedioOrdenesPedido;
  }

  public BigDecimal getImpRetencion()
  {
    return impRetencion;
  }

  public void setImpRetencion(BigDecimal impRetencion)
  {
    this.impRetencion = impRetencion;
  }

  public Long getCapitalizacion()
  {
    return capitalizacion;
  }

  public void setCapitalizacion(Long capitalizacion)
  {
    this.capitalizacion = capitalizacion;
  }

  public BigDecimal getActividad()
  {
    return actividad;
  }

  public void setActividad(BigDecimal actividad)
  {
    this.actividad = actividad;
  }

  public Double getRetencion()
  {
    return retencion;
  }

  public void setRetencion(Double retencion)
  {
    this.retencion = retencion;
  }

  public Long getNumEntregadas()
  {
    return numEntregadas;
  }

  public void setNumEntregadas(Long numEntregadas)
  {
    this.numEntregadas = numEntregadas;
  }

  public Long getNumRecibidas()
  {
    return numRecibidas;
  }

  public void setNumRecibidas(Long numRecibidas)
  {
    this.numRecibidas = numRecibidas;
  }

  public String getNombrePeriodo()
  {
    return nombrePeriodo;
  }

  public void setNombrePeriodo(String nombrePeriodo)
  {
    this.nombrePeriodo = nombrePeriodo;
  }

  public Boolean getDentroRangoEvaluacion()
  {
    return dentroRangoEvaluacion;
  }

  public void setDentroRangoEvaluacion(Boolean dentroRangoEvaluacion)
  {
    this.dentroRangoEvaluacion = dentroRangoEvaluacion;
  }

  public Boolean getPrimerPeriodo()
  {
    return primerPeriodo;
  }

  public void setPrimerPeriodo(Boolean primerPeriodo)
  {
    this.primerPeriodo = primerPeriodo;
  }
}