package es.indra.sicc.logicanegocio.inc;
import java.io.Serializable;


/**
 * Se usa para retornar el tipo y subtipos de solicitud y posicion de una solicitud.
 *
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
 *
 * @date 27/04/2005
 * @author Gustavo Viñales
 */
public class TipoSolicitudPosicion implements Serializable {
    private Long tipoSolicitud;
    private Long tipoPosicion;
    private Long subtipoPosicion;
    private Long producto;
    private Long acceso;
    private Long subacceso;

    public TipoSolicitudPosicion() {
    }

    public void setSubtipoPosicion(Long subtipoPosicion) {
        this.subtipoPosicion = subtipoPosicion;
    }

    public Long getSubtipoPosicion() {
        return subtipoPosicion;
    }

    public void setTipoPosicion(Long tipoPosicion) {
        this.tipoPosicion = tipoPosicion;
    }

    public Long getTipoPosicion() {
        return tipoPosicion;
    }

    public void setTipoSolicitud(Long tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Long getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setProducto(Long producto) {
        this.producto = producto;
    }

    public Long getProducto() {
        return producto;
    }

    public Long getAcceso() {
        return acceso;
    }

    public void setAcceso(Long acceso) {
        this.acceso = acceso;
    }


    public void setSubacceso(Long subacceso)
    {
        this.subacceso = subacceso;
    }


    public Long getSubacceso()
    {
        return subacceso;
    }
}
