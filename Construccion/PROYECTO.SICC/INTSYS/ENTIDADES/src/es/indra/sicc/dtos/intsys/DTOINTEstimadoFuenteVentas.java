/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/

package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.Date;

public class DTOINTEstimadoFuenteVentas extends DTOBelcorp {
	private Long canal;
	private Long empresa;
	private Long moneda;
	private Long periodo;
	private Long region;
	private Long zona;
	private Integer anioComercial;
	private Long activasIniciales;
	private Long activasFinales;
	private Long ingresos;
	private Long reingresos;
	private Long egresos;
    private Long rezonificadasRecibidas;
    private Long rezonificadasEntregadas;
    private Long numeroOrdenes;
    private Long numeroPedidos;
    private Long unidadesVendidas;
    private Long numeroClientes;
    
    //private Long ventaNetaEstadisticable;
    private BigDecimal ventaNetaEstadisticable;
    
    private Date fechaCierre;
    private Long centro;

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


	public DTOINTEstimadoFuenteVentas() {
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long canal) {
		this.canal = canal;
	}

	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long empresa) {
		this.empresa = empresa;
	}

	public Long getMoneda() {
		return moneda;
	}

	public void setMoneda(Long moneda) {
		this.moneda = moneda;
	}

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long periodo) {
		this.periodo = periodo;
	}

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long region) {
		this.region = region;
	}

	public Long getZona() {
		return zona;
	}

	public void setZona(Long zona) {
		this.zona = zona;
	}

	public Integer getAnioComercial() {
		return anioComercial;
	}

	public void setAnioComercial(Integer anioComercial) {
		this.anioComercial = anioComercial;
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

	public Long getReingresos() {
		return reingresos;
	}

	public void setReingresos(Long reingresos) {
		this.reingresos = reingresos;
	}

	public Long getEgresos() {
		return egresos;
	}

	public void setEgresos(Long egresos) {
		this.egresos = egresos;
	}

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Long getNumeroClientes() {
        return numeroClientes;
    }

    public void setNumeroClientes(Long numeroClientes) {
        this.numeroClientes = numeroClientes;
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

    public Long getRezonificadasEntregadas() {
        return rezonificadasEntregadas;
    }

    public void setRezonificadasEntregadas(Long rezonificadasEntregadas) {
        this.rezonificadasEntregadas = rezonificadasEntregadas;
    }

    public Long getRezonificadasRecibidas() {
        return rezonificadasRecibidas;
    }

    public void setRezonificadasRecibidas(Long rezonificadasRecibidas) {
        this.rezonificadasRecibidas = rezonificadasRecibidas;
    }

    public Long getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(Long unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public Long getCentro() {
        return centro;
    }

    public void setCentro(Long centro) {
        this.centro = centro;
    }


    public void setVentaNetaEstadisticable(BigDecimal ventaNetaEstadisticable) {
        this.ventaNetaEstadisticable = ventaNetaEstadisticable;
    }


    public BigDecimal getVentaNetaEstadisticable() {
        return ventaNetaEstadisticable;
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


}