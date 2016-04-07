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

package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


public class DTOEntradaCriteriosDeBusqueda extends DTOSiccPaginacion  {

  private String nombrePerfil;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

  public DTOEntradaCriteriosDeBusqueda() {
    super();
  }

  public DTOEntradaCriteriosDeBusqueda(String nombrePerfil) {
    super();
    this.nombrePerfil = nombrePerfil;
  }

  public String getNombrePerfil(){
    return this.nombrePerfil;
  }

  public void setNombrePerfil(String nombrePerfil){
    this.nombrePerfil = nombrePerfil;
  }

}
