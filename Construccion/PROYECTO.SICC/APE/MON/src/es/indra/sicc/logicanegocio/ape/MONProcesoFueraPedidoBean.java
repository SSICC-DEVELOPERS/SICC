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
 *
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
//import java.math.BigDecimal;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.ape.DTOConfListaAFP;

import es.indra.sicc.dtos.ape.DTOProcesoFueraPedido;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.util.UtilidadesBD;

public class MONProcesoFueraPedidoBean implements SessionBean  {
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
   * CHANGELOG
   * ---------
   * dmorello, 06/09/2007: BELC400000721 - Al comprobar lista de picado, recupero también el nº de unidades
   * dmorello, 02/07/2007: Se considera que el tamaño de la lista cambiara si se quitan elementos
   * dmorello, 12/03/2009: Incidencia RI 20080820 - Paso a escribir los detalles en tabla APE_LISTA_PICAD_DETAL_TEMP
   * dmorello, 11/06/2009: Incidencia SiCC 20090936 - Modifico llamada a DAOProcesoFueraPedido.obtenerListaPicadoACrear
   *          Ya no le paso el OID linea del primer elem de la lista, sino del primero que sea de un prod fuera caja
   * dmorello, 01/10/2009: Cambio 20090839 - Se setea el nuevo campo DTOListaPicadoDetalle.idZona
   */
  public ArrayList procesarFueraPedido(ArrayList lstProductos) throws MareException {
    UtilidadesLog.info("MONProcesoFueraPedidoBean.procesarFueraPedido(ArrayList lstProductos): Entrada");
    
        if (lstProductos.size()<=0){
            UtilidadesLog.debug("lista de entrada, vacia");
            return null;
        }else{
            UtilidadesLog.debug("lista lstProductos mide: " + lstProductos.size());
            UtilidadesLog.debug("1ra. pos. lista: " + (DTOProcesoFueraPedido)lstProductos.get(0));
            if ((((DTOProcesoFueraPedido)lstProductos.get(0)).getOidConsolidado()==null)
                &&(((DTOProcesoFueraPedido)lstProductos.get(0)).getOidConfiguracionCD()==null)){
                UtilidadesLog.debug("lista lstProductos[0]; nula!");
                return null;
            }
            
            DTOListaPicadoCabecera dtoLPC = null;
            
            Long oidConsolidado = ((DTOProcesoFueraPedido)lstProductos.get(0)).getOidConsolidado();
            Long oidConfiguracionCD = ((DTOProcesoFueraPedido)lstProductos.get(0)).getOidConfiguracionCD();
            DAOProcesoFueraPedido daoPFP = new DAOProcesoFueraPedido();
            
            UtilidadesLog.debug("oidConsolidado/oidConfiguracionCD : " +oidConsolidado+"/"+oidConfiguracionCD);
            
            ArrayList lstAgrupaciones = daoPFP.obtenerAgrupacionesPorConsolidado(oidConsolidado);         
            UtilidadesLog.debug("lista lstAgrupaciones mide: " + lstAgrupaciones.size());
            
            Long oidAgrupacion = null;
            String codAgrupacionDefault = null;
            if (lstAgrupaciones.size()>0) {
                oidAgrupacion = new Long(((DTOConfListaAFP)lstAgrupaciones.get(0)).getOidConfListaAFP().longValue());
                UtilidadesLog.debug("oidAgrupacion: " + oidAgrupacion);
            }else if ((lstAgrupaciones==null) || (lstAgrupaciones.size()==0)){
                codAgrupacionDefault = daoPFP.obtenerFueraPedidoDefault(oidConfiguracionCD);
                UtilidadesLog.debug("codAgrupacionDefault: " + codAgrupacionDefault);
            }
            
            DTOListaPicadoDetalle dtoDetalle = null; 
            ArrayList lstDetallesAInsertar = new ArrayList();
            
                boolean flag = false;
                int mide = lstProductos.size();
                int j = 0;
                while (j < mide && !flag) {
                    if (((DTOProcesoFueraPedido)lstProductos.get(j)).getIndFueraCaja().booleanValue()){
                       flag = true;
                    } else {
                        j++;
                    }
                }
                UtilidadesLog.debug("flag: " + flag);
                if (flag){
                    /*DTOListaPicadoCabecera*/ dtoLPC = daoPFP.obtenerListaPicadoACrear(oidConsolidado, 
                                                                                    ((DTOProcesoFueraPedido)lstProductos.get(j)).getOidLinea(),
                                                                                    ((DTOProcesoFueraPedido)lstProductos.get(j)).getOidConfiguracionCD(),
                                                                                    oidAgrupacion, codAgrupacionDefault);
                    UtilidadesLog.debug("dtoLPC: " + dtoLPC);
                }else{   //Finaliza el caso de uso 
                    UtilidadesLog.info("MONProcesoFueraPedidoBean.procesarFueraPedido(ArrayList lstProductos): Salida");
                    return lstProductos;
                }

            //Por c/elemento de lstProductos que posea lstProductos[i].indFueraCaja en TRUE 
            for (int i = 0; i < lstProductos.size(); i++) {
                if (((DTOProcesoFueraPedido)lstProductos.get(i)).getIndFueraCaja()!=null){           
                    if (((DTOProcesoFueraPedido)lstProductos.get(i)).getIndFueraCaja().booleanValue()){
                            dtoDetalle = new DTOListaPicadoDetalle();
                            UtilidadesLog.debug("crearDetalle true!");                          
                            dtoDetalle.setOidMapaCDDetalle(((DTOProcesoFueraPedido)lstProductos.get(i)).getOidMapaCDDetalle());
                            dtoDetalle.setOidProducto(((DTOProcesoFueraPedido)lstProductos.get(i)).getOidProducto());
                            dtoDetalle.setUnidadesProducto(((DTOProcesoFueraPedido)lstProductos.get(i)).getNumeroUnidades());
                            dtoDetalle.setOidSistemaPicado(((DTOProcesoFueraPedido)lstProductos.get(i)).getOidSistemaPicado());
                            dtoDetalle.setIndicadorImpresion(((DTOProcesoFueraPedido)lstProductos.get(i)).getImpresion());
                            dtoDetalle.setIdZona(Integer.valueOf(((DTOProcesoFueraPedido)lstProductos.get(i)).getIdZona().intValue()));
                            UtilidadesLog.debug("add en lstDetallesAInsertar");                          
                            lstDetallesAInsertar.add(dtoDetalle);
                        lstProductos.remove(i);
                        
                        i--;
                    }        
                }    
            }   //Fin por c/elemento 
            
            if (lstDetallesAInsertar!=null)    
                for (int i = 0; i < lstDetallesAInsertar.size(); i++) {
                    dtoDetalle = (DTOListaPicadoDetalle)lstDetallesAInsertar.get(i);
                    daoPFP.insertarDetalleAFPTemporal(dtoLPC, dtoDetalle);
                }
            
            UtilidadesLog.info("MONProcesoFueraPedidoBean.procesarFueraPedido(ArrayList lstProductos): Salida");
          
            UtilidadesLog.debug("retorno una lstProductos de size: " + lstProductos.size());                          
            return lstProductos;
        }
  }
  
  
  /**
   * Creado por incidencia RI 20080820
   * A partir de los registros en APE_LISTA_PICAD_DETAL_TEMP,
   * este metodo crea o actualiza las listas de picado AFP, luego de lo cual
   * limpia la tabla APE_LISTA_PICAD_DETAL_TEMP
   * @author dmorello
   * @since 29-ene-2009
   * 
   * CHANGELOG
   * ---------
   * dmorello, 24/02/2009: El hashmap cabecerasActualizar pasa a guardar el num de 
   *                       UNIDADES A AGREGAR a la lista, en lugar del total de unidades.
   */
  public void crearListasAFPDefinitivas(Long oidPais) throws MareException {
      UtilidadesLog.info("MONProcesoFueraPedidoBean.crearListasAFPDefinitivas(Long oidPais): Entrada");
      
      DAOProcesoFueraPedido dao = new DAOProcesoFueraPedido();
      
      
      RecordSet rsCabec = dao.obtenerDatosParaCabecerasAFP(oidPais); // Incluye campos OID_LISTA_EXISTENTE y NUM_UNID_LISTA_EXISTENTE
      UtilidadesLog.debug("rsCabec: " + rsCabec);
      if (rsCabec != null && !rsCabec.esVacio()) {
      
          // Obtengo los detalles de la tabla APE_LISTA_PICAD_DETAL_TEMP
          RecordSet rsDetal = dao.obtenerDatosParaDetallesAFP(oidPais);
          
          int cantDetalles = 0;           // cantidad de detalles de la cabecera actual
          int primerDetalleCabecera = 0;  // posicion en rsCabec del primer detalle de la cabecera actual (i)
          int detalle = 0;                // posicion del detalle actual (registro de rsDetal)
          long numUnidadesLista = 0;      // numero de UNIDADES A AGREGAR a la lista actual
          
          ArrayList detallesPreexistentes = null;
          ArrayList detallesActualizar = new ArrayList();
          ArrayList detallesInsertar = new ArrayList();
          HashMap cabecerasActualizar = new HashMap();
          
          Long oidCabecera = null;
          boolean cabeceraPreexistente = false;
          
          long unidadesProd;
          long oidProducto;
          long oidAnaquel;

          // Recorro las cabeceras (registros de rsCabec)
          // y tomo la cantidad de registros de rsDetal dada por rsCabec.CANT_DETALLES
          int size = rsCabec.getRowCount();
          for (int i = 0; i < size; i++) {
          
              // Verifico si ya existe una lista de picado con la cabecera actual
              BigDecimal bdCabec = (BigDecimal)rsCabec.getValueAt(i, "OID_LISTA_EXISTENTE");
              if (bdCabec != null) {
                  oidCabecera = new Long(bdCabec.longValue());
                  cabeceraPreexistente = true;
                  detallesPreexistentes = dao.obtenerListaPicadoDetalles(oidCabecera);
                  //numUnidadesLista = ((BigDecimal)rsCabec.getValueAt(i, "NUM_UNID_LISTA_EXISTENTE")).longValue();
                  numUnidadesLista = 0;
                  UtilidadesLog.debug("Se actualizara la lista de picado con OID cabecera: " + oidCabecera);
              } else {
                  // Armo DTO con los datos de la cabecera a crear
                  DTOListaPicadoCabecera dtoCabe = this.obtenerDTOListaPicadoCabeceraCrear(rsCabec, i);
                  oidCabecera = dao.crearListaPicadoCabecera(dtoCabe);
                  cabeceraPreexistente = false;
                  detallesPreexistentes = null;
                  numUnidadesLista = 0;
                  UtilidadesLog.debug("Se creo la cabecera de lista de picado con OID: " + oidCabecera);
              }
          
              cantDetalles = ((BigDecimal)rsCabec.getValueAt(i, "CANT_PRODUCTOS")).intValue();
              
              // Recorro los detalles de la cabecera actual
              for (int j = 0; j < cantDetalles; j++) {
                  detalle = primerDetalleCabecera + j;
                  unidadesProd = ((BigDecimal)rsDetal.getValueAt(detalle, "NUM_UNID_PROD")).longValue();
                  
                  DTOListaPicadoDetalle dtoDetalle;
                  if (cabeceraPreexistente) {
                      // Ya existe la cabecera de la lista en cuestion
                      // Veo si en la lista existente hay un detalle para el producto y anaquel actuales
                      oidProducto = ((BigDecimal)rsDetal.getValueAt(detalle, "PROD_OID_PROD")).longValue();
                      oidAnaquel = ((BigDecimal)rsDetal.getValueAt(detalle, "MCDD_OID_MAPA_CENT_DIST_DETA")).longValue();
                      dtoDetalle = this.buscoEnlstPicDet(detallesPreexistentes, oidProducto, oidAnaquel);
                      
                      if (dtoDetalle != null) {
                          // Ya existe un detalle -> actualizo el numero de unidades
                          dtoDetalle.setUnidadesProducto(new Long(unidadesProd + dtoDetalle.getUnidadesProducto().longValue()));
                          detallesActualizar.add(dtoDetalle);
                      } else {
                          // Existe cabecera pero no detalle -> hay que crear
                          dtoDetalle = this.obtenerDTOListaPicadoDetalle(rsDetal, detalle, oidCabecera);
                          detallesInsertar.add(dtoDetalle);
                      }
                  } else {
                      // No existe la cabecera, entonces hay que crear el detalle
                      dtoDetalle = this.obtenerDTOListaPicadoDetalle(rsDetal, detalle, oidCabecera);
                      detallesInsertar.add(dtoDetalle);
                  }
                  
                  // Incremento el total de unidades de la lista con las unidades del producto recien tratado
                  numUnidadesLista += unidadesProd;
                  
              } // Fin FOR detalles
              
              // Inserto/actualizo los detalles
              dao.insertarDetalles(detallesInsertar);
              dao.actualizarDetallesCantidad(detallesActualizar);
              
              // Actualizo numero de unidades en la lista
              cabecerasActualizar.put(oidCabecera, new Long(numUnidadesLista));
              
              // Limpio listas y ajusto variables para la proxima cabecera
              primerDetalleCabecera += cantDetalles;
              detallesActualizar.clear();
              detallesInsertar.clear();
              
          } // Fin FOR cabeceras
          
          // Actualizo los totales de unidades de todas las listas procesadas
          dao.actualizarTotalesCabeceras(cabecerasActualizar);
          
          // Vacio la tabla APE_LISTA_PICAD_DETAL_TEMP
          dao.eliminarDetallesTemporales(oidPais);
          
      } else {
          UtilidadesLog.debug("*** No hay listas AFP para crear o actualizar ***");
      }
      
      UtilidadesLog.info("MONProcesoFueraPedidoBean.crearListasAFPDefinitivas(Long oidPais): Salida");
  }
  
    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     */  
  private DTOListaPicadoDetalle buscoEnlstPicDet(ArrayList lista, long oidProducto, long oidMapaCDDetalle) {
      UtilidadesLog.info("MONProcesoFueraPedidoBean.buscoEnlstPicDet(ArrayList lista, long oidProducto, long oidMapaCDDetalle ): Entrada");
      int mide = lista.size();
      for (int i = 0; i < mide; i++) {
          DTOListaPicadoDetalle elemento = (DTOListaPicadoDetalle)lista.get(i);
          if ((elemento.getOidProducto().longValue() == oidProducto)&&(elemento.getOidMapaCDDetalle().longValue() == oidMapaCDDetalle)){
              UtilidadesLog.info("MONProcesoFueraPedidoBean.buscoEnlstPicDet(ArrayList lista, long oidProducto, long oidMapaCDDetalle ): Salida (hay)");
              return elemento;
          }
      }
      UtilidadesLog.info("MONProcesoFueraPedidoBean.buscoEnlstPicDet(ArrayList lista, long oidProducto, long oidMapaCDDetalle ): Salida (no hay)");
      //return new DTOListaPicadoDetalle();
      return null;
  }
  
