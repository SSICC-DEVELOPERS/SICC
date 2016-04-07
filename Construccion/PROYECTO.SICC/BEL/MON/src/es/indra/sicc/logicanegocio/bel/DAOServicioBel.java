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


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;

import es.indra.sicc.dtos.bel.DTOStock;

import es.indra.sicc.dtos.cal.DTOBuscarStockProducto;

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.dtos.bel.DTOMovimientoCajaDetalle;

import java.util.Vector;
import java.text.SimpleDateFormat;

/**
 * 
 */
public class DAOServicioBel  {

	private String usuario;
	
	public DAOServicioBel(String usuario) {
		this.usuario = usuario;
	}


  
 /**
  *  Método para obtener las posiciones de cambio y ventas asociada a la 
  *  solicitud recibida
  *  Incidencia asociada: BELC300022052 - DBLG400000834 
  * @author gpons
  * @date 23/06/2006
  * @param oidSolicitud Long
  * @return RecordSet 
  * @exception MareException 
  * 
 **/
  public RecordSet obtenerPosicionesCambioVenta(Long oidSolicitud) throws MareException
  {
  
    UtilidadesLog.info("DAORegistroOnline.obtenerPosicionesCambioVenta(Long oidSolicitud): Entrada ");
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {

      buf.append(" SELECT ");
      buf.append(" SP.OID_SOLI_POSI OID, "); 
      buf.append(" SP.PROD_OID_PROD OID_PRODUCTO, "); 
      buf.append(" MP.COD_SAP COD_PRODUCTO, "); 
      buf.append(" SP.VAL_CODI_VENT CODIGO_VENTA, "); 
      buf.append(" SP.COD_POSI NUMERO_POSICION, "); 
      buf.append(" SP.NUM_UNID_ATEN UNIDADES_ATENDIDAS, "); 
      buf.append(" SP.VAL_PREC_FACT_UNIT_LOCA PRECIO_UNITARIO, "); 
      buf.append(" SP.NUM_UNID_CAMB UNIDADES_CAMBIO, "); 
      buf.append(" SP.NUM_UNID_VENT UNIDADES_VENTA "); 
      buf.append(" FROM "); 
      buf.append(" PED_SOLIC_POSIC SP, "); 
      buf.append(" MAE_PRODU MP, ");
      buf.append(" PED_SOLIC_CABEC SC ");
      buf.append(" WHERE "); 
      buf.append(" SC.SOCA_OID_SOLI_CABE = " + oidSolicitud + " AND "); 
      buf.append(" SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE AND ");      
      buf.append(" MP.OID_PROD = SP.PROD_OID_PROD "); 
      buf.append(" ORDER BY PRECIO_UNITARIO DESC ");
      
      rs = bs.dbService.executeStaticQuery(buf.toString());
    }
    catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAORegistroOnline.obtenerPosicionesCambioVenta(Long oidSolicitud): Salida ");
    return rs;
  }
  


