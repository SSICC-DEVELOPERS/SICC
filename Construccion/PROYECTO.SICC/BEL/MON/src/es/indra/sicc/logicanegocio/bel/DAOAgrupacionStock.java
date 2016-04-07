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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import es.indra.sicc.dtos.bel.DTOEBuscarAgrupacionStock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;


public class DAOAgrupacionStock  {
	private String usuario;
	public DAOAgrupacionStock(String usuario) {
		this.usuario = usuario;
	}

	//Métodos
	/** 
     * Método para buscar agrupación de stock
     * @param dto DTOEBuscarAgrupacionStock 
     * @return RecordSet el resultado de la busqueda
     * @exception MareException 
     */
	public RecordSet buscarAgrupacionStock(DTOEBuscarAgrupacionStock dto) throws MareException {
		UtilidadesLog.info("DAOAgrupacionStock.buscarAgrupacionStock(DTOEBuscarAgrupacionStock dto):Entrada");
		//Documentation
		//Entrada: DTOEBuscarAgrupacionStock 
		//- codigoAgrupacionStock : String 
		//- descripcion : String 
		//Proceso: 
		//-> Hacer consulta JDBC sobre la tabla BEL_AGRUP_STOCK_CABEC para obtener los campos 
		//OID_AGRU_STOC_CABE, COD_AGRU_STOC_CABE y la descripción internacionalizada del registro. 
		//Se filtrará por los atributos del dto de entrada PAIS_OID_PAIS = dto.pais, 
		//COD_AGRU_STOC_CABE = dto.codigoAgrupacionStock y la descripción, 
		//que viene en el idioma del usuario activo, dto.idioma. Esta búsqueda es paginada, 
		//por tanto habra que tener en cuenta las siguientes consideraciones: 
		//1.- oid del registro encontrado > dto.indicadorSituacion 
		//2.- ROWNUM <= dto.tamañoPagina 
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		consulta.append(" SELECT a.OID_AGRU_STOC_CABE OID, a.COD_AGRU_STOC_CABE CODIGO,");
		//Descripcion inter del registro
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID= a.OID_AGRU_STOC_CABE ");
		consulta.append(" AND v.IDIO_OID_IDIO = ? ");
		parametros.add(dto.getOidIdioma());
		consulta.append(" AND v.ATTR_NUM_ATRI = 1 ");
		consulta.append(" AND v.ATTR_ENTI = 'BEL_AGRUP_STOCK_CABEC') AS DESCRIPCION ");
		
		consulta.append(" FROM BEL_AGRUP_STOCK_CABEC a ");		
		if(dto.getDescripcion() != null) { 
			consulta.append(", V_GEN_I18N_SICC IDIO ");		
		}
		consulta.append(" WHERE a.PAIS_OID_PAIS = ? ");
		parametros.add(dto.getOidPais());

		//codigoAgrupacionStock
		if(dto.getCodigoAgrupacionStock()!=null) { 
			consulta.append(" AND a.COD_AGRU_STOC_CABE  LIKE ? "); 
			parametros.add(dto.getCodigoAgrupacionStock());
		}

		if(dto.getDescripcion() != null) { 
			consulta.append(" AND IDIO.VAL_OID= a.OID_AGRU_STOC_CABE ");
			consulta.append(" AND IDIO.IDIO_OID_IDIO = ? ");
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.ATTR_NUM_ATRI = 1 ");
			consulta.append(" AND IDIO.ATTR_ENTI = 'BEL_AGRUP_STOCK_CABEC'");
			consulta.append(" AND IDIO.VAL_I18N LIKE ?");		
			parametros.add(dto.getDescripcion());
		}

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
		try {
			resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
		} catch (Exception e) {
			this.logearError("buscarAgrupacionStock:",e);
			this.loguearSql("buscarAgrupacionStock",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		//-> Devolver el RecordSet obtenido en la actividad anterior, que contendrá los siguientes campos en este orden: 
		//- oidAgrupacionStockCabecera 
		//- codigoAgrupacionStockCabecera 
		//- descripcionAgrupacionStockCabecera (internacionalizada) 
		UtilidadesLog.info("DAOAgrupacionStock.buscarAgrupacionStock(DTOEBuscarAgrupacionStock dto):Salida");
		return resultado;
	}

	/** 
     * Método consultar una agrupacion de Stock
     * @param dto DTOOID 
     * @return RecordSet el resultado de la consulta
     * @exception MareException 
     */
	 public RecordSet consultarAgrupacionStockCabecera (DTOOID dto) throws MareException {
		 UtilidadesLog.info("DAOAgrupacionStock.consultarAgrupacionStockCabecera(DTOOID dto):Entrada");
		//Documentation
		//Entrada: DTOOID (oid de cabecera) 
		//Proceso: 
		//-> Hacer consulta JDBC sobre la tabla BEL_AGRUP_STOCK_CABEC para obtener 
		//los campos OID_AGRU_STOC_CABE, PAIS_OID_PAIS, COD_AGRU_STOC_CABE, descripción internacionalizada 
		//de la agrupación y IND_DEFE, filtrar por el campo OID_AGRU_STOC_CABE = dto.oid 
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		consulta.append(" SELECT a.OID_AGRU_STOC_CABE, a.PAIS_OID_PAIS, a.COD_AGRU_STOC_CABE,");
		//Descripcion inter del registro
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID= a.OID_AGRU_STOC_CABE ");
		consulta.append(" AND v.IDIO_OID_IDIO = ? ");
		parametros.add(dto.getOidIdioma());
		consulta.append(" AND v.ATTR_NUM_ATRI = 1 ");
		consulta.append(" AND v.ATTR_ENTI = 'BEL_AGRUP_STOCK_CABEC') AS DESCRIPCION,");
		consulta.append(" a.IND_DEFE ");
				
		consulta.append(" FROM BEL_AGRUP_STOCK_CABEC a ");		
		consulta.append(" WHERE a.OID_AGRU_STOC_CABE = ? ");
		parametros.add(dto.getOid());

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			this.logearError("consultarAgrupacionStockCabecera:",e);
			this.loguearSql("consultarAgrupacionStockCabecera",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		//-> Devolver el RecordSet obtenido en la actividad anterior, que contendrá un registro los siguientes campos: 
		//- oidAgrupacionStockCabecera 
		//- oidPais 
		//- codigoASC 
		//- descripción internacionalizada 
		//- indicadorDefecto	 
		UtilidadesLog.info("DAOAgrupacionStock.consultarAgrupacionStockCabecera(DTOOID dto):Salida");
		return resultado;
	 }

	 /** 
     * Método consultar detalle de una agrupacion de Stock
     * @param dto DTOOID 
     * @return RecordSet el resultado de la consulta
     * @exception MareException 
     */
	 public RecordSet consultarDetalleAgrupacionStock (DTOOID dto) throws MareException {
		UtilidadesLog.info("DAOAgrupacionStock.consultarDetalleAgrupacionStock(DTOOID dto):Entrada");
		//Documentation
		//Entrada: DTOOID (oid de cabecera) 
		//Proceso: 
		//-> Hacer consulta JDBC sobre la tabla BEL_AGRUP_STOCK_DETAL para obtener los 
		//campos OID_AGRU_STOC_DETA, ESME_OID_ESTA_MERC, haciendo join con la tabla BEL_ESTAD_MERCA 
		//obtener la descripción internacionalizada del estado de mercancía, y COD_OPER. 
		//Filtrar por AGSC_OID_AGRU_STOC_CABE = dto.oid 
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		consulta.append(" SELECT a.OID_AGRU_STOC_DETA, a.ESME_OID_ESTA_MERC,");
		//Descripcion inter del registro
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID= a.ESME_OID_ESTA_MERC ");
		consulta.append(" AND v.IDIO_OID_IDIO = ? ");
		parametros.add(dto.getOidIdioma());
		consulta.append(" AND v.ATTR_NUM_ATRI = 1 ");
		consulta.append(" AND v.ATTR_ENTI = 'BEL_ESTAD_MERCA') AS DESCRIPCION,");
		consulta.append(" a.COD_OPER ");
				
		consulta.append(" FROM BEL_AGRUP_STOCK_DETAL a ");		
		consulta.append(" WHERE a.AGSC_OID_AGRU_STOC_CABE = ? ");
		parametros.add(dto.getOid());

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			this.logearError("consultarDetalleAgrupacionStock:",e);
			this.loguearSql("consultarDetalleAgrupacionStock",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		//-> Devolver RecordSet obtenido, que contendrá una lista de registros con los siguientes campos: 
		//- oidAgrupacionStockDetalle 
		//- oidEstadoMercancia 
		//- descripcionEstadoMercancia (internacionalizada) 
		//- operacion	 
		 UtilidadesLog.info("DAOAgrupacionStock.consultarDetalleAgrupacionStock(DTOOID dto):Salida");
		 return resultado;
	 }

	 /** 
     * Método consultar agrupaciones por defecto
     * @param pais Long 
     * @return RecordSet el resultado de la consulta
     * @exception MareException 
     */

	 public RecordSet consultarAgrupacionStockPorDefecto(Long pais) throws MareException {
		UtilidadesLog.info("DAOAgrupacionStock.consultarAgrupacionStockPorDefecto(Long pais):Entrada");
		//Documentation
		//Entrada: pais (oid de pais) 
		//Proceso: 
		//-> Hacer consulta sobre tabla BEL_AGRUP_STOCK_CABEC para obtener el campo 
		//OID_AGRU_STOC_CABE de aquel registro donde PAIS_OID_PAIS = pais de entrada, 
		//y IND_DEFE = 1 (que es como decir que está a True) 
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		consulta.append(" SELECT a.OID_AGRU_STOC_CABE ");
		consulta.append(" FROM BEL_AGRUP_STOCK_CABEC a ");		
		consulta.append(" WHERE a.PAIS_OID_PAIS = ? ");
		consulta.append(" AND a.IND_DEFE = 1 ");
		parametros.add(pais);

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			this.logearError("consultarAgrupacionStockPorDefecto:",e);
			this.loguearSql("consultarAgrupacionStockPorDefecto",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		//-> Devolver RecordSet obtenido en actividad anterior, que contendrá 0 ó 1 registros 
		//con un sólo compo: oidAgrupacionStockCabecera
		UtilidadesLog.info("DAOAgrupacionStock.consultarAgrupacionStockPorDefecto(Long pais):Salida");
		return resultado;
	 }

	/**
	 * 
	 * @param DTOOID 
	 * @exception MareException
	 * @return RecordSet con los datos de la consulta
	 */
	
	public RecordSet consultarOidsDetalleAgrupacionStock(DTOOID dto) throws MareException {
		UtilidadesLog.info("DAOAgrupacionStock.consultarOidsDetalleAgrupacionStock(DTOOID dto):Entrada");

		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT DETAL.OID_AGRU_STOC_DETA ");
		consulta.append("FROM BEL_AGRUP_STOCK_DETAL DETAL ");
		consulta.append("WHERE DETAL.AGSC_OID_AGRU_STOC_CABE = ?");

		Vector parametros = new Vector();
		parametros.add(dto.getOid());

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			this.logearError("consultarOidsDetalleAgrupacionStock:",e);
			this.loguearSql("consultarOidsDetalleAgrupacionStock",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.info("DAOAgrupacionStock.consultarOidsDetalleAgrupacionStock(DTOOID dto):Salida");
		return rs;
	}
	
	 private void logStackTrace(Throwable e) {
    UtilidadesLog.info("DAOAgrupacionStock.logStackTrace(Throwable e):Entrada");
		try{
			UtilidadesLog.error("Se produjo la excepcion: " + e.getMessage());
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			UtilidadesLog.error("stack Trace : " +  pila.toString());
		}catch(Exception ex){
			UtilidadesLog.error("Eror Logeando Pila: "+ex.getMessage());
		}
    UtilidadesLog.info("DAOAgrupacionStock.logStackTrace(Throwable e):Salida");
	}


	private void loguearSql(String metodo, String sql, Vector params){
    UtilidadesLog.info("DAOAgrupacionStock.loguearSql(String metodo, String sql, Vector params):Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0){
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}	
    UtilidadesLog.info("DAOAgrupacionStock.loguearSql(String metodo, String sql, Vector params):Salida");
	}

	private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		UtilidadesLog.error(e);
	}

	
}
