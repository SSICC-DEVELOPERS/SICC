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

package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;

public class DTOAtencionReclamoREC extends DTOBelcorp  {
    private Long numAtencion = null;
    private Long oidMotivoBloqueo;
    // vbongiov -- GCC-COL-REC-001 -- 2/12/2007
    private String numRecojo;
    
    public DTOAtencionReclamoREC() {
    }

    public Long getNumAtencion() {
        return numAtencion;
    }

    public void setNumAtencion(Long numAtencion) {
        this.numAtencion = numAtencion;
    }

    public Long getOidMotivoBloqueo() {
        return oidMotivoBloqueo;
    }

    public void setOidMotivoBloqueo(Long oidMotivoBloqueo) {
        this.oidMotivoBloqueo = oidMotivoBloqueo;
    }

  public String getNumRecojo() {
    return numRecojo;
  }

  public void setNumRecojo(String numRecojo) {
    this.numRecojo = numRecojo;
  }
}