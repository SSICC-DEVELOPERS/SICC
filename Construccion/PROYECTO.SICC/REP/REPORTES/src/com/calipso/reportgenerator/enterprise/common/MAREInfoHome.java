package com.calipso.reportgenerator.enterprise.common;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MAREInfoHome extends EJBHome 
{
  MAREInfo create() throws RemoteException, CreateException;
}