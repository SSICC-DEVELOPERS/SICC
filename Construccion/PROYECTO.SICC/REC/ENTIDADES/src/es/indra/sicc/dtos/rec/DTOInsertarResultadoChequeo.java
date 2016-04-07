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
import es.indra.sicc.util.DTOBelcorp;

public class DTOInsertarResultadoChequeo extends DTOBelcorp  {
    public DTOInsertarResultadoChequeo() {
    }
    
    private Long oidSolicitudCabecera;
    private Long oidResultadoChequeo;
    private String observaciones;

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getOidResultadoChequeo() {
        return oidResultadoChequeo;
    }

    public void setOidResultadoChequeo(Long oidResultadoChequeo) {
        this.oidResultadoChequeo = oidResultadoChequeo;
    }

    public Long getOidSolicitudCabecera() {
        return oidSolicitudCabecera;
    }

    public void setOidSolicitudCabecera(Long oidSolicitudCabecera) {
        this.oidSolicitudCabecera = oidSolicitudCabecera;
    }
}