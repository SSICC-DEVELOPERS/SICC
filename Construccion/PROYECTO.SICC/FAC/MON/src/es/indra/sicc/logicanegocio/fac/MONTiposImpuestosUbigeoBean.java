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
 */
 
package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.seg.DTOCAS;
import es.indra.sicc.dtos.seg.DTOCargaCAS;
import es.indra.sicc.dtos.seg.DTOFiltroCAS;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DAOTiposImpuestosUbigeo;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.mae.DTOCombosImpuestos;
import es.indra.sicc.dtos.fac.DTOTiposImpuestosUbigeo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class MONTiposImpuestosUbigeoBean implements SessionBean  {

	private SessionContext ctx;

  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;    
  }
  
 /**
  * @author Emilio Noziglia
  * @date 15/08/2007
  * @throws MareException
  */    
  public DTOCombosImpuestos buscaTiposImpuestosPorUbigeo(DTOBelcorp dtoE) throws MareException {
    UtilidadesLog.info("MONTiposImpuestosUbigeoBean.buscaTiposImpuestosPorUbigeo(): Entrada");
    
    DAOTiposImpuestosUbigeo daoTipImpuUbigeo = new DAOTiposImpuestosUbigeo();
    RecordSet rsTipImpuUbigeo = daoTipImpuUbigeo.buscaTiposImpuestosPorUbigeo(dtoE);
    
    try {         
      
      MONMantenimientoSEGHome mmsHome = getMONMantenimientoSEGHome();
      
      DTOCargaCAS dtoCargaCas = new DTOCargaCAS();
      DTOFiltroCAS dtoFiltro = new DTOFiltroCAS();
      DTOFiltroCAS dtoTodos = new DTOFiltroCAS();
      
      dtoFiltro.setBaccesos(Boolean.TRUE);
      dtoFiltro.setBcanales(Boolean.TRUE);
      dtoFiltro.setBsubaccesos(Boolean.TRUE);
      dtoFiltro.setOidPais(dtoE.getOidPais());
      dtoFiltro.setOidIdioma(dtoE.getOidIdioma());
      
      dtoTodos.setBaccesos(Boolean.FALSE);
      dtoTodos.setBcanales(Boolean.FALSE);
      dtoTodos.setBsubaccesos(Boolean.FALSE);
      dtoTodos.setOidPais(dtoE.getOidPais());
      dtoTodos.setOidIdioma(dtoE.getOidIdioma());
      
      dtoCargaCas.setFiltro(dtoFiltro);      
      dtoCargaCas.setTodos(dtoTodos);
      dtoCargaCas.setOidPais(dtoE.getOidPais());
      dtoCargaCas.setOidIdioma(dtoE.getOidIdioma());
      
      DTOCAS dtoCas = mmsHome.create().obtieneCanalAccesoSubacceso(dtoCargaCas);

      DTOCombosImpuestos dtoS = new DTOCombosImpuestos();
      
      dtoS.setAccesos(dtoCas.getAccesos());
      dtoS.setCanales(dtoCas.getCanales());
      dtoS.setSubaccesos(dtoCas.getSubaccesos());
      dtoS.setTasasImpuestos(rsTipImpuUbigeo);
      dtoS.setOidIdioma(dtoE.getOidIdioma());
      dtoS.setOidPais(dtoE.getOidPais());
      
      
      UtilidadesLog.info("MONTiposImpuestosUbigeoBean.buscaTiposImpuestosPorUbigeo(): Salida");
      return dtoS;
      
    } catch (CreateException e) {
        UtilidadesLog.error(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS);
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
    } catch (RemoteException e) {
        UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));      
    } catch (NamingException e) {
        UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }

  }

 /**
  * @author Emilio Noziglia
  * @date 15/08/2007
  * @throws MareException
  */    
  public void guardarTiposImpuestosPorUbigeo(DTOTiposImpuestosUbigeo dtoE) throws MareException {
    UtilidadesLog.info("MONTiposImpuestosUbigeoBean.buscaTiposImpuestosPorUbigeo(DTOTiposImpuestosUbigeo dtoE): Entrada");
    
    DAOTiposImpuestosUbigeo daoTipImpuUbigeo = new DAOTiposImpuestosUbigeo();
    daoTipImpuUbigeo.guardarTiposImpuestosPorUbigeo(dtoE);
    
    UtilidadesLog.info("MONTiposImpuestosUbigeoBean.buscaTiposImpuestosPorUbigeo(DTOTiposImpuestosUbigeo dtoE): Salida");  
  }

 /**
  * @author Emilio Noziglia
  * @date 15/08/2007
  * @throws MareException
  */    
  public DTOSalida consultarTiposImpuestosPorUbigeo(DTOSiccPaginacion dtoE) throws MareException {
    UtilidadesLog.info("MONTiposImpuestosUbigeoBean.consultarTiposImpuestosPorUbigeo(DTOBelcorp dtoE): Entrada");
    
    DAOTiposImpuestosUbigeo daoTipImpuUbigeo = new DAOTiposImpuestosUbigeo();
    DTOSalida dtoS = new DTOSalida();
    dtoS.setOidIdioma(dtoE.getOidIdioma());
    dtoS.setOidPais(dtoE.getOidPais());
    RecordSet rsTipImpuUbigeo = daoTipImpuUbigeo.consultarTiposImpuestosPorUbigeo(dtoE);
    dtoS.setResultado(rsTipImpuUbigeo);
    
    UtilidadesLog.info("MONTiposImpuestosUbigeoBean.consultarTiposImpuestosPorUbigeo(DTOBelcorp dtoE): Salida");  
    return dtoS;
  }

 /**
  * @author Emilio Noziglia
  * @date 15/08/2007
  * @throws MareException
  */    
  public void eliminarTiposImpuestosUbigeo(DTOOIDs dtoE) throws MareException {
    UtilidadesLog.info("MONTiposImpuestosUbigeoBean.eliminarTiposImpuestosUbigeo(DTOOIDs dtoE): Entrada");
    
    DAOTiposImpuestosUbigeo daoTipImpuUbigeo = new DAOTiposImpuestosUbigeo();
    daoTipImpuUbigeo.eliminarTiposImpuestosUbigeo(dtoE);
    
    UtilidadesLog.info("MONTiposImpuestosUbigeoBean.eliminarTiposImpuestosUbigeo(DTOOIDs dtoE): Salida");  
  }

  private MONMantenimientoSEGHome getMONMantenimientoSEGHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONMantenimientoSEGHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoSEG"), MONMantenimientoSEGHome.class);
  }
  
}