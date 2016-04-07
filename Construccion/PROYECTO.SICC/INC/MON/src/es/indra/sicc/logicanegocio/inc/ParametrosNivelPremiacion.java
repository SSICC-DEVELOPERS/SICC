/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 *
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;
import java.io.Serializable;

public class ParametrosNivelPremiacion implements Serializable {
    private Long numeroNivel;
    private Long numeroPedidos;

    public ParametrosNivelPremiacion() {
    }

    public Long getNumeroNivel() {
        return numeroNivel;
    }

    public void setNumeroNivel(Long numeroNivel) {
        this.numeroNivel = numeroNivel;
    }

    public Long getNumeroPedidos() {
        return numeroPedidos;
    }

    public void setNumeroPedidos(Long numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }
}
