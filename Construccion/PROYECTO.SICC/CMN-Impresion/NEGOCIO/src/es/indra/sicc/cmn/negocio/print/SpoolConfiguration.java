/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.cmn.negocio.print;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Hashtable;
import java.util.Vector;


public class SpoolConfiguration {
    private static SpoolConfiguration spoolConfiguration;
    private Vector configuration;
    private Hashtable openedSpools;
    private String serverID;
    private SpoolManagerBean spoolManager=null;
    private boolean multiSpoolEnable; 
   
    public boolean getMultiSpoolEnable(){
    return this.multiSpoolEnable;
    }

    private SpoolConfiguration(String serverID) throws MareException {
        /*ENTRADA: serverID String
        SALIDA:
        RESUMEN: Es el contructor privado de la clase.

        1.- Me creo una nueva instancia de un objeto HashTable y se lo asigno al atributo openedSpools.
        2.- Me creo una nueva instancia de un objeto Vector y se lo asigno al atributo configuration.
        3.- Asigno al atributo serverID el String que se pasa por cabecera.
        3.- Llamo al método loadConfiguration.
        */
        /*UtilidadesLog.info("SpoolConfiguration.SpoolConfiguration(): Entrada");
        this.openedSpools = new Hashtable();
        this.configuration = new Vector();
        this.serverID = serverID;

        try {
            this.loadConfiguration();
        } catch (MareException e) {
            this.loguearError("SpoolConfiguration: SpoolConfiguration ", e);
        }
        UtilidadesLog.info("SpoolConfiguration.SpoolConfiguration(): Salida");*/
    }
    
    private SpoolConfiguration(String serverID, Long oidSubacceso) throws MareException {
        /*ENTRADA: serverID String
        SALIDA:
        RESUMEN: Es el contructor privado de la clase.

        1.- Me creo una nueva instancia de un objeto HashTable y se lo asigno al atributo openedSpools.
        2.- Me creo una nueva instancia de un objeto Vector y se lo asigno al atributo configuration.
        3.- Asigno al atributo serverID el String que se pasa por cabecera.
        3.- Llamo al método loadConfiguration.
        */
        /*UtilidadesLog.info("SpoolConfiguration.SpoolConfiguration(): Entrada");
        this.openedSpools = new Hashtable();
        this.configuration = new Vector();
        this.serverID = serverID;

        try {
            this.loadConfiguration(oidSubacceso);
        } catch (MareException e) {
            this.loguearError("SpoolConfiguration: SpoolConfiguration ", e);
        }
        UtilidadesLog.info("SpoolConfiguration.SpoolConfiguration(): Salida");*/
    }
    
   //Cambio por incidencia 11572
    public void createSpool(Long spoolID, SpoolManagerBean spoolManager)  throws MareException {
		/*ENTRADA: spoolID : Long, spoolManager: SpoolManager 
		SALIDA: 
		RESUMEN: Crea una instancia del objeto Spool y la añade a su atributo openedSpool 

		1.-Creo una instacia del objeto Spool y le paso spoolID, config, serverID(atributo clase) y el spoolManager (cabecera). 
		2.-Añado esa instancia a la tabla hash openedSpool (atributo de la clase) con la clave spoolID */
        UtilidadesLog.info("SpoolConfiguration.createSpool(): Entrada");
        Spool spool = null;
        this.spoolManager=spoolManager;
        try {    
            //De donde saco config que no esta
            //Cambio por incidencia 11572
            //spool = new Spool(spoolID, configuration, this.serverID.toString(),spoolManager); //Ver incidencia 10948
            spool = new Spool(spoolID, configuration, this.serverID.toString(),this.spoolManager ); //Ver incidencia 10948
            //ver que hacer con la excepcion  porque todavia no lo sabe solo poner log
        } catch (Exception e) {
            this.loguearError("SpoolConfiguration: createSpool  ", e);
            throw new MareException("SpoolConfiguration: createSpool al crear el SPoll", e);
        }

        this.openedSpools.put(spoolID, spool);
        UtilidadesLog.info("SpoolConfiguration.createSpool(): Salida");
    }

