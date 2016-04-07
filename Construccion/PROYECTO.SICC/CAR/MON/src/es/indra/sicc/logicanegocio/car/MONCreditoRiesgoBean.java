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
 */
 
package es.indra.sicc.logicanegocio.car;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.correo.DTOCorreoElectronico;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronico;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronicoHome;
import es.indra.sicc.dtos.car.DTOCalculoPedidos;
import es.indra.sicc.dtos.car.DTOCreditoRiesgo;
import es.indra.sicc.dtos.car.DTONotificar;
import es.indra.sicc.dtos.car.DTOOrden;
import es.indra.sicc.dtos.car.DTOReevaluar;
import es.indra.sicc.dtos.car.DTOReevaluarEnMasa;
import es.indra.sicc.dtos.car.DTOTipoReevaluacion;
import es.indra.sicc.dtos.ccc.DTODias;
import es.indra.sicc.dtos.ccc.DTOSaldosPorDiasPeriodos;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotalyDias;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.car.DTOParametrosCalculo;
import es.indra.sicc.dtos.car.DTONivelRiesgo;
import es.indra.sicc.dtos.car.DTOParametrosEvaluacionNR;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.entidades.car.ParametrosCalculoLCLocal;
import es.indra.sicc.entidades.car.ParametrosCalculoLCLocalHome;

import es.indra.sicc.entidades.car.ParametrosGeneralesdeCarteraLocal;
import es.indra.sicc.entidades.car.ParametrosGeneralesdeCarteraLocalHome;
import es.indra.sicc.entidades.car.SolicitudesEntregaBloqueadasLocal;
import es.indra.sicc.entidades.car.SolicitudesEntregaBloqueadasLocalHome;

