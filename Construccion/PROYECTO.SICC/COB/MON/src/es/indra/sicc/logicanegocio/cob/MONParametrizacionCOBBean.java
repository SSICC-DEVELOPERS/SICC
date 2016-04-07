/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * Autor : Igor Dedought / Marta Montiel
 */
package es.indra.sicc.logicanegocio.cob;
import es.indra.sicc.dtos.men.DTOIdentUsuario;
import es.indra.sicc.entidades.cob.UsuariosCobranzasLocal;
import es.indra.sicc.entidades.cob.UsuariosCobranzasLocalHome;
import es.indra.sicc.logicanegocio.men.MONUsuarios;
import es.indra.sicc.logicanegocio.men.MONUsuariosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.COBEjbLocators;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.mare.common.exception.MareException;
//import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.cob.DTOBuscarUsuariosCob;
import es.indra.sicc.dtos.cob.DTOResumen;
import es.indra.sicc.dtos.cob.DTOUsuarioCobranzas;

//import java.util.Vector;

import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;

import org.apache.commons.logging.Log;

import es.indra.sicc.util.DTOBelcorp;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONParametrizacionCOBBean implements SessionBean 
{ 
  private SessionContext ctx;
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
      ctx = ctx;
  }

  public DTOSalida obtenerEtapasDeuda(DTOBelcorp dtoe) throws MareException{
    UtilidadesLog.info("MONParametrizacionCOBBean.obtenerEtapasDeuda(DTOBelcorp dtoe): Entrada");
  
    DAOParametrizacionCOB daoParamCOB = new DAOParametrizacionCOB();
    DTOSalida dts = new DTOSalida();    
    dts.setResultado(daoParamCOB.obtenerEtapasDeuda(dtoe));    
    UtilidadesLog.debug("resultado  " + dts.getResultado());
    
    UtilidadesLog.info("MONParametrizacionCOBBean.obtenerEtapasDeuda(DTOBelcorp dtoe): Salida");
    
    return dts;
  }

  public DTOSalida obtenerTipoCargoPorEtapa(DTOOID dtoe) throws MareException{ 
    UtilidadesLog.info("MONParametrizacionCOBBean.obtenerTipoCargoPorEtapa(DTOOID dtoe): Entrada");
  
    DAOParametrizacionCOB daoParamCOB = new DAOParametrizacionCOB();
    DTOSalida dts = new DTOSalida();    
    dts.setResultado(daoParamCOB.obtenerTiposCargoPorEtapa(dtoe));    
    UtilidadesLog.debug("resultado  " + dts.getResultado());
    
    UtilidadesLog.info("MONParametrizacionCOBBean.obtenerTipoCargoPorEtapa(DTOOID dtoe): Salida");
    
    return dts;
  }

  public DTOSalida obtenerResumen(DTOResumen dtoe) throws MareException{
    UtilidadesLog.info("MONParametrizacionCOBBean.obtenerResumen(DTOResumen dtoe): Entrada");
  
    DAOParametrizacionCOB daoParamCOB = new DAOParametrizacionCOB();
    DTOSalida dts = new DTOSalida();    
    dts.setResultado(daoParamCOB.obtenerResumen(dtoe));  
    if(!dts.getResultado().esVacio()){      
      UtilidadesLog.debug("resultado  " + dts.getResultado());
      
    UtilidadesLog.info("MONParametrizacionCOBBean.obtenerResumen(DTOResumen dtoe): Salida");
      
      return dts;
    }else{
    throw new MareException(new Exception(),
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    
    }    
  }
  //-------------------------------------------------------------------------------------------------
  public DTOSalida obtenerEstadoUsuario(DTOBelcorp dtoe) throws MareException
  {
    DAOParametrizacionCOB daoParamCOB = new DAOParametrizacionCOB();
    return daoParamCOB.obtenerEstadoUsuario(dtoe);
  }

  public void guardarUsuarioCobranzas(DTOUsuarioCobranzas dtoUsuCobra) throws MareException {
    UtilidadesLog.info("MONParametrizacionCOBBean.guardarUsuarioCobranzas(DTOUsuarioCobranzas dtoUsuCobra): Entrada");
  
     /* Si DTOE.indUsuarioSupervisor { correcto = Llamo al metodo comprobarUnicoSupervisor() 
        } Otro caso { correcto=true } */
     
     boolean correcto;
     boolean supervisorExisteEnSistema;
     
     supervisorExisteEnSistema = !(comprobarUnicoSupervisor(dtoUsuCobra.getIndUsuarioSupervisor())).booleanValue();     
     if(dtoUsuCobra.getIndUsuarioSupervisor().booleanValue()) {
       UtilidadesLog.debug("**** USUARIO SUPERVISOR");
       correcto = !supervisorExisteEnSistema;
     }       
     else {
       UtilidadesLog.debug("***** USUARIO NO SUPERVISOR");
       correcto = true;
     }       
     UtilidadesLog.debug("****  CORRECTO .... " + correcto );  
     
     // cambio de acuerdo de inc.16641  idedough 20/04/05
    // if(correcto) 
    // {        
         DTOIdentUsuario dtoIdentUsu = new DTOIdentUsuario(); // <- se crea una vez     
         
// **INICIO**        Cambio por Incidencia BELC300022797    alorenzo 15/03/06 
//

         DTOIdentUsuario dtoIdentUsuSUPERVISORSalida = null;
         
         MONUsuarios monUsuarios = null; 
         monUsuarios = this.getMONUsuarios();

         if(dtoUsuCobra.getCodUsuarioSupervisor() != null && !"".equals(dtoUsuCobra.getCodUsuarioSupervisor())){
             dtoIdentUsu.setCodUsuario(dtoUsuCobra.getCodUsuarioSupervisor());     
             
            
             // Llama MONUsuarios::obtenerUsuario(DTOIdentUsuario)  para obtener dtoIdentUsuSUPERVISORSalida
             // con el idUsuarioSupervisor = dtoIdentUsuSalida.idUsuario
             try {  
                dtoIdentUsuSUPERVISORSalida = monUsuarios.obtenerUsuario(dtoIdentUsu); 
             }
             catch(RemoteException e) {
                UtilidadesLog.error(e);
                //this.loguearError("MONUsuarios::obtenerUsuario(DTOIdentUsuario): RemoteException",e);
                throw new MareException(e,UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));       
             }
         } else {
                dtoIdentUsuSUPERVISORSalida = new DTOIdentUsuario();
         }
         UtilidadesLog.debug("***** dtoIdentUsuSUPERVISORSalida = " + dtoIdentUsuSUPERVISORSalida);
         
         DTOIdentUsuario dtoIdentUsuRESPALDOSalida = null;
         
         if(dtoUsuCobra.getCodUsuarioRespaldo() != null && !"".equals(dtoUsuCobra.getCodUsuarioRespaldo())){
             dtoIdentUsu.setCodUsuario(dtoUsuCobra.getCodUsuarioRespaldo());          
         // Llama MONUsuarios::obtenerUsuario(DTOIdentUsuario)  para obtener dtoIdentUsuRESPALDOSalida
         // con el idUsuarioRespaldo = dtoIdentUsuSalida.idUsuario
             try  {  
               dtoIdentUsuRESPALDOSalida = monUsuarios.obtenerUsuario(dtoIdentUsu); 
             }
             catch(RemoteException e) {
                UtilidadesLog.error(e);
                //this.loguearError("***** MONUsuarios::obtenerUsuario(DTOIdentUsuario): RemoteException",e);
                throw new MareException(e,UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));       
             }
         } else {
              dtoIdentUsuRESPALDOSalida = new DTOIdentUsuario();
         }
