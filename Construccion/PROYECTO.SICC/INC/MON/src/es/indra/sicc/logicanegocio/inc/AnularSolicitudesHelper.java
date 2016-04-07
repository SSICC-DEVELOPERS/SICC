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
 * @author Viviana Bongiovanni
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 */
 
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.entidades.inc.ClienteRecomendadoLocal;
import es.indra.sicc.entidades.inc.ClienteRecomendadoLocalHome;
import es.indra.sicc.entidades.inc.PedidoRecomendadoMultinivelLocal;
import es.indra.sicc.entidades.inc.PedidoRecomendadoMultinivelLocalHome;
import es.indra.sicc.entidades.inc.PedidoRecomendanteMultinivelLocal;
import es.indra.sicc.entidades.inc.PedidoRecomendanteMultinivelLocalHome;
import es.indra.sicc.entidades.inc.PedidosConcursoRecomendadaLocal;
import es.indra.sicc.entidades.inc.PedidosConcursoRecomendadaLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoPuntajeLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoPuntajeLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoRecomendadasLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoRecomendadasLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

import java.util.Iterator;
import javax.ejb.CreateException;

import javax.ejb.DuplicateKeyException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class AnularSolicitudesHelper {
    private UtilidadesLog log = new UtilidadesLog();
    
    public AnularSolicitudesHelper() {
    }

    public void anularSolicitudConcursoPuntaje(Solicitud solicitud,
        SolicitudConcurso solicitudConc) throws MareException {
        UtilidadesLog.info("AnularSolicitudesHelper.anularSolicitudConcurso"
            +"Puntaje(Solicitud solicitud, SolicitudConcurso solicitudConc):"
            +"Entrada");
            
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
          UtilidadesLog.debug("Empezo anularSolicitudConcursoPuntaje recibo "
            +"Solicitud: " + solicitud.getOidSolicitud() + 
            " y SolicitudConcurso: " + solicitudConc.getOidConcurso());

        try {
            SolicitudConcursoPuntajeLocalHome solConPuntajHome =  this.getSolicitudConcursoPuntajeLocalHome();
            SolicitudConcursoPuntajeLocal solConPuntaj = null;
            PosicionPuntaje posPunt = new PosicionPuntaje();
            Gerente gerente = null;
            double puntosValidos = 0;
            double numeroPuntos = 0;
            double puntosValidosTotal = 0;
            long unidadesValidas = 0;
            long unidades = 0;
            long unidadesValidasTotal = 0;
            BigDecimal montoValidos = null;
            BigDecimal monto = null;
            BigDecimal montoValidosTotal = null;
            double puntajeBonificacion = 0;
            double puntosBonificados = 0;
            double puntajeBonificacionTotal = 0;
            HashMap posiciones = new HashMap();

            // Solicitudes anuladas                 
            DAOSolicitudConcurso daoSolicitudConcurso = 
                new DAOSolicitudConcurso();
            DTOOIDs dtoOids = daoSolicitudConcurso
                .recuperarSolicitudesConcursos(solicitud.getOidSolicitud(),
                    solicitudConc.getOidConcurso());

            int cant = dtoOids.getOids().length;
            Long[] solicConPunt = dtoOids.getOids();

            for (int i = 0; i < cant; i++) {
                // Obtiene el puntaje
                solConPuntaj = solConPuntajHome.findByPrimaryKey(
                    solicConPunt[i]);

                if (solConPuntaj.getGerente() == null) {
                    UtilidadesLog.debug("Consultora");

                    // Actualiza puntos validos
                    puntosValidos = (posPunt.getPuntosValidos() != null)
                        ? posPunt.getPuntosValidos().doubleValue() : 0;
                    numeroPuntos = (solConPuntaj.getNumeroPuntos() != null)
                        ? solConPuntaj.getNumeroPuntos().doubleValue() : 0;
                    puntosValidosTotal = puntosValidos + numeroPuntos;

                    posPunt.setPuntosValidos(new Double(puntosValidosTotal));
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("posPunt.getPuntosValidos: " + posPunt.getPuntosValidos());

                    // Actualiza unidades validas
                    unidadesValidas = (posPunt.getUnidadesValidas() != null)
                        ? posPunt.getUnidadesValidas().longValue() : 0;
                    unidades = (solConPuntaj.getUnidades() != null)
                        ? solConPuntaj.getUnidades().longValue() : 0;
                    unidadesValidasTotal = unidadesValidas + unidades;

                    posPunt.setUnidadesValidas(new Long(unidadesValidasTotal));
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("posPunt.getUnidadesValidas: " + posPunt.getUnidadesValidas());

                    // Actualiza monto valido
                    montoValidos = (posPunt.getMontoValido() != null)
                        ? posPunt.getMontoValido() : new BigDecimal(0);
                    monto = (solConPuntaj.getMonto() != null)
                        ? solConPuntaj.getMonto() : new BigDecimal(0);
                    montoValidosTotal = montoValidos.add(monto);

                    posPunt.setMontoValido(montoValidosTotal);
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("posPunt.getMontoValido: " + posPunt.getMontoValido());

                    // Actualiza puntaje bonificado
                    puntajeBonificacion = posPunt.getPuntosBonificados();
                    puntosBonificados = (solConPuntaj.getPuntajeBonificacion() 
                        != null)? solConPuntaj.getPuntajeBonificacion()
                            .doubleValue() : 0;
                    puntajeBonificacionTotal = puntajeBonificacion +
                        puntosBonificados;

                    posPunt.setPuntosBonificados(puntajeBonificacionTotal);
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("posPunt.getPuntosBonificados: " + posPunt.getPuntosBonificados());
                } else {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("Gerente: " + solConPuntaj.getGerente());
                    gerente = new Gerente();
                    gerente.setOidCliente(solConPuntaj.getGerente());

                    solicitudConc.getGerenteParticipante(gerente);
                }

                // Anula el registro
                solConPuntaj.setAnulada(Boolean.TRUE);
                
                solConPuntajHome.merge(solConPuntaj);
            }

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("posPunt: " + posPunt);

            // Actualiza las posiciones
            posiciones.put(posPunt, posPunt);
            solicitudConc.setPosiciones(posiciones);

            UtilidadesLog.debug("Termino anularSolicitudConcursoPuntaje");
            UtilidadesLog.info("AnularSolicitudesHelper.anularSolicitudConcur"
                +"soPuntaje(Solicitud solicitud, SolicitudConcurso solicitud"
                +"Conc):Salida");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public void tratarAnulacionSolicitud(Solicitud solicitud, Long periodoAnulacion)
        throws MareException {
        UtilidadesLog.info("AnularSolicitudesHelper.tratarAnulacionSolicitud("
            +"Solicitud solicitud):Entrada");
            
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
          UtilidadesLog.debug("Solicitud: " + solicitud.getOidSolicitud());

        DespacharPremiosHelper despacharHelper = new DespacharPremiosHelper();
        DAOSolicitudActualizacion daoSolicitudActualizacion = 
            new DAOSolicitudActualizacion();

        Hashtable solicitudConcursoH = solicitud.getSolicitudConcursos();
        Enumeration solicitudConcursoIt = solicitudConcursoH.elements();
        SolicitudConcurso solConc = null;
        Concurso concurso = null;
        double puntosCuentaCorriente = 0;
        
        //jrivas 21/11/2007 20070447
        ArrayList concursosAAtualizar = new ArrayList();

        while (solicitudConcursoIt.hasMoreElements()) {
            solConc = (SolicitudConcurso) solicitudConcursoIt.nextElement();
    
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("SolicitudConcurso: " + solConc.getOidConcurso());

            if (!solConc.getRechazado()) {
                UtilidadesLog.debug("solConc.getRechazado() false");

                // Datos concurso
                concurso = despacharHelper.obtenerConcurso(solConc
                    .getOidConcurso());

                //sapaza -- PER-SiCC-2010-0407 -- 05/07/2010 
                if (concurso.getIndAnulacion()) { 
                  //|| (solicitud.getIndAnulacion() && solicitud.getIndDevolucion() ) ) {
                    UtilidadesLog.debug("concurso.getIndAnulacion() true");

                    // Anular puntaje
                    this.anularSolicitudConcursoPuntaje(solicitud, solConc);

                    // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                    this.anularProductosExigidos(solicitud, solConc);
                    this.anularExigenciasCumplidas(solicitud, solConc);
                    
                    // DBLG700000194 - gPineda - 22/11/2006
                    if( solConc.getIndAnulaCandidataGanadora() || solConc.getIndAnulaPedido() ){
                      daoSolicitudActualizacion.anularCandidataGanadora( solicitud, solConc );
                    }
                    
                    solConc.setExigenciasCumplidasEnSolicitud(false);
                    
                    // vbongiov -- Cambio 20080811 -- 26/08/2009
                    if(concurso.getIndSorteo()){
                        this.anularSolicitudConcursoSorteo(solicitud, solConc);
                    }

                    if ((ConstantesINC.OID_BASE_CALCULO_MONTO.equals(
                                concurso.getBaseCalculo()) ||
                            ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(
                                concurso.getBaseCalculo())) &&
                            !concurso.getMultiNivel()) {
                        UtilidadesLog.debug(
                            "Base calculo Monto o Unidades sin Multinivel");

                        solicitud.setIndAnulacion(true);

                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("solConc.getPuntosValidos(): " +
                            solConc.getPuntosValidos());
                        /* BELC300024526 - gPineda - 01/12/2006
                        //jrivas 7/9/2006 DBLG50000943
                        solConc.setPuntosCuentaCorriente(new Double(-1 * solConc.getPuntosValidos().doubleValue()));*/
                        solConc.setPuntosCuentaCorriente(new Double( solConc.getPuntosValidos().doubleValue()));
                        
                        daoSolicitudActualizacion.actualizarCuentaCorriente(solicitud,
                            solConc);
                    }

                    if (ConstantesINC.OID_BASE_CALCULO_NPEDIDOS.equals(
                                concurso.getBaseCalculo())) {
                        UtilidadesLog.debug("Base calculo Pedidos");

                        solicitud.setIndAnulacion(true);

                        if ((concurso.getFactorConversion() != null) &&
                                (concurso.getPuntosAsignar() != null) &&
                                (concurso.getFactorConversion().doubleValue() 
                                    != 0.0) && (concurso.getPuntosAsignar()
                                        .doubleValue() != 0.0)) {
                            puntosCuentaCorriente = 1 / (concurso
                                .getFactorConversion().doubleValue() * 
                                    concurso.getPuntosAsignar().doubleValue());
                        } else {
                            puntosCuentaCorriente = 0;
                        }

                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("puntosCuentaCorriente: " +
                            puntosCuentaCorriente);
                        /* BELC300024526 - gPineda - 01/12/2006
                        //jrivas 7/9/2006 DBLG50000943
                        solConc.setPuntosCuentaCorriente(new Double(-1 * puntosCuentaCorriente));*/
                        solConc.setPuntosCuentaCorriente(new Double( puntosCuentaCorriente));

                        daoSolicitudActualizacion.actualizarCuentaCorriente(
                            solicitud,solConc);
                    }

                    if (ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(
                                concurso.getBaseCalculo())) {
                        UtilidadesLog.debug("Base calculo Recomendadas");
                        // vbongiov -- 8/01/2007 -- DBLG500001077
                        try {
                            MONPremiacion mONPremiacion = getMONPremiacion();
                            
                            ArrayList clientePremiacionAntesAnular = 
                            mONPremiacion.determinarGanadorasRecomendacionConsultoraCalculo(
                            solicitud.getOidPais(), solicitud.getPeriodo(), solicitud.getCliente().getOidCliente());
    
                            this.anularSolicitudConcursoRecomendadas(solicitud,
                                solConc);
                            this.descontarPedidoConcursoRecomendadas(solicitud,
                                solConc, concurso.getDirigidoA());
                                
                            ArrayList clientePremiacionDespAnular = 
                            mONPremiacion.determinarGanadorasRecomendacionConsultoraCalculo(
                            solicitud.getOidPais(), solicitud.getPeriodo(), solicitud.getCliente().getOidCliente());
                                
                            // vbongiov -- 29/11/2006 -- DBLG500001077
                            solicitud.setIndAnulacion(true);
                                
                            // CAMBIO ANUL_DEVO - gPineda - 30/10/2006
                            this.anularRecomendacionesEfectivas(solicitud, solConc, 
                                                                clientePremiacionAntesAnular, clientePremiacionDespAnular);
                            
                        } catch(RemoteException re) {
                              UtilidadesLog.error(re);
                              throw new MareException(re,
                                  UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    }

                    if ((ConstantesINC.OID_BASE_CALCULO_MONTO.equals(
                                concurso.getBaseCalculo()) ||
                            ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(
                                concurso.getBaseCalculo())) &&
                            concurso.getMultiNivel()) {
                        UtilidadesLog.debug(
                            "Base calculo Monto o Unidades con Multinivel");

                        if(solicitud.getCliente().getIndRecomendante()) {
                            UtilidadesLog.debug(
                            "TIPO_VINC_AMBOS o TIPO_VINC_RECOMENDANTE");
                            this.descontarPedidoRecomendanteMultinivel(solicitud,
                            solConc);
                        }
                        
                        if(solicitud.getCliente().getClienteRecomendante()!=null) {
                            UtilidadesLog.debug(
                            "TIPO_VINC_AMBOS o TIPO_VINC_RECOMENDADO");
                            this.descontarPedidoRecomendadoMultinivel(solicitud,
                            solConc);
                        }
                    }
                    
                    //jrivas 21/11/2007 20070447
                    //Verificamos Periodos
                    if (solicitud.getPeriodo().getOidPeriodo().equals(periodoAnulacion)) {

                        Long periodoDespachoDespuesObtencion = null;
                        if (concurso.getNumeroPeriodos() != null) {
                            periodoDespachoDespuesObtencion  = (new DAOClientePremiacion().obtenerPeriodo(periodoAnulacion,
                                    concurso.getNumeroPeriodos().intValue())).getOidPeriodo();
                        }

                        if ((concurso.getIndPeriodoDespachoExigido().booleanValue() && (concurso.getPeriodoDeDespacho() != null)
                            && (concurso.getNumeroPeriodos() == null) && concurso.getPeriodoDeDespacho().getOidPeriodo().equals(periodoAnulacion)) 
                            ||
                            (concurso.getIndPeriodoDespachoExigido().booleanValue() && (concurso.getNumeroPeriodos() != null)
                            && periodoDespachoDespuesObtencion.equals(periodoAnulacion))
                            ||
                            (!concurso.getIndPeriodoDespachoExigido().booleanValue())) {                             
                        
                            //Guardamos los oidConcursos a actualizar.
                            if (!concursosAAtualizar.contains(concurso.getOidConcurso())) {
                                concursosAAtualizar.add(concurso.getOidConcurso());
                            }
                        }
                    } else {
                        //No se hace nada.
                    }
                }
            }
            solConc.setRechazado(true);
        }

        //jrivas 21/11/2007 20070447 INICIO
        if (concursosAAtualizar.size() > 0) {
            Iterator it = concursosAAtualizar.iterator();
            StringBuffer oidsConcursos = new StringBuffer();
            while (it.hasNext()) {
                oidsConcursos.append(it.next());
                if (it.hasNext()) { 
                    oidsConcursos.append(", ");
                }
            }
            StringBuffer candi = armarStringCandidata(oidsConcursos, solicitud.getCliente().getOidCliente());
            StringBuffer cuenta = armarStringCuentaCorri(oidsConcursos, solicitud.getCliente().getOidCliente(), periodoAnulacion);
            this.ActualizaIU(candi);
            this.ActualizaIU(cuenta);
        }
        //jrivas 21/11/2007 20070447 FIN            

        UtilidadesLog.debug("Termino tratarAnulacionSolicitud ");
        UtilidadesLog.info("AnularSolicitudesHelper.tratarAnulacionSolicitud("
            +"Solicitud solicitud):Salida");
    }

    public void anularSolicitudConcursoRecomendadas(Solicitud solicitud,
        SolicitudConcurso solicitudConc) throws MareException {
        UtilidadesLog.info("AnularSolicitudesHelper.anularSolicitudConcurso"
            +"Recomendadas(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Conc):Salida");

        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
          UtilidadesLog.debug("Empezo anularSolicitudConcursoRecomendadas recibo"
            +"Solicitud: " + solicitud.getOidSolicitud() +
            " y SolicitudConcurso: " + solicitudConc.getOidConcurso());

        try {
            DAOSolicitudConcurso daoSolicitudConcurso =  new DAOSolicitudConcurso();
            SolicitudConcursoRecomendadasLocalHome solicConRecH =  this.getSolicitudConcursoRecomendadasLocalHome();
            SolicitudConcursoRecomendadasLocal solicConRec = null;

            PosicionPuntaje posPunt = new PosicionPuntaje();
            long unidadesValidas = 0;
            long unidades = 0;
            long unidadesValidasTotal = 0;
            BigDecimal montoValidos = null;
            BigDecimal monto = null;
            BigDecimal montoValidosTotal = null;
            HashMap posiciones = new HashMap();

            DTOOIDs dtoOids = daoSolicitudConcurso
                .recuperarSolicitudesConcursosRecomendadas(solicitud
                .getOidSolicitud(),solicitudConc.getOidConcurso());

            int cant = dtoOids.getOids().length;
            Long[] solicConRecom = dtoOids.getOids();

            for (int i = 0; i < cant; i++) {
                solicConRec = solicConRecH.findByPrimaryKey(solicConRecom[i]);

                // Actualiza monto valido
                montoValidos = (posPunt.getMontoValido() != null)
                    ? posPunt.getMontoValido() : new BigDecimal(0);
                monto = (solicConRec.getMontoSolicitud() != null)
                    ? solicConRec.getMontoSolicitud() : new BigDecimal(0);
                montoValidosTotal = montoValidos.add(monto);

                posPunt.setMontoValido(montoValidosTotal);
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("posPunt.getMontoValido: " +
                    posPunt.getMontoValido());

                // Actualiza unidades validas
                unidadesValidas = (posPunt.getUnidadesValidas() != null)
                    ? posPunt.getUnidadesValidas().longValue() : 0;
                unidades = (solicConRec.getUnidadesSolicitud() != null)
                    ? solicConRec.getUnidadesSolicitud().longValue() : 0;
                unidadesValidasTotal = unidadesValidas + unidades;

                posPunt.setUnidadesValidas(new Long(unidadesValidasTotal));
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("posPunt.getUnidadesValidas: " +
                    posPunt.getUnidadesValidas());

                solicConRec.setAnulada(Boolean.TRUE);
                solicConRec.setSolicitudValida(Boolean.FALSE);
                solicConRecH.merge(solicConRec);
            }

            // Actualiza las posiciones
            posiciones.put(posPunt, posPunt);
            solicitudConc.setPosiciones(posiciones);

            UtilidadesLog.debug("Termino anularSolicitudConcursoRecomendadas");
            UtilidadesLog.info("AnularSolicitudesHelper.anularSolicitudConcur"
                +"soRecomendadas(Solicitud solicitud, SolicitudConcurso solici"
                +"tudConc):Salida");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public void descontarPedidoConcursoRecomendadas(Solicitud solicitud,
        SolicitudConcurso solicitudConc, Long dirigidoA)
        throws MareException {
        UtilidadesLog.info("AnularSolicitudesHelper.descontarPedidoConcursoRe"
            +"comendadas(Solicitud solicitud, SolicitudConcurso solicitudConc)"
            +":Entrada");
            
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug(
            "Empezo descontarPedidoConcursoRecomendadas recibo Solicitud: " +
            solicitud.getOidSolicitud() + " y SolicitudConcurso: " +
            solicitudConc.getOidConcurso());

        try {
            DAOSolicitudConcurso daoSolicitudConcurso =  new DAOSolicitudConcurso();
            PedidosConcursoRecomendadaLocalHome pedConRecH =  this.getPedidosConcursoRecomendadaLocalHome();
            PedidosConcursoRecomendadaLocal pedConRec = null;

            int unidadesValidas = 0;
            int unidadesPedido = 0;
            int unidadesValidasTotal = 0;
            BigDecimal montoValidos = null;
            BigDecimal montoPedido = null;
            BigDecimal montoValidosTotal = null;

            DTOOIDs dtoOids = daoSolicitudConcurso
                .recuperarPedidosConcursosRecomendadas(solicitud, 
                    solicitudConc, dirigidoA);

            // vbongiov -- 2/11/2006
            int cant = dtoOids.getOids()!=null?dtoOids.getOids().length:0;
            
            Long[] solicConRecom = dtoOids.getOids();

            for (int i = 0; i < cant; i++) {
                pedConRec = pedConRecH.findByPrimaryKey(solicConRecom[i]);

                // Actualiza monto pedido
                montoValidos = (solicitudConc.getMontoValido() != null)
                    ? solicitudConc.getMontoValido() : new BigDecimal(0);
                montoPedido = (pedConRec.getMontoPedido() != null)
                    ? pedConRec.getMontoPedido() : new BigDecimal(0);
                montoValidosTotal = montoPedido.subtract(montoValidos);

                pedConRec.setMontoPedido(montoValidosTotal);
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("pedConRec.getMontoPedido: " +
                    pedConRec.getMontoPedido());

                // Actualiza unidades pedidas
                unidadesValidas = (solicitudConc.getUnidadesValidas() != null)
                    ? solicitudConc.getUnidadesValidas().intValue() : 0;
                unidadesPedido = (pedConRec.getUnidadesPedido() != null)
                    ? pedConRec.getUnidadesPedido().intValue() : 0;
                unidadesValidasTotal = unidadesPedido - unidadesValidas;

                pedConRec.setUnidadesPedido(new Integer(unidadesValidasTotal));
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("pedConRec.getUnidadesPedido: " +
                    pedConRec.getUnidadesPedido());
                    
                // vbongiov --20090882 -- 3/04/2009    
                pedConRecH.merge(pedConRec);
            }

            UtilidadesLog.debug("Termino descontarPedidoConcursoRecomendadas");
            UtilidadesLog.info("AnularSolicitudesHelper.descontarPedidoConcur"
                +"soRecomendadas(Solicitud solicitud, SolicitudConcurso solici"
                +"tudConc):Salida");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public void descontarPedidoRecomendanteMultinivel(Solicitud solicitud,
        SolicitudConcurso solicitudConc) throws MareException {
        UtilidadesLog.info("AnularSolicitudesHelper.descontarPedidoRecomendan"
            +"teMultinivel(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Conc):Entrada");
            
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
          UtilidadesLog.debug("Empezo descontarPedidoRecomendanteMultinivel re"
            +"cibo Solicitud: " + solicitud.getOidSolicitud() + 
            " y SolicitudConcurso: " + solicitudConc.getOidConcurso());

        try {
            DAOSolicitudConcurso daoSolicitudConcurso =  new DAOSolicitudConcurso();
            PedidoRecomendanteMultinivelLocalHome pedRecteMulH = this.getPedidoRecomendanteMultinivelLocalHome();
            PedidoRecomendanteMultinivelLocal pedRecteMul = null;
            Concurso concurso = null;

            int unidadesValidas = 0;
            int unidadesCantidad = 0;
            int unidadesValidasTotal = 0;
            BigDecimal montoValidos = null;
            BigDecimal montoCantidad = null;
            BigDecimal montoValidosTotal = null;

            DespacharPremiosHelper despacharHelper = 
                new DespacharPremiosHelper();
            concurso = despacharHelper.obtenerConcurso(solicitudConc
                .getOidConcurso());

            DTOOIDs dtoOids = daoSolicitudConcurso
                .recuperarPedidosRecomendantesMultinivel(solicitud,
                    solicitudConc);

            int cant = dtoOids.getOids().length;
            Long[] pedRecteMultinivel = dtoOids.getOids();

            for (int i = 0; i < cant; i++) {
                pedRecteMul = pedRecteMulH.findByPrimaryKey(
                    pedRecteMultinivel[i]);

                if (ConstantesINC.OID_BASE_CALCULO_MONTO.equals(
                            concurso.getBaseCalculo())) {
                    UtilidadesLog.debug("OID_BASE_CALCULO_MONTO");

                    // Actualiza monto 
                    montoValidos = (solicitudConc.getMontoValido() != null)
                        ? solicitudConc.getMontoValido() : new BigDecimal(0);
                    montoCantidad = (pedRecteMul.getCantidad() != null)
                        ? pedRecteMul.getCantidad() : new BigDecimal(0);
                    montoValidosTotal = montoCantidad.subtract(montoValidos);

                    pedRecteMul.setCantidad(montoValidosTotal);

                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("pedRecteMul.getCantidad: " +
                        pedRecteMul.getCantidad());
                }

                if (ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(
                            concurso.getBaseCalculo())) {
                    UtilidadesLog.debug("OID_BASE_CALCULO_UNIDADES");

                    // Actualiza unidades 
                    unidadesValidas = (solicitudConc.getUnidadesValidas() 
                        != null) ? solicitudConc.getUnidadesValidas()
                            .intValue() : 0;
                    unidadesCantidad = (pedRecteMul.getCantidad() != null)
                        ? pedRecteMul.getCantidad().intValue() : 0;
                    unidadesValidasTotal = unidadesCantidad - unidadesValidas;

                    pedRecteMul.setCantidad(new BigDecimal(
                        unidadesValidasTotal));
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                        
                      UtilidadesLog.debug("pedRecteMul.getCantidad: " +
                        pedRecteMul.getCantidad());
                }
                pedRecteMulH.merge(pedRecteMul);
            }

            UtilidadesLog.debug("Termino descontarPedidoRecomendanteMultini"
                +"vel");
            UtilidadesLog.info("AnularSolicitudesHelper.descontarPedidoRecomen"
                +"danteMultinivel(Solicitud solicitud, SolicitudConcurso soli"
                +"citudConc):Salida");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public void descontarPedidoRecomendadoMultinivel(Solicitud solicitud,
        SolicitudConcurso solicitudConc) throws MareException {
        UtilidadesLog.info("AnularSolicitudesHelper.descontarPedidoRecomenda"
            +"doMultinivel(Solicitud solicitud, SolicitudConcurso solicitud"
            +"Conc):Entrada");
        UtilidadesLog.debug("Empezo descontarPedidoRecomendadoMultinivel reci"
            +"bo Solicitud: " + solicitud.getOidSolicitud() + 
            " y SolicitudConcurso: " + solicitudConc.getOidConcurso());

        try {
            DAOSolicitudConcurso daoSolicitudConcurso = new DAOSolicitudConcurso();
            PedidoRecomendadoMultinivelLocalHome pedRecMulH = this.getPedidoRecomendadoMultinivelLocalHome();
            PedidoRecomendadoMultinivelLocal pedRecMul = null;
            Concurso concurso = null;

            int unidadesValidas = 0;
            int unidadesCantidad = 0;
            int unidadesValidasTotal = 0;
            BigDecimal montoValidos = null;
            BigDecimal montoCantidad = null;
            BigDecimal montoValidosTotal = null;

            DespacharPremiosHelper despacharHelper =  new DespacharPremiosHelper();
            concurso = despacharHelper.obtenerConcurso(solicitudConc.getOidConcurso());

            DTOOIDs dtoOids = daoSolicitudConcurso.recuperarPedidosRecomendadosMultinivel(solicitud, solicitudConc);

            int cant = dtoOids.getOids().length;
            Long[] pedRecMultinivel = dtoOids.getOids();

            for (int i = 0; i < cant; i++) {
                pedRecMul = pedRecMulH.findByPrimaryKey(pedRecMultinivel[i]);

                if (ConstantesINC.OID_BASE_CALCULO_MONTO.equals(
                            concurso.getBaseCalculo())) {
                    UtilidadesLog.debug("OID_BASE_CALCULO_MONTO");

                    // Actualiza monto 
                    montoValidos = (solicitudConc.getMontoValido() != null)
                        ? solicitudConc.getMontoValido() : new BigDecimal(0);
                    montoCantidad = (pedRecMul.getCantidad() != null)
                        ? pedRecMul.getCantidad() : new BigDecimal(0);
                    montoValidosTotal = montoCantidad.subtract(montoValidos);

                    pedRecMul.setCantidad(montoValidosTotal);
                    UtilidadesLog.debug("pedRecMul.getCantidad: " +
                        pedRecMul.getCantidad());
                }

                if (ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(
                            concurso.getBaseCalculo())) {
                    UtilidadesLog.debug("OID_BASE_CALCULO_UNIDADES");

                    // Actualiza unidades 
                    unidadesValidas = (solicitudConc.getUnidadesValidas() 
                        != null) ? solicitudConc.getUnidadesValidas()
                            .intValue() : 0;
                    unidadesCantidad = (pedRecMul.getCantidad() != null)
                        ? pedRecMul.getCantidad().intValue() : 0;
                    unidadesValidasTotal = unidadesCantidad - unidadesValidas;

                    pedRecMul.setCantidad(new BigDecimal(unidadesValidasTotal));
                    UtilidadesLog.debug("pedRecMul.getCantidad: " +
                        pedRecMul.getCantidad());
                }
                pedRecMulH.merge(pedRecMul);
            }

            UtilidadesLog.debug("Termino descontarPedidoRecomendadoMultinivel");
            UtilidadesLog.info("AnularSolicitudesHelper.descontarPedidoRecomen"
                +"dadoMultinivel(Solicitud solicitud, SolicitudConcurso solici"
                +"tudConc):Salida");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Este método recupera las solcitudes a ser anuladas como consecuencia de 
     * una devolución con la que se pierde alguna exigencia de cada concurso.
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoOidConcursos
     * @param solicitud
     */
    public void tratarAnulacionDevolucion(Solicitud solicitud, DTOOIDs dtoOidConcursos, ArrayList oidsSolicitudConcursoConIndAnulaCandidata )
      throws MareException{
      UtilidadesLog.info("AnularSolicitudesHelper.tratarAnulacionDevolucion(Solicitud solicitud, DTOOIDs dtoOidConcursos, ArrayList oidsSolicitudConcursoConIndAnulaCandidata):Entrada" );
      DAOSolicitudes daoSolicitudes = new DAOSolicitudes();
      ArrayList arrSolicitudesADevolver = daoSolicitudes.
            obtenerSolicitudesADevolverIncentivos(  solicitud.getOidSolicitud(), 
                                                    solicitud.getPeriodo().getOidPeriodo() );
      int size = arrSolicitudesADevolver.size();
      for( int i = 0; i < size; i++ ){
        Solicitud solicitudADevolver = daoSolicitudes.obtenerSolicitud( (DTOSolicitudValidacion)arrSolicitudesADevolver.get(i) );
        
        this.eliminarSolicitudConcursoSinAnulacion(solicitudADevolver, dtoOidConcursos);
        
        //Como son nuevas instancias, no tienen activo el indAnulaPedido, ni Anulacion ó Devolución
        solicitudADevolver.setIndAnulacion(true);
        solicitudADevolver.setIndDevolucion(true);
        Iterator solicitudesConcursosIte = solicitudADevolver.getSolicitudConcursos().values().iterator();
        while( solicitudesConcursosIte.hasNext() ){
           SolicitudConcurso solConc = (SolicitudConcurso)solicitudesConcursosIte.next() ;
           solConc.setIndAnulaPedido( true );
           if( oidsSolicitudConcursoConIndAnulaCandidata.contains( solConc.getOidConcurso() ) ){
             solConc.setIndAnulaCandidataGanadora( true );
           }
        }
        
        //jrivas 21/11/2007 20070447
        this.tratarAnulacionSolicitud( solicitudADevolver, null );

      }
      UtilidadesLog.info("AnularSolicitudesHelper.tratarAnulacionDevolucion(Solicitud solicitud, DTOOIDs dtoOidConcursos, ArrayList oidsSolicitudConcursoConIndAnulaCandidata):Salida" );
    }
    
    /**
     * elimina los objetos solicitud concurso que no estan en el objeto DTOOIDs
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoOidsConcursos
     * @param solicitudADevolver
     */
    public void  eliminarSolicitudConcursoSinAnulacion(Solicitud solicitudADevolver,DTOOIDs dtoOidsConcursos)
      throws MareException{
      UtilidadesLog.info("AnularSolicitudesHelper.eliminarSolicitudConcursoSinAnulacion(Solicitud solicitudADevolver,DTOOIDs dtoOidsConcursos):Entrada" );
      Hashtable solicitudConcursos = solicitudADevolver.getSolicitudConcursos();
      Hashtable nuevoHash = new Hashtable();
      Long[] oidsConcursos = dtoOidsConcursos.getOids();
      int oidsSize = oidsConcursos.length;
      // Creamos un nuevo hashTable con los oids que están en dtoOidsConcursos 
      // y el hashTable de solicitudADevolver.getSolicitudConcursos()
      for( int i = 0; i<oidsSize; i++){
        Long oidConcurso = oidsConcursos[i];
        if( solicitudConcursos.containsKey( oidConcurso ) ){
          nuevoHash.put(oidConcurso, solicitudConcursos.get(oidConcurso) );
        }
      }
      // seteamos el nuevo hashTable
      solicitudADevolver.setSolicitudConcursos( nuevoHash );
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
        UtilidadesLog.debug("solicitudADevolver.getSolicitudConcursos(): "+nuevoHash);
        
      UtilidadesLog.info("AnularSolicitudesHelper.eliminarSolicitudConcursoSinAnulacion(Solicitud solicitudADevolver,DTOOIDs dtoOidsConcursos):Salida" );
    }
    
   /**
    * anula los productos exigidos para el cliente, concurso y periodo recibidos por parametro.
    * 
    * @throws es.indra.mare.common.exception.MareException
    * @param solicitudConcurso
    * @param solicitud
    */
    public void anularProductosExigidos(Solicitud solicitud, SolicitudConcurso solicitudConcurso)
      throws MareException{
      UtilidadesLog.info("AnularSolicitudesHelper.anularProductosExigidos(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Entrada");
      UtilidadesLog.debug("Solicitud: "+ solicitud);
      UtilidadesLog.debug("SolicitudConcurso: "+ solicitudConcurso);
      new DAOSolicitudActualizacion().actualizarCalculosProductosExigidos( solicitud, solicitudConcurso);
      UtilidadesLog.info("AnularSolicitudesHelper.anularProductosExigidos(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
    }

   /**
    * anula las exigencias cumplidas para el cliente, concurso y periodo recibido por parametro
    * 
    * @throws es.indra.mare.common.exception.MareException
    * @param solicitudConcurso
    * @param solicitud
    */
    public void anularExigenciasCumplidas(Solicitud solicitud, SolicitudConcurso solicitudConcurso)
      throws MareException{
      UtilidadesLog.info("AnularSolicitudesHelper.anularExigenciasCumplidas(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Entrada");
      UtilidadesLog.debug("Solicitud: "+ solicitud);
      UtilidadesLog.debug("SolicitudConcurso: "+ solicitudConcurso);
      if( solicitudConcurso.getIndAnulaPedido() ){
        new DAOSolicitudActualizacion().activarExigenciasCumplidas( solicitud, solicitudConcurso);
      }
      UtilidadesLog.info("AnularSolicitudesHelper.anularExigenciasCumplidas(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
    }
    
   /**
    * anula las recomendaciones efectivas y retorna numero total de recomendaciones.
    * 
    * @throws es.indra.mare.common.exception.MareException
    * @param solicitudConcurso
    * @param solicitud
    */
    public void anularRecomendacionesEfectivas(Solicitud solicitud, SolicitudConcurso solicitudConcurso, 
                ArrayList clientePremiacionAntesAnular, ArrayList clientePremiacionDespAnular) throws MareException{
      UtilidadesLog.info("AnularSolicitudesHelper.anularRecomendacionesEfectivas(Solicitud solicitud, SolicitudConcurso solicitudConcurso, " +
                "ArrayList clientePremiacionAntesAnular, ArrayList clientePremiacionDespAnular):Entrada");
      
      if(clientePremiacionAntesAnular != null) {
          // vbongiov -- 9/01/2007 -- DBLG500001077
          int cantClientePremiacionAntesAnular = clientePremiacionAntesAnular.size();  
          ClientePremiacion cliePremiacionAntesAnular = null;
          ClientePremiacion cliePremiacionDespuesAnular = null;
          HashMap cliePremConcursosAntesAnular = null;
          HashMap cliePremConcursosDespuesAnular = null;
          ClientePremiacionConcurso cliePremConcuAntesAnular = null;
          ClientePremiacionConcurso cliePremConcuDespAnular = null;
          Long oidConcurso = null;
          long diferenciaRecomEfectivas = 0;
          DespacharPremiosHelper despachar = new DespacharPremiosHelper();
          DAOSolicitudActualizacion daoSolicitudActualizacion = new DAOSolicitudActualizacion();
          Concurso concurso = null;
          Cliente cliente = null;
          
          for (int i = 0; cantClientePremiacionAntesAnular > i; i++) {
              cliePremiacionAntesAnular = (ClientePremiacion) clientePremiacionAntesAnular.get(i);
              
              //busca el cliente Premiacion que le corresponde (mismo anterior que posterior por oidCliente)
              //jrivas 29/1/2007 BELG50001077 
              int j = 0;
              cliePremiacionDespuesAnular = (ClientePremiacion) clientePremiacionDespAnular.get(j);
              while (!(cliePremiacionDespuesAnular.getOidCliente().equals(cliePremiacionAntesAnular.getOidCliente()))) {
                  j++;
                  cliePremiacionDespuesAnular = (ClientePremiacion) clientePremiacionDespAnular.get(j);
              }
              
              cliePremConcursosAntesAnular = cliePremiacionAntesAnular.getClientesPremiacionConcurso();
              
              UtilidadesLog.debug("cliePremConcuAntesAnular " + cliePremConcursosAntesAnular.values().size());
    
              Iterator itCliePremConcursosAntesAnular = cliePremConcursosAntesAnular.values().iterator();
    
              while (itCliePremConcursosAntesAnular.hasNext()) {
              
                  oidConcurso = ((ClientePremiacionConcurso) itCliePremConcursosAntesAnular.next()).getOidConcurso();
                  UtilidadesLog.debug("oidConcurso: " + oidConcurso);
                  
                  cliePremConcuAntesAnular = cliePremiacionAntesAnular.getClientePremiacionConcurso(oidConcurso);
                  UtilidadesLog.debug("oidCliente: " + cliePremiacionAntesAnular.getOidCliente());
                  
                  if(cliePremConcuAntesAnular.getRecomendacionesEfectivas().longValue() > 0){
                  
                      cliePremConcuDespAnular = cliePremiacionDespuesAnular.getClientePremiacionConcurso(oidConcurso);
                      
                      diferenciaRecomEfectivas = cliePremConcuAntesAnular.getRecomendacionesEfectivas().longValue() -
                                                 cliePremConcuDespAnular.getRecomendacionesEfectivas().longValue();
                                                 
                      UtilidadesLog.debug("diferenciaRecomEfectivas: " + diferenciaRecomEfectivas);
                                                 
                      if(diferenciaRecomEfectivas > 0){
          
                          this.actualizarRecomendacionesEfectivas(cliePremConcuAntesAnular, cliePremiacionAntesAnular, 
                                                                  cliePremConcuDespAnular);
          
                          concurso = despachar.obtenerConcurso( solicitudConcurso.getOidConcurso());
                          solicitudConcurso = solicitud.getSolicitudConcurso(oidConcurso);
                          solicitudConcurso.setPuntosCuentaCorriente( new Double( 
                              ( diferenciaRecomEfectivas / concurso.getFactorConversion().doubleValue() )
                                * concurso.getPuntosAsignar().doubleValue()));    
                                
                          UtilidadesLog.debug("solicitudConcurso.getPuntosCuentaCorriente():"+
                                                    solicitudConcurso.getPuntosCuentaCorriente());
                                                    
                          if(!cliePremiacionAntesAnular.getIndAnulacionRecomendante()) {
                              UtilidadesLog.debug("es recomendado");
                              cliente = new Cliente();
                              cliente.setOidCliente(cliePremiacionAntesAnular.getOidCliente());
                              solicitud.setCliente(cliente);                          
                          }
                          
                          daoSolicitudActualizacion.actualizarCuentaCorriente(solicitud, solicitudConcurso);
                          
                          UtilidadesLog.debug("solicitudConcurso.getPuntosCuentaCorriente():"+
                                                    solicitudConcurso.getPuntosCuentaCorriente() );
                      }                
                  }
              }
          }                
      }
      
      UtilidadesLog.info("AnularSolicitudesHelper.anularRecomendacionesEfectivas(Solicitud solicitud, SolicitudConcurso solicitudConcurso, " +
                "ArrayList clientePremiacionAntesAnular, ArrayList clientePremiacionDespAnular):Salida");
    }
    
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   05/01/2007
     * @version 1.00
     * @autor   Viviana Bongiovanni
     * Inc DBLG500001077
     */
    public void actualizarRecomendacionesEfectivas(ClientePremiacionConcurso cliePremConcuAntesAnular, 
                                                   ClientePremiacion clientePremiacionDespAnular ,
							                                     ClientePremiacionConcurso cliePremConcuDespAnular) throws MareException{
        UtilidadesLog.info("AnularSolicitudesHelper.actualizarRecomendacionesEfectivas(ClientePremiacionConcurso cliePremConcuAntesAnular, ClientePremiacion clientePremiacionDespAnular , " +
                "ClientePremiacionConcurso cliePremConcuDespAnular):Entrada");
                
        try {
            DAOSolicitudes daoSolicitudes = new DAOSolicitudes();
            ClienteRecomendadoLocalHome clienteRecomendadoLocalHome = this.getClienteRecomendadoLocalHome();
            ClienteRecomendadoLocal clienteRecomendadoLocal = null;
            
            ArrayList recomendadosAntesAnular = cliePremConcuAntesAnular.getRecomendados();
            int cantRecomAntesAnular = recomendadosAntesAnular.size();            
            ClientePremiacionRecomendado clientePremiacionRecomendadoAntesAnular = null;
            Long recomendadoAntes = null;
            boolean indRecomendacionEfectivaAntesAnular = false;
            
            ArrayList recomendadosDespuesAnular = cliePremConcuDespAnular.getRecomendados();
            int cantRecomDespuesAnular = recomendadosDespuesAnular.size();
            ClientePremiacionRecomendado clientePremiacionRecomendadoDespuesAnular = null;
            Long recomendadoDespues = null;
            boolean indRecomendacionEfectivaDespAnular = false;
            Long oidClienteRecomendado = null;
            
            UtilidadesLog.info("cantRecomAntesAnular: " + cantRecomAntesAnular);
            UtilidadesLog.info("cantRecomDespuesAnular: " + cantRecomDespuesAnular);
            
            for(int i= 0; i< cantRecomAntesAnular; i++){
                clientePremiacionRecomendadoAntesAnular = (ClientePremiacionRecomendado)recomendadosAntesAnular.get(i);
                recomendadoAntes = clientePremiacionRecomendadoAntesAnular.getOidClienteRecomendado();
                indRecomendacionEfectivaAntesAnular = clientePremiacionRecomendadoAntesAnular.getIndRecomendacionEfectiva();
                
                UtilidadesLog.info("recomendadoAntes: " + recomendadoAntes);
                UtilidadesLog.info("indRecomendacionEfectivaAntesAnular: " + indRecomendacionEfectivaAntesAnular);
            
                for(int j= 0; j< cantRecomDespuesAnular; j++){
                    clientePremiacionRecomendadoDespuesAnular = (ClientePremiacionRecomendado)recomendadosDespuesAnular.get(i);
                    recomendadoDespues = clientePremiacionRecomendadoDespuesAnular.getOidClienteRecomendado();
                    
                    UtilidadesLog.info("recomendadoDespues: " + recomendadoDespues);             
                    
                    if(recomendadoAntes.equals(recomendadoDespues)){
                        indRecomendacionEfectivaDespAnular = clientePremiacionRecomendadoDespuesAnular.getIndRecomendacionEfectiva();
                        UtilidadesLog.info("indRecomendacionEfectivaDespAnular: " + indRecomendacionEfectivaDespAnular);
                        break;
                    }
                }
                
                if(indRecomendacionEfectivaAntesAnular && !indRecomendacionEfectivaDespAnular){
                    oidClienteRecomendado = recomendadoAntes;
                    
                    UtilidadesLog.info("oidClienteRecomendado: " + oidClienteRecomendado);
                                       
                    clienteRecomendadoLocal = clienteRecomendadoLocalHome.findByPrimaryKey(oidClienteRecomendado);
                    
                    clienteRecomendadoLocal.setEfectiva(Boolean.FALSE);    
                    
                    //sapaza -- PER-SiCC-2010-0407 -- 05/07/2010
                    clienteRecomendadoLocal.setAnulado(Boolean.TRUE);   
                    clienteRecomendadoLocalHome.merge(clienteRecomendadoLocal);
                    
                }                
            }
        } catch (NoResultException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
                
                
        UtilidadesLog.info("AnularSolicitudesHelper.actualizarRecomendacionesEfectivas(ClientePremiacionConcurso cliePremConcuAntesAnular, ClientePremiacion clientePremiacionDespAnular , " +
                "ClientePremiacionConcurso cliePremConcuDespAnular):Salida");
    }

      



    
    private MONPremiacion getMONPremiacion() throws MareException {
      try{
          final InitialContext context = new InitialContext();
          MONPremiacionHome monPremiacionHome =  (MONPremiacionHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPremiacion"), MONPremiacionHome.class);
                              
          return monPremiacionHome.create();
      
      } catch(NamingException me) {
            UtilidadesLog.error(me);
            throw new MareException(me,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(RemoteException re) {
            UtilidadesLog.error(re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(CreateException ce) {
            UtilidadesLog.error(ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
  }
  
  
     //jrivas 21/11/2007 20070447
     private StringBuffer armarStringCandidata(StringBuffer oidsConcursos, Long oidCliente) {
        StringBuffer query = new StringBuffer();
        query.append("UPDATE INC_CANDI_GANAD ");
        query.append(" SET VAL_REQU_PREM_SUPE = 0, ");
        query.append(" BINC_OID_BASE_INCU = NULL ");
        query.append(" WHERE COPA_OID_PARA_GRAL IN ("+oidsConcursos+")");
        query.append(" AND CLIE_OID_CLIE = " + oidCliente + ";");

        return query;
     }  
     
     //jrivas 21/11/2007 20070447
     private StringBuffer armarStringCuentaCorri(StringBuffer oidsConcursos, Long oidCliente, Long oidPeriodo) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE INC_CUENT_CORRI_PUNTO ");
        query.append(" WHERE COPA_OID_PARA_GRAL IN ("+oidsConcursos+")");
        query.append(" AND CLIE_OID_CLIE = " + oidCliente);
        query.append(" AND PERD_OID_PERI = " + oidPeriodo);
        query.append(" AND TMOV_OID_TIPO_MOVI = "+ConstantesINC.TIPO_MOVIMIENTO_CARGO );
        query.append(" AND UPPER(VAL_DESC) LIKE UPPER('%"+ ConstantesINC.DESC_ENTREGA_PREMIO +"%');");
        return query;
     }    
     
     //jrivas 21/11/2007 20070447
     private void ActualizaIU(StringBuffer queryUpdate) throws MareException {
       try{
          BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", queryUpdate.toString());
       }catch(Exception e){
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
       }  
     }     
     
    // vbongiov -- Cambio 20080811 -- 26/08/2009
    public void anularSolicitudConcursoSorteo(Solicitud solicitud, SolicitudConcurso solicitudConcurso) throws MareException {
        UtilidadesLog.info("AnularSolicitudesHelper.anularSolicitudConcursoSorteo(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Entrada");
        
        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();        
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        query.append(" UPDATE INC_PARTI_SORTE partSor ");   
        query.append(" SET partSor.IND_ANUL = 1 ");
        query.append(" WHERE partSor.COPA_OID_PARA_GRAL = " + solicitudConcurso.getOidConcurso());
        query.append(" AND partSor.SOCA_OID_SOLI_CABE = " + solicitud.getOidSolicitud());
        query.append(" AND partSor.CLIE_OID_CLIE = " + solicitud.getCliente().getOidCliente());
        query.append(" AND partSor.PERD_OID_PERI = " + solicitud.getPeriodo().getOidPeriodo());
               
        
        try {
              bs.dbService.executeUpdate(query.toString());     
        } catch (DuplicateKeyException ex) {
              ex.printStackTrace();
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }     
        
        UtilidadesLog.info("AnularSolicitudesHelper.anularSolicitudConcursoSorteo(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
        
    }

    private SolicitudConcursoRecomendadasLocalHome getSolicitudConcursoRecomendadasLocalHome() {
            return new SolicitudConcursoRecomendadasLocalHome();
    }

    private PedidoRecomendanteMultinivelLocalHome getPedidoRecomendanteMultinivelLocalHome() {
            return new PedidoRecomendanteMultinivelLocalHome();
    }

    private PedidoRecomendadoMultinivelLocalHome getPedidoRecomendadoMultinivelLocalHome() {
            return new PedidoRecomendadoMultinivelLocalHome();
    }

    private ClienteRecomendadoLocalHome getClienteRecomendadoLocalHome() {
            return new ClienteRecomendadoLocalHome();
    }
    
    private SolicitudConcursoPuntajeLocalHome getSolicitudConcursoPuntajeLocalHome() {
            return new SolicitudConcursoPuntajeLocalHome();
    }

    private PedidosConcursoRecomendadaLocalHome getPedidosConcursoRecomendadaLocalHome() {
            return new PedidosConcursoRecomendadaLocalHome();
    }

    

       
    
}
