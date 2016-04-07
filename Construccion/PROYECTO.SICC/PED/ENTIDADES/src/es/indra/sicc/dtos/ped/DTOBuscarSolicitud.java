package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;
import java.math.BigDecimal;

public class DTOBuscarSolicitud extends DTOSiccPaginacion {

    private Long canal;
    private Long acceso;
    private Long subacceso;
    private Long tipoSolicitud;
    private String cliente;
    private String pagador;
    private String receptor;
    private Long grupoProcesos;
    private Long proceso;
    private Long marca;
    private Long periodo;
    private Date fechaDesde;
    private Date fechaHasta;
    private Long estado;
    private BigDecimal totalPagarDesde;
    private BigDecimal totalPagarHasta;
    private Boolean indModificacion;
    private Long numeroSolicitud;
  private String operacion;

  public void setCanal(Long canal)
  {
    this.canal = canal;
  }


  public Long getCanal()
  {
    return canal;
  }


  public void setAcceso(Long acceso)
  {
    this.acceso = acceso;
  }


  public Long getAcceso()
  {
    return acceso;
  }


  public void setTipoSolicitud(Long tipoSolicitud)
  {
    this.tipoSolicitud = tipoSolicitud;
  }


  public Long getTipoSolicitud()
  {
    return tipoSolicitud;
  }


  public void setCliente(String cliente)
  {
    this.cliente = cliente;
  }


  public String getCliente()
  {
    return cliente;
  }


  public void setPagador(String pagador)
  {
    this.pagador = pagador;
  }


  public String getPagador()
  {
    return pagador;
  }


  public void setReceptor(String receptor)
  {
    this.receptor = receptor;
  }


  public String getReceptor()
  {
    return receptor;
  }


  public void setGrupoProcesos(Long grupoProcesos)
  {
    this.grupoProcesos = grupoProcesos;
  }


  public Long getGrupoProcesos()
  {
    return grupoProcesos;
  }


  public void setProceso(Long proceso)
  {
    this.proceso = proceso;
  }


  public Long getProceso()
  {
    return proceso;
  }


  public void setMarca(Long marca)
  {
    this.marca = marca;
  }


  public Long getMarca()
  {
    return marca;
  }


  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }


  public Long getPeriodo()
  {
    return periodo;
  }


  public void setFechaDesde(Date fechaDesde)
  {
    this.fechaDesde = fechaDesde;
  }


  public Date getFechaDesde()
  {
    return fechaDesde;
  }


  public void setFechaHasta(Date fechaHasta)
  {
    this.fechaHasta = fechaHasta;
  }


  public Date getFechaHasta()
  {
    return fechaHasta;
  }


  public void setEstado(Long estado)
  {
    this.estado = estado;
  }


  public Long getEstado()
  {
    return estado;
  }


  public void setTotalPagarDesde(BigDecimal totalPagarDesde)
  {
    this.totalPagarDesde = totalPagarDesde;
  }


  public BigDecimal getTotalPagarDesde()
  {
    return totalPagarDesde;
  }


  public void setTotalPagarHasta(BigDecimal totalPagarHasta)
  {
    this.totalPagarHasta = totalPagarHasta;
  }


  public BigDecimal getTotalPagarHasta()
  {
    return totalPagarHasta;
  }


  public void setIndModificacion(Boolean indModificacion)
  {
    this.indModificacion = indModificacion;
  }


  public Boolean getIndModificacion()
  {
    return indModificacion;
  }


  public void setSubacceso(Long subacceso) {
    this.subacceso = subacceso;
  }


  public Long getSubacceso() {
    return subacceso;
  }


    public void setNumeroSolicitud(Long numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }


    public Long getNumeroSolicitud() {
        return numeroSolicitud;
    }

  public String getOperacion()
  {
    return operacion;
  }

  public void setOperacion(String operacion)
  {
    this.operacion = operacion;
  }

}