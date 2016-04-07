/*
 * RegistroCache.java
 *
 * Created on 9 de diciembre de 2004, 12:50 PM
 */

package es.indra.sicc.cmn.applet;
import es.indra.sicc.dtos.prueba.DTODatosCombo;
import es.indra.sicc.dtos.prueba.DTOTiposSolicitud;

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
}
