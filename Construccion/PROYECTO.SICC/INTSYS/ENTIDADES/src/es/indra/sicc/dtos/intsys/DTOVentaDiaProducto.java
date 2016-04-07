package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.Date;

public class DTOVentaDiaProducto extends DTOBelcorp  {
	private Long pais;
	private Long oidPeriodo;
	private Long oidSubAcceso;
	private Long oidAlmacen;
	private Long oidSociedad;
	private Long oidTipoSolicitudPais;
	private Long oidTipoCliente;
	private Long oidProducto;
	private Long oidCicloVida;
	private Long oidTipoOferta;
	private Long oidCondicionPromocion;
  private Long unidadesAtendidas;
	private BigDecimal ventaNeta;
	private BigDecimal precioCatalogoTotalLocal;
	private Date fechaFacturacion;
	private String codVenta;
	private Boolean unidadesVendidas;
	private Boolean unidadesFaltantes;
	private Boolean unidadesDevueltas;
	private Boolean unidadesAnuladas;
	private Boolean unidadesCanje;
	private Boolean unidadesTrueque;
	private Boolean flagVenta;
  private String territorio;
    private Long oidTerritorio; //17/01/2007
  
  //SCS (05/10/2006) se agregan mas atrib. por perf.!
	private String codSociedad;
	private String codAlmacen;
	private String medio;
	private String canalBPS;
	private String codPerio;
	private String codSAP;
	private String codCicloVida;
	private String codTipoOfer;
	private String codCondProm;
	private String codMarca;
  
  /* SICC-GCC-INT-SAB-004 - dmorello, 22/11/2006: Se agregan tres atributos */
  private Long oidRegion;
  private Long oidZona;
  private Long unidadesPorAtender;

  /* BELC300024603 - dmorello, 05/01/2007 */
  private Long unidadesAtendidasVendidas;
  private Long unidadesAtendidasFaltantes;
  private Long unidadesAtendidasDevueltas;
  private Long unidadesAtendidasAnuladas;
  private Long unidadesAtendidasCanje;
  private Long unidadesAtendidasTrueque;
  private BigDecimal ventaNetaVendidas;
  private BigDecimal ventaNetaFaltantes;
  private BigDecimal ventaNetaDevueltas;
  private BigDecimal ventaNetaAnuladas;
  private BigDecimal ventaNetaCanje;
  private BigDecimal ventaNetaTrueque;
  private BigDecimal precioCatalogoTotalLocalVendidas;
  private BigDecimal precioCatalogoTotalLocalFaltantes;
    private Integer anioComercial;
    private Long oidMoneda;

