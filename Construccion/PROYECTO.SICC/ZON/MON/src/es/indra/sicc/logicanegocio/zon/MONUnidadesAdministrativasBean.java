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
 */
package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.entidades.zon.HistoricoGerentesLideresLocal;
import es.indra.sicc.entidades.zon.HistoricoGerentesLideresLocalHome;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.zon.DTOBuscaZonaEstIni;
import es.indra.sicc.dtos.zon.DTOBuscarUA;
import es.indra.sicc.dtos.zon.DTOEstadoZona;
import es.indra.sicc.dtos.zon.DTOHistoricoZona;
import es.indra.sicc.dtos.zon.DTOLISTUniNSE;
import es.indra.sicc.dtos.zon.DTOPantallaAsignarEstado;
import es.indra.sicc.dtos.zon.DTOPedidosZona;
import es.indra.sicc.dtos.zon.DTOResponsable;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.zon.DTOZona;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.zon.EstadoZonaLocal;
import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.SeccionLocal;
import es.indra.sicc.entidades.zon.SeccionLocalHome;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocal;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.logicanegocio.zon.DAOUnidadesAdministrativas;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.ped.DAOEstadisticasPED;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.DTOColeccion;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.math.BigDecimal;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.zon.DTOUnidadesAdministrativas;

