/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor: Diego Morello
 *
 */
package es.indra.sicc.logicanegocio.inc;
import java.io.Serializable; 

public class VariableVentaRanking 
        implements Serializable {
    private Integer peso;
    private Integer divisor;
    private Integer numeroDiasCobranza;
    private Boolean aplicable;

    public VariableVentaRanking() {
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getDivisor() {
        return divisor;
    }

    public void setDivisor(Integer divisor) {
        this.divisor = divisor;
    }

    public Integer getNumeroDiasCobranza() {
        return numeroDiasCobranza;
    }

    public void setNumeroDiasCobranza(Integer numeroDiasCobranza) {
        this.numeroDiasCobranza = numeroDiasCobranza;
    }

    public Boolean getAplicable() {
        return aplicable;
    }

    public void setAplicable(Boolean aplicable) {
        this.aplicable = aplicable;
    }
}
