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
 *  @author:  Dante Castiglione
 *  
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 *  
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOActualizarCtaCteDescalifica;
import es.indra.sicc.dtos.inc.DTOETramitarCierre;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.DescalificacionesLocalHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.PersistenceException;


public class DAOClientePremiacion {
    private UtilidadesLog log = new UtilidadesLog();
    
    /**
     * Obtiene la lista de tipos de cursos asistidos por cliente
     * @author Dante Castiglione
     */
    public void obtenerAsistenciaCursos(ClientePremiacion clientePremiacion)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerAsistenciaCursos(Clien"
            +"tePremiacion clientePremiacion):Entrada");

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
            query.append(" SELECT DISTINCT ");
            query.append(" TICU_OID_TIPO_CURS ");
            query.append(" FROM EDU_HISTO_CURSO, ");
            query.append(" EDU_MATRI_CURSO ");
            query.append(" WHERE MCUR_OID_CURS = OID_CURS ");
            query.append(" AND CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        HashMap tiposCursos = new HashMap();

        if (!respuesta.esVacio()) {
            for (int i = 0; i < respuesta.getRowCount(); i++) {
                BigDecimal tipoCurso = (BigDecimal) respuesta.getValueAt(i,
                        "TICU_OID_TIPO_CURS");
                tiposCursos.put((tipoCurso != null)
                    ? new Long(tipoCurso.longValue()) : null, null);
            }
        }

        clientePremiacion.setTiposCursosAsistidos(tiposCursos);
        UtilidadesLog.info("DAOClientePremiacion.obtenerAsistenciaCursos( "
            +"ClientePremiacion clientePremiacion):Salida");
    }

