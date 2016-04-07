/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GerenteConcursoVariablesVentaRanking implements Serializable {
    private Long gerente;
    private Long concurso;
    private boolean indProductosExigidos;
    private UnidadAdministrativa unidadAdministrativaGerente;
    private Periodo periodoCierre;
    private Periodo periodoDesde;
    private HashMap variablesConcurso;
    private HashMap resultados;
    private Periodo periodoHasta;

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public GerenteConcursoVariablesVentaRanking(Long oidGerente, Long oidConcurso, UnidadAdministrativa unidadAdmin)
            throws MareException {
        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.GerenteConcursoVariablesVentaRanking(Long oidGerente, Long oidConcurso, UnidadAdministrativa unidadAdmin):Entrada");
        this.gerente = oidGerente;
        this.concurso = oidConcurso;
        this.unidadAdministrativaGerente = unidadAdmin;
        this.resultados = new HashMap();

        DAOVariablesVentaRanking dao = new DAOVariablesVentaRanking();
        this.periodoDesde = dao.recuperarPeriodoDesde(this.concurso);
        this.periodoHasta = dao.recuperarPeriodoHasta(this.concurso);
        this.variablesConcurso = dao.recuperarVariablesVentaRankingConcurso(this.concurso);
        dao.recuperarIndicadoresConcurso(this);
        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.GerenteConcursoVariablesVentaRanking(Long oidGerente, Long oidConcurso, UnidadAdministrativa unidadAdmin):Salida");
    }

    public Long getGerente() {
        return gerente;
    }

    public void setGerente(Long gerente) {
        this.gerente = gerente;
    }

    public Long getConcurso() {
        return concurso;
    }

    public void setConcurso(Long concurso) {
        this.concurso = concurso;
    }

    public boolean getIndProductosExigidos() {
        return indProductosExigidos;
    }

    public void setIndProductosExigidos(boolean indProductosExigidos) {
        this.indProductosExigidos = indProductosExigidos;
    }

    public UnidadAdministrativa getUnidadAdministrativaGerente() {
        return unidadAdministrativaGerente;
    }

    public void setUnidadAdministrativaGerente(UnidadAdministrativa unidadAdministrativaGerente) {
        this.unidadAdministrativaGerente = unidadAdministrativaGerente;
    }

    public Periodo getPeriodoCierre() {
        return periodoCierre;
    }

    public void setPeriodoCierre(Periodo periodoCierre) {
        this.periodoCierre = periodoCierre;
    }

    public Periodo getPeriodoDesde() {
        return periodoDesde;
    }

    public void setPeriodoDesde(Periodo periodoDesde) {
        this.periodoDesde = periodoDesde;
    }

    public Periodo getPeriodoHasta() {
        return periodoHasta;
    }

    public void setPeriodoHasta(Periodo periodoHasta) {
        this.periodoHasta = periodoHasta;
    }

    /**
     * Chequea si la variable (codigoVariable) esta en el HashMap
     * variablesConcurso
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public Boolean isVariableConcurso(Integer codigoVariable) {
        boolean is = this.variablesConcurso.containsKey(codigoVariable);

        return new Boolean(is);
    }

    /**
     * Actualiza en el HashMap resultados el valor de la variable (codigoVariable)
     * con la cantidad (valor) en la unidad adminstrativa (uniAdmGer)
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void setVariableResultado(UnidadAdministrativa uniAdm, Integer codigoVariable, Object valor) {
        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.setVariableResultado(UnidadAdministrativa uniAdm, Integer codigoVariable, Object valor):Entrada");
        UtilidadesLog.debug("Empieza setVariableResultado con UnidadAdministrativa: " + uniAdm + " codigoVariable: " + codigoVariable + " valor: " +
                           valor);
                           
        UnidadAdministrativa UA = null;
        UnidadAdministrativa uniAdmRS = new UnidadAdministrativa();
        
        uniAdmRS.setOidSubgerencia(uniAdm.getOidSubgerencia());
        uniAdmRS.setOidRegion(uniAdm.getOidRegion());
        uniAdmRS.setOidZona(uniAdm.getOidZona());
        uniAdmRS.setOidSeccion(uniAdm.getOidSeccion());        
        
        // Busca la uniAdm a actualizar
        Iterator it = this.resultados.entrySet().iterator();
        
        UtilidadesLog.debug("this.resultados antes: " + this.resultados);        
        
        while (it.hasNext()) { 
            Map.Entry entry = (Map.Entry) it.next();

            UA = (UnidadAdministrativa)entry.getKey();
            
            if(uniAdmRS.equalsUA(UA)){
                uniAdmRS = UA;
                UtilidadesLog.debug("Son iguales : " + UA);
                break;
            }
        }      
        
        UtilidadesLog.debug("this.resultados despues: " + this.resultados);        

        ResultadoVariablesVentaRanking resultVarVtaRank = (ResultadoVariablesVentaRanking) this.resultados.get(uniAdmRS);

        UtilidadesLog.debug("resultVarVtaRank " + resultVarVtaRank);
        
        if (resultVarVtaRank == null) {
            resultVarVtaRank = new ResultadoVariablesVentaRanking();
        }

        if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_VENTAS)) {
            BigDecimal importeVentas = (BigDecimal) valor;
            resultVarVtaRank.setImporteVentas(importeVentas);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_INICIALES)) {
            Long activasIniciales = (Long) valor;
            resultVarVtaRank.setActivasIniciales(activasIniciales);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_FINALES)) {
            Integer activasFinales = (Integer) valor;
            resultVarVtaRank.setActivasFinales(activasFinales);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ACTIVIDAD)) {
            BigDecimal porcentajeActividad = (BigDecimal) valor;
            resultVarVtaRank.setPorcentajeActividad(porcentajeActividad);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_CONSTANCIA)) {
            BigDecimal constancia = (BigDecimal) valor;
            resultVarVtaRank.setConstancia(constancia);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_INGRESOS)) {
            BigDecimal ingresos = (BigDecimal) valor;
            resultVarVtaRank.setIngresos(ingresos);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_REINGRESOS)) {
            BigDecimal reingresos = (BigDecimal) valor;
            resultVarVtaRank.setReingresos(reingresos);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_EGRESOS)) {
            BigDecimal egresos = (BigDecimal) valor;
            resultVarVtaRank.setEgresos(egresos);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_ENTREGADAS)) {
            BigDecimal entregadas = (BigDecimal) valor;
            resultVarVtaRank.setEntregadas(entregadas);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_RECIBIDAS)) {
            BigDecimal recibidas = (BigDecimal) valor;
            resultVarVtaRank.setRecibidas(recibidas);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_CATIPALIZACION)) {
            BigDecimal capitalizacion = (BigDecimal) valor;
            resultVarVtaRank.setCapitalizacion(capitalizacion);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_NUMERO_PEDIDOS)) {
            BigDecimal numeroPedidos = (BigDecimal) valor;
            resultVarVtaRank.setNumeroPedidos(numeroPedidos);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PRECIO_PROMEDIO_UNITARIO)) {
            BigDecimal ppu = (BigDecimal) valor;
            resultVarVtaRank.setPpu(ppu);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_VENTAS_PEDIDO)) {
            BigDecimal pvp = (BigDecimal) valor;
            resultVarVtaRank.setPvp(pvp);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_UNIDADES_PEDIDO)) {
            BigDecimal pup = (BigDecimal) valor;
            resultVarVtaRank.setPup(pup);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_ORDENES_PEDIDO)) {
            BigDecimal pop = (BigDecimal) valor;
            resultVarVtaRank.setPop(pop);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_RETENCION)) {
            BigDecimal retencion = (BigDecimal) valor;
            resultVarVtaRank.setRetencion(retencion);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_COBRANZA)) {
            BigDecimal cobranza = (BigDecimal) valor;
            resultVarVtaRank.setCobranza(cobranza);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ROTACION)) {
            BigDecimal rotacion = (BigDecimal) valor;
            resultVarVtaRank.setRotacion(rotacion);
        } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_UNIDADES)) {
            Long unidades = (Long) valor;
            resultVarVtaRank.setUnidades(unidades);
        }
        
        UtilidadesLog.debug("uniAdm de salida: " + uniAdmRS);
        UtilidadesLog.debug("resultVarVtaRank de salida: " + resultVarVtaRank);

        // Almaceno el resultado en el hashmap
        this.resultados.put(uniAdmRS, resultVarVtaRank);

        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.setVariableResultado(UnidadAdministrativa uniAdm, Integer codigoVariable, Object valor):Salida");
    }

    /**
     * Retorna, del HashMap resultados, el valor de la variable (codigoVariable)
     * en la unidad adminstrativa (uniAdmGer)
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public Object obtenerVariableResultado(UnidadAdministrativa uniAdm, Integer codigoVariable) {
        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.obtenerVariableResultado(UnidadAdministrativa uniAdm, Integer codigoVariable):Entrada");
        UtilidadesLog.debug("Empezo obtenerVariableResultado, recibo UnidadAdministrativa: " + uniAdm + " y codigoVariable: " + codigoVariable);
        
        Object variableResultado = null;
        UnidadAdministrativa UA = null;
        
        // Busca la uniAdm a actualizar
        Iterator it = this.resultados.entrySet().iterator();
        
        while (it.hasNext()) { 
            Map.Entry entry = (Map.Entry) it.next();

            UA = (UnidadAdministrativa)entry.getKey();
            
            if(uniAdm.equalsUA(UA)){
                uniAdm = UA;
                UtilidadesLog.debug("Son iguales : " + UA);
                break;
            }
        }
         
        ResultadoVariablesVentaRanking resultVarVtaRank = (ResultadoVariablesVentaRanking) this.resultados.get(uniAdm);
        
        UtilidadesLog.debug("resultVarVtaRank: " + resultVarVtaRank);
        
        if(resultVarVtaRank!=null) {

            if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_VENTAS)) {
                variableResultado = resultVarVtaRank.getImporteVentas();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_INICIALES)) {
                variableResultado = resultVarVtaRank.getActivasIniciales();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_FINALES)) {
                variableResultado = resultVarVtaRank.getActivasFinales();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ACTIVIDAD)) {
                variableResultado = resultVarVtaRank.getPorcentajeActividad();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_CONSTANCIA)) {
                variableResultado = resultVarVtaRank.getConstancia();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_INGRESOS)) {
                variableResultado = resultVarVtaRank.getIngresos();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_REINGRESOS)) {
                variableResultado = resultVarVtaRank.getReingresos();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_EGRESOS)) {
                variableResultado = resultVarVtaRank.getEgresos();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_ENTREGADAS)) {
                variableResultado = resultVarVtaRank.getEntregadas();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_RECIBIDAS)) {
                variableResultado = resultVarVtaRank.getRecibidas();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_CATIPALIZACION)) {
                variableResultado = resultVarVtaRank.getCapitalizacion();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_NUMERO_PEDIDOS)) {
                variableResultado = resultVarVtaRank.getNumeroPedidos();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PRECIO_PROMEDIO_UNITARIO)) {
                variableResultado = resultVarVtaRank.getPpu();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_VENTAS_PEDIDO)) {
                variableResultado = resultVarVtaRank.getPvp();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_UNIDADES_PEDIDO)) {
                variableResultado = resultVarVtaRank.getPup();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_ORDENES_PEDIDO)) {
                variableResultado = resultVarVtaRank.getPop();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_RETENCION)) {
                variableResultado = resultVarVtaRank.getRetencion();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_COBRANZA)) {
                variableResultado = resultVarVtaRank.getCobranza();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ROTACION)) {
                variableResultado = resultVarVtaRank.getRotacion();
            } else if (codigoVariable.equals(ConstantesRanking.VAR_VTA_RANK_UNIDADES)) {
                variableResultado = resultVarVtaRank.getUnidades();
            }
        }
        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.obtenerVariableResultado(UnidadAdministrativa uniAdm, Integer codigoVariable):Salida");
        return variableResultado;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha: 27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public BigDecimal aplicarPesoDivisor(Integer codigoVariable, BigDecimal valor) {
        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.aplicarPesoDivisor(Integer codigoVariable, BigDecimal valor):Entrada");
        BigDecimal valorRetorno = null;
        VariableVentaRanking varVtaRank = (VariableVentaRanking) this.variablesConcurso.get(codigoVariable);

        if ((varVtaRank != null) && (valor != null) && varVtaRank.getAplicable().booleanValue()) {
            BigDecimal peso = new BigDecimal(varVtaRank.getPeso().toString());
            BigDecimal divisor = new BigDecimal(varVtaRank.getDivisor().toString());
            valorRetorno = valor.multiply(peso).divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
        } else {
            valorRetorno = valor;
        }
        
        if(valorRetorno==null) {
            valorRetorno = new BigDecimal(0);
        }
        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.aplicarPesoDivisor(Integer codigoVariable, BigDecimal valor):Salida");
        return valorRetorno;
    }

    public HashMap getResultados() {
        return this.resultados;
    }

    public void setResultados(HashMap resultados) {
        this.resultados = resultados;
    }

    /**
     * Este método calcula los resultados de variables de venta ranking que dependen
     * solamente de la unidad administrativa del gerente para el periodo recibido por parametro
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha: 27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void calcularResultados(Periodo periodoCierre)
            throws MareException {
        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.calcularResultados(Periodo periodoCierre):Entrada");
        UtilidadesLog.debug("Empezo calcularVariablesVentaRanking con Periodo: " + periodoCierre.getOidPeriodo());

        VariablesVentaRankingHelper vvrHelper = new VariablesVentaRankingHelper();

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_VENTAS).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PRECIO_PROMEDIO_UNITARIO).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_VENTAS_PEDIDO).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_UNIDADES_PEDIDO).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularVentasRanking");
            vvrHelper.calcularVentasRanking(this);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_INICIALES).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_CATIPALIZACION).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ROTACION).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularActivasInicialesRanking");
            vvrHelper.calcularActivasInicialesRanking(this);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_ACTIVAS_FINALES).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_CONSTANCIA).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ACTIVIDAD).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_CATIPALIZACION).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_RETENCION).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularActivasFinalesConstanciaRanking");
            vvrHelper.calcularActivasFinalesConstanciaRanking(this, periodoCierre);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_INGRESOS).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularCantidadConsultorasPorEstado 1");
            vvrHelper.calcularCantidadConsultorasPorEstado(this, new Integer(ConstantesMAE.OID_ESTATUS_NUEVA.intValue()),
                                                           ConstantesRanking.VAR_VTA_RANK_INGRESOS);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_REINGRESOS).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ROTACION).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularCantidadConsultorasPorEstado 3");
            vvrHelper.calcularCantidadConsultorasPorEstado(this, new Integer(ConstantesMAE.OID_ESTATUS_REINGRESADA.intValue()),
                                                           ConstantesRanking.VAR_VTA_RANK_REINGRESOS);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_EGRESOS).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ROTACION).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularCantidadConsultorasPorEstado 3");
            vvrHelper.calcularCantidadConsultorasPorEstado(this, new Integer(ConstantesMAE.OID_ESTATUS_EGRESADA.intValue()),
                                                           ConstantesRanking.VAR_VTA_RANK_EGRESOS);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_ENTREGADAS).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularEntregadasRanking");
            vvrHelper.calcularEntregadasRanking(this);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_RECIBIDAS).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularRecibidasRanking");
            vvrHelper.calcularRecibidasRanking(this);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_NUMERO_PEDIDOS).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ACTIVIDAD).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_VENTAS_PEDIDO).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_UNIDADES_PEDIDO).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_ORDENES_PEDIDO).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularNumeroPedidosRanking");
            vvrHelper.calcularNumeroPedidosRanking(this);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_ORDENES_PEDIDO).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularPOPRanking");
            vvrHelper.calcularPOPRanking(this);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_COBRANZA).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularPorcentajeCobranzaRanking");
            vvrHelper.calcularPorcentajeCobranzaRanking(this);
        }

        if (this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ACTIVIDAD).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_CATIPALIZACION).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PRECIO_PROMEDIO_UNITARIO).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_VENTAS_PEDIDO).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PROMEDIO_UNIDADES_PEDIDO).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_RETENCION).booleanValue() ||
                this.isVariableConcurso(ConstantesRanking.VAR_VTA_RANK_PORCENTAJE_ROTACION).booleanValue()) {
            UtilidadesLog.debug("Entro a calcularVariablesDependientes");
            vvrHelper.calcularVariablesDependientes(this, periodoCierre);
        }

        UtilidadesLog.info("GerenteConcursoVariablesVentaRanking.calcularResultados(Periodo periodoCierre):Salida");
    }

    public String toString() {
        StringBuffer strGerente = new StringBuffer();
        strGerente.append("{ ");
        strGerente.append("Ger: " + this.gerente + "; ");
        strGerente.append("Conc: " + this.concurso + "; ");
        strGerente.append("IndProdEx: " + indProductosExigidos + "; ");
        strGerente.append("UniAdmGer: " + unidadAdministrativaGerente + "; ");
        strGerente.append("pCierre: " + this.periodoCierre + "; ");
        strGerente.append("pDesde: " + this.periodoDesde + "; ");
        strGerente.append("pHasta: " + this.periodoHasta + "; ");
        strGerente.append("varConc: " + this.variablesConcurso + "; ");
        strGerente.append("result: " + this.resultados + " ");
        strGerente.append("}");

        return strGerente.toString();
    }
}
