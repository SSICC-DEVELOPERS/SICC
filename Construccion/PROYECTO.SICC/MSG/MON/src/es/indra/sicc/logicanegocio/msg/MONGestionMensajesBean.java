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
package es.indra.sicc.logicanegocio.msg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.ejbservice.EJBLocator;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.msg.DTODestinatarioMensaje;
import es.indra.sicc.entidades.msg.BuzonMensajesLocal;
import es.indra.sicc.entidades.msg.BuzonMensajesLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.logicanegocio.mae.MONEstatusClienteHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.msg.ConstantesMSG;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import es.indra.sicc.util.LogAPP;
import javax.rmi.PortableRemoteObject;

import java.util.HashSet;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONGestionMensajesBean implements SessionBean, IMSG {
    SessionContext ctx;
    private UtilidadesLog log = new UtilidadesLog();
    
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

    public DTOBuzonMensajes insertaDatosMensaje(DTOBuzonMensajes dto) throws MareException {
    
        UtilidadesLog.info("MONGestionMensajesBean.insertaDatosMensaje(DTOBuzonMensajes dto): Entrada");
    
        

        

        Long oidMensaje = null;
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010 
          UtilidadesLog.debug("DTOBuzonMensajes param. entrada es: " + dto);

        try {
            if (dto.getOidMensaje() == null) {
                if ((dto.getOidPais() != null) && (dto.getCodigoMensaje() != null)) {
                    UtilidadesLog.debug("scs 1");

                    MensajesLocalHome mLH = new MensajesLocalHome();
                    MensajesLocal mL;

                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                     
                      UtilidadesLog.debug("Pais: "+dto.getOidPais()+" - CodMensaje: "+dto.getCodigoMensaje());
                    
                    mL = mLH.findByUk(dto.getOidPais(), dto.getCodigoMensaje());
                    oidMensaje = new Long(mL.getOid().longValue());
                } else {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresDeNegocio.MSG_0006));
                }
            } else {

                oidMensaje = dto.getOidMensaje();
            }
            
            //BuzonMensajesLocalHome localHome = getBuzonMensajesLocalHome();
            //localHome.parametrosAuditoria(dto);

            //DAOMSG dao = new DAOMSG();
	        
            /*  inicio CAMBIO MSG 002 - pperez  */
            dto.setOidMensaje(oidMensaje);
            if (!this.validarDestinatario(dto))  {
                /*Loguear el error MSG-0026 // “El cliente no es un destinatario válido para el mensaje”   */
                LogAPP.error(ErroresDeNegocio.MSG_0026 + " El cliente no es un destinatario válido para el mensaje");
                return dto;
            } 
            /*  inicio CAMBIO MSG 002 - pperez  */

            return this.grabarBuzon(oidMensaje, dto);
            //Long numeroSecuencia = new Long(dao.obtenerNumeroSecuencial(oidMensaje, dto.getOidCliente(), dto.getOidPais()).longValue() + 1);
            
            /*UtilidadesLog.debug("numeroSecuencia  " + numeroSecuencia + "dto.getOidCliente() " + dto.getOidCliente() + "  oidMensaje  "+ oidMensaje + " dto.getModuloOrigen()  " + dto.getModuloOrigen() );
            
            local = localHome.create(numeroSecuencia, // Numero Secuencial  
                    dto.getOidCliente(), // Oid Cliente      
                    oidMensaje, // Oid Mensaje 
                    dto.getModuloOrigen() // modulo origen 
                );
            UtilidadesLog.debug("scs 4");

            // pais: no existe en la entidad
            //local.setModulo(dto.getModuloOrigen()); 
            //Si viene S le mando 1, si viene N le mando 0
            
            if (	(dto.getListaConsultoras() == null) || 
					(dto.getListaConsultoras().equals("")) || 
					(dto.getListaConsultoras().equals(ConstantesMSG.NO)) || 
					(dto.getListaConsultoras().equals("0"))  ) {
                    local.setEsConsultora(new Long(0));
            } else {
                 local.setEsConsultora(new Long(1));
				}

            local.setDatoVariable1(dto.getDatoVariable1());
            local.setDatoVariable2(dto.getDatoVariable2());
            local.setDatoVariable3(dto.getDatoVariable3());
            local.setDatoVariable4(dto.getDatoVariable4());
            local.setDatoVariable5(dto.getDatoVariable5());
            local.setDatoVariable6(dto.getDatoVariable6());
            local.setDatoVariable7(dto.getDatoVariable7());
            local.setDatoVariable8(dto.getDatoVariable8());
            local.setDatoVariable9(dto.getDatoVariable9());
            local.setDatoVariable10(dto.getDatoVariable10());
            local.setDatoVariable11(dto.getDatoVariable11());
            local.setDatoVariable12(dto.getDatoVariable12());
            local.setDatoVariable13(dto.getDatoVariable13());
            local.setDatoVariable14(dto.getDatoVariable14());
            local.setDatoVariable15(dto.getDatoVariable15());
            local.setDatoVariable16(dto.getDatoVariable16());
            local.setDatoVariable17(dto.getDatoVariable17());
            local.setDatoVariable18(dto.getDatoVariable18());
            local.setDatoVariable19(dto.getDatoVariable19());
            local.setDatoVariable20(dto.getDatoVariable20());

            // Genera los datos:
            //local.setNumeroSecuencial( 
            //new Long(obtenerNumeroSecuencial(dto.getOidMensaje(), dto.getOidCliente(), dto.getOidPais()).longValue()+1));
            local.setActivo(new Long(1));

            //            local.setEstaImpreso(null);
            local.setFechaGrabacion(new java.sql.Timestamp(System.currentTimeMillis()));

            dtoSalida.setNumeroSecuencial(local.getNumeroSecuencial());

            dtoSalida.setFechaGrabacion(local.getFechaGrabacion());
            dtoSalida.setOid(local.getOid());

            UtilidadesLog.info("MONGestionMensajesBean.insertaDatosMensaje(DTOBuzonMensajes dto): Salida");

            return dtoSalida;*/
        } catch (NoResultException e) {
            UtilidadesLog.debug(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception e){
            UtilidadesLog.debug(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    private MONGestionMensajesLocal getMONGestionMensajesLocal() throws MareException {
        MONGestionMensajesLocalHome localHome = (MONGestionMensajesLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/ejb/local/MONGestionMensajes");
        // Se obtiene el interfaz remoto
        MONGestionMensajesLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONGestionMensajesLocal",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }

    public void eliminaDatosMensaje(DTOBuzonMensajes dto) throws MareException {
    
        UtilidadesLog.info("MONGestionMensajesBean.eliminaDatosMensaje(DTOBuzonMensajes dto): Entrada");
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010 
          UtilidadesLog.debug("DTOBuzonMensajes: " + dto);

        BuzonMensajesLocal local = null;
        Long oidMensaje = null;
        Long oidBuzonMensajes = null;

        try {
            if (dto.getOid() == null) {
                if (dto.getOidMensaje() == null) {
                    if ((dto.getOidPais() != null) && (dto.getCodigoMensaje() != null)) {
                        MensajesLocalHome mLH = new MensajesLocalHome();
                        MensajesLocal mL;
                        mL = mLH.findByUk(dto.getOidPais(), dto.getCodigoMensaje());
                        
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010 
                          UtilidadesLog.debug("mL.getOid():  " + mL.getOid());
                          
                        oidMensaje = new Long(mL.getOid().longValue());
                    } else {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresDeNegocio.MSG_0006));
                    }
                } else {
                    oidMensaje = dto.getOidMensaje();
                }

                BuzonMensajesLocalHome bmLH = getBuzonMensajesLocalHome();
                BuzonMensajesLocal bmL;
                bmL = bmLH.findByUk(oidMensaje, dto.getOidCliente(), dto.getNumeroSecuencial());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010 
                  UtilidadesLog.debug("BuzonMensaje, bmL: " + bmL.getOid());
                
                oidBuzonMensajes = new Long(bmL.getOid().longValue());
            } else {
                oidBuzonMensajes = dto.getOid();
            }

            BuzonMensajesLocalHome localHome = getBuzonMensajesLocalHome();
            localHome.parametrosAuditoria(dto);
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010 
              UtilidadesLog.debug("Antes de hacer el finder.. con  oidBuzonMensajes: " + oidBuzonMensajes);
              
            local = localHome.findByPrimaryKey(oidBuzonMensajes);
            UtilidadesLog.debug("Despues del finder....  ");
            local.remove();
        } catch (FinderException finderException) {
            //ctx.setRollbackOnly();
            UtilidadesLog.error("FinderException: ",finderException);
            //throw new MareException(finderException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (RemoveException removeException) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("RemoveException: ",removeException);
            throw new MareException(removeException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        } catch (NoResultException noresultException) {
            //ctx.setRollbackOnly();
            UtilidadesLog.error("FinderException: ",noresultException);
            //throw new MareException(finderException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }catch (Exception exception) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO));
        }
        
        UtilidadesLog.info("MONGestionMensajesBean.eliminaDatosMensaje(DTOBuzonMensajes dto): Salida");
    }

    private BuzonMensajesLocalHome getBuzonMensajesLocalHome() throws MareException {
        String codigoError;
        EJBLocator servicioEjbLocator;
        BuzonMensajesLocalHome localHome = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            localHome = (BuzonMensajesLocalHome) bs.ejbLocator.getEntityLocalHome("java:comp/env/BuzonMensajes");
        } catch (MareServiceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        return localHome;
    }


    public void eliminaMensajesFaltantesAnunciados(DTOBuzonMensajes dto) throws MareException{
  
  
   /*Elimina los mensajes de faltantes anunciados generados por PED que no estén impresos. 
      * @author Sergio Saavedra
      * fecha 23/12/04    
    */
    /* estos datos del dto, deben tener data; si o si
       pais 
       codigoMensaje 
       oidCliente 
       moduloOrigen 
       datoVariable1  
     */
     
        UtilidadesLog.info("MONGestionMensajesBean.eliminaMensajesFaltantesAnunciados(DTOBuzonMensajes dto): Entrada");
     
        if ((dto.getOidPais()!=null) && 
                (dto.getCodigoMensaje()!=null) && 
                (dto.getOidCliente()!=null) &&
                (dto.getModuloOrigen()!=null) &&
                (dto.getDatoVariable1()!=null)) {   
            
            UtilidadesLog.debug("todos los datos ok....");
            
            DAOMSG lnkDao = new DAOMSG();
            lnkDao.eliminaMensajesFaltantesAnunciados(dto);
        }
     
        UtilidadesLog.info("MONGestionMensajesBean.eliminaMensajesFaltantesAnunciados(DTOBuzonMensajes dto): Salida");
    }

    public DTOBuzonMensajes grabarBuzon(Long mensaje, DTOBuzonMensajes dto) throws MareException{
        try{
            DAOMSG dao = new DAOMSG();
            DTOBuzonMensajes dtoSalida = new DTOBuzonMensajes();
            Long numeroSecuencia = new Long((dao.obtenerNumeroSecuencial(mensaje, dto.getOidCliente(), dto.getOidPais()).longValue()+1));
            BuzonMensajesLocal local = null;
            BuzonMensajesLocalHome localHome = getBuzonMensajesLocalHome();
            localHome.parametrosAuditoria(dto);
            local = localHome.create(numeroSecuencia, // Numero Secuencial  
                    dto.getOidCliente(), // Oid Cliente      
                    mensaje, // Oid Mensaje 
                    dto.getModuloOrigen() // modulo origen 
                );
            if (	(dto.getListaConsultoras() == null) || 
					(dto.getListaConsultoras().equals("")) || 
					(dto.getListaConsultoras().equals(ConstantesMSG.NO)) || 
					(dto.getListaConsultoras().equals("0"))  ) {
                    local.setEsConsultora(new Long(0));
            } else {
                 local.setEsConsultora(new Long(1));
				}

            // V-MSG-05 gPineda - Se elimina la invocacion a ajustarVariable() - 18/01/2007
            local.setDatoVariable1(dto.getDatoVariable1());
            local.setDatoVariable2(dto.getDatoVariable2());
            local.setDatoVariable3(dto.getDatoVariable3());
            local.setDatoVariable4(dto.getDatoVariable4());
            local.setDatoVariable5(dto.getDatoVariable5());
            local.setDatoVariable6(dto.getDatoVariable6());
            local.setDatoVariable7(dto.getDatoVariable7());
            local.setDatoVariable8(dto.getDatoVariable8());
            local.setDatoVariable9(dto.getDatoVariable9());
            local.setDatoVariable10(dto.getDatoVariable10());
            local.setDatoVariable11(dto.getDatoVariable11());
            local.setDatoVariable12(dto.getDatoVariable12());
            local.setDatoVariable13(dto.getDatoVariable13());
            local.setDatoVariable14(dto.getDatoVariable14());
            local.setDatoVariable15(dto.getDatoVariable15());
            local.setDatoVariable16(dto.getDatoVariable16());
            local.setDatoVariable17(dto.getDatoVariable17());
            local.setDatoVariable18(dto.getDatoVariable18());
            local.setDatoVariable19(dto.getDatoVariable19());
            local.setDatoVariable20(dto.getDatoVariable20());

            // Genera los datos:
            //local.setNumeroSecuencial( 
            //new Long(obtenerNumeroSecuencial(dto.getOidMensaje(), dto.getOidCliente(), dto.getOidPais()).longValue()+1));
            local.setActivo(new Long(1));

            //            local.setEstaImpreso(null);
            local.setFechaGrabacion(new java.sql.Timestamp(System.currentTimeMillis()));

            dtoSalida.setNumeroSecuencial(local.getNumeroSecuencial());

            dtoSalida.setFechaGrabacion(local.getFechaGrabacion());
            dtoSalida.setOid(local.getOid());
            return dtoSalida;
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
    }

    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env//ejb/local/MONGestionMensajes");
    }

    public DTOBuzonMensajes insertaDatosMensajeBatch(DTOBuzonMensajes dto) throws MareException{
        UtilidadesLog.info("MONGestionMensajesBean.insertaDatosMensaje(DTOBuzonMensajes dto): Entrada");
        Long oidMensaje = null;
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("DTOBuzonMensajes param. entrada es: " + dto);

        try {
            if (dto.getOidMensaje() == null) {
                if ((dto.getOidPais() != null) && (dto.getCodigoMensaje() != null)) {
                    UtilidadesLog.debug("scs 1");

                    MensajesLocalHome mLH = new MensajesLocalHome();
                    MensajesLocal mL;
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010     
                      UtilidadesLog.debug("Pais: "+dto.getOidPais()+" - CodMensaje: "+dto.getCodigoMensaje());
                    
                    mL = mLH.findByUk(dto.getOidPais(), dto.getCodigoMensaje());
                    oidMensaje = new Long(mL.getOid().longValue());
                } else {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresDeNegocio.MSG_0006));
                }
            } else {

                oidMensaje = dto.getOidMensaje();
            }
            
            //BuzonMensajesLocalHome localHome = getBuzonMensajesLocalHome();
            //localHome.parametrosAuditoria(dto);

            /*  inicio CAMBIO MSG 002 - pperez  */
            dto.setOidMensaje(oidMensaje);
            if (!this.validarDestinatario(dto))  {
                /*Loguear el error MSG-0026  “El cliente no es un destinatario válido para el mensaje”  */
                LogAPP.error(ErroresDeNegocio.MSG_0026 + " El cliente no es un destinatario válido para el mensaje");
                return dto;
            }
            /*  inicio CAMBIO MSG 002 - pperez  */

            //DAOMSG dao = new DAOMSG();
            return getMONGestionMensajesLocal().grabarBuzon(oidMensaje, dto);
            //Long numeroSecuencia = new Long(dao.obtenerNumeroSecuencial(oidMensaje, dto.getOidCliente(), dto.getOidPais()).longValue() + 1);
            
            /*UtilidadesLog.debug("numeroSecuencia  " + numeroSecuencia + "dto.getOidCliente() " + dto.getOidCliente() + "  oidMensaje  "+ oidMensaje + " dto.getModuloOrigen()  " + dto.getModuloOrigen() );
            
            local = localHome.create(numeroSecuencia, // Numero Secuencial  
                    dto.getOidCliente(), // Oid Cliente      
                    oidMensaje, // Oid Mensaje 
                    dto.getModuloOrigen() // modulo origen 
                );
            UtilidadesLog.debug("scs 4");

            // pais: no existe en la entidad
            //local.setModulo(dto.getModuloOrigen()); 
            //Si viene S le mando 1, si viene N le mando 0
            
            if (	(dto.getListaConsultoras() == null) || 
					(dto.getListaConsultoras().equals("")) || 
					(dto.getListaConsultoras().equals(ConstantesMSG.NO)) || 
					(dto.getListaConsultoras().equals("0"))  ) {
                    local.setEsConsultora(new Long(0));
            } else {
                 local.setEsConsultora(new Long(1));
				}

            local.setDatoVariable1(dto.getDatoVariable1());
            local.setDatoVariable2(dto.getDatoVariable2());
            local.setDatoVariable3(dto.getDatoVariable3());
            local.setDatoVariable4(dto.getDatoVariable4());
            local.setDatoVariable5(dto.getDatoVariable5());
            local.setDatoVariable6(dto.getDatoVariable6());
            local.setDatoVariable7(dto.getDatoVariable7());
            local.setDatoVariable8(dto.getDatoVariable8());
            local.setDatoVariable9(dto.getDatoVariable9());
            local.setDatoVariable10(dto.getDatoVariable10());
            local.setDatoVariable11(dto.getDatoVariable11());
            local.setDatoVariable12(dto.getDatoVariable12());
            local.setDatoVariable13(dto.getDatoVariable13());
            local.setDatoVariable14(dto.getDatoVariable14());
            local.setDatoVariable15(dto.getDatoVariable15());
            local.setDatoVariable16(dto.getDatoVariable16());
            local.setDatoVariable17(dto.getDatoVariable17());
            local.setDatoVariable18(dto.getDatoVariable18());
            local.setDatoVariable19(dto.getDatoVariable19());
            local.setDatoVariable20(dto.getDatoVariable20());

            // Genera los datos:
            //local.setNumeroSecuencial( 
            //new Long(obtenerNumeroSecuencial(dto.getOidMensaje(), dto.getOidCliente(), dto.getOidPais()).longValue()+1));
            local.setActivo(new Long(1));

            //            local.setEstaImpreso(null);
            local.setFechaGrabacion(new java.sql.Timestamp(System.currentTimeMillis()));

            dtoSalida.setNumeroSecuencial(local.getNumeroSecuencial());

            dtoSalida.setFechaGrabacion(local.getFechaGrabacion());
            dtoSalida.setOid(local.getOid());

            UtilidadesLog.info("MONGestionMensajesBean.insertaDatosMensaje(DTOBuzonMensajes dto): Salida");

            return dtoSalida;*/
        } catch (NoResultException e) {
            UtilidadesLog.debug(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception e){
            UtilidadesLog.debug(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    private String ajustarVariable(String dato) {
        String retorno = "''";
        if (dato != null && dato.length() > 100 ) {
            retorno = dato.substring(0, 100).replaceAll("'","''");
            retorno = "'" + retorno + "'";
        } else if (dato!=null){
            retorno = dato.replaceAll("'","''");
            retorno = "'"+retorno+"'";
        }
        return retorno;
    }

    /**    
     *@Author: pperez 
     *@Fecha:  19/10/2006
     *@throws: MareException
     *@return: boolean
     *@param: DTOBuzonMensajes dto
     *@Observaciones: CAMBIO MSG-002
    */ 
    
    private boolean validarDestinatario(DTOBuzonMensajes dto) throws MareException {
        /*Descripción: Si el tipo de destinatario es por Unida Administrativa o por Tipo de Cliente, 
        se valida si el cliente destinatario cumple con lo requerido. */
        UtilidadesLog.info("MONGestionMensajesBean.validarDestinatario(DTOBuzonMensajes dto): Entrada");
        MONImpresionMensajesHome monImpresHM = null;
        MONImpresionMensajes monImpres = null;
        boolean guardarMensaje = true;

        try  {

            DTODestinatarioMensaje[] dtoDest =  new DAOMSG().obtenerTiposDestinatariosMensaje(dto.getOidMensaje());
            
            if (dtoDest != null)  {
                int cant = dtoDest.length;
                
                monImpresHM =this.getMONImpresionMensajesHome();
                monImpres = monImpresHM.create();            
            
                for (int i=0; i<cant; i++)  {
                    if (dtoDest[i].getOidTipoDestinatario().equals(ConstantesMSG.OID_UNIDAD_ADMINISTRATIVA) )  {
                        guardarMensaje = monImpres.validarDestinatarioUA(dto);
                    } else if (dtoDest[i].getOidTipoDestinatario().equals(ConstantesMSG.OID_CLASIFICACION_CLIENTE) )  {
                        guardarMensaje = monImpres.validarDestinatarioTipoCliente(dto);
                    }
                    
                    if (!guardarMensaje)  {
                         break;   
                    }
                }
            }
            
        
        } catch (NamingException ne)  {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce)  {
            UtilidadesLog.error(ce);
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e){ 
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONGestionMensajesBean.validarDestinatario(DTOBuzonMensajes dto): Salida");
        return guardarMensaje;
    }    
    
    private void validarDestinatarios(DTOBuzonMensajes[] dto) throws MareException {
        /*Descripción: Si el tipo de destinatario es por Unida Administrativa o por Tipo de Cliente, 
        se valida si el cliente destinatario cumple con lo requerido. */
        UtilidadesLog.info("MONGestionMensajesBean.validarDestinatario(DTOBuzonMensajes dto): Entrada");
        MONImpresionMensajesHome monImpresHM = null;
        MONImpresionMensajes monImpres = null;
        boolean guardarMensaje = true;

        try  {

            DTODestinatarioMensaje[] dtoDest =  new DAOMSG().obtenerTiposDestinatariosMensaje(dto);            
            if (dtoDest != null)  {
                int cant = dto.length;
                
                monImpresHM =this.getMONImpresionMensajesHome();
                monImpres = monImpresHM.create();            
            
                for (int i=0; i<cant; i++)  {
                    guardarMensaje = true;
                    for (int j=0; j<dtoDest.length; j++)  {
                        if (dto[i].getOidMensaje().longValue() == dtoDest[j].getOidMensaje().longValue()){
                            if (dtoDest[j].getOidTipoDestinatario().equals(ConstantesMSG.OID_UNIDAD_ADMINISTRATIVA) )  {
                                guardarMensaje = monImpres.validarDestinatarioUA(dto[i]);
                            } else if (dtoDest[j].getOidTipoDestinatario().equals(ConstantesMSG.OID_CLASIFICACION_CLIENTE) )  {
                                guardarMensaje = monImpres.validarDestinatarioTipoCliente(dto[i]);
                            }
                            if (!guardarMensaje)  {
                                break;   
                            }                            
                        }
                    }
                    if (!guardarMensaje){
                        // se marca el mensaje como no valido para luego no grabarlo.
                        dto[i].setOidMensaje(null);
                    }
                }
            }
        } catch (NamingException ne)  {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce)  {
            UtilidadesLog.error(ce);
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e){ 
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONGestionMensajesBean.validarDestinatario(DTOBuzonMensajes dto): Salida");
    }  
    
    
    /**    
    *@Author: pperez 
    *@Fecha:  20/10/2006
    *@throws: NamingException
    *@return: MONImpresionMensajesHome
    *@param: 
    *@Observaciones: CAMBIO MSG-002
    */ 
    private MONImpresionMensajesHome getMONImpresionMensajesHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONImpresionMensajesHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONImpresionMensajes"), MONImpresionMensajesHome.class);
    }

    public DTOBuzonMensajes[] insertarDatosMensajesBatch(DTOBuzonMensajes[] dto) throws MareException{
        UtilidadesLog.info("MONGestionMensajesBean.insertarDatosMensajesBatch(DTOBuzonMensajes dto): Entrada");
        UtilidadesLog.debug("  dto.length: "+ dto.length );
        try {
            if (dto.length>0){
                Long pais = dto[0].getOidPais();
                ArrayList mensajesSinOid = new ArrayList();
                for (int i = 0 ; i < dto.length ; i ++){
                    if (dto[i].getOidMensaje() == null){
                        mensajesSinOid.add(dto[i]);
                    }
                }               
                if (mensajesSinOid.size()>0){
                    completarOidMensaje(mensajesSinOid, pais);
                }
                validarDestinatarios(dto);
                dto =  getMONGestionMensajesLocal().grabarBuzon(dto);
                return dto;
            }
            return dto;
        } catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOBuzonMensajes[] grabarBuzon(DTOBuzonMensajes[] dto) throws MareException{
        try{
            StringBuffer sb = new StringBuffer();
            
            ArrayList oids = new ArrayList();
            for (int i = 0 ; i< dto.length; i++){
                // si el mensaje no posee oid, esta marcado como no valido por lo cual no se graba.
                if (dto[i].getOidMensaje()!=null){
                    Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_BUME_SEQ");
                    dto[i].setOid(oid);
                    dto[i].setFechaGrabacion(new java.sql.Timestamp(System.currentTimeMillis()));
                    oids.add(oid);
                    sb.append(generaInsertBuzonMensaje(dto[i], oid));
                }
            }
            if (sb.toString().trim().length()>0){
                BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb.toString());
                RecordSet r = buscarBuzonMensajesInsertados(oids);
                for (int i = 0 ; i< r.getRowCount(); i++){
                    for (int j = 0 ; j< dto.length; j++){
                        // si el mensaje no posee oid, esta marcado como no valido por lo cual no se graba.
                        if (dto[j].getOidMensaje()!=null) {
                            if (r.getValueAt(i,0).toString().equals(dto[j].getOid().toString())){
                                //  Modificado por HRCS - Fecha 05/07/2007 - IncidenciaSicc20070287
                                if ( r.getValueAt(i,1) instanceof Long )    {
                                    dto[j].setNumeroSecuencial((Long)r.getValueAt(i,1));
                                } 
                                else if ( r.getValueAt(i,1) instanceof String )    {
                                    dto[j].setNumeroSecuencial( new Long(r.getValueAt(i,1).toString()) );
                                }
                                else  {
                                    dto[j].setNumeroSecuencial(bigDecimalToLong(r.getValueAt(i,1)));
                                }
                                break;
                            }
                        }
                    }
                }
            }
            return dto;
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
    }
    
    private StringBuffer generaInsertBuzonMensaje(DTOBuzonMensajes dto, Long oid){
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO msg_buzon_mensa ");
        sb.append(" (oid_buzo_mens, clie_oid_clie, mens_oid_mens, modu_oid_modu_orig, ");
        sb.append(" peri_oid_peri, val_nom1_clie, val_nom2_clie, val_ape1_clie, ");
        sb.append(" val_ape2_clie, val_apel_casa_clie, ");
        sb.append(" num_secu, ");
        sb.append(" dato_vari_01, dato_vari_02, dato_vari_03, dato_vari_04, ");
        sb.append(" dato_vari_05, dato_vari_06, dato_vari_07, dato_vari_08, ");
        sb.append(" dato_vari_09, dato_vari_10, dato_vari_11, dato_vari_12, ");
        sb.append(" dato_vari_13, dato_vari_14, dato_vari_15, dato_vari_16, ");
        sb.append(" dato_vari_17, dato_vari_18, dato_vari_19, dato_vari_20, ");
        sb.append(" num_lote_impr, fec_grab, fec_impr, ind_list_cons, ind_esta_mens, ");
        sb.append(" ind_acti ");
        sb.append(" ) ");
        sb.append(" VALUES ("+oid);
        sb.append(" , "+dto.getOidCliente());
        sb.append(" , "+dto.getOidMensaje());
        sb.append(" , "+dto.getModuloOrigen());
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , NULL");
        sb.append(" , (MSG_BUM2_SEQ.NEXTVAL + 1) ");
        sb.append(" , "+ajustarVariable(dto.getDatoVariable1()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable2()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable3()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable4()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable5()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable6()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable7()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable8()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable9()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable10()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable11()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable12()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable13()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable14()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable15()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable16()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable17()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable18()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable19()));
        sb.append(" , "+ajustarVariable(dto.getDatoVariable20()));
        sb.append(" , "+dto.getNumeroLoteImpresion());
        sb.append(" , sysdate");
        sb.append(" , NULL");
        if (	(dto.getListaConsultoras() == null) || 
					(dto.getListaConsultoras().equals("")) || 
					(dto.getListaConsultoras().equals(ConstantesMSG.NO)) || 
					(dto.getListaConsultoras().equals("0"))  ) {
            sb.append(" , "+new Long(0));
        } else {
            sb.append(" , "+new Long(1));
        }
        sb.append(" , NULL");
        sb.append(" , "+new Long(1));
        sb.append(" );");
        return sb;
    }
    
    private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
    
    /**
    * Mediante el codigo de mensajes obtiene el oid correspondiente.
    * @mejora Se utiliza un HashSet para no repetir codigos en la query de busqueda de oids. SiCC 20070287.
    * @autor gdmarzi
    */
    private void completarOidMensaje (ArrayList array, Long pais) throws MareException{
        HashSet codigos = new HashSet();
        DTOBuzonMensajes dtoB;
        try{
            // obtenemos los distintos codigos de mensajes
            for (int i = 0 ; i < array.size() ; i++){
                codigos.add("'" + ((DTOBuzonMensajes)array.get(i)).getCodigoMensaje() + "'");
            }
            StringBuffer sb = new StringBuffer();
            sb.append(" SELECT oid_mens, cod_mens ");
            sb.append(" FROM msg_mensa ");
            sb.append(" WHERE pais_oid_pais = "+pais);
            sb.append(" AND cod_mens IN " + codigos.toString().replace('[','(').replace(']',')') );
            RecordSet r = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
            
            for (int i = 0 ; i < array.size() ; i++){
                dtoB = (DTOBuzonMensajes)array.get(i);
                for (int j = 0 ; j < r.getRowCount() ; j++){
                    if (dtoB.getCodigoMensaje().equals(r.getValueAt(j,1).toString())){
                        dtoB.setOidMensaje(bigDecimalToLong(r.getValueAt(j,0)));
                        break;
                    }
                }
            }
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
    }
    
    private RecordSet buscarBuzonMensajesInsertados (ArrayList array) throws MareException{
        try{
            if (array.size()<1000)   {
                StringBuffer sb = new StringBuffer();
                sb.append(" select oid_buzo_mens, num_secu from msg_buzon_mensa where oid_buzo_mens in ( ");
                for (int i = 0 ; i < array.size() ; i++){
                    if (i == (array.size()-1)){
                        sb.append(" '"+(Long)array.get(i)+"' ");
                    }else{
                        sb.append(" '"+(Long)array.get(i)+"', ");
                    }
                }
                sb.append(" ) ");
                return BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
            }
            else    {
                //  Agregado por HRCS - Fecha 04/07/2007 - Incidencia Sicc20070287
                //  Partimos la lista, en sublistas de 900 como maximo
                int totalGrupos = (array.size()/900) + 1;
                RecordSet resultado = new RecordSet();
                RecordSet temporal;
                UtilidadesLog.warn(">>> Total de grupos: " + totalGrupos );
                UtilidadesLog.warn(">>> Numero de registros a dividir: " + array.size() );
                int flag = 0;
                for(int k = 0; k<totalGrupos; k++)   {
                    StringBuffer sb = new StringBuffer();
                    sb.append(" select oid_buzo_mens, num_secu from msg_buzon_mensa ");
    
                    HashSet codigosOid = new HashSet();
                    int i = flag;
                    //UtilidadesLog.warn(">>> Se inicia el armado de la lista, desde la posicion: " + i );
                    while( i<array.size())  {
                        codigosOid.add( (Long)array.get(i) );
                        if ( i>=900 && (i%900 == 0)) {
                            flag = i+1;
                            //UtilidadesLog.warn(">>> Terminando el grupo " + k + " con i: " + i + " y flag: " + flag );
                            break;
                        }
                        i++;
                    }
                    sb.append(" where oid_buzo_mens in " + codigosOid.toString().replace('[','(').replace(']',')') );
                    //UtilidadesLog.warn(">>> Query en buscarBuzonMensajesInsertados: " + sb );
                    temporal = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
                    //UtilidadesLog.warn(">>> RecordSet temporal recuperado: " + temporal );
                    if (k==0)   {
                        resultado = RecordSet.clone(temporal);
                    }
                    else    {
                        for(int j=0; j<temporal.getRowCount(); j++)   {
                            java.util.Vector nuevoReg = new java.util.Vector();
                            nuevoReg.add( (BigDecimal)temporal.getRow(j).get(0) );
                            nuevoReg.add( (BigDecimal)temporal.getRow(j).get(1) );
                            resultado.addRow( nuevoReg );
                        }
                    }
                    //UtilidadesLog.warn(">>> Total de registros por el momento: " + resultado.getRowCount() );
                }
                UtilidadesLog.warn(">>> Total de registros: " + resultado.getRowCount() );
                UtilidadesLog.warn(">>> Todos los registros: " + resultado );
                return resultado;
            }
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
    }
    
    
}
