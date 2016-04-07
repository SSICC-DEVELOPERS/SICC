package es.indra.sicc.logicanegocio.intsys;
import java.math.BigDecimal;
import java.util.Date;

public class FuenteVentasRealAcumulada  {//BELC300016863

	private String codigoPais;
	private String codigoSociedad;
	private String codigoAlmacen;
	private String canalBPS;
	private String codigoZona;
	private String codigoRegion;
	private Long numeroOrdenes;
	private Long numeroPedidos;
	private Long numeroClientes;
	private Long unidadesVendidas;
	private BigDecimal ventaNetaEstadisticable;
	private Date fechaCierre;
	private Long marca;
	private Long periodo;
	private Long activasIniciales;
	private Long activasFinales;
	private Long ingresos;
	private Long egresos;
	private Long reingresos;
	private Long rezonificadasRecibidas;
	private Long rezonificadasEntregadas;
    //BELC300017190
    private Long canal;
    //BELC300017111
    private Long zona;
    
    //BELC300018713
    private Long region;
    private Long pais;
    private Long tipoSolicitudPais;
    private Long almacen;
    private Long tipoCliente;
    private Long sociedad;
    // 23122 - dmorello, 12/05/2006: Quito este campo ya que no se usará
    //private String marcaProducto;
    private String territorio;
    // 23122 - dmorello, 16/05/2006: Agrego los siguientes campos
    private Long oidTerritorio;
    private String codMarca;
    
    

	public FuenteVentasRealAcumulada() {
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getCodigoSociedad() {
		return codigoSociedad;
	}

	public void setCodigoSociedad(String codigoSociedad) {
		this.codigoSociedad = codigoSociedad;
	}

	public String getCodigoAlmacen() {
		return codigoAlmacen;
	}

	public void setCodigoAlmacen(String codigoAlmacen) {
		this.codigoAlmacen = codigoAlmacen;
	}

	public String getCanalBPS() {
		return canalBPS;
	}

	public void setCanalBPS(String canalBPS) {
		this.canalBPS = canalBPS;
	}

	public String getCodigoZona() {
		return codigoZona;
	}

	public void setCodigoZona(String codigoZona) {
		this.codigoZona = codigoZona;
	}

	public String getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(String codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public Long getNumeroOrdenes() {
		return numeroOrdenes;
	}

	public void setNumeroOrdenes(Long numeroOrdenes) {
		this.numeroOrdenes = numeroOrdenes;
	}

	public Long getNumeroPedidos() {
		return numeroPedidos;
	}

	public void setNumeroPedidos(Long numeroPedidos) {
		this.numeroPedidos = numeroPedidos;
	}

	public Long getNumeroClientes() {
		return numeroClientes;
	}

	public void setNumeroClientes(Long numeroClientes) {
		this.numeroClientes = numeroClientes;
	}

	public Long getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(Long unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

	public BigDecimal getVentaNetaEstadisticable() {
		return ventaNetaEstadisticable;
	}

	public void setVentaNetaEstadisticable(BigDecimal ventaNetaEstadisticable) {
		this.ventaNetaEstadisticable = ventaNetaEstadisticable;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long marca) {
		this.marca = marca;
	}

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long periodo) {
		this.periodo = periodo;
	}

	public Long getActivasIniciales() {
		return activasIniciales;
	}

	public void setActivasIniciales(Long activasIniciales) {
		this.activasIniciales = activasIniciales;
	}

	public Long getActivasFinales() {
		return activasFinales;
	}

	public void setActivasFinales(Long activasFinales) {
		this.activasFinales = activasFinales;
	}

	public Long getIngresos() {
		return ingresos;
	}

	public void setIngresos(Long ingresos) {
		this.ingresos = ingresos;
	}

	public Long getEgresos() {
		return egresos;
	}

	public void setEgresos(Long egresos) {
		this.egresos = egresos;
	}

	public Long getReingresos() {
		return reingresos;
	}

	public void setReingresos(Long reingresos) {
		this.reingresos = reingresos;
	}

	public Long getRezonificadasRecibidas() {
		return rezonificadasRecibidas;
	}

	public void setRezonificadasRecibidas(Long rezonificadasRecibidas) {
		this.rezonificadasRecibidas = rezonificadasRecibidas;
	}

	public Long getRezonificadasEntregadas() {
		return rezonificadasEntregadas;
	}

	public void setRezonificadasEntregadas(Long rezonificadasEntregadas) {
		this.rezonificadasEntregadas = rezonificadasEntregadas;
	}

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long canal) {
        this.canal = canal;
    }

    public Long getZona() {
        return zona;
    }

    public void setZona(Long zona) {
        this.zona = zona;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long region) {
        this.region = region;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long pais) {
        this.pais = pais;
    }

    public Long getTipoSolicitudPais() {
        return tipoSolicitudPais;
    }

    public void setTipoSolicitudPais(Long tipoSolicitudPais) {
        this.tipoSolicitudPais = tipoSolicitudPais;
    }

    public Long getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Long almacen) {
        this.almacen = almacen;
    }

    public Long getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Long tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Long getSociedad() {
        return sociedad;
    }

    public void setSociedad(Long sociedad) {
        this.sociedad = sociedad;
    }

