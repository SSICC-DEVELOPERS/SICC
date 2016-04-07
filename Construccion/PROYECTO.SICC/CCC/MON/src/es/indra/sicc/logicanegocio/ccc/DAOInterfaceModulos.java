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
import es.indra.sicc.dtos.ccc.DTOEtapasDeCobranzas;
import es.indra.sicc.dtos.ccc.DTOMarcasSalida;
import es.indra.sicc.dtos.ccc.DTOSaldosPorDiasPeriodos;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechas;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.ccc.DTOTotalyDias;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.Vector;

public class DAOInterfaceModulos {
    public DAOInterfaceModulos() {
    }

 public DTOTotal calcularSaldoCCCliente(DTOSaldosPorFechasyVtos dto,
        Long[] oidsMarcasSituacion) throws MareException {
        
        UtilidadesLog.info("DAOInterfaceModulos.calcularSaldoCCCliente(DTOSaldosPorFechasyVtos dto, Long[] oidsMarcasSituacion): Entrada");

        RecordSet resultado = null;
        Vector parametros = new Vector();
        DTOTotal dtoTotal = new DTOTotal();
        StringBuffer consulta = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strOids = null;
		
		if (oidsMarcasSituacion != null){
			strOids = this.cadenaInt(oidsMarcasSituacion);
		}
		
        //Segun incidencia SiCC 20070115 (gacevedo 15/03/2007)
        //----------------------------------------------------
        // Modificado por HRCS - Fecha 20/03/2007 - Incidencia ADAM-3
        consulta.append(" SELECT ");
	    consulta.append("  b.suma - a.suma ");
	    consulta.append(" FROM ");
        consulta.append(" ( ");
	    consulta.append(" SELECT nvl(SUM(b.imp_sald_pend),0) suma ");
        consulta.append(" FROM ccc_movim_banca b ");
        consulta.append(" WHERE b.clie_oid_clie = ? AND b.imp_sald_pend <> 0 ");
        parametros.add(dto.getOidCliente());
	    consulta.append(" ) a, ");
        consulta.append(" ( ");
	    consulta.append(" SELECT nvl(SUM(imp_pend),0) suma ");
        consulta.append(" FROM ccc_movim_cuent_corri m, mae_clien c ");
        consulta.append(" WHERE m.CLIE_OID_CLIE = c.OID_CLIE ");
        if (dto.getOidPais() != null) {
            consulta.append(" AND c.PAIS_OID_PAIS= ? "); //dto.pais
            parametros.add(dto.getOidPais());
        }
        if (dto.getOidCliente() != null) {
            consulta.append(" AND m.CLIE_OID_CLIE = ? "); // dto.oidCliente
            parametros.add(dto.getOidCliente());
        }
        if (dto.getFechaDocDesde() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocDesde = new java.sql.Date(dto.getFechaDocDesde().getTime());
			String sFechaDocDesde = sdf.format(fechaDocDesde);
			consulta.append("	AND m.FEC_DOCU >= TO_DATE( ? ,'YYYY-MM-DD')  "); //dto.fechaDocDesde
            parametros.add(sFechaDocDesde);  
        }
        if (dto.getFechaDocHasta() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocHasta = new java.sql.Date(dto.getFechaDocHasta().getTime());
			String sFechaDocHasta = sdf.format(fechaDocHasta);
			consulta.append("	AND m.FEC_DOCU <= TO_DATE( ? ,'YYYY-MM-DD')  "); //dto.fechaDocHasta
            parametros.add(sFechaDocHasta);  
        }
        if (dto.getFechaVtoDesde() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaVtoDesde = new java.sql.Date(dto.getFechaVtoDesde().getTime());
			String sFechaVtoDesde = sdf.format(fechaVtoDesde);
			consulta.append("	AND m.FEC_VENC >= TO_DATE( ? ,'YYYY-MM-DD')  "); //dto.fechaVtoDesde
            parametros.add(sFechaVtoDesde);  
        }

        if (dto.getFechaVtoHasta() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaVtoHasta = new java.sql.Date(dto.getFechaVtoHasta().getTime());
			String sFechaVtoHasta = sdf.format(fechaVtoHasta);
			consulta.append("	AND m.FEC_VENC <= TO_DATE( ? ,'YYYY-MM-DD')  "); //dto.fechaVtoDesde
            parametros.add(sFechaVtoHasta);  
        }

        if (oidsMarcasSituacion!= null && !strOids.equals("")){  
        consulta.append(" AND m.MASI_OID_MARC_SITU IN (" + strOids + ") ");
			for (int i = 0; i < oidsMarcasSituacion.length; i++) {
				parametros.add(oidsMarcasSituacion[i]);
			}
		}

        consulta.append(" AND m.IMP_MOVI <> m.IMP_PAGA ");
        consulta.append(" ) b ");
       

        //se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("calcularSaldoCCCliente: Exception", e);
            this.logSql("calcularSaldoCCCliente. SQL: ", consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.debug("total en tabla "+resultado.getValueAt(0, 0));
        if (resultado.getValueAt(0,0) != null) {
            dtoTotal.setTotalString(resultado.getValueAt(0, 0).toString());
            dtoTotal.setTotal((BigDecimal)resultado.getValueAt(0, 0));
            UtilidadesLog.debug("total "+dtoTotal.getTotalString());
        }else{
            UtilidadesLog.debug("total vino null mandamos 0");
            dtoTotal.setTotalString("0");
            BigDecimal valor = new BigDecimal(0);
            dtoTotal.setTotal(valor);
        }
        
        UtilidadesLog.info("DAOInterfaceModulos.calcularSaldoCCCliente(DTOSaldosPorFechasyVtos dto, Long[] oidsMarcasSituacion): Salida");
        return dtoTotal;
    }

    public DTOTotalyDias calcularDeudaVencidaCCCCliente(
        DTOSaldosPorDiasPeriodos dto, Long[] oidsMarcasSituacion)
        throws MareException {
        
        UtilidadesLog.info("DAOInterfaceModulos.calcularDeudaVencidaCCCCliente(DTOSaldosPorDiasPeriodos dto, Long[] oidsMarcasSituacion): Entrada");

        RecordSet resultado = null;
        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();
        DTOTotalyDias dtoTotalyDias = new DTOTotalyDias();      

        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());//Fecha del sistema;
		//formateamos la fecha al formato estandar en busquedas
		java.sql.Date formatFechaActual = new java.sql.Date(fechaActual.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sFechaActual = sdf.format(formatFechaActual);
		
		String strOids = null;
		if (oidsMarcasSituacion != null){
			strOids = this.cadenaInt(oidsMarcasSituacion);
		}
		
        consulta.append(" SELECT SUM(IMP_PEND) as suma, "); 
		consulta.append(" MAX( TO_DATE( ? ,'YYYY-MM-DD') - FEC_VENC) as dias ");
		parametros.add(sFechaActual);
        consulta.append(" FROM CCC_MOVIM_CUENT_CORRI m ");
        if (dto.getOidCliente() == null){
              if (dto.getOidPais() != null) {
                consulta.append(" , MAE_CLIEN c ");
              }
        }        
        consulta.append(" WHERE m.IMP_MOVI <> m.IMP_PAGA");
        
        if (dto.getOidCliente() == null){                
        //Los campos del DTOSaldosPorFechas que vengan a "null" no filtrarán
            if (dto.getOidPais() != null) {
                consulta.append(" AND m.CLIE_OID_CLIE = c.OID_CLIE ");
                consulta.append(" AND c.PAIS_OID_PAIS= ? "); //dto.pais
                parametros.add(dto.getOidPais());
            }
        }
        
        if (dto.getOidCliente() != null) {
            consulta.append(" AND m.CLIE_OID_CLIE = ? "); //dto.oidCliente
            parametros.add(dto.getOidCliente());
        }
		
        if (dto.getDiasDesde() != null) {
            consulta.append(" AND ( TO_DATE( ? ,'YYYY-MM-DD') - FEC_VENC) >= ? "); //dto.diasDesde							 
			parametros.add(sFechaActual);
			parametros.add(dto.getDiasDesde());
            consulta.append(" AND ( TO_DATE( ? ,'YYYY-MM-DD') - FEC_VENC) > 0 ");
            parametros.add(sFechaActual);
        }

        if (dto.getDiasHasta() != null) {
            consulta.append(" AND ( TO_DATE( ? ,'YYYY-MM-DD') - FEC_VENC) <= ? "); //dto.diasHasta
			parametros.add(sFechaActual);
			parametros.add(dto.getDiasHasta());
            consulta.append(" AND ( TO_DATE( ? ,'YYYY-MM-DD') - FEC_VENC) > 0 ");
			parametros.add(sFechaActual);           
        }

        if (dto.getOidTipoCliente() != null) {
            consulta.append(" AND m.TICL_OID_TIPO_CLIE= ? "); //dto.oidTipoCliente
            parametros.add(dto.getOidTipoCliente());
        }

        if (dto.getOidTipoPeriodo() != null) {
            consulta.append(" AND m.TIPE_OID_TIPO_PERI = ? "); //dto.oidTipoPeriodo
            parametros.add(dto.getOidTipoPeriodo());
        }

        if (dto.getOidPeriodo() != null) {
            consulta.append(" AND m.PERD_OID_PERI = ? "); //dto.oidPeriodo
            parametros.add(dto.getOidPeriodo());
        }
		if (oidsMarcasSituacion!= null && !strOids.equals("")){
        consulta.append(" AND m.MASI_OID_MARC_SITU IN (" + strOids + ") ");
			for (int i = 0; i < oidsMarcasSituacion.length; i++) {
				parametros.add(oidsMarcasSituacion[i]);
			}
		}
		
        		        
        //se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("calcularDeudaVencidaCCCCliente: Exception", e);
            this.logSql("calcularDeudaVencidaCCCCliente. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (resultado.getValueAt(0,0) != null) {
            dtoTotalyDias.setTotal((BigDecimal) resultado.getValueAt(0, 0));
            dtoTotalyDias.setNumeroDias(new Integer(
                    ((BigDecimal) resultado.getValueAt(0, 1)).intValue()));
        } else {
            BigDecimal bValor = new BigDecimal(0);
            Integer iValor = new Integer(0);
            dtoTotalyDias.setTotal(bValor);
            dtoTotalyDias.setNumeroDias(iValor);
        }

        UtilidadesLog.info("DAOInterfaceModulos.calcularDeudaVencidaCCCCliente(DTOSaldosPorDiasPeriodos dto, Long[] oidsMarcasSituacion): Salida");

        return dtoTotalyDias;
    }

    public DTOTotal calcularCuponTramiteCliente(DTOSaldosPorFechas dto)
        throws MareException {
        
        UtilidadesLog.info("DAOInterfaceModulos.calcularCuponTramiteCliente(DTOSaldosPorFechas dto): Entrada");

        RecordSet resultado = null;
        Vector parametros = new Vector();
        DTOTotal dtoTotal = new DTOTotal();
        StringBuffer consulta = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        consulta.append(" SELECT SUM(d.IMP_DETA) as suma ");
        consulta.append(" FROM CCC_CUPON_TRAMI_DEPUR c, ");
        consulta.append(" CCC_DETAL_CUPON_TRAMI_DEPUR d, ");
        consulta.append(" CCC_SITUA_CUPON s ");
        consulta.append(" WHERE c.OID_CUPO_TRAM_DEPU = d.CTDE_OID_CUPO_TRAM_DEPU ");
        consulta.append(" AND d.SICU_OID_SITU_CUPO = s.OID_SITU_CUPO ");

		//Los campos del DTOSaldosPorFechas que vengan a "null" no filtrarán 
        if (dto.getOidPais() != null) {
            consulta.append(" AND c.PAIS_OID_PAIS = ? "); //dto.pais
            parametros.add(dto.getOidPais());
        }

        if (dto.getOidCliente() != null) {
            consulta.append(" AND d.CLIE_OID_CLIE = ? "); //dto.oidCliente
            parametros.add(dto.getOidCliente());
        }

        if (dto.getFechaDocDesde() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocDesde = new java.sql.Date(dto.getFechaDocDesde().getTime());
			String sFechaDocDesde = sdf.format(fechaDocDesde);
            consulta.append(" AND d.FEC_DOCU >= TO_DATE( ? ,'YYYY-MM-DD') "); //dto.fechaDocDesde
			parametros.add(sFechaDocDesde);
        }

        if (dto.getFechaDocHasta() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocHasta = new java.sql.Date(dto.getFechaDocHasta().getTime());
			String sFechaDocHasta = sdf.format(fechaDocHasta);
            consulta.append(" AND d.FEC_DOCU <= TO_DATE( ? ,'YYYY-MM-DD') "); //dto.fechaDocHasta
           parametros.add(sFechaDocHasta);
        }

        consulta.append("	AND s.COD_SITU_CUPO = '" + CCCConstantes.SITUACION_CUPON_TRAMITE + "'");
        //se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("calcularCuponTramiteCliente: Exception", e);
            this.logSql("calcularCuponTramiteCliente. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (resultado.getValueAt(0,0) != null) {
            dtoTotal.setTotal((BigDecimal) resultado.getValueAt(0, 0));
        } else {
            BigDecimal valor = new BigDecimal(0);
            dtoTotal.setTotal(valor);
        }

        UtilidadesLog.info("DAOInterfaceModulos.calcularCuponTramiteCliente(DTOSaldosPorFechas dto): Salida");

        return dtoTotal;
    }

    public RecordSet calcularDiasAtrasoCliente(DTOSaldosPorFechasyVtos dto,
        Long[] oidsMarcasSituacion) throws MareException {
        
        UtilidadesLog.info("DAOInterfaceModulos.calcularDiasAtrasoCliente(DTOSaldosPorFechasyVtos dto, Long[] oidsMarcasSituacion): Entrada");

        RecordSet resultado = null;
        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();        

        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());//Fecha del sistema;
		//formateamos la fecha al formato estandar en busquedas
		java.sql.Date formatFechaActual = new java.sql.Date(fechaActual.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sFechaActual = sdf.format(formatFechaActual);
		
		String strOids = null;
		if (oidsMarcasSituacion!= null && oidsMarcasSituacion != null){
			strOids = this.cadenaInt(oidsMarcasSituacion);
		}

        /* Elimina DBLG700000200 eiraola
        consulta.append(" SELECT m.FEC_ULTI_MOVI, m.FEC_VENC, m.IMP_PEND, NVL (m.IMP_PAGO, 0) IMP_PAGO ");
        consulta.append(" FROM CCC_MOVIM_CUENT_CORRI m, MAE_CLIEN c ");
        consulta.append(" WHERE m.CLIE_OID_CLIE = c.OID_CLIE ");

        //Los campos del DTOSaldosPorFechasyVtos que vengan a "null" no filtrarán 
        if (dto.getOidPais() != null) {
            consulta.append(" AND c.PAIS_OID_PAIS= ? "); // dto.pais
            parametros.add(dto.getOidPais());
        }

        if (dto.getOidCliente() != null) {
            consulta.append(" AND m.CLIE_OID_CLIE = ? "); //dto.oidCliente
            parametros.add(dto.getOidCliente());
        }

        if (dto.getFechaDocDesde() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocDesde = new java.sql.Date(dto.getFechaDocDesde().getTime());
			String sFechaDocDesde = sdf.format(fechaDocDesde);
            consulta.append(" AND m.FEC_DOCU >= TO_DATE( ? ,'YYYY-MM-DD') "); //dto.fechaDocDesde
            parametros.add(sFechaDocDesde);
        }

        if (dto.getFechaDocHasta() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocHasta = new java.sql.Date(dto.getFechaDocHasta().getTime());
			String sFechaDocHasta = sdf.format(fechaDocHasta);
            consulta.append(" AND m.FEC_DOCU <= TO_DATE( ? ,'YYYY-MM-DD') "); //dto.fechaDocHasta
            parametros.add(sFechaDocHasta);
        }

        if (dto.getFechaVtoDesde() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaVtoDesde = new java.sql.Date(dto.getFechaVtoDesde().getTime());
			String sFechaVtoDesde = sdf.format(fechaVtoDesde);
            consulta.append(" AND m.FEC_VENC >= TO_DATE( ? ,'YYYY-MM-DD') "); //dto.fechaVtoDesde
            parametros.add(sFechaVtoDesde);
        }

        if (dto.getFechaVtoHasta() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaVtoHasta = new java.sql.Date(dto.getFechaVtoHasta().getTime());
			String sfechaVtoHasta = sdf.format(fechaVtoHasta);
            consulta.append(" AND m.FEC_VENC <= TO_DATE( ? ,'YYYY-MM-DD') "); //dto.fechaVtoHasta
            parametros.add(sfechaVtoHasta);
        }

        consulta.append(" AND ( TO_DATE( ? ,'YYYY-MM-DD') - m.FEC_VENC) > 0 ");
		parametros.add(sFechaActual);
		if (oidsMarcasSituacion!= null && !strOids.equals("")){
        consulta.append(" AND m.MASI_OID_MARC_SITU IN (" + strOids + ") ");
			for (int i = 0; i < oidsMarcasSituacion.length; i++) {
				parametros.add(oidsMarcasSituacion[i]);
			}
		}
		
        consulta.append(" AND m.IMP_MOVI <> m.IMP_PAGA ");
        consulta.append(" AND m.IMP_PAGO <> 0 ");
        consulta.append(" AND m.FEC_ULTI_MOVI > m.FEC_VENC ");

        consulta.append(" UNION ");

        consulta.append(" SELECT h.FEC_MOVI, h.FEC_VENC, h.IMP_PEN, NVL (h.IMP_PAGO, 0) IMP_PAGO ");
        consulta.append(" FROM CCC_HISTO_MOVIM_CC h, MAE_CLIEN c ");
        consulta.append(" WHERE h.CLIE_OID_CLIE = c.OID_CLIE ");

		//Los campos del DTOSaldosPorFechasyVtos que vengan a "null" no filtrarán
        if (dto.getOidPais() != null) {
            consulta.append(" AND c.PAIS_OID_PAIS= ? "); // dto.pais
            parametros.add(dto.getOidPais());
        }

        if (dto.getOidCliente() != null) {
            consulta.append(" AND h.CLIE_OID_CLIE = ? "); //dto.oidCliente
            parametros.add(dto.getOidCliente());
        }
		
        if (dto.getFechaDocDesde() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocDesde = new java.sql.Date(dto.getFechaDocDesde().getTime());
			String sFechaDocDesde = sdf.format(fechaDocDesde);
            consulta.append(" AND h.FEC_DOCU >= TO_DATE( ? ,'YYYY-MM-DD') "); //dto.fechaDocDesde
            parametros.add(sFechaDocDesde);
        }

        if (dto.getFechaDocHasta() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocHasta = new java.sql.Date(dto.getFechaDocHasta().getTime());
			String sFechaDocHasta = sdf.format(fechaDocHasta);
            consulta.append("	AND h.FEC_DOCU <= TO_DATE( ? ,'YYYY-MM-DD')   "); //dto.fechaDocHasta
            parametros.add(sFechaDocHasta);
        }

        if (dto.getFechaVtoDesde() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaVtoDesde = new java.sql.Date(dto.getFechaVtoDesde().getTime());
			String sFechaVtoDesde = sdf.format(fechaVtoDesde);
            consulta.append(" AND h.FEC_VENC >= TO_DATE( ? ,'YYYY-MM-DD') "); //dto.fechaVtoDesde
            parametros.add(sFechaVtoDesde);
        }

        if (dto.getFechaVtoHasta() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaVtoHasta = new java.sql.Date(dto.getFechaVtoHasta().getTime());
			String sFechaVtoHasta = sdf.format(fechaVtoHasta);
            consulta.append(" AND h.FEC_VENC <= TO_DATE( ? ,'YYYY-MM-DD') "); //dto.fechaVtoHasta
            parametros.add(sFechaVtoHasta);
        }

        consulta.append(" AND ( TO_DATE( ? ,'YYYY-MM-DD') - h.FEC_VENC) > 0 ");
		parametros.add(sFechaActual);

		if (oidsMarcasSituacion!= null && !strOids.equals("")){
        consulta.append(" AND h.MASI_OID_MARC_SITU IN (" + strOids + ") ");
			for (int i = 0; i < oidsMarcasSituacion.length; i++) {
				parametros.add(oidsMarcasSituacion[i]);
			}
		}
        consulta.append(" AND h.IMP <> h.IMP_PAGA ");
        consulta.append(" AND h.IMP_PAGO <> 0 ");
        consulta.append(" AND h.FEC_MOVI > h.FEC_VENC "); */

        // Inc. DBLG700000200 eiraola
        consulta.append(" SELECT m.FEC_DOCU, m.IMP_MOVI, m.IMP_PAGA ");
        consulta.append("   FROM CCC_MOVIM_CUENT_CORRI m, ");
        consulta.append("        MAE_CLIEN c ");
        consulta.append("  WHERE m.CLIE_OID_CLIE = c.OID_CLIE ");
        
        if (dto.getOidPais() != null) {
            consulta.append("AND c.PAIS_OID_PAIS= ? ");
            parametros.add(dto.getOidPais());
        }
        
        if (dto.getOidCliente() != null) {
            consulta.append("AND m.CLIE_OID_CLIE = ? ");
            parametros.add(dto.getOidCliente());
        }
        
        if (dto.getFechaDocDesde() != null) {
            java.sql.Date fechaDocDesde = new java.sql.Date(dto.getFechaDocDesde().getTime());
            String sFechaDocDesde = sdf.format(fechaDocDesde);
            consulta.append(" AND m.FEC_DOCU >= TO_DATE( ? , 'YYYY-MM-DD') ");
            parametros.add(sFechaDocDesde);
        }
        
        if (dto.getFechaDocHasta() != null) {
            java.sql.Date fechaDocHasta = new java.sql.Date(dto.getFechaDocHasta().getTime());
            String sFechaDocHasta = sdf.format(fechaDocHasta);
            consulta.append(" AND m.FEC_DOCU <= TO_DATE( ? , 'YYYY-MM-DD') "); //dto.fechaDocHasta
            parametros.add(sFechaDocHasta);
        }
        
        if (dto.getFechaVtoDesde() != null) {
            java.sql.Date fechaVtoDesde = new java.sql.Date(dto.getFechaVtoDesde().getTime());
            String sFechaVtoDesde = sdf.format(fechaVtoDesde);
            consulta.append(" AND m.FEC_VENC >= TO_DATE( ? , 'YYYY-MM-DD') ");
            parametros.add(sFechaVtoDesde);
        }
        
        if (dto.getFechaVtoHasta() != null) {
            java.sql.Date fechaVtoHasta = new java.sql.Date(dto.getFechaVtoHasta().getTime());
            String sfechaVtoHasta = sdf.format(fechaVtoHasta);
            consulta.append(" AND m.FEC_VENC <= TO_DATE( ? , 'YYYY-MM-DD') ");
            parametros.add(sfechaVtoHasta);
        }
        
        consulta.append(" AND ( TO_DATE( ? , 'YYYY-MM-DD') - m.FEC_VENC) > 0 ");
        parametros.add(sFechaActual);
        
        
        if (oidsMarcasSituacion!= null && !strOids.equals("")){
            consulta.append(" AND m.MASI_OID_MARC_SITU IN (" + strOids + ") ");
            
            for (int i = 0; i < oidsMarcasSituacion.length; i++) {
                parametros.add(oidsMarcasSituacion[i]);
            }
        }
        consulta.append(" AND (m.IMP_MOVI - m.IMP_PAGA) > 0 ");

        //Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("calcularDiasAtrasoCliente: Exception", e);
            this.logSql("calcularDiasAtrasoCliente. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOInterfaceModulos.calcularDiasAtrasoCliente(DTOSaldosPorFechasyVtos dto, Long[] oidsMarcasSituacion): Salida");

        //Salida: RecordSet con campos de fecha 
        return resultado;
    }

	public DTOTotal consultarCuentasCastigadasCliente(DTOMarcasSalida dto) throws MareException {
		/* Permite la consulta del total del importe pendiente de cuentas castigadas 
		 * (que tengan como marcas de salida las recibidas) de un cliente concreto 
		 * entre unas determinadas fechas, Vtos y para marcas de salida (proceso: 
		 * "CON002" y subproceso="1" //Consulta de deuda provisionada) */
		
        UtilidadesLog.info("DAOInterfaceModulos.consultarCuentasCastigadasCliente(DTOMarcasSalida dto): Entrada");
		DTOTotal dtoS = null;
		dtoS = new DTOTotal();
		RecordSet resultado = null; 
		Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strOids = null;
		Long[] oidsMarcasSalida = null;
		oidsMarcasSalida = dto.getOidsMarcasSalida();
		if (oidsMarcasSalida != null){
			strOids = this.cadenaInt(oidsMarcasSalida);
		}
		
		consulta.append("SELECT SUM(IMP_PEND) ");
		consulta.append("FROM ");
		consulta.append("CCC_MOVIM_CUENT_CORRI ");
		consulta.append("WHERE ");
		//criterios de filtro: No aplicamos los que venga a null 
		if (dto.getOidCliente() != null) {
            consulta.append("CLIE_OID_CLIE = ? AND "); //dto.oidCliente
            parametros.add(dto.getOidCliente());
        }
		if(dto.getFechaDocDesde() != null) { 
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocDesde = new java.sql.Date(dto.getFechaDocDesde().getTime());
			String sFechaDocDesde = sdf.format(fechaDocDesde);
			consulta.append("FEC_DOCU >= TO_DATE( ? ,'YYYY-MM-DD') AND "); //dto.fechaDocDesde
			parametros.add(sFechaDocDesde);
		}
		if(dto.getFechaDocHasta() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaDocHasta = new java.sql.Date(dto.getFechaDocHasta().getTime());
			String sFechaDocHasta = sdf.format(fechaDocHasta);
			//consulta.append("FEC_DOCU <= TO_DATE( ? ,'YYYY-MM-DD') AND "); //dto.fechaDocHasta
			consulta.append("TO_DATE(TO_CHAR(FEC_DOCU, 'YYYY-MM-DD'), 'YYYY-MM-DD') <= TO_DATE(?, 'YYYY-MM-DD') AND "); //dto.fechaDocHasta
            parametros.add(sFechaDocHasta);
		}
		if(dto.getFechaVtoDesde() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaVtoDesde = new java.sql.Date(dto.getFechaVtoDesde().getTime());
			String sFechaVtoDesde = sdf.format(fechaVtoDesde);
			consulta.append("FEC_VENC >= TO_DATE( ? ,'YYYY-MM-DD') AND "); //dto.fechaVtoDesde
			parametros.add(sFechaVtoDesde);
		}
		if(dto.getFechaVtoHasta() != null) {
			//formateamos la fecha al formato estandar en busquedas
			java.sql.Date fechaVtoHasta = new java.sql.Date(dto.getFechaVtoHasta().getTime());
			String sFechaVtoHasta = sdf.format(fechaVtoHasta);
			consulta.append("FEC_VENC <= TO_DATE( ? ,'YYYY-MM-DD') AND "); //dto.fechaVtoHasta
			parametros.add(sFechaVtoHasta);
		}
		if (oidsMarcasSalida != null && !strOids.equals("")){
			consulta.append("MASI_OID_MARC_SITU IN (" + strOids + ") AND "); //dto.oidsMarcasSalida
		for (int i = 0; i < oidsMarcasSalida.length; i++) {
				parametros.add(oidsMarcasSalida[i]);
			}
		}
		
		consulta.append("IMP_MOVI <> IMP_PAGA ");

		//Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("consultarCuentasCastigadasCliente: Exception", e);
            this.logSql("consultarCuentasCastigadasCliente. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
		
		if(resultado.getValueAt(0,0) != null){
			dtoS.setTotal((BigDecimal)resultado.getValueAt(0,0));
		}else {
            BigDecimal valor = new BigDecimal(0);
            dtoS.setTotal(valor);
        }
		UtilidadesLog.info("DAOInterfaceModulos.consultarCuentasCastigadasCliente(DTOMarcasSalida dto): Salida");
		return dtoS;
	}

    /*=============================METODOS PRIVADOS=================================*/
    
    
    private void logStackTrace(Throwable e) {
        try {
            UtilidadesLog.error(e);
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }

    private void logSql(String metodo, String sql, Vector params) {
    
        UtilidadesLog.debug(metodo + sql);
        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
    }

    private String cadenaInt(Long[] cadena) {
    
        UtilidadesLog.info("DAOInterfaceModulos.cadenaInt(Long[] cadena): Entrada");
        int i;
        int size = cadena.length;
        StringBuffer sentencia = new StringBuffer("");
        String retorno = "";

        if (size > 0) {
            for (i = 0; i < size; i++) {
                sentencia.append(" ?, ");
            }

            //Quitamos la coma y el espacio del final
            retorno = sentencia.substring(0, sentencia.length() - 2);
        }
        UtilidadesLog.info("DAOInterfaceModulos.cadenaInt(Long[] cadena): Salida");
        return retorno;
    }
    
    
  /**
   * @Author: ssantana, 15/2/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida   
   * @Modificado: 27/10/2005 Hugo Mansi
   **/
    public DTOSalida consultarClientesDeudaVencidaUA(DTOEtapasDeCobranzas dto) throws MareException {
      
      UtilidadesLog.info("DAOInterfaceModulos.consultarClientesDeudaVencidaUA(DTOEtapasDeCobranzas dto): Entrada");
      RecordSet r = new RecordSet();
      DTOSalida dtoSalida = new DTOSalida();
      String query = null;
      
      StringBuffer sqlSelect = new StringBuffer("");
      StringBuffer sqlFrom = new StringBuffer("");
      StringBuffer sqlWhere = new StringBuffer("");

//Esta query fue comentada por Hugo Mansi para mejorar la estructura de la misma y mejorar el rendimiento      
// -------------------------------------------------------------------------------------
/*      sqlSelect.append(" SELECT maec.cod_clie codigocliente, ");
      sqlSelect.append(" canal.cod_cana canal, ");
      sqlSelect.append(" acces.cod_acce acceso, ");
      sqlSelect.append(" subacc.cod_sbac subacceso, ");
      sqlSelect.append(" movicc.num_iden_cuot numeroindentificadorcuota, ");
      sqlSelect.append(" movicc.val_ejer_cuot ejerciciocuota, ");
      sqlSelect.append(" movicc.num_orde_cuot numeroordencuota, ");
      sqlSelect.append(" movicc.tcab_oid_tcab_ulti tipocargoabono, ");
      sqlSelect.append(" socie.val_deno empresa, ");
      
      // Modificado por ssantana, 16/9/2005, a pedido de Hugo Mansi (peru)
      //sqlSelect.append(" movicc.imp_movi_cuen importe, ");
      sqlSelect.append(" movicc.IMP_MOVI importe, ");
      // Fin Modificacion por ssantana, 16/9/2005. 
      
      sqlSelect.append(" movicc.imp_movi_cuen importe, ");
      sqlSelect.append(" movicc.imp_pend importependiente, ");
      sqlSelect.append(" maec.oid_clie oidcliente, ");
      sqlSelect.append(" movicc.oid_movi_cc oidCuota, ");
      sqlSelect.append(" socie.OID_SOCI oidSociedad, ");
      sqlSelect.append(" maeclisubt.OID_CLIE_TIPO_SUBT oidClienteTipoSubtipo ");
      
      sqlFrom.append(" FROM ccc_movim_cuent_corri movicc, ");
      sqlFrom.append(" mae_clien maec, ");
      sqlFrom.append(" MAE_CLIEN_TIPO_SUBTI maeclisubt, ");
      sqlFrom.append(" zon_terri_admin zonterriadm, "); 
      sqlFrom.append(" zon_terri zonterri, ");
      sqlFrom.append(" zon_secci zonsecc, ");
      sqlFrom.append(" zon_zona zonzona,  ");
      sqlFrom.append(" zon_regio zonregion,  ");
      sqlFrom.append(" zon_sub_geren_venta zonsubge,  ");
      sqlFrom.append(" seg_canal canal,  ");
      sqlFrom.append(" cra_perio peri,  ");
      sqlFrom.append(" seg_acces acces,  ");
      sqlFrom.append(" seg_subac subacc, ");
      sqlFrom.append(" ccc_tipo_cargo_abono tipocab, ");
      sqlFrom.append(" seg_socie socie,  ");
      sqlFrom.append(" (SELECT marcata.masi_oid_marc_sali oidmarcasi ");
      sqlFrom.append(" FROM ccc_marca_tipo_abono marcata, ");
      sqlFrom.append(" ccc_tipo_abono_subpr tipoab ");
      sqlFrom.append(" WHERE tipoab.subp_oid_subp = " + CCCConstantes.PROCESO_CON001_SP1);
      sqlFrom.append(" AND marcata.tasp_oid_tipo_abon_subp = tipoab.oid_tipo_abon_subp ");
      sqlFrom.append(" AND marcata.ind_entr_sali = 'S') marcasitu ");


      sqlWhere.append(" WHERE movicc.clie_oid_clie = maec.oid_clie ");
      if (dto.getOidTerritorio() != null)  {
         sqlWhere.append(" AND zonterri.oid_terr = " + dto.getOidTerritorio() ); 
         sqlWhere.append(" AND zonterriadm.TERR_OID_TERR = zonterri.OID_TERR ");
         sqlWhere.append(" AND movicc.ZTAD_OID_TERR_ADMI = zonterriadm.OID_TERR_ADMI ");
         sqlWhere.append(" AND movicc.ztad_oid_terr_admi = zonterriadm.oid_terr_admi ");
      }          
      
      if (dto.getOidSeccion() != null) {
         sqlWhere.append(" AND zonsecc.oid_secc = " + dto.getOidSeccion() );
         sqlWhere.append(" AND zonterriadm.zscc_oid_secc = zonsecc.oid_secc ");
         sqlWhere.append(" AND zonterriadm.TERR_OID_TERR = zonterri.OID_TERR ");  
         sqlWhere.append(" and movicc.ZSCC_OID_SECC = zonsecc.OID_SECC ");
         sqlWhere.append(" AND movicc.ZTAD_OID_TERR_ADMI = zonterriadm.OID_TERR_ADMI ");
         sqlWhere.append(" AND movicc.ztad_oid_terr_admi = zonterriadm.oid_terr_admi ");
      }
      
      if (dto.getOidZona() != null) {
         sqlWhere.append(" AND zonzona.oid_zona = " + dto.getOidZona() );
         sqlWhere.append(" AND zonsecc.zzon_oid_zona = zonzona.oid_zona ");
         sqlWhere.append(" AND zonterriadm.zscc_oid_secc = zonsecc.oid_secc "); 
         sqlWhere.append(" AND zonterriadm.TERR_OID_TERR = zonterri.OID_TERR  ");   
         sqlWhere.append(" and movicc.ZSCC_OID_SECC = zonsecc.OID_SECC ");
         sqlWhere.append(" and movicc.ZTAD_OID_TERR_ADMI = zonterriadm.OID_TERR_ADMI ");
         sqlWhere.append(" AND movicc.ztad_oid_terr_admi = zonterriadm.oid_terr_admi ");
      }
      
      if  (dto.getOidRegion() != null)  {
         sqlWhere.append(" AND zonregion.oid_regi = " + dto.getOidRegion() ); 
         sqlWhere.append(" AND zonzona.zorg_oid_regi = zonregion.oid_regi ");
         sqlWhere.append(" AND zonsecc.zzon_oid_zona = zonzona.oid_zona ");
         sqlWhere.append(" AND zonterriadm.zscc_oid_secc = zonsecc.oid_secc ");
         sqlWhere.append(" AND zonterriadm.TERR_OID_TERR = zonterri.OID_TERR ");  
         sqlWhere.append(" and movicc.ZORG_OID_REGI = zonregion.OID_REGI ");
         sqlWhere.append(" and movicc.ZSCC_OID_SECC = zonsecc.OID_SECC ");
         sqlWhere.append(" and movicc.ZTAD_OID_TERR_ADMI = zonterriadm.OID_TERR_ADMI ");
         sqlWhere.append(" AND movicc.ztad_oid_terr_admi = zonterriadm.oid_terr_admi ");
      }

      if (dto.getOidSubgerenciaVentas() != null) {
         sqlWhere.append(" AND zonsubge.oid_subg_vent = " + dto.getOidSubgerenciaVentas() );
         sqlWhere.append(" AND zonregion.zsgv_oid_subg_vent = zonsubge.oid_subg_vent ");
         sqlWhere.append(" AND zonzona.zorg_oid_regi = zonregion.oid_regi ");
         sqlWhere.append(" AND zonsecc.zzon_oid_zona = zonzona.oid_zona ");
         sqlWhere.append(" AND zonterriadm.zscc_oid_secc = zonsecc.oid_secc ");
         sqlWhere.append(" AND zonterriadm.TERR_OID_TERR = zonterri.OID_TERR ");  
         sqlWhere.append(" AND movicc.ztad_oid_terr_admi = zonterriadm.oid_terr_admi ");
         sqlWhere.append(" and movicc.ZSGV_OID_SUBG_VENT = zonsubge.OID_SUBG_VENT ");
         sqlWhere.append(" and movicc.ZORG_OID_REGI = zonregion.OID_REGI ");
         sqlWhere.append(" and movicc.ZSCC_OID_SECC = zonsecc.OID_SECC ");
         sqlWhere.append(" and movicc.ZTAD_OID_TERR_ADMI = zonterriadm.OID_TERR_ADMI ");
         sqlWhere.append(" AND movicc.ztad_oid_terr_admi = zonterriadm.oid_terr_admi ");
      }

      sqlWhere.append(" AND peri.OID_PERI = " + dto.getOidPeriodoOrigen() );
      sqlWhere.append(" AND peri.oid_peri = movicc.perd_oid_peri ");
      sqlWhere.append(" AND canal.oid_cana = peri.cana_oid_cana ");
      
      if (dto.getOidCanal() != null) {
         sqlWhere.append(" AND canal.oid_cana = " + dto.getOidCanal() );
      }      
      
      sqlWhere.append(" AND subacc.acce_oid_acce = acces.oid_acce ");
      sqlWhere.append(" AND subacc.OID_SBAC = movicc.SBAC_OID_SBAC ");

      //Modificado por incidencia 21210
      //Modificó Hugo Mansi
      //Fecha: 13/10/2005
      //Se reemplazó movicc.tcab_oid_tcab_ulti por movicc.tcab_oid_tcab_crea
      
      if (dto.getOidTipoCargoAbono() != null) {
         sqlWhere.append(" AND tipocab.oid_tipo_carg_abon = movicc.tcab_oid_tcab_crea ");
         sqlWhere.append(" AND tipocab.OID_TIPO_CARG_ABON = " + dto.getOidTipoCargoAbono());
      }

      sqlWhere.append(" AND movicc.masi_oid_marc_situ = marcasitu.oidmarcasi ");
      sqlWhere.append(" AND movicc.SOCI_OID_SOCI = socie.OID_SOCI ");
      sqlWhere.append(" AND maec.oid_clie = maeclisubt.clie_oid_clie "); 
      sqlWhere.append(" AND movicc.TICL_OID_TIPO_CLIE = maeclisubt.TICL_OID_TIPO_CLIE ");

      sqlWhere.append(" AND movicc.OID_MOVI_CC NOT IN( ");
      sqlWhere.append(" SELECT  cac.MVCC_OID_MOVI_CC "); 
      sqlWhere.append(" FROM COB_ASIGN_COBRA cac, COB_CRONO_COBRA crono "); 
      sqlWhere.append(" WHERE cac.CRCO_OID_CRON_COBR = crono.OID_CRON_COBR ");
      sqlWhere.append(" AND crono.ETDE_OID_ETAP_DEUD = "+dto.getOidEtapa()+" ");
      sqlWhere.append(" ) ");
      
      sqlWhere.append(" AND " + dto.getEdadInicial() + " > 0");
      sqlWhere.append(" AND (SYSDATE - movicc.FEC_VENC) between ");
      sqlWhere.append( dto.getEdadInicial() + " AND " + dto.getEdadFinal() );
      sqlWhere.append(" AND " + dto.getImporteDesde() + " > 0 ");
      sqlWhere.append(" AND movicc.IMP_PEND between ");
      sqlWhere.append( dto.getImporteDesde() + " AND " +   dto.getImporteHasta());
      sqlWhere.append(" ORDER BY codigocliente, importependiente ");
  */    
      sqlSelect.append(" SELECT maec.cod_clie codigocliente, ");
      sqlSelect.append(" canal.cod_cana canal, ");
      sqlSelect.append(" acces.cod_acce acceso, ");
      sqlSelect.append(" subacc.cod_sbac subacceso, ");
      sqlSelect.append(" movicc.num_iden_cuot numeroindentificadorcuota, ");
      sqlSelect.append(" movicc.val_ejer_cuot ejerciciocuota, ");
      sqlSelect.append(" movicc.num_orde_cuot numeroordencuota, ");
      sqlSelect.append(" movicc.tcab_oid_tcab_ulti tipocargoabono, ");
      sqlSelect.append(" socie.val_deno empresa, ");
      sqlSelect.append(" movicc.imp_movi importe, ");      
      sqlSelect.append(" movicc.imp_pend importependiente, ");
      sqlSelect.append(" maec.oid_clie oidcliente, ");
      sqlSelect.append(" movicc.oid_movi_cc oidCuota, ");
      sqlSelect.append(" socie.OID_SOCI oidSociedad, ");
      sqlSelect.append(" maeclisubt.OID_CLIE_TIPO_SUBT oidClienteTipoSubtipo ");

      sqlFrom.append(" FROM ccc_movim_cuent_corri movicc, ");
      sqlFrom.append(" mae_clien maec, ");
      sqlFrom.append(" MAE_CLIEN_TIPO_SUBTI maeclisubt, ");
      sqlFrom.append(" seg_canal canal,  ");
      sqlFrom.append(" cra_perio peri,  ");
      sqlFrom.append(" seg_acces acces,  ");
      sqlFrom.append(" seg_subac subacc, ");
      sqlFrom.append(" ccc_tipo_cargo_abono tipocab, ");
      sqlFrom.append(" seg_socie socie,  ");
      sqlFrom.append(" ( SELECT marcata.masi_oid_marc_sali oidmarcasi ");
      sqlFrom.append("   FROM ccc_marca_tipo_abono marcata, ");
      sqlFrom.append("   ccc_tipo_abono_subpr tipoab, ");
      sqlFrom.append("   ccc_subpr subpro, ");
      sqlFrom.append("   ccc_proce proce ");
      sqlFrom.append("   WHERE marcata.tasp_oid_tipo_abon_subp = tipoab.oid_tipo_abon_subp ");
      sqlFrom.append("   AND tipoab.subp_oid_subp = subpro.oid_subp ");
      sqlFrom.append("   AND subpro.ccpr_oid_proc = proce.oid_proc ");
      sqlFrom.append("   AND subpro.cod_subp = " + CCCConstantes.SUBPROCESO_CONSULTA_DEUDA);
      sqlFrom.append("   AND proce.cod_proc = '" + CCCConstantes.PROCESO_CON001 + "' ");
      sqlFrom.append("   AND marcata.ind_entr_sali = 'E' ) marcasitu ");

      sqlWhere.append(" WHERE movicc.clie_oid_clie = maec.oid_clie ");
      if (dto.getOidSubgerenciaVentas() != null) {
         sqlWhere.append(" AND zonsubge.oid_subg_vent = " + dto.getOidSubgerenciaVentas() );
	     sqlWhere.append(" and movicc.ZSGV_OID_SUBG_VENT = zonsubge.OID_SUBG_VENT ");
	     sqlFrom.append(" ,zon_sub_geren_venta zonsubge  ");
 	     if (dto.getOidRegion() != null)  {
           sqlWhere.append(" AND zonregion.oid_regi = " + dto.getOidRegion() ); 
           sqlWhere.append(" AND zonsubge.oid_subg_vent = zonregion.ZSGV_OID_SUBG_VENT ");
           sqlWhere.append(" and movicc.ZORG_OID_REGI = zonregion.oid_regi ");
	       sqlFrom.append(" ,zon_regio zonregion  ");
	       if (dto.getOidZona() != null) {
	         sqlWhere.append(" AND zonzona.oid_zona = " + dto.getOidZona() );
             sqlWhere.append(" AND zonzona.ZORG_OID_REGI = zonregion.oid_regi ");  
             sqlFrom.append(" ,zon_zona zonzona  ");
		     if (dto.getOidSeccion() != null){
               sqlWhere.append(" AND zonsecc.oid_secc = " + dto.getOidSeccion() );
               sqlWhere.append(" AND zonzona.oid_zona = zonsecc.ZZON_OID_ZONA ");       
		       sqlWhere.append(" and movicc.ZSCC_OID_SECC = zonsecc.oid_secc ");
    		   sqlFrom.append(" ,zon_secci zonsecc ");
			   if (dto.getOidTerritorio() != null)  {
                 sqlWhere.append(" AND zonterri.oid_terr = " + dto.getOidTerritorio() ); 
                 sqlWhere.append(" AND zonterri.oid_terr = zonterriadm.TERR_OID_TERR "); 
                 sqlWhere.append(" AND zonsecc.oid_secc = zonterriadm.ZSCC_OID_SECC "); 	                  	   
		         sqlWhere.append(" and movicc.ZTAD_OID_TERR_ADMI = zonterriadm.OID_TERR_ADMI ");
                 sqlFrom.append(" ,zon_terri_admin zonterriadm "); 
			     sqlFrom.append(" ,zon_terri zonterri ");
			   }
  		     } 
	       }
         }
       }

      sqlWhere.append(" AND peri.OID_PERI = " + dto.getOidPeriodoOrigen() );
      sqlWhere.append(" AND peri.oid_peri = movicc.perd_oid_peri ");
      sqlWhere.append(" AND canal.oid_cana = peri.cana_oid_cana ");
      
      if (dto.getOidCanal() != null) {
         sqlWhere.append(" AND canal.oid_cana = " + dto.getOidCanal() );
      }      
      
      sqlWhere.append(" AND subacc.acce_oid_acce = acces.oid_acce ");
      sqlWhere.append(" AND subacc.OID_SBAC = movicc.SBAC_OID_SBAC ");

      if (dto.getOidTipoCargoAbono() != null) {
         sqlWhere.append(" AND tipocab.oid_tipo_carg_abon = movicc.tcab_oid_tcab_crea ");
         sqlWhere.append(" AND tipocab.OID_TIPO_CARG_ABON = " + dto.getOidTipoCargoAbono());
      }
      sqlWhere.append(" AND movicc.masi_oid_marc_situ = marcasitu.oidmarcasi ");
      sqlWhere.append(" AND movicc.SOCI_OID_SOCI = socie.OID_SOCI ");
      sqlWhere.append(" AND maec.oid_clie = maeclisubt.clie_oid_clie "); 
      sqlWhere.append(" AND movicc.TICL_OID_TIPO_CLIE = maeclisubt.TICL_OID_TIPO_CLIE ");
      sqlWhere.append(" AND movicc.OID_MOVI_CC NOT IN( ");
      sqlWhere.append(" SELECT  cac.MVCC_OID_MOVI_CC "); 
      sqlWhere.append(" FROM COB_ASIGN_COBRA cac, COB_CRONO_COBRA crono "); 
      sqlWhere.append(" WHERE cac.CRCO_OID_CRON_COBR = crono.OID_CRON_COBR ");
      sqlWhere.append(" AND crono.ETDE_OID_ETAP_DEUD = " + dto.getOidEtapa()+" ");
      sqlWhere.append(" ) ");
      sqlWhere.append(" AND " + dto.getEdadInicial() + " > 0");
      sqlWhere.append(" AND (SYSDATE - movicc.FEC_VENC) between ");
      sqlWhere.append( dto.getEdadInicial() + " AND " + dto.getEdadFinal() + " " );
      //El siguiente condigo comentado se comento por incidencia DBLG400000884
      //No hay que realizar la comprobacion de importes maximos y minimos.
    /*  sqlWhere.append(" AND " + dto.getImporteDesde() + " > 0 ");
      sqlWhere.append(" AND movicc.IMP_PEND between ");
      sqlWhere.append( dto.getImporteDesde() + " AND " +   dto.getImporteHasta());*/
      sqlWhere.append(" ORDER BY codigocliente, importependiente ");
      BelcorpService bs = BelcorpService.getInstance();
      query = sqlSelect.toString() + sqlFrom.toString() + sqlWhere.toString();
      
      try {
         r = bs.dbService.executeStaticQuery(query);
      }catch (Exception ex) {
        ex.printStackTrace();
        String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }
      UtilidadesLog.debug("r: " + r);
      dtoSalida.setResultado(r);
      UtilidadesLog.info("DAOInterfaceModulos.consultarClientesDeudaVencidaUA(DTOEtapasDeCobranzas dto): Salida");
      return dtoSalida;
    }

  public Integer obtenerNroVecesProntoPago(Long oidCliente, Long oidPais) throws MareException {
      
      UtilidadesLog.info("DAOInterfaceModulos.obtenerNroVecesProntoPago(Long oidCliente, Long oidPais): Entrada");      
      Integer res = null;
      StringBuffer query = new StringBuffer();
      RecordSet rs = null;
      
      query.append(" SELECT COUNT(DISTINCT m.NUM_IDEN_CUOT) AS CANT "); 
      query.append(" FROM   CCC_CABEC_DTO_RECAR_FINAN CAB, "); 
      query.append(" CCC_DETAL_DTO_RECAR_FINAN DET, "); 
      query.append(" CCC_MOVIM_CUENT_CORRI M, "); 
      query.append(" CCC_SUBPR S, "); 
      query.append(" CCC_PROCE P	 "); 
      query.append(" WHERE  CAB.SUBP_OID_SUBP = S.OID_SUBP "); 
      query.append(" AND S.CCPR_OID_PROC = P.OID_PROC "); 
      query.append(" AND S.COD_SUBP = 1  "); 
      query.append(" AND P.COD_PROC = 'CCC005' "); 
      query.append(" AND CAB.FEC_DOCU>=(ADD_MONTHS(SYSDATE,-6)) "); 
      query.append(" AND CAB.PAIS_OID_PAIS = "+oidPais+" "); 
      query.append(" AND DET.CDRF_OID_CABE_DTO_RECA_FINA = CAB.OID_CABE_DTO_RECA_FINA "); 
      query.append(" AND DET.MVCC_OID_MOVI_CC = M.OID_MOVI_CC "); 
      query.append(" AND CAB.CLIE_OID_CLIE = "+oidCliente+" "); 
      query.append(" GROUP BY CAB.CLIE_OID_CLIE, M.NUM_IDEN_CUOT, M.NUM_ORDE_CUOT "); 


      try {
        rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        if ((!rs.esVacio())&&(rs.getValueAt(0,"CANT")!=null)){
            res = BigToInteger(rs.getValueAt(0,"CANT"));
        }
      } catch (Exception e) {
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.info("DAOInterfaceModulos.obtenerNroVecesProntoPago(Long oidCliente, Long oidPais): Salida");      
      return res;  
  }
    
  private Integer BigToInteger(Object num) {
      if (num != null) {
          return (new Integer(((BigDecimal) num).intValue()));
      } else {
          return null;
      }
  }

  public Integer obtenerNroVecesRecargoFinanciero(Long oidCliente, Long oidPais) throws MareException {
  
      UtilidadesLog.info("DAOInterfaceModulos.obtenerNroVecesRecargoFinanciero(Long oidCliente, Long oidPais): Entrada");      
      
      Integer res = null;
      StringBuffer query = new StringBuffer();
      RecordSet rs = null;

      query.append(" SELECT COUNT(DISTINCT m.NUM_IDEN_CUOT) AS CANT "); 
      query.append(" FROM   CCC_CABEC_DTO_RECAR_FINAN CAB, "); 
      query.append(" CCC_DETAL_DTO_RECAR_FINAN DET, "); 
      query.append(" CCC_MOVIM_CUENT_CORRI M, "); 
      query.append(" CCC_SUBPR S, "); 
      query.append(" CCC_PROCE P "); 	
      query.append(" WHERE  CAB.SUBP_OID_SUBP = S.OID_SUBP "); 
      query.append(" AND S.CCPR_OID_PROC = P.OID_PROC "); 
      query.append(" AND S.COD_SUBP = 2 "); 
      query.append(" AND P.COD_PROC = 'CCC005' "); 
      query.append(" AND CAB.FEC_DOCU>=(ADD_MONTHS(SYSDATE,-6)) "); 
      query.append(" AND CAB.PAIS_OID_PAIS = "+oidPais+" "); 
      query.append(" AND DET.CDRF_OID_CABE_DTO_RECA_FINA = CAB.OID_CABE_DTO_RECA_FINA "); 
      query.append(" AND DET.MVCC_OID_MOVI_CC = M.OID_MOVI_CC "); 
      query.append(" AND CAB.CLIE_OID_CLIE = "+oidCliente+" "); 
      query.append(" GROUP BY CAB.CLIE_OID_CLIE, M.NUM_IDEN_CUOT, M.NUM_ORDE_CUOT "); 
      
      try {
        rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        if ((!rs.esVacio())&&(rs.getValueAt(0,"CANT")!=null)){
            res = BigToInteger(rs.getValueAt(0,"CANT"));
        }
      }
      catch (Exception e) {
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.info("DAOInterfaceModulos.obtenerNroVecesRecargoFinanciero(Long oidCliente, Long oidPais): Salida");      
      return res;    
  }
}
