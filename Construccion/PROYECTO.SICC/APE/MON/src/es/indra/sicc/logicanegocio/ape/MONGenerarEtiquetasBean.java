/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */

package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOListaPicado;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.HashMap;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.cmn.negocio.print.SpoolManagerLocalHome;


public class MONGenerarEtiquetasBean implements SessionBean 
{
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
  }

  /**
   * Genera registros en APE_ETIQU para la lista de picado recibida por parámetro.
   * 
   * CHANGELOG
   * ---------
   * - dmorello, 06/03/2007: Se reemplazan entity beans por JDBC
   * - dmorello, 16/03/2007: Si el sist. etiquetado no es manual, finaliza el CU
   * - dmorello, 19/07/2007: Se insertan todas las etiquetas en un solo acceso a BD
   * - dmorello, 20/04/2007: BELC400000379 - Se elimina impresión de etiquetas
   * - dmorello, 16/05/2008: Se considera que la lista puede no tener detalles.
   */
  public void generarEtiquetas(DTOListaPicado dtoe) throws MareException {
      UtilidadesLog.info("MONGenerarEtiquetasBean.generarEtiquetas(DTOListaPicado dtoe): Entrada");
      DAOGenerarEtiquetas daoGenerar = new DAOGenerarEtiquetas();
      
      RecordSet rs = daoGenerar.obtenerDatosListaPicado(dtoe);

      // Verifico que la lista tenga alguna posición para poder crear etiquetas
      if (! rs.esVacio()) {
      
          DTOOIDs dtoClientes = new DTOOIDs();
          Long[] oidCli = { new Long(((BigDecimal)rs.getValueAt(0, "OID_CLIE")).longValue()) };
          dtoClientes.setOids(oidCli);
          DAOImpresionEtiquetasManual daoImpresion = new DAOImpresionEtiquetasManual();
          HashMap hashTextoVariable = daoImpresion.recuperarTextosVariables(dtoClientes);
      
          // Obtengo el texto variable para el cliente
          Object objTextoVar = hashTextoVariable.get(oidCli[0]);
          String textoVariable = (objTextoVar != null)? objTextoVar.toString() : null;
          // Inserto la etiqueta
          daoGenerar.insertarEtiquetas(rs, textoVariable, dtoe.getOidPais());
      } else {
          UtilidadesLog.debug("Lista de picado sin detalles - NO SE GENERAN ETIQUETAS");
      }
      
      UtilidadesLog.info("MONGenerarEtiquetasBean.generarEtiquetas(DTOListaPicado dtoe): Salida");
  }
  
	 private SpoolManagerLocalHome getSpoolManagerLocalHome() throws MareException {
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.getSpoolManagerLocalHome(): Entrada");
      SpoolManagerLocalHome home = (SpoolManagerLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/SpoolManager");
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.getSpoolManagerLocalHome(): Salida");
      return home;
  }

  
}