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
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.logicanegocio.zon;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTORezonificacionRegistro;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.MSGEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.zon.DTOEjecutarReterritorializacion;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.dtos.zon.DTOEjecutarReterritorializacionCab;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocalHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;

public class MONEjecutarReterritorializacionBean implements SessionBean  {
  private SessionContext ctx;    
  
  private ArrayList lineasConError;
  
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }

  public DTOSalida recuperarNivelesSocioEconomicosBelcorp() throws MareException  {
    UtilidadesLog.info("MONEjecutarReterritorializacion.recuperarNivelesSocioEconomicosBelcorp(): Entrada");
    DTOSalida dtoSalida = new DAOEjecutarReterritorializacion().recuperarNivelesSocioEconomicosBelcorp();
    UtilidadesLog.info("MONEjecutarReterritorializacion.recuperarNivelesSocioEconomicosBelcorp(): Salida");
    return dtoSalida;
  }

  public DTOSalida recargaConsultoras(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONEjecutarReterritorializacion.recargaConsultoras(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOEjecutarReterritorializacion().recargaConsultoras(dtoe);
    UtilidadesLog.info("MONEjecutarReterritorializacion.recargaConsultoras(DTOOID dtoe): Salida");
    return dtoSalida;
  }

  public void lanzarEjecutarReterritorializacion(DTOEjecutarReterritorializacion dtoe) throws MareException {
      UtilidadesLog.info("MONEjecutarReterritorializacion.lanzarEjecutarReterritorializacion(DTOEjecutarReterritorializacion dtoe): Entrada");
      
      UtilidadesLog.debug(" RECIBIDO DTOEjecutarReterritorializacion:  " + dtoe);      
      
      try {      
          MONReterritorializacionHome monReterritHome = getMONReterritorializacionHome();
          MONReterritorializacion monReterrit = monReterritHome.create();
            
          DAOEjecutarReterritorializacion daoEjecutarReterritorializacion = new DAOEjecutarReterritorializacion();
          daoEjecutarReterritorializacion.obtenerCodCab(dtoe.getCabecera());
          
          String nombreFichero = this.crearFicheroRTZ(dtoe);
          
          // Armar DTOFicheroDisp
          DTOFicheroDisp dtoin = new DTOFicheroDisp();
          dtoin.setNombreFichero(nombreFichero); 
          dtoin.setPathFichero(dtoe.getPathFichero()); 
          dtoin.setOidPais(dtoe.getOidPais());
          dtoin.setOidIdioma(dtoe.getOidIdioma());
          
          UtilidadesLog.debug(" DTOFicheroDisp:  " + dtoin);      
          
          monReterrit.lanzarReterritorializacion(dtoin);
      
      } catch (Exception ex) {
          UtilidadesLog.error(ex);       
          throw new MareException(ex);
      }      

      UtilidadesLog.info("MONEjecutarReterritorializacion.lanzarEjecutarReterritorializacion(DTOEjecutarReterritorializacion dtoe): Salida");     
  }
  
  public String crearFicheroRTZ(DTOEjecutarReterritorializacion dtoe) throws MareException {
    UtilidadesLog.info("MONEjecutarReterritorializacion.crearFicheroRTZ(DTOEjecutarReterritorializacion dtoe): Entrada");     
    
    FileOutputStream salida = null;
    PrintWriter archSalida = null;
    DAOEjecutarReterritorializacion daoEjecutarReterritorializacion = new DAOEjecutarReterritorializacion();
    
    try {    
        Date fecha = new Date(System.currentTimeMillis());
        String nombreFichero = "EjecutarRTZ" + daoEjecutarReterritorializacion.fechaHora(fecha);
        
        UtilidadesLog.debug("nombre completo: " + dtoe.getPathFichero() + File.separator + nombreFichero);
              
        salida = new FileOutputStream(dtoe.getPathFichero() + File.separator + nombreFichero);
        archSalida = new PrintWriter(salida);
        
        // Escribo la cab        
        archSalida.println(dtoe.getCabecera().getCodPais());
        archSalida.println(dtoe.getCabecera().getCodMarca());
        archSalida.println(dtoe.getCabecera().getCodCanal());
        archSalida.println(dtoe.getCabecera().getCodTipoPeriodo());
        archSalida.println(dtoe.getCabecera().getCodPeriodo());
        archSalida.println(daoEjecutarReterritorializacion.fechaActualizacion(fecha));
        archSalida.println("");
        
        // Escribo las lineas
        ArrayList detalles = dtoe.getRegistros();
        int cant = detalles.size();
        DTORezonificacionRegistro dtoRezonificacionRegistro = null;
        HashMap UAPadres = null;
        String UAPadre = null;
        
        // Para Fusion
        if(dtoe.getTipoOp().equals("F")){
        
            // Obtengo las UAPadres de los territorios destinos
            UAPadres = daoEjecutarReterritorializacion.obtenerUAPadres(detalles);
        
            dtoRezonificacionRegistro = (DTORezonificacionRegistro)detalles.get(0);
            
            UAPadre = (String)UAPadres.get(dtoRezonificacionRegistro.getDatoOrigen2().toString());
            
            archSalida.println(dtoRezonificacionRegistro.getTipoOp() + ";" +
                               UAPadre + dtoRezonificacionRegistro.getDatoOrigen1() + ";" +
                               ";" + 
                               UAPadre + dtoRezonificacionRegistro.getDatoOrigen2() + ";" +
                               UAPadre + dtoRezonificacionRegistro.getDatoNuevo() + ";" +
                               dtoRezonificacionRegistro.getNse1() + ";" +
                               dtoRezonificacionRegistro.getNse2() + ";" +
                               ";"
                               );            
                               
        } else if(dtoe.getTipoOp().equals("P")){
        
            for(int i=0; i<cant; i++){
                dtoRezonificacionRegistro = (DTORezonificacionRegistro)detalles.get(i);
                
                archSalida.println(dtoRezonificacionRegistro.getTipoOp() + ";" +
                                   dtoRezonificacionRegistro.getDatoOrigen1() + ";" +
                                   dtoRezonificacionRegistro.getCodCliente() +  ";" +
                                   dtoRezonificacionRegistro.getDatoOrigen2() + ";" +
                                   ";" + 
                                   dtoRezonificacionRegistro.getNse1() + ";" +
                                   dtoRezonificacionRegistro.getNse2() + ";" +
                                   ";"
                                   );   
            }
            
        } else if(dtoe.getTipoOp().equals("T")){
        
            // Obtengo las UAPadres de los territorios destinos
            UAPadres = daoEjecutarReterritorializacion.obtenerUAPadres(detalles);
        
            for(int i=0; i<cant; i++){
                dtoRezonificacionRegistro = (DTORezonificacionRegistro)detalles.get(i);
                
                UAPadre = (String)UAPadres.get(dtoRezonificacionRegistro.getDatoOrigen2().toString());
                
                archSalida.println(dtoRezonificacionRegistro.getTipoOp() + ";" +
                                   dtoRezonificacionRegistro.getDatoOrigen1() + ";" +
                                   dtoRezonificacionRegistro.getCodCliente() +  ";" +
                                   UAPadre + dtoRezonificacionRegistro.getDatoOrigen2() + ";" +
                                   ";" + 
                                   ";" + 
                                   ";" +
                                   ";"
                                   );   
            }
        }        
        
        // Cierra el archivo
        archSalida.flush();
        archSalida.close();
        salida.close();
        
        UtilidadesLog.info("MONEjecutarReterritorializacion.crearFicheroRTZ(DTOEjecutarReterritorializacion dtoe): Salida");     
        return nombreFichero;
    
    } catch (IOException ioex) {
        UtilidadesLog.error(ioex);    
        archSalida.close();
        
        throw new MareException(ioex);
        
    } catch (Exception ex) {  
        UtilidadesLog.error(ex);    
        ex.printStackTrace();
        throw new MareException(ex);
    }    
  }
  
  public DTOString buscarUAPadre(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONEjecutarReterritorializacion.buscarUAPadre(DTOOID dtoe): Entrada");
    DTOString dtoString = new DAOEjecutarReterritorializacion().buscarUAPadre(dtoe);
    UtilidadesLog.info("MONEjecutarReterritorializacion.buscarUAPadre(DTOOID dtoe): Salida");
    return dtoString;
  }


  private MONBatchEJBLocalHome getMONBatchEJBLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONBatchEJBLocalHome)context.lookup("java:comp/env/ejb/local/MONBatchEJB");
  }
  
   private MONReterritorializacionHome getMONReterritorializacionHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONReterritorializacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONReterritorializacion"), MONReterritorializacionHome.class);
  }

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }

  private MONGestorInterfacesHome getMONGestorInterfacesHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGestorInterfacesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestorInterfaces"), MONGestorInterfacesHome.class);
  }

  private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionMensajes"), MONGestionMensajesHome.class);
  }
  
}