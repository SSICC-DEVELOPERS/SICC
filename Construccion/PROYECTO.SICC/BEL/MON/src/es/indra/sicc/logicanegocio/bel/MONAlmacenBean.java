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
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.logicanegocio.bel;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.entidades.bel.AlmacenesLocal;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.bel.DTOAlmacen;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.entidades.bel.AlmacenesLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONAlmacenBean implements SessionBean  {
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

  public void guardarAlmacen(DTOAlmacen dtoe) throws MareException {
      UtilidadesLog.info("MONAlmacenBean.guardarAlmacen(DTOAlmacen dtoe): Entrada");
   
      try {
          AlmacenesLocalHome almacenLH = this.getAlmacenesLocalHome();
          Entidadi18nLocalHome entidadi18nLocalHome = this.getEntidadi18nLocalHome();
          
          if(dtoe.getOid()== null){
            UtilidadesLog.debug("Insercion");  
         
            // Datos generales   
            AlmacenesLocal almacenL = almacenLH.create(dtoe.getOidPais(), dtoe.getCodAlmacen().toUpperCase(), dtoe.getInfSAP());
            almacenL.setOidCentroDistribucion(dtoe.getOidCentroDistribucion());
            almacenLH.merge(almacenL);
         
            // Descripcion      
            int cantDesc = dtoe.getDescAlmacen().size();
            Vector descTrad = dtoe.getDescAlmacen();
            DTOI18nSICC dtoTraduccion = null;
            Long oidIdioma = null;
            String descripcion = null;
            
            for (int i=0; i < cantDesc; i++){
                dtoTraduccion = (DTOI18nSICC)descTrad.get(i);
                oidIdioma = (Long)dtoTraduccion.getOidIdioma();
                descripcion = (String)dtoTraduccion.getValorI18n();
                
                entidadi18nLocalHome.create("BEL_ALMAC", new Long(1), oidIdioma, 
                                           descripcion, almacenL.getOid());
            }    
            
          } else if(dtoe.getOid()!= null){
                UtilidadesLog.debug("Modificacion");  
                
                AlmacenesLocal almacenL = almacenLH.findByPrimaryKey(dtoe.getOid());
                almacenL.setInformarSAP(dtoe.getInfSAP());         
                almacenL.setOidCentroDistribucion(dtoe.getOidCentroDistribucion());
                almacenLH.merge(almacenL);
                
                // Actualizo descripciones
                int cantDesc = dtoe.getDescAlmacen().size();
                Vector descTrad = dtoe.getDescAlmacen();
                DTOI18nSICC dtoTraduccion = null;
                Long oidIdioma = null;
                String descripcion = null;
                Entidadi18nLocal entidadi18n = null;
                
                for (int i=0; i < cantDesc; i++){
                    dtoTraduccion = (DTOI18nSICC)descTrad.get(i);
                    oidIdioma = (Long)dtoTraduccion.getOidIdioma();
                    descripcion = (String)dtoTraduccion.getValorI18n();
                    
                    entidadi18n = entidadi18nLocalHome.findByEntAtrIdioPK("BEL_ALMAC", new Long(1), 
                                           oidIdioma, dtoe.getOid());
                
                    entidadi18n.setDetalle(descripcion);
                    entidadi18nLocalHome.merge(entidadi18n);
                }
          }
          
      }   catch (NoResultException fe) {  
          //ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", fe);
          throw new MareException(fe, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }  catch (PersistenceException ce) {   
          //ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      
      UtilidadesLog.info("MONAlmacenBean.guardarAlmacen(DTOAlmacen dtoe): Salida");
  
  }

  public DTOSalida buscarAlmacen(DTOAlmacen dtoe) throws MareException {
    UtilidadesLog.info("MONAlmacenBean.buscarAlmacen(DTOAlmacen dtoe): Entrada");
    DTOSalida dtoSalida = new DAOAlmacen().buscarAlmacen(dtoe);
    UtilidadesLog.info("MONAlmacenBean.buscarAlmacen(DTOAlmacen dtoe): Salida");
    return dtoSalida;
  }

  public DTOAlmacen obtenerAlmacen(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONAlmacenBean.obtenerAlmacen(DTOOID dtoe): Entrada");
    DTOAlmacen dtoAlmacen = new DAOAlmacen().obtenerAlmacen(dtoe);
    UtilidadesLog.info("MONAlmacenBean.obtenerAlmacen(DTOOID dtoe): Salida");
    return dtoAlmacen;
  }

  public void eliminarAlmacen(DTOOIDs dtoOids) throws MareException {
      UtilidadesLog.info("MONAlmacenBean.eliminarAlmacen(DTOOIDs dtoOids): Entrada");
      
      try {
          AlmacenesLocalHome almacenLH = this.getAlmacenesLocalHome();          
          AlmacenesLocal almacenL = null;
          Entidadi18nLocalHome entidadi18nLocalHome = this.getEntidadi18nLocalHome();
          
          Long[] oids = dtoOids.getOids();
          int cant = oids.length;
          
          for(int i=0; i< cant; i++){
              UtilidadesLog.debug("oOid: " + oids[i]);  
              almacenL = almacenLH.findByPrimaryKey(oids[i]);
              almacenLH.remove(almacenL);
              
              // Elimino descripcion internacionalizada
              Entidadi18nLocal entidadi18n = null;
              Collection col = entidadi18nLocalHome.findByEntAtrPK("BEL_ALMAC", new Long(1), oids[i]);
             
              Iterator it = col.iterator();
              while (it.hasNext()){
                  entidadi18n= (Entidadi18nLocal)it.next();
                  entidadi18nLocalHome.remove(entidadi18n);
              }
          }
          
      }   catch (NoResultException fe) {  
          //ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", fe);
          throw new MareException(fe, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }   catch (PersistenceException re) {  
          //ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", re);
          throw new MareException(re, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      UtilidadesLog.info("MONAlmacenBean.eliminarAlmacen(DTOOIDs dtoOids): Salida");  
  }

  private AlmacenesLocalHome getAlmacenesLocalHome() {
    return  new AlmacenesLocalHome();
  }

  private Entidadi18nLocalHome getEntidadi18nLocalHome(){
    return new Entidadi18nLocalHome();
  }


}
