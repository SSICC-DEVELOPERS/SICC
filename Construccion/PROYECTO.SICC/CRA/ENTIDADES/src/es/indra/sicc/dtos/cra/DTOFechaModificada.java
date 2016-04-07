/*
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

import java.util.ArrayList;
import java.util.Collection;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cra.util.ModificacionActividad;
import es.indra.sicc.cra.util.GrupoZonaActividad;

public class DTOFechaModificada extends DTOAuditableSICC {

	public DTOFechaModificada() {
		super();
	}

    private GrupoZonaActividad grupoZona;

    private Collection actModificadas  = new ArrayList();


    public GrupoZonaActividad getGrupoZona() {
        return grupoZona;
    }

    public void setGrupoZona(GrupoZonaActividad newGrupoZona) {
        grupoZona = newGrupoZona;
    }

    public void addModificacionActividad(ModificacionActividad modActividad) {
        actModificadas.add(modActividad);
    }

    public boolean removeModificacionActividad(ModificacionActividad modActividad) {
        return actModificadas.remove(modActividad);
    }

    //Devuelve una copia "soft" los elementos en si no son clonados
    public Collection getActividadesModificadas(){
        return (Collection) actModificadas;
    }

    public Collection getActModificadas() {
        return actModificadas;
    }

    public void setActModificadas(Collection actModificadas) {
        this.actModificadas = actModificadas;
    }
    
}