//         
// **FIN** Cambio por Incidencia BELC300022797    alorenzo 15/03/06 
         try {
                 UsuariosCobranzasLocalHome usu_cobraLHome = null;
                 UsuariosCobranzasLocal usu_cobraLocal = null;
                 usu_cobraLHome = this.getUsuariosCobranzasLocalHome();
                 
                 // cambio de acuerdo de inc.16641  idedough 20/04/05
                 // estamos insertando nuevo [correcto]-> es usuario no supervisor 
                 //                                       o supervisor pero el todavia no existe en sistema
                 if(dtoUsuCobra.getOidUsuarioCobranza()==null)  
                 {   
                     if(correcto)
                     {
                     /*Hacer un create en la entidad UsuariosCobranzas con: 
                      - idUsuario=DTOE.idUsuario de dtoe
                      - idUsuarioSupervisor=idUsuarioSupervisor de dtoIdentUsuSUPERVISORSalida
                      - idUsuarioRespaldo=idUsuarioRespaldo de dtoIdentUsuRESPALDOSalida
                      - oidEtadoUsuario=DTOE.oidEstadoUsuario 
                      - fechaUltimoEstado=DTOE.fechaUltimoEstado 
                      - indJefeCobranza=DTOE.indJefeCobranza 
                      - indJefeCobranza=DTOE.indJefeCobranza 
                      - indUsuarioExterno=DTOE.indUsuarioExterno 
                      - turnoHorarioEntrada=DTOE.turnoHorarioEntrada 
                      - turnoHorarioSalida=DTOE.turnoHorarioSalida 
                      - observaciones=DTOE.observaciones */
                       UtilidadesLog.debug("**** NEW VALUES: " );
                       UtilidadesLog.debug("**** dtoUsuCobra.getFechaUltimoEstado(): " + dtoUsuCobra.getFechaUltimoEstado());
                       UtilidadesLog.debug("**** dtoUsuCobra.getIndJefeCobranza(): " + dtoUsuCobra.getIndJefeCobranza());
                       UtilidadesLog.debug("**** dtoUsuCobra.getIndUsuarioSupervisor(): " + dtoUsuCobra.getIndUsuarioSupervisor());
                       UtilidadesLog.debug("**** dtoUsuCobra.getIndUsuarioExterno(): " + dtoUsuCobra.getIndUsuarioExterno());
                       UtilidadesLog.debug("**** dtoUsuCobra.getTurnoHorarioEntrada(): " + dtoUsuCobra.getTurnoHorarioEntrada());
                       UtilidadesLog.debug("**** dtoUsuCobra.getTurnoHorarioSalida(): " + dtoUsuCobra.getTurnoHorarioSalida());
                       UtilidadesLog.debug("**** dtoUsuCobra.getObservaciones(): " + dtoUsuCobra.getObservaciones());
                       UtilidadesLog.debug("**** dtoUsuCobra.getOidPais(): " + dtoUsuCobra.getOidPais());
                       UtilidadesLog.debug("**** dtoUsuCobra.getOidEstadoUsuario(): " + dtoUsuCobra.getOidEstadoUsuario() );
                       UtilidadesLog.debug("**** dtoIdentUsuSUPERVISORSalida.getIdUsuario(): " + dtoIdentUsuSUPERVISORSalida.getIdUsuario() );
                       UtilidadesLog.debug("**** dtoUsuCobra.getIdUsuario(): " + dtoUsuCobra.getIdUsuario() );
                       UtilidadesLog.debug("**** dtoIdentUsuRESPALDOSalida.getIdUsuario(): " + dtoIdentUsuRESPALDOSalida.getIdUsuario() );
                       
                       usu_cobraLocal = usu_cobraLHome.create( 
                                                                dtoUsuCobra.getFechaUltimoEstado(),  
                                                                dtoUsuCobra.getIndJefeCobranza(),    
                                                                dtoUsuCobra.getIndUsuarioSupervisor(),
                                                                dtoUsuCobra.getIndUsuarioExterno(),    
                                                                dtoUsuCobra.getTurnoHorarioEntrada(), 
                                                                dtoUsuCobra.getTurnoHorarioSalida(),  
                                                                dtoUsuCobra.getObservaciones(),       
                                                                dtoUsuCobra.getOidPais(),
                                                                dtoUsuCobra.getOidEstadoUsuario(),
                                                                dtoIdentUsuSUPERVISORSalida.getIdUsuario(),
                                                                dtoUsuCobra.getIdUsuario(),
                                                                dtoIdentUsuRESPALDOSalida.getIdUsuario()                                                                                                          
                                                              );  
                     }
                     else
                     {
                       // lanzar una excepcion con el error COB-001 
                          throw new MareException(null, null, 
                          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_001));                                            
                     }
                 }
                 else 
                 {    // cambio de acuerdo de inc.16641  idedough 20/04/05
                      // caso modificacion                                           
                      if(supervisorExisteEnSistema && !dtoUsuCobra.getIndUsuarioSupervisorAnterior().booleanValue() && dtoUsuCobra.getIndUsuarioSupervisor().booleanValue())
                      {
                           // lanzar una excepcion con el error COB-001 
                           throw new MareException(null, null, 
                           UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_001));
                      }
                      else
                      {
                          // process: actualizacion usuario cobranzas
                                UtilidadesLog.debug("**** CALL: comprobarEstado(...) " + dtoUsuCobra);
                                /*if((comprobarEstado(dtoUsuCobra.getOidUsuarioCobranza(),
                                                   dtoUsuCobra.getEstadoAnterior(),
                                                   dtoUsuCobra.getOidEstadoUsuario())).booleanValue())
                                {*/
                                if((comprobarEstado(dtoUsuCobra.getEstadoAnterior(),
                                                    dtoUsuCobra.getOidEstadoUsuario(), 
                                                    dtoUsuCobra.getOidUsuarioCobranza()).booleanValue()) ){                      
                                     UtilidadesLog.debug("**** CALL: usu_cobraLHome.findByPrimaryKey(...) " + dtoUsuCobra.getOidUsuarioCobranza());
                                     usu_cobraLocal = usu_cobraLHome.findByPrimaryKey(dtoUsuCobra.getOidUsuarioCobranza());
                                     
                                     UtilidadesLog.debug("**** dtoUsuCobra.getIdUsuario() : " + dtoUsuCobra.getIdUsuario());
                                     usu_cobraLocal.setUserOidUsuaCobr(dtoUsuCobra.getIdUsuario());
                                     UtilidadesLog.debug("**** dtoIdentUsuSUPERVISORSalida.getIdUsuario() : " + dtoIdentUsuSUPERVISORSalida.getIdUsuario());
                                     usu_cobraLocal.setUserOidUsuaSupe(dtoIdentUsuSUPERVISORSalida.getIdUsuario());
                                     UtilidadesLog.debug("**** dtoIdentUsuRESPALDOSalida.getIdUsuario() " + dtoIdentUsuRESPALDOSalida.getIdUsuario());
                                     usu_cobraLocal.setUserOidUsuaResp(dtoIdentUsuRESPALDOSalida.getIdUsuario());
                                     
                                     usu_cobraLocal.setEsusOidEstaUsua(dtoUsuCobra.getOidEstadoUsuario());
                                     usu_cobraLocal.setFecUltiEsta(dtoUsuCobra.getFechaUltimoEstado());
                                     usu_cobraLocal.setIndJefeCobr(dtoUsuCobra.getIndJefeCobranza());
                                     usu_cobraLocal.setIndUsuaExte(dtoUsuCobra.getIndUsuarioExterno());
                                     usu_cobraLocal.setIndUsuaSupe(dtoUsuCobra.getIndUsuarioSupervisor());
                                     if(dtoUsuCobra.getTurnoHorarioEntrada() != null)
                                          usu_cobraLocal.setValTurnHoraEntr(dtoUsuCobra.getTurnoHorarioEntrada());
                                     if(dtoUsuCobra.getTurnoHorarioSalida() != null)
                                          usu_cobraLocal.setValTurnHoraSali(dtoUsuCobra.getTurnoHorarioSalida());
                                     if(dtoUsuCobra.getObservaciones() != null)
                                          usu_cobraLocal.setValObse(dtoUsuCobra.getObservaciones());
                                          
                                    usu_cobraLHome.merge(usu_cobraLocal);
                                }
                                else {
                                  // lanzar una excepcion con el error COB-002 , MODULO_COB = 17
                                  throw new MareException(null, null, 
                                  UtilidadesError.armarCodigoError(
                                  ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_002));                      
                                }
                      }
                 }
         } catch(NoResultException nre) {
             ctx.setRollbackOnly();
             nre.printStackTrace();
             throw new MareException(nre, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         } catch(PersistenceException pex) {
             ctx.setRollbackOnly();
             pex.printStackTrace();
             throw new MareException(pex, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }   
    /* }
     else  {
        // lanzar una excepcion con el error COB-001 
        throw new MareException(null, null, 
        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_001)); 
     } */         
     
    UtilidadesLog.info("MONParametrizacionCOBBean.guardarUsuarioCobranzas(DTOUsuarioCobranzas dtoUsuCobra): Salida");
  }
  
  public Boolean comprobarUnicoSupervisor(Boolean indUsuarioSupervisor)  throws MareException{
    UtilidadesLog.info("MONParametrizacionCOBBean.comprobarUnicoSupervisor(Boolean indUsuarioSupervisor): Entrada");
  
    /*Llamar al metodo obtenerSupervisorEspecial() del DAOParametrizacionCOB 
      Si recorset esta vacio
         devuelve true 
      else 
         devuelve false  */ 
    UtilidadesLog.debug("Method: comprobarUnicoSupervisor indUsuarioSupervisor = " + indUsuarioSupervisor);
    DAOParametrizacionCOB daoParamCOB = new DAOParametrizacionCOB();
    
    UtilidadesLog.info("MONParametrizacionCOBBean.comprobarUnicoSupervisor(Boolean indUsuarioSupervisor): Salida");
    
    return ((daoParamCOB.obtenerSupervisorEspecial()).esVacio())?Boolean.TRUE:Boolean.FALSE;
  }

  public DTOSalida obtenerUsuariosCob(DTOBuscarUsuariosCob dtoe) throws MareException{
    UtilidadesLog.info("MONParametrizacionCOBBean.obtenerUsuariosCob(DTOBuscarUsuariosCob dtoe): Entrada");
  
    DAOParametrizacionCOB daoParamCOB = new DAOParametrizacionCOB();
    DTOSalida out = new DTOSalida();
    out.setResultado(daoParamCOB.obtenerUsuariosCob(dtoe));    
    
    UtilidadesLog.info("MONParametrizacionCOBBean.obtenerUsuariosCob(DTOBuscarUsuariosCob dtoe): Salida");
    
    return out;
  }

  public void eliminarUsuarios(DTOOIDs dtose)  throws MareException{
    UtilidadesLog.info("MONParametrizacionCOBBean.eliminarUsuarios(DTOOIDs dtose): Entrada");
  
      /*Para cada oid recibido{ 
      Se hace un findByPk sobre la entidad UsuariosCobranzas pasandole el oid del usuario recibido 
      Para el entity obtenido en el paso anterior se llama al metodo remove. }*/
      
      /*----igarciacaro--DT--21/03/2005----
      Se modifica el método elminarUsuarios() del MONParamentrizacionCOB, para realizar la validación. Para ello se
      realiza una llamada al método comprobarEtapa() para cada oidUsuario que queremos eliminar.
      El método eliminarUsuarios() quedaría:
      -----
      Para cada oid recibido{
        correcto = comprobarEtapa(oid)
        Si (no correcto) { //Se obtiene false de la llamada anterior
             Se hace un findByPk sobre la entidad UsuariosCobranzas pasandole el oid del usuario recibido
             Para el entity obtenido en el paso anterior se llama al metodo remove.
        }else {
             Mostrar error COB-010:  "Usuario con etapa asignada: no se puede inactivar al usuario" */
      boolean correcto;
      Long[] oids = dtose.getOids();    
      UsuariosCobranzasLocalHome usu_cobraLHome = null;
      UsuariosCobranzasLocal usu_cobraLocal = null;   
      usu_cobraLHome = this.getUsuariosCobranzasLocalHome();      
      for(int i = 0; i < oids.length; i++)
      {      correcto = comprobarEtapa(oids[i]).booleanValue();
             if(!correcto)
             {     try
                   {    usu_cobraLocal = usu_cobraLHome.findByPrimaryKey(oids[i]);
                   } catch(NoResultException nre) {
                       ctx.setRollbackOnly();
                       nre.printStackTrace();
                       throw new MareException(nre, 
                       UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                   } catch(PersistenceException pex) {
                       ctx.setRollbackOnly();
                       pex.printStackTrace();
                       throw new MareException(pex, 
                       UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                   }                         
                   
                   
                   try{
                       usu_cobraLHome.remove(usu_cobraLocal);
                   } catch (PersistenceException pe) {
                       ctx.setRollbackOnly();
                       pe.printStackTrace();
                       throw new MareException(pe, 
                       UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                   }
             }
             else
             {   throw new MareException(null, null, 
                        UtilidadesError.armarCodigoError(
                        ConstantesSEG.MODULO_COB, "", ErroresDeNegocio.COB_010));  
             }
      }//for
      
        UtilidadesLog.info("MONParametrizacionCOBBean.eliminarUsuarios(DTOOIDs dtose): Salida");
  }

  public DTOSalida recuperarUsuarioCob(DTOOID dtoe)  throws MareException{
    UtilidadesLog.info("MONParametrizacionCOBBean.recuperarUsuarioCob(DTOOID dtoe): Entrada");
  
    DAOParametrizacionCOB daoParamCob = new DAOParametrizacionCOB();   
    DTOSalida out = new DTOSalida();
    out.setResultado(daoParamCob.recuperarUsuarioCob(dtoe));
    UtilidadesLog.debug(" return recuperarUsuarioCob->DTOSalida: " + out.getResultado().toString() );
    
    UtilidadesLog.info("MONParametrizacionCOBBean.recuperarUsuarioCob(DTOOID dtoe): Salida");
    
    return out;
  }

  public Boolean comprobarEstado(Long estadoAnterior, Long oidEstadoUsuario, Long oidUsuarioCob) throws MareException{
    UtilidadesLog.info("MONParametrizacionCOBBean.comprobarEstado(Long estadoAnterior, Long oidEstadoUsuario, Long oidUsuarioCob): Entrada");
  
     /*Si DTOE.estadoAnterior=1 y DTOE.oidEstadoUsuario !=1 { 
      etapaAsignada= Llamar a comprobarEtapa() con el DTOE.oidUsuarioCob 
      Si comprobarEtapa{ devuelve false  }  } Otro caso{ devuelve true } 
      */
      if(estadoAnterior.intValue() == 1 && oidEstadoUsuario.intValue() != 1){
        UtilidadesLog.info("MONParametrizacionCOBBean.comprobarEstado(Long estadoAnterior, Long oidEstadoUsuario, Long oidUsuarioCob): Salida");
          return (comprobarEtapa(oidUsuarioCob).booleanValue())?Boolean.FALSE:Boolean.TRUE;
      }else{
        UtilidadesLog.info("MONParametrizacionCOBBean.comprobarEstado(Long estadoAnterior, Long oidEstadoUsuario, Long oidUsuarioCob): Salida");
          return Boolean.TRUE;
      }
  }

  public Boolean comprobarEtapa(Long oidUsuarioCob) throws MareException
  {
      /*Llamar al metodo obtenerEtapaAsignada(oidUsuarioCob) del DAOParametrizacion 
      Si recorset esta vacio{ devuelve false else{ devuelve verdadero */
      DAOParametrizacionCOB daoParamCOB = new DAOParametrizacionCOB();
      return ((daoParamCOB.obtenerEtapaAsignada(oidUsuarioCob)).esVacio())?Boolean.FALSE:Boolean.TRUE;      
  }
  
  private MONUsuarios getMONUsuarios() throws MareException {
        UtilidadesLog.info("MONParametrizacionCOBBean.getMONUsuarios(): Entrada");
  
        // Se obtiene el interfaz home
        MONUsuariosHome home = (MONUsuariosHome)UtilidadesEJB.getHome("MONUsuarios", MONUsuariosHome.class);
            
        // Se obtiene el interfaz remoto
        MONUsuarios ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
      
            UtilidadesLog.error(e);
      
            //this.loguearError("*** Error en MONUsuariosHome",e);
            
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
    
    UtilidadesLog.info("MONParametrizacionCOBBean.getMONUsuarios(): Salida");
    
        return ejb;
  }
  
  private Log getLog() {
		Log log = null;
		try {
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());
		} catch (Exception e) {
            UtilidadesLog.error(e);
			throw new RuntimeException ("No se pudo obtener el objeto Log");
		}
	}  
  
  /*private void loguearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		this.getLog().error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		this.loguearStackTrace(e);
	}*/

	/*private void loguearStackTrace(Throwable e){
		try{						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			this.getLog().error(pila.toString());
		}catch(Exception ex){
			this.getLog().error("Error Logeando Pila: "+ex.getMessage());
		}			
	}*/
  
  /*private void loguearSql(String metodo, String sql, Vector params){
		this.getLog().info(metodo + sql);
		if (params!=null && params.size()>0){
			String sParams="";
			for (int i=0; i<params.size();i++){
				if (params.elementAt(i)!=null)
					sParams+="param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";
				else
					sParams+="param "+ (i+1) + ": es nulo, ";
			}
			this.getLog().info(metodo + sParams);
		}		
	}*/

    public DTOSalida obtenerEtapasDeudaPorTipoCargo(DTOOID dto) throws MareException {
        DAOParametrizacionCOB daoParam = new DAOParametrizacionCOB();
        return daoParam.obtenerEtapasDeudaPorTipoCargo(dto);
    }
        
    private UsuariosCobranzasLocalHome getUsuariosCobranzasLocalHome() 
    {
    return new UsuariosCobranzasLocalHome();
    }


}