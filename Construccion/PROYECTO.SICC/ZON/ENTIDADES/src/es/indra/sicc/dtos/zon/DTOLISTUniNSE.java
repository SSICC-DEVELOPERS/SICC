package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;
import es.indra.sicc.dtos.zon.DTOUniNSE;

public class DTOLISTUniNSE extends DTOAuditableSICC 
{
  private ArrayList arrayDTOUniNSE;
  public DTOLISTUniNSE()
  {
    super();
  }

  public void setArrayDTOUniNSE(ArrayList arrayDTOUniNSE)
  {
    this.arrayDTOUniNSE = arrayDTOUniNSE;
  }

  public ArrayList getArrayDTOUniNSE()
  {
    return this.arrayDTOUniNSE;
  }
  
}