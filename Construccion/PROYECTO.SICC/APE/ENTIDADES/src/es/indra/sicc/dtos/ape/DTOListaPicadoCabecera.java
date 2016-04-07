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
 */
package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class DTOListaPicadoCabecera extends DTOBelcorp  {
  private Long oid;
  private Long codigoListaPicado;
  
  //SCS, por inc.: BELC400000473, se cambia al dejar de existir el campo ind_cheq, ahora es: inre_oid_indi_revi
  private Long indicadorChequeo;
  
  private Long numeroTotalCajas;
  private String secuencia;
  private Boolean indicadorImpresion;
  private Date fechaCreacion;
  private BigDecimal volumen;
  private Long numeroUnidadesTotales;
  private Long agrupacion;
  private Boolean impreso;
  private Long secuenciaZonaRuta;
  private String textoChequeo;
  private String textoPrimerPedido;
  private Boolean indicadorInterfaceEnviada;
  private Timestamp fechaHoraInicioEmbalaje;
  private Timestamp fechaHoraFinEmbalaje;
  private String strFechaHoraFinEmbalaje;  
  private Long oidAgrupacion;
  private Long oidConfiguracionCD;
  private Long oidPeriodo;
  private Long oidSeccion;
  private Long oidSolicitudCAbecera;
  private Long oidZona;
  private DTOLineaArmado lineaArmado;
  private ArrayList detalles;
  private Timestamp fechaFacturacion;
  
  /* Agregado Gpons 04/05/2007 - APE-065*/
  private Long oidCliente;
  private Long oidRegion;
  /* Fin agregado Gpons 04/05/2007 - APE-065*/  
  
  /* Agregado Gpons 15/05/2007 - BELC400000441 */
  private String nombreFacturador;
  /* Fin agregado Gpons 15/05/2007 - BELC400000441 */  
  private String origenChequeo; //añadido por incidencia BELC400000459(APE)  

  public DTOListaPicadoCabecera() {
  }
  
  public String getStrFechaHoraFinEmbalaje() {
      return this.strFechaHoraFinEmbalaje;
  }
  
  public void setStrFechaHoraFinEmbalaje(String strFechaHoraFinEmbalaje) {
      this.strFechaHoraFinEmbalaje = strFechaHoraFinEmbalaje;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public Long getCodigoListaPicado() {
    return codigoListaPicado;
  }

  public void setCodigoListaPicado(Long codigoListaPicado) {
    this.codigoListaPicado = codigoListaPicado;
  }

  public Long getIndicadorChequeo() {
    return indicadorChequeo;
  }

  public void setIndicadorChequeo(Long indicadorChequeo) {
    this.indicadorChequeo = indicadorChequeo;
  }

  public Long getNumeroTotalCajas() {
    return numeroTotalCajas;
  }

  public void setNumeroTotalCajas(Long numeroTotalCajas) {
    this.numeroTotalCajas = numeroTotalCajas;
  }

  public String getSecuencia() {
    return secuencia;
  }

  public void setSecuencia(String secuencia) {
    this.secuencia = secuencia;
  }

  public Boolean getIndicadorImpresion() {
    return indicadorImpresion;
  }

  public void setIndicadorImpresion(Boolean indicadorImpresion) {
    this.indicadorImpresion = indicadorImpresion;
  }

  public Date getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(Date fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public BigDecimal getVolumen() {
    return volumen;
  }

  public void setVolumen(BigDecimal volumen) {
    this.volumen = volumen;
  }

  public Long getNumeroUnidadesTotales() {
    return numeroUnidadesTotales;
  }

  public void setNumeroUnidadesTotales(Long numeroUnidadesTotales) {
    this.numeroUnidadesTotales = numeroUnidadesTotales;
  }

  public Long getAgrupacion() {
    return agrupacion;
  }

  public void setAgrupacion(Long agrupacion) {
    this.agrupacion = agrupacion;
  }

  public Boolean getImpreso() {
    return impreso;
  }

  public void setImpreso(Boolean impreso) {
    this.impreso = impreso;
  }

  public Long getSecuenciaZonaRuta() {
    return secuenciaZonaRuta;
  }

  public void setSecuenciaZonaRuta(Long secuenciaZonaRuta) {
    this.secuenciaZonaRuta = secuenciaZonaRuta;
  }

  public String getTextoChequeo() {
    return textoChequeo;
  }

  public void setTextoChequeo(String textoChequeo) {
    this.textoChequeo = textoChequeo;
  }

  public String getTextoPrimerPedido() {
    return textoPrimerPedido;
  }

  public void setTextoPrimerPedido(String textoPrimerPedido) {
    this.textoPrimerPedido = textoPrimerPedido;
  }

  public Boolean getIndicadorInterfaceEnviada() {
    return indicadorInterfaceEnviada;
  }

  public void setIndicadorInterfaceEnviada(Boolean indicadorInterfaceEnviada) {
    this.indicadorInterfaceEnviada = indicadorInterfaceEnviada;
  }

  public Timestamp getFechaHoraInicioEmbalaje() {
    return fechaHoraInicioEmbalaje;
  }

  public void setFechaHoraInicioEmbalaje(Timestamp fechaHoraInicioEmbalaje) {
    this.fechaHoraInicioEmbalaje = fechaHoraInicioEmbalaje;
  }

  public Timestamp getFechaHoraFinEmbalaje() {
    return fechaHoraFinEmbalaje;
  }

  public void setFechaHoraFinEmbalaje(Timestamp fechaHoraFinEmbalaje) {
    this.fechaHoraFinEmbalaje = fechaHoraFinEmbalaje;
  }

  public Long getOidAgrupacion() {
    return oidAgrupacion;
  }

  public void setOidAgrupacion(Long oidAgrupacion) {
    this.oidAgrupacion = oidAgrupacion;
  }

  public Long getOidConfiguracionCD() {
    return oidConfiguracionCD;
  }

  public void setOidConfiguracionCD(Long oidConfiguracionCD) {
    this.oidConfiguracionCD = oidConfiguracionCD;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo) {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidSeccion() {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion) {
    this.oidSeccion = oidSeccion;
  }

  public Long getOidSolicitudCAbecera() {
    return oidSolicitudCAbecera;
  }

  public void setOidSolicitudCAbecera(Long oidSolicitudCAbecera) {
    this.oidSolicitudCAbecera = oidSolicitudCAbecera;
  }

  public Long getOidZona() {
    return oidZona;
  }

  public void setOidZona(Long oidZona) {
    this.oidZona = oidZona;
  }

  public DTOLineaArmado getLineaArmado() {
    return lineaArmado;
  }

  public void setLineaArmado(DTOLineaArmado lineaArmado) {
    this.lineaArmado = lineaArmado;
  }

  public ArrayList getDetalles() {
    return detalles;
  }

  public void setDetalles(ArrayList detalles) {
    this.detalles = detalles;
  }


  public void setFechaFacturacion(Timestamp fechaFacturacion) {
    this.fechaFacturacion = fechaFacturacion;
  }


  public Timestamp getFechaFacturacion() {
    return fechaFacturacion;
  }

  /* Agregado Gpons 04/05/2007 - APE-065*/
  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }

  public void setOidRegion(Long oidRegion) {
    this.oidRegion = oidRegion;
  }

  public Long getOidRegion() {
    return oidRegion;
  }
  /* Fin agregado Gpons 04/05/2007 - APE-065*/  

  /* Agregado Gpons 15/05/2007 - BELC400000441 */
  public void setNombreFacturador(String nombreFacturador) {
    this.nombreFacturador = nombreFacturador;
  }

  public String getNombreFacturador() {
    return nombreFacturador;
  }  
  /* Fin agregado Gpons 15/05/2007 - BELC400000441 */  
  
    public String getOrigenChequeo()
    {
        return origenChequeo;
    }

    public void setOrigenChequeo(String origenChequeo)
    {
        this.origenChequeo = origenChequeo;
    }  
}

