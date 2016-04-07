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
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005
 */
 
 
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOETramitarCierre;
import es.indra.sicc.dtos.inc.DTOReemplazoArticuloLote;
import es.indra.sicc.dtos.rec.DTOBuscarEnvia;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocalHome;
import es.indra.sicc.entidades.inc.PremiosElegidosLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.Exception;
import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Iterator;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import es.indra.sicc.logicanegocio.inc.PremioSorteo;


public class DAOClientePremiacionConcurso {

    private static int CANT_DECIMALES_PUNTOS = 0; // JVM, sicc 20070300
    private UtilidadesLog log = new UtilidadesLog();
     
    public DAOClientePremiacionConcurso() {
    }

    public void recuperarSaldoPuntos(ClientePremiacion clientePremiacion,
        ClientePremiacionConcurso clientePremiacionConcurso,
        Periodo periodoAPremiar) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarSaldoPuntos"
            +"(ClientePremiacion clientePremiacion, ClientePremiacionConcurso"
            +"clientePremiacionConcurso, Periodo periodoAPremiar):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ");
            query.append(" SUM (NUM_PUNT) AS SALDO_PUNTOS, ");
            query.append(" SUM (NUM_PUNT_EXIG) AS SALDO_PUNTOS_EXIGIDOS ");
            query.append(" FROM INC_CUENT_CORRI_PUNTO ");
            query.append(" WHERE CLIE_OID_CLIE = " + 
                clientePremiacion.getOidCliente());
            query.append(" AND COPA_OID_PARA_GRAL = " +
                clientePremiacionConcurso.getOidConcurso());
            query.append(" AND PERD_OID_PERI = " +
                clientePremiacion.getPeriodo().getOidPeriodo());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (((respuesta.getValueAt(0, "SALDO_PUNTOS")) != null) &&
                ((respuesta.getValueAt(0, "SALDO_PUNTOS_EXIGIDOS")) != null)) {
            clientePremiacionConcurso.setSaldoPuntos(new Double(
                    ((BigDecimal) respuesta.getValueAt(0, "SALDO_PUNTOS"))
                        .doubleValue()));
            clientePremiacionConcurso.setSaldoPuntosExigidos(new Double(
                    ((BigDecimal) respuesta.getValueAt(0,
                        "SALDO_PUNTOS_EXIGIDOS")).doubleValue()));
        }

        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarSaldoPuntos("
            +"ClientePremiacion clientePremiacion, ClientePremiacionConcurso "
            +"clientePremiacionConcurso, Periodo periodoAPremiar):Salida");
    }

    /**
     * @author Dante Castiglione
     */
    public Periodo recuperarPeriodoAPremiar(
        ClientePremiacion clientePremiacion, Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPeriodoAPre"
            +"miar(ClientePremiacion clientePremiacion, Concurso concurso)"
            +":Entrada");

        Periodo periodo = new Periodo();

        if (concurso.getMultiNivel() == false) {
            if (concurso.getPuntajeAcumulativo() == true) {
                UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPerio"
                    +"doAPremiar(ClientePremiacion clientePremiacion, Concurso"
                    +"concurso):Salida");

                return null;
            } else {
                UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPeri"
                    +"odoAPremiar(ClientePremiacion clientePremiacion, "
                    +"Concurso concurso):Salida");

                return clientePremiacion.getPeriodo();
            }
        } else {
            if (concurso.getMultiNivel() == true) {
                // armar objeto periodo
                periodo.setOidPeriodo(clientePremiacion.getPeriodo()
                                                       .getOidPeriodo());

                BelcorpService bs;
                RecordSet respuesta;
                StringBuffer query = new StringBuffer();

                try {
                    bs = BelcorpService.getInstance();
                } catch (MareMiiServiceNotFoundException e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                }

                try {
                    query.append(" SELECT ");
                    query.append(" COD_PERI, ");
                    query.append(" FEC_INIC, ");
                    query.append(" FEC_FINA, ");
                    query.append(" CANA_OID_CANA, ");
                    query.append(" MARC_OID_MARC, ");
                    query.append(" PAIS_OID_PAIS ");
                    query.append(" FROM CRA_PERIO CRA, ");
                    query.append(" SEG_PERIO_CORPO SEG ");
                    query.append(" WHERE CRA.PERI_OID_PERI = SEG.OID_PERI ");
                    query.append(" AND CRA.OID_PERI = " +
                        clientePremiacion.getPeriodo().getOidPeriodo());
                    query.append(" AND MARC_OID_MARC = " +
                        concurso.getOidMarca());
                    query.append(" AND CANA_OID_CANA = " +
                        concurso.getOidCanal());
                    query.append(" AND PAIS_OID_PAIS = " +
                        concurso.getOidPais());
                    respuesta = bs.dbService.executeStaticQuery(
                        query.toString());
                        
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                        
                      UtilidadesLog.debug("*** respuesta: " + respuesta);
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }

                if (!respuesta.esVacio()) {
                    periodo.setCodperiodo((String) respuesta.getValueAt(0,
                            "COD_PERI"));
                    periodo.setFechaDesde((Date) respuesta.getValueAt(0,
                            "FEC_INIC"));
                    periodo.setFechaHasta((Date) respuesta.getValueAt(0,
                            "FEC_FINA"));
                    periodo.setOidCanal(new Long(
                            ((BigDecimal) respuesta.getValueAt(0,
                                "CANA_OID_CANA")).longValue()));
                    periodo.setOidMarca(new Long(
                            ((BigDecimal) respuesta.getValueAt(0,
                                "MARC_OID_MARC")).longValue()));
                    periodo.setOidPais(new Long(
                            ((BigDecimal) respuesta.getValueAt(0,
                                "PAIS_OID_PAIS")).longValue()));
                }
            }
        }

        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPeriodoAPre"
            +"miar(ClientePremiacion clientePremiacion, Concurso concurso)"
            +":Salida");

        return periodo.calcularPeriodoAnterior(new Integer(
                concurso.getPeriodosEsperaParaCalculo().intValue()));
    }

    /**
     * @author Dante Castiglione
     */
    public void recuperarSaldoPuntosAcumulativos(
        ClientePremiacion clientePremiacion,
        ClientePremiacionConcurso clientePremiacionConcurso)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarSaldoPuntosA"
            +"cumulativos(ClientePremiacion clientePremiacion, ClientePremia"
            +"cionConcurso clientePremiacionConcurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ");
            query.append(" SUM (NUM_PUNT) AS SALDO_PUNTOS, ");
            query.append(" SUM (NUM_PUNT_EXIG) AS SALDO_PUNTOS_EXIGIDOS ");
            query.append(" FROM INC_CUENT_CORRI_PUNTO ");
            query.append(" WHERE CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());
            query.append(" AND COPA_OID_PARA_GRAL = " +
                clientePremiacionConcurso.getOidConcurso());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (((respuesta.getValueAt(0, "SALDO_PUNTOS")) != null) &&
                ((respuesta.getValueAt(0, "SALDO_PUNTOS_EXIGIDOS")) != null)) {
            Double saldoPuntos = new Double(((BigDecimal) respuesta.getValueAt(
                        0, "SALDO_PUNTOS")).doubleValue());
            clientePremiacionConcurso.setSaldoPuntos(saldoPuntos);
            clientePremiacionConcurso.setSaldoPuntosExigidos(new Double(
                    ((BigDecimal) respuesta.getValueAt(0,
                        "SALDO_PUNTOS_EXIGIDOS")).doubleValue()));
            clientePremiacionConcurso.setPuntajeObtenido(saldoPuntos);
        }

        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarSaldoPuntosA"
            +"cumulativos(ClientePremiacion clientePremiacion, ClientePremiac"
            +"ionConcurso clientePremiacionConcurso):Salida");
    }

    /**
     * @author Dante Castiglione
     */
    public ArrayList recuperarPremiosElegidos(
        ClientePremiacionConcurso clientePremiacionConcurso,
        ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremiosEle"
            +"gidos(ClientePremiacionConcurso clientePremiacionConcurso, Clie"
            +"ntePremiacion clientePremiacion):Entrada");

        //0.- jrivas 21/7/2006 DBLG500001013
        int saldoPuntosAux = clientePremiacionConcurso.getSaldoPuntos().intValue();        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("recuperarPremiosElegidos  --- saldoPuntosAux " + saldoPuntosAux);

        BelcorpService bs1;
        RecordSet respuesta1;
        StringBuffer query1 = new StringBuffer();

        try {
            bs1 = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //1.-
            query1.append(" SELECT ");
            query1.append(" OID_PARA_NIVE_PREM, ");
            query1.append(" TPRE_OID_TIPO_PREM, ");
            query1.append(" inc_param_nivel_premi.NUM_NIVE, ");
            query1.append(" NUM_CANT_FIJA_PUNT, ");
            query1.append(" NUM_CANT_INIC_PUNT, ");
            query1.append(" NUM_CANT_FINA_PUNT, ");
            query1.append(" OID_PREM_ELEG, ");
            query1.append(" NUM_PREM, ");
            query1.append(" NUM_PUNT_PROD_EXIG, ");
            query1.append(" PERD_OID_PERI, ");
            query1.append(" cp.MARC_OID_MARC, ");
            query1.append(" cp.CANA_OID_CANA, ");
            query1.append(" cp.PAIS_OID_PAIS, ");
            query1.append(" V.VAL_I18N descTipoPremio, ");
            //jrivas 21/7/2006 DBLG500001013
            query1.append(" NVL(NUM_CANT_FIJA_PUNT, NUM_CANT_INIC_PUNT) AS PUNTOS ");
            query1.append(" FROM INC_PREMI_ELEGI, ");
            query1.append(" INC_PARAM_NIVEL_PREMI, ");
            query1.append(" INC_CONCU_PARAM_GENER conc, ");
            query1.append(" INC_PARAM_GENER_PREMI pgp, CRA_PERIO cp, ");
            query1.append(" V_GEN_I18N_SICC V ");
            query1.append(" WHERE CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());
            query1.append(" AND INC_PREMI_ELEGI.COPA_OID_PARA_GRAL = " +
                clientePremiacionConcurso.getOidConcurso());
            query1.append(" AND PANP_OID_PARA_NIVE_PREM = OID_PARA_NIVE_PREM ");
            query1.append(" AND PAGP_OID_PARA_GENE_PREM = OID_PARA_GENE_PREM ");
            query1.append(" AND PERD_OID_PERI_DESD = OID_PERI ");
            query1.append(" AND conc.OID_PARA_GRAL = pgp.COPA_OID_PARA_GRAL ");
            query1.append(" AND V.VAL_OID = TPRE_OID_TIPO_PREM ");
            query1.append(" AND V.ATTR_NUM_ATRI = 1  ");
            query1.append(" AND V.ATTR_ENTI = 'INC_TIPO_PREMI' ");
            query1.append(" AND V.IDIO_OID_IDIO = " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
            query1.append(" ORDER BY PUNTOS DESC ");
            
            respuesta1 = bs1.dbService.executeStaticQuery(query1.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta1: " + respuesta1);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Periodo periodoDespacho = new Periodo();
        ArrayList salida = new ArrayList();
        String descTipoPremio = null;

        for (int i1 = 0; i1 < respuesta1.getRowCount(); i1++) {
            //1.1.- jrivas 21/7/2006 DBLG500001013
            int costoPremio = ((respuesta1.getValueAt(i1, "PUNTOS") != null)
                ? ((BigDecimal) respuesta1.getValueAt(i1, "PUNTOS")).intValue(): 0);            

            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("recuperarPremiosElegidos  --- costoPremio " + costoPremio);
              UtilidadesLog.debug("recuperarPremiosElegidos saldoPuntosAux >= puntosLeidos " 
                + (saldoPuntosAux >= costoPremio));
            }   

            //1.2- jrivas 21/7/2006 DBLG500001013
            if (saldoPuntosAux >= costoPremio) {
                UtilidadesLog.debug("saldoPuntosAux >= puntosLeidos ");
            
                // vbongiov -- 5/07/2006 -- inc 723
                descTipoPremio = (String) respuesta1.getValueAt(0, "DESCTIPOPREMIO");
    
                NivelPremiacion nivelPre = new NivelPremiacion();
                nivelPre.setNivel((respuesta1.getValueAt(i1, "NUM_NIVE") != null)
                    ? new Integer(
                        ((BigDecimal) respuesta1.getValueAt(i1, "NUM_NIVE"))
                            .intValue()) : null);
                nivelPre.setOidNivel((
                    respuesta1.getValueAt(i1, "OID_PARA_NIVE_PREM") != null)
                    ? new Long(((BigDecimal) 
                    respuesta1.getValueAt(i1, "OID_PARA_NIVE_PREM")).longValue())
                    : null);
                nivelPre.setCantidadFijaPuntos((respuesta1.getValueAt(i1,
                        "NUM_CANT_FIJA_PUNT") != null)
                    ? new Double(((BigDecimal) 
                    respuesta1.getValueAt(i1, "NUM_CANT_FIJA_PUNT")).doubleValue())
                    : new Double(0));
                nivelPre.setCantidadInicialPuntos((respuesta1.getValueAt(i1,
                        "NUM_CANT_INIC_PUNT") != null)
                    ? new Double(((BigDecimal) 
                    respuesta1.getValueAt(i1, "NUM_CANT_INIC_PUNT")).doubleValue())
                    : new Double(0));
                nivelPre.setCantidadFinalPuntos((respuesta1.getValueAt(i1,
                        "NUM_CANT_FINA_PUNT") != null)
                    ? new Double(((BigDecimal) 
                    respuesta1.getValueAt(i1, "NUM_CANT_FINA_PUNT")).doubleValue())
                    : new Double(0));
    
                if (respuesta1.getValueAt(i1, "PERD_OID_PERI") != null) {
                    periodoDespacho.setOidPeriodo(new Long(
                          ((BigDecimal) respuesta1.getValueAt(i1, "PERD_OID_PERI"))
                          .longValue()));
                } 
    
    
                long tipoPremioLeido = ((BigDecimal) respuesta1.getValueAt(i1,
                        "TPRE_OID_TIPO_PREM")).longValue();
                long oidNivelPremiacion = ((BigDecimal) respuesta1.getValueAt(i1,
                        "OID_PARA_NIVE_PREM")).longValue();
                BigDecimal puntosObtenerProdExigidos = (BigDecimal) 
                    respuesta1.getValueAt(i1,"NUM_PUNT_PROD_EXIG");
    
                // procesar premio monetario
                if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_MONETARIO
                    .longValue()) {
                    
                    PremioMonetario premioMonetario = new PremioMonetario();
                    premioMonetario.setNivel(nivelPre);
                    premioMonetario.setTipoPremio(new Long(tipoPremioLeido));
                    // vbongiov -- 5/07/2006 -- inc 723
                    premioMonetario.setDescripcionTipoPremio(descTipoPremio);
                    premioMonetario.setPeriodoDeDespacho(periodoDespacho);
    
                    BelcorpService bs2;
                    RecordSet respuesta2;
                    StringBuffer query2 = new StringBuffer();
    
                    try {
                        bs2 = BelcorpService.getInstance();
                    } catch (MareMiiServiceNotFoundException e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }
    
                    try {
                        query2.append(" SELECT ");
                        query2.append(" OID_PREM_MONE, ");
                        query2.append(" NUM_PREM, ");
                        query2.append(" VAL_CANT, ");
                        query2.append(" VAL_PORC, ");
                        query2.append(" IND_PAGO_PART, ");
                        query2.append(" IND_DESC_PAGO_ANTI, ");
                        query2.append(" TPMO_OID_TIPO_PREM_MONE, ");
                        query2.append(" FPAG_OID_FORM_PAGO ");
                        query2.append(" FROM INC_PREMI_MONET ");
                        query2.append(" WHERE PANP_OID_PARA_NIVE_PREM = " +
                            oidNivelPremiacion);
                        respuesta2 = bs2.dbService.executeStaticQuery(
                            query2.toString());

                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                          UtilidadesLog.debug("*** respuesta2: " + respuesta2);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
    
                    if (!respuesta2.esVacio()) {
                        long oidPremioMonetario = ((BigDecimal) 
                            respuesta2.getValueAt(i1, "OID_PREM_MONE")).longValue();
    
                        {
                            BigDecimal cantidad = (BigDecimal) 
                                respuesta2.getValueAt(i1,"VAL_CANT");
                            premioMonetario.setCantidad((cantidad != null)
                                ? cantidad : new BigDecimal(0));
                        }
    
                        {
                            BigDecimal descontar = (BigDecimal) 
                                respuesta2.getValueAt(i1, "IND_DESC_PAGO_ANTI");
    
                            if (descontar == null) {
                                premioMonetario
                                    .setDescontarPagosAnticipados(false);
                            } else {
                                if (descontar.compareTo(new BigDecimal(1)) == 0) {
                                    premioMonetario.setDescontarPagosAnticipados(
                                        true);
                                } else {
                                    premioMonetario.setDescontarPagosAnticipados(
                                        false);
                                }
                            }
                        }
    
                        premioMonetario.setNumeroPremio(new Long(
                                ((BigDecimal) respuesta2.getValueAt(i1, "NUM_PREM"))
                                    .longValue()));
                        premioMonetario.setOidFormaPago(new Long(
                                ((BigDecimal) respuesta2.getValueAt(i1,
                                    "FPAG_OID_FORM_PAGO")).longValue()));
    
                        {
                            BigDecimal pagoPartes = (BigDecimal) 
                                respuesta2.getValueAt(i1,"IND_PAGO_PART");
    
                            if (pagoPartes == null) {
                                premioMonetario.setPagoEnPartes(false);
                            } else {
                                if (pagoPartes.compareTo(new BigDecimal(1)) == 0) {
                                    premioMonetario.setPagoEnPartes(true);
                                } else {
                                    premioMonetario.setPagoEnPartes(false);
                                }
                            }
                        }
    
                        premioMonetario.setPorcentaje((BigDecimal) 
                            respuesta2.getValueAt(i1, "VAL_PORC"));
                        premioMonetario.setTipoPremioMonetario(new Long(
                                ((BigDecimal) respuesta2.getValueAt(i1,
                                    "TPMO_OID_TIPO_PREM_MONE")).longValue()));
    
                        //Si tipoPremio es premioMonetario, y el campo 
                        //pagoPartes==True,
                        //entonces tendremos que ir a la entidad PagoPartes
                        //y crear objetos PagoPartes rellenando sus atributos.
                        
                        if (premioMonetario.getPagoEnPartes()) {
                            BelcorpService bs3;
                            RecordSet respuesta3;
                            StringBuffer query3 = new StringBuffer();
    
                            try {
                                bs3 = BelcorpService.getInstance();
                            } catch (MareMiiServiceNotFoundException e) {
                                UtilidadesLog.error("ERROR ", e);
                                throw new MareException(e,
                                    UtilidadesError.armarCodigoError(
                                        CodigosError
                                            .ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                            }
    
                            try {
                                query3.append(" SELECT ");
                                query3.append(" NUM_PAGO, ");
                                query3.append(" VAL_PORC_PREM, ");
                                query3.append(" PERD_OID_PERI, ");
                                query3.append(" COD_PERI, ");
                                query3.append(" FEC_INIC, ");
                                query3.append(" FEC_FINA, ");
                                query3.append(" CANA_OID_CANA, ");
                                query3.append(" MARC_OID_MARC, ");
                                query3.append(" PAIS_OID_PAIS ");
                                query3.append(" FROM INC_PAGO_MONET PAGO, ");
                                query3.append(" CRA_PERIO CRA, ");
                                query3.append(" SEG_PERIO_CORPO SEG ");
                                query3.append(" WHERE PRMO_OID_PREM_MONE = " +
                                    oidPremioMonetario);
                                query3.append(
                                    " AND PAGO.PERD_OID_PERI = CRA.OID_PERI ");
                                query3.append(
                                    " AND CRA.PERI_OID_PERI = SEG.OID_PERI ");
                                respuesta3 = bs3.dbService.executeStaticQuery(
                                    query3.toString());
                                    
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                    
                                  UtilidadesLog.debug("*** respuesta3: " +  respuesta3);
                            } catch (Exception e) {
                                UtilidadesLog.error("ERROR ", e);
                                throw new MareException(e,
                                    UtilidadesError.armarCodigoError(
                                        CodigosError
                                            .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                            }
    
                            premioMonetario.setPagosEnPartes(new ArrayList());
    
                            for (int i3 = 0; i3 < respuesta3.getRowCount(); i3++){
                                PagoPartes pagoPartes = new PagoPartes();
                                pagoPartes.setNumeroPago(new Integer(
                                        ((BigDecimal) respuesta3.getValueAt(i3,
                                            "NUM_PAGO")).intValue()));
                                pagoPartes.setPorcentajePremio((BigDecimal) 
                                    respuesta3.getValueAt(i3, "VAL_PORC_PREM"));
    
                                Periodo periodoControl = new Periodo();
                                periodoControl.setCodperiodo((String) 
                                    respuesta3.getValueAt(i3, "COD_PERI"));
                                periodoControl.setFechaDesde((Date) 
                                    respuesta3.getValueAt(i3, "FEC_INIC"));
                                periodoControl.setFechaHasta((Date) 
                                    respuesta3.getValueAt(i3, "FEC_FINA"));
                                periodoControl.setOidCanal(new Long(((BigDecimal) 
                                        respuesta3.getValueAt(i3, "CANA_OID_CANA"))
                                        .longValue()));
                                periodoControl.setOidMarca(new Long(
                                        ((BigDecimal) respuesta3.getValueAt(i3,
                                            "MARC_OID_MARC")).longValue()));
                                periodoControl.setOidPais(new Long(
                                        ((BigDecimal) respuesta3.getValueAt(i3,
                                            "PAIS_OID_PAIS")).longValue()));
                                periodoControl.setOidPeriodo(new Long(
                                        ((BigDecimal) respuesta3.getValueAt(i3,
                                            "PERD_OID_PERI")).longValue()));
                                            
                                // Periodo                                              
                                pagoPartes.setPeriodoControl(periodoControl); 
                                premioMonetario.getPagosEnPartes().add(pagoPartes);
                            }
                        }
                    }
    
                    salida.add(premioMonetario);
                }
    
                // procesar premio articulo lote
                if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_ARTICULO
                    .longValue()) {
                    //jrivas 18/7/2006 DBLG5001010
                    BigDecimal numeroPremio = (BigDecimal) respuesta1.getValueAt(i1,"NUM_PREM");
                    
                    PremioArticuloLote premioArticuloLote = new PremioArticuloLote();
                    PremioArticulo premioArticulo = new PremioArticulo();
                    premioArticuloLote.setNivel(nivelPre);
                    premioArticuloLote.setTipoPremio(new Long(tipoPremioLeido));
                    // vbongiov -- 5/07/2006 -- inc 723
                    premioArticuloLote.setDescripcionTipoPremio(descTipoPremio);
                    premioArticuloLote.setPeriodoDeDespacho(periodoDespacho);
                    premioArticuloLote.setPuntosObtenerProdExigidos((
                        puntosObtenerProdExigidos != null)
                        ? new Double(puntosObtenerProdExigidos.doubleValue())
                        : new Double(0));
    
                    BelcorpService bs4;
                    RecordSet respuesta4;
                    StringBuffer query4 = new StringBuffer();
    
                    try {
                        bs4 = BelcorpService.getInstance();
                    } catch (MareMiiServiceNotFoundException e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }
    
                    try {
                        /* INC 001 - gPineda - 13/01/2007
                        * Se agrega la recuperacion del atributo VAL_DESC_LOTE_PREM_ARTI. (2)
                        */
                        query4.append(" SELECT ");
                        query4.append(" NUM_UNID, NUM_LOTE, ");
                        query4.append(" NUM_PREM, ");
                        query4.append(" OID_LOTE_PREM_ARTI ");
                        query4.append(" ,INC_LOTE_PREMI_ARTIC.VAL_DESC_LOTE_PREM_ARTI"); //(2)
                        query4.append(" FROM INC_PREMI_ARTIC, ");
                        query4.append(" INC_LOTE_PREMI_ARTIC ");
                        query4.append(" WHERE PRAR_OID_PREM_ARTI = OID_PREM_ARTI ");
                        query4.append(" AND PANP_OID_PARA_NIVE_PREM = " + oidNivelPremiacion);
                        //jrivas 18/7/2006 DBLG5001010
                        query4.append(" AND NUM_PREM = " + numeroPremio);
                        query4.append(" ORDER BY NUM_LOTE ");  
                        
                        respuesta4 = bs4.dbService.executeStaticQuery(
                            query4.toString());
                            
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                    
                          UtilidadesLog.debug("*** respuesta4: " + respuesta4);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
    
                    if (!respuesta4.esVacio()) {
                        premioArticuloLote.setDescripcionLote( (String) respuesta4.getValueAt(0, "VAL_DESC_LOTE_PREM_ARTI") );//(2)
                        
                        premioArticuloLote.setNumeroLote(new Long(
                                ((BigDecimal) respuesta4.getValueAt(0, "NUM_LOTE"))
                                    .longValue()));
                        premioArticuloLote.setNumeroPremio(new Long(
                                ((BigDecimal) respuesta4.getValueAt(0, "NUM_PREM"))
                                    .longValue()));
                        premioArticulo.setNumeroUnidades(new Long(
                                ((BigDecimal) respuesta4.getValueAt(0, "NUM_UNID"))
                                    .longValue()));
                        premioArticuloLote.setPremio(premioArticulo);
                        
                        
    
                        Long oidLotePremioArticulo = new Long(((BigDecimal) 
                            respuesta4.getValueAt(0, "OID_LOTE_PREM_ARTI"))
                                .longValue());
                        ArrayList articulos = new ArrayList();
    
                        BelcorpService bs7;
                        RecordSet respuesta7;
    
                        try {
                            bs7 = BelcorpService.getInstance();
                        } catch (MareMiiServiceNotFoundException e) {
                            UtilidadesLog.error("ERROR ", e);
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                        }
    
                        try {
                            //Brecha INC-003 6-9-07 jrivas
                            respuesta7 = bs7.dbService.executeStaticQuery(queryArticuloLote(oidLotePremioArticulo).toString());
                                
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                
                              UtilidadesLog.debug("*** respuesta7: " + respuesta7);
                        } catch (Exception e) {
                            UtilidadesLog.error("ERROR ", e);
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                        }
        
                        ArticuloLote articuloLote = null;
                        
                        if (!respuesta7.esVacio()) {
                        
                            int cant7 = respuesta7.getRowCount();
                            for(int i7=0; i7 < cant7; i7++) {
                                articuloLote = new ArticuloLote();
                                
                                articuloLote.setNombre((String)respuesta7.getValueAt(i7, "DESCPRODU"));
                                
                                articuloLote.setNumeroUnidades(new Long(
                                        ((BigDecimal) respuesta7.getValueAt(i7, "NUM_UNID"))
                                            .longValue()));
                                articuloLote.setCodigoVentaFicticio(respuesta7.getValueAt(
                                        i7, "COD_VENT_FICT").toString());
                                articuloLote.setOidCodigoProducto(new Long(
                                        ((BigDecimal) respuesta7.getValueAt(i7,
                                            "PROD_OID_PROD")).longValue()));
                                articuloLote.setPrecioPublico((BigDecimal) 
                                    respuesta7.getValueAt(i7, "IMP_PREC_PUBL"));
                                    
                                articuloLote.setCodSapProducto((String)	respuesta7.getValueAt(i7, "COD_SAP")); 
                                
                                articuloLote.setTipoEntregaPremio(respuesta7.getValueAt(i7, "IND_TIPO_ENTR_PREM").toString()); 
                                
                                if (respuesta7.getValueAt(i7, "COD_CENT_SERV") != null) {
                                    articuloLote.setCodigoCentroServicio((String) respuesta7.getValueAt(i7, "COD_CENT_SERV")); 
                                } else {
                                    articuloLote.setCodigoCentroServicio(""); 
                                }
                                
                                if (respuesta7.getValueAt(i7, "DES_CENT_SERV") != null) {
                                    articuloLote.setDescripcionCentroServicio((String) respuesta7.getValueAt(i7, "DES_CENT_SERV")); 
                                } else {
                                    articuloLote.setDescripcionCentroServicio(""); 
                                }         
                                
                                // vbongiov -- Cambio 20090828 -- 8/06/2009
                                articuloLote.setOidArticuloLote(new Long(((BigDecimal) respuesta7.getValueAt(i7, "OID_ARTI_LOTE")).longValue()));                                
                                
                                articulos.add(articuloLote);
                            }
                        }
                        premioArticuloLote.setArticulos(articulos);
                    }
    
                    salida.add(premioArticuloLote);
                }
    
                // procesar premio descuento
            if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_DESCUENTOS
                .longValue()) {
                UtilidadesLog.debug("tipoPremioLeido = ConstantesINC.TIPO_PREMIO_DESCUENTOS.longValue() ***");
    
                PremioDescuento premioDescuento = new PremioDescuento();
                premioDescuento.setNivel(nivelPre);
                premioDescuento.setTipoPremio(new Long(tipoPremioLeido));
                // vbongiov -- 5/07/2006 -- inc 723
                premioDescuento.setDescripcionTipoPremio(descTipoPremio);
                premioDescuento.setPeriodoDeDespacho(periodoDespacho);
    
                BelcorpService bs5;
                RecordSet respuesta5;
                RecordSet respuesta6;
                StringBuffer query5 = new StringBuffer();
                StringBuffer query6 = new StringBuffer();
    
                try {
                    bs5 = BelcorpService.getInstance();
                } catch (MareMiiServiceNotFoundException e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                }
    
                try {
                    query5.append(" SELECT OID_PREM_DESC,");
                    query5.append(" NUM_PREM, ");
                    query5.append(" VAL_CANT_DESC, ");
                    query5.append(" VAL_PORC_DESC, ");
                    query5.append(" PERD_OID_PERI_DESD, ");
                    query5.append(" PERD_OID_PERI ");
                    query5.append(" FROM INC_PREMI_DESCU ");
                    query5.append(" WHERE OID_PARA_NIVE_PREM = " +
                        oidNivelPremiacion);
                    respuesta5 = bs5.dbService.executeStaticQuery(
                        query5.toString());
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }
    
                if (!respuesta5.esVacio()) {
                
                    BigDecimal oidPremDesc = (BigDecimal) respuesta5.getValueAt(0,
                            "OID_PREM_DESC");
                    
                    BigDecimal cantidad = (BigDecimal) respuesta5.getValueAt(0,
                            "VAL_CANT_DESC");
                    premioDescuento.setCantidad((cantidad != null) ? cantidad
                        : new BigDecimal(0));
                    
    
                    premioDescuento.setNumeroPremio(new Long(
                            ((BigDecimal) respuesta5.getValueAt(0, "NUM_PREM"))
                                .longValue()));
                    premioDescuento.setOidPeriodoDesde(new Long(
                            ((BigDecimal) respuesta5.getValueAt(0,
                                "PERD_OID_PERI_DESD")).longValue()));
    
                    
                    BigDecimal periodoHasta = (BigDecimal) 
                        respuesta5.getValueAt(0,"PERD_OID_PERI");
                    premioDescuento.setOidPeriodoHasta((periodoHasta != null)
                        ? new Long(periodoHasta.longValue()) : null);
                    
    
                    premioDescuento.setPorcentaje((BigDecimal) 
                        respuesta5.getValueAt(0, "VAL_PORC_DESC"));
                        
                    ArrayList prodDesc = new ArrayList();
                        
                    // Productos del premio descuento                
                    try {
                        query6.append(" SELECT prodD.MAPR_OID_MARC_PROD,");
                        query6.append(" prodD.SGEN_OID_SUPE_GENE, prodD.GENE_OID_GENE, ");
                        query6.append(" prodD.UNEG_OID_UNID_NEGO, prodD.NEGO_OID_NEGO, ");
                        query6.append(" prodD.PROD_OID_PROD ");
                        query6.append(" FROM INC_PRODU_DESCU prodD ");
                        query6.append(" WHERE prodD.PRDE_OID_PREM_DESC = " + oidPremDesc);
                        
                        respuesta6 = bs5.dbService.executeStaticQuery(query6.toString());
                        
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
    
                    ProductoDescuento prodDescuento = null;
                    
                    if (!respuesta6.esVacio()) {
                        int cant6 = respuesta6.getRowCount();
                        
                        for(int i6=0; i6 < cant6; i6++) {
                            prodDescuento = new ProductoDescuento();
                            
                            prodDescuento.setOidMarcaProducto(new Long(((BigDecimal)respuesta6.getValueAt(i6,"MAPR_OID_MARC_PROD")).intValue()));
                            
                            BigDecimal oidSupeGen = (BigDecimal) 
                                respuesta6.getValueAt(i6,"SGEN_OID_SUPE_GENE");
                            prodDescuento.setOidSuperGenerico((oidSupeGen != null)
                                ? new Long(oidSupeGen.longValue()) : null);
                                
                            BigDecimal oidGene = (BigDecimal) 
                                respuesta6.getValueAt(i6,"GENE_OID_GENE");
                            prodDescuento.setOidGenerico((oidGene != null)
                                ? new Long(oidGene.longValue()) : null);
                            
                            BigDecimal oidUniNeg = (BigDecimal) 
                                respuesta6.getValueAt(i6,"UNEG_OID_UNID_NEGO");
                            prodDescuento.setOidUnidadNegocio((oidUniNeg != null)
                                ? new Long(oidUniNeg.longValue()) : null);
                                
                            BigDecimal oidNeg = (BigDecimal) 
                                respuesta6.getValueAt(i6,"NEGO_OID_NEGO");
                            prodDescuento.setOidNegocio((oidNeg != null)
                                ? new Long(oidNeg.longValue()) : null);
                                
                            BigDecimal oidProd = (BigDecimal) 
                                respuesta6.getValueAt(i6,"PROD_OID_PROD");
                            prodDescuento.setOidProducto((oidProd != null)
                                ? new Long(oidProd.longValue()) : null);
                                
                            prodDesc.add(prodDescuento);
                        }
                    }
                                        
                    premioDescuento.setListaProductos(prodDesc);
                        
                }
    
                    salida.add(premioDescuento);
                }
    
                // procesar premio puntaje
                if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_PUNTUACION
                    .longValue()) {
                    PremioPuntos premioPuntos = new PremioPuntos();
                    premioPuntos.setNivel(nivelPre);
                    premioPuntos.setTipoPremio(new Long(tipoPremioLeido));
                    // vbongiov -- 5/07/2006 -- inc 723
                    premioPuntos.setDescripcionTipoPremio(descTipoPremio);
                    premioPuntos.setPeriodoDeDespacho(periodoDespacho);
    
                    BelcorpService bs6;
                    RecordSet respuesta6;
                    StringBuffer query6 = new StringBuffer();
    
                    try {
                        bs6 = BelcorpService.getInstance();
                    } catch (MareMiiServiceNotFoundException e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }
    
                    try {
                        query6.append(" SELECT ");
                        query6.append(" VAL_CANT, ");
                        query6.append(" NUM_PREM, ");
                        query6.append(" COPA_OID_PARA_GRAL, ");
                        query6.append(" VAL_PORC, ");
                        query6.append(" TPPU_OID_TIPO_PREM_PUNT ");
                        query6.append(" FROM INC_PREMI_PUNTO ");
                        query6.append(" WHERE PANP_OID_PARA_NIVE_PREM = " +
                            oidNivelPremiacion);
                        respuesta6 = bs6.dbService.executeStaticQuery(
                            query6.toString());
                            
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                          UtilidadesLog.debug("*** respuesta6: " + respuesta6);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
    
                    if (!respuesta6.esVacio()) {
                        {
                            BigDecimal cantidad = (BigDecimal) 
                                respuesta6.getValueAt(0,"VAL_CANT");
                            premioPuntos.setCantidad((cantidad != null) ? cantidad
                                : new BigDecimal(0));
                        }
    
                        premioPuntos.setNumeroPremio(new Long(
                                ((BigDecimal) respuesta6.getValueAt(0, "NUM_PREM"))
                                    .longValue()));
                        premioPuntos.setOidConcursoDestino(new Long(
                                ((BigDecimal) respuesta6.getValueAt(0,
                                    "COPA_OID_PARA_GRAL")).longValue()));
                        UtilidadesLog.debug("premioPuntos.setOidConcursoDestino " +
                            premioPuntos.getOidConcursoDestino());
                        premioPuntos.setPorcentaje((BigDecimal) 
                            respuesta6.getValueAt( 0, "VAL_PORC"));
                        premioPuntos.setOidTipoPremioPuntos(new Long(
                                ((BigDecimal) respuesta6.getValueAt(0,
                                    "TPPU_OID_TIPO_PREM_PUNT")).longValue()));
                    }
                    salida.add(premioPuntos);
                }
                
                //1.3.- jrivas 21/7/2006 DBLG500001013                   
                saldoPuntosAux = saldoPuntosAux - costoPremio;
            }
        }

        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremiosEleg"
            +"idos(ClientePremiacionConcurso clientePremiacionConcurso, Client"
            +"ePremiacion clientePremiacion):Salida");

        return salida;
    }

    /**
     * Comentario: Este metodo utiliza la entidad PremiosElegidos, porfavor 
     * recordar colocar la EJB Local
     * reference a esta entidad en el MON desde donde se llame a este metodo
     *
     * @author Dante Castiglione
     */
    public ArrayList recuperarPremiosNivelesPremiacion(
        ClientePremiacionConcurso clientePremiacionConcurso,
        ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremiosNivel"
            +"esPremiacion(ClientePremiacionConcurso clientePremiacionConcurso"
            +", ClientePremiacion clientePremiacion):Entrada");

        BelcorpService bs1;
        RecordSet respuesta1;
        StringBuffer query1 = new StringBuffer();

        try {
            bs1 = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //Recuperar todos los registros de la entidad parNivel
        //ordenados por numeroNivel de mayor a menor coste en puntos
        //(para ello nos fijamos en el campo cantidadFijaPuntos,
        //si este no esta informado usaremos cantidadInicialPuntos).
        try {
            query1.append(" SELECT ");
            query1.append(" NVL(NUM_CANT_FIJA_PUNT, NUM_CANT_INIC_PUNT) AS PUNTOS, ");
            query1.append(" TPRE_OID_TIPO_PREM, ");
            query1.append(" OID_PARA_NIVE_PREM, ");
            query1.append(" INC_PARAM_NIVEL_PREMI.NUM_NIVE, ");
            query1.append(" NUM_CANT_FIJA_PUNT, ");
            query1.append(" NUM_CANT_INIC_PUNT, ");
            query1.append(" NUM_CANT_FINA_PUNT, ");
            query1.append(" NUM_PUNT_PROD_EXIG, ");
            query1.append(" PERD_OID_PERI, ");
            query1.append(" conc.MARC_OID_MARC, ");
            query1.append(" conc.CANA_OID_CANA, ");
            query1.append(" conc.PAIS_OID_PAIS, ");
            // vbongiov -- 5/07/2006 -- inc 723
            query1.append(" V.VAL_I18N descTipoPremio ");
            query1.append(" FROM INC_PARAM_GENER_PREMI, ");
            query1.append(" INC_PARAM_NIVEL_PREMI, ");
            query1.append(" INC_CONCU_PARAM_GENER conc, CRA_PERIO, ");
            query1.append(" V_GEN_I18N_SICC V ");
            query1.append(" WHERE PAGP_OID_PARA_GENE_PREM = OID_PARA_GENE_PREM ");
            query1.append(" AND COPA_OID_PARA_GRAL = " +
                clientePremiacionConcurso.getOidConcurso());
            query1.append(" AND conc.OID_PARA_GRAL = COPA_OID_PARA_GRAL ");
            query1.append(" AND conc.PERD_OID_PERI_DESD = OID_PERI ");
            query1.append(" AND V.VAL_OID = TPRE_OID_TIPO_PREM ");
            query1.append(" AND V.ATTR_NUM_ATRI = 1  ");
            query1.append(" AND V.ATTR_ENTI = 'INC_TIPO_PREMI' ");
            query1.append(" AND V.IDIO_OID_IDIO = " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
            query1.append(" ORDER BY PUNTOS DESC ");
            
            respuesta1 = bs1.dbService.executeStaticQuery(query1.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta1: " + respuesta1);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Periodo periodoDespacho = new Periodo();
        String descTipoPremio = null;

        ArrayList salida = new ArrayList();
        int saldoPuntosAux = clientePremiacionConcurso.getSaldoPuntos().intValue();
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("recuperarPremiosNivelesPremiacion  --- saldoPuntosAux " +
            saldoPuntosAux);

        for (int i1 = 0; i1 < respuesta1.getRowCount(); i1++) {
            // vbongiov -- 5/07/2006 -- inc 723
            descTipoPremio = (String) respuesta1.getValueAt(0, "DESCTIPOPREMIO");
            
            NivelPremiacion nivelPre = new NivelPremiacion();
            nivelPre.setNivel((respuesta1.getValueAt(i1, "NUM_NIVE") != null)
                ? new Integer(
                ((BigDecimal) respuesta1.getValueAt(i1, "NUM_NIVE")).intValue())
                : null);
            nivelPre.setOidNivel((
              respuesta1.getValueAt(i1, "OID_PARA_NIVE_PREM") != null)
              ? new Long(((BigDecimal) 
              respuesta1.getValueAt(i1, "OID_PARA_NIVE_PREM")).longValue())
              : null);
            nivelPre.setCantidadFijaPuntos((respuesta1.getValueAt(i1,
                "NUM_CANT_FIJA_PUNT") != null)
                ? new Double(((BigDecimal) 
                respuesta1.getValueAt(i1, "NUM_CANT_FIJA_PUNT")).doubleValue())
                : new Double(0));
            nivelPre.setCantidadInicialPuntos((respuesta1.getValueAt(i1,
                "NUM_CANT_INIC_PUNT") != null)
                ? new Double(((BigDecimal) 
                respuesta1.getValueAt(i1, "NUM_CANT_INIC_PUNT")).doubleValue())
                : new Double(0));
            nivelPre.setCantidadFinalPuntos((respuesta1.getValueAt(i1,
                "NUM_CANT_FINA_PUNT") != null)
                ? new Double(((BigDecimal) 
                respuesta1.getValueAt(i1, "NUM_CANT_FINA_PUNT")).doubleValue())
                : new Double(0));

            if (respuesta1.getValueAt(i1, "PERD_OID_PERI") != null) {
                periodoDespacho.setOidPeriodo(new Long(((BigDecimal) 
                    respuesta1.getValueAt(i1, "PERD_OID_PERI")).longValue()));
            }

            int puntosLeidos = ((respuesta1.getValueAt(i1, "PUNTOS") != null)
                ? ((BigDecimal) respuesta1.getValueAt(i1, "PUNTOS")).intValue()
                : 0);
                
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                
              UtilidadesLog.debug(
                "recuperarPremiosNivelesPremiacion  --- puntosLeidos " +
                puntosLeidos);
              UtilidadesLog.debug("recuperarPremiosNivelesPremiacion "
              + "saldoPuntosAux >= puntosLeidos " 
                +(saldoPuntosAux >= puntosLeidos));
            }    

            if (saldoPuntosAux >= puntosLeidos) {
                UtilidadesLog.debug("saldoPuntosAux >= puntosLeidos ");

                long tipoPremioLeido = ((BigDecimal) respuesta1.getValueAt(i1,
                        "TPRE_OID_TIPO_PREM")).longValue();
                long oidNivelPremiacion = ((BigDecimal) 
                    respuesta1.getValueAt(i1,"OID_PARA_NIVE_PREM"))
                        .longValue();
                BigDecimal puntosObtenerProdExigidos = (BigDecimal) 
                    respuesta1.getValueAt(i1,"NUM_PUNT_PROD_EXIG");
                    
                Long numPremio = null;

                // procesar premio monetario
                if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_MONETARIO
                    .longValue()) {
                    UtilidadesLog.debug("Premio Monetario");

                    PremioMonetario premioMonetario = new PremioMonetario();
                    premioMonetario.setNivel(nivelPre);
                    premioMonetario.setTipoPremio(new Long(tipoPremioLeido));
                    // vbongiov -- 5/07/2006 -- inc 723
                    premioMonetario.setDescripcionTipoPremio(descTipoPremio);
                    premioMonetario.setPeriodoDeDespacho(periodoDespacho);

                    BelcorpService bs2;
                    RecordSet respuesta2;
                    StringBuffer query2 = new StringBuffer();

                    try {
                        bs2 = BelcorpService.getInstance();
                    } catch (MareMiiServiceNotFoundException e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }

                    try {
                        query2.append(" SELECT ");
                        query2.append(" OID_PREM_MONE, ");
                        query2.append(" NUM_PREM, ");
                        query2.append(" VAL_CANT, ");
                        query2.append(" VAL_PORC, ");
                        query2.append(" IND_PAGO_PART, ");
                        query2.append(" IND_DESC_PAGO_ANTI, ");
                        query2.append(" TPMO_OID_TIPO_PREM_MONE, ");
                        query2.append(" FPAG_OID_FORM_PAGO ");
                        query2.append(" FROM INC_PREMI_MONET ");
                        query2.append(" WHERE PANP_OID_PARA_NIVE_PREM = " +
                            oidNivelPremiacion);
                        respuesta2 = bs2.dbService.executeStaticQuery(
                            query2.toString());
                            
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                          UtilidadesLog.debug("*** respuesta2: " + respuesta2);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError
                                    .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }

                    if (!respuesta2.esVacio()) {
                        UtilidadesLog.debug("Encontre premio monetario");

                        long oidPremioMonetario = ((BigDecimal)
                            respuesta2.getValueAt(0,"OID_PREM_MONE"))
                                .longValue();

                        {
                            BigDecimal cantidad = (BigDecimal) 
                                respuesta2.getValueAt(0,"VAL_CANT");
                            premioMonetario.setCantidad((cantidad != null)
                                ? cantidad : new BigDecimal(0));
                        }

                        {
                            BigDecimal descontar = (BigDecimal) 
                                respuesta2.getValueAt(0,"IND_DESC_PAGO_ANTI");

                            if (descontar == null) {
                                premioMonetario
                                    .setDescontarPagosAnticipados(false);
                            } else {
                                if (descontar.compareTo(new BigDecimal(1)) == 0) {
                                    premioMonetario
                                        .setDescontarPagosAnticipados(true);
                                } else {
                                    premioMonetario
                                        .setDescontarPagosAnticipados(false);
                                }
                            }
                        }

                        premioMonetario.setNumeroPremio(new Long(
                                ((BigDecimal) respuesta2.getValueAt(0,
                                    "NUM_PREM")).longValue()));

                        //jrivas 26/7/2005
                        numPremio = premioMonetario.getNumeroPremio();

                        premioMonetario.setOidFormaPago(new Long(
                                ((BigDecimal) respuesta2.getValueAt(0,
                                    "FPAG_OID_FORM_PAGO")).longValue()));

                        {
                            BigDecimal pagoPartes = (BigDecimal) 
                                respuesta2.getValueAt(0,"IND_PAGO_PART");

                            if (pagoPartes == null) {
                                premioMonetario.setPagoEnPartes(false);
                            } else {
                                if (pagoPartes.compareTo(new BigDecimal(1)) 
                                    == 0) {
                                    premioMonetario.setPagoEnPartes(true);
                                } else {
                                    premioMonetario.setPagoEnPartes(false);
                                }
                            }
                        }

                        premioMonetario.setPorcentaje((BigDecimal) 
                            respuesta2.getValueAt(0, "VAL_PORC"));
                        premioMonetario.setTipoPremioMonetario(new Long(
                                ((BigDecimal) respuesta2.getValueAt(0,
                                    "TPMO_OID_TIPO_PREM_MONE")).longValue()));

                        //Si tipoPremio es premioMonetario, y el campo 
                        //pagoPartes==True,
                        //entonces tendremos que ir a la entidad PagoPartes
                        //y crear objetos PagoPartes rellenando sus atributos.
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("premioMonetario.getPagoEnPartes() " +
                            premioMonetario.getPagoEnPartes());

                        if (premioMonetario.getPagoEnPartes()) {
                            BelcorpService bs3;
                            RecordSet respuesta3;
                            StringBuffer query3 = new StringBuffer();

                            try {
                                bs3 = BelcorpService.getInstance();
                            } catch (MareMiiServiceNotFoundException e) {
                                UtilidadesLog.error("ERROR ", e);
                                throw new MareException(e,
                                    UtilidadesError.armarCodigoError(
                                        CodigosError
                                            .ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                            }

                            try {
                                query3.append(" SELECT ");
                                query3.append(" NUM_PAGO, ");
                                query3.append(" VAL_PORC_PREM, ");
                                query3.append(" PERD_OID_PERI, ");
                                query3.append(" COD_PERI, ");
                                query3.append(" FEC_INIC, ");
                                query3.append(" FEC_FINA, ");
                                query3.append(" CANA_OID_CANA, ");
                                query3.append(" MARC_OID_MARC, ");
                                query3.append(" PAIS_OID_PAIS ");
                                query3.append(" FROM INC_PAGO_MONET PAGO, ");
                                query3.append(" CRA_PERIO CRA, ");
                                query3.append(" SEG_PERIO_CORPO SEG ");
                                query3.append(" WHERE PRMO_OID_PREM_MONE = " +
                                    oidPremioMonetario);
                                query3.append(
                                    " AND PAGO.PERD_OID_PERI = CRA.OID_PERI ");
                                query3.append(
                                    " AND CRA.PERI_OID_PERI = SEG.OID_PERI ");
                                respuesta3 = bs3.dbService.executeStaticQuery(
                                    query3.toString());
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                    
                                  UtilidadesLog.debug("*** respuesta3: " + respuesta3);
                            } catch (Exception e) {
                                UtilidadesLog.error("ERROR ", e);
                                throw new MareException(e,
                                    UtilidadesError.armarCodigoError(
                                        CodigosError
                                        .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                            }

                            premioMonetario.setPagosEnPartes(new ArrayList());

                            for (int i3 = 0; i3 < respuesta3.getRowCount();
                                    i3++) {
                                PagoPartes pagoPartes = new PagoPartes();
                                pagoPartes.setNumeroPago(new Integer(
                                        ((BigDecimal) respuesta3.getValueAt(
                                            i3, "NUM_PAGO")).intValue()));
                                pagoPartes.setPorcentajePremio((BigDecimal)
                                  respuesta3.getValueAt(i3, "VAL_PORC_PREM"));

                                Periodo periodoControl = new Periodo();
                                periodoControl.setCodperiodo((String)
                                    respuesta3.getValueAt(i3, "COD_PERI"));
                                periodoControl.setFechaDesde((Date) 
                                    respuesta3.getValueAt(i3, "FEC_INIC"));
                                periodoControl.setFechaHasta((Date) 
                                    respuesta3.getValueAt(i3, "FEC_FINA"));
                                periodoControl.setOidCanal(new Long(
                                        ((BigDecimal) respuesta3.getValueAt(
                                          i3, "CANA_OID_CANA")).longValue()));
                                periodoControl.setOidMarca(new Long(
                                        ((BigDecimal) respuesta3.getValueAt(
                                          i3, "MARC_OID_MARC")).longValue()));
                                periodoControl.setOidPais(new Long(
                                        ((BigDecimal) respuesta3.getValueAt(
                                          i3, "PAIS_OID_PAIS")).longValue()));
                                periodoControl.setOidPeriodo(new Long(
                                        ((BigDecimal) respuesta3.getValueAt(
                                          i3, "PERD_OID_PERI")).longValue()));
                                           
                                // Periodo           
                                pagoPartes.setPeriodoControl(periodoControl); 
                                premioMonetario.getPagosEnPartes()
                                    .add(pagoPartes);
                            }
                        }
                    }

                    UtilidadesLog.debug("guarde.... premio monet");
                    salida.add(premioMonetario);
                }

                // procesar premio articulo lote
                if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_ARTICULO
                    .longValue()) {
                    UtilidadesLog.debug("Premio Articulo");

                    PremioArticuloLote premioArticuloLote = 
                        new PremioArticuloLote();
                    PremioArticulo premioArticulo = new PremioArticulo();
                    premioArticuloLote.setNivel(nivelPre);
                    premioArticuloLote.setTipoPremio(new Long(tipoPremioLeido));
                    // vbongiov -- 5/07/2006 -- inc 723
                    premioArticuloLote.setDescripcionTipoPremio(descTipoPremio);
                    premioArticuloLote.setPeriodoDeDespacho(periodoDespacho);
                    premioArticuloLote.setPuntosObtenerProdExigidos((
                        puntosObtenerProdExigidos != null)
                        ? new Double(puntosObtenerProdExigidos.doubleValue())
                        : new Double(0));

                    BelcorpService bs4;
                    RecordSet respuesta4;
                    StringBuffer query4 = new StringBuffer();

                    try {
                        bs4 = BelcorpService.getInstance();
                    } catch (MareMiiServiceNotFoundException e) {
                        UtilidadesLog.error("ERROR ", e);

                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }

                    try {
                        /* INC 001 - gPineda - 13/01/2007
                        * Se agrega la recuperacion del atributo VAL_DESC_LOTE_PREM_ARTI. (2)
                        */
                        query4.append(" SELECT ");
                        query4.append(" NUM_UNID, NUM_LOTE, ");
                        query4.append(" NUM_PREM, ");
                        query4.append(" OID_LOTE_PREM_ARTI ");
                        query4.append(" ,INC_LOTE_PREMI_ARTIC.VAL_DESC_LOTE_PREM_ARTI"); //(2)
                        query4.append(" FROM INC_PREMI_ARTIC, ");
                        query4.append(" INC_LOTE_PREMI_ARTIC ");
                        query4.append(
                            " WHERE PRAR_OID_PREM_ARTI = OID_PREM_ARTI ");
                        query4.append(" AND PANP_OID_PARA_NIVE_PREM = " + oidNivelPremiacion);
                        query4.append(" ORDER BY NUM_LOTE ");  
                        
                        respuesta4 = bs4.dbService.executeStaticQuery(
                            query4.toString());
                            
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                          UtilidadesLog.debug("*** respuesta4: " + respuesta4);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError
                                    .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }

                    if (!respuesta4.esVacio()) {
                        premioArticuloLote.setDescripcionLote( (String) respuesta4.getValueAt(0, "VAL_DESC_LOTE_PREM_ARTI") );//(2)
                    
                        premioArticuloLote.setNumeroLote(new Long(
                                ((BigDecimal) respuesta4.getValueAt(0,
                                    "NUM_LOTE")).longValue()));
                        premioArticuloLote.setNumeroPremio(new Long(
                                ((BigDecimal) respuesta4.getValueAt(0,
                                    "NUM_PREM")).longValue()));

                        //jrivas 26/7/2005
                        numPremio = premioArticuloLote.getNumeroPremio();

                        premioArticulo.setNumeroUnidades(new Long(
                                ((BigDecimal) respuesta4.getValueAt(0,
                                    "NUM_UNID")).longValue()));
                        premioArticuloLote.setPremio(premioArticulo);

                        Long oidLotePremioArticulo = new Long(((BigDecimal) 
                            respuesta4.getValueAt(0, "OID_LOTE_PREM_ARTI"))
                                .longValue());
                        ArrayList articulos = new ArrayList();

                        BelcorpService bs7;
                        RecordSet respuesta7;

                        try {
                            bs7 = BelcorpService.getInstance();
                        } catch (MareMiiServiceNotFoundException e) {
                            UtilidadesLog.error("ERROR ", e);
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                        }

                        try {
                            //Brecha INC-003 6-9-07 jrivas
                            respuesta7 = bs7.dbService.executeStaticQuery(queryArticuloLote(oidLotePremioArticulo).toString());
                                
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                
                              UtilidadesLog.debug("*** respuesta7: " + respuesta7);
                        } catch (Exception e) {
                            UtilidadesLog.error("ERROR ", e);
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                        }
        
                        ArticuloLote articuloLote = null;
                        
                        if (!respuesta7.esVacio()) {
                        
                            int cant7 = respuesta7.getRowCount();
                            for(int i7=0; i7 < cant7; i7++) {
                                articuloLote = new ArticuloLote();
                                
                                articuloLote.setNombre((String)respuesta7.getValueAt(i7, "DESCPRODU"));
                                
                                articuloLote.setNumeroUnidades(new Long(
                                        ((BigDecimal) respuesta7.getValueAt(i7, "NUM_UNID"))
                                            .longValue()));
                                articuloLote.setCodigoVentaFicticio(respuesta7.getValueAt(
                                        i7, "COD_VENT_FICT").toString());
                                articuloLote.setOidCodigoProducto(new Long(
                                        ((BigDecimal) respuesta7.getValueAt(i7,
                                            "PROD_OID_PROD")).longValue()));
                                articuloLote.setPrecioPublico((BigDecimal) 
                                    respuesta7.getValueAt(i7, "IMP_PREC_PUBL"));
                                    
                                articuloLote.setCodSapProducto((String)	respuesta7.getValueAt(i7, "COD_SAP")); 
                                
                                articuloLote.setTipoEntregaPremio(respuesta7.getValueAt(i7, "IND_TIPO_ENTR_PREM").toString()); 
                                if (respuesta7.getValueAt(i7, "COD_CENT_SERV") != null) {
                                    articuloLote.setCodigoCentroServicio((String) respuesta7.getValueAt(i7, "COD_CENT_SERV")); 
                                } else {
                                    articuloLote.setCodigoCentroServicio(""); 
                                }
                                
                                if (respuesta7.getValueAt(i7, "DES_CENT_SERV") != null) {
                                    articuloLote.setDescripcionCentroServicio((String) respuesta7.getValueAt(i7, "DES_CENT_SERV")); 
                                } else {
                                    articuloLote.setDescripcionCentroServicio(""); 
                                }            
                                
                                // vbongiov -- Cambio 20090828 -- 8/06/2009
                                articuloLote.setOidArticuloLote(new Long(((BigDecimal) respuesta7.getValueAt(i7, "OID_ARTI_LOTE")).longValue()));                                
                                
                                articulos.add(articuloLote);
                            }
                        }
                        premioArticuloLote.setArticulos(articulos);
                    }
                    salida.add(premioArticuloLote);
                }

                // procesar premio descuento
        if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_DESCUENTOS
            .longValue()) {
            UtilidadesLog.debug("tipoPremioLeido = ConstantesINC.TIPO_PREMIO_DESCUENTOS.longValue() ***");

            PremioDescuento premioDescuento = new PremioDescuento();
            premioDescuento.setNivel(nivelPre);
            premioDescuento.setTipoPremio(new Long(tipoPremioLeido));
            // vbongiov -- 5/07/2006 -- inc 723
            premioDescuento.setDescripcionTipoPremio(descTipoPremio);
            premioDescuento.setPeriodoDeDespacho(periodoDespacho);

            BelcorpService bs5;
            RecordSet respuesta5;
            RecordSet respuesta6;
            StringBuffer query5 = new StringBuffer();
            StringBuffer query6 = new StringBuffer();

            try {
                bs5 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            try {
                query5.append(" SELECT OID_PREM_DESC,");
                query5.append(" NUM_PREM, ");
                query5.append(" VAL_CANT_DESC, ");
                query5.append(" VAL_PORC_DESC, ");
                query5.append(" PERD_OID_PERI_DESD, ");
                query5.append(" PERD_OID_PERI ");
                query5.append(" FROM INC_PREMI_DESCU ");
                query5.append(" WHERE OID_PARA_NIVE_PREM = " +
                    oidNivelPremiacion);
                respuesta5 = bs5.dbService.executeStaticQuery(
                    query5.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!respuesta5.esVacio()) {
            
                BigDecimal oidPremDesc = (BigDecimal) respuesta5.getValueAt(0,
                        "OID_PREM_DESC");
                
                BigDecimal cantidad = (BigDecimal) respuesta5.getValueAt(0,
                        "VAL_CANT_DESC");
                premioDescuento.setCantidad((cantidad != null) ? cantidad
                    : new BigDecimal(0));
                

                premioDescuento.setNumeroPremio(new Long(
                        ((BigDecimal) respuesta5.getValueAt(0, "NUM_PREM"))
                            .longValue()));
                premioDescuento.setOidPeriodoDesde(new Long(
                        ((BigDecimal) respuesta5.getValueAt(0,
                            "PERD_OID_PERI_DESD")).longValue()));

                
                BigDecimal periodoHasta = (BigDecimal) 
                    respuesta5.getValueAt(0,"PERD_OID_PERI");
                premioDescuento.setOidPeriodoHasta((periodoHasta != null)
                    ? new Long(periodoHasta.longValue()) : null);
                

                premioDescuento.setPorcentaje((BigDecimal) 
                    respuesta5.getValueAt(0, "VAL_PORC_DESC"));
                    
                ArrayList prodDesc = new ArrayList();
                    
                // Productos del premio descuento                
                try {
                    query6.append(" SELECT prodD.MAPR_OID_MARC_PROD,");
                    query6.append(" prodD.SGEN_OID_SUPE_GENE, prodD.GENE_OID_GENE, ");
                    query6.append(" prodD.UNEG_OID_UNID_NEGO, prodD.NEGO_OID_NEGO, ");
                    query6.append(" prodD.PROD_OID_PROD ");
                    query6.append(" FROM INC_PRODU_DESCU prodD ");
                    query6.append(" WHERE prodD.PRDE_OID_PREM_DESC = " + oidPremDesc);
                    
                    respuesta6 = bs5.dbService.executeStaticQuery(query6.toString());
                    
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }

                ProductoDescuento prodDescuento = null;
                
                if (!respuesta6.esVacio()) {
                    int cant6 = respuesta6.getRowCount();
                    
                    for(int i6=0; i6 < cant6; i6++) {
                        prodDescuento = new ProductoDescuento();
                        
                        prodDescuento.setOidMarcaProducto(new Long(((BigDecimal)respuesta6.getValueAt(i6,"MAPR_OID_MARC_PROD")).intValue()));
                        
                        BigDecimal oidSupeGen = (BigDecimal) 
                            respuesta6.getValueAt(i6,"SGEN_OID_SUPE_GENE");
                        prodDescuento.setOidSuperGenerico((oidSupeGen != null)
                            ? new Long(oidSupeGen.longValue()) : null);
                            
                        BigDecimal oidGene = (BigDecimal) 
                            respuesta6.getValueAt(i6,"GENE_OID_GENE");
                        prodDescuento.setOidGenerico((oidGene != null)
                            ? new Long(oidGene.longValue()) : null);
                        
                        BigDecimal oidUniNeg = (BigDecimal) 
                            respuesta6.getValueAt(i6,"UNEG_OID_UNID_NEGO");
                        prodDescuento.setOidUnidadNegocio((oidUniNeg != null)
                            ? new Long(oidUniNeg.longValue()) : null);
                            
                        BigDecimal oidNeg = (BigDecimal) 
                            respuesta6.getValueAt(i6,"NEGO_OID_NEGO");
                        prodDescuento.setOidNegocio((oidNeg != null)
                            ? new Long(oidNeg.longValue()) : null);
                            
                        BigDecimal oidProd = (BigDecimal) 
                            respuesta6.getValueAt(i6,"PROD_OID_PROD");
                        prodDescuento.setOidProducto((oidProd != null)
                            ? new Long(oidProd.longValue()) : null);
                            
                        prodDesc.add(prodDescuento);
                    }
                }
                                    
                premioDescuento.setListaProductos(prodDesc);
                    
            }

                    salida.add(premioDescuento);
                }

                // procesar premio puntaje
                if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_PUNTUACION
                    .longValue()) {
                    UtilidadesLog.debug("Premio premioPuntos");

                    PremioPuntos premioPuntos = new PremioPuntos();
                    premioPuntos.setNivel(nivelPre);
                    premioPuntos.setTipoPremio(new Long(tipoPremioLeido));
                    // vbongiov -- 5/07/2006 -- inc 723
                    premioPuntos.setDescripcionTipoPremio(descTipoPremio);
                    premioPuntos.setPeriodoDeDespacho(periodoDespacho);

                    BelcorpService bs6;
                    RecordSet respuesta6;
                    StringBuffer query6 = new StringBuffer();

                    try {
                        bs6 = BelcorpService.getInstance();
                    } catch (MareMiiServiceNotFoundException e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }

                    try {
                        query6.append(" SELECT ");
                        query6.append(" VAL_CANT, ");
                        query6.append(" NUM_PREM, ");
                        query6.append(" COPA_OID_PARA_GRAL, ");
                        query6.append(" VAL_PORC, ");
                        query6.append(" TPPU_OID_TIPO_PREM_PUNT ");
                        query6.append(" FROM INC_PREMI_PUNTO ");
                        query6.append(" WHERE PANP_OID_PARA_NIVE_PREM = " +
                            oidNivelPremiacion);
                        respuesta6 = bs6.dbService.executeStaticQuery(
                            query6.toString());
                            
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                          UtilidadesLog.debug("*** respuesta6: " + respuesta6);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError
                                    .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }

                    if (!respuesta6.esVacio()) {
                        {
                            BigDecimal cantidad = (BigDecimal)
                                respuesta6.getValueAt(0,"VAL_CANT");
                            premioPuntos.setCantidad((cantidad != null)
                                ? cantidad : new BigDecimal(0));
                        }

                        premioPuntos.setNumeroPremio(new Long(
                                ((BigDecimal) respuesta6.getValueAt(0,
                                    "NUM_PREM")).longValue()));

                        //jrivas 26/7/2005
                        numPremio = premioPuntos.getNumeroPremio();

                        premioPuntos.setOidConcursoDestino(new Long(
                                ((BigDecimal) respuesta6.getValueAt(0,
                                    "COPA_OID_PARA_GRAL")).longValue()));
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                    
                          UtilidadesLog.debug("premioPuntos.setOidConcursoDestino " +
                            premioPuntos.getOidConcursoDestino());
                        premioPuntos.setPorcentaje((BigDecimal) 
                            respuesta6.getValueAt(0, "VAL_PORC"));
                        premioPuntos.setOidTipoPremioPuntos(new Long(
                                ((BigDecimal) respuesta6.getValueAt(0,
                                    "TPPU_OID_TIPO_PREM_PUNT")).longValue()));
                    }

                    salida.add(premioPuntos);
                }

                PremiosElegidosLocalHome premiosElegidosHome = this.getPremiosElegidosLocalHome();

                try {
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("insertando PremiosElegidosLocal");
                      UtilidadesLog.debug("numPremio : " + numPremio);
                      UtilidadesLog.debug("clientePremiacion.getOidCliente(): "+clientePremiacion.getOidCliente());
                      UtilidadesLog.debug("clientePremiacionConcurso.getOidConcurso() : " +clientePremiacionConcurso.getOidConcurso());
                      UtilidadesLog.debug("oidNivelPremiacion : " +oidNivelPremiacion);
                    }  

                    premiosElegidosHome.create(new Integer(numPremio
                        .intValue()), clientePremiacion.getOidCliente(),
                        clientePremiacionConcurso.getOidConcurso(),
                        new Long(oidNivelPremiacion),
                        new Date(System.currentTimeMillis()));

                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                saldoPuntosAux = saldoPuntosAux - puntosLeidos;
            }
        }

        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremiosNivel"
            +"esPremiacion(ClientePremiacionConcurso clientePremiacionConcurso,"
            +"ClientePremiacion clientePremiacion):Salida");

        return salida;
    }

    /**
     * @author Dante Castiglione
     * Modificado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
     */
    public Premio recuperarPremioPorNivel(Long oid, BigDecimal numeroPremio) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremioPorNivel:Entrada");

        BelcorpService bs1;
        RecordSet respuesta1;
        StringBuffer query1 = new StringBuffer();

        try {
            bs1 = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query1.append(" SELECT ");
            query1.append(" inc_param_nivel_premi.NUM_NIVE, ");
            query1.append(" OID_PARA_NIVE_PREM, ");
            query1.append(" NUM_CANT_FIJA_PUNT, ");
            query1.append(" NUM_CANT_INIC_PUNT, ");
            query1.append(" NUM_CANT_FINA_PUNT, ");
            query1.append(" TPRE_OID_TIPO_PREM, ");
            query1.append(" PERD_OID_PERI, ");
            query1.append(" NUM_PUNT_PROD_EXIG, ");
            query1.append(" cp.MARC_OID_MARC, ");
            query1.append(" cp.CANA_OID_CANA, ");
            query1.append(" cp.PAIS_OID_PAIS, ");
            // vbongiov -- 5/07/2006 -- inc 723
            query1.append(" V.VAL_I18N descTipoPremio ");
            
            // sapaza -- PER-SiCC-2014-0192 -- 06/03/2014
            query1.append(" ,NVL(VAL_NIVE_SELE,0) VAL_NIVE_SELE ");  
            
            query1.append(" FROM INC_PARAM_NIVEL_PREMI, ");
            query1.append(" INC_PARAM_GENER_PREMI, ");
            query1.append(" INC_CONCU_PARAM_GENER conc, CRA_PERIO cp, ");
            query1.append(" V_GEN_I18N_SICC V ");
            query1.append(" WHERE OID_PARA_NIVE_PREM = " + oid);
            query1.append(" AND PAGP_OID_PARA_GENE_PREM = ");
            query1.append(" OID_PARA_GENE_PREM ");
            query1.append(" AND conc.PERD_OID_PERI_DESD = OID_PERI ");
            query1.append(" AND conc.OID_PARA_GRAL = COPA_OID_PARA_GRAL ");
            query1.append(" AND V.VAL_OID = TPRE_OID_TIPO_PREM ");
            query1.append(" AND V.ATTR_NUM_ATRI = 1  ");
            query1.append(" AND V.ATTR_ENTI = 'INC_TIPO_PREMI' ");
            query1.append(" AND V.IDIO_OID_IDIO = " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());

            respuesta1 = bs1.dbService.executeStaticQuery(query1.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta1: " + respuesta1);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        long tipoPremioLeido = ((BigDecimal) respuesta1.getValueAt(0,
                "TPRE_OID_TIPO_PREM")).longValue();
        long oidNivelPremiacion = ((BigDecimal) respuesta1.getValueAt(0,
                "OID_PARA_NIVE_PREM")).longValue();
        BigDecimal puntosObtenerProdExigidos = (BigDecimal) 
            respuesta1.getValueAt(0,"NUM_PUNT_PROD_EXIG");
            
        // vbongiov -- 5/07/2006 -- inc 723
        String descTipoPremio = (String) respuesta1.getValueAt(0, "DESCTIPOPREMIO");

        NivelPremiacion nivelPre = new NivelPremiacion();
        Periodo periodoDespacho = new Periodo();

        if (!respuesta1.esVacio()) {
        
            nivelPre.setNivel((respuesta1.getValueAt(0, "NUM_NIVE") != null)
                ? new Integer(
                    ((BigDecimal) respuesta1.getValueAt(0, "NUM_NIVE"))
                        .intValue()): null);
                        
            nivelPre.setOidNivel((
                respuesta1.getValueAt(0, "OID_PARA_NIVE_PREM") != null)
                ? new Long(((BigDecimal) 
                    respuesta1.getValueAt(0, "OID_PARA_NIVE_PREM"))
                        .longValue()): null);
                        
            nivelPre.setCantidadFijaPuntos((respuesta1.getValueAt(0,
                "NUM_CANT_FIJA_PUNT") != null)? new Double(((BigDecimal) 
                    respuesta1.getValueAt(0, "NUM_CANT_FIJA_PUNT"))
                        .doubleValue()): new Double(0));
                        
            nivelPre.setCantidadInicialPuntos((respuesta1.getValueAt(0,
                "NUM_CANT_INIC_PUNT") != null)? new Double(((BigDecimal) 
                    respuesta1.getValueAt(0, "NUM_CANT_INIC_PUNT"))
                        .doubleValue()): new Double(0));
            nivelPre.setCantidadFinalPuntos((respuesta1.getValueAt(0,
                 "NUM_CANT_FINA_PUNT") != null)? new Double(((BigDecimal) 
                    respuesta1.getValueAt(0, "NUM_CANT_FINA_PUNT"))
                        .doubleValue()): new Double(0));

            if (respuesta1.getValueAt(0, "PERD_OID_PERI") != null) {
                periodoDespacho.setOidPeriodo(new Long(
                    ((BigDecimal) respuesta1.getValueAt(0, "PERD_OID_PERI"))
                        .longValue()));
            } 
            
            // sapaza -- PER-SiCC-2014-0192 -- 06/03/2014
            int nivelElectivo = new Integer(((BigDecimal) respuesta1.getValueAt(0,
                                                "VAL_NIVE_SELE")).intValue());
            if(nivelElectivo == 1)                                  
                nivelPre.setNivelSelectivo(true);
            else
                nivelPre.setNivelSelectivo(false);
        }

        // procesar premio monetario
        if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_MONETARIO
            .longValue()){
            UtilidadesLog.debug(" tipoPremioLeido = ConstantesINC.TIPO_PREMIO"
                +"MONETARIO.longValue() ***");
                
            PremioMonetario premioMonetario = new PremioMonetario();
            premioMonetario.setNivel(nivelPre);
            premioMonetario.setTipoPremio(new Long(tipoPremioLeido));
            // vbongiov -- 5/07/2006 -- inc 723
            premioMonetario.setDescripcionTipoPremio(descTipoPremio);
            premioMonetario.setPeriodoDeDespacho(periodoDespacho);

            BelcorpService bs2;
            RecordSet respuesta2;
            StringBuffer query2 = new StringBuffer();

            try {
                bs2 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);

                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            try {
                query2.append(" SELECT ");
                query2.append(" OID_PREM_MONE, ");
                query2.append(" NUM_PREM, ");
                query2.append(" VAL_CANT, ");
                query2.append(" VAL_PORC, ");
                query2.append(" IND_PAGO_PART, ");
                query2.append(" IND_DESC_PAGO_ANTI, ");
                query2.append(" TPMO_OID_TIPO_PREM_MONE, ");
                query2.append(" FPAG_OID_FORM_PAGO ");
                query2.append(" FROM INC_PREMI_MONET ");
                query2.append(" WHERE PANP_OID_PARA_NIVE_PREM = " +
                    oidNivelPremiacion);
                respuesta2 = bs2.dbService.executeStaticQuery(
                    query2.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);

                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!respuesta2.esVacio()) {
                long oidPremioMonetario = ((BigDecimal) 
                    respuesta2.getValueAt(0,"OID_PREM_MONE")).longValue();

                BigDecimal cantidad = (BigDecimal) respuesta2.getValueAt(0,
                        "VAL_CANT");
                premioMonetario.setCantidad((cantidad != null) ? cantidad
                    : new BigDecimal(0));

                UtilidadesLog.debug("premioMonetario.setCantidad() " +
                    premioMonetario.getCantidad());

                BigDecimal descontar = (BigDecimal) respuesta2.getValueAt(0,
                        "IND_DESC_PAGO_ANTI");

                if (descontar == null) {
                    premioMonetario.setDescontarPagosAnticipados(false);
                } else {
                    if (descontar.compareTo(new BigDecimal(1)) == 0) {
                        premioMonetario.setDescontarPagosAnticipados(true);
                    } else {
                        premioMonetario.setDescontarPagosAnticipados(false);
                    }
                }

                premioMonetario.setNumeroPremio(new Long(
                        ((BigDecimal) respuesta2.getValueAt(0, "NUM_PREM"))
                            .longValue()));
                premioMonetario.setOidFormaPago(new Long(
                        ((BigDecimal) respuesta2.getValueAt(0,
                            "FPAG_OID_FORM_PAGO")).longValue()));

                {
                    BigDecimal pagoPartes = (BigDecimal) 
                        respuesta2.getValueAt(0,"IND_PAGO_PART");

                    if (pagoPartes == null) {
                        premioMonetario.setPagoEnPartes(false);
                    } else {
                        if (pagoPartes.compareTo(new BigDecimal(1)) == 0) {
                            premioMonetario.setPagoEnPartes(true);
                        } else {
                            premioMonetario.setPagoEnPartes(false);
                        }
                    }
                }

                premioMonetario.setPorcentaje((BigDecimal) 
                    respuesta2.getValueAt(0, "VAL_PORC"));
                premioMonetario.setTipoPremioMonetario(new Long(
                        ((BigDecimal) respuesta2.getValueAt(0,
                            "TPMO_OID_TIPO_PREM_MONE")).longValue()));

                //Si tipoPremio es premioMonetario, y el campo pagoPartes==
                //True,
                //entonces tendremos que ir a la entidad PagoPartes
                //y crear objetos PagoPartes rellenando sus atributos.
                if (premioMonetario.getPagoEnPartes()) {
                    UtilidadesLog.debug(
                        "*** premioMonetario.getPagoEnPartes() true");

                    BelcorpService bs3;
                    RecordSet respuesta3;
                    StringBuffer query3 = new StringBuffer();

                    try {
                        bs3 = BelcorpService.getInstance();
                    } catch (MareMiiServiceNotFoundException e) {
                        UtilidadesLog.error("ERROR ", e);

                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                    }

                    try {
                        query3.append(" SELECT ");
                        query3.append(" NUM_PAGO, ");
                        query3.append(" VAL_PORC_PREM, ");
                        query3.append(" PERD_OID_PERI, ");
                        query3.append(" COD_PERI, ");
                        query3.append(" FEC_INIC, ");
                        query3.append(" FEC_FINA, ");
                        query3.append(" CANA_OID_CANA, ");
                        query3.append(" MARC_OID_MARC, ");
                        query3.append(" PAIS_OID_PAIS ");
                        query3.append(" FROM INC_PAGO_MONET PAGO, ");
                        query3.append(" CRA_PERIO CRA, ");
                        query3.append(" SEG_PERIO_CORPO SEG ");
                        query3.append(" WHERE PRMO_OID_PREM_MONE = " +
                            oidPremioMonetario);
                        query3.append(" AND PAGO.PERD_OID_PERI = ");
                        query3.append(" CRA.OID_PERI ");
                        query3.append(" AND CRA.PERI_OID_PERI = ");
                        query3.append(" SEG.OID_PERI ");
                        respuesta3 = bs3.dbService.executeStaticQuery(
                            query3.toString());
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError
                                    .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }

                    premioMonetario.setPagosEnPartes(new ArrayList());

                    for (int i3 = 0; i3 < respuesta3.getRowCount(); i3++) {
                        PagoPartes pagoPartes = new PagoPartes();
                        pagoPartes.setNumeroPago(new Integer(
                                ((BigDecimal) respuesta3.getValueAt(i3,
                                    "NUM_PAGO")).intValue()));
                        pagoPartes.setPorcentajePremio((BigDecimal) 
                            respuesta3.getValueAt(i3, "VAL_PORC_PREM"));

                        Periodo periodoControl = new Periodo();
                        periodoControl.setCodperiodo((String) 
                            respuesta3.getValueAt(i3, "COD_PERI"));
                        periodoControl.setFechaDesde((Date)
                            respuesta3.getValueAt(i3, "FEC_INIC"));
                        periodoControl.setFechaHasta((Date) 
                            respuesta3.getValueAt(i3, "FEC_FINA"));
                        periodoControl.setOidCanal(new Long(((BigDecimal) 
                            respuesta3.getValueAt(i3,"CANA_OID_CANA"))
                                .longValue()));
                        periodoControl.setOidMarca(new Long(((BigDecimal) 
                            respuesta3.getValueAt(i3,"MARC_OID_MARC"))
                                .longValue()));
                        periodoControl.setOidPais(new Long(((BigDecimal) 
                            respuesta3.getValueAt(i3,"PAIS_OID_PAIS"))
                                .longValue()));
                        periodoControl.setOidPeriodo(new Long(
                                ((BigDecimal) respuesta3.getValueAt(i3,
                                    "PERD_OID_PERI")).longValue()));
                                    
                        // Periodo                                    
                        pagoPartes.setPeriodoControl(periodoControl); 
                        premioMonetario.getPagosEnPartes().add(pagoPartes);
                    }
                }
            }

            UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremioPorNivel:Salida");

            return premioMonetario;
        }

        // procesar premio articulo lote
        if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_ARTICULO.longValue()){
            UtilidadesLog.debug(" tipoPremioLeido = ConstantesINC.TIPO_PREMIO_ARTICULO.longValue() ***");

            PremioArticuloLote premioArticuloLote = new PremioArticuloLote();
            PremioArticulo premioArticulo = new PremioArticulo();
            premioArticuloLote.setNivel(nivelPre);
            premioArticuloLote.setTipoPremio(new Long(tipoPremioLeido));
            // vbongiov -- 5/07/2006 -- inc 723
            premioArticuloLote.setDescripcionTipoPremio(descTipoPremio);
            premioArticuloLote.setPeriodoDeDespacho(periodoDespacho);
            premioArticuloLote.setPuntosObtenerProdExigidos((
                puntosObtenerProdExigidos != null)
                ? new Double(puntosObtenerProdExigidos.doubleValue())
                : new Double(0));

            BelcorpService bs4;
            RecordSet respuesta4;
            StringBuffer query4 = new StringBuffer();

            try {
                bs4 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            try {
                /* INC 001 - gPineda - 13/01/2007
                * Se agrega la recuperacion del atributo VAL_DESC_LOTE_PREM_ARTI. (2)
                */
                query4.append(" SELECT ");
                query4.append(" NUM_UNID, NUM_LOTE, ");
                query4.append(" NUM_PREM, ");
                query4.append(" OID_LOTE_PREM_ARTI ");
                query4.append(" ,INC_LOTE_PREMI_ARTIC.VAL_DESC_LOTE_PREM_ARTI"); //(2)
                query4.append(" FROM INC_PREMI_ARTIC, ");
                query4.append(" INC_LOTE_PREMI_ARTIC ");
                query4.append(" WHERE PRAR_OID_PREM_ARTI = OID_PREM_ARTI ");
                query4.append(" AND PANP_OID_PARA_NIVE_PREM = " + oidNivelPremiacion);
                //  Agregado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
                if (numeroPremio!=null)   {
                    query4.append(" AND NUM_PREM = "+ numeroPremio.longValue() +" ");
                }
                query4.append(" ORDER BY NUM_LOTE ");                
                
                respuesta4 = bs4.dbService.executeStaticQuery(
                    query4.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!respuesta4.esVacio()) {
                premioArticuloLote.setDescripcionLote( (String) respuesta4.getValueAt(0, "VAL_DESC_LOTE_PREM_ARTI") );//(2)
                premioArticuloLote.setNumeroLote(new Long(
                        ((BigDecimal) respuesta4.getValueAt(0, "NUM_LOTE"))
                            .longValue()));
                premioArticuloLote.setNumeroPremio(new Long(
                        ((BigDecimal) respuesta4.getValueAt(0, "NUM_PREM"))
                            .longValue()));
                premioArticulo.setNumeroUnidades(new Long(
                        ((BigDecimal) respuesta4.getValueAt(0, "NUM_UNID"))
                            .longValue()));
                premioArticuloLote.setPremio(premioArticulo);
                premioArticuloLote.setPuntosObtenerProdExigidos((
                    puntosObtenerProdExigidos != null)
                    ? new Double(puntosObtenerProdExigidos.doubleValue())
                    : new Double(0));

                Long oidLotePremioArticulo = new Long(((BigDecimal) respuesta4.getValueAt(0, "OID_LOTE_PREM_ARTI")).longValue());
                //  Agregado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("**** oidLotePremioArticulo: " + oidLotePremioArticulo );
                
                ArrayList articulos = new ArrayList();

                BelcorpService bs7;
                RecordSet respuesta7;

                try {
                    bs7 = BelcorpService.getInstance();
                } catch (MareMiiServiceNotFoundException e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                }

                try {
                    //Brecha INC-003 6-9-07 jrivas
                    respuesta7 = bs7.dbService.executeStaticQuery(queryArticuloLote(oidLotePremioArticulo).toString());
                        
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                        
                      UtilidadesLog.debug("*** respuesta7: " + respuesta7);
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }

                ArticuloLote articuloLote = null;
                
                if (!respuesta7.esVacio()) {
                
                    int cant7 = respuesta7.getRowCount();
                    for(int i7=0; i7 < cant7; i7++) {
                        articuloLote = new ArticuloLote();
                        
                        articuloLote.setNombre((String)respuesta7.getValueAt(i7, "DESCPRODU"));
                        
                        articuloLote.setNumeroUnidades(new Long(
                                ((BigDecimal) respuesta7.getValueAt(i7, "NUM_UNID"))
                                    .longValue()));
                        articuloLote.setCodigoVentaFicticio(respuesta7.getValueAt(
                                i7, "COD_VENT_FICT").toString());
                        articuloLote.setOidCodigoProducto(new Long(
                                ((BigDecimal) respuesta7.getValueAt(i7,
                                    "PROD_OID_PROD")).longValue()));
                        articuloLote.setPrecioPublico((BigDecimal) 
                            respuesta7.getValueAt(i7, "IMP_PREC_PUBL"));
                            
                        articuloLote.setCodSapProducto((String)	respuesta7.getValueAt(i7, "COD_SAP")); 
                        
                        articuloLote.setTipoEntregaPremio(respuesta7.getValueAt(i7, "IND_TIPO_ENTR_PREM").toString()); 
                        if (respuesta7.getValueAt(i7, "COD_CENT_SERV") != null) {
                            articuloLote.setCodigoCentroServicio((String) respuesta7.getValueAt(i7, "COD_CENT_SERV")); 
                        } else {
                            articuloLote.setCodigoCentroServicio(""); 
                        }
                        
                        if (respuesta7.getValueAt(i7, "DES_CENT_SERV") != null) {
                            articuloLote.setDescripcionCentroServicio((String) respuesta7.getValueAt(i7, "DES_CENT_SERV")); 
                        } else {
                            articuloLote.setDescripcionCentroServicio(""); 
                        }           
                        
                        // vbongiov -- Cambio 20090828 -- 8/06/2009
                        articuloLote.setOidArticuloLote(new Long(((BigDecimal) respuesta7.getValueAt(i7, "OID_ARTI_LOTE")).longValue()));                                
                        
                        articulos.add(articuloLote);
                    }
                }
                premioArticuloLote.setArticulos(articulos);
            }  

            UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremio"
                +"PorNivel(Long oid):Salida");

            return premioArticuloLote;
        }

        // procesar premio descuento
        if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_DESCUENTOS
            .longValue()) {
            UtilidadesLog.debug("tipoPremioLeido = ConstantesINC.TIPO_PREMIO"
                +"_DESCUENTOS.longValue() ***");

            PremioDescuento premioDescuento = new PremioDescuento();
            premioDescuento.setNivel(nivelPre);
            premioDescuento.setTipoPremio(new Long(tipoPremioLeido));
            // vbongiov -- 5/07/2006 -- inc 723
            premioDescuento.setDescripcionTipoPremio(descTipoPremio);
            premioDescuento.setPeriodoDeDespacho(periodoDespacho);

            BelcorpService bs5;
            RecordSet respuesta5;
            RecordSet respuesta6;
            StringBuffer query5 = new StringBuffer();
            StringBuffer query6 = new StringBuffer();

            try {
                bs5 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            try {
                query5.append(" SELECT OID_PREM_DESC,");
                query5.append(" NUM_PREM, ");
                query5.append(" VAL_CANT_DESC, ");
                query5.append(" VAL_PORC_DESC, ");
                query5.append(" PERD_OID_PERI_DESD, ");
                query5.append(" PERD_OID_PERI ");
                query5.append(" FROM INC_PREMI_DESCU ");
                query5.append(" WHERE OID_PARA_NIVE_PREM = " +
                    oidNivelPremiacion);
                respuesta5 = bs5.dbService.executeStaticQuery(
                    query5.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!respuesta5.esVacio()) {
            
                BigDecimal oidPremDesc = (BigDecimal) respuesta5.getValueAt(0,
                        "OID_PREM_DESC");
                
                BigDecimal cantidad = (BigDecimal) respuesta5.getValueAt(0,
                        "VAL_CANT_DESC");
                premioDescuento.setCantidad((cantidad != null) ? cantidad
                    : new BigDecimal(0));
                

                premioDescuento.setNumeroPremio(new Long(
                        ((BigDecimal) respuesta5.getValueAt(0, "NUM_PREM"))
                            .longValue()));
                premioDescuento.setOidPeriodoDesde(new Long(
                        ((BigDecimal) respuesta5.getValueAt(0,
                            "PERD_OID_PERI_DESD")).longValue()));

                
                BigDecimal periodoHasta = (BigDecimal) 
                    respuesta5.getValueAt(0,"PERD_OID_PERI");
                premioDescuento.setOidPeriodoHasta((periodoHasta != null)
                    ? new Long(periodoHasta.longValue()) : null);
                

                premioDescuento.setPorcentaje((BigDecimal) 
                    respuesta5.getValueAt(0, "VAL_PORC_DESC"));
                    
                ArrayList prodDesc = new ArrayList();
                    
                // Productos del premio descuento                
                try {
                    query6.append(" SELECT prodD.MAPR_OID_MARC_PROD,");
                    query6.append(" prodD.SGEN_OID_SUPE_GENE, prodD.GENE_OID_GENE, ");
                    query6.append(" prodD.UNEG_OID_UNID_NEGO, prodD.NEGO_OID_NEGO, ");
                    query6.append(" prodD.PROD_OID_PROD ");
                    query6.append(" FROM INC_PRODU_DESCU prodD ");
                    query6.append(" WHERE prodD.PRDE_OID_PREM_DESC = " + oidPremDesc);
                    
                    respuesta6 = bs5.dbService.executeStaticQuery(query6.toString());
                    
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }

                ProductoDescuento prodDescuento = null;
                
                if (!respuesta6.esVacio()) {
                    int cant6 = respuesta6.getRowCount();
                    
                    for(int i6=0; i6 < cant6; i6++) {
                        prodDescuento = new ProductoDescuento();
                        
                        prodDescuento.setOidMarcaProducto(new Long(((BigDecimal)respuesta6.getValueAt(i6,"MAPR_OID_MARC_PROD")).intValue()));
                        
                        BigDecimal oidSupeGen = (BigDecimal) 
                            respuesta6.getValueAt(i6,"SGEN_OID_SUPE_GENE");
                        prodDescuento.setOidSuperGenerico((oidSupeGen != null)
                            ? new Long(oidSupeGen.longValue()) : null);
                            
                        BigDecimal oidGene = (BigDecimal) 
                            respuesta6.getValueAt(i6,"GENE_OID_GENE");
                        prodDescuento.setOidGenerico((oidGene != null)
                            ? new Long(oidGene.longValue()) : null);
                        
                        BigDecimal oidUniNeg = (BigDecimal) 
                            respuesta6.getValueAt(i6,"UNEG_OID_UNID_NEGO");
                        prodDescuento.setOidUnidadNegocio((oidUniNeg != null)
                            ? new Long(oidUniNeg.longValue()) : null);
                            
                        BigDecimal oidNeg = (BigDecimal) 
                            respuesta6.getValueAt(i6,"NEGO_OID_NEGO");
                        prodDescuento.setOidNegocio((oidNeg != null)
                            ? new Long(oidNeg.longValue()) : null);
                            
                        BigDecimal oidProd = (BigDecimal) 
                            respuesta6.getValueAt(i6,"PROD_OID_PROD");
                        prodDescuento.setOidProducto((oidProd != null)
                            ? new Long(oidProd.longValue()) : null);
                            
                        prodDesc.add(prodDescuento);
                    }
                }
                                    
                premioDescuento.setListaProductos(prodDesc);
                    
            }

            UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremio"
                +"PorNivel(Long oid):Salida");

            return premioDescuento;
        }

        // procesar premio puntaje
        if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_PUNTUACION
            .longValue()) {
            UtilidadesLog.debug(
                "*** tipoPremioLeido = ConstantesINC.TIPO_PREMIO_PUNTUACION."
                    +"longValue() ***");

            PremioPuntos premioPuntos = new PremioPuntos();
            premioPuntos.setNivel(nivelPre);
            premioPuntos.setTipoPremio(new Long(tipoPremioLeido));
            // vbongiov -- 5/07/2006 -- inc 723
            premioPuntos.setDescripcionTipoPremio(descTipoPremio);
            premioPuntos.setPeriodoDeDespacho(periodoDespacho);

            BelcorpService bs6;
            RecordSet respuesta6;
            StringBuffer query6 = new StringBuffer();

            try {
                bs6 = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            try {
                query6.append(" SELECT ");
                query6.append(" VAL_CANT, ");
                query6.append(" NUM_PREM, ");
                query6.append(" COPA_OID_PARA_GRAL, ");
                query6.append(" VAL_PORC, ");
                query6.append(" TPPU_OID_TIPO_PREM_PUNT ");
                query6.append(" FROM INC_PREMI_PUNTO ");
                query6.append(" WHERE PANP_OID_PARA_NIVE_PREM = " +
                    oidNivelPremiacion);
                respuesta6 = bs6.dbService.executeStaticQuery(
                    query6.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!respuesta6.esVacio()) {
                {
                    BigDecimal cantidad = (BigDecimal) respuesta6.getValueAt(0,
                            "VAL_CANT");
                    premioPuntos.setCantidad((cantidad != null) ? cantidad
                        : new BigDecimal(0));
                }

                premioPuntos.setNumeroPremio(new Long(
                        ((BigDecimal) respuesta6.getValueAt(0, "NUM_PREM"))
                            .longValue()));
                premioPuntos.setOidConcursoDestino(new Long(
                        ((BigDecimal) respuesta6.getValueAt(0,
                            "COPA_OID_PARA_GRAL")).longValue()));
                UtilidadesLog.debug("premioPuntos.setOidConcursoDestino " +
                    premioPuntos.getOidConcursoDestino());
                premioPuntos.setPorcentaje((BigDecimal) respuesta6.getValueAt(
                        0, "VAL_PORC"));
                premioPuntos.setOidTipoPremioPuntos(new Long(
                        ((BigDecimal) respuesta6.getValueAt(0,
                            "TPPU_OID_TIPO_PREM_PUNT")).longValue()));
            }

            UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremio"
                +"PorNivel(Long oid):Salida");

            return premioPuntos;
        }

        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremioPor"
            +"Nivel(Long oid):Salida");

        return null;
    }

    /**
     * @author Dante Castiglione
     * Modificado: Cristian Valenzuela
     * Fecha: 16/8/2005
     * Incidencia: BELC300020542
     * 
     * Modificaco INC-46
     * jrivas 28/3/2006
     */
    public void recuperarPremiosMultinivel(
        ClientePremiacionConcurso               clientePremiacionConcurso,
        ClientePremiacion                       clientePremiacion,    
        Concurso                                concurso)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremiosMulti"
            +"nivel(ClientePremiacionConcurso clientePremiacionConcurso, Clien"
            +"tePremiacion clientePremiacion, Concurso concurso):Entrada");


BelcorpService bs;
        RecordSet registrosRecuperados;
        StringBuffer query = new StringBuffer();

        if (clientePremiacionConcurso.getPremiosEscogidos() == null) {
            clientePremiacionConcurso.setPremiosEscogidos(new ArrayList());
        }

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
 
        int rotaciones = 1;

        if ((concurso.getNivelesRotatorios() == true) && (concurso.getNumeroRotaciones() != null)
            && (concurso.getNumeroRotaciones().intValue() > 0)) {
            rotaciones = concurso.getNumeroRotaciones().intValue();
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("*** rotaciones: " + rotaciones);

        boolean fin = false;
        double saldoCanjear = clientePremiacionConcurso.getSaldoPuntos().doubleValue();
        double puntosServicio = 0;
        double cantidadFija = 0;
        double puntosInicial;
        double puntosFinal = 0;
        double puntos = 0;
        
        //jrivas 20070536 13/11/2008
        saldoCanjear = saldoCanjear + clientePremiacionConcurso.getUltimoSaldo().doubleValue();
        rotaciones = rotaciones - clientePremiacionConcurso.getUltimaRotacion().intValue();

        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("*** saldoCanjear: " + saldoCanjear);
        
        // ----------------------------------------------------------------------
        // JVM, sicc 20070300, 
        // ----------------------------------------------------------------------
        
        BigDecimal meta = new BigDecimal(0);
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("JVM300,concurso.getOidConcurso()="+concurso.getOidConcurso());
          UtilidadesLog.debug("JVM300,clientePremiacion.getOidCliente()="+clientePremiacion.getOidCliente());
          UtilidadesLog.debug("JVM300,concurso.getOidPais()="+concurso.getOidPais());
        }  
        
        try
        {
            query = new StringBuffer();
            query.append(" SELECT ");
            query.append(" VAL_META ");
            query.append(" FROM  ");
            query.append(" INC_METAS_TIPO_VENTA  V, ");
            query.append(" INC_CONCU_PARAM_GENER C ");
            query.append(" WHERE 1=1  ");
            query.append(" AND V.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());
            query.append(" AND V.CLIE_OID_CLIE      = " + clientePremiacion.getOidCliente());
            query.append(" AND C.OID_PARA_GRAL      = V.COPA_OID_PARA_GRAL ");
            //query.append(" AND C.NUM_VERS           = " + clientePremiacion.);
            query.append(" AND C.PAIS_OID_PAIS      = " + concurso.getOidPais());
            
            registrosRecuperados = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** registrosRecuperados: " + registrosRecuperados);
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if(!registrosRecuperados.esVacio()){
            meta = (BigDecimal) registrosRecuperados.getValueAt(0, "VAL_META");
        }

        if (meta == null || meta.compareTo(new BigDecimal(0)) == 0){
            try
            {
                query = new StringBuffer();
                query.append(" SELECT M.IMP_MONT_MINI AS IMP_MONT_MINI ");
                query.append(" FROM INC_MONTO_MINIM_RANGO_CONSU M ");
                query.append(" WHERE 1=1  ");
                query.append(" AND M.ESTV_OID_ESTA_VENT IN (   ");
                query.append(" SELECT OID_ESTA_VENT  ");
                query.append(" FROM INC_ESTAT_VENTA  ");
                query.append(" WHERE COPA_OID_PARA_GRAL = "+concurso.getOidConcurso());
                query.append(" AND ESTA_OID_ESTA_CLIE = 2) ");    
                
                registrosRecuperados = bs.dbService.executeStaticQuery(query.toString());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("*** registrosRecuperados2: " + registrosRecuperados);
                
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if(!registrosRecuperados.esVacio()){
                meta = (BigDecimal) registrosRecuperados.getValueAt(0, "IMP_MONT_MINI");
            }                        
        }
        
        BigDecimal puntosMeta = new BigDecimal(0);
        
        // (1) PuntosMeta = ( Meta / FactorConversion ) * Puntos_a_Asignar
        puntosMeta = meta.divide(   new BigDecimal(concurso.getFactorConversion().doubleValue()), 
                                    CANT_DECIMALES_PUNTOS, 
                                    BigDecimal.ROUND_HALF_UP 
                                 ).multiply((new BigDecimal(concurso.getPuntosAsignar().doubleValue())));
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("JVM300, (1); "+
            "puntosMeta("+puntosMeta+")= Meta("+meta+")/FactorConversion("+concurso.getFactorConversion().doubleValue()+ ")");
        
        clientePremiacionConcurso.setPuntosMeta(puntosMeta);
        
        // (2) IncrmentoSobreMeta = SaldoPunto - PuntosMeta
        //BigDecimal incrementoSobreMeta = new BigDecimal(clientePremiacionConcurso.getSaldoPuntos().toString());
        BigDecimal incrementoSobreMeta = new BigDecimal(saldoCanjear);
        incrementoSobreMeta = incrementoSobreMeta.subtract(puntosMeta);

        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                
          UtilidadesLog.debug("JVM300,  (2); IncrementoSobreMeta("+incrementoSobreMeta+")=SaldoPunto("+saldoCanjear+")-PuntosMeta("+puntosMeta+")");
                
        // (3) SaldoCanjear = IncrementoSobreMeta
        saldoCanjear = incrementoSobreMeta.doubleValue();
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("JVM300, (3); saldoCanjear("+saldoCanjear+") = incremetoSobreMeta("+incrementoSobreMeta+")");
                
        // --------------------------------------------------------------------  
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("*** NEW saldoCanjear: " + saldoCanjear);        
        
       try {
            query = new StringBuffer();
            query.append(" SELECT ");
            query.append(" PNP.OID_PARA_NIVE_PREM, ");
            query.append(" NVL(PNP.VAL_PUNT_SERV, 0) VAL_PUNT_SERV,");
            query.append(" NVL(PNP.NUM_CANT_FIJA_PUNT, 0) NUM_CANT_FIJA_PUNT, ");
            query.append(" NVL(PNP.NUM_CANT_INIC_PUNT, 0) NUM_CANT_INIC_PUNT, ");
            query.append(" NVL(PNP.NUM_CANT_FINA_PUNT, 0) NUM_CANT_FINA_PUNT, ");
            query.append(" NUM_PUNT_PROD_EXIG, ");
            query.append(" conc.MARC_OID_MARC, ");
            query.append(" conc.CANA_OID_CANA, ");
            query.append(" conc.PAIS_OID_PAIS, ");
            query.append(" NVL(PNP.NUM_CANT_FIJA_PUNT, ");
            query.append(" PNP.NUM_CANT_INIC_PUNT) AS PUNTOS, ");        
            //INC-46 28/3/2006 jrivas
            query.append(" PNP.TPRE_OID_TIPO_PREM,  ");
            query.append(" PNP.NUM_NIVE, ");
            
            query.append(" NVL(PNP.VAL_NIVE_SELE,0) VAL_NIVE_SELE, ");  // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
            
            // vbongiov -- 5/07/2006 -- inc 723
            query.append(" V.VAL_I18N descTipoPremio ");            
            query.append(" FROM INC_PARAM_NIVEL_PREMI PNP, ");
            query.append(" INC_PARAM_GENER_PREMI PGP, ");
            query.append(" INC_CONCU_PARAM_GENER conc, ");
            query.append(" V_GEN_I18N_SICC V ");
            query.append(" WHERE  PNP.PAGP_OID_PARA_GENE_PREM = ");
            query.append(" PGP.OID_PARA_GENE_PREM ");
            query.append(" AND PGP.COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());
            query.append(" AND conc.OID_PARA_GRAL = PGP.COPA_OID_PARA_GRAL ");
            query.append(" AND V.VAL_OID = TPRE_OID_TIPO_PREM ");
            query.append(" AND V.ATTR_NUM_ATRI = 1  ");
            query.append(" AND V.ATTR_ENTI = 'INC_TIPO_PREMI' ");
            query.append(" AND V.IDIO_OID_IDIO = " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
            query.append(" ORDER BY PNP.NUM_NIVE ");
            
            registrosRecuperados = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** registrosRecuperados: " + registrosRecuperados);
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        ArrayList nivelesEntregar = new ArrayList();

        //jrivas 20070536 13/11/2008
        int niveles = registrosRecuperados.getRowCount();
        boolean seguir = true;
        boolean canjeoPuntos = false;
        int primerNivel = clientePremiacionConcurso.getUltimoNivel().intValue();
        double ultimoSaldoCanjeado = 0;
        int nivelObtenido = 0;
        int ultimoNivel = ((BigDecimal)registrosRecuperados.getValueAt((niveles-1), "NUM_NIVE")).intValue();
        //jrivas 10/12/2008 20080808
        double saldoADescontar = 0;
        saldoADescontar = saldoADescontar - clientePremiacionConcurso.getUltimoSaldo().doubleValue();
        
        int nivel = 0;
        int ultimaRotacion = clientePremiacionConcurso.getUltimaRotacion().intValue();
        
        // vbongiov -- Cambio 20090950 -- 27/10/2009
        int nivelObtenidoxProductoExigido = 0;
        boolean indPuntosExigidos = false;
        int cant = registrosRecuperados.getRowCount();
        
        for(int i=0; i< cant; i++){
            
            if((BigDecimal)registrosRecuperados.getValueAt(i, "NUM_PUNT_PROD_EXIG") != null &&
               (((BigDecimal) registrosRecuperados.getValueAt(i, "NUM_PUNT_PROD_EXIG")).intValue() > 0)){
                indPuntosExigidos = true;
            }
            
            // sapaza -- PER-SICC-2011-0314 -- 16/05/2011
            if((BigDecimal)registrosRecuperados.getValueAt(i, "NUM_PUNT_PROD_EXIG") != null &&
              (clientePremiacionConcurso.getSaldoPuntosExigidos().doubleValue() >=
               (((BigDecimal) registrosRecuperados.getValueAt(i, "NUM_PUNT_PROD_EXIG")).doubleValue()))){
               
                nivelObtenidoxProductoExigido = ((BigDecimal)registrosRecuperados.getValueAt(i, "NUM_NIVE")).intValue();
            }
        }

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("clientePremiacionConcurso.getSaldoPuntosExigidos(): " + clientePremiacionConcurso.getSaldoPuntosExigidos()); 
          UtilidadesLog.debug("indPuntosExigidos: " + indPuntosExigidos); 
          UtilidadesLog.debug("nivelObtenidoxProductoExigido: " + nivelObtenidoxProductoExigido); 
        }  
        
        if(indPuntosExigidos && (nivelObtenidoxProductoExigido == 0)) {
            UtilidadesLog.debug("nivelObtenido = 0 "); 
            nivelObtenido = 0;
            
        } else {
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("*** ultimoNivel: " + ultimoNivel); 
              UtilidadesLog.debug("*** primerNivel: " + primerNivel); 
              UtilidadesLog.debug("*** saldoCanjear: " + saldoCanjear); 
              UtilidadesLog.debug("*** Inicial: " + ((BigDecimal) registrosRecuperados.getValueAt((primerNivel), "NUM_CANT_INIC_PUNT")).doubleValue()); 
            }   
                    
            while ((rotaciones != 0) && (seguir) && (
                   ((((BigDecimal) registrosRecuperados.getValueAt((primerNivel), "NUM_CANT_FIJA_PUNT")).doubleValue() > 0) &&
                   ((saldoCanjear + ((BigDecimal) registrosRecuperados.getValueAt((primerNivel), "VAL_PUNT_SERV")).doubleValue()) >= 
                   ((BigDecimal) registrosRecuperados.getValueAt((primerNivel), "NUM_CANT_FIJA_PUNT")).doubleValue()))  ||
                   (saldoCanjear >= ((BigDecimal) registrosRecuperados.getValueAt((primerNivel), "NUM_CANT_INIC_PUNT")).doubleValue()) )) {
                   
                nivel = primerNivel;
                while ((ultimoNivel != nivel) && (nivelObtenido == 0)) {
                    puntosServicio = ((BigDecimal) registrosRecuperados.getValueAt(nivel, "VAL_PUNT_SERV")).doubleValue();
                    cantidadFija = ((BigDecimal) registrosRecuperados.getValueAt(nivel, "NUM_CANT_FIJA_PUNT")).doubleValue();
                    puntosInicial = ((BigDecimal) registrosRecuperados.getValueAt(nivel,"NUM_CANT_INIC_PUNT")).doubleValue();
                    puntosFinal = ((BigDecimal) registrosRecuperados.getValueAt(nivel, "NUM_CANT_FINA_PUNT")).doubleValue();
                    puntos = ((BigDecimal)registrosRecuperados.getValueAt(nivel,"PUNTOS")).doubleValue();
                    nivel = nivel + 1;                
                
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                                
                      UtilidadesLog.debug("*** nivel: " + nivel);     
                      UtilidadesLog.debug("*** puntosServicio: " + puntosServicio); 
                      UtilidadesLog.debug("*** cantidadFija: " + cantidadFija); 
                      UtilidadesLog.debug("*** puntosInicial: " + puntosInicial); 
                      UtilidadesLog.debug("*** puntosFinal: " + puntosFinal); 
                      UtilidadesLog.debug("*** puntos: " + puntos); 
                      UtilidadesLog.debug("*** saldoCanjear: " + saldoCanjear); 
                      UtilidadesLog.debug("*** rotaciones: " + rotaciones); 
                    }  
                    
                    // vbongiov -- Cambio 20090950 -- 27/10/2009
                    if ((ultimoNivel != nivel) && (((cantidadFija > 0) && (saldoCanjear + puntosServicio) >= cantidadFija) ||
                                ((saldoCanjear >= puntosInicial) && (saldoCanjear <= puntosFinal)) ||
                                (indPuntosExigidos && nivelObtenidoxProductoExigido == nivel)
                                )) {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                
                          UtilidadesLog.debug("*** Entro 1: " + nivel); 
                        nivelObtenido = nivel;
                        canjeoPuntos = true;
                        saldoCanjear = saldoCanjear - puntos;
                        ultimoSaldoCanjeado = puntos;
                        //jrivas 10/12/2008 20080808
                        saldoADescontar = saldoADescontar + puntos;
                        tratarNivelObtenido(concurso, registrosRecuperados, 
                                                              nivelesEntregar, nivel, primerNivel);
                    }
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                    
                      UtilidadesLog.debug("*** nivelObtenido: " + nivelObtenido); 
                    
                    if ((ultimoNivel != nivelObtenido) && (nivelObtenido != 0) && (!concurso.getIndDuplaCyzone())) {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                          UtilidadesLog.debug("*** Entro 2: " + nivel); 
                        seguir = false;
                    }
                    
                    if ((ultimoNivel == nivel) && (((cantidadFija > 0) && (saldoCanjear >= cantidadFija)) ||
                                (saldoCanjear >= puntosInicial))) {
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                                
                          UtilidadesLog.debug("*** Entro 3: " + nivel);
                        nivelObtenido = nivel;
                        canjeoPuntos = true;
                        saldoCanjear = saldoCanjear - puntos;
                        ultimoSaldoCanjeado = puntos;
                        //jrivas 10/12/2008 20080808
                        saldoADescontar = saldoADescontar + puntos;
                        tratarNivelObtenido(concurso, registrosRecuperados, 
                                                              nivelesEntregar, nivel, primerNivel);                    
                    }
                }
    
                primerNivel = 0;
                
                //jrivas 5/5/09 20090912
                if (concurso.getIndDuplaCyzone()) {
                    UtilidadesLog.debug("*** Entro 3.5 ");
                    nivelObtenido = 0;
                    rotaciones = rotaciones - 1;
                }
                
                if (nivelObtenido == ultimoNivel) {
                    UtilidadesLog.debug("*** Entro 4 ");
                    seguir = true;
                    rotaciones = rotaciones - 1;
                    ultimaRotacion = ultimaRotacion + 1;
                    ultimoSaldoCanjeado = 0;
                    nivelObtenido = 0;
                }
                
            }
        }

        //jrivas 10/12/2008 20080808
        if (canjeoPuntos) {
            clientePremiacionConcurso.setSaldoADescontar(saldoADescontar);
        }
        
        // sapaza -- PER-SiCC-2015-0303 -- 11/05/2015
        if ((canjeoPuntos) && (!concurso.getIndDuplaCyzone()) && (concurso.getPremiosAcumulativosNiveles())) {
            this.guardarUltimaAsignacionPremios(concurso.getOidPais(), concurso.getOidConcurso(), clientePremiacion.getOidCliente(), 
                                                        ultimaRotacion, nivelObtenido, ultimoSaldoCanjeado);
        }
        
        /*while (rotaciones != 0) {               
            for (int i = 0; (i < registrosRecuperados.getRowCount()) && (fin == false); i++) {
                puntosServicio = ((BigDecimal) registrosRecuperados.getValueAt(i, "VAL_PUNT_SERV")).doubleValue();
                cantidadFija = ((BigDecimal) registrosRecuperados.getValueAt(i, "NUM_CANT_FIJA_PUNT")).doubleValue();
                puntosInicial = ((BigDecimal) registrosRecuperados.getValueAt(i,"NUM_CANT_INIC_PUNT")).doubleValue();
                puntosFinal = ((BigDecimal) registrosRecuperados.getValueAt(i, "NUM_CANT_FINA_PUNT")).doubleValue();
                puntos = ((BigDecimal)registrosRecuperados.getValueAt(i,"PUNTOS")).doubleValue();
        
                UtilidadesLog.debug("*** puntosServicio: " + puntosServicio);        
                UtilidadesLog.debug("*** cantidadFija: " + cantidadFija);        
                UtilidadesLog.debug("*** puntosInicial: " + puntosInicial);        
                UtilidadesLog.debug("*** puntosFinal: " + puntosFinal);        
                UtilidadesLog.debug("*** puntos: " + puntos);        
        
                if (((cantidadFija > 0) && ((saldoCanjear + puntosServicio) >= cantidadFija)) ||
                ((puntosInicial <= saldoCanjear) &&
                (saldoCanjear <= puntosFinal))) {
                    UtilidadesLog.debug("*** entro " + i);        
                    tratarNivelObtenido(concurso, registrosRecuperados, 
                                                          nivelesEntregar, i, 0);
                    fin = true;
                    saldoCanjear = saldoCanjear - puntos;
                } 
            }

            UtilidadesLog.debug("*** puntosServicio2: " + puntosServicio);        
            UtilidadesLog.debug("*** cantidadFija2: " + cantidadFija);        
            UtilidadesLog.debug("*** puntosFinal2: " + puntosFinal);        
            UtilidadesLog.debug("*** puntos2: " + puntos); 
            
            if ((fin == false) && (((cantidadFija > 0) && 
                    ((saldoCanjear + puntosServicio) >= cantidadFija)) || 
                    (puntosFinal <= saldoCanjear))){
                UtilidadesLog.debug("*** no entro " + registrosRecuperados.getRowCount());        
                tratarNivelObtenido(concurso, registrosRecuperados, 
                          nivelesEntregar, registrosRecuperados.getRowCount()-1, 0);
                saldoCanjear = saldoCanjear - puntos;
            }
            
            rotaciones = rotaciones - 1;
            fin = false;
        }*/
        
        //jrivas 28/11/2008 20080783
        //ArrayList premiosElegidos = new ArrayList();
        PremiosElegidos premiosElegidos = getPremiosElegidos(clientePremiacion.getOidCliente(), clientePremiacionConcurso.getOidConcurso(), clientePremiacion.getPeriodo().getOidPeriodo());

        //UtilidadesLog.debug("*** premiosElegidos, size=" + premiosElegidos.size());        
                
        long oidNivel;
        long tipoPremiacion = 0;
        long nivelElectivo = 0;
        long totalElectivosSinPremio = 0;
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("*** nivelesEntregar " + nivelesEntregar.size());        
          UtilidadesLog.debug("*** registrosRecuperados " + registrosRecuperados.getRowCount());        
        }  

        for (int i = 0; i < nivelesEntregar.size(); i++) {
            for (int q = 0; q < registrosRecuperados.getRowCount(); q++) {
                oidNivel = ((BigDecimal) registrosRecuperados.getValueAt(q, "OID_PARA_NIVE_PREM")).longValue();
                tipoPremiacion = ((BigDecimal) registrosRecuperados.getValueAt(q, "TPRE_OID_TIPO_PREM")).longValue();
                
                // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
                nivelElectivo = ((BigDecimal) registrosRecuperados.getValueAt(q, "VAL_NIVE_SELE")).longValue();
                
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("*** oidNivel " + oidNivel);        
                  UtilidadesLog.debug("*** nivelesEntregar.get(i) " + ((Long)nivelesEntregar.get(i)).longValue());        
                  UtilidadesLog.debug("*** tipoPremiacion " + tipoPremiacion);                        
                }  
                if (((Long)nivelesEntregar.get(i)).longValue() == oidNivel) {
                    break;
                }
            }

            if (ConstantesINC.OID_TIPO_PREMIO_ARTICULO.longValue() == tipoPremiacion) {
                UtilidadesLog.debug("*** Premio articulo ");        
                
                //jrivas 28/11/2008 20080783
                Long oivNivel = (Long)nivelesEntregar.get(i);
                Premio aux = premiosElegidos.obtenerPremioNivel(oivNivel);
                if (aux != null) {
                    clientePremiacionConcurso.getPremiosEscogidos().add((Premio)this.deepCopy(aux));
                } else {
                    Premio prem = recuperarPremioPorDefecto((Long)nivelesEntregar.get(i), clientePremiacionConcurso.getOidConcurso());
                    
                    if (prem != null) {
                        clientePremiacionConcurso.getPremiosEscogidos().add(prem);
                        prem.setIndPendiente(false);
                        
                        // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
                        if((nivelElectivo == 1 )  && (concurso.isSinPremioPorDefecto()) ) {
                            totalElectivosSinPremio++;
                            prem.setIndAtenderPremio(false);
                        }
                    }
                }

                /*boolean encontre = false;
                int y;
                for (y = 0; (y < premiosElegidos.size() && (encontre == false)); y++) {
                    UtilidadesLog.debug("*** nivelesEntregar.get(i)2 " + ((Long)nivelesEntregar.get(i)).longValue());        
                    UtilidadesLog.debug("*** premiosElegidos.get(y) " + ((Premio)premiosElegidos.get(y)).getNivel().getOidNivel().longValue());        
                    
                    if (((Long)nivelesEntregar.get(i)).longValue() == ((Premio)premiosElegidos.get(y)).getNivel().getOidNivel().longValue() ) {
                        UtilidadesLog.debug(" encontre ");
                        encontre = true;
                    }
                }
                
                if (encontre) {
                    try{                        
                        // JVM sicc 20070359 , se implementa clone                        
                        // clientePremiacionConcurso.getPremiosEscogidos().add(premiosElegidos.get(y-1));
                        //20080714 27/8/2008 jrivas se implementa el deepcopy
                        //Premio pre = (Premio)((Premio)premiosElegidos.get(y-1)).clone();
                        Premio pre = (Premio)this.deepCopy(premiosElegidos.get(y-1));
                        clientePremiacionConcurso.getPremiosEscogidos().add(pre);
                        
                    } catch (Exception e){
                        UtilidadesLog.error("ERROR ", e);
                        String codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(codigoError));
                    }
                                    
                } else {
                    Premio prem = recuperarPremioPorDefecto((Long)nivelesEntregar.get(i), 
                            clientePremiacionConcurso.getOidConcurso());
        
                    if (prem != null) {
                        clientePremiacionConcurso.getPremiosEscogidos().add(prem);
                    }
                }*/
            } else {
                //  Se agrego un parametro null, Modificado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
                clientePremiacionConcurso.getPremiosEscogidos().add(recuperarPremioPorNivel((Long)nivelesEntregar.get(i), null));
            }
        }
        
        // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
        if(nivelesEntregar.size() == totalElectivosSinPremio) {
            clientePremiacionConcurso.setPremiosEscogidos(new ArrayList());
        }
        
        //jrivas 28/11/2008 20080783
        this.updatePremiosElegidosPendiente(premiosElegidos, clientePremiacion.getOidPais(), clientePremiacion.getPeriodo().getOidPeriodo());
                    
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremiosMul"
            +"tinivel(ClientePremiacionConcurso clientePremiacionConcurso, "
            +"ClientePremiacion clientePremiacion, Concurso concurso):Salida");
        }

    /**
    * Fecha de Creacion: 17/05/2005
    * @author: Damasia Maneiro
    * Comentario:
    *
    */
    public ArrayList getRecomendantes(Long oidPeriodo, String tipoProceso, Long oidZona, Long cliente)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.getRecomendantes(Long oidPeriodo, String tipoProceso, Long oidZona, Long oidCliente):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;

        query.append(" SELECT MAE_CLI.OID_CLIE, p1.OID_PERI, OID_PARA_GRAL, ");
        query.append(" P1.MARC_OID_MARC, P1.CANA_OID_CANA, P1.PAIS_OID_PAIS ");
        query.append(", P1.FEC_INIC, P1.FEC_FINA, "); 

        query.append(" mae_cli.COD_CLIE, mae_cli.VAL_NOM1, mae_cli.VAL_NOM2,  "); 
        query.append(" mae_cli.VAL_APE1, mae_cli.VAL_APE2 "); 
        query.append(" FROM inc_clien_recte clie, MAE_CLIEN mae_cli, ");
        query.append(" inc_concu_param_gener concu, cra_perio p1, ");
        query.append(" cra_perio desde ");
        //jrivas 20080535 INICIO
        if ((ConstantesFAC.TIPO_CIERRE_ZONA.equals(tipoProceso)) ||
                ("C".equals(tipoProceso))) {
            query.append(" , INC_CONCU_PARAM_CONSU CONSU ");
            if (ConstantesFAC.TIPO_CIERRE_ZONA.equals(tipoProceso)) {        
               query.append(" , MAE_CLIEN_UNIDA_ADMIN MCUA ");
               query.append(" , ZON_TERRI_ADMIN ZTA ");
               query.append(" , ZON_SECCI ZS ");
            }
        }  
        //jrivas 20080535 FIN
        query.append(" WHERE clie.copa_oid_para_gral = concu.oid_para_gral");
        query.append(" AND p1.OID_PERI = " + oidPeriodo);
        query.append(" AND concu.perd_oid_peri_desd = desde.OID_PERI");

        query.append(" AND desde.FEC_INIC <= p1.FEC_INIC ");

        query.append(" AND concu.ind_acti = 1 ");
        query.append(" AND clie.CLIE_OID_CLIE = mae_cli.OID_CLIE");
        //jrivas 20080535 INICIO
        if ((ConstantesFAC.TIPO_CIERRE_ZONA.equals(tipoProceso)) ||
                ("C".equals(tipoProceso))) {
            query.append(" AND CONSU.COPA_OID_PARA_GRAL = CONCU.OID_PARA_GRAL ");
            query.append(" AND CONSU.IND_PREM_CAMP_EFEC = 1 ");
            if ("C".equals(tipoProceso)) {
                query.append(" AND MAE_CLI.OID_CLIE = " + cliente);
            }
            if (ConstantesFAC.TIPO_CIERRE_ZONA.equals(tipoProceso)) {        
               query.append(" AND MCUA.CLIE_OID_CLIE = MAE_CLI.OID_CLIE ");
               query.append(" AND MCUA.IND_ACTI = 1 ");
               query.append(" AND MCUA.ZTAD_OID_TERR_ADMI = ZTA.OID_TERR_ADMI ");
               query.append(" AND ZTA.ZSCC_OID_SECC = ZS.OID_SECC ");
               query.append(" AND ZS.ZZON_OID_ZONA = " + oidZona);       
            }
        }
        //jrivas 20080535 FIN
        
        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta: " + rs);                    
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.debug("resultado: " + rs);

        if (rs.esVacio()) {
            UtilidadesLog.info("DAOClientePremiacionConcurso.getRecomendantes"
                +"(Long oidPeriodo, String tipoProceso, Long oidZona, Long oidCliente):Salida VACIO");

            return null;
        } else {
            ArrayList clientesPremiacion = new ArrayList();
            Periodo periodo = new Periodo();
            DAOClientePremiacion daoClientePremiacion = 
                new DAOClientePremiacion();
            DespacharPremiosHelper despacharPremiosHelper = 
                new DespacharPremiosHelper();
            Concurso concurso = new Concurso();
            boolean existe = false;

            for (int fila = 0; rs.existeFila(fila); fila++) {
                existe = false;
                ClientePremiacion clientePremiacion = new ClientePremiacion();
                Long oidCliente = new Long(((BigDecimal) rs.getValueAt(fila,
                            "OID_CLIE")).longValue());
                Long oidPeri = new Long(((BigDecimal) rs.getValueAt(fila,
                            "OID_PERI")).longValue());
                Long oidConcurso = new Long(((BigDecimal) rs.getValueAt(fila,
                            "OID_PARA_GRAL")).longValue());

                Long marca = new Long(((BigDecimal) rs.getValueAt(fila,
                            "MARC_OID_MARC")).longValue());
                Long canal = new Long(((BigDecimal) rs.getValueAt(fila,
                            "CANA_OID_CANA")).longValue());
                Long pais = new Long(((BigDecimal) rs.getValueAt(fila,
                            "PAIS_OID_PAIS")).longValue());
                            
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                            
                  UtilidadesLog.debug("oidCliente: " + oidCliente);
                
                // vbongiov -- 20/07/2006 -- inc DBLG500001048
                DatosPersonales datPerso = new DatosPersonales();
                
                datPerso.setNombre1((String) rs.getValueAt(fila,"VAL_NOM1"));
                datPerso.setNombre2((String) rs.getValueAt(fila,"VAL_NOM2"));
                datPerso.setApellido1((String) rs.getValueAt(fila,"VAL_APE1"));
                datPerso.setApellido2((String) rs.getValueAt(fila,"VAL_APE2"));
                datPerso.setCodCliente((String) rs.getValueAt(fila,"COD_CLIE"));
                
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("oidConcurso: " + oidConcurso);
                  UtilidadesLog.debug("oidPeri: " + oidPeri);
                }  

                //Armado de Periodo INC-122
                periodo = new Periodo();
                periodo.setFechaDesde((Date) rs.getValueAt(fila, "FEC_INIC"));
                periodo.setFechaHasta((Date) rs.getValueAt(fila, "FEC_FINA"));
                periodo.setOidCanal(new Long(((BigDecimal) rs.getValueAt(fila,"CANA_OID_CANA")).longValue()));
                periodo.setOidMarca(new Long(((BigDecimal) rs.getValueAt(fila,"MARC_OID_MARC")).longValue()));
                periodo.setOidPais(new Long(((BigDecimal) rs.getValueAt(fila,"PAIS_OID_PAIS")).longValue()));
                periodo.setOidPeriodo(oidPeri);                


                //INC-122 Verificar si periodo <= concurso.ultimoPeriodoEvaluar
                concurso = despacharPremiosHelper.obtenerConcurso(oidConcurso);
                
                // sapaza -- PER-SiCC-2013-0875 -- 13/08/2013
                /*if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("periodo : " + periodo);
                  UtilidadesLog.debug("concurso.getUltimoPeridoEvaluar() : " + concurso.getUltimoPeridoEvaluar());
                }  
                
                if (!periodo.mayorQue(concurso.getUltimoPeridoEvaluar())) {
                    //Entonces tengo que procesarlo
                    UtilidadesLog.debug("SE PROCESA!!!");
                    
                    //en caso de que se repita el cliente seteamos 
                    //clientesPremiacionConcurso        
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("DAOClientePremiacionConcurso.clientesPrem"
                        +"iacion.size()" + clientesPremiacion.size());*/
    
                    //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                    if ((concurso.getPeriodoInicialEvaluacion() == null) ||
                         ((!periodo.mayorQue(concurso.getPeriodoFinalEvaluacion())) &&
                         (!periodo.menorQue(concurso.getPeriodoInicialEvaluacion())))) {

                         UtilidadesLog.debug("SE PROCESA 2!!!");
                        
                        for (int pos = 0; (clientesPremiacion.size() > pos && !existe); pos++) {
                            clientePremiacion = (ClientePremiacion) 
                                clientesPremiacion.get(pos);
        
                            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                              UtilidadesLog.debug(
                                "DAOClientePremiacionConcurso.oidCliente()" +
                                oidCliente);
                              UtilidadesLog.debug("DAOClientePremiacionConcurso.cliente"
                                +"Premiacion.getOidCliente()()" +
                                clientePremiacion.getOidCliente());
                            }    
        
                            if (oidCliente.equals(clientePremiacion.getOidCliente())){
                                existe = true;
                                daoClientePremiacion
                                    .rellenarClientePremiacionConcursoRecomendacion(concurso,
                                    clientePremiacion);                                
                            }
                        }
        
                        if (!existe) {
                            UtilidadesLog.debug(
                                "DAOClientePremiacionConcurso.nbo existe!!!");
                            clientePremiacion = new ClientePremiacion();
                            clientePremiacion.setOidCliente(oidCliente);
                            clientePremiacion.setOidMarca(marca);
                            clientePremiacion.setOidCanal(canal);
                            clientePremiacion.setOidPais(pais);
                            clientePremiacion.setPeriodo(periodo);
                            clientePremiacion.setDatosPersonales(datPerso);
                            //concurso = despacharPremiosHelper.obtenerConcurso(oidConcurso);
                            daoClientePremiacion
                              .rellenarClientePremiacionConcursoRecomendacion(concurso,
                                clientePremiacion);
                            clientesPremiacion.add(clientePremiacion);
                        } else {
                            existe = false;
                        }
                    }                         
                /*} else {
                    //no se procesa
                    UtilidadesLog.debug("NO SE PROCESA!!!");
                }*/
                
            }
            UtilidadesLog.info("DAOClientePremiacionConcurso.getRecomendantes"
                +"(Long oidPeriodo, String tipoProceso, Long oidZona, Long oidCliente):Salida");

            return clientesPremiacion;
        }
    }


    /**
     * @author Dante Castiglione
     */
    public void recuperarClientePremiacionConcurso(
        ClientePremiacionConcurso clientePremiacionConcurso,
        ClientePremiacion clientePremiacion) throws MareException {
        // 1) Cargar los atributos de clientePremiacionConcurso
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarClientePrem"
            +"iacionConcurso(ClientePremiacionConcurso clientePremiacionConcu"
            +"rso, ClientePremiacion clientePremiacion):Entrada");
        
        BelcorpService bs1;
        RecordSet respuesta1;
        StringBuffer query1 = new StringBuffer();

        try {
            bs1 = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query1.append(" SELECT ");
            query1.append(" BINC_OID_BASE_INCU, ");
            query1.append(" VAL_REQU_PREM_SUPE, ");
            query1.append(" COD_PERI, ");
            query1.append(" FEC_INIC, ");
            query1.append(" FEC_FINA, ");
            query1.append(" CANA_OID_CANA, ");
            query1.append(" MARC_OID_MARC, ");
            query1.append(" PAIS_OID_PAIS, ");

            //jrivas 5/8/2005
            //inc 20269
            query1.append(" NUM_PERI_EVAL, ");

            //jrivas 27/8/2005
            //inc 20450
            query1.append(" PERD_OID_PERI, ");

            query1.append(" PERD_OID_PERI_EVAL ");
            query1.append(" FROM INC_CANDI_GANAD GAN, ");
            query1.append(" CRA_PERIO CRA, ");
            query1.append(" SEG_PERIO_CORPO SEG ");
            query1.append(" WHERE COPA_OID_PARA_GRAL = " +
                clientePremiacionConcurso.getOidConcurso());
            query1.append(" AND CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());
            query1.append(" AND GAN.PERD_OID_PERI = CRA.OID_PERI ");
            query1.append(" AND CRA.PERI_OID_PERI = SEG.OID_PERI ");
            query1.append(" AND PAIS_OID_PAIS = " + clientePremiacion.getOidPais());
            query1.append(" AND MARC_OID_MARC = " + clientePremiacion.getOidMarca());
            query1.append(" AND CANA_OID_CANA = " + clientePremiacion.getOidCanal());
            //jrivas 20090842 25/2/2009
            //query1.append(" ORDER BY num_peri_eval desc ");
            query1.append(" ORDER BY num_peri_eval desc, VAL_REQU_PREM_SUPE  ");
                
            respuesta1 = bs1.dbService.executeStaticQuery(query1.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("respuesta1 " + respuesta1);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DespacharPremiosHelper despacharPremiosHelper = 
            new DespacharPremiosHelper();
        Concurso concursoRecuperado = despacharPremiosHelper
            .obtenerConcurso(clientePremiacionConcurso.getOidConcurso());

        if (!respuesta1.esVacio()) {
            Long periodoCandidataGanadora = new Long(((BigDecimal) 
                respuesta1.getValueAt(0, "PERD_OID_PERI")).longValue());

            BigDecimal oidBaseIncumplida = (BigDecimal) 
                respuesta1.getValueAt(0,"BINC_OID_BASE_INCU");
            clientePremiacionConcurso.setOidBaseIncumplida((
                oidBaseIncumplida != null)? new Long(oidBaseIncumplida
                    .longValue()) : null);

            //jrivas 2/8/2005
            //inc 20269            
            clientePremiacionConcurso.setNumeroPeriodosEvaluados((
                respuesta1.getValueAt(0, "NUM_PERI_EVAL") != null)
                ? (((BigDecimal) respuesta1.getValueAt(0, "NUM_PERI_EVAL"))
                    .intValue()): 0);

            BigDecimal requisitos = (BigDecimal) respuesta1.getValueAt(0,
                    "VAL_REQU_PREM_SUPE");

            if (requisitos == null) {
                clientePremiacionConcurso
                    .setRequisitosPremiacionSuperado(false);
            } else {
                if (requisitos.compareTo(new BigDecimal(1)) == 0) {
                    clientePremiacionConcurso
                        .setRequisitosPremiacionSuperado(true);
                } else {
                    clientePremiacionConcurso
                        .setRequisitosPremiacionSuperado(false);
                }
            }

            if (respuesta1.getValueAt(0, "PERD_OID_PERI_EVAL") != null) {
                Periodo periodo = new Periodo();
                periodo.setCodperiodo((String) respuesta1.getValueAt(0,
                        "COD_PERI"));
                periodo.setFechaDesde((Date) 
                    respuesta1.getValueAt(0, "FEC_INIC"));
                periodo.setFechaHasta((Date) 
                    respuesta1.getValueAt(0, "FEC_FINA"));
                periodo.setOidCanal(new Long(((BigDecimal) 
                    respuesta1.getValueAt(0, "CANA_OID_CANA")).longValue()));
                periodo.setOidMarca(new Long(((BigDecimal) 
                    respuesta1.getValueAt(0, "MARC_OID_MARC")).longValue()));
                periodo.setOidPais(new Long(((BigDecimal)
                    respuesta1.getValueAt(0, "PAIS_OID_PAIS")).longValue()));
                periodo.setOidPeriodo(new Long(((BigDecimal) 
                    respuesta1.getValueAt(0,"PERD_OID_PERI_EVAL"))
                        .longValue()));
                clientePremiacionConcurso.setUltimoPeriodoEvaluado(periodo);
            }

            //jrivas 18/8/2005
            //INC 20450
            //-Calculo periodoDespachoDespuesObtencion 
            DTOETramitarCierre dtoETramitarCierre2 = new DTOETramitarCierre();
            DAOClientePremiacion daoClientePremiacion = 
                new DAOClientePremiacion();

            dtoETramitarCierre2.setOidPais(clientePremiacion.getOidPais());
            dtoETramitarCierre2.setOidMarca(clientePremiacion.getOidMarca());
            dtoETramitarCierre2.setOidCanal(clientePremiacion.getOidCanal());
            dtoETramitarCierre2.setOidPeriodo(periodoCandidataGanadora);

            if (concursoRecuperado.getNumeroPeriodos() != null) {
                clientePremiacionConcurso.setPeriodoDespachoDespuesObtencion(
                    daoClientePremiacion.obtenerPeriodo(dtoETramitarCierre2,
                        concursoRecuperado.getNumeroPeriodos().intValue()));
            }
        }
        
        //jrivas 20/9/2006 Uso de acumulador
        // recuperar fechas desde y hasta del concurso
        Date fechaDesde = null;
        Date fechaHasta = null;
        String strFechaDesde = null;
        String strFechaHasta = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        /*BelcorpService bs4;
        RecordSet respuesta4;
        StringBuffer query4 = new StringBuffer();

        try {
            bs4 = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query4.append(" SELECT ");
            query4.append(" B.FEC_INIC, ");
            query4.append(" C.FEC_FINA ");
            query4.append(" FROM INC_CONCU_PARAM_GENER A, ");
            query4.append(" CRA_PERIO B, ");
            query4.append(" CRA_PERIO C ");
            query4.append(" WHERE A.PERD_OID_PERI_DESD = B.OID_PERI ");
            query4.append(" AND   A.PERD_OID_PERI_HAST = C.OID_PERI ");
            query4.append(" AND   OID_PARA_GRAL        = " +
                clientePremiacionConcurso.getOidConcurso());
            respuesta4 = bs4.dbService.executeStaticQuery(query4.toString());
            UtilidadesLog.debug("*** respuesta: " + respuesta4);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (!respuesta4.esVacio()) {
            fechaDesde = (Date) respuesta4.getValueAt(0, "FEC_INIC");
            fechaHasta = (Date) respuesta4.getValueAt(0, "FEC_FINA");
            strFechaDesde = sdf.format(fechaDesde);
            strFechaHasta = sdf.format(fechaHasta);
        }*/

        // 2) Recuperar importes 
        BelcorpService bs2;
        RecordSet respuesta2;
        StringBuffer query2 = new StringBuffer();

        try {
            bs2 = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            
            // sapaza -- PER-SiCC-2014-0081 -- 30/01/2014
            query2.append(" SELECT SUM(VAL_MONT_TOTA) AS SUMA, SUM(VAL_CANT_PEDI) AS CUENTA ");
            query2.append(" FROM PED_SOLIC_CABEC_ACUM2 A, ");
            query2.append("      CRA_PERIO B, ");
            query2.append("      SEG_PERIO_CORPO C, ");
            query2.append("      CRA_PERIO D, ");
            query2.append("      SEG_PERIO_CORPO E, ");
            query2.append("      CRA_PERIO F, ");
            query2.append("      SEG_PERIO_CORPO G ");
            query2.append(" WHERE A.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
            query2.append("   AND A.PERD_OID_PERI = B.OID_PERI ");
            query2.append("   AND B.PERI_OID_PERI = C.OID_PERI ");
            query2.append("   AND D.OID_PERI = " + concursoRecuperado.getPeriodoDesde().getOidPeriodo());
            query2.append("   AND D.PERI_OID_PERI = E.OID_PERI ");
            query2.append("   AND F.OID_PERI = " + concursoRecuperado.getPeriodoHasta().getOidPeriodo());
            query2.append("   AND F.PERI_OID_PERI = G.OID_PERI ");
            query2.append("   AND C.COD_PERI BETWEEN E.COD_PERI AND G.COD_PERI ");

            /*//jrivas 20/9/2006 Uso de acumulador
            query2.append(" SELECT DISTINCT SUM(VAL_MONT_TOTA) AS SUMA, SUM(VAL_CANT_PEDI) AS CUENTA");
            query2.append(" FROM PED_SOLIC_CABEC_ACUM2 A, ");
            query2.append(" CRA_PERIO B ");
            query2.append(" WHERE B.OID_PERI IN ( ");
            query2.append(" SELECT B.OID_PERI ");
            query2.append(" FROM CRA_PERIO PERINIC, CRA_PERIO B, CRA_PERIO PERFINA ");
            query2.append(" WHERE PERINIC.OID_PERI = " + concursoRecuperado.getPeriodoDesde().getOidPeriodo());
            query2.append(" AND PERFINA.OID_PERI = " + concursoRecuperado.getPeriodoHasta().getOidPeriodo());
            query2.append(" AND B.FEC_INIC >= PERINIC.FEC_INIC ");
            query2.append(" AND B.FEC_FINA <= PERFINA.FEC_FINA ");
            query2.append(" AND PERINIC.PAIS_OID_PAIS = B.PAIS_OID_PAIS ");
            query2.append(" AND PERINIC.MARC_OID_MARC = B.MARC_OID_MARC ");
            query2.append(" AND PERINIC.CANA_OID_CANA = B.CANA_OID_CANA) ");
            query2.append(" AND A.CLIE_OID_CLIE = " +clientePremiacion.getOidCliente());            
            query2.append(" AND A.PERD_OID_PERI = B.OID_PERI ");*/
            
            /*query2.append(" SELECT ");
            query2.append(" SUM (A.VAL_PREC_CATA_TOTA_LOC_UNI_DEM) AS SUMA, ");
            query2.append(" COUNT(*) AS CUENTA ");
            query2.append(" FROM PED_SOLIC_CABEC A, ");
            query2.append(" CRA_PERIO B, ");
            //jrivas 12/9/2006 Aceptacion (inc. 7)
            query2.append(" PED_TIPO_SOLIC_PAIS PTSP, ");
            query2.append(" PED_TIPO_SOLIC PTS, ");
            query2.append(" PED_SOLIC_CABEC CONSO  ");
            query2.append(" WHERE A.IND_OC = 1 ");
            query2.append(" AND A.PERD_OID_PERI = OID_PERI ");
            query2.append(" AND A.CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente().longValue());
            query2.append(" AND B.MARC_OID_MARC = " +
                clientePremiacion.getOidMarca());
            query2.append(" AND B.CANA_OID_CANA = " +
                clientePremiacion.getOidCanal());
            query2.append(" AND B.FEC_INIC >= TO_DATE('" + strFechaDesde +
                "','YYYY-MM-DD') ");
            query2.append(" AND B.FEC_FINA <= TO_DATE('" + strFechaHasta +
                "','YYYY-MM-DD') ");
            //jrivas 12/9/2006 Aceptacion (inc. 7)
            query2.append(" AND A.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS  ");
            query2.append(" AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI  ");
            query2.append(" AND PTS.IND_ANUL <> 1  ");
            query2.append(" AND PTS.IND_DEVO <> 1  ");
            query2.append(" AND A.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE(+)  ");
            query2.append(" AND NVL(CONSO.ESSO_OID_ESTA_SOLI, 1) <> " + ConstantesPED.ESTADO_SOLICITUD_ANULADO);*/
                
            respuesta2 = bs2.dbService.executeStaticQuery(query2.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta: " + respuesta2);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!respuesta2.esVacio()) {
            BigDecimal suma = (BigDecimal) respuesta2.getValueAt(0, "SUMA");

            if (!(suma == null)) {
                clientePremiacionConcurso.setMontoPedidos(suma);
            } else {
                clientePremiacionConcurso.setMontoPedidos(new BigDecimal(0));
            }

            BigDecimal cantidad = (BigDecimal) respuesta2.getValueAt(0, "CUENTA");

            if (!(cantidad == null)) {
                clientePremiacionConcurso.setCantidadPedidos(cantidad
                    .longValue());
            } else {
                clientePremiacionConcurso.setCantidadPedidos(0);
            }
        } else {
            clientePremiacionConcurso.setMontoPedidos(new BigDecimal(0));
            clientePremiacionConcurso.setCantidadPedidos(0);
        }

        // obtener los dias de gracia del concurso
        int diasDeGracia;

        BelcorpService bs5;
        RecordSet respuesta5;
        StringBuffer query5 = new StringBuffer();

        try {
            bs5 = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            /*query5.append(" SELECT ");
            query5.append(" NUM_DIAS_GRAC ");
            query5.append(" FROM INC_REQUI_PREMI ");
            query5.append(" WHERE COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());*/
            //jrivas 18/8/2006 DBLG5000986
            query5.append(" SELECT NUM_DIAS_GRAC, B.FEC_INIC, C.FEC_FINA ");
            query5.append(" FROM INC_REQUI_PREMI RP, CRA_PERIO B, CRA_PERIO C ");
            query5.append(" WHERE RP.PERD_OID_PERI_DESD = B.OID_PERI ");
            query5.append(" AND RP.PERD_OID_PERI = C.OID_PERI ");
            query5.append(" AND COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());
            
            respuesta5 = bs5.dbService.executeStaticQuery(query5.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("*** respuesta: " + respuesta5);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuesta5.esVacio() ||
                (respuesta5.getValueAt(0, "NUM_DIAS_GRAC") == null)) {
            diasDeGracia = 0;
        } else {
            diasDeGracia = ((BigDecimal) respuesta5.getValueAt(0,
                    "NUM_DIAS_GRAC")).intValue();
        }
        
        //jrivas 18/8/2006 DBLG5000986
        if (!respuesta5.esVacio()) {
            fechaDesde = (Date) respuesta5.getValueAt(0, "FEC_INIC");
            fechaHasta = (Date) respuesta5.getValueAt(0, "FEC_FINA");
            strFechaDesde = sdf.format(fechaDesde);
            strFechaHasta = sdf.format(fechaHasta);
        } else {
            fechaDesde = concursoRecuperado.getPeriodoDesde().getFechaDesde();
            fechaHasta = concursoRecuperado.getPeriodoHasta().getFechaHasta();
            strFechaDesde = sdf.format(fechaDesde);
            strFechaHasta = sdf.format(fechaHasta);
        }

        // obtener fecha de proceso
        Date fechaDeProceso = new Date(System.currentTimeMillis());
        String strfechaDeProceso = sdf.format(fechaDeProceso);

        // 3) Verificar pago en termino 
        BelcorpService bs3;
        RecordSet respuesta3;
        StringBuffer query3 = new StringBuffer();

        try {
            bs3 = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query3.append(" SELECT ");
            query3.append(" COUNT(*) ");
            query3.append(" FROM CCC_MOVIM_CUENT_CORRI A, ");
            query3.append(" CRA_PERIO B ");
            query3.append(" WHERE B.PAIS_OID_PAIS = " +
                clientePremiacion.getOidPais());
            query3.append(" AND A.MARC_OID_MARC = " +
                clientePremiacion.getOidMarca());
            query3.append(" AND B.CANA_OID_CANA = " +
                clientePremiacion.getOidCanal());
            query3.append(" AND A.CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());
            query3.append(" AND B.FEC_INIC >= TO_DATE('" + strFechaDesde +
                "','yyyy-MM-dd') ");
            query3.append(" AND B.FEC_FINA <= TO_DATE('" + strFechaHasta +
                "','yyyy-MM-dd') ");
            query3.append(" AND A.IMP_PEND = 0 ");
            query3.append(" AND A.PERD_OID_PERI = B.OID_PERI ");
            query3.append(" AND A.FEC_VENC  < TO_DATE('" + strfechaDeProceso + "', 'yyyy-MM-dd') - " + diasDeGracia );
            query3.append(" AND A.FEC_ULTI_MOVI > ( A.FEC_VENC + " +
                diasDeGracia + " ) ");
            
            respuesta3 = bs3.dbService.executeStaticQuery(query3.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta: " + respuesta3);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if ((((BigDecimal) respuesta3.getValueAt(0, 0)).longValue()) == 0) {
            clientePremiacionConcurso.setIndPagoEnTermino(true);
        } else {
            clientePremiacionConcurso.setIndPagoEnTermino(false);
        }

        // 4) Cargar clientePremiacionConcurso.dirigidoA
        clientePremiacionConcurso.setDirigidoA(
            concursoRecuperado.getDirigidoA());

        //jrivas 20070536 13/11/2008
        BelcorpService bs6;
        RecordSet respuesta6;
        StringBuffer query6 = new StringBuffer();

        try {
            bs6 = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            query6.append(" SELECT VAL_ULTI_ROTA, VAL_ULTI_NIVE, VAL_ULTI_SALD ");
            query6.append(" FROM INC_ULTIM_ASIGN_PREMI ");
            query6.append(" WHERE CLIE_OID_CLIE = " +clientePremiacion.getOidCliente());
            query6.append(" AND COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());

            respuesta6 = bs6.dbService.executeStaticQuery(query6.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("*** respuesta: " + respuesta6);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!respuesta6.esVacio()) {
            clientePremiacionConcurso.setUltimaRotacion(new Integer(((BigDecimal)respuesta6.getValueAt(0, "VAL_ULTI_ROTA")).intValue()));
            clientePremiacionConcurso.setUltimoNivel(new Integer(((BigDecimal)respuesta6.getValueAt(0, "VAL_ULTI_NIVE")).intValue()));
            clientePremiacionConcurso.setUltimoSaldo((BigDecimal)respuesta6.getValueAt(0, "VAL_ULTI_SALD"));
        } else {
            clientePremiacionConcurso.setUltimaRotacion(new Integer(0));
            clientePremiacionConcurso.setUltimoNivel(new Integer(0));
            clientePremiacionConcurso.setUltimoSaldo(new BigDecimal(0));
        }  
        //FIN jrivas 20070536 13/11/2008
        
         // vbongiov -- Cambio 20090929 -- 18/09/2009
         RecordSet respuesta7;
         StringBuffer query7 = new StringBuffer();
          
         try {
              query7.append(" SELECT premPen.OID_ASIG_PREM_PEND ");
              query7.append(" FROM INC_ASIGN_PREMI_PENDI premPen, CRA_PERIO perTope, ");
              query7.append(" CRA_PERIO perMax, INC_REQUI_PREMI reqPrem ");
              query7.append(" WHERE premPen.COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());
              query7.append(" AND premPen.CLIE_OID_CLIE = " +clientePremiacion.getOidCliente());
              query7.append(" AND premPen.VAES_OID_VALO_ESTA = " + ConstantesINC.OID_ESTADO_MORO_REGISTRADO);
              query7.append(" AND reqPrem.COPA_OID_PARA_GRAL = premPen.COPA_OID_PARA_GRAL ");
              query7.append(" AND reqPrem.VADE_OID_VALI_DEUD IS NOT NULL ");
              query7.append(" AND perMax.OID_PERI = reqPrem.PERD_OID_PERI_MAXI ");
              query7.append(" AND premPen.PERD_OID_PERI_TOPE = perTope.OID_PERI ");
              query7.append(" AND perTope.FEC_INIC <= perMax.FEC_INIC ");
              
              respuesta7 = bs6.dbService.executeStaticQuery(query7.toString());
              
              if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                              
                UtilidadesLog.debug("*** respuesta 7: " + respuesta7);
              
         } catch (Exception e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }
         
         
         if(!respuesta7.esVacio()){
         
             ArrayList asignacionPremiosPend = new ArrayList();
             int cant = respuesta7.getRowCount();
             
             for(int i=0; i<cant; i++){             
                asignacionPremiosPend.add(Long.valueOf(((BigDecimal)respuesta7.getValueAt(i, "OID_ASIG_PREM_PEND")).toString()));                 
             }
         
             clientePremiacionConcurso.setAsignacionPremiosPendientes(asignacionPremiosPend);
         } else {
             clientePremiacionConcurso.setAsignacionPremiosPendientes(new ArrayList());
         }
         
         
        // vbongiov -- Cambio 20090929 -- 18/09/2009
        if(ConstantesINC.TIPO_CIERRE_ZONA.equals(clientePremiacion.getTipoCierre())){
        
            RecordSet respuesta8;
            StringBuffer query8 = new StringBuffer();
            
            try {
            
                query8.append(" SELECT NVL(SUM(cuenta.IMP_PEND),0) DEUDA ");
                query8.append(" FROM  CCC_MOVIM_CUENT_CORRI cuenta,  ");
                query8.append("       (SELECT D.OID_PERI FROM CRA_PERIO C, CRA_PERIO D ");
                query8.append("        WHERE C.OID_PERI = " + concursoRecuperado.getPeriodoHasta().getOidPeriodo());
                query8.append("          AND D.PAIS_OID_PAIS = C.PAIS_OID_PAIS  ");
                query8.append("          AND D.MARC_OID_MARC = C.MARC_OID_MARC  ");
                query8.append("          AND D.CANA_OID_CANA = C.CANA_OID_CANA  ");
                query8.append("          AND D.FEC_INIC <= C.FEC_INIC) periodos  ");
                query8.append(" WHERE cuenta.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
                query8.append(" AND cuenta.PERD_OID_PERI = periodos.oid_peri");
    
                respuesta8 = bs6.dbService.executeStaticQuery(query8.toString());
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("respuesta8 : " + respuesta8);
            
            } catch (Exception e) {
                 UtilidadesLog.error("ERROR ", e);
                 throw new MareException(e,
                     UtilidadesError.armarCodigoError(
                         CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!respuesta8.esVacio()) {
            
                if(((BigDecimal)respuesta8.getValueAt(0, "DEUDA")).doubleValue() > 0  &&
                   ((BigDecimal)respuesta8.getValueAt(0, "DEUDA")).doubleValue() > 0.00 ) {
                   
                    clientePremiacionConcurso.setDeudaPeriodoHastaConc(true);
                    
                } else {                
                    clientePremiacionConcurso.setDeudaPeriodoHastaConc(false);                    
                }
            }
            
        } else {
            clientePremiacionConcurso.setDeudaPeriodoHastaConc(false);    
        }

        // sapaza -- Cambio 20090929 -- 23/02/2010
        if(ConstantesINC.TIPO_CIERRE_ZONA.equals(clientePremiacion.getTipoCierre())){
        
            RecordSet respuesta9;
            StringBuffer query9 = new StringBuffer();
            
            try {
            
                query9.append(" SELECT premPen.OID_ASIG_PREM_PEND, ");   
                query9.append("        (SELECT NVL(SUM(cuenta.IMP_PEND),0) ");   
                query9.append("           FROM CCC_MOVIM_CUENT_CORRI cuenta, CRA_PERIO C, CRA_PERIO D ");   
                query9.append("          WHERE cuenta.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
                query9.append("            AND C.OID_PERI = prempen.perd_oid_peri_vali ");   
                query9.append("            AND D.PAIS_OID_PAIS = C.PAIS_OID_PAIS ");   
                query9.append("            AND D.MARC_OID_MARC = C.MARC_OID_MARC ");   
                query9.append("            AND D.CANA_OID_CANA = C.CANA_OID_CANA ");   
                query9.append("            AND D.FEC_INIC <= C.FEC_INIC ");   
                query9.append("            AND cuenta.PERD_OID_PERI = D.OID_PERI) DEUDA ");                   
                query9.append(" FROM INC_ASIGN_PREMI_PENDI premPen, CRA_PERIO perTope, ");   
                query9.append(" CRA_PERIO perMax, INC_REQUI_PREMI reqPrem ");   
                query9.append(" WHERE premPen.COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());   
                query9.append(" AND premPen.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
                query9.append(" AND premPen.VAES_OID_VALO_ESTA = " + ConstantesINC.OID_ESTADO_MORO_REGISTRADO);
                query9.append(" AND reqPrem.COPA_OID_PARA_GRAL = premPen.COPA_OID_PARA_GRAL ");   
                query9.append(" AND reqPrem.VADE_OID_VALI_DEUD IS NOT NULL ");   
                query9.append(" AND perMax.OID_PERI = reqPrem.PERD_OID_PERI_MAXI ");   
                query9.append(" AND premPen.PERD_OID_PERI_TOPE = perTope.OID_PERI ");   
                query9.append(" AND perTope.FEC_INIC <= perMax.FEC_INIC ");   

        
                respuesta9 = bs6.dbService.executeStaticQuery(query9.toString());
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                
                  UtilidadesLog.debug("respuesta9 : " + respuesta9);
            
            } catch (Exception e) {
                 UtilidadesLog.error("ERROR ", e);
                 throw new MareException(e,
                     UtilidadesError.armarCodigoError(
                         CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if(!respuesta9.esVacio()){
                int cant = respuesta9.getRowCount();
                clientePremiacionConcurso.setDeudaPeriodoValidado(false);
                
                for(int i=0; i < cant; i++){
                
                    if(((BigDecimal)respuesta9.getValueAt(i, "DEUDA")).doubleValue() > 0  &&
                       ((BigDecimal)respuesta9.getValueAt(i, "DEUDA")).doubleValue() > 0.00 ) {
                       clientePremiacionConcurso.setDeudaPeriodoValidado(true);
                   }
                }            
            } else {
                clientePremiacionConcurso.setDeudaPeriodoValidado(false);    
            }
        }
        
        // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
         RecordSet respuesta10;
         StringBuffer query10 = new StringBuffer();
         
         try {
             query10.append(" SELECT COUNT(1) ");
             query10.append("   FROM INC_GANAD GAN, INC_PARAM_NIVEL_PREMI NIVEL, ");
             query10.append("        INC_PARAM_GENER_PREMI GENP, INC_CONCU_PARAM_GENER PARAM ");
             query10.append("  WHERE GAN.PANP_OID_PARA_NIVE_PREM = NIVEL.OID_PARA_NIVE_PREM ");
             query10.append("    AND NIVEL.PAGP_OID_PARA_GENE_PREM = GENP.OID_PARA_GENE_PREM ");
             query10.append("    AND GENP.COPA_OID_PARA_GRAL = PARAM.OID_PARA_GRAL ");
             query10.append("    AND PARAM.OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());
             query10.append("    AND GAN.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
             
             respuesta10 = bs6.dbService.executeStaticQuery(query10.toString());
             if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                
               UtilidadesLog.debug("respuesta10 : " + respuesta10);
         
         } catch (Exception e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }
         
        if ((((BigDecimal) respuesta10.getValueAt(0, 0)).longValue()) > 0) {
            clientePremiacionConcurso.setPremioDespachado(true);
        } else {
            clientePremiacionConcurso.setPremioDespachado(false);
        }
         
        
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarClientePremi"
            +"acionConcurso(ClientePremiacionConcurso clientePremiacionConcur"
            +"so, ClientePremiacion clientePremiacion):Salida");
    }


    /**
     * @author Dante Castiglione
     */
    public void getPedidosRecomendante(ClientePremiacion clientePremiacion,
        ClientePremiacionConcurso clientePremiacionConcurso)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.getPedidosRecomendan"
            +"te(ClientePremiacion clientePremiacion, ClientePremiacionConcur"
            +"so clientePremiacionConcurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //se agrego el periodo
            //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
            query.append(" SELECT  ");
            query.append(" IMP_MONT_PEDI,  ");
            query.append(" NUM_UNID_PEDI, ");
            query.append(" IND_PEDI_VALI , P1.OID_PERI, P1.FEC_INIC, P1.FEC_FINA ");
            query.append(" ,IMP_MONT_RETL "); // sapaza -- PER-SiCC-2012-0712 -- 06/05/2013
            query.append(
                " FROM INC_PEDID_CONCU_RECOM pcr, INC_CLIEN_RECTE recte, cra_perio p1 ");
            query.append(" WHERE pcr.COPA_OID_PARA_GRAL = " +
                clientePremiacionConcurso.getOidConcurso().longValue());
            query.append(" AND pcr.CLR3_OID_CLIE_RETE = recte.OID_CLIE_RETE ");
            query.append(" AND recte.CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());
            query.append(" AND pcr.CLRE_OID_CLIE_REDO IS NULL  ");
            query.append(" AND PCR.PERD_OID_PERI = P1.OID_PERI ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("respuesta " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        for (int i = 0; i < respuesta.getRowCount(); i++) {
            UtilidadesLog.debug("nuevo un pedidoRecomendacion");

            PedidoRecomendacion pedidoRecomendacion =  new PedidoRecomendacion();

            //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
            Periodo periodo = new Periodo();
            Long oidPeriIniVin = new Long(respuesta.getValueAt(i, "OID_PERI").toString()); 
            periodo.setFechaDesde((Date) respuesta.getValueAt(i, "FEC_INIC"));
            periodo.setFechaHasta((Date) respuesta.getValueAt(i, "FEC_FINA"));
            periodo.setOidPeriodo(oidPeriIniVin);  
            pedidoRecomendacion.setPeriodo(periodo);
            
            BigDecimal monto = (BigDecimal) respuesta.getValueAt(i,
                    "IMP_MONT_PEDI");
            pedidoRecomendacion.setMontoPedido((monto != null)
                ? monto : new BigDecimal(0));

            {
                BigDecimal unidades = (BigDecimal) respuesta.getValueAt(i,
                        "NUM_UNID_PEDI");
                pedidoRecomendacion.setUnidadesPedido((unidades != null)
                    ? new Long(unidades.longValue()) : new Long(0));
            }

            // sapaza -- PER-SiCC-2012-0712 -- 06/05/2013
            BigDecimal montoRetail = (BigDecimal) respuesta.getValueAt(i,
                    "IMP_MONT_RETL");
            pedidoRecomendacion.setMontoRetail((montoRetail != null)
                ? montoRetail : new BigDecimal(0));
                
            UtilidadesLog.debug("Inserto un pedidoRecomendacion valido" +
                pedidoRecomendacion.getValido());
            clientePremiacionConcurso.getPedidosRecomendacion()
                .add(pedidoRecomendacion);
        }

        UtilidadesLog.debug(
            "clientePremiacionConcurso.getPedidosRecomendacion() " +
            clientePremiacionConcurso.getPedidosRecomendacion());
        UtilidadesLog.info("DAOClientePremiacionConcurso.getPedidosRecomendant"
            +"e(ClientePremiacion clientePremiacion, ClientePremiacionConcurso"
            +"clientePremiacionConcurso):Salida");
    }

    /**
     * @author Dante Castiglione
     */
    public void getPedidosRecomendados(ClientePremiacion clientePremiacion,
        ClientePremiacionConcurso clientePremiacionConcurso,
        java.util.ArrayList recomendados) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.getPedidosRecomendado"
            +"s(ClientePremiacion clientePremiacion, ClientePremiacionConcurso"
            +"clientePremiacionConcurso, java.util.ArrayList recomendados):"
            +"Entrada");

        //1.-Se accede a la entidad PedidoConcursoRecomendacion filtrando por: 
        //oidConcurso: clientePremiacionConcurso.oidConcurso 
        //oidClienteRecomendante: clientePremiacion.oidCliente 
        //oidClienteRecomendando: todos los recomendados[].oid 
        //2.- Los resultados se agrupan por oidClinete recomendados. 
        //3.- Por cada registro recuperado se crea una instancia del objeto
        //pedidoConcursoRecomendacion, se rellenan sus atributos y se insertan
        //en el arrayList recomendados[].pedidosRecomendacion que cumpla
        // => registroRecuperado.oidClienteRecomendado=recomendados[]
        //.oidClienteRecomendado 
        
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();
        int corte = 1000;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //BELC300019833
            UtilidadesLog.debug(" ** recomendados " + recomendados);

            if ((recomendados != null) && (recomendados.size() > 0)) {
                //se agrego el periodo
                //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                query.append("  SELECT  ");
                query.append(" pcr.IMP_MONT_PEDI,  ");
                query.append(" pcr.NUM_UNID_PEDI,  ");
                query.append(" recdo.OID_CLIE_REDO,  ");
                query.append(" pcr.IND_PEDI_VALI, P1.OID_PERI, P1.FEC_INIC, P1.FEC_FINA ");
                query.append(" ,pcr.IMP_MONT_RETL "); // sapaza -- PER-SiCC-2012-0712 -- 06/05/2013
                query.append(" FROM INC_PEDID_CONCU_RECOM pcr, ");
                query.append(" INC_CLIEN_RECTE recte, inc_clien_recdo recdo, cra_perio p1 ");
                query.append(" WHERE pcr.COPA_OID_PARA_GRAL = " +
                    clientePremiacionConcurso.getOidConcurso());
                query.append(
                    " AND pcr.CLR3_OID_CLIE_RETE = recte.OID_CLIE_RETE ");
                query.append(" AND PCR.PERD_OID_PERI = P1.OID_PERI ");
                
                query.append(" AND recte.CLIE_OID_CLIE = " +
                    clientePremiacion.getOidCliente());
                query.append(
                    " AND pcr.CLRE_OID_CLIE_REDO = recdo.OID_CLIE_REDO ");

                if (recomendados.size() <= corte) {
                    query.append(" AND recdo.OID_CLIE_REDO IN ( ");

                    for (int index = 0; index < recomendados.size(); index++) {
                        Long oid = ((ClientePremiacionRecomendado) 
                            recomendados.get(index)).getOidClienteRecomendado();
                        query.append(oid);

                        if ((index != (recomendados.size() - 1))) {
                            query.append(", ");
                        }
                    }

                    query.append(" ) ");
                } else {
                    query.append(" AND ( recdo.OID_CLIE_REDO IN ( ");

                    for (int index = 0; index < recomendados.size(); index++) {
                        Long oid = ((ClientePremiacionRecomendado) 
                            recomendados.get(index))
                                .getOidClienteRecomendado();
                        query.append(oid);

                        if ((index != (recomendados.size() - 1)) &&
                                (((index + 1) % corte) != 0)) {
                            query.append(",");
                        } else {
                            if (index != (recomendados.size() - 1)) {
                                query.append(" ) OR recdo.OID_CLIE_REDO IN (");
                            }
                        }
                    }

                    query.append(" ) )");
                }

                respuesta = bs.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("*** respuesta *** " + respuesta);
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
        DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
        Concurso concurso = despacharPremiosHelper.obtenerConcurso(clientePremiacionConcurso.getOidConcurso());

        for (int i = 0; i < respuesta.getRowCount(); i++) {
            UtilidadesLog.debug("*** nuevo  pedidoRecomendacion ***");

            PedidoRecomendacion pedidoRecomendacion = new PedidoRecomendacion();

            //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
            Periodo periodo = new Periodo();
            Long oidPeriIniVin = new Long(respuesta.getValueAt(i, "OID_PERI").toString()); 
            periodo.setFechaDesde((Date) respuesta.getValueAt(i, "FEC_INIC"));
            periodo.setFechaHasta((Date) respuesta.getValueAt(i, "FEC_FINA"));
            periodo.setOidPeriodo(oidPeriIniVin);  
            ClientePremiacionRecomendado clienteRecomendado;


            BigDecimal monto = (BigDecimal) respuesta.getValueAt(i,
                    "IMP_MONT_PEDI");
            pedidoRecomendacion.setMontoPedido((monto != null)
                ? monto : new BigDecimal(0));

            {
                BigDecimal unidades = (BigDecimal) respuesta.getValueAt(i,
                        "NUM_UNID_PEDI");
                pedidoRecomendacion.setUnidadesPedido((unidades != null)
                    ? new Long(unidades.longValue()) : new Long(0));
            }

            // sapaza -- PER-SiCC-2012-0712 -- 06/05/2013
            BigDecimal montoRetail = (BigDecimal) respuesta.getValueAt(i,
                    "IMP_MONT_RETL");
            pedidoRecomendacion.setMontoRetail((montoRetail != null)
                ? montoRetail : new BigDecimal(0));
            
            Long oidRecom = new Long(((BigDecimal) respuesta.getValueAt(i,
                        "OID_CLIE_REDO")).longValue());
            UtilidadesLog.debug("*** oidRecom *** " + oidRecom);

            Long oid = null;

            // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
            for (int index = 0; index < recomendados.size(); index++) {
                clienteRecomendado = ((ClientePremiacionRecomendado) clientePremiacionConcurso .getRecomendados().get(index));
                
                oid = clienteRecomendado.getOidClienteRecomendado();
                UtilidadesLog.debug("*** oid *** " + oid);
                
                if (oidRecom.equals(oid)) {
                     if ((!clientePremiacion.getPeriodo().mayorQue(clienteRecomendado.getPeriodoFinVinculo())) &&
                          (!clientePremiacion.getPeriodo().menorQue(clienteRecomendado.getPeriodoInicioVinculo()))) {
                          
                        if ((!periodo.mayorQue(clienteRecomendado.getPeriodoFinVinculo())) &&
                             (!periodo.menorQue(clienteRecomendado.getPeriodoInicioVinculo()))) {
        
                            // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
                            if(concurso.getIndTipoEvaluacion() != null) {
                                Integer cantidadPeriodos = periodo.calcularCantidadPeriodos(clienteRecomendado.getPeriodoInicioVinculo().getOidPeriodo(),
                                                            periodo.getOidPeriodo());
                                pedidoRecomendacion.setSecuencia(cantidadPeriodos);                            
                            }
                                                
                            
                            UtilidadesLog.debug("Premio elegido" + clienteRecomendado.getPremioElegido());
            
                            
                            UtilidadesLog.debug("*** pongo nuevo  pedidoRecomendacion ***");
                            clienteRecomendado.getPedidosRecomendacion().add(pedidoRecomendacion);
                            UtilidadesLog.debug("Premio elegido 22 " +clienteRecomendado.getPremioElegido());
                        }
                    }    
                }    
            }

            UtilidadesLog.debug(
                "*** clientePremiacionConcurso.getPedidosRecomendacion() *** " +
                clientePremiacionConcurso.getRecomendados());
        }

        UtilidadesLog.info( "DAOClientePremiacionConcurso.getPedidosRecomenda"
            +"dos(ClientePremiacion clientePremiacion, ClientePremiacionConcur"
            +"so clientePremiacionConcurso, java.util.ArrayList recomendados)"
            +":Salida");
    }

    /**
     * @author Dante Castiglione
     */
    public void getRecomendados(ClientePremiacion clientePremiacion,
        ClientePremiacionConcurso clientePremiacionConcurso)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.getRecomendados(Clie"
            +"ntePremiacion clientePremiacion, ClientePremiacionConcurso cli"
            +"entePremiacionConcurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT  ");
            // Modificado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
            query.append(" A.OID_CLIE_REDO, PANP_OID_PARA_NIVE_PREM, A.NUM_PREM, ");
            query.append(" B.OID_CLIE_RETE,  ");
            // vbongiov -- 20/07/2006 -- inc DBLG500001048
            query.append(" mae_cli.COD_CLIE, mae_cli.VAL_NOM1, mae_cli.VAL_NOM2,  "); 
            query.append(" mae_cli.VAL_APE1, mae_cli.VAL_APE2, "); 
            query.append(" per.COD_PERI, "); 
            //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
            query.append(" cra.FEC_INIC, "); 
            query.append(" cra.FEC_FINA, "); 
            query.append(" cra.CANA_OID_CANA, "); 
            query.append(" cra.MARC_OID_MARC, "); 
            query.append(" cra.PAIS_OID_PAIS, ");        
            query.append(" cra.OID_PERI ");
            //jrivas 22/8/2008 20080580
            query.append(" , A.CLIE_OID_CLIE ");            
            query.append(" FROM INC_CLIEN_RECDO A,  ");
            query.append(" INC_CLIEN_RECTE      B,  MAE_CLIEN mae_cli,");
            query.append(" CRA_PERIO cra, SEG_PERIO_CORPO per");
            query.append(" WHERE A.CLR3_OID_CLIE_RETE = B.OID_CLIE_RETE  ");
            query.append(" AND B.COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());
            query.append(" AND B.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
            query.append(" AND A.CLIE_OID_CLIE = mae_cli.OID_CLIE  ");
            query.append(" AND cra.OID_PERI = A.PERD_OID_PERI  ");
            query.append(" AND cra.PERI_OID_PERI = per.OID_PERI  ");            
            // vbongiov -- 9/01/2007 -- DBLG500001077
            if(clientePremiacion.getIndAnulacion()){
                query.append(" AND IND_EFEC = 1 ");
            } else {
                //jrivas 2/8/2006 DBLG50001117
                query.append(" AND (IND_EFEC <> 1 OR IND_EFEC IS NULL) ");
            }
            
            //jrivas 20080535
            query.append(" AND (A.IND_EVAL <> 1 OR A.IND_EVAL IS NULL)");
            
            
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** getRecomendados " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        DatosPersonales datPerso = null;
        Periodo periodo = null;

        for (int i = 0; i < respuesta.getRowCount(); i++) {
            UtilidadesLog.debug("*** nuevo clientePremiacionRecomendado ***");

            ClientePremiacionRecomendado clientePremiacionRecomendado = 
                new ClientePremiacionRecomendado();
            clientePremiacionRecomendado.setOidClienteRecomendado(new Long(
                    ((BigDecimal) respuesta.getValueAt(i, "OID_CLIE_REDO"))
                        .longValue()));
                        
            //jrivas 22/8/2008 20080580                        
            clientePremiacionRecomendado.setOidCliente(new Long(((BigDecimal) respuesta.getValueAt(i, "CLIE_OID_CLIE")).longValue()));                          

            //jrivas 25/8/2005
            //inc 20713
            BigDecimal nivel = (BigDecimal) respuesta.getValueAt(i, "PANP_OID_PARA_NIVE_PREM");

            if (nivel != null) {
                // Modificado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
                BigDecimal numPremio = (BigDecimal)respuesta.getValueAt(i,"NUM_PREM");
                clientePremiacionRecomendado.setPremioElegido(
                    recuperarPremioPorNivel(new Long(nivel.longValue()), numPremio ) );
                UtilidadesLog.debug(
                    "**** clientePremiacionRecomendado.setPremioElegido( *** " +
                    clientePremiacionRecomendado.getPremioElegido());
            }
            
            // vbongiov -- 20/07/2006 -- inc DBLG500001048
            datPerso = new DatosPersonales();
            
            datPerso.setNombre1((String) respuesta.getValueAt(i,"VAL_NOM1"));
            datPerso.setNombre2((String) respuesta.getValueAt(i,"VAL_NOM2"));
            datPerso.setApellido1((String) respuesta.getValueAt(i,"VAL_APE1"));
            datPerso.setApellido2((String) respuesta.getValueAt(i,"VAL_APE2"));
            datPerso.setCodCliente((String) respuesta.getValueAt(i,"COD_CLIE"));
            
            clientePremiacionRecomendado.setDatosPersonales(datPerso);
            
            // Periodo Inicio Vinculo 
            //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
            //------------------------------------------------------    
            Concurso concursoObj = despacharPremiosHelper.obtenerConcurso(clientePremiacionConcurso.getOidConcurso());
            periodo = new Periodo();

            periodo.setCodperiodo((String) respuesta.getValueAt(i, "COD_PERI"));
            periodo.setFechaDesde((Date) respuesta.getValueAt(i, "FEC_INIC"));
            periodo.setFechaHasta((Date) respuesta.getValueAt(i, "FEC_FINA"));
            periodo.setOidCanal(new Long(((BigDecimal) respuesta.getValueAt(i,"CANA_OID_CANA")).longValue()));
            periodo.setOidMarca(new Long(((BigDecimal) respuesta.getValueAt(i,"MARC_OID_MARC")).longValue()));
            periodo.setOidPais(new Long( ((BigDecimal) respuesta.getValueAt(i,"PAIS_OID_PAIS")).longValue()));
            periodo.setOidPeriodo(new Long(((BigDecimal)respuesta.getValueAt(i, "OID_PERI")).longValue()));
            clientePremiacionRecomendado.setPeriodoInicioVinculo(periodo);

            StringBuffer query2 = new StringBuffer();
            RecordSet rs2 = new RecordSet();

            query2.append(" SELECT p.oid_peri OIDPERIODOFIN, ");
            query2.append(" p.fec_inic FECHAINIPERIODOFIN, ");
            query2.append(" p.fec_fina FECHAFINPERIODOFIN, ");
            query2.append(" pc.cod_peri CODIGOPERIODOFIN, ");
            query2.append(" p.pais_oid_pais PAISPERIODOFIN, ");
            query2.append(" p.marc_oid_marc MARCAPERIODOFIN, ");
            query2.append(" p.cana_oid_cana CANALPERIODOFIN");
            query2.append(" FROM cra_perio pent, cra_perio p, ");
            query2.append(" seg_perio_corpo pc ");
            query2.append(" WHERE pent.oid_peri = ").append(periodo.getOidPeriodo());
            query2.append(" AND p.fec_inic >= pent.fec_inic ");
            query2.append(" AND pc.oid_peri = p.peri_oid_peri ");
            query2.append(" AND p.pais_oid_pais =  ");
            query2.append(" pent.pais_oid_pais ");
            query2.append(" AND p.marc_oid_marc =  ");
            query2.append(" pent.marc_oid_marc ");
            query2.append(" AND p.cana_oid_cana =  ");
            query2.append(" pent.cana_oid_cana ");
            query2.append(" ORDER BY p.fec_inic, pc.cod_peri, p.fec_fina ");
            try {
                rs2 = bs.dbService.executeStaticQuery(query2.toString());
                UtilidadesLog.debug("******* rs2 " + rs2);
                
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError
                            .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            //jrivas Brecha INC 15 20/6/2008
            //int numePeriodEvalu = concursoObj.getNumeroPeriodosAEvaluar().intValue();
            //int numePeriodEvalu = concursoObj.getNumeroPeriodosAEvaluar().intValue() - 1;
            
            // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
            int numePeriodEvalu = concursoObj.getNumeroPeriodosVinculo().intValue() - 1;
            
            if (!rs2.esVacio() && (rs2.existeFila(numePeriodEvalu))) {
                UtilidadesLog.debug("Existe fila periodoFinVinculo");

                Periodo periodoFinVinculo = new Periodo();                            

                BigDecimal bdOidPerEva = (BigDecimal) rs2.getValueAt(numePeriodEvalu,"OIDPERIODOFIN");
                Date fechaInicioPerEva = (Date) rs2.getValueAt(numePeriodEvalu, "FECHAINIPERIODOFIN");
                Date fechaFinPerEva = (Date) rs2.getValueAt(numePeriodEvalu, "FECHAFINPERIODOFIN");
                String codigoPerEva = (String) rs2.getValueAt(numePeriodEvalu, "CODIGOPERIODOFIN");
                BigDecimal paisPerEva = (BigDecimal) rs2.getValueAt(numePeriodEvalu, "PAISPERIODOFIN");
                BigDecimal marcaPerEva = (BigDecimal) rs2.getValueAt(numePeriodEvalu,"MARCAPERIODOFIN");
                BigDecimal canalPerEva = (BigDecimal)rs2.getValueAt(numePeriodEvalu, "CANALPERIODOFIN");

                //Seteo de valores para periodo fin
                periodoFinVinculo.setOidPeriodo(new Long(bdOidPerEva.longValue()));
                periodoFinVinculo.setFechaDesde(fechaInicioPerEva);
                periodoFinVinculo.setFechaHasta(fechaFinPerEva);
                periodoFinVinculo.setCodperiodo(codigoPerEva);
                periodoFinVinculo.setOidPais(new Long(paisPerEva.longValue()));
                periodoFinVinculo.setOidMarca(new Long(marcaPerEva.longValue()));
                periodoFinVinculo.setOidCanal(new Long(canalPerEva.longValue()));

                clientePremiacionRecomendado.setPeriodoFinVinculo(periodoFinVinculo);
            } else {
                UtilidadesLog.debug("no Existe fila periodoFinVinculo");
                clientePremiacionRecomendado.setPeriodoFinVinculo(null);
            }
            //------------------------------------------------------    

            clientePremiacionConcurso.getRecomendados().add(
                clientePremiacionRecomendado);
            UtilidadesLog.debug(
                "*** clientePremiacionConcurso.getRecomendados() *** " +
                clientePremiacionConcurso.getRecomendados());
        }

        getPedidosRecomendados(clientePremiacion, clientePremiacionConcurso,
            clientePremiacionConcurso.getRecomendados());
        UtilidadesLog.info(
            "DAOClientePremiacionConcurso.getRecomendados(ClientePremiacion "
                +"clientePremiacion, ClientePremiacionConcurso clientePremia"
                +"cionConcurso):Salida");
    }


    /**
     * @author
     */
     public PremiosElegidos getPremiosElegidos(Long oidCliente, Long oidConcurso, Long oidPeriodo)
         throws MareException {
         UtilidadesLog.info(
             "DAOClientePremiacionConcurso.getPremiosElegidos(Long oidCliente,"
             +"Long oidConcurso):Entrada");

         //ArrayList premiosElegidos = new ArrayList();
         //jrivas 28/11/2008 20080783
         PremiosElegidos premiosElegidos = new PremiosElegidos(); 
         
         BelcorpService bs1;
         RecordSet respuesta1;
         StringBuffer query1 = new StringBuffer();

         try {
             bs1 = BelcorpService.getInstance();
         } catch (MareMiiServiceNotFoundException e) {
             UtilidadesLog.error("ERROR ", e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }

         try {
             query1.append(" SELECT ");
             query1.append(" TPRE_OID_TIPO_PREM, ");
             query1.append(" pnp.NUM_NIVE, ");
             query1.append(" NUM_CANT_FIJA_PUNT, ");
             query1.append(" NUM_CANT_INIC_PUNT, ");
             query1.append(" NUM_CANT_FINA_PUNT, ");
             query1.append(" OID_PARA_NIVE_PREM, ");
             query1.append(" NUM_PUNT_PROD_EXIG, ");
             query1.append(" pgp.PERD_OID_PERI, ");
             query1.append(" cp.MARC_OID_MARC, ");
             query1.append(" cp.CANA_OID_CANA, ");
             query1.append(" cp.PAIS_OID_PAIS, ");
             // vbongiov -- 5/07/2006 -- inc 723
             query1.append(" V.VAL_I18N descTipoPremio,  ");
             //jrivas 18/7/2006 DBLG5000991
             query1.append(" NUM_PREM ");
             //jrivas 28/11/2008 20080783
             query1.append(", pe.OID_PREM_ELEG ");            
             
             // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
             query1.append(", pgp.COPA_OID_PARA_GRAL ");            
             query1.append(", NVL(pnp.VAL_NIVE_SELE, 0) VAL_NIVE_SELE ");            
             
             query1.append(" FROM INC_PREMI_ELEGI pe, ");
             query1.append(" INC_PARAM_NIVEL_PREMI pnp, ");
             query1.append(" INC_PARAM_GENER_PREMI pgp, ");
             query1.append(" INC_CONCU_PARAM_GENER conc, CRA_PERIO cp, ");
             query1.append(" V_GEN_I18N_SICC V ");
             query1.append(" WHERE PANP_OID_PARA_NIVE_PREM = OID_PARA_NIVE_PREM ");
             query1.append(" AND CLIE_OID_CLIE = " + oidCliente);
             query1.append(" AND pe.COPA_OID_PARA_GRAL = " + oidConcurso);
             query1.append(" AND pnp.PAGP_OID_PARA_GENE_PREM = pgp.OID_PARA_GENE_PREM ");
             query1.append(" AND conc.OID_PARA_GRAL = pgp.COPA_OID_PARA_GRAL ");
             query1.append(" AND conc.PERD_OID_PERI_DESD = OID_PERI ");
             query1.append(" AND V.VAL_OID = TPRE_OID_TIPO_PREM ");
             query1.append(" AND V.ATTR_NUM_ATRI = 1  ");
             query1.append(" AND V.ATTR_ENTI = 'INC_TIPO_PREMI' ");
             query1.append(" AND V.IDIO_OID_IDIO = " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
             //jrivas 28/11/2008 20080783
             query1.append(" AND IND_PEND = 1 ");
             query1.append(" AND (pe.PERD_OID_PERI_IATN IS NULL OR pe.PERD_OID_PERI_IATN <= " + oidPeriodo + ")");

             respuesta1 = bs1.dbService.executeStaticQuery(query1.toString());
             UtilidadesLog.debug("*** respuesta1: " + respuesta1);
         } catch (Exception e) {
             UtilidadesLog.error("ERROR ", e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }

         NivelPremiacion nivelPre = new NivelPremiacion();
         Periodo periodoDespacho = new Periodo();
         
         String descTipoPremio = null;
         if (respuesta1.esVacio()) {
             UtilidadesLog.info("DAOClientePremiacionConcurso.getPremiosElegidos(Long oidCliente, Long oidConcurso):Salida");
             return premiosElegidos;
         }
         
         //jrivas 28/11/2008 20080783
         for(int i = 0; i < respuesta1.getRowCount(); i++){
             
             //jrivas 12/5/2009  20090911
             nivelPre = new NivelPremiacion();
             
             // vbongiov -- 5/07/2006 -- inc 723
             descTipoPremio = (String) respuesta1.getValueAt(i, "DESCTIPOPREMIO");
             
             nivelPre.setNivel((respuesta1.getValueAt(i, "NUM_NIVE") != null) ? new Integer(
                     ((BigDecimal) respuesta1.getValueAt(i, "NUM_NIVE")).intValue()): null);
             nivelPre.setOidNivel((respuesta1.getValueAt(i, "OID_PARA_NIVE_PREM") != null)
                 ? new Long(((BigDecimal)  respuesta1.getValueAt(i, "OID_PARA_NIVE_PREM")).longValue()): null);
             nivelPre.setCantidadFijaPuntos((respuesta1.getValueAt(i, "NUM_CANT_FIJA_PUNT") != null)
                 ? new Double(((BigDecimal)  respuesta1.getValueAt(i, "NUM_CANT_FIJA_PUNT")).doubleValue()): new Double(0));
             nivelPre.setCantidadInicialPuntos((respuesta1.getValueAt(i,"NUM_CANT_INIC_PUNT") != null)
                 ? new Double(((BigDecimal) respuesta1.getValueAt(i, "NUM_CANT_INIC_PUNT")).doubleValue()): new Double(0));
             nivelPre.setCantidadFinalPuntos((respuesta1.getValueAt(i,"NUM_CANT_FINA_PUNT") != null)
                 ? new Double(((BigDecimal)respuesta1.getValueAt(i, "NUM_CANT_FINA_PUNT")).doubleValue()) : new Double(0));

             if (respuesta1.getValueAt(i, "PERD_OID_PERI") != null) {
                 periodoDespacho.setOidPeriodo(new Long(((BigDecimal) respuesta1.getValueAt(i, "PERD_OID_PERI")).longValue()));
             }

             long tipoPremioLeido = ((BigDecimal) respuesta1.getValueAt(i,"TPRE_OID_TIPO_PREM")).longValue();
             long oidNivelPremiacion = ((BigDecimal) respuesta1.getValueAt(i,"OID_PARA_NIVE_PREM")).longValue();
             BigDecimal puntosObtenerProdExigidos = (BigDecimal) respuesta1.getValueAt(i,"NUM_PUNT_PROD_EXIG");

             // Begin IF procesar premio articulo lote
             if (tipoPremioLeido == ConstantesINC.TIPO_PREMIO_ARTICULO.longValue()){
                 //jrivas 18/7/2006 DBLG5000991
                 BigDecimal numeroPremio = (BigDecimal) respuesta1.getValueAt(i,"NUM_PREM");
                 PremioArticuloLote premioArticuloLote = new PremioArticuloLote();
                 PremioArticulo premioArticulo = new PremioArticulo();
                 premioArticuloLote.setNivel(nivelPre);
                 premioArticuloLote.setTipoPremio(new Long(tipoPremioLeido));
                 // vbongiov -- 5/07/2006 -- inc 723
                 premioArticuloLote.setDescripcionTipoPremio(descTipoPremio);
                 
                 // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
                 Long oidConcursoAux = new Long(((BigDecimal) respuesta1.getValueAt(i, "COPA_OID_PARA_GRAL")).longValue());
                 if(oidConcurso.longValue() != oidConcursoAux.longValue()) {
                     premioArticuloLote.setCodMotivoInvalido(new Integer(1));
                     premiosElegidos.almacenarPremioElegido(premioArticuloLote);
                     continue;
                 }
                 
                 premioArticuloLote.setPeriodoDeDespacho(periodoDespacho);
                 premioArticuloLote.setPuntosObtenerProdExigidos((puntosObtenerProdExigidos != null)
                     ? new Double(puntosObtenerProdExigidos.doubleValue()): new Double(0));
                 //jrivas 28/11/2008 20080783
                 premioArticuloLote.setIndPendiente(true);
                 premioArticuloLote.setOidPremioElegido(new Long(((BigDecimal) respuesta1.getValueAt(i, "OID_PREM_ELEG")).longValue()));
     
                 BelcorpService bs4;
                 RecordSet respuesta4;
                 StringBuffer query4 = new StringBuffer();
     
                 try {
                     bs4 = BelcorpService.getInstance();
                 } catch (MareMiiServiceNotFoundException e) {
                     UtilidadesLog.error("ERROR ", e);
                     throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                 }
     
                 try {
                     /* INC 001 - gPineda - 13/01/2007
                     * Se agrega la recuperacion del atributo VAL_DESC_LOTE_PREM_ARTI. (2)
                     */
                     query4.append(" SELECT ");
                     query4.append(" NUM_UNID, NUM_LOTE, ");
                     query4.append(" NUM_PREM, ");
                     query4.append(" OID_LOTE_PREM_ARTI ");
                     query4.append(" ,INC_LOTE_PREMI_ARTIC.VAL_DESC_LOTE_PREM_ARTI"); //(2)
                     query4.append(" FROM INC_PREMI_ARTIC, ");
                     query4.append(" INC_LOTE_PREMI_ARTIC ");
                     query4.append(" WHERE PRAR_OID_PREM_ARTI = OID_PREM_ARTI ");
                     query4.append(" AND PANP_OID_PARA_NIVE_PREM = " + oidNivelPremiacion);
                     //jrivas 18/7/2006 DBLG5000991
                     query4.append(" AND NUM_PREM = " + numeroPremio);
                     query4.append(" ORDER BY NUM_LOTE ");  
                     
                     respuesta4 = bs4.dbService.executeStaticQuery(query4.toString());
                     UtilidadesLog.debug("*** respuesta4: " + respuesta4);
                 } catch (Exception e) {
                     UtilidadesLog.error("ERROR ", e);
                     throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                 }
     
                 if (!respuesta4.esVacio()) {
                     // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
                     Integer nivelElectivo = new Integer(((BigDecimal) respuesta1.getValueAt(i, "VAL_NIVE_SELE")).intValue());
                     if(nivelElectivo.intValue() == 0) {
                         premioArticuloLote.setCodMotivoInvalido(new Integer(4));
                         premiosElegidos.almacenarPremioElegido(premioArticuloLote);
                         continue;
                     }
                 
                     premioArticuloLote.setDescripcionLote((String) respuesta4.getValueAt(0, "VAL_DESC_LOTE_PREM_ARTI") );
                     premioArticuloLote.setNumeroLote(new Long(((BigDecimal) respuesta4.getValueAt(0, "NUM_LOTE")).longValue()));
                     premioArticuloLote.setNumeroPremio(new Long(((BigDecimal) respuesta4.getValueAt(0, "NUM_PREM")).longValue()));
                     premioArticulo.setNumeroUnidades(new Long(((BigDecimal) respuesta4.getValueAt(0, "NUM_UNID")).longValue()));
                     premioArticuloLote.setPremio(premioArticulo);
     
                     Long oidLotePremioArticulo = new Long(((BigDecimal)respuesta4.getValueAt(0, "OID_LOTE_PREM_ARTI")).longValue());
                     ArrayList articulos = new ArrayList();
     
                     BelcorpService bs7;
                     RecordSet respuesta7;
     
                     try {
                         bs7 = BelcorpService.getInstance();
                     } catch (MareMiiServiceNotFoundException e) {
                         UtilidadesLog.error("ERROR ", e);
                         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                     }
     
                     try {
                         //Brecha INC-003 6-9-07 jrivas
                         respuesta7 = bs7.dbService.executeStaticQuery(queryArticuloLote(oidLotePremioArticulo).toString());
                             
                         UtilidadesLog.debug("*** respuesta7: " + respuesta7);
                     } catch (Exception e) {
                         UtilidadesLog.error("ERROR ", e);
                         throw new MareException(e,
                             UtilidadesError.armarCodigoError(
                                 CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                     }
     
                     ArticuloLote articuloLote = null;
                     
                     if (!respuesta7.esVacio()) {
                     
                         int cant7 = respuesta7.getRowCount();
                         for(int i7=0; i7 < cant7; i7++) {
                             articuloLote = new ArticuloLote();
                             
                             articuloLote.setNombre((String)respuesta7.getValueAt(i7, "DESCPRODU"));
                             
                             articuloLote.setNumeroUnidades(new Long(((BigDecimal) respuesta7.getValueAt(i7, "NUM_UNID")).longValue()));
                             articuloLote.setCodigoVentaFicticio(respuesta7.getValueAt(i7, "COD_VENT_FICT").toString());
                             articuloLote.setOidCodigoProducto(new Long(((BigDecimal) respuesta7.getValueAt(i7, "PROD_OID_PROD")).longValue()));
                             articuloLote.setPrecioPublico((BigDecimal) respuesta7.getValueAt(i7, "IMP_PREC_PUBL"));
                             articuloLote.setCodSapProducto((String)     respuesta7.getValueAt(i7, "COD_SAP")); 
                             articuloLote.setTipoEntregaPremio(respuesta7.getValueAt(i7, "IND_TIPO_ENTR_PREM").toString()); 
                             if (respuesta7.getValueAt(i7, "COD_CENT_SERV") != null) {
                                 articuloLote.setCodigoCentroServicio((String) respuesta7.getValueAt(i7, "COD_CENT_SERV")); 
                             } else {
                                 articuloLote.setCodigoCentroServicio(""); 
                             }
                             
                             if (respuesta7.getValueAt(i7, "DES_CENT_SERV") != null) {
                                 articuloLote.setDescripcionCentroServicio((String) respuesta7.getValueAt(i7, "DES_CENT_SERV")); 
                             } else {
                                 articuloLote.setDescripcionCentroServicio(""); 
                             }
                             
                             // vbongiov -- Cambio 20090828 -- 8/06/2009
                             articuloLote.setOidArticuloLote(new Long(((BigDecimal) respuesta7.getValueAt(i7, "OID_ARTI_LOTE")).longValue()));                                
                             
                             articulos.add(articuloLote);
                         }
                     }
                     premioArticuloLote.setArticulos(articulos);
                 } else {
                     premioArticuloLote.setCodMotivoInvalido(new Integer(1));
                 }
                 //premiosElegidos.add(premioArticuloLote);
                 premiosElegidos.almacenarPremioElegido(premioArticuloLote);
                 
             } // End IF procesar premio articulo lote

         }
         UtilidadesLog.info("DAOClientePremiacionConcurso.getPremiosElegidos("
             +"Long oidCliente, Long oidConcurso):Salida");

         return premiosElegidos;
     }

    /**
     * @author Dante Castiglione
     */
    public Premio recuperarPremioPorDefecto(Long nivel, Long oidConcurso)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremioPor"
            +"Defecto(Long nivel, Long oidConcurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //Brecha INC-003 6-9-07 jrivas            
            query.append(" SELECT   IMP_PREC_PUBL, COD_VENT_FICT, Z.PROD_OID_PROD, ");
            query.append("          B.NUM_UNID AS UNIDADES, Z.NUM_UNID AS UNIDADES_ARTICULO, A.NUM_LOTE, A.NUM_PREM, ");
            query.append("          A.OID_LOTE_PREM_ARTI, C.NUM_NIVE, C.OID_PARA_NIVE_PREM, C.NUM_CANT_FIJA_PUNT, ");
            query.append("          C.NUM_CANT_INIC_PUNT, C.NUM_CANT_FINA_PUNT, D.PERD_OID_PERI, C.VAL_PUNT_SERV, ");
            query.append("          C.NUM_PUNT_PROD_EXIG, CP.MARC_OID_MARC, CP.CANA_OID_CANA, CP.PAIS_OID_PAIS, ");
            query.append("          C.TPRE_OID_TIPO_PREM, B.NUM_UNID AS UNIDADES_PREMIO, ");
            query.append("          (SELECT V.VAL_I18N ");
            query.append("             FROM V_GEN_I18N_SICC V ");
            query.append("            WHERE V.VAL_OID = TPRE_OID_TIPO_PREM ");
            query.append("              AND V.IDIO_OID_IDIO =  " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
            query.append("              AND V.ATTR_NUM_ATRI = 1 ");
            query.append("              AND V.ATTR_ENTI = 'INC_TIPO_PREMI') AS DESC_TIPO_PREMIO, ");
            query.append("          (SELECT V.VAL_I18N ");
            query.append("             FROM V_GEN_I18N_SICC V ");
            query.append("            WHERE V.VAL_OID = PROD_OID_PROD ");
            query.append("              AND V.IDIO_OID_IDIO =  " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
            query.append("              AND V.ATTR_NUM_ATRI = 1 ");
            query.append("              AND V.ATTR_ENTI = 'MAE_PRODU') AS DESCPRODU, ");
            query.append("          PRODU.COD_SAP, A.VAL_DESC_LOTE_PREM_ARTI, IND_TIPO_ENTR_PREM, CS.COD_CENT_SERV, ");
            query.append("          CS.DES_CENT_SERV ");
            // vbongiov -- Cambio 20090828 -- 8/06/2009
            query.append(" , Z.OID_ARTI_LOTE ");
            query.append("     FROM INC_ARTIC_LOTE Z, ");
            query.append("          INC_LOTE_PREMI_ARTIC A, ");
            query.append("          INC_PREMI_ARTIC B, ");
            query.append("          INC_PARAM_NIVEL_PREMI C, ");
            query.append("          INC_PARAM_GENER_PREMI D, ");
            query.append("          INC_CONCU_PARAM_GENER CONC, ");
            query.append("          CRA_PERIO CP, ");
            query.append("          MAE_PRODU PRODU, ");
            query.append("          INC_CENTR_SERVI CS ");
            query.append("    WHERE PRAR_OID_PREM_ARTI = OID_PREM_ARTI ");
            query.append("      AND Z.PROD_OID_PROD = PRODU.OID_PROD ");
            query.append("      AND PANP_OID_PARA_NIVE_PREM = OID_PARA_NIVE_PREM ");
            query.append("      AND PAGP_OID_PARA_GENE_PREM = OID_PARA_GENE_PREM ");
            query.append("      AND CONC.PERD_OID_PERI_DESD = OID_PERI ");
            query.append("      AND PANP_OID_PARA_NIVE_PREM = " + nivel);
            query.append("      AND COPA_OID_PARA_GRAL = " + oidConcurso);
            query.append("      AND TPRE_OID_TIPO_PREM = " + ConstantesINC.OID_TIPO_PREMIO_ARTICULO);
            query.append("      AND LOPA_OID_LOTE_PREM_ARTI = OID_LOTE_PREM_ARTI ");
            query.append("      AND CONC.OID_PARA_GRAL = D.COPA_OID_PARA_GRAL ");
            query.append("      AND A.NUM_PREM = ");
            query.append("             (SELECT MIN (A.NUM_PREM) ");
            query.append("                FROM INC_LOTE_PREMI_ARTIC A, INC_PREMI_ARTIC B, INC_PARAM_NIVEL_PREMI C ");
            query.append("               WHERE PRAR_OID_PREM_ARTI = OID_PREM_ARTI ");
            query.append("                 AND PANP_OID_PARA_NIVE_PREM = " + nivel);
            query.append("                 AND TPRE_OID_TIPO_PREM = " + ConstantesINC.OID_TIPO_PREMIO_ARTICULO);
            query.append("                 AND PANP_OID_PARA_NIVE_PREM = OID_PARA_NIVE_PREM) ");
            query.append("      AND CESE_OID_CESE_ENTR = CS.OID_CENT_SERV(+) ");
            query.append(" ORDER BY NUM_PREM, PROD_OID_PROD ");

            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        NivelPremiacion nivelPre = new NivelPremiacion();
        Periodo periodoDespacho = new Periodo();
        String descTipoPremio = null;

        if (!respuesta.esVacio()) {
        
            // vbongiov -- 5/07/2006 -- inc 723
            descTipoPremio = (String) respuesta.getValueAt(0, "DESC_TIPO_PREMIO");
            
            nivelPre.setNivel((respuesta.getValueAt(0, "NUM_NIVE") != null)
                ? new Integer(
                    ((BigDecimal) respuesta.getValueAt(0, "NUM_NIVE"))
                        .intValue())
                : null);
            nivelPre.setOidNivel((
                respuesta.getValueAt(0, "OID_PARA_NIVE_PREM") != null)
                ? new Long(((BigDecimal) 
                    respuesta.getValueAt(0, "OID_PARA_NIVE_PREM")).longValue())
                : null);
            nivelPre.setCantidadFijaPuntos((respuesta.getValueAt(0,
                    "NUM_CANT_FIJA_PUNT") != null)
                ? new Double(((BigDecimal)
                    respuesta.getValueAt(0, "NUM_CANT_FIJA_PUNT"))
                        .doubleValue())
                : new Double(0));
            nivelPre.setCantidadInicialPuntos((respuesta.getValueAt(0,
                    "NUM_CANT_INIC_PUNT") != null)
                ? new Double(((BigDecimal) 
                    respuesta.getValueAt(0, "NUM_CANT_INIC_PUNT"))
                        .doubleValue())
                : new Double(0));
            nivelPre.setCantidadFinalPuntos((respuesta.getValueAt(0,
                    "NUM_CANT_FINA_PUNT") != null)
                ? new Double(((BigDecimal) 
                    respuesta.getValueAt(0, "NUM_CANT_FINA_PUNT"))
                        .doubleValue()): new Double(0));

            if (respuesta.getValueAt(0, "PERD_OID_PERI") != null) {
                periodoDespacho.setOidPeriodo(new Long(((BigDecimal) 
                    respuesta.getValueAt(0, "PERD_OID_PERI")).longValue()));
            } 

            // crear el premio articulo lote
            PremioArticuloLote premioArticuloLote = new PremioArticuloLote();
            PremioArticulo premioArticulo = new PremioArticulo();
            premioArticulo.setNumeroUnidades(new Long(
                    ((BigDecimal) respuesta.getValueAt(0, "UNIDADES"))
                        .longValue()));
            premioArticuloLote.setPremio(premioArticulo);
            premioArticuloLote.setDescripcionTipoPremio(descTipoPremio);

            premioArticuloLote.setActualizarGanadora(false);
            premioArticuloLote.setDespachado(false);
            premioArticuloLote.setListarGanador(false);

            premioArticuloLote.setNivel(nivelPre);
            premioArticuloLote.setPeriodoDeDespacho(periodoDespacho);
            
            premioArticuloLote.setNombre((String)respuesta.getValueAt(0, "DESCPRODU"));
            premioArticuloLote.setDescripcionLote( (String) respuesta.getValueAt(0, "VAL_DESC_LOTE_PREM_ARTI") );
                        
            premioArticuloLote.setNumeroLote(new Long(
                ((BigDecimal) respuesta.getValueAt(0, "NUM_LOTE"))
                    .longValue()));
            premioArticuloLote.setNumeroPremio(new Long(
                ((BigDecimal) respuesta.getValueAt(0, "NUM_PREM"))
                     .longValue()));
            premioArticuloLote.setOidPremio(new Long(((BigDecimal) 
                respuesta.getValueAt(0, "OID_LOTE_PREM_ARTI"))
                    .longValue()));

            {
                BigDecimal puntajeServicio = (BigDecimal) 
                    respuesta.getValueAt(0, "VAL_PUNT_SERV");
                premioArticuloLote.setPuntajeServicio((puntajeServicio != null)
                    ? new Double(puntajeServicio.doubleValue()) 
                        : new Double(0));
            }

            {
                BigDecimal puntosObtenerProdExigidos = (BigDecimal) 
                    respuesta.getValueAt(0, "NUM_PUNT_PROD_EXIG");
                premioArticuloLote.setPuntosObtenerProdExigidos((
                    puntosObtenerProdExigidos != null) ? new Double(
                        puntosObtenerProdExigidos.doubleValue())
                            : new Double(0));
            }

            premioArticuloLote.setRechazado(false);
            premioArticuloLote.setTipoPremio(new Long(((BigDecimal) 
                respuesta.getValueAt(0, "TPRE_OID_TIPO_PREM")).longValue()));
            premioArticuloLote.setUnidades((BigDecimal) respuesta.getValueAt(
                    0, "UNIDADES_PREMIO"));

            ArrayList articulos = new ArrayList();

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ArticuloLote articuloLote = new ArticuloLote();
                
                // DBLG500001023 - gPineda - 25/10/2006
                articuloLote.setNombre( (String) respuesta.getValueAt(i, "DESCPRODU") );
                
                articuloLote.setNumeroUnidades(new Long(
                        ((BigDecimal) respuesta.getValueAt(i,
                            "UNIDADES_ARTICULO")).longValue()));
                articuloLote.setCodigoVentaFicticio(respuesta.getValueAt(i,
                        "COD_VENT_FICT").toString());
                articuloLote.setOidCodigoProducto(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "PROD_OID_PROD"))
                            .longValue()));
                articuloLote.setPrecioPublico((BigDecimal) 
                    respuesta.getValueAt(i, "IMP_PREC_PUBL"));
                    
                articuloLote.setCodSapProducto((String)	respuesta.getValueAt(i, "COD_SAP")); 
                
                articuloLote.setTipoEntregaPremio(respuesta.getValueAt(i, "IND_TIPO_ENTR_PREM").toString()); 

                if (respuesta.getValueAt(i, "COD_CENT_SERV") != null) {
                    articuloLote.setCodigoCentroServicio((String) respuesta.getValueAt(i, "COD_CENT_SERV")); 
                } else {
                    articuloLote.setCodigoCentroServicio(""); 
                }
                
                if (respuesta.getValueAt(i, "DES_CENT_SERV") != null) {
                    articuloLote.setDescripcionCentroServicio((String) respuesta.getValueAt(i, "DES_CENT_SERV")); 
                } else {
                    articuloLote.setDescripcionCentroServicio(""); 
                }
                
                // vbongiov -- Cambio 20090828 -- 8/06/2009
                articuloLote.setOidArticuloLote(new Long(((BigDecimal) respuesta.getValueAt(i, "OID_ARTI_LOTE")).longValue()));                                
                
                articulos.add(articuloLote);
            }

            premioArticuloLote.setArticulos(articulos);
            UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremioP"
                +"orDefecto(Long nivel, Long oidConcurso):Salida");

            return premioArticuloLote;
        } else {
            UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPremioPo"
                +"rDefecto(Long nivel, Long oidConcurso):Salida");

            return null;
        }
    }

    /**
     * @author Dante Castiglione
     */
    public String recuperarSumaMontoPedidos(Long oidCliente,
        Long oidRecomendado, Concurso concurso) throws MareException {
        UtilidadesLog.info(
            "DAOClientePremiacionConcurso.recuperarSumaMontoPedidos(Long "
                +"oidRecomendante, Long oidRecomendado, Concurso concurso)"
                +":Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ");
            query.append(" SUM (IMP_MONT_PEDI) AS SUMA_MONTO_PEDIDO ");
            query.append(" FROM INC_PEDID_CONCU_RECOM ped,  INC_CLIEN_RECTE cliR ");
            query.append(" WHERE cliR.COPA_OID_PARA_GRAL = ped.COPA_OID_PARA_GRAL ");
            query.append(" AND cliR.CLIE_OID_CLIE =  " +  oidCliente.longValue());
            query.append(" AND ped.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso().longValue());
            query.append(" AND ped.CLR3_OID_CLIE_RETE = cliR.OID_CLIE_RETE ");
            query.append(" AND ped.CLRE_OID_CLIE_REDO = " +  oidRecomendado.longValue());
            
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuesta.getValueAt(0, "SUMA_MONTO_PEDIDO") != null) {
            UtilidadesLog.info(
                "DAOClientePremiacionConcurso.recuperarSumaMontoPedidos(Long "
                    +"oidRecomendante, Long oidRecomendado, Concurso concurso)"
                    +":Salida SUMA " + respuesta.getValueAt(0, "SUMA_MONTO_PEDIDO"));

            return ((BigDecimal) respuesta.getValueAt(0, "SUMA_MONTO_PEDIDO"))
                .toString();
        } else {
            UtilidadesLog.info(
                "DAOClientePremiacionConcurso.recuperarSumaMontoPedidos(Long "
                    +"oidRecomendante, Long oidRecomendado, Concurso concurso)"
                    +":Salida NULL");

            return null;
        }
    }

    /**
     * @author
     */
    public String recuperarCodigoMensajeObtencion(Long oidConcurso)
        throws MareException {
        UtilidadesLog.info(
            "DAOClientePremiacionConcurso.recuperarCodigoMensajeObtencion(Long"
                +"oidConcurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ");
            query.append(" COD_MENS ");
            query.append(" FROM INC_OBTEN_PUNTO, ");
            query.append(" MSG_MENSA ");
            query.append(" WHERE COPA_OID_PARA_GRAL = " +
                oidConcurso.longValue());
            query.append(" AND MENS_OID_MENS = OID_MENS ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!respuesta.esVacio()) {
            UtilidadesLog.info(
                "DAOClientePremiacionConcurso.recuperarCodigoMensajeObtencion"
                    +"(Long oidConcurso):Salida CON VALOR " +  respuesta.getValueAt(0, "COD_MENS"));

            return (String) respuesta.getValueAt(0, "COD_MENS");
        } else {
            UtilidadesLog.info(
                "DAOClientePremiacionConcurso.recuperarCodigoMensajeObtencion"
                    +"(Long oidConcurso):Salida NULL");

            return null;
        }
    }

    /**
     * @author Dante Castiglione
     */
    public Float recuperarSaldoPuntos(Long oidCliente, Concurso concurso)
        throws MareException {
        UtilidadesLog.info(
            "DAOClientePremiacionConcurso.recuperarSaldoPuntos(Long oidCliente"
                +", Concurso concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT ");
            query.append(" SUM (NUM_PUNT) AS SUMA_PUNTOS ");
            query.append(" FROM INC_CUENT_CORRI_PUNTO ");
            query.append(" WHERE CLIE_OID_CLIE = " + oidCliente.longValue());
            query.append(" AND COPA_OID_PARA_GRAL = " +
                concurso.getOidConcurso().longValue());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuesta.getValueAt(0, "SUMA_PUNTOS") != null) {
            UtilidadesLog.info(
                "DAOClientePremiacionConcurso.recuperarSaldoPuntos(Long "
                    +"oidCliente, Concurso concurso):Salida");

            return new Float(((BigDecimal) 
                respuesta.getValueAt(0, "SUMA_PUNTOS")).floatValue());
        } else {
            UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarSaldo"
                +"Puntos(Long oidCliente, Concurso concurso):Salida");

            return null;
        }
    }

    public String recuperarCodigoMensajeDespacho(Long oidConcurso)
        throws MareException {
        UtilidadesLog.info(
            "DAOClientePremiacionConcurso.recuperarCodigoMensajeDespacho(Long"
                +"oidConcurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();

            ParametrosGeneralesPremiacionLocalHome ParamGenerLocalHome = this.getParametrosGeneralesPremiacionLocalHome();

            ParametrosGeneralesPremiacionLocal ParamGenerLocal = 
                ParamGenerLocalHome.findByUK(oidConcurso);

            if (ConstantesINC.TIPO_PREMIACION_BOLSA_PREMIOS.equals(
                ParamGenerLocal.getTipoPremiacion())) {
                query.append(" SELECT ");
                query.append(" COD_MENS ");
                query.append(" FROM INC_DESPA_PREMI, ");
                query.append(" MSG_MENSA ");
                query.append(" WHERE COPA_OID_PARA_GRAL = " + oidConcurso);
                query.append(" AND MENS_OID_MENS_MANU = OID_MENS ");
                respuesta = bs.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("*** respuesta: " + respuesta);
            } else if (ConstantesINC.TIPO_PREMIACION_POR_NIVELES.equals(
                ParamGenerLocal.getTipoPremiacion())) {
                query.append(" SELECT ");
                query.append(" COD_MENS ");
                query.append(" FROM INC_DESPA_PREMI, ");
                query.append(" MSG_MENSA ");
                query.append(" WHERE COPA_OID_PARA_GRAL = " + oidConcurso);
                query.append(" AND MENS_OID_MENS_AUTO = OID_MENS ");
                respuesta = bs.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("*** respuesta: " + respuesta);
            }        

        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!respuesta.esVacio()) {
            UtilidadesLog.info(
                "DAOClientePremiacionConcurso.recuperarCodigoMensajeDespacho("
                    +"Long oidConcurso):Salida");

            return (String) respuesta.getValueAt(0, "COD_MENS");
        } else {
            UtilidadesLog.info(
                "DAOClientePremiacionConcurso.recuperarCodigoMensajeDespacho("
                    +"Long oidConcurso):Salida");

            return null;
        }
    }
    
    /**
     * INC-46
     * jrivas 28/3/2006
     * @param nivelesEntregar
     * @param nivelObtenido
     * @param registrosRecuperados
     * @param concurso
     */
     private void tratarNivelObtenido(Concurso concurso, RecordSet registrosRecuperados,  ArrayList nivelesEntregar, int i, int primerNivel) {
         UtilidadesLog.info("DAOClientePremiacionConcurso.tratarNivelObtenido:Entrada");

         UtilidadesLog.debug("primerNivel " + (primerNivel));
         i -= 1;
         UtilidadesLog.debug("i " + i);
         UtilidadesLog.debug("concurso.getPremiosAcumulativosNiveles() " + concurso.getPremiosAcumulativosNiveles());    
         if (concurso.getPremiosAcumulativosNiveles()) {
             UtilidadesLog.debug("concurso.getHastaNivelPremiacion() " + concurso.getHastaNivelPremiacion());            
             if (!concurso.getHastaNivelPremiacion().equals(new Long(0))) {
                 Long numeroNivel = new Long(((BigDecimal) registrosRecuperados.getValueAt(i, "NUM_NIVE")).longValue());
                 UtilidadesLog.debug("numeroNivel " + numeroNivel);            
                 if (numeroNivel.longValue() > concurso.getHastaNivelPremiacion().longValue()) { 
                     UtilidadesLog.debug("pongo 2 "); 
                     nivelesEntregar.add(new Long(((BigDecimal) registrosRecuperados.getValueAt(i, "OID_PARA_NIVE_PREM")).longValue()));
                 } else {
                     //jrivas 17/11/2008
                     //for (int h = 0; h <= i; h++) {
                     for (int h = primerNivel; h <= i; h++) {
                         UtilidadesLog.debug("pongo 3 "); 
                         nivelesEntregar.add(new Long(((BigDecimal) registrosRecuperados.getValueAt(h, "OID_PARA_NIVE_PREM")).longValue()));
                     }
                 }
             } else {
                 //jrivas 17/11/2008
                 //for (int f = 0; f <= i; f++) {
                 for (int f = primerNivel; f <= i; f++) {
                     UtilidadesLog.debug("pongo 4 "); 
                     nivelesEntregar.add(new Long(((BigDecimal) registrosRecuperados.getValueAt(f, "OID_PARA_NIVE_PREM")).longValue()));
                 }
             }
         } else {
             UtilidadesLog.debug("pongo 5 "); 
             nivelesEntregar.add(new Long(((BigDecimal) registrosRecuperados.getValueAt(i, "OID_PARA_NIVE_PREM")).longValue()));        
         }
         UtilidadesLog.info("DAOClientePremiacionConcurso.tratarNivelObtenido:Salida " + nivelesEntregar) ;        
     }
    
    /**
     * BELC300023774 
     * jrivas 26/8/2006
     * @param periodo
     */
    public String obtenerDescCuentaCorrientePuntos(Long periodo) throws MareException {
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        String descripcion;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } 
        
        try {
            query.append(" SELECT gen1.VAL_I18N descTipoMov, mar.DES_MARC, gen2.VAL_I18N descCanal, corp.COD_PERI  ");
            query.append(" FROM V_GEN_I18N_SICC gen1, CRA_PERIO cra,  ");
            query.append(" SEG_MARCA mar, V_GEN_I18N_SICC gen2, SEG_PERIO_CORPO corp  ");
            query.append(" WHERE cra.OID_PERI = " + periodo);
            query.append(" AND cra.MARC_OID_MARC = mar.OID_MARC  ");
            query.append(" AND gen2.ATTR_NUM_ATRI = 1  ");
            query.append(" AND gen2.ATTR_ENTI= 'SEG_CANAL'  ");
            query.append(" AND gen2.VAL_OID = cra.CANA_OID_CANA  ");
            query.append(" AND gen2.IDIO_OID_IDIO = 1 ");
            query.append(" AND corp.OID_PERI = cra.PERI_OID_PERI  ");
            query.append(" AND gen1.ATTR_NUM_ATRI = 1  ");
            query.append(" AND gen1.ATTR_ENTI= 'INC_TIPO_MOVIM'  ");
            query.append(" AND gen1.VAL_OID = 1 ");
            query.append(" AND gen1.IDIO_OID_IDIO = 1 ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
 
        descripcion = (String)respuesta.getValueAt(0, "DESCTIPOMOV") + ConstantesINC.DESC_PUNTAJE_PERIODO +
                     (String)respuesta.getValueAt(0, "DES_MARC") + " " + (String)respuesta.getValueAt(0, "DESCCANAL") + " " +
                     (String)respuesta.getValueAt(0, "COD_PERI");
                     
        return descripcion;
    }
    
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   05/01/2007
     * @version 1.00
     * @autor   Viviana Bongiovanni
     * Inc DBLG500001077
     */
    public ArrayList getRecomendantesCalculo(Long oidPeriodo, Long cliente) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.getRecomendantesCalculo(Long oidPeriodo, Long cliente):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;

        query.append(" SELECT CLIE_OID_CLIE, p1.OID_PERI, OID_PARA_GRAL, ");
        query.append(" P1.MARC_OID_MARC, P1.CANA_OID_CANA, P1.PAIS_OID_PAIS ");
        query.append(", P1.FEC_INIC, P1.FEC_FINA, "); //INC-122
        // vbongiov -- 20/07/2006 -- inc DBLG500001048
        query.append(" mae_cli.COD_CLIE, mae_cli.VAL_NOM1, mae_cli.VAL_NOM2,  "); 
        query.append(" mae_cli.VAL_APE1, mae_cli.VAL_APE2, 1 recomendante "); 
        query.append(" FROM inc_clien_recte clie, MAE_CLIEN mae_cli, ");
        query.append(" inc_concu_param_gener concu, cra_perio p1, ");
        query.append(" cra_perio desde ");
        query.append(" WHERE clie.copa_oid_para_gral = concu.oid_para_gral");
        query.append(" AND p1.OID_PERI = " + oidPeriodo);
        query.append(" AND concu.perd_oid_peri_desd = desde.OID_PERI");
        query.append(" AND desde.FEC_INIC <= p1.FEC_INIC ");
        query.append(" AND concu.ind_acti = 1 ");
        query.append(" AND clie.CLIE_OID_CLIE = mae_cli.OID_CLIE");
        query.append(" AND clie.CLIE_OID_CLIE = " + cliente);

        //jrivas 29/1/2007 BELG50001077 
        query.append(" UNION ");
        query.append(" SELECT clie.CLIE_OID_CLIE, p1.OID_PERI, OID_PARA_GRAL, ");
        query.append(" P1.MARC_OID_MARC, P1.CANA_OID_CANA, P1.PAIS_OID_PAIS ");
        query.append(", P1.FEC_INIC, P1.FEC_FINA, "); 
        query.append(" mae_cli.COD_CLIE, mae_cli.VAL_NOM1, mae_cli.VAL_NOM2,  "); 
        query.append(" mae_cli.VAL_APE1, mae_cli.VAL_APE2, 0 recomendante "); 
        query.append(" FROM inc_clien_recte clie, MAE_CLIEN mae_cli, ");
        query.append(" inc_concu_param_gener concu, cra_perio p1, ");
        query.append(" cra_perio desde, INC_CLIEN_RECDO rdo ");
        query.append(" WHERE clie.copa_oid_para_gral = concu.oid_para_gral");
        query.append(" AND p1.OID_PERI = " + oidPeriodo);
        query.append(" AND concu.perd_oid_peri_desd = desde.OID_PERI");
        query.append(" AND desde.FEC_INIC <= p1.FEC_INIC ");
        query.append(" AND concu.ind_acti = 1 ");
        query.append(" AND clie.CLIE_OID_CLIE = mae_cli.OID_CLIE");
        query.append(" AND rdo.CLR3_OID_CLIE_RETE = clie.OID_CLIE_RETE ");
        query.append(" AND rdo.CLIE_OID_CLIE = " + cliente);
    
        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** respuesta: " + rs);                    
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.debug("resultado recomendado: " + rs);
    
        if (rs.esVacio()) {
            UtilidadesLog.info("DAOClientePremiacionConcurso.getRecomendantes(Long oidPeriodo, Long oidCliente):Salida");

            return null;
        }
            
        ArrayList clientesPremiacion = new ArrayList();
        Periodo periodo = new Periodo();
        DAOClientePremiacion daoClientePremiacion = 
            new DAOClientePremiacion();
        DespacharPremiosHelper despacharPremiosHelper = 
            new DespacharPremiosHelper();
        Concurso concurso = new Concurso();
        boolean existe = false;

        for (int fila = 0; rs.existeFila(fila); fila++) {
            existe = false;
            ClientePremiacion clientePremiacion = new ClientePremiacion();
            Long oidCliente = new Long(((BigDecimal) rs.getValueAt(fila,
                        "CLIE_OID_CLIE")).longValue());
            Long oidPeri = new Long(((BigDecimal) rs.getValueAt(fila,
                        "OID_PERI")).longValue());
            Long oidConcurso = new Long(((BigDecimal) rs.getValueAt(fila,
                        "OID_PARA_GRAL")).longValue());

            Long marca = new Long(((BigDecimal) rs.getValueAt(fila,
                        "MARC_OID_MARC")).longValue());
            Long canal = new Long(((BigDecimal) rs.getValueAt(fila,
                        "CANA_OID_CANA")).longValue());
            Long pais = new Long(((BigDecimal) rs.getValueAt(fila,
                        "PAIS_OID_PAIS")).longValue());
                        
            UtilidadesLog.debug("oidCliente: " + oidCliente);
            
            if (rs.getValueAt(fila,"RECOMENDANTE").toString().equals("1")) {
                clientePremiacion.setIndAnulacionRecomendante(true);
            } else {
                clientePremiacion.setIndAnulacionRecomendante(false);
            }
            
            // vbongiov -- 20/07/2006 -- inc DBLG500001048
            DatosPersonales datPerso = new DatosPersonales();
            
            datPerso.setNombre1((String) rs.getValueAt(fila,"VAL_NOM1"));
            datPerso.setNombre2((String) rs.getValueAt(fila,"VAL_NOM2"));
            datPerso.setApellido1((String) rs.getValueAt(fila,"VAL_APE1"));
            datPerso.setApellido2((String) rs.getValueAt(fila,"VAL_APE2"));
            datPerso.setCodCliente((String) rs.getValueAt(fila,"COD_CLIE"));
            
            UtilidadesLog.debug("oidConcurso: " + oidConcurso);
            UtilidadesLog.debug("oidPeri: " + oidPeri);

            //Armado de Periodo INC-122
            periodo = new Periodo();
            periodo.setFechaDesde((Date) rs.getValueAt(fila, "FEC_INIC"));
            periodo.setFechaHasta((Date) rs.getValueAt(fila, "FEC_FINA"));
            periodo.setOidCanal(new Long(((BigDecimal) rs.getValueAt(fila,"CANA_OID_CANA")).longValue()));
            periodo.setOidMarca(new Long(((BigDecimal) rs.getValueAt(fila,"MARC_OID_MARC")).longValue()));
            periodo.setOidPais(new Long(((BigDecimal) rs.getValueAt(fila,"PAIS_OID_PAIS")).longValue()));
            periodo.setOidPeriodo(oidPeri);                


            //INC-122 Verificar si periodo <= concurso.ultimoPeriodoEvaluar
            concurso = despacharPremiosHelper.obtenerConcurso(oidConcurso);
            UtilidadesLog.debug("periodo : " + periodo);
            UtilidadesLog.debug("concurso.getUltimoPeridoEvaluar() : " + concurso.getUltimoPeridoEvaluar());
            if (!periodo.mayorQue(concurso.getUltimoPeridoEvaluar())) {
                //Entonces tengo que procesarlo
                UtilidadesLog.debug("SE PROCESA!!!");
                
                //en caso de que se repita el cliente seteamos 
                //clientesPremiacionConcurso           
                UtilidadesLog.debug("DAOClientePremiacionConcurso.clientesPrem"
                    +"iacion.size()" + clientesPremiacion.size());

                //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                //jrivas 29/1/2007 BELG50001077 
                /*if ((concurso.getPeriodoInicialEvaluacion() == null) ||
                     ((!periodo.mayorQue(concurso.getPeriodoFinalEvaluacion())) &&
                     (!periodo.menorQue(concurso.getPeriodoInicialEvaluacion())))) {*/

                UtilidadesLog.debug("SE PROCESA 2!!!");
                
                for (int pos = 0; (clientesPremiacion.size() > pos && !existe); pos++) {
                    clientePremiacion = (ClientePremiacion) 
                        clientesPremiacion.get(pos);
                        
                    // vbongiov -- 9/01/2007 -- DBLG500001077
                    clientePremiacion.setIndAnulacion(true);

                    UtilidadesLog.debug(
                        "DAOClientePremiacionConcurso.oidCliente()" +
                        oidCliente);
                    UtilidadesLog.debug("DAOClientePremiacionConcurso.cliente"
                        +"Premiacion.getOidCliente()()" +
                        clientePremiacion.getOidCliente());

                    if (oidCliente.equals(clientePremiacion.getOidCliente())){
                        existe = true;
                        daoClientePremiacion
                            .rellenarClientePremiacionConcursoRecomendacion(concurso,
                            clientePremiacion);                                
                    }
                }

                if (!existe) {
                    UtilidadesLog.debug(
                        "DAOClientePremiacionConcurso.nbo existe!!!");
                    clientePremiacion = new ClientePremiacion();
                    clientePremiacion.setOidCliente(oidCliente);
                    clientePremiacion.setOidMarca(marca);
                    clientePremiacion.setOidCanal(canal);
                    clientePremiacion.setOidPais(pais);
                    clientePremiacion.setPeriodo(periodo);
                    clientePremiacion.setDatosPersonales(datPerso);
                    // vbongiov -- 9/01/2007 -- DBLG500001077
                    clientePremiacion.setIndAnulacion(true);
                    //concurso = despacharPremiosHelper.obtenerConcurso(oidConcurso);
                    daoClientePremiacion
                      .rellenarClientePremiacionConcursoRecomendacion(concurso,
                        clientePremiacion);
                    clientesPremiacion.add(clientePremiacion);
                } else {
                    existe = false;
                }
                //}                         
            } else {
                //no se procesa
                UtilidadesLog.debug("NO SE PROCESA!!!");
            }                
        }
        
        UtilidadesLog.info("DAOClientePremiacionConcurso.getRecomendantes(Long oidPeriodo, Long oidCliente):Salida");

        return clientesPremiacion;
        
    }
    
    private StringBuffer queryArticuloLote (Long oidLotePremioArticulo) throws MareException {
        StringBuffer query = new StringBuffer();
        query.append(" SELECT   IMP_PREC_PUBL, NUM_UNID, COD_VENT_FICT, PROD_OID_PROD, ");
        query.append("          (SELECT V.VAL_I18N ");
        query.append("             FROM V_GEN_I18N_SICC V ");
        query.append("            WHERE V.VAL_OID = PROD_OID_PROD ");
        query.append("              AND V.ATTR_NUM_ATRI = 1 ");
        query.append("              AND V.ATTR_ENTI = 'MAE_PRODU' ");
        query.append("              AND V.IDIO_OID_IDIO =  " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
        query.append("          ) DESCPRODU, ");
        query.append("          PRODU.COD_SAP, IND_TIPO_ENTR_PREM, CS.COD_CENT_SERV, CS.DES_CENT_SERV ");
        // vbongiov -- Cambio 20090828 -- 8/06/2009
        query.append(" , OID_ARTI_LOTE ");
        
        query.append("     FROM INC_ARTIC_LOTE, MAE_PRODU PRODU, INC_CENTR_SERVI CS ");
        query.append("    WHERE LOPA_OID_LOTE_PREM_ARTI = " + oidLotePremioArticulo);
        query.append("      AND INC_ARTIC_LOTE.PROD_OID_PROD = PRODU.OID_PROD ");
        query.append("      AND CESE_OID_CESE_ENTR = CS.OID_CENT_SERV(+) ");
        query.append(" ORDER BY PROD_OID_PROD ");
        return query;
    }
    
    //jrivas BRECHA MSG-01 8/10/2007
    public ArrayList recuperarPuntos(Long oidCliente, Concurso concurso)
        throws MareException {
        UtilidadesLog.info(
            "DAOClientePremiacionConcurso.recuperarPuntos(Long oidCliente"
                +", Concurso concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT A.NUM_PUNT PUNTOS, A.VAL_DESC DESCIPCION, ");
            query.append("        TO_DATE (A.FEC_MOVI, 'DD/MM/YYYY') - TO_DATE (B.FEC_ULTI_GENE_CUPO, 'DD/MM/YYYY') DIFERENCIAFECHA  ");
            query.append("   FROM INC_CUENT_CORRI_PUNTO A, MAE_CLIEN B ");
            query.append("  WHERE A.CLIE_OID_CLIE = B.OID_CLIE  ");
            query.append("    AND A.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso().longValue());
            query.append("    AND B.OID_CLIE = " + oidCliente.longValue());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (respuesta.esVacio()) {
            UtilidadesLog.info(
                "DAOClientePremiacionConcurso.recuperarPuntos(Long oidCliente"
                    +", Concurso concurso):Salida VACIO");
            ArrayList salida = new ArrayList(5);
            salida.add(0, new Integer(0));
            salida.add(1, new Integer(0));
            salida.add(2, new Integer(0));
            salida.add(3, new Integer(0));
            salida.add(4, new Integer(0));            
            return salida;
        } else {
            int puntajeTotal = 0;
            int puntajeDevAnul = 0;
            int puntajeOtrosCanales = 0;
            int puntosUtilizados = 0;
            int saldoAnterior = 0;
            int puntos = 0;
            Integer deferenciaFecha;
            String descripcion = "";
            
            for (int i = 0; i < respuesta.getRowCount(); i++) {
                if (respuesta.getValueAt(i, "DIFERENCIAFECHA") != null) {
                    deferenciaFecha = new Integer(((BigDecimal) respuesta.getValueAt(i, "DIFERENCIAFECHA")).intValue());
                } else {
                    deferenciaFecha = null;
                }
                
                puntos = ((BigDecimal) respuesta.getValueAt(i, "PUNTOS")).intValue();
                if (respuesta.getValueAt(i, "DESCIPCION") != null) {
                    descripcion = (String) respuesta.getValueAt(i, "DESCIPCION");
                }
                
                puntajeTotal = puntajeTotal + puntos;
                UtilidadesLog.debug("*** puntajeTotal: " + puntajeTotal);
                
                if (deferenciaFecha == null || deferenciaFecha.intValue() >= 1) {
                    if ((descripcion.indexOf(ConstantesINC.TEXTO_DESCRIPCION_ANULACION) > -1) ||
                        (descripcion.indexOf("Cargo Puntaje del periodo") > -1)) {
                        puntajeDevAnul = puntajeDevAnul + puntos;
                        UtilidadesLog.debug("*** puntajeDevAnul: " + puntajeDevAnul);                        
                    }
    
                    // sapaza -- PER-SiCC-2010-0513 -- 11/10/2010
                    if (descripcion.indexOf(ConstantesINC.COD_ECM) > -1) {
                        puntajeOtrosCanales = puntajeOtrosCanales + puntos;
                        UtilidadesLog.debug("*** puntajeOtrosCanales: " + puntajeOtrosCanales);
                    }
    
                    if (descripcion.indexOf(ConstantesINC.DESC_ENTREGA_PREMIO) > -1) {
                        puntosUtilizados = puntosUtilizados + puntos;
                        UtilidadesLog.debug("*** puntosUtilizados: " + puntosUtilizados);
                    }
                }
                
                if (deferenciaFecha == null || deferenciaFecha.intValue() <= 0) {
                    saldoAnterior = saldoAnterior + puntos;
                    UtilidadesLog.debug("*** saldoAnterior: " + saldoAnterior);
                }
            }
    
            ArrayList salida = new ArrayList(5);
            salida.add(0, new Integer(puntajeTotal));
            salida.add(1, new Integer(puntajeDevAnul));
            salida.add(2, new Integer(puntajeOtrosCanales));
            salida.add(3, new Integer(puntosUtilizados));
            salida.add(4, new Integer(saldoAnterior));
            
            UtilidadesLog.info(
                "DAOClientePremiacionConcurso.recuperarPuntos(Long oidCliente"
                    +", Concurso concurso):Salida" + salida);
            return salida;
            
        }
        
    }    
    
    private PremiosElegidosLocalHome getPremiosElegidosLocalHome() {
            return new PremiosElegidosLocalHome();
    }

    private ParametrosGeneralesPremiacionLocalHome getParametrosGeneralesPremiacionLocalHome() {
            return new ParametrosGeneralesPremiacionLocalHome();
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
    
    //jrivas 18/11/2008 20070536
    private void guardarUltimaAsignacionPremios(Long oidPais, Long oidConcurso, Long oidCliente, 
                            int ultimaRotacion, int ultimoNivel, double ultimoSaldo) throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.guardarUltimaAsignacionPremios() - Entrada");
        
        StringBuffer query = new StringBuffer();
        
        query.append("DELETE FROM INC_ULTIM_ASIGN_PREMI ");
        query.append("WHERE COPA_OID_PARA_GRAL = " + oidConcurso);
        query.append("AND CLIE_OID_CLIE = " + oidCliente + ";");
        
        query.append("INSERT INTO INC_ULTIM_ASIGN_PREMI ( OID_ULTI_ASIG_PREM, ");
        query.append("PAIS_OID_PAIS, COPA_OID_PARA_GRAL, CLIE_OID_CLIE, VAL_ULTI_ROTA, VAL_ULTI_NIVE, ");
        query.append(" VAL_ULTI_SALD, FEC_CREA ) VALUES ( ");
        query.append(" INC_IUAP_SEQ.nextval, " + oidPais);
        query.append(", " + oidConcurso);
        query.append(", " + oidCliente);
        query.append(", " + ultimaRotacion);
        query.append(", " + ultimoNivel);
        query.append(", " + ultimoSaldo);
        query.append(", sysdate)");
        query.append(";");   
        
        this.ejecutarInsert(query);
        
        UtilidadesLog.info("MONCalcularMetasBean.guardarUltimaAsignacionPremios() - Salida");
    }    

    //jrivas 18/11/2008 20070536
    private void ejecutarInsert(StringBuffer query) throws MareException {
        UtilidadesLog.info("MONCalcularMetasBean.ejecutarInsertMasivo() - Entrada");
        
        BelcorpService bs;
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("Error en ejecutarInsertMasivo ",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }            
        UtilidadesLog.info("MONCalcularMetasBean.ejecutarInsertMasivo() - Salida");
    }    
    
     //jrivas 28/11/2008 20080783
     private void updatePremiosElegidosPendiente(PremiosElegidos premios, Long oidPais, Long oidPeriodo) throws MareException {
        String codigoUsuario = "ADMIN";
        
        ArrayList aux = premios.obtenerPremiosNoPendientes();
        if (aux.size() > 0) {
            Iterator it = aux.iterator();
            StringBuffer oidPremiosElegidos = new StringBuffer();
            while (it.hasNext()) {
                oidPremiosElegidos.append(it.next());
                if (it.hasNext()) { 
                    oidPremiosElegidos.append(", ");
                }
            }
            
            // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
            StringBuffer query = new StringBuffer();
            query.append("UPDATE INC_PREMI_ELEGI ");
            query.append(" SET IND_PEND = 0, ");
            query.append("     COD_MOTI_INVA = NULL, ");
            query.append("     PERD_OID_PERI_IATN = " + oidPeriodo + ",");
            query.append("     USU_MODI = '" + codigoUsuario + "', ");
            query.append("     FEC_MODI = SYSDATE ");
            query.append(" WHERE OID_PREM_ELEG IN ("+oidPremiosElegidos+")");
            
            try{
                BelcorpService.getInstance().dbService.executeUpdate(query.toString());
            }catch(Exception e){
                UtilidadesLog.error("ERROR",e);
                throw new MareException(e);
            }    
        }
        
        // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
        updatePremiosElegidosRechazados(premios, 1, codigoUsuario);
        updatePremiosElegidosRechazados(premios, 4, codigoUsuario);
        
        ArrayList aux1 = premios.obtenerPremiosRechazadosPuntaje();
        if (aux1.size() > 0) {
            DAOSolicitudes daoSolicitudes = new DAOSolicitudes();
            String parametro = daoSolicitudes.obtenerIndicadorParametroPais(oidPais, "INC", "007", "0");
            
            Iterator it = aux1.iterator();
            StringBuffer oidPremiosElegidos = new StringBuffer();
            while (it.hasNext()) {
                oidPremiosElegidos.append(it.next());
                if (it.hasNext()) { 
                    oidPremiosElegidos.append(", ");
                }
            }
            StringBuffer query = new StringBuffer();
            query.append("UPDATE INC_PREMI_ELEGI ");
            query.append(" SET COD_MOTI_INVA = 8, ");
            
            //sapaza -- COL-SiCC-2014-0201 -- 24/06/2014
            if(parametro!=null && "1".equals(parametro))
                query.append("     IND_PEND = 4, ");
                
            query.append("     USU_MODI = '" + codigoUsuario + "', ");
            query.append("     FEC_MODI = SYSDATE ");
            query.append(" WHERE OID_PREM_ELEG IN ("+oidPremiosElegidos+")");
            
            try{
                BelcorpService.getInstance().dbService.executeUpdate(query.toString());
            }catch(Exception e){
                UtilidadesLog.error("ERROR",e);
                throw new MareException(e);
            }    
        }
     
    }           
    
    //jrivas 29/4/2009 20090903
    public void actualizarCandidata(Long oidConcurso, Long oidCliente, Long periodo, boolean requisitosPremiacionSuperado) throws MareException {
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        query.append(" UPDATE INC_CANDI_GANAD ");
        query.append(" SET VAL_REQU_PREM_SUPE = 0 ");
        query.append(" WHERE COPA_OID_PARA_GRAL = " + oidConcurso);
        query.append(" AND CLIE_OID_CLIE = " + oidCliente);
        query.append(" AND PERD_OID_PERI = " + periodo);

        try {
            bs = BelcorpService.getInstance();
            int rs = bs.dbService.executeUpdate(query.toString());
            if (rs == 0) {
              // vbongiov -- SiCC 20090988 -- 15/07/2009
              this.insertarCandidata(oidConcurso, oidCliente, periodo, false);
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

    //jrivas 29/4/2009 20090903
    private void insertarCandidata(Long oidConcurso, Long oidCliente, Long periodo, boolean requisitosPremiacionSuperado) throws MareException {
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        int meta = 0;
        int req = 0;
        if (requisitosPremiacionSuperado) {
            req = 1;
        }        
        query.append(" INSERT INTO INC_CANDI_GANAD ( OID_CAND_GANA, ");
        query.append(" IND_META_SUPE, VAL_REQU_PREM_SUPE, PERD_OID_PERI, ");
        query.append(" COPA_OID_PARA_GRAL, CLIE_OID_CLIE )  ");
        query.append(" VALUES (INC_CAGA_SEQ.nextval,  " + meta);
        query.append(" , " + req);
        query.append(" , " + periodo);
        query.append(" , " + oidConcurso);
        query.append(" , " + oidCliente);
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
    
     // vbongiov -- Cambio 20090828 -- 8/06/2009
    public DTOReemplazoArticuloLote verificarArticuloReemplazo(ArticuloLote articuloLote, ClientePremiacion clientePremiacion, ClientePremiacionConcurso clienteConcurso) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.verificarArticuloReemplazo(ArticuloLote articuloLote, ClientePremiacion clientePremiacion, ClientePremiacionConcurso clienteConcurso): Entrada");                
        UtilidadesLog.debug("articuloLote: " + articuloLote);
                    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOReemplazoArticuloLote dtoReemplazoArticuloLote = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" (SELECT reemL.OID_REEM_ARTI_LOTE, reemL.CTRE_OID_CRIT_REEM, reemL.VAL_CRIT_REEM, ");   
        query.append(" reemL.PROD_OID_PROD, reemL.COD_VENT_FICT, reemL.NUM_UNID, reemL.IMP_PREC_PUBL, reemL.IND_COMU, "); 
        query.append(" prod.COD_SAP COD_SAP_REEM, i18n.VAL_I18N DESC_PROD_REEM, prod2.COD_SAP COD_SAP_ORIG, ");  
        query.append(" con.NUM_CONC, desp.MENS_OID_MENS_AUTO, reeml.num_orde "); 
        query.append(" ,nvl(reemL.COD_TIPO_AGRU,'I') COD_TIPO_AGRU "); // sapaza -- COL-SiCC-2014-0174 -- 20/06/2014
        query.append(" FROM INC_REEMP_ARTIC_LOTE reemL, INC_REEMP_REGIO_ZONA reemRZ, ");  
        query.append(" MAE_PRODU prod, v_gen_i18n_sicc i18n, MAE_PRODU prod2, INC_ARTIC_LOTE artLote, ");  
        query.append(" INC_CONCU_PARAM_GENER con, INC_DESPA_PREMI desp ");  
        query.append(" WHERE reemL.ARLO_OID_ARTI_LOTE = " + articuloLote.getOidArticuloLote());  
        query.append(" AND reemL.IND_ACTI = 1 ");  
        query.append(" AND reemL.OID_REEM_ARTI_LOTE = reemRZ.RARL_OID_REEM_ARTI_LOTE ");
        query.append(" AND (SELECT COUNT(1) ");  
        query.append(" FROM MAE_CLIEN_UNIDA_ADMIN unidAdm, ZON_TERRI_ADMIN terrAdm, ZON_SECCI secc, ");  
        query.append(" ZON_ZONA zon, ZON_REGIO reg ");  
        query.append(" WHERE unidAdm.CLIE_OID_CLIE= " + clientePremiacion.getOidCliente());  
        query.append(" AND unidAdm.IND_ACTI = 1 ");  
        query.append(" AND unidAdm.ZTAD_OID_TERR_ADMI = terrAdm.OID_TERR_ADMI ");  
        query.append(" AND terrAdm.ZSCC_OID_SECC = secc.OID_SECC ");  
        query.append(" AND secc.ZZON_OID_ZONA = zon.OID_ZONA ");  
        query.append(" AND zon.ZORG_OID_REGI = reg.OID_REGI ");  
        query.append(" AND zon.zorg_oid_regi = NVL (reemrz.zorg_oid_regi, zon.zorg_oid_regi) ");  
        query.append(" AND zon.oid_zona = NVL (reemrz.zzon_oid_zona, zon.oid_zona)) >= 1 ");  
        query.append(" AND reemL.PROD_OID_PROD = prod.OID_PROD ");  
        query.append(" AND i18n.ATTR_ENTI = 'MAE_PRODU' ");  
        query.append(" AND i18n.ATTR_NUM_ATRI = 1 ");  
        query.append(" AND i18n.IDIO_OID_IDIO = " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
        query.append(" AND i18n.VAL_OID = prod.OID_PROD ");  
        query.append(" AND reemL.ARLO_OID_ARTI_LOTE = artLote.OID_ARTI_LOTE ");  
        query.append(" AND artLote.PROD_OID_PROD = prod2.OID_PROD ");  
        query.append(" AND con.OID_PARA_GRAL = " + clienteConcurso.getOidConcurso());  
        query.append(" AND desp.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL ");  
        query.append(" AND reemL.COMP_OID_REEM_ARTI_LOTE IS NULL "); // sapaza -- COL-SiCC-2014-0174 -- 20/06/2014
        query.append(" UNION ");  
        
        query.append(" SELECT reemL.OID_REEM_ARTI_LOTE, reemL.CTRE_OID_CRIT_REEM, reemL.VAL_CRIT_REEM, ");   
        query.append(" reemL.PROD_OID_PROD, reemL.COD_VENT_FICT, reemL.NUM_UNID, reemL.IMP_PREC_PUBL, reemL.IND_COMU, "); 
        query.append(" prod.COD_SAP COD_SAP_REEM, i18n.VAL_I18N DESC_PROD_REEM, prod2.COD_SAP COD_SAP_ORIG, ");  
        query.append(" con.NUM_CONC, desp.MENS_OID_MENS_AUTO, reeml.num_orde "); 
        query.append(" ,nvl(reemL.COD_TIPO_AGRU,'I') COD_TIPO_AGRU "); // sapaza -- COL-SiCC-2014-0174 -- 20/06/2014
        query.append(" FROM INC_REEMP_ARTIC_LOTE reemL, ");  
        query.append(" MAE_PRODU prod, v_gen_i18n_sicc i18n, MAE_PRODU prod2, INC_ARTIC_LOTE artLote, ");  
        query.append(" INC_CONCU_PARAM_GENER con, INC_DESPA_PREMI desp ");         
        query.append(" WHERE reemL.ARLO_OID_ARTI_LOTE = " + articuloLote.getOidArticuloLote());  
        query.append(" AND reemL.IND_ACTI = 1 "); 
        query.append(" AND NOT EXISTS (SELECT 1 "); 
        query.append(" FROM inc_reemp_regio_zona reemrz "); 
        query.append(" where reemrz.RARL_OID_REEM_ARTI_LOTE = reeml.OID_REEM_ARTI_LOTE) "); 
        query.append(" AND reemL.PROD_OID_PROD = prod.OID_PROD ");  
        query.append(" AND i18n.ATTR_ENTI = 'MAE_PRODU' ");  
        query.append(" AND i18n.ATTR_NUM_ATRI = 1 ");  
        query.append(" AND i18n.IDIO_OID_IDIO = " + RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
        query.append(" AND i18n.VAL_OID = prod.OID_PROD ");  
        query.append(" AND reemL.ARLO_OID_ARTI_LOTE = artLote.OID_ARTI_LOTE ");  
        query.append(" AND artLote.PROD_OID_PROD = prod2.OID_PROD ");  
        query.append(" AND con.OID_PARA_GRAL = " + clienteConcurso.getOidConcurso());  
        
        // sapaza -- COL-SiCC-2014-0174 -- 20/06/2014
        query.append(" AND reemL.COMP_OID_REEM_ARTI_LOTE IS NULL ");  
        
        query.append(" AND desp.COPA_OID_PARA_GRAL = con.OID_PARA_GRAL) ");  
        query.append(" ORDER BY NUM_ORDE ");  
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
                
        if(rs.esVacio()){
            UtilidadesLog.info("DAOClientePremiacionConcurso.verificarArticuloReemplazo(ArticuloLote articuloLote, ClientePremiacion clientePremiacion, ClientePremiacionConcurso clienteConcurso): Salida");       
            return dtoReemplazoArticuloLote;
            
        } else {
        
           int cant = rs.getRowCount();
           Boolean reemplazoValido = Boolean.FALSE;
           
           for(int i=0; i< cant; i++){
        
                
                reemplazoValido = this.reemplazoValido(Long.valueOf(((BigDecimal)rs.getValueAt(i, "CTRE_OID_CRIT_REEM")).toString()),
                                                       articuloLote.getOidCodigoProducto(),
                                                       Long.valueOf(((BigDecimal)rs.getValueAt(i, "PROD_OID_PROD")).toString()),
                                                       ((rs.getValueAt(i, "VAL_CRIT_REEM")!=null)?(Integer.valueOf(((BigDecimal)rs.getValueAt(i, "VAL_CRIT_REEM")).toString())):null),
                                                       clientePremiacion.getOidPais());
              
                
                if(reemplazoValido.booleanValue()){   
                    
                    if(((BigDecimal)rs.getValueAt(i, "IND_COMU")).intValue()== 1 && ((BigDecimal)rs.getValueAt(i, "MENS_OID_MENS_AUTO")!= null)){
                        this.actualizarBuzonMensajeDespacho(clientePremiacion.getOidCliente(),
                                                            Long.valueOf(((BigDecimal)rs.getValueAt(i, "MENS_OID_MENS_AUTO")).toString()),
                                                            (String)rs.getValueAt(i, "NUM_CONC"),
                                                            (String)rs.getValueAt(i, "COD_SAP_ORIG"),
                                                            (String)rs.getValueAt(i, "COD_SAP_REEM"),
                                                            (String)rs.getValueAt(i, "DESC_PROD_REEM"),
                                                            (String)rs.getValueAt(i, "COD_VENT_FICT"));
                    }
                    
                    dtoReemplazoArticuloLote = new DTOReemplazoArticuloLote();
                    dtoReemplazoArticuloLote.setProdOidProd(Long.valueOf(((BigDecimal)rs.getValueAt(i, "PROD_OID_PROD")).toString()));
                    dtoReemplazoArticuloLote.setCodVentFict((String)rs.getValueAt(i, "COD_VENT_FICT"));
                    dtoReemplazoArticuloLote.setNumUnid(Long.valueOf(((BigDecimal)rs.getValueAt(i, "NUM_UNID")).toString()));
                    dtoReemplazoArticuloLote.setImpPrecPubi((BigDecimal)rs.getValueAt(i, "IMP_PREC_PUBL"));
                    
                    // sapaza -- COL-SiCC-2014-0174 -- 20/06/2014
                    dtoReemplazoArticuloLote.setOidReemArtiLote(Long.valueOf(((BigDecimal)rs.getValueAt(i, "OID_REEM_ARTI_LOTE")).toString()));
                    dtoReemplazoArticuloLote.setTipoAgrupacion((String)rs.getValueAt(i, "COD_TIPO_AGRU"));
                    
                    UtilidadesLog.info("DAOClientePremiacionConcurso.verificarArticuloReemplazo(ArticuloLote articuloLote, ClientePremiacion clientePremiacion, ClientePremiacionConcurso clienteConcurso): Salida");       
                    return dtoReemplazoArticuloLote;
                    
                }
           }            
        }
        
        UtilidadesLog.info("DAOClientePremiacionConcurso.verificarArticuloReemplazo(ArticuloLote articuloLote, ClientePremiacion clientePremiacion, ClientePremiacionConcurso clienteConcurso): Salida");       
        return null;
        
    }
    
    // vbongiov -- Cambio 20090828 -- 8/06/2009
    public Boolean reemplazoValido(Long oidCriterioReemplazo, Long oidProducto, Long oidProductoReemplazo, Integer criterioReemplazo, Long oidPais) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.reemplazoValido(Long oidCriterioReemplazo, Long oidProducto, Long oidProductoReemplazo, Integer criterioReemplazo, Long oidPais): Entrada");                
        UtilidadesLog.debug("oidCriterioReemplazo: " + oidCriterioReemplazo);
        UtilidadesLog.debug("oidProducto: " + oidProducto);
        UtilidadesLog.debug("oidProductoReemplazo: " + oidProductoReemplazo);
        UtilidadesLog.debug("criterioReemplazo: " + criterioReemplazo);
        UtilidadesLog.debug("oidPais: " + oidPais);
       
       
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        DTOReemplazoArticuloLote dtoReemplazoArticuloLote = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        if(oidCriterioReemplazo.equals(ConstantesINC.OID_CRIT_STOCK_AGOTADO) ||
           oidCriterioReemplazo.equals(ConstantesINC.OID_CRIT_EXISTEN_X_UNIDADES)) {
                 
            // sapaza -- PER-SiCC-2012-0977 -- 30/01/2013
            UtilidadesLog.info("DAOClientePremiacionConcurso.reemplazoValido(Long oidCriterioReemplazo, Long oidProducto, Long oidProductoReemplazo, Integer criterioReemplazo, Long oidPais): Salida");       
            return Boolean.FALSE;
     
            /*query.append(" SELECT CASE WHEN ((EXISTS (SELECT st.VAL_SALD ");  
            query.append(" FROM BEL_STOCK st, BEL_ESTAD_MERCA est ");
            query.append(" WHERE st.PROD_OID_PROD = " + oidProducto);
            query.append(" AND st.ESME_OID_ESTA_MERC = est.OID_ESTA_MERC ");
            query.append(" AND st.ESME_OID_ESTA_MERC = est.OID_ESTA_MERC ");
            query.append(" AND est.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND est.COD_ESTA ='LD' ");
            query.append(" AND st.ALMC_OID_ALMA = (SELECT tipoSolPais.ALMC_OID_ALMA ");
            query.append(" FROM PED_TIPO_SOLIC_PAIS tipoSolPais,  ");
            query.append(" PED_TIPO_SOLIC_PROCE tipoSolProc, BEL_OPERA ope ");
            query.append(" WHERE tipoSolPais.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND tipoSolProc.TSPA_OID_TIPO_SOLI_PAIS = tipoSolPais.OID_TIPO_SOLI_PAIS ");
            query.append(" AND tipoSolProc.OPER_OID_OPER = ope.OID_OPER ");
            query.append(" AND ope.COD_OPER = 'INC020' ");
            query.append(" AND ROWNUM = 1)) ");
            query.append(" ) AND ((SELECT st.VAL_SALD ");
            query.append(" FROM BEL_STOCK st, BEL_ESTAD_MERCA est ");
            query.append(" WHERE st.PROD_OID_PROD = " + oidProducto);
            query.append(" AND st.ESME_OID_ESTA_MERC = est.OID_ESTA_MERC ");
            query.append(" AND est.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND est.COD_ESTA ='LD' ");
            query.append(" AND st.ALMC_OID_ALMA = (SELECT tipoSolPais.ALMC_OID_ALMA ");
            query.append(" FROM PED_TIPO_SOLIC_PAIS tipoSolPais,  ");
            query.append(" PED_TIPO_SOLIC_PROCE tipoSolProc, BEL_OPERA ope ");
            query.append(" WHERE tipoSolPais.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND tipoSolProc.TSPA_OID_TIPO_SOLI_PAIS = tipoSolPais.OID_TIPO_SOLI_PAIS ");
            query.append(" AND tipoSolProc.OPER_OID_OPER = ope.OID_OPER ");
            query.append(" AND ope.COD_OPER = 'INC020' ");
            
            if(oidCriterioReemplazo.equals(ConstantesINC.OID_CRIT_STOCK_AGOTADO)){
                query.append(" AND ROWNUM = 1)) > 0 ");
                
            } else if(oidCriterioReemplazo.equals(ConstantesINC.OID_CRIT_EXISTEN_X_UNIDADES)){
                query.append(" AND ROWNUM = 1)) > " + criterioReemplazo);
            }            
            
            query.append(" )) THEN 0 ELSE  ");
            query.append(" (CASE  WHEN ((EXISTS (SELECT st.VAL_SALD ");
            query.append(" FROM BEL_STOCK st, BEL_ESTAD_MERCA est ");
            query.append(" WHERE st.PROD_OID_PROD = " + oidProductoReemplazo);
            query.append(" AND st.ESME_OID_ESTA_MERC = est.OID_ESTA_MERC ");
            query.append(" AND est.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND est.COD_ESTA ='LD' ");
            query.append(" AND st.ALMC_OID_ALMA = (SELECT tipoSolPais.ALMC_OID_ALMA ");
            query.append(" FROM PED_TIPO_SOLIC_PAIS tipoSolPais,  ");
            query.append(" PED_TIPO_SOLIC_PROCE tipoSolProc, BEL_OPERA ope ");
            query.append(" WHERE tipoSolPais.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND tipoSolProc.TSPA_OID_TIPO_SOLI_PAIS = tipoSolPais.OID_TIPO_SOLI_PAIS ");
            query.append(" AND tipoSolProc.OPER_OID_OPER = ope.OID_OPER ");
            query.append(" AND ope.COD_OPER = 'INC020' ");
            query.append(" AND ROWNUM = 1)) ");
            query.append(" ) AND ((SELECT st.VAL_SALD ");
            query.append(" FROM BEL_STOCK st, BEL_ESTAD_MERCA est ");
            query.append(" WHERE st.PROD_OID_PROD = " + oidProductoReemplazo);
            query.append(" AND st.ESME_OID_ESTA_MERC = est.OID_ESTA_MERC ");
            query.append(" AND est.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND est.COD_ESTA ='LD' ");
            query.append(" AND st.ALMC_OID_ALMA = (SELECT tipoSolPais.ALMC_OID_ALMA ");
            query.append(" FROM PED_TIPO_SOLIC_PAIS tipoSolPais,  ");
            query.append(" PED_TIPO_SOLIC_PROCE tipoSolProc, BEL_OPERA ope ");
            query.append(" WHERE tipoSolPais.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND tipoSolProc.TSPA_OID_TIPO_SOLI_PAIS = tipoSolPais.OID_TIPO_SOLI_PAIS ");
            query.append(" AND tipoSolProc.OPER_OID_OPER = ope.OID_OPER ");
            query.append(" AND ope.COD_OPER = 'INC020' ");            
            query.append(" AND ROWNUM = 1)) > 0 ");            
            query.append(" )) THEN 1 ELSE 0 END)  ");
            query.append(" END  REEMP_VALIDO ");
            query.append(" FROM DUAL ");*/
            
        } else if(oidCriterioReemplazo.equals(ConstantesINC.OID_CRIT_INMED_SIGUI_DESPACHO)){
        
            // sapaza -- PER-SiCC-2012-0977 -- 30/01/2013
            UtilidadesLog.info("DAOClientePremiacionConcurso.reemplazoValido(Long oidCriterioReemplazo, Long oidProducto, Long oidProductoReemplazo, Integer criterioReemplazo, Long oidPais): Salida");       
            return Boolean.TRUE;
            
            /*query.append(" SELECT CASE  WHEN ((EXISTS (SELECT st.VAL_SALD ");
            query.append(" FROM BEL_STOCK st, BEL_ESTAD_MERCA est ");
            query.append(" WHERE st.PROD_OID_PROD = " + oidProductoReemplazo);
            query.append(" AND st.ESME_OID_ESTA_MERC = est.OID_ESTA_MERC ");
            query.append(" AND est.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND est.COD_ESTA ='LD' ");
            query.append(" AND st.ALMC_OID_ALMA = (SELECT tipoSolPais.ALMC_OID_ALMA ");
            query.append(" FROM PED_TIPO_SOLIC_PAIS tipoSolPais,  ");
            query.append(" PED_TIPO_SOLIC_PROCE tipoSolProc, BEL_OPERA ope ");
            query.append(" WHERE tipoSolPais.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND tipoSolProc.TSPA_OID_TIPO_SOLI_PAIS = tipoSolPais.OID_TIPO_SOLI_PAIS ");
            query.append(" AND tipoSolProc.OPER_OID_OPER = ope.OID_OPER ");
            query.append(" AND ope.COD_OPER = 'INC020' ");
            query.append(" AND ROWNUM = 1)) ");
            query.append(" ) AND ((SELECT st.VAL_SALD ");
            query.append(" FROM BEL_STOCK st, BEL_ESTAD_MERCA est ");
            query.append(" WHERE st.PROD_OID_PROD = " + oidProductoReemplazo);
            query.append(" AND st.ESME_OID_ESTA_MERC = est.OID_ESTA_MERC ");
            query.append(" AND est.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND est.COD_ESTA ='LD' ");
            query.append(" AND st.ALMC_OID_ALMA = (SELECT tipoSolPais.ALMC_OID_ALMA ");
            query.append(" FROM PED_TIPO_SOLIC_PAIS tipoSolPais,  ");
            query.append(" PED_TIPO_SOLIC_PROCE tipoSolProc, BEL_OPERA ope ");
            query.append(" WHERE tipoSolPais.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND tipoSolProc.TSPA_OID_TIPO_SOLI_PAIS = tipoSolPais.OID_TIPO_SOLI_PAIS ");
            query.append(" AND tipoSolProc.OPER_OID_OPER = ope.OID_OPER ");
            query.append(" AND ope.COD_OPER = 'INC020' ");
            query.append(" AND ROWNUM = 1)) > 0 ");
            query.append(" )) THEN 1 ELSE 0 END REEMP_VALIDO ");
            query.append(" FROM DUAL ");     */       
        }
            
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if(((BigDecimal)rs.getValueAt(0, "REEMP_VALIDO")).intValue()==1){
        
            UtilidadesLog.info("DAOClientePremiacionConcurso.reemplazoValido(Long oidCriterioReemplazo, Long oidProducto, Long oidProductoReemplazo, Integer criterioReemplazo, Long oidPais): Salida");       
            return Boolean.TRUE;
            
        } else {
        
            UtilidadesLog.info("DAOClientePremiacionConcurso.reemplazoValido(Long oidCriterioReemplazo, Long oidProducto, Long oidProductoReemplazo, Integer criterioReemplazo, Long oidPais): Salida");       
            return Boolean.FALSE;
        }
       
    }   
    
    
    // vbongiov -- Cambio 20090828 -- 8/06/2009
    private void actualizarBuzonMensajeDespacho(Long oidConsultora, Long oidMensaje, String numConcurso, String codSAPOrig, 
                                                String codSAPReem, String descReemp, String codVentaReem) throws MareException {    
        UtilidadesLog.info("DAOClientePremiacionConcurso.actualizarBuzonMensajeDespacho(Long oidConsultora, Long oidMensaje, String numConcurso, String codSAPOrig, String codSAPReem, String descReemp, String codVentaReem): Entrada");       
        
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        
        query.append(" UPDATE MSG_BUZON_MENSA ");
        query.append(" SET DATO_VARI_07 = 'Premio Reemplazo', ");
        query.append(" DATO_VARI_11 = '" + descReemp + "', ");
        query.append(" DATO_VARI_18 = '" + codSAPReem + "', ");
        query.append(" DATO_VARI_19 = '" + codVentaReem + "' ");
        query.append(" WHERE CLIE_OID_CLIE = " + oidConsultora);
        query.append(" AND MENS_OID_MENS = " + oidMensaje);
        query.append(" AND DATO_VARI_18 = '" + codSAPOrig + "' ");
        query.append(" AND DATO_VARI_17 = '" + numConcurso + "' ");
        
        try {
            bs = BelcorpService.getInstance();
            int rs = bs.dbService.executeUpdate(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Error " , e);
            throw new MareException(e);
        }
        
        UtilidadesLog.info("DAOClientePremiacionConcurso.actualizarBuzonMensajeDespacho(Long oidConsultora, Long oidMensaje, String numConcurso, String codSAPOrig, String codSAPReem, String descReemp, String codVentaReem): Salida");       
    }    
    
     // vbongiov -- Cambio 20090942 -- 28/07/2009
    public Long recuperarPuntBonifRecomocimiento(Long oidCliente, Concurso concurso) throws MareException {
       UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPuntBonifRecomocimiento(Long oidCliente, Concurso concurso): Entrada");                
                         
       RecordSet rs = new RecordSet();
       StringBuffer query = new StringBuffer();
       BelcorpService bs;

       try {
           bs = BelcorpService.getInstance();
       } catch (MareMiiServiceNotFoundException e) {
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }

       query.append(" SELECT NVL(SUM(sol.VAL_PUNT_BONI),0) VAL_PUNT_BONI ");   
       query.append(" FROM INC_SOLIC_CONCU_PUNTA sol ");  
       query.append(" WHERE sol.CLIE_OID_CLIE = " + oidCliente);  
       query.append(" AND sol.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());  
       
       try {
           rs = bs.dbService.executeStaticQuery(query.toString());
       } catch (Exception ex) {
           UtilidadesLog.error("ERROR ", ex);
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       
       UtilidadesLog.debug("rs: " + rs);
               
       if(rs.esVacio()){
           UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPuntBonifRecomocimiento(Long oidCliente, Concurso concurso): Salida");       
           return new Long(0);
           
       } else {
           UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPuntBonifRecomocimiento(Long oidCliente, Concurso concurso): Salida");       
           return Long.valueOf(((BigDecimal)rs.getValueAt(0, "VAL_PUNT_BONI")).toString());
       }       
    }
    
    // vbongiov -- Cambio 20090942 -- 28/07/2009
    public ArrayList recuperarSiguienteNivelDesc(Concurso concurso, BigDecimal puntaje) throws MareException {
      UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarSiguienteNivelDesc(Concurso concurso, Long puntaje): Entrada");                
                        
      RecordSet rs = new RecordSet();
      RecordSet rs1 = new RecordSet();
      StringBuffer query = new StringBuffer();
      StringBuffer query1 = new StringBuffer();
      BelcorpService bs;
      ArrayList salida = new ArrayList();

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT nivSup.NUM_NIVE, (nivSup.NUM_CANT_INIC_PUNT - " + puntaje + ") PUNTFALSUP, nivSup.VAL_DESC ");   
      query.append(" FROM INC_PARAM_GENER_PREMI prem, INC_PARAM_NIVEL_PREMI niv, INC_PARAM_NIVEL_PREMI nivSup ");   
      query.append(" WHERE prem.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());   
      query.append(" AND prem.TPRM_OID_TIPO_PION = " + ConstantesINC.OID_TIPO_PREM_NIVELES);   
      query.append(" AND niv.PAGP_OID_PARA_GENE_PREM = prem.OID_PARA_GENE_PREM ");   
      query.append(" AND " + puntaje + " BETWEEN niv.NUM_CANT_INIC_PUNT AND niv.NUM_CANT_FINA_PUNT ");   
      query.append(" AND nivSup.NUM_NIVE = (niv.NUM_NIVE + 1) ");   
      query.append(" AND nivSup.PAGP_OID_PARA_GENE_PREM = prem.OID_PARA_GENE_PREM ");   
      query.append(" UNION ");   
      query.append(" SELECT nivSup.NUM_NIVE, (nivSup.NUM_CANT_FIJA_PUNT - " + puntaje + ") PUNTFALSUP, nivSup.VAL_DESC ");   
      query.append(" FROM INC_PARAM_GENER_PREMI prem, INC_PARAM_NIVEL_PREMI niv, INC_PARAM_NIVEL_PREMI nivSup ");   
      query.append(" WHERE prem.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso()); 
      query.append(" AND prem.TPRM_OID_TIPO_PION != " + ConstantesINC.OID_TIPO_PREM_NIVELES);   
      query.append(" AND niv.PAGP_OID_PARA_GENE_PREM = prem.OID_PARA_GENE_PREM ");   
      query.append(" AND " + puntaje + " BETWEEN niv.NUM_CANT_FIJA_PUNT  AND nivSup.NUM_CANT_FIJA_PUNT ");   
      query.append(" AND nivSup.NUM_NIVE = (niv.NUM_NIVE + 1) ");   
      query.append(" AND nivSup.PAGP_OID_PARA_GENE_PREM = prem.OID_PARA_GENE_PREM ");   
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("rs: " + rs);
      
      if(rs.esVacio()){
      
        // Busco si el puntaje no es suficiente para alcanzar el primer nivel
        query1.append(" SELECT niv.num_nive, (niv.num_cant_inic_punt - " + puntaje + ") PUNTFALSUP, niv.VAL_DESC ");   
        query1.append(" FROM inc_param_gener_premi prem, inc_param_nivel_premi niv ");   
        query1.append(" WHERE prem.copa_oid_para_gral = " + concurso.getOidConcurso());   
        query1.append(" AND prem.tprm_oid_tipo_pion = " + ConstantesINC.OID_TIPO_PREM_NIVELES);   
        query1.append(" AND niv.pagp_oid_para_gene_prem = prem.oid_para_gene_prem ");   
        query1.append(" AND niv.num_nive = 1 ");   
        query1.append(" AND " + puntaje + " < niv.num_cant_inic_punt ");   
        query1.append(" UNION ");   
        query1.append(" SELECT niv.num_nive, (niv.num_cant_fija_punt - " + puntaje + ") PUNTFALSUP, niv.VAL_DESC ");   
        query1.append(" FROM inc_param_gener_premi prem, inc_param_nivel_premi niv ");   
        query1.append(" WHERE prem.copa_oid_para_gral = " + concurso.getOidConcurso());   
        query1.append(" AND prem.tprm_oid_tipo_pion != " + ConstantesINC.OID_TIPO_PREM_NIVELES);   
        query1.append(" AND niv.pagp_oid_para_gene_prem = prem.oid_para_gene_prem ");   
        query1.append(" AND niv.num_nive = 1 ");   
        query1.append(" AND " + puntaje + " < niv.num_cant_fija_punt  ");   
        
        
        try {
          rs1 = bs.dbService.executeStaticQuery(query1.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs1: " + rs1);
        
          if(rs1.esVacio()){
                
            // El puntaje es superior a todos los niveles
            salida.add("0");
            salida.add("");
            
            UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPuntBonifRecomocimiento(Long oidCliente, Concurso concurso): Salida");       
            return salida;
          
          } else {
            
              salida.add(((BigDecimal)rs1.getValueAt(0, "PUNTFALSUP")).toString());
              salida.add((String)rs1.getValueAt(0, "VAL_DESC"));     
          
              UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarSiguienteNivelDesc(Concurso concurso, Long puntaje): Salida");       
              return salida;
          }
      
      } else {
        
          salida.add(((BigDecimal)rs.getValueAt(0, "PUNTFALSUP")).toString());
          salida.add((String)rs.getValueAt(0, "VAL_DESC"));     
      
          UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarSiguienteNivelDesc(Concurso concurso, Long puntaje): Salida");       
          return salida;
      }
      
    }
    
    // sapaza -- PER-SiCC-2010-0479 -- 25/08/2010
        public ArrayList recuperarPuntajeRanking(Long oidCliente, String numeroConcurso, Periodo periodo) throws MareException {
      UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPuntajeRanking(Long oidCliente, String numeroConcurso, Periodo periodo): Entrada");                
                        
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      ArrayList salida = new ArrayList();

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      String codigoPeriodoAnterior = periodo.calcularPeriodoAnterior(1).getCodperiodo();
      
      query.append(" SELECT A.NUM_PUNT, ");   
      query.append("        A.NUM_RANK, ");   
      query.append("        A.COD_PERI ");         
      query.append("   FROM INC_RANKI_RECON A, MAE_CLIEN B ");   
      query.append("   WHERE B.OID_CLIE = " + oidCliente);   
      query.append("     AND A.COD_CLIE = B.COD_CLIE ");   
      query.append("     AND A.COD_CONC = '" + numeroConcurso + "' ");   
      query.append("     AND A.COD_PERI = '" + codigoPeriodoAnterior + "'");   
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }

      if(log.isDebugEnabled())      
        UtilidadesLog.debug("rs: " + rs);
      
      if(!rs.esVacio()){
          salida.add((String)rs.getValueAt(0, "COD_PERI"));   
          
          if(rs.getValueAt(0, "NUM_RANK")!=null)
            salida.add(((BigDecimal)rs.getValueAt(0, "NUM_RANK")).toString());
          else
            salida.add(null);
      } 
      
      UtilidadesLog.info("DAOClientePremiacionConcurso.recuperarPuntajeRanking(Long oidCliente, String numeroConcurso, Periodo periodo): Salida");       
      return salida;
    }
    
    
    // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
    public BigDecimal obtenerMontoRecuperado(Long oidPais, String numeroConcurso, String indicadorTipo, Integer secuenciaPeriodo) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.obtenerMontoRecuperado(Long oidPais): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        consulta.append("  SELECT REC.VAL_MONT ");
        consulta.append("    FROM INC_CONCU_RECOM_CAMPA_MONTO REC, SEG_PAIS PAI ");
        consulta.append("   WHERE PAI.OID_PAIS = " + oidPais);
        consulta.append("     AND REC.COD_PAIS = PAI.COD_PAIS ");
        consulta.append("     AND REC.NUM_CONC = '" + numeroConcurso + "'");
        consulta.append("     AND REC.IND_TIPO = '" + indicadorTipo + "'");
        consulta.append("     AND REC.SEC_CAMP = '" + secuenciaPeriodo + "'");

        BelcorpService bs = null;
        RecordSet rs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerMontoRecuperado: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if(!rs.esVacio()){               
            UtilidadesLog.info("DAOClientePremiacionConcurso.obtenerMontoRecuperado(Long oidPais): Salida");
            return ((BigDecimal)rs.getValueAt(0,0));        
        }

        UtilidadesLog.info("DAOClientePremiacionConcurso.obtenerMontoRecuperado(Long oidPais): Salida 2");

        return null;
    }
    
    // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
    public BigDecimal obtenerMontoBonificacion(Long oidPais, Long oidPeriodo, String numeroConcurso) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.obtenerMontoBonificacion(Long oidPais): Entrada");
                      
        StringBuffer consulta = new StringBuffer();
        consulta.append("  SELECT BON.VAL_BONR ");
        consulta.append("    FROM INC_BONIF_EFECT_CAMPA BON, SEG_PAIS PAI, CRA_PERIO CRA, SEG_PERIO_CORPO COR ");
        consulta.append("   WHERE PAI.OID_PAIS = " + oidPais);
        consulta.append("     AND CRA.OID_PERI = " + oidPeriodo);        
        consulta.append("     AND BON.COD_PAIS = PAI.COD_PAIS ");
        consulta.append("     AND COR.OID_PERI = CRA.PERI_OID_PERI ");
        consulta.append("     AND BON.COD_PERI = COR.COD_PERI ");
        consulta.append("     AND BON.NUM_CONC = '" + numeroConcurso + "'");

        BelcorpService bs = null;
        RecordSet rs = null;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerMontoRecuperado: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } //catch

        if(!rs.esVacio()){               
            UtilidadesLog.info("DAOClientePremiacionConcurso.obtenerMontoBonificacion(Long oidPais): Salida");
            return ((BigDecimal)rs.getValueAt(0,0));        
        }

        UtilidadesLog.info("DAOClientePremiacionConcurso.obtenerMontoBonificacion(Long oidPais): Salida 2");

        return null;
    }

    // sapaza -- PER-SiCC-2014-0081 -- 30/01/2014
    public void actualizarCandidataGanadora(Long oidConsultora, Long oidConcurso) throws MareException {    
        UtilidadesLog.info("DAOClientePremiacionConcurso.actualizarCandidataGanadora(Long oidConsultora, Long oidConcurso): Entrada");       
        
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        
        query.append(" UPDATE INC_CANDI_GANAD ");
        query.append("    SET VAL_REQU_PREM_SUPE = 1 ");
        query.append("  WHERE CLIE_OID_CLIE = " + oidConsultora);
        query.append("    AND COPA_OID_PARA_GRAL = " + oidConcurso);
        
        try {
            bs = BelcorpService.getInstance();
            int rs = bs.dbService.executeUpdate(query.toString());
            
            // sapaza -- PER-SiCC-2014-0854 -- 28/10/2014
            StringBuffer update = new StringBuffer();
            update.append("update INC_PREMI_ELEGI ");
            update.append("   set ind_pend = 4, COD_MOTI_INVA=14, ");
            update.append("       usu_modi = 'ADMIN', ");
            update.append("       fec_modi = SYSDATE ");
            update.append("where copa_oid_para_gral = " + oidConcurso);
            update.append("  and clie_oid_clie = " + oidConsultora);
            update.append("  and ind_pend = 1 ");
            
            bs.dbService.executeUpdate(update.toString());
            
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Error " , e);
            throw new MareException(e);
        }
        
        UtilidadesLog.info("DAOClientePremiacionConcurso.actualizarBuzonMensajeDespacho(Long oidConsultora, Long oidMensaje, String numConcurso, String codSAPOrig, String codSAPReem, String descReemp, String codVentaReem): Salida");       
    }    

    // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
    private void updatePremiosElegidosRechazados(PremiosElegidos premios, int codMotivoInvalido, String codigoUsuario) throws MareException {
       ArrayList aux1 = premios.obtenerPremiosRechazados(codMotivoInvalido);
       if (aux1.size() > 0) {
           Iterator it = aux1.iterator();
           StringBuffer oidPremiosElegidos = new StringBuffer();
           while (it.hasNext()) {
               oidPremiosElegidos.append(it.next());
               if (it.hasNext()) { 
                   oidPremiosElegidos.append(", ");
               }
           }
           StringBuffer query = new StringBuffer();
           query.append("UPDATE INC_PREMI_ELEGI ");
           query.append(" SET IND_PEND = 4, ");
           query.append("     COD_MOTI_INVA = " + codMotivoInvalido + ", ");
           query.append("     USU_MODI = '" + codigoUsuario + "', ");
           query.append("     FEC_MODI = SYSDATE ");
           query.append(" WHERE OID_PREM_ELEG IN ("+oidPremiosElegidos+")");
           
           try{
               BelcorpService.getInstance().dbService.executeUpdate(query.toString());
           }catch(Exception e){
               UtilidadesLog.error("ERROR",e);
               throw new MareException(e);
           }    
       }
    }

    // sapaza -- COL-SiCC-2014-0174 -- 20/06/2014
    public ArrayList obtenerPremiosReemplazoCompuesta(Long oidReemplazo) throws MareException {
        UtilidadesLog.info("DAOClientePremiacionConcurso.obtenerPremiosReemplazoCompuesta(Long oidReemplazo): Entrada");                
        UtilidadesLog.debug("oidReemplazo: " + oidReemplazo);
                    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        ArrayList salida = new ArrayList();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT PROD_OID_PROD, ");   
        query.append("        COD_VENT_FICT, "); 
        query.append("        NUM_UNID, ");  
        query.append("        IMP_PREC_PUBL "); 
        query.append("   FROM INC_REEMP_ARTIC_LOTE ");  
        query.append("  WHERE COMP_OID_REEM_ARTI_LOTE = " + oidReemplazo);  
        query.append("    AND IND_ACTI = 1 ");  
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if(log.isDebugEnabled())      
          UtilidadesLog.debug("rs: " + rs);
        
        if(!rs.esVacio()){
            for(int i=0; i< rs.getRowCount(); i++) {
                 DTOReemplazoArticuloLote dtoReemplazoArticuloLote = new DTOReemplazoArticuloLote();
                 dtoReemplazoArticuloLote.setProdOidProd(Long.valueOf(((BigDecimal)rs.getValueAt(i, "PROD_OID_PROD")).toString()));
                 dtoReemplazoArticuloLote.setCodVentFict((String)rs.getValueAt(i, "COD_VENT_FICT"));
                 dtoReemplazoArticuloLote.setNumUnid(Long.valueOf(((BigDecimal)rs.getValueAt(i, "NUM_UNID")).toString()));
                 dtoReemplazoArticuloLote.setImpPrecPubi((BigDecimal)rs.getValueAt(i, "IMP_PREC_PUBL"));
                 
                 salida.add(dtoReemplazoArticuloLote);
            }            
        
        }
        
        UtilidadesLog.info("DAOClientePremiacionConcurso.obtenerPremiosReemplazoCompuesta(Long oidReemplazo): Salida");                
        return salida;
    }
    
}
