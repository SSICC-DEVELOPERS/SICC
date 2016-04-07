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
 *
 */
/**
  * pperanzola - 20/10/2005 - se modifica segun incidencia BELC300021203
  */
package es.indra.sicc.dtos.pre;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
 

public class DTOECopiarMF extends DTOAuditableSICC  {

    private Long oidOrigen;
    private Long oidNueva;
    private Long codigoProgramaFidelizacion; //[1]
    private Long variante;//[1]
    // vbongiov -- Cambio 20080746 -- 29/10/2008
    private Long oidTipoOferta;
    private Boolean indOrdenarCodVenta;
    
    public DTOECopiarMF() {
    }

    public Long getOidNueva() {
        return oidNueva;
    }

    public void setOidNueva(Long newOidNueva) {
        oidNueva = newOidNueva;
    }

    public Long getOidOrigen() {
        return oidOrigen;
    }

    public void setOidOrigen(Long newOidOrigen) {
        oidOrigen = newOidOrigen;
    }
    ///*[1]
    public Long getCodigoProgramaFidelizacion() {
        return codigoProgramaFidelizacion;
    }

    public void setCodigoProgramaFidelizacion(Long codigoProgramaFidelizacion) {
        this.codigoProgramaFidelizacion = codigoProgramaFidelizacion;
    }

    public Long getVariante(){
        return variante;
    }

    public void setVariante(Long variante) {
        this.variante = variante;
    }

    //*/[1]
    
     public Long getOidTipoOferta()
     {
         return oidTipoOferta;
     }

     public void setOidTipoOferta(Long oidTipoOferta)
     {
         this.oidTipoOferta = oidTipoOferta;
     }

     public Boolean getIndOrdenarCodVenta()
     {
         return indOrdenarCodVenta;
     }

     public void setIndOrdenarCodVenta(Boolean indOrdenarCodVenta)
     {
         this.indOrdenarCodVenta = indOrdenarCodVenta;
     }


}