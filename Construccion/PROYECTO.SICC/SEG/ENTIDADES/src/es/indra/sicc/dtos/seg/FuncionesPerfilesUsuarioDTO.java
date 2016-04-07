package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class FuncionesPerfilesUsuarioDTO extends DTOAuditableSICC
{
  private ArrayList listaFunciones;

  public FuncionesPerfilesUsuarioDTO()
  {
  super();
  }

  public ArrayList getListaFunciones()
  {
    return this.listaFunciones;
  }

  public void setListaFunciones(ArrayList listaFunciones)
  {
    this.listaFunciones = listaFunciones;
  }
}