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
 
package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:       Belcorp
 * Modulo:        BEL - BelCenter
 * Componente:    DTOCopiarParametrosBelcenter 
 * Fecha:         05/11/2004
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
 
public class DTOCopiarParametrosBelcenter extends DTOAuditableSICC {

    private Long oidSubaccesoOrigen;
    private Long oidSubaccesoDestino;

    public DTOCopiarParametrosBelcenter() {

    }

    public Long getOidSubaccesoOrigen() {
        return oidSubaccesoOrigen;
    }

    public void setOidSubaccesoOrigen(Long newOidSubaccesoOrigen) {
        oidSubaccesoOrigen = newOidSubaccesoOrigen;
    }

    public Long getOidSubaccesoDestino() {
        return oidSubaccesoDestino;
    }

    public void setOidSubaccesoDestino(Long newOidSubaccesoDestino) {
        oidSubaccesoDestino = newOidSubaccesoDestino;
    }

}