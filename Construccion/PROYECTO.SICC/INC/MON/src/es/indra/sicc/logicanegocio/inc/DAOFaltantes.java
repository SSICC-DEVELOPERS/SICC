/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @autor: Damasia Maneiro
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOBusquedaFaltantes;
import es.indra.sicc.dtos.inc.DTOPremioSustitutivo;
import es.indra.sicc.dtos.inc.DTOProductoSustitutivo;
import es.indra.sicc.dtos.inc.DTOPrecioReclamo;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.inc.ArticulosPremioAlternativoLocalHome;
import es.indra.sicc.entidades.inc.BolsaFantantesLocal;
import es.indra.sicc.entidades.inc.BolsaFantantesLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.inc.Faltante;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.ejb.CreateException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


class DAOFaltantes {
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOFaltantes() {
    }
    
    /**
    * Fecha de Creacion: 26/04/2005
    * Autor: Damasia Maneiro
    *
    */
    public DTOSalida recuperarCodConcurso(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("DAOFaltantes.recuperarCodConcurso(DTOBelcorp dto):"
            +"Entrada");

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_PARA_GRAL, NUM_CONC");
            query.append(" FROM INC_CONCU_PARAM_GENER");
            query.append(" WHERE PAIS_OID_PAIS = " + dto.getOidPais());
            query.append(" ORDER BY NUM_CONC");

            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOFaltantes.recuperarCodConcurso(DTOBelcorp dto):"
            +"Salida");