    /**
     * Obtiene la lista productos del cliente
     * @author Dante Castiglione
     */
    public void obtenerProductos(ClientePremiacion clientePremiacion)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerProductos("
            +"ClientePremiacion clientePremiacion):Entrada");

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
            query.append(" PROD_OID_PROD ");
            query.append(" FROM PED_SOLIC_POSIC A, ");
            query.append(" PED_SOLIC_CABEC B");
            query.append(" WHERE A.SOCA_OID_SOLI_CABE = OID_SOLI_CABE ");
            query.append(" AND CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());
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

        HashMap productos = clientePremiacion.getProductos();

        if (productos == null) {
            productos = new HashMap();
        }

        if (!respuesta.esVacio()) {
            for (int i = 0; i < respuesta.getRowCount(); i++) {
                productos.put(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "PROD_OID_PROD"))
                        .longValue()),null);
            }
        }

        clientePremiacion.setProductos(productos);
        UtilidadesLog.info("DAOClientePremiacion.obtenerProductos("
            +"ClientePremiacion clientePremiacion):Salida");
    }

    /*
     * Obtiene los Periodos para los cuales el cliente pasó al menos un pedido
     */
    public void obtenerPeriodosConPedidosCliente(
        ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info(
            "DAOClientePremiacion.obtenerPeriodosConPedidosCliente("
                +"ClientePremiacion clientePremiacion):Entrada");
        
        //jrivas 20/9/2006 Uso de acumulador
        /*Date menorFechaConcursos = FactoriaConcurso.getFactoriaConcurso()
                                                   .getMinPeriodoDesde()
                                                   .getFechaDesde();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strMenorFechaConcursos = sdf.format(menorFechaConcursos);*/
        
        HashMap periodos = new HashMap();
        Long oidPeriodo = FactoriaConcurso.getFactoriaConcurso().getMinPeriodoDesde().getOidPeriodo();

        // Recuperar los Periodos
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
            //jrivas 20/9/2006 Uso de acumulador
            query.append(" SELECT DISTINCT A.PERD_OID_PERI, COD_PERI, B.FEC_INIC, B.FEC_FINA, ");
            query.append(" B.CANA_OID_CANA, B.MARC_OID_MARC, B.PAIS_OID_PAIS ");
            query.append(" FROM PED_SOLIC_CABEC_ACUM2 A, ");
            query.append(" CRA_PERIO B, ");
            query.append(" SEG_PERIO_CORPO C, ");
            query.append(" CRA_PERIO D ");
            query.append(" WHERE A.PERD_OID_PERI = B.OID_PERI ");
            query.append(" AND B.PERI_OID_PERI = C.OID_PERI ");
            query.append(" AND D.OID_PERI = " + oidPeriodo);
            query.append(" AND A.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
            query.append(" AND B.FEC_INIC >= D.FEC_INIC ");
			query.append(" AND D.PAIS_OID_PAIS = B.PAIS_OID_PAIS ");
			query.append(" AND D.MARC_OID_MARC = B.MARC_OID_MARC ");
			query.append(" AND D.CANA_OID_CANA = B.CANA_OID_CANA ");
            query.append(" AND a.val_cant_pedi > 0 ");                          // JVM, sicc 20070376
            
            /*query.append(" SELECT DISTINCT A.PERD_OID_PERI, COD_PERI, FEC_INIC, FEC_FINA, CANA_OID_CANA, ");
            query.append(" B.MARC_OID_MARC, A.PAIS_OID_PAIS ");
            query.append(" FROM PED_SOLIC_CABEC A, ");
            query.append(" CRA_PERIO B, ");
            query.append(" SEG_PERIO_CORPO C, ");
            query.append(" PED_TIPO_SOLIC_PAIS PTSP, ");
            query.append(" PED_TIPO_SOLIC PTS, PED_SOLIC_CABEC CONSO  ");
            query.append(" WHERE A.PERD_OID_PERI = B.OID_PERI ");
            query.append(" AND B.PERI_OID_PERI = C.OID_PERI ");
            query.append(" AND A.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
            query.append(" AND B.FEC_INIC >= TO_DATE('" + strMenorFechaConcursos + "', 'dd/MM/yyyy') ");
            query.append(" AND A.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS ");
            query.append(" AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
            query.append(" AND PTS.IND_ANUL <> 1 ");
            query.append(" AND PTS.IND_DEVO <> 1 ");
            query.append(" AND A.IND_OC = 1 ");
            query.append(" AND A.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE(+) ");
            query.append(" AND NVL(CONSO.ESSO_OID_ESTA_SOLI, 1) <> " + ConstantesPED.ESTADO_SOLICITUD_ANULADO); */
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("respuesta : " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!respuesta.esVacio()) {
            for (int i = 0; i < respuesta.getRowCount(); i++) {
                Periodo periodo = new Periodo();
                periodo.setCodperiodo((String) respuesta.getValueAt(i,
                        "COD_PERI"));
                periodo.setFechaDesde((Date) 
                    respuesta.getValueAt(i, "FEC_INIC"));
                periodo.setFechaHasta((Date) 
                    respuesta.getValueAt(i, "FEC_FINA"));
                periodo.setOidCanal(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "CANA_OID_CANA"))
                            .longValue()));
                periodo.setOidMarca(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "MARC_OID_MARC"))
                            .longValue()));
                periodo.setOidPais(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "PAIS_OID_PAIS"))
                            .longValue()));

                Long oidPeri = new Long(((BigDecimal) respuesta.getValueAt(
                            i, "PERD_OID_PERI")).longValue());
                periodo.setOidPeriodo(oidPeri);
                periodos.put(oidPeri, periodo);
            }
        }

        clientePremiacion.setPeriodosConPedidos(periodos);
        UtilidadesLog.info("DAOClientePremiacion.obtenerPeriodosConPedidos"
            +"Cliente(ClientePremiacion clientePremiacion):Salida");
    }

    /**
     * Obtiene la lista de clientes en CandidataGanadora
     * @author Dante Castiglione
     */
    public DTOOIDs obtenerClientes(DTOETramitarCierre dtoe)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerClientes(DTOETramitar"
            +"Cierre dtoe):Entrada");

        BelcorpService bs1;
        RecordSet respuesta1;
        StringBuffer query1 = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

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
            query1.append(" FEC_INIC, ");
            query1.append(" FEC_FINA ");
            query1.append(" FROM CRA_PERIO ");
            query1.append(" WHERE OID_PERI = " + dtoe.getOidPeriodo());
            query1.append(" AND MARC_OID_MARC = " + dtoe.getOidMarca());
            query1.append(" AND CANA_OID_CANA = " + dtoe.getOidCanal());
            query1.append(" AND PAIS_OID_PAIS = " + dtoe.getOidPais());
            respuesta1 = bs1.dbService.executeStaticQuery(query1.toString());
            UtilidadesLog.debug("*** respuesta1: " + respuesta1);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Date fecDesde = null;
        String sfecDesde = null;
        Date fecHasta = null;
        String sfecHasta = null;

        if (!respuesta1.esVacio()) {
            fecDesde = (Date) respuesta1.getValueAt(0, "FEC_INIC");
            sfecDesde = sdf.format(fecDesde);

            fecHasta = (Date) respuesta1.getValueAt(0, "FEC_FINA");
            sfecHasta = sdf.format(fecHasta);
        }

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
            query2.append(" CLIE_OID_CLIE ");
            query2.append(" FROM INC_CANDI_GANAD gan, ");
            query2.append(" INC_CONCU_PARAM_GENER C, ");
            query2.append(" CRA_PERIO cra");
            query2.append(" WHERE COPA_OID_PARA_GRAL = OID_PARA_GRAL ");
            query2.append(" AND VAL_REQU_PREM_SUPE <> 1 ");
            query2.append(" AND BINC_OID_BASE_INCU IS NULL ");
            query2.append(" AND C.MARC_OID_MARC = " + dtoe.getOidMarca());
            query2.append(" AND C.CANA_OID_CANA = " + dtoe.getOidCanal());
            query2.append(" AND C.PAIS_OID_PAIS = " + dtoe.getOidPais());

            //jrivas inc 20450
            //query2.append(" AND PERD_OID_PERI = " + dtoe.getOidPeriodo());
            query2.append(" AND DIRI_OID_DIRI = " +
                ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS);

            //query2.append(" AND PERD_OID_PERI_EVAL = OID_PERI ");
            //query2.append(" AND FEC_INIC < TO_DATE('" + fecDesde + "', 
            //'dd-MM-yyyy')");
            //Cleal 9/8/2005            
            query2.append(" AND  ((gan.PERD_OID_PERI_EVAL is not NULL  ");
            query2.append(" and gan.PERD_OID_PERI_EVAL = cra.OID_PERI ");
            query2.append(" AND cra.FEC_INIC <= TO_DATE('" + sfecDesde +
                "', 'dd-MM-yyyy')) ");
            query2.append(" or (gan.PERD_OID_PERI_EVAL is NULL)) ");
            query2.append(" AND c.IND_ACTI = 1 ");
            query2.append(" GROUP BY CLIE_OID_CLIE ");

            respuesta2 = bs2.dbService.executeStaticQuery(query2.toString());
            UtilidadesLog.debug("*** respuesta2: " + respuesta2);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        ArrayList oids = new ArrayList();
        long cliente;

        if (!respuesta2.esVacio()) {
            for (int i = 0; i < respuesta2.getRowCount(); i++) {
                cliente = ((BigDecimal) 
                    respuesta2.getValueAt(i, "CLIE_OID_CLIE")).longValue();

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

                // 2.2) Verificar si el el cliente pertenece a la zona que 
                //se cierra: 
                //Hacer un join entre mae_clien_unida_admin y cra_perio 
                //filtrando por: 
                //ind_acti en true 
                //oid de cliente 
                //zona igual a zona recibida por parametro 
                //fec_inic correspondiente a oid_peri_ini sea igual a null o 
                //mayor o igual a fecDesde 
                //fec_fina correspondiente a oid_peri_fin sea igual a null o
                //menor o igual a fecHasta 
                //Tener en cuenta que el join con cra_perio es outer dado que
                //pueden venir en null 
                //A continuacion se muestra un ejemplo: 
                try {
                    query3.append(" SELECT c.ztad_oid_terr_admi ");
                    query3.append(" FROM mae_clien_unida_admin c, ");
                    query3.append(" cra_perio cp1, ");
                    query3.append(" cra_perio cp2, ");
                    query3.append(" ZON_TERRI_ADMIN ta, ");
                    query3.append(" ZON_SECCI sexy, ");
                    query3.append(" ZON_ZONA zon ");
                    query3.append(" WHERE c.perd_oid_peri_ini = cp1.oid_peri ");
                    query3.append(" AND c.perd_oid_peri_fin = cp2.oid_peri(+) ");
                    query3.append(" AND c.ind_acti = 1 ");
                    query3.append(" AND c.clie_oid_clie = " + cliente);

                    //query3.append(" AND c.ztad_oid_terr_admi = " 
                    //+ dtoe.getOidZona());
                    //Cleal 11/8/2005
                    query3.append(" AND  zon.OID_ZONA = " + dtoe.getOidZona());
                    query3.append(" AND  sexy.ZZON_OID_ZONA = zon.OID_ZONA ");
                    query3.append(" AND  ta.ZSCC_OID_SECC  = sexy.OID_SECC  ");
                    query3.append(
                        " AND  ta.OID_TERR_ADMI  = c.ZTAD_OID_TERR_ADMI ");

                    query3.append(" AND (cp1.fec_inic IS NULL ");
                    query3.append(" OR TO_DATE ('" + sfecDesde +
                        "', 'dd-MM-yyyy') >= cp1.fec_inic ");
                    query3.append(" ) ");
                    query3.append(" AND (cp2.fec_fina IS NULL ");
                    query3.append(" OR TO_DATE ('" + sfecHasta +
                        "', 'dd-MM-yyyy') <= cp2.fec_fina ");
                    query3.append(" ) ");

                    /*
                     * c.perd_oid_peri_ini = cp1.oid_peri
                      AND  c.perd_oid_peri_fin = cp2.oid_peri(+)
                      AND  c.ind_acti = 1
                      AND  c.clie_oid_clie = 2024
                      and  zon.OID_ZONA = 13
                      and  sexy.ZZON_OID_ZONA = zon.OID_ZONA
                      and  ta.ZSCC_OID_SECC  = sexy.OID_SECC
                      and  ta.OID_TERR_ADMI  = c.ZTAD_OID_TERR_ADMI
                      AND (cp1.fec_inic IS NULL OR TO_DATE ('30-07-2005', 
                      //'dd-MM-yyyy') >= cp1.fec_inic )
                      AND (cp2.fec_fina IS NULL OR TO_DATE ('19-08-2005', 
                      //'dd-MM-yyyy') <= cp2.fec_fina )
                     *
                     */
                    respuesta3 = bs3.dbService.executeStaticQuery(query3
                        .toString());
                    UtilidadesLog.debug("*** respuesta3: " + respuesta3);
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }

                // 2.3) Si se cumple el punto anterior (se recupera un 
                //registro)
                // entonces agregar el oid de cliente a la lista de OIDs 
                //a retornar. 
                if (!respuesta3.esVacio()) {
                    oids.add(new Long(cliente));
                }
            }
        }

        Long[] oidsDto = (Long[]) oids.toArray(new Long[oids.size()]);
        DTOOIDs dto = new DTOOIDs();
        dto.setOids(oidsDto);
        UtilidadesLog.debug("*** Dto retornado: " + dto);
        UtilidadesLog.info("DAOClientePremiacion.obtenerClientes(DTOETramit"
            +"arCierre dtoe):Salida");

        return dto;
    }

    /**
     * Este metodo utiliza la entidad ConcursoParametrosGenerales , por favor 
     * recordar colocar la EJB Local reference a esta entidad en el MON desde 
     * donde se llame a este metodo
     *
     * @author Dante Castiglione
     */
    public void rellenarClientePremiacionConcursoRecomendacion(
        Concurso concurso, ClientePremiacion clientePremiacion)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.rellenarClientePremiacionConc"
            +"ursoRecomendacion(Concurso concurso, ClientePremiacion clientePr"
            +"emiacion):Entrada");

        ClientePremiacionConcurso clientePremiacionConcurso = clientePremiacion
            .getClientePremiacionConcurso(concurso.getOidConcurso());

        DAOClientePremiacionConcurso daoClientePremiacionConcurso = 
            new DAOClientePremiacionConcurso();
        daoClientePremiacionConcurso.getPedidosRecomendante(clientePremiacion,
            clientePremiacionConcurso);
        daoClientePremiacionConcurso.getRecomendados(clientePremiacion,
            clientePremiacionConcurso);
        UtilidadesLog.info("DAOClientePremiacion.rellenarClientePremiacionCo"
            +"ncursoRecomendacion(Concurso concurso, ClientePremiacion "
            +"clientePremiacion):Salida");
    }

    /**
     * @author Dante Castiglione
     * Modificado: Carlos Leal 01/07/2005
     */
    public Periodo obtenerPeriodo(DTOETramitarCierre dtoe)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerPeriodo(DTOETramitar"
            +"Cierre dtoe):Entrada");

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
            query.append(" PAIS_OID_PAIS, ");
            query.append(" CRA.OID_PERI ");
            query.append(" FROM CRA_PERIO CRA, ");
            query.append(" SEG_PERIO_CORPO SEG ");
            query.append(" WHERE CRA.PERI_OID_PERI = SEG.OID_PERI ");
            query.append(" AND PAIS_OID_PAIS = " + dtoe.getOidPais());
            query.append(" AND MARC_OID_MARC = " + dtoe.getOidMarca());
            query.append(" AND CANA_OID_CANA = " + dtoe.getOidCanal());
            query.append(" AND CRA.OID_PERI = " + dtoe.getOidPeriodo());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Periodo periodo = new Periodo();

        if (!respuesta.esVacio()) {
            periodo.setCodperiodo((String) respuesta.getValueAt(0, "COD_PERI"));
            periodo.setFechaDesde((Date) respuesta.getValueAt(0, "FEC_INIC"));
            periodo.setFechaHasta((Date) respuesta.getValueAt(0, "FEC_FINA"));
            periodo.setOidCanal(new Long(
                    ((BigDecimal) respuesta.getValueAt(0, "CANA_OID_CANA"))
                    .longValue()));
            periodo.setOidMarca(new Long(
                    ((BigDecimal) respuesta.getValueAt(0, "MARC_OID_MARC"))
                    .longValue()));
            periodo.setOidPais(new Long(
                    ((BigDecimal) respuesta.getValueAt(0, "PAIS_OID_PAIS"))
                    .longValue()));
            periodo.setOidPeriodo(new Long(
                    ((BigDecimal) respuesta.getValueAt(0, "OID_PERI"))
                    .longValue()));
        }

        UtilidadesLog.info("DAOClientePremiacion.obtenerPeriodo(DTOETramitar"
            +"Cierre dtoe):Salida");

        return periodo;
    }

    /**
    * @return Periodo
    * @version 1.00 23/06/2005
    * @author: Carlos Leal
    * Descripcion: obtiene un periodo hacia el futuro o hacia el pasado del 
    * periodo recibido por parametro de acuerdo al desplazamiento tambien 
    * recibido por parametro.
    */
    public Periodo obtenerPeriodo(Long oidPeriodo, int desplazamiento)
        throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerPeriodo(Long "
            +"oidPeriodo, int desplazamiento):Entrada");

        BelcorpService bs;
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT P.PAIS_OID_PAIS, P.MARC_OID_MARC, ");
        query.append(" P.CANA_OID_CANA,PC.COD_PERI,  ");
        query.append(" P.OID_PERI, P.FEC_INIC, P.FEC_FINA");
        query.append(" FROM CRA_PERIO P,  ");
        query.append(" SEG_PERIO_CORPO PC,  ");
        query.append(" (SELECT P1.OID_PERI, P1.FEC_INIC, P1.PAIS_OID_PAIS,  ");
        query.append(" P1.MARC_OID_MARC, P1.CANA_OID_CANA  ");
        query.append(" FROM CRA_PERIO P1) PEE  ");
        query.append(" WHERE P.PERI_OID_PERI = PC.OID_PERI  ");
        query.append(" AND PEE.OID_PERI = " + oidPeriodo);

        if (desplazamiento >= 0) {
            query.append(" AND P.FEC_INIC >= PEE.FEC_INIC  ");
        } else if (desplazamiento < 0) {
            query.append("AND P.FEC_INIC <= PEE.FEC_INIC ");
        }

        query.append(" AND P.PAIS_OID_PAIS = PEE.PAIS_OID_PAIS  ");
        query.append(" AND P.MARC_OID_MARC = PEE.MARC_OID_MARC  ");
        query.append(" AND P.CANA_OID_CANA = PEE.CANA_OID_CANA  ");

        if (desplazamiento >= 0) {
            query.append(" ORDER BY P.FEC_INIC ASC  ");
        } else if (desplazamiento < 0) {
            query.append(" ORDER BY P.FEC_INIC DESC ");
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****obtenerPeriodo**** rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Periodo perDesp = null;

        UtilidadesLog.debug("****obtenerPeriodo**** desplazamiento " +
            desplazamiento);
        desplazamiento = Math.abs(desplazamiento);

        //desplazamiento -= 1;
        //UtilidadesLog.info("****obtenerPeriodo**** desplazamiento -1 " +
        //desplazamiento);
        if (rs.getRowCount() > desplazamiento) {
            if ((rs != null) && (rs.getRowCount() >= desplazamiento)) {
                perDesp = new Periodo();
                perDesp.setCodperiodo((String) rs.getValueAt(desplazamiento,
                        "COD_PERI"));
                perDesp.setOidCanal(new Long(
                        ((BigDecimal) rs.getValueAt(desplazamiento,
                            "CANA_OID_CANA")).longValue()));
                perDesp.setOidMarca(new Long(
                        ((BigDecimal) rs.getValueAt(desplazamiento,
                            "MARC_OID_MARC")).longValue()));
                perDesp.setOidPais(new Long(
                        ((BigDecimal) rs.getValueAt(desplazamiento,
                            "PAIS_OID_PAIS")).longValue()));
                perDesp.setOidPeriodo(new Long(((BigDecimal) 
                    rs.getValueAt(desplazamiento, "OID_PERI")).longValue()));
                perDesp.setFechaDesde((Date) rs.getValueAt(desplazamiento,
                        "FEC_INIC"));
                perDesp.setFechaHasta((Date) rs.getValueAt(desplazamiento,
                        "FEC_FINA"));
            }
        }

        UtilidadesLog.info("DAOClientePremiacion.obtenerPeriodo(Long "
            +"oidPeriodo, int desplazamiento):Salida");

        return perDesp;
    }

    /**
    * @return Periodo
    * Modificado: Carlos Leal 23/06/2005
    */
    public Periodo obtenerPeriodo(DTOETramitarCierre dtoe, int desplazamiento)
        throws MareException {
        return this.obtenerPeriodo(dtoe.getOidPeriodo(), desplazamiento);
    }

    /**
    * @author Dante Castiglione
    */
    public void rellenarClientePremiacion(ClientePremiacion clientePremiacion,
        Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.rellenarClientePremiacion("
            +"ClientePremiacion clientePremiacion, Long oidPeriodo):Entrada");
            
        long comienzo = System.currentTimeMillis();

        //1) Obtener Periodo: 
        DTOETramitarCierre dto = new DTOETramitarCierre();
        dto.setOidPais(clientePremiacion.getOidPais());
        dto.setOidMarca(clientePremiacion.getOidMarca());
        dto.setOidCanal(clientePremiacion.getOidCanal());
        dto.setOidPeriodo(oidPeriodo);
        clientePremiacion.setPeriodo(this.obtenerPeriodo(dto));

        //2) Recuperar periodo primerContacto 
        BelcorpService bsPrimerContacto;
        RecordSet respuestaPrimerContacto;
        StringBuffer queryPrimerContacto = new StringBuffer();

        try {
            bsPrimerContacto = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            // vbongiov -- 16/10/2006
            queryPrimerContacto.append(" SELECT ");
            queryPrimerContacto.append(" D.FEC_INIC, ");
            queryPrimerContacto.append(" D.FEC_FINA, ");
            queryPrimerContacto.append(" D.CANA_OID_CANA, ");
            queryPrimerContacto.append(" D.MARC_OID_MARC, ");
            queryPrimerContacto.append(" D.PAIS_OID_PAIS, ");
            queryPrimerContacto.append(" E.COD_PERI, ");
            queryPrimerContacto.append(" A.PERD_OID_PERI, ");
            queryPrimerContacto.append(" A.CLIE_OID_CLIE ");
            queryPrimerContacto.append(" FROM MAE_CLIEN_PRIME_CONTA A, ");
            queryPrimerContacto.append(" MAE_CLIEN C, ");
            queryPrimerContacto.append(" CRA_PERIO D, ");
            queryPrimerContacto.append(" SEG_PERIO_CORPO E ");
            queryPrimerContacto.append(" WHERE A.CLIE_OID_CLIE = C.OID_CLIE ");
            queryPrimerContacto.append(" AND A.PERD_OID_PERI = D.OID_PERI ");
            queryPrimerContacto.append(" AND D.PERI_OID_PERI = E.OID_PERI ");
            queryPrimerContacto.append(" AND D.PAIS_OID_PAIS = " +
                clientePremiacion.getOidPais());
            queryPrimerContacto.append(" AND D.MARC_OID_MARC = " +
                clientePremiacion.getOidMarca());
            queryPrimerContacto.append(" AND D.CANA_OID_CANA = " +
                clientePremiacion.getOidCanal());
            queryPrimerContacto.append(" AND A.CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());
            respuestaPrimerContacto = 
                bsPrimerContacto.dbService.executeStaticQuery(
                    queryPrimerContacto.toString());
                    
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                    
              UtilidadesLog.debug("*** respuestaPrimerContacto: " + respuestaPrimerContacto);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (respuestaPrimerContacto.esVacio()) {
            clientePremiacion.setPeriodoPrimerContacto(null);
        } else {
            Periodo periodoPrimerContacto = new Periodo();
            periodoPrimerContacto.setFechaDesde((Date) 
                respuestaPrimerContacto.getValueAt(0, "FEC_INIC"));
            periodoPrimerContacto.setFechaHasta((Date) 
                respuestaPrimerContacto.getValueAt(0, "FEC_FINA"));
            periodoPrimerContacto.setOidCanal(new Long(
                    ((BigDecimal) respuestaPrimerContacto.getValueAt(0,
                        "CANA_OID_CANA")).longValue()));
            periodoPrimerContacto.setOidMarca(new Long(
                    ((BigDecimal) respuestaPrimerContacto.getValueAt(0,
                        "MARC_OID_MARC")).longValue()));
            periodoPrimerContacto.setOidPais(new Long(
                    ((BigDecimal) respuestaPrimerContacto.getValueAt(0,
                        "PAIS_OID_PAIS")).longValue()));

            periodoPrimerContacto.setOidPeriodo(new Long(
                    ((BigDecimal) respuestaPrimerContacto.getValueAt(0,
                        "PERD_OID_PERI")).longValue()));

            //sapaza -- PER-SiCC-2010-0399 -- 01/07/2010                        
            periodoPrimerContacto.setCodperiodo((String) respuestaPrimerContacto.getValueAt(0, "COD_PERI"));                        

            clientePremiacion.setPeriodoPrimerContacto(periodoPrimerContacto);
        }

        //3) Recuperar montoPedidoPremiacion
        BelcorpService bsMonto;
        RecordSet respuestaMonto;
        StringBuffer queryMonto = new StringBuffer();

        try {
            bsMonto = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            //jrivas 20/9/2006 Uso de acumulador
            queryMonto.append(" SELECT DISTINCT SUM(VAL_MONT_TOTA) AS SUMA");
            queryMonto.append(" FROM PED_SOLIC_CABEC_ACUM2 A, ");
            queryMonto.append(" CRA_PERIO B ");
            queryMonto.append(" WHERE B.OID_PERI = " + clientePremiacion.getPeriodo().getOidPeriodo());
            queryMonto.append(" AND A.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
            queryMonto.append(" AND A.PERD_OID_PERI = B.OID_PERI ");
            
            /*queryMonto.append(" SELECT ");
            queryMonto.append(" SUM (A.VAL_PREC_CATA_TOTA_LOC_UNI_DEM) AS SUMA ");
            queryMonto.append(" FROM PED_SOLIC_CABEC A, ");
            //jrivas 12/9/2006 DBLG70000041
            queryMonto.append(" PED_TIPO_SOLIC_PAIS PTSP, ");
            queryMonto.append(" PED_TIPO_SOLIC PTS, ");
            queryMonto.append(" PED_SOLIC_CABEC CONSO  ");
            queryMonto.append(" WHERE A.IND_OC = 1 ");
            queryMonto.append(" AND A.CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());
            queryMonto.append(" AND A.PERD_OID_PERI = " +
                clientePremiacion.getPeriodo().getOidPeriodo());
            //jrivas 12/9/2006 DBLG70000041
            queryMonto.append(" AND A.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS  ");
            queryMonto.append(" AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI  ");
            queryMonto.append(" AND PTS.IND_ANUL <> 1  ");
            queryMonto.append(" AND PTS.IND_DEVO <> 1  ");
            queryMonto.append(" AND A.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE(+)  ");
            queryMonto.append(" AND NVL(CONSO.ESSO_OID_ESTA_SOLI, 1) <> " + ConstantesPED.ESTADO_SOLICITUD_ANULADO);*/
                
            respuestaMonto = bsMonto.dbService.executeStaticQuery(queryMonto.toString());

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("*** respuestaMonto: " + respuestaMonto);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if ((respuestaMonto.getValueAt(0, "SUMA")) == null) {
            UtilidadesLog.debug("dsetMontoPedidoPremiacion:  0");
            clientePremiacion.setMontoPedidoPremiacion(new BigDecimal(0));
        } else {
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("setMontoPedidoPremiacion = getValueAt(0, " +
                respuestaMonto.getValueAt(0, "SUMA"));
            clientePremiacion.setMontoPedidoPremiacion((BigDecimal) 
                respuestaMonto.getValueAt(0, "SUMA"));
        }        
        
        // vbongiov -- 21/06/06 -- DBLG500000775         
        RecordSet rs1;
        StringBuffer query1 = new StringBuffer();
        
        try {
            query1.append(" SELECT COD_EMPL ");
            query1.append(" FROM MAE_CLIEN_DATOS_ADICI ");
            query1.append(" WHERE CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());

            rs1 = bsMonto.dbService.executeStaticQuery(query1.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("rs1: " + rs1);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (rs1.esVacio()) {
            clientePremiacion.setOidCodigoEmpleado(null);
        } else {
            String codEmpleado = (String)rs1.getValueAt(0, "COD_EMPL");
            clientePremiacion.setOidCodigoEmpleado(codEmpleado!=null?codEmpleado:null);
        }

        // vbongiov -- 29/06/06 -- DBLG500000723    
        RecordSet rs2;
        StringBuffer query2 = new StringBuffer();
        
        try {
            query2.append(" SELECT ZON.COD_ZONA, TERR.COD_TERR, REG.COD_REGI ");
            query2.append(" FROM MAE_CLIEN_UNIDA_ADMIN UNA,  ZON_TERRI_ADMIN TERRA,  ZON_SECCI SEC, ");
            query2.append(" ZON_ZONA ZON, ZON_TERRI TERR, ZON_REGIO REG ");
            query2.append(" WHERE UNA.ZTAD_OID_TERR_ADMI = TERRA.OID_TERR_ADMI ");
            query2.append(" AND TERRA.TERR_OID_TERR = TERR.OID_TERR ");
            query2.append(" AND TERRA.ZSCC_OID_SECC = SEC.OID_SECC ");
            query2.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA ");
            query2.append(" AND ZON.ZORG_OID_REGI = REG.OID_REGI ");
            
            // sapaza -- PER-SiCC-2013-0608 -- 11/06/2013
            query2.append(" AND UNA.PERD_OID_PERI_FIN IS NULL ");
            //query2.append(" AND UNA.IND_ACTI = 1 ");
            
            query2.append(" AND UNA.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());

            rs2 = bsMonto.dbService.executeStaticQuery(query2.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
              UtilidadesLog.debug("rs2: " + rs2);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!rs2.esVacio()) {
            if(clientePremiacion.getDatosPersonales()!=null){
                clientePremiacion.getDatosPersonales().setCodZona((String)rs2.getValueAt(0, "COD_ZONA"));
                clientePremiacion.getDatosPersonales().setCodTerritorio(rs2.getValueAt(0, "COD_TERR").toString());
                
                //sapaza -- PER-SiCC-2011-0677 -- 10/11/2010  
                clientePremiacion.getDatosPersonales().setCodRegion(rs2.getValueAt(0, "COD_REGI").toString());
            } else {
                UtilidadesLog.debug("no hay datos personales");
                
                DatosPersonales datosPersonales = new DatosPersonales();
                datosPersonales.setCodZona((String)rs2.getValueAt(0, "COD_ZONA"));
                datosPersonales.setCodTerritorio(rs2.getValueAt(0, "COD_TERR").toString());
                
                //sapaza -- PER-SiCC-2011-0677 -- 10/11/2010  
                datosPersonales.setCodRegion((String)rs2.getValueAt(0, "COD_REGI"));
                
                clientePremiacion.setDatosPersonales(datosPersonales);
            }
        }

        //4) descalificacion
        // INC 20638        
        //this.obtenerDescalificacionesCliente(clientePremiacion);
        
        // jrivas BLO-01 
        RecordSet rs3;
        StringBuffer query3 = new StringBuffer();

        try {        
            query3.append(" SELECT CB.CLIE_OID_CLIE ");
            query3.append("  FROM MAE_CLIEN_BLOQU CB, MAE_ACCIO_PROCE_BLOQU APB, MAE_ACCIO_BLOQU AB ");
            query3.append(" WHERE CB.FEC_DESB IS NULL ");
            query3.append("   AND APB.TIBQ_OID_TIPO_BLOQ = CB.TIBQ_OID_TIPO_BLOQ ");
            query3.append("   AND APB.PAIS_OID_PAIS = " + clientePremiacion.getOidPais());
            query3.append("   AND AB.OID_ACCI_BLOQ = APB.MABL_OID_ACCI_BLOQ ");
            query3.append("   AND AB.COD_ACCI_BLOQ = 'EN'  ");
            query3.append("   AND APB.MAPB_OID_PROC_BLOQ = (SELECT PB.OID_PROC_BLOQ ");
            query3.append("                                    FROM MAE_PROCE_BLOQU PB ");
            query3.append("                                   WHERE PB.COD_PROC_BLOQ = 'CO') ");
            query3.append("   AND CB.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());

            rs3 = bsMonto.dbService.executeStaticQuery(query3.toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("rs3: " + rs3);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!rs3.esVacio()) {
            clientePremiacion.setClienteBloqueado(true);
        } 
        // jrivas BLO-01 

         // sapaza -- PER-SiCC-2012-0712 -- 06/11/2012
         /*try {
             queryMonto = new StringBuffer();
             queryMonto.append(" SELECT PQ_PLANI.INC_FN_OBTEN_PUNTA_RETAI(" + clientePremiacion.getOidPais()+", ");
             queryMonto.append(clientePremiacion.getOidCliente() + ", " + clientePremiacion.getPeriodo().getOidPeriodo()+ ") SUMA FROM DUAL ");
             
             respuestaMonto = bsMonto.dbService.executeStaticQuery(queryMonto.toString());

             if (respuestaMonto.esVacio()) {
                 clientePremiacion.setMontoPuntajeRetail(new BigDecimal(0));
             } else {    
                 clientePremiacion.setMontoPuntajeRetail((BigDecimal)respuestaMonto.getValueAt(0, "SUMA"));
             }
             
             if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                            
               UtilidadesLog.debug("*** rs4: " + respuestaMonto);
         } catch (Exception e) {
             UtilidadesLog.error("ERROR ", e);
             throw new MareException(e,
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }*/
        
        UtilidadesLog.info("DAOClientePremiacion.rellenarClientePremiacion("
            +"ClientePremiacion clientePremiacion, Long oidPeriodo):Salida");
    }

    /**
     * Este metodo utiliza la entidad Descalificaciones , porfavor recordar 
     * colocar la EJB Local reference a esta entidad en el MON desde donde se 
     * llame a este metodo
     *
     */
    public void actualizarDescalificaciones(
        ClientePremiacionConcurso clientePremiacionConcurso,
        ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.actualizarDescalificaciones("
            +"ClientePremiacionConcurso clientePremiacionConcurso, ClientePrem"
            +"iacion clientePremiacion):Entrada");

        DescalificacionesLocalHome descalificacionesHome = this.getDescalificacionesLocalHome();

        try {
            descalificacionesHome.create(new Date(System.currentTimeMillis()),
                clientePremiacion.getOidCliente(),
                clientePremiacionConcurso.getOidConcurso(),
                clientePremiacion.getPeriodo().getOidPeriodo(), new Long(
                clientePremiacionConcurso.getDescalificaClientePorSolicitud()));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOClientePremiacion.actualizarDescalificaciones("
            +"ClientePremiacionConcurso clientePremiacionConcurso, ClientePrem"
            +"iacion clientePremiacion):Salida");
    }

    /**
     * Este metodo utiliza la entidad CuentaCorrientePuntos , porfavor recordar 
     * colocar la EJB Local reference a esta entidad en el MON desde donde se 
     * llame a este metodo
     *
     */
    public void actualizarCuentaCorriente(
        ClientePremiacionConcurso clientePremiacionConcurso,
        ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.actualizarCuentaCorriente("
            +"ClientePremiacionConcurso clientePremiacionConcurso, ClientePremi"
            +"acion clientePremiacion):Entrada");

        DTOActualizarCtaCteDescalifica dto = 
            new DTOActualizarCtaCteDescalifica();
        dto.setOidConcurso(clientePremiacionConcurso.getOidConcurso());
        dto.setOidCliente(clientePremiacion.getOidCliente());
        dto.setOidPeriodo(clientePremiacion.getPeriodo().getOidPeriodo());

        //jrivas 19/8/2005 INC 20598
        if (clientePremiacionConcurso.getDescalificaClientePorSolicitud() == 
            ConstantesINC.CAUSA_DESCALIF_ACTIVIDAD) {
            dto.setDescripcion(ConstantesINC.DESC_FALTA_ACTIVIDAD);
        } else {
            if (clientePremiacionConcurso.getDescalificaClientePorSolicitud() 
                == ConstantesINC.CAUSA_DESCALIF_CONSTANCIA) {
                dto.setDescripcion(ConstantesINC.DESC_FALTA_CONSTANCIA);
            }
        }
        
        this.actualizarCuentaCorrienteDescalificacion(dto);
        UtilidadesLog.info("DAOClientePremiacion.actualizarCuentaCorriente(Cl"
            +"ientePremiacionConcurso clientePremiacionConcurso, ClientePremia"
            +"cion clientePremiacion):Salida");
    }

    public void actualizarCuentaCorrienteDescalificacion(
        DTOActualizarCtaCteDescalifica dto) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.actualizarCuentaCorrienteDe"
            +"scalificacion(DTOActualizarCtaCteDescalifica dto):Entrada");

        BelcorpService bsPuntos;
        RecordSet respuestaPuntos;
        StringBuffer queryPuntos = new StringBuffer();

        try {
            bsPuntos = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            queryPuntos.append(" SELECT ");
            queryPuntos.append(" SUM (NUM_PUNT) AS SUMA_PUNTOS, ");
            queryPuntos.append(" SUM (NUM_PUNT_BONI) AS SUMA_PUNTOS_BONIFICADOS, "); //sapaza -- COL-SiCC-2014-0175 -- 04/06/2014           
            queryPuntos.append(" SUM (NUM_PUNT_EXIG) AS SUMA_PUNTOS_EXIGIDOS ");
            queryPuntos.append(" FROM INC_CUENT_CORRI_PUNTO ");
            queryPuntos.append(" WHERE COPA_OID_PARA_GRAL = " +
                dto.getOidConcurso());
            queryPuntos.append(" AND CLIE_OID_CLIE = " + dto.getOidCliente());
            respuestaPuntos = bsPuntos.dbService.executeStaticQuery(
                queryPuntos.toString());
                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                
              UtilidadesLog.debug("respuestaPuntos : " + respuestaPuntos);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!respuestaPuntos.esVacio()) {
            int sumaNumPuntos = 
                (respuestaPuntos.getValueAt(0, "SUMA_PUNTOS") != null)
                ? ((BigDecimal) respuestaPuntos.getValueAt(0, "SUMA_PUNTOS"))
                    .intValue() : 0;
            int sumaNumPuntosExigidos = (respuestaPuntos.getValueAt(0,
                    "SUMA_PUNTOS_EXIGIDOS") != null)
                ? ((BigDecimal) respuestaPuntos.getValueAt(0,
                    "SUMA_PUNTOS_EXIGIDOS")).intValue() : 0;
            int sumaNumPuntosBonificados = (respuestaPuntos.getValueAt(0,
                    "SUMA_PUNTOS_BONIFICADOS") != null)
                ? ((BigDecimal) respuestaPuntos.getValueAt(0,
                    "SUMA_PUNTOS_BONIFICADOS")).intValue() : 0;
                    
            UtilidadesLog.debug("sumaNumPuntos : " + sumaNumPuntos);
            UtilidadesLog.debug("sumaNumPuntosExigidos : " + sumaNumPuntosExigidos);
            UtilidadesLog.debug("sumaNumPuntosBonificados : " + sumaNumPuntosBonificados);

            if ((sumaNumPuntos > 0) || (sumaNumPuntosExigidos > 0) || (sumaNumPuntosBonificados > 0)) {
                if (sumaNumPuntos > 0) {
                    sumaNumPuntos = (-1) * sumaNumPuntos;
                } else {
                    sumaNumPuntos = 0;
                }

                if (sumaNumPuntosExigidos > 0) {
                    sumaNumPuntosExigidos = (-1) * sumaNumPuntosExigidos;
                } else {
                    sumaNumPuntosExigidos = 0;
                }

                //sapaza -- COL-SiCC-2014-0175 -- 04/06/2014
                if (sumaNumPuntosBonificados > 0) {
                    sumaNumPuntosBonificados = (-1) * sumaNumPuntosBonificados;
                } else {
                    sumaNumPuntosBonificados = 0;
                }
                
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("sumaNumPuntos : " + sumaNumPuntos);
                  UtilidadesLog.debug("sumaNumPuntosExigidos : " + sumaNumPuntosExigidos);
                  UtilidadesLog.debug("sumaNumPuntosBonificados : " + sumaNumPuntosBonificados);
                }  

                CuentaCorrientePuntosLocalHome cuentaCorrientePuntosHome = this.getCuentaCorrientePuntosLocalHome();
                CuentaCorrientePuntosLocal cuentaCorrientePuntos = null;

                try {
                    cuentaCorrientePuntos = 
                            cuentaCorrientePuntosHome.create(new Integer(
                                sumaNumPuntos),
                            new Integer(sumaNumPuntosExigidos),
                            new Date(System.currentTimeMillis()),
                            dto.getOidConcurso(), dto.getOidCliente(),
                            dto.getOidPeriodo(),
                            ConstantesINC.TIPO_MOVIMIENTO_CARGO);
                            
                    cuentaCorrientePuntos.setNumMovimiento(new Integer(
                            cuentaCorrientePuntos.getOid().intValue()));
                    cuentaCorrientePuntos.setVal_desc(dto.getDescripcion());
                    
                    //sapaza -- COL-SiCC-2014-0175 -- 04/06/2014
                    cuentaCorrientePuntos.setPuntosBonificados(sumaNumPuntosBonificados);
                    
                    cuentaCorrientePuntosHome.merge(cuentaCorrientePuntos);       
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

            }
        }

        UtilidadesLog.info("DAOClientePremiacion.actualizarCuentaCorrienteDe"
            +"scalificacion(DTOActualizarCtaCteDescalifica dto):Salida");
    }

    public void actualizaCtaCteIncentivos(SolicitudConcurso solicitudConcurso,
        Solicitud solicitud) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.actualizaCtaCteIncentivos("
            +"SolicitudConcurso solicitudConcurso, Solicitud solicitud)"
            +":Entrada");

        DTOActualizarCtaCteDescalifica dto = 
            new DTOActualizarCtaCteDescalifica();
        dto.setOidConcurso(solicitudConcurso.getOidConcurso());
        dto.setOidCliente(solicitud.getCliente().getOidCliente());
        dto.setOidPeriodo(solicitud.getPeriodo().getOidPeriodo());

        //jrivas 19/8/2005 INC 20598
        if (solicitudConcurso.getDescalificaClientePorSolicitud() 
            == ConstantesINC.CAUSA_DESCALIF_ACTIVIDAD) {
            dto.setDescripcion(ConstantesINC.DESC_FALTA_ACTIVIDAD);
        } else {
            if (solicitudConcurso.getDescalificaClientePorSolicitud() 
                == ConstantesINC.CAUSA_DESCALIF_CONSTANCIA) {
                dto.setDescripcion(ConstantesINC.DESC_FALTA_CONSTANCIA);
            }
        }

        this.actualizarCuentaCorrienteDescalificacion(dto);
        UtilidadesLog.info("DAOClientePremiacion.actualizaCtaCteIncentivos("
            +"SolicitudConcurso solicitudConcurso, Solicitud solicitud)"
            +":Salida");
    }

    /** Metodo: obtenerDescalificacionesCliente
       * Autor: Julián Rivas
       * Fecha: 24/8/2005
       * INC 20638
       */
    private void obtenerDescalificacionesCliente(
        ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerDescalificaciones"
            +"Cliente(ClientePremiacion clientePremiacion):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        query.append(" SELECT id.OID_DESC, id.FEC_DESC, id.CLIE_OID_CLIE, ");
        query.append(
            " id.COPA_OID_PARA_GRAL, id.PERD_OID_PERI, id.CADE_OID_CAUS_DESC ");
        query.append(" FROM INC_DESCA id, inc_concu_param_gener con ");
        query.append(" WHERE id.CLIE_OID_CLIE = " +
            clientePremiacion.getOidCliente());
        /*query.append(" AND id.PERD_OID_PERI = " +
            clientePremiacion.getPeriodo().getOidPeriodo());*/
        query.append(" and con.IND_ACTI = 1 ");
        query.append(" and con.OID_PARA_GRAL = ID.COPA_OID_PARA_GRAL ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
            UtilidadesLog.debug("******* rs " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info("DAOClientePremiacion.obtenerDescalificaciones"
                +"Cliente(ClientePremiacion clientePremiacion):Salida");

            return;
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            BigDecimal bdOidCon = (BigDecimal) rs.getValueAt(i,
                    "COPA_OID_PARA_GRAL");
            clientePremiacion.getClientePremiacionConcurso(new Long(
                    bdOidCon.longValue())).setDescalificado(true);
        }

        UtilidadesLog.info("DAOClientePremiacion.obtenerDescalificacionesCli"
            +"ente(ClientePremiacion clientePremiacion):Salida");
    }
    
    public DTOOIDs obtenerClientesPerf(DTOETramitarCierre dtoe, String tipoCierre) throws MareException {
        /*
         * Autor : JVM
         * Fecha : 26-Mar-2006
         * Desc  : SICC-20070148 se agrega el parametro tipoCierre en el metodo obtenerClientesPers
         */
       long comienzo = System.currentTimeMillis();
        UtilidadesLog.info("DAOClientePremiacion.obtenerClientesPerf(DTOETramitar" +
        "Cierre dtoe, String tipoCierre["+tipoCierre+"]):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error",  e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT C.CLIE_OID_CLIE ");
            query.append("   FROM MAE_CLIEN_UNIDA_ADMIN C, ");
            query.append("        CRA_PERIO CP1, ");
            query.append("        (SELECT FEC_INIC, FEC_FINA ");
            query.append("           FROM CRA_PERIO ");
            query.append("          WHERE OID_PERI = " + dtoe.getOidPeriodo() + ") PER_REF ");
            
            /*
             * Autor : JVM
             * Fecha : 26-Mar-2007
             * Desc  : SICC-20070148, filtra por zonas cuando tipo cierre es diferente a Periodo
             */
            if (tipoCierre != ConstantesFAC.TIPO_CIERRE_PERIODO){
                query.append("        , ");
                query.append("        ZON_TERRI_ADMIN TA, ");
                query.append("        ZON_SECCI SEXY, ");
                query.append("        ZON_ZONA ZON ");
            }
            
            query.append("  WHERE C.PERD_OID_PERI_INI = CP1.OID_PERI     ");
            query.append("    AND C.IND_ACTI = 1                         ");
            query.append("    AND C.CLIE_OID_CLIE IN (                   ");
            query.append("           SELECT   CLIE_OID_CLIE              ");
            query.append("               FROM INC_CANDI_GANAD GAN,       ");
            query.append("                    INC_CONCU_PARAM_GENER C,   ");
            query.append("                    INC_PARAM_GENER_PREMI PRE, ");
            query.append("                    INC_REQUI_PREMI REQ, ");
            query.append("                    (SELECT FEC_INIC, FEC_FINA ");
            query.append("                       FROM CRA_PERIO ");
            query.append("                      WHERE OID_PERI = " + dtoe.getOidPeriodo() + ") PER_REF ");
            query.append("              WHERE GAN.COPA_OID_PARA_GRAL = C.OID_PARA_GRAL ");
            query.append("                AND PRE.COPA_OID_PARA_GRAL = C.OID_PARA_GRAL ");
            
            // sapaza -- PER-SiCC-2013-0608 -- 03/06/2013
            query.append(" AND (((" + dtoe.getOidPeriodo() + " BETWEEN PRE.PERD_OID_PERI_INIC AND PRE.PERD_OID_PERI) ");
            query.append("      AND PRE.PERD_OID_PERI_INIC IS NOT NULL) OR  (PRE.PERD_OID_PERI IS NULL)  ");
            query.append("      OR ((PRE.PERD_OID_PERI_INIC IS NULL) AND PRE.PERD_OID_PERI = " + dtoe.getOidPeriodo() + ")) ");
            
            // sapaza -- Cambio 20090929 -- 25/02/2010
            /*query.append("                 AND ((REQ.VADE_OID_VALI_DEUD IS NULL AND (PRE.PERD_OID_PERI = " + dtoe.getOidPeriodo());
            query.append("                                   OR PRE.PERD_OID_PERI IS NULL )) ");
            query.append("                      OR   (REQ.VADE_OID_VALI_DEUD IS NOT NULL)) ");*/
            
            query.append("                AND REQ.COPA_OID_PARA_GRAL(+) = C.OID_PARA_GRAL");
            
            // sapaza -- PER-SiCC-2010-0175 -- 14/04/2010
            query.append("                AND PRE.TPRM_OID_TIPO_PION <> " + ConstantesINC.TIPO_PREMIACION_BOLSA_PREMIOS);
            
            query.append("                AND GAN.VAL_REQU_PREM_SUPE <> 1 ");
            query.append("                AND GAN.BINC_OID_BASE_INCU IS NULL ");

            /*
             * Autor : JVM
             * Fecha : 12-Jul-2007
             * Desc  : SICC-20070351, filtra las consultoras que este descalifcadas
             */
            query.append("                AND CLIE_OID_CLIE NOT IN ( ");
            query.append("                     SELECT ");
            query.append("                        DSC.CLIE_OID_CLIE ");
            query.append("                     FROM ");
            query.append("                        INC_DESCA DSC ");
            query.append("                     WHERE ");
            query.append("                       DSC.COPA_OID_PARA_GRAL = C.OID_PARA_GRAL ");
            query.append("                     ) ");
            
            query.append("                AND C.MARC_OID_MARC        = " + dtoe.getOidMarca());
            query.append("                AND C.CANA_OID_CANA        = " + dtoe.getOidCanal());
            query.append("                AND C.PAIS_OID_PAIS        = " + dtoe.getOidPais());
            query.append("                AND C.DIRI_OID_DIRI        = " + ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS);
            
            //jrivas 20080535 Se saca la validación de último Periodo Evaluado
            /*query.append("                AND (   (GAN.PERD_OID_PERI_EVAL IS NULL) ");
            query.append("                     OR (SELECT FEC_FINA ");
            query.append("                           FROM CRA_PERIO ");
            query.append("                          WHERE OID_PERI = GAN.PERD_OID_PERI_EVAL) <= PER_REF.FEC_FINA ");
            query.append("                    ) ");*/
            
            query.append("                AND C.IND_ACTI = 1 ");
            query.append("           GROUP BY CLIE_OID_CLIE) ");

            /*
             * Autor : JVM
             * Fecha : 26-Mar-2007
             * Desc  : SICC-20070148, filtra por zonas cuando tipo cierre es diferente a Periodo
             */
            if (tipoCierre != ConstantesFAC.TIPO_CIERRE_PERIODO){

                query.append("    AND ZON.OID_ZONA = " + dtoe.getOidZona());
                query.append("    AND SEXY.ZZON_OID_ZONA = ZON.OID_ZONA ");
                query.append("    AND TA.ZSCC_OID_SECC = SEXY.OID_SECC ");
                query.append("    AND TA.OID_TERR_ADMI = C.ZTAD_OID_TERR_ADMI ");
            }
            
            query.append("    AND PER_REF.FEC_INIC >= CP1.FEC_INIC ");
            query.append("    AND (   (C.PERD_OID_PERI_FIN IS NULL) "); 
            query.append("         OR (SELECT FEC_FINA ");
            query.append("               FROM CRA_PERIO ");
            query.append("              WHERE OID_PERI = C.PERD_OID_PERI_FIN) <= PER_REF.FEC_FINA ");
            query.append("        )         ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** respuesta: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("Error",  e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        ArrayList oids = new ArrayList();
        long cliente;

        if (!respuesta.esVacio()) {
            for (int i = 0; i < respuesta.getRowCount(); i++) {
                cliente = ((BigDecimal)respuesta.getValueAt(i, "CLIE_OID_CLIE")).longValue();
                oids.add(new Long(cliente));
            }
        }
        
        Long[] oidsDto = (Long[]) oids.toArray(new Long[oids.size()]);
        DTOOIDs dto = new DTOOIDs();
        dto.setOids(oidsDto);
        UtilidadesLog.debug("*** Dto retornado: " + dto);
        UtilidadesLog.info("DAOClientePremiacion.obtenerClientesPerf(DTOETramit"
            +"arCierre dtoe):Salida");

        UtilidadesLog.warn("obtenerClientesPerf " + (System.currentTimeMillis() - comienzo));
        return dto;
    }  
    
    // jrivas BLO-01 
    public boolean validarClienteBloqueado(Long oidCliente, Long oidPais) throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.validarClienteBloqueado():Entrada");
        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {        
            query.append(" SELECT CB.CLIE_OID_CLIE ");
            query.append("  FROM MAE_CLIEN_BLOQU CB, MAE_ACCIO_PROCE_BLOQU APB, MAE_ACCIO_BLOQU AB ");
            query.append(" WHERE CB.FEC_DESB IS NULL ");
            query.append("   AND APB.TIBQ_OID_TIPO_BLOQ = CB.TIBQ_OID_TIPO_BLOQ ");
            query.append("   AND APB.PAIS_OID_PAIS = " + oidPais);
            query.append("   AND AB.OID_ACCI_BLOQ = APB.MABL_OID_ACCI_BLOQ ");
            query.append("   AND AB.COD_ACCI_BLOQ = 'EN'  ");
            query.append("   AND APB.MAPB_OID_PROC_BLOQ = (SELECT PB.OID_PROC_BLOQ ");
            query.append("                                    FROM MAE_PROCE_BLOQU PB ");
            query.append("                                   WHERE PB.COD_PROC_BLOQ = 'CO') ");
            query.append("   AND CB.CLIE_OID_CLIE = " + oidCliente);

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!rs.esVacio()) {
            UtilidadesLog.info("DAOPremiosConsuelo.validarClienteBloqueado():Salida TRUE");
            return true;
        } else {
            UtilidadesLog.info("DAOPremiosConsuelo.validarClienteBloqueado():Salida FALSE");
            return false;        
        }
    }    
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    public void actualizarAsignacionPremiosPendientes(ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.actualizarAsignacionPremiosPendientes(ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion):Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        String oidAsignacionPremioPend = "";

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        int cantAsig = clientePremiacionConcurso.getAsignacionPremiosPendientes().size();
        ArrayList asigPrePenArray = clientePremiacionConcurso.getAsignacionPremiosPendientes();
        
        for(int i=0; i < cantAsig; i++){
            oidAsignacionPremioPend = oidAsignacionPremioPend + "," + asigPrePenArray.get(i);
        }        
                
        query.append(" UPDATE INC_ASIGN_PREMI_PENDI premPen ");   
        query.append(" SET premPen.VAES_OID_VALO_ESTA = " + ConstantesINC.OID_ESTADO_MORO_PASO_PED_CAMP_ANT + ", ");   
        query.append(" premPen.PERD_OID_PERI_APRO = " + clientePremiacion.getPeriodo().getOidPeriodo() + ", ");   
        query.append(" premPen.FEC_APRO = SYSDATE ");   
        query.append(" WHERE premPen.OID_ASIG_PREM_PEND IN ( " + oidAsignacionPremioPend.substring(1) + ") ");   
        
        try {
              int cant = bs.dbService.executeUpdate(query.toString());     
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        UtilidadesLog.info("DAOClientePremiacion.actualizarAsignacionPremiosPendientes(ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion):Salida");
    }
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    public void actualizarAsignacionPremiosPendientesCierre(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.actualizarAsignacionPremiosPendientesCierre(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion):Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        StringBuffer query1 = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT premPen.OID_ASIG_PREM_PEND, ");   
        query.append("        (SELECT NVL(SUM(cuenta.IMP_PEND),0) ");   
        query.append("           FROM CCC_MOVIM_CUENT_CORRI cuenta, CRA_PERIO C, CRA_PERIO D ");   
        query.append("          WHERE cuenta.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
        query.append("            AND C.OID_PERI = prempen.perd_oid_peri_vali ");   
        query.append("            AND D.PAIS_OID_PAIS = C.PAIS_OID_PAIS ");   
        query.append("            AND D.MARC_OID_MARC = C.MARC_OID_MARC ");   
        query.append("            AND D.CANA_OID_CANA = C.CANA_OID_CANA ");   
        query.append("            AND D.FEC_INIC <= C.FEC_INIC ");   
        query.append("            AND cuenta.PERD_OID_PERI = D.OID_PERI) DEUDA ");                   
        query.append(" FROM INC_ASIGN_PREMI_PENDI premPen, CRA_PERIO perTope, ");   
        query.append(" CRA_PERIO perMax, INC_REQUI_PREMI reqPrem ");   
        query.append(" WHERE premPen.COPA_OID_PARA_GRAL = " + clientePremiacionConcurso.getOidConcurso());   
        query.append(" AND premPen.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
        query.append(" AND premPen.VAES_OID_VALO_ESTA = " + ConstantesINC.OID_ESTADO_MORO_REGISTRADO);
        query.append(" AND reqPrem.COPA_OID_PARA_GRAL = premPen.COPA_OID_PARA_GRAL ");   
        query.append(" AND reqPrem.VADE_OID_VALI_DEUD IS NOT NULL ");   
        query.append(" AND perMax.OID_PERI = reqPrem.PERD_OID_PERI_MAXI ");   
        query.append(" AND premPen.PERD_OID_PERI_TOPE = perTope.OID_PERI ");   
        query.append(" AND perTope.FEC_INIC <= perMax.FEC_INIC ");   
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("rs: " + rs);
        
        if(!rs.esVacio()){
        
            int cant = rs.getRowCount();
            
            query1.append("BEGIN ");
            
            for(int i=0; i < cant; i++){
            
                if(((BigDecimal)rs.getValueAt(i, "DEUDA")).doubleValue() > 0  &&
                   ((BigDecimal)rs.getValueAt(i, "DEUDA")).doubleValue() > 0.00 ) {
                   
                   if(concurso.getPeriodoMaxi().equals(clientePremiacion.getPeriodo())){
                   
                       query1.append(" UPDATE INC_ASIGN_PREMI_PENDI premPen ");   
                       query1.append(" SET premPen.VAES_OID_VALO_ESTA = " + ConstantesINC.OID_ESTADO_MORO_DEUDORA_CIERRE_Z_PER_MAX + ", ");   
                       query1.append(" premPen.PERD_OID_PERI_APRO = " + clientePremiacion.getPeriodo().getOidPeriodo() + ", ");   
                       query1.append(" premPen.FEC_APRO = SYSDATE ");   
                       query1.append(" WHERE premPen.OID_ASIG_PREM_PEND = " + ((BigDecimal)rs.getValueAt(i, "OID_ASIG_PREM_PEND")).toString() + "; "); 
                   }
                   
               } else {
               
                   query1.append(" UPDATE INC_ASIGN_PREMI_PENDI premPen ");   
                   query1.append(" SET premPen.VAES_OID_VALO_ESTA = " + ConstantesINC.OID_ESTADO_MORO_AL_DIA_CIERRE_Z + ", ");   
                   query1.append(" premPen.PERD_OID_PERI_APRO = " + clientePremiacion.getPeriodo().getOidPeriodo() + ", ");   
                   query1.append(" premPen.FEC_APRO = SYSDATE ");   
                   query1.append(" WHERE premPen.OID_ASIG_PREM_PEND = " + ((BigDecimal)rs.getValueAt(i, "OID_ASIG_PREM_PEND")).toString() + "; "); 
               }
                            
            }            
            
            if(!query1.toString().equals("BEGIN ")) {
                query1.append("  END;");         
            
                try {
                      bs.dbService.executeUpdate(query1.toString());     
                } catch (Exception e){       
                      e.printStackTrace();
                      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }  
            }    
        }
        
        UtilidadesLog.info("DAOClientePremiacion.actualizarAsignacionPremiosPendientesCierre(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion):Salida");
    }
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    public void obtenerDeudaPeriodoCierreMenosUno(ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerDeudaPeriodoCierreMenosUno(ClientePremiacion clientePremiacion): Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        DAOCRA daoCRA = new DAOCRA();
        
        Long periodoCierreMenosUno = daoCRA.obtienePeriodoAnterior (clientePremiacion.getPeriodo().getOidPeriodo());

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT NVL(SUM(cuenta.IMP_PEND),0) DEUDA ");
            buf.append(" FROM  CCC_MOVIM_CUENT_CORRI cuenta, ");
            buf.append("       (SELECT D.OID_PERI FROM CRA_PERIO C, CRA_PERIO D ");
            buf.append("        WHERE C.OID_PERI = " + periodoCierreMenosUno);
            buf.append("          AND D.PAIS_OID_PAIS = C.PAIS_OID_PAIS  ");
            buf.append("          AND D.MARC_OID_MARC = C.MARC_OID_MARC  ");
            buf.append("          AND D.CANA_OID_CANA = C.CANA_OID_CANA  ");
            buf.append("          AND D.FEC_INIC <= C.FEC_INIC) periodos  ");
            buf.append(" WHERE cuenta.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());
            buf.append(" AND cuenta.PERD_OID_PERI = periodos.oid_peri");

            rs = bs.dbService.executeStaticQuery(buf.toString());
            UtilidadesLog.debug("rs : " + rs);

            if (!rs.esVacio()) {
            
                if(((BigDecimal)rs.getValueAt(0, "DEUDA")).doubleValue() > 0  &&
                   ((BigDecimal)rs.getValueAt(0, "DEUDA")).doubleValue() > 0.00 ) {
                   
                    clientePremiacion.setDeudaPeriodoCierreMenosUno(true);
                    clientePremiacion.setPeriodoCierreMenosUno(periodoCierreMenosUno);
                    
                    UtilidadesLog.info("DAOClientePremiacion.obtenerDeudaPeriodoCierreMenosUno(ClientePremiacion clientePremiacion): Salida");
                    
                } else {
                
                    clientePremiacion.setDeudaPeriodoCierreMenosUno(false);
                    
                    UtilidadesLog.info("DAOClientePremiacion.obtenerDeudaPeriodoCierreMenosUno(ClientePremiacion clientePremiacion): Salida");                    
                }
                
            } else {
                clientePremiacion.setDeudaPeriodoCierreMenosUno(false);                
                UtilidadesLog.info("DAOClientePremiacion.obtenerDeudaPeriodoCierreMenosUno(ClientePremiacion clientePremiacion): Salida");                    
            }
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

    }
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    public void creacionAsignacionPremiosPendientesCierre(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.creacionAsignacionPremiosPendientesCierre(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion):Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
                
        query.append(" INSERT INTO INC_ASIGN_PREMI_PENDI(OID_ASIG_PREM_PEND, COPA_OID_PARA_GRAL, CLIE_OID_CLIE, ");   
        query.append(" FEC_PROC, PERD_OID_PERI_PROC, FEC_SIST, ");  
        query.append(" VAL_MOTI, PERD_OID_PERI_VALI, PERD_OID_PERI_TOPE, ");  
        query.append(" VAES_OID_VALO_ESTA, PERD_OID_PERI_APRO, FEC_APRO) ");  
        query.append(" VALUES (INC_ASPP_SEQ.NEXTVAL, " + clientePremiacionConcurso.getOidConcurso() + ", " + clientePremiacion.getOidCliente() + ", ");  
        query.append(" TRUNC(SYSDATE), " + clientePremiacion.getPeriodo().getOidPeriodo() + ", SYSDATE, ");   
        query.append(" 'D', ");  
        
        if(concurso.getOidValidaDeuda().equals(ConstantesINC.OID_CAMP_ANT_PREMIACION)){
            query.append(clientePremiacion.getPeriodoCierreMenosUno() + ", ");  
        } else if (concurso.getOidValidaDeuda().equals(ConstantesINC.OID_CAMP_FINAL_VIGENCIA)){
            query.append(concurso.getPeriodoHasta().getOidPeriodo() + ", ");  
        }
        
        query.append(this.obtenerPeriodoMasDelta(clientePremiacion.getPeriodo().getOidPeriodo(), concurso.getNumPerioEspe()) + ", ");  
        
        query.append(ConstantesINC.OID_ESTADO_MORO_REGISTRADO + ", NULL, NULL)");  
        
        try {
             bs.dbService.executeUpdate(query.toString());     
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        UtilidadesLog.info("DAOClientePremiacion.creacionAsignacionPremiosPendientesCierre(Concurso concurso, ClientePremiacionConcurso clientePremiacionConcurso, ClientePremiacion clientePremiacion):Salida");
    }
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    public Long obtenerPeriodoMasDelta(Long oidPeriodo, Long delta) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerPeriodoMasDelta(Long oidPeriodo, Long delta):Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
                
        query.append(" SELECT B.oid_peri OID ");
        query.append(" FROM cra_perio A, cra_perio B ");
        query.append(" WHERE A.oid_peri = " + oidPeriodo + " AND ");
        query.append(" B.pais_oid_pais = A.pais_oid_pais AND ");
        query.append(" B.marc_oid_marc = A.marc_oid_marc AND ");
        query.append(" B.cana_oid_cana = A.cana_oid_cana AND ");
        query.append(" B.fec_inic >= A.fec_inic ");
        query.append(" ORDER BY B.fec_inic ");
        
        try {
             rs = bs.dbService.executeStaticQuery(query.toString());     
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        if(!rs.esVacio()){
          UtilidadesLog.info("DAOClientePremiacion.obtenerPeriodoMasDelta(Long oidPeriodo, Long delta):Salida");
          return Long.valueOf(((BigDecimal) rs.getValueAt(delta.intValue(), "OID")).toString());
        }
        
        return null;
        
    }

    private DescalificacionesLocalHome getDescalificacionesLocalHome() {
            return new DescalificacionesLocalHome();
    }

    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }

    // sapaza -- PER-SiCC-2014-0913 -- 10/11/2014  
    public String obtenerParametroPais(Long oidPais, String codigoSistema, String nombreParametro) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.obtenerParametroPais(): Entrada ");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            query.append(" SELECT NVL(GEN_PKG_GENER.GEN_FN_NOMBRE_PARAM_PAIS(COD_PAIS, '");
            query.append(codigoSistema + "','" + nombreParametro + "'),'0') ");
            query.append(" FROM SEG_PAIS ");
            query.append(" WHERE OID_PAIS = " + oidPais);

            rs = bs.dbService.executeStaticQuery(query.toString());

            String valorParametro = rs.getValueAt(0, 0).toString();
            UtilidadesLog.info("DAOClientePremiacion.obtenerParametroPais(): Salida ");

            return valorParametro;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
    }

    // sapaza -- PER-SiCC-2015-0063 -- 16/02/2015  
    public boolean validarExigCampAnterior(Long oidPais, Long oidCliente, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOClientePremiacion.validarExigCampAnterior(Long oidPais, Long oidCliente, Long oidPeriodo): Entrada ");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            query.append(" SELECT PQ_PLANI.INC_FN_VALID_CAMPA_ANTER(" + oidPais + "," + oidCliente + "," + oidPeriodo + ") FROM DUAL ");

            rs = bs.dbService.executeStaticQuery(query.toString());

            String valorParametro = rs.getValueAt(0, 0).toString();
            
            if("1".equals(valorParametro))
                return true;
            else
                return false;

        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
    }
    
}
