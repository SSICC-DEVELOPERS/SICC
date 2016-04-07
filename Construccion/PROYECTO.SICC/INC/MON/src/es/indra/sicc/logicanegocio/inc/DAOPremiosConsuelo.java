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
 * @autor: Paola Cabrera
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOConsultarPremiosConsuelo;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

public class DAOPremiosConsuelo {
    private String usuario;

    public DAOPremiosConsuelo() {
    }

    public DAOPremiosConsuelo(String usuario) {
        this.usuario = usuario;
    }

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param DTOE
    * @author Paola Cabrera
    * @fecha 13/07/2005
    */
    public RecordSet obtenerEnviarA(DTOBelcorp DTOE) throws MareException {
        /* 
         * Realiza una consulta utilizando el servicio DBService
               Hacer la consulta sobre la tabla perteneciente a la
               entidad INC:ENVIARA
               El RecordSet debe tener los siguientes campos:
               oid
               descripcion (internacionalizable)
               Retornar el RecordSet
         *
         */
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerEnviarA(DTOBelcorp DTOE)"
            +":Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();

        query.append(" SELECT inc_env.OID_ENVI as oid_Envia, ");
        query.append(" i1.val_i18n as descripcion ");
        query.append(" FROM v_gen_i18n_sicc i1, ");
        query.append(" INC_ENVIA inc_env ");
        query.append(" WHERE i1.attr_enti = 'INC_ENVIA' ");
        query.append(" AND i1.attr_num_atri = 1 ");
        query.append(" AND i1.val_oid = inc_env.OID_ENVI ");
        query.append(" AND i1.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" ORDER BY descripcion ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerEnviarA(DTOBelcorp DTOE)"
            +":Salida");
        return rs;
    }

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param DTOE
    * @author Paola Cabrera
    * @fecha 13/07/2005
    */
    public RecordSet obtenerMotivosPremiosConsuelo(DTOBelcorp DTOE)
            throws MareException {
        /*
         * //Realiza una consulta utilizando el servicio DBService
               Hacer la consulta sobre la tabla INC_MOTIV_PREMI_CONSU
               El RecordSet debe tener los siguientes campos:
               oid_motiv_prem_cons
               descripcion (internacionalizable)
               Retornar el RecordSet
         *
         */
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerMotivosPremiosConsuelo("
            +"DTOBelcorp DTOE):Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();

        query.append(" SELECT inc_premio_consu.OID_MOTI_PREM_CONS as  ");
        query.append("  oid_Premio, ");
        query.append(" i1.val_i18n as descripcion ");
        query.append(" FROM v_gen_i18n_sicc i1, ");
        query.append(" INC_MOTIV_PREMI_CONSU inc_premio_consu ");
        query.append(" WHERE i1.attr_enti = 'INC_MOTIV_PREMI_CONSU' ");
        query.append(" AND i1.attr_num_atri = 1 ");
        query.append(" AND i1.val_oid = inc_premio_consu.OID_MOTI_PREM_CONS ");
        query.append(" AND i1.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" ORDER BY descripcion ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerMotivosPremiosConsuelo("
            +"DTOBelcorp DTOE):Salida");
        return rs;
    }

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param DTOE
    * @author Paola Cabrera
    * @fecha 13/07/2005
    */
    public RecordSet obtenerConcursoGanadoras(DTOBelcorp DTOE)
            throws MareException {
        /*
         * //Realiza una consulta utilizando el servicio DBService

           select distinct cpg.oid_para_gral, cpg.num_conc
           from inc_concu_param_gener cpg,
           inc_param_gener_premi pgp,
           inc_param_nivel_premi pnp,
           inc_ganad g
           where cpg.OID_PARA_GRAL = pgp.COPA_OID_PARA_GRAL
           and pgp.OID_PARA_GENE_PREM = pnp.PAGP_OID_PARA_GENE_PREM
           and pnp.OID_PARA_NIVE_PREM = g.PANP_OID_PARA_NIVE_PREM
           and cpg.PAIS_OID_PAIS = DTOE.get(pais);
           Retornar el RecordSet
         *
         */
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerConcursoGanadoras(DTOBel"
            +"corp DTOE):Entrada");
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();

        query.append(" SELECT DISTINCT cpg.oid_para_gral,  ");
        query.append("  cpg.num_conc ||' - '|| cpg.NUM_VERS descripcion ");
        query.append(" FROM inc_concu_param_gener cpg, ");
        query.append(" inc_param_gener_premi pgp, ");
        query.append(" inc_param_nivel_premi pnp, ");
        query.append(" inc_ganad g ");
        query.append(" WHERE cpg.oid_para_gral = pgp.copa_oid_para_gral ");
        query.append(" AND pgp.oid_para_gene_prem =  ");
        query.append(" pnp.pagp_oid_para_gene_prem ");
        query.append(" AND pnp.oid_para_nive_prem =  ");
        query.append(" g.panp_oid_para_nive_prem ");
        query.append(" AND cpg.pais_oid_pais = " + DTOE.getOidPais());
        query.append(" ORDER by descripcion ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerConcursoGanadoras(DTOBel"
            +"corp DTOE):Salida");
        return rs;
    }

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param DTOE
    * @author Paola Cabrera
    * @fecha 13/07/2005
    */
    public RecordSet obtenerClientesGanadoras(DTOBelcorp DTOE)
        throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerClientesGanadoras(DT"
            +"OBelcorp DTOE):Entrada");
        /*
         * //Realiza una consulta utilizando el servicio DBService
               select g.CLIE_OID_CLIE, c.VAL_NOM1||' '||c.VAL_NOM2||'
               '||c.VAL_APE1||' '||c.VAL_APE2
               from inc_ganad g,
               mae_clien c
               where g.CLIE_OID_CLIE = c.OID_CLIE
               and c.PAIS_OID_PAIS = DTOE.getPais()
               Retornar el RecordSet
         *
         */
        BelcorpService bs;
        RecordSet rs;
        String codigoError;

        StringBuffer query = new StringBuffer();

        query.append(" SELECT DISTINCT g.clie_oid_clie, ");
        query.append(" c.val_nom1 || ' ' || c.val_nom2 || ' ' ||  ");
        query.append("  c.val_ape1 || ' ' || c.val_ape2 descripcion ");
        query.append(" FROM inc_ganad g, mae_clien c ");
        query.append(" WHERE g.clie_oid_clie = c.oid_clie ");
        query.append(" AND c.pais_oid_pais = " + DTOE.getOidPais());
        //jrivas BLO-01
        query.append(" AND C.OID_CLIE NOT IN ( ");
        query.append(" SELECT DISTINCT CB.CLIE_OID_CLIE ");
        query.append(" FROM MAE_CLIEN_BLOQU CB, MAE_ACCIO_PROCE_BLOQU APB, MAE_ACCIO_BLOQU AB ");
        query.append(" WHERE CB.FEC_DESB IS NULL ");
        query.append(" AND APB.TIBQ_OID_TIPO_BLOQ = CB.TIBQ_OID_TIPO_BLOQ ");
        query.append(" AND APB.PAIS_OID_PAIS = " + DTOE.getOidPais());
        query.append(" AND AB.OID_ACCI_BLOQ = APB.MABL_OID_ACCI_BLOQ ");
        query.append(" AND AB.COD_ACCI_BLOQ = 'EN' ");
        query.append(" AND APB.MAPB_OID_PROC_BLOQ = (SELECT PB.OID_PROC_BLOQ ");
        query.append(" FROM MAE_PROCE_BLOQU PB ");
        query.append(" WHERE PB.COD_PROC_BLOQ = 'CO') ");
        query.append(" ) ");
        //jrivas BLO-01
        query.append(" ORDER by descripcion ");

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(
                codigoError));
        }
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerClientesGanadoras(DTOBel"
            +"corp DTOE):Salida");
        return rs;
    }

    /**
      * Sistema: Belcorp
      * Módulo:  INC
      * Fecha:   14/07/2005
      * @version 1.00
      * @autor   Diego Morello
      */
    public RecordSet obtenerClientesConcurso(DTOOID dtoE) throws MareException{
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerClientesConcurso(DTOOID "
            +"dtoE):Entrada");
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
        query.append("   cpg.OID_PARA_GRAL, ");
        query.append("   g.CLIE_OID_CLIE, ");
        query.append("   c.COD_CLIE  ");
        query.append(" FROM ");
        query.append("   INC_CONCU_PARAM_GENER  cpg,  ");
        query.append("   INC_PARAM_GENER_PREMI  pgp,  ");
        query.append("   INC_PARAM_NIVEL_PREMI  pnp,  ");
        query.append("   INC_GANAD g,  ");
        query.append("   MAE_CLIEN c  ");
        query.append(" WHERE ");
        query.append("   cpg.OID_PARA_GRAL = pgp.COPA_OID_PARA_GRAL  ");
        query.append("   AND pgp.OID_PARA_GENE_PREM =  ");
        query.append(" pnp.PAGP_OID_PARA_GENE_PREM  ");
        query.append("   AND pnp.OID_PARA_NIVE_PREM = ");
        query.append("   g.PANP_OID_PARA_NIVE_PREM  ");
        query.append("   AND cpg.oid_para_gral = " + dtoE.getOid());
        query.append("   AND cpg.PAIS_OID_PAIS = " + dtoE.getOidPais());
        query.append("   AND g.CLIE_OID_CLIE = c.OID_CLIE  ");
        //jrivas BLO-01 
        query.append("   AND C.OID_CLIE NOT IN ( ");
        query.append("   SELECT DISTINCT CB.CLIE_OID_CLIE ");
        query.append("   FROM MAE_CLIEN_BLOQU CB, MAE_ACCIO_PROCE_BLOQU APB, MAE_ACCIO_BLOQU AB ");
        query.append("   WHERE CB.FEC_DESB IS NULL ");
        query.append("   AND APB.TIBQ_OID_TIPO_BLOQ = CB.TIBQ_OID_TIPO_BLOQ ");
        query.append("   AND APB.PAIS_OID_PAIS = " + dtoE.getOidPais());
        query.append("   AND AB.OID_ACCI_BLOQ = APB.MABL_OID_ACCI_BLOQ ");
        query.append("   AND AB.COD_ACCI_BLOQ = 'EN' ");
        query.append("   AND APB.MAPB_OID_PROC_BLOQ = (SELECT PB.OID_PROC_BLOQ ");
        query.append("                                   FROM MAE_PROCE_BLOQU PB ");
        query.append("                                  WHERE PB.COD_PROC_BLOQ = 'CO')) ");
        //jrivas BLO-01 
        query.append("   GROUP BY cpg.OID_PARA_GRAL, g.CLIE_OID_CLIE, c.COD_CLIE ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerClientesConcurso(DTOOID "
            +"dtoE):Salida");
        return rs;
    }

    /**
      * Sistema: Belcorp
      * Módulo:  INC
      * Fecha:   14/07/2005
      * @version 1.00
      * @autor   Diego Morello
      * Modificado: Cristian Valenzuela
      * Fecha: 23/08/2006
      * Incidencia: BELC300023493
      */
    public Long validarConcurso(String nroConcurso, Long oidPais) throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.validarConcurso(String nroConcurso,"
            +"Long oidPais):Entrada");
        UtilidadesLog.debug("Metodo validarConcurso con nroConcurso: " 
            + nroConcurso);

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
            .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        query.append(" SELECT DISTINCT PGP.COPA_OID_PARA_GRAL, CPG.NUM_VERS ");
        query.append(" FROM INC_CONCU_PARAM_GENER CPG, ");
        query.append(" INC_PARAM_GENER_PREMI PGP, ");
        query.append(" INC_PARAM_NIVEL_PREMI PNP, ");
        query.append(" INC_GANAD GAN ");
        query.append(" WHERE CPG.NUM_CONC LIKE '" + nroConcurso + "' ");
		query.append(" AND CPG.PAIS_OID_PAIS = " + oidPais);
        query.append(" AND PGP.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        query.append(" AND PGP.OID_PARA_GENE_PREM = PNP.PAGP_OID_PARA_GENE_PREM ");
        query.append(" AND PNP.OID_PARA_NIVE_PREM = GAN.PANP_OID_PARA_NIVE_PREM ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
            .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }
        
        Long oidConcurso = null;
        UtilidadesLog.debug("+++++++ rs " + rs);        
        
        if(!rs.esVacio()) {            
            int cant = rs.getRowCount();    
            UtilidadesLog.debug("+++++++ cant " + cant);            
            
            if(cant==1) {
                BigDecimal oid = (BigDecimal)rs.getValueAt(0, "COPA_OID_PARA_GRAL");
                oidConcurso = new Long(oid.longValue());
            }
            else  {
                BigDecimal version = null;
                BigDecimal versionMayor = null;
                int j = 0;
                
                for(int i=0; i<cant; i++) {
                    version = (BigDecimal)rs.getValueAt(i, "NUM_VERS");
                    if(i==0) {
                        versionMayor = version;
                        j = i;
                    }
                    else {
                        if(version.intValue() > versionMayor.intValue())  {
                            versionMayor = version;
                            j = i;
                        }
                    }
                }
                
                BigDecimal oid = (BigDecimal)rs.getValueAt(j, "COPA_OID_PARA_GRAL");
                oidConcurso = new Long(oid.longValue());                
            }            
        }      
        
        UtilidadesLog.debug("+++++++ oidConcurso " + oidConcurso);            
        
        UtilidadesLog.info("DAOPremiosConsuelo.validarConcurso(String nroConcurso"
            +", Long oidPais):Salida");
            
        return oidConcurso;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   14/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public Boolean validarCliente(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.validarCliente(Long oidCliente)"
            +":Entrada");
        UtilidadesLog.debug("Metodo validarCliente con oidCliente: " 
            + oidCliente);

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

        query.append(" SELECT mc.OID_CLIE ");
        query.append(" FROM MAE_CLIEN mc");
        query.append(" WHERE mc.OID_CLIE = " + oidCliente);

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        // La consulta puede devolver a lo sumo 1 registro
        // Si no devuelve registros, la validación da "false"        
        boolean validar = rs.getRowCount() != 0;
        UtilidadesLog.info("DAOPremiosConsuelo.validarCliente(Long oidCliente)"
            +":Salida");
        return new Boolean(validar);
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   14/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public DTOBuzonMensajes obtenerVariablesClientes(DTOBuzonMensajes 
        dtoBuzonMensajes, Long oidConcurso) throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerVariablesClientes(DTOBuz"
            +"onMensajes dtoBuzonMensajes, Long oidConcurso):Entrada");
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

        DTOBuzonMensajes dtoBM = dtoBuzonMensajes;
        dtoBM.setOidCliente(dtoBuzonMensajes.getOidCliente());
        dtoBM.setOidPais(dtoBuzonMensajes.getOidPais());

        query.append(" SELECT m.VAL_NOM1, m.VAL_APE1, m.COD_CLIE ");
        query.append(" FROM MAE_CLIEN m ");
        query.append(" WHERE m.OID_CLIE = " + dtoBM.getOidCliente());
        query.append(" AND m.PAIS_OID_PAIS = " + dtoBM.getOidPais());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        dtoBM.setDatoVariable2(rs.getValueAt(0, "VAL_NOM1").toString());
        dtoBM.setDatoVariable3(rs.getValueAt(0, "VAL_APE1").toString());
        dtoBM.setDatoVariable4(rs.getValueAt(0, "COD_CLIE").toString());

        StringBuffer query2 = new StringBuffer();
        RecordSet rs2 = new RecordSet();

        query2.append(" SELECT ");
        query2.append("   z.COD_ZONA, ");
        query2.append("   t.COD_TERR, ");
        query2.append("   mc.campaniaInicio, ");
        query2.append("   mc.campaniaFin  ");
        query2.append(" FROM ");
        query2.append("   ZON_ZONA z,  ");
        query2.append("   ( SELECT ");
        query2.append("       cpg.MARC_OID_MARC, ");
        query2.append("       cpg.CANA_OID_CANA, ");
        query2.append("       s1.COD_PERI campaniaInicio, ");
        query2.append("       s2.COD_PERI campaniaFin  ");
        query2.append("     FROM ");
        query2.append("       INC_CONCU_PARAM_GENER cpg,  ");
        query2.append("       CRA_PERIO c1,  ");
        query2.append("       SEG_PERIO_CORPO s1,  ");
        query2.append("       CRA_PERIO c2,  ");
        query2.append("       SEG_PERIO_CORPO s2  ");
        query2.append("     WHERE ");
        query2.append("       cpg.OID_PARA_GRAL = " + oidConcurso);
        query2.append("       AND cpg.PERD_OID_PERI_DESD = c1.OID_PERI ");
        query2.append("       AND c1.PERI_OID_PERI = s1.OID_PERI  ");
        query2.append("       AND cpg.PERD_OID_PERI_DESD = c2.OID_PERI  ");
        query2.append("       AND c2.PERI_OID_PERI = s2.OID_PERI  ");
        query2.append("   ) mc,  ");
        query2.append("   MAE_CLIEN clien,  ");
        query2.append("   MAE_CLIEN_UNIDA_ADMIN cua,  ");
        query2.append("   ZON_TERRI_ADMIN ta,  ");
        query2.append("   ZON_TERRI t,  ");
        query2.append(" ZON_SECCI s  ");
        query2.append(" WHERE ");
        query2.append("   cua.CLIE_OID_CLIE = clien.OID_CLIE ");
        query2.append("   AND cua.IND_ACTI = 1  ");
        query2.append("   AND ta.CANA_OID_CANA = mc.CANA_OID_CANA ");
        query2.append("   AND ta.MARC_OID_MARC = mc.MARC_OID_MARC ");
        query2.append("   AND ta.OID_TERR_ADMI = cua.ZTAD_OID_TERR_ADMI ");
        query2.append("   AND ta.ZSCC_OID_SECC = s.OID_SECC  ");
        query2.append("   AND s.ZZON_OID_ZONA = z.OID_ZONA  ");
        query2.append("   AND ta.TERR_OID_TERR = t.OID_TERR ");
        query2.append("   AND clien.OID_CLIE = " + dtoBM.getOidCliente());
        query2.append("   AND clien.PAIS_OID_PAIS = " + dtoBM.getOidPais());

        try {
            rs2 = bs.dbService.executeStaticQuery(query2.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        dtoBM.setDatoVariable5(rs2.getValueAt(0, "COD_ZONA").toString());
        dtoBM.setDatoVariable6(rs2.getValueAt(0, "COD_TERR").toString());
        dtoBM.setDatoVariable7(rs2.getValueAt(0, "CAMPANIAINICIO").toString());
        dtoBM.setDatoVariable8(rs2.getValueAt(0, "CAMPANIAFIN").toString());
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerVariablesClientes(DTOBuz"
            +"onMensajes dtoBuzonMensajes, Long oidConcurso):Salida");
        return dtoBM;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   14/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public RecordSet obtenerMarcaCanal(Long oidCliente, Long oidPais)
            throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerMarcaCanal(Long oidClien"
            +"te, Long oidPais):Entrada");
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
        query.append("   terr.MARC_OID_MARC, ");
        query.append("   terr.CANA_OID_CANA, ");
        query.append("   terr.ZSCC_OID_SECC, ");
        query.append("   terr.TERR_OID_TERR ");
        query.append(" FROM ");
        query.append("   ZON_TERRI_ADMIN terr, ");
        query.append("   MAE_CLIEN_UNIDA_ADMIN cli ");
        query.append(" WHERE ");
        query.append("   cli.ZTAD_OID_TERR_ADMI = terr.OID_TERR_ADMI ");
        query.append("   AND terr.PAIS_OID_PAIS = " + oidPais);
        query.append("   AND cli.CLIE_OID_CLIE = " + oidCliente);
        query.append("   AND cli.IND_ACTI = 1 ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerMarcaCanal(Long oidClien"
            +"te, Long oidPais):Salida");
        return rs;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   14/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public Long obtenerTipoCliente(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerTipoCliente(Long oidClie"
            +"nte):Entrada");
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

        query.append(" SELECT cli.TICL_OID_TIPO_CLIE ");
        query.append(" FROM MAE_CLIEN_TIPO_SUBTI cli ");
        query.append(" WHERE cli.CLIE_OID_CLIE = " + oidCliente);
        query.append(" AND cli.IND_PPAL = 1  ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        Long tipo = new Long(((BigDecimal) rs
            .getValueAt(0, "TICL_OID_TIPO_CLIE")).longValue());
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerTipoCliente(Long oidClie"
            +"nte):Salida");
        return tipo;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   14/07/2005
     * @version 1.00
     * @autor   Diego Morello
     *
     * NOTA:
     * En la signatura del método se omitió el parámetro oidPais indicado en 
     * la documentación ya que no es necesario para efectuar la 
     * consulta...
     */
    public String obtenerCodClientePremiosConsuelo(Long oidCliente)
            throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerCodClientePremiosConsuel"
            +"o(Long oidCliente):Entrada");
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

        query.append(" SELECT cli.COD_CLIE ");
        query.append(" FROM MAE_CLIEN cli ");
        query.append(" WHERE cli.OID_CLIE = " + oidCliente);

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        String codCliente = rs.getValueAt(0, "COD_CLIE").toString();
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerCodClientePremiosConsuel"
            +"o(Long oidCliente):Salida");
        return codCliente;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   18/07/2005
     * @version 1.0
     * @autor   Diego Morello
     */
    public RecordSet obtenerNroConcursoPremiosConsuelo() throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerNroConcursoPremiosConsue"
            +"lo():Entrada");
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

        query.append(" SELECT DISTINCT ");
        query.append("   cpg.OID_PARA_GRAL, ");
        query.append("   cpg.NUM_CONC ");
        query.append(" FROM ");
        query.append("   INC_CONCU_PARAM_GENER cpg, ");
        query.append("   INC_CLIEN_PREMI_CONSU cpc ");
        query.append(" WHERE ");
        query.append("   cpc.COPA_OID_PARA_GRAL = cpg.OID_PARA_GRAL ");
        query.append("   ORDER BY NUM_CONC ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerNroConcursoPremiosConsue"
            +"lo():Salida");
        return rs;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   18/07/2005
     * @version 1.0
     * @autor   Diego Morello
     */
    public RecordSet obtenerArticulosPremioConsuelo() throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerArticulosPremioConsuelo"
            +"():Entrada");
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

        query.append(" SELECT DISTINCT ");
        query.append("   prod.OID_PROD, ");
        query.append("   prod.COD_SAP ");
        query.append(" FROM ");
        query.append("   INC_ARTIC_PREMI_CONSU art, ");
        query.append("   MAE_PRODU prod ");
        query.append(" WHERE ");
        query.append("   art.PROD_OID_PROD = prod.OID_PROD ");
        query.append("   ORDER BY COD_SAP ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }
        UtilidadesLog.info("DAOPremiosConsuelo.obtenerArticulosPremioConsuelo"
            +"():Salida");
        return rs;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   19/07/2005
     * @version 1.0
     * @autor   Diego Morello
     */
    public RecordSet consultarPremiosConsuelo(DTOConsultarPremiosConsuelo dtoE)
            throws MareException {
        UtilidadesLog.info("DAOPremiosConsuelo.consultarPremiosConsuelo(DTOCon"
            +"sultarPremiosConsuelo dtoE):Entrada");
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

        // vbongiov -- 12/09/2007
        query.append(" SELECT ");
        query.append("   prem.OID_PREM_CONS AS OID, ");
        query.append("   cpg.NUM_CONC, ");
        query.append("   cli.COD_CLIE, ");
        query.append("   v.VAL_I18N AS MOTI_PREM_CONS, ");
        query.append("   prem.NUM_UNID, ");
        query.append("   prem.NUM_DESP, ");
        query.append("   msg.COD_MENS, ");
        query.append("   prem.VAL_OBSE, ");
        query.append("   prod.COD_SAP, ");
        query.append("   art.IND_CENT_DIST_GARA, ");
        query.append("   vG.DES_CENT_SERV DESC_G, ");
        query.append("   art.NUM_MESE_GARA, ");
        query.append("   art.OBS_CENT_DIST, ");
        query.append("   art.IND_TIPO_ENTR_PREM, ");
        query.append("   vE.DES_CENT_SERV DESC_E ");
        query.append(" FROM ");
        query.append("   INC_PREMI_CONSU prem, ");
        query.append("   INC_ARTIC_PREMI_CONSU art, ");
        query.append("   INC_CLIEN_PREMI_CONSU cliPC, ");
        query.append("   INC_CONCU_PARAM_GENER cpg, ");
        query.append("   MAE_CLIEN cli, ");
        query.append("   MAE_CLIEN_UNIDA_ADMIN uni, ");
        query.append("   MAE_PRODU prod, ");
        query.append("   ZON_TERRI_ADMIN terr, ");
        query.append("   VCA_ZON_SECCI secc, ");
        query.append("   VCA_ZON_ZONA zona, ");
        query.append("   VCA_ZON_REGIO reg, ");
        query.append("   MSG_MENSA msg, ");
        query.append("   V_GEN_I18N_SICC v, ");
        query.append("   INC_CENTR_SERVI vG, ");
        query.append("   INC_CENTR_SERVI vE ");
        query.append(" WHERE ");
        query.append("   cliPC.COPA_OID_PARA_GRAL = cpg.OID_PARA_GRAL(+) ");
        query.append("   AND cliPC.CLIE_OID_CLIE = cli.OID_CLIE ");
        query.append("   AND prem.OID_PREM_CONS = cliPC.PRCO_OID_PREM_CONS ");
        query.append("   AND cli.OID_CLIE = uni.CLIE_OID_CLIE ");
        query.append("   AND uni.IND_ACTI = 1 ");

        // Internacionalización Motivo Premio Consuelo
        query.append("   AND v.VAL_OID = prem.MOPC_OID_MOTI_PREM_CONS ");
        query.append("   AND v.IDIO_OID_IDIO = " + dtoE.getOidIdioma());
        query.append("   AND v.ATTR_NUM_ATRI = 1 ");
        query.append("   AND v.ATTR_ENTI = 'INC_MOTIV_PREMI_CONSU' ");
        
        query.append("   AND vG.OID_CENT_SERV(+) = art.CESE_OID_CESE_GARA ");
        query.append("   AND vE.OID_CENT_SERV(+) = art.CESE_OID_CESE_ENTR ");

        // -----
        query.append("   AND prem.MENS_OID_MENS = msg.OID_MENS(+) ");
        query.append("   AND art.PRCO_OID_PREM_CONS = prem.OID_PREM_CONS ");
        query.append("   AND prod.OID_PROD = art.PROD_OID_PROD ");

        // Filtro por concurso y articulo según los parámetros del DTO
        if (dtoE.getNroConcurso() != null) {
            query.append("   AND cpg.OID_PARA_GRAL = " 
                + dtoE.getNroConcurso());
        }

        if (dtoE.getArticulo() != null) {
            query.append("   AND art.PROD_OID_PROD = " + dtoE.getArticulo());
        }

        // Joins de zonificación
        query.append("   AND uni.ZTAD_OID_TERR_ADMI = terr.OID_TERR_ADMI ");
        query.append("   AND terr.ZSCC_OID_SECC = secc.OID_SECC ");
        query.append("   AND secc.ZZON_OID_ZONA = zona.OID_ZONA ");
        query.append("   AND zona.ZORG_OID_REGI = reg.OID_REGI ");

        if (dtoE.getZona() != null) {
            query.append("   AND zona.OID_ZONA = " + dtoE.getZona());
        }

        if (dtoE.getRegion() != null) {
            query.append("   AND reg.OID_REGI = " + dtoE.getRegion());
        }

        // Filtro segun el usuario
        query.append("   AND secc.COD_USUA = '" + usuario + "' ");
        query.append("   AND zona.COD_USUA = '" + usuario + "' ");
        query.append("   AND reg.COD_USUA = '" + usuario + "' ");

        // Filtro por cliente
        if (dtoE.getOidCliente() != null) {
            query.append("   AND cli.OID_CLIE = " + dtoE.getOidCliente());
        }

        String queryPag = UtilidadesPaginacion.armarQueryPaginacion(
            query.toString(), dtoE);

        try {
            rs = bs.dbService.executeStaticQuery(queryPag);
            UtilidadesLog.debug("Resultado: " + rs.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        if ((rs == null) || rs.esVacio()) {
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(new Exception(), error);
        }   
        UtilidadesLog.info("DAOPremiosConsuelo.consultarPremiosConsuelo(DTOCon"
            +"sultarPremiosConsuelo dtoE):Salida");
        return rs;
    }
}