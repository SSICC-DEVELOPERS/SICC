/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOOIDs;

public class DTOParamBalanceoAreaChequeo extends DTOSiccPaginacion {
    private Long oidCentroDistribucion;
    private Long oidLineaArmado;
    private DTOOIDs listaSolicitudes;
    private String parametroDistribucion;
    private String pedidosArmadoHoras;
    private String unidadesChequeoHoraPersona;
    private Long oidParametros; 
    private Double diaHora;
    private Long codAgrupacion;
    
    public DTOParamBalanceoAreaChequeo() {
    }

    public void setOidCentroDistribucion(Long oidCentroDistribucion) {
        this.oidCentroDistribucion = oidCentroDistribucion;
    }

    public Long getOidCentroDistribucion() {
        return oidCentroDistribucion;
    }
    
    public void setOidLineaArmado(Long oidLineaArmado) {
        this.oidLineaArmado  = oidLineaArmado;
    }

    public Long getOidLineaArmado() {
        return oidLineaArmado;
    }    

    public DTOOIDs getListaSolicitudes() {
      return listaSolicitudes;
    }
  
    public void setListaSolicitudes(DTOOIDs listaSolicitudes) {
      this.listaSolicitudes = listaSolicitudes;
    }

    public void setParametroDistribucion(String parametroDistribucion) {
        this.parametroDistribucion = parametroDistribucion;
    }

    public String getParametroDistribucion() {
        return parametroDistribucion;
    }

    public void setPedidosArmadoHoras(String pedidosArmadoHoras) {
        this.pedidosArmadoHoras = pedidosArmadoHoras;
    }

    public String getPedidosArmadoHoras() {
        return pedidosArmadoHoras;
    }
    
    public void setUnidadesChequeoHoraPersona(String unidadesChequeoHoraPersona) {
        this.unidadesChequeoHoraPersona = unidadesChequeoHoraPersona;
    }

    public String getUnidadesChequeoHoraPersona() {
        return unidadesChequeoHoraPersona;
    }    
    
     public void setOidParametros(Long oidParametros) {
        this.oidParametros = oidParametros;
    }

    public Long getOidParametros() {
        return oidParametros;
    }  


  public void setDiaHora(Double diaHora)
  {
    this.diaHora = diaHora;
  }


  public Double getDiaHora()
  {
    return diaHora;
  }


  public void setCodAgrupacion(Long codAgrupacion)
  {
    this.codAgrupacion = codAgrupacion;
  }


  public Long getCodAgrupacion()
  {
    return codAgrupacion;
  }
    
}