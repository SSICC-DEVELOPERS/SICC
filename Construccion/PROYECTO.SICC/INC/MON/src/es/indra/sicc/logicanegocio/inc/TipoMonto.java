package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;
import java.math.BigDecimal;

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
 *
 * @autor Javier Quiroga - CDOS - jquiroga@indra.com.ar
 * @date 26/05/2005
 */
public class TipoMonto implements Serializable {
    public Long tipo;
    public BigDecimal cantidad;

    public TipoMonto() {
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public Long getTipo() {
        return tipo;
    }
}
