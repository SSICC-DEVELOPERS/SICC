package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTONomApeCliente extends DTOBelcorp
{
  private Long oidCliente;
  private String nombre1;
  private String nombre2;
  private String apellido1;
  private String apellido2;

  public DTONomApeCliente() 
  {
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public String getNombre1()
  {
    return nombre1;
  }

  public void setNombre1(String nombre1)
  {
    this.nombre1 = nombre1;
  }

  public String getNombre2()
  {
    return nombre2;
  }

  public void setNombre2(String nombre2)
  {
    this.nombre2 = nombre2;
  }

  public String getApellido1()
  {
    return apellido1;
  }

  public void setApellido1(String apellido1)
  {
    this.apellido1 = apellido1;
  }

  public String getApellido2()
  {
    return apellido2;
  }

  public void setApellido2(String apellido2)
  {
    this.apellido2 = apellido2;
  }
}