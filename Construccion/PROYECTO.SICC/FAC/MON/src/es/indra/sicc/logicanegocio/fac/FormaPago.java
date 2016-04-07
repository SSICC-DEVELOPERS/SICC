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
 
package es.indra.sicc.logicanegocio.fac;

import java.math.BigDecimal;

public class FormaPago  {

	private Long oidFormaPago;   
	private BigDecimal importeLocal;   
	private BigDecimal importeDoc;
  private BigDecimal redondeoLocal;
  private BigDecimal redondeoDocumento;

	public FormaPago() {
	
	}

	public BigDecimal getImporteDoc() {
		return importeDoc;
	}

	public void setImporteDoc(BigDecimal newImporteDoc) {
		importeDoc = newImporteDoc;
	}

	public BigDecimal getImporteLocal() {
		return importeLocal;
	}

	public void setImporteLocal(BigDecimal newImporteLocal) {
		importeLocal = newImporteLocal;
	}

	public Long getOidFormaPago() {
		return oidFormaPago;
	}

	public void setOidFormaPago(Long newOidFormaPago) {
		oidFormaPago = newOidFormaPago;
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