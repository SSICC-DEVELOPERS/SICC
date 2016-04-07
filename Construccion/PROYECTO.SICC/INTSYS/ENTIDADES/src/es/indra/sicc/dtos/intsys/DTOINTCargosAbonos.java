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

public class DTOINTCargosAbonos extends DTOBelcorp implements Cloneable {
   
   public DTOINTCargosAbonos() {
      super();   
   }
   
   public Object clone() throws CloneNotSupportedException {
      DTOINTCargosAbonos dto = (DTOINTCargosAbonos)super.clone();
      return dto;
   }
   
   private String codigoPais;
   private Date fechaDocumento;
   private Date fechaValor;   
   private Long empresa;   
   private String codigoEmpresa;   
   private Long canal;   
   private String codigoCanal;   
   private Long acceso;   
   private String codigoAcceso;   
   private Long subacceso;   
   private String codigoSubacceso;   
   private Long proceso;   
   private String codigoProceso;   
   private Long subproceso;   
   private String codigoSubproceso;   
   private Long cuentaContable;   
   private String codigoCuentaContable;   
   private Long banco;   
   private String codigoBanco;   
   private Date fechaPagoBancos;   
   private String indicadorDebeHaber;   
   private BigDecimal importe;   
   private Long tipoAbonoSubprocesoDetalle;   
   private Long cuentaContableCuotaAnterior;   
   private Long cuentaContableCuotaNueva;   
   private String tipoCargoAbono;   
   private String descripcionCuentaCorriente;   
   private Long moneda;   
   private String codigoMoneda;   
   private Long oidCabecera; 

   public Long getAcceso() {
      return acceso;
   }

   public void setAcceso(Long acceso) {
      this.acceso = acceso;
   }

   public Long getBanco() {
      return banco;
   }

   public void setBanco(Long banco) {
      this.banco = banco;
   }

   public Long getCanal() {
      return canal;
   }

   public void setCanal(Long canal) {
      this.canal = canal;
   }

   public String getCodigoAcceso() {
      return codigoAcceso;
   }

   public void setCodigoAcceso(String codigoAcceso) {
      this.codigoAcceso = codigoAcceso;
   }

   public String getCodigoBanco() {
      return codigoBanco;
   }

   public void setCodigoBanco(String codigoBanco) {
      this.codigoBanco = codigoBanco;
   }

   public String getCodigoCanal() {
      return codigoCanal;
   }

   public void setCodigoCanal(String codigoCanal) {
      this.codigoCanal = codigoCanal;
   }

   public String getCodigoCuentaContable() {
      return codigoCuentaContable;
   }

   public void setCodigoCuentaContable(String codigoCuentaContable) {
      this.codigoCuentaContable = codigoCuentaContable;
   }

   public String getCodigoEmpresa() {
      return codigoEmpresa;
   }

   public void setCodigoEmpresa(String codigoEmpresa) {
      this.codigoEmpresa = codigoEmpresa;
   }

   public String getCodigoMoneda() {
      return codigoMoneda;
   }

   public void setCodigoMoneda(String codigoMoneda) {
      this.codigoMoneda = codigoMoneda;
   }

   public String getCodigoPais() {
      return codigoPais;
   }

   public void setCodigoPais(String codigoPais) {
      this.codigoPais = codigoPais;
   }

   public String getCodigoProceso() {
      return codigoProceso;
   }

   public void setCodigoProceso(String codigoProceso) {
      this.codigoProceso = codigoProceso;
   }

   public String getCodigoSubacceso() {
      return codigoSubacceso;
   }

   public void setCodigoSubacceso(String codigoSubacceso) {
      this.codigoSubacceso = codigoSubacceso;
   }

   public String getCodigoSubproceso() {
      return codigoSubproceso;
   }

   public void setCodigoSubproceso(String codigoSubproceso) {
      this.codigoSubproceso = codigoSubproceso;
   }

   public Long getCuentaContable() {
      return cuentaContable;
   }

   public void setCuentaContable(Long cuentaContable) {
      this.cuentaContable = cuentaContable;
   }

   public Long getCuentaContableCuotaAnterior() {
      return cuentaContableCuotaAnterior;
   }

   public void setCuentaContableCuotaAnterior(Long cuentaContableCuotaAnterior) {
      this.cuentaContableCuotaAnterior = cuentaContableCuotaAnterior;
   }

   public Long getCuentaContableCuotaNueva() {
      return cuentaContableCuotaNueva;
   }

   public void setCuentaContableCuotaNueva(Long cuentaContableCuotaNueva) {
      this.cuentaContableCuotaNueva = cuentaContableCuotaNueva;
   }

   public String getDescripcionCuentaCorriente() {
      return descripcionCuentaCorriente;
   }

   public void setDescripcionCuentaCorriente(String descripcionCuentaCorriente) {
      this.descripcionCuentaCorriente = descripcionCuentaCorriente;
   }

   public Long getEmpresa() {
      return empresa;
   }

   public void setEmpresa(Long empresa) {
      this.empresa = empresa;
   }

   public Date getFechaDocumento() {
      return fechaDocumento;
   }

   public void setFechaDocumento(Date fechaDocumento) {
      this.fechaDocumento = fechaDocumento;
   }

   public Date getFechaPagoBancos() {
      return fechaPagoBancos;
   }

   public void setFechaPagoBancos(Date fechaPagoBancos) {
      this.fechaPagoBancos = fechaPagoBancos;
   }

   public Date getFechaValor() {
      return fechaValor;
   }

   public void setFechaValor(Date fechaValor) {
      this.fechaValor = fechaValor;
   }

   public BigDecimal getImporte() {
      return importe;
   }

   public void setImporte(BigDecimal importe) {
      this.importe = importe;
   }

   public String getIndicadorDebeHaber() {
      return indicadorDebeHaber;
   }

   public void setIndicadorDebeHaber(String indicadorDebeHaber) {
      this.indicadorDebeHaber = indicadorDebeHaber;
   }

   public Long getMoneda() {
      return moneda;
   }

   public void setMoneda(Long moneda) {
      this.moneda = moneda;
   }

   public Long getOidCabecera() {
      return oidCabecera;
   }

   public void setOidCabecera(Long oidCabecera) {
      this.oidCabecera = oidCabecera;
   }

   public Long getProceso() {
      return proceso;
   }

   public void setProceso(Long proceso) {
      this.proceso = proceso;
   }

   public Long getSubacceso() {
      return subacceso;
   }

   public void setSubacceso(Long subacceso) {
      this.subacceso = subacceso;
   }

   public Long getSubproceso() {
      return subproceso;
   }

   public void setSubproceso(Long subproceso) {
      this.subproceso = subproceso;
   }

   public Long getTipoAbonoSubprocesoDetalle() {
      return tipoAbonoSubprocesoDetalle;
   }

   public void setTipoAbonoSubprocesoDetalle(Long tipoAbonoSubprocesoDetalle) {
      this.tipoAbonoSubprocesoDetalle = tipoAbonoSubprocesoDetalle;
   }

   public String getTipoCargoAbono() {
      return tipoCargoAbono;
   }

   public void setTipoCargoAbono(String tipoCargoAbono) {
      this.tipoCargoAbono = tipoCargoAbono;
   }
   
}