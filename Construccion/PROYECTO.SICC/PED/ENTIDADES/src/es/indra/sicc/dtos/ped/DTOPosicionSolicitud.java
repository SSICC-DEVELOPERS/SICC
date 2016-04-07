package es.indra.sicc.dtos.ped;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

/**
 * 
 * modificaciones - 08/08/2005 - BELC300014487 - pperanzola
 */
public class DTOPosicionSolicitud extends DTOBelcorp implements Cloneable {

    private Long numeroPosicion;
    private Long unidadesDemandadas;
    private Long unidadesPorAtender;
    private Long unidadesComprometidas;
    private Long tipoPosicion;
    private Long producto;
    private Long formaPago;
    private String codigoVenta;
    private Long oidProducto;
    private Long estadoPosicion;
    private Long subtipoPosicion;
    private Long codigoVentaFicticio;
    private Long unidadesDemandaReal;     
    private BigDecimal precioCatalogoUnitarioLocal;
    private BigDecimal precioContableUnitarioLocal;
    private BigDecimal precioCatalogoUnitarioDocumento;
    private BigDecimal precioContableUnitarioDocumento;
    private Double porcentajeDescuento;
    private BigDecimal importeDescuentoUnitarioDocumento;
    private Boolean OK;
    private String mensajeError;
    private Long oidPosicionSolicitud;
    private Boolean cvOK;
  	private Long oidDetalleOferta;
  	private Long unidadesMaximas;
    private Long oidOferta;
    private Long tipoEstrategia;
    private Long indicadorCuadre;
    private Long factorCuadre;
    private Integer grupo;
    private Integer numeroOferta;
    private Long unidadesAtendidas;
    private Long posicionRecuperacion;
    private Long lineaProducto;
    private Long catalogo;
    private Integer factorRepeticion;
    private Boolean indCondicionante;
    private Integer pagina;
    private Long posicionRanking;
    private String codigoProducto;
    private String descripcionProducto;
    private String descripcionFormaPago;
    private Boolean controlStock;
    private Boolean productoReemplazado;
    private Boolean unidadesModificadas;
    private Boolean aAgregar;
    private String codigoVentaActual;
    private BigDecimal importeDescuentoUnitarioLocal;
    
    //cambio nº 2
    private String codFormaPago;
    private BigDecimal precioCatalogo;
    private Boolean indPosicionCompletada;
    private String cvOriginalAntesDeReemplazo;
    
    private Long oidEstrategia;
    private Long oidTipoOferta;    
    
    // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
    private Long oidAlmacen;    

    public DTOPosicionSolicitud() {
    }

	  public Boolean getOK() {
        return OK;
    }

    public void setOK(Boolean newOK) {
        OK = newOK;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String newCodigoVenta) {
        codigoVenta = newCodigoVenta;
    }

    public Long getCodigoVentaFicticio() {
        return codigoVentaFicticio;
    }

    public void setCodigoVentaFicticio(Long newCodigoVentaFicticio) {
        codigoVentaFicticio = newCodigoVentaFicticio;
    }

    public Boolean getCvOK() {
        return cvOK;
    }

    public void setCvOK(Boolean newCvOK) {
        cvOK = newCvOK;
    }

    public Long getEstadoPosicion() {
        return estadoPosicion;
    }

    public void setEstadoPosicion(Long newEstadoPosicion) {
        estadoPosicion = newEstadoPosicion;
    }

