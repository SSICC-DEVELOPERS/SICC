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
           
import es.indra.sicc.util.DTOOIDs;
import java.util.Vector;

import es.indra.sicc.util.DTOSalida;                  
import es.indra.sicc.util.CodigosError;               
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesPaginacion; 
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService; 

import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.dtos.edu.DTOOIDCurso;

import es.indra.sicc.logicanegocio.edu.ConstantesEDU;

import es.indra.sicc.cmn.negocio.ConstantesCMN; 

import es.indra.mare.common.exception.MareException;  
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;        

public class DAOExtemporaneas  {

	private String usuario = null;
	public DAOExtemporaneas(String usuario) {
		this.usuario = usuario;
	}

	public  DTOSalida consultaCursos (DTOConsultaCurso dtoe) throws MareException {
		/* Obtiene los cursos que están en funcionamiento, 
		 * no tienen bloqueo de extemporáneas y cumplen los
		 * siguientes criterios: marca, canal, tipo de curso,
		 * código de curso y nombre de curso.
		 */
		 
		UtilidadesLog.info("Metodo DAOExtemporaneas.consultaCursos(DTOConsultaCurso) : Entrada");	

		Vector parametros = new Vector();
		// Se crea la consulta SQL                  
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT A.OID_CURS OID, ");

		// Subselect para obtener el nombre del curso
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.OID_CURS AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'EDU_MATRI_CURSO') AS NOMBRE, ");
		parametros.add(dtoe.getOidIdioma());

		consulta.append(" A.FEC_FIN_CURS FECHA, ");

