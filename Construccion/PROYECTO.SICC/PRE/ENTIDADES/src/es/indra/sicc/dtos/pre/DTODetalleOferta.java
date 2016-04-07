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
 * pperanzola - 20/10/2005 - [1] se modifica según el SICC-DMCO-PRE_MAE_INT-GCC-001
 * pperanzola - 26/10/2005 - [2] se modifica según PRE 2
 */
public class DTODetalleOferta extends DTOAuditableSICC 
{
  private Long oidDetalleOferta;
  private Integer lineaOferta;
  private Long oidSAP;
  private String codigoSAP;
  private String descripcion;
  private Integer unidadesEstimadas;
  private String origen;
  private Integer factorRepeticion;
  private String atributo1;
  private String atributo2;
  private String atributo3;
  private Boolean digitable;
  private Boolean impresionGP;
  private Integer posicionRanking;
  private Long oidFormaPago;
  private String descripcionFormaPago;
  private Integer numeroGrupo;
  private Boolean productoPrincipal;
  private BigDecimal precioCatalogo;
  private Integer posicionPagina;
  private BigDecimal precioPosicionamiento;
  private BigDecimal costeEstandar;
  private BigDecimal ventaNetaEstimada;
  private Long oidCatalogo;
  private Integer paginaCatalogo;
  private Long oidCondicionPromocion;
  private Long oidTipoOferta;
  private Long oidCicloVida;
  private Boolean matrizFacturacionGenerada;
  private Long oidGrupo;
  private String centro;
  private Boolean codigoVentaGenerado;
  private String codigoVenta;
  ///*[1]
  private String tipoOperacion;
  private Long programaFidelizacion;
  private Long variantes;
  private Integer puntajeFijo;
  private BigDecimal precioUnitario;
  //*/[1]
  
  //  Agregado por HRCS - Fecha 15/03/2007 - Incidencia SiCC 20070106
  private Integer secuencial;
  private Vector rangosPrecios;

  public DTODetalleOferta()  {
  }

  public Long getOidDetalleOferta()  {
    return oidDetalleOferta;
  }

  public void setOidDetalleOferta(Long newOidDetalleOferta)  {
    oidDetalleOferta = newOidDetalleOferta;
  }

  public Integer getLineaOferta()  {
    return lineaOferta;
  }

  public void setLineaOferta(Integer newLineaOferta)  {
    lineaOferta = newLineaOferta;
  }

  public Long getOidSAP()  {
    return oidSAP;
  }

  public void setOidSAP(Long newOidSAP)  {
    oidSAP = newOidSAP;
  }

  public String getCodigoSAP()  {
    return codigoSAP;
  }

  public void setCodigoSAP(String newCodigoSAP)  {
    codigoSAP = newCodigoSAP;
  }

  public String getDescripcion()  {
    return descripcion;
  }

  public void setDescripcion(String newDescripcion)  {
    descripcion = newDescripcion;
  }

  public Integer getUnidadesEstimadas()  {
    return unidadesEstimadas;
  }

  public void setUnidadesEstimadas(Integer newUnidadesEstimadas)  {
    unidadesEstimadas = newUnidadesEstimadas;
  }

  public String getOrigen()  {
    return origen;
  }

  public void setOrigen(String newOrigen)  {
    origen = newOrigen;
  }

  public Integer getFactorRepeticion()  {
    return factorRepeticion;
  }

  public void setFactorRepeticion(Integer newFactorRepeticion)  {
    factorRepeticion = newFactorRepeticion;
  }

  public String getAtributo1()  {
    return atributo1;
  }

  public void setAtributo1(String newAtributo1)  {
    atributo1 = newAtributo1;
  }

  public String getAtributo2()  {
    return atributo2;
  }

  public void setAtributo2(String newAtributo2)  {
    atributo2 = newAtributo2;
  }

  public String getAtributo3()  {
    return atributo3;
  }

  public void setAtributo3(String newAtributo3)  {
    atributo3 = newAtributo3;
  }

  public Boolean getDigitable()  {
    return digitable;
  }

  public void setDigitable(Boolean newDigitable)  {
    digitable = newDigitable;
  }

  public Boolean getImpresionGP()  {
    return impresionGP;
  }

  public void setImpresionGP(Boolean newImpresionGP)  {
    impresionGP = newImpresionGP;
  }

  public Integer getPosicionRanking()  {
    return posicionRanking;
  }

  public void setPosicionRanking(Integer newPosicionRanking)  {
    posicionRanking = newPosicionRanking;
  }

  public Long getOidFormaPago()  {
    return oidFormaPago;
  }

  public void setOidFormaPago(Long newOidFormaPago)  {
    oidFormaPago = newOidFormaPago;
  }

