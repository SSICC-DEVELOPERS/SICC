/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/
package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTRegionCerrada extends DTOBelcorp  {

    private String anioCampania;
    private String codigoRegion;
    private String codigoZona;
    private String flagImpresion;
    private String flagStatusFacturacion;

    public DTOINTRegionCerrada() {
    }

    public void setAnioCampania(String anioCampania) {
      this.anioCampania = anioCampania;
    }
  
    public String getAnioCampania() {
      return anioCampania;
    }
  
    public void setCodigoRegion(String codigoRegion) {
      this.codigoRegion = codigoRegion;
    }
  
    public String getCodigoRegion() {
      return codigoRegion;
    }
  
    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }
  
    public String getCodigoZona() {
        return codigoZona;
    }
  
    public void setFlagImpresion(String flagImpresion) {
        this.flagImpresion = flagImpresion;
    }
  
    public String getFlagImpresion() {
        return flagImpresion;
    }
  
    public void setFlagStatusFacturacion(String flagStatusFacturacion) {
        this.flagStatusFacturacion = flagStatusFacturacion;
    }
  
    public String getFlagStatusFacturacion() {
        return flagStatusFacturacion;
    }

}