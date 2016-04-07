package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;
import java.math.BigDecimal;

public class DTOINTTxCliente extends DTOBelcorp  {
    private String codigoCliente;
    private String codigoAcceso;
    private Long codigoTerritorio;
    private Long numeroSolicitud;
    private Date fechaFacturacion;
    private String tipoSolicitud;
    private Boolean indicadorDevoluciones;
    private Boolean indicadorAnulaciones;
    private String codigoProducto;
    private String codigoVenta;
    private String tipoOferta;
    private Long unidadesAtendidas;
    private Long unidadesNoAtendidas;

    //<inicio> Modificado por Sapaza - Fecha 20/04/2007 - Cambio Sicc20070147
    private Long unidadesDevueltas;
    private Long unidadesAnuladas;
    //<fin> Modificado por Sapaza - Fecha 20/04/2007 - Cambio Sicc20070147
    
    private BigDecimal precioNetoUnitarioLocal;
    private BigDecimal precioNetoTotalLocal;
    private BigDecimal precioFacturaUnitarioLocal;
    private BigDecimal precioFacturaTotalLocal;
    private String codigoZona;
    private Long numeroOrdenes;
    private Long numeroClientes;
    private Long numeroActivasInicioCampania;
    private Long numeroIngresos;
    private Long numeroEgresos;
    private Long numeroConsultorasReingreso;
    private Long numeroConsultorasRecibidas;
    private Long numeroConsultorasEntregadas;
    private Long numeroRealPedidos;
    private Long numeroConsultorasActivas;
    private Integer unidadesVendidas;
    private BigDecimal estimadoVentasNetas;
    private String ubicacionGeografica;
    private String marcaProducto;
    
    //Incidencia BELC300016329
    private String periodoDocumentoReferencia;
    private Long estimadoNumeroPedidos;
    private Long estimadoNumeroClientes;
    private Long estimadoNumeroActivas;
    private Long estimadoNumeroIngresos;
    private Long estimadoNumeroEgresos;
    private Long estimadoNumeroReingresos;
  private String periodoDocumento;
  private String codigoCanal;
  
    // gPineda - 15/02/2007 - INT-DAT-003
    private String codigoSeccion; 

    // Agregado por HRCS - Fecha 21/03/2007 - Cambio Sicc20070147
    private BigDecimal precioCatalogoUnitarioLocal;

    // Cambio SiCC 20070511 - dmorello
    private BigDecimal actividadInfladaZona;
    private Long nroConsultorasClientesPrivilege;
    private Long nroClientesInscritosPrivilege;
    private Long nroClientesTransaccionesPrivilege;
    private Long retencion2doPedido;
    private Long retencion3erPedido;
    private Long retencion4toPedido;
    private Long retencionActivas;
    private BigDecimal porcentajeRotacion;
    private Long posiblesEgresos;
    private Long retencionPosiblesEgresos;
    private BigDecimal porcentajeEgresos;
    private BigDecimal pup;
    private BigDecimal ppu;
    // Fin cambio SiCC 20070511 - dmorello

    /**
     */
    private BigDecimal montoFaltante;
    
    private BigDecimal oportunidadAhorro;
    
    //Agregado por Sapaza - Fecha 01/09/2011 - RCR PER-SiCC-2011-0566
    private Long unidadesRetorno;
    private Long unidadesAtencion;
    private BigDecimal montoNetoRetorno;
    private BigDecimal montoNetoAtencion;
    private BigDecimal montoNetoVenta;
    private BigDecimal montoNetoDevolucion;
    private BigDecimal montoNetoAnulacion;
    
