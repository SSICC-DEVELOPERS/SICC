package es.indra.sicc.dtos.ped.applet;
import java.math.BigDecimal;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTODatosCliente extends DTOAuditableSICC {
  private String nombre;
  private String apellidos;
  private BigDecimal lineaCredito;
  private BigDecimal LineaDisp;
  private BigDecimal DeudaVencida;
  private DTODatosCombo[] direcciones;
  private DTOTipoDocumento[] tiposDocumento;
  private String codCliente;
  private Long oidCliente;
  private String userName;
  

  public DTODatosCliente() {
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String newNombre) {
    nombre = newNombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String newApellidos) {
    apellidos = newApellidos;
  }

  public BigDecimal getLineaCredito() {
    return lineaCredito;
  }

  public void setLineaCredito(BigDecimal newLineaCredito) {
    lineaCredito = newLineaCredito;
  }

  public BigDecimal getLineaDisp() {
    return LineaDisp;
  }

  public void setLineaDisp(BigDecimal newLineaDisp) {
    LineaDisp = newLineaDisp;
  }

  public BigDecimal getDeudaVencida() {
    return DeudaVencida;
  }

  public void setDeudaVencida(BigDecimal newDeudaVencida) {
    DeudaVencida = newDeudaVencida;
  }

  public DTODatosCombo[] getDirecciones() {
    return direcciones;
  }

  public void setDirecciones(DTODatosCombo[] newDirecciones) {
    direcciones = newDirecciones;
  }

  public DTOTipoDocumento[] getTiposDocumento() {
    return tiposDocumento;
  }

  public void setTiposDocumento(DTOTipoDocumento[] newTiposDocumento) {
    tiposDocumento = newTiposDocumento;
  }

  public String getCodCliente()
  {
    return codCliente;
  }

  public void setCodCliente(String codCliente)
  {
    this.codCliente = codCliente;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }
}