 /**
  *  Método para obtener la información de cambio y ventas asociada a la 
  *  solicitud recibida
  *  Incidencia asociada: BELC300022052 - DBLG400000834 
  * @author gpons
  * @date 23/06/2006
  * @param dtoE DTOOID 
  * @return RecordSet 
  * @exception MareException 
  * 
 **/
 public RecordSet simularCambiosVentas(DTOOID dtoE) throws MareException
  {
    UtilidadesLog.info("DAORegistroOnline.simularCambiosVentas(DTOOID dtoE): Entrada ");
    BelcorpService bs;
    RecordSet rs;
    StringBuffer buf = new StringBuffer();
    try {
      bs = BelcorpService.getInstance();
    }
    catch(MareMiiServiceNotFoundException e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {
    
      buf.append(" SELECT ");
      buf.append(" GEN_P.VAL_I18N PRODUCTO, "); 
      buf.append(" SP.NUM_UNID_ATEN UNIDADES_ATENDIDAS, "); 
      buf.append(" SP.VAL_PREC_FACT_UNIT_LOCA MONTO, ");
      buf.append(" SP.NUM_UNID_CAMB UNIDADES_CAMBIO, ");
      buf.append(" SP.NUM_UNID_VENT UNIDADES_VENTA ");
      buf.append(" FROM ");
      buf.append(" PED_SOLIC_POSIC SP, ");
      buf.append(" GEN_I18N_SICC_PAIS GEN_P, "); 
      buf.append(" PED_SOLIC_CABEC SC ");       
      buf.append(" WHERE "); 
      buf.append(" GEN_P.ATTR_ENTI = 'MAE_PRODU' AND "); 
      buf.append(" GEN_P.ATTR_NUM_ATRI = 1 AND "); 
      buf.append(" GEN_P.IDIO_OID_IDIO = " + dtoE.getOidIdioma() + " AND "); 
      buf.append(" GEN_P.VAL_OID = SP.PROD_OID_PROD AND "); 
      buf.append(" SC.SOCA_OID_SOLI_CABE = " + dtoE.getOid() + " AND ");
      buf.append(" SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");       

      rs = bs.dbService.executeStaticQuery(buf.toString());
    }
    catch(Exception e) {
      UtilidadesLog.error("Exception: ",e);
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAORegistroOnline.simularCambiosVentas(DTOOID dtoE): Salida ");
    return rs;
  }

	// Incidencia 4522
	/** 
     * Método para obtener los medios de pago de un pais (datos asignables a un combo)
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerMediosPagoCombo(DTOBelcorp dto) throws MareException{
		/*	public DTOSalida obtenerMediosPagoCombo(DTOBelcorp dto) {
		 * Entrada: DTOBelcorp
		 * Proceso: 
		 * -> Hacer consulta JDBC sobre la tabla BEL_MEDIO_PAGO, para obtener 
		 * los campos OID_MEDI_PAGO y COD_MEDI_PAGO + descripción internacionalizada 
		 * del medio de pago. Se filtrará por pais, tomando el pais del dto de entrada.
		 * -> Devolver RecordSet obtenido en un objeto DTOSalida.
		 * }
		 */
		UtilidadesLog.info("DAOServicioBel.obtenerMediosPagoCombo(DTOBelcorp dto):Entrada");
		
		DTOSalida dtoSalida = null;
		Vector parametros=new Vector();
		StringBuffer query = new StringBuffer("");		 
		query.append(" SELECT e.OID_MEDI_PAGO,E.COD_MEDI_PAGO||' '||(SELECT i.val_i18n FROM V_GEN_I18N_SICC i WHERE "+ 
                 " i.attr_enti = 'BEL_MEDIO_PAGO' AND i.attr_num_atri = 1 AND i.idio_oid_idio = ? AND "+
                 " i.val_oid = e.OID_MEDI_PAGO ) AS DESC_MEDIO_PAGO");
		parametros.add(dto.getOidIdioma());
		query.append(" FROM BEL_MEDIO_PAGO e");
		query.append(" WHERE e.PAIS_OID_PAIS = ? ");
		parametros.add(dto.getOidPais());
		query.append(" ORDER BY 2");
		RecordSet rs;
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try{
		  rs = (RecordSet) bs.dbService.executePreparedQuery(query.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerMediosPagoCombo",query.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		dtoSalida =  new DTOSalida();
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("DAOServicioBel.obtenerMediosPagoCombo(DTOBelcorp dto):Salida");
		return dtoSalida;
	}

	/** 
     * Método para consultar el Stock de una Agrupacion para un almacen y un producto determinados
     * @param pais Long con el oid del pais
     * @param almacen Long con el oid del almacen
     * @param producto Long con el oid del producto
     * @param codigoAgrupacion String con el codigo de agrupacion
     * @return RecordSet con los detalles de la Agrupacion de Stock
     * @exception MareException 
     */	
	public RecordSet obtenerStocksAgrupacion (Long pais, Long almacen, Long producto, String codigoAgrupacion) throws MareException{
		UtilidadesLog.info("DAOServicioBel.obtenerStocksAgrupacion (Long pais, Long almacen, Long producto, String codigoAgrupacion):Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros=new Vector();
		try{
			
			consulta.append(" SELECT BEL_AGRUP_STOCK_DETAL.COD_OPER, BEL_STOCK.VAL_SALD ");
			consulta.append(" FROM BEL_AGRUP_STOCK_CABEC , BEL_AGRUP_STOCK_DETAL , ");
			consulta.append(" BEL_STOCK , BEL_ESTAD_MERCA ");
			consulta.append(" WHERE ( (BEL_AGRUP_STOCK_CABEC.OID_AGRU_STOC_CABE = BEL_AGRUP_STOCK_DETAL.AGSC_OID_AGRU_STOC_CABE) AND ");
			consulta.append(" (BEL_ESTAD_MERCA.OID_ESTA_MERC = BEL_AGRUP_STOCK_DETAL.ESME_OID_ESTA_MERC) AND ");
			consulta.append(" (BEL_ESTAD_MERCA.OID_ESTA_MERC = BEL_STOCK.ESME_OID_ESTA_MERC) AND ");
			consulta.append(" (BEL_AGRUP_STOCK_CABEC.PAIS_OID_PAIS = ?) AND "); //pais
			parametros.add(pais);
			consulta.append(" (BEL_AGRUP_STOCK_CABEC.COD_AGRU_STOC_CABE = ?) AND "); //codigoAgrupacion
			parametros.add(codigoAgrupacion);
			consulta.append(" (BEL_STOCK.ALMC_OID_ALMA = ?) AND (BEL_STOCK.PROD_OID_PROD = ?) ) "); //almacen,producto
			parametros.add(almacen);
			parametros.add(producto);
			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerStocksAgrupacion",consulta.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info("DAOServicioBel.obtenerStocksAgrupacion (Long pais, Long almacen, Long producto, String codigoAgrupacion):Salida");
		return rs;	
	}

	/** 
     * Método para obtener los medios de pago de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerMediosDePago(DTOBelcorp dto) throws MareException{
		UtilidadesLog.info("DAOServicioBel.obtenerMediosDePago(DTOBelcorp dto):Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros=new Vector();
		try{
			
			consulta.append(" SELECT mp.OID_MEDI_PAGO,mp.COD_MEDI_PAGO, ");

			//Descripcion del medio de pago.
			consulta.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_MEDIO_PAGO' AND IDIO.idio_oid_idio = ? AND "); //oidIdioma
			consulta.append(" IDIO.val_oid = mp.OID_MEDI_PAGO ) AS DES_MEDIO_PAGO, ");
			parametros.add(dto.getOidIdioma());
			
			//Descripcion del tipo de medio de pago.
			consulta.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_TIPO_MEDIO_PAGO' AND IDIO.idio_oid_idio = ? AND "); //oidIdioma
			consulta.append(" IDIO.val_oid = mp.TMEP_OID_TIPO_MEDI_PAGO ) AS DES_TIPO_MEDIO_PAGO ");
			parametros.add(dto.getOidIdioma());

			consulta.append(" FROM BEL_MEDIO_PAGO mp  ");
			consulta.append(" WHERE  mp.PAIS_OID_PAIS=?  "); //oidPais
			parametros.add(dto.getOidPais());

			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerMediosDePago",consulta.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info("DAOServicioBel.obtenerMediosDePago(DTOBelcorp dto):Salida");
		return new DTOSalida(rs);			
	}

	/** 
     * Método para obtener los tipos de medios de pago
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerTiposMedioPago(DTOBelcorp dto) throws MareException{ //abrir incidencia
		UtilidadesLog.info("DAOServicioBel.obtenerTiposMedioPago(DTOBelcorp dto):Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");	
		Vector parametros=new Vector();
		try{
			
			consulta.append(" SELECT tp.OID_TIPO_MEDI_PAGO, ");
			//Descripcion del tipo de medio de pago.
			consulta.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_TIPO_MEDIO_PAGO' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = tp.OID_TIPO_MEDI_PAGO ) AS DES_TIPO_MEDIO_PAGO ");
			consulta.append(" FROM BEL_TIPO_MEDIO_PAGO tp  ");
			consulta.append(" ORDER BY 2");

			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerTiposMedioPago",consulta.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info("DAOServicioBel.obtenerTiposMedioPago(DTOBelcorp dto):Salida");
		return new DTOSalida(rs);			
	}

	/** 
     * Método para obtener las formas de pago de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerFormasPagoCabecera (DTOBelcorp dto) throws MareException{ 
		UtilidadesLog.info("DAOServicioBel.obtenerFormasPagoCabecera (DTOBelcorp dto):Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");		
		Vector parametros=new Vector();
		try{
			
			consulta.append(" SELECT fp.OID_FORM_PAGO ,CONCAT (CONCAT(fp.COD_FORM_PAGO,' '), ");

			//Descripcion de la forma de pago.
			consulta.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_FORMA_PAGO' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid = fp.OID_FORM_PAGO )) AS DESC_FORMA_PAGO  ");
			
			consulta.append(" FROM BEL_FORMA_PAGO fp  ");
			consulta.append(" WHERE fp.PAIS_OID_PAIS=?  "); //pais
			consulta.append(" ORDER BY 2");//gus
			parametros.add(dto.getOidPais());

			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerFormasPagoCabecera",consulta.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		UtilidadesLog.info("DAOServicioBel.obtenerFormasPagoCabecera (DTOBelcorp dto):Salida");
		return new DTOSalida(rs);			
	}	

	/** 
     * Método para obtener los estados de mercancia de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerEstadosMercancia(DTOBelcorp dto) throws MareException{ 
		UtilidadesLog.info("DAOServicioBel.obtenerEstadosMercancia(DTOBelcorp dto):Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");		
		Vector parametros=new Vector();
		try{
			
			consulta.append(" SELECT em.OID_ESTA_MERC , ");
			
			//Descripcion del estado del Mercado
			consulta.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_ESTAD_MERCA' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid =  em.OID_ESTA_MERC ) AS DESC_ESTADO_MERCADO ");
			
			consulta.append(" FROM BEL_ESTAD_MERCA em  ");
			consulta.append(" WHERE em.PAIS_OID_PAIS=?  "); //pais
			parametros.add(dto.getOidPais());
			consulta.append(" ORDER BY 2");

			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerEstadosMercancia",consulta.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info("DAOServicioBel.obtenerEstadosMercancia(DTOBelcorp dto):Salida");
		return new DTOSalida(rs);			
	}	

	/** 
     * Método para obtener los almacenes de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerAlmacenes (DTOBelcorp dto) throws MareException{ 
		UtilidadesLog.info("DAOServicioBel.obtenerAlmacenes (DTOBelcorp dto):Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");		
		Vector parametros=new Vector();
		try{
			
			consulta.append(" SELECT a.OID_ALMA , ");

			//Descripcion de Almacen
			consulta.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
			consulta.append(" IDIO.attr_enti = 'BEL_ALMAC' AND IDIO.idio_oid_idio = ?  "); //oidIdioma
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND IDIO.val_oid =  a.OID_ALMA ) AS DESC_ALMACEN ");
			
			consulta.append(" FROM BEL_ALMAC a  ");
			consulta.append(" WHERE a.PAIS_OID_PAIS=?  "); //pais
			parametros.add(dto.getOidPais());
			consulta.append(" ORDER BY 2");

			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerAlmacenes",consulta.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info("DAOServicioBel.obtenerAlmacenes (DTOBelcorp dto):Salida");
		return new DTOSalida(rs);			
	}	

	/** 
     * Método para obtener las operaciones definidas
     * @return RecordSet el resultado de la consulta
     * @exception MareException 
     */	
	public RecordSet obtenerOperaciones() throws MareException{ 
		UtilidadesLog.info("DAOServicioBel.obtenerOperaciones():Entrada");
		RecordSet rs=new RecordSet();
		StringBuffer consulta = new StringBuffer("");		
		Vector parametros=new Vector();
		try{
			

			consulta.append(" SELECT o.OID_OPER ,o.COD_OPER ");			
			consulta.append(" FROM BEL_OPERA o ");
			// MODIFICACION -------------------------------
			// Autor: Maximiliano Dello Russo (grusso).
			// Motivo: Se agrega línea para que los datos retornados queden ordenados
			// alfabeticamente, y de este modo quedan ordenados en el combo que
			// utiliza los mismos.  Por inc BELC300010890.  
			consulta.append(" ORDER BY o.cod_oper ");
			// FIN MODIFICACION ---------------------------
			
			BelcorpService bs = UtilidadesEJB.getBelcorpService();	
			rs = (RecordSet) bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerOperaciones",consulta.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		UtilidadesLog.info("DAOServicioBel.obtenerOperaciones():Salida");
		return rs;			
	}	

	/** Metodo para obtener stocks
	 * @param DTOStock
	 * @return RecordSet
	 * @exception MareException
	 * @author masanz
	 */
	public RecordSet obtenerStocks(DTOStock dtoStock) throws MareException {
		UtilidadesLog.info("DAOServicioBel.obtenerStocks(DTOStock dtoStock):Entrada");
		
		RecordSet rs = new RecordSet();
		StringBuffer consulta = new StringBuffer("");
		Vector param = new Vector();
		String sql = null;
		//Select
		consulta.append("SELECT S.OID_STOC, S.ALMC_OID_ALMA, S.ESME_OID_ESTA_MERC, ");
		consulta.append("S.PROD_OID_PROD , S.VAL_SALD ");
		//From
		consulta.append("FROM BEL_STOCK S ");
		//Where
		StringBuffer sqlwhere = new StringBuffer("");
		if (dtoStock.getOidStock() != null) {
			sqlwhere.append("S.OID_STOC = ? AND ");
			param.add(dtoStock.getOidStock());
		}
		if (dtoStock.getOidAlmacen() != null) {
			sqlwhere.append("S.ALMC_OID_ALMA = ? AND ");
			param.add(dtoStock.getOidAlmacen());
		}
		if (dtoStock.getOidEstadoMercancia() != null) {
			sqlwhere.append("S.ESME_OID_ESTA_MERC = ? AND ");
			param.add(dtoStock.getOidEstadoMercancia());
		}
		if (dtoStock.getOidProducto() != null) {
			sqlwhere.append("S.PROD_OID_PROD = ? AND ");
			param.add(dtoStock.getOidProducto());
		}
		if (dtoStock.getSaldo() != null) {
			sqlwhere.append("S.VAL_SALD = ? AND ");
			param.add(dtoStock.getSaldo());
		}

		if (sqlwhere.length() != 0){
			sql = consulta.toString() + " WHERE " + 
					sqlwhere.toString().substring(0,sqlwhere.toString().length() - 4);
		}
		else{
			sql = consulta.toString();
		}

		BelcorpService bs = UtilidadesEJB.getBelcorpService();

		try{
			rs = (RecordSet)bs.dbService.executePreparedQuery(sql,param);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerStocks",sql,param);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		
		UtilidadesLog.info("DAOServicioBel.obtenerStocks(DTOStock dtoStock):Salida");
		return rs;
	}

	// Incidencia BELC300008595 
	/** 
     * Método para obtener el tipo de cliente de un cliente
     * @param oidCliente Long con el oid del cliente
     * @return Long el resultado de la consulta
     * @exception MareException 
     */	
	public Long obtenerPrimerTipoCliente(Long oidCliente) throws MareException{
	/** 
		Proceso: 
			-> Hacer consulta JDBC sobre la tabla MAE_CLIEN_TIPO_SUBTI 
			-> Obtener el campo TICL_OID_TIPO_CLIE para los siguientes criterios: 
			-> CLIE_OID_CLIE = oidCliente 
			-> Tomar el primer registro del RecordSet obtenido 
			-> Devolver el oid de tipo de cliente contenido en el registro
	*/
		UtilidadesLog.info("DAOServicioBel.obtenerPrimerTipoCliente(Long oidCliente):Entrada");
		
		Long tipoCliente = null;
		Vector parametros = new Vector();
		StringBuffer query = new StringBuffer("");		 
		query.append(" SELECT TICL_OID_TIPO_CLIE");
		query.append(" FROM MAE_CLIEN_TIPO_SUBTI");
		query.append(" WHERE CLIE_OID_CLIE =  ? ");
		parametros.add(oidCliente);
		RecordSet rs;
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try{
		  rs = (RecordSet) bs.dbService.executePreparedQuery(query.toString(), parametros);
		}catch (Exception e){
			UtilidadesLog.error(e);
			this.loguearSql("obtenerMediosPagoCombo",query.toString(),parametros);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));			
		}
		if (!rs.esVacio()) {
			tipoCliente = new Long(((BigDecimal)rs.getValueAt(0, 0)).longValue());
		}
		UtilidadesLog.info("DAOServicioBel.obtenerPrimerTipoCliente(Long oidCliente):Salida");
		return tipoCliente;
	}

  public DTOBoolean comprobarParametrizacionSubacceso(DTOOID dto) throws MareException{

     UtilidadesLog.info("DAOServicioBel.comprobarParametrizacionSubacceso(DTOOID dto):Entrada");
     BelcorpService bs;
     RecordSet resultado = new RecordSet();
     DTOBoolean dtos = new DTOBoolean();
     bs = UtilidadesEJB.getBelcorpService();

     StringBuffer query = new StringBuffer();

     try {
          bs = BelcorpService.getInstance();

          query.append(" SELECT OID_PARA");
		      query.append(" FROM BEL_PARAM_BELCE");
		      query.append(" WHERE SBAC_OID_SBAC = " + dto.getOid());
          query.append(" AND PAIS_OID_PAIS = " + dto.getOidPais());
          resultado = bs.dbService.executeStaticQuery(query.toString());
          
      
     } catch (Exception e) {
            UtilidadesLog.debug(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }

     if (!resultado.esVacio()) {
        dtos.setValor(true);
     }else{
        dtos.setValor(false);
     }
     UtilidadesLog.info("DAOServicioBel.comprobarParametrizacionSubacceso(DTOOID dto):Salida");
     return dtos;
		
  }
	
	private void logStackTrace(Throwable e) {
		try{
			UtilidadesLog.error("Se produjo la excepcion: " + e.getMessage());
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			/*e.printStackTrace(out);
			UtilidadesLog.error("stack Trace : " +  pila.toString());*/
      UtilidadesLog.error(e);
		}catch(Exception ex){
			UtilidadesLog.error("Eror Logeando Pila: "+ex.getMessage());
		}
	}
	private void loguearSql(String metodo, String sql, Vector params){
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0){
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
		
	}

  public DTOSalida obtenerTiposMovimientosCaja(DTOBelcorp dtoe) throws MareException {
    /** DAOServicioBEL.obtenerTiposMovimientosCaja(dto : DTOBelcorp) : DTOSalida *
    Entrada: 
    - dto : DTOBelcorp (Se pone este dto para prevenir futuros cambios en cuanto a la internacionalización de la descripción del tipo de movimiento de caja) 
    Proceso: 
    -> Hacer consulta JDBC sobre la tabla BEL_TIPO_MOVIM_CAJA 
    -> Obtener los campos: OID_TIPO_MOVI_CAJA y COD_TIPO_MOVI_CAJA +" "+ DES_TIPO_MOVI_CAJA 
    -> Devolver RecordSet obtenido encapsulado en un DTOSalida
    */
    
      UtilidadesLog.info("DAOServicioBel.obtenerTiposMovimientosCaja(DTOBelcorp dtoe):Entrada");
      BelcorpService belcorpService;
      RecordSet rs;
      DTOSalida dtos = new DTOSalida();

      try {

          belcorpService = BelcorpService.getInstance();
          StringBuffer query = new StringBuffer();

          query.append(" SELECT tmc.OID_TIPO_MOVI_CAJA, tmc.COD_CAJA, tmc.DES_TIPO_MOVI_CAJA ");
          query.append(" FROM BEL_TIPO_MOVIM_CAJA tmc ");

          rs = belcorpService.dbService.executeStaticQuery(query.toString());
          
      }catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (Exception exception) {
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      dtos.setResultado(rs);
      UtilidadesLog.info("DAOServicioBel.obtenerTiposMovimientosCaja(DTOBelcorp dtoe):Salida");
      return dtos;    
  }

  public DTOSalida obtenerTiposMovimientosCajaManuales(DTOBelcorp dtoe) throws MareException {
    /** DAOServicioBEL.obtenerTiposMovimientosCajaManuales(dto : DTOBelcorp) : DTOSalida  
    Entrada: 
    - dto : DTOBelcorp (Se pone este dto para prevenir futuros cambios en cuanto a la internacionalización de la descripción del tipo de movimiento de caja) 
    Proceso: 
    -> Hacer consulta JDBC sobre la tabla BEL_TIPO_MOVIM_CAJA 
    -> Obtener los campos: OID_TIPO_MOVI_CAJA y COD_TIPO_MOVI_CAJA +" "+ DES_TIPO_MOVI_CAJA 
    -> IND_AUTO = 'M' 
    -> Devolver RecordSet obtenido encapsulado en un DTOSalida
    */
    
      UtilidadesLog.info("DAOServicioBel.obtenerTiposMovimientosCajaManuales(DTOBelcorp dtoe):Entrada");
      BelcorpService belcorpService;
      RecordSet rs;
      DTOSalida dtos = new DTOSalida();

      try {

          belcorpService = BelcorpService.getInstance();
          StringBuffer query = new StringBuffer();

          query.append(" SELECT tmc.OID_TIPO_MOVI_CAJA, tmc.COD_CAJA, tmc.DES_TIPO_MOVI_CAJA ");
          query.append(" FROM BEL_TIPO_MOVIM_CAJA tmc ");
          query.append(" WHERE tmc.IND_AUTO = 'M' ");

          rs = belcorpService.dbService.executeStaticQuery(query.toString());
          
      }catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (Exception exception) {
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      dtos.setResultado(rs);
      UtilidadesLog.info("DAOServicioBel.obtenerTiposMovimientosCajaManuales(DTOBelcorp dtoe):Salida");
      return dtos;
  }
  
 	/** 14/01/2005
     * Método para obtener el signo de cada Tipo de Movimiento
     * @param DTOBelcorp
     * @return Recordset en DtoSalida
     * @exception MareException 
     */	
  
  public DTOSalida obtenerSignoTiposMovimientosCajaManuales(DTOBelcorp dtoe) throws MareException {
      UtilidadesLog.info("DAOServicioBel.obtenerSignoTiposMovimientosCajaManuales(DTOBelcorp dtoe):Entrada");
      BelcorpService belcorpService;
      RecordSet rs;
      DTOSalida dtos = new DTOSalida();

      try {

          belcorpService = BelcorpService.getInstance();
          StringBuffer query = new StringBuffer();

          query.append(" SELECT tmc.OID_TIPO_MOVI_CAJA, tmc.VAL_SIGN ");
          query.append(" FROM BEL_TIPO_MOVIM_CAJA tmc ");
          query.append(" WHERE tmc.IND_AUTO = 'M' ");

          rs = belcorpService.dbService.executeStaticQuery(query.toString());
          
      }catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (Exception exception) {
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      dtos.setResultado(rs);
      UtilidadesLog.info("DAOServicioBel.obtenerSignoTiposMovimientosCajaManuales(DTOBelcorp dtoe):Salida");
      return dtos;
  }



    /**
     * 
     */
  public DTOSalida obtenerMediosPagoBelcenterCierre(DTOOID dto) throws MareException {
    /** DAOServicioBEL.obtenerMediosPagoBelcenterCierre(dto : DTOOID) : DTOSalida  
    Entrada: 
    - dto : DTOOID (oid de subacceso) 
    Proceso: 
    -> Hacer consulta JDBC sobre la tabla BEL_MEDIO_PAGO_BELCE 
    -> Cruzar tabla BEL_MEDIO_PAGO_BELCE con tabla BEL_MEDIO_PAGO 
    -> BEL_MEDIO_PAGO.TMEP_OID_TIPO_MEDI_PAGO <> ConstantesBEL.TIPO_MP_NOTA_CREDITO y ConstantesBEL.TIPO_MP_VENTA_CCC 
    -> BEL_MEDIO_PAGO_BELCE.SBAC_OID_SBAC = dto.oid 
    -> BEL_MEDIO_PAGO.PAIS_OID_PAIS = dto.pais 
    -> Obtener los campos BEL_MEDIO_PAGO_BELCE.OID_MEDI_PAGO_BELC, BEL_TIPO_MEDIO_PAGO.OID_TIPO_MEDI_PAGO y BEL_MEDIO_PAGO.COD_MEDI_PAGO + descripción internacionalizada del medio de pago. 
    -> Devolver RecordSet obtenido en un objeto DTOSalida.
    */
      UtilidadesLog.info("DAOServicioBel.obtenerMediosPagoBelcenterCierre(DTOOID dto):Entrada");
      BelcorpService belcorpService;
      RecordSet rs;
      DTOSalida dtos = new DTOSalida();

      try {

          belcorpService = BelcorpService.getInstance();
          StringBuffer query = new StringBuffer();
        

           query.append(" SELECT mpb.OID_MEDI_PAGO_BELC, i18n.VAL_I18N DES_MEDI_PAGO, mp.TMEP_OID_TIPO_MEDI_PAGO, mp.COD_MEDI_PAGO ");
           query.append(" FROM BEL_MEDIO_PAGO_BELCE mpb, BEL_MEDIO_PAGO mp, GEN_I18N_SICC i18n  ");
           query.append(" WHERE mpb.MPAB_OID_MEDI_PAGO = mp.OID_MEDI_PAGO  ");
           query.append(" AND mp.TMEP_OID_TIPO_MEDI_PAGO != " + ConstantesBEL.TIPO_MP_NOTA_CREDITO + " ");
           query.append(" AND mp.TMEP_OID_TIPO_MEDI_PAGO != " + ConstantesBEL.TIPO_MP_VENTA_CCC + " ");
           query.append(" AND mpb.SBAC_OID_SBAC = " + dto.getOid() + " ");
           query.append(" AND mp.PAIS_OID_PAIS = " + dto.getOidPais() + " ");
 
           query.append(" AND i18n.ATTR_ENTI = 'BEL_MEDIO_PAGO' ");
           query.append(" AND i18n.ATTR_NUM_ATRI = 1 ");//porque solo hay un internacionalizable en la tabla
           query.append(" AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
           query.append(" AND i18n.VAL_OID = mp.OID_MEDI_PAGO ");

          rs = belcorpService.dbService.executeStaticQuery(query.toString());
          
      }catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (Exception exception) {
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      dtos.setResultado(rs);
      UtilidadesLog.info("DAOServicioBel.obtenerMediosPagoBelcenterCierre(DTOOID dto):Salida");
      return dtos;
  }


    /**
     * Obtiene los medios de pago segun el oidSubacceso. 
     * @param DTOOID con oid de subacceso
     * @return DTOSalida
     * @exception MareException 
     * @author gdmarzi
     */
    public DTOSalida obtenerMediosPagoBelcenter(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOServicioBel.obtenerMediosPagoBelcenter(DTOOID dto):Entrada");
        BelcorpService belcorpService;
        RecordSet rsMediosPagoBelcenter;
        String codigoError;
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }
        StringBuffer stringBuffer = new StringBuffer();
        // -> Obtener los campos BEL_MEDIO_PAGO_BELCE.OID_MEDI_PAGO_BELC y BEL_MEDIO_PAGO.COD_MEDI_PAGO + descripción internacionalizada del medio de pago. 
        stringBuffer.append(" SELECT BEL_MEDIO_PAGO_BELCE.OID_MEDI_PAGO_BELC, ");
        stringBuffer.append("   BEL_MEDIO_PAGO.COD_MEDI_PAGO || ' ' || V_GEN_I18N_SICC.VAL_I18N ");        
        // -> Cruzar tabla BEL_MEDIO_PAGO_BELCE con tabla BEL_MEDIO_PAGO 
        stringBuffer.append(" FROM  BEL_MEDIO_PAGO_BELCE, BEL_MEDIO_PAGO, V_GEN_I18N_SICC ");
        stringBuffer.append(" WHERE BEL_MEDIO_PAGO.OID_MEDI_PAGO = BEL_MEDIO_PAGO_BELCE.MPAB_OID_MEDI_PAGO ");
        // -> BEL_MEDIO_PAGO_BELCE.SBAC_OID_SBAC = dto.oid 
        UtilidadesLog.info("BEL_MEDIO_PAGO_BELCE.SBAC_OID_SBAC ****** dto.getOid() *****  " + dto.getOid());
        stringBuffer.append("   AND BEL_MEDIO_PAGO_BELCE.SBAC_OID_SBAC = " + dto.getOid());
        // -> BEL_MEDIO_PAGO.PAIS_OID_PAIS = dto.pais 
        UtilidadesLog.info("BEL_MEDIO_PAGO.PAIS_OID_PAIS ***** dto.getOidPais()  *****  " + dto.getOidPais());
        stringBuffer.append("   AND BEL_MEDIO_PAGO.PAIS_OID_PAIS = " + dto.getOidPais());
        stringBuffer.append("   AND V_GEN_I18N_SICC.ATTR_ENTI = 'BEL_MEDIO_PAGO' ");
        UtilidadesLog.info("V_GEN_I18N_SICC.IDIO_OID_IDIO ***** dto.getOidIdioma()  *****  " + dto.getOidIdioma());
        stringBuffer.append("   AND V_GEN_I18N_SICC.IDIO_OID_IDIO = " + dto.getOidIdioma());        
        stringBuffer.append("   AND V_GEN_I18N_SICC.VAL_OID = BEL_MEDIO_PAGO.OID_MEDI_PAGO ");        
                  

        //ejecutamos la consulta
        try {
            rsMediosPagoBelcenter = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
        } catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }

        // -> Devolver RecordSet obtenido en un objeto DTOSalida.
        UtilidadesLog.info("DAOServicioBel.obtenerMediosPagoBelcenter(DTOOID dto):Salida");
        return new DTOSalida(rsMediosPagoBelcenter);
    }


    /**
     * Calcula el saldo movimiento caja detalle.
     * Se toman como parametros opcionales el oidCaja, el tipoMedioPago y una fecha.
     * @param DTOMovimientoCajaDetalle
     * @return BigDecimal
     * @exception MareException 
     * @author gdmarzi
     */
    public BigDecimal calcularSaldoMovimientosCajaDetalle(DTOMovimientoCajaDetalle dto) throws MareException {
        UtilidadesLog.info("DAOServicioBel.calcularSaldoMovimientosCajaDetalle(DTOMovimientoCajaDetalle dto):Entrada");
        BelcorpService belcorpService;
        RecordSet rsSaldoMovimientos;
        String codigoError;
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }
        StringBuffer stringBuffer = new StringBuffer();
        // -> Obtener la sumatoria del campo BEL_MOVIM_CAJA_DETAL.IMP_MOVI 
        stringBuffer.append(" SELECT ");
        stringBuffer.append("   SUM (BEL_MOVIM_CAJA_DETAL.IMP_MOVI) AS saldoMovimientos ");
        // -> Hacer consulta JDBC sobre la tabla BEL_MOVIM_CAJA_DETAL 
        stringBuffer.append(" FROM ");
        stringBuffer.append("   BEL_MOVIM_CAJA_DETAL, BEL_MOVIM_CAJA_CABEC, BEL_CAJA, ");
        stringBuffer.append("   BEL_MEDIO_PAGO_BELCE, BEL_MEDIO_PAGO, BEL_TIPO_MEDIO_PAGO ");
        stringBuffer.append(" WHERE ");
        // -> Cruzar la tabla BEL_MOVIM_CAJA_DETAL con la tabla BEL_MOVIM_CAJA_CABEC 
        // -> Cruzar la tabla BEL_MOVIM_CAJA_CABEC con la tabla BEL_CAJA 
        stringBuffer.append("   BEL_MOVIM_CAJA_DETAL.MCAC_OID_CABE =  BEL_MOVIM_CAJA_CABEC.OID_CABE ");
        stringBuffer.append("   AND BEL_MOVIM_CAJA_CABEC.CAJA_OID_CAJA = BEL_CAJA.OID_CAJA ");
        // -> BEL_CAJA.OID_CAJA = dto.caja (si es null no se filtrará por este campo) 
        if (dto.getCaja() != null) {
            stringBuffer.append("   AND BEL_CAJA.OID_CAJA = " + dto.getCaja());
        }
        // -> Cruzar la tabla BEL_MOVIM_CAJA_DETAL con la tabla BEL_MEDIO_PAGO_BELCE 
        // -> Cruzar la tabla BEL_MEDIO_PAGO_BELCE con la tabla BEL_MEDIO_PAGO 
        // -> Cruzar la tabla BEL_MEDIO_PAGO con la tabla BEL_TIPO_MEDIO_PAGO 
        stringBuffer.append("   AND BEL_MOVIM_CAJA_DETAL.MPBC_OID_MEDI_PAGO_BELC = BEL_MEDIO_PAGO_BELCE.OID_MEDI_PAGO_BELC ");
        stringBuffer.append("   AND BEL_MEDIO_PAGO_BELCE.MPAB_OID_MEDI_PAGO = BEL_MEDIO_PAGO.OID_MEDI_PAGO ");
        stringBuffer.append("   AND BEL_MEDIO_PAGO.TMEP_OID_TIPO_MEDI_PAGO = BEL_TIPO_MEDIO_PAGO.OID_TIPO_MEDI_PAGO ");
        // -> BEL_TIPO_MEDIO_PAGO.OID_TIPO_MEDI_PAGO = dto.tipoMedioPago (si es null no se filtrará por este campo) 
        if (dto.getTipoMedioPago() != null) {
            stringBuffer.append("   AND  BEL_TIPO_MEDIO_PAGO.OID_TIPO_MEDI_PAGO =  " + dto.getTipoMedioPago());
        }
        // -> BEL_MOVIM_CAJA_DETAL.FEC_MOVI = dto.fecha (si es null no se filtrará por este campo) 
        // La fecha se igualará sólo a nivel de día mes y año sin importar el instante 
        if (dto.getFecha() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSdf = sdf.format(dto.getFecha());
            stringBuffer.append("   AND TRUNC(BEL_MOVIM_CAJA_DETAL.FEC_MOVI) = TO_DATE('" + fechaSdf+ "','YYYY-MM-DD') ");
        }
        // -> Obtener el registro único del RecordSet obtenido
        try {
            rsSaldoMovimientos = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
        } catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }
        BigDecimal saldoMovimientos = (BigDecimal)rsSaldoMovimientos.getValueAt(0,"SALDOMOVIMIENTOS");

        // -> Devolver la sumatoria calculada en la select encapsulada en un objeto BigDecimal 
        UtilidadesLog.debug("************ el saldo de los movimientos es " + saldoMovimientos);
        UtilidadesLog.info("DAOServicioBel.calcularSaldoMovimientosCajaDetalle(DTOMovimientoCajaDetalle dto):Salida");
        return saldoMovimientos;
    }

    /**
     * 22/11/2004
     * Obtiene los subaccesos parametrizados en BEL_PARAM_BELCE
     * Se toman como parametros el oid del acceso, el pais y el idioma
     * @param DTOOID
     * @return DTOSalida
     * @exception MareException 
     * @author mdolce
     */

    public DTOSalida obtieneSubaccesosPRMBelcenter(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOServicioBel.obtieneSubaccesosPRMBelcenter(DTOOID dto):Entrada");
        BelcorpService belcorpService;
        RecordSet rsSubac;
        String codigoError;
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }
            StringBuffer query = new StringBuffer();
        query.append(" select a.SBAC_OID_SBAC,i1.VAL_I18N as Descripcion ");
        query.append(" from  bel_param_belce a, seg_subac b, V_GEN_I18N_SICC i1 ");
        query.append(" where a.SBAC_OID_SBAC = b.OID_SBAC ");
        query.append(" and b.ACCE_OID_ACCE = " + dto.getOid());
        query.append(" and   a.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND   i1.ATTR_ENTI = 'SEG_SUBAC' "); 
        query.append(" AND   i1.ATTR_NUM_ATRI = 1 "); 
        query.append(" AND   i1.IDIO_OID_IDIO = " + dto.getOidIdioma());  
        query.append(" and   i1.VAL_OID = b.OID_SBAC ");
        query.append(" order by Descripcion ");  
      
        

        //ejecutamos la consulta
        try {
            rsSubac = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
        }

        // -> Devolver RecordSet obtenido en un objeto DTOSalida.
        UtilidadesLog.info("DAOServicioBel.obtieneSubaccesosPRMBelcenter(DTOOID dto):Salida");
        return new DTOSalida(rsSubac);

    }

  public RecordSet obtenerEstimadosDeVentaBelcenter(Long periodo, Long subacceso) throws MareException{
    
    UtilidadesLog.info("DAOServicioBel.obtenerEstimadosDeVentaBelcenter(Long periodo, Long subacceso):Entrada");
    BelcorpService belcorpService;
    String codigoError = "";
    RecordSet resultado;

    StringBuffer query = new StringBuffer();
    Vector parametros = new Vector();
    
    query.append(" SELECT OID_ESTI FROM BEL_ESTIM_VENTA_BELCE ");
    query.append(" WHERE BEL_ESTIM_VENTA_BELCE.PERD_OID_PERI = ? ");
    parametros.add(periodo);
    query.append("AND BEL_ESTIM_VENTA_BELCE.SBAC_OID_SBAC = ?");
    parametros.add(subacceso);
    
    belcorpService = UtilidadesEJB.getBelcorpService();
    try{
        resultado = belcorpService.dbService.executePreparedQuery(query.toString(),
        parametros);
      
    }catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
    }
        
    UtilidadesLog.info("DAOServicioBel.obtenerEstimadosDeVentaBelcenter(Long periodo, Long subacceso):Salida");
    return resultado;
  }

  public DTOSalida obtenerAgrupacionStockCabecera(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("DAOServicioBel.obtenerAgrupacionStockCabecera(DTOBelcorp dto):Entrada");
    
    BelcorpService belcorpService;
    RecordSet resultado;
    String codigoError = "";
    
    StringBuffer query = new StringBuffer();
    Vector parametros = new Vector();
    
    query.append(" SELECT OID_AGRU_STOC_CABE, IND_DEFE, ");
    query.append("(SELECT VAL_I18N FROM V_GEN_I18N_SICC ");
    query.append(" WHERE ATTR_ENTI = ? ");
    parametros.add("BEL_AGRUP_STOCK_CABEC");
    query.append(" AND IDIO_OID_IDIO = ? ");
    parametros.add(dto.getOidIdioma());
    query.append(" AND VAL_OID = A.OID_AGRU_STOC_CABE ) AS DESCRIPCION ");
    query.append(" FROM BEL_AGRUP_STOCK_CABEC A ");
    query.append(" WHERE A.PAIS_OID_PAIS = ? ");
    parametros.add(dto.getOidPais());
    
    belcorpService = UtilidadesEJB.getBelcorpService();
    try{
        resultado = belcorpService.dbService.executePreparedQuery(query.toString(),
        parametros);
      
    }catch (Exception exception) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(codigoError));
    }
    DTOSalida salida = new DTOSalida(resultado);
    
    UtilidadesLog.info("DAOServicioBel.obtenerAgrupacionStockCabecera(DTOBelcorp dto):Salida");
    return salida;
  }
  
  public DTOSalida buscarStockProducto(DTOBuscarStockProducto dto) throws MareException {
    //incidencia 12317
    UtilidadesLog.info("DAOServicioBel.buscarStockProducto(DTOBuscarStockProducto dto):Entrada");
    
    StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

		sql.append(" SELECT * FROM ( SELECT  ");
    sql.append(" TO_NUMBER(B.oid_stoc || R.oid_deta_ofer || K.oid_gest_stoc) as oidPaginacion, ");
    sql.append(" F.cod_sap as codProducto, ");
    sql.append(" G.val_i18n as descSAP, ");
    sql.append(" J.val_i18n as descTipoPeriodo, ");
    sql.append(" H.val_nomb_peri as descPeriodo, ");
    sql.append(" L.des_regi as descRegion,  ");
    sql.append(" M.des_zona as descZona, ");
    sql.append(" R.val_codi_vent as codVenta, ");
    sql.append(" B.val_sald as saldo,  ");
    sql.append(" N.val_i18n as descTipoCliente, ");
    sql.append(" O.val_i18n as descSubtipoCliente, ");
    sql.append(" P.val_i18n as descTipoClasificacion,  ");
    sql.append(" Q.val_i18n as descClasificacion, ");
    sql.append(" K.val_limi_ctrl_vent as limiteVenta, ");
    sql.append(" K.ind_ctrl_liqu as controlLiquidacion, ");
    sql.append(" DECODE(K.val_porc, NULL, TO_CHAR(K.val_unid), TO_CHAR(K.val_porc) || '%') as controlStock  ");
    sql.append(" FROM bel_estad_merca A, ");
    sql.append(" bel_stock B, ");
    sql.append(" mae_produ F, ");
    sql.append(" v_gen_i18n_sicc G, ");
    sql.append(" cra_perio H, ");
    sql.append(" seg_perio_corpo I, ");
    sql.append(" v_gen_i18n_sicc J, ");
    sql.append(" ped_gesti_stock K, ");
    sql.append(" zon_regio L, ");
    sql.append(" zon_zona M,  ");
    sql.append(" v_gen_i18n_sicc N, ");
    sql.append(" v_gen_i18n_sicc O, ");
    sql.append(" v_gen_i18n_sicc P,  ");
    sql.append(" v_gen_i18n_sicc Q,  ");
    sql.append(" (SELECT C.prod_oid_prod as oid_prod, ");
    sql.append(" C.val_codi_vent as val_codi_vent, ");
    sql.append(" C.oid_deta_ofer as oid_deta_ofer, ");
    sql.append(" E.perd_oid_peri as oid_peri, ");
    sql.append(" D.acce_oid_acce as oid_acce, ");
    sql.append(" D.sbac_oid_sbac as oid_sbac ");
    sql.append(" FROM pre_ofert_detal C, ");
    sql.append(" pre_ofert D, ");
    sql.append(" pre_matri_factu_cabec E ");
    sql.append(" WHERE D.oid_ofer = C.ofer_oid_ofer AND  ");
    sql.append(" E.oid_cabe = D.mfca_oid_cabe) R  ");
    sql.append(" WHERE TO_NUMBER(B.oid_stoc || R.oid_deta_ofer || K.oid_gest_stoc) > ? AND ");
    parametros.add(dto.getIndicadorSituacion());
    sql.append(" A.pais_oid_pais = ? AND ");
    parametros.add(dto.getOidPais());
    sql.append(" A.cod_esta = ? AND ");
    parametros.add(ConstantesBEL.COD_EST_LIBRE_DISP);
    sql.append(" B.esme_oid_esta_merc = A.oid_esta_merc AND ");
    sql.append(" R.oid_prod = B.prod_oid_prod AND ");
    sql.append(" F.oid_prod = B.prod_oid_prod AND ");
    sql.append(" G.attr_enti = 'MAE_PRODU' AND ");
    sql.append(" G.attr_num_atri = 1 AND  ");
    sql.append(" G.idio_oid_idio = ? AND ");
    parametros.add(dto.getOidIdioma());
    sql.append(" G.val_oid = F.oid_prod AND  ");
    sql.append(" H.oid_peri = R.oid_peri AND ");
    sql.append(" H.pais_oid_pais = ? AND ");
    parametros.add(dto.getOidPais());
    sql.append(" I.oid_peri = H.peri_oid_peri AND ");
    sql.append(" J.attr_enti = 'SEG_TIPO_PERIO' AND ");
    sql.append(" J.attr_num_atri = 1 AND ");
    sql.append(" J.idio_oid_idio = ? AND ");
    parametros.add(dto.getOidIdioma());
    sql.append(" J.val_oid = I.tipe_oid_tipo_peri AND  ");
    sql.append(" K.perd_oid_peri (+) = R.oid_peri AND ");
    sql.append(" K.ofde_oid_deta_ofer (+) = R.oid_deta_ofer AND ");
    sql.append(" L.oid_regi (+) = K.zorg_oid_regi AND ");
    sql.append(" M.oid_zona (+) = K.zzon_oid_zona AND ");
    sql.append(" N.attr_enti (+) = 'MAE_TIPO_CLIEN' AND ");
    sql.append(" N.attr_num_atri (+) = 1 AND ");
    sql.append(" N.idio_oid_idio (+) = ? AND ");
    parametros.add(dto.getOidIdioma());
    sql.append(" N.val_oid (+) = K.ticl_oid_tipo_clie AND ");
    sql.append(" O.attr_enti (+) = 'MAE_SUBTI_CLIEN' AND ");
    sql.append(" O.attr_num_atri (+) = 1 AND ");
    sql.append(" O.idio_oid_idio (+) = ? AND ");
    parametros.add(dto.getOidIdioma());
    sql.append(" O.val_oid (+) = K.sbti_oid_subt_clie AND  ");
    sql.append(" P.attr_enti (+) = 'MAE_TIPO_CLASI_CLIEN' AND ");
    sql.append(" P.attr_num_atri (+) = 1 AND ");
    sql.append(" P.idio_oid_idio (+) = ? AND  ");
    parametros.add(dto.getOidIdioma());
    sql.append(" P.val_oid (+) = K.tccl_oid_tipo_clas AND ");
    sql.append(" Q.attr_enti (+) = 'MAE_CLASI' AND  ");
    sql.append(" Q.attr_num_atri (+) = 1 AND ");
    sql.append(" Q.idio_oid_idio (+) = ? AND ");
    parametros.add(dto.getOidIdioma());
    sql.append(" Q.val_oid (+) = K.clas_oid_clas ");
    
    if(dto.getOidAlmacen() != null) {
      sql.append(" AND B.almc_oid_alma = ?  ");
      parametros.add(dto.getOidAlmacen());
    }
    if (dto.getCodVenta() != null) {
      sql.append(" AND R.val_codi_vent LIKE ? ");
      parametros.add(dto.getCodVenta());
    }
    if (dto.getOidAcceso() != null) {
      sql.append(" AND R.oid_acce = ? ");
      parametros.add(dto.getOidAcceso());
    }
    if (dto.getOidSubacceso() != null) {
      sql.append(" AND R.oid_sbac = ? ");
      parametros.add(dto.getOidSubacceso());
    }
    if (dto.getOidPeriodo() != null ) {
      sql.append(" AND R.oid_peri = ? ");
      parametros.add(dto.getOidPeriodo());
    }
    if (dto.getCodProducto() != null) {
      sql.append(" AND F.cod_sap LIKE ? ");
      parametros.add(dto.getCodProducto());
    }
    if (dto.getDescProducto() != null) {
      sql.append(" AND G.val_i18n LIKE ? ");
      parametros.add(dto.getDescProducto());
    }
    if (dto.getOidMarca() != null) {
      sql.append(" AND H.marc_oid_marc = ? ");
      parametros.add(dto.getOidMarca());
    }
    if (dto.getOidCanal() != null) {
      sql.append(" AND H.cana_oid_cana = ?  ");
      parametros.add(dto.getOidCanal());
    }
    if (dto.getOidRegion() != null) {
      sql.append(" AND K.zorg_oid_regi = ?  ");
      parametros.add(dto.getOidRegion());
    }
    if (dto.getOidZona() != null) {
      sql.append(" AND K.zzon_oid_zona = ? ");
      parametros.add(dto.getOidZona());
    }
    sql.append(" ORDER BY TO_NUMBER(B.oid_stoc || R.oid_deta_ofer || K.oid_gest_stoc) ) ");
    sql.append(" WHERE ROWNUM <= ? ");
    parametros.add(dto.getTamanioPagina());
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(sql.toString(),parametros);
		} catch (Exception e) {
		    codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        this.logSql("DAOServicioBel.buscarStockProducto. SQL: ",sql.toString(), parametros);
			  UtilidadesLog.error("DAOServicioBel.buscarStockProducto: Exception",e);
		    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		if (rs.esVacio()){
			UtilidadesLog.info("****DAOServicioBel.buscarStockProducto: No hay datos ");
			throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
		DTOSalida dtoS = new DTOSalida();
		dtoS.setResultado(rs);
       
    UtilidadesLog.info("DAOServicioBel.buscarStockProducto(DTOBuscarStockProducto dto):Salida");
    return dtoS;
  }
  
  private void logSql(String metodo, String sql, Vector params){
		UtilidadesLog.info(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.info(metodo + sParams);
		}
  }
  
// vbongiov -- 29/10/2008
  public DTOOID obtenerCanalVD(DTOString dtoe) throws MareException  {
    UtilidadesLog.info("DAOServicioBel.obtenerCanalVD(DTOString dtoe): Entrada");
    try {
        BelcorpService belcorpServ = BelcorpService.getInstance();
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();

        query.append(" select can.OID_CANA ");
        query.append(" from SEG_CANAL can ");
        query.append(" where can.COD_CANA = '" + dtoe.getCadena() + "' ");
        
        rs = belcorpServ.dbService.executeStaticQuery(query.toString());
        
        DTOOID dtoOID = new DTOOID();
        
        dtoOID.setOid(new Long(((BigDecimal)rs.getValueAt(0,"OID_CANA")).longValue()));

        UtilidadesLog.info("DAOServicioBel.obtenerCanalVD(DTOString dtoe): Salida");
        return dtoOID;
        
    } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
        UtilidadesLog.error(serviceNotFoundException);
        throw new MareException(serviceNotFoundException
                                , UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    } catch (Exception exception) {
        UtilidadesLog.error(exception);
        throw new MareException(exception
                                , UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
  }

}