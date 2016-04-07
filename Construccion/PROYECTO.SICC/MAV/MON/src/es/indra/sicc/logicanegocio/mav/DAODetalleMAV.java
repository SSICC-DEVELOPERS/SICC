package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.mav.DTOCampaniaEstimadosBP;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocal;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.rec.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.ejb.EJBException;

import javax.persistence.NoResultException;


public class DAODetalleMAV {
    public DAODetalleMAV() {}

    public RecordSet obtieneDetallesAPT(Long actividad, Long periodo, Long tipoCliente, Long oidPagina, Integer tamanioPagina,
        Long idioma, String codigoSAP, BigDecimal unidades) throws MareException 
    {
        UtilidadesLog.info("DAODetalleMAV.obtieneDetallesAPT(Long actividad, Long periodo, Long tipoCliente, Long oidPagina, Integer tamanioPagina, Long idioma):Entrada");
        RecordSet rs = new RecordSet();
        //StringBuffer query = new StringBuffer();

        BelcorpService belcorpService = null;

        UtilidadesLog.debug("---- obtieneDetallesAPT ----- ");
        String queryPrincipal = this.armaQueryPrincipal(actividad, periodo, tipoCliente, idioma, codigoSAP, unidades);
        DTOSiccPaginacion dtoPag = new DTOSiccPaginacion();
        dtoPag.setTamanioPagina(tamanioPagina);
        dtoPag.setIndicadorSituacion(new Long(oidPagina.intValue()) );
        queryPrincipal = UtilidadesPaginacion.armarQueryPaginacion(queryPrincipal, dtoPag);

        belcorpService = null;

        // Ejecuta la query Principal
        UtilidadesLog.debug("Ejecuta la query Principal");
        try {
            belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery(queryPrincipal.toString());
            UtilidadesLog.debug("rs: " + rs.toString());
        } catch(MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if (!rs.esVacio()) 
        {
            // Si no es vacío, obtiene las descripcion de los 4 campos con relacion
            // m:n y las concatena.
            
            // Obtiene las queries secundarias.
            UtilidadesLog.debug("Obtiene las queries secundarias");
            Long[] oids = this.obtieneOids(rs);
            String subtipo = this.armaQuerySubtipo(oids, idioma);
            String acceso = this.armaQueryAcceso(oids, idioma);
            String subacceso = this.armaQuerySubacceso(oids, idioma);

            // Ejecuta las queries secundarias
            UtilidadesLog.debug("Ejecuta las queries secundarias");
            try {
                belcorpService = BelcorpService.getInstance();
                RecordSet rSubtipo = belcorpService.dbService.executeStaticQuery(subtipo);
                RecordSet rAcceso = belcorpService.dbService.executeStaticQuery(acceso);            
                RecordSet rSubacceso = belcorpService.dbService.executeStaticQuery(subacceso);

                UtilidadesLog.debug("rSubtipo: " + rSubtipo.toString());
                UtilidadesLog.debug("rAcceso: " + rAcceso.toString());
                UtilidadesLog.debug("rSubacceso: " + rSubacceso.toString());

                rSubtipo = this.concatena(rSubtipo);
                rAcceso = this.concatena(rAcceso);            
                rSubacceso = this.concatena(rSubacceso);       

                UtilidadesLog.debug("rSubtipo: " + rSubtipo.toString());
                UtilidadesLog.debug("rAcceso: " + rAcceso.toString());
                UtilidadesLog.debug("rSubacceso: " + rSubacceso.toString());

                // Ahora que tenemos todos los RecordSets con sus valores concatenados, por ID,
                // con respecto al RecordSet principal,
                // procedemos a poner los valores correspondientes en el recordset principal,
                // por Oid.

                rs = this.agregaValoresConcatenados(rs, rSubtipo, 7);
                rs = this.agregaValoresConcatenados(rs, rAcceso, 10);
                rs = this.agregaValoresConcatenados(rs, rSubacceso, 11);                
                
            } catch(MareException me) {
                UtilidadesLog.error(me);
                throw me;
            } catch(Exception e) {
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

            }    
        } 
        
        UtilidadesLog.info("DAODetalleMAV.obtieneDetallesAPT(Long actividad, Long periodo, Long tipoCliente, Long oidPagina, Integer tamanioPagina, Long idioma):Salida");
        return rs;
    }

    public RecordSet obtenerRegionesGerente(Long oidCliente)
        throws MareException {
        UtilidadesLog.info("DAODetalleMAV.obtenerRegionesGerente(Long oidCliente):Entrada");
        RecordSet rs = new RecordSet();

        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

            query.append(" select OID_REGI from ZON_REGIO ");
            query.append(" where CLIE_OID_CLIE = " + oidCliente);

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAODetalleMAV.obtenerRegionesGerente(Long oidCliente):Salida");
        return rs;
    }

    public RecordSet obtenerZonasGerente(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAODetalleMAV.obtenerZonasGerente(Long oidCliente):Entrada");    
        RecordSet rs = new RecordSet();

        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

            query.append(" select OID_ZONA from ZON_ZONA ");
            query.append(" where CLIE_OID_CLIE = " + oidCliente);

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAODetalleMAV.obtenerZonasGerente(Long oidCliente):Salida");    
        return rs;
    }

    public DTOSalida cargarCampaniasSimularEstimadosBP(DTOSiccPaginacion dto)
        throws MareException {
        /* Historial de cambios
         * - Agregado por ssantana, 15/6/2005
         *   Inc. 18071 - Se retorna oidPeriodo también.
         *              - Ahora filtra por Tipo Estado Proceso del DetalleMAV
         * 
         * - SiCC 20070221 - Rafael Romero - 19/06/2007
         *   Visualizar envios aunque sea de la campaña vigente
         */
        
        UtilidadesLog.info("DAODetalleMAV.cargarCampaniasSimularEstimadosBP(DTOSiccPaginacion dto):Entrada");            
        RecordSet rs = new RecordSet();

        try {
            //BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();
            
            query.append("SELECT ROWNUM AS OID, resultado.* ");
            query.append("  FROM (SELECT   i1.val_i18n pais, des_marc, i2.val_i18n canal, ");
            query.append("                 cra1.val_nomb_peri, i3.val_i18n actividad, ");
            query.append("                 i4.val_i18n tip_cli, seg_marca.oid_marc, ticl_oid_tipo_clie, ");
            query.append("                 acti_oid_acti, cra1.oid_peri ");
            query.append("            FROM mav_detal_mav, ");
            query.append("                 cra_perio cra1, ");
            query.append("                 cra_perio cra2, ");
            query.append("                 seg_marca, ");
            query.append("                 v_gen_i18n_sicc i1, ");
            query.append("                 v_gen_i18n_sicc i2, ");
            query.append("                 v_gen_i18n_sicc i3, ");
            query.append("                 v_gen_i18n_sicc i4 ");
            query.append("           WHERE cra1.pais_oid_pais = "+dto.getOidPais()+" ");
            query.append("             AND mav_detal_mav.perd_oid_peri = cra1.oid_peri ");
            query.append("             AND cra1.marc_oid_marc = seg_marca.oid_marc ");
            query.append("             AND i1.attr_enti = 'SEG_PAIS' ");
            query.append("             AND i1.attr_num_atri = 1 ");
            query.append("             AND i1.idio_oid_idio = "+dto.getOidIdioma()+" ");
            query.append("             AND i1.val_oid = cra1.pais_oid_pais ");
            query.append("             AND i2.attr_enti = 'SEG_CANAL' ");
            query.append("             AND i2.attr_num_atri = 1 ");
            query.append("             AND i2.idio_oid_idio = "+dto.getOidIdioma()+" ");
            query.append("             AND i2.val_oid = cra1.cana_oid_cana ");
            query.append("             AND i3.attr_enti = 'MAV_ACTIV' ");
            query.append("             AND i3.attr_num_atri = 1 ");
            query.append("             AND i3.idio_oid_idio = "+dto.getOidIdioma()+" ");
            query.append("             AND i3.val_oid = acti_oid_acti ");
            query.append("             AND i4.attr_enti = 'MAE_TIPO_CLIEN' ");
            query.append("             AND i4.attr_num_atri = 1 ");
            query.append("             AND i4.idio_oid_idio = "+dto.getOidIdioma()+" ");
            query.append("             AND i4.val_oid = ticl_oid_tipo_clie ");
            query.append("             AND cra2.pais_oid_pais = cra1.pais_oid_pais ");
            query.append("             AND cra2.marc_oid_marc = cra1.marc_oid_marc ");
            query.append("             AND cra2.cana_oid_cana = cra1.cana_oid_cana ");
            query.append("             AND cra2.fec_inic <= TO_DATE('"+ (new SimpleDateFormat("ddMMyyyy")).format(new java.util.Date()) +"','DDMMYYYY') ");
            query.append("             AND cra2.fec_fina >= TO_DATE('"+ (new SimpleDateFormat("ddMMyyyy")).format(new java.util.Date()) +"','DDMMYYYY') ");
            query.append("             AND cra1.fec_inic >= cra2.fec_inic ");
            query.append("             AND mav_detal_mav.tepr_oid_tipo_esta_proc = "+ConstantesMAV.T_ESTAD_PROCESO_COMPLETADO+" ");
            query.append("        GROUP BY i1.val_i18n, ");
            query.append("                 des_marc, ");
            query.append("                 i2.val_i18n, ");
            query.append("                 cra1.val_nomb_peri, ");
            query.append("                 i3.val_i18n, ");
            query.append("                 i4.val_i18n, ");
            query.append("                 seg_marca.oid_marc, ");
            query.append("                 ticl_oid_tipo_clie, ");
            query.append("                 acti_oid_acti, ");
            query.append("                 cra1.oid_peri) resultado ");



            rs = getBelcorpService().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.debug(rs);
        if(rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAODetalleMAV.cargarCampaniasSimularEstimadosBP(DTOSiccPaginacion dto):Salida");
        return new DTOSalida(rs);
    }

    public DTOSalida cargarDetalleSimularEstimadosBP(DTOCampaniaEstimadosBP dto)
        throws MareException {
        UtilidadesLog.info("DAODetalleMAV.cargarDetalleSimularEstimadosBP(DTOCampaniaEstimadosBP dto):Entrada");
        ParametrizacionMAVLocal paramL = null;
        RecordSet rs = new RecordSet();

        try {
            ParametrizacionMAVLocalHome paramLH = new ParametrizacionMAVLocalHome();
            paramL = paramLH.findByUK(dto.getOidPais());
        } catch(NoResultException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        Long almacen = paramL.getOidAlmacenes();
        UtilidadesLog.debug("*************** almacen " + almacen);

        StringBuffer query = new StringBuffer(" ");

        // Modificado por ssantana, 3/8/2005, inc. BELC300015618,
        //  por quita de campo MAV_DETAL_MAV.MAFA_OID_MATR_FACT
        /*query.append(
           " SELECT detal.OID_DETA_MAV , pro.COD_SAP, det.VAL_CODI_VENT,  detal.PROD_OID_PROD, inte1.VAL_I18N, '' subtipo , ");*/
        query.append(
           " SELECT detal.OID_DETA_MAV , pro.COD_SAP, '' as CODIGO_VENTA_VACIO,  detal.PROD_OID_PROD, inte1.VAL_I18N, '' subtipo , ");
        query.append(" detal.TCCL_OID_TIPO_CLAS, inte2.VAL_I18N, detal.CLAS_OID_CLAS, inte3.VAL_I18N, ");
        query.append(" decode(nvl(detal.NUM_UNID_CLIE, 0), 0, nvl(detal.NUM_UNID_ESTI,0), detal.NUM_UNID_CLIE) prome , ");
        query.append(" decode(nvl(detal.NUM_UNID_TOTA, 0), 0, nvl(detal.NUM_UNID_TOTA_ESTI,0), detal.NUM_UNID_TOTA) tota, ");
        query.append(" nvl(detal.NUM_UNID_TOTA,0), sto.VAL_SALD, sub.DES_SUBC, '' val_cond, detal.SCAS_OID_SUBC, ");
        query.append(
            " detal.VAL_EDAD_DESD, detal.VAL_EDAD_HAST,detal.NUM_ANIV, detal.VAL_MONT, detal.NUM_UNID_ESTI, detal.TICL_OID_TIPO_CLIE, '' oidSubtipo ");
        query.append(" FROM MAE_PRODU pro, MAV_DETAL_MAV detal, V_GEN_I18N_SICC inte1 ,V_GEN_I18N_SICC inte2, ");
        query.append(" MAV_SUBCR_ASIGN sub , ");
        /*query.append(
            " V_GEN_I18N_SICC inte3, BEL_STOCK sto, PRE_MATRI_FACTU mat, PRE_OFERT_DETAL det , CRA_PERIO per, BEL_ESTAD_MERCA estad ");*/
        query.append(
            " V_GEN_I18N_SICC inte3, BEL_STOCK sto, CRA_PERIO per, BEL_ESTAD_MERCA estad ");            
        query.append(" where inte1.ATTR_NUM_ATRI=1 and inte1.IDIO_OID_IDIO= " + dto.getOidIdioma());
        query.append(" and inte1.ATTR_ENTI='MAE_PRODU' and inte1.VAL_OID=detal.PROD_OID_PROD and ");
        query.append(" inte2.ATTR_NUM_ATRI(+) = 1 and inte2.IDIO_OID_IDIO(+) = " + dto.getOidIdioma());
        query.append(" and inte2.ATTR_ENTI(+) ='MAE_TIPO_CLASI_CLIEN' and ");
        query.append(" inte2.VAL_OID(+) = detal.TCCL_OID_TIPO_CLAS ");
        query.append(" and inte3.ATTR_NUM_ATRI(+) = 1 and ");
        query.append(" inte3.IDIO_OID_IDIO(+)= " + dto.getOidIdioma());
        query.append(" and inte3.ATTR_ENTI(+) = 'MAE_CLASI' and inte3.VAL_OID(+) = detal.CLAS_OID_CLAS and ");
        query.append(" detal.PROD_OID_PROD=pro.OID_PROD and pro.OID_PROD = sto.PROD_OID_PROD and ");
        query.append(" per.OID_PERI=detal.PERD_OID_PERI and ");
        query.append(" sub.OID_SUBC=detal.SCAS_OID_SUBC and ");
        query.append(" per.MARC_OID_MARC= " + dto.getMarca() + " and ");
        query.append(" per.PAIS_OID_PAIS= " + dto.getPais() + " and ");
        query.append(" detal.TICL_OID_TIPO_CLIE = " + dto.getTipoCliente() + " and ");
        query.append(" detal.ACTI_OID_ACTI= " + dto.getActividad() + " and ");
        query.append(" sto.ALMC_OID_ALMA= " + almacen + " and ");
        // Agregado por ssantana, 15/6/2005
        // Inc. 18071
        query.append(" detal.PERD_OID_PERI = " + dto.getPeriodo() + " and ");
        query.append(" detal.TEPR_OID_TIPO_ESTA_proc = " + ConstantesMAV.T_ESTAD_PROCESO_COMPLETADO  + " and ");
        // Fin Agregado ssantana x inc. 18071

        //incidencia 8837 gpm
        //		query.append(" and sto.ESME_OID_ESTA_MERC=" + Constantes.OID_ESTADO_LIBRE_DISPOSICION );
        // 9159
        query.append(" sto.ESME_OID_ESTA_MERC = estad.OID_ESTA_MERC and ");
        query.append(" estad.COD_ESTA = '" + ConstantesBEL.COD_EST_LIBRE_DISP + "' and ");
        query.append(" estad.PAIS_OID_PAIS = " + dto.getPais());
        // Fin Modificacion por ssantana, 3/8/2005, inc. BELC300015618,
        //  por quita de campo MAV_DETAL_MAV.MAFA_OID_MATR_FACT

        UtilidadesLog.debug("********** Primera query " + query.toString());
        
        

        try {
            BelcorpService bs = getBelcorpService();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        BigDecimal subacceso = null;
        Long subac = null;
        RecordSet reg = new RecordSet();
        StringBuffer concatena = null;
        StringBuffer concatenaOIDS = null;
        String valor = null;

        for(int i = 0; i < rs.getRowCount(); i++) {
            query = new StringBuffer("");
            UtilidadesLog.debug("rs.getValueAt(i,0)" + rs.getValueAt(i, 0).toString());

            query.append(" select i.VAL_I18N, i.VAL_OID ");
            query.append(" from MAV_DETAL_MAV det, MAV_SUBTI_CLIEN_DETAL sub, MAE_SUBTI_CLIEN cli, V_GEN_I18N_SICC i ");
            query.append(" where ");
            query.append(" cli.OID_SUBT_CLIE=sub.SBTI_OID_SUBT_CLIE and ");
            query.append(" sub.DENV_OID_DETA_MAV =det.OID_DETA_MAV and ");
            query.append(" cli.OID_SUBT_CLIE = i.VAL_OID and ");
            query.append(" i.ATTR_ENTI='MAE_SUBTI_CLIEN' and ");
            query.append(" i.ATTR_NUM_ATRI=1 and ");
            query.append(" i.IDIO_OID_IDIO= " + dto.getOidIdioma() + " and ");
            query.append(" det.OID_DETA_MAV =" + rs.getValueAt(i, 0).toString());

            UtilidadesLog.debug("********** Segunda query " + query.toString());

            try {
                BelcorpService bs = getBelcorpService();
                reg = bs.dbService.executeStaticQuery(query.toString());
            } catch(Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            concatena = new StringBuffer("");
            concatenaOIDS = new StringBuffer("");

            for(int j = 0; j < reg.getRowCount(); j++) {
                UtilidadesLog.debug("************** reg.getValueAt(j,0)" + reg.getValueAt(j, 0).toString());

                if(j < 1) {
                    concatena = new StringBuffer(reg.getValueAt(j, 0).toString());
                    concatenaOIDS = new StringBuffer(reg.getValueAt(j, 1).toString());
                } else {
                    concatena.append(" / " + reg.getValueAt(j, 0).toString());
                    concatenaOIDS.append("/" + reg.getValueAt(j, 1).toString());
                }

                UtilidadesLog.debug("*************** contena " + concatena);
            }

            rs.setValueAt(concatena, i, 5); //--
            rs.setValueAt(concatenaOIDS, i, 23); //--
            subacceso = (BigDecimal)rs.getValueAt(i, 16); //--
            UtilidadesLog.debug("****************** subacceso " + subacceso);
            subac = new Long(subacceso.longValue());

            // Modificado por ssantana, 10/3/2005
            // ----------------------------------
            // 
            // Se cambian los casteos a String por casteos a BigDecimal.
            /*if(ConstantesMAV.SUBCRI_EDAD.longValue() == subac.longValue())
                valor = (String)rs.getValueAt(i, 17) + " a " + (String)rs.getValueAt(i, 18);
            else {
                if(ConstantesMAV.SUBCRI_ANIVERSARIO.longValue() == subac.longValue())
                    valor = (String)rs.getValueAt(i, 19);
                else {
                    if((subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO.longValue())
                        || (subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_MARCA.longValue())
                        || (subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_U_NEGOCIO.longValue())
                        || (subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_NEGOCIO.longValue())
                        || (subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_CATALOGO.longValue()))
                        valor = (String)rs.getValueAt(i, 20);
                    else
                        valor = null;
                }
            }*/
            
            if(ConstantesMAV.SUBCRI_EDAD.longValue() == subac.longValue())
            {
                UtilidadesLog.debug("Edad");
                BigDecimal bigBuffer1 = (BigDecimal)rs.getValueAt(i, 17); //--
                BigDecimal bigBuffer2 = (BigDecimal)rs.getValueAt(i, 18); //--
                valor = bigBuffer1.toString() + " a " + bigBuffer2.toString();
            }
            else 
            {
                if(ConstantesMAV.SUBCRI_ANIVERSARIO.longValue() == subac.longValue())
                {
                    UtilidadesLog.debug("Aniversario");
                    BigDecimal bigBuffer = (BigDecimal) rs.getValueAt(i, 19); //--
                    valor = bigBuffer.toString();
                } else {
                    if((subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO.longValue())
                        || (subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_MARCA.longValue())
                        || (subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_U_NEGOCIO.longValue())
                        || (subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_NEGOCIO.longValue())
                        || (subac.longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_CATALOGO.longValue()))
                    {
                        UtilidadesLog.debug(" Pedido supera a Monto, Monto Marca, Monto U Negocio, Monto Negocio o Catalogo");
                        BigDecimal bigBuffer = (BigDecimal)rs.getValueAt(i, 20); //--
                        valor = bigBuffer.toString();
                    }
                    else
                        valor = null;
                }
            }            

            UtilidadesLog.debug("**************** valor " + valor);
            rs.setValueAt(valor, i, 15); //--
        }

        DTOSalida sal = new DTOSalida();
        sal.setResultado(rs);
        UtilidadesLog.debug("*********************** ResultSet Final: " + rs);
        UtilidadesLog.info("DAODetalleMAV.cargarDetalleSimularEstimadosBP(DTOCampaniaEstimadosBP dto):Salida");
        return sal;
    }

    public Long consultorasGerenteRegionPorSubcriterio(DTODetalleMAV dto, Long oidCliente, Long periodo)
        throws MareException {
        RecordSet rs = new RecordSet();
        UtilidadesLog.info("DAODetalleMAV.consultorasGerenteRegionPorSubcriterio(DTODetalleMAV dto, Long oidCliente, Long periodo):Entrada");
        
        // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010                
        boolean aplicarUnidadesxRegionZona = false;
        if(dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_FORMULA) {
            if(dto.getUnidadesRegionZona()!=null) {
                Iterator it = dto.getUnidadesRegionZona().keySet().iterator();
                String claveUA = (String)it.next();
                Long valorUA = (Long)dto.getUnidadesRegionZona().get(claveUA);
                
                if(valorUA!=null)    
                    aplicarUnidadesxRegionZona = true;
            }
        }
        UtilidadesLog.debug("aplicarUnidadesxRegionZona :" + aplicarUnidadesxRegionZona);

        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

            String tabla = "";
            String campo = "";
            
            if(dto.getCriterioAsignacion().intValue() == 
                                        ConstantesMAV.CRITERIO_ASIGNA_VARIABLES) {
                UtilidadesLog.debug("Es Criterio Asignacion Variables");            
                Long periodoFiltro = null;
                Integer campanyaEvaluacion = dto.getCampagnaEvaluacion();
                if((campanyaEvaluacion != null) && (campanyaEvaluacion.intValue() < 0)) {
                    tabla = "INT_FUENT_VENTAS_REAL";
                    Long oidPeriodoAnterior = this.obtieneOidPeriodoAnteriorPorCampanya( periodo,
                                                                                    dto.getCampagnaEvaluacion(),
                                                                                    dto.getCanal(),
                                                                                    dto.getMarca(),
                                                                                    dto.getOidPais() );
                                                                                    
                    periodoFiltro = oidPeriodoAnterior; 
                } else {
                   tabla = "INT_FUENT_VENTA_PREVI_SAP";
                   if( (campanyaEvaluacion != null) && (campanyaEvaluacion.intValue() > 0)) {
                      Long oidPeriodoPosterior = this.obtieneOidPeriodoPosteriorPorCampanya(periodo,
                                                                                  dto.getCampagnaEvaluacion(),
                                                                                  dto.getCanal(),
                                                                                  dto.getMarca(),
                                                                                  dto.getOidPais());
                      periodoFiltro = oidPeriodoPosterior;
                   } else {
                      periodoFiltro = periodo;
                   }
                   
                }

                if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_ACTIVAS_FINALES.longValue())
                    campo = "NUM_ACTI_FINA";
                else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_INGRESOS.longValue())
                    campo = "NUM_INGR";
                else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_REINGRESOS.longValue())
                    campo = "NUM_REIN";
                else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_EGRESOS.longValue())
                    campo = "NUM_EGRE";
                else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_NUMERO_PEDIDOS.longValue())
                    campo = "NUM_PEDI";
                    
                /* Inc. 16051, 12/4/2005
                 * (3.1) Si el campo es "NUM_PEDI" y tabla es "INT_FUENTE_VENTAS_REAL"
                 *   -> Cambiar el valor de tabla de donde se obtiene este campo, tabla = "INT_FUENTE_VENTAS_REAL_VACUM"
                 * (3.1) Fin Si*/
                 
                if (campo.equals("NUM_PEDI") && tabla.equals("INT_FUENT_VENTAS_REAL") )
                    tabla = "INT_FUENT_VENTA_REAL_VACUM";

                /*
                -> Hacer consulta JDBC sobre la tabla contenida en variable "tabla" para obtener la sumatoria del campo contenido en la variable "campo" para los siguientes criterios:
                -> Cruzar la tabla contenida en la variable "tabla" con la tabla ZON_REGIO tal que ZON_REGIO.OID_REGIO = tabla.OID_REGIO
                -> ZON_REGIO.CLIE_OID_CLIE = oidCliente
                -> ZON_REGIO.OID_REGIO = una de las regiones contenidas en dto.regiones
                -> tabla.PERI_OID_PERIO = periodo
                -> De la consulta anterior sólo obtendremos un registro con la sumatoria de consultoras correspondiente al campo contenido en la variable "campo"
                -> Devolver la cifra obtenida encapsulada en un Long
                */
                query.append(" select SUM(" + campo + ") from " + tabla + ", ZON_REGIO Z ");
                query.append(" where ");
                query.append(" Z.OID_REGI = " + tabla + ".ZORG_OID_REGI ");
                query.append(" and Z.CLIE_OID_CLIE = " + oidCliente);

                Long[] regiones = dto.getRegiones();

                if(regiones != null) {
                    int canti = regiones.length - 1;

                    if(canti > -1) {
                        query.append(" and Z.OID_REGI in (");

                        for(int i = 0; i < canti; i++)
                            query.append(regiones[i] + ", ");

                        query.append(regiones[canti] + ")");
                    }
                }

                query.append(" and " + tabla + ".PERD_OID_PERI = " + periodoFiltro);                
                
                UtilidadesLog.debug(query.toString());
            } else {
                if(dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_FORMULA) {
                    UtilidadesLog.debug("Es Criterio Asignacion Formula");
                    
                    if((dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_ACTIVAS_FINALES_FORMULA.longValue())
                        || (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_INGRESOS_FORMULA.longValue())
                        || (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_REINGRESOS_FORMULA.longValue())
                        || (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_EGRESOS_FORMULA.longValue())
                        || (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_NUMERO_PEDIDOS_FORMULA.longValue())) {
                        
                        Long periodoFiltro = null;
                        Integer campanyaEvaluacion = dto.getCampagnaEvaluacion();
                        if((campanyaEvaluacion != null)  &&
                                          (campanyaEvaluacion.intValue() < 0)) {
                           tabla = "INT_FUENT_VENTAS_REAL";
                           Long oidPeriodoAnterior = this.obtieneOidPeriodoAnteriorPorCampanya( periodo,
                                                                                      dto.getCampagnaEvaluacion(),
                                                                                      dto.getCanal(),
                                                                                      dto.getMarca(),
                                                                                      dto.getOidPais() );
                                                                                    
                           periodoFiltro = oidPeriodoAnterior;
                            
                        } else {
                           tabla = "INT_FUENT_VENTA_PREVI_SAP";                          
                           
                           if ( (campanyaEvaluacion != null) &&
                                         ( campanyaEvaluacion.intValue() > 0 )) {
                              Long oidPeriodoPosterior = this.obtieneOidPeriodoPosteriorPorCampanya(periodo,
                                                                                      dto.getCampagnaEvaluacion(),
                                                                                      dto.getCanal(),
                                                                                      dto.getMarca(),
                                                                                      dto.getOidPais());
                              periodoFiltro= oidPeriodoPosterior;
                           } else {
                              periodoFiltro = periodo;
                           }
                           
                        }

                        // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010
                        if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_ACTIVAS_FINALES_FORMULA.longValue())
                            campo = "NUM_ACTI_FINA";
                        else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_INGRESOS_FORMULA.longValue())
                            campo = "NUM_INGR";
                        else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_REINGRESOS_FORMULA.longValue())
                            campo = "NUM_REIN";
                        else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_EGRESOS_FORMULA.longValue())
                            campo = "NUM_EGRE";
                        else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_NUMERO_PEDIDOS_FORMULA.longValue())
                            campo = "NUM_PEDI";
                            
