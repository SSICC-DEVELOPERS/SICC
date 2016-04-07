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

package es.indra.sicc.dtos.zon;

import es.indra.sicc.util.DTOBelcorp;

/**
 * Sistema:           Belcorp
 * Modulo:            ZON 
 * Submódulo:         Zonificación
 * Componente:        DTO's
 * Fecha:             19/05/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-ZON-201-334-N028
 *                    (Subido al portal el //)
 * @version           1.0
 * @autor             
 */

public class DTOHistoricoZona  extends DTOBelcorp {
    private Long oidZonaPadre;
    private Long oidEstadoPadre;
    private Long oidZonaHija;
    private Character tipoModificacion;


    public DTOHistoricoZona() {
        super();
    }

    public Long getOidEstadoPadre(){
        return oidEstadoPadre;
    }
    
    public Long getOidZonaPadre(){
        return oidZonaPadre;
    }

   public void setOidEstadoPadre(Long oidEstadoPadre) {
        this.oidEstadoPadre = oidEstadoPadre;
    }

    public void setOidZonaPadre(Long oidZonaPadre) {
        this.oidZonaPadre = oidZonaPadre;
    }

    public Long getOidZonaHija() {
        return oidZonaHija;
    }

    public void setOidZonaHija(Long oidZonaHija) {
        this.oidZonaHija = oidZonaHija;
    }

    public Character getTipoModificacion() {
        return tipoModificacion;
    }

    public void setTipoModificacion(Character tipoModificacion) {
        this.tipoModificacion = tipoModificacion;
    }


}
