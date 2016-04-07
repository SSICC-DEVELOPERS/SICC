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
 */
package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           19/1/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Viviana Bongiovanni
 */

public class DTOBusquedaPeriodos extends DTOAuditableSICC  {
    private Long marca;
    private Long canal;
    private Long tipoPeriodo;

    public DTOBusquedaPeriodos() {
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Long getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(Long newTipoPeriodo) {
        tipoPeriodo = newTipoPeriodo;
    }
}