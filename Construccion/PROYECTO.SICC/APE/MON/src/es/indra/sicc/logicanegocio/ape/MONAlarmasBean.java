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
import es.indra.sicc.cmn.negocio.correo.DTOCorreoElectronico;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronico;
import es.indra.sicc.dtos.ape.DTOFactoresConversion;
import es.indra.sicc.dtos.mae.DTOProducto;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ape.DTOComprobarAlarmas;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOTipoCajaEmbalaje;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronicoHome;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.dtos.ape.DTOErrorValoresCubicaje;

public class MONAlarmasBean implements SessionBean  {
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
    * Fecha:       23/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * @modificaciones 
    * BELC400000353 26/04/2007 Cristian Valenzuela
    * BELC400000380/353 10/05/2007 Emilio Iraola
    * BELC400000515  21/06/2007 vbongiov
    */
  public DTOColeccion comprobarAlarmasValoresCubicaje(DTOComprobarAlarmas dtoe) throws MareException {
      UtilidadesLog.info("MONAlarmas.comprobarAlarmasValoresCubicaje(DTOComprobarAlarmas dtoe): Entrada");
      
      try { 
          DAOAlarmas daoAlarmas = new DAOAlarmas();
          DTOColeccion dtoColeccion = new DTOColeccion();
          ArrayList listaErrores = new ArrayList();
          DTOErrorValoresCubicaje dtoErrorValoresCubicaje = null;
          DTOTipoCajaEmbalaje dtoTipoCajaEmbalaje = null;
          DTOTipoCajaEmbalaje dtoTipoCajaEmbalajeSiguiente = null;
          Boolean indicadorCubicaje = null;
          String linea;
          
          ArrayList cajas = daoAlarmas.obtenerDatosCajas(dtoe);
          
          this.homogeneizarMedidas(cajas);
          
          // Ordeno las cajas de mayor a menor por capacidad 
          // vbongiov -- BELC400000567 -- 13/07/2007
          // y de mayor a menor capacidad minima
          Collections.sort(cajas, new CapacidadAlarmaComparator());  
          
          UtilidadesLog.debug("cajas: " + cajas);
          
          ArrayList lineasConEmbalajeParaCubicaje = new ArrayList();
          ArrayList lineasSinEmbalajeParaCubicaje = new ArrayList();
          int cantCajas = cajas.size();
          
          for (int i = 0; i < cantCajas; i++) {
              dtoTipoCajaEmbalaje = (DTOTipoCajaEmbalaje)cajas.get(i);
              UtilidadesLog.debug("dtoTipoCajaEmbalaje: " + dtoTipoCajaEmbalaje);
              
              indicadorCubicaje = dtoTipoCajaEmbalaje.getIndicadorCubicaje();
              linea = dtoTipoCajaEmbalaje.getDescripcionLinea();
              UtilidadesLog.debug("linea: " + linea);
              
              if (indicadorCubicaje != null && indicadorCubicaje.booleanValue() == true) {
                  UtilidadesLog.debug("indicadorCubicaje == true");
                  
                  // vbongiov -- LG_V400000016 -- 27/09/2007
                  if (dtoTipoCajaEmbalaje.getNivelAplicacion().compareTo(dtoTipoCajaEmbalaje.getCapacidadMinima()) >= 0) {
                      dtoErrorValoresCubicaje = new DTOErrorValoresCubicaje();
                      dtoErrorValoresCubicaje.setDescripcionLinea(dtoTipoCajaEmbalaje.getDescripcionLinea());
                      dtoErrorValoresCubicaje.setInformacionRegistroProblemas(dtoTipoCajaEmbalaje.getDescripcion());
                      dtoErrorValoresCubicaje.setError("APE-0042");
                      
                      listaErrores.add(dtoErrorValoresCubicaje);
                  }
                  
                  if((i+1)!=cantCajas){
                      UtilidadesLog.debug("Hay caja siguiente");
                      
                      dtoTipoCajaEmbalajeSiguiente = (DTOTipoCajaEmbalaje)cajas.get(i+1);
                      // vbongiov -- LG_V400000016 -- 27/09/2007
                      if (dtoTipoCajaEmbalajeSiguiente.getOid() != null &&
                          dtoTipoCajaEmbalaje.getCapacidadMinima().compareTo(dtoTipoCajaEmbalajeSiguiente.getCapacidad()) <= 0) {
                          dtoErrorValoresCubicaje = new DTOErrorValoresCubicaje();
                          dtoErrorValoresCubicaje.setDescripcionLinea(dtoTipoCajaEmbalaje.getDescripcionLinea());
                          dtoErrorValoresCubicaje.setInformacionRegistroProblemas(dtoTipoCajaEmbalaje.getDescripcion());
                          dtoErrorValoresCubicaje.setError("APE-0043;" + dtoTipoCajaEmbalaje.getDescripcion() 
                                                            + ";" + dtoTipoCajaEmbalajeSiguiente.getDescripcion());
                          
                          listaErrores.add(dtoErrorValoresCubicaje);
                      }
                  }
                  
                  
                  if (lineasSinEmbalajeParaCubicaje.contains(linea)) {
                      UtilidadesLog.debug("saco la linea a lineasSinEmbalajeParaCubicaje");
                      lineasSinEmbalajeParaCubicaje.remove(linea);
                  }
                  if (!lineasConEmbalajeParaCubicaje.contains(linea)) {
                      UtilidadesLog.debug("agrego la linea a lineasConEmbalajeParaCubicaje");
                      lineasConEmbalajeParaCubicaje.add(linea);
                  }
                  
              } else {
                  UtilidadesLog.debug("No hay tipo caja embalaje (o su Ind Cubicaje 'false')");
                  if (!lineasConEmbalajeParaCubicaje.contains(linea) && !lineasSinEmbalajeParaCubicaje.contains(linea)) {
                          UtilidadesLog.debug("agrego la linea a lineasSinEmbalajeParaCubicaje");
                          lineasSinEmbalajeParaCubicaje.add(linea);
                  }
              }
              
          } // fin for
          
          int cantLineasNoCubic = lineasSinEmbalajeParaCubicaje.size();
          String descLinea;
          
          // Para todas las lineas que no tenian ningun Tipo Caja Embalaje y para aquellas
          // que no tenina ningun Tipo Caja Embalaje con indicador Cubicaje = true generamos
          // un detalle de error
          for (int j = 0; j < cantLineasNoCubic; j++) {
              descLinea = (String)lineasSinEmbalajeParaCubicaje.get(j);
              UtilidadesLog.debug(" Agregando linea con Tipo Caja Embalaje pero no marcada con Indicador Cubicaje 'true': " + descLinea);
              
              dtoErrorValoresCubicaje = new DTOErrorValoresCubicaje();
              dtoErrorValoresCubicaje.setDescripcionLinea(descLinea);
              dtoErrorValoresCubicaje.setInformacionRegistroProblemas("APE-0041-1");
              dtoErrorValoresCubicaje.setError("APE-0041");
              
              listaErrores.add(dtoErrorValoresCubicaje);
          }
          
          UtilidadesLog.debug("listaErrores: " + listaErrores);
          dtoColeccion.setLista(listaErrores);
          
          UtilidadesLog.info("MONAlarmas.comprobarAlarmasValoresCubicaje(DTOComprobarAlarmas dtoe): Salida");
          return dtoColeccion;
          
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
      }
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       22/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Modificado   25/06/2007 -- Inc BELC400000527
    */    
  public void comprobarAlarmasRelativasAProductos(DTOComprobarAlarmas dtoe) 
      throws MareException {
      UtilidadesLog.info("MONAlarmas.comprobarAlarmasRelativasAProductos(DTOComprobarAlarmas dtoe): Entrada");
      
      try {      
          
          DAOAlarmas daoAlarmas = new DAOAlarmas();
          
          Integer oidPeriodoSiguiente = daoAlarmas.obtienePeriodoSiguiente(Integer.valueOf(dtoe.getOidPeriodo().toString()));
          
          ArrayList productos = daoAlarmas.obtenerProductosMF(Integer.valueOf(dtoe.getOidPeriodo().toString()), oidPeriodoSiguiente);
          
          RecordSet rsUsuarioLA = daoAlarmas.obtenerUsuariosLA(dtoe.getOidCentroDistribucion());
          
          this.enviarMailAlarmaProducto(rsUsuarioLA, productos);
      
          UtilidadesLog.info("MONAlarmas.comprobarAlarmasRelativasAProductos(DTOComprobarAlarmas dtoe): Salida");
          
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
      } 
  }

  public void homogeneizarMedidas(ArrayList tiposCajas) throws MareException {
      UtilidadesLog.info("MONAlarmas.homogeneizarMedidas(DTOTipoCajaEmbalaje tiposCajas): Entrada");
      
      HashMap oidUniMedH = new HashMap();
      int cantTiposCajas = tiposCajas.size();
      DTOTipoCajaEmbalaje dtoTipoCajaEmbalaje = null;
      DTOOIDs oidUnidesMed = new DTOOIDs();
      DAOCalculoCubicaje daoCalculoCubicaje = new DAOCalculoCubicaje();
      
      for(int i=0; i< cantTiposCajas; i++){
          dtoTipoCajaEmbalaje = (DTOTipoCajaEmbalaje)tiposCajas.get(i);
          UtilidadesLog.debug("dtoTipoCajaEmbalaje: " + dtoTipoCajaEmbalaje);
      
          if(dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad()!= null && oidUniMedH.get(dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad())==null){
              UtilidadesLog.debug("Hash caja: " + dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad());
              oidUniMedH.put(dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad(), dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad());
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
          oidUnidesMed.setOidPais(dtoTipoCajaEmbalaje.getOidPais());
          
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
              
              if(dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad()!=null){
          
                  oidUniMedOrig = dtoTipoCajaEmbalaje.getOidUnidadMedidaCapacidad();
                  factConv = (BigDecimal)factConvH.get(oidUniMedOrig);
                  UtilidadesLog.debug("factConv: " + factConv);
                  
                  if(factConv!=null){
                      dtoTipoCajaEmbalaje.setCapacidad(dtoTipoCajaEmbalaje.getCapacidad().multiply(factConv));
                      // Agrega Inc. BELC400000380 - Inicio
                      dtoTipoCajaEmbalaje.setCapacidadMinima(dtoTipoCajaEmbalaje.getCapacidadMinima().multiply(factConv));
                      dtoTipoCajaEmbalaje.setNivelAplicacion(dtoTipoCajaEmbalaje.getNivelAplicacion().multiply(factConv));
                      // Agrega Inc. BELC400000380 - Fin
                  }
              }
          }
          
          UtilidadesLog.debug("tiposCajas: " + tiposCajas);
      }
      
      UtilidadesLog.info("MONAlarmas.homogeneizarMedidas(DTOTipoCajaEmbalaje tiposCajas): Salida");      
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       22/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public String armarMensajeAlarmaProducto(ArrayList productos) throws MareException {
      UtilidadesLog.info("MONAlarmas.armarMensajeAlarmaProducto(ArrayList productos): Entrada");
      
      String mensaje = "" ;
      int cant = productos.size();
      DTOProducto dtoProducto = null;
      
      for(int i=0; i < cant; i++){
          dtoProducto = (DTOProducto)productos.get(i);
          
          mensaje = mensaje + dtoProducto.getCodSAP() + " " + 
                              (dtoProducto.getDescSAP()!=null?dtoProducto.getDescSAP():"") + "\n";
      }
      
      UtilidadesLog.debug("mensaje: " + mensaje);
      
      UtilidadesLog.info("MONAlarmas.armarMensajeAlarmaProducto(ArrayList productos): Salida");
      return mensaje;
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       22/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * Modificado inc BELC400000527
    */
  public void enviarMailAlarmaProducto(RecordSet rsUsuarioLA, ArrayList productos) throws MareException {
      UtilidadesLog.info("MONAlarmas.enviarMailAlarmaProducto(RecordSet rsUsuarioLA, ArrayList productos): Entrada");
      
      try {
          MONMantenimientoLineaSublineaHome monMantenimientoLineaSublineaH = getMONMantenimientoLineaSublineaHome();
          MONMantenimientoLineaSublinea monMantenimientoLineaSublinea= monMantenimientoLineaSublineaH.create(); 
          MONServicioCorreoElectronicoHome monServicioCorreoElectronicoH = getMONServicioCorreoElectronicoHome();
          MONServicioCorreoElectronico monServicioCorreoElectronico = monServicioCorreoElectronicoH.create();       
          
          String mensajeError = this.armarMensajeAlarmaProducto(productos) ;
          
          if(!mensajeError.equals("")){
              
              int cant = rsUsuarioLA.getRowCount();
              String emailAdministrador = null;
             
              DTOCorreoElectronico dtoCorreoElectronico = new DTOCorreoElectronico();
              dtoCorreoElectronico.setAsunto("Alarma Relativa a Productos");
              dtoCorreoElectronico.setMensaje(mensajeError);
              
              for(int i=0; i <cant; i++){
                  emailAdministrador = (String)rsUsuarioLA.getValueAt(i,"MAIL");
                  dtoCorreoElectronico.setDireccion(emailAdministrador);
                  UtilidadesLog.debug("dtoCorreoElectronico: " + dtoCorreoElectronico);
                  monServicioCorreoElectronico.enviarCorreo(dtoCorreoElectronico);
              }
          }

      }  catch (NamingException ne) {
          UtilidadesLog.error("ERROR ", ne);
          throw new MareException(ne, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        
      } catch (RemoteException re) {
          UtilidadesLog.error("ERROR ", re);
          throw new MareException(re, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        
      } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      
      UtilidadesLog.info("MONAlarmas.enviarMailAlarmaProducto(RecordSet rsUsuarioLA, ArrayList productos): Salida");
  }

  private MONMantenimientoMapasHome getMONMantenimientoMapasHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONMantenimientoMapasHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoMapas"), MONMantenimientoMapasHome.class);
  }

  private MONMantenimientoLineaSublineaHome getMONMantenimientoLineaSublineaHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONMantenimientoLineaSublineaHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoLineaSublinea"), MONMantenimientoLineaSublineaHome.class);
  }

  private MONServicioCorreoElectronicoHome getMONServicioCorreoElectronicoHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONServicioCorreoElectronicoHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONServicioCorreoElectronico"), MONServicioCorreoElectronicoHome.class);
  }

}