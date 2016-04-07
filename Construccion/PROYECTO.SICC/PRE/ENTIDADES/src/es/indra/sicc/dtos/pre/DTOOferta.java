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
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 
 * pperanzola - 20/10/2005 - [1] se modifica según el SICC-DMCO-PRE_MAE_INT-GCC-001
 * pperanzola - 30/03/2006 - [2] se modifica para mejora de performance 
 */
public class DTOOferta extends DTOAuditableSICC 
{
  private Long oidOferta;
  private Long oidCabeceraMF;
  private Integer numeroOrden;
  private Long oidEstrategia;
  private Long oidAcceso;
  private String descripcionAcceso;
  private Long oidSubacceso;
  private String descripcionSubacceso;
  private Integer numeroOferta;
  private Long oidArgumentoVenta;
  private String descripcionArgumentoVenta;
  private Boolean despachoCompleto;
  private Boolean despachoAutomatico;
  private Integer numeroGrupos;
  private Integer numeroPaquetes;
  private Integer numeroGruposCondicionantes;
  private Integer numeroGruposCondicionados;
  private String condicionCondicionantes;
  private String condicionCondicionados;
  private Integer primeraPosicionRanking;
  private Integer ultimaPosicionRanking;
  private Boolean codigoVentaGenerado;
  private Boolean matrizFacturacionGenerada;
  private Long oidFormaPago;
  private String descripcionFormaPago;
  private Boolean recuperacionObligatoria;
  private Boolean registroEstadisticoGenerado;
  private Vector ventaExclusiva;
  private Vector promocion;
  private Vector detalleOferta;
  private Vector grupo;
  private Long oidIndCuadre;
  private Boolean matrizFacturada;
  private Long oidCatalogo;
  private String descripcionCatalogo;
  private String descripcionEstrategia;
  ///*[1]
  private Boolean modificacionPromocion;
  private Boolean modificacionVentaExclusiva;
  private Boolean modificacionRangoPromocion;
  private Boolean modificacionGrupo;
  //*/[1]
  private ArrayList listaCodVenta  = new ArrayList(); //[2]
    private Integer cuadre;

  //  Agregado por HRCS - Fecha 15/03/2007 - Incidencia SiCC 20070106
  private Integer ultimaSecuencia;
  
  public DTOOferta()
  {
  }

  public Long getOidOferta()
  {
    return oidOferta;
  }

  public void setOidOferta(Long newOidOferta)
  {
    oidOferta = newOidOferta;
  }

  public Long getOidCabeceraMF()
  {
    return oidCabeceraMF;
  }

  public void setOidCabeceraMF(Long newOidCabeceraMF)
  {
    oidCabeceraMF = newOidCabeceraMF;
  }

  public Integer getNumeroOrden()
  {
    return numeroOrden;
  }

  public void setNumeroOrden(Integer newNumeroOrden)
  {
    numeroOrden = newNumeroOrden;
  }

  public Long getOidEstrategia()
  {
    return oidEstrategia;
  }

  public void setOidEstrategia(Long newOidEstrategia)
  {
    oidEstrategia = newOidEstrategia;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long newOidAcceso)
  {
    oidAcceso = newOidAcceso;
  }

  public String getDescripcionAcceso()
  {
    return descripcionAcceso;
  }

  public void setDescripcionAcceso(String newDescripcionAcceso)
  {
    descripcionAcceso = newDescripcionAcceso;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long newOidSubacceso)
  {
    oidSubacceso = newOidSubacceso;
  }

  public String getDescripcionSubacceso()
  {
    return descripcionSubacceso;
  }

  public void setDescripcionSubacceso(String newDescripcionSubacceso)
  {
    descripcionSubacceso = newDescripcionSubacceso;
  }

  public Integer getNumeroOferta()
  {
    return numeroOferta;
  }

  public void setNumeroOferta(Integer newNumeroOferta)
  {
    numeroOferta = newNumeroOferta;
  }

  public Long getOidArgumentoVenta()
  {
    return oidArgumentoVenta;
  }

