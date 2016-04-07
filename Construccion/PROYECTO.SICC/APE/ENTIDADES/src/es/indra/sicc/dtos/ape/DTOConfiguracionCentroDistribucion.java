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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Vector;


public class DTOConfiguracionCentroDistribucion extends DTOSiccPaginacion {
  private Long oidCentroDistribucion;
  private Long codigoCentroDistribucion;
  private String descripcion;
  private Vector attTraducible; // descripcion
  private String nivelOutsourcing;
  private String fueraPedidoPicado; // eiraola modifico el nombre para que coincida con el del DMCO (estaba fueraNivelPicado)
  
  // Gpons - Inc. BELC400000478: Cambio tipo de dato
  private Long ordenPedidoPicado;
  private Long ordenAscDesc;
  // Fin - Inc. BELC400000478
  
  private String textoChequeos;
  private String textoPrimerPedido;
  private Long longitudEtiqueta;
  private Boolean valorDefecto;
  //private String imprimirListaPicado; // ciglesias incidencia 355
  private Long agrupacionDefaultAFP;    // eiraola incidencia 417 (agrega campo)
  private Long impresionDatosbasicos; // cambio 20090839
  private Long oidOredenVisulaChequeo; // cambio 20090839
  private String oredenVisual; // cambio 20090839
  
  // sapaza -- Cambios para WCS y MUO -- 22/09/2010
  private Long agrupacionOlas;
  
  private String codigoOrdenPedidoPicado;
  private String codigoOrdenAsDesc;
  
  public DTOConfiguracionCentroDistribucion() {
  }


  public void setOidCentroDistribucion(Long oidCentroDistribucion) {
    this.oidCentroDistribucion = oidCentroDistribucion;
  }

  public Long getOidCentroDistribucion() {
    return oidCentroDistribucion;
  }

  public void setCodigoCentroDistribucion(Long codigoCentroDistribucion) {
    this.codigoCentroDistribucion = codigoCentroDistribucion;
  }

  public Long getCodigoCentroDistribucion() {
    return codigoCentroDistribucion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setAttTraducible(Vector attTraducible) {
    this.attTraducible = attTraducible;
  }

  public Vector getAttTraducible() {
    return attTraducible;
  }

  public void setNivelOutsourcing(String nivelOutsourcing) {
    this.nivelOutsourcing = nivelOutsourcing;
  }

  public String getNivelOutsourcing() {
    return nivelOutsourcing;
  }

/* ciglesias incidencia 355
  public void setImprimirListaPicado(String imprimirListaPicado)
  {
    this.imprimirListaPicado = imprimirListaPicado;
  }


  public String getImprimirListaPicado()
  {
    return imprimirListaPicado;
  }
*/

  public void setFueraPedidoPicado(String fueraPedidoPicado) {
    this.fueraPedidoPicado = fueraPedidoPicado;
  }

  public String getFueraPedidoPicado() {
    return fueraPedidoPicado;
  }

 // Gpons - Inc. BELC400000478: Cambio tipo de dato
  public void setOrdenPedidoPicado(Long ordenPedidoPicado) {
    this.ordenPedidoPicado = ordenPedidoPicado;
  }

  public Long getOrdenPedidoPicado() {
    return ordenPedidoPicado;
  }

  public void setOrdenAscDesc(Long ordenAscDesc) {
    this.ordenAscDesc = ordenAscDesc;
  }

  public Long getOrdenAscDesc() {
    return ordenAscDesc;
  }
 // Fin - Inc. BELC400000478.
 
  public void setTextoChequeos(String textoChequeos) {
    this.textoChequeos = textoChequeos;
  }

  public String getTextoChequeos() {
    return textoChequeos;
  }

  public void setTextoPrimerPedido(String textoPrimerPedido) {
    this.textoPrimerPedido = textoPrimerPedido;
  }

  public String getTextoPrimerPedido() {
    return textoPrimerPedido;
  }

  public void setLongitudEtiqueta(Long longitudEtiqueta) {
    this.longitudEtiqueta = longitudEtiqueta;
  }

  public Long getLongitudEtiqueta() {
    return longitudEtiqueta;
  }

  public void setValorDefecto(Boolean valorDefecto) {
    this.valorDefecto = valorDefecto;
  }

  public Boolean getValorDefecto() {
    return valorDefecto;
  }

  public void setAgrupacionDefaultAFP(Long agrupacionDefaultAFP) {
    this.agrupacionDefaultAFP = agrupacionDefaultAFP;
  }

  public Long getAgrupacionDefaultAFP() {
    return agrupacionDefaultAFP;
  }
   // Agregado por cambio 20090839
    public void setImpresionDatosbasicos(Long impresionDatosbasicos) {
      this.impresionDatosbasicos = impresionDatosbasicos;
    }

    public Long getImpresionDatosbasicos() {
      return impresionDatosbasicos;
    }
    public void setOidOredenVisulaChequeo(Long oidOredenVisulaChequeo) {
      this.oidOredenVisulaChequeo = oidOredenVisulaChequeo;
    }

    public Long getOidOredenVisulaChequeo() {
      return oidOredenVisulaChequeo;
    }
    
    public void setOredenVisual(String oredenVisual) {
      this.oredenVisual = oredenVisual;
    }

    public String getOredenVisual() {
      return oredenVisual;
    }

    public void setAgrupacionOlas(Long agrupacionOlas) {
        this.agrupacionOlas = agrupacionOlas;
    }

    public Long getAgrupacionOlas() {
        return agrupacionOlas;
    }

    public void setCodigoOrdenPedidoPicado(String codigoOrdenPedidoPicado) {
        this.codigoOrdenPedidoPicado = codigoOrdenPedidoPicado;
    }

    public String getCodigoOrdenPedidoPicado() {
        return codigoOrdenPedidoPicado;
    }

    public void setCodigoOrdenAsDesc(String codigoOrdenAsDesc) {
        this.codigoOrdenAsDesc = codigoOrdenAsDesc;
    }

    public String getCodigoOrdenAsDesc() {
        return codigoOrdenAsDesc;
    }
}
