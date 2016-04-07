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

import es.indra.sicc.util.DTOBelcorp;


public class DTOProcesoFueraPedido extends DTOBelcorp {
    private Long oidProducto;
    private Long oidSublinea;
    private Long oidLinea;
    private Long oidMapaCDDetalle;
    private Long numeroUnidades;
    private Long oidZonaArmando;
    private Boolean impresion;
    private Long oidSistemaPicado;
    private Boolean indFueraCaja;
    private Long oidConfiguracionCD;
    private Long oidConsolidado;
    private String numeroAnaquel;
    
    // Cambio 20090839 - dmorello, 03/09/2009
    private String letraParaAnaquel;
    
    //SCS (15/05/2007) agregado x inc.: 441
    private Long idZona;
    private Long codigoSublinea;
    
  /* Agregado Gpons 04/05/2007 - APE-065*/
    private String codProducto;  
  /* Fin agregado Gpons 04/05/2007 - APE-065*/

    private Long numeroOrdenSubLinea;

    public DTOProcesoFueraPedido() {
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidSublinea(Long oidSublinea) {
        this.oidSublinea = oidSublinea;
    }

    public Long getOidSublinea() {
        return oidSublinea;
    }

    public void setOidLinea(Long oidLinea) {
        this.oidLinea = oidLinea;
    }

    public Long getOidLinea() {
        return oidLinea;
    }

    public void setOidMapaCDDetalle(Long oidMapaCDDetalle) {
        this.oidMapaCDDetalle = oidMapaCDDetalle;
    }

    public Long getOidMapaCDDetalle() {
        return oidMapaCDDetalle;
    }

    public void setNumeroUnidades(Long numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    public Long getNumeroUnidades() {
        return numeroUnidades;
    }

    public void setOidZonaArmando(Long oidZonaArmando) {
        this.oidZonaArmando = oidZonaArmando;
    }

    public Long getOidZonaArmando() {
        return oidZonaArmando;
    }

    public void setImpresion(Boolean impresion) {
        this.impresion = impresion;
    }

    public Boolean getImpresion() {
        return impresion;
    }

    public void setOidSistemaPicado(Long oidSistemaPicado) {
        this.oidSistemaPicado = oidSistemaPicado;
    }

    public Long getOidSistemaPicado() {
        return oidSistemaPicado;
    }

    public void setIndFueraCaja(Boolean indFueraCaja) {
        this.indFueraCaja = indFueraCaja;
    }

    public Boolean getIndFueraCaja() {
        return indFueraCaja;
    }

    public void setOidConfiguracionCD(Long oidConfiguracionCD) {
        this.oidConfiguracionCD = oidConfiguracionCD;
    }

    public Long getOidConfiguracionCD() {
        return oidConfiguracionCD;
    }

    public void setOidConsolidado(Long oidConsolidado) {
        this.oidConsolidado = oidConsolidado;
    }

    public Long getOidConsolidado() {
        return oidConsolidado;
    }

    public void setNumeroAnaquel(String numeroAnaquel) {
        this.numeroAnaquel = numeroAnaquel;
    }

    public String getNumeroAnaquel() {
        return numeroAnaquel;
    }

    
  /* Agregado Gpons 04/05/2007 - APE-065*/
    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getCodProducto() {
        return codProducto;
    }


  public void setIdZona(Long idZona) {
    this.idZona = idZona;
  }


  public Long getIdZona() {
    return idZona;
  }


  public void setCodigoSublinea(Long codigoSublinea) {
    this.codigoSublinea = codigoSublinea;
  }


  public Long getCodigoSublinea() {
    return codigoSublinea;
  }
  /* Fin agregado Gpons 04/05/2007 - APE-065*/

  public void setLetraParaAnaquel(String letraParaAnaquel) {
    this.letraParaAnaquel = letraParaAnaquel;
  }

  public String getLetraParaAnaquel() {
    return letraParaAnaquel;
  }

    public void setNumeroOrdenSubLinea(Long numeroOrdenSubLinea) {
        this.numeroOrdenSubLinea = numeroOrdenSubLinea;
    }

    public Long getNumeroOrdenSubLinea() {
        return numeroOrdenSubLinea;
    }
}
