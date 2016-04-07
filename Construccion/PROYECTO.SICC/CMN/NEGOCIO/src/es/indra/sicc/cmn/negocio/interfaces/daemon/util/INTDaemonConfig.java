package es.indra.sicc.cmn.negocio.interfaces.daemon.util;

import es.indra.mare.common.exception.MareException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class INTDaemonConfig extends MareConfig {	

    private static final String DAEMON_INITIAL_CONTEXT_FACTORY = "initialContextFactory";
    private static final String DAEMON_PRINCIPAL               = "principal";
    private static final String DAEMON_CREDENTIALS             = "credentials";
    private static final String DAEMON_PROVIDER                = "provider";
    private final static String DAEMON_CONFIG_PREFIX           = "interfacesdaemon";
    private final static String DAEMON_LOG_FILE                = "logFile";
    private final static String DAEMON_DB_URL                  = "dbURL";
    private final static String DAEMON_DB_DRIVER               = "dbDriver";
    private final static String DAEMON_DB_USER                 = "dbUser";
    private static final String DAEMON_DB_PASSWORD             = "dbPassword";
    private final static String DAEMON_BF                      = "BusinessFacade";
    private final static String DAEMON_INTERFACES_CONFIG_FILE  = "interfacesConfigFile";
    private final static String DAEMON_CASTOR_MAPPING_FILE     = "castorMappingFile";
    private final static String DAEMON_QUEUEING_IDBUSINESS     = "queueingIDBusiness";
    
    private final static String DBSERVICE_PROPERTY             = "DBService";
    private final static String SERVER_PROPERTY                = "server";
  
    private List folders = new ArrayList();
    
    public List getFolders() { return folders; }
                
    public String getPrefix() {return DAEMON_CONFIG_PREFIX;}
        
    private String getConfigStringProperty (String prop) throws MareException {
        String value = (String)getConfiguration().getProperty(prop);
    
        if (value == null)
            throw new MareException ("No se encuentra la propiedad: " +  DAEMON_CONFIG_PREFIX + "/" + prop);   
        return value;
    }

    public String getInitialContextFactory() throws MareException {
        return getConfigStringProperty(DAEMON_INITIAL_CONTEXT_FACTORY);
    }
    
    public String getPrincipal() throws MareException {
        return getConfigStringProperty(DAEMON_PRINCIPAL);
    }
    
    public String getCredentials() throws MareException {
        return getConfigStringProperty(DAEMON_CREDENTIALS);
    }
    
    public String getProvider() throws MareException {
        String providerUrl = "";
        StringBuffer providerUrlBuffer = new StringBuffer("");
        if (getConfiguration().getProperty(DAEMON_PROVIDER) instanceof Vector) {
            Vector vec = (Vector) getConfiguration().getProperty(DAEMON_PROVIDER);
            for (Enumeration e=vec.elements(); e.hasMoreElements();) {
                providerUrlBuffer.append(e.nextElement().toString()).append(",");
            }
            providerUrl = providerUrlBuffer.deleteCharAt(providerUrlBuffer.length() - 1).toString();
        } else {
            providerUrl = getConfiguration().getString(DAEMON_PROVIDER);
        }
        return providerUrl;
    }
    
    public String getDBService() throws MareException {
        return getConfigStringProperty(DBSERVICE_PROPERTY);
    }
    
    public String getLogFile() throws MareException {
        return getConfigStringProperty(DAEMON_LOG_FILE);
    }
    
    public String getBusinessFacade() throws MareException {
        return getConfigStringProperty(DAEMON_BF);
    }
    
    public String getServer() throws MareException {
        return getConfigStringProperty(SERVER_PROPERTY);
    }
    
    public String getDBURL() throws MareException {
        return getConfigStringProperty(DAEMON_DB_URL);
    }
    
    public String getInterfacesConfigFile() throws MareException {
        return getConfigStringProperty(DAEMON_INTERFACES_CONFIG_FILE);
    }
    
    public String getCastorMappingFile() throws MareException {
        return getConfigStringProperty(DAEMON_CASTOR_MAPPING_FILE);
    }
    
    public String getDBDriver() throws MareException {
        return getConfigStringProperty(DAEMON_DB_DRIVER);
    }
    
    public String getDBUser() throws MareException {
        return getConfigStringProperty(DAEMON_DB_USER);
    }
    
    public String getDBPassword() throws MareException {
        return getConfigStringProperty(DAEMON_DB_PASSWORD);
    }
    
    public String getQueueingIDBusiness() throws MareException {
        return getConfigStringProperty(DAEMON_QUEUEING_IDBUSINESS);
    }
    
}
