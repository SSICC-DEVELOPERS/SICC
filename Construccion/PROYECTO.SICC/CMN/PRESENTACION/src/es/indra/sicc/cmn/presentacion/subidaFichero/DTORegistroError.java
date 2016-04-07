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

package es.indra.sicc.cmn.presentacion.subidaFichero;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTORegistroError extends DTOAuditableSICC {
    private String fechaHora;
    private String mensajeError;
    private String dato;

    public DTORegistroError() {
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String newFechaHora) {
        fechaHora = newFechaHora;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String newMensajeError) {
        mensajeError = newMensajeError;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String newDato) {
        dato = newDato;
    }
}
