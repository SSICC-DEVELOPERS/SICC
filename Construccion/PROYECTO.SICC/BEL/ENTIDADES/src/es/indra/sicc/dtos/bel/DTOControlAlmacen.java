/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 * DTO para el caso de uso de Controles de Almacen, hereda comportamiento
 * para paginado.
 * Sistema:       Belcorp
 * Modulo:        BEL - BelCenter
 * Componente:    DTOControlAlmacen
 * 
 * @author Emilio Iraola
 * @date 23/01/2006
 */
public class DTOControlAlmacen extends DTOSiccPaginacion {
    /* Atributos */
    private Long oidControlAlmacen; // PK - Not null
    private Long oidCanal;
    private Long oidAcceso;
    private Long oidSubacceso; // Not null
    private Long oidProducto; // Not null
    private Long oidAlmacen; // Not null
    private Long stockMinimo;
    private Long stockMaximo;
    private Long stockReposicion;
    private Character activado;
  private String codigoProducto;
  private String descripcionProducto;

    /* Constructores */
    public DTOControlAlmacen () {
    }
    
    /* Métodos Getters y Setters */
    public void setOidControlAlmacen(Long oidControlAlmacen) {
        this.oidControlAlmacen = oidControlAlmacen;
    }

    public Long getOidControlAlmacen() {
        return oidControlAlmacen;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidAcceso(Long oidAcceso) {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidAcceso() {
        return oidAcceso;
    }

    public void setOidSubacceso(Long oidSubacceso) {
        this.oidSubacceso = oidSubacceso;
    }

    public Long getOidSubacceso() {
        return oidSubacceso;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidAlmacen(Long oidAlmacen) {
        this.oidAlmacen = oidAlmacen;
    }

    public Long getOidAlmacen() {
        return oidAlmacen;
    }
    
    public void setStockMinimo(Long stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Long getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMaximo(Long stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public Long getStockMaximo() {
        return stockMaximo;
    }

    public void setStockReposicion(Long stockReposicion) {
        this.stockReposicion = stockReposicion;
    }

    public Long getStockReposicion() {
        return stockReposicion;
    }

    public void setActivado(Character activado) {
        this.activado = activado;
    }

    public Character getActivado() {
        return activado;
    }

  public String getCodigoProducto() {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto) {
    this.codigoProducto = codigoProducto;
  }

  public String getDescripcionProducto() {
    return descripcionProducto;
  }

  public void setDescripcionProducto(String descripcionProducto) {
    this.descripcionProducto = descripcionProducto;
  }
    
}