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
 */
package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.entidades.rec.CabeceraReclamoDigitadoLocal;
import es.indra.sicc.entidades.rec.LineaOperacionReclamoDigitadoLocal;
import es.indra.sicc.entidades.rec.LineaOperacionReclamoDigitadoLocalHome;
import es.indra.sicc.entidades.rec.OperacionReclamoDigitadoLocal;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.rec.DTOCargaInicialDigitarReclamos;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.rec.DTOReclamo;
import es.indra.sicc.dtos.rec.DTOOperacionReclamo;
import es.indra.sicc.dtos.rec.DTOLineaOperacion;
import es.indra.sicc.entidades.rec.CabeceraReclamoDigitadoLocalHome;
import es.indra.sicc.entidades.rec.OperacionReclamoDigitadoLocalHome;

import javax.persistence.PersistenceException;

public class MONDigitarReclamosBean implements SessionBean {
    
    private SessionContext ctx;
    
    public void ejbCreate(){
    }

    public void ejbActivate(){
    }

    public void ejbPassivate(){
    }

    public void ejbRemove(){
    }

    public void setSessionContext(SessionContext ctx){
        this.ctx = ctx;
    }

    public DTOCargaInicialDigitarReclamos cargaInicial(DTOBelcorp dtoE) throws MareException{
        
        UtilidadesLog.info("MONDigitarReclamos.cargaInicial(DTOBelcorp):Entrada");
        // Realiza la carga inicial para el proceso de digitación de reclamos 

        //Crea un dtoOut del tipo DTOCargaInicialDigitarReclamos 
        DTOCargaInicialDigitarReclamos dtoOut = new DTOCargaInicialDigitarReclamos();
        DAORec dao = new DAORec(ctx);

        // OPERACION 
        //dtoOut.operacion = DAORec.obtenerCodigosOperacion(DTOE)
        UtilidadesLog.debug("Antes de llamar daoREC.obtenerCodigosOperacion");
        dtoOut.setOperacion(dao.obtenerCodigosOperacion(dtoE));
        // ASUME PERDIDA 
        //dtoOut.asumePerdida = DAOCapturaProcesoReclamos.obtenerAsumePerdida(DTOE) 
        UtilidadesLog.debug("Antes llamar al DAOCPR");
        DAOCapturaProcesoReclamos daoCPR = new DAOCapturaProcesoReclamos();
        UtilidadesLog.debug("Despues llamada y antes de llamar METODO");
        dtoOut.setAsumePerdida(daoCPR.obtenerAsumePerdida(dtoE));
        //Devuelve dtoOut 
        UtilidadesLog.info("MONDigitarReclamos.cargaInicial(DTOBelcorp):Salida");        
        return dtoOut;
    }

    public DTOSalida obtenerCodigosTipoOperacion(DTOOID dtoE) throws MareException{
        UtilidadesLog.info("MONDigitarReclamos.obtenerCodigosTipoOperacion(DTOOID):Entrada");
        //Documentation
        // Obtiene los tipos de operación asociados a la operación recibida 
        //Crea un DTOSalida con: 
        //- resultado = DAO.obtenerCodigosTipoOperacion(DTOOID) 
        DAORec dao = new DAORec();
        DTOSalida salida = new DTOSalida();
        salida.setResultado(dao.obtenerCodigosTipoOperacion(dtoE));
        //Devuelve DTOSalida
        UtilidadesLog.info("MONDigitarReclamos.obtenerCodigosTipoOperacion(DTOOID):Salida");
        return salida;
    }

    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoE
     */
    public DTOSalida obtenerTiposMovimiento(DTOBelcorp dtoE) throws MareException{
        UtilidadesLog.info("MONDigitarReclamos.obtenerTiposMovimiento(DTOBelcorp):Entrada");
        //Documentation
        // Obtiene los tipos de movimiento existentes 
        //Crea un DTOSalida con: 
        //- resultado = DAORec.obtenerTiposMovimiento(DTOE) 
        DAORec dao = new DAORec();
        DTOSalida salida = new DTOSalida();
        salida.setResultado(dao.obtenerTiposMovimiento(dtoE));
        //Devuelve DTOSalida

        UtilidadesLog.info("MONDigitarReclamos.obtenerTiposMovimiento(DTOBelcorp):Salida");
        return salida;
    }

