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
 */
package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTODatosPreRec extends DTOBelcorp
{
    private String numGeneracion;
    private Long oidDetalleOfertaOrigen;
    private String codVentaOrigen;   
    private String descripcionOrigen;
    private BigDecimal precioCatalogoOrigen;   
    private Long oidDetalleOfertaDestino;
    private String codVentaDestino;
    private String descripcionDestino;
    private BigDecimal precioCatalogoDestino;
    private Long oidPrecioEnvia; // añadido por incidencia BELC300014892

    public DTODatosPreRec()
    {
    }

    public String getCodVentaDestino()
    {
        return codVentaDestino;
    }

    public void setCodVentaDestino(String codVentaDestino)
    {
        this.codVentaDestino = codVentaDestino;
    }

    public String getCodVentaOrigen()
    {
        return codVentaOrigen;
    }

    public void setCodVentaOrigen(String codVentaOrigen)
    {
        this.codVentaOrigen = codVentaOrigen;
    }

    public String getDescripcionDestino()
    {
        return descripcionDestino;
    }

    public void setDescripcionDestino(String descripcionDestino)
    {
        this.descripcionDestino = descripcionDestino;
    }

    public String getDescripcionOrigen()
    {
        return descripcionOrigen;
    }

    public void setDescripcionOrigen(String descripcionOrigen)
    {
        this.descripcionOrigen = descripcionOrigen;
    }

    public String getNumGeneracion()
    {
        return numGeneracion;
    }

    public void setNumGeneracion(String numGeneracion)
    {
        this.numGeneracion = numGeneracion;
    }

    public Long getOidDetalleOfertaDestino()
    {
        return oidDetalleOfertaDestino;
    }

    public void setOidDetalleOfertaDestino(Long oidDetalleOfertaDestino)
    {
        this.oidDetalleOfertaDestino = oidDetalleOfertaDestino;
    }

    public Long getOidDetalleOfertaOrigen()
    {
        return oidDetalleOfertaOrigen;
    }

    public void setOidDetalleOfertaOrigen(Long oidDetalleOfertaOrigen)
    {
        this.oidDetalleOfertaOrigen = oidDetalleOfertaOrigen;
    }

    public BigDecimal getPrecioCatalogoDestino()
    {
        return precioCatalogoDestino;
    }

    public void setPrecioCatalogoDestino(BigDecimal precioCatalogoDestino)
    {
        this.precioCatalogoDestino = precioCatalogoDestino;
    }

    public BigDecimal getPrecioCatalogoOrigen()
    {
        return precioCatalogoOrigen;
    }

    public void setPrecioCatalogoOrigen(BigDecimal precioCatalogoOrigen)
    {
        this.precioCatalogoOrigen = precioCatalogoOrigen;
    }

   public Long getOidPrecioEnvia() {
      return oidPrecioEnvia;
   }

   public void setOidPrecioEnvia(Long oidPrecioEnvia) {
      this.oidPrecioEnvia = oidPrecioEnvia;
   }
}