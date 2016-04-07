package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOEntradaInsertarElementodeMenu extends DTOAuditableSICC 
{
  private String nombreElementoMenu;
  private Boolean indicadorDeRastreo;
  private Boolean indicadorFuncionFinal;
  private String nombreProgramaEjecutable;
  private Long idFuncJerarquia;
  private Vector idIdioma;
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

  public DTOEntradaInsertarElementodeMenu()
  {
  }

  public String getNombreElementoMenu()
  {
    return nombreElementoMenu;
  }

  public void setNombreElementoMenu(String newNombreElementoMenu)
  {
    nombreElementoMenu = newNombreElementoMenu;
  }

  public Boolean getIndicadorDeRastreo()
  {
    return indicadorDeRastreo;
  }

  public void setIndicadorDeRastreo(Boolean newIndicadorDeRastreo)
  {
    indicadorDeRastreo = newIndicadorDeRastreo;
  }

  public Boolean getIndicadorFuncionFinal()
  {
    return indicadorFuncionFinal;
  }

  public void setIndicadorFuncionFinal(Boolean newIndicadorFuncionFinal)
  {
    indicadorFuncionFinal = newIndicadorFuncionFinal;
  }

  public String getNombreProgramaEjecutable()
  {
    return nombreProgramaEjecutable;
  }

  public void setNombreProgramaEjecutable(String newNombreProgramaEjecutable)
  {
    nombreProgramaEjecutable = newNombreProgramaEjecutable;
  }

    public Vector getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Vector newIdIdioma) {
        idIdioma = newIdIdioma;
    }

    public Long getIdFuncJerarquia() {
        return idFuncJerarquia;
    }

    public void setIdFuncJerarquia(Long newIdFuncJerarquia) {
        idFuncJerarquia = newIdFuncJerarquia;
    }

}