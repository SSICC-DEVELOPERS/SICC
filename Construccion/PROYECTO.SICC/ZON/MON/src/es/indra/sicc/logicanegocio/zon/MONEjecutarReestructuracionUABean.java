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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.zon.DTOCodUA;
import es.indra.sicc.dtos.zon.DTOEjecutarReestructuracionUA;
import es.indra.sicc.dtos.zon.DTOEjecutarReestructuracionUAReg;
import es.indra.sicc.util.DTOString;

public class MONEjecutarReestructuracionUABean implements SessionBean  {
  private SessionContext ctx;
  
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

  public DTOSalida recargaUAInferior(DTOUnidadAdministrativa dtoe) throws MareException {
    UtilidadesLog.info("MONEjecutarReestructuracionUA.recargaUAInferior(DTOUnidadAdministrativa dtoe): Entrada");
    String user = ctx.getCallerPrincipal().getName();
    DTOSalida dtoSalida = new DAOEjecutarReestructuracionUA().recargaUAInferior(dtoe, user);
    UtilidadesLog.info("MONEjecutarReestructuracionUA.recargaUAInferior(DTOUnidadAdministrativa dtoe): Salida");
    return dtoSalida;
  }

  public DTOCodUA buscarCodUA(DTOCodUA dtoe) throws MareException {
    UtilidadesLog.info("MONEjecutarReestructuracionUA.buscarCodUA(DTOCodUA dtoe): Entrada");   
    DTOCodUA dtoCodUAOrigen = new DAOEjecutarReestructuracionUA().buscarCodUA(dtoe);
    UtilidadesLog.info("MONEjecutarReestructuracionUA.buscarCodUA(DTOCodUA dtoe): Salida");
    return dtoCodUAOrigen;
  }

  public DTOString lanzarEjecutarReestructuracionUA(DTOEjecutarReestructuracionUA dtoe) throws MareException {
    UtilidadesLog.info("MONEjecutarReestructuracionUA.lanzarEjecutarReestructuracionUA(DTOEjecutarReestructuracionUA dtoe): Entrada");
      
    UtilidadesLog.debug("DTOEjecutarReestructuracionUA:  " + dtoe);      
    FileOutputStream salida = null;
    PrintWriter archSalida = null;
    
    try {      
       
        DAOEjecutarReterritorializacion daoEjecutarReterritorializacion = new DAOEjecutarReterritorializacion();
        daoEjecutarReterritorializacion.obtenerCodCab(dtoe.getCabecera());
        
        DAOEjecutarReestructuracionUA daoEjecutarReestructuracionUA = new DAOEjecutarReestructuracionUA();
        
        DTOString dtoNombreFichero = new DTOString();
        
        Date fecha = new Date(System.currentTimeMillis());
        String nombreFichero = "EjecutarReestructuracionUA" + daoEjecutarReterritorializacion.fechaHora(fecha);
        dtoNombreFichero.setCadena(nombreFichero);
        
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
        DTOEjecutarReestructuracionUAReg dtoEjecutarReestructuracionUAReg = null;
        RecordSet codClientes = null;
        int cantClientes = 0;
        
        
        HashMap UADestinos = null;
        String codUADestino = null;
        
        // Para Fusion
        if(dtoe.getTipoOp().equals("F")){
        
            dtoEjecutarReestructuracionUAReg = (DTOEjecutarReestructuracionUAReg)detalles.get(0);
            
            // Busca el cod de UA a Fusionar 2
            DTOCodUA dtoCodUA = new DTOCodUA();
            dtoCodUA.setOidUA(dtoEjecutarReestructuracionUAReg.getOidUA());
            dtoCodUA.setJerarquia(dtoEjecutarReestructuracionUAReg.getJerarquia());
            
            DTOCodUA dtoCodUADatoOrigen2 = daoEjecutarReestructuracionUA.buscarCodUA(dtoCodUA);            
            
            archSalida.println(dtoEjecutarReestructuracionUAReg.getTipoOp() + ";" +
                               dtoEjecutarReestructuracionUAReg.getDatoOrigen1() + ";" +
                               ";" + 
                               dtoCodUADatoOrigen2.getCodUA() + ";" +
                               dtoEjecutarReestructuracionUAReg.getDatoNuevo() + ";" +
                               dtoEjecutarReestructuracionUAReg.getNse1() + ";" +
                               dtoEjecutarReestructuracionUAReg.getNse2() + ";" +
                               ";"
                               );            
                               
        } else if(dtoe.getTipoOp().equals("P")){
        
            for(int i=0; i<cant; i++){
                dtoEjecutarReestructuracionUAReg = (DTOEjecutarReestructuracionUAReg)detalles.get(i);
                
                // Busca los clientes de la UA inferior
                DTOCodUA dtoCodUA = new DTOCodUA();
                dtoCodUA.setOidUA(dtoEjecutarReestructuracionUAReg.getOidUA());
                dtoCodUA.setJerarquia(dtoEjecutarReestructuracionUAReg.getJerarquia());
                
                codClientes = daoEjecutarReestructuracionUA.buscarClientesPorUA(dtoCodUA); 
                cantClientes = codClientes.getRowCount();
                
                for(int j=0; j<cantClientes; j++){                
                    
                    archSalida.println(dtoEjecutarReestructuracionUAReg.getTipoOp() + ";" +
                                       dtoEjecutarReestructuracionUAReg.getDatoOrigen1() + ";" +
                                       (String)codClientes.getValueAt(j,"COD_CLIE") +  ";" +
                                       dtoEjecutarReestructuracionUAReg.getDatoOrigen2() + ";" +
                                       ";" + 
                                       dtoEjecutarReestructuracionUAReg.getNse1() + ";" +
                                       dtoEjecutarReestructuracionUAReg.getNse2() + ";" +
                                       ";"
                                       );   
                }
            }
            
        } else if(dtoe.getTipoOp().equals("T")){
        
            // Obtengo los cod de las UAs destinos
            UADestinos = daoEjecutarReestructuracionUA.obtenerUADestinos(detalles);
        
            for(int i=0; i<cant; i++){
                dtoEjecutarReestructuracionUAReg = (DTOEjecutarReestructuracionUAReg)detalles.get(i);
                
                // Busco el cod de la UA Destino
                codUADestino = (String)UADestinos.get(dtoEjecutarReestructuracionUAReg.getOidUADestTrasv().toString());
                
                archSalida.println(dtoEjecutarReestructuracionUAReg.getTipoOp() + ";" +
                                   dtoEjecutarReestructuracionUAReg.getDatoOrigen1() + dtoEjecutarReestructuracionUAReg.getCodUA() + ";" +
                                   ";" + 
                                   codUADestino + dtoEjecutarReestructuracionUAReg.getCodUA() + ";" +
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
        
        UtilidadesLog.info("MONEjecutarReestructuracionUA.lanzarEjecutarReestructuracionUA(DTOEjecutarReestructuracionUA dtoe): Salida");     
        return dtoNombreFichero;
        
    } catch (IOException ioex) {
        UtilidadesLog.error(ioex);    
        archSalida.close();
        
        throw new MareException(ioex);    
    
    } catch (Exception ex) {
        UtilidadesLog.error(ex);       
        throw new MareException(ex);
    }    
  }
}