  private DTOListaPicadoCabecera obtenerDTOListaPicadoCabeceraCrear(RecordSet rsCabec, int i) {
      DTOListaPicadoCabecera dtoCabe = new DTOListaPicadoCabecera();
      Object o;
      
      o = rsCabec.getValueAt(i, "IND_IMPR_CABE");
      if (o != null) {
          String indImpr = o.toString();
          dtoCabe.setIndicadorImpresion(Boolean.valueOf(indImpr.equals("1")));
      }
      
      o = rsCabec.getValueAt(i, "FEC_CREA");
      dtoCabe.setFechaCreacion((Date)o);
      
      o = rsCabec.getValueAt(i, "NUM_SECU_ZONA_RUTA");
      if (o != null) {
          dtoCabe.setSecuenciaZonaRuta(new Long(((BigDecimal)o).longValue()));
      }
      
      o = rsCabec.getValueAt(i, "PERD_OID_PERI");
      dtoCabe.setOidPeriodo(new Long(((BigDecimal)o).longValue()));
      
      o = rsCabec.getValueAt(i, "ZSCC_OID_SECC");
      if (o != null) {
          dtoCabe.setOidSeccion(new Long(((BigDecimal)o).longValue()));
      }
      
      o = rsCabec.getValueAt(i, "CCDI_OID_CONF_CENT_DIST");
      dtoCabe.setOidConfiguracionCD(new Long(((BigDecimal)o).longValue()));
      
      o = rsCabec.getValueAt(i, "LIAR_OID_LINE_ARMA");
      DTOLineaArmado dtoLinea = new DTOLineaArmado();
      dtoLinea.setOid(new Long(((BigDecimal)o).longValue()));
      dtoCabe.setLineaArmado(dtoLinea);
      
      o = rsCabec.getValueAt(i, "ZZON_OID_ZONA");
      if (o != null) {
          dtoCabe.setOidZona(new Long(((BigDecimal)o).longValue()));
      }
      
      o = rsCabec.getValueAt(i, "FEC_FACTU");
      if (o != null) {
          dtoCabe.setFechaFacturacion(new Timestamp(((Date)o).getTime()));
      }
      
      o = rsCabec.getValueAt(i, "ZORG_OID_REGI");
      dtoCabe.setOidRegion(new Long(((BigDecimal)o).longValue()));
      
      o = rsCabec.getValueAt(i, "LIAC_OID_CONF_LAFP_CABE");
      if (o != null) {
          dtoCabe.setOidAgrupacion(new Long(((BigDecimal)o).longValue()));
      }
      
      return dtoCabe;
  }
  
