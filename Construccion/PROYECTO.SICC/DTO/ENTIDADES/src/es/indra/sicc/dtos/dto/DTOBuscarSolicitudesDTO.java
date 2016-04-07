/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOSolicitudDescuento 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Federico I. Hofman
 */

public class DTOBuscarSolicitudesDTO extends DTOSiccPaginacion {
    private Long oidCliente;
    private String codigoCliente;    
    private String codigoVenta;
    private String oidMarca;
    private String oidCanal;
    private String oidAcceso;

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String newCodigoVenta) {
        codigoVenta = newCodigoVenta;
    }

    public String getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(String newOidMarca) {
        oidMarca = newOidMarca;
    }

    public String getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(String newOidCanal) {
        oidCanal = newOidCanal;
    }

    public String getOidAcceso() {
        return oidAcceso;
    }

    public void setOidAcceso(String newOidAcceso) {
        oidAcceso = newOidAcceso;
    }


  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }


  public String getCodigoCliente()
  {
    return codigoCliente;
  }

    

}