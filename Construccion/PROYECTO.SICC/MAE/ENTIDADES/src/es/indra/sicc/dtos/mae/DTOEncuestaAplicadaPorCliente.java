/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Componente:      DTO's
 * Fecha:           9/02/2006
 * Observaciones:     
 * @autor           Ezequiel Amores
 */
public class DTOEncuestaAplicadaPorCliente extends DTOSiccPaginacion {
  
    public DTOEncuestaAplicadaPorCliente() {
    }

    private Long oid;
    private Long oidCliente;
    private Long oidRespuesta;
    private Long oidPregunta;
    private String codigoCliente;

    public String getCodigoCliente() {
        return codigoCliente;
    }
    
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
    public Long getOid() {
        return oid;
    }
    
    public void setOid(Long oid) {
        this.oid = oid;
    }
    
    public Long getOidCliente() {
        return oidCliente;
    }
    
    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }
    
    public Long getOidPregunta() {
        return oidPregunta;
    }
    
    public void setOidPregunta(Long oidPregunta) {
        this.oidPregunta = oidPregunta;
    }
    
    public Long getOidRespuesta() {
        return oidRespuesta;
    }
    
    public void setOidRespuesta(Long oidRespuesta) {
        this.oidRespuesta = oidRespuesta;
    }

}