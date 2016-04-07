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

public class DTOEvaluarChequeo extends DTOBelcorp  {
    public DTOEvaluarChequeo() {
    }
    
    private Long oidPeriodoReclamo;
    private Integer cantidadMinima;
    private Integer cantidadPeriHaciaAtras;
    private Long oidPeriodoDesde;
    private Long oidPeriodoHasta;
    
    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Integer getCantidadMinima() {
        return cantidadMinima;
    }
    
    public void setCantidadPeriHaciaAtras(Integer cantidadPeriHaciaAtras) {
        this.cantidadPeriHaciaAtras = cantidadPeriHaciaAtras;
    }

    public Integer getCantidadPeriHaciaAtras() {
        return cantidadPeriHaciaAtras;
    }
    
    public Long getOidPeriodoDesde() {
        return oidPeriodoDesde;
    }

    public void setOidPeriodoDesde(Long oidPeriodoDesde) {
        this.oidPeriodoDesde = oidPeriodoDesde;
    }
    
    public Long getOidPeriodoHasta() {
        return oidPeriodoHasta;
    }

    public void setOidPeriodoHasta(Long oidPeriodoHasta) {
        this.oidPeriodoHasta = oidPeriodoHasta;
    }
    
    public Long getOidPeriodoReclamo() {
        return oidPeriodoReclamo;
    }

    public void setOidPeriodoReclamo(Long oidPeriodoReclamo) {
        this.oidPeriodoReclamo = oidPeriodoReclamo;
    }
}