import es.indra.sicc.entidades.mae.ClienteBloqueoLocal;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocalHome;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocal;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.car.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.mae.IMaestroClientes;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.msg.IMSG;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
//import es.indra.sicc.logicanegocio.msg.MONMensajes;
//import es.indra.sicc.logicanegocio.msg.MONMensajesHome;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitud;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitudHome;
import es.indra.sicc.logicanegocio.ped.MONUtilidadesProcesos;
import es.indra.sicc.logicanegocio.ped.MONUtilidadesProcesosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.mail.internet.AddressException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONCreditoRiesgoBean implements SessionBean 
{

  private SessionContext ctx = null;
  Integer numeroMaximoSegmentos = null;
   
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
    this.ctx = ctx;
  }

  /*****************
  Autor: Viviana Bongiovanni
  Fecha: 05/01/2005
  Obtiene Credito Riesgo Consultora Nueva
  *********************/
  public DTOCreditoRiesgo obtenerCreditoRiesgoConsultoraNueva(Long pais, Long territorioAdministrativo) throws MareException{
    UtilidadesLog.info("MONCreditoRiesgo.obtenerCreditoRiesgoConsultoraNueva(Long , Long):Entrada");
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
        
        // Obtiene el credito Riesgo
        //VER !!!!!!!!!!!!!!!!!!!
        RecordSet rCreditoRiesgo = daoCAR.obtenerCreditoRiesgo(territorioAdministrativo); 
                
        DTOCreditoRiesgo dtoCR = new DTOCreditoRiesgo();
        
        if(!rCreditoRiesgo.esVacio()) {            
           dtoCR.setNivelRiesgo(new Long(((BigDecimal)rCreditoRiesgo.getValueAt(0, "NIVELRIESGO")).longValue()));
           dtoCR.setMontoLineaCredito((BigDecimal)rCreditoRiesgo.getValueAt(0, "LINEACREDITO"));
        }
        UtilidadesLog.info("MONCreditoRiesgo.obtenerCreditoRiesgoConsultoraNueva(Long , Long):Salida");
        return dtoCR;
        
  }

    public DTOSalida cargaOrdenesNotificar(DTOBelcorp dto) throws MareException
    {
        DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
        DTOSalida dtoSalida = daoCAR.obtieneOrdenesNotificar(dto);

        return dtoSalida;
    }

 /**
   * 
   * @Comentario: Realiza la notificación por e-mail para cada gerente de zona.    
   * @Fecha: 11/01/2005
   * @author: Cintia Argain
   * @throws es.indra.mare.common.exception.MareException
   * @param DTONotificar
   */
    public void notificarMail(DTONotificar dto) throws MareException{
        UtilidadesLog.info("MONCreditoRiesgo.notificarMail(DTONotificar):Entrada");
//Se crean las variables String sGerente, sMensaje y sDireccion. 

//sGerente = "" 
//sMensaje = "" 
//sDireccion = "" 

    //Por cada elemento en dto.ordenes 
//Si dto.ordenes(i).codGerenteZona <> sGerente 
//Si sGerente <> "" 
//sMensaje = ConstantesCAR.MENSAJE1 & " " & sMensaje & " " & ConstantesCAR.MENSAJE2 

//enviarMail(ConstantesCAR.ASUNTO_MENSAJE, sMensaje, sDireccion) 
//Fin del Si 

//sMensaje = "" 
//sDireccion = dto.ordenes(i).comunicacion 
//sGerente = dto.ordenes(i).codGerenteZona 
//Fin del Si 

//Si sMensaje <> "" 
//sMensaje = sMensaje & ", " 
//Fin del Si 
//sMensaje = sMensaje & dto.ordenes(i).numSolicitud 
//marcaNotificacion(dto.ordenes(i).oid) 
//Fin del Bucle 

//Si sMensaje <> "" 
//sMensaje = ConstantesCAR.MENSAJE1 & " " & sMensaje & " " & ConstantesCAR.MENSAJE2 

//enviarMail(ConstantesCAR.ASUNTO_MENSAJE, sMensaje, sDireccion) 
//Fin del Si
    try{
            String sGerente ="";
            String sMensaje ="";
            String sDireccion ="";
            ArrayList listaOrdenes = dto.getOrdenes();      
            Iterator itOrdenes = listaOrdenes.iterator();
          
            while (itOrdenes.hasNext() ){
                DTOOrden dtoO = (DTOOrden)itOrdenes.next();
                //Si dto.ordenes(i).codGerenteZona <> sGerente 
                if( !dtoO.getCodGerenteZona().equals(sGerente))
                {
                    if (!sGerente.equals(""))
                    {
                        sMensaje = ConstantesCAR.MENSAJE1 + " " + sMensaje + " " + ConstantesCAR.MENSAJE2;
                        try{
                        enviarMail(ConstantesCAR.ASUNTO_MENSAJE, sMensaje, sDireccion);        
                        } catch(AddressException ae){
                            UtilidadesLog.error("*** Direccion de mail invalida ");
                            continue;
                        }
                    }
                    sMensaje = "";
                    sDireccion = dtoO.getComunicacion();
                    sGerente = dtoO.getCodGerenteZona();
                }//Fin del Si 
                
                if (!sMensaje.equals(""))
                {
                    sMensaje = sMensaje + ", ";
                }//Fin del Si 
                
                sMensaje = sMensaje + dtoO.getNumSolicitud();        
                marcaNotificacion(dtoO.getOid());
            }//Fin del Bucle 
            
            if (!sMensaje.equals(""))
            {
                sMensaje = ConstantesCAR.MENSAJE1 + " " + sMensaje + " " + ConstantesCAR.MENSAJE2;
                enviarMail(ConstantesCAR.ASUNTO_MENSAJE, sMensaje, sDireccion);
            }//Fin del Si
        } catch(MareException me){
            UtilidadesLog.error(me);
            ctx.setRollbackOnly();
            throw me;
        } catch(AddressException ae){
            UtilidadesLog.error("*** Direccion de mail invalida ");
        }
        UtilidadesLog.info("MONCreditoRiesgo.notificarMail(DTONotificar):Salida");
    }
    

 /**
   * 
   * @Comentario: Marca una solicitud como notificada
   * @Fecha: 11/01/2005
   * @author: Cintia Argain
   * @throws es.indra.mare.common.exception.MareException
   * @param Long
   */
    public void marcaNotificacion(Long oid) throws MareException{
        UtilidadesLog.info("MONCreditoRiesgo.marcaNotificacion(Long):Entrada");
        try 
        {     
            //Se llama al método findByPrimaryKey de la entidad (EJB Entity) 
            //CAR:SolicitudesEntregaBloqueadas pasándole como parámetro de entrada oid 
            //Se actualiza el atributo Notificado de la entidad: 
            //CAR:SolicitudesEntregaBloqueadas.Notificado = True
            SolicitudesEntregaBloqueadasLocalHome solicitudesEntregaBloqueadasLH = this.getSolicitudesEntregaBloqueadasLocalHome();
            SolicitudesEntregaBloqueadasLocal solicitudesEntregaBloqueadas = 
            solicitudesEntregaBloqueadasLH.findByPrimaryKey(oid);
            solicitudesEntregaBloqueadas.setIndicadorNotificado(Boolean.TRUE);
            
            solicitudesEntregaBloqueadasLH.merge(solicitudesEntregaBloqueadas);
        
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONCreditoRiesgo.marcaNotificacion(Long):Salida");
    }
    

 /**
   * 
   * @Comentario: Envía un correo electrónico.
   * @Fecha: 11/01/2005
   * @author: Cintia Argain
   * @throws es.indra.mare.common.exception.MareException
   * @param String, String, String
   */
    public void enviarMail(String asunto, String mensaje, String direccion) throws MareException, AddressException
    {
        UtilidadesLog.info("MONCreditoRiesgo.enviarMail(String , String , String):Entrada");
        //Se crea un DTOCorreoElectronico (dtoCorreo) que se carga como sigue: 
        //dtoCorreo.asunto = asunto 
        //dtoCorreo.mensaje = mensaje 
        //dtoCorreo.direccion = direccion 
        
        //IServicioCorreoElectronico.enviarCorreo(dtoCorreo) 
        try{
                DTOCorreoElectronico dtoCorreo = new DTOCorreoElectronico();
                dtoCorreo.setAsunto(asunto);
                dtoCorreo.setMensaje(mensaje);
                dtoCorreo.setDireccion(direccion);
                String s = "";
                
                UtilidadesLog.debug("dtoCorreo: " + dtoCorreo);                
        
                MONServicioCorreoElectronico monCorreo = getMONServicioCorreoElectronicoHome().create();
                monCorreo.enviarCorreo(dtoCorreo, s);
        } catch(NamingException e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException re) {
            re.printStackTrace();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException re) {
            re.printStackTrace();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONCreditoRiesgo.enviarMail(String , String , String):Salida");
    }
    
    private MONServicioCorreoElectronicoHome getMONServicioCorreoElectronicoHome()
            throws NamingException {
            final InitialContext context = new InitialContext();
    
        return (MONServicioCorreoElectronicoHome)PortableRemoteObject.narrow(context.lookup("MONServicioCorreoElectronico"),
        MONServicioCorreoElectronicoHome.class);
    }
    
    
     /**
   * 
   * @Comentario: Marca la notificación de las órdenes con tipo de comunicación teléfono o fax. 
   * @Fecha: 11/01/2005
   * @author: Cintia Argain
   * @throws es.indra.mare.common.exception.MareException
   * @param DTOOIds
   */
    public void notificarTfnoFax(DTOOIDs dto) throws MareException
    {
        UtilidadesLog.info("MONCreditoRiesgo.notificarTfnoFax(DTOOIDs):Entrada");
        try {
            //Por cada elemento en el array dto.oids 
            //marcaNotificacion(dto.oids(i)) 
            //Fin del Bucle
            Long[] lOids = dto.getOids();
            
            for ( int i=0; i<lOids.length; i++)  {
                marcaNotificacion(lOids[i]);
            }
        } catch(MareException me){
            UtilidadesLog.error(me);
            ctx.setRollbackOnly();
            throw me;
        }
        UtilidadesLog.info("MONCreditoRiesgo.notificarTfnoFax(DTOOIDs):Salida");
    }
    
/*
      Se crea un DTOBelcorp (dtoB) que se carga como sigue: 
      dtoB.pais = dto.pais 
      dtoB.idioma = dto.idioma 
      
      DTOSalida dtoS = IPEDUtilidadesProcesos.consultaClasesSolicitudOrdenCompra(dtoB) 
      
      Se crea un DTOReevaluarEnMasa (dtoR) que se carga como sigue: 
      dtoR.pais = dto.pais 
      dtoR.idioma = dto.idioma 
      dtoR.oidMarca = dto.marca 
      dtoR.oidCanal = dto.canal 
      dtoR.oidClaseSolicitud = dtoS.resultado(0).oid 
      dtoR.oidPeriodo = dto.periodo 
      dtoR.procedencia = ConstantesCAR.TIPO_REEVALUACION_NR 
      dtoR.oidSubgerencia = null 
      dtoR.oidRegion = dto.region 
      dtoR.oidZona = null 
      dtoR.mensaje = False 
      
      reevaluarEnMasa(dtoR)
   
   */
  public void reevaluarNivelRiesgoMasaOffLine(DTOFACProcesoCierre dto) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.reevaluarNivelRiesgoMasaOffLine(DTOFACProcesoCierre):Entrada");
   /* DTOBelcorp dtoB = new DTOBelcorp();
    dtoB.setOidPais(dto.getOidPais());
    dtoB.setOidIdioma(dto.getOidIdioma()); 
    
    MONUtilidadesProcesos monPed = null;
    
    try {
        MONUtilidadesProcesosHome monPedHome = this.getMONUtilidadesProcesosHome();
        monPed = monPedHome.create();
    
        DTOSalida dtoS = monPed.consultaClasesSolicitudOrdenCompra(dtoB);
    
        UtilidadesLog.debug("consultaClasesSolicitudOrdenCompra: " + dtoS.getResultado());
        
        // Verifica que existan clase solicitud
        if(dtoS.getResultado().esVacio()) {    
           UtilidadesLog.error("No se encuentra ninguna clase de solicitud de orden de compra");
           throw new MareException(null, null, 
              UtilidadesError.armarCodigoError(
              ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0010));     
          
        } else {
        
            DTOReevaluarEnMasa dtoR = new DTOReevaluarEnMasa();
            dtoR.setOidPais(dto.getOidPais());
            dtoR.setOidIdioma(dto.getOidIdioma());
            dtoR.setOidMarca(dto.getMarca());
            dtoR.setOidCanal(dto.getCanal());
            if (dtoS != null && !dtoS.getResultado().esVacio()) {
              BigDecimal oid = (BigDecimal)dtoS.getResultado().getValueAt(0, "OID");
              dtoR.setOidClaseSolicitud(new Long(oid.longValue()));
            }
            dtoR.setOidPeriodo(dto.getPeriodo());
            dtoR.setProcedencia(ConstantesCAR.TIPO_REEVALUACION_NR);
            dtoR.setOidSubgerencia(null);
            dtoR.setOidRegion(dto.getRegion()); 
            dtoR.setOidZona(null);
            dtoR.setMensaje(Boolean.FALSE);
            
            UtilidadesLog.debug("dtoR: " + dtoR);
              
            reevaluarEnMasa(dtoR);
        }
    
    } catch (Exception Ne) {
        UtilidadesLog.error(Ne);
		}*/
    this.reevaluarNivelRiesgoMasaOffLinePerf(dto);
        UtilidadesLog.info("MONCreditoRiesgo.reevaluarNivelRiesgoMasaOffLine(DTOFACProcesoCierre):Salida");
  } 
  
  private MONUtilidadesProcesosHome getMONUtilidadesProcesosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONUtilidadesProcesosHome)PortableRemoteObject.narrow(context.lookup("MONUtilidadesProcesos"), MONUtilidadesProcesosHome.class);
  }
  
  private MONPedidosSolicitudHome getMONPedidosSolicitudHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONPedidosSolicitudHome)PortableRemoteObject.narrow(context.lookup("MONPedidosSolicitud"), MONPedidosSolicitudHome.class);
  }
  
  

  /**
   * 
   * @Comentario: Permite modificar el monto de la línea de crédito de cada cliente 
   * en el maestro de clientes. 
   * @Fecha: 11/01/2005
   * @author: Joaquin Alem
   * @throws es.indra.mare.common.exception.MareException
   * @param dto
   */
  public void reevaluarLineaCreditoMasaOffLine(DTOFACProcesoCierre dto) throws MareException
  {
          UtilidadesLog.info("MONCreditoRiesgo.reevaluarLineaCreditoMasaOffLine(DTOFACProcesoCierre):Entrada");
     /*     DTOBelcorp dtoB = new DTOBelcorp();
          dtoB.setOidPais(dto.getOidPais());
          dtoB.setOidIdioma(dto.getOidIdioma());
          
          MONUtilidadesProcesos monPed = null;
    
          try {
                MONUtilidadesProcesosHome monPedHome = this.getMONUtilidadesProcesosHome();
                monPed = monPedHome.create();
                DTOSalida dtoS = monPed.consultaClasesSolicitudOrdenCompra(dtoB);
                
                if(dtoS.getResultado().esVacio()) {   
                   UtilidadesLog.error("No se encuentra ninguna clase de solicitud de orden de compra");
                   throw new MareException(null, null, 
                      UtilidadesError.armarCodigoError(
                      ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0010));     
                  
                } else {
                    //Se crea un DTOReevaluarEnMasa (dtoR) que se carga como sigue:           
                    DTOReevaluarEnMasa dtoR = new DTOReevaluarEnMasa();
                    dtoR.setOidPais(dto.getOidPais());
                    dtoR.setOidIdioma(dto.getOidIdioma());
              
                    dtoR.setOidMarca(dto.getMarca());
                    dtoR.setOidCanal(dto.getCanal());
                    dtoR.setOidClaseSolicitud(new Long(((BigDecimal)(dtoS.getResultado().getValueAt(0,"OID"))).toString()));
                    dtoR.setOidPeriodo(dto.getPeriodo());
                    dtoR.setProcedencia(ConstantesCAR.TIPO_REEVALUACION_LC);
                    dtoR.setOidSubgerencia(null);
                    dtoR.setOidRegion(dto.getRegion());
                    dtoR.setOidZona(null);
                    dtoR.setMensaje(new Boolean(false));
          
                    // Invocamos a reevaluar en Masa
                    this.reevaluarEnMasa(dtoR);
                }
          
          } catch (Exception Ne) {
              UtilidadesLog.error(Ne);
		      }*/
        this.reevaluarLineaCreditoMasaOffLinePerf(dto);
        UtilidadesLog.info("MONCreditoRiesgo.reevaluarLineaCreditoMasaOffLine(DTOFACProcesoCierre):Salida");
  }



  /**
   * 
   * @Comentario: Ejecuta el algoritmo de reasignación de líneas de crédito. 
   * @Fecha: 12/01/2005
   * @author: Joaquin Alem
   * @throws es.indra.mare.common.exception.MareException
   * @param dto
   */
  public void reasignarLineasCredito(DTOReevaluar dto) throws MareException 
  {
  try{
      UtilidadesLog.info("MONCreditoRiesgo.reasignarLineasCredito(DTOReevaluar):Entrada");
      ClienteDatosAdicionalesLocalHome  clienteHome = new ClienteDatosAdicionalesLocalHome();
      ClienteDatosAdicionalesLocal clientesDatosAdicionales = clienteHome.findByCliente(dto.getOidCliente());
     
      UtilidadesLog.debug("clientesDatosAdicionales: " + clientesDatosAdicionales);      
      // Verifica Nivel de riesgo
      if(clientesDatosAdicionales.getNiri_oid_nive_ries()==null) {
           UtilidadesLog.error("El cliente no tiene nivel de riesgo");
           throw new MareException(null, null, 
                      UtilidadesError.armarCodigoError(
                      ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0011));   
      }
      
      // Verifica monto de línea de crédito
      if(clientesDatosAdicionales.getImp_mont_line_cred()==null) {
           UtilidadesLog.error("El cliente no tiene monto de línea de crédito");
           throw new MareException(null, null, 
                      UtilidadesError.armarCodigoError(
                      ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0012));   
      }
      
      if (!clientesDatosAdicionales.getNiri_oid_nive_ries().equals(ConstantesCAR.NIVEL_RIESGO_NUEVAS)){
       
            Long lPeriodo1 = null;
            Long lPeriodo2 = null;
            Long lPeriodoActual = null;
            BigDecimal pedidoPromedio = null;
            
            MONPeriodosHome monPeriHome = CRAEjbLocators.getMONPeriodosHome();
            MONPeriodos monPeri = monPeriHome.create();
            
            DTOPeriodo dtoP = new DTOPeriodo();
            dtoP = monPeri.obtienePeriodoActual(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal()); 
            
            UtilidadesLog.debug("DTOPeriodo:" + dtoP);            
            
            lPeriodoActual = dtoP.getOid(); 

            lPeriodo2 = dto.getOidPeriodo(); 
    
            if (lPeriodo2 == null){ 
                    lPeriodo2 = lPeriodoActual;
            } 
            
                        
            lPeriodo1 = clientesDatosAdicionales.getPerd_oid_peri_line_cred();
            
            // (nunca ha habido cambio de línea de crédito)
            if (lPeriodo1 == null){
                
                  ClienteHistoricoEstatusLocalHome ClienteHistoricoEstatusLH = getClienteHistoricoEstatusLocalHome();
                  ClienteHistoricoEstatusLocal clienteHistoricoEstatus= null;
                  
                  boolean historicoEstatus = true;
                  try{
                    clienteHistoricoEstatus = ClienteHistoricoEstatusLH.findByClienteEstatus(dto.getOidCliente(),ConstantesMAE.OID_ESTATUS_NUEVA);
                    UtilidadesLog.debug("clienteHistoricoEstatus: " + clienteHistoricoEstatus);
                  
                  } catch(NoResultException nre) {
                    historicoEstatus = false;
                  } catch(PersistenceException pex) {
                    ctx.setRollbackOnly();
                    throw new MareException(pex, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                  }
                  
                  if(historicoEstatus)
                    lPeriodo1 = clienteHistoricoEstatus.getPerd_oid_peri();
            }
            
            
            if (lPeriodo1 == null){
                //la consultora no ha hecho ningún pedido, ya que se pone en estado "Nueva" tras realizar el primer pedido 
                  pedidoPromedio = new BigDecimal(0); 
            }else{
                  DTOCalculoPedidos dtoC = new DTOCalculoPedidos();
                  dtoC.setOidCliente(dto.getOidCliente());
                  dtoC.setOidClaseSolicitud(dto.getOidClaseSolicitud());                      
                  dtoC.setOidPeriodo1(lPeriodo1);
                  dtoC.setOidPeriodo2(lPeriodo2);
                  
                  UtilidadesLog.debug("DTOCalculoPedidos:" + dtoC);
                  pedidoPromedio = this.calcularPedidoPromedioUltimaEvaluacion(dtoC); 
                  
                  UtilidadesLog.debug("pedidoPromedio: " + pedidoPromedio);
            }
              
            Boolean bActualizar  = new Boolean(false);
            
            java.util.Collection colParametros = null;
         
            ParametrosCalculoLCLocalHome parametrosCalculoLCLH = getParametrosCalculoLCLocalHome();
            ParametrosCalculoLCLocal parametrosCalculoLC;
            colParametros = parametrosCalculoLCLH.findByNivelRiesgo(clientesDatosAdicionales.getNiri_oid_nive_ries());
            UtilidadesLog.debug("colParametros size: " + colParametros.size());
            
              Iterator it = colParametros.iterator();
              for (int i = 0;i < colParametros.size(); ++i) {
                          ParametrosCalculoLCLocal parametro = (ParametrosCalculoLCLocal) it.next();
                         if(pedidoPromedio.doubleValue() <= parametro.getValTope().doubleValue()) {
                                   pedidoPromedio = pedidoPromedio.multiply(new BigDecimal(parametro.getValFactCalc().floatValue()));
                                   UtilidadesLog.debug("pedidoPromedio: " + pedidoPromedio);
                                   pedidoPromedio = redondear(dto.getOidPais(), pedidoPromedio);
                                   UtilidadesLog.debug("pedidoPromedio redondeado : " + pedidoPromedio);
                                   bActualizar = Boolean.FALSE; 

                                  if(ConstantesCAR.AUMENTAR_LC.equals( parametro.getIndVariLineCred())) {
                                        if(pedidoPromedio.doubleValue() >= clientesDatosAdicionales.getImp_mont_line_cred().doubleValue()) {
                                                bActualizar = Boolean.TRUE;
                                        }
                                  } else if(ConstantesCAR.DISMINUIR_LC.equals( parametro.getIndVariLineCred())) {
                                          
                                        if(pedidoPromedio.doubleValue() <= clientesDatosAdicionales.getImp_mont_line_cred().doubleValue()) {
                                              bActualizar = Boolean.TRUE;
                                        }
                                  }

                                 if (Boolean.TRUE.equals(bActualizar)) {
                                        UtilidadesLog.debug("actualizar");
                                        enviarMensajeLC(dto.getOidPais(),dto.getOidCliente(),new BigDecimal((clientesDatosAdicionales.getImp_mont_line_cred()).longValue()),pedidoPromedio);
                                        UtilidadesLog.debug("envio mensaje");
                                        
                                        //Se actualizan los siguientes campos de la entidad (EJB Entity) ClienteDatosAdicionales: 
                                        clientesDatosAdicionales.setImp_mont_line_cred(new Double(pedidoPromedio.doubleValue()));
                                        clientesDatosAdicionales.setPerd_oid_peri_line_cred(lPeriodoActual);
                                        
                                        clienteHome.merge(clientesDatosAdicionales);
                                 }
                                 
                                 break;
                          } // fin if
                     }//Bucle
              }  
			
              } catch (NoResultException nre) {
                  ctx.setRollbackOnly();
                  throw new MareException(nre,        
                      UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
              } catch (PersistenceException pe) {
                  ctx.setRollbackOnly();
                  throw new MareException(pe,
                      UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            } catch (CreateException ce) {
                     UtilidadesLog.error(ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                    
            } catch (RemoteException re) {
               UtilidadesLog.error(re);
               throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }      
              
		
     UtilidadesLog.info("MONCreditoRiesgo.reasignarLineasCredito(DTOReevaluar):Salida");   
  }



  /**
   * 
   * @Comentario: Permite calcular el importe de pedido promedio que ha 
   * pasado la consultora desde su última evaluación de la línea de crédito. 
   * @Fecha: 
   * @author: Joaquin Alem
   * @throws es.indra.mare.common.exception.MareException
   * @return BigDecimal
   * @param dto
   */
  public BigDecimal calcularPedidoPromedioUltimaEvaluacion(DTOCalculoPedidos dto) throws MareException
  {
        UtilidadesLog.info("MONCreditoRiesgo.calcularPedidoPromedioUltimaEvaluacion(DTOCalculoPedidos):Entrada");
        MONPedidosSolicitud monPed = null;
        
          try {
              MONPedidosSolicitudHome monPedHome = this.getMONPedidosSolicitudHome();
              monPed = monPedHome.create();
              BigDecimal resultado = monPed.calcularPedidoPromedio(dto);
              UtilidadesLog.info("MONCreditoRiesgo.calcularPedidoPromedioUltimaEvaluacion(DTOCalculoPedidos):Salida");
              return resultado;
                    
          } catch (NamingException Ne) {
               UtilidadesLog.error(Ne);               
               throw new MareException(Ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          } catch (CreateException ce) {
               UtilidadesLog.error(ce);               
               throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          } catch (RemoteException re) {
               UtilidadesLog.error(re);               
               throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          } 
          
  }



  /**
   * 
   * @Comentario: Redondea la cantidad pasada por parámetro. 
   * @Fecha: 12/01/2005
   * @author: Joaquin Alem
   * @throws es.indra.mare.common.exception.MareException
   * @return BigDecimal
   * @param cantidad
   * @param pais
   */
  public BigDecimal redondear(Long pais, BigDecimal cantidad) throws MareException
  {
      UtilidadesLog.info("MONCreditoRiesgo.redondear(Long , BigDecimal):Entrada");
      BigDecimal redondeo = cantidad;
            
      try{
            if (!(redondeo.equals(new BigDecimal(0)))){
                    
                    ParametrosGeneralesdeCarteraLocalHome parametrosCarteraLH = getParametrosGeneralesdeCarteraLocalHome();
                    ParametrosGeneralesdeCarteraLocal parametrosCarteraLC;
                    parametrosCarteraLC = parametrosCarteraLH.findByPais(pais);
                    RedondeoCartera red = new RedondeoCartera(redondeo,parametrosCarteraLC.getOidNivelRedondeo());
                    redondeo = red.calcularRedondeo(); 
              }
              
           } catch (NoResultException nre) {
               ctx.setRollbackOnly();
               throw new MareException(nre,        
                   UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
           } catch (PersistenceException pe) {
               ctx.setRollbackOnly();
               throw new MareException(pe,
                   UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
       UtilidadesLog.info("MONCreditoRiesgo.redondear(Long , BigDecimal):Salida");
       return redondeo;
  }


  /**
   * 
   * @Comentario: Envía un mensaje a la consultora notificando el cambio en su línea de crédito. 
   * @Fecha: 12/01/2005
   * @author: Joaquin Alem
   * @throws es.indra.mare.common.exception.MareException
   * @param montoFin
   * @param montoIni
   * @param oidCliente
   * @param pais
   */
  public void enviarMensajeLC(Long pais, Long oidCliente, BigDecimal montoIni, BigDecimal montoFin) throws MareException
  {
    UtilidadesLog.info("MONCreditoRiesgo.redondearenviarMensajeLC(Long , Long , BigDecimal , BigDecimal):Entrada");
        try{         
                DTOBuzonMensajes dtoB = new DTOBuzonMensajes();
                dtoB.setOidPais(pais);
                dtoB.setCodigoMensaje(ConstantesMSG.MENSAJE_CAR02);
                dtoB.setOidCliente(oidCliente);
                dtoB.setModuloOrigen(new Long(ConstantesSEG.MODULO_CAR));
                dtoB.setDatoVariable1(montoIni.toString());
                dtoB.setDatoVariable2(montoFin.toString());
                dtoB.setListaConsultoras(ConstantesMSG.NO);
                
                MONGestionMensajesHome monMenHome = this.getMONGestionMensajesHome();
                MONGestionMensajes monMen = monMenHome.create();
                
                dtoB = monMen.insertaDatosMensaje(dtoB);
                
          } catch (CreateException ce) {
                  UtilidadesLog.error(ce);
                  throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          } catch (RemoteException re) {
                 UtilidadesLog.error(re);
                 throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          } catch(NamingException ne){
                  UtilidadesLog.error(ne);
                  throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
          UtilidadesLog.info("MONCreditoRiesgo.redondearenviarMensajeLC(Long , Long , BigDecimal , BigDecimal):Salida");
    }


    /**
     * @author mbobadill
     * @date 11/01/05
     * Modifica el nivel de riesgo y el monto de la línea de crédito de un cliente. Ocurre cuando una 
     * consultora solicita una re-evaluación personal a través de la Gerente de zona. 
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     */
  public void reevaluarCreditoRiesgoIndividual(DTOTipoReevaluacion dto) throws MareException
  {
    UtilidadesLog.info("MONCreditoRiesgo.reevaluarCreditoRiesgoIndividual(DTOTipoReevaluacion):Entrada");
    try{
        MONClientesHome mONClientesHome = this.getMONClientesHome();
        MONClientes mONClientes = mONClientesHome.create();
        Long valorDao = mONClientes.obtenerOidCliente(dto.getOidPais(),dto.getCodCliente());
        if(valorDao == null)
        {
            // Lanzamos MareException
            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(
                                    ConstantesSEG.MODULO_CAR, "", es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0032));

            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
            ex.addParameter( dto.getCodCliente());
            throw ex;
          
        }else
        {
          DTOReevaluar dtoR = new DTOReevaluar();
          dtoR.setOidPais(dto.getOidPais());
          dtoR.setOidIdioma(dto.getOidIdioma());
          dtoR.setOidCliente(valorDao);
          dtoR.setOidMarca(dto.getOidMarca());
          dtoR.setOidCanal(dto.getOidCanal());
          dtoR.setOidPeriodo(null);
          dtoR.setOidClaseSolicitud(dto.getOidClaseSolicitud());
           
          Long[] tipoReevaluacion = dto.getTiposReevaluacion();
           for(int i=0; i < tipoReevaluacion.length;i++)
           {
               if(tipoReevaluacion[i].equals(ConstantesCAR.TIPO_REEVALUACION_NR)) {
                  reevaluarNivelRiesgo(dtoR) ;
               }
               
                if(tipoReevaluacion[i].equals(ConstantesCAR.TIPO_REEVALUACION_LC)) {
                  reasignarLineasCredito(dtoR) ;               
               }
           }
        }
    } catch (CreateException ce) {
        UtilidadesLog.error(ce);
        ctx.setRollbackOnly();
        throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

    } catch (RemoteException re) {
        UtilidadesLog.error(re);
        ctx.setRollbackOnly();
        throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (NamingException ne) {
        UtilidadesLog.error(ne);
        ctx.setRollbackOnly();
        throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (MareException me) {
         UtilidadesLog.error(me);
         ctx.setRollbackOnly();
         throw me;
    }
    UtilidadesLog.info("MONCreditoRiesgo.reevaluarCreditoRiesgoIndividual(DTOTipoReevaluacion):Salida");
  }

   /**
   * @autor mbobadill
   * @ date 11/01/05
   * Obtiene los tipos de re-evaluación. 
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   */
     
     public DTOSalida obtieneTipoReevaluacion(DTOBelcorp dto) throws MareException
      {
        UtilidadesLog.info("MONCreditoRiesgo.obtieneTipoReevaluacion(DTOBelcorp):Entrada");
                 DAOCAR daoCAR= new DAOCAR(ctx.getCallerPrincipal().getName());
                 DTOSalida out = daoCAR.obtieneTipoReevaluacion(dto);
                 UtilidadesLog.info("MONCreditoRiesgo.obtieneTipoReevaluacion(DTOBelcorp):Salida");
                 return out;
     
      }


    /**
     * @Autor Cortaberria
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOReevaluar dto
     * Ejecuta el algoritmo de re-evaluación del nivel de riesgo. 
     * dto.oidPeriodo es opcional.
     */

  public void reevaluarNivelRiesgo(DTOReevaluar dto) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.reevaluarNivelRiesgo(DTOReevaluar):Entrada");
    Long lNivelRiesgo = null;
    Long lPeriodo1 = null;
    Long lPeriodo2 = null;
    Long lPeriodoActual = null;
    Integer iPeriodosPedido = null;
    Integer iNumPeriodos = null;
    Integer iPeriodosReevaluar = null;

    ClienteDatosAdicionalesLocal clientesDatosAdicionales = null;
    ClienteDatosAdicionalesLocalHome clientesDatosAdicionalesLH = null;

    clientesDatosAdicionalesLH = this.getClienteDatosAdicionalesLocalHome();
    
    try {
      clientesDatosAdicionales = clientesDatosAdicionalesLH.findByCliente(dto.getOidCliente());
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
        throw new MareException(nre,        
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    UtilidadesLog.debug("clientesDatosAdicionales: " + clientesDatosAdicionales);
    
    MONPeriodosHome periodosHome = null;
    MONPeriodos periodos = null;
    DTOPeriodo dtoP = null;
    try {
      periodosHome = this.getMONPeriodosHome();
      periodos = periodosHome.create();
    } catch (Exception e) {
      UtilidadesLog.error(e);
      throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    try {
      dtoP = periodos.obtienePeriodoActual(dto.getOidPais(), 
              dto.getOidMarca(), 
              dto.getOidCanal());
    } catch (Exception e) {    
      UtilidadesLog.error(e);
      throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    
    }
    
    UtilidadesLog.debug("Perido: " + dtoP);
    
    lPeriodoActual = dtoP.getOid(); 
    lPeriodo2 = dto.getOidPeriodo(); 

    if(lPeriodo2 == null) {
      lPeriodo2 = lPeriodoActual;
    }

    ParametrosGeneralesdeCarteraLocalHome parametrosHome = null;
    ParametrosGeneralesdeCarteraLocal parametros = null;
    
    parametrosHome = this.getParametrosGeneralesdeCarteraLocalHome();
    
    try {
      parametros = parametrosHome.findByPais(dto.getOidPais());
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
        throw new MareException(nre,        
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    UtilidadesLog.debug("ParametrosGeneralesdeCartera: " + parametros);

    lPeriodo1 = clientesDatosAdicionales.getPerd_oid_peri_nive_ries(); 

    if(lPeriodo1 == null) {
      // (nunca ha habido cambio de nivel de riesgo) 
      iPeriodosReevaluar = new Integer(parametros.getNumeroPeriodosNue().intValue()); 

      ClienteHistoricoEstatusLocal status =  null;
      ClienteHistoricoEstatusLocalHome statusHome = null;
        
      statusHome = this.getClienteHistoricoEstatusLocalHome();      
      
      
      try {
        status =  statusHome.findByClienteEstatus(dto.getOidCliente(), 
                        ConstantesMAE.OID_ESTATUS_NUEVA);
      } catch (Exception e) {    
        status = null;
        /*e.printStackTrace();
        throw new MareException(e, UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    */
      }
      
      UtilidadesLog.debug("ClienteHistoricoEstatus: " + status);
      
      if(status != null) {//(pudiera ser que no se encontrara registro alguno) 
        lPeriodo1 = status.getPerd_oid_peri(); 
      }
    } else {
      //(ya ha habido algún cambio de nivel de riesgo) 
      iPeriodosReevaluar = new Integer(parametros.getNumeroPeriodosAnt().intValue()); 
    }

    if(lPeriodo1 == null) {
      //(la consultora no ha hecho ningún pedido, ya que se pone en estado "Nueva" 
      //tras realizar el primer pedido) 
      iPeriodosPedido = new Integer(0); 
      iNumPeriodos = new Integer(0);
    } else {
      DTOCalculoPedidos dtoC = new DTOCalculoPedidos();
      dtoC.setOidCliente(dto.getOidCliente()); 
      dtoC.setOidClaseSolicitud(dto.getOidClaseSolicitud()); 
      dtoC.setOidPeriodo1(lPeriodo1); 
      dtoC.setOidPeriodo2(lPeriodo2); 
      
      UtilidadesLog.debug("DTOCalculoPedidos: " + dtoC);
      
      iPeriodosPedido = calcularPeriodosPedidoUltimaEvaluacion(dtoC);
      
      UtilidadesLog.debug("iPeriodosPedido: " + iPeriodosPedido);
      
      try {
        DTOOIDs dtoPs = periodos.obtienePeriodosEntre(lPeriodo1, lPeriodoActual);
        
        UtilidadesLog.debug("DTOOIDs: " + dtoPs);
        
        iNumPeriodos = new Integer((dtoPs != null && dtoPs.getOids() != null)? dtoPs.getOids().length : 0);
        
        UtilidadesLog.debug("iNumPeriodos: " + iNumPeriodos);
      } catch (Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));   
      }
    }

    if(iNumPeriodos.intValue() > iPeriodosReevaluar.intValue()) {
      UtilidadesLog.debug(" invoca obtenerNivelRiesgo");     
      Double porcentajePeriodosPedido = new Double(((iPeriodosPedido.doubleValue() / iNumPeriodos.doubleValue()) * 100));      
      UtilidadesLog.debug("porcentajePeriodosPedido:" + porcentajePeriodosPedido);
      lNivelRiesgo = obtenerNivelRiesgo(dto.getOidCliente(), porcentajePeriodosPedido, dto.getOidPais());
                          
      UtilidadesLog.debug("lNivelRiesgo: " + lNivelRiesgo);                          
      
      UtilidadesLog.debug("actualizar");
      enviarMensajeNR(dto.getOidPais(), dto.getOidCliente(), lNivelRiesgo);
      UtilidadesLog.debug("envio mensaje");
       
      clientesDatosAdicionales.setNiri_oid_nive_ries(lNivelRiesgo);
      clientesDatosAdicionales.setPerd_oid_peri_nive_ries(lPeriodoActual);
      
      clientesDatosAdicionalesLH.merge(clientesDatosAdicionales);
    }
    UtilidadesLog.info("MONCreditoRiesgo.reevaluarNivelRiesgo(DTOReevaluar):Salida");
  }

  /**
   * @Autor Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @return Integer
   * @param DTOCalculoPedidos dto
   * Permite calcular el nº de periodos con pedido que ha realizado una consultora desde su última evaluación
   */
  public Integer calcularPeriodosPedidoUltimaEvaluacion(DTOCalculoPedidos dto) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.calcularPeriodosPedidoUltimaEvaluacion(DTOCalculoPedidos):Entrada");
          try {
              MONPedidosSolicitudHome pedHome = this.getMONPedidosSolicitudHome();
              MONPedidosSolicitud ped = pedHome.create();
              Integer i = ped.calcularPeriodosPedido(dto);
              UtilidadesLog.info("MONCreditoRiesgo.calcularPeriodosPedidoUltimaEvaluacion(DTOCalculoPedidos):Salida");
              return i;
              
          } catch (NamingException Ne) {
               UtilidadesLog.error(Ne);
               throw new MareException(Ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          } catch (CreateException ce) {
               UtilidadesLog.error(ce);
               throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          } catch (RemoteException re) {
               UtilidadesLog.error(re);
               throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          } 
  }

  /**
   * @Autor Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @return Long
   * @param Double porcentajePeriodosPedido
   * @param Long cliente
   * Obtiene el nivel de riesgo de la reevaluación. 
   */
  private Long obtenerNivelRiesgo (Long cliente, Double porcentajePeriodosPedido, Long oidPais) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.obtenerNivelRiesgo (Long , Double , Long):Entrada");
    BigDecimal nivel = new BigDecimal(0);

    nivel = nivel.add(this.evaluarParametroNR(ConstantesCAR.PARAM_NR_PEDIDOS_PERIODO, 
                    porcentajePeriodosPedido));
                    
    UtilidadesLog.debug("nivel- porcentajePeriodosPedido: " + nivel);                    

    DTOSaldosPorFechasyVtos dtoSF = new DTOSaldosPorFechasyVtos();
    dtoSF.setOidCliente(cliente);
    dtoSF.setOidPais(oidPais);

    DTODias dtoD = null;
    MONInterfaceModulos interfaceModulos = null;
    try {
      MONInterfaceModulosHome interfaceModulosHome = this.getMONInterfaceModulosHome();
      interfaceModulos = interfaceModulosHome.create();
  
      dtoD = interfaceModulos.calcularDiasAtrasoCliente(dtoSF);
    } catch (NamingException e) {
      UtilidadesLog.error(e);
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));   
    } catch (CreateException e) {
      UtilidadesLog.error(e);
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));   
    } catch (RemoteException e) {
      UtilidadesLog.error(e);
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));   
    }
    
    UtilidadesLog.debug("DTODias: " + dtoD);
    
    if(dtoD.getNumeroDias().intValue() < ConstantesCAR.MIN_DIAS.intValue()) { 
      dtoD.setNumeroDias(ConstantesCAR.MIN_DIAS); 
    } else if(dtoD.getNumeroDias().intValue() > ConstantesCAR.MAX_DIAS.intValue()) {
      dtoD.setNumeroDias(ConstantesCAR.MAX_DIAS);
    }

    nivel = nivel.add(this.evaluarParametroNR(ConstantesCAR.PARAM_NR_DIAS_MORA, 
                      new Double(dtoD.getNumeroDias().doubleValue())));
                      
    UtilidadesLog.debug("nivel- calcularDiasAtrasoCliente: " + nivel);                            

    DTOSaldosPorDiasPeriodos dtoSD = new DTOSaldosPorDiasPeriodos();
    dtoSD.setOidCliente(cliente);
    dtoSD.setOidPais(oidPais);

    DTOTotalyDias dtoTD = null;
    
    try {
      dtoTD = interfaceModulos.calcularDeudaVencidaCCCliente(dtoSD);
    } catch (RemoteException e) {
      e.printStackTrace();
        throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));   
    }
    
    if(dtoTD.getNumeroDias().intValue() < ConstantesCAR.MIN_DIAS.intValue()) {
      dtoTD.setNumeroDias(ConstantesCAR.MIN_DIAS);
    } else if(dtoTD.getNumeroDias().intValue() > ConstantesCAR.MAX_DIAS.intValue()) {
      dtoTD.setNumeroDias(ConstantesCAR.MAX_DIAS);
    }
    
    UtilidadesLog.debug("DTOTotalyDias: " + dtoTD);

    nivel = nivel.add(this.evaluarParametroNR(ConstantesCAR.PARAM_NR_DIAS_DEUDA, 
                    new Double(dtoTD.getNumeroDias().doubleValue())));
                    
    UtilidadesLog.debug("nivel- calcularDeudaVencidaCCCliente: " + nivel);                              

    DAOCAR daoCar = new DAOCAR(ctx.getCallerPrincipal().getName());
    Long retorna = daoCar.obtenerNivelRiesgo(nivel);
    UtilidadesLog.info("MONCreditoRiesgo.obtenerNivelRiesgo (Long , Double , Long):Salida");
    return retorna;
    
  }  

  /* @Autor Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @return BigDecimal
   * @param Double entrada
   * @param Long parametro
   * Evalúa los parámetros de nivel de riesgo. 
   */
  private BigDecimal evaluarParametroNR (Long parametro, Double entrada) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.evaluarParametroNR (Long , Double):Entrada");
    BigDecimal evalua = null;
    DAOCAR daoCar = new DAOCAR(ctx.getCallerPrincipal().getName());
    RecordSet registro = daoCar.evaluarParametroNR(parametro, entrada);
    
    UtilidadesLog.debug("evaluarParametroNR: " + registro);

    BigDecimal maximo = (BigDecimal)registro.getValueAt(0, "MAXIMO"); 
    BigDecimal minimo = (BigDecimal)registro.getValueAt(0, "MINIMO"); 
    BigDecimal escala = (BigDecimal)registro.getValueAt(0, "ESCALA"); 
    BigDecimal peso = (BigDecimal)registro.getValueAt(0, "PESO"); 
    
    if(ConstantesCAR.PARAM_NR_PEDIDOS_PERIODO.equals(parametro)) {
      evalua = (((maximo.subtract(new BigDecimal(entrada.doubleValue())))
            .divide(maximo.subtract(minimo),2, BigDecimal.ROUND_HALF_UP))
            .add(escala))
            .multiply(peso);
      /*evalua = new BigDecimal (
        (
          (
            (
              maximo.doubleValue() - entrada.doubleValue()) / 
            (maximo.doubleValue() - minimo.doubleValue())
          ) + escala.doubleValue()
        ) * peso.doubleValue());
        */
    } else {
      evalua = ((((new BigDecimal(entrada.doubleValue())).subtract(minimo))
                .divide(maximo.subtract(minimo),2, BigDecimal.ROUND_HALF_UP))
                .add(escala))
                .multiply(peso);
      /*evalua = new BigDecimal (
        (
          (
            (entrada.doubleValue() - minimo.doubleValue()) / 
            (maximo.doubleValue() - minimo.doubleValue())
          ) + escala.doubleValue()
        ) * peso.doubleValue());*/
    }

    UtilidadesLog.debug("evalua: " + evalua);
    UtilidadesLog.info("MONCreditoRiesgo.evaluarParametroNR (Long , Double):Salida");
    return evalua;
  }
  
  /**
   * @Autor Cortaberria
   * @param Long nivelRiesgo
   * @param Long oidCliente
   * @param Long pais
   * Envía un mensaje a la consultora notificando el cambio en su nivel de riesgo. 
   */
  private void enviarMensajeNR (Long pais, Long oidCliente, Long nivelRiesgo) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.enviarMensajeNR (Long , Long , Long):Entrada");
      DTOBuzonMensajes dtoB = new DTOBuzonMensajes();
      dtoB.setOidPais(pais);
      dtoB.setCodigoMensaje(ConstantesMSG.MENSAJE_CAR01); 
      dtoB.setOidCliente(oidCliente); 
      dtoB.setModuloOrigen(new Long(ConstantesSEG.MODULO_CAR)); 
      if (nivelRiesgo != null) {
        dtoB.setDatoVariable1(nivelRiesgo.toString());
      }
      dtoB.setListaConsultoras(ConstantesMSG.NO);
      
      MONGestionMensajes msg = null;
      try {
        MONGestionMensajesHome msgHome = this.getMONGestionMensajesHome();
        msg = msgHome.create();
      } catch (Exception e) {
        UtilidadesLog.error(e);
          throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));   
      }
      
      try {
        dtoB = msg.insertaDatosMensaje(dtoB);
      } catch (RemoteException re) {
           UtilidadesLog.error(re);
           throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } 
    UtilidadesLog.info("MONCreditoRiesgo.enviarMensajeNR (Long , Long , Long):Salida");
  }

  private MONPeriodosHome getMONPeriodosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("MONPeriodos"), MONPeriodosHome.class);
  }

  private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("MONGestionMensajes"), MONGestionMensajesHome.class);
  }

  private MONInterfaceModulosHome getMONInterfaceModulosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONInterfaceModulosHome)PortableRemoteObject.narrow(context.lookup("MONInterfaceModulos"), MONInterfaceModulosHome.class);
  }

  private MONClientesHome getMONClientesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONClientesHome)PortableRemoteObject.narrow(context.lookup("MONClientes"), MONClientesHome.class);
  }

  /**
      RecordSet rCliente = DAOCAR.obtieneClientesReevaluarEnMasa(dto) 
      
      Si rCliente no tiene ningún registro y dto.mensaje == True 
      Se lanza la MareException CAR-0007 (No existen consultoras que cumplan los parámetros seleccionados) 
      
      Si no 
      Se crea un DTOReevaluar (dtoR) que se carga como sigue: 
      dtoR.pais = dto.pais 
      dtoR.idioma = dto.idioma 
      dtoR.oidMarca = dto.oidMarca 
      dtoR.oidCanal = dto.oidCanal 
      dtoR.oidClaseSolicitud = dto.oidClaseSolicitud 
      dtoR.oidPeriodo = dto.oidPeriodo 
      
      Por cada registro en rCliente 
      dtoR.oidCliente = rCliente[i].oidCliente 
      
      Si dto.procedencia == ConstantesCAR.TIPO_REEVALUACION_LC 
      reasignarLineasCredito(dtoR) 
      Fin del Si 
      
      Si dto.procedencia == ConstantesCAR.TIPO_REEVALUACION_NR 
      reevaluarNivelRiesgo(dtoR) 
      Fin del Si 
      Fin del Bucle 
      Fin del Si
   */
   /**
   * @Autor Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @param dto
   */
  public void reevaluarEnMasa (DTOReevaluarEnMasa dto) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.reevaluarEnMasa (DTOReevaluarEnMasa):Entrada");
    DAOCAR daoCar = new DAOCAR(ctx.getCallerPrincipal().getName());
    
    UtilidadesLog.debug("DTOReevaluarEnMasa: " + dto);
    
    RecordSet rCliente = daoCar.obtieneClientesReevaluarEnMasa(dto);
    
    UtilidadesLog.debug("rCliente: " + rCliente);
    
    if (rCliente.esVacio()) {
      if (Boolean.TRUE.equals(dto.getMensaje())) {
        throw new MareException(null, null, 
          UtilidadesError.armarCodigoError(
          ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0007));      
      }
    } else {
      try{
          DTOReevaluar dtoR = new DTOReevaluar();
          dtoR.setOidPais(dto.getOidPais());
          dtoR.setOidIdioma(dto.getOidIdioma());
          dtoR.setOidMarca(dto.getOidMarca() );
          dtoR.setOidCanal(dto.getOidCanal()); 
          dtoR.setOidClaseSolicitud(dto.getOidClaseSolicitud());
          dtoR.setOidPeriodo(dto.getOidPeriodo());
          
          for (int i = 0; i < rCliente.getRowCount(); ++i) {
            long oidCliente = ((BigDecimal)rCliente.getValueAt(i, 0)).longValue(); 
            dtoR.setOidCliente(new Long(oidCliente));  
            
            UtilidadesLog.debug("DTOReevaluar: " + dtoR);
          
            if(ConstantesCAR.TIPO_REEVALUACION_LC.equals(dto.getProcedencia())) { 
              UtilidadesLog.debug("reasignarLineasCredito");
              reasignarLineasCredito(dtoR);
            } else if(ConstantesCAR.TIPO_REEVALUACION_NR.equals(dto.getProcedencia())) { 
              UtilidadesLog.debug("reasignarLineasCredito");
              reevaluarNivelRiesgo(dtoR);
            }
          }
      } catch (MareException me) {
         UtilidadesLog.error(me);
         ctx.setRollbackOnly();
         throw me;
      }
    }      
    UtilidadesLog.info("MONCreditoRiesgo.reevaluarEnMasa (DTOReevaluarEnMasa):Salida");
  }


  public void reevaluarLineaCreditoMasaOffLinePerf(DTOFACProcesoCierre dto) throws MareException {
     UtilidadesLog.info("MONCreditoRiesgo.reevaluarLineaCreditoMasaOffLinePerf(DTOFACProcesoCierre):Entrada");
     Date beginTrans = new Date();
     Long oidClaseSolicitud = null;
     
     oidClaseSolicitud = this.obtenerClaseSolicitudOrdenCompra();
     
     if (oidClaseSolicitud == null) {
        UtilidadesLog.error("No se encuentra ninguna clase de solicitud de orden de compra");
        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0010));     
     } else {
        DTOReevaluarEnMasa dtoR = new DTOReevaluarEnMasa();
        dtoR.setOidPais(dto.getOidPais());
        dtoR.setOidIdioma(dto.getOidIdioma());
        dtoR.setOidMarca(dto.getMarca());
        dtoR.setOidCanal(dto.getCanal());
        dtoR.setOidClaseSolicitud(oidClaseSolicitud);
        dtoR.setOidPeriodo(dto.getPeriodo());
        dtoR.setProcedencia(ConstantesCAR.TIPO_REEVALUACION_LC);
        dtoR.setOidRegion(dto.getRegion());
        dtoR.setMensaje(new Boolean(false));
         
        this.reevaluarEnMasaPerf(dtoR);
     }
     Date endTrans = new Date();
     UtilidadesLog.warn("Tiempo reevaluarLineaCreditoMasaOffLinePerf ----->" + (endTrans.getTime() - beginTrans.getTime()));
     UtilidadesLog.info("MONCreditoRiesgo.reevaluarLineaCreditoMasaOffLinePerf(DTOFACProcesoCierre):Salida");
  }

  private Long obtenerClaseSolicitudOrdenCompra() throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.obtenerClaseSolicitudOrdenCompra():Entrada");
    StringBuffer query = new StringBuffer();
    Long oidClaseSolicitud = null;
    
    query.append("SELECT PCS.OID_CLAS_SOLI ");
    query.append(" FROM PED_CLASE_SOLIC PCS ");
    query.append(" WHERE PCS.IND_ORDE_COMP = 1 ");
    
    RecordSet rs = null;

    rs = this.executeQuery(query.toString());
    
    if (!rs.esVacio()) {
      oidClaseSolicitud = this.bigDecimalToLong(rs.getValueAt(0,"OID_CLAS_SOLI"));
    }
    
    UtilidadesLog.info("MONCreditoRiesgo.obtenerClaseSolicitudOrdenCompra():Salida");
    return oidClaseSolicitud;
  }

  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONCreditoRiesgo.executeQuery(String query): Salida");  
    return rs;
  }
  
  private Long bigDecimalToLong(Object numero) {
    if (numero != null) {
        return new Long(((BigDecimal) numero).longValue());
    } else {
        return null;
    }
  }

 private Integer bigDecimalToInteger(Object numero) {
    if (numero != null) {
        return new Integer(((BigDecimal) numero).intValue());
    } else {
        return null;
    }
  }

  
 private void reasignarLineasCreditoPerf(DTOReevaluarEnMasa dto) throws MareException {
     UtilidadesLog.info("MONCreditoRiesgo.reasignarLineasCreditoPerf(DTOReevaluarEnMasa dto):Entrada");
     RecordSet rs = null;
     HashMap hashClientesPeriodo = new HashMap();
     StringBuffer cadenaUpdateLineaCredito = new StringBuffer();
     Long oidPeriodoActual = this.obtenerPeriodoActual(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal());     
     rs = this.obtenerClientesLineaCredito(dto);          
     
     if (!rs.esVacio()){
       int longRS = rs.getRowCount();
       for (int i = 0;i < longRS;i++){         
         DTOCreditoRiesgo dtoCredito = new DTOCreditoRiesgo();         
         dtoCredito.setOidCliente(this.bigDecimalToLong(rs.getValueAt(i,"OIDCLIENTE")));
         dtoCredito.setNivelRiesgo(this.bigDecimalToLong(rs.getValueAt(i,"NIRI_OID_NIVE_RIES")));
         dtoCredito.setMontoLineaCredito((BigDecimal)rs.getValueAt(i,"IMP_MONT_LINE_CRED"));
         dtoCredito.setOidPeriodo(this.bigDecimalToLong(rs.getValueAt(i,"PERIODO")));
         dtoCredito.setPedidoPromedio(new BigDecimal(0));
         Boolean cargar = Boolean.TRUE;
         
         if (dtoCredito.getNivelRiesgo() == null){
           LogAPP.error("El cliente no tiene nivel de riesgo " + dtoCredito.getOidCliente());
           cargar = Boolean.FALSE;
//           throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0011));   
         }
        
         if (dtoCredito.getMontoLineaCredito() == null) {
           LogAPP.error("El cliente no tiene monto de línea de crédito " + dtoCredito.getOidCliente());
           cargar = Boolean.FALSE;
//           throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0012));   
         }
         
         ArrayList arrayClientes;          
         Long oidPeriodo;
         if (dtoCredito.getOidPeriodo() == null) {                        
            if (hashClientesPeriodo.containsKey(new Long(-1))) {
                arrayClientes = (ArrayList)hashClientesPeriodo.get(new Long(-1));                
            } else {
                arrayClientes = new ArrayList();
            }
            oidPeriodo = new Long(-1);
         } else {            
            if (hashClientesPeriodo.containsKey(dtoCredito.getOidPeriodo())) {
                arrayClientes = (ArrayList)hashClientesPeriodo.get(dtoCredito.getOidPeriodo());                  
            } else {
                arrayClientes = new ArrayList();
            }   
            oidPeriodo = dtoCredito.getOidPeriodo();
         }
         if (cargar.booleanValue()){        
            arrayClientes.add(dtoCredito);
         }
         hashClientesPeriodo.put(oidPeriodo, arrayClientes);            

       }
       
       Iterator it = (Iterator)((Collection)hashClientesPeriodo.values()).iterator();
       HashMap hashParametrosCalculo = new HashMap();
       hashParametrosCalculo = this.obtenerParametrosCalculo();
       while (it.hasNext()){
          ArrayList arrayClientesPeriodo = (ArrayList)it.next();
          if (arrayClientesPeriodo.size() > 0) {
              arrayClientesPeriodo = this.obtenerPedidoPromedio(arrayClientesPeriodo, oidPeriodoActual);
              
              int longArray = arrayClientesPeriodo.size();
              for (int i=0;i<longArray;i++){
                  DTOCreditoRiesgo dtoCreditoRiesgo = (DTOCreditoRiesgo)arrayClientesPeriodo.get(i);
                  if (!dtoCreditoRiesgo.getNivelRiesgo().equals(ConstantesCAR.NIVEL_RIESGO_NUEVAS)) {              
                      if (hashParametrosCalculo.containsKey(dtoCreditoRiesgo.getNivelRiesgo())) {
                        ArrayList arrayParametros = (ArrayList)hashParametrosCalculo.get(dtoCreditoRiesgo.getNivelRiesgo());
                        int longArrayParametros = arrayParametros.size();
                        for (int x = 0;x < longArrayParametros; x++) {
                              DTOParametrosCalculo dtoParametrosCalculo = (DTOParametrosCalculo)arrayParametros.get(x);   
                              Boolean bActualizar;
                              BigDecimal pedidoPromedio = dtoCreditoRiesgo.getPedidoPromedio();
                              if(pedidoPromedio.doubleValue() <= dtoParametrosCalculo.getValTope().doubleValue()) {
                                  pedidoPromedio = pedidoPromedio.multiply(new BigDecimal(dtoParametrosCalculo.getValFactorCalculo().floatValue()));
                                  pedidoPromedio = redondear(dto.getOidPais(), pedidoPromedio);
                                  bActualizar = Boolean.FALSE; 
    
                                  if(ConstantesCAR.AUMENTAR_LC.equals(dtoParametrosCalculo.getIndVariacionLineaCredito().toString())) {
                                     if(pedidoPromedio.doubleValue() >= dtoCreditoRiesgo.getMontoLineaCredito().doubleValue()) {                                          
                                          bActualizar = Boolean.TRUE;
                                     }
                                  } else if(ConstantesCAR.DISMINUIR_LC.equals(dtoParametrosCalculo.getIndVariacionLineaCredito().toString())) {
                                     if(pedidoPromedio.doubleValue() <= dtoCreditoRiesgo.getMontoLineaCredito().doubleValue()) {                                          
                                          bActualizar = Boolean.TRUE;
                                     }
                                  }
    
                                  if (bActualizar.booleanValue()) {
                                     enviarMensajeLC(dto.getOidPais(),dtoCreditoRiesgo.getOidCliente(), new BigDecimal((dtoCreditoRiesgo.getMontoLineaCredito()).longValue()),pedidoPromedio);
                                     cadenaUpdateLineaCredito.append(this.generarCadenaUpdateLineaCredito(dtoCreditoRiesgo.getOidCliente(), pedidoPromedio, oidPeriodoActual).toString());      
                                  }                                 
                                  break;
                              } // fin if
                         }//Buc             
                      } else {
                          LogAPP.error("No se encontraron Parametros de Calculo para el nivel de riesgo " + dtoCreditoRiesgo.getNivelRiesgo());
                      }              
                  }
              }
           BelcorpService bs = BelcorpService.getInstance();
           try {
                bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",cadenaUpdateLineaCredito.toString());
            } catch (Exception e) {
                throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
       } else {
          UtilidadesLog.debug("Array Vacio ");
       }       
    }
    } else {
      LogAPP.error("No se encontraron Clientes ");  
    
    }
    UtilidadesLog.info("MONCreditoRiesgo.reasignarLineasCredito(DTOReevaluar):Salida");   
  }

  private RecordSet obtenerClientesLineaCredito(DTOReevaluarEnMasa dto) throws MareException{
    UtilidadesLog.info("MONCreditoRiesgo.obtenerClientesLineaCredito(DTOReevaluarEnMasa dto):Entrada");
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT DISTINCT A.OID_CLIE AS OIDCLIENTE, ");
    query.append("	 		  CDA.NIRI_OID_NIVE_RIES, ");
    query.append("   			CDA.IMP_MONT_LINE_CRED, ");
	  query.append("  CASE WHEN (CDA.PERD_OID_PERI_LINE_CRED IS NULL) THEN ");
		query.append("  ( ");
		query.append("    SELECT CHE.PERD_OID_PERI ");
		query.append("    FROM MAE_CLIEN_HISTO_ESTAT CHE ");
		query.append("    WHERE CHE.CLIE_OID_CLIE = A.OID_CLIE ");
		query.append("      AND CHE.ESTA_OID_ESTA_CLIE = "+ ConstantesMAE.OID_ESTATUS_NUEVA);
		query.append("  ) ");
		query.append(" ELSE ");
		query.append("    CDA.PERD_OID_PERI_LINE_CRED ");
		query.append(" END PERIODO ");
    query.append(" FROM MAE_CLIEN A, ");
    query.append("   MAE_CLIEN_TIPO_SUBTI B, ");
		query.append("   MAE_CLIEN_UNIDA_ADMIN C, ");
    query.append("   ZON_TERRI_ADMIN D, ");
    query.append("   ZON_SECCI E, ");
    query.append("   ZON_ZONA F, ");
    query.append("   ZON_REGIO G, ");
    query.append("   MAE_CLIEN_DATOS_ADICI CDA ");
    query.append(" WHERE A.PAIS_OID_PAIS = " + dto.getOidPais());
	  query.append("  AND B.CLIE_OID_CLIE = A.OID_CLIE "); 
	  query.append("  AND B.TICL_OID_TIPO_CLIE = " + ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
	  query.append("  AND C.CLIE_OID_CLIE = B.CLIE_OID_CLIE "); 
	  query.append("  AND C.IND_ACTI = 1 ");
	  query.append("  AND D.OID_TERR_ADMI = C.ZTAD_OID_TERR_ADMI ");
	  query.append("  AND D.IND_BORR = 0 ");
	  query.append("  AND E.OID_SECC = D.ZSCC_OID_SECC ");
	  query.append("  AND E.IND_BORR = 0 ");
	  query.append("  AND E.IND_ACTI = 1 ");
	  query.append("  AND F.OID_ZONA = E.ZZON_OID_ZONA ");
	  query.append("  AND F.IND_BORR = 0 ");
	  query.append("  AND F.IND_ACTI = 1 ");
	  query.append("  AND G.OID_REGI = F.ZORG_OID_REGI ");
	  query.append("  AND G.IND_BORR = 0 ");
	  query.append("  AND G.IND_ACTI = 1 ");
	  query.append("  AND G.PAIS_OID_PAIS = A.PAIS_OID_PAIS ");
    query.append("  AND G.MARC_OID_MARC = " + dto.getOidMarca());
	  query.append("  AND G.CANA_OID_CANA = " + dto.getOidCanal());
    query.append("  AND CDA.CLIE_OID_CLIE = A.OID_CLIE ");
    if (dto.getOidRegion() != null) {
      query.append(" AND G.OID_REGI = ").append(dto.getOidRegion()); 
    }
    
    RecordSet rs = null;

    rs = this.executeQuery(query.toString());
    
    UtilidadesLog.info("MONCreditoRiesgo.obtenerClientesLineaCredito(DTOReevaluarEnMasa dto):Salida");
    return rs;
  }
  
  private Long obtenerPeriodoActual(Long oidPais, Long oidMarca, Long oidCanal) throws MareException{
    StringBuffer query = new StringBuffer();
    
    Long oidPeriodo = null;
    query.append(" SELECT OID_PERI, ");
	  query.append("  		  FEC_INIC ");
	  query.append(" FROM CRA_PERIO PER ");
	  query.append(" WHERE PER.PAIS_OID_PAIS = " + oidPais);
	  query.append("   AND PER.MARC_OID_MARC = " + oidMarca );
		query.append("   AND PER.CANA_OID_CANA = " + oidCanal);
		query.append("   AND PER.FEC_INIC <= TRUNC(SYSDATE) ");
		query.append("   AND PER.FEC_FINA >= TRUNC(SYSDATE) ");
	  query.append(" ORDER BY FEC_INIC	");
    
    RecordSet rs = null;
    
    rs = this.executeQuery(query.toString());
    
    if (!rs.esVacio()) {
        oidPeriodo = this.bigDecimalToLong(rs.getValueAt(0,"OID_PERI"));
    }
    return oidPeriodo;    
  }
  
  
  private ArrayList obtenerPedidoPromedio(ArrayList arrayClientesPeriodo, Long oidPeriodoActual) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.obtenerPedidoPromedio(ArrayList arrayClientesPeriodo, Long oidPeriodoActual):Entrada");
    StringBuffer query = new StringBuffer();    
    
    DTOCreditoRiesgo dtoCredito = (DTOCreditoRiesgo)arrayClientesPeriodo.get(0);
    
    if (dtoCredito.getOidPeriodo() != null){
      query.append(" SELECT PSC.CLIE_OID_CLIE, ");
      query.append(" 		  SUM(PSC.VAL_CANT_PEDI) VAL_CANT_PEDI, ");
      query.append("      SUM(PSC.VAL_SUM_TOTA_PAGA_LOCA) VAL_TOTA_PAGA_LOCA_PERI ");
      query.append("FROM PED_SOLIC_CABEC_ACUM3 PSC, ");
      query.append("  ( ");
      query.append("  SELECT FEC_INIC ");
      query.append("  FROM CRA_PERIO ");
      query.append("  WHERE OID_PERI = " + dtoCredito.getOidPeriodo());
      query.append("  ) PER_INI, ");
      query.append("  ( ");
      query.append("  SELECT FEC_FINA ");
      query.append("  FROM CRA_PERIO ");
      query.append("  WHERE OID_PERI = " + oidPeriodoActual);
      query.append("  ) PER_FIN, ");
      query.append("  CRA_PERIO PER ");
      query.append("WHERE PSC.PERD_OID_PERI = PER.OID_PERI ");
      query.append("  AND PER.FEC_INIC >= PER_INI.FEC_INIC ");
      query.append("  AND PER.FEC_FINA <= PER_FIN.FEC_FINA ");
      query.append(this.generarFiltroClientes(arrayClientesPeriodo).toString());      
      query.append(" GROUP BY PSC.CLIE_OID_CLIE ");
    
      RecordSet rs = null;
      
      rs = this.executeQuery(query.toString());
      HashMap hashClientesPedidoPromedio = new HashMap();
      if (!rs.esVacio()){
        int longRS = rs.getRowCount();
        for (int i = 0; i< longRS;i++){
          Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i,"CLIE_OID_CLIE"));
          BigDecimal pedidoPromedio = ((BigDecimal)rs.getValueAt(i, "VAL_TOTA_PAGA_LOCA_PERI")).divide(new BigDecimal(((BigDecimal)rs.getValueAt(i, "VAL_CANT_PEDI")).intValue()),2,BigDecimal.ROUND_HALF_UP );
          hashClientesPedidoPromedio.put(oidCliente, pedidoPromedio);
        }
      }
      
      int longArray = arrayClientesPeriodo.size();
      for (int i =0;i<longArray;i++){
         dtoCredito = (DTOCreditoRiesgo)arrayClientesPeriodo.get(i);
         if (hashClientesPedidoPromedio.containsKey(dtoCredito.getOidCliente())){
            dtoCredito.setPedidoPromedio((BigDecimal)hashClientesPedidoPromedio.get(dtoCredito.getOidCliente()));
         }
      }      
    }    
  
    UtilidadesLog.info("MONCreditoRiesgo.obtenerPedidoPromedio(ArrayList arrayClientesPeriodo, Long oidPeriodoActual):Salida");
    return arrayClientesPeriodo;
  }
  
  private StringBuffer generarFiltroClientes(ArrayList arrayClientesPeriodo) {
    StringBuffer filtro = new StringBuffer();
    int longArray = arrayClientesPeriodo.size();
    int count = 0;
    String oidClientes = "";
    
    for (int i = 0;i<longArray;i++){
      if (i==0){
        filtro.append(" AND (");
      }
      DTOCreditoRiesgo dtoCredito = (DTOCreditoRiesgo)arrayClientesPeriodo.get(i);
      if (count == 0) {
          oidClientes = (String)dtoCredito.getOidCliente().toString();
      } else { 
          oidClientes += "," + (String)dtoCredito.getOidCliente().toString();
      }
      if (count == 999)  {
          filtro.append(" PSC.CLIE_OID_CLIE IN ( " + oidClientes.toString() + ")  ");                     
          if (i < (longArray -1)){
              filtro.append("  OR ");
          }                    
          count = 0;
          oidClientes = "";
      } else {
          if (i == (longArray -1)){
              filtro.append(" PSC.CLIE_OID_CLIE IN ( " + oidClientes.toString() + ") ");        
          }                    
          count++;            
      }           
      if (i == (longArray -1)){              
        filtro.append(")");
      }      
    }
    return filtro; 
 }
 
 
 private HashMap obtenerParametrosCalculo() throws MareException {
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT NIRI_OID_NIVE_RIES, ");
	  query.append(" 		   VAL_TOPE,");
		query.append("       VAL_FACT_CALC,");
		query.append("       IND_VARI_LINE_CRED ");
	  query.append("FROM CAR_PARAM_CALCU_LC");
    
    RecordSet rs = null;
    
    rs = this.executeQuery(query.toString());
    HashMap hashParametrosCalculo = new HashMap();
    
    if (!rs.esVacio()){
      int longRS = rs.getRowCount();
      for (int i=0;i<longRS;i++) {
          DTOParametrosCalculo dtoParametros = new DTOParametrosCalculo();
          dtoParametros.setNivelRiesgo(this.bigDecimalToLong(rs.getValueAt(i,"NIRI_OID_NIVE_RIES")));  
          dtoParametros.setValTope(this.bigDecimalToLong(rs.getValueAt(i,"VAL_TOPE")));
          dtoParametros.setValFactorCalculo(this.bigDecimalToLong(rs.getValueAt(i,"VAL_FACT_CALC")));
          dtoParametros.setIndVariacionLineaCredito((String)rs.getValueAt(i,"IND_VARI_LINE_CRED"));
          
          ArrayList arrayParametrosNivel;
          if (hashParametrosCalculo.containsKey(dtoParametros.getNivelRiesgo())) {
              arrayParametrosNivel = (ArrayList)hashParametrosCalculo.get(dtoParametros.getNivelRiesgo());              
          } else {
              arrayParametrosNivel = new ArrayList();
          }
          arrayParametrosNivel.add(dtoParametros);
          hashParametrosCalculo.put(dtoParametros.getNivelRiesgo(),arrayParametrosNivel);
      }
    }
    return hashParametrosCalculo;
 }
  
 private StringBuffer generarCadenaUpdateLineaCredito(Long oidCliente, BigDecimal pedidoPromedio, Long oidPeriodoActual) {
    StringBuffer query = new StringBuffer();    
    query.append("UPDATE MAE_CLIEN_DATOS_ADICI SET IMP_MONT_LINE_CRED = " + pedidoPromedio);
    query.append(" , PERD_OID_PERI_LINE_CRED = " + oidPeriodoActual + " WHERE CLIE_OID_CLIE = " + oidCliente + ";");
    return query; 
 }

  public void reevaluarNivelRiesgoMasaOffLinePerf(DTOFACProcesoCierre dto) throws MareException {
     UtilidadesLog.info("MONCreditoRiesgo.reevaluarNivelRiesgoMasaOffLinePerf(DTOFACProcesoCierre):Entrada");
     Date beginTrans = new Date();
     Long oidClaseSolicitud = null;
     
     oidClaseSolicitud = this.obtenerClaseSolicitudOrdenCompra();
     
     if (oidClaseSolicitud == null) {
        UtilidadesLog.error("No se encuentra ninguna clase de solicitud de orden de compra");
        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0010));     
     } else {
        this.ejecucionBatch( dto.getIDProc() , dto, oidClaseSolicitud);
     }
     Date endTrans = new Date();
     UtilidadesLog.warn("Tiempo reevaluarNivelRiesgoMasaOffLinePerf ---->" + (endTrans.getTime() - beginTrans.getTime()));
     UtilidadesLog.info("MONCreditoRiesgo.reevaluarNivelRiesgoMasaOffLinePerf(DTOFACProcesoCierre):Salida");
  }
  
  
  private void reevaluarNivelRiesgoPerf(DTOReevaluarEnMasa dto) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.reevaluarNivelRiesgoPerf(DTOReevaluar):Entrada");
    RecordSet rs = null;
    Long oidPeriodoActual = this.obtenerPeriodoActual(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal());
    UtilidadesLog.debug("oidPeriodoActual obtenido: " + oidPeriodoActual );
    Long oidPeriodo2 = null;
    if (dto.getOidPeriodo() == null) {
      oidPeriodo2 = oidPeriodoActual;
    }
    rs = this.obtenerClientesNivelRiesgo(dto);

    HashMap hashClientesPeriodos = new HashMap();    
    if (!rs.esVacio()){
        int longRS = rs.getRowCount();
        for (int i = 0; i < longRS;i++) {
          DTONivelRiesgo dtoNivelRiesgo = new DTONivelRiesgo();
          dtoNivelRiesgo.setOidCliente(this.bigDecimalToLong(rs.getValueAt(i,"OIDCLIENTE")));
          dtoNivelRiesgo.setOidPeriodo(this.bigDecimalToLong(rs.getValueAt(i,"PERIODO")));
          dtoNivelRiesgo.setPeriodosReevaluar(this.bigDecimalToInteger(rs.getValueAt(i,"IPERIODOS")));
          dtoNivelRiesgo.setPeriodoPedidos(new Integer(0)); 
          dtoNivelRiesgo.setNumeroDiasAtraso(new Integer(0));
          dtoNivelRiesgo.setNumeroDiasDeudaVencida(new Integer(0));

          ArrayList arrayDtos;
          if (dtoNivelRiesgo.getOidPeriodo() != null) {
              if (hashClientesPeriodos.containsKey(dtoNivelRiesgo.getOidPeriodo())) {
                arrayDtos = (ArrayList)hashClientesPeriodos.get(dtoNivelRiesgo.getOidPeriodo());
              } else {
                arrayDtos = new ArrayList();
              }
              arrayDtos.add(dtoNivelRiesgo);
              hashClientesPeriodos.put(dtoNivelRiesgo.getOidPeriodo(), arrayDtos);              
          }          
        }
        
        StringBuffer filtroMarcas = new StringBuffer();
        filtroMarcas.append(this.obtenerMarcasSituacion(dto.getOidPais()).toString());
        
        HashMap hashNivelesEvaluacion = this.obtenerNivelesEvaluacion();
        Iterator it = (Iterator)((Collection)hashClientesPeriodos.values()).iterator();
        
        StringBuffer cadenaUpdateNivelRiesgo = new StringBuffer();
        while (it.hasNext()){
            ArrayList arrayClientes = (ArrayList)it.next();
            int longArray = arrayClientes.size();
            if (longArray > 0){
              arrayClientes = this.calcularPedidosUltimaEvaluacion(arrayClientes, oidPeriodo2);
              arrayClientes = this.calcularDatosCCC(arrayClientes, dto.getOidPais(), filtroMarcas);
              
              DTONivelRiesgo dtoNivelRiesgo = (DTONivelRiesgo)arrayClientes.get(0);
              //UtilidadesLog.debug("dtoNR: OIDCLIENTE:["+ dtoNivelRiesgo.getOidCliente() +"] - PERIODO:["+ dtoNivelRiesgo.getOidPeriodo() +"] - IPERIODOS:["+ dtoNivelRiesgo.getPeriodosReevaluar() +"] - PED_PROM:["+ dtoNivelRiesgo.getPeriodoPedidos() +"] - DIAS_ATRASO:["+ dtoNivelRiesgo.getNumeroDiasAtraso() +"] - DEUDA_VENC:["+dtoNivelRiesgo.getNumeroDiasDeudaVencida()+"]");
              Integer iNumPeriodos = this.obtenerCantidadPeriodosEntre(dtoNivelRiesgo.getOidPeriodo(), oidPeriodoActual);
              for (int i=0;i < longArray;i++){
                  dtoNivelRiesgo = (DTONivelRiesgo)arrayClientes.get(i);                  
                  if(iNumPeriodos.intValue() > dtoNivelRiesgo.getPeriodosReevaluar().intValue()) {
                    Double porcentajePeriodosPedido = new Double(((dtoNivelRiesgo.getPeriodoPedidos().doubleValue() / iNumPeriodos.doubleValue()) * 100));      
                    Long lNivelRiesgo = this.obtenerNivelRiesgoPerf(dtoNivelRiesgo, porcentajePeriodosPedido, hashNivelesEvaluacion);

                    if (lNivelRiesgo != null){                    
                      enviarMensajeNR(dto.getOidPais(), dtoNivelRiesgo.getOidCliente(), lNivelRiesgo);
                      cadenaUpdateNivelRiesgo.append(this.generarCadenaUpdateNivelRiesgo(dtoNivelRiesgo.getOidCliente(), lNivelRiesgo, oidPeriodoActual).toString());
                    } else {
                      LogAPP.error("No Existe nivel de Riesgo para el Cliente : " + dtoNivelRiesgo.getOidCliente());
                    } 
                  }
              }
            }            
        }
        BelcorpService bs = BelcorpService.getInstance();
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR",cadenaUpdateNivelRiesgo.toString());
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    } else {
      LogAPP.error("No se encontraron Clientes ");  
    }
    UtilidadesLog.info("MONCreditoRiesgo.reevaluarNivelRiesgoPerf(DTOReevaluar):Salida");
  }

   private RecordSet obtenerClientesNivelRiesgo(DTOReevaluarEnMasa dto) throws MareException{
    UtilidadesLog.info("MONCreditoRiesgo.obtenerClientesLineaCredito(DTOReevaluarEnMasa dto):Entrada");
    StringBuffer query = new StringBuffer();    
    
    query.append("SELECT DISTINCT A.OID_CLIE AS OIDCLIENTE, ");
	  query.append("    CASE WHEN (CDA.PERD_OID_PERI_NIVE_RIES IS NULL) THEN");
		query.append("      (");
		query.append("        SELECT CHE.PERD_OID_PERI");
		query.append("        FROM MAE_CLIEN_HISTO_ESTAT CHE");
		query.append("        WHERE CHE.CLIE_OID_CLIE = A.OID_CLIE");
		query.append("          AND CHE.ESTA_OID_ESTA_CLIE = " + ConstantesMAE.OID_ESTATUS_NUEVA);
		query.append("      )  ");
		query.append("    ELSE");
		query.append("      CDA.PERD_OID_PERI_NIVE_RIES");
		query.append("    END PERIODO,");
		query.append("    CASE WHEN (CDA.PERD_OID_PERI_NIVE_RIES IS NULL) THEN");
		query.append("        PAR_GEN.NUM_PERI_NUEV");
		query.append("    ELSE");
		query.append("        PAR_GEN.NUM_PERI_ANTI");
		query.append("    END IPERIODOS ");
    query.append("FROM MAE_CLIEN A, ");
    query.append("     MAE_CLIEN_TIPO_SUBTI B, ");
		query.append("     MAE_CLIEN_UNIDA_ADMIN C, ");
    query.append("     ZON_TERRI_ADMIN D, ");
    query.append("     ZON_SECCI E, ");
    query.append("     ZON_ZONA F, ");
    query.append("     ZON_REGIO G, ");
    query.append("     MAE_CLIEN_DATOS_ADICI CDA,");
		query.append("    (");
		query.append("      SELECT NUM_PERI_NUEV, NUM_PERI_ANTI ");
		query.append("      FROM CAR_PARAM_GENER_CARTE PGC");
		query.append("      WHERE PGC.PAIS_OID_PAIS = " + dto.getOidPais());
		query.append("    ) PAR_GEN ");
    query.append("WHERE A.PAIS_OID_PAIS = " + dto.getOidPais());
	  query.append("  AND B.CLIE_OID_CLIE = A.OID_CLIE  ");
	  query.append("  AND B.TICL_OID_TIPO_CLIE = " + ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
	  query.append("  AND C.CLIE_OID_CLIE = B.CLIE_OID_CLIE  ");
	  query.append("  AND C.IND_ACTI = 1 ");
	  query.append("  AND D.OID_TERR_ADMI = C.ZTAD_OID_TERR_ADMI ");
	  query.append("  AND D.IND_BORR = 0 ");
	  query.append("  AND E.OID_SECC = D.ZSCC_OID_SECC ");
	  query.append("  AND E.IND_BORR = 0 ");
	  query.append("  AND E.IND_ACTI = 1 ");
	  query.append("  AND F.OID_ZONA = E.ZZON_OID_ZONA ");
	  query.append("  AND F.IND_BORR = 0 ");
	  query.append("  AND F.IND_ACTI = 1 ");
	  query.append("  AND G.OID_REGI = F.ZORG_OID_REGI ");
	  query.append("  AND G.IND_BORR = 0 ");
	  query.append("  AND G.IND_ACTI = 1 ");
	  query.append("  AND G.PAIS_OID_PAIS = A.PAIS_OID_PAIS ");
    query.append("  AND G.MARC_OID_MARC = " + dto.getOidMarca());
 	  query.append("  AND G.CANA_OID_CANA = " + dto.getOidCanal());
    query.append("  AND CDA.CLIE_OID_CLIE = A.OID_CLIE ");
    if (dto.getOidRegion() != null) {
      query.append(" AND G.OID_REGI = ").append(dto.getOidRegion()); 
    }
    if( dto.getOidZona() != null) {
        query.append(" AND F.OID_ZONA = ").append(dto.getOidZona()); 
    }
    
    RecordSet rs = null;

    rs = this.executeQuery(query.toString());
    
    UtilidadesLog.info("MONCreditoRiesgo.obtenerClientesLineaCredito(DTOReevaluarEnMasa dto):Salida");
    return rs;
  }
  
  private ArrayList calcularPedidosUltimaEvaluacion(ArrayList arrayClientesPeriodo, Long oidPeriodoActual) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.calcularPedidosUltimaEvaluacion(ArrayList arrayClientesPeriodo, Long oidPeriodoActual):Entrada");
    StringBuffer query = new StringBuffer();    
    
    DTONivelRiesgo dtoNivelRiesgo = (DTONivelRiesgo)arrayClientesPeriodo.get(0);    
    
    query.append(" SELECT PSC.CLIE_OID_CLIE, ");
    query.append(" 		    COUNT(PER.OID_PERI) VAL_CANT_PEDI ");
    query.append("FROM PED_SOLIC_CABEC_ACUM3 PSC, ");
    query.append("  ( ");
    query.append("  SELECT FEC_INIC, PAIS_OID_PAIS, MARC_OID_MARC, CANA_OID_CANA ");
    query.append("  FROM CRA_PERIO ");
    query.append("  WHERE OID_PERI = " + dtoNivelRiesgo.getOidPeriodo());
    query.append("  ) PER_INI, ");
    query.append("  ( ");
    query.append("  SELECT FEC_FINA ");
    query.append("  FROM CRA_PERIO ");
    query.append("  WHERE OID_PERI = " + oidPeriodoActual);
    query.append("  ) PER_FIN, ");
    query.append("  CRA_PERIO PER ");
    query.append("WHERE PSC.PERD_OID_PERI = PER.OID_PERI ");
    query.append("  AND PER.FEC_INIC >= PER_INI.FEC_INIC ");
    query.append("  AND PER.FEC_FINA <= PER_FIN.FEC_FINA ");
    query.append("  AND PER_INI.PAIS_OID_PAIS = PER.PAIS_OID_PAIS ");
    query.append("  AND PER_INI.MARC_OID_MARC = PER.MARC_OID_MARC ");
    query.append("  AND PER_INI.CANA_OID_CANA = PER.CANA_OID_CANA ");
    query.append(this.generarFiltroClientesNivelRiesgo(arrayClientesPeriodo, "PSC").toString());      
    query.append(" GROUP BY PSC.CLIE_OID_CLIE ");
    
    RecordSet rs = null;
      
    rs = this.executeQuery(query.toString());
    HashMap hashClientesPedidoPromedio = new HashMap();
    if (!rs.esVacio()){
      int longRS = rs.getRowCount();
      for (int i = 0; i< longRS;i++){
        Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i,"CLIE_OID_CLIE"));
        Integer pedidoPromedio = this.bigDecimalToInteger(rs.getValueAt(i,"VAL_CANT_PEDI"));
        hashClientesPedidoPromedio.put(oidCliente, pedidoPromedio);
      }
    }
      
    int longArray = arrayClientesPeriodo.size();
    for (int i =0;i<longArray;i++){
       dtoNivelRiesgo = (DTONivelRiesgo)arrayClientesPeriodo.get(i);
       if (hashClientesPedidoPromedio.containsKey(dtoNivelRiesgo.getOidCliente())){
          dtoNivelRiesgo.setPeriodoPedidos((Integer)hashClientesPedidoPromedio.get(dtoNivelRiesgo.getOidCliente()));
       }
    }      
        
  
    UtilidadesLog.info("MONCreditoRiesgo.calcularPedidosUltimaEvaluacion(ArrayList arrayClientesPeriodo, Long oidPeriodoActual):Salida");
    return arrayClientesPeriodo;
  }
  
  
  private Integer obtenerCantidadPeriodosEntre(Long oidPeriodoDesde, Long oidPeriodoActual) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.obtenerCantidadPeriodosEntre(Long oidPeriodoDesde, Long oidPeriodoActual):Entrada");
    StringBuffer query = new StringBuffer();    
    Integer cantPeriodos = new Integer(0);
    
    query.append("SELECT COUNT(OID_PERI) CANT_PERI ");
	  query.append(" FROM CRA_PERIO PERI, ");
		query.append(" ( ");
		query.append("   SELECT FEC_INIC, PAIS_OID_PAIS, MARC_OID_MARC, CANA_OID_CANA ");
		query.append("   FROM CRA_PERIO ");
		query.append("   WHERE OID_PERI = " + oidPeriodoDesde);
		query.append(" ) PER_INI, ");
		query.append(" ( ");
		query.append("   SELECT FEC_FINA ");
		query.append("   FROM CRA_PERIO ");
		query.append("   WHERE OID_PERI = " + oidPeriodoActual);
		query.append(" ) PER_FIN ");
	  query.append(" WHERE PERI.PAIS_OID_PAIS = PER_INI.PAIS_OID_PAIS ");
		query.append("   AND PERI.MARC_OID_MARC = PER_INI.MARC_OID_MARC ");
		query.append("   AND PERI.CANA_OID_CANA = PER_INI.CANA_OID_CANA ");
		query.append("   AND PERI.FEC_INIC >= PER_INI.FEC_INIC ");
		query.append("   AND PERI.FEC_FINA <= PER_FIN.FEC_FINA ");
    
    RecordSet rs = null;
      
    rs = this.executeQuery(query.toString());
    
    if (!rs.esVacio()){
      cantPeriodos = this.bigDecimalToInteger(rs.getValueAt(0,"CANT_PERI"));
    }
  
    UtilidadesLog.info("MONCreditoRiesgo.obtenerCantidadPeriodosEntre(Long oidPeriodoDesde, Long oidPeriodoActual):Salida");
    return cantPeriodos;
  }
  
  private StringBuffer generarCadenaUpdateNivelRiesgo(Long oidCliente, Long nivelRiesgo, Long oidPeriodoActual) {
    StringBuffer query = new StringBuffer();    
    query.append("UPDATE MAE_CLIEN_DATOS_ADICI SET NIRI_OID_NIVE_RIES = " + nivelRiesgo);
    query.append(" , PERD_OID_PERI_NIVE_RIES = " + oidPeriodoActual + " WHERE CLIE_OID_CLIE = " + oidCliente + ";");
    return query; 
 }
 
  private StringBuffer generarFiltroClientesNivelRiesgo(ArrayList arrayClientesPeriodo, String tabla) {
    StringBuffer filtro = new StringBuffer();
    int longArray = arrayClientesPeriodo.size();
    int count = 0;
    String oidClientes = "";
    
    for (int i = 0;i<longArray;i++){
      if (i==0){
        filtro.append(" AND (");
      }
      DTONivelRiesgo dtoNivelRiesgo = (DTONivelRiesgo)arrayClientesPeriodo.get(i);
      if (count == 0) {
          oidClientes = (String)dtoNivelRiesgo.getOidCliente().toString();
      } else { 
          oidClientes += "," + (String)dtoNivelRiesgo.getOidCliente().toString();
      }
      if (count == 999)  {
          filtro.append(" " + tabla + ".CLIE_OID_CLIE IN ( " + oidClientes.toString() + ")  ");                     
          if (i < (longArray -1)){
              filtro.append("  OR ");
          }                    
          count = 0;
          oidClientes = "";
      } else {
          if (i == (longArray -1)){
              filtro.append(" " + tabla + ".CLIE_OID_CLIE IN ( " + oidClientes.toString() + ") ");        
          }                    
          count++;            
      }           
      if (i == (longArray -1)){              
        filtro.append(")");
      }      
    }
    return filtro; 
 }
  
  private ArrayList calcularDatosCCC(ArrayList arrayClientesPeriodo, Long oidPais, StringBuffer filtroMarcas) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.calcularDeudaVencidaCliente(ArrayList arrayClientesPeriodo):Entrada");
    HashMap hashClientesDeudaVencida = this.calcularDeudaVencida(arrayClientesPeriodo, filtroMarcas);
    HashMap hashClientesDiasAtraso = this.calcularDiasAtraso(arrayClientesPeriodo, filtroMarcas);

    int longArray = arrayClientesPeriodo.size();
    DTONivelRiesgo dtoNivelRiesgo;
    for (int i =0;i<longArray;i++){
       dtoNivelRiesgo = (DTONivelRiesgo)arrayClientesPeriodo.get(i);
       if (hashClientesDeudaVencida.containsKey(dtoNivelRiesgo.getOidCliente())){
          dtoNivelRiesgo.setNumeroDiasDeudaVencida((Integer)hashClientesDeudaVencida.get(dtoNivelRiesgo.getOidCliente()));          
       }
       if (hashClientesDiasAtraso.containsKey(dtoNivelRiesgo.getOidCliente())){
          dtoNivelRiesgo.setNumeroDiasAtraso((Integer)hashClientesDiasAtraso.get(dtoNivelRiesgo.getOidCliente()));          
       }       
    }              
  
    UtilidadesLog.info("MONCreditoRiesgo.calcularDeudaVencidaCliente(ArrayList arrayClientesPeriodo):Salida");
    return arrayClientesPeriodo;
  }
  
  
  private StringBuffer obtenerMarcasSituacion(Long oidPais) throws MareException{
    UtilidadesLog.info("MONCreditoRiesgo.obtenerMarcasSituacion():Entrada");
    StringBuffer query = new StringBuffer();    
    
    String proceso = "CON001";
    Integer subproceso = new Integer(1);

 		query.append("    SELECT CMS.OID_MARC_SITU");
		query.append("    FROM CCC_MARCA_SITUA CMS,");
		query.append("         CCC_PROCE CP,");
		query.append("         CCC_SUBPR CS,");
		query.append("         CCC_TIPO_ABONO_SUBPR TAS,");
		query.append("         CCC_MARCA_TIPO_ABONO MTA");
		query.append("    WHERE CP.COD_PROC = '"+ proceso +"'");
		query.append("    AND CS.COD_SUBP = " + subproceso);
		query.append("    AND CS.CCPR_OID_PROC = CP.OID_PROC");
		query.append("    AND TAS.SUBP_OID_SUBP = CS.OID_SUBP");
		query.append("    AND MTA.TASP_OID_TIPO_ABON_SUBP = TAS.OID_TIPO_ABON_SUBP");
		query.append("    AND MTA.MASI_OID_MARC_SALI = CMS.OID_MARC_SITU");
		query.append("    AND MTA.IND_ENTR_SALI LIKE 'E'");
		query.append("    AND CP.PAIS_OID_PAIS = " + oidPais);
    
    RecordSet rs = null;

    rs = this.executeQuery(query.toString());
    StringBuffer datosInsercion = new StringBuffer();
    if (!rs.esVacio()){
      int longRS = rs.getRowCount();
      for (int i=0;i<longRS;i++){
        if (i==0){
          datosInsercion.append(this.bigDecimalToLong(rs.getValueAt(i,"OID_MARC_SITU")).toString());
        } else {
          datosInsercion.append("," + this.bigDecimalToLong(rs.getValueAt(i,"OID_MARC_SITU")).toString());
        }
      }
    }
    UtilidadesLog.info("MONCreditoRiesgo.obtenerMarcasSituacion():Salida");
    return datosInsercion;
  }


  private HashMap calcularDeudaVencida(ArrayList arrayClientesPeriodo, StringBuffer filtroMarcas) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.calcularDeudaVencida(ArrayList arrayClientesPeriodo, StringBuffer filtroMarcas):Entrada");
    StringBuffer query = new StringBuffer();    

    query.append(" SELECT MCC.CLIE_OID_CLIE, ");
	 	query.append("        MAX(SYSDATE - MCC.FEC_VENC) N_DIAS");
	  query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC");
	  query.append(" WHERE MCC.IMP_MOVI <> MCC.IMP_PAGA");
    query.append(" AND MCC.MASI_OID_MARC_SITU IN (");
    query.append(filtroMarcas.toString());
    query.append("        )");
    StringBuffer filtroClientes = new StringBuffer();
		filtroClientes.append(this.generarFiltroClientesNivelRiesgo(arrayClientesPeriodo, "MCC").toString()); 
    query.append(filtroClientes.toString());
	  query.append(" GROUP BY MCC.CLIE_OID_CLIE");
    
    RecordSet rs = null;
      
    rs = this.executeQuery(query.toString());
    
    HashMap hashClientesDeudaVencida = new HashMap();
    if (!rs.esVacio()){
      int longRS = rs.getRowCount();
      for (int i = 0; i< longRS;i++){
        Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i,"CLIE_OID_CLIE"));
        Integer numeroDias = this.bigDecimalToInteger(rs.getValueAt(i,"N_DIAS"));
        hashClientesDeudaVencida.put(oidCliente, numeroDias);
      }
    }
    UtilidadesLog.info("MONCreditoRiesgo.calcularDeudaVencida(ArrayList arrayClientesPeriodo, StringBuffer filtroMarcas):Salida");
    return hashClientesDeudaVencida;
  }
  
  private HashMap calcularDiasAtraso(ArrayList arrayClientesPeriodo, StringBuffer filtroMarcas) throws MareException{
    UtilidadesLog.info("MONCreditoRiesgo.calcularDiasAtraso(ArrayList arrayClientesPeriodo, StringBuffer filtroMarcas):Entrada");
    HashMap hashDeudaCliente = this.calcularDeudaCCC(arrayClientesPeriodo, filtroMarcas);
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT CLIE_OID_CLIE,");
	  query.append("       SUM((FEC_MOVI - FEC_VENC) * IMP_PAGO) DIAS_ATRA	  ");
    query.append("FROM	");
    query.append("(  ");
    query.append("  (	  ");
		query.append("  SELECT MCC.CLIE_OID_CLIE,");
		query.append("         TO_DATE(MCC.FEC_ULTI_MOVI) FEC_MOVI,");
		query.append("         MCC.FEC_VENC,");
		query.append("         MCC.IMP_PAGO ");
		query.append("  FROM CCC_MOVIM_CUENT_CORRI MCC");
		query.append("  WHERE MCC.IMP_MOVI <> MCC.IMP_PAGA");
		query.append("  AND MCC.IMP_PAGO <> 0");
		query.append("  AND MCC.FEC_ULTI_MOVI > MCC.FEC_VENC");
    query.append(" AND MCC.MASI_OID_MARC_SITU IN (");
    query.append(filtroMarcas.toString());
    query.append(" ) ");
	  query.append(this.generarFiltroClientesNivelRiesgo(arrayClientesPeriodo, "MCC").toString());
	  query.append("  )");
	  query.append("  UNION");
	  query.append("  (");
	  query.append("  SELECT HMC.CLIE_OID_CLIE,");
		query.append("         TO_DATE(HMC.FEC_MOVI) FEC_MOVI,");
		query.append("         HMC.FEC_VENC,");
		query.append("         HMC.IMP_PAGO");
		query.append("  FROM CCC_HISTO_MOVIM_CC HMC");
  	query.append("  WHERE HMC.IMP_MOVI <> HMC.IMP_PAGA");
		query.append("  AND HMC.IMP_PAGO <> 0");
		query.append("  AND HMC.FEC_MOVI > HMC.FEC_VENC");
    query.append("  AND HMC.MASI_OID_MARC_SITU IN (");
    query.append(filtroMarcas.toString());
    query.append(" ) ");
	  query.append(this.generarFiltroClientesNivelRiesgo(arrayClientesPeriodo, "HMC").toString());
	  query.append("  ) ");
    query.append(" ) ");
    query.append(" GROUP BY CLIE_OID_CLIE	  ");
    
    RecordSet rs = null;
  
    rs = this.executeQuery(query.toString());
    
    HashMap hashClientesDiasAtraso = new HashMap();
    if (!rs.esVacio()){
      int longRS = rs.getRowCount();
      for (int i = 0; i< longRS;i++){
        Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i,"CLIE_OID_CLIE"));
        Long numeroDiasAtraso = new Long(0);
        if (hashDeudaCliente.containsKey(oidCliente)){
            Long deudaTotal = (Long)hashDeudaCliente.get(oidCliente);
            if (!(deudaTotal.longValue() == 0)){
              numeroDiasAtraso = new Long(this.bigDecimalToLong(rs.getValueAt(i,"DIAS_ATRA")).longValue()/deudaTotal.longValue());
            }
        }         
        hashClientesDiasAtraso.put(oidCliente, new Integer(numeroDiasAtraso.intValue()));
      }
    }
  
    UtilidadesLog.info("MONCreditoRiesgo.calcularDiasAtraso(ArrayList arrayClientesPeriodo, StringBuffer filtroMarcas):Salida");
    return hashClientesDiasAtraso;
  }
  
  
   private HashMap calcularDeudaCCC(ArrayList arrayClientesPeriodo, StringBuffer filtroMarcas) throws MareException{
    UtilidadesLog.info("MONCreditoRiesgo.calcularDeudaCCC(ArrayList arrayClientesPeriodo, StringBuffer filtroMarcas):Entrada");
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT MCC.CLIE_OID_CLIE, ");
	  query.append("        SUM(MCC.IMP_PEND) IMP_PEND ");
    query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC ");
    query.append(" WHERE MCC.IMP_MOVI <> MCC.IMP_PAGA ");
    query.append("	 AND MCC.MASI_OID_MARC_SITU IN (");
    query.append(filtroMarcas.toString());
    query.append(" ) ");
    query.append(this.generarFiltroClientesNivelRiesgo(arrayClientesPeriodo, "MCC"));
    query.append(" GROUP BY MCC.CLIE_OID_CLIE ");
    
    RecordSet rs = null;
  
    rs = this.executeQuery(query.toString());
    
    HashMap hashClientesDeudaCCC = new HashMap();
    
    if (!rs.esVacio()){
      int longRS = rs.getRowCount();
      for (int i = 0; i< longRS;i++){
        Long oidCliente = this.bigDecimalToLong(rs.getValueAt(i, "CLIE_OID_CLIE"));
        Long totalDeuda = this.bigDecimalToLong(rs.getValueAt(i, "IMP_PEND"));
        hashClientesDeudaCCC.put(oidCliente, totalDeuda);
      }
    }
    UtilidadesLog.info("MONCreditoRiesgo.calcularDeudaCCC(ArrayList arrayClientesPeriodo, StringBuffer filtroMarcas):Salida");
    return hashClientesDeudaCCC;
  }
  
  
  private HashMap obtenerNivelesEvaluacion() throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.obtenerNivelesEvaluacion():Entrada");
    HashMap hashNivelesEvaluacion = new HashMap();
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT TO_NUMBER(CPE.COD_PARA) COD_PARA, ");
	  query.append("       CPE.VAL_PESO,");
	  query.append("       CCE.VAL_ESCA_MINI,");
	  query.append("       CCE.VAL_MINI,");
	  query.append("       CCE.VAL_MAXI ");
    query.append("FROM CAR_PARAM_EVALU_NR CPE, ");
    query.append("     CAR_CONDI_EVALU_NR CCE ");
    query.append("WHERE CPE.OID_PARA_EVAL_NR = CCE.PENR_OID_PARA_EVAL_NR ");
    query.append("ORDER BY 1,3");
    
    RecordSet rs = null;
    
    rs = this.executeQuery(query.toString());
    
    if (!rs.esVacio()){
       int longRS = rs.getRowCount();
       for (int i =0;i<longRS;i++) {
          DTOParametrosEvaluacionNR dtoParamEvaluacion = new DTOParametrosEvaluacionNR();
          dtoParamEvaluacion.setCodigoParametro(this.bigDecimalToLong(rs.getValueAt(i,"COD_PARA")));
          dtoParamEvaluacion.setValPeso(this.bigDecimalToLong(rs.getValueAt(i,"VAL_PESO")));
          dtoParamEvaluacion.setValEscalaMinima(this.bigDecimalToLong(rs.getValueAt(i,"VAL_ESCA_MINI")));
          dtoParamEvaluacion.setValMinimo(this.bigDecimalToLong(rs.getValueAt(i,"VAL_MINI")));
          dtoParamEvaluacion.setValMaximo(this.bigDecimalToLong(rs.getValueAt(i,"VAL_MAXI")));
          ArrayList arrayParametros;
          if (hashNivelesEvaluacion.containsKey(dtoParamEvaluacion.getCodigoParametro())){
              arrayParametros = (ArrayList)hashNivelesEvaluacion.get(dtoParamEvaluacion.getCodigoParametro());
          } else {
              arrayParametros = new ArrayList();
          }
          arrayParametros.add(dtoParamEvaluacion);
          hashNivelesEvaluacion.put(dtoParamEvaluacion.getCodigoParametro(), arrayParametros);          
       }
    }
    UtilidadesLog.info("MONCreditoRiesgo.obtenerNivelesEvaluacion():Salida");
    return hashNivelesEvaluacion;
  }
  
  
  private Long obtenerNivelRiesgoPerf(DTONivelRiesgo dtoNivelRiesgo, Double porcentajePeriodosPedido, HashMap hashNivelesEvaluacion) throws MareException {
    UtilidadesLog.info("MONCreditoRiesgo.obtenerNivelRiesgoPerf(DTONivelRiesgo dtoNivelRiesgo, Double porcentajePeriodosPedido, HashMap hashNivelesEvaluacion):Entrada");
    Long a = this.calcularEvaluacionPedidosPeriodo(dtoNivelRiesgo, porcentajePeriodosPedido, hashNivelesEvaluacion);
    Long b = this.calcularEvaluacionDiasMora(dtoNivelRiesgo, hashNivelesEvaluacion);
    Long c = this.calcularEvaluacionDiasDeuda(dtoNivelRiesgo, hashNivelesEvaluacion);   
    
    Long d = new Long(a.longValue() + b.longValue() + c.longValue());
    
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT CPN.NIRI_OID_NIVE_RIES ");
    query.append(" FROM CAR_PARAM_NR CPN ");
    query.append(" WHERE CPN.VAL_MINI <= " + d);
	  query.append("   AND CPN.VAL_MAXI >= " + d);
    
    RecordSet rs = null;
    
    rs = this.executeQuery(query.toString());
    Long oidNivelRiesgo = null;
    if (!rs.esVacio()){
        oidNivelRiesgo = this.bigDecimalToLong(rs.getValueAt(0,"NIRI_OID_NIVE_RIES"));
    }
    UtilidadesLog.info("MONCreditoRiesgo.obtenerNivelRiesgoPerf(DTONivelRiesgo dtoNivelRiesgo, Double porcentajePeriodosPedido, HashMap hashNivelesEvaluacion):Salida");
    return oidNivelRiesgo;
  }
  
  
  private Long calcularEvaluacionPedidosPeriodo(DTONivelRiesgo dtoNivelRiesgo, Double porcentajePeriodosPedido, HashMap hashNivelesEvaluacion) {
   UtilidadesLog.info("MONCreditoRiesgo.calcularEvaluacionPedidosPeriodo(DTONivelRiesgo dtoNivelRiesgo, Double porcentajePeriodosPedido, HashMap hashNivelesEvaluacion):Entrada");
   Long a = new Long(0);
   if (hashNivelesEvaluacion.containsKey(ConstantesCAR.PARAM_NR_PEDIDOS_PERIODO)){
        ArrayList arrayParametrosPedidosPeriodo = (ArrayList)hashNivelesEvaluacion.get(ConstantesCAR.PARAM_NR_PEDIDOS_PERIODO);
        int longArrayPPP = arrayParametrosPedidosPeriodo.size();
        for (int i = 0;i<longArrayPPP;i++) {
          DTOParametrosEvaluacionNR dtoParamEvalNR = (DTOParametrosEvaluacionNR)arrayParametrosPedidosPeriodo.get(i);
          if (dtoParamEvalNR.getValMinimo().longValue() <= porcentajePeriodosPedido.longValue() && dtoParamEvalNR.getValMaximo().longValue() >= porcentajePeriodosPedido.longValue()){
              Long v1 = new Long(dtoParamEvalNR.getValMaximo().longValue()-dtoParamEvalNR.getValMinimo().longValue());             
              Long v2 = new Long(dtoParamEvalNR.getValMaximo().longValue()-porcentajePeriodosPedido.longValue());                       
              if (v1.longValue() == 0){
                a = new Long(dtoParamEvalNR.getValEscalaMinima().longValue()*dtoParamEvalNR.getValPeso().longValue());
              } else {
                a = new Long(((v2.longValue()/v1.longValue())+dtoParamEvalNR.getValEscalaMinima().longValue())*dtoParamEvalNR.getValPeso().longValue());  
              }
          }
        }        
    }
    UtilidadesLog.info("MONCreditoRiesgo.calcularEvaluacionPedidosPeriodo(DTONivelRiesgo dtoNivelRiesgo, Double porcentajePeriodosPedido, HashMap hashNivelesEvaluacion):Salida");
    return a;
  }
  
  private Long calcularEvaluacionDiasMora(DTONivelRiesgo dtoNivelRiesgo, HashMap hashNivelesEvaluacion) {
    UtilidadesLog.info("MONCreditoRiesgo.calcularEvaluacionDiasMora(DTONivelRiesgo dtoNivelRiesgo, HashMap hashNivelesEvaluacion):Entrada");
    Long b = new Long(0);
    if (hashNivelesEvaluacion.containsKey(ConstantesCAR.PARAM_NR_DIAS_MORA)){
       if (dtoNivelRiesgo.getNumeroDiasAtraso().intValue() < 0){
          dtoNivelRiesgo.setNumeroDiasAtraso(new Integer(0));
       } else {
         if (dtoNivelRiesgo.getNumeroDiasAtraso().intValue() > 42){
            dtoNivelRiesgo.setNumeroDiasAtraso(new Integer(42));  
         }
       }
       ArrayList arrayParametrosDiasAtraso = (ArrayList)hashNivelesEvaluacion.get(ConstantesCAR.PARAM_NR_DIAS_MORA);
       int longArrayDiasAtraso = arrayParametrosDiasAtraso.size();
       for (int i = 0;i<longArrayDiasAtraso;i++) {
         DTOParametrosEvaluacionNR dtoParamEvalNR = (DTOParametrosEvaluacionNR)arrayParametrosDiasAtraso.get(i);
         if (dtoParamEvalNR.getValMinimo().longValue() <= dtoNivelRiesgo.getNumeroDiasAtraso().longValue() && dtoParamEvalNR.getValMaximo().longValue() >= dtoNivelRiesgo.getNumeroDiasAtraso().longValue()){
             Long v1 = new Long(dtoParamEvalNR.getValMaximo().longValue()-dtoParamEvalNR.getValMinimo().longValue());             
             Long v2 = new Long(dtoParamEvalNR.getValMaximo().longValue()-dtoNivelRiesgo.getNumeroDiasAtraso().longValue());                       
             if (v1.longValue() == 0){
               b = new Long(dtoParamEvalNR.getValEscalaMinima().longValue()*dtoParamEvalNR.getValPeso().longValue());
             } else {
               b = new Long(((v2.longValue()/v1.longValue())+dtoParamEvalNR.getValEscalaMinima().longValue())*dtoParamEvalNR.getValPeso().longValue());  
             }           
         }
      }        
    }
    UtilidadesLog.info("MONCreditoRiesgo.calcularEvaluacionDiasMora(DTONivelRiesgo dtoNivelRiesgo, HashMap hashNivelesEvaluacion):Salida");
    return b;
  }
  
  private Long calcularEvaluacionDiasDeuda(DTONivelRiesgo dtoNivelRiesgo, HashMap hashNivelesEvaluacion) {
    UtilidadesLog.info("MONCreditoRiesgo.calcularEvaluacionDiasDeuda(DTONivelRiesgo dtoNivelRiesgo, HashMap hashNivelesEvaluacion):Entrada");
    Long c = new Long(0);
    if (hashNivelesEvaluacion.containsKey(ConstantesCAR.PARAM_NR_DIAS_DEUDA)){
          if (dtoNivelRiesgo.getNumeroDiasDeudaVencida().intValue() < 0){
            dtoNivelRiesgo.setNumeroDiasDeudaVencida(new Integer(0));
          } else {
            if (dtoNivelRiesgo.getNumeroDiasDeudaVencida().intValue() > 42){
              dtoNivelRiesgo.setNumeroDiasDeudaVencida(new Integer(42));  
            }
          }
          ArrayList arrayParametrosDiasDeudaVencida = (ArrayList)hashNivelesEvaluacion.get(ConstantesCAR.PARAM_NR_DIAS_DEUDA);
          int longArrayDiasAtraso = arrayParametrosDiasDeudaVencida.size();
          for (int i = 0;i<longArrayDiasAtraso;i++) {
            DTOParametrosEvaluacionNR dtoParamEvalNR = (DTOParametrosEvaluacionNR)arrayParametrosDiasDeudaVencida.get(i);
            if (dtoParamEvalNR.getValMinimo().longValue() <= dtoNivelRiesgo.getNumeroDiasDeudaVencida().longValue() && dtoParamEvalNR.getValMaximo().longValue() >= dtoNivelRiesgo.getNumeroDiasDeudaVencida().longValue()){
                Long v1 = new Long(dtoParamEvalNR.getValMaximo().longValue()-dtoParamEvalNR.getValMinimo().longValue());             
                Long v2 = new Long(dtoParamEvalNR.getValMaximo().longValue()-dtoNivelRiesgo.getNumeroDiasDeudaVencida().longValue());                       
                if (v1.longValue() == 0){
                  c = new Long(dtoParamEvalNR.getValEscalaMinima().longValue()*dtoParamEvalNR.getValPeso().longValue());
                } else {
                  c = new Long(((v2.longValue()/v1.longValue())+dtoParamEvalNR.getValEscalaMinima().longValue())*dtoParamEvalNR.getValPeso().longValue());  
                }           
            }
          }        
     }
     UtilidadesLog.info("MONCreditoRiesgo.calcularEvaluacionDiasDeuda(DTONivelRiesgo dtoNivelRiesgo, HashMap hashNivelesEvaluacion):Salida");
     return c;
  }
  
    // gPineda - Perf Segmentacion - 22/01/2007
    private void ejecucionBatch(String IDProceso, DTOFACProcesoCierre dto, Long oidClaseSolicitud ) throws MareException {
        UtilidadesLog.info("MONCreditoRiesgo.ejecucionBatch(String IDProceso, DTOFACProcesoCierre dto, Long oidClaseSolicitud ): Entrada");

        MareMGC mgc = new MareMGC();
        mgc = (MareMGC) MareMii.getService(new MareTopic("Configuration"));
        String numero = (String) mgc.getProperty("application/NumeroMaximoSegmentosNR");

        if ((numero == null) || (numero.equals(""))) {
            // si no esta configurado el tamaño se toma por defecto 12 (numero de procesadores de ejecucion)
            this.numeroMaximoSegmentos = new Integer(12);
        } else {
            UtilidadesLog.debug("application/NumeroMaximoSegmentosNR: "+ numero );
            this.numeroMaximoSegmentos = new Integer(numero);
        }    
        int segmentosEjecutandoSimultaneamente = 0;
        RecordSet rs = this.obtenerZonasPorRegion( dto.getRegion() );
        int totalZonas = rs.getRowCount();
        UtilidadesLog.warn("Total de Zonas: "+ totalZonas );
        for(int i = 0; i<totalZonas; i++) {
            DTOReevaluarEnMasa dtoR = new DTOReevaluarEnMasa();
            dtoR.setOidPais(dto.getOidPais());
            dtoR.setOidIdioma(dto.getOidIdioma());
            dtoR.setOidMarca(dto.getMarca());
            dtoR.setOidCanal(dto.getCanal());
            dtoR.setOidClaseSolicitud(oidClaseSolicitud);
            dtoR.setOidPeriodo(dto.getPeriodo());
            dtoR.setProcedencia(ConstantesCAR.TIPO_REEVALUACION_NR);
            dtoR.setOidRegion(dto.getRegion());
            dtoR.setOidZona( new Long( ((BigDecimal)rs.getValueAt(i, "OID_ZONA") ).longValue() )  );
            dtoR.setMensaje(new Boolean(false));

            IMareDTO dtoSegmento = dtoR;
            DTOSubBatch dtoSubBatch = new DTOSubBatch("CAR_REEVALUAR_NR_", IDProceso, ctx.getCallerPrincipal().getName() ,new MareBusinessID("CARSegmentoReevaluarEnMasaPerf"), dtoSegmento);
            try{
                BatchUtil.executeMLN( dtoSubBatch, new MareBusinessID( "FACProcesosGP5" ));
                
                if ( ++segmentosEjecutandoSimultaneamente == numeroMaximoSegmentos.intValue()){
                    UtilidadesLog.debug("*** El IDProceso es = "+IDProceso);
                    this.esperarProcesamiento( IDProceso );
                    segmentosEjecutandoSimultaneamente = 0;
                }
            }catch(RemoteException re){
                UtilidadesLog.error("ERROR ", re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
            }catch(InterruptedException ie){
                UtilidadesLog.error("ERROR" , ie);
                String codigoError = ie.getMessage();
                throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
            }
        }
        
        try{
            this.esperarProcesamiento(IDProceso);
        }catch(InterruptedException ie){
            UtilidadesLog.error("ERROR ", ie);
            String codigoError = ie.getMessage();
            throw new MareException(ie,UtilidadesError.armarCodigoError(codigoError));
        }   
        UtilidadesLog.info("MONCreditoRiesgo.ejecucionBatch(String IDProceso, DTOFACProcesoCierre dto, Long oidClaseSolicitud ): Entrada");
    }
    
    // gPineda - Perf Segmentacion - 22/01/2007
    // Este metodo puede aceptar operaciones de LC, pero el CU no está preparado.
    public DTOSalidaBatch reevaluarEnMasaPerf(DTOBatch dtoin) throws MareException {
        UtilidadesLog.info("MONCreditoRiesgo.reevaluarEnMasaPerf(DTOBatch dtoin):Entrada");
        UtilidadesLog.debug("DTO PROCESO: "+ dtoin);
        MareDTO dtoonline = (MareDTO)dtoin.getDTOOnline();
        DTOReevaluarEnMasa dto = (DTOReevaluarEnMasa)dtoonline;
        if(ConstantesCAR.TIPO_REEVALUACION_LC.equals(dto.getProcedencia())) { 
           UtilidadesLog.debug("reasignarLineasCredito");
           this.reasignarLineasCreditoPerf(dto);
        } else if(ConstantesCAR.TIPO_REEVALUACION_NR.equals(dto.getProcedencia())) { 
           UtilidadesLog.debug("reasignarNivelRiesgo");
           this.reevaluarNivelRiesgoPerf(dto);
        }
        UtilidadesLog.info("MONCreditoRiesgo.reevaluarEnMasaPerf(DTOBatch dtoin):Salida");    
        return new DTOSalidaBatch(0,"Ejecucion reevaluarEnMasa : procesarSegmento completada"); 
    }

    // gPineda - Perf Segmentacion - 22/01/2007
    private RecordSet obtenerZonasPorRegion(Long oidRegion)
        throws MareException {
        UtilidadesLog.info("MONCreditoRiesgo.obtenerZonasPorRegion(Long oidRegion): Entrada");
        RecordSet rs = null;
        
        StringBuffer sb = new StringBuffer();
        sb.append(" SELECT ZON.OID_ZONA ");
        sb.append(" FROM ZON_ZONA ZON ");
        sb.append(" WHERE ZON.IND_ACTI = 1 ");
        sb.append(" AND ZON.IND_BORR = 0 ");
        sb.append(" AND ZON.ZORG_OID_REGI = "+ oidRegion );

        rs = this.executeQuery( sb.toString() );
        UtilidadesLog.info("MONCreditoRiesgo.obtenerZonasPorRegion(Long oidRegion): Salida");
        return rs;
    }

    // gPineda - Perf Segmentacion - 22/01/2007
    private void esperarProcesamiento(String codigoProceso) throws MareException, InterruptedException {
        UtilidadesLog.info("MONCreditoRiesgo.esperarProcesamiento(String codigoProceso): Entrada");
        BatchUtil.esperarHijos(codigoProceso);	
        UtilidadesLog.info("MONCreditoRiesgo.esperarProcesamiento(String codigoProceso): Salida");
    } 
    
    // gPineda - Perf Segmentacion - 22/01/2007
    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }

    private void reevaluarEnMasaPerf(DTOReevaluarEnMasa dtoin) throws MareException {
        UtilidadesLog.info("MONCreditoRiesgo.reevaluarEnMasaPerf(DTOReevaluarEnMasa dtoin):Entrada");
        if(ConstantesCAR.TIPO_REEVALUACION_LC.equals(dtoin.getProcedencia())) { 
           UtilidadesLog.debug("reasignarLineasCredito");
           this.reasignarLineasCreditoPerf(dtoin);
        } else if(ConstantesCAR.TIPO_REEVALUACION_NR.equals(dtoin.getProcedencia())) { 
           UtilidadesLog.debug("reasignarNivelRiesgo");
           this.reevaluarNivelRiesgoPerf(dtoin);
        }
        UtilidadesLog.info("MONCreditoRiesgo.reevaluarEnMasaPerf(DTOReevaluarEnMasa dtoin):Salida");    
    }
    
    private ClienteDatosAdicionalesLocalHome getClienteDatosAdicionalesLocalHome() 
  {
      return new ClienteDatosAdicionalesLocalHome();
  }

  private ClienteHistoricoEstatusLocalHome getClienteHistoricoEstatusLocalHome() 
  {
      return new ClienteHistoricoEstatusLocalHome();
  }
  
  
  private ParametrosCalculoLCLocalHome getParametrosCalculoLCLocalHome() 
  {
      return new ParametrosCalculoLCLocalHome();
  }

    private SolicitudesEntregaBloqueadasLocalHome getSolicitudesEntregaBloqueadasLocalHome() 
    {
        return new SolicitudesEntregaBloqueadasLocalHome();
    }

    private ParametrosGeneralesdeCarteraLocalHome getParametrosGeneralesdeCarteraLocalHome() 
    {
        return new ParametrosGeneralesdeCarteraLocalHome();
    }

    
}