package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

import java.sql.Date;

public class DTOCargaInicialCierre extends DTOBelcorp  {

    private String indicadorControlCierre;
    
    private String codigoPais;
    private String codigoPeriodo;
    private Date fechaProceso;  //fecha Proceso de Facturacion
    private Long oidPeriodo;    //periodo de Facturacion

    public DTOCargaInicialCierre() {
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setIndicadorControlCierre(String indicadorControlCierre) {
        this.indicadorControlCierre = indicadorControlCierre;
    }

    public String getIndicadorControlCierre() {
        return indicadorControlCierre;
    }
}
