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
 */
 
/**
 * @author Sergio Platas
 * @date 19/07/2005
 * Incidencia 19834
 */
package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOFiltroGrupoSolicitud extends DTOSiccPaginacion {
    
    private Long nivelRiesgo;
    private Long oidCodConf;

    public DTOFiltroGrupoSolicitud() {
    }

    public Long getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(Long nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public Long getOidCodConf() {
        return oidCodConf;
    }

    public void setOidCodConf(Long oidCodConf) {
        this.oidCodConf = oidCodConf;
    }
}