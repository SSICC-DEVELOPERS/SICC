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

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOMensajeDescuento 
 * Fecha:         16/06/2005
 * Observaciones: Componente construido de acuerdo a la especificación de incidencia 19041
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
 
public class DTOMensajeDescuento extends DTOAuditableSICC {
    
    private String codigoMensaje;
    private Long cliente;
    private Long modulo;
    private String dv1;
    private String dv2;
    private String dv3;
    private String dv4;
    private String dv5;
    private String dv6;
    private Long descuento;
    private String descripcionMarcaProducto;
    private String descripcionUnidadNegocio;
    private String descripcionNegocio;
    private Long marcaProducto;
    private Long unidadNegocio;
    private Long negocio;

    public DTOMensajeDescuento() {
    }

    public String getCodigoMensaje()
    {
        return codigoMensaje;
    }

    public void setCodigoMensaje(String codigoMensaje)
    {
        this.codigoMensaje = codigoMensaje;
    }

    public Long getCliente()
    {
        return cliente;
    }

    public void setCliente(Long cliente)
    {
        this.cliente = cliente;
    }

    public Long getModulo()
    {
        return modulo;
    }

    public void setModulo(Long modulo)
    {
        this.modulo = modulo;
    }

    public String getDv1()
    {
        return dv1;
    }

    public void setDv1(String dv1)
    {
        this.dv1 = dv1;
    }

    public String getDv2()
    {
        return dv2;
    }

    public void setDv2(String dv2)
    {
        this.dv2 = dv2;
    }

    public String getDv3()
    {
        return dv3;
    }

    public void setDv3(String dv3)
    {
        this.dv3 = dv3;
    }

    public String getDv4()
    {
        return dv4;
    }

    public void setDv4(String dv4)
    {
        this.dv4 = dv4;
    }

    public String getDv5()
    {
        return dv5;
    }

    public void setDv5(String dv5)
    {
        this.dv5 = dv5;
    }

    public String getDv6()
    {
        return dv6;
    }

    public void setDv6(String dv6)
    {
        this.dv6 = dv6;
    }

    public Long getDescuento()
    {
        return descuento;
    }

    public void setDescuento(Long descuento)
    {
        this.descuento = descuento;
    }

    public String getDescripcionMarcaProducto()
    {
        return descripcionMarcaProducto;
    }

    public void setDescripcionMarcaProducto(String descripcionMarcaProducto)
    {
        this.descripcionMarcaProducto = descripcionMarcaProducto;
    }

    public String getDescripcionUnidadNegocio()
    {
        return descripcionUnidadNegocio;
    }

    public void setDescripcionUnidadNegocio(String descripcionUnidadNegocio)
    {
        this.descripcionUnidadNegocio = descripcionUnidadNegocio;
    }

    public String getDescripcionNegocio()
    {
        return descripcionNegocio;
    }

    public void setDescripcionNegocio(String descripcionNegocio)
    {
        this.descripcionNegocio = descripcionNegocio;
    }

    public Long getMarcaProducto()
    {
      return marcaProducto;
    }
  
    public void setMarcaProducto(Long marcaProducto)
    {
      this.marcaProducto = marcaProducto;
    }
  
    public Long getUnidadNegocio()
    {
      return unidadNegocio;
    }
  
    public void setUnidadNegocio(Long unidadNegocio)
    {
      this.unidadNegocio = unidadNegocio;
    }
  
    public Long getNegocio()
    {
      return negocio;
    }
  
    public void setNegocio(Long negocio)
    {
      this.negocio = negocio;
    }
}