        return dtoSalida;
    }

    /**
    * Fecha de Creacion: 26/04/2005
    * Autor: Damasia Maneiro
    * Comentario: busca los premios faltantes vigentes dependiendo de los 
    * parametros de entrada.
    * Modificado por: Cristian Valenzuela
    * Fecha: 19/06/2006
    * Incidencia: DBLG500000928
    * Comentario: Se agrega el campo ROWNUM, para poder identificar
    * cada registro de la lista en la pantalla. El primer campo era
    * el oid de concurso que se repite.
    *
    */
    public DTOSalida recuperarPremiosFaltantesVigentes(
        DTOBusquedaFaltantes dtoe) throws MareException {
        UtilidadesLog.info("DAOFaltantes.recuperarPremiosFaltantesVigentes(DTO"
            +"BusquedaFaltantes dtoe):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;
        ArrayList regiones = parseaString(dtoe.getRegiones());
        ArrayList zonas = parseaString(dtoe.getZonas());
        ArrayList productos = parseaString(dtoe.getCodigosProductos());
        DTOSalida dtoSalida = new DTOSalida();
        int corte = 1000;
        
        //Agregado por Cristian Valenzuela - 19/06/2006
        query.append(" SELECT ROWNUM AS ID, E.* FROM ( ");
        //FIN - Agregado por Cristian Valenzuela - 19/06/2006
        query.append(" SELECT MAX(CONC.OID_PARA_GRAL) OID, ");
        query.append(" MAX(CONC.NUM_CONC) NUMERO_CONCURSO, ");
        query.append(" MAX(CLIE.COD_CLIE) CODIGO_CLIENTE, ");
        query.append( " MAX(REGI.COD_REGI) CODIGO_REGION, ");
        query.append(" MAX(ZON.COD_ZONA) CODIGO_ZONA,");
        query.append(" MAX(SCAB.NUM_PREM) NUMERO_PREMIO,  ");
        // vbongiov -- DBLG500000739
        query.append(" PROD.COD_SAP CODIGO_PROD, ");   
        query.append(" MAX(SCAB.COPA_OID_PARA_GENE) OID_CONCURSO, ");
        query.append(" SCAB.OID_SOLI_CABE, ");
        query.append(" MAX(SCAB.CLIE_OID_CLIE) OID_CLIENTE,");
        query.append(" MAX(ZON.OID_ZONA) OID_ZONA, MAX(REGI.OID_REGI) OID_REGION ");        
        query.append(" FROM INC_BOLSA_FALTA BOLF, PED_SOLIC_POSIC SPOS,");
        query.append(" PED_SOLIC_CABEC SCAB, MAE_CLIEN CLIE,");
        query.append(" INC_CONCU_PARAM_GENER CONC, ZON_ZONA ZON, ZON_REGIO REGI, ");
        query.append(" mae_produ prod ");
        query.append(" WHERE BOLF.SOPO_OID_SOLI_POSI = SPOS.OID_SOLI_POSI");
        query.append(" AND SPOS.SOCA_OID_SOLI_CABE = SCAB.OID_SOLI_CABE");
        query.append(" AND SCAB.CLIE_OID_CLIE = CLIE.OID_CLIE");
        query.append(" AND SCAB.COPA_OID_PARA_GENE = CONC.OID_PARA_GRAL");
        query.append(" AND SCAB.ZZON_OID_ZONA = ZON.OID_ZONA");
        query.append(" AND ZON.ZORG_OID_REGI = REGI.OID_REGI");
        query.append(" AND BOLF.FEC_SOLU IS NULL ");
        query.append(" AND prod.OID_PROD = SPOS.PROD_OID_PROD ");
        query.append(" AND NOT EXISTS (SELECT 1 FROM INC_ARTIC_PREMI_ALTER PRAL");
        query.append(" WHERE PRAL.BOFA_OID_BOLS_FALT = BOLF.OID_BOLS_FALT)");

        if (dtoe.getOidConcurso() != null) {
            query.append(" AND CONC.OID_PARA_GRAL = " + dtoe.getOidConcurso());
        }
        //recorro ArrayList de regiones 
        if ((regiones != null) && (regiones.size() != 0)) {
            if (regiones.size() <= corte) {
                query.append(" AND REGI.OID_REGI IN ( ");
                for (int index = 0; index < regiones.size(); index++) {
                    String oid = (String) regiones.get(index);
                    query.append(oid);
                    if ((index != (regiones.size() - 1))) {
                        query.append(",");
                    }
                }
                query.append(" ) ");
            } else {
                query.append(" AND ( REGI.OID_REGI IN ( ");
                for (int index = 0; index < regiones.size(); index++) {
                    String oid = (String) regiones.get(index);
                    query.append(oid);
                    if ((index != (regiones.size() - 1)) &&
                            (((index + 1) % corte) != 0)) {
                        query.append(",");
                    } else {
                        if (index != (regiones.size() - 1)) {
                            query.append(" ) OR REGI.OID_REGI IN (");
                        }
                    }
                }
                query.append(" ) )");
            }
        }
        //recorro ArrayList de zonas      
        if ((zonas != null) && (zonas.size() != 0)) {
            if (zonas.size() <= corte) {
                query.append(" AND ZON.OID_ZONA IN ( ");
                for (int index = 0; index < zonas.size(); index++) {
                    String oid = (String) zonas.get(index);
                    query.append(oid);
                    if ((index != (zonas.size() - 1))) {
                        query.append(",");
                    }
                }
                query.append(" ) ");
            } else {
                query.append(" AND ( ZON.OID_ZONA IN ( ");
                for (int index = 0; index < zonas.size(); index++) {
                    String oid = (String) zonas.get(index);
                    query.append(oid);
                    if ((index != (zonas.size() - 1)) &&
                            (((index + 1) % corte) != 0)) {
                        query.append(",");
                    } else {
                        if (index != (zonas.size() - 1)) {
                            query.append(" ) OR ZON.OID_ZONA IN ( ");
                        }
                    }
                }
                query.append(" ) )");
            }
        }
        //recorro ArrayList de productos   
        if ((productos != null) && (productos.size() != 0)) {
            if (productos.size() <= corte) {
                query.append(" AND SPOS.PROD_OID_PROD IN ( ");
                for (int index = 0; index < productos.size(); index++) {
                    String oid = (String) productos.get(index);
                    query.append(oid);
                    if ((index != (productos.size() - 1))) {
                        query.append(",");
                    }
                }
                query.append(" )");
            } else {
                query.append(" AND ( SPOS.PROD_OID_PROD IN ( ");
                for (int index = 0; index < productos.size(); index++) {
                    String oid = (String) productos.get(index);
                    query.append(oid);
                    if ((index != (productos.size() - 1)) &&
                            (((index + 1) % corte) != 0)) {
                        query.append(",");
                    } else {
                        if (index != (productos.size() - 1)) {
                            query.append(" ) OR SPOS.PROD_OID_PROD IN (");
                        }
                    }
                }
                query.append(" ) )");
            }
        }
        query.append(" GROUP BY SCAB.OID_SOLI_CABE, PROD.COD_SAP");
        //Agregado por Cristian Valenzuela - 19/06/2006
        query.append(" ) E");
        //FIN - Agregado por Cristian Valenzuela - 19/06/2006
        
        try {
            rs = (RecordSet) belcorpService.getInstance()
                .dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("* rs: " + rs);
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
            UtilidadesError.armarCodigoError(codigoError));
        }
        
        if(rs.esVacio()) {
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), 
            UtilidadesError.armarCodigoError(sCodigoError));          
        }      
        
        dtoSalida.setResultado(rs);
        UtilidadesLog.debug("*** dtoSalida: " + dtoSalida);
        UtilidadesLog.info("DAOFaltantes.recuperarPremiosFaltantesVigentes("
            +"DTOBusquedaFaltantes dtoe):Salida");

        return dtoSalida;
    }

    /**
    * Fecha de Creacion: 26/04/2005
    * Autor: Damasia Maneiro
    * Comentario: busca los premios faltantes historicos y sus premios 
    * alternativos
    * dependiendo de los parametros de entrada.
    * Modificado por: Cristian Valenzuela
    * Fecha: 19/06/2006
    * Comentario: Se agrega el campo ROWNUM, para poder identificar
    * cada registro de la lista en la pantalla. El primer campo era
    * el oid de concurso que se repite.
    *
    */
    public DTOSalida recuperarPremiosFaltantesHistoricos(
        DTOBusquedaFaltantes dtoe) throws MareException {
        UtilidadesLog.info("DAOFaltantes.recuperarPremiosFaltantesHistoricos("
            +"DTOBusquedaFaltantes dtoe):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        String codigoError;
        ArrayList regiones = parseaString(dtoe.getRegiones());
        ArrayList zonas = parseaString(dtoe.getZonas());
        ArrayList productos = parseaString(dtoe.getCodigosProductos());
        DTOSalida dtoSalida = new DTOSalida();
        int corte = 1000;
        
        //Agregado por Cristian Valenzuela - 19/06/2006
        query.append(" SELECT ROWNUM AS ID, E.* FROM (");
        //FIN - Agregado por Cristian Valenzuela - 19/06/2006
        query.append(" SELECT MAX(CONC.OID_PARA_GRAL) OID, ");
        query.append(" MAX(CONC.NUM_CONC) NUMERO_CONCURSO, ");
        query.append(" MAX(CLIE.COD_CLIE) CODIGO_CLIENTE,");
        query.append(" MAX(REGI.COD_REGI) CODIGO_REGION,  ");
        query.append(" MAX(ZON.COD_ZONA) CODIGO_ZONA,");
        query.append(" MAX(SCAB.NUM_PREM) NUMERO_PREMIO, ");
        // vbongiov -- DBLG500000739
        query.append(" PROD1.COD_SAP CODIGO_PROD, ");
        query.append(" MAX(BOLF.FEC_SOLU) FECHA_SOLUCION,");
        query.append(" MAX(PRE_ALT.VAL_PREM_ALTE) PREMIO_ALTERNATIVO,  ");
        query.append(" MAX(PROD.COD_SAP) CODIGO_PROD_PREM_ALT ");  
        query.append(" FROM INC_BOLSA_FALTA BOLF, PED_SOLIC_POSIC SPOS,");
        query.append(" PED_SOLIC_CABEC SCAB, MAE_CLIEN CLIE,");
        query.append(" INC_CONCU_PARAM_GENER CONC, ZON_ZONA ZON,");
        query.append(" ZON_REGIO REGI, INC_ARTIC_PREMI_ALTER PRE_ALT,");
        query.append(" MAE_PRODU PROD, MAE_PRODU PROD1");        
        query.append(" WHERE BOLF.SOPO_OID_SOLI_POSI = SPOS.OID_SOLI_POSI");
        query.append(" AND SPOS.SOCA_OID_SOLI_CABE = SCAB.OID_SOLI_CABE");
        query.append(" AND SCAB.CLIE_OID_CLIE = CLIE.OID_CLIE");
        query.append(" AND SCAB.COPA_OID_PARA_GENE = CONC.OID_PARA_GRAL");
        query.append(" AND SCAB.ZZON_OID_ZONA = ZON.OID_ZONA ");
        query.append(" AND ZON.ZORG_OID_REGI = REGI.OID_REGI");
        query.append(" AND BOLF.OID_BOLS_FALT = PRE_ALT.BOFA_OID_BOLS_FALT");
        query.append(" AND PRE_ALT.PROD_OID_PROD = PROD.OID_PROD");
        query.append(" AND BOLF.FEC_SOLU IS NOT NULL");
        query.append(" and prod1.OID_PROD = SPOS.PROD_OID_PROD ");
        query.append(" AND EXISTS (SELECT 1 FROM INC_ARTIC_PREMI_ALTER PRAL");
        query.append(" WHERE PRAL.BOFA_OID_BOLS_FALT = BOLF.OID_BOLS_FALT)");

        if (dtoe.getOidConcurso() != null) {
            query.append(" AND CONC.OID_PARA_GRAL = " + dtoe.getOidConcurso());
        }
        //recorro ArrayList de regiones 
        if ((regiones != null) && (regiones.size() != 0)) {
            if (regiones.size() <= corte) {
                query.append(" AND REGI.OID_REGI IN ( ");
                for (int index = 0; index < regiones.size(); index++) {
                    String oid = (String) regiones.get(index);
                    query.append(oid);
                    if ((index != (regiones.size() - 1))) {
                        query.append(",");
                    }
                }
                query.append(" ) ");
            } else {
                query.append(" AND ( REGI.OID_REGI IN ( ");
                for (int index = 0; index < regiones.size(); index++){
                    String oid = (String) regiones.get(index);
                    query.append(oid);
                    if ((index != (regiones.size() - 1)) &&
                            (((index + 1) % corte) != 0)) {
                        query.append(",");
                    } else {
                        if (index != (regiones.size() - 1)) {
                            query.append(" ) OR REGI.OID_REGI IN (");
                        }
                    }
                }
                query.append(" ) )");
            }
        }
        //recorro ArrayList de zonas      
        if ((zonas != null) && (zonas.size() != 0)){
            if (zonas.size() <= corte) {
                query.append(" AND ZON.OID_ZONA IN ( ");
                for (int index = 0; index < zonas.size(); index++) {
                    String oid = (String) zonas.get(index);
                    query.append(oid);
                    if ((index != (zonas.size() - 1))) {
                        query.append(",");
                    }
                }
                query.append(" ) ");
            } else {
                query.append(" AND ( ZON.OID_ZONA IN ( ");
                for (int index = 0; index < zonas.size(); index++) {
                    String oid = (String) zonas.get(index);
                    query.append(oid);
                    if ((index != (zonas.size() - 1)) &&
                            (((index + 1) % corte) != 0)) {
                        query.append(",");
                    } else {
                        if (index != (zonas.size() - 1)) {
                            query.append(" ) OR ZON.OID_ZONA IN ( ");
                        }
                    }
                }
                query.append(" ) )");
            }
        }
        //recorro ArrayList de productos   
        if ((productos != null) && (productos.size() != 0)) {
            if (productos.size() <= corte) {
                query.append(" AND SPOS.PROD_OID_PROD IN ( ");
                for (int index = 0; index < productos.size(); index++) {
                    String oid = (String) productos.get(index);
                    query.append(oid);
                    if ((index != (productos.size() - 1))) {
                        query.append(",");
                    }
                }

                query.append(" )");
            } else {
                query.append(" AND ( SPOS.PROD_OID_PROD IN ( ");
                for (int index = 0; index < productos.size(); index++) {
                    String oid = (String) productos.get(index);
                    query.append(oid);
                    if ((index != (productos.size() - 1)) &&
                            (((index + 1) % corte) != 0)) {
                        query.append(",");
                    } else {
                        if (index != (productos.size() - 1)) {
                            query.append(" ) OR SPOS.PROD_OID_PROD IN (");
                        }
                    }
                }
                query.append(" ) )");
            }
        }
        query.append(" GROUP BY SCAB.OID_SOLI_CABE, PRE_ALT.PROD_OID_PROD, ");
        query.append(" PROD.COD_SAP, PROD1.COD_SAP");        
        //Agregado por Cristian Valenzuela - 19/06/2006
        query.append(" ) E ");
        //FIN - Agregado por Cristian Valenzuela - 19/06/2006

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        if(rs.esVacio()) {
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), 
            UtilidadesError.armarCodigoError(sCodigoError));               
        }

        dtoSalida.setResultado(rs);

        UtilidadesLog.debug("* dtoSalida: " + dtoSalida);
        UtilidadesLog.info("DAOFaltantes.recuperarPremiosFaltantesHistoricos "
            +"(DTOBusquedaFaltantes dtoe):Salida");

        return dtoSalida;
    }

    /**
    * Fecha de Creacion: 26/04/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo obtiene los faltantes para efectuar la 
    * asignacion de sustitutivos.
    * Modificado: 21/06/2005
    * Autor: Carlos Leal
    * Modificado: 29/08/2006
    * Autor: Cristian Valenzuela
    * Incidencia: BELC300023933
    */
    public ArrayList obtenerFaltantesSustitucion(DTOPremioSustitutivo dtosus)
        throws MareException {
        UtilidadesLog.info("DAOFaltantes.obtenerFaltantesSustitucion(DTOPrem"
            +"ioSustitutivo dtosus):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        DTOPeriodo dtoPer = new DTOPeriodo();
        String codigoError;
        ArrayList faltantes = new ArrayList();

        query.append(" SELECT OID_SOLI_CABE, BOLF.OID_BOLS_FALT, ");
        query.append(" ZON.OID_ZONA, ZON.COD_ZONA, SCAB.COPA_OID_PARA_GENE, ");
        //query.append(" PROD.COD_SAP,SPOS.VAL_CODI_VENT_FICT, ");
        query.append(" CONC.DIRI_OID_DIRI, ");
        //query.append(" SPOS.NUM_UNID_DEMA, ");
        query.append(" CLIE.VAL_NOM1||' '||CLIE.VAL_NOM2 NOMBRE_CLIENTE, ");
        query.append(" CLIE.VAL_APE1||' '||CLIE.VAL_APE2 APELLIDO_CLIENTE, ");
        query.append(" CLIE.COD_CLIE, ");
        query.append(" TERR.COD_TERR, PEC_DSD.COD_PERI PERIODO_DESDE, ");
        query.append(" PEC_HST.COD_PERI PERIODO_HASTA, ");
        query.append(" MEN.COD_MENS, SCAB.PERD_OID_PERI, ");
        query.append(" PER_SOL.MARC_OID_MARC, PER_SOL.CANA_OID_CANA, ");
        query.append(" SUB.ACCE_OID_ACCE, ");
        //query.append(" PROD.OID_PROD, ");        
        query.append(" OBT.IND_COMU_OBTE, SCAB.SBAC_OID_SBAC ");
        query.append(" FROM INC_BOLSA_FALTA BOLF, ");
        query.append(" PED_SOLIC_POSIC SPOS, ");
        query.append(" PED_SOLIC_CABEC SCAB, ");
        //query.append(" MAE_PRODU PROD, ");
        query.append(" INC_CONCU_PARAM_GENER CONC, ");
        query.append(" ZON_ZONA ZON, ");
        query.append(" MAE_CLIEN CLIE, ");
        query.append(" ZON_TERRI TERR, ");
        query.append(" CRA_PERIO PER_DSD, ");
        query.append(" SEG_PERIO_CORPO PEC_DSD, ");
        query.append(" CRA_PERIO PER_HST, ");
        query.append(" SEG_PERIO_CORPO PEC_HST, ");
        query.append(" CRA_PERIO PER_SOL, ");
        query.append(" SEG_SUBAC SUB, ");
        query.append(" INC_OBTEN_PUNTO OBT, ");
        //inc 20724 jrivas 27/8/2005
        //query.append(" BEL_STOCK STO, ");
        query.append(" MSG_MENSA MEN ");
        query.append(" WHERE BOLF.SOPO_OID_SOLI_POSI = SPOS.OID_SOLI_POSI ");
        query.append(" AND SPOS.SOCA_OID_SOLI_CABE = SCAB.OID_SOLI_CABE ");
        //inc 20724 jrivas 27/8/2005
        
        //query.append(" AND SPOS.PROD_OID_PROD = STO.PROD_OID_PROD ");
        //query.append(" AND STO.ALMC_OID_ALMA = SCAB.ALMC_OID_ALMA ");
        //query.append(" AND STO.ESME_OID_ESTA_MERC = " +
        //ConstantesBEL.OID_ESTADO_LIBRE_DISPOSICION);        
        //query.append(" AND STO.VAL_SALD >= SPOS.NUM_UNID_DEMA ");
        //query.append(" AND SPOS.PROD_OID_PROD = PROD.OID_PROD ");
        
        query.append(" AND SCAB.COPA_OID_PARA_GENE = CONC.OID_PARA_GRAL ");
        query.append(" AND SCAB.ZZON_OID_ZONA = ZON.OID_ZONA ");
        query.append(" AND SCAB.CLIE_OID_CLIE = CLIE.OID_CLIE ");
        query.append(" AND SCAB.TERR_OID_TERR = TERR.OID_TERR ");
        query.append(" AND CONC.PERD_OID_PERI_DESD = PER_DSD.OID_PERI ");
        query.append(" AND CONC.PERD_OID_PERI_HAST = PER_HST.OID_PERI ");
        query.append(" AND PER_DSD.PERI_OID_PERI = PEC_DSD.OID_PERI ");
        query.append(" AND PER_HST.PERI_OID_PERI = PEC_HST.OID_PERI ");
        query.append(" AND SCAB.PERD_OID_PERI = PER_SOL.OID_PERI ");
        query.append(" AND SCAB.SBAC_OID_SBAC = SUB.OID_SBAC ");
        query.append(" AND CONC.OID_PARA_GRAL = OBT.COPA_OID_PARA_GRAL (+) "); // JVM sicc 20070335, se agrega (+)
        query.append(" AND OBT.MENS_OID_MENS = MEN.OID_MENS (+) ");
        query.append(" AND BOLF.FEC_SOLU IS NULL ");
        query.append(" AND NOT EXISTS (SELECT 1 ");
        query.append(" FROM INC_ARTIC_PREMI_ALTER PRAL ");
        query.append(" WHERE PRAL.BOFA_OID_BOLS_FALT = BOLF.OID_BOLS_FALT) ");        
        
        if (dtosus.getOidPais() != null) {
            query.append(" AND SCAB.PAIS_OID_PAIS = " + dtosus.getOidPais());
        }
        if (dtosus.getOidConcurso() != null) {
            query.append(" AND SCAB.COPA_OID_PARA_GENE = " +
                dtosus.getOidConcurso());
        }
        if ((dtosus.getOidCliente() != null) &&
                (dtosus.getTipoCambio().equals(ConstantesINC
                    .TIPO_CAMBIO_PREMIADO_A_PREMIADO))) {
            query.append(" AND SCAB.CLIE_OID_CLIE = " +
                dtosus.getOidCliente());
        }
        if (dtosus.getNumeroPremioFaltante() != null) {
            query.append(" AND SCAB.NUM_PREM = " +
                dtosus.getNumeroPremioFaltante());
        }
        if (dtosus.getOidRegion() != null) {
            query.append(" AND ZON.ZORG_OID_REGI = " + dtosus.getOidRegion());
        }
        if (dtosus.getOidZona() != null) {
            query.append(" AND ZON.OID_ZONA = " + dtosus.getOidZona());
        }
        if ((dtosus.getOidSolicitud() != null) &&
                (dtosus.getTipoCambio().equals(ConstantesINC
                    .TIPO_CAMBIO_SIN_PREMIO))) {
            query.append(" AND SCAB.OID_SOLI_CABE = " +
                dtosus.getOidSolicitud());
        }

        query.append(" ORDER BY SCAB.CLIE_OID_CLIE, SCAB.OID_SOLI_CABE");

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
            UtilidadesLog.debug("*rs: " + rs);
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (rs.esVacio()) {
            UtilidadesLog.info("DAOFaltantes.obtenerFaltantesSustitucion("
                +"DTOPremioSustitutivo dtosus):Salida");
            return faltantes;
        }
        else {
            try {
                MONPeriodosHome monPeriodosHome = 
                CRAEjbLocators.getMONPeriodosHome();
                MONPeriodos monPeriodos = monPeriodosHome.create();
                Faltante faltante;

                for (int fila = 0; rs.existeFila(fila); fila++) {
                    faltante = new Faltante();
                    //Inc 20648
                    faltante.setOidSolicitud(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_SOLI_CABE"))
                                .longValue()));
                    faltante.setOidPais(dtosus.getOidPais());
                    faltante.setOidBolsaFaltantes(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_BOLS_FALT"))
                                .longValue()));
                    faltante.setOidCliente(dtosus.getOidCliente());
                    faltante.setOidMarca(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "MARC_OID_MARC"))
                                .longValue()));
                    faltante.setOidCanal(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "CANA_OID_CANA"))
                                .longValue()));
                    //Inc 18970 
                    
                    /*faltante.setOidProducto(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_PROD"))
                                .longValue()));*/
                    
                    if (rs.getValueAt(fila, "SBAC_OID_SBAC") != null) {
                        faltante.setOidSubacceso(new Long(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "SBAC_OID_SBAC")).longValue()));
                    }
                    if (rs.getValueAt(fila, "ACCE_OID_ACCE") != null) {
                        faltante.setOidAcceso(new Long(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "ACCE_OID_ACCE")).longValue()));
                    }
                    faltante.setOidZona(dtosus.getOidZona());
                    faltante.setCodigoZona(((String) rs.getValueAt(fila,
                            "COD_ZONA")));
                    faltante.setOidPeriodo(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "PERD_OID_PERI"))
                                .longValue()));
                    if (rs.getValueAt(fila, "COPA_OID_PARA_GENE") != null) {
                        faltante.setOidConcurso(new Long(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "COPA_OID_PARA_GENE")).longValue()));
                    }
                    
                    /*faltante.setCodigoProducto((String) rs.getValueAt(fila,
                            "COD_SAP"));*/
                    
                    /*if (rs.getValueAt(fila, "VAL_CODI_VENT_FICT") != null) {
                        faltante.setCodigoVentaFicticio(((BigDecimal) 
                            rs.getValueAt(fila, "VAL_CODI_VENT_FICT"))
                                .toString());
                    }*/
                    
                    faltante.setDirigidoA(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "DIRI_OID_DIRI"))
                                .longValue()));
                    
                    /*if (rs.getValueAt(fila, "NUM_UNID_DEMA") != null) {
                        faltante.setUnidadesDemandadas(new Double(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "NUM_UNID_DEMA")).doubleValue()));
                    }*/
                    
                    if (rs.getValueAt(fila, "NOMBRE_CLIENTE") != null) {
                        faltante.setNombreCliente((String) rs.getValueAt(fila,
                                "NOMBRE_CLIENTE"));
                    }
                    if (rs.getValueAt(fila, "APELLIDO_CLIENTE") != null) {
                        faltante.setApellidoCliente((String) rs.getValueAt(
                                fila, "APELLIDO_CLIENTE"));
                    }
                    faltante.setCuentaCliente((String) rs.getValueAt(fila,
                            "COD_CLIE"));

                    if (rs.getValueAt(fila, "COD_TERR") != null) {
                        faltante.setCodigoTerritorio(new Long((rs.getValueAt(fila, "COD_TERR")).toString()));
                    }

                    faltante.setCodigoPeriodoInicioConcurso((String) 
                        rs.getValueAt(fila, "PERIODO_DESDE"));
                    faltante.setCodigoPeriodoFinConcurso((String) 
                        rs.getValueAt(fila, "PERIODO_HASTA"));
                    if (rs.getValueAt(fila, "COD_MENS") != null) {
                        faltante.setCodigoMensaje((String) rs.getValueAt(fila,
                                "COD_MENS"));
                    }
                    if (rs.getValueAt(fila, "IND_COMU_OBTE") != null) {
                        if (((BigDecimal) rs.getValueAt(fila, "IND_COMU_OBTE"))
                            .intValue() > 0) {
                            faltante.setIndEnvioMensaje(Boolean.TRUE);
                        } else {
                            faltante.setIndEnvioMensaje(Boolean.FALSE);
                        }
                    }
                    dtoPer = monPeriodos.obtienePeriodoActual(
                        dtosus.getOidPais(),faltante.getOidMarca(), 
                            faltante.getOidCanal());
                    faltante.setCodigoPeriodoDespacho(dtoPer
                        .getCodigoPeriodo());
                    UtilidadesLog.debug("OID Faltante: " +
                        faltante.getOidBolsaFaltantes());
                    faltantes.add(faltante);
                }

                UtilidadesLog.info("DAOFaltantes.obtenerFaltantesSustitucion("
                    +"DTOPremioSustitutivo dtosus):Salida");
                return faltantes;
            }
            catch (CreateException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            catch (RemoteException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            catch (MareException me) {
                UtilidadesLog.error("ERROR ", me);
                throw me;
            }
            catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e);
            }
        }
    }

    /**
    * Fecha de Creacion: 26/04/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo actualiza las entidades relacionadas con los 
    * faltantes.
    * Este metodo utiliza las entidades BolsaFaltantes y 
    * ArticulosPremioAlternativo, por favor recordar colocar las EJB Local 
    * references a estas entidades en el MON desde donde se llame a este metodo
    * Modificado: Carlos Leal  21/06/2005
    */
