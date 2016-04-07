package es.indra.sicc.cmn.start.beans;

import javax.ejb.Remote;

@Remote
public interface IDaemonStarterRemote {
    public void start();
    public void stop();
}