  public String getDescripcionFormaPago()  {
    return descripcionFormaPago;
  }

  public void setDescripcionFormaPago(String newDescripcionFormaPago)  {
    descripcionFormaPago = newDescripcionFormaPago;
  }

  public Integer getNumeroGrupo()  {
    return numeroGrupo;
  }

  public void setNumeroGrupo(Integer newNumeroGrupo)  {
    numeroGrupo = newNumeroGrupo;
  }

  public Boolean getProductoPrincipal()  {
    return productoPrincipal;
  }

  public void setProductoPrincipal(Boolean newProductoPrincipal)  {
    productoPrincipal = newProductoPrincipal;
  }

  public BigDecimal getPrecioCatalogo()  {
    return precioCatalogo;
  }

  public void setPrecioCatalogo(BigDecimal newPrecioCatalogo)  {
    precioCatalogo = newPrecioCatalogo;
  }

  public Integer getPosicionPagina()  {
    return posicionPagina;
  }

  public void setPosicionPagina(Integer newPosicionPagina)  {
    posicionPagina = newPosicionPagina;
  }

  public BigDecimal getPrecioPosicionamiento()  {
    return precioPosicionamiento;
  }

  public void setPrecioPosicionamiento(BigDecimal newPrecioPosicionamiento)  {
    precioPosicionamiento = newPrecioPosicionamiento;
  }

  public BigDecimal getCosteEstandar()  {
    return costeEstandar;
  }

  public void setCosteEstandar(BigDecimal newCosteEstandar)  {
    costeEstandar = newCosteEstandar;
  }

  public BigDecimal getVentaNetaEstimada()  {
    return ventaNetaEstimada;
  }

  public void setVentaNetaEstimada(BigDecimal newVentaNetaEstimada)  {
    ventaNetaEstimada = newVentaNetaEstimada;
  }

  public Long getOidCatalogo()  {
    return oidCatalogo;
  }

  public void setOidCatalogo(Long newOidCatalogo)  {
    oidCatalogo = newOidCatalogo;
  }

  public Integer getPaginaCatalogo()  {
    return paginaCatalogo;
  }

  public void setPaginaCatalogo(Integer newPaginaCatalogo)  {
    paginaCatalogo = newPaginaCatalogo;
  }

  public Long getOidCondicionPromocion()  {
    return oidCondicionPromocion;
  }

  public void setOidCondicionPromocion(Long newOidCondicionPromocion)  {
    oidCondicionPromocion = newOidCondicionPromocion;
  }

  public Long getOidTipoOferta()  {
    return oidTipoOferta;
  }

  public void setOidTipoOferta(Long newOidTipoOferta)  {
    oidTipoOferta = newOidTipoOferta;
  }

  public Long getOidCicloVida()  {
    return oidCicloVida;
  }

  public void setOidCicloVida(Long newOidCicloVida)  {
    oidCicloVida = newOidCicloVida;
  }

  public Boolean getMatrizFacturacionGenerada()  {
    return matrizFacturacionGenerada;
  }

  public void setMatrizFacturacionGenerada(Boolean newMatrizFacturacionGenerada)  {
    matrizFacturacionGenerada = newMatrizFacturacionGenerada;
  }

  public Long getOidGrupo() {
    return oidGrupo;
  }

  public void setOidGrupo(Long newOidGrupo) {
    oidGrupo = newOidGrupo;
  }

  public String getCentro() {
    return centro;
  }

  public void setCentro(String newCentro) {
    centro = newCentro;
  }

  public Boolean getCodigoVentaGenerado() {
    return codigoVentaGenerado;
  }

  public void setCodigoVentaGenerado(Boolean newCodigoVentaGenerado) {
    codigoVentaGenerado = newCodigoVentaGenerado;
  }

  public String getCodigoVenta() {
    return codigoVenta;
  }

  public void setCodigoVenta(String newCodigoVenta) {
    codigoVenta = newCodigoVenta;
  }
  
  ///*[1]
      public String getTipoOperacion()    {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion)    {
        this.tipoOperacion = tipoOperacion;
    }

    public Long getProgramaFidelizacion()    {
        return programaFidelizacion;
    }

    public void setProgramaFidelizacion(Long programaFidelizacion)    {
        this.programaFidelizacion = programaFidelizacion;
    }

    public Long getVariantes()    {
        return variantes;
    }

    public void setVariantes(Long variantes)    {
        this.variantes = variantes;
    }

    public Integer getPuntajeFijo()    {
        return puntajeFijo;
    }

    public void setPuntajeFijo(Integer puntajeFijo) {
        this.puntajeFijo = puntajeFijo;
    }
   //*/[1]
   ///*[2]
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario)    {
        this.precioUnitario = precioUnitario;
    }
   //*/[2]

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