    public Long getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Long newFormaPago) {
        formaPago = newFormaPago;
    }

    public BigDecimal getImporteDescuentoUnitarioDocumento() {
        return importeDescuentoUnitarioDocumento;
    }

    public void setImporteDescuentoUnitarioDocumento(BigDecimal newImporteDescuentoUnitarioDocumento) {
        importeDescuentoUnitarioDocumento = newImporteDescuentoUnitarioDocumento;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String newMensajeError) {
        mensajeError = newMensajeError;
    }

    public Long getNumeroPosicion() {
        return numeroPosicion;
    }

    public void setNumeroPosicion(Long newNumeroPosicion) {
        numeroPosicion = newNumeroPosicion;
    }

    public Long getOidPosicionSolicitud() {
        return oidPosicionSolicitud;
    }

    public void setOidPosicionSolicitud(Long newOidPosicionSolicitud) {
        oidPosicionSolicitud = newOidPosicionSolicitud;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long newOidProducto) {
        oidProducto = newOidProducto;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double newPorcentajeDescuento) {
        porcentajeDescuento = newPorcentajeDescuento;
    }

    public BigDecimal getPrecioCatalogoUnitarioDocumento() {
        return precioCatalogoUnitarioDocumento;
    }

    public void setPrecioCatalogoUnitarioDocumento(BigDecimal newPrecioCatalogoUnitarioDocumento) {
        precioCatalogoUnitarioDocumento = newPrecioCatalogoUnitarioDocumento;
    }

    public BigDecimal getPrecioCatalogoUnitarioLocal() {
        return precioCatalogoUnitarioLocal;
    }

    public void setPrecioCatalogoUnitarioLocal(BigDecimal newPrecioCatalogoUnitarioLocal) {
        precioCatalogoUnitarioLocal = newPrecioCatalogoUnitarioLocal;
    }

    public BigDecimal getPrecioContableUnitarioDocumento() {
        return precioContableUnitarioDocumento;
    }

    public void setPrecioContableUnitarioDocumento(BigDecimal newPrecioContableUnitarioDocumento) {
        precioContableUnitarioDocumento = newPrecioContableUnitarioDocumento;
    }

    public BigDecimal getPrecioContableUnitarioLocal() {
        return precioContableUnitarioLocal;
    }

    public void setPrecioContableUnitarioLocal(BigDecimal newPrecioContableUnitarioLocal) {
        precioContableUnitarioLocal = newPrecioContableUnitarioLocal;
    }

    public Long getProducto() {
        return producto;
    }

    public void setProducto(Long newProducto) {
        producto = newProducto;
    }

    public Long getSubtipoPosicion() {
        return subtipoPosicion;
    }

    public void setSubtipoPosicion(Long newSubtipoPosicion) {
        subtipoPosicion = newSubtipoPosicion;
    }

    public Long getTipoPosicion() {
        return tipoPosicion;
    }

    public void setTipoPosicion(Long newTipoPosicion) {
        tipoPosicion = newTipoPosicion;
    }

    public Long getUnidadesDemandaReal() {
        return unidadesDemandaReal;
    }

    public void setUnidadesDemandaReal(Long newUnidadesDemandaReal) {
        unidadesDemandaReal = newUnidadesDemandaReal;
    }

    public Long getUnidadesDemandadas() {
        return unidadesDemandadas;
    }

    public void setUnidadesDemandadas(Long newUnidadesDemandadas) {
        unidadesDemandadas = newUnidadesDemandadas;
    }

    public Long getUnidadesPorAtender() {
        return unidadesPorAtender;
    }

    public void setUnidadesPorAtender(Long newUnidadesPorAtender) {
        unidadesPorAtender = newUnidadesPorAtender;
    }

	public Long getOidDetalleOferta() {
		return oidDetalleOferta;
	}

	public void setOidDetalleOferta(Long newOidDetalleOferta) {
		oidDetalleOferta = newOidDetalleOferta;
	}

	public Long getUnidadesMaximas() {
		return unidadesMaximas;
	}

	public void setUnidadesMaximas(Long newUnidadesMaximas) {
		unidadesMaximas = newUnidadesMaximas;
	}

  public Long getOidOferta() {
    return oidOferta;
  }

  public void setOidOferta(Long newOidOferta) {
    oidOferta = newOidOferta;
  }

  public Long getTipoEstrategia() {
    return tipoEstrategia;
  }

  public void setTipoEstrategia(Long newTipoEstrategia) {
    tipoEstrategia = newTipoEstrategia;
  }

  public Long getIndicadorCuadre() {
    return indicadorCuadre;
  }

  public void setIndicadorCuadre(Long newIndicadorCuadre) {
    indicadorCuadre = newIndicadorCuadre;
  }

  public Long getFactorCuadre() {
    return factorCuadre;
  }

  public void setFactorCuadre(Long newFactorCuadre) {
    factorCuadre = newFactorCuadre;
  }

  public Integer getGrupo() {
    return grupo;
  }

  public void setGrupo(Integer newGrupo) {
    grupo = newGrupo;
  }

  public Integer getNumeroOferta() {
    return numeroOferta;
  }

  public void setNumeroOferta(Integer newNumeroOferta) {
    numeroOferta = newNumeroOferta;
  }

  public Long getUnidadesAtendidas() {
    return unidadesAtendidas;
  }

  public void setUnidadesAtendidas(Long newUnidadesAtendidas) {
      unidadesAtendidas = newUnidadesAtendidas;
  }

    public Long getPosicionRecuperacion()
    {
        return posicionRecuperacion;
    }

    public void setPosicionRecuperacion(Long newPosicionRecuperacion)
    {
        posicionRecuperacion = newPosicionRecuperacion;
    }

    public Long getLineaProducto() {
        return lineaProducto;
    }

    public void setLineaProducto(Long newLineaProducto) {
        lineaProducto = newLineaProducto;
    }

    public Long getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Long newCatalogo) {
        catalogo = newCatalogo;
    }

    public Integer getFactorRepeticion() {
        return factorRepeticion;
    }

    public void setFactorRepeticion(Integer newFactorRepeticion) {
        factorRepeticion = newFactorRepeticion;
    }

    public Boolean getIndCondicionante() {
        return indCondicionante;
    }

    public void setIndCondicionante(Boolean newIndCondicionante) {
        indCondicionante = newIndCondicionante;
    }

  public Integer getPagina() {
    return pagina;
  }

  public void setPagina(Integer newPagina) {
    pagina = newPagina;
  }

  public Long getPosicionRanking() {
    return posicionRanking;
  }

  public void setPosicionRanking(Long newPosicionRanking) {
    posicionRanking = newPosicionRanking;
  }


  public void setUnidadesComprometidas(Long unidadesComprometidas)
  {
    this.unidadesComprometidas = unidadesComprometidas;
  }


  public Long getUnidadesComprometidas()
  {
    return unidadesComprometidas;
  }

  public String getCodigoProducto() {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto) {
    this.codigoProducto = codigoProducto;
  }

  public String getDescripcionProducto() {
    return descripcionProducto;
  }

  public void setDescripcionProducto(String descripcionProducto) {
    this.descripcionProducto = descripcionProducto;
  }

  public String getDescripcionFormaPago() {
    return descripcionFormaPago;
  }

  public void setDescripcionFormaPago(String descripcionFormaPago) {
    this.descripcionFormaPago = descripcionFormaPago;
  }

    public Boolean getControlStock()    {
        return controlStock;
    }

    public void setControlStock(Boolean controlStock)    {
        this.controlStock = controlStock;
    }

    public Boolean getProductoReemplazado()    {
        return productoReemplazado;
    }

    public void setProductoReemplazado(Boolean productoReemplazado)    {
        this.productoReemplazado = productoReemplazado;
    }

    public Boolean getUnidadesModificadas()    {
        return unidadesModificadas;
    }

    public void setUnidadesModificadas(Boolean unidadesModificadas)    {
        this.unidadesModificadas = unidadesModificadas;
    }
    
     public Boolean getAAgregar()   {
        return aAgregar;
    }

    public void setAAgregar(Boolean aAgregar) {
        this.aAgregar = aAgregar;
    }
    
    public String getCodigoVentaActual() {
      return codigoVentaActual;
    }

    public void setCodigoVentaActual(String codigoVentaActual) {
      this.codigoVentaActual = codigoVentaActual;
    }

    public BigDecimal getImporteDescuentoUnitarioLocal() {
        return importeDescuentoUnitarioLocal;
    }

    public void setImporteDescuentoUnitarioLocal(BigDecimal importeDescuentoUnitarioLocal) {
        this.importeDescuentoUnitarioLocal = importeDescuentoUnitarioLocal;
    }


  public void setPrecioCatalogo(BigDecimal precioCatalogo) {
    this.precioCatalogo = precioCatalogo;
  }


  public BigDecimal getPrecioCatalogo() {
    return precioCatalogo;
  }


  public void setCodFormaPago(String codFormaPago) {
    this.codFormaPago = codFormaPago;
  }


  public String getCodFormaPago() {
    return codFormaPago;
  }

    public Boolean getIndPosicionCompletada()
    {
        return indPosicionCompletada;
    }

    public void setIndPosicionCompletada(Boolean indPosicionCompletada)
    {
        this.indPosicionCompletada = indPosicionCompletada;
    }

    public String getCvOriginalAntesDeReemplazo() {
        return cvOriginalAntesDeReemplazo;
    }

    public void setCvOriginalAntesDeReemplazo(String cvOriginalAntesDeReemplazo) {
        this.cvOriginalAntesDeReemplazo = cvOriginalAntesDeReemplazo;
    }

    public void setOidEstrategia(Long oidEstrategia) {
        this.oidEstrategia = oidEstrategia;
    }

    public Long getOidEstrategia() {
        return oidEstrategia;
    }

    public void setOidTipoOferta(Long oidTipoOferta) {
        this.oidTipoOferta = oidTipoOferta;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }
    
    public Object clone () throws CloneNotSupportedException{
        return super.clone();
    }

    public void setOidAlmacen(Long oidAlmacen) {
        this.oidAlmacen = oidAlmacen;
    }

    public Long getOidAlmacen() {
        return oidAlmacen;
    }
}
