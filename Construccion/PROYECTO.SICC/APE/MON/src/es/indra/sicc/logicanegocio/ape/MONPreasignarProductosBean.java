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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelCabeceraLocal;
import es.indra.sicc.entidades.ape.AsignacionProductoAnaquelCabeceraLocalHome;
import es.indra.sicc.entidades.ape.LineaArmadoLocal;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOPreasignarProducto;
import es.indra.sicc.util.DTOBoolean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.entidades.ape.LineaArmadoLocalHome;
import java.util.ArrayList;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.util.DTOOID;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONPreasignarProductosBean implements SessionBean  {
    
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
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       6/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOSalida obtenerFuentesPeriodoPreasignacion(DTOBelcorp dtoe) throws MareException {
    UtilidadesLog.info("MONPreasignarProductos.obtenerFuentesPeriodoPreasignacion(DTOBelcorp dtoe): Entrada");
    DTOSalida dtoSalida = new DAOPreasignarProductos().obtenerFuentesPeriodoPreasignacion(dtoe);
    UtilidadesLog.info("MONPreasignarProductos.obtenerFuentesPeriodoPreasignacion(DTOBelcorp dtoe): Salida");
    return dtoSalida;
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       7/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOBoolean preasignarProductosValidacion(DTOPreasignarProducto dtoe) throws MareException {
    UtilidadesLog.info("MONPreasignarProductos.preasignarProductosValidacion(DTOPreasignarProducto dtoe): Entrada");
    UtilidadesLog.debug("dtoe : " + dtoe);
    
    AsignacionProductoAnaquelCabeceraLocalHome asigProdAnaCabLH = new AsignacionProductoAnaquelCabeceraLocalHome();
    AsignacionProductoAnaquelCabeceraLocal asigProdAnaCabL = null;
    DTOBoolean dtoBoolean= new DTOBoolean();   
    DAOPreasignarProductos daoPreasignarProductos= new DAOPreasignarProductos();        
    
    if(!daoPreasignarProductos.existeProductosPreasignados(dtoe).esVacio()){
    
        dtoBoolean.setValor(false);            
        UtilidadesLog.debug("Se encontro el resgistro en AsignacionProductoAnaquelCabecera y detalle - FALSE");
        
        UtilidadesLog.info("MONPreasignarProductos.preasignarProductosValidacion(DTOPreasignarProducto dtoe): Salida");                                                                           
        return dtoBoolean;
        
    } else {        
        try {            
            asigProdAnaCabL = asigProdAnaCabLH.findByUk(dtoe.getOidMapaCD(), dtoe.getVersionDestino(),dtoe.getOidPeriodoDestino());
                       
            UtilidadesLog.debug("Se encontro el resgistro en AsignacionProductoAnaquelCabecera");
            
            dtoe.setOidAsignacionProductoAnaquelCabecera(asigProdAnaCabL.getOid());
            
            this.preasignarProductos(dtoe);
            
            dtoBoolean.setValor(true);     
            UtilidadesLog.info("MONPreasignarProductos.preasignarProductosValidacion(DTOPreasignarProducto dtoe): Salida");
            return dtoBoolean;            
            
        }   catch (NoResultException e){  
            UtilidadesLog.debug("No se encontro el registro en AsignacionProductoAnaquelCabecera, se crea");
            
            //Gpons-Inc. BELC400000163: Se elimina indicador Estado de la cabecera
            try {
                asigProdAnaCabL = asigProdAnaCabLH.create(dtoe.getVersionDestino(),
                                                          ConstantesAPE.ACTIVO_FACTURACION_N, // Inc. BELC400000169
                                                          dtoe.getOidPeriodoDestino(),
                                                          dtoe.getOidMapaCD(), 
                                                          dtoe.getOidMapaZona());
            } catch (PersistenceException pe) {  
                ctx.setRollbackOnly();
                UtilidadesLog.error("ERROR ", pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
                                                      
                                                      
            dtoe.setOidAsignacionProductoAnaquelCabecera(asigProdAnaCabL.getOid());
            
            this.preasignarProductos(dtoe);
            
            dtoBoolean.setValor(true);     
            UtilidadesLog.info("MONPreasignarProductos.preasignarProductosValidacion(DTOPreasignarProducto dtoe): Salida");
            return dtoBoolean;            
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       7/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void preasignarProductos(DTOPreasignarProducto dtoe) throws MareException {
      UtilidadesLog.info("MONPreasignarProductos.preasignarProductos(DTOPreasignarProducto dtoe): Entrada");
      try {
        LineaArmadoLocalHome lineaArmadoLH = new LineaArmadoLocalHome();
        DAOPreasignarProductos daoPreasignarProductos= new DAOPreasignarProductos();
        
        LineaArmadoLocal lineaArmadoL = lineaArmadoLH.findByPrimaryKey(dtoe.getOidLinea());        
        dtoe.setPorcentajeVariacionEstimado(lineaArmadoL.getPorcentajeVariacionEstimado());
        
        dtoe.setLstProdAnaqPerioActual(daoPreasignarProductos.obtenerProductosMapaCDPeriodoActual(dtoe));
        
        ArrayList lstProdAPreasignar = daoPreasignarProductos.obtenerProductosAPreasignar(dtoe);
        
        MONAsignacionProductosHome monAsignacionProductosHome = getMONAsignacionProductosHome();
        MONAsignacionProductos monAsignacionProductos = monAsignacionProductosHome.create();
        
        monAsignacionProductos.insertarAsignacionProductoDetalles(lstProdAPreasignar);
        
        UtilidadesLog.info("MONPreasignarProductos.preasignarProductos(DTOPreasignarProducto dtoe): Salida");
        
      }  catch (NamingException ne) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", ne);
          throw new MareException(ne, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }  catch (NoResultException e) {  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }  catch (PersistenceException e){  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }  catch (Exception ex){  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex);
      }
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       9/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public void preasignarProductosElimina(DTOPreasignarProducto dtoe) throws MareException {
    UtilidadesLog.info("MONPreasignarProductos.preasignarProductosElimina(DTOPreasignarProducto dtoe): Entrada");
    UtilidadesLog.debug("dtoe : " + dtoe);
    try {
        AsignacionProductoAnaquelCabeceraLocalHome asigProdAnaCabLH = new AsignacionProductoAnaquelCabeceraLocalHome();
        AsignacionProductoAnaquelCabeceraLocal asigProdAnaCabL = null;
      
        asigProdAnaCabL = asigProdAnaCabLH.findByUk(dtoe.getOidMapaCD(), dtoe.getVersionDestino(),dtoe.getOidPeriodoDestino());
        
        dtoe.setOidAsignacionProductoAnaquelCabecera(asigProdAnaCabL.getOid());
        
        this.eliminarAsignacionProdDetalles(asigProdAnaCabL.getOid(), dtoe.getCodProcedenciaNoElimina());
         
        //Gpons-Inc. BELC400000163: Se elimina indicador Estado de la cabecera
        //asigProdAnaCabL.setEstado(ConstantesAPE.ESTADO_PREASIGNADO);    
        
        this.preasignarProductos(dtoe);
            
        UtilidadesLog.info("MONPreasignarProductos.preasignarProductosElimina(DTOPreasignarProducto dtoe): Salida");        
        
      }  catch (NoResultException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }  catch (PersistenceException e){   
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }  
  }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       9/02/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    
     /* Modificado por: Cristian Valenzuela
       Incidencia: BELC400000347
       Fecha: 19/04/2007 */
       
  public void eliminarAsignacionProdDetalles(Long oid, String codProcedenciaNoElimina) throws MareException {
      UtilidadesLog.info("MONPreasignarProductos.eliminarAsignacionProdDetalles(Long oid, String codProcedenciaNoElimina): Entrada");
     
      StringBuffer query = new StringBuffer();
      BelcorpService bs;

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" DELETE APE_ASIGN_PRODU_ANAQU_DETAL det ");
      query.append(" WHERE det.APAC_OID_ASIG_PROD_ANAQ_CABE =  " + oid);
      
      if(codProcedenciaNoElimina.equals(ConstantesAPE.COD_PROCEDENCIA_MANUAL)) {
          //query.append(" AND det.IND_PROCE IN ( '" + ConstantesAPE.COD_PREASIGNACION + 
          //"', '" + ConstantesAPE.COD_BALANCEO + "') " );
          
          query.append(" AND det.PRCE_OID_PROC IN ( '" + ConstantesAPE.OID_PROCEDENCIA_PREASIGNACION + 
          "', '" + ConstantesAPE.OID_PROCEDENCIA_BALANCEO + "') " );
      }

      try {
          bs.dbService.executeUpdate(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("MONPreasignarProductos.eliminarAsignacionProdDetalles(Long oid, String codProcedenciaNoElimina): Salida");
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       4/05/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOSalida obtenerPeriodoSiguiente(DTOOID oidPeriodo) throws MareException {
    UtilidadesLog.info("MONPreasignarProductos.obtenerPeriodoSiguiente(DTOOID oidPeriodo): Entrada");    
    DAOPreasignarProductos daoPreasignarProductos= new DAOPreasignarProductos();
    UtilidadesLog.info("MONPreasignarProductos.obtenerPeriodoSiguiente(DTOOID oidPeriodo): Salida");
    
    return daoPreasignarProductos.obtenerPeriodoSiguiente(oidPeriodo);
  }
  
  private MONAsignacionProductosHome getMONAsignacionProductosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONAsignacionProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONAsignacionProductos"), MONAsignacionProductosHome.class);
  }


}