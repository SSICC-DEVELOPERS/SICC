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
 *
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.rules.RuleService;
import es.indra.sicc.dtos.inc.DTOESolicitud;
import es.indra.sicc.dtos.inc.DTOSolicitudConcursoPuntaje;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoPuntajeLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoPuntajeLocalHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.MegaProcesadorGPs;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

import javax.rules.StatelessRuleSession;


public class MONIncentivosBean
        implements SessionBean {
    private final String reglasCalificacion = "variable_1";
    private final String reglasPuntuacion = "variable_2";
    private final String reglasEvaluacion = "variable_3";

    //private final String reglasPremiacion = "variable_4";
    private StatelessRuleSession workSpace = null;
    private List objetosDelMotor = null;
    private SessionContext ctx;

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

    /**
     * Se concursa la solicitud.
     * Se obtienen los concursos y los datos de la solicitud.
     * Se procesan las calificaciones.
     * Se descartan las solicitudes por no partipar.
     *
     */
    public DTOEstatusSolicitud concursarSolicitud(DTOSolicitudValidacion solicitud)
            throws MareException {
        UtilidadesLog.info("MONIncentivosBean.concursarSolicitud(DTOSolicitudValidacion solicitud):Entrada");
        return this.concursarSolicitudPorConcursos(solicitud, null);

    }

    /**
     * Fecha de Creacion: 19/07/2005
     * Autor: Carlos Leal
     * Descripción: Revierte los puntajes obtenidos durante el proceso de calculo para una solicitud dada.
     *
     */
    public DTOEstatusSolicitud revertirPuntajes(DTOSolicitudValidacion solicitudValidacion)
            throws MareException {
        UtilidadesLog.info("MONIncentivosBean.revertirPuntajes(DTOSolicitudValidacion solicitudValidacion):Entrada");

        DTOESolicitud dtoeSolicitud = new DTOESolicitud();
        dtoeSolicitud.setOidSolicitud(solicitudValidacion.getOidSolicitud());
        RevertirHelper.revertirMensajes(dtoeSolicitud);
        RevertirHelper.revertirRecomendadas(solicitudValidacion);

        DAOSolicitudConcursoPuntaje dao = new DAOSolicitudConcursoPuntaje();
        SolicitudConcursoPuntajeLocalHome solicitudConcursoPuntajeLocalHome = this.getSolicitudConcursoPuntajeLocalHome();
        SolicitudConcursoPuntajeLocal solicitudConcursoPuntajeLocal = null;
        DTOOIDs dtoConcursos = new DTOOIDs();

        DAOSolicitudes daoSol = new DAOSolicitudes();

        ArrayList listaPuntajes = dao.cargarPuntajes(solicitudValidacion.getOidSolicitud().longValue());
        int size = listaPuntajes.size();
        dtoConcursos.setOids(new Long[size]);

        for (int i = 0; i < size; i++) {
            DTOSolicitudConcursoPuntaje dtoSol = (DTOSolicitudConcursoPuntaje) listaPuntajes.get(i);

            try {
                solicitudConcursoPuntajeLocal = solicitudConcursoPuntajeLocalHome.findByPrimaryKey(dtoSol.getOid());
                solicitudConcursoPuntajeLocalHome.remove(solicitudConcursoPuntajeLocal);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }

            //b) Agrego el OID de concurso a un DTOOIs llamado dtoConcursos  ***De donde saco el OID de concurso??
            dtoConcursos.getOids()[i] = dtoSol.getOidConcurso();
            RevertirHelper.revertirExigencias(dtoSol.getOidConcurso().longValue(), solicitudValidacion);
        }

        boolean cuentaCorriente = RevertirHelper.tieneCuentaCorriente(solicitudValidacion);
        boolean candidata = RevertirHelper.esCandidataGanadora(solicitudValidacion);

        if ((cuentaCorriente == true) || (candidata == true)) {
            //Obtengo un objeto del tipo Solicitud a partir del DTO recibido como parametro: 
            Solicitud solicitud = daoSol.obtenerSolicitud(solicitudValidacion);
            Hashtable solicitudConcursoH = solicitud.getSolicitudConcursos();
            Enumeration solicitudConcursoIt = solicitudConcursoH.elements();

            while (solicitudConcursoIt.hasMoreElements()) {
                SolicitudConcurso solConc = (SolicitudConcurso) solicitudConcursoIt.nextElement();
                solConc.setExigenciasCumplidasEnSolicitud(false);
            }

            //Utilizo el motor de reglas 
            crearWorkSpace(this.reglasEvaluacion);
            insertarSolicitudEnMotor(solicitud);

            //invoco a this.insertarConcursosEnMotor( FactoriaConcursos.getFactoriaConcurso().getConcursosPorOID(listConcursos) 
            insertarConcursosEnMotor(FactoriaConcurso.getFactoriaConcurso().getConcursosPorOID(dtoConcursos));
            arrancarMotorDeReglas();

            //Ahora por cada OID de dtoConcursos 
            int sizedtoConcursos = dtoConcursos.getOids().length;

            for (int elm = 0; elm < sizedtoConcursos; elm++) {
                SolicitudConcurso solicitudConcurso = (SolicitudConcurso) solicitud.getSolicitudConcurso(dtoConcursos.getOids()[elm]);
                solicitudConcursoH.get(solicitudConcurso.getOidConcurso());

                if (cuentaCorriente == true) {
                    RevertirHelper.revertirCuentaCorriente(solicitud, solicitudConcurso);
                }

                if (candidata == true) {
                    RevertirHelper.revertirCandidataGanadora(solicitud, solicitudConcurso);
                }
            }

        }

        //6) Retornar objeto DTOEstatusSolicitud con status igual a ConstantesPED.ESTADO_SOLICITUD_VALIDADO 
        DTOEstatusSolicitud dTOEstatusSolicitud = new DTOEstatusSolicitud();
        dTOEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONIncentivosBean.revertirPuntajes(DTOSolicitudValidacion solicitudValidacion):Salida");

        return dTOEstatusSolicitud;
    }

    /**
     *
     */
    private Solicitud obtenerDatosSolicitud(DTOSolicitudValidacion solicitud)
            throws MareException {
        /**
         * PERFORMANCE
         * Hay que revisar el metodo obtenerSolicitud del DAOSolicitudes. Tarda demasiado y hace demasiadas querys.
         * Quizas se podria reemplazar por un store
         */
        Solicitud sol = null;
        Solicitud solAux = null;
        if (MegaProcesadorGPs.solicitudesConcursoEnEjecucion!=null && MegaProcesadorGPs.solicitudesConcursoEnEjecucion.containsKey(solicitud.getOidSolicitud())){
            sol = (Solicitud)MegaProcesadorGPs.solicitudesConcursoEnEjecucion.get(solicitud.getOidSolicitud());
        }else{
            DAOSolicitudes dao = new DAOSolicitudes();
            solAux = dao.obtenerSolicitud(solicitud);
            if (MegaProcesadorGPs.solicitudesConcursoEnEjecucion == null) {
                MegaProcesadorGPs.solicitudesConcursoEnEjecucion = new Hashtable();
            }
            MegaProcesadorGPs.solicitudesConcursoEnEjecucion.put(solicitud.getOidSolicitud(),solAux);
            sol = (Solicitud)this.deepCopy(solAux);
        }
        return sol;
    }

    /**
     *
     */
    private void crearWorkSpace(String reglasAplicables)
            throws MareException {
        UtilidadesLog.info("MONIncentivosBean.crearWorkSpace(String reglasAplicables):Entrada");
        try {
            RuleService ruleService = (RuleService) MareMii.getService(new MareTopic(MareMii.SERVICE_RULE));
            objetosDelMotor = new ArrayList();
            workSpace = (StatelessRuleSession) ruleService.createRuleSession(reglasAplicables, null, 1);
        } catch (MareMiiServiceNotFoundException mm) {
            UtilidadesLog.debug("***Error creando crearWorkSpace*****");
            UtilidadesLog.error("ERROR ", mm);
            throw new MareException(mm, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        UtilidadesLog.info("MONIncentivosBean.crearWorkSpace(String reglasAplicables):Salida");
    }

    /**
     *
     */
    private void arrancarMotorDeReglas() throws MareException {
        try {
            UtilidadesLog.info("MONIncentivosBean.arrancarMotorDeReglas():Entrada");
            workSpace.executeRules(objetosDelMotor);
            objetosDelMotor.clear();
            workSpace.release();
            workSpace = null;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            try {
                workSpace.release();
            } catch (Exception w) {
                UtilidadesLog.error("ERROR ", w);
            }  
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        UtilidadesLog.info("MONIncentivosBean.arrancarMotorDeReglas():Salida");
    }

    /**
     *
     */
    private void insertarSolicitudEnMotor(Solicitud solicitud) {
        UtilidadesLog.info("MONIncentivosBean.insertarSolicitudEnMotor():Entrada");
       // UtilidadesLog.info("solicitud: " + solicitud);
        objetosDelMotor.add(solicitud);
        UtilidadesLog.info("MONIncentivosBean.insertarSolicitudEnMotor():Salida");
    }

    /**
     *
     */
    private void insertarConcursosEnMotor(ArrayList concursos) {
        UtilidadesLog.info("MONIncentivosBean.insertarConcursosEnMotor():Entrada");
       // UtilidadesLog.info("concursos: " + concursos);
        objetosDelMotor.addAll(concursos);
        UtilidadesLog.info("MONIncentivosBean.insertarConcursosEnMotor():Salida");
    }

    /**
     *
     */
    private void insertarPosicionesEnMotor(Posicion[] posicion) {
        UtilidadesLog.info("MONIncentivosBean.insertarPosicionesEnMotor():Entrada");
      //  UtilidadesLog.info("posicion: " + posicion);
        
        int cant = posicion.length;
        ArrayList posiciones = new ArrayList();

        for (int i = 0; i < cant; i++) {
            posiciones.add((Posicion) posicion[i]);
        }

        objetosDelMotor.addAll(posiciones);
        
        UtilidadesLog.info("MONIncentivosBean.insertarPosicionesEnMotor():Salida");
    }

    /**
     *
     */
    private boolean descartarSolicitudPorNoParticipante(Solicitud solicitud) {
        UtilidadesLog.info("MONIncentivosBean.descartarSolicitudPorNoParticipante(Solicitud solicitud):Entrada");
        boolean rechazada = true;
        Hashtable ht = solicitud.getSolicitudConcursos();
        Enumeration e = ht.elements();

        while (e.hasMoreElements()) {
            SolicitudConcurso solicitudConcurso = (SolicitudConcurso) e.nextElement();

            if (solicitudConcurso.getRechazado() == false) {
                rechazada = false;
            }
        }

        UtilidadesLog.info("MONIncentivosBean.descartarSolicitudPorNoParticipante(Solicitud solicitud):Salida");
        return rechazada;
    }

    /**
     *
     */
    private boolean descartarSolicitudPorNoGanadora(Solicitud solicitud) {
        UtilidadesLog.info("MONIncentivosBean.descartarSolicitudPorNoGanadora(Solicitud solicitud):Entrada");

        boolean noGanadora = true;
        Hashtable ht = solicitud.getSolicitudConcursos();
        Enumeration e = ht.elements();

        while (e.hasMoreElements()) {
            SolicitudConcurso solicitudConcurso = (SolicitudConcurso) e.nextElement();

            if (solicitudConcurso.getCandidataGanadora() == true) {
                noGanadora = false;
            }
        }
        UtilidadesLog.info("MONIncentivosBean.descartarSolicitudPorNoGanadora(Solicitud solicitud):Salida");
        return noGanadora;
    }

    //jrivas 05/2/2007 V-INC-36
    private void procesarCalificaciones(Solicitud solicitud, ArrayList concursos) throws MareException {    
        this.procesarCalificaciones(solicitud, concursos, false);
    }


    private void procesarCalificaciones(Solicitud solicitud, ArrayList concursos, boolean anulacion) throws MareException {
        
        UtilidadesLog.info("MONIncentivosBean.procesarCalificaciones(Solicitud solicitud, ArrayList concursos):Entrada");

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("MONIncentivosBean.procesarCalificaciones, anulacion="+anulacion);
          UtilidadesLog.debug("MONIncentivosBean.procesarCalificaciones, consursos="+concursos.size());
        }   

        try{
            if (anulacion == false) {
        
                Concurso con;
            
                UtilidadesLog.info("MONIncentivosBean.procesarCalificaciones END");                                    

                for(int i=0; i<concursos.size();i++){            
                    con=(Concurso) concursos.get(i);

                    if(log.isDebugEnabled()) { //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("RULES **** ["+i+"] ********** oidConcurso="+con.getOidConcurso());
                    
                      UtilidadesLog.debug("solicitud.getDentroPeriodo(con.getPeriodoDesde(), con.getPeriodoHasta())="+
                                            solicitud.getDentroPeriodo(con.getPeriodoDesde(), con.getPeriodoHasta()));
                    
                      UtilidadesLog.debug("ConstantesINC.TIPO_CONSULTORA.equals( con.getDirigidoA())="+
                                            ConstantesINC.TIPO_CONSULTORA.equals( con.getDirigidoA() ));
                                            
                      UtilidadesLog.debug("ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(con.getBaseCalculo())="+
                                            ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(con.getBaseCalculo())+" "+con.getBaseCalculo());             
                            
                      UtilidadesLog.debug("sol.getCliente().getClienteRecomendado().size() = "+
                                            solicitud.getCliente().getClienteRecomendado().size() + " > 0 ");
                    }
                    
                    if (solicitud.getCliente().getPeriodoPrimerContacto() != null) { 
                         UtilidadesLog.debug("solicitud.getCliente().getPeriodoPrimerContacto() is not NULL");
                    /*
                        UtilidadesLog.debug("sol.getCliente().getPeriodoPrimerContacto().getFechaInicio()="+
                                            solicitud.getCliente().getPeriodoPrimerContacto().getFechaDesde());
                    */                                            
                    }else{
                        UtilidadesLog.debug("solicitud.getCliente().getPeriodoPrimerContacto() is NULL");
                    }

                    if (solicitud.getCliente().getClienteRecomendante() != null)
                    {                            
                       if(log.isDebugEnabled()) { //sapaza -- cambio Optimizacion Logs -- 23/03/2010   
                          UtilidadesLog.debug("sol.getCliente().getClienteRecomendante() != null = ("+
                                            solicitud.getCliente().getClienteRecomendante()+")");
                                
                          UtilidadesLog.debug("con.getPeriodoDesde().antesDe(sol.getCliente().getClienteRecomendante().getFechaInicio())="+
                                            con.getPeriodoDesde().antesDe(solicitud.getCliente().getClienteRecomendante().getFechaInicio()));
                                
                          UtilidadesLog.debug("sol.getCliente().getClienteRecomendante().getFechaInicio() = "+
                                            solicitud.getCliente().getClienteRecomendante().getFechaInicio());                            
                                
                          UtilidadesLog.debug("!sol.getIndDevolucion()="+ !solicitud.getIndDevolucion());
                        
                          UtilidadesLog.debug("TIPO_VINCULO, "+ solicitud.getSolicitudConcurso(con.getOidConcurso()).getTipoVinculo());                                
                       }   
                        
                    }else{
                        UtilidadesLog.debug("sol.getCliente().getClienteRecomendante() is NULL");
                    }

                    if (solicitud.getCliente().getClienteRecomendador() != null){
                        if(log.isDebugEnabled()) { //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                          UtilidadesLog.debug("RECOMENDADOR solicitud.getCliente().getClienteRecomendador().getFechaInicio()="+
                                            solicitud.getCliente().getClienteRecomendador().getFechaInicio());

                          UtilidadesLog.debug("RECOMENDADOR con.getPeriodoDesde().antesDe(solicitud.getCliente().getClienteRecomendador().getFechaInicio())="+
                                            con.getPeriodoDesde().antesDe(solicitud.getCliente().getClienteRecomendador().getFechaInicio()));
                        }                    
                                            
                    } else {
                        UtilidadesLog.debug("RECOMENDADOR IS NULL");                        
                    }                    
                }                    
                
                UtilidadesLog.info("MONIncentivosBean.procesarCalificaciones END");                        
            }
            
        } catch(Exception e){
            UtilidadesLog.debug("ERROR="+ e.getMessage());
            e.printStackTrace();
        }

        crearWorkSpace(this.reglasCalificacion);
        insertarConcursosEnMotor(concursos);
        insertarSolicitudEnMotor(solicitud);     
        arrancarMotorDeReglas();


        //jrivas 13/7/2005
        //inc 19854
        //jrivas 05/2/2007 V-INC-36
        
        UtilidadesLog.info("MONIncentivosBean.procesarCalificaciones START");
        
        if (anulacion == false) {
            this.actualizarDatosCalificacion(solicitud);
        }
                
        UtilidadesLog.info("MONIncentivosBean.procesarCalificaciones(Solicitud solicitud, ArrayList concursos):Salida");
    }

    /**
     *
     */
    private void procesarPuntuaciones(Solicitud solicitud, ArrayList concursos)
            throws MareException {
        UtilidadesLog.info("MONIncentivosBean.procesarPuntuaciones(Solicitud solicitud, ArrayList concursos):Entrada");
        crearWorkSpace(this.reglasPuntuacion);
        insertarConcursosEnMotor(concursos);
        insertarPosicionesEnMotor(solicitud.getPosiciones());       
        arrancarMotorDeReglas();

        // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
        if( solicitud.getIndAnulacion() == false 
            && solicitud.getIndDevolucion() == false){
          this.actualizarDatosPuntuacion(solicitud, concursos);
        }
        UtilidadesLog.info("MONIncentivosBean.procesarPuntuaciones(Solicitud solicitud, ArrayList concursos):Salida");
    }

    /**
     *
     */
    private void procesarEvaluaciones(Solicitud solicitud, ArrayList concursos)
            throws MareException {
        UtilidadesLog.info("MONIncentivosBean.procesarEvaluaciones(Solicitud solicitud, ArrayList concursos):Entrada");
        crearWorkSpace(this.reglasEvaluacion);
        insertarConcursosEnMotor(concursos);
        insertarSolicitudEnMotor(solicitud);
        arrancarMotorDeReglas();

        // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
        if( solicitud.getIndAnulacion() == false 
            && solicitud.getIndDevolucion() == false){
          actualizarDatosEvaluacion(solicitud, concursos);
        }
        UtilidadesLog.info("MONIncentivosBean.procesarEvaluaciones(Solicitud solicitud, ArrayList concursos):Salida");
    }

    /**
     *
     */
    private void actualizarDatosCalificacion(Solicitud solicitud) throws MareException {
        UtilidadesLog.info("MONIncentivosBean.actualizarDatosCalificacion(Solicitud solicitud):Entrada");
        DAOSolicitudActualizacion dao = new DAOSolicitudActualizacion();
        DAOBaseCalculo daoBaseCalc = new DAOBaseCalculo();
        DAOClientePremiacion daoClie = new DAOClientePremiacion();
        DespacharPremiosHelper despacharHelper = new DespacharPremiosHelper();
        boolean multinivel;

        Hashtable ht = solicitud.getSolicitudConcursos();
        Enumeration e = ht.elements();

        while (e.hasMoreElements()) {
            SolicitudConcurso solicitudConcurso = (SolicitudConcurso) e.nextElement();
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug(solicitudConcurso.getOidConcurso() + "  _  solicitudConcurso.getCambioTipoVinculo() " + solicitudConcurso.getCambioTipoVinculo());
              UtilidadesLog.debug(" solicitudConcurso.getTipoVinculo() " + solicitudConcurso.getTipoVinculo());
            }  
            
            multinivel = despacharHelper.obtenerConcurso(solicitudConcurso.getOidConcurso()).getMultiNivel();
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug(" concurso.getMultiNivel() " + multinivel );

            if (multinivel) {
                dao.actualizarRecomendadaRecomendanteMultinivel(solicitudConcurso, solicitud);                    
            }

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("ACTUALIZAR RECOMENDADA(S)RECOMENDANTE ("+solicitudConcurso.getOidConcurso() + ")"
                +"=> getCambioTipoVinculo()="+solicitudConcurso.getCambioTipoVinculo()
               +" getRechazado()="+solicitudConcurso.getRechazado());
            
            if ( solicitudConcurso.getCambioTipoVinculo() && !multinivel ) {
                //jrivas 15/12/2006 V-INC-024
                if ( !solicitudConcurso.getRechazado() ) {
                    dao.actualizarRecomendadasRecomendante(solicitudConcurso, solicitud);   // JVM sicc 20070237, dao.actualizarRecomendadasRecomendante(solicitudConcurso, solicitud)
                    if (solicitud.getCliente().getClienteRecomendante() != null){           // JVM sicc 20070237, se agrega para procesar solo tipo vinculo ambas
                        dao.actualizarRecomendadaRecomendante(solicitudConcurso, solicitud);                    
                    }
                }
            }
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                        
              UtilidadesLog.debug(" solicitudConcurso.getDescalificaClientePorSolicitud() " + solicitudConcurso.getDescalificaClientePorSolicitud());

            // vbongiov -- 16/11/2006 -- DBLG700000185
            if (((solicitudConcurso.getDescalificaClientePorSolicitud() == ConstantesINC.CAUSA_DESCALIF_ACTIVIDAD) ||
                    (solicitudConcurso.getDescalificaClientePorSolicitud() == ConstantesINC.CAUSA_DESCALIF_CONSTANCIA)) 
                    && !solicitud.getRechazado(solicitudConcurso.getOidConcurso())){
                  
                // sapaza -- PER-SiCC-2014-0913 -- 10/11/2014      
                String valorParametro = daoClie.obtenerParametroPais(solicitud.getOidPais(), "INC", "IndEvCierrCamp");
                    
                if(!"1".equals(valorParametro)) {
                    dao.actualizarDescalificaciones(solicitudConcurso, solicitud);
                    daoClie.actualizaCtaCteIncentivos(solicitudConcurso, solicitud);
                    daoBaseCalc.grabarClienteFaltaConstanciaActividad(solicitud.getCliente().getOidCliente(), solicitud.getPeriodo());
                    // vbongiov -- 16/11/2006 -- DBLG700000185
                    solicitud.setRechazado(solicitudConcurso.getOidConcurso());
                }    
            }

            //jrivas DBLG5000839 31/8/2006
            //-----------------------------------------------------------------------
            if (solicitudConcurso.getActualizarGerentesRecomendacion()) {
                dao.actualizarGerentesRecomendacion(solicitudConcurso);
            }

            if (solicitudConcurso.getActualizarClienteRecomendacionGerente()) {
                dao.actualizarClienteRecomendadoGerentes(solicitudConcurso, solicitud);                
                dao.actualizarSolicitudRecomendadasGerente(solicitud, solicitudConcurso);
            }
            //-----------------------------------------------------------------------

        }
        UtilidadesLog.info("MONIncentivosBean.actualizarDatosCalificacion(Solicitud solicitud):Salida");
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @param concursos
     * @param solicitud
     *
     * Modificado por Sergio Platas
     * @date 24/06/2005
     */
    private void actualizarDatosPuntuacion(Solicitud solicitud, ArrayList concursos)
            throws MareException {
        UtilidadesLog.info("MONIncentivosBean.actualizarDatosPuntuacion(Solicitud solicitud, ArrayList concursos):Entrada");
        DAOSolicitudActualizacion dao = new DAOSolicitudActualizacion();

        Hashtable ht = solicitud.getSolicitudConcursos();
        Enumeration e = ht.elements();

        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" solicitud.getSolicitudConcursos() " + solicitud.getSolicitudConcursos());

        while (e.hasMoreElements()) {
            SolicitudConcurso solicitudConcurso = (SolicitudConcurso) e.nextElement();
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug(" solicitudConcurso " + solicitudConcurso);

            // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
            // 0.- Si solicitud.indDevolucion && solicitudConcurso.indAnulaPedido == true 
            //     entonces pasar al siguiente elemento de solicitudConcursos
            if( solicitud.getIndDevolucion() 
                && solicitudConcurso.getIndAnulaPedido() ){
                continue;
            }

            Iterator i = concursos.iterator();

            while (i.hasNext()) {
                Concurso concurso = (Concurso) i.next();
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug(" concurso " + concurso);

                if ((concurso.getOidConcurso().equals(solicitudConcurso.getOidConcurso())) && concurso.getIndProductosExigidos()) {
                    dao.actualizarCalculosProductosExigidos(solicitud, solicitudConcurso);
                    dao.actualizarPuntajeProductosExigidos(solicitud, solicitudConcurso);
                }
            }

            //Actualizar Solicitud Concurso Puntaje 
            //Llamamos al método del DAOSolicitudActualizacion
            //          .actualizarSolicitudConcursoPuntaje(solicitudConcurso,solicitud, 
            //                  this.obtenerConcurso.(solicitudConcurso.oidConcurso, concursos))
            //jrivas 13/7/2005
            //inc 19853
            if (!solicitudConcurso.getRechazado()) {
                Concurso concurso = this.obtenerConcurso(concursos, solicitudConcurso.getOidConcurso());

                if (concurso != null) {
                    dao.actualizarSolicitudConcursoPuntaje(solicitud, solicitudConcurso, concurso);
                    solicitudConcurso.setNumeroPeriodosEvaluados(solicitudConcurso.getNumeroPeriodosEvaluados() + 1);
                }
            }
        }

        UtilidadesLog.info("MONIncentivosBean.actualizarDatosPuntuacion(Solicitud solicitud, ArrayList concursos):Salida");
    }


    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param concursos
     * @param solicitud
     *
     * Modificado por Sergio Platas
     * @date 23/06/2005
     */
    private void actualizarDatosEvaluacion(Solicitud solicitud, ArrayList concursos) throws MareException {
        UtilidadesLog.info("MONIncentivosBean.actualizarDatosEvaluacion(Solicitud solicitud, ArrayList concursos):Entrada");
        DAOSolicitudActualizacion dao = new DAOSolicitudActualizacion();
        //Concurso concurso = new Concurso();
        Concurso concurso = null;
        Hashtable ht = solicitud.getSolicitudConcursos();
        Enumeration e = ht.elements();
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" ht  " + ht);

        while (e.hasMoreElements()) {
            SolicitudConcurso solicitudConcurso = (SolicitudConcurso) e.nextElement();
            concurso = this.obtenerConcurso(concursos, solicitudConcurso.getOidConcurso());

            if (concurso != null) {

              if (solicitud.getCliente() != null){                
                  if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                    UtilidadesLog.debug("JVMXYZ, solicitud.getCliente().getOidCliente()="
                     +solicitud.getCliente().getOidCliente());
              }
              
              if(solicitud.getCliente().getPeriodo() != null){
                  if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                    UtilidadesLog.debug("JVMXYZ, solicitud.getCliente().getPeriodo().getOidPeriodo()=>"
                      +solicitud.getCliente().getPeriodo().getOidPeriodo());
              }
              
              if(solicitud.getCliente().getClienteRecomendante() != null){
                  if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                    UtilidadesLog.debug("JVMXYZ, solicitud.getCliente().getPeriodo().getOidPeriodo()=>"
                     +solicitud.getCliente().getClienteRecomendante().getPeriodo().getOidPeriodo());
              }
              
                // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                // 0.- Si solicitud.indDevolucion && solicitudConcurso.indAnulaPedido == true 
                //     entonces pasar al siguiente elemento de solicitudConcursos
                if( solicitud.getIndDevolucion() 
                    && solicitudConcurso.getIndAnulaPedido() ){
                    continue;
                  }
                  
                // 1.- Actualizamos candidata ganadora
                //jrivas 25/1/2007 Cambio Dupla Cyzone
                if (  (solicitudConcurso.getCandidataGanadora() 
                      && solicitud.getIndDevolucion() == false 
                      && concurso.getIndDuplaCyzone() == false) 
                      ||
                      (solicitudConcurso.getCandidataGanadora() 
                      && solicitud.getIndDevolucion() == false 
                      && concurso.getIndDuplaCyzone() == true
                      && concurso.getClienteParticipanteConcurso(solicitud.getCliente())) ) {
                    this.actualizarDatosEvaluacionCandidata(solicitudConcurso, solicitud);
                }
                
                // DBLG700000193 - gPineda - 22/11/2006
                if( solicitudConcurso.getIndAnulaCandidataGanadora() 
                      && solicitud.getIndDevolucion() ){
                  dao.anularCandidataGanadora( solicitud, solicitudConcurso );
                }


                // 2.- Grabamos en CCPuntos
                if (solicitudConcurso.getIndActualizaCuentaCorriente()) {
                    if (ConstantesINC.TIPO_GERENTE.equals(concurso.getDirigidoA())) {
                        dao.actualizarCuentaCorrienteGerente(solicitudConcurso, solicitud);
                    } else {
                        dao.actualizarCuentaCorriente(solicitud, solicitudConcurso);
                    }
                }
                
                // vbongiov -- Cambio 20080811 -- 26/08/2009
                if (solicitudConcurso.getIndActualizaSorteo()) {
                    String numerosAsignados = dao.actualizarSorteo(solicitud, solicitudConcurso);
                    
                    //dao.actualizarCuentaCorrienteSorteo(solicitud, solicitudConcurso);
                    dao.actualizarCuentaCorriente(solicitud, solicitudConcurso);
                    
                    GestorMensajesPuntuacion gestorMensajesPuntuacion = new GestorMensajesPuntuacion();
                    gestorMensajesPuntuacion.generarMensajeSorteo(solicitud, solicitudConcurso, concursos, numerosAsignados);
                    
                }
                
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("solicitudConcurso.getActualizarPuntajeRecomendacion()="+solicitudConcurso.getActualizarPuntajeRecomendacion());
                  UtilidadesLog.debug("solicitudConcurso.getTipoVinculo()="+solicitudConcurso.getTipoVinculo());
                }  
                
                // 3.- Actulizamos puntaje recomendacion
                if (solicitudConcurso.getActualizarPuntajeRecomendacion()) {
                
// JVMCHG, 001 blq

                    if ((solicitudConcurso.getTipoVinculo().equals(ConstantesINC.TIPO_VINC_RECOMENDADO)) ||
                            (solicitudConcurso.getTipoVinculo().equals(ConstantesINC.TIPO_VINC_AMBOS))) 
                    {
                        //jrivas 7/7/2005
                        //inc 19733
                        dao.actualizarPedidoConcursoRecomendado(solicitud, solicitudConcurso, concurso);

                        //jrivas 1/8/2005
                        //inc 202                        
                        dao.actualizarSolicitudConcursoRecomendado(solicitudConcurso, solicitud);
                    }                
                
                
// JVMCHG, 002 blq
                    if ((ConstantesINC.TIPO_VINC_RECOMENDANTE.equals(solicitudConcurso.getTipoVinculo())) ||
                            (ConstantesINC.TIPO_VINC_AMBOS.equals((solicitudConcurso.getTipoVinculo())))) 
                    {
                            
                        dao.actualizarPedidoConcursoRecomendante(solicitud, solicitudConcurso);

                        //jrivas 1/8/2005
                        //inc 20312  
                        //si es ambas entonces el registro ya esta insertado arriba.
                        //if (!ConstantesINC.TIPO_VINC_AMBOS.equals((solicitudConcurso.getTipoVinculo()))) {
                        //jrivas 2/2/2007 Se cambio la UK da INC_SOLIC_CONCU_RECOM para que permita hacer la insercion de recomendante y recomendado
                        dao.actualizarSolicitudConcursoRecomendante(solicitudConcurso, solicitud);
                        //}

                        //jrivas 7/7/2005
                        //inc 19731
                        //dao.actualizarPedidoConcursoRecomendante(solicitud, solicitudConcurso);
                    }         
                    
                    // vbongiov -- Cambio 20090841 -- 6/07/2009
                    if (solicitudConcurso.getTipoVinculo().equals(ConstantesINC.TIPO_VINC_RECOMENDADO)){
                    
                        dao.guardaSolicitudConcursoRecomendadoTemporal(solicitudConcurso, solicitud);
                        dao.actualizarPedidoConcursoRecomendadoTemporal(solicitudConcurso, solicitud, concurso);
                        
                    }    
                    
                    // vbongiov -- Cambio 20090841 -- 6/07/2009
                    if (solicitudConcurso.getTipoVinculo().equals(ConstantesINC.TIPO_VINC_RECOMENDADO) || 
                        solicitudConcurso.getTipoVinculo().equals(ConstantesINC.TIPO_VINC_AMBOS)){
                    
                        dao.guardaSolicitudConcursoPuntajeFuturo(solicitudConcurso, solicitud); 
                        dao.guardaSolicitudConcursoRecomendadoFuturo(solicitudConcurso, solicitud);
                        dao.guardarPedidoConcursoRecomendadoFuturo(solicitudConcurso, solicitud, concurso);
                    }                    
                
                // vbongiov -- Cambio 20090841 -- 6/07/2009
                } else {
                  // solicitudConcurso.getTipoVinculo = ConstantesINC.TIPO_VINC_NINGUNO                  
                  if(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(concurso.getBaseCalculo())){
                      dao.guardaSolicitudConcursoRecomendadoTemporal(solicitudConcurso, solicitud);
                      dao.actualizarPedidoConcursoRecomendadoTemporal(solicitudConcurso, solicitud, concurso);
                  }
                }

                // 4.- Generamos mensages
                if (solicitudConcurso.getCrearMensaje() && concurso.getComunicacionEnObtencionPuntos() &&
                    (!ConstantesINC.COD_TIPO_PEDIDO_ECM.equals(solicitud.getCodigoTipoSolPais())) ) { // sapaza -- PER-SiCC-2010-0513 -- 11/10/2010
                    this.generarMensaje(solicitud, solicitudConcurso, concursos);
                } 

                // 5.- Actualizamos exigencias cumplidas
                if (solicitudConcurso.getExigenciasCumplidasEnSolicitud()) {
                    dao.activarExigenciasCumplidas(solicitud, solicitudConcurso);
                }

                // 6.- Actualizamos recomendacion gerente
                //jrivas DBLG5000839 31/8/2006
                if (solicitudConcurso.getActualizarPuntanjeRecomendacionGerente() == true) {
                    dao.actualizarPedidoRecomendadasGerente(solicitud, solicitudConcurso);
                }

                // 7.- Actualizamos pedido recomendacion multinivel
                if (solicitudConcurso.getActulaizarPedidoRecomendanteMultinivel() == true) {
                    dao.actualizarPedidoRecomendanteMultinivel(solicitud, solicitudConcurso, concurso);
                }
            }
        }
        UtilidadesLog.info("MONIncentivosBean.actualizarDatosEvaluacion(Solicitud solicitud, ArrayList concursos):Salida");
    }


    /**
     * Genera el mensaje en el buzon de mensajes y en la entidad de mensajes de incentivos.
     */
    private void generarMensaje(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos) throws MareException {
        UtilidadesLog.info("MONIncentivosBean.generarMensaje(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos):Entrada");
        
        GestorMensajesPuntuacion gestorMensajesPuntuacion = new GestorMensajesPuntuacion();
        
        Iterator i = concursos.iterator();
        boolean found = false;
        Concurso concurso = null;

        while (i.hasNext() && !found) {
            concurso = (Concurso) i.next();

            if (concurso.getOidConcurso().longValue() == solicitudConc.getOidConcurso().longValue()) {
                found = true;
            }
        }        
        
        // vbongiov - 11/05/2006
        // Inc DBLG500000246 / DBLG500000347
        if((ConstantesINC.OID_BASE_CALCULO_MONTO.equals(concurso.getBaseCalculo()) ||
           ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(concurso.getBaseCalculo())) && 
           ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.equals(concurso.getDirigidoA())){
           
              gestorMensajesPuntuacion.crearMensajeMontoUnidadesConsultoras(solicitud, solicitudConc, concursos);
          
        } else {
              gestorMensajesPuntuacion.crearMensajeGenerico(solicitud, solicitudConc, concursos);
        }
        
        UtilidadesLog.info("MONIncentivosBean.generarMensaje(Solicitud solicitud, SolicitudConcurso solicitudConc, ArrayList concursos):Salida");
    }


    /**
     *
     */
    private Concurso obtenerConcurso(ArrayList concursos, Long oidConcurso)
            throws MareException {
        /*
        Autor:DJ
        Fecha:18/03/2005

        Descripcion: retorna un objeto concurso de acuerdo al oid recibido por parametro.

        Implementacion:
        Recorrer el ArrayList de concursos recibido por parametro buscando el concurso con el oid recibido
        por parametro y retornar el objeto de la clase Concurso encontrado. Si no existe retornar null.
        */
        UtilidadesLog.info("MONIncentivosBean.obtenerConcurso(ArrayList concursos, Long oidConcurso):Entrada");
        for (int i = 0; i < concursos.size(); i++) {
            if (oidConcurso.equals(((Concurso) concursos.get(i)).getOidConcurso())) {
                UtilidadesLog.info("MONIncentivosBean.obtenerConcurso(ArrayList concursos, Long oidConcurso):Salida");
                return (Concurso) concursos.get(i);
            }
        }
        UtilidadesLog.info("MONIncentivosBean.obtenerConcurso(ArrayList concursos, Long oidConcurso):Salida");
        return null;
    }

    /**
     * Descripcion: rechaza la solicitud para los concursos de ranking para evitar
     * su evaluacion en dichos concursos ya que esta funcionalidad se efectua en otro
     * punto del sistema.
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   13/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void rechazarSolicitudEnConcursoRanking(Solicitud solicitud, ArrayList concursos)
            throws MareException {
        UtilidadesLog.info("MONIncentivosBean.rechazarSolicitudEnConcursoRanking(Solicitud solicitud, ArrayList concursos):Entrada");

        Enumeration enumSolConc = solicitud.getSolicitudConcursos().elements();

        while (enumSolConc.hasMoreElements()) {
            SolicitudConcurso solConc = (SolicitudConcurso) enumSolConc.nextElement();
            Concurso conc = null;

            for (int i = 0; i < concursos.size(); i++) {
                conc = (Concurso) concursos.get(i);

                if (conc.getOidConcurso().equals(solConc.getOidConcurso())) {
                    break;
                }
            }

            if (conc.getIndRanking()) {
                solConc.setRechazado(true);
            }
        }
        UtilidadesLog.info("MONIncentivosBean.rechazarSolicitudEnConcursoRanking(Solicitud solicitud, ArrayList concursos):Salida");
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       9/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public void actualizarDatosAnulacion(DTOSolicitudValidacion dtoSolicitudValidacion, Long periodoAnulacion) throws MareException {
        UtilidadesLog.info("MONIncentivosBean.actualizarDatosAnulacion(Solicitud solicitud):Entrada");
        
        DAOSolicitudes daoSolicitudes = new DAOSolicitudes();
        AnularSolicitudesHelper anularSolicitudesHelper = new AnularSolicitudesHelper();
        Solicitud solicOriginal = null;
        Solicitud solicAEvaluar = null;
        SolicitudConcurso solcitudConcursoAEvaluar = null;
        
        // Obtiene las solicitudes del consolidado
        DTOOIDs dtoOids = daoSolicitudes.obtenerSolicitudesConsolidado(dtoSolicitudValidacion.getOidSolicitud());
        
        int cant = dtoOids.getOids().length;
        Long[] oidSolicitudes = dtoOids.getOids();
        ArrayList concursosOids = new ArrayList();
        ArrayList concursos = new ArrayList();
        Long oidConcurso = null;
        
        for(int i=0; i<cant; i++) {
            concursosOids = new ArrayList();
            dtoSolicitudValidacion.setOidSolicitud(oidSolicitudes[i]);
            
            // Datos solicitud original
            UtilidadesLog.debug("dtoSolicitudValidacion: " + dtoSolicitudValidacion);
            solicOriginal = daoSolicitudes.obtenerSolicitud(dtoSolicitudValidacion);
            
            Iterator solicitudesConcursosIte = solicOriginal.getSolicitudConcursos().values().iterator();
            
            UtilidadesLog.debug("solicOriginal.getSolicitudConcursos.size(): " + solicOriginal.getSolicitudConcursos().size());
            
            while( solicitudesConcursosIte.hasNext() ){
              // vbongiov -- 27/12/2006 -- DBLG700000194
              oidConcurso = ( (SolicitudConcurso)solicitudesConcursosIte.next()).getOidConcurso();              
              concursosOids.add(oidConcurso);                            
            }     
            
            Long[] oids = (Long[]) concursosOids.toArray(new Long[concursosOids.size()]);
            DTOOIDs dtoOidsConc = new DTOOIDs();
            dtoOidsConc.setOids(oids);
            
            concursos = FactoriaConcurso.getFactoriaConcurso().getConcursosPorOID(dtoOidsConc);
                                            
            //jrivas 05/2/2007 V-INC-36
            this.procesarCalificaciones(solicOriginal, concursos, true);

            boolean descartar = this.descartarSolicitudPorNoParticipante(solicOriginal);
            if (!descartar) {
            
                // gPineda - 12/12/06
                //Como son nuevas instancias, no tienen activo el indAnulaPedido, ni Anulacion
                solicOriginal.setIndAnulacion(true);
                
                // vbongiov -- 27/12/2006 -- DBLG700000194
                UtilidadesLog.debug("solicOriginal: " + solicOriginal);
                // Copio la solicutud a anular para precesarla por las reglas
                solicAEvaluar = (Solicitud)deepCopy(solicOriginal);
                UtilidadesLog.debug("solicAEvaluar: " + solicAEvaluar);
                
                Posicion posicion = null;
                Posicion[] posiciones = solicAEvaluar.getPosiciones();
                int cant1 = posiciones.length;
                
                UtilidadesLog.debug("cant1: " + cant1);   

                // Se modifican las unidades a negativas para el procesamiento de las reglas
                for(int j=0; j<cant1; j++){
                  posicion = posiciones[j];
                  
                  posicion.setUnidadesDemandadas(new Long((-1)*posicion.getUnidadesDemandadas().longValue()));
                  posicion.setUnidadesDemandaReal(new Long((-1)*posicion.getUnidadesDemandaReal().longValue()));
                  posicion.setUnidadesPorAtender(new Long((-1)*posicion.getUnidadesPorAtender().longValue()));
                  posicion.setUnidadesComprometidas(new Long((-1)*posicion.getUnidadesComprometidas().longValue()));           
                }
                
                UtilidadesLog.debug("concursos.size(): " + concursos.size());
                UtilidadesLog.debug("solicitud.getPosiciones(): " + solicAEvaluar.getPosiciones().length);
                
                this.procesarPuntuaciones(solicAEvaluar, concursos);
                this.procesarEvaluaciones(solicAEvaluar, concursos);
                
                UtilidadesLog.debug("solicAEvaluar.getSolicitudConcursos.size() despues: " + solicAEvaluar.getSolicitudConcursos().size());

                Iterator solicitudesConcursosAEvaluarIte = solicAEvaluar.getSolicitudConcursos().values().iterator();
                
                // Actualiza la solicitud a anular con el flag IndAnulaCandidataGanadora
                while( solicitudesConcursosAEvaluarIte.hasNext() ){
                    solcitudConcursoAEvaluar = (SolicitudConcurso)solicitudesConcursosAEvaluarIte.next();
                    UtilidadesLog.debug("solcitudConcursoReglas.getOidConcurso(): " + solcitudConcursoAEvaluar.getOidConcurso());
                    
                    solicOriginal.getSolicitudConcurso(solcitudConcursoAEvaluar.getOidConcurso()).setIndAnulaCandidataGanadora(
                    solcitudConcursoAEvaluar.getIndAnulaCandidataGanadora());
                }
                
                UtilidadesLog.debug("solicitudAnulacion: "+solicOriginal);
                
                // Anulacion de la solicitud
                anularSolicitudesHelper.tratarAnulacionSolicitud(solicOriginal, periodoAnulacion);

            }
        }
        UtilidadesLog.info("MONIncentivosBean.actualizarDatosAnulacion(Solicitud solicitud):Salida");
        
    }
    
    
     /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       15/09/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOEstatusSolicitud anularSolicitud(DTOSolicitudValidacion dtoSolicitud) throws MareException {
        UtilidadesLog.info("MONIncentivosBean.anularSolicitud(DTOSolicitudValidacion dtoSolicitud):Entrada");
        
        DTOSolicitudValidacion dtoSolicitudAnul = (DTOSolicitudValidacion)deepCopy(dtoSolicitud);
        
        ArrayList concursos = FactoriaConcurso.getFactoriaConcurso().getConcursos(dtoSolicitud.getOidPais());
        
        //jrivas 21/11/2007 20070447
        Long periodoAnulacion = dtoSolicitudAnul.getOidPeriodo();
        
        if(IncetivosHelper.contieneConcursos(concursos).booleanValue()){
    
            DAOSolicitudes dao = new DAOSolicitudes();

            dao.rellenarAnulaciones(dtoSolicitudAnul);
                
            //jrivas 21/11/2007 20070447
            if (dtoSolicitudAnul.getOidSolicitud() != null) {
                this.actualizarDatosAnulacion(dtoSolicitudAnul, periodoAnulacion);
            }
        }        
        DTOEstatusSolicitud estatus = new DTOEstatusSolicitud();
        estatus.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
    
        UtilidadesLog.info("MONIncentivosBean.anularSolicitud(DTOSolicitudValidacion dtoSolicitud):Salida");
        return estatus;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       02/12/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOEstatusSolicitud concursarSolicitudRanking(DTOSolicitudValidacion solicitud, Long oidConcurso) throws MareException {
  
      UtilidadesLog.info("MONIncentivosBean.concursarSolicitudRanking(DTOSolicitudValidacion solicitud):Entrada");
  
      FactoriaConcurso factoria= FactoriaConcurso.getFactoriaConcurso();
      
      DTOOIDs dtoOids = new DTOOIDs();
      Long[] oids = { oidConcurso };
      dtoOids.setOids(oids);

      ArrayList concursos = FactoriaConcurso.getFactoriaConcurso().getConcursosPorOID(dtoOids);
      
      if(IncetivosHelper.contieneConcursos(concursos).booleanValue()){
            
          Solicitud solicitudIntegra = this.obtenerDatosSolicitud(solicitud);
          
          if(!solicitudIntegra.getIndAnulacion()) {
          
              this.procesarCalificaciones(solicitudIntegra, concursos);
              
              if(!this.descartarSolicitudPorNoParticipante(solicitudIntegra)){
                  this.procesarPuntuaciones(solicitudIntegra, concursos);
              }
          }
      }
      
      DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
      
      dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
      
      UtilidadesLog.info("MONIncentivosBean.concursarSolicitudRanking(DTOSolicitudValidacion solicitud):Salida");
      
      return dtoEstatusSolicitud;
  }


    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLoclHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (CuentaCorrientePuntosLocalHome) context.lookup("java:comp/env/CuentaCorrientePuntos");
    }


    private MONGestionMensajesHome getMONGestionMensajesHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGestionMensajesHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionMensajes"), MONGestionMensajesHome.class);
    }


    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param arrConcursos
     * @param solicitud
     * jrivas inc. 22126 17/12/2005
     */
    public DTOEstatusSolicitud concursarSolicitudPorConcursos(DTOSolicitudValidacion solicitud, ArrayList arrConcursos) throws MareException {

        UtilidadesLog.info("MONIncentivosBean.concursarSolicitudPorConcursos():Entrada");        
        
        ArrayList concursos;
        if (arrConcursos == null) {
            FactoriaConcurso factoria = FactoriaConcurso.getFactoriaConcurso();
            concursos = factoria.getConcursos(solicitud.getOidPais());
        } else {
            concursos = arrConcursos;
        }

        if(IncetivosHelper.contieneConcursos(concursos).booleanValue()){
            Solicitud solicitudIntegra = this.obtenerDatosSolicitud(solicitud);
            /* CAMBIO ANUL_DEVO - gPineda - 30/10/2006
            //jrivas 25/8/2006 Si es una Devolución y no tiene posiciones, es porque es una dev. digitada y estas no se tienen en cuenta.
            if (solicitudIntegra.getPosiciones().length > 0 || (!solicitudIntegra.getIndDevolucion())) { */
            if( ! solicitudIntegra.getIndDevolucion() ){
                if( solicitudIntegra.getPosiciones().length > 0){
                
                    // vbongiov -- 07/07/2006 -- inc DBLG500000896
                    // if(!solicitudIntegra.getIndAnulacion()) {
                    Iterator it = concursos.iterator();
    
                    while (it.hasNext()) {
                        solicitudIntegra.getSolicitudConcurso(((Concurso) it.next()).getOidConcurso());                    
                    }
            
                    this.procesarCalificaciones(solicitudIntegra, concursos);
                    
                    boolean descartar = this.descartarSolicitudPorNoParticipante(solicitudIntegra);
            
                    if (!descartar) {
                        this.procesarPuntuaciones(solicitudIntegra, concursos);                         
                        this.procesarEvaluaciones(solicitudIntegra, concursos);
                    }                    
                }                
            } else{
              //vbongiov -- 21/11/2006 
              if( solicitudIntegra.getPosiciones().length > 0){
                  //CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                  this.devolverSolicitud(solicitud);
              }
            }
        }

        DTOEstatusSolicitud dto = new DTOEstatusSolicitud();
        dto.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        if(log.isInfoEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.info("MONIncentivosBean.concursarSolicitudPorConcursos():Salida " + dto);
          
        return dto;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param arrConcursos
     * @param solicitud
     * jrivas inc. 22126 17/12/2005
     */
    public DTOEstatusSolicitud calcularPuntajeMontoUnidades(DTOSolicitudValidacion solicitud) throws MareException {
        ArrayList arrConcursos = new DAOConcursos().obtenerConcursosMontoUnidades(solicitud.getOidPais());
        DTOEstatusSolicitud dtoS = this.concursarSolicitudPorConcursos(solicitud, arrConcursos);
        return dtoS;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param arrConcursos
     * @param solicitud
     * jrivas inc. 22126 17/12/2005
     */
    public DTOEstatusSolicitud calcularPuntajeProgramaNuevas(DTOSolicitudValidacion solicitud) throws MareException {
        UtilidadesLog.info("MONIncentivosBean.calcularPuntajeProgramaNuevas():Entrada");
        ArrayList arrConcursos = new DAOConcursos().obtenerConcursosProgramaNuevas(solicitud.getOidPais());
        UtilidadesLog.info("MONIncentivosBean.calcularPuntajeProgramaNuevas():Salida");
        return this.concursarSolicitudPorConcursos(solicitud, arrConcursos);
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param arrConcursos
     * @param solicitud
     * jrivas inc. 22126 17/12/2005
     */
     public DTOEstatusSolicitud calcularPuntajeNumeroPedidos(DTOSolicitudValidacion solicitud) throws MareException {
        UtilidadesLog.info("MONIncentivosBean.calcularPuntajeNumeroPedidos():Entrada");
        ArrayList arrConcursos = new DAOConcursos().obtenerConcursosNumeroPedidos(solicitud.getOidPais());
        UtilidadesLog.info("MONIncentivosBean.calcularPuntajeNumeroPedidos():Salida");
        return this.concursarSolicitudPorConcursos(solicitud, arrConcursos);
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param arrConcursos
     * @param solicitud
     * jrivas inc. 22126 17/12/2005
     */
     public DTOEstatusSolicitud calcularPuntajeRecomendacion(DTOSolicitudValidacion solicitud) throws MareException {
        UtilidadesLog.info("MONIncentivosBean.calcularPuntajeRecomendacion():Entrada");
        ArrayList arrConcursos = new DAOConcursos().obtenerConcursosRecomendacion(solicitud.getOidPais());
        UtilidadesLog.info("MONIncentivosBean.calcularPuntajeRecomendacion():Salida");
        return this.concursarSolicitudPorConcursos(solicitud, arrConcursos);
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param SolicitudConcurso solicitudConcurso, Solicitud solicitud
     * jrivas INC-44 18/01/2006
     */
    private void actualizarDatosEvaluacionCandidata (SolicitudConcurso solicitudConcurso, Solicitud solicitud) throws MareException {
        DespacharPremiosHelper despacharHelper = new DespacharPremiosHelper();        
        Concurso concurso  = despacharHelper.obtenerConcurso(solicitudConcurso.getOidConcurso());
        DAOSolicitudActualizacion dao = new DAOSolicitudActualizacion();
        
        if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA())) {
            dao.actualizarCandidataGanadora(solicitudConcurso, solicitud, solicitud.getCliente().getOidCliente());
        } else {
            HashMap gerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
            Iterator itKeysGerentesParticipantes = gerentesParticipantes
                .keySet().iterator();

            while (itKeysGerentesParticipantes.hasNext()) {
                Long oidGerente = (Long) itKeysGerentesParticipantes.next();
                Boolean contenido = (Boolean) gerentesParticipantes.get(
                    oidGerente);

                if (contenido.booleanValue() == true) {
                    dao.actualizarCandidataGanadora(solicitudConcurso, solicitud, oidGerente);
                }
            }
        }

    }

  /**
   *  trata una solicitud de devolucion dentro del modulo de incentivos.
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoSolicitud
   * @author gPineda
   */
    public void devolverSolicitud(DTOSolicitudValidacion dtoSolicitud) throws MareException{
      UtilidadesLog.info("MONIncentivosBean.devolverSolicitud(DTOSolicitudValidacion dtoSolicitud) : Entrada");
      FactoriaConcurso factoriaConcurso = FactoriaConcurso.getFactoriaConcurso();
      ArrayList concursos = factoriaConcurso.getConcursos( dtoSolicitud.getOidPais() );
      
      if( IncetivosHelper.contieneConcursos(concursos).booleanValue() ){
        DAOSolicitudes daoSolicitudes = new DAOSolicitudes();
        Solicitud solicitud = daoSolicitudes.obtenerSolicitudDevolucion( dtoSolicitud );
        
        if( solicitud != null ){
        
            // 22/02/2007 - jrivas
            this.procesarCalificaciones(solicitud, concursos, true);
            boolean descartar = this.descartarSolicitudPorNoParticipante(solicitud);
            if (!descartar) {
        
                this.procesarPuntuaciones(solicitud, concursos);
                this.procesarEvaluaciones(solicitud, concursos);
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("solicitudDevolucion: "+solicitud);
                  
                this.procesarEvaluacionesDevolucion(solicitud, concursos);
            }
        }
      }
      UtilidadesLog.info("MONIncentivosBean.devolverSolicitud(DTOSolicitudValidacion dtoSolicitud) : Salida");
    }
    
   /**
    * Este metodo procesa las devoluciones con las que los clientes dejan de cumplir 
    * con alguna exigencia y transformandose asi en una anulacion.
    * @throws es.indra.mare.common.exception.MareException
    * @param ArrayList concursos
    * @param Solicitud solicitud
    * @author gPineda
    */
    public void procesarEvaluacionesDevolucion(Solicitud solicitud, ArrayList concursos) throws MareException{
      UtilidadesLog.info("MONIncentivosBean.procesarEvaluacionesDevolucion(Solicitud solicitud, ArrayList concursos): Entrada");
      ArrayList oids = new ArrayList(); // se usa ArrayList por no poder agrandar dinámicamente un Long[]
      ArrayList oidsSolicitudConcursoConIndAnulaCandidata = new ArrayList();
      Enumeration solicitudesConcursos = solicitud.getSolicitudConcursos().elements();      
      DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
      while( solicitudesConcursos.hasMoreElements() ){
        SolicitudConcurso solicitudConcurso = (SolicitudConcurso)solicitudesConcursos.nextElement();
        Concurso concurso = despacharPremiosHelper.obtenerConcurso( solicitudConcurso.getOidConcurso() );
        
        if( concurso.getIndDevolucion() ){
          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
            UtilidadesLog.debug("solicitudConcurso.getIndAnulaPedido(): "+ solicitudConcurso.getIndAnulaPedido() +" solicitudConcurso.getOidConcurso(): "+ solicitudConcurso.getOidConcurso());
            
          if( solicitudConcurso.getIndAnulaPedido() ){
            oids.add( solicitudConcurso.getOidConcurso() );
          }
          
          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
            UtilidadesLog.debug("solicitudConcurso.getIndAnulaCandidataGanadora(): "+ solicitudConcurso.getIndAnulaCandidataGanadora() +" solicitudConcurso.getOidConcurso(): "+ solicitudConcurso.getOidConcurso());
            
          if( solicitudConcurso.getIndAnulaCandidataGanadora() ){
            oidsSolicitudConcursoConIndAnulaCandidata.add( solicitudConcurso.getOidConcurso() );
          }
        }else{
          solicitud.getSolicitudConcursos().remove( solicitudConcurso.getOidConcurso() );
        }
        
      }
      this.actualizarDatosPuntuacion( solicitud, concursos);
      this.actualizarDatosEvaluacion( solicitud, concursos);

      int cantOids = oids.size();      
      if( cantOids > 0 ){
        solicitud.setIndAnulacion( true );
        solicitud.setIndDevolucion( true );

        // hay que pasarlo a Long[]
        Long [] arrayOids = new Long[cantOids];
        for( int i = 0; i < cantOids ; i++){
          arrayOids[i] = (Long)oids.get( i );
        }
        
        DTOOIDs dtoOidsConcursosParaAnular = new DTOOIDs();      
        AnularSolicitudesHelper anularHelper = new AnularSolicitudesHelper();
        dtoOidsConcursosParaAnular.setOids(arrayOids);
        anularHelper.tratarAnulacionDevolucion( solicitud, dtoOidsConcursosParaAnular, oidsSolicitudConcursoConIndAnulaCandidata );
      }
      UtilidadesLog.info("MONIncentivosBean.procesarEvaluacionesDevolucion(Solicitud solicitud, ArrayList concursos): Salida");
    }
    
    /**
     * Retorna una copia del objeto pasado por parametro.
     */
    private Object deepCopy(Object oldObj) throws MareException {
        UtilidadesLog.info("MONIncentivosBean.deepCopy(Object oldObj):Entrada");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
 
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
 
            oos.writeObject(oldObj);
            oos.flush();
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bin);
            UtilidadesLog.info("MONIncentivosBean.deepCopy(Object oldObj):Salida");
            return ois.readObject();
        } catch(Exception e) {
            UtilidadesLog.error("ERROR ", e);
            UtilidadesLog.debug("Exception en deepCopy = " + e);
            throw new MareException(e);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch(Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                UtilidadesLog.debug("Exception en deepCopy = " + ex);
                throw new MareException(ex);
            }
        }
    }


    //jrivas 29/11/2006 Cambio Cierre Incentivos Performance
    public DTOEstatusSolicitud concursarSolicitudPorConcursosCierre(DTOSolicitudValidacion solicitud, ArrayList arrConcursos) throws MareException  {
          UtilidadesLog.info("MONIncentivosBean.concursarSolicitudPorConcursosCierre():Entrada");        
          
          ArrayList concursos;
          if (arrConcursos == null) {
              FactoriaConcurso factoria = FactoriaConcurso.getFactoriaConcurso();
              concursos = factoria.getConcursos(solicitud.getOidPais());
          } else {
              concursos = arrConcursos;
          }
  
          if(IncetivosHelper.contieneConcursos(concursos).booleanValue()){
              Solicitud solicitudIntegra = this.obtenerDatosSolicitud(solicitud);

              if( ! solicitudIntegra.getIndDevolucion() ){
                  if( solicitudIntegra.getPosiciones().length > 0){
                  
                      Iterator it = concursos.iterator();
      
                      while (it.hasNext()) {
                          solicitudIntegra.getSolicitudConcurso(((Concurso) it.next()).getOidConcurso());                    
                      }
              
                      this.procesarCalificaciones(solicitudIntegra, concursos);
              
                      boolean descartar = this.descartarSolicitudPorNoParticipante(solicitudIntegra);
              
                      if (!descartar) {
                          this.procesarPuntuaciones(solicitudIntegra, concursos);        
                          this.procesarEvaluaciones(solicitudIntegra, concursos);
                      }                    
                  }                
              } else{
                if( solicitudIntegra.getPosiciones().length > 0){
                    this.devolverSolicitud(solicitud);
                }
              }
          }
  
          DTOEstatusSolicitud dto = new DTOEstatusSolicitud();
          dto.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
          UtilidadesLog.info("MONIncentivosBean.concursarSolicitudPorConcursosCierre():Salida " + dto);
          return dto;
    }

    //jrivas 5/12/2006 Cambio Cierre Incentivos Performance
    private void lockeaTabla(){
        try{
            StringBuffer queryFinal = new StringBuffer();
            queryFinal.append("SELECT OID_CONT_CORR_STOC FROM BEL_CONTR_CORRE_STOCK WHERE OID_CONT_CORR_STOC = 1 FOR UPDATE");
            this.executeQuery(queryFinal.toString());
        } catch ( Exception e ) {
            UtilidadesLog.error("ERROR",e);
        }       
    }
    
    //jrivas 5/12/2006 Cambio Cierre Incentivos Performance
    private void liberaTabla(){
        try{
            StringBuffer queryFinal = new StringBuffer();
            queryFinal.append("UPDATE BEL_CONTR_CORRE_STOCK SET FEC_ULTI_STOC = SYSDATE WHERE OID_CONT_CORR_STOC = 1");
            BelcorpService belcorpService = BelcorpService.getInstance();
            int cant = belcorpService.dbService.executeUpdate( queryFinal.toString() );
            if (cant == 0){
                queryFinal = new StringBuffer("INSERT INTO BEL_CONTR_CORRE_STOCK ( OID_CONT_CORR_STOC, FEC_ULTI_STOC ) VALUES ( 1, SYSDATE) ");
                belcorpService.dbService.executeUpdate( queryFinal.toString() );
            }
        } catch ( Exception e ) {
            UtilidadesLog.error("ERROR",e);
        }       
    }
    
   //jrivas 5/12/2006 Cambio Cierre Incentivos Performance
   private RecordSet executeQuery(String query) throws MareException {
    RecordSet rs = null;
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    return rs;
  }  

  //jrivas 5/12/2006 Cambio Cierre Incentivos Performance  
  public void insertaCandidata(Long oidConcurso, Long oidLiente, Long periodo, int numerPeriodosEvaluados, boolean metasSuperadas, boolean requisitosSuperados) throws MareException {
    this.lockeaTabla();
    DAOSolicitudActualizacion dao = new DAOSolicitudActualizacion();
    boolean aux = dao.actualizarCandidata(oidConcurso, oidLiente, periodo, numerPeriodosEvaluados);
    if (!aux) {
      dao.insertarCandidata(oidConcurso, oidLiente, periodo, numerPeriodosEvaluados, metasSuperadas, requisitosSuperados);
    }
    this.liberaTabla();
  }

  private MONIncentivosLocalHome getMONIncentivosLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONIncentivosLocalHome)context.lookup("java:comp/env/ejb/local/MONIncentivos");
  }

  private MONPremiacionHome getMONPremiacionHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONPremiacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPremiacion"), MONPremiacionHome.class);
  }
  
    private SolicitudConcursoPuntajeLocalHome getSolicitudConcursoPuntajeLocalHome() {
            return new SolicitudConcursoPuntajeLocalHome();
    }

  
}