    /**
     * @author mmaidana
     * @date 09/06/2006
     * creado por REC-028
     */
    public DTOSalida obtenerTiposMovimientoRecarga(DTOBelcorp dtoE) throws MareException{
        UtilidadesLog.info("MONDigitarReclamos.obtenerTiposMovimiento(DTOBelcorp):Entrada");
        //Documentation
        // Obtiene los tipos de movimiento existentes 
        //Crea un DTOSalida con: 
        //- resultado = DAORec.obtenerTiposMovimiento(DTOE) 
        DAORec dao = new DAORec();
        DTOSalida salida = new DTOSalida();
        salida.setResultado(dao.obtenerTiposMovimientoRecarga(dtoE));
        //Devuelve DTOSalida

        UtilidadesLog.info("MONDigitarReclamos.obtenerTiposMovimiento(DTOBelcorp):Salida");
        return salida;
    }


    public DTOSalida obtenerMotivosDevolucionOperacion(DTOOID dtoE) throws MareException{
        
        UtilidadesLog.info("MONDigitarReclamos.obtenerMotivosDevolucionOperacion(DTOOID):Entrada");
        //Documentation
        // Obtiene los motivos de devolución por operación asociados a la operación recibida 
        //Crea DTOSalida con: 
        //- resultado = DAORec.obtenerMotivosDevolucionOperacion(DTOOID) 
        DAORec dao = new DAORec();
        DTOSalida salida = new DTOSalida();
        salida.setResultado(dao.obtenerMotivosDevolucionOperacion(dtoE));
        //Devuelve DTOSalida
        UtilidadesLog.info("MONDigitarReclamos.obtenerMotivosDevolucionOperacion(DTOOID):Salida");
        return salida;
    }

    /**
     * @author mmaidana
     * @date 09/06/2006
     * creado por REC-028
     */
    public DTOSalida obtenerMotivosDevolucionOperacionRecarga(DTOOID dtoE) throws MareException{
        UtilidadesLog.info("MONDigitarReclamos.obtenerMotivosDevolucionOperacionRecarga(DTOOID):Entrada");
        //Documentation
        // Obtiene los motivos de devolución por operación asociados a la operación recibida 
        //Crea DTOSalida con: 
        //- resultado = DAORec.obtenerMotivosDevolucionOperacion(DTOOID) 
        DAORec dao = new DAORec();
        DTOSalida salida = new DTOSalida();
        salida.setResultado(dao.obtenerMotivosDevolucionOperacionRecarga(dtoE));
        //Devuelve DTOSalida
        UtilidadesLog.info("MONDigitarReclamos.obtenerMotivosDevolucionOperacionRecarga(DTOOID):Salida");
        return salida;
    }

    public void guardarReclamoDigitado(DTOReclamo dtoE) throws MareException{

        UtilidadesLog.info("MONDigitarReclamos.guardarReclamoDigitado(DTOReclamo):Entrada");
        UtilidadesLog.debug("*** DTOReclamo = "+dtoE);
        //Documentation
        // Guarda en BD un reclamo digitado 
        // Guarda la cabecera del reclamo 
        //DTOE = guardarCabeceraReclamoDigitado(DTOE) 
        UtilidadesLog.debug("*** Se guarda la cabecera del reclamo ***");
        dtoE = this.guardarCabeceraReclamoDigitado(dtoE);
                
        // Guarda las operaciones del reclamo junto con sus lineas de operacion 
        //Recorre el ArrayList DTOE.operaciones utilizando el contador operacion 
        //DTOOperacionReclamo = DTOE.operaciones.get(operacion) 
        //guardarOperacionReclamoDigitado(DTOOperacionReclamo, DTOE.oid) 
        // 
        UtilidadesLog.debug("*** Se guardan las operaciones y las lineas del reclamo ***");
        ArrayList operaciones = dtoE.getOperaciones();
        Iterator itOperaciones = operaciones.iterator();
        DTOOperacionReclamo dtoOR = null;
        while(itOperaciones.hasNext()){
            dtoOR = (DTOOperacionReclamo)itOperaciones.next();
            this.guardarOperacionReclamoDigitado(dtoOR,dtoE.getOidReclamo());
        }
        
        UtilidadesLog.info("MONDigitarReclamos.guardarReclamoDigitado(DTOReclamo):Salida");
    }