  /**
   * CHANGELOG
   * ---------
   * 01/10/2009 - dmorello, Cambio 20090839 - Se setea en el DTO de salida el campo idZona
   */
  private DTOListaPicadoDetalle obtenerDTOListaPicadoDetalle(RecordSet rsDetal, int i, Long oidCabecera) {
  
      DTOListaPicadoDetalle dtoDetalle = new DTOListaPicadoDetalle();
      dtoDetalle.setOidCabecera(oidCabecera);
      
      long unidadesProd = ((BigDecimal)rsDetal.getValueAt(i, "NUM_UNID_PROD")).longValue();
      dtoDetalle.setUnidadesProducto(new Long(unidadesProd));
      
      String indImpr = rsDetal.getValueAt(i, "IND_IMPR_DETA").toString();
      if (indImpr != null) {
          dtoDetalle.setIndicadorImpresion(Boolean.valueOf(indImpr.equals("1")));
      }

      long oidAnaquel = ((BigDecimal)rsDetal.getValueAt(i, "MCDD_OID_MAPA_CENT_DIST_DETA")).longValue();
      dtoDetalle.setOidMapaCDDetalle(new Long(oidAnaquel));
      
      long oidSistPicado = ((BigDecimal)rsDetal.getValueAt(i, "SIPI_OID_SIST_PICA")).longValue();
      dtoDetalle.setOidSistemaPicado(new Long(oidSistPicado));
      
      long oidProducto = ((BigDecimal)rsDetal.getValueAt(i, "PROD_OID_PROD")).longValue();
      dtoDetalle.setOidProducto(new Long(oidProducto));
      
      Integer idZona = UtilidadesBD.convertirAInteger(rsDetal.getValueAt(i, "NUM_IDZO"));
      dtoDetalle.setIdZona(idZona);
      
      return dtoDetalle;
  }

}