		// Subselect para obtener la descripción de la subgerencia de ventas
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.ZSGV_OID_SUBG_VENT AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'ZON_SUB_GEREN_VENTA') AS SUBGERENCIA, ");
		parametros.add(dtoe.getOidIdioma());

		//Subselect para obtener la descripción de región 
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.ZORG_OID_REGI AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'ZON_REGIO') AS REGION, ");
		parametros.add(dtoe.getOidIdioma());

		//Subselect para obtener la descripción de zona
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.ZZON_OID_ZONA AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'ZON_ZONA') AS ZONA, ");
		parametros.add(dtoe.getOidIdioma());

		//Subselect para obtener la descripción de seccion 
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.ZSCC_OID_SECC AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'ZON_SECCI') AS SECCION, ");
		parametros.add(dtoe.getOidIdioma());

		//Subselect para obtener la descripción de territorio 
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.ZZON_OID_ZONA AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'ZON_TERRI') AS TERRITORIO, ");
		parametros.add(dtoe.getOidIdioma());
    
    consulta.append(" a.TICU_OID_TIPO_CURS ");
		
		consulta.append(" FROM EDU_MATRI_CURSO A, VCA_SEG_PAIS B, ");
		consulta.append(" VCA_SEG_MARCA C, VCA_SEG_CANAL D ");

		// datos del DTO
		Long pais = dtoe.getOidPais();
		Long marca = dtoe.getMarca();
		Long canal = dtoe.getCanal();
		Long tipoCurso = dtoe.getTipoCurso();
		Integer codigo = dtoe.getCodigo();
		String nombreCurso = dtoe.getNombre();

		consulta.append(" WHERE ");
		
		consulta.append(" A.PAIS_OID_PAIS = ? ");
		parametros.add(pais);
		if(marca != null){
			consulta.append(" AND A.MARC_OID_MARC = ? ");
			parametros.add(marca);
		}
		if(canal != null){
			consulta.append(" AND A.CANA_OID_CANA = ? ");
			parametros.add(canal);
		}
		if(tipoCurso != null){
			consulta.append(" AND A.TICU_OID_TIPO_CURS = ? ");
			parametros.add(tipoCurso);
		}
		if(codigo != null){
			consulta.append(" AND A.COD_CURS = ? ");
			parametros.add(codigo);
		}
		if(nombreCurso != null) {
			consulta.append(" AND ");
			consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
			consulta.append(" WHERE V.VAL_OID =  A.OID_CURS AND ");
			consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
			consulta.append(" V.ATTR_ENTI = 'EDU_MATRI_CURSO') ");
			consulta.append(" LIKE ? ");
			parametros.add(dtoe.getOidIdioma());
			parametros.add(nombreCurso);
		}
		consulta.append(" AND A.IND_CTRL_FUNC = ? ");
		parametros.add(ConstantesCMN.VAL_TRUE); // Integer = 1
		consulta.append(" AND A.IND_BLOQ_EXTE = ? ");
		parametros.add(ConstantesCMN.VAL_FALSE); //  Integer = 0
 		consulta.append(" AND B.OID_PAIS = A.PAIS_OID_PAIS ");
		consulta.append(" AND B.COD_USUA = ? ");
		parametros.add(this.usuario);
		consulta.append(" AND C.OID_MARC = A.MARC_OID_MARC ");
		consulta.append(" AND C.COD_USUA = ? ");
		parametros.add(this.usuario);
		consulta.append(" AND D.OID_CANA = A.CANA_OID_CANA");
		consulta.append(" AND D.COD_USUA = ? ");
		parametros.add(this.usuario);

		// La consulta debe ser paginada                                       
		String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dtoe);
                                                                               
		// Se ejecuta la consulta SQL                                          
		BelcorpService bs = UtilidadesEJB.getBelcorpService();                 
		RecordSet rs = null;                                                   
		String codigoError = null;                                             
		try {                                                                  
			rs = bs.dbService.executePreparedQuery(sql,parametros);        
		} catch (Exception e) {                                                
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                
			UtilidadesLog.error("consultaCursos: Exception",e);           
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
		}                                                                                   
		// Se crea un DTOSalida a partir del RecordSet                         
		DTOSalida dtoSalida = new DTOSalida(rs);                               
		                                                              
		UtilidadesLog.info("Metodo DAOExtemporaneas.consultaCursos(DTOConsultaCurso) : Salida");	 
		return dtoSalida;	                                               
	}//fin consultaCurso

  /**
   * @author: ssantana, 6/12/2005, SICC-GCC-EDU-009
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param DTOOIDCurso dtoe
   */
	public DTOSalida consultaExtemporaneas (DTOOIDCurso dtoe) 
                                                       throws MareException {
	/*Obtiene los participantes que no han asistido al curso,
	 * son aptos, son de segunda convocatoria y cumplen los
	 * siguientes criterios: oid del curso.
	 */
		UtilidadesLog.info("Metodo DAOExtemporaneas.consultaExtemporaneas " + 
                       "(DTOOIDCurso) : Entrada");	 

		Vector parametros = new Vector();
		StringBuffer consulta = new StringBuffer();
    // Modificado por ssantana, 6/12/2005, inc. 22085
		consulta.append(" SELECT A.OID_APTA OID, ");
		consulta.append(" C.COD_CLIE CODIGOCLIENTE, A.FEC_ASIS FECHA, ");
		consulta.append(" C.VAL_APE1 APELLIDO1, C.VAL_APE2 APELLIDO2, ");
		consulta.append(" C.VAL_NOM1 NOMBRE1, ");
		consulta.append(" C.VAL_NOM2 NOMBRE2, ");
    consulta.append(" C.OID_CLIE OIDCLIENTE, ");
    consulta.append(" ROWNUM ");

		consulta.append(" FROM EDU_APTAS_CURSO A, MAE_SUBTI_CLIEN B, MAE_CLIEN C, ");
		consulta.append(" MAE_CLIEN_DATOS_ADICI D, EDU_MATRI_CURSO E, VCA_SEG_PAIS F, ");
		consulta.append(" VCA_SEG_MARCA G, VCA_SEG_CANAL H, MAE_CLIEN_TIPO_SUBTI I, "); 
    consulta.append(" MAE_TIPO_CLIEN J ");
		
		// datos del DTO 
		Long oid = dtoe.getOid();

		consulta.append(" WHERE ");
		consulta.append(" A.MCUR_OID_CURS = ? ");
		parametros.add(oid);
		consulta.append(" AND A.IND_ASIS = ? ");
		parametros.add(ConstantesEDU.NO_ASIS);
		consulta.append(" AND A.IND_APTA_CURS = ? ");
		parametros.add(ConstantesCMN.VAL_TRUE);   
		consulta.append(" AND A.NUM_CONV = ? ");
		parametros.add(ConstantesEDU.SEG_CONV);
		consulta.append(" AND B.OID_SUBT_CLIE = A.SBTI_OID_SUBT_CLIE ");
		consulta.append(" AND C.OID_CLIE = A.CLIE_OID_CLIE ");
		consulta.append(" AND D.CLIE_OID_CLIE = C.OID_CLIE ");
		consulta.append(" AND I.CLIE_OID_CLIE=C.OID_CLIE ");
    consulta.append(" AND B.TICL_OID_TIPO_CLIE = J.OID_TIPO_CLIE ");
		consulta.append(" AND E.OID_CURS = A.MCUR_OID_CURS ");
		consulta.append(" AND F.OID_PAIS = E.PAIS_OID_PAIS ");
		consulta.append(" AND F.COD_USUA = ? ");
		parametros.add(this.usuario);
		consulta.append(" AND G.OID_MARC = E.MARC_OID_MARC ");
		consulta.append(" AND G.COD_USUA = ? ");
		parametros.add(this.usuario);
		consulta.append(" AND H.OID_CANA = E.CANA_OID_CANA ");
		consulta.append(" AND H.COD_USUA = ? ");
		parametros.add(this.usuario);
		                                                                           
		// Se ejecuta la consulta SQL                                          
		BelcorpService bs = UtilidadesEJB.getBelcorpService();                 
		RecordSet rs = null;                                                   
		String codigoError = null;                                             
		try {                                                                  
			rs = bs.dbService.executePreparedQuery(consulta.toString(),
                                             parametros);        
		} catch (Exception e) {                                                
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                
			UtilidadesLog.error("consultaExtemporaneas: Exception",e);           
			throw new MareException(e, 
                              UtilidadesError.armarCodigoError(codigoError)); 
		}                                                                      
		if (rs.esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.error("****consultaExtemporaneas: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
                                                                       
		// Se crea un DTOSalida a partir del RecordSet                         
		DTOSalida dtoSalida = new DTOSalida(rs);                               
	                                                                       
		UtilidadesLog.info("Metodo DAOExtemporaneas.consultaExtemporaneas " + 
                       " (DTOOIDCurso) : Salida");	 
		return dtoSalida;	                                               
		
	}// fin consultaExtemporaneas
  
  /**
   * 
   * @author: wancho, 7/12/2005, SICC-GCC-EDU-009
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet
   * @param DTOOIDs dtoe
   */
  public RecordSet obtenerParticipantesValidos(DTOOIDs dtoe) 
      throws MareException {
   /*
    * Se recuperan los clientes de la tabla AptasCurso 
    * que cumplen con ciertas validaciones 
    */
    
    UtilidadesLog.info( "Metodo DAOExtemporaneas.obtenerParticipantesValidos" +
                        "(DTOOIDs dtoe) : Entrada");	 
    Vector parametros = new Vector();
    StringBuffer consulta = new StringBuffer();
    
    consulta.append("SELECT apta.oid_apta oidapta, ");
    consulta.append("apta.clie_oid_clie oidcliente ");
    consulta.append("FROM edu_aptas_curso apta, ");
    consulta.append("edu_matri_curso matriz, ");
    consulta.append("vca_seg_pais f, ");
    consulta.append("vca_seg_marca g, ");
    consulta.append("vca_seg_canal h ");

    //jrivas EDU-09 9/3/2006
    /*consulta.append("WHERE apta.mcur_oid_curs = ? ");
    parametros.add(dtoe.getOids()[0]);
    consulta.append("AND APTA.ind_asis = ? ");*/
    consulta.append("WHERE APTA.ind_asis = ? ");
    parametros.add(ConstantesEDU.NO_ASIS);

    consulta.append("AND APTA.num_conv = ? ");
    parametros.add(ConstantesEDU.SEG_CONV);
    consulta.append("AND APTA.ind_prue = ? ");
    parametros.add(ConstantesCMN.VAL_FALSE);
    consulta.append("AND matriz.pais_oid_pais = ? ");
    parametros.add(dtoe.getOids()[1]);
    consulta.append(" AND matriz.TICU_OID_TIPO_CURS = ? ");
    parametros.add(dtoe.getOids()[2]);
    consulta.append("AND matriz.oid_curs = apta.mcur_oid_curs ");
    consulta.append("AND matriz.marc_oid_marc = g.oid_marc ");
    consulta.append("AND f.oid_pais = matriz.pais_oid_pais ");
    consulta.append("AND g.cod_usua = ? ");
    parametros.add(usuario);
    consulta.append("AND f.cod_usua = ? ");
    parametros.add(usuario);
    consulta.append("AND h.oid_cana = matriz.cana_oid_cana ");
    consulta.append("AND h.cod_usua = ? ");
    parametros.add(usuario);
    consulta.append(" and apta.clie_oid_clie not in( ");
    /*mdolce 26/01/2007 */
    /*Segun requerimiento del cliente, se debe traer los que no estuvieron en el curso que se esta tratando*/
    consulta.append(" select apta2.clie_oid_clie from edu_aptas_curso apta2 where apta2.MCUR_OID_CURS =  "+ dtoe.getOids()[0]+")");
    
    BelcorpService bs = BelcorpService.getInstance();
    RecordSet rs=null;
    try {                                                                  
			rs = bs.dbService.executePreparedQuery(consulta.toString(),
                                                       parametros);
		} catch (Exception e) {                                                
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                
			UtilidadesLog.error("consultaExtemporaneas: Exception",e);           
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
		}  
    
    UtilidadesLog.info("Metodo DAOExtemporaneas.obtenerParticipantesValidos" + 
                       "(DTOOIDs dtoe) : Salida");	 
    return rs;
  }
  

	                                                               

}// fin DAOExtemporaneas