  public void setOidArgumentoVenta(Long newOidArgumentoVenta)
  {
    oidArgumentoVenta = newOidArgumentoVenta;
  }

  public String getDescripcionArgumentoVenta()
  {
    return descripcionArgumentoVenta;
  }

  public void setDescripcionArgumentoVenta(String newDescripcionArgumentoVenta)
  {
    descripcionArgumentoVenta = newDescripcionArgumentoVenta;
  }

  public Boolean getDespachoCompleto()
  {
    return despachoCompleto;
  }

  public void setDespachoCompleto(Boolean newDespachoCompleto)
  {
    despachoCompleto = newDespachoCompleto;
  }

  public Boolean getDespachoAutomatico()
  {
    return despachoAutomatico;
  }

  public void setDespachoAutomatico(Boolean newDespachoAutomatico)
  {
    despachoAutomatico = newDespachoAutomatico;
  }

  public Integer getNumeroGrupos()
  {
    return numeroGrupos;
  }

  public void setNumeroGrupos(Integer newNumeroGrupos)
  {
    numeroGrupos = newNumeroGrupos;
  }

  public Integer getNumeroPaquetes()
  {
    return numeroPaquetes;
  }

  public void setNumeroPaquetes(Integer newNumeroPaquetes)
  {
    numeroPaquetes = newNumeroPaquetes;
  }

  public Integer getNumeroGruposCondicionantes()
  {
    return numeroGruposCondicionantes;
  }

  public void setNumeroGruposCondicionantes(Integer newNumeroGruposCondicionantes)
  {
    numeroGruposCondicionantes = newNumeroGruposCondicionantes;
  }

  public Integer getNumeroGruposCondicionados()
  {
    return numeroGruposCondicionados;
  }

  public void setNumeroGruposCondicionados(Integer newNumeroGruposCondicionados)
  {
    numeroGruposCondicionados = newNumeroGruposCondicionados;
  }

  public String getCondicionCondicionantes()
  {
    return condicionCondicionantes;
  }

  public void setCondicionCondicionantes(String newCondicionCondicionantes)
  {
    condicionCondicionantes = newCondicionCondicionantes;
  }

  public String getCondicionCondicionados()
  {
    return condicionCondicionados;
  }

  public void setCondicionCondicionados(String newCondicionCondicionados)
  {
    condicionCondicionados = newCondicionCondicionados;
  }

  public Integer getPrimeraPosicionRanking()
  {
    return primeraPosicionRanking;
  }

  public void setPrimeraPosicionRanking(Integer newPrimeraPosicionRanking)
  {
    primeraPosicionRanking = newPrimeraPosicionRanking;
  }

  public Integer getUltimaPosicionRanking()
  {
    return ultimaPosicionRanking;
  }

  public void setUltimaPosicionRanking(Integer newUltimaPosicionRanking)
  {
    ultimaPosicionRanking = newUltimaPosicionRanking;
  }

  public Boolean getCodigoVentaGenerado()
  {
    return codigoVentaGenerado;
  }

  public void setCodigoVentaGenerado(Boolean newCodigoVentaGenerado)
  {
    codigoVentaGenerado = newCodigoVentaGenerado;
  }

  public Boolean getMatrizFacturacionGenerada()
  {
    return matrizFacturacionGenerada;
  }

  public void setMatrizFacturacionGenerada(Boolean newMatrizFacturacionGenerada)
  {
    matrizFacturacionGenerada = newMatrizFacturacionGenerada;
  }

  public Long getOidFormaPago()
  {
    return oidFormaPago;
  }

  public void setOidFormaPago(Long newOidFormaPago)
  {
    oidFormaPago = newOidFormaPago;
  }

  public String getDescripcionFormaPago()
  {
    return descripcionFormaPago;
  }

  public void setDescripcionFormaPago(String newDescripcionFormaPago)
  {
    descripcionFormaPago = newDescripcionFormaPago;
  }

  public Boolean getRecuperacionObligatoria()
  {
    return recuperacionObligatoria;
  }

