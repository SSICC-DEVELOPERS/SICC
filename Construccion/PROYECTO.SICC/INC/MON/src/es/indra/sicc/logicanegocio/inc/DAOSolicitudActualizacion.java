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
 * @author : Dante Castiglione
 * @author Noziglia C.
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.batch.util.ConfigFactory;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.entidades.inc.CalculoProductosExigidosLocal;
import es.indra.sicc.entidades.inc.CalculoProductosExigidosLocalHome;
import es.indra.sicc.entidades.inc.ClienteGerenteLocal;
import es.indra.sicc.entidades.inc.ClienteGerenteLocalHome;
import es.indra.sicc.entidades.inc.ClienteGerenteRecomendadoLocal;
import es.indra.sicc.entidades.inc.ClienteGerenteRecomendadoLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendadoLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendadoLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendadoMultinivelLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendadoMultinivelLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendanteLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendanteLocalHome;
import es.indra.sicc.entidades.inc.ClienteRecomendanteMultinivelLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendanteMultinivelLocalHome;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.DescalificacionesLocalHome;
import es.indra.sicc.entidades.inc.ExigenciasCumplidasLocal;
import es.indra.sicc.entidades.inc.ExigenciasCumplidasLocalHome;
import es.indra.sicc.entidades.inc.PedidoGerenteRecomendadoLocal;
import es.indra.sicc.entidades.inc.PedidoGerenteRecomendadoLocalHome;
import es.indra.sicc.entidades.inc.PedidoRecomendadoMultinivelLocal;
import es.indra.sicc.entidades.inc.PedidoRecomendadoMultinivelLocalHome;
import es.indra.sicc.entidades.inc.PedidoRecomendanteMultinivelLocal;
import es.indra.sicc.entidades.inc.PedidoRecomendanteMultinivelLocalHome;
import es.indra.sicc.entidades.inc.PedidosConcursoRecomendadaLocal;
import es.indra.sicc.entidades.inc.PedidosConcursoRecomendadaLocalHome;
import es.indra.sicc.entidades.inc.PuntajeProductosExigidosLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoPuntajeLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoPuntajeLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoRecomendadasLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoRecomendadasLocalHome;
import es.indra.sicc.entidades.inc.SolicitudGerenteRecomendadoLocal;
import es.indra.sicc.entidades.inc.SolicitudGerenteRecomendadoLocalHome;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.lang.Integer;
import java.lang.Long;

import java.text.SimpleDateFormat;

