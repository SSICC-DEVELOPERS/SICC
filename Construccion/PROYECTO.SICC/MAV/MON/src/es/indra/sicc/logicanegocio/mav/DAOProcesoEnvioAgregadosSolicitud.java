package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.ejb.FinderException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;

import javax.persistence.NoResultException;


public class DAOProcesoEnvioAgregadosSolicitud {
    public DAOProcesoEnvioAgregadosSolicitud() {}
    private UtilidadesLog log = new UtilidadesLog();
    
    /**
     * DAOProcesoEnvioAgregadosSolicitud.obtenerDetallesMAV(cliente : Long, periodo : Long, tipoEstadoProceso :
     * Long) : RecordSet
     *
     * El método recupera registros de DetalleMAV filtrando por la tipificación del cliente de la entrada, y por el
     * periodo y tipoEstadoProceso de entrada
     *
     * Entrada:
     *     - cliente : Long
     *     - periodo : Long
     *     - tipoEstadoProceso : Long
     * Proceso:
     * -> Hacer consulta JDBC sobre la entidad MAV_DETAL_MAV para obtener el campo OID_DETA_MAV con los
     * siguientes filtros:
     * -> Cruzar MAV_DETAL_MAV con vista V_MAE_TIPIF_CLIEN tal que MAV_DETAL_MAV.TICL_OID_TIPO_CLIE
     * = V_MAE_TIPIF_CLIEN.TICL_OID_TIPO_CLIE
     * -> V_MAE_TIPIF_CLIEN.CLIE_OID_CLIE = cliente
     * -> V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI = MAV_DETAL_MAV.TCCL_OID_TIPO_CLASI
     * -> V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS = MAV_DETAL_MAV.CLAS_OID_CLAS
     * -> Cruzar MAV_DETAL_MAV con tabla CRA_PERIO AS PERIODO_INICIO tal que
     * MAV_DETAL_MAV.PERI_OID_PERI = PERIODO_INICIO.OID_PERI
     * -> Cruzar MAV_DETAL_MAV con tabla CRA_PERIO AS PERIODO_FIN tal que
     * MAV_DETAL_MAV.PERI_OID_PERI = PERIODO_INICIO.OID_PERI
     * -> Hacer findByPrimaryKey sobre la entidad Periodo tomando "periodo" de entrada
     * -> (PERIODO_INICIO.FEC_INI < Periodo.fechaInicio) AND (Periodo.fechaFin < PERIODO_FIN.FEC_FIN)
     * -> MAV_DETAL_MAV.TEPR_OID_TIPO_ESTA_PROC = tipoEstadoProceso
     * -> Devolver RecordSet obtenido
     */
    public RecordSet obtenerDetallesMAV(Long lngOidCliente, Long lngOidPeriodo, Long lngTipoEstadoProceso)
        throws MareException {
        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.obtenerDetallesMAV(Long lngOidCliente, Long lngOidPeriodo, Long lngTipoEstadoProceso):Entrada");
        BelcorpService bs;
        //StringBuffer query = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
        } catch(MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        /**
         * Comentado porque no tiene sentido 
         * autor: jpbosnja
         */
        /*Date dPeriodoFechaFin = new Date(System.currentTimeMillis());
        Date dPediodoFechaInicio = new Date(System.currentTimeMillis());

        try {
            PeriodoLocalHome ph = this.getPeriodoLocalHome();
            PeriodoLocal periodoLocal = ph.findByPrimaryKey(lngOidPeriodo);

            dPeriodoFechaFin = periodoLocal.getFechaFin();
            dPediodoFechaInicio = periodoLocal.getFechainicio();
        } catch(MareException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }*/
    
        try {
           // Modificado por ssantana, inc. BELC300018225, 20/7/2005
            /*query.append(" SELECT mav_detal_mav.oid_deta_mav, mav_detal_mav.perd_oid_peri, ");
            query.append("   mav_detal_mav.perd_oid_peri_fina, pini.fec_inic AS fi_periodo_ini, ");
            query.append("   pfin.fec_fina AS ff_periodo_fin, pentrada.fec_inic, pentrada.fec_fina ");
            query.append(" FROM mav_detal_mav, ");
            query.append("   v_mae_tipif_clien, ");
            query.append("   cra_perio pini, ");
            query.append("   cra_perio pfin, ");
            query.append("   cra_perio pentrada, ");
            query.append("   mav_subti_clien_detal ");
            query.append(" WHERE mav_detal_mav.ticl_oid_tipo_clie = v_mae_tipif_clien.ticl_oid_tipo_clie ");
            query.append("   AND v_mae_tipif_clien.clie_oid_clie = " + lngOidCliente);
            query.append("   AND (   mav_detal_mav.clas_oid_clas IS NULL ");
            query.append("        OR mav_detal_mav.clas_oid_clas = v_mae_tipif_clien.clas_oid_clas ");
            query.append("       ) "); 
            query.append("   AND (   mav_detal_mav.tccl_oid_tipo_clas IS NULL ");
            query.append("        OR v_mae_tipif_clien.tccl_oid_tipo_clasi = ");
            query.append("                                       mav_detal_mav.tccl_oid_tipo_clas ");
            query.append("       ) ");
            query.append(" AND mav_detal_mav.perd_oid_peri = pini.oid_peri ");
            query.append(" AND mav_detal_mav.perd_oid_peri_fina = pfin.oid_peri(+) ");
            query.append(" AND pentrada.oid_peri = " + lngOidPeriodo);
            query.append(" AND (   (    mav_detal_mav.perd_oid_peri_fina IS NULL ");
            query.append("           AND mav_detal_mav.perd_oid_peri = pentrada.oid_peri ");
            query.append("          ) ");
            query.append("      OR (    mav_detal_mav.perd_oid_peri_fina IS NOT NULL ");
            query.append("           AND pini.fec_inic <= pentrada.fec_inic ");
            query.append("           AND pentrada.fec_fina <= pfin.fec_fina ");
            query.append("         ) ");
            query.append("     ) ");
            query.append(" AND mav_detal_mav.oid_deta_mav = mav_subti_clien_detal.denv_oid_deta_mav(+) ");
            query.append(" AND (   mav_subti_clien_detal.sbti_oid_subt_clie IS NULL ");
            query.append("       OR mav_subti_clien_detal.sbti_oid_subt_clie = ");
            query.append("                                        v_mae_tipif_clien.sbti_oid_subt_clie ");
            query.append("     ) ");
            query.append(" AND mav_detal_mav.tepr_oid_tipo_esta_proc = " + lngTipoEstadoProceso);*/
            // Fin Modificacion por ssantana, inc. BELC300018225, 20/7/2005
            
            es.indra.mare.common.mii.services.jdbcservice.RecordSet rs;
            ArrayList parametros = new ArrayList();
            parametros.add(lngOidPeriodo.toString());
            parametros.add(lngOidCliente.toString());
            parametros.add(lngTipoEstadoProceso.toString());

            //rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet)bs.dbService.executeStaticQuery(query.toString());
            rs = bs.dbService.executeProcedure("PQ_PLANI.MAV_OBTENER_DETALLES_MAV",parametros);
            //UtilidadesLog.debug("rs: " + rs);            
            bs = null;

            UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.obtenerDetallesMAV(Long lngOidCliente, Long lngOidPeriodo, Long lngTipoEstadoProceso):Salida");
            return rs;
        } catch(Exception e) {
            if(e instanceof MareException) {
                UtilidadesLog.error(e);
                throw (MareException)e;
            } else {
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }

    public RecordSet obtenerSolicitudesEnvioMAV(DTOSolicitudValidacion dto)
        throws MareException {

        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.obtenerSolicitudesEnvioMAV(DTOSolicitudValidacion dto):Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
            //Inc. 8194 jrivas
            query.append(" select OID_SOLI_ENVI, MENV_OID_ENVI from MAV_SOLIC_ENVIO ");
            query.append(" where SOCA_OID_SOLI_CABE = " + dto.getOidSolicitud());
            query.append(" order by MENV_OID_ENVI ");

            resultado = bs.dbService.executeStaticQuery(query.toString());
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                            
              UtilidadesLog.debug("resultado: " + resultado);
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.obtenerSolicitudesEnvioMAV(DTOSolicitudValidacion dto):Salida");
        return resultado;
    }

    public Boolean existenSolicitudesEnvioMAV(Long envio) throws MareException {
        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.existenSolicitudesEnvioMAV(Long envio):Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();

        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
            query.append(" select count(OID_SOLI_ENVI) from MAV_SOLIC_ENVIO ");
            query.append(" where MENV_OID_ENVI = " + envio);

            resultado = bs.dbService.executeStaticQuery(query.toString());
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                            
              UtilidadesLog.debug("resultado: " + resultado);
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(new Long(resultado.getValueAt(0, 0).toString()).intValue() != 0) {
            UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.existenSolicitudesEnvioMAV(Long envio):Salida");
            return new Boolean(true);
        } else {
            UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.existenSolicitudesEnvioMAV(Long envio):Salida");
            return new Boolean(false);
        }
    }

    /**
     * CHANGELOG
     * ---------
     * dmorello, 17/12/2008 - Error RI 20080817
     *    - Se corrige la comparacion de fechas de cumpleaños/aniversario
     *      para contemplar el caso de un periodo que comienza en un año
     *      y termina en el siguiente.
     *      
     * sbuchelli 02/03/2010 MAV - PER-SiCC-2010-0109
     *   -
     *   Actividad 5: Se agrega funcionalidad para manejar mas opciones en atributos a evaluar para el 
     *   criterio de Asignacion por Atributos. Las nuevas opciones  asignan el despacho a consultoras 
     *   que NO superan el monto indicado para las diferntes modalidades que se manejan actualmente 
     *   ( en marca, en unidad de negocio, en negocio y en catálogo)
     *   
     * sapaza  21/07/2010 MAV - PER-SiCC-2010-0458
     *   - Se corrige funcionalidad para el caso de criterio de Asignacion por Atributos :  
     *   No supera monto en catalogo. 
     */
    public Boolean cumpleCriterioPorAtributos(DTOSolicitudValidacion dto1, DTODetalleMAV dto2)
        throws MareException {
        
        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.cumpleCriterioPorAtributos(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Entrada");
        BelcorpService bs;
        String query = null;
        StringBuffer sSelect = new StringBuffer("");
        StringBuffer sFrom = new StringBuffer("");
        StringBuffer sWhere = new StringBuffer("");
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy");
        String anioActual = formato.format(new java.util.Date());
        UtilidadesLog.debug("anioActual: " + anioActual);
        
        String pedazoQuery = null;
        
        try {
            bs = BelcorpService.getInstance();
        } catch(MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            Long subcriterio = dto2.getSubcriterio();
            UtilidadesLog.debug("subcriterio: " + subcriterio);
            if ( subcriterio.equals(ConstantesMAV.SUBCRI_TODOS) ) {
                return Boolean.TRUE;
            }
            // Modificado por ssantana, inc. BELC300018225, 20/7/2005
            /*String clausulaINzonas = this.armaClausulaIN( dto2.getZonas() );
            String clausulaINregiones = this.armaClausulaIN( dto2.getRegiones() );
            String clausulaINsubgv = this.armaClausulaIN( dto2.getSubgerencias() );
            String clausulaINsubtipoCliente = this.armaClausulaIN( dto2.getSubtiposCliente() );*/

            //query.append(" SELECT ped_solic_cabec.oid_soli_cabe ");
            sSelect.append(" SELECT mae_clien.OID_CLIE ");

            sFrom.append(" FROM mae_clien, ");
            sFrom.append("  ped_solic_cabec, ");
            sFrom.append("  mae_clien_datos_adici ");

            sWhere.append(" WHERE mae_clien.oid_clie = " + dto1.getOidCliente());
            sWhere.append("  AND ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
            sWhere.append("  AND mae_clien.oid_clie = ped_solic_cabec.clie_oid_clie ");
            sWhere.append(" AND mae_clien.oid_clie = mae_clien_datos_adici.clie_oid_clie ");
            
            //  Ahora arma el resto de la query dinámicamente en base al Subcriterio de 
            //  Asignación
            // -------------------------------------------------------------------------------------
            if (subcriterio.equals(ConstantesMAV.SUBCRI_CUMPLE) ) {
               
               String[] arrayAnyos = this.obtieneFechasPeriodo(dto1.getOidPeriodo());
              
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
      
               sWhere.append(" AND mae_clien_datos_adici.fec_naci IS NOT NULL ");
               sWhere.append(" AND ( ");
               
               if (bCambiaAnyo.booleanValue()) { 
               /** Hay cambio de año */
                 sWhere.append(" (TO_DATE (TO_CHAR (mae_clien_datos_adici.fec_naci, 'dd/MM') ");
                 sWhere.append(" || '/2008', 'dd/MM/yyyy' )");
                 sWhere.append(" BETWEEN TO_DATE ('" + sFechaInicio + "', 'dd/MM/yyyy') ");
                 sWhere.append(" AND TO_DATE ('31/12/2008', 'dd/MM/yyyy') )");
               
                 sWhere.append(" or ");
               
                 sWhere.append(" (TO_DATE (TO_CHAR (mae_clien_datos_adici.fec_naci, 'dd/MM') ");
                 sWhere.append(" || '/2008', 'dd/MM/yyyy' )");
                 sWhere.append(" BETWEEN TO_DATE ('01/01/2008', 'dd/MM/yyyy') ");
                 sWhere.append(" AND TO_DATE ('" + sFechaFin + "', 'dd/MM/yyyy') )");
               
               } else {
                  /** No hay cambio de año */
                 sWhere.append(" (TO_DATE (TO_CHAR (mae_clien_datos_adici.fec_naci, 'dd/MM') ");
                 sWhere.append(" || '/2008', 'dd/MM/yyyy' )");
                 sWhere.append(" BETWEEN TO_DATE ('" + sFechaInicio + "', 'dd/MM/yyyy') ");
                 sWhere.append(" AND TO_DATE ('" + sFechaFin + "', 'dd/MM/yyyy') )");
               }
                
               sWhere.append(" ) ");
            }
            
            // -------------------------------------------------------------------------------------
            if (subcriterio.equals(ConstantesMAV.SUBCRI_ANIVERSARIO)) {
               String[] arrayAnyos = this.obtieneFechasPeriodo(dto1.getOidPeriodo());
               String sFechaInicio = arrayAnyos[0];
               String sFechaFin = arrayAnyos[1]; 
               String sAnyoIni = arrayAnyos[2]; 
               String sAnyoFin = arrayAnyos[3]; 
               
               Boolean bCambiaAnyo = Boolean.FALSE;
               if (!sAnyoIni.equals(sAnyoFin)) {
                  bCambiaAnyo = Boolean.TRUE;
               }
    
               //sapaza -- PER-SiCC-2010-0423 -- 05/07/2010                           
               sFechaInicio = sFechaInicio + "/2008";
               sFechaFin = sFechaFin + "/2008";
               
               UtilidadesLog.debug("CambiaAnyo: " + bCambiaAnyo);   
               UtilidadesLog.debug("sFechaInicio: " + sFechaInicio);
               UtilidadesLog.debug("sFechaFin: " + sFechaFin);
               
               sWhere.append(" AND mae_clien.fec_ingr IS NOT NULL ");
               sWhere.append(" AND ( ");
               
               if (bCambiaAnyo.booleanValue()) {  
                  sWhere.append(" (TO_DATE (TO_CHAR (mae_clien.fec_ingr, 'dd/MM') || '/2008', 'dd/MM/yyyy' ) ");
                  sWhere.append(" BETWEEN TO_DATE ('" + sFechaInicio + "', 'dd/MM/yyyy') ");
                  sWhere.append(" AND TO_DATE ('31/12/2008', 'dd/MM/yyyy') ) ");
                  
                  sWhere.append(" OR ");
                  
                  sWhere.append(" (TO_DATE (TO_CHAR (mae_clien.fec_ingr, 'dd/MM') || '/2008', 'dd/MM/yyyy' ) ");
                  sWhere.append(" BETWEEN TO_DATE ('01/01/2008', 'dd/MM/yyyy') ");
                  sWhere.append(" AND TO_DATE ('" + sFechaFin +  "', 'dd/MM/yyyy') ) ");
               
               } else {
                  sWhere.append(" (TO_DATE (TO_CHAR (mae_clien.fec_ingr, 'dd/MM') || '/2008', 'dd/MM/yyyy' ) ");
                  sWhere.append(" BETWEEN TO_DATE ('" + sFechaInicio + "', 'dd/MM/yyyy') ");
                  sWhere.append(" AND TO_DATE ('" + sFechaFin + "', 'dd/MM/yyyy') )");
               }

               
               sWhere.append(" ) ");
               
               // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
               sWhere.append(" and (" + sAnyoFin + " -  TO_NUMBER (TO_CHAR (mae_clien.FEC_INGR, 'yyyy')) ) in ");
               sWhere.append(obtenerListaAniversario(dto2.getNumeroAniversario()));
            }
            
            // -------------------------------------------------------------------------------------
            if ( subcriterio.equals(ConstantesMAV.SUBCRI_EDAD) ) {
              String sFormatoFecha = "dd/MM/yyyy";
              PeriodoLocalHome pLocalHome = new PeriodoLocalHome();
              PeriodoLocal pLocal = pLocalHome.findByPrimaryKey( dto1.getOidPeriodo() );
              
              java.sql.Date dateFechaInicio = pLocal.getFechainicio();
              String sFechaIniTrunca = this.truncaFecha(dateFechaInicio, sFormatoFecha);
            
              sWhere.append(" AND ( ( TO_DATE ('" + sFechaIniTrunca + "', '" + sFormatoFecha + "')");
              sWhere.append(" - mae_clien_datos_adici.fec_naci) ");
              sWhere.append(" / 365.25 ");
              sWhere.append(" ) BETWEEN " + dto2.getEdadDesde() + " AND " + dto2.getEdadHasta() );
            }

            // -------------------------------------------------------------------------------------
            //  Agregado por HRCS - Incidencia SiCC20080605
            StringBuffer sbTemp = new StringBuffer();
            sbTemp.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
            sbTemp.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
            sbTemp.append(" ) monto ");
            sbTemp.append(" FROM ped_solic_cabec, ped_solic_posic ");
            sbTemp.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
            sbTemp.append(" AND ped_solic_posic.soca_oid_soli_cabe = ped_solic_cabec.oid_soli_cabe ");
            
            StringBuffer sbTemp2 = new StringBuffer();
            sbTemp2.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
            sbTemp2.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
            sbTemp2.append(" ) monto ");
            sbTemp2.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
            sbTemp2.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
            sbTemp2.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
            sbTemp2.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
            
            StringBuffer sbTemp3 = new StringBuffer();
            sbTemp3.append(" SELECT NVL(SUM (  ped_solic_posic.num_unid_por_aten ");
            sbTemp3.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
            sbTemp3.append(" ),0) monto ");
            sbTemp3.append(" FROM ped_solic_cabec, ped_solic_posic, pre_ofert_detal ");
            sbTemp3.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
            sbTemp3.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
            sbTemp3.append(" AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
            //  fin de agregado
            
            // -------------------------------------------------------------------------------------
            if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO) ) {
               UtilidadesLog.debug(" - SUBCRI_PED_SUP_MONTO");

               /** Modificado por ssantana, 02/06/2006 - Lo que estaba diseñado
                * a partir de la inc. BELC300018225 es incorrecto según el DECU 
                *  No hace falta validar que el cliente tenga la tipificación del DetalleMAV
                * ya que el DetalleMAV se ha levantado a partir de la tipificacion
                * del cliente!!!!! */ 
               
               sSelect = new StringBuffer("");
               sFrom = new StringBuffer("");
               sWhere = new StringBuffer("");
               
               sSelect.append(" select SUM(a.monto) ");
               
               if ( dto2.getPeriodoIniMonto() == null || 
                                      dto2.getPeriodoFinMonto() == null) {
                  sFrom.append(" FROM (SELECT SUM ");
                  sFrom.append(" (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem) monto ");
                  sFrom.append(" FROM ped_solic_cabec ");
                  sFrom.append(" WHERE ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                  sFrom.append(" AND ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                  sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                  sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                  sFrom.append(" UNION ALL  ");
                  //sFrom.append(" SELECT SUM (ped_solic_posic.num_unid_por_aten ");
                  //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                  //sFrom.append(" ) monto ");
                  //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic ");
                  //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                  //sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                  //sFrom.append(" ped_solic_cabec.oid_soli_cabe) a ");
                  sFrom.append( sbTemp.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                  sFrom.append(" ) a ");
                  sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto() );
               } else {
                   sFrom.append(" FROM (SELECT SUM (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ");
                   sFrom.append(" cra_perio pini, ");
                   sFrom.append(" cra_perio pfin, ");
                   sFrom.append(" cra_perio pcabecera ");
                   sFrom.append(" WHERE pini.oid_peri = " + dto2.getPeriodoIniMonto());
                   sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                   sFrom.append(" AND pcabecera.oid_peri = ped_solic_cabec.perd_oid_peri ");
                   sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                   sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                   sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                   sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                   sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                   sFrom.append(" AND ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   sFrom.append(" and ped_solic_cabec.FEC_FACT IS NOT NULL ");
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                   //sFrom.append(" ped_solic_cabec.oid_soli_cabe) a ");
                   sFrom.append( sbTemp.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" ) a ");
                   sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto());
               }
            }
            
            // -------------------------------------------------------------------------------------
            if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO_MARCA)) {
               /** Modificado por ssantana, 02/06/2006 - Lo que estaba diseñado
                * a partir de la inc. BELC300018225 es incorrecto según el DECU 
                *  No hace falta validar que el cliente tenga la tipificación del DetalleMAV
                * ya que el DetalleMAV se ha levantado a partir de la tipificacion
                * del cliente!!!!! */ 
               UtilidadesLog.debug(" - SUBCRI_PED_SUP_MONTO_MARCA X");
               sSelect = new StringBuffer("");
               sFrom = new StringBuffer("");
               sWhere = new StringBuffer("");
                               
                sSelect.append(" select SUM(a.monto) ");
                if (dto2.getPeriodoIniMonto() == null || dto2.getPeriodoFinMonto() == null) {
                   sFrom.append(" FROM (SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   sFrom.append(" ) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ped_solic_posic , mae_produ ");
                   sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ped_solic_cabec.oid_soli_cabe ");
                   //sb
                   sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                   sFrom.append(" AND mae_produ.MAPR_OID_MARC_PROD = " + dto2.getMarcaCondicion());
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013                   
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ped_solic_cabec.oid_soli_cabe ");
                   sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" AND mae_produ.MAPR_OID_MARC_PROD = " + dto2.getMarcaCondicion());
                   sFrom.append(" ) a ");
                   sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto() );
                } else {
                   /* Nota: No se puede hacer SUM (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem)
                    *  ya que hay una condicion que chequear para cada una de las posiciones
                    *  de la solicitud, y puede dejar algunas posiciones afuera (el campo
                    *  val_prec_cata_tota_loc_uni_dem tiene el valor por TODAS las posiciones).*/
                   sFrom.append(" FROM (SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   sFrom.append(" ) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ");
                   sFrom.append(" cra_perio pini, ");
                   sFrom.append(" cra_perio pfin, ");
                   sFrom.append(" cra_perio pcabecera, ");
                   sFrom.append(" ped_solic_posic, ");
                   sFrom.append(" mae_produ mp ");
                   sFrom.append(" WHERE pini.oid_peri = " + dto2.getPeriodoIniMonto());
                   sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                   sFrom.append(" AND pcabecera.oid_peri = ped_solic_cabec.perd_oid_peri ");
                   sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                   sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                   sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                   sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                   sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                   sFrom.append(" AND ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   sFrom.append(" AND mp.oid_prod = ped_solic_posic.prod_oid_prod " );                    
                   sFrom.append(" AND mp.MAPR_OID_MARC_PROD = " + dto2.getMarcaCondicion());
                   sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                   sFrom.append(" ped_solic_cabec.oid_soli_cabe ");
                   sFrom.append(" AND ped_solic_cabec.FEC_FACT IS NOT NULL ");
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/0/2013
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                   //sFrom.append(" ped_solic_cabec.oid_soli_cabe ");
                   sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" AND mae_produ.MAPR_OID_MARC_PROD = " + dto2.getMarcaCondicion() + ") a ");
                   //sFrom.append(" AND ped_solic_posic.prod_oid_prod = " + dto2.getMarcaCondicion() + ") a ");
                   sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto() );
                }
               
            }
            
            // -------------------------------------------------------------------------------------
            if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO_U_NEGOCIO ) ) {
              UtilidadesLog.debug(" - SUBCRI_PED_SUP_MONTO_U_NEGOCIO");
              
              sSelect = new StringBuffer("");
              sFrom = new StringBuffer("");
              sWhere = new StringBuffer("");
               
              sSelect.append(" select SUM(a.monto) ");
              if ( dto2.getPeriodoIniMonto() == null || 
                      dto2.getPeriodoFinMonto() == null ) {
                 sFrom.append(" FROM (SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                 sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                 sFrom.append(" ) monto ");
                 sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                 sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                 sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                 sFrom.append("                   ped_solic_cabec.oid_soli_cabe ");
                 sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                 sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                 sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                 sFrom.append(" AND mae_produ.uneg_oid_unid_nego = " + dto2.getUnidadNegocio());
                 sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/0/2013
                 sFrom.append(" UNION ALL ");
                 //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                 //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                 //sFrom.append(" ) monto ");
                 //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                 //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                 //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                 //sFrom.append("                   ped_solic_posic.soca_oid_soli_cabe ");
                 //sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                 sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                 sFrom.append(" AND mae_produ.uneg_oid_unid_nego = " + dto2.getUnidadNegocio() + ") a ");
                 sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto() );

              } else {
                 /* Nota: No se puede hacer SUM (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem)
                  *  ya que hay una condicion que chequear para cada una de las posiciones
                  *  de la solicitud, y puede dejar algunas posiciones afuera (el campo
                  *  val_prec_cata_tota_loc_uni_dem tiene el valor por TODAS las posiciones).*/
                  sFrom.append(" FROM (SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                  sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                  sFrom.append(" ) monto ");
                  sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ,");
                  sFrom.append(" cra_perio pini, cra_perio pfin, cra_perio pcabecera");
                  sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                  sFrom.append(" AND ped_solic_cabec.fec_fact IS NOT NULL ");
                  sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                  sFrom.append("         ped_solic_posic.soca_oid_soli_cabe ");
                  sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                  sFrom.append(" AND mae_produ.uneg_oid_unid_nego = " + dto2.getUnidadNegocio());
                  sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                  //sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                  sFrom.append(" AND ped_solic_cabec.perd_oid_peri = pcabecera.oid_peri ");
                  sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                  sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                  sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                  sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                  sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                  sFrom.append(" AND pini.oid_peri = " + dto2.getPeriodoIniMonto());
                  sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                  sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                  sFrom.append(" UNION ALL ");
                  //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                  //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                  //sFrom.append(" ) monto ");
                  //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                  //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                  //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                  //sFrom.append("                        ped_solic_posic.soca_oid_soli_cabe ");
                  //sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                  sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                  sFrom.append(" AND mae_produ.uneg_oid_unid_nego = " + dto2.getUnidadNegocio());
                  sFrom.append(" ) a ");                  
                  sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto() );                  
              }
            }
            
            // -------------------------------------------------------------------------------------
            if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO_NEGOCIO )) {
               UtilidadesLog.debug(" - SUBCRI_PED_SUP_MONTO_NEGOCIO");
               
               sSelect = new StringBuffer("");
               sFrom = new StringBuffer("");
               sWhere = new StringBuffer("");
               
               sSelect.append(" select SUM(a.monto) ");
               if (dto2.getPeriodoIniMonto() == null || dto2.getPeriodoFinMonto() == null ) {              
                   sFrom.append(" FROM (SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                   sFrom.append(" ) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                   sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                   sFrom.append("        ped_solic_posic.soca_oid_soli_cabe ");
                   sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                   sFrom.append(" AND mae_produ.nego_oid_nego = " + dto2.getNegocio());
                   sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                   //sFrom.append("        ped_solic_posic.soca_oid_soli_cabe ");
                   //sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                   sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" AND mae_produ.nego_oid_nego = " + dto2.getNegocio() + ") a ");
                   sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto() );
                } else {
                  /* Nota: No se puede hacer SUM (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem)
                   *  ya que hay una condicion que chequear para cada una de las posiciones
                   *  de la solicitud, y puede dejar algunas posiciones afuera (el campo
                   *  val_prec_cata_tota_loc_uni_dem tiene el valor por TODAS las posiciones).*/
                   sFrom.append(" FROM (SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   sFrom.append(" ) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ, ");
                   sFrom.append(" cra_perio pini, cra_perio pfin, cra_perio pcabecera ");
                   sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                   sFrom.append("               ped_solic_posic.soca_oid_soli_cabe ");
                   sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                   sFrom.append(" AND mae_produ.nego_oid_nego = " + dto2.getNegocio());
                   //sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                   sFrom.append(" AND ped_solic_cabec.perd_oid_peri = pcabecera.oid_peri ");
                   sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                   sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                   sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                   sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                   sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                   sFrom.append(" AND pini.oid_peri = " + dto2.getPeriodoIniMonto());
                   sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                   sFrom.append(" AND ped_solic_cabec.fec_fact IS NOT NULL ");
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud() );
                   //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
                   //sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                   sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" AND mae_produ.nego_oid_nego = " + dto2.getNegocio());
                   sFrom.append(" ) a ");                 
                   sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto() );                 
              }
              
            }
            
            // -------------------------------------------------------------------------------------
            if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_SUP_MONTO_CATALOGO )) {
               UtilidadesLog.debug(" - SUBCRI_PED_SUP_MONTO_CATALOGO");
               sSelect = new StringBuffer("");
               sFrom = new StringBuffer("");
               sWhere = new StringBuffer("");
               
               sSelect.append(" select SUM(a.monto) ");
               
               if (dto2.getPeriodoIniMonto() == null || dto2.getPeriodoFinMonto() == null) {
                  sFrom.append(" FROM (SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                  sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                  sFrom.append(" ) monto ");
                  sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, pre_ofert_detal ");
                  sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != "+ dto1.getOidSolicitud());
                  sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
                  sFrom.append(" AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
                  sFrom.append(" AND pre_ofert_detal.ocat_oid_catal = " + dto2.getCatalogo());
                  sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                  sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                  sFrom.append(" AND ped_solic_cabec.fec_fact IS NOT NULL ");
                  sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                  sFrom.append(" UNION ALL ");
                  //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                  //sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                  //sFrom.append(" ) monto ");
                  //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, pre_ofert_detal ");
                  //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                  //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
                  //sFrom.append(" AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
                  sFrom.append( sbTemp3.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                  sFrom.append(" AND pre_ofert_detal.ocat_oid_catal = " + dto2.getCatalogo());
                  sFrom.append(" ) a ");                  
                  sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto() );
               } else {
                  sFrom.append(" FROM (SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                  sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                  sFrom.append(" ) monto ");
                  sFrom.append(" FROM ped_solic_cabec, ");
                  sFrom.append(" ped_solic_posic, ");
                  sFrom.append(" cra_perio pini, ");
                  sFrom.append(" cra_perio pfin, ");
                  sFrom.append(" cra_perio pcabecera, ");
                  sFrom.append(" pre_ofert_detal ");
                  sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                  sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                  sFrom.append(" ped_solic_posic.soca_oid_soli_cabe ");
                  sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                  //Gacevedo tiene periodo de inicio y fin, el periodo no debe tenerse en cuenta
                  //Parece ser un problema de "copy paste". V-MAV-08
                  //sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                  sFrom.append(" AND ped_solic_cabec.fec_fact IS NOT NULL ");
                  sFrom.append(" AND ped_solic_cabec.perd_oid_peri = pcabecera.oid_peri ");
                  sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                  sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                  sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                  sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                  sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                  sFrom.append(" AND pini.oid_peri = " + dto2.getPeriodoIniMonto());
                  sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                  sFrom.append(" AND ped_solic_posic.ofde_oid_deta_ofer = ");
                  sFrom.append(" pre_ofert_detal.oid_deta_ofer ");
                  sFrom.append(" AND pre_ofert_detal.ocat_oid_catal = " + dto2.getCatalogo());
                  sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013                  
                  sFrom.append(" UNION ALL ");
                  //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                  //sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                  //sFrom.append(" ) monto ");
                  //sFrom.append(" FROM ped_solic_cabec, ");
                  //sFrom.append(" ped_solic_posic, ");
                  //sFrom.append(" pre_ofert_detal ");
                  //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                  //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
                  //sFrom.append(" AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
                  sFrom.append( sbTemp3.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                  sFrom.append(" AND pre_ofert_detal.ocat_oid_catal = " + dto2.getCatalogo());
                  sFrom.append(" ) a ");
                  sWhere.append(" HAVING SUM(a.monto) >= " + dto2.getMonto() );
               }
            } // Fin Modificacion ssantana, inc. BELC300018225
            
            //SBuchelli PER-SiCC-2010-0109
            /*
             * Actividad 5: Se agrega funcionalidad para manejar mas opciones en atributos a evaluar 
             * para el criterio de Asignacion por Atributos. Las nuevas opciones  
             * asignan el despacho a consultoras que NO superan el monto indicado 
             * para las diferntes modalidades que se manejan actualmente ( en marca, en unidad de negocio, en negocio y en catálogo)
             * 
             * */
            
             // -------------------------------------------------------------------------------------
             if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_NO_SUP_MONTO) ) {
                UtilidadesLog.debug(" - SUBCRI_PED_NO_SUP_MONTO");

                sSelect = new StringBuffer("");
                sFrom = new StringBuffer("");
                sWhere = new StringBuffer("");
                
                sSelect.append(" select SUM(a.monto) ");
                
                if ( dto2.getPeriodoIniMonto() == null || 
                                       dto2.getPeriodoFinMonto() == null) {
                   sFrom.append(" FROM (SELECT SUM ");
                   sFrom.append(" (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem) monto ");
                   sFrom.append(" FROM ped_solic_cabec ");
                   sFrom.append(" WHERE ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                   sFrom.append(" AND ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013                   
                   sFrom.append(" UNION ALL  ");
                   //sFrom.append(" SELECT SUM (ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                   //sFrom.append(" ped_solic_cabec.oid_soli_cabe) a ");
                   sFrom.append( sbTemp.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" ) a ");
                   sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto() );
                } else {
                    sFrom.append(" FROM (SELECT SUM (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem) monto ");
                    sFrom.append(" FROM ped_solic_cabec, ");
                    sFrom.append(" cra_perio pini, ");
                    sFrom.append(" cra_perio pfin, ");
                    sFrom.append(" cra_perio pcabecera ");
                    sFrom.append(" WHERE pini.oid_peri = " + dto2.getPeriodoIniMonto());
                    sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                    sFrom.append(" AND pcabecera.oid_peri = ped_solic_cabec.perd_oid_peri ");
                    sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                    sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                    sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                    sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                    sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                    sFrom.append(" AND ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                    sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                    sFrom.append(" and ped_solic_cabec.FEC_FACT IS NOT NULL ");
                    sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                    sFrom.append(" UNION ALL ");
                    //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                    //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                    //sFrom.append(" ) monto ");
                    //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic ");
                    //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                    //sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                    //sFrom.append(" ped_solic_cabec.oid_soli_cabe) a ");
                    sFrom.append( sbTemp.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                    sFrom.append(" ) a ");
                    sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto());
                }
             }
             
             // -------------------------------------------------------------------------------------
             if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_NO_SUP_MONTO_MARCA)) {
           
                UtilidadesLog.debug(" - SUBCRI_PED_NO_SUP_MONTO_MARCA XX");
                sSelect = new StringBuffer("");
                sFrom = new StringBuffer("");
                sWhere = new StringBuffer("");
                
                sSelect.append(" select SUM(a.monto) ");
                if (dto2.getPeriodoIniMonto() == null || dto2.getPeriodoFinMonto() == null) {
                   sFrom.append(" FROM (SELECT NVL(SUM (  ped_solic_posic.num_unid_por_aten ");
                   sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   sFrom.append(" ),0) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ped_solic_posic , mae_produ ");
                   sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ped_solic_cabec.oid_soli_cabe ");
                   //sb
                   sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                   sFrom.append(" AND mae_produ.MAPR_OID_MARC_PROD = " + dto2.getMarcaCondicion());
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ped_solic_cabec.oid_soli_cabe ");
                   sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" AND mae_produ.MAPR_OID_MARC_PROD = " + dto2.getMarcaCondicion());
                   sFrom.append(" ) a ");
                   sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto() );
                } else {
                   /* Nota: No se puede hacer SUM (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem)
                    *  ya que hay una condicion que chequear para cada una de las posiciones
                    *  de la solicitud, y puede dejar algunas posiciones afuera (el campo
                    *  val_prec_cata_tota_loc_uni_dem tiene el valor por TODAS las posiciones).*/
                   sFrom.append(" FROM (SELECT NVL(SUM (  ped_solic_posic.num_unid_por_aten ");
                   sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   sFrom.append(" ),0) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ");
                   sFrom.append(" cra_perio pini, ");
                   sFrom.append(" cra_perio pfin, ");
                   sFrom.append(" cra_perio pcabecera, ");
                   sFrom.append(" ped_solic_posic, ");
                   sFrom.append(" mae_produ mp ");
                   sFrom.append(" WHERE pini.oid_peri = " + dto2.getPeriodoIniMonto());
                   sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                   sFrom.append(" AND pcabecera.oid_peri = ped_solic_cabec.perd_oid_peri ");
                   sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                   sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                   sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                   sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                   sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                   sFrom.append(" AND ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   sFrom.append(" AND mp.oid_prod = ped_solic_posic.prod_oid_prod " );                    
                   sFrom.append(" AND mp.MAPR_OID_MARC_PROD = " + dto2.getMarcaCondicion());
                   sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                   sFrom.append(" ped_solic_cabec.oid_soli_cabe ");
                   sFrom.append(" AND ped_solic_cabec.FEC_FACT IS NOT NULL ");
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                   //sFrom.append(" ped_solic_cabec.oid_soli_cabe ");
                   sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" AND mae_produ.MAPR_OID_MARC_PROD = " + dto2.getMarcaCondicion() + ") a ");
                   //sFrom.append(" AND ped_solic_posic.prod_oid_prod = " + dto2.getMarcaCondicion() + ") a ");
                   sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto() );
                }
             }
             
             // -------------------------------------------------------------------------------------
             if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_NO_SUP_MONTO_U_NEGOCIO ) ) {
               UtilidadesLog.debug(" - SUBCRI_PED_NO_SUP_MONTO_U_NEGOCIO");
               
               sSelect = new StringBuffer("");
               sFrom = new StringBuffer("");
               sWhere = new StringBuffer("");
                
               sSelect.append(" select SUM(a.monto) ");
               if ( dto2.getPeriodoIniMonto() == null || 
                       dto2.getPeriodoFinMonto() == null ) {
                  sFrom.append(" FROM (SELECT NVL(SUM (  ped_solic_posic.num_unid_por_aten ");
                  sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                  sFrom.append(" ),0) monto ");
                  sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                  sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                  sFrom.append(" AND ped_solic_posic.soca_oid_soli_cabe = ");
                  sFrom.append("                   ped_solic_cabec.oid_soli_cabe ");
                  sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                  sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                  sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                  sFrom.append(" AND mae_produ.uneg_oid_unid_nego = " + dto2.getUnidadNegocio());
                  sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                  sFrom.append(" UNION ALL ");
                  //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                  //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                  //sFrom.append(" ) monto ");
                  //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                  //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                  //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                  //sFrom.append("                   ped_solic_posic.soca_oid_soli_cabe ");
                  //sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                  sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                  sFrom.append(" AND mae_produ.uneg_oid_unid_nego = " + dto2.getUnidadNegocio() + ") a ");
                  sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto() );

               } else {
                  /* Nota: No se puede hacer SUM (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem)
                   *  ya que hay una condicion que chequear para cada una de las posiciones
                   *  de la solicitud, y puede dejar algunas posiciones afuera (el campo
                   *  val_prec_cata_tota_loc_uni_dem tiene el valor por TODAS las posiciones).*/
                   sFrom.append(" FROM (SELECT NVL(SUM (  ped_solic_posic.num_unid_por_aten ");
                   sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   sFrom.append(" ),0) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ,");
                   sFrom.append(" cra_perio pini, cra_perio pfin, cra_perio pcabecera");
                   sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.fec_fact IS NOT NULL ");
                   sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                   sFrom.append("         ped_solic_posic.soca_oid_soli_cabe ");
                   sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                   sFrom.append(" AND mae_produ.uneg_oid_unid_nego = " + dto2.getUnidadNegocio());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   //sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                   sFrom.append(" AND ped_solic_cabec.perd_oid_peri = pcabecera.oid_peri ");
                   sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                   sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                   sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                   sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                   sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                   sFrom.append(" AND pini.oid_peri = " + dto2.getPeriodoIniMonto());
                   sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                   //sFrom.append("                        ped_solic_posic.soca_oid_soli_cabe ");
                   //sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                   sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" AND mae_produ.uneg_oid_unid_nego = " + dto2.getUnidadNegocio());
                   sFrom.append(" ) a ");                  
                   sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto() );                  
               }
             }
             
             // -------------------------------------------------------------------------------------
             if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_NO_SUP_MONTO_NEGOCIO )) {
                UtilidadesLog.debug(" - SUBCRI_PED_NO_SUP_MONTO_NEGOCIO");
                
                sSelect = new StringBuffer("");
                sFrom = new StringBuffer("");
                sWhere = new StringBuffer("");
                
                sSelect.append(" select SUM(a.monto) ");
                if (dto2.getPeriodoIniMonto() == null || dto2.getPeriodoFinMonto() == null ) {              
                    sFrom.append(" FROM (SELECT NVL(SUM (  ped_solic_posic.num_unid_por_aten ");
                    sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                    sFrom.append(" ),0) monto ");
                    sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                    sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                    sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                    sFrom.append("        ped_solic_posic.soca_oid_soli_cabe ");
                    sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                    sFrom.append(" AND mae_produ.nego_oid_nego = " + dto2.getNegocio());
                    sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                    sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                    sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                    sFrom.append(" UNION ALL ");
                    //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                    //sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                    //sFrom.append(" ) monto ");
                    //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                    //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                    //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                    //sFrom.append("        ped_solic_posic.soca_oid_soli_cabe ");
                    //sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                    sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                    sFrom.append(" AND mae_produ.nego_oid_nego = " + dto2.getNegocio() + ") a ");
                    sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto() );
                 } else {
                   /* Nota: No se puede hacer SUM (ped_solic_cabec.val_prec_cata_tota_loc_uni_dem)
                    *  ya que hay una condicion que chequear para cada una de las posiciones
                    *  de la solicitud, y puede dejar algunas posiciones afuera (el campo
                    *  val_prec_cata_tota_loc_uni_dem tiene el valor por TODAS las posiciones).*/
                    sFrom.append(" FROM (SELECT NVL(SUM (  ped_solic_posic.num_unid_por_aten ");
                    sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                    sFrom.append(" ),0) monto ");
                    sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ, ");
                    sFrom.append(" cra_perio pini, cra_perio pfin, cra_perio pcabecera ");
                    sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                    sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                    sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                    sFrom.append("               ped_solic_posic.soca_oid_soli_cabe ");
                    sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                    sFrom.append(" AND mae_produ.nego_oid_nego = " + dto2.getNegocio());
                    //sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                    sFrom.append(" AND ped_solic_cabec.perd_oid_peri = pcabecera.oid_peri ");
                    sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                    sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                    sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                    sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                    sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                    sFrom.append(" AND pini.oid_peri = " + dto2.getPeriodoIniMonto());
                    sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                    sFrom.append(" AND ped_solic_cabec.fec_fact IS NOT NULL ");
                    sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                    sFrom.append(" UNION ALL ");
                    //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                    //sFrom.append(" * ped_solic_posic.val_prec_cata_tota_loca ");
                    //sFrom.append(" ) monto ");
                    //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, mae_produ ");
                    //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud() );
                    //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
                    //sFrom.append(" AND ped_solic_posic.prod_oid_prod = mae_produ.oid_prod ");
                    sFrom.append( sbTemp2.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                    sFrom.append(" AND mae_produ.nego_oid_nego = " + dto2.getNegocio());
                    sFrom.append(" ) a ");                 
                    sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto() );                 
               }
               
             }
             
             // -------------------------------------------------------------------------------------
             if ( subcriterio.equals(ConstantesMAV.SUBCRI_PED_NO_SUP_MONTO_CATALOGO )) {
                UtilidadesLog.debug(" - SUBCRI_PED_NO_SUP_MONTO_CATALOGO");
                sSelect = new StringBuffer("");
                sFrom = new StringBuffer("");
                sWhere = new StringBuffer("");
                
                sSelect.append(" select SUM(a.monto) ");
                
                if (dto2.getPeriodoIniMonto() == null || dto2.getPeriodoFinMonto() == null) {
                   sFrom.append(" FROM (SELECT NVL(SUM (  ped_solic_posic.num_unid_por_aten ");
                   sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                   sFrom.append(" ),0) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, pre_ofert_detal ");
                   sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != "+ dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
                   sFrom.append(" AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
                   sFrom.append(" AND pre_ofert_detal.ocat_oid_catal = " + dto2.getCatalogo());
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                   sFrom.append(" AND ped_solic_cabec.fec_fact IS NOT NULL ");
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ped_solic_posic, pre_ofert_detal ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
                   //sFrom.append(" AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
                   sFrom.append( sbTemp3.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" AND pre_ofert_detal.ocat_oid_catal = " + dto2.getCatalogo());
                   sFrom.append(" ) a ");                  
                   sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto() );
                } else {
                   sFrom.append(" FROM (SELECT NVL(SUM (  ped_solic_posic.num_unid_por_aten ");
                   sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                   sFrom.append(" ),0) monto ");
                   sFrom.append(" FROM ped_solic_cabec, ");
                   sFrom.append(" ped_solic_posic, ");
                   sFrom.append(" cra_perio pini, ");
                   sFrom.append(" cra_perio pfin, ");
                   sFrom.append(" cra_perio pcabecera, ");
                   sFrom.append(" pre_ofert_detal ");
                   sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe != " + dto1.getOidSolicitud());
                   sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ");
                   sFrom.append(" ped_solic_posic.soca_oid_soli_cabe ");
                   sFrom.append(" AND ped_solic_cabec.clie_oid_clie = " + dto1.getOidCliente());
                   //Gacevedo tiene periodo de inicio y fin, el periodo no debe tenerse en cuenta
                   //Parece ser un problema de "copy paste". V-MAV-08
                   //sFrom.append(" AND ped_solic_cabec.perd_oid_peri = " + dto1.getOidPeriodo());
                   sFrom.append(" AND ped_solic_cabec.fec_fact IS NOT NULL ");
                   sFrom.append(" AND ped_solic_cabec.perd_oid_peri = pcabecera.oid_peri ");
                   sFrom.append(" AND pcabecera.fec_inic >= pini.fec_inic ");
                   sFrom.append(" AND pcabecera.fec_fina <= pfin.fec_fina ");
                   sFrom.append(" AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                   sFrom.append(" AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                   sFrom.append(" AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                   sFrom.append(" AND pini.oid_peri = " + dto2.getPeriodoIniMonto());
                   sFrom.append(" AND pfin.oid_peri = " + dto2.getPeriodoFinMonto());
                   sFrom.append(" AND ped_solic_posic.ofde_oid_deta_ofer = ");
                   sFrom.append(" pre_ofert_detal.oid_deta_ofer ");
                   sFrom.append(" AND pre_ofert_detal.ocat_oid_catal = " + dto2.getCatalogo());
                   sFrom.append(" and ped_solic_cabec.ind_oc = 1 "); // sapaza -- PER-SiCC-2013-0169 -- 05/03/2013
                   sFrom.append(" UNION ALL ");
                   //sFrom.append(" SELECT SUM (  ped_solic_posic.num_unid_por_aten ");
                   //sFrom.append(" * ped_solic_posic.val_prec_cata_unit_loca ");
                   //sFrom.append(" ) monto ");
                   //sFrom.append(" FROM ped_solic_cabec, ");
                   //sFrom.append(" ped_solic_posic, ");
                   //sFrom.append(" pre_ofert_detal ");
                   //sFrom.append(" WHERE ped_solic_cabec.oid_soli_cabe = " + dto1.getOidSolicitud());
                   //sFrom.append(" AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
                   //sFrom.append(" AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
                   sFrom.append( sbTemp3.toString() );    //  Modificado por HRCS - Incidencia SiCC20080605
                   sFrom.append(" AND pre_ofert_detal.ocat_oid_catal = " + dto2.getCatalogo());
                   sFrom.append(" ) a ");
                   sWhere.append(" HAVING SUM(a.monto) < " + dto2.getMonto() );
                }
             } // Fin Modificacion SBUCHELLI PER-SiCC-2010-0109

              // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
              if ( subcriterio.equals(ConstantesMAV.SUBCRI_INSCRIPCION_DUPLA_CYZONE) ) {
                 UtilidadesLog.debug(" - SUBCRI_INSCRIPCION_DUPLA_CYZONE");

                 sSelect = new StringBuffer("");
                 sFrom = new StringBuffer("");
                 sWhere = new StringBuffer("");

                 sSelect.append(" SELECT vinc.OID_CLIE_VINC ");
                 sSelect.append("   FROM MAE_CLIEN_VINCU vinc, ");
                 sSelect.append("        MAE_TIPO_VINCU tipo,  ");
                 sSelect.append("        CRA_PERIO pini, ");
                 sSelect.append("        CRA_PERIO pfin ");
                 sSelect.append("  WHERE vinc.TIVC_OID_TIPO_VINC = tipo.OID_TIPO_VINC ");
                 sSelect.append("    AND tipo.COD_TIPO_VINC = '01' ");
                 sSelect.append("    AND pini.OID_PERI = " + dto2.getPeriodoIniMonto());
                 sSelect.append("    AND pfin.OID_PERI = " + dto2.getPeriodoFinMonto());
                 sSelect.append("    AND vinc.FEC_DESD >= pini.FEC_INIC ");
                 sSelect.append("    AND vinc.FEC_DESD <= pfin.FEC_FINA ");
                 sSelect.append("    AND vinc.CLIE_OID_CLIE_VNTE = " + dto1.getOidCliente());
                 sSelect.append("    AND vinc.FEC_HAST IS NULL ");

              }
            
        } catch (NoResultException fEx) {
            UtilidadesLog.debug(fEx);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(fEx, UtilidadesError.armarCodigoError(codigoError));       
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));       
           
        }
            
        try { 
            query = sSelect.toString() + sFrom.toString() + sWhere.toString();
            es.indra.mare.common.mii.services.jdbcservice.RecordSet rs;
      
            rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet)bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " +rs);
            bs = null;

            if(!rs.esVacio()) {
              UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.cumpleCriterioPorAtributos(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida TRUE");
              return new Boolean(true);
            }
                
            UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.cumpleCriterioPorAtributos(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida FALSE");
            return new Boolean(false);
        } catch(Exception e) {
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }

    /**
     * DAOProcesoEnvioAgregadosSolicitud.cumpleEstatusCliente(detalleMAV : DTODetalleMAV, oidCliente : Long) : Boolean
     *
     * Entrada:
     * - detalleMAV : DTODetalleMAV
     * - oidCliente : Long
     * Proceso:
     * -> Hacer consulta JDBC sobre la tabla MAE_CLIEN para obtener COUNT(*) para los siguientes criterios:
     * -> Cruzar tabla MAE_CLIEN con tabla MAE_CLIEN_DATOS_ADICI, y esta a su vez con tabla MAE_ESTAT_CLIEN, y esta a su vez con MAV_ESTAD_MAV_MAE, y esta a su vez con MAV_ESTAD_MAV, y esta a su vez con MAV_ACTIV_ESTAD, y esta a su vez con MAV_DETAL_MAV
     * -> MAV_DETAL_MAV.OID = detalleMAV.oidDetalleMAV
     * -> MAE_CLIEN.OID_CLIE = oidCliente
     * -> Si la consulta devuelve un resultado mayor que 0 devolver "True" si no devolver "False"
     */
    public Boolean cumpleEstatusCliente(DTODetalleMAV dtoDetalleMAV, Long lngOidCliente)
        throws MareException {
        
        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.cumpleEstatusCliente(DTODetalleMAV dtoDetalleMAV, Long lngOidCliente):Entrada");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch(MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            /*query.append(" SELECT COUNT(*) TOTAL_PRODUCTO ");
            query.append(" FROM MAE_CLIEN, ");
            query.append(" MAE_CLIEN_DATOS_ADICI, ");
            query.append(" MAE_ESTAT_CLIEN, ");
            query.append(" MAV_ESTAD_MAV_MAE, ");
            query.append(" MAV_ESTAD_MAV, ");
            query.append(" MAV_ACTIV_ESTAD, ");
            query.append(" MAV_DETAL_MAV ");
            query.append(" WHERE MAE_CLIEN_DATOS_ADICI.OID_CLIE_DATO_ADIC = MAE_CLIEN.COD_CLIE  ");
            query.append(" AND MAE_CLIEN_DATOS_ADICI.ESTA_OID_ESTA_CLIE = MAE_ESTAT_CLIEN.OID_ESTA_CLIE  ");
            query.append(" AND MAE_ESTAT_CLIEN.OID_ESTA_CLIE = MAV_ESTAD_MAV_MAE.ESTA_OID_ESTA_CLIE  ");
            query.append(" AND MAV_ESTAD_MAV_MAE.OID_ESTA_MAV_MAE = MAV_ESTAD_MAV.OID_ESTA_MAV  ");
            query.append(" AND MAV_ESTAD_MAV.OID_ESTA_MAV = MAV_ACTIV_ESTAD.EMAV_OID_ESTA_MAV ");
            query.append(" AND MAV_ACTIV_ESTAD.EMAV_OID_ESTA_MAV = MAV_DETAL_MAV.OID_DETA_MAV  ");
            query.append(" AND MAV_DETAL_MAV.OID_DETA_MAV = " + dtoDetalleMAV.getOid());
            query.append(" AND MAE_CLIEN.OID_CLIE = " + lngOidCliente);*/
            
            // Query modificada por ssantana, 13/5/2005
            // para ajustarse al DMCO
            
            // Modificado por ssantana, 2/8/2005, inc. 20366.
            Boolean bRetorno = null;
            if ( dtoDetalleMAV.getEstadoMAV() != null ) { 
              query.append(" SELECT COUNT(*) as TOTAL_PRODUCTO ");
              query.append(" FROM mae_clien, ");
              query.append(" mae_clien_datos_adici, ");
              query.append(" mae_estat_clien, ");
              query.append(" mav_estad_mav_mae, ");
              query.append(" mav_estad_mav, ");
              query.append(" mav_activ_estad, ");
              query.append(" mav_detal_mav ");
              query.append(" WHERE mae_clien.oid_clie = " + lngOidCliente); 
              query.append(" AND mae_clien.oid_clie = mae_clien_datos_adici.clie_oid_clie ");
              query.append(" AND mae_clien_datos_adici.esta_oid_esta_clie = mae_estat_clien.oid_esta_clie ");
              query.append(" AND mae_estat_clien.oid_esta_clie = mav_estad_mav_mae.esta_oid_esta_clie ");
              query.append(" AND mav_estad_mav_mae.emav_oid_esta_mav = mav_estad_mav.oid_esta_mav ");
              query.append(" AND mav_estad_mav.oid_esta_mav = mav_activ_estad.emav_oid_esta_mav ");
              query.append(" AND mav_activ_estad.oid_esta_acti = mav_detal_mav.aest_oid_esta_acti ");
              query.append(" AND mav_detal_mav.oid_deta_mav = " + dtoDetalleMAV.getOid() );

              es.indra.mare.common.mii.services.jdbcservice.RecordSet rs;

              rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet)bs.dbService.executeStaticQuery(query.toString());
              
              if(((BigDecimal)rs.getValueAt(0, "TOTAL_PRODUCTO")).intValue() > 0)
                 bRetorno = Boolean.TRUE;
              else
                 bRetorno = Boolean.FALSE;
            } else {
               bRetorno = Boolean.TRUE;
            }
            // Fin Modificacion por ssantana, 2/8/2005, inc. 20366.

            UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.cumpleEstatusCliente(DTODetalleMAV dtoDetalleMAV, Long lngOidCliente):Salida");
            return bRetorno;
        } catch(Exception e) {
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }

    /**
     * DAOProcesoEnvioAgregadosSolicitud.obtenerEnviosMAV(dto : DTOSolicitudValidacion) : RecordSet
     * Entrada:
     *     - dto : DTOSolicitudValidacion
     * Proceso:
     * -> Hacer consulta JDBC sobre tabla MAV_ENVIO para obtener los siguienes campos:
     *     - Obtener todos los campos de MAV_ENVIO
     *     - MAE_CLIEN.COD_CLIE (Código de cliente)
     *     - Descripción internacionalizada del producto (MAE_PRODU)
     *     - MSG_MENSA.COD_MENSA (Código de mensaje)
     * -> Cruzar tabla MAV_ENVIO con tabla MSG_BUZON_MENSA
     * -> Cruzar tabla MSG_BUZON_MENSA con tabla MSG_MENSA
     * -> Cruzar tabla MAV_ENVIO con tabla MAE_CLIEN
     * -> MAV_ENVIO.CLIE_OID_CLIE = dto.oidCliente
     * -> Cruzar tabla MAV_ENVIO con tabla PRE_MATRI_FACTU1
     * -> Cruzar tabla PRE_MATRI_FACTU con tabla PRE_OFERT_DETAL
     * -> Cruzar tabla PRE_OFERT_DETAL con tabla MAE_PRODU
     * -> Cruzar tabla MAV_ENVIO con tabla MAV_DETAL_MAV y esta a su vez con la tabla
     * MAV_DETAL_MAV_ACCES_SUBAC
     * -> MAV_DETAL_MAV_ACCES_SUBAC.SBAC_OID_SBAC = dto.oidSubacceso
     * -> Devolver RecordSet obtenido
     */
    public RecordSet obtenerEnviosMAV(DTOSolicitudValidacion dtoSolicitudValidacion) throws MareException {
        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.obtenerEnviosMAV(DTOSolicitudValidacion dtoSolicitudValidacion):Entrada");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch(MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            /*query.append(
                " SELECT MAV_ENVIO.OID_ENVI, MAV_ENVIO.FEC_ENTR, MAV_ENVIO.NUM_UNID, ");
            query.append(
                " MAV_ENVIO.VAL_PREC_STND, MAV_ENVIO.VAL_PREC, MAV_ENVIO.VAL_PREC_CONT, ");
            query.append(
                " MAV_ENVIO.DENV_OID_DETA_MAV, MAV_ENVIO.MAFA_OID_MATR_FACT, MAV_ENVIO.CLIE_OID_CLIE  " );
            query.append(
                " ,MAV_ENVIO.ESEN_OID_ESTA_ENVI,MAV_ENVIO.FCOB_OID_FORM_COBR,MAV_ENVIO.ATDE_OID_ACTI_TIPO_DESP");
            query.append(
                " ,MAV_ENVIO.FOPA_OID_FORM_PAGO,MAV_ENVIO.IND_ENVI,MAV_ENVIO.ACTI_OID_ACTI ");
            query.append(
                " ,MAV_ENVIO.NUM_MENS, MAE_CLIEN.COD_CLIE, MAE_PRODU.DES_CORT, ");
            query.append(" MSG_MENSA.COD_MENS, MAV_DETAL_MAV.OID_DETA_MAV,");
            query.append(" PRE_OFERT_DETAL.VAL_CODI_VENT ");
            query.append(" FROM   MAV_ENVIO, ");
            query.append(" 	   MAE_CLIEN, ");
            query.append(" 	   MSG_MENSA, ");
            query.append(" 	   MSG_BUZON_MENSA,	");
            query.append(" 	   PRE_MATRI_FACTU, ");
            query.append(" 	   PRE_OFERT_DETAL, ");
            query.append(" 	   MAE_PRODU, ");
            query.append(" 	   MAV_DETAL_MAV, ");
            query.append(" 	   MAV_DETAL_MAV_ACCES_SUBAC ");
            query.append(" WHERE  MAV_ENVIO.NUM_MENS = MSG_BUZON_MENSA.OID_BUZO_MENS(+) ");
            query.append(" AND    MSG_MENSA.OID_MENS(+) = MSG_BUZON_MENSA.MENS_OID_MENS ");
            query.append(" AND    MAV_ENVIO.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE ");
            query.append(" AND	   MAV_ENVIO.CLIE_OID_CLIE = " + dtoSolicitudValidacion.getOidCliente());
            query.append(" AND	   PRE_MATRI_FACTU.OID_MATR_FACT = MAV_ENVIO.MAFA_OID_MATR_FACT ");
            query.append(" AND	   PRE_MATRI_FACTU.OFDE_OID_DETA_OFER = PRE_OFERT_DETAL.OID_DETA_OFER ");
            query.append(" AND	   PRE_OFERT_DETAL.PROD_OID_PROD = MAE_PRODU.OID_PROD ");
            query.append(" AND	   MAV_ENVIO.DENV_OID_DETA_MAV = MAV_DETAL_MAV.OID_DETA_MAV ");
            query.append(" AND	   MAV_DETAL_MAV.OID_DETA_MAV = MAV_DETAL_MAV_ACCES_SUBAC.DENV_OID_DETA_MAV ");
            
            
            
            // Ssantana, inc. 21658, provisorio. 
            query.append(" and mav_envio.ind_envi = 'P' ");*/
            // Fin Ssantana, inc. 21658, provisorio. 
            
            
            
            /*
             * Agregado por ssantana, 03/03/2006, inc. BELC300018238
             */
            if (dtoSolicitudValidacion.getOidIdioma() == null) {
               Long oidIdioma = 
                   RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor();
               dtoSolicitudValidacion.setOidIdioma(oidIdioma);
            }
            /*query.append(" SELECT   mav_envio.oid_envi, mav_envio.fec_entr, mav_envio.num_unid, ");
            query.append(" mav_envio.val_prec_stnd, mav_envio.val_prec, mav_envio.val_prec_cont, ");
            query.append(" mav_envio.denv_oid_deta_mav, mav_envio.mafa_oid_matr_fact, ");
            query.append(" mav_envio.clie_oid_clie, mav_envio.esen_oid_esta_envi, ");
            query.append(" mav_envio.fcob_oid_form_cobr, mav_envio.atde_oid_acti_tipo_desp, ");
            query.append(" mav_envio.fopa_oid_form_pago, mav_envio.ind_envi, ");
            query.append(" mav_envio.acti_oid_acti, mav_envio.num_mens, mae_clien.cod_clie, ");
            query.append(" v_gen_i18n_sicc.val_i18n,  pre_ofert_detal.val_text_brev, ");
            query.append(" pre_ofert_detal.val_codi_vent ");
            query.append(" FROM mav_envio, ");
            query.append(" mae_clien, ");
            query.append(" pre_matri_factu, ");
            query.append(" pre_matri_factu_cabec, ");
            query.append(" pre_ofert_detal, ");
            query.append(" v_gen_i18n_sicc, ");
            query.append(" mav_estad_envio, ");
            query.append(" mav_activ ");
            query.append(" WHERE mav_envio.clie_oid_clie = mae_clien.oid_clie ");
            query.append(" AND mav_envio.mafa_oid_matr_fact = pre_matri_factu.oid_matr_fact ");
            query.append(" AND pre_matri_factu.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
            query.append(" AND pre_ofert_detal.prod_oid_prod = v_gen_i18n_sicc.val_oid ");
            query.append(" AND v_gen_i18n_sicc.attr_enti = 'MAE_PRODU' ");
            query.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");
            query.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + dtoSolicitudValidacion.getOidIdioma());
            query.append(" AND mae_clien.oid_clie = " + dtoSolicitudValidacion.getOidCliente());
            query.append(" AND pre_matri_factu.mfca_oid_cabe = pre_matri_factu_cabec.oid_cabe ");
            query.append(" AND pre_matri_factu_cabec.perd_oid_peri = " + dtoSolicitudValidacion.getOidPeriodo());
            query.append(" AND ( (mav_envio.denv_oid_deta_mav IN ( ");
            query.append(" SELECT mav_detal_mav_acces_subac.denv_oid_deta_mav ");
            query.append(" FROM mav_detal_mav_acces_subac ");
            query.append(" WHERE mav_detal_mav_acces_subac.sbac_oid_sbac = ");
            query.append(dtoSolicitudValidacion.getOidSubAcceso() + ") ");
            query.append(" ) ");
            query.append(" OR (mav_envio.denv_oid_deta_mav NOT IN ( ");
            query.append(" SELECT mav_detal_mav_acces_subac.denv_oid_deta_mav ");
            query.append(" FROM mav_detal_mav_acces_subac) ");
            query.append(" ) ");
            query.append(" ) ");
            query.append(" AND mav_envio.esen_oid_esta_envi = mav_estad_envio.oid_esta_envi ");
            query.append(" AND (   mav_estad_envio.oid_esta_envi = " + ConstantesMAV.ESTADO_ENVIO_AUTORIZADO);
            query.append(" OR mav_estad_envio.oid_esta_envi = " + ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION);
            query.append(" ) ");
            query.append(" AND mav_envio.acti_oid_acti = mav_activ.oid_acti ");
            query.append(" AND ( mav_envio.ind_envi = '" + ConstantesMAV.INDICADOR_PENDIENTE_ENVIO + "'");
            query.append(" OR ( mav_envio.ind_envi != '" + ConstantesMAV.INDICADOR_PENDIENTE_ENVIO + "'");
            query.append(" AND mav_activ.oid_acti IN ( ");
            query.append(" SELECT mav_activ_tipo_despa.acti_oid_acti ");
            query.append(" FROM mav_activ_tipo_despa ");
            query.append(" WHERE ( (mav_activ_tipo_despa.tdch_oid_tipo_desp = ");
            query.append(ConstantesMAV.DESPACHO_PEDIDO );
            query.append(" AND mav_activ_tipo_despa.envs_oid_envi_soli = ");
            query.append(ConstantesMAV.ENVIO_SOLICITUD_TODAS );
            query.append(" ) ");
            query.append(" OR (    (   mav_activ_tipo_despobtenerEnviosMAVa.tdch_oid_tipo_desp = ");
            query.append(ConstantesMAV.DESPACHO_PEDIDO);
            query.append(" OR mav_activ_tipo_despa.tdch_oid_tipo_desp = ");
            query.append(ConstantesMAV.DESPACHO_PEDIDO_SERVICIO );
            query.append(" ) ");
            query.append(" AND (mav_envio.acti_oid_acti IN ( ");
            query.append(" SELECT mav_activ_tipo_solic.acti_oid_acti ");
            query.append(" FROM mav_activ_tipo_solic ");
            query.append(" WHERE mav_activ_tipo_solic.tspa_oid_tipo_soli_pais = ");
            query.append(dtoSolicitudValidacion.getOidTipoSolPais() );
            query.append(" ))))))) ");
            query.append(" ORDER BY 1 ");   */
            /*
             * Fin Agregado por ssantana, 03/03/2006, inc. BELC300018238
             */
             
            /*
             * inicio enozigli 16/02/2007 Incidencia. SiCC 20070024
             */             
             /*
            ArrayList parametros = new ArrayList();
            parametros.add(dtoSolicitudValidacion.getOidIdioma().toString());
            parametros.add(dtoSolicitudValidacion.getOidCliente().toString());
            parametros.add(dtoSolicitudValidacion.getOidPeriodo().toString());
            parametros.add(dtoSolicitudValidacion.getOidSubAcceso().toString());
            parametros.add(ConstantesMAV.ESTADO_ENVIO_AUTORIZADO.toString());
            parametros.add(ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION.toString());
            parametros.add(ConstantesMAV.INDICADOR_PENDIENTE_ENVIO.toString());
            parametros.add((new Integer(ConstantesMAV.DESPACHO_PEDIDO)).toString());
            parametros.add(ConstantesMAV.ENVIO_SOLICITUD_TODAS.toString());
            parametros.add((new Integer(ConstantesMAV.DESPACHO_PEDIDO_SERVICIO)).toString());
            parametros.add(dtoSolicitudValidacion.getOidTipoSolPais().toString());
            parametros.add(ConstantesBEL.COD_EST_LIBRE_DISP.toString());*/           
            
            
            query.append(" select * from table(CAST(MAV_OBTENER_ENVIOS_MAV( ");
            query.append(" "+dtoSolicitudValidacion.getOidIdioma().toString()+", ");
            query.append(" "+dtoSolicitudValidacion.getOidCliente().toString()+", ");
            query.append(" "+dtoSolicitudValidacion.getOidPeriodo().toString()+", ");
            query.append(" "+dtoSolicitudValidacion.getOidSubAcceso().toString()+", ");
            query.append(" "+ConstantesMAV.ESTADO_ENVIO_AUTORIZADO.toString()+", ");
            query.append(" "+ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION.toString()+", ");
            query.append(" '"+ConstantesMAV.INDICADOR_PENDIENTE_ENVIO.toString()+"', ");
            query.append(" "+(new Integer(ConstantesMAV.DESPACHO_PEDIDO)).toString()+", ");
            query.append(" "+ConstantesMAV.ENVIO_SOLICITUD_TODAS.toString()+", ");
            query.append(" "+(new Integer(ConstantesMAV.DESPACHO_PEDIDO_SERVICIO)).toString()+", ");
            query.append(" "+dtoSolicitudValidacion.getOidTipoSolPais().toString()+", ");
            query.append(" '"+ConstantesBEL.COD_EST_LIBRE_DISP.toString()+"') as OBJ_MAV_OBTENER_ENVIO_TABLE))");
 
            RecordSet rs = bs.dbService.executeStaticQuery(query.toString());
			
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
	    if(log.isDebugEnabled())
                UtilidadesLog.debug("resultado ggg  MAV_OBTENER_ENVIOS_MAV: " + rs);
				
            //rs = bs.dbService.executeProcedure("PQ_PLANI.MAV_OBTERNER_ENVIOS_MAV",parametros);
            /*
             * fin enozigli 16/02/2007 Incidencia. SiCC 20070024
             */            
            bs = null;

            UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.obtenerEnviosMAV(DTOSolicitudValidacion dtoSolicitudValidacion):Salida");
            return rs;
        } catch(Exception e) {
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }

    /**
     * DAOProcesoEnvioAgregadosSolicitud.cumpleZonificacion(detalleMAV : DTODetalleMAV, oidCliente : Long) : Boolean
     *
     * Entrada:
     * - detalleMAV : DTODetalleMAV
     * - oidCliente : Long
     * Proceso:
     * -> Hacer consulta JDBC sobre la tabla MAE_CLIEN para obtener COUNT(*) por los siguientes criterios:
     * -> Cruzar tabla MAE_CLIEN con tabla MAE_CLIEN_UNIDA_ADMIN tal que MAE_CLIEN.OID_CLIE = MAE_CLIEN_UNIDA_ADMIN.OID_CLIE_UNID_ADMI
     * -> Cruzar tabla MAE_CLIEN_UNIDA_ADMIN con tabla ZON_TERRI_ADMIN tal que ZON_TERRI_ADMIN.OID_TERR_ADMI = MAE_CLIEN_UNIDA_ADMIN.ZTAD_OID_TERR_ADMI
     * -> Cruzar tabla ZON_TERRI_ADMIN con la tabla ZON_SECCI tal que ZON_TERRI_ADMIN.ZSCC_OID_SECC = ZON_SECCI.OID_SECC
     * -> Cruzar tabla ZON_SECCI con la tabla ZON_ZONA tal que ZON_ZONA.OID_ZONA = ZON_SECCI.ZZON_OID_ZONA
     * -> Cruzar tabla ZON_ZONA con la tabla ZON_REGIO tal que ZON_REGIO.OID_REGI = ZON_ZONA.ZORG_OID_REGI
     * -> Cruzar tabla ZON_REGIO con la tabla ZON_SUB_GEREN_VENTA.OID_SUBG_VENT = ZON_REGIO.ZSGV_OID_SUBG_VENT
     * -> ZON_SUB_GEREN_VENTA.OID_SUBG_VENT = alguna de las subgerencias contenidas en dto.subgerencias[] OR ZON_REGIO.OID_REGI = alguna de las regiones contenidas en dto.regiones[] OR ZON_ZONA.OID_ZONA = alguna de las zonas contenidas en dto.zonas[]
     * -> MAE_CLIEN.OID_CLIEN = oidCliente
     * -> La consulta devuelve una cuenta de registros que cumplen la zonificación de un DetalleMAV
     * -> Si la consulta devuelve un resultado mayor que 0 devolver "True" si no devolver "False"
     */
     /*
      * Autor: Cortaberría
      * Fecha: 04/07/2005
      * Se estaba comparando el oid recibido por parametro con el codigo del cliente
      */
    public Boolean cumpleZonificacion(DTODetalleMAV dtoDetalleMAV, Long lngOidCliente)
        throws MareException {
        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.cumpleZonificacion(DTODetalleMAV dtoDetalleMAV, Long lngOidCliente):Entrada");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        UtilidadesLog.debug("DAOProcesoEnvioAgregadosSolicitud.cumpleZonificacion()");

        try {
            bs = BelcorpService.getInstance();
        } catch(MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT COUNT(*) TOTAL_PRODUCTO ");
            query.append(" FROM MAE_CLIEN, ");
            query.append(" MAE_CLIEN_UNIDA_ADMIN, ");
            query.append(" ZON_TERRI_ADMIN, ");
            query.append(" ZON_SECCI, ");
            query.append(" ZON_ZONA, ");
            query.append(" ZON_REGIO, ");
            query.append(" ZON_SUB_GEREN_VENTA ");
            //query.append(" WHERE MAE_CLIEN.OID_CLIE = MAE_CLIEN_UNIDA_ADMIN.OID_CLIE_UNID_ADMI ");
            // Modificado por ssantana, 1/9/2005
            query.append(" WHERE mae_clien.oid_clie = mae_clien_unida_admin.CLIE_OID_CLIE ");            
            // Fin modificacion ssantana, 1/9/2005
            query.append(" AND ZON_TERRI_ADMIN.OID_TERR_ADMI = MAE_CLIEN_UNIDA_ADMIN.ZTAD_OID_TERR_ADMI ");
            query.append(" AND ZON_TERRI_ADMIN.ZSCC_OID_SECC = ZON_SECCI.OID_SECC ");
            query.append(" AND ZON_ZONA.OID_ZONA = ZON_SECCI.ZZON_OID_ZONA ");
            query.append(" AND ZON_REGIO.OID_REGI = ZON_ZONA.ZORG_OID_REGI ");
            query.append(" AND ZON_SUB_GEREN_VENTA.OID_SUBG_VENT = ZON_REGIO.ZSGV_OID_SUBG_VENT ");

            String sgv = this.includeIN("ZON_SUB_GEREN_VENTA.OID_SUBG_VENT", dtoDetalleMAV.getSubgerencias());
            String regi = this.includeIN("ZON_REGIO.OID_REGI", dtoDetalleMAV.getRegiones());
            String zonas = this.includeIN("ZON_ZONA.OID_ZONA", dtoDetalleMAV.getZonas());

            if(((sgv != null) && (sgv.length() > 0)) && ((regi != null) && (regi.length() > 0))
                && ((zonas != null) && (zonas.length() > 0)))
                query.append(" and (" + sgv + " or " + regi + " or " + zonas + ")");
            else {
                if(((sgv != null) && (sgv.length() > 0)) && ((regi != null) && (regi.length() > 0)))
                    query.append(" and (" + sgv + " or " + regi + ")");
                else {
                    if(((sgv != null) && (sgv.length() > 0)) && ((zonas != null) && (zonas.length() > 0)))
                        query.append(" and (" + sgv + " or " + zonas + ")");
                    else {
                        if(((regi != null) && (regi.length() > 0)) && ((zonas != null) && (zonas.length() > 0)))
                            query.append(" and (" + regi + " or " + zonas + ")");
                        else {
                            if((sgv != null) && (sgv.length() > 0))
                                query.append(" and (" + sgv + ")");

                            if((regi != null) && (regi.length() > 0))
                                query.append(" and (" + regi + ")");

                            if((zonas != null) && (zonas.length() > 0))
                                query.append(" and (" + zonas + ")");
                        }
                    }
                }
            }

            //query.append(" AND MAE_CLIEN.COD_CLIE = " + lngOidCliente);
            query.append(" AND MAE_CLIEN.OID_CLIE = " + lngOidCliente);
            

            es.indra.mare.common.mii.services.jdbcservice.RecordSet rs;

            rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet)bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
            bs = null;

            if(((BigDecimal)rs.getValueAt(0, "TOTAL_PRODUCTO")).intValue() > 0) {
               UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.cumpleZonificacion(DTODetalleMAV dtoDetalleMAV, Long lngOidCliente):Salida");
               return new Boolean(true);
            }

            UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.cumpleZonificacion(DTODetalleMAV dtoDetalleMAV, Long lngOidCliente):Salida");
            return new Boolean(false);
        } catch(Exception e) {
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }

    private String includeIN(String tabla, Long[] oids) {
        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.includeIN(String tabla, Long[] oids):Entrada");
        Long[] aux = oids;
        StringBuffer aux2 = new StringBuffer();

        if(aux != null) {
            int canti = aux.length - 1;

            if(canti > -1) {
                aux2.append(tabla + " in (");

                for(int i = 0; i < canti; i++)
                    aux2.append(aux[i] + ", ");

                aux2.append(aux[canti] + ")");
            }
        }

        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.includeIN(String tabla, Long[] oids):Salida");
        return aux2.toString();
    }

    
    public BigDecimal obtenerUltimaPosicion(Long cabecera) 
        throws MareException { 
        UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.obtenerUltimaPosicion(Long cabecera):Entrada");
        BelcorpService bs; 
        StringBuffer query = new StringBuffer(); 

        try { 
            bs = BelcorpService.getInstance(); 
        } catch(MareException e) { 
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE)); 
        } 

        try { 
            query.append( 
                " select max (cod_posi) from ped_solic_posic p where p.SOCA_OID_SOLI_CABE = "+cabecera); 

            es.indra.mare.common.mii.services.jdbcservice.RecordSet rs; 

            rs = bs.dbService.executeStaticQuery(query.toString()); 
            bs = null; 
            if (rs == null || rs.getValueAt(0,0) == null)  {
                UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.obtenerUltimaPosicion(Long cabecera):Salida");
                return null; 
            }
            UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.obtenerUltimaPosicion(Long cabecera):Salida");
            return (BigDecimal)rs.getValueAt(0,0); 
        } catch(Exception e) { 
            UtilidadesLog.error(e);
            if(e instanceof MareException) { 
                throw (MareException)e; 
            } else { 
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS)); 
            } 
        } 
    }
    
    
  /**
   * @author: ssantana, 20/7/2005 
   * @throws java.lang.Exception
   * @return String
   * @param Object[] array
   */
    private String armaClausulaIN(Object[] array) throws Exception {
      /*
       *  A partir del Array[] de entrada,
       *   - Si está vacío o es NULL, retoran NULL
       *   - Si no, retorna una cadena con formato "IN (a,b,c,d,...)"
       *     donde "a", "b", etc., son los elementos del Array[], 
       *     convertidos a String. 
       */
       
       UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.armaClausulaIN(Object[] array):Entrada");
       String sCadena = null;
       
       if (array != null && array.length > 0) {
          StringBuffer sBuffer = new StringBuffer("");
          sBuffer.append(" IN (");
          
          for ( int i = 0; i < array.length; i++)
          {
              if ( i != 0 )
                sBuffer.append(",");
 
              Object o = array[i];               
              sBuffer.append( o.toString() );
          }
          sBuffer.append(" ) ");
          
          sCadena = sBuffer.toString();
       }
      
       UtilidadesLog.debug("Cadena a retornar: " + sCadena);
       UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.armaClausulaIN(Object[] array):Salida");
       return sCadena;
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
     UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.truncaFecha(java.sql.Date fechaOrigen, String formato):Entrada");
     SimpleDateFormat simpleDate = new SimpleDateFormat(formato);
     String sFechaFormateada = simpleDate.format(fechaOrigen);
     UtilidadesLog.debug("sFechaFormateada: " + sFechaFormateada);
     UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.truncaFecha(java.sql.Date fechaOrigen, String formato):Salida");
     
     return sFechaFormateada;
     
  }
  
  
  public Boolean chequeaExistenciaEnvioMAV(BigDecimal bigOidDetalleMAV, Long oidCliente)
                                        throws MareException {
      UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.chequeaExistenciaEnvioMAV():Entrada");
      StringBuffer sqlQuery = new StringBuffer("");
      Boolean bRetorno = Boolean.FALSE;
      
      sqlQuery.append(" SELECT COUNT (mav_envio.oid_envi) ");
      sqlQuery.append(" FROM mav_envio ");
      sqlQuery.append(" WHERE mav_envio.denv_oid_deta_mav = " + 
                                                    bigOidDetalleMAV.toString());
      sqlQuery.append(" AND mav_envio.clie_oid_clie = " + oidCliente);
      
      
      BelcorpService bs = BelcorpService.getInstance();
      try {
          RecordSet rBuffer = bs.dbService.executeStaticQuery(sqlQuery.toString());
          UtilidadesLog.debug("rRetorno: " + rBuffer);
          /* Obtengo la cant. de tuplas encontradas. */ 
          
          BigDecimal cantRegistros = (BigDecimal) rBuffer.getValueAt(0,0);
          if (cantRegistros.longValue() > 0) {bRetorno = Boolean.TRUE;}
          
      } catch (Exception ex) {
          UtilidadesLog.error(ex);
          ex.printStackTrace();
      }
      
      UtilidadesLog.info("DAOProcesoEnvioAgregadosSolicitud.chequeaExistenciaEnvioMAV():Salida");
      return bRetorno;
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
         UtilidadesLog.debug("sFechaIni: " + sFechaIni ); 
         UtilidadesLog.debug("sFechaFin: " + sFechaFin ); 
         UtilidadesLog.debug("sAnyoIni: " + sAnyoIni ); 
         UtilidadesLog.debug("sAnyoFin: " + sAnyoFin ); 
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
 
    // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010 
    private String obtenerListaAniversario(String aniversario)  {
        StringBuffer resultado = new StringBuffer("(");
        
        int posicion = aniversario.indexOf("-");
        if(posicion > 0) {
            int numeroInicio = Integer.parseInt(aniversario.substring(0, posicion));
            int numeroFinal = Integer.parseInt(aniversario.substring(posicion + 1));
            
            for(int i=numeroInicio; i<=numeroFinal;i++) {
                if(i==numeroInicio)
                    resultado.append(i);
                else {   
                    resultado.append(",");
                    resultado.append(i);
                }    
            }
        } else 
            resultado.append(aniversario);
        
        resultado = resultado.append(")");
        
        return resultado.toString();
    }
                                       
}