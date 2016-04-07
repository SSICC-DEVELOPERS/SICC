package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOPremioRecomendacion extends DTOAuditableSICC  {

    private Long clienteRecomendado;
    private Long clienteRecomendante;
    // vbongiv -- 18/01/2008 -- Cambio SiCC20070461 MAE
    private String problemasEstatus;

    public Long getClienteRecomendado() {
        return clienteRecomendado;
    }

    public void setClienteRecomendado(Long newClienteRecomendado) {
        clienteRecomendado = newClienteRecomendado;
    }

    public Long getClienteRecomendante() {
        return clienteRecomendante;
    }

    public void setClienteRecomendante(Long newClienteRecomendante) {
        clienteRecomendante = newClienteRecomendante;
    }

  public String getProblemasEstatus() {
    return problemasEstatus;
  }

  public void setProblemasEstatus(String problemasEstatus) {
    this.problemasEstatus = problemasEstatus;
  }

    


}