    public DTOINTTxCliente() {
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public Long getCodigoTerritorio() {
        return codigoTerritorio;
    }

    public void setCodigoTerritorio(Long codigoTerritorio) {
        this.codigoTerritorio = codigoTerritorio;
    }

    public Long getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(Long numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public Date getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Date fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Boolean getIndicadorDevoluciones() {
        return indicadorDevoluciones;
    }

    public void setIndicadorDevoluciones(Boolean indicadorDevoluciones) {
        this.indicadorDevoluciones = indicadorDevoluciones;
    }

    public Boolean getIndicadorAnulaciones() {
        return indicadorAnulaciones;
    }

    public void setIndicadorAnulaciones(Boolean indicadorAnulaciones) {
        this.indicadorAnulaciones = indicadorAnulaciones;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public Long getUnidadesAtendidas() {
        return unidadesAtendidas;
    }

    public void setUnidadesAtendidas(Long unidadesAtendidas) {
        this.unidadesAtendidas = unidadesAtendidas;
    }

    public Long getUnidadesNoAtendidas() {
        return unidadesNoAtendidas;
    }

    public void setUnidadesNoAtendidas(Long unidadesNoAtendidas) {
        this.unidadesNoAtendidas = unidadesNoAtendidas;
    }

    public BigDecimal getPrecioNetoUnitarioLocal() {
        return precioNetoUnitarioLocal;
    }

    public void setPrecioNetoUnitarioLocal(BigDecimal precioNetoUnitarioLocal) {
        this.precioNetoUnitarioLocal = precioNetoUnitarioLocal;
    }

    public BigDecimal getPrecioNetoTotalLocal() {
        return precioNetoTotalLocal;
    }

    public void setPrecioNetoTotalLocal(BigDecimal precioNetoTotalLocal) {
        this.precioNetoTotalLocal = precioNetoTotalLocal;
    }

    public BigDecimal getPrecioFacturaUnitarioLocal() {
        return precioFacturaUnitarioLocal;
    }

    public void setPrecioFacturaUnitarioLocal(BigDecimal precioFacturaUnitarioLocal) {
        this.precioFacturaUnitarioLocal = precioFacturaUnitarioLocal;
    }

    public BigDecimal getPrecioFacturaTotalLocal() {
        return precioFacturaTotalLocal;
    }

    public void setPrecioFacturaTotalLocal(BigDecimal precioFacturaTotalLocal) {
        this.precioFacturaTotalLocal = precioFacturaTotalLocal;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public Long getNumeroOrdenes() {
        return numeroOrdenes;
    }

    public void setNumeroOrdenes(Long numeroOrdenes) {
        this.numeroOrdenes = numeroOrdenes;
    }

    public Long getNumeroClientes() {
        return numeroClientes;
    }

    public void setNumeroClientes(Long numeroClientes) {
        this.numeroClientes = numeroClientes;
    }

    public Long getNumeroActivasInicioCampania() {
        return numeroActivasInicioCampania;
    }

    public void setNumeroActivasInicioCampania(Long numeroActivasInicioCampania) {
        this.numeroActivasInicioCampania = numeroActivasInicioCampania;
    }

    public Long getNumeroIngresos() {
        return numeroIngresos;
    }

    public void setNumeroIngresos(Long numeroIngresos) {
        this.numeroIngresos = numeroIngresos;
    }

    public Long getNumeroEgresos() {
        return numeroEgresos;
    }

    public void setNumeroEgresos(Long numeroEgresos) {
        this.numeroEgresos = numeroEgresos;
    }

    public Long getNumeroConsultorasReingreso() {
        return numeroConsultorasReingreso;
    }

    public void setNumeroConsultorasReingreso(Long numeroConsultorasReingreso) {
        this.numeroConsultorasReingreso = numeroConsultorasReingreso;
    }

    public Long getNumeroConsultorasRecibidas() {
        return numeroConsultorasRecibidas;
    }

    public void setNumeroConsultorasRecibidas(Long numeroConsultorasRecibidas) {
        this.numeroConsultorasRecibidas = numeroConsultorasRecibidas;
    }

    public Long getNumeroConsultorasEntregadas() {
        return numeroConsultorasEntregadas;
    }

    public void setNumeroConsultorasEntregadas(Long numeroConsultorasEntregadas) {
        this.numeroConsultorasEntregadas = numeroConsultorasEntregadas;
    }

    public Long getNumeroRealPedidos() {
        return numeroRealPedidos;
    }

    public void setNumeroRealPedidos(Long numeroRealPedidos) {
        this.numeroRealPedidos = numeroRealPedidos;
    }

    public Long getNumeroConsultorasActivas() {
        return numeroConsultorasActivas;
    }

    public void setNumeroConsultorasActivas(Long numeroConsultorasActivas) {
        this.numeroConsultorasActivas = numeroConsultorasActivas;
    }

    public Integer getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(Integer unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public BigDecimal getEstimadoVentasNetas() {
        return estimadoVentasNetas;
    }

    public void setEstimadoVentasNetas(BigDecimal estimadoVentasNetas) {
        this.estimadoVentasNetas = estimadoVentasNetas;
    }

    public String getPeriodoDocumentoReferencia() {
        return periodoDocumentoReferencia;
    }

    public void setPeriodoDocumentoReferencia(String periodoDocumentoReferencia) {
        this.periodoDocumentoReferencia = periodoDocumentoReferencia;
    }

    public Long getEstimadoNumeroPedidos() {
        return estimadoNumeroPedidos;
    }

    public void setEstimadoNumeroPedidos(Long estimadoNumeroPedidos) {
        this.estimadoNumeroPedidos = estimadoNumeroPedidos;
    }

    public Long getEstimadoNumeroClientes() {
        return estimadoNumeroClientes;
    }

    public void setEstimadoNumeroClientes(Long estimadoNumeroClientes) {
        this.estimadoNumeroClientes = estimadoNumeroClientes;
    }

    public Long getEstimadoNumeroActivas() {
        return estimadoNumeroActivas;
    }

    public void setEstimadoNumeroActivas(Long estimadoNumeroActivas) {
        this.estimadoNumeroActivas = estimadoNumeroActivas;
    }

    public Long getEstimadoNumeroIngresos() {
        return estimadoNumeroIngresos;
    }

    public void setEstimadoNumeroIngresos(Long estimadoNumeroIngresos) {
        this.estimadoNumeroIngresos = estimadoNumeroIngresos;
    }

    public Long getEstimadoNumeroEgresos() {
        return estimadoNumeroEgresos;
    }

    public void setEstimadoNumeroEgresos(Long estimadoNumeroEgresos) {
        this.estimadoNumeroEgresos = estimadoNumeroEgresos;
    }

    public Long getEstimadoNumeroReingresos() {
        return estimadoNumeroReingresos;
    }

    public void setEstimadoNumeroReingresos(Long estimadoNumeroReingresos) {
        this.estimadoNumeroReingresos = estimadoNumeroReingresos;
    }

  public String getUbicacionGeografica() {
    return ubicacionGeografica;
  }

  public void setUbicacionGeografica(String ubicacionGeografica) {
    this.ubicacionGeografica = ubicacionGeografica;
  }

  public void setMarcaProducto(String marcaProducto) {
    this.marcaProducto = marcaProducto;
  }
  
  public String getMarcaProducto() {
    return marcaProducto;
  }

  public String getPeriodoDocumento()
  {
    return periodoDocumento;
  }

  public void setPeriodoDocumento(String periodoDocumento)
  {
    this.periodoDocumento = periodoDocumento;
  }

  public String getCodigoCanal()
  {
    return codigoCanal;
  }

  public void setCodigoCanal(String codigoCanal)
  {
    this.codigoCanal = codigoCanal;
  }


    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }


    public String getCodigoSeccion() {
        return codigoSeccion;
    }


    public void setPrecioCatalogoUnitarioLocal(BigDecimal precioCatalogoUnitarioLocal) {
        this.precioCatalogoUnitarioLocal = precioCatalogoUnitarioLocal;
    }


    public BigDecimal getPrecioCatalogoUnitarioLocal() {
        return precioCatalogoUnitarioLocal;
    }


  public void setUnidadesDevueltas(Long unidadesDevueltas)
  {
    this.unidadesDevueltas = unidadesDevueltas;
  }


  public Long getUnidadesDevueltas()
  {
    return unidadesDevueltas;
  }


  public void setUnidadesAnuladas(Long unidadesAnuladas)
  {
    this.unidadesAnuladas = unidadesAnuladas;
  }


  public Long getUnidadesAnuladas()
  {
    return unidadesAnuladas;
  }
    
  public BigDecimal getActividadInfladaZona() {
    return actividadInfladaZona;
  }
  
  public void setActividadInfladaZona(BigDecimal actividadInfladaZona) {
    this.actividadInfladaZona = actividadInfladaZona;
  }
  
  public Long getNroConsultorasClientesPrivilege() {
    return nroConsultorasClientesPrivilege;
  }
  
  public void setNroConsultorasClientesPrivilege(Long nroConsultorasClientesPrivilege) {
    this.nroConsultorasClientesPrivilege = nroConsultorasClientesPrivilege;
  }
  
  public Long getNroClientesInscritosPrivilege() {
    return nroClientesInscritosPrivilege;
  }
  
  public void setNroClientesInscritosPrivilege(Long nroClientesInscritosPrivilege) {
    this.nroClientesInscritosPrivilege = nroClientesInscritosPrivilege;
  }
  
  public Long getNroClientesTransaccionesPrivilege() {
    return nroClientesTransaccionesPrivilege;
  }
  
  public void setNroClientesTransaccionesPrivilege(Long nroClientesTransaccionesPrivilege) {
    this.nroClientesTransaccionesPrivilege = nroClientesTransaccionesPrivilege;
  }
  
  public Long getRetencion2doPedido() {
    return retencion2doPedido;
  }
  
  public void setRetencion2doPedido(Long retencion2doPedido) {
    this.retencion2doPedido = retencion2doPedido;
  }
  
  public Long getRetencion3erPedido() {
    return retencion3erPedido;
  }
  
  public void setRetencion3erPedido(Long retencion3erPedido) {
    this.retencion3erPedido = retencion3erPedido;
  }
  
  public Long getRetencion4toPedido() {
    return retencion4toPedido;
  }
  
  public void setRetencion4toPedido(Long retencion4toPedido) {
    this.retencion4toPedido = retencion4toPedido;
  }
  
  public Long getRetencionActivas() {
    return retencionActivas;
  }
  
  public void setRetencionActivas(Long retencionActivas) {
    this.retencionActivas = retencionActivas;
  }
  
  public BigDecimal getPorcentajeRotacion() {
    return porcentajeRotacion;
  }
  
  public void setPorcentajeRotacion(BigDecimal porcentajeRotacion) {
    this.porcentajeRotacion = porcentajeRotacion;
  }
  
  public Long getPosiblesEgresos() {
    return posiblesEgresos;
  }
  
  public void setPosiblesEgresos(Long posiblesEgresos) {
    this.posiblesEgresos = posiblesEgresos;
  }
  
  public Long getRetencionPosiblesEgresos() {
    return retencionPosiblesEgresos;
  }
  
  public void setRetencionPosiblesEgresos(Long retencionPosiblesEgresos) {
    this.retencionPosiblesEgresos = retencionPosiblesEgresos;
  }
  
  public BigDecimal getPorcentajeEgresos() {
    return porcentajeEgresos;
  }
  
  public void setPorcentajeEgresos(BigDecimal porcentajeEgresos) {
    this.porcentajeEgresos = porcentajeEgresos;
  }
  
  public BigDecimal getPup() {
    return pup;
  }
  
  public void setPup(BigDecimal pup) {
    this.pup = pup;
  }
  
  public BigDecimal getPpu() {
    return ppu;
  }
  
  public void setPpu(BigDecimal ppu) {
    this.ppu = ppu;
  }

    public BigDecimal getMontoFaltante() {
        return montoFaltante;
    }

    public void setMontoFaltante(BigDecimal montoFaltante) {
        this.montoFaltante = montoFaltante;
    }

    public BigDecimal getOportunidadAhorro() {
        return oportunidadAhorro;
    }

    public void setOportunidadAhorro(BigDecimal oportunidadAhorro) {
        this.oportunidadAhorro = oportunidadAhorro;
    }

    public void setUnidadesRetorno(Long unidadesRetorno) {
        this.unidadesRetorno = unidadesRetorno;
    }

    public Long getUnidadesRetorno() {
        return unidadesRetorno;
    }

    public void setUnidadesAtencion(Long unidadesAtencion) {
        this.unidadesAtencion = unidadesAtencion;
    }

    public Long getUnidadesAtencion() {
        return unidadesAtencion;
    }

    public void setMontoNetoRetorno(BigDecimal montoNetoRetorno) {
        this.montoNetoRetorno = montoNetoRetorno;
    }

    public BigDecimal getMontoNetoRetorno() {
        return montoNetoRetorno;
    }

    public void setMontoNetoAtencion(BigDecimal montoNetoAtencion) {
        this.montoNetoAtencion = montoNetoAtencion;
    }

    public BigDecimal getMontoNetoAtencion() {
        return montoNetoAtencion;
    }

    public void setMontoNetoVenta(BigDecimal montoNetoVenta) {
        this.montoNetoVenta = montoNetoVenta;
    }

    public BigDecimal getMontoNetoVenta() {
        return montoNetoVenta;
    }

    public void setMontoNetoDevolucion(BigDecimal montoNetoDevolucion) {
        this.montoNetoDevolucion = montoNetoDevolucion;
    }

    public BigDecimal getMontoNetoDevolucion() {
        return montoNetoDevolucion;
    }

    public void setMontoNetoAnulacion(BigDecimal montoNetoAnulacion) {
        this.montoNetoAnulacion = montoNetoAnulacion;
    }

    public BigDecimal getMontoNetoAnulacion() {
        return montoNetoAnulacion;
    }
}
