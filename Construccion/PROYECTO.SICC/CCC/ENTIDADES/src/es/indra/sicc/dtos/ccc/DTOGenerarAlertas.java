/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOGenerarAlertas extends DTOBelcorp {
    private Long oidCliente;
    private Long numeroCupon;
    private Integer numeroFactuBoleta;
    private BigDecimal importePago;
    private Boolean saldoUnico;

    public DTOGenerarAlertas() {
        super();
    }

	public BigDecimal getImportePago() {
		return this.importePago;
	}

	public void setImportePago(BigDecimal newImportePago) {
		this.importePago = newImportePago;
	}

	public Long getNumeroCupon() {
		return this.numeroCupon;
	}

	public void setNumeroCupon(Long newNumeroCupon) {
		this.numeroCupon = newNumeroCupon;
	}

	public Integer getNumeroFactuBoleta() {
		return this.numeroFactuBoleta;
	}

	public void setNumeroFactuBoleta(Integer newNumeroFactuBoleta) {
		this.numeroFactuBoleta = newNumeroFactuBoleta;
	}

	public Long getOidCliente() {
		return this.oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		this.oidCliente = newOidCliente;
	}

	public Boolean getSaldoUnico() {
		return this.saldoUnico;
	}

	public void setSaldoUnico(Boolean newSaldoUnico) {
		this.saldoUnico = newSaldoUnico;
	}
}
