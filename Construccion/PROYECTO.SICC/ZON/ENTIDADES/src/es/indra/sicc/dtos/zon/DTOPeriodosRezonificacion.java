/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

package es.indra.sicc.dtos.zon;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import java.util.Collection;

/**
 * Sistema:           Belcorp
 * Modulo:            ZON 
 * Subm�dulo:         Zonificaci�n
 * Componente:        DTO's
 * Fecha:             19/05/2005
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del 
 *                    Modelo de Componentes SICC-DMCO-ZON-201-334-N028
 *                    (Subido al portal el //)
 * @version           1.0
 * @autor             
 */

public class DTOPeriodosRezonificacion  extends DTOBelcorp {


    private DTOPeriodo periodoPropuesto;
    private DTOPeriodo periodoSinSolapar;
    private Collection listaPosteriores;

    public DTOPeriodosRezonificacion() {
        super();
    }

    public DTOPeriodo getPeriodoPropuesto() {
        return periodoPropuesto;
    }

    public void setPeriodoPropuesto(DTOPeriodo periodoPropuesto) {
        this.periodoPropuesto = periodoPropuesto;
    }

    public DTOPeriodo getPeriodoSinSolapar() {
        return periodoSinSolapar;
    }

    public void setPeriodoSinSolapar(DTOPeriodo periodoSinSolapar) {
        this.periodoSinSolapar = periodoSinSolapar;
    }

    public Collection getListaPosteriores() {
        return listaPosteriores;
    }

    public void setListaPosteriores(Collection listaPosteriores) {
        this.listaPosteriores = listaPosteriores;
    }

    
















}