  public void setRecuperacionObligatoria(Boolean newRecuperacionObligatoria)
  {
    recuperacionObligatoria = newRecuperacionObligatoria;
  }

  public Boolean getRegistroEstadisticoGenerado()
  {
    return registroEstadisticoGenerado;
  }

  public void setRegistroEstadisticoGenerado(Boolean newRegistroEstadisticoGenerado)
  {
    registroEstadisticoGenerado = newRegistroEstadisticoGenerado;
  }
  public void setGrupo(Vector newGrupo)
  {
    grupo = newGrupo;
  }
  public void setPromocion(Vector newPromocion)
  {
    promocion = newPromocion;
  }
  public void setDetalleOferta(Vector newDetalleOferta)
  {
    detalleOferta = newDetalleOferta;
  }
  public void setVentaExvlusiva(Vector newVentaExclusiva)
  {
    ventaExclusiva = newVentaExclusiva;
  }
  public Vector getGrupo()
  {
    return grupo;
  }
  public Vector getPromocion()
  {
    return promocion;
  }
  public Vector getDetalleOferta()
  {
    return detalleOferta;
  }
  public Vector getVentaExclusiva()
  {
    return ventaExclusiva;
  }

  public Long getOidIndCuadre() {
    return oidIndCuadre;
  }

  public void setOidIndCuadre(Long newOidIndCuadre) {
    oidIndCuadre = newOidIndCuadre;
  }

  public Boolean getMatrizFacturada() {
    return matrizFacturada;
  }

  public void setMatrizFacturada(Boolean newMatrizFacturada) {
    matrizFacturada = newMatrizFacturada;
  }

  public Long getOidCatalogo()
  {
    return oidCatalogo;
  }

  public void setOidCatalogo(Long oidCatalogo)
  {
    this.oidCatalogo = oidCatalogo;
  }

  public String getDescripcionCatalogo() {
    return descripcionCatalogo;
  }

  public void setDescripcionCatalogo(String descripcionCatalogo) {
    this.descripcionCatalogo = descripcionCatalogo;
  }

  public String getDescripcionEstrategia() {
    return descripcionEstrategia;
  }

  public void setDescripcionEstrategia(String descripcionEstrategia) {
    this.descripcionEstrategia = descripcionEstrategia;
  }
  
  ///*[1]
  public Boolean getModificacionPromocion() {
        return modificacionPromocion;
  }

  public void setModificacionPromocion(Boolean modificacionPromocion){
        this.modificacionPromocion = modificacionPromocion;
  }

  public Boolean getModificacionVentaExclusiva(){
        return modificacionVentaExclusiva;
  }

  public void setModificacionVentaExclusiva(Boolean modificacionVentaExclusiva) {
        this.modificacionVentaExclusiva = modificacionVentaExclusiva;
  }

  public Boolean getModificacionRangoPromocion() {
        return modificacionRangoPromocion;
  }

  public void setModificacionRangoPromocion(Boolean modificacionRangoPromocion){
        this.modificacionRangoPromocion = modificacionRangoPromocion;
  }

  public Boolean getModificacionGrupo(){
        return modificacionGrupo;
  }

  public void setModificacionGrupo(Boolean modificacionGrupo) {
        this.modificacionGrupo = modificacionGrupo;
  }
//*/[1]

///*[2]
    public void setListaCodVenta (ArrayList listaCodVentas){
        this.listaCodVenta = listaCodVentas;
    }
    public ArrayList getListaCodVenta (){
        return this.listaCodVenta;
    }
    
    public void agregarCodVenta(String codVenta){
        this.listaCodVenta.add(this.listaCodVenta.size(),codVenta);
    }

    public Integer getCuadre()
    {
        return cuadre;
    }

    public void setCuadre(Integer cuadre)
    {
        this.cuadre = cuadre;
    }
//*/[2]

    public void setUltimaSecuencia(Integer ultimaSecuencia) {
        this.ultimaSecuencia = ultimaSecuencia;
    }

    public Integer getUltimaSecuencia() {
        return ultimaSecuencia;
    }
}