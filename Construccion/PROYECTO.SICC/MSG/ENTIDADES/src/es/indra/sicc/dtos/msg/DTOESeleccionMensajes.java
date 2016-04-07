package es.indra.sicc.dtos.msg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOESeleccionMensajes extends DTOAuditableSICC {
  private Long oidPatron;
  private Long oidCliente; // inc. 431
    private Integer periodo;

    public DTOESeleccionMensajes() {
    }

    public Long getOidCliente() {
    return oidCliente;
    }

    public void setOidCliente(Long newCodigoCliente) {
        oidCliente = newCodigoCliente;
    }

    public Long getOidPatron() {
    return oidPatron;
    }

    public void setOidPatron(Long newOidPatron) {
    oidPatron = newOidPatron;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer newPeriodo) {
        periodo = newPeriodo;
    }

}
