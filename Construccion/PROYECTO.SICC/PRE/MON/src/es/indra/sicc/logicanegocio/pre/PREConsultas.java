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
 */

package es.indra.sicc.logicanegocio.pre;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.cra.DTOCriteriosPeriodo;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.pre.*;
import es.indra.sicc.dtos.pre.DTOEstrategia;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOSCriteriosCondicionOferta;
import es.indra.sicc.dtos.pre.DTOTipoEstrategia;
import es.indra.sicc.logicanegocio.bel.MONGestionFormasPagoDetalle;
import es.indra.sicc.logicanegocio.bel.MONGestionFormasPagoDetalleHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.DAOMAEConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.DAOMAEProductos;
import es.indra.sicc.logicanegocio.pre.MONConfiguracionMF;
import es.indra.sicc.logicanegocio.pre.MONConfiguracionMFHome;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

/*
 * rgiorgi - 19/8/2005: se formatea la clase
 * */
/**
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */  
public class PREConsultas {


    private SessionContext ctx;
    private String usuario;

    public PREConsultas(String newusuario) {
        UtilidadesLog.info("PREConsultas.PREConsultas(String newusuario): Entrada");
        setUsuario(newusuario);
        UtilidadesLog.info("PREConsultas.PREConsultas(String newusuario): Salida");
    }

    public PREConsultas() {
    }

    public PREConsultas(SessionContext context) {
        UtilidadesLog.info("PREConsultas.PREConsultas(SessionContext context): Entrada");
        this.ctx = context;
        UtilidadesLog.info("PREConsultas.PREConsultas(SessionContext context): Salida");
    }

    public void setUsuario(String newUser) {
        UtilidadesLog.info("PREConsultas.setUsuario(String newUser): Entrada");
        usuario = newUser;
        UtilidadesLog.info("PREConsultas.setUsuario(String newUser): Salida");
    }

    public String getUsuario() {
        UtilidadesLog.info("PREConsultas.getUsuario(): Entrada");
        UtilidadesLog.info("PREConsultas.getUsuario(): Salida");
        return usuario;
    }

