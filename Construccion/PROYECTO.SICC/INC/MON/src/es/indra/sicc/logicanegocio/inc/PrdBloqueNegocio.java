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
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;
import java.io.Serializable;

public class PrdBloqueNegocio
        extends PrdBloque implements Serializable {
    private Long oidMarcaProducto;
    private Long oidUnidadNegocio;
    private Long oidNegocio;
    private Long oidGenerico;
    private Long oidSuperGenerico;

    public PrdBloqueNegocio() {
    }

    /*
     * Verifica si el producto esta contenido en el bloque de Negocio.
     */
    public boolean validarProducto(Posicion pos, Long oidConcurso) {
        UtilidadesLog.info("PrdBloqueNegocio.validarProducto(Posicion pos, Long oidConcurso):Entrada");


UtilidadesLog.info(" oidMarcaProducto " + oidMarcaProducto + " getOidMarcaProducto " + pos.getOidMarcaProducto());
UtilidadesLog.info(" oidUnidadNegocio " + oidUnidadNegocio + " getOidUnidadNegocio " + pos.getOidUnidadNegocio());
UtilidadesLog.info(" oidNegocio " + oidNegocio + " getOidNegocio " + pos.getOidNegocio());
UtilidadesLog.info(" oidGenerico " + oidGenerico + " getOidGenerico " + pos.getOidGenerico());
UtilidadesLog.info(" oidSuperGenerico " + oidSuperGenerico + " getOidSuperGenerico " + pos.getOidSuperGenerico());


        if (!pos.getPeriodo().contenidoEn(this.getPeriodoDesde(), this.getPeriodoHasta())) {
            UtilidadesLog.info("PrdBloqueNegocio.validarProducto:Salida PERIODO");
            return false;
        }

        if (oidMarcaProducto != null) {
            if (!oidMarcaProducto.equals(pos.getOidMarcaProducto())) {
            UtilidadesLog.info("PrdBloqueNegocio.validarProducto:Salida MARCA PRODUCTO");
                return false;
            }
        }

        if (oidUnidadNegocio != null) {
            if (!oidUnidadNegocio.equals(pos.getOidUnidadNegocio())) {
            UtilidadesLog.info("PrdBloqueNegocio.validarProducto:Salida UNIDAD NEGOCIO");
                return false;
            }
        }

        if (oidNegocio != null) {
            if (!oidNegocio.equals(pos.getOidNegocio())) {
                UtilidadesLog.info("PrdBloqueNegocio.validarProducto:Salida NEGOCIO");
                return false;
            }
        }

        if (oidGenerico != null) {
            if (!oidGenerico.equals(pos.getOidGenerico())) {
                UtilidadesLog.info("PrdBloqueNegocio.validarProducto:Salida GENERICO");
                return false;
            }
        }

        if (oidSuperGenerico != null) {
            if (!oidSuperGenerico.equals(pos.getOidSuperGenerico())) {
                UtilidadesLog.info("PrdBloqueNegocio.validarProducto:Salida SUPERGENERICO");
                return false;
            }
        }

        // Si no se cumple algunos de los casos anteriores que haga que se retorn false se retorna true 
        UtilidadesLog.debug("Se valido Bloque Negocio ------ >>> this.getOidProductoExigido() " + this.getOidProductoExigido());
        UtilidadesLog.debug("Se valido Bloque Negocio ------ >>> pos.getPosicionPuntaje(oidConcurso) " +
                           pos.getPosicionPuntaje(oidConcurso).getOidPosicion());

        //jrivas 16/8/2005
        //inc 20358
        //pos.getPosicionPuntaje(oidConcurso).setOidProductoExigido(this.getOidProductoExigido());
        UtilidadesLog.info("PrdBloqueNegocio.validarProducto(Posicion pos, Long oidConcurso):Salida");
        return true;
    }

    public Long getOidMarcaProducto() {
        return oidMarcaProducto;
    }

    public void setOidMarcaProducto(Long oidMarcaProducto) {
        this.oidMarcaProducto = oidMarcaProducto;
    }

    public Long getOidUnidadNegocio() {
        return oidUnidadNegocio;
    }

    public void setOidUnidadNegocio(Long oidUnidadNegocio) {
        this.oidUnidadNegocio = oidUnidadNegocio;
    }

    public Long getOidNegocio() {
        return oidNegocio;
    }

    public void setOidNegocio(Long oidNegocio) {
        this.oidNegocio = oidNegocio;
    }

    public Long getOidGenerico() {
        return oidGenerico;
    }

    public void setOidGenerico(Long oidGenerico) {
        this.oidGenerico = oidGenerico;
    }

    public Long getOidSuperGenerico() {
        return oidSuperGenerico;
    }

    public void setOidSuperGenerico(Long oidSuperGenerico) {
        this.oidSuperGenerico = oidSuperGenerico;
    }
}