public void actualizarEntidadesFaltantes(Faltante faltante) 
        throws MareException {
        UtilidadesLog.info("DAOFaltantes.actualizarEntidadesFaltantes(Faltante"
            +"faltante):Entrada");

        BelcorpService bs = null;
        StringBuffer query = new StringBuffer();
        query.append(" UPDATE INC_BOLSA_FALTA  ");
        query.append(" SET FEC_SOLU = SYSDATE, VAL_OBSE = ''  ");
        query.append(" WHERE OID_BOLS_FALT = " + faltante.getOidBolsaFaltantes());

        try {
            bs = BelcorpService.getInstance();
            bs.dbService.executeUpdate(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e);
        }

               
        Integer cantidad = new Integer(faltante.getUnidadesDemandadas()
                                               .intValue());
        //Long faltantes = bolsaFantantes.getOid();
        //Inc 18970
        Long codigoProducto = faltante.getOidProducto();
        
        //Inc 19888
        /*Integer nroPremio = new Integer(obtenerSiguienteNumeroPremio(
                    faltante.getOidConcurso()).intValue());*/
                    
        //DBLG50000899
        Integer nroPremio;
        if (faltante.getNumeroPremio() != null) {
            nroPremio = new Integer(faltante.getNumeroPremio().intValue());
        } else {
            nroPremio = new Integer(0);
        }

        /*UtilidadesLog.debug("nroPremio: " + nroPremio + " cantidad: " +
            cantidad + " faltantes: " + faltantes + " codigoProducto: " +
            codigoProducto);

        ArticulosPremioAlternativoLocal articulosPremioAlternativo = 
            articulosPremioAlternativoLocalHome.create(nroPremio,
                cantidad, faltantes, codigoProducto);*/
                
        StringBuffer query2 = new StringBuffer();
        query2.append(" INSERT INTO INC_ARTIC_PREMI_ALTER (  ");
        query2.append(" OID_ARTI_PREM_ALTE, VAL_PREM_ALTE, VAL_CANT, BOFA_OID_BOLS_FALT, PROD_OID_PROD )   ");
        query2.append(" VALUES (INC_ARPA_SEQ.nextval, " + nroPremio + ", " + cantidad + ", " +  faltante.getOidBolsaFaltantes() + ", " + codigoProducto + ")");

        try {
            bs = BelcorpService.getInstance();
            bs.dbService.executeUpdate(query2.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            UtilidadesLog.error("Error: ",  e);
            throw new MareException(e);
        }
               
        UtilidadesLog.info("DAOFaltantes.actualizarEntidadesFaltantes(Faltante"
            +"faltante):Salida");
    }

    /**
    * Fecha de Creacion: 26/04/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo retorna el proximo numero de premio disponible.
    *
    */
    public Long obtenerSiguienteNumeroPremio(Long oidConcurso)
        throws MareException {
        UtilidadesLog.info("DAOFaltantes.obtenerSiguienteNumeroPremio(Long"
            +"oidConcurso):Entrada");

        try {
            DTOOID dtoOID = new DTOOID();
            DAOConcurso daoConcurso = new DAOConcurso();
            RecordSet rs = new RecordSet();

            dtoOID.setOid(oidConcurso);
            rs = daoConcurso.obtenerMaximoNumeroPremio(dtoOID);
            Long sigNum = new Long(((BigDecimal) rs.getValueAt(0, 0))
                .longValue() + 1);

            UtilidadesLog.info("DAOFaltantes.obtenerSiguienteNumeroPremio(Long"
                +"oidConcurso):Salida");
            return sigNum;
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw new MareException(me);
        }
    }

    /**
    * Fecha de Creacion: 26/04/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo actualiza las entidades relacionadas con los 
    * faltantes y participa en la asignacion de productos sustitutivos.
    * Este metodo utiliza las entidades BolsaFaltantes y 
    * ArticulosPremioAlternativo, por favor recordar colocar las EJB Local 
    * references a estas entidades en el MON desde donde se llame a este metodo
    */
    public void actualizarEntidadesFaltantes(Faltante faltante,
        DTOPremioSustitutivo dtosus) throws MareException {
        UtilidadesLog.info("DAOFaltantes.actualizarEntidadesFaltantes(Faltante"
            +"faltante, DTOPremioSustitutivo dtosus):Entrada");

        try {
            BolsaFantantesLocalHome bolsaFaltantesLocalHome = this.getBolsaFaltantesLocalHome();
            BolsaFantantesLocal bolsaFaltantes = bolsaFaltantesLocalHome.findByPrimaryKey(faltante.getOidBolsaFaltantes());
            bolsaFaltantes.setFechaSolucion(new java.sql.Timestamp(System.currentTimeMillis()));
            bolsaFaltantes.setValObser(dtosus.getObservacionesCambio());
            bolsaFaltantesLocalHome.merge(bolsaFaltantes);
            UtilidadesLog.debug("***1.-");

            Long sigNum;
            ArticulosPremioAlternativoLocalHome articulosPremioAlternativoLocalHome = this.getArticulosPremioAlternativoLocalHome();

            /*  ArticulosPremioAlternativoLocal articulosPremioAlternativo =
             * articulosPremioAlternativoLocalHome.create(new Integer
             * (sigNum.intValue()),
             */

            //Cleal 22/08/2005 
            int size = dtosus.getProductosSustitutivos().size();

            for (int i = 0; i < size; i++) {
                sigNum = obtenerSiguienteNumeroPremio(dtosus.getOidConcurso());
                DTOProductoSustitutivo dtoProdSus = (DTOProductoSustitutivo) 
                    dtosus.getProductosSustitutivos().get(i);
                UtilidadesLog.debug("OID BolsaFalt" + bolsaFaltantes.getOid());
                UtilidadesLog.debug("OID Prod Sust: " +dtoProdSus
                    .getOidProducto());
                UtilidadesLog.debug("Cantidad: " + dtoProdSus.getCantidad());
                UtilidadesLog.debug("sigNum: " + sigNum.intValue());

                articulosPremioAlternativoLocalHome.create(new Integer(
                            sigNum.intValue()),
                        new Integer(dtoProdSus.getCantidad().intValue()),
                        bolsaFaltantes.getOid(), dtoProdSus.getOidProducto());
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e);
        }

        UtilidadesLog.info("DAOFaltantes.actualizarEntidadesFaltantes(Faltante"
            +"faltante, DTOPremioSustitutivo dtosus):Salida");
    }

    /**
    * Fecha de Creacion: 03/05/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo obtiene las posiciones faltantes y sus datos 
    * asociados para permitir la generacion de las solicitudes para aquellas 
    * posiciones cuyos productos cuenten con stock.
    *  
    * Modificado: Carlos Leal 21/06/2005
    * Modificado: Cristian Valenzuela 9/10/2006 (BELC300024279)
    */   
    
    public ArrayList obtenerFaltantesSolicitud(
        DTOSolicitudValidacion dtoSolicitud) throws MareException {
        UtilidadesLog.info("DAOFaltantes.obtenerFaltantesSolicitud(DTOSolicitu"
            +"dValidacion dtoSolicitud):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        DTOPeriodo dtoPer = new DTOPeriodo();
        String codigoError;
        ArrayList faltantes = new ArrayList();

        query.append(" SELECT BOLF.OID_BOLS_FALT, ZON.OID_ZONA, ZON.COD_ZONA,");
        query.append(" SCAB.COPA_OID_PARA_GENE, ");
        query.append(" PROD.COD_SAP,SPOS.VAL_CODI_VENT_FICT, ");
        query.append(" CONC.DIRI_OID_DIRI, ");
        query.append(" SPOS.NUM_UNID_DEMA, ");
        query.append(" CLIE.VAL_NOM1||' '||CLIE.VAL_NOM2 NOMBRE_CLIENTE, ");
        query.append( " CLIE.VAL_APE1||' '||CLIE.VAL_APE2 APELLIDO_CLIENTE, ");
        query.append(" CLIE.COD_CLIE, ");
        query.append(" TERR.COD_TERR, PEC_DSD.COD_PERI PERIODO_DESDE, ");
        query.append(" PEC_HST.COD_PERI PERIODO_HASTA, ");
        query.append(" OBT.VAL_MENS_VALI, SPOS.PROD_OID_PROD,  PROD.COD_SAP, "); 
        query.append(" OBT.VAL_COMU_VALI, PROD.OID_PROD, ");
        query.append(" SCAB.SBAC_OID_SBAC, SCAB.NUM_PREM");
        
        //Agregado por BELC300024279
        query.append(", BOLF.NUM_UNID_FALT ");
        //Fin - Agregado por BELC300024279        
        
        //jrivas SiCC 20070242  28/5/07
        query.append(", CONC.VAL_NOMB "); 
        
        // jrivas -- 06/06/2007 -- SICC20070290
        query.append(", CONC.NUM_CONC "); 
        
        query.append(" FROM INC_BOLSA_FALTA BOLF, ");
        query.append(" PED_SOLIC_POSIC SPOS, ");
        query.append(" PED_SOLIC_CABEC SCAB, ");
        query.append(" BEL_STOCK STO, ");
        query.append(" MAE_PRODU PROD, ");
        query.append(" INC_CONCU_PARAM_GENER CONC, ");
        query.append(" ZON_ZONA ZON, ");
        query.append(" MAE_CLIEN CLIE, ");
        query.append(" ZON_TERRI TERR, ");
        query.append(" CRA_PERIO PER_DSD, ");
        query.append(" SEG_PERIO_CORPO PEC_DSD, ");
        query.append(" CRA_PERIO PER_HST, ");
        query.append(" SEG_PERIO_CORPO PEC_HST, ");
        query.append(" CRA_PERIO PER_SOL, ");
        query.append(" INC_PRODU OBT, ");
        query.append(" bel_estad_merca em ");
        
        query.append(" WHERE BOLF.SOPO_OID_SOLI_POSI = SPOS.OID_SOLI_POSI ");
        query.append(" AND SPOS.SOCA_OID_SOLI_CABE = SCAB.OID_SOLI_CABE ");
        query.append(" AND SPOS.PROD_OID_PROD = STO.PROD_OID_PROD ");
        
        //query.append(" AND STO.ALMC_OID_ALMA = PQ_PLANI.INC_OBTIE_ALMAC_ZONA(ZON.OID_ZONA) ");
        query.append(" AND STO.ALMC_OID_ALMA = nvl((SELECT DISTINCT a1.oid_alma ");
        query.append("     FROM bel_almac a1, app_confi_centr_distr b1, ");
        query.append("          ape_confi_liafp_cabec c1, ape_confi_liafp_detal d1 ");
        query.append("    WHERE a1.ccdi_oid_confi_centr_distr = b1.oid_conf_cent_dist ");
        query.append("      AND b1.oid_conf_cent_dist = c1.ccdi_oid_conf_cent_dist ");
        query.append("      AND c1.oid_conf_lafp_cabe = d1.liac_oid_conf_lafp_cabe ");
        query.append("      AND d1.zzon_oid_zona = ZON.OID_ZONA),2001) ");
        
        query.append(" AND SPOS.PROD_OID_PROD = PROD.OID_PROD ");
        query.append(" AND SCAB.COPA_OID_PARA_GENE = CONC.OID_PARA_GRAL ");
        query.append(" AND SCAB.ZZON_OID_ZONA = ZON.OID_ZONA ");
        query.append(" AND SCAB.CLIE_OID_CLIE = CLIE.OID_CLIE ");
        query.append(" AND SCAB.TERR_OID_TERR = TERR.OID_TERR ");
        query.append(" AND CONC.PERD_OID_PERI_DESD = PER_DSD.OID_PERI ");
        query.append(" AND CONC.PERD_OID_PERI_HAST = PER_HST.OID_PERI ");
        query.append(" AND PER_DSD.PERI_OID_PERI = PEC_DSD.OID_PERI ");
        query.append(" AND PER_HST.PERI_OID_PERI = PEC_HST.OID_PERI ");
        query.append(" AND SCAB.PERD_OID_PERI = PER_SOL.OID_PERI ");
        query.append(" AND CONC.OID_PARA_GRAL = OBT.COPA_OID_PARA_GRAL (+) ");  // JVM sicc 20070335, se agrega (+)
        query.append(" AND BOLF.FEC_SOLU IS NULL ");
        query.append(" AND NOT EXISTS (SELECT 1 ");
        query.append(" FROM INC_ARTIC_PREMI_ALTER PRAL ");
        query.append(" WHERE PRAL.BOFA_OID_BOLS_FALT = BOLF.OID_BOLS_FALT) ");
        
        //jrivas 3/11/2006 El oid de LD puede cambiar.
        /*query.append(" AND STO.ESME_OID_ESTA_MERC = " +
            ConstantesBEL.OID_ESTADO_LIBRE_DISPOSICION);*/
        query.append(" AND em.COD_ESTA = '" + ConstantesBEL.CODIGO_ESTADO_LIBRE_DISPOSICION + "'");
        query.append(" AND em.PAIS_OID_PAIS = " + dtoSolicitud.getOidPais());
        query.append(" AND em.OID_ESTA_MERC = sto.esme_oid_esta_merc ");        
        
        //Eliminado por BELC300024279  
        //query.append(" AND STO.VAL_SALD >= SPOS.NUM_UNID_DEMA ");
        //Agregado por BELC300024279
        query.append(" AND STO.VAL_SALD >= BOLF.NUM_UNID_FALT ");
        //Fin - Agregado por BELC300024279
        
        query.append(" AND SCAB.PAIS_OID_PAIS = " + dtoSolicitud.getOidPais());
        query.append(" AND PER_SOL.MARC_OID_MARC = " + dtoSolicitud.getOidMarca());
        query.append(" AND PER_SOL.CANA_OID_CANA = " + dtoSolicitud.getOidCanal());
        //Agregado para PED-27 (la bolsa de faltantes debe filtrarse para el cliente
        query.append(" AND clie.OID_CLIE  = " + dtoSolicitud.getOidCliente().toString());

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug(" rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (!rs.esVacio()) {
            try {
                MONPeriodosHome monPeriodosHome = CRAEjbLocators.getMONPeriodosHome();
                MONPeriodos monPeriodos = monPeriodosHome.create();
                Faltante faltante;
                dtoPer = monPeriodos.obtienePeriodoActual(
                    dtoSolicitud.getOidPais(),dtoSolicitud.getOidMarca(), 
                        dtoSolicitud.getOidCanal());

                for (int fila = 0; rs.existeFila(fila); fila++) {
                    faltante = new Faltante();
                    faltante.setOidSolicitud(dtoSolicitud.getOidSolicitud());
                    faltante.setOidPais(dtoSolicitud.getOidPais());
                    faltante.setOidBolsaFaltantes(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_BOLS_FALT"))
                                .longValue()));
                    faltante.setOidCliente(dtoSolicitud.getOidCliente());
                    faltante.setOidMarca(dtoSolicitud.getOidMarca());
                    faltante.setOidCanal(dtoSolicitud.getOidCanal());
                    faltante.setOidAcceso(dtoSolicitud.getOidAcceso());
                    faltante.setOidZona(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_ZONA"))
                                .longValue()));
                    faltante.setCodigoZona(((String) rs.getValueAt(fila,
                            "COD_ZONA")));
                    faltante.setOidPeriodo(dtoSolicitud.getOidPeriodo());
                    //ver DT
                    faltante.setOidSubacceso(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "SBAC_OID_SBAC"))
                                .longValue()));
                    if (rs.getValueAt(fila, "COPA_OID_PARA_GENE") != null) {
                        faltante.setOidConcurso(new Long(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "COPA_OID_PARA_GENE")).longValue()));
                    }
                    faltante.setOidProducto(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_PROD"))
                                .longValue())); //Inc 18970
                    faltante.setCodigoProducto((String) rs.getValueAt(fila,
                            "COD_SAP"));
                    if (rs.getValueAt(fila, "VAL_CODI_VENT_FICT") != null) {
                        faltante.setCodigoVentaFicticio(((BigDecimal)
                            rs.getValueAt(fila, "VAL_CODI_VENT_FICT"))
                                .toString());
                    }
                    faltante.setDirigidoA(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "DIRI_OID_DIRI"))
                            .longValue()));
                    
                    //Modificado BELC300024279
                    /*if (rs.getValueAt(fila, "NUM_UNID_DEMA") != null) {
                        faltante.setUnidadesDemandadas(new Double(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "NUM_UNID_DEMA")).doubleValue()));
                    }*/
                    if (rs.getValueAt(fila, "NUM_UNID_FALT") != null) {
                        faltante.setUnidadesDemandadas(new Double(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "NUM_UNID_FALT")).doubleValue()));
                    }                    
                    //Fin - Modificado BELC300024279
                    
                    //jrivas SiCC 20070242  28/5/07                        
                    faltante.setNombreConcurso((String)rs.getValueAt(fila, "VAL_NOMB"));
                    
                    //jrivas DBLG5000899 3/7/2006
                    DTOPrecioReclamo dtoPR = new DTOPrecioReclamo();
                    dtoPR.setOidConcurso(faltante.getOidConcurso());
                    dtoPR.setCodigoVenta(faltante.getCodigoVentaFicticio());
                    DAOSoporteExterno daoSE = new DAOSoporteExterno();
                    faltante.setPrecioPublico(daoSE.obtenerPrecioReclamo(dtoPR).getPrecioPublico());
                    
                    if (rs.getValueAt(fila, "NUM_PREM") != null) {
                        faltante.setNumeroPremio(new Long(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "NUM_PREM")).longValue()));
                    }
                    
                    if (rs.getValueAt(fila, "NOMBRE_CLIENTE") != null) {
                        faltante.setNombreCliente((String) rs.getValueAt(fila,
                                "NOMBRE_CLIENTE"));
                    }
                    if (rs.getValueAt(fila, "APELLIDO_CLIENTE") != null) {
                        faltante.setApellidoCliente((String) rs.getValueAt(
                                fila, "APELLIDO_CLIENTE"));
                    }
                    faltante.setCuentaCliente((String) rs.getValueAt(fila,
                            "COD_CLIE"));
                    
                    if (rs.getValueAt(fila, "COD_TERR") != null) {
                        faltante.setCodigoTerritorio(new Long((rs.getValueAt(fila, "COD_TERR")).toString()));
                    }
                    
                    faltante.setCodigoPeriodoInicioConcurso((String) 
                        rs.getValueAt(fila, "PERIODO_DESDE"));
                    faltante.setCodigoPeriodoFinConcurso((String) 
                        rs.getValueAt(fila, "PERIODO_HASTA"));

                    if (rs.getValueAt(fila, "VAL_MENS_VALI") != null) {
                        faltante.setCodigoMensaje((String) 
                            rs.getValueAt(fila, "VAL_MENS_VALI"));
                    }

                    faltante.setCodigoPeriodoDespacho(dtoPer
                        .getCodigoPeriodo());
                    if (rs.getValueAt(fila, "VAL_COMU_VALI") != null) {
                        if (((BigDecimal) rs.getValueAt(fila, "VAL_COMU_VALI"))
                            .intValue() > 0) {
                            faltante.setIndEnvioMensaje(Boolean.TRUE);
                        } else {
                            faltante.setIndEnvioMensaje(Boolean.FALSE);
                        }
                    }
                    
                    // jrivas -- 06/06/2007 -- SICC20070290
                    faltante.setNumeroConcurso(((String) rs.getValueAt(fila, "NUM_CONC")));
                    
                    faltantes.add(faltante);
                }
            } catch (CreateException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } catch (RemoteException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (MareException me) {
                UtilidadesLog.error("ERROR ", me);
                throw me;
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e);
            }
        }

        UtilidadesLog.info("DAOFaltantes.obtenerFaltantesSolicitud(DTOSolic"
            +"itudValidacion dtoSolicitud):Salida");

        return faltantes;
    }

    /**
    * Fecha de Creacion: 04/05/2005
    * Autor: Damasia Maneiro
    * Comnetario: este metodo obtiene las posiciones faltantes y sus datos 
    * asociados para  permitir la generacion de las solicitudes para aquellas
    *  posiciones cuyos productos
    * cuenten con stock.
    * Modificado: Carlos Leal 21/06/2005
    * Modificado: Cristian Valenzuela 9/10/2006 (BELC300024279)
    * Modificado: Sergio Apaza 18/02/2010 (RCR Demora en Cierre de Zonas)
    */
    public ArrayList obtenerFaltantesCierre(DTOFACProcesoCierre dtoEntrada)
        throws MareException {
        UtilidadesLog.info("DAOFaltantes.obtenerFaltantesCierre(DTOFACProceso"
            +"Cierre dtoEntrada):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;
        DTOPeriodo dtoPer = new DTOPeriodo();
        String codigoError;
        ArrayList faltantes = new ArrayList();

        query.append(" SELECT  OID_BOLS_FALT, ");
        query.append(" OID_ZONA, ");
        query.append(" COD_ZONA, ");
        query.append(" COPA_OID_PARA_GENE, ");
        query.append(" COD_SAP, ");
        query.append(" VAL_CODI_VENT_FICT, ");
        query.append(" DIRI_OID_DIRI, ");
        query.append(" NUM_UNID_DEMA, ");
        query.append(" NOMBRE_CLIENTE, ");
        query.append(" APELLIDO_CLIENTE, ");
        query.append(" COD_CLIE, ");
        query.append(" COD_TERR, ");
        query.append(" PERIODO_DESDE, ");
        query.append(" PERIODO_HASTA, ");
        query.append(" VAL_MENS_VALI, ");
        query.append(" PROD_OID_PROD, ");
        query.append(" VAL_COMU_VALI, ");
        query.append(" OID_SOLI_CABE, ");
        query.append(" CLIE_OID_CLIE, ");
        query.append(" ACCE_OID_ACCE, ");
        query.append(" OID_PROD, ");
        query.append(" OID_SBAC, ");
        query.append(" NUM_PREM, ");
        query.append(" NUM_CONC, ");
        query.append(" NUM_UNID_FALT, ");
        query.append(" VAL_NOMB ");
        query.append(" FROM ( ");

        query.append(" SELECT BOLF.OID_BOLS_FALT, ZON.OID_ZONA, ");
        query.append(" ZON.COD_ZONA, SCAB.COPA_OID_PARA_GENE,  ");
        query.append(" PROD.COD_SAP,SPOS.VAL_CODI_VENT_FICT, ");
        query.append(" CONC.DIRI_OID_DIRI, ");
        query.append(" SPOS.NUM_UNID_DEMA,  ");
        query.append(" CLIE.VAL_NOM1||' '||CLIE.VAL_NOM2 NOMBRE_CLIENTE, ");
        query.append(" CLIE.VAL_APE1||' '||CLIE.VAL_APE2 APELLIDO_CLIENTE, ");
        query.append(" CLIE.COD_CLIE, ");
        query.append(" TERR.COD_TERR, PEC_DSD.COD_PERI PERIODO_DESDE, ");
        query.append(" PEC_HST.COD_PERI PERIODO_HASTA, ");
        // vbongiov -- 13/07/2006 -- inc DBLG500000901
        query.append(" INC_PRODU.VAL_MENS_VALI, SPOS.PROD_OID_PROD, ");
        query.append(" INC_PRODU.VAL_COMU_VALI, ");
        query.append(" SCAB.OID_SOLI_CABE, SCAB.CLIE_OID_CLIE, ");
        query.append(" SUB.ACCE_OID_ACCE, PROD.OID_PROD, SUB.OID_SBAC, NUM_PREM, CONC.NUM_CONC ");
        
        //Agregado por BELC300024279
        query.append(" , BOLF.NUM_UNID_FALT ");
        //Fin - Agregado por BELC300024279        
        
        //jrivas SiCC 20070242  28/5/07
        query.append(", CONC.VAL_NOMB, "); 
        
        query.append(" (SELECT COUNT(1) FROM INC_ARTIC_PREMI_ALTER PRAL "); 
        query.append("  WHERE PRAL.BOFA_OID_BOLS_FALT = BOLF.OID_BOLS_FALT) TOT_ARTI "); 

        query.append(" FROM INC_BOLSA_FALTA BOLF, ");
        query.append(" PED_SOLIC_POSIC SPOS, ");
        query.append(" PED_SOLIC_CABEC SCAB, ");
        query.append(" BEL_STOCK STO, ");
        query.append(" MAE_PRODU PROD, ");
        query.append(" INC_CONCU_PARAM_GENER CONC, ");
        query.append(" ZON_ZONA ZON, ");
        query.append(" MAE_CLIEN CLIE, ");
        query.append(" ZON_TERRI TERR, ");
        query.append(" CRA_PERIO PER_DSD, ");
        query.append(" SEG_PERIO_CORPO PEC_DSD, ");
        query.append(" CRA_PERIO PER_HST, ");
        query.append(" SEG_PERIO_CORPO PEC_HST, ");
        query.append(" CRA_PERIO PER_SOL, ");
        query.append(" SEG_SUBAC SUB, ");
        query.append(" INC_PRODU, bel_estad_merca em ");
        
        query.append(" WHERE BOLF.SOPO_OID_SOLI_POSI = SPOS.OID_SOLI_POSI ");
        query.append(" AND SPOS.SOCA_OID_SOLI_CABE = SCAB.OID_SOLI_CABE ");
        query.append(" AND SPOS.PROD_OID_PROD = STO.PROD_OID_PROD ");
        
        //query.append(" AND STO.ALMC_OID_ALMA = SCAB.ALMC_OID_ALMA ");
        //query.append(" AND STO.ALMC_OID_ALMA = PQ_PLANI.INC_OBTIE_ALMAC_ZONA(ZON.OID_ZONA) ");
        
        query.append(" AND STO.ALMC_OID_ALMA  = nvl((SELECT DISTINCT a1.oid_alma ");
        query.append("     FROM bel_almac a1, app_confi_centr_distr b1, ");
        query.append("          ape_confi_liafp_cabec c1, ape_confi_liafp_detal d1 ");
        query.append("    WHERE a1.ccdi_oid_confi_centr_distr = b1.oid_conf_cent_dist ");
        query.append("      AND b1.oid_conf_cent_dist = c1.ccdi_oid_conf_cent_dist ");
        query.append("      AND c1.oid_conf_lafp_cabe = d1.liac_oid_conf_lafp_cabe ");
        query.append("      AND d1.zzon_oid_zona = ZON.OID_ZONA),2001) ");
        
        query.append(" AND SPOS.PROD_OID_PROD = PROD.OID_PROD ");
        query.append(" AND SCAB.COPA_OID_PARA_GENE = CONC.OID_PARA_GRAL ");
        query.append(" AND SCAB.ZZON_OID_ZONA = ZON.OID_ZONA ");
        query.append(" AND SCAB.CLIE_OID_CLIE = CLIE.OID_CLIE ");
        query.append(" AND SCAB.TERR_OID_TERR = TERR.OID_TERR ");
        query.append(" AND CONC.PERD_OID_PERI_DESD = PER_DSD.OID_PERI ");
        query.append(" AND CONC.PERD_OID_PERI_HAST = PER_HST.OID_PERI ");
        query.append(" AND PER_DSD.PERI_OID_PERI = PEC_DSD.OID_PERI ");
        query.append(" AND PER_HST.PERI_OID_PERI = PEC_HST.OID_PERI ");
        query.append(" AND SCAB.PERD_OID_PERI = PER_SOL.OID_PERI ");
        query.append(" AND SCAB.SBAC_OID_SBAC = SUB.OID_SBAC ");
        query.append(" AND CONC.OID_PARA_GRAL = INC_PRODU.COPA_OID_PARA_GRAL (+) "); // JVM sicc 20070335, se agrega (+)
        query.append(" AND BOLF.FEC_SOLU IS NULL ");
        /*query.append(" AND NOT EXISTS (SELECT 1 ");
        query.append(" FROM INC_ARTIC_PREMI_ALTER PRAL ");
        query.append(" WHERE PRAL.BOFA_OID_BOLS_FALT = BOLF.OID_BOLS_FALT) ");*/

        //jrivas 3/11/2006 El oid de LD puede cambiar.
        /*query.append(" AND STO.ESME_OID_ESTA_MERC = " +
            ConstantesBEL.OID_ESTADO_LIBRE_DISPOSICION);*/
        query.append(" AND em.COD_ESTA = '" + ConstantesBEL.CODIGO_ESTADO_LIBRE_DISPOSICION + "'");
        query.append(" AND em.PAIS_OID_PAIS = " + dtoEntrada.getOidPais());
        query.append(" AND em.OID_ESTA_MERC = sto.esme_oid_esta_merc ");
        
        //Modificado por BELC300024279    
        //query.append(" AND STO.VAL_SALD >= SPOS.NUM_UNID_DEMA ");
        query.append(" AND STO.VAL_SALD >= BOLF.NUM_UNID_FALT ");
        //Fin - Modificado por BELC300024279    
        
        query.append(" AND SCAB.PAIS_OID_PAIS = " + dtoEntrada.getOidPais());
        query.append(" AND PER_SOL.MARC_OID_MARC = " + dtoEntrada.getMarca());
        query.append(" AND PER_SOL.CANA_OID_CANA = " + dtoEntrada.getCanal());
        query.append(" AND SCAB.ZZON_OID_ZONA = " + dtoEntrada.getZona());

        query.append(" ) ");
        query.append(" WHERE TOT_ARTI = 0 ");

        try {
            rs = (RecordSet) belcorpService.getInstance().dbService
                .executeStaticQuery(query.toString());
            UtilidadesLog.debug("*** rs: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (!rs.esVacio()) {
            try {
                Faltante faltante;
                //jrivas 8/1/2009 20080821
                /*MONPeriodosHome monPeriodosHome = CRAEjbLocators
                    .getMONPeriodosHome();
                MONPeriodos monPeriodos = monPeriodosHome.create();*/
                /*dtoPer = monPeriodos.obtienePeriodoActual(dtoEntrada
                    .getOidPais(), dtoEntrada.getMarca(), 
                        dtoEntrada.getCanal());*/
                dtoPer = this.obtienePeriodo(dtoEntrada.getPeriodo());

                for (int fila = 0; rs.existeFila(fila); fila++) {
                    faltante = new Faltante();
                    faltante.setOidSolicitud(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_SOLI_CABE"))
                                .longValue()));
                    faltante.setOidPais(dtoEntrada.getOidPais());
                    faltante.setOidBolsaFaltantes(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_BOLS_FALT"))
                                .longValue()));
                    faltante.setOidCliente(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "CLIE_OID_CLIE"))
                                .longValue()));
                    faltante.setOidMarca(dtoEntrada.getMarca());
                    faltante.setOidCanal(dtoEntrada.getCanal());
                    faltante.setOidProducto(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_PROD"))
                                .longValue()));
                    if (rs.getValueAt(fila, "OID_SBAC") != null) {
                        faltante.setOidSubacceso(new Long(
                                ((BigDecimal) rs.getValueAt(fila, "OID_SBAC"))
                                    .longValue()));
                    }
                    if (rs.getValueAt(fila, "ACCE_OID_ACCE") != null) {
                        faltante.setOidAcceso(new Long(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "ACCE_OID_ACCE")).longValue()));
                    }
                    faltante.setOidZona(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "OID_ZONA"))
                                .longValue()));
                    faltante.setCodigoZona(((String) rs.getValueAt(fila,
                            "COD_ZONA")));
                    faltante.setOidPeriodo(dtoPer.getOid());
                    if (rs.getValueAt(fila, "COPA_OID_PARA_GENE") != null) {
                        faltante.setOidConcurso(new Long(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "COPA_OID_PARA_GENE")).longValue()));
                    }
                    faltante.setCodigoProducto((String) rs.getValueAt(fila,
                            "COD_SAP"));
                    if (rs.getValueAt(fila, "VAL_CODI_VENT_FICT") != null) {
                        faltante.setCodigoVentaFicticio(((BigDecimal) 
                            rs.getValueAt(fila, "VAL_CODI_VENT_FICT"))
                                .toString());
                    }
                    faltante.setDirigidoA(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "DIRI_OID_DIRI"))
                                .longValue()));
                    
                    //Modificado por BELC300024279
                    /*if (rs.getValueAt(fila, "NUM_UNID_DEMA") != null) {
                        faltante.setUnidadesDemandadas(new Double(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "NUM_UNID_DEMA")).doubleValue()));
                    }*/
                    
                    if (rs.getValueAt(fila, "NUM_UNID_FALT") != null) {
                        faltante.setUnidadesDemandadas(new Double(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "NUM_UNID_FALT")).doubleValue()));
                    }
                    //Fin - Modificado por BELC300024279
                    
                    //jrivas SiCC 20070242  28/5/07                        
                    faltante.setNombreConcurso((String)rs.getValueAt(fila, "VAL_NOMB"));

                    //jrivas DBLG5000899 3/7/2006
                    DTOPrecioReclamo dtoPR = new DTOPrecioReclamo();
                    dtoPR.setOidConcurso(faltante.getOidConcurso());
                    dtoPR.setCodigoVenta(faltante.getCodigoVentaFicticio());
                    DAOSoporteExterno daoSE = new DAOSoporteExterno();
                    faltante.setPrecioPublico(daoSE.obtenerPrecioReclamo(dtoPR).getPrecioPublico());
                    
                    if (rs.getValueAt(fila, "NUM_PREM") != null) {
                        faltante.setNumeroPremio(new Long(
                                ((BigDecimal) rs.getValueAt(fila,
                                    "NUM_PREM")).longValue()));
                    }
                   
                    if (rs.getValueAt(fila, "NOMBRE_CLIENTE") != null) {
                        faltante.setNombreCliente((String) rs.getValueAt(fila,
                                "NOMBRE_CLIENTE"));
                    }
                    if (rs.getValueAt(fila, "APELLIDO_CLIENTE") != null) {
                        faltante.setApellidoCliente((String) rs.getValueAt(
                                fila, "APELLIDO_CLIENTE"));
                    }
                    faltante.setCuentaCliente((String) rs.getValueAt(fila,
                            "COD_CLIE"));
                    
                    if (rs.getValueAt(fila, "COD_TERR") != null) {
                        faltante.setCodigoTerritorio(new Long((rs.getValueAt(fila, "COD_TERR")).toString()));
                    }
                    
                    faltante.setCodigoPeriodoInicioConcurso((String) 
                        rs.getValueAt(fila, "PERIODO_DESDE"));
                    faltante.setCodigoPeriodoFinConcurso((String) 
                        rs.getValueAt(fila, "PERIODO_HASTA"));
                        
                    // vbongiov -- 13/07/2006 -- inc DBLG500000901
                    if (rs.getValueAt(fila, "VAL_MENS_VALI") != null) {
                        faltante.setCodigoMensaje((String) rs.getValueAt(fila,
                                "VAL_MENS_VALI"));
                    }
                    faltante.setCodigoPeriodoDespacho(dtoPer
                        .getCodigoPeriodo());
                        
                    // vbongiov -- 13/07/2006 -- inc DBLG500000901
                    if (rs.getValueAt(fila, "VAL_COMU_VALI") != null) {
                        if (((BigDecimal) rs.getValueAt(fila, "VAL_COMU_VALI"))
                            .intValue() > 0) {
                            faltante.setIndEnvioMensaje(Boolean.TRUE);
                        } else {
                            faltante.setIndEnvioMensaje(Boolean.FALSE);
                        }
                    }else{//gacevedo 16/11/2006 V-INC-08 (Bloqueante de Validacion)
                        faltante.setIndEnvioMensaje(Boolean.FALSE);
                    }
                    // vbongiov -- 12/07/2006 -- inc DBLG500000920
                    faltante.setNumeroConcurso(((String) rs.getValueAt(fila, "NUM_CONC")));
                        
                    faltantes.add(faltante);
                }
            } catch (MareException me) {
                UtilidadesLog.error("ERROR ", me);
                throw me;
            } catch (Exception e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e);
            }
        }
        UtilidadesLog.info("DAOFaltantes.obtenerFaltantesCierre(DTOFACProces"
            +"oCierre dtoEntrada):Salida");

        return faltantes;
    }

    public RecordSet obtenerSituacionRegistro(DTOBelcorp dtoe)
        throws MareException {
        UtilidadesLog.info("DAOFaltantes.obtenerSituacionRegistro(DTOBelcorp"
            +"dtoe):Entrada");
        /*
        Obtener los campos:
        oid
        descripcion (internacionalizable)
        de la entidad INC:SituacionRegistro
        */
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT ia.oid_situ_regi, ");
        query.append(" i1.val_i18n ");
        query.append(" FROM v_gen_i18n_sicc i1, ");
        query.append(" INC_SITUA_REGIS ia ");
        query.append("  WHERE i1.attr_enti = 'INC_SITUA_REGIS' ");
        query.append(" AND i1.attr_num_atri = 1 ");
        query.append(" AND i1.val_oid = ia.oid_situ_regi ");
        query.append(" AND i1.IDIO_OID_IDIO =  " + dtoe.getOidIdioma());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOFaltantes.obtenerSituacionRegistro(DTOBelcorp"
            +"dtoe):Salida");
        return rs;
    }

    public RecordSet obtenerTipoCambio(DTOBelcorp dtoe)
        throws MareException {
        UtilidadesLog.info("DAOFaltantes.obtenerTipoCambio(DTOBelcorp"
            +"dtoe):Entrada");
        /*
          Obtener los campos:
          oid
          descripcion (internacionalizable)
          de la entidad INC:TipoCambio
        */
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT tc.OID_TIPO_CAMB, ");
        query.append(" i1.val_i18n ");
        query.append(" FROM v_gen_i18n_sicc i1, ");
        query.append(" INC_TIPO_CAMBI tc ");
        query.append(" WHERE i1.attr_enti = 'INC_TIPO_CAMBI' ");
        query.append(" AND i1.attr_num_atri = 1 ");
        query.append(" AND i1.val_oid = tc.OID_TIPO_CAMB ");
        query.append(" AND i1.IDIO_OID_IDIO =  " + dtoe.getOidIdioma());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("*rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOFaltantes.obtenerTipoCambio(DTOBelcorp dtoe)"
            +":Salida");
        return rs;
    }

    /**
    * Fecha de Creacion: 26/05/2005
    * Autor: Carlos Leal
    * Comentario: Toma un string, busca los tokens contenidos en el cuyo 
    * separador es la "," y a cada token lo agrega en un arrayList.   
    */
    private ArrayList parseaString(String cadena) {
        UtilidadesLog.info("DAOFaltantes.parseaString(String cadena):Entrada");

        ArrayList arrList = new ArrayList();
        
        if (cadena != null) {
            StringTokenizer st1 = new StringTokenizer(cadena, ",");
            int cantTokens = st1.countTokens();
            for (int i = 0; i < cantTokens; i++) {
                String token = st1.nextToken();
                arrList.add(token);
            }
        }
        UtilidadesLog.info("DAOFaltantes.parseaString(String cadena):Salida");
        return arrList;
    }
    
    /**
         * Sistema:     Belcorp
         * Modulo:      INC
         * Fecha:       29/08/2006
         * @version     1.0
         * @autor       Cristian Valenzuela
    **/
    public RecordSet obtenerStockProductosSustitutivos(DTOPremioSustitutivo 
        dtoSus, Faltante faltante) throws MareException {
        UtilidadesLog.info("DAOFaltantes.obtenerStockProductosSustitutivos(" +
        "DTOPremioSustitutivo dtoSus, Faltante faltante):Entrada");
        
        ArrayList productosSustitutivos = dtoSus.getProductosSustitutivos();
        int cant = productosSustitutivos.size();
        UtilidadesLog.debug("*** cant " + cant);
        
        Long[] oids = new Long[cant];        
        
        for(int i=0;i<cant; i++) {
            DTOProductoSustitutivo dto = (DTOProductoSustitutivo)productosSustitutivos.get(i);
            oids[i] = dto.getOidProducto();            
        }
        
        //<inicio> incidencia SiCC-20070227, en caso que no haya productos sustitutivos se envia -1
        String oidsFiltro = null;
        if(cant > 0) 
            oidsFiltro = this.generaINClause(oids);
        else  
            oidsFiltro = "IN (-1)";
        //<fin> incidencia SiCC-20070227
        
        UtilidadesLog.debug("********* oidsFiltro:" + oidsFiltro);
        
        Long oidTipoCliente = null;
        
        if(faltante.getDirigidoA().longValue() == 
        ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.longValue()) {
            oidTipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA;
        }
        
        if(faltante.getDirigidoA().longValue() == 
        ConstantesINC.OID_DIRIGIDO_A_GERENTE.longValue()) {
            oidTipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_GERENTE;
        }
        
        UtilidadesLog.debug("********* oidTipoCliente:" + oidTipoCliente);        

        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT PROD.OID_PROD OIDPRODUCTO, STO.VAL_SALD STOCK ");
            query.append(" FROM BEL_STOCK STO,MAE_PRODU PROD, ");
            query.append(" (SELECT TSOP.OID_TIPO_SOLI_PAIS, ");
            query.append(" NVL (TSOP.ALMC_OID_ALMA, ");
            query.append(" (SELECT AA.ALMC_OID_ALMA ");
            query.append(" FROM PED_ASIGN_ALMAC AA ");
            query.append(" WHERE AA.PAIS_OID_PAIS = TSOP.PAIS_OID_PAIS ");
            query.append(" AND AA.MARC_OID_MARC = TSOLI.MARC_OID_MARC ");
            query.append(" AND AA.SBAC_OID_SBAC = TSOLI.SBAC_OID_SBAC) ");
            query.append(" ) OIDALMACEN ");
            query.append(" FROM PED_TIPO_SOLIC_PAIS TSOP, ");
            query.append(" PED_TIPO_SOLIC_PROCE TSPR, ");
            query.append(" PED_TIPO_SOLIC TSOLI, ");
            query.append(" SEG_ACCES ACCE ");
            query.append(" WHERE TSOP.PAIS_OID_PAIS = " + dtoSus.getOidPais());
            query.append(" AND TSPR.TSPA_OID_TIPO_SOLI_PAIS = TSOP.OID_TIPO_SOLI_PAIS ");
            query.append(" AND TSOP.TSOL_OID_TIPO_SOLI = TSOLI.OID_TIPO_SOLI ");
            query.append(" AND TSPR.OPER_OID_OPER = " + ConstantesINC.OPER_SOLIC_BOLSA_FALTANTES);
            query.append(" AND TSOLI.TICL_OID_TIPO_CLIE = " + oidTipoCliente);
            query.append(" AND TSOLI.ACCE_OID_ACCE = ACCE.OID_ACCE ");
            query.append(" AND ACCE.CANA_OID_CANA = " + faltante.getOidCanal());
            query.append(" AND TSOLI.MARC_OID_MARC = " + faltante.getOidMarca());
            query.append(" )ALMA WHERE STO.PROD_OID_PROD " + oidsFiltro);
            query.append(" AND STO.ALMC_OID_ALMA = ALMA.OIDALMACEN ");
            query.append(" AND STO.PROD_OID_PROD = PROD.OID_PROD ");
            query.append(" AND STO.ESME_OID_ESTA_MERC = " + 
            ConstantesBEL.OID_ESTADO_LIBRE_DISPOSICION);

            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.debug("******* rs: " + rs);

        UtilidadesLog.info("DAOFaltantes.obtenerStockProductosSustitutivos(" +
        "DTOPremioSustitutivo dtoSus, Faltante faltante):Entrada");
        return rs;
    }
    
    //Metodo que genera la clausula IN dependiendo un array de Long
    //Devuelve un String, por ejemplo: IN(1834, 1835, 1836)
    private String generaINClause(Long[] oids) throws MareException {
        UtilidadesLog.info("DAOFaltantes.generaINClause(Long[] oids): Entrada");
        StringBuffer sClausula = new StringBuffer("");

        try {
            sClausula.append(" IN ( ");

            for (int i = 0; i < oids.length; i++) {
                Long oid = oids[i];

                if (i != 0) {
                    sClausula.append(", ");
                }

                sClausula.append("" + oid);
            }

            sClausula.append(")");
        }
        catch (Exception ex) {
            //UtilidadesLog.debug(ex);
        }

        UtilidadesLog.info("DAOFaltantes.generaINClause(Long[] oids): Salida");
        return sClausula.toString();
    }
    
    private BolsaFantantesLocalHome getBolsaFaltantesLocalHome() {
            return new BolsaFantantesLocalHome();
    }

    private ArticulosPremioAlternativoLocalHome getArticulosPremioAlternativoLocalHome() {
            return new ArticulosPremioAlternativoLocalHome();
    }
    
    //jrivas 8/1/2009 20080821
    private DTOPeriodo obtienePeriodo(Long oid) throws  MareException {
        UtilidadesLog.info("DAOFaltantes.obtienePeriodo(Long oid):Entrada");
        BelcorpService belcorpService;
        try {
        
            belcorpService = BelcorpService.getInstance();
            
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" SELECT   P.OID_PERI, COD_PERI ");
            stringBuffer.append("     FROM CRA_PERIO P, SEG_PERIO_CORPO PC ");
            stringBuffer.append("    WHERE P.OID_PERI = " + oid );
            stringBuffer.append("      AND P.PERI_OID_PERI = PC.OID_PERI ");
            stringBuffer.append(" ORDER BY FEC_INIC DESC ");

            RecordSet recordSet = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());

            DTOPeriodo dtoPeriodo = new DTOPeriodo();
            if ( ! recordSet.esVacio()) {
                dtoPeriodo.setOid( new Long(((BigDecimal)recordSet.getValueAt(0,"OID_PERI")).longValue()));
                dtoPeriodo.setCodigoPeriodo( (String) recordSet.getValueAt(0,"COD_PERI"));
            }

            UtilidadesLog.info("DAOFaltantes.obtienePeriodo(Long oid):Salida");
            return dtoPeriodo;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }    

    // sapaza -- PER-SiCC-2012-0355 -- 27/04/2012
    public void procesarBolsaFaltantesServicio(DTOFACProcesoCierre dtoe) throws MareException {
        UtilidadesLog.info("DAOFaltantes.procesarBolsaFaltantesServicio(DTOFACProcesoCierre dtoe): Entrada ");
        BelcorpService bs = BelcorpService.getInstance();

        try {
            ArrayList params = new ArrayList();
            params.add(dtoe.getOidPais().toString());
            params.add(dtoe.getMarca().toString());
            params.add(dtoe.getCanal().toString());
            params.add(dtoe.getPeriodo().toString());
            params.add(dtoe.getZona().toString());
            params.add("ADMIN");
            
            bs.dbService.executeProcedure("PQ_PLANI.INC_PR_GENER_SOLIC_BOLSA_FALTA", params);
            
            UtilidadesLog.info("DAOFaltantes.procesarBolsaFaltantesServicio(DTOFACProcesoCierre dtoe): Salida ");
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
}