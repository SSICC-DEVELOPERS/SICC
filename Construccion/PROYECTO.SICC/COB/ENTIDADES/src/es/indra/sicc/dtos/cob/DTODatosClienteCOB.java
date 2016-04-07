package es.indra.sicc.dtos.cob;

import java.sql.Date;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODatosClienteCOB extends DTOAuditableSICC
{
  private String codigoCliente;
  private String apellido1;
  private String apellido2;
  private String apellidoCasada;
  private String nombre1;
  private String nombre2;
  private String tratamiento;
  private Date fechaNacimiento;
  private String tipoVia;
  private String nombreVia;
  
  // V-PED001 - dmorello, 06/10/2006: Se cambia el tipo de Integer a String
  private String numeroPrincipal;
  
  private String puerta;
  private String estatus;
  private Boolean indicadorActivo;

  public DTODatosClienteCOB()
  {
  }

  public String getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
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

  public String getApellidoCasada()
  {
    return apellidoCasada;
  }

  public void setApellidoCasada(String apellidoCasada)
  {
    this.apellidoCasada = apellidoCasada;
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

  public String getTratamiento()
  {
    return tratamiento;
  }

  public void setTratamiento(String tratamiento)
  {
    this.tratamiento = tratamiento;
  }

  public Date getFechaNacimiento()
  {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento)
  {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getTipoVia()
  {
    return tipoVia;
  }

  public void setTipoVia(String tipoVia)
  {
    this.tipoVia = tipoVia;
  }

  public String getNombreVia()
  {
    return nombreVia;
  }

  public void setNombreVia(String nombreVia)
  {
    this.nombreVia = nombreVia;
  }

  public String getNumeroPrincipal()
  {
    return numeroPrincipal;
  }

  public void setNumeroPrincipal(String numeroPrincipal)
  {
    this.numeroPrincipal = numeroPrincipal;
  }

  public String getPuerta()
  {
    return puerta;
  }

  public void setPuerta(String puerta)
  {
    this.puerta = puerta;
  }

  public String getEstatus()
  {
    return estatus;
  }

  public void setEstatus(String estatus)
  {
    this.estatus = estatus;
  }

  public Boolean getIndicadorActivo()
  {
    return indicadorActivo;
  }

  public void setIndicadorActivo(Boolean indicadorActivo)
  {
    this.indicadorActivo = indicadorActivo;
  }
}