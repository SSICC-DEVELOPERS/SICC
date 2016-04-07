package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarUsuariosCob extends DTOSiccPaginacion
{
  private Long oidUsuarioCob;
  private String codUsuario;
  private String nombre1;
  private String nombre2;
  private String apellido1;
  private String apellido2;
  private Long oidEstadoUsuario;
    
  public DTOBuscarUsuariosCob()
  {
  }

  public void setOidUsuarioCob(Long oidUsuarioCob)
  {
    this.oidUsuarioCob = oidUsuarioCob;
  }


  public Long getOidUsuarioCob()
  {
    return oidUsuarioCob;
  }


  public void setCodUsuario(String codUsuario)
  {
    this.codUsuario = codUsuario;
  }


  public String getCodUsuario()
  {
    return codUsuario;
  }


  public void setNombre1(String nombre1)
  {
    this.nombre1 = nombre1;
  }


  public String getNombre1()
  {
    return nombre1;
  }


  public void setNombre2(String nombre2)
  {
    this.nombre2 = nombre2;
  }


  public String getNombre2()
  {
    return nombre2;
  }


  public void setApellido1(String apellido1)
  {
    this.apellido1 = apellido1;
  }


  public String getApellido1()
  {
    return apellido1;
  }


  public void setApellido2(String apellido2)
  {
    this.apellido2 = apellido2;
  }


  public String getApellido2()
  {
    return apellido2;
  }


  public void setOidEstadoUsuario(Long oidEstadoUsuario)
  {
    this.oidEstadoUsuario = oidEstadoUsuario;
  }


  public Long getOidEstadoUsuario()
  {
    return oidEstadoUsuario;
  }
}