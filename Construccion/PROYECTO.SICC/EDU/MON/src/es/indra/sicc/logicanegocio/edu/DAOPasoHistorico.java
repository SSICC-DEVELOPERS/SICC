/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.edu;

import java.text.SimpleDateFormat;
import java.util.Vector;
import java.sql.Date;

import es.indra.sicc.dtos.edu.DTOConsultaPasoHistorico;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.util.BelcorpService;

import es.indra.sicc.logicanegocio.edu.ConstantesEDU;

import es.indra.sicc.cmn.negocio.ConstantesCMN; 

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


public class DAOPasoHistorico  {
	private String usuario;

	public DAOPasoHistorico(String usuario) {
		this.usuario = usuario;
	}

	public DTOSalida consultaCursos (DTOConsultaPasoHistorico dtoe) throws MareException {
	/*Obtiene los cursos que están en funcionamiento 
	 * y cumplen los siguientes criterios: 
	 * marca, canal, tipo de curso, código de curso, nombre de curso y fecha del curso. 
	*/
		UtilidadesLog.info(" DAOPasohistorico.consultaCursos(DTOConsultaPasoHistorico) : Entrada");	 
		Vector parametros = new Vector();
		
		StringBuffer sql=new StringBuffer();
								//ALIAS importante para armarQuery
		sql.append("SELECT A.OID_CURS OID, A.COD_CURS CODIGO,");         
				 //subselect de descripcion nombre                                                    
		sql.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");        
		sql.append("WHERE v.VAL_OID =  A.OID_CURS AND ");                
		sql.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");  
		sql.append("v.ATTR_ENTI = 'EDU_MATRI_CURSO' ) AS NOMBRE,  ");     

        parametros.add(dtoe.getOidIdioma());
                                    
		sql.append("E.COD_TIPO_CURS TIPOCURSO,  ");                      
         //subselect de descripcion curso                                                        
		sql.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v  ");       
		sql.append("WHERE v.VAL_OID = E.OID_TIPO_CURS AND  ");           
		sql.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND  ");  
		sql.append("v.ATTR_ENTI = 'EDU_TIPO_CURSO' ) AS DESCTIPOCURSO, ");
        parametros.add(dtoe.getOidIdioma());                                                   

		sql.append(" C.DES_MARC AS MARCA, ");        

        //subselect de descripcion canal                                       
		sql.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");        
		sql.append("WHERE v.VAL_OID = D.OID_CANA AND ");                 
		sql.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND  "); 
		sql.append("v.ATTR_ENTI = 'SEG_CANAL' ) AS CANAL, ");

		parametros.add(dtoe.getOidIdioma());
                                                                 
		sql.append("A.FEC_LANZ FECHA  ");                                
                                                                 
		sql.append("FROM EDU_MATRI_CURSO A, EDU_TIPO_CURSO E, ");        
		sql.append("VCA_SEG_MARCA C,  VCA_SEG_CANAL D, VCA_SEG_PAIS B ");                
                                                                 
		sql.append("WHERE "); 
		

		sql.append(" A.PAIS_OID_PAIS = ?  ");
		parametros.add(dtoe.getOidPais());

		Long canal = dtoe.getCanal();
		Long marca = dtoe.getMarca();
		Long tipCurso = dtoe.getTipoCurso();
		Integer codigo = dtoe.getCodigo();
		String nombre = dtoe.getNombre();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fechaSql= null;
		if (dtoe.getFecCurso()!= null) {
			fechaSql = new Date(dtoe.getFecCurso().getTime());
		}
		
		if (canal != null) {
			sql.append("AND A.CANA_OID_CANA = ? ");
			parametros.add(canal);
		}
		if (marca != null) {
			sql.append("AND A.MARC_OID_MARC = ? ");
			parametros.add(marca);
		}
		if(tipCurso != null){
			sql.append("AND A.TICU_OID_TIPO_CURS = ? ");
			parametros.add(tipCurso);
		}
		if(codigo != null){
			sql.append("AND A.COD_CURS = ? ");
			parametros.add(codigo);
		}
		if(nombre != null){	
			sql.append("AND (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v "); 
			sql.append("WHERE v.VAL_OID =  A.OID_CURS AND ");  
			sql.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND "); 
			sql.append("v.ATTR_ENTI = 'EDU_MATRI_CURSO' ) LIKE  ? ");
			parametros.add(dtoe.getOidIdioma());
			parametros.add(nombre);
		}
		if(fechaSql!=null){
			sql.append("AND A.FEC_LANZ = TO_DATE( ? ,'YYYY-MM-DD') ");
            String fechalanz = sdf.format(fechaSql);                                               
            parametros.add(fechalanz);
		}
		
		sql.append("AND A.IND_CTRL_FUNC = ?  "); 
		parametros.add(obtineBoolean(ConstantesCMN.VAL_TRUE));
		sql.append("AND E.OID_TIPO_CURS = A.TICU_OID_TIPO_CURS  ");               
		sql.append("AND B.OID_PAIS = A.PAIS_OID_PAIS  ");                        
		sql.append("AND B.COD_USUA = ?   ");                                
		parametros.add(this.usuario);
		sql.append("AND C.OID_MARC = A.MARC_OID_MARC   "); 
		
		sql.append("AND C.COD_USUA = ?  ");
		parametros.add(this.usuario);
		sql.append("AND D.OID_CANA = A.CANA_OID_CANA  ");                         
		sql.append("AND D.COD_USUA = ? ");
		parametros.add(this.usuario);    

		String sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(),dtoe);

		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(sqlPaginacion,parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("consultaCursos: Exception",e);
			      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		// Se crea un DTOSalida a partir del RecordSet
		DTOSalida dtoSalida = new DTOSalida(rs);
		
		UtilidadesLog.info(" DAOPasohistorico.consultaCursos(DTOConsultaPasoHistorico) : Salida");	 
		return dtoSalida;	
	}// consultaCursos


