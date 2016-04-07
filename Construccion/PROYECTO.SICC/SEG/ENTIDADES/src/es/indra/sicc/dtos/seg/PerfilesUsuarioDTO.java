package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.lang.String;
import java.util.Vector;

public class PerfilesUsuarioDTO extends DTOAuditableSICC
{
  private Vector listaPerfiles;
  private String usuario;
  
  public PerfilesUsuarioDTO()
  {
    super();
  }

  public Vector getListaPerfiles()
  {
    return this.listaPerfiles;
  }

  public void setListaPerfiles(Vector listaPerfiles)
  {
    this.listaPerfiles = listaPerfiles;
    return;
  }


  public String getUsuario()
  {
    return this.usuario;
  }

  public void setUsuario(String usuario)
  {
    this.usuario = usuario;
    return; 
  }


  
}