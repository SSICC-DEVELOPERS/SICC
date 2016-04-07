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

public class DTOProductoReemplazo extends DTOAuditableSICC {
    private String cvPrincipal;
    private Long oidPeriodo;
    private String cvReemplazo;
    private Boolean indAntesCuadre;
    private Boolean indMensaje;
    private BigDecimal precioCatalogoReemplazo;
    private Long oidDetalleOferta;
    private Long oidProducto;
    private Integer factorCuadre;
    private Long formaPago;

/*
 * enozigli 23/03/2007
 * se agrega oidOferta y tipoEstrategia por pedido de cambio relacionado con SICC 20070157 
 * no estaba contemplado en el DECU este campo
 */
    private Long oidOferta;
    private Long tipoEstrategia;
    
    // Agregado por SICC20070315 - Rafael Romero - 02/08/2007
    // Tambien se agregan metodos de acceso
    private BigDecimal precioPosicionamiento;
    // Fin agregado SICC20070315

    // sapaza -- PER-SiCC-2014-0580 -- 05/11/2014
    private Long catalogo;
    
    // sapaza -- PER-SiCC-2014-0580 -- 10/11/2014
    private Integer pagina;
     
  public DTOProductoReemplazo() {
  }

  public String getCvPrincipal() {
    return cvPrincipal;
  }

  public void setCvPrincipal(String newCvPrincipal) {
    cvPrincipal = newCvPrincipal;
  }

  public Long getOidPeriodo() {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long newOidPeriodo) {
    oidPeriodo = newOidPeriodo;
  }

  public String getCvReemplazo() {
    return cvReemplazo;
  }

  public void setCvReemplazo(String newCvReemplazo) {
    cvReemplazo = newCvReemplazo;
  }

  public Boolean getIndAntesCuadre() {
    return indAntesCuadre;
  }

  public void setIndAntesCuadre(Boolean newIndAntesCuadre) {
    indAntesCuadre = newIndAntesCuadre;
  }

  public Boolean getIndMensaje() {
    return indMensaje;
  }

  public void setIndMensaje(Boolean newIndMensaje) {
    indMensaje = newIndMensaje;
  }

  public BigDecimal getPrecioCatalogoReemplazo() {
    return precioCatalogoReemplazo;
  }

  public void setPrecioCatalogoReemplazo(BigDecimal newPrecioCatalogoReemplazo) {
    precioCatalogoReemplazo = newPrecioCatalogoReemplazo;
  }

    public Long getOidDetalleOferta()
    {
        return oidDetalleOferta;
    }

    public void setOidDetalleOferta(Long oidDetalleOferta)
    {
        this.oidDetalleOferta = oidDetalleOferta;
    }

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }

  public Integer getFactorCuadre()
  {
    return factorCuadre;
  }

  public void setFactorCuadre(Integer factorCuadre)
  {
    this.factorCuadre = factorCuadre;
  }

    public Long getOidOferta() {
        return oidOferta;
    }

    public void setOidOferta(Long oidOferta) {
        this.oidOferta = oidOferta;
    }

    public Long getTipoEstrategia() {
        return tipoEstrategia;
    }

    public void setTipoEstrategia(Long tipoEstrategia) {
        this.tipoEstrategia = tipoEstrategia;
    }

    public BigDecimal getPrecioPosicionamiento() {
        return precioPosicionamiento;
    }

    public void setPrecioPosicionamiento(BigDecimal precioPosicionamiento) {
        this.precioPosicionamiento = precioPosicionamiento;
    }

    public void setFormaPago(Long formaPago) {
        this.formaPago = formaPago;
    }

    public Long getFormaPago() {
        return formaPago;
    }

    public void setCatalogo(Long catalogo) {
        this.catalogo = catalogo;
    }

    public Long getCatalogo() {
        return catalogo;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getPagina() {
        return pagina;
    }
}