                       /* Inc. 16051, 12/4/2005
                        * (3.1) Si el campo es "NUM_PEDI" y tabla es "INT_FUENTE_VENTAS_REAL"
                        *   -> Cambiar el valor de tabla de donde se obtiene este campo, tabla = "INT_FUENTE_VENTAS_REAL_VACUM"
                        * (3.1) Fin Si
                        */
                        if (campo.equals("NUM_PEDI") && tabla.equals("INT_FUENT_VENTAS_REAL") )
                          tabla = "INT_FUENT_VENTA_REAL_VACUM";
                            

                        /*
                        -> Hacer consulta JDBC sobre la tabla contenida en variable "tabla" para obtener la sumatoria del campo contenido en la variable "campo" para los siguientes criterios:
                        -> Cruzar la tabla contenida en la variable "tabla" con la tabla ZON_REGIO tal que ZON_REGIO.OID_REGIO = tabla.OID_REGIO
                        -> ZON_REGIO.CLIE_OID_CLIE = oidCliente
                        -> ZON_REGIO.OID_REGIO = una de las zonas contenidas en dto.zonas
                        -> tabla.PERI_OID_PERIO = periodo
                        -> De la consulta anterior sólo obtendremos un registro con la sumatoria de consultoras correspondiente al campo contenido en la variable "campo"
                        -> Devolver la cifra obtenida encapsulada en un Long */
                        
