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
import java.util.ArrayList;

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

public class DTOFicheroRezonificacion  extends DTOBelcorp {
    private ArrayList registros;
    private DTORezonificacionCabecera cabecera;
    private Long oidPeriodoRezonificacion;
    private String nombreFichero;


    public DTOFicheroRezonificacion() {
        super();
    }

    public ArrayList getRegistros(){
        return registros;
    }

    public DTORezonificacionCabecera getCabecera() {
        return cabecera;
    }


    public void setRegistros(ArrayList registros) {
        this.registros = registros;
    }

    public void setCabecera(DTORezonificacionCabecera cabecera) {
        this.cabecera = cabecera;
    }

    public Long getOidPeriodoRezonificacion() {
        return oidPeriodoRezonificacion;
    }

    public void setOidPeriodoRezonificacion(Long oidPeriodoRezonificacion) {
        this.oidPeriodoRezonificacion = oidPeriodoRezonificacion;
    }
    
    public String getNombreFichero() {
        return nombreFichero;
    }

    public void setNombreFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }




}
