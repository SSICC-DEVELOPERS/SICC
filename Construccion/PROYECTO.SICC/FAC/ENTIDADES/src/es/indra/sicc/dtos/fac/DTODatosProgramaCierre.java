package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

public class DTODatosProgramaCierre extends DTOBelcorp {
    
    private Long oidPeriodo;
    private String codigoPeriodo;
    private String fecha;
    private String formatoFecha;
    private String tipoCierre;
    
    public DTODatosProgramaCierre() {
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }
}
