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
 * @autor : Gustavo Viñales
 * @autor : Damasia Maneiro
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOETramitarCierre;
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
import java.util.Iterator;


public class DAOGerentes {
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOGerentes() {
    }

    /**
    * Fecha de Creacion: 08/06/2005
    * Autor: Damasia Maneiro
    * Comentario:
    */
    public void recuperarClientePremiacionConcurso(
        ClientePremiacionConcurso clientePremiacionConcurso,
        ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOGerentes.recuperarClientePremiacionConcurso(Cli"
            +"entePremiacionConcurso clientePremiacionConcurso, ClientePremia"
            +"cion clientePremiacion): Entrada");

        StringBuffer query = new StringBuffer(); // inc. 18973
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;
        DTOOIDs dtoOIDs = new DTOOIDs();
        Periodo periodo = new Periodo();
        ArrayList regiones = clientePremiacion
            .getUnidadesAdministrativasGerenciadas().getRegiones();
        ArrayList secciones = clientePremiacion
            .getUnidadesAdministrativasGerenciadas().getSecciones();
        ArrayList subGerencias = clientePremiacion
            .getUnidadesAdministrativasGerenciadas().getSubGerencias();
        ArrayList zonas = clientePremiacion
            .getUnidadesAdministrativasGerenciadas().getZonas();
        ArrayList unidades = null;
        int corte = 1000;

        query.append(" SELECT CG.PERD_OID_PERI_EVAL, CG.BINC_OID_BASE_INCU, ");
        query.append(" CG.VAL_REQU_PREM_SUPE");
        query.append(" ,PERIO.CANA_OID_CANA, PERIO.PAIS_OID_PAIS");

        //jrivas 27/8/2005
        //inc 20450
        query.append(" , PERD_OID_PERI ");
        query.append(" ,PERIO.MARC_OID_MARC, PERIO.FEC_FINA, PERIO.FEC_INIC");
        query.append(" FROM INC_CANDI_GANAD CG, CRA_PERIO PERIO");

        query.append(" WHERE PERIO.OID_PERI = CG.PERD_OID_PERI");
        query.append(" AND PERIO.PAIS_OID_PAIS = " +
            clientePremiacion.getOidPais());
        query.append(" AND PERIO.MARC_OID_MARC = " +
            clientePremiacion.getOidMarca());
        query.append(" AND PERIO.CANA_OID_CANA = " +
            clientePremiacion.getOidCanal());
        query.append(" AND CG.COPA_OID_PARA_GRAL = " +
            clientePremiacionConcurso.getOidConcurso());
        query.append(" AND CG.CLIE_OID_CLIE = " +
            clientePremiacion.getOidCliente());

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Concurso concurso = new DespacharPremiosHelper().obtenerConcurso(
            clientePremiacionConcurso.getOidConcurso());

        if (!rs.esVacio()) {
            if (rs.getValueAt(0, "PERD_OID_PERI_EVAL") != null) {
                periodo.setOidPeriodo(Long.valueOf(String.valueOf(
                    rs.getValueAt(0, "PERD_OID_PERI_EVAL"))));
            }

            Long periodoCandidataGanadora = new Long(((BigDecimal) 
                rs.getValueAt(0, "PERD_OID_PERI")).longValue());

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

            if (concurso.getNumeroPeriodos() != null) {
                clientePremiacionConcurso.setPeriodoDespachoDespuesObtencion(
                    daoClientePremiacion.obtenerPeriodo(dtoETramitarCierre2,
                        concurso.getNumeroPeriodos().intValue()));
            }

            periodo.setFechaDesde(Date.valueOf(String.valueOf(rs.getValueAt(0,
                            "FEC_INIC"))));
            periodo.setFechaHasta(Date.valueOf(String.valueOf(rs.getValueAt(0,
                            "FEC_FINA"))));
            periodo.setOidCanal(Long.valueOf(String.valueOf(rs.getValueAt(0,
                            "CANA_OID_CANA"))));
            periodo.setOidMarca(Long.valueOf(String.valueOf(rs.getValueAt(0,
                            "MARC_OID_MARC"))));
            periodo.setOidPais(Long.valueOf(String.valueOf(rs.getValueAt(0,
                            "PAIS_OID_PAIS"))));

            clientePremiacionConcurso.setUltimoPeriodoEvaluado(periodo);

            if (rs.getValueAt(0, "BINC_OID_BASE_INCU") != null) {
                clientePremiacionConcurso.setOidBaseIncumplida(Long.valueOf(
                        String.valueOf(rs
                            .getValueAt(0, "BINC_OID_BASE_INCU"))));
            }

            if (((BigDecimal) rs.getValueAt(0, "VAL_REQU_PREM_SUPE"))
                .intValue() > 0) {
                clientePremiacionConcurso.setRequisitosPremiacionSuperado(true);
            } else {
                clientePremiacionConcurso.setRequisitosPremiacionSuperado(false);
            }

            if (((regiones != null) && (regiones.size() > 0)) ||
                ((secciones != null) && (secciones.size() > 0)) ||
                ((subGerencias != null) && (subGerencias.size() > 0)) ||
                ((zonas != null) && (zonas.size() > 0))) {
                
                query = new StringBuffer();
                StringBuffer UA = new StringBuffer();
                int cantReg = 0;
                ArrayList reg = null;
                
                /*FactoriaConcurso factoria= FactoriaConcurso.getFactoriaConcurso();
           
                DTOOIDs dtoOids = new DTOOIDs();
                Long[] oids = { clientePremiacionConcurso.getOidConcurso() };
                dtoOids.setOids(oids);
          
                ArrayList concursos = factoria.getConcursosPorOID(dtoOids);
                Concurso concurso1 = (Concurso) concursos.get(0);
                      
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String strFechaDesde = sdf.format(concurso1.getPeriodoDesde().getFechaDesde());
                String strFechaHasta = sdf.format(concurso1.getPeriodoHasta().getFechaHasta());*/

                DespacharPremiosHelper despacharPremiosHelper = 
                    new DespacharPremiosHelper();
                Concurso concursoRecuperado = despacharPremiosHelper
                    .obtenerConcurso(clientePremiacionConcurso.getOidConcurso());


                //jrivas 20/9/2006 Uso de acumulador
                query.append(" SELECT VAL_MONT_TOTA AS PRECIO_CATALOGO_TOTAL_REAL, VAL_CANT_PEDI AS CANTIDAD");
                query.append(" FROM PED_SOLIC_CABEC_ACUM2 A, ZON_TERRI_ADMIN terrAdmin, ");
                query.append(" CRA_PERIO B ");
                query.append(" WHERE B.OID_PERI IN ( ");
                query.append(" SELECT B.OID_PERI ");
                query.append(" FROM CRA_PERIO PERINIC, CRA_PERIO B, CRA_PERIO PERFINA ");
    
                /*query.append(" SELECT COUNT(*) CANTIDAD, ");
                query.append(" SUM(SCAB.VAL_PREC_CATA_TOTA_LOC_UNI_DEM) ");
                query.append(" PRECIO_CATALOGO_TOTAL_REAL");
                query.append(" FROM PED_SOLIC_CABEC SCAB , ZON_TERRI_ADMIN terrAdmin, ");
                query.append(" CRA_PERIO periSolic,  ");
                //jrivas 12/9/2006 Aceptacion (inc. 7)
				query.append(" PED_TIPO_SOLIC_PAIS PTSP, ");
				query.append(" PED_TIPO_SOLIC PTS, ");
				query.append(" PED_SOLIC_CABEC CONSO  ");*/
                
                if ((subGerencias != null) && (subGerencias.size() != 0)) {
                
                    query.append(" , ZON_SECCI secc, ");
                    query.append(" ZON_ZONA zona, ");
                    query.append(" ZON_REGIO reg ");
    
                    query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                    query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                    query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");
    
                    cantReg = subGerencias.size();
                    reg = subGerencias;
    
                    for (int i = 0; i < cantReg; i++) {
                        UA.append((", "));
                        UA.append(reg.get(i));
                    }
    
                    query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                        UA.toString().substring(2) + " ) ");
                }
                
                if ((regiones != null) && (regiones.size() != 0)) {
                    query.append(" , ZON_SECCI secc, ");
                    query.append(" ZON_ZONA zona ");
    
                    query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                    query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
    
                    cantReg = regiones.size();
                    reg = regiones;
    
                    for (int i = 0; i < cantReg; i++) {
                        UA.append((", "));
                        UA.append(reg.get(i));
                    }
    
                    query.append(" AND zona.ZORG_OID_REGI IN ( " +
                        UA.toString().substring(2) + " ) ");
                
                }
    
                if ((zonas != null) && (zonas.size() != 0)) {
                    query.append(" , ZON_SECCI secc ");
    
                    query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
    
                    cantReg = zonas.size();
                    reg = zonas;
    
                    for (int i = 0; i < cantReg; i++) {
                        UA.append((", "));
                        UA.append(reg.get(i));
                    }
    
                    query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                        UA.toString().substring(2) + " ) ");
                }
                
                
                if ((secciones != null) && (secciones.size() != 0)) {
                
                    cantReg = secciones.size();
                    reg = secciones;
    
                    for (int i = 0; i < cantReg; i++) {
                        UA.append((", "));
                        UA.append(reg.get(i));
                    }
    
                    query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                        UA.toString().substring(2) + " ) ");
                }
    
