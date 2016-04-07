package com.calipso.reportgenerator.enterprise.common;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.rep.dtos.DTOReporte;

public interface MAREInfo extends EJBObject 
{
  void ejecutarReporte(DTOReporte dtoReporte) throws RemoteException, MareException;

  DTOReporte ejecutarReporteOrig(DTOReporte dtoReporte) throws MareException, RemoteException;
}