package es.indra.sicc.logicanegocio.msg;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.cra.DTOID;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTODestinatario;
import es.indra.sicc.dtos.msg.DTOMensaje;
import es.indra.sicc.dtos.msg.DTOMensajeCliente;
import es.indra.sicc.dtos.msg.DTOMensajeCodigoVenta;
import es.indra.sicc.dtos.msg.DTOMensajeMarca;
import es.indra.sicc.dtos.msg.DTOMensajePrograma;
import es.indra.sicc.dtos.msg.DTOMensajeTipoCliente;
import es.indra.sicc.dtos.msg.DTOMensajeUnidadAdministrativa;
import es.indra.sicc.entidades.msg.MensajeCodigoVentaLocal;
import es.indra.sicc.entidades.msg.MensajeCodigoVentaLocalHome;
import es.indra.sicc.entidades.msg.MensajeMarcaLocal;
import es.indra.sicc.entidades.msg.MensajeMarcaLocalHome;
import es.indra.sicc.entidades.msg.MensajeTipoClienteLocal;
import es.indra.sicc.entidades.msg.MensajeTipoClienteLocalHome;
import es.indra.sicc.entidades.msg.MensajeUnidadAdministrativaLocal;
import es.indra.sicc.entidades.msg.MensajeUnidadAdministrativaLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocal;

//import es.indra.sicc.entidades.msg.MensajeTipoDestinatarioLocal;
//import es.indra.sicc.entidades.msg.MensajeTipoDestinatarioLocalHome;
//import es.indra.sicc.entidades.msg.MensajeDestinatarioLocalHome;
//import es.indra.sicc.entidades.msg.MensajeDestinatarioLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.entidades.msg.MensajesTipoAsignacionLocal;
import es.indra.sicc.entidades.msg.MensajesTipoAsignacionLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

//import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
//import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Vector;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

