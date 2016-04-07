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

public class DTOCargaListas extends DTOSiccPaginacion  {
    public DTOCargaListas() {
    }
    
    private Long oidCabecera;
    private Integer indicador;

    public Integer getIndicador() {
        return indicador;
    }

    public void setIndicador(Integer indicador) {
        this.indicador = indicador;
    }

    public Long getOidCabecera() {
        return oidCabecera;
    }

    public void setOidCabecera(Long oidCabecera) {
        this.oidCabecera = oidCabecera;
    }
    
}