	public RecordSet consultaAptasCursoRealizado (Long oid)throws MareException {
	//Obtiene los clientes que han asistido al curso especificado en el parámetro de entrada. 
		UtilidadesLog.info(" DAOPasohistorico.consultaAptasCursoRealizado(oid) : Entrada");	 

		Vector parametros = new Vector();
		StringBuffer consulta=new StringBuffer();
								//ALIAS importante para armarQuery
		consulta.append("SELECT ");                                       
		consulta.append("A.OID_APTA OID, ");                             
		consulta.append("A.CLIE_OID_CLIE CLIENTE, ");                     
		consulta.append("A.SBTI_OID_SUBT_CLIE SUBTIPO, ");               
		consulta.append("A.IND_APTA_CURS APTA, ");                         
		consulta.append("A.IND_INVI INVITADA, ");                         
		consulta.append("A.FEC_ASIS FECHAASISTENCIA, ");                   
		consulta.append("A.NUM_CONV NUMCONVOCATORIA, ");                  
		consulta.append("A.IND_ASIS ASISTENCIA ");                         
	                                         
		consulta.append("FROM ");                                        
		consulta.append("EDU_APTAS_CURSO A, ");                            
		consulta.append("EDU_MATRI_CURSO B, ");                            
		consulta.append("VCA_SEG_PAIS C, ");                               
		consulta.append("VCA_SEG_MARCA D, ");                              
		consulta.append("VCA_SEG_CANAL E  ");                              
		                                         
		consulta.append("WHERE ");                                        
		consulta.append("A.MCUR_OID_CURS = ? ");
		parametros.add(oid);
		consulta.append("AND A.IND_ASIS <> ? ");
		//parametros.add(new Long(1)); 
		parametros.add(ConstantesEDU.NO_ASIS);      

		consulta.append("AND B.OID_CURS = ? ");
		parametros.add(oid);
		
		consulta.append("AND C.OID_PAIS = B.PAIS_OID_PAIS ");            
		consulta.append("AND C.COD_USUA = ?  ");
		parametros.add(this.usuario);
		
		consulta.append("AND D.OID_MARC = B.MARC_OID_MARC ");             
		consulta.append("AND D.COD_USUA = ? "); 
		parametros.add(this.usuario);
		consulta.append("AND E.OID_CANA = B.CANA_OID_CANA ");              
		consulta.append("AND E.COD_USUA = ? "); 
		parametros.add(this.usuario);

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			      UtilidadesLog.error("consultaAptasCursoRealizado: Exception",e);
			      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

    UtilidadesLog.info(" DAOPasohistorico.consultaAptasCursoRealizado(oid) : Salida");	 

        return rs;                                                       
   		
 }//
	

