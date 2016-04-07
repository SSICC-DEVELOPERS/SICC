package es.indra.sicc.logicanegocio.ape;

import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONFormatosEtiquetasHome extends EJBHome {
    MONFormatosEtiquetas create() throws RemoteException, CreateException;
}