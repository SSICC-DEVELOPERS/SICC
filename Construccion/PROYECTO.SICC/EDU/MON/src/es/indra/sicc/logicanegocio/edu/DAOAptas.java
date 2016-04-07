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

import java.util.ArrayList;
import java.util.Vector;
import java.math.BigDecimal;
import java.util.Date;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;

import es.indra.sicc.logicanegocio.edu.ConstantesEDU;

import es.indra.sicc.cmn.negocio.ConstantesCMN; 

import es.indra.sicc.dtos.edu.DTOAsignarAptas;
import es.indra.sicc.dtos.edu.DTOOIDApta;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DAOAptas  {

	private String usuario;

	public DAOAptas(String usuario) {
		this.usuario = usuario;
	}

	public DTOSalida consultaCursos (DTOAsignarAptas dtoe) throws MareException {
		UtilidadesLog.info(" DAOAptas.consultaCursos(DTOAsignarAptas) : Entrada");								
		Vector parametros = new Vector();
		
		StringBuffer sql=new StringBuffer();
		
		//ALIAS importante para armarQuery
		sql.append("SELECT A.OID_CURS OID, A.COD_CURS CODIGO, ");         
		
        //subselect de descripcion nombre                                                    
		sql.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");        
		sql.append("WHERE v.VAL_OID =  A.OID_CURS AND ");                
		sql.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");  
		sql.append("v.ATTR_ENTI = 'EDU_MATRI_CURSO') AS NOMBRE,  ");     
        parametros.add(dtoe.getOidIdioma());
                                    
		sql.append("E.COD_TIPO_CURS TIPOCURSO, ");                      
         	
       	//subselect de descripcion curso                                                        
		sql.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v  ");       
		sql.append("WHERE v.VAL_OID = E.OID_TIPO_CURS AND  ");           
		sql.append("v.IDIO_OID_IDIO =? AND v.ATTR_NUM_ATRI = 1 AND  ");  
		sql.append("v.ATTR_ENTI = 'EDU_TIPO_CURSO') AS DESCTIPOCURSO, ");
        parametros.add(dtoe.getOidIdioma());                                                   
		
		 //Descripcion marca
        sql.append(" C.DES_MARC AS MARCA,  ");        

        //subselect de descripcion canal                                       
		sql.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");        
		sql.append("WHERE v.VAL_OID = D.OID_CANA AND ");                 
		sql.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND  "); 
		sql.append("v.ATTR_ENTI = 'SEG_CANAL') AS CANAL, ");
		parametros.add(dtoe.getOidIdioma());
                                                                 
		sql.append("A.IND_ACCE_DMRT DATAMART, A.NUM_PART NUMPARTICIPANTES,  ");                
		
		// Incidencia BELC300007744
        sql.append(" A.CPLC_OID_CABE_PLAN_CURS  ");
        
        sql.append(" , D.OID_CANA  ");
        sql.append(" , C.OID_MARC  ");


		sql.append("FROM EDU_MATRI_CURSO A, EDU_TIPO_CURSO E, ");        
		sql.append("VCA_SEG_MARCA C,  VCA_SEG_CANAL D, VCA_SEG_PAIS B ");                
                                                                 
		
		sql.append("WHERE "); 
		//sql.append(" A.OID_CURS > ? "); 
		//parametros.add(dtoe.getIndicadorSituacion());

		sql.append(" A.PAIS_OID_PAIS = ? ");
		parametros.add(dtoe.getOidPais());


		Long canal = dtoe.getCanal();
		Long marca = dtoe.getMarca();
		Long tipCurso = dtoe.getTipoCurso();
		Integer codigo = dtoe.getCodigo();
		String nombre = dtoe.getNombre();
		
		
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
			sql.append("AND (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v  "); 
			sql.append("WHERE v.VAL_OID =  A.oid_curs AND ");  
			sql.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND "); 
			sql.append("v.ATTR_ENTI = 'EDU_MATRI_CURSO') LIKE  ? ");
			parametros.add(dtoe.getOidIdioma());
			parametros.add(nombre);
		}
        
        
		UtilidadesLog.info("************* IND CTRL FUNC* ********** --> "+dtoe.getIndOrigen().intValue() );
		String indOrigen = (dtoe.getIndOrigen()).toString();
        String constante = (ConstantesEDU.ORIG_APTAS).toString();
        
        if(indOrigen.equals(constante)){//(CASO DE USO ASIGNAR APTAS A CURSOS)
			sql.append("AND A.IND_CTRL_FUNC = ? "); 
			parametros.add(ConstantesCMN.VAL_TRUE);//(CONSTANTESCMN.VAL_TRUE);
		}
        
        
       /* if(dtoe.getIndOrigen().intValue()==ConstantesEDU.ORIG_APTAS.intValue()){//(CASO DE USO ASIGNAR APTAS A CURSOS)
			sql.append("AND A.IND_CTRL_FUNC = ? "); 
			parametros.add(obtieneBoolean(ConstantesCMN.VAL_TRUE));//(CONSTANTESCMN.VAL_TRUE);
		}*/
        
        /*
        Se elimina por incidencia 21736
        Paola Cabrera
        
        22/12/2005
        else{//(CASO DE USO PROBAR MATRIZ DE CURSOS)
			sql.append("AND A.IND_CTRL_FUNC = ? "); 
			parametros.add(obtieneBoolean(ConstantesCMN.VAL_FALSE));//(CONSTANTESCMN.VAL_FALSE);
			
		}	
        
        //--fin de comentario
        
		*/
		sql.append("AND E.OID_TIPO_CURS = A.TICU_OID_TIPO_CURS  ");               
		sql.append("AND B.OID_PAIS = A.PAIS_OID_PAIS  ");                        
		sql.append("AND B.COD_USUA = ?  ");                                
		parametros.add(this.usuario);
		sql.append("AND C.OID_MARC = A.MARC_OID_MARC  "); 
		
		sql.append("AND C.COD_USUA = ?  ");
		parametros.add(this.usuario);
		sql.append("AND D.OID_CANA = A.CANA_OID_CANA  ");                         
		sql.append("AND D.COD_USUA = ? ");
		parametros.add(this.usuario);



		String sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(),dtoe);
        UtilidadesLog.info("sqlPaginacion " + sqlPaginacion);
		
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
		UtilidadesLog.info("rs: " + rs);
        UtilidadesLog.info("parametros: " + parametros);
        
        
		UtilidadesLog.info("**** DAOAptas.consultaCursos(DTOAsignarAptas) : Salida");								
		return dtoSalida;	
			

	}// ConsultaCursos

	// BELC300006992
	public DTOSalida consultaAptas (DTOOIDApta dtoe) throws MareException {
		UtilidadesLog.info(" DAOAptas.consultaAptas(DTOOIDApta) : Entrada");		

		Vector parametros = new Vector();
		StringBuffer consulta=new StringBuffer();
	
		consulta.append("SELECT ");
		consulta.append("A.OID_APTA_ASIG OID,");
		consulta.append("B.COD_CLIE CODIGO, ");

		// cambiado por incidencia: 11426
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = C.TICL_OID_TIPO_CLIE AND  ");
		consulta.append("v.IDIO_OID_IDIO =? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append("v.ATTR_ENTI = 'MAE_TIPO_CLIEN') AS TIPO, ");
		parametros.add(dtoe.getOidIdioma());

		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = C.OID_SUBT_CLIE AND ");
		consulta.append("v.IDIO_OID_IDIO =? AND v.ATTR_NUM_ATRI = 1 AND  ");
		consulta.append("v.ATTR_ENTI = 'MAE_SUBTI_CLIEN') AS SUBTIPO, ");
		parametros.add(dtoe.getOidIdioma());
		
		consulta.append("B.VAL_NOM1 || ' ' || B.VAL_NOM2 NOMBRE, ");
		consulta.append("B.VAL_APE1 || ' ' || B.VAL_APE2 APELLIDOS, ");
		consulta.append("A.NUM_CONV CONVOCATORIA ");

		consulta.append("FROM ");
		consulta.append("EDU_APTAS_ASIGN A, ");
		consulta.append("MAE_CLIEN B, ");
		consulta.append("MAE_SUBTI_CLIEN C ");
		
		consulta.append("WHERE ");
		//consulta.append("A.OID_APTA_ASIG > ? ");//1 --DTOE.INDICADORSITUACION AND
		//parametros.add(dtoe.getIndicadorSituacion());
		
		consulta.append(" A.ASAP_OID_ASIG = ? ");//1 --OID ");
		parametros.add(dtoe.getOid());
		consulta.append("AND B.OID_CLIE = A.CLIE_OID_CLIE  ");
		consulta.append("AND C.OID_SUBT_CLIE = A.SBTI_OID_SUBT_CLIE ");

		String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dtoe);

		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(sql,parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("consultaAptas: Exception",e);
			       throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}


        UtilidadesLog.debug("rs: " + rs);
        UtilidadesLog.debug("parametros: " + parametros);
		// Se crea un DTOSalida a partir del RecordSet
		DTOSalida dtoSalida = new DTOSalida(rs);
	
	  UtilidadesLog.info("**** DAOAptas.consultaAptas(DTOOIDApta) : Salida");		
		return dtoSalida;
	}// consultaAptas

	public RecordSet obtieneSegundaConvocatoria (Integer codCurso, Long pais) throws MareException {

		UtilidadesLog.info(" DAOAptas.obtieneSegundaConvocatoria(Integer codCurso, Long pais) : Entrada");		

		Vector parametros = new Vector();
		StringBuffer consulta=new StringBuffer();

		consulta.append("SELECT ");
		consulta.append("B.CLIE_OID_CLIE CLIENTE, ");
		consulta.append("B.SBTI_OID_SUBT_CLIE SUBTIPO, ");
		consulta.append("B.IND_APTA_CURS APTA, ");
		consulta.append("B.IND_ACCE_DMRT DATAMART ");

		consulta.append("FROM ");
		consulta.append("EDU_MATRI_CURSO A, ");
		consulta.append("EDU_APTAS_CURSO B, ");
		consulta.append("VCA_SEG_PAIS C, ");
		consulta.append("VCA_SEG_MARCA D, ");
		consulta.append("VCA_SEG_CANAL E  ");

		consulta.append("WHERE ");
		consulta.append("A.COD_CURS = ? ");
		parametros.add(codCurso);

		consulta.append("AND A.PAIS_OID_PAIS = ? ");
		parametros.add(pais);

		consulta.append("AND B.MCUR_OID_CURS = A.OID_CURS ");
		consulta.append("AND B.NUM_CONV = ? ");
		parametros.add(ConstantesEDU.PRIM_CONV);

		consulta.append("AND B.IND_ASIS = ? ");
		parametros.add(ConstantesEDU.NO_ASIS);

		consulta.append("AND C.OID_PAIS = A.PAIS_OID_PAIS ");
		consulta.append("AND C.COD_USUA = ? ");
		parametros.add(this.usuario);
	
		consulta.append("AND D.OID_MARC = A.MARC_OID_MARC  ");
		consulta.append("AND D.COD_USUA = ? ");
		parametros.add(this.usuario); 
	
		consulta.append("AND E.OID_CANA = A.CANA_OID_CANA ");
		consulta.append("AND E.COD_USUA = ? ");
		parametros.add(this.usuario);

		
	// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtieneSegundaConvocatoria: Exception",e);
			      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
	
		UtilidadesLog.info(" DAOAptas.obtieneSegundaConvocatoria(Integer codCurso, Long pais) : Salida");		
		return rs;

	}// obtieneSegundaConvocatoria
    

    /**
     * Retorna los tipos de cursos exigidos para un corso.
     */
	 public ArrayList tipoCursosExigidos (Long oidCurso) throws MareException {
        UtilidadesLog.info(" DAOAptas.tipoCursosExigidos(Long oidCurso) : Entrada");		
		Vector parametros = new Vector();
		StringBuffer consulta=new StringBuffer();

		consulta.append(" SELECT TICU_OID_TIPO_CURS ");
		consulta.append(" FROM  EDU_MATRI_CURSO_EXIGI "); 
		consulta.append(" WHERE MCUR_OID_CURS = ? "); 
		parametros.add(oidCurso);

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("tipoCursosExigidos: Exception",e);
			       throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		ArrayList resultado = new ArrayList();
        for (int pos=0; pos < rs.getRowCount(); pos++) {
            if (rs.getValueAt(pos,0) != null) {
                resultado.add(new Long(((BigDecimal)rs.getValueAt(pos,0)).longValue()));
            }
        }
		UtilidadesLog.info(" DAOAptas.tipoCursosExigidos(Long oidCurso) : Salida");	
		return resultado;
	 }
     

    /**
     * Retorna los tipos de cursos recibidos, para un cliente.
     */
	public ArrayList tipoCursosRecibidos(Long oidCliente) throws MareException {
		UtilidadesLog.info(" DAOAptas.tipoCursosRecibidos(Long oidCurso, Long oidCliente) : Entrada");	
		Vector parametros = new Vector();
		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT DISTINCT TICU_OID_TIPO_CURS ");   
		consulta.append(" FROM ( ( ");   
		consulta.append("       SELECT  matrizCursos.TICU_OID_TIPO_CURS ");                                                                 
		consulta.append("       FROM  EDU_APTAS_CURSO aptas, EDU_MATRI_CURSO matrizCursos ");                                                                 
		consulta.append("       WHERE  aptas.CLIE_OID_CLIE = ? AND ");                                                                 
		consulta.append("           aptas.IND_ASIS <> ? ");                                                                 
		consulta.append("       ) ");                                                                 
		consulta.append("       UNION ");                                                                 
		consulta.append("       ( ");                                                                 
		consulta.append("       SELECT  matrizCursos.TICU_OID_TIPO_CURS ");                                                                 
		consulta.append("       FROM  EDU_HISTO_CURSO historicoCursos, EDU_MATRI_CURSO matrizCursos ");                                                                 
		consulta.append("       WHERE  historicoCursos.CLIE_OID_CLIE = ? AND ");                                                                 
		consulta.append("           historicoCursos.MCUR_OID_CURS = matrizCursos.OID_CURS ");                                                                 
		consulta.append("       ) )       ");                                                                 
		parametros.add(oidCliente);
		parametros.add(ConstantesEDU.NO_ASIS);
		parametros.add(oidCliente);

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("cursosRecibidos: Exception",e);
			      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		ArrayList resultado = new ArrayList();
        for (int pos=0; pos < rs.getRowCount(); pos++) {
            if (rs.getValueAt(pos,0) != null) {
                resultado.add(new Long(((BigDecimal)rs.getValueAt(pos,0)).longValue()));
            }
        }

		UtilidadesLog.info(" DAOAptas.tipoCursosRecibidos(Long oidCurso, Long oidCliente) : Salida");	
		return resultado;
	}


	public  Date ultimoCurso (Long oidCliente) throws MareException {

		UtilidadesLog.info(" DAOAptas.ultimoCurso(Long oidCliente) : Entrada");	
		Vector parametros = new Vector();
		StringBuffer consulta=new StringBuffer();

		consulta.append("SELECT FECHA FROM ");                                                 
		consulta.append("(               ");                                                   
		                                                
		consulta.append("	 ( SELECT FEC_ASIS FECHA ");                                      
		consulta.append("	  FROM EDU_APTAS_CURSO ");                                       
		consulta.append("	  WHERE ");                                                      
		consulta.append("	  CLIE_OID_CLIE =? ");//--oidCliente (parámetro de entrada)  
		parametros.add(oidCliente);
		
		consulta.append("	  AND IND_ASIS <> ? )");
		parametros.add(ConstantesEDU.NO_ASIS);
		
							                                               
                                                                                       
		consulta.append("UNION ");                                                             
		                                                                     
		consulta.append("	( ");                                                          
		consulta.append("	  SELECT FEC_ASIS FECHA  ");                                     
		consulta.append("	  FROM EDU_HISTO_CURSO ");                                       
		consulta.append("	  WHERE CLIE_OID_CLIE = ? )"); //1--oidCliente (parámetro de entrada)"); 
		parametros.add(oidCliente);
		
								
		consulta.append(")  ");
		consulta.append("ORDER BY FECHA DESC ");      
                                     

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("ultimoCurso: Exception",e);
			
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

//Atencion aqui al repasar con el mon, ver que tiene que devolver si no hqy nada en rs NULL??
		Date resultado = new Date();
		if (!rs.esVacio()) {
			if (rs.getValueAt(0, "FECHA")!=null) { //(rs.getValueAt(0,0)
				resultado = (Date)rs.getValueAt(0, "FECHA");
			}
		}else{resultado=null;
			}
		
		UtilidadesLog.info(" DAOAptas.ultimoCurso(Long oidCliente) : Salida");	
		return resultado;
	}// ultimoCurso

	
	private Boolean obtieneBoolean(Integer constantes){
     UtilidadesLog.info(" DAOAptas.obtieneBoolean(Integer constantes) : Entrada");	

		if(constantes.equals(new Integer("0"))){
			return Boolean.FALSE;
		}else{
			if(constantes.equals(new Integer("1"))){
				return Boolean.TRUE;
			}
		}//si no es cero que devuelva true
		UtilidadesLog.info(" DAOAptas.obtieneBoolean(Integer constantes) : Salida");	
    return Boolean.TRUE;
		
	}//

    /**
     * Verifica si un cliente esta asignado o no a un curso.
     */
	public Boolean clienteAsignadoACurso(Long oidCliente, Long oidCurso) throws MareException {
		UtilidadesLog.info(" DAOAptas.clienteAsignadoACurso(Long oidCliente, Long oidCurso) : Entrada");
        
        Boolean resultado = Boolean.FALSE;
		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT COUNT(*) ");
		consulta.append(" FROM EDU_APTAS_ASIGN A");
		consulta.append(" WHERE A.ASAP_OID_ASIG = "+oidCurso.longValue()+" ");
		consulta.append("   AND A.CLIE_OID_CLIE = "+oidCliente.longValue()+" ");

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		try {
			rs = bs.dbService.executeStaticQuery(consulta.toString());
		} catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("clienteAsignadoACurso: Exception",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        if(((BigDecimal)rs.getValueAt(0,0)).intValue()>0){
            resultado = Boolean.TRUE;
        }

		UtilidadesLog.info(" DAOAptas.clienteAsignadoACurso(Long oidCliente, Long oidCurso) : Salida");
		return resultado;
	}

}//clase

