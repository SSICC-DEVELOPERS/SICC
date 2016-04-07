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

import es.indra.sicc.dtos.ccc.DTOBuscarConfirmarMovBanc;
import es.indra.sicc.dtos.ccc.DTOBuscarMovBancConsultar;
import es.indra.sicc.dtos.ccc.DTOBuscarMovBancDepurar;
import es.indra.sicc.dtos.ccc.DTOBuscarMovCCConfirmar;
import es.indra.sicc.dtos.ccc.DTOCancelarCupon3;
import es.indra.sicc.dtos.ccc.DTOConsultarCupon3;
import es.indra.sicc.dtos.ccc.DTOMovBanc;
import es.indra.sicc.dtos.ccc.DTONumeroLote;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.text.SimpleDateFormat;

import java.util.Vector;
import java.math.BigDecimal;


public class DAORecaudoEntFin {

	//private String usuario;

	public DAORecaudoEntFin() {
	}

	   // incidencia 9844
   /*public DAORecaudoEntFin(String usuario) {
		this.usuario = usuario;
	}*/

	/**
	 * Metodo 
	 */
	public DTOSalida consultarCupon3(DTOConsultarCupon3 dto) throws MareException {

		UtilidadesLog.info("DAORecaudoEntFin.consultarCupon3(DTOConsultarCupon3 dto): Entrada");      
		
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append("SELECT d.OID_DETA_CUPO_TRAM_DEPU OID, c.VAL_ANIO, ");
		consulta.append("c.VAL_PERI_MES, c.NUM_CUPE, p.COD_PERI, m.COD_CLIE, ");
		consulta.append("d.FEC_DIGI, d.FEC_DOCU, b.DES_BANC, d.NUM_LINE, d.IMP_DETA ");

		consulta.append("FROM ");
		consulta.append("CCC_CUPON_TRAMI_DEPUR c, ");
		consulta.append("CCC_DETAL_CUPON_TRAMI_DEPUR d, ");
		consulta.append("CCC_SITUA_CUPON s, ");
		consulta.append("MAE_CLIEN m, ");
		consulta.append("SEG_PERIO_CORPO p, ");
		consulta.append("CCC_BANCO b ");

		consulta.append("WHERE ");

		// joins
		consulta.append("c.OID_CUPO_TRAM_DEPU = d.CTDE_OID_CUPO_TRAM_DEPU ");
		consulta.append("AND d.SICU_OID_SITU_CUPO = s.OID_SITU_CUPO ");
		consulta.append("AND d.CLIE_OID_CLIE = m.OID_CLIE ");
		consulta.append("AND d.PERI_OID_PERI = p.OID_PERI ");
		consulta.append("AND d.CBAN_OID_BANC = b.OID_BANC ");

		//criterios - Los que venga a null no se aplican como criterios de filtro 

		if (dto.getOidPais() != null) {
			consulta.append("AND c.PAIS_OID_PAIS = ? ");
			parametros.add(dto.getOidPais());
		}
		if (dto.getOidSubacceso() != null) {
			consulta.append("AND c.SBAC_OID_SBAC = ? ");
			parametros.add(dto.getOidSubacceso());
		}
		if (dto.getOidPeriodo() != null) {
			consulta.append("AND d.PERI_OID_PERI = ? ");
			parametros.add(dto.getOidPeriodo());
		}
		if (dto.getAnio() != null) {
			consulta.append("AND c.VAL_ANIO = ? ");
			parametros.add(dto.getAnio());
		}
		if (dto.getMes() != null) {
			consulta.append("AND c.VAL_PERI_MES = ? ");
			parametros.add(dto.getMes());
		}
		if (dto.getNumero() != null) {
			consulta.append("AND c.NUM_CUPE = ? ");
			parametros.add(dto.getNumero());
		}
		if (dto.getCodigoCliente() != null) {
			consulta.append("AND m.COD_CLIE = ? ");
			parametros.add(dto.getCodigoCliente());
		}
		if (dto.getFechaDigitacion() != null) {
            consulta.append("AND d.FEC_DIGI = TO_DATE(?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaDigitacion = sdf.format(dto.getFechaDigitacion());
            parametros.add(fechaDigitacion);
		}
		if (dto.getFechaDoc() != null) {
            consulta.append("AND d.FEC_DOCU = TO_DATE(?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaDoc = sdf.format(dto.getFechaDoc());
            parametros.add(fechaDoc);
		}
		if (dto.getOidBanco() != null) {
			consulta.append("AND d.CBAN_OID_BANC = ? ");
			parametros.add(dto.getOidBanco());
		}
		if (dto.getOidSituacion() != null) {
			consulta.append("AND d.SICU_OID_SITU_CUPO = ?");
			parametros.add(dto.getOidSituacion());			
		}

		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);

        try {
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("consultarCupon3(DTOConsultarCupon3): Exception", e);
            logSql("consultarCupon3(DTOConsultarCupon3). SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtoSalida = new DTOSalida(resultado);
                
		UtilidadesLog.info("DAORecaudoEntFin.consultarCupon3(DTOConsultarCupon3 dto): Salida");      

        return dtoSalida;
	}

	/**
	 * Metodo 
	 */
	public DTOSalida consultarCupon3(DTOCancelarCupon3 dto) throws MareException {

		UtilidadesLog.info("DAORecaudoEntFin.consultarCupon3(DTOCancelarCupon3 dto): Entrada");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append("SELECT ");
		consulta.append("d.OID_DETA_CUPO_TRAM_DEPU OID, mov.NUM_LOTE, c.VAL_ANIO, ");
		consulta.append("c.VAL_PERI_MES, m.COD_CLIE, d.FEC_DOCU, mov.FEC_PAGO, ");
		consulta.append("b.DES_BANC, d.IMP_DETA ");

		consulta.append("FROM ");
		
		consulta.append("CCC_CUPON_TRAMI_DEPUR c, ");
		consulta.append("CCC_DETAL_CUPON_TRAMI_DEPUR d, ");
		consulta.append("CCC_SITUA_CUPON s, ");
		consulta.append("MAE_CLIEN m, ");
		consulta.append("SEG_PERIO_CORPO p, ");
		consulta.append("CCC_BANCO b, ");
		consulta.append("CCC_MOVIM_BANCA mov ");

		consulta.append("WHERE ");

		//joins 
		consulta.append("c.OID_CUPO_TRAM_DEPU = d.CTDE_OID_CUPO_TRAM_DEPU ");
		consulta.append("AND d.SICU_OID_SITU_CUPO = s.OID_SITU_CUPO ");
		consulta.append("AND d.CLIE_OID_CLIE = m.OID_CLIE ");
		consulta.append("AND d.PERI_OID_PERI = p.OID_PERI ");
		consulta.append("AND d.CBAN_OID_BANC = b.OID_BANC ");
		consulta.append("AND d.CMBA_OID_MOVI_BANC = mov.OID_MOVI_BANC ");


		//criterios - Los que venga a null no se aplican como criterios de filtro 
		if (dto.getOidPais() != null) {
			consulta.append("AND c.PAIS_OID_PAIS = ? ");
			parametros.add(dto.getOidPais());
		}
		if (dto.getAnio() != null) {
			consulta.append("AND c.VAL_ANIO = ? ");
			parametros.add(dto.getAnio());
		}
		if (dto.getMes() != null) {
			consulta.append("AND c.VAL_PERI_MES = ? ");
			parametros.add(dto.getMes());
		}
		if (dto.getNumero() != null) {
			consulta.append("AND c.NUM_CUPE = ? ");
			parametros.add(dto.getNumero());
		}
		if (dto.getOidSubacceso() != null) {
			consulta.append("AND c.SBAC_OID_SBAC = ? ");
			parametros.add(dto.getOidSubacceso());
		}
		if (dto.getCodigoCliente() != null) {
			consulta.append("AND m.COD_CLIE = ? ");
			parametros.add(dto.getCodigoCliente());
		}
		if (dto.getFechaDoc() != null) {
            consulta.append("AND d.FEC_DOCU = TO_DATE(?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaDoc = sdf.format(dto.getFechaDoc());
            parametros.add(fechaDoc);
		}
		if (dto.getFechaMovBanc() != null) {
            consulta.append("AND d.FEC_MOVI_BANC = TO_DATE(?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaMovBanc = sdf.format(dto.getFechaMovBanc());
            parametros.add(fechaMovBanc);
		}
		if (dto.getOidBanco() != null) {
			consulta.append("AND d.CBAN_OID_BANC = ? ");
			parametros.add(dto.getOidBanco());
		}
		if (dto.getOidSituacion() != null) {
			consulta.append("AND d.SICU_OID_SITU_CUPO = ? ");
			parametros.add(dto.getOidSituacion());
		}
		
		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);

        try {
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("consultarCupon3(DTOCancelarCupon3): Exception", e);
            logSql("consultarCupon3(DTOCancelarCupon3). SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOSalida dtoSalida = new DTOSalida(resultado);
                
		UtilidadesLog.info("DAORecaudoEntFin.consultarCupon3(DTOCancelarCupon3 dto): Salida");

        return dtoSalida;
	}


	/**
	 * Método
     * 17/06/2005: Por incidencia 17648 Se han hecho modificaciones al query. - [pperanzola]
	 */
	public DTOSalida buscarMovBancConsultar(DTOBuscarMovBancConsultar dto) 
		throws MareException {

		UtilidadesLog.info("DAORecaudoEntFin.buscarMovBancConsultar(DTOBuscarMovBancConsultar dto): Entrada");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

        consulta.append("SELECT * FROM (SELECT ROWNUM as linea,    XY.* FROM (");		
	    consulta.append("SELECT ");
		consulta.append("m.OID_MOVI_BANC OID,  ");
       
        // Se modifica por incidencia 21424 
        //-- Paola Cabrera 14/11/2005
       // consulta.append(" c.COD_CC_BANC, "); 
        consulta.append(" c.DES_CC Descripcion,");        
        //--fin modificacion - inc: 21424
       
       
        consulta.append(" m.FEC_PAGO, m.NUM_LOTE, ");
		consulta.append("n.COD_CLIE, n.VAL_NOM1 || ' ' || n.VAL_NOM2 || ' ' || n.VAL_APE1 || ' ' || n.VAL_APE2, ");
		consulta.append("m.NUM_FACT_BOLE, m.IMP_PAGO, m.COD_IDEN_PROC ");
        
		consulta.append("FROM ");
		
		consulta.append("CCC_MOVIM_BANCA m, ");
		consulta.append("CCC_CUENT_CORRI_BANCA c, ");
		consulta.append("CCC_SUCUR s, ");
		consulta.append("MAE_CLIEN n, ");
        consulta.append(" ccc_tipo_trans ctt "); //INCIDENCIA 17648
        
		consulta.append("WHERE ");

		//joins 
		consulta.append("m.CCBA_OID_CC_BANC = c.OID_CUEN_CORR_BANC ");
		consulta.append("AND c.SUCU_OID_SUCU = s.OID_SUCU ");
		consulta.append("AND m.CLIE_OID_CLIE = n.OID_CLIE ");
        consulta.append(" AND m.TTRA_OID_TIPO_TRANS  = ctt.OID_TIPO_TRAN  "); //INCIDENCIA 17648

		//criterios - Los que venga a null no se aplican como criterios de filtro 
		if (dto.getOidBanco() != null) {
			consulta.append("AND s.CBAN_OID_BANC = ? ");
			parametros.add(dto.getOidBanco());
		}
		if (dto.getOidCuentaCorriente() != null) {
			consulta.append("AND c.OID_CUEN_CORR_BANC = ? ");
			parametros.add(dto.getOidCuentaCorriente());
		}
		if (dto.getFechaMovimiento() != null) {
            consulta.append("AND m.FEC_PAGO = TO_DATE(?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaMovimiento = sdf.format(dto.getFechaMovimiento());
            parametros.add(fechaMovimiento);
		}
		if (dto.getCodigoCliente() != null) {
			consulta.append("AND n.COD_CLIE = ? ");
			parametros.add(dto.getCodigoCliente());
		}

		
        if (dto.getMovActualizado()!=null && dto.getMovActualizado().booleanValue()) {
			consulta.append("AND m.COD_IDEN_PROC = ? ");
			parametros.add(CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO);
		}
        // INICIO MODIFICACIONES INCIDENCIA 17648
        
        if (dto.getTipoTransaccion()!=null ){
            consulta.append(" AND ctt.OID_TIPO_TRAN = ? ");
            parametros.add(dto.getTipoTransaccion());
        
        }
        // FIN MODIFICACIONES INCIDENCIA 17648
        

		consulta.append("ORDER BY c.COD_CC_BANC, m.FEC_PAGO, m.NUM_LOTE, m.NUM_CONS_TRAN");
        consulta.append(") XY ) WHERE linea > " + dto.getIndicadorSituacion() + " AND ROWNUM <= " + dto.getTamanioPagina() );
		
		UtilidadesLog.info("***** Consulta: " + consulta.toString());
        UtilidadesLog.info("*** Parametros: " + parametros.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		//String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("buscarMovBancConsultar: Exception", e);
            logSql("buscarMovBancConsultar. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		 if (resultado.esVacio()) {                                                                            
            //GEN-0007 --> 005                                                                                  
			UtilidadesLog.debug("****DAORecaudoEntFin.buscarMovBancConsultar(dto): No hay datos ");				
            		throw new MareException(new Exception(),                                                            
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
       }  

		if (resultado != null) {
		
			// Le agregamos al RecordSet una columna vacía: "saldo" (BigDecimal:12,2)
			/*int numeroFilas = resultado.getRowCount();
			BigDecimal valores[] = new BigDecimal[numeroFilas];
			for (int i = 0; i < numeroFilas; i++) {
				valores[i] = new BigDecimal("");
				valores[i].setScale(12,2);
			}*/
			resultado.addColumn("saldo");

			// intercambio las columnas penultima y ultima para que se devuelvan
			// en el orden que se indica en el modelo de componentes
			int numeroColumnas = resultado.getColumnCount();
			resultado.interchangeColumns(numeroColumnas - 2, numeroColumnas - 1);
		}
		
        DTOSalida dtoSalida = new DTOSalida(resultado);
                
		UtilidadesLog.info("DAORecaudoEntFin.buscarMovBancConsultar(DTOBuscarMovBancConsultar dto): Salida");

        return dtoSalida;
	}


	/**
	 * Método
	 */
	public DTOSalida buscarMovBancConfirmar(DTOBuscarConfirmarMovBanc dto) 
		throws MareException {

		UtilidadesLog.info("DAORecaudoEntFin.buscarMovBancConfirmar(DTOBuscarConfirmarMovBanc dto): Entrada");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

      consulta.append("SELECT OID, cod_cc_banc, fec_pago, num_lote, cuenta, suma, ");
	   consulta.append("(select count(*) from ccc_movim_banca m1 ");
	   consulta.append(" where m1.NUM_LOTE = M2.num_lote and M1.CLIE_OID_CLIE IS NULL) AS vacio, ");
      consulta.append(" cod_tipo_tran_cheq FROM( ");

	   consulta.append("SELECT ");

		consulta.append("m.NUM_LOTE OID, ");
        consulta.append("c.COD_CC_BANC, ");
		consulta.append("min(m.FEC_PAGO) as FEC_PAGO, "); 
		consulta.append("m.NUM_LOTE, ");
		consulta.append("count (m.oid_movi_banc) AS CUENTA, ");
		consulta.append("sum(m.IMP_PAGO) AS SUMA, ");
		// se añade una columna vacia
		// consulta.append("'' AS VACIO, ");
		consulta.append("'' as COD_TIPO_TRAN_CHEQ ");

		consulta.append("FROM  ");

		consulta.append("CCC_MOVIM_BANCA m, ");
		consulta.append("CCC_CUENT_CORRI_BANCA c, ");
		consulta.append("CCC_TIPO_TRANS t, ");
		// incidencia 9844
        consulta.append("SEG_PAIS p, ");
		consulta.append("CCC_SUCUR s ");

		consulta.append("WHERE ");

		// joins
		consulta.append("m.CCBA_OID_CC_BANC = c.OID_CUEN_CORR_BANC ");
		consulta.append("AND m.TTRA_OID_TIPO_TRANS = t.OID_TIPO_TRAN ");
		consulta.append("AND p.OID_PAIS = m.PAIS_OID_PAIS ");
		consulta.append("AND p.OID_PAIS = c.PAIS_OID_PAIS ");
		consulta.append("AND s.OID_SUCU = c.SUCU_OID_SUCU ");
		
		// filtrado
		if (dto.getOidBanco() != null) {
			consulta.append("AND s.CBAN_OID_BANC = ? ");
			parametros.add(dto.getOidBanco());
		}
		if (dto.getOidCuentaCorriente() != null) {
			consulta.append("AND c.OID_CUEN_CORR_BANC = ? ");	
			parametros.add(dto.getOidCuentaCorriente());
		}
		if (dto.getFechaMovimiento() != null) {
            consulta.append("AND m.FEC_PAGO = TO_DATE(?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaMovimiento = sdf.format(dto.getFechaMovimiento());
            parametros.add(fechaMovimiento);
		}
		if (dto.getNumeroLote() != null) {
			consulta.append("AND m.NUM_LOTE = ? ");
			parametros.add(dto.getNumeroLote());
		}

		consulta.append("AND m.COD_IDEN_PROC = ? ");	
		parametros.add(CCCConstantes.MOVIMIENTO_BANCARIO_TRANSMITIDO);

      //Se filtran los lotes ya procesados. Segun incidencia V-CCC036 (Gacevedo 25/01/2007).-
      consulta.append("AND NOT EXISTS(SELECT * FROM CCC_NUM_LOTE_PROC CL	WHERE CL.VAL_NUME_LOTE_FACT = M.NUM_LOTE) ");
		consulta.append(" GROUP BY m.NUM_LOTE, c.COD_CC_BANC ) M2");
	
		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);

        try {
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("buscarMovBancConfirmar: Exception", e);
            logSql("buscarMovBancConfirmar. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		DTOSalida dtoSalida = new DTOSalida(resultado);

		UtilidadesLog.info("DAORecaudoEntFin.buscarMovBancConfirmar(DTOBuscarConfirmarMovBanc dto): Salida");

        return dtoSalida;
	}

	/**
	 * Metodo
	 */
	public DTOSalida buscarMovBancDepurar(DTOBuscarMovBancDepurar dto) 
		throws MareException {

		UtilidadesLog.info("DAORecaudoEntFin.buscarMovBancDepurar(DTOBuscarMovBancDepurar dto): Entrada");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append("SELECT ");

		consulta.append("m.OID_MOVI_BANC OID, c.COD_CC_BANC, m.FEC_PAGO, m.NUM_LOTE, ");
		consulta.append("n.COD_CLIE, n.VAL_NOM1 || ' ' || n.VAL_APE1 || ' ' || n.VAL_APE2, ");
		consulta.append("m.NUM_FACT_BOLE, m.IMP_PAGO ");

		consulta.append("FROM ");

		consulta.append("CCC_MOVIM_BANCA m, ");
		consulta.append("CCC_CUENT_CORRI_BANCA c, "); 
		consulta.append("CCC_SUCUR s, "); 
		consulta.append("MAE_CLIEN n "); 

		consulta.append("WHERE ");

		// joins
		consulta.append("m.CCBA_OID_CC_BANC = c.OID_CUEN_CORR_BANC ");
		consulta.append("AND c.SUCU_OID_SUCU = s.OID_SUCU ");
		consulta.append("AND m.CLIE_OID_CLIE = n.OID_CLIE ");
		
		// filtrado
		if (dto.getOidBanco() != null) {
			consulta.append("AND s.CBAN_OID_BANC = ? ");
			parametros.add(dto.getOidBanco());
		}
		if (dto.getOidCuentaCorriente() != null) {
			consulta.append("AND c.OID_CUEN_CORR_BANC = ? ");
			parametros.add(dto.getOidCuentaCorriente());
		}
		if (dto.getFechaMovDesde() != null) {
            consulta.append("AND m.FEC_PAGO >= TO_DATE(?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaMovDesde = sdf.format(dto.getFechaMovDesde());
            parametros.add(fechaMovDesde);
		}
		if (dto.getFechaMovHasta() != null) {
            consulta.append("AND m.FEC_PAGO <= TO_DATE(?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaMovHasta = sdf.format(dto.getFechaMovHasta());
            parametros.add(fechaMovHasta);
		}

		consulta.append("AND m.VAL_ESTA_MOVI_PEND = ? ");
		parametros.add(CCCConstantes.MOVIMIENTO_BANCARIO_APLICADO);

		consulta.append("AND m.IMP_PAGO = m.IMP_APLI ");

		consulta.append("ORDER BY c.COD_CC_BANC, m.FEC_PAGO, m.NUM_LOTE, m.NUM_CONS_TRAN");
		

		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);

        try {
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("buscarMovBancDepurar: Exception", e);
            logSql("buscarMovBancDepurar. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		DTOSalida dtoSalida = new DTOSalida(resultado);

		UtilidadesLog.info("DAORecaudoEntFin.buscarMovBancDepurar(DTOBuscarMovBancDepurar dto): Salida");

        return dtoSalida;
	}


	/**
	 * Metodo
	 */
	public DTOSalida detalleMovBanc(DTOMovBanc dto) throws MareException {
   
      // ver incidencia 9887

		UtilidadesLog.info("DAORecaudoEntFin.detalleMovBanc(DTOMovBanc): Entrada");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append("SELECT ");
        consulta.append("m.OID_MOVI_BANC OID,  ");
        
        //-- Paola Cabrera 
        //-- 14/11/2005
        //-- se modifica por la incidencia 21424
        //consulta.append(" c.COD_CC_BANC, ");
        consulta.append(" c.DES_CC Descripcion ,");
        //-- Fin de modificacion  14/11/2005 ---
        
        consulta.append(" m.FEC_PAGO, m.NUM_LOTE, ");       
		consulta.append("m.NUM_CONS_TRAN,  ");
        
        //--Se modifica por incidencia 21424 ---
        //--Pcabrera 10/11/2005 
        //consulta.append(" t.COD_TIPO_TRAN,  ");        
        consulta.append(" v.val_i18n cod_tipo_tran,  ");        
        //--fin de modificacion - 21424     
        
		consulta.append("m.IMP_PAGO, i.COD_CLIE, m.COD_CONS, ");
		consulta.append("m.NUM_FACT_BOLE, m.VAL_DIGI_CHEQ_FACT, ");
		consulta.append("m.NUM_CUPO, m.VAL_NUME_DOCU, ");
		consulta.append("m.COD_OFIC_RECA, m.VAL_NOMB_OFIC, ");

		//consulta.append("m.VAL_HORA_NORM_ADIC, ");
        consulta.append(" case when (m.val_hora_norm_adic = 'N') THEN 'Normal' ");
        consulta.append(" when (m.val_hora_norm_adic = 'A') THEN 'Adicional' ");
        consulta.append(" end as val_hora_norm_adic, ");

		consulta.append("m.VAL_USUA_PROC, m.FEC_PROC, ");
		//--Se modifica por inc 21424        
        //consulta.append("m.VAL_HORA_PROC, ");
        consulta.append(" to_char(m.val_hora_proc,'HH24:mm:ss' ) as hora, "); 
        
        consulta.append("m.COD_ERRO, ");
		consulta.append("m.VAL_ESTA_MOVI_PEND, ");

		//consulta.append("m.COD_IDEN_PROC, ");
        consulta.append(" CASE WHEN (m.cod_iden_proc = 'T') THEN 'Transferido' ");
        consulta.append(" WHEN (m.cod_iden_proc = 'I') THEN 'Incorrecto' ");
        consulta.append(" WHEN (m.cod_iden_proc = 'P') THEN 'Procesado' ");
        consulta.append("	end as cod_iden_proc, ");
        
		consulta.append("m.VAL_OBSE ");

        consulta.append("FROM ");
			
		consulta.append("CCC_MOVIM_BANCA m, ");
		consulta.append("CCC_CUENT_CORRI_BANCA c, "); 
		consulta.append("CCC_TIPO_TRANS t, ");
		consulta.append("MAE_CLIEN i ,"); 
        
        
        //--Se agrega por incidencia 21424 ---
        //--Pcabrera 10/11/2005 
        consulta.append("v_gen_i18n_sicc v "); 
        //--Fin de agregacion 

		consulta.append("WHERE ");

		// joins
		consulta.append("m.CCBA_OID_CC_BANC = c.OID_CUEN_CORR_BANC ");
		consulta.append("AND m.TTRA_OID_TIPO_TRANS = t.OID_TIPO_TRAN (+) ");        
        
        //--Se agrega por incidencia 21424 ---
        //--Pcabrera 10/11/2005
        consulta.append(" AND t.oid_tipo_tran = v.val_oid ");
        consulta.append(" AND v.idio_oid_idio = ?  ");
        parametros.add(dto.getOidIdioma());
        consulta.append(" AND v.attr_enti = 'CCC_TIPO_TRANS' ");
        consulta.append(" AND v.attr_num_atri = 1 ");
          
        //-- Fin incidencia 21424 ---
        //--Pcabrera 10/11/2005        
		consulta.append("AND m.CLIE_OID_CLIE = i.OID_CLIE ");
		
		// filtrado
		if (dto.getOid() != null) {
			consulta.append("AND m.OID_MOVI_BANC = ?");
			parametros.add(dto.getOid());
		}
		

		UtilidadesLog.info("***** Consulta: " + consulta.toString());
        UtilidadesLog.info("***** parametros: " + parametros.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        //String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("detalleMovBanc(DTOOID): Exception", e);
            logSql("detalleMovBanc(DTOOID). SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }


        UtilidadesLog.info("resultado: " + resultado);


       //--Agregado por Paola Cabrera
       //-- por inc: 21424
       //-- 16/11/2005
       /*if (!resultado.esVacio()) {
            //--Agregado
            for (int i=0; i < resultado.getRowCount(); i++)  {
                String hora = (String)resultado.getValueAt(i,18);                                    
                resultado.setValueAt(hora, i, 18);
            }
        }*/
        
		DTOSalida dtoSalida = new DTOSalida(resultado);
		UtilidadesLog.info("DAORecaudoEntFin.detalleMovBanc(DTOOID): Salida");

		return dtoSalida;
	}


	/**
	 * Metodo
	 */
	public DTOSalida detalleMovBanc(DTONumeroLote dto) throws MareException {

		UtilidadesLog.info("DAORecaudoEntFin.detalleMovBanc(DTONumeroLote): Entrada");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append("SELECT ");

		consulta.append("m.OID_MOVI_BANC OID, c.COD_CC_BANC, m.FEC_PAGO, m.NUM_LOTE, ");
		consulta.append("m.NUM_CONS_TRAN, t.COD_TIPO_TRAN, ");
		consulta.append("m.IMP_PAGO, i.COD_CLIE, m.COD_CONS, ");
		consulta.append("m.NUM_FACT_BOLE, m.VAL_DIGI_CHEQ_FACT, ");
		consulta.append("m.NUM_CUPO, m.VAL_NUME_DOCU, ");
		consulta.append("m.COD_OFIC_RECA, m.VAL_NOMB_OFIC, ");
		consulta.append("m.VAL_HORA_NORM_ADIC, ");
		consulta.append("m.VAL_USUA_PROC, m.FEC_PROC, ");
		consulta.append("m.VAL_HORA_PROC, m.COD_ERRO, ");
		consulta.append("m.VAL_ESTA_MOVI_PEND, ");
		consulta.append("m.COD_IDEN_PROC, ");
		consulta.append("m.VAL_OBSE ");

		consulta.append("FROM ");
			
		consulta.append("CCC_MOVIM_BANCA m, ");
		consulta.append("CCC_CUENT_CORRI_BANCA c, "); 
		consulta.append("CCC_TIPO_TRANS t, ");
		consulta.append("MAE_CLIEN i "); 

		consulta.append("WHERE ");

		// joins
		consulta.append("m.CCBA_OID_CC_BANC = c.OID_CUEN_CORR_BANC ");
		consulta.append("AND m.TTRA_OID_TIPO_TRANS = t.OID_TIPO_TRAN ");
		consulta.append("AND m.CLIE_OID_CLIE = i.OID_CLIE ");
		
		// filtrado
		if (dto.getNumeroLote() != null) {
			consulta.append("AND m.NUM_LOTE = ?");
			parametros.add(dto.getNumeroLote());
		}
		

		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(), dto);

        try {
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("detalleMovBanc(DTONumeroLote): Exception", e);
            logSql("detalleMovBanc(DTONumeroLote). SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		DTOSalida dtoSalida = new DTOSalida(resultado);
		
		UtilidadesLog.info("DAORecaudoEntFin.detalleMovBanc(DTONumeroLote): Salida");

		return dtoSalida;
	}


	/**
	 * Metodo
	 */
	public DTOSalida buscarMovCCConfirmar(DTOBuscarMovCCConfirmar dto) 
		throws MareException 
	{
	
		UtilidadesLog.info("DAORecaudoEntFin.buscarMovCCConfirmar(DTOBuscarMovCCConfirmar dto): Entrada");
		 
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append("SELECT ");
		consulta.append("FEC_DOCU ");
		consulta.append("FROM ");
		consulta.append("CCC_MOVIM_CUENT_CORRI ");
		consulta.append("WHERE ");

		// filtrado
		boolean seHaFiltrado = false;
		
		if (dto.getNumeroIdentCuota() != null) {
			consulta.append("NUM_IDEN_CUOT = ? ");
			parametros.add(dto.getNumeroIdentCuota());
			seHaFiltrado = true;
		}
		if (dto.getOidCliente() != null) {
			if (seHaFiltrado) {
				consulta.append("AND ");
			}
			consulta.append("CLIE_OID_CLIE = ? ");
			parametros.add(dto.getOidCliente());
			if (!seHaFiltrado) {
				seHaFiltrado = true;
			}
		}
		if (seHaFiltrado) {
			consulta.append("AND ");
		}
		consulta.append("IMP_MOVI <> IMP_PAGA");
		
		UtilidadesLog.debug("***** Consulta: " + consulta.toString());

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("buscarMovCCConfirmar: Exception", e);
            logSql("buscarMovCCConfirmar. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

		DTOSalida dtoSalida = new DTOSalida(resultado);

		UtilidadesLog.info("DAORecaudoEntFin.buscarMovCCConfirmar(DTOBuscarMovCCConfirmar dto): Salida");

		return dtoSalida;
	}

	/**
	 * Este metodo obtiene el saldo inicial para los movimientos basandose en los criterios de busqueda y la fecha de movimiento recibida. Para esto totaliza el importe de pago de todos los movimientos que cumplen los criterios de busqueda y son menores a la fecha de movimiento recibida
     * @param dto DTOBuscarMovBancConsultar con los criterios de busqueda
     * @return BigDecimal con el saldo inicial
     * @exception MareException si no se pudo acceder a la base de datos
	 */
	public BigDecimal obtenerSaldoInicialFechaMovimiento(DTOBuscarMovBancConsultar dto) throws MareException {
	
		UtilidadesLog.info("DAORecaudoEntFin.obtenerSaldoInicialFechaMovimiento(DTOBuscarMovBancConsultar dto): Entrada");
		 
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append(" SELECT ");
	    consulta.append(" sum(IMP_PAGO) "); 
	    consulta.append(" FROM  ");
	    consulta.append(" CCC_MOVIM_BANCA m, "); 
	    consulta.append(" CCC_CUENT_CORRI_BANCA c, "); 
	    consulta.append(" CCC_SUCUR s, "); 
	    consulta.append(" MAE_CLIEN n "); 
	    consulta.append(" WHERE "); 
//--joins 
	    consulta.append(" m.CCBA_OID_CC_BANC = c.OID_CUEN_CORR_BANC "); 
	    consulta.append(" AND c.SUCU_OID_SUCU = s.OID_SUCU "); 
	    consulta.append(" AND m.CLIE_OID_CLIE = n.OID_CLIE "); 
	    consulta.append(" AND m.COD_IDEN_PROC = ? "); 
        parametros.add(CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO);
	    consulta.append(" AND FEC_PAGO < TO_DATE( ?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaDigitacion = sdf.format(dto.getFechaMovimiento());
            parametros.add(fechaDigitacion); 

        //filtros - Si alguno viene a null no se aplicará 
        if (dto.getOidBanco() != null) {
            consulta.append(" AND s.CBAN_OID_BANC = ? ");
            parametros.add(dto.getOidBanco()); 
        }
        if (dto.getOidCuentaCorriente() != null) {
            consulta.append(" AND c.OID_CUEN_CORR_BANC = ? "); 
            parametros.add(dto.getOidCuentaCorriente()); 
        }
        if (dto.getCodigoCliente() != null) {
            consulta.append(" AND n.COD_CLIE = ?  ");
            parametros.add(dto.getCodigoCliente()); 
        }

		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("obtenerSaldoInicialFechaMovimiento: Exception", e);
            logSql("obtenerSaldoInicialFechaMovimiento. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        BigDecimal saldoInicial = new BigDecimal(0);
		if (resultado != null && !resultado.esVacio() && resultado.getValueAt(0, 0) != null) {
            saldoInicial = (BigDecimal)resultado.getValueAt(0, 0);
        }

		UtilidadesLog.info("DAORecaudoEntFin.obtenerSaldoInicialFechaMovimiento(DTOBuscarMovBancConsultar dto): Salida");
		return saldoInicial;
	}

	/**
	 * Este metodo obtiene el saldo inicial para los movimientos basandose en los criterios de busqueda y la fecha de movimiento recibida.
     * Para esto totaliza el importe de pago de todos los movimientos que cumplen los criterios de busqueda y son menores a la fecha de movimiento recibida
     * Utilizando el indicador de situacion de la paginacion se obtiene el saldo acumulado de los movimiento que cumplen con los criterios de busqueda contenidos en las paginas anteriores a la actual.
     * @param dto DTOBuscarMovBancConsultar con los criterios de busqueda e indicador de situacion
     * @return BigDecimal con el saldo inicial
     * @exception MareException si no se pudo acceder a la base de datos 
	 */
	public BigDecimal obtenerSaldoInicialPaginasAnteriores(DTOBuscarMovBancConsultar dto) throws MareException {
	
		UtilidadesLog.info("DAORecaudoEntFin.obtenerSaldoInicialPaginasAnteriores(DTOBuscarMovBancConsultar dto): Entrada");
		 
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append(" SELECT sum(IMP_PAGO) FROM ");
	    consulta.append(" ( SELECT  ROWNUM as linea,  xxx.* FROM (  "); 
	    consulta.append(" SELECT ");
		consulta.append("m.OID_MOVI_BANC OID, c.COD_CC_BANC, m.FEC_PAGO, m.NUM_LOTE, ");
		consulta.append("n.COD_CLIE, n.VAL_NOM1 || ' ' || n.VAL_APE1 || ' ' || n.VAL_APE2, ");
		consulta.append("m.NUM_FACT_BOLE, m.IMP_PAGO, m.COD_IDEN_PROC ");

		consulta.append("FROM ");
		
		consulta.append("CCC_MOVIM_BANCA m, ");
		consulta.append("CCC_CUENT_CORRI_BANCA c, ");
		consulta.append("CCC_SUCUR s, ");
		consulta.append("MAE_CLIEN n ");

		consulta.append("WHERE ");

		//joins 
		consulta.append("m.CCBA_OID_CC_BANC = c.OID_CUEN_CORR_BANC ");
		consulta.append("AND c.SUCU_OID_SUCU = s.OID_SUCU ");
		consulta.append("AND m.CLIE_OID_CLIE = n.OID_CLIE ");

		//criterios - Los que venga a null no se aplican como criterios de filtro 
		if (dto.getOidBanco() != null) {
			consulta.append("AND s.CBAN_OID_BANC = ? ");
			parametros.add(dto.getOidBanco());
		}
		if (dto.getOidCuentaCorriente() != null) {
			consulta.append("AND c.OID_CUEN_CORR_BANC = ? ");
			parametros.add(dto.getOidCuentaCorriente());
		}
		if (dto.getFechaMovimiento() != null) {
            consulta.append("AND m.FEC_PAGO = TO_DATE(?, 'dd-MM-yyyy') ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaMovimiento = sdf.format(dto.getFechaMovimiento());
            parametros.add(fechaMovimiento);
		}
		if (dto.getCodigoCliente() != null) {
			consulta.append("AND n.COD_CLIE = ? ");
			parametros.add(dto.getCodigoCliente());
		}

		
		if (dto.getMovActualizado()!=null && dto.getMovActualizado().booleanValue()) {
			consulta.append("AND m.COD_IDEN_PROC = ? ");
			parametros.add(CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO);
		}

		consulta.append(" ORDER BY c.COD_CC_BANC, m.FEC_PAGO, m.NUM_LOTE, m.NUM_CONS_TRAN");
		consulta.append(" ) xxx ) WHERE  linea <= ? ");
        parametros.add(dto.getIndicadorSituacion());


		// se ejecuta la consulta
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

		try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            logError("obtenerSaldoInicialPaginasAnteriores: Exception", e);
            logSql("obtenerSaldoInicialPaginasAnteriores. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        BigDecimal saldoInicial = new BigDecimal(0);
		if (resultado != null && !resultado.esVacio() && resultado.getValueAt(0, 0) != null) {
            saldoInicial = (BigDecimal)resultado.getValueAt(0, 0);
        }

		UtilidadesLog.info("DAORecaudoEntFin.obtenerSaldoInicialPaginasAnteriores(DTOBuscarMovBancConsultar dto): Salida");
		return saldoInicial;
	}
	/**
	 * Metodo
	 */
	void eliminarDetalleCuponesTramitePorMovBanc(DTOOID dto) throws MareException {
		UtilidadesLog.info("DAORecaudoEntFin.eliminarDetalleCuponesTramitePorMovBanc(DTOOID dto): Entrada");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();

	    consulta.append("DELETE FROM CCC_DETAL_CUPON_TRAMI_DEPUR ");
		consulta.append("WHERE CMBA_OID_MOVI_BANC = ?");

		parametros.add(dto.getOid());

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;

		try  {
            bs.dbService.executePreparedUpdate(consulta.toString(), parametros);
        } catch (Exception ex) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }
		
		UtilidadesLog.info("DAORecaudoEntFin.eliminarDetalleCuponesTramitePorMovBanc(DTOOID dto): Salida");
	}

	private void logError(String mensaje, Throwable e) {
    
		UtilidadesLog.error("*** Error Metodo "+ mensaje + ": " + e.getMessage());
		this.logStackTrace(e);
	}

	private void logStackTrace(Throwable e) {
    
		try {						
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


  public Long obtenerOidError(String codErrorr) throws MareException {
	    UtilidadesLog.info("DAORecaudoEntFin.obtenerOidError(String codErrorr): Entrada");      
		  RecordSet rs;
		  StringBuffer consulta = new StringBuffer();

      consulta.append("SELECT cccTE.oid_erro ");
  		consulta.append("FROM ");
	  	consulta.append("CCC_TIPO_ERROR cccTE ");
  		consulta.append("WHERE ");
  		consulta.append("cccTE.COD_ERRO = '" + codErrorr + "'");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (MareException me) {
          throw me;
      } catch (Exception e) {
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
        
      UtilidadesLog.info("DAORecaudoEntFin.obtenerOidError(String codErrorr): Salida ");
      if ((rs != null) && (rs.getRowCount()>0))
          return new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
      else
          return null;
  }
  
   public Long obtenerOidCueContCero(String cuentCont) throws MareException {
	    UtilidadesLog.info("DAORecaudoEntFin.obtenerOidCueContCero(String cuentCont): Entrada");      
		  RecordSet rs;
		  StringBuffer consulta = new StringBuffer();

      consulta.append("SELECT cccTE.oid_cuen_cont ");
  		consulta.append("FROM ");
	  	consulta.append("CCC_CUENT_CONTA cccTE ");
  		consulta.append("WHERE ");
  		consulta.append("cccTE.COD_CUEN_CONT = '" + cuentCont + "'");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
          rs = bs.dbService.executeStaticQuery(consulta.toString());
      } catch (MareException me) {
          throw me;
      } catch (Exception e) {
          throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
        
      UtilidadesLog.info("DAORecaudoEntFin.obtenerOidCueContCero(String cuentCont): Salida ");
      if ((rs != null) && (rs.getRowCount()>0))
          return new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
      else
          return null;
  }
  
}