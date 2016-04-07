/*
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.cmn.negocio.batch.util;

import es.indra.mare.common.exception.MareException;

/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class BatchConfig extends MaReConfig {	

    private final static String CONFIG_BATCH_PREFIX     = "batch";
    private final static String DBSERVICE_PROPERTY      = "DBService";
    private final static String LOGSERVICE_PROPERTY     = "LogService";
    private final static String USER_PROPERTY           = "user";
    private final static String URL_PROPERTY            = "url";
    private final static String PASSWORD_PROPERTY       = "password";
    private final static String BF_PROPERTY             = "BusinessFacade";
    private final static String LOCAL_BF_PROPERTY       = "localBusinessFacade";
    private final static String SERVER_PROPERTY         = "server";
    private final static String WAIT_TIME_PROPERTY      = "waitPollingTime";
    private final static String RECOVER_QUEUED_PROPERTY = "recoverQueued";
		
    public String getPrefix() {return CONFIG_BATCH_PREFIX;};
        
    private String getConfigStringProperty (String prop) throws MareException {	
        String value = (String)getConfiguration().getProperty(prop);
        if (value == null)
            throw new MareException ("No se encuentra la propiedad: " +  CONFIG_BATCH_PREFIX + "." + prop);   
        return value;
    }
  
    private int getConfigIntProperty (String prop) throws MareException {
        String sValue = getConfigStringProperty(prop);
        int iValue = 0;
        if (sValue != null) {
           iValue = new Integer(sValue).intValue();            
        }         
        return iValue;
    }
    
    private boolean getConfigBooleanProperty (String prop) throws MareException {
        return getConfiguration().getBoolean(prop, false);
    }
    
    public String getDBService() throws MareException {
        return getConfigStringProperty(DBSERVICE_PROPERTY);
    }
    
    public String getLogService() throws MareException {
        return getConfigStringProperty(LOGSERVICE_PROPERTY);
    }
    
    public String getUser() throws MareException {
        return getConfigStringProperty(USER_PROPERTY);
    }
    
    public String getPassword() throws MareException {
        return getConfigStringProperty(PASSWORD_PROPERTY);
    }
    
    public String getLocalBusinessFacade() throws MareException {
        return getConfigStringProperty(LOCAL_BF_PROPERTY);
    }
    
    public String getBusinessFacade() throws MareException {
        return getConfigStringProperty(BF_PROPERTY);
    }
    
    public String getServer() throws MareException {
        return getConfigStringProperty(SERVER_PROPERTY);
    }
    
    public int getWaitPoollingTime() throws MareException {
        return getConfigIntProperty(WAIT_TIME_PROPERTY);
    }
    
    public boolean getRecorverQueued() throws MareException {
        return getConfigBooleanProperty(RECOVER_QUEUED_PROPERTY);
    }
    
    public String getUrl() throws MareException {
        return getConfigStringProperty(URL_PROPERTY);
    }
    
}
