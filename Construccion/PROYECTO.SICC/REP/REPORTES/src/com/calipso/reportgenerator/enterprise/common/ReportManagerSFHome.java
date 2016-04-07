package com.calipso.reportgenerator.enterprise.common;

import com.calipso.reportgenerator.common.ReportGeneratorConfiguration;
import com.calipso.reportgenerator.enterprise.common.ReportManagerSF;
import es.indra.mare.common.info.InfoException;

import java.rmi.RemoteException;


//import com.calipso.reportgenerator.enterprise.common.ReportManagerSF;

/**
 * Es la interface home para ReportManagerSFBean, y es implementada
 * por el EJB server container; el objeto implementado es Home object
 * que proporciona una factory para los EJB objects.
 */

public interface ReportManagerSFHome extends javax.ejb.EJBHome {

  /*
   * Este método crea el EJB object. Tal método se corresponde con
   * el método ejbCreate() del ReportManagerSLBean
   * @param reportGeneratorConfiguration La configuración para la ubicación de repositorios, etc
   * @return El EJB object creado recientemente
   */
  ReportManagerSF create(ReportGeneratorConfiguration reportGeneratorConfiguration) throws javax.ejb.CreateException, InfoException, RemoteException;
}


