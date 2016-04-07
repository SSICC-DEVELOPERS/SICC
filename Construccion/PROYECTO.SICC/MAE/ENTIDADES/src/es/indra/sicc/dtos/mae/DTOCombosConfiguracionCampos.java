package es.indra.sicc.dtos.mae;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOCombosConfiguracionCampos extends DTOTipoSubtipo  {
  private RecordSet tipoCliente;
  private RecordSet subtipoCliente;
  private RecordSet campos;

  public DTOCombosConfiguracionCampos(DTOTipoSubtipo dto) {
    this.setTipoCliente(dto.getTipos());
    this.setSubtipoCliente(dto.getSubtipos());
  }

  public RecordSet getTipoCliente() {
    return tipoCliente;
  }

  public void setTipoCliente(RecordSet newTipoCliente) {
    tipoCliente = newTipoCliente;
  }

  public RecordSet getSubtipoCliente() {
    return subtipoCliente;
  }

  public void setSubtipoCliente(RecordSet newSubtipoCliente) {
    subtipoCliente = newSubtipoCliente;
  }

  public RecordSet getCampos() {
    return campos;
  }

  public void setCampos(RecordSet newCampos) {
    campos = newCampos;
  }
}