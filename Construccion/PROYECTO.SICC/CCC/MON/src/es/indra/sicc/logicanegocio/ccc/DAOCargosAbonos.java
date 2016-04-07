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

package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOBuscarCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOCargosAbonos;
import es.indra.sicc.dtos.ccc.DTOMovimientoCuentaCompleto;
import es.indra.sicc.dtos.ccc.DTONumeroDocumento;
import es.indra.sicc.dtos.ccc.DTONumeroOrden;
import es.indra.sicc.dtos.ccc.DTOValidarNumeroDocumento;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocalHome;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.ccc.DAOCCC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.persistence.NoResultException;

public class DAOCargosAbonos  {

	private String usuario = null;

	public DAOCargosAbonos(String newUsuario) {
        UtilidadesLog.info("DAOCargosAbonos.DAOCargosAbonos(String newUsuario): Entrada ");
		this.usuario = newUsuario;
        UtilidadesLog.info("DAOCargosAbonos.DAOCargosAbonos(String newUsuario): Salida ");
	}

    /** 
     * Método para obtener el siguiente numero de la tabla CCC_CABEC_CARGA_ABONO_DIREC
     * @param pais Long con el pais de referencia
     * @return Integer con el numero siguiente
     * @exception MareException si no se pudo acceder a la base de datos 
     */
/*	Eliminado por incidencia BELC300010254 
	public Integer obtieneSiguienteNumero (Long pais) throws MareException {
		/*
		 * Hacemos la siguiente consulta JDBC: 

		 * SELECT MAX(NUMERO) 
		 * FROM CCC_CABEC_CARGA_ABONO_DIREC 
		 * GROUP BY PAIS_OID_PAIS, ANIO, VAL_PERI_MES 
		 * HAVING PAIS_OID_PAIS = pais AND 
		 * ANIO = [los dos ultimos dígitos del año de la fecha del sistema] AND 
		 * VAL_PERI_MES = [el número de més de la fecha del sistema] 

		 * Devolvemos el valor obtenido +1 
		 * Si no obtenemos ningún registro devolvemos 1

		 *

		UtilidadesLog.info("Entrada metodo obtieneSiguienteNumero");

		Integer siguiente = new Integer(1);

        BelcorpService bs = null;
		String anyo = null;
		String mes = null;
		try  {
			anyo = UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"yy");
			mes = UtilidadesFecha.convertirAString(new Date(System.currentTimeMillis()),"MM");
		}catch (ParseException e)  {
			this.logearError("*** Error en aplicarCargosAbonos",e);
            String codigoError = CodigosError.ERROR_PARAMETROS_INCORRECTOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
		}

        StringBuffer sQuery = new StringBuffer("SELECT MAX(NUM_CABE)");
        sQuery.append(" FROM CCC_CABEC_CARGA_ABONO_DIREC ");
        sQuery.append("GROUP BY PAIS_OID_PAIS, ANIO, VAL_PERI_MES ");
        sQuery.append("HAVING PAIS_OID_PAIS = " + pais );
        sQuery.append(" AND ANIO = '" + anyo + "'");
        sQuery.append(" AND VAL_PERI_MES = '" + mes + "'");

		UtilidadesLog.info("SQL: " + sQuery);

        bs = UtilidadesEJB.getBelcorpService();

        RecordSet rs = null;

        try {
            rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if((rs != null) && (!rs.esVacio())) {
            if(rs.getValueAt(0,0) != null)
                siguiente = new Integer(((BigDecimal)rs.getValueAt(0,0)).intValue()+1);
        }

		UtilidadesLog.info("Salida metodo obtieneSiguienteNumero: " + siguiente);
		return siguiente;
    }

*/
    /** 
     * Método para obtener los registros de la tabla CCC_CABEC_CARGA_ABONO_DIREC que cumplen 
     * los criterios de busqueda determinados en el parámetro de entrada
     * @param dto DTOBuscarCargosAbonos con los criterios de busqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
	 public DTOSalida buscar(DTOBuscarCargosAbonos dto)  throws MareException {
		/*
		 * SELECT ca.OID_CABECERA_CARGAS, ca.NUMERO, cli.COD_CLIE, ca.FEC_DOCU 
		 * FROM CCC_CABEC_CARGA_ABONO_DIREC ca 
		 * WHERE ca.CLIE_OID_CLIE = cli.oid_CLIE AND 

		 * //De las siguientes restricciones quitamos aquellas en las que el atributo del dto sea null 
		 * ca.NUMERO LIKE dto.numeroIdentificacion AND 
		 * cli.COD_CLIE LIKE dto.codigoCliente AND 
		 * ca.FEC_DOCU = dto.fechaDocumento 

		 * Devolvemos un DTOSalida con los resultados
		 */

		UtilidadesLog.info("DAOCargosAbonos.buscar(DTOBuscarCargosAbonos dto): Entrada ");

        Vector  parametros = new Vector();

        BelcorpService bs = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		//String anyo = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);

        StringBuffer sQuery = new StringBuffer("");

		sQuery.append(" SELECT ca.OID_CABE_CARG OID, ca.NUM_CABE,ca.ANIO, ");
		sQuery.append(" ca.VAL_PERI_MES, cli.COD_CLIE,pro.COD_PROC,ca.FEC_DOCU ");
        sQuery.append(" FROM CCC_CABEC_CARGA_ABONO_DIREC ca LEFT JOIN MAE_CLIEN cli ");
		sQuery.append(" ON (cli.OID_CLIE = ca.CLIE_OID_CLIE), ");
		sQuery.append(" CCC_PROCE pro, ");
		sQuery.append(" VCA_SEG_PAIS pais ");
        sQuery.append(" WHERE ca.PAIS_OID_PAIS = pais.OID_PAIS AND ");
		sQuery.append(" ca.CCPR_OID_PROC = pro.OID_PROC AND ");
		sQuery.append(" pais.COD_USUA = ? ");
		parametros.add(this.usuario);
		
