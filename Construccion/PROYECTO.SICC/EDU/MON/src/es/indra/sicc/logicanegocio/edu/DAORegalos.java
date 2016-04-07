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


import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;

import java.util.Vector;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.dtos.edu.DTOConsultaRegalo;

public class DAORegalos  {

	private String usuario;
	
	public DAORegalos(String usuario) {
		this.usuario = usuario;
	}

	/** 
     * Obtiene los productos de un regalo. El idioma se agregó por incidencia número 6949
     * @param oidRegalo Long con el numero identificador del regalo
	 * @param idioma Long: identificador del idioma
     * @return Recordset 
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontró el registro
     */   
	public RecordSet obtieneProductos(Long oidRegalo, Long idioma) throws MareException {
		UtilidadesLog.info(" DAORegalos.obtieneProductos(Long oidRegalo, Long idioma) : Entrada");	 
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros=new Vector();
		try {
			
			consulta.append(" SELECT A.PROD_OID_PROD OID, ");
			consulta.append(" B.COD_SAP CODIGO, ");
			consulta.append("(SELECT IDIO.VAL_I18N DESCRIPCION FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.ATTR_ENTI = 'MAE_PRODU' AND IDIO.IDIO_OID_IDIO = ? AND "); //oidIdioma
			consulta.append(" IDIO.VAL_OID = B.OID_PROD) AS descProducto ");
			consulta.append(" FROM EDU_REGAL_DETAL A, MAE_PRODU B, VCA_SEG_PAIS C ");
			consulta.append(" WHERE ");
			consulta.append(" A.REGA_OID_REGA = ? "); //oidRegalo: parametro de entrada
			consulta.append(" AND B.OID_PROD = A.PROD_OID_PROD ");
			consulta.append(" AND C.OID_PAIS = B.PAIS_OID_PAIS ");
      consulta.append(" AND C.COD_USUA = ? "); //usuario

			parametros.add(idioma);
			parametros.add(oidRegalo);
			parametros.add(usuario);
			//ejecutamos la consulta
			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error("DAORegalos: Exception",e);
			      String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info(" DAORegalos.obtieneProductos(Long oidRegalo, Long idioma) : Salida");	 
		return rs;	
	}

	/** 
     * Obtiene los oid de la entidad RegalosProductos para un regalo determinado. 
     * @param oidRegalo Long con el numero identificador del regalo
     * @return Recordset 
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontró el registro
     */
	public RecordSet obtieneRegaloProducto (Long oidRegalo) throws MareException {

		UtilidadesLog.info(" DAORegalos.obtieneRegaloProducto(Long oidRegalo) : Entrada");	 
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros=new Vector();	
		try{
		
			consulta.append(" SELECT A.OID_DETA ");
			consulta.append(" FROM EDU_REGAL_DETAL A, EDU_REGAL B, VCA_SEG_PAIS C ");
			consulta.append(" WHERE ");
			consulta.append(" A.REGA_OID_REGA = ? "); //iodRegalo parametro entrada
			consulta.append( " AND B.OID_REGA = ? "); //iodRegalo parametro entrada
			consulta.append(" AND C.OID_PAIS = B.PAIS_OID_PAIS ");
			consulta.append(" AND C.COD_USUA = ? "); //usuario

			parametros.add(oidRegalo);
			parametros.add(oidRegalo);
			parametros.add(usuario);
			//ejecutamos la consulta
			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch(Exception e){
			UtilidadesLog.error("DAORegalos: Exception",e);
			       String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));	
		}
		UtilidadesLog.info(" DAORegalos.obtieneRegaloProducto(Long oidRegalo) : Salida");	 
		return rs;	
	}

	/** 
     * Obtiene los regalos que cumplen los criterios: código de regalo y código de producto  
     * @param dto DTOConsultaRegalo con los criterios de busqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
	public DTOSalida obtieneRegalos (DTOConsultaRegalo dto) throws MareException {

		UtilidadesLog.info(" DAORegalos.obtieneRegalos(DTOConsultaRegalo) : Entrada");	 
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros=new Vector();	
		try{
			consulta.append(" SELECT DISTINCT(A.OID_REGA) OID, ");
			consulta.append(" A.COD_REGA, ");
			consulta.append("(SELECT IDIO.VAL_I18N FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.ATTR_ENTI = 'EDU_REGAL' AND IDIO.IDIO_OID_IDIO = ? AND "); //oidIdioma
			consulta.append(" IDIO.VAL_OID = A.OID_REGA) AS descRegalo ");
			parametros.add(dto.getOidIdioma());
			consulta.append(" FROM EDU_REGAL A, EDU_REGAL_DETAL B, MAE_PRODU C, VCA_SEG_PAIS D ");
			consulta.append(" WHERE ");
					
			consulta.append(" A.PAIS_OID_PAIS = ? "); //dto.oidPais
			parametros.add(dto.getOidPais());

			if (dto.getCodRegalo() !=null) {
				consulta.append(" AND A.COD_REGA LIKE ? " ); //dto.codRegalo
				parametros.add(dto.getCodRegalo());
			}
			consulta.append(" AND B.REGA_OID_REGA = A.OID_REGA ");
			consulta.append(" AND C.OID_PROD = B.PROD_OID_PROD ");
			if (dto.getCodProducto() !=null) {
				consulta.append(" AND C.COD_SAP LIKE ? "); //dto.codProducto
				parametros.add(dto.getCodProducto());
			}
			consulta.append(" AND D.OID_PAIS = A.PAIS_OID_PAIS ");
			consulta.append(" AND D.COD_USUA = ? "); //usuario
			parametros.add(usuario);      
			consulta.append(" ORDER BY A.COD_REGA ");
			
			String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);
			
			//ejecutamos la consulta
			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(sql,parametros);
			
		}catch (Exception e){
			UtilidadesLog.error("DAORegalos: Exception",e);
			
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		
		// Se devuelve un DTOSalida que contiene el resultado de la consulta
        DTOSalida dtoSalida = new DTOSalida(rs);

		UtilidadesLog.info(" DAORegalos.obtieneRegalos(DTOConsultaRegalo) : Salida");	 
        return dtoSalida;
	}
	
	

}