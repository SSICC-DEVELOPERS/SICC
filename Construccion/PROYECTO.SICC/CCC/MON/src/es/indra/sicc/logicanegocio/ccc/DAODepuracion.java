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
import es.indra.sicc.dtos.ccc.DTOBuscarLotes;
import es.indra.sicc.dtos.ccc.DTOConsultarDepuracion;
import es.indra.sicc.dtos.ccc.DTOClienteBloqueo;
import es.indra.sicc.dtos.ccc.DTOOIDPAG;
import es.indra.sicc.logicanegocio.ccc.DAOCCC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Vector;

public class DAODepuracion  {
	private String usuario;

	// Nombres de los MONs
    //private final static String MON_MANTENIMIENTO_SEG = "MONMantenimientoSEG";
	
	public DAODepuracion(String usuario) {
		this.usuario = usuario;
	}
/*	Eliminado por incidencia BELC300010254
// ----------- inicio del nuevo INCIDENCIA 9128
	public DTONumeroDepuracion obtenerSiguienteNumeroDepuracion(DTOConfigSecuencial dto) throws MareException {
		UtilidadesLog.info("*** Método obtenerSiguienteNumeroDepuracion: Entrada ***");
		Long pais = dto.getOidPais();
		Long idioma = dto.getOidIdioma();
		RecordSet rs = null;
	//-------------------- SOBRA ---------
	/*
		//Llamamos al método recuperarPais de IServicioSEG pasandole el pais
		DTOOID dtoOID = new DTOOID();
		dtoOID.setOid(pais);
		dtoOID.setOidIdioma(idioma);
		MONMantenimientoSEG seg = this.getISEG();

		DTOSalida dtoSalida = null;
		try {		
			dtoSalida = seg.recuperarPais(dtoOID);
		} catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logError("obtenerSiguienteNumeroDepuracion: RemoteException",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }

		// Se obtiene el campo VAL_CONF_SECU_CCC de la primera fila del recordset
		RecordSet rs = dtoSalida.getResultado();
		int columna = rs.getColumnPosition("VAL_CONF_SECU_CCC");
		String tipo = (String)rs.getRow(0).elementAt(columna);

		char tipoSecuencial = tipo.charAt(0);
	*
	//-------------------- HASTA AQUI

	
		// Se obtienen los dos ultimos digitos del año y los dos 
		// digitos del mes
		java.util.Date fechaActual = new java.util.Date(System.currentTimeMillis());
		String anyo = null;
		String mes = null;
		try {
			anyo = UtilidadesFecha.convertirAString(fechaActual,"yy");
			mes = UtilidadesFecha.convertirAString(fechaActual,"MM");
		} catch (ParseException e)  {
			this.logError("obtenerSiguienteNumeroDepuracion: ParseException",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));		
		}

		// Se crea la consulta SQL
		// Ver incidencia 3335
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT MAX(NUM_CABE) ");
		consulta.append("FROM CCC_CABEC_CARGA_ABONO_DIREC ");

		// Parametros de la consulta
		Vector parametros = new Vector();

		switch (dto.getIndicadorConfigSec().charValue()) {
			case 'U':
				consulta.append("WHERE PAIS_OID_PAIS = ? "); 
				parametros.add(pais);
				break;
			case 'A':
				consulta.append("GROUP BY ANIO, PAIS_OID_PAIS ");
				consulta.append("HAVING PAIS_OID_PAIS = ? AND ");
				consulta.append("ANIO = ? ");
				parametros.add(pais);
				parametros.add(anyo);
				break;
			case 'M':
				consulta.append("GROUP BY ANIO, VAL_PERI_MES, PAIS_OID_PAIS ");
				consulta.append("HAVING PAIS_OID_PAIS = ? AND ");
				consulta.append("ANIO = ? AND ");
				consulta.append("VAL_PERI_MES = ? ");
				parametros.add(pais);
				parametros.add(anyo);
				parametros.add(mes);
				break;
		}

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerSiguienteNumeroDepuracion: Exception",e);
			this.logSql("obtenerSiguienteNumeroDepuracion. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		// Si la consulta nos devuelve un número le sumamos 1 y devolvemos el resultado 
		// si no devolvemos un 1. 
		Integer resultado = null;
		if (!rs.esVacio()) {
			if (rs.getValueAt(0,0)!=null) {
				resultado = new Integer(((BigDecimal)rs.getValueAt(0,0)).intValue()+1);
			} else {
				resultado = new Integer(1);
			}
			
		}else{
			resultado = new Integer(1);
		}
		DTONumeroDepuracion dtoNumero = new DTONumeroDepuracion();
		dtoNumero.setNumeroDepuracion(resultado);
		UtilidadesLog.info("*** Método obtenerSiguienteNumeroDepuracion: Salida ***");
		return dtoNumero;
	}
//-------------------- fin del nuevo
*/


