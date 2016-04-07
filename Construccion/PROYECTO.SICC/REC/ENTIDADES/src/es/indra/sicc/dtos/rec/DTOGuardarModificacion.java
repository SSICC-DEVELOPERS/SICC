/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.rec;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;

public class DTOGuardarModificacion extends DTOBelcorp{
    
    private Long oidCabecera;    
    private RecordSet lstNoGenerar;
    private RecordSet lstDetalles; // BELC300020340
    
    public DTOGuardarModificacion(){
        super();
    }
    
    public RecordSet getLstNoGenerar(){
        return lstNoGenerar;
    }

    public void setLstNoGenerar(RecordSet lstNoGenerar){
        this.lstNoGenerar = lstNoGenerar;
    }

    public Long getOidCabecera(){
        return oidCabecera;
    }

    public void setOidCabecera(Long oidCabecera){
        this.oidCabecera = oidCabecera;
    }

    public RecordSet getLstDetalles() {
        return lstDetalles;
    }

    public void setLstDetalles(RecordSet lstDetalles) {
        this.lstDetalles = lstDetalles;
    }
        
}