	private Boolean obtineBoolean(Integer constantes){
 
		if(constantes.equals(new Integer("0"))){
			return Boolean.FALSE;
		}else{
			if(constantes.equals(new Integer("1"))){
				return Boolean.TRUE;
			}
		}//si no es cero que devuelva true
		return Boolean.TRUE;
		
	}//
  
  
  /**
   * @author: ssantana, 9/12/2005, SICC-GCC-EDU-009
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet
   * @param Long oid
   */
  public RecordSet consultarAptasExtemporaneas(Long oidTipoCurso, String clientes) throws MareException {
     UtilidadesLog.info("DAOPasoHistorico.consultarAptasExtemporaneas" + 
                        "(Long oid):Entrada");
     /*mdolce 25/01/2006 se modifico para que encuentre solo los clientes enviados por pantalla*/                   
     RecordSet rRetorno = null;
     StringBuffer sqlQuery = new StringBuffer("");
     sqlQuery.append(" SELECT edu_aptas_curso.oid_apta OID, ");
     sqlQuery.append(" edu_aptas_curso.clie_oid_clie cliente, ");
     sqlQuery.append(" edu_aptas_curso.sbti_oid_subt_clie subtipo, ");
     sqlQuery.append(" edu_aptas_curso.ind_apta_curs apta, ");
     sqlQuery.append(" edu_aptas_curso.ind_invi invitada, ");
     sqlQuery.append(" edu_aptas_curso.num_conv numconvocatoria, ");
     sqlQuery.append(" edu_aptas_curso.ind_asis asistencia, ");
     sqlQuery.append(" edu_aptas_curso.MCUR_OID_CURS ");
     sqlQuery.append(" FROM edu_aptas_curso, ");
     sqlQuery.append(" edu_matri_curso, ");
     sqlQuery.append(" vca_seg_pais, ");
     sqlQuery.append(" vca_seg_marca, ");
     sqlQuery.append(" vca_seg_canal ");
     sqlQuery.append(" WHERE edu_matri_curso.oid_curs = edu_aptas_curso.mcur_oid_curs ");
     sqlQuery.append( " and edu_matri_curso.TICU_OID_TIPO_CURS = " + oidTipoCurso);
     sqlQuery.append(" AND edu_aptas_curso.ind_asis = " + ConstantesEDU.NO_ASIS);
     sqlQuery.append(" AND edu_aptas_curso.fec_asis IS NULL ");
     sqlQuery.append(" AND (edu_aptas_curso.num_conv = 1 OR "); 
     sqlQuery.append("                          edu_aptas_curso.num_conv = 2) ");
     sqlQuery.append("  and edu_aptas_curso.clie_oid_clie in("+ clientes + ")");
     sqlQuery.append(" AND vca_seg_pais.oid_pais = edu_matri_curso.pais_oid_pais ");
     sqlQuery.append(" AND vca_seg_pais.cod_usua = '" + this.usuario + "' ");
     sqlQuery.append(" AND vca_seg_marca.oid_marc = edu_matri_curso.marc_oid_marc ");
     sqlQuery.append(" AND vca_seg_marca.cod_usua = '" + this.usuario + "' ");
     sqlQuery.append(" AND vca_seg_canal.oid_cana = edu_matri_curso.cana_oid_cana ");
     sqlQuery.append(" AND vca_seg_canal.cod_usua = '" + this.usuario + "' ");
    
     UtilidadesLog.info("DAOPasoHistorico.consultarAptasExtemporaneas" + 
                        "(Long oid):Salida");
                        
                        
     try {
       BelcorpService bs = BelcorpService.getInstance();
       rRetorno = bs.dbService.executeStaticQuery(sqlQuery.toString());
     } catch (Exception ex) {
       String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
       UtilidadesLog.error("consultarAptasExtemporaneas: Exception",ex);
       throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
		}
    
    UtilidadesLog.debug("rRetorno: " + rRetorno);
    
    UtilidadesLog.info("DAOPasoHistorico.consultarAptasExtemporaneas" + 
                       "(Long oid):Salida");
    return rRetorno;
  }

