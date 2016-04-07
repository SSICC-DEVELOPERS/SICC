package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOVencimientosCC  extends DTOBelcorp{
    private String codigoPeriodo;
    private Long numeroIdentificadorCuota;
    private Long numeroOrdenCuota;
    private Float importePendiente;
    private Date fechaVencimiento;

    public DTOVencimientosCC() {
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public Long getNumeroIdentificadorCuota() {
        return numeroIdentificadorCuota;
    }

    public void setNumeroIdentificadorCuota(Long numeroIdentificadorCuota) {
        this.numeroIdentificadorCuota = numeroIdentificadorCuota;
    }

    public Long getNumeroOrdenCuota() {
        return numeroOrdenCuota;
    }

    public void setNumeroOrdenCuota(Long numeroOrdenCuota) {
        this.numeroOrdenCuota = numeroOrdenCuota;
    }

    public Float getImportePendiente() {
        return importePendiente;
    }

    public void setImportePendiente(Float importePendiente) {
        this.importePendiente = importePendiente;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}