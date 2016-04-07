package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOGestionDeCobranza;
import es.indra.sicc.dtos.cob.DTOUsuariosPerfil;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.entidades.cob.EtapasDeudaLocal;
import es.indra.sicc.entidades.cob.GestionesCobranzaLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOColeccion;
//import es.indra.sicc.dtos.dto.DTOColeccion;
import es.indra.sicc.util.COBEjbLocators;
import es.indra.sicc.dtos.cob.DTOBuscarClientesAsignados;
import es.indra.sicc.dtos.cob.DTOGenerarMensajes;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.entidades.cob.HistoricoMensajesLocalHome;
import es.indra.sicc.entidades.cob.HistoricoMensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.entidades.cob.EtapasDeudaLocalHome;
import es.indra.sicc.entidades.cob.AccionesCobranzaLocal;
import es.indra.sicc.entidades.cob.AccionesCobranzaLocalHome;

import es.indra.sicc.dtos.cob.DTOHistoricoMensajeLote;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.logicanegocio.cob.ConstantesCOB;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Iterator;

import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.dtos.cob.DTOIdLote;

import es.indra.sicc.entidades.cob.GestionesCobranzaLocal;

import java.math.BigDecimal;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONSoporteCobranzaBean implements SessionBean
{
  SessionContext sessionContext = null;
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

  public void setSessionContext(SessionContext ctx){sessionContext = ctx; }



 /** 
  * Retorna el DTOSalida con el resultado de la consulta.
  * @param 
  * @return DTOSalida
  * @exception MareException 
  * @author mamontie
  * @referencia SICC-DMCO-COM-202-334-N036
  */

  public DTOSalida cargarEtapasPais(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("MONSoporteCobranzaBean.cargarEtapasPais(DTOBelcorp dto): Entrada");
  
      /*
       * ->LLamar al método: 
      DAOSoporteCobranza.cargarEtapasPais(dto:DTOBelcorp): DTOSalida 
      ->Retorna el DTOSalida con el resultado de la consulta. 
       * */
      DTOSalida dts = new DTOSalida();
      DAOSoporteCobranza dao = new DAOSoporteCobranza();
      dts = dao.cargarEtapaPais(dto);
      
    UtilidadesLog.info("MONSoporteCobranzaBean.cargarEtapasPais(DTOBelcorp dto): Salida");
      
      return dts;
  }


/** 
  * Retorna el DTOSalida con el resultado de la consulta.
  * @param DTOOID
  * @return DTOSalida
  * @exception MareException 
  * @author mamontie
  * @referencia SICC-DMCO-COM-202-334-N036
  */
  public DTOSalida cargarMensajesLote(DTOOID dtoe) throws MareException{
    UtilidadesLog.info("MONSoporteCobranzaBean.cargarMensajesLote(DTOOID dtoe): Entrada");
  
     DTOSalida dts = new DTOSalida();
     DAOSoporteCobranza dao = new DAOSoporteCobranza();
     dts = dao.cargarMensajesLote(dtoe);
     
    UtilidadesLog.info("MONSoporteCobranzaBean.cargarMensajesLote(DTOOID dtoe): Salida");
     
     return dts;
  }

/** 
  * Actualizar los datos contenidos en el DTOHistoricoMensajesLote fecha de 
    entrega y las observaciones correspondientes.
  * @param DTOColeccion
  * @return 
  * @exception MareException 
  * @author mamontie
  * @referencia SICC-DMCO-COM-202-334-N036
  */
  public void grabarMensajesLote(DTOColeccion dtoe) throws MareException{
    UtilidadesLog.info("MONSoporteCobranzaBean.grabarMensajesLote(DTOColeccion dtoe): Entrada");
  
      /*
       * ->Por cada DTOHistoricoMensajeLote, contenidos en el dto recibido hacer: 
      ->findByPK en la entidad "HistoricoMensajes" (COB_HISTO_MENSA) 
      ->Actualizar los datos contenidos en el DTOHistoricoMensajesLote fecha de 
      entrega y las observaciones correspondientes.
       * */
      HistoricoMensajesLocalHome histMsjLocalHome;      
      HistoricoMensajesLocal histMsjLocal;
      histMsjLocalHome = this.getHistoricoMensajesLocalHome();
      ArrayList arrayMsj = new ArrayList();                
      arrayMsj = dtoe.getLista();
      DTOHistoricoMensajeLote dTOHistoricoMensajeLote = null;
      
      for (int i=0;i<dtoe.getLista().size();i++){
          dTOHistoricoMensajeLote =   (DTOHistoricoMensajeLote)arrayMsj.get(i);
          try{
              histMsjLocal = histMsjLocalHome.findByPrimaryKey(dTOHistoricoMensajeLote.getOid());              
              //histMsjLocal.setFechaEntregaMensaje(new Date(System.currentTimeMillis()));
              
              histMsjLocal.setFechaEntregaMensaje(dTOHistoricoMensajeLote.getFechaEntrega());
              histMsjLocal.setObservacion(dTOHistoricoMensajeLote.getObservaciones());
              
              histMsjLocalHome.merge(histMsjLocal);
              
          } catch(NoResultException nre) {
              sessionContext.setRollbackOnly();
              nre.printStackTrace();
              throw new MareException(nre, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          } catch(PersistenceException pex) {
              sessionContext.setRollbackOnly();
              pex.printStackTrace();
              throw new MareException(pex, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        }
        
    UtilidadesLog.info("MONSoporteCobranzaBean.grabarMensajesLote(DTOColeccion dtoe): Salida");
  }

  /** 
  * Actualizar los datos contenidos en el DTOHistoricoMensajesLote fecha de 
    entrega y las observaciones correspondientes.
  * @param DTOBuscarClientesAsignados
  * @return DTOSalida
  * @exception MareException 
  * @author mamontie
  * @referencia SICC-DMCO-COM-202-334-N036
  */
  public DTOSalida buscarClientesAsignados(DTOBuscarClientesAsignados dtoe) throws MareException{    
    UtilidadesLog.info("MONSoporteCobranzaBean.buscarClientesAsignados(DTOBuscarClientesAsignados dtoe): Entrada");
  
      DTOSalida dts = new DTOSalida();
      DAOSoporteCobranza dao = new DAOSoporteCobranza();      
       
      dts = dao.buscarClientesAsignados(dtoe);

    UtilidadesLog.info("MONSoporteCobranzaBean.buscarClientesAsignados(DTOBuscarClientesAsignados dtoe): Salida");
      
      return dts;
  }
  /** 
  * Genera el mensaje
  * @param DTOGenerarMensajes
  * @return DTOOID
  * @exception MareException 
  * @author mamontie
  * @referencia SICC-DMCO-COM-202-334-N036
  */
  public DTOOID generarMensajes(DTOColeccion dto) throws MareException{
    UtilidadesLog.info("MONSoporteCobranzaBean.generarMensajes(DTOColeccion dto): Entrada");
   
        //->Crear un DTOOID dtoSalida    
        boolean generoMensaje = false;
        DTOOID dtoSalida = new DTOOID();
    try {     
UtilidadesLog.debug(" Paso 0 " + dto);
//-> Se recibe un DTOColeccion de DTOGenerarMensajes ""dto"".
/*
->Crear un Long ""idLote"" 
-> idLote = Convertir a Long el resultado de llamar al caso de uso Generar nº 
de Documento del modulo PED con la interfaz IGenerarNumeroDocumento y se le 
pasa como parámetro el pais (dtoGenerar.get(pais)), y la operacion 
(ConstantesCOB.OPERACION_COB070)*/
        MONProcesosPEDHome monPedLH = null;
        MONProcesosPED monPedL = null;
        DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();        
        
        String sIdLote = new String();
        monPedLH = COBEjbLocators.getMONProcesosPEDHome();
        
        try{
              monPedL = monPedLH.create();
          }catch(CreateException createException) {
              UtilidadesLog.error(createException);
              sessionContext.setRollbackOnly();
              throw new MareException(createException,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
           }
        dtoNumeroSolicitud.setOidPais(dto.getOidPais());
        dtoNumeroSolicitud.setOidIdioma(dto.getOidIdioma());
        dtoNumeroSolicitud.setOperacion(ConstantesCOB.OPERACION_COB070);
        sIdLote = monPedL.generaNumeroDocumento(dtoNumeroSolicitud);
        
        //--yyy esto es provisorio para que ande - VOLAR!!!---------------------
        //sIdLote = "1";
        //----------------------------------------------------------------------
        
UtilidadesLog.debug(" Paso 7. IDLOTE:     " + sIdLote);        
                
        
/*-> orden = Convertir a Long el resultado de llamar al caso de uso Generar nº de 
Documento del modulo PED  con la interfaz IGenerarNumeroDocumento y se le pasa 
como parámetro el pais (dtoGenerar.get(pais)), y la operacion 
(ConstantesCOB.OPERACION_COB072)
*/
        dtoNumeroSolicitud.setOperacion(ConstantesCOB.OPERACION_COB072);
/* gPineda - Se debe generar un nro de Orden distinto para cada gestion de Cobranza
 * String sIdOrden = monPedL.generaNumeroDocumento(dtoNumeroSolicitud);
UtilidadesLog.debug(" Paso 8. ORDEN " + sIdOrden);*/

//-> dtoSalida.set(oid) = idLote (No es un oid pero lo tratamos como si lo fuera)
        dtoSalida.setOid(new Long(sIdLote));


//-> Por cada elemento del DTOColeccion (dtoGenerar) recibido hacer lo siguiente:
        Iterator iter = dto.getLista().iterator();
        for (int i = 1; iter.hasNext(); i++) {
UtilidadesLog.debug(" PASANDO:  " + i);        
            DTOGenerarMensajes dtoGenerar = (DTOGenerarMensajes) iter.next();
            //->Crear DTOBuzonMensajes ""dtoEntrada"" con: 
             DTOBuzonMensajes dtoEntrada = new DTOBuzonMensajes();
//*oidPais = dtoGenerar.get(pais)
            dtoEntrada.setOidPais(dtoGenerar.getOidPais());
//*CodigoPatron = null
            dtoEntrada.setCodigoPatron(null);
//.............................................
//Crear una entidad EtapaCobranza ""etapaCob""
            EtapasDeudaLocalHome etapaLH = this.getEtapasDeudaLocalHome();
            EtapasDeudaLocal etapaL = null;
            MensajesLocalHome mensajesLH = null;
            MensajesLocal mensajesL = null;
            try{
//Hacer un etapaCob.findByPK(dtoEntrada.get(oidEtapa))            
UtilidadesLog.debug(" Tomando OID ETAPA: " + dtoGenerar.getOidEtapa().toString());
                etapaL = etapaLH.findByPrimaryKey(dtoGenerar.getOidEtapa());
UtilidadesLog.debug(" Paso 12. Desc Etapa:  " + etapaL.getDescripcion());                
                Long oidMensaje = etapaL.getMensaje();
//Crear una entidad Mensajes ""mensajes""
                mensajesLH = this.getMensajesLocalHome();  
//Hacer un mensajes.findByPK(etapaCob.get(oidMensaje))                
                mensajesL = mensajesLH.findByPrimaryKey(oidMensaje);
                
            } catch(NoResultException nre) {
                sessionContext.setRollbackOnly();
                nre.printStackTrace();
                throw new MareException(nre, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch(PersistenceException pex) {
                sessionContext.setRollbackOnly();
                pex.printStackTrace();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
//.............................................//
//*Codigo de Mensaje = mesajes.get(codigoMensaje)
            String codMensaje = mensajesL.getCodMensaje();
            dtoEntrada.setCodigoMensaje(codMensaje);
UtilidadesLog.debug(" Paso 16. MEnsaje " + codMensaje);
//*CodigoCliente = dtoGenerar.get(oidCliente)
            Long lOidCli = dtoGenerar.getOidCliente();
            dtoEntrada.setOidCliente(lOidCli);
//*ModuloOrigen = ConstantesSEG.MODULO_COB
            dtoEntrada.setModuloOrigen(new Long(ConstantesSEG.MODULO_COB));
//*Dato Variable 1 = dtoGenerar.get(clienteNombre)
            dtoEntrada.setDatoVariable1(dtoGenerar.getClienteNombre());
//*Dato Variable 2 = """"
            dtoEntrada.setDatoVariable2(new String(""));
//*Dato Variable 3 = fecha del sistema
            //dtoBuzonMensajes.setDatoVariable3(new Date(System.currentTimeMillis()));            
            dtoEntrada.setDatoVariable3(new Date(System.currentTimeMillis()).toString());
//*Dato Variable 4 = Importe dtoGenerar.get(importe)

UtilidadesLog.debug("Importe " + dtoGenerar.getImporte());
            // vbongiov -- 30/12/2008
            dtoEntrada.setDatoVariable4((dtoGenerar.getImporte()==null?"":dtoGenerar.getImporte().toString()) );
//*Lista Consultoras = 0
            dtoEntrada.setListaConsultoras(new String("0"));
//............................................................................
//............................................................................
//*********-> Crear DTOBuzonMensajes ""mensaje""
            DTOBuzonMensajes mensaje = new DTOBuzonMensajes();
//-> mensaje = IMSG.insertarDatosMensajes(dtoGenerar)
            MONGestionMensajesHome gestionMsjHome = COBEjbLocators.getMONGestionMensajesHome();
            MONGestionMensajes  gestionMsj = null;
            try{
                gestionMsj = gestionMsjHome.create();
            }catch(CreateException createException) {
                UtilidadesLog.error(createException);
                sessionContext.setRollbackOnly();
                throw new MareException(createException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
             }

            dtoEntrada.setOidCliente(dtoGenerar.getOidCliente());
            mensaje = gestionMsj.insertaDatosMensaje(dtoEntrada);
            UtilidadesLog.debug("OID OBTENIDO:   " + mensaje.getOid());            


            if (mensaje.getOid() != null )  {   // if mensaje.getOid() != null    pperez CAMBIO MSG - 002
                    
                generoMensaje = true;
    //-> Creamos un DTOHistoricoMensajesLote ""dtoHisto"" de la siguiente manera
                DTOHistoricoMensajeLote dtoHisto = new DTOHistoricoMensajeLote();
    //sociedad = null
                dtoHisto.setSociedad(null);
    
    
                
                //--yyy esto es provisorio para que ande - VOLAR!!!-----------------
                //dtoHisto.setSociedad(new Long(1));
                //------------------------------------------------------------------
                
                
                
    //String usuario = dtoGenerar.get(oidUsuarioCobranza)
                String usuario = dtoGenerar.getOidUsuarioCobranza().toString();
                
                dtoHisto.setUsuarioCobranza(dtoGenerar.getOidUsuarioCobranza());
                
    //etapaDeuda = dtoGenerar.get(oidEtapa)
                dtoHisto.setEtapaDeuda(dtoGenerar.getOidEtapa());
    //periodo = dtoGenerar.get(oidPeriodo)
                dtoHisto.setPeriodo(dtoGenerar.getOidPeriodo());
    //buzonMensajes = mensaje.get(oid) 
                dtoHisto.setOidBuzonMensaje(mensaje.getOid());
    //fechaEmision = mensaje.get(fechaGrabacion)
                Date fecha = new java.sql.Date(mensaje.getFechaGrabacion().getTime());
                dtoHisto.setFechaEmision(fecha);
    //IdLote = idLote             
                dtoHisto.setCodLote(new Long(sIdLote));
    //importe = dtoGenerar.get(importe)             
                dtoHisto.setImporte(dtoGenerar.getImporte());
    
                
    //.............................................................................//
    //.............................................................................//
    //-> Con el DTOHisto hacer un create() en la entidad HistoricoMensaje
                HistoricoMensajesLocalHome histoMensajesLH =  this.getHistoricoMensajesLocalHome();
                HistoricoMensajesLocal histoMensajesL =  null;
                UtilidadesLog.debug( "codigo lote:  " + dtoHisto.getCodLote() );
                UtilidadesLog.debug( "periodo:      " + dtoHisto.getPeriodo() );
                UtilidadesLog.debug( "etapa deuda:  " + dtoHisto.getEtapaDeuda() );
                UtilidadesLog.debug( "UsuarioCobr:  " + dtoHisto.getUsuarioCobranza());
                
                try{
    
      //--yy se asigna este valor provisoriamente para que ande - VOLAR!!!----------
      //dtoHisto.setUsuarioCobranza(new Long(8));
      //----------------------------------------------------------------------------
    
      UtilidadesLog.debug("dtoHisto.getCodLote(): " + dtoHisto.getCodLote());
      UtilidadesLog.debug("dtoHisto.getSociedad(): " + dtoHisto.getSociedad());
      UtilidadesLog.debug("dtoHisto.getPeriodo(): " + dtoHisto.getPeriodo());
      UtilidadesLog.debug("dtoHisto.getOidBuzonMensaje(): " + dtoHisto.getOidBuzonMensaje());
      UtilidadesLog.debug("dtoHisto.getEtapaDeuda(): " + dtoHisto.getEtapaDeuda());
      UtilidadesLog.debug("dtoHisto.getUsuarioCobranza(): " + dtoHisto.getUsuarioCobranza());
    
                        histoMensajesL =  histoMensajesLH.create(dtoHisto.getCodLote(), dtoHisto.getSociedad(),
                        dtoHisto.getPeriodo(),dtoHisto.getOidBuzonMensaje(),
                        dtoHisto.getEtapaDeuda(), dtoHisto.getUsuarioCobranza() );
                        histoMensajesL.setFechaEmisionMensaje(new Date(System.currentTimeMillis()));
                        histoMensajesL.setImporte(dtoHisto.getImporte());
                        
                        histoMensajesLH.merge(histoMensajesL);
                        
                } catch(PersistenceException e) {
                     sessionContext.setRollbackOnly();
                     e.printStackTrace();
                     throw new MareException(e,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }     
    ///.............................................................................///
    //-> Crear un DTOGestionDeCobranza DTOGestion con:
                DTOGestionDeCobranza dtoGestion = new DTOGestionDeCobranza();            
    //*String usuario = Recuperar el nombre del usuario logueado 
                String usuarioLogin = sessionContext.getCallerPrincipal().getName();
                UtilidadesLog.debug("Usuario Logueado:  " + usuarioLogin);
    //DTOUsuariosPerfil dtoPerfil
                DTOUsuariosPerfil dtoPerfil = new DTOUsuariosPerfil();
                dtoPerfil.setOidPais(dtoGenerar.getOidPais());
                dtoPerfil.setOidIdioma(dtoGenerar.getOidIdioma());
    //dtoPerfil.set(loginUsuario)=usuario
                dtoPerfil.setLoginUsuario(usuarioLogin);
    //usuarioCobranza = DAOGestionesDeCobranza.recuperarUsuario(dtoPerfil)
                DAOGestionesDeCobranza daoGestionesCob = new DAOGestionesDeCobranza();
               
                Long oidUsuCob = daoGestionesCob.recuperarUsuario(dtoPerfil);
                dtoGestion.setOidUsuarioCobranza(oidUsuCob);
    
    //* oidEtapaDeuda = dtoGenerar.get(oidEtapa)
                dtoGestion.setOidEtapaDeuda(dtoGenerar.getOidEtapa());
    //* oidPeriodo = dtoGenerar.get(oidPeriodo)
                dtoGestion.setOidPeriodo(dtoGenerar.getOidPeriodo());
    //* oidTipoCargo: nulos
                dtoGestion.setOidTipoCargoAbono(null);
    //* oidCliente: dtoGenerar.get(oidCliente)
                dtoGestion.setOidCliente(dtoGenerar.getOidCliente());
    //* procesoActualiza = ""Mensajes""
                dtoGestion.setProcesoActualiza("mensajes");
    
    
    
    //............................................................................//
    //* oidCodigoAccion: El oid de la accion (OID_ACCI_COBR). Se recupera de la             
    //entidad ""Acciones de Cobranza"" (COB_ACCIO_COBRA) donde: 
    //COB_ACCIO_COBRA.PAIS_OID_PAIS = dto.get(pais) y 
    //COB_ACCIO_COBRA.IND_ACCI_MENS_RECO = ""true""
                AccionesCobranzaLocalHome accionesCobLH = null;
                AccionesCobranzaLocal accionesCobL = null;
                try{
    //Crear una entidad AccionesCobranza ""accionesCob""                
                    accionesCobLH = this.getAccionesCobranzaLocalHome();
    //Hacer un mensajes.findByIndicador(dtoGenerar.get(oidPais), true)                
                    accionesCobL = accionesCobLH.findByIndicador(dtoGenerar.getOidPais(),
                                    new Long(1));
                } catch(NoResultException nre) {
                    sessionContext.setRollbackOnly();
                    nre.printStackTrace();
                    throw new MareException(nre, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch(PersistenceException pex) {
                    sessionContext.setRollbackOnly();
                    pex.printStackTrace();
                    throw new MareException(pex, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
    //............................................................................//
                String sCodigoAccion = accionesCobL.getCodigoAccionCobranza();
                dtoGestion.setAccion(sCodigoAccion);
                
                //modif mm
                dtoGestion.setOidAccion(accionesCobL.getOid());
                
    // fechaSeguimiento: se recupera la fecha del sistema
                DateFormat df = DateFormat.getDateInstance();
                UtilidadesLog.debug("Formato de la fecha:   " + df);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
                java.sql.Date fechaD = new java.sql.Date(fecha.getTime());
                String hora = sdf2.format(fechaD);
                UtilidadesLog.debug("Hora: " + hora);
                String sFechaSistema = sdf.format(fechaD); 
                UtilidadesLog.debug("Fecha Sistema: " + sFechaSistema);
                dtoGestion.setFechaSeguimiento(new Date(System.currentTimeMillis()));
    // horaSeguimiento: se recupera la hora del sistema
                dtoGestion.setHoraSeguimiento(hora);
                
    // compromisosDePago: Nulo 
    // fechaReprogramación: Nulo
    // horaReprogramación: Nulo
    // aportaPrueba: Nulo
    // descripciónPrueba: Nulo
    // numeroDocSoporte: idLote
                dtoGestion.setNumeroDocSoporte(new Long(sIdLote));
    // tipoDocPago: Nulo
    // codigoBanco: Nulo
    // codigoSucursal: Nulo
    // nuevaDirección: Nulo
    // nuevoTelefono: Nulo
    // pasaAdministrador: Nulo
    // peticionBloqueoAdmin: 0
                dtoGestion.setPeticionBloqueoAdmin(Boolean.TRUE);
    // peticionDesbloqueoAdmin: 0
                dtoGestion.setPeticionDesbloqueoAdmin(Boolean.TRUE);
    // visadoAdministrador: 0
                dtoGestion.setVisadoAdministrador(Boolean.TRUE);
    // marcaComisionCalculada: 0 
                dtoGestion.setMarcaComisionCalculada(Boolean.TRUE);
    // observaciones:""""  
    // motivoNoCobro: Nulo
    //-> Con el DTOGestion hacer un create() en la entidad GestionCobranza
                GestionesCobranzaLocalHome gestionesCobLH = this.getGestionesCobranzaLocalHome();
                GestionesCobranzaLocal gestionesCobL = null;
                try{
                
                  //--yyy se asigna provisoriamente para que ande - VOLAR!!!--------
                  //dtoGestion.setOidUsuarioCobranza(new Long(1));
                  //----------------------------------------------------------------
                
                  //--yyy se asigna provisoriamente para que ande - VOLAR!!!--------
                  //dtoGestion.setOidAccion(new Long(1));
                  //----------------------------------------------------------------
                  
                  // gPineda - 13/02/2007 - C-COB-006
                  // Se debe generar un nro de Orden distinto para cada Gestion de Cobranza
                  String sIdOrden = monPedL.generaNumeroDocumento(dtoNumeroSolicitud);
                                  
                       UtilidadesLog.debug(" Integer.valueOf(numOrden) " + Integer.valueOf(sIdOrden));
                       UtilidadesLog.debug(" dtoGestion.getOidCliente()  " + dtoGestion.getOidCliente());
                       UtilidadesLog.debug(" dtoGestion.getOidPeriodo() " + dtoGestion.getOidPeriodo());
                       UtilidadesLog.debug(" dtoGestion.getOidEtapaDeuda() " + dtoGestion.getOidEtapaDeuda() );
                       UtilidadesLog.debug(" dtoGestion.getOidUsuarioCobranza() " + dtoGestion.getOidUsuarioCobranza());
                       UtilidadesLog.debug(" dtoGestion.getOidAccion() " + dtoGestion.getOidAccion());
                       // vbongiov -- 30/12/2008
                       gestionesCobL = gestionesCobLH.create(sIdOrden, 
                                          dtoGestion.getOidCliente(), 
                                          dtoGestion.getOidPeriodo(), 
                                          dtoGestion.getOidEtapaDeuda(),
                                          dtoGestion.getOidUsuarioCobranza(),
                                          dtoGestion.getOidAccion());
                                          
                        gestionesCobL.setFechaSeguimiento(dtoGestion.getFechaSeguimiento());
                        gestionesCobL.setHoraSeguimiento(dtoGestion.getHoraSeguimiento());
                        gestionesCobL.setNumeroDocumentoSoporte(new BigDecimal(sIdLote));
                        gestionesCobL.setVisadoAdministrador(dtoGestion.getVisadoAdministrador());
                        gestionesCobL.setMarcaComisionCalculada(dtoGestion.getMarcaComisionCalculada());
                        gestionesCobL.setPeticionBloqueo(dtoGestion.getPeticionBloqueoAdmin());
                        gestionesCobL.setPeticionDesbloqueo(dtoGestion.getPeticionDesbloqueoAdmin());
                                                
                        gestionesCobLH.merge(gestionesCobL);
                                          
    UtilidadesLog.debug(" Paso  37 oidlote " + dtoSalida.getOid());                                      
                    } catch(PersistenceException e) {
                         sessionContext.setRollbackOnly();
                         e.printStackTrace();
                         throw new MareException(e,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }     
                 
            }   // fin if mensaje.getOid() != null    pperez CAMBIO MSG - 002
                 
                 
        }
        
        /* inicio pperez CAMBIO MSG - 002  */
        if (!generoMensaje)  {
           throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ErroresDeNegocio.COB_016));
        }  
        /* fin pperez CAMBIO MSG - 002  */
        
        
    } catch (RemoteException rEx){
        UtilidadesLog.error(rEx);
        String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException( rEx, UtilidadesError.armarCodigoError(sCodigoError) );
    }
 //-> Retornar dtoSalida         
/* =========================================================================== */    

    UtilidadesLog.info("MONSoporteCobranzaBean.generarMensajes(DTOColeccion dto): Salida");

    return dtoSalida;
  }


  /** 
  * Retornar el DTOSalida
  * @param DTOBelcorp
  * @return DTOSalida
  * @exception MareException 
  * @author mamontie
  * @referencia SICC-DMCO-COM-202-334-N036
  */
  public DTOSalida listadoMensajesEmitidos(DTOIdLote dto) throws MareException{
    UtilidadesLog.info("MONSoporteCobranzaBean.listadoMensajesEmitidos(DTOIdLote dto): Entrada");
  
//->Crear un DTOSalida 
//->Llamar al DAOSoporteCobranza.listadoMensajesEmitidos(dto):DTOSalida 
//->Retornar el DTOSalida
        DTOSalida dtoS = new DTOSalida();
        DAOSoporteCobranza dao = new DAOSoporteCobranza();
        dtoS = dao.listadoMensajesEmitidos(dto);
        
        UtilidadesLog.info("MONSoporteCobranzaBean.listadoMensajesEmitidos(DTOIdLote dto): Salida");
        
        return dtoS;
    }

  public DTOSalida cargarIdLotes(DTOBelcorp dtoe) throws MareException{ 
    UtilidadesLog.info("MONSoporteCobranzaBean.cargarIdLotes(DTOBelcorp dtoe): Entrada");
  
     DTOSalida dts = new DTOSalida();
     DAOSoporteCobranza dao = new DAOSoporteCobranza();
     dts = dao.cargarIdLotes(dtoe);
     
    UtilidadesLog.info("MONSoporteCobranzaBean.cargarIdLotes(DTOBelcorp dtoe): Salida");
     
     return dts;
  }
/*Marta Aurora Montiel
 * 30/03/05 Incidencia BELC300015274
 * */
  public DTOSalida cargarEtapasPaisMensaje(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("MONSoporteCobranzaBean.cargarEtapasPaisMensaje(DTOBelcorp dto): Entrada");
  
    /* DAOSoporteCobranza.cargarEtapasPaisMensaje(dto:DTOBelcorp): DTOSalida 
  ->Retorna el DTOSalida con el resultado de la consulta. 
   */
   DAOSoporteCobranza dao = new DAOSoporteCobranza();
   
    UtilidadesLog.info("MONSoporteCobranzaBean.cargarEtapasPaisMensaje(DTOBelcorp dto): Salida");
   
   return dao.cargarEtapasPaisMensaje(dto);
  }
  
  
    private GestionesCobranzaLocalHome getGestionesCobranzaLocalHome()
    {
    return new GestionesCobranzaLocalHome();
    }
    
    private HistoricoMensajesLocalHome getHistoricoMensajesLocalHome()
    {
    return new HistoricoMensajesLocalHome();
    }
    
    private EtapasDeudaLocalHome getEtapasDeudaLocalHome()
    {
    return new EtapasDeudaLocalHome();
    }
    
    private AccionesCobranzaLocalHome getAccionesCobranzaLocalHome()
    {
    return new AccionesCobranzaLocalHome();
    }
    
    private MensajesLocalHome getMensajesLocalHome()
    {
    return new MensajesLocalHome();
    }

}