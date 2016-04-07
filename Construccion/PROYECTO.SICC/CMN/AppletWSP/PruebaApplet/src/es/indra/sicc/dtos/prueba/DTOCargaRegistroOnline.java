package es.indra.sicc.dtos.prueba;
import es.indra.sicc.dtos.prueba.DTODatosCombo;
import java.io.Serializable;

public class DTOCargaRegistroOnline extends DTOAbstractoApplet implements Serializable{
  private String txtsubAcceso;
  private Long oidSubAcceso;
  private DTODatosCombo[] periodos;
  private DTODatosCombo[] accesosFisico;
  private DTODatosCombo[] tiposDespacho;
  private DTODatosCombo[] formasPago;
  private DTODatosCombo[] valoreDefecto;
  private DTOTiposSolicitud[] tiposSolicitud;

  public DTOCargaRegistroOnline() {
  }

  public String getTxtsubAcceso() {
    return txtsubAcceso;
  }

  public void setTxtsubAcceso(String newTxtsubAcceso) {
    txtsubAcceso = newTxtsubAcceso;
  }

  public Long getOidSubAcceso() {
    return oidSubAcceso;
  }

  public void setOidSubAcceso(Long newOidSubAcceso) {
    oidSubAcceso = newOidSubAcceso;
  }

  public DTODatosCombo[] getPeriodos() {
    return periodos;
  }

  public void setPeriodos(DTODatosCombo[] newPeriodos) {
    periodos = newPeriodos;
  }

  public DTODatosCombo[] getAccesosFisico() {
    return accesosFisico;
  }

  public void setAccesosFisico(DTODatosCombo[] newAccesosFisico) {
    accesosFisico = newAccesosFisico;
  }

  public DTODatosCombo[] getTiposDespacho() {
    return tiposDespacho;
  }

  public void setTiposDespacho(DTODatosCombo[] newTiposDespacho) {
    tiposDespacho = newTiposDespacho;
  }

  public DTODatosCombo[] getFormasPago() {
    return formasPago;
  }

  public void setFormasPago(DTODatosCombo[] newFormasPago) {
    formasPago = newFormasPago;
  }

  public DTODatosCombo[] getValoreDefecto() {
    return valoreDefecto;
  }

  public void setValoreDefecto(DTODatosCombo[] newValoreDefecto) {
    valoreDefecto = newValoreDefecto;
  }

  public DTOTiposSolicitud[] getTiposSolicitud() {
    return tiposSolicitud;
  }

  public void setTiposSolicitud(DTOTiposSolicitud[] newTiposSolicitud) {
    tiposSolicitud = newTiposSolicitud;
  }
}