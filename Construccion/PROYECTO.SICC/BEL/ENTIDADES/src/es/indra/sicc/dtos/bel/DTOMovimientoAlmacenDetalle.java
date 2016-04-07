/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.bel;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
public class DTOMovimientoAlmacenDetalle extends DTOBelcorp  {
	private String numeroMovimiento;
	private Long oidTipoMovimientoAlmacen;
	private Long oidCanal;
	private Long oidAcceso;
	private Long oidSubacceso;
	private Long oidAlmacenSalida;
	private Long oidAlmacenEntrada;
	private Long oidProducto;
	private Long cantidad;
	private BigDecimal precioVentaNeto;
	private BigDecimal precioContable;
	private Integer numeroPosicionReferencia;
	private Long numeroDocumentoReferencia;
	private String operacion;
	private Boolean movimientoOk;
	private Long oid; //BELC300006139 
	private Long oidMovimientoCabecera; //BELC300006139 
	private Integer numeroLinea; //BELC300006139 
	private Long oidTipoOferta; //BELC300008595
    private String observaciones;//Añadido despues
    private Long numeroLoteSAP;
    private Long oidTipoPosicion;
    private Long oidSubtipoPosicion;
  private String codigoVenta;
    
    public Long getOidTipoPosicion() {
        return this.oidTipoPosicion;
    }
    
    public void setOidTipoPosicion(Long newOidTipoPosicion) {
        this.oidTipoPosicion = newOidTipoPosicion;        
    }
    
    public Long getOidSubtipoPosicion() {
        return this.oidSubtipoPosicion;
    }
    
    public void setOidSubtipoPosicion(Long newOidSubtipoPosicion) {
        this.oidSubtipoPosicion = newOidSubtipoPosicion;
    }

	public Long getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Long newCantidad) {
		this.cantidad = newCantidad;
	}

	public Boolean getMovimientoOk() {
		return this.movimientoOk;
	}

	public void setMovimientoOk(Boolean newMovimientoOk) {
		this.movimientoOk = newMovimientoOk;
	}

	public Long getNumeroDocumentoReferencia() {
		return this.numeroDocumentoReferencia;
	}

	public void setNumeroDocumentoReferencia(Long newNumeroDocumentoReferencia) {
		this.numeroDocumentoReferencia = newNumeroDocumentoReferencia;
	}

	public String getNumeroMovimiento() {
		return this.numeroMovimiento;
	}

	public void setNumeroMovimiento(String newNumeroMovimiento) {
		this.numeroMovimiento = newNumeroMovimiento;
	}

	public Integer getNumeroPosicionReferencia() {
		return this.numeroPosicionReferencia;
	}

	public void setNumeroPosicionReferencia(Integer newNumeroPosicionReferencia) {
		this.numeroPosicionReferencia = newNumeroPosicionReferencia;
	}

	public Long getOidAcceso() {
		return this.oidAcceso;
	}

	public void setOidAcceso(Long newOidAcceso) {
		this.oidAcceso = newOidAcceso;
	}

	public Long getOidAlmacenEntrada() {
		return this.oidAlmacenEntrada;
	}

	public void setOidAlmacenEntrada(Long newOidAlmacenEntrada) {
		this.oidAlmacenEntrada = newOidAlmacenEntrada;
	}

	public Long getOidAlmacenSalida() {
		return this.oidAlmacenSalida;
	}

	public void setOidAlmacenSalida(Long newOidAlmacenSalida) {
		this.oidAlmacenSalida = newOidAlmacenSalida;
	}

	public Long getOidCanal() {
		return this.oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		this.oidCanal = newOidCanal;
	}

	public Long getOidProducto() {
		return this.oidProducto;
	}

	public void setOidProducto(Long newOidProducto) {
		this.oidProducto = newOidProducto;
	}

	public Long getOidSubacceso() {
		return this.oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		this.oidSubacceso = newOidSubacceso;
	}

	public Long getOidTipoMovimientoAlmacen() {
		return this.oidTipoMovimientoAlmacen;
	}

	public void setOidTipoMovimientoAlmacen(Long newOidTipoMovimientoAlmacen) {
		this.oidTipoMovimientoAlmacen = newOidTipoMovimientoAlmacen;
	}

	public String getOperacion() {
		return this.operacion;
	}

	public void setOperacion(String newOperacion) {
		this.operacion = newOperacion;
	}

	public BigDecimal getPrecioContable() {
		return this.precioContable;
	}

	public void setPrecioContable(BigDecimal newPrecioContable) {
		this.precioContable = newPrecioContable;
	}

	public BigDecimal getPrecioVentaNeto() {
		return this.precioVentaNeto;
	}

	public void setPrecioVentaNeto(BigDecimal newPrecioVentaNeto) {
		this.precioVentaNeto = newPrecioVentaNeto;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getOidMovimientoCabecera() {
		return oidMovimientoCabecera;
	}

	public void setOidMovimientoCabecera(Long newOidMovimientoCabecera) {
		oidMovimientoCabecera = newOidMovimientoCabecera;
	}

	public Integer getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(Integer newNumeroLinea) {
		numeroLinea = newNumeroLinea;
	}

	public Long getOidTipoOferta() {
		return oidTipoOferta;
	}

	public void setOidTipoOferta(Long newOidTipoOferta) {
		oidTipoOferta = newOidTipoOferta;
	}

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getNumeroLoteSAP()
    {
        return numeroLoteSAP;
    }

    public void setNumeroLoteSAP(Long numeroLoteSAP)
    {
        this.numeroLoteSAP = numeroLoteSAP;
    }

  // Agregado por ssantana, 27/09/2005, GCC-REC-003
  public String getCodigoVenta() {
    return codigoVenta;
  }

  public void setCodigoVenta(String codigoVenta) {
    this.codigoVenta = codigoVenta;
  }
  
  // Fin agregado por ssantana, 27/09/2005, GCC-REC-003

}