	public DTOOIDs obtenerLineasDetalle(Long oid) throws MareException {
		
        UtilidadesLog.info("DAODepuracion.obtenerLineasDetalle(Long oid): Entrada");

		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT OID_DETA_CARG_ABON_DIRE ");
		consulta.append("FROM CCC_DETAL_CARGO_ABONO_DIREC ");
		consulta.append("WHERE CCAD_OID_CABE_CARG = ? ");

		// Parametros de la consulta
		Vector parametros = new Vector();
		parametros.add(oid);

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerLineasDetalle: Exception",e);
			this.logSql("obtenerLineasDetalle. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		Long oids[] = null;
		if (!rs.esVacio()) {
			oids = new Long[rs.getRowCount()];
			for (int i=0; i < rs.getRowCount(); i++) {
				Vector fila = rs.getRow(i);
				oids[i] = new Long(((BigDecimal)fila.elementAt(0)).longValue());
			}
		}

		// Se crea un DTOOIDs y se rellena con los registros obtenidos. Si no se obtiene 
		// ningún registro se devuelve el DTOOIDs con un array vacio.
		DTOOIDs dto = new DTOOIDs();
		dto.setOids(oids);
		
		UtilidadesLog.info("DAODepuracion.obtenerLineasDetalle(Long oid): Salida");
		return dto;
	}

	public DTOConsultarDepuracion obtenerDetalleDepuracion(DTOOIDPAG dto) throws MareException {
		
        UtilidadesLog.info("DAODepuracion.obtenerDetalleDepuracion(DTOOIDPAG dto): Entrada");
		StringBuffer consulta = new StringBuffer();
		/* quitado por la incidencia 8813
		consulta.append(" SELECT cabe.OID_CABE_CARG, cabe.NUM_CABE, cabe.ANIO, cabe.VAL_PERI_MES,  ");
		consulta.append(" cabe.CLIE_OID_CLIE, cabe.VAL_NUME_LOTE_CONT, cabe.FEC_VALO, cabe.FEC_CONT, ");
		consulta.append(" cabe.FEC_DOCU, cabe.VAL_REFE_EXTE, cabe.VAL_OBSE, cabe.PAIS_OID_PAIS, ");
		consulta.append(" soc.VAL_DENO, "); 
		consulta.append(" can.COD_CANA, ");
		consulta.append(" ac.COD_ACCE, ");
		consulta.append(" sub.COD_SBAC, ");
		consulta.append(" cabe.COD_USUA, cabe.FEC_DOCU_DESD, cabe.FEC_DOCU_HAST, ");
		consulta.append(" cabe.FEC_VENC_DESD, cabe.FEC_VENC_HAST, cabe.COD_CLIE_DESD, cabe.COD_CLIE_HAST, ");
		consulta.append(" cabe.COD_PERI_DESD, cabe.COD_PERI_HAST, cabe.TASP_OID_TIPO_ABON_SUBP, ");

		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = cabe.SIIN_OID_SITU_INCO AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'CCC_SITUA_INCOB') AS DESC_SITU_INCO, ");

		consulta.append(" COUNT(deta.OID_DETA_CARG_ABON_DIRE) AS TOTALREGSCABECERA, ");
		consulta.append(" SUM(deta.IMP) AS IMPORTETOTALCABECERA ");
		
		consulta.append(" FROM CCC_CABEC_CARGA_ABONO_DIREC cabe LEFT JOIN CCC_DETAL_CARGO_ABONO_DIREC deta ON ");
		consulta.append(" cabe.OID_CABE_CARG = deta.CCAD_OID_CABE_CARG, ");
		consulta.append(" SEG_SOCIE soc, SEG_ACCES ac, SEG_CANAL can, SEG_SUBAC sub ");

		consulta.append(" WHERE ");
		consulta.append(" cabe.SOCI_OID_SOCI=soc.OID_SOCI ");
		consulta.append(" AND cabe.SBAC_OID_SBAC = sub.OID_SBAC ");
		consulta.append(" AND sub.ACCE_OID_ACCE = ac.OID_ACCE ");
		consulta.append(" AND ac.CANA_OID_CANA=can.OID_CANA ");
		consulta.append(" AND cabe.OID_CABE_CARG= ? ");

		consulta.append("GROUP BY cabe.OID_CABE_CARG, cabe.NUM_CABE, cabe.ANIO, cabe.VAL_PERI_MES, ");
		consulta.append(" cabe.CLIE_OID_CLIE, cabe.VAL_NUME_LOTE_CONT, cabe.FEC_VALO, cabe.FEC_CONT, ");
		consulta.append(" cabe.FEC_DOCU, cabe.VAL_REFE_EXTE, cabe.VAL_OBSE, cabe.PAIS_OID_PAIS, ");
		consulta.append(" soc.VAL_DENO, can.COD_CANA, ac.COD_ACCE,  sub.COD_SBAC, ");
		consulta.append(" cabe.COD_USUA, cabe.FEC_DOCU_DESD, cabe.FEC_DOCU_HAST, ");
		consulta.append(" cabe.FEC_VENC_DESD, cabe.FEC_VENC_HAST, cabe.COD_CLIE_DESD, cabe.COD_CLIE_HAST, ");
		consulta.append(" cabe.COD_PERI_DESD, cabe.COD_PERI_HAST, cabe.TASP_OID_TIPO_ABON_SUBP, ");
		consulta.append(" cabe.SIIN_OID_SITU_INCO ");
  
  
		Long idioma=dto.getOidIdioma();
		Vector parametros = new Vector();
		parametros.add(idioma);
		//parametros.add(this.usuario);
		//parametros.add(this.usuario);
		//parametros.add(this.usuario);
		//parametros.add(this.usuario);
		parametros.add(dto.getOid());

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerDetalleDepuracion: Exception",e);
			this.logSql("obtenerDetalleDepuracion. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		//Construimos un DTOConsultarDepuracion con los datos obtenidos de la CabeceraCargoAbonosDirectos 
		//y del DetalleCargosAbonosDirectos. 
	
		DTOConsultarDepuracion dtoConsultar=new DTOConsultarDepuracion();
		//new Long(((BigDecimal)resultadoQuery.getValueAt(0, "OID_SOCI")).longValue())
		dtoConsultar.setOidCabecera(new Long(((BigDecimal)rs.getValueAt(0,"OID_CABE_CARG")).longValue()));
		dtoConsultar.setNumero(new Integer(((BigDecimal)rs.getValueAt(0,"NUM_CABE")).intValue()));
		dtoConsultar.setAnio(rs.getValueAt(0,"ANIO").toString());
		dtoConsultar.setMes(rs.getValueAt(0,"VAL_PERI_MES").toString());
		dtoConsultar.setFechaImputacion((Date)rs.getValueAt(0,"FEC_DOCU"));
		if (rs.getValueAt(0,"DESC_SITU_INCO")!=null) {
			dtoConsultar.setSituacion(rs.getValueAt(0,"DESC_SITU_INCO").toString());
		}
		dtoConsultar.setEmpresa(rs.getValueAt(0,"VAL_DENO").toString());
		dtoConsultar.setCanal(rs.getValueAt(0,"COD_CANA").toString());
		dtoConsultar.setAcceso(rs.getValueAt(0,"COD_ACCE").toString());
		dtoConsultar.setSubAcceso((String)rs.getValueAt(0,"COD_SBAC"));
		dtoConsultar.setNumeroRegistrosDelNumero(new Integer(((BigDecimal)rs.getValueAt(0,"NUM_REG")).intValue()));
		dtoConsultar.setImporteRegistrosDelNumero((BigDecimal)rs.getValueAt(0,"IMPORTE_TOTAL"));
		
		if (rs.getValueAt(0,"VAL_REFE_EXTE")!=null) {
			dtoConsultar.setReferencia(rs.getValueAt(0,"VAL_REFE_EXTE").toString());
		}
		if (rs.getValueAt(0,"COD_CLIE_DESD")!=null) {
			dtoConsultar.setClienteDesde(rs.getValueAt(0,"COD_CLIE_DESD").toString());
		}
		
		if (rs.getValueAt(0,"COD_CLIE_HAST")!=null) {
			dtoConsultar.setClienteHasta(rs.getValueAt(0,"COD_CLIE_HAST").toString());
		}
		
		if (rs.getValueAt(0,"FEC_VENC_DESD")!=null) {
			dtoConsultar.setFechaVencimientoDesde((Date)rs.getValueAt(0,"FEC_VENC_DESD"));
		}

		if (rs.getValueAt(0,"FEC_VENC_HAST")!=null) {
			dtoConsultar.setFechaVencimientoHasta((Date)rs.getValueAt(0,"FEC_VENC_HAST"));
		}

		if (rs.getValueAt(0,"COD_PERI_DESD")!=null) {
			dtoConsultar.setPeriodoDesde(rs.getValueAt(0,"COD_PERI_DESD").toString());
		}

		if (rs.getValueAt(0,"COD_PERI_HAST")!=null) {
			dtoConsultar.setPeriodoHasta(rs.getValueAt(0,"COD_PERI_HAST").toString());
		}

		if (rs.getValueAt(0,"VAL_OBSE")!=null) {
			dtoConsultar.setObservaciones(rs.getValueAt(0,"VAL_OBSE").toString());
		}*/
		

		/*El campo lineasDetalle:RecordSet tendrá los datos siguientes: 
		 * oidDetalle (oculto), canal(codigo), acceso(codigo), subacceso(codigo), numeroIdentificadorCuota, 
		 * ejercicioCuota, numeroOrdenCuota, codigoCliente, medioPago(codigo) y importe.
		*/
		
		DTOConsultarDepuracion dtoConsultar=new DTOConsultarDepuracion();
		//consulta = new StringBuffer();
		consulta.append(" SELECT deta.OID_DETA_CARG_ABON_DIRE, ");
		
		//consulta.append(" can.COD_CANA, ");
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = can.OID_CANA AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'SEG_CANAL') AS DESC_CANAL, ");	
		
		//consulta.append(" ac.COD_ACCE, ");
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = ac.OID_ACCE AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'SEG_ACCES') AS DESC_ACCESO, ");
		