    public DTOSalida cargarPeriodos(DTOPeriodo dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarPeriodos(DTOPeriodo dto): Entrada");
        
        try {
            MONPeriodos mP = getMONPeriodosHome().create();

            DTOCriteriosPeriodo dtoe = new DTOCriteriosPeriodo();
            dtoe.setCanal(dto.getCanal());
            dtoe.setMarca(dto.getMarca());
            dtoe.setPais(dto.getPais());
            dtoe.setOidPais(dto.getOidPais());

            DTOSalida dtoS = mP.obtienePeriodosConsulta(dtoe);
            RecordSet r = dtoS.getResultado();

            if (r.getRowCount() == 0) {
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            int oid = r.getColumnPosition("OID");
            int desc = r.getColumnPosition("VAL_NOMB_PERI");
            int columcount = r.getColumnCount() - 1;

            for (int i = columcount; i >= 0; i--) {
                if (!((i == oid) || (i == desc))) {
                    r.removeColumn(i);
                }
            }

            r.interchangeColumns(0, 1);

            dtoS.setResultado(r);
            
            UtilidadesLog.info("PREConsultas.cargarPeriodos(DTOPeriodo dto): Salida");
            return dtoS;
            
        } catch (NamingException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    public DTOSalida cargarIndicadoresCuadrePorTipoEstrategia(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarIndicadoresCuadrePorTipoEstrategia(DTOOID dtoe): Entrada");
        
        //obtengo el tipo de estrategia
        StringBuffer query0 = new StringBuffer();
        StringBuffer query = new StringBuffer();
        RecordSet rSetAux = new RecordSet();
        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        query0.append("SELECT estrateg.TIES_OID_TIPO_ESTR ");
        query0.append(" FROM PRE_ESTRA estrateg");
        query0.append(" WHERE estrateg.OID_ESTR = '" + dtoe.getOid() + "'");

        try {
            rSetAux = belcorpService.getInstance().dbService.executeStaticQuery(query0.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        query.append("SELECT indicCuadTipEstr.INDC_OID_INDI_CUAD, i18n.VAL_I18N, ");
        query.append(" indicCuadTipEstr.OID_IND_CUAD_TIPO_ESTR, indicCuadTipEstr.IND_OFER_MONO_GRUP ");
        query.append(" FROM PRE_INDIC_CUADR_TIPO_ESTRA indicCuadTipEstr, V_GEN_I18N_SICC i18n,");
        query.append(" PRE_INDIC_CUADR indicCuad");
        query.append(" WHERE indicCuadTipEstr.TIES_OID_TIPO_ESTR = '" + BigDecTolong((BigDecimal) rSetAux.getValueAt(0, 0)) + "'");
        query.append(" AND indicCuadTipEstr.INDC_OID_INDI_CUAD = indicCuad.OID_IND_CUAD");
        query.append(" AND indicCuad.OID_IND_CUAD = i18n.VAL_OID");
        query.append(" AND i18n.IDIO_OID_IDIO = '" + dtoe.getOidIdioma() + "'");
        query.append(" AND i18n.ATTR_ENTI = 'PRE_INDIC_CUADR'");
        query.append(" ORDER BY i18n.VAL_I18N");

        belcorpService = null;

        try {
            rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        DTOSalida dto = new DTOSalida();
        dto.setResultado(rSet);
        
        UtilidadesLog.info("PREConsultas.cargarIndicadoresCuadrePorTipoEstrategia(DTOOID dtoe): Salida");
        return dto;
    }
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoe
     * 
     * pperanzola - 12/10/2005 - [1] se modifica segun SICC-DMCO-PRE_MAE_INT-GCC-001
     * pperanzola - 03/11/2005 - [2] se modifica según peer review inc=BELC300021579
     */
    public DTOSCargarCriteriosDefinirOferta cargarCriteriosDefinirOferta(
           DTOECargarCriteriosDefinirOferta dtoe) throws MareException {
           
        UtilidadesLog.info("PREConsultas.cargarCriteriosDefinirOferta" + 
                           "(DTOECargarCriteriosDefinirOferta dtoe): Entrada");
        
        DTOSCargarCriteriosDefinirOferta criterioGral = new DTOSCargarCriteriosDefinirOferta();

        RecordSet rsAux = new RecordSet();

        RecordSet rsAccesos = new RecordSet();
        RecordSet rsArgVta = new RecordSet();
        RecordSet rsIndicCuadre = new RecordSet();
        RecordSet rsTipoClien = new RecordSet();
        RecordSet rsPosibStatClient = new RecordSet();
        RecordSet rsFormasPago = new RecordSet();
        RecordSet rsMoneda = new RecordSet();
        RecordSet rsCondicProm = new RecordSet();
        RecordSet rsTiposOferta = new RecordSet();
        RecordSet rsCiclosVida = new RecordSet();

        //////////////////////////////////////////
        //1-Accesos
        //obtengo periodo
        StringBuffer query0 = new StringBuffer();
        query0.append("SELECT mfcabecera.PERD_OID_PERI");
        query0.append(" FROM PRE_MATRI_FACTU_CABEC mfcabecera");
        query0.append(" WHERE mfcabecera.OID_CABE = '" + dtoe.getOidCabeceraMF() + "'");

        BelcorpService belcorpService = null;

        try {
            rsAux = belcorpService.
                                    getInstance().dbService.executeStaticQuery(query0.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e
                                    , UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //busco dentro de accesos
        StringBuffer query = new StringBuffer();
        query.append(" select acces.OID_ACCE, i18n.VAL_I18N ");
        query.append(" from CRA_PERIO peri, VCA_SEG_ACCES acces , V_GEN_I18N_SICC i18n ");
        query.append(" where peri.OID_PERI = " );
        query.append(BigDecTolong((BigDecimal) rsAux.getValueAt(0, 0)));
        query.append(" and acces.CANA_OID_CANA = peri.CANA_OID_CANA ");
        query.append(" and acces.COD_USUA = '" + this.getUsuario() + "' ");
        query.append(" and i18n.IDIO_OID_IDIO = '" + dtoe.getOidIdioma() + "'");
        query.append(" AND i18n.VAL_OID = acces.OID_ACCE");
        query.append(" AND i18n.ATTR_ENTI = 'SEG_ACCES'");
        query.append(" ORDER BY i18n.VAL_I18N ");

        belcorpService = null;

        try {
            rsAccesos = belcorpService.
                                            getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //2-Argumentos de Vta.
        StringBuffer query1 = new StringBuffer();

        query1.append(" SELECT argvta.OID_ARGU_VENT, " );
        query1.append(" i18n.VAL_I18N, argvta.TIES_OID_TIPO_ESTR, argvta.COD_ARGU_VENT ");
        query1.append(" FROM PRE_ARGUM_VENTA argvta, V_GEN_I18N_SICC i18n");
        query1.append(" WHERE i18n.IDIO_OID_IDIO = '" + dtoe.getOidIdioma() + "'");
        query1.append(" AND i18n.VAL_OID = argvta.OID_ARGU_VENT");
        query1.append(" AND i18n.ATTR_ENTI = 'PRE_ARGUM_VENTA'");
        query1.append(" ORDER BY i18n.VAL_I18N");

        belcorpService = null;

        try {
            rsArgVta = belcorpService.
                                            getInstance().dbService.executeStaticQuery(query1.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);    
            throw new MareException(e
                                    ,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //3-Indicadores de cuadre 
        try {
            DTOOID dtoOID = new DTOOID();
            dtoOID.setOid(dtoe.getOidEstrategia());
            dtoOID.setOidPais(dtoe.getOidPais());
            dtoOID.setOidIdioma(dtoe.getOidIdioma());
            rsIndicCuadre = cargarIndicadoresCuadrePorTipoEstrategia(dtoOID).getResultado();
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //4-Tipos de cliente
        DAOMAEConfiguracionClientes dmcc = new DAOMAEConfiguracionClientes(this.getUsuario());
        rsTipoClien = dmcc.obtenerTipos(dtoe);

        DTOSalida dtosCliente = new DTOSalida();
        dtosCliente.setResultado(rsTipoClien);

        //5-Status Cliente
        StringBuffer query2 = new StringBuffer();

        query2.append(" SELECT estat.OID_ESTA_CLIE, i18n.VAL_I18N");
        query2.append(" FROM MAE_ESTAT_CLIEN estat, V_GEN_I18N_SICC i18n");
        query2.append(" WHERE estat.OID_ESTA_CLIE = i18n.VAL_OID");
        query2.append(" AND i18n.IDIO_OID_IDIO = '" + dtoe.getOidIdioma() + "'");
        query2.append(" AND i18n.ATTR_ENTI = 'MAE_ESTAT_CLIEN'");
        query2.append(" ORDER BY i18n.VAL_I18N");

        belcorpService = null;

        try {
            rsPosibStatClient = belcorpService.
                                                    getInstance().dbService.executeStaticQuery(query2.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        DTOSalida dtosStatCliente = new DTOSalida();
        dtosStatCliente.setResultado(rsPosibStatClient);

        //6-Formas de Pago
        try {
            MONGestionFormasPagoDetalle mgfpd = getMONGestionFormasPagoDetalleHome().create();
            rsFormasPago = mgfpd.obtenerFormasPagoPorPais(dtoe);

            /*if (rsFormasPago.getRowCount()==0)
                throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
               */
        } catch (NamingException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        //7-Tipos de estrategia 
        //obtengo el tipo de estrategia desde estrategia
        StringBuffer queryEstr = new StringBuffer();
        RecordSet rSetEstr = new RecordSet();
        belcorpService = null;

        queryEstr.append("SELECT estrateg.TIES_OID_TIPO_ESTR ");
        queryEstr.append(" FROM PRE_ESTRA estrateg");
        queryEstr.append(" WHERE estrateg.OID_ESTR = '" + dtoe.getOidEstrategia() + "'");

        try {
            rSetEstr = belcorpService.
                                        getInstance().dbService.executeStaticQuery(queryEstr.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //tipo de estrategia
        StringBuffer queryTipoEstr = new StringBuffer();
        RecordSet rSetTipoEstr = new RecordSet();
        belcorpService = null;

        queryTipoEstr.append("SELECT tipoestr.OID_TIPO_ESTR, ");
        queryTipoEstr.append(" tipoestr.COD_TIPO_ESTR, tipoestr.DES_TIPO_ESTR, ");
        queryTipoEstr.append(" tipoestr.IND_ESTR_COND,");
        queryTipoEstr.append(" tipoestr.IND_ESTR_GRUP, tipoestr.IND_ESTR_PAQU, ");
        queryTipoEstr.append(" tipoestr.IND_ESTR_VS");
        queryTipoEstr.append(" FROM PRE_TIPO_ESTRA tipoestr");
        queryTipoEstr.append(" WHERE tipoestr.OID_TIPO_ESTR = '" );
        queryTipoEstr.append(BigDecTolong((BigDecimal) rSetEstr.getValueAt(0, 0)) + "'");

        try {
            rSetTipoEstr = belcorpService.
                                            getInstance().dbService.executeStaticQuery(queryTipoEstr.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        DTOTipoEstrategia dtote = new DTOTipoEstrategia();
        dtote.setCodigoTipoEstrategia(rSetTipoEstr.getValueAt(0, 1).toString());
        dtote.setDescripcion(rSetTipoEstr.getValueAt(0, 2).toString());
        dtote.setEstrategiaCondicionada(BigDecToBool((BigDecimal) rSetTipoEstr.getValueAt(0, 3)));
        dtote.setEstrategiaGrupo(BigDecToBool((BigDecimal) rSetTipoEstr.getValueAt(0, 4)));
        dtote.setEstrategiaPaquetes(BigDecToBool((BigDecimal) rSetTipoEstr.getValueAt(0, 5)));
        dtote.setEstrategiaVS(BigDecToBool((BigDecimal) rSetTipoEstr.getValueAt(0, 6)));
        dtote.setOid(BigDecToLong((BigDecimal) rSetTipoEstr.getValueAt(0, 0)));

        //8-Estrategia 
        StringBuffer queryEstr1 = new StringBuffer();
        RecordSet rSetEstr1 = new RecordSet();
        belcorpService = null;

        queryEstr1.append("SELECT estrateg.COD_ESTR, ");
        queryEstr1.append("estrateg.IND_CUAD_GRUP, estrateg.IND_CV_DESP_AUTO,");
        queryEstr1.append(" estrateg.IND_CV_DIGI, estrateg.IND_CV_IMPR, ");
        queryEstr1.append(" estrateg.IND_LIST_RANK, estrateg.NUM_MAXI_GRUP,");
        queryEstr1.append(" estrateg.NUM_MAXI_GRUP_CNDO, estrateg.NUM_MAXI_GRUP_CNDT, ");
        queryEstr1.append(" estrateg.IND_MODI_DESP,");
        queryEstr1.append(" estrateg.IND_MODI_DIGI, estrateg.IND_MODI_IMPR, ");
        queryEstr1.append(" estrateg.PAIS_OID_PAIS, estrateg.TIES_OID_TIPO_ESTR,");
        queryEstr1.append(" estrateg.TIPR_OID_TIPO_PROD");
        queryEstr1.append(" FROM PRE_ESTRA estrateg");
        queryEstr1.append(" WHERE estrateg.OID_ESTR = '" + dtoe.getOidEstrategia() + "'");

        try {
            rSetEstr1 = belcorpService.
                                        getInstance().dbService.executeStaticQuery(queryEstr1.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        DTOEstrategia dtoex = new DTOEstrategia();

        dtoex.setCodigo(rSetEstr1.getValueAt(0, 0).toString());
        dtoex.setCuadreGrupos(BigDecToBool((BigDecimal) rSetEstr1.getValueAt(0, 1)));
        dtoex.setCvDespachoAutomatico(BigDecToBool((BigDecimal) rSetEstr1.getValueAt(0, 2)));
        dtoex.setCvDigitable(BigDecToBool((BigDecimal) rSetEstr1.getValueAt(0, 3)));
        dtoex.setCvImprimible(BigDecToBool((BigDecimal) rSetEstr1.getValueAt(0, 4)));
        dtoex.setListaRanking(BigDecToBool((BigDecimal) rSetEstr1.getValueAt(0, 5)));
        dtoex.setMaxGrupos(BigDecToInt((BigDecimal) rSetEstr1.getValueAt(0, 6)));
        dtoex.setMaxGruposCondicionados(BigDecToInt((BigDecimal) rSetEstr1.getValueAt(0, 7)));
        dtoex.setMaxGruposCondicionantes(BigDecToInt((BigDecimal) rSetEstr1.getValueAt(0, 8)));
        dtoex.setModificableDespachoAutomatico(BigDecToBool((BigDecimal) rSetEstr1.getValueAt(0, 9)));
        dtoex.setModificableDigitable(BigDecToBool((BigDecimal) rSetEstr1.getValueAt(0, 10)));
        dtoex.setModificableImprimible(BigDecToBool((BigDecimal) rSetEstr1.getValueAt(0, 11)));
        dtoex.setOid(dtoe.getOidEstrategia());
        dtoex.setOidPais(BigDecToLong((BigDecimal) rSetEstr1.getValueAt(0, 12)));
        dtoex.setOidTipoEstr(BigDecToLong((BigDecimal) rSetEstr1.getValueAt(0, 13)));
        dtoex.setOidTipoProd(BigDecToLong((BigDecimal) rSetEstr1.getValueAt(0, 14)));

        //9-Moneda
        //mas alla del M de C, se entra tambien con marca y canal (aparte de pais), para lo cual vamos a periodo
        StringBuffer query3 = new StringBuffer();
        StringBuffer query3a = new StringBuffer();

        //obtengo marca-canal, desde cra-perio
        RecordSet rsMonedaAux = new RecordSet();

        query3.append("SELECT perio.MARC_OID_MARC, perio.CANA_OID_CANA");
        query3.append(" FROM CRA_PERIO perio");
        query3.append(" WHERE OID_PERI = '" );
        query3.append(BigDecTolong((BigDecimal) rsAux.getValueAt(0, 0)) + "'");

        belcorpService = null;

        try {
            rsMonedaAux = belcorpService.
                                            getInstance().dbService.executeStaticQuery(query3.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        query3a.append(" SELECT confmfpais.MONE_OID_MONE, i18n.VAL_I18N");
        query3a.append(" FROM PRE_CONFI_MF_PAIS confmfpais, ");
        query3a.append(" V_GEN_I18N_SICC i18n, SEG_MONED moneda");
        query3a.append(" WHERE confmfpais.PAIS_OID_PAIS = '" + dtoe.getOidPais() + "'");
        query3a.append(" AND confmfpais.MARC_OID_MARC = '");
        query3a.append(BigDecTolong((BigDecimal) rsMonedaAux.getValueAt(0, 0)) + "'");
        query3a.append(" AND confmfpais.CANA_OID_CANA = '");
        query3a.append(BigDecTolong((BigDecimal) rsMonedaAux.getValueAt(0, 1)) + "'");
        query3a.append(" AND confmfpais.MONE_OID_MONE = moneda.OID_MONE");
        query3a.append(" AND i18n.VAL_OID = moneda.OID_MONE");
        query3a.append(" AND i18n.IDIO_OID_IDIO = '" + dtoe.getOidIdioma() + "'");
        query3a.append(" AND i18n.ATTR_ENTI = 'SEG_MONED'");
        query3a.append(" ORDER BY i18n.VAL_I18N");

        belcorpService = null;

        try {
            rsMoneda = belcorpService.
                                        getInstance().dbService.executeStaticQuery(query3a.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //10-Condición de la promocion
        StringBuffer query4 = new StringBuffer();

        query4.append(" SELECT condpromo.OID_COND_PROM, i18n.VAL_I18N");
        query4.append(" FROM PRE_CONDI_PROMO condpromo, V_GEN_I18N_SICC i18n");
        query4.append(" WHERE condpromo.OID_COND_PROM = i18n.VAL_OID");
        query4.append(" AND i18n.IDIO_OID_IDIO = '" + dtoe.getOidIdioma() + "'");
        query4.append(" AND i18n.ATTR_ENTI = 'PRE_CONDI_PROMO'");
        query4.append(" ORDER BY i18n.VAL_I18N");
        belcorpService = null;

        try {
            rsCondicProm = belcorpService.
                                            getInstance().dbService.executeStaticQuery(query4.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //11-Tipo oferta
        StringBuffer query5 = new StringBuffer();

        query5.append(" SELECT tipoofert.OID_TIPO_OFER, ");
        query5.append(" i18n.VAL_I18N, tipoofert.IND_COMI, ");
        query5.append(" tipoofert.IND_PUNT, tipoofert.IND_ESTA,");
        query5.append(" tipoofert.IND_MONT_MINI, tipoofert.IND_APOR_MONT_ESCA");
        query5.append(" FROM PRE_TIPO_OFERT tipoofert, V_GEN_I18N_SICC i18n");
        query5.append(" WHERE tipoofert.CANA_OID_CANA = '");
        query5.append(BigDecTolong((BigDecimal) rsMonedaAux.getValueAt(0, 1)) + "'");
        query5.append(" AND i18n.VAL_OID = tipoofert.OID_TIPO_OFER");
        query5.append(" AND i18n.IDIO_OID_IDIO = '" + dtoe.getOidIdioma() + "'");
        query5.append(" AND i18n.ATTR_ENTI = 'PRE_TIPO_OFERT'");
        query5.append(" ORDER BY i18n.VAL_I18N");
        belcorpService = null;

        try {
            rsTiposOferta = belcorpService.
                                                getInstance().dbService.executeStaticQuery(query5.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //12-Ciclos de vida
        StringBuffer query6 = new StringBuffer();

        query6.append(" SELECT ciclovida.OID_CICL_VIDA, i18n.VAL_I18N");
        query6.append(" FROM PRE_CICLO_VIDA ciclovida, V_GEN_I18N_SICC i18n");
        query6.append(" WHERE i18n.VAL_OID = ciclovida.OID_CICL_VIDA");
        query6.append(" AND i18n.IDIO_OID_IDIO = '" + dtoe.getOidIdioma() + "'");
        query6.append(" AND i18n.ATTR_ENTI = 'PRE_CICLO_VIDA'");
        query6.append(" ORDER BY i18n.VAL_I18N");

        belcorpService = null;

        try {
            rsCiclosVida = belcorpService.
                                            getInstance().dbService.executeStaticQuery(query6.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        // /*[1]
        //13 - Programas de Fidelizacion 
        StringBuffer queryProgFide = new StringBuffer();
        RecordSet rsProgFide = null;
        queryProgFide.append(" select OID_PROG_FIDE,DES_PROG_FIDE, ");
        queryProgFide.append(" COD_PROG_FIDE from MAE_PROGR_FIDEL");

        belcorpService = null;

        try {
            rsProgFide = belcorpService.
                                            getInstance().dbService.executeStaticQuery(queryProgFide.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        //14 - Variantes
        StringBuffer queryVaria = new StringBuffer();
        RecordSet rsVaria = null;
        queryVaria.append(" select OID_VARI,DES_VARI,IND_PUNT from PRE_VARIA ");

        belcorpService = null;

        try {
            rsVaria = belcorpService.
                                            getInstance().dbService.executeStaticQuery(queryVaria.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        // */[1]

        criterioGral.setAccesos(rsAccesos);
        criterioGral.setArgumentosVenta(rsArgVta);
        criterioGral.setCiclosVida(rsCiclosVida);
        criterioGral.setCondiciones(rsCondicProm);

        if (!rsMoneda.esVacio()) {
            criterioGral.setOidMoneda(BigDecToLong(
                                            (BigDecimal) rsMoneda.getValueAt(0, "MONE_OID_MONE")));
            criterioGral.setDescripcionMoneda(rsMoneda.getValueAt(0, "VAL_I18N").toString());
        }

        criterioGral.setEstatus(rsPosibStatClient);
        criterioGral.setEstrategia(dtoex);
        criterioGral.setFormasPago(rsFormasPago);
        criterioGral.setIndicadoresCuadre(rsIndicCuadre);
        criterioGral.setTipoEstrategia(dtote);
        criterioGral.setTiposCliente(rsTipoClien);
        criterioGral.setTiposOferta(rsTiposOferta);
        
        // /*[1]
        criterioGral.setProgramaFidelizacion(rsProgFide);
        criterioGral.setVariantes(rsVaria);
        // */[1]
        
        //15 Marca y Canal
         //8-Estrategia 
         StringBuffer queryEstr15 = new StringBuffer();
         RecordSet rSetEstr15 = new RecordSet();
         belcorpService = null;

         queryEstr15.append("SELECT PERI.MARC_OID_MARC MARCA, PERI.CANA_OID_CANA CANAL ");
         queryEstr15.append("FROM CRA_PERIO PERI, PRE_MATRI_FACTU_CABEC MFC ");
         queryEstr15.append("WHERE PERI.OID_PERI = MFC.PERD_OID_PERI ");
         queryEstr15.append("AND MFC.OID_CABE =  '" + dtoe.getOidCabeceraMF() + "'");

         try {
             rSetEstr15 = belcorpService.
                                         getInstance().dbService.executeStaticQuery(queryEstr15.toString());
         } catch (MareException me) {
             UtilidadesLog.error(me);
             throw me;
         } catch (Exception e) {
             UtilidadesLog.error(e);
             throw new MareException(e, 
                                     UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
         
         criterioGral.setOidMarca(BigDecToLong((BigDecimal) rSetEstr15.getValueAt(0, 0)));
         criterioGral.setOidCanal(BigDecToLong((BigDecimal) rSetEstr15.getValueAt(0, 1)));        
        

        UtilidadesLog.info("PREConsultas.cargarCriteriosDefinirOferta" 
                            + "(DTOECargarCriteriosDefinirOferta dtoe): Salida");
        return criterioGral;
    }

    public RecordSet cargarIndicadoresCuadrePromocion(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarIndicadoresCuadrePromocion(DTOBelcorp dto): Entrada");
        
        StringBuffer query = new StringBuffer();
        query.append(" SELECT CuadIndi.OID_INDI_CUAD_PROM, i18n.VAL_I18N ");
        query.append(" FROM PRE_INDIC_CUADR_PROMO CuadIndi,V_GEN_I18N_SICC i18n ");
        query.append(" WHERE i18n.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "' ");
        query.append(" AND CuadIndi.OID_INDI_CUAD_PROM = i18n.VAL_OID ");
        query.append(" AND i18n.ATTR_ENTI = 'PRE_INDIC_CUADR_PROMO' ");
        query.append(" ORDER BY i18n.VAL_I18N");

        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("PREConsultas.cargarIndicadoresCuadrePromocion(DTOBelcorp dto): Salida");
        return rSet;
    }

    public DTOSCriteriosCondicionOferta cargarCriteriosCondicionOferta(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarCriteriosCondicionOferta(DTOBelcorp dto): Entrada");
        
        DTOSCriteriosCondicionOferta cCriterios = new DTOSCriteriosCondicionOferta();
        DTOSalida dtosCatalogos = new DTOSalida();

        cCriterios.setIndicadoresCuadre(cargarIndicadoresCuadrePromocion(dto));
        dtosCatalogos = cargarCatalogos(dto);

        cCriterios.setCatalogos(dtosCatalogos.getResultado());
        
        UtilidadesLog.info("PREConsultas.cargarCriteriosCondicionOferta(DTOBelcorp dto): Salida");
        return cCriterios;
    }

    public static void main(String[] args) {
        UtilidadesLog.info("PREConsultas.main(String[] args): Entrada");
        PREConsultas consultas = new PREConsultas("usuarioharcodeado");
        DTOOID dto = new DTOOID();
        dto.setOid(new Long(1));
        dto.setOidIdioma(new Long(1));

        try {
            UtilidadesLog.info(consultas.cargarTiposOfertaMF(dto));
        } catch (MareException ex) {
            UtilidadesLog.error(ex);
        }
        UtilidadesLog.info("PREConsultas.main(String[] args): Salida");
    }


    public DTOSCargarCriteriosBusquedaProductos cargarCriteriosBusquedaProductos(DTOOID dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarCriteriosBusquedaProductos(DTOOID dto): Entrada");
        Cronometrador.startTransaction("PREConsultas.cargarCriteriosBusquedaProductos");
        try {
            RecordSet rsCatalogos = new RecordSet();
            RecordSet rsMarcas = new RecordSet();
            RecordSet rsLineasProducto = new RecordSet();
            RecordSet rsUnidadesNegocio = new RecordSet();
            RecordSet rsNegocios = new RecordSet();
            RecordSet rsGenericos = new RecordSet();
            RecordSet rsSupergenericos = new RecordSet();
            RecordSet rsEstategias = new RecordSet();

            //1) Llama al método cargarCatalogos de esta clase 
            //y obtiene todos los catalogos definidos para el pais
            DTOBelcorp dtoB = new DTOBelcorp();
            dtoB.setOidPais(dto.getOidPais());
            dtoB.setOidIdioma(dto.getOidIdioma());

            rsCatalogos = this.cargarCatalogos(dtoB).getResultado();

            //2) Recuperamos la marca de la matriz de facturación recibida 
            //DTOOID = Llamar al método MONConfiguracionMF.obtenerMarcaMF(dto) 
            MONConfiguracionMFHome mcmfH = this.getMONConfiguracionMFHome();
            MONConfiguracionMF mcmf = mcmfH.create();
            Cronometrador.startTransaction("mcmf.obtenerMarcaMF");
            DTOOID dtoMarca = mcmf.obtenerMarcaMF(dto);
            Cronometrador.endTransaction("mcmf.obtenerMarcaMF");

            //3) Obtenemos las marcas correspondientes a la marca de la matriz 
            // DTOSalida = Llama al método recuperarMarcasProductoMP(DTOOID) localizado en la 
            // interfaz IServicioSEG y obtiene un DTOSalida con todas las marcas.
            MONMantenimientoSEGHome mmsh = this.getMONMantenimientoSEGHome();
            MONMantenimientoSEG iss = mmsh.create();
            Cronometrador.startTransaction("iss.recuperarMarcasProductoMP");
            rsMarcas = iss.recuperarMarcasProductoMP(dtoMarca).getResultado();
            Cronometrador.endTransaction("iss.recuperarMarcasProductoMP");

            //4) Llama al método buscarLineasProductoPorPais de la clase 
            // DAOMAEProductos y obtiene todas las lineas de producto.
            DAOMAEProductos dmp = new DAOMAEProductos(this.getUsuario());
            Cronometrador.startTransaction("dmp.buscarLineasProductoPorPais");
            rsLineasProducto = dmp.buscarLineasProductoPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarLineasProductoPorPais");

            //5) Llama al método buscarUnidadesNegocioPorPais de la clase DAOMAEProductos 
            // y obtiene todas las unidades de negocio. 
            Cronometrador.startTransaction("dmp.buscarUnidadesNegocioPorPais");
            rsUnidadesNegocio = dmp.buscarUnidadesNegocioPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarUnidadesNegocioPorPais");

            //6) Llama al método buscarNegocioPorPais de la clase DAOMAEProductos 
            //y obtiene todos los negocios.
            Cronometrador.startTransaction("dmp.buscarNegocioPorPais");
            rsNegocios = dmp.buscarNegocioPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarNegocioPorPais");

            //7) Llama al método buscarGenericosPorPais de la clase DAOMAEProductos 
            //y obtiene todos los genericos.
            Cronometrador.startTransaction("dmp.buscarGenericosPorPais");
            rsGenericos = dmp.buscarGenericosPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarGenericosPorPais");

            //8) Llama al método buscarSuperGenericoPorPais de la clase DAOMAEProductos 
            //y obtiene todos los supergenericos.
            Cronometrador.startTransaction("dmp.buscarSuperGenericoPorPais");
            rsSupergenericos = dmp.buscarSuperGenericoPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarSuperGenericoPorPais");

            // 9) Llama al método cargar Estrategias y obtiene las estrategias segun el pais e idioma
            Cronometrador.startTransaction("cargarEstrategias");
            rsEstategias = this.cargarEstrategias(dtoB).getResultado();
            Cronometrador.endTransaction("cargarEstrategias");

            /*10) Crea un DTOSCargarCriteriosBusquedaProductos con:
                  - catalogos
                  - marcas = DTOSalida.resultado
                  - lineasProducto
                  - unidadesNegocio
                  - negocios
                  - genericos
                  - supergenericos
                  - estrategias */
            DTOSCargarCriteriosBusquedaProductos dtos = new DTOSCargarCriteriosBusquedaProductos();
            dtos.setCatalogos(rsCatalogos);
            dtos.setMarcas(rsMarcas);
            dtos.setLineasProducto(rsLineasProducto);
            dtos.setUnidadesNegocio(rsUnidadesNegocio);
            dtos.setNegocios(rsNegocios);
            dtos.setGenericos(rsGenericos);
            dtos.setSupergenericos(rsSupergenericos);
            dtos.setEstrategias(rsEstategias);
            
            UtilidadesLog.info("PREConsultas.cargarCriteriosBusquedaProductos(DTOOID dto): Salida");
            Cronometrador.endTransaction("PREConsultas.cargarCriteriosBusquedaProductos");
            return dtos;            
        } catch (NamingException ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    public DTOSCargarCriteriosBusquedaProductos cargarCriteriosBusquedaProductosMinimo(DTOOID dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarCriteriosBusquedaProductosMinimo(DTOOID dto): Entrada");
        Cronometrador.startTransaction("PREConsultas.cargarCriteriosBusquedaProductosMinimo");
        try {
            RecordSet rsCatalogos = new RecordSet();
            RecordSet rsMarcas = new RecordSet();
            RecordSet rsLineasProducto = new RecordSet();
            RecordSet rsUnidadesNegocio = new RecordSet();
            RecordSet rsNegocios = new RecordSet();
            RecordSet rsGenericos = new RecordSet();
            RecordSet rsSupergenericos = new RecordSet();
            RecordSet rsEstategias = new RecordSet();

            //1) Llama al método cargarCatalogos de esta clase 
            //y obtiene todos los catalogos definidos para el pais
            DTOBelcorp dtoB = new DTOBelcorp();
            dtoB.setOidPais(dto.getOidPais());
            dtoB.setOidIdioma(dto.getOidIdioma());

            rsCatalogos = this.cargarCatalogos(dtoB).getResultado();

            //2) Recuperamos la marca de la matriz de facturación recibida 
            //DTOOID = Llamar al método MONConfiguracionMF.obtenerMarcaMF(dto) 
            MONConfiguracionMFHome mcmfH = this.getMONConfiguracionMFHome();
            MONConfiguracionMF mcmf = mcmfH.create();
            Cronometrador.startTransaction("mcmf.obtenerMarcaMF");
            DTOOID dtoMarca = mcmf.obtenerMarcaMF(dto);
            Cronometrador.endTransaction("mcmf.obtenerMarcaMF");

            //3) Obtenemos las marcas correspondientes a la marca de la matriz 
            // DTOSalida = Llama al método recuperarMarcasProductoMP(DTOOID) localizado en la 
            // interfaz IServicioSEG y obtiene un DTOSalida con todas las marcas.
            MONMantenimientoSEGHome mmsh = this.getMONMantenimientoSEGHome();
            MONMantenimientoSEG iss = mmsh.create();
            Cronometrador.startTransaction("iss.recuperarMarcasProductoMP");
            rsMarcas = iss.recuperarMarcasProductoMP(dtoMarca).getResultado();
            Cronometrador.endTransaction("iss.recuperarMarcasProductoMP");
            // DAOMAEProductos y obtiene todas las lineas de producto.
            DAOMAEProductos dmp = new DAOMAEProductos(this.getUsuario());
            /*
            //4) Llama al método buscarLineasProductoPorPais de la clase 
            Cronometrador.startTransaction("dmp.buscarLineasProductoPorPais");
            rsLineasProducto = dmp.buscarLineasProductoPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarLineasProductoPorPais");
            */
            
            //se descomenta para que cargue el combo de buscar producto en caso de uso Registro Automaticas
            //5) Llama al método buscarUnidadesNegocioPorPais de la clase DAOMAEProductos 
            // y obtiene todas las unidades de negocio. 
            Cronometrador.startTransaction("dmp.buscarUnidadesNegocioPorPais");
            rsUnidadesNegocio = dmp.buscarUnidadesNegocioPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarUnidadesNegocioPorPais");
            
            
            
            //6) Llama al método buscarNegocioPorPais de la clase DAOMAEProductos 
            //y obtiene todos los negocios.
            Cronometrador.startTransaction("dmp.buscarNegocioPorPais");
            rsNegocios = dmp.buscarNegocioPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarNegocioPorPais");


            /*
            //7) Llama al método buscarGenericosPorPais de la clase DAOMAEProductos 
            //y obtiene todos los genericos.
            Cronometrador.startTransaction("dmp.buscarGenericosPorPais");
            rsGenericos = dmp.buscarGenericosPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarGenericosPorPais");

            //8) Llama al método buscarSuperGenericoPorPais de la clase DAOMAEProductos 
            //y obtiene todos los supergenericos.
            Cronometrador.startTransaction("dmp.buscarSuperGenericoPorPais");
            rsSupergenericos = dmp.buscarSuperGenericoPorPais(dtoB);
            Cronometrador.endTransaction("dmp.buscarSuperGenericoPorPais");
            
            */

            // 9) Llama al método cargar Estrategias y obtiene las estrategias segun el pais e idioma
            Cronometrador.startTransaction("cargarEstrategias");
            rsEstategias = this.cargarEstrategias(dtoB).getResultado();
            Cronometrador.endTransaction("cargarEstrategias");

            /*10) Crea un DTOSCargarCriteriosBusquedaProductos con:
                  - catalogos
                  - marcas = DTOSalida.resultado
                  - lineasProducto
                  - unidadesNegocio
                  - negocios
                  - genericos
                  - supergenericos
                  - estrategias */
            DTOSCargarCriteriosBusquedaProductos dtos = new DTOSCargarCriteriosBusquedaProductos();
            dtos.setCatalogos(rsCatalogos);
            dtos.setMarcas(rsMarcas);
            dtos.setLineasProducto(rsLineasProducto);
            dtos.setUnidadesNegocio(rsUnidadesNegocio);
            dtos.setNegocios(rsNegocios);
            dtos.setGenericos(rsGenericos);
            dtos.setSupergenericos(rsSupergenericos);
            dtos.setEstrategias(rsEstategias);
            
            UtilidadesLog.info("PREConsultas.cargarCriteriosBusquedaProductosMinimo(DTOOID dto): Salida");
            Cronometrador.endTransaction("PREConsultas.cargarCriteriosBusquedaProductosMinimo");
            return dtos;            
        } catch (NamingException ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }



    public DTOSalida cargarCatalogos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarCatalogos(DTOBelcorp dto): Entrada");
        
        BelcorpService belcorpService;
        RecordSet rs;
        DTOSalida dtos = new DTOSalida();

        try {
            belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append(" select OID_CATA, DES_CATA from PRE_CATAL ");
            query.append(" where PAIS_OID_PAIS = '" + dto.getOidPais() + "' ORDER BY DES_CATA");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        
        UtilidadesLog.info("PREConsultas.cargarCatalogos(DTOBelcorp dto): Salida");
        return dtos;
    }


    public DTOSalida cargarEstrategias(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarEstrategias(DTOBelcorp dto): Entrada");
        BelcorpService belcorpService;
        RecordSet rs;
        DTOSalida dtos = new DTOSalida();

        try {
            belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();
            query.append(" SELECT estra.OID_ESTR, i18n.VAL_I18N ");
            query.append(" FROM PRE_ESTRA estra, V_GEN_I18N_SICC i18n ");
            query.append(" WHERE estra.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append("  AND i18n.VAL_OID = estra.OID_ESTR ");
            query.append("  AND i18n.ATTR_ENTI = 'PRE_ESTRA' ");
            query.append("  AND i18n.ATTR_NUM_ATRI = 1 ");
            query.append("  AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" ORDER BY i18n.VAL_I18N ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        dtos.setResultado(rs);
        UtilidadesLog.info("PREConsultas.cargarEstrategias(DTOBelcorp dto): Salida");
        return dtos;
    }


    private Long BigDecToLong(BigDecimal nToTransform) {
        UtilidadesLog.info("PREConsultas.BigDecToLong(BigDecimal nToTransform): Entrada");
        
        if (nToTransform != null) {
            UtilidadesLog.info("PREConsultas.BigDecToLong(BigDecimal nToTransform): Salida");
            return new Long(nToTransform.longValue());
        }
        UtilidadesLog.info("PREConsultas.BigDecToLong(BigDecimal nToTransform): Salida");
        return null;
    }

    private Integer BigDecToInt(BigDecimal nToTransform) {
        UtilidadesLog.info("PREConsultas.BigDecToInt(BigDecimal nToTransform): Entrada");    
        if (nToTransform != null) {
            UtilidadesLog.info("PREConsultas.BigDecToInt(BigDecimal nToTransform): Salida");
            return new Integer(nToTransform.toString());
        }
        UtilidadesLog.info("PREConsultas.BigDecToInt(BigDecimal nToTransform): Salida");
        return null;
    }

    private long BigDecTolong(BigDecimal nToTransform) {
        UtilidadesLog.info("PREConsultas.BigDecTolong(BigDecimal nToTransform): Entrada");
        
        long retValue;

        if (nToTransform == null) {
            retValue = 0;
        } else {
            retValue = nToTransform.longValue();
        }
        UtilidadesLog.info("PREConsultas.BigDecTolong(BigDecimal nToTransform): Salida");        
        return retValue;
    }

    private Boolean BigDecToBool(BigDecimal nToTransform) {
        UtilidadesLog.info("PREConsultas.BigDecToBool(BigDecimal nToTransform): Entrada");        
        
        if (nToTransform != null) {
            if (nToTransform.intValue() >= 1) {
                UtilidadesLog.info("PREConsultas.BigDecToBool(BigDecimal nToTransform): Salida");
                return Boolean.TRUE;
            }

            if (nToTransform.intValue() <= 0) {
                UtilidadesLog.info("PREConsultas.BigDecToBool(BigDecimal nToTransform): Salida"); 
                return Boolean.FALSE;
            }
        }
        UtilidadesLog.info("PREConsultas.BigDecToBool(BigDecimal nToTransform): Salida");
        return null;
    }

    public DTOSalida cargarLineasProductos(DTOSiccPaginacion dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarLineasProductos(DTOSiccPaginacion dto): Entrada");
        
        BelcorpService belcorpService;
        RecordSet rs;
        DTOSalida dtos = new DTOSalida();

        try {
            belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append(" SELECT linea.OID_LINE_PROD OID, linea.COD_LINE_PROD CODIGO, i18n.VAL_I18N DESCR ");
            query.append(" FROM MAE_LINEA_PRODU linea,V_GEN_I18N_SICC i18n ");
            query.append(" WHERE i18n.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "' ");
            query.append(" AND linea.OID_LINE_PROD = i18n.VAL_OID ");
            query.append(" AND i18n.ATTR_ENTI = 'MAE_LINEA_PRODU' ");
            query.append(" AND linea.PAIS_OID_PAIS = " + dto.getOidPais());

            rs = belcorpService.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        
        UtilidadesLog.info("PREConsultas.cargarLineasProductos(DTOSiccPaginacion dto): Salida");
        return dtos;
    }

    public DTOSalida cargarTiposOfertaMF(DTOOID dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarTiposOfertaMF(DTOOID dto): Entrada");
        
        RecordSet rs = null;
        DTOSalida dtoSalida = new DTOSalida();

       /* if (dto == null) {
            UtilidadesLog.debug(">>> El dto de entrada es nulo");
        }

        if (dto.getOid() == null) {
            UtilidadesLog.debug(">>> El contenido del dto esta mocho");
        } else {
            UtilidadesLog.debug(">>> El dto contiene: " + dto.getOid());
        }*/

        try {
            StringBuffer query = new StringBuffer();

            query.append("SELECT tipooferta.oid_tipo_ofer oidtipooferta, i18n.val_i18n descripcion ");
            query.append("FROM pre_matri_factu_cabec cabeceramf, ");
            query.append("cra_perio periodo, ");
            query.append("pre_tipo_ofert tipooferta, ");
            query.append("v_gen_i18n_sicc i18n ");
            query.append("WHERE cabeceramf.oid_cabe = " + dto.getOid() + " ");
            query.append("AND cabeceramf.perd_oid_peri = periodo.oid_peri ");
            query.append("AND periodo.cana_oid_cana = tipooferta.cana_oid_cana ");
            query.append("AND i18n.attr_enti = 'PRE_TIPO_OFERT' ");
            query.append("AND i18n.attr_num_atri = 1 ");
            query.append("AND i18n.idio_oid_idio = " + dto.getOidIdioma() + " ");
            query.append("AND i18n.val_oid = tipooferta.oid_tipo_ofer ");

            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());

            /*if (rs.esVacio()) {
                UtilidadesLog.debug(">>> RecordSet de PREConsultas.cargarTipoOfertaMF vacio.");
            } else {
                UtilidadesLog.debug(">>> RecordSet de PREConsultas.cargarTipoOfertaMF cargado.");
            }*/
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("PREConsultas.cargarTiposOfertaMF(DTOOID dto): Salida");
        return dtoSalida;
    }

    public DTOSalida obtenerCiclosVida(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("PREConsultas.obtenerCiclosVida(DTOBelcorp dto): Entrada");
        
        BelcorpService belcorpS = BelcorpService.getInstance();
        RecordSet rs = null;
        DTOSalida dtoSalida = new DTOSalida();
        StringBuffer query = new StringBuffer();

        try {
            query.append("SELECT ciclovida.OID_CICL_VIDA, i18n.VAL_I18N ");
            query.append("FROM pre_ciclo_vida ciclovida, v_gen_i18n_sicc i18n ");
            query.append("WHERE i18n.attr_enti = 'PRE_CICLO_VIDA' ");
            query.append("AND i18n.attr_num_atri = 1 ");
            query.append("AND i18n.idio_oid_idio = " + dtoe.getOidIdioma() + " ");
            query.append("AND i18n.val_oid = ciclovida.oid_cicl_vida ");
            query.append(" ORDER BY i18n.val_i18n ");

            rs = belcorpS.dbService.executeStaticQuery(query.toString());

            dtoSalida.setResultado(rs);
            
            UtilidadesLog.info("PREConsultas.obtenerCiclosVida(DTOBelcorp dto): Salida");
            return dtoSalida;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtenerTiposOfertaPorCanal(DTOOID dto) throws MareException {
        UtilidadesLog.info("PREConsultas.obtenerTiposOfertaPorCanal(DTOOID dto): Entrada");
        
        // DETALLE DEL MODELO DE COMPONENTES. (INTERFAZ DEFINIDA EN MAV)
        // Accede a la entidad TipoOferta y recupera todos los tipos de oferta correspondientes al canal recibido (oidCanal) 
        // Devuelve: 
        // - oidTipoOferta 
        // - descripcion 
        try {            

            BelcorpService belcorpServ = BelcorpService.getInstance();
            RecordSet rs = null;
            StringBuffer query = new StringBuffer();

            query.append(" SELECT tipooferta.oid_tipo_ofer oidTipoOferta, i18n.val_i18n descripcion ");
            query.append(" FROM pre_tipo_ofert tipooferta, v_gen_i18n_sicc i18n ");
            query.append(" WHERE tipooferta.cana_oid_cana = " + dto.getOid() + " ");
            query.append(" AND i18n.attr_enti = 'PRE_TIPO_OFERT' ");
            query.append(" AND i18n.attr_num_atri = 1 ");
            query.append(" AND i18n.idio_oid_idio = " + dto.getOidIdioma() + " ");
            query.append(" AND i18n.val_oid = tipooferta.oid_tipo_ofer");
            query.append(" ORDER BY i18n.val_i18n");

            rs = belcorpServ.dbService.executeStaticQuery(query.toString());

            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            
            UtilidadesLog.info("PREConsultas.obtenerTiposOfertaPorCanal(DTOOID dto): Salida");
            return dtoSalida;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /* Accede a la tabla PRE_TIPO_ESTRA y recupera:
        - OID_TIPO_ESTR
        - DES_TIPO_ESTR
        - IND_ESTR_GRUP
        - IND_ESTR_COND
        - IND_ESTR_VS
        - IND_ESTR_PAQU
        Crea un DTOSalida y lo devuelve
     */
    public DTOSalida obtenerTiposEstrategia(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("PREConsultas.obtenerTiposEstrategia(DTOBelcorp dto): Entrada");
        
        try {
            BelcorpService belcorpServ = BelcorpService.getInstance();
            RecordSet rs = null;
            StringBuffer query = new StringBuffer();

            query.append("SELECT tipoestragia.oid_tipo_estr oidTipoEstrategia, ");
            query.append("tipoestragia.des_tipo_estr descTipoEstrategia, ");
            query.append("tipoestragia.IND_ESTR_GRUP indGrupo, ");
            query.append("tipoestragia.ind_estr_cond indEstrategiaCond, ");
            query.append("tipoestragia.ind_estr_vs indEstrategiaVS, ");
            query.append("tipoestragia.ind_estr_paqu indEstrategiaPaqu ");
            query.append("FROM PRE_TIPO_ESTRA tipoestragia order by 2");

            rs = belcorpServ.dbService.executeStaticQuery(query.toString());

            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            
            UtilidadesLog.info("PREConsultas.obtenerTiposEstrategia(DTOBelcorp dto): Salida");
            return dtoSalida;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
    * @autor jquiroga@indra.com.ar
    * @throws MareException    
    * @return DTOSalida
    * @documentation
        Accede a la entidad TipoOferta y recupera todos los tipos de oferta correspondientes al canal recibido (oidCanal) y
        que sean comisionables.

        Devuelve:

         - oidTipoOferta
         - descripcion
     * @modificado por Cristian Valenzuela 26/4/2005 Incidencia 17142
     */
    public DTOSalida obtenerTiposOfertaComisionablePorCanal(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("PREConsultas.obtenerTiposOfertaComisionablePorCanal(DTOOID dtoE): Entrada");
        
        try {
            BelcorpService belcorpServ = BelcorpService.getInstance();
            RecordSet rs = null;
            StringBuffer query = new StringBuffer();

            query.append(" SELECT T1.OID_TIPO_OFER, T2.VAL_I18N AS DESCRIPCION ");
            query.append(" FROM PRE_TIPO_OFERT T1, V_GEN_I18N_SICC T2  ");
            query.append(" WHERE T1.OID_TIPO_OFER=T2.VAL_OID ");
            query.append(" AND T2.ATTR_ENTI='PRE_TIPO_OFERT' AND T2.ATTR_NUM_ATRI=1 ");
            query.append(" AND T2.IDIO_OID_IDIO=" + dtoE.getOidIdioma());
            query.append(" AND T1.CANA_OID_CANA=" + dtoE.getOid());
            query.append(" ORDER BY DESCRIPCION ");

            rs = belcorpServ.dbService.executeStaticQuery(query.toString());

            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            
            UtilidadesLog.info("PREConsultas.obtenerTiposOfertaComisionablePorCanal(DTOOID dtoE): Salida");
            return dtoSalida;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    //Incidencia 9789
    //Ver incidencia 12627 26/01/05
    public Long obtenerEstimadosVentaProducto(Long producto, Long periodo) throws MareException {
        UtilidadesLog.info("PREConsultas.obtenerEstimadosVentaProducto(Long producto, Long periodo): Entrada");
        
        /* PREConsultas.obtenerEstimadosVentaProducto(producto : Long, periodo : Long) : Long
        Entrada:
            - producto : Long
            - periodo : Long
        Proceso:
        -> Hacer consulta JDBC sobre la tabla PRE_ESTIM_VENTA
        -> PROD_OID_PROD = producto
        -> PERD_OID_PERI = periodo
        -> Agrupar por los campos PROD_OID_PROD, PERD_OID_PERI
        -> Obtener la sumatoria del campo NUM_UNID_ESTI
        -> Devolver el resultado de la suma, si no se encuentran filas devolver 0*/
        try {
            BelcorpService belcorpServ = BelcorpService.getInstance();
            RecordSet rs = null;
            StringBuffer query = new StringBuffer();

            query.append("SELECT   SUM (num_unid_esti) ");
            query.append("FROM pre_estim_venta ");
            query.append("WHERE prod_oid_prod = " + producto + " ");
            query.append("AND perd_oid_peri = " + periodo + " ");
            query.append("GROUP BY prod_oid_prod, perd_oid_peri ");

            rs = belcorpServ.dbService.executeStaticQuery(query.toString());

            // DTOSalida dtoSalida = new DTOSalida();
            if (rs.esVacio()) {
                rs.addColumn("sum");

                Vector vec = new Vector();
                vec.add("0");
                rs.addRow(vec);
            }

            BigDecimal valorRs = (BigDecimal) rs.getValueAt(0, 0);
            
            UtilidadesLog.info("PREConsultas.obtenerEstimadosVentaProducto(Long producto, Long periodo): Salida");
            return new Long(valorRs.longValue());
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    /**
     * @author pperanzola
     * @date 12/10/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * se crea segun SICC-DMCO-PRE_MAE_INT-GCC-001
     * Descripción: devuelve un RecordSet para la carga del combo variante. 
       Implementación: 
        Hacer una consulta a la entidad PRE:Variantes filtrando por dto.pais recuperando: 
        - oid 
        - codigo 
        Devolver el Recorset obtenido

     */
    public RecordSet obtenerVariantes (DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("PREConsultas.obtenerVariantes (DTOBelcorp dto): Entrada");
        try {
            BelcorpService belcorpServ = BelcorpService.getInstance();
            RecordSet rs = null;
            StringBuffer query = new StringBuffer();

            query.append(" select OID_VARI,COD_VARI from PRE_VARIA ");
            query.append(" where pais_oid_pais = " + dto.getOidPais());
            
            rs = belcorpServ.dbService.executeStaticQuery(query.toString());

            UtilidadesLog.info("PREConsultas.obtenerVariantes (DTOBelcorp dto): Salida");
            return rs;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException
                                    , UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception
                                    , UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    private MONPeriodosHome getMONPeriodosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONPeriodosHome) PortableRemoteObject.narrow(context.lookup("MONPeriodos"), MONPeriodosHome.class);
    }

    private MONConfiguracionMFHome getMONConfiguracionMFHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONConfiguracionMFHome) PortableRemoteObject.narrow(context.lookup("MONConfiguracionMF"), MONConfiguracionMFHome.class);
    }

    private MONMantenimientoSEGHome getMONMantenimientoSEGHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoSEGHome) PortableRemoteObject.narrow(context.lookup("MONMantenimientoSEG"), MONMantenimientoSEGHome.class);
    }

    private MONGestionFormasPagoDetalleHome getMONGestionFormasPagoDetalleHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGestionFormasPagoDetalleHome) PortableRemoteObject.narrow(context.lookup("MONGestionFormasPagoDetalle"), MONGestionFormasPagoDetalleHome.class);
    }
    
  public void actualizaCVDetalles(Long oidOferta) throws MareException {
        UtilidadesLog.info("PREConsultas.actualizaCVDetalles(Long oidOferta): Entrada ");
        BelcorpService bs;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

              buf.append(" UPDATE pre_ofert_detal "); 
              buf.append(" SET pre_ofert_detal.ind_codi_vent_gene = 0, "); 
              buf.append(" pre_ofert_detal.val_codi_vent = '' "); 
              buf.append(" WHERE pre_ofert_detal.ofer_oid_ofer = "+oidOferta+" ");
              
        try{
        
          bs.dbService.executeUpdate(buf.toString()); 
          
        } catch(Exception e){
          UtilidadesLog.error("Exception: ",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));              
        }
        UtilidadesLog.info("PREConsultas.actualizaCVDetalles(Long oidOferta): Salida ");
  }    
  
    // vbongiov -- Cambio 20080746 -- 29/10/2008
   public RecordSet obtenerTipoOfertaCopiar(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("PREConsultas.obtenerTipoOfertaCopiar (DTOBelcorp dto): Entrada");
        try {
            BelcorpService belcorpServ = BelcorpService.getInstance();
            RecordSet rs = null;
            StringBuffer query = new StringBuffer();
    
            query.append(" SELECT tiof.OID_TIPO_OFER, i18n.VAL_I18N ");
            query.append(" FROM PRE_TIPO_OFERT tiof, V_GEN_I18N_SICC i18n ");
            query.append(" WHERE i18n.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
            query.append(" AND i18n.ATTR_NUM_ATRI = 1 ");
            query.append(" AND i18n.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
            query.append(" AND i18n.VAL_OID = tiof.OID_TIPO_OFER ");
            query.append(" AND tiof.COD_TIPO_OFER IN ('" + ConstantesPRE.COD_PROGR_NUEVAS_MARKETING + "', '" + ConstantesPRE.COD_MATERIAL_NUEVAS + "') ");
            query.append(" ORDER BY VAL_I18N ");
            
            rs = belcorpServ.dbService.executeStaticQuery(query.toString());
    
            UtilidadesLog.info("PREConsultas.obtenerTipoOfertaCopiar (DTOBelcorp dto): Salida");
            return rs;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException
                                    , UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception
                                    , UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    // vbongiov -- Cambio 20080746 -- 20/11/2008
        public boolean tieneDetallesTipoOferta(Long oidOferta, Long oidTipoOferta) throws MareException {
            UtilidadesLog.info("PREConsultas.tieneDetallesTipoOferta(Long oidOferta, Long oidTipoOferta)): Entrada");
            try {
            
                BelcorpService belcorpServ = BelcorpService.getInstance();
                RecordSet rs = null;
                StringBuffer query = new StringBuffer();
        
                query.append(" select count(1) CANT ");
                query.append(" from PRE_OFERT_DETAL det ");
                query.append(" where det.OFER_OID_OFER = " + oidOferta);
                query.append(" and det.TOFE_OID_TIPO_OFER = " + oidTipoOferta);
                
                rs = belcorpServ.dbService.executeStaticQuery(query.toString());
                
                BigDecimal cant = (BigDecimal) rs.getValueAt(0, 0);
                
                if(cant.toString().equals("0")) {
                    UtilidadesLog.info("PREConsultas.tieneDetallesTipoOferta(Long oidOferta, Long oidTipoOferta)): Salida false");
                    return false;
                } else {
                    UtilidadesLog.info("PREConsultas.tieneDetallesTipoOferta(Long oidOferta, Long oidTipoOferta)): Salida true");
                    return true;
                }
                
            } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                UtilidadesLog.error(serviceNotFoundException);
                throw new MareException(serviceNotFoundException
                                        , UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception
                                        , UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
        
    // vbongiov -- Cambio 20080794 -- 16/12/2008
        public boolean hayOfertasYaCopiadas(Long oidCabe, Long codigoProgramaFidelizacion, Long variante, Long oidTipoOferta) throws MareException {
            UtilidadesLog.info("PREConsultas.hayOfertasYaCopiadas(Long oidCabe, Long codigoProgramaFidelizacion, Long Variante, Long oidTipoOferta): Entrada");
            try {
            
                BelcorpService belcorpServ = BelcorpService.getInstance();
                RecordSet rs = null;
                StringBuffer query1 = new StringBuffer();
                StringBuffer query2 = new StringBuffer();
                StringBuffer query3 = new StringBuffer();
                
                if(oidTipoOferta!=null) {
        
                    query1.append(" select count(1) CANT ");
                    query1.append(" from PRE_OFERT_DETAL det, PRE_OFERT ofer ");
                    query1.append(" where ofer.MFCA_OID_CABE = " + oidCabe);
                    query1.append(" and det.OFER_OID_OFER = ofer.OID_OFER ");
                    query1.append(" and det.TOFE_OID_TIPO_OFER = " + oidTipoOferta);
                    
                    rs = belcorpServ.dbService.executeStaticQuery(query1.toString());
                    
                    if(!(((BigDecimal) rs.getValueAt(0, 0)).toString().equals("0"))) {      
                        UtilidadesLog.debug("hay ofertas con igual oidTipoOferta");
                        UtilidadesLog.info("PREConsultas.hayOfertasYaCopiadas(Long oidCabe, Long codigoProgramaFidelizacion, Long Variante, Long oidTipoOferta): Salida false");
                        return true;
                    }            
                }
                
                if(codigoProgramaFidelizacion!=null) {     
                
                    query2.append(" select count(1) CANT ");
                    query2.append(" from PRE_OFERT_DETAL det, PRE_OFERT ofer ");
                    query2.append(" where ofer.MFCA_OID_CABE = " + oidCabe);
                    query2.append(" and det.OFER_OID_OFER = ofer.OID_OFER ");
                    query2.append(" and det.PRFI_OID_PROG_FIDE = " + codigoProgramaFidelizacion);
                    
                    rs = belcorpServ.dbService.executeStaticQuery(query2.toString());
                    
                    if(!(((BigDecimal) rs.getValueAt(0, 0)).toString().equals("0"))) {  
                        UtilidadesLog.debug("hay ofertas con igual codigoProgramaFidelizacion");
                        UtilidadesLog.info("PREConsultas.hayOfertasYaCopiadas(Long oidCabe, Long codigoProgramaFidelizacion, Long Variante, Long oidTipoOferta): Salida false");
                        return true;                    
                    }
                }
                    
                if(variante!=null) {     
                    
                    query3.append(" select count(1) CANT ");
                    query3.append(" from PRE_OFERT_DETAL det, PRE_OFERT ofer ");
                    query3.append(" where ofer.MFCA_OID_CABE = " + oidCabe);
                    query3.append(" and det.OFER_OID_OFER = ofer.OID_OFER ");
                    query3.append(" and det.VARI_OID_VARI = " + variante);
                    
                    rs = belcorpServ.dbService.executeStaticQuery(query3.toString());                    
                        
                    if(!(((BigDecimal) rs.getValueAt(0, 0)).toString().equals("0"))) {     
                        
                        UtilidadesLog.debug("hay ofertas con igual variante");
                        UtilidadesLog.info("PREConsultas.hayOfertasYaCopiadas(Long oidCabe, Long codigoProgramaFidelizacion, Long Variante, Long oidTipoOferta): Salida false");
                        return true;
                    }
                }
                       
                UtilidadesLog.debug("no hay ofertas con oidTipoOferta, codigoProgramaFidelizacion o variante");
                UtilidadesLog.info("PREConsultas.hayOfertasYaCopiadas(Long oidCabe, Long codigoProgramaFidelizacion, Long Variante, Long oidTipoOferta): Salida false"); 
                return false;
                
            } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                UtilidadesLog.error(serviceNotFoundException);
                throw new MareException(serviceNotFoundException
                                        , UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception
                                        , UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
        
    // vbongiov -- Cambio 20080794 -- 16/12/2008
    public long ultimoCodVentaMatrizFacturacion(Long oidCabe) throws MareException {
        UtilidadesLog.info("PREConsultas.ultimoCodVentaMatrizFacturacion(Long oidCabe): Entrada");
        try {
        
            BelcorpService belcorpServ = BelcorpService.getInstance();
            RecordSet rs = null;
            StringBuffer query = new StringBuffer();
    
            query.append(" SELECT MAX(det.VAL_CODI_VENT) COD_VENTA_MAX");
            query.append(" from PRE_OFERT_DETAL det, PRE_OFERT ofer ");
            query.append(" where ofer.MFCA_OID_CABE = " + oidCabe);
            query.append(" and det.OFER_OID_OFER = ofer.OID_OFER ");
            
            rs = belcorpServ.dbService.executeStaticQuery(query.toString());
            
            BigDecimal codVentaMax = (BigDecimal) rs.getValueAt(0, 0);            
            
            UtilidadesLog.info("PREConsultas.tieneDetallesTipoOferta(Long oidOferta, Long oidTipoOferta)): Salida false");
            return codVentaMax.longValue();
                
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException
                                    , UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception
                                    , UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    // vbongiov -- Cambio 20080794 -- 16/12/2008
    public Integer obtenerUltimoNumeroOferta(Long oidCabeceraMF, Long oidEstrategia) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerUltimoNumeroOferta(Long oidCabeceraMF, Long oidEstrategia): Entrada");
        
        StringBuffer query = new StringBuffer();

        query.append("SELECT MAX(po.NUM_OFER) NUM ");
        query.append("FROM PRE_OFERT po ");
        query.append("WHERE po.COES_OID_ESTR = " + oidEstrategia + " ");
        query.append("AND po.MFCA_OID_CABE = " + oidCabeceraMF + " ");

        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            rSet = (RecordSet) belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        BigDecimal numOferta = (BigDecimal) rSet.getValueAt(0, "NUM");
        
        UtilidadesLog.debug("ultimo nro oferta de matr " + oidCabeceraMF + "estra" + oidEstrategia + ":" + numOferta);
        
        if(numOferta == null) {
            UtilidadesLog.info("MONOfertaBean.obtenerUltimoNumeroOferta(Long oidCabeceraMF, Long oidEstrategia): Salida");
            return new Integer("0");
        } else {
            UtilidadesLog.info("MONOfertaBean.obtenerUltimoNumeroOferta(Long oidCabeceraMF, Long oidEstrategia): Salida");
            return Integer.valueOf(numOferta.toString());
        }
    }
    
    // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
    public DTOSalida cargarCondicionesPromocion(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("PREConsultas.cargarCondicionesPromocion(DTOBelcorp dto): Entrada");
        
        BelcorpService belcorpService;
        RecordSet rs;
        DTOSalida dtos = new DTOSalida();

        try {
            belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append(" SELECT condpromo.OID_COND_PROM, i18n.VAL_I18N");
            query.append(" FROM PRE_CONDI_PROMO condpromo, V_GEN_I18N_SICC i18n");
            query.append(" WHERE condpromo.OID_COND_PROM = i18n.VAL_OID");
            query.append(" AND i18n.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "'");
            query.append(" AND i18n.ATTR_ENTI = 'PRE_CONDI_PROMO'");
            query.append(" ORDER BY i18n.VAL_I18N");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        dtos.setResultado(rs);
        
        UtilidadesLog.info("PREConsultas.cargarCondicionesPromocion(DTOBelcorp dto): Salida");
        return dtos;
    }
    
}