    /*public void loadConfiguration() throws MareException {
        UtilidadesLog.info("SpoolConfiguration.loadConfiguration(): Entrada");
        DAOPrinterConfiguration dao = new DAOPrinterConfiguration();

        try {
            this.configuration = dao.recoverConfiguration();
            this.multiSpoolEnable = dao.recoverMultiSpoolEnable();
        } catch (MareException e) {
            this.loguearError("SpoolConfiguration: loadConfiguration  ", e);
        }
        UtilidadesLog.info("SpoolConfiguration.loadConfiguration(): Salida");
        //ver que hacer con la excepcion porque todavia no lo sabe solo poner log
    }*/
    
    /*public void loadConfiguration(Long oidSubacceso) throws MareException {
        

        UtilidadesLog.info("SpoolConfiguration.loadConfiguration(): Entrada");
        DAOPrinterConfiguration dao = new DAOPrinterConfiguration();

        try {
            this.configuration = dao.recoverConfiguration();
            this.multiSpoolEnable = dao.recoverMultiSpoolEnable();
        } catch (MareException e) {
            this.loguearError("SpoolConfiguration: loadConfiguration  ", e);
        }
        UtilidadesLog.info("SpoolConfiguration.loadConfiguration(): Salida");
        //ver que hacer con la excepcion porque todavia no lo sabe solo poner log
    }*/

    public Spool getOpenedSpool(Long idSpool) {
        //Devuelve el objeto Spool almacenado en la tabla openedSpool con la clave que se nos pasa por cabecera
        UtilidadesLog.info("SpoolConfiguration.getOpenedSpool(): Entrada");
        UtilidadesLog.debug("idSpool "+ idSpool);
        try{
            if(openedSpools!=null){
                Spool spoolAbierto = (Spool)openedSpools.get(idSpool);
                UtilidadesLog.info("SpoolConfiguration.getOpenedSpool(): Salida Abierto");
                return spoolAbierto;
            }else {
                UtilidadesLog.info("SpoolConfiguration.getOpenedSpool(): Salida ");
                return null;
            }
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            return null;
        }
    }


    static synchronized public SpoolConfiguration getSpoolConfiguration(
        String serverID) throws MareException {
        /*ENTRADA: serverID: Long
        SALIDA: SpoolConfiguration
        RESUMEN: Es un método estatico que devueve una instancia Singleton del SpoolConfiguration y sincronizado

        1.-Si SpoolConfguration es null
        asignamos al atributo spoolConfiguration= new SpoolConfiguration(serverID)
        fin si.
        2.- Devolvemos el valor del atributo spoolConfiguration

        */
        UtilidadesLog.info("SpoolConfiguration.getSpoolConfiguration(): Entrada");
        if (spoolConfiguration == null) {
            try {
                spoolConfiguration = new SpoolConfiguration(serverID);
            } catch (MareException e) {
                loguearErrorStatic("SpoolConfiguration: getSpoolConfiguration ",
                    e);
            }
        }
        UtilidadesLog.info("SpoolConfiguration.getSpoolConfiguration(): Salida");
        return spoolConfiguration;
    }
    
    static synchronized public SpoolConfiguration getSpoolConfiguration(String serverID, Long oidSubacceso) throws MareException {
        /*ENTRADA: serverID: Long
        SALIDA: SpoolConfiguration
        RESUMEN: Es un método estatico que devueve una instancia Singleton del SpoolConfiguration y sincronizado

        1.-Si SpoolConfguration es null
        asignamos al atributo spoolConfiguration= new SpoolConfiguration(serverID)
        fin si.
        2.- Devolvemos el valor del atributo spoolConfiguration

        */
        UtilidadesLog.info("SpoolConfiguration.getSpoolConfiguration(): Entrada");
        if (spoolConfiguration == null) {
            try {
                spoolConfiguration = new SpoolConfiguration(serverID, oidSubacceso);
            } catch (MareException e) {
                loguearErrorStatic("SpoolConfiguration: getSpoolConfiguration ",
                    e);
            }
        }
        UtilidadesLog.info("SpoolConfiguration.getSpoolConfiguration(): Salida");
        return spoolConfiguration;
    }


