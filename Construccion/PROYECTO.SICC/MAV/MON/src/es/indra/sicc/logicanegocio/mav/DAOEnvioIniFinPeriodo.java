package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.mav.DTOEnvioMAV;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.UtilidadesBD;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.persistence.NoResultException;

public class DAOEnvioIniFinPeriodo {
    public DAOEnvioIniFinPeriodo() {}

  /**
   * 19-06-2007   modificado por Sapaza, incidencia SiCC-20070288. Se agrega parametro Actividades,
   *              el cual se filtra por actividades MAV, en vez de tipo de despacho MAV
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param 
   * @param oidCanal
   * @param oidPais
   * @param oidMarca
   * @param periodo
   * @param modulo
   */
    public RecordSet obtenerCondicionesNoEvaluadas(Long modulo, 
                                                         Long periodo,
                                                         Long oidMarca,
                                                         Long oidPais,
                                                         Long oidCanal,
                                                         ArrayList actividadesMAV)
                                                    throws MareException {
        
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.obtenerCondicionesNoEvaluadas():Entrada");
        StringBuffer query = new StringBuffer();

        /*query.append("SELECT DESP.TDCH_OID_TIPO_DESP, ");
        query.append("A.OID_DETA_MAV, "); //--oid
        query.append("A.TICL_OID_TIPO_CLIE, "); //--tipoCliente 
        query.append("A.CLAS_OID_CLAS, "); //--clasificacion 
        query.append("A.TCCL_OID_TIPO_CLAS, "); //--tipoClasificacion
        query.append("A.ATDE_OID_ACTI_TIPO_DESP, "); //--tipoDespacho
        query.append("A.PERD_OID_PERI, "); //--periodo
        query.append("A.PERD_OID_PERI_FINA, "); //--periodoFin 
        query.append("A.PERD_OID_PERI_FINA_MONT, "); //--periodoFinMonto o campaña hasta 
        query.append("A.PERD_OID_PERI_INIC_MONT, "); //--periodoIniMonto o campaña desde 
        query.append("A.TEPR_OID_TIPO_ESTA_PROC, "); //--estadoProceso 
        query.append("A.AEST_OID_ESTA_ACTI, "); //--estadoMAV 
        query.append("A.SCAS_OID_SUBC, "); //--subcriterio 
        query.append("A.VAL_EDAD_DESD, "); //--edadDesde 
        query.append("A.VAL_EDAD_HAST, "); //--edadHasta 
        query.append("A.NUM_ANIV, "); //--numeroAniversario 
        query.append("A.MAPR_OID_MARC_PROD, "); //--marcaCondicion 
        query.append("A.UNEG_OID_UNID_NEGO, "); //--unidadNegocio 
        query.append("A.NEGO_OID_NEGO, "); //--negocio 
        query.append("A.OCAT_OID_CATA, "); //--catalogo 
        query.append("A.ACTI_OID_ACTI, "); //--actividad 
        query.append("A.FCOB_OID_FORM_COBR, "); //--formaCobro 
        query.append("A.FOPA_OID_FORM_PAGO, "); //--formaPago 
        query.append("A.NUM_UNID_CLIE, "); //--unidadesPorCliente 
        query.append("A.VAL_PREC_STND, "); //--precioEstandar 
        query.append("A.VAL_PREC, "); //--precio
        query.append("A.VAL_PREC_CONT, "); //-- precioContable, 
            
        // Quitado por ssantana, 3/8/2005, inc. 15618
        //query.append("A.MAFA_OID_MATR_FACT, "); //--codigoVenta 
        // Fin quitado por ssantana, 3/8/2005, inc. 15618
        
        query.append("E.ZZON_OID_ZONA, "); //--zona 
        query.append("E.ZORG_OID_REGI, "); //--region 
        query.append("E.ZSGV_OID_SUBG_VENT, "); //--subgerencia
        
        query.append("A.MENS_OID_MENS ");

        query.append("FROM MAV_DETAL_MAV A, ");
        query.append("CRA_PERIO B, ");
        query.append("CRA_PERIO C, ");
        
        // Elemento comentado por ssantana, 24/8/2005, a petición de JPBosnjak.
        // query.append("CRA_PERIO D, ");
        // Fin elemento comentado ssantana, 24/8/2005.
        query.append(" MAV_DETAL_MAV_UNIDA_ADMIN E, ");
        
        // Agregado por ssantana, 23/8/2005, pedido de JPBosnjak
        query.append(" MAV_ACTIV_TIPO_DESPA DESP ");
        // Fin agregado por ssantana, 23/8/2005, pedido de JPBosnjak


        query.append("WHERE B.OID_PERI= ").append(periodo).append(" ");
        query.append("AND C.OID_PERI = A.PERD_OID_PERI ");

        // Elemento comentado por ssantana, 24/8/2005, a petición de JPBosnjak.        
        //query.append("AND D.OID_PERI = A.PERD_OID_PERI_FINA ");
        // Fin elemento comentado ssantana, 24/8/2005.        
        
        query.append(" AND B.FEC_INIC >= C.FEC_INIC ");
        
        // Elemento comentado por ssantana, 24/8/2005, a petición de JPBosnjak.        
        //query.append("AND B.FEC_FINA <= D.FEC_FINA ");
        // Fin elemento comentado ssantana, 24/8/2005.  
        
        query.append(" AND A.TEPR_OID_TIPO_ESTA_PROC = ").append(ConstantesMAV.T_ESTAD_PROCESO_INICIADO);
        query.append(" AND A.OID_DETA_MAV = E.DENV_OID_DETA_MAV (+) AND "); //puede que no exista ese registro en la tabla MAV_DETAL_MAV_UNIDA_ADMIN. 

        // Agregado por ssantana, 23/8/2005, pedido de JPBosnjak
        query.append(" DESP.OID_ACTI_TIPO_DESP = A.ATDE_OID_ACTI_TIPO_DESP ");

        if(ConstantesSEG.MODULO_CRA.equals(modulo.toString()))
            query.append("AND DESP.TDCH_OID_TIPO_DESP = ").append(ConstantesMAV.DESPACHO_INI_PERIODO).append(" ");
        else if(ConstantesSEG.MODULO_FAC.equals(modulo.toString()))
            query.append("AND DESP.TDCH_OID_TIPO_DESP = ").append(ConstantesMAV.DESPACHO_FIN_PERIODO).append(" ");            
        // Fin agregado por ssantana, 23/8/2005, pedido de JPBosnjak
        */
        BelcorpService belcorpService = BelcorpService.getInstance();
        RecordSet rs = null;
        
        /*query.append(" SELECT mav_detal_mav.oid_deta_mav ");
        query.append(" FROM mav_detal_mav, ");
        query.append(" cra_perio pini, ");
        query.append(" cra_perio pfin, ");
        query.append(" cra_perio pentrada, ");
        query.append(" mav_activ_tipo_despa ");
        query.append(" WHERE mav_detal_mav.tepr_oid_tipo_esta_proc = " + 
                                            ConstantesMAV.T_ESTAD_PROCESO_INICIADO);
        query.append(" AND mav_detal_mav.perd_oid_peri = pini.oid_peri ");
        query.append(" AND mav_detal_mav.perd_oid_peri_fina = pfin.oid_peri(+) ");
        query.append(" AND pentrada.oid_peri = " + periodo);
        query.append(" AND pentrada.fec_inic >= pini.fec_inic ");
        query.append(" AND pentrada.fec_fina(+) <= pfin.fec_fina ");
        query.append(" AND pini.pais_oid_pais = " + oidPais );
        query.append(" AND pini.cana_oid_cana = " + oidCanal);
        query.append(" AND pini.marc_oid_marc = " + oidMarca);
        query.append(" AND pfin.pais_oid_pais(+) = " + oidPais);
        query.append(" AND pfin.cana_oid_cana(+) = " + oidCanal);
        query.append(" AND pfin.marc_oid_marc(+) = " + oidMarca);
        query.append(" AND mav_detal_mav.atde_oid_acti_tipo_desp = ");
        query.append("                     mav_activ_tipo_despa.oid_acti_tipo_desp ");*/
        
        query.append(" SELECT   mav_detal_mav.oid_deta_mav ");
        query.append(" FROM mav_detal_mav, ");
        query.append(" mav_activ, ");        
        query.append(" cra_perio pini, ");
        query.append(" cra_perio pfin, ");
        query.append(" cra_perio pentrada, ");
        query.append(" mav_activ_tipo_despa ");
        query.append(" WHERE mav_detal_mav.tepr_oid_tipo_esta_proc = " + 
                                          ConstantesMAV.T_ESTAD_PROCESO_INICIADO);
        query.append(" AND mav_detal_mav.perd_oid_peri = pini.oid_peri ");
        query.append(" AND pentrada.oid_peri = " + periodo);
        query.append(" AND pentrada.fec_inic >= pini.fec_inic ");
        query.append(" AND (   ( mav_detal_mav.perd_oid_peri_fina IS NULL ");
        query.append("           AND pfin.oid_peri = pentrada.oid_peri ");
        query.append("          ) ");
        query.append("         OR (mav_detal_mav.perd_oid_peri_fina IS NOT NULL ");
        query.append("             AND mav_detal_mav.perd_oid_peri_fina = pfin.oid_peri ");
        query.append("             AND pentrada.fec_fina <= pfin.fec_fina ");
        query.append("             ) ");
        query.append("     ) ");
        query.append(" AND mav_detal_mav.atde_oid_acti_tipo_desp = ");
        query.append("                  mav_activ_tipo_despa.oid_acti_tipo_desp ");
        query.append(" AND mav_detal_mav.acti_oid_acti = mav_activ.oid_acti ");        
        
        
        if (ConstantesSEG.MODULO_CRA.equals(modulo.toString())) {
            query.append(" AND mav_activ_tipo_despa.TDCH_OID_TIPO_DESP = ");
            query.append(ConstantesMAV.DESPACHO_INI_PERIODO);
        } else if(ConstantesSEG.MODULO_FAC.equals(modulo.toString())) {
            query.append(" AND mav_activ_tipo_despa.TDCH_OID_TIPO_DESP = ");
            query.append(ConstantesMAV.DESPACHO_FIN_PERIODO);
        } else if(ConstantesSEG.MODULO_MAV.equals(modulo.toString())) {
            query.append(" AND mav_activ.oid_acti IN " + actividadesMAV.toString().replace('[','(').replace(']',')') );
        }
        
        query.append(" ORDER BY 1 ");

        try {
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
        } catch(Exception e) {
            if(e instanceof MareException)
                throw (MareException)e;
            else
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.obtenerCondicionesNoEvaluadas():Salida");        
        return rs;

        

        /*if((rs != null) && !rs.esVacio()) {
            dtosDetalleMAV = new DTODetalleMAV[rs.getRecords().size()];

            for(int i = 0; i < rs.getRecords().size(); ++i) {
                DTODetalleMAV dto = new DTODetalleMAV();
                dto.setOid(this.getLongFromResultSet(rs.getValueAt(i, "OID_DETA_MAV")));
                dto.setTipoCliente(this.getLongFromResultSet(rs.getValueAt(i, "TICL_OID_TIPO_CLIE")));
                dto.setClasificacion(this.getLongFromResultSet(rs.getValueAt(i, "CLAS_OID_CLAS")));
                dto.setTipoClasificacion(this.getLongFromResultSet(rs.getValueAt(i, "TCCL_OID_TIPO_CLAS")));
                dto.setTipoDespacho(this.getLongFromResultSet(rs.getValueAt(i, "ATDE_OID_ACTI_TIPO_DESP")));
                dto.setPeriodo(this.getLongFromResultSet(rs.getValueAt(i, "PERD_OID_PERI")));
                dto.setPeriodoFin(this.getLongFromResultSet(rs.getValueAt(i, "PERD_OID_PERI_FINA")));
                dto.setPeriodoFinMonto(this.getLongFromResultSet(rs.getValueAt(i, "PERD_OID_PERI_FINA_MONT")));
                dto.setPeriodoIniMonto(this.getLongFromResultSet(rs.getValueAt(i, "PERD_OID_PERI_INIC_MONT")));
                dto.setEstadoProceso(this.getLongFromResultSet(rs.getValueAt(i, "TEPR_OID_TIPO_ESTA_PROC")));
                dto.setEstadoMAV(this.getLongFromResultSet(rs.getValueAt(i, "AEST_OID_ESTA_ACTI")));
                dto.setSubcriterio(this.getLongFromResultSet(rs.getValueAt(i, "SCAS_OID_SUBC")));
                dto.setEdadDesde(this.getLongFromResultSet(rs.getValueAt(i, "VAL_EDAD_DESD")));
                dto.setEdadHasta(this.getLongFromResultSet(rs.getValueAt(i, "VAL_EDAD_HAST")));
                dto.setNumeroAniversario(this.getIntegerFromResultSet(rs.getValueAt(i, "NUM_ANIV")));
                dto.setMarcaCondicion(this.getLongFromResultSet(rs.getValueAt(i, "MAPR_OID_MARC_PROD")));
                dto.setUnidadNegocio(this.getLongFromResultSet(rs.getValueAt(i, "UNEG_OID_UNID_NEGO")));
                dto.setNegocio(this.getLongFromResultSet(rs.getValueAt(i, "NEGO_OID_NEGO")));
                dto.setCatalogo(this.getLongFromResultSet(rs.getValueAt(i, "OCAT_OID_CATA")));
                dto.setActividad(this.getLongFromResultSet(rs.getValueAt(i, "ACTI_OID_ACTI")));
                dto.setFormaCobro(this.getLongFromResultSet(rs.getValueAt(i, "FCOB_OID_FORM_COBR")));
                dto.setFormaPago(this.getLongFromResultSet(rs.getValueAt(i, "FOPA_OID_FORM_PAGO")));
                dto.setUnidadesPorCliente(this.getIntegerFromResultSet(rs.getValueAt(i, "NUM_UNID_CLIE")));
                dto.setPrecioEstandar(this.getDoubleFromResultSet(rs.getValueAt(i, "VAL_PREC_STND")));
                dto.setPrecio(this.getDoubleFromResultSet(rs.getValueAt(i, "VAL_PREC")));
                dto.setPrecioContable(this.getDoubleFromResultSet(rs.getValueAt(i, "VAL_PREC_CONT")));
                // Quitado por ssantana, 3/8/2005, inc. 15618
                // dto.setCodigoVenta(this.getLongFromResultSet(rs.getValueAt(i, "MAFA_OID_MATR_FACT")));
                // Fin Quitado por ssantana, 3/8/2005, inc. 15618
                dto.setZonas(new Long[] {this.getLongFromResultSet(rs.getValueAt(i, "ZZON_OID_ZONA"))});
                dto.setRegiones(new Long[] {this.getLongFromResultSet(rs.getValueAt(i, "ZORG_OID_REGI"))});
                dto.setSubgerencias(new Long[] {this.getLongFromResultSet(rs.getValueAt(i, "ZSGV_OID_SUBG_VENT"))});

                dtosDetalleMAV[i] = dto;
            }
             //for
        }*/
         //if rs != null


    }

    public DTOEnvioMAV[] obtenerClienteCondicion(DTODetalleMAV dtoDetalleMAV, Long periodo)
        throws MareException {
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.obtenerClienteCondicion(DTODetalleMAV DTOE, Long periodo):Entrada");
        
        /** Obtengo los Clientes */
        
        DTOEnvioMAV[] arrayDtoEnvio = null;
        Long[] arraySubtipos = null;
        Long[] arrayZonas = null;
        Long[] arrayRegiones = null;
        Long[] arraySGV = null;
        Long clasificacion = null;
        Long tipoClasificacion = null;
        Long subcriterio = null;
        boolean yaUsoDatosAdicionales = false;
        
        StringBuffer sqlSelect = new StringBuffer("");
        StringBuffer sqlFrom = new StringBuffer("");
        StringBuffer sqlWhere = new StringBuffer("");
        
        String sQuery = null;
        RecordSet r = null;
        
        sqlSelect.append(" SELECT v_mae_tipif_clien.clie_oid_clie ");
        
        sqlFrom.append(" FROM mav_detal_mav, ");
        sqlFrom.append(" v_mae_tipif_clien, ");
        sqlFrom.append(" mae_clien_unida_admin, ");
        sqlFrom.append(" zon_terri_admin, ");
        sqlFrom.append(" zon_secci, ");
        sqlFrom.append(" zon_zona, ");
        sqlFrom.append(" zon_regio, ");
        sqlFrom.append(" zon_sub_geren_venta ");
        
        sqlWhere.append(" WHERE  mav_detal_mav.oid_deta_mav = " + dtoDetalleMAV.getOid());
        sqlWhere.append(" AND mav_detal_mav.ticl_oid_tipo_clie = ");
        sqlWhere.append("                        v_mae_tipif_clien.ticl_oid_tipo_clie ");
        
        /* Subtipos */ 
        arraySubtipos = dtoDetalleMAV.getSubtiposCliente();
        if (arraySubtipos != null && arraySubtipos.length > 0 ) {
           String sIn = this.parseaArray(arraySubtipos);
           sqlWhere.append(" AND v_mae_tipif_clien.sbti_oid_subt_clie IN (" + sIn);
           sqlWhere.append(" ) ");
        }
        
        /* Clasificacion y Tipo Clasificacion*/ 
        clasificacion = dtoDetalleMAV.getClasificacion();
        tipoClasificacion = dtoDetalleMAV.getTipoClasificacion();
        
        if (clasificacion != null) {
           sqlWhere.append(" and v_mae_tipif_clien.CLAS_OID_CLAS = " + clasificacion);
        }
        
        if (tipoClasificacion != null) {
          sqlWhere.append(" and v_mae_tipif_clien.TCCL_OID_TIPO_CLASI = " + tipoClasificacion);
        }
        
        /* Zonificacion */
        sqlWhere.append(" AND mae_clien_unida_admin.clie_oid_clie = v_mae_tipif_clien.clie_oid_clie ");
        sqlWhere.append(" AND mae_clien_unida_admin.ztad_oid_terr_admi = ");
        sqlWhere.append("                                        zon_terri_admin.oid_terr_admi ");
        sqlWhere.append(" AND zon_terri_admin.zscc_oid_secc = zon_secci.oid_secc ");
        sqlWhere.append(" AND zon_secci.zzon_oid_zona = zon_zona.oid_zona ");
        sqlWhere.append(" AND zon_zona.zorg_oid_regi = zon_regio.oid_regi ");
        sqlWhere.append(" AND zon_regio.zsgv_oid_subg_vent = zon_sub_geren_venta.oid_subg_vent ");
        
        arrayZonas = dtoDetalleMAV.getZonas();
        arrayRegiones = dtoDetalleMAV.getRegiones();
        arraySGV = dtoDetalleMAV.getSubgerencias();
        
        if (arrayZonas != null && arrayZonas.length > 0 ){
           String sIn = this.parseaArray(arrayZonas);
           sqlWhere.append(" AND zon_zona.oid_zona IN (" + sIn + ") ");
        }

        if (arrayRegiones != null && arrayRegiones.length > 0 ){
           String sIn = this.parseaArray(arrayRegiones);
           sqlWhere.append(" AND zon_regio.oid_regi IN (" + sIn + ") ");           
        }
        
        if (arraySGV != null && arraySGV.length > 0 ){
            String sIn = this.parseaArray(arraySGV);
           sqlWhere.append(" AND zon_sub_geren_venta.oid_subg_vent IN (" + sIn + ") ");
        }
        sqlWhere.append(" AND mae_clien_unida_admin.ind_acti = 1 ");
        
        /* Estado */ 
        if (dtoDetalleMAV.getEstadoMAV() != null) {
            sqlFrom.append(" , mae_clien_datos_adici, ");
            sqlFrom.append(" mae_estat_clien, ");
            sqlFrom.append(" mav_estad_mav_mae, ");
            sqlFrom.append(" mav_estad_mav, ");
            sqlFrom.append(" mav_activ_estad ");     
            
            sqlWhere.append(" AND v_mae_tipif_clien.clie_oid_clie = mae_clien_datos_adici.clie_oid_clie ");
            sqlWhere.append(" AND mae_clien_datos_adici.esta_oid_esta_clie = ");
            sqlWhere.append("                               mae_estat_clien.oid_esta_clie ");
            sqlWhere.append(" AND mae_estat_clien.oid_esta_clie = mav_estad_mav_mae.esta_oid_esta_clie ");
            sqlWhere.append(" AND mav_estad_mav_mae.emav_oid_esta_mav = mav_estad_mav.oid_esta_mav ");
            sqlWhere.append(" AND mav_estad_mav.oid_esta_mav = mav_activ_estad.emav_oid_esta_mav ");
            sqlWhere.append(" AND mav_activ_estad.oid_esta_acti = mav_detal_mav.aest_oid_esta_acti ");
            
            yaUsoDatosAdicionales = true;
        }
        
        /* Subcriterio */ 
        subcriterio = dtoDetalleMAV.getSubcriterio();
        if (subcriterio.equals(ConstantesMAV.SUBCRI_CUMPLE)) {
            UtilidadesLog.debug("Es SUBCRI_CUMPLE");
            if (!yaUsoDatosAdicionales) {
              sqlFrom.append(", mae_clien_datos_adici ");
            }
            String[] arrayAnyos = this.obtieneFechasPeriodo(periodo);
            
            String sFechaInicio = arrayAnyos[0];
            String sFechaFin = arrayAnyos[1]; 
            String sAnyoIni = arrayAnyos[2]; 
            String sAnyoFin = arrayAnyos[3]; 
            
            Boolean bCambiaAnyo = Boolean.FALSE;
            if (!sAnyoIni.equals(sAnyoFin)) {
               bCambiaAnyo = Boolean.TRUE;
            }
            
            sFechaInicio = sFechaInicio + "/2008";
            sFechaFin = sFechaFin + "/2008";

            UtilidadesLog.debug("CambiaAnyo: " + bCambiaAnyo);
            UtilidadesLog.debug("sFechaInicio: " + sFechaInicio);
            UtilidadesLog.debug("sFechaFin: " + sFechaFin);
            
            sqlWhere.append(" AND mae_clien_datos_adici.clie_oid_clie = v_mae_tipif_clien.clie_oid_clie "); 
            sqlWhere.append(" AND mae_clien_datos_adici.fec_naci IS NOT NULL ");
            sqlWhere.append(" AND ( ");
            
            if (bCambiaAnyo.booleanValue()) { 
               /** Hay cambio de año */
              sqlWhere.append(" (TO_DATE (TO_CHAR (mae_clien_datos_adici.fec_naci, 'dd/MM') ");
              sqlWhere.append(" || '/2008', 'dd/MM/yyyy' )");
              sqlWhere.append(" BETWEEN TO_DATE ('" + sFechaInicio + "', 'dd/MM/yyyy') ");
              sqlWhere.append(" AND TO_DATE ('31/12/2008', 'dd/MM/yyyy') )");
              
              sqlWhere.append(" or ");
              
              sqlWhere.append(" (TO_DATE (TO_CHAR (mae_clien_datos_adici.fec_naci, 'dd/MM') ");
              sqlWhere.append(" || '/2008', 'dd/MM/yyyy' )");
              sqlWhere.append(" BETWEEN TO_DATE ('01/01/2008', 'dd/MM/yyyy') ");
              sqlWhere.append(" AND TO_DATE ('" + sFechaFin + "', 'dd/MM/yyyy') )");
              
            } else {
               /** No hay cambio de año */
              sqlWhere.append(" (TO_DATE (TO_CHAR (mae_clien_datos_adici.fec_naci, 'dd/MM') ");
              sqlWhere.append(" || '/2008', 'dd/MM/yyyy' )");
              sqlWhere.append(" BETWEEN TO_DATE ('" + sFechaInicio + "', 'dd/MM/yyyy') ");
              sqlWhere.append(" AND TO_DATE ('" + sFechaFin + "', 'dd/MM/yyyy') )");
            }
            
            
            sqlWhere.append(" ) ");
        } else if (subcriterio.equals(ConstantesMAV.SUBCRI_ANIVERSARIO)) {
            UtilidadesLog.debug("Es SUBCRI_ANIVERSARIO");
            sqlFrom.append(", mae_clien ");
              
            String[] arrayAnyos = this.obtieneFechasPeriodo(periodo);
            String sFechaInicio = arrayAnyos[0];
            String sFechaFin = arrayAnyos[1]; 
            String sAnyoIni = arrayAnyos[2]; 
            String sAnyoFin = arrayAnyos[3]; 
            
            Boolean bCambiaAnyo = Boolean.FALSE;
            if (!sAnyoIni.equals(sAnyoFin)) {
               bCambiaAnyo = Boolean.TRUE;
            }
            
            sFechaInicio = sFechaInicio + "/2008";
            sFechaFin = sFechaFin + "/2008";

            UtilidadesLog.debug("CambiaAnyo: " + bCambiaAnyo);
            UtilidadesLog.debug("sFechaInicio: " + sFechaInicio);
            UtilidadesLog.debug("sFechaFin: " + sFechaFin);
            
            sqlWhere.append(" AND mae_clien.fec_ingr IS NOT NULL ");
            sqlWhere.append(" AND ( ");
            
            if (bCambiaAnyo.booleanValue()) {  
               sqlWhere.append(" (TO_DATE (TO_CHAR (mae_clien.fec_ingr, 'dd/MM') || '/2008', 'dd/MM/yyyy' ) ");
               sqlWhere.append(" BETWEEN TO_DATE ('" + sFechaInicio + "', 'dd/MM/yyyy') ");
               sqlWhere.append(" AND TO_DATE ('31/12/2008', 'dd/MM/yyyy') ) ");
               
               sqlWhere.append(" OR ");
               
               sqlWhere.append(" (TO_DATE (TO_CHAR (mae_clien.fec_ingr, 'dd/MM') || '/2008', 'dd/MM/yyyy' ) ");
               sqlWhere.append(" BETWEEN TO_DATE ('01/01/2008', 'dd/MM/yyyy') ");
               sqlWhere.append(" AND TO_DATE ('" + sFechaFin +  "', 'dd/MM/yyyy') ) ");
            
            } else {
               sqlWhere.append(" (TO_DATE (TO_CHAR (mae_clien.fec_ingr, 'dd/MM') || '/2008', 'dd/MM/yyyy' ) ");
               sqlWhere.append(" BETWEEN TO_DATE ('" + sFechaInicio + "', 'dd/MM/yyyy') ");
               sqlWhere.append(" AND TO_DATE ('" + sFechaFin + "', 'dd/MM/yyyy') )");
            }
            
            sqlWhere.append(" ) ");
            sqlWhere.append(" and (" + sAnyoFin + " -  TO_NUMBER (TO_CHAR (mae_clien.FEC_INGR, 'yyyy')) ) = ");
            sqlWhere.append( dtoDetalleMAV.getNumeroAniversario());
            
        } else if (subcriterio.equals(ConstantesMAV.SUBCRI_EDAD)) {
            UtilidadesLog.debug("Es SUBCRI_EDAD");
            if (!yaUsoDatosAdicionales) {
              sqlFrom.append(", mae_clien_datos_adici ");
            }
            sqlFrom.append(", cra_perio ");
            
            sqlWhere.append(" and cra_perio.oid_peri = " + periodo);
            sqlWhere.append(" and mae_clien_datos_adici.clie_oid_clie = "); 
            sqlWhere.append("                   v_mae_tipif_clien.clie_oid_clie ");
            sqlWhere.append(" and mae_clien_datos_adici.fec_naci is not null ");
            sqlWhere.append(" and ((cra_perio.fec_inic - mae_clien_datos_adici.fec_naci) "); 
            sqlWhere.append("                               /365.25) "); 
            sqlWhere.append(" between " + dtoDetalleMAV.getEdadDesde() );
            sqlWhere.append(" and " + dtoDetalleMAV.getEdadHasta());
        } else if(subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO)) {
            UtilidadesLog.debug("Es SUBCRI_PED_SUP_MONTO");
            Long periodoMontoIni = dtoDetalleMAV.getPeriodoIniMonto();
            Long periodoMontoFin = dtoDetalleMAV.getPeriodoFinMonto();
            
            if (periodoMontoIni == null || periodoMontoFin == null) {
               /* Sin Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Sin Monto Periodo Inicio");
               sqlSelect.append(", sum(ped_solic_posic.NUM_UNID_POR_ATEN * "); 
               sqlSelect.append("        ped_solic_posic.val_prec_cata_tota_loca) ");
               
               sqlFrom.append(", ped_solic_cabec, ");   
               sqlFrom.append(" ped_solic_posic ");
    
               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = "); 
               sqlWhere.append("                  ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" and ped_solic_cabec.PERD_OID_PERI = " + periodo);
               sqlWhere.append(" and ped_solic_cabec.OID_SOLI_CABE = "); 
               sqlWhere.append("                ped_solic_posic.SOCA_OID_SOLI_CABE ");
               sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie ");
               sqlWhere.append(" having sum(ped_solic_posic.NUM_UNID_POR_ATEN * "); 
               sqlWhere.append("              ped_solic_posic.val_prec_cata_tota_loca) > "); 
               sqlWhere.append(dtoDetalleMAV.getMonto());
            } else {
               /* Con Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Con Monto Periodo Inicio");
               sqlSelect.append(", sum(ped_solic_cabec.VAL_PREC_CATA_TOTA_LOC_UNI_DEM) ");
               
               sqlFrom.append(", ped_solic_cabec, ");
               sqlFrom.append(" cra_perio pIni, ");
               sqlFrom.append(" cra_perio pFin, ");
               sqlFrom.append(" cra_perio pCabecera ");
               
               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = "); 
               sqlWhere.append("                    ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" AND ped_solic_cabec.FEC_FACT IS NOT NULL ");
               sqlWhere.append(" and ped_solic_cabec.perd_oid_peri = pCabecera.oid_peri ");
               sqlWhere.append(" and pCabecera.FEC_INIC >= pIni.fec_inic ");
               sqlWhere.append(" and pCabecera.FEC_FINA <= pFin.fec_fina ");
               sqlWhere.append(" and pIni.oid_peri = " + periodoMontoIni);
               sqlWhere.append(" and pFin.oid_peri = " + periodoMontoFin);
               sqlWhere.append(" and pCabecera.CANA_OID_CANA = pIni.CANA_OID_CANA ");
               sqlWhere.append(" and pCabecera.MARC_OID_MARC = pIni.Marc_oid_marc ");
               sqlWhere.append(" and pCabecera.PAIS_OID_PAIS = pIni.pais_oid_pais ");
               sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie ");
               sqlWhere.append(" having sum(ped_solic_cabec.VAL_PREC_CATA_TOTA_LOC_UNI_DEM) ");
               sqlWhere.append(" > " + dtoDetalleMAV.getMonto());
            } 
        } else if (subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO_MARCA)) {
            UtilidadesLog.debug("Es SUBCRI_PED_SUP_MONTO_MARCA");
            Long periodoMontoIni = dtoDetalleMAV.getPeriodoIniMonto();
            Long periodoMontoFin = dtoDetalleMAV.getPeriodoFinMonto();
            sqlSelect.append(", sum(ped_solic_posic.NUM_UNID_POR_ATEN * ");
            sqlSelect.append("            ped_solic_posic.val_prec_cata_tota_loca) ");
            if (periodoMontoIni == null || periodoMontoFin == null) { 
               /* Sin Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Sin Monto Periodo Inicio");
               sqlFrom.append(", ped_solic_cabec, ");
               sqlFrom.append(" ped_solic_posic, ");
               sqlFrom.append(" mae_produ ");
               
               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = "); 
               sqlWhere.append("                     ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" and ped_solic_cabec.perd_oid_peri = " + periodo); 
               sqlWhere.append(" and ped_solic_cabec.oid_soli_cabe = "); 
               sqlWhere.append("                  ped_solic_posic.SOCA_OID_SOLI_CABE ");
               sqlWhere.append(" and ped_solic_posic.PROD_OID_PROD = mae_produ.OID_PROD");
               sqlWhere.append(" and mae_produ.MAPR_OID_MARC_PROD = " + dtoDetalleMAV.getMarca());
               sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie ");
               sqlWhere.append(" having sum(ped_solic_posic.NUM_UNID_POR_ATEN * ");
               sqlWhere.append(" ped_solic_posic.val_prec_cata_tota_loca) > " + dtoDetalleMAV.getMonto() );
            } else {
               /* Con Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Con Monto Periodo Inicio");
               sqlFrom.append(", ped_solic_cabec, ");
               sqlFrom.append(" ped_solic_posic, ");
               sqlFrom.append(" cra_perio pIni, ");
               sqlFrom.append(" cra_perio pFin, ");
               sqlFrom.append(" cra_perio pCabecera, ");
               sqlFrom.append(" mae_produ ");
               
               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = "); 
               sqlWhere.append("                     ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" AND ped_solic_cabec.FEC_FACT IS NOT NULL "); 
               sqlWhere.append(" and ped_solic_cabec.oid_soli_cabe = "); 
               sqlWhere.append("                ped_solic_posic.SOCA_OID_SOLI_CABE ");
               sqlWhere.append(" and ped_solic_posic.PROD_OID_PROD = mae_produ.OID_PROD");
               sqlWhere.append(" and mae_produ.MAPR_OID_MARC_PROD = " + dtoDetalleMAV.getMarca());
               sqlWhere.append(" and ped_solic_cabec.perd_oid_peri = pCabecera.OID_PERI ");
               sqlWhere.append(" and pCabecera.FEC_INIC >= pIni.fec_inic ");
               sqlWhere.append(" and pCabecera.fec_fina <= pFin.fec_fina ");
               sqlWhere.append(" and pIni.oid_peri = " + periodoMontoIni);
               sqlWhere.append(" and pFin.oid_peri = " + periodoMontoFin);
               sqlWhere.append(" and pCabecera.CANA_OID_CANA = pIni.CANA_OID_CANA ");
               sqlWhere.append(" and pCabecera.MARC_OID_MARC = pIni.Marc_oid_marc ");
               sqlWhere.append(" and pCabecera.PAIS_OID_PAIS = pIni.pais_oid_pais ");
               sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie ");
               sqlWhere.append(" having sum(ped_solic_posic.NUM_UNID_POR_ATEN * ");
               sqlWhere.append("              ped_solic_posic.val_prec_cata_tota_loca) > "); 
               sqlWhere.append(dtoDetalleMAV.getMonto());
            }
        } else if (subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO_U_NEGOCIO)) {
            UtilidadesLog.debug("Es SUBCRI_PED_SUP_MONTO_U_NEGOCIO");
            Long periodoMontoIni = dtoDetalleMAV.getPeriodoIniMonto();
            Long periodoMontoFin = dtoDetalleMAV.getPeriodoFinMonto();
            sqlSelect.append(", sum(ped_solic_posic.NUM_UNID_POR_ATEN * "); 
            sqlSelect.append("            ped_solic_posic.val_prec_cata_tota_loca) ");
            if (periodoMontoIni == null || periodoMontoFin == null) { 
               /* Sin Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Sin Monto Periodo Inicio");
               sqlFrom.append(", ped_solic_cabec, ");
               sqlFrom.append(" mae_produ, ");
               sqlFrom.append(" ped_solic_posic ");
               
               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = "); 
               sqlWhere.append("                    ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" and ped_solic_cabec.perd_oid_peri = " + periodo);
               sqlWhere.append(" and ped_solic_cabec.oid_soli_cabe = ");
               sqlWhere.append("                    ped_solic_posic.SOCA_OID_SOLI_CABE ");
               sqlWhere.append(" and ped_solic_posic.PROD_OID_PROD = mae_produ.OID_PROD ");
               sqlWhere.append(" and mae_produ.UNEG_OID_UNID_NEGO = " + dtoDetalleMAV.getUnidadNegocio());
               sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie ");
               sqlWhere.append(" having sum(ped_solic_posic.NUM_UNID_POR_ATEN * "); 
               sqlWhere.append("       ped_solic_posic.val_prec_cata_tota_loca) > ");
               sqlWhere.append(dtoDetalleMAV.getMonto());
            } else {
               /* Con Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Con Monto Periodo Inicio");
               sqlFrom.append(", ped_solic_cabec, ");
               sqlFrom.append(" mae_produ, "); 
               sqlFrom.append(" ped_solic_posic, ");
               sqlFrom.append(" cra_perio pEntrada, ");
               sqlFrom.append(" cra_perio pIni, ");
               sqlFrom.append(" cra_perio pFin ");
               
               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = "); 
               sqlWhere.append("                   ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" AND ped_solic_cabec.FEC_FACT IS NOT NULL ");
               sqlWhere.append(" and ped_solic_cabec.oid_soli_cabe = "); 
               sqlWhere.append("                   ped_solic_posic.SOCA_OID_SOLI_CABE ");
               sqlWhere.append(" and ped_solic_posic.PROD_OID_PROD = mae_produ.OID_PROD ");
               sqlWhere.append(" and mae_produ.UNEG_OID_UNID_NEGO = " + dtoDetalleMAV.getUnidadNegocio());
	             sqlWhere.append(" and ped_solic_cabec.perd_oid_peri = pEntrada.OID_PERI ");
	             sqlWhere.append(" and pEntrada.FEC_INIC >= pIni.fec_inic ");
	             sqlWhere.append(" and pEntrada.FEC_FINA <= pFin.fec_fina ");
	             sqlWhere.append(" and pIni.oid_peri = " + periodoMontoIni);
	             sqlWhere.append(" and pFin.oid_peri = " + periodoMontoFin);
	             sqlWhere.append(" and pEntrada.CANA_OID_CANA = pIni.cana_oid_cana ");
	             sqlWhere.append(" and pEntrada.MARC_OID_MARC = pIni.marc_oid_marc ");
	             sqlWhere.append(" and pEntrada.PAIS_OID_PAIS = pIni.pais_oid_pais ");
	             sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie ");
	             sqlWhere.append(" having sum(ped_solic_posic.NUM_UNID_POR_ATEN * ");
               sqlWhere.append("              ped_solic_posic.val_prec_cata_tota_loca) > ");
               sqlWhere.append(dtoDetalleMAV.getMonto());
            }
            
        } else if (subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO_NEGOCIO)) {
            UtilidadesLog.debug("Es SUBCRI_PED_SUP_MONTO_NEGOCIO");
            Long periodoMontoIni = dtoDetalleMAV.getPeriodoIniMonto();
            Long periodoMontoFin = dtoDetalleMAV.getPeriodoFinMonto();
            sqlSelect.append(", sum(ped_solic_posic.NUM_UNID_POR_ATEN * ");
            sqlSelect.append("          ped_solic_posic.val_prec_cata_tota_loca) ");
            if (periodoMontoIni == null || periodoMontoFin == null) { 
               /* Sin Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Sin Monto Periodo Inicio");
               sqlFrom.append(", ped_solic_cabec, ");
               sqlFrom.append(" ped_solic_posic, ");
               sqlFrom.append(" mae_produ ");
               
               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = "); 
               sqlWhere.append("                  ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" and ped_solic_cabec.perd_oid_peri = " + periodo);
               sqlWhere.append(" and ped_solic_cabec.oid_soli_cabe = ");
               sqlWhere.append("                    ped_solic_posic.SOCA_OID_SOLI_CABE ");
               sqlWhere.append(" and ped_solic_posic.PROD_OID_PROD = mae_produ.oid_prod ");
               sqlWhere.append(" and mae_produ.NEGO_OID_NEGO = " + dtoDetalleMAV.getNegocio() );
               sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie ");
               sqlWhere.append(" having sum(ped_solic_posic.NUM_UNID_POR_ATEN * ");
               sqlWhere.append("        ped_solic_posic.val_prec_cata_tota_loca) > ");
               sqlWhere.append(dtoDetalleMAV.getMonto());
            
            } else {
               /* Con Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Con Monto Periodo Inicio");
               sqlFrom.append(", ped_solic_cabec, ");
               sqlFrom.append(" ped_solic_posic, ");
               sqlFrom.append(" mae_produ, ");
               sqlFrom.append(" cra_perio pEntrada, ");
               sqlFrom.append(" cra_perio pIni, ");
               sqlFrom.append(" cra_perio pFin ");
               
               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = "); 
               sqlWhere.append("                     ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" AND ped_solic_cabec.FEC_FACT IS NOT NULL ");
               sqlWhere.append(" and ped_solic_cabec.oid_soli_cabe = "); 
               sqlWhere.append("                ped_solic_posic.SOCA_OID_SOLI_CABE ");
               sqlWhere.append(" and ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
               sqlWhere.append(" and mae_produ.NEGO_OID_NEGO = " + dtoDetalleMAV.getNegocio());
               sqlWhere.append(" and ped_solic_cabec.perd_oid_peri = pEntrada.oid_peri ");
               sqlWhere.append(" and pEntrada.FEC_INIC >= pIni.fec_inic ");
               sqlWhere.append(" and pEntrada.FEC_FINA <= pFin.fec_fina ");
               sqlWhere.append(" and pIni.oid_peri = " + periodoMontoIni);
               sqlWhere.append(" and pFin.oid_peri = " + periodoMontoFin);
               sqlWhere.append(" and pEntrada.CANA_OID_CANA = pIni.cana_oid_cana ");
               sqlWhere.append(" and pEntrada.MARC_OID_MARC = pIni.marc_oid_marc ");
               sqlWhere.append(" and pEntrada.pais_oid_pais = pIni.pais_oid_pais ");
               sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie ");
               sqlWhere.append(" having sum(ped_solic_posic.NUM_UNID_POR_ATEN * ");
               sqlWhere.append("          ped_solic_posic.val_prec_cata_tota_loca) > ");
               sqlWhere.append(dtoDetalleMAV.getMonto());
            }
          
        } else if (subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO_CATALOGO)) {
            UtilidadesLog.debug("Es SUBCRI_PED_SUP_MONTO_CATALOGO");
            Long periodoMontoIni = dtoDetalleMAV.getPeriodoIniMonto();
            Long periodoMontoFin = dtoDetalleMAV.getPeriodoFinMonto();
            sqlSelect.append(", sum(ped_solic_posic.NUM_UNID_POR_ATEN * "); 
            sqlSelect.append("          ped_solic_posic.val_prec_cata_tota_loca) ");
            if (periodoMontoIni == null || periodoMontoFin == null) { 
               /* Sin Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Sin Monto Periodo Inicio");
               sqlFrom.append(" , ped_solic_cabec, ");
               sqlFrom.append(" ped_solic_posic, ");
               sqlFrom.append(" pre_ofert_detal "); 
               
               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" and ped_solic_cabec.perd_oid_peri = " + periodo);
               sqlWhere.append(" and ped_solic_cabec.oid_soli_cabe = ped_solic_posic.SOCA_OID_SOLI_CABE ");
               sqlWhere.append(" and ped_solic_posic.OFDE_OID_DETA_OFER = pre_ofert_detal.OID_DETA_OFER ");
               sqlWhere.append(" and pre_ofert_detal.OCAT_OID_CATAL = " + dtoDetalleMAV.getCatalogo());
               sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie ");
               sqlWhere.append(" having sum(ped_solic_posic.NUM_UNID_POR_ATEN * ");
               sqlWhere.append("              ped_solic_posic.val_prec_cata_tota_loca) > ");
               sqlWhere.append(dtoDetalleMAV.getMonto());            
            } else {
               /* Con Periodo Monto Inicio y Final */ 
               UtilidadesLog.debug("Con Monto Periodo Inicio");
               sqlFrom.append(", ped_solic_cabec, ");
               sqlFrom.append(" ped_solic_posic, ");
               sqlFrom.append(" cra_perio pEntrada, ");
               sqlFrom.append(" cra_perio pIni, ");
               sqlFrom.append(" cra_perio pFin, ");
               sqlFrom.append(" pre_ofert_detal ");

               sqlWhere.append(" and v_mae_tipif_clien.clie_oid_clie = ped_solic_cabec.clie_oid_clie ");
               sqlWhere.append(" AND ped_solic_cabec.FEC_FACT IS NOT NULL ");
               sqlWhere.append(" and ped_solic_cabec.oid_soli_cabe = ped_solic_posic.SOCA_OID_SOLI_CABE ");
               sqlWhere.append(" and ped_solic_posic.OFDE_OID_DETA_OFER = pre_ofert_detal.OID_DETA_OFER ");
               sqlWhere.append(" and pre_ofert_detal.OCAT_OID_CATAL = " + dtoDetalleMAV.getCatalogo());
               sqlWhere.append(" and ped_solic_cabec.perd_oid_peri = pEntrada.OID_PERI ");
               sqlWhere.append(" and pEntrada.FEC_INIC >= pIni.fec_inic ");
               sqlWhere.append(" and pEntrada.fec_fina <= pFin.fec_fina ");
               sqlWhere.append(" and pIni.oid_peri = " + periodoMontoIni);
               sqlWhere.append(" and pFin.oid_peri = " + periodoMontoFin);
               sqlWhere.append(" and pEntrada.CANA_OID_CANA = pIni.CANA_OID_CANA ");
               sqlWhere.append(" and pEntrada.MARC_OID_MARC = pIni.marc_oid_marc ");
               sqlWhere.append(" and pEntrada.PAIS_OID_PAIS = pIni.pais_oid_pais ");
               sqlWhere.append(" group by v_mae_tipif_clien.clie_oid_clie  ");
               sqlWhere.append(" having sum(ped_solic_posic.NUM_UNID_POR_ATEN * ");
               sqlWhere.append("              ped_solic_posic.val_prec_cata_tota_loca) > ");
               sqlWhere.append(dtoDetalleMAV.getMonto());
            }        
        }
        
        
        /* ------ Ejecuta la query ------- */
        sQuery = sqlSelect.toString() + sqlFrom.toString() + sqlWhere.toString();
        UtilidadesLog.debug("sQuery: " + sQuery);
        
        BelcorpService bs = BelcorpService.getInstance();
        r = null;
        try {
           r = bs.dbService.executeStaticQuery(sQuery);
           UtilidadesLog.debug("r: " + r);
        } catch (Exception ex) {
           UtilidadesLog.error(ex);
           ex.printStackTrace();
           String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError) );
        }
        
        if (!r.esVacio()) {
           int cantRegistros = r.getRowCount();
           Long oidCliente = null; 
           Long oidDetalleMAV = dtoDetalleMAV.getOid();           
           DTOEnvioMAV dtoEnvioBuffer = null;
           
           arrayDtoEnvio = new DTOEnvioMAV[cantRegistros];
           for (int i=0 ; i < cantRegistros; i++) {
              dtoEnvioBuffer = new DTOEnvioMAV();
              oidCliente = Long.valueOf(r.getValueAt(i,0).toString());
              
              dtoEnvioBuffer.setOidCliente(oidCliente);
              dtoEnvioBuffer.setOidDetalle(oidDetalleMAV);
              arrayDtoEnvio[i] = dtoEnvioBuffer;
           }
        }
        
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.obtenerClienteCondicion(DTODetalleMAV DTOE, Long periodo):Salida");
        return arrayDtoEnvio;
    }

    private void removerTablaFrom(Hashtable from, Hashtable to, String pk) {
        if(from.get(pk) != null)
            to.put(pk, from.remove(pk));
    }

    /**
    Se obtienen los envíos, de entidad "Envío MAV" cuyo tipo de despacho sea "Siempre inicio"
    o "Siempre fin" (según activación del caso de uso, solo una de las condiciones en cada caso,
    "Siempre inicio" en activación como proceso de CRA y "Siempre fin" en el otro caso), el
    estado de autorización "Autorizado" o "Sin autorización" y cuyo estado de envío sea
    "Pendiente" de entre los pertenecientes al país, marca, canal, zona y período finalizado.
    Se tiene en cuenta que un registro correcto para el período será aquel definido para un
    rango de "período" y "período fin" que incluya el período de la solicitud.
    Las líneas se agruparán por cliente y fecha de entrega para su proceso
    */
    /*public DTOEnvioSolicitudCliente[] obtenerDatosSolicitudCliente(Long pais, Long modulo, Long periodo)*/
    public RecordSet obtenerDatosSolicitudCliente(Long pais, Long modulo, Long periodo, ArrayList actividadesMAV)
        throws MareException {
        //Incidencia 8380 (lista) y 8752(listo)
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.obtenerDatosSolicitudCliente(Long pais, Long modulo, Long periodo):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet r = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        query.append(" SELECT   mav_envio.clie_oid_clie, mav_envio.fec_entr, ");
        query.append(" mav_envio.oid_envi, ");
        query.append(" mav_envio.num_unid, mav_envio.val_prec_stnd, mav_envio.val_prec, ");
        query.append(" mav_envio.val_prec_cont, mav_envio.denv_oid_deta_mav, ");
        query.append(" mav_envio.acti_oid_acti, mav_activ.tspa_oid_tipo_soli_pais_dest, ");
        query.append(" mav_activ.tpos_oid_tipo_posi_dest, mav_activ.stpo_oid_subt_posi_envi, ");
        query.append(" mav_detal_mav.prod_oid_prod, mav_detal_mav.ticl_oid_tipo_clie, ");
        query.append(" mav_detal_mav.ind_envi_mens, mav_detal_mav.tccl_oid_tipo_clas, ");
        query.append(" mav_detal_mav.clas_oid_clas, mav_detal_mav.aest_oid_esta_acti, ");
        query.append(" ped_tipo_solic.acce_oid_acce, SYSDATE, seg_pais.mone_oid_mone, ");
        query.append(" pre_ofert_detal.val_codi_vent, pre_ofert_detal.oid_deta_ofer, ");
        query.append(" mae_clien.cod_clie, mae_clien_tipo_subti.sbti_oid_subt_clie, ");
        query.append(" pre_matri_factu_cabec.VAL_TIPO_CAMB, mav_envio.num_mens, ");
        query.append(" msg_mensa.COD_MENS, ");
        query.append(" pre_ofert_detal.VAL_TEXT_BREV, ");
        query.append(" mav_detal_mav.PERD_OID_PERI, ");
        query.append(" mav_detal_mav.PERD_OID_PERI_FINA ");
        query.append(" FROM mav_envio, ");
        query.append(" mav_activ_tipo_despa, ");
        query.append(" pre_matri_factu, ");
        query.append(" pre_matri_factu_cabec, ");
        query.append(" mav_detal_mav, ");
        query.append(" mav_activ, ");
        query.append(" ped_tipo_solic_pais, ");
        query.append(" ped_tipo_solic, ");
        query.append(" cra_perio, ");
        query.append(" seg_pais, ");
        query.append(" pre_ofert_detal, ");
        query.append(" mae_clien, ");
        query.append(" mae_clien_tipo_subti, ");        
        query.append(" msg_mensa, ");
        query.append(" zon_zona ");        
        query.append(" WHERE mav_envio.acti_oid_acti = mav_activ.oid_acti ");
        query.append(" AND mav_envio.atde_oid_acti_tipo_desp = ");
        query.append("                                        mav_activ_tipo_despa.oid_acti_tipo_desp ");
        query.append(" AND mav_activ.tspa_oid_tipo_soli_pais_dest = ");
        query.append("                                        ped_tipo_solic_pais.oid_tipo_soli_pais ");
        query.append(" AND ped_tipo_solic_pais.tsol_oid_tipo_soli = ped_tipo_solic.oid_tipo_soli ");
        
        String sModulo = modulo.toString();
        if (sModulo.equals(ConstantesSEG.MODULO_CRA)) {
          query.append(" AND mav_activ_tipo_despa.tdch_oid_tipo_desp = ");
          query.append(ConstantesMAV.DESPACHO_INI_PERIODO);
        //19-06-2007, modificado por incidencia SiCC-20070288 (Sapaza), se filtra por lista de actividades MAV
        } else if(ConstantesSEG.MODULO_MAV.equals(modulo.toString())) {
          query.append(" AND mav_activ.oid_acti IN " + actividadesMAV.toString().replace('[','(').replace(']',')') );
        } else {
          query.append(" AND mav_activ_tipo_despa.tdch_oid_tipo_desp = ");
          query.append(ConstantesMAV.DESPACHO_FIN_PERIODO);
        }
        
        query.append(" AND (mav_envio.esen_oid_esta_envi = " + ConstantesMAV.ESTADO_ENVIO_AUTORIZADO);
        query.append(" OR mav_envio.esen_oid_esta_envi = " + ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION + ") ");
        query.append(" AND mav_envio.ind_envi = '" + ConstantesMAV.INDICADOR_PENDIENTE_ENVIO + "' ");
        query.append(" AND mav_envio.mafa_oid_matr_fact = pre_matri_factu.oid_matr_fact ");
        query.append(" AND pre_matri_factu.ofde_oid_deta_ofer = ");
        query.append("                               pre_ofert_detal.oid_deta_ofer ");
        query.append(" AND pre_matri_factu.mfca_oid_cabe = pre_matri_factu_cabec.oid_cabe ");
        query.append(" and cra_perio.OID_PERI = " + periodo);
        query.append(" AND pre_matri_factu_cabec.perd_oid_peri = cra_perio.oid_peri ");
        query.append(" AND seg_pais.oid_pais = cra_perio.pais_oid_pais ");
        query.append(" AND mav_detal_mav.oid_deta_mav = mav_envio.denv_oid_deta_mav ");
        query.append(" AND mae_clien.oid_clie = mav_envio.clie_oid_clie ");
        query.append(" AND mae_clien_tipo_subti.clie_oid_clie = mae_clien.oid_clie ");
        query.append(" AND mae_clien_tipo_subti.ticl_oid_tipo_clie = ");
        query.append("                            mav_detal_mav.ticl_oid_tipo_clie ");
     	  query.append(" and mav_detal_mav.MENS_OID_MENS = msg_mensa.OID_MENS(+) ");
        query.append(" AND mae_clien.OID_CLIE = zon_zona.CLIE_OID_CLIE (+) ");
        query.append(" AND (zon_zona.IND_ACTI = 1 or zon_zona.IND_ACTI is null) ");
        query.append(" AND (zon_zona.IND_BORR = 0 or zon_zona.IND_BORR is null) ");          
        query.append(" ORDER BY mav_envio.clie_oid_clie, ");
        query.append("          mav_envio.fec_entr, ");
        query.append("          mav_detal_mav.prod_oid_prod ");
        
        try {
           r = bs.dbService.executeStaticQuery(query.toString());
           UtilidadesLog.debug("r: " + r);
        } catch (Exception ex) {
           ex.printStackTrace();
           UtilidadesLog.error(ex);
           String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError) );
        }
  
        /*query.append("SELECT ");
        query.append("A.OID_ENVI, ");
        query.append("A.FEC_ENTR, ");
        query.append("A.NUM_UNID, ");
        query.append("A.VAL_PREC_STND, ");
        query.append("A.VAL_PREC, ");
        query.append("A.VAL_PREC_CONT, ");
        query.append("A.DENV_OID_DETA_MAV, ");
        query.append("A.CLIE_OID_CLIE, ");
        query.append("A.ACTI_OID_ACTI, ");
        query.append("B.TICL_OID_TIPO_CLIE, ");
        query.append("B.IND_ENVI_MENS, ");
        query.append("B.TCCL_OID_TIPO_CLAS, ");
        query.append("B.CLAS_OID_CLAS, ");
        query.append("B.AEST_OID_ESTA_ACTI, ");
        query.append("F.ZORG_OID_REGI, ");
        query.append("F.ZZON_OID_ZONA, ");
        query.append("G.SBTI_OID_SUBT_CLIE, ");
        query.append("H.TSPA_OID_TIPO_SOLI_PAIS_DEST,  ");
        query.append("H.TPOS_OID_TIPO_POSI_DEST, ");
        query.append("H.STPO_OID_SUBT_POSI_ENVI, ");
        query.append("J.ACCE_OID_ACCE, ");
        query.append("L.MONE_OID_MONE, ");
        query.append("N.OID_DETA_OFER, ");
        query.append("N.VAL_TEXT_BREV, ");
        query.append("O.VAL_TIPO_CAMB, ");
        query.append("P.COD_MENS ");
        query.append("FROM MAV_ENVIO A, ");
        query.append("MAV_DETAL_MAV B, ");
        query.append("CRA_PERIO C, ");
        query.append("CRA_PERIO D, ");
        query.append("CRA_PERIO E, ");
        query.append("MAV_DETAL_MAV_UNIDA_ADMIN F, ");
        query.append("MAE_CLIEN_TIPO_SUBTI G, ");
        query.append("MAV_ACTIV H, ");
        query.append("PED_TIPO_SOLIC_PAIS I, ");
        query.append("PED_TIPO_SOLIC J, ");
        query.append("SEG_PAIS L, ");
        query.append("PRE_MATRI_FACTU M, ");
        query.append("PRE_OFERT_DETAL N, ");
        query.append("PRE_MATRI_FACTU_CABEC O, ");
        query.append("MSG_MENSA P, ");
        // Agregado por ssantana, 23/8/2005, pedido de JPBosnjak        
        query.append(" MAV_ACTIV_TIPO_DESPA DESP ");
        // Fin Agregado ssantana, 23/8/2005, pedido de JPBosnjak        
        query.append(" WHERE A.DENV_OID_DETA_MAV = B.OID_DETA_MAV AND ");

        // Agregado por ssantana, 23/8/2005, pedido de JPBosnjak
        query.append(" DESP.OID_ACTI_TIPO_DESP = B.ATDE_OID_ACTI_TIPO_DESP ");
        
        if(ConstantesSEG.MODULO_CRA.equals(modulo.toString()))
           query.append(" AND DESP.TDCH_OID_TIPO_DESP = ").append(ConstantesMAV.DESPACHO_INI_PERIODO);
         else if(ConstantesSEG.MODULO_FAC.equals(modulo.toString()))
            query.append(" AND DESP.TDCH_OID_TIPO_DESP = ").append(ConstantesMAV.DESPACHO_FIN_PERIODO);
        // Fin Agregado ssantana, 23/8/2005, pedido de JPBosnjak
        
        
        query.append(" AND (A.ESEN_OID_ESTA_ENVI = ").append(ConstantesMAV.ESTADO_ENVIO_AUTORIZADO);
        query.append(" OR A.ESEN_OID_ESTA_ENVI = ").append(ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION).append(") ");
        query.append("AND A.IND_ENVI = '").append(ConstantesMAV.INDICADOR_PENDIENTE_ENVIO).append("' ");
        query.append(" AND C.OID_PERI = ").append(periodo);
        query.append(" AND D.OID_PERI = B.PERD_OID_PERI ");
        query.append("AND E.OID_PERI = B.PERD_OID_PERI_FINA ");
        query.append("AND C.FEC_INIC >= D.FEC_INIC ");
        query.append("AND C.FEC_FINA <= E.FEC_FINA ");
        query.append("AND B.OID_DETA_MAV = F.DENV_OID_DETA_MAV (+) ");
        query.append("AND G.CLIE_OID_CLIE = A.CLIE_OID_CLIE ");
        query.append("AND G.TICL_OID_TIPO_CLIE = B.TICL_OID_TIPO_CLIE ");
        query.append("AND A.ACTI_OID_ACTI = H.OID_ACTI ");
        query.append("AND H.TSPA_OID_TIPO_SOLI_PAIS_DEST = I.OID_TIPO_SOLI_PAIS ");
        query.append("AND I.TSOL_OID_TIPO_SOLI = J.OID_TIPO_SOLI ");
        query.append("AND L.OID_PAIS = ").append(pais);
        // Quitado por ssantana, 3/8/2005, inc. 15618
        // query.append(" AND A.MAFA_OID_MATR_FACT = M.OID_MATR_FACT ");
        // Quitado por ssantana, 3/8/2005, inc. 15618
        
        query.append("AND M.OFDE_OID_DETA_OFER = N.OID_DETA_OFER ");
        query.append("AND M.MFCA_OID_CABE = O.OID_CABE ");
        query.append("AND O.PERD_OID_PERI = ").append(periodo);
        query.append(" AND B.MENS_OID_MENS = P.OID_MENS ");
        query.append("ORDER BY A.CLIE_OID_CLIE, A.FEC_ENTR ");

        BelcorpService belcorpService = BelcorpService.getInstance();
        RecordSet rs = null;

        try {
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            if(e instanceof MareException)
                throw (MareException)e;
            else
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOEnvioSolicitudCliente[] dtoEnvio = null;

        if((rs != null) && !rs.esVacio()) {
            dtoEnvio = new DTOEnvioSolicitudCliente[rs.getRecords().size()];

            for(int i = 0; i < rs.getRecords().size(); ++i) {
                DTOEnvioSolicitudCliente dto = new DTOEnvioSolicitudCliente();

                dto.setOidEnvioMAV(this.getLongFromResultSet(rs.getValueAt(i, "OID_ENVI")));
                dto.setFechaEntrega((rs.getValueAt(i, "FEC_ENTR") != null)
                    ? new Timestamp(((java.sql.Date)rs.getValueAt(i, "FEC_ENTR")).getTime()) : null);

                dto.setNumeroUnidades(this.getLongFromResultSet(rs.getValueAt(i, "NUM_UNID")));
                dto.setPrecio((BigDecimal)rs.getValueAt(i, "VAL_PREC_STND"));
                dto.setPrecio((BigDecimal)rs.getValueAt(i, "VAL_PREC"));
                dto.setPrecioContable((BigDecimal)rs.getValueAt(i, "VAL_PREC_CONT"));
                dto.setOidDetalleMAV(this.getLongFromResultSet(rs.getValueAt(i, "DENV_OID_DETA_MAV")));
                dto.setOidCliente(this.getLongFromResultSet(rs.getValueAt(i, "CLIE_OID_CLIE")));
                dto.setOidActividad(this.getLongFromResultSet(rs.getValueAt(i, "ACTI_OID_ACTI")));
                dto.setOidTipoCliente(this.getLongFromResultSet(rs.getValueAt(i, "TICL_OID_TIPO_CLIE")));
                Long aux = this.getLongFromResultSet(rs.getValueAt(i, "IND_ENVI_MENS"));

                if((aux != null) && (aux.intValue() == 1))
                    dto.setIndEnvioMensaje(new Boolean(true));
                else
                    dto.setIndEnvioMensaje(new Boolean(false));

                dto.setOidTipoClasificacion(this.getLongFromResultSet(rs.getValueAt(i, "TCCL_OID_TIPO_CLAS")));
                dto.setOidClasificacion(this.getLongFromResultSet(rs.getValueAt(i, "CLAS_OID_CLAS")));
                dto.setOidEstadoMAV(this.getLongFromResultSet(rs.getValueAt(i, "AEST_OID_ESTA_ACTI")));
                dto.setOidRegion(this.getLongFromResultSet(rs.getValueAt(i, "ZORG_OID_REGI")));
                dto.setOidZona(this.getLongFromResultSet(rs.getValueAt(i, "ZZON_OID_ZONA")));
                dto.setOidSubtipoCliente(this.getLongFromResultSet(rs.getValueAt(i, "SBTI_OID_SUBT_CLIE")));
                dto.setOidTipoSolicitud(this.getLongFromResultSet(rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS_DEST")));
                dto.setOidTipoPosicion(this.getLongFromResultSet(rs.getValueAt(i, "TPOS_OID_TIPO_POSI_DEST")));
                dto.setOidSubtipoPosicion(this.getLongFromResultSet(rs.getValueAt(i, "STPO_OID_SUBT_POSI_ENVI")));
                dto.setOidAcceso(this.getLongFromResultSet(rs.getValueAt(i, "ACCE_OID_ACCE")));
                dto.setOidMoneda(this.getLongFromResultSet(rs.getValueAt(i, "MONE_OID_MONE")));
                dto.setOidDetalleOferta(this.getLongFromResultSet(rs.getValueAt(i, "OID_DETA_OFER")));
                dto.setTextoBreve(this.getStringFromResultSet(rs.getValueAt(i, "VAL_TEXT_BREV")));
                dto.setTipoCambio((BigDecimal)rs.getValueAt(i, "VAL_TIPO_CAMB"));
                dto.setCodMensaje(this.getStringFromResultSet(rs.getValueAt(i, "COD_MENS")));

                dtoEnvio[i] = dto;
            }
             //for
        }*/
         //if
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.obtenerDatosSolicitudCliente(Long pais, Long modulo, Long periodo):Salida");
        return r;
    }


    private Long getLongFromResultSet(Object dato) {
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.getLongFromResultSet(Object dato):Entrada");
        Long l = null;

        if(dato != null)
            l = new Long(((BigDecimal)dato).longValue());

        UtilidadesLog.info("DAOEnvioIniFinPeriodo.getLongFromResultSet(Object dato):Salida");
        return l;
    }

    private Integer getIntegerFromResultSet(Object dato) {
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.getIntegerFromResultSet(Object dato):Entrada");
        Integer i = null;

        if(dato != null)
            i = new Integer(((BigDecimal)dato).intValue());

        UtilidadesLog.info("DAOEnvioIniFinPeriodo.getIntegerFromResultSet(Object dato):Salida");
        return i;
    }

    private Double getDoubleFromResultSet(Object dato) {
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.getDoubleFromResultSet(Object dato):Entrada");
        Double d = null;

        if(dato != null)
            d = new Double(((BigDecimal)dato).doubleValue());

        UtilidadesLog.info("DAOEnvioIniFinPeriodo.getDoubleFromResultSet(Object dato):Salida");
        return d;
    }

    private String getStringFromResultSet(Object dato) {
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.getStringFromResultSet(Object dato):Entrada");
        String s = null;

        if(dato != null)
            //s = ((BigDecimal)dato).toString();
            s = (String)dato;
        UtilidadesLog.info("DAOEnvioIniFinPeriodo.getStringFromResultSet(Object dato):Salida");
        return s;
    }
    
