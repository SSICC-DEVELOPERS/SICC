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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarMatrices extends DTOSiccPaginacion {

 private Long oidCabeceraMF;
 private String codigoVenta;
 private String descripcionProducto;
 
   public DTOEBuscarMatrices() {
   }

   public void setOidCabeceraMF(Long oidCabeceraMF)
  {
    this.oidCabeceraMF = oidCabeceraMF;
  }

  public Long getOidCabeceraMF ()
  {
    return this.oidCabeceraMF;
  }

  public void setCodigoVenta(String codigoVenta)
 {
		this.codigoVenta = codigoVenta;
  }

  public String getCodigoVenta()
	{
			return this.codigoVenta;
   }

	public String getDescripcionProducto()
	{
		return this.descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto)
	{
		this.descripcionProducto = descripcionProducto;
	}
}