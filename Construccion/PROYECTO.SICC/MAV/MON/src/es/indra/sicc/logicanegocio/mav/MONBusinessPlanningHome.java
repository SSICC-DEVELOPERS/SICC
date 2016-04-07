package es.indra.sicc.logicanegocio.mav;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;


public interface MONBusinessPlanningHome extends EJBHome {
    MONBusinessPlanning create() throws RemoteException, CreateException;
}