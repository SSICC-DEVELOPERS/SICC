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
package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.LogAPP;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.mare.common.exception.MareException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;
import java.util.Map;
import java.math.BigDecimal;
import es.indra.sicc.dtos.ape.DTOTipoCajaEmbalaje;
import es.indra.sicc.dtos.ape.DTOVolumenProducto;
import es.indra.sicc.dtos.ape.DTOFactoresConversion;
import es.indra.sicc.util.DTOOIDs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MONCalculoCubicajeBean implements SessionBean  {
  private UtilidadesLog log = new UtilidadesLog();
    
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       14/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void calcularCubicajePorVolumen(DTOListaPicadoCabecera listaPicado) throws MareException {
      UtilidadesLog.info("MONCalculoCubicaje.calcularCubicajePorVolumen(DTOListaPicadoCabecera listaPicado): Entrada");
      
      if(log.isDebugEnabled())
        UtilidadesLog.debug("listaPicado: " + listaPicado);
      
      try {
          DAOCalculoCubicaje daoCalculoCubicaje = new DAOCalculoCubicaje();
          
          ArrayList tiposCajas = daoCalculoCubicaje.obtenerTiposCajasCubicaje(listaPicado.getLineaArmado());
          
          if(tiposCajas.size()==0){
              LogAPP.error("No existe ninguna caja con indicador de cubicaje activo");
              return;
          }
          
          ArrayList volumenProductos = daoCalculoCubicaje.obtenerVolumenProductos(listaPicado);
          
          if(volumenProductos.size() > 0)
            this.homogeneizarMedidas(tiposCajas, volumenProductos);
          
          // Ordeno las listas de mayor a menor por capacidad y volumen
          Collections.sort(tiposCajas, new CapacidadComparator());     
          Collections.sort(volumenProductos, new VolumenComparator());    
          
          if(log.isDebugEnabled()) {
            UtilidadesLog.debug("despues de ordenar tiposCajas: " + tiposCajas);
            UtilidadesLog.debug("despues de ordenar volumenProductos: " + volumenProductos);
          }
          
          // Calculo el cubitaje
          BigDecimal volumenACubicar = this.calcularVolumenProductos(volumenProductos);
          
          ArrayList cajasInicial = new ArrayList();
          ArrayList cajas = new ArrayList();
          DTOTipoCajaEmbalaje cajaActual = null;
          DTOTipoCajaEmbalaje cajaAuxiliar = null;
          
          if(volumenACubicar.compareTo(((DTOTipoCajaEmbalaje)tiposCajas.get(0)).getCapacidad())==1){
              UtilidadesLog.debug("volumenACubicar > que la caja con mayor capacidad");
              cajasInicial.add((DTOTipoCajaEmbalaje)tiposCajas.get(0));
              
          } else {
              UtilidadesLog.debug("busco la caja que tenga la capacidad > volumenACubicar");
              int cantTiposCajas = tiposCajas.size();
              DTOTipoCajaEmbalaje dtoTipoCajaEmbalaje = null;
              
              for(int i=0; i< cantTiposCajas; i++){
                  dtoTipoCajaEmbalaje = (DTOTipoCajaEmbalaje)tiposCajas.get(i);
                  if(log.isDebugEnabled())
                    UtilidadesLog.debug("dtoTipoCajaEmbalaje: " + dtoTipoCajaEmbalaje);
                  
                  if(volumenACubicar.compareTo(((DTOTipoCajaEmbalaje)tiposCajas.get(i)).getCapacidad())==-1){
                      cajaAuxiliar = dtoTipoCajaEmbalaje;
                  }
              }
              
              DTOTipoCajaEmbalaje backCajaAuxiliar = (DTOTipoCajaEmbalaje)deepCopy(cajaAuxiliar);
              cajasInicial.add(backCajaAuxiliar);
          }
          
          cajaActual = (DTOTipoCajaEmbalaje)cajasInicial.get(0);
          cajaActual.setVolumenSobrante(cajaActual.getCapacidad());
          DTOTipoCajaEmbalaje cajaNueva = null;
          
          BigDecimal volumenCubicado = new BigDecimal(0);
          int numeroCajas = 1;
          long numeroCajasMaestra=0;
          boolean aplicarSeguridad = true;
          DTOVolumenProducto volumenProductoActual = null;
          
          ArrayList detalles = listaPicado.getDetalles();
          int cantDet = 0;
          int indexNuevoDet = 0;
          DTOListaPicadoDetalle dtoListaPicadoDetalle = null;
          DTOListaPicadoDetalle dtoListaPicadoDetalleCaja = null;
          DTOListaPicadoDetalle backDtoListaPicadoDetalle = null;

          while(!volumenProductos.isEmpty()) {
              volumenProductoActual = (DTOVolumenProducto)volumenProductos.get(0);
              
              if(log.isDebugEnabled())
                UtilidadesLog.debug("volumenProductoActual: " + volumenProductoActual);
              
              // sapaza -- Cambios para WCS y MUO -- 22/09/2010
              //Verificamos si la cantidad de productos corresponde a una caja maestra
              if( (volumenProductoActual.getNumeroUnidadesCajaMaestra().intValue() > 0) &&
                  (volumenProductoActual.getUnidadesProducto().intValue() >= volumenProductoActual.getNumeroUnidadesCajaMaestra().intValue()))  {
                  
                  UtilidadesLog.debug("Aplica el caso de Caja Maestra");
                  volumenCubicado = volumenCubicado.add(volumenProductoActual.getVolumen().multiply(
                      new BigDecimal(volumenProductoActual.getNumeroUnidadesCajaMaestra().toString())));
                  
                  //determinamos el numero de caja maestra que tendra el producto evaluado
                  numeroCajasMaestra = cajas.size() + 1;
                  
                  //Se debe descontar el Nro de unidades en la caja maestra del total de unidades a picar y asignar los productos a esta caja.
                  Integer numeroUnidadesRestante = new Integer(volumenProductoActual.getUnidadesProducto().intValue() - 
                                                        volumenProductoActual.getNumeroUnidadesCajaMaestra().intValue());
                  
                  UtilidadesLog.debug("numeroUnidadesRestante :" + numeroUnidadesRestante);
                  
                  // Busca el ultimo producto en lista de picado que se corresponde con volumenProductoActual                      
                  cantDet = detalles.size();
                  for (int k = 0; k < cantDet; k++) {
                      dtoListaPicadoDetalle = (DTOListaPicadoDetalle)detalles.get(k);
                      
                      if(volumenProductoActual.getOidProducto().equals(dtoListaPicadoDetalle.getOidProducto())){
                          backDtoListaPicadoDetalle = (DTOListaPicadoDetalle)deepCopy(dtoListaPicadoDetalle);
                          dtoListaPicadoDetalleCaja = dtoListaPicadoDetalle;
                          indexNuevoDet = k + 1;
                      }
                  }
                  
                  dtoListaPicadoDetalleCaja.setNumeroCaja(new Long(numeroCajasMaestra));
                  dtoListaPicadoDetalleCaja.setUnidadesProducto(new Long(volumenProductoActual.getNumeroUnidadesCajaMaestra()));
                  dtoListaPicadoDetalleCaja.setOidTipoCajaEmbalaje(volumenProductoActual.getOidTipoCajaMaestra());
                  dtoListaPicadoDetalleCaja.setDescripcionTipoCajaEmbalaje(volumenProductoActual.getDescripcionTipoCajaMaestra()); 
                  
                  if(log.isDebugEnabled())
                    UtilidadesLog.debug("dtoListaPicadoDetalleCaja: " + dtoListaPicadoDetalleCaja);
                  
                  //si el numero de unidades restante es igual a 0, ya no se inserta un nuevo detalle de lista de picado
                  if(numeroUnidadesRestante.intValue() > 0) 
                    detalles.add(indexNuevoDet, backDtoListaPicadoDetalle);

                  cajaNueva = new DTOTipoCajaEmbalaje();
                  cajaNueva.setOid(volumenProductoActual.getOidTipoCajaMaestra());
                  cajaNueva.setDescripcion(volumenProductoActual.getDescripcionTipoCajaMaestra());
                  cajaNueva.setVolumenSobrante(new BigDecimal(0));
                  cajas.add(cajaNueva);
                  
                  volumenProductoActual.setUnidadesProducto(numeroUnidadesRestante);

                  if(log.isDebugEnabled()) {
                    UtilidadesLog.debug("cajaActual Maestra: " + cajaNueva);
                    UtilidadesLog.debug("detalles nueva vuelta Maestra: " + detalles);
                  }  

                  //si el numero de unidades restante es igual a 0, se continua con el siguiente producto
                  if(numeroUnidadesRestante.intValue() == 0) {
                      volumenProductos.remove(0);
                  }                      

                  continue;  
              } else {
                  cajaActual = (DTOTipoCajaEmbalaje)cajasInicial.get(0);
                  boolean despachado = false;
                  
                  if(volumenProductoActual.getVolumen().compareTo(cajaActual.getNivelAplicacion())==1){
                      if(log.isDebugEnabled())
                        UtilidadesLog.debug("Aplica el porcentaje de seguridad del tipo de caja al producto");

                      BigDecimal porcentajeSeguridad = cajaActual.getPorcentajeSeguridad();
                      
                      // sapaza -- Cambios para WCS y MUO -- 22/09/2010
                      if(ConstantesAPE.COD_PICADO_AFRAME.equals(volumenProductoActual.getCodigoSistemaPicado()))
                          porcentajeSeguridad = porcentajeSeguridad.add(volumenProductoActual.getPorcentajeCubicajeAdicional());
                          
                      volumenProductoActual.setVolumen(volumenProductoActual.getVolumen().add(volumenProductoActual.getVolumen().multiply(porcentajeSeguridad).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP)));
                  }
              
                  //Buscamos por las cajas que tienes volumen sobrante para ingresar los productos posibles en dicho espacio
                  for(int i=0; i<cajas.size(); i++) {
                      cajaActual = (DTOTipoCajaEmbalaje)cajas.get(i);
                      numeroCajas = i+1;
                      
                      //la caja tiene volumen sobrante, verificamos si puede entrar algun producto  
                      if(cajaActual.getVolumenSobrante().longValue() > 0) {
                          boolean crearDetalle = true;
                          BigDecimal unidades = cajaActual.getVolumenSobrante().divide(volumenProductoActual.getVolumen(),0,BigDecimal.ROUND_DOWN);
                          if(log.isDebugEnabled()) { 
                            UtilidadesLog.debug("numero cajaActual: " + (i+1));
                            UtilidadesLog.debug("unidades maxima en la caja: " + unidades);
                            UtilidadesLog.debug("unidades restantes: " + volumenProductoActual.getUnidadesProducto());
                          }  
                                                    
                          if(unidades.intValue() >= volumenProductoActual.getUnidadesProducto())  {
                            unidades = new BigDecimal(volumenProductoActual.getUnidadesProducto());
                            crearDetalle = false;
                          }  
                          
                          if(unidades.longValue() > 0){
                              
                              volumenCubicado = volumenCubicado.add(volumenProductoActual.getVolumen().multiply(unidades));
                              cajaActual.setVolumenSobrante(cajaActual.getVolumenSobrante().subtract(volumenProductoActual.getVolumen().multiply(unidades)));
                              
                              // Busca el ultimo producto en lista de picado que se corresponde con volumenProductoActual                      
                              cantDet = detalles.size();
                              for (int k = 0; k < cantDet; k++) {
                                  dtoListaPicadoDetalle = (DTOListaPicadoDetalle)detalles.get(k);
                                  
                                  if(volumenProductoActual.getOidProducto().equals(dtoListaPicadoDetalle.getOidProducto())){
                                      if(crearDetalle)
                                        backDtoListaPicadoDetalle = (DTOListaPicadoDetalle)deepCopy(dtoListaPicadoDetalle);
                                      dtoListaPicadoDetalleCaja = dtoListaPicadoDetalle;
                                      indexNuevoDet = k + 1;
                                  }
                              }
                              
                              dtoListaPicadoDetalleCaja.setNumeroCaja(new Long(numeroCajas));
                              dtoListaPicadoDetalleCaja.setUnidadesProducto(Long.valueOf(unidades.toString()));
                              dtoListaPicadoDetalleCaja.setOidTipoCajaEmbalaje(cajaActual.getOid());
                              dtoListaPicadoDetalleCaja.setDescripcionTipoCajaEmbalaje(cajaActual.getDescripcion()); 
                              
                              if(log.isDebugEnabled())
                                UtilidadesLog.debug("dtoListaPicadoDetalleCaja: " + dtoListaPicadoDetalleCaja);
                              
                              if(crearDetalle)
                                detalles.add(indexNuevoDet, backDtoListaPicadoDetalle);
                          } else if(unidades.longValue()==0 && cajaActual.getVolumenSobrante().equals(cajaActual.getCapacidad())){
                              throw new MareException("La volumen de la caja es menor que el volumen del producto ");
                          }                          
                      
                          volumenProductoActual.setUnidadesProducto(new Integer(volumenProductoActual.getUnidadesProducto().intValue()- 
                                                                    Integer.valueOf(unidades.toString()).intValue()));
                          
                          //si se ha atendido la cantidad solicitado del producto actual, se sigue con el siguiente producto                                          
                          if(volumenProductoActual.getUnidadesProducto() == 0) {
                              volumenProductos.remove(0);
                              despachado = true;
                              break;                                          
                          }                                                                    
                          
                      }
                  }  
                  
                  if(!despachado) {
                      //si queda unidades pendientes x despachar, entonces empezamos a abrir nuevas cajas para despachar lo restante
                      while(volumenProductoActual.getUnidadesProducto() > 0) {
                          cajaActual = (DTOTipoCajaEmbalaje)deepCopy((DTOTipoCajaEmbalaje)cajasInicial.get(0));
                          cajas.add(cajaActual);
                          cajaActual.setVolumenSobrante(cajaActual.getCapacidad());
                          numeroCajas = cajas.size();
                          boolean crearDetalle = true;
                       
                          BigDecimal unidades = cajaActual.getVolumenSobrante().divide(volumenProductoActual.getVolumen(),0,BigDecimal.ROUND_DOWN);
                          if(unidades.longValue()==0 && cajaActual.getVolumenSobrante().equals(cajaActual.getCapacidad())){
                            throw new MareException("La volumen de la caja es menor que el volumen del producto ");
                          } 
                          
                          //validamos si cubre la cantidad de productos solicitados
                          if(unidades.intValue() >= volumenProductoActual.getUnidadesProducto())  {
                            unidades = new BigDecimal(volumenProductoActual.getUnidadesProducto());
                            crearDetalle = false;
                          }
                          
                          volumenCubicado = volumenCubicado.add(volumenProductoActual.getVolumen().multiply(unidades));
                          cajaActual.setVolumenSobrante(cajaActual.getVolumenSobrante().subtract(volumenProductoActual.getVolumen().multiply(unidades)));
                          
                          cantDet = detalles.size();
                          for (int k = 0; k < cantDet; k++) {
                              dtoListaPicadoDetalle = (DTOListaPicadoDetalle)detalles.get(k);
                              
                              if(volumenProductoActual.getOidProducto().equals(dtoListaPicadoDetalle.getOidProducto())){
                                  dtoListaPicadoDetalleCaja = dtoListaPicadoDetalle;
                              }
                          }
                          
                          cantDet = detalles.size();
                          for (int k = 0; k < cantDet; k++) {
                              dtoListaPicadoDetalle = (DTOListaPicadoDetalle)detalles.get(k);
                              
                              if(volumenProductoActual.getOidProducto().equals(dtoListaPicadoDetalle.getOidProducto())){
                                  if(crearDetalle)
                                    backDtoListaPicadoDetalle = (DTOListaPicadoDetalle)deepCopy(dtoListaPicadoDetalle);
                                  dtoListaPicadoDetalleCaja = dtoListaPicadoDetalle;
                                  indexNuevoDet = k + 1;
                              }
                          }                          
                          
                          dtoListaPicadoDetalleCaja.setNumeroCaja(new Long(numeroCajas));
                          dtoListaPicadoDetalleCaja.setUnidadesProducto(Long.valueOf(unidades.toString()));
                          dtoListaPicadoDetalleCaja.setOidTipoCajaEmbalaje(cajaActual.getOid());
                          dtoListaPicadoDetalleCaja.setDescripcionTipoCajaEmbalaje(cajaActual.getDescripcion()); 
                          
                          volumenProductoActual.setUnidadesProducto(new Integer(volumenProductoActual.getUnidadesProducto().intValue()- 
                                                                    Integer.valueOf(unidades.toString()).intValue()));
                          
                          if(crearDetalle)
                            detalles.add(indexNuevoDet, backDtoListaPicadoDetalle);
                          
                          //si se ha atendido la cantidad solicitado del producto actual, se sigue con el siguiente producto                                          
                          if(volumenProductoActual.getUnidadesProducto() == 0) {
                              volumenProductos.remove(0);
                              break;                                          
                          }  
                      }    
                  }
                  
              }
          }    
          
          // Reacomodo la ultima caja
          this.reubicarProductosUltimaCaja(listaPicado, tiposCajas, volumenProductos, cajas, numeroCajas);
          
          listaPicado.setNumeroTotalCajas(new Long(cajas.size()));
          listaPicado.setVolumen(volumenCubicado);
          
          if(log.isDebugEnabled())
            UtilidadesLog.debug("listaPicado salida: " + listaPicado);
          
          UtilidadesLog.info("MONCalculoCubicaje.calcularCubicajePorVolumen(DTOListaPicadoCabecera listaPicado): Salida");
          
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
      } 
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       15/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void reubicarProductosUltimaCaja(DTOListaPicadoCabecera listaPicado, ArrayList tiposCajas, ArrayList volumenProductos, ArrayList cajas, int numeroCajas) throws MareException {
      UtilidadesLog.info("MONCalculoCubicaje.reubicarProductosUltimaCaja(DTOListaPicadoCabecera listaPicado, ArrayList tiposCajas, ArrayList volumenProductos, ArrayList cajas, Integer numeroCajas): Entrada");
      
      if(numeroCajas > 1){
          UtilidadesLog.debug("Hay mas de una caja");
          
          // sapaza -- Cambios para WCS y MUO -- 22/09/2010
          DTOTipoCajaEmbalaje ultimaCaja = null;
          for(int j=cajas.size()-1; j>=0;j--) {
              ultimaCaja = (DTOTipoCajaEmbalaje)cajas.get(j);
              
              if(ultimaCaja.getCapacidad()==null)
                continue;
              else
                break;
          }
          
          if(ultimaCaja.getCapacidad() != null) {
          
              BigDecimal volumenUtilizadoUltimaCaja = ultimaCaja.getCapacidad().subtract(ultimaCaja.getVolumenSobrante());  
             
              UtilidadesLog.debug("volumenUtilizadoUltimaCaja: " + volumenUtilizadoUltimaCaja);
              UtilidadesLog.debug("ultimaCaja.getCapacidadMinima(): " + ultimaCaja.getCapacidadMinima());
              
              DTOTipoCajaEmbalaje cajaAuxiliar = null ;
              
              if(volumenUtilizadoUltimaCaja.compareTo(ultimaCaja.getCapacidadMinima())==-1){
                  // Arma lista con los detalles a modificar
                  ArrayList detallesAModificar = new ArrayList();
                  int cantProd = listaPicado.getDetalles().size();
                  ArrayList detalles = listaPicado.getDetalles();
                  DTOListaPicadoDetalle dtoListaPicadoDetalle = null;
                  
                  for (int j = 0; j < cantProd; j++) {
                     dtoListaPicadoDetalle = (DTOListaPicadoDetalle)detalles.get(j);
                     
                     if((dtoListaPicadoDetalle.getNumeroCaja()!= null) && (dtoListaPicadoDetalle.getNumeroCaja().longValue()== numeroCajas)){
                        detallesAModificar.add(dtoListaPicadoDetalle);
                     }
                  }
                  
                  // Busca una caja menor para los productos
                  int cantTiposCajas = tiposCajas.size();
                  DTOTipoCajaEmbalaje dtoTipoCajaEmbalaje = null;
                  
                  for(int i=0; i< cantTiposCajas; i++){
                      dtoTipoCajaEmbalaje = (DTOTipoCajaEmbalaje)tiposCajas.get(i);
                      UtilidadesLog.debug("dtoTipoCajaEmbalaje: " + dtoTipoCajaEmbalaje);
                      
                      if(volumenUtilizadoUltimaCaja.compareTo(dtoTipoCajaEmbalaje.getCapacidad())==-1){
                          cajaAuxiliar = (DTOTipoCajaEmbalaje)deepCopy(dtoTipoCajaEmbalaje);
                      }
                  }
                  
                  // Asigna los productos a la caja menor
                  if(cajaAuxiliar!=null){
                      int cantDetMod = detallesAModificar.size();
                      
                      for(int k=0; k < cantDetMod; k++){
                          dtoListaPicadoDetalle = (DTOListaPicadoDetalle)detallesAModificar.get(k);
                          dtoListaPicadoDetalle.setOidTipoCajaEmbalaje(cajaAuxiliar.getOid());
                          dtoListaPicadoDetalle.setDescripcionTipoCajaEmbalaje(cajaAuxiliar.getDescripcion());
                      }
                  } else {
                      UtilidadesLog.debug("No se encontró una caja no realizamos ninguna acción");
                  }                    
              }
          }
          
      }
      UtilidadesLog.info("MONCalculoCubicaje.reubicarProductosUltimaCaja(DTOListaPicadoCabecera listaPicado, ArrayList tiposCajas, ArrayList volumenProductos, ArrayList cajas, Integer numeroCajas): Salida");
  }
  

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       15/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public BigDecimal calcularVolumenProductos(ArrayList volumenProductos) throws MareException {
    UtilidadesLog.info("MONCalculoCubicaje.calcularVolumenProductos(ArrayList volumenProductos): Entrada");
    
    BigDecimal volumenTotal = new BigDecimal(0);
    int cantVolumenProductos = volumenProductos.size();
    DTOVolumenProducto dtoVolumenProducto = null;
    
    for(int j=0; j< cantVolumenProductos; j++){
        dtoVolumenProducto = (DTOVolumenProducto)volumenProductos.get(j);
        UtilidadesLog.debug("dtoVolumenProducto: " + dtoVolumenProducto);
    
        volumenTotal = volumenTotal.add(dtoVolumenProducto.getVolumen().multiply(new BigDecimal(dtoVolumenProducto.getUnidadesProducto().toString())));
        
        UtilidadesLog.debug("volumenTotal parcial: " + volumenTotal);    
    }
    
    UtilidadesLog.debug("volumenTotal: " + volumenTotal);    
    
    UtilidadesLog.info("MONCalculoCubicaje.calcularVolumenProductos(ArrayList volumenProductos): Salida");
    return volumenTotal;
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       15/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void homogeneizarMedidas(ArrayList tiposCajas, ArrayList volumenProductos) throws MareException {
      UtilidadesLog.info("MONCalculoCubicaje.homogeneizarMedidas(ArrayList tiposCajas, ArrayList volumenProductos): Entrada");
      
      HashMap oidUniMedH = new HashMap();
      int cantTiposCajas = tiposCajas.size();
      int cantVolumenProductos = volumenProductos.size();
      DTOTipoCajaEmbalaje dtoTipoCajaEmbalaje = null;
      DTOVolumenProducto dtoVolumenProducto = null;
      DTOOIDs oidUnidesMed = new DTOOIDs();
      DAOCalculoCubicaje daoCalculoCubicaje = new DAOCalculoCubicaje();
      
      for(int i=0; i< cantTiposCajas; i++){
          dtoTipoCajaEmbalaje = (DTOTipoCajaEmbalaje)tiposCajas.get(i);
          UtilidadesLog.debug("dtoTipoCajaEmbalaje: " + dtoTipoCajaEmbalaje);
      
          if(oidUniMedH.get(dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad())==null){
              UtilidadesLog.debug("Hash caja: " + dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad());
              oidUniMedH.put(dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad(), dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad());
          }
      }
      
      for(int j=0; j< cantVolumenProductos; j++){
          dtoVolumenProducto = (DTOVolumenProducto)volumenProductos.get(j);
          UtilidadesLog.debug("dtoVolumenProducto: " + dtoVolumenProducto);
      
          if(oidUniMedH.get(dtoVolumenProducto.getOidUnidadMedidaVolumen())==null){
              UtilidadesLog.debug("Hash voluProd: " + dtoVolumenProducto.getOidUnidadMedidaVolumen());
              oidUniMedH.put(dtoVolumenProducto.getOidUnidadMedidaVolumen(), dtoVolumenProducto.getOidUnidadMedidaVolumen());
          }
      }
      
      if(oidUniMedH.size()>0){
          UtilidadesLog.debug("Hay unidades de medida");
          
          Long[] oids = new Long[oidUniMedH.size()];
          int k = 0;
          Iterator it = oidUniMedH.entrySet().iterator();         
              
          while (it.hasNext()) { 
              Map.Entry entry = (Map.Entry) it.next();
               oids[k] = (Long)entry.getKey();
               UtilidadesLog.debug("oids[k]: " + oids[k]);
               k++;
          }      
      
          oidUnidesMed.setOids(oids);
          oidUnidesMed.setOidPais(dtoVolumenProducto.getOidPais());
          
          // Obtiene los factores de conversion
          ArrayList factoresConv = daoCalculoCubicaje.obtenerFactoresConversionAMedidaEstandar(oidUnidesMed);
          
          int cantFactoresConv = factoresConv.size();
          HashMap factConvH = new HashMap();
          DTOFactoresConversion dtoFactoresConversion = new DTOFactoresConversion();
          
          for(int m=0; m< cantFactoresConv; m++){
              dtoFactoresConversion = (DTOFactoresConversion)factoresConv.get(m);
              UtilidadesLog.debug("dtoFactoresConversion: " + dtoFactoresConversion);
          
              if(factConvH.get(dtoFactoresConversion.getOidUnidadMedidaOrigen())==null){
                  factConvH.put(dtoFactoresConversion.getOidUnidadMedidaOrigen(), dtoFactoresConversion.getFactorConversion());
              }
          }
          
          // Convierto las unidades de los tipo caja en unidades estandar
          Long oidUniMedOrig = null;
          BigDecimal factConv = null;
          
          for(int i=0; i< cantTiposCajas; i++){
              dtoTipoCajaEmbalaje = (DTOTipoCajaEmbalaje)tiposCajas.get(i);
              UtilidadesLog.debug("dtoTipoCajaEmbalaje: " + dtoTipoCajaEmbalaje);
          
              oidUniMedOrig = dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad();
              factConv = (BigDecimal)factConvH.get(oidUniMedOrig);
              UtilidadesLog.debug("factConv: " + factConv);
              
              if(factConv!=null){
                  dtoTipoCajaEmbalaje.setCapacidad(dtoTipoCajaEmbalaje.getCapacidad().multiply(factConv));
                  dtoTipoCajaEmbalaje.setCapacidadMinima(dtoTipoCajaEmbalaje.getCapacidadMinima().multiply(factConv));
                  dtoTipoCajaEmbalaje.setNivelAplicacion(dtoTipoCajaEmbalaje.getNivelAplicacion().multiply(factConv));
              }
          }
          
          UtilidadesLog.debug("tiposCajas: " + tiposCajas);
          
          for(int j=0; j< cantVolumenProductos; j++){
              dtoVolumenProducto = (DTOVolumenProducto)volumenProductos.get(j);
              UtilidadesLog.debug("dtoVolumenProducto: " + dtoVolumenProducto);
          
              oidUniMedOrig = dtoVolumenProducto.getOidUnidadMedidaVolumen();
              factConv = (BigDecimal)factConvH.get(oidUniMedOrig);
              UtilidadesLog.debug("factConv: " + factConv);
              
              if(factConv!=null){
                  dtoVolumenProducto.setVolumen(dtoVolumenProducto.getVolumen().multiply(factConv));
              }
          }
          
          UtilidadesLog.debug("volumenProductos: " + volumenProductos);
      }      
      
      UtilidadesLog.info("MONCalculoCubicaje.homogeneizarMedidas(ArrayList tiposCajas, ArrayList volumenProductos): Salida");
  }

  
  /**
     * Retorna una copia del objeto pasado por parametro.
     */
    private Object deepCopy(Object oldObj) throws MareException {
        UtilidadesLog.info("MONVariablesVentaBean.deepCopy(Object oldObj):Entrada");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
 
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
 
            oos.writeObject(oldObj);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            UtilidadesLog.info("MONVariablesVentaBean.deepCopy(Object oldObj):Salida");
            return ois.readObject();
        } catch(Exception e) {
            UtilidadesLog.error("ERROR ", e);
            UtilidadesLog.debug("Exception en deepCopy = " + e);
            throw new MareException(e);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch(Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                UtilidadesLog.debug("Exception en deepCopy = " + ex);
                throw new MareException(ex);
            }
        }
    }

}