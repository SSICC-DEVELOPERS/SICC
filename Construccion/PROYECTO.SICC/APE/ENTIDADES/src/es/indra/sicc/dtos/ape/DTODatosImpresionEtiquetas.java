/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTODatosImpresionEtiquetas extends DTOBelcorp {
  private String apellido1;
  private String apellido2;
  private String nombre1;
  private String nombre2;
  private String codigoTerritorio;
  private Long numCaja;
  private String codPostal;
  
  // Cambio APE-04 - dmorello, 10/01/2008: Cambia tipo de String a Long
  private Long secuenciaCajaPTL;
  
  private String nombreVia;
  private String talla;
  private String codigoSeccion;
  
  //SCS, por inc.: BELC400000473, se cbia. a long
  private Long indChequeo;
  
  private String textoVariable;
  private String campania;
  private Date fecha;
  private String compania;
  private String telefono;
  private String cargo;
  private String numeroPrincipal;
  private Long numeroTotalCajas;
  private String region;
  private String zona;
  private String barrio;
  private String ciudad;
  private String departamento;
  private Integer longitudNumeroEtiqueta;
  private Long numConsolidado;
  private String codigoListaPicado; // Agregado eiraola 09/08/2007 Inc. BELC400000620 
  
  /* BELC400000224 - dmorello, 20/03/2007 */
  private Long nroSecuencia;
  
  // Cambio APE-04 - dmorello, 10/01/2008
  private String textoPrimerPedido;
  
  // Cambio 20090839 - dmorello, 03/09/2009
  private Boolean indImprimirDatosBasicosCliente;
  private String descripcionLineaArmado;
  private Date fechaFacturacion;
  

  public String getApellido1()
  {
    return apellido1;
  }

  public void setApellido1(String apellido1)
  {
    this.apellido1 = apellido1;
  }

  public String getApellido2()
  {
    return apellido2;
  }

  public void setApellido2(String apellido2)
  {
    this.apellido2 = apellido2;
  }

  public String getNombre1()
  {
    return nombre1;
  }

  public void setNombre1(String nombre1)
  {
    this.nombre1 = nombre1;
  }

  public String getNombre2()
  {
    return nombre2;
  }

  public void setNombre2(String nombre2)
  {
    this.nombre2 = nombre2;
  }

  public String getCodigoTerritorio()
  {
    return codigoTerritorio;
  }

  public void setCodigoTerritorio(String codigoTerritorio)
  {
    this.codigoTerritorio = codigoTerritorio;
  }

  public Long getNumCaja()
  {
    return numCaja;
  }

  public void setNumCaja(Long caja)
  {
    this.numCaja = caja;
  }

  public String getCodPostal()
  {
    return codPostal;
  }

  public void setCodPostal(String codPostal)
  {
    this.codPostal = codPostal;
  }

  public Long getSecuenciaCajaPTL()
  {
    return secuenciaCajaPTL;
  }

  public void setSecuenciaCajaPTL(Long secuenciaCajaPTL)
  {
    this.secuenciaCajaPTL = secuenciaCajaPTL;
  }

  public String getNombreVia()
  {
    return nombreVia;
  }

  public void setNombreVia(String nombreVia)
  {
    this.nombreVia = nombreVia;
  }

  public String getTalla()
  {
    return talla;
  }

  public void setTalla(String talla)
  {
    this.talla = talla;
  }

  public String getCodigoSeccion()
  {
    return codigoSeccion;
  }

  public void setCodigoSeccion(String seccion)
  {
    this.codigoSeccion = seccion;
  }

  public Long getIndChequeo()
  {
    return indChequeo;
  }

  public void setIndChequeo(Long indChequeo)
  {
    this.indChequeo = indChequeo;
  }

  public String getTextoVariable()
  {
    return textoVariable;
  }

  public void setTextoVariable(String textoVariable)
  {
    this.textoVariable = textoVariable;
  }

  public String getCampania()
  {
    return campania;
  }

  public void setCampania(String campania)
  {
    this.campania = campania;
  }

  public Date getFecha()
  {
    return fecha;
  }

  public void setFecha(Date fecha)
  {
    this.fecha = fecha;
  }

  public String getCompania()
  {
    return compania;
  }

  public void setCompania(String compania)
  {
    this.compania = compania;
  }

  public String getTelefono()
  {
    return telefono;
  }

  public void setTelefono(String telefono)
  {
    this.telefono = telefono;
  }

  public String getCargo()
  {
    return cargo;
  }

  public void setCargo(String cargo)
  {
    this.cargo = cargo;
  }

  public String getNumeroPrincipal()
  {
    return numeroPrincipal;
  }

  public void setNumeroPrincipal(String numeroPrincipal)
  {
    this.numeroPrincipal = numeroPrincipal;
  }

  public Long getNumeroTotalCajas()
  {
    return numeroTotalCajas;
  }

  public void setNumeroTotalCajas(Long numeroTotalCajas)
  {
    this.numeroTotalCajas = numeroTotalCajas;
  }

  public String getRegion()
  {
    return region;
  }

  public void setRegion(String region)
  {
    this.region = region;
  }

  public String getZona()
  {
    return zona;
  }

  public void setZona(String zona)
  {
    this.zona = zona;
  }

  public String getBarrio()
  {
    return barrio;
  }

  public void setBarrio(String barrio)
  {
    this.barrio = barrio;
  }

  public String getCiudad()
  {
    return ciudad;
  }

  public void setCiudad(String ciudad)
  {
    this.ciudad = ciudad;
  }

  public String getDepartamento()
  {
    return departamento;
  }

  public void setDepartamento(String departamento)
  {
    this.departamento = departamento;
  }

  public Integer getLongitudNumeroEtiqueta()
  {
    return longitudNumeroEtiqueta;
  }

  public void setLongitudNumeroEtiqueta(Integer longitudNumeroEtiqueta)
  {
    this.longitudNumeroEtiqueta = longitudNumeroEtiqueta;
  }

  public Long getNumConsolidado()
  {
    return numConsolidado;
  }

  public void setNumConsolidado(Long numConsolidado)
  {
    this.numConsolidado = numConsolidado;
  }

  public Long getNroSecuencia()
  {
    return nroSecuencia;
  }

  public void setNroSecuencia(Long nroSecuencia)
  {
    this.nroSecuencia = nroSecuencia;
  }

  public void setCodigoListaPicado(String codigoListaPicado)
  {
    this.codigoListaPicado = codigoListaPicado;
  }

  public String getCodigoListaPicado()
  {
    return codigoListaPicado;
  }

  public String getTextoPrimerPedido()
  {
    return textoPrimerPedido;
  }

  public void setTextoPrimerPedido(String textoPrimerPedido)
  {
    this.textoPrimerPedido = textoPrimerPedido;
  }

  public void setIndImprimirDatosBasicosCliente(Boolean indImprimirDatosBasicosCliente) {
    this.indImprimirDatosBasicosCliente = indImprimirDatosBasicosCliente;
  }

  public Boolean getIndImprimirDatosBasicosCliente() {
    return indImprimirDatosBasicosCliente;
  }

  public void setDescripcionLineaArmado(String descripcionLineaArmado) {
      this.descripcionLineaArmado = descripcionLineaArmado;
  }

  public String getDescripcionLineaArmado() {
      return descripcionLineaArmado;
  }

  public void setFechaFacturacion(Date fechaFacturacion) {
      this.fechaFacturacion = fechaFacturacion;
  }

  public Date getFechaFacturacion() {
      return fechaFacturacion;
  }
}
