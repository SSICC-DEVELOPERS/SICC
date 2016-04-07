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

// Método DAOFACPrecargas.cargarSecuenciaProcesos eliminado
// por la incidencia BELC300008564. Se vuelve a añadir por incidencia 8725	

package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOFACClaseSolicitud;
import es.indra.sicc.dtos.fac.DTOFACEstadoSolicitud;
import es.indra.sicc.dtos.fac.DTOFACImpuestosNegocio;
import es.indra.sicc.dtos.fac.DTOFACImpuestosUbigeo;
import es.indra.sicc.dtos.fac.DTOFACSecuenciaProcesos;
import es.indra.sicc.dtos.fac.DTOFACValoresDefecto;
import es.indra.sicc.dtos.fac.DTOImpuestosGenerales;
import es.indra.sicc.dtos.fac.DTOIndicadoresImpuestos;
import es.indra.sicc.dtos.fac.DTOTiposSolicitudPais;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

public class DAOFACPrecargas  {
	public DAOFACPrecargas() {
	}

	public ArrayList cargarEstadosSolicitud() throws MareException {

		UtilidadesLog.info("DAOFACPrecargas.cargarEstadosSolicitud(): Entrada");

		StringBuffer sql = new StringBuffer("");
	
		sql.append(" SELECT OID_ESTA_SOLI as OID, COD_ESTA_SOLI as ESTADO ");
		sql.append(" FROM PED_ESTAD_SOLIC ");
		
		//Con cada registro obtenido de crea un objeto DTOFACEstadoSolicitud,
		//y se retorna la lista total.
		BelcorpService bs = null;
		bs = BelcorpService.getInstance();

		RecordSet rs = null;

		// Obtenemos todos los registros
		try{
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch(Exception e) {
			UtilidadesLog.error(" cargarEstadosSolicitud:",e);
			this.logSql(" cargarEstadosSolicitud. SQL: ",sql.toString(),null);
			throw new MareException(e, UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		int tamanyo = rs.getRowCount();
		ArrayList salida = new ArrayList(tamanyo);
		for(int i=0; i<tamanyo; i++){

			DTOFACEstadoSolicitud dto = new DTOFACEstadoSolicitud();
			dto.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID")).longValue()));
			dto.setEstado(rs.getValueAt(i,"ESTADO").toString());
			
			salida.add(dto);
		}
        
		UtilidadesLog.info("DAOFACPrecargas.cargarEstadosSolicitud(): Salida");
        
		return salida;
	}

	public ArrayList cargarImpuestosGenerales() throws MareException {

		UtilidadesLog.info("DAOFACPrecargas.cargarImpuestosGenerales(): Entrada");
		
		StringBuffer sql = new StringBuffer("");

		// Armamos la SQL
		//Modificado Incidencia BELC300009715
		sql.append(" SELECT IG.PAIS_OID_PAIS AS pais, ");
		sql.append(" IG.SBAC_OID_SBAC AS subacceso, ");
		sql.append(" IG.TAIM_OID_TASA_IMPU AS indicadorImpuesto, ");
		sql.append(" IG.TAIM_OID_TASA_IMPU_FLET AS indicadorImpuestoFlete, ");
		sql.append(" IG.IND_TASA_UNIC AS indicadorTasaUnica ");
		sql.append(" FROM PED_IMPUE_GENER IG, SEG_SUBAC SA ");
		sql.append(" WHERE IG.SBAC_OID_SBAC = SA.OID_SBAC ");

		BelcorpService bs = null;
		bs = BelcorpService.getInstance();

		RecordSet rs = null;

		// Obtenemos todos los registros
		try{
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch(Exception e) {
			UtilidadesLog.error("DAOFACPrecargas:cargarImpuestosGenerales:Exception",e);
			this.logSql(" cargarImpuestosGenerales. SQL: ",sql.toString(),null);
			throw new MareException(e, UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		DTOImpuestosGenerales dto = null;
		int tamanyo = rs.getRowCount();
		ArrayList arraySalida = new ArrayList(tamanyo);
		
		// Obtenemos todos los datos del RecordSet. Cada entrada se almacenará
		// temporalmente en dto y de ahí al ArrayList
		for(int i = 0; i<tamanyo; i++){
			dto = new DTOImpuestosGenerales();
			
			dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(i, "PAIS")).toString()));
			dto.setSubacceso(new Long(((BigDecimal)rs.getValueAt(i, "SUBACCESO")).toString()));
			dto.setIndicadorImpuesto(new Long(((BigDecimal)rs.getValueAt(i,"INDICADORIMPUESTO")).longValue()));//incidencia 8034

			// Puede ser nulo
			if(((BigDecimal)rs.getValueAt(i, "INDICADORIMPUESTOFLETE"))==null){
				dto.setIndicadorImpuestoFlete(null);
			}else {
				dto.setIndicadorImpuestoFlete(new Long(((BigDecimal)rs.getValueAt(i,"INDICADORIMPUESTOFLETE")).longValue()));//incidencia 8034
			}
			
			if(((BigDecimal)rs.getValueAt(i, "INDICADORTASAUNICA")).intValue()==0) {
				dto.setIndicadorTasaUnica(new Boolean(false));
			} else {
					dto.setIndicadorTasaUnica(new Boolean(true));
			}
		
			// Introducimos el dto en el arrayList
			arraySalida.add(dto);
		}
		
		UtilidadesLog.info("DAOFACPrecargas.cargarImpuestosGenerales(): Salida");

		return arraySalida;
	}

	public ArrayList cargaIndicadoresImpuestos() throws MareException {

		UtilidadesLog.info("DAOFACPrecargas.cargaIndicadoresImpuestos(): Entrada");

		StringBuffer sql = new StringBuffer("");

		// Armamos la SQL
		//sql.append(" SELECT * FROM PED_TASA_IMPUE ");//incidencia BELC300008034
		//modificado por nuevo diseño
		sql.append(" SELECT OID_TASA_IMPU as oidTasaImpuesto, ");
		sql.append(" VAL_TASA_IMPU as tasaImpuesto, ");
		sql.append(" VAL_INDI_IMPU as indicadorImpuestos, ");
		sql.append(" PAIS_OID_PAIS as pais ");
		sql.append(" FROM PED_TASA_IMPUE "); 

		//BelcorpService bs = null;
		//bs = BelcorpService.getInstance();
		BelcorpService bs = UtilidadesEJB.getBelcorpService();

		RecordSet rs = null;
		
		// Ejecutamos la consulta
		try{
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargaIndicadoresImpuestos:Exception",e);
			this.logSql(" cargaIndicadoresImpuestos. SQL: ",sql.toString(),null);
			throw new MareException(e, UtilidadesError.armarCodigoError(
								CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		ArrayList arraySalida = new ArrayList();

		DTOIndicadoresImpuestos dto = null;

		int tamanyo = rs.getRowCount();

		for(int i = 0; i<tamanyo; i++){
			dto = new DTOIndicadoresImpuestos();
			// se quito el nombre de las columnas pq no funcionaba adecuadamente
			dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(i, 3)).toString()));//PAIS_OID_PAIS
			dto.setIndicadorImpuestos((String)rs.getValueAt(i, 2));//VAL_INDI_IMPU
			dto.setTasaImpuesto(
					new Float(((BigDecimal)rs.getValueAt(i, 1)).toString()));//VAL_TASA_IMPU
			dto.setOidTasaImpuesto(new Long(((BigDecimal)rs.getValueAt(i, 0)).toString()));//OID_TASA_IMPU  //INCIDENCIA BELC300008034
			arraySalida.add(dto);
		}


		UtilidadesLog.info("DAOFACPrecargas.cargaIndicadoresImpuestos(): Salida");

		return arraySalida;
	}

	public Hashtable cargarTiposSolicitudPais() throws MareException {

		UtilidadesLog.info("DAOFACPrecargas.cargarTiposSolicitudPais(): Entrada");

		StringBuffer sql = new StringBuffer("");

		// Armo la SQL
		sql.append(" SELECT TSP.OID_TIPO_SOLI_PAIS AS TIPOSOLICITUDPAIS, ");
		sql.append(" TS.ACCE_OID_ACCE AS ACCESO, TS.SBAC_OID_SBAC AS SUBACCESO, ");
        sql.append(" A.COD_ACCE AS CODACCESO ");
		sql.append(" FROM PED_TIPO_SOLIC_PAIS TSP, PED_TIPO_SOLIC TS,  SEG_ACCES A ");
		sql.append(" WHERE TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI ");
        sql.append(" AND A.OID_ACCE (+) = TS.ACCE_OID_ACCE ");

		RecordSet rs = null;
	
		// Obtengo los valores de la SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try { 
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargarTiposSolicitudPais:Exception",e);
			this.logSql("cargarTiposSolicitudPais. SQL: ",sql.toString(),null);
			throw new MareException (e, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		int tamanyo = rs.getRowCount();
		Hashtable hashSalida = new Hashtable(tamanyo);
		DTOTiposSolicitudPais dto = null;
		Long tipoSolicitudPais = null;

		// Inserto los elementos encontrados en un DTO y de ahí al Hashtable
		for(int i = 0; i<tamanyo; i++){
			dto = new DTOTiposSolicitudPais();

			tipoSolicitudPais = new Long(((BigDecimal)rs.getValueAt(i, "TIPOSOLICITUDPAIS")).toString());
			dto.setAcceso(new Long(((BigDecimal)rs.getValueAt(i, "ACCESO")).toString()));
			// Es nullable
			if(rs.getValueAt(i, "SUBACCESO")==null){
				dto.setSubacceso(null);
			} else {
				dto.setSubacceso(new Long(((BigDecimal)rs.getValueAt(i, "SUBACCESO")).toString()));
			}
            // añadido por incidencia 17331
            if(rs.getValueAt(i,"CODACCESO") != null){
                dto.setCodAcceso(rs.getValueAt(i,"CODACCESO").toString());
            }
			
			hashSalida.put(tipoSolicitudPais, dto);
		}

		UtilidadesLog.info("DAOFACPrecargas.cargarTiposSolicitudPais(): Salida");

		return hashSalida;
	}

	public ArrayList cargaValoresDefecto() throws MareException {

		UtilidadesLog.info("DAOFACPrecargas.cargaValoresDefecto(): Entrada");

		StringBuffer sql = new StringBuffer("");

		// Armo la SQL
		sql.append(" SELECT * FROM PED_VALOR_DEFEC_TIPO_SOLIC ");

		RecordSet rs = null;
	
		// Obtengo los valores de la SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try { 
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargaValoresDefecto:Exception",e);
			this.logSql("cargaValoresDefecto. SQL: ",sql.toString(),null);
			throw new MareException (e, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		DTOFACValoresDefecto dto = null;
		int tamanyo = rs.getRowCount();
		ArrayList arraySalida = new ArrayList(tamanyo);

		for(int i = 0; i<tamanyo; i++){
			dto = new DTOFACValoresDefecto();


			// Es nullable
			if(rs.getValueAt(i, "OID_VALO_DEFE_TIPO_SOLI")==null){
				dto.setOidValorDefectoTipoSolicitud(null);
			} else {
				dto.setOidValorDefectoTipoSolicitud(
					new Long(((BigDecimal)rs.getValueAt(i, "OID_VALO_DEFE_TIPO_SOLI")).toString()));
			}
			// Es nullable, pero como es String, funciona correctamente
			dto.setValorPorDefecto((String)rs.getValueAt(i, "VAL_VALO_DEFE"));
			dto.setOidTipoSolicitudPais(
				new Long(((BigDecimal)rs.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS")).toString()));
			dto.setOidAtributoEspecial(
				new Long(((BigDecimal)rs.getValueAt(i, "ATRE_OID_ATRI_ESPE")).toString()));

			Long obligatorio = new Long(
				((BigDecimal)rs.getValueAt(i, "IND_OBLI")).toString());
			if (obligatorio.intValue()==1) {
				dto.setIndicadorObligatorio(new Boolean(true));
			} else if (obligatorio.intValue()==0) {
				dto.setIndicadorObligatorio(new Boolean(false));
			}

			Long modificable = new Long(
				((BigDecimal)rs.getValueAt(i, "IND_MODI")).toString());
			if (modificable.intValue()==1) {
				dto.setIndicadorModificable(new Boolean(true));
			} else if (modificable.intValue()==0) {
				dto.setIndicadorModificable(new Boolean(false));
			}

			arraySalida.add(dto);
		}

		UtilidadesLog.info("DAOFACPrecargas.cargaValoresDefecto(): Salida");

		return arraySalida;
	}

public ArrayList cargarImpuestosUbigeo() throws MareException {

		UtilidadesLog.info("DAOFACPrecargas.cargarImpuestosUbigeo(): Entrada");

		StringBuffer sql = new StringBuffer("");

		// Armo la SQL

		sql.append(" SELECT OID_IMPU_UBIG as oid, ");
		sql.append(" PROD_OID_PROD as producto, ");
		sql.append(" TAIM_OID_TASA_IMPU as tasaImpuesto,  ");
		sql.append(" SBAC_OID_SBAC as subacceso ");
		sql.append(" FROM MAE_IMPUE_UBIGE  ");
		
		RecordSet rs = null;
	
		// Obtengo los valores de la SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try { 
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargarImpuestosUbigeo:Exception",e);
			this.logSql("cargarImpuestosUbigeo. SQL: ",sql.toString(),null);
			throw new MareException (e, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		DTOFACImpuestosUbigeo dto = null;
		int tamanyo = rs.getRowCount();
		ArrayList arraySalida = new ArrayList(tamanyo);

		for(int i = 0; i<tamanyo; i++){
			dto = new DTOFACImpuestosUbigeo();
				dto.setOid(new Long(((BigDecimal)rs.getValueAt(i, 0)).toString()));//OID_IMPU_UBIG
				dto.setProducto(new Long(((BigDecimal)rs.getValueAt(i, 1)).toString()));//PROD_OID_PROD
			if(rs.getValueAt(i, "TAIM_OID_TASA_IMPU") != null){
				dto.setTasaImpuesto(new Long(((BigDecimal)rs.getValueAt(i, 2)).toString()));//TAIM_OID_TASA_IMPU
			}
				dto.setSubacceso(new Long(((BigDecimal)rs.getValueAt(i, 3 )).toString()));	//SBAC_OID_SBAC
			arraySalida.add(dto);
		}

		UtilidadesLog.info("DAOFACPrecargas.cargarImpuestosUbigeo(): Salida");

		return arraySalida;
	}

	public ArrayList cargarImpuestosNegocio() throws MareException {
		UtilidadesLog.info("DAOFACPrecargas.cargarImpuestosNegocio(): Entrada");
	
		StringBuffer sql = new StringBuffer("");

		// Armo la SQL

		sql.append(" SELECT NEGO_OID_NEGO as negocio, ");
		sql.append(" TAIM_OID_TASA_IMPU as indicadorImpuesto, ");
		sql.append(" PAIS_OID_PAIS as pais, ");
		sql.append(" SBAC_OID_SBAC as subacceso  ");
		sql.append(" from PED_IMPUE_NEGOC  ");

		RecordSet rs = null;
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
	
		// Obtengo los valores de la SQL
		try { 
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargarImpuestosNegocio:Exception",e);
			this.logSql("cargarImpuestosNegocio. SQL: ",sql.toString(),null);
			throw new MareException (e, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		DTOFACImpuestosNegocio dto = null;
		int tamanyo = rs.getRowCount();
		ArrayList arraySalida = new ArrayList(tamanyo);
		

		for(int i = 0; i<tamanyo; i++){
			dto = new DTOFACImpuestosNegocio();

			//se quitaron el nombre de las columnas porque no funcionaba adecuadamente
			dto.setPais(new Long(((BigDecimal)rs.getValueAt(i, 2)).toString()));
			dto.setSubacceso(new Long(((BigDecimal)rs.getValueAt(i, 3)).toString()));
			dto.setNegocio(new Long(((BigDecimal)rs.getValueAt(i, 0)).toString()));
			dto.setIndicadorImpuesto(
				new Long(((BigDecimal)rs.getValueAt(i, 1)).toString()));

			arraySalida.add(dto);
		}

		UtilidadesLog.info("DAOFACPrecargas.cargarImpuestosNegocio(): Salida");

		return arraySalida;
		
	}

	public ArrayList cargarClasesSolicitud() throws MareException {
		UtilidadesLog.info("DAOFACPrecargas.cargarClasesSolicitud(): Entrada");

		StringBuffer sql = new StringBuffer("");

		// Armo la SQL
		sql.append(" SELECT * FROM PED_CLASE_SOLIC ");

		RecordSet rs = null;
		BelcorpService bs = null;
		
		// Obtengo los valores de la SQL
		bs = BelcorpService.getInstance();
		try { 
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			UtilidadesLog.error("cargarClasesSolicitud:Exception",e);
			this.logSql("cargarClasesSolicitud. SQL: ",sql.toString(),null);
			throw new MareException (e, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		DTOFACClaseSolicitud dto = null;
		int tamanyo = rs.getRowCount();
		ArrayList arraySalida = new ArrayList(tamanyo);

		for(int i = 0; i<tamanyo; i++){
			dto = new DTOFACClaseSolicitud();

			// Creo que debería obtener COD_CLAS_SOLI
			// Incidencia 8670
			
			//OID_CLAS_SOLI(NUMBER(12)) -> claseSolicitud(Long)
			//COD_CLAS_SOLI(VARCHAR2(2)) -> descripcion(String)
			//IND_ORDE_COMP(NUMBER(1)) -> indicadorOrdenCompra(Boolean)
			
			dto.setClaseSolicitud(new Long(
				((BigDecimal)rs.getValueAt(i, "OID_CLAS_SOLI")).toString()));

			dto.setDescripcion(rs.getValueAt(i, "COD_CLAS_SOLI").toString());

			Long ordenCompra = new Long(
				((BigDecimal)rs.getValueAt(i, "IND_ORDE_COMP")).toString());
			
			if (ordenCompra.intValue()==1) {
				dto.setIndicadorOrdenCompra(new Boolean(true));
			} else if (ordenCompra.intValue()==0) {
				dto.setIndicadorOrdenCompra(new Boolean(false));
			}
			
			arraySalida.add(dto);
		}
		
		UtilidadesLog.info("DAOFACPrecargas.cargarClasesSolicitud(): Salida");

		return arraySalida;
	}

    public ArrayList cargarSecuenciaProcesos( Long grupoProcesos ,String proceso, Long tipoSolicitud) throws MareException{
        // Hace una precarga de la tabla PED_SECUE_PROCE para optimizar los accesos a BD.
        // Los procesos han de pertenecer al grupo ser posteriores al proceso recibidos como parámetros
        UtilidadesLog.info("DAOFACPrecargas.cargarSecuenciaProcesos( Long grupoProcesos ,String proceso, Long tipoSolicitud): Entrada");
        UtilidadesLog.debug("*** GrupoProceso = "+grupoProcesos + " Proceso = "+proceso +" tipoSolicitud = "+tipoSolicitud);
		StringBuffer sql = new StringBuffer("");
        Vector parametros = new Vector();
        
		sql.append(" SELECT SP.COD_SECU secuencia, SP.TSPA_OID_TIPO_SOLI_PAIS as tipoSolicitud, ");
		sql.append(" SP.GRPR_OID_GRUP_PROC as oidGrupoProcesos, GP.COD_GRUP_PROC as grupoProcesos, ");
		sql.append(" SP.PROC_OID_PROC as oidProceso, P.COD_PROC as codigoProceso, ");
		sql.append(" SP.IND_EJEC_ONLI as indicadorEjecucionEnLinea, ");
		sql.append(" PR.VAL_CLAS_EJEC as businessID "); 
		sql.append(" FROM PED_SECUE_PROCE SP, PED_GRUPO_PROCE GP, PED_PROCE P, PED_PROGR PR ");
		
        sql.append(" WHERE SP.PROC_OID_PROC = P.OID_PROC ");
        sql.append(" AND PR.OID_PROG = P.PROG_OID_PROG ");
        sql.append(" AND GP.OID_GRUP_PROC = SP.GRPR_OID_GRUP_PROC ");
        if(grupoProcesos != null){
            sql.append(" AND  SP.GRPR_OID_GRUP_PROC = ? ");
            parametros.add(grupoProcesos);
        }
        if(proceso != null){
            sql.append(" AND P.COD_PROC > ? ");
            parametros.add(proceso);
        }
        if(tipoSolicitud != null){
            sql.append(" AND SP.TSPA_OID_TIPO_SOLI_PAIS = ? ");
            parametros.add(tipoSolicitud);
		}
		  
        //Con el RecordSet obtenido se crea una lista de objetos DTOFACSecuenciaProcesos, y se retorna.
        BelcorpService bs = null;
		bs = BelcorpService.getInstance();

		RecordSet rs = null;

		// Obtenemos todos los registros
		try{
			rs = bs.dbService.executePreparedQuery(sql.toString(),parametros);
		} catch(Exception e) {
			UtilidadesLog.error(" cargarSecuenciaProcesos:",e);
			this.logSql(" cargarSecuenciaProcesos. SQL: ",sql.toString(),null);
			throw new MareException(e, UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		int tamanyo = rs.getRowCount();
		ArrayList salida = new ArrayList(tamanyo);
		for(int i=0; i<tamanyo; i++){

			DTOFACSecuenciaProcesos dto = new DTOFACSecuenciaProcesos();
			dto.setSecuencia(new Integer(((BigDecimal)rs.getValueAt(i,0)).intValue()));//"secuencia"
			dto.setTipoSolicitud(new Long(((BigDecimal)rs.getValueAt(i,1)).longValue()));//"tipoSolicitud"
			dto.setOidGrupoProcesos(new Long(((BigDecimal)rs.getValueAt(i,2)).longValue()));	//"oidGrupoProcesos"		
			dto.setGrupoProcesos(rs.getValueAt(i,3).toString());//"grupoProcesos"
			dto.setOidProceso(new Long(((BigDecimal)rs.getValueAt(i,4)).longValue()));//"oidProceso"			
			dto.setCodigoProceso(rs.getValueAt(i,5).toString());//"codigoProceso"

			if(((BigDecimal)rs.getValueAt(i,6)).intValue() == 1){//"indicadorEjecucionEnLinea"
				dto.setIndicadorEjecucionEnLinea(Boolean.TRUE);
			} else{
				dto.setIndicadorEjecucionEnLinea(Boolean.FALSE);
			}

			if (rs.getValueAt(i,7)!=null){//"businessID"
				dto.setBusinessID(rs.getValueAt(i,7).toString());//"businessID"
			}
			salida.add(dto);
		}
			
		UtilidadesLog.info("DAOFACPrecargas.cargarSecuenciaProcesos( Long grupoProcesos ,String proceso, Long tipoSolicitud): Salida");
		return salida;
    }

	private void logSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("DAOFACPrecargas.logSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
        UtilidadesLog.info("DAOFACPrecargas.logSql(String metodo, String sql, Vector params): Salida");
	}	
    
}