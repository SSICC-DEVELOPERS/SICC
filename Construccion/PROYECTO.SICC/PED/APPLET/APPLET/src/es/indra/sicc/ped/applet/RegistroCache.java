/*
 * RegistroCache.java
 *
 * Created on 9 de diciembre de 2004, 12:50 PM
 */

package es.indra.sicc.ped.applet;
import es.indra.sicc.dtos.ped.applet.DTODatosCombo;
import es.indra.sicc.dtos.ped.applet.DTOTiposSolicitud;
import java.util.Date;

/**
 *
 * @author  jpbosnja
 */
public class RegistroCache {
  
    private static RegistroCache myRegistroCache ;
    private Boolean cargado;
    private Object valoresDefecto;
    private Long oidSubAcceso;
    private String txtSubAcceso;
    private DTODatosCombo[] formaPago;
    private DTODatosCombo[] tiposDespacho;
    private DTODatosCombo[] accesosFisicos;
    private DTODatosCombo[] periodos;
    private DTOTiposSolicitud[] tiposSolicitud;
    private Boolean belcenter = null;
  private Long ultimoPeriodo;
  private Long ultimoTipoSolicitud;
  private Long oidAcceso;
  private String txtAcceso;
  private Long oidCanal;
  private String txtCanal;
  private String numeroMovimiento;
  private Long controlStock;
  private Integer tamPagina;
  
    //17/07/2006 cdos gPineda
  private Date fechaFacturacion;
    
    /** Creates a new instance of RegistroCache */
    private RegistroCache() {
        this.setCargado(Boolean.FALSE);
    }
    
    public static RegistroCache getInstance(){
        if (myRegistroCache == null){
            myRegistroCache = new RegistroCache();
            
        }
        return myRegistroCache;
    }
    
    public Boolean getCargado(){
        return this.cargado;
    }
    
    public void setCargado(Boolean cargado){
        this.cargado = cargado;
    }

    public Object getValoresDefecto(){
        return this.valoresDefecto;
    }
    
    public void setValoresDefecto(Object newvaloresDefecto){
        this.valoresDefecto = newvaloresDefecto;
    }

    public DTODatosCombo[] getAccesosFisicos() {
        return accesosFisicos;
    }

    public void setAccesosFisicos(DTODatosCombo[] newAccesosFisicos) {
        accesosFisicos = newAccesosFisicos;
    }

    public DTODatosCombo[] getTiposDespacho() {
      return tiposDespacho;
    }

    public void setTiposDespacho(DTODatosCombo[] newTiposDespacho) {
      tiposDespacho = newTiposDespacho;
    }

    public DTODatosCombo[] getPeriodos() {
      return periodos;
    }

    public void setPeriodos(DTODatosCombo[] newperiodos) {
      periodos = newperiodos;
    }

    public DTOTiposSolicitud[] getTiposSolicitud() {
      return tiposSolicitud;
    }

    public void setTiposSolicitud(DTOTiposSolicitud[] newtiposSolicitud) {
      tiposSolicitud = newtiposSolicitud;
    }

    public DTODatosCombo[] getFormaPago() {
      return formaPago;
    }

    public void setFormaPago(DTODatosCombo[] newformaPago) {
      formaPago = newformaPago;
    }

  public String getTxtSubAcceso() {
    return txtSubAcceso;
  }

  public void setTxtSubAcceso(String newTxtSubAcceso) {
    txtSubAcceso = newTxtSubAcceso;
  }

  public Long getOidSubAcceso() {
    return oidSubAcceso;
  }

  public void setOidSubAcceso(Long newOidSubAcceso) {
    oidSubAcceso = newOidSubAcceso;
  }  
  
  public Boolean getBelcenter() {
    return this.belcenter;
  }
  
  public void setBelcenter(Boolean b) {
    this.belcenter = b;
  }

  public Long getUltimoPeriodo()
  {
    return ultimoPeriodo;
  }

  public void setUltimoPeriodo(Long ultimoPeriodo)
  {
    this.ultimoPeriodo = ultimoPeriodo;
  }

  public Long getUltimoTipoSolicitud()
  {
    return ultimoTipoSolicitud;
  }

  public void setUltimoTipoSolicitud(Long ultimoTipoSolicitud)
  {
    this.ultimoTipoSolicitud = ultimoTipoSolicitud;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public String getTxtAcceso()
  {
    return txtAcceso;
  }

  public void setTxtAcceso(String txtAcceso)
  {
    this.txtAcceso = txtAcceso;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public String getTxtCanal()
  {
    return txtCanal;
  }

  public void setTxtCanal(String txtCanal)
  {
    this.txtCanal = txtCanal;
  }

  public String getNumeroMovimiento()
  {
    return numeroMovimiento;
  }

  public void setNumeroMovimiento(String numeroMovimiento)
  {
    this.numeroMovimiento = numeroMovimiento;
  }

  public Long getControlStock()
  {
    return controlStock;
  }

  public void setControlStock(Long controlStock)
  {
    this.controlStock = controlStock;
  }

  public Integer getTamPagina()
  {
    return tamPagina;
  }

  public void setTamPagina(Integer tamPagina)
  {
    this.tamPagina = tamPagina;
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
