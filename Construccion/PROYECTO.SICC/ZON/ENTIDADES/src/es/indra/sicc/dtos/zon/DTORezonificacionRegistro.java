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
import java.util.Date;

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

public class DTORezonificacionRegistro  extends DTOBelcorp {
    private String tipoOp;
    private String nse1;
    private String codCliente;
    private String datoOrigen2;
    private String datoOrigen1;
    private String nse2;
    private String desc;
    private String datoNuevo;


    public DTORezonificacionRegistro() {
        super();
    }

    public String getNse1(){
        return nse1;
    }
    
    public String getTipoOp(){
        return tipoOp;
    }

    public String getCodCliente() {
        return codCliente;
    }


    public String getDatoOrigen2() {
        return datoOrigen2;
    }


    public void setNse1(String nse1) {
        this.nse1 = nse1;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public void setTipoOp(String tipoOp) {
        this.tipoOp = tipoOp;
    }

    public void setDatoOrigen2(String datoOrigen2) {
        this.datoOrigen2 = datoOrigen2;
    }

    public String getDatoOrigen1() {
        return datoOrigen1;
    }

    public void setDatoOrigen1(String datoOrigen1) {
        this.datoOrigen1 = datoOrigen1;
    }

    public String getNse2() {
        return nse2;
    }


    public String getDesc() {
        return desc;
    }


    public void setNse2(String nse2) {
        this.nse2 = nse2;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDatoNuevo() {
        return datoNuevo;
    }

    public void setDatoNuevo(String datoNuevo) {
        this.datoNuevo = datoNuevo;
    }


}
