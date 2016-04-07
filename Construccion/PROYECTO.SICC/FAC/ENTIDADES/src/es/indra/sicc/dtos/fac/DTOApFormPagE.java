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
 
package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

import java.util.Date;

public class DTOApFormPagE extends DTOBelcorp{

	private BigDecimal importeFracLocal; 
	private BigDecimal importeFracDoc;  
	private Long oidFormaPago;     
	private Date fechaFacturacion;     
	private Long oidMarca;     
	private Long oidCanal;     
	private Long oidPeriodo;     
	private Long oidZona;   
  private BigDecimal redondeoLocal;
  private BigDecimal redondeoDocumento;

	public DTOApFormPagE() {
		super();
	}

	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(Date newFechaFacturacion) {
		fechaFacturacion = newFechaFacturacion;
	}

	public BigDecimal getImporteFracDoc() {
		return importeFracDoc;
	}

	public void setImporteFracDoc(BigDecimal newImporteFracDoc) {
		importeFracDoc = newImporteFracDoc;
	}

	public BigDecimal getImporteFracLocal() {
		return importeFracLocal;
	}

	public void setImporteFracLocal(BigDecimal newImporteFracLocal) {
		importeFracLocal = newImporteFracLocal;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public Long getOidFormaPago() {
		return oidFormaPago;
	}

	public void setOidFormaPago(Long newOidFormaPago) {
		oidFormaPago = newOidFormaPago;
	}

	public Long getOidMarca() {
		return oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		oidMarca = newOidMarca;
	}

	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long newOidPeriodo) {
		oidPeriodo = newOidPeriodo;
	}

	public Long getOidZona() {
		return oidZona;
	}

	public void setOidZona(Long newOidZona) {
		oidZona = newOidZona;
	}

  public BigDecimal getRedondeoLocal()
  {
    return redondeoLocal;
  }

  public void setRedondeoLocal(BigDecimal redondeoLocal)
  {
    this.redondeoLocal = redondeoLocal;
  }

  public BigDecimal getRedondeoDocumento()
  {
    return redondeoDocumento;
  }

  public void setRedondeoDocumento(BigDecimal redondeoDocumento)
  {
    this.redondeoDocumento = redondeoDocumento;
  }

}