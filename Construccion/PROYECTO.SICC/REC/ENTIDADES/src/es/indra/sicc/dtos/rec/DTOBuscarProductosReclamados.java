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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.util.Date;

public class DTOBuscarProductosReclamados extends DTOSiccPaginacion  {
    public DTOBuscarProductosReclamados() {
    }
    
    private Long numeroReclamo;
    private Date fechaReclamo;
    private Long oidOperacion;

    public Date getFechaReclamo() {
        return fechaReclamo;
    }

    public void setFechaReclamo(Date fechaReclamo) {
        this.fechaReclamo = fechaReclamo;
    }

    public Long getNumeroReclamo() {
        return numeroReclamo;
    }

    public void setNumeroReclamo(Long numeroReclamo) {
        this.numeroReclamo = numeroReclamo;
    }

    public Long getOidOperacion() {
        return oidOperacion;
    }

    public void setOidOperacion(Long oidOperacion) {
        this.oidOperacion = oidOperacion;
    }
}