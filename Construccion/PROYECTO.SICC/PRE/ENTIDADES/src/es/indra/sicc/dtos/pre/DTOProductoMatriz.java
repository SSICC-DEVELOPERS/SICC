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

import java.math.BigDecimal;

public class DTOProductoMatriz extends DTOAuditableSICC  {

  private Long oidMarca;
  private Long oidCanal;
  private Long oidPeriodo;
  private Long oidPeriodoFin;
  private Long oidSAP;
  private Long oidCicloVida;
  private Long oidTipoOferta;
  private Long oidFormaPago;
  private BigDecimal precioCatalogo;
  private BigDecimal precioContable;
  private Long oidEstrategia;
  private Long oidAcceso;
  private Long oidSubacceso;
  private String codigoVenta;
    private Long oidCatalogo;
    
  // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
  private Long oidCondicionPromocion;

  public DTOProductoMatriz() {
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long newOidMarca) {
    oidMarca = newOidMarca;
  }

  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long newOidCanal) {
    oidCanal = newOidCanal;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long newOidPeriodo) {
    oidPeriodo = newOidPeriodo;
  }

  public Long getOidPeriodoFin() {
    return oidPeriodoFin;
  }

  public void setOidPeriodoFin(Long newOidPeriodoFin) {
    oidPeriodoFin = newOidPeriodoFin;
  }

  public Long getOidSAP() {
    return oidSAP;
  }

  public void setOidSAP(Long newOidSAP) {
    oidSAP = newOidSAP;
  }

  public Long getOidCicloVida() {
    return oidCicloVida;
  }

  public void setOidCicloVida(Long newOidCicloVida) {
    oidCicloVida = newOidCicloVida;
  }

  public Long getOidTipoOferta() {
    return oidTipoOferta;
  }

  public void setOidTipoOferta(Long newOidTipoOferta) {
    oidTipoOferta = newOidTipoOferta;
  }

  public Long getOidFormaPago() {
    return oidFormaPago;
  }

  public void setOidFormaPago(Long newOidFormaPago) {
    oidFormaPago = newOidFormaPago;
  }

  public BigDecimal getPrecioCatalogo() {
    return precioCatalogo;
  }

  public void setPrecioCatalogo(BigDecimal newPrecioCatalogo) {
    precioCatalogo = newPrecioCatalogo;
  }

  public BigDecimal getPrecioContable() {
    return precioContable;
  }

  public void setPrecioContable(BigDecimal newPrecioContable) {
    precioContable = newPrecioContable;
  }

  public Long getOidEstrategia() {
    return oidEstrategia;
  }

  public void setOidEstrategia(Long newOidEstrategia) {
    oidEstrategia = newOidEstrategia;
  }

  public Long getOidAcceso() {
    return oidAcceso;
  }

  public void setOidAcceso(Long newOidAcceso) {
    oidAcceso = newOidAcceso;
  }

  public Long getOidSubacceso() {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long newOidSubacceso) {
    oidSubacceso = newOidSubacceso;
  }

  public String getCodigoVenta() {
    return codigoVenta;
  }

  public void setCodigoVenta(String newCodigoVenta) {
    codigoVenta = newCodigoVenta;
  }

    public Long getOidCatalogo()
    {
        return oidCatalogo;
    }

    public void setOidCatalogo(Long oidCatalogo)
    {
        this.oidCatalogo = oidCatalogo;
    }

    public void setOidCondicionPromocion(Long oidCondicionPromocion) {
        this.oidCondicionPromocion = oidCondicionPromocion;
    }

    public Long getOidCondicionPromocion() {
        return oidCondicionPromocion;
    }
}