public class MONMensajesBean
        implements SessionBean {
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
        this.ctx = ctx;
    }

    public DTOSalida obtenerTiposMensaje(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.obtenerTiposMensaje(DTOBelcorp DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();
        DTOSalida dts = new DTOSalida();

        try {
            if (DTOE != null) {
                dts.setResultado(dmsg.obtenerTiposMensaje(DTOE));
            } else {
                dts.setResultado(null);
            }

            UtilidadesLog.info("MONMensajesBean.obtenerTiposMensaje(DTOBelcorp DTOE): Salida");

            return dts;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS + "(obtenerTiposMensaje)"));
        }
    }

    public DTOSalida obtenerTiposGeneracionDatos(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.obtenerTiposGeneracionDatos(DTOBelcorp DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();
        DTOSalida dts = new DTOSalida();

        try {
            if (DTOE != null) {
                dts.setResultado(dmsg.obtenerTiposGeneracionDatos(DTOE));
            } else {
                dts.setResultado(null);
            }

            UtilidadesLog.info("MONMensajesBean.obtenerTiposGeneracionDatos(DTOBelcorp DTOE): Salida");

            return dts;
        } catch (Exception e) {
            throw new MareException(e,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS + "(obtenerTiposGeneracionDatos)"));
        }
    }

    public DTOSalida obtenerTiposPermanencia(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.obtenerTiposPermanencia(DTOBelcorp DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();
        DTOSalida dts = new DTOSalida();

        try {
            dts.setResultado(dmsg.obtenerTiposPermanencia());

            UtilidadesLog.info("MONMensajesBean.obtenerTiposPermanencia(DTOBelcorp DTOE): Salida");

            return dts;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS + "(obtenerTiposPermanencia)"));
        }
    }

    public DTOSalida obtenerTiposDestinatario(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.obtenerTiposDestinatario(DTOBelcorp DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();
        DTOSalida dts = new DTOSalida();

        try {
            if (DTOE != null) {
                dts.setResultado(dmsg.obtenerTiposDestinatario(DTOE));
            } else {
                dts.setResultado(null);
            }

            UtilidadesLog.info("MONMensajesBean.obtenerTiposDestinatario(DTOBelcorp DTOE): Salida");

            return dts;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS + "(obtenerTiposDestinatario)"));
        }
    }

    public DTOBoolean comprobarDestinatariosExcluyentes(DTOOIDs DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.comprobarDestinatariosExcluyentes(DTOOIDs DTOE): Entrada");
            
        int nExcluyentes;
        DTOBoolean lResp = new DTOBoolean();

        //    try {
        //    
        //      //recorro rescatando c/oid
        //      nExcluyentes = 0;
        //      TipoDestinatarioLocalHome tDLH = getTipoDestinatarioLocalHome();
        //      TipoDestinatarioLocal tDL;
        //
        //      if ((DTOE != null) && (DTOE.getOids() != null)) {
        //
        //        if (DTOE.getOids() != null) {
        //      
        //          Long oidsA[] = DTOE.getOids();
        //        
        //          for (int i = 0; i < oidsA.length; i++) {
        //
        //             try {
        //                tDL = tDLH.findByPrimaryKey(oidsA[i]);
        //              
        //                if (tDL.getIndicadorExcluyente() != null) { 
        //                 if (tDL.getIndicadorExcluyente().booleanValue())
        //                   nExcluyentes++;
        //                }              
        //             }catch(FinderException e){
        //               //nothing          
        //             }
        //          }
        //        }
        //      }
        //      tDL = null;
        //
        //      if (DTOE != null && DTOE.getOids().length > 1 && nExcluyentes > 0 )
        //        lResp.setValor(false);
        //      else  
        //        lResp.setValor(true);
        //
        //      return lResp;
        //      
        //    }catch(NamingException e) {
        //      e.printStackTrace();
        //      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        //    }
        
        UtilidadesLog.info("MONMensajesBean.comprobarDestinatariosExcluyentes(DTOOIDs DTOE): Salida");
        
        return null;
    }

    public DTOOID guardarMensaje(DTOMensaje DTOE) throws MareException {
    
        UtilidadesLog.info("MONMensajesBean.guardarMensaje(DTOMensaje DTOE): Entrada");
    
        /*
        Crea un nuevo mensaje con la siguiente información:

        - mensaje.bloque = DTOE.bloque
        - mensaje.oidTipoPermanencia = DTOE.oidPermanencia
        - mensaje.permanenciaDesde = DTOE.permanenciaDesde
        - mensaje.permanenciaHasta = DTOE.permanenciaHasta



        Devuelve un DTOOID con:
        - oid = mensaje.oid
        */
         UtilidadesLog.debug("el dto es " + DTOE);
         
        //sapaza -- PER-SiCC-2010-0450 -- 14/07/2010
        //Realizamos la validacion del Campo Texto Fijo y datos Variables    
         DAOMSG dmsg = new DAOMSG();
         int totalRegistros = dmsg.obtenerNumeroRegistrosConError(DTOE.getTexto());
         if(totalRegistros > 0) {
            throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0027));
         }
        
        //validacion de estructura del xml
         String textoXml = DTOE.getTexto();
         //validaciones de variables validasa y no validas
         String grupo =getGrupoMensaje(dmsg,DTOE);
        UtilidadesLog.info("grupo " +grupo) ;
        //tanto para grupo 1 y 2
        
        validarVariablesNoValidas(dmsg, textoXml);                 
        
        if("G1".equals(grupo)) //solo para G1
           validarVariablesValidas(dmsg, textoXml);
        else{
            
            String mensajeError= validaXml(textoXml);
            if(mensajeError != null && !("".equals(mensajeError))){        
                               ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), 
                                                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, 
                                                               "", 
                                                               ErroresDeNegocio.MSG_0030));

                                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                                ex.addParameter(mensajeError);
                                throw ex;                  
            }
        }
            
                        
        DTOOID dtoResp = new DTOOID();
        MensajesLocal mL = null;

        try {
            MensajesLocalHome mLH = new MensajesLocalHome();
            //mLH.parametrosAuditoria(DTOE);

            String texto = deshacerFormateoMetacaracter(DTOE.getTexto());

            mL = mLH.create(DTOE.getCodigo().toString(), DTOE.getOidPais(), DTOE.getDescripcion(), texto, DTOE.getOidPeriodoDesde(),
                            DTOE.getOidPeriodoHasta(), DTOE.getOidModulo(), DTOE.getOidTipoMensaje(), DTOE.getOidPermanencia());

            if (DTOE.getPermanenciaDesde() != null) {
                mL.setPermanenciaDesde(new Timestamp(DTOE.getPermanenciaDesde().getTime()));
            }

            if (DTOE.getPermanenciaHasta() != null) {
                mL.setPermanenciaHasta(new Timestamp(DTOE.getPermanenciaHasta().getTime()));
            }

            mL.setBloqueGrupoPertenece(DTOE.getBloque());

            String periodoDesde = null;
            String periodoHasta = null;

            if (DTOE.getOidPeriodoDesde() != null) {
                PeriodoCorporativoLocalHome pcLHome = new PeriodoCorporativoLocalHome();
                PeriodoCorporativoLocal pcLocal = pcLHome.findByPrimaryKey(DTOE.getOidPeriodoDesde());
                periodoDesde = pcLocal.getCodigoPeriodo();
            }

            if (DTOE.getOidPeriodoHasta() != null) {
                PeriodoCorporativoLocalHome pcLHome = new PeriodoCorporativoLocalHome();
                PeriodoCorporativoLocal pcLocal = pcLHome.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                periodoHasta = pcLocal.getCodigoPeriodo();
            }

            if ((DTOE.getOidPeriodoDesde() != null) && (DTOE.getOidPeriodoHasta() != null)) {
                if (periodoDesde.compareTo(periodoHasta) <= 0) {
                    mL.setPeriodoDesde(DTOE.getOidPeriodoDesde());
                    mL.setPeriodoHasta(DTOE.getOidPeriodoHasta());
                } else {
                    UtilidadesLog.debug("devolviop la excepcion de que los periodods estan mal");
                    
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG + ErroresDeNegocio.MSG_0018));
                }
            }
            
            if ((DTOE.getExclusionTipologia() != null) && DTOE.getExclusionTipologia().booleanValue()) {
                mL.setExclusionTipologia(new Long(1));  
            } else {
                mL.setExclusionTipologia(new Long(0));              
            }
            
            dtoResp.setOid(mL.getOid());
            mLH.merge(mL);
            UtilidadesLog.info("MONMensajesBean.guardarMensaje(DTOMensaje DTOE): Salida");

            return dtoResp;
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } /*catch (MareException me) {
            throw me;
        } /*catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }*/
    }

    private void validarVariablesValidas(DAOMSG dmsg, 
                                         String textoXml) throws ExcepcionParametrizada, 
                                                                 MareException {
        //obteniendo los parametros validos
        List listVariablesValidas = dmsg.getListVariablesValidas();                              
        Iterator it = listVariablesValidas.iterator();
        while(it.hasNext()){
            String variable = (String)it.next();
            textoXml=textoXml.replaceAll(variable," ");//X CADENA VACIA            
        }
        
        UtilidadesLog.debug("XML SIN VARIABLES " + textoXml);
        String mensajeError= validaXml(textoXml);
        if(mensajeError != null && !("".equals(mensajeError))){        
                           ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), 
                                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, 
                                                           "", 
                                                           ErroresDeNegocio.MSG_0028));

                            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                            ex.addParameter(mensajeError);
                            throw ex;                         
        }
    }

    private void validarVariablesNoValidas(DAOMSG dmsg, 
                                           String textoXml) throws ExcepcionParametrizada, 
                                                                   MareException {
        //obteniendo los parametros no validos
        List listVariablesNoValidas = dmsg.getListVariablesNoValidas();
        Iterator it = listVariablesNoValidas.iterator();
        while(it.hasNext()){
           String variable = (String)it.next();
           int index=textoXml.indexOf(variable);//
           if(index != -1){
               UtilidadesLog.debug(">> Variable error " + variable);
               ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), 
                                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, 
                                               "", 
                                               ErroresDeNegocio.MSG_0029));
                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                ex.addParameter(variable);
               UtilidadesLog.debug(variable);
                throw ex;                         
           }
           
        }
    }

    public void guardarDestinatarioMensaje(DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.guardarDestinatarioMensaje(DTODestinatario DTOE): Entrada");
            
        try {
            // UNIDAD ADMINISTRATIVA
            if (DTOE.getUnidadAdministrativa() != null) {
                MensajeUnidadAdministrativaLocalHome mUALH = new MensajeUnidadAdministrativaLocalHome();
                //mUALH.parametrosAuditoria(DTOE);

                MensajeUnidadAdministrativaLocal mUAL;

                Enumeration elementosUnidAdm = DTOE.getUnidadAdministrativa().elements();

                while (elementosUnidAdm.hasMoreElements()) {
                    DTOMensajeUnidadAdministrativa elemUnidAdm = (DTOMensajeUnidadAdministrativa) elementosUnidAdm.nextElement();
                    mUAL = mUALH.create(DTOE.getOidMensaje());
                    mUAL.setZorg_oid_regi(elemUnidAdm.getOidRegion());
                    mUAL.setZzon_oid_zona(elemUnidAdm.getOidZona());
                    mUAL.setZscc_oid_secc(elemUnidAdm.getOidSeccion());
                    mUAL.setTerr_oid_terr(elemUnidAdm.getOidTerritorio());
                    mUALH.merge(mUAL);
                }

                guardarTipoDestinatario(ConstantesMSG.OID_UNIDAD_ADMINISTRATIVA, DTOE.getOidMensaje());
            }

            // TIPO CLIENTE
            if (DTOE.getTipoCliente() != null) {
                MensajeTipoClienteLocalHome mTCLH = new MensajeTipoClienteLocalHome();
                //mTCLH.parametrosAuditoria(DTOE);

                MensajeTipoClienteLocal mTCL;

                Enumeration elementosTipoClte = DTOE.getTipoCliente().elements();

                while (elementosTipoClte.hasMoreElements()) {
                    DTOMensajeTipoCliente elemTipoClte = (DTOMensajeTipoCliente) elementosTipoClte.nextElement();
                    mTCL = mTCLH.create(DTOE.getOidMensaje(), elemTipoClte.getOidTipoCliente());
                    mTCL.setSbti_oid_subt_clie(elemTipoClte.getOidSubtipoCliente());
                    mTCL.setTccl_oid_tipo_clas(elemTipoClte.getOidTipoClasificacion());
                    mTCL.setClas_oid_clas(elemTipoClte.getOidClasificacion());
                    mTCLH.merge(mTCL);
                }

                guardarTipoDestinatario(ConstantesMSG.OID_CLASIFICACION_CLIENTE, DTOE.getOidMensaje());
            }

            // MARCA 
            if (DTOE.getMarca() != null) {
                MensajeMarcaLocalHome mMLH = new MensajeMarcaLocalHome();
                //mMLH.parametrosAuditoria(DTOE);

                MensajeMarcaLocal mML;
                Enumeration elementosMarca = DTOE.getMarca().elements();

                while (elementosMarca.hasMoreElements()) {
                    DTOMensajeMarca elemMarca = (DTOMensajeMarca) elementosMarca.nextElement();
                    mML = mMLH.create(elemMarca.getOidMarca(), DTOE.getOidMensaje());
                    mMLH.merge(mML);
                }

                guardarTipoDestinatario(ConstantesMSG.OID_MARCA, DTOE.getOidMensaje());
            }

            // CODIGO VENTA 
            if (DTOE.getCodigoVenta() != null) {
                MensajeCodigoVentaLocalHome mMCVLH = new MensajeCodigoVentaLocalHome();
                //mMCVLH.parametrosAuditoria(DTOE);

                MensajeCodigoVentaLocal mCVL;
                Enumeration elementosCodigoVenta = DTOE.getCodigoVenta().elements();

                while (elementosCodigoVenta.hasMoreElements()) {
                    DTOMensajeCodigoVenta elemCodigoVenta = (DTOMensajeCodigoVenta) elementosCodigoVenta.nextElement();
                    mCVL = mMCVLH.create(DTOE.getOidMensaje(), elemCodigoVenta.getCodigoVenta());
                    mMCVLH.merge(mCVL);
                }

                guardarTipoDestinatario(ConstantesMSG.OID_CODIGO_VENTA, DTOE.getOidMensaje());
            }

            // PEDIDO 
            //	if ((DTOE.getPedido() != null) && (DTOE.getPedido().booleanValue() == true))
            //	guardarTipoDestinatario(ConstantesMSG.OID_PEDIDO, DTOE.getOidMensaje());
            //			if (DTOE.get)  {
            //					
            //			}
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMensajesBean.guardarDestinatarioMensaje(DTODestinatario DTOE): Salida");
    }

    public DTOSalida buscarMensajes(DTOMensaje DTOE) throws MareException {
    
        UtilidadesLog.info("MONMensajesBean.buscarMensajes(DTOMensaje DTOE): Entrada");
    
        DAOMSG dmsg = new DAOMSG();
        DTOSalida dts = new DTOSalida();

        try {
            if (DTOE != null) {
                dts.setResultado(dmsg.buscarMensajes(DTOE));
            }

            UtilidadesLog.info("MONMensajesBean.buscarMensajes(DTOMensaje DTOE): Salida");

            return dts;
        } catch (Exception exception) {
            if (exception instanceof MareException) {
                throw (MareException) exception;
            } else {
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
    }

    public DTOMensaje obtenerMensaje(DTOOID DTOE) throws MareException {
        try {
        
            UtilidadesLog.info("MONMensajesBean.obtenerMensaje(DTOOID DTOE): Entrada");
        
            DTOMensaje dtoMsg = new DTOMensaje();

            MensajesLocalHome mLH = new MensajesLocalHome();
            MensajesLocal mL = mLH.findByPrimaryKey(DTOE.getOid());

            dtoMsg.setOidMensaje(mL.getOid());
            dtoMsg.setOidModulo(mL.getOidModulo());
            dtoMsg.setCodigo(mL.getCodMensaje());
            dtoMsg.setOidTipoMensaje(mL.getTipoMensaje());
            dtoMsg.setDescripcion(mL.getDescripcion());
            dtoMsg.setBloque(mL.getBloqueGrupoPertenece());
            dtoMsg.setOidPermanencia(mL.getTipoPermanencia());
            dtoMsg.setPermanenciaDesde(mL.getPermanenciaDesde());
            dtoMsg.setPermanenciaHasta(mL.getPermanenciaHasta());
            dtoMsg.setOidPeriodoDesde(mL.getPeriodoDesde());
            dtoMsg.setOidPeriodoHasta(mL.getPeriodoHasta());

            if (mL.getPeriodoDesde() != null) {
                PeriodoCorporativoLocalHome pcLHome = new PeriodoCorporativoLocalHome();
                PeriodoCorporativoLocal pcLocal = pcLHome.findByPrimaryKey(mL.getPeriodoDesde());
                dtoMsg.setOidTipoPeriodo(pcLocal.getOidTipoPeriodo());
            }

            dtoMsg.setTexto(mL.getTexto());
            dtoMsg.setTiposDestinatario(obtenerTiposDestinatarioMensaje(mL.getOid()));
            
            if ((mL.getExclusionTipologia() != null) && mL.getExclusionTipologia().equals(new Long(1))) {
                dtoMsg.setExclusionTipologia(Boolean.TRUE);
            } else {
                dtoMsg.setExclusionTipologia(Boolean.FALSE);
            }

            UtilidadesLog.info("MONMensajesBean.obtenerMensaje(DTOOID DTOE): Salida");
            
            return dtoMsg;
        } catch (NoResultException e) {
            UtilidadesLog.debug(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch (PersistenceException e) {
                       UtilidadesLog.error(e);
                       ctx.setRollbackOnly();
                       throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    public DTOBoolean comprobarMensajeCodigoVenta(DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.comprobarMensajeCodigoVenta(DTODestinatario DTOE): Entrada");
            
        DTOBoolean resu = new DTOBoolean();
        boolean correcto = true;

        try {
            MONMantenimientoMFHome monMantMFHome = getMONMantenimientoMFHome();
            MONMantenimientoMF monMantMF = monMantMFHome.create();

            Enumeration elementosCodigoVenta = DTOE.getCodigoVenta().elements();

            while (elementosCodigoVenta.hasMoreElements()) {
                DTOMensajeCodigoVenta elemCodigoVenta = (DTOMensajeCodigoVenta) elementosCodigoVenta.nextElement();

                if (monMantMF.buscarCodigoVenta(elemCodigoVenta.getCodigoVenta(), DTOE.getOidPais()).booleanValue() == false) {
                    correcto = false;

                    break;
                }
            }

            resu.setValor(correcto);

            UtilidadesLog.info("MONMensajesBean.comprobarMensajeCodigoVenta(DTODestinatario DTOE): Salida");

            return resu;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    public void guardarTipoDestinatario(Long tipo, Long mensaje)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.guardarTipoDestinatario(Long tipo, Long mensaje): Entrada");
            
        try {
            MensajesTipoAsignacionLocalHome mtaLHome = new MensajesTipoAsignacionLocalHome();
            MensajesTipoAsignacionLocal mtaLocal = mtaLHome.create(mensaje, tipo);
            mtaLocal = null;
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMensajesBean.guardarTipoDestinatario(Long tipo, Long mensaje): Salida");
    }

    public Vector obtenerTiposDestinatarioMensaje(Long oidMensaje)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.obtenerTiposDestinatarioMensaje(Long oidMensaje): Entrada");
            
        Vector listaDestinatarios = new Vector();

        try {
            if (oidMensaje != null) {
                MensajesTipoAsignacionLocalHome tadLHome = new MensajesTipoAsignacionLocalHome();

                Collection col = tadLHome.findByMensaje(oidMensaje);

                if (col != null) {
                    Iterator destinatarios = col.iterator();

                    while (destinatarios.hasNext()) {
                        MensajesTipoAsignacionLocal tdLocal = (MensajesTipoAsignacionLocal) destinatarios.next();

                        listaDestinatarios.add(tdLocal.getTide_oid_tipo_dest());
                    }
                }
            }

            UtilidadesLog.info("MONMensajesBean.obtenerTiposDestinatarioMensaje(Long oidMensaje): Salida");

            return listaDestinatarios;
        } catch (NoResultException e) {
            UtilidadesLog.debug(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    private Timestamp obtenerFechaSinHora(Date fecha) {
    
        UtilidadesLog.info("MONMensajesBean.obtenerFechaSinHora(Date fecha): Entrada");
    
        String sDate = null;
        String anio = null;
        String mes = null;
        String dia = null;

        GregorianCalendar gc = new GregorianCalendar();
        Timestamp tmstmp = null;

        if (fecha != null) {
            gc.setTime(fecha);
            anio = (new Integer(gc.get(GregorianCalendar.YEAR))).toString();

            if (gc.get(GregorianCalendar.MONTH) < 10) {
                mes = "0" + (new Integer(gc.get(GregorianCalendar.MONTH) + 1)).toString();
            } else {
                mes = (new Integer(gc.get(GregorianCalendar.MONTH) + 1)).toString();
            }

            if (gc.get(GregorianCalendar.DAY_OF_MONTH) < 10) {
                dia = "0" + (new Integer(gc.get(GregorianCalendar.DAY_OF_MONTH))).toString();
            } else {
                dia = (new Integer(gc.get(GregorianCalendar.DAY_OF_MONTH))).toString();
            }

            sDate = anio + "-" + mes + "-" + dia + " 00:00:00";

            tmstmp = Timestamp.valueOf(sDate);
        }

        UtilidadesLog.info("MONMensajesBean.obtenerFechaSinHora(Date fecha): Salida");

        return tmstmp;
    }

    public DTOOID modificarMensaje(DTOMensaje DTOE) throws MareException {
    
        UtilidadesLog.info("MONMensajesBean.modificarMensaje(DTOMensaje DTOE): Entrada");
    
        //sapaza -- PER-SiCC-2010-0450 -- 14/07/2010
        //Realizamos la validacion del Campo Texto Fijo y datos Variables    
         DAOMSG dmsg = new DAOMSG();
         int totalRegistros = dmsg.obtenerNumeroRegistrosConError(DTOE.getTexto());
         if(totalRegistros > 0) {
            throw new MareException(" ", 
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, "", ErroresDeNegocio.MSG_0027));
         }
    
        //validacion de estructura del xml
         String textoXml = DTOE.getTexto();
        //validaciones de variables validasa y no validas
        String grupo =getGrupoMensaje(dmsg,DTOE);
        UtilidadesLog.info("grupo " +grupo) ;
        //tanto para grupo 1 y 2
        
        validarVariablesNoValidas(dmsg, textoXml);
        
        if("G1".equals(grupo)) //solo para G1
          validarVariablesValidas(dmsg, textoXml);
        else{
            
            String mensajeError= validaXml(textoXml);
            if(mensajeError != null && !("".equals(mensajeError))){        
                               ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), 
                                                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MSG, 
                                                               "", 
                                                               ErroresDeNegocio.MSG_0030));

                                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                                ex.addParameter(mensajeError);
                                throw ex;                  
            }
        }

    
        DTOOID dtoResu = new DTOOID();

        try {
            MensajesLocalHome mLH = new MensajesLocalHome();
            //mLH.parametrosAuditoria(DTOE);

            String texto = deshacerFormateoMetacaracter(DTOE.getTexto());
            MensajesLocal mL = mLH.findByPrimaryKey(DTOE.getOidMensaje());
            mL.setOidModulo(DTOE.getOidModulo());
            mL.setTipoMensaje(DTOE.getOidTipoMensaje());
            mL.setDescripcion(DTOE.getDescripcion());
            mL.setBloqueGrupoPertenece(DTOE.getBloque());
            mL.setTipoPermanencia(DTOE.getOidPermanencia());
            mL.setPermanenciaDesde(obtenerFechaSinHora(DTOE.getPermanenciaDesde()));
            mL.setPermanenciaHasta(obtenerFechaSinHora(DTOE.getPermanenciaHasta()));
            mL.setTexto(texto);
            mL.setPeriodoDesde(DTOE.getOidPeriodoDesde());
            mL.setPeriodoHasta(DTOE.getOidPeriodoHasta());
            if ((DTOE.getExclusionTipologia() != null) && DTOE.getExclusionTipologia().booleanValue()) {
                mL.setExclusionTipologia(new Long(1));  
            } else {
                mL.setExclusionTipologia(new Long(0));              
            }

            dtoResu.setOid(mL.getOid());

            UtilidadesLog.info("MONMensajesBean.modificarMensaje(DTOMensaje DTOE): Salida");
            mLH.merge(mL);
            return dtoResu;
        } catch (NoResultException e) {
            UtilidadesLog.debug(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    public DTODestinatario obtenerDatosDestinatario(DTOOID DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.obtenerDatosDestinatario(DTOOID DTOE): Entrada");
            
        DTODestinatario dtoDest = new DTODestinatario();

        // UNIDAD ADMINISTRATIVA 
        dtoDest = generarMensajeUnidadAdministrativa(DTOE.getOid(), dtoDest);

        // TIPIFICACION CLIENTE
        dtoDest = generarMensajeTipoCliente(DTOE.getOid(), dtoDest);

        // MARCA
        dtoDest = generarMensajeMarca(DTOE.getOid(), dtoDest);

        // CODIGO VENTA 
        dtoDest = generarMensajeCodigoVenta(DTOE.getOid(), dtoDest);

        // PEDIDO 
        dtoDest = generarMensajePedido(DTOE.getOid(), dtoDest);

        UtilidadesLog.info("MONMensajesBean.obtenerDatosDestinatario(DTOOID DTOE): Salida");

        return dtoDest;
    }

    public DTODestinatario generarMensajeUnidadAdministrativa(Long oidMensaje, DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.generarMensajeUnidadAdministrativa(Long oidMensaje, DTODestinatario DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();

        Vector row = new Vector();
        Vector vUA = new Vector();

        RecordSet muad = dmsg.obtenerMensajeUnidadAdministrativa(oidMensaje);

        for (int i = 0; i < muad.getRowCount(); i++) {
            row = muad.getRow(i);
            vUA.add(crearDTOMensajeUnidadAdministrativa(row));
        }

        DTOE.setUnidadAdministrativa(vUA);

        UtilidadesLog.info("MONMensajesBean.generarMensajeUnidadAdministrativa(Long oidMensaje, DTODestinatario DTOE): Salida");

        return DTOE;
    }

    public DTOMensajeUnidadAdministrativa crearDTOMensajeUnidadAdministrativa(Vector fila)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeUnidadAdministrativa(Vector fila): Entrada");
            
        DTOMensajeUnidadAdministrativa dtoMUA = new DTOMensajeUnidadAdministrativa();
        
        UtilidadesLog.debug("   - SAP601: 1 ");
        dtoMUA.setOid((fila.get(0) != null) ? new Long(((BigDecimal) fila.get(0)).toString()) : null);
        
        UtilidadesLog.debug("   - SAP601: 2 ");
        dtoMUA.setOidRegion((fila.get(1) != null) ? new Long(((BigDecimal) fila.get(1)).toString()) : null);
        
        UtilidadesLog.debug("   - SAP601: 3 ");
        dtoMUA.setOidZona((fila.get(2) != null) ? new Long(((BigDecimal) fila.get(2)).toString()) : null);
        
        UtilidadesLog.debug("   - SAP601: 4 ");
        dtoMUA.setOidSeccion((fila.get(3) != null) ? new Long(((BigDecimal) fila.get(3)).toString()) : null);
        
        UtilidadesLog.debug("   - SAP601: 5 ");
        dtoMUA.setOidTerritorio((fila.get(4) != null) ? new Long(((BigDecimal) fila.get(4)).toString()) : null);
        
        UtilidadesLog.debug("   - SAP601: 6 ");
        dtoMUA.setDesRegion((fila.get(5) != null) ?fila.get(5).toString(): null);
        
        UtilidadesLog.debug("   - SAP601: 7 ");
        dtoMUA.setDesZona((fila.get(6) != null) ?fila.get(6).toString(): null);
        
        UtilidadesLog.debug("   - SAP601: 8 ");
        dtoMUA.setDesSeccion((fila.get(7) != null) ?fila.get(7).toString(): null);
        
        UtilidadesLog.debug("   - SAP601: 9 ");
        dtoMUA.setDesTerritorio((fila.get(8) != null) ?fila.get(8).toString(): null);

        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeUnidadAdministrativa(Vector fila): Salida");

        return dtoMUA;
    }

    public DTODestinatario generarMensajeTipoCliente(Long oidMensaje, DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.generarMensajeTipoCliente(Long oidMensaje, DTODestinatario DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();
        Vector row = new Vector();
        Vector vectTipocliente = new Vector();

        RecordSet tipoclientes = dmsg.obtenerMensajeTipoCliente(oidMensaje);

        for (int i = 0; i < tipoclientes.getRowCount(); i++) {
            row = tipoclientes.getRow(i);
            vectTipocliente.add(crearDTOMensajeTipoCliente(row));
        }

        DTOE.setTipoCliente(vectTipocliente);

        UtilidadesLog.info("MONMensajesBean.generarMensajeTipoCliente(Long oidMensaje, DTODestinatario DTOE): Salida");

        return DTOE;
    }

    public DTOMensajeTipoCliente crearDTOMensajeTipoCliente(Vector fila)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeTipoCliente(Vector fila): Entrada");
            
        DTOMensajeTipoCliente dtoMTC = new DTOMensajeTipoCliente();

        dtoMTC.setOid((fila.get(0) != null) ? new Long(((BigDecimal) fila.get(0)).toString()) : null);
        dtoMTC.setOidTipoCliente((fila.get(1) != null) ? new Long(((BigDecimal) fila.get(1)).toString()) : null);
        dtoMTC.setOidSubtipoCliente((fila.get(2) != null) ? new Long(((BigDecimal) fila.get(2)).toString()) : null);
        dtoMTC.setOidTipoClasificacion((fila.get(3) != null) ? new Long(((BigDecimal) fila.get(3)).toString()) : null);
        dtoMTC.setOidClasificacion((fila.get(4) != null) ? new Long(((BigDecimal) fila.get(4)).toString()) : null);

        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeTipoCliente(Vector fila): Salida");

        return dtoMTC;
    }

    public DTODestinatario generarMensajeMarca(Long oidMensaje, DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.generarMensajeMarca(Long oidMensaje, DTODestinatario DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();
        Vector row = new Vector();
        Vector msgmarca = new Vector();

        try {
            if (oidMensaje != null) {
                RecordSet msgmarcas = dmsg.obtenerMensajeMarca(oidMensaje);

                for (int i = 0; i < msgmarcas.getRowCount(); i++) {
                    row = msgmarcas.getRow(i);

                    Long pos0 = ((row.get(0) == null) ? null : new Long(((BigDecimal) row.get(0)).toString()));
                    Long pos1 = ((row.get(1) == null) ? null : new Long(((BigDecimal) row.get(1)).toString()));

                    DTOMensajeMarca dtoMM = crearDTOMensajeMarca(pos0, pos1);

                    msgmarca.add(dtoMM);
                }
            }

            DTOE.setMarca(msgmarca);

            UtilidadesLog.info("MONMensajesBean.generarMensajeMarca(Long oidMensaje, DTODestinatario DTOE): Salida");

            return DTOE;
        } catch (Exception exception) {
            if (exception instanceof MareException) {
                throw (MareException) exception;
            } else {
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
    }

    public DTOMensajeMarca crearDTOMensajeMarca(Long oid, Long marca)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeMarca(Long oid, Long marca): Entrada");
            
        DTOMensajeMarca dtoMM = new DTOMensajeMarca();

        if ((oid != null) && (marca != null)) {
            dtoMM.setOid(oid);
            dtoMM.setOidMarca(marca);
        }

        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeMarca(Long oid, Long marca): Salida");

        return dtoMM;
    }

    public DTODestinatario generarMensajeCodigoVenta(Long oidMensaje, DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.generarMensajeCodigoVenta(Long oidMensaje, DTODestinatario DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();
        Vector row = new Vector();

        DTOMensajeCodigoVenta[] msgcvta;
        msgcvta = null;

        Vector vC = new Vector();

        try {
            if (oidMensaje != null) {
                RecordSet msgcvtas = dmsg.obtenerMensajeCodigoVenta(oidMensaje);

                for (int i = 0; i < msgcvtas.getRowCount(); i++) {
                    row = msgcvtas.getRow(i);

                    Long colCero = ((row.get(0) == null) ? null : new Long(((BigDecimal) row.get(0)).toString()));
                    String colUno = ((row.get(1) == null) ? null : row.get(1).toString());

                    DTOMensajeCodigoVenta dtoMCV = crearDTOMensajeCodigoVenta(colCero, colUno);

                    vC.add(dtoMCV);
                }
            }

            DTOE.setCodigoVenta(vC);

            UtilidadesLog.info("MONMensajesBean.generarMensajeCodigoVenta(Long oidMensaje, DTODestinatario DTOE): Salida");

            return DTOE;
        } catch (Exception exception) {
            if (exception instanceof MareException) {
                throw (MareException) exception;
            } else {
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
    }

    public DTOMensajeCodigoVenta crearDTOMensajeCodigoVenta(Long oid, String codigo)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeCodigoVenta(Long oid, String codigo): Entrada");
            
        DTOMensajeCodigoVenta dtoMCV = new DTOMensajeCodigoVenta();

        if ((oid != null) && (codigo != null)) {
            dtoMCV.setOid(oid);
            dtoMCV.setCodigoVenta(codigo);
        }

        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeCodigoVenta(Long oid, String codigo): Salida");

        return dtoMCV;
    }

    public DTODestinatario generarMensajePedido(Long oidMensaje, DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.generarMensajePedido(Long oidMensaje, DTODestinatario DTOE): Entrada");
            
        try {
            if (oidMensaje != null) {
                MensajesTipoAsignacionLocalHome mTALH = new MensajesTipoAsignacionLocalHome();
                Collection mTAL = mTALH.findByTipo(oidMensaje, ConstantesMSG.OID_PEDIDO);

                if (mTAL != null) {
                    DTOE.setPedido(new Boolean(true));
                } else {
                    DTOE.setPedido(new Boolean(false));
                }
            }

            UtilidadesLog.info("MONMensajesBean.generarMensajePedido(Long oidMensaje, DTODestinatario DTOE): Salida");

            return DTOE;
        } catch (NoResultException e) {
            UtilidadesLog.debug(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        //return null; 
    }

    public DTODestinatario generarMensajePrograma(Long oidMensaje, DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.generarMensajePrograma(Long oidMensaje, DTODestinatario DTOE): Entrada");
            
        //    try { 
        //          MensajeTipoDestinatarioLocalHome tDPMLH = getMensajeTipoDestinatarioLocalHome();
        //          Collection tDPML = tDPMLH.findByTipo(oidMensaje, ConstantesMSG.OID_PEDIDO);
        //          
        //          if (oidMensaje != null) {
        //          
        //            if (tDPML != null) {
        //          
        //              MensajesLocalHome mLH = getMensajesLocalHome();
        //              MensajesLocal mL = mLH.findByPrimaryKey(oidMensaje);
        //
        //              DTOMensajePrograma dtoMP = new DTOMensajePrograma();
        //              dtoMP.setProgramaAsociado(mL.getProcesoAsociado());
        //              dtoMP.setProceso(mL.getProcesoALlamar());
        //
        //              DTOE.setProgramaAsociado(dtoMP);
        //
        //            }
        //          }
        
        UtilidadesLog.info("MONMensajesBean.generarMensajePrograma(Long oidMensaje, DTODestinatario DTOE): Salida");
        
        return DTOE;

        //    } catch(NamingException e) {
        //          ctx.setRollbackOnly();
        //          e.printStackTrace();
        //          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        //    }catch(FinderException e){
        //      e.printStackTrace();
        //      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        //    }          
    }

    public DTODestinatario generarMensajeCliente(Long oidMensaje, DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.generarMensajeCliente(Long oidMensaje, DTODestinatario DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();
        Vector row = new Vector();

        DTOMensajeCliente[] cliente;
        cliente = null;

        Vector vC = new Vector();
        RecordSet clientes = dmsg.obtenerMensajeCliente(oidMensaje);

        try {
            if (oidMensaje != null) {
                for (int i = 0; i < clientes.getRowCount(); i++) {
                    row = clientes.getRow(i);

                    Long pos0 = ((row.get(0) == null) ? null : new Long(((BigDecimal) row.get(0)).toString()));
                    Long pos1 = ((row.get(1) == null) ? null : new Long(((BigDecimal) row.get(1)).toString()));

                    DTOMensajeCliente dtoMC = crearDTOMensajeCliente(pos0, pos1);
                    vC.add(dtoMC);
                }
            }

            DTOE.setCliente(vC);

            UtilidadesLog.info("MONMensajesBean.generarMensajeCliente(Long oidMensaje, DTODestinatario DTOE): Salida");

            return DTOE;
        } catch (Exception exception) {
            if (exception instanceof MareException) {
                throw (MareException) exception;
            } else {
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
    }

    public DTOMensajeCliente crearDTOMensajeCliente(Long oid, Long cliente)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeCliente(Long oid, Long cliente): Entrada");
            
        DTOMensajeCliente dtoMC = new DTOMensajeCliente();

        if ((oid != null) && (cliente != null)) {
            dtoMC.setOid(oid);
            dtoMC.setOidCliente(cliente);
        }

        UtilidadesLog.info("MONMensajesBean.crearDTOMensajeCliente(Long oid, Long cliente): Salida");

        return dtoMC;
    }

    public void modificarDestinatarioMensaje(DTODestinatario DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.modificarDestinatarioMensaje(DTODestinatario DTOE): Entrada");
            
        if (DTOE != null) {
            //elimin. los destinatarios actuales
            eliminarDestinatarioMensaje(DTOE.getOidMensaje());

            // se guarda la nueva información de los destinatarios
            guardarDestinatarioMensaje(DTOE);
        }
        
        UtilidadesLog.info("MONMensajesBean.modificarDestinatarioMensaje(DTODestinatario DTOE): Salida");
    }

    public void eliminarDestinatarioMensaje(Long oidMensaje)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.eliminarDestinatarioMensaje(Long oidMensaje): Entrada");
            
        try {
            if (oidMensaje != null) {
                // UNIDAD ADMINISTRATIVA
                MensajeUnidadAdministrativaLocalHome mUALH = new MensajeUnidadAdministrativaLocalHome();
                Collection collMUA = mUALH.findByMensaje(oidMensaje);

                Iterator itcollMUA = collMUA.iterator();

                while (itcollMUA.hasNext()) {
                    MensajeUnidadAdministrativaLocal mUAL = (MensajeUnidadAdministrativaLocal) itcollMUA.next();
                    mUALH.remove(mUAL);
                }

                // TIPIFICACION CLIENTE
                MensajeTipoClienteLocalHome mMTCLH = new MensajeTipoClienteLocalHome();
                Collection collMTC = mMTCLH.findByMensaje(oidMensaje);

                Iterator itcollMTC = collMTC.iterator();

                while (itcollMTC.hasNext()) {
                    MensajeTipoClienteLocal mMTCL = (MensajeTipoClienteLocal) itcollMTC.next();
                    mMTCLH.remove(mMTCL);
                }

                // MARCA
                MensajeMarcaLocalHome mMMLH = new MensajeMarcaLocalHome();
                Collection collMM = mMMLH.findByMensajeM(oidMensaje);

                Iterator itcollMM = collMM.iterator();

                while (itcollMM.hasNext()) {
                    MensajeMarcaLocal mMML = (MensajeMarcaLocal) itcollMM.next();
                    mMMLH.remove(mMML);
                }

                // CODIGO VENTA
                MensajeCodigoVentaLocalHome mCVLH = new MensajeCodigoVentaLocalHome();
                Collection collCV = mCVLH.findByMensaje(oidMensaje);

                Iterator itcollCV = collCV.iterator();

                while (itcollCV.hasNext()) {
                    MensajeCodigoVentaLocal mCVL = (MensajeCodigoVentaLocal) itcollCV.next();
                    mCVLH.remove(mCVL);
                }

                MensajesTipoAsignacionLocalHome mTALH = new MensajesTipoAsignacionLocalHome();
                Collection collMTA = mTALH.findByMensaje(oidMensaje);

                Iterator itcollMTA = collMTA.iterator();

                while (itcollMTA.hasNext()) {
                    MensajesTipoAsignacionLocal mTAL = (MensajesTipoAsignacionLocal) itcollMTA.next();

                    if ((mTAL.getTide_oid_tipo_dest().longValue() != ConstantesMSG.OID_PEDIDO.longValue()) &&
                            (mTAL.getTide_oid_tipo_dest().longValue() != ConstantesMSG.OID_CONSULTORAS.longValue())) {
                        mTALH.remove(mTAL);
                    }
                }

                // CLIENTE
                //  MensajesTipoAsignacionLocalHome mTALH = getMensajesTipoAsignacionLocalHome();
                //        Collection collMTA = mTALH.findByMensaje(oidMensaje);
                //      Iterator itcollMTA = collMTA.iterator();
                //    while (itcollMTA.hasNext()) {
                //MensajesTipoAsignacionLocal mTAL = (MensajesTipoAsignacionLocal)itcollMTA.next();
                //mTAL.remove();
                //}
                //       while (itcollMTA.hasNext()) {
                //          MensajeDestinatarioLocal mMDL = (MensajeDestinatarioLocal)itcollMD.next();
                //          mMDL.setActivo("0");
                //          mMDL.setFecha(new Timestamp(System.currentTimeMillis()));
                //        }
                // Eliminacion de todas las entradas de la entidad MensajeTipoDestinatario
                //        MensajeTipoDestinatarioLocalHome tDPMLH = getMensajeTipoDestinatarioLocalHome();
                //        Collection collTDPM = tDPMLH.findByMensaje(oidMensaje);
                //      
                //        Iterator itcollTDPM = collTDPM.iterator();
                //
                //        while (itcollTDPM.hasNext()) {
                //          MensajeTipoDestinatarioLocal tDPML = (MensajeTipoDestinatarioLocal)itcollTDPM.next();
                //          tDPML.remove();
                //        }
            }
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMensajesBean.eliminarDestinatarioMensaje(Long oidMensaje): Salida");
    }

    public void eliminarMensaje(DTOOIDs DTOE) throws MareException {
    
        UtilidadesLog.info("MONMensajesBean.eliminarMensaje(DTOOIDs DTOE): Entrada");
    
        try {
            if (DTOE != null) {
                if (DTOE.getOids() != null) {
                    Long[] oidsA = DTOE.getOids();

                    for (int i = 0; i < oidsA.length; i++) {
                        // Eliminamos todos los destinatarios del mensaje excepto los clientes 
                        eliminarDestinatarioMensaje(oidsA[i]);

                        // Eliminamos el mensaje 
                        MensajesLocalHome mLH = new MensajesLocalHome();
                        MensajesLocal mL = mLH.findByPrimaryKey(oidsA[i]);
                        mLH.remove(mL);
                    }
                }
            }
        } catch (NoResultException e) {
            UtilidadesLog.debug(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMensajesBean.eliminarMensaje(DTOOIDs DTOE): Salida");
    }

  
    private Long BigToLong(Object num) {
        if (num != null) {
            return (new Long(((BigDecimal) num).longValue()));
        } else {
            return null;
        }
    }

    public DTOSalida obtenerMensajesPorPais(DTOSiccPaginacion DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.obtenerMensajesPorPais(DTOSiccPaginacion DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();
        DTOSalida dts = new DTOSalida();

        try {
            if (DTOE != null) {
                dts.setResultado(dmsg.obtenerMensajesPorPais(DTOE));
            } else {
                dts.setResultado(null);
            }

            UtilidadesLog.info("MONMensajesBean.obtenerMensajesPorPais(DTOSiccPaginacion DTOE): Salida");

            return dts;
        } catch (Exception e) {
            throw new MareException(e,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS + "(obtenerTiposGeneracionDatos)"));
        }
    }



    public DTOSalida obtenerMetacaracteres(DTOBelcorp DTOE)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.obtenerMetacaracteres(DTOBelcorp DTOE): Entrada");
            
        DAOMSG dmsg = new DAOMSG();

        try {
            DTOSalida dtoSalida = dmsg.obtenerMetacaracter(DTOE);

            RecordSet rs_metacaracteres = dtoSalida.getResultado();
            int rows = rs_metacaracteres.getRowCount();

            //int cols = rs_metacaracteres.getColumnCount();
            String value = null;

            for (int row = 0; row < rows; row++) {
                //for(int col=0;col < cols;col++)
                //{
                value = (rs_metacaracteres.getValueAt(row, 0)).toString();

                //value = (replaceAll(value,'<',"&lt;")).replaceAll(value,'>',"&rt;"); // se supone que ">" tambien tendria que reemplazar 
                value = formatearMetacaracter(value);
                rs_metacaracteres.setValueAt(value, row, 0);

                //}
            }

            dtoSalida.setResultado(rs_metacaracteres);

            UtilidadesLog.info("MONMensajesBean.obtenerMetacaracteres(DTOBelcorp DTOE): Salida");

            return dtoSalida;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    private String formatearMetacaracter(String str) {
        int label_l = ConstantesMSG.CARACTER_MENOR.length();

        if (str.regionMatches(str.indexOf(ConstantesMSG.CARACTER_MENOR), ConstantesMSG.CARACTER_MENOR, 0, label_l)) {
            int f = str.indexOf(ConstantesMSG.CARACTER_MENOR);
            str = (str.substring(0, f)).concat(ConstantesMSG.ESCAPE_CARACTER_MENOR).concat(str.substring(f + label_l));
        }

        //return str.replaceAll(ConstantesMSG.CARACTER_MENOR,ConstantesMSG.ESCAPE_CARACTER_MENOR); //.replaceAll(str,CARACTER_MAYOR,ESCAPE_CARACTER_MAYOR)     
        return str;
    }

    private String deshacerFormateoMetacaracter(String str) {
        int label_l = ConstantesMSG.ESCAPE_CARACTER_MENOR.length();

        if (str.regionMatches(str.indexOf(ConstantesMSG.ESCAPE_CARACTER_MENOR), ConstantesMSG.ESCAPE_CARACTER_MENOR, 0, label_l)) {
            int f = str.indexOf(ConstantesMSG.ESCAPE_CARACTER_MENOR);
            str = (str.substring(0, f)).concat(ConstantesMSG.CARACTER_MENOR).concat(str.substring(f + label_l));
        }

        //return str.replaceAll(ConstantesMSG.ESCAPE_CARACTER_MENOR, ConstantesMSG.CARACTER_MENOR); //.replaceAll(str,ESCAPE_CARACTER_MAYOR,CARACTER_MAYOR)    
        return str;
    }

    public void guardarDestinatarioExcluyente(DTODestinatario dto)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.guardarDestinatarioExcluyente(DTODestinatario dto): Entrada");
            
        // PEDIDO 
        if (dto.getPedido().booleanValue()) {
            guardarTipoDestinatario(ConstantesMSG.OID_PEDIDO, dto.getOidMensaje());
        }

        // LISTA CONSULTORAS 
        if (dto.getConsultoras().booleanValue()) {
            guardarTipoDestinatario(ConstantesMSG.OID_CONSULTORAS, dto.getOidMensaje());
        }
        
        UtilidadesLog.info("MONMensajesBean.guardarDestinatarioExcluyente(DTODestinatario dto): Salida");
    }

    public void modificarDestinatarioExcluyente(DTODestinatario dto)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.modificarDestinatarioExcluyente(DTODestinatario dto): Entrada");
            
        try {
            // Eliminar todas las entradas de la entidad MensajesTipoAsignacion que sean "Lista de Consultoras" o "Pedidos"

            MensajesTipoAsignacionLocalHome mTALH = new MensajesTipoAsignacionLocalHome();
            Collection collMTA = mTALH.findByMensaje(dto.getOidMensaje());

            Iterator itcollMTA = collMTA.iterator();

            while (itcollMTA.hasNext()) {
                MensajesTipoAsignacionLocal mTAL = (MensajesTipoAsignacionLocal) itcollMTA.next();

                UtilidadesLog.debug("esta en el ciclo " + mTAL.getTide_oid_tipo_dest());

                if ((mTAL.getTide_oid_tipo_dest().longValue() == ConstantesMSG.OID_PEDIDO.longValue()) ||
                        (mTAL.getTide_oid_tipo_dest().longValue() == ConstantesMSG.OID_CONSULTORAS.longValue())) {
                    mTALH.remove(mTAL);
                }
            }

            //PEDIDO
            if (dto.getPedido().booleanValue()) {
                guardarTipoDestinatario(ConstantesMSG.OID_PEDIDO, dto.getOidMensaje());
            }

            //CONSULTORAS
            if (dto.getConsultoras().booleanValue()) {
                guardarTipoDestinatario(ConstantesMSG.OID_CONSULTORAS, dto.getOidMensaje());
            }
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMensajesBean.modificarDestinatarioExcluyente(DTODestinatario dto): Salida");
    }

    public RecordSet obtenerCodigosMensajesPorPais(DTOBelcorp dtoe)
            throws MareException {
            
        UtilidadesLog.info("MONMensajesBean.obtenerCodigosMensajesPorPais(DTOBelcorp dtoe): Entrada");

        RecordSet rs = new RecordSet();
        DAOMSG dao = new DAOMSG();

        rs = dao.obtenerCodigosMensajesPorPais(dtoe);
        
        UtilidadesLog.debug("** rs: " + rs);
        
        UtilidadesLog.info("MONMensajesBean.obtenerCodigosMensajesPorPais(DTOBelcorp dtoe): Salida");

        return rs;
    }

    private MONMantenimientoMFHome getMONMantenimientoMFHome()
             throws NamingException {
         final InitialContext context = new InitialContext();

         return (MONMantenimientoMFHome) PortableRemoteObject.narrow(context.lookup("MONMantenimientoMF"), MONMantenimientoMFHome.class);
     }


    /**
     * @autor Sergio Buchelli
     * Se encarga de validar el xml, si hay errero retona la cadena de al excption caso contario 
     * cadenaz vacia
     * @param textoXml
     * @return
     */
    private String validaXml(String textoXml) {
        StringBuffer sb= new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>");
        sb.append("<SICC-VALIDACION_XML>");
        sb.append(textoXml);
        sb.append("</SICC-VALIDACION_XML>");
        String retorno=string2DOM(sb.toString());
        return retorno;
    
    }

    /**
     * Realiza la conversion de String a un documento xml
     * @param s
     * @return
     */
    public static String string2DOM(String s)
      {
          Document tmpX=null;
          DocumentBuilder builder = null;
          String msgerror="";
          try{
              builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
          }catch(javax.xml.parsers.ParserConfigurationException error){
              msgerror="Error creando factory  "+error.getMessage();
              return msgerror;
          }
          try{
              tmpX=builder.parse(new ByteArrayInputStream(s.getBytes()));
          }catch(org.xml.sax.SAXException error){
              msgerror="Error parseo "+error.getMessage();
              return msgerror;
          }catch(IOException error){
              msgerror="Error generando "+error.getMessage();
              return msgerror;
          }
          return (tmpX!=null?"":msgerror);
      }

    /**
     * OBTINE EL GRUPO DE MENSAJE
     * @param DTOE
     * @return
     */
    private String getGrupoMensaje(DAOMSG dmsg,DTOMensaje DTOE) throws MareException {
        UtilidadesLog.info("MONMensajesBean.getGrupoMensaje(DAOMSG dmsg,DTOMensaje DTOE): Entrada");
        String codigo= dmsg.obtenerCodigoTipoMensaje(DTOE);
        UtilidadesLog.info("MONMensajesBean.getGrupoMensaje(DAOMSG dmsg,DTOMensaje DTOE): Salida");
        return codigo;
    }
}
