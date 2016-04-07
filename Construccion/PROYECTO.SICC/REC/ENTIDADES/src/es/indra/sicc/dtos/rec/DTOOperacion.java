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
import java.util.ArrayList;
import java.util.Vector;

public class DTOOperacion extends DTOBelcorp {
    
    private Long oidOperacion; 
    private String codOperacion; 
    private String descripcionCorta; 
    private String descripcionLarga; 
    private Long oidPrecios; 
    private Boolean anulacion; 
    private Boolean perdida; 
    private Long oidTIpoSolicitudPerdida; 
    private Boolean esperarMercaderiaFisica; 
    private Boolean devueltoFisicoFactura; 
    private Integer numeroCampaniasHistoria; 
    private Long oidPrecioEnvia; 
    private Long oidBloqueoChequeo; 
    private Boolean faltanteMercaderia; 
    private Boolean ingresaEnvia; 
    private Long oidTipoSolicitud1; 
    private Long oidTipoSolicitud2; 
    private Long oidMensajeGenerar; 
    private Boolean enviaGeneraDevuelve; 
    private Boolean ingresaDevuelve; 
    private Long oidTipoSolicitudGenera; 
    private Long oidAlmacen; 
    private Long oidMovimientoAlmacen; 
    private Boolean devuelveGeneraEnvia; 
    private ArrayList arrayListTiposOperacion; 
    private ArrayList arrayListEliminados; 
    private Vector attriTraducible;
    
    //vbongiov -- GCC-COL-REC-001-- 14/12/2007
    private Boolean recojo;
    private Long oidTipoSolicitudRecojoInicial;
    private Long oidTipoSolicitudPrimerRecojoNoExitoso;
    private Long oidTipoSolicitudSegundoRecojoNoExitoso;
    private Long oidAlmacenPostVenta;
    private Long oidMovimientoAlmacenRecojoInicial;
    private Long oidMovimientoAlmacenRecojoExitoso;
    private Long oidMovimientoAlmacenRecojoNoExitoso;
     
    public DTOOperacion() {
        super();
    }

    public Boolean getAnulacion() {
        return anulacion;
    }

    public void setAnulacion(Boolean anulacion) {
        this.anulacion = anulacion;
    }

    public ArrayList getArrayListEliminados() {
        return arrayListEliminados;
    }

    public void setArrayListEliminados(ArrayList arrayListEliminados) {
        this.arrayListEliminados = arrayListEliminados;
    }

    public ArrayList getArrayListTiposOperacion() {
        return arrayListTiposOperacion;
    }

    public void setArrayListTiposOperacion(ArrayList arrayListTiposOperacion) {
        this.arrayListTiposOperacion = arrayListTiposOperacion;
    }

    public String getCodOperacion() {
        return codOperacion;
    }

