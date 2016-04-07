package es.indra.sicc.logicanegocio.car;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.car.DTOReevaluarEnMasa;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.dtos.car.DTOCriteriosCodigoConf;
import es.indra.sicc.dtos.car.DTOCriteriosEjecutivo;
import es.indra.sicc.dtos.car.DTOCriteriosGrupoSol;
import es.indra.sicc.entidades.ped.TiposSolicitudLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesLog;
import javax.naming.NamingException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.ZONEjbLocators;
import es.indra.sicc.util.CAREjbLocators;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.util.UtilidadesPaginacion;
import javax.naming.InitialContext;
import javax.ejb.FinderException;
import javax.ejb.SessionContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import java.math.BigDecimal;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.car.DTOPaginado;
import es.indra.sicc.dtos.car.DTOBusquedaSolBloqueadas;
import es.indra.sicc.dtos.car.DTOJerarquia;
import es.indra.sicc.dtos.car.DTOCodigoConfiguracion;
import es.indra.sicc.dtos.car.DTOUsuarioJerarquia;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.negocio.ConstantesCMN;

import es.indra.sicc.dtos.car.DTOGrupoSolicitud;

import es.indra.sicc.dtos.car.DTOTipoOfertaPrioridad;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudLimiteCredito;

import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.DTOOIDs;

import java.util.Vector;
import java.util.ArrayList;
import java.sql.Date;

import java.util.Collection;

import javax.persistence.NoResultException;

public class DAOCAR {
  private String usuario_ses;
	private String ENT_SEG_CANAL = "SEG_CANAL";
	private String ENT_CAR_NIVELRIESGO = "CAR_NIVEL_RIESG";
	
    public DAOCAR(String usuario) { usuario_ses = usuario; }

     public RecordSet obtenerTiposSolicitud(Long oidGrupoSolicitud, Long oidIdioma, Boolean TSolicitudLibres) throws MareException {
        UtilidadesLog.info("DAOCAR.obtenerTiposSolicitud(Long , Long, Boolean):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        if(oidGrupoSolicitud!=null && TSolicitudLibres.booleanValue()==true ){			
          UtilidadesLog.debug("Condicion1");
          query.append(" SELECT oid_tipo_soli, a.COD_TIPO_SOLI || '-' || val_i18n descripcion  ");
          query.append(" FROM ped_tipo_solic a, v_gen_i18n_sicc v ");
          query.append(" WHERE a.oid_tipo_soli = v.val_oid ");
          query.append(" AND v.attr_enti = 'PED_TIPO_SOLIC' ");
          query.append(" AND v.attr_num_atri = 1 ");
          query.append(" AND v.idio_oid_idio = " + oidIdioma);
          query.append(" AND ( grso_oid_grup_soli = " + oidGrupoSolicitud + " or grso_oid_grup_soli is null)  ");
          query.append(" ORDER BY descripcion ");
        }

        if(oidGrupoSolicitud == null && TSolicitudLibres.booleanValue()==true){
          UtilidadesLog.debug("Condicion2");
          query.append(" SELECT oid_tipo_soli, a.COD_TIPO_SOLI || '-' || val_i18n descripcion  ");
          query.append(" FROM ped_tipo_solic a, v_gen_i18n_sicc v ");
          query.append(" WHERE a.oid_tipo_soli = v.val_oid ");
          query.append(" AND v.attr_enti = 'PED_TIPO_SOLIC' ");
          query.append(" AND v.attr_num_atri = 1 ");
          query.append(" AND v.idio_oid_idio = " + oidIdioma);
          query.append(" AND grso_oid_grup_soli is null ");
          query.append(" ORDER BY descripcion ");
        }

        if(oidGrupoSolicitud!=null && TSolicitudLibres.booleanValue()==false ){
          UtilidadesLog.debug("Condicion3");
          UtilidadesLog.debug(oidGrupoSolicitud.toString());
          query.append(" SELECT distinct oid_tipo_soli, a.COD_TIPO_SOLI || '-' || val_i18n descripcion ");
          query.append(" FROM ped_tipo_solic a, v_gen_i18n_sicc v,car_grupo_solic cgs ");
          query.append(" WHERE a.oid_tipo_soli = v.val_oid ");
          query.append(" AND v.attr_enti = 'PED_TIPO_SOLIC' ");
          query.append(" AND v.attr_num_atri = 1 ");
          query.append(" AND v.idio_oid_idio = " + oidIdioma);
          query.append(" AND grso_oid_grup_soli = "+ oidGrupoSolicitud );
          query.append(" ORDER BY descripcion ");
        }

        if(oidGrupoSolicitud ==null && TSolicitudLibres.booleanValue()==false ){
          UtilidadesLog.debug("Condicion4");			
          query.append(" SELECT distinct oid_tipo_soli, a.COD_TIPO_SOLI || '-' || val_i18n descripcion  ");
          query.append(" FROM ped_tipo_solic a, v_gen_i18n_sicc v,car_grupo_solic cgs ");
          query.append(" WHERE a.oid_tipo_soli = v.val_oid ");
          query.append(" AND v.attr_enti = 'PED_TIPO_SOLIC' ");
          query.append(" AND v.attr_num_atri = 1 ");
          query.append(" AND v.idio_oid_idio = " + oidIdioma);
          query.append(" AND grso_oid_grup_soli is not null ");
          query.append(" ORDER BY descripcion ");
        }
		 
        try{
          bs = BelcorpService.getInstance();
        }
        catch (MareMiiServiceNotFoundException ex) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
		
        try{			
          rs = bs.dbService.executeStaticQuery(query.toString());		
        }
        catch (Exception ex) {
          throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if ((oidGrupoSolicitud==null) && rs.esVacio()){
          throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0004));
        }

