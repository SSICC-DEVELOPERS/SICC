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

package es.indra.sicc.cra.util;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;
import java.io.Serializable;

/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:         Cronograma de Actividades
 * Componente:        DTO's
 * Fecha:             13/11/2003
 * Observaciones:     Importado desde Version 2 y modificado segun requerimientos
 *                    generales de la Version 3
 * @version           1.0
 * @autor             Gaston Acevedo
 * */

public class GrupoZonaActividad extends DTOAuditableSICC implements Serializable{

    private Long oidGrupoZona;
    private String nombreGrupoZona;
    private String tipoFacturacion;
    private Vector actividades;
    private Integer codigoGrupoZona;

	public GrupoZonaActividad() {
		super();
	}

    public String getNombreGrupoZona() {
        return nombreGrupoZona;
    }

    public void setNombreGrupoZona(String newNombreGrupoZona) {
        nombreGrupoZona = newNombreGrupoZona;
    }

    public Long getOidGrupoZona()  {
        return oidGrupoZona;
    }

    public void setOidGrupoZona(Long newOidGrupoZona)  {
        oidGrupoZona = newOidGrupoZona;
    }

    public Integer getCodigoGrupoZona() {
        return codigoGrupoZona;
    }

    public void setCodigoGrupoZona(Integer newCodigoGrupoZona) {
        codigoGrupoZona = newCodigoGrupoZona;
    }

    public String getTipoFacturacion() {
        return tipoFacturacion;
    }

    public void setTipoFacturacion(String newTipoFacturacion) {
        tipoFacturacion = newTipoFacturacion;
    }

    public Vector getActividades() {
        return actividades;
    }

    public void setActividades(Vector newActividades) {
        actividades = newActividades;
    }

    /*
     * Agrega una actividad al grupo de zona
     */
    public void addActividad(Actividad newActividad) {
        //Definido por Gabriel Guardincerri
        actividades.add(newActividad);
    }

    /*
     * Elimina una actividad del grupo de zona
     */
    public boolean removeActividad(Actividad remActividad) {
        //Definido por Gabriel Guardincerri
        return actividades.remove(remActividad);
    }    

}
