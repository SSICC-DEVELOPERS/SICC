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

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;



public class DTOProductoVenta extends DTOAuditableSICC {
   private java.lang.Long oidMatrizCodigoAlternativo;
   private java.lang.Long oidMatrizFacturacion;
   private java.lang.Long oidMatrizFacturacionAlternativo;
   private java.lang.String codigoVenta;
   private java.lang.String descripcion;
   private java.lang.Long oidPeriodo;
   private java.lang.String descripcionPeriodo;
   private java.lang.Long numeroOrden;
	 private Boolean emiteMensaje;
   private java.lang.Boolean indicadorAntesDespuesCuadre;
   private java.lang.Boolean indicadorRecuperadorAut;
  private ArrayList regiones;
  private ArrayList zonas;
  private Long tipoCliente;
  private Long subTipoCliente;
  private Long tipoClasificacion;
  private Long clasificacion;

  public void setOidMatrizCodigoAlternativo(java.lang.Long OidMatrizCodigoAlternativo) {

     this.oidMatrizCodigoAlternativo = OidMatrizCodigoAlternativo;

  }

  public java.lang.Long getOidMatrizCodigoAlternativo() {

     return this.oidMatrizCodigoAlternativo;

  }

  public void setOidMatrizFacturacion(java.lang.Long OidMatrizFacturacion) {

     this.oidMatrizFacturacion = OidMatrizFacturacion;

  }

  public java.lang.Long getOidMatrizFacturacion() {

     return this.oidMatrizFacturacion;

  }

  public void setOidMatrizFacturacionAlternativo(java.lang.Long OidMatrizFacturacionAlternativo) {

     this.oidMatrizFacturacionAlternativo = OidMatrizFacturacionAlternativo;

  }

  public java.lang.Long getOidMatrizFacturacionAlternativo() {

     return this.oidMatrizFacturacionAlternativo;

  }

  public void setCodigoVenta(java.lang.String CodigoVenta) {

     this.codigoVenta = CodigoVenta;

  }

  public java.lang.String getCodigoVenta() {

     return this.codigoVenta;

  }

  public void setDescripcion(java.lang.String Descripcion) {

     this.descripcion = Descripcion;

  }

  public java.lang.String getDescripcion() {

     return this.descripcion;

  }

  public void setOidPeriodo(java.lang.Long OidPeriodo) {

     this.oidPeriodo = OidPeriodo;

  }

  public java.lang.Long getOidPeriodo() {

     return this.oidPeriodo;

  }

  public void setDescripcionPeriodo(java.lang.String DescripcionPeriodo) {

     this.descripcionPeriodo = DescripcionPeriodo;

  }

  public java.lang.String getDescripcionPeriodo() {

     return this.descripcionPeriodo;

  }

  public void setNumeroOrden(java.lang.Long NumeroOrden) {

     this.numeroOrden = NumeroOrden;

  }

  public java.lang.Long getNumeroOrden() {

     return this.numeroOrden;

  }

  public void setEmiteMensaje(java.lang.Boolean EmiteMensaje) {

     this.emiteMensaje = EmiteMensaje;

  }

  public java.lang.Boolean getEmiteMensaje() {

     return this.emiteMensaje;

  }

  public void setIndicadorAntesDespuesCuadre(java.lang.Boolean IndicadorAntesDespuesCuadre) {

     this.indicadorAntesDespuesCuadre = IndicadorAntesDespuesCuadre;

  }

  public java.lang.Boolean getIndicadorAntesDespuesCuadre() {

     return this.indicadorAntesDespuesCuadre;

  }



	public Boolean getIndicadorRecuperadorAut() {
		return indicadorRecuperadorAut;
	}

	public void setIndicadorRecuperadorAut(Boolean newIndicadorRecuperadorAut) {
		indicadorRecuperadorAut = newIndicadorRecuperadorAut;
	}

	public Boolean isIndicadorRecuperadorAut() {
		return indicadorRecuperadorAut;
	}

  public ArrayList getRegiones()
  {
    return regiones;
  }

  public void setRegiones(ArrayList regiones)
  {
    this.regiones = regiones;
  }

  public ArrayList getZonas()
  {
    return zonas;
  }

  public void setZonas(ArrayList zonas)
  {
    this.zonas = zonas;
  }

  public Long getTipoCliente()
  {
    return tipoCliente;
  }

  public void setTipoCliente(Long tipoCliente)
  {
    this.tipoCliente = tipoCliente;
  }

  public Long getSubTipoCliente()
  {
    return subTipoCliente;
  }

  public void setSubTipoCliente(Long subTipoCliente)
  {
    this.subTipoCliente = subTipoCliente;
  }

  public Long getTipoClasificacion()
  {
    return tipoClasificacion;
  }

  public void setTipoClasificacion(Long tipoClasificacion)
  {
    this.tipoClasificacion = tipoClasificacion;
  }

  public Long getClasificacion()
  {
    return clasificacion;
  }

  public void setClasificacion(Long clasificacion)
  {
    this.clasificacion = clasificacion;
  }

/*	public Boolean isVEmiteMensaje() {
		return vEmiteMensaje;
	}

	public void setVEmiteMensaje(Boolean newVEmiteMensaje) {
		vEmiteMensaje = newVEmiteMensaje;
	}*/

}