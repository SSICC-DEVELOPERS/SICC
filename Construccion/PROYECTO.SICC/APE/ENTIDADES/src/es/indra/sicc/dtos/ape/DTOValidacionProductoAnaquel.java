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

/**
 * Objeto creado para utilizar como estructura auxiliar de los elementos del ArrayList 
 * lstValidacionProductoAnaquel en APE:DTOMantenerAsignacionProductosAnaqueles
 * @author Emilio Iraola
 * @since  30/01/2006
 */
public class DTOValidacionProductoAnaquel extends DTOBelcorp {
    private String codigoValidacion;  // Identificador especial de la validacion
    private Long oidAnaquel;
    private String codigoAnaquel;
    private Long oidProducto;
    private String codigoProducto;
    // vbongiov -- BELC400000594 -- 26/07/2007
    private Long unidadesEstimadas;
    
    
    public DTOValidacionProductoAnaquel() {
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setOidAnaquel(Long oidAnaquel) {
        this.oidAnaquel = oidAnaquel;
    }

    public Long getOidAnaquel() {
        return oidAnaquel;
    }

    public void setCodigoAnaquel(String codigoAnaquel) {
        this.codigoAnaquel = codigoAnaquel;
    }

    public String getCodigoAnaquel() {
        return codigoAnaquel;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

  public Long getUnidadesEstimadas() {
    return unidadesEstimadas;
  }

  public void setUnidadesEstimadas(Long unidadesEstimadas) {
    this.unidadesEstimadas = unidadesEstimadas;
  }
}