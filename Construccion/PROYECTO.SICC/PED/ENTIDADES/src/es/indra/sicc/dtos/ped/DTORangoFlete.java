package es.indra.sicc.dtos.ped;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.math.BigDecimal;

public class DTORangoFlete extends DTOSiccPaginacion {

    private Long oidRangoFlete;
    private BigDecimal rangoInf;
    private BigDecimal rangoSup;
    private BigDecimal montoFij;
    private Long oidFlete;
    private String modificado;    
    private String aEliminar;    
    
    public DTORangoFlete() {
    }

    public void setOidRangoFlete(Long oidRangoFlete) {
        this.oidRangoFlete = oidRangoFlete;
    }

    public Long getOidRangoFlete() {
        return oidRangoFlete;
    }

    public void setRangoInf(BigDecimal rangoInf) {
        this.rangoInf = rangoInf;
    }

    public BigDecimal getRangoInf() {
        return rangoInf;
    }

    public void setRangoSup(BigDecimal rangoSup) {
        this.rangoSup = rangoSup;
    }

    public BigDecimal getRangoSup() {
        return rangoSup;
    }

    public void setMontoFij(BigDecimal montoFij) {
        this.montoFij = montoFij;
    }

    public BigDecimal getMontoFij() {
        return montoFij;
    }

    public void setOidFlete(Long oidFlete) {
        this.oidFlete = oidFlete;
    }

    public Long getOidFlete() {
        return oidFlete;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }

    public String getModificado() {
        return modificado;
    }

    public void setAEliminar(String aEliminar) {
        this.aEliminar = aEliminar;
    }

    public String getAEliminar() {
        return aEliminar;
    }
}