import javax.ejb.DuplicateKeyException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class DAOSolicitudActualizacion {
    private UtilidadesLog log = new UtilidadesLog();
    
    //sapaza -- PER-SiCC-2010-0455 -- 20/07/2010    
    private static final String UK_RECOMENDANTE  = "CLR3_UK";
    private static final String UK_RECOMENDADA  = "CLRE_UK";    
    
    public DAOSolicitudActualizacion() {
    }

    /**
     * Comentario: Este metodo utiliza las entidades ClienteRecomendante y 
     * ClienteRecomendado , porfavor recordar colocar las EJB Local references 
     * a estas entidades en el MON desde donde se llame a este metodo 
     */
    public void actualizarRecomendadaRecomendante(SolicitudConcurso 
        solicitudConcurso, Solicitud solicitud) throws MareException {
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarRecomendadaRe"
            +"comendante(SolicitudConcurso solicitudConcurso, Solicitud solici"
                +"tud):Entrada");

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("actualizarRecomendadaRecomendante solicitudConcur"
            +"so.getOidConcurso() " + solicitudConcurso.getOidConcurso());        
       
          UtilidadesLog.debug("actualizarRecomendadaRecomendante solicitud"
            +".getCliente().getOidCliente() " + solicitud.getCliente().getOidCliente());                
        }    

        ClienteRecomendanteLocalHome clienteRecomendanteHome = this.getClienteRecomendanteLocalHome();
            
        ClienteRecomendanteLocal clienteRecomendante = null;
        ClienteRecomendadoLocalHome clienteRecomendadoHome;
        ClienteRecomendadoLocal clienteRecomendado;

        // ----------------------------------------------------------------------------------------
        // JVM, sicc 20070381, "contenidoEn" VinculoRecomendante, DES-HAS, crea ClienteRecomendante
        // ----------------------------------------------------------------------------------------    
        boolean fCrea = false;
        
        DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
        Concurso concurso = desPreH.obtenerConcurso(solicitudConcurso.getOidConcurso());
        
        if (solicitud.getCliente().getClienteRecomendante() != null && solicitud.getCliente().getClienteRecomendado().size() > 0) {
           if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010            
             UtilidadesLog.debug("JVMXYZ, solicitud.getCliente().getClienteRecomendante().getRecomendate (oid)="+solicitud.getCliente().getClienteRecomendante().getRecomendante());
             
           fCrea = solicitud.getCliente().getClienteRecomendante().getPeriodo().contenidoEn(concurso.getPeriodoDesde(), concurso.getPeriodoHasta());
        } else {
           if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
             UtilidadesLog.debug("JVMXYZ, solicitud.getCliente().getClienteRecomendante() IS NULL");
             
           fCrea = solicitud.getCliente().getPeriodo().contenidoEn(concurso.getPeriodoDesde(), concurso.getPeriodoHasta() );
        }
                                                             
        if (fCrea) {
                // ---------------------------------------------------------------------------------    
                try {
                    clienteRecomendante = clienteRecomendanteHome.findByUK(solicitud.getCliente().getClienteRecomendante().getRecomendante(),
                                                                                    solicitudConcurso.getOidConcurso());
                    UtilidadesLog.debug(" clienteRecomendante.findByUk, FOUND");                                                                   
                } catch (NoResultException fe) {
                    UtilidadesLog.debug(" clienteRecomendante.findByUk, NOT_FOUND");                                                                   
                    try {
                        clienteRecomendante = clienteRecomendanteHome.create(solicitud.getCliente().getClienteRecomendante().getRecomendante(),                         
                                                                                    solicitudConcurso.getOidConcurso());

                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                                                    
                          UtilidadesLog.debug(" clienteRecomendante.create, CREATED, with  OID: " + clienteRecomendante.getOid());                                                                                                                   
                    } catch (PersistenceException ce) {
                        if(ce.getMessage().indexOf(UK_RECOMENDANTE)<0) { //sapaza -- PER-SiCC-2010-0455 -- 20/07/2010                        
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        } else {
                            clienteRecomendante = clienteRecomendanteHome.findByUK(solicitud.getCliente().getClienteRecomendante().getRecomendante(),
                                                                                            solicitudConcurso.getOidConcurso());
                        }
                    }
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
        
                try {
                    clienteRecomendadoHome = this.getClienteRecomendadoLocalHome();
                    clienteRecomendado = clienteRecomendadoHome.findByUK(clienteRecomendante.getOid(), 
                                                                                    solicitud.getCliente().getOidCliente());
                    UtilidadesLog.debug(" clienteRecomendado.findByUK, FOUND");                                                                                                                   
                    //jrivas 18/8/2006 DBLG50001117
                    clienteRecomendado.setEfectiva(Boolean.FALSE);
                    clienteRecomendadoHome.merge(clienteRecomendado);
                } catch (NoResultException fe) {
                    try {
                        UtilidadesLog.debug(" clienteRecomendado.findByUK, NOT_FOUND");
                        clienteRecomendadoHome = this.getClienteRecomendadoLocalHome();
                        clienteRecomendado = clienteRecomendadoHome.create(solicitud.getCliente().getOidCliente(), 
                                                                                solicitud.getCliente().getPeriodo().getOidPeriodo(),  // JVM, sicc 20070381, solicitud.getPeriodo().getOidPeriodo(), 
                                                                                clienteRecomendante.getOid()); 
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                                                
                          UtilidadesLog.debug(" clienteRecomendadoHome.create, CREATED, with OID:"+clienteRecomendado .getOid());                                                                                                                   
                    } catch (PersistenceException ce) {
                        if(ce.getMessage().indexOf(UK_RECOMENDADA)<0) { //sapaza -- PER-SiCC-2010-0455 -- 20/07/2010
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }        
                    }            
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

        }
 
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarRecomendadaRecomendante(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Salida");
    }

    /**
     * Actuliza las entidades recomendada mulitnivel y recomendante mulinivel.
     * Este metodo utiliza las entidades ClienteRecomendanteMultinivel y Clien-
     * teRecomendadoMultinivel.
     */
    public void actualizarRecomendadaRecomendanteMultinivel(SolicitudConcurso 
        solicitudConcurso, Solicitud solicitud) throws MareException {
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarRecomendadaRe"
            +"comendanteMultinivel(SolicitudConcurso solicitudConcurso, "
            +"Solicitud solicitud):Entrada");
            
        ClienteRecomendanteMultinivelLocalHome 
            clienteRecomendanteMultinivelHome;
        ClienteRecomendanteMultinivelLocal clienteRecomendanteMultinivel=null;
        ClienteRecomendadoMultinivelLocalHome clienteRecomendadoMultinivelHome;
        ClienteRecomendadoMultinivelLocal clienteRecomendadoMultinivel;      
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("solicitudConcurso.getOidConcurso() " + 
            solicitudConcurso.getOidConcurso());        
          UtilidadesLog.debug("solicitud.getCliente().getOidCliente() " + 
            solicitud.getCliente().getOidCliente());                
        }    

        // 1.- Actualizamos la entidad ClienteRecomendanteMultinivel
        clienteRecomendanteMultinivelHome = this.getClienteRecomendanteMultinivelLocalHome();
            
        if(solicitud.getCliente().getIndRecomendante()){
            try {
                clienteRecomendanteMultinivel = clienteRecomendanteMultinivelHome.findByUK(solicitud.getCliente().getOidCliente(), 
                                                                                        solicitudConcurso.getOidConcurso());
                UtilidadesLog.debug(" entidad ClienteRecomendanteMultinivel lo encontre");                                                                   
            } catch (NoResultException fe) {
                UtilidadesLog.debug(" entidad ClienteRecomendanteMultinivel no lo encontre");                                                                   
                try {
                    clienteRecomendanteMultinivel = clienteRecomendanteMultinivelHome.create(solicitud.getCliente().getOidCliente(), 
                                                                    solicitudConcurso.getOidConcurso());
                                                                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                                    
                      UtilidadesLog.debug(" ClienteRecomendanteMultinivel lo cree OID: " + clienteRecomendanteMultinivel.getOid());
    
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        // 2.- Actualizamos la entidad ClienteRecomendadaMultinivel
        if(solicitud.getCliente().getClienteRecomendante()!=null){

            //jrivas BUSCO RECOMENDANTE
            try {
                clienteRecomendanteMultinivel = clienteRecomendanteMultinivelHome.findByUK(solicitud.getCliente().getClienteRecomendante().getRecomendante(), 
                                                            solicitudConcurso.getOidConcurso());
                UtilidadesLog.debug(" entidad ClienteRecomendanteMultinivel lo encontrev 2");                                                                   
            } catch (NoResultException fe) {
                UtilidadesLog.debug(" entidad ClienteRecomendanteMultinivel no lo encontre 2");                                                                   
                try {
                    clienteRecomendanteMultinivel = clienteRecomendanteMultinivelHome.create(solicitud.getCliente().getClienteRecomendante().getRecomendante(), 
                        solicitudConcurso.getOidConcurso());
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                        
                      UtilidadesLog.debug(" ClienteRecomendanteMultinivel lo cree 2 OID: " + clienteRecomendanteMultinivel.getOid());
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            //LO BUSQUÉ

            try {
                clienteRecomendadoMultinivelHome = this.getClienteRecomendadoMultinivelLocalHome();
                clienteRecomendadoMultinivel = clienteRecomendadoMultinivelHome.findByUK(solicitud.getCliente().getOidCliente(), 
                                                                        clienteRecomendanteMultinivel.getOid());
                UtilidadesLog.debug(" entidad ClienteRecomendadoMultinivel lo encontre");                                                                                                                   
            } catch (NoResultException fe) {
                try {
                    UtilidadesLog.debug(fe);
                    UtilidadesLog.debug(" entidad ClienteRecomendadoMultinivel no lo encontre");
                    clienteRecomendadoMultinivelHome = this.getClienteRecomendadoMultinivelLocalHome();
                    clienteRecomendadoMultinivel = clienteRecomendadoMultinivelHome.create(solicitud.getCliente().getOidCliente(),
                                                                            clienteRecomendanteMultinivel.getOid(), solicitud
                                                                                .getPeriodo().getOidPeriodo());
                    UtilidadesLog.debug(" entidad ClienteRecomendadoMultinivel lo cree");                                                                                                                   
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }            
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarRecomendadaRe"
            +"comendanteMultinivel(SolicitudConcurso solicitudConcurso, Solici"
            +"tud solicitud):Salida");
    }


    /**
     * Comentario: Este metodo utiliza la entidades SolicitudConcursoRecomenda
     * das , porfavorrecordar colocarla EJB Local reference a esta entidad en
     * el MON desde donde se llame a este metodo
     */
    public void actualizarSolicitudConcursoRecomendante(
                                                            SolicitudConcurso   solicitudConcurso, 
                                                            Solicitud           solicitud) 
    throws MareException 
    {
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSolicitudConcursoRecomendante"+
                "(SolicitudConcurso solicitudConcurso, Solicitudsolicitud):Entrada");
                
        // --------------------------------------------------------------------------------------------
        // JVM, sicc 20070381, "contenidoEn" Solicitud DES-(HAS + (NUMPEDIDOS - 1)), crea solicitudConcursoRecomendadas
        // --------------------------------------------------------------------------------------------
        DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
        Concurso concurso = desPreH.obtenerConcurso(solicitudConcurso.getOidConcurso());
        
        Integer numPeriodosAEvaluar = new Integer(0);
        
        if ( concurso.getNumeroPeriodosAEvaluar() != null && concurso.getNumeroPeriodosAEvaluar().longValue() > 0){
            numPeriodosAEvaluar = new Integer(concurso.getNumeroPeriodosAEvaluar().intValue() - 1);
        }        
                           
        boolean fCrea = false;                           

        Periodo periodo = this.buscaPeridoVinculoRecomendante(solicitudConcurso, solicitud);

        if (periodo != null){
            fCrea = periodo.contenidoEn(    concurso.getPeriodoDesde(), 
                                            concurso.getPeriodoHasta().calcularPeriodoPosterior(numPeriodosAEvaluar)
                                        );
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("JVM-actualizarSolicitudConcursoRecomendante, fCrea="+fCrea);
                                      
        if (fCrea)
        {
                SolicitudConcursoRecomendadasLocalHome solicitudConcursoRecomendadasHome = this.getSolicitudConcursoRecomendadasLocalHome();
                SolicitudConcursoRecomendadasLocal solicitudConcursoRecomendadas = null;
        
                try {
                    solicitudConcursoRecomendadas = solicitudConcursoRecomendadasHome.findByUKSinGerente(solicitudConcurso.getOidConcurso(), 
                                                        solicitud.getOidSolicitud());

                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug(    "JVMXYZ, SOL. RCTE, FOUND => "+
                                    "solicitudConcurso.getOidConcurso()=" + solicitudConcurso.getOidConcurso() + 
                                    "solicitud.getOidSolicitud()=" + solicitud.getOidSolicitud());
                    
                    if( solicitudConcurso.getTipoVinculo().equals(ConstantesINC.TIPO_VINC_AMBOS) && 
                        ( solicitudConcursoRecomendadas.getRecomendado() != null && solicitudConcursoRecomendadas.getRecomendante() != null)) {
                        try {
            
                            solicitudConcursoRecomendadas = solicitudConcursoRecomendadasHome.create(
                                                solicitudConcurso.getOidConcurso(),
                                                solicitud.getOidSolicitud(), 
                                                solicitud.getCliente().getOidCliente(),
                                                solicitud.getPeriodo().getOidPeriodo(), 
                                                null); 
                            //jrivas inc 
                            //19631 22/7/2005
                           
                            UtilidadesLog.debug("JVMXYZ, SOL. RCTE. ");
                            
                        } catch (PersistenceException ce) {
                            //UtilidadesLog.debug(ce);
                            //throw new MareException(fe, UtilidadesError.armarCodigoError(
                            //CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }            
                    }
        
                } catch (NoResultException fe) {
                    UtilidadesLog.debug(fe);
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug(    "JVMXYZ, SOL. RCTE, NOT FOUND => "+
                                    "solicitudConcurso.getOidConcurso()=" + solicitudConcurso.getOidConcurso() + 
                                    "solicitud.getOidSolicitud()=" + solicitud.getOidSolicitud());                    

                    try {
        
                        solicitudConcursoRecomendadas = solicitudConcursoRecomendadasHome.create(solicitudConcurso.getOidConcurso(),
                                                                        solicitud.getOidSolicitud(), 
                                                                        solicitud.getCliente().getOidCliente(),
                                                                        solicitud.getPeriodo().getOidPeriodo(), 
                                                                        null); 

                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("JVMXYZ, SOL. RCTE, CREADO, OID=>"+solicitudConcursoRecomendadas.getOid());                        

                    } catch (PersistenceException ce) {
                        //UtilidadesLog.debug(ce);
                        //throw new MareException(fe, UtilidadesError.armarCodigoError(
                        //CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                } catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                solicitudConcursoRecomendadas.setFechaDocumento(solicitud.getFechaDocumento());
                solicitudConcursoRecomendadas.setMontoSolicitud(solicitudConcurso.getMontoValido());
                
                if (solicitudConcurso.getUnidadesValidas() != null) {
                    solicitudConcursoRecomendadas.setUnidadesSolicitud(new Integer(solicitudConcurso.getUnidadesValidas().intValue()));
                }
                
                solicitudConcursoRecomendadas.setSolicitudValida(new Boolean(true));
                solicitudConcursoRecomendadasHome.merge(solicitudConcursoRecomendadas);
                
        // vbongiov -- Cambio 20090841 -- 6/07/2009
        } else {
            this.guardaSolicitudConcursoRecomendadoTemporal(solicitudConcurso, solicitud);
        }
        
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSolicitudConcursoRecomendante(SolicitudConcurso solicitudConcurso, Solicitudsolicitud):Salida");
    }


    /**
     * Comentario: Este metodo utiliza la entidades SolicitudConcursoRecomen
     * dadas , porfavor recordar colocar la EJB Local reference a esta entidad 
     * en el MON desde donde se llame a este metodo
     */
    public void actualizarSolicitudConcursoRecomendado
    (
        SolicitudConcurso   solicitudConcurso, 
        Solicitud           solicitud
    ) throws MareException 
    {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSolicitudConcursoRecomendado(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Entrada");

        SolicitudConcursoRecomendadasLocalHome solicitudConcursoRecomendadasHome = this.getSolicitudConcursoRecomendadasLocalHome();
        SolicitudConcursoRecomendadasLocal solicitudConcursoRecomendadas = null;

        // --------------------------------------------------------------------------------------------
        // JVM, sicc 20070381, "contenidoEn" Solicitud DES-(HAS + (NUMPEDIDOS - 1)), crea solicitudConcursoRecomendadas
        // --------------------------------------------------------------------------------------------
        DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
        Concurso concurso = desPreH.obtenerConcurso(solicitudConcurso.getOidConcurso());
        
        Integer numPeriodosAEvaluar = new Integer(0);
        
        if ( concurso.getNumeroPeriodosAEvaluar() != null && concurso.getNumeroPeriodosAEvaluar().longValue() > 0){
            numPeriodosAEvaluar = new Integer(concurso.getNumeroPeriodosAEvaluar().intValue() - 1);
        }        
                           
        boolean fCrea = false;                           

        if(solicitud.getCliente().getClienteRecomendado().size() > 0) {        
            Periodo periodo = this.buscaPeridoVinculoRecomendante(solicitudConcurso, solicitud);
            
            if(periodo != null){
                fCrea = periodo.contenidoEn( concurso.getPeriodoDesde(), concurso.getPeriodoHasta());

                if(solicitud.getCliente().getClienteRecomendante() != null){
                    fCrea = solicitud.getCliente().getClienteRecomendante().getPeriodo().contenidoEn(concurso.getPeriodoDesde(), 
                                                    concurso.getPeriodoHasta());
                }
                if (fCrea) {
                    fCrea = solicitud.getPeriodo().contenidoEn(concurso.getPeriodoDesde(), 
                                    concurso.getPeriodoHasta().calcularPeriodoPosterior(numPeriodosAEvaluar));
                }
            }          
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("JVM-getClienteRecomendado().size() > 0, actualizarSolicitudConcursoRecomendado, fCrea="+fCrea);
        } else {
                fCrea = solicitud.getCliente().getPeriodo().contenidoEn(concurso.getPeriodoDesde(), 
                                        concurso.getPeriodoHasta());
                if (fCrea) {
                    fCrea = solicitud.getPeriodo().contenidoEn(concurso.getPeriodoDesde(), 
                                    concurso.getPeriodoHasta().calcularPeriodoPosterior(numPeriodosAEvaluar));
                }                     
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("JVM-getClienteRecomendado().size() <= 0, actualizarSolicitudConcursoRecomendado, fCrea="+fCrea);                                    
        }
        if (fCrea){
            try {        
                solicitudConcursoRecomendadas = solicitudConcursoRecomendadasHome.findByUKSinGerente(solicitudConcurso.getOidConcurso(), 
                                        solicitud.getOidSolicitud());
                                        
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                        
                  UtilidadesLog.debug(    "JVMXYZ, SOL. RCDO, FOUND => "+
                                        "solicitudConcurso.getOidConcurso()=" + solicitudConcurso.getOidConcurso() + 
                                        "solicitud.getOidSolicitud()=" + solicitud.getOidSolicitud());
            } catch (NoResultException fe) {
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug(    "JVMXYZ, SOL. RCDO, NOT FOUND => "+
                                        "solicitudConcurso.getOidConcurso()=" + solicitudConcurso.getOidConcurso() + 
                                        "solicitud.getOidSolicitud()=" + solicitud.getOidSolicitud());
    
                try {
                    solicitudConcursoRecomendadas = solicitudConcursoRecomendadasHome.create(
                                    solicitudConcurso.getOidConcurso(), 
                                    solicitud.getOidSolicitud(),
                                    solicitud.getCliente().getClienteRecomendante().getRecomendante(), 
                                    solicitud.getPeriodo().getOidPeriodo(), 
                                    null);//jrivas inc 19631 
                                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                    
                      UtilidadesLog.debug("JVMXYZ, SOL. RCDO, CREADO, OID=>"+solicitudConcursoRecomendadas.getOid()); 
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                }
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            solicitudConcursoRecomendadas.setFechaDocumento(solicitud.getFechaDocumento());
            solicitudConcursoRecomendadas.setMontoSolicitud(solicitudConcurso.getMontoValido());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** solicitudConcurso.getUnidadesValidas(): " + solicitudConcurso.getUnidadesValidas());
                
            if (solicitudConcurso.getUnidadesValidas() != null) {
                solicitudConcursoRecomendadas.setUnidadesSolicitud(new Integer(solicitudConcurso.getUnidadesValidas().intValue()));
            }
            solicitudConcursoRecomendadas.setRecomendado(solicitud.getCliente().getOidCliente());
                
            solicitudConcursoRecomendadas.setSolicitudValida(new Boolean(true));
            
            solicitudConcursoRecomendadasHome.merge(solicitudConcursoRecomendadas);
        
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSolicitudCon"
            +"cursoRecomendado(SolicitudConcurso solicitudConcurso, Solicitud "
            +"solicitud):Salida");
    }

    /**
     * Comentario: Este metodo utiliza la entidad PedidosConcursoRecomendada , 
     * por favor recordar colocar la EJB Local reference a esta entidad en
     * el MON desde donde se llame a este metodo
     */
    public void actualizarPedidoConcursoRecomendante
                                        (       Solicitud               solicitud, 
                                                SolicitudConcurso       solicitudConcurso
                                        ) throws MareException 
    {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoConcurso"
            +"Recomendante(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Concurso):Entrada");
            
        PedidosConcursoRecomendadaLocalHome pedidosConcursoRecomendadaHome = this.getPedidosConcursoRecomendadaLocalHome();
        PedidosConcursoRecomendadaLocal pedidosConcursoRecomendada;
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendante solicitud.getCliente().getOidCliente() " 
                                + solicitud.getCliente().getOidCliente());

          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendante solicitudConcurso.getOidConcurso() " 
                                + solicitudConcurso.getOidConcurso());
                                                               
          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendante solicitudConcurso.getMontoValido() " 
                                + solicitudConcurso.getMontoValido());
                                
          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendante solicitudConcurso.getUnidadesValidas() " 
                                + solicitudConcurso.getUnidadesValidas());
                                
          UtilidadesLog.debug("actualizarPedidoConcursoRecomendante solicitud.getPeriodo().getOidPeriodo() " 
                                + solicitud.getPeriodo().getOidPeriodo() );
        }                        

        //jrivas 17/8/2005 
        //inc. 20556
        
        ClienteRecomendanteLocalHome clienteRecomendanteHome = this.getClienteRecomendanteLocalHome();

        UtilidadesLog.debug("ClienteRecomendanteLocal clienteRecomendante = null");
        ClienteRecomendanteLocal clienteRecomendante = null;

        try {
        
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
              UtilidadesLog.debug("findByUK");        
              UtilidadesLog.debug("solicitudConcurso.getOidConcurso()="+solicitudConcurso.getOidConcurso());                
              UtilidadesLog.debug("solicitud.getCliente().getOidCliente()="+solicitud.getCliente().getOidCliente());
            }    

            clienteRecomendante = clienteRecomendanteHome.findByUK(solicitud.getCliente().getOidCliente(), solicitudConcurso.getOidConcurso());
                        
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                        
              UtilidadesLog.debug(" clienteRecomendanteHome.findByUK, FOUND, clienteRecomendante " + clienteRecomendante.getOid()); 
              
            pedidosConcursoRecomendadaHome = this.getPedidosConcursoRecomendadaLocalHome();
            pedidosConcursoRecomendada = pedidosConcursoRecomendadaHome.findRecomendante(clienteRecomendante.getOid(),
                                                                                            solicitudConcurso.getOidConcurso(),
                                                                                            solicitud.getPeriodo().getOidPeriodo());

            pedidosConcursoRecomendada.setMontoPedido(pedidosConcursoRecomendada.getMontoPedido().add( solicitudConcurso.getMontoValido()) );
            pedidosConcursoRecomendada.setUnidadesPedido(new Integer( pedidosConcursoRecomendada.getUnidadesPedido().intValue() +
                                                                                solicitudConcurso.getUnidadesValidas().intValue()) );
            pedidosConcursoRecomendadaHome.merge(pedidosConcursoRecomendada);
        } catch (NoResultException fe) {
            try {

                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug(" clienteRecomendanteHome.findByUK, NOT_FOUND");                
                  UtilidadesLog.debug(" solicitud.getPeriodo().getOidPeriodo()="+solicitud.getPeriodo().getOidPeriodo());
                  UtilidadesLog.debug(" solicitudConcurso.getOidConcurso()="+solicitudConcurso.getOidConcurso());
                }  
                
                // JVM, sicc 20070381, if para consistenciar create INC_PEDID_CONCU_RECOM 
                 if (clienteRecomendante != null)  {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug(" clienteRecomendante.getOid()="+clienteRecomendante.getOid());
                    
                        pedidosConcursoRecomendada = pedidosConcursoRecomendadaHome.create(solicitud.getPeriodo().getOidPeriodo(),
                                                                                solicitudConcurso.getOidConcurso(), 
                                                                                clienteRecomendante.getOid(), 
                                                                                null, null);
                          
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                     
                          UtilidadesLog.debug(" clienteRecomendanteHome.findByUK, CREATED, with oid: " + clienteRecomendante.getOid());                         
                          
                        pedidosConcursoRecomendada.setMontoPedido(solicitudConcurso.getMontoValido());
                        pedidosConcursoRecomendada.setUnidadesPedido(new Integer(solicitudConcurso.getUnidadesValidas().intValue()));
                        pedidosConcursoRecomendadaHome.merge(pedidosConcursoRecomendada);
                        
                // vbongiov -- Cambio 20090841 -- 6/07/2009        
                } else {                

                    Concurso concurso  = new DespacharPremiosHelper().obtenerConcurso(solicitudConcurso.getOidConcurso());
                    this.actualizarPedidoConcursoRecomendadoTemporal(solicitudConcurso, solicitud, concurso);     
                }
                
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                //throw new MareException(ce, UtilidadesError.armarCodigoError
                //(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoConcursoRecomendante(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
    }

    /**
     * Comentario: Este metodo utiliza la entidad PedidosConcursoRecomendada , 
     * por favor recordar colocar la EJB Local reference a esta entidad
     *  en el MON desde donde se llame a este metodo
     */
    public void actualizarPedidoConcursoRecomendado(    
                                                        Solicitud           solicitud, 
                                                        SolicitudConcurso   solicitudConcurso, 
                                                        Concurso            concurso
        )
        throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoConcurso"
            +"Recomendado(Solicitud solicitud, SolicitudConcurso solicitudCon"
            +"curso, Concurso concurso):Entrada");

        PedidosConcursoRecomendadaLocalHome pedidosConcursoRecomendadaLocalHome = this.getPedidosConcursoRecomendadaLocalHome();
        PedidosConcursoRecomendadaLocal pedidosConcursoRecomendadaLocal;

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendado solicitud.getCliente().getClienteRecomendante().getRecomendante() " 
            + solicitud.getCliente().getClienteRecomendante().getRecomendante());
                
          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendado solicitudConcurso.getOidConcurso() " 
            + solicitudConcurso.getOidConcurso());
            
          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendado solicitud.getCliente().getOidCliente() " 
            + solicitud.getCliente().getOidCliente());
            
          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendado solicitud Concurso.getMontoValido() " 
            + solicitudConcurso.getMontoValido());
            
          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendado solicitudConcurso.getUnidadesValidas() " 
            + solicitudConcurso.getUnidadesValidas());
            
          UtilidadesLog.debug(" actualizarPedidoConcursoRecomendado solicitud.getPeriodo().getOidPeriodo() " 
            + solicitud.getPeriodo().getOidPeriodo() );
        }    

        ClienteRecomendanteLocalHome clienteRecomendanteHome = this.getClienteRecomendanteLocalHome();
        ClienteRecomendanteLocal clienteRecomendante = null;
        ClienteRecomendadoLocalHome clienteRecomendadoHome = this.getClienteRecomendadoLocalHome();
        ClienteRecomendadoLocal clienteRecomendado = null;

        boolean fCrea = false;

        try {
            clienteRecomendante = clienteRecomendanteHome.findByUK(solicitud.getCliente().getClienteRecomendante().getRecomendante(),
                                                                            solicitudConcurso.getOidConcurso());
                                                                            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                                            
              UtilidadesLog.debug(" actualizarPedidoConcursoRecomendado clienteRecomendante " + clienteRecomendante.getOid());
              
            clienteRecomendado = clienteRecomendadoHome.findByUK(clienteRecomendante.getOid(), solicitud.getCliente().getOidCliente());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug(" actualizarPedidoConcursoRecomendado clienteRecomendado " + clienteRecomendado.getOid());
            fCrea=true;
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            UtilidadesLog.debug(" actualizarPedidoConcursoRecomendado no lo encontre");                                                                   
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }                                                                   

        //Jrivas 6/7/2005
        //Inc 19733
        if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA()) && fCrea) {
            try {
            
                //jrivas 17/8/2005 20556 //solicitud.getCliente()
                //.getClienteRecomendante().getRecomendante(),//.getCliente()
                //.getOidCliente(),
                pedidosConcursoRecomendadaLocal = pedidosConcursoRecomendadaLocalHome.findByUKConsultora(clienteRecomendante.getOid(),solicitudConcurso
                                                                                    .getOidConcurso(),clienteRecomendado.getOid(),
                                                                                    solicitud.getPeriodo().getOidPeriodo());

                pedidosConcursoRecomendadaLocal.setMontoPedido(
                            pedidosConcursoRecomendadaLocal.getMontoPedido().add(
                                solicitudConcurso.getMontoValido()));
                pedidosConcursoRecomendadaLocal.setUnidadesPedido(new Integer(
                            pedidosConcursoRecomendadaLocal.getUnidadesPedido()
                            .intValue() +solicitudConcurso.getUnidadesValidas()
                            .intValue()));
                pedidosConcursoRecomendadaLocalHome.merge(pedidosConcursoRecomendadaLocal);
            } catch (NoResultException fe) {
                try {
                    UtilidadesLog.debug(fe);
                    //jrivas 17/8/2005 20556 //solicitud.getCliente().
                    //getClienteRecomendante().getRecomendante());
                    pedidosConcursoRecomendadaLocal = pedidosConcursoRecomendadaLocalHome.create(solicitud.getPeriodo().getOidPeriodo(),
                                                                    solicitudConcurso.getOidConcurso(),
                                                                    clienteRecomendante.getOid(), clienteRecomendado.getOid(),  null ); 
                         
                    pedidosConcursoRecomendadaLocal.setMontoPedido(solicitudConcurso.getMontoValido());
                        
                    pedidosConcursoRecomendadaLocal.setUnidadesPedido(
                                                    new Integer(solicitudConcurso.getUnidadesValidas()
                                                    .intValue()));
                    pedidosConcursoRecomendadaLocalHome.merge(pedidosConcursoRecomendadaLocal);
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    //throw new MareException(ce, UtilidadesError.armarCodigo
                    //Error(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } else {
            if (ConstantesINC.TIPO_GERENTE.equals(concurso.getDirigidoA())) {
                HashMap hmGerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
                Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet().iterator();

                while (itKeysGerentesParticipantes.hasNext()) {
                    Long oidGerente = (Long) itKeysGerentesParticipantes.next();
                    Boolean contenido = (Boolean) hmGerentesParticipantes.get(oidGerente);

                    if (contenido.booleanValue() == true) {
                        try {
                            //jrivas 17/8/2005 20556 //solicitud.getCliente()
                            //.getClienteRecomendante().getRecomendante(),
                            pedidosConcursoRecomendadaLocal = pedidosConcursoRecomendadaLocalHome.findByUKGerente(
                                                                                    clienteRecomendante.getOid(),
                                                                                    solicitudConcurso.getOidConcurso(),
                                                                                    clienteRecomendado.getOid(), oidGerente, 
                                                                                    solicitud.getPeriodo().getOidPeriodo());

                            pedidosConcursoRecomendadaLocal.setMontoPedido(
                                                    pedidosConcursoRecomendadaLocal
                                                    .getMontoPedido().add(solicitudConcurso
                                                    .getMontoValido()));
                            pedidosConcursoRecomendadaLocal.setUnidadesPedido(
                                                        new Integer(pedidosConcursoRecomendadaLocal
                                                        .getUnidadesPedido().intValue() + solicitudConcurso
                                                        .getUnidadesValidas().intValue()));
                            pedidosConcursoRecomendadaLocalHome.merge(pedidosConcursoRecomendadaLocal);
                        } catch (NoResultException fe) {
                            try {
                                UtilidadesLog.debug(fe);
                                //jrivas 17/8/2005 20556 //solicitud.getCliente
                                //().getClienteRecomendante().
                                //getRecomendante());
                                pedidosConcursoRecomendadaLocal = pedidosConcursoRecomendadaLocalHome.create(solicitud.getPeriodo()
                                                                .getOidPeriodo(), solicitudConcurso
                                                                .getOidConcurso(),clienteRecomendante
                                                                .getOid(),clienteRecomendado.getOid(),
                                                                oidGerente); 
                                pedidosConcursoRecomendadaLocal.setMontoPedido(solicitudConcurso.getMontoValido());
                                pedidosConcursoRecomendadaLocal.setUnidadesPedido(new Integer(
                                                                solicitudConcurso.getUnidadesValidas()
                                                                .intValue()));
                                pedidosConcursoRecomendadaLocalHome.merge(pedidosConcursoRecomendadaLocal);
                            } catch (PersistenceException ce) {
                                UtilidadesLog.error("ERROR ", ce);
                                throw new MareException(ce, UtilidadesError
                                .armarCodigoError(CodigosError
                                .ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        } catch (PersistenceException ce) {
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }
                }
            }
        }
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoConcurs"
            +"Recomendado(Solicitud solicitud, SolicitudConcurso solicitudCon"
            +"curso, Concurso concurso):Salida");
    }


    /**
     * Se indica que se han cumplidos las exigencias de un concurso para un 
     * periodo.
     *
     * Comentario: Este metodo utiliza la entidad ExigenciasCumplidas , por 
     * favor recordar colocar la EJB Local reference a esta entidad
     *  en el MON desde donde se llame a 
     * este metodo
     *
     */
    public void activarExigenciasCumplidas(Solicitud solicitud, 
        SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.activarExigenciasCumpli"
            +"das(Solicitud solicitud, SolicitudConcurso solicitudConcurso):"
            +"Entrada");

        ExigenciasCumplidasLocalHome exigenciasCumplidasHome = this.getExigenciasCumplidasLocalHome();
        ExigenciasCumplidasLocal exigenciasCumplidas = null;
        
        // vbongiov 31/03/2006 inc 22826
        FactoriaConcurso factoria= FactoriaConcurso.getFactoriaConcurso();
       
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = {solicitudConcurso.getOidConcurso() };
        dtoOids.setOids(oids);
  
        ArrayList concursos = factoria.getConcursosPorOID(dtoOids);
        Concurso concurso = (Concurso) concursos.get(0);
        
         if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA())) {
              if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                UtilidadesLog.debug("ConstantesINC.TIPO_CONSULTORA");
                UtilidadesLog.debug("solicitud.getCliente().getOidCliente(): " + solicitud.getCliente().getOidCliente());
                UtilidadesLog.debug("solicitudConcurso.getOidConcurso(): " + solicitudConcurso.getOidConcurso());
                UtilidadesLog.debug("solicitud.getPeriodo().getOidPeriodo(): " + solicitud.getPeriodo().getOidPeriodo());
              }  
               
              try {
                  exigenciasCumplidas = exigenciasCumplidasHome.findByUK(
                                          solicitud.getCliente().getOidCliente(), 
                                          solicitudConcurso.getOidConcurso(),
                                          solicitud.getPeriodo().getOidPeriodo());
                          
                  UtilidadesLog.debug("lo encontre ");      
                  
                  // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                  if( solicitudConcurso.getIndAnulaPedido() &&
                      ( solicitud.getIndAnulacion() || solicitud.getIndDevolucion() ) ){
                    exigenciasCumplidas.setExigenciasCumplidas( new Boolean(false) );
                  }else{
                    exigenciasCumplidas.setFechaCumplimiento(new Date(System.currentTimeMillis()));
                  }
                  exigenciasCumplidasHome.merge(exigenciasCumplidas);
                  
              } catch (NoResultException fe) {
                  UtilidadesLog.debug(fe);
                  UtilidadesLog.debug(" No lo encontre, lo inserto ");
                  
                  // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                  if(  solicitud.getIndAnulacion() == false && solicitud.getIndDevolucion() == false  ){
                      try {
                          exigenciasCumplidas = exigenciasCumplidasHome.create(
                                                  new Boolean(solicitudConcurso
                                                      .getExigenciasCumplidasEnSolicitud()),
                                                      solicitudConcurso.getOidConcurso(), 
                                                      solicitud.getCliente().getOidCliente(),
                                                      solicitud.getPeriodo().getOidPeriodo());
                          exigenciasCumplidas.setFechaCumplimiento(new Date(System
                                                  .currentTimeMillis()));
                          exigenciasCumplidas.setExigenciasCumplidas( new Boolean(true) );
                          exigenciasCumplidasHome.merge(exigenciasCumplidas);
                      } catch (PersistenceException ce) {
                          UtilidadesLog.error("ERROR ", ce);
                          throw new MareException(ce, UtilidadesError.armarCodigoError(
                              CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                      }
                  }// end if CAMBIO ANUL_DEVO
               } catch (PersistenceException ce) {
                   UtilidadesLog.error("ERROR ", ce);
                   throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              
         } else {
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("ConstantesINC.TIPO_GERENTE");
                        
              UtilidadesLog.debug("solicitudConcurso.getOidConcurso(): " + solicitudConcurso.getOidConcurso());
              UtilidadesLog.debug("solicitud.getPeriodo().getOidPeriodo(): " + solicitud.getPeriodo().getOidPeriodo());
            }  
            
            HashMap hmGerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
            Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet().iterator();

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("hmGerentesParticipantes " + hmGerentesParticipantes);

            while (itKeysGerentesParticipantes.hasNext()) {
                Long oidGerente = (Long) itKeysGerentesParticipantes.next();
                Boolean contenido = (Boolean) hmGerentesParticipantes.get(oidGerente);
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("oidGerente: " + oidGerente + "contenido: " + contenido);

                if (contenido.booleanValue() == true) {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("oidGerente: " + oidGerente);
                      
                    try {
                        exigenciasCumplidas = exigenciasCumplidasHome.findByUK(
                                                oidGerente, solicitudConcurso.getOidConcurso(),
                                                solicitud.getPeriodo().getOidPeriodo());
                            
                        UtilidadesLog.debug("lo encontre ");       
                        
                        // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                        if( solicitudConcurso.getIndAnulaPedido() &&
                            ( solicitud.getIndAnulacion() || solicitud.getIndDevolucion() ) ){
                          exigenciasCumplidas.setExigenciasCumplidas( new Boolean(false) );
                        }else{
                          exigenciasCumplidas.setFechaCumplimiento(new Date(System.currentTimeMillis()));
                        }
                        exigenciasCumplidasHome.merge(exigenciasCumplidas);
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug(fe);
                        UtilidadesLog.debug(" No lo encontre, lo inserto ");
                        
                        // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                        if(  solicitud.getIndAnulacion() == false && solicitud.getIndDevolucion() == false  ){
                            try {
                                exigenciasCumplidas = exigenciasCumplidasHome.create(
                                    new Boolean(solicitudConcurso
                                        .getExigenciasCumplidasEnSolicitud()),
                                        solicitudConcurso.getOidConcurso(), 
                                        oidGerente,
                                        solicitud.getPeriodo().getOidPeriodo());
                                        
                                exigenciasCumplidas.setFechaCumplimiento(new Date(System.currentTimeMillis()));
                                exigenciasCumplidas.setExigenciasCumplidas( new Boolean(true) );
                                exigenciasCumplidasHome.merge(exigenciasCumplidas);
                                
                            } catch (PersistenceException ce) {
                                UtilidadesLog.error("ERROR ", ce);
                                throw new MareException(ce, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        }// end if CAMBIO ANUL_DEVO 
                    } catch (PersistenceException ce) {
                         UtilidadesLog.error("ERROR ", ce);
                         throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
            }
           
         }
         
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                         
          UtilidadesLog.debug("exigenciasCumplidas: " + exigenciasCumplidas);
        
        UtilidadesLog.info("DAOSolicitudActualizacion.activarExigenciasCumpli"
            +"das(Solicitud solicitud, SolicitudConcurso solicitudConcurso):"
            +"Salida");
    }
    
    
    /**
     * Crea el mensaje en la tabla de mensajes de incentivos.
     *
     * Comentario: Este metodo utiliza la entidad SolicitudConcursoMensaje , 
     * por favor recordar colocar la EJB Local reference a esta entidad en el
     *  MON desde donde se llame a este metodo
     *
     */
    public void actualizarMensajeIncentivos(Long oidSolicitud, Long 
        oidConcurso, DTOBuzonMensajes dtoBuzonRetorno) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarMensajeIncenti"
            +"vos(Long oidSolicitud, Long oidConcurso, DTOBuzonMensajes dtoBu"
            +"zonRetorno):Entrada");
        if (dtoBuzonRetorno!=null && dtoBuzonRetorno.getOid()!=null){
            BelcorpService bs;
            StringBuffer query = new StringBuffer();
            query.append(" INSERT INTO INC_SOLIC_CONCU_MENSA ( ");
            query.append(" OID_SOLI_CONC_MENS, VAL_BUZO_MENS, SOCA_OID_SOLI_CABE, COPA_OID_PARA_GRAL )  ");
            query.append(" VALUES (INC_SCMS_SEQ.nextval, " + dtoBuzonRetorno.getOid() + ", " + oidSolicitud + ", " +oidConcurso+ ")");
    
    
            try {
                bs = BelcorpService.getInstance();
                bs.dbService.executeUpdate(query.toString());
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("Error: ",  e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            } catch (Exception e) {
                UtilidadesLog.error("Error " , e);
                throw new MareException(e);
            }
            UtilidadesLog.info("DAOSolicitudActualizacion.actualizarMensajeIncenti"
            +"vos(Long oidSolicitud, Long oidConcurso, DTOBuzonMensajes dtoBu"
            +"zonRetorno):Salida");
        }else{
            UtilidadesLog.info("DAOSolicitudActualizacion.actualizarMensajeIncenti"
            +"vos(Long oidSolicitud, Long oidConcurso, DTOBuzonMensajes dtoBu"
            +"zonRetorno):Salida SIN DATOS");
        }
    }


    /**
     * Comentario: Este metodo utiliza la entidad Descalificaciones , por favor
     * recordar colocar la EJB Local reference a esta entidad en el
     *  MON desde donde se llame a este metodo
     *
     */
    public void actualizarDescalificaciones(SolicitudConcurso 
        solicitudConcurso, Solicitud solicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarDescalificacio"
            +"nes(SolicitudConcurso solicitudConcurso, Solicitud solicitud):"
            +"Entrada");
        DescalificacionesLocalHome descalificacionesHome = this.getDescalificacionesLocalHome();

        try {
            descalificacionesHome.create(new Date(System.currentTimeMillis()), 
                            solicitud.getCliente().getOidCliente(),solicitudConcurso
                            .getOidConcurso(), solicitud.getPeriodo().getOidPeriodo(),
                            new Long(solicitudConcurso
                            .getDescalificaClientePorSolicitud()));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError
                .armarCodigoError(CodigosError
                    .ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarDescalificacio"
            +"nes(SolicitudConcurso solicitudConcurso, Solicitud solicitud):"
            +"Salida");
    }

    /**
     * Comentario: Este metodo utiliza la entidad CandidataGanadora , por fa-
     * vor recordar colocar la EJB Local reference a esta entidad en el
     *  MON desde donde se llame a este metodo
     *
     */
    public void actualizarCandidataGanadora(SolicitudConcurso 
        solicitudConcurso, Solicitud solicitud, Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarCandidataGana"
            +"dora(SolicitudConcurso solicitudConcurso, Solicitud solicitud):"
            +"Entrada");
       
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + solicitudConcurso.getOidConcurso());
          UtilidadesLog.debug("CLIE_OID_CLIE:  " + oidCliente);
          UtilidadesLog.debug("solicitud.getPeriodo().getOidPeriodo():  " + solicitud.getPeriodo().getOidPeriodo()); 
        }  

        //jrivas 8/12/2006 Cambio Cierre Incentivos.
        boolean aux = this.actualizarCandidata(solicitudConcurso.getOidConcurso(), oidCliente, 
                solicitud.getPeriodo().getOidPeriodo(), solicitudConcurso.getNumeroPeriodosEvaluados());

        try {
            if (!aux) {
                Concurso conc = new DespacharPremiosHelper().obtenerConcurso(solicitudConcurso.getOidConcurso());
                this.getMONIncentivosLocalHome().create().insertaCandidata(solicitudConcurso.getOidConcurso(), oidCliente, solicitud.getPeriodo().getOidPeriodo(), solicitudConcurso.getNumeroPeriodosEvaluados(), 
                        conc.getFaseCalificacion(), false);
            }
        } catch (CreateException e) {
              UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (NamingException e) {
              UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        

    }


    /**
       * Comentario: Este metodo utiliza la entidad CuentaCorrientePuntos , por
       * favor recordar colocar la EJB Local reference a esta entidad en el 
       * MON desde donde se llame a este metodo
       *
       */
    public void actualizarCuentaCorriente(Solicitud solicitud, 
        SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarCuentaCorrien"
            +"te(Solicitud solicitud, SolicitudConcurso solicitudConcurso):"
            +"Entrada");
        CuentaCorrientePuntosLocalHome cuentaCorrientePuntosHome = this.getCuentaCorrientePuntosLocalHome();
        CuentaCorrientePuntosLocal cuentaCorrientePuntos;
        Long tipoMovimientoAux;
        Double puntosValidosAux;
        Integer numPunt;
        Integer numPuntExig;
        Date fecMovi = solicitud.getFechaDocumento();
        Long copaOidParaGral = solicitudConcurso.getOidConcurso();
        Long clieOidClie = null;
        Long perdOidPeri = solicitud.getPeriodo().getOidPeriodo();
        String descripcion = "";

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" fecMovi " + fecMovi);
          UtilidadesLog.debug(" copaOidParaGral " + copaOidParaGral);
          UtilidadesLog.debug(" clieOidClie " + clieOidClie);        
          UtilidadesLog.debug(" perdOidPeri " + perdOidPeri);                
          UtilidadesLog.debug(" idioma: " + solicitud.getOidIdioma());       
        }  

        if ((solicitud.getIndAnulacion() == true) || (solicitud
                            .getIndDevolucion() == true)) {
            UtilidadesLog.debug(" Anulacion o Devolucion ");
            tipoMovimientoAux = ConstantesINC.TIPO_MOVIMIENTO_CARGO;

            //puntosValidosAux = new Double( -1 * solicitudConcurso.
            //getPuntosValidos().doubleValue() );
            //jrivas 5/9/2006 DBLG50000943
            /*puntosValidosAux = new Double(-1 * solicitudConcurso
                .getPuntosCuentaCorriente().doubleValue());*/
            
        } else {
            UtilidadesLog.debug(" NOOOO    Anulacion o Devolucion ");
            tipoMovimientoAux = ConstantesINC.TIPO_MOVIMIENTO_ABONO;

            //puntosValidosAux = solicitudConcurso.getPuntosValidos();
            //jrivas 5/9/2006 DBLG50000943
            //puntosValidosAux = solicitudConcurso.getPuntosCuentaCorriente();
                         
        }

        //jrivas 5/9/2006 DBLG50000943
        puntosValidosAux = solicitudConcurso.getPuntosCuentaCorriente();
        
        if(!solicitud.getIndAnulacion()){
            // vbongiov 6/03/2006 - 22675
            // Obtener descripcion
            Long oidIdioma;
            if( solicitud.getOidIdioma() != null ){
              oidIdioma = solicitud.getOidIdioma();
            }else{
              oidIdioma = new RecuperadorIdiomaDefectoServidor().getIdiomaDefectoServidor(); 
            }
            RecordSet rs = this.recuperarDatosDescripcionAbono(solicitud.getOidSolicitud(), oidIdioma, tipoMovimientoAux);
            
            descripcion = (String)rs.getValueAt(0, "DESCTIPOMOV") + " Puntaje del periodo " +
                          (String)rs.getValueAt(0, "DES_MARC") + " " + (String)rs.getValueAt(0, "DESCCANAL") + " " +
                          (String)rs.getValueAt(0, "COD_PERI");
            
            // sapaza -- PER-SiCC-2010-0513 -- 11/10/2010              
            if((tipoMovimientoAux == ConstantesINC.TIPO_MOVIMIENTO_ABONO) && 
               ConstantesINC.COD_TIPO_PEDIDO_ECM.equals(solicitud.getCodigoTipoSolPais()))
               descripcion = ConstantesINC.TEXTO_VENTA_ECM;
               
        } else {
            descripcion = ConstantesINC.TEXTO_DESCRIPCION_ANULACION;                
        }

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" tipoMovimientoAux " + tipoMovimientoAux);
          UtilidadesLog.debug(" puntosValidosAux " + puntosValidosAux);
        
          UtilidadesLog.debug(" solicitudConcurso.getExigenciasCumplidasEnSoli"
            +"citud() " + solicitudConcurso.getExigenciasCumplidasEnSolicitud());        
        }        

        //BELC300023719 - gPineda - 11/12/2006
        int factorAnulacion;
        if( solicitud.getIndAnulacion() ){
          factorAnulacion = -1;
        }else{
          factorAnulacion = 1;
        }

        //jrivas 19/7/2006 DBLG50001046 se agrega que no sea RECOMENDADA y NUM_PEDIDOS
        Concurso conc = new DespacharPremiosHelper().obtenerConcurso(solicitudConcurso.getOidConcurso());
        
        // vbongiov -- 29/11/2006 -- DBLG500001077 
        if((conc.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_RECOMENDADA)) && (!solicitud.getIndAnulacion())){
            clieOidClie = solicitud.getCliente().getClienteRecomendante().getRecomendante();
        } else {
            clieOidClie = solicitud.getCliente().getOidCliente();
        }
        
        // vbongiov -- 29/11/2006 -- DBLG500000983
        /* if ((solicitudConcurso.getExigenciasCumplidasEnSolicitud())
                && !(conc.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_NUM_PEDIDOS))
                && !(conc.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_RECOMENDADA))) {
            // vbongiov -- 29/11/2006 -- DBLG500001077
            numPunt = new Integer((solicitudConcurso.getPuntosAcumulados()
                .intValue() + puntosValidosAux.intValue()) * factorAnulacion);           
        } else {
            // vbongiov -- 29/11/2006 -- DBLG500001077
            numPunt = new Integer(puntosValidosAux.intValue()* factorAnulacion);            
        //}*/
        
        // sapaza -- SIN-RCR-20131003 AJUSTE CALCULAR PUNTAJE CONSULTORAS -- 03/10/2013
        //numPunt = new Integer(puntosValidosAux.intValue()* factorAnulacion);      
        
        //sapaza -- COL-SiCC-2014-0232 -- 09/07/2014
        Long puntosValidosAuxRound = Math.round(puntosValidosAux);
        numPunt = new Integer(puntosValidosAuxRound.intValue()* factorAnulacion);      
        
        if (((solicitudConcurso.getExigenciasCumplidasEnSolicitud())
                && !(conc.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_NUM_PEDIDOS))
                && !(conc.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_RECOMENDADA)))
                || 
                ((solicitud.getIndAnulacion())
                && !(conc.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_NUM_PEDIDOS))
                && !(conc.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_RECOMENDADA)))) {
          
            //BELC300023719 - gPineda - 14/11/2006
            //numPuntExig = new Integer(solicitudConcurso.getPuntosExigidos()
            //    .intValue() * factorAnulacion );
            
            //sapaza -- COL-SiCC-2014-0232 -- 09/07/2014
            Long numPuntExigRound = Math.round(solicitudConcurso.getPuntosExigidos());
            numPuntExig = new Integer(numPuntExigRound.intValue() * factorAnulacion );
             
        } else {         
            // sapaza -- PER-SiCC-2012-0082 -- 16/05/2012
            numPuntExig = new Integer(0);
            
            //BELC300023719 - gPineda - 14/11/2006
            /*numPuntExig = new Integer(solicitudConcurso
                .getPuntosExigidosSolicitud().intValue() * factorAnulacion);*/
        }

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" numPunt " + numPunt);
          UtilidadesLog.debug(" numPuntExig " + numPuntExig);
        }  

        try {
            //BRECHA MSG-01 jrivas 11/10/2007
            cuentaCorrientePuntos = cuentaCorrientePuntosHome.create(numPunt,
                            numPuntExig, fecMovi, copaOidParaGral, clieOidClie, 
                            perdOidPeri, tipoMovimientoAux, descripcion);
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        cuentaCorrientePuntos.setNumMovimiento(new Integer(
            cuentaCorrientePuntos.getOid().intValue()));

        //sapaza -- COL-SiCC-2014-0175 -- 04/06/2014
        //int puntoBonificados = solicitudConcurso.getPuntosBonificados().intValue();

        //sapaza -- COL-SiCC-2014-0232 -- 09/07/2014
        Long puntoBonificados = Math.round(solicitudConcurso.getPuntosBonificados());
        cuentaCorrientePuntos.setPuntosBonificados(puntoBonificados.intValue());
            
        cuentaCorrientePuntosHome.merge(cuentaCorrientePuntos);

        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarCuentaCorrien"
            +"te(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
    }

    /**
       * Comentario: Este metodo utiliza la entidad PuntajeProductosExigidos , 
       * por favor recordar colocar la EJB Local reference a esta entidad en 
       * el MON desde donde se llame a este metodo
       *
       */
    public void actualizarPuntajeProductosExigidos(Solicitud solicitud, 
        SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPuntajeProduc"
            +"tosExigidos(Solicitud solicitud, SolicitudConcurso solicitudCon"
            +"curso):Entrada");            
            
        // vbongiov -- 19/09/2006 -- inc DBLG500000761
        FactoriaConcurso factoria= FactoriaConcurso.getFactoriaConcurso();
       
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = {solicitudConcurso.getOidConcurso() };
        dtoOids.setOids(oids);
  
        ArrayList concursos = factoria.getConcursosPorOID(dtoOids);
        Concurso concurso = (Concurso) concursos.get(0);
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" concurso.getDirigidoA(): " + concurso.getDirigidoA());
        
        if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA()) ||
           (ConstantesINC.TIPO_GERENTE.equals(concurso.getDirigidoA()) && this.gerenteValido(solicitudConcurso))) {

            PuntajeProductosExigidosLocalHome puntajeProductosExigidosHome = this.getPuntajeProductosExigidosLocalHome();
    
            HashMap listaProductosExigidos = solicitudConcurso.getListaProductosExigidos();
            Collection productosExigidos = listaProductosExigidos.values();
            Iterator productos = productosExigidos.iterator();
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug(" productos " + productos);
    
            while (productos.hasNext()) {
                try {
                    ProductoExigido productoExigido = (ProductoExigido) productos.next();
                    Double montoPedido = (productoExigido.getMontoPedido() != null)
                        ? new Double(productoExigido.getMontoPedido().doubleValue())
                        : new Double(0);
                    Long puntoPedido = (productoExigido.getPuntosPedido() != null)
                    ? new Long(productoExigido.getPuntosPedido().longValue())
                    : new Long(0);
                    puntajeProductosExigidosHome.create(montoPedido, 
                                        productoExigido.getUnidadesPedido(), puntoPedido,
                                        solicitudConcurso.getOidConcurso(), productoExigido
                                        .getOidProductoExigido(),solicitud.getOidSolicitud());
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
        }

        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPuntajeProduc"
            +"tosExigidos(Solicitud solicitud, SolicitudConcurso solicitudCon"
            +"curso):Salida");
    }  
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       19/09/2006
    * @version     1.0
    * @autor       Viviana Bongiovanni
    * inc DBLG500000761
    */
    private boolean gerenteValido(SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.gerenteValido(SolicitudConcurso solicitudConcurso):Entrada"); 
        
        HashMap hmGerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
        Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet().iterator();
    
        UtilidadesLog.debug("hmGerentesParticipantes " + hmGerentesParticipantes);
        
        Long oidGerente = null;
        Boolean contenido = null;
                    
        while (itKeysGerentesParticipantes.hasNext()) {
            oidGerente = (Long) itKeysGerentesParticipantes.next();
            contenido = (Boolean) hmGerentesParticipantes.get(oidGerente);

            if (contenido.booleanValue() == true) {
                UtilidadesLog.debug("gerente true: " + oidGerente);
                UtilidadesLog.info("DAOSolicitudActualizacion.gerenteValido(SolicitudConcurso solicitudConcurso):Salida");   
                return true;
            }
        }
        
        UtilidadesLog.debug("gerente false");
        UtilidadesLog.info("DAOSolicitudActualizacion.gerenteValido(SolicitudConcurso solicitudConcurso):Salida");   
        return false;
        
    }

    /**
       * Comentario: Este metodo utiliza la entidad CalculoProductosExigidos , 
       * por favor recordar colocarla EJB Local reference a esta entidad en el 
       * MON desde donde se llame a este metodo
       *
       */
    public void actualizarCalculosProductosExigidos(Solicitud solicitud, 
        SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarCalculosProdu"
            +"ctosExigidos(Solicitud solicitud, SolicitudConcurso solicitudCon"
            +"curso):Entrada");

        CalculoProductosExigidosLocalHome calculoProductosExigidosHome = this.getCalculoProductosExigidosLocalHome();
        CalculoProductosExigidosLocal calculoProductosExigidos;

        ProductoExigido productoExigido = null;
        HashMap listaProductosExigidos = solicitudConcurso.getListaProductosExigidos();
        Collection listaProductos = listaProductosExigidos.values();
        Iterator productos = listaProductos.iterator();
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(" productos " + productos);
        
        // vbongiov 31/03/2006 inc 22826
        FactoriaConcurso factoria= FactoriaConcurso.getFactoriaConcurso();
       
         DTOOIDs dtoOids = new DTOOIDs();
         Long[] oids = {solicitudConcurso.getOidConcurso() };
         dtoOids.setOids(oids);
  
         ArrayList concursos = factoria.getConcursosPorOID(dtoOids);
         Concurso concurso = (Concurso) concursos.get(0);
         
         BigDecimal montoPedido1 = null;
         int unidadesPedido1;
         int puntosPedido1;
         
          if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA())) {
               UtilidadesLog.debug("ConstantesINC.TIPO_CONSULTORA");
               
               while (productos.hasNext()) {
                  try {
                      productoExigido = (ProductoExigido) productos.next();
                      
                      if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                        UtilidadesLog.debug(" solicitud.getPeriodo().getOidPeriodo() " 
                          + solicitud.getPeriodo().getOidPeriodo());
                        UtilidadesLog.debug(" productoExigido.getOidProductoExigido() " 
                          + productoExigido.getOidProductoExigido());
                        UtilidadesLog.debug(" productoExigido.getMontoPedido() " + 
                          productoExigido.getMontoPedido());
                        UtilidadesLog.debug(" productoExigido.getUnidadesPedido() " + 
                          productoExigido.getUnidadesPedido());
                        UtilidadesLog.debug(" productoExigido.getPuntosPedido() " + 
                          productoExigido.getPuntosPedido());
                        UtilidadesLog.debug(" solicitud.getCliente().getOidCliente() " 
                          + solicitud.getCliente().getOidCliente());
                      }    
      
                      calculoProductosExigidos = calculoProductosExigidosHome
                          .findByUK(solicitud.getPeriodo().getOidPeriodo(),
                          productoExigido.getOidProductoExigido(), 
                          solicitud.getCliente().getOidCliente());
                   
                      calculoProductosExigidos.setMontoPedido(productoExigido.getMontoPedido());
      
                      if (productoExigido.getUnidadesPedido() != null) {
                          calculoProductosExigidos.setUnidadesPedido(new Integer(productoExigido.getUnidadesPedido().intValue()));
                      }
      
                      if (productoExigido.getPuntosPedido() != null) {
                          calculoProductosExigidos.setPuntosPedido(new Integer(productoExigido.getPuntosPedido().intValue()));
                      } 
                      calculoProductosExigidosHome.merge(calculoProductosExigidos);
                      
                  } catch (NoResultException fe) {
                      UtilidadesLog.debug(fe);
                      try {
                      
                          // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                          if(  solicitud.getIndAnulacion() == false && solicitud.getIndDevolucion() == false  ){
                          
                              UtilidadesLog.debug("se crea calculoProductosExigidos ");
                              BigDecimal montoPedido = new BigDecimal(0); 
                              Integer unidadesPedido = new Integer(0); 
                              Integer puntosPedido = new Integer(0); 
          
                              if (productoExigido.getMontoPedido() != null ) {
                                  montoPedido = productoExigido.getMontoPedido();
                              }
                              if (productoExigido.getUnidadesPedido() != null) {
                                  unidadesPedido = new Integer(productoExigido.getUnidadesPedido().intValue());
                              } 
                              if (productoExigido.getPuntosPedido() != null) {
                                  puntosPedido = new Integer(productoExigido.getPuntosPedido().intValue());
                              }
          
                              calculoProductosExigidos = calculoProductosExigidosHome
                                  .create(solicitud.getPeriodo().getOidPeriodo(),
                                  productoExigido.getOidProductoExigido(),
                                  solicitud.getCliente().getOidCliente(),
                                  montoPedido, unidadesPedido, puntosPedido );
                          }
                      } catch (PersistenceException ce) {
                          UtilidadesLog.error("ERROR ", ce);
                          throw new MareException(ce, UtilidadesError
                              .armarCodigoError(CodigosError
                                  .ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                      }
                  } catch (PersistenceException ce) {
                      UtilidadesLog.error("ERROR ", ce);
                      throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                  }
              }
          } else {
                UtilidadesLog.debug("ConstantesINC.TIPO_GERENTE");
                
                HashMap hmGerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
                Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet().iterator();
    
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("hmGerentesParticipantes " + hmGerentesParticipantes);
    
                while (itKeysGerentesParticipantes.hasNext()) {
                    Long oidGerente = (Long) itKeysGerentesParticipantes.next();
                    Boolean contenido = (Boolean) hmGerentesParticipantes.get(oidGerente);
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("oidGerente: " + oidGerente + "contenido: " + contenido);
                    
                    productos = listaProductos.iterator();
                        
                    if (contenido.booleanValue() == true) {                    
                        while (productos.hasNext()) {
                            try {
                                productoExigido = (ProductoExigido) productos.next();
                                
                                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug(" solicitud.getPeriodo().getOidPeriodo() " + solicitud.getPeriodo().getOidPeriodo());
                                  UtilidadesLog.debug(" productoExigido.getOidProductoExigido() " + productoExigido.getOidProductoExigido());
                                  UtilidadesLog.debug(" productoExigido.getMontoPedido() " + productoExigido.getMontoPedido());
                                  UtilidadesLog.debug(" productoExigido.getUnidadesPedido() " + productoExigido.getUnidadesPedido());
                                  UtilidadesLog.debug(" productoExigido.getPuntosPedido() " + productoExigido.getPuntosPedido());
                                  UtilidadesLog.debug(" oidGerente " + oidGerente);
                                }  
                
                                calculoProductosExigidos = calculoProductosExigidosHome.findByUK(solicitud.getPeriodo().getOidPeriodo(),
                                                productoExigido.getOidProductoExigido(),oidGerente);
                                    
                                if (productoExigido.getMontoPedido() != null) {
                                    montoPedido1 = productoExigido.getMontoPedido().add(calculoProductosExigidos.getMontoPedido());
                                    calculoProductosExigidos.setMontoPedido(montoPedido1);
                                }
                
                                if (productoExigido.getUnidadesPedido() != null) {
                                    unidadesPedido1 = productoExigido.getUnidadesPedido().intValue() + calculoProductosExigidos.getUnidadesPedido().intValue();
                                    calculoProductosExigidos.setUnidadesPedido(new Integer(unidadesPedido1));
                                } 
                
                                if (productoExigido.getPuntosPedido() != null) {
                                    puntosPedido1 = productoExigido.getPuntosPedido().intValue() + calculoProductosExigidos.getPuntosPedido().intValue();
                                    calculoProductosExigidos.setPuntosPedido(new Integer(puntosPedido1));
                                }
                                calculoProductosExigidosHome.merge(calculoProductosExigidos);
                                
                            } catch (NoResultException fe) {
                                UtilidadesLog.debug(fe);
                                try {
                                    // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                                    if(  solicitud.getIndAnulacion() == false && solicitud.getIndDevolucion() == false  ){
                                    
                                        UtilidadesLog.debug("se crea calculoProductosExigidos ");
                                        BigDecimal montoPedido = new BigDecimal(0); 
                                        Integer unidadesPedido = new Integer(0); 
                                        Integer puntosPedido = new Integer(0); 
                    
                                        if (productoExigido.getMontoPedido() != null ) {
                                            montoPedido = productoExigido.getMontoPedido();
                                        }
                                        if (productoExigido.getUnidadesPedido() != null) {
                                            unidadesPedido = new Integer(productoExigido.getUnidadesPedido().intValue());
                                        } 
                                        if (productoExigido.getPuntosPedido() != null) {
                                            puntosPedido = new Integer(productoExigido.getPuntosPedido().intValue());
                                        }
                    
                                        calculoProductosExigidos = calculoProductosExigidosHome
                                            .create(solicitud.getPeriodo().getOidPeriodo(),
                                            productoExigido.getOidProductoExigido(),
                                            oidGerente,  montoPedido, unidadesPedido, puntosPedido );
                                    }
                                } catch (PersistenceException ce) {
                                    UtilidadesLog.error("ERROR ", ce);
                                    throw new MareException(ce, UtilidadesError
                                        .armarCodigoError(CodigosError
                                            .ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                }
                            } catch (PersistenceException ce) {
                                UtilidadesLog.error("ERROR ", ce);
                                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        }
                    }
                }
          }

        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarCalculosProduc"
            +"tosExigidos(Solicitud solicitud, SolicitudConcurso solicitudCon"
            +"curso):Salida");
    }

    /**
      * Comentario: Este metodo utiliza la entidad SolicitudConcursoPuntaje , 
      * por favor recordar colocarla EJB Local reference a esta entidad en el 
      * MON desde donde se llame a este metodo
      *
      * @throws es.indra.mare.common.exception.MareException
      * @param concurso
      * @param solicitudConcurso
      * @param solicitud
      *
      * Modificado por Sergio Platas
      * @date 24/06/2005
      */
    public void actualizarSolicitudConcursoPuntaje(     Solicitud               solicitud, 
                                                        SolicitudConcurso       solicitudConcurso, 
                                                        Concurso                concurso
                                                   ) 
        throws MareException 
    {
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSolicitudConcursoPuntaje (Solicitud solicitud, SolicitudConcurso solicitudConcurso, Concurso concurso):Entrada");

        //
        // sicc 20070237, se agrega condición if para manejo de puntajes
        // sicc 20070373, se agrega condicion para base de calculo RECOMENDADAS
        //
        boolean fCrea=true;
        
        if((ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(concurso.getBaseCalculo()))
            &&
           (solicitud.getCliente().getClienteRecomendado().size() > 0)
          )
        {
            Periodo periodo = this.buscaPeridoVinculoRecomendante(solicitudConcurso, solicitud);
            
            if (periodo != null){
                fCrea = solicitud.getPeriodo().contenidoEn(concurso.getPeriodoDesde(), concurso.getUltimoPeridoEvaluar());
            }else{
                fCrea=false;
            }
        }
        
        if ( !(
                solicitud.getCliente().getClienteRecomendado().size() == 0 
                &&
                ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(concurso.getBaseCalculo())
              )  
              &&
              fCrea
        )
        {
            try {
            SolicitudConcursoPuntajeLocalHome solicitudConcursoPuntajeHome = this.getSolicitudConcursoPuntajeLocalHome();
            SolicitudConcursoPuntajeLocal solicitudConcursoPuntaje;
            
            /* vbongiov
             * inc 22066*/ 
            DAOConcursosRanking daoConcursosRanking= new DAOConcursosRanking();
            
            Concurso concCompleto = daoConcursosRanking.obtenerConcurso(solicitudConcurso.getOidConcurso());
            
            Collection solConcPuntaj= null;
           
            //BELC300024413 - gPineda - 16/11/2006
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("!solicitudConcurso.getTipoVinculo().equals(ConstantesINC.TIPO_VINC_NINGUNO): " + 
                                      !solicitudConcurso.getTipoVinculo().equals(ConstantesINC.TIPO_VINC_NINGUNO) );
                                      
            if(!ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(concCompleto.getBaseCalculo()) || 
               (ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(concCompleto.getBaseCalculo()) 
               && (!solicitudConcurso.getTipoVinculo().equals(ConstantesINC.TIPO_VINC_NINGUNO))) ){
    
            //Jrivas 6/7/2005
            //Inc 19705
            if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA())) {
            
                    if(concCompleto.getIndRanking()){
                        try {
                            solConcPuntaj= solicitudConcursoPuntajeHome.findByUK(solicitudConcurso.getOidConcurso(), solicitud.getPeriodo().getOidPeriodo(),
                                                                solicitud.getOidSolicitud(), solicitud.getCliente().getOidCliente());
                                                                UtilidadesLog.debug("solConcPuntaj.size(): " + solConcPuntaj.size());
                        } catch (NoResultException fe) {
                            UtilidadesLog.error("ERROR : " + fe);
                            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                        } catch (PersistenceException ce) {
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }
                    
                    // La informacion no fue anterirmente grabada en la entidad
                    if(!concCompleto.getIndRanking() || (concCompleto.getIndRanking() && solConcPuntaj.isEmpty())){
                        UtilidadesLog.debug("no esta creo el registro");
                        
                        //sapaza -- COL-SiCC-2014-0232 -- 09/07/2014
                        int puntos = (new Long(Math.round(solicitudConcurso.getPuntosValidos().doubleValue() + 
                                                                solicitudConcurso.getPuntosBonificados().doubleValue()))).intValue();
                        int puntosExigidos = (new Long(Math.round(solicitudConcurso.getPuntosExigidos()))).intValue();
                        
                        // sapaza -- PER-SiCC-2014-0074 -- 04/02/2014
                        //int puntos = new Double(solicitudConcurso.getPuntosValidos().doubleValue() + 
                        //                                    solicitudConcurso.getPuntosBonificados().doubleValue()).intValue();
                        //int puntosExigidos = solicitudConcurso.getPuntosExigidos().intValue();
                        
                        if(log.isDebugEnabled()) {             
                          UtilidadesLog.debug("puntos: " + puntos);
                          UtilidadesLog.debug("puntosExigidos: " + puntosExigidos);
                        }
                        
                        if(puntos!=0 || puntosExigidos!=0) {
                            try {
                                solicitudConcursoPuntaje = solicitudConcursoPuntajeHome.create(
                                                                                solicitudConcurso.getOidConcurso(), 
                                                                                solicitud.getOidSolicitud(), 
                                                                                solicitud.getPeriodo().getOidPeriodo(),
                                                                                solicitud.getCliente().getOidCliente(), 
                                                                                null);
                                             
                            } catch (PersistenceException ce) {
                                UtilidadesLog.error("ERROR ", ce);
                                throw new MareException(ce, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                
                            // obtenemos puntos validos y bonificados
                            // vbongiov -- 14/11/2006 -- DBLG700000190
                            double puntosValidos = solicitudConcurso.getPuntosValidos().doubleValue();
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("puntosValidos: " + puntosValidos);
                              
                            double puntoBonificados = solicitudConcurso.getPuntosBonificados().doubleValue();
                            
                            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug("puntoBonificados: " + puntoBonificados);
                              UtilidadesLog.debug("solicitudConcursoPuntaje.setNumeroPuntos: " + (puntosValidos + puntoBonificados));
                              UtilidadesLog.debug("solicitudConcursoPuntaje.setPuntajeBonificacion: " + puntoBonificados);
                              UtilidadesLog.debug("solicitudConcursoPuntaje.setPuntajeFaltantesNoAnunciados: " + solicitudConcurso.getPuntosFaltantesNoAnunciados());
                            }  
                
                            //Y se hace el set con de los siguiente atributos: 
                            // Incidencia 20515
                            // vbongiov -- 14/11/2006 -- DBLG700000190
                            
                            //sapaza -- COL-SiCC-2014-0232 -- 09/07/2014
                            solicitudConcursoPuntaje.setNumeroPuntos((new Long(Math.round(puntosValidos))).intValue() + (new Long(Math.round(puntoBonificados))).intValue()); 
                            solicitudConcursoPuntaje.setPuntajeBonificacion((new Long(Math.round(puntoBonificados))).intValue());
                            //solicitudConcursoPuntaje.setNumeroPuntos(new Integer(new Double(puntosValidos + puntoBonificados).intValue())); 
                            //solicitudConcursoPuntaje.setPuntajeBonificacion( new Integer(new Double(puntoBonificados).intValue()));
                            
                            solicitudConcursoPuntaje.setPuntajeFaltantesNoAnunciados(new Integer(solicitudConcurso.getPuntosFaltantesNoAnunciados()
                                    .intValue()));
                
                            if (solicitud.getFechaDocumento() != null) {
                                solicitudConcursoPuntaje.setFechaDocumento(solicitud.getFechaDocumento());
                            }
                
                            solicitudConcursoPuntaje.setAnulada(new Boolean(solicitud.getIndAnulacion() || solicitud.getIndDevolucion()));
                            
                            // Si concurso.formaCalculo == Interfaces::INC::ConstantesINC.
                            //OID_FORMA_CALC_VARIABLES_VTA 
                            // monto:solicitudConcurso.getMontoBonificado() 
                            // SiNO 
                            // monto: solicitudConcurso.getMontoValido() 
                            if (ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.equals(concurso.getFormaCalculo())) {
                                solicitudConcursoPuntaje.setMonto(solicitudConcurso.getMontoBonificado());
                            } else {
                                solicitudConcursoPuntaje.setMonto(solicitudConcurso.getMontoValido());
                            }
    
                            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                        
                              UtilidadesLog.debug(" solicitudConcursoPuntaje.getMonto: " + solicitudConcursoPuntaje.getMonto());
                              UtilidadesLog.debug(" solicitudConcurso.getUnidadesValidas() " + solicitudConcurso.getUnidadesValidas());
                            }  
                
                            if (solicitudConcurso.getUnidadesValidas() != null) {
                                solicitudConcursoPuntaje.setUnidades(new Integer(solicitudConcurso.getUnidadesValidas().intValue()));
                            }
                            solicitudConcursoPuntajeHome.merge(solicitudConcursoPuntaje);
                        }    
                    }
                    
                } else {
                  
                    //Jrivas inc 19525
                    //29/6/2005
                    HashMap hmGerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
                    Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet().iterator();
        
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("hmGerentesParticipantes "  + hmGerentesParticipantes);
                            
                    while (itKeysGerentesParticipantes.hasNext()) {
                        Long oidGerente = (Long) itKeysGerentesParticipantes.next();
                        Boolean contenido = (Boolean) hmGerentesParticipantes.get(oidGerente);
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("oidGerente " + oidGerente + "contenido " + contenido);
        
                        if (contenido.booleanValue() == true) {
                        
                            try {
                                solConcPuntaj= solicitudConcursoPuntajeHome.findByUKGerente(solicitudConcurso.getOidConcurso(), solicitud.getPeriodo().getOidPeriodo(),
                                solicitud.getOidSolicitud(), solicitud.getCliente().getOidCliente(), oidGerente);
                            } catch (NoResultException fe) {
                                UtilidadesLog.error("ERROR : " + fe);
                                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                            } catch (PersistenceException ce) {
                                UtilidadesLog.error("ERROR ", ce);
                                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        
                            if(solConcPuntaj.isEmpty()){
                                try {
                                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                      UtilidadesLog.debug("solicitudConcurso.getOidConcurso() " + solicitudConcurso.getOidConcurso());
                                      UtilidadesLog.debug("solicitud.getOidSolicitud() " + solicitud.getOidSolicitud());
                                    }  
                                    
                                    solicitudConcursoPuntaje = solicitudConcursoPuntajeHome.create(solicitudConcurso.getOidConcurso(), 
                                            solicitud.getOidSolicitud(),solicitud.getPeriodo().getOidPeriodo(),
                                            solicitud.getCliente().getOidCliente(), 
                                            oidGerente);
                                } catch (PersistenceException ce) {
                                    UtilidadesLog.error("ERROR ", ce);
                                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                }
            
                                // obtenemos puntos validos y bonificados
                                int puntosValidos = solicitudConcurso.getPuntosValidos().intValue();
                                int puntoBonificados = solicitudConcurso.getPuntosBonificados().intValue();
                                    
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                    
                                  UtilidadesLog.debug("solicitudConcursoPuntaje.setNumeroPuntos() " + new Integer(puntosValidos + puntoBonificados));
            
                                //Y se hace el set con de los siguiente atributos: 
                                solicitudConcursoPuntaje.setNumeroPuntos( new Integer(puntosValidos + puntoBonificados) );// Incidencia 20515
                                
                                 if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("solicitudConcursoPuntaje.setPuntajeBonificacion() " + puntoBonificados);
                                solicitudConcursoPuntaje.setPuntajeBonificacion(new Integer(puntoBonificados) );
                                
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("solicitudConcursoPuntaje.setPuntajeFaltantesNoAnunciados() " + new Integer(solicitudConcurso.getPuntosFaltantesNoAnunciados().intValue()));
                                solicitudConcursoPuntaje.setPuntajeFaltantesNoAnunciados(new Integer(solicitudConcurso.getPuntosFaltantesNoAnunciados().intValue()));
                                
                                // vbongiov -- 28/08/2006 -- DBLG500000680
                                solicitudConcursoPuntaje.setFechaDocumento(solicitud.getFechaFacturacion());
                                solicitudConcursoPuntaje.setAnulada(new Boolean(solicitud.getIndAnulacion() || solicitud.getIndDevolucion()));
                                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("solicitudConcurso.getMontoValido() " + solicitudConcurso.getMontoValido());
                                  UtilidadesLog.debug("solicitudConcurso.getUnidadesValidas() " + solicitudConcurso.getUnidadesValidas());
                                }  
                                
                                // Si concurso.formaCalculo == Interfaces::INC::
                                //ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA 
                                // monto:solicitudConcurso.getMontoBonificado() 
                                // SiNO 
                                // monto: solicitudConcurso.getMontoValido() 
                                if (ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.equals(
                                    concurso.getFormaCalculo())) {
                                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                      UtilidadesLog.debug("solicitudConcursoPuntaje.setMonto() " + solicitudConcurso.getMontoBonificado());
                                    solicitudConcursoPuntaje.setMonto(solicitudConcurso.getMontoBonificado());
                                } else {
                                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                      UtilidadesLog.debug("solicitudConcursoPuntaje.setMonto() " + solicitudConcurso.getMontoValido());
                                    solicitudConcursoPuntaje.setMonto(solicitudConcurso.getMontoValido());
                                }
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                                  UtilidadesLog.debug("solicitudConcursoPuntaje.setUnidades() " + new Integer(solicitudConcurso.getUnidadesValidas().intValue()));
                                  
                                //unidades: solicitudConcurso.getUnidadesValidas() 
                                solicitudConcursoPuntaje.setUnidades(new Integer(solicitudConcurso.getUnidadesValidas().intValue()));
                                solicitudConcursoPuntajeHome.merge(solicitudConcursoPuntaje);
                            }
                        }
                    }
                }
              }                     
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } catch (Exception e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e);
            }
        } 
        
        // vbongiov -- Cambio 20090841 -- 6/07/2009
        if (((solicitud.getCliente().getClienteRecomendado().size() == 0 && ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(concurso.getBaseCalculo()))  
              && fCrea) || 
            ((solicitud.getCliente().getClienteRecomendado().size() > 0 && ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(concurso.getBaseCalculo()))  
              && !fCrea)
        ){
        
            this.guardaSolicitudConcursoPuntajeTemporal(solicitud, solicitudConcurso, concurso);
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSolicitudCon"
            +"cursoPuntaje(Solicitud solicitud, SolicitudConcurso solicitudCon"
            +"curso, Concurso concurso):Salida");
    }


    /**
     * @author Noziglia C.
     * @throws MareException
     * @param Solicitud solicitud, SolicitudConcurso solicitudConcurso, 
     *        Concurso concurso
     * @return void
     *
     * @cambio incidencia 20462
     * @autor gdmarzi 
     */
    public void actualizarSolicitudRecomendadasGerente(Solicitud solicitud, 
        SolicitudConcurso solicitudConcurso) 
        throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSolicitudReco"
            +"mendadasGerente(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Concurso, Concurso concurso):Entrada");

        //jrivas 30/8/2006 DBLG5000839
        HashMap hmGerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
        Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet().iterator();
        SolicitudGerenteRecomendadoLocal solicitudGerenteRecomendadoL;
        SolicitudGerenteRecomendadoLocalHome solicitudGerenteRecomendadoLH = this.getSolicitudGerenteRecomendadoLocalHome();
        Long oidGerente;
        Boolean contenido;
        
        while (itKeysGerentesParticipantes.hasNext()) {
            oidGerente = (Long) itKeysGerentesParticipantes.next();
            contenido = (Boolean) hmGerentesParticipantes.get(oidGerente);
            
            if (contenido.booleanValue() == true) {        
                try {
                    solicitudGerenteRecomendadoL = solicitudGerenteRecomendadoLH.findByClienteGerente(
                                                            oidGerente, 
                                                            solicitud.getCliente().getOidCliente(),
                                                            solicitudConcurso.getOidConcurso(),
                                                            solicitud.getOidSolicitud());
                    UtilidadesLog.debug("SolicitudGerenteRecomendado LO ENCONTRE"); 

                    if (solicitud.getFechaFacturacion() != null) {
                        solicitudGerenteRecomendadoL.setFechaDocumento(new Timestamp(solicitud.getFechaFacturacion().getTime()));
                        solicitudGerenteRecomendadoLH.merge(solicitudGerenteRecomendadoL);
                    }
                    
                } catch (NoResultException e) {
                    UtilidadesLog.debug("SolicitudGerenteRecomendado NO LO ENCONTRE"); 
                    try {
                        solicitudGerenteRecomendadoL = solicitudGerenteRecomendadoLH.create(
                                            solicitud.getCliente().getOidCliente(),
                                            oidGerente, 
                                            solicitud.getOidSolicitud(),
                                            solicitudConcurso.getOidConcurso(),
                                            solicitud.getPeriodo().getOidPeriodo());
                                            
                                            
                        if (solicitud.getFechaFacturacion() != null) {
                            solicitudGerenteRecomendadoL.setFechaDocumento(new Timestamp(solicitud.getFechaFacturacion().getTime()));
                            solicitudGerenteRecomendadoLH.merge(solicitudGerenteRecomendadoL);
                        }
                        
                        UtilidadesLog.debug("SolicitudGerenteRecomendado CREADO"); 
                    } catch (PersistenceException pe) {
                        UtilidadesLog.debug("Error al crear SolicitudGerenteRecomendado"); 
                    }
                }
            }
        }
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSolicitudReco"
            +"mendadasGerente(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Concurso, Concurso concurso):Salida");
    }


    /**
     * @author Noziglia C.
     * @throws MareException
     * @param Solicitud solicitud, SolicitudConcurso solicitudConcurso, 
     *        Concurso concurso
     * @return void
     * @documentation
     *
     * @cambio incidencia 20467
     * @autor gdmarzi 
     * @cambio incidencia 20637
     * @autor gdmarzi 
     */
    public void actualizarPedidoRecomendadasGerente(Solicitud solicitud, 
        SolicitudConcurso solicitudConcurso)
        throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoRecomen"
            +"dadasGerente(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Concurso, Concurso concurso):Entrada");

        //jrivas 30/8/2006 DBLG5000839.
        HashMap hmGerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
        Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet().iterator();
        ClienteGerenteLocal clienteGerenteL;
        ClienteGerenteLocalHome clienteGerenteLH = this.getClienteGerenteLocalHome();
        ClienteGerenteRecomendadoLocal clienteGerenteRecomendadoL;
        ClienteGerenteRecomendadoLocalHome clienteGerenteRecomendadoLH = this.getClienteGerenteRecomendadoLocalHome();
        PedidoGerenteRecomendadoLocal pedidoGerenteRecomendadoL;
        PedidoGerenteRecomendadoLocalHome pedidoGerenteRecomendadoLH = this.getPedidoGerenteRecomendadoLocalHome();
        Long oidGerente;
        Boolean contenido;
        
        while (itKeysGerentesParticipantes.hasNext()) {
            oidGerente = (Long) itKeysGerentesParticipantes.next();
            contenido = (Boolean) hmGerentesParticipantes.get(oidGerente);

            
            if (contenido.booleanValue() == true) {        
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("oidGerente " + oidGerente); 
                  UtilidadesLog.debug("OidConcurso() " + solicitudConcurso.getOidConcurso()); 
                }  
                try {
                    clienteGerenteL = clienteGerenteLH.findByGerenteConcurso(oidGerente, solicitudConcurso.getOidConcurso());
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("ClienteGerente LO ENCONTRE"); 
                      UtilidadesLog.debug("OidCliente() " + solicitud.getCliente().getOidCliente()); 
                      UtilidadesLog.debug("clienteGerenteL.getOid() " + clienteGerenteL.getOid()); 
                    }  
                    clienteGerenteRecomendadoL = clienteGerenteRecomendadoLH.findByClienteGerente(solicitud.getCliente().getOidCliente(), clienteGerenteL.getOid());
                    UtilidadesLog.debug("ClienteGerenteRecomendado LO ENCONTRE");                 
                } catch (NoResultException e) {
                    UtilidadesLog.debug("ClienteGerente o ClienteGerenteRecomendadoNO LO ENCONTRE");
                    return;
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                try {
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                
                      UtilidadesLog.debug("clienteGerenteRecomendadoL.getOid() " + clienteGerenteRecomendadoL.getOid()); 
                      UtilidadesLog.debug("OidPeriodo() " + solicitud.getPeriodo().getOidPeriodo()); 
                    }  
                    
                    pedidoGerenteRecomendadoL = pedidoGerenteRecomendadoLH.findByGerenteRecom(
                                                            clienteGerenteL.getOid(),
                                                            clienteGerenteRecomendadoL.getOid(),
                                                            solicitudConcurso.getOidConcurso(),
                                                            solicitud.getPeriodo().getOidPeriodo());
                    UtilidadesLog.debug("PedidoGerenteRecomendadoLocal LO ENCONTRE");
                    pedidoGerenteRecomendadoL.setPedidoValido(Boolean.TRUE);
                    pedidoGerenteRecomendadoL.setMontoPedido(new Double(pedidoGerenteRecomendadoL.getMontoPedido().doubleValue() + solicitudConcurso.getMontoValido().doubleValue()));
                    pedidoGerenteRecomendadoL.setUnidadesPedidas(new Long(pedidoGerenteRecomendadoL.getUnidadesPedidas().longValue() + solicitudConcurso.getUnidadesValidas().longValue()));
                    pedidoGerenteRecomendadoLH.merge(pedidoGerenteRecomendadoL);
                } catch (NoResultException fe) {
                    UtilidadesLog.debug("PedidoGerenteRecomendadoLocal NO LO ENCONTRE");
                    try {    
                        pedidoGerenteRecomendadoL = pedidoGerenteRecomendadoLH.create(
                                    clienteGerenteL.getOid(),
                                    clienteGerenteRecomendadoL.getOid(),
                                    solicitud.getPeriodo().getOidPeriodo(),    
                                    solicitudConcurso.getOidConcurso());
                    
                        UtilidadesLog.debug("PedidoGerenteRecomendadoLocal CREADO");
                        pedidoGerenteRecomendadoL.setPedidoValido(Boolean.TRUE);
                        pedidoGerenteRecomendadoL.setMontoPedido(new Double(solicitudConcurso.getMontoValido().doubleValue()));
                        pedidoGerenteRecomendadoL.setUnidadesPedidas(new Long(solicitudConcurso.getUnidadesValidas().longValue()));
                        pedidoGerenteRecomendadoLH.merge(pedidoGerenteRecomendadoL);
                    } catch (PersistenceException ce) {
                            UtilidadesLog.debug("Error al crear PedidoGerenteRecomendadoLocal");
                    }

                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                    
            }
        }

        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoRecomen"
            +"dadasGerente(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Concurso, Concurso concurso):Salida");
    }


    /**
     * @author Noziglia C.
     * @throws MareException
     * @param SolicitudConcurso solicitudConcurso, Solicitud solicitud
     * @return void
     * @documentation
     *
     * @date
     */
    public void actualizarCuentaCorrienteGerente(SolicitudConcurso 
        solicitudConcurso, Solicitud solicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarCuentaCorrien"
            +"teGerente(SolicitudConcurso solicitudConcurso, Solicitud "
            +"solicitud):Entrada");

        HashMap hmGerentesParticipantes = solicitudConcurso
            .getGerentesParticipantes();
        Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet()
            .iterator();
            
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
          UtilidadesLog.debug("Nro GerentesParticipantes " + hmGerentesParticipantes.size()); 

        RecuperadorIdiomaDefectoServidor recuperadorIdiomaDefectoServidor = null;
        while (itKeysGerentesParticipantes.hasNext()) {
            Long oidGerente = (Long) itKeysGerentesParticipantes.next();
            Boolean contenido = (Boolean) hmGerentesParticipantes.get(
                oidGerente);

            if (contenido.booleanValue()) {
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("Actualiza cuenta corriente concurso " + 
                    solicitudConcurso.getOidConcurso() + ", gerente " + oidGerente); 
                Long tipoMovimientoAux;
                Integer puntosValidosAux;
                Integer puntosExigidosAux;
                CuentaCorrientePuntosLocalHome cuentaCorrientePuntosLocalHome = this.getCuentaCorrientePuntosLocalHome();
                CuentaCorrientePuntosLocal cuentaCorrientePuntos;

                try {
                    //BELC300023719 - gPineda - 14/11/2006
                    int factorAnulacion;
                    if ((solicitud.getIndAnulacion()) || (solicitud
                        .getIndDevolucion())) {
                        tipoMovimientoAux = (ConstantesINC.TIPO_MOVIMIENTO_CARGO);
                        //BELC300023719 - gPineda - 14/11/2006
                        factorAnulacion = -1;
                        //puntosValidosAux = new Integer((-1) * 
                        //solicitudConcurso.getPuntosValidos().intValue()); 
                        // puntosValidosAux = (-1) * getPuntosValidos()
                        //jrivas 5/9/2006 DBLG50000943
                        /*puntosValidosAux = new Integer((-1) * solicitudConcurso
                            .getPuntosCuentaCorriente().intValue());*/
                    } else {
                        tipoMovimientoAux = (ConstantesINC
                            .TIPO_MOVIMIENTO_ABONO);
                        //BELC300023719 - gPineda - 14/11/2006
                        factorAnulacion = 1;
                        //puntosValidosAux = new Integer(solicitudConcurso.
                        //getPuntosValidos().intValue()); 
                        //puntosValidosAux = getPuntosValidos()
                        //jrivas 5/9/2006 DBLG50000943
                        /*puntosValidosAux = new Integer(solicitudConcurso
                            .getPuntosCuentaCorriente().intValue());*/
                        //puntosValidosAux = getPuntosValidos()                        
                    }

                    //jrivas 5/9/2006 DBLG50000943
                    puntosValidosAux = new Integer(solicitudConcurso.getPuntosCuentaCorriente().intValue());
                            
                    //jrivas 19/7/2006 DBLG50001046 se agrega que no sea RECOMENDADA y NUM_PEDIDOS
                    Concurso conc = new DespacharPremiosHelper().obtenerConcurso(solicitudConcurso.getOidConcurso());                    
                    if ((solicitudConcurso.getExigenciasCumplidasEnSolicitud())
                            && !(conc.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_NUM_PEDIDOS))
                            && !(conc.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_RECOMENDADA))) {
                        puntosValidosAux = new Integer(solicitudConcurso
                            .getPuntosAcumulados().intValue() + 
                                puntosValidosAux.intValue());
                        //BELC300023719 - gPineda - 14/11/2006
                        puntosExigidosAux = new Integer(solicitudConcurso
                            .getPuntosExigidos().intValue() * factorAnulacion );
                    } else {
                        puntosValidosAux = new Integer(puntosValidosAux
                            .intValue());
                        //BELC300023719 - gPineda - 14/11/2006
                        puntosExigidosAux = new Integer(solicitudConcurso
                            .getPuntosExigidosSolicitud().intValue() * factorAnulacion );
                    }
                    
                    cuentaCorrientePuntos = cuentaCorrientePuntosLocalHome.create(puntosValidosAux, puntosExigidosAux, 
                                            new Date(System.currentTimeMillis()), solicitudConcurso
                                            .getOidConcurso(), oidGerente, // Inc 19373
                                            solicitud.getPeriodo().getOidPeriodo(), 
                                            tipoMovimientoAux);

                    // numeroMovimiento = debe ser igual al oid de la entidad 
                    //cuentaCorrientePuntos
                    cuentaCorrientePuntos.setNumMovimiento(new Integer(cuentaCorrientePuntos.getOid().intValue()));

                    // DBLG700000006 - gPineda - 09/10/2006
                    String descripcion;
                    if(!solicitud.getIndAnulacion()){
                      Long oidIdioma;
                      if( solicitud.getOidIdioma() != null ){
                        oidIdioma = solicitud.getOidIdioma();
                      }else{
                        if( recuperadorIdiomaDefectoServidor == null ) { recuperadorIdiomaDefectoServidor = new RecuperadorIdiomaDefectoServidor(); }
                        oidIdioma = recuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
                      }
                      RecordSet rs = this.recuperarDatosDescripcionAbono(solicitud.getOidSolicitud(), oidIdioma, tipoMovimientoAux);
                      
                      descripcion = (String)rs.getValueAt(0, "DESCTIPOMOV") + " Puntaje del periodo " +
                      (String)rs.getValueAt(0, "DES_MARC") + " " + (String)rs.getValueAt(0, "DESCCANAL") + " " +
                      (String)rs.getValueAt(0, "COD_PERI");
                    } else {
                      descripcion = ConstantesINC.TEXTO_DESCRIPCION_ANULACION;                
                    }
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("descripcion: "+ descripcion);
                      
                    cuentaCorrientePuntos.setVal_desc( descripcion );
                    
                    cuentaCorrientePuntosLocalHome.merge(cuentaCorrientePuntos);
                    
                } catch (PersistenceException createException) {
                    UtilidadesLog.error("ERROR ", createException);
                    throw new MareException(createException, UtilidadesError
                        .armarCodigoError(CodigosError
                        .ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
        }

        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarCuentaCorrien"
            +"teGerente(SolicitudConcurso solicitudConcurso, Solicitud solici"
            +"tud):Salida");
    }


    /**
     * @author Noziglia C.
     * @throws MareException
     * @param Solicitud solicitud, SolicitudConcurso solicitudConcurso, 
     * Concurso concurso
     * @return void
     * @documentation
     * @date
     * Si en la tabla PeidodRecomendanteMultinivel existe un registro que 
     * cumpla: concurso.oidConcurso,
     * solicitud.cliente.oidCliente, solicitudPeriodo.periodo, actualizaremos 
     * el campo cantidad:
     * Si concurso.baseCalculo==ConstantesINC.BASE_CALCULO_MONTO ==> cantidad= 
     * cantidad+solicitudConcurso.montoPedido
     * Si concurso.baseCalculo==ConstantesINC.BASE_CALCULO_UNIDADES ==> 
     * cantidad= cantidad+solicitudConcurso.unidadesPedido
     * Si no existia el registro, lo creamos, inicializando cantidad con el
     * monto o unidades con el mismo criterio que antes.
     */
    public void actualizarPedidoRecomendanteMultinivel(Solicitud solicitud, 
        SolicitudConcurso solicitudConcurso, Concurso concurso) 
        throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoRecomen"
            +"danteMultinivel(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Concurso, Concurso concurso):Entrada");
            
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        PedidoRecomendanteMultinivelLocal prml;
        ClienteRecomendanteMultinivelLocalHome 
            clienteRecomendanteMultinivelHome;
        ClienteRecomendanteMultinivelLocal clienteRecomendanteMultinivel;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            PedidoRecomendanteMultinivelLocalHome prmlh = this.getPedidoRecomendanteMultinivelLocalHome();

            // Verificamos existencia de un registro por concurso.oidConcurso, 
            //solicitud.cliente.oidCliente, solicitudPeriodo.periodo
            buf.append(" SELECT OID_PEDI_RETE_MULT ");
            buf.append(" FROM INC_PEDID_RECTE_MULTI, INC_CLIEN_RECTE_MULTI ");
            buf.append(" WHERE INC_PEDID_RECTE_MULTI.CLR2_CLIE_OID_CLIE =  ");
            buf.append(" INC_CLIEN_RECTE_MULTI.OID_CLIE_RECO_MULT ");
            buf.append(" AND COPA_OID_PARA_GRAL = ").append(concurso
                .getOidConcurso());
            buf.append(" AND CLIE_OID_CLIE = ").append(solicitud.getCliente()
                .getOidCliente());
            buf.append(" AND PERD_OID_PERI = ").append(solicitud.getPeriodo()
                .getOidPeriodo());
            rs = bs.dbService.executeStaticQuery(buf.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("*** rs: "+rs);
            
            Long basecalcu = concurso.getBaseCalculo();
            Long base_calcu_monto = ConstantesINC.BASE_CALCULO_MONTO;
            Long base_calcu_unidades = ConstantesINC.BASE_CALCULO_UNIDADES;
            if ( ! rs.esVacio() ) {
                // actualizamos el PeidodRecomendanteMultinivel
                Long oidPedidoRecomendanteMultinivel = new Long(((BigDecimal) 
                    rs.getValueAt(0, 0)).longValue());
                prml = prmlh.findByPrimaryKey(oidPedidoRecomendanteMultinivel);

                if (basecalcu.equals(base_calcu_monto)) {
                    prml.setCantidad(prml.getCantidad().add(solicitudConcurso
                        .getMontoValido()));
                }
                
                if ((basecalcu.equals(base_calcu_unidades))) {
                    prml.setCantidad(prml.getCantidad().add(BigDecimal.valueOf(
                        solicitudConcurso.getUnidadesValidas().longValue())));
                }

                prml.setPuntosExigidos(new Integer( prml.getPuntosExigidos()
                    .intValue() + solicitudConcurso.getPuntosExigidos()
                    .intValue()));
                    
                prmlh.merge(prml);

            } else {
                // obtenemos el recomendante multinivel a partir del cliente
                //y del concurso
                clienteRecomendanteMultinivelHome = this.getClienteRecomendanteMultinivelLocalHome();
                clienteRecomendanteMultinivel = clienteRecomendanteMultinivelHome.findByUK(solicitud
                                                                            .getCliente().getOidCliente(), solicitudConcurso
                                                                                .getOidConcurso());
                // creamos el PeidodRecomendanteMultinivel
                prml = prmlh.create(solicitud.getPeriodo().getOidPeriodo(), clienteRecomendanteMultinivel.getOid());

                if ((basecalcu.equals(base_calcu_monto))) {
                    prml.setCantidad(solicitudConcurso.getMontoValido());
                }

                if ((basecalcu.equals(base_calcu_unidades))) {
                    prml.setCantidad(BigDecimal.valueOf(solicitudConcurso
                        .getUnidadesValidas().longValue()));
                }

                prml.setPuntosExigidos(new Integer(solicitudConcurso
                    .getPuntosExigidos().intValue()));
                prml.setPedidoValido(Boolean.TRUE);

                prmlh.merge(prml);
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            throw new MareException(createException, UtilidadesError
                .armarCodigoError(CodigosError
                .ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoRecomen"
            +"danteMultinivel(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Concurso, Concurso concurso):Salida");
    }



    /**
     * @author gdmarzi
     * @throws MareException
     * @param Solicitud solicitud, Concurso concurso, Periodo periodoGanador
     * @return void
     * @documentation
     * @date
     */
    public void actualizarPedidoRecomendadoMultinivel(Solicitud solicitud, 
        Concurso concurso, Periodo periodoGanador) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoRecomen"
        +"dadoMultinivel(Solicitud solicitud, Concurso concurso, Periodo "
        +"periodoGanador):Entrada");
        BelcorpService bs;
        RecordSet rs;
        BigDecimal cantidad = new BigDecimal(0);
        StringBuffer buf = new StringBuffer();
        PedidoRecomendadoMultinivelLocal prml;
        PedidoRecomendadoMultinivelLocalHome prmlh = this.getPedidoRecomendadoMultinivelLocalHome();
        ClienteRecomendadoMultinivelLocalHome clienteRecomendadoMultinivelHome;
        ClienteRecomendadoMultinivelLocal clienteRecomendadoMultinivel;
        ClienteRecomendanteMultinivelLocalHome 
            clienteRecomendanteMultinivelHome;
        ClienteRecomendanteMultinivelLocal clienteRecomendanteMultinivel;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            // Verificamos existencia de un registro por oidConcurso, 
            //clienteRecomendante, clienteRecomendado, periodo
            buf.append(" SELECT OID_PEDI_RECO_MULT ");
            buf.append(" FROM INC_PEDID_RECDA_MULTI PEDID,  ");
            buf.append(" INC_CLIEN_RECDO_MULTI RECOMENDADO, ");
            buf.append(" INC_CLIEN_RECTE_MULTI RECOMENDANTE  ");
            buf.append(" WHERE PEDID.CLRM_OID_CLIE_RECO_MULT =  ");
            buf.append(" RECOMENDADO.OID_CLIE_RECO_MULT ");
            buf.append(" AND RECOMENDANTE.OID_CLIE_RECO_MULT =  ");
            buf.append(" RECOMENDADO.CLR2_CLIE_OID_CLIE ");
            buf.append("  AND RECOMENDANTE.COPA_OID_PARA_GRAL = ").append(
                concurso.getOidConcurso());
            buf.append("  AND RECOMENDANTE.CLIE_OID_CLIE = ").append(
                solicitud.getCliente().getClienteRecomendante()
                    .getRecomendante());
            buf.append("  AND RECOMENDADO.CLIE_OID_CLIE = ").append(
                solicitud.getCliente().getOidCliente());
            buf.append("  AND PEDID.PERD_OID_PERI = ").append(solicitud
                .getPeriodo().getOidPeriodo());
            rs = bs.dbService.executeStaticQuery(buf.toString());
            UtilidadesLog.debug("---> rs pedido recomendante: " + rs);

            if ( ! rs.esVacio() ) {
                // actualizamos el PeidodRecomendanteMultinivel
                Long oidPedidoRecomendadoultinivel = new Long(((BigDecimal) 
                    rs.getValueAt(0, 0)).longValue());
                prml = prmlh.findByPrimaryKey(oidPedidoRecomendadoultinivel);

                //acumulamos los valores de los atributos cantidad y puntos 
                //exigidos
                if (concurso.getBaseCalculo().equals(ConstantesINC
                    .BASE_CALCULO_MONTO)) {
                    cantidad = solicitud.getSolicitudConcurso(concurso
                        .getOidConcurso()).getMontoValido(); //BELC300018969 
                } else if (concurso.getBaseCalculo().equals(ConstantesINC
                    .BASE_CALCULO_UNIDADES)) {
                    cantidad = (solicitud.getSolicitudConcurso(concurso
                        .getOidConcurso()).getUnidadesValidas() != null)
                               ? new BigDecimal(solicitud.getSolicitudConcurso(
                                concurso.getOidConcurso()).getUnidadesValidas()
                                    .longValue()) : null; //BELC300018969 
                }
               //BELC300018969 
                prml.setCantidad( prml.getCantidad().add(cantidad));
                prml.setPuntosExigidos( new Integer(prml.getPuntosExigidos()
                    .intValue() + solicitud.getSolicitudConcurso(concurso
                        .getOidConcurso()).getPuntosExigidos().intValue()));
                prmlh.merge(prml);                        

            } else {
                // Obtenemos el oidRecomendante
                clienteRecomendanteMultinivelHome = this.getClienteRecomendanteMultinivelLocalHome();
                try {
                    clienteRecomendanteMultinivel = clienteRecomendanteMultinivelHome.findByUK(solicitud
                                                            .getCliente().getClienteRecomendante()
                                                            .getRecomendante(), concurso.getOidConcurso());
                    UtilidadesLog.debug(" entidad ClienteRecomendanteMultini"
                        +"vel lo encontre");                                                                   
                } catch (NoResultException fe) {
                    UtilidadesLog.debug(" entidad ClienteRecomendanteMultinivel no lo encontre");                                                                   
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                try {
                    clienteRecomendadoMultinivelHome = this.getClienteRecomendadoMultinivelLocalHome();
                    clienteRecomendadoMultinivel = clienteRecomendadoMultinivelHome.findByUK(solicitud.getCliente().getOidCliente(), 
                                                    clienteRecomendanteMultinivel.getOid());
                    UtilidadesLog.debug(" entidad ClienteRecomendadoMultinivello encontre");                                                                                                                   
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug(" entidad ClienteRecomendanteMultinivel lo encontre");                                                                   
                        UtilidadesLog.error("ERROR ", fe);
                        throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                // Creamos el PeidodRecomendanteMultinivel                
                //BELC300018945 PedidoRecomendadoMultinivel  
                UtilidadesLog.debug("Creamos Pedido Recomendado Mutlinivel "
                    +"cliente: " + solicitud.getCliente().getOidCliente());
                prml = prmlh.create(periodoGanador.getOidPeriodo(),clienteRecomendadoMultinivel.getOid());

                if (concurso.getBaseCalculo().equals(ConstantesINC.BASE_CALCULO_MONTO)) {
                    cantidad = solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getMontoValido(); //BELC300018969 
                } else if (concurso.getBaseCalculo().equals(ConstantesINC
                    .BASE_CALCULO_UNIDADES)) {
                     //BELC300018969 
                    cantidad = (solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getUnidadesValidas() != null)
                               ? new BigDecimal(solicitud.getSolicitudConcurso(concurso.getOidConcurso()).getUnidadesValidas()
                                                         .longValue()) : null;
                }
            
                prml.setCantidad(cantidad); //BELC300018969 
                prml.setPuntosExigidos((solicitud.getSolicitudConcurso(
                    concurso.getOidConcurso()).getPuntosExigidos() != null)
                        ? new Integer(solicitud.getSolicitudConcurso(concurso
                            .getOidConcurso()).getPuntosExigidos().intValue()) 
                                : new Integer(0));
                prml.setPedidoValido(Boolean.TRUE);
                prmlh.merge(prml);
            } //rs es vacio
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            throw new MareException(createException, UtilidadesError
                .armarCodigoError(CodigosError
                    .ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoRecomen"
            +"dadoMultinivel(Solicitud solicitud, Concurso concurso, Periodo "
            +"periodoGanador):Salida");
    }


    /**
       * Sistema:     Belcorp
       * Modulo:      INC
       * Fecha:       6/03/2006
       * @version     1.0
       * @autor       Viviana Bongiovanni
    **/
    public RecordSet recuperarDatosDescripcionAbono(Long oidSolicitud, Long oidIdioma, Long oidTipoMovimiento) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.recuperarDatosDescripcionAbono(Long oidSolicitud, Long oidIdioma, Long oidTipoMovimiento): Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT gen1.VAL_I18N descTipoMov, mar.DES_MARC, gen2.VAL_I18N descCanal, corp.COD_PERI ");
        query.append(" FROM PED_SOLIC_CABEC cab, V_GEN_I18N_SICC gen1, CRA_PERIO cra, ");
        query.append(" SEG_MARCA mar, V_GEN_I18N_SICC gen2, SEG_PERIO_CORPO corp ");
        query.append(" WHERE cab.OID_SOLI_CABE = " + oidSolicitud);
        query.append(" AND cab.PERD_OID_PERI = cra.OID_PERI ");
        query.append(" AND cra.MARC_OID_MARC = mar.OID_MARC ");
        query.append(" AND gen2.ATTR_NUM_ATRI = 1 ");
        query.append(" AND gen2.ATTR_ENTI= 'SEG_CANAL' ");
        query.append(" AND gen2.VAL_OID = cra.CANA_OID_CANA ");
        query.append(" AND gen2.IDIO_OID_IDIO = " + oidIdioma);
        query.append(" AND corp.OID_PERI = cra.PERI_OID_PERI ");
        query.append(" AND gen1.ATTR_NUM_ATRI = 1  ");
        query.append(" AND gen1.ATTR_ENTI= 'INC_TIPO_MOVIM' ");
        query.append(" AND gen1.VAL_OID = " + oidTipoMovimiento);
        query.append(" AND gen1.IDIO_OID_IDIO = " + oidIdioma);

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.recuperarDatosDescripcionAbono(Long oidSolicitud, Long oidIdioma, Long oidTipoMovimiento): Salida");

        return rs;
    }

    /**
       * Modulo:      INC
       * Fecha:       31/08/2006
       * @version     1.0
       * @autor       jrivas
       * DBLG5000839
    **/
    public void actualizarGerentesRecomendacion(SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarGerentesRecomendacion(SolicitudConcurso solicitudConcurso): Entrada"); 

        HashMap hmGerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
        Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet().iterator();
        ClienteGerenteLocalHome clienteGerenteLH = this.getClienteGerenteLocalHome();
        ClienteGerenteLocal clienteGerenteL;
        Long oidGerente;
        Boolean contenido;

        while (itKeysGerentesParticipantes.hasNext()) {
            oidGerente = (Long) itKeysGerentesParticipantes.next();
            contenido = (Boolean) hmGerentesParticipantes.get(oidGerente);
            
            if (contenido.booleanValue() == true) {        
                try {
                    clienteGerenteL = clienteGerenteLH.findByGerenteConcurso(oidGerente, solicitudConcurso.getOidConcurso());
                    UtilidadesLog.debug("ClienteGerente LO ENCONTRE"); 
                } catch (NoResultException e) {
                    UtilidadesLog.debug("ClienteGerente NO LO ENCONTRE"); 
                    try {
                        clienteGerenteL = clienteGerenteLH.create(solicitudConcurso.getOidConcurso(), oidGerente);
                        UtilidadesLog.debug("ClienteGerente CREADO"); 
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        UtilidadesLog.debug("Error al crear ClienteGerente"); 
                    }
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
        }
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarGerentesRecomendacion(SolicitudConcurso solicitudConcurso): Salida"); 
    }
    
    /**
       * Modulo:      INC
       * Fecha:       31/08/2006
       * @version     1.0
       * @autor       jrivas
       * DBLG5000839
    **/
    public void actualizarClienteRecomendadoGerentes(SolicitudConcurso solicitudConcurso, Solicitud solicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarClienteRecomendadoGerentes(SolicitudConcurso solicitudConcurso): Entrada");

        HashMap hmGerentesParticipantes = solicitudConcurso.getGerentesParticipantes();
        Iterator itKeysGerentesParticipantes = hmGerentesParticipantes.keySet().iterator();
        ClienteGerenteLocal clienteGerenteL;
        ClienteGerenteLocalHome clienteGerenteLH = this.getClienteGerenteLocalHome();
        ClienteGerenteRecomendadoLocal clienteGerenteRecomendadoL;
        ClienteGerenteRecomendadoLocalHome clienteGerenteRecomendadoLH = this.getClienteGerenteRecomendadoLocalHome();
        Long oidGerente;
        Boolean contenido;
        
        while (itKeysGerentesParticipantes.hasNext()) {
            oidGerente = (Long) itKeysGerentesParticipantes.next();
            contenido = (Boolean) hmGerentesParticipantes.get(oidGerente);
            if (contenido.booleanValue() == true) {        
                try {
                    clienteGerenteL = clienteGerenteLH.findByGerenteConcurso(oidGerente, solicitudConcurso.getOidConcurso());
                    UtilidadesLog.debug("ClienteGerente LO ENCONTRE"); 
                } catch (NoResultException e) {
                    UtilidadesLog.debug("ClienteGerente NO LO ENCONTRE"); 
                    return;
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                try {
                    clienteGerenteRecomendadoL = clienteGerenteRecomendadoLH.findByClienteGerente(solicitud.getCliente().getOidCliente(), clienteGerenteL.getOid());
                    UtilidadesLog.debug("ClienteGerenteRecomendado LO ENCONTRE"); 
                } catch (NoResultException fe) {
                    UtilidadesLog.debug("ClienteGerenteRecomendado NO LO ENCONTRE"); 
                    try {    
                        clienteGerenteRecomendadoL = clienteGerenteRecomendadoLH.create(solicitud.getCliente().getOidCliente(), 
                                                solicitud.getPeriodo().getOidPeriodo(), 
                                                clienteGerenteL.getOid());
                        UtilidadesLog.debug("ClienteGerenteRecomendado CREADO");                                
                    } catch (PersistenceException ce) {
                            UtilidadesLog.debug("Error al crear ClienteGerenteRecomendado"); 
                    }

                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                    
            }
        }
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarClienteRecomendadoGerentes(SolicitudConcurso solicitudConcurso): Salida");
    }    

    /**
     * Este metodo elimina el registro de INC:CandidataGanadora(candGan)
     * DBLG700000193 - 22/11/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param solicitudConcurso
     * @param solicitud
     * @author gPineda
     */
    public void anularCandidataGanadora(Solicitud solicitud, SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("anularCandidataGanadora(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Entrada");
        StringBuffer query = new StringBuffer();

        try {
          query.append(" DELETE INC_CANDI_GANAD GAN  ");
          query.append("  WHERE GAN.CLIE_OID_CLIE = " + solicitud.getCliente().getOidCliente() );
          
          // 26/12/06 - gPineda
          if( solicitudConcurso.getIndAnulaPedido() && !solicitudConcurso.getIndAnulaCandidataGanadora() ){
            query.append("    AND GAN.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo() );
          }
          
          query.append("    AND GAN.COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso() );

          BelcorpService.getInstance().dbService.executeUpdate( query.toString() );

        }catch (Exception e) {
            throw new MareException("anularCandidataGanadora()", e );
        }
        UtilidadesLog.info("anularCandidataGanadora(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
    }
    
    //jrivas 5/12/2006 Cambio Cierre Incentivos Performance
    public boolean actualizarCandidata(Long oidConcurso, Long oidLiente, Long periodo, int numerPeriodosEvaluados) throws MareException {
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        query.append(" UPDATE INC_CANDI_GANAD ");
        query.append(" SET VAL_REQU_PREM_SUPE = 0,  ");
        query.append(" BINC_OID_BASE_INCU = NULL,  ");
        query.append(" PERD_OID_PERI_EVAL = NULL,  ");
        query.append(" NUM_PERI_EVAL = " + numerPeriodosEvaluados);
        query.append(" WHERE COPA_OID_PARA_GRAL = " + oidConcurso);
        query.append(" AND CLIE_OID_CLIE = " + oidLiente);
        query.append(" AND PERD_OID_PERI = " + periodo);

        try {
            bs = BelcorpService.getInstance();
            int rs = bs.dbService.executeUpdate(query.toString());
            if (rs > 0) {
              return true;
            } else {
              return false;
            }
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Error " , e);
            throw new MareException(e);
        }
    }

    //jrivas 5/12/2006 Cambio Cierre Incentivos Performance
    public void insertarCandidata(Long oidConcurso, Long oidLiente, Long periodo, int numerPeriodosEvaluados, boolean metasSuperadas, boolean requisitosSuperados) throws MareException {
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        int meta = 0;
        int req = 0;
        if (metasSuperadas) {
            meta = 1;
        }
        if (requisitosSuperados) {
            req = 1;
        }        
        query.append(" INSERT INTO INC_CANDI_GANAD ( OID_CAND_GANA, ");
        query.append(" IND_META_SUPE, VAL_REQU_PREM_SUPE, PERD_OID_PERI, ");
        query.append(" COPA_OID_PARA_GRAL, CLIE_OID_CLIE, NUM_PERI_EVAL )  ");
        query.append(" VALUES (INC_CAGA_SEQ.nextval,  " + meta);
        query.append(" , " + req);
        query.append(" , " + periodo);
        query.append(" , " + oidConcurso);
        query.append(" , " + oidLiente);
        query.append(" , " + numerPeriodosEvaluados);
        query.append(" ) ");

        try {
            bs = BelcorpService.getInstance();
            int rs = bs.dbService.executeUpdate(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Error " , e);
            throw new MareException(e);
        }
    }
    
    private MONIncentivosLocalHome getMONIncentivosLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONIncentivosLocalHome)context.lookup("java:comp/env/ejb/local/MONIncentivos");
    }    

    /*
     * JVM - sicc 200702375,  se agrega el metodo actualizarRecomendadasRecomendante
     */
    public void actualizarRecomendadasRecomendante(SolicitudConcurso 
        solicitudConcurso, Solicitud solicitud) throws MareException {

        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarRecomendadasRecomendante(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Entrada");

        if (solicitud.getCliente().getIndRecomendadosEnINC() == true ){
       
            // ---------------------------------------------------------------------------------------
            // JVM, sicc 20070381, "contenidoEn" VinculoRecomendante DES-HAS, crea clienteRecomendante     
            // ---------------------------------------------------------------------------------------    
            DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
            Concurso concurso = desPreH.obtenerConcurso(solicitudConcurso.getOidConcurso());
            boolean noValidaEnPeriodo = false;   
            
            ClienteRecomendado clienteRecomendados = new ClienteRecomendado();

            if (solicitud.getCliente().getClienteRecomendante() != null){
                solicitud.getCliente().getClienteRecomendante().setContenidoEnPeriodo(false);    
            }
        
            for(int i=0; i<solicitud.getCliente().getClienteRecomendado().size(); i++)
            {
                clienteRecomendados = (ClienteRecomendado) solicitud.getCliente().getClienteRecomendado().get(i);

                clienteRecomendados.setContenidoEnPeriodo
                (
                  clienteRecomendados.getPeriodo().contenidoEn(concurso.getPeriodoDesde(),concurso.getPeriodoHasta())
                );                
                    
                if (solicitud.getCliente().getClienteRecomendante() != null)
                {                                
                    solicitud.getCliente().getClienteRecomendante().setContenidoEnPeriodo
                        (
                            solicitud.getCliente().getClienteRecomendante().getContenidoEnPeriodo()
                            ||
                            clienteRecomendados.getContenidoEnPeriodo()
                        );                    
                        
                    noValidaEnPeriodo = solicitud.getCliente().getClienteRecomendante().getContenidoEnPeriodo();                        
                }else{
                    noValidaEnPeriodo = clienteRecomendados.getContenidoEnPeriodo() || noValidaEnPeriodo;
                }
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("idx("+i+") " + 
                                    "Recomendante["+clienteRecomendados.getRecomendante()+"] - "  +
                                    "ContenidoEnPeriodo("+noValidaEnPeriodo+ ") " +
                                    "Recomendado["+clienteRecomendados.getRecomendado()+"] " +
                                    "ContenidoEnPeriodo("+clienteRecomendados.getContenidoEnPeriodo()+")"
                                    );
                                    
            }
            
            if (noValidaEnPeriodo)
            {
                // Recomendante
                ClienteRecomendanteLocalHome clienteRecomendanteHome = this.getClienteRecomendanteLocalHome();
                ClienteRecomendanteLocal clienteRecomendante;
                // Recomendado
                ClienteRecomendadoLocalHome clienteRecomendadoHome;
                ClienteRecomendadoLocal clienteRecomendado;
                
                try {    
                    clienteRecomendante = clienteRecomendanteHome.findByUK( solicitud.getCliente().getOidCliente(),
                                                                            solicitudConcurso.getOidConcurso());    
                    
                    UtilidadesLog.debug(" clienteRecomendante.findByUK, FOUND");                                                                                                                                               
                    
                } catch (NoResultException fe) {
                    UtilidadesLog.debug(" clienteRecomendante.findByUK, NOT_FOUND");
                     try {
                        clienteRecomendante = clienteRecomendanteHome.create(solicitud.getCliente().getOidCliente(),
                                                                            solicitudConcurso.getOidConcurso());
                                                                            
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                                            
                          UtilidadesLog.debug(" clienteRecomendante.create, CREATED with OID: " + clienteRecomendante.getOid());                                                                                                                   
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
    
                ArrayList lstRecomendado = solicitud.getCliente().getClienteRecomendado();
        
                for(int i=0; i< lstRecomendado.size(); i++){
        
                    clienteRecomendados = (ClienteRecomendado) lstRecomendado.get(i);
               
                    // ---------------------------------------------------------------------------------------
                    // JVM, sicc 20070381, "contenidoEn" VinculoRecomendado DES-HAS, crea clienteRecomendado     
                    // ---------------------------------------------------------------------------------------    
                    if ( clienteRecomendados.getContenidoEnPeriodo() ) {               
                        try {
                            clienteRecomendadoHome = this.getClienteRecomendadoLocalHome();
                                         
                            clienteRecomendado = clienteRecomendadoHome.findByUK(clienteRecomendante.getOid(), clienteRecomendados.getRecomendado());
                            UtilidadesLog.debug(" clienteRecomendadoHome.findByUK, FOUND");                                                                                                                   
                            // vbongiov -- RI SiCC 20090941 -- 16/06/2009 
                            //clienteRecomendado.setPeriodoInicioVinculo(solicitud.getPeriodo().getOidPeriodo());
                            //clienteRecomendado.setEfectiva(Boolean.FALSE);
                            //clienteRecomendadoHome.merge(clienteRecomendado);
                        } catch (NoResultException fe) {
                            try {
                                UtilidadesLog.debug(" clienteRecomendadoHome.findByUK, NOT_FOUND");                                                                                                                   
                                clienteRecomendadoHome = this.getClienteRecomendadoLocalHome();
                                                                                
                                clienteRecomendado = clienteRecomendadoHome.create( clienteRecomendados.getRecomendado(), 
                                                                            clienteRecomendados.getPeriodo().getOidPeriodo(),       //JVM, sicc 20070381 solicitud.getPeriodo().getOidPeriodo(), 
                                                                            clienteRecomendante.getOid()); 
                                                      
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                                                                    
                                  UtilidadesLog.debug(" clienteRecomendado.create, CREATED with OID="+clienteRecomendado.getOid());                                                                                                                   
            
                            } catch (PersistenceException ce) {
                                if(ce.getMessage().indexOf(UK_RECOMENDADA)<0) { //sapaza -- PER-SiCC-2010-0455 -- 20/07/2010
                                    UtilidadesLog.error("ERROR ", ce);
                                    throw new MareException(ce, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                }        
                            }            
                        } catch (PersistenceException ce) {
                             UtilidadesLog.error("ERROR ", ce);
                             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }                    
                }                
            } 
            
        }else{
            if (solicitud.getCliente().getClienteRecomendado().size() > 0) {
                UtilidadesLog.debug("NO SE ACTUALIZA POR ESTAR TODAS EN MAE");
            }else{
                UtilidadesLog.debug("NO EXISTEN RECOMENDADOS ASOCIADOS");
            }
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarRecomendadasRecomendante(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Salida");
    }


    /*
     * JVM - sicc 20070381,  se agrega el metodo actualizarRecomendadasRecomendante
     */
    public Periodo buscaPeridoVinculoRecomendante
    (
            SolicitudConcurso   solicitudConcurso, 
            Solicitud           solicitud
    ) throws MareException 
    {

        UtilidadesLog.info("DAOSolicitudActualizacion.buscaPeridoVinculoRecomendante(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Entrada");
        
        if (solicitud.getCliente().getClienteRecomendado().size() > 0)
        {
            // ---------------------------------------------------------------------------------------
            // JVM, sicc 20070381, "contenidoEn" VinculoRecomendante DES-HAS, crea clienteRecomendante     
            // ---------------------------------------------------------------------------------------    
            DespacharPremiosHelper desPreH= new DespacharPremiosHelper();
            Concurso concurso = desPreH.obtenerConcurso(solicitudConcurso.getOidConcurso());
             
            ClienteRecomendado clienteRecomendados = new ClienteRecomendado();
            
            for(int i=0; i<solicitud.getCliente().getClienteRecomendado().size(); i++)
            {
                clienteRecomendados = (ClienteRecomendado) solicitud.getCliente().getClienteRecomendado().get(i);                
            
                    if(clienteRecomendados.getPeriodo().contenidoEn(concurso.getPeriodoDesde(), concurso.getPeriodoHasta())) {                          
                        UtilidadesLog.info( "DAOSolicitudActualizacion.buscaPeridoVinculoRecomendante"+
                                            "(SolicitudConcurso solicitudConcurso, Solicitud solicitud):"+ 
                                            "Salida, return PERIODO("+
                                            clienteRecomendados.getPeriodo().getOidPeriodo()+")");
                                            
                        return(clienteRecomendados.getPeriodo());
                    }
            }
        }
                
        UtilidadesLog.info("DAOSolicitudActualizacion.buscaPeridoVinculoRecomendante(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Salida, return(NULL)");
        return(null);
    }
    
    // vbongiov -- Cambio 20090841 -- 6/07/2009
    public void guardaSolicitudConcursoRecomendadoTemporal(SolicitudConcurso solicitudConcurso, Solicitud solicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.guardaSolicitudConcursoRecomendadoTemporal(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Entrada");
        
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String strFecha = sdf.format(solicitud.getFechaDocumento());
        
        query.append(" INSERT INTO INC_SOLIC_CONCU_RECOM_TEMP (OID_SOLI_CONC_RECO, FEC_DOCU, ");   
        query.append(" IND_SOLI_VALI, IMP_MONT_SOLI, NUM_UNID_SOLI, ");   
        query.append(" COPA_OID_PARA_GRAL, SOCA_OID_SOLI_CABE, ");  
        query.append(" CLIE_OID_CLIE, PERD_OID_PERI, CLIE_OID_CLIE_GERE) ");  
        query.append(" VALUES (INC_SCRT_SEQ.NEXTVAL, TO_DATE('"+ strFecha + "', 'DD-MM-YYYY'), ");
        query.append(" 1, " + solicitudConcurso.getMontoValido() + ", " + solicitudConcurso.getUnidadesValidas()); 
        query.append(" , " + solicitudConcurso.getOidConcurso() + ", " + solicitud.getOidSolicitud()); 
        query.append(" , " + solicitud.getCliente().getOidCliente() + ", " + solicitud.getPeriodo().getOidPeriodo() + ", NULL) "); 
        
        try {
              bs.dbService.executeUpdate(query.toString());     
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        UtilidadesLog.info("DAOSolicitudActualizacion.guardaSolicitudConcursoRecomendadoTemporal(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Salida");
    }
    
    // vbongiov -- Cambio 20090841 -- 6/07/2009
    public void actualizarPedidoConcursoRecomendadoTemporal(SolicitudConcurso solicitudConcurso, Solicitud solicitud, Concurso concurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoConcursoRecomendadoTemporal(SolicitudConcurso solicitudConcurso, Solicitud solicitud, Concurso concurso):Entrada");
        
        if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA())) {
        
            RecordSet rs = new RecordSet();
            StringBuffer query = new StringBuffer();
            StringBuffer query1 = new StringBuffer();
            BelcorpService bs;
            int cant = 0;
    
            try {
                bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            
            query.append(" UPDATE INC_PEDID_CONCU_RECOM_TEMP ");   
            query.append(" SET IMP_MONT_PEDI = (IMP_MONT_PEDI + " + solicitudConcurso.getMontoValido() + "), ");   
            query.append(" NUM_UNID_PEDI = (NUM_UNID_PEDI + " + solicitudConcurso.getUnidadesValidas() + ") ");
            query.append(" WHERE COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());  
            query.append(" AND PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());  
            query.append(" AND CLIE_OID_CLIE_RETE = " + solicitud.getCliente().getOidCliente());          
            
            try {
                  cant = bs.dbService.executeUpdate(query.toString());     
            } catch (Exception e){       
                  e.printStackTrace();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }  
            
            if(cant==0){
                 // No existe el registro hay que crearlo
                 query.delete(0, query.length());
                 query.append(" INSERT INTO INC_PEDID_CONCU_RECOM_TEMP( ");   
                 query.append(" OID_PEDI_CONC_RECO, IMP_MONT_PEDI, NUM_UNID_PEDI, ");   
                 query.append(" PERD_OID_PERI, COPA_OID_PARA_GRAL, CLIE_OID_CLIE_RETE) "); 
                 query.append(" VALUES (INC_PCRT_SEQ.NEXTVAL, "+ solicitudConcurso.getMontoValido() + ", " + solicitudConcurso.getUnidadesValidas());
                 query.append(" , " + solicitud.getPeriodo().getOidPeriodo() + ", " + solicitudConcurso.getOidConcurso()); 
                 query.append(" , " + solicitud.getCliente().getOidCliente() + ") " ); 
                 
                try {
                      bs.dbService.executeUpdate(query.toString());     
                } catch (Exception e){       
                      e.printStackTrace();
                      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }                  
            }
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarPedidoConcursoRecomendadoTemporal(SolicitudConcurso solicitudConcurso, Solicitud solicitud, Concurso concurso):Salida");
    }
    
    // vbongiov -- Cambio 20090841 -- 6/07/2009
    public void guardaSolicitudConcursoRecomendadoFuturo(SolicitudConcurso solicitudConcurso, Solicitud solicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.guardaSolicitudConcursoRecomendadoFuturo(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Entrada");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        StringBuffer query2 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        // Busca si el recomendante fue un recomendante futuro
        query.append(" SELECT FEC_DOCU, IND_SOLI_VALI, IMP_MONT_SOLI, NUM_UNID_SOLI, ");   
        query.append(" COPA_OID_PARA_GRAL, SOCA_OID_SOLI_CABE, ");   
        query.append(" CLIE_OID_CLIE, PERD_OID_PERI, CLIE_OID_CLIE_GERE ");   
        query.append(" FROM INC_SOLIC_CONCU_RECOM_TEMP solConTemp ");   
        query.append(" WHERE solConTemp.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());   
        query.append(" AND solConTemp.COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());   
        query.append(" AND solConTemp.CLIE_OID_CLIE = " + solicitud.getCliente().getClienteRecomendante().getRecomendante());   
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        if(!rs.esVacio()){        
            // sapaza -- PER-SiCC-2010-0312 -- 14/05/2010
            StringBuffer queryAux = new StringBuffer();
            RecordSet rsAux = new RecordSet();
            queryAux.append(" SELECT COUNT(1) contador ");   
            queryAux.append(" FROM INC_SOLIC_CONCU_RECOM ");   
            queryAux.append(" WHERE PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());   
            queryAux.append(" AND COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());   
            queryAux.append(" AND CLIE_OID_CLIE = " + solicitud.getCliente().getClienteRecomendante().getRecomendante());   
            queryAux.append(" AND SOCA_OID_SOLI_CABE = " + (BigDecimal) rs.getValueAt(0,"SOCA_OID_SOLI_CABE"));   

            try {
                rsAux = bs.dbService.executeStaticQuery(queryAux.toString());
            } catch (Exception e){       
                  e.printStackTrace();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }  
            int ocurrencias = ((BigDecimal) rsAux.getValueAt(0,"contador")).intValue();
        
            if(ocurrencias == 0) {
                Date fechaDoc = (Date) rs.getValueAt(0,"FEC_DOCU");
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String strFecha = sdf.format(fechaDoc);
            
                query1.append(" INSERT INTO INC_SOLIC_CONCU_RECOM (OID_SOLI_CONC_RECO, FEC_DOCU, ");   
                query1.append(" IND_SOLI_VALI, IMP_MONT_SOLI, NUM_UNID_SOLI, ");   
                query1.append(" COPA_OID_PARA_GRAL, SOCA_OID_SOLI_CABE, ");  
                query1.append(" CLIE_OID_CLIE, PERD_OID_PERI, CLIE_OID_CLIE_GERE) ");  
                query1.append(" VALUES (INC_SOCR_SEQ.NEXTVAL, TO_DATE('"+ strFecha + "', 'DD-MM-YYYY') ");
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"IND_SOLI_VALI") + ", " + (BigDecimal) rs.getValueAt(0,"IMP_MONT_SOLI") + ", " + (BigDecimal) rs.getValueAt(0,"NUM_UNID_SOLI")); 
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"COPA_OID_PARA_GRAL") + ", " + (BigDecimal) rs.getValueAt(0,"SOCA_OID_SOLI_CABE")); 
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"CLIE_OID_CLIE") + ", " + (BigDecimal) rs.getValueAt(0,"PERD_OID_PERI") + ", NULL) "); 
            
                try {
                      bs.dbService.executeUpdate(query1.toString());     
                } catch (Exception e){       
                     // e.printStackTrace();
                    //throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }  
            }    
            
            query2.append(" DELETE INC_SOLIC_CONCU_RECOM_TEMP solConTemp ");   
            query2.append(" WHERE solConTemp.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());   
            query2.append(" AND solConTemp.COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());   
            query2.append(" AND solConTemp.CLIE_OID_CLIE = " + solicitud.getCliente().getClienteRecomendante().getRecomendante());   
            
            try {
                  bs.dbService.executeUpdate(query2.toString());     
            } catch (Exception e){       
                  e.printStackTrace();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }  
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.guardaSolicitudConcursoRecomendadoFuturo(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Salida");
    }
    
    // vbongiov -- Cambio 20090841 -- 6/07/2009
    public void guardarPedidoConcursoRecomendadoFuturo(SolicitudConcurso solicitudConcurso, Solicitud solicitud, Concurso concurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.guardarPedidoConcursoRecomendadoFuturo(SolicitudConcurso solicitudConcurso, Solicitud solicitud, Concurso concurso):Entrada");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        StringBuffer query2 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        // Busca si el recomendante fue un recomendante futuro
        query.append(" SELECT pedConTemp.IMP_MONT_PEDI, pedConTemp.NUM_UNID_PEDI, ");   
        query.append(" pedConTemp.PERD_OID_PERI, pedConTemp.COPA_OID_PARA_GRAL, cliRete.OID_CLIE_RETE ");   
        query.append(" FROM INC_PEDID_CONCU_RECOM_TEMP pedConTemp, INC_CLIEN_RECTE cliRete ");   
        query.append(" WHERE pedConTemp.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());   
        query.append(" AND pedConTemp.COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());   
        query.append(" AND pedConTemp.CLIE_OID_CLIE_RETE = " + solicitud.getCliente().getClienteRecomendante().getRecomendante());   
        query.append(" AND pedConTemp.CLIE_OID_CLIE_RETE = cliRete.CLIE_OID_CLIE ");  
        query.append(" AND pedConTemp.COPA_OID_PARA_GRAL = cliRete.COPA_OID_PARA_GRAL ");  
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        if(!rs.esVacio()){        
            // sapaza -- PER-SiCC-2010-0312 -- 14/05/2010
            StringBuffer queryAux = new StringBuffer();
            RecordSet rsAux = new RecordSet();
            queryAux.append(" SELECT COUNT(1) contador ");   
            queryAux.append(" FROM INC_PEDID_CONCU_RECOM ");   
            queryAux.append(" WHERE PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());   
            queryAux.append(" AND COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());   
            queryAux.append(" AND CLRE_OID_CLIE_REDO IS NULL ");   
            queryAux.append(" AND CLR3_OID_CLIE_RETE = " + (BigDecimal) rs.getValueAt(0,"OID_CLIE_RETE"));   

            try {
                rsAux = bs.dbService.executeStaticQuery(queryAux.toString());
            } catch (Exception e){       
                  e.printStackTrace();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }  
            int ocurrencias = ((BigDecimal) rsAux.getValueAt(0,"contador")).intValue();
            
            if(ocurrencias == 0) {
                query1.append(" INSERT INTO INC_PEDID_CONCU_RECOM( ");   
                query1.append(" OID_PEDI_CONC_RECO, IMP_MONT_PEDI, NUM_UNID_PEDI, ");   
                query1.append(" PERD_OID_PERI, COPA_OID_PARA_GRAL, CLR3_OID_CLIE_RETE) "); 
                query1.append(" VALUES (INC_PECR_SEQ.NEXTVAL, "+ (BigDecimal) rs.getValueAt(0,"IMP_MONT_PEDI") + ", " + (BigDecimal) rs.getValueAt(0,"NUM_UNID_PEDI"));
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"PERD_OID_PERI") + ", " + (BigDecimal) rs.getValueAt(0,"COPA_OID_PARA_GRAL")); 
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"OID_CLIE_RETE") + ") " ); 
                
                try {
                      bs.dbService.executeUpdate(query1.toString());     
                } catch (Exception e){       
                      //e.printStackTrace();
                      //throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }  
            }    
            
            query2.append(" DELETE INC_PEDID_CONCU_RECOM_TEMP pedConTemp ");   
            query2.append(" WHERE pedConTemp.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());   
            query2.append(" AND pedConTemp.COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());   
            query2.append(" AND pedConTemp.CLIE_OID_CLIE_RETE = " + solicitud.getCliente().getClienteRecomendante().getRecomendante());    
            
            try {
                  bs.dbService.executeUpdate(query2.toString());     
            } catch (Exception e){       
                  e.printStackTrace();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }  
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.guardarPedidoConcursoRecomendadoFuturo(SolicitudConcurso solicitudConcurso, Solicitud solicitud, Concurso concurso):Salida");
    }
    
    // vbongiov -- Cambio 20090841 -- 6/07/2009
    public void guardaSolicitudConcursoPuntajeTemporal( Solicitud solicitud, SolicitudConcurso solicitudConcurso, Concurso concurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.guardaSolicitudConcursoPuntajeTemporal( Solicitud solicitud, SolicitudConcurso solicitudConcurso, Concurso concurso):Entrada");
        
        if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA())) {
        
            StringBuffer query = new StringBuffer();
            BelcorpService bs;
    
            try {
                bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String strFecha = sdf.format(solicitud.getFechaDocumento());
            
            Boolean indAnulacion = new Boolean(solicitud.getIndAnulacion() || solicitud.getIndDevolucion());
            
            query.append(" INSERT INTO INC_SOLIC_CONCU_PUNTA_TEMP (OID_SOLI_CONC_PUNT, ");   
            query.append(" COPA_OID_PARA_GRAL, SOCA_OID_SOLI_CABE, CLIE_OID_CLIE, ");   
            query.append(" PERD_OID_PERI, FEC_DOCU, ");   
            query.append(" IND_ANUL, ");
            query.append(" NUM_PUNT, ");
            query.append(" VAL_PUNT_BONI, ");
            query.append(" VAL_PUNT_FALT_NANU, ");
            query.append(" IMP_MONT, "); 
            query.append(" NUM_UNID, "); 
            query.append(" CLIE_OID_CLIE_GERE) "); 
            query.append(" VALUES (INC_SCPT_SEQ.NEXTVAL");
            query.append(" , " + solicitudConcurso.getOidConcurso() + ", " + solicitud.getOidSolicitud() + ", " + solicitud.getCliente().getOidCliente()); 
            query.append(" , " + solicitud.getPeriodo().getOidPeriodo() + ", TO_DATE('"+ strFecha + "', 'DD-MM-YYYY') "); 
            query.append(" , " + (indAnulacion.booleanValue()?"1":"0"));             
            query.append(" , " + new Double(solicitudConcurso.getPuntosValidos().doubleValue() + solicitudConcurso.getPuntosBonificados().doubleValue()).intValue());             
            query.append(" , " + new Double(solicitudConcurso.getPuntosBonificados().doubleValue()).intValue()); 
            query.append(" , " + solicitudConcurso.getPuntosFaltantesNoAnunciados().intValue()); 
            
            // IMP_MONT
            if (ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.equals(concurso.getFormaCalculo())) {
                query.append(" , " + solicitudConcurso.getMontoBonificado());                
            } else {
                query.append(" , " + solicitudConcurso.getMontoValido()); 
            }
            
            // NUM_UNID
            if (solicitudConcurso.getUnidadesValidas() != null) {
                query.append(" , " + solicitudConcurso.getUnidadesValidas().intValue()); 
            } else {
                query.append(" , NULL "); 
            }
            
            // CLIE_OID_CLIE_GERE
            query.append(" , NULL ) "); 
            
            try {
                  bs.dbService.executeUpdate(query.toString());     
            } catch (Exception e){       
                  e.printStackTrace();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }  
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.guardaSolicitudConcursoPuntajeTemporal( Solicitud solicitud, SolicitudConcurso solicitudConcurso, Concurso concurso):Salida");
    }    
    
    // vbongiov -- Cambio 20090841 -- 6/07/2009
    public void guardaSolicitudConcursoPuntajeFuturo(SolicitudConcurso solicitudConcurso, Solicitud solicitud) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.guardaSolicitudConcursoPuntajeFuturo(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Entrada");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        StringBuffer query2 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        // Busca si el recomendante fue un recomendante futuro
        query.append(" SELECT COPA_OID_PARA_GRAL, SOCA_OID_SOLI_CABE, CLIE_OID_CLIE, ");   
        query.append(" PERD_OID_PERI, FEC_DOCU, IND_ANUL, NUM_PUNT, ");   
        query.append(" VAL_PUNT_BONI, VAL_PUNT_FALT_NANU, IMP_MONT, NUM_UNID, CLIE_OID_CLIE_GERE ");   
        query.append(" FROM INC_SOLIC_CONCU_PUNTA_TEMP ");   
        query.append(" WHERE PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());   
        query.append(" AND COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());   
        query.append(" AND CLIE_OID_CLIE = " + solicitud.getCliente().getClienteRecomendante().getRecomendante());   
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        if(!rs.esVacio()){        
            // sapaza -- PER-SiCC-2010-0312 -- 14/05/2010
            StringBuffer queryAux = new StringBuffer();
            RecordSet rsAux = new RecordSet();
            queryAux.append(" SELECT COUNT(1) contador ");   
            queryAux.append(" FROM INC_SOLIC_CONCU_PUNTA ");   
            queryAux.append(" WHERE PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());   
            queryAux.append(" AND COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());   
            queryAux.append(" AND CLIE_OID_CLIE = " + solicitud.getCliente().getClienteRecomendante().getRecomendante());   

            try {
                rsAux = bs.dbService.executeStaticQuery(queryAux.toString());
            } catch (Exception e){       
                  e.printStackTrace();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }  
            int ocurrencias = ((BigDecimal) rsAux.getValueAt(0,"contador")).intValue();
        
            if(ocurrencias == 0) {
                Date fechaDoc = (Date) rs.getValueAt(0,"FEC_DOCU");
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String strFecha = sdf.format(fechaDoc);
            
                query1.append(" INSERT INTO INC_SOLIC_CONCU_PUNTA (OID_SOLI_CONC_PUNT, ");   
                query1.append(" COPA_OID_PARA_GRAL, SOCA_OID_SOLI_CABE, CLIE_OID_CLIE, ");   
                query1.append(" PERD_OID_PERI, FEC_DOCU, ");   
                query1.append(" IND_ANUL, ");
                query1.append(" NUM_PUNT, ");
                query1.append(" VAL_PUNT_BONI, ");
                query1.append(" VAL_PUNT_FALT_NANU, ");
                query1.append(" IMP_MONT, "); 
                query1.append(" NUM_UNID, "); 
                query1.append(" CLIE_OID_CLIE_GERE) "); 
                query1.append(" VALUES (INC_SOCP_SEQ.NEXTVAL");            
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"COPA_OID_PARA_GRAL") + ", " + (BigDecimal) rs.getValueAt(0,"SOCA_OID_SOLI_CABE") + ", " + (BigDecimal) rs.getValueAt(0,"CLIE_OID_CLIE")); 
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"PERD_OID_PERI") + ",  TO_DATE('"+ strFecha + "', 'DD-MM-YYYY') ");            
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"IND_ANUL") + ", " + (BigDecimal) rs.getValueAt(0,"NUM_PUNT") + ", " + (BigDecimal) rs.getValueAt(0,"VAL_PUNT_BONI")); 
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"VAL_PUNT_FALT_NANU") + ", " + (BigDecimal) rs.getValueAt(0,"IMP_MONT") + ", " + (BigDecimal) rs.getValueAt(0,"NUM_UNID")); 
                query1.append(" , " + (BigDecimal) rs.getValueAt(0,"CLIE_OID_CLIE_GERE") + ") ");             
                
                try {
                      bs.dbService.executeUpdate(query1.toString());     
                } catch (Exception e){       
                      //e.printStackTrace();
                      //throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }  
            }    
            
            query2.append(" DELETE INC_SOLIC_CONCU_PUNTA_TEMP ");   
            query2.append(" WHERE PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());   
            query2.append(" AND COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());   
            query2.append(" AND CLIE_OID_CLIE = " + solicitud.getCliente().getClienteRecomendante().getRecomendante());   
            
            try {
                  bs.dbService.executeUpdate(query2.toString());     
            } catch (Exception e){       
                  e.printStackTrace();
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }  
        }
        
        UtilidadesLog.info("DAOSolicitudActualizacion.guardaSolicitudConcursoPuntajeFuturo(SolicitudConcurso solicitudConcurso, Solicitud solicitud):Salida");
    }

    // vbongiov -- Cambio 20080811 -- 26/08/2009
    public String actualizarSorteo(Solicitud solicitud, SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSorteo(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Entrada");
        
        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();
        StringBuffer query1 = new StringBuffer();
        StringBuffer numerosAsignar = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
        
            query.append(" SELECT NVL(MAX(parSorteo.NUM_ASIG), 0) NUM_MAX ");
            query.append(" FROM INC_PARTI_SORTE parSorteo ");
            query.append(" WHERE parSorteo.COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());
                
            respuesta = bs.dbService.executeStaticQuery(query.toString());    
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        DespacharPremiosHelper desPreH = new DespacharPremiosHelper();
        Concurso concurso = desPreH.obtenerConcurso(solicitudConcurso.getOidConcurso());
        long numMax = ((BigDecimal) respuesta.getValueAt(0, "NUM_MAX")).longValue();
        
        int cant = concurso.getCantidadNumerosAOtorgar().intValue();
        
        query1.append("  BEGIN");
        
        for(int i=0; i < cant; i++){
        
            numMax = numMax + 1;
            
            numerosAsignar.append(", ").append(numMax);

            query1.append(" INSERT INTO INC_PARTI_SORTE ");   
            query1.append(" (OID_PART_SORT, COPA_OID_PARA_GRAL, NUM_ASIG, PERD_OID_PERI, ");
            query1.append("  CLIE_OID_CLIE,  SOCA_OID_SOLI_CABE,  IND_ANUL) ");
            query1.append("  VALUES (INC_PARS_SEQ.NEXTVAL, " + solicitudConcurso.getOidConcurso() + ", " + numMax + ", " +
                             solicitud.getPeriodo().getOidPeriodo() + ", " + solicitud.getCliente().getOidCliente() + ", " +
                             solicitud.getOidSolicitud() + ", 0); " );
                        
        }            
        
        query1.append("  END;"); 
        
        try {
              bs.dbService.executeUpdate(query1.toString());     
        } catch (DuplicateKeyException ex) {
              ex.printStackTrace();
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }     
        
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarSorteo(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
        
        return numerosAsignar.toString().substring(2);
    }
    
    // vbongiov -- Cambio 20080811 -- 26/08/2009
    public void actualizarCuentaCorrienteSorteo(Solicitud solicitud, SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarCuentaCorrienteSorteo(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Entrada");
        CuentaCorrientePuntosLocalHome cuentaCorrientePuntosHome = this.getCuentaCorrientePuntosLocalHome();
        CuentaCorrientePuntosLocal cuentaCorrientePuntos;
        Long tipoMovimientoAux;
        Double puntosValidosAux;
        Integer numPunt = new Integer(0);
        Integer numPuntExig;
        Date fecMovi = solicitud.getFechaDocumento();
        Long copaOidParaGral = solicitudConcurso.getOidConcurso();
        Long clieOidClie = null;
        Long perdOidPeri = solicitud.getPeriodo().getOidPeriodo();
        String descripcion = "";

        UtilidadesLog.debug(" fecMovi " + fecMovi);
        UtilidadesLog.debug(" copaOidParaGral " + copaOidParaGral);
        UtilidadesLog.debug(" clieOidClie " + clieOidClie);        
        UtilidadesLog.debug(" perdOidPeri " + perdOidPeri);                
        UtilidadesLog.debug(" idioma: " + solicitud.getOidIdioma());      
       
        tipoMovimientoAux = ConstantesINC.TIPO_MOVIMIENTO_ABONO;

        //puntosValidosAux = solicitudConcurso.getPuntosCuentaCorriente();

        UtilidadesLog.debug(" tipoMovimientoAux " + tipoMovimientoAux);
       // UtilidadesLog.debug(" puntosValidosAux " + puntosValidosAux);
        
        clieOidClie = solicitud.getCliente().getOidCliente();
        
        //numPunt = new Integer(puntosValidosAux.intValue())
        //UtilidadesLog.debug(" numPunt " + numPunt);

        try {
            cuentaCorrientePuntos = cuentaCorrientePuntosHome.create(numPunt,
                            null, fecMovi, copaOidParaGral, clieOidClie, 
                            perdOidPeri, tipoMovimientoAux, null);
                            
                            
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        cuentaCorrientePuntos.setNumMovimiento(new Integer(
            cuentaCorrientePuntos.getOid().intValue()));
            
        cuentaCorrientePuntosHome.merge(cuentaCorrientePuntos);

        UtilidadesLog.info("DAOSolicitudActualizacion.actualizarCuentaCorrienteSorteo(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
        
    }
    
    
    private ClienteRecomendanteLocalHome getClienteRecomendanteLocalHome() {
            return new ClienteRecomendanteLocalHome();
    }

    private ClienteRecomendadoLocalHome getClienteRecomendadoLocalHome() {
            return new ClienteRecomendadoLocalHome();
    }

    private ClienteRecomendanteMultinivelLocalHome getClienteRecomendanteMultinivelLocalHome() {
            return new ClienteRecomendanteMultinivelLocalHome();
    }

    private ClienteRecomendadoMultinivelLocalHome getClienteRecomendadoMultinivelLocalHome() {
            return new ClienteRecomendadoMultinivelLocalHome();
    }

    private SolicitudConcursoRecomendadasLocalHome getSolicitudConcursoRecomendadasLocalHome() {
            return new SolicitudConcursoRecomendadasLocalHome();
    }

    private PedidosConcursoRecomendadaLocalHome getPedidosConcursoRecomendadaLocalHome() {
            return new PedidosConcursoRecomendadaLocalHome();
    }

    private ExigenciasCumplidasLocalHome getExigenciasCumplidasLocalHome() {
            return new ExigenciasCumplidasLocalHome();
    }

    private DescalificacionesLocalHome getDescalificacionesLocalHome() {
            return new DescalificacionesLocalHome();
    }

    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }

    private PuntajeProductosExigidosLocalHome getPuntajeProductosExigidosLocalHome() {
            return new PuntajeProductosExigidosLocalHome();
    }

    private CalculoProductosExigidosLocalHome getCalculoProductosExigidosLocalHome() {
            return new CalculoProductosExigidosLocalHome();
    }

    private SolicitudConcursoPuntajeLocalHome getSolicitudConcursoPuntajeLocalHome() {
            return new SolicitudConcursoPuntajeLocalHome();
    }

    private SolicitudGerenteRecomendadoLocalHome getSolicitudGerenteRecomendadoLocalHome() {
            return new SolicitudGerenteRecomendadoLocalHome();
    }

    private ClienteGerenteLocalHome getClienteGerenteLocalHome() {
            return new ClienteGerenteLocalHome();
    }

    private ClienteGerenteRecomendadoLocalHome getClienteGerenteRecomendadoLocalHome() {
            return new ClienteGerenteRecomendadoLocalHome();
    }

    private PedidoGerenteRecomendadoLocalHome getPedidoGerenteRecomendadoLocalHome() {
            return new PedidoGerenteRecomendadoLocalHome();
    }

    private PedidoRecomendanteMultinivelLocalHome getPedidoRecomendanteMultinivelLocalHome() {
            return new PedidoRecomendanteMultinivelLocalHome();
    }

    private PedidoRecomendadoMultinivelLocalHome getPedidoRecomendadoMultinivelLocalHome() {
            return new PedidoRecomendadoMultinivelLocalHome();
    }

   
}