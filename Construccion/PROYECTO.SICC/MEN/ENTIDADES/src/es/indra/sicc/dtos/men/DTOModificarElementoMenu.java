package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOModificarElementoMenu extends DTOAuditableSICC
{
  private Vector nombreFuncion;
  private Boolean indicadorRastreo;
  private Boolean indicadorFuncionFinal;
  private String programaEjecutable;
  private Long idFuncionJerarquiaDestino;
  private Long idFuncion;
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

  public DTOModificarElementoMenu()
  {
  }

  public Vector getNombreFuncion() {
    return nombreFuncion;
  }

  public void setNombreFuncion(Vector newNombreFuncion)
  {
    nombreFuncion = newNombreFuncion;
  }

  public Boolean getIndicadorRastreo()
  {
    return indicadorRastreo;
  }

  public void setIndicadorRastreo(Boolean newIndicadorRastreo)
  {
    indicadorRastreo = newIndicadorRastreo;
  }

  public Boolean getIndicadorFuncionFinal()
  {
    return indicadorFuncionFinal;
  }

  public void setIndicadorFuncionFinal(Boolean newIndicadorFuncionFinal)
  {
    indicadorFuncionFinal = newIndicadorFuncionFinal;
  }

  public String getProgramaEjecutable()
  {
    return programaEjecutable;
  }

  public void setProgramaEjecutable(String newProgramaEjecutable)
  {
    programaEjecutable = newProgramaEjecutable;
  }

  public Long getIdFuncionJerarquiaDestino()
  {
        return idFuncionJerarquiaDestino;
  }

    public Long getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Long newIdFuncion) {
        idFuncion = newIdFuncion;
    }

    public void setIdFuncionJerarquiaDestino(Long newIdFuncionJerarquiaDestino) {
        idFuncionJerarquiaDestino = newIdFuncionJerarquiaDestino;
    }
}