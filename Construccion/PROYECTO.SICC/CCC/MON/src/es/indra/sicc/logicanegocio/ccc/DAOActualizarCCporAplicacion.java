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

import es.indra.sicc.dtos.ccc.DTOBuscarCuotasAplicar;
import es.indra.sicc.dtos.ccc.DTOBuscarMovCupon3;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.sql.Date;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Vector;


public class DAOActualizarCCporAplicacion {

    public DAOActualizarCCporAplicacion() {
    }

	// Incidencia 9810: se cambia el tipo del parámetro numeroDocumento a Long
    public DTOTotal calcularSaldoNoUnicoPendiente(DTOSaldosPorFechasyVtos dto,
																	Long[] oidsMarcaSituacion, 
																	Long numeroDocumento) 
        throws MareException 
	{
        UtilidadesLog.info("DAOActualizarCCporAplicacion.calcularSaldoNoUnicoPendiente(DTOSaldosPorFechasyVtos dto, Long[] oidsMarcaSituacion, Long numeroDocumento): Entrada ");
        
        //Parámetros E/S 
        //Entrada: DTOSaldosPorFechasyVtos y Long[] oidsMarcaSituacion y numeroDocumento 
        //Salida: DTOTotal 
        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer sQuery = new StringBuffer("");
        String strOids = null;

        if (oidsMarcaSituacion != null) {
            strOids = this.cadenaInt(oidsMarcaSituacion);
        }

        //Los campos del DTOSaldosPorFechasyVtos que vengan a "null" no filtrarán 
        sQuery.append(" SELECT SUM(IMP_PEND) ");
        sQuery.append(" FROM ");
        sQuery.append(" CCC_MOVIM_CUENT_CORRI m, ");
        sQuery.append(" MAE_CLIEN c ");
        sQuery.append(" WHERE m.CLIE_OID_CLIE=c.OID_CLIE ");

        if (dto.getOidPais() != null) {
            sQuery.append(" AND c.PAIS_OID_PAIS= ? ");
            parametros.add(dto.getOidPais());
        }

        if (dto.getOidCliente() != null) {
            sQuery.append(" AND m.CLIE_OID_CLIE = ? ");
            parametros.add(dto.getOidCliente());
        }

        if ((oidsMarcaSituacion != null) && !strOids.equals("")) {
            sQuery.append(" AND m.MASI_OID_MARC_SITU IN (" + strOids + ") ");

            for (int i = 0; i < oidsMarcaSituacion.length; i++) {
                parametros.add(oidsMarcaSituacion[i]);
            }
        }

        sQuery.append(" AND m.IMP_MOVI <> m.IMP_PAGA ");

        // sQuery.append(" AND m.VAL_DOCU_NUME AND VAL_EJER_CUOT = " + numeroDocumento);//Falta incidencia 9810
        if (numeroDocumento != null) {
            String valorNumeroDocumento = "";
            String rellenoIzqdaHasta12 = null;
            valorNumeroDocumento = numeroDocumento.toString();

            char[] ceros;

            if (valorNumeroDocumento.length() < 12) {
					 ceros = new char[12 - valorNumeroDocumento.length()];

                for (int i = 0; i < ceros.length; i++) {
                    ceros[i] = '0';
                }

                rellenoIzqdaHasta12 = new String(ceros);
                valorNumeroDocumento = rellenoIzqdaHasta12.concat(valorNumeroDocumento);
            }

            valorNumeroDocumento = valorNumeroDocumento.substring(2, 12);

				sQuery.append(" AND LPAD(m.VAL_EJER_CUOT,2,'0')||LPAD(m.NUM_IDEN_CUOT,8,'0') = ?"); //Falta incidencia 9810				
            parametros.add(valorNumeroDocumento);
        }

        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(sQuery.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("calcularSaldoNoUnicoPendiente: Exception", e);
            this.logSql("calcularSaldoNoUnicoPendiente. SQL: ",
                sQuery.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //Creamos un DTOTotal dtoTotal; 
        DTOTotal dtoTotal = new DTOTotal();

        //Si no se encuentran registros 
        if (resultado == null) {
            dtoTotal.setTotal(new BigDecimal(0));
        } else {
            dtoTotal.setTotal(new BigDecimal(
                    ((BigDecimal) resultado.getValueAt(0, 0)).doubleValue()));
        }

        UtilidadesLog.info("DAOActualizarCCporAplicacion.calcularSaldoNoUnicoPendiente(DTOSaldosPorFechasyVtos dto, Long[] oidsMarcaSituacion, Long numeroDocumento): Salida ");

        return dtoTotal;
    }

    //se modifica segun cambio fac 03, modulo ccc (SCS-29/01/2008)
    public DTOSalida buscarMovCupon3(DTOBuscarMovCupon3 dto, 
                              long numeroDiasCruceCupon3)
        throws MareException {
        //Entrada: DTOBuscarMovCupon3 dtoBMC3; 
        //Salida: DTOSalida 
        UtilidadesLog.info("DAOActualizarCCporAplicacion.buscarMovCupon3(DTOBuscarMovCupon3 dto): Entrada ");

        //FieldPosition pos=new FieldPosition(0);
        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();        

        StringBuffer sQuery = new StringBuffer("");

        sQuery.append(" SELECT d.OID_DETA_CUPO_TRAM_DEPU ");
        sQuery.append(" FROM CCC_CUPON_TRAMI_DEPUR c, ");
        sQuery.append(" CCC_DETAL_CUPON_TRAMI_DEPUR d, ");
        sQuery.append(" CCC_SITUA_CUPON s ");
        sQuery.append(" WHERE c.OID_CUPO_TRAM_DEPU = d.CTDE_OID_CUPO_TRAM_DEPU ");
        sQuery.append(" AND d.SICU_OID_SITU_CUPO=s.OID_SITU_CUPO ");

        if (dto.getOidPais() != null) {
            sQuery.append(" AND c.PAIS_OID_PAIS = ? ");
            parametros.add(dto.getOidPais());
        }
        //los filtros q' se comentan, se comentan por cambio fac 03, modulo ccc (SCS-29/01/2008)

        /*if (dto.getNumeroCupon() != null) {
            sQuery.append(" AND d.NUM_CUPO = ? ");
            parametros.add(dto.getNumeroCupon());
        }*/

        if (dto.getOidCliente() != null) {
            sQuery.append(" AND d.CLIE_OID_CLIE = ? ");
            parametros.add(dto.getOidCliente());
        }

        /*if (dto.getFechaMovimiento() != null) {
            sQuery.append(" AND d.FEC_MOVI_BANC = TO_DATE(?, 'dd-MM-yyyy') ");

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String fechaMovimiento = sdf.format(dto.getFechaMovimiento());
            parametros.add(fechaMovimiento);
        }*/
        //se agrega condicion, cambio fac 03, modulo ccc (SCS-29/01/2008)
        
        //Fecha-Documento –del cupón en trámite- > (Fecha-sistema - Variable-Número-Días-Cruce-Cupón3). 
        //Nota funcional: Variable-Número-Días-Cruce-Cupón3 se recupera en actividad 5 CU Confirmar Movimientos Bancarios.
        
        sQuery.append(" AND d.FEC_DOCU > TO_DATE(?, 'dd-MM-yyyy') ");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        long nroDiasCruceAmilisecs = (numeroDiasCruceCupon3*24*60*60*1000);
        String fechaComp = sdf.format(new Date( (System.currentTimeMillis() - nroDiasCruceAmilisecs) ));
        
        UtilidadesLog.debug("numero de dias de cruce (pas a milisec's): " + nroDiasCruceAmilisecs);
        UtilidadesLog.debug("fecha del sistema - numero de dias de cruce: " + fechaComp);        
        parametros.add(fechaComp);

        /*
        if (dto.getOidBanco() != null) {
            sQuery.append(" AND d.CBAN_OID_BANC = ? ");
            parametros.add(dto.getOidBanco());
        }*/

        /*
        if (dto.getSituacion() != null) {
            sQuery.append(" AND s.COD_SITU_CUPO = ? ");
            parametros.add(dto.getSituacion());
        }*/
        
        
        if (dto.getImporte() != null) {
            sQuery.append(" AND d.IMP_DETA = ? ");
            parametros.add(dto.getImporte());
        }

        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(sQuery.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("buscarMovCupon3: Exception", e);
            this.logSql("buscarMovCupon3. SQL: ", sQuery.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //Construimos un DTOSalida y lo devolvemos 		
        DTOSalida dtos = new DTOSalida(resultado);
        UtilidadesLog.info("DAOActualizarCCporAplicacion.buscarMovCupon3(DTOBuscarMovCupon3 dto): Salida ");

        return dtos;
    }
    
    public DTOSalida buscarCCporNumeroIdentAplicar(DTOBuscarCuotasAplicar dto)
        throws MareException {
        //Entrada: DTOBuscarCuotasAplicar dto 
        //Salida: DTOSalida             
        UtilidadesLog.info("DAOActualizarCCporAplicacion.buscarCCporNumeroIdentAplicar(DTOBuscarCuotasAplicar dto): Entrada ");

        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer sQuery = new StringBuffer("");
        String strOids = null;
		
		Long[] oidsMarcaSituacion = new  Long[2];
		
		for(int i=0;i<2; i++){
			oidsMarcaSituacion[i] = dto.getMarcasSituacion()[i];
		}

        if (oidsMarcaSituacion != null) {
            strOids = this.cadenaInt(oidsMarcaSituacion);
        }

        sQuery.append(
            " SELECT * FROM CCC_MOVIM_CUENT_CORRI m, VCA_SEG_SOCIE s ");
        sQuery.append(" WHERE m.SOCI_OID_SOCI = s.OID_SOCI ");

        //criterios 
        if (dto.getOidPais() != null) {
            sQuery.append(" AND s.PAIS_OID_PAIS = ? ");
            parametros.add(dto.getOidPais());
        }

        if (dto.getOidCliente() != null) {
            sQuery.append(" AND m.CLIE_OID_CLIE = ? ");
            parametros.add(dto.getOidCliente());
        }

        if (dto.getOidEmpresa() != null) {
            sQuery.append(" AND m.SOCI_OID_SOCI = ? ");
            parametros.add(dto.getOidEmpresa());
        }

        if ((oidsMarcaSituacion != null) && !strOids.equals("")) {
            sQuery.append(" AND m.MARC_OID_MARC IN (" + strOids + ") ");

            for (int i = 0; i < oidsMarcaSituacion.length; i++) {
                parametros.add(oidsMarcaSituacion[i]);
            }
        }

        if (dto.getNumeroIdentCuota() != null) {
            sQuery.append(" AND m.NUM_IDEN_CUOT = ? ");
            parametros.add(dto.getNumeroIdentCuota());
        }

        //Agregamos el siguiente filtro en función del valor de dto.importePago 
        if (dto.getImportePago() != null) {
            if (dto.getImportePago().doubleValue() > 0) {
                sQuery.append(" AND m.IMP_PEND > 0 ");
            } else {
                sQuery.append(" AND m.IMP_PEND < 0 ");
            }
        }

        sQuery.append(" ORDER BY NUM_ORDE_CUOT ");

        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(sQuery.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("buscarCCporNumeroIdentAplicar: Exception", e);
            this.logSql("buscarCCporNumeroIdentAplicar. SQL: ",
                sQuery.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //Construimos un DTOSalida y lo devolvemos 		
        DTOSalida dtos = new DTOSalida(resultado);
        UtilidadesLog.info("DAOActualizarCCporAplicacion.buscarCCporNumeroIdentAplicar(DTOBuscarCuotasAplicar dto): Salida ");

        return dtos;
    }

    public DTOSalida buscarCCporFechaAplicar(DTOBuscarCuotasAplicar dto)
        throws MareException {
        //Entrada: DTOBuscarCuotasAplicar dto 
        //Salida: DTOSalida 
        UtilidadesLog.info("DAOActualizarCCporAplicacion.buscarCCporFechaAplicar(DTOBuscarCuotasAplicar dto): Entrada ");

        Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        
        StringBuffer sQuery = new StringBuffer("");
        String strOids = null;
        Long[] oidsMarcaSituacion = dto.getMarcasSituacion();

        if (oidsMarcaSituacion != null) {
            strOids = this.cadenaInt(oidsMarcaSituacion);
        }

        sQuery.append(" SELECT DISTINCT m.* FROM CCC_MOVIM_CUENT_CORRI m, MAE_CLIEN c, ");
        sQuery.append(" SEG_SOCIE s WHERE m.SOCI_OID_SOCI = s.OID_SOCI ");  //  Incidencia Sicc20080575
        sQuery.append(" AND m.CLIE_OID_CLIE = c.OID_CLIE ");

        if (dto.getOidPais() != null) {
            sQuery.append(" AND s.PAIS_OID_PAIS = ? ");
            parametros.add(dto.getOidPais());
        }

        if (dto.getOidCliente() != null) {
            sQuery.append(" AND m.CLIE_OID_CLIE = ? ");
            parametros.add(dto.getOidCliente());
        }

        if (dto.getOidEmpresa() != null) {
            sQuery.append(" AND m.SOCI_OID_SOCI = ? ");
            parametros.add(dto.getOidEmpresa());
        }

        if ((oidsMarcaSituacion != null) && !strOids.equals("")) {
            sQuery.append(" AND m.MASI_OID_MARC_SITU IN (" + strOids + ") ");

            for (int i = 0; i < oidsMarcaSituacion.length; i++) {
                parametros.add(oidsMarcaSituacion[i]);
            }
        }

        //Agregamos el siguiente filtro en función del valor de dto.importePago 
        if (dto.getImportePago() != null) {
            if (dto.getImportePago().doubleValue() > 0) {
                sQuery.append(" AND m.IMP_PEND > 0 ");
            } else {
                sQuery.append(" AND m.IMP_PEND < 0 ");
            }
        }

        //Agregamos la opción de ordenación en función del indicador siguiente: 
        if (dto.getIndEmisionVto() == "1") //por fecha de facturación 
         {
            sQuery.append(" ORDER BY FEC_VALO ");
        } else //por fecha Vto 
         {
            sQuery.append(" ORDER BY FEC_VENC ");
        }

        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(sQuery.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("buscarCCporFechaAplicar: Exception", e);
            this.logSql("buscarCCporFechaAplicar. SQL: ", sQuery.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //Construimos un DTOSalida y lo devolvemos 		
        DTOSalida dtos = new DTOSalida(resultado);
       
        UtilidadesLog.info("DAOActualizarCCporAplicacion.buscarCCporFechaAplicar(DTOBuscarCuotasAplicar dto): Salida");        
        return dtos;
    }

    public void actDetalleCuponesTramiteDepuracion(Long oidSituCupo, Long oidSitu)
        throws MareException {
        
        StringBuffer update = new StringBuffer();
        Vector parametros = new Vector();
        
        update.append("UPDATE CCC_DETAL_CUPON_TRAMI_DEPUR SET ");
        update.append(" SICU_OID_SITU_CUPO = ? ");
        update.append(" WHERE OID_DETA_CUPO_TRAM_DEPU = ? ");        
        
        parametros.add(oidSitu);
        parametros.add(oidSituCupo);
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
		try{                                                              
			bs.dbService.executePreparedUpdate(update.toString(),parametros);        
		} catch (Exception e) {                                                
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                
			UtilidadesLog.error("actDetalleCuponesTramiteDepuracion: Exception",e);           
			this.logSql("actDetalleCuponesTramiteDepuracion. SQL: ",update.toString(), parametros);   
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
		}           
    }

    public void actMovBarios(Long oidMovBario, String codErro)
        throws MareException {
        
        StringBuffer update = new StringBuffer();
        Vector parametros = new Vector();
        
        update.append("UPDATE CCC_MOVIM_BANCA SET ");
        update.append(" COD_ERRO = ? ");
        update.append(" WHERE OID_MOVI_BANC = ? ");        
        
        parametros.add(codErro);
        parametros.add(oidMovBario);
        BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
		try{                                                              
			bs.dbService.executePreparedUpdate(update.toString(),parametros);        
		} catch (Exception e) {                                                
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;                
			UtilidadesLog.error("actMovBarios: Exception",e);           
			this.logSql("actMovBarios. SQL: ",update.toString(), parametros);   
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
		}           
    }

    private void logError(String mensaje, Throwable e) {
        UtilidadesLog.info("DAOActualizarCCporAplicacion.logError(String mensaje, Throwable e) :  Entrada ");
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " + e.getMessage());
        this.logStackTrace(e);
        UtilidadesLog.info("DAOActualizarCCporAplicacion.logError(String mensaje, Throwable e) :  Salida ");
    }

    private void logSql(String metodo, String sql, Vector params) {
    
        UtilidadesLog.info("DAOActualizarCCporAplicacion.logSql(String metodo, String sql, Vector params): Entrada ");
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }
            UtilidadesLog.debug(metodo + sParams);
        }
        UtilidadesLog.info("DAOActualizarCCporAplicacion.logSql(String metodo, String sql, Vector params):  Salida ");
    }

    private void logStackTrace(Throwable e) {
        UtilidadesLog.info("DAOActualizarCCporAplicacion.logStackTrace(Throwable e): Entrada ");
        try {
            UtilidadesLog.error(e);
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
        UtilidadesLog.info("DAOActualizarCCporAplicacion.logStackTrace(Throwable e): Salida ");
    }

    private String cadenaInt(Long[] cadena) {
        
        UtilidadesLog.info("DAOActualizarCCporAplicacion.cadenaInt(Long[] cadena): Entrada ");
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
        UtilidadesLog.info("DAOActualizarCCporAplicacion.cadenaInt(Long[] cadena): Salida ");
        return retorno;
    }
}
