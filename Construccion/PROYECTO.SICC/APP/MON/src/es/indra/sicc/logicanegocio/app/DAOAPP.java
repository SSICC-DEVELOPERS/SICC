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
package es.indra.sicc.logicanegocio.app;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.app.DTOClienteChequeo;
import es.indra.sicc.dtos.app.DTOSolicCabecSecu;
import es.indra.sicc.dtos.app.DTOTerritorio;
import es.indra.sicc.dtos.app.DTOTerritorioRuta;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.Vector;


public class DAOAPP {
    private String usuario;

	public DAOAPP(){
	}
	
    public DAOAPP(String usuario) {
        this.usuario = usuario;
    }

    public RecordSet obtenerRutas(DTOBelcorp DTOE) throws MareException {
        UtilidadesLog.info("DAOAPP.obtenerRutas(DTOBelcorp DTOE): Entrada ");

        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT a.OID_RUTA_TRAN , ");

        // Subselect para obtener la descripcion internacionalizable 
        consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        consulta.append(" WHERE idio.ATTR_ENTI = 'APP_RUTAS_TRANS' ");
        consulta.append(" AND idio.IDIO_OID_IDIO = ? "); //DTOE.idioma
        consulta.append(
            " AND idio.VAL_OID = a.OID_RUTA_TRAN ) AS DES_RUTA_TRANS ");
        parametros.add(DTOE.getOidIdioma());

        consulta.append(" FROM APP_RUTAS_TRANS a ");
        consulta.append(" WHERE PAIS_OID_PAIS = ?  "); //DTOE.pais
        parametros.add(DTOE.getOidPais());

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerRutas: Exception", e);
            this.logSql("obtenerRutas. SQL: ", consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (resultado == null) {
            resultado = new RecordSet();
        }

       UtilidadesLog.info("DAOAPP.obtenerRutas(DTOBelcorp DTOE): Salida ");

        return resultado;
    }

    /*public RecordSet obtenerTerritoriosAsociados(DTOOID DTOE)
        throws MareException {
        UtilidadesLog.info("DAOAPP.obtenerTerritoriosAsociados(DTOOID DTOE): Entrada ");

        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT A.OID_RUTA_TERR, A.NUM_SECU, B.COD_TERR ");
        consulta.append(" FROM APP_RUTAS_TERRI A, VCA_ZON_TERRI B ");
        consulta.append(" WHERE A.RUTR_OID_RUTA_TRAN = ?"); //DTOE.oid 
        consulta.append(" AND A.TERR_OID_TERR = B.OID_TERR ");

        parametros.add(DTOE.getOid());
        consulta.append("AND B.COD_USUA = ?  ");
        parametros.add(this.usuario);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerTerritoriosAsociados: Exception", e);
            this.logSql("obtenerTerritoriosAsociados. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (resultado == null) {
            resultado = new RecordSet();
        }

        UtilidadesLog.info("DAOAPP.obtenerTerritoriosAsociados(DTOOID DTOE): Salida ");

        return resultado;
    }*/
    
    public RecordSet obtenerTerritoriosAsociados(DTOOID DTOE)
        throws MareException {
        UtilidadesLog.info("DAOAPP.obtenerTerritoriosAsociados(DTOOID DTOE): Entrada ");

        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT a.oid_ruta_terr, a.num_secu, z.COD_TERR ");
        consulta.append(" FROM app_rutas_terri a, zon_terri z ");
        consulta.append(" WHERE A.RUTR_OID_RUTA_TRAN = ?"); //DTOE.oid 
        consulta.append(" and a.TERR_OID_TERR = z.OID_TERR ");

        parametros.add(DTOE.getOid());

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerTerritoriosAsociados: Exception", e);
            this.logSql("obtenerTerritoriosAsociados. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (resultado == null) {
            resultado = new RecordSet();
        }

        UtilidadesLog.info("DAOAPP.obtenerTerritoriosAsociados(DTOOID DTOE): Salida ");

        return resultado;
    }

    public RecordSet buscarTerritoriosNoAsociados(DTOTerritorio DTOE)
        throws MareException {
        UtilidadesLog.info("DAOAPP.Método buscarTerritoriosNoAsociados(DTOTerritorio DTOE): Entrada");

        //Realiza una consulta utilizando el servicio DBService. 
        //Obtenemos los territorios comprendidos entre territorioDesde y territorioHasta, 
        //que no estén en APP_RUTAS_TERRITORIOS (No se tendran en cuenta los criterios
        //con valor null)
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT A.OID_TERR, A.COD_TERR ");
        consulta.append(" FROM ZON_TERRI A ");
        consulta.append(" WHERE ");
        consulta.append(" NOT EXISTS (SELECT NULL FROM APP_RUTAS_TERRI B ");
        consulta.append(" WHERE A.OID_TERR = B.TERR_OID_TERR) ");

        if (DTOE.getOidPais() != null) {
            consulta.append("AND A.PAIS_OID_PAIS = ?  ");
            parametros.add(DTOE.getOidPais());
        }

        if (DTOE.getTerritorioDesde() != null) {
            consulta.append(" AND A.COD_TERR >= TO_NUMBER( ? ) "); //INCIDENCIA 8410
            parametros.add(DTOE.getTerritorioDesde());
        }

        if (DTOE.getTerritorioHasta() != null) {
            consulta.append(" AND A.COD_TERR <= TO_NUMBER( ? ) ");
            parametros.add(DTOE.getTerritorioHasta());
        }

        /*consulta.append("AND A.COD_USUA = ?  ");
        parametros.add(this.usuario);*/

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("buscarTerritoriosNoAsociados: Exception", e);
            this.logSql("buscarTerritoriosNoAsociados. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
		
		if (rs.esVacio()) {
			UtilidadesLog.info("buscar: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOAPP.Método buscarTerritoriosNoAsociados(DTOTerritorio DTOE): Salida");
        //Devuelve el RecordSet obtenido
        return rs;
    }

    public RecordSet consultarTerritoriosAsociados(DTOTerritorio DTOE)
        throws MareException {
        UtilidadesLog.info("DAOAPP.consultarTerritoriosAsociados(DTOTerritorio DTOE): Entrada");

        //Realiza una consulta utilizando el servicio DBService. 
        //Obtenemos todos los territorios para la ruta pasada como argumento y 
        //que estén comprendidos entre territorioDesde y territorioHasta, también 
        //argumentos de entrada que estén en APP_RUTAS_TERRITORIOS (No se tendrán 
        //en cuenta los criterios con valor Null) 
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT A.OID_RUTA_TERR, B.COD_TERR , A.NUM_SECU  ");
        consulta.append(" FROM APP_RUTAS_TERRI A, ZON_TERRI B ");
        consulta.append(" WHERE ");
        consulta.append(" A.TERR_OID_TERR = B.OID_TERR  ");

        if (DTOE.getOidRuta() != null) {
            consulta.append(" AND A.RUTR_OID_RUTA_TRAN = ? "); //Incidencia 9085
            parametros.add(DTOE.getOidRuta());
        }

        if (DTOE.getOidPais() != null) {
            consulta.append(" AND B.PAIS_OID_PAIS = ? ");
            parametros.add(DTOE.getOidPais());
        }

        if (DTOE.getTerritorioDesde() != null) {
            consulta.append("AND B.COD_TERR >= TO_NUMBER( ? ) "); //INCIDENCIA 8410
            parametros.add(DTOE.getTerritorioDesde());
        }

        if (DTOE.getTerritorioHasta() != null) {
            consulta.append("AND B.COD_TERR <= TO_NUMBER( ? ) ");
            parametros.add(DTOE.getTerritorioHasta());
        }

        /*consulta.append("AND B.COD_USUA = ?  ");
        parametros.add(this.usuario);*/

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("consultarTerritoriosAsociados: Exception", e);
            this.logSql("consultarTerritoriosAsociados. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
		if (rs.esVacio()) {
			UtilidadesLog.info("buscar: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOAPP.consultarTerritoriosAsociados(DTOTerritorio DTOE): Salida");

        //Devuelve el RecordSet obtenido
        return rs;
    }

    public Long obtenerMaximaSecuFactuDiariaZonaFecha(Long zona, Date fechaFact)
        throws MareException {
        UtilidadesLog.info("DAOAPP.obtenerMaximaSecuFactuDiariaZonaFecha(Long zona, Date fechaFact): Entrada");

        // Realiza una consulta utilizando el servicio DBService. 
        // Se obtiene el máximo número de secuencia de facturación diaria para una 
        // zona comercial y una fecha de consolidado 
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT NVL(MAX(A.NUM_SECU_FACT_DIAR),0) ");
        consulta.append(" FROM PED_SOLIC_CABEC_SECUE A, PED_SOLIC_CABEC B ");
        consulta.append(" WHERE A.SOCA_OID_SOLI_CABE=B.OID_SOLI_CABE ");

        if (zona != null) {
            consulta.append(" AND B.ZZON_OID_ZONA = ? ");
            parametros.add(zona);
        }
        // Modificado por incidencia 13670
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
        if (fechaFact != null) {
            String sFechaFact = sdf.format(fechaFact);                                               
			consulta.append(" AND (B.FEC_FACT= TO_DATE( ? ,'YYYY-MM-DD') ) ");
            parametros.add(sFechaFact);    
        }

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerMaximaSecuFactuDiariaZonaFecha: Exception",
                e);
            this.logSql("obtenerMaximaSecuFactuDiariaZonaFecha. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Long valor = null;

		// Modificado por hsanchez
        valor = new Long((((BigDecimal) resultado.getValueAt(0, 0))).longValue());
		/*
        if (resultado != null) {
            valor = new Long((((BigDecimal) resultado.getValueAt(0, 0))).longValue());
        }*/

        UtilidadesLog.info("DAOAPP.obtenerMaximaSecuFactuDiariaZonaFecha(Long zona, Date fechaFact): Salida");

        return valor;
    }

    public Long obtenerMaximaSecuFactuDiariaPaisRutaFecha(Long pais, Long ruta,
        Date fechaFact) throws MareException {
        UtilidadesLog.info("DAOAPP.obtenerMaximaSecuFactuDiariaPaisRutaFecha(Long pais, Long ruta, Date fechaFact): Entrada ");

        // Realiza una consulta utilizando el servicio DBService. 
        // Se obtiene el máximo número de secuencia de facturación diaria para un país, 
        // ruta y fecha de consolidado 
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT NVL(MAX(A.NUM_SECU_FACT_DIAR),0) ");
        consulta.append(" FROM PED_SOLIC_CABEC_SECUE A, PED_SOLIC_CABEC B ");
        consulta.append(" WHERE A.SOCA_OID_SOLI_CABE= B.OID_SOLI_CABE ");

        if (ruta != null) {
            consulta.append(" AND A.NUM_SECU_ZONA_RUTA = ? "); //ruta --nombre campo tabla????
            parametros.add(ruta);
        }

        if (pais != null) {
            consulta.append(" AND B.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }

        // Es la fecha de facturación, la comparación se hace con la máscara 'DD/MM/YYYY', 
        // es decir, sólo hay que llegar hasta el nivel del día 
        // Modificado por incidencia 13670, uso de TO_DATE
       	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
        if (fechaFact != null) {
            String sFechaFact = sdf.format(fechaFact);                                               
			consulta.append(" AND (B.FEC_FACT= TO_DATE( ? ,'YYYY-MM-DD') ) ");
            parametros.add(sFechaFact);    
        }
        UtilidadesLog.info("*** dentro de obtenerMaximaSecuFactuDiariaPaisRutaFecha, la cosulta a ej., es: " + consulta.toString());

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerMaximaSecuFactuDiariaPaisRutaFecha: Exception",
                e);
            this.logSql("obtenerMaximaSecuFactuDiariaPaisRutaFecha. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("*** y me retorna:" + resultado);

        Long valor = null;

		// Modificado por hsanchez
        valor = new Long((((BigDecimal) resultado.getValueAt(0, 0))).longValue());
        /*if (resultado != null) {
            valor = new Long((((BigDecimal) resultado.getValueAt(0, 0))).longValue());
        }*/

        UtilidadesLog.info("DAOAPP.obtenerMaximaSecuFactuDiariaPaisRutaFecha(Long pais, Long ruta, Date fechaFact): Salida ");

        return valor;
    }

		// Incidencia 9672
	public DTOSolicCabecSecu obtenerRutaYSecuencias(DTOTerritorioRuta DTOE)
        throws MareException {
        UtilidadesLog.info("DAOAPP.obtenerRutaYSecuencias(DTOTerritorioRuta DTOE): Entrada ");

        // Realiza una consulta utilizando el servicio DBService. 
        // Se obtiene el oidRuta y la secuencia ruta-territorio y la secuencia de la 
        // ruta de las tablas app_rutas_terri y app_rutas_trans 
        // filtrando por país y territorio 
        DTOSolicCabecSecu dtoResultado = new DTOSolicCabecSecu();
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append(
            " SELECT A.RUTR_OID_RUTA_TRAN, B.NUM_SECU || A.NUM_SECU, ");
        consulta.append(" B.NUM_SECU ");
        consulta.append(" FROM APP_RUTAS_TERRI A, APP_RUTAS_TRANS B ");
        consulta.append(" WHERE A.RUTR_OID_RUTA_TRAN = B.OID_RUTA_TRAN ");

        consulta.append(" AND B.PAIS_OID_PAIS = ? ");
        parametros.add(DTOE.getOidPais());

        consulta.append(" AND A.TERR_OID_TERR = ? ");
        parametros.add(DTOE.getOidTerritorio());
        
        UtilidadesLog.info("*** estoy obteniendo Ruta y Secuencias, la consulta es: " + consulta.toString());

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("obtenerRutaYSecuencias: Exception", e);
            this.logSql("obtenerRutaYSecuencias. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("*** y me retorna: " + rs);

        /* Crear un dtoResultado del tipo DTOSolicCabecSecu con los siguientes campos:
        * dtoResultado.oidRuta = A.RUTR_OID_RUTA_TRAN
        * dtoResultado.secuenciaRutaTerritorio = B.NUM_SECU || A.NUM_SECU
        * dtoResultado.numSecuenciaZonasRutas = B.NUM_SECU
        */
		// Incidencia 9672 implantada
		if(!rs.esVacio()){
	        dtoResultado.setOidRuta(new Long(
		            ((BigDecimal) rs.getValueAt(0, 0)).longValue()));
			dtoResultado.setSecuenciaRutaTerritorio(new String(
				    (rs.getValueAt(0, 1)).toString()));
	        dtoResultado.setNumSecuenciaZonasRutas(new Long(
		            ((BigDecimal) rs.getValueAt(0, 2)).longValue()));
                    
            UtilidadesLog.info("*** como oid de ruta tengo: " + rs.getValueAt(0, 0));
            UtilidadesLog.info("*** como secuencia ruta y territorio tengo: " + rs.getValueAt(0, 1));
            UtilidadesLog.info("*** como secuencia zonas rutas tengo: " + rs.getValueAt(0, 2));
		}
		/*if (rs != null) {
            dtoResultado.setOidRuta(new Long(
                    ((BigDecimal) rs.getValueAt(0, 0)).longValue()));
            dtoResultado.setSecuenciaRutaTerritorio(new String(
                    (rs.getValueAt(0, 1)).toString()));
            dtoResultado.setNumSecuenciaZonasRutas(new Long(
                    ((BigDecimal) rs.getValueAt(0, 2)).longValue()));
        }*/

        UtilidadesLog.info("DAOAPP.obtenerRutaYSecuencias(DTOTerritorioRuta DTOE): Salida ");

        //Resultado devuelto
        return dtoResultado;
    }

    // Incidencia 8727	
    public Long obtenerRevisionClientesAChequear(DTOClienteChequeo DTOE)
        throws MareException {
        UtilidadesLog.info("DAOAPP.obtenerRevisionClientesAChequear(DTOClienteChequeo DTOE): Entrada ");
    
        // vbongiov -- Cambio 20080756 -- 29/04/2009
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        RecordSet rs1 = new RecordSet();
        StringBuffer query1 = new StringBuffer();
        RecordSet rs2 = new RecordSet();
        StringBuffer query2 = new StringBuffer();
        BelcorpService bs;
        Long valor = null;
         
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        // Busca a que tipo de chequeo corresponden con el cliente y periodo
        query.append(" SELECT COUNT(DISTINCT tipoCheq.OID_TIPO_INDI_REVI) CANT ");   
        query.append(" FROM REC_CLIEN_A_CHEQU cliCheq, PED_INDIC_REVIS cheq, PED_TIPO_INDIC_REVIS tipoCheq ");
        query.append(" WHERE cliCheq.INRE_OID_INDI_REVI =  cheq.OID_INDI_REVI ");
        query.append(" AND cheq.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI ");
        query.append(" AND cliCheq.PERD_OID_PERI = " + DTOE.getOidPeriodo());
        query.append(" AND cliCheq.CLIE_OID_CLIE = " + DTOE.getOidClienteReceptorFactura());        
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
         
        UtilidadesLog.debug("rs: " + rs); 
       
        // Busca los chequeo que corresponden con el cliente y periodo
        query1.append(" SELECT 1 COD_CHEQUEO, cheq.OID_INDI_REVI, cheq.COD_INDI_REVI ");   
        query1.append(" FROM REC_CLIEN_A_CHEQU cliCheq, PED_INDIC_REVIS cheq ");   
        query1.append(" WHERE cliCheq.INRE_OID_INDI_REVI =  cheq.OID_INDI_REVI ");   
        query1.append(" AND cheq.COD_INDI_REVI IN ('" + ConstantesREC.COD_TIPO_REVISION_A + "', '" + 
                                                        ConstantesREC.COD_TIPO_REVISION_B + "', '" +   
                                                        ConstantesREC.COD_TIPO_REVISION_C + "')"); 
        query1.append(" AND cliCheq.PERD_OID_PERI = " + DTOE.getOidPeriodo());
        query1.append(" AND cliCheq.CLIE_OID_CLIE = " + DTOE.getOidClienteReceptorFactura());        
        query1.append(" UNION ");   
        query1.append(" SELECT 2 COD_CHEQUEO, cheq.OID_INDI_REVI, cheq.COD_INDI_REVI ");   
        query1.append(" FROM REC_CLIEN_A_CHEQU cliCheq, PED_INDIC_REVIS cheq ");   
        query1.append(" WHERE cliCheq.INRE_OID_INDI_REVI =  cheq.OID_INDI_REVI ");   
        query1.append(" AND cheq.COD_INDI_REVI IN ('" + ConstantesREC.COD_TIPO_REVISION_D + "', '" + 
                                                        ConstantesREC.COD_TIPO_REVISION_E + "', '" +   
                                                        ConstantesREC.COD_TIPO_REVISION_F + "')"); 
        query1.append(" AND cliCheq.PERD_OID_PERI = " + DTOE.getOidPeriodo());
        query1.append(" AND cliCheq.CLIE_OID_CLIE = " + DTOE.getOidClienteReceptorFactura());   
        query1.append(" UNION ");  
        query1.append(" SELECT 3 COD_CHEQUEO, cheq.OID_INDI_REVI, cheq.COD_INDI_REVI ");   
        query1.append(" FROM REC_CLIEN_A_CHEQU cliCheq, PED_INDIC_REVIS cheq ");   
        query1.append(" WHERE cliCheq.INRE_OID_INDI_REVI =  cheq.OID_INDI_REVI  ");   
        query1.append(" AND cheq.COD_INDI_REVI NOT IN ('" + ConstantesREC.COD_TIPO_REVISION_A + "', '" + 
                                                            ConstantesREC.COD_TIPO_REVISION_B + "', '" +   
                                                            ConstantesREC.COD_TIPO_REVISION_C + "', '" +   
                                                            ConstantesREC.COD_TIPO_REVISION_D + "', '" + 
                                                            ConstantesREC.COD_TIPO_REVISION_E + "', '" +   
                                                            ConstantesREC.COD_TIPO_REVISION_F + "', '" + 
                                                            ConstantesREC.COD_TIPO_REVISION_G + "', '" + 
                                                            ConstantesREC.COD_TIPO_REVISION_H + "', '" +   
                                                            ConstantesREC.COD_TIPO_REVISION_I + "')"); 
        query1.append(" AND cliCheq.PERD_OID_PERI = " + DTOE.getOidPeriodo());
        query1.append(" AND cliCheq.CLIE_OID_CLIE = " + DTOE.getOidClienteReceptorFactura());  
        query1.append(" UNION ");   
        query1.append(" SELECT 4 COD_CHEQUEO, cheq.OID_INDI_REVI, cheq.COD_INDI_REVI ");   
        query1.append(" FROM REC_CLIEN_A_CHEQU cliCheq, PED_INDIC_REVIS cheq ");   
        query1.append(" WHERE cliCheq.INRE_OID_INDI_REVI =  cheq.OID_INDI_REVI ");   
        query1.append(" AND cheq.COD_INDI_REVI IN ('" + ConstantesREC.COD_TIPO_REVISION_G + "', '" + 
                                                        ConstantesREC.COD_TIPO_REVISION_H + "', '" +   
                                                        ConstantesREC.COD_TIPO_REVISION_I + "')"); 
        query1.append(" AND cliCheq.PERD_OID_PERI = " + DTOE.getOidPeriodo());
        query1.append(" AND cliCheq.CLIE_OID_CLIE = " + DTOE.getOidClienteReceptorFactura());  
        query1.append(" ORDER BY COD_CHEQUEO, COD_INDI_REVI ");  
         
        try {
             rs1 = bs.dbService.executeStaticQuery(query1.toString());
        } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
            
        UtilidadesLog.debug("rs1: " + rs1);   
        
        if(!rs1.esVacio()){
            
            if(((BigDecimal)rs.getValueAt(0, "CANT")).intValue()==1){            
                // Las marcas recuperadas corresponden a un mismo tipo de chequeo   
                valor = Long.valueOf(((BigDecimal)rs1.getValueAt(0, "OID_INDI_REVI")).toString());            
                
            } else {        
                // Las marcas recuperadas corresponden a diferentes tipos de chequeo 
                if(((BigDecimal)rs1.getValueAt(0, "COD_CHEQUEO")).intValue()== 1){
                  // Manual
                   valor = ConstantesREC.OID_TIPO_REVISION_C;
                   
                } else if(((BigDecimal)rs1.getValueAt(0, "COD_CHEQUEO")).intValue()== 2){
                    // Reincidente
                     valor = ConstantesREC.OID_TIPO_REVISION_F;
                 
                } else if(((BigDecimal)rs1.getValueAt(0, "COD_CHEQUEO")).intValue()== 3){
                
                    // Tipologia de Cliente                
                    query2.append(" SELECT cheq.OID_INDI_REVI, cheq.COD_INDI_REVI ");   
                    query2.append(" FROM REC_CONFI_TIPO_CLIEN confCli, V_MAE_TIPIF_CLIEN tipolog, CRA_PERIO per, "); 
                    query2.append(" PED_INDIC_REVIS cheq, PED_TIPO_INDIC_REVIS tipoCheq, MAE_CLIEN_DATOS_ADICI cli "); 
                    query2.append(" WHERE confCli.INRE_OID_INDI_REVI =  cheq.OID_INDI_REVI "); 
                    query2.append(" AND cheq.TIRV_OID_TIPO_INDI_REVI = tipoCheq.OID_TIPO_INDI_REVI "); 
                    query2.append(" AND tipoCheq.COD_TIPO_INDI_REVI = '" + ConstantesREC.COD_TIPO_REVISION_A + "' "); 
                    query2.append(" AND per.OID_PERI = " + DTOE.getOidPeriodo());
                    query2.append(" AND confCli.PAIS_OID_PAIS = per.PAIS_OID_PAIS "); 
                    query2.append(" AND confCli.TICL_OID_TIPO_CLIE = tipolog.TICL_OID_TIPO_CLIE "); 
                    query2.append(" AND confCli.SBTI_OID_SUBT_CLIE = tipolog.SBTI_OID_SUBT_CLIE "); 
                    query2.append(" AND confCli.TCCL_OID_TIPO_CLAS = tipolog.TCCL_OID_TIPO_CLASI ");   
                    query2.append(" AND confCli.CLAS_OID_CLAS = tipolog.CLAS_OID_CLAS "); 
                    query2.append(" AND tipolog.CLIE_OID_CLIE = " + DTOE.getOidClienteReceptorFactura());  
                    query2.append(" AND tipolog.CLIE_OID_CLIE = cli.CLIE_OID_CLIE "); 
                    query2.append(" AND cli.IND_ACTI = 1 "); 
                     
                    try {
                         rs2 = bs.dbService.executeStaticQuery(query2.toString());
                    } catch (Exception ex) {
                         UtilidadesLog.error("ERROR ", ex);
                         throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
                    
                    UtilidadesLog.debug("rs2: " + rs2);
                    
                    valor = Long.valueOf(((BigDecimal)rs2.getValueAt(0, "OID_INDI_REVI")).toString()); 
                
                } else if(((BigDecimal)rs1.getValueAt(0, "COD_CHEQUEO")).intValue()== 4){
                    // Undidad Administrativa
                     valor = ConstantesREC.OID_TIPO_REVISION_I;
                }
            }
        }
        
        UtilidadesLog.debug("valor: " + valor);            

        UtilidadesLog.info("DAOAPP.obtenerRevisionClientesAChequear(DTOClienteChequeo DTOE): Salida ");

        //Resultado devuelto
        return valor;
    }

    public Boolean esClienteNuevo(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOAPP.esClienteNuevo(Long oidCliente): Entrada ");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        //Realiza una consulta utilizando el servicio DBService. 
        consulta.append(" SELECT count(*) contador");
        consulta.append(" FROM MAE_CLIEN_DATOS_ADICI A, MAE_ESTAT_CLIEN B ");
        consulta.append(" WHERE A.CLIE_OID_CLIE = ? ");
        parametros.add(oidCliente);
        consulta.append(" AND A.ESTA_OID_ESTA_CLIE = B.OID_ESTA_CLIE ");
        // vbongiov -- Cambio 20080756 -- 29/04/2009
        consulta.append(" AND B.COD_ESTA_CLIE IN ('" + ConstantesMAE.ESTATUS_NUEVO + "', '" + ConstantesMAE.ESTATUS_REACTIVADO + "')");
       
        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("esClienteNuevo: Exception", e);
            this.logSql("esClienteNuevo. SQL: ", consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        int contador = (((BigDecimal) rs.getValueAt(0, 0)).intValue());
        Boolean valor = null;

        if (contador == 0) {
            valor = new Boolean("false");
        } else {
            valor = new Boolean("true");
        }

        UtilidadesLog.info("DAOAPP.esClienteNuevo(Long oidCliente): Salida  ");
        
        //Resultado devuelto
        return valor;
    }
    
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    public Long obtenerRevisionClientesAChequearNuevos() throws MareException {
        UtilidadesLog.info("DAOAPP.obtenerRevisionClientesAChequearNuevos(): Entrada ");
        
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        Long valor = null;
         
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        // Busca a que tipo de chequeo corresponden con el cliente y periodo
        query.append(" SELECT CASE WHEN (NUEVO_L.IND_CHEQ_NUEV = 1 AND NUEVO_C.IND_CHEQ_NUEV = 1) THEN " + ConstantesREC.OID_TIPO_REVISION_Z + " ELSE  ");       
        query.append(" (CASE WHEN (NUEVO_L.IND_CHEQ_NUEV = 1 AND NUEVO_C.IND_CHEQ_NUEV = 0) THEN " + ConstantesREC.OID_TIPO_REVISION_X + " ELSE  ");
        query.append(" (CASE WHEN (NUEVO_L.IND_CHEQ_NUEV = 0 AND NUEVO_C.IND_CHEQ_NUEV = 1) THEN " + ConstantesREC.OID_TIPO_REVISION_Y + " END) END) END OID_INDI_REVI ");
        query.append(" FROM (SELECT NVL(paramCheq.IND_CHEQ_NUEV,0) IND_CHEQ_NUEV ");
        query.append(" FROM REC_PARAM_CHEQU paramCheq, PED_TIPO_INDIC_REVIS tipoCheq ");
        query.append(" WHERE paramCheq.TIRV_OID_TIPO_INDI_REVI(+) = tipoCheq.OID_TIPO_INDI_REVI ");       
        query.append(" AND tipoCheq.COD_TIPO_INDI_REVI(+) = '" + ConstantesREC.COD_TIPO_REVISION_LINEA + "') NUEVO_L, ");
        query.append(" (SELECT NVL(paramCheq.IND_CHEQ_NUEV,0) IND_CHEQ_NUEV ");
        query.append(" FROM REC_PARAM_CHEQU paramCheq, PED_TIPO_INDIC_REVIS tipoCheq ");
        query.append(" WHERE paramCheq.TIRV_OID_TIPO_INDI_REVI(+) = tipoCheq.OID_TIPO_INDI_REVI ");
        query.append(" AND tipoCheq.COD_TIPO_INDI_REVI(+) = '" + ConstantesREC.COD_TIPO_REVISION_CAMPO + "') NUEVO_C ");  
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
         
        UtilidadesLog.debug("rs: " + rs); 
       
        if(!rs.esVacio()){
        
            if((BigDecimal)rs.getValueAt(0, "OID_INDI_REVI")!= null){
                valor = Long.valueOf(((BigDecimal)rs.getValueAt(0, "OID_INDI_REVI")).toString()); 
            }
        }
        
        UtilidadesLog.debug("valor: " + valor);            

        UtilidadesLog.info("DAOAPP.obtenerRevisionClientesAChequear(DTOClienteChequeo DTOE): Salida ");

        //Resultado devuelto
        return valor;
    }

    public Boolean esConfiguracionChequeoEnLinea(DTOClienteChequeo DTOE)
        throws MareException {
        UtilidadesLog.info("DAOAPP.esConfiguracionChequeoEnLinea(DTOClienteChequeo DTOE): Entrada ");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        //Realiza una consulta utilizando el servicio DBService. 
        consulta.append(" SELECT COUNT(*) contador ");
        consulta.append(" FROM REC_CONFI_LINEA ");
        consulta.append(" WHERE ");
        consulta.append(" PERD_OID_PERI = ? ");
        parametros.add(DTOE.getOidPeriodo());

        if (DTOE.getOidSubgerencia() != null) {
            consulta.append(" AND ZSGV_OID_SUBG_VENT = ? ");
            parametros.add(DTOE.getOidSubgerencia());
        }

        if (DTOE.getOidRegion() != null) {
            consulta.append(" AND ZORG_OID_REGI = ?  ");
            parametros.add(DTOE.getOidRegion());
        }

        if (DTOE.getOidZona() != null) {
            consulta.append(" AND ZZON_OID_ZONA = ? ");
            parametros.add(DTOE.getOidZona());
        }

        if (DTOE.getOidSeccion() != null) {
            consulta.append(" AND ZSCC_OID_SECC = ? ");
            parametros.add(DTOE.getOidSeccion());
        }

        consulta.append(" AND IND_CHEQ_NUEV = ?");

        // Incidencia 8629
        parametros.add(ConstantesPED.SI);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("esConfiguracionChequeoEnLinea: Exception", e);
            this.logSql("esConfiguracionChequeoEnLinea. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Boolean valor = null;

        if ((((BigDecimal) rs.getValueAt(0, 0)).intValue()) == 0) {
            valor = new Boolean("false");
        } else {
            valor = new Boolean("true");
        }

        UtilidadesLog.info("DAOAPP.esConfiguracionChequeoEnLinea(DTOClienteChequeo DTOE): Salida ");

        // Resultado devuelto
        return valor;
    }

    public Boolean esConfiguracionChequeoEnCampo(Long oidPeriodo)
        throws MareException {
        UtilidadesLog.info("DAOAPP.esConfiguracionChequeoEnCampo(Long oidPeriodo) : Entrada ");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        //Realiza una consulta utilizando el servicio DBService. 
        consulta.append(" SELECT COUNT(*) contador ");
        consulta.append(" FROM REC_CONFI_CAMPO ");
        consulta.append(" WHERE ");
        consulta.append(" IND_CHEQ_NUEV = ?");

        //Incidencia 8629
        parametros.add(ConstantesPED.SI);

        if (oidPeriodo != null) {
            consulta.append(" AND PERD_OID_PERI = ? ");
            parametros.add(oidPeriodo);
        }

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("esConfiguracionChequeoEnCampo: Exception", e);
            this.logSql("esConfiguracionChequeoEnCampo. SQL: ",
                consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Boolean valor = null;

        if ((((BigDecimal) rs.getValueAt(0, 0)).intValue()) == 0) {
            valor = new Boolean("false");
        } else {
            valor = new Boolean("true");
        }

        UtilidadesLog.info("DAOAPP.esConfiguracionChequeoEnCampo(Long oidPeriodo): Salida ");

        //Resultado devuelto
        return valor;
    }

    public Boolean esZonaChequeoEnCampo(DTOClienteChequeo DTOE)
        throws MareException {
        UtilidadesLog.info("DAOAPP.esZonaChequeoEnCampo(DTOClienteChequeo DTOE): Entrada ");

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        //Realiza una consulta utilizando el servicio DBService. 
        consulta.append(" SELECT COUNT(*) contador ");
        consulta.append(" FROM REC_ZONAS_CAMPO A, REC_CONFI_CAMPO B ");
        consulta.append(" WHERE A.CCCC_OID_CONF_CAMP = B.OID_CONF_CAMP ");

        if (DTOE.getOidPeriodo() != null) {
            consulta.append(" AND B.PERD_OID_PERI = ? ");
            parametros.add(DTOE.getOidPeriodo());
        }

        if (DTOE.getOidSubgerencia() != null) {
            consulta.append(" AND A.ZSGV_OID_SUBG_VENT = ? ");
            parametros.add(DTOE.getOidSubgerencia());
        }

        if (DTOE.getOidRegion() != null) {
            consulta.append(" AND A.ZORG_OID_REGI = ? ");
            parametros.add(DTOE.getOidRegion());
        }

        if (DTOE.getOidZona() != null) {
            consulta.append(" AND A.ZZON_OID_ZONA = ? ");
            parametros.add(DTOE.getOidZona());
        }

        if (DTOE.getOidSeccion() != null) {
            consulta.append(" AND A.ZSCC_OID_SECC = ? ");
            parametros.add(DTOE.getOidSeccion());
        }

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("esZonaChequeoEnCampo : Exception", e);
            this.logSql("esZonaChequeoEnCampo . SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        Boolean valor = null;

        if ((((BigDecimal) rs.getValueAt(0, 0)).intValue()) == 0) {
            valor = new Boolean("false");
        } else {
            valor = new Boolean("true");
        }

        UtilidadesLog.info("DAOAPP.esZonaChequeoEnCampo(DTOClienteChequeo DTOE): Salida ");

        //Resultado devuelto
        return valor;
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.info(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.error(metodo + sParams);
        }
    }
}