		//consulta.append(" sub.COD_SBAC, ");
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = sub.OID_SBAC AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'SEG_SUBAC') AS DESC_SUBAC, ");
		
		consulta.append(" mov.NUM_IDEN_CUOT, mov.VAL_EJER_CUOT, mov.NUM_ORDE_CUOT, ");
		consulta.append(" c.COD_CLIE, med.COD_MEDI_PAGO, deta.IMP ");

		consulta.append(" FROM CCC_DETAL_CARGO_ABONO_DIREC deta LEFT JOIN BEL_MEDIO_PAGO med ON deta.MPAB_OID_MEDI_PAGO=med.OID_MEDI_PAGO, ");
		consulta.append(" MAE_CLIEN c, CCC_MOVIM_CUENT_CORRI mov, ");
		//consulta.append(" VCA_SEG_ACCES ac, VCA_SEG_CANAL can, VCA_SEG_SUBAC sub ");
		consulta.append(" CCC_CABEC_CARGA_ABONO_DIREC cabe LEFT JOIN SEG_SUBAC sub ON cabe.SBAC_OID_SBAC=sub.OID_SBAC  ");
		consulta.append(" LEFT JOIN SEG_ACCES ac ON sub.ACCE_OID_ACCE=ac.OID_ACCE ");
		consulta.append(" LEFT JOIN SEG_CANAL can ON ac.CANA_OID_CANA=can.OID_CANA ");

		consulta.append(" WHERE deta.CLIE_OID_CLIE = c.OID_CLIE AND ");
		consulta.append(" deta.CCAD_OID_CABE_CARG = cabe.OID_CABE_CARG AND ");
		consulta.append(" deta.MVCC_OID_MOVI_CC=mov.OID_MOVI_CC AND ");
		consulta.append(" (cabe.SBAC_OID_SBAC IS NULL OR ");
		consulta.append(" (EXISTS (SELECT * FROM VCA_SEG_SUBAC SS WHERE sub.OID_SBAC = SS.OID_SBAC AND SS.COD_USUA = ? ) ");
		consulta.append(" AND EXISTS(SELECT * FROM VCA_SEG_ACCES AC WHERE ac.OID_ACCE = AC.OID_ACCE AND AC.COD_USUA = ? ) ");
		consulta.append(" AND EXISTS(SELECT * FROM VCA_SEG_CANAL SC WHERE ac.CANA_OID_CANA = SC.OID_CANA AND SC.COD_USUA = ? ))) ");
		consulta.append(" AND cabe.OID_CABE_CARG= ? ");

		Long idioma=dto.getOidIdioma();
		Vector parametros = new Vector();
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(this.usuario);
		parametros.add(this.usuario);
		parametros.add(this.usuario);
		parametros.add(dto.getOid());

		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerDetalleDepuracion: Exception",e);
			this.logSql("obtenerDetalleDepuracion. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		// Se rellena el campo lineas de DTOConsultarDepuracion
		dtoConsultar.setLineasDetalle(rs);

		UtilidadesLog.info("DAODepuracion.obtenerDetalleDepuracion(DTOOIDPAG dto): Salida");
		return dtoConsultar;
	}

	public DTOSalida buscarLotesDepuracion(DTOBuscarLotes criterios) throws MareException {
		        
        UtilidadesLog.info("DAODepuracion.buscarLotesDepuracion(DTOBuscarLotes criterios): Entrada");
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		Long idioma = criterios.getOidIdioma();

		//nuevo
		consulta.append(" SELECT ca.OID_CABE_CARG oid, ca.NUM_CABE, ca.ANIO, ca.VAL_PERI_MES, ca.FEC_DOCU, ");
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = ca.SIIN_OID_SITU_INCO AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'CCC_SITUA_INCOB') AS DESC_SITU_INCO, ");
		consulta.append(" soc.VAL_DENO, ");
		//descripcion del canal
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = can.OID_CANA AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'SEG_CANAL') AS DESC_CANAL, ");	
		//descripcion del acceso
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = ac.OID_ACCE AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'SEG_ACCES') AS DESC_ACCESO, ");

		//descripcion del subacceso
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = sub.OID_SBAC AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'SEG_SUBAC') AS DESC_SUBAC, ");
		
		consulta.append(" COUNT(da.oid_deta_carg_abon_dire) AS TOTALREGSCABECERA, ");
		consulta.append(" SUM(da.IMP) AS IMPORTETOTALCABECERA ");

		consulta.append(" FROM CCC_CABEC_CARGA_ABONO_DIREC ca LEFT JOIN CCC_DETAL_CARGO_ABONO_DIREC da ON ");
		consulta.append(" ca.OID_CABE_CARG = da.CCAD_OID_CABE_CARG ");
		consulta.append(" LEFT JOIN SEG_SUBAC sub ON CA.SBAC_OID_SBAC=SUB.OID_SBAC ");
		consulta.append(" LEFT JOIN SEG_ACCES ac ON SUB.ACCE_OID_ACCE= AC.OID_ACCE ");
		consulta.append(" LEFT JOIN SEG_CANAL can ON AC.CANA_OID_CANA=CAN.OID_CANA, ");
		consulta.append(" VCA_SEG_SOCIE soc ");
		consulta.append(" WHERE ");
		consulta.append(" ca.SOCI_OID_SOCI=soc.OID_SOCI AND soc.COD_USUA = ? ");
		consulta.append(" AND  (ca.SBAC_OID_SBAC IS NULL OR ");
		consulta.append(" (EXISTS (SELECT * FROM VCA_SEG_SUBAC SS WHERE sub.OID_SBAC = SS.OID_SBAC AND SS.COD_USUA = ? ) ");
		consulta.append(" AND EXISTS(SELECT * FROM VCA_SEG_ACCES AC WHERE ac.OID_ACCE = AC.OID_ACCE AND AC.COD_USUA = ? ) ");
		consulta.append(" AND EXISTS(SELECT * FROM VCA_SEG_CANAL SC WHERE ac.CANA_OID_CANA = SC.OID_CANA AND SC.COD_USUA = ? ))) ");
		
		// Parametros de la consulta
		Vector parametros = new Vector();
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(this.usuario);
		parametros.add(this.usuario);
		parametros.add(this.usuario);
		parametros.add(this.usuario);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
		if (criterios.getNumero() != null) {
			consulta.append(" AND ca.NUM_CABE = ? ");
			parametros.add(criterios.getNumero());
		}

		if (criterios.getAnho() != null) {
			consulta.append("AND ca.ANIO = ? ");
			parametros.add(criterios.getAnho());
		}

		if (criterios.getMes()!=null) {
			consulta.append("AND ca.VAL_PERI_MES = ? ");
			parametros.add(criterios.getMes());
		}

		if (criterios.getFechaImputacion()!=null) {
			Date fechaImputacion = new java.sql.Date(criterios.getFechaImputacion().getTime());
			String sfechaImputacion = sdf.format(fechaImputacion);  
			consulta.append("AND (ca.FEC_DOCU = TO_DATE( ? ,'YYYY-MM-DD')) ");
			parametros.add(sfechaImputacion);
		}

		if (criterios.getOidTipoCargoAbono()!=null) {
			consulta.append("AND da.TASP_OID_TIPO_ABON_SUBP = ? ");
			parametros.add(criterios.getOidTipoCargoAbono());
		}

		if (criterios.getOidCanal()!=null) {
			consulta.append("AND can.OID_CANA = ? ");
			parametros.add(criterios.getOidCanal());
		}

		if (criterios.getOidAcceso()!=null) {
			consulta.append("AND ac.OID_ACCE = ? ");
			parametros.add(criterios.getOidAcceso());
		}

		if (criterios.getOidSubacceso()!=null) {
			consulta.append("AND sub.OID_SBAC = ? ");
			parametros.add(criterios.getOidSubacceso());
		}

		if (criterios.getSituacion()!=null) {
			consulta.append("AND ca.SIIN_OID_SITU_INCO = ? ");
			parametros.add(criterios.getSituacion());
		}

		if (criterios.getEliminar().booleanValue()){
			consulta.append(" AND CCC_CABEC_CARGA_ABONO_DIREC.FEC_CONT IS NULL ");
		}

		consulta.append(" GROUP BY ca.OID_CABE_CARG, ca.NUM_CABE, ca.ANIO, ca.VAL_PERI_MES, ca.FEC_DOCU, ");
		consulta.append(" ca.FEC_CONT, ca.SIIN_OID_SITU_INCO, soc.VAL_DENO, can.OID_CANA, ac.OID_ACCE, sub.OID_SBAC "); 

		// La consulta debe ser paginada
		String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),criterios);

		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(sql,parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("buscarLotesDepuracion: Exception",e);
			this.logSql("buscarLotesDepuracion. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		if (rs.esVacio()) {
			UtilidadesLog.debug("buscarLotesDepuracion: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

		// Se crea un DTOSalida a partir del RecordSet
		DTOSalida dtoSalida = new DTOSalida(rs);		
		UtilidadesLog.info("DAODepuracion.buscarLotesDepuracion(DTOBuscarLotes criterios): Salida");
		return dtoSalida;	
		
		/*// Se crea la consulta SQL
		// Ver incidencias 3418, 3415, 4732
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT c.OID_CABE_CARG OID, ");
        //Descripcion de Pais
        consulta.append(" (SELECT    v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("   WHERE v.VAL_OID=c.PAIS_OID_PAIS ");
        consulta.append("   		AND   v.IDIO_OID_IDIO =?");
        consulta.append("      AND   v.ATTR_NUM_ATRI = 1 ");
        consulta.append("      AND   v.ATTR_ENTI = 'SEG_PAIS') AS DESC_PAIS, ");      
		
		consulta.append("c.ANIO, c.VAL_PERI_MES, c.NUM_CABE, COUNT(de.OID_DETA_CARG_ABON_DIRE) AS NUM_REG_LOTE, ");
		consulta.append("SUM(mov.IMP_MOVI) AS IMPORTE_TOTAL ,c.FEC_CONT, ");
		
		// Subselect para obtener la descripción de la situación
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = c.SIIN_OID_SITU_INCO AND ");
		consulta.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append("v.ATTR_ENTI = 'CCC_SITUA_INCOB') AS DESC_SITU_INCO, ");

		// Subselect para obtener la descripción del proceso
		consulta.append(" s.DES_SUBP, ");

		// Subselect para obtener la descripción del canal
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = ac.CANA_OID_CANA AND ");
		consulta.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append("v.ATTR_ENTI = 'SEG_CANAL') AS DESC_CANA, ");

		// Subselect para obtener la descripción del acceso
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = ac.OID_ACCE AND ");
		consulta.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append("v.ATTR_ENTI = 'SEG_ACCES') AS DESC_ACCE, ");

		// Subselect para obtener la descripción del subacceso
		consulta.append("(SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append("WHERE v.VAL_OID = sub.OID_SBAC AND ");
		consulta.append("v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append("v.ATTR_ENTI = 'SEG_SUBAC') AS DESC_SBAC ");

		consulta.append("FROM (((CCC_CABEC_CARGA_ABONO_DIREC c LEFT JOIN CCC_DETAL_CARGO_ABONO_DIREC de ON ");
		consulta.append("(c.OID_CABE_CARG = de.CCAD_OID_CABE_CARG)) ");
		consulta.append("LEFT JOIN CCC_MOVIM_CUENT_CORRI mov ON ");
		consulta.append("(de.MVCC_OID_MOVI_CC = mov.OID_MOVI_CC)) ");

		consulta.append("LEFT JOIN VCA_SEG_SUBAC sub ON ");
		consulta.append("(c.SBAC_OID_SBAC = sub.OID_SBAC AND sub.COD_USUA = ?)) ");

		consulta.append("LEFT JOIN VCA_SEG_ACCES ac ON ");
		consulta.append("(sub.ACCE_OID_ACCE = ac.OID_ACCE AND ac.COD_USUA = ?), ");

		consulta.append("CCC_TIPO_ABONO_SUBPR ts, CCC_SUBPR s ");

		consulta.append("WHERE c.TASP_OID_TIPO_ABON_SUBP = ts.OID_TIPO_ABON_SUBP AND ");
		consulta.append("ts.SUBP_OID_SUBP = s.OID_SUBP AND ");
		consulta.append(" ");
		consulta.append("c.PAIS_OID_PAIS = ? ");


		Long idioma = criterios.getOidIdioma();
		Long pais = criterios.getOidPais();
		
		// Parametros de la consulta
		Vector parametros = new Vector();
		//parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(this.usuario);
		parametros.add(this.usuario);
		parametros.add(pais);

		// Se obtienen los campos del DTO
		String anho = criterios.getAnho();
		String mes = criterios.getMes();
		String numeroLote = criterios.getNumeroLote();
		Date fechaContable = null;
		if (criterios.getFechaImputacion() != null) {
			fechaContable = new Date(criterios.getFechaImputacion().getTime());
		}
		Long situacion = criterios.getSituacion();
		Long tipoCargoAbono = criterios.getTipoCargoAbono();
		Long subacceso = criterios.getSubacceso();
		Long acceso = criterios.getAcceso();
		Long canal = criterios.getCanal();
		Boolean eliminar = criterios.getEliminar();
		
		// Parte opcional de la consulta
		// Ver incidencias 3418, 3415
		if (anho != null) {
			consulta.append("AND c.ANIO = ? ");
			parametros.add(anho);
		}
		if (mes != null) {
			consulta.append("AND c.VAL_PERI_MES = ? ");
			parametros.add(mes);
		}
		if (numeroLote != null) {
			consulta.append("AND c.NUM_CABE = ? ");
			parametros.add(numeroLote);
		}
		if (fechaContable != null) {
			consulta.append("AND c.FEC_CONT = ? ");
			parametros.add(fechaContable);
		}
		if (situacion != null) {
			consulta.append("AND c.SIIN_OID_SITU_INCO = ? ");
			parametros.add(situacion);
		}
		if (tipoCargoAbono != null) {
			consulta.append("AND ts.TCAB_OID_TCAB = ? ");
			parametros.add(tipoCargoAbono);
		}
		if (subacceso != null) {
			consulta.append("AND sub.OID_SBAC = ? ");
			parametros.add(subacceso);
		}
		if (acceso != null) {
			consulta.append("AND ac.OID_ACCE = ? ");
			parametros.add(acceso);
		}
		if (canal != null) {
			consulta.append("AND ac.CANA_OID_CANA = ? ");
			parametros.add(canal);
		}

		if (eliminar.booleanValue()==true){
			consulta.append("AND CCC_CABEC_CARGA_ABONO_DIREC.FEC_CONT IS NULL ");
		}

		consulta.append("GROUP BY c.OID_CABE_CARG, c.ANIO, c.VAL_PERI_MES, ");
		consulta.append("c.NUM_CABE, c.FEC_CONT,c.PAIS_OID_PAIS,c.SIIN_OID_SITU_INCO, ");
		consulta.append("s.DES_SUBP, ac.CANA_OID_CANA, ac.OID_ACCE, sub.OID_SBAC ");

		// La consulta debe ser paginada
		String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),criterios);

		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(sql,parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("buscarLotesDepuracion: Exception",e);
			this.logSql("buscarLotesDepuracion. SQL: ",sql, parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		// Se crea un DTOSalida a partir del RecordSet
		DTOSalida dtoSalida = new DTOSalida(rs);*/
		
	}

	public DTOConsultarDepuracion obtenerCabeceraDepuracion(DTOOID dto) throws MareException {
		
        UtilidadesLog.info("DAODepuracion.obtenerCabeceraDepuracion(DTOOID dto): Entrada");
		StringBuffer consulta = new StringBuffer();		
		consulta.append(" SELECT cabe.OID_CABE_CARG, cabe.NUM_CABE, cabe.ANIO, cabe.VAL_PERI_MES, cabe.FEC_DOCU, ");
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = cabe.SIIN_OID_SITU_INCO AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'CCC_SITUA_INCOB') AS DESC_SITU_INCO, ");
		consulta.append(" soc.VAL_DENO, "); 
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = can.OID_CANA AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'SEG_CANAL') AS DESC_CANAL, ");	
		//consulta.append(" ac.COD_ACCE, ");
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = ac.OID_ACCE AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'SEG_ACCES') AS DESC_ACCESO, ");
		//consulta.append(" sub.COD_SBAC, ");
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");
		consulta.append(" WHERE v.VAL_OID = sub.OID_SBAC AND ");
		consulta.append(" v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND ");
		consulta.append(" v.ATTR_ENTI = 'SEG_SUBAC') AS DESC_SUBAC, ");
		
		consulta.append(" COUNT(deta.OID_DETA_CARG_ABON_DIRE) AS TOTALREGSCABECERA, ");
		consulta.append(" SUM(deta.IMP) AS IMPORTETOTALCABECERA, ");
		
		consulta.append(" cabe.VAL_REFE_EXTE, cabe.COD_CLIE_DESD, cabe.COD_CLIE_HAST, ");
		consulta.append(" cabe.FEC_VENC_DESD, cabe.FEC_VENC_HAST, ");
		consulta.append(" cabe.COD_PERI_DESD, cabe.COD_PERI_HAST, cabe.VAL_OBSE ");
		
		consulta.append(" FROM CCC_CABEC_CARGA_ABONO_DIREC cabe LEFT JOIN CCC_DETAL_CARGO_ABONO_DIREC deta ON ");
		consulta.append(" cabe.OID_CABE_CARG = deta.CCAD_OID_CABE_CARG ");
		consulta.append(" LEFT JOIN SEG_SUBAC sub ON cabe.SBAC_OID_SBAC=sub.OID_SBAC ");
		consulta.append(" LEFT JOIN SEG_ACCES ac ON sub.ACCE_OID_ACCE=ac.OID_ACCE ");
		consulta.append(" LEFT JOIN SEG_CANAL can ON ac.CANA_OID_CANA=caN.OID_CANA, ");
		consulta.append(" SEG_SOCIE soc ");

		consulta.append(" WHERE ");
		consulta.append(" cabe.SOCI_OID_SOCI=soc.OID_SOCI ");
		//consulta.append(" AND (cabe.SBAC_OID_SBAC IS NULL OR ");
		//consulta.append(" (EXISTS (SELECT * FROM VCA_SEG_SUBAC SS WHERE sub.OID_SBAC = SS.OID_SBAC AND SS.COD_USUA = ? ) ");
		//consulta.append(" AND EXISTS(SELECT * FROM VCA_SEG_ACCES AC WHERE ac.OID_ACCE = AC.OID_ACCE AND AC.COD_USUA = ? ) ");
		//consulta.append(" AND EXISTS(SELECT * FROM VCA_SEG_CANAL SC WHERE ac.CANA_OID_CANA = SC.OID_CANA AND SC.COD_USUA = ? ))) ");
		consulta.append(" AND cabe.OID_CABE_CARG= ? ");

		consulta.append("GROUP BY cabe.OID_CABE_CARG, cabe.NUM_CABE, cabe.ANIO, cabe.VAL_PERI_MES, ");
		consulta.append(" cabe.FEC_DOCU, cabe.VAL_REFE_EXTE, cabe.VAL_OBSE,  ");
		consulta.append(" soc.VAL_DENO, can.OID_CANA, ac.OID_ACCE,  sub.OID_SBAC, ");
		consulta.append(" cabe.FEC_VENC_DESD, cabe.FEC_VENC_HAST, cabe.COD_CLIE_DESD, cabe.COD_CLIE_HAST, ");
		consulta.append(" cabe.COD_PERI_DESD, cabe.COD_PERI_HAST, ");
		consulta.append(" cabe.SIIN_OID_SITU_INCO ");
  
  
		Long idioma=dto.getOidIdioma();
		Vector parametros = new Vector();
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(idioma);
		parametros.add(dto.getOid());

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerCabeceraDepuracion: Exception", e);
			this.logSql("obtenerCabeceraDepuracion. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		//Construimos un DTOConsultarDepuracion con los datos obtenidos de la CabeceraCargoAbonosDirectos 
			
		DTOConsultarDepuracion dtoConsultar=new DTOConsultarDepuracion();

		dtoConsultar.setOidCabecera(new Long(((BigDecimal)rs.getValueAt(0,"OID_CABE_CARG")).longValue()));
		dtoConsultar.setNumero(new Integer(((BigDecimal)rs.getValueAt(0,"NUM_CABE")).intValue()));
		dtoConsultar.setAnio(rs.getValueAt(0,"ANIO").toString());
		dtoConsultar.setMes(rs.getValueAt(0,"VAL_PERI_MES").toString());
		dtoConsultar.setFechaImputacion((Date)rs.getValueAt(0,"FEC_DOCU"));
		if (rs.getValueAt(0,"DESC_SITU_INCO")!=null) {
			dtoConsultar.setSituacion(rs.getValueAt(0,"DESC_SITU_INCO").toString());
		}
		if (rs.getValueAt(0,"VAL_DENO") != null) {
			dtoConsultar.setEmpresa(rs.getValueAt(0,"VAL_DENO").toString());
		}
		if (rs.getValueAt(0,"DESC_CANAL") != null) {
			dtoConsultar.setCanal(rs.getValueAt(0,"DESC_CANAL").toString());
		}
		if (rs.getValueAt(0,"DESC_ACCESO") != null) {
			dtoConsultar.setAcceso(rs.getValueAt(0,"DESC_ACCESO").toString());
		}
		if (rs.getValueAt(0,"DESC_SUBAC") != null) {
			dtoConsultar.setSubAcceso((String)rs.getValueAt(0,"DESC_SUBAC"));
		}
		
		dtoConsultar.setNumeroRegistrosDelNumero(new Integer(((BigDecimal)rs.getValueAt(0,"TOTALREGSCABECERA")).intValue()));
		dtoConsultar.setImporteRegistrosDelNumero((BigDecimal)rs.getValueAt(0,"IMPORTETOTALCABECERA"));
		
		if (rs.getValueAt(0,"VAL_REFE_EXTE")!=null) {
			dtoConsultar.setReferencia(rs.getValueAt(0,"VAL_REFE_EXTE").toString());
		}
		if (rs.getValueAt(0,"COD_CLIE_DESD")!=null) {
			dtoConsultar.setClienteDesde(rs.getValueAt(0,"COD_CLIE_DESD").toString());
		}
		
		if (rs.getValueAt(0,"COD_CLIE_HAST")!=null) {
			dtoConsultar.setClienteHasta(rs.getValueAt(0,"COD_CLIE_HAST").toString());
		}
		
		if (rs.getValueAt(0,"FEC_VENC_DESD")!=null) {
			dtoConsultar.setFechaVencimientoDesde((Date)rs.getValueAt(0,"FEC_VENC_DESD"));
		}

		if (rs.getValueAt(0,"FEC_VENC_HAST")!=null) {
			dtoConsultar.setFechaVencimientoHasta((Date)rs.getValueAt(0,"FEC_VENC_HAST"));
		}

		if (rs.getValueAt(0,"COD_PERI_DESD")!=null) {
			dtoConsultar.setPeriodoDesde(rs.getValueAt(0,"COD_PERI_DESD").toString());
		}

		if (rs.getValueAt(0,"COD_PERI_HAST")!=null) {
			dtoConsultar.setPeriodoHasta(rs.getValueAt(0,"COD_PERI_HAST").toString());
		}

		if (rs.getValueAt(0,"VAL_OBSE")!=null) {
			dtoConsultar.setObservaciones(rs.getValueAt(0,"VAL_OBSE").toString());
		}

		UtilidadesLog.info("DAODepuracion.obtenerCabeceraDepuracion(DTOOID dto): Salida");
		return dtoConsultar;
	}

	public Long obtenerCuentaTipoAbono(Long tipoAbono, Long pais) throws MareException {
		
        UtilidadesLog.info("DAODepuracion.obtenerCuentaTipoAbono(Long tipoAbono, Long pais): Entrada");

		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT CUCO_OID_CUEN_CONT ");
		consulta.append("FROM CCC_TIPO_ABONO_SUBPR ");
		consulta.append("WHERE TCAB_OID_TCAB = ? AND ");
		consulta.append("SUBP_OID_SUBP = ? "); 

		// Se llama a DAOCCC.obtieneSubproceso("CCC006", "1", pais); 
		DAOCCC daoCCC = new DAOCCC();
		Long subproceso = daoCCC.obtieneSubproceso("CCC006", "1", pais);

		// Parametros de la consulta
		Vector parametros = new Vector();
		parametros.add(tipoAbono);
		parametros.add(subproceso);

		// Se ejecuta la consulta SQL
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerCuentaTipoAbono: Exception",e);
			this.logSql("obtenerCuentaTipoAbono. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		Long resultado = null;
		if (!rs.esVacio()) {
			Vector fila = rs.getRow(0);
			resultado = new Long(((BigDecimal)fila.elementAt(0)).longValue());
		}

		UtilidadesLog.info("DAODepuracion.obtenerCuentaTipoAbono(Long tipoAbono, Long pais): Salida");
		return resultado;
	}


	private void logError(String mensaje,Throwable e) {
    
		UtilidadesLog.error("*** Error Metodo " + mensaje + ": " + e.getMessage());
		this.logStackTrace(e);
	}

	private void logStackTrace(Throwable e) {
		try {						
			UtilidadesLog.error(e);
		} catch (Exception ex) {
			UtilidadesLog.error("Traza de la pila: "+ex.getMessage());
		}			
	}

	private void logSql(String metodo, String sql, Vector params){
		
        UtilidadesLog.debug(metodo + sql);
		if (params != null && params.size() > 0) {
			String sParams="";
			for (int i = 0; i < params.size(); i++) {
				sParams += "param " + (i + 1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
	}	
  public RecordSet obtenerTiposBloqueo(String codigo, Boolean indActivo ) throws MareException {
		
        UtilidadesLog.info("DAODepuracion.obtenerTiposBloqueo(String Codigo, Boolean indActivo): Entrada");

		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT * "); 
		consulta.append(" FROM MAE_TIPO_BLOQU TB"); 
		consulta.append(" WHERE TB.IND_BLOQ_FINA = "+(indActivo.booleanValue()?"1":"0")); 
		if(codigo!=null){
      consulta.append(" AND TB.COD_TIPO_BLOQ ="+codigo); 
    }
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executeStaticQuery(consulta.toString());
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		
		if (rs.esVacio()) {
      return null;
		}

		UtilidadesLog.info("DAODepuracion.obtenerTiposBloqueo(String Codigo, Boolean indActivo): Salida");
		return rs;
	}
 public ArrayList obtenerClientesDetalle(Long oid) throws MareException {
		
        UtilidadesLog.info("DAODepuracion.obtenerClientesDetalle(Long oid): Entrada");

		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT CLIE_OID_CLIE ");
		consulta.append("FROM CCC_DETAL_CARGO_ABONO_DIREC ");
		consulta.append("WHERE CCAD_OID_CABE_CARG = ? ");

		// Parametros de la consulta
		Vector parametros = new Vector();
		parametros.add(oid);

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerClientesDetalle: Exception",e);
			this.logSql("obtenerClientesDetalle. SQL: ",consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		ArrayList oids = new ArrayList();
		if (!rs.esVacio()) {
			for (int i=0; i < rs.getRowCount(); i++) {
				oids.add(new Long(rs.getValueAt(i,0).toString()));
				
			}
		}

		// Se crea un DTOOIDs y se rellena con los registros obtenidos. Si no se obtiene 
		// ningún registro se devuelve el DTOOIDs con un array vacio.
		
		UtilidadesLog.info("DAODepuracion.obtenerClientesDetalle(Long oid): Salida");
		return oids;
	}
  
  public ArrayList obtenerClientesBloqueo(ArrayList oids) throws MareException {
		
        UtilidadesLog.info("DAODepuracion.obtenerClientesBloqueo(DTOOIDs oids): Entrada");

		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT CB.CLIE_OID_CLIE , CB.TIBQ_OID_TIPO_BLOQ, TB.NUM_NIVE_GRAV_BLOQ " );
		consulta.append(" FROM MAE_CLIEN_BLOQU CB, MAE_TIPO_BLOQU TB " );
		consulta.append(" WHERE CB.TIBQ_OID_TIPO_BLOQ = TB.OID_TIPO_BLOQ " );
		consulta.append(" AND CB.FEC_DESB IS NULL " );
		consulta.append(" AND CB.CLIE_OID_CLIE IN(" );
  
			for (int i=0; i < oids.size() ; i++) {
				consulta.append(" "+oids.get(i).toString() +",");
			}
      consulta.deleteCharAt(consulta.length()-1);
		consulta.append(" ) ORDER BY CB.FEC_BLOQ DESC ");


		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executeStaticQuery(consulta.toString());
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerClientesBloqueo: Exception",e);
			
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		ArrayList listaBloqueos = new ArrayList();
		
    if (!rs.esVacio()) {
			for (int i=0; i < rs.getRowCount(); i++) {
    		DTOClienteBloqueo dtoCB = new DTOClienteBloqueo();	
        dtoCB.setOidCliente(new Long(rs.getValueAt(i,"CLIE_OID_CLIE").toString()));
      	dtoCB.setOidTipoBloqueo(new Long(rs.getValueAt(i,"TIBQ_OID_TIPO_BLOQ").toString()));
        dtoCB.setNvlGravedadBloqueo(new Long(rs.getValueAt(i,"NUM_NIVE_GRAV_BLOQ").toString()));
			  listaBloqueos.add(dtoCB);
      }
		}

		// Se crea un DTOOIDs y se rellena con los registros obtenidos. Si no se obtiene 
		// ningún registro se devuelve el DTOOIDs con un array vacio.

		
		UtilidadesLog.info("DAODepuracion.obtenerClientesBloqueo(DTOOIDs oids): Salida");
		return listaBloqueos;
	}
}