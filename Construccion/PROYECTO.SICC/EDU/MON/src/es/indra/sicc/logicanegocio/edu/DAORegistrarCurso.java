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

public class DAORegistrarCurso  {

	private String usuario = null; 
	public DAORegistrarCurso(String usuario) {
		this.usuario = usuario;
	}

	public DTOSalida consultaCursos (DTOConsultaCurso dtoe) throws MareException {
	/* Obtiene los cursos que están en funcionamiento y cumplen los siguientes
	 * criterios: marca, canal, tipo de curso, código de curso y nombre de curso.
	 */
		UtilidadesLog.info(" DAORegistrarCurso.consultaCursos(DTOConsultaCurso) : Entrada");	 

		Vector parametros = new Vector();
		// Se crea la consulta SQL                  
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT A.OID_CURS OID,	A.COD_CURS CODIGO, ");

		// Subselect para obtener el nombre del curso
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.OID_CURS AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'EDU_MATRI_CURSO') AS NOMBRE, ");
		parametros.add(dtoe.getOidIdioma());

		consulta.append(" E.COD_TIPO_CURS TIPOCURSO,");

		// Subselect para obtener la descripción del tipo de curso 
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.OID_CURS AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'EDU_TIPO_CURSO') AS DESCTIPOCURSO, ");
		parametros.add(dtoe.getOidIdioma());

		// Obtener la descripción de la marca                           
		consulta.append(" C.DES_MARC AS MARCA,  ");
		
		// Subselect para obtener la descripción del canal                       
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");           
		consulta.append("WHERE V.VAL_OID = D.OID_CANA AND ");               
		consulta.append("V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");     
		consulta.append("V.ATTR_ENTI = 'SEG_CANAL') AS CANAL, "); 
		parametros.add(dtoe.getOidIdioma());
		
		// Subselect para obtener la descripcion del regalo 
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.REGA_OID_REGA AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'EDU_REGAL') AS REGALO, ");
		parametros.add(dtoe.getOidIdioma());
		consulta.append(" A.NUM_UNID UNIDADES, "); 

		// Subselect para obtener la decripcion del momento de entrega
		consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
		consulta.append(" WHERE V.VAL_OID =  A.MOME_OID_MOME_ENTR AND ");
		consulta.append(" V.IDIO_OID_IDIO = ? AND V.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" V.ATTR_ENTI = 'EDU_MOMEN_ENTRE') AS MOMENTO ");
		parametros.add(dtoe.getOidIdioma());

		consulta.append(" FROM EDU_MATRI_CURSO A, EDU_TIPO_CURSO E, VCA_SEG_PAIS B, ");
		consulta.append(" VCA_SEG_MARCA C, VCA_SEG_CANAL D "); 

		// datos del DTO
		
		Long pais = dtoe.getOidPais();
		Long marca = dtoe.getMarca();
		Long canal = dtoe.getCanal();
		Long tipoCurso = dtoe.getTipoCurso();
		Integer codigo = dtoe.getCodigo();
		String nombreCurso = dtoe.getNombre();
		
		consulta.append(" WHERE ");
		
		consulta.append("  A.PAIS_OID_PAIS = ? ");
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
			consulta.append(" V.ATTR_ENTI = 'EDU_MATRI_CURSO') LIKE ? ") ;
			parametros.add(dtoe.getOidIdioma());
			parametros.add(nombreCurso);
		}
		consulta.append(" AND A.IND_CTRL_FUNC = ? ");
		parametros.add(ConstantesCMN.VAL_TRUE); // Integer = 1
		
		consulta.append(" AND E.OID_TIPO_CURS = A.TICU_OID_TIPO_CURS ");

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
	                                                                       
		UtilidadesLog.info(" DAORegistrarCurso.consultaCursos(DTOConsultaCurso) : Salida");	 
		return dtoSalida;	                                               
	}//fin consultaCurso

	public  DTOSalida consultaParticipantes (DTOOIDCurso dtoe) throws MareException {
		/*Obtiene los participantes que no han asistido al curso y cumplen
		 * los siguientes criterios: oid del curso. */

		UtilidadesLog.info(" DAORegistrarCurso.consultaParticipantes(DTOOIDCurso) : Entrada");	 

		Vector parametros = new Vector();
		// Se crea la consulta SQL                  
		StringBuffer consulta = new StringBuffer();
		
		consulta.append("SELECT A.OID_APTA OID, C.COD_CLIE CODIGOCLIENTE, ");
		consulta.append(" C.VAL_APE1 APELLIDO1, C.VAL_APE2 APELLIDO2, ");
		consulta.append(" C.VAL_NOM1 NOMBRE1, C.VAL_NOM2 NOMBRE2, A.FEC_ASIS FECHA, ");
		consulta.append(" A.IND_INVI INVITADA, A.IND_APTA_CURS APTA, ");
		consulta.append(" B.TICL_OID_TIPO_CLIE TIPOCLIENTE, C.OID_CLIE OIDCLIENTE ");

		consulta.append(" FROM EDU_APTAS_CURSO A, MAE_SUBTI_CLIEN B, MAE_CLIEN C, ");
		consulta.append(" EDU_MATRI_CURSO D, VCA_SEG_PAIS E, VCA_SEG_MARCA F, ");
		consulta.append(" VCA_SEG_CANAL G ");

		// datos del DTO 
		
		Long oid = dtoe.getOid();

		consulta.append(" WHERE ");
		
		consulta.append(" A.MCUR_OID_CURS = ? ");
		parametros.add(oid);
		consulta.append(" AND A.IND_ASIS = ? ");
		parametros.add(ConstantesEDU.NO_ASIS);
		consulta.append(" AND B.OID_SUBT_CLIE = A.SBTI_OID_SUBT_CLIE ");
		consulta.append(" AND C.OID_CLIE = A.CLIE_OID_CLIE ");
		consulta.append(" AND D.OID_CURS = A.MCUR_OID_CURS ");
		consulta.append(" AND E.OID_PAIS = D.PAIS_OID_PAIS ");
		consulta.append(" AND E.COD_USUA = ? ");
		parametros.add(this.usuario);
		consulta.append(" AND F.OID_MARC = D.MARC_OID_MARC ");
		consulta.append(" AND F.COD_USUA = ? ");
		parametros.add(this.usuario);
		consulta.append(" AND G.OID_CANA = D.CANA_OID_CANA ");
		consulta.append(" AND G.COD_USUA = ? ");
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
			UtilidadesLog.error("consultaParticipantes: Exception",e);           
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
		}                                                                      
                                                                               
		// Se crea un DTOSalida a partir del RecordSet                         
		DTOSalida dtoSalida = new DTOSalida(rs);                               
	                                                                       
		UtilidadesLog.info(" DAORegistrarCurso.consultaParticipantes(DTOOIDCurso) : Salida");	 
		return dtoSalida;	                                               
	}// fin consultaParticipantes                                                                                             

	                                                             
} //fin DAORegistrarCurso