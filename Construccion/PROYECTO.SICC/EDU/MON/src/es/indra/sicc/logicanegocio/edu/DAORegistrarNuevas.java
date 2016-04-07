package es.indra.sicc.logicanegocio.edu;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.dtos.edu.DTOParticipante;
import es.indra.sicc.dtos.edu.DTOValidarParticipantes;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.util.Iterator;

/**
 * @author Rafael Romero
 * @date 13/04/2007
 */
public class DAORegistrarNuevas  {

    private static final int OID_PLANTILLA_NUEVAS = 1;
    
	private String usuario = null;
	public DAORegistrarNuevas(String usuario) {
		this.usuario = usuario;
	}

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida, con RecordSet para paginado
     * @param dtoe DTO con filtros de concursos a mostrar
     */
	public DTOSalida consultaCursos(DTOConsultaCurso dtoe) throws MareException {
        DTOSalida retorno = null;
        try{
            UtilidadesLog.info("DAORegistrarNuevas.consultaCursos(DTOConsultaCurso): Entrada");
            //Vector parametros = new Vector();
    
            StringBuffer consulta = new StringBuffer();
            consulta.append("SELECT a.oid_curs OID, ");
            consulta.append("       (SELECT v.val_i18n ");
            consulta.append("          FROM v_gen_i18n_sicc v ");
            consulta.append("         WHERE v.val_oid = a.oid_curs ");
            consulta.append("           AND v.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
            consulta.append("           AND v.attr_num_atri = 1 ");
            consulta.append("           AND v.attr_enti = 'EDU_MATRI_CURSO') AS nombre, ");
            //consulta.append("       a.fec_fin_curs fecha, ");
            consulta.append("       (SELECT perio.VAL_NOMB_PERI FROM CRA_PERIO perio WHERE OID_PERI = a.PERD_OID_PERI_INGR) PERINGEXI, ");
            consulta.append("       (SELECT des_subg_vent ");
            consulta.append("          FROM zon_sub_geren_venta ");
            consulta.append("         WHERE oid_subg_vent = a.zsgv_oid_subg_vent) AS subgerencia, ");
            consulta.append("       (SELECT des_regi ");
            consulta.append("          FROM zon_regio ");
            consulta.append("         WHERE oid_regi = a.zorg_oid_regi) AS region, ");
            consulta.append("       (SELECT des_zona ");
            consulta.append("          FROM zon_zona ");
            consulta.append("         WHERE oid_zona = a.zzon_oid_zona) AS zona, ");
            consulta.append("       (SELECT des_secci ");
            consulta.append("          FROM zon_secci ");
            consulta.append("         WHERE oid_secc = a.zscc_oid_secc) AS seccion, ");
            consulta.append("       (SELECT cod_terr ");
            consulta.append("          FROM zon_terri ");
            consulta.append("         WHERE oid_terr = a.terr_oid_terr) AS territorio, ");
            consulta.append("       a.ticu_oid_tipo_curs ");
            consulta.append("  FROM edu_matri_curso a, vca_seg_pais b, vca_seg_marca c, vca_seg_canal d ");
            consulta.append(" WHERE b.oid_pais = a.pais_oid_pais ");
            consulta.append("   AND b.cod_usua = '"+this.usuario+"' ");
            consulta.append("   AND c.oid_marc = a.marc_oid_marc ");
            consulta.append("   AND c.cod_usua = '"+this.usuario+"' ");
            consulta.append("   AND d.oid_cana = a.cana_oid_cana ");
            consulta.append("   AND d.cod_usua = '"+this.usuario+"' ");
            consulta.append("   AND a.cplc_oid_cabe_plan_curs = "+OID_PLANTILLA_NUEVAS+" ");
            //consulta.append("   AND a.ind_ctrl_func = "+ConstantesCMN.VAL_TRUE+" ");
            //consulta.append("   AND a.ind_bloq_exte = "+ConstantesCMN.VAL_FALSE+" ");
            consulta.append("   AND a.pais_oid_pais = "+dtoe.getOidPais()+" ");
            if(dtoe.getMarca() != null) consulta.append("   AND a.marc_oid_marc = "+dtoe.getMarca()+" ");
            if(dtoe.getCanal() != null) consulta.append("   AND a.cana_oid_cana = "+dtoe.getCanal()+" ");
            if(dtoe.getTipoCurso() != null) consulta.append("   AND a.ticu_oid_tipo_curs = "+dtoe.getTipoCurso()+" ");
            if(dtoe.getCodigo() != null)  consulta.append("   AND a.cod_curs = "+dtoe.getCodigo()+" ");
            if(dtoe.getNombre() != null) {
                consulta.append("   AND (SELECT v.val_i18n ");
                consulta.append("          FROM v_gen_i18n_sicc v ");
                consulta.append("         WHERE v.val_oid = a.oid_curs ");
                consulta.append("           AND v.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
                consulta.append("           AND v.attr_num_atri = 1 ");
                consulta.append("           AND v.attr_enti = 'EDU_MATRI_CURSO') LIKE '"+dtoe.getNombre()+"' ");
            }
    
            String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dtoe);
                                                                                   
            BelcorpService bs = UtilidadesEJB.getBelcorpService();                 
            RecordSet rs = null;                                                   
            try {                                                                  
                rs = bs.dbService.executeStaticQuery(sql);
            } catch (Exception e) {                                                
                UtilidadesLog.error("DAORegistrarNuevas.consultaCursos(DTOConsultaCurso): Exception",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            if (rs.esVacio()) {
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            
            retorno = new DTOSalida(rs);
            
        //}catch(Exception e){
        //    throw e;
        }finally{
            UtilidadesLog.info("DAORegistrarNuevas.consultaCursos(DTOConsultaCurso) : Salida");
        }
		return retorno;
	}
    
    public RecordSet obtenerNoValidos(DTOValidarParticipantes dtoe) throws MareException{
        RecordSet salida = null;
        try{
            UtilidadesLog.info("DAORegistrarNuevas.obtenerNoValidos(DTOValidarParticipantes) : Entrada");
            
            if(dtoe.getValidar().size()>0){

                Iterator ite = dtoe.getValidar().iterator();
                String oids = "";
                
                while(ite.hasNext()){
                    DTOParticipante participante = (DTOParticipante)ite.next();
                    oids += (participante.getOidCliente() + ",");
                }
                oids = oids.substring(0,oids.length()-1);
                
                StringBuffer consulta = new StringBuffer();

                consulta.append("SELECT DISTINCT oidcliente ");
                consulta.append("           FROM ((SELECT   apcu.clie_oid_clie oidcliente ");
                consulta.append("                      FROM edu_aptas_curso apcu, edu_matri_curso mcur ");
                consulta.append("                     WHERE apcu.mcur_oid_curs = mcur.oid_curs ");
                consulta.append("                       AND apcu.ind_prue = 0 ");
                consulta.append("                       AND apcu.ind_asis IN ("+ConstantesEDU.ASIS_APTA+", "+ConstantesEDU.ASIS_OTRO+") ");
                consulta.append("                       AND apcu.fec_asis IS NOT NULL ");
                consulta.append("                       AND apcu.clie_oid_clie IN ("+oids+") ");
                consulta.append("                       AND mcur.pais_oid_pais = "+dtoe.getOidPais()+" ");
                consulta.append("                       AND mcur.cplc_oid_cabe_plan_curs = "+OID_PLANTILLA_NUEVAS+" ");
                consulta.append("                  GROUP BY apcu.clie_oid_clie) ");
                consulta.append("                 UNION ALL ");
                consulta.append("                 (SELECT clie.oid_clie ");
                consulta.append("                    FROM mae_clien clie ");
                consulta.append("                   WHERE clie.oid_clie IN ("+oids+") ");
                consulta.append("                     AND NOT EXISTS ( ");
                consulta.append("                            SELECT sbti.clie_oid_clie oidcliente ");
                consulta.append("                              FROM mae_clien_tipo_subti sbti, ");
                consulta.append("                                   edu_matri_curso mcur ");
                consulta.append("                             WHERE sbti.clie_oid_clie = clie.oid_clie ");
                consulta.append("                               AND mcur.oid_curs = "+dtoe.getCurso()+" ");
                consulta.append("                               AND sbti.ticl_oid_tipo_clie = ");
                consulta.append("                                      NVL (mcur.ticl_oid_tipo_clie, ");
                consulta.append("                                           sbti.ticl_oid_tipo_clie ");
                consulta.append("                                          ) ");
                consulta.append("                               AND sbti.sbti_oid_subt_clie = ");
                consulta.append("                                      NVL (mcur.sbti_oid_subt_clie, ");
                consulta.append("                                           sbti.sbti_oid_subt_clie ");
                consulta.append("                                          )))) ");
                
                BelcorpService bs = UtilidadesEJB.getBelcorpService();                 
                try {                                                                  
                    salida = bs.dbService.executeStaticQuery(consulta.toString());
                    if(salida!=null){
                        UtilidadesLog.debug("Registros obtenidos ["+salida.getRowCount()+"]");
                    }
                } catch (Exception e) {                                                
                    UtilidadesLog.error("DAORegistrarNuevas.obtenerNoValidos(DTOValidarParticipantes): Exception",e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            
            }else{
                UtilidadesLog.debug("DAORegistrarNuevas.obtenerNoValidos(DTOValidarParticipantes): No hay elementos a validar");
            }
            
        }
        finally{
            UtilidadesLog.info("DAORegistrarNuevas.obtenerNoValidos(DTOValidarParticipantes) : Salida");
        }
        return salida;
    }
    public Long obtenerTipoSubtipoPpalPorCliente(Long oidCliente) throws MareException{
        Long salida = null;
        try{
            UtilidadesLog.info("DAORegistrarNuevas.obtenerTipoSubtipoPpalPorCliente(Long) : Entrada");
            UtilidadesLog.info("oidCliente["+oidCliente+"]");
            StringBuffer consulta = new StringBuffer();

            consulta.append("SELECT sbti_oid_subt_clie ");
            consulta.append("  FROM mae_clien_tipo_subti ");
            consulta.append(" WHERE clie_oid_clie = "+oidCliente+" ");
            consulta.append("       AND ind_ppal = 1 ");

            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            try {                                                                  
                RecordSet rs = bs.dbService.executeStaticQuery(consulta.toString());
                salida = new Long(((BigDecimal)rs.getValueAt(0,"SBTI_OID_SUBT_CLIE")).toString());
            } catch (Exception e) {                                                
                UtilidadesLog.error("DAORegistrarNuevas.obtenerTipoSubtipoPpalPorCliente(Long): Exception",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        finally{
            UtilidadesLog.info("DAORegistrarNuevas.obtenerTipoSubtipoPpalPorCliente(Long) : Salida");
        }
        return salida;
    }
}