        if (rs.esVacio()){
            throw new MareException(null,null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0002));
        }		
     UtilidadesLog.info("DAOCAR.obtenerTiposSolicitud(Long , Long, Boolean):Salida");
        return rs;
    }
    //modificado por Noziglia C. Incidencia BELC300014807
    public RecordSet buscarGruposSolicitud(DTOCriteriosGrupoSol dtoin)
		throws MareException {
        UtilidadesLog.info("DAOCAR.buscarGruposSolicitud(DTOCriteriosGrupoSol):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //query.append(" SELECT gs.oid_grup_soli OID ,ts.oid_tipo_soli OIDTP, i1.val_i18n desc_tipo_solic, i2.val_i18n desc_grupo_solic ");
        // query anterior
 /*     query.append(" SELECT ts.oid_tipo_soli OID, gs.COD_GRUP_SOLI, i1.val_i18n desc_tipo_solic ,i2.val_i18n desc_grupo_solic ");
        query.append("   FROM ped_tipo_solic ts, ");
        query.append("        car_grupo_solic gs, ");
        query.append("        v_gen_i18n_sicc i1, ");
        query.append("        v_gen_i18n_sicc i2 ");
        query.append("  WHERE ts.grso_oid_grup_soli = gs.oid_grup_soli ");
        query.append("    AND i1.attr_enti = 'PED_TIPO_SOLIC' ");
        query.append("    AND i1.attr_num_atri = 1 ");
        query.append("    AND i1.idio_oid_idio = " + dtoin.getOidIdioma());
        query.append("    AND i1.val_oid = ts.oid_tipo_soli ");
        query.append("    AND i2.attr_enti = 'CAR_GRUPO_SOLIC' ");
        query.append("    AND i2.attr_num_atri = 1 ");
        query.append("    AND i2.idio_oid_idio = " + dtoin.getOidIdioma());
        query.append("    AND i2.val_oid = gs.oid_grup_soli ");*/


        query.append("SELECT ts.oid_tipo_soli OID, gs.COD_GRUP_SOLI, ts.COD_TIPO_SOLI,  i2.val_i18n desc_grupo_solic ");
        query.append("  FROM ped_tipo_solic ts, ");
        query.append("       car_grupo_solic gs,");
        query.append("       v_gen_i18n_sicc i2 ");
        query.append(" WHERE ts.grso_oid_grup_soli = gs.oid_grup_soli ");
        query.append("   AND i2.attr_enti = 'CAR_GRUPO_SOLIC' ");
        query.append("   AND i2.attr_num_atri = 1 ");
        query.append("   AND i2.idio_oid_idio = " + dtoin.getOidIdioma());
        query.append("   AND i2.val_oid = gs.oid_grup_soli " );

		if (dtoin.getCodGrupoSolicitud()!=null){
			query.append("    AND gs.cod_grup_soli like '" + dtoin.getCodGrupoSolicitud() + "'");	
			
		}

		if (dtoin.getTiposSolicitud()!=null){
			query.append("    AND ts.oid_tipo_soli = " + dtoin.getTiposSolicitud());
		}

		if (dtoin.getDescripcion()!=null){
			query.append("    AND i2.val_i18n LIKE '" + dtoin.getDescripcion() + "'");
		}
        
		
		query.append(" ORDER BY 2 ");

        try {
            rs = bs.dbService.executeStaticQuery(
				UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoin));
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		UtilidadesLog.info("DAOCAR.buscarGruposSolicitud(DTOCriteriosGrupoSol):Salida");
        return rs;
    }
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidCodigoConf
     * @param oidIdioma
     */
     // Modificado por Sergio Platas - 22/07/2005 - Inc. 19834
    public RecordSet obtenerNivelesRiesgo(Long oidIdioma, Long oidCodigoConf) throws MareException{
        UtilidadesLog.info("DAOCAR.obtenerNivelesRiesgo(Long, Long):Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        if( oidCodigoConf != null ){
            UtilidadesLog.debug("----------- > oidCodigoConf es NOT NULL !!");
        
            query.append(" SELECT DISTINCT a.oid_nive_ries, val_i18n descripcion, b.COD_CONF ");
            query.append(" from CAR_NIVEL_RIESG a, CAR_PARAM_CARTE b , V_GEN_I18N_SICC v, ");
            query.append(" CAR_PARAM_CARTE C" );
            query.append(" where B.NIRI_OID_NIVE_RIES = a.OID_NIVE_RIES  ");
            query.append(" and v.val_oid = OID_NIVE_RIES  ");
            query.append(" and v.attr_enti = 'CAR_NIVEL_RIESG' ");
            query.append(" and v.attr_num_atri = 1 ");
            query.append(" and v.idio_oid_idio = " + oidIdioma);
            query.append(" and b.COD_CONF = c.COD_CONF  " );
            query.append(" and C.OID_PARA_CART = " + oidCodigoConf );
            query.append(" ORDER BY DESCRIPCION ");            
        }else {
            UtilidadesLog.debug("----------- > oidCodigoConf es NULL !!");
        
            query.append(" select OID_NIVE_RIES, VAL_I18N DESCRIPCION ");
            query.append(" from CAR_NIVEL_RIESG a, V_GEN_I18N_SICC v ");
            query.append(" where v.val_oid = OID_NIVE_RIES ");
            query.append(" and v.attr_enti = 'CAR_NIVEL_RIESG' ");
            query.append(" and v.attr_num_atri = 1 ");
            query.append(" and v.idio_oid_idio = " + oidIdioma );            
            query.append(" ORDER BY DESCRIPCION ");
        }       
        
        UtilidadesLog.debug("--------- >  La query es: " + query.toString());
                   
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("----> EJECUTÓ LA QUERY !! ");
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCAR.obtenerNivelesRiesgo(Long, Long):Salida");
        return rs;
    }
    
   /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidCodigoConf
     * @param oidIdioma
     * @param oidNivelRiesgo
     */
    // Modificado por Sergio Platas - 22/07/2005 - Inc. 19834 
    // Modificado por Damasia Maneiro - 22/08/2005 arreglo de consulta si oidCodigoConf es NULL se agrego oidNivelRiesgo
    public RecordSet obtenerGruposSolicitud(Long oidIdioma, Long oidCodigoConf, Long oidNivelRiesgo) 
            throws MareException{
        UtilidadesLog.info("DAOCAR.obtenerGruposSolicitud(Long , Long , Long ):Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
       
        if( oidCodigoConf != null ){
            UtilidadesLog.debug("----------- > oidCodigoConf es NOT NULL !!");
            
            query.append(" select distinct OID_GRUP_SOLI, VAL_I18N DESCRIPCION ");
            query.append(" from CAR_GRUPO_SOLIC a, CAR_PARAM_CARTE b , V_GEN_I18N_SICC v ,");
            query.append(" CAR_PARAM_CARTE c ");
            query.append(" where b.GRSO_OID_GRUP_SOLI = OID_GRUP_SOLI ");
            query.append(" and v.attr_enti = 'CAR_GRUPO_SOLIC' ");
            query.append(" and v.attr_num_atri = 1 ");
            query.append(" and v.idio_oid_idio = " + oidIdioma);
            query.append(" and v.val_oid = OID_GRUP_SOLI ");
            query.append(" and b.COD_CONF=c.COD_CONF ");
            query.append(" and C.OID_PARA_CART = " + oidCodigoConf);
            query.append(" and b.NIRI_OID_NIVE_RIES = " + oidNivelRiesgo);
            query.append(" ORDER BY DESCRIPCION ");
            
        }else {
            UtilidadesLog.debug("----------- > oidCodigoConf es NULL !!");
        
            query.append(" select distinct OID_GRUP_SOLI, VAL_I18N DESCRIPCION ");
            query.append(" from CAR_GRUPO_SOLIC a,  CAR_PARAM_CARTE b, V_GEN_I18N_SICC v ");
            query.append(" where v.val_oid = OID_GRUP_SOLI ");
            query.append(" and a.OID_GRUP_SOLI = b.GRSO_OID_GRUP_SOLI ");
            query.append(" and v.attr_enti = 'CAR_GRUPO_SOLIC' ");
            query.append(" and v.attr_num_atri = 1 ");
            query.append(" and v.idio_oid_idio = " + oidIdioma );
            query.append(" and b.NIRI_OID_NIVE_RIES = " + oidNivelRiesgo);
            query.append(" ORDER BY DESCRIPCION ");
        }
            
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            UtilidadesLog.debug(" LA QUERY ES: \n" + query.toString());
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("--------- >  Sale de 'obtenerNivelesRiesgo() retornando: '" +
                           rs.toString() );
        UtilidadesLog.info("DAOCAR.obtenerGruposSolicitud(Long , Long , Long ):Salida");
        return rs;
    }
    
   /*
        VERSION ANTERIOR
    */
    public RecordSet obtenerGruposSolicitud(Long oidIdioma, Long oidCodigoConf) throws MareException{
        UtilidadesLog.info("DAOCAR.obtenerGruposSolicitud(Long , Long ):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        if( oidCodigoConf != null ){
            query.append(" select OID_GRUP_SOLI, VAL_I18N DESCRIPCION ");
            query.append(" from CAR_GRUPO_SOLIC a, CAR_PARAM_CARTE b , V_GEN_I18N_SICC v ");
            query.append(" where  GRSO_OID_GRUP_SOLI = OID_GRUP_SOLI ");
            query.append(" and b.OID_PARA_CART  = " + oidCodigoConf );
            query.append(" and v.attr_enti = 'CAR_GRUPO_SOLIC' ");
            query.append(" and v.attr_num_atri = 1 ");
            query.append(" and v.idio_oid_idio = " + oidIdioma );
            query.append(" and v.val_oid = OID_GRUP_SOLI ");
            query.append(" ORDER BY DESCRIPCION ");
        }else {
            query.append(" select OID_GRUP_SOLI, VAL_I18N DESCRIPCION ");
            query.append(" from CAR_GRUPO_SOLIC a,  V_GEN_I18N_SICC v ");
            query.append(" where v.val_oid = OID_GRUP_SOLI ");
            query.append(" and v.attr_enti = 'CAR_GRUPO_SOLIC' ");
            query.append(" and v.attr_num_atri = 1 ");
            query.append(" and v.idio_oid_idio = " + oidIdioma );
            query.append(" ORDER BY DESCRIPCION ");
        }

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCAR.obtenerGruposSolicitud(Long , Long ):Salida");
        return rs;
    }

    public RecordSet obtenerIndicadoresValidacion(Long oidIdioma) throws MareException{
        UtilidadesLog.info("DAOCAR.obtenerIndicadoresValidacion(Long ):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        query.append(" SELECT OID_INDI_VALI, VAL_I18N DESCRIPCION ");
        query.append(" FROM CAR_INDIC_VALID a, V_GEN_I18N_SICC v ");
        query.append(" WHERE v.attr_enti = 'CAR_INDIC_VALID' ");
        query.append(" and v.val_oid = OID_INDI_VALI ");
        query.append(" and v.idio_oid_idio = "+ oidIdioma );
        query.append(" and v.attr_num_atri = 1 ");
        query.append(" ORDER BY DESCRIPCION ");

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCAR.obtenerIndicadoresValidacion(Long ):Salida");
        return rs;
    }


    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     */
    // Modificado por Sergio Platas - 18/07/2005 - Inc. 19834
    public RecordSet obtenerCodigosConfiguracion() throws MareException{
        UtilidadesLog.info("DAOCAR.obtenerCodigosConfiguracion():Entrada");
                
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        
        query.append(" select min(OID_PARA_CART), COD_CONF ");
        query.append(" from CAR_PARAM_CARTE ");
        query.append(" group by COD_CONF");
        query.append(" ORDER BY COD_CONF ");
        
        UtilidadesLog.debug("------------ > La query es : " + query.toString());
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("------------ > sale de 'obtenerCodigosConfiguracion()' retornando" + 
            rs.toString());
        UtilidadesLog.info("DAOCAR.obtenerCodigosConfiguracion():Salida");
        return rs;
        
    }

     public RecordSet buscarCodigoConf(DTOCriteriosCodigoConf dtoin) throws MareException{
        UtilidadesLog.info("DAOCAR.buscarCodigoConf(DTOCriteriosCodigoConf):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
       
       /* query.append(" SELECT a.OID_ASIG_CODI_CONF OID, e.DES_MARC, i.VAL_I18N descripcion, "); 
        query.append(" b.DES_SUBG_VENT, g.DES_REGI, h.DES_ZONA, c.COD_CONF, i2.VAL_I18N descripcionNivelRiesgo, i3.VAL_I18N descripcionGrupoSolicitud, ");
        query.append(" IND_DEUD_VENC, ");
        query.append(" IND_LINE_CRED, ");
        query.append(" IND_MONT_MAXI, ");
        query.append(" IND_PORC_MAXI, ");
        query.append(" c.OID_PARA_CART, a.NIRI_OID_NIVE_RIES, a.GRSO_OID_GRUP_SOLI ");
        query.append(" FROM CAR_ASIGN_CODIG_CONFI a , VCA_ZON_SUB_GEREN_VENTA b, CAR_PARAM_CARTE c, ");
        query.append(" VCA_SEG_CANAL d, VCA_SEG_MARCA e, VCA_SEG_PAIS f, VCA_ZON_REGIO g, VCA_ZON_ZONA h, ");
        query.append(" V_GEN_I18N_SICC i,  V_GEN_I18N_SICC i2, V_GEN_I18N_SICC i3");
        query.append(" WHERE a.ZSGV_OID_SUBG_VENT = b.OID_SUBG_VENT ");
        query.append(" and a.PACA_OID_PARA_CART = c.OID_PARA_CART ");            
        query.append(" and d.OID_CANA = b.CANA_OID_CANA ");           
        query.append(" and e.OID_MARC = b.MARC_OID_MARC ");           
        query.append(" and f.OID_PAIS = b.PAIS_OID_PAIS ");           
        query.append(" and g.OID_REGI = a.ZORG_OID_REGI ");           
        query.append(" and h.OID_ZONA = a.ZZON_OID_ZONA ");           
        query.append(" and i.attr_enti = 'SEG_CANAL' ");            
        query.append(" and i.idio_oid_idio = 1 ");            
        query.append(" and i.attr_num_atri = 1 ");            
        query.append(" and i.VAL_OID = d.OID_CANA ");
        query.append(" and i2.attr_enti = 'CAR_NIVEL_RIESG' ");
        query.append(" and i2.idio_oid_idio = 1 ");
        query.append(" and i2.attr_num_atri = 1 ");
        query.append(" and i2.VAL_OID = a.NIRI_OID_NIVE_RIES ");    
        query.append(" and i3.attr_enti = 'CAR_GRUPO_SOLIC' ");
        query.append(" and i3.idio_oid_idio = 1 ");
        query.append(" and i3.attr_num_atri = 1 ");   
        query.append(" and i3.VAL_OID = a.GRSO_OID_GRUP_SOLI ");  
        query.append(" and b.COD_USUA = '" + usuario_ses + "' ");          
        query.append(" and d.COD_USUA = '" + usuario_ses + "' ");           
        query.append(" and e.COD_USUA = '" + usuario_ses + "' ");           
        query.append(" and f.COD_USUA = '" + usuario_ses + "' ");  	       
        query.append(" and g.COD_USUA = '" + usuario_ses + "' "); 
        query.append(" and h.COD_USUA = '" + usuario_ses + "' ");*/
        query.append("SELECT   nvl(a.oid_asig_codi_conf, '999999999') as oid,");  
		    query.append("e.des_marc,i.val_i18n descripcion,b.des_subg_vent, ");
		    query.append("g.des_regi,h.des_zona,c.cod_conf,");
        query.append("i2.val_i18n descripcionnivelriesgo,");
        query.append("i3.val_i18n descripciongruposolicitud,"); 
		    query.append("ind_deud_venc,ind_line_cred,ind_mont_maxi,"); 
		    query.append("ind_porc_maxi, c.oid_para_cart, a.niri_oid_nive_ries,");
        query.append("a.grso_oid_grup_soli");
        query.append(" FROM car_asign_codig_confi a,");
		    query.append("vca_zon_sub_geren_venta b,car_param_carte c,");
 		    query.append("vca_seg_canal d,vca_seg_marca e,");
        query.append("vca_seg_pais f,vca_zon_regio g,");
        query.append("vca_zon_zona h,v_gen_i18n_sicc i,");
        query.append("v_gen_i18n_sicc i2,v_gen_i18n_sicc i3");
        query.append(" WHERE  a.paca_oid_para_cart(+) = c.oid_para_cart");
        query.append(" AND  b.oid_subg_vent(+) = a.zsgv_oid_subg_vent");
	      query.append(" AND  d.oid_cana(+) = b.cana_oid_cana ");
        query.append(" AND i2.attr_enti(+) = 'CAR_NIVEL_RIESG'");
        query.append(" AND i2.idio_oid_idio(+) = " + dtoin.getOidIdioma());
        query.append(" AND i2.attr_num_atri(+) = 1");
        query.append(" AND i2.val_oid(+) = a.niri_oid_nive_ries");
        query.append(" AND i3.attr_enti(+) = 'CAR_GRUPO_SOLIC'");
        query.append(" AND i3.idio_oid_idio(+) = " + dtoin.getOidIdioma());
        query.append(" AND i3.attr_num_atri(+) = 1");
        query.append(" AND i3.val_oid(+) = a.grso_oid_grup_soli");
	      query.append(" AND i.attr_enti(+) = 'SEG_CANAL'");
        query.append(" AND i.idio_oid_idio(+) = " + dtoin.getOidIdioma());
        query.append(" AND i.attr_num_atri(+) = 1");
        query.append(" AND i.val_oid(+) = d.oid_cana");
	      query.append(" AND e.oid_marc(+) = b.marc_oid_marc");
        query.append(" AND f.oid_pais(+) = b.pais_oid_pais");
        query.append(" AND g.oid_regi(+) = a.zorg_oid_regi");
        query.append(" AND h.oid_zona(+) = a.zzon_oid_zona");
        query.append(" AND e.cod_usua(+) = '" + usuario_ses + "'");
        query.append(" AND f.cod_usua(+) = '" + usuario_ses + "'");
        query.append(" AND g.cod_usua(+) = '" + usuario_ses + "'");
        query.append(" AND h.cod_usua(+) = '" + usuario_ses + "'");
	      query.append(" AND b.cod_usua(+) = '" + usuario_ses + "'");
	      query.append(" AND d.cod_usua(+) = '" + usuario_ses + "'");
	      query.append(" AND f.oid_pais(+) = " + dtoin.getOidPais());
   
	           
        if(dtoin.getCanal()!=null){
            query.append(" and d.OID_CANA = " + dtoin.getCanal() );
        }
        
        if(dtoin.getMarca()!=null){
            query.append(" and e.OID_MARC = " + dtoin.getMarca() );
        }

        /*if(dtoin.getOidPais()!=null){
            query.append(" and f.OID_PAIS = " + dtoin.getOidPais() );
        }*/

        if(dtoin.getSgv()!=null){
            query.append(" and b.OID_SUBG_VENT = " + dtoin.getSgv() );
        }

        if(dtoin.getRegion()!=null){
            query.append(" and g.OID_REGI = " + dtoin.getRegion());
        }

        if(dtoin.getZona()!=null){
            query.append(" and h.OID_ZONA = " + dtoin.getZona() );
        }

        if( dtoin.getNivelRiesgo()!=null ){
            query.append(" and a.NIRI_OID_NIVE_RIES = " + dtoin.getNivelRiesgo());
        }

        if( dtoin.getGrupoSolicitud()!=null ){
            query.append(" and a.GRSO_OID_GRUP_SOLI = " + dtoin.getGrupoSolicitud());
        }

        if((dtoin.getCodConf() != null) && !(dtoin.getCodConf().equals(""))){
            query.append("and c.COD_CONF like '" + dtoin.getCodConf().toUpperCase() + "' ");
        }


        //incidencia 7676 mdolce
        if(dtoin.getTipoValidacion1().intValue() != 0 ){
              query.append(" and c.IND_DEUD_VENC = " + dtoin.getTipoValidacion1());
        }

        if( dtoin.getTipoValidacion2().intValue() != 0 ){
            query.append(" and c.IND_LINE_CRED = " + dtoin.getTipoValidacion2() );
        }

        if( dtoin.getTipoValidacion3().intValue() != 0){
            query.append( " and c.IND_MONT_MAXI = " + dtoin.getTipoValidacion3() );
        }

        if( dtoin.getTipoValidacion4().intValue() != 0 ){
            query.append( " and c.IND_PORC_MAXI = " + dtoin.getTipoValidacion4());
        }
       

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
           String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoin);
           rs = bs.dbService.executeStaticQuery(queryStr.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if( rs.esVacio() ){
          UtilidadesLog.debug("************** No hay registros, se lanza la MareException");
          //throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }      
        UtilidadesLog.info("DAOCAR.buscarCodigoConf(DTOCriteriosCodigoConf):Salida");
        return rs;
    }
    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoin
     */
    // Modificado por Sergio Platas - 24/10/2005 - Inc. 19834
    // @scsaavedra - 29/08/2006, inc. BELC300024045
    
    /*Modificado por: Cristian Valenzuela
      Incidencia bloqueante: V_CAR_01
      Fecha: 12/12/2006
      Comentario: se modifica el metodo para que la consulta sea paginada */
    public RecordSet buscarAsignacionesCodigoConf(DTOOID dtoin) throws MareException{
        UtilidadesLog.info("DAOCAR.buscarAsignacionesCodigoConf(DTOOID ):Entrada");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
         
        query.append(" SELECT rownum as oid, a.OID_ASIG_CODI_CONF, x.COD_CONF, ");
        query.append(" v2.VAL_I18N DESCRIPCIONNIVELRIESGO, "); 
        query.append(" v3.VAL_I18N DESCRIPCIONGRUPOSOLICITUD, m.DES_MARC, v.VAL_I18N DESCRIPCION, "); 
        query.append(" c.DES_SUBG_VENT, d.DES_REGI, e.DES_ZONA, a.VAL_LINE_CRED_INIC, "); 
        query.append(" v4.VAL_I18N DESCRIPCIONNIVELRIESGOINICIAL, x.OID_PARA_CART, o.OID_NIVE_RIES, "); 
        query.append(" b.OID_GRUP_SOLI, m.OID_MARC, c.CANA_OID_CANA, c.OID_SUBG_VENT, d.OID_REGI, ");
        query.append(" e.OID_ZONA, a.NIRI_OID_NIVE_RIES_INICI "); 
        query.append(" FROM CAR_ASIGN_CODIG_CONFI a, CAR_PARAM_CARTE x, CAR_PARAM_CARTE x2, CAR_GRUPO_SOLIC b, ");  
        query.append(" CAR_NIVEL_RIESG o, ZON_SUB_GEREN_VENTA c, ZON_REGIO d, ZON_ZONA e, ");
        query.append(" SEG_MARCA m , SEG_CANAL h, V_GEN_I18N_SICC v, V_GEN_I18N_SICC v2, "); 
        query.append(" V_GEN_I18N_SICC v3, V_GEN_I18N_SICC v4 ");
        query.append(" WHERE x2.OID_PARA_CART = " + dtoin.getOid());
        query.append(" and x2.COD_CONF=x.COD_CONF ");
        query.append(" and a.ZSGV_OID_SUBG_VENT = c.OID_SUBG_VENT "); 
        query.append(" and a.GRSO_OID_GRUP_SOLI = b.OID_GRUP_SOLI ");
        
        // vbongiov --  SiCC 20080736 -- 11/09/2008
        /*
        //scsaavedra - BELC300024045
        //query.append(" and a.ZORG_OID_REGI = d.OID_REGI ");
        query.append(" and (a.ZORG_OID_REGI = d.OID_REGI or ");
        query.append(" a.ZORG_OID_REGI is null) ");
        
        //scsaavedra - BELC300024045
        //query.append(" and a.ZZON_OID_ZONA = e.OID_ZONA ");
        query.append(" and (a.ZZON_OID_ZONA = e.OID_ZONA or ");
        query.append(" a.ZZON_OID_ZONA is null) ");
        */
        query.append(" AND (( a.ZORG_OID_REGI = d.OID_REGI ");
        query.append("        AND a.zzon_oid_zona = e.oid_zona ");
        query.append("        AND d.IND_ACTI = 1 AND d.IND_BORR = 0 ");
        query.append("        AND e.IND_ACTI = 1 AND e.IND_BORR = 0) ");
        query.append("     OR (a.zorg_oid_regi IS NOT NULL AND a.zzon_oid_zona IS NULL  ");
        query.append("         AND a.zorg_oid_regi = d.oid_regi AND e.ZORG_OID_REGI = a.ZORG_OID_REGI ");
        query.append("         AND d.IND_ACTI = 1 AND d.IND_BORR = 0 ");
        query.append("         AND e.IND_ACTI = 1 AND e.IND_BORR = 0) ");
        query.append("     OR (a.zorg_oid_regi IS NULL AND a.zzon_oid_zona IS NULL  ");
        query.append("         AND d.ZSGV_OID_SUBG_VENT = a.ZSGV_OID_SUBG_VENT AND d.oid_regi= e.ZORG_OID_REGI ");
        query.append("         AND d.IND_ACTI = 1 AND d.IND_BORR = 0 ");
        query.append("         AND e.IND_ACTI = 1 AND e.IND_BORR = 0)) ");
        
        query.append(" and a.NIRI_OID_NIVE_RIES = o.OID_NIVE_RIES "); 
        query.append(" and a.PACA_OID_PARA_CART = x.OID_PARA_CART ");
        query.append(" and c.MARC_OID_MARC = m.OID_MARC ");
        query.append(" and c.CANA_OID_CANA = h.OID_CANA ");
        query.append(" and v.attr_enti = 'SEG_CANAL' ");
        query.append(" and v.val_oid = h.OID_CANA ");
        query.append(" and v.idio_oid_idio = " + dtoin.getOidIdioma() );
        query.append(" and v.attr_num_atri = 1 ");
        query.append(" and v2.attr_enti = 'CAR_NIVEL_RIESG' "); 
        query.append(" and v2.idio_oid_idio = 1 ");
        query.append(" and v2.attr_num_atri = 1 ");
        query.append(" and v2.VAL_OID = a.NIRI_OID_NIVE_RIES ");  
        query.append(" and v3.attr_enti = 'CAR_GRUPO_SOLIC' ");
        query.append(" and v3.idio_oid_idio = " + dtoin.getOidIdioma() );
        query.append(" and v3.attr_num_atri = 1 ");
        query.append(" and v3.VAL_OID = a.GRSO_OID_GRUP_SOLI ");  
        query.append(" and v4.attr_enti = 'CAR_NIVEL_RIESG' "); 
        query.append(" and v4.idio_oid_idio = " + dtoin.getOidIdioma() );
        query.append(" and v4.attr_num_atri = 1 ");
        query.append(" and v4.VAL_OID = a.NIRI_OID_NIVE_RIES_INICI ");
                 
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoin);
        UtilidadesLog.debug("----> La query es: " + queryPaginada.toString());
        
        try {
            rs = bs.dbService.executeStaticQuery(queryPaginada.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        UtilidadesLog.debug("*** cantidad de registros: " + rs.getRowCount());
        UtilidadesLog.info("DAOCAR.buscarAsignacionesCodigoConf(DTOOID ):Salida");
        return rs;
    }

    // @scsaavedra - 29/08/2006, inc. BELC300024046
    public RecordSet buscarAsignacionesEjecutivo(DTOOID dtoin) throws MareException {
        UtilidadesLog.info("DAOCAR.buscarAsignacionesEjecutivo(DTOOID):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT aej.oid_asig_ejec_cuen OID,  ");
        query.append(" 	   	  CONCAT(p.NAME,CONCAT(' ',CONCAT (pv.stringvalue,CONCAT (' ',CONCAT (pv2.stringvalue,CONCAT (' ',CONCAT (pv3.stringvalue,CONCAT (' ',pv4.stringvalue)))))))) descripcion, ");
        query.append(" 	      seg_marca.des_marc, i1.val_i18n canal, ");
        query.append("        zon_sub_geren_venta.des_subg_vent, ");
        query.append("       (select reg.DES_REGI from ZON_REGIO reg where reg.OID_REGI = aej.ZORG_OID_REGI) des_regi, ");
        query.append("       (select zon.DES_ZONA from ZON_ZONA zon where zon.OID_ZONA = aej.ZZON_OID_ZONA) des_zona, ");
        query.append("        i2.val_i18n nivel_riesgo, ");
        query.append(" 	      ej.USER_EJEC_CUEN oidEjecutivo,  "); //TODO verificar.
        query.append(" 	      zon_sub_geren_venta.marc_oid_marc oidMarca, ");
        query.append(" 	      zon_sub_geren_venta.cana_oid_cana oidCanal, ");
        query.append(" 	      aej.zsgv_oid_subg_vent oidSubgerencia, ");
        query.append(" 	      aej.zorg_oid_regi oidRegion, ");
        query.append(" 	      aej.zzon_oid_zona oidZona, ");
        query.append(" 	      aej.niri_oid_nive_ries oidNivelRiesgo ");
        query.append("   FROM car_ejecu_cuent ej, ");
        query.append("        car_asign_ejecu_cuent aej, ");
        query.append(" 	      zon_sub_geren_venta, ");
        query.append(" 	      seg_marca, ");
        query.append(" 	      seg_canal, ");
        query.append("        v_gen_i18n_sicc i1, ");
        query.append("        v_gen_i18n_sicc i2, ");
        query.append("        principals p LEFT JOIN propertyvalues pv ON pv.idproperty = 2 AND  ");
        query.append(" 	      pv.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv2 ON pv2.idproperty =3 AND  ");
        query.append(" 	      pv2.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv3 ON pv3.idproperty =5 AND  ");
        query.append(" 	      pv3.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv4 ON pv4.idproperty =6 AND  ");
        query.append(" 	      pv4.idprincipal = p.idprincipal, ");
        query.append("        users u ");
        query.append("  WHERE aej.ejcu_oid_ejec_cuen = ej.oid_ejec_cuen ");
        query.append("    AND zon_sub_geren_venta.oid_subg_vent = aej.zsgv_oid_subg_vent ");        
        query.append("    AND seg_canal.oid_cana = zon_sub_geren_venta.cana_oid_cana ");
        query.append("    AND seg_marca.oid_marc = zon_sub_geren_venta.marc_oid_marc ");
        query.append("    AND i1.attr_enti = 'SEG_CANAL' ");
        query.append("    AND i1.attr_num_atri = 1 ");
        query.append("    AND i1.idio_oid_idio = " + dtoin.getOidIdioma() );
        query.append("    AND i1.val_oid = seg_canal.oid_cana ");
        query.append("    AND i2.attr_enti = 'CAR_NIVEL_RIESG' ");
        query.append("    AND i2.attr_num_atri = 1 ");
        query.append("    AND i2.idio_oid_idio = " + dtoin.getOidIdioma() );
        query.append("    AND i2.val_oid = aej.niri_oid_nive_ries ");
        query.append("    AND u.iduser = p.idprincipal ");
        query.append("    AND p.idprincipal = ej.USER_EJEC_CUEN ");
        query.append("    AND ej.OID_EJEC_CUEN = " + dtoin.getOid());
        query.append(" ORDER BY 1 ");

        try {
			
            rs = bs.dbService.executeStaticQuery( query.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		UtilidadesLog.info("DAOCAR.buscarAsignacionesEjecutivo(DTOOID):Salida");
        return rs;
    }
    
    /*
     * Autor: Cortaberria
     * Fecha: 13/06/2005
     * Se estaba usando en la consulta el campo USER_EJEC_CUEN en lugar de OID_EJEC_CUEN
     * Se reviso la consulta debido a la incidencia BELC300019062
     */
    // @scsaavedra - 29/08/2006, inc. BELC300024046
    public RecordSet buscarEjecutivos(DTOCriteriosEjecutivo dtoin) throws MareException {
        UtilidadesLog.info("DAOCAR.buscarEjecutivos(DTOCriteriosEjecutivo):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        }
        catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
		
        query.append(" SELECT aej.OID_ASIG_EJEC_CUEN OID,  vca_seg_marca.des_marc, i1.val_i18n canal, ");
        query.append(" vca_zon_sub_geren_venta.des_subg_vent, vca_zon_regio.des_regi, ");
        query.append(" vca_zon_zona.des_zona, i2.val_i18n nivel_riesgo, ");
        query.append(" CONCAT(p.NAME,CONCAT(' ',CONCAT (pv.stringvalue,CONCAT (' ',CONCAT (pv2.stringvalue,CONCAT (' ',CONCAT (pv3.stringvalue,CONCAT (' ',pv4.stringvalue)))))))) descripcion, ");
        query.append(" car_jerar.cod_jera, ej.OID_EJEC_CUEN");
        query.append(" FROM car_ejecu_cuent ej, ");
        query.append(" car_asign_ejecu_cuent aej, ");
        query.append(" vca_seg_marca, ");
        query.append(" vca_seg_canal, ");
        query.append(" vca_seg_pais, ");
        query.append(" vca_zon_sub_geren_venta, ");
        query.append(" vca_zon_regio, ");
        query.append(" vca_zon_zona, ");
        query.append(" car_jerar, ");
        query.append(" v_gen_i18n_sicc i1, ");
        query.append(" v_gen_i18n_sicc i2, ");
        query.append(" principals p LEFT JOIN propertyvalues pv ON pv.idproperty = 2 AND  ");
        query.append(" pv.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv2 ON pv2.idproperty =3 AND  ");
        query.append(" pv2.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv3 ON pv3.idproperty =5 AND  ");
        query.append(" pv3.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv4 ON pv4.idproperty =6 AND  ");
        query.append(" pv4.idprincipal = p.idprincipal, ");
        query.append(" users u ");
        query.append(" WHERE aej.ejcu_oid_ejec_cuen = ej.oid_ejec_cuen ");
        query.append(" AND vca_seg_canal.cod_usua = '" + usuario_ses + "'");
        query.append(" AND vca_seg_pais.cod_usua = '" + usuario_ses + "'");
        query.append(" AND vca_zon_sub_geren_venta.cod_usua = '" + usuario_ses + "'");
        query.append(" AND vca_zon_regio.cod_usua = '" + usuario_ses + "'");
        query.append(" AND vca_zon_zona.cod_usua = '" + usuario_ses + "'");
        query.append(" AND vca_seg_marca.cod_usua = '" + usuario_ses + "'");
        query.append(" AND i1.attr_enti = 'SEG_CANAL'");
        query.append(" AND i1.attr_num_atri = 1 ");
        query.append(" AND i1.idio_oid_idio = " + dtoin.getOidIdioma());
        query.append(" AND i1.val_oid = vca_seg_canal.oid_cana ");
        query.append(" AND i2.attr_enti = 'CAR_NIVEL_RIESG' ");
        query.append(" AND i2.attr_num_atri = 1 ");
        query.append(" AND i2.idio_oid_idio = " + dtoin.getOidIdioma());
        query.append(" AND i2.val_oid = aej.niri_oid_nive_ries ");
        query.append(" AND vca_zon_sub_geren_venta.oid_subg_vent = aej.zsgv_oid_subg_vent ");
        query.append(" AND vca_seg_marca.oid_marc = vca_zon_sub_geren_venta.marc_oid_marc ");
        query.append(" AND vca_seg_canal.oid_cana = vca_zon_sub_geren_venta.cana_oid_cana ");
        query.append(" AND vca_seg_pais.oid_pais = vca_zon_sub_geren_venta.pais_oid_pais ");
        
        // @scsaavedra - BELC300024046
        //query.append(" AND vca_zon_regio.oid_regi = aej.zorg_oid_regi ");
        query.append(" AND (aej.zorg_oid_regi = vca_zon_regio.oid_regi or aej.zorg_oid_regi is null)");
        
        // @scsaavedra - BELC300024046
        //query.append(" AND vca_zon_zona.oid_zona = aej.zzon_oid_zona ");
        query.append(" AND (aej.zzon_oid_zona = vca_zon_zona.oid_zona or aej.zzon_oid_zona is null)");
        
        query.append(" AND car_jerar.oid_jera = ej.jera_oid_jera ");
        query.append(" AND u.iduser = p.idprincipal ");
        query.append(" AND p.idprincipal = ej.USER_EJEC_CUEN ");

		if (dtoin.getOidNivelRiesgo()!=null){
			query.append("    AND aej.niri_oid_nive_ries = " + dtoin.getOidNivelRiesgo() );
		}
    
		if (dtoin.getOidJerarquia()!=null){
		   query.append("    AND ej.jera_oid_jera = " + dtoin.getOidJerarquia() );
		}

		if (dtoin.getOidMarca()!=null){
		   query.append("	 AND vca_seg_marca.oid_marc = " + dtoin.getOidMarca() );
		}

		if (dtoin.getOidCanal()!=null){
		   query.append("	 AND vca_seg_canal.oid_cana = " + dtoin.getOidCanal() );
		}

		if (dtoin.getOidPais()!=null){
		   query.append("    AND vca_seg_pais.oid_pais = " + dtoin.getOidPais() );
		}

		if (dtoin.getOidsgv()!=null){
		   query.append("   AND vca_zon_sub_geren_venta.oid_subg_vent = " + dtoin.getOidsgv() );
		}

		if (dtoin.getOidRegion()!=null){
		   query.append("   AND vca_zon_regio.oid_regi = " + dtoin.getOidRegion() );
		}

		if (dtoin.getOidZona()!=null){
		   query.append("   AND vca_zon_zona.oid_zona = " + dtoin.getOidZona() );
		}

		if (dtoin.getIDPrincipal()!=null){
		   query.append("   AND ej.USER_EJEC_CUEN = " + dtoin.getIDPrincipal() );
       //query.append("   AND ej.OID_EJEC_CUEN = " + dtoin.getIDPrincipal() );
		}

        query.append(" ORDER BY 1 ");

        try {
			
            rs = bs.dbService.executeStaticQuery(
					UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoin));
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		UtilidadesLog.info("DAOCAR.buscarEjecutivos(DTOCriteriosEjecutivo):Salida");
        return rs;
    }

    public RecordSet obtenerJerarquias(DTOBelcorp dtoin) throws MareException{
        UtilidadesLog.info("DAOCAR.obtenerJerarquias(DTOBelcorp):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT oid_jera, cod_jera ");
        query.append("   FROM car_jerar ");
        query.append("   ORDER BY 1 ");
  
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		UtilidadesLog.info("DAOCAR.obtenerJerarquias(DTOBelcorp):Salida");
        return rs;
    }

    public RecordSet obtenerEjecutivos(DTOBelcorp dtoin) throws MareException {
    UtilidadesLog.info("DAOCAR.obtenerEjecutivos(DTOBelcorp):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
          bs = BelcorpService.getInstance();
        }
        catch (MareMiiServiceNotFoundException ex) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT ej.oid_ejec_cuen OID, ");
        query.append(" CONCAT(p.NAME,CONCAT(' ',CONCAT (pv.stringvalue,CONCAT (' ',CONCAT (pv2.stringvalue,CONCAT (' ',CONCAT (pv3.stringvalue,CONCAT (' ',pv4.stringvalue)))))))) descripcion ");
        query.append(" FROM car_ejecu_cuent ej, ");
        query.append(" principals p LEFT JOIN propertyvalues pv ON pv.idproperty = 2 AND  ");
        query.append(" pv.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv2 ON pv2.idproperty =3 AND  ");
        query.append(" pv2.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv3 ON pv3.idproperty =5 AND  ");
        query.append(" pv3.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv4 ON pv4.idproperty =6 AND  ");
        query.append(" pv4.idprincipal = p.idprincipal, ");
        query.append(" users u ");
        query.append(" WHERE u.iduser = p.idprincipal ");
        query.append(" AND p.idprincipal = ej.USER_EJEC_CUEN ");
        query.append(" ORDER BY descripcion ");		
		
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		
        UtilidadesLog.info("DAOCAR.obtenerEjecutivos(DTOBelcorp):Salida");
        return rs;
    }


	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Este metodo realiza una consutlta a través del DBService de MARE contra la entidad "CAR:EstatusPedido" 
	 *              Esta consulta retornar los registros con codigo "COD_ESTA" (03,04,06,07) que se encuentran en la entidad, 
	 *              haciendo un join con la vista de idiomas para obtener la descripcion que corresponde al idioma recibido 
	 *              como parametro. 
	 *              La consulta retorna un RecordSet con el oid del estatus y su descripción.               
	 */
	public RecordSet obtenerEstatusCredito( DTOBelcorp dtoin ) throws MareException {
        UtilidadesLog.info("DAOCAR.obtenerEstatusCredito( DTOBelcorp):Entrada");
		RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

		try{
			bs = BelcorpService.getInstance();
		}catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

		query.append("SELECT   estatuspedido.oid_esta_pedi AS OID, i18n.val_i18n AS descripcion ");
		query.append("    FROM car_estat_pedid estatuspedido, v_gen_i18n_sicc i18n ");
		query.append("   WHERE estatuspedido.cod_esta IN ('03', '04', '06', '07') ");
		query.append("     AND i18n.attr_enti = 'CAR_ESTAT_PEDID' ");
		query.append("     AND i18n.val_oid = estatuspedido.cod_esta ");
		query.append("     AND i18n.idio_oid_idio = " + dtoin.getOidIdioma().toString());
		query.append("     AND i18n.attr_num_atri = 1 ");
		query.append("ORDER BY i18n.val_i18n ");

		try {
			rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		
        UtilidadesLog.info("DAOCAR.obtenerEstatusCredito( DTOBelcorp):Salida");
        return rs;
	}



	/**
   * Sistema:     Belcorp
   * Modulo:      CAR
   * Fecha:       24/09/2004
   * @version     1.0
   * @autor       Maximiliano Dello Russo
   *  Descripcion: Realiza una consulta contra las tablas CAR_EJECU_CUENT y PRINCIPALS. 
   *  				Filtrando por el atributo NAME de PRINCIPALS y obteniendo el atributo JERA_OID_JERA de CAR_EJECU_CUENT.
   * @webmethod 
   */
	public DTOUsuarioJerarquia obtenerJerarquiaUsuario(String userName, Long oidPais) throws MareException{
        UtilidadesLog.info("DAOCAR.obtenerJerarquiaUsuario(String, Long):Entrada");
		RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
		DTOUsuarioJerarquia dtoSalida = new DTOUsuarioJerarquia();

		try{
			bs = BelcorpService.getInstance();
		}catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

		query.append("SELECT ejeccuenta.jera_oid_jera, ejeccuenta.OID_EJEC_CUEN ");
		query.append("  FROM car_ejecu_cuent ejeccuenta, ");
		query.append("       principals principals, ");
		query.append("       users users ");
		query.append(" WHERE principals.NAME = '" + userName + "' ");
		query.append("   AND ejeccuenta.user_ejec_cuen = users.iduser ");
		query.append("   AND users.iduser = principals.idprincipal ");
		query.append("   AND ejeccuenta.PAIS_OID_PAIS = " + oidPais);

		try {
			rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		
        if( rs.esVacio() ){
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
		BigDecimal jerarquia = (BigDecimal)rs.getValueAt(0, "JERA_OID_JERA");
		BigDecimal ejecutivo = (BigDecimal)rs.getValueAt(0, "OID_EJEC_CUEN");
		dtoSalida.setOidJerarquia(new Long(jerarquia.longValue()));
		dtoSalida.setOidEjecutivo(new Long(ejecutivo.longValue()));		
		dtoSalida.setUsuario(userName);
        UtilidadesLog.info("DAOCAR.obtenerJerarquiaUsuario(String, Long):Salida");
		return dtoSalida;
	}


	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Este metodo realiza una consutlta a través del DBService de MARE contra la entidad "CAR:CodigosAprobacion" 
	 * 				Esta consulta retornar todos los registros que se encuentran en la entidad, haciendo un join con la vista 
	 *              de idiomas para obtener la descripcion que corresponde al idioma recibido como parametro. 
	 *              La consulta retorna un RecordSet con el oid del codigo de aprobacion y su descripción. 
	 */
	public RecordSet obtenerCodigosAprobacion( DTOBelcorp dtoin ) throws MareException{
        UtilidadesLog.info("DAOCAR.obtenerCodigosAprobacion( DTOBelcorp):Entrada");
		RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

		try{
			bs = BelcorpService.getInstance();
		}catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

		query.append("SELECT   codaprob.oid_codi_apro OID, i18n.val_i18n descripcion ");
		query.append("    FROM car_codig_aprob codaprob, v_gen_i18n_sicc i18n ");
		query.append("   WHERE i18n.attr_enti = 'CAR_CODIG_APROB' ");
		query.append("     AND i18n.idio_oid_idio = " + dtoin.getOidIdioma().toString());
		query.append("     AND i18n.attr_num_atri = 1 ");
		query.append("     AND i18n.val_oid = codaprob.oid_codi_apro ");
		query.append("ORDER BY descripcion");

		try {
			rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		
        UtilidadesLog.info("DAOCAR.obtenerCodigosAprobacion( DTOBelcorp):Salida");
		return rs;
	}


	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Este metodo realiza una consutlta a través del DBService de MARE contra la entidad 
	 *              "CAR:EjecutivosCuenta" y la entidad OWN_MARE.PRINCIPALS Esta consulta todos los 
	 *              registros que se encuentran en la entidad de CAR:EjecutivosCuenta, haciendo un join con la
	 *              entidad OWN_MARE.USERS a través del codigo de CAR:EjecutivoCuenta y PRINCIPALS.IDPRINCIPAL. 
	 *              Sacando de esta ultima la informacion y de la entidad OWN_MARE.PROPERTYVALUES los datos 
	 *              necesarios para poder retornar los datos que se necesitan. (-> Ver detalle de como hacer 
	 *              esto en DAOUSUARIO.consultaUsuario del modulo de MEN).
	 *              La consulta retorna un RecordSet con el oid del ejecutivo y un string donde se concatena: 
	 *              codigo usuario, primer apellido, segundo apellido, primer nombre y segundo nombre. 
	 *              Se debe ordernar por el oidEjecutivo. 
	 *              Se debe restringir la consulta al número de registros indicados en el tamaño de página y 
	 *              filtrando para retornar los ejecutivos posteriores al indicador recibido. 
	 */
	public RecordSet obtenerEjecutivosPaginado(DTOPaginado dtoin) throws MareException{
        UtilidadesLog.info("DAOCAR.obtenerEjecutivosPaginado(DTOPaginado):Entrada");
		RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

		try{
			bs = BelcorpService.getInstance();
		}catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

		query.append("select ejecCuenta.OID_EJEC_CUEN as oid, aux.descripcion ");
		query.append(" from  CAR_EJECU_CUENT ejecCuenta, ");
		query.append(" (SELECT p.IDPRINCIPAL,CONCAT(p.name,CONCAT(' ',CONCAT(pv.STRINGVALUE,CONCAT ");
		query.append(" (' ',CONCAT(pv2.STRINGVALUE,CONCAT(' ',CONCAT(pv3.STRINGVALUE,CONCAT(' ',pv4.STRINGVALUE)))))))) descripcion ");
		query.append(" FROM Principals p ");
		query.append(" LEFT JOIN PROPERTYVALUES pv ON pv.IDPROPERTY=2 AND pv.IDPRINCIPAL= p.IDPRINCIPAL ");
		query.append(" LEFT JOIN PROPERTYVALUES pv2 ON pv2.IDPROPERTY=3 AND pv2.IDPRINCIPAL= p.IDPRINCIPAL ");
		query.append(" LEFT JOIN PROPERTYVALUES pv3 ON pv3.IDPROPERTY=5 AND pv3.IDPRINCIPAL= p.IDPRINCIPAL ");
		query.append(" LEFT JOIN PROPERTYVALUES pv4 ON pv4.IDPROPERTY=6 AND pv4.IDPRINCIPAL=p.IDPRINCIPAL ) aux ");
		query.append(" where aux.IDPRINCIPAL = ejecCuenta.USER_EJEC_CUEN ");
		query.append(" and ejecCuenta.PAIS_OID_PAIS = " + dtoin.getOidPais().toString());

		String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoin);

		try {
			rs = bs.dbService.executeStaticQuery(queryPaginada.toString());
        }
        catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		
        UtilidadesLog.info("DAOCAR.obtenerEjecutivosPaginado(DTOPaginado):Salida");
		return rs;
	}

    public RecordSet consultarSolicitudesBloqueadas2( DTOBusquedaSolBloqueadas dtoin ) throws MareException{
        UtilidadesLog.info("DAOCAR.consultarSolicitudesBloqueadas2( DTOBusquedaSolBloqueadas):Entrada");
		RecordSet rs = new RecordSet();
		StringBuffer query = new StringBuffer();
        String strIN= new String("");
        BelcorpService bs;
		bs = BelcorpService.getInstance();
    
        
        query.append("  SELECT solientrbloq.oid_soli_entr_bloq OID  ");
        query.append("  ,zona.des_zona ");
        query.append("  ,cliente.cod_clie ");
        query.append("  ,CONCAT (cliente.val_nom1, CONCAT (' ', CONCAT (cliente.val_nom2, CONCAT (' ', ");
        query.append("              CONCAT (cliente.val_ape1, CONCAT (' ',cliente.val_ape2 )))) ) ) nombrecliente ");
        query.append("  ,soliccabec.val_nume_soli  ");
        query.append("  ,Pq_Apl_Aux.valor_gen_i18n_sicc (" + dtoin.getOidIdioma().toString() + ", periodo.tipe_oid_tipo_peri,  'SEG_TIPO_PERIO' ) AS tipoperiodo ");
        query.append("  ,Pq_Apl_Aux.valor_gen_i18n_sicc (" + dtoin.getOidIdioma().toString() + ", periodo.oid_peri,  'SEG_PERIO_CORPO' ) AS periodo   ");
        query.append("  ,solientrbloq.val_mont_orde  ");
        query.append("  ,solientrbloq.val_mont_deud_venc ");
        query.append("  ,Pq_Apl_Aux.valor_gen_i18n_sicc (" + dtoin.getOidIdioma().toString() + ", solientrbloq.espe_oid_esta_pedi, 'CAR_ESTAT_PEDID' ) AS estatus ");
        query.append("  ,solientrbloq.ind_vali_1 ");
        query.append("  ,solientrbloq.ind_vali_2 ");
        query.append("  ,solientrbloq.ind_vali_3 ");
        query.append("  ,solientrbloq.ind_vali_4 ");
        query.append("  ,Pq_Apl_Aux.valor_gen_i18n_sicc (" + dtoin.getOidIdioma().toString() + ", solientrbloq.niri_oid_nive_ries,'CAR_NIVEL_RIESG' ) AS nivelriesgo ");
        query.append("  ,(SELECT  niveljerar.cod_jera FROM car_jerar niveljerar WHERE  niveljerar.oid_jera = solientrbloq.jera_oid_jera) cod_jera ");
        query.append("  , aux.descripcion ");
        query.append("  ,Pq_Apl_Aux.valor_gen_i18n_sicc (" + dtoin.getOidIdioma().toString() + ", solientrbloq.grso_oid_grup_soli, 'CAR_GRUPO_SOLIC' ) AS gruposolicitud ");
        query.append("  ,(SELECT marca.des_marc FROM seg_marca marca WHERE marca.oid_marc = craperio2.marc_oid_marc) ");
        query.append("  ,Pq_Apl_Aux.valor_gen_i18n_sicc (" + dtoin.getOidIdioma().toString() + ", craperio2.cana_oid_cana, 'SEG_CANAL' ) AS canal ");
        query.append("   , (SELECT subgerencia.des_subg_vent FROM ZON_SUB_GEREN_VENTA  subgerencia WHERE  ");
        query.append("              subgerencia.oid_subg_vent = region.zsgv_oid_subg_vent AND  subgerencia.pais_oid_pais = "+ dtoin.getOidPais().toString()+" ) des_subg_vent ");
        query.append(" ,region.des_regi  ");
        query.append(" ,(SELECT CONCAT  (gerentezona.val_nom1, CONCAT (' ', CONCAT (gerentezona.val_nom2, CONCAT (' ', ");
        query.append("          CONCAT (gerentezona.val_ape1, CONCAT (' ', gerentezona.val_ape2 ) ) ) ) ) ) ");
        query.append(" FROM MAE_CLIEN gerentezona  ");
        query.append(" WHERE  gerentezona.oid_clie = zona.clie_oid_clie  ");
        query.append(" AND gerentezona.pais_oid_pais = "+ dtoin.getOidPais().toString()+"  ) nomb_gerentezona  ");
        query.append(" ,solientrbloq.jera_oid_jera  ");
        query.append(" FROM  ");
        query.append(" (SELECT * FROM CAR_SOLI_ENTR_BLOQ solientrbloq  ");
        query.append("      WHERE  solientrbloq.pais_oid_pais = "+ dtoin.getOidPais().toString()+" ");
        if( dtoin.getEstatusBloqueado() != null){
            strIN = ConstantesCAR.ESTATUS_BLOQUEADO + ", ";
        }
        if( dtoin.getEstatusLiberado() != null){
            strIN = strIN + ConstantesCAR.ESTATUS_LIBERADO + ", ";
        }
        if( dtoin.getEstatusReasignado() != null){
            strIN = strIN + ConstantesCAR.ESTATUS_REASIGNADO + ", ";
        }
		if( dtoin.getEstatusRechazado() != null){
            strIN = strIN + ConstantesCAR.ESTATUS_RECHAZADO + ", ";
        }
        
        if (strIN.length()>0){
            strIN = strIN.substring(0,strIN.length() -2 );
            query.append("      AND solientrbloq.espe_oid_esta_pedi IN ("+strIN+") ");
        }
        query.append(" ) solientrbloq, ");
        query.append("  (SELECT * FROM ZON_ZONA zona WHERE  zona.pais_oid_pais = "+ dtoin.getOidPais().toString()+" ");
        if( dtoin.getOidZona() != null ){
			query.append("   AND zona.oid_zona = " + dtoin.getOidZona());
		}
        query.append(" ) zona , ");
        query.append(" MAE_CLIEN cliente,  ");
        query.append(" PED_SOLIC_CABEC soliccabec,  ");
        query.append(" seg_perio_corpo periodo,  ");
        query.append(" (SELECT * FROM CRA_PERIO craperio2 WHERE pais_oid_pais = "+ dtoin.getOidPais().toString()+") craperio2,  ");
        query.append("  (SELECT CONCAT (p.NAME, CONCAT (' ', CONCAT (pv.stringvalue, CONCAT  ");
        query.append("  (' ', CONCAT  (pv2.stringvalue,  CONCAT (' ',  CONCAT  (pv3.stringvalue,  CONCAT (' ',  pv4.stringvalue ) ) ) ) ) ) ) ) descripcion,oid_ejec_cuen ");
        query.append("  FROM CAR_EJECU_CUENT ejecucuent, principals p, propertyvalues pv ,propertyvalues pv2 ,propertyvalues pv3, propertyvalues pv4 ");
        query.append("  WHERE 	pv.idproperty = 2  ");
        query.append("  AND pv.idprincipal(+) = p.idprincipal ");
        query.append("  AND pv2.idproperty = 3 ");
        query.append("  AND pv2.idprincipal (+)= p.idprincipal ");
        query.append("  AND pv3.idproperty = 5 ");
        query.append("  AND pv3.idprincipal (+)= p.idprincipal ");
        query.append("  AND pv4.idproperty = 6 ");
        query.append("  AND pv4.idprincipal(+) = p.idprincipal ");
        
        if (dtoin.getEjecutivo()!= null){
            query.append("  AND p.NAME = '" + dtoin.getEjecutivo() +"'  ");
        }
        query.append("  AND ejecucuent.user_ejec_cuen =p.idprincipal )  aux, ");
        query.append(" (SELECT * FROM VCA_ZON_REGIO region WHERE region.cod_usua = '" + this.usuario_ses + "' ");
        if( dtoin.getOidRegion() != null ){
            query.append("   AND region.oid_regi = " + dtoin.getOidRegion().toString());	
        }
        query.append("  ) region ");
        query.append(" WHERE zona.oid_zona = solientrbloq.zzon_oid_zona  ");
        query.append("  AND cliente.oid_clie = solientrbloq.clie_oid_clie ");
        query.append("  AND soliccabec.oid_soli_cabe = solientrbloq.soca_oid_soli_cabe ");
        query.append("  AND craperio2.oid_peri = solientrbloq.perd_oid_peri ");
        query.append("  AND periodo.oid_peri = craperio2.peri_oid_peri ");
        query.append("  AND region.oid_regi = zona.zorg_oid_regi ");
        query.append("  AND soliccabec.PERD_OID_PERI = craperio2.oid_peri ");
        query.append("  AND soliccabec.zzon_oid_zona 	= zona.oid_zona ");
        query.append("  AND soliccabec.pais_oid_pais = craperio2.pais_oid_pais ");
        query.append("  AND aux.oid_ejec_cuen(+) = solientrbloq.ejcu_oid_ejec_cuen ");
        
        if( dtoin.getOidMarca() != null ){
			query.append("   AND craperio2.marc_oid_marc = " + dtoin.getOidMarca().toString());
		}
        if( dtoin.getOidCanal() != null ){
			query.append("   AND craperio2.CANA_OID_CANA = " + dtoin.getOidCanal().toString());		
		}
        if( dtoin.getOidSubgerencia() != null ){
			query.append("   AND region.zsgv_oid_subg_vent = " + dtoin.getOidSubgerencia().toString());
		}
        if( dtoin.getOidNivelJerarquico() != null ){
			query.append("   AND solientrbloq.jera_oid_jera = " + dtoin.getOidNivelJerarquico().toString());
		}
        if( dtoin.getOidNivelRiesgo() != null ){
            query.append("   AND solientrbloq.oid_nive_ries  = " + dtoin.getOidNivelRiesgo().toString());
		}
        if( dtoin.getValidacion1().equals(new Integer(0)) ){
			query.append("   AND solientrbloq.ind_vali_1 = " + dtoin.getValidacion1().toString());
		}
		if( dtoin.getValidacion2().equals(new Long(0)) ){
			query.append("   AND solientrbloq.ind_vali_2 = " + dtoin.getValidacion2().toString());
		}
		if( dtoin.getValidacion3().equals(new Long(0)) ){
			query.append("   AND solientrbloq.ind_vali_3 = " + dtoin.getValidacion3().toString());	
		}
		if( dtoin.getValidacion4().equals(new Long(0)) ){
			query.append("   AND solientrbloq.ind_vali_4 = " + dtoin.getValidacion4().toString());
		}
		if( dtoin.getOidGrupoSolicitud() != null ){
			query.append("   AND solientrbloq.grso_oid_grup_soli = " + dtoin.getOidGrupoSolicitud().toString());
		}
        if( dtoin.getEjecutivo() != null ){
			query.append("	 and aux.descripcion like '%" + dtoin.getEjecutivo() + "%' ");
		}
		if( dtoin.getOidPeriodo() != null ){
			query.append("   AND craperio2.oid_peri = " + dtoin.getOidPeriodo().toString());
		}
		if( dtoin.getMontoOrdenDesde() != null ){
			query.append("   AND solientrbloq.val_mont_orde >= " + dtoin.getMontoOrdenDesde().toString());	
		}
		if( dtoin.getMontoOrdenHasta() != null ){
			query.append("   AND solientrbloq.val_mont_orde <= " + dtoin.getMontoOrdenHasta().toString());
		}
		if( dtoin.getMontoDeudaDesde() != null ){
			query.append("   AND solientrbloq.val_mont_deud_venc >= " + dtoin.getMontoDeudaDesde().toString());
		}
		if( dtoin.getMontoDeudaHasta() != null ){
			query.append("   AND solientrbloq.val_mont_deud_venc <= " + dtoin.getMontoDeudaHasta().toString());
		}
      
        String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoin);
        try {
			rs = bs.dbService.executeStaticQuery(queryPaginada.toString());
        }
        catch (Exception ex) {
			UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if (!(rs.getRowCount()>0)){
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
		
        UtilidadesLog.info("DAOCAR.consultarSolicitudesBloqueadas2(DTOBusquedaSolBloqueadas):Salida");
		return rs;  
    
    }

	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       27/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: 
	 */	
	public RecordSet consultarSolicitudesBloqueadas( DTOBusquedaSolBloqueadas dtoin ) throws MareException{
        UtilidadesLog.info("DAOCAR.consultarSolicitudesBloqueadas( DTOBusquedaSolBloqueadas):Entrada");
		RecordSet rs = new RecordSet();
		StringBuffer query = new StringBuffer();
        BelcorpService bs;

		try{
			bs = BelcorpService.getInstance();
		}catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

		query.append("SELECT solientrbloq.oid_soli_entr_bloq OID, zona.des_zona , cliente.COD_CLIE, ");
		query.append("       CONCAT(cliente.val_nom1, CONCAT (' ', CONCAT (cliente.val_nom2, CONCAT (' ',");
		query.append("          CONCAT (cliente.val_ape1, CONCAT (' ', cliente.val_ape2)))))) nombrecliente,");
        query.append("       soliccabec.val_nume_soli, ");
        query.append("Pq_Apl_Aux.Valor_Gen_I18n_Sicc(" + dtoin.getOidIdioma().toString() + ",tipoperiodo.oid_tipo_peri, 'SEG_TIPO_PERIO'" + ") AS tipoperiodo,");
        query.append("Pq_Apl_Aux.Valor_Gen_I18n_Sicc(" + dtoin.getOidIdioma().toString() + ",periodo.OID_PERI, 'SEG_PERIO_CORPO'" + ") as Periodo,");
		query.append("		 solientrbloq.val_mont_orde,");
		query.append("       solientrbloq.val_mont_deud_venc, ");
        query.append("Pq_Apl_Aux.Valor_Gen_I18n_Sicc(" + dtoin.getOidIdioma().toString() + ",estatus.oid_esta_pedi, 'CAR_ESTAT_PEDID'" + ") as estatus,");
		query.append("       solientrbloq.ind_vali_1, solientrbloq.ind_vali_2,");
		query.append("       solientrbloq.ind_vali_3, solientrbloq.ind_vali_4,");
        query.append("Pq_Apl_Aux.Valor_Gen_I18n_Sicc(" + dtoin.getOidIdioma().toString() + ",nivelriesgo.OID_NIVE_RIES, 'CAR_NIVEL_RIESG'" + ") as NivelRiesgo,");
        query.append("       niveljerar.cod_jera, aux.descripcion,");
        query.append("Pq_Apl_Aux.Valor_Gen_I18n_Sicc(" + dtoin.getOidIdioma().toString() + ",gruposolic.oid_grup_soli, 'CAR_GRUPO_SOLIC'" + ") as gruposolicitud,");
        query.append("       marca.des_marc,");
        query.append("Pq_Apl_Aux.Valor_Gen_I18n_Sicc(" + dtoin.getOidIdioma().toString() + ",canal.oid_cana, 'SEG_CANAL'" + ") as canal,");
        query.append("       subgerencia.DES_SUBG_VENT,");
		query.append("       region.DES_REGI,");
		query.append("       CONCAT(gerentezona.val_nom1, CONCAT (' ', CONCAT (gerentezona.val_nom2, CONCAT (' ',");
		query.append("          CONCAT (gerentezona.val_ape1, CONCAT (' ', gerentezona.val_ape2)))))) Nomb_gerentezona,");
		query.append("       jerar.oid_jera");
		query.append("  FROM car_soli_entr_bloq solientrbloq,");
		query.append("       vca_zon_zona zona,");
		query.append("       mae_clien cliente,");
		query.append("       ped_solic_cabec soliccabec,");
		//query.append("       v_gen_i18n_sicc i18ntipoperiodo,");
		query.append("       seg_tipo_perio tipoperiodo,");
		//query.append("       v_gen_i18n_sicc i18nPeriodo,");
		query.append("       seg_perio_corpo periodo,");
		//query.append("       v_gen_i18n_sicc i18nestatus,");
		query.append("       car_estat_pedid estatus,");
		query.append("       car_nivel_riesg nivelriesgo,");
		//query.append("	     v_gen_i18n_sicc i18nNivelRiesgo,");
		query.append("       car_jerar niveljerar,");
		query.append("	   (SELECT p.idprincipal, CONCAT(p.NAME, CONCAT(' ', CONCAT(pv.stringvalue, CONCAT");
		query.append("       	   (' ', CONCAT (pv2.stringvalue, CONCAT (' ', CONCAT (pv3.stringvalue,");
		query.append("  	  CONCAT (' ', pv4.stringvalue)))))))) descripcion");
		query.append("        FROM principals p LEFT JOIN propertyvalues pv ON pv.idproperty = 2");
		query.append("        AND  pv.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv2 ON pv2.idproperty = 3");
		query.append("		  AND  pv2.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv3 ON pv3.idproperty = 5");
		query.append("		  AND  pv3.idprincipal = p.idprincipal LEFT JOIN propertyvalues pv4 ON pv4.idproperty = 6");
		query.append("        AND  pv4.idprincipal = p.idprincipal) aux,");
		//query.append("	     v_gen_i18n_sicc i18ngruposolic,");
		query.append("       car_grupo_solic gruposolic,");
		query.append("       seg_marca marca,");
		//query.append("       v_gen_i18n_sicc i18ncanal,");
		query.append("       seg_canal canal,");
		query.append("       vca_zon_sub_geren_venta subgerencia,");
		query.append("       vca_zon_regio region,");
		query.append("       mae_clien gerentezona,");
		query.append("       car_jerar jerar,");
		query.append("       cra_perio craperio,");
		query.append("       cra_perio craperio2,");
		query.append("       car_ejecu_cuent ejecucuent");
		query.append(" WHERE zona.oid_zona(+) = solientrbloq.zzon_oid_zona");
		query.append("   AND zona.COD_USUA = '" + this.usuario_ses + "' ");
		query.append("   AND cliente.oid_clie(+) = solientrbloq.clie_oid_clie");
		query.append("   AND soliccabec.oid_soli_cabe(+) = solientrbloq.soca_oid_soli_cabe");
		query.append("   AND craperio.oid_peri(+) = solientrbloq.perd_oid_peri");
		query.append("   AND periodo.oid_peri(+) = craperio.peri_oid_peri");
		//query.append("   and i18nPeriodo.ATTR_ENTI(+) = 'SEG_PERIO_CORPO'");
		//query.append("   and i18nPeriodo.ATTR_NUM_ATRI(+) = 1");
		//query.append("   and i18nPeriodo.IDIO_OID_IDIO(+) = " + dtoin.getOidIdioma().toString());
		//query.append("   and i18nPeriodo.VAL_OID(+) = periodo.OID_PERI");
		query.append("   AND tipoperiodo.oid_tipo_peri(+) = periodo.tipe_oid_tipo_peri");
		query.append("   AND estatus.oid_esta_pedi(+) = solientrbloq.espe_oid_esta_pedi");
		//query.append("   AND nivelriesgo.oid_nive_ries(+) = solientrbloq.espe_oid_esta_pedi");
		query.append("   AND nivelriesgo.oid_nive_ries(+) = solientrbloq.niri_oid_nive_ries");    
		//query.append("   and i18nNivelRiesgo.ATTR_ENTI(+) = 'CAR_NIVEL_RIESG'");
		//query.append("	 and i18nNivelRiesgo.IDIO_OID_IDIO(+) = " + dtoin.getOidIdioma().toString() );
		//query.append("	 and i18nNivelRiesgo.ATTR_NUM_ATRI(+) = 1");
		//query.append("	 and i18nNivelRiesgo.VAL_OID(+) = nivelriesgo.OID_NIVE_RIES");
		query.append("   AND niveljerar.OID_JERA(+) = solientrbloq.jera_oid_jera");
		query.append("   AND ejecucuent.oid_ejec_cuen(+) = solientrbloq.ejcu_oid_ejec_cuen");
		query.append("   AND aux.idprincipal(+) = ejecucuent.user_ejec_cuen");
		query.append("   AND gruposolic.oid_grup_soli(+) = solientrbloq.grso_oid_grup_soli");
		query.append("   AND craperio2.oid_peri(+) = solientrbloq.perd_oid_peri");
		query.append("   AND marca.oid_marc(+) = craperio2.marc_oid_marc");
		query.append("   AND canal.oid_cana(+) = craperio2.cana_oid_cana");
		query.append("   AND region.oid_regi(+) = zona.zorg_oid_regi");
		query.append("	 AND region.COD_USUA(+) = '" + this.usuario_ses + "' ");
		query.append("   AND subgerencia.oid_subg_vent(+) = region.zsgv_oid_subg_vent");
		query.append("   AND subgerencia.PAIS_OID_PAIS(+) = " + dtoin.getOidPais().toString());
		query.append("   AND subgerencia.COD_USUA(+) = '" + this.usuario_ses + "'");
		if( dtoin.getOidMarca() != null ){
			query.append("   AND subgerencia.MARC_OID_MARC(+) = " + dtoin.getOidMarca().toString());
		}
		if( dtoin.getOidCanal() != null ){
			query.append("   AND subgerencia.CANA_OID_CANA(+) = " + dtoin.getOidCanal().toString());		
		}
		query.append("   AND gerentezona.oid_clie(+) = zona.clie_oid_clie");
		query.append("   AND jerar.oid_jera(+) = solientrbloq.jera_oid_jera");
		//query.append("   AND i18ntipoperiodo.attr_enti(+) = 'SEG_TIPO_PERIO'");
		//query.append("   AND i18ntipoperiodo.idio_oid_idio(+) = " + dtoin.getOidIdioma().toString() );	
		//query.append("   AND i18ntipoperiodo.attr_num_atri(+) = 1");
		//query.append("   AND i18ntipoperiodo.val_oid(+) = tipoperiodo.oid_tipo_peri");
		//query.append("   AND i18nestatus.attr_enti(+) = 'CAR_ESTAT_PEDID'");
		//query.append("   AND i18nestatus.idio_oid_idio(+) = " + dtoin.getOidIdioma().toString());
		//query.append("   AND i18nestatus.attr_num_atri(+) = 1");
		//query.append("   AND i18nestatus.val_oid(+) = estatus.oid_esta_pedi");	
		//query.append("   AND i18ngruposolic.attr_enti(+) = 'CAR_GRUPO_SOLIC'");
		//query.append("   AND i18ngruposolic.idio_oid_idio(+) = " + dtoin.getOidIdioma().toString());
		//query.append("   AND i18ngruposolic.attr_num_atri(+) = 1");
		//query.append("   AND i18ngruposolic.val_oid(+) = gruposolic.oid_grup_soli");
		//query.append("   AND i18ncanal.attr_enti(+) = 'SEG_CANAL'");
		//query.append("   AND i18ncanal.idio_oid_idio(+) = " + dtoin.getOidIdioma().toString() );	
		//query.append("   AND i18ncanal.attr_num_atri(+) = 1");
		//query.append("   AND i18ncanal.val_oid(+) = canal.oid_cana");
		if( dtoin.getOidMarca() != null ){
			query.append("   AND marca.oid_marc = " + dtoin.getOidMarca().toString());
		}
		if( dtoin.getOidCanal() != null ){
			query.append("   AND canal.oid_cana = " + dtoin.getOidCanal().toString());
		}
		if( dtoin.getOidSubgerencia() != null ){
			query.append("   AND subgerencia.oid_subg_vent = " + dtoin.getOidSubgerencia().toString());
		}
		if( dtoin.getOidRegion() != null ){
			query.append("   AND region.oid_regi = " + dtoin.getOidRegion().toString());	
		}
		if( dtoin.getOidZona() != null ){
			query.append("   AND zona.oid_zona = " + dtoin.getOidZona());
		}
		if( dtoin.getOidNivelJerarquico() != null ){
			query.append("   AND niveljerar.oid_jera = " + dtoin.getOidNivelJerarquico().toString());
		}
		if( dtoin.getOidNivelRiesgo() != null ){
			//query.append("   AND nivelriesgo.cod_nive_ries = " + dtoin.getOidNivelRiesgo().toString());
      query.append("   AND nivelriesgo.oid_nive_ries  = " + dtoin.getOidNivelRiesgo().toString());
		}
		
		if( dtoin.getValidacion1().equals(new Integer(0)) ){
			query.append("   AND solientrbloq.ind_vali_1 = " + dtoin.getValidacion1().toString());
		}
		if( dtoin.getValidacion2().equals(new Long(0)) ){
			query.append("   AND solientrbloq.ind_vali_2 = " + dtoin.getValidacion2().toString());
		}
		if( dtoin.getValidacion3().equals(new Long(0)) ){
			query.append("   AND solientrbloq.ind_vali_3 = " + dtoin.getValidacion3().toString());	
		}
		if( dtoin.getValidacion4().equals(new Long(0)) ){
			query.append("   AND solientrbloq.ind_vali_4 = " + dtoin.getValidacion4().toString());
		}
		if( dtoin.getOidGrupoSolicitud() != null ){
			query.append("   AND gruposolic.oid_grup_soli = " + dtoin.getOidGrupoSolicitud().toString());
		}
		if( dtoin.getEstatusBloqueado() != null || dtoin.getEstatusLiberado() != null || 
			dtoin.getEstatusReasignado() != null || dtoin.getEstatusRechazado() != null ){
			query.append(" AND ( ");
			int selecciones = 0;
			if( dtoin.getEstatusBloqueado() != null ) selecciones++;
			if( dtoin.getEstatusLiberado() != null ) selecciones++;
			if( dtoin.getEstatusReasignado() != null ) selecciones++;
			if( dtoin.getEstatusRechazado() != null ) selecciones++;
			
			if( dtoin.getEstatusBloqueado() != null ){
				query.append(" estatus.oid_esta_pedi like " + ConstantesCAR.ESTATUS_BLOQUEADO);
				if( selecciones > 1 ){ 
					query.append(" OR ");
					selecciones--;
				}				
			}
			if( dtoin.getEstatusLiberado() != null ){
				query.append(" estatus.oid_esta_pedi like " + ConstantesCAR.ESTATUS_LIBERADO);
				if( selecciones > 1 ){ 
					query.append(" OR ");
					selecciones--;
				}				
			}
			if( dtoin.getEstatusReasignado() != null ){
				query.append(" estatus.oid_esta_pedi like " + ConstantesCAR.ESTATUS_REASIGNADO);
				if( selecciones > 1 ){ 
					query.append(" OR ");
					selecciones--;
				}				
			}
			if( dtoin.getEstatusRechazado() != null ){
				query.append(" estatus.oid_esta_pedi like " + ConstantesCAR.ESTATUS_RECHAZADO );
				if( selecciones > 1 ){ 
					query.append(" OR ");
					selecciones--;
				}				
			}

			query.append(" ) ");
		}
		if( dtoin.getEjecutivo() != null ){
			query.append("	 and aux.descripcion like '%" + dtoin.getEjecutivo() + "%' ");
		}
		if( dtoin.getOidPeriodo() != null ){
			query.append("   AND craperio2.oid_peri = " + dtoin.getOidPeriodo().toString());
		}
		if( dtoin.getMontoOrdenDesde() != null ){
			query.append("   AND solientrbloq.val_mont_orde >= " + dtoin.getMontoOrdenDesde().toString());	
		}
		if( dtoin.getMontoOrdenHasta() != null ){
			query.append("   AND solientrbloq.val_mont_orde <= " + dtoin.getMontoOrdenHasta().toString());
		}
		if( dtoin.getMontoDeudaDesde() != null ){
			query.append("   AND solientrbloq.val_mont_deud_venc >= " + dtoin.getMontoDeudaDesde().toString());
		}
		if( dtoin.getMontoDeudaHasta() != null ){
			query.append("   AND solientrbloq.val_mont_deud_venc <= " + dtoin.getMontoDeudaHasta().toString());
		}
		String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoin);
		try {
			rs = bs.dbService.executeStaticQuery(queryPaginada.toString());
        }
        catch (Exception ex) {
			UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		UtilidadesLog.debug("RETORNO: " + rs);
        UtilidadesLog.info("DAOCAR.consultarSolicitudesBloqueadas(DTOBusquedaSolBloqueadas):Salida");
		return rs;
		
	}

  /**
   * 
   * @webmethod 
   */
    public DTOJerarquia[] obtenerDatosJerarquia() throws MareException {
        UtilidadesLog.info("DAOCAR.obtenerDatosJerarquia():Entrada");
        RecordSet rs = new RecordSet();
        DTOJerarquia reg = null;
        ArrayList arrJerarquia = new ArrayList();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

		try{
			bs = BelcorpService.getInstance();
		}catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

		query.append("SELECT OID_JERA, COD_JERA, NUM_DIAS, VAL_PORC_MONT_MAXI, VAL_PORC_LINE_CRED ");
		query.append(" FROM CAR_JERAR ");		
		query.append(" ORDER BY COD_JERA ");

		try {
			rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		

        // Devuelve un array de DTOJerarquia
        for(int i=0; i< rs.getRowCount(); i++){
            reg = new DTOJerarquia();

            reg.setOidJerarquia(new Long(((BigDecimal)rs.getValueAt(i, "OID_JERA")).longValue()));
            reg.setCodJerarquia((String)rs.getValueAt(i, "COD_JERA"));
            reg.setNumDias(new Long(((BigDecimal)rs.getValueAt(i, "NUM_DIAS")).longValue()));
            reg.setExcesoMontoMaximo((BigDecimal)rs.getValueAt(i, "VAL_PORC_MONT_MAXI"));
            reg.setExcesoLineaCredito((BigDecimal)rs.getValueAt(i, "VAL_PORC_LINE_CRED"));
            
            arrJerarquia.add(reg);
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        UtilidadesLog.info("DAOCAR.obtenerDatosJerarquia():Salida");
        return (DTOJerarquia[])arrJerarquia.toArray(new DTOJerarquia[arrJerarquia.size()]);
    }

    /**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       24/09/2004
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
   // @scsaavedra - 29/08/2006, inc. BELC300024045
    public DTOCodigoConfiguracion obtenerCodigoConfiguracionAsociado(Long oidNivelRiesgo, Long oidTipoSolPais, Long oidZona) throws MareException {
        UtilidadesLog.info("DAOCAR.obtenerCodigoConfiguracionAsociado(Long , Long , Long):Entrada");
        RecordSet rs = new RecordSet();
        DTOCodigoConfiguracion dtoCodigoConfiguracion = new DTOCodigoConfiguracion(); 
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

		try{
			bs = BelcorpService.getInstance();
		}catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append("SELECT CG.ZSGV_OID_SUBG_VENT,CG.ZORG_OID_REGI,CG.ZZON_OID_ZONA, ");
        query.append(" CO.OID_PARA_CART,CO.COD_CONF,CO.NIRI_OID_NIVE_RIES,CO.GRSO_OID_GRUP_SOLI, ");		
        query.append(" CO.IND_DEUD_VENC,CO.NUM_DIAS_DEUD_VENC, ");        
        query.append(" CO.IND_LINE_CRED,CO.FEC_VIGE_DESD,CO.FEC_VIGE_HAST,CO.INVA_OID_INDI_VALI,CO.VAL_PORC_VALI, ");		
      	query.append(" CO.IND_MONT_MAXI,CO.VAL_MONT_MAXI_PERM, ");
        query.append(" CO.IND_PORC_MAXI,CO.VAL_PORC,CO.NUM_DIAS_ADIC,TS.OID_TIPO_SOLI ");		
      	query.append(" FROM CAR_ASIGN_CODIG_CONFI CG, CAR_PARAM_CARTE CO, ");
        query.append(" ZON_ZONA ZO, ZON_REGIO RE, ");		
      	query.append(" PED_TIPO_SOLIC_PAIS TSP, PED_TIPO_SOLIC TS ");
        query.append(" WHERE CG.NIRI_OID_NIVE_RIES = " + oidNivelRiesgo);
        query.append(" AND TSP.OID_TIPO_SOLI_PAIS = " + oidTipoSolPais);		
        if (oidZona!=null){
            query.append(" AND ZO.OID_ZONA = " + oidZona);
        }
        query.append(" AND TS.OID_TIPO_SOLI=TSP.TSOL_OID_TIPO_SOLI ");		
        query.append(" AND TS.GRSO_OID_GRUP_SOLI=CG.GRSO_OID_GRUP_SOLI ");
    
        //query.append(" AND ZO.ZORG_OID_REGI=RE.OID_REGI ");
        query.append(" AND (ZO.ZORG_OID_REGI = RE.OID_REGI or ZO.ZORG_OID_REGI is null)");
        
        query.append(" AND CG.PACA_OID_PARA_CART=CO.OID_PARA_CART ");		
		    query.append(" AND CG.ZSGV_OID_SUBG_VENT=RE.ZSGV_OID_SUBG_VENT ");
        query.append(" AND (CG.ZORG_OID_REGI=RE.OID_REGI OR CG.ZORG_OID_REGI IS NULL) ");		
        query.append(" AND (CG.ZZON_OID_ZONA=ZO.OID_ZONA OR CG.ZZON_OID_ZONA IS NULL) ");
        query.append(" ORDER BY CG.ZSGV_OID_SUBG_VENT ASC ,CG.ZORG_OID_REGI ASC,CG.ZZON_OID_ZONA ASC ");
        
		try {
			rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		

        if(rs.esVacio()) {
            return null;
        }
       
        // Crea el DTO de configuracion
        
        dtoCodigoConfiguracion.setOidCodConf(new Long(((BigDecimal)rs.getValueAt(0, "OID_PARA_CART")).longValue()));
        dtoCodigoConfiguracion.setCodConf((String)rs.getValueAt(0, "COD_CONF"));
        dtoCodigoConfiguracion.setNivelRiesgo(new Long(((BigDecimal)rs.getValueAt(0, "NIRI_OID_NIVE_RIES")).longValue()));
        dtoCodigoConfiguracion.setGrupoSolicitud(new Long(((BigDecimal)rs.getValueAt(0, "GRSO_OID_GRUP_SOLI")).longValue()));
        dtoCodigoConfiguracion.setOidTipoSolPED(new Long(((BigDecimal)rs.getValueAt(0, "OID_TIPO_SOLI")).longValue()));
        
        dtoCodigoConfiguracion.setFechaVigenciaDesde((Date)rs.getValueAt(0, "FEC_VIGE_DESD"));
        dtoCodigoConfiguracion.setFechaVigenciaHasta((Date)rs.getValueAt(0, "FEC_VIGE_HAST"));

        if(rs.getValueAt(0, "INVA_OID_INDI_VALI")!= null){
            dtoCodigoConfiguracion.setIndicadorValidacion(new Long(((BigDecimal)rs.getValueAt(0, "INVA_OID_INDI_VALI")).longValue()));
        }

        if(rs.getValueAt(0, "VAL_PORC_VALI")!= null){
            dtoCodigoConfiguracion.setPorcentajeValidacion(new Float(((BigDecimal)rs.getValueAt(0, "VAL_PORC_VALI")).floatValue()));
        }
        
        if(rs.getValueAt(0, "VAL_MONT_MAXI_PERM")!= null){
            dtoCodigoConfiguracion.setMontoMaximoPermitido((BigDecimal)rs.getValueAt(0, "VAL_MONT_MAXI_PERM"));
        }
        
        if(rs.getValueAt(0, "VAL_PORC")!= null){
            dtoCodigoConfiguracion.setPorcentajeMaximoPermitido(new Float(((BigDecimal)rs.getValueAt(0, "VAL_PORC")).floatValue()));
        }
        
        if(rs.getValueAt(0, "NUM_DIAS_ADIC")!= null){
            dtoCodigoConfiguracion.setNumDiasAdicionales(new Integer(((BigDecimal)rs.getValueAt(0, "NUM_DIAS_ADIC")).intValue()));
        }
        
        if(rs.getValueAt(0, "NUM_DIAS_DEUD_VENC")!= null){
            dtoCodigoConfiguracion.setDiasDeudaVenPerm(new Integer(((BigDecimal)rs.getValueAt(0, "NUM_DIAS_DEUD_VENC")).intValue()));
        }

        // Indicadores 
        if(rs.getValueAt(0, "IND_DEUD_VENC")!= null){
            dtoCodigoConfiguracion.setValDiasDeuda(((BigDecimal)rs.getValueAt(0, "IND_DEUD_VENC")).compareTo(new BigDecimal(1))==0?Boolean.TRUE:Boolean.FALSE);
        } else {
            dtoCodigoConfiguracion.setValDiasDeuda(Boolean.FALSE);
        }

        if(rs.getValueAt(0, "IND_LINE_CRED")!= null){
            dtoCodigoConfiguracion.setValLineaCredito(((BigDecimal)rs.getValueAt(0, "IND_LINE_CRED")).compareTo(new BigDecimal(1))==0?Boolean.TRUE:Boolean.FALSE);
        } else {
            dtoCodigoConfiguracion.setValLineaCredito(Boolean.FALSE);
        }

        if(rs.getValueAt(0, "IND_MONT_MAXI")!= null){
            dtoCodigoConfiguracion.setValMontoMaximo(((BigDecimal)rs.getValueAt(0, "IND_MONT_MAXI")).compareTo(new BigDecimal(1))==0?Boolean.TRUE:Boolean.FALSE);
        } else {
            dtoCodigoConfiguracion.setValMontoMaximo(Boolean.FALSE);
        }

        if(rs.getValueAt(0, "IND_PORC_MAXI")!= null){
            dtoCodigoConfiguracion.setValporcentajeMaximo(((BigDecimal)rs.getValueAt(0, "IND_PORC_MAXI")).compareTo(new BigDecimal(1))==0?Boolean.TRUE:Boolean.FALSE);
        } else {
            dtoCodigoConfiguracion.setValporcentajeMaximo(Boolean.FALSE);
        }
        UtilidadesLog.info("DAOCAR.obtenerCodigoConfiguracionAsociado(Long , Long , Long):Salida");
        return dtoCodigoConfiguracion;

    }

    /**
   * Sistema:     Belcorp
   * Modulo:      CAR
   * Fecha:       24/09/2004
   * @version     1.0
   * @autor       Viviana Bongiovanni
   * @webmethod 
   */
   // @scsaavedra - 29/08/2006, inc. BELC300024046, ya estaba!
    public Long obtenerEjecutivoAsociado(Long oidNivelRiesgo, Long oidZona) throws MareException {
        UtilidadesLog.info("DAOCAR.obtenerEjecutivoAsociado(Long , Long):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

		try{
			bs = BelcorpService.getInstance();
		}catch(MareMiiServiceNotFoundException ex) {
			throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

		query.append("SELECT EJ.EJCU_OID_EJEC_CUEN, EJ.ZSGV_OID_SUBG_VENT, EJ.ZORG_OID_REGI,EJ.ZZON_OID_ZONA ");			
		query.append(" FROM CAR_ASIGN_EJECU_CUENT EJ, ");
    query.append(" ZON_ZONA ZO, ZON_REGIO RE ");	
    query.append(" WHERE EJ.NIRI_OID_NIVE_RIES = " + oidNivelRiesgo);     
    if (oidZona!=null){    
		    query.append(" AND ZO.OID_ZONA = " + oidZona);
    } 
    query.append(" AND ZO.ZORG_OID_REGI=RE.OID_REGI ");		
		query.append(" AND EJ.ZSGV_OID_SUBG_VENT=RE.ZSGV_OID_SUBG_VENT ");
    query.append(" AND (EJ.ZORG_OID_REGI=RE.OID_REGI OR EJ.ZORG_OID_REGI IS NULL) ");
    query.append(" AND (EJ.ZZON_OID_ZONA=ZO.OID_ZONA OR EJ.ZZON_OID_ZONA IS NULL) ");
    query.append(" ORDER BY EJ.ZSGV_OID_SUBG_VENT ASC ,EJ.ZORG_OID_REGI ASC,EJ.ZZON_OID_ZONA ASC ");
        
		try {
			rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		

        if(rs.esVacio()) {
            return null;
        }
       
        // Retorna el ejecutivo de cuenta del primer registro        
        UtilidadesLog.info("DAOCAR.obtenerEjecutivoAsociado(Long , Long):Salida");
        return new Long(((BigDecimal)rs.getValueAt(0, "EJCU_OID_EJEC_CUEN")).longValue());
        
    }


  /*****************
  Autor: Viviana Bongiovanni
  Fecha: 05/01/2005
  Obtiene Credito Riesgo
  *********************/
  // @scsaavedra - 29/08/2006, inc. BELC300024045, (ya estaba!!)
  public RecordSet obtenerCreditoRiesgo(Long territorioAdministrativo) throws MareException{
    UtilidadesLog.info("DAOCAR.obtenerCreditoRiesgo(Long):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try{
          bs = BelcorpService.getInstance();
        }catch(MareMiiServiceNotFoundException ex) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT A.niri_oid_nive_ries_inici AS nivelriesgo, ");			
        query.append(" A.val_line_cred_inic AS lineacredito, ");	
        query.append(" A.zsgv_oid_subg_vent AS subgerencia, ");	
        query.append(" A.zorg_oid_regi AS region, ");	
        query.append(" A.zzon_oid_zona AS zona ");	
        query.append(" FROM car_asign_codig_confi A,  ");	
        query.append(" zon_terri_admin B, zon_secci C, ");	
        query.append(" zon_zona D, zon_regio E ");	
        query.append(" WHERE B.oid_terr_admi = " + territorioAdministrativo + " AND ");	
        query.append(" C.oid_secc = B.zscc_oid_secc AND ");	
        query.append(" D.oid_zona = C.zzon_oid_zona AND ");	
        query.append(" E.oid_regi = D.zorg_oid_regi AND ");	
        query.append(" A.zsgv_oid_subg_vent = E.zsgv_oid_subg_vent AND ");	
        query.append(" (A.zorg_oid_regi = D.zorg_oid_regi OR A.zorg_oid_regi IS NULL) AND ");	
        query.append(" (A.zzon_oid_zona = C.zzon_oid_zona OR A.zzon_oid_zona IS NULL) ");	
        query.append(" ORDER BY A.zorg_oid_regi ASC, A.zzon_oid_zona ASC, A.val_line_cred_inic DESC ");	
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        }catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		
        UtilidadesLog.info("DAOCAR.obtenerCreditoRiesgo(Long):Salida");     
        return rs;
        
  }
   /*****************
  Autor: Cintia Argain
  Fecha: 07/01/2005
  Obtiene las órdenes para el caso de uso "Notificar Órdenes Bloqueadas". 
  *********************/
  DTOSalida obtieneOrdenesNotificar (DTOBelcorp dto)throws MareException {
    UtilidadesLog.info("DAOCAR.obtieneOrdenesNotificar(DTOBelcorp):Entrada");
        BelcorpService bs;
        RecordSet r = null;
        StringBuffer query = new StringBuffer();
        Long oidIdioma = dto.getOidIdioma();
  		
        UtilidadesLog.debug("Pais " + dto.getOidPais());       

        query.append("SELECT  ");
        query.append("A.oid_soli_entr_bloq as oid,  ");
        query.append("B.cod_clie as codigocliente,  ");
        //descripción según el idioma del dto de A.grso_oid_grup_soli en V_GEN_I18N_SICC as gruposolicitud,
        query.append("i.VAL_I18N as gruposolicitud,  ");
        //descripción según el idioma del dto de A.espe_oid_esta_pedi en V_GEN_I18N_SICC as estadopedido,
        query.append("i2.VAL_I18N as estadopedido,  ");
        query.append("E.val_nume_soli as numerosolicitud, "); 
        query.append("A.val_mont_orde as montoorden,  ");
        query.append("NVL(A.val_mont_deud_venc, 0) as montodeudavencida,  ");
        query.append("A.ind_vali_1 as validacion1,  ");
        query.append("A.ind_vali_2 as validacion2,  ");
        query.append("A.ind_vali_3 as validacion3,  ");
        query.append("A.ind_vali_4 as validacion4,  ");
        query.append("D.cod_clie as gerentezona,  ");
        query.append("A.ind_noti as notificado,  ");
        query.append("j.COD_TIPO_COMU AS codTipoComunicacion,  ");
        //descripción según el idioma del dto de F.ticm_oid_tipo_comu en V_GEN_I18N_SICC as desctipocomunicacion,
        query.append("i3.VAL_I18N as desctipocomunicacion,   ");
        query.append("F.val_text_comu as comunicacion,  ");
        query.append("A.ind_noti as notificado2  ");
        query.append("FROM  ");
        query.append("car_soli_entr_bloq A,  ");
        query.append("mae_clien B,  ");
        query.append("zon_zona C,  ");
        query.append("mae_clien D,  ");
        query.append("ped_solic_cabec E,  ");
        query.append("mae_clien_comun F, ");
        query.append("v_gen_i18n_sicc i, ");
        query.append("v_gen_i18n_sicc i2, ");
        query.append("v_gen_i18n_sicc i3,  ");
        query.append("mae_tipo_comun j   ");
        query.append("WHERE  ");
        query.append(" A.espe_oid_esta_pedi IN (");
        query.append(ConstantesCAR.ESTATUS_BLOQUEADO + " ," + ConstantesCAR.ESTATUS_RECHAZADO + ") AND" ); 
        
        query.append(" B.oid_clie = A.clie_oid_clie AND ");
        query.append(" C.oid_zona = A.zzon_oid_zona AND ");
        query.append(" D.oid_clie = C.clie_oid_clie AND ");
        query.append(" E.oid_soli_cabe = A.soca_oid_soli_cabe AND ");
        query.append(" F.clie_oid_clie(+) = C.clie_oid_clie AND ");
        query.append(" F.ind_comu_ppal(+) = "+ ConstantesCMN.VAL_TRUE );

        query.append(" and i.VAL_OID = A.grso_oid_grup_soli ");
        query.append(" AND i.ATTR_ENTI = 'CAR_GRUPO_SOLIC' ");
        query.append(" AND i.ATTR_NUM_ATRI = 1");
        query.append(" and i.IDIO_OID_IDIO = " + oidIdioma);

        query.append(" and i2.VAL_OID = A.espe_oid_esta_pedi ");
        query.append(" AND i2.ATTR_ENTI = 'CAR_ESTAT_PEDID' ");
        query.append(" AND i2.ATTR_NUM_ATRI = 1");
        query.append(" and i2.IDIO_OID_IDIO = " + oidIdioma);

        query.append(" and i3.VAL_OID(+) = F.ticm_oid_tipo_comu ");
        query.append(" AND i3.ATTR_ENTI(+) = 'MAE_TIPO_COMUN' ");
        query.append(" AND i3.ATTR_NUM_ATRI(+) = 1");
        query.append(" and i3.IDIO_OID_IDIO(+) = " + oidIdioma);
        query.append(" and j.OID_TIPO_COMU = f.TICM_OID_TIPO_COMU");

        query.append(" ORDER BY D.cod_clie");


    try{
          bs = BelcorpService.getInstance();
        }
        catch (MareMiiServiceNotFoundException ex) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    
    try {
        DTOPaginado dtoin = new DTOPaginado();
        dtoin.setOidIdioma(oidIdioma);
        dtoin.setOidPais(dto.getOidPais());        
        r = bs.dbService.executeStaticQuery(
				UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoin));
                

    } catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.debug("Consulta Ejecutada con Exito" );
        
    DTOSalida output = new DTOSalida();
    output.setResultado(r);
    UtilidadesLog.info("DAOCAR.obtieneOrdenesNotificar(DTOBelcorp):Salida");
    return output;	
  }
  
  
  /**
   * @author mbobadill
   * SICC-DMCO-CAR-201-334-N013
   * @date 10/01/05
   * Obtiene los tipos de re-evaluación 
   */
   
   public DTOSalida obtieneTipoReevaluacion (DTOBelcorp dto) throws MareException{
     UtilidadesLog.info("DAOCAR.obtieneTipoReevaluacion (DTOBelcorp):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try{
          bs = BelcorpService.getInstance();
        }catch(MareMiiServiceNotFoundException ex) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT oid_tipo_reev as oid,b.val_i18n as descripcion ");	
        query.append(" FROM car_tipo_reeva ,v_gen_i18n_sicc b ");
        query.append(" WHERE oid_tipo_reev = b.VAL_OID ");
        query.append(" AND  b.ATTR_ENTI = 'CAR_TIPO_REEVA' ");
        query.append(" AND b.idio_oid_idio = " + dto.getOidIdioma());
        query.append(" AND b.attr_num_atri = 1 ");
        query.append(" order by descripcion");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        }catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }		
             
        DTOSalida out = new DTOSalida();
        out.setResultado(rs);
        UtilidadesLog.info("DAOCAR.obtieneTipoReevaluacion (DTOBelcorp):Salida");
        return out;

   }

  /**
   * @author Cortaberría
   * @date 10/01/05
   * Obtiene los clientes a los que se va a realizar una re-evaluación en masa.
   */ 
  public RecordSet obtieneClientesReevaluarEnMasa (DTOReevaluarEnMasa dto) throws MareException {
    UtilidadesLog.info("DAOCAR.obtieneClientesReevaluarEnMasa (DTOReevaluarEnMasa):Entrada");
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT DISTINCT A.oid_clie as oidCliente");
    query.append(" FROM");
    query.append(" mae_clien A,");
    query.append(" mae_clien_tipo_subti B,");
    query.append(" mae_clien_unida_admin C,");
    query.append(" zon_terri_admin D,");
    query.append(" zon_secci E,");
    query.append(" zon_zona F,");
    query.append(" zon_regio G");
    query.append(" WHERE");
    query.append(" A.pais_oid_pais = ").append(dto.getOidPais()).append(" AND");
    query.append(" B.clie_oid_clie = A.oid_clie AND");
    query.append(" B.ticl_oid_tipo_clie = ").append(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA).append(" AND");
    query.append(" C.clie_oid_clie = B.clie_oid_clie AND ");
    query.append(" C.ind_acti = ").append(ConstantesCMN.VAL_TRUE).append(" AND");
    query.append(" D.oid_terr_admi = C.ztad_oid_terr_admi AND");
    query.append(" D.ind_borr = ").append(ConstantesCMN.VAL_FALSE).append(" AND");
    query.append(" E.oid_secc = D.zscc_oid_secc AND");
    query.append(" E.ind_borr = ").append(ConstantesCMN.VAL_FALSE).append(" AND");
    query.append(" E.ind_acti = ").append(ConstantesCMN.VAL_TRUE).append(" AND"); 
    query.append(" F.oid_zona = E.zzon_oid_zona AND"); 
    query.append(" F.ind_borr = ").append(ConstantesCMN.VAL_FALSE).append(" AND"); 
    query.append(" F.ind_acti = ").append(ConstantesCMN.VAL_TRUE).append(" AND"); 
    query.append(" G.oid_regi = F.zorg_oid_regi AND"); 
    query.append(" G.ind_borr = ").append(ConstantesCMN.VAL_FALSE).append(" AND"); 
    query.append(" G.ind_acti = ").append(ConstantesCMN.VAL_TRUE).append(" AND"); 
    query.append(" G.pais_oid_pais = ").append(dto.getOidPais()).append(" AND"); 
    query.append(" G.marc_oid_marc = ").append(dto.getOidMarca()).append(" AND"); 
    query.append(" G.cana_oid_cana = ").append(dto.getOidCanal()); 

    if (dto.getOidZona() != null) {
      query.append(" AND E.zzon_oid_zona = ").append(dto.getOidZona());
    }
    if (dto.getOidRegion() != null) {
      query.append(" AND F.zorg_oid_regi = ").append(dto.getOidRegion()); 
    }
    if (dto.getOidSubgerencia() != null) {
      query.append(" AND G.zsgv_oid_subg_vent = ").append(dto.getOidSubgerencia()); 
    }

    BelcorpService bs;
    RecordSet r = null;
    
    try{
       bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException ex) {
       throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    
    try {
        r = bs.dbService.executeStaticQuery(query.toString());
    } catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAOCAR.obtieneClientesReevaluarEnMasa (DTOReevaluarEnMasa):Salida");    
    return r;
  }

   /**
   * @Autor Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet
   * @param Double entrada
   * @param Long parametro
   */
  public RecordSet evaluarParametroNR (Long parametro, Double entrada) throws MareException {
    UtilidadesLog.info("DAOCAR.evaluarParametroNR (Long , Double):Entrada");
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT");
    query.append(" NVL(B.val_maxi, ").append(ConstantesCAR.VAL_MAXI).append(") as maximo, ");
    query.append(" B.val_mini as minimo,");
    query.append(" B.val_esca_mini as escala,");
    query.append(" A.val_peso as peso");
    query.append(" FROM car_param_evalu_nr A, car_condi_evalu_nr B");
    query.append(" WHERE");
    query.append(" A.oid_para_eval_nr = ").append(parametro);
    query.append(" AND B.penr_oid_para_eval_nr = A.oid_para_eval_nr");
    query.append(" AND ").append(entrada).append(" BETWEEN B.val_mini AND NVL(B.val_maxi, ").append(ConstantesCAR.VAL_MAXI).append(")");
      
    BelcorpService bs;
    RecordSet r = null;
    
    try{
       bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException ex) {
       throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    
    try {
        r = bs.dbService.executeStaticQuery(query.toString());
    } catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    
    if (r.esVacio()) {      
      String msg =  "CAR-0008: No se encuentra el intervalo del parámetro de nivel de riesgo para el valor de entrada "+ entrada + ":oidNivelRiesgo: " + parametro;
      UtilidadesLog.error(msg);
      ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(
          ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0008 ));

      ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
      ex.addParameter(entrada.toString());
      throw ex;
    }
    UtilidadesLog.info("DAOCAR.evaluarParametroNR (Long , Double):Salida");
    return r;
  }

    /**
   * @Autor Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @return Long
   * @param BigDecimal valor
   */
  public Long obtenerNivelRiesgo (BigDecimal valor) throws MareException {
    UtilidadesLog.info("DAOCAR.obtenerNivelRiesgo (BigDecimal):Entrada");
    StringBuffer query = new StringBuffer();
    
    query.append(" SELECT niri_oid_nive_ries");
    query.append(" FROM car_param_nr");
    query.append(" WHERE ").append(valor).append(" BETWEEN val_mini AND NVL(val_maxi, ").append(ConstantesCAR.VAL_MAXI);
    query.append(" ) ");
    
    BelcorpService bs;
    RecordSet r = null;
    
    try{
       bs = BelcorpService.getInstance();
    } catch (MareMiiServiceNotFoundException ex) {
       throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    
    try {
        r = bs.dbService.executeStaticQuery(query.toString());
    } catch(Exception e) {
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
 
    Long l = null;
    if (!r.esVacio()) {
      l = new Long(((BigDecimal)r.getValueAt(0,0)).longValue());
      UtilidadesLog.debug("obtenerNivelRiesgo: " + l);
    } else {
      String msg =  " CAR-0009: No se encuentra nivel de riesgo para el valor " + valor;
      UtilidadesLog.error(msg);
      ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(
          ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0009 ));

      ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
      ex.addParameter(valor.toString());
      throw ex;
    }
    UtilidadesLog.info("DAOCAR.obtenerNivelRiesgo (BigDecimal):Salida");
    return l;
  }
  
   // vbongiov -- 23/09/2008
   // Se agrega este metodo por migracion para reemplazar a CAR_PED_TipoSolicitudLocalHome
    public void actualizarTiposSolicitud(DTOGrupoSolicitud dtoin) throws MareException {
        UtilidadesLog.info("DAOCAR.actualizarTiposSolicitud(DTOGrupoSolicitud dtoin):Entrada");
        
        StringBuffer query = new StringBuffer();
        StringBuffer query1 = new StringBuffer();
        String inOidTipoSolicitud = "";
        Vector tiposSol = dtoin.getTiposSolicitud();
        int cantTiposSol = tiposSol.size();
        BelcorpService bs;
        int i;
        
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e){
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" update PED_TIPO_SOLIC ");
        query.append(" set GRSO_OID_GRUP_SOLI = NULL ");
        query.append(" where GRSO_OID_GRUP_SOLI = " + dtoin.getOidGrupoSol());
        
                
        for (int j = 0; j < cantTiposSol; j++) {             
             inOidTipoSolicitud = inOidTipoSolicitud + ", " + (Long)tiposSol.get(j);                  
        }
        
        query1.append(" update PED_TIPO_SOLIC ");
        query1.append(" set GRSO_OID_GRUP_SOLI = " + dtoin.getOidGrupoSol());
        query1.append(" where OID_TIPO_SOLI IN (" + inOidTipoSolicitud.substring(1) + ") ");
        
        
        try {
            i = bs.dbService.executeUpdate(query.toString());
            i = bs.dbService.executeUpdate(query1.toString());
            
        } catch(Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCAR.actualizarTiposSolicitud(DTOGrupoSolicitud dtoin): Salida");
    }
    
    // vbongiov -- 23/09/2008
    // Se agrega este metodo por migracion para reemplazar a CAR_PED_TipoSolicitudLocalHome
    public Long obtenerOidGrupoSolicitud(Long oidTipoSoli) throws MareException {
          UtilidadesLog.info("DAOCAR.obtenerOidGrupoSolicitud(DTOOID dtoin): Entrada");
          
          RecordSet rs = new RecordSet();        
          BelcorpService bs;
          StringBuffer query = new StringBuffer();
          
          try {
              bs = BelcorpService.getInstance();
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
          }
         
          query.append(" select GRSO_OID_GRUP_SOLI ");
          query.append(" from PED_TIPO_SOLIC ");
          query.append(" where OID_TIPO_SOLI = " + oidTipoSoli);
               
          try {
              rs = bs.dbService.executeStaticQuery(query.toString());
              
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          
          UtilidadesLog.info("DAOCAR.obtenerOidGrupoSolicitud(DTOOID dtoin): Salida");
          
          if(!rs.esVacio()){
              return Long.valueOf(((BigDecimal)rs.getValueAt(0,"GRSO_OID_GRUP_SOLI")).toString());
          } else {
              return null;
          }
      }
      
    // vbongiov -- 23/09/2008
    // Se agrega este metodo por migracion para reemplazar a CAR_PED_TipoSolicitudLocalHome
    public Collection obtenerGrupoSolicitud(Long oidGrupoSolicitud) throws MareException {
          UtilidadesLog.info("DAOCAR.obtenerGrupoSolicitud(Long oidGrupoSolicitud): Entrada");
          
          RecordSet rs = new RecordSet();        
          BelcorpService bs;
          StringBuffer query = new StringBuffer();
          Collection solicitudes = new ArrayList();
          
          try {
              bs = BelcorpService.getInstance();
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
          }
         
          query.append(" select OID_TIPO_SOLI ");
          query.append(" from PED_TIPO_SOLIC ");
          query.append(" where GRSO_OID_GRUP_SOLI= " + oidGrupoSolicitud);
               
          try {
              rs = bs.dbService.executeStaticQuery(query.toString());
              
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          
          if(!rs.esVacio()) {
          
              int cant = rs.getRowCount();
              
              for(int i=0; i < cant; i++){                
                solicitudes.add(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_SOLI")).toString()));
              }
          }          
          
          UtilidadesLog.info("DAOCAR.obtenerGrupoSolicitud(Long oidGrupoSolicitud): Salida");
          return solicitudes;          
          
      }
      
    /**
     * Sistema:     Belcorp
     * Modulo:      CAR
     * Fecha:       02/06/2009
     * @version     1.0
     * @autor       Emilio Noziglia
     */
    public Boolean obtenerIndicadorGestionMonto(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOCAR.obtenerIndicadorGestionMonto(Long oidSolicitud): Entrada ");
        String codigoError;
        RecordSet respuesta;        
        BelcorpService bs;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }        
        
        StringBuffer buf = new StringBuffer();        

        try {            
            
            buf.append(" SELECT PIP.IND_GESTION_MONTO ");
            buf.append(" FROM SEG_PARAM_INTER_PAIS PIP, PED_SOLIC_CABEC PSC ");
            buf.append(" WHERE PSC.OID_SOLI_CABE = " + oidSolicitud +" ");
            buf.append(" AND PSC.PAIS_OID_PAIS = PIP.PAIS_OID_PAIS ");                      

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(respuesta.esVacio()) {
             codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
             throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOCAR.obtenerIndicadorGestionMonto(Long oidSolicitud): Salida ");
        return this.bigDecimalToBoolean(respuesta.getValueAt(0, "IND_GESTION_MONTO"));
    }
    
    private Boolean bigDecimalToBoolean(Object indicador) {    
        if (indicador != null) {
            if (((BigDecimal) indicador).intValue() == 1)  { 
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;           
            }           
        } else {
            return Boolean.FALSE;
        }
    }    
    
    private Integer bigDecimalToInteger(BigDecimal number) throws Exception{
        if (number==null)
            return null;
        return new Integer(number.intValue());
    }    

    private Long bigDecimalToLong(BigDecimal number) throws Exception{
        if (number==null)
            return null;
        return new Long(number.longValue());
    }  
    
    /**
    * Sistema:     Belcorp
    * Modulo:      CAR
    * Fecha:       03/06/2009
    * @version     1.0
    * @autor       Emilio Noziglia
    */
    public Boolean esSolicitudReclamo(Long oidSolicitud) throws MareException {
      UtilidadesLog.info("DAOCAR.esSolicitudReclamo(Long oidSolicitud): Entrada ");
      String codigoError;
      RecordSet respuesta;        
      BelcorpService bs;
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }        
      
      StringBuffer buf = new StringBuffer();        

      try {            
          
          buf.append(" SELECT PSC.MODU_OID_MODU ");
          buf.append(" FROM PED_SOLIC_CABEC PSC ");
          buf.append(" WHERE PSC.OID_SOLI_CABE = " + oidSolicitud +" ");                              

          respuesta = bs.dbService.executeStaticQuery(buf.toString());
          
      } catch(Exception e) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      if(respuesta.esVacio()) {
           codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
           throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
      }
      
      Integer modulo = null;
      
      try {
            modulo = bigDecimalToInteger((BigDecimal)respuesta.getValueAt(0, "MODU_OID_MODU"));
            
      } catch(Exception e) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      UtilidadesLog.info("DAOCAR.esSolicitudReclamo(Long oidSolicitud): Salida ");      
      if (modulo!=null&&modulo.intValue()==15){
          return Boolean.TRUE;
      } else {
          return Boolean.FALSE;
      }
    }
        
        
    /**
    * Sistema:     Belcorp
    * Modulo:      CAR
    * Fecha:       03/06/2009
    * @version     1.0
    * @autor       Emilio Noziglia
    */
    public BigDecimal calcularPrecioCatalogoExcluyente(Long oidSolicitud) throws MareException {
      UtilidadesLog.info("DAOCAR.calcularPrecioCatalogoExcluyente(Long oidSolicitud): Entrada ");
      String codigoError;
      RecordSet respuesta;        
      BelcorpService bs;
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }        
      
      StringBuffer buf = new StringBuffer();        

      try {            
          
          buf.append(" SELECT SUM(PSP.VAL_PREC_CATA_UNIT_LOCA * PSP.NUM_UNID_DEMA_REAL) RES ");
          buf.append(" FROM PED_SOLIC_POSIC PSP, PRE_OFERT_DETAL POD, PRE_OFERT PO ");
          buf.append(" WHERE PSP.SOCA_OID_SOLI_CABE = " + oidSolicitud +" ");
          buf.append(" AND PSP.ESPO_OID_ESTA_POSI <> 2 ");
          buf.append(" AND PSP.OFDE_OID_DETA_OFER = POD.OID_DETA_OFER ");
          buf.append(" AND POD.OFER_OID_OFER = PO.OID_OFER ");
          buf.append(" AND PO.COES_OID_ESTR IN (SELECT PEE.COES_OID_ESTR FROM PED_ESTRA_EXCLU PEE) ");
          
          respuesta = bs.dbService.executeStaticQuery(buf.toString());
          
      } catch(Exception e) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      if(respuesta.esVacio()) {
           codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
           throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
      }
      
      UtilidadesLog.info("DAOCAR.calcularPrecioCatalogoExcluyente(Long oidSolicitud): Salida ");      
      return (BigDecimal)respuesta.getValueAt(0, "RES");
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      CAR
    * Fecha:       03/06/2009
    * @version     1.0
    * @autor       Emilio Noziglia
    */
    public DTOOIDs obtenerEstrategiasExcluidas() throws MareException {
      UtilidadesLog.info("DAOCAR.obtenerEstrategiasExcluidas(Long oidSolicitud): Entrada ");
      String codigoError;
      RecordSet respuesta;        
      BelcorpService bs;
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }        
      
      StringBuffer buf = new StringBuffer();        

      try {            
          
          buf.append(" SELECT PEE.COES_OID_ESTR FROM PED_ESTRA_EXCLU PEE ");
          
          respuesta = bs.dbService.executeStaticQuery(buf.toString());
          
      } catch(Exception e) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      DTOOIDs estrategiasExcluidas = new DTOOIDs();

      if(!respuesta.esVacio()) {
          Long[] ee = new Long[respuesta.getRowCount()];
          
          for (int i=0; i<respuesta.getRowCount(); i++) {
                try {
                    ee[i] = bigDecimalToLong((BigDecimal)respuesta.getValueAt(i, "COES_OID_ESTR"));
                } catch (Exception e) {
                     codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                     throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                }
            }
            
          estrategiasExcluidas.setOids(ee);      
      }
      
      UtilidadesLog.info("DAOCAR.obtenerEstrategiasExcluidas(Long oidSolicitud): Salida ");      
      return estrategiasExcluidas;
    }      
      
    /**
    * Sistema:     Belcorp
    * Modulo:      CAR
    * Fecha:       04/06/2009
    * @version     1.0
    * @autor       Emilio Noziglia
    */
    public DTOSalida obtenerEstraTipoOfertPosic(String detallesOferta) throws MareException {
      UtilidadesLog.info("DAOCAR.obtenerEstraTipoOfertPosic(String detallesOferta): Entrada ");
      String codigoError;
      RecordSet respuesta;      
      BelcorpService bs;
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }        
      
      StringBuffer buf = new StringBuffer();        

      try {            
          
          buf.append(" SELECT POD.OID_DETA_OFER, POD.TOFE_OID_TIPO_OFER, PO.COES_OID_ESTR ");
          buf.append(" FROM PRE_OFERT_DETAL POD, PRE_OFERT PO ");
          buf.append(" WHERE  POD.OFER_OID_OFER = PO.OID_OFER ");
          buf.append(" AND POD.OID_DETA_OFER IN ("+detallesOferta+") ");
          
          respuesta = bs.dbService.executeStaticQuery(buf.toString());
          
      } catch(Exception e) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      if(respuesta.esVacio()) {
           codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
           throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
      }
      
      DTOSalida res = new DTOSalida();
      res.setResultado(respuesta);
      
      UtilidadesLog.info("DAOCAR.obtenerEstraTipoOfertPosic(String detallesOferta): Salida ");      
      return res;
    }      
    
    /**
    * Sistema:     Belcorp
    * Modulo:      CAR
    * Fecha:       05/06/2009
    * @version     1.0
    * @autor       Emilio Noziglia
    */
    public ArrayList obtenerTipoOfertaPrioridad() throws MareException {
      UtilidadesLog.info("DAOCAR.obtenerTipoOfertaPrioridad(): Entrada ");
      String codigoError;
      RecordSet respuesta;      
      BelcorpService bs;
      
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }        
      
      StringBuffer buf = new StringBuffer();        

      try {            
          
            buf.append(" SELECT OP.TOFE_OID_TIPO_OFER, OP.NUM_PRIO ");
            buf.append(" FROM PED_TIPO_OFERT_PRIO OP ");
            buf.append(" ORDER BY OP.NUM_PRIO ");
          
          respuesta = bs.dbService.executeStaticQuery(buf.toString());
          
      } catch(Exception e) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      /*if(respuesta.esVacio()) {
           codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
           throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
      }*/
      
      ArrayList res = new ArrayList();
      try {   
          for (int i=0; i<respuesta.getRowCount(); i++){
              DTOTipoOfertaPrioridad dtoTiOfPr = new DTOTipoOfertaPrioridad();
              dtoTiOfPr.setOidTipoOferta(bigDecimalToLong((BigDecimal)respuesta.getValueAt(i,"TOFE_OID_TIPO_OFER")));
              dtoTiOfPr.setPrioridad(bigDecimalToLong((BigDecimal)respuesta.getValueAt(i,"NUM_PRIO")));
              res.add(dtoTiOfPr);
          }        
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
      
      UtilidadesLog.info("DAOCAR.obtenerTipoOfertaPrioridad(): Salida ");      
      return res;
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      CAR
    * Fecha:       05/06/2009
    * @version     1.0
    * @autor       Emilio Noziglia
    */    
    public void actualizarPosicionesAnuladasMontoMaximo(String posiciones) throws MareException {
        UtilidadesLog.info("DAOCAR.actualizarPosicionesAnuladasMontoMaximo(String posiciones): Entrada");
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();        

        query.append(" UPDATE PED_SOLIC_POSIC ");
        query.append(" SET ");
        query.append(" ESPO_OID_ESTA_POSI = ? ");
        parametros.add(ConstantesPED.ESTADO_POSICION_ANULADO);
        query.append(" , STPO_OID_SUBT_POSI = ? ");
        parametros.add(ConstantesPED.ESTADO_ANULADO_POR_MONTO_MAXIMO);
        query.append(" ,NUM_UNID_POR_ATEN = 0 ");
        query.append(" ,NUM_UNID_DEMA_REAL = 0 ");
        query.append(" ,NUM_UNID_COMPR = 0 ");
        query.append(" ,VAL_IMPO_DESC_UNIT_LOCA = 0 ");
        query.append(" ,VAL_IMPO_DESC_UNIT_DOCU = 0 ");
        query.append(" ,VAL_PORC_DESC = 0 ");
        query.append(" WHERE OID_SOLI_POSI IN ("+ posiciones +")");

        try{
            BelcorpService.getInstance().dbService.executePreparedUpdate(query.toString(), parametros);
        }catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCAR.actualizarPosicionesAnuladasMontoMaximo(String posiciones): Salida");        
    }    
    
    /**
    * Sistema:     Belcorp
    * Modulo:      CAR
    * Fecha:       07/07/2009
    * @version     1.0
    * @autor       Emilio Noziglia
    * @webmethod
    */    
    public Long obtenerNivelRiesgo(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOCAR.obtenerNivelRiesgo(Long):Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try{
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT da.niri_oid_nive_ries ");
        query.append(" FROM mae_clien_datos_adici da ");
        query.append(" WHERE da.clie_oid_clie = " + oidCliente);         
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }               

        if(rs.esVacio()) {
            return null;
        }
       
        // Retorna el nivel de riesgo 
        UtilidadesLog.info("DAOCAR.obtenerNivelRiesgo(Long):Salida");
        return new Long(((BigDecimal)rs.getValueAt(0, "niri_oid_nive_ries")).longValue());
        
    }    
}