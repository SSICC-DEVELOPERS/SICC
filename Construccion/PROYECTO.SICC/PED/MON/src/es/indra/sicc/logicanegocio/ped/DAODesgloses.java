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
/**
 * @Autor: Hugo A. Mansi
 * @Fecha: 28/10/2004
 * @DMCO: SICC-DMCO-PED-201-354-N029
 * @Modifico: --
 * @Modificado: --
 * @Descripción:--
 * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
 *
 */
package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.ped.DTOBuscarSeguimientoPedidos;
import es.indra.sicc.dtos.ped.DTOEDesglose;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.text.SimpleDateFormat;

import java.util.Date;


public class DAODesgloses {
    public DAODesgloses() {
    }

    /**
         * @Autor: Hugo A. Mansi
         * @Fecha: 28/10/2004
         * @DMCO: SICC-DMCO-PED-201-354-N029
         * @Modifico: --
         * @Modificado: --
         * @Descripción: Instancia el BelcorpService
         * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
         *
         */
    private BelcorpService getBelcorpService() throws MareException {
        try {
            BelcorpService bs = BelcorpService.getInstance();
            return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    }

    /**
     * @Autor: Hugo A. Mansi
     * @Fecha: 28/10/2004
     * @DMCO: SICC-DMCO-PED-201-354-N029
     * @Modifico: --
     * @Modificado: --
     * @Descripción: Hace una consulta JDBC sobre la tabla PED_SOLIC_CABEC
     * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
     *
     */
    public DTOSalida agrupacionTipoSubtipoClasificacionCliente(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("DAODesgloses.agrupacionTipoSubtipoClasificacionCliente(DTOEDesglose dto): Entrada ");
        DTOSalida dtoOut = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = getBelcorpService();
        UtilidadesLog.debug(dto.getHacerPaginacion());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = formato.format(dto.getFechaInicio());
        String fechaFin = "";
        if (dto.getFechaFin() != null) {
          fechaFin = formato.format(dto.getFechaFin());
        }

        if (!dto.getHacerPaginacion().booleanValue()) {
        /* Modificacion por Performance alorenzo 01/08/2006 */
             switch (dto.getGrupoProcesos().intValue()) {
                case 1: query.append(" SELECT SUM(SCA.VAL_ACUM_GP1) cantidad "); break;
                case 2: query.append(" SELECT SUM(SCA.VAL_ACUM_GP2) cantidad "); break;
                case 3: query.append(" SELECT SUM(SCA.VAL_ACUM_GP3) cantidad "); break;
                case 4: query.append(" SELECT SUM(SCA.VAL_ACUM_GP4) cantidad "); break;
                case 5: query.append(" SELECT SUM(SCA.VAL_ACUM_GP5) cantidad "); break;
            }
            query.append(" FROM PED_SOLIC_CABEC_ACUM SCA ");
            query.append(" WHERE SCA.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND SCA.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
            if (dto.getFechaFin() != null) {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaFin + "', 'YYYY-MM-DD') ");
            } else {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') ");
            }
        /*
            query.append(" SELECT  COUNT(*) cantidad ");
            query.append(" FROM PED_SOLIC_CABEC, MAE_CLIEN, V_MAE_TIPIF_CLIEN,V_GEN_I18N_SICC I18N_TC, ");
            query.append(" V_GEN_I18N_SICC I18N_SUBTC, V_GEN_I18N_SICC I18N_TCLASE,V_GEN_I18N_SICC I18N_CLASE ");
            query.append(" WHERE PED_SOLIC_CABEC.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" AND PED_SOLIC_CABEC.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND PED_SOLIC_CABEC.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            query.append(" AND PED_SOLIC_CABEC.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
            if (dto.getFechaFin() != null) {
              query.append(" AND PED_SOLIC_CABEC.FEC_PROG_FACT BETWEEN TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
              query.append(" AND TO_DATE('" + fechaFin + "','YYYY-MM-DD')");
            } else {
              query.append(" AND PED_SOLIC_CABEC.FEC_PROG_FACT >= TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
            }
            query.append(" AND PED_SOLIC_CABEC.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE ");
            query.append(" AND MAE_CLIEN.OID_CLIE = V_MAE_TIPIF_CLIEN.CLIE_OID_CLIE ");
            query.append(" AND I18N_TC.ATTR_ENTI = 'MAE_TIPO_CLIEN' AND I18N_TC.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND I18N_TC.VAL_OID = V_MAE_TIPIF_CLIEN.TICL_OID_TIPO_CLIE ");
            query.append(" AND I18N_SUBTC.ATTR_ENTI = 'MAE_SUBTI_CLIEN' AND I18N_SUBTC.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND I18N_SUBTC.VAL_OID = V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE ");
            query.append(" AND I18N_TCLASE.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' AND I18N_TCLASE.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND I18N_TCLASE.VAL_OID = V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI ");
            query.append(" AND I18N_CLASE.ATTR_ENTI = 'MAE_CLASI' AND I18N_CLASE.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND I18N_CLASE.VAL_OID = V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS ");
        */
        /* Fin Modificacion por Performance alorenzo 01/08/2006 */
        } else {
        /* Modificacion por Performance alorenzo 01/08/2006 */
            query.append(" SELECT ROWNUM OID , OID_TIPO_CLIENTE, ");
            query.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC("+ dto.getOidIdioma() +", OID_TIPO_CLIENTE, 'MAE_TIPO_CLIEN') tipocliente, ");
            query.append("        SBTI_OID_SUBT_CLIE, ");
            query.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC("+ dto.getOidIdioma() +", SBTI_OID_SUBT_CLIE, 'MAE_SUBTI_CLIEN') subtipocliente, ");
            query.append("        TCCL_OID_TIPO_CLASI, ");
            query.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC("+ dto.getOidIdioma() +", TCCL_OID_TIPO_CLASI, 'MAE_TIPO_CLASI_CLIEN') tipoclase, ");
            query.append("        CLAS_OID_CLAS, ");
            query.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC("+ dto.getOidIdioma() +", CLAS_OID_CLAS, 'MAE_CLASI') clase, ");
            query.append("        numerosolicitudes ");
            query.append(" FROM ");
            query.append("    (		 ");
            query.append("      SELECT VTC.TICL_OID_TIPO_CLIE OID_TIPO_CLIENTE, ");
		        query.append("             VTC.SBTI_OID_SUBT_CLIE, ");
		  	    query.append("             VTC.TCCL_OID_TIPO_CLASI, ");
		  	    query.append("             VTC.CLAS_OID_CLAS, ");
            query.append("             COUNT (*) numerosolicitudes ");
            query.append("      FROM PED_SOLIC_CABEC PSC, ");
            query.append("           V_MAE_TIPIF_CLIEN VTC ");
            query.append("      WHERE PSC.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append("        AND PSC.ZZON_OID_ZONA = " + dto.getZona());
            query.append("        AND PSC.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            query.append("        AND PSC.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
             if (dto.getFechaFin() != null) {
                query.append(" AND PSC.FEC_PROG_FACT >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND PSC.FEC_PROG_FACT <= TO_DATE('" + fechaFin + "', 'YYYY-MM-DD') ");
            } else {
                query.append(" AND PSC.FEC_PROG_FACT >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND PSC.FEC_PROG_FACT <= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') ");
            }
            query.append("        AND PSC.CLIE_OID_CLIE = VTC.CLIE_OID_CLIE");
            query.append("      GROUP BY VTC.TICL_OID_TIPO_CLIE,");
  	   		  query.append("               VTC.SBTI_OID_SUBT_CLIE,");
  	   		  query.append("               VTC.TCCL_OID_TIPO_CLASI,");
  	   		  query.append("               VTC.CLAS_OID_CLAS	)		 ");
            query.append("      ORDER BY OID_TIPO_CLIENTE ");
            

/*        
            query.append(" SELECT V_MAE_TIPIF_CLIEN.TICL_OID_TIPO_CLIE OID, ");
            //Descripción internacionalizada del tipo de cliente para V_MAE_TIPIF_CLIEN.TICL_OID_TIPO_CLIE
            query.append(" I18N_TC.VAL_I18N tipoCliente, V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE, ");
            //Descripción internacionalizada del subtipo de cliente para V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE
            query.append(" I18N_SUBTC.VAL_I18N subTipoCliente, V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI, ");
            //Descripción internacionalizada del tipo de clasificación para V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI
            query.append(" I18N_TCLASE.VAL_I18N tipoClase, V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS, ");
            //Descripción internacionalizada del clasificación para V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS
            query.append(" I18N_CLASE.VAL_I18N clase, ");
            //Número de solicitudes haciendo la sumatoria de los registros obtenidos según el "GROUP BY"
            query.append(" COUNT (*) numeroSolicitudes ");
            query.append(" FROM PED_SOLIC_CABEC, MAE_CLIEN, V_MAE_TIPIF_CLIEN,V_GEN_I18N_SICC I18N_TC, ");
            query.append(" V_GEN_I18N_SICC I18N_SUBTC, V_GEN_I18N_SICC I18N_TCLASE,V_GEN_I18N_SICC I18N_CLASE ");
            query.append(" WHERE PED_SOLIC_CABEC.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" AND PED_SOLIC_CABEC.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND PED_SOLIC_CABEC.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            query.append(" AND PED_SOLIC_CABEC.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
            if (dto.getFechaFin() != null) {
              query.append(" AND PED_SOLIC_CABEC.FEC_PROG_FACT BETWEEN TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
              query.append(" AND TO_DATE('" + fechaFin + "','YYYY-MM-DD')");
            } else {
              query.append(" AND PED_SOLIC_CABEC.FEC_PROG_FACT >= TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
            }
            query.append(" AND PED_SOLIC_CABEC.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE ");
            query.append(" AND MAE_CLIEN.OID_CLIE = V_MAE_TIPIF_CLIEN.CLIE_OID_CLIE ");
            query.append(" AND I18N_TC.ATTR_ENTI = 'MAE_TIPO_CLIEN' AND I18N_TC.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND I18N_TC.VAL_OID = V_MAE_TIPIF_CLIEN.TICL_OID_TIPO_CLIE ");
            query.append(" AND I18N_SUBTC.ATTR_ENTI = 'MAE_SUBTI_CLIEN' AND I18N_SUBTC.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND I18N_SUBTC.VAL_OID = V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE ");
            query.append(" AND I18N_TCLASE.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' AND I18N_TCLASE.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND I18N_TCLASE.VAL_OID = V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI ");
            query.append(" AND I18N_CLASE.ATTR_ENTI = 'MAE_CLASI' AND I18N_CLASE.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" AND I18N_CLASE.VAL_OID = V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS ");
            query.append(" GROUP BY V_MAE_TIPIF_CLIEN.TICL_OID_TIPO_CLIE, I18N_TC.VAL_I18N, V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE, I18N_SUBTC.VAL_I18N,	 ");
            query.append(" V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI, I18N_TCLASE.VAL_I18N, V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS, I18N_CLASE.VAL_I18N ");
  */
        /* Fin Modificacion por Performance alorenzo 01/08/2006 */
        }

        try {
            if (!dto.getHacerPaginacion().booleanValue()) {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } else {
                rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
            }
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }
        dtoOut.setResultado(rs);
        UtilidadesLog.info("DAODesgloses.agrupacionTipoSubtipoClasificacionCliente(DTOEDesglose dto): Salida ");
        return dtoOut;
    }

    /**
     * @Autor: Hugo A. Mansi
     * @Fecha: 01/11/2004
     * @DMCO: SICC-DMCO-PED-201-354-N029
     * @Modifico: --
     * @Modificado: --
     * @Descripción: Hace una consulta JDBC sobre la tabla PED_SOLIC_CABEC
     * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
     *
     */
    public DTOSalida agrupacionAcceso(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("DAODesgloses.agrupacionAcceso(DTOEDesglose dto): Entarda ");
        DTOSalida dtoOut = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = getBelcorpService();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = formato.format(dto.getFechaInicio());
        String fechaFin = "";
        if (dto.getFechaFin() != null) {
          fechaFin = formato.format(dto.getFechaFin());
        }
        if (dto.getHacerPaginacion().booleanValue() == false) {
        /* Modificacion por Performance alorenzo 01/08/2006 */
             switch (dto.getGrupoProcesos().intValue()) {
                case 1: query.append(" SELECT SUM(SCA.VAL_ACUM_GP1) cantidad "); break;
                case 2: query.append(" SELECT SUM(SCA.VAL_ACUM_GP2) cantidad "); break;
                case 3: query.append(" SELECT SUM(SCA.VAL_ACUM_GP3) cantidad "); break;
                case 4: query.append(" SELECT SUM(SCA.VAL_ACUM_GP4) cantidad "); break;
                case 5: query.append(" SELECT SUM(SCA.VAL_ACUM_GP5) cantidad "); break;
            }
            query.append(" FROM PED_SOLIC_CABEC_ACUM SCA ");
            query.append(" WHERE SCA.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND SCA.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
            if (dto.getFechaFin() != null) {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaFin + "', 'YYYY-MM-DD') ");
            } else {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') ");
            }
       /*
            query.append(" SELECT  COUNT(*) cantidad ");
            query.append(" from ped_solic_cabec cabe, ");
            query.append(" seg_acces acce, ");
            query.append(" V_GEN_I18N_SICC i18n_acceso, ");
            query.append(" seg_subac subac ");
            query.append(" WHERE CABE.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" AND CABE.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND CABE.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            query.append(" AND CABE.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
            if (dto.getFechaFin() != null) {
              query.append(" AND CABE.FEC_PROG_FACT BETWEEN TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
              query.append(" AND TO_DATE('" + fechaFin + "','YYYY-MM-DD')");
            } else {
              query.append(" AND CABE.FEC_PROG_FACT >= TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");            
            }
            query.append(" and i18n_acceso.ATTR_ENTI = 'SEG_ACCES'	 ");
            query.append(" and i18n_acceso.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" and i18n_acceso.ATTR_NUM_ATRI = 1 ");
            query.append(" and i18n_acceso.VAL_OID = acce.OID_ACCE ");
            query.append(" and cabe.SBAC_OID_SBAC = subac.OID_SBAC ");
            query.append(" and subac.ACCE_OID_ACCE = acce.OID_ACCE ");
        */
        /* Fin Modificacion por Performance alorenzo 01/08/2006 */
        } else {
        /* Modificacion por Performance alorenzo 01/08/2006 */
            query.append(" SELECT SBA.ACCE_OID_ACCE OID, ");
            query.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC("+ dto.getOidIdioma() +", SBA.ACCE_OID_ACCE, 'SEG_ACCES') Descripcion, ");
            switch (dto.getGrupoProcesos().intValue()) {
                case 1: query.append(" SUM(SCA.VAL_ACUM_GP1) cantidad "); break;
                case 2: query.append(" SUM(SCA.VAL_ACUM_GP2) cantidad "); break;
                case 3: query.append(" SUM(SCA.VAL_ACUM_GP3) cantidad "); break;
                case 4: query.append(" SUM(SCA.VAL_ACUM_GP4) cantidad "); break;
                case 5: query.append(" SUM(SCA.VAL_ACUM_GP5) cantidad "); break;
            }
            query.append(" FROM PED_SOLIC_CABEC_ACUM SCA, ");
            query.append("      SEG_SUBAC SBA ");
            query.append(" WHERE SCA.ZZON_OID_ZONA = " + dto.getZona());
            query.append("   AND SCA.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
             if (dto.getFechaFin() != null) {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaFin + "', 'YYYY-MM-DD') ");
            } else {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') ");
            }
            query.append("   AND SBA.OID_SBAC = SCA.SBAC_OID_SBAC ");
            query.append(" GROUP BY SBA.ACCE_OID_ACCE, ");
            query.append("       PQ_APL_AUX.VALOR_GEN_I18N_SICC("+ dto.getOidIdioma() +", SBA.ACCE_OID_ACCE, 'SEG_ACCES') ");
        
/*       
            query.append("SELECT ");
            //oid del acceso	
            query.append(" acce.OID_ACCE OID, ");
            //Descripcicion internacionalizada del acceso	
            query.append(" i18n_acceso.VAL_I18N Descripcion, ");
            //Número de solicitudes haciendo la sumatoria de los registros obtenidos según el "GROUP BY" 	
            query.append(" COUNT (*) numeroSolicitudes ");
            query.append(" from ped_solic_cabec cabe, ");
            query.append(" seg_acces acce, ");
            query.append(" V_GEN_I18N_SICC i18n_acceso, ");
            query.append(" seg_subac subac ");
            query.append(" WHERE CABE.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" AND CABE.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND CABE.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            query.append(" AND CABE.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
           if (dto.getFechaFin() != null) {
              query.append(" AND CABE.FEC_PROG_FACT BETWEEN TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
              query.append(" AND TO_DATE('" + fechaFin + "','YYYY-MM-DD')");
            } else {
              query.append(" AND CABE.FEC_PROG_FACT >= TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");            
            }
            query.append(" 	and i18n_acceso.ATTR_ENTI = 'SEG_ACCES'	 ");
            query.append(" and i18n_acceso.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" and i18n_acceso.ATTR_NUM_ATRI = 1 ");
            query.append(" and i18n_acceso.VAL_OID = acce.OID_ACCE ");
            query.append(" and cabe.SBAC_OID_SBAC = subac.OID_SBAC ");
            query.append(" and subac.ACCE_OID_ACCE = acce.OID_ACCE ");
            query.append(" GROUP BY acce.OID_ACCE, i18n_acceso.VAL_I18N ");
  */
   /* Fin Modificacion por Performance alorenzo 01/08/2006 */
        }

        try {
            if (!dto.getHacerPaginacion().booleanValue()) {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } else {
                rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
            }
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        dtoOut.setResultado(rs);
        UtilidadesLog.info("DAODesgloses.agrupacionAcceso(DTOEDesglose dto): Salida ");
        return dtoOut;
    }

    /**
    * @Autor: Hugo A. Mansi
    * @Fecha: 01/11/2004
    * @DMCO: SICC-DMCO-PED-201-354-N029
    * @Modifico: --
    * @Modificado: --
    * @Descripción: Hace una consulta JDBC sobre la tabla PED_SOLIC_CABEC
    * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
    *    */
    public DTOSalida agrupacionContenido(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("DAODesgloses.agrupacionContenido(DTOEDesglose dto): Entrada ");
        DTOSalida dtoOut = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = getBelcorpService();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = formato.format(dto.getFechaInicio());
        String fechaFin = "";
        if (dto.getFechaFin() != null) {
          fechaFin = formato.format(dto.getFechaFin());
        }
    
        if (dto.getHacerPaginacion().booleanValue() == false) {
        /* Modificacion por Performance alorenzo 01/08/2006 */
            switch (dto.getGrupoProcesos().intValue()) {
                case 1: query.append(" SELECT SUM(SCA.VAL_ACUM_GP1) cantidad "); break;
                case 2: query.append(" SELECT SUM(SCA.VAL_ACUM_GP2) cantidad "); break;
                case 3: query.append(" SELECT SUM(SCA.VAL_ACUM_GP3) cantidad "); break;
                case 4: query.append(" SELECT SUM(SCA.VAL_ACUM_GP4) cantidad "); break;
                case 5: query.append(" SELECT SUM(SCA.VAL_ACUM_GP5) cantidad "); break;
            }
            query.append(" FROM PED_SOLIC_CABEC_ACUM SCA ");
            query.append(" WHERE SCA.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND SCA.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
            if (dto.getFechaFin() != null) {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaFin + "', 'YYYY-MM-DD') ");
            } else {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') ");
            }

        
         /* query.append(" SELECT  COUNT(*) cantidad ");
            query.append(" FROM ped_tipo_solic_pais solic,ped_solic_cabec cabe,	 ");
            query.append(" v_gen_i18n_sicc i18n_clase,	 ");
            query.append(" v_gen_i18n_sicc i18n_tipo,	 ");
            query.append(" ped_clase_solic,	 ");
            query.append(" ped_tipo_solic	 ");
            query.append(" WHERE CABE.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" AND CABE.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND CABE.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            query.append(" AND CABE.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
            if (dto.getFechaFin() != null) {
              query.append(" AND CABE.FEC_PROG_FACT BETWEEN TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
              query.append(" AND TO_DATE('" + fechaFin + "','YYYY-MM-DD')");
            } else {
              query.append(" AND CABE.FEC_PROG_FACT >= TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");            
            }
            query.append(" AND i18n_clase.attr_enti = 'PED_CLASE_SOLIC' ");
            query.append(" AND i18n_clase.idio_oid_idio = " + dto.getOidIdioma());
            query.append(" AND i18n_clase.attr_num_atri = 1 ");
            query.append(" AND i18n_clase.val_oid = ped_clase_solic.oid_clas_soli	 ");
            query.append(" AND i18n_tipo.attr_enti = 'PED_TIPO_SOLIC'	 ");
            query.append(" AND i18n_tipo.idio_oid_idio = " + dto.getOidIdioma());
            query.append(" AND i18n_tipo.attr_num_atri = 1 ");
            query.append(" AND i18n_tipo.val_oid = ped_tipo_solic.oid_tipo_soli ");
            query.append(" AND cabe.tspa_oid_tipo_soli_pais = solic.oid_tipo_soli_pais ");
            query.append(" AND solic.tsol_oid_tipo_soli = ped_tipo_solic.oid_tipo_soli ");
            query.append(" and ped_clase_solic.OID_CLAS_SOLI = ped_tipo_solic.CLSO_OID_CLAS_SOLI ");*/
         /* Fin Modificacion por Performance alorenzo 01/08/2006 */
            
        } else {
         /* Modificacion por Performance alorenzo 01/08/2006 */
            query.append(" SELECT SCA.TSPA_OID_TIPO_SOLI_PAIS OID, ");
            query.append("        PCS.OID_CLAS_SOLI oidClase, ");
            query.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma() + ", PCS.OID_CLAS_SOLI, 'PED_CLASE_SOLIC') claseSolicitud, ");
            query.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma() + ", PTS.OID_TIPO_SOLI, 'PED_TIPO_SOLIC') tipoSoliPais, ");
            switch (dto.getGrupoProcesos().intValue()) {
                case 1: query.append(" SUM(SCA.VAL_ACUM_GP1) cantidad "); break;
                case 2: query.append(" SUM(SCA.VAL_ACUM_GP2) cantidad "); break;
                case 3: query.append(" SUM(SCA.VAL_ACUM_GP3) cantidad "); break;
                case 4: query.append(" SUM(SCA.VAL_ACUM_GP4) cantidad "); break;
                case 5: query.append(" SUM(SCA.VAL_ACUM_GP5) cantidad "); break;
            }
            query.append(" FROM PED_SOLIC_CABEC_ACUM SCA, ");
            query.append("      PED_CLASE_SOLIC PCS, ");
            query.append("      PED_TIPO_SOLIC PTS, ");
            query.append("      PED_TIPO_SOLIC_PAIS PTSP ");
            query.append(" WHERE SCA.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
            query.append("   AND SCA.ZZON_OID_ZONA = " + dto.getZona());
            query.append("   AND PTSP.OID_TIPO_SOLI_PAIS = SCA.TSPA_OID_TIPO_SOLI_PAIS ");
            query.append("   AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
            query.append("   AND PTS.CLSO_OID_CLAS_SOLI = PCS.OID_CLAS_SOLI ");
            if (dto.getFechaFin() != null) {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaFin + "', 'YYYY-MM-DD') ");
            } else {
                query.append(" AND SCA.FEC_PROC >= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') "); 
                query.append(" AND SCA.FEC_PROC <= TO_DATE('" + fechaInicio + "', 'YYYY-MM-DD') ");
            }
            query.append(" GROUP BY SCA.TSPA_OID_TIPO_SOLI_PAIS, ");
            query.append("        PCS.OID_CLAS_SOLI, ");
            query.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma() + ", PCS.OID_CLAS_SOLI, 'PED_CLASE_SOLIC'), ");
            query.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC(" + dto.getOidIdioma() + ", PTS.OID_TIPO_SOLI, 'PED_TIPO_SOLIC') ");
            query.append(" ORDER BY SCA.TSPA_OID_TIPO_SOLI_PAIS ");
 
            /*
            //ver incidencia 9763 
            query.append("SELECT ");
            //oid del tipo de solicitud	
            query.append(" solic.oid_tipo_soli_pais OID, ");
            //oid clase de solicitud
            query.append(" ped_clase_solic.OID_CLAS_SOLI oidClase, ");
            //Descripcicion internacionalizada de la clase de solicitud	
            query.append(" i18n_clase.val_i18n claseSolicitud, ");
            //Descripcicion internacionalizada del tipo de solicitud	
            query.append(" i18n_tipo.val_i18n tipoSoliPais, ");
            query.append(" COUNT (*) cantidad ");
            query.append(" FROM ped_tipo_solic_pais solic,ped_solic_cabec cabe,	 ");
            query.append(" v_gen_i18n_sicc i18n_clase,	 ");
            query.append(" v_gen_i18n_sicc i18n_tipo,	 ");
            query.append(" ped_clase_solic,	 ");
            query.append(" ped_tipo_solic	 ");
            query.append(" WHERE CABE.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" AND CABE.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND CABE.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            query.append(" AND CABE.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
           if (dto.getFechaFin() != null) {
              query.append(" AND CABE.FEC_PROG_FACT BETWEEN TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
              query.append(" AND TO_DATE('" + fechaFin + "','YYYY-MM-DD')");
            } else {
              query.append(" AND CABE.FEC_PROG_FACT >= TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");            
            }
            query.append(" AND i18n_clase.attr_enti = 'PED_CLASE_SOLIC' ");
            query.append(" AND i18n_clase.idio_oid_idio = " + dto.getOidIdioma());
            query.append(" AND i18n_clase.attr_num_atri = 1 ");
            query.append(" AND i18n_clase.val_oid = ped_clase_solic.oid_clas_soli	 ");
            query.append(" AND i18n_tipo.attr_enti = 'PED_TIPO_SOLIC'	 ");
            query.append(" AND i18n_tipo.idio_oid_idio = " + dto.getOidIdioma());
            query.append(" AND i18n_tipo.attr_num_atri = 1 ");
            query.append(" AND i18n_tipo.val_oid = ped_tipo_solic.oid_tipo_soli ");
            query.append(" AND cabe.tspa_oid_tipo_soli_pais = solic.oid_tipo_soli_pais ");
            query.append(" AND solic.tsol_oid_tipo_soli = ped_tipo_solic.oid_tipo_soli ");
            query.append(" and ped_clase_solic.OID_CLAS_SOLI = ped_tipo_solic.CLSO_OID_CLAS_SOLI ");
            query.append(" GROUP BY solic.oid_tipo_soli_pais, ped_clase_solic.OID_CLAS_SOLI, i18n_clase.val_i18n, i18n_tipo.val_i18n ");*/
        /* Fin Modificacion por Performance alorenzo 01/08/2006 */
        }

        try {
            if (!dto.getHacerPaginacion().booleanValue()) {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } else {
                rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
            }
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        dtoOut.setResultado(rs);
        UtilidadesLog.info("DAODesgloses.agrupacionContenido(DTOEDesglose dto): Salida ");
        return dtoOut;
    }

    /**
    * @Autor: Hugo A. Mansi
    * @Fecha: 01/11/2004
    * @DMCO: SICC-DMCO-PED-201-354-N029
    * @Modifico: --
    * @Modificado: --
    * @Descripción: Hace una consulta JDBC sobre la tabla PED_SOLIC_CABEC
    * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
    *    */
    public DTOSalida agrupacionEstados(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("DAODesgloses.agrupacionEstados(DTOEDesglose dto): Entrada  ");
        DTOSalida dtoOut = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = getBelcorpService();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = formato.format(dto.getFechaInicio());
        String fechaFin = "";
        if (dto.getFechaFin() != null) {
          fechaFin = formato.format(dto.getFechaFin());
        }

        if (dto.getHacerPaginacion().booleanValue() == false) {
            query.append(" SELECT  COUNT(*) cantidad ");
            query.append(" FROM ped_solic_cabec cabe, ");
            query.append(" PED_ESTAD_SOLIC estad, ");
            query.append(" v_gen_i18n_sicc i18n_estado ");
            query.append(" WHERE CABE.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" AND CABE.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND CABE.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            query.append(" AND CABE.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
           if (dto.getFechaFin() != null) {
              query.append(" AND CABE.FEC_PROG_FACT BETWEEN TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
              query.append(" AND TO_DATE('" + fechaFin + "','YYYY-MM-DD')");
            } else {
              query.append(" AND CABE.FEC_PROG_FACT >= TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");            
            }
            query.append(" AND i18n_estado.attr_enti = 'PED_ESTAD_SOLIC' ");
            query.append(" AND i18n_estado.idio_oid_idio = " + dto.getOidIdioma());
            query.append(" AND i18n_estado.attr_num_atri = 1 ");
            query.append(" AND i18n_estado.VAL_OID = estad.OID_ESTA_SOLI ");
            query.append(" and cabe.esso_oid_esta_soli = estad.OID_ESTA_SOLI ");
        } else {
            query.append(" SELECT estad.OID_ESTA_SOLI OID, ");
            query.append(" i18n_estado.val_i18n estado, ");
            query.append(" count (*) cantidad ");
            query.append(" FROM ped_solic_cabec cabe, ");
            query.append(" PED_ESTAD_SOLIC estad, ");
            query.append(" v_gen_i18n_sicc i18n_estado ");
            query.append(" WHERE CABE.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" AND CABE.ZZON_OID_ZONA = " + dto.getZona());
            query.append(" AND CABE.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            query.append(" AND CABE.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
           if (dto.getFechaFin() != null) {
              query.append(" AND CABE.FEC_PROG_FACT BETWEEN TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
              query.append(" AND TO_DATE('" + fechaFin + "','YYYY-MM-DD')");
            } else {
              query.append(" AND CABE.FEC_PROG_FACT >= TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");            
            }
            query.append(" AND i18n_estado.attr_enti = 'PED_ESTAD_SOLIC' ");
            query.append(" AND i18n_estado.idio_oid_idio = " + dto.getOidIdioma());
            query.append(" AND i18n_estado.attr_num_atri = 1 ");
            query.append(" AND i18n_estado.VAL_OID = estad.OID_ESTA_SOLI ");
            query.append(" and cabe.esso_oid_esta_soli = estad.OID_ESTA_SOLI ");
            query.append(" GROUP BY estad.OID_ESTA_SOLI, i18n_estado.val_i18n");
        }

        try {
            if (!dto.getHacerPaginacion().booleanValue()) {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } else {
                rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
            }
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        dtoOut.setResultado(rs);
        UtilidadesLog.info("DAODesgloses.agrupacionEstados(DTOEDesglose dto): Salida  ");
        return dtoOut;
    }

    /**
    * @Autor: Hugo A. Mansi
    * @Fecha: 01/11/2004
    * @DMCO: SICC-DMCO-PED-201-354-N029
    * @Modifico: --
    * @Modificado: --
    * @Descripción: Hace una consulta JDBC sobre la tabla PED_SOLIC_CABEC para los siguientes criterios
    * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
    *    */
    public DTOSalida desgloseNumeroSolicitud(DTOEDesglose dto) throws MareException {
        UtilidadesLog.info("DAODesgloses.desgloseNumeroSolicitud(DTOEDesglose dto): Entrada ");
        DTOSalida dtoOut = new DTOSalida();
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs = getBelcorpService();
        SimpleDateFormat formateo = new SimpleDateFormat("yyyy-MM-dd");
        String fechaInicio = formateo.format(dto.getFechaInicio());
        String fechaFin = "";
        if (dto.getFechaFin() != null) {
          fechaFin = formateo.format(dto.getFechaFin());
        }

        try {
            //query.append(" SELECT DISTINCT cabe.oid_soli_cabe OID, i18n_canal.val_i18n canal, ");
            query.append(" SELECT DISTINCT rownum OID, i18n_canal.val_i18n canal, ");            
            query.append(" i18n_acceso.val_i18n acceso, i18n_subac.val_i18n subacceso, ");
            query.append(" cabe.val_nume_soli nrosolicitud, mae.cod_clie codcliente, ");
            query.append(" concat(mae.val_nom1,concat(' ',concat(mae.val_nom2,concat(' ',concat(mae.val_ape1,concat(' ',mae.val_ape2))))))nombcliente ");
            query.append(" FROM v_gen_i18n_sicc i18n_canal, ");
            query.append(" v_gen_i18n_sicc i18n_acceso, ");
            query.append(" v_gen_i18n_sicc i18n_subac, ");
            query.append(" ped_solic_cabec cabe, ");
            query.append(" mae_clien mae, ");
            query.append(" cra_perio cra, ");
            query.append(" v_mae_tipif_clien v_mae, ");
            query.append(" SEG_SUBAC sub ");            
            query.append(" WHERE ");
            if (dto.getOidPais() != null) {
                query.append(" CABE.PAIS_OID_PAIS = " + dto.getOidPais());
                //Jrivas 14/1/2005
                query.append(" AND mae.PAIS_OID_PAIS = " + dto.getOidPais());                
            }
            if (dto.getZona() != null) {
                query.append(" AND CABE.ZZON_OID_ZONA = " + dto.getZona());
            }
            if (dto.getGrupoProcesos() != null) {
                query.append(" AND CABE.GRPR_OID_GRUP_PROC = " + dto.getGrupoProcesos());
            }
            if (dto.getTipoSolicitud() != null) {
                query.append(" AND CABE.TSPA_OID_TIPO_SOLI_PAIS = " + dto.getTipoSolicitud());
            }
           if (dto.getFechaFin() != null) {
              query.append(" AND CABE.FEC_PROG_FACT BETWEEN TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");
              query.append(" AND TO_DATE('" + fechaFin + "','YYYY-MM-DD')");
            } else {
              query.append(" AND CABE.FEC_PROG_FACT >= TO_DATE ('" + fechaInicio + "','YYYY-MM-DD')");            
            }
            query.append(" AND cabe.perd_oid_peri = cra.oid_peri ");
            if (dto.getMarca() != null) {
                query.append(" AND cra.marc_oid_marc = " + dto.getMarca());
            }
            if (dto.getCanal() != null) {
                query.append(" AND cra.cana_oid_cana = " + dto.getCanal());
            }
            
            //Modificado jrivas 19/1/2005 inc 12430
            query.append(" AND sub.oid_sbac = cabe.sbac_oid_sbac ");
            if (dto.getAcceso() != null) {
                //Modificado Jrivas 14/1/2005
                query.append(" AND sub.acce_oid_acce = " + dto.getAcceso());
            }
            query.append(" AND mae.oid_clie = v_mae.clie_oid_clie ");
            if (dto.getTipoCliente() != null) {
                query.append(" AND v_mae.ticl_oid_tipo_clie = " + dto.getTipoCliente());
            }
            if (dto.getSubtipoCliente() != null) {
                query.append(" AND v_mae.sbti_oid_subt_clie = " + dto.getSubtipoCliente());
            }
            if (dto.getTipoClasificacion() != null) {
                query.append(" AND v_mae.tccl_oid_tipo_clasi = " + dto.getTipoClasificacion());
            }
            if (dto.getClasificacion() != null) {
                query.append(" AND v_mae.clas_oid_clas = " + dto.getClasificacion());
            }
            query.append(" AND i18n_canal.attr_enti = 'SEG_CANAL' ");
            query.append(" AND i18n_canal.attr_num_atri = 1 ");
            query.append(" AND i18n_canal.val_oid = cra.cana_oid_cana ");
            query.append(" AND i18n_canal.idio_oid_idio = " + dto.getOidIdioma());
            //Jrivas 14/1/2005
            query.append(" AND i18n_acceso.attr_enti = 'SEG_ACCES' ");
            query.append(" AND i18n_acceso.attr_num_atri = 1 ");
            query.append(" AND i18n_acceso.val_oid= sub.acce_oid_acce ");
            query.append(" AND i18n_acceso.idio_oid_idio(+) = " + dto.getOidIdioma());
            query.append(" AND i18n_subac.attr_enti = 'SEG_SUBAC' ");
            query.append(" AND i18n_subac.attr_num_atri = 1 ");
            query.append(" AND i18n_subac.val_oid = cabe.sbac_oid_sbac	 ");
            query.append(" AND i18n_subac.idio_oid_idio = " + dto.getOidIdioma());
            query.append(" AND cabe.clie_oid_clie = mae.oid_clie");            
            rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
        } catch (Exception ex) {
            UtilidadesLog.error("Excepcion: ",ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        dtoOut.setResultado(rs);
        UtilidadesLog.info("DAODesgloses.desgloseNumeroSolicitud(DTOEDesglose dto): Salida ");
        return dtoOut;
    }
    
    
    public RecordSet obtenerDatosPaginaDesglose(long oid_zona, long oid_grupo_proceso, long tipo_solicitud, long oid_idioma )throws MareException  {
        UtilidadesLog.info("DAODesgloses.obtenerDatosPaginaDesglose(long oid_zona, long oid_grupo_proceso, long tipo_solicitud, long oid_idioma ): Entrada ");
        StringBuffer query = new StringBuffer();
        query.append("select OID_ZONA, DES_ZONA, OID_MARC, DES_MARC, OID_CANA, ");
        query.append("pq_apl_aux.valor_gen_i18n_sicc("+oid_idioma+", oid_cana,'SEG_CANAL') DES_CANAL, ");
        query.append("(select DES_GRUP_proc from ped_grupo_proce where OID_GRUP_proc = "+oid_grupo_proceso+") DES_GRUP_PROCE,");
        query.append("(select pq_apl_aux.valor_gen_i18n_sicc("+oid_idioma+", "+tipo_solicitud+", 'PED_TIPO_SOLIC') des_tipo_sol_pais from dual) DES_TIPO_SOL_PAIS ");
        query.append("from zon_zona, seg_marca, seg_canal ");
        query.append("where zon_zona.OID_ZONA = "+ oid_zona+ " AND zon_zona.MARC_OID_MARC = seg_marca.OID_MARC AND zon_zona.CANA_OID_CANA = seg_canal.OID_CANA");
        RecordSet salida = null;        
        try {
          BelcorpService bs = getBelcorpService();
          salida = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("Excepcion: ",ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
      UtilidadesLog.info("DAODesgloses.obtenerDatosPaginaDesglose(long oid_zona, long oid_grupo_proceso, long tipo_solicitud, long oid_idioma ): Salida ");
      return salida;
    }
    
}
