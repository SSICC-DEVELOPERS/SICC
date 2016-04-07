package es.indra.sicc.dtos.msg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.Date;


public class DTOConsultaMensajesConsultora extends DTOAuditableSICC {
  private Long oidCliente; // inc. 434
    private Integer numeroLoteImpresion;
    private String medioEnvio;
    private Date fechaImpresion;
    private Integer tipoPeriodo;
    private Integer periodo;

    public DTOConsultaMensajesConsultora() {
    }

    public Date getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(Date newFechaImpresion) {
        fechaImpresion = newFechaImpresion;
    }

    public String getMedioEnvio() {
        return medioEnvio;
    }

    public void setMedioEnvio(String newMedioEnvio) {
        medioEnvio = newMedioEnvio;
    }

    public Long getOidCliente() {
    return oidCliente;
    }


    public Integer getNumeroLoteImpresion() {
        return numeroLoteImpresion;
    }

    public void setNumeroLoteImpresion(Integer newNumeroLoteImpresion) {
        numeroLoteImpresion = newNumeroLoteImpresion;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer newPeriodo) {
        periodo = newPeriodo;
    }

    public Integer getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(Integer newTipoPeriodo) {
        tipoPeriodo = newTipoPeriodo;
    }

  public void setOidCliente(Long newOidCliente) {
    oidCliente = newOidCliente;
  }
}