    /**
     * @autor Rafael Romero
     * @date 17/04/2007
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param clientes OIDs de clientes separados por coma
     * @param oidTipoCurso
     */
    public RecordSet consultarClientes(Long oidTipoCurso, String clientes) throws MareException {
        /*
         * Este metodo se basa en public RecordSet consultarAptasExtemporaneas(Long oidTipoCurso, String clientes) throws MareException
         */
        UtilidadesLog.debug("DAOPasoHistorico.consultarClientes(Long, String): Entrada");
        RecordSet rRetorno = null;
        StringBuffer sqlQuery = new StringBuffer();

        sqlQuery.append("SELECT edu_aptas_curso.oid_apta OID, edu_aptas_curso.clie_oid_clie cliente, ");
        sqlQuery.append("       edu_aptas_curso.sbti_oid_subt_clie subtipo, ");
        sqlQuery.append("       edu_aptas_curso.ind_apta_curs apta, edu_aptas_curso.ind_invi invitada, ");
        sqlQuery.append("       edu_aptas_curso.num_conv numconvocatoria, ");
        sqlQuery.append("       edu_aptas_curso.ind_asis asistencia, edu_aptas_curso.mcur_oid_curs ");
        sqlQuery.append("  FROM edu_aptas_curso, ");
        sqlQuery.append("       edu_matri_curso, ");
        sqlQuery.append("       vca_seg_pais, ");
        sqlQuery.append("       vca_seg_marca, ");
        sqlQuery.append("       vca_seg_canal ");
        sqlQuery.append(" WHERE edu_matri_curso.oid_curs = edu_aptas_curso.mcur_oid_curs ");
        sqlQuery.append("   AND edu_matri_curso.ticu_oid_tipo_curs = "+oidTipoCurso+" ");
        sqlQuery.append("   AND edu_aptas_curso.ind_asis = " + ConstantesEDU.NO_ASIS + " ");
        sqlQuery.append("   AND edu_aptas_curso.fec_asis IS NULL ");
        sqlQuery.append("   AND (edu_aptas_curso.num_conv = "+ConstantesEDU.PRIM_CONV+" OR edu_aptas_curso.num_conv = "+ConstantesEDU.SEG_CONV+") ");
        sqlQuery.append("   AND edu_aptas_curso.clie_oid_clie IN ("+clientes+") ");
        sqlQuery.append("   AND vca_seg_pais.oid_pais = edu_matri_curso.pais_oid_pais ");
        sqlQuery.append("   AND vca_seg_pais.cod_usua = '" + this.usuario + "' ");
        sqlQuery.append("   AND vca_seg_marca.oid_marc = edu_matri_curso.marc_oid_marc ");
        sqlQuery.append("   AND vca_seg_marca.cod_usua = '" + this.usuario + "' ");
        sqlQuery.append("   AND vca_seg_canal.oid_cana = edu_matri_curso.cana_oid_cana ");
        sqlQuery.append("   AND vca_seg_canal.cod_usua = '" + this.usuario + "' ");

        BelcorpService bs = BelcorpService.getInstance();                 
        try {
            rRetorno = bs.dbService.executeStaticQuery(sqlQuery.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("consultarAptasExtemporaneas: Exception",ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
    
        UtilidadesLog.debug("DAOPasoHistorico.consultarClientes(Long, String): Se han obtenido [" + rRetorno.getRowCount() + "] registros");
        UtilidadesLog.debug("DAOPasoHistorico.consultarClientes(Long, String): Salida");
        return rRetorno;
    }

}//clase