    // SC-SAB-INT-001-2 - dmorello, 12/05/2006: Se quita este atributo
    /*
    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }*/

    public String getTerritorio() {
        return territorio;
    }

    public void setTerritorio(String territorio) {
        this.territorio = territorio;
    }
    
    public String toString() {
    
        StringBuffer sb = new StringBuffer();
        sb.append("FuenteVentasRealAcumulada:");
        sb.append("\ncodigoPais:");
        sb.append(this.getCodigoPais() != null? this.getCodigoPais() : "null");
        sb.append("\ncodigoSociedad:");
        sb.append(this.getCodigoSociedad() != null? this.getCodigoSociedad() : "null");
        sb.append("\ncodigoAlmacen:");
        sb.append(this.getCodigoAlmacen() != null? this.getCodigoAlmacen() : "null");
        sb.append("\ncanalBPS:");
        sb.append(this.getCanalBPS() != null? this.getCanalBPS() : "null");
        sb.append("\ncodigoZona:");
        sb.append(this.getCodigoZona() != null? this.getCodigoZona() : "null");
        sb.append("\ncodigoRegion:");
        sb.append(this.getCodigoRegion() != null? this.getCodigoRegion() : "null");
        sb.append("\nnumeroOrdenes:");
        sb.append(this.getNumeroOrdenes() != null? this.getNumeroOrdenes().toString() : "null");
        sb.append("\nnumeroPedidos:");
        sb.append(this.getNumeroPedidos() != null? this.getNumeroPedidos().toString() : "null");
        sb.append("\nnumeroClientes:");
        sb.append(this.getNumeroClientes() != null? this.getNumeroClientes().toString() : "null");
        sb.append("\nunidadesVendidas:");
        sb.append(this.getUnidadesVendidas() != null? this.getUnidadesVendidas().toString() : "null");
        sb.append("\nventaNetaEstadisticable:");
        sb.append(this.getVentaNetaEstadisticable() != null? this.getVentaNetaEstadisticable().toString() : "null");
        sb.append("\nfechaCierre:");
        sb.append(this.getFechaCierre() != null? this.getFechaCierre().toString() : "null");
        sb.append("\nmarca:");
        sb.append(this.getMarca() != null? this.getMarca().toString() : "null");
        sb.append("\nperiodo:");
        sb.append(this.getPeriodo() != null? this.getPeriodo().toString() : "null");
        sb.append("\nactivasIniciales:");
        sb.append(this.getActivasIniciales() != null? this.getActivasIniciales().toString() : "null");
        sb.append("\nactivasFinales:");
        sb.append(this.getActivasFinales() != null? this.getActivasFinales().toString() : "null");
        sb.append("\ningresos:");
        sb.append(this.getIngresos() != null? this.getIngresos().toString() : "null");
        sb.append("\negresos:");
        sb.append(this.getEgresos() != null? this.getEgresos().toString() : "null");
        sb.append("\nreingresos:");
        sb.append(this.getReingresos() != null? this.getReingresos().toString() : "null");
        sb.append("\nrezonificadasRecibidas:");
        sb.append(this.getRezonificadasRecibidas() != null? this.getRezonificadasRecibidas().toString() : "null");
        sb.append("\nrezonificadasEntregadas:");
        sb.append(this.getRezonificadasEntregadas() != null? this.getRezonificadasEntregadas().toString() : "null");
        sb.append("\ncanal:");
        sb.append(this.getCanal() != null? this.getCanal().toString() : "null");
        sb.append("\nzona:");
        sb.append(this.getZona() != null? this.getZona().toString() : "null");
        sb.append("\nregion:");
        sb.append(this.getRegion() != null? this.getRegion().toString() : "null");
        sb.append("\npais:");
        sb.append(this.getPais() != null? this.getPais().toString() : "null");
        sb.append("\ntipoSolicitudPais:");
        sb.append(this.getTipoSolicitudPais() != null? this.getTipoSolicitudPais().toString() : "null");
        sb.append("\nalmacen:");
        sb.append(this.getAlmacen() != null? this.getAlmacen().toString() : "null");
        sb.append("\ntipoCliente:");
        sb.append(this.getTipoCliente() != null? this.getTipoCliente().toString() : "null");
        sb.append("\nsociedad:");
        sb.append(this.getSociedad() != null? this.getSociedad().toString() : "null");
        //sb.append("\nmarcaProducto:");
        //sb.append(this.getMarcaProducto() != null? this.getMarcaProducto() : "null");
        sb.append("\nterritorio:");
        sb.append(this.getTerritorio() != null? this.getTerritorio() : "null");        
        sb.append("\ncodMarca:");
        sb.append(this.getCodMarca() != null? this.getCodMarca() : "null");
        return sb.toString();
    }

    // 23122 - dmorello, 16/05/2006: Se agrega el campo territorio
    public Long getOidTerritorio() 
    {
        return oidTerritorio;
    }
    
    public void setOidTerritorio(Long oidTerritorio) 
    {
        this.oidTerritorio = oidTerritorio;
    }
    
    // 23122 - dmorello, 16/05/2006: Se agrega el campo marca
    public String getCodMarca()
    {
        return codMarca;
    }

    public void setCodMarca(String codMarca)
    {
        this.codMarca = codMarca;
    }
}