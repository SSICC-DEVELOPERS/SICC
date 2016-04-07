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
import java.util.Vector;
/**
 * 
 * pperanzola - 12/10/2005 - se modifica segun SICC-DMCO-PRE_MAE_INT-GCC-001
 */

public class DTOProducto extends DTOAuditableSICC 
{
  private Long oid;
  private String codigoSAP;
  private String descripcionSAP;
  private String atributo1;
  private String atributo2;
  private String atributo3;
  private BigDecimal precioCatalogo;
  private Integer paginaCatalogo;
  private Integer posicionPagina;
  private Boolean digitable;
  private Boolean imprimible;
  private Integer factorRepeticion;
  private Integer unidadesEstimadas;
  private BigDecimal ventaNetaEstimada;
  private BigDecimal precioPosicionamiento;
  private BigDecimal costeEstandar;
  private Long oidCatalogo;
  private Long oidCondicionPromocion;
  private Long oidTipoOferta;
  private String descripcionTipoOferta;
  private Long oidCicloVida;
  private String descripcionCicloVida;
  private String centro;
  private String textoBreve;
  private String descripcionCorta;
  ///*[1]
  private Long programaFidelizacion;
  private Long variantes;
  private Integer puntajeFijo;
  private String tipoOperacion;
  //*/[1]

  //  Agregado por HRCS - Fecha 15/03/2007 - Incidencia SiCC 20070106
  private Integer secuencial;
  private Vector rangosPrecios;
    
  public DTOProducto()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long newOid)
  {
    oid = newOid;
  }

  public String getCodigoSAP()
  {
    return codigoSAP;
  }

  public void setCodigoSAP(String newCodigoSAP)
  {
    codigoSAP = newCodigoSAP;
  }

  public String getDescripcionSAP()
  {
    return descripcionSAP;
  }

  public void setDescripcionSAP(String newDescripcionSAP)
  {
    descripcionSAP = newDescripcionSAP;
  }

  public String getAtributo1()
  {
    return atributo1;
  }

  public void setAtributo1(String newAtributo1)
  {
    atributo1 = newAtributo1;
  }

  public String getAtributo2()
  {
    return atributo2;
  }

  public void setAtributo2(String newAtributo2)
  {
    atributo2 = newAtributo2;
  }

  public String getAtributo3()
  {
    return atributo3;
  }

  public void setAtributo3(String newAtributo3)
  {
    atributo3 = newAtributo3;
  }

  public BigDecimal getPrecioCatalogo()
  {
    return precioCatalogo;
  }

  public void setPrecioCatalogo(BigDecimal newPrecioCatalogo)
  {
    precioCatalogo = newPrecioCatalogo;
  }

  public Integer getPaginaCatalogo()
  {
    return paginaCatalogo;
  }

  public void setPaginaCatalogo(Integer newPaginaCatalogo)
  {
    paginaCatalogo = newPaginaCatalogo;
  }

  public Integer getPosicionPagina()
  {
    return posicionPagina;
  }

  public void setPosicionPagina(Integer newPosicionPagina)
  {
    posicionPagina = newPosicionPagina;
  }

  public Boolean getDigitable()
  {
    return digitable;
  }

  public void setDigitable(Boolean newDigitable)
  {
    digitable = newDigitable;
  }

  public Boolean getImprimible()
  {
    return imprimible;
  }

  public void setImprimible(Boolean newImprimible)
  {
    imprimible = newImprimible;
  }

  public Integer getFactorRepeticion()
  {
    return factorRepeticion;
  }

  public void setFactorRepeticion(Integer newFactorRepeticion)
  {
    factorRepeticion = newFactorRepeticion;
  }

  public Integer getUnidadesEstimadas()
  {
    return unidadesEstimadas;
  }

  public void setUnidadesEstimadas(Integer newUnidadesEstimadas)
  {
    unidadesEstimadas = newUnidadesEstimadas;
  }

  public BigDecimal getVentaNetaEstimada()
  {
    return ventaNetaEstimada;
  }

  public void setVentaNetaEstimada(BigDecimal newVentaNetaEstimada)
  {
    ventaNetaEstimada = newVentaNetaEstimada;
  }

  public BigDecimal getPrecioPosicionamiento()
  {
    return precioPosicionamiento;
  }

  public void setPrecioPosicionamiento(BigDecimal newPrecioPosicionamiento)
  {
    precioPosicionamiento = newPrecioPosicionamiento;
  }

  public BigDecimal getCosteEstandar()
  {
    return costeEstandar;
  }

  public void setCosteEstandar(BigDecimal newCosteEstandar)
  {
    costeEstandar = newCosteEstandar;
  }

  public Long getOidCatalogo()
  {
    return oidCatalogo;
  }

  public void setOidCatalogo(Long newOidCatalogo)
  {
    oidCatalogo = newOidCatalogo;
  }

  public Long getOidCondicionPromocion()
  {
    return oidCondicionPromocion;
  }

  public void setOidCondicionPromocion(Long newOidCondicionPromocion)
  {
    oidCondicionPromocion = newOidCondicionPromocion;
  }

  public Long getOidTipoOferta()
  {
    return oidTipoOferta;
  }

  public void setOidTipoOferta(Long newOidTipoOferta)
  {
    oidTipoOferta = newOidTipoOferta;
  }

  public String getDescripcionTipoOferta()
  {
    return descripcionTipoOferta;
  }

  public void setDescripcionTipoOferta(String newDescripcionTipoOferta)
  {
    descripcionTipoOferta = newDescripcionTipoOferta;
  }

  public Long getOidCicloVida()
  {
    return oidCicloVida;
  }

  public void setOidCicloVida(Long newOidCicloVida)
  {
    oidCicloVida = newOidCicloVida;
  }

  public String getDescripcionCicloVida()
  {
    return descripcionCicloVida;
  }

  public void setDescripcionCicloVida(String newDescripcionCicloVida)
  {
    descripcionCicloVida = newDescripcionCicloVida;
  }

  public String getCentro()
  {
    return centro;
  }

  public void setCentro(String newCentro)
  {
    centro = newCentro;
  }

  public String getTextoBreve()
  {
    return textoBreve;
  }

  public void setTextoBreve(String newTextoBreve)
  {
    textoBreve = newTextoBreve;
  }

  public String getDescripcionCorta() {
    return descripcionCorta;
  }

  public void setDescripcionCorta(String newDescripcionCorta) {
    descripcionCorta = newDescripcionCorta;
  }
  
  ///*[1]
  public Long getProgramaFidelizacion() {
        return programaFidelizacion;
  }

  public void setProgramaFidelizacion(Long programaFidelizacion){
        this.programaFidelizacion = programaFidelizacion;
  }

  public Long getVariantes()  {
        return variantes;
  }

  public void setVariantes(Long variantes) {
        this.variantes = variantes;
  }

  public Integer getPuntajeFijo() {
        return puntajeFijo;
  }

  public void setPuntajeFijo(Integer puntajeFijo) {
        this.puntajeFijo = puntajeFijo;
  }

  public String getTipoOperacion() {
        return tipoOperacion;
  }

  public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
  }
  //*/[1]

    public void setSecuencial(Integer secuencial) {
        this.secuencial = secuencial;
    }

    public Integer getSecuencial() {
        return secuencial;
    }

  public Vector getRangosPrecios() {
    return rangosPrecios;
  }

  public void setRangosPrecios(Vector rangosPrecios) {
    this.rangosPrecios = rangosPrecios;
  }
}