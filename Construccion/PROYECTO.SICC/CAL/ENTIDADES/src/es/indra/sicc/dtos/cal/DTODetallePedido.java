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

package es.indra.sicc.dtos.cal;
import es.indra.sicc.util.DTOBelcorp;

public class DTODetallePedido extends DTOBelcorp
{
    private String tipoSolicitudOrigen;
    private String numSolicitudOrigen;
    private String estadoPosicion;
    private String tipoPosicion;
    private String numSolicitudRecuperacion;
    private String limiteVenta;
    private String controlStock;
    private String controlLiquidacion;
    private String formaPago;

    public DTODetallePedido()
    {
    }

    public String getTipoSolicitudOrigen()
    {
        return tipoSolicitudOrigen;
    }

    public void setTipoSolicitudOrigen(String tipoSolicitudOrigen)
    {
        this.tipoSolicitudOrigen = tipoSolicitudOrigen;
    }

    public String getNumSolicitudOrigen()
    {
        return numSolicitudOrigen;
    }

    public String getEstadoPosicion()
    {
        return estadoPosicion;
    }

    public void setEstadoPosicion(String estadoPosicion)
    {
        this.estadoPosicion = estadoPosicion;
    }

    public String getTipoPosicion()
    {
        return tipoPosicion;
    }

    public void setTipoPosicion(String tipoPosicion)
    {
        this.tipoPosicion = tipoPosicion;
    }

    public String getNumSolicitudRecuperacion()
    {
        return numSolicitudRecuperacion;
    }

    public void setNumSolicitudRecuperacion(String numSolicitudRecuperacion)
    {
        this.numSolicitudRecuperacion = numSolicitudRecuperacion;
    }

    public String getLimiteVenta()
    {
        return limiteVenta;
    }

    public void setLimiteVenta(String limiteVenta)
    {
        this.limiteVenta = limiteVenta;
    }

    public String getControlStock()
    {
        return controlStock;
    }

    public void setControlStock(String controlStock)
    {
        this.controlStock = controlStock;
    }

    public String getControlLiquidacion()
    {
        return controlLiquidacion;
    }

    public void setControlLiquidacion(String controlLiquidacion)
    {
        this.controlLiquidacion = controlLiquidacion;
    }

    public String getFormaPago()
    {
        return formaPago;
    }

    public void setFormaPago(String formaPago)
    {
        this.formaPago = formaPago;
    }
}