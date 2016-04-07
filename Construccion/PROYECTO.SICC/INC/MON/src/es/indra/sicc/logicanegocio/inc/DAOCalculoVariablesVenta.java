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
 *  @author: Damasia Maneiro
 *  
 *  
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOResultadoConcursoVariablesVenta;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.HashMap;


public class DAOCalculoVariablesVenta {
    public DAOCalculoVariablesVenta() {
    }

    /**
    * rgiorgi - 24-8-2005: modificación de consulta por correspondencia del DT.
    * Fecha de Creacion: 10/06/2005
    * Autor: Damasia Maneiro
    * Descripcion: este metodo cuenta la cantidad de clientes que pertenecen a 
    * las unidades administrativas
    * recibidas por parametro, que pasaron solicitudes en los periodos tambien 
    * recibidos por parametro.
    *
    */
    public Integer recuperarCantidadActivasIniciales(
        UnidadesAdministrativasGerenciadas unidGer, ArrayList arrPer)
        throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarCantidadActivas"
            +"Iniciales(UnidadesAdministrativasGerenciadas unidGer, ArrayList "
            +"arrPer):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        StringBuffer UA = new StringBuffer();
        ArrayList reg = null;
        int corte = 1000;
        int cantReg = 0;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(
                " SELECT COUNT (clientes_pedidos.CLIE_OID_CLIE) CANTIDAD");
            query.append(" FROM ( ");
            query.append(" SELECT DISTINCT sol.CLIE_OID_CLIE ");
            query.append(
                " FROM PED_SOLIC_CABEC sol ,  ");
            query.append(" (SELECT SEC.OID_SECC ZSCC_OID_SECC,  UNA.CLIE_OID_CLIE ");
            query.append(" FROM MAE_CLIEN_UNIDA_ADMIN UNA,  ZON_TERRI_ADMIN TERR,  ZON_SECCI SEC, ");			   	
            query.append(" ZON_ZONA ZON, ZON_REGIO REG, ZON_SUB_GEREN_VENTA SUB, ");
            query.append(" CRA_PERIO PER_DSD, CRA_PERIO PER_HST, CRA_PERIO PER_ENT ");
            query.append(" WHERE UNA.ZTAD_OID_TERR_ADMI = TERR.OID_TERR_ADMI ");
            query.append(" AND TERR.ZSCC_OID_SECC = SEC.OID_SECC  ");
            query.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA  ");
            query.append(" AND ZON.ZORG_OID_REGI = REG.OID_REGI ");
            query.append(" AND REG.ZSGV_OID_SUBG_VENT = SUB.OID_SUBG_VENT ");
            query.append(" AND UNA.PERD_OID_PERI_INI = PER_DSD.OID_PERI ");
            query.append(" AND UNA.PERD_OID_PERI_FIN = PER_HST.OID_PERI(+) ");
            query.append(" AND PER_ENT.OID_PERI = " + ((Periodo) arrPer.get(0)).getOidPeriodo());
            query.append(" AND PER_DSD.FEC_INIC <= PER_ENT.FEC_INIC ");
            query.append(" AND (PER_HST.OID_PERI IS NULL OR PER_HST.FEC_FINA >= PER_ENT.FEC_FINA) ");
            query.append(" AND UNA.IND_ACTI = 1 ) terrAdmin");
            
