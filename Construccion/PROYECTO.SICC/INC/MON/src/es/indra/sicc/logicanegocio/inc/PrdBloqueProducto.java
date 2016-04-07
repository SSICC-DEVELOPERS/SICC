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

public class PrdBloqueProducto
        extends PrdBloque implements Serializable {
    private Long oidProducto;
    private Long oidTipoOferta;
    private Long oidCicloVida;

    public PrdBloqueProducto() {
    }

    /*
     * Verifica si el producto esta contenido en el bloque de Producto.
     */
    public boolean validarProducto(Posicion pos, Long oidConcurso) {
        UtilidadesLog.info("PrdBloqueOferta.validarProducto(Posicion pos, Long oidConcurso):Entrada");
        if (!pos.getPeriodo().contenidoEn(this.getPeriodoDesde(), this.getPeriodoHasta())) {
            UtilidadesLog.info("PrdBloqueOferta.validarProducto:Salida PERIDO");
            return false;
        }

        if (oidProducto != null) {
            if (!oidProducto.equals(pos.getOidProducto())) {
                UtilidadesLog.info("PrdBloqueOferta.validarProducto:Salida PRODUCTO");
                return false;
            }
        }

        if (oidTipoOferta != null) {
            if (!oidTipoOferta.equals(pos.getOidTipoOferta())) {
                UtilidadesLog.info("PrdBloqueOferta.validarProducto:Salida TIPO OFERTA");
                return false;
            }
        }

        if (oidCicloVida != null) {
            if (!oidCicloVida.equals(pos.getOidCicloVida())) {
                UtilidadesLog.info("PrdBloqueOferta.validarProducto:Salida CICLO VIDA");
                return false;
            }
        }

        // Si no se cumple algunos de los casos anteriores que haga que se retorn false se retorna true 
        UtilidadesLog.debug("Se valido Bloque Producto ------ >>> this.getOidProductoExigido() " + this.getOidProductoExigido());
        UtilidadesLog.debug("Se valido Bloque Producto ------ >>> pos.getPosicionPuntaje(oidConcurso) " +
                           pos.getPosicionPuntaje(oidConcurso).getOidPosicion());

        //jrivas 16/8/2005
        //inc 20358
        //pos.getPosicionPuntaje(oidConcurso).setOidProductoExigido(this.getOidProductoExigido());
        UtilidadesLog.info("PrdBloqueOferta.validarProducto(Posicion pos, Long oidConcurso):Salida");
        return true;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }

    public void setOidTipoOferta(Long oidTipoOferta) {
        this.oidTipoOferta = oidTipoOferta;
    }

    public Long getOidCicloVida() {
        return oidCicloVida;
    }

    public void setOidCicloVida(Long oidCicloVida) {
        this.oidCicloVida = oidCicloVida;
    }
}
