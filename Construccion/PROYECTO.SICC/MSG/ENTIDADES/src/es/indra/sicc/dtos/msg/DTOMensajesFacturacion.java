package es.indra.sicc.dtos.msg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOMensajesFacturacion extends DTOAuditableSICC {
  private String codCliente;
  private Long oidPatron;
  private Long oidTipoPeriodo;
  private Long oidPeriodo;
  private Long oidCabecera;

    public DTOMensajesFacturacion() {
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String newCodCliente) {
        codCliente = newCodCliente;
    }

    public Long getOidCabecera() {
    return oidCabecera;
    }

    public void setOidCabecera(Long newOidCabecera) {
    oidCabecera = newOidCabecera;
    }

    public Long getOidPatron() {
    return oidPatron;
    }

    public void setOidPatron(Long newOidPatron) {
    oidPatron = newOidPatron;
    }

    public Long getOidPeriodo() {
    return oidPeriodo;
    }

    public void setOidPeriodo(Long newOidPeriodo) {
    oidPeriodo = newOidPeriodo;
    }

    public Long getOidTipoPeriodo() {
    return oidTipoPeriodo;
    }

    public void setOidTipoPeriodo(Long newOidTipoPeriodo) {
    oidTipoPeriodo = newOidTipoPeriodo;
    }



}
