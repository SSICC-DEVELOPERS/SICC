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
 *
 */ 
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSValidarCodigoVenta extends DTOAuditableSICC  {
    private Long oidDetalleOferta;
    private Long producto;
    private Boolean indicadorDigitableGP;
    private Long oidFormaPago;
    private Integer numPagCatalogo;
    private Long codigoCatalogo;  
    private String codigoVenta;

  public DTOSValidarCodigoVenta() {  }

  public Long getOidDetalleOferta() {
		return oidDetalleOferta;
	}

	public void setOidDetalleOferta(Long newOidDetalleOferta) {
		oidDetalleOferta = newOidDetalleOferta;
	}	  

  public Long getProducto() {
    return producto;
  }

  public void setProducto(Long newProducto) {
    producto = newProducto;
  }

  public Boolean getIndicadorDigitableGP() {
    return indicadorDigitableGP;
  }

  public void setIndicadorDigitableGP(Boolean newIndicadorDigitableGP) {
    indicadorDigitableGP = newIndicadorDigitableGP;
  }

  public Long getOidFormaPago() {
		return oidFormaPago;
	}

	public void setOidFormaPago(Long newOidFormaPago) {
		oidFormaPago = newOidFormaPago;
	}	  
 
    public Integer getNumPagCatalogo(){
        return numPagCatalogo;
    }
 
    public void setNumPagCatalogo(Integer newNumPagCatalogo){
        numPagCatalogo = newNumPagCatalogo;
    }

    public Long getCodigoCatalogo(){
        return codigoCatalogo;
    }

    public void setCodigoCatalogo(Long newCodigoCatalogo){
        codigoCatalogo = newCodigoCatalogo;
    }

    public String getCodigoVenta()
    {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta)
    {
        this.codigoVenta = codigoVenta;
    }
  
}