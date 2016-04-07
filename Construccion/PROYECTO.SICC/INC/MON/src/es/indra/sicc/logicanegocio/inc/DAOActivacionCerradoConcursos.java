package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.batch.util.ConfigFactory;
import es.indra.sicc.dtos.inc.DTOBuscarConcursos;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

public class DAOActivacionCerradoConcursos  {
    public DAOActivacionCerradoConcursos() {
    }

    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080621 - dmorello, 22/09/2008
     *     - Se filtra en CRA_PERIO por el periodo recibido en el dtoe
     *       Si no se recibe periodo, se busca aquel cuya fecha inicio es la del sistema
     *     - Se agrega recuperacion de numero de concurso
     * 
     * @author: ssantana, 23/05/2006
     * @return RecordSet
     * @param DTOBuscarConcursos dtoe
     */
    public RecordSet obtenerConcursosActivar(DTOBuscarConcursos dtoe)
            throws MareException {
        UtilidadesLog.info("DAOActivacionCerradoConcursos.obtenerConcursosActivar " +
                            "(DTOBuscarConcursos dtoe):Entrada");
                            
        StringBuffer sqlQuery = new StringBuffer("");
        String sIndActivo = null;
        RecordSet rRetorno = null;
        
        if ( dtoe.getIndActivo().booleanValue() ) {
            sIndActivo = "1";
        } else {
            sIndActivo = "0";
        }
        
        sqlQuery.append(" SELECT cpg.oid_para_gral oidconcurso, vc.esc2_oid_esta_conc estado, ");
        sqlQuery.append(" vc.copa_oid_para_gral_orig oidconcursoorigen ,");
        sqlQuery.append(" cpg.num_conc as numeroconcurso ");
        sqlQuery.append(" FROM inc_concu_param_gener cpg, inc_versi_concu vc, cra_perio peri ");
        sqlQuery.append(" WHERE cpg.pais_oid_pais = " + dtoe.getOidPais());
        sqlQuery.append(" AND cpg.ind_acti = " + sIndActivo);
        sqlQuery.append(" AND vc.copa_oid_para_gral = cpg.oid_para_gral ");
        if (dtoe.getOidPeriodo() != null) {
            sqlQuery.append(" AND peri.oid_peri = ").append(dtoe.getOidPeriodo());
        } else {
            sqlQuery.append(" AND peri.fec_inic = TRUNC(SYSDATE)");
        }
        sqlQuery.append(" AND peri.marc_oid_marc = " + dtoe.getOidMarca());
        sqlQuery.append(" AND peri.pais_oid_pais = " + dtoe.getOidPais());
        sqlQuery.append(" AND peri.cana_oid_cana = " + dtoe.getOidCanal());
        sqlQuery.append(" AND peri.val_esta = 1 ");        
        sqlQuery.append(" AND vc.perd_oid_peri = peri.oid_peri ");
        sqlQuery.append(" AND (vc.esc2_oid_esta_conc = " + ConstantesINC.OID_ESTADO_ACTIVO );
        sqlQuery.append(" OR vc.esc2_oid_esta_conc = " + ConstantesINC.OID_ESTADO_APROBADO + ") ");
        sqlQuery.append(" AND vc.vico_oid_vige_conc = " + dtoe.getOidVigenciaConcurso());       
        
        try {
            BelcorpService bs = BelcorpService.getInstance();
            rRetorno = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("**** rRetorno: " + rRetorno);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
            UtilidadesError.armarCodigoError(sCodigoError));
       }

