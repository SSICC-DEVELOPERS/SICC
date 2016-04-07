package com.calipso.reportgenerator.enterprise.common;

import com.calipso.reportgenerator.enterprise.common.ReportManagerSL;


//import com.calipso.reportgenerator.enterprise.common.ReportManagerSF;

/**
 * Es la interface home para ReportManagerSLBean, y es implementada
 * por el EJB server container; el objeto implementado es Home object
 * que proporciona una factory para los EJB objects.
 */

public interface ReportManagerSLHome extends javax.ejb.EJBHome {

  /*
   * Este método crea el EJB object. Tal método se corresponde con
   * el método ejbCreate() del ReportManagerSLBean
   * @return El EJB object creado recientemente
   */
  ReportManagerSL create() throws java.rmi.RemoteException, javax.ejb.CreateException;
}


