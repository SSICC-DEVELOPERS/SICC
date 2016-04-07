package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;

/**
 * Contiene los lotes de PremiosArticulos para un concurso determinado.
 * <p>Copyright 2005 © por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * España<br>
 * <p>Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @date 26/04/2005
 * @author Gustavo Viñales
 */
public class PremioArticulo
        implements Serializable {
    private Long numeroUnidades;

    /*
     * Implementacion: se carga de las entidades INC:PremioArticulo y
     * INC:LotePremioArticulo haciendo un join por oidPremioArticulo creando un
     * objeto de la clase PremioArticuloLote.
     */
    public PremioArticulo() {
    }

    public void setNumeroUnidades(Long numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    public Long getNumeroUnidades() {
        return numeroUnidades;
    }
}
