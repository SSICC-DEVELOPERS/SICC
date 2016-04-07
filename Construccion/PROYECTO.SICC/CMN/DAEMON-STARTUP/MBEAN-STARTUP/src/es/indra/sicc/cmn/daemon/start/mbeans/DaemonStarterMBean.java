package es.indra.sicc.cmn.daemon.start.mbeans;

public interface DaemonStarterMBean {

    public void start();
    public void stop();
    public void setInitCxtFact(String initCxtFact);
    public void setProvURL(String provURL);
    public void setSecPrincipal(String secPrincipal);
    public void setSecCredential(String secCredential);
    public void setLoockupName(String loockupName);

    public String getInitCxtFact();
    public String getProvURL();
    public String getSecPrincipal();
    public String getSecCredential();
    public String getLoockupName();

}
