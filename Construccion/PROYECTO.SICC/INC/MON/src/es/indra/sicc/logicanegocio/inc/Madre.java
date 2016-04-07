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
import java.util.ArrayList;
import java.util.Iterator;

public class Madre implements Serializable {
    private Long oidCliente;
    private Long oidConcurso;
    private ArrayList hijas;
    private ArrayList pedidos;

    public Madre() {
        hijas = new ArrayList();
        pedidos = new ArrayList();
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public ArrayList getHijas() {
        return hijas;
    }

    public void setHijas(ArrayList hijas) {
        this.hijas = hijas;
    }

    public ArrayList getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 06/06/2005
     * @Recibe: void
     * @Retorna: un Long
     * @Descripción: Se recorre la lista pedidos y hacemos el sumatorio de cantidad
     *               de cada PedidoMultinivel y lo devolvemos
     * @Referencia: Incidencia BELC300018836
     */
    public Long getCantidadMadre() {
        UtilidadesLog.info("Madre.getCantidadMadre():Entrada");
        long cantidadMadre = 0;
        Iterator itPedidos = this.pedidos.iterator();

        while (itPedidos.hasNext()) {
            PedidoMultinivel pedidoMultinivel = (PedidoMultinivel) itPedidos.next();

            cantidadMadre = cantidadMadre + ((pedidoMultinivel.getCantidad() != null) ? pedidoMultinivel.getCantidad().longValue() : 0);
        }
        UtilidadesLog.info("Madre.getCantidadMadre():Salida");
        return new Long(cantidadMadre);
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 06/06/2005
     * @Recibe: void
     * @Retorna: un Long
     * @Descripción: Hacemos el sumatorio de cantidad de todos los pedidos de las
     *               hijas. Es decir, recorremos la lista hijas y de cada hija todos
     *               los pedidos sumando en una variable el valor de cantidad para luego
     *               devolverla.
     * @Referencia: Incidencia BELC300018836
     */
    public Long getCantidadHijas() {
        UtilidadesLog.info("Madre.getCantidadHijas():Entrada");
        long cantidadHijas = 0;
        Iterator itHijas = this.hijas.iterator();

        while (itHijas.hasNext()) {
            Hijas hija = (Hijas) itHijas.next();
            Iterator itPedidosHija = (hija.getPedidos() != null) ? hija.getPedidos().iterator() : null;

            if (itPedidosHija != null) {
                while (itPedidosHija.hasNext()) {
                    PedidoMultinivel pedidoMultinivel = (PedidoMultinivel) itPedidosHija.next();

                    cantidadHijas = cantidadHijas + ((pedidoMultinivel.getCantidad() != null) ? pedidoMultinivel.getCantidad().longValue() : 0);
                }
            }
        }
        UtilidadesLog.info("Madre.getCantidadHijas():Salida");
        return new Long(cantidadHijas);
    }
}
