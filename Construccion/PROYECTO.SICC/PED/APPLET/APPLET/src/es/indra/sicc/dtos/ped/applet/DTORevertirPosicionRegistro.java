package es.indra.sicc.dtos.ped.applet;

import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTORevertirPosicionRegistro extends DTOAuditableSICC {
  private ArrayList posicionesRevertir;
  private DTOCabeceraSolicitud cabeceraSolicitud;

  public ArrayList getPosicionesRevertir()
  {
    return posicionesRevertir;
  }

  public void setPosicionesRevertir(ArrayList posicionesRevertir)
  {
    this.posicionesRevertir = posicionesRevertir;
  }

  public DTOCabeceraSolicitud getCabeceraSolicitud()
  {
    return cabeceraSolicitud;
  }

  public void setCabeceraSolicitud(DTOCabeceraSolicitud cabeceraSolicitud)
  {
    this.cabeceraSolicitud = cabeceraSolicitud;
  }
}