    public void activateSpool(Long idSpool) throws MareException {
        UtilidadesLog.info("SpoolConfiguration.activateSpool(): Entrada");
        //RESUMEN: Este método activa un spol. 
    
        //1.- obtengo un spool llamando al método getOpenedSpool(idSpool) y llamo a su método activate.
        Spool spool = null;
        spool = this.getOpenedSpool(idSpool);
        if (spool !=null){
            spool.activate();
        }
        //2.- creo una instancia del objeto DAOPrinterSystem y llamo a su método activateSpool(idSpool)
        DAOPrinterSystem daoPrinterSystem = new DAOPrinterSystem();
        daoPrinterSystem.activateSpool(idSpool);
        UtilidadesLog.info("SpoolConfiguration.activateSpool(): Salida");
    }


    public Vector getConfiguration() {
        return configuration;
    }

    public void closeSpool(Long idSpool) throws MareException{
        UtilidadesLog.info("SpoolConfiguration.closeSpool(): Entrada");
        //RESUMEN: El objetivo de este método es cerrrar un spool.
    
        //1.- Creo una instancia del DAOPrinterSystem y llamo a su método closeSpool(idSpool).
        DAOPrinterSystem daoPrinterSystem = new DAOPrinterSystem();
        daoPrinterSystem.closeSpool(idSpool);
    
        //2.- Llamo al método getOpenedSpool(idSpoo) para obtener el spool 
        //que nos interesa y llamar a su método getActive.
        Spool spool = null;
        spool = this.getOpenedSpool(idSpool);
        boolean active;
        if(spool==null){
          //throw new MareException();
          return;
        }
        active = spool.getActive();
        //Si devuelve TRUE entonces: 
        //-llamo a su método flush 
            
        if(active){
            UtilidadesLog.debug("El spool esta activo, imprimo lo que queda");
          	//spool.flush();
            //*************** Cambio por la incidencia 15675 ********************************************************
            daoPrinterSystem.desactivateSpool(idSpool); //va a la tabla de Spool y lo desactiva pone (campo active= FALSE)
            //******************************************************************************************************
            this.openedSpools.remove(spool);
        }else{
            UtilidadesLog.debug("El spool esta desactivo");
        }
        
        UtilidadesLog.info("SpoolConfiguration.closeSpool(): Salida");
    }


    public void setConfiguration(Vector newConfiguration) {
        configuration = newConfiguration;
    }

    public Hashtable getOpenedSpools() {
        return openedSpools;
    }

    public void setOpenedSpools(Hashtable newOpenedSpools) {
        openedSpools = newOpenedSpools;
    }

    public String getServerID() {
        return serverID;
    }

    public void setServerID(String newServerID) {
        serverID = newServerID;
    }

    public void setSpoolConfiguration(SpoolConfiguration newSpoolConfiguration) {
        spoolConfiguration = newSpoolConfiguration;
    }

    private void loguearStackTrace(Throwable e) {
        try {
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            UtilidadesLog.error(out,e);
            UtilidadesLog.error(pila.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("Error Logeando Pila: " + ex.getMessage());
        }
    }

    private void loguearError(String mensaje, Throwable e) {
        //mensaje: nombreMetodo: tipoExcepcion
        UtilidadesLog.error("****Error Metodo: " + mensaje + ": " +
            e.getMessage());
        this.loguearStackTrace(e);
    }

    private static void loguearErrorStatic(String mensaje, Throwable e) {
        //mensaje: nombreMetodo: tipoExcepcion
        UtilidadesLog.error("****Error Metodo: " + mensaje + ": " +
            e.getMessage());
        loguearStackTraceStatic(e);
    }

    private static void loguearStackTraceStatic(Throwable e) {
        try {
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            UtilidadesLog.error(out,e);
            UtilidadesLog.error(pila.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("Error Logeando Pila: " + ex.getMessage());
        }
    }
}
