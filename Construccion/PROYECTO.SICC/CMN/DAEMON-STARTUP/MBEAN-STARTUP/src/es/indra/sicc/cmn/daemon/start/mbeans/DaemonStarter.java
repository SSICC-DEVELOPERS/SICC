package es.indra.sicc.cmn.daemon.start.mbeans;

import es.indra.mare.common.log.MareDebug;

import es.indra.sicc.cmn.start.beans.IDaemonStarterRemote;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class DaemonStarter implements DaemonStarterMBean {

    private String initCxtFact;
    private String provURL;
    private String secPrincipal;
    private String secCredential;
    private String loockupName;
    
    public DaemonStarter() {
        super();
    }

    private IDaemonStarterRemote getBean() throws Exception {

        Properties props = new Properties();
        //props.put(Context.INITIAL_CONTEXT_FACTORY,"com.evermind.server.ApplicationInitialContextFactory");
        props.put(Context.INITIAL_CONTEXT_FACTORY,initCxtFact);
        //props.put(Context.PROVIDER_URL,"ormi://localhost:3104/sicc_server_peru");
        props.put(Context.PROVIDER_URL,provURL);
        //props.put(Context.SECURITY_PRINCIPAL, "oc4jadmin");
        props.put(Context.SECURITY_PRINCIPAL, secPrincipal);
        //props.put(Context.SECURITY_CREDENTIALS, "manager1");
        props.put(Context.SECURITY_CREDENTIALS, secCredential);
        
        Context ctx = new InitialContext(props);

        //return (IDaemonStarterRemote)ctx.lookup("BelcorpStarter");
         return (IDaemonStarterRemote)ctx.lookup(loockupName);

    }

    public void start() {

        MareDebug.write("[Starter] - Starter.start() --> Entrada");
        try {
            getBean().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MareDebug.write("[Starter] - Starter.start() --> Salida");
    }

    public void stop() {
        MareDebug.write("[Starter] - Starter.stop() --> Entrada");
        try {
            getBean().stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MareDebug.write("[Starter] - Starter.stop() --> Salida");
    }


    public void setInitCxtFact(String initCxtFact) {
        this.initCxtFact = initCxtFact;
    }

    public String getInitCxtFact() {
        return initCxtFact;
    }

    public void setProvURL(String provURL) {
        this.provURL = provURL;
    }

    public String getProvURL() {
        return provURL;
    }

    public void setSecPrincipal(String secPrincipal) {
        this.secPrincipal = secPrincipal;
    }

    public String getSecPrincipal() {
        return secPrincipal;
    }

    public void setSecCredential(String secCredential) {
        this.secCredential = secCredential;
    }

    public String getSecCredential() {
        return secCredential;
    }

    public void setLoockupName(String loockupName) {
        this.loockupName = loockupName;
    }

    public String getLoockupName() {
        return loockupName;
    }
}
