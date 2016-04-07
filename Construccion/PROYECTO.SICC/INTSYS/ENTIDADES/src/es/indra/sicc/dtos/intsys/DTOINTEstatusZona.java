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
package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTEstatusZona extends DTOBelcorp  {
    private String codigoEstatusZona;
    private String descripcionEstatusZona;

    public DTOINTEstatusZona() {
    }

    public String getCodigoEstatusZona() {
        return codigoEstatusZona;
    }

    public void setCodigoEstatusZona(String codigoEstatusZona) {
        this.codigoEstatusZona = codigoEstatusZona;
    }

    public String getDescripcionEstatusZona() {
        return descripcionEstatusZona;
    }

    public void setDescripcionEstatusZona(String descripcionEstatusZona) {
        this.descripcionEstatusZona = descripcionEstatusZona;
    }
}