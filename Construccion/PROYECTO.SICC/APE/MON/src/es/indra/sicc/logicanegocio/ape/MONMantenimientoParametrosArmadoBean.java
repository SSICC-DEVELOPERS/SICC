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
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ape.DTOInsertarListaAFP;
import es.indra.sicc.dtos.ape.DTOAgrupacionEspecifica;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.ape.ConfiguracionListaAFPCabeceraLocalHome;
import es.indra.sicc.entidades.ape.ConfiguracionListaAFPCabeceraLocal;
import es.indra.sicc.entidades.ape.ConfiguracionListaAFPDetalleLocalHome;
import es.indra.sicc.entidades.ape.ConfiguracionListaAFPDetalleLocal;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoParametrosArmadoBean implements SessionBean  {
  private SessionContext ctx;    
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) { this.ctx = ctx; }

  public void insertarParametrosArmado(DTOInsertarListaAFP dtoe) throws MareException {  
      UtilidadesLog.info("MONMantenimientoParametrosArmado.insertarParametrosArmado(DTOInsertarListaAFP dtoe): Entrada");
      UtilidadesLog.debug("DTOInsertarListaAFP: " + dtoe);
      
      try {      
          ConfiguracionListaAFPCabeceraLocalHome confListAFPCabH = new ConfiguracionListaAFPCabeceraLocalHome();
          ConfiguracionListaAFPDetalleLocalHome confListaAFPDetH = new ConfiguracionListaAFPDetalleLocalHome();
          
          DAOMantenimientoParametrosArmado daoMantenimientoParametrosArmado = new DAOMantenimientoParametrosArmado();          
          
          Long oidCabeceraListaAFP = null;
          DTOColeccion coleccion = dtoe.getColeccion();
          ArrayList detalles = coleccion.getLista();
          DTOAgrupacionEspecifica dtoAgrupacionEspecificaCab = (DTOAgrupacionEspecifica)detalles.get(0);
          DTOAgrupacionEspecifica dtoAgrupacionEspecifica = null;
          int cant = detalles.size();
          
          if(dtoe.getOidCabeceraListaAFP()!=null){
              // Borra los detalles
              daoMantenimientoParametrosArmado.eliminarListaAFPDetalles(dtoe.getOidCabeceraListaAFP());
              
              oidCabeceraListaAFP = dtoe.getOidCabeceraListaAFP();
          
          } else {
             
             ConfiguracionListaAFPCabeceraLocal confListAFPCab = confListAFPCabH.create(
                                              dtoAgrupacionEspecificaCab.getAgrupacionEspecifica(),
                                              dtoAgrupacionEspecificaCab.getOidCentroDistribucion(), 
                                              dtoAgrupacionEspecificaCab.getOidCanal(),
                                              dtoAgrupacionEspecificaCab.getOidMarca());
                                              
             oidCabeceraListaAFP = confListAFPCab.getOid();                              
                                              
          }
          
          //vbongiov -- BELC400000561 -- 16/07/2007
          if(!daoMantenimientoParametrosArmado.validarDetalleAgrupacion(coleccion).booleanValue()){
              throw new MareException(new MareException(),
                                         UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",
                                                                          ErroresDeNegocio.APE_0054));
          }
          
          for(int i=0; i<cant; i++){     
              dtoAgrupacionEspecifica = (DTOAgrupacionEspecifica)detalles.get(i);            
              
              ConfiguracionListaAFPDetalleLocal confListaAFPDet = confListaAFPDetH.create( 
                                                         dtoAgrupacionEspecifica.getNumeroLinea(), 
                                                         oidCabeceraListaAFP, 
                                                         dtoAgrupacionEspecifica.getOidRegion(),
                                                         dtoAgrupacionEspecifica.getOidZona(),
                                                         dtoAgrupacionEspecifica.getOidSeccion());
                                                         
                   
          }
      }  catch (PersistenceException e){   
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }   
      
      UtilidadesLog.info("MONMantenimientoParametrosArmado.insertarParametrosArmado(DTOInsertarListaAFP dtoe): Salida");
  }

  public DTOSalida recuperarConfiguracionesAFP(DTOAgrupacionEspecifica dtoe) throws MareException {
      UtilidadesLog.info("MONMantenimientoParametrosArmado.recuperarConfiguracionesAFP(DTOAgrupacionEspecifica dtoe): Entrada");
      UtilidadesLog.debug("DTOAgrupacionEspecifica: " + dtoe);
      
      DAOMantenimientoParametrosArmado daoMantenimientoParametrosArmado = new DAOMantenimientoParametrosArmado();          
      
      DTOSalida dtoSalida = daoMantenimientoParametrosArmado.recuperarConfiguracionesAFP(dtoe);
      
      //Gpons-25/07/2007-BELC400000588 
      RecordSet rs=new RecordSet();
      rs=dtoSalida.getResultado();
      if (rs.esVacio()) {
            UtilidadesLog.debug("****recuperarConfiguracionesAFP: no hay datos ");				
            throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }      
      
      UtilidadesLog.info("MONMantenimientoParametrosArmado.recuperarConfiguracionesAFP(DTOAgrupacionEspecifica dtoe): Salida");
      return dtoSalida;
  }

  public void eliminarParametrosArmado(DTOOIDs dtoOids) throws MareException {
      UtilidadesLog.info("MONMantenimientoParametrosArmado.eliminarParametrosArmado(DTOOIDs dtoOids): Entrada");
      
      try {
          ConfiguracionListaAFPCabeceraLocalHome confListAFPCabH = new ConfiguracionListaAFPCabeceraLocalHome();
          ConfiguracionListaAFPCabeceraLocal confListAFPCab = null;
          
          Long[] oids = dtoOids.getOids();
          int cant = oids.length;
          
          for(int i=0; i< cant; i++){
              UtilidadesLog.debug("oOid: " + oids[i]);  
              confListAFPCab = confListAFPCabH.findByPrimaryKey(oids[i]);
              
              try {
                confListAFPCabH.remove(confListAFPCab);
              } catch (PersistenceException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error(e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
              }
          }
      }   catch (NoResultException e){  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }   catch (PersistenceException e){  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("MONMantenimientoParametrosArmado.eliminarParametrosArmado(DTOOIDs dtoOids): Salida");  
  }
  
  public DTOSalida recuperarAgrupacionesAFP(DTOAgrupacionEspecifica dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoParametrosArmado.recuperarAgrupacionesAFP(DTOAgrupacionEspecifica dtoe): Entrada");
    UtilidadesLog.debug("DTOAgrupacionEspecifica: " + dtoe);
    
    DAOMantenimientoParametrosArmado daoMantenimientoParametrosArmado = new DAOMantenimientoParametrosArmado();          
    
    DTOSalida dtoSalida = daoMantenimientoParametrosArmado.recuperarAgrupacinesAFP(dtoe);
    

    
    UtilidadesLog.info("MONMantenimientoParametrosArmado.recuperarAgrupacionesAFP(DTOAgrupacionEspecifica dtoe): Salida");
    return dtoSalida;
  }
  
}