import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.fac.TiposCierreLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocalHome;
import es.indra.sicc.logicanegocio.zon.DAOZON;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.entidades.zon.EstadoZonaLocalHome;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDireccionLocalHome;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocalHome;
import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocalHome;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.zon.HistoricoZonasLocalHome;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocalHome;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
import java.util.StringTokenizer;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONUnidadesAdministrativasBean implements SessionBean, IServiceUnidadesAdministrativas {
    private SessionContext ctx;
    private BelcorpService bs;
    public static String RESPONSABLE_NO_CUMPLE_CAMPAÑAS_PARA_REINGRESO = "0605";

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void ejbCreate() throws CreateException {
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException mmsnfe) {
            throw new CreateException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage());
        }
    }

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public Integer consultaZonasAsignadas(Long gerente) throws MareException {
    
        UtilidadesLog.info("MONUnidadesAdministrativasBean.consultaZonasAsignadas(Long gerente): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        if(gerente == null) {
            codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            buf.append("select count(*) cantidad from ZON_ZONA ");
            buf.append(" where CLIE_OID_CLIE = " + gerente);

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.consultaZonasAsignadas(Long gerente): Salida");
        return new Integer(((BigDecimal)respuesta.getValueAt(0, "cantidad")).intValue());
    }

    public DTOUnidadAdministrativa generaUATerritorio(Long pais, Long marca, Long canal, Long territorio, Long zona)
        throws MareException {
        DAOZON daoZon = new DAOZON();
        return daoZon.obtenerUnidadAdministrativa(marca, pais, canal, territorio, zona);
    }

    public void calcularNSE(DTOUnidadAdministrativa dtoe) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.calcularNSE(DTOUnidadAdministrativa dtoe): Entrada");
        
        DTOLISTUniNSE uni;
        Long seccion;
        Long zona;
        Long region;
        Long sgv;
        CAuxCalculoModas calculaModas = new CAuxCalculoModas();
        String[] nses;
        DAOZON daoZon = new DAOZON();

        SeccionLocalHome sLocalHome = this.getSeccionLocalHome();
        ZonaLocalHome zLocalHome = this.getZonaLocalHome();
        RegionLocalHome rLocalHome = this.getRegionLocalHome();
        SubGerenciaVentaLocalHome sgvLocalHome = this.getSubGerenciaVentaLocalHome();

        SeccionLocal sLocal;
        ZonaLocal zLocal;
        RegionLocal rLocal;
        SubGerenciaVentaLocal sgvLocal;

        DTOUnidadAdministrativa unidadAdm = this.generaUATerritorio(dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal(),
                dtoe.getOidTerritorio(), dtoe.getOidZona());
        ArrayList secciones = daoZon.obtenerSeccionesdeTerritorio(unidadAdm.getOidTerritorio());
        Iterator secc = secciones.iterator();

        while(secc.hasNext()) {
            seccion = (Long)secc.next();
            uni = daoZon.obtenerUAinferioresUA(seccion, new Integer(4));
            nses = new String[3];
            sLocal = this.findSeccion(sLocalHome, seccion);

            if(uni.getArrayDTOUniNSE() != null) {
                calculaModas.calcularModaNSE(uni, nses);
                sLocal.setCodNse1(nses[0]);
                sLocal.setCodNse2(nses[1]);
                sLocal.setCodNse3(nses[2]);
                sLocalHome.merge(sLocal);
            }

            zona = sLocal.getOidZona();
            zLocal = this.findZona(zLocalHome, zona);
            uni = daoZon.obtenerUAinferioresUA(zona, new Integer(3));
            nses = new String[3];

            if(uni.getArrayDTOUniNSE() != null) {
                calculaModas.calcularModaNSE(uni, nses);
                zLocal.setNse1(nses[0]);
                zLocal.setNse2(nses[1]);
                zLocal.setNse3(nses[2]);
                zLocalHome.merge(zLocal);
            }

            region = zLocal.getOidRegion();
            rLocal = this.findRegion(rLocalHome, region);
            uni = daoZon.obtenerUAinferioresUA(region, new Integer(2));
            nses = new String[3];

            if(uni.getArrayDTOUniNSE() != null) {
                calculaModas.calcularModaNSE(uni, nses);
                rLocal.setCodNse1(nses[0]);
                rLocal.setCodNse2(nses[1]);
                rLocal.setCodNse3(nses[2]);
                rLocalHome.merge(rLocal);
            }

            sgv = rLocal.getSgvOidSubgVenta();
            sgvLocal = this.findSgv(sgvLocalHome, sgv);
            uni = daoZon.obtenerUAinferioresUA(sgv, new Integer(1));
            nses = new String[3];

            if(uni.getArrayDTOUniNSE() != null) {
                calculaModas.calcularModaNSE(uni, nses);
                sgvLocal.setCodNse1(nses[0]);
                sgvLocal.setCodNse2(nses[1]);
                sgvLocal.setCodNse3(nses[2]);
                sgvLocalHome.merge(sgvLocal);
            }
        }
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.calcularNSE(DTOUnidadAdministrativa dtoe)): Salida");
    }

    public RecordSet obtenerSubgerenciaVentas(DTOUnidadAdministrativa dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSubgerenciaVentas(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select OID_SUBG_VENT, COD_NSE1, COD_NSE2, COD_NSE3, DES_SUBG_VENT, CANA_OID_CANA,                 MARC_OID_MARC, PAIS_OID_PAIS, COD_SUBG_VENT ");
            buf.append(" from VCA_ZON_SUB_GEREN_VENTA ");

            String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"CANA_OID_CANA", "MARC_OID_MARC", "PAIS_OID_PAIS"},
                    new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()}, new boolean[] {false, false, false});

            if(sqlWhere == "")
                buf.append(" WHERE ");
            else {
                buf.append(sqlWhere);
                buf.append(" AND ");
            }

            buf.append(" ind_acti = 1 ");
            buf.append(" and ind_borr = 0 ");
            buf.append(" AND COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY DES_SUBG_VENT ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSubgerenciaVentas(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }

    public RecordSet obtenerRegiones(DTOUnidadAdministrativa dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegiones(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select R.OID_REGI, R.ZSGV_OID_SUBG_VENT, R.COD_NSE1, R.COD_NSE2, R.COD_NSE3, R.DES_REGI, R.COD_REGI from VCA_ZON_REGIO R");

            if(dtoe.getOidSGV() != null) {
                buf.append(" where R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_SUB_GEREN_VENTA SGV ");
                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and sgv.ind_acti = 1 ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
            }
            buf.append(" AND R.COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY R.DES_REGI ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegiones(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }


    public RecordSet obtenerRegionesNoBorradas(DTOUnidadAdministrativa arg) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegionesNoBorradas(DTOUnidadAdministrativa arg): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select R.OID_REGI, R.ZSGV_OID_SUBG_VENT, R.COD_NSE1, R.COD_NSE2, R.COD_NSE3, R.DES_REGI, R.COD_REGI from VCA_ZON_REGIO R");

            if(arg.getOidSGV() != null) {
                buf.append(" where R.ZSGV_OID_SUBG_VENT = " + arg.getOidSGV());
                buf.append(" and r.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_SUB_GEREN_VENTA SGV ");
                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {arg.getOidCanal(), arg.getOidMarca(), arg.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_borr = 0 ");
            }
            buf.append(" AND R.COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY R.DES_REGI ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegionesNoBorradas(DTOUnidadAdministrativa arg): Salida");
        return respuesta;
    }

    public RecordSet obtenerZonas(DTOUnidadAdministrativa dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerZonas(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select Z.OID_ZONA, Z.ZORG_OID_REGI, Z.COD_NSE1, Z.COD_NSE2, Z.COD_NSE3, Z.DES_ZONA, Z.COD_ZONA from VCA_ZON_ZONA Z ");

            if(dtoe.getOidRegion() != null) {
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R");
                buf.append(" where R.OID_REGI = Z.ZORG_OID_REGI and");
                buf.append(" R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_SUB_GEREN_VENTA SGV  ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and sgv.ind_acti = 1 ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
            }
            buf.append(" AND Z.COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY Z.DES_ZONA ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerZonas(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }

    public RecordSet obtenerZonasNoBorradas(DTOUnidadAdministrativa arg) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerZonasNoBorradas(DTOUnidadAdministrativa arg): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select Z.OID_ZONA, Z.ZORG_OID_REGI, Z.COD_NSE1, Z.COD_NSE2, Z.COD_NSE3, Z.DES_ZONA, Z.COD_ZONA from VCA_ZON_ZONA Z ");

            if(arg.getOidRegion() != null) {
                buf.append(" where Z.ZORG_OID_REGI = " + arg.getOidRegion());
                buf.append(" and z.ind_borr = 0 ");
            } else if(arg.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R");
                buf.append(" where R.OID_REGI = Z.ZORG_OID_REGI and");
                buf.append(" R.ZSGV_OID_SUBG_VENT = " + arg.getOidSGV());
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_SUB_GEREN_VENTA SGV  ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {arg.getOidCanal(), arg.getOidMarca(), arg.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_borr = 0 ");
            }
            buf.append(" AND Z.COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY Z.DES_ZONA ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerZonasNoBorradas(DTOUnidadAdministrativa arg): Salida");
        return respuesta;
    }



    public RecordSet obtenerSecciones(DTOUnidadAdministrativa dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSecciones(DTOUnidadAdministrativa dtoe)): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select S.OID_SECC, S.ZZON_OID_ZONA, S.COD_NSE1, S.COD_NSE2, S.COD_NSE3, S.DES_SECCI, S.COD_SECC from VCA_ZON_SECCI S ");

            if(dtoe.getOidZona() != null) {
                buf.append(" where S.ZZON_OID_ZONA = " + dtoe.getOidZona());
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
            } else if(dtoe.getOidRegion() != null) {
                buf.append(" ,ZON_ZONA Z");
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z");
                buf.append(" where S.ZZON_OID_ZONA = Z.OID_ZONA and");
                buf.append(" R.OID_REGI = Z.ZORG_OID_REGI and");
                buf.append(" R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SUB_GEREN_VENTA SGV  ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and sgv.ind_acti = 1 ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
            }

            buf.append(" AND S.COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY S.DES_SECCI ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSecciones(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }

    public RecordSet obtenerTerritorios(DTOUnidadAdministrativa dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritorios(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select T.OID_TERR, TA.ZSCC_OID_SECC, T.COD_NSE1, T.COD_NSE2, T.COD_NSE3, T.COD_TERR from VCA_ZON_TERRI T, ZON_TERRI_ADMIN TA ");

            if(dtoe.getOidSeccion() != null) {
                buf.append(" where T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append("and TA.ZSCC_OID_SECC = " + dtoe.getOidSeccion());
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidZona() != null) {
                buf.append(" ,ZON_SECCI S ");
                buf.append(" where S.ZZON_OID_ZONA = " + dtoe.getOidZona());
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidRegion() != null) {
                buf.append(" ,ZON_ZONA Z, ZON_SECCI S");
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SECCI S");
                buf.append(" where S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SUB_GEREN_VENTA SGV, ZON_SECCI S ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and sgv.ind_acti = 1 ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            }

            buf.append(" AND T.COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY T.COD_TERR ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

       UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritorios(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }


    public void actualizarUnidadesAdmMAE(Long marca, Long pais, Long canal, Long territorio, Long cliente, DTOAuditableSICC dto, Long indDirePrincipal)
        throws MareException, RemoteException {
        
    UtilidadesLog.info("MONUnidadesAdministrativasBean.actualizarUnidadesAdmMAE(Long marca, Long pais, Long canal, Long territorio, Long cliente, DTOAuditableSICC dto): Entrada");

		try{
		
			MONClientes monClientes = MAEEjbLocators.getMONClientesHome().create();
			monClientes.actualizarUnidadesAdmMAE( marca, pais, canal, territorio, cliente, dto, indDirePrincipal);
			
		} catch(CreateException ce) { throw new MareException(ce); }
    
    UtilidadesLog.info("MONUnidadesAdministrativasBean.actualizarUnidadesAdmMAE(Long marca, Long pais, Long canal, Long territorio, Long cliente, DTOAuditableSICC dto): Salida");

	}

    public void evaluarZona(Long zona, Long tipoZona, Long periodo, Long tipoPeriodo)
        throws MareException {}

    public RecordSet obtenerTerritoriosAdministrativos(DTOUnidadAdministrativa dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritoriosAdministrativos(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            buf.append("select TA.OID_TERR_ADMI, TA.ZSCC_OID_SECC, TA.TERR_OID_TERR from ZON_TERRI_ADMIN TA ");

            if(dtoe.getOidSeccion() != null) {
                buf.append(" where TA.ZSCC_OID_SECC = " + dtoe.getOidSeccion());
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidZona() != null) {
                buf.append(" ,ZON_SECCI S ");
                buf.append(" where S.ZZON_OID_ZONA = " + dtoe.getOidZona());
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidRegion() != null) {
                buf.append(" ,ZON_ZONA Z, ZON_SECCI S");
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SECCI S");
                buf.append(" where S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SUB_GEREN_VENTA SGV, ZON_SECCI S ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and sgv.ind_acti = 1 ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            }

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritoriosAdministrativos(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }

    public Long obtenerGerenteUniAdm(DTOUnidadAdministrativa dto)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerGerenteUniAdm(DTOUnidadAdministrativa dto): Entrada");
        
        Long gerente = null;

        if(!verificarDTO(dto)) {
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.UNIDAD_ADMINISTRATIVA_INCORRECTA));
        } else
         if(dto.getOidSGV() != null) {
            SubGerenciaVentaLocalHome localHome = this.getSubGerenciaVentaLocalHome();
            SubGerenciaVentaLocal local = findSgv(localHome, dto.getOidSGV());
            gerente = local.getOidCliente();
        } else if(dto.getOidRegion() != null) {
            RegionLocalHome localHome = this.getRegionLocalHome();
            RegionLocal local = findRegion(localHome, dto.getOidRegion());
            gerente = local.getOidCliente();
        } else if(dto.getOidZona() != null) {
            ZonaLocalHome localHome = this.getZonaLocalHome();
            ZonaLocal local = findZona(localHome, dto.getOidZona());
            gerente = local.getCliente();
        } else if(dto.getOidSeccion() != null) {
            SeccionLocalHome localHome = this.getSeccionLocalHome();
            SeccionLocal local = findSeccion(localHome, dto.getOidSeccion());
            gerente = local.getClienteOid();
        }

        if(gerente != null){
            UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerGerenteUniAdm(DTOUnidadAdministrativa dto): Salida");
            return gerente;
        } else {
            UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerGerenteUniAdm(DTOUnidadAdministrativa dto): Salida");
            throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.UNIDAD_ADMINISTRATVA_SIN_GERENTE));
        }
    }

    private boolean verificarDTO(DTOUnidadAdministrativa dto)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.verificarDTO(DTOUnidadAdministrativa dto): Entrada");
        
        Long sgv = dto.getOidSGV();
        Long reg = dto.getOidRegion();
        Long zon = dto.getOidZona();
        Long sec = dto.getOidSeccion();

        return (sgv == null) ^ (reg == null) ^ (zon == null) ^ (sec == null);
    }

    private SeccionLocal findSeccion(SeccionLocalHome localHome, Long pk)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.findSeccion(SeccionLocalHome localHome, Long pk): Entrada");
        
        String codigoError;
        SeccionLocal local;

        try {
            local = localHome.findByPrimaryKey(pk);
        } catch(NoResultException e) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONUnidadesAdministrativasBean.findSeccion(SeccionLocalHome localHome, Long pk): Salida");
        return local;
    }

    private ZonaLocal findZona(ZonaLocalHome localHome, Long pk)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.findZona(ZonaLocalHome localHome, Long pk): Entrada");
        
        String codigoError;
        ZonaLocal local;

        try {
            local = localHome.findByPrimaryKey(pk);
        } catch(NoResultException e) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONUnidadesAdministrativasBean.findZona(ZonaLocalHome localHome, Long pk): Salida");
        return local;
    }

    private RegionLocal findRegion(RegionLocalHome localHome, Long pk)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.findRegion(RegionLocalHome localHome, Long pk): Entrada");
        
        String codigoError;
        RegionLocal local;

        try {
            local = localHome.findByPrimaryKey(pk);
        } catch(NoResultException e) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONUnidadesAdministrativasBean.findRegion(RegionLocalHome localHome, Long pk): Salida");
        return local;
    }

    private SubGerenciaVentaLocal findSgv(SubGerenciaVentaLocalHome localHome, Long pk)
        throws MareException {
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.findSgv(SubGerenciaVentaLocalHome localHome, Long pk): Entrada");
        
        String codigoError;
        SubGerenciaVentaLocal local;

        try {
            local = localHome.findByPrimaryKey(pk);
        } catch(NoResultException e) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONUnidadesAdministrativasBean.findSgv(SubGerenciaVentaLocalHome localHome, Long pk): Salida");
        return local;
    }

    public void asignarEstadoZona(DTOColeccion dtoCol) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.asignarEstadoZona(DTOColeccion dtoCol): Entrada");
        
        ArrayList al = dtoCol.getLista();
        for (int i = 0; i < al.size(); i++) {
            asignarEstaZona((DTOEstadoZona) al.get(i));
        }
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.asignarEstadoZona(DTOColeccion dtoCol): Salida");
    }

    private void asignarEstaZona(DTOEstadoZona dtoEZ) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.asignarEstaZona(DTOEstadoZona dtoEZ): Entrada");
        
        String codigoError;
        ZonaLocalHome zonaLH = null;
        ZonaLocal zonaLocal = null;

        if(dtoEZ == null) {
            UtilidadesLog.info("MONUnidadesAdministrativasBean.asignarEstaZona(DTOEstadoZona dtoEZ): Salida");
            codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            zonaLH = this.getZonaLocalHome();
            zonaLocal = findZona(zonaLH, dtoEZ.getOidZona());
        } catch(MareException mex) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(mex, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            zonaLocal.setOidEstadoZona(dtoEZ.getEstadoZona());
            zonaLocal.setFechaCambioEstado(new Timestamp(System.currentTimeMillis()));            
            zonaLH.merge(zonaLocal);
        } catch(Exception ex) {
            codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.asignarEstaZona(DTOEstadoZona dtoEZ): Salida");
    }

    public DTOSalida buscarZonasEstadoIni(DTOBuscaZonaEstIni arg) throws MareException
    {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.buscarZonasEstadoIni(DTOBuscaZonaEstIni arg): Entrada");
        
        DTOSalida dtos =  new DTOSalida();
        String user = ctx.getCallerPrincipal().getName();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" zz.oid_zona oid, ");
        query.append(" m.DES_MARC, ");
        query.append(" ICanal.val_i18n, ");
        query.append(" zr.des_regi, ");
        query.append(" zz.cod_zona, ");
        query.append(" zz.eszo_oid_esta_zona ");
        query.append(" FROM zon_sub_geren_venta zsgv, zon_regio zr, vca_zon_zona zz, SEG_MARCA m, V_GEN_I18N_SICC ICanal ");
        query.append(" WHERE zsgv.oid_subg_vent = zr.zsgv_oid_subg_vent ");
        query.append(" AND zr.oid_regi = zz.zorg_oid_regi ");
        query.append(" AND zsgv.marc_oid_marc = m.oid_marc ");
        query.append(" AND zsgv.marc_oid_marc = " + arg.getOidMarca() + " ");
        query.append(" AND zsgv.PAIS_OID_PAIS = " + arg.getOidPais() + " ");
        query.append(" AND ICanal.ATTR_ENTI = 'SEG_CANAL' ");
        query.append(" AND ICanal.IDIO_OID_IDIO = " + arg.getOidIdioma() + " ");
        query.append(" AND ICanal.VAL_OID = zsgv.cana_oid_cana ");
        query.append(" AND ICanal.ATTR_NUM_ATRI = 1 ");
        query.append(" AND zz.COD_USUA = '"+user+"' ");
        if (arg.getOidCanal() != null)
            query.append(" AND zsgv.cana_oid_cana = " + arg.getOidCanal() +" ");
        if (arg.getOidRegion() != null)
            query.append(" AND zr.oid_regi = " + arg.getOidRegion() +" ");
        if (arg.getOidZona() != null)
            query.append(" AND zz.oid_zona = " + arg.getOidZona() +" ");

        query.append(" and zsgv.ind_borr = 0 ");
        query.append(" and zr.ind_borr = 0 ");
        query.append(" and zz.ind_borr = 0 ");
        query.append(" and zz.ESZO_OID_ESTA_ZONA IS NULL ");

        query.append(" UNION ");

        query.append(" SELECT ");
        query.append(" zz.oid_zona oid, ");
        query.append(" m.DES_MARC, ");
        query.append(" ICanal.val_i18n, ");
        query.append(" zr.des_regi, ");
        query.append(" zz.cod_zona, ");
        query.append(" zz.eszo_oid_esta_zona ");
        query.append(" FROM zon_sub_geren_venta zsgv, zon_regio zr, vca_zon_zona zz, SEG_MARCA m, V_GEN_I18N_SICC ICanal, ZON_ESTAD_ZONA est ");
        query.append(" WHERE zsgv.oid_subg_vent = zr.zsgv_oid_subg_vent ");
        query.append(" AND zr.oid_regi = zz.zorg_oid_regi ");
        query.append(" AND zsgv.marc_oid_marc = m.oid_marc ");
        query.append(" AND zsgv.marc_oid_marc = " + arg.getOidMarca() + " ");
        query.append(" AND zsgv.PAIS_OID_PAIS = " + arg.getOidPais() + " ");
        query.append(" AND ICanal.ATTR_ENTI = 'SEG_CANAL' ");
        query.append(" AND ICanal.IDIO_OID_IDIO = " + arg.getOidIdioma() + " ");
        query.append(" AND ICanal.VAL_OID = zsgv.cana_oid_cana ");
        query.append(" AND ICanal.ATTR_NUM_ATRI = 1 ");
        query.append(" AND zz.COD_USUA = '"+user+"' ");
        if (arg.getOidCanal() != null)
            query.append(" AND zsgv.cana_oid_cana = " + arg.getOidCanal() +" ");
        if (arg.getOidRegion() != null)
            query.append(" AND zr.oid_regi = " + arg.getOidRegion() +" ");
        if (arg.getOidZona() != null)
            query.append(" AND zz.oid_zona = " + arg.getOidZona() +" ");

        query.append(" and zsgv.ind_borr = 0 ");
        query.append(" and zr.ind_borr = 0 ");
        query.append(" and zz.ind_borr = 0 ");
        query.append(" and zz.ESZO_OID_ESTA_ZONA = est.OID_ESTA_ZONA ");
        query.append(" and est.IND_INIC = 1 ");
        
        query.append(" ORDER BY 1 ");

        String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), arg);

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(queryStr);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs==null || rs.esVacio()) {
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    
        }

        dtos.setResultado(rs);
        UtilidadesLog.info("MONUnidadesAdministrativasBean.buscarZonasEstadoIni(DTOBuscaZonaEstIni arg): Salida");
        return dtos;
    }

  public DTOSalida buscarEstadosZona(DTOBuscaZonaEstIni arg) throws MareException
  {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.buscarEstadosZona(DTOBuscaZonaEstIni arg): Entrada");
        
        DTOSalida dtos =  new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" IEsta.VAL_OID,  ");
        query.append(" IEsta.VAL_I18N ");
        query.append(" FROM ZON_ESTAD_ZONA E, V_GEN_I18N_SICC IEsta ");
        query.append(" WHERE IEsta.ATTR_ENTI = 'ZON_ESTAD_ZONA' ");
        query.append(" AND IEsta.IDIO_OID_IDIO = " + arg.getOidIdioma() + " ");
        query.append(" AND IEsta.VAL_OID = E.OID_ESTA_ZONA  ");
        query.append(" AND IEsta.ATTR_NUM_ATRI = 1 ");
        query.append(" AND E.PAIS_OID_PAIS  = " + arg.getOidPais() + " ");
        query.append(" AND E.MARC_OID_MARC  = " + arg.getOidMarca() + " ");
        query.append(" ORDER BY IEsta.VAL_I18N ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);

        UtilidadesLog.info("MONUnidadesAdministrativasBean.buscarEstadosZona(DTOBuscaZonaEstIni arg): Salida");
        return dtos;
  }

  public Long obtenerTerritorioAdministrativo(Long oidmarca, Long oidcliente) throws MareException {
        DAOZON daoZon = new DAOZON();
        return daoZon.obtenerTerritorioAdministrativo(oidmarca, oidcliente);
 }

  public DTOSalida recargaRegiones(DTOUnidadAdministrativa dtoe) throws MareException {
      UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaRegiones(DTOUnidadAdministrativa dtoe): Entrada");
      
      DTOSalida dtoS= new DTOSalida();
      String codigoError;
      RecordSet respuesta;
      StringBuffer buf = new StringBuffer();
      String user = ctx.getCallerPrincipal().getName();

      try {
          buf.append(
              "select R.OID_REGI, R.DES_REGI from VCA_ZON_REGIO R");

          if(dtoe.getOidSGV() != null) {
              buf.append(" where R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
              buf.append(" and r.ind_acti = 1 ");
              buf.append(" and r.ind_borr = 0 ");
          } else {
              buf.append(" ,ZON_SUB_GEREN_VENTA SGV ");
              String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                      new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                      new boolean[] {false, false, false, false});

              if(sqlWhere == "")
                  buf.append(" WHERE ");
              else {
                  buf.append(sqlWhere);
                  buf.append(" AND ");
              }

              buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
              buf.append(" and sgv.ind_acti = 1 ");
              buf.append(" and sgv.ind_borr = 0 ");
              buf.append(" and r.ind_acti = 1 ");
              buf.append(" and r.ind_borr = 0 ");
          }
          buf.append(" AND R.COD_USUA = '"+user+"' ");
          buf.append(" ORDER BY R.DES_REGI ");
            
          UtilidadesLog.info("\n ######### LA QUERY ES:\n" + buf.toString());
          
          respuesta = bs.dbService.executeStaticQuery(buf.toString());
      } catch(Exception e) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaRegiones(DTOUnidadAdministrativa dtoe): Salida");
        return new DTOSalida(respuesta);
	}

    public RecordSet obtenerSubgerenciaVentasSinFiltro(DTOUnidadAdministrativa dtoe) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSubgerenciaVentasSinFiltro(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            buf.append(
                "select OID_SUBG_VENT, COD_NSE1, COD_NSE2, COD_NSE3, DES_SUBG_VENT, CANA_OID_CANA, MARC_OID_MARC, PAIS_OID_PAIS, COD_SUBG_VENT ");
            buf.append(" from ZON_SUB_GEREN_VENTA ");

            String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"CANA_OID_CANA", "MARC_OID_MARC", "PAIS_OID_PAIS"},
                    new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()}, new boolean[] {false, false, false});

            if(sqlWhere == "")
                buf.append(" WHERE ");
            else {
                buf.append(sqlWhere);
                buf.append(" AND ");
            }

            buf.append(" ind_borr = 0 ");
            buf.append(" ORDER BY DES_SUBG_VENT ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSubgerenciaVentasSinFiltro(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }

    public RecordSet obtenerRegionesSinFiltro(DTOUnidadAdministrativa dtoe) throws MareException {
    
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegionesSinFiltro(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();        

        try {
            buf.append(
                "select R.OID_REGI, R.ZSGV_OID_SUBG_VENT, R.COD_NSE1, R.COD_NSE2, R.COD_NSE3, R.DES_REGI, R.COD_REGI from ZON_REGIO R");

            if(dtoe.getOidSGV() != null) {
                buf.append(" where R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_SUB_GEREN_VENTA SGV ");
                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_borr = 0 ");
            }
           
            buf.append(" ORDER BY R.DES_REGI ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegionesSinFiltro(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;

    }

    public RecordSet obtenerZonasSinFiltro(DTOUnidadAdministrativa dtoe) throws MareException {
    
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerZonasSinFiltro(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        
        try {
            buf.append(
                "select Z.OID_ZONA, Z.DES_ZONA, Z.COD_ZONA, Z.ZORG_OID_REGI, Z.COD_NSE1, Z.COD_NSE2, Z.COD_NSE3 from ZON_ZONA Z ");

            if(dtoe.getOidRegion() != null) {
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and z.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R");
                buf.append(" where R.OID_REGI = Z.ZORG_OID_REGI and");
                buf.append(" R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_SUB_GEREN_VENTA SGV  ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_borr = 0 ");
            }
           
            buf.append(" ORDER BY Z.DES_ZONA ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

       UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerZonasSinFiltro(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }

    public RecordSet obtenerSeccionesSinFiltro(DTOUnidadAdministrativa dtoe) throws MareException {
    
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSeccionesSinFiltro(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            buf.append(
                "select S.OID_SECC, S.ZZON_OID_ZONA, S.COD_NSE1, S.COD_NSE2, S.COD_NSE3, S.DES_SECCI, S.COD_SECC from ZON_SECCI S ");

            if(dtoe.getOidZona() != null) {
                buf.append(" where S.ZZON_OID_ZONA = " + dtoe.getOidZona());
                buf.append(" and s.ind_borr = 0 ");
            } else if(dtoe.getOidRegion() != null) {
                buf.append(" ,ZON_ZONA Z");
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z");
                buf.append(" where S.ZZON_OID_ZONA = Z.OID_ZONA and");
                buf.append(" R.OID_REGI = Z.ZORG_OID_REGI and");
                buf.append(" R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SUB_GEREN_VENTA SGV  ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_borr = 0 ");               
            }
            
            buf.append(" ORDER BY S.DES_SECCI ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSeccionesSinFiltro(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }

    public RecordSet obtenerTerritoriosSinFiltro(DTOUnidadAdministrativa dtoe) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritoriosSinFiltro(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            buf.append(
                "select T.OID_TERR, TA.ZSCC_OID_SECC, T.COD_NSE1, T.COD_NSE2, T.COD_NSE3, T.COD_TERR, T.PAIS_OID_PAIS from ZON_TERRI T, ZON_TERRI_ADMIN TA ");

            if(dtoe.getOidSeccion() != null) {
                buf.append(" where T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append("and TA.ZSCC_OID_SECC = " + dtoe.getOidSeccion());
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidZona() != null) {
                buf.append(" ,ZON_SECCI S ");
                buf.append(" where S.ZZON_OID_ZONA = " + dtoe.getOidZona());
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidRegion() != null) {
                buf.append(" ,ZON_ZONA Z, ZON_SECCI S");
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SECCI S");
                buf.append(" where S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SUB_GEREN_VENTA SGV, ZON_SECCI S ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and sgv.ind_acti = 1 ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");                
            }

            buf.append(" ORDER BY T.COD_TERR ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritoriosSinFiltro(DTOUnidadAdministrativa dtoe): Salida");
        return respuesta;
    }

    public DTOSalida obtenerTerritoriosPorSeccion(DTOUnidadAdministrativa dtoin) throws MareException {       
    
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritoriosPorSeccion(DTOUnidadAdministrativa dtoin): Entrada");
        
        RecordSet respuesta;
        DTOSalida dtos= new DTOSalida(); 
       
        if(dtoin.getOidMarca()==null && dtoin.getOidCanal()== null && dtoin.getOidPais()== null) {
              throw new MareException(null, null,
			  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATOS_ENTRADA_INCORRECTOS));
        }

        DAOZON daoZon = new DAOZON();
        respuesta = daoZon.obtenerTerritoriosPorSeccion(dtoin.getOidMarca(), dtoin.getOidCanal(), dtoin.getOidPais());
        
        dtos.setResultado(respuesta);
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritoriosPorSeccion(DTOUnidadAdministrativa dtoin)): Salida");
        return dtos;
    }

    public DTOSalida obtenerSeccionesPorZona(DTOUnidadAdministrativa dtoin) throws MareException {
    
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSeccionesPorZona(DTOUnidadAdministrativa dtoin): Entrada");
        
        RecordSet respuesta;
        DTOSalida dtos= new DTOSalida(); 
       
        if(dtoin.getOidMarca()==null && dtoin.getOidCanal()== null && dtoin.getOidPais()== null) {
              throw new MareException(null, null,
			  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATOS_ENTRADA_INCORRECTOS));
        }

        DAOZON daoZon = new DAOZON();
        respuesta = daoZon.obtenerSeccionesPorZona(dtoin.getOidMarca(), dtoin.getOidCanal(), dtoin.getOidPais());
        
        dtos.setResultado(respuesta);
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerSeccionesPorZona(DTOUnidadAdministrativa dtoin): Salida");
        return dtos;
    }

  public DTOSalida obtenerRegionesPorSGV(DTOUnidadAdministrativa dtoin) throws MareException
  {
  
      UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegionesPorSGV(DTOUnidadAdministrativa dtoin): Entrada");
      
      // Chequea que alguno de los parametros de dtoin sea distinto de null.
      DTOSalida dtoSalida = new DTOSalida();
      if ( (dtoin.getOidPais() == null) && (dtoin.getOidCanal() == null) && (dtoin.getOidMarca() == null) )
      { 
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegionesPorSGV(DTOUnidadAdministrativa dtoin): Salida");
        // Si todos son null, tira una MareException
        throw new MareException(null, null,
			  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATOS_ENTRADA_INCORRECTOS));
      } else
      {
        DAOZON daozon = new DAOZON();
        RecordSet r = daozon.obtenerRegionesPorSGV(dtoin.getOidMarca(), dtoin.getOidCanal(), dtoin.getOidPais() );
        UtilidadesLog.debug("Regiones por SGV: " + r.toString() );
        dtoSalida.setResultado(r);       
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegionesPorSGV(DTOUnidadAdministrativa dtoin): Salida");
        return dtoSalida;
      }
  }

  public DTOSalida obtenerZonasPorRegiones(DTOUnidadAdministrativa dtoin) throws MareException
  {
    UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerZonasPorRegiones(DTOUnidadAdministrativa dtoin): Entrada");
    
    DTOSalida dtoSalida = new DTOSalida();
      if ( (dtoin.getOidPais() == null) && (dtoin.getOidCanal() == null) && (dtoin.getOidMarca() == null) )
      {
       UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerZonasPorRegiones(DTOUnidadAdministrativa dtoin): Salida");
        // Si todos son null, tira una MareException
        throw new MareException(null, null,
			  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATOS_ENTRADA_INCORRECTOS));
      } else
      {
        DAOZON daozon = new DAOZON();
        RecordSet r = daozon.obtenerZonasPorRegiones(dtoin.getOidMarca(), dtoin.getOidCanal(), dtoin.getOidPais());
        UtilidadesLog.debug("Zonas por region: " + r.toString() );
        dtoSalida.setResultado(r);
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerZonasPorRegiones(DTOUnidadAdministrativa dtoin): Salida");
        return dtoSalida;
      }

  }

    public DTOSalida recargaSubgerenciaVentas(DTOUnidadAdministrativa dtoe) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaSubgerenciaVentas(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        DTOSalida dto = new DTOSalida();
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select OID_SUBG_VENT, DES_SUBG_VENT ");
            buf.append(" from VCA_ZON_SUB_GEREN_VENTA ");

            String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"CANA_OID_CANA", "MARC_OID_MARC", "PAIS_OID_PAIS"},
                    new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()}, new boolean[] {false, false, false});

            if(sqlWhere == "")
                buf.append(" WHERE ");
            else {
                buf.append(sqlWhere);
                buf.append(" AND ");
            }

            buf.append(" ind_acti = 1 ");
            buf.append(" and ind_borr = 0 ");
            buf.append(" AND COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY DES_SUBG_VENT ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaSubgerenciaVentas(DTOUnidadAdministrativa dtoe): Salida");
        return new DTOSalida(respuesta);
    }

	public DTOSalida recargaZonas(DTOUnidadAdministrativa dtoe) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaZonas(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select Z.OID_ZONA, Z.DES_ZONA, Z.COD_ZONA , Z.ZORG_OID_REGI from VCA_ZON_ZONA Z ");

            if(dtoe.getOidRegion() != null) {
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R");
                buf.append(" where R.OID_REGI = Z.ZORG_OID_REGI and");
                buf.append(" R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_SUB_GEREN_VENTA SGV  ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and sgv.ind_acti = 1 ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
            }
            buf.append(" AND Z.COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY Z.DES_ZONA ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaZonas(DTOUnidadAdministrativa dtoe): Salida");
        return new DTOSalida(respuesta);
	}

   	public DTOSalida recargaSecciones(DTOUnidadAdministrativa dtoe) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaSecciones(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select S.OID_SECC, S.DES_SECCI, S.COD_SECC, S.ZZON_OID_ZONA from VCA_ZON_SECCI S ");

            if(dtoe.getOidZona() != null) {
                buf.append(" where S.ZZON_OID_ZONA = " + dtoe.getOidZona());
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
            } else if(dtoe.getOidRegion() != null) {
                buf.append(" ,ZON_ZONA Z");
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z");
                buf.append(" where S.ZZON_OID_ZONA = Z.OID_ZONA and");
                buf.append(" R.OID_REGI = Z.ZORG_OID_REGI and");
                buf.append(" R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SUB_GEREN_VENTA SGV  ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and sgv.ind_acti = 1 ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
            }

            buf.append(" AND S.COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY S.DES_SECCI ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaSecciones(DTOUnidadAdministrativa dtoe): Salida");
        return new DTOSalida(respuesta);
	}

	public DTOSalida recargaTerritorios(DTOUnidadAdministrativa dtoe) throws MareException {
  
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaTerritorios(DTOUnidadAdministrativa dtoe): Entrada");
        
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String user = ctx.getCallerPrincipal().getName();

        try {
            buf.append(
                "select T.OID_TERR, T.COD_TERR from VCA_ZON_TERRI T, ZON_TERRI_ADMIN TA ");

            if(dtoe.getOidSeccion() != null) {
                buf.append(" where T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append("and TA.ZSCC_OID_SECC = " + dtoe.getOidSeccion());
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidZona() != null) {
                buf.append(" ,ZON_SECCI S ");
                buf.append(" where S.ZZON_OID_ZONA = " + dtoe.getOidZona());
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidRegion() != null) {
                buf.append(" ,ZON_ZONA Z, ZON_SECCI S");
                buf.append(" where Z.ZORG_OID_REGI = " + dtoe.getOidRegion());
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else if(dtoe.getOidSGV() != null) {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SECCI S");
                buf.append(" where S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and R.ZSGV_OID_SUBG_VENT = " + dtoe.getOidSGV());
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            } else {
                buf.append(" ,ZON_REGIO R, ZON_ZONA Z, ZON_SUB_GEREN_VENTA SGV, ZON_SECCI S ");

                String sqlWhere = UtilidadesBD.armarSQLWhere(new String[] {"SGV.CANA_OID_CANA", "SGV.MARC_OID_MARC", "SGV.PAIS_OID_PAIS"},
                        new Object[] {dtoe.getOidCanal(), dtoe.getOidMarca(), dtoe.getOidPais()},
                        new boolean[] {false, false, false, false});

                if(sqlWhere == "")
                    buf.append(" WHERE ");
                else {
                    buf.append(sqlWhere);
                    buf.append(" AND ");
                }

                buf.append(" R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT ");
                buf.append(" and R.OID_REGI = Z.ZORG_OID_REGI ");
                buf.append(" and S.ZZON_OID_ZONA = Z.OID_ZONA ");
                buf.append(" and T.OID_TERR = TA.TERR_OID_TERR ");
                buf.append(" and S.OID_SECC = TA.ZSCC_OID_SECC ");
                buf.append(" and sgv.ind_acti = 1 ");
                buf.append(" and sgv.ind_borr = 0 ");
                buf.append(" and r.ind_acti = 1 ");
                buf.append(" and r.ind_borr = 0 ");
                buf.append(" and z.ind_acti = 1 ");
                buf.append(" and z.ind_borr = 0 ");
                buf.append(" and s.ind_acti = 1 ");
                buf.append(" and s.ind_borr = 0 ");
                buf.append(" and t.ind_borr = 0 ");
                buf.append(" and ta.ind_borr = 0 ");
            }

            buf.append(" AND T.COD_USUA = '"+user+"' ");
            buf.append(" ORDER BY T.COD_TERR ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaTerritorios(DTOUnidadAdministrativa dtoe): Salida");
        return new DTOSalida(respuesta);
	}

  Long obtenerGerente(DTOUnidadAdministrativa arg) throws MareException{
    UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerGerente(DTOUnidadAdministrativa arg): Entrada");
	  DAOZON zona = new DAOZON();
	  Long valor = zona.obtenerGerente(arg);
    UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerGerente(DTOUnidadAdministrativa arg): Salida");
	  return valor;
  }

  public DTOSalida obtenerRegionesPorPais(DTOBelcorp dto) throws MareException
  {     UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegionesPorPais(DTOOID dto): Entrada");
  
        String codigoError;
        RecordSet respuesta;
        DTOSalida dtoS = new DTOSalida();
        StringBuffer buf = new StringBuffer();        

        try {
        
             buf.append(" SELECT R.OID_REGI OID, R.DES_REGI DESCRIPCION, SGV.MARC_OID_MARC MARCA, SGV.CANA_OID_CANA CANAL ");
             buf.append(" FROM ZON_REGIO R, ZON_SUB_GEREN_VENTA SGV ");
             buf.append(" WHERE 1 = 1 ");
             if (dto.getOidPais()!=null){
                buf.append(" AND SGV.PAIS_OID_PAIS = "+dto.getOidPais()+" ");
             }
             buf.append(" AND R.ZSGV_OID_SUBG_VENT = SGV.OID_SUBG_VENT  ");
             buf.append(" AND sgv.ind_borr = 0  ");
             buf.append(" AND r.ind_borr = 0 ");
             buf.append(" AND r.IND_ACTI = 1 ");
             buf.append(" ORDER BY R.DES_REGI ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        dtoS.setResultado(respuesta);
        UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerRegionesPorPais(DTOOID dto): Salida");
        return dtoS;        
  }

    public void evaluacionEstadoZona(DTOFACProcesoCierre DTOE) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.evaluacionEstadoZona(DTOFACProcesoCierre DTOE): Entrada");
        UtilidadesLog.debug("dtoFACProcesoCierre " + DTOE);
        
        DTOZona dtoZona = new DTOZona();
        dtoZona.setOidZona(DTOE.getZona());
        
        ZonaLocalHome zonaLH = this.getZonaLocalHome();
        ZonaLocal zona = null;
        
        try{
            zona = zonaLH.findByPrimaryKey(DTOE.getZona());
        } catch (NoResultException fe){
            UtilidadesLog.error("MONUnidadesAdministrativas.evaluacionEstadoZona: FinderException Zona", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));    
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        EstadoZonaLocalHome estadoZonaLH = this.getEstadoZonaLocalHome();
        EstadoZonaLocal estadoActual = null;
        
        
        if(zona.getOidEstadoZona()!= null){
            try{
                estadoActual = estadoZonaLH.findByPrimaryKey(zona.getOidEstadoZona());
            } catch (NoResultException fe){
                EstadoZonaLocal estado = null;
                try{
                    // BELC300018464
                    // BELC300018639
                    estado = estadoZonaLH.findByUK(DTOE.getOidPais(),DTOE.getMarca(),ConstantesZON.CODIGO_ESTADO_INICIAL);
                } catch (NoResultException e){
                    UtilidadesLog.error("MONUnidadesAdministrativas.evaluacionEstadoZona: FinderException EstadoZona", fe);
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));        
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                dtoZona.setOidEstadoZona(estado.getOid());
                dtoZona.setFechaCambioEstado(new Date(System.currentTimeMillis()));
                this.actualizarEstado(dtoZona);//BELC300018873
             }  catch (PersistenceException ce) {   
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        
        } else {
            EstadoZonaLocal estado = null;
            try{
                // BELC300018464
                // BELC300018639
                estado = estadoZonaLH.findByUK(DTOE.getOidPais(),DTOE.getMarca(),ConstantesZON.CODIGO_ESTADO_INICIAL);
            } catch (NoResultException e){
                UtilidadesLog.error("MONUnidadesAdministrativas.evaluacionEstadoZona: FinderException EstadoZona", e);
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));        
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            dtoZona.setOidEstadoZona(estado.getOid());
            dtoZona.setFechaCambioEstado(new Date(System.currentTimeMillis()));
            this.actualizarEstado(dtoZona);//BELC300018873                
        }
        
        if (estadoActual != null) {     
            // si el indicadorInicio esta inactivo, false eq ConstantesZON.IND_INACTIVO
            if ( ! estadoActual.getIndicadorInicio().booleanValue()) {
                UtilidadesLog.debug("indicador inicio inactivo ");
                boolean estaTiempoMinimo;
                if (estadoActual.getTiempoMinimo() != null){
                    Calendar fechaCambio = Calendar.getInstance();
                    fechaCambio.setTime((Date)zona.getFechaCambioEstado());
                    long diferenciaDias = (System.currentTimeMillis() - fechaCambio.getTimeInMillis()) / 86400000;
                    if (diferenciaDias >= estadoActual.getTiempoMinimo().longValue()){
                        estaTiempoMinimo = true;
                    } else {
                        estaTiempoMinimo = false;
                    }
                } else {
                    estaTiempoMinimo = true;
                }
                UtilidadesLog.debug("estaTiempoMinimo: " + estaTiempoMinimo);

                if (estaTiempoMinimo) {
                    DTOPedidosZona dtoDatosPedidos = new DTOPedidosZona();
                    dtoDatosPedidos.setOidZona(DTOE.getZona());
                    dtoDatosPedidos.setOidPeriodo(DTOE.getPeriodo());
                    /* DBLG500000150 - dmorello, 09/08/2006: seteo pais y marca */
                    dtoDatosPedidos.setOidPais(DTOE.getOidPais());
                    dtoDatosPedidos.setOidMarca(DTOE.getMarca());
                    
                    DAOEstadisticasPED daoPED = new DAOEstadisticasPED();
                    dtoDatosPedidos = daoPED.obtenerNumeroPedidosYMonto(dtoDatosPedidos);
                    
                    DAOZON daoZON = new DAOZON();
                    dtoDatosPedidos.setNumeroConsultoras(daoZON.obtenerNroConsultorasZona(dtoDatosPedidos));
                    UtilidadesLog.debug("dtoDatosPedidos: " + dtoDatosPedidos);
                    dtoZona.setOidEstadoZona(daoZON.obtenerNuevoEstadoEvaluacion(dtoDatosPedidos));
                    
                    if (zona.getRezonificacion() != null
                            && zona.getRezonificacion().equals(ConstantesZON.IND_ACTIVO)){
                            
                        UtilidadesLog.debug("indicador rezonificacion activo ");
                        PaisLocal paramPais = null;
                        try{
                            paramPais = this.getPaisLocalHome().findByPrimaryKey(DTOE.getOidPais());
                        } catch (NoResultException fe){
                            UtilidadesLog.error("MONUnidadesAdministrativas.evaluacionEstadoZona: FinderException Pais", fe);
                            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));        
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                        Calendar fechaCambio = Calendar.getInstance();
                        fechaCambio.setTime((Date)zona.getFechaRezonificacion());
                        long diferenciaDias = (System.currentTimeMillis() - fechaCambio.getTimeInMillis()) / 86400000;
                        if (diferenciaDias >= paramPais.getVal_tiem_rezo().longValue()){
                            dtoZona.setIndRezonificacion(new Boolean(false));
                        } else{
                            dtoZona.setIndRezonificacion(null);
                        }
                        
                        /*
                         * INC 22396 - dmorello, 25/01/2006
                         * Las siguientes dos líneas van fuera del IF
                         */
                        //dtoZona.setFechaCambioEstado(new Date(System.currentTimeMillis()));
                        //this.actualizarEstado(dtoZona);
                    } 
                    
                    /*
                     * INC 22396 - dmorello, 25/01/2006
                     * Estas dos líneas van fuera del IF anterior, según lo
                     * indica el modelo; de otro modo, no se podría actualizar
                     * el estado si el IND_REZO de la zona está en activo.
                     */
                    dtoZona.setFechaCambioEstado(new Date(System.currentTimeMillis()));
                    this.actualizarEstado(dtoZona);
                }
                else{
                    UtilidadesLog.debug("MONUnidadesAdministrativas.evaluacionEstadoZona. La zona 'DTOE.zona' no ha estado en el estado actual 'estadoActual.codigo' el tiempo mínimo, no se evalúa");
                }
            } else{
                UtilidadesLog.debug("MONUnidadesAdministrativas.evaluacionEstadoZona. La zona 'DTOE.zona' tiene datos de inicio, no se evalúa");
                
                try {
                    estadoActual = estadoZonaLH.findByUK(DTOE.getOidPais(), DTOE.getMarca(), ConstantesZON.CODIGO_ESTADO_INICIAL);
                }
                catch (NoResultException e) {
                    UtilidadesLog.error("MONUnidadesAdministrativas.evaluacionEstadoZona: FinderException Zona", e);
                    String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                dtoZona.setOidEstadoZona(estadoActual.getOid());
                dtoZona.setIndRezonificacion(null);
                
                dtoZona.setFechaCambioEstado(new Date(System.currentTimeMillis()));
                this.actualizarEstado(dtoZona);//BELC300018873
                
            }
        }
        
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.evaluacionEstadoZona(DTOFACProcesoCierre DTOE): Salida");
    }

    public void reestructurarUAdministrativasSegundaFase(DTOFACProcesoCierre DTOE) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.reestructurarUAdministrativasSegundaFase(DTOFACProcesoCierre DTOE): Entrada");
        
        DAOCRA daoCra = new DAOCRA();
        
        Long oidPeriodoSiguiente = daoCra.obtienePeriodoSiguiente(DTOE.getPeriodo());
        if(oidPeriodoSiguiente == null) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            String mensaje = "MONUnidadesAdministrativas.reestructurarUAdministrativasSegundaFase: "
                            + "no se encontró oidPeriodoSiguiente en DAOCRA.obtienePeriodoSiguiente"
                            + "("+DTOE.getPeriodo()+")";
            throw new MareException(mensaje, UtilidadesError.armarCodigoError(error));
        }
        
        DAOZON daoZon = new DAOZON();
        daoZon.activarUnidadesAdministrativasCliente(oidPeriodoSiguiente);
        daoZon.desactivarUnidadesAdministrativasCliente(DTOE.getPeriodo());

        //agregado por Sapaza, incidencia Sicc-20070276 (13-06-2007)
        daoZon.activarTerritoriosAdministrativos(oidPeriodoSiguiente);
        daoZon.desactivarTerritoriosAdministrativos(DTOE.getPeriodo());

        daoZon.activarSecciones(oidPeriodoSiguiente);
        daoZon.desactivarSecciones(DTOE.getPeriodo());
        
        daoZon.activarZonas(oidPeriodoSiguiente);
        daoZon.desactivarZonas(DTOE.getPeriodo());
        
        daoZon.activarRegiones(oidPeriodoSiguiente);
        daoZon.desactivarRegiones(DTOE.getPeriodo());
        
        daoZon.activarSubgerenciasVenta(oidPeriodoSiguiente);
        daoZon.desactivarSubgerenciasVenta(DTOE.getPeriodo());
        
        daoZon.actualizarFechaActivacionHistoricoZonas(oidPeriodoSiguiente);
        
        DTOPeriodo dtoPeriodo = new DTOPeriodo();
        dtoPeriodo.setOid(DTOE.getPeriodo());
        dtoPeriodo.setPais(DTOE.getOidPais());
        dtoPeriodo.setOidPais(DTOE.getOidPais());
        dtoPeriodo.setOidIdioma(DTOE.getOidIdioma());
        dtoPeriodo.setMarca(DTOE.getMarca());
        dtoPeriodo.setCanal(DTOE.getCanal());

        ArrayList zonasParticionadas = daoZon.obtenerZonasParticionadas(dtoPeriodo);
        DTOZona dtoZon = null;
        DTOHistoricoZona dtoHistorico = null;
        int n = zonasParticionadas.size();
        for(int i = 0; i<n; i++) {
            dtoHistorico = (DTOHistoricoZona)zonasParticionadas.get(i);
            
            dtoZon = new DTOZona();
            
            dtoZon.setOidZona(dtoHistorico.getOidZonaHija());
            dtoZon.setOidEstadoZona(dtoHistorico.getOidEstadoPadre());
            if(ConstantesZON.IND_ACTIVO.intValue()==1) {
                dtoZon.setIndRezonificacion(new Boolean(true));    
            } else {
                dtoZon.setIndRezonificacion(new Boolean(false));
            }
            dtoZon.setFechaCambioEstado(null);
            
            this.actualizarEstado(dtoZon);
        }

        RecordSet zonasFusionadas = daoZon.obtenerZonasFusionadas(dtoPeriodo);
        n = zonasFusionadas.getRowCount();
        for(int i = 0; i<n; i++) {
            DTOE.setZona(new Long(((BigDecimal)zonasFusionadas.getValueAt(i, "OID_ZONA")).longValue()));
            
            this.evaluacionEstadoZona(DTOE);
        }
        
        // Aclarado por la BELC300018463
        RecordSet zonasActivas = daoZon.obtenerZonasActivas(oidPeriodoSiguiente);
        MONReestructuracion monReestructuracion = this.getMONReestructuracion();
        Long oidZona = null;
        n = zonasActivas.getRowCount();
        for(int i = 0; i<n; i++) {
            oidZona = new Long(((BigDecimal)zonasActivas.getValueAt(i, "OID_ZONA")).longValue());
            try {
                monReestructuracion.asignarNSE(DTOE.getOidPais(), DTOE.getMarca(), 
                    DTOE.getCanal(), null, oidZona, new Integer(3));
            } catch (RemoteException e) {
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }
        }
        UtilidadesLog.info("MONUnidadesAdministrativasBean.reestructurarUAdministrativasSegundaFase(DTOFACProcesoCierre DTOE): Salida");
    }

    public void actualizarEstado(DTOZona DTOE) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.actualizarEstado(DTOZona DTOE): Entrada");
        UtilidadesLog.debug("DTOZona " + DTOE);
        //Actualiza los datos que se pasan en el DTOE (que no sean nulos) en la entidad Zona 

        // zona = findByPrimaryKey (DTOE.oidZona) sobre Zona
        ZonaLocal zonaLocal = null;
        
        ZonaLocalHome zonaLocalHome = this.getZonaLocalHome();
        try {
            zonaLocal = zonaLocalHome.findByPrimaryKey(DTOE.getOidZona());
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONUnidadesAdministrativas.actualizarEstado: FinderException Zona", fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));    
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

        }
         
        /*Hacer una modificación para los campos del DTOE de entrada que no sean nulos: 
        zona.estado = DTOE.oidEstadoZona 
        zona.fechaCambioEstado = DTOE.fechaCambioEstado //sólo si DTOE.fechaCambioEstado es != null, si es == null no se modifica, de deja como está 
        zona.indRezonificacion = DTOE.indRezonificacion //sólo si DTOE.indRezonificacion != null, si es == null no se modifica*/
        
        if (DTOE.getOidEstadoZona() != null) {
            zonaLocal.setOidEstadoZona(DTOE.getOidEstadoZona());
        }
        if (DTOE.getFechaCambioEstado() != null) {
            zonaLocal.setFechaCambioEstado(new Timestamp(DTOE.getFechaCambioEstado().getTime()));
        }        
        if (DTOE.getIndRezonificacion() != null) {
            zonaLocal.setRezonificacion(DTOE.getIndRezonificacion().equals(Boolean.TRUE) ? new Long(1) : new Long(0));
        }
        zonaLocalHome.merge(zonaLocal);
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean.actualizarEstado(DTOZona DTOE): Salida");
    }
    
  /**
   * @author: ssantana, 25/11/2005, SICC-GCC-ZON-003
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param DTOBuscarUA dtoe
   */
    public DTOSalida buscarUnidadesAdministrativas(DTOBuscarUA dtoe) throws MareException
    {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.buscarUnidadesAdministrativas(DTOBuscarUA dtoe): Entrada");
        DTOSalida resultado = new DTOSalida();
        RecordSet rs = null;
        //llamar al método DAOZON.buscarUASinResponsable(DTOE)
        DAOZON dao = new DAOZON();  
        
        // Modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003
        // rs = dao.buscarUASinResponsable(dtoe);
        rs = dao.buscarUnidadesAdministrativas(dtoe);
        // Fin modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003
        
        resultado.setResultado(rs);
        UtilidadesLog.info("MONUnidadesAdministrativasBean.buscarUnidadesAdministrativas(DTOBuscarUA dtoe): Salida");
        return resultado;
    }
   //creado por solicitud de cambio ZON-005 Peru Esika (SCS, 16/05/2008)  
   public void asignarResponsableContinuar(DTOResponsable dtoe) throws MareException {
       UtilidadesLog.info("MONUnidadesAdministrativasBean.asignarResponsableContinuar(DTOResponsable dtoe): Entrada");    
       ClienteDatosBasicosLocal clienteLocal = null;
       Long oidGerenteHistorico = null;
       DAOZON daoZON = new DAOZON();

       if (dtoe.getCodigoResponsable() != null) {
           ClienteDatosBasicosLocalHome clienteLocalHome = this.getClienteDatosBasicosLocalHome();
            try {
                clienteLocal = clienteLocalHome.findByUK(dtoe.getOidPais(),dtoe.getCodigoResponsable());
            } catch (NoResultException fe) {
                UtilidadesLog.error("MONUnidadesAdministrativas.asignarResponsable: FinderException cliente", fe);
                UtilidadesLog.error("El código de cliente responsable ["+dtoe.getCodigoResponsable()+"] no existe en el Maestro de Clientes");
                ExcepcionParametrizada ep = new ExcepcionParametrizada("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_CLIENTE_RESPONSABLE));
                ep.addParameter(dtoe.getCodigoResponsable());
                ep.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                throw ep;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            dtoe.setOidResponsable(clienteLocal.getOid());
        } else {
            dtoe.setOidResponsable(null);
        }

        boolean esResponsable = false;
        if(dtoe.getOidResponsable() != null) {
            if(dtoe.getIndUA().equals(ConstantesZON.IND_SECCION)){
                esResponsable = daoZON.validarClienteConsultora(clienteLocal.getOid());
            }else{
                esResponsable = daoZON.validarClienteGerente(clienteLocal.getOid());
            }
        } else {
            esResponsable = true;
        }

        if(!esResponsable){
            if(dtoe.getIndUA().equals(ConstantesZON.IND_SECCION)){
                UtilidadesLog.debug("No es Consultora, lanza excepcion " + 
                           "'El responsable elegido no es de tipo Consultora'");
                throw new MareException(null, null,
                     UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, 
                                           "", 
                                           ErroresDeNegocio.RESPONSABLE_ELEGIDO_NO_CONSULTORA));
            }else{
                UtilidadesLog.debug("No es Gerente, lanza excepcion " + 
                           "'El responsable elegido no es de tipo gerente'");
                throw new MareException(null, null,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, 
                                           "", 
                                           ErroresDeNegocio.RESPONSABLE_ELEGIDO_NO_GERENTE));
            }    
        } else {
            if(dtoe.getOidResponsable() != null && !dtoe.getIndUA().equals(ConstantesZON.IND_SUBGERENCIA)) {    
                String asignado = daoZON.validarResponsableYaAsignado(dtoe);
                if(asignado != null) {
                    UtilidadesLog.debug("Responsable ya esta asignado a otra UA, lanza excepcion");
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, 
                                                   "", 
                                                   ErroresDeNegocio.RESPONSABLE_YA_ASIGNADO));

                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter(asignado);
                    throw ex;                                                   
                }
            }
        }
        Long oidGerenteAnterior = new Long(0);
        if (dtoe.getIndUA().equals(ConstantesZON.IND_SUBGERENCIA)) {
            try{
                SubGerenciaVentaLocal subgerencia = 
                      this.getSubGerenciaVentaLocalHome().findByPrimaryKey(dtoe.getOidUA());
                oidGerenteAnterior = subgerencia.getOidCliente();
                subgerencia.setOidCliente(dtoe.getOidResponsable());
                this.getSubGerenciaVentaLocalHome().merge(subgerencia);
            }catch (NoResultException fe){
               UtilidadesLog.debug("MONUnidadesAdministrativas.asignarResponsable: " + 
                                   "Error FinderException: Subgerencia");
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else if (dtoe.getIndUA().equals(ConstantesZON.IND_REGION)) {
            try {
                RegionLocal region = this.getRegionLocalHome().findByPrimaryKey(dtoe.getOidUA());
                oidGerenteAnterior = region.getOidCliente();
                region.setOidCliente(dtoe.getOidResponsable());
                this.getRegionLocalHome().merge(region);
            } catch (NoResultException fe) {
                UtilidadesLog.debug("MONUnidadesAdministrativas.asignarResponsable: " +
                                    "Error FinderException: Region");
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else if(dtoe.getIndUA().equals(ConstantesZON.IND_ZONA)) {
            try{
                ZonaLocal zona = this.getZonaLocalHome().findByPrimaryKey(dtoe.getOidUA());
                oidGerenteAnterior = zona.getCliente();
                zona.setCliente(dtoe.getOidResponsable());
                this.getZonaLocalHome().merge(zona);
            }catch (NoResultException fe){
                UtilidadesLog.debug("MONUnidadesAdministrativas.asignarResponsable: " + 
                                    "Error FinderException: Zona");
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else if(dtoe.getIndUA().equals(ConstantesZON.IND_SECCION)) {
            try{
                
                SeccionLocal seccion = this.getSeccionLocalHome().findByPrimaryKey(dtoe.getOidUA());
                oidGerenteAnterior = seccion.getClienteOid();
                seccion.setClienteOid(dtoe.getOidResponsable());
                this.getSeccionLocalHome().merge(seccion);
            }catch(NoResultException fe){
                UtilidadesLog.debug("MONUnidadesAdministrativas.asignarResponsable: " + 
                                    "Error FinderException: Seccion");
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        oidGerenteHistorico = this.generarHistoricoResponsables(dtoe, oidGerenteAnterior);

        if (dtoe.getCodigoResponsable() != null) {
            this.enviarMensajeHistorico(oidGerenteHistorico, dtoe);
        }
        UtilidadesLog.info("MONUnidadesAdministrativasBean.asignarResponsableContinuar(DTOResponsable dtoe): Salida");    
   }
    
  /**
   * 12-04-2012   agregado por Sapaza, PER-SiCC-2011-0928, se elimina todo lo referente a Secciones y 
   *              Numero Minimo de Campañas
   * 
   * @author: ssantana, 25/11/2005, SICC-GCC-ZON-003
   * @throws es.indra.mare.common.exception.MareException
   * @param DTOResponsable dtoe
   */
 public void asignarResponsable(DTOResponsable dtoe) throws MareException {
    UtilidadesLog.info("MONUnidadesAdministrativasBean.asignarResponsable(DTOResponsable dtoe): Entrada");    
    /* Este método actualiza la entidad correspondiente de ZON con el responsable 
       (código de cliente responsable) que se ha asignado en la pantalla, 
       dependiendo de la unidad administrativa 
       por la que se hizo la búsqueda accederemos a una entida de ZON u otra. */
    ClienteDatosBasicosLocal clienteLocal = null;
    Long oidGerenteHistorico = null;
    DAOZON daoZON = new DAOZON();

    //<inicio>Si envia responsable, se valida que codigo de Cliente exista en maestro de clientes, incidencia SiCC-20070205
    if (dtoe.getCodigoResponsable() != null) {
        /* BELC300022921 - dmorello, 29/03/2006: Se descomenta el siguiente find */
        ClienteDatosBasicosLocalHome clienteLocalHome = this.getClienteDatosBasicosLocalHome();
        try {
            clienteLocal = clienteLocalHome.findByUK(dtoe.getOidPais(),dtoe.getCodigoResponsable());
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONUnidadesAdministrativas.asignarResponsable: FinderException cliente", fe);
            UtilidadesLog.error("El código de cliente responsable ["+dtoe.getCodigoResponsable()+"] no existe en el Maestro de Clientes");
            ExcepcionParametrizada ep = new ExcepcionParametrizada("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_CLIENTE_RESPONSABLE));
            ep.addParameter(dtoe.getCodigoResponsable());
            ep.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
            throw ep;
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        // Agregado por ssantana, 24/11/2005, cambio GCC-SICC-ZON-003
        /* BELC300022921 - dmorello, 30/03/2006: Seteo el OID de cliente en el DTO */
        dtoe.setOidResponsable(clienteLocal.getOid());
    } else {
        dtoe.setOidResponsable(null);
    }
    //<fin>incidencia SiCC-20070205
    
    //Si envia responsable, se valida que es de Tipo Gerente, 
    //en caso de SubGerencia,Region, Zona, incidencia SiCC-20070205
    boolean esResponsable = false;
    if(dtoe.getOidResponsable() != null) {
        esResponsable = daoZON.validarClienteGerente(clienteLocal.getOid());
    } else {
        esResponsable = true;
    }

    if(!esResponsable){
       UtilidadesLog.debug("No es Gerente, lanza excepcion " + 
                           "'El responsable elegido no es de tipo gerente'");
       throw new MareException(null, null,
          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, 
                                           "", 
                                           ErroresDeNegocio.RESPONSABLE_ELEGIDO_NO_GERENTE));
    } else {
        //<inicio>agregado por incidencia SiCC-20070239 (Sapaza)
        //para Region, Zona, Seccion se validara que el responsable no este asignado a otra unidad administrativa
        if(dtoe.getOidResponsable() != null && !dtoe.getIndUA().equals(ConstantesZON.IND_SUBGERENCIA)) {    
            String asignado = daoZON.validarResponsableYaAsignado(dtoe);
            
            if(asignado != null) {
                UtilidadesLog.debug("Responsable ya esta asignado a otra UA, lanza excepcion");
                                                   
                ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, 
                                                   "", 
                                                   ErroresDeNegocio.RESPONSABLE_YA_ASIGNADO));

                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                ex.addParameter(asignado);
                throw ex;                                                   
             }
        }
        //<fin>agregado por incidencia SiCC-20070239 (Sapaza)
    }
    
    //jrivas 21/4/2006 ZON-03 
    Long oidGerenteAnterior = new Long(0);
    
    //PENDIENTE INCIDENCIA 18774
    /*Incidencia 22532 pzerbino 09/03/2006 */ 
    /* dmorello, 27/03/2006: Sólo se comentan los seteos de dtoe.codigoUA */
    if (dtoe.getIndUA().equals(ConstantesZON.IND_SUBGERENCIA)) {
        try{
            SubGerenciaVentaLocal subgerencia = 
                  this.getSubGerenciaVentaLocalHome().findByPrimaryKey(dtoe.getOidUA());

            //jrivas 21/4/2006 ZON-03 
            oidGerenteAnterior = subgerencia.getOidCliente();
            //dtoe.setCodigoUA(subgerencia.getCodigoSubgVenta()); 
           //Modificar en la entidad SubgerenciaVentas el gerente: SubgerenciaVentas.gerente = cliente.oid
           //Modificado por Incidencia 18777
           // subgerencia.setOidCliente(clienteLocal.getOid());
           subgerencia.setOidCliente(dtoe.getOidResponsable());
           this.getSubGerenciaVentaLocalHome().merge(subgerencia);
        }catch (NoResultException fe){
           UtilidadesLog.debug("MONUnidadesAdministrativas.asignarResponsable: " + 
                               "Error FinderException: Subgerencia");
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    else if (dtoe.getIndUA().equals(ConstantesZON.IND_REGION)) {
        try {
            RegionLocal region = this.getRegionLocalHome().findByPrimaryKey(dtoe.getOidUA());
            //jrivas 21/4/2006 ZON-03 
            oidGerenteAnterior = region.getOidCliente();
            //dtoe.setCodigoUA(region.getCodigoRegion()); 
            //Modificar en la entidad Region el gerente: Region.gerente = cliente.oid
            //Modificado por Incidencia 18777
            //region.setOidCliente(clienteLocal.getOid());
            region.setOidCliente(dtoe.getOidResponsable());
            this.getRegionLocalHome().merge(region);
        } catch (NoResultException fe) {
            UtilidadesLog.debug("MONUnidadesAdministrativas.asignarResponsable: " +
                                "Error FinderException: Region");
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    else if(dtoe.getIndUA().equals(ConstantesZON.IND_ZONA)) {
        try{
            ZonaLocal zona = this.getZonaLocalHome().findByPrimaryKey(dtoe.getOidUA());
            //jrivas 21/4/2006 ZON-03 
            oidGerenteAnterior = zona.getCliente();
            //dtoe.setCodigoUA(zona.getCodZona()); 
            //Modificar en la entidad Zona el gerente: Zona.gerente = cliente.oid
            //Modificado por Incidencia 18777
            //zona.setCliente(clienteLocal.getOid());
            zona.setCliente(dtoe.getOidResponsable());
            this.getZonaLocalHome().merge(zona);
        }catch (NoResultException fe){
            UtilidadesLog.debug("MONUnidadesAdministrativas.asignarResponsable: " + 
                                "Error FinderException: Zona");
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }
    /*else if(dtoe.getIndUA().equals(ConstantesZON.IND_SECCION)) {
        try{
            
            SeccionLocal seccion = this.getSeccionLocalHome().findByPrimaryKey(dtoe.getOidUA());
            //jrivas 21/4/2006 ZON-03 
            oidGerenteAnterior = seccion.getClienteOid();
            //dtoe.setCodigoUA(seccion.getCodSecc()); 
            //Modificar en la entidad Seccion el responsable: Seccion.responsable = cliente.oid
            //Modificado por Incidencia 18777
            //seccion.setClienteOid(clienteLocal.getOid());
            seccion.setClienteOid(dtoe.getOidResponsable());
            this.getSeccionLocalHome().merge(seccion);
        }catch(NoResultException fe){
            UtilidadesLog.debug("MONUnidadesAdministrativas.asignarResponsable: " + 
                                "Error FinderException: Seccion");
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }*/
    
    // Añadido por incidenicia 20289
    //dtoe.setOidResponsable(clienteLocal.getOid());
    // Actualiza el historico de responsables 
    oidGerenteHistorico = this.generarHistoricoResponsables(dtoe, oidGerenteAnterior);

    //<inicio>Si envia responsable, se envia mensaje, incidencia SiCC-20070205
    if (dtoe.getCodigoResponsable() != null) {
        // Envia un mensaje con el historico de la Unidad Administrativa 
        this.enviarMensajeHistorico(oidGerenteHistorico, dtoe);
    }
    //<fin>incidencia SiCC-20070205

    UtilidadesLog.info("MONUnidadesAdministrativasBean.asignarResponsable(DTOResponsable dtoe): Salida");
 }  
 
  
	private MONReestructuracion getMONReestructuracion() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONReestructuracion(): Entrada");	
        MONReestructuracionHome home = (MONReestructuracionHome)UtilidadesEJB.getHome(
        "MONReestructuracion", MONReestructuracionHome.class);
        // Se obtiene el interfaz remoto
        MONReestructuracion ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONReestructuracion",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONReestructuracion(): Salida");
        return ejb;
	}
    
	private MONReestructuracionPrimeraFase getMONReestructuracionPrimeraFase() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONReestructuracionPrimeraFase(): Entrada");
        MONReestructuracionPrimeraFaseHome home = (MONReestructuracionPrimeraFaseHome)UtilidadesEJB.getHome(
        "MONReestructuracionPrimeraFase", MONReestructuracionPrimeraFaseHome.class);
        // Se obtiene el interfaz remoto
        MONReestructuracionPrimeraFase ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONReestructuracionPrimeraFase",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONReestructuracionPrimeraFase(): Salida");
        return ejb;
	}

    private MONGestionMensajes getMONGestionMensajes() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONGestionMensajes(): Entrada");
        MONGestionMensajesHome home = (MONGestionMensajesHome)UtilidadesEJB.getHome(
            "MONGestionMensajes", MONGestionMensajesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestionMensajes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONGestionMensajes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONGestionMensajes(): Salida");
        return ejb;
	} 

  public DTOSalida obtenerTerritoriosporZonas(DTOBelcorp dtoIn) throws MareException {
     UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritoriosporZonas(DTOBelcorp dtoIn): Entrada");
     DAOZON daoZon = new DAOZON();
     DTOSalida dtoS = new DTOSalida();
     dtoS.setResultado(daoZon.obtenerTerritoriosporZonas(dtoIn));
     UtilidadesLog.info("MONUnidadesAdministrativasBean.obtenerTerritoriosporZonas(DTOBelcorp dtoIn): Salida");
     return dtoS;
  }


  /**
   * @author: ssantana, 28/11/2005, SICC-GCC-ZON-003
   * @throws es.indra.mare.common.exception.MareException
   * @param DTOResponsable dtoe
   * @param Long oidGerenteAnterior
   */
  public void enviarMensajeHistorico(Long oidGerenteAnterior, DTOResponsable dtoe) throws MareException {
  
          UtilidadesLog.info("MONUnidadesAdministrativasBean.enviarMensajeHistorico" + 
                         "(DTOResponsable dtoe): Entrada");
      // Envia un mensaje con la informacion de la unidad administrativa actual: 
      // - Unidad administrativa 
      // - Responsable anterior 
      // - Fecha desde 
      // - Fecha hasta 
      // - Nuevo responsable 

      // Obtiene el periodo actual 
      MONPeriodos monPeriodo = this.getMONPeriodos();
      DTOPeriodo periodo = null;
      Long tipoPeriodo = null;
      try {
          periodo = monPeriodo.obtienePeriodoActual(dtoe.getOidPais(),
                                                    dtoe.getOidMarca(), 
                                                    dtoe.getOidCanal()) ;
      } catch (RemoteException re) {
          UtilidadesLog.error("*** Error en enviarMensajeHistorico", re);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
      }

      try {
          PeriodoCorporativoLocal periodoCorpLocal = (this.getPeriodoCorporativoLocalHome()).findByPrimaryKey(
                                                                periodo.getOidPeriodoCorporativo());
          tipoPeriodo = periodoCorpLocal.getOidTipoPeriodo();
      } catch (NoResultException e) {
          String sCodigoError = 
                  CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
          UtilidadesLog.debug("*** No se encontró el período corporativo " +
                              "del periodo actual ***");
          throw new MareException(e, 
                                  UtilidadesError.armarCodigoError(sCodigoError));
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      MONGestionMensajes localGestion = null;
  
      DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
      dtoBuzon.setOidPais(dtoe.getOidPais());
      dtoBuzon.setCodigoMensaje("ZON03");

      //pendiente de incidencia BELC300009492
      dtoBuzon.setModuloOrigen(Long.valueOf(ConstantesSEG.MODULO_ZON));   
      dtoBuzon.setDatoVariable1(tipoPeriodo.toString());
      dtoBuzon.setDatoVariable2(periodo.getOid().toString());
      
      //pendiente de incidencia BELC300009492
      dtoBuzon.setDatoVariable3(new Date().toString()); 
      dtoBuzon.setDatoVariable4(dtoe.getCodigoUA());
      
      /*
       * Modificacion por ssantana, 25/11/2005, SICC-GCC-ZON-003
       */
       dtoBuzon.setDatoVariable5(oidGerenteAnterior.toString());
      /*
       * Fin modificacion ssantana, 25/11/2005, SICC-GCC-ZON-003
       */
      dtoBuzon.setOidCliente(dtoe.getOidResponsable());
  
      localGestion = this.getMONGestionMensajes();
      try {
        localGestion.insertaDatosMensaje(dtoBuzon);
      } catch (RemoteException re) {
        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        UtilidadesLog.debug("enviarMensajeHistorico : RemoteException");
        UtilidadesLog.debug(re);
        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
      }
  
      UtilidadesLog.info("MONUnidadesAdministrativasBean.enviarMensajeHistorico" + 
                         "(DTOResponsable dtoe): Salida");
  }

  /**
   * @author: ssantana, 25/11/2005, SICC-GCC-ZON-003
   * @throws es.indra.mare.common.exception.MareException/
   * @return Long
   * @param DTOResponsable dtoe
   */
    public Long generarHistoricoResponsables(DTOResponsable dtoe, Long oidGerenteAnterior) 
            throws MareException {
        /* Guarda en el historico de responsables un registro correspondiente al 
         * nuevo gerente asignado. 
         * Ademas actualiza el historico para la unidad administrativa a la 
         * que le estamos asignando gerente con el ultimo gerente que tenia asignado. 
         */
        UtilidadesLog.info("MONUnidadesAdministrativasBean.generarHistoricoResponsables" +
                           "(DTOResponsable dtoe): Entrada");
        
        /* Añadido por ssantana, 24/11/2005, SICC-GCC-ZON-003 */
        Long oidGerenteHistorico = new Long(0);
        /* Fin añadido por ssantana, 24/11/2005, SICC-GCC-ZON-003 */

        // sapaza -- PER-SiCC-2011-0928 -- 12/04/2012
        String user = ctx.getCallerPrincipal().getName();
        DAOZON daoZon = new DAOZON();
        
        /* 
         * Comprueba si la unidad administratriva tenia un gerente anterior 
         * y en ese caso actualiza el historico con la fecha hasta 
         */
        HistoricoGerentesLideresLocal historico = null;
        HistoricoGerentesLideresLocalHome historicoHome = this.getHistoricoGerentesLideresLocalHome();
        Collection col = null;
        try {
            historico = historicoHome.findByNoFechaHasta(dtoe.getCodigoUA(),
                                                         dtoe.getOidPais(), 
                                                         dtoe.getOidMarca(), 
                                                         dtoe.getOidCanal());
                                                         
            if(historico.getPeriodoDesde().longValue() != dtoe.getOidPeriodo().longValue()) {                                                         
                RecordSet rsAnt = daoZon.obtenerDatosCampañaAnterior(dtoe.getOidPeriodo());
                Long oidPeriodoHasta = null;
                Date fechaFinPeriodo = null;
                
                if(rsAnt!=null && !rsAnt.esVacio()) {
                    if (rsAnt.getValueAt(0, "OID_PERI") != null) {
                        oidPeriodoHasta = new Long(rsAnt.getValueAt(0, "OID_PERI").toString());
                    }
                    if (rsAnt.getValueAt(0, "FEC_FINA") != null) {
                        fechaFinPeriodo = (java.sql.Date)rsAnt.getValueAt(0, "FEC_FINA");
                    }
                    
                    historico.setPeriodoHasta(oidPeriodoHasta);
                    historico.setFechaHasta(new Timestamp(fechaFinPeriodo.getTime()));
                }

                historico.setIndDesvinculacion(new Long(0));
                historico.setUsuario(user);
                historico.setFechaModificacion(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
            
                historicoHome.merge(historico);
                oidGerenteHistorico = historico.getOid();
            } else {
                historicoHome.remove(historico);
            }
            
        } catch (NoResultException fe) {//jrivas 21/4/2006 ZON-03 Ahora se inserta en historico el gerente anterior.
            /*UtilidadesLog.debug("****Metodo  generarHistoricoResponsables: "+
                                "no existe histórico, lo creo");

            if (oidGerenteAnterior != null)  {
                ClienteDatosBasicosLocalHome clienteLocalHome = this.getClienteDatosBasicosLocalHome();
                ClienteDatosBasicosLocal clienteLocal;
                try {
                    clienteLocal = clienteLocalHome.findByPrimaryKey(oidGerenteAnterior);
                } catch (NoResultException fe2) {
                    ExcepcionParametrizada ep = new ExcepcionParametrizada("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.NO_EXISTE_CLIENTE_RESPONSABLE));
                    ep.addParameter(dtoe.getCodigoResponsable());
                    ep.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    throw ep;
                }
    
    
    //(new Date(System.currentTimeMillis()).getTime())-60000
                try {
                    Timestamp hoy = new Timestamp(new Date(System.currentTimeMillis()).getTime());
                    historico = historicoHome.create(dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal(),
                                        dtoe.getCodigoUA(), clienteLocal.getCod_clie(), new Timestamp((new Date(System.currentTimeMillis()).getTime()-60000))); 
                                        //se le descuenta 1 minuto para que no se pise con el que voy a insertar para el nuevo gerente
                    
                    historico.setFechaHasta(hoy);
                    historicoHome.merge(historico);
                } catch (PersistenceException ex) {
                    UtilidadesLog.debug("Error al crearlo", ex);            
                }                    
            }*/
            
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 

        //validamos el acceso
        MONValidacion monValidacion = this.getMONValidacion();

        try {
            if (!(monValidacion.validarAccesos(dtoe.getOidPais(), null, 
                        dtoe.getOidMarca(), dtoe.getOidCanal(), null, null, null,
                        null, null, null, null)).booleanValue()) {
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
            }
        } catch (RemoteException re) {
            UtilidadesLog.error("grabarMovimientoAlmacenYStock: "+
                                "RemoteException, validarAccesos",re);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        //<inicio>Si se tiene responsable se guarda el historico, incidencia SiCC-20070205
        if(dtoe.getOidResponsable() != null) {
            try {
              /* Genera la entrada en el historico para el nuevo gerente */
              historico = historicoHome.create(dtoe.getOidPais(), 
                                   dtoe.getOidMarca(), 
                                   dtoe.getOidCanal(), 
                                   dtoe.getCodigoUA(), 
                                   dtoe.getCodigoResponsable(), 
                                   new Timestamp(dtoe.getFechaProceso().getTime())); 
                                   
              historico.setPeriodoDesde(dtoe.getOidPeriodo());
              historico.setIndDesvinculacion(new Long(0));
              historico.setUsuario(user);
              historico.setFechaModificacion(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
              historicoHome.merge(historico);                                   
              
            } catch (NoResultException ce) {
                UtilidadesLog.error(ce);
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(ce, 
                                      UtilidadesError.armarCodigoError(codigoError));		
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        //<fin>incidencia SiCC-20070205
        
        UtilidadesLog.info("MONUnidadesAdministrativasBean." + 
                           "generarHistoricoResponsables (DTOResponsable dtoe): " + 
                           "Salida");
        return oidGerenteHistorico;        
    }




    private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONPeriodos(): Entrada");
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome("MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONPeriodos(): Salida");   
        return ejb;
	}
    
     private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONValidacion(): Entrada");
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome("MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONUnidadesAdministrativasBean.getMONValidacion(): Salida");
        return ejb;
	}


  /**
   * @author: ssantana, 28/11/2005, SICC-GCC-ZON-003
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida dtoSalida
   * @param DTOOID dtoOid
   */
  public DTOSalida obtenerDetalleResponsable(DTOOID dtoOid) throws MareException {
    UtilidadesLog.info("MONUnidadesAdministrativas.obtenerDetalleResponsable" +
                      "(DTOOID dtoOid):Entrada");
                      
    DAOZON daoZon = new DAOZON();
    DTOSalida dtoSalida = new DTOSalida();
    
    Long oidIdioma = dtoOid.getOidIdioma();
    Long oidCliente = dtoOid.getOid();
    RecordSet rResponsable = daoZon.obtenerDetalleResponsable(oidCliente, 
                                                              oidIdioma);    
    dtoSalida.setResultado(rResponsable);

    UtilidadesLog.info("MONUnidadesAdministrativas.obtenerDetalleResponsable" +
                      "(DTOOID dtoOid):Salida");
    return dtoSalida;
  }

    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       28/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    public DTOSalida recargaSeccionesCliente(DTOUnidadAdministrativa dto) throws MareException {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaSeccionesCliente(DTOUnidadAdministrativa dto): Entrada");            
        String user = ctx.getCallerPrincipal().getName();
        DAOUnidadesAdministrativas dao = new DAOUnidadesAdministrativas(user);
        DTOSalida dtoSalida = dao.recargaSeccionesCliente(dto);    
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaSeccionesCliente(DTOUnidadAdministrativa dto): Salida");
        return dtoSalida;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       28/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    public DTOSalida recargaZonasCliente(DTOUnidadAdministrativa dto) throws MareException  {
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaZonasCliente(DTOUnidadAdministrativa dto): Entrada");                    
        String user = ctx.getCallerPrincipal().getName();
        DAOUnidadesAdministrativas dao = new DAOUnidadesAdministrativas(user);
        DTOSalida dtoSalida = dao.recargaZonasCliente(dto);
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaZonasCliente(DTOUnidadAdministrativa dto): Salida");            
        return dtoSalida;
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       28/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    public DTOSalida recargaRegionesCliente(DTOUnidadAdministrativa dto) throws MareException   {    
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaRegionesCliente(DTOUnidadAdministrativa dto): Entrada");                        
        String user = ctx.getCallerPrincipal().getName();
        DAOUnidadesAdministrativas dao = new DAOUnidadesAdministrativas(user);
        DTOSalida dtoSalida = dao.recargaRegionesCliente(dto);
        UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaRegionesCliente(DTOUnidadAdministrativa dto): Salida");            
        return dtoSalida;
    }    

   /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       31/3/2006
    * @version     1.0
    * @autor       Cristian Valenzuela
    */
    public DTOSalida recargaUnidadesAdministrativasCliente(DTOUnidadAdministrativa dtoe) 
    throws MareException {         
      UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaUnidadesAdministrativasCliente(DTOUnidadAdministrativa dto): Entrada");                        
      String user = ctx.getCallerPrincipal().getName();
      DAOUnidadesAdministrativas dao = new DAOUnidadesAdministrativas(user);
      DTOSalida dtoSalida = dao.recargaUnidadesAdministrativasCliente(dtoe);
      UtilidadesLog.info("MONUnidadesAdministrativasBean.recargaUnidadesAdministrativasCliente(DTOUnidadAdministrativa dto): Salida");            
      return dtoSalida;        
    }
    
      private String convertirStringTOStringComas(String cadena) throws MareException {
        //Recibe un string separado por x y ldevuelve un string separado por comas
           StringTokenizer st = new StringTokenizer(cadena, "x");
           String cadenaSalida = new String();
           while (st.countTokens()> 0) {
              cadenaSalida = cadenaSalida + st.nextToken();
              if(cadenaSalida!=null){
                 cadenaSalida = cadenaSalida + ",";
              }
           }
           
           cadenaSalida = cadenaSalida.substring(0, cadenaSalida.length() -1);
           return cadenaSalida;
      }    

    public DTOSalida recargarZonasReg(DTOString dto) throws MareException {
         UtilidadesLog.info(" MONUnidadesAdministrativasBean.recargarZonasReg(DTOString) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
         query.append(" SELECT  zona.oid_zona  || '@' || TO_CHAR (zona.zorg_oid_regi)  || '$' || TO_CHAR (zona.des_zona)  oid_zona, zona.des_zona DESZON_REG  ");
         query.append(" FROM zon_zona zona  ");
         query.append(" WHERE zona.ind_acti = 1 ");
         query.append(" AND zona.ind_borr = 0 ");
         //query.append(" AND zona.ZORG_OID_REGI in(" + convertirStringTOStringComas(dto.getCadena()) + ") ");
         query.append(" and zona.PAIS_OID_PAIS = " + dto.getOidPais());
         query.append(" ORDER BY zona.des_zona ");
                   
         try{
              rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("MONUnidadesAdministrativasBean.recargarZonasReg(DTOString dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;
    }
    
    private RegionLocalHome getRegionLocalHome() {
        return new RegionLocalHome();        
    }
    
    private SeccionLocalHome getSeccionLocalHome() {
        return new SeccionLocalHome();
    }
    
    private SubGerenciaVentaLocalHome getSubGerenciaVentaLocalHome() {
        return new SubGerenciaVentaLocalHome();
    }
    
    private ZonaLocalHome getZonaLocalHome() {
        return new ZonaLocalHome();
    }

    private EstadoZonaLocalHome getEstadoZonaLocalHome() {
        return new EstadoZonaLocalHome();
    }
    
    private PaisLocalHome getPaisLocalHome() {
        return new PaisLocalHome();
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }
    
    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
        return new PeriodoCorporativoLocalHome();
    }
    
    private HistoricoGerentesLideresLocalHome getHistoricoGerentesLideresLocalHome() {
        return new HistoricoGerentesLideresLocalHome();
    }

}