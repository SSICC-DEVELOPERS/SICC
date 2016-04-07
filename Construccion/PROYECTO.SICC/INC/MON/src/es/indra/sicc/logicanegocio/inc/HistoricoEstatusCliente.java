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
import java.io.Serializable;

public class HistoricoEstatusCliente implements Serializable {
    private Long oidEstatus;
    private Periodo periodoInicio;
    private Periodo periodoFin;

    public HistoricoEstatusCliente() {
    }

    public Long getOidEstatus() {
        return oidEstatus;
    }

    public void setOidEstatus(Long HistoricoEstatusCliente) {
        this.oidEstatus = HistoricoEstatusCliente;
    }

    public Periodo getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(Periodo periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public Periodo getPeriodoFin() {
        return periodoFin;
    }

    public void setPeriodoFin(Periodo periodoFin) {
        this.periodoFin = periodoFin;
    }
    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!this.getClass().isInstance(obj)) {
            return false;
        }

        HistoricoEstatusCliente estatusEntrada = (HistoricoEstatusCliente) obj;
        if (this.oidEstatus.equals(estatusEntrada.getOidEstatus())) {
            if (!((this.periodoFin != null && 
                (this.periodoFin.getFechaHasta().getTime() < estatusEntrada.periodoInicio.getFechaDesde().getTime())) ||
                    (estatusEntrada.periodoFin != null 
                    && (this.periodoInicio.getFechaDesde().getTime() > estatusEntrada.periodoFin.getFechaHasta().getTime())))) {
                return true;
            }
        }
        return false;
    }
}