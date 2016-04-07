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

import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

public class DTOListaPicadoDetalle extends DTOBelcorp implements Comparable {
  private Long oid;
  private Long codigoPosicion;
  private Long unidadesProducto;
  private BigDecimal valorLinea;
  private Long numeroCaja;
  private Boolean indicadorImpresion;
  private String nombrePicador;
  private Long unidadesPicadas;
  private Long unidadesChequeadas;
  private Long oidCabecera;
  private Long oidMapaCDDetalle;
  private Long oidTipoCajaEmbalaje;
  private Long oidProducto;
  private Long oidSistemaPicado;
  
  /* Agregado Gpons 04/05/2007 - APE-065*/

  private String numeroAnaquel;
  private String codigoSAP;
  private Long oidSentidoOrden;
  private Long oidOrdenLista;
  
  /* Fin agregado Gpons 04/05/2007 - APE-065*/

  /* Agregado por dmorello - 14/05/2007 */
  private String nombreChequeador;
  private Long numeroEtiqueta;
  
  private String observaciones;
  private Long oidCodigoError;
  private String codigoError;
  
  // Cambio 20090839 - dmorello, 01/10/2009
  private Integer idZona;
  private String descripcionTipoCajaEmbalaje;
  
  //Agregado por cambio 20090839 
  
  private Long unidadesVerificadas;
  
  // sapaza -- Cambios para WCS y MUO -- 22/09/2010
  private Long numeroOrdenSubLinea;
  private String codigoOrdenLista;
  private String codigoSentidoOrden;
  
  public DTOListaPicadoDetalle() {  }
  
  public String getCodigoError() {
      return this.codigoError;
  }
  
  public void setCodigoError(String codigoError) {
      this.codigoError = codigoError;
  }
  
  public String getObservaciones() {
      return this.observaciones;
  }
  
  public void setObservaciones(String observaciones) {
      this.observaciones = observaciones;
  }
  
  public Long getOidCodigoError() {
      return this.oidCodigoError;
  }
  
  public void setOidCodigoError(Long oidCodigoError) {
      this.oidCodigoError = oidCodigoError;
  }
  
  public Long getNumeroEtiqueta() {
      return this.numeroEtiqueta;
  }
  
