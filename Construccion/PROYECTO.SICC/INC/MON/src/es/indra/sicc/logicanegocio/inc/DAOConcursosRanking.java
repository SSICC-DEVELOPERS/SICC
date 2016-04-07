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
 * 
 * @author: Marcelo Maidana
 *  
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;
import java.util.HashMap;


public class DAOConcursosRanking {
    private Long oidConcurso;

    public DAOConcursosRanking() {
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    /**
     * Este metodo retorna los datos del concurso pasado por parametro
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public Concurso obtenerConcurso(Long oidConcurso) throws MareException {
        UtilidadesLog.info("DAOConcursosRanking.obtenerConcurso(Long oidConcu"
            +"rso):Entrada");

        FactoriaConcurso factoria = FactoriaConcurso.getFactoriaConcurso();
        Long[] oids = { oidConcurso };
        DTOOIDs dtoOids = new DTOOIDs();
        dtoOids.setOids(oids);

        ArrayList concursos = factoria.getConcursosPorOID(dtoOids);
        Concurso concurso = (Concurso) concursos.get(0);
        UtilidadesLog.info("DAOConcursosRanking.obtenerConcurso(Long oidCon"
            +"curso):Salida");

        return concurso;
    }

    /**
     * Este metodo retorna la subgerencia y la region correspondiente a la zona
     * pasada por parametro (oidZona)
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public RecordSet completarAmbitoPorZona(Long oidZona)
        throws MareException {
        UtilidadesLog.info("DAOConcursosRanking.completarAmbitoPorZona(Long "
            +"oidZona):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        query.append(" SELECT ");
        query.append("     agz.ZORG_OID_REGI, ");
        query.append("     agr.ZSGV_OID_SUBG_VENT ");
        query.append(" FROM ");
        query.append("     ZON_ZONA agz, ");
        query.append("     ZON_REGIO agr ");
        query.append(" WHERE ");
        query.append("    agz.OID_ZONA = " + oidZona);
        query.append("    AND agr.OID_REGI = agz.ZORG_OID_REGI ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOConcursosRanking.completarAmbitoPorZona(Long "
            +"oidZona):Salida");

        return rs;
    }

    /**
     * Este metodo retorna la subgerencia correspondiente a la region pasada
     * por parametro (oidRegion)
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public RecordSet completarAmbitoPorRegion(Long oidRegion)
        throws MareException {
        UtilidadesLog.info("DAOConcursosRanking.completarAmbitoPorRegion(Long "
            +"oidRegion):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        query.append(" SELECT ");
        query.append("     agr.ZSGV_OID_SUBG_VENT  ");
        query.append(" FROM ");
        query.append("     ZON_REGIO agr ");
        query.append(" WHERE ");
        query.append("    agr.OID_REGI =  " + oidRegion);

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOConcursosRanking.completarAmbitoPorRegion(Long"
            +" oidRegion):Salida");

        return rs;
    }

    /**
     * Descripcion: obtiene los Periodos para los cuales el cliente pasó al 
     * menos un pedido
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Sergio C. Saavedra -- 07/07/2005
     */
    public HashMap obtenerPeriodosConPedidosCliente(Long oidCliente)
        throws MareException {
        UtilidadesLog.info("DAOConcursosRanking.obtenerPeriodosConPedidosCli"
            +"ente(Long oidCliente):Entrada");

        RecordSet r = null;
        StringBuffer sqlQuery = new StringBuffer();
        DTOParametrosGeneralesPremiacion resu = 
            new DTOParametrosGeneralesPremiacion();

        HashMap lista = new HashMap();

        //Cleal 10/8/2005
        /*Date minPerDDe = FactoriaConcurso.getFactoriaConcurso()
                                         .getMinPeriodoDesde().getFechaDesde();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strminPerDDe = sdf.format(minPerDDe);*/
        Long oidPeriodo = FactoriaConcurso.getFactoriaConcurso().getMinPeriodoDesde().getOidPeriodo();

        
        //jrivas 20/9/2006 Uso de acumulador
        sqlQuery.append(" SELECT DISTINCT A.PERD_OID_PERI, COD_PERI, B.FEC_INIC, B.FEC_FINA, ");
        sqlQuery.append(" B.CANA_OID_CANA, B.MARC_OID_MARC, B.PAIS_OID_PAIS ");
        sqlQuery.append(" FROM PED_SOLIC_CABEC_ACUM2 A, ");
        sqlQuery.append(" CRA_PERIO B, ");
        sqlQuery.append(" SEG_PERIO_CORPO C, ");
        sqlQuery.append(" CRA_PERIO D ");
        sqlQuery.append(" WHERE A.PERD_OID_PERI = B.OID_PERI ");
        sqlQuery.append(" AND B.PERI_OID_PERI = C.OID_PERI ");
        sqlQuery.append(" AND D.OID_PERI = " + oidPeriodo);
        sqlQuery.append(" AND A.CLIE_OID_CLIE = " + oidCliente);
        sqlQuery.append(" AND B.FEC_INIC >= D.FEC_INIC ");
        sqlQuery.append(" AND D.PAIS_OID_PAIS = B.PAIS_OID_PAIS ");
        sqlQuery.append(" AND D.MARC_OID_MARC = B.MARC_OID_MARC ");
        sqlQuery.append(" AND D.CANA_OID_CANA = B.CANA_OID_CANA ");
        sqlQuery.append(" AND a.val_cant_pedi > 0 ");                           // JVM, sicc 20070376
        
        /*sqlQuery.append(" Select DISTINCT psc.PERD_OID_PERI oidPeri,  ");
        sqlQuery.append(" crap.FEC_INIC, crap.FEC_FINA, crap.PAIS_OID_PAIS, ");
        sqlQuery.append(
            " crap.MARC_OID_MARC, crap.CANA_OID_CANA , spc.COD_PERI ");
        sqlQuery.append(
            " FROM PED_SOLIC_CABEC psc, CRA_PERIO crap, SEG_PERIO_CORPO spc, ");
        // vbongiov -- 30/08/2006 -- Inc DBLG500001181
        sqlQuery.append(" PED_TIPO_SOLIC_PAIS PTSP, ");
        sqlQuery.append(" PED_TIPO_SOLIC PTS, PED_SOLIC_CABEC CONSO  ");    
        sqlQuery.append(" WHERE ");
        sqlQuery.append(" crap.fec_inic BETWEEN TO_DATE('" + minPerDDe +
            "', 'yyyy-MM-dd') AND TRUNC(SYSDATE) ");
        sqlQuery.append(" AND psc.CLIE_OID_CLIE = " + oidCliente.longValue());
        sqlQuery.append(" AND psc.PERD_OID_PERI = crap.OID_PERI ");
        sqlQuery.append(" AND crap.PERI_OID_PERI = spc.oid_peri ");
        // vbongiov -- 30/08/2006 -- Inc DBLG500001181
        sqlQuery.append(" AND psc.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS ");
        sqlQuery.append(" AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
        sqlQuery.append(" AND PTS.IND_ANUL <> 1 ");
        sqlQuery.append(" AND PTS.IND_DEVO <> 1 ");
        sqlQuery.append(" AND psc.IND_OC = 1 ");
        sqlQuery.append(" AND psc.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE(+) ");
        sqlQuery.append(" AND NVL(CONSO.ESSO_OID_ESTA_SOLI, 1) <> " + ConstantesPED.ESTADO_SOLICITUD_ANULADO); */

        try {
            BelcorpService bs = BelcorpService.getInstance();
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("resultado query: " + r);

            if ((r != null) && (r.getRowCount() > 0)) {
                Object o = null;
                Periodo registro = null;

                for (int i = 0; i < r.getRowCount(); i++) {
                    registro = new Periodo();

                    Date fechaInicio = (Date) r.getValueAt(i, "FEC_INIC");
                    Date fechaFin = (Date) r.getValueAt(i, "FEC_FINA");

                    registro.setCodperiodo((String) 
                        r.getValueAt(i, "COD_PERI"));
                    registro.setFechaDesde(fechaInicio);
                    registro.setFechaHasta(fechaFin);
                    registro.setOidCanal(((o = 
                        r.getValueAt(i, "CANA_OID_CANA")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    registro.setOidMarca(((o = 
                        r.getValueAt(i, "MARC_OID_MARC")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    registro.setOidPais(((o = 
                        r.getValueAt(i, "PAIS_OID_PAIS")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    registro.setOidPeriodo(((o = 
                        r.getValueAt(i, "PERD_OID_PERI")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);

                    lista.put(registro.getOidPeriodo(), registro);
                }
            }
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOConcursosRanking.obtenerPeriodosConPedidosClien"
            +"te(Long oidCliente):Salida");

        return lista;
    }

    /**
      * Descripcion: este metodo retorna un objeto Periodo con los datos del 
      * primer contacto del oidCliente
      * recibido por parametro
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 07/07/2005
      */
    public Periodo obtenerPrimerContactoCliente(Long oidCliente)
        throws MareException {
        UtilidadesLog.info("DAOConcursosRanking.obtenerPrimerContactoCliente("
            +"Long oidCliente):Entrada");

        RecordSet r = null;
        StringBuffer sqlQuery = new StringBuffer();

        Periodo resu = null;

        sqlQuery.append(" Select mcpc.PERD_OID_PERI oidPeri, crap.FEC_INIC, ");
        sqlQuery.append(" crap.FEC_FINA, crap.PAIS_OID_PAIS, ");
        sqlQuery.append(" crap.MARC_OID_MARC, crap.CANA_OID_CANA,  ");
        sqlQuery.append(" spc.COD_PERI ");
        sqlQuery.append(" FROM MAE_CLIEN_PRIME_CONTA mcpc, CRA_PERIO crap, ");
        sqlQuery.append(" SEG_PERIO_CORPO spc ");
        sqlQuery.append(" WHERE ");
        sqlQuery.append(" mcpc.CLIE_OID_CLIE = " + oidCliente.longValue());
        sqlQuery.append(" AND mcpc.PERD_OID_PERI = crap.OID_PERI ");
        sqlQuery.append(" AND mcpc.PERD_OID_PERI = spc.OID_PERI");

        try {
            BelcorpService bs = BelcorpService.getInstance();
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("resultado query: " + r);

            if ((r != null) && (r.getRowCount() > 0) && 
                (r.getRowCount() == 1)) {
                
                resu = new Periodo();

                Object o = null;
                Date fechaInicio = (Date) r.getValueAt(0, "FEC_INIC");
                Date fechaFin = (Date) r.getValueAt(0, "FEC_FINA");

                resu.setCodperiodo(((o = r.getValueAt(0, "COD_PERI")) != null)
                    ? (String) o : null);
                resu.setFechaDesde(fechaInicio);
                resu.setFechaHasta(fechaFin);
                resu.setOidCanal(((o = r.getValueAt(0, "CANA_OID_CANA")) 
                    != null) ? new Long(((BigDecimal) o).toString()) : null);
                resu.setOidMarca(((o = r.getValueAt(0, "MARC_OID_MARC")) 
                    != null) ? new Long(((BigDecimal) o).toString()) : null);
                resu.setOidPais(((o = r.getValueAt(0, "PAIS_OID_PAIS")) 
                    != null) ? new Long(((BigDecimal) o).toString()) : null);
                resu.setOidPeriodo(((o = r.getValueAt(0, "PERD_OID_PERI")) 
                    != null) ? new Long(((BigDecimal) o).toString()) : null);
            }
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOConcursosRanking.obtenerPrimerContactoCliente("
            +"Long oidCliente):Salida");

        return resu;
    }
}
