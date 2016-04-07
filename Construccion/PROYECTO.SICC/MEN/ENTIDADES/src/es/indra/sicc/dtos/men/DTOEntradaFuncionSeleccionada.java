package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEntradaFuncionSeleccionada extends DTOAuditableSICC
{
  private String nombreFuncion;
  private Long id;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

  public DTOEntradaFuncionSeleccionada()
  {
  }

  public String getNombreFuncion()
  {
    return nombreFuncion;
  }

  public void setNombreFuncion(String newNombreFuncion)
  {
    nombreFuncion = newNombreFuncion;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long newId)
  {
    id = newId;
  }
}