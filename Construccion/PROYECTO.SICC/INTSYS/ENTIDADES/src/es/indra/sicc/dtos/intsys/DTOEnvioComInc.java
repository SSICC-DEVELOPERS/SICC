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

public class DTOEnvioComInc extends DTOBelcorp{
    private Long oidCliente;
    private String codPlanilla;
    private Long importePagar;
    private Boolean fallido;
    //añadido por incidencia 22281
    private Long oidIngresoComInc;


    public void setOidCliente(Long oidCliente){
        this.oidCliente = oidCliente;
    }


    public Long getOidCliente(){
        return oidCliente;
    }


    public void setCodPlanilla(String codPlanilla){
        this.codPlanilla = codPlanilla;
    }


    public String getCodPlanilla(){
        return codPlanilla;
    }


    public void setImportePagar(Long importePagar){
        this.importePagar = importePagar;
    }


    public Long getImportePagar(){
        return importePagar;
    }


    public void setFallido(Boolean fallido){
        this.fallido = fallido;
    }


    public Boolean getFallido(){
        return fallido;
    }

    public Long getOidIngresoComInc()
    {
        return oidIngresoComInc;
    }

    public void setOidIngresoComInc(Long oidIngresoComInc)
    {
        this.oidIngresoComInc = oidIngresoComInc;
    }
}