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

package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.InterfazDef;
import es.indra.sicc.cmn.negocio.interfaces.RegistroDefs;
import es.indra.sicc.cmn.negocio.interfaces.buzones.BuzonEntrada;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocal;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocal;
import es.indra.sicc.entidades.rec.OperacionReclamoLocal;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.ped.MONDigitacionInicialLocalHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.intsys.DTOINT;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocalHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.entidades.rec.OperacionReclamoLocalHome;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

import es.indra.sicc.logicanegocio.ped.MONDigitacionInicialLocal;
import es.indra.sicc.util.UtilidadesBD;

import java.util.Date;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * @author Emilio Noziglia
 * @since 13/12/2005
 * @reference SICC-DMCO-INTSAB-GCC-001-003
 */ 
 
public class MONINTRETBean implements SessionBean  {

  private SessionContext sessionContext;
  
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
      sessionContext = ctx;
  }

  /**
   * @author Emilio Noziglia
   * @since 07/12/2005
   * @param DTOINT dto  
   * @return void 
   * @throws MareException
   * @description Se recepcionan en tres ficheros separados los datos de 
   *              reclamos procesados por Calypso: Cabeceras de reclamos, 
   *              operaciones y líneas de reclamos. La información se integra 
   *              dentro de la información de reclamos de SICC. 
   * @reference SICC-DMCO-INTSAB-GCC-001-003
   */ 
  public void recepcionarReclamosCalypso(DTOINT dto) throws MareException {
      UtilidadesLog.info("MONINTRETBean.recepcionarReclamosCalypso(DTOINT dto): Entrada");
      
      this.recepcionarReclamosCabecera(dto);
      this.recepcionarOperacionReclamo(dto);
      this.recepcionarLineaOperacionReclamo(dto);
      UtilidadesLog.info("MONINTRETBean.recepcionarReclamosCalypso(DTOINT dto): Salida");
  }

  /**
   * CHANGELOG
   * ---------
   * Inc.BELC300023121 - Campos opcionales en el archivo.
   * Inc.DBLG500001068 - Se guarda en NUM_ATEN_INTE el numeroAtencion del archivo
   * Incidencia SiCC 20090906 - dmorello, 27/04/2009 - Se hace merge en entidad CabeceraReclamo
   */ 
  public void recepcionarReclamosCabecera(DTOINT dto) throws MareException {
      UtilidadesLog.info("MONINTRETBean.recepcionarReclamosCabecera(DTOINT dto): Entrada");
      MONGestorInterfacesHome gestor;
      MONGestorInterfaces gint = null;
      IRegistroSicc registro = null;
      InterfazInfo info = null;
      DAOINTRET daointret = new DAOINTRET();
      
      try {
          gestor = CMNEjbLocators.getMONGestorInterfacesHome();            
          gint = gestor.create();
          info = new InterfazInfo
                    (IGestorInterfaces.COD_INTERFAZ_RET1
                    ,dto.getNumeroLote().toString()
                    ,dto.getOidPais());
                      
          info.setNumeroLote(dto.getNumeroLote().toString());
          info.setDescripcionLote(dto.getDescripcionLote());
          info.setObservaciones(dto.getObservaciones());
          info.setCodigoInterfaz(IGestorInterfaces.COD_INTERFAZ_RET1);
          info.setPais(dto.getOidPais());

          //modificado por Sapaza, fecha 22-10-2007, cambio Sicc20070396, se verifica si viene de la llamada
          //desde BizTalk o desde el sistema SICC
          if(dto.getNombreArchivo() == null)
            info = gint.importarInterfaz(info);
          else  
            info = gint.importarInterfaz(info, dto.getNombreArchivo());
            
          registro = gint.cargarRegistro(info,false);
          CabeceraReclamoLocalHome crlh = new CabeceraReclamoLocalHome();
            
          /* Declaracion de Variables para campos opcionales en Archivo: */
          String tipoDocumentoArch;
          String motivoBloqueoArch;
          String motivoRechazoArch;
          String motivoDesbloqueoArch;
          String tipoIngresoArch;
          String territorioClienteArch;            
            
          while (registro!=null) {                
              Long oidPais = null;
              Long oidPeriodoDocumentoReferencia = null;
              Long oidCliente = null;
              Long oidTipoCliente = null;
              Long oidSubtipoCliente = null;
              Long oidTipoDocumento = null;
              Long oidEstadoReclamo = null;
              Long oidMotivoBloqueo = null;
              Long oidMotivoRechazo = null;
              Long oidMotivoDesbloqueo = null;
              Long oidTipoIngreso = null;
              Long oidTerritorioAdministrativo = null;
              Long oidSolicitudCabecera = null;
              Long periodoReclamo = null;
              String numeroDocumento = null; 
              CabeceraReclamoLocal cabeceraReclamo = null;
              Collection cabeceras = null;
                              
              try {
                  /* gPineda - 09/02/2007 - INT-001 CAMBIO
                   * Se busca por nroAtenInteArchivo y luego por nroAtenArchivo. (Manuel Rivas)
                   */
                  String nroAtenArchivo = ((String) registro.obtenerCampo(
                                                      RET.NRO_ATENCION)).trim();
                  String nroAtenInteArchivo = ((String) registro.obtenerCampo(
                                                      RET.NRO_ATENCION_INTE)).trim();
                  UtilidadesLog.debug("Param. busqueda Cabec.:"+ nroAtenInteArchivo +", "+nroAtenArchivo+", "+ dto.getOidPais());
                  Long oidCabeceraReclamo = daointret.obtenerOidCabeceraReclamo(nroAtenArchivo,
                                    nroAtenInteArchivo,
                                    dto.getOidPais());
                                   
                  boolean existe = false;  
                  if( oidCabeceraReclamo != null ) {
                      UtilidadesLog.debug("La CabeceraReclamo ya existe");
                      /*Iterator it = cabeceras.iterator();
                      cabeceraReclamo = (CabeceraReclamoLocal) it.next(); */
                      cabeceraReclamo = crlh.findByPrimaryKey( oidCabeceraReclamo );
                      existe = true;
                  }
                  
                  if( cabeceraReclamo == null ){
                      UtilidadesLog.debug("La CabeceraReclamo no existe");
                      existe = false;
                      
                      if( nroAtenInteArchivo== null || nroAtenInteArchivo.equals("") ){
                          UtilidadesLog.debug("como tampoco hay nroAtenInteArchivo se continua con el proximo registro. ");
                          registro = gint.cargarRegistro(info,false);//para evitar el bucle infinito
                          continue;
                      }
                      
                      DTONumeroSolicitud dtoNumero = new DTONumeroSolicitud();
                      dtoNumero.setOidPais(dto.getOidPais());
                      dtoNumero.setOidIdioma(dto.getOidIdioma());
                      dtoNumero.setOperacion(RET.NUEVO_DOCUMENTO_RECLAMOS);

                      // RI 20090914 - Cambio en el modo de generar el numero de atencion de reclamo
                      numeroDocumento = this.generarNumeroDocumento(dtoNumero);
                      UtilidadesLog.debug("numero de atencion generado: " + numeroDocumento);

                  }
                
                
                  oidPais = daointret.obtenerPais(((String)registro.
                                                      obtenerCampo(RET.PAIS)).trim());
                  
                  oidPeriodoDocumentoReferencia = daointret.obtenerPeriodo(
                                 oidPais, 
                                 ((String)registro.obtenerCampo(RET.COD_MARCA)).trim(), 
                                 ((String)registro.obtenerCampo(RET.COD_CANAL)).trim(), 
                                 ((String)registro.obtenerCampo(RET.PERIODO_DOC_REFERENCIA)).trim()); 
                  
                  oidCliente = daointret.obtenerCliente(oidPais, 
                                 ((String)registro.obtenerCampo(RET.COD_CLIENTE)).trim()); 
                  
                  oidTipoCliente = daointret.obtenerTipoCliente(
                                 ((String)registro.obtenerCampo(RET.COD_TIPO_CLIENTE)).trim()); 
                  
                  oidSubtipoCliente = daointret.obtenerSubtipoCliente(
                                 oidTipoCliente, 
                                 ((String)registro.obtenerCampo(RET.COD_SUBTIPO_CLIENTE)).trim());
                    
                  tipoDocumentoArch = (String)registro.obtenerCampo(RET.TIPO_DOCUMENTO);
                  tipoDocumentoArch = tipoDocumentoArch.trim();
                  oidTipoDocumento = (tipoDocumentoArch != null && !tipoDocumentoArch.equals(""))
                      ? daointret.obtenerTipoDocumento(tipoDocumentoArch)
                      : null;
                  
                  UtilidadesLog.debug("SCS, oidTipoDocumento es: " + oidTipoDocumento);
                              
                  oidEstadoReclamo = daointret.obtenerEstadoReclamo( 
                             ((String)registro.obtenerCampo(RET.ESTADO_RECLAMO)).trim()); 
                    
                  motivoBloqueoArch = (String)registro.obtenerCampo(RET.MOTIVO_BLOQUEO);
                  motivoBloqueoArch = motivoBloqueoArch.trim();
                  oidMotivoBloqueo = (motivoBloqueoArch != null && !motivoBloqueoArch.equals(""))
                      ? daointret.obtenerMotivoBloqueo(oidPais, motivoBloqueoArch)
                      : null;
                    
                  motivoRechazoArch = (String)registro.obtenerCampo(RET.MOTIVO_RECHAZO);
                  motivoRechazoArch = motivoRechazoArch.trim();
                  oidMotivoRechazo = (motivoRechazoArch != null && !motivoRechazoArch.equals(""))
                      ? daointret.obtenerMotivoRechazoDesbloqueo(oidPais, motivoRechazoArch)
                      : null;
                    
                  motivoDesbloqueoArch = (String)registro.obtenerCampo(RET.MOTIVO_DESBLOQUEO);
                  motivoDesbloqueoArch = motivoDesbloqueoArch.trim();
                  oidMotivoDesbloqueo = (motivoDesbloqueoArch != null && !motivoDesbloqueoArch.equals(""))
                      ? daointret.obtenerMotivoRechazoDesbloqueo(oidPais, motivoDesbloqueoArch)
                      : null;
                    
                  tipoIngresoArch = (String)registro.obtenerCampo(RET.TIPO_INGRESO);
                  tipoIngresoArch = tipoIngresoArch.trim();
                  oidTipoIngreso = (tipoIngresoArch != null && !tipoIngresoArch.equals(""))
                      ? daointret.obtenerTipoIngreso(tipoIngresoArch)
                      : null;
                    
                  territorioClienteArch = (String)registro.obtenerCampo(RET.TERRITORIO_CLIENTE);
                  territorioClienteArch = territorioClienteArch.trim();
                  oidTerritorioAdministrativo = (territorioClienteArch != null && !territorioClienteArch.equals(""))
                      ? daointret.obtenerTerritorioAdministrativo(
                                oidPais, 
                                ((String)registro.obtenerCampo(RET.COD_MARCA)).trim(), 
                                ((String)registro.obtenerCampo(RET.COD_CANAL)).trim(),
                                territorioClienteArch)
                      : null;
                                 
                  oidSolicitudCabecera = daointret.
                          obtenerSolicitudCabecera(oidPais, 
                          ((String)registro.obtenerCampo(RET.SUBACCESO)).trim(), 
                          ((String)registro.obtenerCampo(RET.NRO_DOC_REFERENCIA)).trim(), 
                          ((String)registro.obtenerCampo(RET.COD_ACCESO)).trim(), 
                          ((String)registro.obtenerCampo(RET.COD_CANAL)).trim()); 
                
                  periodoReclamo = daointret.obtenerPeriodo(oidPais, 
                            ((String)registro.obtenerCampo(RET.COD_MARCA)).trim(), 
                            ((String)registro.obtenerCampo(RET.COD_CANAL)).trim(), 
                            ((String)registro.obtenerCampo(RET.PERIODO_RECLAMO)).trim()); 
                               
                  Long numeroReclamo = null;
                  BigDecimal totalEnvia = null;
                  BigDecimal totalDevuelve = null;
                  BigDecimal saldoPagar = null;
                    
                  numeroReclamo = Long.valueOf(((String)registro.
                                                 obtenerCampo(RET.NRO_RECLAMO)).trim()); 
                  try {
                      totalEnvia = new BigDecimal(((String)registro.
                                                 obtenerCampo(RET.TOTAL_ENVIA)).trim()); 
                        
                      totalDevuelve = new BigDecimal(((String)registro.
                                                 obtenerCampo(RET.TOTAL_DEVUELVE)).trim()); 
                        
                      saldoPagar = new BigDecimal(((String)registro.
                                                 obtenerCampo(RET.SALDO_PAGAR)).trim()); 
                  } catch (Exception e) {
                      UtilidadesLog.debug("ERROR EN EL PARSEO DE LOS NUMEROS",e);
                      totalEnvia = new BigDecimal(0);
                      totalDevuelve = new BigDecimal(0);
                      saldoPagar = new BigDecimal(0);
                  }
    
                    
                  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                  SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
                  java.sql.Date fechaIngreso = null;
                  java.sql.Date fechaDocumentoReferencia = null;
                  java.util.Date fecha = null;
                  try {
                      fecha = sdf.parse(((String)registro.
                                            obtenerCampo(RET.FECHA_DOC_REFERENCIA)).trim());         
                      fechaDocumentoReferencia =
                                        java.sql.Date.valueOf(sdfSQL.format(fecha));
                  } catch (ParseException pe) {                      
                      UtilidadesLog.debug("Error de lectura de interfaz RET-1 "+
                                          "en fechaDocumentoReferencia");
                      DTOINTError dtoError = new DTOINTError(info,registro,    
                                          ErroresDeNegocio.INT_0096 + 
                                          registro.obtenerCampo(RET.NRO_ATENCION));
                      gint.registrarError(dtoError);
                  }
                  try {
                      fecha = sdf.parse(((String)registro.
                                        obtenerCampo(RET.FECHA_INGRESO)).trim());
                      fechaIngreso = java.sql.Date.valueOf(sdfSQL.format(fecha));                                               
                  } catch (ParseException pe) {                      
                      UtilidadesLog.debug("Error de lectura de interfaz RET-1 "+
                                          "en fechaIngreso");
                      DTOINTError dtoError = new DTOINTError(info,registro,    
                                          ErroresDeNegocio.INT_0096 + " " +
                                          registro.obtenerCampo(RET.NRO_ATENCION));
                      gint.registrarError(dtoError);
                  }
    
                  String usuarioIngreso = ((String)registro.
                                      obtenerCampo(RET.USUARIO_INGRESO)).trim(); 
                                             
                  if (existe) {
                      cabeceraReclamo.setPais(oidPais);
                      cabeceraReclamo.setPeriodoDocumentoReferencia(
                                                 oidPeriodoDocumentoReferencia);
                      cabeceraReclamo.setCliente(oidCliente);
                      cabeceraReclamo.setTipoCliente(oidTipoCliente);
                      cabeceraReclamo.setSubTipoCliente(oidSubtipoCliente);
                      cabeceraReclamo.setTipoDocumento(oidTipoDocumento);
                      cabeceraReclamo.setEstadoReclamo(oidEstadoReclamo);
                      cabeceraReclamo.setMotivoBloqueo(oidMotivoBloqueo);
                      cabeceraReclamo.setMotivoRechazo(oidMotivoRechazo);
                      cabeceraReclamo.setMotivoDesbloqueo(oidMotivoDesbloqueo);
                      cabeceraReclamo.setTipoIngreso(oidTipoIngreso);
                      cabeceraReclamo.setUnidadAdministrativaCliente(
                                                   oidTerritorioAdministrativo);
                      cabeceraReclamo.setNumeroDocumentoReferencia(
                                                          oidSolicitudCabecera);
                      cabeceraReclamo.setPeriodoReclamo(periodoReclamo);
                      cabeceraReclamo.setNumeroReclamo(numeroReclamo);
                      cabeceraReclamo.setTotalEnvia(totalEnvia);
                      cabeceraReclamo.setTotalDevuelve(totalDevuelve);
                      cabeceraReclamo.setSaldoPagar(saldoPagar);
                      cabeceraReclamo.setFechaDocumentoReferencia(
                                                      fechaDocumentoReferencia);
                      cabeceraReclamo.setFechaIngreso(fechaIngreso);
                      cabeceraReclamo.setUsuarioIngreso(usuarioIngreso);
                      UtilidadesLog.debug("   La CabeceraReclamo fue Actualizada");
                  } else {
                      cabeceraReclamo = crlh.create(
                                   Long.valueOf(numeroDocumento), 
                                   numeroReclamo, oidPais, oidSolicitudCabecera, 
                                   oidPeriodoDocumentoReferencia, oidCliente,  
                                   periodoReclamo,  oidSubtipoCliente, 
                                   oidTipoDocumento, oidEstadoReclamo,  
                                   oidTipoCliente);
                      cabeceraReclamo.setMotivoBloqueo(oidMotivoBloqueo);
                      cabeceraReclamo.setMotivoRechazo(oidMotivoRechazo);
                      cabeceraReclamo.setMotivoDesbloqueo(oidMotivoDesbloqueo);
                      cabeceraReclamo.setTipoIngreso(oidTipoIngreso);
                      cabeceraReclamo.setUnidadAdministrativaCliente(
                                                   oidTerritorioAdministrativo);
                      cabeceraReclamo.setTotalEnvia(totalEnvia);
                      cabeceraReclamo.setTotalDevuelve(totalDevuelve);
                      cabeceraReclamo.setSaldoPagar(saldoPagar);
                      cabeceraReclamo.setFechaDocumentoReferencia(
                                                      fechaDocumentoReferencia);
                      cabeceraReclamo.setFechaIngreso(fechaIngreso);
                      cabeceraReclamo.setUsuarioIngreso(usuarioIngreso);
                      cabeceraReclamo.setNumeroAtencionInterface(Long.valueOf(nroAtenInteArchivo));
                      UtilidadesLog.debug("   La CabeceraReclamo fue Creada");
                  }
                  
                  crlh.merge(cabeceraReclamo);
                  
                  UtilidadesLog.debug("...fue procesada la CabeceraReclamo cuyo oid es_" + cabeceraReclamo.getOid());
              } catch (MareException me) {
                  UtilidadesLog.debug("setRollbackOnly");
                  sessionContext.setRollbackOnly();
                  UtilidadesLog.error("Error de lectura de interfaz RET-1 ",me);
                  DTOINTError dtoError = new DTOINTError(info,registro,    
                                      ErroresDeNegocio.INT_0096 + " " +
                                      registro.obtenerCampo(RET.NRO_ATENCION));
                  gint.registrarError(dtoError);      
                  throw new MareException(ErroresDeNegocio.INT_0096 + " " +
                                      registro.obtenerCampo(RET.NRO_ATENCION), me.getCause(), me.getCode());
                  //throw me;
              } catch (Exception e){
                  UtilidadesLog.debug("setRollbackOnly");
                  sessionContext.setRollbackOnly();
                  UtilidadesLog.error("Error de lectura de interfaz RET-1 ",e);
                  throw e;
              }
              registro = gint.cargarRegistro(info,false);//siguiente
          } // fin while
          gint.cerrarInterfaz(info);
            
      } catch (CreateException ce) {
            UtilidadesLog.error(ce);
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));        
      } catch (NamingException ne) {
            UtilidadesLog.error(ne);        
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException re) {
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            if (re.detail != null && re.detail instanceof InterfacesException) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  
                    ((InterfacesException)re.detail).getMotivo() ,re.detail);                
            } else {                                
                throw new MareException(re.detail != null? re.detail: re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }        
      } catch (InterfacesException ie) {
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("Excepcion de la Interfaz " +  ie.getMotivo()  +
                            " ( "+ ie.getEx() + " )", ie );
            throw new MareException(ie.getMotivo(), ie);
      } catch (Exception e){
          UtilidadesLog.error(e);
          UtilidadesLog.debug("setRollbackOnly");
          sessionContext.setRollbackOnly();
          throw new MareException(e,
          UtilidadesError.armarCodigoError(
          CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));        
      }
      
      UtilidadesLog.info("MONINTRETBean.recepcionarReclamosCabecera(DTOINT dto): Salida");
  }


    private String generarNumeroDocumento(DTONumeroSolicitud dtoNumero) throws MareException {
        UtilidadesLog.info("MONINTRETBean.generarNumeroDocumento(): entrada");
        String numeroDocumento;
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT ("); 
        query.append(" SELECT COD_PAIS"); 
        query.append(" FROM SEG_PAIS"); 
        query.append(" WHERE OID_PAIS = ").append(dtoNumero.getOidPais());
        query.append(" ) COD_PAIS,"); 
        query.append(" ("); 
        query.append(" SELECT COD_SBAC"); 
        query.append(" FROM SEG_SUBAC"); 
        query.append(" WHERE OID_SBAC = ").append(dtoNumero.getOidSubacceso());
        query.append(" ) COD_SBAC"); 
        query.append(" FROM DUAL");
        
        RecordSet rs = null;
        
        rs = UtilidadesBD.executeQuery(query.toString());
        ArrayList arrayParametros = new ArrayList();
        
        arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_PAIS")));

        if (rs.getValueAt(0, "COD_SBAC") != null) {
            arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_SBAC")));
        } else {
            arrayParametros.add("_");
        }
        
        arrayParametros.add(dtoNumero.getOperacion());
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Date currentYear = new Date( System.currentTimeMillis());
        String yy = sdf.format(currentYear);
        arrayParametros.add(new Integer(yy));
        
        String numeroSolicitud = null;
        try {
            numeroSolicitud = this.getMONDigitacionInicialLocal().ejecutarFuncionGeneraNumeros(arrayParametros);
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR al localizar un componente EJB",ne);
            throw new MareException(ne);
        }
        
        StringBuffer numeroFormateado = new StringBuffer();
        numeroFormateado.append(cerosIzq(yy.toString(), 2));
        numeroFormateado.append(cerosIzq(numeroSolicitud, 8));
        numeroDocumento = numeroFormateado.toString();
        
        UtilidadesLog.info("MONINTRETBean.generarNumeroDocumento(): salida");
        return numeroDocumento;      
    }


    private String cerosIzq(String cadenaEntrada, int cantidadCeros) {
        StringBuffer cadenaSalida = new StringBuffer("");
        for(int i=0; i < cantidadCeros - cadenaEntrada.length() ;i++) {
            cadenaSalida.append("0");
        }
        return cadenaSalida.append(cadenaEntrada.toString()).toString();
    }    



  /**
   * CHANGELOG
   * ---------
   * Inc.BELC300023121 - Campos opcionales en el archivo.
   * Inc.DBLG500001068 - Se recupera Cabecera con numeroAtencion
   *                     del archivo, comparado a NUM_ATEN_INTE
   * Inc.SiCC 20090906 - dmorello, 28/04/2009 - Se agrega merge para las entidades utilizadas
   */ 
  public void recepcionarOperacionReclamo(DTOINT dto) throws MareException {
      UtilidadesLog.info("MONINTRETBean.recepcionarOperacionReclamo(DTOINT dto): Entrada");
      
      MONGestorInterfacesHome gestor;
      MONGestorInterfaces gint = null;
      IRegistroSicc registro = null;
      InterfazInfo info = null;
      DAOINTRET daointret = new DAOINTRET();
      
      try {
            gestor = CMNEjbLocators.getMONGestorInterfacesHome();            
            gint = gestor.create();
            info = new InterfazInfo
                      (IGestorInterfaces.COD_INTERFAZ_RET2
                      ,dto.getNumeroLote().toString()
                      ,dto.getOidPais());
                      
            info.setNumeroLote(dto.getNumeroLote().toString());
            info.setDescripcionLote(dto.getDescripcionLote());
            info.setObservaciones(dto.getObservaciones());
            info.setCodigoInterfaz(IGestorInterfaces.COD_INTERFAZ_RET2);
            info.setPais(dto.getOidPais());
            
            //modificado por Sapaza, fecha 22-10-2007, cambio Sicc20070396, se verifica si viene de la llamada
            //desde BizTalk o desde el sistema SICC
            if(dto.getNombreArchivo() == null)
              info = gint.importarInterfaz(info);
            else  
              info = gint.importarInterfaz(info, dto.getNombreArchivo());
            
            registro = gint.cargarRegistro(info,false);

            OperacionReclamoLocalHome orlh = new OperacionReclamoLocalHome();
            
            /* Declaracion de Variables para campos opcionales en Archivo: */
            String tipoBloqueoArch;
            String motivoBloqueoArch;
            String indEntregaMercaderiaArch;
            String asumePerdidaArch;
            String codArticuloArch;
            String clienteSeguroArch;
            String motivoRechazoArch;
            String motivoDesbloqueoArch;
            String precioPerdidaArch;
            String responsablePerdidaArch;
            String tipoSolicitudPerdidaArch;
            
            
            while (registro!=null) {
                
                Long oidPais = null;
                Integer numeroSecuencialOperacion = null;
                BigDecimal montoPerdida = null;
                Double porcentajePerdida = null;
                Long oidCabeceraReclamo = null;
                Long oidTipoBloqueo = null;
                Long oidMotivoBloqueo = null;
                Long oidPeriodo = null;
                Long oidIndicadorEntregaMercaderia = null;
                Long oidAsumePerdida = null;
                Long oidProducto = null;
                Long oidCliente = null;
                Long oidMotivoRechazo = null;
                Long oidMotivoDesbloqueo = null;
                Long oidPrecioPerdida = null;
                Long oidEstadoOperacion = null;
                Long oidResponsablePerdida = null;
                Long oidSolicitudCabecera = null;
                Long oidPeriodoReclamo = null;
                Long oidTipoSolicitud = null;
                Long oidTipoOperacion = null;
                Long indicadorAtendido = null;
                
                UtilidadesLog.debug("regitro: "+ registro );
                
                String nroAtenArchivo = ((String) registro.obtenerCampo(
                                                          RET.NRO_ATENCION)).trim();
                String nroAtenArchivoInte = ((String) registro.obtenerCampo(
                                                          RET.NRO_ATENCION_INTE)).trim();
                boolean existe = false;  
                
                try {
                    /* gPineda - DBLG700000316 - 02/02/2007
                     * Se busca con el nroAtencion del archivo = nroAtencionInterfaz en la BD 
                     */ 
                      UtilidadesLog.debug("Param. busqueda Cabec.:"+nroAtenArchivo +" "+ nroAtenArchivoInte +" "+  dto.getOidPais());
                      oidCabeceraReclamo = daointret.obtenerOidCabeceraReclamo(nroAtenArchivo, 
                                        nroAtenArchivoInte,
                                        dto.getOidPais());
                      existe = true;
                } catch (MareException me) {
                      UtilidadesLog.error("No existe la cabecera de reclamo",me);
                      
                      UtilidadesLog.debug("Error de lectura de interfaz RET-2 "+
                                      "en cabeceraReclamo");
                      DTOINTError dtoError = new DTOINTError(info,registro,    
                                        ErroresDeNegocio.INT_0094 + " " +
                                        registro.obtenerCampo(RET.NRO_ATENCION_INTE));
                      gint.registrarError(dtoError);                       
                      existe = false;
                }
                
                //daointret
                if (existe) {
                    existe = false;
                    
                    OperacionReclamoLocal operacionReclamo = null;
                    try {
                          operacionReclamo = orlh.findByUK(oidCabeceraReclamo,
                                        Integer.valueOf(((String)registro.obtenerCampo(
                                        RET.NRO_SECUENCIAL_OPERACION)).trim()));
                          existe = true;
                    } catch (NoResultException fe) {
                          UtilidadesLog.debug("No existe la operacion de reclamo,"+
                                          " se genera una nueva.");
                          existe = false;
                    }
                
                  try {
                  
                       oidPais = daointret.obtenerPais(((String)registro.
                                                            obtenerCampo(RET.PAIS)).trim());

                       numeroSecuencialOperacion = Integer.valueOf(
                                              ((String)registro.obtenerCampo(
                                              RET.NRO_SECUENCIAL_OPERACION)).trim());
                      
                       montoPerdida = new BigDecimal(((String)registro.obtenerCampo(RET.MONTO_PERDIDA)).trim());
                      
                       porcentajePerdida = Double.valueOf(((String)registro.
                                        obtenerCampo(RET.PORCENTAJE_PERDIDA)).trim());
                       
                       tipoBloqueoArch = (String)registro.obtenerCampo(RET.TIPO_BLOQUEO);
                       tipoBloqueoArch = tipoBloqueoArch.trim();
                       oidTipoBloqueo = (tipoBloqueoArch != null && !tipoBloqueoArch.equals(""))
                           ? daointret.obtenerTipoBloqueo(oidPais, tipoBloqueoArch)
                           : null;
                       
                       motivoBloqueoArch = (String)registro.obtenerCampo(RET.MOTIVO_BLOQUEO);
                       motivoBloqueoArch = motivoBloqueoArch.trim();
                       oidMotivoBloqueo = (motivoBloqueoArch != null && !motivoBloqueoArch.equals(""))
                           ? daointret.obtenerMotivoBloqueo(oidPais, motivoBloqueoArch)
                           : null;
                      
                       oidPeriodo = daointret.obtenerPeriodo (oidPais, 
                              ((String)registro.obtenerCampo(RET.COD_MARCA)).trim(), 
                              ((String)registro.obtenerCampo(RET.COD_CANAL)).trim(), 
                              ((String)registro.obtenerCampo(RET.COD_PERIODO)).trim()); 
                       
                       indEntregaMercaderiaArch = (String)registro.obtenerCampo(RET.IND_ENTREGA_MERCADERIA);
                       indEntregaMercaderiaArch = indEntregaMercaderiaArch.trim();
                       oidIndicadorEntregaMercaderia = (indEntregaMercaderiaArch != null && !indEntregaMercaderiaArch.equals(""))
                           ? daointret.obtenerIndicadorEntregaMercaderia(indEntregaMercaderiaArch)
                           : null;
                       
                       asumePerdidaArch = (String)registro.obtenerCampo(RET.ASUME_PERDIDA);
                       asumePerdidaArch = asumePerdidaArch.trim();
                       oidAsumePerdida = (asumePerdidaArch != null && !asumePerdidaArch.equals(""))
                           ? daointret.obtenerAsumePerdida(asumePerdidaArch)
                           : null;
                       
                       codArticuloArch = (String)registro.obtenerCampo(RET.COD_ARTICULO);
                       codArticuloArch = codArticuloArch.trim();
                       oidProducto = (codArticuloArch != null && !codArticuloArch.equals(""))
                           ? daointret.obtenerProducto(oidPais, codArticuloArch)
                           : null;
                       
                       clienteSeguroArch = (String)registro.obtenerCampo(RET.CLIENTE_SEGURO);
                       clienteSeguroArch = clienteSeguroArch.trim();
                       oidCliente = (clienteSeguroArch != null && !clienteSeguroArch.equals(""))
                           ? daointret.obtenerCliente(oidPais, clienteSeguroArch)
                           : null;
                       
                       motivoRechazoArch = (String)registro.obtenerCampo(RET.MOTIVO_RECHAZO);
                       motivoRechazoArch = motivoRechazoArch.trim();
                       oidMotivoRechazo = (motivoRechazoArch != null && !motivoRechazoArch.equals(""))
                           ? daointret.obtenerMotivoRechazoDesbloqueo(oidPais, motivoRechazoArch)
                           : null;
                       
                       motivoDesbloqueoArch = (String)registro.obtenerCampo(RET.MOTIVO_DESBLOQUEO);
                       motivoDesbloqueoArch = motivoDesbloqueoArch.trim();
                       oidMotivoDesbloqueo = (motivoDesbloqueoArch != null && !motivoDesbloqueoArch.equals(""))
                           ? daointret.obtenerMotivoRechazoDesbloqueo(oidPais, motivoDesbloqueoArch)
                           : null;
                       
                       precioPerdidaArch = (String)registro.obtenerCampo(RET.PRECIO_PERDIDA);
                       precioPerdidaArch = precioPerdidaArch.trim();
                       oidPrecioPerdida = (precioPerdidaArch != null && !precioPerdidaArch.equals(""))
                           ? daointret.obtenerPrecioPerdida(precioPerdidaArch)
                           : null;
                       
                       oidEstadoOperacion = daointret.obtenerEstadoOperacion(
                                              RET.ESTADO_OPERACION_F); 
                       
                       responsablePerdidaArch = (String)registro.obtenerCampo(RET.RESPONSABLE_PERDIDA);
                       responsablePerdidaArch = responsablePerdidaArch.trim();
                       oidResponsablePerdida = (responsablePerdidaArch != null && !responsablePerdidaArch.equals(""))
                           ? daointret.obtenerCliente(oidPais, responsablePerdidaArch)
                           : null;
                       
                       oidSolicitudCabecera = daointret.
                        obtenerSolicitudCabecera(oidPais, 
                        ((String)registro.obtenerCampo(RET.SUBACCESO)).trim(), 
                        ((String)registro.obtenerCampo(RET.DOCUMENTO_REFERENCIA)).trim(), 
                        ((String)registro.obtenerCampo(RET.COD_ACCESO)).trim(),
                        ((String)registro.obtenerCampo(RET.COD_CANAL)).trim());
                        
                       oidPeriodoReclamo = daointret.obtenerPeriodo(oidPais, 
                          ((String)registro.obtenerCampo(RET.COD_MARCA)).trim(), 
                          ((String)registro.obtenerCampo(RET.COD_CANAL)).trim(), 
                          ((String)registro.obtenerCampo(RET.PERIODO_RECLAMO)).trim());
                       
                       tipoSolicitudPerdidaArch = (String)registro.obtenerCampo(RET.TIPO_SOLICITUD_PERDIDA);
                       tipoSolicitudPerdidaArch = tipoSolicitudPerdidaArch.trim();
                       oidTipoSolicitud = (tipoSolicitudPerdidaArch != null && !tipoSolicitudPerdidaArch.equals(""))
                           ? daointret.obtenerTipoSolicitud(oidPais, tipoSolicitudPerdidaArch)
                           : null;

                       oidTipoOperacion = daointret.
                            obtenerTipoOperacion(oidPais, 
                            ((String)registro.obtenerCampo(RET.COD_OPERACION)).trim(), 
                            ((String)registro.obtenerCampo(RET.TIPO_OPERACION)).trim()); 
                      
                       indicadorAtendido = Long.valueOf(((String)registro.
                                          obtenerCampo(RET.ATENDIDO)).trim());
                       
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
                        java.sql.Date fechaFacturacion = null;
                        java.util.Date fecha = null;
                        try {
                            fecha = sdf.parse(((String)registro.
                                                obtenerCampo(RET.FECHA_FACTURACION)).trim());         
                            fechaFacturacion =
                                            java.sql.Date.valueOf(sdfSQL.format(fecha));
                        } catch (ParseException pe) {
                            UtilidadesLog.debug("Error de lectura de interfaz RET-2 "+
                                            "en fechaFacturacion");
                        }

                        if (existe) {
                              operacionReclamo.setSecuencialOperacion(numeroSecuencialOperacion);
                              operacionReclamo.setMontoPerdida(montoPerdida);
                              operacionReclamo.setPorcentajePerdida(porcentajePerdida);
                              operacionReclamo.setNumeroAtencion(oidCabeceraReclamo);
                              operacionReclamo.setTipoBloqueo(oidTipoBloqueo);
                              operacionReclamo.setMotivoBloqueo(oidMotivoBloqueo);
                              operacionReclamo.setIndicativoEntregaMercaderia(
                                                  oidIndicadorEntregaMercaderia);
                              operacionReclamo.setAsumePerdida(oidAsumePerdida);
                              operacionReclamo.setArticulo(oidProducto);
                              operacionReclamo.setClienteSeguro(oidCliente);
                              operacionReclamo.setMotivoRechazo(oidMotivoRechazo);
                              operacionReclamo.setMotivoDesbloqueo(oidMotivoDesbloqueo);
                              operacionReclamo.setPrecioPerdida(oidPrecioPerdida);
                              operacionReclamo.setEstadoOperacion(oidEstadoOperacion);
                              operacionReclamo.setResponsablePerdida(oidResponsablePerdida);
                              operacionReclamo.setDocumentoReferencia(oidSolicitudCabecera);
                              operacionReclamo.setPeriodoReclamo(oidPeriodoReclamo);
                              operacionReclamo.setTipoSolicitudPerdida(oidTipoSolicitud);
                              operacionReclamo.setTipoOperacion(oidTipoOperacion);                              
                              operacionReclamo.setAtendido(
                                          Long.valueOf("1").equals(indicadorAtendido)?
                                          Boolean.TRUE:Boolean.FALSE);
                              operacionReclamo.setFechaFacturacion(fechaFacturacion);
                        } else {
                              operacionReclamo = orlh.create(numeroSecuencialOperacion, 
                                           oidCabeceraReclamo, oidPeriodoReclamo,
                                           oidTipoOperacion, 
                                           oidSolicitudCabecera);                              
                              operacionReclamo.setMontoPerdida(montoPerdida);
                              operacionReclamo.setPorcentajePerdida(porcentajePerdida);                              
                              operacionReclamo.setTipoBloqueo(oidTipoBloqueo);
                              operacionReclamo.setMotivoBloqueo(oidMotivoBloqueo);
                              operacionReclamo.setIndicativoEntregaMercaderia(
                                                  oidIndicadorEntregaMercaderia);
                              operacionReclamo.setAsumePerdida(oidAsumePerdida);
                              operacionReclamo.setArticulo(oidProducto);
                              operacionReclamo.setClienteSeguro(oidCliente);
                              operacionReclamo.setMotivoRechazo(oidMotivoRechazo);
                              operacionReclamo.setMotivoDesbloqueo(oidMotivoDesbloqueo);
                              operacionReclamo.setPrecioPerdida(oidPrecioPerdida);
                              operacionReclamo.setEstadoOperacion(oidEstadoOperacion);
                              operacionReclamo.setResponsablePerdida(oidResponsablePerdida);
                              operacionReclamo.setTipoSolicitudPerdida(oidTipoSolicitud);                                                         
                              operacionReclamo.setAtendido(
                                        Long.valueOf("1").equals(indicadorAtendido)?
                                        Boolean.TRUE:Boolean.FALSE);
                              operacionReclamo.setFechaFacturacion(fechaFacturacion);                                                
                        }
                        
                        orlh.merge(operacionReclamo);
                        
                    } catch (MareException me) {
                        UtilidadesLog.debug("setRollbackOnly");
                        sessionContext.setRollbackOnly();
                        UtilidadesLog.error("Error de lectura de interfaz RET-2",me);
                        DTOINTError dtoError = new DTOINTError(info,registro,    
                                ErroresDeNegocio.INT_0095 + " " +
                                registro.obtenerCampo(RET.NRO_ATENCION) + " " +
                                registro.obtenerCampo(RET.NRO_SECUENCIAL_OPERACION));
                        gint.registrarError(dtoError);                  
                        
                        throw new MareException(ErroresDeNegocio.INT_0095 + " " +
                                registro.obtenerCampo(RET.NRO_ATENCION) + " " +
                                registro.obtenerCampo(RET.NRO_SECUENCIAL_OPERACION), me.getCause(), me.getCode());
                        
                        //throw me;
                    } catch (Exception e){
                        UtilidadesLog.debug("setRollbackOnly");
                        sessionContext.setRollbackOnly();
                        UtilidadesLog.error("Error de lectura de interfaz RET-2",e);
                        throw e;
                    }
                }
                registro = gint.cargarRegistro(info,false);//siguiente
            }
            gint.cerrarInterfaz(info);
            
      } catch (CreateException ce) {
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("E",ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));        
      } catch (NamingException ne) {
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("E",ne);            
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException re) {
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            if (re.detail != null && re.detail instanceof InterfacesException) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  
                    ((InterfacesException)re.detail).getMotivo() ,re.detail);                
            } else {                                
                throw new MareException(re.detail != null? re.detail: re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }        
      } catch (InterfacesException ie) {
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("Excepcion de la Interfaz " +  ie.getMotivo()  +
                            " ( "+ ie.getEx() + " )", ie );
            throw new MareException(ie.getMotivo(), ie);
        
      }catch (Exception e ){
          UtilidadesLog.debug("setRollbackOnly");
          sessionContext.setRollbackOnly();
          UtilidadesLog.error("ERROR",e);            
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
            
      UtilidadesLog.info("MONINTRETBean.recepcionarOperacionReclamo(DTOINT dto): Salida");
  }

  /**
   * CHANGELOG
   * --------- 
   * Inc.BELC300023121 - Campos opcionales en el archivo.
   * Incidencia SiCC 20090906 - dmorello, 28/04/2009 - Agrego merge para entidad LineasOperacionReclamo
   */ 
  public void recepcionarLineaOperacionReclamo(DTOINT dto) throws MareException {
      UtilidadesLog.info("MONINTRETBean.recepcionarLineaOperacionReclamo(DTOINT dto): Entrada");
    
      MONGestorInterfacesHome gestor;
      MONGestorInterfaces gint = null;
      IRegistroSicc registro = null;
      InterfazInfo info = null;
      DAOINTRET daointret = new DAOINTRET();
      
      try {
            gestor = CMNEjbLocators.getMONGestorInterfacesHome();            
            gint = gestor.create();
            info = new InterfazInfo
                      (IGestorInterfaces.COD_INTERFAZ_RET3
                      ,dto.getNumeroLote().toString()
                      ,dto.getOidPais());
                      
            info.setNumeroLote(dto.getNumeroLote().toString());
            info.setDescripcionLote(dto.getDescripcionLote());
            info.setObservaciones(dto.getObservaciones());
            info.setCodigoInterfaz(IGestorInterfaces.COD_INTERFAZ_RET3);
            info.setPais(dto.getOidPais());

            //modificado por Sapaza, fecha 22-10-2007, cambio Sicc20070396, se verifica si viene de la llamada
            //desde BizTalk o desde el sistema SICC
            if(dto.getNombreArchivo() == null)
              info = gint.importarInterfaz(info);
            else  
              info = gint.importarInterfaz(info, dto.getNombreArchivo());
            
            registro = gint.cargarRegistro(info,false);
            LineasOperacionReclamoLocalHome lorlh = new LineasOperacionReclamoLocalHome();
            
            /* Declaracion de Variables para campos opcionales en Archivo: */
            String tipoOfertaArch;
            String precioPerdidaArch;
            String tipoPosicionArch;
            String codProductoArch;
            String dteEstrategiaArch;
            String dteNumeroOfertaArch;
            String dteLineaOfertaArch;
            String motivoDevolucionArch;
            String motivoDesbloqueoArch;
            String tipoSolicitudArch;
            
            
            while (registro!=null) {
                
                Long oidPais = null;                
                Long oidPrecioPerdida = null;
                Long oidProducto = null;
                Long oidPeriodo = null;
                Long oidMotivoRechazo = null;
                Long oidTipoSolicitud = null;   
                Long oidTipoPosicion = null;
                Long indicadorAtendido = null;                
                Long oidMatrizFacturacion = null;
                Long oidMotivoDevolucion = null;
                Long oidTipoMovimiento = null;
                Long oidTipoOferta = null;
                Long oidOperacionReclamo = null;
                Long indicadorAtentido = null;
                BigDecimal importeMontoPerdido = null;
                String indicadorEstado = null;
                Integer numeroUnidadesDevueltas = null;
                BigDecimal importeCargo = null;
                BigDecimal importeAbonar = null;
                BigDecimal precio = null;
                Integer numeroUnidadesReclamadas = null;
                Integer numeroLinea = null;
                
                String nroAtenArchivo = ((String) registro.obtenerCampo(
                                                          RET.NRO_ATENCION)).trim();
                String nroAtenArchivoInte = ((String) registro.obtenerCampo(
                                                          RET.NRO_ATENCION_INTE)).trim();
                boolean existe = false;  


                try {
                    /* gPineda - DBLG700000316 - 02/02/2007
                     * Se busca con el nroAtencion del archivo = nroAtencionInterfaz en la BD 
                     */ 
                      UtilidadesLog.debug("Param. busqueda Cabec.:"+nroAtenArchivo +" "+ nroAtenArchivoInte +" "+  dto.getOidPais());
                      oidOperacionReclamo = daointret.obtenerOidOperacionReclamo(nroAtenArchivo,
                                    nroAtenArchivoInte,
                                    Integer.valueOf(((String)registro.obtenerCampo(
                                    RET.NRO_SECUENCIAL_OPERACION)).trim()), dto.getOidPais());
                      existe = true;
                } catch (MareException me) {
                      UtilidadesLog.error("No existe la operacion de reclamo",me);
                      
                      UtilidadesLog.debug("Error de lectura de interfaz RET-3 "+
                                      "en cabeceraReclamo");
                      DTOINTError dtoError = new DTOINTError(info,registro,    
                                        ErroresDeNegocio.INT_0097 + " " +
                                        registro.obtenerCampo(RET.NRO_SECUENCIAL_OPERACION));
                      gint.registrarError(dtoError);                       
                      existe = false;
                }

                if (existe) {
                    existe = false;
                    
                    LineasOperacionReclamoLocal lineaoperacionReclamo = null;
                    try {
                          lineaoperacionReclamo = lorlh.findByUK(oidOperacionReclamo,
                                        Integer.valueOf(((String)registro.obtenerCampo(
                                        RET.NRO_LINEA)).trim()));
                          existe = true;
                    } catch (NoResultException fe) {
                          UtilidadesLog.debug("No existe la operacion de reclamo,"+
                                          " se genera una nueva.");
                          existe = false;
                    }
                
                  try {
                  
                      if( ! existe && ( nroAtenArchivoInte== null || nroAtenArchivoInte.equals("") ) ){
                          UtilidadesLog.debug("como tampoco hay nroAtenInteArchivo se continua con el proximo registro. ");
                          registro = gint.cargarRegistro(info,false);//para evitar el bucle infinito
                          continue;
                      }                  
                  
                       numeroLinea = Integer.valueOf(
                                              ((String)registro.obtenerCampo(
                                              RET.NRO_LINEA)).trim());
                      
                       numeroUnidadesReclamadas = Integer.valueOf(((String)registro.
                                            obtenerCampo(RET.UNIDADES_RECLAMADAS)).trim());                     
                      
                       precio = new BigDecimal(((String)registro.
                                        obtenerCampo(RET.PRECIO)).trim());                                        
                                        
                       importeAbonar = new BigDecimal(((String)registro.
                                        obtenerCampo(RET.IMPORTE_ABONO)).trim());
                      
                       importeCargo = new BigDecimal(((String)registro.
                                        obtenerCampo(RET.IMPORTE_CARGO)).trim());

                       numeroUnidadesDevueltas = Integer.valueOf(((String)registro.
                                        obtenerCampo(RET.NUMERO_UNIDADES_DEVUELTAS)).trim());                      

                       indicadorEstado = RET.ESTADO_OPERACION_E;
                                              
                       importeMontoPerdido = new BigDecimal(((String)registro.
                                        obtenerCampo(RET.MONTO_PERDIDA)).trim());  

                       indicadorAtentido = Long.valueOf(((String)registro.
                                        obtenerCampo(RET.ATENDIDO)).trim());
                       
                       tipoOfertaArch = (String)registro.obtenerCampo(RET.TIPO_OFERTA);
                       tipoOfertaArch = tipoOfertaArch.trim();
                       oidTipoOferta = (tipoOfertaArch != null && !tipoOfertaArch.equals(""))
                           ? daointret.obtenerTipoOferta(tipoOfertaArch,
                                   ((String)registro.obtenerCampo(RET.COD_CANAL)).trim())
                           : null;
                       
                       precioPerdidaArch = (String)registro.obtenerCampo(RET.PRECIO_PERDIDA);
                       precioPerdidaArch = precioPerdidaArch.trim();
                       oidPrecioPerdida = (precioPerdidaArch != null && !precioPerdidaArch.equals(""))
                           ? daointret.obtenerPrecioPerdida(precioPerdidaArch)
                           : null;
                       
                       oidPais = daointret.obtenerPais(((String)registro.
                                                        obtenerCampo(RET.PAIS)).trim());
                       
                       tipoPosicionArch = (String)registro.obtenerCampo(RET.TIPO_POSICION);
                       tipoPosicionArch = tipoPosicionArch.trim();
                       oidTipoPosicion = (tipoPosicionArch != null && !tipoPosicionArch.equals(""))
                           ? daointret.obtenerTipoPosicion(tipoPosicionArch)
                           : null;
                      
                       oidTipoMovimiento = daointret.obtenerTipoMovimiento( 
                            ((String)registro.obtenerCampo(RET.TIPO_MOVIMIENTO)).trim()); 
                       
                       codProductoArch = (String)registro.obtenerCampo(RET.COD_PRODUCTO);
                       codProductoArch = codProductoArch.trim();
                       oidProducto = (codProductoArch != null && !codProductoArch.equals(""))
                           ? daointret.obtenerProducto(oidPais, codProductoArch)
                           : null;
                       
                       oidPeriodo = daointret.obtenerPeriodo(oidPais, 
                            ((String)registro.obtenerCampo(RET.COD_MARCA)).trim(),
                            ((String)registro.obtenerCampo(RET.COD_CANAL)).trim(),
                            ((String)registro.obtenerCampo(RET.COD_PERIODO)).trim()); 
                       
                       dteEstrategiaArch = (String)registro.obtenerCampo(RET.DTE_ESTRATEGIA);
                       dteNumeroOfertaArch = (String)registro.obtenerCampo(RET.DTE_NUMERO_OFERTA);
                       dteLineaOfertaArch = (String)registro.obtenerCampo(RET.DTE_LINEA_LA_OFERTA);
                       dteEstrategiaArch = dteEstrategiaArch.trim();
                       dteNumeroOfertaArch = dteNumeroOfertaArch.trim();
                       dteLineaOfertaArch = dteLineaOfertaArch.trim();
                       
                       if ((dteEstrategiaArch != null && !dteEstrategiaArch.equals(""))
                               && (dteNumeroOfertaArch != null && !dteNumeroOfertaArch.equals(""))
                               && (dteLineaOfertaArch != null && !dteLineaOfertaArch.equals(""))
                               && (oidProducto != null)) {
                           oidMatrizFacturacion = daointret.obtenerMatrizFacturacion(
                                   oidPeriodo,
                                   oidPais,
                                   dteEstrategiaArch,
                                   Integer.valueOf(dteNumeroOfertaArch),
                                   oidProducto,
                                   Integer.valueOf(dteLineaOfertaArch));
                       } else {
                           oidMatrizFacturacion = null;
                       }
                       
                       motivoDevolucionArch = (String)registro.obtenerCampo(RET.MOTIVO_DEVOLUCION);
                       motivoDevolucionArch = motivoDevolucionArch.trim();
                       oidMotivoDevolucion = (motivoDevolucionArch != null && !motivoDevolucionArch.equals(""))
                           ? daointret.obtenerMotivoDevolucion(oidPais, motivoDevolucionArch)
                           : null;
                       
                       motivoDesbloqueoArch = (String)registro.obtenerCampo(RET.MOTIVO_DESBLOQUEO);
                       motivoDesbloqueoArch = motivoDesbloqueoArch.trim();
                       oidMotivoRechazo = (motivoDesbloqueoArch != null && !motivoDesbloqueoArch.equals(""))
                           ? daointret.obtenerMotivoRechazoDesbloqueo(oidPais, motivoDesbloqueoArch)
                           : null;
                       
                       tipoSolicitudArch = (String)registro.obtenerCampo(RET.TIPO_SOLICITUD);
                       tipoSolicitudArch = tipoSolicitudArch.trim();
                       oidTipoSolicitud = (tipoSolicitudArch != null && !tipoSolicitudArch.equals(""))
                           ? daointret.obtenerTipoSolicitud(oidPais, tipoSolicitudArch)
                           : null;
                       
                        if (existe) {
                              lineaoperacionReclamo.setNumeroLinea(numeroLinea);
                              lineaoperacionReclamo.setUnidadesReclamadas(numeroUnidadesReclamadas);
                              lineaoperacionReclamo.setPrecio(precio);
                              lineaoperacionReclamo.setImporteAbono(importeAbonar);
                              lineaoperacionReclamo.setImporteCargo(importeCargo);
                              lineaoperacionReclamo.setNumeroUnidadesDevueltas(numeroUnidadesDevueltas);
                              lineaoperacionReclamo.setIndicadorEstado(
                                                indicadorEstado!=null?
                                                new Character(indicadorEstado.charAt(0)):null);
                              lineaoperacionReclamo.setMontoPerdida(importeMontoPerdido);
                              lineaoperacionReclamo.setAtendido(
                                                Long.valueOf("1").equals(indicadorAtendido)?
                                                Boolean.TRUE:Boolean.FALSE);
                              lineaoperacionReclamo.setOperacion(oidOperacionReclamo);
                              lineaoperacionReclamo.setTipoOferta(oidTipoOferta);
                              lineaoperacionReclamo.setPrecioPerdida(oidPrecioPerdida);
                              lineaoperacionReclamo.setTipoPosicion(oidTipoPosicion);
                              lineaoperacionReclamo.setTipoMovimiento(oidTipoMovimiento);
                              lineaoperacionReclamo.setProducto(oidProducto);
                              lineaoperacionReclamo.setCodigoVenta(oidMatrizFacturacion);
                              lineaoperacionReclamo.setMotivoDevolucion(oidMotivoDevolucion);
                              lineaoperacionReclamo.setMotivoDesbloqueo(oidMotivoRechazo);
                              lineaoperacionReclamo.setTipoSolicitud(oidTipoSolicitud);
                        } else {
                              lineaoperacionReclamo = lorlh.create(numeroLinea, 
                                           oidOperacionReclamo, oidTipoOferta, 
                                           oidTipoPosicion, 
                                           oidTipoMovimiento, oidMotivoDevolucion);

                              lineaoperacionReclamo.setUnidadesReclamadas(numeroUnidadesReclamadas);
                              lineaoperacionReclamo.setPrecio(precio);
                              lineaoperacionReclamo.setImporteAbono(importeAbonar);
                              lineaoperacionReclamo.setImporteCargo(importeCargo);
                              lineaoperacionReclamo.setNumeroUnidadesDevueltas(numeroUnidadesDevueltas);
                              lineaoperacionReclamo.setIndicadorEstado(
                                                    indicadorEstado!=null?
                                                    new Character(indicadorEstado.charAt(0)):null);
                              lineaoperacionReclamo.setMontoPerdida(importeMontoPerdido);
                              lineaoperacionReclamo.setAtendido(
                                                    Long.valueOf("1").equals(indicadorAtendido)?
                                                    Boolean.TRUE:Boolean.FALSE);
                              lineaoperacionReclamo.setPrecioPerdida(oidPrecioPerdida);
                              lineaoperacionReclamo.setProducto(oidProducto);
                              lineaoperacionReclamo.setCodigoVenta(oidMatrizFacturacion);
                              lineaoperacionReclamo.setMotivoDesbloqueo(oidMotivoRechazo);
                              lineaoperacionReclamo.setTipoSolicitud(oidTipoSolicitud);                                             
                        }
                        
                        lorlh.merge(lineaoperacionReclamo);
                        
                    } catch (MareException me) {
                        UtilidadesLog.debug("setRollbackOnly");
                        sessionContext.setRollbackOnly();
                        UtilidadesLog.error("Error de lectura de interfaz RET-3 ",me);
                        DTOINTError dtoError = new DTOINTError(info,registro,    
                                ErroresDeNegocio.INT_0098 + " " + 
                                registro.obtenerCampo(RET.NRO_ATENCION) + " " +
                                registro.obtenerCampo(RET.NRO_SECUENCIAL_OPERACION) + " " +
                                registro.obtenerCampo(RET.NRO_LINEA));
                        gint.registrarError(dtoError); 
                        
                        throw new MareException(ErroresDeNegocio.INT_0098 + " " + 
                                registro.obtenerCampo(RET.NRO_ATENCION) + " " +
                                registro.obtenerCampo(RET.NRO_SECUENCIAL_OPERACION) + " " +
                                registro.obtenerCampo(RET.NRO_LINEA), me.getCause(), me.getCode());
                        
                        //throw me;
                    }                            
                }
                
                //modificado por Sapaza, fecha 07-12-2007, incidencia SiCC-20070513
                try {                
                    registro = gint.cargarRegistro(info,false);//siguiente
                } catch (InterfacesException ie) {
                    UtilidadesLog.error("ERROR cargarRegistro", ie);            
                    DTOINTError dtoError = new DTOINTError(info, null, ie.getMotivo());
                    gint.registrarError(dtoError); 

                    throw new MareException("RET-3 - " + ie.getMotivo(), ie);
                }      
                    
            }
            
            gint.cerrarInterfaz(info);
            
      } catch (CreateException ce) {
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            UtilidadesLog.error(ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_DE_INTERFAZ));        
      } catch (RemoteException re) {
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            if (re.detail != null && re.detail instanceof InterfacesException) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  
                    ((InterfacesException)re.detail).getMotivo() ,re.detail);                
            } else {                                
                throw new MareException(re.detail != null? re.detail: re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }        
      } catch (InterfacesException ie) {
            UtilidadesLog.debug("setRollbackOnly");
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("Excepcion de la Interfaz " +  ie.getMotivo()  +
                            " ( "+ ie.getEx() + " )", ie );
            throw new MareException(ie.getMotivo(), ie);
        
      }      
      catch (Exception e ){
          UtilidadesLog.debug("setRollbackOnly");
          sessionContext.setRollbackOnly();
          UtilidadesLog.error("ERROR",e);            
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("MONINTRETBean.recepcionarLineaOperacionReclamo(DTOINT dto): Salida");
  }


  /**
   * @author Emilio Noziglia
   * @since 14/12/2005
   * @param Object  
   * @return BigDecimal  
   * @reference Metodo de apoyo.
   */   
  private BigDecimal LongtoBig(Object num) {
      UtilidadesLog.info("MONINTRETBean.LongtoBig(Object num): Entrada");
      if (num != null) {
          UtilidadesLog.info("MONINTRETBean.LongtoBig(Object num): Salida");
          return (new BigDecimal(((Long) num).longValue()));
      } else {
          UtilidadesLog.info("MONINTRETBean.LongtoBig(Object num): Salida");
          return null;
      }
  }  


    /**
     * 22-10-2007       Modificado por Sapaza, cambio SiCC20070396. Servira para procesar los reclamos
     *                  enviados desde Calypso, pero que se lanzara cuando el demonio del SICC, recupere
     *                  el archivo del interfaz RET-I, que es creado por el sistema Biztalk, luego que termine
     *                  el proceso se envia la respuesta mediante la interfaz RET-F.
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoBatch
     */
    public DTOSalidaBatch recepcionarReclamosCalypsoINI(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTRETBean.recepcionarReclamosCalypsoINI(DTOBatch dtoBatch): Entrada");
        Cronometrador.startTransaction("MONINTRETBean.recepcionarReclamosCalypsoINI");
        
        ArrayList listRespuesta = new ArrayList();
        DTOINT dto = null;
        Long pais = null;
        String idBizTalk = null;
        String flagProceso = "1";
        String mensajeProceso = null;

        try {
            PaisLocalHome paisLocalHome = null;
            PaisLocal paisLocal = null;
            paisLocalHome = new PaisLocalHome();
        
            //recuperamos el pais de la interfaz
            DTOString dtoPais = (DTOString) dtoBatch.getDTOOnline();
            try {
                paisLocal = paisLocalHome.findByUk(dtoPais.getString("cadena"));
                pais = paisLocal.getOid();
            }catch (NoResultException fe) {
                UtilidadesLog.error("MONINTRETBean.recepcionarReclamosCalypsoINI: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            MONGestorInterfacesHome gestor;
            MONGestorInterfaces gint = null;
    
            gestor = CMNEjbLocators.getMONGestorInterfacesHome();            
            gint = gestor.create();
            
            InterfazInfo interfaz = gint.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_RETINI, paisLocal.getOid());

            //recuperamos los datos enviados por BizTalk: id, nombre archivo RET1,
            //nombre archivo RET2, nombre archivo RET3
            IRegistroSicc  registro = gint.cargarRegistro(interfaz,false);
            idBizTalk = (String) registro.obtenerCampo(IRegistroSicc.RETINI_CAMPO);

            registro = gint.cargarRegistro(interfaz,false);
            String archivoRET1 = (String) registro.obtenerCampo(IRegistroSicc.RETINI_CAMPO);

            registro = gint.cargarRegistro(interfaz,false);
            String archivoRET2 = (String) registro.obtenerCampo(IRegistroSicc.RETINI_CAMPO);

            registro = gint.cargarRegistro(interfaz,false);
            String archivoRET3 = (String) registro.obtenerCampo(IRegistroSicc.RETINI_CAMPO);

            UtilidadesLog.info("idBizTalk = " + idBizTalk);
            UtilidadesLog.info("archivoRET1 = " + archivoRET1);
            UtilidadesLog.info("archivoRET2 = " + archivoRET2);
            UtilidadesLog.info("archivoRET3 = " + archivoRET3);

            gint.cerrarInterfaz(interfaz);

            //recuperamos el numero de lote para el proceso de reclamos Calypso
            dto = cargaInicial(pais, IGestorInterfaces.COD_INTERFAZ_CPR1);

            //Validamos la existencia de los archivos de Reclamos
            validarExistenciaArchivo(IGestorInterfaces.COD_INTERFAZ_RET1, archivoRET1);
            validarExistenciaArchivo(IGestorInterfaces.COD_INTERFAZ_RET2, archivoRET2);
            validarExistenciaArchivo(IGestorInterfaces.COD_INTERFAZ_RET3, archivoRET3);

            //realizamos el proceso de carga de los reclamos enviados del sistema de Calypso
            getMonIntRetHome().create().recepcionarReclamosCalypsoBizTalk(dto, archivoRET1, archivoRET2, archivoRET3);
            
            flagProceso = "0";
            mensajeProceso = "Proceso Realizado Correctamente";
        }catch (InterfacesException ie) {
            mensajeProceso = ie.getMotivo();
        }catch (MareException me) {
            UtilidadesLog.error(me);
            mensajeProceso = me.getCause().getMessage();
        }catch (RemoteException re) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            mensajeProceso = re.getMessage();
        }catch (Exception e) {
            UtilidadesLog.error(e);
            mensajeProceso = e.getMessage();
        } finally {
            //Construimos el archivo de respuesta, del resultado de la ejecucion de proceso de reclamos
            String codigoInterfaz = IGestorInterfaces.COD_INTERFAZ_RETFIN;
            RegistroSicc registro = new RegistroSicc();
            MONGestorInterfacesHome gestor = null;
            MONGestorInterfaces gi = null;
            InterfazInfo interfazInfo = null;
            
            try {
                gestor = CMNEjbLocators.getMONGestorInterfacesHome();            
                gi = gestor.create();
                interfazInfo = new InterfazInfo(codigoInterfaz
                                        ,dto.getNumeroLote().toString()
                                        ,dto.getOidPais());
                          
                interfazInfo.setNumeroLote(dto.getNumeroLote().toString());
                interfazInfo.setDescripcionLote(dto.getDescripcionLote());
                interfazInfo.setObservaciones(dto.getObservaciones());
                interfazInfo.setCodigoInterfaz(codigoInterfaz);
                interfazInfo.setPais(dto.getOidPais());
            
                interfazInfo = gi.importarInterfaz(interfazInfo);
            } catch (Exception me) {            
                UtilidadesLog.debug(" [ " + codigoInterfaz + " ] Fallo al realizar init");
                throw new MareException(me.getMessage(), me);
            }

            //obtenemos los datos que mandaremos al fichero para enviar la situacion final del proceso            
            listRespuesta.add(idBizTalk);
            listRespuesta.add(flagProceso);
            listRespuesta.add(mensajeProceso);

            try{
                for(int i=0; i<listRespuesta.size();i++) {
                    registro.vaciar();
                    registro.anyadirCampo( IRegistroSicc.RETINI_CAMPO, (String)listRespuesta.get(i)); 

                    gi.anyadirRegistro(interfazInfo, registro);
                }
            }catch(RemoteException re){                         
                UtilidadesLog.debug(" [ "+codigoInterfaz+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (InterfacesException iex) {
                throw new MareException(iex.getMotivo(), iex);
            }
            
            try{ 
                interfazInfo.setObservaciones("FlagProceso="+flagProceso);
                gi.enviarInterfaz(interfazInfo);
            } catch (InterfacesException ie) {
                UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );            
            }catch(RemoteException re){                 
                UtilidadesLog.debug(" [ "+codigoInterfaz+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));              
            }
        }
    
        Cronometrador.endTransaction("MONINTRETBean.recepcionarReclamosCalypsoINI");    
        UtilidadesLog.info("MONINTRETBean.recepcionarReclamosCalypsoINI(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "recepcionarReclamosCalypsoINI finalizado");
    }

    private MONINTRETHome getMonIntRetHome() throws MareException {
        MONINTRETHome home = (MONINTRETHome) UtilidadesEJB.getHome("MONINTRET", MONINTRETHome.class);
        return home;        
    }


    public DTOINT cargaInicial(Long pais, String codigoInterfaz)
        throws MareException {
        UtilidadesLog.info("MONINTRETBean.cargaInicial(Long pais, String codigoInterfaz): Entrada");
        DTOINT dto = new DTOINT();      
 
        try{
            UtilidadesLog.debug("Metodo carga inicializaa la Interfaz");
            MONGestorInterfacesHome gI = CMNEjbLocators.getMONGestorInterfacesHome();            
            MONGestorInterfaces g = gI.create(); 
            UtilidadesLog.debug("antes de llamar al metodo obtenerInterfazInfo");
            UtilidadesLog.debug("MONGestorInterfaces "+ (g==null));
            InterfazInfo ii = g.obtenerInterfazInfo(codigoInterfaz, pais);
            UtilidadesLog.debug("InterfazInfo "+ (ii==null));
            
            dto.setOidPais(pais);
            dto.setNumeroLote(new Long(ii.getNumeroLote()));
            dto.setDescripcionLote("");
        }catch (RemoteException ne) {            
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ne) {            
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz "+ ie.getMotivo(), ie.getEx() != null? ie.getEx(): ie);
            throw new MareException( ie );
        }  catch (Exception e) {            
            UtilidadesLog.error(e);            
            throw new MareException("Error", e);
        }

        UtilidadesLog.debug("antes de devolver dtoI " + dto);  
        UtilidadesLog.info("MONINTRETBean.cargaInicial(Long pais, String codigoInterfaz): Salida");
        return dto;
    }
 
    public String validarExistenciaArchivo(String codigoInterfaz, String nombreArchivo) throws InterfacesException {
        String mensaje = null;
        List lista = null;

        try{
            InterfazDef def = RegistroDefs.obtenerInterfaz(codigoInterfaz);
            BuzonEntrada buzon = new BuzonEntrada(def.getPathBuzonES());
            UtilidadesLog.debug("Patron :" + def.getPatronNombreFicheros()); 
            lista = buzon.obtenerFicheros(nombreArchivo);
        }catch(InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
            throw new InterfacesException("Excepcion de la Interfaz: "+ ie.getMotivo());
        }

        if(lista == null || lista.isEmpty()){
			mensaje = "No se ha recibido el fichero de interfaz " + codigoInterfaz; 
			throw new InterfacesException( mensaje );
        }    

        return mensaje;
    }

    /**
     * 22-10-2007       Modificado por Sapaza, cambio SiCC20070396. se procesa las interfacez RET-1, RET-2, RET-3,
     *                  con los nombre de los archivos enviados por BizTalk
     * @throws es.indra.mare.common.exception.MareException
     * @param archivoRET3
     * @param archivoRET2
     * @param archivoRET1
     * @param dto
     */
    public void recepcionarReclamosCalypsoBizTalk(DTOINT dto, String archivoRET1, String archivoRET2, String archivoRET3) throws MareException {
        UtilidadesLog.info("MONINTRETBean.recepcionarReclamosCalypsoBizTalk(DTOINT dto, String archivoRET1, String archivoRET2, String archivoRET3): Entrada");
      
        dto.setNombreArchivo(archivoRET1);
        this.recepcionarReclamosCabecera(dto);
      
        dto.setNombreArchivo(archivoRET2);
        this.recepcionarOperacionReclamo(dto);
      
        dto.setNombreArchivo(archivoRET3);
        this.recepcionarLineaOperacionReclamo(dto);
      
        UtilidadesLog.info("MONINTRETBean.recepcionarReclamosCalypsoBizTalk(DTOINT dto, String archivoRET1, String archivoRET2, String archivoRET3): Salida");
    }

    private MONDigitacionInicialLocal getMONDigitacionInicialLocal() throws NamingException, MareException {

        MONDigitacionInicialLocalHome localHome = this.getMONDigitacionInicialLocalHome();
        // Se obtiene el interfaz remoto
        MONDigitacionInicialLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONDigitacionInicialLocalHome",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }

    private MONDigitacionInicialLocalHome getMONDigitacionInicialLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONDigitacionInicialLocalHome) context.lookup( "java:comp/env/ejb/local/MONDigitacionInicial" );
    }
}
