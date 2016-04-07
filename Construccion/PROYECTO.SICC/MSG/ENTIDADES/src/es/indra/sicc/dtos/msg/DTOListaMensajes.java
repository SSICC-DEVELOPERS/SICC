package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.*;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOListaMensajes extends DTOAuditableSICC {
  public DTOListaMensajes() {
  }

  private RecordSet mensajes;

  private DTOMensaje[] listaMensaje;

  public RecordSet getMensajes() {
    return mensajes;
  }

  public void setMensajes(RecordSet newMensajes) {
    mensajes = newMensajes;
  }

  public DTOMensaje[] getListaMensaje() {
    return listaMensaje;
  }

  public void setListaMensaje(DTOMensaje[] newListaMensaje) {
    listaMensaje = newListaMensaje;
  }
}