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
package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

//import es.indra.sicc.dtos.zon.DTOPedidosZona;
//import es.indra.sicc.dtos.zon.DTOHistoricoZona;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;
import java.util.Vector;

public class DAOReestructuracion {

    public DAOReestructuracion() {  }


    /**
     * 06-06-2007   agregado por Sapaza, incidencia Sicc-20070276, se agrego filtros para pedidos
     *              de tipo orden de compra, que no sea anulacion ni devolucion
     * Obtiene el último periodo para el que se realizó un pedido en la Unidad Administrativa recibida. 
     * Solo se filtrará por aquellos niveles (subgerencia, región, zona, sección y territorio) que estén informados.
     * @param Long oidPais 
     * @param String subgerencia, 
     * @param String region, 
     * @param String zona, 
     * @param String seccion, 
     * @param String territorio
     * @return DTOPeriodo con los datos del perido encontrado
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public DTOPeriodo obtenerUltimoPeriodoUA (Long oidPais, Long oidMarca, Long oidCanal, String subgerencia, String region, String zona, String seccion, String territorio) throws MareException {
        UtilidadesLog.info("DAOReestructuracion.obtenerUltimoPeriodoUA (Long oidPais, Long oidMarca, Long oidCanal, String subgerencia, String region, String zona, String seccion, String territorio): Entrada");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer("SELECT XX.* FROM (SELECT ");

        consulta.append(" P.OID_PERI OID_PERIODO, "); 
        consulta.append(" P.FEC_FINA FECHA_FINAL "); 

        consulta.append(" FROM "); 
        consulta.append(" PED_SOLIC_CABEC SC, "); 
        
        //agregado por Sapaza, incidencia Sicc 20070276 (06-06-2007)
        consulta.append(" PED_TIPO_SOLIC_PAIS  TSP, " );
        consulta.append(" PED_TIPO_SOLIC TS, " );
        
        consulta.append(" CRA_PERIO P, "); 
        //consulta.append(" MAE_CLIEN CL, "); //incidencia
        consulta.append(" ZON_TERRI_ADMIN TA, "); 
        consulta.append(" ZON_TERRI TE, "); //incidencia
        consulta.append(" ZON_SECCI SE, "); 
        consulta.append(" ZON_ZONA ZO, "); 
        consulta.append(" ZON_REGIO RE, "); 
        consulta.append(" ZON_SUB_GEREN_VENTA SV "); 

        consulta.append(" WHERE "); 

        consulta.append(" SC.PAIS_OID_PAIS = ? AND "); //incidencia
        parametros.add(oidPais);

// PERIODO 
        consulta.append(" SC.PERD_OID_PERI = P.OID_PERI AND "); 

// UNIDAD ADMINISTRATIVA 
        consulta.append(" SC.ZTAD_OID_TERR_ADMI = TA.OID_TERR_ADMI AND "); 

// TERRITORIO 
        consulta.append(" TA.TERR_OID_TERR = TE.OID_TERR AND "); 
        if (territorio != null) {
            consulta.append(" TE.COD_TERR = ? AND "); 
            parametros.add(territorio);
        }

// SECCION 
        consulta.append(" TA.ZSCC_OID_SECC = SE.OID_SECC AND "); 
        if (seccion != null) {
            consulta.append(" SE.COD_SECC = ? AND "); 
            parametros.add(seccion);
        }

// ZONA 
        consulta.append(" SE.ZZON_OID_ZONA = ZO.OID_ZONA AND "); 
        if (zona != null) {
            consulta.append(" ZO.COD_ZONA = ? AND "); 
            parametros.add(zona);
        }

// REGION 
        consulta.append(" ZO.ZORG_OID_REGI = RE.OID_REGI AND ");
        if (region != null) {
            consulta.append(" RE.COD_REGI = ? AND "); 
            parametros.add(region);
        }

// SUBGERENCIA VENTAS 
        consulta.append(" RE.ZSGV_OID_SUBG_VENT = SV.OID_SUBG_VENT AND "); 
        consulta.append(" SV.PAIS_OID_PAIS = ? AND ");
        consulta.append(" SV.MARC_OID_MARC = ? AND ");
        consulta.append(" SV.CANA_OID_CANA = ? ");

        //agregado por Sapaza, incidencia Sicc-20070276 (06-06-2007)
        consulta.append("  AND ((SC.IND_PEDI_PRUE is null) OR (SC.IND_PEDI_PRUE = 0)) " );
        consulta.append("  AND SC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS " );
        consulta.append("  AND TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI " );
        consulta.append("  AND TS.IND_DEVO  = 0 " );
        consulta.append("  AND TS.IND_ANUL  = 0 " );
        consulta.append("  AND SC.IND_TS_NO_CONSO = 1 ");                
        consulta.append("  AND SC.IND_OC = 1 " );
        consulta.append("  AND ((SC.IND_PEDI_PRUE is null) OR (SC.IND_PEDI_PRUE = 0)) " );

        parametros.add(oidPais);
        parametros.add(oidMarca);
        parametros.add(oidCanal);

        if (subgerencia != null) {
            consulta.append(" AND SV.COD_SUBG_VENT = ? "); 
            parametros.add(subgerencia);
        }

        consulta.append(" ORDER BY P.FEC_FINA DESC ) XX  WHERE ROWNUM = 1 ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerUltimoPeriodoUA. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOPeriodo dtoPeriodo = new DTOPeriodo();
        if (!resultado.esVacio()) {
            UtilidadesLog.debug("*** Método obtenerUltimoPeriodoUA: hay datos ***");
            dtoPeriodo.setOidPais(oidPais);
            dtoPeriodo.setOid(resultado.getValueAt(0, "OID_PERIODO") != null?new Long(((BigDecimal)resultado.getValueAt(0, "OID_PERIODO")).longValue()):null);
            dtoPeriodo.setFechaFin(resultado.getValueAt(0, "FECHA_FINAL") != null?(Date)resultado.getValueAt(0, "FECHA_FINAL"):null);
        }

        UtilidadesLog.info("DAOReestructuracion.obtenerUltimoPeriodoUA (Long oidPais, Long oidMarca, Long oidCanal, String subgerencia, String region, String zona, String seccion, String territorio): Salida");
        return dtoPeriodo;
    }


    /**
     * Obtiene los territorios activos asociados a la sección recibida 
     * @param Long oidSeccion, 
     * @return RecordSet con los datos de los territorios obtenidos
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public RecordSet obtenerTerritoriosPorSeccion (Long oidSeccion) throws MareException {
        UtilidadesLog.info("DAOReestructuracion.obtenerTerritoriosPorSeccion (Long oidSeccion): Entrada");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer("SELECT ");

        consulta.append(" TAD.OID_TERR_ADMI OID_TERRITORIO_ADM, "); 
        consulta.append(" TAD.TERR_OID_TERR OID_TERRITORIO, "); 
        consulta.append(" TE.COD_TERR CODIGO_TERRITORIO "); 

        consulta.append(" FROM "); 
        consulta.append(" ZON_TERRI_ADMIN TAD, "); 
        consulta.append(" ZON_SECCI SE, "); 
        consulta.append(" ZON_TERRI TE "); 

        consulta.append(" WHERE "); 
        consulta.append(" TAD.ZSCC_OID_SECC = SE.OID_SECC AND "); 
        consulta.append(" SE.OID_SECC = ? AND "); 
        consulta.append(" TAD.TERR_OID_TERR = TE.OID_TERR AND "); 
        consulta.append(" SE.IND_ACTI = 1"); 

        // Parametros de la consulta
        parametros.add(oidSeccion);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerTerritoriosPorSeccion. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOReestructuracion.obtenerTerritoriosPorSeccion (Long oidSeccion): Salida");
        return resultado;
    }

    /**
     * Obtiene las secciones activas asociadas a la zona recibida  
     * @param Long oidZona 
     * @return RecordSet con los datos de las secciones obtenidas
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public RecordSet obtenerSeccionesPorZona (Long oidZona) throws MareException {
        UtilidadesLog.info("DAOReestructuracion.obtenerSeccionesPorZona (Long oidZona): Entrada");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer("SELECT ");

        consulta.append(" SE.OID_SECC OID_SECCION, "); 
        consulta.append(" SE.COD_SECC CODIGO_SECCION, "); 
        // 21886 - dmorello, 05/04/2006: Se recupera la descripción de sección
        consulta.append(" SE.DES_SECCI DESCRIPCION ");

        consulta.append(" FROM  ");
        consulta.append(" ZON_SECCI SE "); 

        consulta.append(" WHERE "); 
        consulta.append(" SE.ZZON_OID_ZONA = ? AND "); 
        consulta.append(" SE.IND_ACTI = 1"); 

        // Parametros de la consulta
        parametros.add(oidZona);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerSeccionesPorZona. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOReestructuracion.obtenerSeccionesPorZona (Long oidZona): Salida");
        return resultado;
    }

    /**
     * Obtiene las zonas activas asociadas a la region recibida   
     * @param Long oidRegion 
     * @return RecordSet con los datos de las zonas obtenidas
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public RecordSet obtenerZonasPorRegion (Long oidRegion) throws MareException {
        UtilidadesLog.info("DAOReestructuracion.obtenerZonasPorRegion (Long oidRegion): Entrada");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer("SELECT ");

        consulta.append(" ZO.OID_ZONA OID_ZONA, "); 
        consulta.append(" ZO.COD_ZONA CODIGO_ZONA,  ");
        // 21886 - dmorello, 05/04/2006: Se recupera la descripción de la zona.
        consulta.append(" ZO.DES_ZONA DESCRIPCION ");

        consulta.append(" FROM  ");
        consulta.append(" ZON_ZONA ZO "); 

        consulta.append(" WHERE ");
        consulta.append(" ZO.ZORG_OID_REGI = ? AND "); 
        consulta.append(" ZO.IND_ACTI = 1"); 

        // Parametros de la consulta
        parametros.add(oidRegion);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerZonasPorRegion. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOReestructuracion.obtenerZonasPorRegion (Long oidRegion): Salida");
        return resultado;
    }

    /**
     * Obtiene las regiones activas asociadas a la subgerencia recibida    
     * @param Long oidSubgerencia 
     * @return RecordSet con los datos de las regiones obtenidas
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public RecordSet obtenerRegionesPorSubgerencia (Long oidSubgerencia) throws MareException {
        UtilidadesLog.info("DAOReestructuracion.obtenerRegionesPorSubgerencia (Long oidSubgerencia): Entrada");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer("SELECT ");

        consulta.append(" RE.OID_REGI OID_REGION, "); 
        consulta.append(" RE.COD_REGI CODIGO_REGION, ");
        // 21886 - dmorello, 05/04/2006: Se recupera la descripción de región.
        consulta.append(" RE.DES_REGI DESCRIPCION ");

        consulta.append(" FROM "); 
        consulta.append(" ZON_REGIO RE "); 

        consulta.append(" WHERE "); 
        consulta.append(" RE.ZSGV_OID_SUBG_VENT = ? AND "); 
        consulta.append(" RE.IND_ACTI = 1"); 

        // Parametros de la consulta
        parametros.add(oidSubgerencia);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerRegionesPorSubgerencia. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOReestructuracion.obtenerRegionesPorSubgerencia (Long oidSubgerencia): Salida");
        return resultado;
    }

    /**
     * Obtiene los clientes asignados a un territorio administrativo     
     * @param Long oidTerritorioAdm 
     * @return RecordSet con los datos de las clientes obtenidos
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public RecordSet obtenerClientesPorTerritorio (Long oidTerritorioAdm) throws MareException {
        UtilidadesLog.info("DAOReestructuracion.obtenerClientesPorTerritorio (Long oidTerritorioAdm): Entrada");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer("SELECT ");

        consulta.append(" CUA.CLIE_OID_CLIE OID_CLIENTE "); 

        consulta.append(" FROM "); 
        consulta.append(" MAE_CLIEN_UNIDA_ADMIN CUA "); 

        consulta.append(" WHERE "); 
        consulta.append(" CUA.ZTAD_OID_TERR_ADMI = ? "); 

        // Parametros de la consulta
        parametros.add(oidTerritorioAdm);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerClientesPorTerritorio. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOReestructuracion.obtenerClientesPorTerritorio (Long oidTerritorioAdm): Salida");
        return resultado;
    }

    /**
     * Cuenta los territorios administrativos para el periodo actual, que cumplan: 
     * pais = recibido 
     * marca o canal <> recibidos 
     * territorio = recibido
     * @throws es.indra.mare.common.exception.MareException
     * @return Long
     * @param territorio .
     * @param canal .
     * @param marca .
     * @param pais .
     */
    public Long obtenerTerritoriosAdministrativosPeriodoActual (Long pais, Long marca, 
                                                                Long canal, Long territorio) 
                                                                throws MareException {
        UtilidadesLog.info("DAOReestructuracion.obtenerTerritoriosAdministrativosPeriodoActual (Long pais, Long marca, Long canal, Long territorio) : Entrada");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();
        SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
        Timestamp date = new Timestamp(System.currentTimeMillis());


        consulta.append(" SELECT COUNT(*) As TERRITORIOS");

        consulta.append(" FROM ZON_TERRI_ADMIN TAD, ");
        consulta.append(" ZON_SECCI SE, ");
        consulta.append(" CRA_PERIO PE_INICIO, ");
        consulta.append(" CRA_PERIO PE_FIN ");
 
        consulta.append(" WHERE SE.OID_SECC = TAD.ZSCC_OID_SECC ");
        consulta.append(" AND SE.PERD_OID_PERI_INIC = PE_INICIO.OID_PERI ");
        consulta.append(" AND SE.PERD_OID_PERI_FINA = PE_FIN.OID_PERI ");
        
        consulta.append(" AND PE_INICIO.FEC_INIC <= to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') ");
        consulta.append(" AND PE_FIN.FEC_FINA >= to_date('" + formatter.format(date) + "', 'DD-MM-YYYY') ");
        if(pais != null){
            consulta.append(" AND TAD.PAIS_OID_PAIS = ? ");
            parametros.add(pais);
        }
        if(marca != null){
            consulta.append(" AND (TAD.MARC_OID_MARC <> ? ");
            parametros.add(marca);
        }
        if(canal != null){
            consulta.append(" OR TAD.CANA_OID_CANA <> ? )");
            parametros.add(canal);
        }
        if(territorio != null){
            consulta.append(" AND TAD.TERR_OID_TERR = ? ");
            parametros.add(territorio);
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        Long numTerritorios = new Long(0);

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerTerritoriosAdministrativosPeriodoActual. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        // Recupero el resultado del RecordSet
        if(resultado != null){
            if(resultado.getValueAt(0,"TERRITORIOS") != null){                
                numTerritorios = new Long(((BigDecimal)resultado.getValueAt(0,"TERRITORIOS")).longValue());
            }
        }

        UtilidadesLog.info("DAOReestructuracion.obtenerTerritoriosAdministrativosPeriodoActual (Long pais, Long marca, Long canal, Long territorio) : Salida");
        return numTerritorios;
    }
    
    /**
     * Obtiene los clientes asociados al territorio físico recibido
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param oidTerritorio .
     */
    public RecordSet obtenerClientesPorTerritorioFisico (Long oidTerritorio) 
                                                                throws MareException {
        UtilidadesLog.info("DAOReestructuracion.obtenerClientesPorTerritorioFisico (Long oidTerritorio): Entrada");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT CD.CLIE_OID_CLIE OID_CLIENTE ");        
        consulta.append(" FROM MAE_CLIEN_DIREC CD ");
        
        if(oidTerritorio != null){
            consulta.append(" WHERE CD.TERR_OID_TERR = ? ");
            consulta.append(" AND CD.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
            parametros.add(oidTerritorio);
        } //<inicio>agregado por Sapaza, incidencia V_MAE_08
        else {
            consulta.append(" WHERE CD.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
        } //<fin>agregado por Sapaza, incidencia V_MAE_08
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            e.printStackTrace();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerClientesPorTerritorioFisico. SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOReestructuracion.obtenerClientesPorTerritorioFisico (Long oidTerritorio): Salida");
        return resultado;
    }
    
    /**
     * Obtiene la dirección para el cliente y territorio recibido 
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param oidTerritorio .
     * @param cliente .
     */
    public RecordSet obtenerClienteDireccion (Long cliente, Long oidTerritorio) 
                                              throws MareException {
        UtilidadesLog.info("DAOReestructuracion.obtenerClienteDireccion (Long cliente, Long oidTerritorio): Entrada");

        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT CD.OID_CLIE_DIRE As OIDCLIENTE ");
        consulta.append(" FROM MAE_CLIEN_DIREC CD ");
         
        consulta.append(" WHERE CD.TERR_OID_TERR = ? ");
        consulta.append(" AND CD.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
        parametros.add(oidTerritorio);
        if (cliente != null){
            consulta.append("       AND CD.CLIE_OID_CLIE = ? ");
            parametros.add(cliente);
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;

        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerClienteDireccion.SQL: ", consulta.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOReestructuracion.obtenerClienteDireccion (Long cliente, Long oidTerritorio): Salida");
        return resultado;
    }
    
  private void logSql(String metodo, String sql, Vector params){
    UtilidadesLog.info("DAOReestructuracion.logSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
    UtilidadesLog.info("DAOReestructuracion.logSql(String metodo, String sql, Vector params): Salida");
  }

  /**
   * (31/05/2007) agregado por incidencia Sicc-20070266 (Sapaza), se calcula la cantidad de pedidos (O/C,
   *              no anulaciones ni devoluciones) para la consultora en los periodos vigentes
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param periodos
   * @param cliente
   */
    public boolean validarPedidosConsultora(Long cliente, String periodos) throws es.indra.mare.common.exception.MareException{
        UtilidadesLog.info("DAOReestructuracion.validarPedidosConsultora(Long cliente, Long periodo): Entrada ");
        Boolean bRetorno = null;
        BelcorpService belcorpService;
        RecordSet rs;
        Vector parametros = new Vector();

        StringBuffer query = new StringBuffer();
        query.append( " SELECT COUNT(*) " );
        query.append( "   FROM PED_SOLIC_CABEC s, " );
        query.append( "        PED_TIPO_SOLIC_PAIS  tipoSolPais, " );
        query.append( "        PED_TIPO_SOLIC tipoSol " );
        query.append( "  WHERE s.IND_OC = 1 " );
        query.append( "    AND s.PERD_OID_PERI IN " + periodos );
        query.append( "    AND s.CLIE_OID_CLIE = " + cliente.toString() );
        query.append( "    AND ((s.IND_PEDI_PRUE is null) OR (s.IND_PEDI_PRUE = 0)) " );
        query.append( "    AND s.TSPA_OID_TIPO_SOLI_PAIS = tipoSolPais.OID_TIPO_SOLI_PAIS " );
        query.append( "    AND tipoSolPais.TSOL_OID_TIPO_SOLI = tipoSol.OID_TIPO_SOLI " );
        query.append( "    AND tipoSol.IND_DEVO  = 0 " );
        query.append( "    AND tipoSol.IND_ANUL  = 0 " );
        query.append("     AND s.IND_TS_NO_CONSO = 1 ");
        //  Agregado por HRCS - Incidencia Sicc20080587
        query.append("     AND s.FEC_FACT is not null ");
        query.append("     AND s.MODU_OID_MODU <> " + ConstantesPED.MODULO_RECLAMOS);
      
        try{
            belcorpService = BelcorpService.getInstance();
        } catch(Exception e){
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
      
        try{
          rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch( Exception e ){
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.validarPedidosConsultora. SQL: ", query.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
      
        BigDecimal bd = (BigDecimal)rs.getValueAt(0, 0);
      
        UtilidadesLog.info("DAOReestructuracion.validarPedidosConsultora(Long cliente, Long periodo): Salida ");
        
        if( bd.intValue() > 0 ){
          return true;
        } else{
          return false;
        }
    }

  /**
   * (31/05/2007) agregado por incidencia Sicc-20070266 (Sapaza), Se obtiene el siguiente periodo para el
   *              ultimo periodo que la consulta realizo un pedido (O/C, no anulaciones ni devoluciones)
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param canal
   * @param marca
   * @param pais
   * @param cliente
   */
    public RecordSet obtenerPeriodoSiguientePasoPedidoCliente(Long cliente, Long pais, Long marca, Long canal) throws es.indra.mare.common.exception.MareException{
        UtilidadesLog.info("DAOReestructuracion.obtenerPeriodoSiguientePasoPedidoCliente(Long cliente, Long pais, Long marca, Long canal): Entrada ");
        Long ultimoPeriodo = null;
        BelcorpService belcorpService;
        RecordSet rs;
        Vector parametros = new Vector();

        StringBuffer query = new StringBuffer();
        query.append( " SELECT OID_PERI " );
        query.append( " FROM  (SELECT OID_PERI " );
        query.append( "        FROM CRA_PERIO " );
        query.append( "        WHERE OID_PERI IN " );
        query.append( "  (SELECT DISTINCT per.OID_PERI " );
        query.append( "    FROM PED_SOLIC_CABEC s, ");
        query.append( "         PED_TIPO_SOLIC_PAIS tipoSolPais, ");
        query.append( "         PED_TIPO_SOLIC tipoSol, " );
        query.append( "         CRA_PERIO per " );
        query.append( "    WHERE s.IND_OC = 1 " );
        query.append( "    AND s.CLIE_OID_CLIE = " + cliente.toString() );
        query.append( "    AND ((s.IND_PEDI_PRUE is null) OR (s.IND_PEDI_PRUE = 0)) " );
        query.append( "    AND s.TSPA_OID_TIPO_SOLI_PAIS = tipoSolPais.OID_TIPO_SOLI_PAIS " );
        query.append( "    AND tipoSolPais.TSOL_OID_TIPO_SOLI = tipoSol.OID_TIPO_SOLI " );
        query.append( "    AND tipoSol.IND_DEVO  = 0 " );
        query.append( "    AND tipoSol.IND_ANUL  = 0 " );
        query.append("     AND s.IND_TS_NO_CONSO = 1 ");                
        query.append("     AND per.PAIS_OID_PAIS = " + pais);                
        query.append("     AND per.MARC_OID_MARC = " + marca);                
        query.append("     AND per.CANA_OID_CANA = " + canal);                
        query.append( "    AND s.PERD_OID_PERI = per.OID_PERI) ");
        query.append( "    ORDER BY FEC_INIC DESC) ");
        query.append( " WHERE ROWNUM=1 ");
        
        belcorpService = BelcorpService.getInstance();
        
        try{
          rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch( Exception e ){
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerPeriodoSiguientePasoPedidoCliente. SQL: ", query.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
      
        if(rs.esVacio()) {
            return rs;
        } else {
            ultimoPeriodo = new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
            UtilidadesLog.debug("Encontro Periodo para Cliente (" + cliente + "): " + ultimoPeriodo);
        }
        
        //Obtenemos el periodo siguiente al periodo encontrado anteriormente
        try {
            query = new StringBuffer();
            query.append(" SELECT B.oid_peri oid, to_char(B.fec_inic,'YYYYMMDD') fechainicio ");
            query.append(" FROM cra_perio A, cra_perio B ");
            query.append(" WHERE A.oid_peri = " + ultimoPeriodo);
            query.append(" AND B.pais_oid_pais = A.pais_oid_pais ");
            query.append(" AND B.marc_oid_marc = A.marc_oid_marc ");
            query.append(" AND B.cana_oid_cana = A.cana_oid_cana ");
            query.append(" AND B.fec_inic > A.fec_inic ");
            query.append(" ORDER BY B.fec_inic ");                        

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info("DAOReestructuracion.obtenerPeriodoSiguientePasoPedidoCliente(Long cliente, Long pais, Long marca, Long canal): Salida ");                        
            
            return rs;
            
        } catch(Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerPeriodoSiguientePasoPedidoCliente. SQL: ", query.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
    }

  /**
   * (31/05/2007) agregado por incidencia Sicc-20070266 (Sapaza), Se obtiene el siguiente periodo para el
   *              ultimo cierre de la region Destino
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param oidTipoCierre
   * @param region
   * @param canal
   * @param marca
   * @param pais
   */
    public RecordSet obtenerPeriodoSiguienteUltimoCierreRegion(Long pais, Long marca, Long canal, Long region, Long oidTipoCierre) throws es.indra.mare.common.exception.MareException{
        UtilidadesLog.info("DAOReestructuracion.obtenerPeriodoSiguienteUltimoCierreRegion(Long pais, Long marca, Long canal, Long region): Entrada ");
        Long ultimoPeriodo = null;
        BelcorpService belcorpService;
        RecordSet rs;
        Vector parametros = new Vector();
  
        StringBuffer query = new StringBuffer();
        query.append( " SELECT OID_PERI " );
        query.append( " FROM  (SELECT OID_PERI " );
        query.append( "        FROM CRA_PERIO " );
        query.append( "        WHERE OID_PERI IN " );
        query.append( "  (SELECT DISTINCT cierre.PERD_OID_PERI  " );
        query.append( "    FROM FAC_CONTR_CIERR cierre, ");
        query.append( "         ZON_REGIO reg  ");
        query.append("     WHERE cierre.PAIS_OID_PAIS = " + pais );
        query.append("        AND cierre.TCIE_OID_TIPO_CIER = " + oidTipoCierre );
        query.append("        AND cierre.ZORG_OID_REGI = reg.OID_REGI ");
        query.append("        AND reg.MARC_OID_MARC = " + marca );
        query.append("        AND reg.CANA_OID_CANA = " + canal );
        query.append("        AND reg.OID_REGI = " + region + ")" );
        query.append( "    ORDER BY FEC_INIC DESC) ");
        query.append( " WHERE ROWNUM=1 ");
        
        belcorpService = BelcorpService.getInstance();

        try{
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch( Exception e ){
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerPeriodoSiguienteUltimoCierreRegion. SQL: ", query.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));

        }
      
        if(rs.esVacio()) {
            return rs;
        } else {
            ultimoPeriodo = new Long(((BigDecimal) rs.getValueAt(0, 0)).longValue());
            UtilidadesLog.debug("Encontro Ultimo Cierre para Region (" + region + "): " + ultimoPeriodo);
        }
        
        //Obtenemos el periodo siguiente al periodo encontrado anteriormente
        try {
            query = new StringBuffer();
            query.append(" SELECT B.oid_peri oid, to_char(B.fec_inic,'YYYYMMDD') fechainicio ");
            query.append(" FROM cra_perio A, cra_perio B ");
            query.append(" WHERE A.oid_peri = " + ultimoPeriodo);
            query.append(" AND B.pais_oid_pais = A.pais_oid_pais ");
            query.append(" AND B.marc_oid_marc = A.marc_oid_marc ");
            query.append(" AND B.cana_oid_cana = A.cana_oid_cana ");
            query.append(" AND B.fec_inic > A.fec_inic ");
            query.append(" ORDER BY B.fec_inic ");                        

            rs = belcorpService.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info("DAOReestructuracion.obtenerPeriodoSiguienteUltimoCierreRegion(Long pais, Long marca, Long canal, Long region): Salida ");

            return rs;
        } catch(Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            this.logSql("DAOReestructuracion.obtenerPeriodoSiguienteUltimoCierreRegion. SQL: ", query.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }
  
}
