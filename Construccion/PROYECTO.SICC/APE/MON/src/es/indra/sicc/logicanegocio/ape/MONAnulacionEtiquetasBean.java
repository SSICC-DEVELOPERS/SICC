/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ape.DTOBusquedaEtiqueta;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;

public class MONAnulacionEtiquetasBean implements SessionBean 
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

  public DTOSalida buscarEtiquetas(DTOBusquedaEtiqueta dtoE) throws MareException {
      UtilidadesLog.info("MONAnulacionEtiquetasBean.buscarEtiquetas(DTOBusquedaEtiqueta dtoE): Entrada");
      DTOSalida dtoSalida = new DAOAnulacionEtiquetas().buscarEtiquetas(dtoE);
      UtilidadesLog.info("MONAnulacionEtiquetasBean.buscarEtiquetas(DTOBusquedaEtiqueta dtoE): Salida");
      return dtoSalida;
  }

  public void anularEtiquetas(DTOOIDs dtoE) throws MareException {
      UtilidadesLog.info("MONAnulacionEtiquetasBean.anularEtiquetas(DTOOIDs dtoE): Entrada");
      new DAOAnulacionEtiquetas().anularEtiquetas(dtoE);
      UtilidadesLog.info("MONAnulacionEtiquetasBean.anularEtiquetas(DTOOIDs dtoE): Salida");
  }
}