            if ((unidGer.getSubGerencias() != null) &&
                    (unidGer.getSubGerencias().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona, ");
                query.append(" ZON_REGIO reg ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");

                cantReg = unidGer.getSubGerencias().size();
                reg = unidGer.getSubGerencias();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getRegiones() != null) &&
                    (unidGer.getRegiones().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");

                cantReg = unidGer.getRegiones().size();
                reg = unidGer.getRegiones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND zona.ZORG_OID_REGI IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getZonas() != null) &&
                    (unidGer.getZonas().size() != 0)) {
                query.append(" , ZON_SECCI secc ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");

                cantReg = unidGer.getZonas().size();
                reg = unidGer.getZonas();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getSecciones() != null) &&
                    (unidGer.getSecciones().size() != 0)) {
                cantReg = unidGer.getSecciones().size();
                reg = unidGer.getSecciones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                    UA.toString().substring(2) + " ) ");
            }

            query.append(" AND PERD_OID_PERI IN ( " +
                ((Periodo) arrPer.get(1)).getOidPeriodo() + ", " +
                ((Periodo) arrPer.get(2)).getOidPeriodo() + " )");
          
            query.append(" AND SOL.CLIE_OID_CLIE = terrAdmin.CLIE_OID_CLIE ");
            query.append(" AND SOL.FEC_FACT IS NOT NULL");
            query.append(" AND SOL.IND_OC = 1");

            query.append(" ) clientes_pedidos ");

            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!rs.esVacio()) {
            UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarCantidadActi"
                +"vasIniciales(UnidadesAdministrativasGerenciadas unidGer, "
                +"ArrayList arrPer):Salida");

            return new Integer(((BigDecimal) rs.getValueAt(0, "CANTIDAD"))
                .intValue());
        } else {
            UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarCantidadActi"
                +"vasIniciales(UnidadesAdministrativasGerenciadas unidGer, "
                +"ArrayList arrPer):Salida");

            return null;
        }
    }

    /**
     * rgiorgi - 24/08/2005: modificación de consulta por correspondencia del 
     * DT.
    * Fecha de Creacion: 10/06/2005
    * Autor: Damasia Maneiro
    * Descripcion: este metodo cuenta la cantidad de clientes que pertenecen a
    * las unidades administrativas recibidas por parametro, que pasaron 
    * solicitudes en los periodos tambien recibidos por parametro.
    *
    */
    public Integer recuperarCantidadActivasFinales(
        UnidadesAdministrativasGerenciadas unidGer, ArrayList arrPer)
        throws MareException {
        
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarCantidadActivas"
            +"Finales(UnidadesAdministrativasGerenciadas unidGer, ArrayList "
            +"arrPer):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        StringBuffer UA = new StringBuffer();
        ArrayList reg = null;
        int corte = 1000;
        int cantReg = 0;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(
                " SELECT COUNT (clientes_pedidos.CLIE_OID_CLIE) CANTIDAD");
            query.append(" FROM ( ");
            query.append(" SELECT DISTINCT sol.CLIE_OID_CLIE ");
            query.append(
                " FROM PED_SOLIC_CABEC sol , ");
             query.append(" (SELECT SEC.OID_SECC ZSCC_OID_SECC,  UNA.CLIE_OID_CLIE ");
            query.append(" FROM MAE_CLIEN_UNIDA_ADMIN UNA,  ZON_TERRI_ADMIN TERR,  ZON_SECCI SEC, ");			   	
            query.append(" ZON_ZONA ZON, ZON_REGIO REG, ZON_SUB_GEREN_VENTA SUB, ");
            query.append(" CRA_PERIO PER_DSD, CRA_PERIO PER_HST, CRA_PERIO PER_ENT ");
            query.append(" WHERE UNA.ZTAD_OID_TERR_ADMI = TERR.OID_TERR_ADMI ");
            query.append(" AND TERR.ZSCC_OID_SECC = SEC.OID_SECC  ");
            query.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA  ");
            query.append(" AND ZON.ZORG_OID_REGI = REG.OID_REGI ");
            query.append(" AND REG.ZSGV_OID_SUBG_VENT = SUB.OID_SUBG_VENT ");
            query.append(" AND UNA.PERD_OID_PERI_INI = PER_DSD.OID_PERI ");
            query.append(" AND UNA.PERD_OID_PERI_FIN = PER_HST.OID_PERI(+) ");
            query.append(" AND PER_ENT.OID_PERI = " + ((Periodo) arrPer.get(0)).getOidPeriodo());
            query.append(" AND PER_DSD.FEC_INIC <= PER_ENT.FEC_INIC ");
            query.append(" AND (PER_HST.OID_PERI IS NULL OR PER_HST.FEC_FINA >= PER_ENT.FEC_FINA) ");
            query.append(" AND UNA.IND_ACTI = 1 ) terrAdmin");

            if ((unidGer.getSubGerencias() != null) &&
                    (unidGer.getSubGerencias().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona, ");
                query.append(" ZON_REGIO reg ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");

                cantReg = unidGer.getSubGerencias().size();
                reg = unidGer.getSubGerencias();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getRegiones() != null) &&
                    (unidGer.getRegiones().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");

                cantReg = unidGer.getRegiones().size();
                reg = unidGer.getRegiones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND zona.ZORG_OID_REGI IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getZonas() != null) &&
                    (unidGer.getZonas().size() != 0)) {
                query.append(" , ZON_SECCI secc ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");

                cantReg = unidGer.getZonas().size();
                reg = unidGer.getZonas();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getSecciones() != null) &&
                    (unidGer.getSecciones().size() != 0)) {
                cantReg = unidGer.getSecciones().size();
                reg = unidGer.getSecciones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                    UA.toString().substring(2) + " ) ");
            }

            query.append(" AND PERD_OID_PERI IN ( " +
                ((Periodo) arrPer.get(0)).getOidPeriodo() + ", " +
                ((Periodo) arrPer.get(1)).getOidPeriodo() + " )");

            query.append(" AND SOL.CLIE_OID_CLIE = terrAdmin.CLIE_OID_CLIE ");
            query.append(" AND SOL.FEC_FACT IS NOT NULL");
            query.append(" AND SOL.IND_OC = 1");

            query.append(" ) clientes_pedidos ");

            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!rs.esVacio()) {
            UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarCantidadActi"
                +"vasFinales(UnidadesAdministrativasGerenciadas unidGer, "
                +"ArrayList arrPer):Salida");

            return new Integer(((BigDecimal) rs.getValueAt(0, "CANTIDAD"))
                .intValue());
        } else {
            UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarCantidad"
                +"ActivasFinales(UnidadesAdministrativasGerenciadas unidGer, "
                +"ArrayList arrPer):Salida");

            return null;
        }
    }

    /**
        * rgiorgi - 24/08/2005: corrección del filtro de UAs
    * Fecha de Creacion: 10/06/2005
    * Autor: Damasia Maneiro
    * Descripcion: recupera el total de monto y unidades acordes a los 
    * parametros recibidos.
    *
    */
    public DTOResultadoConcursoVariablesVenta recuperarMontoUnidadesConExigencias(
        Long oidConcurso, InfoGerentesConcursos infoGerConc,
        GerenteVariablesVenta gerVarVta) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMontoUnidades"
            +"ConExigencias(Long oidConcurso, InfoGerentesConcursos infoGerCon "
            +"GerenteVariablesVenta gerVarVta):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        DTOResultadoConcursoVariablesVenta dtoResulConcuVarVta =
            new DTOResultadoConcursoVariablesVenta();
        StringBuffer UA = new StringBuffer();
        ArrayList reg = null;
        int corte = 1000;
        int cantReg = 0;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (gerVarVta.getUnidadesGerenciadas() != null) {
            UnidadesAdministrativasGerenciadas unidGer = 
                gerVarVta.getUnidadesGerenciadas();

            try {
                query.append(" SELECT SCP.COPA_OID_PARA_GRAL, ");
                query.append(" SUM(SCP.IMP_MONT) ");
                query.append(" AS totalMonto, ");
                query.append(" SUM(SCP.NUM_UNID) AS totalUnidades ");
                query.append(" FROM INC_SOLIC_CONCU_PUNTA SCP, ");
                query.append(" PED_SOLIC_CABEC SC, ZON_TERRI_ADMIN terrAdmin");

                if ((unidGer.getSubGerencias() != null) &&
                        (unidGer.getSubGerencias().size() != 0)) {
                    query.append(" , ZON_SECCI secc, ");
                    query.append(" ZON_ZONA zona, ");
                    query.append(" ZON_REGIO reg ");

                    query.append(
                        " WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                    query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                    query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");

                    cantReg = unidGer.getSubGerencias().size();
                    reg = unidGer.getSubGerencias();

                    for (int i = 0; i < cantReg; i++) {
                        UA.append((", "));
                        UA.append(reg.get(i));
                    }

                    query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                        UA.toString().substring(2) + " ) ");
                } else if ((unidGer.getRegiones() != null) &&
                        (unidGer.getRegiones().size() != 0)) {
                    query.append(" , ZON_SECCI secc, ");
                    query.append(" ZON_ZONA zona ");

                    query.append(
                        " WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                    query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");

                    cantReg = unidGer.getRegiones().size();
                    reg = unidGer.getRegiones();

                    for (int i = 0; i < cantReg; i++) {
                        UA.append((", "));
                        UA.append(reg.get(i));
                    }

                    query.append(" AND zona.ZORG_OID_REGI IN ( " +
                        UA.toString().substring(2) + " ) ");
                } else if ((unidGer.getZonas() != null) &&
                        (unidGer.getZonas().size() != 0)) {
                    query.append(" , ZON_SECCI secc ");

                    query.append(
                        " WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");

                    cantReg = unidGer.getZonas().size();
                    reg = unidGer.getZonas();

                    for (int i = 0; i < cantReg; i++) {
                        UA.append((", "));
                        UA.append(reg.get(i));
                    }

                    query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                        UA.toString().substring(2) + " ) ");
                } else if ((unidGer.getSecciones() != null) &&
                        (unidGer.getSecciones().size() != 0)) {
                    cantReg = unidGer.getSecciones().size();
                    reg = unidGer.getSecciones();

                    for (int i = 0; i < cantReg; i++) {
                        UA.append((", "));
                        UA.append(reg.get(i));
                    }

                    query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                        UA.toString().substring(2) + " ) ");
                }

                query.append(" AND SCP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE");
                query.append(
                    " AND SC.ztad_oid_terr_admi = terrAdmin.OID_TERR_ADMI");
                query.append(" AND SCP.CLIE_OID_CLIE_GERE IN (");
                query.append(" SELECT EXP.CLIE_OID_CLIE");
                query.append(" FROM INC_EXIGE_CUMPL EXP");
                query.append(" WHERE EXP.COPA_OID_PARA_GRAL = " + oidConcurso);
                query.append(" AND EXP.IND_EXIG_CUMP = 1");
                query.append(" AND EXP.FEC_CUMP <= TO_DATE('" +
                    infoGerConc.getPeriodoCierre().getFechaHasta() +
                    "', 'YYYY-MM-DD') ");
                query.append(" ) AND SCP.COPA_OID_PARA_GRAL = " + oidConcurso);
                query.append(" AND SCP.CLIE_OID_CLIE_GERE = " +
                    gerVarVta.getOidGerente());
                query.append(" AND SCP.PERD_OID_PERI = " +
                    infoGerConc.getPeriodoCierre().getOidPeriodo());
                query.append(" AND SC.FEC_FACT IS NOT NULL");
                query.append(" AND SC.IND_OC = 1");
                query.append(" GROUP BY SCP.COPA_OID_PARA_GRAL, ");
                query.append(" SCP.CLIE_OID_CLIE_GERE, SCP.PERD_OID_PERI");

                rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!rs.esVacio()) {
                dtoResulConcuVarVta.setOidConcurso(new Long(
                        ((BigDecimal) rs.getValueAt(0, "COPA_OID_PARA_GRAL"))
                            .longValue()));

                if (rs.getValueAt(0, "TOTALMONTO") != null) {
                    dtoResulConcuVarVta.setTotalVentaNetaEstadisticable(
                        (BigDecimal) rs.getValueAt(0, "TOTALMONTO"));
                }

                if (rs.getValueAt(0, "TOTALUNIDADES") != null) {
                    dtoResulConcuVarVta.setTotalUnidadesVendidas(new Long(
                            ((BigDecimal) rs.getValueAt(0, "TOTALUNIDADES"))
                                .longValue()));
                }

                UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMontoUni"
                    +"dadesConExigencias(Long oidConcurso, InfoGerentesConcu"
                    +"rsos infoGerCon GerenteVariablesVenta gerVarVta):Salida");

                return dtoResulConcuVarVta;
            }
        }

        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMontoUnidadesCon"
            +"Exigencias(Long oidConcurso, InfoGerentesConcursos infoGerCon "
            +"GerenteVariablesVenta gerVarVta):Salida");

        return null;
    }

    /**
     * rgiorgi - 28/08/2005: correccion de filtro de UAs
    * Fecha de Creacion: 10/06/2005
    * Autor: Damasia Maneiro
    * Descripcion: calcula la cantidad de clientes asociados a un gerente que
    * hayan pasado solicitudes segun los parametros de entrada.
    *
    */
    public Long recuperarCantidadSolicitudes(
        UnidadesAdministrativasGerenciadas unidGer, ArrayList arrPer)
        throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarCantidadSolicit"
            +"udes(UnidadesAdministrativasGerenciadas unidGer, ArrayList "
            +"arrPer):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        StringBuffer UA = new StringBuffer();
        ArrayList reg = null;
        int corte = 1000;
        int cantReg = 0;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT COUNT(SOL.CLIE_OID_CLIE) AS CANTIDAD");
            query.append(" FROM PED_SOLIC_CABEC SOL, ZON_TERRI_ADMIN terrAdmin");

            if ((unidGer.getSubGerencias() != null) &&
                    (unidGer.getSubGerencias().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona, ");
                query.append(" ZON_REGIO reg ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");

                cantReg = unidGer.getSubGerencias().size();
                reg = unidGer.getSubGerencias();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getRegiones() != null) &&
                    (unidGer.getRegiones().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");

                cantReg = unidGer.getRegiones().size();
                reg = unidGer.getRegiones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND zona.ZORG_OID_REGI IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getZonas() != null) &&
                    (unidGer.getZonas().size() != 0)) {
                query.append(" , ZON_SECCI secc ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");

                cantReg = unidGer.getZonas().size();
                reg = unidGer.getZonas();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getSecciones() != null) &&
                    (unidGer.getSecciones().size() != 0)) {
                cantReg = unidGer.getSecciones().size();
                reg = unidGer.getSecciones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                    UA.toString().substring(2) + " ) ");
            }

            query.append(
                " AND SOL.ztad_oid_terr_admi = terrAdmin.oid_terr_admi ");
            query.append(" AND SOL.PERD_OID_PERI = " +
                ((Periodo) arrPer.get(0)).getOidPeriodo());
            query.append(" AND SOL.FEC_FACT IS NOT NULL");
            query.append(" AND SOL.IND_OC = 1");

            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (!rs.esVacio()) {
            UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarCantidadSo"
                +"licitudes(UnidadesAdministrativasGerenciadas unidGer, Array"
                +"List arrPer):Salida");

            return new Long(((BigDecimal) rs.getValueAt(0, "CANTIDAD"))
                .intValue());
        } else {
            //return null;
            //Cleal 5/7/2005
            UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarCantidadSol"
                +"icitudes(UnidadesAdministrativasGerenciadas unidGer, ArrayL "
                +"ist arrPer):Salida");

            return new Long(0);
        }
    }

    /**
    * Fecha de Creacion: 10/06/2005
    * Autor: Damasia Maneiro
    * Descripcion: obtiene los resultados guardados para un cliente y un 
    * concurso.
    *
    */
    public MetasVentaProyectada recuperarMetasGerenteConcurso(
        GerenteVariablesVenta gerVarVta, ConcursoVariablesVenta concurso,
        Periodo periodoDesde, Periodo periodoHasta) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMetasGerente"
            +"Concurso(erenteVariablesVenta gerVarVta, ConcursoVariablesVenta "
            +"concurso, Periodo periodoDesde, Periodo periodoHasta):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        String table = "";
        String campoUnidadAdmin = "";
        MetasVentaProyectada metasVentaProyectada = new MetasVentaProyectada();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (gerVarVta.getUnidadesGerenciadas() != null) {
            ArrayList regiones = 
                gerVarVta.getUnidadesGerenciadas().getRegiones();
            ArrayList zonas = gerVarVta.getUnidadesGerenciadas().getZonas();
            ArrayList subGerencias = gerVarVta.getUnidadesGerenciadas()
                                              .getSubGerencias();

            if ((regiones != null) && (regiones.size() > 0)) {
                table = "INC_METAS_VENTA_PROYE_REGIO";
                campoUnidadAdmin = "ZORG_OID_REGI";
            }

            if ((zonas != null) && (zonas.size() > 0)) {
                table = "INC_METAS_VENTA_PROYE_ZONA";
                campoUnidadAdmin = "ZZON_OID_ZONA";
            }

            if ((subGerencias != null) && (subGerencias.size() > 0)) {
                table = "INC_METAS_VENTA_PROYE_SUBGE";
                campoUnidadAdmin = "ZSGV_OID_SUBG_VENT";
            }

            query.append(" SELECT SUM(MVP.NUM_ACTI_INIC) AS ACTIVAS_INICIALES,");
            query.append(" SUM(MVP.NUM_ACTI_FINA) AS ACTIVAS_FINALES,");
            query.append(" SUM(MVP.IMP_INGR) AS INGRESOS,");
            query.append(" SUM(MVP.IMP_REIN) AS REINGRESOS,");
            query.append(" SUM(MVP.IMP_EGRE) AS EGRESOS,");
            query.append(" SUM(MVP.NUM_ORDE) AS NUMERO_ORDENES,");
            query.append(" SUM(MVP.NUM_PEDI) AS NUMERO_PEDIDO,");
            query.append(" SUM(MVP.NUM_UNID_VEND) AS UNIDADES_VENDIDAS,");
            query.append(" SUM(MVP.NUM_CLIE) AS NUMERO_CLIENTES,");
            query.append(
                " SUM(MVP.IMP_VENT_NETA_ESTA) AS VENTA_NETA_ESTADISTICA,");
            query.append(" SUM(MVP.IMP_CAPI) AS CAPITALIZACION,");
            query.append(" SUM(MVP.IMP_ACTI) AS ACTIVIDAD,");
            query.append(
                " SUM(MVP.IMP_PREC_PROM_UNIT) AS PRECIO_PROM_UNITARIO,");
            query.append(" SUM(MVP.VAL_PROM_VENT_PEDI) AS PROM_VTA_PEDIDO,");
            query.append(
                " SUM(MVP.VAL_PROM_UNID_PEDI) AS PROM_UNIDADES_PEDIDO,");
            query.append(" SUM(MVP.VAL_PROM_ORDE_PEDI) AS PROM_ORDENES_PEDIDO,");
            query.append(" SUM(MVP.IMP_RETE) AS RETENCION,");
            query.append(" SUM(MVP.NUM_ENTR) AS NUMERO_ENTREGAS,");
            query.append(" SUM(MVP.NUM_RECI) AS NUMERO_RECIBIDAS,");
            query.append(" SUM(MVP.VAL_ROTA) AS ROTACION");
            query.append(" FROM " + table + " MVP, cra_perio p_actual ");
            query.append(" WHERE MVP.COPA_OID_PARA_GRAL = " +
                concurso.getOidConcurso());
            query.append(" AND MVP.CLIE_OID_CLIE = " +
                gerVarVta.getOidGerente());
            query.append(" AND MVP.PERD_OID_PERI = p_actual.OID_PERI");
            query.append(" AND p_actual.fec_inic >= (SELECT fec_inic ");
            query.append(" FROM cra_perio WHERE oid_peri = " +
                periodoDesde.getOidPeriodo() + ") ");
            query.append(
                " AND p_actual.fec_inic <= (SELECT fec_inic FROM cra_perio ");
            query.append(" WHERE oid_peri = " +
                periodoHasta.getOidPeriodo() + ") ");

            //TODO: verificar si la de fin tambien debe filtrarse
            //query.append(" AND p_actual.fec_fina >= (SELECT fec_fina FROM
            //cra_perio WHERE oid_peri = " + periodoDesde.getOidPeriodo()
            //+ ")");
            //query.append(" AND p_actual.fec_fina < (SELECT fec_fina FROM 
            //cra_perio WHERE oid_peri = " + periodoHasta.getOidPeriodo()
            //+ ") ");
            query.append(" AND MVP." + campoUnidadAdmin + " = " +
                gerVarVta.getUnidadesGerenciadas().getUnidadesGerenciadas()
                    .get(0));
                    
            query.append(" GROUP BY MVP.CLIE_OID_CLIE");

            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!rs.esVacio()) {
                metasVentaProyectada.setActivasIniciales(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "ACTIVAS_INICIALES"))
                            .intValue()));
                metasVentaProyectada.setActivasFinales(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "ACTIVAS_FINALES"))
                            .intValue()));
                metasVentaProyectada.setIngresos(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "INGRESOS"))
                            .intValue()));
                metasVentaProyectada.setReingresos(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "REINGRESOS"))
                            .intValue()));
                metasVentaProyectada.setEgresos(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "EGRESOS"))
                            .intValue()));
                metasVentaProyectada.setNumeroOrdenes(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "NUMERO_ORDENES"))
                            .intValue()));
                metasVentaProyectada.setNumeroPedidos(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "NUMERO_PEDIDO"))
                            .intValue()));
                metasVentaProyectada.setUnidadesVendidas(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "UNIDADES_VENDIDAS"))
                            .intValue()));
                metasVentaProyectada.setNumeroClientes(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "NUMERO_CLIENTES"))
                            .intValue()));
                metasVentaProyectada.setVentaNetaEstadisticable((BigDecimal) 
                    rs.getValueAt(0, "VENTA_NETA_ESTADISTICA"));

                if (rs.getValueAt(0, "CAPITALIZACION") != null) {
                    metasVentaProyectada.setCapitalizacion((BigDecimal) 
                        rs.getValueAt(0, "CAPITALIZACION"));
                }

                if (rs.getValueAt(0, "ACTIVIDAD") != null) {
                    metasVentaProyectada.setActividad((BigDecimal) 
                        rs.getValueAt(0, "ACTIVIDAD"));
                }

                metasVentaProyectada.setPrecioPromedioUnitario((BigDecimal) 
                    rs.getValueAt(0, "PRECIO_PROM_UNITARIO"));

                if (rs.getValueAt(0, "PROM_VTA_PEDIDO") != null) {
                    metasVentaProyectada.setPromedioVentaPedido((BigDecimal) 
                        rs.getValueAt(0, "PROM_VTA_PEDIDO"));
                }

                if (rs.getValueAt(0, "PROM_UNIDADES_PEDIDO") != null) {
                    metasVentaProyectada.setPromedioUnidadesPedido((BigDecimal) 
                        rs.getValueAt(0, "PROM_UNIDADES_PEDIDO"));
                }

                if (rs.getValueAt(0, "PROM_ORDENES_PEDIDO") != null) {
                    metasVentaProyectada.setPromedioOrdenesPedido((BigDecimal) 
                        rs.getValueAt( 0, "PROM_ORDENES_PEDIDO"));
                }

                if (rs.getValueAt(0, "RETENCION") != null) {
                    metasVentaProyectada.setRetencion((BigDecimal) 
                        rs.getValueAt(0, "RETENCION"));
                }

                if (rs.getValueAt(0, "NUMERO_ENTREGAS") != null) {
                    metasVentaProyectada.setNumeroEntregadas(new Long(
                            ((BigDecimal) rs.getValueAt(0, "NUMERO_ENTREGAS"))
                                .longValue()));
                }

                if (rs.getValueAt(0, "NUMERO_RECIBIDAS") != null) {
                    metasVentaProyectada.setNumeroRecibidas(new Long(
                            ((BigDecimal) rs.getValueAt(0, "NUMERO_RECIBIDAS"))
                                .longValue()));
                }

                if (rs.getValueAt(0, "ROTACION") != null) {
                    metasVentaProyectada.setRotacion((BigDecimal) 
                        rs.getValueAt( 0, "ROTACION"));
                }

                UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMetasGer"
                    +"enteConcurso(GerenteVariablesVenta gerVarVta, ConcursoVa"
                    +"riablesVenta concurso, Periodo periodoDesde, Periodo per"
                    +"iodoHasta):Salida");

                return metasVentaProyectada;
            }
        }

        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMetasGerenteCon"
            +"curso(GerenteVariablesVenta gerVarVta, ConcursoVariablesVenta "
            +"concurso, Periodo periodoDesde, Periodo periodoHasta):Salida");

        return null;
    }

    /**
    * rgiorgi - 24/08/2005: corrección del filtro de UA.
    * Fecha de Creacion: 13/06/2005
    * Autor: Damasia Maneiro
    * Descripcion: Este método recupera la cantidad de consultoras del gerente 
    * por cada estatus
    *
    */
    public HashMap recuperarIngresosReingresosEgresos(
        GerenteVariablesVenta gerVarVta, Periodo periodoCierre)
        throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarIngresosReingresosEgresos"
            +"(GerenteVariablesVenta gerVarVta, Periodo periodoCierre):"
            +"Entrada");
        UtilidadesLog.debug("Entro DAOCalculoVariablesVenta.recuperarIngresosRe"
            +"ingresosEgresos ***");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        StringBuffer UA = new StringBuffer();
        ArrayList reg = null;
        int corte = 1000;
        int cantReg = 0;

        String table = "";
        String campoUnidadAdmin = "";
        HashMap estadosCliente = new HashMap();
        BigDecimal oidEstado = null;
        Integer count = null;

        //Cleal 10/8/2005
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoCierre.getFechaDesde());
        String strFechaHasta = sdf.format(periodoCierre.getFechaHasta());

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (gerVarVta.getUnidadesGerenciadas() != null) {
            UnidadesAdministrativasGerenciadas unidGer =
                gerVarVta.getUnidadesGerenciadas();

            query.append(
                " SELECT histo.esta_oid_esta_clie oidEstatus, COUNT (*) count");
            query.append(" FROM mae_clien_unida_admin unida,");
            query.append(" cra_perio p1, cra_perio p2,");
            query.append(
                " zon_terri_admin terrAdmin, mae_clien_histo_estat histo,");
            query.append(" cra_perio p3, cra_perio p4");

            if ((unidGer.getSubGerencias() != null) &&
                    (unidGer.getSubGerencias().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona, ");
                query.append(" ZON_REGIO reg ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");

                cantReg = unidGer.getSubGerencias().size();
                reg = unidGer.getSubGerencias();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getRegiones() != null) &&
                    (unidGer.getRegiones().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");

                cantReg = unidGer.getRegiones().size();
                reg = unidGer.getRegiones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND zona.ZORG_OID_REGI IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getZonas() != null) &&
                    (unidGer.getZonas().size() != 0)) {
                query.append(" , ZON_SECCI secc ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");

                cantReg = unidGer.getZonas().size();
                reg = unidGer.getZonas();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getSecciones() != null) &&
                    (unidGer.getSecciones().size() != 0)) {
                cantReg = unidGer.getSecciones().size();
                reg = unidGer.getSecciones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                    UA.toString().substring(2) + " ) ");
            }

            query.append(" AND unida.perd_oid_peri_ini = p1.oid_peri(+)");
            query.append(" AND unida.perd_oid_peri_fin = p2.oid_peri(+)");
            query.append(
                " AND (p1.fec_inic IS NULL OR p1.fec_inic <= TO_DATE('" +
                strFechaDesde + "', 'yyyy-MM-dd'))");
            query.append(
                " AND (p2.fec_fina IS NULL OR p2.fec_fina >= TO_DATE('" +
                strFechaHasta + "', 'yyyy-MM-dd'))");
            query.append(" AND histo.clie_oid_clie = unida.clie_oid_clie");
            query.append(" AND histo.perd_oid_peri = p3.oid_peri(+)");
            query.append(" AND histo.perd_oid_peri_peri_fin = p4.oid_peri(+)");
            query.append(
                " AND (p3.fec_inic IS NULL OR p3.fec_inic <= TO_DATE('" +
                strFechaDesde + "', 'yyyy-MM-dd'))");
            query.append(
                " AND (p4.fec_fina IS NULL OR p4.fec_fina >= TO_DATE('" +
                strFechaHasta + "', 'yyyy-MM-dd'))");
            query.append(
                " AND unida.ztad_oid_terr_admi = terrAdmin.oid_terr_admi");

            query.append(" GROUP BY histo.esta_oid_esta_clie");

            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("*** rs: " + rs);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!rs.esVacio()) {
                for (int pos = 0; rs.existeFila(pos); pos++) {
                    
                    oidEstado = (BigDecimal) rs.getValueAt(pos,"OIDESTATUS");
                    
                    if(oidEstado!=null){
                        estadosCliente.put(Long.valueOf(rs.getValueAt(pos,
                                    "OIDESTATUS").toString()),
                            Integer.valueOf(rs.getValueAt(pos, "COUNT").toString()));
                            
                        //estadosCliente.put(oidEstado, count);
                    }
                }
            }
        }

        UtilidadesLog.debug(" Salio DAOCalculoVariablesVenta.recuperarIngresos"
            +"ReingresosEgresos ***");
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMetasGerenteCo"
            +"ncurso(GerenteVariablesVenta gerVarVta, Periodo periodoCierre)"
            +":Salida");

        return estadosCliente;
    }

    /**
     * rgiorgi - 24/08/2005: se corrige el filtradode UAs y el filtro de accesos
    * Fecha de Creacion: 13/06/2005
    * Autor: Damasia Maneiro
    * Descripcion: Calcula el número de pedidos facturados para un periodo
    * Modificado: Carlos Leal Inc 19641
    */
    public void recuperarNumeroPedidos(
        DTOResultadoConcursoVariablesVenta dtoRes,
        GerenteVariablesVenta gerVarVta, InfoGerentesConcursos infoGerConc)
        throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarNumeroPedidos("
            +"DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta"
            +"gerVarVta, InfoGerentesConcursos infoGerConc):Entrada");
        UtilidadesLog.debug("Entro DAOCalculoVariablesVenta.recuperarNumero"
            +"Pedidos *");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        StringBuffer UA = new StringBuffer();
        StringBuffer accesos = new StringBuffer();
        ArrayList reg = null;
        int corte = 1000;
        int cantReg = 0;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (gerVarVta.getUnidadesGerenciadas() != null) {
            UnidadesAdministrativasGerenciadas unidGer = 
                gerVarVta.getUnidadesGerenciadas();

            query.append(" SELECT COUNT(*)");
            query.append(" FROM PED_SOLIC_CABEC SCAB, SEG_SUBAC SUBA, ");
            query.append(" ZON_TERRI_ADMIN terrAdmin");

            if ((unidGer.getSubGerencias() != null) &&
                    (unidGer.getSubGerencias().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona, ");
                query.append(" ZON_REGIO reg ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");

                cantReg = unidGer.getSubGerencias().size();
                reg = unidGer.getSubGerencias();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getRegiones() != null) &&
                    (unidGer.getRegiones().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");

                cantReg = unidGer.getRegiones().size();
                reg = unidGer.getRegiones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND zona.ZORG_OID_REGI IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getZonas() != null) &&
                    (unidGer.getZonas().size() != 0)) {
                query.append(" , ZON_SECCI secc ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");

                cantReg = unidGer.getZonas().size();
                reg = unidGer.getZonas();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getSecciones() != null) &&
                    (unidGer.getSecciones().size() != 0)) {
                cantReg = unidGer.getSecciones().size();
                reg = unidGer.getSecciones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                    UA.toString().substring(2) + " ) ");
            }

            //Inc 19641
            // query.append(" AND SCAB.PERD_OID_PERI = " +
            //infoGerConc.getPeriodoCierre().getOidPeriodo());
            query.append(
                " AND SCAB.ZTAD_OID_TERR_ADMI = terrAdmin.OID_TERR_ADMI ");
            query.append(" AND SCAB.SBAC_OID_SBAC = SUBA.OID_SBAC");

            Long[] oidAccesos = infoGerConc.getConcurso(dtoRes.getOidConcurso())
                                           .getOidAccesos();

            if (oidAccesos != null) {
                cantReg = oidAccesos.length;

                for (int i = 0; i < cantReg; i++) {
                    accesos.append((", "));
                    accesos.append(infoGerConc.getConcurso(
                            dtoRes.getOidConcurso()).getOidAccesos()[i]);
                }

                query.append(" AND SUBA.ACCE_OID_ACCE IN (" +
                    accesos.toString().substring(2) + ") ");
            }

            query.append(" AND SCAB.IND_OC = 1 ");
            query.append(" AND scab.FEC_FACT IS NOT NULL ");
            query.append(" AND scab.PERD_OID_PERI = " + infoGerConc.getPeriodoCierre().getOidPeriodo());

            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("*** rs: " + rs);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!rs.esVacio()) {
                dtoRes.setNumeroPedidos(new Integer(
                        ((BigDecimal) rs.getValueAt(0, "COUNT")).intValue()));
            }
        }

        UtilidadesLog.debug(
            "*** Salio DAOCalculoVariablesVenta.recuperarNumeroPedidos ***");
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarNumeroPedidos("
            +"DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta "
            +"gerVarVta, InfoGerentesConcursos infoGerConc):Salida");
    }

    /**
        * rgiorgi - 24/08/2005: corrección del filtro de UAs
    * Fecha de Creacion: 13/06/2005
    * Autor: Damasia Maneiro
    * Descripcion:
    *
    */
    public Integer recuperarRecibidas(GerenteVariablesVenta gerVarVta,
        Periodo periodoCierre) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarRecibidas(Geren"
            +"teVariablesVenta gerVarVta, Periodo periodoCierre):Entrada");
        UtilidadesLog.debug("Entro DAOCalculoVariablesVenta.recuperarRecibidas");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        StringBuffer UA = new StringBuffer();
        ArrayList reg = null;
        int corte = 1000;
        int cantReg = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoCierre.getFechaDesde());
        String strFechaHasta = sdf.format(periodoCierre.getFechaHasta());

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT COUNT (1) COUNT ");
        query.append(" FROM (SELECT  COUNT(1) ");
        query.append(" FROM mae_clien_unida_admin unida, MAE_CLIEN_DATOS_ADICI adic, ");
        query.append(" zon_terri_admin terrAdmin ");

        if (gerVarVta.getUnidadesGerenciadas() != null) {
            UnidadesAdministrativasGerenciadas unidGer = 
                gerVarVta.getUnidadesGerenciadas();

            if ((unidGer.getSubGerencias() != null) &&
                    (unidGer.getSubGerencias().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona, ");
                query.append(" ZON_REGIO reg ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");

                cantReg = unidGer.getSubGerencias().size();
                reg = unidGer.getSubGerencias();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getRegiones() != null) &&
                    (unidGer.getRegiones().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");

                cantReg = unidGer.getRegiones().size();
                reg = unidGer.getRegiones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND zona.ZORG_OID_REGI IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getZonas() != null) &&
                    (unidGer.getZonas().size() != 0)) {
                query.append(" , ZON_SECCI secc ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");

                cantReg = unidGer.getZonas().size();
                reg = unidGer.getZonas();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getSecciones() != null) &&
                    (unidGer.getSecciones().size() != 0)) {
                cantReg = unidGer.getSecciones().size();
                reg = unidGer.getSecciones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                    UA.toString().substring(2) + " ) ");
            }

            query.append(" AND unida.perd_oid_peri_ini = " +
                periodoCierre.getOidPeriodo());
            query.append(" AND adic.clie_oid_clie = unida.clie_oid_clie");          
            query.append(
                " AND unida.ztad_oid_terr_admi = terrAdmin.oid_terr_admi");
            query.append(" AND adic.esta_oid_esta_clie <> " +
                ConstantesMAE.OID_ESTATUS_REGISTRADA);
            query.append(" AND adic.esta_oid_esta_clie <> " +
                ConstantesMAE.OID_ESTATUS_NUEVA);
                
            query.append(" GROUP BY unida.clie_oid_clie) ");  
                

            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("*** rs: " + rs);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!rs.esVacio()) {
                UtilidadesLog.debug(" Salio DAOCalculoVariablesVenta.recuperar"
                    +"Recibidas ***");
                UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarRecib"
                    +"idas(GerenteVariablesVenta gerVarVta, Periodo periodoCi"
                    +"erre):Salida");

                return new Integer(((BigDecimal) rs.getValueAt(0, "COUNT"))
                    .intValue());
            }
        }

        UtilidadesLog.debug(
            "*** Salio DAOCalculoVariablesVenta.recuperarRecibidas ***");
        UtilidadesLog.info(
            "DAOCalculoVariablesVenta.recuperarRecibidas(GerenteVariablesVenta"
                +"gerVarVta, Periodo periodoCierre):Salida");

        return null;
    }

    /**
        * rgiorgi - 24/08/2005: corrección del filtro de UAs
    * Fecha de Creacion: 14/06/2005
    * Autor: Damasia Maneiro
    * Descripcion:
    *
    */
    public Integer recuperarEntregadas(GerenteVariablesVenta gerVarVta,
        Periodo periodoAnterior) throws MareException {
        UtilidadesLog.info(
            "DAOCalculoVariablesVenta.recuperarEntregadas(GerenteVariablesVen"
                +"ta gerVarVta, Periodo periodoAnterior):Entrada");
        UtilidadesLog.debug(
            "*** Entro DAOCalculoVariablesVenta.recuperarEntregadas ***");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        StringBuffer UA = new StringBuffer();
        ArrayList reg = null;
        int corte = 1000;
        int cantReg = 0;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (gerVarVta.getUnidadesGerenciadas() != null) {
            UnidadesAdministrativasGerenciadas unidGer = 
                gerVarVta.getUnidadesGerenciadas();

            query.append(" SELECT COUNT (1) COUNT ");
            query.append(" FROM (SELECT  COUNT(1) ");
            query.append(" FROM mae_clien_unida_admin unida,");
            query.append(" zon_terri_admin terrAdmin ");

            if ((unidGer.getSubGerencias() != null) &&
                    (unidGer.getSubGerencias().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona, ");
                query.append(" ZON_REGIO reg ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");

                cantReg = unidGer.getSubGerencias().size();
                reg = unidGer.getSubGerencias();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getRegiones() != null) &&
                    (unidGer.getRegiones().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");

                cantReg = unidGer.getRegiones().size();
                reg = unidGer.getRegiones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND zona.ZORG_OID_REGI IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getZonas() != null) &&
                    (unidGer.getZonas().size() != 0)) {
                query.append(" , ZON_SECCI secc ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");

                cantReg = unidGer.getZonas().size();
                reg = unidGer.getZonas();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getSecciones() != null) &&
                    (unidGer.getSecciones().size() != 0)) {
                cantReg = unidGer.getSecciones().size();
                reg = unidGer.getSecciones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                    UA.toString().substring(2) + " ) ");
            }

            query.append(" AND unida.perd_oid_peri_fin = " +
                periodoAnterior.getOidPeriodo());
            query.append(
                " AND unida.ztad_oid_terr_admi = terrAdmin.oid_terr_admi");
                
            query.append(" GROUP BY unida.clie_oid_clie) ");  
              
            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("*** rs: " + rs);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!rs.esVacio()) {
                UtilidadesLog.debug(
                    "* Salio DAOCalculoVariablesVenta.recuperarEntregadas *");
                UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarEntregadas(GerenteVariablesVenta gerVarVta, Periodo periodoAnterior):Salida");

                return new Integer(((BigDecimal) rs.getValueAt(0, "COUNT")).intValue());
            }
        }

        UtilidadesLog.debug(
            "*** Salio DAOCalculoVariablesVenta.recuperarEntregadas ***");
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarEntregadas(Gere"
            +"nteVariablesVenta gerVarVta, Periodo periodoAnterior):Salida");

        return null;
    }

    /**
        * rgiorgi - 24/08/2005: corrección del filtro de UAs
    * Fecha de Creacion: 14/06/2005
    * Autor: Damasia Maneiro
    * Descripcion: recupera el total de monto y unidades acordes a los 
    * parametros recibidos.
    *
    */
    public DTOResultadoConcursoVariablesVenta recuperarMontoUnidadesSinExigencias(
        Long oidConcurso, InfoGerentesConcursos infoGerConc,
        GerenteVariablesVenta gerVarVta) throws MareException {
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMontoUnidadesS"
            +"inExigencias(Long oidConcurso, InfoGerentesConcursos infoGerConc"
            +"GerenteVariablesVenta gerVarVta):Entrada");
        UtilidadesLog.debug(" Entro DAOCalculoVariablesVenta.recuperarMontoUni"
            +"dadesSinExigencias ***");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        StringBuffer UA = new StringBuffer();
        ArrayList reg = null;
        int corte = 1000;
        int cantReg = 0;

        DTOResultadoConcursoVariablesVenta dtoResulConcuVarVta = 
            new DTOResultadoConcursoVariablesVenta();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (gerVarVta.getUnidadesGerenciadas() != null) {
            UnidadesAdministrativasGerenciadas unidGer = 
                gerVarVta.getUnidadesGerenciadas();

            query.append(" SELECT SCP.COPA_OID_PARA_GRAL, ");
            query.append(" SUM(SCP.IMP_MONT) AS totalMonto, ");
            query.append(" SUM(SCP.NUM_UNID) AS totalUnidades ");
            query.append(" FROM INC_SOLIC_CONCU_PUNTA SCP, ");
            query.append(" PED_SOLIC_CABEC SC, ZON_TERRI_ADMIN terrAdmin ");

            if ((unidGer.getSubGerencias() != null) &&
                    (unidGer.getSubGerencias().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona, ");
                query.append(" ZON_REGIO reg ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");
                query.append(" AND zona.ZORG_OID_REGI = reg.OID_REGI  ");

                cantReg = unidGer.getSubGerencias().size();
                reg = unidGer.getSubGerencias();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND reg.ZSGV_OID_SUBG_VENT IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getRegiones() != null) &&
                    (unidGer.getRegiones().size() != 0)) {
                query.append(" , ZON_SECCI secc, ");
                query.append(" ZON_ZONA zona ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");
                query.append(" AND secc.ZZON_OID_ZONA = zona.OID_ZONA  ");

                cantReg = unidGer.getRegiones().size();
                reg = unidGer.getRegiones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND zona.ZORG_OID_REGI IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getZonas() != null) &&
                    (unidGer.getZonas().size() != 0)) {
                query.append(" , ZON_SECCI secc ");

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC = secc.OID_SECC  ");

                cantReg = unidGer.getZonas().size();
                reg = unidGer.getZonas();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" AND secc.ZZON_OID_ZONA IN ( " +
                    UA.toString().substring(2) + " ) ");
            } else if ((unidGer.getSecciones() != null) &&
                    (unidGer.getSecciones().size() != 0)) {
                cantReg = unidGer.getSecciones().size();
                reg = unidGer.getSecciones();

                for (int i = 0; i < cantReg; i++) {
                    UA.append((", "));
                    UA.append(reg.get(i));
                }

                query.append(" WHERE terrAdmin.ZSCC_OID_SECC IN ( " +
                    UA.toString().substring(2) + " ) ");
            }

            query.append(" AND SCP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE");
            query.append(" AND SC.TERR_OID_TERR = terrAdmin.TERR_OID_TERR");
            query.append(" AND SCP.COPA_OID_PARA_GRAL = " + oidConcurso);
            query.append(" AND SCP.CLIE_OID_CLIE_GERE = " +
                gerVarVta.getOidGerente());
            query.append(" AND SCP.PERD_OID_PERI = " +
                infoGerConc.getPeriodoCierre().getOidPeriodo());
            query.append(" AND SC.FEC_FACT IS NOT NULL");
            query.append(" AND SC.IND_OC = 1");
            query.append(
                " GROUP BY SCP.COPA_OID_PARA_GRAL, SCP.CLIE_OID_CLIE_GERE, ");
            query.append(" SCP.PERD_OID_PERI");

            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
                UtilidadesLog.debug("*** rs: " + rs);
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (!rs.esVacio()) {
                dtoResulConcuVarVta.setOidConcurso(new Long(
                        ((BigDecimal) rs.getValueAt(0, "COPA_OID_PARA_GRAL"))
                            .longValue()));

                if (rs.getValueAt(0, "TOTALMONTO") != null) {
                    dtoResulConcuVarVta.setTotalVentaNetaEstadisticable(
                        (BigDecimal) rs.getValueAt(0, "TOTALMONTO"));
                }

                if (rs.getValueAt(0, "TOTALUNIDADES") != null) {
                    dtoResulConcuVarVta.setTotalUnidadesVendidas(new Long(
                            ((BigDecimal) rs.getValueAt(0, "TOTALUNIDADES"))
                            .longValue()));
                }

                UtilidadesLog.debug("DTO retornado: " + dtoResulConcuVarVta);
                UtilidadesLog.debug("Salio DAOCalculoVariablesVenta.recuperar"
                    +"MontoUnidadesSinExigencias ***");
                UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMontoUn"
                    +"idadesSinExigencias(Long oidConcurso, InfoGerentesConcu"
                    +"rsos infoGerConc GerenteVariablesVenta gerVarVta)"
                    +":Salida");

                return dtoResulConcuVarVta;
            }
        }

        UtilidadesLog.debug("*** retorna: NULL");
        UtilidadesLog.debug("Salio DAOCalculoVariablesVenta.recuperarMontoUni"
            +"dadesSinExigencias ***");
        UtilidadesLog.info("DAOCalculoVariablesVenta.recuperarMontoUnidadesS"
            +"inExigencias(Long oidConcurso, InfoGerentesConcursos infoGerConc"
            +"GerenteVariablesVenta gerVarVta):Salida");

        return null;
    }

    /**
    * @return void
    * @version 1.00 23/06/2005
    * @author: Carlos Leal
    * Descripcion: obtiene los resultados guardados para un cliente y un 
    * concurso.
    **/
    public void acumularResultadosGerenteConcurso(
        GerenteVariablesVenta gerVarVta, ConcursoVariablesVenta concurso,
        DTOResultadoConcursoVariablesVenta dtoResConc,
        InfoGerentesConcursos infoGerConc) throws MareException {
        
        UtilidadesLog.info("DAOCalculoVariablesVenta.acumularResultadosGeren"
            +"teConcurso(GerenteVariablesVenta gerVarVta, ConcursoVariables"
            +"Venta concurso, DTOResultadoConcursoVariablesVenta dtoResConc,"
            +"InfoGerentesConcursos infoGerConc):Entrada");
            
        UtilidadesLog.debug("Entro DAOCalculoVariablesVenta.acumularResulta"
            +"dosGerenteConcurso****");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(concurso.getPeriodoDesde()
                                                  .getFechaDesde());
        String strFechaHasta = sdf.format(concurso.getPeriodoDesde()
                                                  .getFechaHasta());

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //gerVarVta.unidadesGerenciadas.regiones != null 
        if (gerVarVta.getUnidadesGerenciadas().getRegiones() != null) {
            query.append(" SELECT SUM(RREGIO.NUM_ACTI_INIC) SNUM_ACTI_INIC, ");
            query.append(" SUM(RREGIO.NUM_ACTI_FINA) SNUM_ACTI_FINA,  ");
            query.append(" SUM(RREGIO.IMP_INGR) SIMP_INGR,  ");
            query.append(" SUM(RREGIO.IMP_REIN) SIMP_REIN,  ");
            query.append(" SUM(RREGIO.IMP_EGRE) SIMP_EGRE,  ");
            query.append(" SUM(RREGIO.NUM_ORDE) SNUM_ORDE,  ");
            query.append(" SUM(RREGIO.NUM_PEDI) SNUM_PEDI,  ");
            query.append(" SUM(RREGIO.NUM_UNID_VEND) SNUM_UNID_VEND,  ");
            query.append(" SUM(RREGIO.NUM_CLIE) SNUM_CLIE,  ");
            query.append(
                " SUM(RREGIO.IMP_VENT_NETA_ESTA) SIMP_VENT_NETA_ESTA,  ");
            query.append(" SUM(RREGIO.VAL_CAPI) SVAL_CAPI,  ");
            query.append(" SUM(RREGIO.VAL_ACTI) SVAL_ACTI,  ");
            query.append(
                " SUM(RREGIO.IMP_PREC_PROM_UNIT) SIMP_PREC_MEDI_UNIT,  ");
            query.append(
                " SUM(RREGIO.VAL_PROM_VENT_PEDI) SVAL_PROM_VENT_PEDI,  ");
            query.append(
                " SUM(RREGIO.VAL_PROM_UNID_PEDI) SVAL_PROM_UNID_PEDI,  ");
            query.append(
                " SUM(RREGIO.VAL_PROM_ORDE_PEDI) SVAL_PROM_ORDE_PEDI,  ");
            query.append(" SUM(RREGIO.VAL_RETE) SVAL_RETE, ");
            query.append(" SUM(RREGIO.NUM_ENTR) SNUM_ENTR,  ");
            query.append(" SUM(RREGIO.NUM_RECI) SNUM_RECI,  ");
            query.append(" SUM(RREGIO.VAL_ROTA) SVAL_ROTA ");

            query.append(" FROM INC_METAS_VENTA_PROYE_REGIO MREGIO, ");
            query.append(" INC_RESUL_VENTA_PROYE_REGION RREGIO, ");
            query.append(" CRA_PERIO CP ");
            query.append(" WHERE MREGIO.COPA_OID_PARA_GRAL = " +
                concurso.getOidConcurso());
            query.append(" AND MREGIO.CLIE_OID_CLIE = " +
                gerVarVta.getOidGerente());
            query.append(" AND MREGIO.OID_META_VENT_PROY_REGI =  ");
            query.append(" RREGIO.MVPR_OID_META_VENT_PROY_REGI ");
            query.append(" AND CP.OID_PERI = MREGIO.PERD_OID_PERI ");
            query.append(" AND TO_DATE('" + strFechaDesde +
                "', 'yyyy-MM-dd') <= CP.FEC_INIC ");
            query.append(" AND CP.FEC_FINA <= TO_DATE('" + strFechaHasta +
                "', 'yyyy-MM-dd')  ");

            //INC 19815 infoGerConc.periodoCierre.oidPeriodo
            query.append(" AND MREGIO.PERD_OID_PERI!= " +
                infoGerConc.getPeriodoCierre().getOidPeriodo());
            query.append(" GROUP BY MREGIO.CLIE_OID_CLIE ");
        }

        if (gerVarVta.getUnidadesGerenciadas().getSubGerencias() != null) {
            query.append(" SELECT ");
            query.append(" SUM(RSUBGE.NUM_ACTI_INIC) SNUM_ACTI_INIC, ");
            query.append(" SUM(RSUBGE.NUM_ACTI_FINA) SNUM_ACTI_FINA, ");
            query.append(" SUM(RSUBGE.IMP_INGR) SIMP_INGR, ");
            query.append(" SUM(RSUBGE.IMP_REIN) SIMP_REIN, ");
            query.append(" SUM(RSUBGE.IMP_EGRE) SIMP_EGRE, ");
            query.append(" SUM(RSUBGE.NUM_ORDE) SNUM_ORDE, ");
            query.append(" SUM(RSUBGE.NUM_PEDI) SNUM_PEDI, ");
            query.append(" SUM(RSUBGE.NUM_UNID_VEND) SNUM_UNID_VEND, ");
            query.append(" SUM(RSUBGE.NUM_CLIE) SNUM_CLIE, ");
            query.append(
                " SUM(RSUBGE.IMP_VENT_NETA_ESTA) SIMP_VENT_NETA_ESTA, ");
            query.append(" SUM(RSUBGE.VAL_CAPI) SVAL_CAPI, ");
            query.append(" SUM(RSUBGE.VAL_ACTI) SVAL_ACTI, ");
            query.append(
                " SUM(RSUBGE.IMP_PREC_PROM_UNIT) SIMP_PREC_MEDI_UNIT, ");
            query.append(
                " SUM(RSUBGE.VAL_PROM_VENT_PEDI) SVAL_PROM_VENT_PEDI, ");
            query.append(
                " SUM(RSUBGE.VAL_PROM_UNID_PEDI) SVAL_PROM_UNID_PEDI, ");
            query.append(
                " SUM(RSUBGE.VAL_PROM_ORDE_PEDI) SVAL_PROM_ORDE_PEDI, ");
            query.append(" SUM(RSUBGE.VAL_RETE) SVAL_RETE, ");
            query.append(" SUM(RSUBGE.NUM_ENTR) SNUM_ENTR, ");
            query.append(" SUM(RSUBGE.NUM_RECI) SNUM_RECI, ");
            query.append(" SUM(RSUBGE.VAL_ROTA) SVAL_ROTA");

            query.append(" FROM ");
            query.append(" INC_METAS_VENTA_PROYE_SUBGE MSUBGE,");
            query.append(" INC_RESUL_VENTA_PROYE_SUBGE RSUBGE,");
            query.append(" CRA_PERIO CP");
            query.append(" WHERE");
            query.append(" MSUBGE.COPA_OID_PARA_GRAL = " +
                concurso.getOidConcurso());
            query.append(" AND MSUBGE.CLIE_OID_CLIE = " +
                gerVarVta.getOidGerente());
            query.append(" AND MSUBGE.OID_META_VENT_PROY_SUBG = ");
            query.append(" RSUBGE.MVPS_OID_META_VENT_PROY_SUBG");
            query.append(" AND CP.OID_PERI = MSUBGE.PERD_OID_PERI");
            query.append(" AND TO_DATE('" + strFechaDesde +
                "', 'yyyy-MM-dd') <= CP.FEC_INIC");
            query.append(" AND CP.FEC_FINA <= TO_DATE('" + strFechaHasta +
                "', 'yyyy-MM-dd') ");

            //INC 19815
            query.append(" AND MSUBGE.PERD_OID_PERI!= " +
                infoGerConc.getPeriodoCierre().getOidPeriodo());

            query.append(" GROUP BY MSUBGE.CLIE_OID_CLIE ");
        }

        if (gerVarVta.getUnidadesGerenciadas().getZonas() != null) {
            query.append(" SELECT ");
            query.append(" SUM(RZONA.NUM_ACTI_INIC) SNUM_ACTI_INIC, ");
            query.append(" SUM(RZONA.NUM_ACTI_FINA) SNUM_ACTI_FINA,  ");
            query.append(" SUM(RZONA.IMP_INGR) SIMP_INGR,  ");
            query.append(" SUM(RZONA.IMP_REIN) SIMP_REIN,  ");
            query.append(" SUM(RZONA.IMP_EGRE) SIMP_EGRE,  ");
            query.append(" SUM(RZONA.NUM_ORDE) SNUM_ORDE,  ");
            query.append(" SUM(RZONA.NUM_PEDI) SNUM_PEDI,  ");
            query.append(" SUM(RZONA.NUM_UNID_VEND) SNUM_UNID_VEND, ");
            query.append(" SUM(RZONA.NUM_CLIE) SNUM_CLIE,  ");
            query.append(" SUM(RZONA.IMP_VENT_NETA_ESTA) SIMP_VENT_NETA_ESTA, ");
            query.append(" SUM(RZONA.VAL_CAPI) SVAL_CAPI,  ");
            query.append(" SUM(RZONA.VAL_ACTI) SVAL_ACTI,  ");
            query.append(" SUM(RZONA.IMP_PREC_MEDI_UNIT) SIMP_PREC_MEDI_UNIT, ");
            query.append(
                " SUM(RZONA.VAL_PROM_VENT_PEDI) SVAL_PROM_VENT_PEDI,  ");
            query.append(
                " SUM(RZONA.VAL_PROM_UNID_PEDI) SVAL_PROM_UNID_PEDI,  ");
            query.append(
                " SUM(RZONA.VAL_PROM_ORDE_PEDI) SVAL_PROM_ORDE_PEDI,  ");
            query.append(" SUM(RZONA.VAL_RETE) SVAL_RETE,  ");
            query.append(" SUM(RZONA.NUM_ENTR) SNUM_ENTR,  ");
            query.append(" SUM(RZONA.NUM_RECI) SNUM_RECI,  ");
            query.append(" SUM(RZONA.VAL_ROTA) SVAL_ROTA ");

            query.append(" FROM ");
            query.append(" INC_METAS_VENTA_PROYE_ZONA MZONA, ");
            query.append(" INC_RESUL_VENTA_PROYE_ZONA RZONA, ");
            query.append(" CRA_PERIO CP ");

            query.append(" WHERE ");
            query.append(" MZONA.COPA_OID_PARA_GRAL = " +
                concurso.getOidConcurso());
            query.append(" AND MZONA.CLIE_OID_CLIE = " +
                gerVarVta.getOidGerente());
            query.append(" AND MZONA.OID_META_VENT_PROY_ZONA = ");
            query.append(" RZONA.MVPZ_OID_META_VENT_PROY_ZONA ");
            query.append(" AND CP.OID_PERI = MZONA.PERD_OID_PERI ");
            query.append(" AND TO_DATE('" + strFechaDesde +
                "', 'yyyy-MM-dd') <= CP.FEC_INIC ");
            query.append(" AND CP.FEC_FINA <= TO_DATE('" + strFechaHasta +
                "', 'yyyy-MM-dd')  ");

            //INC 19815
            query.append(" AND MZONA.PERD_OID_PERI!= " +
                infoGerConc.getPeriodoCierre().getOidPeriodo());

            query.append(" GROUP BY MZONA.CLIE_OID_CLIE ");
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        if (!rs.esVacio()) {
            //gerVarVta.resultadosVariables.activasIniciales += resul.activasIniciales 
            int actIni = 
                gerVarVta.getResultadosVariables().getActivasIniciales()
                                  .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SNUM_ACTI_INIC") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SNUM_ACTI_INIC"))
                    .intValue() : 0);

            gerVarVta.getResultadosVariables().setActivasIniciales(new Integer(
                    actIni));

            //gerVarVta.resultadosVariables.ingresos += resul.ingresos 
            int ing = gerVarVta.getResultadosVariables().getIngresos()
                .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SIMP_INGR") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SIMP_INGR")).intValue() : 0);

            gerVarVta.getResultadosVariables().setIngresos(new Integer(ing));

            //gerVarVta.resultadosVariables.reingresos += resul.reingresos 
            int rein = gerVarVta.getResultadosVariables().getReingresos()
                                .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SIMP_REIN") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SIMP_REIN")).intValue() : 0);

            gerVarVta.getResultadosVariables().setReingresos(new Integer(rein));

            //gerVarVta.resultadosVariables.egresos += resul.egresos 
            int egre = gerVarVta.getResultadosVariables().getEgresos()
                .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SIMP_EGRE") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SIMP_EGRE")).intValue() : 0);

            gerVarVta.getResultadosVariables().setEgresos(new Integer(egre));

            //gerVarVta.resultadosVariables.entregadas += 
            //resul.numeroEntregadas 
            
            int ent = gerVarVta.getResultadosVariables().getEntregadas()
                               .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SNUM_ENTR") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SNUM_ENTR")).intValue() : 0);

            gerVarVta.getResultadosVariables().setEntregadas(new Integer(ent));

            //gerVarVta.resultadosVariables.recibidas += 
            //resul.numeroRecibidas 
            
            int rec = gerVarVta.getResultadosVariables().getRecibidas()
                               .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SNUM_RECI") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SNUM_RECI")).intValue() : 0);

            gerVarVta.getResultadosVariables().setRecibidas(new Integer(rec));

            //gerVarVta.resultadosVariables.activasFinales += 
            //resul.activasFinales 
            int acFina = gerVarVta.getResultadosVariables().getActivasFinales()
                                  .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SNUM_ACTI_FINA") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SNUM_ACTI_FINA")).intValue()
                : 0);

            gerVarVta.getResultadosVariables().setActivasFinales(new Integer(
                    acFina));

            //gerVarVta.resultadosVariables.capitalizacion +=
            //resul.capitalizacion 
            int capi = gerVarVta.getResultadosVariables().getCapitalizacion()
                                .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SVAL_CAPI") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SVAL_CAPI")).intValue() : 0);

            gerVarVta.getResultadosVariables().setCapitalizacion(new Integer(
                    capi));

            //gerVarVta.resultadosVariables.porcentajeRetencion += resul.retencion 
            double pret = gerVarVta.getResultadosVariables()
                                   .getPorcentajeRetencion().doubleValue() +
                (((BigDecimal) rs.getValueAt(0, "SVAL_RETE") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SVAL_RETE")).doubleValue() : 0);

            gerVarVta.getResultadosVariables().setPorcentajeRetencion(
                new Double(pret));

            //gerVarVta.resultadosVariables.numeroOrdenes += resul.numeroOrdenes 
            int nord = gerVarVta.getResultadosVariables().getNumeroOrdenes()
                                .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SNUM_ORDE") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SNUM_ORDE")).intValue() : 0);

            gerVarVta.getResultadosVariables().setNumeroOrdenes(new Integer(
                    nord));

            //gerVarVta.resultadosVariables.numeroClientes += 
            //resul.numeroClientes 
            int nclie = gerVarVta.getResultadosVariables().getNumeroClientes()
                                 .intValue() +
                (((BigDecimal) rs.getValueAt(0, "SNUM_CLIE") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SNUM_CLIE")).intValue() : 0);

            gerVarVta.getResultadosVariables().setNumeroClientes(new Integer(
                    nclie));

            //gerVarVta.resultadosVariables.rotacion += resul.rotacion 
            double rota = gerVarVta.getResultadosVariables().getRotacion()
                                   .doubleValue() +
                (((BigDecimal) rs.getValueAt(0, "SVAL_ROTA") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SVAL_ROTA")).doubleValue() 
                    : 0);

            gerVarVta.getResultadosVariables().setRotacion(
                new BigDecimal(rota));

            //dtoResConc.totalVentaNetaEstaditicable += 
            //resul.ventaNetaEstadisticable
            double vtanta = dtoResConc.getTotalVentaNetaEstadisticable()
                                      .doubleValue() +
                (((BigDecimal) rs.getValueAt(0, "SIMP_VENT_NETA_ESTA") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SIMP_VENT_NETA_ESTA"))
                    .doubleValue() : 0);

            dtoResConc.setTotalVentaNetaEstadisticable(new BigDecimal(vtanta));

            //dtoResConc.totalUnidadesVendidas += resul.unidadesVendidas 
            long uvend = dtoResConc.getTotalUnidadesVendidas().longValue() +
                (((BigDecimal) rs.getValueAt(0, "SNUM_UNID_VEND") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SNUM_UNID_VEND")).longValue()
                : 0);

            dtoResConc.setTotalUnidadesVendidas(new Long(uvend));

            //dtoResConc.precioPromedioUnitario += resul.precioPromedioUnitario 
            double ppromu = dtoResConc.getPrecioPromedioUnitario()
                .doubleValue() +
                (((BigDecimal) rs.getValueAt(0, "SIMP_PREC_MEDI_UNIT") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SIMP_PREC_MEDI_UNIT"))
                .doubleValue() : 0);

            dtoResConc.setPrecioPromedioUnitario(new BigDecimal(ppromu));

            //dtoResConc.numeroPedidos += resul.numeroPedidos 
            int nped = dtoResConc.getNumeroPedidos().intValue() +
                (((BigDecimal) rs.getValueAt(0, "SNUM_PEDI") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SNUM_PEDI")).intValue() : 0);

            dtoResConc.setNumeroPedidos(new Integer(nped));

            //dtoResConc.promedioVentaPedidos += resul.promedioVentaPedido 
            double promvtaped = dtoResConc.getPromedioVentaPedidos()
                                          .doubleValue() +
                (((BigDecimal) rs.getValueAt(0, "SVAL_PROM_VENT_PEDI") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SVAL_PROM_VENT_PEDI"))
                    .doubleValue() : 0);

            dtoResConc.setPromedioVentaPedidos(new BigDecimal(promvtaped));

            //dtoResConc.promedioUnidadesPedidos += 
            //resul.promedioUnidadesPedido 
            double promunidped = dtoResConc.getPromedioUnidadesPedidos()
                                           .doubleValue() +
                (((BigDecimal) rs.getValueAt(0, "SVAL_PROM_UNID_PEDI") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SVAL_PROM_UNID_PEDI"))
                .doubleValue() : 0);

            dtoResConc.setPromedioUnidadesPedidos(new Double(promunidped));

            //dtoResConc.porcentajeActividad += resul.actividad 
            double porcacti = dtoResConc.getPorcentajeActividad().doubleValue() +
                (((BigDecimal) rs.getValueAt(0, "SVAL_ACTI") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SVAL_ACTI"))
                    .doubleValue() : 0);

            dtoResConc.setPorcentajeActividad(new Double(porcacti));

            //dtoResConc.promedioOrdenesPedidos += resul.promedioOrdenesPedido 
            double promordpedi = dtoResConc.getPromedioOrdenesPedidos()
                                           .doubleValue() +
                (((BigDecimal) rs.getValueAt(0, "SVAL_PROM_ORDE_PEDI") != null)
                ? ((BigDecimal) rs.getValueAt(0, "SVAL_PROM_ORDE_PEDI"))
                .doubleValue() : 0);

            dtoResConc.setPromedioOrdenesPedidos(new Double(promordpedi));
        }

        UtilidadesLog.debug("Salio DAOCalculoVariablesVenta.acumularResultados"
            +"GerenteConcurso****");
        UtilidadesLog.info("DAOCalculoVariablesVenta.acumularResultadosGerente"
            +"Concurso(GerenteVariablesVenta gerVarVta, ConcursoVariablesVenta"
            +"concurso, DTOResultadoConcursoVariablesVenta dtoResConc, "
            +"InfoGerentesConcursos infoGerConc):Salida");
    }
}