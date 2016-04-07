package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTOListaTipificaciones extends DTOAuditableSICC  {
  private ArrayList tipificaciones;

  public DTOListaTipificaciones() {
  }

  public ArrayList getTipificaciones() {
    return tipificaciones;
  }

  public void setTipificaciones(ArrayList newTipificaciones) {
    tipificaciones = newTipificaciones;
  }
}