                query.append(" AND PERINIC.OID_PERI = " + concursoRecuperado.getPeriodoDesde().getOidPeriodo());
                query.append(" AND PERFINA.OID_PERI = " + concursoRecuperado.getPeriodoHasta().getOidPeriodo());
                query.append(" AND B.FEC_INIC >= PERINIC.FEC_INIC ");
                query.append(" AND B.FEC_FINA <= PERFINA.FEC_FINA ");
                query.append(" AND PERINIC.PAIS_OID_PAIS = B.PAIS_OID_PAIS ");
                query.append(" AND PERINIC.MARC_OID_MARC = B.MARC_OID_MARC ");
                query.append(" AND PERINIC.CANA_OID_CANA = B.CANA_OID_CANA) ");
                query.append(" AND A.CLIE_OID_CLIE = " +clientePremiacion.getOidCliente());  
                query.append(" AND A.PERD_OID_PERI = B.OID_PERI ");
    
                /*query.append(" AND SCAB.ztad_oid_terr_admi = terrAdmin.oid_terr_admi ");
                query.append(" AND SCAB.IND_OC = 1");
                query.append(" AND SCAB.PERD_OID_PERI = periSolic.OID_PERI ");
                query.append(" AND periSolic.FEC_INIC >= TO_DATE('" + strFechaDesde + "', 'YYYY-MM-DD') ");
                query.append(" AND periSolic.FEC_FINA <= TO_DATE('" + strFechaHasta +  "', 'YYYY-MM-DD') ");
                //jrivas 12/9/2006 Aceptacion (inc. 7)
                query.append(" AND SCAB.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS  ");
                query.append(" AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI  ");
                query.append(" AND PTS.IND_ANUL <> 1  ");
                query.append(" AND PTS.IND_DEVO <> 1  ");
                query.append(" AND SCAB.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE(+)  ");
                query.append(" AND NVL(CONSO.ESSO_OID_ESTA_SOLI, 1) <> " + ConstantesPED.ESTADO_SOLICITUD_ANULADO);*/
                    
    
                try {
                    rs = (RecordSet) belcorpService.getInstance().dbService
                        .executeStaticQuery(query.toString());
                        
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                                        
                      UtilidadesLog.debug("rs  : " + rs);

                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                }
    