/**
   * @author: ssantana, 21/7/2005
   * @throws java.lang.Exception
   * @return String
   * @param String formato
   * @param java.sql.Date fechaOrigen
   */
  private String truncaFecha(java.sql.Date fechaOrigen, String formato) throws Exception {
    /*
     * Recibe un sql.Date y obtener el String que representa la fecha segun "formato".
     */
     UtilidadesLog.info("DAOEnvioIniFinPeriodo.truncaFecha(java.sql.Date fechaOrigen, String formato):Entrada");
     SimpleDateFormat simpleDate = new SimpleDateFormat(formato);
     String sFechaFormateada = simpleDate.format(fechaOrigen);
     UtilidadesLog.debug("sFechaFormateada: " + sFechaFormateada);
     UtilidadesLog.info("DAOEnvioIniFinPeriodo.truncaFecha(java.sql.Date fechaOrigen, String formato):Salida");     
     return sFechaFormateada;
     
  }    
  
  
  /**
   * @author: ssantana, 09/06/2006
   * @throws es.indra.mare.common.exception.MareException
   * @return String
   * @param Long[] array
   */
  private String parseaArray(Long[] array) throws MareException {
     StringBuffer sCadena = new StringBuffer("");
     
     Long valorBuffer = null;
     int longArray = array.length;
     
     for (int i=0; i<longArray; i++) {
        valorBuffer = array[i]; 
        if (i != 0){ 
          sCadena.append(",");
        }
        sCadena.append(valorBuffer);
     }
     
     return sCadena.toString();
    
  }
  
  
  private String[] obtieneFechasPeriodo(Long oidPeriodo) throws MareException {
      String[] sAnyosRetorno = new String[4];
      try {
         SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM");
         SimpleDateFormat simpleDateAnyo = new SimpleDateFormat("yyyy");
         PeriodoLocalHome pLocalHome = new PeriodoLocalHome();
         PeriodoLocal pLocal = pLocalHome.findByPrimaryKey(oidPeriodo);
         
         java.sql.Date dateFechaInicio = pLocal.getFechainicio();
         java.sql.Date dateFechaFin = pLocal.getFechaFin();
         
         String sFechaIni = simpleDate.format(dateFechaInicio);
         String sFechaFin = simpleDate.format(dateFechaFin);
         
         String sAnyoIni = simpleDateAnyo.format(dateFechaInicio);
         String sAnyoFin = simpleDateAnyo.format(dateFechaFin);
         
         
         sAnyosRetorno[0] = sFechaIni;
         sAnyosRetorno[1] = sFechaFin;
         sAnyosRetorno[2] = sAnyoIni;
         sAnyosRetorno[3] = sAnyoFin;
        
      } catch (NoResultException fEx) {
         fEx.printStackTrace();
         UtilidadesLog.error(fEx);
         String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(fEx, UtilidadesError.armarCodigoError(codigoError));
      } catch (MareException mEx) {
         throw mEx;
      } catch (Exception ex) {
         ex.printStackTrace();
         UtilidadesLog.error(ex);
         String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
     }

     return sAnyosRetorno;
   }

    public DTOUnidadAdministrativa obtenerUnidadAdministrativa(Long cliente, Long periodo) throws MareException {
            UtilidadesLog.info("DAOEnvioIniFinPeriodo.obtenerUnidadAdministrativa(cliente, periodo): Entrada"); 
            RecordSet resultado = new RecordSet();
            DTOUnidadAdministrativa dtoS = new DTOUnidadAdministrativa();

            StringBuffer query = new StringBuffer();

            try {
                query.append(" SELECT distinct sub.PAIS_OID_PAIS, sub.MARC_OID_MARC, sub.CANA_OID_CANA, OID_SUBG_VENT,   ");
                query.append(" OID_REGI, OID_ZONA, OID_SECC, TERR_OID_TERR, t.COD_NSE1, t.COD_NSE2, t.COD_NSE3,  ");
                query.append(" OID_TERR_ADMI,pi.FEC_INIC,unid.PERD_OID_PERI_INI,unid.PERD_OID_PERI_FIN  ");
                query.append(" FROM MAE_CLIEN_UNIDA_ADMIN unid,  ");
                query.append("   ZON_TERRI_ADMIN tadm,    ");
                query.append("       ZON_TERRI t,   ");
                query.append("       ZON_SECCI,   ");
                query.append("       ZON_ZONA ZZON,    ");
                query.append("       ZON_REGIO,  ");
                query.append("       ZON_SUB_GEREN_VENTA sub,  ");
                query.append("   CRA_PERIO pi,   ");
                query.append("       CRA_PERIO pi2  ");
                query.append(" WHERE  ");
                query.append(" unid.CLIE_OID_CLIE = " + cliente);
                query.append(" AND ZTAD_OID_TERR_ADMI = OID_TERR_ADMI  ");
                query.append(" AND TERR_OID_TERR = OID_TERR  ");
                query.append(" AND ZSCC_OID_SECC = OID_SECC  ");
                query.append(" AND ZZON_OID_ZONA= OID_ZONA  ");
                query.append(" AND ZORG_OID_REGI = OID_REGI  ");
                /* Agregado por SiCC20080750 ----- 06/10/2008 ------ AL */
                query.append(" AND ZZON.IND_ACTI = 1 AND ZZON.IND_BORR =0 ");
                /* Agregado por SiCC20080750 ----- 06/10/2008 ------ AL */
                query.append(" AND ZSGV_OID_SUBG_VENT = OID_SUBG_VENT   ");
                query.append(" AND unid.PERD_OID_PERI_INI = pi.OID_PERI  ");
                query.append(" AND pi.FEC_INIC <= (SELECT FEC_INIC FROM CRA_PERIO WHERE OID_PERI = " + periodo + ")");
                query.append(" AND ((unid.PERD_OID_PERI_FIN = pi2.OID_PERI   ");
                query.append("     AND pi2.FEC_FINA >= (SELECT FEC_FINA FROM CRA_PERIO WHERE OID_PERI = " + periodo + "))");
                query.append(" OR unid.PERD_OID_PERI_FIN is NULL)  ");
                query.append(" order by pi.FEC_INIC desc  ");

                resultado = UtilidadesBD.executeQuery(query.toString());
            } catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (resultado.esVacio()) {
                UtilidadesLog.info("DAOEnvioIniFinPeriodo.obtenerUnidadAdministrativa(cliente, periodo): Salida"); 
                return null;
            } else {
                dtoS.setNSE1(UtilidadesBD.convertirAString(resultado.getValueAt(0, "COD_NSE1")));
                dtoS.setNSE2(UtilidadesBD.convertirAString(resultado.getValueAt(0, "COD_NSE2")));
                dtoS.setNSE3(UtilidadesBD.convertirAString(resultado.getValueAt(0, "COD_NSE3")));
                dtoS.setOidCanal(UtilidadesBD.convertirALong(resultado.getValueAt(0, "CANA_OID_CANA")));
                dtoS.setOidMarca(UtilidadesBD.convertirALong(resultado.getValueAt(0, "MARC_OID_MARC")));
                dtoS.setOidPais(UtilidadesBD.convertirALong(resultado.getValueAt(0, "PAIS_OID_PAIS")));
                dtoS.setOidRegion(UtilidadesBD.convertirALong(resultado.getValueAt(0, "OID_REGI")));
                dtoS.setOidSeccion(UtilidadesBD.convertirALong(resultado.getValueAt(0, "OID_SECC")));
                dtoS.setOidSGV(UtilidadesBD.convertirALong(resultado.getValueAt(0, "OID_SUBG_VENT")));
                dtoS.setOidTerritorio(UtilidadesBD.convertirALong(resultado.getValueAt(0, "TERR_OID_TERR")));
                dtoS.setOidTerritorioAdministrativo(UtilidadesBD.convertirALong(resultado.getValueAt(0, "OID_TERR_ADMI")));
                dtoS.setOidZona(UtilidadesBD.convertirALong(resultado.getValueAt(0, "OID_ZONA")));
                
                UtilidadesLog.info("DAOEnvioIniFinPeriodo.obtenerUnidadAdministrativa(cliente, periodo): Salida"); 

                return dtoS;
            }
        }   
}