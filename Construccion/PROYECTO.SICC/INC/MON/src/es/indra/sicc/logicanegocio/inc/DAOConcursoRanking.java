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
*  @author: Marecelo Maidana
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

import es.indra.sicc.dtos.inc.DTOBuscarConcursos;
import es.indra.sicc.dtos.inc.DTODatosGeneralesConcursoRanking;
import es.indra.sicc.dtos.inc.DTOListaVariablesVentaRanking;
import es.indra.sicc.dtos.inc.DTOParametrosConsultorasRanking;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.dtos.inc.DTOTipoProducto;
import es.indra.sicc.dtos.inc.DTOVariablesVentaRankingConcurso;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.util.ArrayList;


public class DAOConcursoRanking {
    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 17/06/2005
     */
    public RecordSet obtenerNivelAgrupamiento(DTOBelcorp DTOE)
        throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.obtenerNivelAgrupamiento(DTOBe"
            +"lcorp DTOE): Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        Periodo retVal = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT A.OID_AGRU_RANK, VAL_I18N  ");
            buf.append("FROM INC_AGRUP_RANKI A, V_GEN_I18N_SICC I ");
            buf.append("WHERE I.ATTR_ENTI LIKE 'INC_AGRUP_RANKI' ");
            buf.append("AND A.OID_AGRU_RANK = I.VAL_OID ");
            buf.append("AND I.ATTR_NUM_ATRI =1 ");