        UtilidadesLog.info("DAOActivacionCerradoConcursos.obtenerConcursosActivar " +
                            "(DTOBuscarConcursos dtoe):Salida");
        return rRetorno;
    }
    
    
    /**
     * CHANGELOG
     * ---------
     * Cambio RI 20080621 - dmorello, 22/09/2008 - Se recupera num de concurso
     * 
     * @author: ssantana, 23/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param DTOBuscarConcursos dtoe
     */
    public RecordSet obtenerConcursosCerrar(DTOBuscarConcursos dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOActivacionCerradoConcursos.obtenerConcursosCerrar" +
                            "(DTOBuscarConcursos dtoe):Entrada");
            
        StringBuffer sqlQuery = new StringBuffer("");
        String sIndActivo = null;
        RecordSet rRetorno = null;
        
        if ( dtoe.getIndActivo().booleanValue() ) {
            sIndActivo = "1";
        } else {
            sIndActivo = "0";
        }
        
        sqlQuery.append(" SELECT cpg.oid_para_gral oidconcurso, ");
        sqlQuery.append(" vc.esc2_oid_esta_conc estado, ");
        sqlQuery.append(" vc.copa_oid_para_gral_orig oidconcursoorigen, ");
        sqlQuery.append(" cpg.perd_oid_peri_hast oidperiodohasta, ");
        sqlQuery.append(" pn.num_pedi_eval periodosevaluar, ");
        sqlQuery.append(" pgp.num_peri periodosobtencion, ");
        sqlQuery.append(" pgp.perd_oid_peri oidperiododespacho, ");
        sqlQuery.append(" pr.perd_oid_peri_prem oidperiodopremiacion, ");
        sqlQuery.append(" mul.num_peri_sobr_calc periodossobrecalculo, ");
        sqlQuery.append(" TRUNC (SYSDATE) fechaactual, ");
        sqlQuery.append(" cpg.num_conc as numeroconcurso ");
        //jrivas 9/1/2009 20080804
        sqlQuery.append(" , CPC.VAL_PERI_EVAL PERIODOSRECOMENDADAS ");
        sqlQuery.append(" FROM inc_concu_param_gener cpg, ");
        sqlQuery.append(" inc_versi_concu vc, ");
        sqlQuery.append(" inc_progr_nueva pn, ");
        sqlQuery.append(" inc_param_gener_premi pgp, ");
        sqlQuery.append(" inc_param_ranki pr, ");
        sqlQuery.append(" inc_multi mul ");
        //jrivas 9/1/2009 20080804
        sqlQuery.append(" , inc_concu_param_consu cpc ");
        sqlQuery.append(" WHERE cpg.pais_oid_pais = " + dtoe.getOidPais());
        sqlQuery.append(" AND cpg.ind_acti = " + sIndActivo);
        sqlQuery.append(" AND vc.copa_oid_para_gral = cpg.oid_para_gral ");
        sqlQuery.append(" AND (vc.esc2_oid_esta_conc = " + ConstantesINC.OID_ESTADO_ACTIVO );
        sqlQuery.append(" OR vc.esc2_oid_esta_conc = " + ConstantesINC.OID_ESTADO_APROBADO +") ");
        sqlQuery.append(" AND vc.vico_oid_vige_conc = " + dtoe.getOidVigenciaConcurso() );
        sqlQuery.append(" AND pn.copa_oid_para_gral(+) = cpg.oid_para_gral ");
        sqlQuery.append(" AND pgp.copa_oid_para_gral(+) = cpg.oid_para_gral ");
        sqlQuery.append(" AND pr.copa_oid_para_gral(+) = cpg.oid_para_gral ");
        sqlQuery.append(" AND mul.copa_oid_para_gral(+) = cpg.oid_para_gral ");
        //jrivas 5/1/2009 20080804
        // vbongiov -- 20080804 -- 26/01/2009
        sqlQuery.append(" AND cpc.copa_oid_para_gral(+) = cpg.oid_para_gral ");
        sqlQuery.append(" AND NOT (PGP.PERD_OID_PERI IS NULL AND (CPG.BCAL_OID_BASE_CALC <> " + ConstantesINC.BASE_CALCULO_RECOMENDADA  );
        sqlQuery.append("                                         AND CPG.BCAL_OID_BASE_CALC IS NOT NULL)) ");
                
        BelcorpService bs = BelcorpService.getInstance();
        
        try {
            rRetorno = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("rRetorno: " + rRetorno);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                                    UtilidadesError.armarCodigoError(sCodigoError));
            
        }
        
        UtilidadesLog.info("DAOActivacionCerradoConcursos.obtenerConcursosCerrar" +
                            "(DTOBuscarConcursos dtoe):Salida");
        return rRetorno;
    }
    
    
    /**
     * @author: ssantana, 23/05/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param DTOPeriodo dtoe
     */
    public RecordSet obtenerPeriodosOrdenadosFechaIni(DTOPeriodo dtoe) 
            throws MareException {
        UtilidadesLog.info("DAOActivacionCerradoConcursos.obtenerPeriodosOrdenadosFechaIni" +
                            "(DTOPeriodo dtoe):Entrada");
            
        RecordSet rRetorno = null;
        StringBuffer sqlQuery = new StringBuffer("");
        
        sqlQuery.append(" SELECT   periodo.oid_peri oidperiodo, ");
        sqlQuery.append(" periodo.fec_inic fechainicial, ");
        sqlQuery.append(" periodo.fec_fina fechafinal ");
        sqlQuery.append(" FROM cra_perio periodo ");
        sqlQuery.append(" WHERE periodo.pais_oid_pais = " + dtoe.getOidPais());
        sqlQuery.append(" AND periodo.marc_oid_marc = " + dtoe.getMarca());
        sqlQuery.append(" AND periodo.cana_oid_cana = " + dtoe.getCanal());
        sqlQuery.append(" ORDER BY periodo.fec_inic ASC ");
        
        
        BelcorpService bs = BelcorpService.getInstance();
        
        try {
            rRetorno = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("rRetorno: " + rRetorno);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                                    UtilidadesError.armarCodigoError(sCodigoError));
            
        }
        
        UtilidadesLog.info("DAOActivacionCerradoConcursos.obtenerPeriodosOrdenadosFechaIni" +
                            "(DTOPeriodo dtoe):Salida");
        return rRetorno;
    }
    
    /**
     * @author: ssantana, 23/02/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOBoolean
     * @param DTOOID dtoe
     */
    public DTOBoolean determinarPendientes(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("DAOActivacionCerradoConcursos.determinarPendientes" +
                            "(DTOOID dtoe):Entrada");
        DTOBoolean dtoBoolean = new DTOBoolean();
        StringBuffer sqlQuery = new StringBuffer("");

        sqlQuery.append(" SELECT bolfal.oid_bols_falt OID ");
        sqlQuery.append(" FROM inc_concu_param_gener cpg, ");
        sqlQuery.append(" ped_solic_cabec solcab, ");
        sqlQuery.append(" ped_solic_posic solpos, ");
        sqlQuery.append(" inc_bolsa_falta bolfal ");
        sqlQuery.append(" WHERE solcab.copa_oid_para_gene(+) = cpg.oid_para_gral ");
        sqlQuery.append(" AND cpg.oid_para_gral = " + dtoe.getOid());
        sqlQuery.append(" AND solpos.soca_oid_soli_cabe = solcab.oid_soli_cabe ");
        sqlQuery.append(" AND bolfal.sopo_oid_soli_posi = solpos.oid_soli_posi ");
        sqlQuery.append(" AND bolfal.fec_solu IS NULL ");
        
        BelcorpService bs = BelcorpService.getInstance();
        
        try {
            RecordSet rTemp = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("rRetorno: " + rTemp);
            if (rTemp != null) {
                dtoBoolean.setValor( !rTemp.esVacio() );
            } else {
                dtoBoolean.setValor(false);
            }
            UtilidadesLog.debug("dtoBoolean: " + dtoBoolean);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                                    UtilidadesError.armarCodigoError(sCodigoError));
        }
        
        UtilidadesLog.info("DAOActivacionCerradoConcursos.determinarPendientes" +
                            "(DTOOID dtoe):Salida");
        return dtoBoolean;
    }
    
    /**
     * @author: cvalenzu, 22/11/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param String tabla, String campo, Long oidAnterior, Long oidNuevo
     */
    public void actualizarEntidad(String tabla, String campo,
       Long oidAnterior, Long oidNuevo) throws MareException {
        UtilidadesLog.info("DAOActivacionCerradoConcursos.actualizarEntidad" +        
        "(String tabla, String campo, Long oidAnterior, Long oidNuevo):Entrada");
        
        StringBuffer sqlQuery = new StringBuffer("");
        
        sqlQuery.append(" UPDATE "); 
        sqlQuery.append(tabla);
        sqlQuery.append(" SET ");
        sqlQuery.append(tabla);
        sqlQuery.append(".");
        sqlQuery.append(campo);
        sqlQuery.append(" = ");
        sqlQuery.append(oidNuevo);
        sqlQuery.append(" WHERE ");
        sqlQuery.append(tabla);
        sqlQuery.append(".");
        sqlQuery.append(campo);
        sqlQuery.append(" = ");
        sqlQuery.append(oidAnterior);
        
        try {
            BelcorpService bs = BelcorpService.getInstance();
            bs.dbService.executeUpdate(sqlQuery.toString());             
        }
        catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            String sCodigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }     
        
        UtilidadesLog.info("DAOActivacionCerradoConcursos.actualizarEntidad" +
        "(String tabla, String campo, Long oidAnterior, Long oidNuevo):Salida");
    }  
    
    // vbongiov -- Cambio 20090863 -- 30/06/2009
    public void guardarHistoricoActivacionCerrado(String accion, Long oidPeriodo, String usuario, RecordSet listaConcursos) throws MareException {
        UtilidadesLog.info("DAOActivacionCerradoConcursos.guardarHistoricoActivacionCerrado(String accion, Long oidPeriodo, String usuario, RecordSet listaConcursos): Entrada");                
        UtilidadesLog.debug("accion: " + accion);
        UtilidadesLog.debug("oidPeriodo: " + oidPeriodo);
        UtilidadesLog.debug("usuario: " + usuario);
        UtilidadesLog.debug("listaConcursos: " + listaConcursos);
                    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        String oidConcursos = new String();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" INSERT INTO INC_HISTO_ACTIV_CERRA ");   
        query.append(" (OID_HIST_ACTI_CERR, VAL_SERV, PERD_OID_PERI, ");   
        query.append(" FEC_PROC, VAL_TIPO_PROC, VAL_USUA, VAL_OBSE)  ");  
        query.append(" VALUES (INC_HIAC_SEQ.NEXTVAL, '" + ConfigFactory.getBatchConfig().getServer() + "', ");   
        query.append( oidPeriodo + ", SYSDATE, "); 
        
        if(accion.equals("A")){
            query.append("'Activacion', "); 
        } else if(accion.equals("C")){
            query.append("'Cerrado', "); 
        }
        
        query.append("'" + usuario + "', "); 
        
        if(!listaConcursos.esVacio()){
        
            int cant = listaConcursos.getRowCount();
            
            for(int i=0; i < cant; i++){
                oidConcursos = oidConcursos + "," + ((BigDecimal)listaConcursos.getValueAt(i, "OIDCONCURSO")).toString();
            }
            
            query.append("'" + oidConcursos.substring(1) + "') "); 
            
        } else {
            query.append("' ') ");
        }
        
        try {
              bs.dbService.executeUpdate(query.toString());     
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        UtilidadesLog.info("DAOActivacionCerradoConcursos.guardarHistoricoActivacionCerrado(String accion, Long oidPeriodo, String usuario, RecordSet listaConcursos): Salida");   
    }
    
    // vbongiov -- Cambio 20090863 -- 30/06/2009
    public void actualizarUltimaActualizacionConcurso() throws MareException {
        UtilidadesLog.info("DAOActivacionCerradoConcursos.actualizarUltimaActualizacionConcurso(): Entrada");                
        UtilidadesLog.debug("servidor: " + ConfigFactory.getBatchConfig().getServer());
                    
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        String oidConcursos = new String();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" UPDATE INC_ULTIM_ACTUA_CONCU ");   
        query.append(" SET FEC_CREA = SYSDATE ");   
        query.append(" WHERE VAL_SERV = '" + ConfigFactory.getBatchConfig().getServer() + "' ");          
        
        try {
              bs.dbService.executeUpdate(query.toString());     
        } catch (Exception e){       
              e.printStackTrace();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }  
        
        UtilidadesLog.info("DAOActivacionCerradoConcursos.actualizarUltimaActualizacionConcurso(): Salida");   
    }
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    public boolean determinarPendientesConcurso(Long idConcurso, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOActivacionCerradoConcursos.determinarPendientesConcurso(Long idConcurso, Long oidPeriodo):Entrada");
        boolean pendientes = false;
        StringBuffer sqlQuery = new StringBuffer("");

        sqlQuery.append(" SELECT COUNT(1) ");
        sqlQuery.append(" FROM INC_ASIGN_PREMI_PENDI premPen, CRA_PERIO perTope, CRA_PERIO perCierre ");
        sqlQuery.append(" WHERE premPen.COPA_OID_PARA_GRAL = " + idConcurso);
        sqlQuery.append(" AND premPen.VAES_OID_VALO_ESTA = " + ConstantesINC.OID_ESTADO_MORO_REGISTRADO);
        sqlQuery.append(" AND perCierre.OID_PERI = " + oidPeriodo);
        sqlQuery.append(" AND premPen.PERD_OID_PERI_TOPE = perTope.OID_PERI ");       
        sqlQuery.append(" AND perTope.FEC_INIC > perCierre.FEC_FINA ");
        
        BelcorpService bs = BelcorpService.getInstance();
        
        try {
            RecordSet rs = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("rs: " + rs);

            BigDecimal cantidad = (BigDecimal)rs.getValueAt(0, 0);

            if (cantidad.intValue() > 0) {
                pendientes = true;
            }
            
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                                    UtilidadesError.armarCodigoError(sCodigoError));
        }
        
        UtilidadesLog.info("DAOActivacionCerradoConcursos.determinarPendientesConcurso(Long idConcurso, Long oidPeriodo):Salida");
        return pendientes;
    }
}