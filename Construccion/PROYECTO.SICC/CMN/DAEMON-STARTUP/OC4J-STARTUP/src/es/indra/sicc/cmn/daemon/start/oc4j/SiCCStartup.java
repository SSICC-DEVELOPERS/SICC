package es.indra.sicc.cmn.daemon.start.oc4j;

import java.io.Serializable;

import java.util.Hashtable;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;

import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import javax.naming.Context;

import oracle.j2ee.server.OC4JStartup;

import oracle.oc4j.admin.jmx.remote.api.JMXConnectorConstant;


public class SiCCStartup implements OC4JStartup, Serializable {

    private static final long serialVersionUID = -1067707682045002976L;


    public SiCCStartup() {
        super();
    }

    

    public String preDeploy(Hashtable hashtable, Context context) {
        return null;
    }

    public String postDeploy(Hashtable hashtable, Context context) {
        JMXConnector jmxCon=null;
        try {
        
            String usuario = (String)hashtable.get("jmx_user");
            String password = (String)hashtable.get("jmx_password");
            jmxCon = connect(usuario, password);

            // Retrieve the MBeanServerConnection instance that acts as a proxy
            // for the OC4J MBeanServer we are connecting to.
            MBeanServerConnection mbs = jmxCon.getMBeanServerConnection();

            String objName = (String)hashtable.get("jmx_objectName");
            if(objName==null){
                objName = "sicc_server_peru:type=DemonManager,name=DaemonStarterBean";
            }
            // Retrieve the Mbean
            ObjectName oc4jMBeanObjectName = new ObjectName(objName);

            // Invoke Mbean method to get all shared library names
            mbs.invoke(oc4jMBeanObjectName, "start", null, null);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jmxCon != null) {
                try {
                    jmxCon.close();
                } catch (Exception e) {;
                }
            }
        }
        return null;

    }

    @SuppressWarnings("unchecked")
    private JMXConnector connect(String usuario, String password) throws Exception {
    
        String url = "service:jmx:rmi://localhost:" + System.getProperty("port.rmi");
            
        System.out.println("url: "+url);    
        
        JMXConnector jmxCon = null;
    
        // Define the connection target
        JMXServiceURL serviceUrl = new JMXServiceURL(url);

        // Use to pass environment properties to be used while
        // retrieving a connection
        Hashtable env = new Hashtable();

        // Define the provider root package
        env.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
                "oracle.oc4j.admin.jmx.remote");

        Hashtable credentials = new Hashtable();
        // Connect using the oc4jadmin super-user administrator account
        credentials.put(JMXConnectorConstant.CREDENTIALS_LOGIN_KEY,
                        usuario);
        credentials.put(JMXConnectorConstant.CREDENTIALS_PASSWORD_KEY,
                        password);

        // Specify the login/password to use for the connection
        env.put(JMXConnector.CREDENTIALS, credentials);

        // Get an instance of the JMXConnector interface for OC4J's rmi protocol
        // User is not yet connected
        jmxCon = JMXConnectorFactory.newJMXConnector(serviceUrl, env);

        // Connect to the target OC4J instance defined in the JMXServiceURL
        jmxCon.connect();
        
        return jmxCon;
    }


}