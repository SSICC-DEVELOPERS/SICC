package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOColeccionSubaccesos extends DTOAuditableSICC {
  private Vector collectionSubaccesos;

  public DTOColeccionSubaccesos() {
  }

  public Vector getCollectionSubaccesos() {
    return collectionSubaccesos;
  }

  public void setCollectionSubaccesos(Vector newCollectionSubaccesos) {
    collectionSubaccesos = newCollectionSubaccesos;
  }
  
}