	public DTOVentaDiaProducto() {
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long pais) {
		this.pais = pais;
	}

	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long oidPeriodo) {
		this.oidPeriodo = oidPeriodo;
	}

	public Long getOidSubAcceso() {
		return oidSubAcceso;
	}

	public void setOidSubAcceso(Long oidSubAcceso) {
		this.oidSubAcceso = oidSubAcceso;
	}

	public Long getOidAlmacen() {
		return oidAlmacen;
	}

	public void setOidAlmacen(Long oidAlmacen) {
		this.oidAlmacen = oidAlmacen;
	}

	public Long getOidSociedad() {
		return oidSociedad;
	}

	public void setOidSociedad(Long oidSociedad) {
		this.oidSociedad = oidSociedad;
	}

	public Long getOidTipoSolicitudPais() {
		return oidTipoSolicitudPais;
	}

	public void setOidTipoSolicitudPais(Long oidTipoSolicitudPais) {
		this.oidTipoSolicitudPais = oidTipoSolicitudPais;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long oidTipoCliente) {
		this.oidTipoCliente = oidTipoCliente;
	}

	public Long getOidProducto() {
		return oidProducto;
	}

	public void setOidProducto(Long oidProducto) {
		this.oidProducto = oidProducto;
	}

	public Long getOidCicloVida() {
		return oidCicloVida;
	}

	public void setOidCicloVida(Long oidCicloVida) {
		this.oidCicloVida = oidCicloVida;
	}

	public Long getOidTipoOferta() {
		return oidTipoOferta;
	}

	public void setOidTipoOferta(Long oidTipoOferta) {
		this.oidTipoOferta = oidTipoOferta;
	}

	public Long getOidCondicionPromocion() {
		return oidCondicionPromocion;
	}

	public void setOidCondicionPromocion(Long oidCondicionPromocion) {
		this.oidCondicionPromocion = oidCondicionPromocion;
	}

	public Long getUnidadesAtendidas() {
		return unidadesAtendidas;
	}

	public void setUnidadesAtendidas(Long unidadesAtendidas) {
		this.unidadesAtendidas = unidadesAtendidas;
	}

	public BigDecimal getVentaNeta() {
		return ventaNeta;
	}

	public void setVentaNeta(BigDecimal ventaNeta) {
		this.ventaNeta = ventaNeta;
	}

	public BigDecimal getPrecioCatalogoTotalLocal() {
		return precioCatalogoTotalLocal;
	}

	public void setPrecioCatalogoTotalLocal(BigDecimal precioCatalogoTotalLocal) {
		this.precioCatalogoTotalLocal = precioCatalogoTotalLocal;
	}

	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(Date fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	public String getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(String codVenta) {
		this.codVenta = codVenta;
	}

	public Boolean getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(Boolean unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public Boolean getUnidadesFaltantes() {
		return unidadesFaltantes;
	}

	public void setUnidadesFaltantes(Boolean unidadesFaltantes) {
		this.unidadesFaltantes = unidadesFaltantes;
	}

	public Boolean getUnidadesDevueltas() {
		return unidadesDevueltas;
	}

	public void setUnidadesDevueltas(Boolean unidadesDevueltas) {
		this.unidadesDevueltas = unidadesDevueltas;
	}

	public Boolean getUnidadesAnuladas() {
		return unidadesAnuladas;
	}

	public void setUnidadesAnuladas(Boolean unidadesAnuladas) {
		this.unidadesAnuladas = unidadesAnuladas;
	}

	public Boolean getUnidadesCanje() {
		return unidadesCanje;
	}

	public void setUnidadesCanje(Boolean unidadesCanje) {
		this.unidadesCanje = unidadesCanje;
	}

	public Boolean getUnidadesTrueque() {
		return unidadesTrueque;
	}

	public void setUnidadesTrueque(Boolean unidadesTrueque) {
		this.unidadesTrueque = unidadesTrueque;
	}

	public Boolean getFlagVenta() {
		return flagVenta;
	}

	public void setFlagVenta(Boolean flagVenta) {
		this.flagVenta = flagVenta;
	}

    public String getTerritorio() {
        return territorio;
    }

    public void setTerritorio(String territorio) {
        this.territorio = territorio;
    }


  public void setCodSociedad(String codSociedad) {
    this.codSociedad = codSociedad;
  }


  public String getCodSociedad() {
    return codSociedad;
  }


  public void setCodAlmacen(String codAlmacen) {
    this.codAlmacen = codAlmacen;
  }


  public String getCodAlmacen() {
    return codAlmacen;
  }


  public void setMedio(String medio) {
    this.medio = medio;
  }


  public String getMedio() {
    return medio;
  }


  public void setCanalBPS(String canalBPS) {
    this.canalBPS = canalBPS;
  }


  public String getCanalBPS() {
    return canalBPS;
  }


  public void setCodPerio(String codPerio) {
    this.codPerio = codPerio;
  }


  public String getCodPerio() {
    return codPerio;
  }


  public void setCodSAP(String codSAP) {
    this.codSAP = codSAP;
  }


  public String getCodSAP() {
    return codSAP;
  }


  public void setCodCicloVida(String codCicloVida) {
    this.codCicloVida = codCicloVida;
  }


  public String getCodCicloVida() {
    return codCicloVida;
  }


  public void setCodTipoOfer(String codTipoOfer) {
    this.codTipoOfer = codTipoOfer;
  }


  public String getCodTipoOfer() {
    return codTipoOfer;
  }


  public void setCodCondProm(String codCondProm) {
    this.codCondProm = codCondProm;
  }


  public String getCodCondProm() {
    return codCondProm;
  }


  public void setCodMarca(String codMarca) {
    this.codMarca = codMarca;
  }


  public String getCodMarca() {
    return codMarca;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getUnidadesPorAtender()
  {
    return unidadesPorAtender;
  }

  public void setUnidadesPorAtender(Long unidadesPorAtender)
  {
    this.unidadesPorAtender = unidadesPorAtender;
  }

  public Long getUnidadesAtendidasVendidas()
  {
    return unidadesAtendidasVendidas;
  }

  public void setUnidadesAtendidasVendidas(Long unidadesAtendidasVendidas)
  {
    this.unidadesAtendidasVendidas = unidadesAtendidasVendidas;
  }

  public Long getUnidadesAtendidasFaltantes()
  {
    return unidadesAtendidasFaltantes;
  }

  public void setUnidadesAtendidasFaltantes(Long unidadesAtendidasFaltantes)
  {
    this.unidadesAtendidasFaltantes = unidadesAtendidasFaltantes;
  }

  public Long getUnidadesAtendidasDevueltas()
  {
    return unidadesAtendidasDevueltas;
  }

  public void setUnidadesAtendidasDevueltas(Long unidadesAtendidasDevueltas)
  {
    this.unidadesAtendidasDevueltas = unidadesAtendidasDevueltas;
  }

  public Long getUnidadesAtendidasAnuladas()
  {
    return unidadesAtendidasAnuladas;
  }

  public void setUnidadesAtendidasAnuladas(Long unidadesAtendidasAnuladas)
  {
    this.unidadesAtendidasAnuladas = unidadesAtendidasAnuladas;
  }

  public Long getUnidadesAtendidasCanje()
  {
    return unidadesAtendidasCanje;
  }

  public void setUnidadesAtendidasCanje(Long unidadesAtendidasCanje)
  {
    this.unidadesAtendidasCanje = unidadesAtendidasCanje;
  }

  public Long getUnidadesAtendidasTrueque()
  {
    return unidadesAtendidasTrueque;
  }

  public void setUnidadesAtendidasTrueque(Long unidadesAtendidasTrueque)
  {
    this.unidadesAtendidasTrueque = unidadesAtendidasTrueque;
  }

  public BigDecimal getVentaNetaVendidas()
  {
    return ventaNetaVendidas;
  }

  public void setVentaNetaVendidas(BigDecimal ventaNetaVendidas)
  {
    this.ventaNetaVendidas = ventaNetaVendidas;
  }

  public BigDecimal getVentaNetaFaltantes()
  {
    return ventaNetaFaltantes;
  }

  public void setVentaNetaFaltantes(BigDecimal ventaNetaFaltantes)
  {
    this.ventaNetaFaltantes = ventaNetaFaltantes;
  }

  public BigDecimal getVentaNetaDevueltas()
  {
    return ventaNetaDevueltas;
  }

  public void setVentaNetaDevueltas(BigDecimal ventaNetaDevueltas)
  {
    this.ventaNetaDevueltas = ventaNetaDevueltas;
  }

  public BigDecimal getVentaNetaAnuladas()
  {
    return ventaNetaAnuladas;
  }

  public void setVentaNetaAnuladas(BigDecimal ventaNetaAnuladas)
  {
    this.ventaNetaAnuladas = ventaNetaAnuladas;
  }

  public BigDecimal getVentaNetaCanje()
  {
    return ventaNetaCanje;
  }

  public void setVentaNetaCanje(BigDecimal ventaNetaCanje)
  {
    this.ventaNetaCanje = ventaNetaCanje;
  }

  public BigDecimal getVentaNetaTrueque()
  {
    return ventaNetaTrueque;
  }

  public void setVentaNetaTrueque(BigDecimal ventaNetaTrueque)
  {
    this.ventaNetaTrueque = ventaNetaTrueque;
  }

  public BigDecimal getPrecioCatalogoTotalLocalVendidas()
  {
    return precioCatalogoTotalLocalVendidas;
  }

  public void setPrecioCatalogoTotalLocalVendidas(BigDecimal precioCatalogoTotalLocalVendidas)
  {
    this.precioCatalogoTotalLocalVendidas = precioCatalogoTotalLocalVendidas;
  }

  public BigDecimal getPrecioCatalogoTotalLocalFaltantes()
  {
    return precioCatalogoTotalLocalFaltantes;
  }

  public void setPrecioCatalogoTotalLocalFaltantes(BigDecimal precioCatalogoTotalLocalFaltantes)
  {
    this.precioCatalogoTotalLocalFaltantes = precioCatalogoTotalLocalFaltantes;
  }


    public void setOidTerritorio(Long oidTerritorio) {
        this.oidTerritorio = oidTerritorio;
    }


    public Long getOidTerritorio() {
        return oidTerritorio;
    }

    public Integer getAnioComercial() {
        return anioComercial;
    }

    public void setAnioComercial(Integer anioComercial) {
        this.anioComercial = anioComercial;
    }

    public Long getOidMoneda() {
        return oidMoneda;
    }

    public void setOidMoneda(Long oidMoneda) {
        this.oidMoneda = oidMoneda;
    }
}