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
 * Autor : Damasia Maneiro
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOETramitarCierre;
import es.indra.sicc.dtos.inc.DTOParametrosCalculosRanking;
import es.indra.sicc.dtos.inc.DTOVentaRankingGerente;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class MONRankingBean
        implements SessionBean {
    private SessionContext ctx;

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

    public void evaluarRanking(DTOFACProcesoCierre dtoin)
            throws MareException {
        this.evaluarRanking(dtoin, null);
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   05/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void evaluarRanking(DTOFACProcesoCierre dtoin, Long oidConcurso) throws MareException {
        UtilidadesLog.info("MONRankingBean.evaluarRanking(DTOFACProcesoCierre dtoin, Long oidConcurso):Entrada");
        UtilidadesLog.debug("Empezo evaluarRanking con DTOFACProcesoCierre: " + dtoin + " y oidConcurso: " + oidConcurso);

        try {
            // sapaza -- PER-SiCC-2011-1005 -- 21/12/2011
            if(oidConcurso != null)
                FactoriaConcurso.refrescarConcursos();
            
            ConcursosRankingHelper crHelper = new ConcursosRankingHelper();
            AmbitoGeografico ambGeoC = crHelper.completarAmbitoGeografico(dtoin.getRegion(), dtoin.getZona());
    
            UtilidadesLog.debug("AmbitoGeografico: " + ambGeoC);
    
            DAOClientePremiacion daoPrem = new DAOClientePremiacion();
            DTOETramitarCierre dtoE = new DTOETramitarCierre();
            dtoE.setOidPeriodo(dtoin.getPeriodo());
            dtoE.setOidMarca(dtoin.getMarca());
            dtoE.setOidCanal(dtoin.getCanal());
            dtoE.setOidPais(dtoin.getOidPais());
    
            Periodo periodoCalculo = daoPrem.obtenerPeriodo(dtoE);
    
            InfoGerentesConcursos infoGerentesConcursos = new InfoGerentesConcursos(dtoin);
            infoGerentesConcursos.setPeriodoCierre(periodoCalculo);
    
            UtilidadesLog.debug("infoGerentesConcursos: " + infoGerentesConcursos);
    
            DAOBaseCalculo daoBC = new DAOBaseCalculo();
            RecordSet rsClientesConcursos = null;
    
            if (oidConcurso != null) {
                rsClientesConcursos = daoBC.obtenerClientesConcursosRanking(oidConcurso);
            } else {
                rsClientesConcursos = daoBC.obtenerClientesConcursosRanking(dtoin);
            }
    
            UtilidadesLog.debug("rsClientesConcursos: " + rsClientesConcursos);
    
            Long ultConcProcesado = null;
            boolean procesarCliente = true;
    
            int rows = rsClientesConcursos.getRowCount();
    
            for (int i = 0; i < rows; i++) {
                // Obtengo informacion del registro actual que necesito en los siguientes IFs
                BigDecimal decOidConcurso = (BigDecimal) rsClientesConcursos.getValueAt(i, "OID_PARA_GRAL");
                BigDecimal decOidFormaCalc = (BigDecimal) rsClientesConcursos.getValueAt(i, "FCAL_OID_FORM_CALC");
                Long oidConcursoActual = new Long(decOidConcurso.longValue());
                Long oidFormaCalc = (decOidFormaCalc == null) ? null : new Long(decOidFormaCalc.longValue());
    
                if (!oidConcursoActual.equals(ultConcProcesado)) {
                    UtilidadesLog.debug("oidConcursoActual: " + oidConcursoActual);
    
                    if ((ambGeoC == null) || crHelper.validarAmbitoGeografico(oidConcursoActual, ambGeoC, null).booleanValue()) {
                        UtilidadesLog.debug("procesarCliente: true ");
                        procesarCliente = true;
    
                        if (!ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.equals(oidFormaCalc)) {
                            UtilidadesLog.debug("eliminar Resultados Ranking ");
                            crHelper.eliminarResultadosRanking(oidConcursoActual, dtoin.getPeriodo());
                        }
                    } else {
                        procesarCliente = false;
                        UtilidadesLog.debug("procesarCliente: false ");
                    }
    
                    ultConcProcesado = oidConcursoActual;
                }
                
                // vbongiov -- 22/09/2006 -- inc DBLG500000756
                AmbitoGeografico ambGeo = new AmbitoGeografico();
                ambGeo.setOidSubgerencia(rsClientesConcursos.getValueAt(i, "OID_SUBG_VENT")==null?null:new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "OID_SUBG_VENT")).longValue()));
                ambGeo.setOidRegion(rsClientesConcursos.getValueAt(i, "OID_REGI")==null?null:new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "OID_REGI")).longValue()));
                ambGeo.setOidZona(rsClientesConcursos.getValueAt(i, "OID_ZONA")==null?null:new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "OID_ZONA")).longValue()));
                ambGeo.setOidSeccion(rsClientesConcursos.getValueAt(i, "OID_SECC")==null?null:new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "OID_SECC")).longValue()));
                ambGeo.setOidTerritorio(rsClientesConcursos.getValueAt(i, "TERR_OID_TERR")==null?null:new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "TERR_OID_TERR")).longValue()));
              
                // Asigna el gerente de la UA
                Gerente ger = new Gerente();            
                Long oidCliente = new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "CLIE_OID_CLIE")).longValue());
                
                ger.setOidCliente(oidCliente);
                
                UnidadAdministrativa unidadAdministrativa = new UnidadAdministrativa();
                
                if(ambGeo.getOidSeccion()!=null) {
                    ambGeo.setLider(ger); 
                    unidadAdministrativa.setOidSeccion(rsClientesConcursos.getValueAt(i, "OID_SECC")==null?null:new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "OID_SECC")).longValue()));
                } else if(ambGeo.getOidZona()!=null) {
                    ambGeo.setGerenteZona(ger); 
                    unidadAdministrativa.setOidZona(rsClientesConcursos.getValueAt(i, "OID_ZONA")==null?null:new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "OID_ZONA")).longValue()));
                } else if(ambGeo.getOidRegion()!=null) {
                    ambGeo.setGerenteRegion(ger); 
                    unidadAdministrativa.setOidRegion(rsClientesConcursos.getValueAt(i, "OID_REGI")==null?null:new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "OID_REGI")).longValue()));
                } else if(ambGeo.getOidSubgerencia()!=null) {
                    ambGeo.setSubgerente(ger); 
                    unidadAdministrativa.setOidSubgerencia(rsClientesConcursos.getValueAt(i, "OID_SUBG_VENT")==null?null:new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "OID_SUBG_VENT")).longValue()));
                }
    
                if (procesarCliente && crHelper.validarAmbitoGeografico(oidConcursoActual, ambGeo, oidCliente).booleanValue()) {
                    if (!ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.equals(oidFormaCalc)) {
                        UtilidadesLog.debug("Forma de calculo: Base Calculo ");
                        /* vbongiov -- 22/09/2006 -- inc DBLG500000756
                        // Tomo informacion de zonificacion del registro
                        BigDecimal decOidSubgerencia = (BigDecimal) rsClientesConcursos.getValueAt(i, "OID_SUBG_VENT");
                        BigDecimal decOidRegion = (BigDecimal) rsClientesConcursos.getValueAt(i, "OID_REGI");
                        BigDecimal decOidZona = (BigDecimal) rsClientesConcursos.getValueAt(i, "OID_ZONA");
                        BigDecimal decOidSeccion = (BigDecimal) rsClientesConcursos.getValueAt(i, "OID_SECC");
                        BigDecimal decOidTerritorio = (BigDecimal) rsClientesConcursos.getValueAt(i, "TERR_OID_TERR");
                        Long oidSubgerencia = new Long(decOidSubgerencia.longValue());
                        Long oidRegion = new Long(decOidRegion.longValue());
                        Long oidZona = new Long(decOidZona.longValue());
                        Long oidSeccion = new Long(decOidSeccion.longValue());
                        Long oidTerritorio = new Long(decOidTerritorio.longValue());
    
                        // Asigno al ambito geografico
                        AmbitoGeografico ambGeoClie = new AmbitoGeografico();
                        ambGeoClie.setOidSubgerencia(oidSubgerencia);
                        ambGeoClie.setOidRegion(oidRegion);
                        ambGeoClie.setOidZona(oidZona);
                        ambGeoClie.setOidSeccion(oidSeccion);
                        ambGeoClie.setOidTerritorio(oidTerritorio);
    
                        if (crHelper.validarAmbitoGeografico(oidConcursoActual, ambGeoClie).booleanValue()) {
                            UtilidadesLog.debug("validarAmbitoGeografico true ");
                        */
                            DatosConcurso datosConc = new DatosConcurso();
    
                            // Obtengo informacion del registro
                            BigDecimal decOidBaseCalculo = (BigDecimal) rsClientesConcursos.getValueAt(i, "BCAL_OID_BASE_CALC");
                            BigDecimal decOidDirigidoA = (BigDecimal) rsClientesConcursos.getValueAt(i, "DIRI_OID_DIRI");
                            BigDecimal decOidTipoRanking = (BigDecimal) rsClientesConcursos.getValueAt(i, "TPRK_OID_TIPO_RANK");
                            BigDecimal decOidTipoExig = (BigDecimal) rsClientesConcursos.getValueAt(i, "TEXI_OID_TIPO_EXIG");
                            
                            Long oidBaseCalculo = (decOidBaseCalculo == null) ? null : new Long(decOidBaseCalculo.longValue());
                            Long oidDirigidoA = new Long(decOidDirigidoA.longValue());
                            Long oidTipoRanking = (decOidTipoRanking == null) ? null : new Long(decOidTipoRanking.longValue());
                            Long oidTipoExig = (decOidTipoExig == null) ? null : new Long(decOidTipoExig.longValue());
    
                            // Asigno a datos concurso
                            datosConc.setOidConcurso(oidConcursoActual);
                            datosConc.setBaseCalculo(oidBaseCalculo);
                            datosConc.setDirigidoA(oidDirigidoA);
                            datosConc.setTipoRanking(oidTipoRanking);
                            // vbongiov -- 27/07/2006 -- inc DBLG500000937
                            datosConc.setTipoExigenciaRanking(oidTipoExig);
                            
                            UtilidadesLog.debug("DatosConcurso:  " + datosConc);
    /*
                            BigDecimal decOidCliente = (BigDecimal) rsClientesConcursos.getValueAt(i, "CLIE_OID_CLIE");
                            Long oidCliente = new Long(((BigDecimal) rsClientesConcursos.getValueAt(i, "CLIE_OID_CLIE")).longValue());
                            
                            Long oidCliente = new Long(decOidCliente.longValue());*/
                            UtilidadesLog.debug("oidCliente:  " + oidCliente);
                            
                            ClienteConcursoBaseCalculoRanking clieConcBaseCalcRank = new ClienteConcursoBaseCalculoRanking(oidCliente, datosConc,
                                                                                                                           periodoCalculo);
                            UtilidadesLog.debug("ClienteConcursoBaseCalculoRanking: " + clieConcBaseCalcRank.getOidCliente() + " OidConcurso: " + clieConcBaseCalcRank.getConcurso().getOidConcurso());
                            Boolean calcularResultado = clieConcBaseCalcRank.calcularResultado();
                            
                             if(calcularResultado!=null) {
                                UtilidadesLog.debug("es gerente: " + clieConcBaseCalcRank.getOidCliente());
                                UtilidadesLog.debug("Despues del calculo ClienteConcursoBaseCalculoRanking: " + clieConcBaseCalcRank.getResultado());
                                daoBC.grabarResultadosRanking(clieConcBaseCalcRank);
                            }
                        //}
                    } else {
                        UtilidadesLog.debug("Forma de calculo: Variable de Venta ");
    
                       // BigDecimal decOidCliente = (BigDecimal) rsClientesConcursos.getValueAt(i, "CLIE_OID_CLIE");
                        //Long oidCliente = new Long(decOidCliente.longValue());
    
                        UtilidadesLog.debug("GerenteVariablesVenta: " + oidCliente);
                        /* vbongiov -- 22/09/2006 -- inc DBLG500000756
                        GerenteVariablesVenta gerente = infoGerentesConcursos.getGerente(oidCliente);
    
                        UnidadesAdministrativasGerenciadas unidadesGerenciadas = gerente.getUnidadesGerenciadas();
                        ArrayList arrayUnidadesGerenciadas = unidadesGerenciadas.getUnidadesGerenciadas();
                        UtilidadesLog.debug("arrayUnidadesGerenciadas: " + arrayUnidadesGerenciadas);
                        
                        if(arrayUnidadesGerenciadas!= null) {
    
                            Integer tipoUnidad = crHelper.obtenerTipoUnidadesAdministrativas(unidadesGerenciadas);
                            UtilidadesLog.debug("tipoUnidad: " + tipoUnidad);
        
                            Iterator iteradorUnidadesGerenciadas = arrayUnidadesGerenciadas.iterator();
        
                            while (iteradorUnidadesGerenciadas.hasNext()) {
                                Long unidad = (Long) iteradorUnidadesGerenciadas.next();
                                UtilidadesLog.debug("unidad: " + unidad);
        
                                UnidadAdministrativa uniAdm = new UnidadAdministrativa();
        
                                if (tipoUnidad.equals(ConstantesUnidadAdministrativa.SUBGERENCIA)) {
                                    uniAdm.setOidSubgerencia(unidad);
                                }
        
                                if (tipoUnidad.equals(ConstantesUnidadAdministrativa.REGION)) {
                                    uniAdm.setOidRegion(unidad);
                                }
        
                                if (tipoUnidad.equals(ConstantesUnidadAdministrativa.ZONA)) {
                                    uniAdm.setOidZona(unidad);
                                }
        
                                if (tipoUnidad.equals(ConstantesUnidadAdministrativa.SECCION)) {
                                    uniAdm.setOidSeccion(unidad);
                                }*/
        
                                DTOParametrosCalculosRanking dtoParaCalcRank = new DTOParametrosCalculosRanking();
                                dtoParaCalcRank.setOidConcurso(oidConcursoActual);
                                dtoParaCalcRank.setOidGerente(oidCliente);
                                dtoParaCalcRank.setPeriodoCierre(periodoCalculo);
                                dtoParaCalcRank.setUnidadAdministrativaGerente(unidadAdministrativa);
        
                                this.calcularVariablesVentaRanking(dtoParaCalcRank);
                            //}
                        //}
                    }
                } // Fin if (procesarCliente)
            } // Fin for
            
        } catch (Exception e){   
             UtilidadesLog.error("ERROR ", e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
            
        UtilidadesLog.info("MONRankingBean.evaluarRanking(DTOFACProcesoCierre dtoin, Long oidConcurso):Salida");
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   05/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void calcularVariablesVentaRanking(DTOParametrosCalculosRanking dtoE)
            throws MareException {
        UtilidadesLog.info("MONRankingBean.calcularVariablesVentaRanking(DTOParametrosCalculosRanking dtoE):Entrada");

        Long oidGerente = dtoE.getOidGerente();
        Long oidConcurso = dtoE.getOidConcurso();
        UnidadAdministrativa uniAdmGer = dtoE.getUnidadAdministrativaGerente();
        GerenteConcursoVariablesVentaRanking gerConcVarVtaRank = new GerenteConcursoVariablesVentaRanking(oidGerente, oidConcurso, uniAdmGer);

        Periodo periodoCierre = dtoE.getPeriodoCierre();
        gerConcVarVtaRank.calcularResultados(periodoCierre);

        DTOVentaRankingGerente dtoVtaRankGerente = new DTOVentaRankingGerente();
        dtoVtaRankGerente.setConcurso(oidConcurso);
        dtoVtaRankGerente.setGerente(oidGerente);

        HashMap resultVarVtaRank = gerConcVarVtaRank.getResultados();
        Iterator iteradorEntries = resultVarVtaRank.entrySet().iterator();

        while (iteradorEntries.hasNext()) {
            Map.Entry entry = (Map.Entry) iteradorEntries.next();
            UnidadAdministrativa uniAdmEntry = (UnidadAdministrativa) entry.getKey();
            ResultadoVariablesVentaRanking resultEntry = (ResultadoVariablesVentaRanking) entry.getValue();

            dtoVtaRankGerente.setOidSubgerencia(uniAdmEntry.getOidSubgerencia());
            dtoVtaRankGerente.setOidRegion(uniAdmEntry.getOidRegion());
            dtoVtaRankGerente.setOidZona(uniAdmEntry.getOidZona());
            dtoVtaRankGerente.setOidSeccion(uniAdmEntry.getOidSeccion());

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_VENTAS).booleanValue()) {
                BigDecimal importeVentas = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_VENTAS, resultEntry.getImporteVentas());
                dtoVtaRankGerente.setImporteVentas(importeVentas);
                
                BigDecimal resUnidades = resultEntry.getUnidades()!=null?new BigDecimal(resultEntry.getUnidades().toString()):new BigDecimal(0);
                Long unidades = new Long(gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_VENTAS, resUnidades).longValue());
                dtoVtaRankGerente.setUnidades(unidades);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_INICIALES).booleanValue()) {
                BigDecimal resActivasIniciales = resultEntry.getActivasIniciales()!= null?new BigDecimal(resultEntry.getActivasIniciales().toString()): new BigDecimal(0);
                BigDecimal decActivasIniciales = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_INICIALES,
                                                                                      resActivasIniciales);
                                                                                      
                Long activasIniciales = new Long(decActivasIniciales.longValue());
                dtoVtaRankGerente.setActivasIniciales(activasIniciales);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_FINALES).booleanValue()) {
                BigDecimal resActivasFinales = resultEntry.getActivasFinales()!= null?new BigDecimal(resultEntry.getActivasFinales().toString()): new BigDecimal(0);
                BigDecimal decActivasFinales = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_FINALES,
                                                                                    resActivasFinales);
                                                                                    
                Integer activasFinales = new Integer(decActivasFinales.intValue());
                dtoVtaRankGerente.setActivasFinales(activasFinales);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_NUMERO_PEDIDOS).booleanValue()) {
                BigDecimal numeroPedidos = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_NUMERO_PEDIDOS,
                                                                                resultEntry.getNumeroPedidos());
                dtoVtaRankGerente.setNumeroPedidos(numeroPedidos);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ACTIVIDAD).booleanValue()) {
                BigDecimal porcAct = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ACTIVIDAD,
                                                                          resultEntry.getPorcentajeActividad());
                dtoVtaRankGerente.setPorcentajeActividad(porcAct);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_CONSTANCIA).booleanValue()) {
                BigDecimal constancia = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_CONSTANCIA, resultEntry.getConstancia());
                dtoVtaRankGerente.setConstancia(constancia);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_INGRESOS).booleanValue()) {
                BigDecimal ingresos = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_INGRESOS, resultEntry.getIngresos());
                dtoVtaRankGerente.setIngresos(ingresos);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_REINGRESOS).booleanValue()) {
                BigDecimal reingresos = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_REINGRESOS, resultEntry.getReingresos());
                dtoVtaRankGerente.setReingresos(reingresos);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_EGRESOS).booleanValue()) {
                BigDecimal egresos = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_EGRESOS, resultEntry.getEgresos());
                dtoVtaRankGerente.setEgresos(egresos);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_ENTREGADAS).booleanValue()) {
                BigDecimal entregadas = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_ENTREGADAS, resultEntry.getEntregadas());
                dtoVtaRankGerente.setEntregadas(entregadas);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_RECIBIDAS).booleanValue()) {
                BigDecimal recibidas = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_RECIBIDAS, resultEntry.getRecibidas());
                dtoVtaRankGerente.setRecibidas(recibidas);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_CATIPALIZACION).booleanValue()) {
                BigDecimal capitalizacion = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_CATIPALIZACION,
                                                                                 resultEntry.getCapitalizacion());
                dtoVtaRankGerente.setCapitalizacion(capitalizacion);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PRECIO_PROMEDIO_UNITARIO).booleanValue()) {
                BigDecimal ppu = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_PRECIO_PROMEDIO_UNITARIO, resultEntry.getPpu());
                dtoVtaRankGerente.setPpu(ppu);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_VENTAS_PEDIDO).booleanValue()) {
                BigDecimal pvp = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_VENTAS_PEDIDO, resultEntry.getPvp());
                dtoVtaRankGerente.setPvp(pvp);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_UNIDADES_PEDIDO).booleanValue()) {
                BigDecimal pup = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_UNIDADES_PEDIDO, resultEntry.getPup());
                dtoVtaRankGerente.setPup(pup);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_ORDENES_PEDIDO).booleanValue()) {
                BigDecimal pop = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_ORDENES_PEDIDO, resultEntry.getPop());
                dtoVtaRankGerente.setPop(pop);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_RETENCION).booleanValue()) {
                BigDecimal retencion = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_RETENCION,
                                                                            resultEntry.getRetencion());
                dtoVtaRankGerente.setRetencion(retencion);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_COBRANZA).booleanValue()) {
                BigDecimal cobranza = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_COBRANZA,
                                                                           resultEntry.getCobranza());
                dtoVtaRankGerente.setCobranza(cobranza);
            }

            if (gerConcVarVtaRank.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ROTACION).booleanValue()) {
                BigDecimal rotacion = gerConcVarVtaRank.aplicarPesoDivisor(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ROTACION,
                                                                           resultEntry.getRotacion());
                dtoVtaRankGerente.setRotacion(rotacion);
            }

            DAOVariablesVentaRanking dao = new DAOVariablesVentaRanking();
            dao.grabarVentaRankingGerente(dtoVtaRankGerente);
        }

        UtilidadesLog.info("MONRankingBean.calcularVariablesVentaRanking(DTOParametrosCalculosRanking dtoE):Salida");
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       02/12/2005
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */ 
   public void preProcesoSolicitudesRanking(Long oidConsultora, Long oidConcurso, Periodo periodoDesde, Periodo periodoHasta) throws MareException {
   
       UtilidadesLog.info("MONRankingBean.preProcesoSolicitudesRanking(Long oidConsultora, Long oidConcurso, Periodo periodoDesde, Periodo periodoHasta):Entrada");
       
       FactoriaConcurso factoria= FactoriaConcurso.getFactoriaConcurso();
       
       DTOOIDs dtoOids = new DTOOIDs();
       Long[] oids = { oidConcurso };
       dtoOids.setOids(oids);

       ArrayList concursos = factoria.getConcursosPorOID(dtoOids);
       Concurso concurso = (Concurso) concursos.get(0);
       
       DAOBaseCalculo daoBaseCalculo = new DAOBaseCalculo();
       
       RecordSet rs = daoBaseCalculo.obtenerSolicitudesFacturadas(oidConsultora, periodoDesde.getOidPeriodo(), 
                                                                                  periodoHasta.getOidPeriodo(), Boolean.valueOf(concurso.getIndAnulacion()),Boolean.valueOf(concurso.getIndDevolucion()));
       try {
            if(rs!=null) {
                MONIncentivos monInc = this.getMONIncentivosHome().create();
                
                int cant = rs.getRowCount();
                
                for (int row = 0; row < cant; row++) {
                
                    DTOSolicitudValidacion registro = new DTOSolicitudValidacion();
                    
                    registro.setOidCliente((rs.getValueAt(row, "CLIE_OID_CLIE") == null) ? null
                                                                                         : new Long(((BigDecimal) rs.getValueAt(row, "CLIE_OID_CLIE")).toString()));
                    registro.setOidSolicitud((rs.getValueAt(row, "OID_SOLI_CABE") == null) ? null
                                                                                           : new Long(((BigDecimal) rs.getValueAt(row, "OID_SOLI_CABE")).toString()));
                    registro.setZona((rs.getValueAt(row, "ZZON_OID_ZONA") == null) ? null
                                                                                   : new Long(((BigDecimal) rs.getValueAt(row, "ZZON_OID_ZONA")).toString()));
                    registro.setOidPeriodo((rs.getValueAt(row, "PERD_OID_PERI") == null) ? null
                                                                                         : new Long(((BigDecimal) rs.getValueAt(row, "PERD_OID_PERI")).toString()));
                    registro.setOidPais((rs.getValueAt(row, "PAIS_OID_PAIS") == null) ? null
                                                                                      : new Long(((BigDecimal) rs.getValueAt(row, "PAIS_OID_PAIS")).toString()));
                    registro.setOidMarca((rs.getValueAt(row, "MARC_OID_MARC") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "MARC_OID_MARC")).toString()));
                    registro.setOidCanal((rs.getValueAt(row, "CANA_OID_CANA") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "CANA_OID_CANA")).toString()));
                                                                                       
                    registro.setIndOrdenCompra((rs.getValueAt(row, "IND_OC")).toString().equals("1")?Boolean.TRUE: Boolean.FALSE);
                    
                    registro.setOidAcceso(new Long(((BigDecimal) rs.getValueAt(row, "ACCE_OID_ACCE")).toString()));
                    
                    UtilidadesLog.debug("registro.getOidSolicitud: " + registro.getOidSolicitud());
    
                    monInc.concursarSolicitudRanking(registro, oidConcurso);
                }
            }
            
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
       
       UtilidadesLog.info("MONRankingBean.preProcesoSolicitudesRanking(Long oidConsultora, Long oidConcurso, Periodo periodoDesde, Periodo periodoHasta):Salida");
   }


    private MONIncentivosHome getMONIncentivosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONIncentivosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONIncentivos"), MONIncentivosHome.class);
  }


}
