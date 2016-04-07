package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSalidaObtieneFunciones extends DTOAuditableSICC
{
  private String idFuncion;
  private String nombreFuncion;
  private String nombrePrograma;
  private String indicadorNivel;
  private String indicadorRastreo;
  private String activa;
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

  public DTOSalidaObtieneFunciones()
  {
  }

  public String getIdFuncion()
  {
    return idFuncion;
  }

  public void setIdFuncion(String newIdFuncion) {
    idFuncion = newIdFuncion;
  }

  public String getNombreFuncion() {
    return nombreFuncion;
  }

  public void setNombreFuncion(String newNombreFuncion) {
    nombreFuncion = newNombreFuncion;
  }

  public String getNombrePrograma() {
    return nombrePrograma;
  }

  public void setNombrePrograma(String newNombrePrograma) {
    nombrePrograma = newNombrePrograma;
  }

  public String getIndicadorNivel() {
    return indicadorNivel;
  }

  public void setIndicadorNivel(String newIndicadorNivel)
  {
    indicadorNivel = newIndicadorNivel;
  }

  public String getIndicadorRastreo()
  {
    return indicadorRastreo;
  }

  public void setIndicadorRastreo(String newIndicadorRastreo)
  {
    indicadorRastreo = newIndicadorRastreo;
  }

  public String getActiva()
  {
    return activa;
  }

  public void setActiva(String newActiva)
  {
    activa = newActiva;
  }
}