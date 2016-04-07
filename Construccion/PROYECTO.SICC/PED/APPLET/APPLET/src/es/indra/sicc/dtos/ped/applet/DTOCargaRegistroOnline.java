package es.indra.sicc.dtos.ped.applet;
import es.indra.sicc.dtos.ped.applet.DTODatosCombo;
import es.indra.sicc.comunapplet.dtos.applet.DTOPaginacionClientePesado;
import java.util.Date;

public class DTOCargaRegistroOnline extends DTOPaginacionClientePesado {
  private String txtsubAcceso;
  private Long oidSubAcceso;
  private DTODatosCombo[] periodos;
  private DTODatosCombo[] accesosFisico;
  private DTODatosCombo[] tiposDespacho;
  private DTODatosCombo[] formasPago;
  private DTODatosCombo[] valoreDefecto;
  private DTOTiposSolicitud[] tiposSolicitud;
  private String ipCliente;
  private Boolean belcenter;
  private String codUsuario;
  private String IP;
  //private DTODatosCliente datosCliente;
  private Long oidAcceso;
  private String txtAcceso;
  private Long oidCanal;
  private String txtCanal;
  private String userName;
  
  //17/07/2006 cdos gPineda
  private Date fechaFacturacion;
  

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

  public String getIpCliente()
  {
    return ipCliente;
  }

  public void setIpCliente(String ipCliente)
  {
    this.ipCliente = ipCliente;
  }

  public Boolean isBelcenter()
  {
    return belcenter;
  }
  
  public Boolean getBelcenter()
  {
    return belcenter;
  }

  public void setBelcenter(Boolean belcenter)
  {
    this.belcenter = belcenter;
  }

  public String getCodUsuario()
  {
    return codUsuario;
  }

  public void setCodUsuario(String codUsuario)
  {
    this.codUsuario = codUsuario;
  }

  public String getIP()
  {
    return IP;
  }

  public void setIP(String IP)
  {
    this.IP = IP;
  }

 /* public DTODatosCliente getDatosCliente()
  {
    return datosCliente;
  }

  public void setDatosCliente(DTODatosCliente datosCliente)
  {
    this.datosCliente = datosCliente;
  }
*/

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }


  public Long getOidAcceso()
  {
    return oidAcceso;
  }


  public void setTxtAcceso(String txtAcceso)
  {
    this.txtAcceso = txtAcceso;
  }


  public String getTxtAcceso()
  {
    return txtAcceso;
  }


  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }


  public Long getOidCanal()
  {
    return oidCanal;
  }


  public void setTxtCanal(String txtCanal)
  {
    this.txtCanal = txtCanal;
  }


  public String getTxtCanal()
  {
    return txtCanal;
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }


  public void setFechaFacturacion(Date fechaFacturacion)
  {
    this.fechaFacturacion = fechaFacturacion;
  }


  public Date getFechaFacturacion()
  {
    return fechaFacturacion;
  }
}