    public DTOReclamo guardarCabeceraReclamoDigitado(DTOReclamo cabecera) throws MareException {
        UtilidadesLog.info("MONDigitarReclamos.guardarCabeceraReclamoDigitado(DTOReclamo):Entrada");
        UtilidadesLog.debug("*** DTOReclamo cabecera = "+cabecera);
        //Documentation
        // Guarda la cabecera del reclamo recibido 
        
        CabeceraReclamoDigitadoLocalHome cabeceraRDHome = new CabeceraReclamoDigitadoLocalHome(); 
        CabeceraReclamoDigitadoLocal cabeceraRDLocal = null;
        
        Integer idReclamo = null;
        DTONumeroSolicitud dtoNumeroSolic = new DTONumeroSolicitud();
        MONProcesosPED monProcesosPed = this.getMONProcesosPED();
        dtoNumeroSolic.setOidPais(cabecera.getOidPais());
        dtoNumeroSolic.setOperacion("RECDGC");
        try {
            idReclamo = new Integer(monProcesosPed.generaSecuenciaDocumento(dtoNumeroSolic));
        } catch (RemoteException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        try{
            cabeceraRDLocal = cabeceraRDHome.create(cabecera.getNumeroDocumentoReferencia(), cabecera.getCodigoCliente(), cabecera.getOidPais(), idReclamo);
        }catch(PersistenceException ce){
            UtilidadesLog.error("MONDigitarReclamos.guardarCabeceraReclamoDigitado: CreateException:al grabar la cabecera",ce);
            ctx.setRollbackOnly();
            throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        // se setean los demas campos
        cabeceraRDLocal.setNumeroReclamo(cabecera.getNumReclamo()); 
        cabeceraRDLocal.setEstado(ConstantesREC.ESTADO_RECLAMO_DIGITADO); 
        cabeceraRDLocal.setTipoIngreso(ConstantesREC.TIPO_INGRESO_DIGITACION);
        cabeceraRDLocal.setCodigoUsuario(ctx.getCallerPrincipal().getName());
        cabeceraRDLocal.setFechaIngreso(new Date(new java.util.Date().getTime()));
       
        //cabecera.oidReclamo = oid del nuevo registro 
        cabecera.setOidReclamo(cabeceraRDLocal.getOid());
        //Devuelve cabecera
        cabeceraRDHome.merge(cabeceraRDLocal);
        UtilidadesLog.info("MONDigitarReclamos.guardarCabeceraReclamoDigitado(DTOReclamo):Salida"); 
        return cabecera;
    }

    public void guardarOperacionReclamoDigitado(DTOOperacionReclamo operacion, Long cabecera) throws MareException{
    
        UtilidadesLog.info("MONDigitarReclamos.guardarOperacionReclamoDigitado(DTOOperacionReclamo , Long):Entrada");
        UtilidadesLog.debug("*** DTOOperacionReclamo operacion = "+operacion);
        // Guarda los datos de una operación dentro de un reclamo junto con sus lineas de operación 
        
        OperacionReclamoDigitadoLocalHome operacionRDHome = new OperacionReclamoDigitadoLocalHome();
        OperacionReclamoDigitadoLocal operacionRDLocal;

        try{
            operacionRDLocal = operacionRDHome.create(operacion.getNumSecuencial(),
                                cabecera, ConstantesREC.ESTADO_OPERACION_DIGITADO);
        }catch(PersistenceException ce){
            UtilidadesLog.error("MONDigitarReclamos.guardarOperacionReclamoDigitado: CreateException:al grabar la operacion",ce);
            ctx.setRollbackOnly();
            throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        // se setean los demas campos
        operacionRDLocal.setTipoOperacion(operacion.getTipoOperacion());
        operacionRDLocal.setAsumePerdida(operacion.getAsumePerdida());
        operacionRDLocal.setResponsablePerdida(operacion.getCodigoResponsablePerdida());
        operacionRDLocal.setCodigoArticulo(operacion.getCodigoArticuloDigitacion());
        operacionRDLocal.setMontoArticulo(operacion.getMontoPerdida());
        operacionRDLocal.setClienteSeguro(operacion.getCodigoClienteSeguro());
        
        operacionRDHome.merge(operacionRDLocal);
        //operacion.oidOperacion = oid del registro creado 
        operacion.setOidOperacion(operacionRDLocal.getOid());
        // Guarda las lineas de operación correspondientes 
                
        ArrayList lineas = operacion.getLineas();
        Iterator itLineas = lineas.iterator();
        DTOLineaOperacion dtoLO = null;
        while(itLineas.hasNext()){
            dtoLO = (DTOLineaOperacion)itLineas.next();
            this.guardarLineaOperacionReclamoDigitado(dtoLO,operacion.getOidOperacion());
        }

        UtilidadesLog.info("MONDigitarReclamos.guardarOperacionReclamoDigitado(DTOOperacionReclamo , Long):Salida");
    }

    public void guardarLineaOperacionReclamoDigitado(DTOLineaOperacion lineaOperacion, Long operacion) throws MareException{
        UtilidadesLog.info("MONDigitarReclamos.guardarLineaOperacionReclamoDigitado(DTOLineaOperacion , Long):Entrada");
        UtilidadesLog.debug("*** DTOLineaOperacion lineaOperacion = "+lineaOperacion);
        // Guarda los datos de una linea de operación dentro de un reclamo 
        LineaOperacionReclamoDigitadoLocalHome lineaOperacionRDHome = new LineaOperacionReclamoDigitadoLocalHome();
        LineaOperacionReclamoDigitadoLocal lineaOperacionRDLocal;
        
        try{
            lineaOperacionRDLocal = lineaOperacionRDHome.create(lineaOperacion.getNumLinea(),
                                lineaOperacion.getCodigoVenta(),
                                lineaOperacion.getUnidadesReclamadas(),
                                operacion,lineaOperacion.getOidTipoMovimiento());
        }catch(PersistenceException ce){
            UtilidadesLog.error("MONDigitarReclamos.guardarLineaOperacionReclamoDigitado: CreateException:al grabar la linea",ce);
            ctx.setRollbackOnly();
            throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        // se setean los demas campos
        lineaOperacionRDLocal.setMotivoDevolucion(lineaOperacion.getOidMotivoDevolucion());
        lineaOperacionRDLocal.setUnidadesDevueltas(lineaOperacion.getUnidadesDevueltas()==null ?new Integer(0):lineaOperacion.getUnidadesDevueltas());
        lineaOperacionRDHome.merge(lineaOperacionRDLocal);
        UtilidadesLog.info("MONDigitarReclamos.guardarLineaOperacionReclamoDigitado(DTOLineaOperacion , Long):Salida");
    }

 

    
    private MONProcesosPED getMONProcesosPED() throws MareException {
        MONProcesosPED local = null;
        MONProcesosPEDHome localHome = null;
        localHome = (MONProcesosPEDHome)UtilidadesEJB.getHome("MONProcesosPED", MONProcesosPEDHome.class);
        try {
            local = localHome.create();
        } catch(CreateException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }  catch(RemoteException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        return local;
    }

    public DTOSalida existenReclamosDigitados(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONDigitarReclamos.existenReclamosDigitados(DTOBelcorp dtoe):Entrada");
        
        DTOSalida salida = new DTOSalida();
        DAORec dao = new DAORec();       
        salida.setResultado(dao.obtenerCabecerasReclamoDigitado(dtoe));
        
        UtilidadesLog.info("MONDigitarReclamos.existenReclamosDigitados(DTOBelcorp dtoe):Salida");
        
        return salida;
    }

    public DTOSalida obtenerReclamosDigitados(DTOBelcorp dtoe) throws MareException  {
        
        UtilidadesLog.info("MONDigitarReclamos.obtenerReclamosDigitados(DTOBelcorp dtoe):Entrada");
        
        DTOSalida salida = new DTOSalida();
        
        DAORec dao = new DAORec();       
        salida.setResultado(dao.obtenerReclamosDigitados(dtoe));
        
        UtilidadesLog.info("MONDigitarReclamos.obtenerReclamosDigitados(DTOBelcorp dtoe):Salida");
        return salida;
   }

    public void EliminaReclamosDigitados(DTOBelcorp dtoe) throws MareException  {
        try{
            DAORec dao = new DAORec();
            dao.eliminaReclamosDigitados(dtoe);
        }catch(Exception e){
            UtilidadesLog.error("Error al eliminar los reclamos digitados",e);
            ctx.setRollbackOnly();
            if(e instanceof MareException){
                throw (MareException)e;    
            }else {
                MareException me = new MareException(e);
                throw me;
            }
            
        }
    }
}