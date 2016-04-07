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

public class DTOINTDatosCliente extends DTOBelcorp  {
    
    private String tipoDocumento;     
    private String numeroDocumento;      
    private String digitoControlDocumento;     
    private String apellido1;     
    private String apellido2;     
    private String nombre1;     
    private String nombre2;     
    private String zonaConsultora; 
    //Añadidos por nuevo diseño en incidencia 12392
    private Long oidCliente;    
    private String codigoCliente;             
    private String codigoRegion;     
    private String tipoCliente;     
    private String subtipoCliente;     
    private String clasificacion;     
    private String tipoClasificacion;
    
    private Double importePendiente;

    public DTOINTDatosCliente() {
        super();
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDigitoControlDocumento() {
        return digitoControlDocumento;
    }

    public void setDigitoControlDocumento(String digitoControlDocumento) {
        this.digitoControlDocumento = digitoControlDocumento;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getZonaConsultora() {
        return zonaConsultora;
    }

    public void setZonaConsultora(String zonaConsultora) {
        this.zonaConsultora = zonaConsultora;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        this.codigoRegion = codigoRegion;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public String getSubtipoCliente() {
        return subtipoCliente;
    }

    public void setSubtipoCliente(String subtipoCliente) {
        this.subtipoCliente = subtipoCliente;
    }

    public String getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(String tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }


   public void setImportePendiente(Double importePendiente) {
      this.importePendiente = importePendiente;
   }


   public Double getImportePendiente() {
      return importePendiente;
   }
}