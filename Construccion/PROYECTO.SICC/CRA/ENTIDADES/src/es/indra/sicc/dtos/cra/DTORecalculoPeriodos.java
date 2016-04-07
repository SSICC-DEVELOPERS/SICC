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

package es.indra.sicc.dtos.cra;

import java.io.Serializable;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:       Belcorp
 * Modulo:        CRA
 * Componente:    DTORecalculoPeriodos
 * Fecha:         05/11/2003
 * Observaciones: 
 *                
 * @version           1.0
 * @autor             Carlos Ferreira
 */
 
public class DTORecalculoPeriodos extends DTOAuditableSICC {
  private Long marca;
  private Long pais;
  private Long canal;
    private DTOPeriodo periodo;

    public DTORecalculoPeriodos() {
        super();
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public DTOPeriodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(DTOPeriodo newPeriodo) {
        periodo = newPeriodo;
    }
}