            if ((DTOE != null) && (DTOE.getOidIdioma() != null)) {
                buf.append(" AND I.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            }

            buf.append(" ORDER BY A.OID_AGRU_RANK");

            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOConcursoRanking.obtenerNivelAgrupamiento(DTOBel"
            +"corp DTOE):Salida");

        return rs;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 17/06/2005
     */
    public RecordSet obtenerTipoRanking(DTOBelcorp DTOE)
        throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.obtenerTipoRanking(DTOBelcorp "
            +"DTOE): Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        Periodo retVal = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT OID_TIPO_RANK, VAL_I18N ");
            buf.append("FROM INC_TIPO_RANKI A, V_GEN_I18N_SICC I ");
            buf.append("WHERE I.ATTR_ENTI LIKE 'INC_TIPO_RANKI' ");
            buf.append("AND A.OID_TIPO_RANK = I.VAL_OID ");
            buf.append("AND I.ATTR_NUM_ATRI =1 ");

            if ((DTOE != null) && (DTOE.getOidIdioma() != null)) {
                buf.append(" AND I.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            }

            buf.append(" ORDER BY VAL_I18N");

            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOConcursoRanking.obtenerTipoRanking(DTOBelcorp"
            +"DTOE): Salida");

        return rs;
    }

    public RecordSet obtenerTiposProductoRanking(DTOTipoProducto DTOE)
        throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.obtenerTiposProductoRanking("
            +"DTOTipoProducto DTOE): Entrada");

        RecordSet r = null;
        StringBuffer sqlQuery = new StringBuffer("");

        sqlQuery.append(
            " SELECT inc_tipo_produ.oid_tipo_prod, v_gen_i18n_sicc.val_i18n ");
        sqlQuery.append(" FROM inc_tipo_produ, v_gen_i18n_sicc ");
        sqlQuery.append(" WHERE inc_tipo_produ.ind_prod = " +
            DTOE.getIndGrupoProducto());
        sqlQuery.append(" AND inc_tipo_produ.oid_tipo_prod IN (");
        sqlQuery.append(ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS + ", ");
        sqlQuery.append(ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS + ") ");
        sqlQuery.append(
            " AND inc_tipo_produ.oid_tipo_prod = v_gen_i18n_sicc.val_oid ");
        sqlQuery.append(" AND v_gen_i18n_sicc.attr_enti = 'INC_TIPO_PRODU' ");
        sqlQuery.append(" AND v_gen_i18n_sicc.idio_oid_idio = " +
            DTOE.getOidIdioma());
        sqlQuery.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
        sqlQuery.append(" ORDER BY VAL_I18N");

        try {
            BelcorpService bs = BelcorpService.getInstance();
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("r: " + r);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOConcursoRanking.obtenerTiposProductoRanking(DTO"
            +"TipoProducto DTOE): Salida");

        return r;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Sergio C. Saavedra -- 21/06/2005
     */
    public DTOSalida buscarConcursosRanking(DTOBuscarConcursos DTOE)
        throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.buscarConcursosRanking(DTOBusc"
            +"arConcursos DTOE): Entrada");

        //Tendremos un registro por cada concurso/acceso, como un concurso 
        //puede tener varios accesos, se repetirá el concurso tantas veces 
        //como accesos distintos tenga 
        DTOSalida resu = new DTOSalida();
        UtilidadesLog.debug(" DTOBuscarConcursos: " + DTOE);

        RecordSet r = null;
        StringBuffer sqlQuery = new StringBuffer();

        sqlQuery.append("SELECT A.OID_PARA_GRAL oid, ");
        sqlQuery.append("A.NUM_CONC numeroConcurso, ");
        sqlQuery.append("A.NUM_VERS version, ");
        sqlQuery.append("A.VAL_NOMB nombreConcurso, ");
        sqlQuery.append("D.DES_MARC marca, ");
        sqlQuery.append("idio.VAL_I18N as desc_canal ");
        sqlQuery.append("FROM INC_CONCU_PARAM_GENER A, ");
        sqlQuery.append("SEG_MARCA D, ");
        sqlQuery.append("v_gen_i18n_sicc idio ");
        sqlQuery.append("WHERE A.PAIS_OID_PAIS = " + DTOE.getOidPais());

        if (!DTOE.getIndActivo().booleanValue()) {
            sqlQuery.append(" AND A.IND_ACTI = 0");
        }

        if (DTOE.getNroConcurso() != null) {
            sqlQuery.append(" AND A.NUM_CONC = '" + DTOE.getNroConcurso() +
                "' ");
        }

        if (DTOE.getNombreConcurso() != null) {
            sqlQuery.append(" AND A.VAL_NOMB like '" +
                DTOE.getNombreConcurso() + "'");
        }

        if (DTOE.getOidMarca() != null) {
            sqlQuery.append(" AND D.OID_MARC = " +
                DTOE.getOidMarca().longValue());
        }

        sqlQuery.append(" AND D.OID_MARC = A.MARC_OID_MARC ");

        if (DTOE.getOidCanal() != null) {
            sqlQuery.append(" AND A.CANA_OID_CANA = " +
                DTOE.getOidCanal().longValue());
        }

        sqlQuery.append("AND A.IND_RANK = " +
            ConstantesINC.IND_ACTIVO.longValue());

        sqlQuery.append(" AND idio.ATTR_ENTI = 'SEG_CANAL' ");
        sqlQuery.append(" AND idio.IDIO_OID_IDIO = " +
            DTOE.getOidIdioma().longValue());
        sqlQuery.append(" AND idio.VAL_OID = A.CANA_OID_CANA ");

        try {
            BelcorpService bs = BelcorpService.getInstance();
            String queryPagina = 
                UtilidadesPaginacion.armarQueryPaginacion(sqlQuery.toString(),
                    DTOE);

            r = bs.dbService.executeStaticQuery(queryPagina);
            UtilidadesLog.debug("resultado query: " + r);

            resu.setResultado(r);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        if ((r == null) || r.esVacio()) {
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("DAOConcursoRanking.buscarConcursosRanking(DTOBusc"
            +"arConcursos DTOE): Salida");

        return resu;
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 21/06/2005
      */
    public DTODatosGeneralesConcursoRanking obtenerDatosGeneralesConcursoRanking(
        DTOOID DTOE) throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.obtenerDatosGeneralesConcurso"
            +"Ranking(DTOOID DTOE): Entrada");

        // Realiza una consulta utilizando el servicio DBService. 
        // Esta select tiene alguno campos cuyos nombres no son los correctos 
        // por no estar creados 
        // al momento de realizar esta select   
        UtilidadesLog.debug(" DTOOID: " + DTOE);

        RecordSet r = null;
        StringBuffer sqlQuery = new StringBuffer();
        DTODatosGeneralesConcursoRanking resu = 
            new DTODatosGeneralesConcursoRanking();

        sqlQuery.append("select A.OID_PARA_RANK oid, ");
        sqlQuery.append("A.PERD_OID_PERI oidPeriodoCalificacion, ");
        sqlQuery.append("A.PERD_OID_PERI_PREM oidPeriodoPremiacion, ");
        sqlQuery.append("A.AGRA_OID_AGRU_RANK oidAgrupamiento, ");
        sqlQuery.append("A.TPRK_OID_TIPO_RANK oidTipoRanking, ");
        sqlQuery.append("B.TEXI_OID_TIPO_EXIG oidTipoExigencia ");
        sqlQuery.append("from INC_PARAM_RANKI A, INC_CONCU_PARAM_GENER B ");
        sqlQuery.append("where A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL ");
        sqlQuery.append("and B.OID_PARA_GRAL = " + DTOE.getOid());

        try {
            BelcorpService bs = BelcorpService.getInstance();
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("resultado query: " + r);

            if ((r != null) && (r.getRowCount() > 0)) {
                //supuestamente de levantar registros, levanta solo uno....
                if (r.getRowCount() > 1) {
                    //lanzar excepcion de tal situacion
                }

                Object o = null;

                for (int i = 0; i < r.getRowCount(); i++) {
                    resu.setOid(((o = r.getValueAt(i, "OID")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    resu.setOidPeriodoCalificacion(((o = r.getValueAt(i,
                                "OIDPERIODOCALIFICACION")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    resu.setOidPeriodoPremiacion(((o = r.getValueAt(i,
                                "OIDPERIODOPREMIACION")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    resu.setOidNivelAgrupamiento(((o = r.getValueAt(i,
                                "OIDAGRUPAMIENTO")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    resu.setOidTipoRanking(((o = r.getValueAt(i,
                                "OIDTIPORANKING")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    resu.setOidTipoExigencia(((o = r.getValueAt(i,
                                "OIDTIPOEXIGENCIA")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                }
            }
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOConcursoRanking.obtenerDatosGeneralesConcurso"
            +"Ranking(DTOOID DTOE): Salida");

        return resu;
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 24/06/2005
      */
    public DTOListaVariablesVentaRanking obtenerVariablesVentaRankingConcurso(
        DTOOID DTOE) throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.obtenerVariablesVentaRanking"
            +"Concurso(DTOOID DTOE): Entrada");
        UtilidadesLog.debug(" DTOOID: " + DTOE);

        RecordSet r = null;
        StringBuffer sqlQuery = new StringBuffer();
        DTOListaVariablesVentaRanking resu = null;

        sqlQuery.append(
            "select A.OID_VARI_VENT_RANK_CONC oid, A.NUM_APLI aplicable, ");
        sqlQuery.append(" A.VAL_PESO peso, A.VAL_DIVI divisor, ");
        sqlQuery.append(" A.NUM_DIAS_COBR NUMERODIASCOBRO, ");
        sqlQuery.append(" A.IVVR_OID_VARI_VENT_RANK oidVariableVenta, ");
        
        //jrivas 21080
        //sqlQuery.append(" C.TR_DESC_VARI_VENT_RANK variableVenta ");
        sqlQuery.append(" inte.VAL_I18N variableVenta ");
        sqlQuery.append(
            " from INC_VARIA_VENTA_RANKI_CONCU A, INC_CONCU_PARAM_GENER B, ");
        sqlQuery.append(" INC_VARIA_VENTA_RANKI C, V_GEN_I18N_SICC inte ");
        sqlQuery.append(" where A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL ");
        sqlQuery.append(" and B.OID_PARA_GRAL = " + DTOE.getOid());
        sqlQuery.append(" and A.IVVR_OID_VARI_VENT_RANK =  ");
        sqlQuery.append(" C.OID_VARI_VENT_RANK");
        sqlQuery.append(" and inte.ATTR_ENTI = 'INC_VARIA_VENTA_RANKI'  ");
        sqlQuery.append(" AND inte.ATTR_NUM_ATRI = 1  ");
        sqlQuery.append(" AND inte.IDIO_OID_IDIO =  " + DTOE.getOidIdioma());
        sqlQuery.append(" AND inte.VAL_OID = c.OID_VARI_VENT_RANK   ");


        try {
            BelcorpService bs = BelcorpService.getInstance();
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("resultado query: " + r);

            if (!r.esVacio()) {
                Object o = null;
                resu = new DTOListaVariablesVentaRanking();

                DTOVariablesVentaRankingConcurso registro = null;
                ArrayList lista = new ArrayList();

                for (int i = 0; i < r.getRowCount(); i++) {
                    registro = new DTOVariablesVentaRankingConcurso();

                    registro.setDivisor(((o = 
                        r.getValueAt(i, "DIVISOR")) != null)
                        ? new Integer(((BigDecimal) o).toString()) : null);
                    registro.setNumeroDiasCobro(((o = r.getValueAt(i,
                                "NUMERODIASCOBRO")) != null)
                        ? new Integer(((BigDecimal) o).toString()) : null);
                    registro.setOid(((o = r.getValueAt(i, "OID")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    registro.setOidVariableVenta(((o = r.getValueAt(i,
                                "OIDVARIABLEVENTA")) != null)
                        ? new Long(((BigDecimal) o).toString()) : null);
                    registro.setPeso(((o = r.getValueAt(i, "PESO")) != null)
                        ? new Integer(((BigDecimal) o).toString()) : null);
                    registro.setVariableVenta(((o = r.getValueAt(i,
                                "VARIABLEVENTA")) != null)
                        ? new String((o).toString()) : null);
                    registro.setAplicable(((BigDecimal) r.getValueAt(i,
                            "APLICABLE")).toString().equals("1") ?
                                Boolean.TRUE : Boolean.FALSE);

                    lista.add(registro);
                }

                resu.setListaVariables(lista);
            }
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOConcursoRanking.obtenerVariablesVentaRankingCon"
            +"curso(DTOOID DTOE): Salida");

        return resu;
    }

    /**
      * @Autor: Emilio Noziglia
      * @Fecha : 24/06/2005
      * @Recibe: DTOBelcorp dtoe con pais e idioma
      * @Retorna: RecordSet
      * @Descripción: obtiene el oid y la descripcion de las Variables Ventas
      * de INC
      * @Referencia: SICC-DMCO-INC-INC9 B
      */
    public RecordSet obtenerVariablesVentaRanking(DTOBelcorp dtoe)
        throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.obtenerVariablesVentaRanking("
            +"DTOBelcorp dtoe): Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT vv.OID_VARI_VENT_RANK OID, ");
            buf.append(" inte.VAL_I18N DESCRIPCION ");
            buf.append(" FROM INC_VARIA_VENTA_RANKI vv, ");
            buf.append(" V_GEN_I18N_SICC inte ");
            buf.append(" WHERE inte.ATTR_ENTI = 'INC_VARIA_VENTA_RANKI' ");
            buf.append(" AND inte.ATTR_NUM_ATRI = 1 ");
            buf.append(" AND inte.IDIO_OID_IDIO = " 
                + dtoe.getOidIdioma() + " ");
            buf.append(" AND inte.VAL_OID = vv.OID_VARI_VENT_RANK  ");
            buf.append(" ORDER BY DESCRIPCION");

            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOConcursoRanking.obtenerVariablesVentaRanking("
            +"DTOBelcorp dtoe): Salida");

        return rs;
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 24/06/2005
      */
    public DTOParametrosConsultorasRanking obtenerParametrosConsultorasRanking(
        DTOOID DTOE) throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.obtenerParametrosConsultoras"
            +"Ranking(DTOOID DTOE): Entrada");
        UtilidadesLog.debug(" DTOOID: " + DTOE);

        RecordSet r = null;
        StringBuffer sqlQuery = new StringBuffer();
        DTOParametrosConsultorasRanking resu = null;

        sqlQuery.append(" select A.OID_CONC_PARA_CONS oid, ");
        sqlQuery.append(" B.BCAL_OID_BASE_CALC oidBaseCalculo, ");
        sqlQuery.append(" A.TVEN_OID_TIPO_VENT oidTipoVenta, ");
        sqlQuery.append(" A.PERD_OID_PERI_DESD oidPeriodoDesde, ");
        sqlQuery.append(" A.PERD_OID_PERI_HAST oidPeriodoHasta ");
        sqlQuery.append(" from INC_CONCU_PARAM_CONSU A, ");
        sqlQuery.append(" INC_CONCU_PARAM_GENER B ");
        sqlQuery.append("where A.COPA_OID_PARA_GRAL = B.OID_PARA_GRAL ");
        sqlQuery.append("and B.OID_PARA_GRAL = " + DTOE.getOid());

        try {
            BelcorpService bs = BelcorpService.getInstance();
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("resultado query: " + r);

            if (!r.esVacio()) {
                resu = new DTOParametrosConsultorasRanking();

                Object o = null;

                resu.setOidBaseCalculo(((o = r.getValueAt(0, "OIDBASECALCULO")) 
                    != null) ? new Long(((BigDecimal) o).toString()) : null);
                resu.setOidParametrosConsultoras(((o = r.getValueAt(0, "OID")) 
                    != null) ? new Long(((BigDecimal) o).toString()) : null);
                resu.setOidPeriodoDesde(((o = 
                    r.getValueAt(0, "OIDPERIODODESDE")) != null)
                    ? new Long(((BigDecimal) o).toString()) : null);
                resu.setOidPeriodoHasta(((o = 
                    r.getValueAt(0, "OIDPERIODOHASTA")) != null)
                    ? new Long(((BigDecimal) o).toString()) : null);
                resu.setOidTipoVenta(((o = 
                    r.getValueAt(0, "OIDTIPOVENTA")) != null)
                    ? new Long(((BigDecimal) o).toString()) : null);
            }
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOConcursoRanking.obtenerParametrosConsultorasRa"
            +"nking(DTOOID DTOE): Salida");

        return resu;
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 24/06/2005
      */
    public DTOParametrosGeneralesPremiacion obtenerPremiosRanking(DTOOID DTOE)
        throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.obtenerPremiosRanking(DTOOID "
            +"DTOE): Entrada");
        UtilidadesLog.debug("DTOOID: " + DTOE);

        // Esta select recupera información de la entidad 
        // INC:ParametrosGeneralesPremiacion 
        // filtarndo por el oid del concurso 
        RecordSet r = null;
        StringBuffer sqlQuery = new StringBuffer();
        DTOParametrosGeneralesPremiacion resu = null;

        sqlQuery.append(
            "select A.OID_PARA_GENE_PREM oidParamGralesPremiacion, ");
        sqlQuery.append("A.NUM_NIVE numeroNiveles, ");
        sqlQuery.append("A.IND_COMU comunicacion, ");
        sqlQuery.append("B.COD_MENS mensaje, ");
        sqlQuery.append("A.PERD_OID_PERI oidPeriodoDespacho ");
        sqlQuery.append("from INC_PARAM_GENER_PREMI A, MSG_MENSA B, ");
        sqlQuery.append("INC_CONCU_PARAM_GENER C ");
        sqlQuery.append("where A.COPA_OID_PARA_GRAL = C.OID_PARA_GRAL ");
        sqlQuery.append("and A.MENS_OID_MENS = B.OID_MENS(+) ");
        sqlQuery.append("and C.OID_PARA_GRAL = " + DTOE.getOid());

        try {
            BelcorpService bs = BelcorpService.getInstance();
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("resultado query: " + r);

            if (!r.esVacio()) {
                Object o = null;
                resu = new DTOParametrosGeneralesPremiacion();

                resu.setOidParamGralesPremiacion(((o = r.getValueAt(0,
                            "OIDPARAMGRALESPREMIACION")) != null)
                    ? new Long(((BigDecimal) o).toString()) : null);
                resu.setOidTipoPremiacion(null);
                resu.setIndPeriodoDespacho(new Boolean(
                        ConstantesINC.IND_INACTIVO.toString()));
                resu.setOidPeriodo(((o = r.getValueAt(0, "OIDPERIODODESPACHO")) 
                    != null)? new Long(((BigDecimal) o).toString()) : null);
                resu.setNroPeriodosObtencion(null);

                BigDecimal ind = (BigDecimal) r.getValueAt(0, "COMUNICACION");
                
                //Boolean -- IND_COMU
                if ((ind != null) && (ind.intValue() == 1)) {
                    resu.setIndComunicacion(Boolean.TRUE); 
                } else {
                    resu.setIndComunicacion(Boolean.FALSE); 
                }

                resu.setMensaje(((o = r.getValueAt(0, "MENSAJE")) != null)
                    ? new String((o).toString()) : null);
                resu.setNroNiveles(((o = r.getValueAt(0, "NUMERONIVELES")) 
                    != null) ? new Integer(((BigDecimal) o).toString())
                        : null);
                resu.setIndPremiosAcumulativosNiveles(new Boolean(
                        ConstantesINC.IND_INACTIVO.toString()));
                resu.setIndNivelesRotativos(new Boolean(
                        ConstantesINC.IND_INACTIVO.toString()));
                resu.setNroRotaciones(null);
                resu.setIndAccesoNivelPremioSuperior(new Boolean(
                        ConstantesINC.IND_INACTIVO.toString()));
                resu.setIndPremiosElectivos(new Boolean(
                        ConstantesINC.IND_INACTIVO.toString()));
                resu.setOidTipoEleccion(null);
            }
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOConcursoRanking.obtenerPremiosRanking(DTOOID "
            +"DTOE): Salida");

        return resu;
    }
    
   /**
     * Autor: Cristian Valenzuela
     * Fecha: 18/10/2006
     * Incidencia: BELC300024282
     */
    public DTOSalida obtenerDetalleParticipantes(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("DAOConcursoRanking.obtenerDetalleParticipantes(DTOOID DTOE): Entrada");
        DTOSalida dtoSalida = new DTOSalida();
      
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {        
            buf.append(" SELECT IPCC.OID_PART_CONC_CABE,  ");
            buf.append(" IPCC.VAL_GRUP_CLIE,  ");
            buf.append(" (SELECT V2.VAL_I18N  ");
            buf.append(" FROM V_GEN_I18N_SICC V2  ");
            buf.append(" WHERE V2.VAL_OID = IPCD.TICL_OID_TIPO_CLIE  ");
            buf.append(" AND V2.ATTR_ENTI LIKE 'MAE_TIPO_CLIEN'  ");
            buf.append(" AND V2.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            buf.append(" AND V2.ATTR_NUM_ATRI = 1 ) AS TIPOCLIENTE,  ");
            buf.append(" (SELECT V3.VAL_I18N  ");
            buf.append(" FROM V_GEN_I18N_SICC V3  ");
            buf.append(" WHERE V3.VAL_OID = IPCD.SBTI_OID_SUBT_CLIE  ");
            buf.append(" AND V3.ATTR_ENTI LIKE 'MAE_SUBTI_CLIEN'  ");
            buf.append(" AND V3.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            buf.append(" AND V3.ATTR_NUM_ATRI = 1 ) AS SUBTIPOCLIENTE, ");
            buf.append(" (SELECT V5.VAL_I18N  ");
            buf.append(" FROM V_GEN_I18N_SICC V5  ");
            buf.append(" WHERE V5.VAL_OID = IPCD.CLAS_OID_CLAS  ");
            buf.append(" AND V5.ATTR_ENTI LIKE 'MAE_CLASI'  ");
            buf.append(" AND V5.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            buf.append(" AND V5.ATTR_NUM_ATRI = 1 ) AS CLASIFICACION,	 ");
            buf.append(" (SELECT V4.VAL_I18N  ");
            buf.append(" FROM V_GEN_I18N_SICC V4  ");
            buf.append(" WHERE V4.VAL_OID = IPCD.TCCL_OID_TIPO_CLAS  ");
            buf.append(" AND V4.ATTR_ENTI LIKE 'MAE_TIPO_CLASI_CLIEN'  ");
            buf.append(" AND V4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
            buf.append(" AND V4.ATTR_NUM_ATRI = 1 ) AS TIPOCLASIFICACION ");
            buf.append(" FROM INC_PARTI_CONCU_CABEC IPCC,  ");
            buf.append(" INC_PARTI_CONCU_DETAL IPCD,  ");
            buf.append(" MAE_TIPO_CLIEN MTC,  ");
            buf.append(" MAE_SUBTI_CLIEN MSC,  ");
            buf.append(" MAE_TIPO_CLASI_CLIEN MTCC,  ");
            buf.append(" MAE_CLASI MC  ");
            buf.append(" WHERE IPCC.PAIS_OID_PAIS =	" + DTOE.getOidPais());
            buf.append(" AND IPCC.OID_PART_CONC_CABE = " + DTOE.getOid());
            buf.append(" AND IPCD.PACI_OID_PART_CONC_CABE = IPCC.OID_PART_CONC_CABE  ");
            buf.append(" AND MTC.OID_TIPO_CLIE = IPCD.TICL_OID_TIPO_CLIE  ");
            buf.append(" AND MSC.OID_SUBT_CLIE(+) = IPCD.SBTI_OID_SUBT_CLIE  ");
            buf.append(" AND MTCC.OID_TIPO_CLAS(+) = IPCD.TCCL_OID_TIPO_CLAS  ");
            buf.append(" AND MC.OID_CLAS(+) = IPCD.CLAS_OID_CLAS  ");            

            rs = bs.dbService.executeStaticQuery(buf.toString());
        }        
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("*** rs " + rs);
        dtoSalida.setResultado(rs);
  
        UtilidadesLog.info("DAOConcursoRanking.obtenerDetalleParticipantes(DTOOID DTOE): Salida");
        return dtoSalida;
    }
}