    public void setCodOperacion(String codOperacion) {
        this.codOperacion = codOperacion;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public Boolean getDevueltoFisicoFactura() {
        return devueltoFisicoFactura;
    }

    public void setDevueltoFisicoFactura(Boolean devueltoFisicoFactura) {
        this.devueltoFisicoFactura = devueltoFisicoFactura;
    }

    public Boolean getDevuelveGeneraEnvia() {
        return devuelveGeneraEnvia;
    }

    public void setDevuelveGeneraEnvia(Boolean devuelveGeneraEnvia) {
        this.devuelveGeneraEnvia = devuelveGeneraEnvia;
    }

    public Boolean getEnviaGeneraDevuelve() {
        return enviaGeneraDevuelve;
    }

    public void setEnviaGeneraDevuelve(Boolean enviaGeneraDevuelve) {
        this.enviaGeneraDevuelve = enviaGeneraDevuelve;
    }

    public Boolean getEsperarMercaderiaFisica() {
        return esperarMercaderiaFisica;
    }

    public void setEsperarMercaderiaFisica(Boolean esperarMercaderiaFisica) {
        this.esperarMercaderiaFisica = esperarMercaderiaFisica;
    }

    public Boolean getFaltanteMercaderia() {
        return faltanteMercaderia;
    }

    public void setFaltanteMercaderia(Boolean faltanteMercaderia) {
        this.faltanteMercaderia = faltanteMercaderia;
    }

    public Boolean getIngresaDevuelve() {
        return ingresaDevuelve;
    }

    public void setIngresaDevuelve(Boolean ingresaDevuelve) {
        this.ingresaDevuelve = ingresaDevuelve;
    }

    public Boolean getIngresaEnvia() {
        return ingresaEnvia;
    }

    public void setIngresaEnvia(Boolean ingresaEnvia) {
        this.ingresaEnvia = ingresaEnvia;
    }

    public Long getOidMensajeGenerar() {
        return oidMensajeGenerar;
    }

    public void setOidMensajeGenerar(Long iodMensajeGenerar) {
        this.oidMensajeGenerar = iodMensajeGenerar;
    }

    public Integer getNumeroCampaniasHistoria() {
        return numeroCampaniasHistoria;
    }

    public void setNumeroCampaniasHistoria(Integer numeroCampañasHistoria) {
        this.numeroCampaniasHistoria = numeroCampañasHistoria;
    }

    public Long getOidAlmacen() {
        return oidAlmacen;
    }

    public void setOidAlmacen(Long oidAlmacen) {
        this.oidAlmacen = oidAlmacen;
    }

    public Long getOidBloqueoChequeo() {
        return oidBloqueoChequeo;
    }

    public void setOidBloqueoChequeo(Long oidBloqueoChequeo) {
        this.oidBloqueoChequeo = oidBloqueoChequeo;
    }

    public Long getOidMovimientoAlmacen() {
        return oidMovimientoAlmacen;
    }

    public void setOidMovimientoAlmacen(Long oidMovimientoAlmacen) {
        this.oidMovimientoAlmacen = oidMovimientoAlmacen;
    }

    public Long getOidOperacion() {
        return oidOperacion;
    }

    public void setOidOperacion(Long oidOperacion) {
        this.oidOperacion = oidOperacion;
    }

    public Long getOidPrecioEnvia() {
        return oidPrecioEnvia;
    }

    public void setOidPrecioEnvia(Long oidPrecioEnvia) {
        this.oidPrecioEnvia = oidPrecioEnvia;
    }

    public Long getOidPrecios() {
        return oidPrecios;
    }

    public void setOidPrecios(Long oidPrecios) {
        this.oidPrecios = oidPrecios;
    }

    public Long getOidTIpoSolicitudPerdida() {
        return oidTIpoSolicitudPerdida;
    }

    public void setOidTIpoSolicitudPerdida(Long oidTIpoSolicitudPerdida) {
        this.oidTIpoSolicitudPerdida = oidTIpoSolicitudPerdida;
    }

    public Long getOidTipoSolicitud1() {
        return oidTipoSolicitud1;
    }

    public void setOidTipoSolicitud1(Long oidTipoSolicitud1) {
        this.oidTipoSolicitud1 = oidTipoSolicitud1;
    }

    public Long getOidTipoSolicitud2() {
        return oidTipoSolicitud2;
    }

    public void setOidTipoSolicitud2(Long oidTipoSolicitud2) {
        this.oidTipoSolicitud2 = oidTipoSolicitud2;
    }

    public Long getOidTipoSolicitudGenera() {
        return oidTipoSolicitudGenera;
    }

    public void setOidTipoSolicitudGenera(Long oidTipoSolicitudGenera) {
        this.oidTipoSolicitudGenera = oidTipoSolicitudGenera;
    }

    public Boolean getPerdida() {
        return perdida;
    }

    public void setPerdida(Boolean perdida) {
        this.perdida = perdida;
    }

    public Vector getAttriTraducible()
    {
        return attriTraducible;
    }

    public void setAttriTraducible(Vector attriTraducible)
    {
        this.attriTraducible = attriTraducible;
    }

  public Boolean getRecojo() {
    return recojo;
  }

  public void setRecojo(Boolean recojo) {
    this.recojo = recojo;
  }

  public Long getOidTipoSolicitudRecojoInicial() {
    return oidTipoSolicitudRecojoInicial;
  }

  public void setOidTipoSolicitudRecojoInicial(Long oidTipoSolicitudRecojoInicial) {
    this.oidTipoSolicitudRecojoInicial = oidTipoSolicitudRecojoInicial;
  }

  public Long getOidTipoSolicitudPrimerRecojoNoExitoso() {
    return oidTipoSolicitudPrimerRecojoNoExitoso;
  }

  public void setOidTipoSolicitudPrimerRecojoNoExitoso(Long oidTipoSolicitudPrimerRecojoNoExitoso) {
    this.oidTipoSolicitudPrimerRecojoNoExitoso = oidTipoSolicitudPrimerRecojoNoExitoso;
  }

  public Long getOidTipoSolicitudSegundoRecojoNoExitoso() {
    return oidTipoSolicitudSegundoRecojoNoExitoso;
  }

  public void setOidTipoSolicitudSegundoRecojoNoExitoso(Long oidTipoSolicitudSegundoRecojoNoExitoso) {
    this.oidTipoSolicitudSegundoRecojoNoExitoso = oidTipoSolicitudSegundoRecojoNoExitoso;
  }

  public Long getOidAlmacenPostVenta() {
    return oidAlmacenPostVenta;
  }

  public void setOidAlmacenPostVenta(Long oidAlmacenPostVenta) {
    this.oidAlmacenPostVenta = oidAlmacenPostVenta;
  }

  public Long getOidMovimientoAlmacenRecojoInicial() {
    return oidMovimientoAlmacenRecojoInicial;
  }

  public void setOidMovimientoAlmacenRecojoInicial(Long oidMovimientoAlmacenRecojoInicial) {
    this.oidMovimientoAlmacenRecojoInicial = oidMovimientoAlmacenRecojoInicial;
  }

  public Long getOidMovimientoAlmacenRecojoExitoso() {
    return oidMovimientoAlmacenRecojoExitoso;
  }

  public void setOidMovimientoAlmacenRecojoExitoso(Long oidMovimientoAlmacenRecojoExitoso) {
    this.oidMovimientoAlmacenRecojoExitoso = oidMovimientoAlmacenRecojoExitoso;
  }

  public Long getOidMovimientoAlmacenRecojoNoExitoso() {
    return oidMovimientoAlmacenRecojoNoExitoso;
  }

  public void setOidMovimientoAlmacenRecojoNoExitoso(Long oidMovimientoAlmacenRecojoNoExitoso) {
    this.oidMovimientoAlmacenRecojoNoExitoso = oidMovimientoAlmacenRecojoNoExitoso;
  }
    
}
