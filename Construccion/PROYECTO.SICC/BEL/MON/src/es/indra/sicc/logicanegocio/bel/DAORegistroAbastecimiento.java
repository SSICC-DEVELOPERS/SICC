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


import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOERecuperarRegistroAbastecimiento;
import es.indra.sicc.dtos.bel.DTOERellenarRegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTOEObtenerRegistroAbastecimientoDetalle;
import es.indra.sicc.dtos.bel.DTOEBuscarHojaDemandaDetalle;
import es.indra.sicc.dtos.bel.DTOEBuscarHDDetalleFlag;
import es.indra.sicc.dtos.bel.DTORegistroInterface;
import es.indra.sicc.util.DTOOID;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import java.math.BigDecimal;
import java.util.Vector;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DAORegistroAbastecimiento 
{
   
   private String usuario;
   
   public DAORegistroAbastecimiento(String usuario) { 
      this.usuario = usuario;
   }
   
	private void logError(String mensaje, Throwable e) {
		UtilidadesLog.error("*** Error Metodo "+ mensaje + ": " + e.getMessage());
		UtilidadesLog.error(e);
	}

	private void logStackTrace(Throwable e) {
		try {						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			
			//UtilidadesLog.error(pila.toString());
      UtilidadesLog.error(e);
		} catch(Exception ex) {
			UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
		}			
	}
   
	private void logSql(String metodo, String sql, Vector params) {
		UtilidadesLog.debug(metodo + sql);
		if (params != null && params.size() > 0) {
			String sParams = "";
			for (int i = 0;  i < params.size(); i++){
				sParams += "param " + (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
	}
   

   public DTOSalida rellenarRegistroAbastecimientoDetalle(DTOERellenarRegistroAbastecimientoDetalle dtoe) 
       throws MareException
   {
      UtilidadesLog.info("DAORegistroAbastecimienot.rellenarRegistroAbastecimientoDetalle(DTOERellenarRegistroAbastecimientoDetalle dtoe):Entrada");
      //UtilidadesLog.debug("*** M\351todo DAORegistroAbastecimiento.rellenarRegistroAbastecimientoDetalle: Entrada ***");

  		StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      
      /*-> Hacer consulta JDBC sobre la tabla BEL_CONTR_ALMAC con las siguientes condiciones: 
      -> BEL_CONTR_ALMAC.SBAC_OID_SBAC = dto.subacceso 
      -> BEL_CONTR_ALMAC.ALMA_OID_ALMA = dto.almacen 
      -> BEL_CONTR_ALMAC.IND_ACTI = ConstantesBEL.CONTROL_ALMACEN_ACTIVADO
      -> Cruzar tabla BEL_CONTR_ALMAC con tabla MAE_PRODU
      -> Obtener los campos: 
      -> NULL (oid de Registro Abastecimiento Detalle) 
      -> MAE_PRODU.OID_PROD (oid de Producto) 
      -> MAE_PRODU.COD_SAP (Código de Producto) 
      -> MAE_PRODU.DES_CORT (Descripción de Producto) 
      -> '' AS SALDO_ACTUAL (Columna vacía para rellenar en el método llamante) 
      -> BEL_CONTR_ALMAC.VAL_STOC_MINI (Stock mínimo) 
      -> BEL_CONTR_ALMAC.VAL_STOC_MAXI (Stock máximo) 
      -> '' AS UNIDADES_REPOSICION (Columna vacía para rellenar en el método llamante) */

      consulta.append("SELECT null AS OID, mp.COD_SAP, mp.DES_CORT, ");
      consulta.append("'' as SALDO_ACTUAL, ca.VAL_STOC_MINI, ca.VAL_STOC_MAXI, ");
      consulta.append("'' as UNIDADES_REPOSICION, mp.OID_PROD, '' as UNIDADES_CONFIRMADAS ");
      
      consulta.append("FROM BEL_CONTR_ALMAC ca, MAE_PRODU mp ");
      
      consulta.append("WHERE ca.prod_oid_prod = mp.oid_prod ");
      consulta.append("AND ca.sbac_oid_sbac = ? ");
      parametros.add(dtoe.getSubacceso());
      consulta.append("AND ca.almc_oid_alma = ? ");
      parametros.add(dtoe.getAlmacen());
      consulta.append("AND ca.ind_acti = ?");
      parametros.add(ConstantesBEL.CONTROL_ALMACEN_ACTIVADO.toString());
      
		  UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		  // se ejecuta la consulta
		  BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      
      try {
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		  } catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.rellenarRegistroAbastecimientoDetalle: Exception", e);
         logSql("DAORegistroAbastecimiento.rellenarRegistroAbastecimientoDetalle. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      DTOSalida dtoSalida = null;
      
      if (! resultado.esVacio()) {
         // Devolver RecordSet obtenido encapsulado en un DTOSalida 
         dtoSalida = new DTOSalida(resultado);      
      } else {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAORegistroAbastecimiento.rellenarRegistroAbastecimientoDetalle: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }
      
      UtilidadesLog.info("DAORegistroAbastecimienot.rellenarRegistroAbastecimientoDetalle(DTOERellenarRegistroAbastecimientoDetalle dtoe):Salida");
      return dtoSalida;
   }


   public DTOSalida recuperarRegistroAbastecimiento(DTOERecuperarRegistroAbastecimiento dtoe) 
       throws MareException
   {
      UtilidadesLog.info("DAORegistroAbastecimienot.recuperarRegistroAbastecimiento(DTOERecuperarRegistroAbastecimiento dtoe):Entrada");

  		StringBuffer consulta = new StringBuffer();
  		Vector parametros = new Vector();
      
      /* Proceso: 
      -> Hacer consulta JDBC sobre la tabla BEL_REGIS_ABAST_CABEC con las siguientes condiciones: 
      -> BEL_REGIS_ABAST_CABEC.PAIS_OID_PAIS = dto.pais 
      -> BEL_REGIS_ABAST_CABEC.SBAC_OID_SBAC = dto.subacceso 
      -> BEL_REGIS_ABAST_CABEC.DHDE_OID_ESTA_HOJA_DEMA = dto.estado 
      -> Obtener los siguientes campos: 
      - OID_REGI_ABAS_CABE (oid de Registro de Abastecimiento Cabecera, columna oculta) 
      - NUM_SOLI (Numero de solicitud) 
      - FEC_CREA (Fecha de creación) 
      
      Esta consulta es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
      1.- oid del registro encontrado > dto.indicadorSituacion 
      2.- ROWNUM <= dto.tamañoPagina 
      
      -> Devolver RecordSet obtenido encapsulado en un DTOSalida
      */

      consulta.append("SELECT T.OID_REGI_ABAS_CABE AS OID, T.NUM_SOLI, T.FEC_CREA ");
      
      consulta.append("FROM BEL_REGIS_ABAST_CABEC T ");
      
      consulta.append("WHERE T.PAIS_OID_PAIS = ? ");
      parametros.add(dtoe.getOidPais());
      consulta.append("AND T.SBAC_OID_SBAC = ? ");
      parametros.add(dtoe.getSubacceso());
      consulta.append("AND T.DHDE_OID_ESTA_HOJA_DEMA = ? ");
      parametros.add(dtoe.getEstado());
      
      UtilidadesLog.debug("***** Consulta: " + consulta.toString());

      // se ejecuta la consulta
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      
      String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dtoe);
      
      try {
         resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
		} catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.recuperarRegistroAbastecimiento: Exception", e);
         logSql("DAORegistroAbastecimiento.recuperarRegistroAbastecimiento. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      DTOSalida dtoSalida = null;
      
      if (! resultado.esVacio()) {
         // Devolver RecordSet obtenido encapsulado en un DTOSalida 
         dtoSalida = new DTOSalida(resultado);      
      } else {
         // GEN-0007 --> 0005                                                                                  
   			 UtilidadesLog.debug("****DAORegistroAbastecimiento.recuperarRegistroAbastecimiento: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }            
      
      UtilidadesLog.info("DAORegistroAbastecimienot.recuperarRegistroAbastecimiento(DTOERecuperarRegistroAbastecimiento dtoe):Salida");
      return dtoSalida;
   }
   
   
   public DTOSalida obtenerRegistroAbastecimientoDetalle(DTOEObtenerRegistroAbastecimientoDetalle dtoe) 
       throws MareException
   {
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerRegistroAbastecimientoDetalle(DTOEObtenerRegistroAbastecimientoDetalle dtoe):Entrada");
  		StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      
      /* Proceso: 
      -> Hacer consulta JDBC sobre la tabla BEL_REGIS_ABAST_DETAL con las siguientes condiciones: 
      -> BEL_REGIS_ABAST_DETAL.RABC_OID_REGI_ABAS_CABE = dto.oidRegistroAbastecimientoCabecera 
      -> Cruzar tabla BEL_REGIS_ABAST_DETAL con tabla MAE_PRODU 
      -> Obtener los siguientes campos: 
      - BEL_REGIS_ABAST_DETAL.OID_REGI_ABAS_DETA (oid de detalle de registro de abastecimiento) 
      - BEL_REGIS_ABAST_DETAL.PROD_OID_PROD (oid de producto) 
      - MAE_PRODU.COD_SAP (Código de Producto) 
      - MAE_PRODU.DES_CORT (Descripción de Producto) 
      - '' AS SALDO_ACTUAL (Columna vacía para rellenar en el método llamante) 
      - BEL_REGIS_ABAST_DETAL.NUM_STOC_MINI (Stock mínimo) 
      - BEL_REGIS_ABAST_DETAL.NUM_STOC_MAXI (Stock máximo) 
      - BEL_REGIS_ABAST_DETAL.NUM_UNID_ENVI (Unidades enviadas) 
      */

      consulta.append("SELECT R.OID_REGI_ABAS_DETA, P.COD_SAP, P.DES_CORT, ");
      consulta.append("'' AS SALDO_ACTUAL, R.NUM_STOC_MINI, R.NUM_STOC_MAXI, R.NUM_UNID_ENVI, R.PROD_OID_PROD, R.NUM_UNID_CONF ");
      
      consulta.append("FROM BEL_REGIS_ABAST_DETAL R, MAE_PRODU P ");
      
      consulta.append("WHERE R.PROD_OID_PROD = P.OID_PROD ");
      consulta.append("AND R.RABC_OID_REGI_ABAS_CABE = ?");
      parametros.add(dtoe.getOidRegistroAbastecimientoCabecera());

		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      
      try {
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.obtenerRegistroAbastecimientoDetalle: Exception", e);
         logSql("DAORegistroAbastecimiento.obtenerRegistroAbastecimientoDetalle. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      DTOSalida dtoSalida = null;
      
      if (! resultado.esVacio()) {
         // Devolver RecordSet obtenido encapsulado en un DTOSalida 
         dtoSalida = new DTOSalida(resultado);      
      } else {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAORegistroAbastecimiento.obtenerRegistroAbastecimientoDetalle: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }            
      
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerRegistroAbastecimientoDetalle(DTOEObtenerRegistroAbastecimientoDetalle dtoe):Salida");
      return dtoSalida;
   }   
   
   
   public DTOSalida obtenerHojaDemanda(DTOERecuperarRegistroAbastecimiento dtoe) 
      throws MareException 
   {
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerHojaDemanda(DTOERecuperarRegistroAbastecimiento dtoe) :Entrada");
      
  		StringBuffer consulta = new StringBuffer();
		  Vector parametros = new Vector();
      
      /* Proceso: 
      -> Hacer consulta JDBC sobre la tabla BEL_REGIS_ABAST_CABEC con las siguientes condiciones: 
      -> BEL_REGIS_ABAST_CABEC.PAIS_OID_PAIS = dto.pais 
      -> BEL_REGIS_ABAST_CABEC.SBAC_OID_SBAC = dto.subacceso 
      -> BEL_REGIS_ABAST_CABEC.DHDE_OID_ESTA_HOJA_DEMA = dto.estado 
      -> BEL_REGIS_ABAST_CABEC.IND_SAP = dto.indicadorSAP 
      -> Obtener los siguientes campos: 
      - OID_REGI_ABAS_CABE (oid de Registro de Abastecimiento Cabecera, columna oculta) 
      - NUM_SOLI (Numero de solicitud) 
      - FEC_CREA (Fecha de creación) 
      - FEC_ENVI (Fecha de envío) 
      - FEC_CONF (Fecha de confirmación) 
      - FEC_INGR (Fecha de ingreso) */
      consulta.append("SELECT T.OID_REGI_ABAS_CABE AS OID, T.NUM_SOLI, T.FEC_CREA, T.FEC_ENVI, ");
      consulta.append("T.FEC_CONF, T.FEC_INGR ");
      consulta.append("FROM BEL_REGIS_ABAST_CABEC T ");
      consulta.append("WHERE T.PAIS_OID_PAIS = ? ");
      parametros.add(dtoe.getOidPais());
      consulta.append("AND T.SBAC_OID_SBAC = ? ");
      parametros.add(dtoe.getSubacceso());
      consulta.append("AND T.DHDE_OID_ESTA_HOJA_DEMA = ? ");
      parametros.add(dtoe.getEstado());
      if (dtoe.getIndicadorSAP() != null) {
         consulta.append("AND T.IND_SAP = ?");
         if (dtoe.getIndicadorSAP().equals(Boolean.TRUE)){
            parametros.add(new Long(1));
         } else {
            parametros.add(new Long(0));
         }         
      }

  		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

    	// se ejecuta la consulta
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      
      /*Esta consulta es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
      1.- oid del registro encontrado > dto.indicadorSituacion 
      2.- ROWNUM <= dto.tamañoPagina */
      String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dtoe);
      
      try {
         resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
		} catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.obtenerHojaDemanda: Exception", e);
         logSql("DAORegistroAbastecimiento.obtenerHojaDemanda. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      DTOSalida dtoSalida = null;
      
      if (! resultado.esVacio()) {
         // Devolver RecordSet obtenido encapsulado en un DTOSalida 
         dtoSalida = new DTOSalida(resultado);      
      } else {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAORegistroAbastecimiento.obtenerHojaDemanda: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }

      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerHojaDemanda(DTOERecuperarRegistroAbastecimiento dtoe):Salida");
      return dtoSalida;
   }
   
   public DTOSalida buscarHojaDemadaDetalle(DTOEBuscarHojaDemandaDetalle dtoe)
       throws MareException 
   {
      UtilidadesLog.info("DAORegistroAbastecimiento.buscarHojaDemadaDetalle(DTOEBuscarHojaDemandaDetalle dtoe):Entrada");
      
  		StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      
      /* Proceso: 
      -> Hacer consulta JDBC sobre la tabla BEL_REGIS_ABAST_DETAL con las siguientes condiciones: 
      -> BEL_REGIS_ABAST_DETAL.RABC_OID_REGI_ABAS_CABE = dto.oidRegistroAbastecimientoCabecera 
      -> Cruzar tabla BEL_REGIS_ABAST_DETAL con tabla MAE_PRODU 
      -> Obtener los siguientes campos: 
      - BEL_REGIS_ABAST_DETAL.OID_REGI_ABAS_DETA (oid de detalle de registro de abastecimiento) 
      - BEL_REGIS_ABAST_DETAL.PROD_OID_PROD (oid de producto) 
      - MAE_PRODU.COD_SAP (Código de Producto) 
      - MAE_PRODU.DES_CORT (Descripción de Producto) 
      - BEL_REGIS_ABAST_DETAL.NUM_UNID_ENVI (Unidades enviadas) 
      - BEL_REGIS_ABAST_DETAL.NUM_UNID_CONF (Unidades confirmadas) 
      - BEL_REGIS_ABAST_DETAL.NUM_UNID_ATEN (Unidades atendidas) 
      - Descripción internacionalizada del Estado de Actuación para el valor de BEL_REGIS_ABAST_DETAL.DEAT_OID_ESTA_ACTU 
      */
      
      consulta.append("SELECT R.OID_REGI_ABAS_DETA AS OID, P.COD_SAP, ");
      consulta.append("P.DES_CORT, R.NUM_UNID_ENVI, R.NUM_UNID_CONF, R.NUM_UNID_ATEN, R.DEAT_OID_ESTA_ACTU, R.PROD_OID_PROD  ");
      /* PZERBINO Incidencia 21740 Se comenta porque no es internacionalizabel el flag de actuacion
       * Hablar con DT porque es asi
      consulta.append("(SELECT V.VAL_I18N FROM V_GEN_I18N_SICC V ");
      consulta.append("WHERE V.VAL_OID = R.DEAT_OID_ESTA_ACTU ");
      consulta.append("AND V.IDIO_OID_IDIO = ? ");
      parametros.add(dtoe.getOidIdioma());
      consulta.append("AND V.ATTR_NUM_ATRI = 1 ");
      consulta.append("AND V.ATTR_ENTI = 'BEL_ESTAD_ACTUA') AS DESCRIPCION, R.PROD_OID_PROD ");
      */
      consulta.append("FROM BEL_REGIS_ABAST_DETAL R, MAE_PRODU P ");      
      consulta.append("WHERE R.RABC_OID_REGI_ABAS_CABE = ? ");      
      parametros.add(dtoe.getOidRegistroAbastecimientoCabecera());
      consulta.append("AND R.PROD_OID_PROD = P.OID_PROD");
      
      UtilidadesLog.debug("***** Consulta: " + consulta.toString());

      // se ejecuta la consulta
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      
      /*Esta consulta es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
      1.- oid del registro encontrado > dto.indicadorSituacion 
      2.- ROWNUM <= dto.tamañoPagina */
      String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dtoe);
      
      try {
         resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
		} catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.buscarHojaDemadaDetalle: Exception", e);
         logSql("DAORegistroAbastecimiento.buscarHojaDemadaDetalle. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      DTOSalida dtoSalida = null;
      
      if (! resultado.esVacio()) {
         // Devolver RecordSet obtenido encapsulado en un DTOSalida 
         dtoSalida = new DTOSalida(resultado);      
      } else {
         // GEN-0007 --> 0005                                                                                  
         UtilidadesLog.debug("****DAORegistroAbastecimiento.buscarHojaDemadaDetalle: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }
      
      UtilidadesLog.info("DAORegistroAbastecimiento.buscarHojaDemadaDetalle(DTOEBuscarHojaDemandaDetalle dtoe):Salida");
      return dtoSalida;
   }
   
   public DTOSalida obtenerDetalleHojaDemanda(DTOOID dtoe) 
      throws MareException 
   {
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerDetalleHojaDemanda(DTOOID dtoe):Entrada");

   		StringBuffer consulta = new StringBuffer();
    	Vector parametros = new Vector();
      
      /* Proceso: 
      -> Hacer consulta JDBC sobre la tabla BEL_REGIS_ABAST_DETAL con las siguientes condiciones: 
      -> BEL_REGIS_ABAST_DETAL.RABC_OID_REGI_ABAS_CABE = dto.oid 
      -> Obtener los siguientes campos: 
      - OID_REGI_ABAS_DETA (oid de detalle) 
      - NUM_LINEA (número de línea) 
      - NUM_STOC_MINI (stock mínimo) 
      - NUM_STOC_MAXI (stock máximo) 
      - RABC_OID_REGI_ABAS_CABE (oid de cabecera) 
      - NUM_UNID_ENVI (unidades enviadas) 
      - NUM_UNID_CONF (unidades confirmadas) 
      - NUM_UNID_ATEN (unidades atendidas) 
      - PROD_OID_PROD (oid del producto) 
      - DEAT_OID_ESTA_ACTU (oid de tipo de estado de actuación)
      */
   
      consulta.append("SELECT T.OID_REGI_ABAS_DETA, T.NUM_LINE, T.NUM_STOC_MINI, T.NUM_STOC_MAXI, ");
      consulta.append("T.RABC_OID_REGI_ABAS_CABE, T.NUM_UNID_ENVI, T.NUM_UNID_CONF, ");
      consulta.append("T.NUM_UNID_ATEN, T.PROD_OID_PROD, T.DEAT_OID_ESTA_ACTU ");
      consulta.append("FROM BEL_REGIS_ABAST_DETAL T ");
      consulta.append("WHERE T.RABC_OID_REGI_ABAS_CABE = ?");
      parametros.add(dtoe.getOid());
      
 		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      
      try {
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.obtenerDetalleHojaDemanda: Exception", e);
         logSql("DAORegistroAbastecimiento.obtenerDetalleHojaDemanda. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      DTOSalida dtoSalida = null;
      
      if (! resultado.esVacio()) {
         // Devolver RecordSet obtenido encapsulado en un DTOSalida 
         dtoSalida = new DTOSalida(resultado);      
      } else {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAORegistroAbastecimiento.obtenerDetalleHojaDemanda: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }            
      
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerDetalleHojaDemanda(DTOOID dtoe):Salida");
      return dtoSalida;
   }
   

   public Integer obtenerMaximaLineaHojaDemanda(Long oidHojaDemanda) 
      throws MareException
   {
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerMaximaLineaHojaDemanda(Long oidHojaDemanda):Entrada");

      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();

      /*Proceso: 
      -> Hacer consulta JDBC sobre la tabla BEL_REGIS_ABAST_DETAL con las siguientes condiciones: 
      -> BEL_REGIS_ABAST_DETAL.RABC_OID_REGI_ABAS_CABE = oidHojaDemanda 
      -> Obtener el máximo valor para el campo BEL_REGIS_ABAST_DETAL.NUM_LINEA 
      -> Devolver el valor obtenido*/
	
      consulta.append(" select (case ");
      consulta.append(" when count(RABC_OID_REGI_ABAS_CABE)=0 ");
      consulta.append(" then RABC_OID_REGI_ABAS_CABE ");
      consulta.append(" else max(NUM_LINE) ");
      consulta.append(" end) as MAXIMO ");
      consulta.append(" from BEL_REGIS_ABAST_DETAL ");
      consulta.append(" where RABC_OID_REGI_ABAS_CABE = ? ");
      parametros.add(oidHojaDemanda);
  	  consulta.append(" group by RABC_OID_REGI_ABAS_CABE ");

      UtilidadesLog.debug("***** Consulta: " + consulta.toString());

      // se ejecuta la consulta
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;

      try {
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
      } catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.obtenerMaximaLineaHojaDemanda: Exception", e);
         logSql("DAORegistroAbastecimiento.obtenerMaximaLineaHojaDemanda. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }

      Integer maximaLinea = null;
      if (! resultado.esVacio()) { 
         maximaLinea = new Integer(((BigDecimal)resultado.getValueAt(0, "MAXIMO")).intValue());
      } else {
         maximaLinea = new Integer(0);         
      }

      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerMaximaLineaHojaDemanda(Long oidHojaDemanda):Salida");
      return maximaLinea;
   }


   
   public DTOSalida buscarHDDetalleFlag(DTOEBuscarHDDetalleFlag dtoe)
      throws MareException
   {
      UtilidadesLog.info("DAORegistroAbastecimiento.buscarHDDetalleFlag(DTOEBuscarHDDetalleFlag dtoe):Entrada");

  		StringBuffer consulta = new StringBuffer();
  		Vector parametros = new Vector();
      
      /*Proceso: 
      -> Hacer consulta JDBC sobre la tabla BEL_REGIS_ABAST_DETAL con las siguientes condiciones: 
      -> BEL_REGIS_ABAST_DETAL.RABC_OID_REGI_ABAS_CABE = dto.oidRegistroAbastecimientoCabecera 
      -> BEL_REGIS_ABAST_DETAL.DEAT_OID_ESTA_ACTU = dto.oidTipoActuacion 
      -> Cruzar tabla BEL_REGIS_ABAST_DETAL con MAE_PRODU tal que BEL_REGIS_ABAST_DETAL.PROD_OID_PROD = MAE_PRODU.OID_PROD 
      -> Obtener los siguientes campos: 
      - MAE_PRODU.COD_SAP (Código SAP de producto) 
      - MAE_PRODU.DES_CORT (Descripción corta de producto) 
      - BEL_REGIS_ABAST_DETAL.NUM_UNID_CONF - BEL_REGIS_ABAST_DETAL.NUM_UNID_ATEN (unidades no atendidas) */
      
      consulta.append("SELECT R.OID_REGI_ABAS_DETA AS OID,P.COD_SAP AS CODIGO, P.DES_CORT, (R.NUM_UNID_CONF - R.NUM_UNID_ATEN) AS UNIDADES_NO_ATENDIDAS ");
      consulta.append("FROM BEL_REGIS_ABAST_DETAL R, MAE_PRODU P ");
      consulta.append("WHERE R.PROD_OID_PROD = P.OID_PROD ");
      consulta.append("AND R.RABC_OID_REGI_ABAS_CABE = ? ");
      parametros.add(dtoe.getOidRegistroAbastecimientoCabecera());
      if (dtoe.getOidTipoActuacion() != null) {
         consulta.append("AND R.DEAT_OID_ESTA_ACTU = ?");
         parametros.add(dtoe.getOidTipoActuacion());
      }
      
      UtilidadesLog.debug("***** Consulta: " + consulta.toString());

    	// se ejecuta la consulta
  		BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;

      /*Esta consulta es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
      1.- oid del registro encontrado > dto.indicadorSituacion 
      2.- ROWNUM <= dto.tamañoPagina */
      String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dtoe);
     
      try {
         resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
      } catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.buscarHDDetalleFlag: Exception", e);
         logSql("DAORegistroAbastecimiento.buscarHDDetalleFlag. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      DTOSalida dtoSalida =new DTOSalida();
      dtoSalida.setResultado(resultado); 
      
      if ( resultado.esVacio()) {                                                                                 
          UtilidadesLog.debug("****DAORegistroAbastecimiento.buscarHDDetalleFlag: No hay datos ");				                 
      }
      
      UtilidadesLog.info("DAORegistroAbastecimiento.buscarHDDetalleFlag(DTOEBuscarHDDetalleFlag dtoe):Salida");
      return dtoSalida;
   }
   
public Long obtenerOIDRegistroAbastecimientoCabecera(DTORegistroInterface dtoe) 
      throws MareException 
   { 
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoCabecera(DTORegistroInterface dtoe):Entrada");

                  StringBuffer consulta = new StringBuffer(); 
                Vector parametros = new Vector(); 

      /*Proceso: 
      -> Hacer consulta JDBC sobre la tabla BEL_REGIS_ABAST_CABEC con las siguientes condiciones: 
      -> Cruzar tabla BEL_REGIS_ABAST_CABEC con la tabla SEG_PAIS 
      -> Cruzar tabla BEL_REGIS_ABAST_CABEC con la tabla SEG_SUBAC 
      -> Cruzar tabla SEG_SUBAC con tabla SEG_ACCES 
      -> Cruzar tabla SEG_ACCES con tabla SEG_CANAL 
      -> SEG_PAIS.COD_PAIS = dto.codigoPais 
      -> SEG_CANAL.COD_CANA = dto.codigoCanal 
      -> SEG_ACCES.COD_ACCE = dto.codigoAcceso 
      -> SEG_SUBAC.COD_SBAC = dto.codigoSubacceso 
      -> Obtener el campo BEL_REGIS_ABAST_CABEC.OID_REGI_ABAS_CABE */ 
      
      //eyache - modificado por incidencia 16799 
      consulta.append("SELECT R.OID_REGI_ABAS_CABE "); 
      consulta.append("FROM BEL_REGIS_ABAST_CABEC R, SEG_PAIS VP, SEG_SUBAC VS, ");       
      consulta.append("SEG_ACCES VA, SEG_CANAL VC "); 
      consulta.append("WHERE R.PAIS_OID_PAIS = VP.OID_PAIS "); 
      consulta.append("AND R.SBAC_OID_SBAC = VS.OID_SBAC "); 
      consulta.append("AND VS.ACCE_OID_ACCE = VA.OID_ACCE "); 
      consulta.append("AND VA.CANA_OID_CANA = VC.OID_CANA "); 
      consulta.append(" AND VP.COD_PAIS = ? "); 
      parametros.add(dtoe.getCodigoPais()); 
      consulta.append(" AND VC.COD_CANA = ? "); 
      parametros.add(dtoe.getCodigoCanal()); 
      consulta.append(" AND VA.COD_ACCE = ? "); 
      parametros.add(dtoe.getCodigoAcceso()); 
      consulta.append(" AND VS.COD_SBAC = ?"); 
      parametros.add(dtoe.getCodigoSubacceso()); 
      if (dtoe.getNumeroSolicitudReposicion()!=null && dtoe.getNumeroSolicitudReposicion().length()>0){ 
          consulta.append(" AND R.NUM_SOLI = ?"); 
          parametros.add(dtoe.getNumeroSolicitudReposicion()); 
      } 


      UtilidadesLog.debug("***** Consulta: " + consulta.toString()); 

      // se ejecuta la consulta 
      BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
      RecordSet resultado = null; 
      String codigoError = null; 
      
      try { 
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
         UtilidadesLog.debug("1resultado/////////" + resultado);
                } catch(Exception e) { 
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
         logError("DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoCabecera: Exception", e); 
         logSql("DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoCabecera. SQL: ", consulta.toString(), parametros); 
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
      } 

      // Esta consulta devuelve un sólo registro, devolver el oid obtenido 
      Long oidObtenido = null; 
      UtilidadesLog.debug("*****resultado********" + resultado.getColumnCount() + resultado.getRowCount());            
      if (!resultado.esVacio()) { 
         oidObtenido = new Long((resultado.getValueAt(0, 0)).toString()); 
      } else { 
         // GEN-0007 --> 0005                                                                                   
         UtilidadesLog.debug("****DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoCabecera: No hay datos ");                                 
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      } 
      
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoCabecera(DTORegistroInterface dtoe):Salida");
      return oidObtenido; 
   }
   
   public Long obtenerOIDRegistroAbastecimientoDetalle(DTORegistroInterface dto, 
                                                      Long oidRegistroAbastecimientoCabecera) 
      throws MareException 
   {
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoDetalle(DTORegistroInterface dto, Long oidRegistroAbastecimientoCabecera):Entrada");

  		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

      /* Proceso: 
      -> Hacer consulta JDBC sobre la tabla BEL_REGIS_ABAST_DETAL con las siguientes condiciones: 
      -> Cruzar tabla BEL_REGIS_ABAST_DETAL con la tabla MAE_PRODU 
      -> BEL_REGIS_ABAST_DETAL.RABC_OID_REGI_ABAS_CABE = oidRegistroAbastecimientoCabecera 
      -> MAE_PRODU.COD_SAP = dto.codigoProducto 
      -> Obtener el campo BEL_REGIS_ABAST_DETAL.OID_REGI_ABAS_DETA */
            
      consulta.append("SELECT R.OID_REGI_ABAS_DETA ");
      consulta.append("FROM BEL_REGIS_ABAST_DETAL R, MAE_PRODU P ");
      consulta.append("WHERE R.PROD_OID_PROD = P.OID_PROD ");
      consulta.append("AND R.RABC_OID_REGI_ABAS_CABE = ? ");
      parametros.add(oidRegistroAbastecimientoCabecera);
      consulta.append("AND P.COD_SAP = ?");
      parametros.add(dto.getCodigoProducto());
      
  		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      
      try {
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoDetalle: Exception", e);
         logSql("DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoDetalle. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      // Esta consulta devuelve un sólo registro, devolver el oid obtenido
      Long oidObtenido = null;
      if (!resultado.esVacio()) {
         oidObtenido = new Long((resultado.getValueAt(0, 0)).toString());
      } else {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoDetalle: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }
     
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerOIDRegistroAbastecimientoDetalle(DTORegistroInterface dto, Long oidRegistroAbastecimientoCabecera):Salida");
      
      return oidObtenido;
   }
   
   
   public RecordSet obtenerEstimadosVenta(Long subacceso, Long periodo)
      throws MareException 
   {
      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerEstimadosVenta(Long subacceso, Long periodo):Entrada");
      
  		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

      // Hacer consulta JDBC sobre la tabla BEL_ESTIM_VENTA_BELCE con las siguientes condiciones: 
      // BEL_ESTIM_VENTA_BELCE.SBAC_OID_SBAC = subacceso 
      // BEL_ESTIM_VENTA_BELCE.PERD_OID_PERI = periodo 
      // Obtener los siguientes campos: 
      // PROD_OID_PROD (Producto) 
      // NUM_UNID_ESTI (Unidades estimadas) 
            
      consulta.append("select prod_oid_prod, num_unid_esti "); 
      consulta.append("from bel_estim_venta_belce ");
      consulta.append("where sbac_oid_sbac = ? ");
      parametros.add(subacceso);
      consulta.append("and perd_oid_peri = ?");
      parametros.add(periodo);

  		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      
      try {
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch(Exception e) {
         codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         logError("DAORegistroAbastecimiento.obtenerEstimadosVenta: Exception", e);
         logSql("DAORegistroAbastecimiento.obtenerEstimadosVenta. SQL: ", consulta.toString(), parametros);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
 
      if (resultado.esVacio()) {
         // GEN-0007 --> 0005                                                                                  
			UtilidadesLog.debug("****DAORegistroAbastecimiento.obtenerEstimadosVenta: No hay datos ");				
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
      }

      UtilidadesLog.info("DAORegistroAbastecimiento.obtenerEstimadosVenta(Long subacceso, Long periodo):Salida");
      // Devolver RecordSet obtenido
      return resultado;
   }
      
}