                if (!rs.esVacio()) {
                    BigDecimal montoPedidos = (BigDecimal) rs.getValueAt(0, "PRECIO_CATALOGO_TOTAL_REAL");
                    clientePremiacionConcurso.setMontoPedidos(montoPedidos==null?new BigDecimal(0):(BigDecimal) 
                        rs.getValueAt(0, "PRECIO_CATALOGO_TOTAL_REAL"));
                    clientePremiacionConcurso.setCantidadPedidos(((BigDecimal) 
                        rs.getValueAt(0, "CANTIDAD")).longValue());
                } else {
                    clientePremiacionConcurso.setMontoPedidos(new BigDecimal(0));
                    clientePremiacionConcurso.setCantidadPedidos(0);
                }
            } 
            clientePremiacionConcurso.setDirigidoA(concurso.getDirigidoA());
        }

        UtilidadesLog.info("DAOGerentes.recuperarClientePremiacionConcurso("
            +"ClientePremiacionConcurso clientePremiacionConcurso, ClientePre"
            +"miacion clientePremiacion):Salida");
    }

    /**
    * Fecha de Creacion: 07/07/2005
    * Autor: Damasia Maneiro
    * Modificado: 28/07/2006 jrivas
    */
    public HashMap recuperarRecomendadosGerente(Long oidPais, Long oidPeriodo)
        throws MareException {
        UtilidadesLog.info("DAOGerentes.recuperarRecomendadosGerente2(Long oidPais, Long oidPeriodo):Entrada");

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        Gerente gerente;
        HashMap gerentesRecomendantes = new HashMap();
        ClientePremiacionConcurso clienPremConcurso;
        ClientePremiacionRecomendado clienPremRecomendado;
        PedidoRecomendacion pedidoRecomendacion;
        DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
        Long concurso = null;
        Long recomendado = null;
        Long oidGerente = null;
        boolean encontro;
        boolean encontro2;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            //jrivas 1/9/2006 DBLG5000839
            //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5) Se agrega el Periodo
            query.append(" SELECT   CLGR_OID_CLIE_GERE_RECO, PDC.COPA_OID_PARA_GRAL, CG.CLIE_OID_CLIE,   ");
            query.append(" NUM_MONT_PEDI, NUM_UNID_PEDI, IND_PEDI_VALI, ");
            query.append(" p1.OID_PERI, P1.MARC_OID_MARC, P1.CANA_OID_CANA, "); 
            query.append(" P1.PAIS_OID_PAIS , P1.FEC_INIC, P1.FEC_FINA,   ");
            query.append(" p2.OID_PERI OID_PERI2, P2.MARC_OID_MARC MARC_OID_MARC2, P2.CANA_OID_CANA CANA_OID_CANA2, "); 
            query.append(" P2.PAIS_OID_PAIS PAIS_OID_PAIS2, P2.FEC_INIC FEC_INIC2, P2.FEC_FINA FEC_FINA2  ");
            query.append(" FROM INC_PEDID_GEREN_RECOM PDC,   ");
            query.append(" INC_CONCU_PARAM_GENER CPG,   ");
            query.append(" INC_CLIEN_GEREN CG, ");
            query.append(" CRA_PERIO P1, CRA_PERIO P2, INC_CLIEN_GEREN_RECOM cgr ");
            query.append(" WHERE P1.OID_PERI = " + oidPeriodo);
            query.append(" AND PDC.PERD_OID_PERI = P1.OID_PERI ");
            query.append(" AND PDC.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL   ");
            query.append(" AND CPG.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND CPG.IND_ACTI = 1   ");
            query.append(" AND CG.OID_CLIE_GERE = PDC.CLGE_OID_CLIE_GERE   ");
            query.append(" AND PDC.CLGR_OID_CLIE_GERE_RECO = CGR.OID_CLIE_GERE_RECO  ");
            query.append(" AND CGR.PERD_OID_PERI = P2.OID_PERI ");
            query.append(" ORDER BY PDC.CLGE_OID_CLIE_GERE   ");

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs.esVacio()) {
            UtilidadesLog.info("DAOGerentes.recuperarRecomendadosGerente2(LongoidPais, Long oidPeriodo):Salida VACIO");
            return gerentesRecomendantes;
        } else {
            //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5) Se agrega el Periodo
            Periodo periodo = new Periodo();
            Long oidPeri = new Long( rs.getValueAt(0, "OID_PERI").toString()); 
            periodo.setFechaDesde((Date) rs.getValueAt(0, "FEC_INIC"));
            periodo.setFechaHasta((Date) rs.getValueAt(0, "FEC_FINA"));
            periodo.setOidCanal(new Long( rs.getValueAt(0,"CANA_OID_CANA").toString()));
            periodo.setOidMarca(new Long( rs.getValueAt(0,"MARC_OID_MARC").toString()));
            periodo.setOidPais(new Long( rs.getValueAt(0,"PAIS_OID_PAIS").toString()));
            periodo.setOidPeriodo(oidPeri);                

            Periodo periodoInicioVinculo;
            
            for (int pos = 0; rs.existeFila(pos); pos++) {
                clienPremConcurso = new ClientePremiacionConcurso();
                pedidoRecomendacion = new PedidoRecomendacion();
                clienPremRecomendado = new ClientePremiacionRecomendado();
                gerente = new Gerente();

                concurso = new Long(((BigDecimal) rs.getValueAt(pos,
                            "COPA_OID_PARA_GRAL")).longValue());
                recomendado = new Long(((BigDecimal) rs.getValueAt(pos,
                            "CLGR_OID_CLIE_GERE_RECO")).longValue());
                oidGerente = new Long(((BigDecimal) rs.getValueAt(pos, 
                            "CLIE_OID_CLIE")).longValue());
                
                Concurso concursoObj = despacharPremiosHelper.obtenerConcurso(concurso);

                //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                //------------------------------------------------------
                periodoInicioVinculo = new Periodo();
                Long oidPeriIniVin = new Long(rs.getValueAt(pos, "OID_PERI2").toString()); 
                periodoInicioVinculo.setFechaDesde((Date) rs.getValueAt(pos, "FEC_INIC2"));
                periodoInicioVinculo.setFechaHasta((Date) rs.getValueAt(pos, "FEC_FINA2"));
                periodoInicioVinculo.setOidCanal(new Long( rs.getValueAt(pos,"CANA_OID_CANA2").toString()));
                periodoInicioVinculo.setOidMarca(new Long( rs.getValueAt(pos,"MARC_OID_MARC2").toString()));
                periodoInicioVinculo.setOidPais(new Long(rs.getValueAt(pos,"PAIS_OID_PAIS2").toString()));
                periodoInicioVinculo.setOidPeriodo(oidPeriIniVin);  
                clienPremRecomendado.setPeriodoInicioVinculo(periodoInicioVinculo);

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
                query2.append(" WHERE pent.oid_peri = ").append(oidPeriIniVin);
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

                int numePeriodEvalu = concursoObj.getNumeroPeriodosAEvaluar().intValue();
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

                    clienPremRecomendado.setPeriodoFinVinculo(periodoFinVinculo);
                } else {
                    UtilidadesLog.debug("no Existe fila periodoFinVinculo");
                    clienPremRecomendado.setPeriodoFinVinculo(null);
                }
                //------------------------------------------------------    

                //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                if ((concursoObj.getPeriodoInicialEvaluacion() == null) ||
                     ((!periodo.mayorQue(concursoObj.getPeriodoFinalEvaluacion())) &&
                         (!periodo.menorQue(concursoObj.getPeriodoInicialEvaluacion())))) {
    
                    UtilidadesLog.debug("SE PROCESA 1/2");
                    
                    //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                    if ((!periodo.mayorQue(clienPremRecomendado.getPeriodoFinVinculo())) &&
                             (!periodo.menorQue(clienPremRecomendado.getPeriodoInicioVinculo()))) {

                        UtilidadesLog.debug("SE PROCESA");                                    
    
                        if (rs.getValueAt(pos, "NUM_MONT_PEDI") != null) {
                            pedidoRecomendacion.setMontoPedido((BigDecimal) 
                                rs.getValueAt(pos, "NUM_MONT_PEDI"));
                        } else {
                            pedidoRecomendacion.setMontoPedido(new BigDecimal(0));
                        }
        
        
                        if (rs.getValueAt(pos, "NUM_UNID_PEDI") != null) {
                            pedidoRecomendacion.setUnidadesPedido(Long.valueOf(
                                    (((BigDecimal) rs.getValueAt(pos, "NUM_UNID_PEDI"))
                                        .toString())));
                        } else {
                            pedidoRecomendacion.setUnidadesPedido(new Long(0));
                        }
        
                        if (rs.getValueAt(pos, "IND_PEDI_VALI") != null) {
                            if (((BigDecimal) rs.getValueAt(pos, "IND_PEDI_VALI"))
                                .intValue() > 0) {
                                pedidoRecomendacion.setValido(true);
                            } else {
                                pedidoRecomendacion.setValido(false);
                            }
                        } else {
                             pedidoRecomendacion.setValido(true);
                        }
        
                        gerente.setOidCliente(oidGerente);
                        
                        ArrayList clientePremiacionConcusos = (ArrayList) gerentesRecomendantes.get(oidGerente);
                        
                        if (clientePremiacionConcusos == null) {
                            UtilidadesLog.info("OTRO GENRETE " + oidGerente);
                            clientePremiacionConcusos = new ArrayList();
                            clienPremConcurso = new ClientePremiacionConcurso();
                            clienPremConcurso.setOidConcurso(concurso);
                            clienPremConcurso.setGerente(gerente);
                            clientePremiacionConcusos.add(clienPremConcurso);
                            gerentesRecomendantes.put(oidGerente, clientePremiacionConcusos);
                        } else  {
                            UtilidadesLog.info("Gerente " + oidGerente);
                            Iterator clienteIt = clientePremiacionConcusos.iterator();
                            encontro = false;
                            while (clienteIt.hasNext() && !encontro) {
                                clienPremConcurso = (ClientePremiacionConcurso) clienteIt.next();
                                if (clienPremConcurso.getOidConcurso().equals(concurso) ) {
                                    UtilidadesLog.info("Encontre econcurso " + concurso);
                                    encontro = true;
                                }
                            }
                            if (!encontro) {
                                UtilidadesLog.info("No Encontre econcurso " + concurso);
                                clienPremConcurso = new ClientePremiacionConcurso();
                                clienPremConcurso.setOidConcurso(concurso);
                                clienPremConcurso.setGerente(gerente);
                                clientePremiacionConcusos.add(clienPremConcurso);
                            }
                        }
                        
                        Iterator recomendadosIt = clienPremConcurso.getRecomendados().iterator();
                        
                        encontro2 = false;
                        while (recomendadosIt.hasNext()) {
                            clienPremRecomendado = (ClientePremiacionRecomendado) recomendadosIt.next();
                            if (clienPremRecomendado.getOidClienteRecomendado().equals(recomendado)) {
                                UtilidadesLog.info("Encontre2" );
                                encontro2 = true;
                            }
                        }
                        
                        if (!encontro2) {
                            UtilidadesLog.info("NO Encontre2");
                            clienPremRecomendado = new ClientePremiacionRecomendado();
                            clienPremRecomendado.setOidClienteRecomendado(recomendado);
                            clienPremConcurso.getRecomendados().add(clienPremRecomendado);
                        }
                        clienPremRecomendado.getPedidosRecomendacion().add(pedidoRecomendacion);
                    }
                }
                    
            }

            UtilidadesLog.info("DAOGerentes.recuperarRecomendadosGerente(LongoidPais, Long oidPeriodo):Salida");
            return gerentesRecomendantes;
        }
    }

    private void asignarPedidoRecomendacion(ArrayList clientesRecomendantes,
        Long recomendado, PedidoRecomendacion pedidoRecomendacion) {
        UtilidadesLog.info( "DAOGerentes.asignarPedidoRecomendacion(ArrayList"
            +"clientesRecomendantes, Long recomendado, PedidoRecomendacion "
            +"pedidoRecomendacion):Entrada");

        Iterator clientesReteIt = clientesRecomendantes.iterator();
        Iterator clienPremConcuIt = null;
        Iterator clienPremRedoIt = null;
        ClientePremiacion clientePremiacion = null;
        ClientePremiacionConcurso clientePremiacionConcurso = null;
        ClientePremiacionRecomendado clientePremiacionRecomendado = null;

        while (clientesReteIt.hasNext()) {
            clientePremiacion = (ClientePremiacion) clientesReteIt.next();
            clienPremConcuIt = clientePremiacion
                .getClientesPremiacionConcurso().values().iterator();

            while (clienPremConcuIt.hasNext()) {
                clientePremiacionConcurso = (ClientePremiacionConcurso) 
                    clienPremConcuIt.next();

                clienPremRedoIt = clientePremiacionConcurso.getRecomendados()
                                                           .iterator();

                while (clienPremRedoIt.hasNext()) {
                    clientePremiacionRecomendado = 
                        (ClientePremiacionRecomendado) clienPremRedoIt.next();

                    if (clientePremiacionRecomendado.getOidClienteRecomendado()
                            .equals(recomendado)) {
                        clientePremiacionRecomendado.getPedidosRecomendacion()
                            .add(pedidoRecomendacion);
                    }
                }
            }
        }

        UtilidadesLog.info("DAOGerentes.asignarPedidoRecomendacion(ArrayList "
            +"clientesRecomendantes, Long recomendado, PedidoRecomendacion "
            +"pedidoRecomendacion):Salida");
    }

    /**
     * comentario: agrega a un recomendante un nuevo ClientePremiacionConcurso
     */
    private void asignarClientePremiacionConcurso(
        ArrayList clientesRecomendantes, Long recomendante,
        ClientePremiacionConcurso clienPremConcurso) {
        UtilidadesLog.info("DAOGerentes.asignarClientePremiacionConcurso("
            +"ArrayList clientesRecomendantes, Long recomendante, ClientePre"
            +"miacionConcurso clienPremConcurso):Entrada");

        Iterator clientesReteIt = clientesRecomendantes.iterator();
        ClientePremiacion clientePremiacion = new ClientePremiacion();
        HashMap clientesPremiacionConcurso = new HashMap();

        while (clientesReteIt.hasNext()) {
            clientePremiacion = (ClientePremiacion) clientesReteIt.next();

            if (clientePremiacion.getOidCliente().equals(recomendante)) {
                clientesPremiacionConcurso = clientePremiacion
                    .getClientesPremiacionConcurso();
                clientesPremiacionConcurso.put(clienPremConcurso
                    .getOidConcurso(),clienPremConcurso);
            }
        }

        UtilidadesLog.debug("Salio DAOGerentes.asignarClientePremiacionConcur"
            +"so****");
    }

    private boolean poseeRecomendante(ArrayList clientesRecomendantes,
        Long oidRecomendante) {
        UtilidadesLog.info("DAOGerentes.poseeRecomendante(ArrayList clientesRe"
            +"comendantes, Long oidRecomendante):Entrada");

        Iterator clientesReteIt = clientesRecomendantes.iterator();
        ClientePremiacion clientePremiacion = new ClientePremiacion();

        if (!clientesRecomendantes.isEmpty()) {
            while (clientesReteIt.hasNext()) {
                clientePremiacion = (ClientePremiacion) clientesReteIt.next();

                if (clientePremiacion.getOidCliente().equals(oidRecomendante)) {
                    UtilidadesLog.info("DAOGerentes.poseeRecomendante(Array"
                        +"List clientesRecomendantes, Long oidRecomendante):"
                        +"Salida TRUE");
                    return true;
                }
            }
        }

        UtilidadesLog.info("DAOGerentes.poseeRecomendante(ArrayList "
            +"clientesRecomendantes, Long oidRecomendante):Salida FALSE");

        return false;
    }

    private boolean poseeConcurso(ArrayList clientesRecomendantes,
        Long oidConcurso) {
        UtilidadesLog.info("DAOGerentes.poseeConcurso(ArrayList clientesRecome"
            +"ndantes, Long oidConcurso):Entrada");

        Iterator clientesReteIt = clientesRecomendantes.iterator();
        ClientePremiacion clientePremiacion = new ClientePremiacion();

        while (clientesReteIt.hasNext()) {
            clientePremiacion = (ClientePremiacion) clientesReteIt.next();

            if (clientePremiacion.getClientesPremiacionConcurso().containsKey(
                oidConcurso)) {
                UtilidadesLog.info("DAOGerentes.poseeConcurso(ArrayList clien"
                    +"tesRecomendantes, Long oidConcurso):Salida FALSE");

                return true;
            }
        }

        UtilidadesLog.info("DAOGerentes.poseeConcurso(ArrayList clientesReco"
            +"mendantes, Long oidConcurso):Salida TRUE");

        return false;
    }

    /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario: Este metodo obtiene los gerentes a ser premiados.
    */
    public DTOOIDs obtenerGerentesPremiacion(DTOFACProcesoCierre dtoe)
        throws MareException {
        UtilidadesLog.info(
            "DAOGerentes.obtenerGerentesPremiacion(DTOFACProcesoCierre dtoe):"
                +"Entrada");

        StringBuffer query = new StringBuffer();
        StringBuffer query2 = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;
        DTOOIDs dtoOIDs = new DTOOIDs();

        query.append(" SELECT FEC_INIC FechaDesde, FEC_FINA FechaHasta");
        query.append(" FROM CRA_PERIO");
        query.append(" WHERE OID_PERI = " + dtoe.getPeriodo());
        query.append(" AND CANA_OID_CANA = " + dtoe.getCanal());
        query.append(" AND MARC_OID_MARC = " + dtoe.getMarca());
        query.append(" AND PAIS_OID_PAIS = " + dtoe.getOidPais());

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (!rs.esVacio()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date dia = (java.sql.Date) rs.getValueAt(0, "FECHADESDE");
            String fechaDesde = sdf.format(dia);
            UtilidadesLog.debug("fecha  Desde : " + fechaDesde);
            query2.append(" SELECT CG.CLIE_OID_CLIE");
            query2.append(" FROM INC_CANDI_GANAD CG,  ");
            query2.append(" INC_CONCU_PARAM_GENER CPG, CRA_PERIO PERIO");
            query2.append(" WHERE CG.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL");
            query2.append(" AND CPG.MARC_OID_MARC = " + dtoe.getMarca());
            query2.append(" AND CPG.CANA_OID_CANA = " + dtoe.getCanal());
            query2.append(" AND CG.BINC_OID_BASE_INCU IS NULL");
            query2.append(" AND CG.VAL_REQU_PREM_SUPE = 0 ");
            query2.append(" AND CPG.PAIS_OID_PAIS = " + dtoe.getOidPais());
            //jrivas inc 20450            
            //query2.append(" AND CG.PERD_OID_PERI = " + dtoe.getPeriodo());
            query2.append(" AND CPG.DIRI_OID_DIRI = " +
                ConstantesINC.TIPO_GERENTE);
            query2.append(" AND CG.PERD_OID_PERI_EVAL = PERIO.OID_PERI(+) ");
            query2.append(" AND PERIO.FEC_INIC(+) <= TO_DATE('" + fechaDesde +
                "', 'yyyy-MM-dd')");
            query2.append(" AND CPG.IND_ACTI = 1 ");    
            query2.append(" GROUP BY CG.CLIE_OID_CLIE ");               
                

            try {
                rs = (RecordSet) belcorpService.getInstance().dbService
                    .executeStaticQuery(query2.toString());
                UtilidadesLog.debug("RS*** : " + rs);                    
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(codigoError));
            }

            Long[] oidsCliente = new Long[rs.getRowCount()];

            for (int pos = 0; rs.getRowCount() > pos; pos++) {
                oidsCliente[pos] = Long.valueOf(((BigDecimal) rs.getValueAt(
                            pos, "CLIE_OID_CLIE")).toString());
            }

            dtoOIDs.setOids(oidsCliente);
        }

        UtilidadesLog.info("DAOGerentes.obtenerGerentesPremiacion(DTOFACProce"
            +"soCierre dtoe):Salida");

        return dtoOIDs;
    }

    /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario: Este método obtiene la lista de concursos a evaluar en la 
    * premiacion de gerentes.
    * Modificado: Carlos Leal 8/7/2005
    */
    public DTOOIDs obtenerConcursosPremiacion(DTOFACProcesoCierre dtoe, Long oidCliente)
        throws MareException {
        UtilidadesLog.info("DAOGerentes.obtenerConcursosPremiacion(DTOFACProce"
            +"soCierre dtoe):Entrada");

        StringBuffer query = new StringBuffer();
        StringBuffer query2 = null;
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;
        DTOOIDs dtoOIDs = null;

        query.append(" SELECT FEC_INIC FechaDesde, FEC_FINA FechaHasta ");
        query.append(" FROM CRA_PERIO ");
        query.append(" WHERE OID_PERI = " + dtoe.getPeriodo());
        query.append(" AND CANA_OID_CANA = " + dtoe.getCanal());
        query.append(" AND MARC_OID_MARC = " + dtoe.getMarca());
        query.append(" AND PAIS_OID_PAIS = " + dtoe.getOidPais());

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (!rs.esVacio()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date dia = (java.sql.Date) rs.getValueAt(0, "FECHADESDE");
            String fechaDesde = sdf.format(dia);
            UtilidadesLog.debug("fechaDesde: " + fechaDesde);
            query2 = new StringBuffer(); //Cleal 8/7/2005
            dtoOIDs = new DTOOIDs(); //Cleal 28/7/2005

            query2.append(" SELECT CG.COPA_OID_PARA_GRAL");
            query2.append(" FROM INC_CANDI_GANAD CG, ");
            query2.append(" INC_CONCU_PARAM_GENER CPG, CRA_PERIO PERIO");
            query2.append(" WHERE CG.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL");
            query2.append(" AND CPG.MARC_OID_MARC = " + dtoe.getMarca());
            query2.append(" AND CPG.CANA_OID_CANA = " + dtoe.getCanal());
            query2.append(" AND CG.BINC_OID_BASE_INCU IS NULL");
            query2.append(" AND CG.VAL_REQU_PREM_SUPE = 0 ");
            query2.append(" AND CPG.PAIS_OID_PAIS = " + dtoe.getOidPais());
            //jrivas inc 20450
            //query2.append(" AND CG.PERD_OID_PERI = " + dtoe.getPeriodo());
            query2.append(" AND CPG.DIRI_OID_DIRI = " +
                ConstantesINC.TIPO_GERENTE);
            query2.append(" AND CG.PERD_OID_PERI_EVAL = PERIO.OID_PERI(+) ");
            query2.append(" AND PERIO.FEC_INIC(+) <= TO_DATE('" + fechaDesde +
                "', 'yyyy-MM-dd')");
                
            //jrivas 18/1/2006
            //INC-44
            query2.append(" AND CG.CLIE_OID_CLIE = " + oidCliente);   
            query2.append(" AND CPG.IND_ACTI = 1 ");
            query2.append(" GROUP BY CG.COPA_OID_PARA_GRAL ");

            try {
                rs = (RecordSet) belcorpService.getInstance().dbService
                    .executeStaticQuery(query2.toString());
                UtilidadesLog.debug("rs---- : " + rs);                    
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(codigoError));
            }

            Long[] oidsConcurso = new Long[rs.getRowCount()];

            for (int pos = 0; rs.getRowCount() > pos; pos++) {
                oidsConcurso[pos] = Long.valueOf(((BigDecimal) rs.getValueAt(
                            pos, "COPA_OID_PARA_GRAL")).toString());
            }

            dtoOIDs.setOids(oidsConcurso);
        }

        UtilidadesLog.info("DAOGerentes.obtenerConcursosPremiacion(DTOFACProce"
            +"soCierre dtoe):Salida");

        return dtoOIDs;
    }

    /**
    * Fecha de Creacion: 02/06/2005
    * Autor: Damasia Maneiro
    * Comentario: Este método completa los datos de un gerente para su 
    * premiacion.
    * 
    */
    public void rellenarClientePremiacionGerentes(
        ClientePremiacion clientePremiacion) throws MareException {
        UtilidadesLog.info("DAOGerentes.rellenarClientePremiacionGerentes("
            +"ClientePremiacion clientePremiacion):Entrada");

        BelcorpService bs;
        RecordSet rs;
        RecordSet rs1;
        String codigoError;
        StringBuffer query = new StringBuffer();
        StringBuffer query1 = new StringBuffer();
        DAOClientePremiacion daoClientePremiacion = new DAOClientePremiacion();
        DTOETramitarCierre dtoETramitarCierre = new DTOETramitarCierre();

        dtoETramitarCierre.setOidPais(clientePremiacion.getOidPais());
        dtoETramitarCierre.setOidMarca(clientePremiacion.getOidMarca());
        dtoETramitarCierre.setOidCanal(clientePremiacion.getOidCanal());
        dtoETramitarCierre.setOidPeriodo(clientePremiacion.getPeriodo()
                                                          .getOidPeriodo());

        clientePremiacion.setPeriodo(daoClientePremiacion.obtenerPeriodo(
                dtoETramitarCierre));

        UnidadesAdministrativasGerenciadas unidadesAdministrativasGerenciadas = 
            obtenerUnidadesAdministrativasGerente(dtoETramitarCierre
                .getOidPais(),dtoETramitarCierre.getOidMarca(),
                dtoETramitarCierre.getOidCanal(),
                clientePremiacion.getOidCliente());
        clientePremiacion.setUnidadesAdministrativasGerenciadas(
            unidadesAdministrativasGerenciadas);

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT PERD_OID_PERI PeriodoPrimerContacto");
            query.append(" FROM MAE_CLIEN_PRIME_CONTA CPC ");
            query.append(" WHERE CPC.CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs.esVacio()) {
            clientePremiacion.setPeriodoPrimerContacto(null);
        } else {
            Periodo periodo = new Periodo();

            //instancio e inicializo un periodo
            periodo.setOidPeriodo(Long.valueOf(((BigDecimal) 
                rs.getValueAt(0, "PeriodoPrimerContacto")).toString()));
            periodo.setOidMarca(clientePremiacion.getOidMarca());
            periodo.setOidCanal(clientePremiacion.getOidCanal());
            periodo.setOidPais(clientePremiacion.getOidPais());

            clientePremiacion.setPeriodoPrimerContacto(periodo);
        }
        
        // vbongiov -- 21/06/06 -- DBLG500000775 
        try {
            query1.append(" SELECT COD_EMPL ");
            query1.append(" FROM MAE_CLIEN_DATOS_ADICI ");
            query1.append(" WHERE CLIE_OID_CLIE = " +
                clientePremiacion.getOidCliente());

            rs1 = bs.dbService.executeStaticQuery(query1.toString());
            UtilidadesLog.debug("rs1: " + rs1);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
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
            query2.append(" SELECT ZON.COD_ZONA, TERR.COD_TERR ");
            query2.append(" FROM MAE_CLIEN_UNIDA_ADMIN UNA,  ZON_TERRI_ADMIN TERRA,  ZON_SECCI SEC, ");
            query2.append(" ZON_ZONA ZON, ZON_TERRI TERR ");
            query2.append(" WHERE UNA.ZTAD_OID_TERR_ADMI = TERRA.OID_TERR_ADMI ");
            query2.append(" AND TERRA.TERR_OID_TERR = TERR.OID_TERR ");
            query2.append(" AND TERRA.ZSCC_OID_SECC = SEC.OID_SECC ");
            query2.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA ");
            query2.append(" AND UNA.IND_ACTI = 1 ");
            query2.append(" AND UNA.CLIE_OID_CLIE = " + clientePremiacion.getOidCliente());

            rs2 = bs.dbService.executeStaticQuery(query2.toString());
            UtilidadesLog.debug("rs2: " + rs2);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (!rs2.esVacio()) {
            clientePremiacion.getDatosPersonales().setCodZona((String)rs2.getValueAt(0, "COD_ZONA"));
            clientePremiacion.getDatosPersonales().setCodTerritorio(((BigDecimal)rs2.getValueAt(0, "COD_TERR")).toString());
        }
        
        // jrivas BLO-01 INICIO
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

            rs3 = bs.dbService.executeStaticQuery(query3.toString());
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
        // jrivas BLO-01  FIN
         

        clientePremiacion.setGerente(true);
        UtilidadesLog.info("DAOGerentes.rellenarClientePremiacionGerentes("
            +"ClientePremiacion clientePremiacion):Salida");
    }

    /**
    * Fecha de Creacion: 08/06/2005
    * Autor: Damasia Maneiro
    * Comentario: este método recupera todas las unidades administrativas
    * manejadas por el gerente recibido por parametro.
    * Un gerente puede manejar mas de una unidad administrativa de la misma 
    * jerarquia, por ejemplo mas de una region o mas de una zona, etc.
    *  
    */
    public UnidadesAdministrativasGerenciadas 
        obtenerUnidadesAdministrativasGerente(Long oidPais, Long oidMarca, 
        Long oidCanal, Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOGerentes.obtenerUnidadesAdministrativasGerente("
            +"Long oidPais, Long oidMarca, Long oidCanal, Long oidCliente):"
            +"Salida");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;
        UnidadesAdministrativasGerenciadas unidAdminGerenciadas = 
            new UnidadesAdministrativasGerenciadas();
        ArrayList oids = new ArrayList();

        //1.- Recuperar unidades Secciones inc.18999
        query.append(" SELECT OID_SECC");
        query.append(" FROM zon_secci secc, zon_zona zon ");
        query.append(" WHERE ZZON_OID_ZONA = OID_ZONA");
        query.append(" AND secc.CLIE_OID_CLIE = " + oidCliente);
        query.append(" AND PAIS_OID_PAIS = " + oidPais);
        query.append(" AND MARC_OID_MARC = " + oidMarca);
        query.append(" AND CANA_OID_CANA = " + oidCanal);

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(
                query.toString());
            UtilidadesLog.debug("rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        if (!rs.esVacio()) {
            //recupero los oids de los registros de zona           
            for (int pos = 0; rs.getRowCount() > pos; pos++) {
                oids.add(Long.valueOf(
                        ((BigDecimal) rs.getValueAt(pos, "OID_SECC"))
                            .toString()));
            }

            unidAdminGerenciadas.setSecciones(oids);
        } else {
            //2.- Recuperar unidades de Gerente Zona 
            query = new StringBuffer();
            query.append(" SELECT OID_ZONA");
            query.append(" FROM ZON_ZONA");
            query.append(" WHERE CLIE_OID_CLIE = " + oidCliente);
            query.append(" AND PAIS_OID_PAIS = " + oidPais);
            query.append(" AND MARC_OID_MARC = " + oidMarca);
            query.append(" AND CANA_OID_CANA = " + oidCanal);

            try {
                rs = (RecordSet) belcorpService.getInstance().dbService
                    .executeStaticQuery(query.toString());
                UtilidadesLog.debug("rs: " + rs);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(codigoError));
            }

            if (!rs.esVacio()) {
                //recupero los oids de los registros de zona           
                for (int pos = 0; rs.getRowCount() > pos; pos++) {
                    oids.add(Long.valueOf(
                            ((BigDecimal) rs.getValueAt(pos, "OID_ZONA"))
                                .toString()));
                }

                unidAdminGerenciadas.setZonas(oids);
            } else {
                //3.- Recuperar unidades de Gerente Region  
                query = new StringBuffer();
                query.append(" SELECT OID_REGI");
                query.append(" FROM ZON_REGIO");
                query.append(" WHERE CLIE_OID_CLIE = " + oidCliente);
                query.append(" AND PAIS_OID_PAIS = " + oidPais);
                query.append(" AND MARC_OID_MARC = " + oidMarca);
                query.append(" AND CANA_OID_CANA = " + oidCanal);

                try {
                    rs = (RecordSet) belcorpService.getInstance().dbService
                        .executeStaticQuery(query.toString());
                    UtilidadesLog.debug("rs: " + rs);
                } catch (Exception e) {
                    UtilidadesLog.error("ERROR ", e);
                    codigoError = CodigosError
                        .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(codigoError));
                }

                if (!rs.esVacio()) {
                    //recupero los oids de los registros de region           
                    for (int pos = 0; rs.getRowCount() > pos; pos++) {
                        oids.add(Long.valueOf(
                                ((BigDecimal) rs.getValueAt(pos, "OID_REGI"))
                                    .toString()));
                    }

                    unidAdminGerenciadas.setRegiones(oids);
                } else {
                    //4.- Recuperar unidades de Subgerente  
                    query = new StringBuffer();
                    query.append(" SELECT OID_SUBG_VENT");
                    query.append(" FROM ZON_SUB_GEREN_VENTA");
                    query.append(" WHERE CLIE_OID_CLIE = " + oidCliente);
                    query.append(" AND PAIS_OID_PAIS = " + oidPais);
                    query.append(" AND MARC_OID_MARC = " + oidMarca);
                    query.append(" AND CANA_OID_CANA = " + oidCanal);

                    try {
                        rs = (RecordSet) belcorpService.getInstance().dbService
                            .executeStaticQuery(query.toString());
                        UtilidadesLog.debug("****rs: " + rs);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        codigoError = CodigosError
                            .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(codigoError));
                    }

                    if (!rs.esVacio()) {
                        //recupero los oids de los registros de Subgerente           
                        for (int pos = 0; rs.getRowCount() > pos; pos++) {
                            oids.add(Long.valueOf(
                                    ((BigDecimal) rs.getValueAt(pos,
                                        "OID_SUBG_VENT")).toString()));
                        }

                        unidAdminGerenciadas.setSubGerencias(oids);
                    }
                }
            }
        }

        UtilidadesLog.info("DAOGerentes.obtenerUnidadesAdministrativasGerente("
            +"Long oidPais, Long oidMarca, Long oidCanal, Long oidCliente):"
            +"Salida");

        return unidAdminGerenciadas;
    }

}
