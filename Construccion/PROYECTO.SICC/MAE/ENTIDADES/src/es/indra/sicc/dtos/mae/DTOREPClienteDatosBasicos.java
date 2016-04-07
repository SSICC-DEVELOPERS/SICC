package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

public class DTOREPClienteDatosBasicos extends DTOAuditableSICC 
{
  private String codigoCliente;
  private String nombreCliente;
  private String statusCliente;
  private String email;
  private String canal;
  private String marca;
  private Date fechaDeIngreso;
  private Boolean bloqueoAdministrativo;
  private Boolean bloqueoFinanciero;
  private String motivoBloqueoAdministrativo;
  private String telefono;
  private String periodo;

  public DTOREPClienteDatosBasicos()
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

  public String getNombreCliente()
  {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente)
  {
    this.nombreCliente = nombreCliente;
  }

  public String getStatusCliente()
  {
    return statusCliente;
  }

  public void setStatusCliente(String statusCliente)
  {
    this.statusCliente = statusCliente;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getCanal()
  {
    return canal;
  }

  public void setCanal(String canal)
  {
    this.canal = canal;
  }

  public String getMarca()
  {
    return marca;
  }

  public void setMarca(String marca)
  {
    this.marca = marca;
  }

  public Date getFechaDeIngreso()
  {
    return fechaDeIngreso;
  }

  public void setFechaDeIngreso(Date fechaDeIngraso)
  {
    this.fechaDeIngreso = fechaDeIngraso;
  }

  public Boolean getBloqueoAdministrativo()
  {
    return bloqueoAdministrativo;
  }

  public void setBloqueoAdministrativo(Boolean bloqueoAdministrativo)
  {
    this.bloqueoAdministrativo = bloqueoAdministrativo;
  }

  public Boolean getBloqueoFinanciero()
  {
    return bloqueoFinanciero;
  }

  public void setBloqueoFinanciero(Boolean bloqueoFinanciero)
  {
    this.bloqueoFinanciero = bloqueoFinanciero;
  }

  public String getMotivoBloqueoAdministrativo()
  {
    return motivoBloqueoAdministrativo;
  }

  public void setMotivoBloqueoAdministrativo(String motivoBloqueoAdministrativo)
  {
    this.motivoBloqueoAdministrativo = motivoBloqueoAdministrativo;
  }

  public String getTelefono()
  {
    return telefono;
  }

  public void setTelefono(String telefono)
  {
    this.telefono = telefono;
  }

  public String getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(String periodo)
  {
    this.periodo = periodo;
  }
}