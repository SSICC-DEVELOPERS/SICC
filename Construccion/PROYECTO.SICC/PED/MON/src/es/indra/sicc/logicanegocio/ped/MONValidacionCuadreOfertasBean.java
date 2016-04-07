package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.DBService;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOProceso;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.pre.MONCuadreOfertasLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class MONValidacionCuadreOfertasBean implements SessionBean  {
    SessionContext ctx;
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx=ctx;
    }

    /**
      Recorremos todas las posiciones de la solicitud (DTOE.posiciones) 
      { 
      DTOPosicionSolicitud = Siguiente posicion en el ArrayList DTOE.posiciones 
      
      // Si la posición ha sido modificada, se actualiza en BD
      Si DTOPosicionSolicitud.tipoPosicion != DTOProceso.oidTipoPosicion 
      { 
      Llamar al método DAOSolicitud.actualizarPosicionCuadre(DTOPosicionSolicitud) 
      } 
      sino // La posición ha sido añadida 
      { 
      DTOE = Llamar al método MONGenerarPosicionSolicitud.generarPosicion(DTOE, DTOPosicionSolicitud.numeroPosicion) 
      Si DTOE.OK == False 
      { 
      DTOPosicionSolicitud.tipoPosicion == ConstantesPED.ESTADO_POSICION_ANULADO 
      Utilizar el servicio APPLoggingService para generar un log de error: 
      [PED] [Validar cuadre de ofertas] Posición soliicitud anulada 
      } 
      } 
      }
    *
    *@autor jpbosnja
    * modificaciones - 08/08/2005 - BELC300014487 - pperanzola 
    **/
    private void actualizarPosicionesSolicitud(DTOCabeceraSolicitud dtoe, DTOProceso dtoProceso) throws MareException{
        UtilidadesLog.info("MONValidacionCuadreOfertasBean.actualizarPosicionesSolicitud(DTOCabeceraSolicitud dtoe, DTOProceso dtoProceso): Entrada ");
        StringBuffer queryGeneral = new StringBuffer();
        try{
            ArrayList arrayNuevas = new ArrayList();
            for(int pos = 0; pos<dtoe.getPosiciones().size();pos++){
                DAOSolicitud dao = new DAOSolicitud();
                DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)dtoe.getPosiciones().get(pos);
                 if (dtoP.getOidPosicionSolicitud()!=null ){
                    if (Boolean.TRUE.equals(dtoP.getProductoReemplazado()) 
                            || Boolean.TRUE.equals(dtoP.getUnidadesModificadas())) {
                                //dao.actualizarPosicionCuadre(dtoP);
                                /**
                                 * Se ejecuta una sola query a traves de una funcion para mejorar los tiempos
                                 * de performance
                                 * autor: jpbonsja
                                 */
                                String query = dao.generarActualizarPosicionCuadre(dtoP);
                                if (query != null){
                                    queryGeneral.append(query).append(";");
                                }
                    }
                 }else {
                    if ( Boolean.TRUE.equals(dtoP.getProductoReemplazado()) ||
                        (((dtoP.getTipoPosicion()== null && dtoProceso.getOidTipoPosicion()==null)
                                  || (dtoP.getTipoPosicion()!= null 
                                      && dtoP.getTipoPosicion().equals(dtoProceso.getOidTipoPosicion())))
                              && ((dtoP.getSubtipoPosicion()== null && dtoProceso.getOidSubTipoPosicion()==null)
                                  || (dtoP.getSubtipoPosicion()!= null 
                                      && dtoP.getSubtipoPosicion().equals(dtoProceso.getOidSubTipoPosicion())))
                                      )) {
                            
                        dtoe.setIndicadorDigitacion(Boolean.FALSE);
                        arrayNuevas.add(dtoP);
                        /*dtoe = getMONGenerarPosicionSolicitudLocalHome().create().generarPosicion(dtoe, dtoP.getNumeroPosicion(), Boolean.TRUE);
                        if (!dtoe.getOK().booleanValue()){
                            dtoP.setTipoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
                            String mensajeLog = "[PED] [Validar cuadre de ofertas] Posición soliicitud anulada";
                            BelcorpService.getInstance().log.info(mensajeLog);
                        }*/
                    }
                }
            }
            arrayNuevas = getMONGenerarPosicionSolicitudLocalHome().create().generarPosicionesCuadre(dtoe, arrayNuevas);
            for (int i = 0 ; i < arrayNuevas.size() ; i++){
                DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)arrayNuevas.get(i);
                if (dtoP.getOK()!=null && !dtoP.getOK().booleanValue()){
                    dtoP.setTipoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
                    String mensajeLog = "[PED] [Validar cuadre de ofertas] Posición solicitud anulada";
                    BelcorpService.getInstance().log.info(mensajeLog);
                }
            }
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.EXECUTOR", queryGeneral.toString());            
        }catch (NamingException e){
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("Exception: "+queryGeneral.toString(),e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONValidacionCuadreOfertasBean.actualizarPosicionesSolicitud(DTOCabeceraSolicitud dtoe, DTOProceso dtoProceso): Salida ");
    }

    /**
      // Recibe una solicitud y llama al proceso de cuadre de ofertas 

      // En primer lugar recupera la información de la cabecera de la solicitud 
      DTOCabeceraSolicitud = Llama al método DAOSolicitud.obtenerCabeceraSolicitudCuadre(DTOE.oidSolicitud) 

      // A continuación recupera las posiciones de la solicitud 
      DTOCabeceraSolicitud.posiciones = Llama al método DAOSolicitud.obtenerPosicionesSolicitudCuadre(DTOE.oidSolicitud) 

      // Obtenemos los datos del proceso recibido 
      DTOProceso = DTOE.proceso 

      // Completa la información necesaria de la solicitud 
      DTOCabeceraSolicitud.indPedidoPrueba = True 

      // Se invoca al proceso de cuadre de ofertas 
      DTOCabeceraSolicitud = Llamar al método IServiceCuadreOfertas.cuadrarOfertas(DTOCabeceraSolicitud,DTOProceso.oidTipoPosicion,DTOProceso.oidSubTipoPosicion) 

      // Se actualizan las posiciones de la solicitud en la BD 
      Llamar al método actualizarPosicionesSolicitud(DTOCabeceraSolicitud) 

      Crea un DTOEstatusSolicitud con: 
      - status = ConstantesPED.ESTADO_SOLICITUD_VALIDADO 

      Devuelve DTOEstatusSolicitud 
    *
    *@autor jpbosnja
    **/
    public DTOEstatusSolicitud  validarCuadreOfertas(DTOSolicitudValidacion dtoe) throws MareException {
        UtilidadesLog.info("MONValidacionCuadreOfertasBean.validarCuadreOfertas(DTOSolicitudValidacion dtoe): Entrada ");
        Cronometrador.startTransaction("MONValidacionCuadreOfertasBean.validarCuadreOfertas");
        
        // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
        if(dtoe.getIndValidacionPROL() != null && dtoe.getIndValidacionPROL()) {
            UtilidadesLog.debug("IndValidacionPROL activo.....");
            
            DTOEstatusSolicitud dtoE = new DTOEstatusSolicitud();
            dtoE.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
            UtilidadesLog.info("MONValidacionCuadreOfertasBean.validarCuadreOfertas(DTOSolicitudValidacion dtoe): Salida ");
            return dtoE;
        }
        
        try{
            
            DAOSolicitud dao = new DAOSolicitud();
            DTOCabeceraSolicitud dtoC = dao.obtenerCabeceraSolicitud(dtoe.getOidSolicitud());
            dtoC.setPosiciones(dao.obtenerPosicionesSolicitud(dtoe.getOidSolicitud()));
            DTOProceso dtoP= dtoe.getProceso();
            dtoC.setIndPedidoPrueba(Boolean.TRUE);
                        
            //dtoC = getMONCuadreOfertasHome().create().cuadrarOfertas(dtoC, dtoP.getOidTipoPosicion(),dtoP.getOidSubTipoPosicion());
            dtoC = getMONCuadreOfertasLocalHome().create().cuadrarOfertas(dtoC, dtoP.getOidTipoPosicion(),dtoP.getOidSubTipoPosicion());
            actualizarPosicionesSolicitud(dtoC, dtoP);
            DTOEstatusSolicitud dtoS = new DTOEstatusSolicitud();
            dtoS.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
            UtilidadesLog.info("MONValidacionCuadreOfertasBean.validarCuadreOfertas(DTOSolicitudValidacion dtoe): Salida ");
            Cronometrador.endTransaction("MONValidacionCuadreOfertasBean.validarCuadreOfertas");
            return dtoS;
        }catch (NamingException e){
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(CreateException e){
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (Exception e){
            if (e instanceof MareException){
                throw (MareException)e;
            }else{
                UtilidadesLog.error("Exception: ",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

    private MONCuadreOfertasLocalHome getMONCuadreOfertasLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCuadreOfertasLocalHome)context.lookup("java:comp/env/ejb/local/MONCuadreOfertas");
    }

    private MONGenerarPosicionSolicitudLocalHome getMONGenerarPosicionSolicitudLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGenerarPosicionSolicitudLocalHome)context.lookup("java:comp/env/ejb/local/MONGenerarPosicionSolicitud");
    }
}