  public void setNumeroEtiqueta(Long numeroEtiqueta) {
      this.numeroEtiqueta = numeroEtiqueta;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public Long getCodigoPosicion() {
    return codigoPosicion;
  }

  public void setCodigoPosicion(Long codigoPosicion) {
    this.codigoPosicion = codigoPosicion;
  }

  public Long getUnidadesProducto() {
    return unidadesProducto;
  }

  public void setUnidadesProducto(Long unidadesProducto) {
    this.unidadesProducto = unidadesProducto;
  }

  public BigDecimal getValorLinea() {
    return valorLinea;
  }

  public void setValorLinea(BigDecimal valorLinea) {
    this.valorLinea = valorLinea;
  }

  public Long getNumeroCaja() {
    return numeroCaja;
  }

  public void setNumeroCaja(Long numeroCaja) {
    this.numeroCaja = numeroCaja;
  }

  public Boolean getIndicadorImpresion() {
    return indicadorImpresion;
  }

  public void setIndicadorImpresion(Boolean indicadorImpresion) {
    this.indicadorImpresion = indicadorImpresion;
  }

  public String getNombrePicador() {
    return nombrePicador;
  }

  public void setNombrePicador(String nombrePicador) {
    this.nombrePicador = nombrePicador;
  }

  public Long getUnidadesPicadas() {
    return unidadesPicadas;
  }

  public void setUnidadesPicadas(Long unidadesPicadas) {
    this.unidadesPicadas = unidadesPicadas;
  }

  public Long getUnidadesChequeadas() {
    return unidadesChequeadas;
  }

  public void setUnidadesChequeadas(Long unidadesChequeadas) {
    this.unidadesChequeadas = unidadesChequeadas;
  }

  public Long getOidCabecera() {
    return oidCabecera;
  }

  public void setOidCabecera(Long oidCabecera) {
    this.oidCabecera = oidCabecera;
  }

  public Long getOidMapaCDDetalle() {
    return oidMapaCDDetalle;
  }

  public void setOidMapaCDDetalle(Long oidMapaCDDetalle) {
    this.oidMapaCDDetalle = oidMapaCDDetalle;
  }

  public Long getOidTipoCajaEmbalaje() {
    return oidTipoCajaEmbalaje;
  }

  public void setOidTipoCajaEmbalaje(Long oidTipoCajaEmbalaje) {
    this.oidTipoCajaEmbalaje = oidTipoCajaEmbalaje;
  }

  public Long getOidProducto() {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto) {
    this.oidProducto = oidProducto;
  }

  public Long getOidSistemaPicado() {
    return oidSistemaPicado;
  }

  public void setOidSistemaPicado(Long oidSistemaPicado) {
    this.oidSistemaPicado = oidSistemaPicado;
  }
  
  /* Agregado Gpons 04/05/2007 - APE-065*/

  public String getNumeroAnaquel(){
    return this.numeroAnaquel;
  }
  public void setNumeroAnaquel(String numeroAnaquel){
    this.numeroAnaquel = numeroAnaquel;
  }
  
  public String getCodigoSAP(){
    return this.codigoSAP;
  }
  
  public void setCodigoSAP(String codigoSAP){
    this.codigoSAP = codigoSAP;
  }  
  
  public Long getOidSentidoOrden(){
    return this.oidSentidoOrden;
  }

  public void setOidSentidoOrden(Long oidSentidoOrden){
    this.oidSentidoOrden = oidSentidoOrden;
  }

  public Long getOidOrdenLista(){
    return this.oidOrdenLista;
  }  
  
  public void setOidOrdenLista(Long oidOrdenLista){
    this.oidOrdenLista = oidOrdenLista;
  }
  
  public int compareTo(Object o){
    DTOListaPicadoDetalle detalle = (DTOListaPicadoDetalle)o;
    if (ConstantesAPE.COD_ORDEN_POR_PRODUCTO.equals(detalle.codigoOrdenLista)){
        if (ConstantesAPE.COD_ORDENACION_ASCENDENTE.equals(detalle.codigoSentidoOrden)){ 
            //Ordenamos de mayor a menor por código SAP 
            return this.codigoSAP.compareTo(detalle.codigoSAP); 
        } 
        if (ConstantesAPE.COD_ORDENACION_DESCENDENTE.equals(detalle.codigoSentidoOrden)){ 
           //Ordenamos de menor a mayor por código SAP 
           //Es igual que de mayor a menor pero cambiado de signo 
           return -(this.codigoSAP.compareTo(detalle.codigoSAP)); 
        } 
    }

    if (ConstantesAPE.COD_ORDEN_POR_ANAQUEL.equals(detalle.codigoOrdenLista)){
        //Verificamos el sentido del ordenamiento 
        if (ConstantesAPE.COD_ORDENACION_ASCENDENTE.equals(detalle.codigoSentidoOrden)){ 
            //Ordenamos de mayor a menor por númeroAnaquel 
            return this.numeroAnaquel.compareTo(detalle.numeroAnaquel); 
        } 

        if (ConstantesAPE.COD_ORDENACION_DESCENDENTE.equals(detalle.codigoSentidoOrden)){ 
            //Ordenamos de menor a mayor por número de anaquel 
            //Es igual que de mayor a menor pero cambiado de signo 
            return -( this.numeroAnaquel.compareTo( detalle.numeroAnaquel )); 
        } 
    }    
    
      if (ConstantesAPE.COD_ORDEN_POR_SUBLINEA_ANAQUEL.equals(detalle.codigoOrdenLista)){    
          String numeroOrden = obtenerNumeroLinea(this.numeroOrdenSubLinea, 2) + this.numeroAnaquel;
          String numeroOrdenDetalle = obtenerNumeroLinea(detalle.numeroOrdenSubLinea, 2) + detalle.numeroAnaquel;
      
          if (ConstantesAPE.COD_ORDENACION_ASCENDENTE.equals(detalle.codigoSentidoOrden)){ 
              //Ordenamos de mayor a menor por númeroAnaquel 
              return numeroOrden.compareTo(numeroOrdenDetalle); 
          } 

          if (ConstantesAPE.COD_ORDENACION_DESCENDENTE.equals(detalle.codigoSentidoOrden)){ 
              //Ordenamos de menor a mayor por número de anaquel 
              //Es igual que de mayor a menor pero cambiado de signo 
              return -( numeroOrden.compareTo( numeroOrdenDetalle )); 
          } 
      }    

      if (ConstantesAPE.COD_ORDEN_POR_SUBLINEA_PRODUCTO.equals(detalle.codigoOrdenLista)){    
          String numeroOrden = obtenerNumeroLinea(this.numeroOrdenSubLinea, 2) + this.codigoSAP;
          String numeroOrdenDetalle = obtenerNumeroLinea(detalle.numeroOrdenSubLinea, 2) + detalle.codigoSAP;

          if (ConstantesAPE.COD_ORDENACION_ASCENDENTE.equals(detalle.codigoSentidoOrden)){ 
              //Ordenamos de mayor a menor por código SAP 
              return numeroOrden.compareTo(numeroOrdenDetalle); 
          } 
          if (ConstantesAPE.COD_ORDENACION_DESCENDENTE.equals(detalle.codigoSentidoOrden)){ 
             //Ordenamos de menor a mayor por código SAP 
             //Es igual que de mayor a menor pero cambiado de signo 
             return -(numeroOrden.compareTo(numeroOrdenDetalle)); 
          } 
      }
    
  return 0;
  }

  public String getNombreChequeador()
  {
    return nombreChequeador;
  }

  public void setNombreChequeador(String nombreChequeador)
  {
    this.nombreChequeador = nombreChequeador;
  }
  /* Fin agregado Gpons 04/05/2007 - APE-065*/

  public void setIdZona(Integer idZona) {
      this.idZona = idZona;
  }

  public Integer getIdZona() {
      return idZona;
  }

  public void setDescripcionTipoCajaEmbalaje(String descripcionTipoCajaEmbalaje) {
      this.descripcionTipoCajaEmbalaje = descripcionTipoCajaEmbalaje;
  }

  public String getDescripcionTipoCajaEmbalaje() {
      return descripcionTipoCajaEmbalaje;
  }
  
  //Agregado por cambio 20090839 
   public Long getUnidadesVerificadas(){
     return this.unidadesVerificadas;
   }  
   
   public void setUnidadesVerificadas(Long unidadesVerificadas){
     this.unidadesVerificadas = unidadesVerificadas;
   }

    public void setNumeroOrdenSubLinea(Long numeroOrdenSubLinea) {
        this.numeroOrdenSubLinea = numeroOrdenSubLinea;
    }

    public Long getNumeroOrdenSubLinea() {
        return numeroOrdenSubLinea;
    }

    public void setCodigoOrdenLista(String codigoOrdenLista) {
        this.codigoOrdenLista = codigoOrdenLista;
    }

    public String getCodigoOrdenLista() {
        return codigoOrdenLista;
    }

    public void setCodigoSentidoOrden(String codigoSentidoOrden) {
        this.codigoSentidoOrden = codigoSentidoOrden;
    }

    public String getCodigoSentidoOrden() {
        return codigoSentidoOrden;
    }

    private String obtenerNumeroLinea(long numeroLinea, int longitud) {
        int tamano = String.valueOf(numeroLinea).length();
        String resultado ="";
        
        for(int i=0;i<longitud-tamano;i++)
            resultado = resultado + "0";
            
        resultado = resultado + String.valueOf(numeroLinea);    
        
        return resultado;
    }
    
}