                        if(aplicarUnidadesxRegionZona)
                            query.append(" select Z.OID_REGI, SUM(" + campo + ") from " + tabla + ", ZON_REGIO Z ");
                        else
                            query.append(" select SUM(" + campo + ") from " + tabla + ", ZON_REGIO Z ");
                            
                        query.append(" where ");
                        query.append(" Z.OID_REGI = " + tabla + ".ZORG_OID_REGI ");
                        query.append(" and Z.CLIE_OID_CLIE = " + oidCliente);

                        Long[] regiones = dto.getRegiones();

                        if(regiones != null) {
                            int canti = regiones.length - 1;

                            if(canti > -1) {
                                query.append(" and Z.OID_REGI in (");

                                for(int i = 0; i < canti; i++)
                                    query.append(regiones[i] + ", ");

                                query.append(regiones[canti] + ")");
                            }
                        }

                        query.append(" and " + tabla + ".PERD_OID_PERI = " + periodoFiltro);
                        
                        if(aplicarUnidadesxRegionZona)
                            query.append(" GROUP BY Z.OID_REGI ");
                        
                        UtilidadesLog.debug(query.toString());
                    } else if (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_NUMERO_ZONAS.longValue())  {
                        // Agregado por ssantana, 29/7/2005, inc. 18058
                        
                        if(aplicarUnidadesxRegionZona)
                            query.append(" SELECT zon_regio.oid_regi, COUNT (zon_zona.oid_zona) ");
                        else
                            query.append(" SELECT COUNT (zon_zona.oid_zona) ");
                             
                        query.append(" FROM zon_zona, zon_regio ");
                        query.append(" WHERE zon_zona.zorg_oid_regi = zon_regio.oid_regi ");
                        query.append(" AND zon_zona.ind_acti = 1 ");
                        query.append(" AND zon_zona.ind_borr = 0 ");
                        query.append(" AND zon_regio.ind_acti = 1 ");
                        query.append(" AND zon_regio.ind_borr = 0 ");
                        query.append(" AND zon_regio.clie_oid_clie = " + oidCliente);
                        
                        // Agregado por ssantana, 24/10/2005, inc. DBLG2 665.
                        // Ahora filtra por las regiones del DetalleMAV. 
                        Long[] regiones = dto.getRegiones();

                        if(regiones != null) {
                            int canti = regiones.length - 1;

                            if(canti > -1) {
                                query.append(" and zon_regio.OID_REGI in (");

                                for(int i = 0; i < canti; i++) {
                                    query.append(regiones[i] + ", ");
                                }

                                query.append(regiones[canti] + ")");
                            }
                        }
                        
                        if(aplicarUnidadesxRegionZona)
                            query.append(" GROUP BY zon_regio.oid_regi ");
                        
                        UtilidadesLog.debug(query.toString());                        
                        // Fin agregado por ssantana, 24/10/2005, inc. DBLG2 665. 

                    } else if (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_TIPOLOGIA_CLIENTES.longValue() ){
                    
                        if(aplicarUnidadesxRegionZona)
                            query.append(" SELECT reg.OID_REGI, COUNT(DISTINCT adm.CLIE_OID_CLIE) ");
                        else
                            query.append(" SELECT COUNT(DISTINCT adm.CLIE_OID_CLIE) ");
                            
                         query.append("   FROM MAE_CLIEN_UNIDA_ADMIN adm, ");
                         query.append("        MAE_CLIEN_DATOS_ADICI cda, ");
                         query.append("        V_MAE_TIPIF_CLIEN tip, ");
                         query.append("        ZON_TERRI_ADMIN ter, ");
                         query.append("        ZON_SECCI sec, ");
                         query.append("        ZON_ZONA zon, ");
                         query.append("        ZON_REGIO reg ");
                         query.append(" WHERE tip.CLIE_OID_CLIE = adm.CLIE_OID_CLIE ");
                         query.append("   AND adm.IND_ACTI = 1 ");
                         
                         // sapaza -- PER-SiCC-2010-0699 -- 07/03/2011
                         query.append("   AND tip.CLIE_OID_CLIE = cda.CLIE_OID_CLIE ");
                         query.append("   AND cda.IND_ACTI = 1 ");
                         
                         query.append("   AND adm.ZTAD_OID_TERR_ADMI = ter.OID_TERR_ADMI ");
                         query.append("   AND ter.ZSCC_OID_SECC = sec.OID_SECC ");
                         query.append("   AND sec.ZZON_OID_ZONA = zon.OID_ZONA ");
                         query.append("   AND zon.ZORG_OID_REGI = reg.OID_REGI ");
                         
                         if (dto.getClasificacion() != null)
                             query.append(" and tip.CLAS_OID_CLAS = " + dto.getClasificacion());
                           
                         if (dto.getTipoClasificacion() != null)
                             query.append(" and tip.TCCL_OID_TIPO_CLASI = " + dto.getTipoClasificacion());

                         if (dto.getSubTipoCliente() != null)
                             query.append(" and tip.SBTI_OID_SUBT_CLIE = " + dto.getSubTipoCliente());

                         if (dto.getTipoClienteCriterio() != null)
                             query.append(" and tip.TICL_OID_TIPO_CLIE = " + dto.getTipoClienteCriterio());

                        query.append(" AND reg.CLIE_OID_CLIE = " + oidCliente);

                         Long[] regiones = dto.getRegiones();
                         if(regiones != null) {
                             int canti = regiones.length - 1;

                             if(canti > -1) {
                                 query.append(" and reg.OID_REGI in (");

                                 for(int i = 0; i < canti; i++) {
                                     query.append(regiones[i] + ", ");
                                 }

                                 query.append(regiones[canti] + ")");
                             }
                         }
                         
                        if(aplicarUnidadesxRegionZona)
                            query.append(" GROUP BY reg.OID_REGI ");
                         
                         UtilidadesLog.debug(query.toString());
                    } else {

                        /*
                        -> Hacer consulta JDBC sobre la tabla EDU_APTAS_CURSO y sumar el número de EDU_APTAS_CURSO.CLIE_OID_CLIE para los siguientes criterios:
                        -> Cruzar tabla EDU_APTAS_CURSO con la tabla EDU_MATRI_CURSO y esta a su vez con ZON_REGIO
                        -> ZON_REGIO.CLIE_OID_CLIE = oidCliente
                        -> EDU_MATRI_CURSO.ZORG_OID_REGI = una de las zonas contenidas en dto.zonas
                        */
                        query.append(" select COUNT(EDU_APTAS_CURSO.CLIE_OID_CLIE) from EDU_APTAS_CURSO, EDU_MATRI_CURSO, ZON_REGIO Z ");
                        query.append(" where ");
                        query.append(" MCUR_OID_CURS = OID_CURS ");
                        query.append(" and ZORG_OID_REGI = Z.OID_REGI ");
                        query.append(" and Z.CLIE_OID_CLIE = " + oidCliente);

                        Long[] regiones = dto.getRegiones();

                        if(regiones != null) {
                            int canti = regiones.length - 1;

                            if(canti > -1) {
                                query.append(" and Z.OID_REGI in (");

                                for(int i = 0; i < canti; i++)
                                    query.append(regiones[i] + ", ");

                                query.append(regiones[canti] + ")");
                            }
                        }

                        UtilidadesLog.debug(query.toString());
                    }
                }
            }

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.debug("rs: " + rs);

        // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010                
        if(!rs.esVacio()) {
            UtilidadesLog.info("DAODetalleMAV.consultorasGerenteRegionPorSubcriterio(DTODetalleMAV dto, Long oidCliente, Long periodo):Salida");
            
            if(aplicarUnidadesxRegionZona) {
                Long consultorasUnidades = new Long(0);
                for(int i=0; i<rs.getRowCount(); i++) {
                    String region = rs.getValueAt(i, 0).toString();
                    Long totalesConsultoras = new Long(rs.getValueAt(i, 1).toString());
                    Long unidades = (Long)dto.getUnidadesRegionZona().get("r"+region);
                    
                    if((unidades.longValue() == 0) && (dto.getUnidadesPorCliente() !=null))            
                      unidades = dto.getUnidadesPorCliente().longValue();
                          
                    Long totalFila = new Long(totalesConsultoras.longValue() * unidades.longValue());
                    consultorasUnidades = new Long(consultorasUnidades.longValue() + totalFila.longValue());
                }
                return consultorasUnidades;
                
            } else             
                if(rs.getValueAt(0, 0) != null) 
                    return new Long(rs.getValueAt(0, 0).toString());
                else    
                    return new Long(0);
        } else {
            UtilidadesLog.info("DAODetalleMAV.consultorasGerenteRegionPorSubcriterio(DTODetalleMAV dto, Long oidCliente, Long periodo):Salida");
            return new Long(0);
        }
    }
    
    private Long obtieneOidPerioCorpo(Long oidPerioCra) throws MareException
    {
        UtilidadesLog.info("DAODetalleMAV.obtieneOidPerioCorpo(Long oidPerioCra):Entrada");    
        BelcorpService belcorpService = BelcorpService.getInstance();
        Long oidRetorno = null;
        StringBuffer query = new StringBuffer("");

        query.append(" SELECT cra_perio.peri_oid_peri ");
        query.append(" FROM cra_perio ");
        query.append(" WHERE cra_perio.oid_peri = " + oidPerioCra);
        
        try 
        {
          RecordSet r = BelcorpService.getInstance().dbService.executeStaticQuery( query.toString() );
          if ( !r.esVacio() ) 
          { 
              BigDecimal bigOid = (BigDecimal) r.getValueAt(0,0);
              if (bigOid != null) 
                oidRetorno = new Long(bigOid.longValue());
          }
              
        } catch (Exception ex)
        {
          UtilidadesLog.error(ex);
          String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError) );
        }
        UtilidadesLog.debug("Periodo Corporativo es " + oidRetorno);
        UtilidadesLog.info("DAODetalleMAV.obtieneOidPerioCorpo(Long oidPerioCra):Salida");
        return oidRetorno;
      
    }

    public Long consultorasGerenteZonaPorSubcriterio(DTODetalleMAV dto, Long oidCliente, Long periodo)
        throws MareException {
        
        UtilidadesLog.info("DAODetalleMAV.consultorasGerenteZonaPorSubcriterio(DTODetalleMAV dto, Long oidCliente, Long periodo):Entrada");
        
        RecordSet rs = new RecordSet();
        
        // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010                
        boolean aplicarUnidadesxRegionZona = false;
        if(dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_FORMULA) {
            if(dto.getUnidadesRegionZona()!=null) {
                Iterator it = dto.getUnidadesRegionZona().keySet().iterator();
                String claveUA = (String)it.next();
                Long valorUA = (Long)dto.getUnidadesRegionZona().get(claveUA);
                
                if(valorUA!=null)    
                    aplicarUnidadesxRegionZona = true;
            }
        }    
        UtilidadesLog.debug("aplicarUnidadesxRegionZona :" + aplicarUnidadesxRegionZona);
        
        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();
            
            //Long perioCorpo = this.obtieneOidPerioCorpo(periodo);

            String tabla = "";
            String campo = "";

            if(dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_VARIABLES) {
                UtilidadesLog.debug("Es Criterio Asignacion Variables");
                Long oidPeriodoFiltro = null;
                Integer campanyaEvaluacion = dto.getCampagnaEvaluacion();
                if((campanyaEvaluacion != null) && (campanyaEvaluacion.intValue() < 0)) {
                    tabla = "INT_FUENT_VENTAS_REAL";
                    Long oidPeriodoAnterior = this.obtieneOidPeriodoAnteriorPorCampanya( periodo,
                                                                                    dto.getCampagnaEvaluacion(),
                                                                                    dto.getCanal(),
                                                                                    dto.getMarca(),
                                                                                    dto.getOidPais() );
                                                                                    
                    oidPeriodoFiltro = oidPeriodoAnterior; 
                    
                } else {
                  tabla = "INT_FUENT_VENTA_PREVI_SAP";
                  if ( (campanyaEvaluacion != null) && (campanyaEvaluacion.intValue() > 0)) {
                      Long oidPeriodoPosterior = this.obtieneOidPeriodoPosteriorPorCampanya(periodo,
                                                                                  dto.getCampagnaEvaluacion(),
                                                                                  dto.getCanal(),
                                                                                  dto.getMarca(),
                                                                                  dto.getOidPais());
                      oidPeriodoFiltro = oidPeriodoPosterior;
                  } else {
                      oidPeriodoFiltro = periodo;
                  }
                }

                if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_ACTIVAS_FINALES.longValue())
                    campo = "NUM_ACTI_FINA";
                else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_INGRESOS.longValue())
                    campo = "NUM_INGR";
                else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_REINGRESOS.longValue())
                    campo = "NUM_REIN";
                else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_EGRESOS.longValue())
                    campo = "NUM_EGRE";
                else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_NUMERO_PEDIDOS.longValue())
                    campo = "NUM_PEDI";
                    
                /* Inc. 16051, 12/4/2005
                 * (3.1) Si el campo es "NUM_PEDI" y tabla es "INT_FUENTE_VENTAS_REAL"
                 *   -> Cambiar el valor de tabla de donde se obtiene este campo, tabla = "INT_FUENTE_VENTAS_REAL_VACUM"
                 * (3.1) Fin Si*/
                 // SSantana, 13/4/2005 
                 // Todavia no se hace este cambio.
                if (campo.equals("NUM_PEDI") && tabla.equals("INT_FUENT_VENTAS_REAL") )
                  tabla = "INT_FUENT_VENTA_REAL_VACUM";

                    

                /*    -> Hacer consulta JDBC sobre la tabla contenida en variable "tabla" para obtener la sumatoria del campo contenido en la variable "campo" para los siguientes criterios:
                        -> Cruzar la tabla contenida en la variable "tabla" con la tabla ZON_ZONA tal que ZON_ZONA.OID_ZONA = tabla.OID_ZONA
                        -> ZON_ZONA.CLIE_OID_CLIE = oidCliente
                        -> ZON_ZONA.OID_ZONA = una de las zonas contenidas en dto.zonas
                        -> tabla.PERI_OID_PERIO = periodo
                        -> De la consulta anterior sólo obtendremos un registro con la sumatoria de consultoras correspondiente al campo contenido en la variable "campo"
                        -> Devolver la cifra obtenida encapsulada en un Long*/
                query.append(" select SUM(" + campo + ") from " + tabla + ", ZON_ZONA Z ");
                
                if(dto.getRegiones()!= null) {
                    query.append(", mav_detal_mav_unida_admin ");
                }
                
                query.append(" where ");
                query.append(" Z.OID_ZONA = " + tabla + ".ZZON_OID_ZONA ");
                query.append(" and Z.CLIE_OID_CLIE = " + oidCliente);

                // vbongiov -- RI SiCC 20090967 -- 3/07/2009   
                /* Se reemplaza
                Long[] zonas = dto.getZonas();

                if(zonas != null) {
                    int canti = zonas.length - 1;

                    if(canti > -1) {
                        query.append(" and Z.OID_ZONA in (");

                        for(int i = 0; i < canti; i++)
                            query.append(zonas[i] + ", ");

                        query.append(zonas[canti] + ")");
                    }
                } */
                
                if(dto.getRegiones()!= null) {
                    query.append(" AND mav_detal_mav_unida_admin.denv_oid_deta_mav = " + dto.getOid());
                    query.append(" AND z.ZORG_OID_REGI = mav_detal_mav_unida_admin.ZORG_OID_REGI ");
                    query.append(" AND z.OID_ZONA = NVL(mav_detal_mav_unida_admin.ZZON_OID_ZONA, z.OID_ZONA) ");                
                }

                query.append(" and " + tabla + ".PERD_OID_PERI = " + oidPeriodoFiltro);
                //query.append(" and " + tabla + ".PERD_OID_PERI = " + perioCorpo);
                UtilidadesLog.debug(query.toString());
            } else {
                if(dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_FORMULA) 
                {
                    UtilidadesLog.debug("Es criterio Asignacion por Formula");
                    if((dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_ACTIVAS_FINALES_FORMULA.longValue())
                        || (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_INGRESOS_FORMULA.longValue())
                        || (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_REINGRESOS_FORMULA.longValue())
                        || (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_EGRESOS_FORMULA.longValue())
                        || (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_NUMERO_PEDIDOS_FORMULA.longValue())) {
                        
                        Long oidPeriodoFiltro = null;
                        Integer campanyaEvaluacion = dto.getCampagnaEvaluacion();               
                        if( (campanyaEvaluacion != null) && (campanyaEvaluacion.intValue() < 0) ) {
                            tabla = "INT_FUENT_VENTAS_REAL";                        
                            Long oidPeriodoAnterior = this.obtieneOidPeriodoAnteriorPorCampanya( periodo,
                                                                                            dto.getCampagnaEvaluacion(),
                                                                                            dto.getCanal(),
                                                                                            dto.getMarca(),
                                                                                            dto.getOidPais() );
                            oidPeriodoFiltro = oidPeriodoAnterior; 

                        } else {
                            tabla = "INT_FUENT_VENTA_PREVI_SAP";
                            if ( (campanyaEvaluacion != null) && (campanyaEvaluacion.intValue() > 0)) {
                               Long oidPeriodoPosterior = this.obtieneOidPeriodoPosteriorPorCampanya(periodo,
                                                                                          dto.getCampagnaEvaluacion(),
                                                                                          dto.getCanal(),
                                                                                          dto.getMarca(),
                                                                                          dto.getOidPais());
                               oidPeriodoFiltro = oidPeriodoPosterior;
                            } else {
                               oidPeriodoFiltro = periodo;
                            }
                        }  

                        // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010
                        if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_ACTIVAS_FINALES_FORMULA.longValue())
                            campo = "NUM_ACTI_FINA";
                        else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_INGRESOS_FORMULA.longValue())
                            campo = "NUM_INGR";
                        else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_REINGRESOS_FORMULA.longValue())
                            campo = "NUM_REIN";
                        else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_EGRESOS_FORMULA.longValue())
                            campo = "NUM_EGRE";
                        else if(dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_NUMERO_PEDIDOS_FORMULA.longValue())
                            campo = "NUM_PEDI";

                        if (campo.equals("NUM_PEDI") && tabla.equals("INT_FUENT_VENTAS_REAL") )
                          tabla = "INT_FUENT_VENTA_REAL_VACUM";

                        /*-> Hacer consulta JDBC sobre la tabla contenida en variable "tabla" para obtener la sumatoria del campo contenido en la variable "campo" para los siguientes criterios:
                        -> Cruzar la tabla contenida en la variable "tabla" con la tabla ZON_ZONA tal que ZON_ZONA.OID_ZONA = tabla.OID_ZONA
                        -> ZON_ZONA.CLIE_OID_CLIE = oidCliente
                        -> ZON_ZONA.OID_ZONA = una de las zonas contenidas en dto.zonas
                        -> tabla.PERI_OID_PERIO = periodo
                        -> De la consulta anterior sólo obtendremos un registro con la sumatoria de consultoras correspondiente al campo contenido en la variable "campo"
                        -> Devolver la cifra obtenida encapsulada en un Long*/
                        
                        if(aplicarUnidadesxRegionZona)
                            query.append(" select Z.OID_ZONA, SUM(" + campo + ") from " + tabla + ", ZON_ZONA Z ");
                        else
                            query.append(" select SUM(" + campo + ") from " + tabla + ", ZON_ZONA Z ");
                        
                        if(dto.getRegiones()!= null) {
                            query.append(", mav_detal_mav_unida_admin ");
                        }
                        
                        query.append(" where ");
                        query.append(" Z.OID_ZONA = " + tabla + ".ZZON_OID_ZONA ");
                        query.append(" and Z.CLIE_OID_CLIE = " + oidCliente);

                        // vbongiov -- RI SiCC 20090967 -- 3/07/2009   
                        /* Se reemplaza
                        Long[] zonas = dto.getZonas();

                        if(zonas != null) {
                            int canti = zonas.length - 1;

                            if(canti > -1) {
                                query.append(" and Z.OID_ZONA in (");

                                for(int i = 0; i < canti; i++)
                                    query.append(zonas[i] + ", ");

                                query.append(zonas[canti] + ")");
                            }
                        }*/
                        
                        if(dto.getRegiones()!= null) {
                            query.append(" AND mav_detal_mav_unida_admin.denv_oid_deta_mav = " + dto.getOid());
                            query.append(" AND z.ZORG_OID_REGI = mav_detal_mav_unida_admin.ZORG_OID_REGI ");
                            query.append(" AND z.OID_ZONA = NVL(mav_detal_mav_unida_admin.ZZON_OID_ZONA, z.OID_ZONA) ");
                        }

                        query.append(" and " + tabla + ".PERD_OID_PERI = " + oidPeriodoFiltro);
                        //query.append(" and " + tabla + ".PERD_OID_PERI = " + perioCorpo);
                        
                         if(aplicarUnidadesxRegionZona)
                             query.append(" GROUP BY Z.OID_ZONA ");
                        
                        UtilidadesLog.debug(query.toString());
                    } else if (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_NUMERO_ZONAS.longValue() ){
                        // Agregado por ssantana, 29/7/2005, inc. BELC300018058
                        
                         if(aplicarUnidadesxRegionZona)
                            query.append(" SELECT zon_zona.oid_zona, COUNT (zon_zona.oid_zona) ");
                         else
                            query.append(" SELECT COUNT (zon_zona.oid_zona) ");
                        
                        query.append(" FROM zon_zona ");
                        
                        if(dto.getRegiones()!= null) {
                            query.append(", mav_detal_mav_unida_admin ");
                        }
                        
                        query.append(" WHERE zon_zona.clie_oid_clie = " + oidCliente );
                        query.append(" AND zon_zona.ind_acti = 1 ");
                        query.append(" AND zon_zona.ind_borr = 0 ");
                        
                        // Agregado por ssantana, 24/10/2005, inc. DBLG2 665.
                        // Ahora filtra por las regiones del DetalleMAV. 
                         // vbongiov -- RI SiCC 20090967 -- 3/07/2009   
                         /* Se reemplaza
                        Long[] zonas = dto.getZonas();

                        if(zonas != null) {
                            int canti = zonas.length - 1;

                            if(canti > -1) {
                                query.append(" and zon_zona.OID_ZONA in (");

                                for(int i = 0; i < canti; i++) {
                                    query.append(zonas[i] + ", ");
                                }

                                query.append(zonas[canti] + ")");
                            }
                        }
                        // Fin Agregado por ssantana, 24/10/2005, inc. DBLG2 665.    
                        */
                        
                        if(dto.getRegiones()!= null) {
                            query.append(" AND mav_detal_mav_unida_admin.denv_oid_deta_mav = " + dto.getOid());
                            query.append(" AND zon_zona.ZORG_OID_REGI = mav_detal_mav_unida_admin.ZORG_OID_REGI ");
                            query.append(" AND zon_zona.OID_ZONA = NVL(mav_detal_mav_unida_admin.ZZON_OID_ZONA, zon_zona.OID_ZONA) ");
                        }
                        
                        if(aplicarUnidadesxRegionZona)
                            query.append(" GROUP BY zon_zona.oid_zona ");
                        
                        UtilidadesLog.debug(query.toString());
                        
                    } else if (dto.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_TIPOLOGIA_CLIENTES.longValue() ){

                        if(aplicarUnidadesxRegionZona)
                            query.append(" SELECT zon.OID_ZONA, COUNT(DISTINCT adm.CLIE_OID_CLIE) ");
                        else
                            query.append(" SELECT COUNT(DISTINCT adm.CLIE_OID_CLIE) ");
                        
                        query.append("   FROM MAE_CLIEN_UNIDA_ADMIN adm, ");
                        query.append("        MAE_CLIEN_DATOS_ADICI cda, ");
                        query.append("        V_MAE_TIPIF_CLIEN tip, ");
                        query.append("        ZON_TERRI_ADMIN ter, ");
                        query.append("        ZON_SECCI sec, ");
                        query.append("        ZON_ZONA zon ");
                        
                        if(dto.getRegiones()!= null) {
                            query.append(", mav_detal_mav_unida_admin ");
                        }
                        
                        query.append(" WHERE tip.CLIE_OID_CLIE = adm.CLIE_OID_CLIE ");
                        query.append("   AND adm.IND_ACTI = 1 ");

                        // sapaza -- PER-SiCC-2010-0699 -- 07/03/2011
                        query.append("   AND tip.CLIE_OID_CLIE = cda.CLIE_OID_CLIE ");
                        query.append("   AND cda.IND_ACTI = 1 ");
                        
                        query.append("   AND adm.ZTAD_OID_TERR_ADMI = ter.OID_TERR_ADMI ");
                        query.append("   AND ter.ZSCC_OID_SECC = sec.OID_SECC ");
                        query.append("   AND sec.ZZON_OID_ZONA = zon.OID_ZONA ");
                        query.append("   AND zon.clie_oid_clie = " + oidCliente );
                        
                        if (dto.getClasificacion() != null)
                            query.append(" and tip.CLAS_OID_CLAS = " + dto.getClasificacion());
                          
                        if (dto.getTipoClasificacion() != null)
                            query.append(" and tip.TCCL_OID_TIPO_CLASI = " + dto.getTipoClasificacion());

                        if (dto.getSubTipoCliente() != null)
                            query.append(" and tip.SBTI_OID_SUBT_CLIE = " + dto.getSubTipoCliente());

                        if (dto.getTipoClienteCriterio() != null)
                            query.append(" and tip.TICL_OID_TIPO_CLIE = " + dto.getTipoClienteCriterio());

                        if(dto.getRegiones()!= null) {
                            query.append(" AND mav_detal_mav_unida_admin.denv_oid_deta_mav = " + dto.getOid());
                            query.append(" AND zon.ZORG_OID_REGI = mav_detal_mav_unida_admin.ZORG_OID_REGI ");
                            query.append(" AND zon.OID_ZONA = NVL(mav_detal_mav_unida_admin.ZZON_OID_ZONA, zon.OID_ZONA) ");
                        }
                        
                        if(aplicarUnidadesxRegionZona)
                            query.append(" GROUP BY zon.OID_ZONA ");
                        
                        UtilidadesLog.debug(query.toString());
                    } else {
                        /*-> Hacer consulta JDBC sobre la tabla EDU_APTAS_CURSO y sumar el número de EDU_APTAS_CURSO.CLIE_OID_CLIE para los siguientes criterios:
                        -> Cruzar tabla EDU_APTAS_CURSO con la tabla EDU_MATRI_CURSO y esta a su vez con ZON_ZONA
                        -> ZON_ZONA.CLIE_OID_CLIE = oidCliente
                        -> EDU_MATRI_CURSO.ZZON_OID_ZONA = una de las zonas contenidas en dto.zonas*/
                        query.append(" select COUNT(EDU_APTAS_CURSO.CLIE_OID_CLIE) from EDU_APTAS_CURSO, EDU_MATRI_CURSO, ZON_ZONA ");
                        
                        if(dto.getRegiones()!= null) {
                            query.append(", mav_detal_mav_unida_admin ");
                        }
                        
                        query.append(" where ");
                        query.append(" MCUR_OID_CURS = OID_CURS ");
                        query.append(" and ZZON_OID_ZONA = OID_ZONA ");
                        query.append(" and ZON_ZONA.CLIE_OID_CLIE = " + oidCliente);

                        // vbongiov -- RI SiCC 20090967 -- 3/07/2009   
                        /* Se reemplaza
                        Long[] zonas = dto.getZonas();

                        if(zonas != null) {
                            int canti = zonas.length - 1;

                            if(canti > -1) {
                                query.append(" and ZON_ZONA.OID_ZONA in (");

                                for(int i = 0; i < canti; i++)
                                    query.append(zonas[i] + ", ");

                                query.append(zonas[canti] + ")");
                            }
                        }*/
                        
                        if(dto.getRegiones()!= null) {
                            query.append(" AND mav_detal_mav_unida_admin.denv_oid_deta_mav = " + dto.getOid());
                            query.append(" AND zon_zona.ZORG_OID_REGI = mav_detal_mav_unida_admin.ZORG_OID_REGI ");
                            query.append(" AND zon_zona.OID_ZONA = NVL(mav_detal_mav_unida_admin.ZZON_OID_ZONA, zon_zona.OID_ZONA) ");
                        }

                        UtilidadesLog.debug(query.toString());
                    }
                }
            }

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.debug("rs: " + rs);

        // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010                
        if(!rs.esVacio()) {
            UtilidadesLog.info("DAODetalleMAV.consultorasGerenteZonaPorSubcriterio(DTODetalleMAV dto, Long oidCliente, Long periodo):Salida");
            
            if(aplicarUnidadesxRegionZona) {
                Long consultorasUnidades = new Long(0);
                for(int i=0; i<rs.getRowCount(); i++) {
                    String zona = rs.getValueAt(i, 0).toString();
                    Long totalesConsultoras = new Long(rs.getValueAt(i, 1).toString());
                    Long unidades = (Long)dto.getUnidadesRegionZona().get("z"+zona);
                    
                    if((unidades.longValue() == 0) && (dto.getUnidadesPorCliente() !=null))
                      unidades = dto.getUnidadesPorCliente().longValue();
                    
                    Long totalFila = new Long(totalesConsultoras.longValue() * unidades.longValue());
                    consultorasUnidades = new Long(consultorasUnidades.longValue() + totalFila.longValue());
                }
                return consultorasUnidades;
                
            } else             
                if(rs.getValueAt(0, 0) != null) 
                    return new Long(rs.getValueAt(0, 0).toString());
                else    
                    return new Long(0);
                    
        } else {
            UtilidadesLog.info("DAODetalleMAV.consultorasGerenteZonaPorSubcriterio(DTODetalleMAV dto, Long oidCliente, Long periodo):Salida");
            return new Long(0);
        }
    }

    // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010
    public RecordSet obtenerClientesLista(Long oidLista) throws MareException {
        UtilidadesLog.info("DAODetalleMAV.obtenerClientesLista(Long oidLista):Entrada");
    
        RecordSet rs = new RecordSet();
        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

            query.append(" select MAE_CLIEN.OID_CLIE, MAV_LISTA_CLIEN_CLIEN.NUM_UNID from MAE_CLIEN, MAV_LISTA_CLIEN_CLIEN ");
            query.append(" where MAV_LISTA_CLIEN_CLIEN.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE ");
            query.append(" and MAV_LISTA_CLIEN_CLIEN.LICL_OID_LISTA_CLIE = " + oidLista);

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAODetalleMAV.obtenerClientesLista(Long oidLista):Salida");
        return rs;
    }

    public RecordSet obtenerClientesPorAtributos(DTODetalleMAV dto)
        throws MareException {
        UtilidadesLog.info("DAODetalleMAV.obtenerClientesPorAtributos(DTODetalleMAV dto):Entrada");
        RecordSet rs = new RecordSet();

        try {
            PeriodoLocalHome plh = new PeriodoLocalHome();
            PeriodoLocal periodoInicio = plh.findByPrimaryKey(dto.getPeriodo());
            
            // Añadido por ssantana, 17/3/2005 - Contempla Periodo Fin Nulo
            PeriodoLocal periodoFin = null;
            if (dto.getPeriodoFin() != null)
              periodoFin = plh.findByPrimaryKey(dto.getPeriodoFin());
              
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

            query.append(" select DISTINCT OID_CLIE from MAE_CLIEN, V_MAE_TIPIF_CLIEN, ");
            
            // vbongiov -- SICC 20091127 -- 18/08/2009
            query.append(" MAE_CLIEN_DATOS_ADICI, PED_SOLIC_CABEC, CRA_PERIO  ");
            
            if (dto.getMarcaCondicion() != null || dto.getUnidadNegocio() != null || dto.getCatalogo() != null || dto.getMonto() != null) {
                query.append(", PED_SOLIC_POSIC ");
            }
                       
            if (dto.getMarcaCondicion() != null || dto.getUnidadNegocio() != null) {
                query.append(" , MAE_PRODU ");
            }                       
            
            if (dto.getCatalogo() != null){
                query.append(" , PRE_OFERT_DETAL ");
            }
            
            
            query.append(" where MAE_CLIEN.OID_CLIE = V_MAE_TIPIF_CLIEN.CLIE_OID_CLIE ");
            query.append(" and V_MAE_TIPIF_CLIEN.TICL_OID_TIPO_CLIE = " + dto.getTipoCliente());            

            String subtipo = this.includeIN("V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE", dto.getSubtiposCliente());

            if((subtipo != null) && (subtipo.length() > 0))
                query.append(" and " + subtipo);
                
            // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010    
            String clasificacion = this.includeIN("V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS", dto.getClasificaciones());                
            if((clasificacion != null) && (clasificacion.length() > 0))
                query.append(" and " + clasificacion);

            String tipoClasificacion = this.includeIN("V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI", dto.getTiposClasificacion());                
            if((tipoClasificacion != null) && (tipoClasificacion.length() > 0))
                query.append(" and " + tipoClasificacion);

            query.append(" and ( exists ");
            query.append("      	 (select zon_sub_geren_venta.OID_SUBG_VENT from zon_sub_geren_venta, mav_detal_mav_unida_admin, mae_clien where ");
            query.append("          mav_detal_mav_unida_admin.DENV_OID_DETA_MAV = " + dto.getOid() );
            query.append("    		  and mav_detal_mav_unida_admin.ZSGV_OID_SUBG_VENT = zon_sub_geren_venta.OID_SUBG_VENT ");
            query.append("    		  and zon_sub_geren_venta.CLIE_OID_CLIE = mae_clien.OID_CLIE) ");
            query.append("   OR ");
            query.append(" 		   exists ");
            query.append("   		   (select zon_regio.OID_REGI from zon_regio, mav_detal_mav_unida_admin, mae_clien where ");
            query.append("          mav_detal_mav_unida_admin.DENV_OID_DETA_MAV = " + dto.getOid() );
 				    query.append("          and mav_detal_mav_unida_admin.ZORG_OID_REGI = zon_regio.OID_REGI ");
            query.append("  				and zon_regio.CLIE_OID_CLIE = mae_clien.OID_CLIE ) ");
            query.append("   OR ");
            query.append("       exists ");
			      query.append("              (select zon_zona.oid_zona from zon_zona, mav_detal_mav_unida_admin, mae_clien where ");
            query.append("               mav_detal_mav_unida_admin.DENV_OID_DETA_MAV = " + dto.getOid() );
            query.append("               and mav_detal_mav_unida_admin.ZZON_OID_ZONA = ZON_ZONA.oid_zona ");
            query.append("               and zon_zona.CLIE_OID_CLIE = mae_clien.OID_CLIE) ");
            query.append("     ) ");

            query.append(" and MAE_CLIEN.OID_CLIE = MAE_CLIEN_DATOS_ADICI.CLIE_OID_CLIE  ");

            // Modificado por ssantana, 20/1/2005
            // ----------------------------------
            
/*            query.append(" and (mae_clien_datos_adici.fec_naci IS NULL OR " );
            query.append(" TO_DATE(substr('" + periodoInicio.getFechainicio()
                + "', 6, 10), 'MM-DD') <= to_date(substr(mae_clien_datos_adici.fec_naci, 0, 5), 'DD-MM'))");
                
            query.append(" and (mae_clien_datos_adici.fec_naci IS NULL OR ");
            query.append(" to_date(substr(mae_clien_datos_adici.fec_naci, 0, 5), 'DD-MM') <= TO_DATE (substr('"
                + periodoInicio.getFechaFin() + "', 6, 10), 'MM-DD'))");
                
            query.append(" and (MAE_CLIEN.FEC_INGR IS NULL OR ");
            query.append(" to_date('" + periodoFin.getFechainicio() + "', 'YYYY-MM-DD') <= MAE_CLIEN.FEC_INGR) ");
            
            query.append(" and (MAE_CLIEN.FEC_INGR IS NULL OR ");
            query.append(" MAE_CLIEN.FEC_INGR <= to_date('" + periodoFin.getFechaFin() + "', 'YYYY-MM-DD'))");              
  */            
  
            query.append(" and (mae_clien_datos_adici.fec_naci IS NULL OR " );
            query.append(" TO_DATE(substr('" + periodoInicio.getFechainicio()
                + "', 6, 10), 'MM-DD') <= to_date(decode(substr(to_char(mae_clien_datos_adici.fec_naci, 'DD-MM-YYYY'), 0, 5),'29-02','28-02', substr(to_char(mae_clien_datos_adici.fec_naci, 'DD-MM-YYYY'), 0, 5)) , 'DD-MM'))");
                
            query.append(" and (mae_clien_datos_adici.fec_naci IS NULL OR ");
            query.append(" to_date(decode(substr(to_char(mae_clien_datos_adici.fec_naci, 'DD-MM-YYYY'), 0, 5),'29-02','28-02', substr(to_char(mae_clien_datos_adici.fec_naci, 'DD-MM-YYYY'), 0, 5)) , 'DD-MM') <= TO_DATE (substr('"
                + periodoInicio.getFechaFin() + "', 6, 10), 'MM-DD'))");
                
            query.append(" and (MAE_CLIEN.FEC_INGR IS NULL OR ");
            query.append(" to_date('" + periodoInicio.getFechainicio() + "', 'YYYY-MM-DD') <= MAE_CLIEN.FEC_INGR) ");
            
            if (dto.getPeriodoFin() != null)
            {
                query.append(" and (MAE_CLIEN.FEC_INGR IS NULL OR ");
                query.append(" MAE_CLIEN.FEC_INGR <= to_date('" + periodoFin.getFechaFin() + "', 'YYYY-MM-DD'))");
            }
              
            if (dto.getEdadDesde() != null)
              query.append(" and " + dto.getEdadDesde() + " <= mae_clien_datos_adici.VAL_EDAD ");
              
            if (dto.getEdadHasta() != null)
              query.append(" and mae_clien_datos_adici.VAL_EDAD <= " + dto.getEdadHasta());

            query.append(" and MAE_CLIEN.OID_CLIE = PED_SOLIC_CABEC.CLIE_OID_CLIE ");
            query.append(" and PED_SOLIC_CABEC.PERD_OID_PERI = CRA_PERIO.OID_PERI ");
            
            // vbongiov -- SICC 20091127 -- 18/08/2009
            if (dto.getMarcaCondicion() != null || dto.getUnidadNegocio() != null || dto.getCatalogo() != null || dto.getMonto() != null) {
                query.append(" and PED_SOLIC_CABEC.OID_SOLI_CABE = PED_SOLIC_POSIC.SOCA_OID_SOLI_CABE ");
            }
                       
            if (dto.getMarcaCondicion() != null || dto.getUnidadNegocio() != null) {
                query.append(" and PED_SOLIC_POSIC.PROD_OID_PROD = MAE_PRODU.OID_PROD ");
            }                       
            
            if (dto.getCatalogo() != null){
                query.append(" and PED_SOLIC_POSIC.OFDE_OID_DETA_OFER = PRE_OFERT_DETAL.OID_DETA_OFER ");
            }
            
            if (dto.getMarcaCondicion() != null || dto.getUnidadNegocio() != null)
            {
              // Abre Bloque 
              query.append(" and ( ");
              boolean hayAnterior = false;
              if (dto.getMarcaCondicion() != null)
              {
                query.append(" MAE_PRODU.MAPR_OID_MARC_PROD = " + dto.getMarcaCondicion() );
                hayAnterior = true;
              }
              
              // Si se agregó la condicion con dto.getMarcaCondicion() 
              // y dto.getUnidadNegocio() != null
              if (hayAnterior && dto.getUnidadNegocio() != null) 
                query.append(" OR ");
                
              if ( dto.getUnidadNegocio() != null)
                query.append(" MAE_PRODU.UNEG_OID_UNID_NEGO = " + dto.getUnidadNegocio() );
              
                //query.append(" MAE_PRODU.NEGO_OID_NEGO = " + dto.getUnidadNegocio() );
                
              // Cierra Bloque  
              query.append(" ) ");
              
/*            Codigo Original               
 *            query.append(" and (MAE_PRODU.MAPR_OID_MARC_PROD = " + dto.getMarcaCondicion());
              query.append(" or MAE_PRODU.NEGO_OID_NEGO = " + dto.getUnidadNegocio() + ") ");*/
            }
            
            if (dto.getCatalogo() != null)
              query.append(" and PRE_OFERT_DETAL.OCAT_OID_CATAL = " + dto.getCatalogo());

            query.append(" group by OID_CLIE ");
            query.append(" Having MAX(CRA_PERIO.FEC_FINA) <= to_date(to_char(sysdate, 'yyyy-MM-dd'), 'YYYY-MM-DD') ");
            
            // Modific. por ssantana, 24/1/2005
            if (dto.getMonto() != null)
            {
              query.append(" and SUM(PED_SOLIC_CABEC.VAL_PREC_CATA_TOTA_LOC_UNI_DEM) > " + dto.getMonto());
              query.append(" AND SUM(PED_SOLIC_POSIC.VAL_PREC_CATA_UNIT_LOCA * PED_SOLIC_POSIC.NUM_UNID_POR_ATEN) >  " + dto.getMonto());              
            } 

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("rs: " + rs);
        } catch(NoResultException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("DAODetalleMAV.obtenerClientesPorAtributos(DTODetalleMAV dto):Salida");
        return rs;
    }

    public RecordSet obtenerClientesPorVariables(DTODetalleMAV dto)
        throws MareException {
        UtilidadesLog.info("DAODetalleMAV.obtenerClientesPorVariables(DTODetalleMAV dto):Entrada");
        RecordSet rs = new RecordSet();

        try {
            Long[] arrayRegiones = dto.getRegiones();        
            Long[] arrayZonas = dto.getZonas();            
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();
            
            // Modificado por ssantana, 30/3/2004
            // por incidencia MAV-12. Ahora trae tanto los clientes Gerentes de Zona 
            // como los de Region
            query.append(" (SELECT DISTINCT oid_clie ");
            query.append(" FROM mae_clien, "); 
            query.append(" v_mae_tipif_clien, ");
            query.append(" zon_regio, ");
            query.append(" mav_param_geren_regio ");
            query.append(" WHERE mae_clien.oid_clie = v_mae_tipif_clien.clie_oid_clie ");
            query.append(" AND v_mae_tipif_clien.ticl_oid_tipo_clie = " + dto.getTipoCliente() );
            
            String subtipo = this.includeIN("V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE", dto.getSubtiposCliente());
            if((subtipo != null) && (subtipo.length() > 0))
                query.append(" and " + subtipo);

            // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010    
            String clasificacion = this.includeIN("V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS", dto.getClasificaciones());                
            if((clasificacion != null) && (clasificacion.length() > 0))
                query.append(" and " + clasificacion);

            String tipoClasificacion = this.includeIN("V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI", dto.getTiposClasificacion());                
            if((tipoClasificacion != null) && (tipoClasificacion.length() > 0))
                query.append(" and " + tipoClasificacion);
            
            query.append(" and ( (MAV_PARAM_GEREN_REGIO.SBTI_OID_SUBT_CLIE = V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE)  ");
            query.append(" 	     AND (ZON_REGIO.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE) ");
            /*
             * Agregado por ssantana, 05/01/2006,
             * si el DetalleMAV no posee Regiones, no se debe filtrar por tal 
             * criterio.
             */
            if ( arrayRegiones != null && arrayRegiones.length > 0) {
                StringBuffer subqueryRegiones = new StringBuffer(" select zon_regio.oid_regi from zon_regio, mav_detal_mav_unida_admin ");            
                subqueryRegiones.append(" where mav_detal_mav_unida_admin.DENV_OID_DETA_MAV = " + dto.getOid());
                subqueryRegiones.append(" and mav_detal_mav_unida_admin.ZORG_OID_REGI = zon_regio.OID_REGI ");
                subqueryRegiones.append(" and zon_regio.CLIE_OID_CLIE = mae_clien.oid_clie ");
                
                query.append(" and zon_regio.oid_regi IN ( " + subqueryRegiones.toString() + ") ");   
            }
            /*
             * Fin agregado por ssantana, 05/01/2006,
             * si el DetalleMAV no posee Regiones, no se debe filtrar por tal 
             * criterio.
             */
                    
            query.append(" ) ");
            query.append(" ) ");
            
            query.append(" UNION ");

            query.append(" (SELECT DISTINCT oid_clie ");
            query.append(" FROM mae_clien, ");
            query.append(" v_mae_tipif_clien, ");
            query.append(" zon_zona, ");
            query.append(" mav_param_geren_zona ");
            
            // vbongiov -- RI SiCC 20090967 -- 3/07/2009     
            if ( arrayRegiones != null && arrayRegiones.length > 0) {
                query.append(", mav_detal_mav_unida_admin ");
            }
            
            query.append(" WHERE mae_clien.oid_clie = v_mae_tipif_clien.clie_oid_clie ");
            query.append(" AND v_mae_tipif_clien.ticl_oid_tipo_clie = " + dto.getTipoCliente() );
            
            subtipo = this.includeIN("V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE", dto.getSubtiposCliente());
            if((subtipo != null) && (subtipo.length() > 0))
                query.append(" and " + subtipo);
            
            // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010        
            if((clasificacion != null) && (clasificacion.length() > 0))
              query.append(" and V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS = " + dto.getClasificacion());
            if((tipoClasificacion != null) && (tipoClasificacion.length() > 0))
              query.append(" and V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI = " + dto.getTipoClasificacion());
                
            query.append(" 	AND MAV_PARAM_GEREN_ZONA.SBTI_OID_SUBT_CLIE = V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE  ");
            query.append(" 	AND ZON_ZONA.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE  ");
            
            // vbongiov -- RI SiCC 20090967 -- 3/07/2009     
             if ( arrayRegiones != null && arrayRegiones.length > 0) {
                 query.append(" AND mav_detal_mav_unida_admin.denv_oid_deta_mav = " + dto.getOid());
                 query.append(" AND zon_zona.ZORG_OID_REGI = mav_detal_mav_unida_admin.ZORG_OID_REGI ");
                 query.append(" AND zon_zona.OID_ZONA = NVL(mav_detal_mav_unida_admin.ZZON_OID_ZONA, zon_zona.OID_ZONA) ");
             }
            
            query.append("  ) ");
            

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAODetalleMAV.obtenerClientesPorVariables(DTODetalleMAV dto):Salida");
        return rs;
    }

    public RecordSet obtenerClientesPorFormula(DTODetalleMAV dto)
        throws MareException {
        
        UtilidadesLog.info("DAODetalleMAV.obtenerClientesPorFormula(DTODetalleMAV dto):Entrada");
        
        RecordSet rs = new RecordSet();
        try {
            Long[] arrayRegiones = dto.getRegiones();                    
            Long[] arrayZonas = dto.getZonas();            
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();
            
            // Modificado por ssantana, 30/3/2004
            // por incidencia MAV-12. Ahora trae tanto los clientes Gerentes de Zona 
            // como los de Region
            query.append(" (SELECT DISTINCT oid_clie ");
            query.append(" FROM mae_clien, "); 
            query.append(" v_mae_tipif_clien, ");
            query.append(" zon_regio, ");
            query.append(" mav_param_geren_regio ");
            query.append(" WHERE mae_clien.oid_clie = v_mae_tipif_clien.clie_oid_clie ");
            query.append(" AND v_mae_tipif_clien.ticl_oid_tipo_clie = " + dto.getTipoCliente() );
            
            String subtipo = this.includeIN("V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE", dto.getSubtiposCliente());
            if((subtipo != null) && (subtipo.length() > 0))
                query.append(" and " + subtipo);
            
            // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010    
            String clasificacion = this.includeIN("V_MAE_TIPIF_CLIEN.CLAS_OID_CLAS", dto.getClasificaciones());                
            if((clasificacion != null) && (clasificacion.length() > 0))
                query.append(" and " + clasificacion);

            String tipoClasificacion = this.includeIN("V_MAE_TIPIF_CLIEN.TCCL_OID_TIPO_CLASI", dto.getTiposClasificacion());                
            if((tipoClasificacion != null) && (tipoClasificacion.length() > 0))
                query.append(" and " + tipoClasificacion);
            
            query.append(" and ( (MAV_PARAM_GEREN_REGIO.SBTI_OID_SUBT_CLIE = V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE)  ");
            query.append(" 	      AND (ZON_REGIO.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE) ");
            /*
             * Agregado por ssantana, 05/01/2006,
             * si el DetalleMAV no posee Regiones, no se debe filtrar por tal 
             * criterio.
             */
            if ( arrayRegiones != null && arrayRegiones.length > 0) {
                StringBuffer subqueryRegiones = new StringBuffer(" select zon_regio.oid_regi from zon_regio, mav_detal_mav_unida_admin ");            
                subqueryRegiones.append(" where mav_detal_mav_unida_admin.DENV_OID_DETA_MAV = " + dto.getOid());
                subqueryRegiones.append(" and mav_detal_mav_unida_admin.ZORG_OID_REGI = zon_regio.OID_REGI ");
                subqueryRegiones.append(" and zon_regio.CLIE_OID_CLIE = mae_clien.oid_clie ");
                
                query.append(" and zon_regio.oid_regi IN ( " + subqueryRegiones.toString() + ") ");   
            }
            /*
             * Fin Agregado por ssantana, 05/01/2006,
             * si el DetalleMAV no posee Regiones, no se debe filtrar por tal 
             * criterio.
             */
                    
            query.append(" ) ");
            query.append(" ) ");
            
            query.append(" UNION ");

            query.append(" (SELECT DISTINCT oid_clie ");
            query.append(" FROM mae_clien, ");
            query.append(" v_mae_tipif_clien, ");
            query.append(" zon_zona, ");
            query.append(" mav_param_geren_zona ");
            
            // vbongiov -- RI SiCC 20090967 -- 3/07/2009     
            if ( arrayRegiones != null && arrayRegiones.length > 0) {
                query.append(", mav_detal_mav_unida_admin ");
            }
            
            query.append(" WHERE mae_clien.oid_clie = v_mae_tipif_clien.clie_oid_clie ");
            query.append(" AND v_mae_tipif_clien.ticl_oid_tipo_clie = " + dto.getTipoCliente() );
            
            subtipo = this.includeIN("V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE", dto.getSubtiposCliente());
            if((subtipo != null) && (subtipo.length() > 0))
                query.append(" and " + subtipo);
                
            // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010    
            if((clasificacion != null) && (clasificacion.length() > 0))
                query.append(" and " + clasificacion);
            if((tipoClasificacion != null) && (tipoClasificacion.length() > 0))
                query.append(" and " + tipoClasificacion);
                
            query.append(" AND MAV_PARAM_GEREN_ZONA.SBTI_OID_SUBT_CLIE = V_MAE_TIPIF_CLIEN.SBTI_OID_SUBT_CLIE  ");
            query.append(" AND ZON_ZONA.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE  ");
           
            // vbongiov -- RI SiCC 20090967 -- 3/07/2009     
             if ( arrayRegiones != null && arrayRegiones.length > 0) {
                 query.append(" AND mav_detal_mav_unida_admin.denv_oid_deta_mav = " + dto.getOid());
                 query.append(" AND zon_zona.ZORG_OID_REGI = mav_detal_mav_unida_admin.ZORG_OID_REGI ");
                 query.append(" AND zon_zona.OID_ZONA = NVL(mav_detal_mav_unida_admin.ZZON_OID_ZONA, zon_zona.OID_ZONA) ");
             }
           
            query.append(" ) ");
            

             
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.debug("rs: " + rs);        
        UtilidadesLog.info("DAODetalleMAV.obtenerClientesPorFormula(DTODetalleMAV dto):Salida");
        return rs;
    }

    public DTOSalida obtieneDetallesMAVCampania(DTODetalleMAV dto, Long tipoEstadoProceso)
        throws MareException {

        UtilidadesLog.info("DAODetalleMAV.obtieneDetallesMAVCampania(DTODetalleMAV dto, Long tipoEstadoProceso):Entrada");
        RecordSet rs = new RecordSet();

        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            StringBuffer query = new StringBuffer();

            query.append(" select OID_DETA_MAV ");
            query.append(" from MAV_DETAL_MAV ");//, CRA_PERIO PERIODO_INICIO, CRA_PERIO PERIODO_FIN ");
            //query.append(" where MAV_DETAL_MAV.PERD_OID_PERI = PERIODO_INICIO.OID_PERI ");
            query.append(" where MAV_DETAL_MAV.PERD_OID_PERI = "+dto.getPeriodo());
            /*query.append(" and MAV_DETAL_MAV.PERD_OID_PERI_FINA = PERIODO_FIN.OID_PERI(+) ");
            query.append(" and PERIODO_INICIO.FEC_INIC >= to_date('" + periodoLocal.getFechainicio() + "', 'YYYY-MM-DD')");
            query.append(" and PERIODO_FIN.FEC_FINA(+) <= to_date('" + periodoLocal.getFechaFin() + "', 'YYYY-MM-DD')");
            query.append(" and PERIODO_INICIO.PAIS_OID_PAIS = " + dto.getOidPais() + " ");
            query.append(" and PERIODO_INICIO.MARC_OID_MARC = " + dto.getMarca() + " ");
            query.append(" and PERIODO_INICIO.CANA_OID_CANA = " + dto.getCanal() + " ");
            query.append(" and PERIODO_FIN.PAIS_OID_PAIS(+) = " + dto.getOidPais() + " ");
            query.append(" and PERIODO_FIN.MARC_OID_MARC(+) = " + dto.getMarca() + " ");
            query.append(" and PERIODO_FIN.CANA_OID_CANA(+) = " + dto.getCanal() + " ");*/
            
            // Agregado por ssantana, 25/1/2005
            query.append(" and MAV_DETAL_MAV.TEPR_OID_TIPO_ESTA_PROC = " + tipoEstadoProceso + " ");

            if(dto.getActividad() != null)
                query.append(" and MAV_DETAL_MAV.ACTI_OID_ACTI = " + dto.getActividad() + " ");

            if(dto.getTipoCliente() != null)
                query.append(" and MAV_DETAL_MAV.TICL_OID_TIPO_CLIE = " + dto.getTipoCliente() + " ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAODetalleMAV.obtieneDetallesMAVCampania(DTODetalleMAV dto, Long tipoEstadoProceso):Salida");
        return new DTOSalida(rs);
    }


    public static void main(String[] args) throws Exception {
        DAODetalleMAV d = new DAODetalleMAV();
/*        DTOBelcorp f = new DTOBelcorp();
        DTODetalleMAV fff = new DTODetalleMAV();
        Long[] e = new Long[] {};

        //fff.setRegiones(e);
        fff.setCriterioAsignacion(new Long(3));
        fff.setCampagnaEvaluacion(new Integer(-1));
        fff.setSubcriterio(new Long(21));
        f.setOidIdioma(new Long(1));
        f.setOidPais(new Long(1));
        UtilidadesLog.debug(d.consultorasGerenteZonaPorSubcriterio(fff, new Long(1), new Long(1)));*/
      DAODetalleMAV dao = new DAODetalleMAV();
      DTODetalleMAV dtoM = new DTODetalleMAV();
      dtoM.setTipoClasificacion(new Long(1));
      dtoM.setClasificacion(new Long(2));
      dtoM.setTipoCliente(new Long(3));
      
      Long[] subtipos = new Long[2];
      subtipos[0] = new Long(1);
      subtipos[1] = new Long(2);    
      
      Long[] regiones = new Long[2];
      regiones[0] = new Long(7);
      regiones[1] = new Long(8);    
      
      Long[] zonas = new Long[2];
      zonas[0] = new Long(5);
      zonas[1] = new Long(6);      
      
      
      
      dtoM.setSubtiposCliente(subtipos);
      
      dtoM.setRegiones(regiones);
      dtoM.setZonas(zonas);
      //dao.obtenerClientesPorFormula(dtoM);
      dao.obtenerClientesPorVariables(dtoM);
        
        //d.concatena(null);
    }

    private String includeIN(String tabla, Long[] oids) {
        UtilidadesLog.info("DAODetalleMAV.includeIN(String tabla, Long[] oids):Entrada");
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
        UtilidadesLog.info("DAODetalleMAV.includeIN(String tabla, Long[] oids):Salida");
        return aux2.toString();
    }

    private BelcorpService getBelcorpService() {
        try {
            return BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
    }
    
    /*
     * [SiCC20070270] Rafael Romero - 29/05/2007
     * Se agregan parametros para filtrar por Codigo SAP y numero de Unidades Estimadas, Unidades Cliente y Unidades Totales
     */
    private String armaQueryPrincipal(Long actividad, Long periodo, Long tipoCliente, Long idioma, String codigoSAP, BigDecimal unidades ) throws MareException
    {
        /*
         * Modificado por Rafael Romero 23/04/2007
         * Incidencia SiCC 20070189
         * Restructuracion de la consulta para incluir estados 3 y 4
         */
        UtilidadesLog.info("DAODetalleMAV.armaQueryPrincipal(Long actividad, Long periodo, Long tipoCliente, Long idioma, String codigoSAP, BigDecimal unidades):Entrada");
        //StringBuffer qSelect = new StringBuffer("");
        //StringBuffer qFrom = new StringBuffer("");
        //StringBuffer qWhere = new StringBuffer("");
        StringBuffer query = new StringBuffer("");

        query.append("SELECT detalle.oid_deta_mav OID, ");
        query.append("       (SELECT v1.val_i18n ");
        query.append("          FROM v_gen_i18n_sicc v1 ");
        query.append("         WHERE v1.idio_oid_idio = " + idioma.toString() + " ");
        query.append("           AND v1.attr_num_atri = 1 ");
        query.append("           AND v1.attr_enti = 'PRE_TIPO_OFERT' ");
        query.append("           AND v1.val_oid = detalle.tofe_oid_tipo_ofer) tipooferta, ");
        query.append("       (SELECT v2.val_i18n ");
        query.append("          FROM v_gen_i18n_sicc v2 ");
        query.append("         WHERE v2.idio_oid_idio = " + idioma.toString() + " ");
        query.append("           AND v2.attr_num_atri = 1 ");
        query.append("           AND v2.attr_enti = 'PRE_CICLO_VIDA' ");
        query.append("           AND v2.val_oid = detalle.civi_oid_cicl_vida) ciclovida, ");
        query.append("       (SELECT produ.cod_sap ");
        query.append("          FROM mae_produ produ ");
        query.append("         WHERE produ.oid_prod = detalle.prod_oid_prod) cod_sap, ");
        query.append("       (SELECT i4.val_i18n ");
        query.append("          FROM v_gen_i18n_sicc i4 ");
        query.append("         WHERE i4.idio_oid_idio = " + idioma.toString() + " ");
        query.append("           AND i4.attr_num_atri = 1 ");
        query.append("           AND i4.attr_enti = 'MAE_PRODU' ");
        query.append("           AND i4.val_oid = detalle.prod_oid_prod) des_cort, ");
        query.append("       (SELECT estadoproce.des_tipo_esta_proc ");
        query.append("          FROM mav_tipo_estad_proce estadoproce ");
        query.append("         WHERE detalle.tepr_oid_tipo_esta_proc = ");
        query.append("                            estadoproce.oid_tipo_esta_proc) ");
        query.append("                                                           des_tipo_esta_proc, ");
        query.append("       (SELECT criterio.des_crit_asig ");
        query.append("          FROM mav_subcr_asign subcriterio, ");
        query.append("               mav_crite_asign criterio ");
        query.append("         WHERE subcriterio.cras_oid_crit_asig = criterio.oid_crit_asig ");
        query.append("           AND subcriterio.oid_subc = detalle.scas_oid_subc) des_crit_asig, ");
        query.append("       '' subtipo, ");
        query.append("       (SELECT i2.val_i18n ");
        query.append("          FROM v_gen_i18n_sicc i2 ");
        query.append("         WHERE i2.attr_enti = 'MAE_TIPO_CLASI_CLIEN' ");
        query.append("           AND i2.attr_num_atri = 1 ");
        query.append("           AND i2.idio_oid_idio = " + idioma.toString() + " ");
        query.append("           AND i2.val_oid = detalle.tccl_oid_tipo_clas) tipoclasi, ");
        query.append("       (SELECT i3.val_i18n ");
        query.append("          FROM v_gen_i18n_sicc i3 ");
        query.append("         WHERE i3.attr_enti = 'MAE_CLASI' ");
        query.append("           AND i3.attr_num_atri IN (1, 4) ");
        query.append("           AND i3.idio_oid_idio = " + idioma.toString() + " ");
        query.append("           AND i3.val_oid = detalle.clas_oid_clas) clasi, ");
        query.append("       '' accesos, '' subaccesos, ");
        query.append("       (SELECT p2.val_nomb_peri ");
        query.append("          FROM cra_perio p2 ");
        query.append("         WHERE p2.oid_peri = detalle.perd_oid_peri_fina) val_nomb_peri, ");
        query.append("         detalle.NUM_UNID_ESTI UNID_ESTI, ");
        query.append("         detalle.num_unid_clie UNID_CLIE, ");
        query.append("         detalle.NUM_UNID_TOTA UNID_TOTA ");
        query.append("  FROM mav_detal_mav detalle ");
        query.append(" WHERE detalle.ticl_oid_tipo_clie = " + tipoCliente.toString() + " ");
        query.append("   AND detalle.perd_oid_peri = " + periodo.toString() + " ");
        query.append("   AND (   (    detalle.tepr_oid_tipo_esta_proc = 1 ");
        // Preguntar si el NULL es necesario
        //query.append("            AND detalle.acti_oid_acti IS NULL ");
        query.append("            AND EXISTS ( ");
        query.append("                   SELECT 1 ");
        query.append("                     FROM mav_activ_ciclo_vida ciclovidaacti ");
        query.append("                    WHERE ciclovidaacti.acti_oid_acti = " + actividad.toString() + " ");
        query.append("                      AND ciclovidaacti.civi_oid_cicl_vida = ");
        query.append("                                                    detalle.civi_oid_cicl_vida) ");
        query.append("            AND EXISTS ( ");
        query.append("                   SELECT 1 ");
        query.append("                     FROM mav_activ_tipo_ofert tipoofertaacti ");
        query.append("                    WHERE tipoofertaacti.acti_oid_acti = " + actividad.toString() + " ");
        query.append("                      AND tipoofertaacti.tofe_oid_tipo_ofer = ");
        query.append("                                                    detalle.tofe_oid_tipo_ofer) ");
        query.append("           ) ");
        query.append("        OR (    detalle.tepr_oid_tipo_esta_proc = 2 ");
        query.append("            AND detalle.acti_oid_acti = " + actividad.toString() + " ");
        query.append("           ) ");
        query.append("        OR (    detalle.tepr_oid_tipo_esta_proc = 3 ");
        /*
         *  Comentado por incidencia SICC20070504 - Rafael Romero - 13/11/2007
        query.append("            AND NOT EXISTS ( ");
        query.append("                          SELECT 1 ");
        query.append("                            FROM mav_envio envio ");
        query.append("                           WHERE envio.denv_oid_deta_mav = ");
        query.append("                                                          detalle.oid_deta_mav) ");
        */
        query.append("            AND detalle.acti_oid_acti = " + actividad.toString() + " ");
        query.append("           ) ");
        query.append("        OR (    detalle.tepr_oid_tipo_esta_proc = 4 ");
        query.append("            AND detalle.acti_oid_acti = " + actividad.toString() + " ");
        query.append("           ) ");
        query.append("       ) ");
        if(codigoSAP!=null && codigoSAP.length()>0){
            query.append("   AND (SELECT produ.cod_sap ");
            query.append("          FROM mae_produ produ ");
            query.append("         WHERE produ.oid_prod = detalle.prod_oid_prod) LIKE '"+codigoSAP+"' ");
        }
        if(unidades!=null){
            query.append("     AND (   detalle.num_unid_esti = "+unidades.toString()+" ");
            query.append("          OR detalle.num_unid_clie = "+unidades.toString()+" ");
            query.append("          OR detalle.num_unid_tota = "+unidades.toString()+" ");
            query.append("         ) ");
        }

        //String selectClause = query.toString();

        //UtilidadesLog.debug("selectClause devuelta: " + selectClause);
        UtilidadesLog.info("DAODetalleMAV.armaQueryPrincipal(Long actividad, Long periodo, Long tipoCliente, Long idioma, String codigoSAP, BigDecimal unidades):Salida");
        return query.toString();
    }

    private String armaQuerySubacceso(Long[] oids, Long idioma)
    {
        UtilidadesLog.info("DAODetalleMAV.armaQuerySubacceso(Long[] oids, Long idioma):Entrada");
        // Se presupone que oids al menos tiene un valor, si no ni se llamaria a esta funcion
        StringBuffer query = new StringBuffer("");
        
        query.append(" SELECT detalle.oid_deta_mav, i1.val_i18n ");
        query.append(" FROM mav_detal_mav detalle, ");
        query.append(" mav_detal_mav_acces_subac mavsubac, ");
        query.append(" seg_subac subac, ");
        query.append(" v_gen_i18n_sicc i1 ");
        //query.append(" WHERE detalle.oid_deta_mav = 222 ");
        query.append(" WHERE detalle.oid_deta_mav = mavsubac.denv_oid_deta_mav ");
        query.append(" AND mavsubac.sbac_oid_sbac = subac.oid_sbac ");
        query.append(" AND i1.attr_enti = 'SEG_SUBAC' ");
        query.append(" AND i1.attr_num_atri = 1 ");
        query.append(" AND i1.idio_oid_idio = " + idioma.toString() );
        query.append(" AND i1.val_oid = subac.oid_sbac ");

        for (int i = 0; i < oids.length; i++)
        {
          if (i == 0)  // Abre el parentésis si es el primer elemento
            query.append(" AND (");

          if (i != 0) // Si es cualquier otro excepto el primero, antepone un OR
            query.append(" OR ");

          query.append(" detalle.oid_deta_mav = " + oids[i].toString() );

          if ( i == (oids.length-1) ) // Si es el ultimo elemento, cierra el parentesis.
            query.append(" ) ");
        }

        query.append(" ORDER BY detalle.oid_deta_mav ASC ");
        
        UtilidadesLog.debug("Query Subacceso: " + query.toString() );
        UtilidadesLog.info("DAODetalleMAV.armaQuerySubacceso(Long[] oids, Long idioma):Salida");        
        return query.toString(); 

    }

    private String armaQueryAcceso(Long[] oids, Long idioma)
    {
        UtilidadesLog.info("DAODetalleMAV.armaQueryAcceso(Long[] oids, Long idioma):Entrada");
        // Se presupone que oids al menos tiene un valor, si no ni se llamaria a esta funcion
        StringBuffer query = new StringBuffer("");
        
        query.append(" SELECT detalle.oid_deta_mav, i1.val_i18n ");
        query.append(" FROM mav_detal_mav detalle, ");
        query.append(" mav_detal_mav_acces_subac mavsubac, ");
        query.append(" seg_subac subac, ");
        query.append(" v_gen_i18n_sicc i1 ");
        //query.append(" WHERE detalle.oid_deta_mav = 222 ");
        query.append(" WHERE detalle.oid_deta_mav = mavsubac.denv_oid_deta_mav ");
        query.append(" AND mavsubac.sbac_oid_sbac = subac.oid_sbac ");
        query.append(" AND i1.attr_enti = 'SEG_ACCES' ");
        query.append(" AND i1.attr_num_atri = 1 ");
        query.append(" AND i1.idio_oid_idio = " + idioma.toString() );
        query.append(" AND i1.val_oid = subac.ACCE_OID_ACCE ");

        for (int i = 0; i < oids.length; i++)
        {
          if (i == 0)  // Abre el parentésis si es el primer elemento
            query.append(" AND (");

          if (i != 0) // Si es cualquier otro excepto el primero, antepone un OR
            query.append(" OR ");

          query.append(" detalle.oid_deta_mav = " + oids[i].toString() );

          if ( i == (oids.length-1) ) // Si es el ultimo elemento, cierra el parentesis.
            query.append(" ) ");
        }

        query.append(" ORDER BY detalle.oid_deta_mav ASC ");        

        UtilidadesLog.debug("Query Acceso: " + query.toString() );
        UtilidadesLog.info("DAODetalleMAV.armaQueryAcceso(Long[] oids, Long idioma):Salida");
        return query.toString();     
  
    }

    private String armaQueryCicloVida(Long[] oids, Long idioma)
    {
        UtilidadesLog.info("DAODetalleMAV.armaQueryCicloVida(Long[] oids, Long idioma):Entrada");
        // Se presupone que oids al menos tiene un valor, si no ni se llamaria a esta funcion
        StringBuffer query = new StringBuffer("");
        
        query.append(" SELECT detalle.oid_deta_mav, i1.val_i18n ");
        query.append(" FROM mav_detal_mav detalle, ");
        query.append(" mav_activ_ciclo_vida ciclovida, ");
        query.append(" v_gen_i18n_sicc i1 ");
        //query.append(" WHERE detalle.oid_deta_mav = 222 ");
        query.append(" where detalle.ACTI_OID_ACTI = ciclovida.ACTI_OID_ACTI ");
        query.append(" and ciclovida.CIVI_OID_CICL_VIDA = i1.VAL_OID ");
        query.append(" and i1.ATTR_ENTI = 'PRE_CICLO_VIDA' ");
        query.append(" and i1.ATTR_NUM_ATRI = 1 ");
        query.append(" and i1.IDIO_OID_IDIO = " + idioma.toString() );

        for (int i = 0; i < oids.length; i++)
        {
          if (i == 0)  // Abre el parentésis si es el primer elemento
            query.append(" AND (");

          if (i != 0) // Si es cualquier otro excepto el primero, antepone un OR
            query.append(" OR ");

          query.append(" detalle.oid_deta_mav = " + oids[i].toString() );

          if ( i == (oids.length-1) ) // Si es el ultimo elemento, cierra el parentesis.
            query.append(" ) ");
        }

        query.append(" ORDER BY detalle.oid_deta_mav ASC ");

        UtilidadesLog.debug("Query Ciclo Vida: " + query.toString() );
        UtilidadesLog.info("DAODetalleMAV.armaQueryCicloVida(Long[] oids, Long idioma):Salida");
        return query.toString();         
    }    

    private String armaQuerySubtipo(Long[] oids, Long idioma)
    {
        UtilidadesLog.info("DAODetalleMAV.armaQuerySubtipo(Long[] oids, Long idioma):Entrada");
        // Se presupone que oids al menos tiene un valor, si no ni se llamaria a esta funcion
        StringBuffer query = new StringBuffer("");
        
        query.append(" SELECT detalle.oid_deta_mav, ");
        query.append("		  (SELECT val_i18n ");
        query.append("           FROM v_gen_i18n_sicc i ");
        query.append("          WHERE i.attr_enti = 'MAE_SUBTI_CLIEN' ");
        query.append("	 		  AND i.attr_num_atri = 1 ");
        query.append("     		  AND i.idio_oid_idio = " + idioma.toString() );
        query.append("     		  AND i.val_oid = subtipo.oid_subt_clie) i1 ");
        query.append("	 FROM mav_detal_mav detalle, ");
        query.append("		  mav_subti_clien_detal mavsubti, ");
        query.append("		  mae_subti_clien subtipo ");
        query.append("	WHERE detalle.oid_deta_mav = mavsubti.denv_oid_deta_mav ");
        query.append("    AND mavsubti.sbti_oid_subt_clie = subtipo.oid_subt_clie ");

        for (int i = 0; i < oids.length; i++) {
          if (i == 0)  // Abre el parentésis si es el primer elemento
            query.append(" AND (");

          if (i != 0) // Si es cualquier otro excepto el primero, antepone un OR
            query.append(" OR ");

          query.append(" detalle.oid_deta_mav = " + oids[i].toString() );

          if ( i == (oids.length-1) ) // Si es el ultimo elemento, cierra el parentesis.
            query.append(" ) ");
        }

        query.append(" ORDER BY detalle.oid_deta_mav ASC ");

        UtilidadesLog.debug("Query Ciclo Vida: " + query.toString() );
        UtilidadesLog.info("DAODetalleMAV.armaQuerySubtipo(Long[] oids, Long idioma):Salida");
        return query.toString();   
    }
	
    private String armaQueryTipoOferta(Long[] oids, Long idioma)
    {
        UtilidadesLog.info("DAODetalleMAV.armaQueryTipoOferta(Long[] oids, Long idioma):Entrada");
        // Se presupone que oids al menos tiene un valor, si no ni se llamaria a esta funcion
        StringBuffer query = new StringBuffer("");
        
        query.append(" SELECT   detalle.oid_deta_mav, i1.val_i18n ");
        query.append(" FROM mav_detal_mav detalle, ");
        query.append(" mav_activ_tipo_ofert oferta, ");
        query.append(" v_gen_i18n_sicc i1 ");

        query.append(" WHERE detalle.acti_oid_acti = oferta.acti_oid_acti ");
        query.append(" AND oferta.TOFE_OID_TIPO_OFER = i1.val_oid ");
        query.append(" AND i1.attr_enti = 'PRE_TIPO_OFERT' ");
        query.append(" AND i1.attr_num_atri = 1 ");
        query.append(" AND i1.idio_oid_idio = " + idioma.toString() );

        for (int i = 0; i < oids.length; i++)
        {
          if (i == 0)  // Abre el parentésis si es el primer elemento
            query.append(" AND (");

          if (i != 0) // Si es cualquier otro excepto el primero, antepone un OR
            query.append(" OR ");

          query.append(" detalle.oid_deta_mav = " + oids[i].toString() );

          if ( i == (oids.length-1) ) // Si es el ultimo elemento, cierra el parentesis.
            query.append(" ) ");
        }

        query.append(" ORDER BY detalle.oid_deta_mav ASC ");

        UtilidadesLog.debug("Query Tipo Oferta: " + query.toString() );
        UtilidadesLog.info("DAODetalleMAV.armaQueryTipoOferta(Long[] oids, Long idioma):Salida");
        return query.toString();         
    }        


    private RecordSet concatena(RecordSet r)
    {
      UtilidadesLog.info("DAODetalleMAV.concatena(RecordSet r):Entrada");
      StringBuffer concat = new StringBuffer("");
      HashMap hash = new HashMap();
      
      RecordSet rToReturn = new RecordSet();
      Vector v = new Vector();
      v.add("OID");
      v.add("DESC");
      
      rToReturn.setColumnIdentifiers(v);

      if (!r.esVacio() )
      {
          // *******************************************
          // Primero unimos los String para un mismo oid
          // *******************************************
        
          Long oidAntiguo = new Long( ((BigDecimal) r.getValueAt(0,0)).longValue() );
          int cantFilas = r.getRowCount();
          UtilidadesLog.debug("r: " + r);
          for (int i = 0; i < cantFilas; i++)
          {
            String texto = (String) r.getValueAt(i,1);
            Long oidActual = new Long ( ((BigDecimal) r.getValueAt(i,0)).longValue() );

            String textoExistente = (String) hash.get(oidActual);
            if (textoExistente == null)
              textoExistente = texto;
            else
              textoExistente = textoExistente + ", " + texto;

            hash.put(oidActual, textoExistente);
            
          }

          // *************************************
          // Ahora armamos el REcordSet de Salida
          // *************************************
          Hashtable hsh = new Hashtable((Map) hash);
          UtilidadesLog.debug("hsh: " + hsh);

          UtilidadesLog.debug("HashMap: " + hash.toString() );

          Enumeration enumKeys = hsh.keys();
          while (enumKeys.hasMoreElements() )
          {
            // Obtiene los valores del hashTable y los mete en el REcordset, fila x fila.
            Long oid = (Long) enumKeys.nextElement();
            String valor = (String)hsh.get(oid);
            Vector fila = new Vector();
            fila.add(oid);
            fila.add(valor);
            rToReturn.addRow(fila);
          }

          UtilidadesLog.debug("rToReturn: " + rToReturn);
          
      }
      UtilidadesLog.info("DAODetalleMAV.concatena(RecordSet r):Salida");
      return rToReturn;
    }


    private Long[] obtieneOids(RecordSet r)
    {
      // Recorre el RecordSet y devuelve un array de Longs con los elementos de la primer
      // columna (los oids)
      UtilidadesLog.info("DAODetalleMAV.obtieneOids(RecordSet r):Entrada");
      Vector v = new Vector(); 

      for (int i = 0; i < r.getRowCount(); i++)
      {
        BigDecimal b = (BigDecimal)  r.getValueAt(i,0);
        Long oid = new Long( b.longValue() );
        v.add(oid);
      }

      Long[] array = (Long[])v.toArray(new Long[v.size()]);
//      Long[] array = (Long) v.
      UtilidadesLog.info("DAODetalleMAV.obtieneOids(RecordSet r):Salida");
      return array;
      
    }


    private RecordSet agregaValoresConcatenados(RecordSet rPrincipal, RecordSet toAdd, int columna) throws MareException
    {
      // Le agrega a "rPrincipal", para la columna "columna", los valores de "toAdd"
      // Nota: se agrega registro a registro, cuando coinciden oids de DetalleMAV
      // en ambos RecordSet.
      // Devuelve el RecordSet cambiado.
      UtilidadesLog.info("DAODetalleMAV.agregaValoresConcatenados(RecordSet rPrincipal, RecordSet toAdd, int columna):Entrada");
      int cantRegistros = rPrincipal.getRowCount();
      int cantRegistrosSec = toAdd.getRowCount();

      if (cantRegistrosSec != 0)
      {
         for (int i=0; i < cantRegistros; i++) // Recorre el RecordSet Principal
         {
            Long oid = new Long( ((BigDecimal) rPrincipal.getValueAt(i,0)).longValue());
            for (int j = 0; j < cantRegistrosSec; j++)
            {
              Long oidSec = (Long) toAdd.getValueAt(j,0);
              if (oidSec.equals(oid))
              {
                  // Cuando los oid coinciden, agrega a "rPrincipal" el valor de la fila Desc de "toAdd",
                  // en la columna "columna"
                  String desc = (String) toAdd.getValueAt(j,1);
                  rPrincipal.setValueAt(desc, i, columna);
              }
            }
         }
      }

      UtilidadesLog.debug("Nuevo rPrincipal: " + rPrincipal);
      UtilidadesLog.info("DAODetalleMAV.agregaValoresConcatenados(RecordSet rPrincipal, RecordSet toAdd, int columna):Salida");
      return rPrincipal;
      
    }

    public RecordSet obtenerParametrizacionMAV(Long pais)  throws MareException
    {
      UtilidadesLog.info("DAODetalleMAV.obtenerParametrizacionMAV(Long pais):Entrada");
      StringBuffer query = new StringBuffer("");

      query.append(" SELECT param.ticl_oid_tipo_clie_regi, regio.sbti_oid_subt_clie ");
      query.append(" FROM mav_param param, mav_param_geren_regio regio ");
      query.append(" WHERE param.pais_oid_pais = " + pais.toString() );
      query.append(" AND regio.parm_oid_para_mav = param.oid_para_mav ");
      query.append("      UNION ");
      query.append(" SELECT param.ticl_oid_tipo_clie_zona, zona.sbti_oid_subt_clie ");
      query.append(" FROM mav_param param, mav_param_geren_zona zona ");
      query.append(" WHERE param.pais_oid_pais = " + pais.toString() ); 
      query.append(" AND zona.parm_oid_para_mav = param.oid_para_mav ");

      RecordSet r = null;
      BelcorpService bs = BelcorpService.getInstance();

      try {
        r = bs.dbService.executeStaticQuery( query.toString() );
      } catch (Exception ex)
      {
        UtilidadesLog.debug("Exception al consultar en obtenerParametrizacionMAV");
        UtilidadesLog.error(ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("--- Recordset a devolver en obtenerParametrizacionMAV: " + r);
      UtilidadesLog.info("DAODetalleMAV.obtenerParametrizacionMAV(Long pais):Salida");
      return r;
      
    }
    
    
  /**
   * @author: ssantana, 26/7/2005, inc. 
   * @throws java.lang.Exception
   * @return Long
   * @param Long pais
   * @param Long acceso
   * @param Long canal
   * @param Long nCampanya
   * @param Long oidPeriodoPivot
   */
    private Long obtieneOidPeriodoAnteriorPorCampanya(Long oidPeriodoPivot, Integer nCampanya, Long canal, Long marca, Long pais) 
      throws Exception {

        /*
         *  Busca tantos periodos anteriores a "periodoPivot", para el Canal, Acceso y Pais, como
         *  indique "nCampanya", ordenados en forma descendente.
         *  Siempre el primer registro retornado contendrá el "n" período buscado.
         */
      
        UtilidadesLog.info("DAODetalleMAV.obtieneOidPeriodoAnteriorPorCampanya(Long oidPeriodoPivot, Integer nCampanya, Long canal, Long marca, Long pais):Entrada");  
        StringBuffer sqlQuery = new StringBuffer("");
        Long oidPeriodoRetorno = null;
        
        // Le quito el signo a nCampanya.
        nCampanya = new Integer( Math.abs(nCampanya.intValue()) );

        // Armo la query.
        sqlQuery.append(" SELECT ROWNUM, a.oid_peri ");
        sqlQuery.append(" FROM (SELECT cra_perio.oid_peri ");
        sqlQuery.append("       FROM cra_perio ");
        sqlQuery.append("       WHERE cra_perio.fec_fina < (SELECT cra_perio.fec_inic ");
        sqlQuery.append("                    FROM cra_perio ");
        sqlQuery.append("                    WHERE cra_perio.oid_peri = " + oidPeriodoPivot + ") ");
        sqlQuery.append("                        AND cra_perio.cana_oid_cana = " + canal );
        sqlQuery.append("                        AND cra_perio.MARC_OID_MARC = " + marca );
        sqlQuery.append("                        AND cra_perio.pais_oid_pais = " + pais );
        sqlQuery.append("                   ORDER BY cra_perio.fec_fina DESC) a ");
        sqlQuery.append(" WHERE ROWNUM <= " + nCampanya);
        sqlQuery.append(" ORDER BY ROWNUM DESC ");
        
        try {
           BelcorpService bs = BelcorpService.getInstance();
           RecordSet r = bs.dbService.executeStaticQuery( sqlQuery.toString() );
           UtilidadesLog.debug("r: " + r);
           BigDecimal bigBuffer = (BigDecimal) r.getValueAt(0,1);
           oidPeriodoRetorno = new Long( bigBuffer.longValue() );
        } catch (Exception ex) {
           UtilidadesLog.error(ex);
           String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
           throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAODetalleMAV.obtieneOidPeriodoAnteriorPorCampanya(Long oidPeriodoPivot, Integer nCampanya, Long canal, Long marca, Long pais):Salida");
        return oidPeriodoRetorno;
    }
    
  /**
   * @author: ssantana, 26/7/2005
   * @throws java.lang.Exception
   * @return Long
   * @param Long pais
   * @param Long marca
   * @param Long canal
   * @param Long nCampanya
   * @param Long oidPeriodoPivot
   */
    private Long obtieneOidPeriodoPosteriorPorCampanya(Long oidPeriodoPivot, Integer nCampanya, Long canal, Long marca, Long pais) 
      throws Exception {
   
      UtilidadesLog.info("DAODetalleMAV.obtieneOidPeriodoPosteriorPorCampanya(Long oidPeriodoPivot, Integer nCampanya, Long canal, Long marca, Long pais):Entrada");
      StringBuffer sqlQuery = new StringBuffer("");
      Long oidPeriodoRetorno = null;
      
      nCampanya = new Integer( Math.abs(nCampanya.intValue()) ) ;
      
      sqlQuery.append(" SELECT   ROWNUM, a.oid_peri ");
      sqlQuery.append(" FROM (SELECT   cra_perio.oid_peri ");
      sqlQuery.append("       FROM cra_perio ");
      /* mdolce 22/01/2007 MAV-15 se cambia el fec_fina por fec_inic porque sino en periodos cruzados se deja 
       * afuera la campaña siguiente*/
      sqlQuery.append("       WHERE cra_perio.fec_inic > (SELECT cra_perio.fec_inic ");
      sqlQuery.append("                                   FROM cra_perio ");
      sqlQuery.append(" WHERE cra_perio.oid_peri = " + oidPeriodoPivot + ") ");
      sqlQuery.append(" AND cra_perio.cana_oid_cana = " + canal);
      sqlQuery.append(" AND cra_perio.marc_oid_marc = " + marca);
      sqlQuery.append(" AND cra_perio.pais_oid_pais = " + pais);
      sqlQuery.append(" ORDER BY cra_perio.fec_inic ASC) a ");
      sqlQuery.append(" WHERE ROWNUM <= " + nCampanya);
      sqlQuery.append(" ORDER BY ROWNUM DESC ");
      
      try {
         BelcorpService bs = BelcorpService.getInstance();
         RecordSet r = bs.dbService.executeStaticQuery( sqlQuery.toString() );
         UtilidadesLog.debug("r: " + r);
         BigDecimal bigBuffer = (BigDecimal) r.getValueAt(0,1);
         oidPeriodoRetorno = new Long( bigBuffer.longValue() );
      } catch (Exception ex) {
         UtilidadesLog.error(ex);
         String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }
      UtilidadesLog.info("DAODetalleMAV.obtieneOidPeriodoPosteriorPorCampanya(Long oidPeriodoPivot, Integer nCampanya, Long canal, Long marca, Long pais):Salida");
      return oidPeriodoRetorno;
      
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
       
       UtilidadesLog.info("DAODetalleMAV.armaClausulaIN(Object[] array):Entrada");
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
       UtilidadesLog.info("DAODetalleMAV.armaClausulaIN(Object[] array):Salida");
       return sCadena;
   }
   
   
  /**
   * @author: ssantana, 09/01/2006, inc. BELC300021972
   * @throws java.lang.Exception
   * @return RecordSet 
   * @param Long oidPais
   */
   public RecordSet obtieneParametrizacionSubtiposMAV(Long oidPais) 
          throws MareException {
      UtilidadesLog.info("DAODetalleMAV.obtieneParametrizacionSubtiposMAV" + 
                       "(Long oidPais):Entrada");    
      RecordSet r = null;
      
      try {
          BelcorpService bs = BelcorpService.getInstance();
          StringBuffer sqlQuery = new StringBuffer("");
          
          sqlQuery.append(" SELECT mav_param_geren_regio.sbti_oid_subt_clie, ");
          sqlQuery.append(" mav_param_geren_zona.sbti_oid_subt_clie ");
          sqlQuery.append(" FROM mav_param, mav_param_geren_regio, ");
          sqlQuery.append("      mav_param_geren_zona ");
          sqlQuery.append(" WHERE mav_param.pais_oid_pais = " + oidPais);
          sqlQuery.append(" AND mav_param_geren_regio.parm_oid_para_mav = ");
          sqlQuery.append("                           mav_param.oid_para_mav ");
          sqlQuery.append(" AND mav_param_geren_zona.parm_oid_para_mav = ");
          sqlQuery.append("                           mav_param.oid_para_mav ");
          
          r = bs.dbService.executeStaticQuery(sqlQuery.toString());
          UtilidadesLog.debug("r: " + r);
      
      } catch (Exception ex) {
         UtilidadesLog.debug(ex);
         UtilidadesLog.error(ex);
         String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }
      UtilidadesLog.info("DAODetalleMAV.obtieneParametrizacionSubtiposMAV" + 
                       "(Long oidPais):Salida");    
      return r;
   
   }
   public DTOSalida desProducto(DTODetalleMAV dtoe)throws MareException{
             UtilidadesLog.info("DAODetalleMAV.desProducto(DTODEtalleMav dtoe): Entrada");
               RecordSet rs = new RecordSet();
               StringBuffer query = new StringBuffer();                  
               BelcorpService bs;
               DTOSalida dtoSalida = new DTOSalida();               
               try{
                       bs = BelcorpService.getInstance();
                      
               } catch(Exception e ){                       
                          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
              }
              query.append(" SELECT  I18N.VAL_OID, I18N.VAL_I18N ");
              query.append("       FROM GEN_I18N_SICC I18N, MAE_PRODU  ");
              query.append("            WHERE I18N.ATTR_ENTI = 'MAE_PRODU' ");
              query.append("                  AND I18N.IDIO_OID_IDIO = 1  ");
              query.append("                  AND I18N.ATTR_NUM_ATRI = 1 ");
              query.append("                  AND I18N.VAL_OID = MAE_PRODU.OID_PROD ");
              query.append("                  AND MAE_PRODU.COD_SAP =  '" + dtoe.getProdCodSAP() + "'");
              try{
                    rs = bs.dbService.executeStaticQuery(query.toString());
                         
              } catch (Exception ex) {
                         
                            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
              if( !rs.esVacio() )
              {
                  dtoSalida.setResultado(rs);       
                   UtilidadesLog.info("DAODetalleMAV.desProducto(DTODEtalleMav dtoe): Salida");
                  return dtoSalida;                
               }else
              {
                   throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT + ErroresDeNegocio.REC_0010));
              }

             
   }
   
   
   
}