		if(dto.getOidPais() != null){
			sQuery.append(" AND pais.OID_PAIS = ? ");
			parametros.add(dto.getOidPais());
		}
		if(dto.getProceso() != null){
			sQuery.append(" AND pro.OID_PROC = ? ");
			parametros.add(dto.getProceso());
		}
		if (dto.getNumeroIdentificacion() != null) {
			sQuery.append(" AND ca.NUM_CABE LIKE ? ");// + dto.getNumeroIdentificacion());
			parametros.add(new Integer(dto.getNumeroIdentificacion().intValue()));
		}
		if (dto.getCodigoCliente() != null) {
			sQuery.append(" AND cli.COD_CLIE LIKE ? " );
			parametros.add(dto.getCodigoCliente());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (dto.getFechaDocumento() != null) {
			Date fechaDesde = new Date(dto.getFechaDocumento().getTime());

			String sFechaDesde = sdf.format(fechaDesde);                                                          

			sQuery.append(" AND (ca.FEC_DOCU = TO_DATE( ? ,'YYYY-MM-DD'))  ");
			parametros.add(sFechaDesde);
			//long time = dto.getFechaDocumento().getTime();
			//java.sql.Date fecha = new java.sql.Date(time);
			//parametros.add(fecha);
		}
		if(dto.getEjercicio() != null){
			sQuery.append(" AND ca.ANIO = ?");
			parametros.add(dto.getEjercicio());
		}
		if(dto.getMes() != null){
			sQuery.append(" AND ca.VAL_PERI_MES = ?");
			parametros.add(dto.getMes());
		}

    	String sql = UtilidadesPaginacion.armarQueryPaginacion(sQuery.toString(), dto);
		this.loguearSql("buscar. SQL: ", sql, parametros);

        bs = UtilidadesEJB.getBelcorpService();


        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        String codigoError = null;
        try {
            resultadoQuery = bs.dbService.executePreparedQuery(sql, parametros);
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** buscar: error ejecutar query ");				
			this.logStackTrace(e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		if (resultadoQuery.esVacio()) {
			UtilidadesLog.debug("buscar: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        // Se devuelve un DTOSalida que contiene el resultado de la consulta
        DTOSalida dtoSalida = new DTOSalida(resultadoQuery);

		UtilidadesLog.info("DAOCargosAbonos.buscar(DTOBuscarCargosAbonos dto): Salida ");
        return dtoSalida;
    }


    /** 
     * Este método devuelve true si aún es posible modificar la aplicación de cargos y abonos a un registro
     * Esto es posible si no se ha contabilizado y si los movimientos asociados no han sido modificados posteriormente. 
     * @param oid Long con el numero identificador del registro     
     * @return Boolean 
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontró el registro
     */
	 public Boolean esPosibleModificar(Long oid)  throws MareException {

        UtilidadesLog.info("DAOCargosAbonos.esPosibleModificar(Long oid): Entrada ");
		/*
		 * SELECT c.FEC_CONT, s.COD_SUBP
			FROM
			  CCC_CABEC_CARGA_ABONO_DIREC c,
			  CCC_TIPO_ABONO_SUBPR t,
			  CCC_SUBPR s
			WHERE
			  //joins
			  c.TASP_OID_TIPO_ABON_SUBP=t.OID_TIPO_ABON_SUBP AND
			  t.SUBP_OID_SUBP = s.OID_SUBP

			  //criterios de filtro
			  c.OID_CABE_CARG = oid  //Recibido como parámetro
		 */

		Vector  parametros = new Vector();

		BelcorpService bs = null;

		StringBuffer sQuery = new StringBuffer("SELECT c.VAL_NUME_LOTE_CONT ");
		sQuery.append(" FROM");
		sQuery.append(" CCC_CABEC_CARGA_ABONO_DIREC c");
		sQuery.append(" WHERE c.OID_CABE_CARG = ? ");
		parametros.add(oid);

		this.loguearSql("esPosibleModificar. SQL: ", sQuery.toString(), parametros);

        bs = UtilidadesEJB.getBelcorpService();


        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        String codigoError = null;
        try {
            resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(), parametros);
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** esPosibleModificar: error ejecutar query ");				
			this.logStackTrace(e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
		
		/*Si recordset.FEC_CONT == null return false;*/
		UtilidadesLog.debug("RESULTADO CONSULTA: " + resultadoQuery);
        
        // gPineda - 23/02/2007 - C-CCC-008 - S/ nvo DECU se verifica mediante este campo, no FEC_CONT
		//if (resultadoQuery.getValueAt(0,"FEC_CONT") != null){
        if (resultadoQuery.getValueAt(0,"VAL_NUME_LOTE_CONT") != null){
			return Boolean.valueOf(false);
		}
		//String subproceso = null;
		///CANCELACION_CUOTAS 
		parametros = new Vector();
			 
			sQuery = new StringBuffer("SELECT de.NUM_HIST_GENE, mo.VAL_ULTI_NUME_HIST ");
			sQuery.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC de, CCC_MOVIM_CUENT_CORRI mo, ");
			sQuery.append(" CCC_TIPO_ABONO_SUBPR ta");
			sQuery.append(" WHERE de.MVCC_OID_MOVI_CC = mo.OID_MOVI_CC AND");
			sQuery.append(" de.TASP_OID_TIPO_ABON_SUBP = ta.OID_TIPO_ABON_SUBP AND");
			sQuery.append(" ta.subp_oid_subp = (SELECT sub.oid_subp FROM CCC_SUBPR sub WHERE ta.subp_oid_subp = sub.oid_subp AND sub.cod_subp = ? ) ");
			parametros.add(CCCConstantes.CANCELACION_CUOTAS);
			sQuery.append(" AND de.CCAD_OID_CABE_CARG = ?");
			parametros.add(oid);

			this.loguearSql("esPosibleModificar. SQL CANCELACION_CUOTAS: ", sQuery.toString(), parametros);

			bs = UtilidadesEJB.getBelcorpService();

			// Se ejecuta la consulta
			resultadoQuery = null;
			try {
				resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(),parametros);
			} catch (Exception e) {
				//GEN-0002
				UtilidadesLog.error("**** esPosibleModificar: error ejecutar query ");				
				this.logStackTrace(e);
				throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
			}
			if (!resultadoQuery.esVacio()) {
				//para cada resultado obtenido Si de.NUM_HIST_GENE <> mo.VAL_ULTI_NUME_HIST  devolvemos false.
				for(int i = 0; i < resultadoQuery.getRowCount(); i++) {
					if (resultadoQuery.getValueAt(i, "NUM_HIST_GENE") != null && resultadoQuery.getValueAt(i, "VAL_ULTI_NUME_HIST") != null  && !((BigDecimal)resultadoQuery.getValueAt(i, "NUM_HIST_GENE")).equals((BigDecimal)resultadoQuery.getValueAt(i, "VAL_ULTI_NUME_HIST"))) {
						UtilidadesLog.debug("Salida metodo esPosibleModificar: false por valores desiguales Cancelacion-Cuotas");
						return Boolean.valueOf(false);
					}
					if (resultadoQuery.getValueAt(i, "NUM_HIST_GENE") == null ^  resultadoQuery.getValueAt(i, "VAL_ULTI_NUME_HIST") == null) {
						UtilidadesLog.debug("Salida metodo esPosibleModificar: false por valores desiguales Cancelacion-Cuotas");
						return Boolean.valueOf(false);
					}
				}
			}

		///GENERACION_VENCIMIENTO

			//Obtenemos los detalles de la cabecera indicada que tienen un movimiento de cc asociado 
			bs = null;
			parametros = new Vector();
			 
			sQuery = new StringBuffer("SELECT mo.VAL_ULTI_NUME_HIST ");
			sQuery.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC de, CCC_MOVIM_CUENT_CORRI mo, CCC_TIPO_ABONO_SUBPR ta");
			sQuery.append(" WHERE de.MVCC_OID_MOVI_CC = mo.OID_MOVI_CC AND");
			sQuery.append(" de.TASP_OID_TIPO_ABON_SUBP = ta.OID_TIPO_ABON_SUBP AND");
			sQuery.append(" ta.SUBP_OID_SUBP = (SELECT sub.oid_subp FROM CCC_SUBPR sub WHERE ta.subp_oid_subp = sub.oid_subp AND sub.cod_subp = ? )");
			parametros.add(CCCConstantes.GENERACION_VENCIMIENTOS);
			sQuery.append(" AND de.CCAD_OID_CABE_CARG = ? ");
			parametros.add(oid);

			this.loguearSql("esPosibleModificar. SQL GENERACION_VENCIMIENTOS: ", sQuery.toString(), parametros);

			bs = UtilidadesEJB.getBelcorpService();

			// Se ejecuta la consulta
			resultadoQuery = null;
			try {
				resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(),parametros);
			} catch (Exception e) {
				//GEN-0002
				UtilidadesLog.error("**** esPosibleModificar: error ejecutar query ");				
				this.logStackTrace(e);
				throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
			}
			if (!resultadoQuery.esVacio()) {
				//para cada resultado obtenido Si mo.VAL_ULTI_NUME_HIST <> 0, devolvemos false. 
				for(int i = 0; i < resultadoQuery.getRowCount(); i++)
					if (resultadoQuery.getValueAt(i, "VAL_ULTI_NUME_HIST") != null && !((BigDecimal)resultadoQuery.getValueAt(i, "VAL_ULTI_NUME_HIST")).equals(new BigDecimal(0))) {
						UtilidadesLog.debug("Salida metodo esPosibleModificar: false por valores distintos de 0 GENERACION_VENCIMIENTOS");
						return Boolean.valueOf(false);
					}
			}

		///APLICACION_COBROS

			//Obtenemos los detalles de la cabecera indicada que tienen un movimiento de cc asociado 
			bs = null;
			parametros = new Vector();
			 
			sQuery = new StringBuffer("SELECT mb.NUM_HIST, de.NUM_HIST_GENE");
			sQuery.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC de, CCC_MOVIM_BANCA mb,CCC_TIPO_ABONO_SUBPR ta");
			sQuery.append(" WHERE de.CMBA_OID_MOVI_BANC = mb.OID_MOVI_BANC AND");
			sQuery.append(" de.TASP_OID_TIPO_ABON_SUBP = ta.OID_TIPO_ABON_SUBP AND");
			sQuery.append(" ta.SUBP_OID_SUBP = (SELECT sub.oid_subp FROM CCC_SUBPR sub WHERE ta.subp_oid_subp = sub.oid_subp AND sub.cod_subp = ? )");
			parametros.add(CCCConstantes.APLICACION_COBROS);
			sQuery.append(" AND de.CCAD_OID_CABE_CARG = ? ");
			parametros.add(oid);

			this.loguearSql("esPosibleModificar. SQL APLICACION_COBROS: ", sQuery.toString(), parametros);

			bs = UtilidadesEJB.getBelcorpService();

			// Se ejecuta la consulta
			resultadoQuery = null;
			try {
				resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(),parametros);
			} catch (Exception e) {
				//GEN-0002
				UtilidadesLog.error("**** esPosibleModificar: error ejecutar query ");				
				this.logStackTrace(e);
				throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
			}
			if (!resultadoQuery.esVacio()) {
				//para cada resultado obtenido si los movimientos bancarios generados no son los últimos, devolvemos false (si no coinciden el valor de los dos campos) 
				//Si de.NUM_HIST_GENE <> mo.NUMERO_HISTORIA  devolvemos false.
				for(int i = 0; i < resultadoQuery.getRowCount(); i++) {
					if (resultadoQuery.getValueAt(i, "NUM_HIST_GENE") != null && resultadoQuery.getValueAt(i, "NUM_HIST") != null && !((BigDecimal)resultadoQuery.getValueAt(i, "NUM_HIST_GENE")).equals((BigDecimal)resultadoQuery.getValueAt(i, "NUM_HIST"))) {
						UtilidadesLog.debug("Salida metodo esPosibleModificar: false por valores desiguales APLICACION_COBROS");
						return Boolean.valueOf(false);
					}
					if (resultadoQuery.getValueAt(i, "NUM_HIST_GENE") == null ^ resultadoQuery.getValueAt(i, "NUM_HIST") == null) {
						UtilidadesLog.debug("Salida metodo esPosibleModificar: false por valores desiguales Cancelacion-Cuotas");
						return Boolean.valueOf(false);
					}
				}
			}

// *************** VIEJO ************		
		/*
		 * Hacemos un findByPrimaryKey del entity CabeceraCargosAbonosDirectos utilizando el parametro oid. 
		 * Si el atributo fechaContabilización es distinto de null devolvemos false. 
		 

		UtilidadesLog.info("Entrada metodo esPosibleModificar");

        CabeceraCargosAbonosDirectosLocalHome localHome = this.getCabeceraCargosAbonosDirectosLocalHome();
        CabeceraCargosAbonosDirectosLocal local = null;
        try {
            local = localHome.findByPrimaryKey(oid);
        } catch (FinderException fe) {
            //GEN-0007 no existe -->
			UtilidadesLog.error("**** esPosibleModificar: no existe registro ");				
			this.logStackTrace(fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

		if (local.getFechaContabilizacion() != null) {
			UtilidadesLog.info("Salida metodo esPosibleModificar: false por fecha");
			return new Boolean(false);
		}



		if (subproceso != null && subproceso.toString().equals(CCCConstantes.CANCELACION_CUOTAS)) { 
			//Obtenemos los detalles de la cabecera indicada que tienen un movimiento de cc asociado 
			BelcorpService bs = null;

			/* SELECT de.NUM_HIST_GENE, mo.VAL_ULTI_NUME_HIST 
			 * FROM CCC_DETAL_CARGO_ABONO_DIREC de, CCC_MOVIM_CUENT_CORRI mo 
			 * WHERE de.MVCC_OID_MOVI_CC = mo.OID_MOVI_CC 
			 * AND de.CCAD_OID_CABE_CARG = oid 
			 
			StringBuffer sQuery = new StringBuffer("SELECT de.NUM_HIST_GENE, mo.VAL_ULTI_NUME_HIST");
			sQuery.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC de, CCC_MOVIM_CUENT_CORRI mo");
			sQuery.append(" WHERE de.MVCC_OID_MOVI_CC = mo.OID_MOVI_CC");
			sQuery.append(" AND de.CCAD_OID_CABE_CARG = " + oid);

			UtilidadesLog.info("SQL: " + sQuery);

			bs = UtilidadesEJB.getBelcorpService();

			// Se ejecuta la consulta
			RecordSet resultadoQuery = null;
			try {
				resultadoQuery = bs.dbService.executeStaticQuery(sQuery.toString());
			} catch (Exception e) {
				//GEN-0002
				UtilidadesLog.error("**** esPosibleModificar: error ejecutar query ");				
				this.logStackTrace(e);
				throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
			}
			if (!resultadoQuery.esVacio()) {
				//para cada resultado obtenido si no coinciden el valor de los dos campos devolvemos false 
				for(int i = 0; i < resultadoQuery.getRowCount(); i++)
					if (!((BigDecimal)resultadoQuery.getValueAt(i, 0)).equals((BigDecimal)resultadoQuery.getValueAt(i, 1))) {
						UtilidadesLog.info("Salida metodo esPosibleModificar: false por valores desiguales Cancelacion-Cuotas");
						return new Boolean(false);
					}
			}
		} 

		if (subproceso != null && subproceso.toString().equals(CCCConstantes.GENERACION_VENCIMIENTOS)) { 

			//Obtenemos los detalles de la cabecera indicada que tienen un movimiento de cc asociado 
			BelcorpService bs = null;

			/* SELECT mo.VAL_ULTI_NUME_HIST 
			 * FROM CCC_DETAL_CARGO_ABONO_DIREC de, CCC_MOVIM_CUENT_CORRI mo 
			 * WHERE de.MVCC_OID_MOVI_CC = mo.OID_MOVI_CC 
			 * AND de.CCAD_OID_CABE_CARG = oid
			 
			StringBuffer sQuery = new StringBuffer("SELECT mo.VAL_ULTI_NUME_HIST");
			sQuery.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC de, CCC_MOVIM_CUENT_CORRI mo");
			sQuery.append(" WHERE de.MVCC_OID_MOVI_CC = mo.OID_MOVI_CC");
			sQuery.append(" AND de.CCAD_OID_CABE_CARG = " + oid);

			UtilidadesLog.info("SQL: " + sQuery);

			bs = UtilidadesEJB.getBelcorpService();

			// Se ejecuta la consulta
			RecordSet resultadoQuery = null;
			try {
				resultadoQuery = bs.dbService.executeStaticQuery(sQuery.toString());
			} catch (Exception e) {
				//GEN-0002
				UtilidadesLog.error("**** esPosibleModificar: error ejecutar query ");				
				this.logStackTrace(e);
				throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
			}
			if (!resultadoQuery.esVacio()) {
				//para cada resultado obtenido si mo.VAL_ULTI_NUME_HIST es distinto de 0 devolvemos false 
				for(int i = 0; i < resultadoQuery.getRowCount(); i++)
					if (!((BigDecimal)resultadoQuery.getValueAt(i, 0)).equals(new BigDecimal(0))) {
						UtilidadesLog.info("Salida metodo esPosibleModificar: false por valores distintos de 0 GENERACION_VENCIMIENTOS");
						return new Boolean(false);
					}
			}
		} 

		if (subproceso != null && subproceso.toString().equals(CCCConstantes.APLICACION_COBROS)) { 

			//Obtenemos los detalles de la cabecera indicada que tienen un movimiento de cc asociado 
			BelcorpService bs = null;

			/* SELECT mb.NUMERO_HISTORIA 
			 * FROM CCC_DETAL_CARGO_ABONO_DIREC de, CCC_MOVIM_BANCA mb 
			 * WHERE de.CMBA_OID_MOVI_BANC = mb.OID_MOVI_BANC 
			 * AND de.CCAD_OID_CABE_CARG = oid 
			 
			StringBuffer sQuery = new StringBuffer("SELECT de.NUM_HIST_GENE, mb.NUM_HIST");
			sQuery.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC de, CCC_MOVIM_BANCA mb");
			sQuery.append(" WHERE de.CMBA_OID_MOVI_BANC = mb.OID_MOVI_BANC");
			sQuery.append(" AND de.CCAD_OID_CABE_CARG = " + oid);

			UtilidadesLog.info("SQL: " + sQuery);

			bs = UtilidadesEJB.getBelcorpService();

			// Se ejecuta la consulta
			RecordSet resultadoQuery = null;
			try {
				resultadoQuery = bs.dbService.executeStaticQuery(sQuery.toString());
			} catch (Exception e) {
				//GEN-0002
				UtilidadesLog.error("**** esPosibleModificar: error ejecutar query ");				
				this.logStackTrace(e);
				throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
			}
			if (!resultadoQuery.esVacio()) {
				//para cada resultado obtenido si los movimientos bancarios generados no son los últimos, devolvemos false (si no coinciden el valor de los dos campos) 
				for(int i = 0; i < resultadoQuery.getRowCount(); i++)
					if (!((BigDecimal)resultadoQuery.getValueAt(i, 0)).equals((BigDecimal)resultadoQuery.getValueAt(i, 1))) {
						UtilidadesLog.info("Salida metodo esPosibleModificar: false por valores desiguales APLICACION_COBROS");
						return new Boolean(false);
					}
			}
		} 
*/
		UtilidadesLog.debug("Salida metodo esPosibleModificar:  true");
        UtilidadesLog.info("DAOCargosAbonos.esPosibleModificar(Long oid): Salida ");
        return Boolean.valueOf(true);
    }



    /** 
	 * Este método devuelve true si el atributo fechaContabilizacion del registro cuyo oid coincide con el oid recibido es nulo,
	 * en caso contrario devuelve false
     * @param oid Long con el numero identificador del registro
     * @return Boolean 
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontró el registro
     */
	 protected Boolean compruebaContabilizado(Long oid)  throws MareException {

		UtilidadesLog.info("DAOCargosAbonos.compruebaContabilizado(Long oid): Entrada ");

        CabeceraCargosAbonosDirectosLocalHome localHome = this.getCabeceraCargosAbonosDirectosLocalHome();
        CabeceraCargosAbonosDirectosLocal local = null;
        try {
            local = localHome.findByPrimaryKey(oid);
        } catch (NoResultException fe) {
            //GEN-0007 no existe -->
            UtilidadesLog.error("**** compruebaContabilizado: no existe registro ");				
            this.logStackTrace(fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

		if (local.getFechaContabilizacion() != null) {
			UtilidadesLog.debug("Salida metodo compruebaContabilizado: false por fecha");
			return Boolean.valueOf(false);
		}

		UtilidadesLog.debug("Salida metodo compruebaContabilizado:  true");
        UtilidadesLog.info("DAOCargosAbonos.compruebaContabilizado(Long oid): Salida ");
        return Boolean.valueOf(true);
    }

    /** 
     * Este método devuelve el tipo de cargo para gastos abonos de un proceso
     * @param proceso DTOOID con el numero identificador del proceso
     * @return String con el tipo de cargo si se encontró o cadena vacia si no hubo resultados 
     * @exception MareException si no se pudo acceder a la base de datos
     */
	 public String obtieneGlosaContableConceptos(DTOOID proceso)  throws MareException {

		UtilidadesLog.info("DAOCargosAbonos.obtieneGlosaContableConceptos(DTOOID proceso): Entrada ");
		String tipoCargo = "";
		Long subproceso = (new DAOCCC()).obtieneSubproceso(proceso.getOid(), CCCConstantes.CONCEPTOS_GASTOS_ABONOS); 

		/*
		 * Hacemos la siguiente consulta JDBC: 
		 * SELECT tipo.DES_TIPO_CARG_ABON 
		 * FROM CCC_TIPO_CARGO_ABONO tipo, CCC_TIPO_ABONO_SUBPR sub 
		 * WHERE tipo.OID_TIPO_CARG_ABON = sub.TCAB_OID_TCAB AND 
		 * SUBP_OID_SUBP = subproceso 

		 * Devolvemos el valor del primer resultado que obtengamos. 

		 * Si no obtenemos ninguno devolvemos una cadena vacía.
		 */

        BelcorpService bs = null;

        StringBuffer sQuery = new StringBuffer("SELECT");
		sQuery.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'CCC_TIPO_CARGO_ABONO' AND IDIO.idio_oid_idio = " + proceso.getOidIdioma()+" AND "+
                " IDIO.val_oid = tipo.OID_TIPO_CARG_ABON ) AS DES_TIPO_CARGO ");

        sQuery.append(" FROM CCC_TIPO_CARGO_ABONO tipo, CCC_TIPO_ABONO_SUBPR sub");
        sQuery.append(" WHERE tipo.OID_TIPO_CARG_ABON = sub.TCAB_OID_TCAB");
		sQuery.append(" AND SUBP_OID_SUBP =  " + subproceso);

		UtilidadesLog.debug("SQL: " + sQuery);

        bs = UtilidadesEJB.getBelcorpService();

        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        try {
            resultadoQuery = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** obtieneGlosaContableConceptos: error ejecutar query ");				
			this.logStackTrace(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        if (!resultadoQuery.esVacio()) {
			tipoCargo =(String)resultadoQuery.getValueAt(0, 0);
		}

		UtilidadesLog.info("DAOCargosAbonos.obtieneGlosaContableConceptos(DTOOID proceso): Salida ");
        return tipoCargo;
    }

    /** 
     * Este método devuelve todos los detalles de la aplicacion de cargos y abonos indicada para el subproceso de Cancelacion de cuotas 
     * @param cabecera DTOOID con el numero identificador de la cabecera
     * @return RecordSet con el resultado de la consulta
     * @exception MareException si no se pudo acceder a la base de datos
     */
	 public RecordSet obtieneCancelacionCuotas(DTOOID cabecera)  throws MareException {

		UtilidadesLog.info("DAOCargosAbonos.obtieneCancelacionCuotas(DTOOID cabecera): Entrada ");
		/*
		 * Hacemos la siguiente consulta JDBC y devolvemos el resultado: 
		 * (El ampersand & indica que se concatenan los campos) 
		 * SELECT cli.COD_CLIE, mov.VAL_NUME_SERI_CUOT & mov.NUM_IDEN_CUOT, mov.NUM_ORDE_CUOT,
		 * mov.FEC_DOCU, mov.FEC_VENC, mov.MPAB_OID_MEDI_PAGO (Descripcion), mov.IMP_MOVI , 
		 * mov.IMP_PAGA , mov.IMP_PEND, det.MONE_OID_MONE (Descripcion), det.IMP_MONE, det.IMP, 
		 * mov.MPAB_OID_MEDI_PAGO, det.MONE_OID_MONE, mov.OID_MOVI_CC, 
		 * det.OID_DETA_CARG_ABON_DIRE 
		 * FROM CCC_DETAL_CARGO_ABONO_DIREC det, CCC_SUBPR sub, MAE_CLIEN cli, CCC_MOVIM_CUENT_CORRI mov 
		 * WHERE det.CCAD_OID_CABE_CARG = cabecera AND 

		 * //Para el subproceso adecuado 
		 * det.SUBP_OID_SUBP = sub.OID_SUBP AND 
		 * sub.COD_SUBP = CCContantes.CANCELACION_CUOTAS 

		 * AND det.CLIE_OID_CLIE = cli.OID_CLIE 
		 * AND det.MVCC_OID_MOVI_CC = mov.OID_MOVI_CC
		 */

		Long idioma = cabecera.getOidIdioma();
        Vector  parametros = new Vector();

        BelcorpService bs = null;

        StringBuffer sQuery = new StringBuffer("SELECT '', cli.COD_CLIE");
		//* acc.CANA_OID_CANA(Descipcion)
        sQuery.append(", (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'SEG_CANAL' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = acc.CANA_OID_CANA ) AS DES_CANAL ");
        parametros.add(idioma);
		
		 //* acc.OID_ACCE(Descripcion)
        sQuery.append(", (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'SEG_ACCES' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = acc.OID_ACCE ) AS DES_ACCESO ");
        parametros.add(idioma);

		 //* sub.OID_SBAC(Descripcion)
        sQuery.append(", (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'SEG_SUBAC' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = subac.OID_SBAC) AS DES_SUBACCESO ");
        parametros.add(idioma);
		sQuery.append(", mov.val_ejer_cuot||LPAD(mov.num_iden_cuot, 8, 0), mov.NUM_ORDE_CUOT,");
        sQuery.append("  mov.FEC_DOCU, mov.FEC_VENC");

        sQuery.append(",med.cod_medi_pago|| (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'BEL_MEDIO_PAGO' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = mov.MPAB_OID_MEDI_PAGO ) AS DES_MEDIO_PAGO ");
        parametros.add(idioma);
        sQuery.append(", mov.IMP_MOVI, mov.IMP_PAGA , mov.IMP_PEND");
        sQuery.append(", mon.COD_MONE");

        sQuery.append(", det.IMP_MONE, det.IMP, mov.MPAB_OID_MEDI_PAGO, mov.OID_MOVI_CC, det.OID_DETA_CARG_ABON_DIRE");
        sQuery.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC det LEFT JOIN SEG_MONED mon ON (mon.OID_MONE = det.MONE_OID_MONE), MAE_CLIEN cli, CCC_SUBPR sub, CCC_TIPO_ABONO_SUBPR tab, CCC_MOVIM_CUENT_CORRI mov LEFT JOIN BEL_MEDIO_PAGO med ON (med.OID_MEDI_PAGO = mov.MPAB_OID_MEDI_PAGO)");
		sQuery.append(" ,VCA_SEG_ACCES acc, VCA_SEG_SUBAC subac, ccc_cabec_carga_abono_direc cab ");
        sQuery.append(" WHERE det.CCAD_OID_CABE_CARG = ?");
        parametros.add(cabecera.getOid());
		//sQuery.append(" AND det.CLIE_OID_CLIE = cli.OID_CLIE");
		sQuery.append(" AND sub.CCPR_OID_PROC = cab.CCPR_OID_PROC");

		sQuery.append(" AND tab.subp_oid_subp = sub.oid_subp");
		sQuery.append(" AND tab.oid_tipo_abon_subp = det.tasp_oid_tipo_abon_subp");

		sQuery.append(" AND det.ccad_oid_cabe_carg = cab.oid_cabe_carg");
		sQuery.append(" AND subac.OID_SBAC = mov.SBAC_OID_SBAC");
		sQuery.append(" AND subac.ACCE_OID_ACCE = acc.OID_ACCE");
		sQuery.append(" AND sub.COD_SUBP =  ?");
        parametros.add(CCCConstantes.CANCELACION_CUOTAS);
		sQuery.append(" AND cli.OID_CLIE = mov.CLIE_OID_CLIE");
		sQuery.append(" AND det.MVCC_OID_MOVI_CC = mov.OID_MOVI_CC");
		sQuery.append(" AND acc.cod_usua = ? ");
		parametros.add(this.usuario);
		sQuery.append(" AND subac.cod_usua = ? ");
		parametros.add(this.usuario);

		this.loguearSql("obtieneCancelacionCuotas: ", sQuery.toString(), parametros);

        bs = UtilidadesEJB.getBelcorpService();

        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        try {
            resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(), parametros);
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** obtieneCancelacionCuotas: error ejecutar query ");				
			this.logStackTrace(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
		UtilidadesLog.info("DAOCargosAbonos.obtieneCancelacionCuotas(DTOOID cabecera): Salida ");
        return resultadoQuery;
    }



    /** 
     * Este método devuelve todos los detalles de la aplicacion de cargos y abonos indicada para el subproceso de aplicacion de cobros 
     * @param cabecera DTOOID con el numero identificador de la cabecera
     * @return RecordSet con el resultado de la consulta
     * @exception MareException si no se pudo acceder a la base de datos
     */
	 public RecordSet obtieneAplicacionCobros(DTOOID cabecera)  throws MareException {

		UtilidadesLog.info("DAOCargosAbonos.obtieneAplicacionCobros(DTOOID cabecera): Entrada ");
		/*
		 * SELECT so.OID_SOCI(Descripcion), cli.COD_CLIE, det.CCBA_OID_CC_BANC (Descripcion), det.FEC_MOVI, det.IMP ,mov.IMP_PAGO, so.OID_SOCI, det.CMBA_OID_MOVI_BANC, det.OID_DETA_CARG_ABON_DIRE 
		 * FROM CCC_DETAL_CARGO_ABONO_DIREC det, CCC_SUBPR sub, MAE_CLIE cli, CCC_HISTO_MOVIM_BANCA mov, VCA_SEG_SOCIE so 
		 * WHERE det.CCAD_OID_CABE_CARG = cabecera AND 
		 * mov.SOCI_OID_SOCI = so.OID_SOCI AND 
		 * so.COD_USUA = usuario AND 

		 * //Para el subproceso adecuado 
		 * det.SUBP_OID_SUBP = sub.OID_SUBP AND 
		 * sub.COD_SUBP = CCContantes.APLICACION_COBROS 

		 * AND det.CLIE_OID_CLIE = cli.OID_CLIE 
		 * AND det.CMBA_OID_MOVI_BANC = mov.OID_MOVI_BANC 
		 */

		//Long idioma = cabecera.getOidIdioma();
        Vector  parametros = new Vector();

        BelcorpService bs = null;

        StringBuffer sQuery = new StringBuffer("SELECT det.CMBA_OID_MOVI_BANC, cli.COD_CLIE ");
		sQuery.append(", corri.DES_CC AS DES_CUENTA ");
		sQuery.append(", det.FEC_PAGO_BANC, mov.NUM_LOTE, mov.NUM_CONS_TRAN, mov.IMP_PAGO, mov.IMP_SALD_PEND, det.IMP, det.CCBA_OID_CUEN_CORR_BANC, det.CMBA_OID_MOVI_BANC, det.OID_DETA_CARG_ABON_DIRE");
        sQuery.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC det, MAE_CLIEN cli, CCC_CUENT_CORRI_BANCA corri, CCC_SUBPR sub, CCC_TIPO_ABONO_SUBPR tab, CCC_MOVIM_BANCA mov,CCC_CABEC_CARGA_ABONO_DIREC cab");
        sQuery.append(" WHERE det.CCAD_OID_CABE_CARG = ?");
        parametros.add(cabecera.getOid());
		sQuery.append(" AND cab.oid_cabe_carg = det.ccad_oid_cabe_carg");
		sQuery.append(" AND det.CCBA_OID_CUEN_CORR_BANC = corri.OID_CUEN_CORR_BANC");
		sQuery.append(" AND sub.ccpr_oid_proc = cab.ccpr_oid_proc");
		sQuery.append(" AND tab.subp_oid_subp = sub.oid_subp");
		sQuery.append(" AND tab.oid_tipo_abon_subp = det.tasp_oid_tipo_abon_subp");
		sQuery.append(" AND cli.OID_CLIE = mov.CLIE_OID_CLIE");
		sQuery.append(" AND sub.COD_SUBP = ?" );
        parametros.add(CCCConstantes.APLICACION_COBROS);
		sQuery.append(" AND det.CMBA_OID_MOVI_BANC = mov.OID_MOVI_BANC");
		
		this.loguearSql("obtieneAplicacionCobros: ", sQuery.toString(), parametros);

        bs = UtilidadesEJB.getBelcorpService();

        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        try {
            resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(), parametros);
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** obtieneAplicacionCobros: error ejecutar query ");				
			this.logStackTrace(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
		UtilidadesLog.info("DAOCargosAbonos.obtieneAplicacionCobros(DTOOID cabecera): Salida ");
        return resultadoQuery;
    }


    /** 
     * Obtiene los detalles de la aplicacion de cargos y abonos indicada, correspondientes al subproceso de conceptos de gastos y abonos 
     * @param cabecera DTOOID con el numero identificador de la cabecera
     * @return RecordSet con el resultado de la consulta
     * @exception MareException si no se pudo acceder a la base de datos
     */
	 public RecordSet obtieneConceptosGastosAbonos(DTOOID cabecera)  throws MareException {

		UtilidadesLog.info("DAOCargosAbonos.obtieneConceptosGastosAbonos(DTOOID cabecera): Entrada ");
		/*
		 * SELECT cli.COD_CLIE, det.CCBA_OID_CC_BANC (Descripcion), det.VAL_GLOS_CONT, det.FEC_MOVI, det.IMP, det,MONE_OID_MONE(Descripcion), det.IMP_MONE, et.CCBA_OID_CC_BANC, det,MONE_OID_MONE, det.OID_DETA_CARG_ABON_DIRE 
		 * FROM CCC_DETAL_CARGO_ABONO_DIREC det, MAE_CLIE cli, CCC_SUBPR sub 
		 * WHERE det.CLIE_OID_CLIE = cli.OID_CLIE AND 
		 * det.CCAD_OID_CABE_CARG = cabecera AND 

		 * //Para el subproceso adecuado 
		 * det.SUBP_OID_SUBP = sub.OID_SUBP AND 
		 * sub.COD_SUBP = CCContantes.CONCEPTOS_GASTOS_ABONOS
		 */

		Long idioma = cabecera.getOidIdioma();
        Vector  parametros = new Vector();

        BelcorpService bs = null;

        StringBuffer sQuery = new StringBuffer("SELECT '', cli.COD_CLIE");
        sQuery.append(", (SELECT CCB.DES_CC FROM CCC_CUENT_CORRI_BANCA CCB WHERE "+
                " det.CCBA_OID_CUEN_CORR_BANC = CCB.OID_CUEN_CORR_BANC ) AS DES_CUENTA ");
		sQuery.append(", (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'CCC_TIPO_CARGO_ABONO' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = tab.TCAB_OID_TCAB ) AS DES_TIPO_ABONO ");
        parametros.add(idioma);
        sQuery.append(", det.VAL_GLOS_CONT glosaContable ");
        sQuery.append(", mon.COD_MONE ");
        sQuery.append(", det.IMP importe , det.IMP_MONE, det.CCBA_OID_CUEN_CORR_BANC, tab.TCAB_OID_TCAB, det.OID_DETA_CARG_ABON_DIRE oidDetalle ");
        sQuery.append(", cab.FEC_DOCU fechaPago ");        
        sQuery.append(" FROM (CCC_DETAL_CARGO_ABONO_DIREC det LEFT JOIN MAE_CLIEN cli ON (cli.OID_CLIE = det.CLIE_OID_CLIE)) LEFT JOIN SEG_MONED mon ON (mon.OID_MONE = det.MONE_OID_MONE), CCC_SUBPR sub, CCC_TIPO_ABONO_SUBPR tab");
		sQuery.append(" ,CCC_CABEC_CARGA_ABONO_DIREC cab");
        sQuery.append(" WHERE det.CCAD_OID_CABE_CARG = ?");
        parametros.add(cabecera.getOid());
		sQuery.append(" AND cab.oid_cabe_carg = det.ccad_oid_cabe_carg");
		sQuery.append(" AND sub.ccpr_oid_proc = cab.ccpr_oid_proc");
		sQuery.append(" AND tab.subp_oid_subp = sub.oid_subp");
		sQuery.append(" AND tab.oid_tipo_abon_subp = det.tasp_oid_tipo_abon_subp");
		sQuery.append(" AND sub.COD_SUBP =  ?");
        parametros.add(CCCConstantes.CONCEPTOS_GASTOS_ABONOS);

		this.loguearSql("obtieneConceptosGastosAbonos: ", sQuery.toString(), parametros);

        bs = UtilidadesEJB.getBelcorpService();

        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        try {
            resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(), parametros);
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** obtieneConceptosGastosAbonos : error ejecutar query ");				
			this.logStackTrace(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
		UtilidadesLog.info("DAOCargosAbonos.obtieneConceptosGastosAbonos(DTOOID cabecera): Salida ");
        return resultadoQuery;
    }


    /** 
     * Obtiene los detalles de la aplicacion de cargos y abonos indicada, correspondientes al subproceso de conceptos de gastos y abonos 
     * @param cabecera DTOOID con el numero identificador de la cabecera
     * @return RecordSet con el resultado de la consulta
     * @exception MareException si no se pudo acceder a la base de datos
     */
	 public RecordSet obtieneGeneracionVencimientos(DTOOID cabecera)  throws MareException {

		UtilidadesLog.info("DAOCargosAbonos.obtieneGeneracionVencimientos(DTOOID cabecera): Entrada ");
		/*
		 * SELECT cli.COD_CLIE, mov.VAL_NUME_SERI_CUOT & mov.NUM_IDEN_CUOT, mov.NUM_ORDE_CUOT, mov.FEC_DOCU, mov.FEC_VENC, mov.MPAB_OID_MEDI_PAGO (Descripcion), det.IMP, mov.IMP_PAGA , mov.IMP_PEND, det.MONE_OID_MONE (Descripcion),
		 * , det.IMP_MONE, mov.MARC_OID_MARC(Descripcion), det.VAL_OBSE, mov.MPAB_OID_MEDI_PAGO, det.MONE_OID_MONE, marca.OID_MARC, mov.OID_MOVI_CC, det.OID_DETA_CARG_ABON_DIRE 
		 * FROM CCC_DETAL_CARGO_ABONO_DIREC det, CCC_SUBPR sub, MAE_CLIEN cli, CCC_MOVIM_CUENT_CORRI mov, VCA_SEG_MARCA m 
		 * WHERE det.CCAD_OID_CABE_CARG = cabecera AND 
		 * mov.MARC_OID_MARC = m.OID_MARC AND 
		 * m.COD_USUA = usuario AND 

		 * //Para el subproceso adecuado 
		 * det.SUBP_OID_SUBP = sub.OID_SUBP AND 
		 * sub.COD_SUBP = CCContantes.GENERACION_VENCIMIENTOS 

		 * AND det.CLIE_OID_CLIE = cli.OID_CLIE 
		 * AND det.MVCC_OID_MOVI_CC = mov.OID_MOVI_CC 
		 */
		Long idioma = cabecera.getOidIdioma();
        Vector  parametros = new Vector();

        BelcorpService bs = null;

        StringBuffer sQuery = new StringBuffer("SELECT ''");
        sQuery.append(",cli.COD_CLIE ");
		sQuery.append(", m.DES_MARC AS DES_MARCA");
		//* acc.CANA_OID_CANA(Descipcion)
        sQuery.append(", (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'SEG_CANAL' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = acc.CANA_OID_CANA ) AS DES_CANAL ");
        parametros.add(idioma);
		
		 //* acc.OID_ACCE(Descripcion)
        sQuery.append(", (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'SEG_ACCES' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = acc.OID_ACCE ) AS DES_ACCESO ");
        parametros.add(idioma);

		 //* sub.OID_SBAC(Descripcion)
        sQuery.append(", (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'SEG_SUBAC' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = subac.OID_SBAC) AS DES_SUBACCESO ");
        parametros.add(idioma);
        sQuery.append(",mov.val_ejer_cuot||LPAD(mov.num_iden_cuot, 8, 0), mov.val_refe_nume_docu_exte, mov.FEC_VALO, mov.FEC_VENC");
        sQuery.append(",med.COD_MEDI_PAGO|| (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE "+
                " IDIO.attr_enti = 'BEL_MEDIO_PAGO' AND IDIO.idio_oid_idio = ? AND "+
                " IDIO.val_oid = mov.MPAB_OID_MEDI_PAGO ) AS DES_MEDIO_PAGO ");
        parametros.add(idioma);
        sQuery.append(", mon.COD_MONE, det.IMP, det.IMP_MONE");

        sQuery.append(", mov.VAL_OBSE, mov.MPAB_OID_MEDI_PAGO, m.OID_MARC, can.OID_CANA, acc.OID_ACCE, cab.SBAC_OID_SBAC, mov.OID_MOVI_CC, det.OID_DETA_CARG_ABON_DIRE");
        sQuery.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC det LEFT JOIN SEG_MONED mon ON (mon.OID_MONE = det.MONE_OID_MONE), CCC_SUBPR sub, CCC_TIPO_ABONO_SUBPR tab, MAE_CLIEN cli, CCC_MOVIM_CUENT_CORRI mov LEFT JOIN BEL_MEDIO_PAGO med ON (med.OID_MEDI_PAGO = mov.MPAB_OID_MEDI_PAGO), VCA_SEG_MARCA m");
		sQuery.append(" ,VCA_SEG_ACCES acc, VCA_SEG_SUBAC subac,CCC_CABEC_CARGA_ABONO_DIREC cab, VCA_SEG_CANAL can");
        sQuery.append(" WHERE det.CCAD_OID_CABE_CARG = ?");
        parametros.add(cabecera.getOid());
		sQuery.append(" AND sub.ccpr_oid_proc = cab.ccpr_oid_proc");
		sQuery.append(" AND mov.MARC_OID_MARC = m.OID_MARC");
		sQuery.append(" AND m.COD_USUA = ?");
        parametros.add(this.usuario);
		sQuery.append(" AND tab.subp_oid_subp = sub.oid_subp");
		sQuery.append(" AND tab.oid_tipo_abon_subp = det.tasp_oid_tipo_abon_subp");
		sQuery.append(" AND sub.COD_SUBP = ?");
        parametros.add(CCCConstantes.GENERACION_VENCIMIENTOS);
		sQuery.append(" AND det.CLIE_OID_CLIE = cli.OID_CLIE");
		sQuery.append(" AND det.MVCC_OID_MOVI_CC = mov.OID_MOVI_CC");
		sQuery.append(" AND det.ccad_oid_cabe_carg = cab.oid_cabe_carg");
		sQuery.append(" AND subac.OID_SBAC = mov.SBAC_OID_SBAC");
		sQuery.append(" AND subac.ACCE_OID_ACCE = acc.OID_ACCE");
		sQuery.append(" AND acc.CANA_OID_CANA = can.OID_CANA");
		sQuery.append(" AND can.COD_USUA = ? ");
		parametros.add(this.usuario);
		sQuery.append(" AND acc.COD_USUA = ? ");
		parametros.add(this.usuario);
		sQuery.append(" AND subac.COD_USUA = ? ");
		parametros.add(this.usuario);

		this.loguearSql("obtieneGeneracionVencimientos: ", sQuery.toString(), parametros);

        bs = UtilidadesEJB.getBelcorpService();

        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        try {
            resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(), parametros);
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** obtieneGeneracionVencimientos : error ejecutar query ");				
			this.logStackTrace(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
		UtilidadesLog.info("DAOCargosAbonos.obtieneGeneracionVencimientos(DTOOID cabecera): Salida ");
        return resultadoQuery;
    }

    /** 
     * Obtiene los cargos abonos relacionados con una cabecera 
     * @param oid DTOOID con el numero identificador de la cabecera
     * @return DTOCargosAbonos con el resultado de la consulta
     * @exception MareException si no se pudo acceder a la base de datos
     */
	 public  DTOCargosAbonos obtenerCabecera(DTOOID oid)  throws MareException {

		UtilidadesLog.info("DAOCargosAbonos.obtenerCabecera(DTOOID oid): Entrada ");
		/*
		 * SELECT cab.NUM_cabe, cli.COD_CLIE, cab.FEC_DOCU, so.OID_SOCI, cab.VAL_REFE_EXTE, so.OID_SOCI(Descripcion), sub.OID_SBAC, cab.VAL_OBSE, cab.OID_CABE_CARG, cli.OID_CLIE, cab.CCPR_OID_PROC, cab.CCPR_OID_PROC (Descripcion), acc.CANA_OID_CANA , acc.OID_ACCE 
		 * acc.CANA_OID_CANA(Descipcion) , acc.OID_ACCE(Descripcion), sub.OID_SBAC(Descripcion)
		 * FROM CCC_CABEC_CARGA_ABONO_DIREC cab LEFT JOIN MAE_CLIE cli ON (cli.OID_CLIE = cab.CLIE_OID_CLIE), VCA_SEG_SUBAC sub, VCA_SEG_ACCES acc, VCA_SEG_SOCIE so 

		 * WHERE cab.OID_CABE_CARG = oid AND 
		 * cab.SOCI_OID_SOCI = so.OID_SOCI AND 
		 * sub.COD_USUA = usuario AND 
		 * acc.COD_USUA = usuario AND 
		 * so.COD_USUA = usuario AND 

		 * sub.OID_SBAC = cab.SBAC_OID_SBAC AND 
		 * sub.ACCE_OID_ACCE = acc.OID_ACCE
		 */

		Long idioma = oid.getOidIdioma();
        Vector  parametros = new Vector();

        BelcorpService bs = null;

        StringBuffer sQuery = new StringBuffer("");

		sQuery.append(" SELECT cab.NUM_CABE, cab.ANIO, cab.VAL_PERI_MES,  cli.COD_CLIE, cab.FEC_VALO,  cab.FEC_DOCU, so.OID_SOCI, cab.VAL_REFE_EXTE, "); 
		sQuery.append(" so.VAL_DENO AS DES_SOCIEDAD, sub.OID_SBAC, cab.VAL_OBSE, cab.OID_CABE_CARG, cli.OID_CLIE,  proc.OID_PROC , proc.DES_PROC AS DES_PROC, "); 
		sQuery.append(" acc.CANA_OID_CANA , acc.OID_ACCE, ");
		sQuery.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE  IDIO.attr_enti = 'SEG_CANAL' AND IDIO.idio_oid_idio = ? AND  IDIO.val_oid = acc.CANA_OID_CANA ) AS DES_CANAL , ");
		parametros.add(idioma);
		sQuery.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE  IDIO.attr_enti = 'SEG_ACCES' AND IDIO.idio_oid_idio = ? AND  IDIO.val_oid = acc.OID_ACCE ) AS DES_ACCESO ,  ");
		parametros.add(idioma);
		sQuery.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE  IDIO.attr_enti = 'SEG_SUBAC' AND IDIO.idio_oid_idio = ? AND  IDIO.val_oid = sub.OID_SBAC) AS DES_SUBACCESO  "); 
		parametros.add(idioma);
		sQuery.append(" FROM ");
		sQuery.append(" ( ( CCC_CABEC_CARGA_ABONO_DIREC cab LEFT JOIN MAE_CLIEN cli  ON (cli.OID_CLIE = cab.CLIE_OID_CLIE) ) ");
		sQuery.append(" LEFT JOIN SEG_SUBAC sub  ON (sub.OID_SBAC = cab.SBAC_OID_SBAC) ) ");
		sQuery.append(" LEFT JOIN SEG_ACCES acc  ON (sub.ACCE_OID_ACCE = acc.OID_ACCE) ");  
		sQuery.append(" , VCA_SEG_SOCIE so, CCC_PROCE proc ");
		sQuery.append(" WHERE cab.OID_CABE_CARG = ?  ");
		parametros.add(oid.getOid());
		sQuery.append(" AND cab.CCPR_OID_PROC = proc.OID_PROC ");
		sQuery.append(" AND cab.SOCI_OID_SOCI = so.OID_SOCI "); 
		sQuery.append(" AND so.COD_USUA = ?  ");
		parametros.add(this.usuario);
		sQuery.append(" AND  (cab.SBAC_OID_SBAC IS NULL OR  ");
		sQuery.append(" (EXISTS (SELECT * FROM VCA_SEG_SUBAC SS WHERE sub.OID_SBAC = SS.OID_SBAC AND SS.COD_USUA = ?)  ");
		parametros.add(this.usuario);
		sQuery.append(" AND EXISTS(SELECT * FROM VCA_SEG_ACCES AC WHERE acc.OID_ACCE = AC.OID_ACCE AND AC.COD_USUA = ?)  ");
		parametros.add(this.usuario);
		sQuery.append(" AND EXISTS(SELECT * FROM VCA_SEG_CANAL SC WHERE acc.CANA_OID_CANA = SC.OID_CANA AND SC.COD_USUA = ?))) ");
		parametros.add(this.usuario);


		this.loguearSql("obtieneCabecera: ", sQuery.toString(), parametros);

        bs = UtilidadesEJB.getBelcorpService();

        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        try {
            resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(), parametros);
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** obtieneCabecera : error ejecutar query ");				
			this.logStackTrace(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        DTOCargosAbonos dtoCargosAbonos = new DTOCargosAbonos();
		//Con el resultado de la consulta rellenamos los atributos:
		
		Integer entero = null;
		if (resultadoQuery.getValueAt(0, "NUM_CABE") != null)
			entero = new Integer(((BigDecimal)resultadoQuery.getValueAt(0, "NUM_CABE")).intValue());
		dtoCargosAbonos.setNumeroIdentificacion(entero != null?entero:null);   
		dtoCargosAbonos.setCodigoCliente(resultadoQuery.getValueAt(0, "COD_CLIE") != null?(String)resultadoQuery.getValueAt(0, "COD_CLIE"):null);   
		dtoCargosAbonos.setFechaDocumento(resultadoQuery.getValueAt(0, "FEC_DOCU") != null?(java.sql.Date)resultadoQuery.getValueAt(0, "FEC_DOCU"):null);   
		dtoCargosAbonos.setEmpresa(resultadoQuery.getValueAt(0, "OID_SOCI") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0, "OID_SOCI")).longValue()):null);   
		dtoCargosAbonos.setReferenciaExterna(resultadoQuery.getValueAt(0, "VAL_REFE_EXTE") != null?(String)resultadoQuery.getValueAt(0, "VAL_REFE_EXTE"):null);      
		dtoCargosAbonos.setEmpresaDesc(resultadoQuery.getValueAt(0, "DES_SOCIEDAD") != null?(String)resultadoQuery.getValueAt(0, "DES_SOCIEDAD"):null);      
		dtoCargosAbonos.setSubacceso(resultadoQuery.getValueAt(0, "OID_SBAC") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0, "OID_SBAC")).longValue()):null);      
		dtoCargosAbonos.setObservaciones(resultadoQuery.getValueAt(0, "VAL_OBSE") != null?(String)resultadoQuery.getValueAt(0, "VAL_OBSE"):null);         
		dtoCargosAbonos.setOid(resultadoQuery.getValueAt(0, "OID_CABE_CARG") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0, "OID_CABE_CARG")).longValue()):null);         
		dtoCargosAbonos.setOidCliente(resultadoQuery.getValueAt(0, "OID_CLIE") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0, "OID_CLIE")).longValue()):null);            
		dtoCargosAbonos.setProceso(resultadoQuery.getValueAt(0, "OID_PROC") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0, "OID_PROC")).longValue()):null);               
		dtoCargosAbonos.setProcesoDesc(resultadoQuery.getValueAt(0, "DES_PROC") != null?(String)resultadoQuery.getValueAt(0, "DES_PROC"):null);         
		dtoCargosAbonos.setCanal(resultadoQuery.getValueAt(0, "CANA_OID_CANA") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0, "CANA_OID_CANA")).longValue()):null);                  
		dtoCargosAbonos.setAcceso(resultadoQuery.getValueAt(0, "OID_ACCE") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0, "OID_ACCE")).longValue()):null);                  
		dtoCargosAbonos.setCanalDesc(resultadoQuery.getValueAt(0, "DES_CANAL") != null?(String)resultadoQuery.getValueAt(0, "DES_CANAL"):null);         
		dtoCargosAbonos.setAccesoDesc(resultadoQuery.getValueAt(0, "DES_ACCESO") != null?(String)resultadoQuery.getValueAt(0, "DES_ACCESO"):null);         
		dtoCargosAbonos.setSubaccesoDesc(resultadoQuery.getValueAt(0, "DES_SUBACCESO") != null?(String)resultadoQuery.getValueAt(0, "DES_SUBACCESO"):null);         
		dtoCargosAbonos.setAnio(resultadoQuery.getValueAt(0, "ANIO") != null?new Integer(((String)resultadoQuery.getValueAt(0, "ANIO"))):null);
		dtoCargosAbonos.setMes(resultadoQuery.getValueAt(0, "VAL_PERI_MES") != null?new Integer(((String)resultadoQuery.getValueAt(0, "VAL_PERI_MES"))):null);
		dtoCargosAbonos.setFechaValor(resultadoQuery.getValueAt(0, "FEC_VALO") != null?(java.sql.Date)resultadoQuery.getValueAt(0, "FEC_VALO"):null);
		
		// No sé por qué figuraba esto en el código. Según el diseño, no hay que rellenarlo.
		/*dtoCargosAbonos.setAnio(resultadoQuery.getValueAt(0,"ANIO") != null?(Integer)resultadoQuery.getValueAt(0,"ANIO"):null);
		dtoCargosAbonos.setMes(resultadoQuery.getValueAt(0,"VAL_PERI_MES") != null?(Integer)resultadoQuery.getValueAt(0,"VAL_PERI_MES"):null);
		dtoCargosAbonos.setNumeroLoteCont(resultadoQuery.getValueAt(0,"VAL_NUME_LOTE_CONT") != null?(String)resultadoQuery.getValueAt(0,"VAL_NUME_LOTE_CONT"):null);
		dtoCargosAbonos.setFechaValor(resultadoQuery.getValueAt(0,"FEC_VALO") != null?(Date)resultadoQuery.getValueAt(0,"FEC_VALO"):null);
		dtoCargosAbonos.setFechaCont(resultadoQuery.getValueAt(0,"FEC_CONT") != null?(Date)resultadoQuery.getValueAt(0,"FEC_CONT"):null);
		dtoCargosAbonos.setCodigoUsuario(resultadoQuery.getValueAt(0,"COD_USUA") != null?(String)resultadoQuery.getValueAt(0,"COD_USUA"):null);
		dtoCargosAbonos.setFechaDocuDesde(resultadoQuery.getValueAt(0,"FEC_DOCU_DESD") != null?(Date)resultadoQuery.getValueAt(0,"FEC_DOCU_DESD"):null);
		dtoCargosAbonos.setFechaDocuHasta(resultadoQuery.getValueAt(0,"FEC_DOCU_HAST") != null?(Date)resultadoQuery.getValueAt(0,"FEC_DOCU_HAST"):null);
		dtoCargosAbonos.setFechaVtoDesde(resultadoQuery.getValueAt(0,"FEC_VENC_DESD") != null?(Date)resultadoQuery.getValueAt(0,"FEC_VENC_DESD"):null);
		dtoCargosAbonos.setFechaVtoHasta(resultadoQuery.getValueAt(0,"FEC_VENC_HAST") != null?(Date)resultadoQuery.getValueAt(0,"FEC_VENC_HAST"):null);
		dtoCargosAbonos.setCodigoClienteDesde(resultadoQuery.getValueAt(0,"COD_CLIE_DESD") != null?(String)resultadoQuery.getValueAt(0,"COD_CLIE_DESD"):null);
		dtoCargosAbonos.setCodigoClienteHasta(resultadoQuery.getValueAt(0,"COD_CLIE_HAST") != null?(String)resultadoQuery.getValueAt(0,"COD_CLIE_HAST"):null);
		dtoCargosAbonos.setCodigoPeriodoDesde(resultadoQuery.getValueAt(0,"COD_PERI_DESD") != null?(String)resultadoQuery.getValueAt(0,"COD_PERI_DESD"):null);
		dtoCargosAbonos.setCodigoPeriodoHasta(resultadoQuery.getValueAt(0,"COD_PERI_HAST") != null?(String)resultadoQuery.getValueAt(0,"COD_PERI_HAST"):null);
		dtoCargosAbonos.setOidCuentaCorriente(resultadoQuery.getValueAt(0,"CCBA_OID_CUEN_CORR_BANC") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0,"CCBA_OID_CUEN_CORR_BANC")).longValue()):null);
		dtoCargosAbonos.setOidTipoAbonoSubproceso(resultadoQuery.getValueAt(0,"TASP_OID_TIPO_ABON_SUBP") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0,"TASP_OID_TIPO_ABON_SUBP")).longValue()):null);
		dtoCargosAbonos.setOidSituacionIncobrable(resultadoQuery.getValueAt(0,"SIIN_OID_SITU_INCO") != null?new Long(((BigDecimal)resultadoQuery.getValueAt(0,"SIIN_OID_SITU_INCO")).longValue()):null);
		*/
		UtilidadesLog.info("DAOCargosAbonos.obtenerCabecera(DTOOID oid): Salida ");
        return dtoCargosAbonos;
    }
    /** 
     * Este método devuelve todos los detalles de la aplicacion de cargos y abonos 
     * @param cabecera Long con el numero identificador de la cabecera
     * @return RecordSet con el resultado de la consulta
     * @exception MareException si no se pudo acceder a la base de datos
     */
	 public RecordSet obtenerDetallesCargoAbono(Long cabecera)  throws MareException {

		UtilidadesLog.info("DAOCargosAbonos.obtenerDetallesCargoAbono(Long cabecera): Entrada ");
		/*SELECT d.OID_DETA_CARG_ABON_DIRE, d.MVCC_OID_MOVI_CC, d.NUM_HIST_GENE,
				d.CMBA_OID_MOVI_BANC, s.COD_SUBP
				FROM CCC_DETAL_CARGO_ABONO_DIREC d, CCC_SUBPR s
				WHERE d.CCAD_OID_CABE_CARG = cabecera 
					  AND d.SUBP_OID_SUBP = s.OID_SUBP*/
        Vector  parametros = new Vector();
		parametros.add(cabecera);
        BelcorpService bs = null;

        StringBuffer sQuery = new StringBuffer("");
		sQuery.append("SELECT d.OID_DETA_CARG_ABON_DIRE, d.MVCC_OID_MOVI_CC, d.NUM_HIST_GENE,");
        sQuery.append("d.CMBA_OID_MOVI_BANC, s.COD_SUBP ");
		sQuery.append("FROM CCC_DETAL_CARGO_ABONO_DIREC d, CCC_SUBPR s, CCC_TIPO_ABONO_SUBPR t ");
		sQuery.append("WHERE d.CCAD_OID_CABE_CARG = ? ");
		sQuery.append(" AND d.TASP_OID_TIPO_ABON_SUBP = t.OID_TIPO_ABON_SUBP");
		sQuery.append(" AND t.SUBP_OID_SUBP = s.OID_SUBP");

		this.loguearSql("obtenerDetallesCargoAbono: ", sQuery.toString(), parametros);

        bs = UtilidadesEJB.getBelcorpService();

        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        try {
            resultadoQuery = bs.dbService.executePreparedQuery(sQuery.toString(), parametros);
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** obtenerDetallesCargoAbono: error ejecutar query ");				
			this.logStackTrace(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
		UtilidadesLog.info("DAOCargosAbonos.obtenerDetallesCargoAbono(Long cabecera): Salida ");
        return resultadoQuery;
    }


    /** 
     * Método para obtener el mayor número de orden del numero de documento de entrada
     * @param dto DTONumeroDocumento con el numero de documento
     * @return DTONumeroOrden con el número de orden (-1 si no localiza el numero de documento de entrada)
     * @exception MareException si no se pudo acceder a la base de datos 
     */
	 public DTONumeroOrden mayorNumeroOrden(DTONumeroDocumento dto)  throws MareException {
		/*
			SELECT MAX( NUM_ORDE_CUOT) 
			FROM 
			  CCC_MOVIM_CUENT_CORRI
			WHERE 
			  VAL_EJER_CUOT+NUM_IDEN_CUOT  = dtoDoc.numeroDocumento

			Creamos un DTONumeroOrden y le asignamos el valor recuperado en la select.
			Si no localiza registros asignamos -1 al DTONumeroOrden.

			Devolvemos el DTONumeroOrden creado.
		 */

		UtilidadesLog.info("DAOCargosAbonos.mayorNumeroOrden(DTONumeroDocumento dto): Entrada ");
		DTONumeroOrden resultado = new DTONumeroOrden();
        String numero = dto.getNumeroDocumento();
        
        ;
    
    
        StringBuffer sQuery = new StringBuffer("");		
	
		sQuery.append(" SELECT MAX( NUM_ORDE_CUOT) ");
        sQuery.append(" FROM CCC_MOVIM_CUENT_CORRI ");
        
        sQuery.append(" WHERE VAL_EJER_CUOT='"+ numero.substring(0,2) +"' ");
        sQuery.append(" AND NUM_IDEN_CUOT = " +new Long(numero.substring(2)).toString());
        
        //sQuery.append(" WHERE (VAL_EJER_CUOT||LPAD(NUM_IDEN_CUOT, 8, 0) = ?) ");
		//parametros.add(dto.getNumeroDocumento());
		
		//this.loguearSql("mayorNumeroOrden. SQL: ", sQuery.toString(), parametros);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        // Se ejecuta la consulta
        RecordSet resultadoQuery = null;
        String codigoError = null;
        try {
            resultadoQuery = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
            //GEN-0002
			UtilidadesLog.error("**** mayorNumeroOrden: error ejecutar query ");				
			this.logStackTrace(e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		if (!resultadoQuery.esVacio() && resultadoQuery.getValueAt(0, 0) != null) {
			resultado.setNumeroOrden(new Integer(((BigDecimal)resultadoQuery.getValueAt(0, 0)).intValue()));
		} else {
				UtilidadesLog.debug("mayorNumeroOrden: no hay datos ");				
				resultado.setNumeroOrden(new Integer(-1));
		}
        
 		UtilidadesLog.info("DAOCargosAbonos.mayorNumeroOrden(DTONumeroDocumento dto): Salida ");
        return resultado;
    }


    public RecordSet getSubProcesos(Long subProceso) throws MareException    {
      
      RecordSet salida = null;
      StringBuffer sQuery = new StringBuffer("");
      sQuery.append("SELECT OID_TIPO_ABON_SUBP, SUBP_OID_SUBP, CUCO_OID_CUEN_CONT, TCAB_OID_TCAB FROM CCC_TIPO_ABONO_SUBPR ");
      sQuery.append("WHERE SUBP_OID_SUBP = "+subProceso.toString());
      
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
            salida = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }
      return salida;
    }

    public RecordSet getMarcaTipoAbono(Long oidMarcaTipoAbono) throws MareException  {
      RecordSet salida = null;
      StringBuffer sQuery = new StringBuffer("");
      
      sQuery.append("SELECT OID_MARC_TIPO_ABON, TASP_OID_TIPO_ABON_SUBP, MASI_OID_MARC_SALI, VAL_OBSE, IND_ENTR_SALI FROM CCC_MARCA_TIPO_ABONO ");
      sQuery.append("WHERE TASP_OID_TIPO_ABON_SUBP = "+oidMarcaTipoAbono.toString());
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      try {
        salida = bs.dbService.executeStaticQuery(sQuery.toString());
      } catch (Exception e) {
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
      }
      return salida;
    }


    /**
    * Retorna true si existe el numero de documento para el pais dado.
    * @autor gdmarzi
    */
    public boolean existeNumeroDocumento(DTOValidarNumeroDocumento dto) throws MareException  {
        UtilidadesLog.info("DAOCargosAbonos.existeNumeroDocumento() Entrada");
        RecordSet rs;
        boolean existeNumeroDocumento;
        StringBuffer sQuery = new StringBuffer();
        // Nota: sc.VAL_NUME_SOLI es igual a mcc.VAL_EJER_CUOT++mcc.NUM_IDEN_CUOT
        sQuery.append(" SELECT sc.OID_SOLI_CABE, sc.VAL_NUME_SOLI ");
        sQuery.append(" FROM PED_SOLIC_CABEC sc  ");
        sQuery.append(" WHERE sc.PAIS_OID_PAIS = " + dto.getOidPais());
        sQuery.append(" AND sc.VAL_NUME_SOLI = '" + dto.getNumeroDocumento().toString() + "'");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }
        existeNumeroDocumento = ! rs.esVacio();
        UtilidadesLog.info("DAOCargosAbonos.existeNumeroDocumento() Salida");
        return existeNumeroDocumento;
    }


    /**
    * Retorna true si el numero de documento, pertenece al cliente para el pais dado.
    * @autor gdmarzi
    */
    public boolean numeroDocumentoPerteneceCliente(DTOValidarNumeroDocumento dto) throws MareException  {
        UtilidadesLog.info("DAOCargosAbonos.existeNumeroDocumentoCliente() Entrada");
        RecordSet rs;
        boolean numeroDocumentoPerteneceCliente;
        StringBuffer sQuery = new StringBuffer();
        // Nota: sc.VAL_NUME_SOLI es igual a mcc.VAL_EJER_CUOT++mcc.NUM_IDEN_CUOT
        sQuery.append(" SELECT sc.OID_SOLI_CABE, sc.VAL_NUME_SOLI, cl.COD_CLIE ");
        sQuery.append(" FROM PED_SOLIC_CABEC sc, mae_clien cl ");
        sQuery.append(" WHERE sc.PAIS_OID_PAIS = " + dto.getOidPais());
        sQuery.append(" AND sc.VAL_NUME_SOLI = '" + dto.getNumeroDocumento().toString() + "' ");
        sQuery.append(" AND sc.CLIE_OID_CLIE = cl.OID_CLIE ");
        sQuery.append(" AND cl.COD_CLIE = '" + dto.getCodigoCliente() + "' ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }
        numeroDocumentoPerteneceCliente = ! rs.esVacio();
        UtilidadesLog.info("DAOCargosAbonos.existeNumeroDocumentoCliente() Salida");
        return numeroDocumentoPerteneceCliente;
    }



    public RecordSet getMarcaTipoAbonoEoS(Long oidMarcaTipoAbono, String EoS) throws MareException  {
      RecordSet salida = null;
      StringBuffer sQuery = new StringBuffer("");
      
      sQuery.append("SELECT OID_MARC_TIPO_ABON, TASP_OID_TIPO_ABON_SUBP, MASI_OID_MARC_SALI, VAL_OBSE, IND_ENTR_SALI FROM CCC_MARCA_TIPO_ABONO ");
      sQuery.append("WHERE TASP_OID_TIPO_ABON_SUBP = "+oidMarcaTipoAbono.toString() );
      sQuery.append(" AND IND_ENTR_SALI = '"+ EoS + "'");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      try {
        salida = bs.dbService.executeStaticQuery(sQuery.toString());
      } catch (Exception e) {
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
      }
      return salida;
    }


    /** para obtener la LocalHome del Entity CabeceraCargosAbonosDirectos */
    private CabeceraCargosAbonosDirectosLocalHome getCabeceraCargosAbonosDirectosLocalHome()
        throws MareException {
        UtilidadesLog.info("DAOCargosAbonos.getCabeceraCargosAbonosDirectosLocalHome(): Entrada ");        
        UtilidadesLog.info("DAOCargosAbonos.getCabeceraCargosAbonosDirectosLocalHome(): Salida ");
        return new CabeceraCargosAbonosDirectosLocalHome();
    }

	private void logStackTrace(Throwable e) {
		try{
			UtilidadesLog.error("Se produjo la excepcion: " + e.getMessage());
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			//e.printStackTrace(out);
            UtilidadesLog.error(out.toString());
			UtilidadesLog.error("stack Trace : " +  pila.toString());
		}catch(Exception ex){
			UtilidadesLog.error("Eror Logeando Pila: "+ex.getMessage());
		}
	}

/*
	private Log getLog() {
		Log log = null;
		try {
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());
		} catch (Exception e) {
			e.printStackTrace();			
			throw new RuntimeException ("No se pudo obtener el objeto Log");
		}
	}  
*/
	
	private void loguearSql(String metodo, String sql, Vector params){
		UtilidadesLog.debug(metodo + sql);
		if (params != null && params.size() > 0) {
			String sParams="";
			for (int i=0; i<params.size();i++) {
				sParams += "param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
		
	}
	
	   
  /**
   * DBLG700000038 - gPineda - 17/10/06
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOOID con el oid de la cabecera   
   */
  public DTOCargosAbonos getCabeceraByMoviemientoCuenta( DTOMovimientoCuentaCompleto dto ) throws MareException
  {
    DTOCargosAbonos salida = null;
    StringBuffer query = new StringBuffer("");
    
    query.append( " SELECT CAB.OID_CABE_CARG, CAB.NUM_CABE ");
    query.append( " FROM CCC_CABEC_CARGA_ABONO_DIREC CAB " );
    query.append( " WHERE CAB.PAIS_OID_PAIS = " + dto.getOidPais() );
    query.append( "   AND CAB.SOCI_OID_SOCI = " + dto.getEmpresa() );
    query.append( "   AND CAB.VAL_NUME_LOTE_FACT = '" + dto.getNumeroLoteFactu() +"' " );
    
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    try {
      RecordSet rs = bs.dbService.executeStaticQuery(query.toString());
      
      if( ! rs.esVacio() ) {
        salida = new DTOCargosAbonos();
        salida.setOid(rs.getValueAt(0, "OID_CABE_CARG") != null?new Long(((BigDecimal)rs.getValueAt(0, "OID_CABE_CARG")).longValue()):null);         
        Integer entero = null;
        if (rs.getValueAt(0, "NUM_CABE") != null)
          entero = new Integer(((BigDecimal)rs.getValueAt(0, "NUM_CABE")).intValue());
        salida.setNumeroIdentificacion(entero != null?entero:null);   
      }
      
    } catch (Exception e) {
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
    }
    
    return salida;
  }


    /**
     * Retorna el formate de fecha segun el pais.
     */
    public String obtenerFormatoFechaPais(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOCargosAbonos.obtenerFormatoFechaPais() Entrada");
        RecordSet rs;
        StringBuffer sQuery = new StringBuffer();
        sQuery.append(" select val_form_fech from seg_pais p ");
        sQuery.append(" where p.oid_pais = " + oidPais);
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
          rs = bs.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));  
        }
				String formatoFecha = rs.getValueAt(0,"VAL_FORM_FECH").toString();
        formatoFecha = formatoFecha.replace('a','y');
        formatoFecha = formatoFecha.replace('m','M');
        UtilidadesLog.info("DAOCargosAbonos.obtenerFormatoFechaPais() Salida");
        return formatoFecha;
    }

}