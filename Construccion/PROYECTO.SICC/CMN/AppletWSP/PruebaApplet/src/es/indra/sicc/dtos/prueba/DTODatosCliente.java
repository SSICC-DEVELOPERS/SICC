package es.indra.sicc.dtos.prueba;
import java.math.BigDecimal;
import java.io.Serializable;

public class DTODatosCliente extends DTOAbstractoApplet implements Serializable{
  private String nombre;
  private String apellidos;
  private BigDecimal lineaCredito;
  private BigDecimal LineaDisp;
  private BigDecimal DeudaVencida;
  private DTODatosCombo[] direcciones;
  private DTOTipoDocumento[] tiposDocumento;

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
}