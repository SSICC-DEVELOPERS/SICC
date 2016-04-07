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
 * @autor: Mariano Rodriguez
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.inc.DTOAmbitRC;
import es.indra.sicc.dtos.inc.DTONivelesRanking;
import es.indra.sicc.dtos.inc.DTORanking;
import es.indra.sicc.dtos.inc.DTORankingNivelesPremios;
import es.indra.sicc.dtos.inc.DTOVentaRankingGerentes;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;
import java.util.Vector;


/**
 *
 * @author Mariano Rodriguez
 * @fecha 20/07/2005
 */
public class DAOMantenimientoRanking {
    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     */
    public DTOSalida obtenerNroConcursosVersionesRankingActivos(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.obtenerNroConcursosVersio"
            +"nesRankingActivos(DTOBelcorp dto):Entrada");

        StringBuffer query = new StringBuffer();

        query.append(" SELECT concu.OID_PARA_GRAL OID, ");
        query.append(" concu.NUM_CONC ||'-'|| concu.NUM_VERS ");
        query.append(" FROM INC_CONCU_PARAM_GENER concu, INC_PARAM_RANKI rak ");
        
        // BELC300024444 - gPineda - 07/11/2006
        query.append(" , INC_CONCU_PARAM_GEREN geren ");
        
        query.append(" WHERE concu.PAIS_OID_PAIS = " + dto.getOidPais());        
        query.append(" AND concu.IND_ACTI  = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND concu.IND_RANK = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND rak.COPA_OID_PARA_GRAL= concu.OID_PARA_GRAL ");
        
        // BELC300024444 - gPineda - 07/11/2006
        //query.append(" AND rak.TPRK_OID_TIPO_RANK = " + ConstantesINC.TIPO_RANKING_INTERACTIVO);
        query.append(" AND concu.OID_PARA_GRAL = geren.COPA_OID_PARA_GRAL (+) ");
        query.append(" AND ( rak.TPRK_OID_TIPO_RANK = " + ConstantesINC.TIPO_RANKING_INTERACTIVO );
        query.append("       OR ( rak.TPRK_OID_TIPO_RANK = " + ConstantesINC.TIPO_RANKING_EVOLUTIVO );
        query.append("            AND geren.FCAL_OID_FORM_CALC = " + ConstantesINC.VARIABLES_VENTA );
        query.append("          ) ");
        query.append("      )");
        
        query.append(" ORDER BY concu.NUM_CONC ||'-'|| concu.NUM_VERS ");

        UtilidadesLog.info("DAOMantenimientoRanking.obtenerNroConcursosVersio"
            +"nesRankingActivos(DTOBelcorp dto):Salida");

        return this.executeSelectQuery(query);
    }

    /**
    *
    * @fecha 21/07/2005
    * @throws es.indra.mare.common.exception.MareException
    * @return DTOSalida
    * @author Mariano Rodriguez
    * @param dto
    */
    public DTOSalida obtieneVersiones(DTOOID dto) throws MareException {
        StringBuffer query = new StringBuffer();
        UtilidadesLog.info("DAOMantenimientoRanking.obtieneVersiones(DTOOID "
            +"dto):Entrada");

        query.append(" SELECT concu.NUM_VERS, concu.NUM_VERS ");
        query.append(" FROM INC_CONCU_PARAM_GENER concu ");
        query.append(" WHERE concu.OID_PARA_GRAL = " + dto.getOid());
        query.append(" ORDER BY concu.NUM_CONC ");

        UtilidadesLog.info("DAOMantenimientoRanking.obtieneVersiones(DTOOID "
            +"dto):Salida");

        return this.executeSelectQuery(query);
    }

    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     */
    public DTOSalida obtenerSGVConcursAmbito(DTOAmbitRC dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.obtenerSGVConcursAmbito"
            +"(DTOAmbitRC dto):Entrada");

        StringBuffer query = new StringBuffer();

        query.append(" SELECT distinct ");
        query.append(" sgv.OID_SUBG_VENT OID, ");
        query.append(" sgv.DES_SUBG_VENT ");
        query.append(" from ZON_SUB_GEREN_VENTA sgv, ");
        query.append(" INC_AMBIT_GEOGR ambit ");
        query.append(" where ");
        query.append(" sgv.OID_SUBG_VENT = ambit.ZSGV_OID_SUBG_VENT ");
        query.append(" and sgv.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" and ambit.COPA_OID_PARA_GRAL = " + dto.getOidConcurso());
        query.append(" and sgv.IND_ACTI = 1 ");
        query.append(" and sgv.IND_BORR = 0 ");

        UtilidadesLog.info("DAOMantenimientoRanking.obtenerSGVConcursAmbito("
            +"DTOAmbitRC dto):Salida");

        return this.executeSelectQuery(query);
    }

    /**
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     * Modificado por: Cristian Valenzuela
     * Fecha: 09/08/2006
     * Incidencia: BELC300023779
     */
    public DTOSalida obtenerRegionesConcursoAmbito(DTOAmbitRC dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.obtenerRegionesConcurso"
            +"Ambito(DTOAmbitRC dto):Entrada");

        StringBuffer query = new StringBuffer();

      /*query.append(" SELECT DISTINCT ambit.zsgv_oid_subg_vent,  ");
        query.append(" regi.oid_regi, ");
        query.append(" regi.des_regi descripcion ");
        query.append(" FROM zon_regio regi, inc_ambit_geogr ambit ");
        query.append(" WHERE regi.pais_oid_pais = " + dto.getOidPais());
        query.append(" AND regi.oid_regi = ambit.zorg_oid_regi ");
        query.append(" AND ambit.copa_oid_para_gral = " +
        dto.getOidConcurso());
        query.append(" AND regi.ind_acti = 1 ");
        query.append(" AND regi.ind_borr = 0 ");
        query.append(" ORDER BY descripcion ");*/        
        
        query.append(" SELECT DISTINCT AMBIT.ZSGV_OID_SUBG_VENT OIDSUBGERENCIAAMBITO, ");
        query.append(" AMBIT.ZORG_OID_REGI OIDREGION, ");
        query.append(" REGI.ZSGV_OID_SUBG_VENT OIDSUBGERENCIA, ");	 
        query.append(" REGI.OID_REGI OID , ");
        query.append(" REGI.DES_REGI DESCRIPCION ");
        query.append(" FROM ZON_REGIO REGI,  "); 
        query.append(" INC_AMBIT_GEOGR AMBIT  "); 
        query.append(" WHERE REGI.PAIS_OID_PAIS = " + dto.getOidPais());		 
        query.append(" AND (REGI.OID_REGI = AMBIT.ZORG_OID_REGI  "); 
        query.append(" OR AMBIT.ZORG_OID_REGI IS NULL)  ");
        query.append(" AND (AMBIT.ZSGV_OID_SUBG_VENT = REGI.ZSGV_OID_SUBG_VENT  ");
        query.append(" OR AMBIT.ZSGV_OID_SUBG_VENT IS NULL)  ");
        query.append(" AND AMBIT.COPA_OID_PARA_GRAL = " + dto.getOidConcurso()); 
        query.append(" AND REGI.IND_ACTI = 1  ");
        query.append(" AND REGI.IND_BORR = 0  "); 
        query.append(" GROUP BY AMBIT.ZSGV_OID_SUBG_VENT, AMBIT.ZORG_OID_REGI,  ");
        query.append(" REGI.ZSGV_OID_SUBG_VENT, REGI.OID_REGI, REGI.DES_REGI  ");
        query.append(" ORDER BY AMBIT.ZSGV_OID_SUBG_VENT, AMBIT.ZORG_OID_REGI ,  ");
        query.append(" REGI.ZSGV_OID_SUBG_VENT, DES_REGI   ");
        
        DTOSalida dtoSalidaFinal = new DTOSalida();    
        
        RecordSet rsFinalRetornar = new RecordSet();        
        rsFinalRetornar.addColumn("OIDSUBGERENCIAAMBITO");
        rsFinalRetornar.addColumn("OIDREGION");
        rsFinalRetornar.addColumn("OIDSUBGERENCIA");
        rsFinalRetornar.addColumn("OID");
        rsFinalRetornar.addColumn("DESCRIPCION");
        
        DTOSalida dtoSalida = executeSelectQuery(query);
        RecordSet rs = dtoSalida.getResultado();
        int n = rs.getRowCount();
        int i = 0;
        
        UtilidadesLog.debug("*** rs.getRowCount(): " + n);
        
        if(n>0) {        
            BigDecimal oidSGActual = (BigDecimal)rs.getValueAt(0, "OIDSUBGERENCIAAMBITO");
            BigDecimal oidSGAnterior = (BigDecimal)rs.getValueAt(0, "OIDSUBGERENCIAAMBITO");        
        
            while (i<n) {
                boolean hayRegionesNotNull = false;
            
                RecordSet rsFinalNoNulos = new RecordSet();
                RecordSet rsFinalNulos = new RecordSet();                   
            
                rsFinalNoNulos.addColumn("OIDSUBGERENCIAAMBITO");
                rsFinalNoNulos.addColumn("OIDREGION");
                rsFinalNoNulos.addColumn("OIDSUBGERENCIA");
                rsFinalNoNulos.addColumn("OID");
                rsFinalNoNulos.addColumn("DESCRIPCION");
                
                rsFinalNulos.addColumn("OIDSUBGERENCIAAMBITO");
                rsFinalNulos.addColumn("OIDREGION");
                rsFinalNulos.addColumn("OIDSUBGERENCIA");
                rsFinalNulos.addColumn("OID");
                rsFinalNulos.addColumn("DESCRIPCION");
        
                while (i<n && oidSGActual.equals(oidSGAnterior) ) {                       
                    oidSGActual = (BigDecimal)rs.getValueAt(i,0); 
                
                    if ((i<n && oidSGActual.equals(oidSGAnterior)) || i==n) {                    
                        BigDecimal oidRegion = (BigDecimal)rs.getValueAt(i, "OIDREGION");           
                
                        if(oidRegion!=null) {
                            hayRegionesNotNull = true;
                            rsFinalNoNulos.addRow(rs.getRow(i));                   
                        }
                        else {                    
                            if(hayRegionesNotNull!=true) {
                                rsFinalNulos.addRow(rs.getRow(i));            
                            }
                        }         
                        i++;
                    }                
                }          
            
                oidSGAnterior = oidSGActual;  
            
                if(hayRegionesNotNull==false) {
                    for(int j=0; j<rsFinalNulos.getRowCount(); j++) {
                        rsFinalRetornar.addRow(rsFinalNulos.getRow(j));
                    }            
                }
                else {
                    for(int j=0; j<rsFinalNoNulos.getRowCount(); j++) {
                        rsFinalRetornar.addRow(rsFinalNoNulos.getRow(j));
                    }                            
                }
            }  
        
            dtoSalidaFinal.setResultado(rsFinalRetornar);
        }

        UtilidadesLog.info("DAOMantenimientoRanking.obtenerRegionesConcurso"
            +"Ambito(DTOAmbitRC dto):Salida");

        return dtoSalidaFinal;
    }

    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     * Modificado por: Cristian Valenzuela
     * Fecha: 09/08/2006
     * Incidencia: BELC300023779
     */
    public DTOSalida obtenerZonasConcursoAmbito(DTOAmbitRC dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.obtenerZonasConcursoAmbi"
            +"to(DTOAmbitRC dto):Entrada");

        StringBuffer query = new StringBuffer();

      /*query.append(" SELECT DISTINCT ambit.zorg_oid_regi,zon.oid_zona, ");
        query.append(" zon.des_zona descripcion ");
        query.append(" FROM zon_zona zon, inc_ambit_geogr ambit ");
        query.append(" WHERE zon.pais_oid_pais =  " + dto.getOidPais());
        query.append(" AND zon.oid_zona = ambit.zzon_oid_zona ");
        query.append(" AND ambit.copa_oid_para_gral = " + dto.getOidConcurso());
        query.append(" AND zon.ind_acti = 1 ");
        query.append(" AND zon.ind_borr = 0 ");
        query.append(" ORDER BY descripcion ");*/
        
        query.append(" SELECT DISTINCT AMBIT.ZORG_OID_REGI OIDREGIONAMBITO, ");
        query.append(" AMBIT.ZZON_OID_ZONA OIDZONA, ");
        query.append(" ZON.ZORG_OID_REGI OIDREGION, ");
        query.append(" ZON.OID_ZONA OID, ");
        query.append(" ZON.DES_ZONA DESCRIPCION ");
        query.append(" FROM ZON_ZONA ZON, "); 
        query.append(" INC_AMBIT_GEOGR AMBIT ");
        query.append(" WHERE ZON.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND (ZON.OID_ZONA = AMBIT.ZZON_OID_ZONA ");
        query.append(" OR AMBIT.ZZON_OID_ZONA IS NULL) ");
        query.append(" AND (AMBIT.ZORG_OID_REGI = ZON.ZORG_OID_REGI ");
        query.append(" OR AMBIT.ZORG_OID_REGI IS NULL) ");	  
        query.append(" AND AMBIT.COPA_OID_PARA_GRAL = " + dto.getOidConcurso());	 
        query.append(" AND ZON.IND_ACTI = 1 ");
        query.append(" AND ZON.IND_BORR = 0 ");
        query.append(" GROUP BY AMBIT.ZORG_OID_REGI,AMBIT.ZZON_OID_ZONA, ");
        query.append(" ZON.ZORG_OID_REGI, ZON.OID_ZONA, ZON.DES_ZONA ");
        query.append(" ORDER BY AMBIT.ZORG_OID_REGI,AMBIT.ZZON_OID_ZONA, ");
        query.append(" ZON.ZORG_OID_REGI, ZON.OID_ZONA, ZON.DES_ZONA ");
        
        DTOSalida dtoSalidaFinal = new DTOSalida();
        
        RecordSet rsFinalRetornar = new RecordSet();        
        rsFinalRetornar.addColumn("OIDREGIONAMBITO");
        rsFinalRetornar.addColumn("OIDZONA");
        rsFinalRetornar.addColumn("OIDREGION");
        rsFinalRetornar.addColumn("OID");
        rsFinalRetornar.addColumn("DESCRIPCION");        
        
        RecordSet rsRegistrosSinNulos = new RecordSet();        
        rsRegistrosSinNulos.addColumn("OIDREGIONAMBITO");
        rsRegistrosSinNulos.addColumn("OIDZONA");
        rsRegistrosSinNulos.addColumn("OIDREGION");
        rsRegistrosSinNulos.addColumn("OID");
        rsRegistrosSinNulos.addColumn("DESCRIPCION");        
        
        RecordSet rsRegistrosNulos = new RecordSet();        
        rsRegistrosNulos.addColumn("OIDREGIONAMBITO");
        rsRegistrosNulos.addColumn("OIDZONA");
        rsRegistrosNulos.addColumn("OIDREGION");
        rsRegistrosNulos.addColumn("OID");
        rsRegistrosNulos.addColumn("DESCRIPCION");        
        
        //se ejecuta la consulta
        DTOSalida dtoSalida = executeSelectQuery(query);
        RecordSet rs = dtoSalida.getResultado();
        int cantidad = rs.getRowCount();
        
        //el RecordSet que trajo la consulta,
        //lo separo en dos, por un lado los que tienen el campo
        //OIDREGIONAMBITO en nulo y por otro lado los que tienen
        //este campo distinto de nulo
        
        for(int i=0; i<cantidad; i++) {
            if(rs.getValueAt(i,0)!=null) {
                rsRegistrosSinNulos.addRow(rs.getRow(i));
            }
            else {
                rsRegistrosNulos.addRow(rs.getRow(i));
            }            
        }  
        
        //el RecordSet que se manipulara sera el que tiene los registros
        //con el campo OIDREGIONAMBITO distinto de nulo
        int n = rsRegistrosSinNulos.getRowCount();
        int k = rsRegistrosNulos.getRowCount();
        
        int i = 0;
        
        UtilidadesLog.debug("*** rsRegistrosSinNulos.getRowCount(): " + n);
        UtilidadesLog.debug("*** rsRegistrosNulos.getRowCount(): " + k);
        
        if(n>0) {        
            BigDecimal oidRegionActual = (BigDecimal)rsRegistrosSinNulos.getValueAt(0, "OIDREGIONAMBITO");
            BigDecimal oidRegionAnterior = (BigDecimal)rsRegistrosSinNulos.getValueAt(0, "OIDREGIONAMBITO");        
            
            while (i<n) {
                boolean hayZonasNotNull = false;
                
                RecordSet rsFinalNoNulos = new RecordSet();
                RecordSet rsFinalNulos = new RecordSet();                   
                
                rsFinalNoNulos.addColumn("OIDREGIONAMBITO");
                rsFinalNoNulos.addColumn("OIDZONA");
                rsFinalNoNulos.addColumn("OIDREGION");
                rsFinalNoNulos.addColumn("OID");
                rsFinalNoNulos.addColumn("DESCRIPCION");
                
                rsFinalNulos.addColumn("OIDREGIONAMBITO");
                rsFinalNulos.addColumn("OIDZONA");
                rsFinalNulos.addColumn("OIDREGION");
                rsFinalNulos.addColumn("OID");
                rsFinalNulos.addColumn("DESCRIPCION");
            
                while (i<n && oidRegionActual.equals(oidRegionAnterior)) {                       
                    oidRegionActual = (BigDecimal)rsRegistrosSinNulos.getValueAt(i,0); 
                    
                    if (i<n && oidRegionActual.equals(oidRegionAnterior) || i==n) {                    
                        BigDecimal oidZona = (BigDecimal)rsRegistrosSinNulos.getValueAt(i, "OIDZONA");           
                    
                        if(oidZona!=null) {
                            hayZonasNotNull = true;
                            rsFinalNoNulos.addRow(rsRegistrosSinNulos.getRow(i));                   
                        }
                        else {                    
                            if(hayZonasNotNull!=true) {
                                rsFinalNulos.addRow(rsRegistrosSinNulos.getRow(i));            
                            }
                        }         
                        i++;
                    }                
                }          
                
                oidRegionAnterior = oidRegionActual;  
                
                if(hayZonasNotNull==false) {
                    for(int j=0; j<rsFinalNulos.getRowCount(); j++) {
                        rsFinalRetornar.addRow(rsFinalNulos.getRow(j));
                    }            
                }
                else {
                    for(int j=0; j<rsFinalNoNulos.getRowCount(); j++) {
                        rsFinalRetornar.addRow(rsFinalNoNulos.getRow(j));
                    }                            
                }
            }                    
        }
        
        //Al final del recordset a devolver se le pasan los registros
        //que tenian el campo OIDREGIONAMBITO en nulo en la consulta
        if(k>0) {
            for(int j=0; j<rsRegistrosNulos.getRowCount(); j++) {
                rsFinalRetornar.addRow(rsRegistrosNulos.getRow(j));
            }              
        }
        
        dtoSalidaFinal.setResultado(rsFinalRetornar);

        UtilidadesLog.info("DAOMantenimientoRanking.obtenerZonasConcursoAmbi"
            +"to(DTOAmbitRC dto):Salida");

        return dtoSalidaFinal;
    }

    /**
    *
    * @fecha 21/07/2005
    * @throws es.indra.mare.common.exception.MareException
    * @return DTOSalida
    * @author Mariano Rodriguez
    * @param dto
    * Modificado por: Cristian Valenzuela
    * Fecha: 09/08/2006
    * Incidencia: BELC300023779
    */
    public DTOSalida obtenerSeccionesConcursoAmbito(DTOAmbitRC dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.obtenerSeccionesConcursoAm"
            +"bito(DTOAmbitRC dto):Entrada");

        StringBuffer query = new StringBuffer();

      /*query.append(" SELECT DISTINCT ambit.zzon_oid_zona,sexy.oid_secc, ");
        query.append(" sexy.des_secci descripcion ");
        query.append(" FROM zon_secci sexy, inc_ambit_geogr ambit ");
        query.append(" WHERE sexy.zzon_oid_zona = ambit.zscc_oid_secc ");
        query.append(" AND ambit.copa_oid_para_gral = " + dto.getOidConcurso());
        query.append(" AND sexy.ind_acti = 1 ");
        query.append(" AND sexy.ind_borr = 0 ");
        query.append(" ORDER BY descripcion ");*/
        
        query.append(" SELECT DISTINCT AMBIT.ZZON_OID_ZONA OIDZONAAMBITO, ");
        query.append(" AMBIT.ZSCC_OID_SECC OIDSECCION, ");
        query.append(" SEXY.ZZON_OID_ZONA OIDZONA, ");
        query.append(" SEXY.OID_SECC OID, ");
        query.append(" SEXY.DES_SECCI DESCRIPCION ");
        query.append(" FROM ZON_SECCI SEXY, ");
        query.append(" INC_AMBIT_GEOGR AMBIT ");
        query.append(" WHERE (SEXY.OID_SECC = AMBIT.ZSCC_OID_SECC ");
        query.append(" OR AMBIT.ZSCC_OID_SECC IS NULL) ");
        query.append(" AND (AMBIT.ZZON_OID_ZONA = SEXY.ZZON_OID_ZONA ");
        query.append(" OR AMBIT.ZZON_OID_ZONA IS NULL) ");
        query.append(" AND AMBIT.COPA_OID_PARA_GRAL = " + dto.getOidConcurso());		 
        query.append(" AND SEXY.IND_ACTI = 1 ");
        query.append(" AND SEXY.IND_BORR = 0 ");
        query.append(" GROUP BY AMBIT.ZZON_OID_ZONA, AMBIT.ZSCC_OID_SECC, ");
        query.append(" SEXY.ZZON_OID_ZONA, SEXY.OID_SECC, SEXY.DES_SECCI ");
        query.append(" ORDER BY AMBIT.ZZON_OID_ZONA, AMBIT.ZSCC_OID_SECC, ");
        query.append(" SEXY.ZZON_OID_ZONA, SEXY.OID_SECC, SEXY.DES_SECCI ");    
        
        DTOSalida dtoSalidaFinal = new DTOSalida();
        
        RecordSet rsFinalRetornar = new RecordSet();        
        rsFinalRetornar.addColumn("OIDZONAAMBITO");
        rsFinalRetornar.addColumn("OIDSECCION");
        rsFinalRetornar.addColumn("OIDZONA");
        rsFinalRetornar.addColumn("OID");
        rsFinalRetornar.addColumn("DESCRIPCION");
        
        RecordSet rsRegistrosSinNulos = new RecordSet();        
        rsRegistrosSinNulos.addColumn("OIDZONAAMBITO");
        rsRegistrosSinNulos.addColumn("OIDSECCION");
        rsRegistrosSinNulos.addColumn("OIDZONA");
        rsRegistrosSinNulos.addColumn("OID");
        rsRegistrosSinNulos.addColumn("DESCRIPCION");        
        
        RecordSet rsRegistrosNulos = new RecordSet();        
        rsRegistrosNulos.addColumn("OIDZONAAMBITO");
        rsRegistrosNulos.addColumn("OIDSECCION");
        rsRegistrosNulos.addColumn("OIDZONA");
        rsRegistrosNulos.addColumn("OID");
        rsRegistrosNulos.addColumn("DESCRIPCION");        
        
        //se ejecuta la consulta        
        DTOSalida dtoSalida = executeSelectQuery(query);
        RecordSet rs = dtoSalida.getResultado();
        int cantidad = rs.getRowCount();
        
        //el RecordSet que trajo la consulta,
        //lo separo en dos, por un lado los que tienen el campo
        //OIDZONAAMBITO en nulo y por otro lado los que tienen
        //este campo distinto de nulo
        
        for(int i=0; i<cantidad; i++) {
            if(rs.getValueAt(i,0)!=null) {
                rsRegistrosSinNulos.addRow(rs.getRow(i));
            }
            else {
                rsRegistrosNulos.addRow(rs.getRow(i));
            }            
        }  
        
        //el RecordSet que se manipulara sera el que tiene los registros
        //con el campo OIDZONAAMBITO distinto de nulo
        int n = rsRegistrosSinNulos.getRowCount();
        int k = rsRegistrosNulos.getRowCount();       
    
        int i = 0;
        
        UtilidadesLog.debug("*** rsRegistrosSinNulos.getRowCount(): " + n);
        UtilidadesLog.debug("*** rsRegistrosNulos.getRowCount(): " + k);
        
        if(n>0) {        
            BigDecimal oidZonaActual = (BigDecimal)rsRegistrosSinNulos.getValueAt(0, "OIDZONAAMBITO");
            BigDecimal oidZonaAnterior = (BigDecimal)rsRegistrosSinNulos.getValueAt(0, "OIDZONAAMBITO");        
            
            while (i<n) {
                boolean haySeccionesNotNull = false;
                
                RecordSet rsFinalNoNulos = new RecordSet();
                RecordSet rsFinalNulos = new RecordSet();                   
                
                rsFinalNoNulos.addColumn("OIDZONAAMBITO");
                rsFinalNoNulos.addColumn("OIDSECCION");
                rsFinalNoNulos.addColumn("OIDZONA");
                rsFinalNoNulos.addColumn("OID");
                rsFinalNoNulos.addColumn("DESCRIPCION");
                
                rsFinalNulos.addColumn("OIDZONAAMBITO");
                rsFinalNulos.addColumn("OIDSECCION");
                rsFinalNulos.addColumn("OIDZONA");
                rsFinalNulos.addColumn("OID");
                rsFinalNulos.addColumn("DESCRIPCION");
            
                while (i<n && oidZonaActual.equals(oidZonaAnterior) ) {                       
                    oidZonaActual = (BigDecimal)rsRegistrosSinNulos.getValueAt(i,0); 
                    
                    if (i<n && oidZonaActual.equals(oidZonaAnterior) || i==n) {                    
                        BigDecimal oidSeccion = (BigDecimal)rsRegistrosSinNulos.getValueAt(i, "OIDSECCION");           
                    
                        if(oidSeccion!=null) {
                            haySeccionesNotNull = true;
                            rsFinalNoNulos.addRow(rsRegistrosSinNulos.getRow(i));                   
                        }
                        else {                    
                            if(haySeccionesNotNull!=true) {
                                rsFinalNulos.addRow(rsRegistrosSinNulos.getRow(i));            
                            }
                        }         
                        i++;
                    }                
                }          
                
                oidZonaAnterior = oidZonaActual;  
                
                if(haySeccionesNotNull==false) {
                    for(int j=0; j<rsFinalNulos.getRowCount(); j++) {
                        rsFinalRetornar.addRow(rsFinalNulos.getRow(j));
                    }            
                }
                else {
                    for(int j=0; j<rsFinalNoNulos.getRowCount(); j++) {
                        rsFinalRetornar.addRow(rsFinalNoNulos.getRow(j));
                    }                            
                }
            }          
        }
        
        //Al final del recordset a devolver se le pasan los registros
        //que tenian el campo OIDZONAAMBITO en nulo en la consulta
        if(k>0) {
            for(int j=0; j<rsRegistrosNulos.getRowCount(); j++) {
                rsFinalRetornar.addRow(rsRegistrosNulos.getRow(j));
            }              
        }        
        
        dtoSalidaFinal.setResultado(rsFinalRetornar);   

        UtilidadesLog.info("DAOMantenimientoRanking.obtenerSeccionesConcursoAm"
            +"bito(DTOAmbitRC dto):Salida");

        return dtoSalidaFinal;
    }

    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     * Modificado por: Cristian Valenzuela
     * Fecha: 07/08/2006
     * Incidencia: BELC300023779
     */
    public DTOSalida obtenerTerritoriosConcursoAmbito(DTOAmbitRC dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.obtenerTerritoriosConcurso"
            +"Ambito(DTOAmbitRC dto):Entrada");

        StringBuffer query = new StringBuffer();

        /*query.append(" SELECT DISTINCT ambit.zscc_oid_secc, terri.oid_terr, ");
        query.append(" terri.cod_terr descripcion ");
        query.append(" FROM zon_terri terri, inc_ambit_geogr ambit ");
        query.append(" WHERE terri.pais_oid_pais = " + dto.getOidPais());
        query.append(" AND terri.oid_terr = ambit.terr_oid_terr ");
        query.append(" AND ambit.copa_oid_para_gral = " + dto.getOidConcurso());
        query.append(" AND terri.ind_borr = 0 ");*/

        query.append(" SELECT DISTINCT AMBIT.ZSCC_OID_SECC OIDSECCIONAMBITO, ");
        query.append(" AMBIT.TERR_OID_TERR OIDTERRITORIO, ");
        query.append(" TADMIN.ZSCC_OID_SECC OIDSECCION, ");
        query.append(" TERRI.OID_TERR OID, ");
        query.append(" TERRI.COD_TERR DESCRIPCION ");
        query.append(" FROM ZON_TERRI TERRI, ");
        query.append(" INC_AMBIT_GEOGR AMBIT, ");
        query.append(" ZON_TERRI_ADMIN TADMIN ");
        query.append(" WHERE TERRI.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append(" AND (TERRI.OID_TERR = AMBIT.TERR_OID_TERR ");
        query.append(" OR AMBIT.TERR_OID_TERR IS NULL) ");
        query.append(" AND  TADMIN.TERR_OID_TERR = TERRI.OID_TERR ");
        query.append(" AND (AMBIT.ZSCC_OID_SECC = TADMIN.ZSCC_OID_SECC ");
        query.append(" OR AMBIT.ZSCC_OID_SECC IS NULL) ");
        query.append(" AND AMBIT.COPA_OID_PARA_GRAL = " + dto.getOidConcurso());		 
        query.append(" AND TERRI.IND_BORR = 0 ");
        query.append(" GROUP BY AMBIT.ZSCC_OID_SECC, AMBIT.TERR_OID_TERR, ");
        query.append(" TADMIN.ZSCC_OID_SECC,TERRI.OID_TERR,TERRI.COD_TERR ");
        query.append(" ORDER BY AMBIT.ZSCC_OID_SECC, AMBIT.TERR_OID_TERR, ");
        query.append(" TADMIN.ZSCC_OID_SECC,TERRI.OID_TERR, TERRI.COD_TERR ");
        
        DTOSalida dtoSalidaFinal = new DTOSalida();
        
        RecordSet rsFinalRetornar = new RecordSet();        
        rsFinalRetornar.addColumn("OIDSECCIONAMBITO");
        rsFinalRetornar.addColumn("OIDTERRITORIO");
        rsFinalRetornar.addColumn("OIDSECCION");
        rsFinalRetornar.addColumn("OID");
        rsFinalRetornar.addColumn("DESCRIPCION");
        
        RecordSet rsRegistrosSinNulos = new RecordSet();        
        rsRegistrosSinNulos.addColumn("OIDSECCIONAMBITO");
        rsRegistrosSinNulos.addColumn("OIDTERRITORIO");
        rsRegistrosSinNulos.addColumn("OIDSECCION");
        rsRegistrosSinNulos.addColumn("OID");
        rsRegistrosSinNulos.addColumn("DESCRIPCION");        
        
        RecordSet rsRegistrosNulos = new RecordSet();        
        rsRegistrosNulos.addColumn("OIDSECCIONAMBITO");
        rsRegistrosNulos.addColumn("OIDTERRITORIO");
        rsRegistrosNulos.addColumn("OIDSECCION");
        rsRegistrosNulos.addColumn("OID");
        rsRegistrosNulos.addColumn("DESCRIPCION");        
        
        //se ejecuta la consulta       
        DTOSalida dtoSalida = executeSelectQuery(query);
        RecordSet rs = dtoSalida.getResultado();
        int cantidad = rs.getRowCount();
        
        //el RecordSet que trajo la consulta,
        //lo separo en dos, por un lado los que tienen el campo
        //OIDSECCIONAMBITO en nulo y por otro lado los que tienen
        //este campo distinto de nulo
        
        for(int i=0; i<cantidad; i++) {
            if(rs.getValueAt(i,0)!=null) {
                rsRegistrosSinNulos.addRow(rs.getRow(i));
            }
            else {
                rsRegistrosNulos.addRow(rs.getRow(i));
            }            
        }  
        
        //el RecordSet que se manipulara sera el que tiene los registros
        //con el campo OIDSECCIONAMBITO distinto de nulo
        int n = rsRegistrosSinNulos.getRowCount();
        int k = rsRegistrosNulos.getRowCount();      
        
        int i = 0;        
        
        UtilidadesLog.debug("*** rsRegistrosSinNulos.getRowCount(): " + n);
        UtilidadesLog.debug("*** rsRegistrosNulos.getRowCount(): " + k);
        
        if(n>0) {        
            BigDecimal oidSeccionActual = (BigDecimal)rsRegistrosSinNulos.getValueAt(0, "OIDSECCIONAMBITO");
            BigDecimal oidSeccionAnterior = (BigDecimal)rsRegistrosSinNulos.getValueAt(0, "OIDSECCIONAMBITO");        
            
            while (i<n) {
                boolean hayTerritoriosNotNull = false;
                
                RecordSet rsFinalNoNulos = new RecordSet();
                RecordSet rsFinalNulos = new RecordSet();                   
                
                rsFinalNoNulos.addColumn("OIDSECCIONAMBITO");
                rsFinalNoNulos.addColumn("OIDTERRITORIO");
                rsFinalNoNulos.addColumn("OIDSECCION");
                rsFinalNoNulos.addColumn("OID");
                rsFinalNoNulos.addColumn("DESCRIPCION");
                
                rsFinalNulos.addColumn("OIDSECCIONAMBITO");
                rsFinalNulos.addColumn("OIDTERRITORIO");
                rsFinalNulos.addColumn("OIDSECCION");
                rsFinalNulos.addColumn("OID");
                rsFinalNulos.addColumn("DESCRIPCION");
            
                while (i<n && oidSeccionActual.equals(oidSeccionAnterior) ) {                       
                    oidSeccionActual = (BigDecimal)rsRegistrosSinNulos.getValueAt(i,0); 
                    
                    if (i<n && oidSeccionActual.equals(oidSeccionAnterior) || i==n) {                    
                        BigDecimal oidTerritorio = (BigDecimal)rsRegistrosSinNulos.getValueAt(i, "OIDTERRITORIO");           
                    
                        if(oidTerritorio!=null) {
                            hayTerritoriosNotNull = true;
                            rsFinalNoNulos.addRow(rsRegistrosSinNulos.getRow(i));                   
                        }
                        else {                    
                            if(hayTerritoriosNotNull!=true) {
                                rsFinalNulos.addRow(rsRegistrosSinNulos.getRow(i));            
                            }
                        }         
                        i++;
                    }                
                }          
                
                oidSeccionAnterior = oidSeccionActual;  
                
                if(hayTerritoriosNotNull==false) {
                    for(int j=0; j<rsFinalNulos.getRowCount(); j++) {
                        rsFinalRetornar.addRow(rsFinalNulos.getRow(j));
                    }            
                }
                else {
                    for(int j=0; j<rsFinalNoNulos.getRowCount(); j++) {
                        rsFinalRetornar.addRow(rsFinalNoNulos.getRow(j));
                    }                            
                }
            }               
        }
        
        //Al final del recordset a devolver se le pasan los registros
        //que tenian el campo OIDSECCIONAMBITO en nulo en la consulta
        if(k>0) {
            for(int j=0; j<rsRegistrosNulos.getRowCount(); j++) {
                rsFinalRetornar.addRow(rsRegistrosNulos.getRow(j));
            }              
        }        
        
        dtoSalidaFinal.setResultado(rsFinalRetornar);    
        
        UtilidadesLog.info("DAOMantenimientoRanking.obtenerTerritoriosConcurso"
            +"Ambito(DTOAmbitRC dto):Salida");

        return dtoSalidaFinal;
    }

    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     */
    public DTOSalida recuperarPremiosNiveles(DTORankingNivelesPremios dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.recuperarPremiosNiveles"
            +"(DTORankingNivelesPremios dto):Entrada");

        DTOSalida resu = new DTOSalida();
        RecordSet r = null;
        StringBuffer query = new StringBuffer();
        StringBuffer queryPaginado = new StringBuffer();

        query.append(" select concgener.NUM_CONC nconcurso, ");
        query.append(" concgener.NUM_VERS version, ");
        query.append(" pnivel.NUM_NIVE nivel, ");
        query.append(" pnivel.NUM_CANT_FIJA_PUNT cantFija, ");
        query.append(" pnivel.NUM_CANT_INIC_PUNT cantInicial, ");
        query.append(" pnivel.NUM_CANT_FINA_PUNT cantFinal, ");
        query.append(" i.VAL_I18N tipoPremio, ");
        query.append(" tpremio.OID_TIPO_PREM oidTipoPremio,  ");
        query.append(" pgener.OID_PARA_GENE_PREM, ");
        query.append(" pnivel.OID_PARA_NIVE_PREM oidNivel");
        query.append(" from INC_PARAM_NIVEL_PREMI pnivel, ");
        query.append(" INC_PARAM_GENER_PREMI pgener, ");
        query.append(" INC_CONCU_PARAM_GENER concgener, ");
        query.append(" INC_TIPO_PREMI tpremio, ");
        query.append(" v_gen_i18n_SICC i ");
        query.append(" where ");
        query.append(
            " pnivel.PAGP_OID_PARA_GENE_PREM = pgener.OID_PARA_GENE_PREM ");
        query.append(
            " and pgener.COPA_OID_PARA_GRAL = concgener.OID_PARA_GRAL ");
        query.append(" and concgener.OID_PARA_GRAL = " + dto.getOidConcurso());
        query.append(" and pnivel.TPRE_OID_TIPO_PREM =  ");
        query.append(" tpremio.OID_TIPO_PREM ");
        query.append(" and i.ATTR_ENTI = 'INC_TIPO_PREMI' ");
        query.append(" and i.ATTR_NUM_ATRI = 1 ");
        query.append(" and i.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" and i.VAL_OID = tpremio.OID_TIPO_PREM ");
        query.append(" order By nivel ");

        queryPaginado.append(" SELECT * FROM ( ");
        queryPaginado.append("   SELECT ROWNUM AS linea, queryPrincipal.* ");
        queryPaginado.append("   FROM (  ");
        queryPaginado.append(query.toString());
        queryPaginado.append("     )  queryPrincipal ");

        queryPaginado.append(" ) WHERE ROWNUM <= " + dto.getTamanioPagina() +
            " AND linea > " + dto.getIndicadorSituacion());

        try {
            BelcorpService bs = BelcorpService.getInstance();

            r = bs.dbService.executeStaticQuery(queryPaginado.toString());
            UtilidadesLog.debug("resultado query: " + r);

            resu.setResultado(r);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        if ((r == null) || r.esVacio()) {
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("DAOMantenimientoRanking.recuperarPremiosNiveles("
            +"DTORankingNivelesPremios dto):Salida");

        return resu;
    }

    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     */
    public DTOSalida recuperarGanadorasAspirantesNivel(DTONivelesRanking dto,
        Long oidPeriodoActual) throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.recuperarGanadorasAspiran"
            +"tesNivel(DTONivelesRanking dto, Long oidPeriodoActual):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(new RecordSet());

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        int numAsp;
        int cantIniPuntos;
        int cantFinPuntos;

        try {
        
            if (dto.getNumeroAspirantes() == null) {
                numAsp = 0;
            } else {
                numAsp = dto.getNumeroAspirantes().intValue();
            }

            if (dto.getCantidadInicialPuntos() == null) {
                cantIniPuntos = 0;
            } else {
                cantIniPuntos = dto.getCantidadInicialPuntos().intValue();
            }

            if (dto.getCantidadFinalPuntos() == null) {
                cantFinPuntos = 0;
            } else {
                cantFinPuntos = dto.getCantidadFinalPuntos().intValue();
            }
                
            query.append(" SELECT *  ");
            query.append(" FROM (SELECT CONSULTA.*, ROWNUM RNUM FROM (  ");            
            query.append(" SELECT con.OID_PARA_GRAL oidConcurso,  ");
            query.append(" con.num_conc concurso, ");
            query.append(" cli.OID_CLIE oiCliente, cli.cod_clie cliente, ");
            query.append(" concat(cli.VAL_NOM1,concat(' ',concat( ");
            query.append("   cli.VAL_NOM2, concat(' ',concat( ");
            query.append(" cli.VAL_APE1,concat ");
            query.append(" (' ', cli.VAL_APE2)))))) nombre_y_apellido, ");
            query.append(" rr.imp_mont_vent monto, ");
            query.append(" rr.num_unid_vend unidades, ");
            query.append(" rr.num_pedi nropedidos, ");
            query.append(" rr.num_reco nroreco, ");
            query.append(" con.MARC_OID_MARC marca, ");
            query.append(" con.CANA_OID_CANA canal, ");
            query.append(" con.PAIS_OID_PAIS pais, ");
            query.append(" con.DIRI_OID_DIRI dirigidoa, ");
            query.append(" rr.PERD_OID_PERI periodo ");
            query.append(" FROM inc_resul_ranki rr,  ");
            query.append(" inc_concu_param_gener con, mae_clien cli, CRA_PERIO CPE ");
            query.append(" WHERE rr.copa_oid_para_gral = " +
                dto.getOidConcurso());
            query.append(" AND con.oid_para_gral = rr.copa_oid_para_gral ");
            query.append(" AND cli.oid_clie = rr.clie_oid_clie ");
            query.append(" AND RR.PERD_OID_PERI = CPE.OID_PERI ");            
            query.append(" AND CPE.FEC_INIC =	(SELECT MAX(CPE_MAX.FEC_INIC) ");
            query.append(" FROM CRA_PERIO CPE_MAX,  INC_RESUL_RANKI RR_MAX ");
            query.append(" WHERE RR_MAX.COPA_OID_PARA_GRAL = RR.COPA_OID_PARA_GRAL ");
            query.append(" AND RR_MAX.CLIE_OID_CLIE = RR.CLIE_OID_CLIE ");
            query.append(" AND CPE_MAX.OID_PERI = RR_MAX.PERD_OID_PERI ");
            query.append(" GROUP BY RR_MAX.COPA_OID_PARA_GRAL, RR_MAX.CLIE_OID_CLIE ) ");
            query.append(" order By nvl(monto,nvl(unidades, ");
            query.append(" nvl(nropedidos,nroreco))) desc ");
            query.append(" ) CONSULTA ");
            query.append(" WHERE ROWNUM <=" + (cantFinPuntos + numAsp) + ") ");
            query.append(" WHERE RNUM >= " + cantIniPuntos );

            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("El recordset es  " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("***El recordset es " + rs);

        try {
            if (!rs.esVacio()) {
                int cantRegistros;
                int iconoGanadora;
                
                cantRegistros = cantFinPuntos -
                    cantIniPuntos + 1 + numAsp;
                iconoGanadora = cantFinPuntos -
                    cantIniPuntos + 1;

                UtilidadesLog.debug("La cantidad es " + cantRegistros);

                RecordSet rsGanadoras = new RecordSet();
                Vector columnas = new Vector();

                columnas.add("OID");
                columnas.add("ICONO");
                columnas.add("CODIGOCLIENTE");
                columnas.add("APENOM");
                columnas.add("MONTO");
                columnas.add("OIDCONCURSO");
                columnas.add("OIDCLIENTE");
                columnas.add("INDGANADOR");
                columnas.add("OIDMARCA");
                columnas.add("OIDCANAL");
                columnas.add("OIDPAIS");
                columnas.add("OIDDIRIGIDOA");
                columnas.add("OIDPERIODO");

                rsGanadoras.setColumnIdentifiers(columnas);

                Vector vec2 = new Vector();

                for (int pos = 0; (pos < cantRegistros && pos < rs.getRowCount()); pos++) {
                    UtilidadesLog.debug("paso 1 dentro del for");

                    vec2 = new Vector();

                    Long oid = new Long(pos);
                    vec2.add(oid);

                    if (pos < iconoGanadora) {
                        vec2.add("iconDorada.gif");
                    } else {
                        vec2.add("iconEstrella.gif");
                    }

                    vec2.add(rs.getValueAt(pos, 3));
                    vec2.add(rs.getValueAt(pos, 4));

                    if (rs.getValueAt(pos, 5) != null) {
                        vec2.add(rs.getValueAt(pos, 5));
                    } else {
                        if (rs.getValueAt(pos, 6) != null) {
                            vec2.add(rs.getValueAt(pos, 6));
                        } else {
                            if (rs.getValueAt(pos, 7) != null) {
                                vec2.add(rs.getValueAt(pos, 7));
                            } else {
                                vec2.add(rs.getValueAt(pos, 8));
                            }
                        }
                    }

                    vec2.add(rs.getValueAt(pos, 0));
                    vec2.add(rs.getValueAt(pos, 2));

                    if (pos < iconoGanadora) {
                        vec2.add("true");
                    } else {
                        vec2.add("false");
                    }

                    vec2.add(rs.getValueAt(pos, 9));
                    vec2.add(rs.getValueAt(pos, 10));
                    vec2.add(rs.getValueAt(pos, 11));
                    vec2.add(rs.getValueAt(pos, 12));
                    vec2.add(rs.getValueAt(pos, 13));

                    rsGanadoras.addRow(vec2);
                }

                UtilidadesLog.debug("El recordset a mostrar es: " +
                    rsGanadoras);
                dtoS.setResultado(rsGanadoras);
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOMantenimientoRanking.recuperarGanadorasAspira"
            +"ntesNivel(DTONivelesRanking dto, Long oidPeriodoActual):Salida");

        return dtoS;
    }

    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     */
    public DTOSalida buscarConcursosRanking(DTORanking dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.buscarConcursosRanking("
            +"DTORanking dto):Entrada");

        StringBuffer query = new StringBuffer();
        RecordSet r = null;
        DTOSalida resu = new DTOSalida();

        query.append(" SELECT concurso.oid_para_gral OID, ");
        query.append(" concurso.num_conc concurso, ");
        query.append(" concurso.num_vers,  ");
        query.append(" descripcionforma.val_i18n formacalculodescripcion, ");
        query.append(" descripcionbasecalculo.val_i18n  ");
        query.append(" basecalculodescripcion, ");
        query.append(" formacalculo.oid_form_calc,  ");
        query.append(" basecalculo.oid_base_calc, ");
        query.append(" concurso.diri_oid_diri ");
        
        //BELC300024444 - gPineda - 07/11/2006
        query.append(" , descripciontiporanking.VAL_I18N ");
        query.append(" , rak.TPRK_OID_TIPO_RANK ");
        
        query.append(" FROM inc_concu_param_gener concurso, ");
        query.append(" INC_PARAM_RANKI rak, ");
        query.append(" inc_base_calcu basecalculo, ");
        query.append(" inc_forma_calcu formacalculo, ");
        query.append(" v_gen_i18n_sicc descripcionforma, ");
        query.append(" v_gen_i18n_sicc descripcionbasecalculo, ");
        
        //BELC300024444 - gPineda - 07/11/2006
        query.append(" v_gen_i18n_sicc descripciontiporanking, ");
        
        query.append(" inc_concu_param_geren gerentes ");
        query.append(" WHERE concurso.BCAL_OID_BASE_CALC =  ");
        query.append(" basecalculo.oid_base_calc(+) ");
        query.append(
            " AND concurso.OID_PARA_GRAL = gerentes.COPA_OID_PARA_GRAL(+) ");
        query.append(" AND gerentes.FCAL_OID_FORM_CALC =  ");
        query.append(" formacalculo.OID_FORM_CALC(+) ");
        query.append(
            " AND descripcionforma.val_oid(+) = formacalculo.oid_form_calc ");
        query.append(" AND descripcionforma.attr_enti(+) = 'INC_FORMA_CALCU' ");
        query.append(" AND descripcionforma.attr_num_atri(+) = 1 ");
        query.append(" AND descripcionforma.idio_oid_idio(+) = " +
            dto.getOidIdioma());
        query.append(" AND descripcionbasecalculo.val_oid (+) =  ");
        query.append(" basecalculo.oid_base_calc ");
        query.append(" AND descripcionbasecalculo.attr_enti (+) =  ");
        query.append(" 'INC_BASE_CALCU' ");
        query.append(" AND descripcionbasecalculo.attr_num_atri (+) = 1 ");
        query.append(" AND descripcionbasecalculo.idio_oid_idio (+)= " +
            dto.getOidIdioma());
        query.append(" AND concurso.ind_acti = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND concurso.ind_rank = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND concurso.oid_para_gral = rak.COPA_OID_PARA_GRAL ");
        
        /* BELC300024444 - gPineda - 07/11/2006
        // vbongiov - 20/04/2006 - Inc DBLG500000590 y DBLG500000591
        query.append(" AND rak.TPRK_OID_TIPO_RANK = " + ConstantesINC.TIPO_RANKING_INTERACTIVO); */
        query.append(" AND concurso.OID_PARA_GRAL = gerentes.COPA_OID_PARA_GRAL (+) ");
        query.append(" AND ( rak.TPRK_OID_TIPO_RANK = " + ConstantesINC.TIPO_RANKING_INTERACTIVO );
        query.append("       OR ( rak.TPRK_OID_TIPO_RANK = " + ConstantesINC.TIPO_RANKING_EVOLUTIVO );
        query.append("            AND gerentes.FCAL_OID_FORM_CALC = " + ConstantesINC.VARIABLES_VENTA );
        query.append("          ) ");
        query.append("      ) ");
        query.append(" AND descripciontiporanking.val_oid (+) =  ");
        query.append(" rak.TPRK_OID_TIPO_RANK ");
        query.append(" AND descripciontiporanking.attr_enti (+) =  ");
        query.append(" 'INC_TIPO_RANKI' ");
        query.append(" AND descripciontiporanking.attr_num_atri (+) = 1 ");
        query.append(" AND descripciontiporanking.idio_oid_idio (+)= " +
            dto.getOidIdioma());
        
        

        if (dto.getBaseCalculo() != null) {
            query.append(" AND descripcionBaseCalculo.val_oid = " +
                dto.getBaseCalculo());
        }

        if (dto.getValorCalculado() != null) {
            query.append(" AND descripcionForma.val_oid = " +
                dto.getValorCalculado());
        }

        if (dto.getOidConcurso() != null) {
            query.append(" and concurso.oid_para_gral = " +
                dto.getOidConcurso());
        }

        try {
            BelcorpService bs = BelcorpService.getInstance();
            String queryPagina = UtilidadesPaginacion
                .armarQueryPaginacion(query.toString(),dto);

            r = bs.dbService.executeStaticQuery(queryPagina);
            UtilidadesLog.debug("resultado query: " + r);

            resu.setResultado(r);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        if ((r == null) || r.esVacio()) {
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("DAOMantenimientoRanking.buscarConcursosRanking("
            +"DTORanking dto):Salida");

        return resu;
    }

    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     */
    public DTOSalida recuperarNivelesPremios(DTOOIDPaginado dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.recuperarNivelesPremios("
            +"DTOOIDPaginado dto):Entrada");

        StringBuffer query = new StringBuffer();
        DTOSalida resu = new DTOSalida();
        RecordSet r = null;

        query.append(" SELECT niv.OID_PARA_NIVE_PREM OID, niv.NUM_NIVE, ");
        query.append(" niv.NUM_CANT_INIC_PUNT, ");
        query.append(" niv.NUM_CANT_FINA_PUNT, niv.NUM_ASPI ");
        query.append(
            " FROM INC_PARAM_NIVEL_PREMI niv, INC_PARAM_GENER_PREMI pre, ");
        query.append(" INC_CONCU_PARAM_GENER gen ");
        query.append(" WHERE gen.OID_PARA_GRAL = " + dto.getOid());
        query.append(" AND pre.COPA_OID_PARA_GRAL = gen.OID_PARA_GRAL ");
        query.append(
            " AND niv.PAGP_OID_PARA_GENE_PREM = pre.OID_PARA_GENE_PREM ");

        try {
            BelcorpService bs = BelcorpService.getInstance();
            String queryPagina = UtilidadesPaginacion
                .armarQueryPaginacion(query.toString(), dto);

            r = bs.dbService.executeStaticQuery(queryPagina);
            UtilidadesLog.debug("resultado query: " + r);

            resu.setResultado(r);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = CodigosError
                .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOMantenimientoRanking.recuperarNivelesPremios("
            +"DTOOIDPaginado dto):Salida");

        return resu;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   21/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public DTOSalida recuperarVentaRankingGerentes(DTOVentaRankingGerentes dto)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.recuperarVentaRankingGeren"
            +"tes(DTOVentaRankingGerentes dto):Entrada");
        UtilidadesLog.debug("Entro a recuperarVentaRankingGerentes con "
            +"DTOVentaRankingGerentes: " + dto);

        DTOSalida dtoSalida = new DTOSalida();
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        StringBuffer querySalida = null;
        BelcorpService bs = null;
        RecordSet resultado = new RecordSet();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            Long agrupacionGeneral = ConstantesINC
                .OID_AGRUPACION_GENERAL_RANKING;
            Long agrupacionSGV = ConstantesINC
                .OID_AGRUPACION_SUBGERENCIA_VTA_RANKING;
            Long agrupacionRegion = ConstantesINC
                .OID_AGRUPACION_REGION_RANKING;
            Long agrupacionZona = ConstantesINC
                .OID_AGRUPACION_ZONA_RANKING;
            Long agrupacionSeccion = ConstantesINC
                .OID_AGRUPACION_SECCION_RANKING;
            Long agrupacionTerritorio = ConstantesINC
                .OID_AGRUPACION_TERRITORIO_RANKING;

            // BELC300024452 - gPineda - 09/11/2006
            /*if (dto.getOidNivelAgrupacion().equals(agrupacionSGV) ||
                    dto.getOidNivelAgrupacion().equals(agrupacionGeneral)) {
                query = this.generarQuerySgv(dto);
            }*/
            if ( dto.getOidNivelAgrupacion().equals(agrupacionGeneral) ){
              query = this.generarQueryGen(dto);
            }
            if ( dto.getOidNivelAgrupacion().equals(agrupacionSGV) ){
              query = this.generarQuerySgv(dto);
            }

            if (dto.getOidNivelAgrupacion().equals(agrupacionRegion)) {
                query = this.generarQueryRegion(dto);
            }

            if (dto.getOidNivelAgrupacion().equals(agrupacionZona)) {
                query = this.generarQueryZona(dto);
            }

            if (dto.getOidNivelAgrupacion().equals(agrupacionSeccion)) {
                query = this.generarQuerySeccion(dto);
            }

            if (dto.getOidNivelAgrupacion().equals(agrupacionTerritorio)) {
                query = this.generarQueryTerritorio(dto);
            }

            // Limitacion y ordenacion para el arbol
            querySalida = this.generarQueryNroOcurrOrdenado(query,
                    dto.getOidNivelAgrupacion(), dto.getIndIncurrencias());

            rs = (RecordSet) bs.dbService.executeStaticQuery(querySalida
                .toString().toUpperCase());
            UtilidadesLog.debug("*El recordset es  " + rs);
            
            // BELC300024452 - gPineda - 09/11/2006
            if( ! rs.esVacio() ){
                AmbitoGeografico ambitoNuevo;                
                AmbitoGeografico ambitoAnterior = this.crearAmbitoGeografico(rs,0);
                int intOcurrenciasCumplidas = dto.getIndIncurrencias().intValue();
                
                resultado.setColumnIdentifiers( rs.getColumnIdentifiers() );
                
                //Para cada registro
                int tamanio = rs.getRowCount();
                for( int i = 0; i < tamanio; i++){
                  ambitoNuevo = this.crearAmbitoGeografico(rs,i);
                  if( ambitoNuevo.equalsAmbito( ambitoAnterior ) == true 
                      && intOcurrenciasCumplidas > 0){
                      //Si cambio el ambito, y quedan ocurrencias
                    resultado.addRow( rs.getRow(i) );
                    intOcurrenciasCumplidas--;
                  }else if( ambitoNuevo.equalsAmbito( ambitoAnterior) == false ){
                    //Si cambio el ambito
                    ambitoAnterior = ambitoNuevo;
                    resultado.addRow( rs.getRow(i) );
                    intOcurrenciasCumplidas = dto.getIndIncurrencias().intValue() - 1;    
                  }
                }
            }else{
              resultado = rs;
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //dtoSalida.setResultado(rs);
        dtoSalida.setResultado(resultado);
        UtilidadesLog.debug("******* Paso 7 : " + resultado);
        UtilidadesLog.info("DAOMantenimientoRanking.recuperarVentaRankingGeren"
            +"tes(DTOVentaRankingGerentes dto):Salida");

        return dtoSalida;
    }

    /**
         * Sistema:     Belcorp
         * Modulo:      INC
         * Fecha:       12/08/2005
         * @version     1.0
         * @autor       Viviana Bongiovanni
         */
    private StringBuffer generarQueryNroOcurrOrdenado(StringBuffer buf,
        Long agrupacion, Integer indOcurrencia) {
        UtilidadesLog.info("DAOMantenimientoRanking.generarQueryNroOcurrOrde"
            +"nado(StringBuffer buf, Long agrupacion, Integer indOcurrencia)"
            +":Entrada");

        // BELC300024452 - gPineda - 09/11/2006
        if (agrupacion.equals(ConstantesINC.OID_AGRUPACION_GENERAL_RANKING)) {
             buf.append(" ORDER BY total desc");
        }else if(agrupacion.equals(ConstantesINC.OID_AGRUPACION_SUBGERENCIA_VTA_RANKING)) {
             buf.append(" ORDER BY oid_subg_vent, total desc");
        }else if (agrupacion.equals(ConstantesINC.OID_AGRUPACION_REGION_RANKING)) {
             buf.append(" ORDER BY oid_subg_vent, oid_regi, total  desc");
        }else if (agrupacion.equals(ConstantesINC.OID_AGRUPACION_ZONA_RANKING)) {
             buf.append(" ORDER BY oid_subg_vent, oid_regi, oid_zona, total  desc");
        }else if (agrupacion.equals(ConstantesINC.OID_AGRUPACION_SECCION_RANKING) ||
            agrupacion.equals(ConstantesINC.OID_AGRUPACION_TERRITORIO_RANKING)) {
             buf.append(" ORDER BY oid_subg_vent, oid_regi, oid_zona, oid_secc, total  desc");
        }

        UtilidadesLog.info("DAOMantenimientoRanking.generarQueryNroOcurr"
            +"Ordenado(StringBuffer buf, Long agrupacion, Integer indOcurren"
            +"cia):Salida");

        return buf;
    }

    private StringBuffer generarQuerySgv(DTOVentaRankingGerentes dto) {
        UtilidadesLog.info("DAOMantenimientoRanking.generarQuerySgv(DTOVenta"
            +"RankingGerentes dto):Entrada");

        StringBuffer query = new StringBuffer();

        // BELC300024444 - gPineda - 07/11/2006
        query.append(
            " SELECT ROWNUM, sub.oid_subg_vent, sub.des_subg_vent,vrg.clie_oid_clie,  ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape2, '') AS nombre, ");
        query.append(" (  NVL (imp_vent, 0) ");
        query.append(" + NVL (num_acti_inic, 0) ");
        query.append(" + NVL (num_acti_fina, 0) ");
        query.append(" + NVL (num_pedi, 0) ");
        query.append(" + NVL (val_porc_acti, 0) ");
        query.append(" + NVL (val_cons, 0) ");
        query.append(" + NVL (imp_ingr, 0) ");
        query.append(" + NVL (imp_rein, 0) ");
        query.append(" + NVL (imp_egre, 0) ");
        query.append(" + NVL (val_entr, 0) ");
        query.append(" + NVL (val_reci, 0) ");
        query.append(" + NVL (imp_capi, 0) ");
        query.append(" + NVL (val_ppu, 0) ");
        query.append(" + NVL (val_pvp, 0) ");
        query.append(" + NVL (val_pup, 0) ");
        query.append(" + NVL (val_pop, 0) ");
        query.append(" + NVL (imp_rete, 0) ");
        query.append(" + NVL (imp_cobr, 0) ");
        query.append(" + NVL (val_rota, 0) ");
        query.append(" ) AS total, ");
        query.append(" ( NVL (imp_vent, 0)) imp_vent, ");
        query.append("  ( NVL (num_acti_inic, 0)) num_acti_inic, ");
        query.append("  ( NVL (num_acti_fina, 0)) num_acti_fina, ");
        query.append("  ( NVL (num_pedi, 0)) num_pedi, ");
        query.append("  ( NVL (val_porc_acti, 0)) val_porc_acti, ");
        query.append("  ( NVL (val_cons, 0)) val_cons, ");
        query.append("  ( NVL (imp_ingr, 0)) imp_ingr, ");
        query.append("  ( NVL (imp_rein, 0)) imp_rein, ");
        query.append("  ( NVL (imp_egre, 0)) imp_egre, ");
        query.append("  ( NVL (val_entr, 0)) val_entr, ");
        query.append("  ( NVL (val_reci, 0)) val_reci, ");
        query.append("  ( NVL (imp_capi, 0)) imp_capi, ");
        query.append("  ( NVL (val_ppu, 0)) val_ppu, ");
        query.append("  ( NVL (val_pvp, 0)) val_pvp, ");
        query.append("  ( NVL (val_pup, 0)) val_pup, ");
        query.append("  ( NVL (val_pop, 0)) val_pop, ");
        query.append("  ( NVL (imp_rete, 0)) imp_rete, ");
        query.append("  ( NVL (imp_cobr, 0)) imp_cobr, ");
        query.append("  ( NVL (val_rota, 0)) val_rota  ");
        query.append(" FROM inc_concu_param_gener cpg, ");
        query.append(" inc_venta_ranki_geren vrg, ");
        query.append(" mae_clien cli, ");
        query.append(" zon_sub_geren_venta sub ");
        query.append(" WHERE vrg.copa_oid_para_gral = cpg.oid_para_gral ");
        query.append(" AND vrg.clie_oid_clie = cli.oid_clie ");
        query.append(" AND vrg.zsgv_oid_subg_vent = sub.oid_subg_vent ");
        query.append(" AND cpg.pais_oid_pais = " + dto.getOidPais());
        query.append(" AND vrg.copa_oid_para_gral = " + dto.getOidConcurso());

/*        if (dto.getOidSGV() != null) {
            query.append(" AND sub.oid_subg_vent IN " +
                generarExprConjuntoSQL(dto.getOidSGV()));
        }*/

        //query.append(" AND sub.clie_oid_clie = vrg.clie_oid_clie ");
        /*query.append(" GROUP BY sub.oid_subg_vent, ");
        query.append(" sub.des_subg_vent, ");
        query.append(" cli.oid_clie, ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', '') ");
        query.append(" || NVL (cli.val_ape2, '') ");
        query.append(" ORDER BY total DESC ");*/
        Long[] vUnidAdm = dto.getOidSGV();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZSGV_OID_SUBG_VENT", vUnidAdm ) );
        }
        

        UtilidadesLog.info("DAOMantenimientoRanking.generarQuerySgv(DTOVenta"
            +"RankingGerentes dto):Salida");

        return query;
    }

    private StringBuffer generarQueryRegion(DTOVentaRankingGerentes dto) {
        UtilidadesLog.info("DAOMantenimientoRanking.generarQueryRegion(DTOVent"
            +"aRankingGerentes dto):Entrada");

        StringBuffer query = new StringBuffer();

        // BELC300024444 - gPineda - 07/11/2006
        query.append(" SELECT  ROWNUM, sub.oid_subg_vent, sub.des_subg_vent, ");
        query.append(" reg.oid_regi, reg.des_regi,vrg.clie_oid_clie, ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape2, '') AS nombre, ");
        query.append("  (  NVL (imp_vent, 0) ");
        query.append(" + NVL (num_acti_inic, 0) ");
        query.append(" + NVL (num_acti_fina, 0) ");
        query.append(" + NVL (num_pedi, 0) ");
        query.append(" + NVL (val_porc_acti, 0) ");
        query.append(" + NVL (val_cons, 0) ");
        query.append(" + NVL (imp_ingr, 0) ");
        query.append(" + NVL (imp_rein, 0) ");
        query.append(" + NVL (imp_egre, 0) ");
        query.append(" + NVL (val_entr, 0) ");
        query.append(" + NVL (val_reci, 0) ");
        query.append(" + NVL (imp_capi, 0) ");
        query.append(" + NVL (val_ppu, 0) ");
        query.append(" + NVL (val_pvp, 0) ");
        query.append(" + NVL (val_pup, 0) ");
        query.append(" + NVL (val_pop, 0) ");
        query.append(" + NVL (imp_rete, 0) ");
        query.append(" + NVL (imp_cobr, 0) ");
        query.append(" + NVL (val_rota, 0) ");
        query.append(" ) AS total, ");
        query.append("  ( NVL (imp_vent, 0)) imp_vent, ");
        query.append("  ( NVL (num_acti_inic, 0)) num_acti_inic, ");
        query.append("  ( NVL (num_acti_fina, 0)) num_acti_fina, ");
        query.append("  ( NVL (num_pedi, 0)) num_pedi, ");
        query.append("  ( NVL (val_porc_acti, 0)) val_porc_acti, ");
        query.append("  ( NVL (val_cons, 0)) val_cons, ");
        query.append("  ( NVL (imp_ingr, 0)) imp_ingr, ");
        query.append("  ( NVL (imp_rein, 0)) imp_rein, ");
        query.append("  ( NVL (imp_egre, 0)) imp_egre, ");
        query.append("  ( NVL (val_entr, 0)) val_entr, ");
        query.append("  ( NVL (val_reci, 0)) val_reci, ");
        query.append("  ( NVL (imp_capi, 0)) imp_capi, ");
        query.append("  ( NVL (val_ppu, 0)) val_ppu, ");
        query.append("  ( NVL (val_pvp, 0)) val_pvp, ");
        query.append("  ( NVL (val_pup, 0)) val_pup, ");
        query.append("  ( NVL (val_pop, 0)) val_pop, ");
        query.append("  ( NVL (imp_rete, 0)) imp_rete, ");
        query.append("  ( NVL (imp_cobr, 0)) imp_cobr, ");
        query.append("  ( NVL (val_rota, 0)) val_rota  ");
        query.append(" FROM inc_concu_param_gener cpg, ");
        query.append(" inc_venta_ranki_geren vrg, ");
        query.append(" mae_clien cli, ");
        query.append(" zon_sub_geren_venta sub, ");
        query.append(" zon_regio reg ");
        query.append(" WHERE vrg.copa_oid_para_gral = cpg.oid_para_gral ");
        query.append(" AND vrg.clie_oid_clie = cli.oid_clie ");
        query.append(" and vrg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");
        query.append(" AND vrg.zorg_oid_regi = reg.oid_regi ");
        query.append(" AND cpg.pais_oid_pais = " + dto.getOidPais());
        query.append(" AND vrg.copa_oid_para_gral = " + dto.getOidConcurso());
        //query.append(" AND reg.clie_oid_clie = vrg.clie_oid_clie ");
        /*query.append(" AND reg.oid_regi IN " +
            generarExprConjuntoSQL(dto.getOidRegion()));*/
        /*query.append(
            " GROUP BY sub.oid_subg_vent, sub.des_subg_vent,reg.oid_regi, ");
        query.append(" reg.des_regi, ");
        query.append(" cli.oid_clie, ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', '') ");
        query.append(" || NVL (cli.val_ape2, '') ");
        query.append(" ORDER BY total DESC ");*/
        Long[] vUnidAdm = dto.getOidSGV();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZSGV_OID_SUBG_VENT", vUnidAdm ) );
        }
        vUnidAdm = dto.getOidRegion();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZORG_OID_REGI", vUnidAdm ) );
        }

        UtilidadesLog.info("DAOMantenimientoRanking.generarQueryRegion(DTOVent"
            +"aRankingGerentes dto):Salida");

        return query;
    }

    private StringBuffer generarQueryZona(DTOVentaRankingGerentes dto) {
        UtilidadesLog.info("DAOMantenimientoRanking.generarQueryZona(DTOVenta"
            +"RankingGerentes dto):entrada");

        StringBuffer query = new StringBuffer();

        query.append(" SELECT ROWNUM, sub.oid_subg_vent, sub.des_subg_vent, ");
        query.append(" reg.oid_regi, reg.des_regi, zona.oid_zona,  ");
        query.append(" zona.des_zona,vrg.clie_oid_clie,  ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape2, '') AS nombre, ");
        query.append("  (  NVL (imp_vent, 0) ");
        query.append(" + NVL (num_acti_inic, 0) ");
        query.append(" + NVL (num_acti_fina, 0) ");
        query.append(" + NVL (num_pedi, 0) ");
        query.append(" + NVL (val_porc_acti, 0) ");
        query.append(" + NVL (val_cons, 0) ");
        query.append(" + NVL (imp_ingr, 0) ");
        query.append(" + NVL (imp_rein, 0) ");
        query.append(" + NVL (imp_egre, 0) ");
        query.append(" + NVL (val_entr, 0) ");
        query.append(" + NVL (val_reci, 0) ");
        query.append(" + NVL (imp_capi, 0) ");
        query.append(" + NVL (val_ppu, 0) ");
        query.append(" + NVL (val_pvp, 0) ");
        query.append(" + NVL (val_pup, 0) ");
        query.append(" + NVL (val_pop, 0) ");
        query.append(" + NVL (imp_rete, 0) ");
        query.append(" + NVL (imp_cobr, 0) ");
        query.append(" + NVL (val_rota, 0) ");
        query.append(" ) AS total, ");
        query.append("  ( NVL (imp_vent, 0)) imp_vent, ");
        query.append("  ( NVL (num_acti_inic, 0)) num_acti_inic, ");
        query.append("  ( NVL (num_acti_fina, 0)) num_acti_fina, ");
        query.append("  ( NVL (num_pedi, 0)) num_pedi, ");
        query.append("  ( NVL (val_porc_acti, 0)) val_porc_acti, ");
        query.append("  ( NVL (val_cons, 0)) val_cons, ");
        query.append("  ( NVL (imp_ingr, 0)) imp_ingr, ");
        query.append("  ( NVL (imp_rein, 0)) imp_rein, ");
        query.append("  ( NVL (imp_egre, 0)) imp_egre, ");
        query.append("  ( NVL (val_entr, 0)) val_entr, ");
        query.append("  ( NVL (val_reci, 0)) val_reci, ");
        query.append("  ( NVL (imp_capi, 0)) imp_capi, ");
        query.append("  ( NVL (val_ppu, 0)) val_ppu, ");
        query.append("  ( NVL (val_pvp, 0)) val_pvp, ");
        query.append("  ( NVL (val_pup, 0)) val_pup, ");
        query.append("  ( NVL (val_pop, 0)) val_pop, ");
        query.append("  ( NVL (imp_rete, 0)) imp_rete, ");
        query.append("  ( NVL (imp_cobr, 0)) imp_cobr, ");
        query.append("  ( NVL (val_rota, 0)) val_rota  ");
        query.append("  FROM inc_concu_param_gener cpg, ");
        query.append(" inc_venta_ranki_geren vrg, ");
        query.append(" mae_clien cli, ");
        query.append(" zon_zona zona, ");
        query.append(" zon_sub_geren_venta sub, ");
        query.append(" zon_regio reg ");
        query.append(" WHERE vrg.copa_oid_para_gral = cpg.oid_para_gral ");
        query.append(" AND vrg.clie_oid_clie = cli.oid_clie ");
        query.append(" and vrg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");
        query.append(" AND vrg.zorg_oid_regi = reg.oid_regi ");
        query.append(" AND vrg.zzon_oid_zona = zona.oid_zona ");
        //query.append(" and vrg.CLIE_OID_CLIE = zona.CLIE_OID_CLIE ");
        query.append(" AND cpg.pais_oid_pais = " + dto.getOidPais());
        query.append(" AND vrg.copa_oid_para_gral = " + dto.getOidConcurso());
        /*query.append(" AND zona.oid_zona IN " +
            generarExprConjuntoSQL(dto.getOidZona()));*/
        /*query.append(
            " GROUP BY sub.oid_subg_vent, sub.des_subg_vent,reg.oid_regi, ");
        query.append(" reg.des_regi, ");
        query.append(" cli.oid_clie, ");
        query.append(" zona.oid_zona, ");
        query.append(" zona.des_zona, ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', '') ");
        query.append(" || NVL (cli.val_ape2, '') ");
        query.append(" ORDER BY total DESC ");*/
        Long[] vUnidAdm = dto.getOidSGV();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZSGV_OID_SUBG_VENT", vUnidAdm ) );
        }
        vUnidAdm = dto.getOidRegion();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZORG_OID_REGI", vUnidAdm ) );
        }
        vUnidAdm = dto.getOidZona();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZZON_OID_ZONA", vUnidAdm ) );
        }

        UtilidadesLog.info("DAOMantenimientoRanking.generarQueryZona(DTOVenta"
            +"RankingGerentes dto):Salida");

        return query;
    }

    private StringBuffer generarQuerySeccion(DTOVentaRankingGerentes dto) {
        UtilidadesLog.info("DAOMantenimientoRanking.generarQuerySeccion(DTO"
            +"VentaRankingGerentes dto):entrada");

        StringBuffer query = new StringBuffer();

        // BELC300024444 - gPineda - 07/11/2006
        query.append(" SELECT ROWNUM, sub.oid_subg_vent, sub.des_subg_vent, ");
        query.append(" reg.oid_regi, reg.des_regi, zona.oid_zona, ");
        query.append(" zona.des_zona, secc.oid_secc, secc.DES_SECCI, ");
        query.append(" vrg.clie_oid_clie,  ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape2, '') AS nombre, ");
        query.append("  (  NVL (imp_vent, 0) ");
        query.append(" + NVL (num_acti_inic, 0) ");
        query.append(" + NVL (num_acti_fina, 0) ");
        query.append(" + NVL (num_pedi, 0) ");
        query.append(" + NVL (val_porc_acti, 0) ");
        query.append(" + NVL (val_cons, 0) ");
        query.append(" + NVL (imp_ingr, 0) ");
        query.append(" + NVL (imp_rein, 0) ");
        query.append(" + NVL (imp_egre, 0) ");
        query.append(" + NVL (val_entr, 0) ");
        query.append(" + NVL (val_reci, 0) ");
        query.append(" + NVL (imp_capi, 0) ");
        query.append(" + NVL (val_ppu, 0) ");
        query.append(" + NVL (val_pvp, 0) ");
        query.append(" + NVL (val_pup, 0) ");
        query.append(" + NVL (val_pop, 0) ");
        query.append(" + NVL (imp_rete, 0) ");
        query.append(" + NVL (imp_cobr, 0) ");
        query.append(" + NVL (val_rota, 0) ");
        query.append(" ) AS total, ");
        query.append("  ( NVL (imp_vent, 0)) imp_vent, ");
        query.append("  ( NVL (num_acti_inic, 0)) num_acti_inic, ");
        query.append("  ( NVL (num_acti_fina, 0)) num_acti_fina, ");
        query.append("  ( NVL (num_pedi, 0)) num_pedi, ");
        query.append("  ( NVL (val_porc_acti, 0)) val_porc_acti, ");
        query.append("  ( NVL (val_cons, 0)) val_cons, ");
        query.append("  ( NVL (imp_ingr, 0)) imp_ingr, ");
        query.append("  ( NVL (imp_rein, 0)) imp_rein, ");
        query.append("  ( NVL (imp_egre, 0)) imp_egre, ");
        query.append("  ( NVL (val_entr, 0)) val_entr, ");
        query.append("  ( NVL (val_reci, 0)) val_reci, ");
        query.append("  ( NVL (imp_capi, 0)) imp_capi, ");
        query.append("  ( NVL (val_ppu, 0)) val_ppu, ");
        query.append("  ( NVL (val_pvp, 0)) val_pvp, ");
        query.append("  ( NVL (val_pup, 0)) val_pup, ");
        query.append("  ( NVL (val_pop, 0)) val_pop, ");
        query.append("  ( NVL (imp_rete, 0)) imp_rete, ");
        query.append("  ( NVL (imp_cobr, 0)) imp_cobr, ");
        query.append("  ( NVL (val_rota, 0)) val_rota  ");
        query.append("  FROM inc_concu_param_gener cpg, ");
        query.append(" inc_venta_ranki_geren vrg, ");
        query.append(" mae_clien cli, ");
        query.append(" zon_zona zona, ");
        query.append(" zon_sub_geren_venta sub, ");
        query.append(" zon_regio reg, ");
        query.append(" zon_secci secc ");
        query.append(" WHERE vrg.copa_oid_para_gral = cpg.oid_para_gral ");
        query.append(" AND vrg.clie_oid_clie = cli.oid_clie ");
        query.append(" and vrg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");
        query.append(" AND vrg.zorg_oid_regi = reg.oid_regi ");
        query.append(" AND vrg.zzon_oid_zona = zona.oid_zona ");
        query.append(" and vrg.ZSCC_OID_SECC = secc.OID_SECC ");
        //query.append(" and vrg.CLIE_OID_CLIE = secc.CLIE_OID_CLIE ");
        query.append(" AND cpg.pais_oid_pais = " + dto.getOidPais());
        query.append(" AND vrg.copa_oid_para_gral = " + dto.getOidConcurso());
        /*query.append(" and secc.OID_SECC in" +
            generarExprConjuntoSQL(dto.getOidSeccion()));*/
        /*query.append(
            " GROUP BY sub.oid_subg_vent, sub.des_subg_vent,reg.oid_regi, ");
        query.append(" reg.des_regi, ");
        query.append(" secc.OID_SECC, ");
        query.append(" secc.DES_SECCI, ");
        query.append(" zona.oid_zona, ");
        query.append(" zona.des_zona, ");
        query.append(" cli.oid_clie, ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', '') ");
        query.append(" || NVL (cli.val_ape2, '') ");
        query.append(" ORDER BY total DESC ");*/
        Long[] vUnidAdm = dto.getOidSGV();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZSGV_OID_SUBG_VENT", vUnidAdm ) );
        }
        vUnidAdm = dto.getOidRegion();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZORG_OID_REGI", vUnidAdm ) );
        }
        vUnidAdm = dto.getOidZona();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZZON_OID_ZONA", vUnidAdm ) );
        }
        vUnidAdm = dto.getOidSeccion();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZSCC_OID_SECC", vUnidAdm ) );
        }

        UtilidadesLog.info("DAOMantenimientoRanking.generarQuerySeccion(DTOVen"
            +"taRankingGerentes dto):Salida");

        return query;
    }

    private StringBuffer generarQueryTerritorio(DTOVentaRankingGerentes dto) {
        UtilidadesLog.info("DAOMantenimientoRanking.generarQueryTerritorio(DTO"
            +"VentaRankingGerentes dto):Entrada");

        StringBuffer query = new StringBuffer();

        // BELC300024444 - gPineda - 07/11/2006
        query.append(" SELECT ROWNUM, sub.oid_subg_vent, sub.des_subg_vent, ");
        query.append(" reg.oid_regi, reg.des_regi, zona.oid_zona, ");
        query.append(" zona.des_zona, secc.OID_SECC, secc.DES_SECCI, ");
        query.append(" vrg.clie_oid_clie,  ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape2, '') AS nombre, ");
        query.append("  (  NVL (imp_vent, 0) ");
        query.append(" + NVL (num_acti_inic, 0) ");
        query.append(" + NVL (num_acti_fina, 0) ");
        query.append(" + NVL (num_pedi, 0) ");
        query.append(" + NVL (val_porc_acti, 0) ");
        query.append(" + NVL (val_cons, 0) ");
        query.append(" + NVL (imp_ingr, 0) ");
        query.append(" + NVL (imp_rein, 0) ");
        query.append(" + NVL (imp_egre, 0) ");
        query.append(" + NVL (val_entr, 0) ");
        query.append(" + NVL (val_reci, 0) ");
        query.append(" + NVL (imp_capi, 0) ");
        query.append(" + NVL (val_ppu, 0) ");
        query.append(" + NVL (val_pvp, 0) ");
        query.append(" + NVL (val_pup, 0) ");
        query.append(" + NVL (val_pop, 0) ");
        query.append(" + NVL (imp_rete, 0) ");
        query.append(" + NVL (imp_cobr, 0) ");
        query.append(" + NVL (val_rota, 0) ");
        query.append(" ) AS total, ");
        query.append("  ( NVL (imp_vent, 0)) imp_vent, ");
        query.append("  ( NVL (num_acti_inic, 0)) num_acti_inic, ");
        query.append("  ( NVL (num_acti_fina, 0)) num_acti_fina, ");
        query.append("  ( NVL (num_pedi, 0)) num_pedi, ");
        query.append("  ( NVL (val_porc_acti, 0)) val_porc_acti, ");
        query.append("  ( NVL (val_cons, 0)) val_cons, ");
        query.append("  ( NVL (imp_ingr, 0)) imp_ingr, ");
        query.append("  ( NVL (imp_rein, 0)) imp_rein, ");
        query.append("  ( NVL (imp_egre, 0)) imp_egre, ");
        query.append("  ( NVL (val_entr, 0)) val_entr, ");
        query.append("  ( NVL (val_reci, 0)) val_reci, ");
        query.append("  ( NVL (imp_capi, 0)) imp_capi, ");
        query.append("  ( NVL (val_ppu, 0)) val_ppu, ");
        query.append("  ( NVL (val_pvp, 0)) val_pvp, ");
        query.append("  ( NVL (val_pup, 0)) val_pup, ");
        query.append("  ( NVL (val_pop, 0)) val_pop, ");
        query.append("  ( NVL (imp_rete, 0)) imp_rete, ");
        query.append("  ( NVL (imp_cobr, 0)) imp_cobr, ");
        query.append("  ( NVL (val_rota, 0)) val_rota  ");
        query.append("  FROM inc_concu_param_gener cpg, ");
        query.append(" inc_venta_ranki_geren vrg, ");
        query.append(" mae_clien cli, ");
        query.append(" zon_zona zona, ");
        query.append(" zon_sub_geren_venta sub, ");
        query.append(" zon_regio reg, ");
        query.append(" zon_secci secc, ");
        query.append(" zon_terri_admin terri_admin ");
        query.append(" WHERE vrg.copa_oid_para_gral = cpg.oid_para_gral ");
        query.append(" AND vrg.clie_oid_clie = cli.oid_clie ");
        query.append(" and vrg.ZSGV_OID_SUBG_VENT = sub.OID_SUBG_VENT ");
        query.append(" AND vrg.zorg_oid_regi = reg.oid_regi ");
        query.append(" AND vrg.zzon_oid_zona = zona.oid_zona ");
        query.append(" and vrg.ZSCC_OID_SECC = secc.OID_SECC ");
        //query.append(" and vrg.CLIE_OID_CLIE = secc.CLIE_OID_CLIE ");
        query.append(" AND cpg.pais_oid_pais = " + dto.getOidPais());
        query.append(" AND vrg.copa_oid_para_gral = " + dto.getOidConcurso());
        /*query.append(" and secc.OID_SECC in" +
            generarExprConjuntoSQL(dto.getOidTerritorio()));
        */   
        Long[] vUnidAdm = dto.getOidSGV();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZSGV_OID_SUBG_VENT", vUnidAdm ) );
        }
        vUnidAdm = dto.getOidRegion();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZORG_OID_REGI", vUnidAdm ) );
        }
        vUnidAdm = dto.getOidZona();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZZON_OID_ZONA", vUnidAdm ) );
        }
        vUnidAdm = dto.getOidSeccion();
        if( vUnidAdm != null && vUnidAdm.length > 0 ){
          query.append(" AND " + this.generarExprConjuntoSQL("vrg.ZSCC_OID_SECC", vUnidAdm ) );
        }
        
        /*query.append(
            " GROUP BY sub.oid_subg_vent, sub.des_subg_vent,reg.oid_regi, ");
        query.append(" reg.des_regi, ");
        query.append(" secc.OID_SECC, ");
        query.append(" secc.DES_SECCI, ");
        query.append(" zona.oid_zona, ");
        query.append(" zona.des_zona, ");
        query.append(" cli.oid_clie, ");
        query.append(" NVL (cli.val_nom1, '') ");
        query.append(" || DECODE (cli.val_nom1, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_nom2, '') ");
        query.append(" || DECODE (cli.val_nom2, NULL, '', ' ') ");
        query.append(" || NVL (cli.val_ape1, '') ");
        query.append(" || DECODE (cli.val_ape1, NULL, '', '') ");
        query.append(" || NVL (cli.val_ape2, '') ");
        query.append(" ORDER BY total DESC ");*/

        UtilidadesLog.info("DAOMantenimientoRanking.generarQueryTerritorio(DTO"
            +"VentaRankingGerentes dto):Salida");

        return query;
    }

    /**
     * Función auxiliar que genera un String con la expresión (?,?,?)
     * que representa a los conjuntos de valores en SQL
     * a partir del array de Long recibido como parámetro
     * @param Long[] con valores del conjunto
     * @return String con el formato antedicho
     * @author Diego Morello
     */
    private String generarExprConjuntoSQL(Long[] valores) {
        UtilidadesLog.info("DAOMantenimientoRanking.generarExprConjuntoSQL"
            +"(Long[] valores):Entrada");

        StringBuffer sb = new StringBuffer();
        sb.append('(');

        for (int i = 0; i < valores.length; i++) {
            sb.append(valores[i]);

            if (i < (valores.length - 1)) {
                sb.append(',');
            }
        }

        sb.append(')');

        UtilidadesLog.info("DAOMantenimientoRanking.generarExprConjuntoSQL"
            +"(Long[] valores):Salida");

        return sb.toString();
    }
    
    /**
     * Función auxiliar que genera un String con la expresión: 
     * [nombre campo] IN (?,?,?) [ OR [nombre campo] IN (?,?,?) ]
     * a partir del array de Long recibido como parámetro
     * @param String con el nombre del campo
     * @param Long[] con valores del conjunto
     * @return String con el formato antedicho
     * @author g
     */
      private String generarExprConjuntoSQL(String campo, Long[] valores) {
        UtilidadesLog.info("DAOMantenimientoRanking.generarExprConjuntoSQL"
            +"(String campo, Long[] valores):Entrada");

        StringBuffer sb = new StringBuffer();
        
        sb.append("( " + campo + " IN (");

        for (int i = 0; i < valores.length; i++) {
        
            if( i % 1000 == 0 && i != 0 ){
                sb.append(") OR " + campo + " IN (");    
            }
            
            sb.append(valores[i]);

            if (i < (valores.length - 1) && i % 1000 < 999 ) {
                sb.append(',');
            }
            
        }

        sb.append(") )");

        UtilidadesLog.info("DAOMantenimientoRanking.generarExprConjuntoSQL"
            +"(String campo, Long[] valores):Salida");

        return sb.toString();
    }
    
    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     */
    public DTOSalida recuperarResultadosRanking(Long oidConcurso)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.recuperarResultadosRanking"
            +"(Long oidConcurso):Entrada");

        StringBuffer query = new StringBuffer();

        query.append(" SELECT   pnp.oid_para_nive_prem OID,  ");
        query.append(" pnp.num_nive AS numeronivel, ");
        query.append(" pnp.num_cant_inic_punt cantidadinicial, ");
        query.append(" pnp.num_cant_fina_punt cantidadfinal, ");
        query.append(" NVL (lpa.num_prem, ");
        query.append(" NVL (pm.num_prem, NVL (pd.num_prem, pp.num_prem)) ");
        query.append(" ) numeropremio, ");
        query.append(" pnp.num_aspi, ");
        query.append("  CASE ");
        query.append(" WHEN (tp.oid_tipo_prem = 1) ");
        query.append(" THEN pm.oid_prem_mone ");
        query.append(" ELSE CASE ");
        query.append(" WHEN (tp.oid_tipo_prem = 2) ");
        query.append(" THEN pa.oid_prem_arti ");
        query.append(" ELSE CASE ");
        query.append(" WHEN (tp.oid_tipo_prem = 3) ");
        query.append(" THEN pd.oid_prem_desc ");
        query.append(" ELSE pp.oid_prem_punt ");
        query.append(" END ");
        query.append("  END ");
        query.append(" END oidPremio, ");
        query.append(" tp.oid_tipo_prem ");
        query.append(" FROM inc_concu_param_gener pg, ");
        query.append(" inc_param_gener_premi pgp, ");
        query.append(" inc_param_nivel_premi pnp, ");
        query.append(" inc_premi_artic pa, ");
        query.append(" inc_lote_premi_artic lpa, ");
        query.append(" inc_premi_monet pm, ");
        query.append(" inc_premi_descu pd, ");
        query.append(" inc_premi_punto pp, ");
        query.append(" inc_tipo_premi tp ");
        query.append(" WHERE ");
        query.append(" pg.oid_para_gral = " + oidConcurso);
        query.append(" AND pgp.copa_oid_para_gral = pg.oid_para_gral ");
        query.append(
            " AND pgp.oid_para_gene_prem = pnp.pagp_oid_para_gene_prem ");
        query.append(
            " AND pnp.oid_para_nive_prem = pa.panp_oid_para_nive_prem(+) ");
        query.append(" AND lpa.prar_oid_prem_arti(+) = pa.oid_prem_arti ");
        query.append(
            " AND pnp.oid_para_nive_prem = pm.panp_oid_para_nive_prem(+) ");
        query.append(" AND pnp.oid_para_nive_prem =  ");
        query.append(" pd.oid_para_nive_prem(+) ");
        query.append(
            " AND pnp.oid_para_nive_prem = pp.panp_oid_para_nive_prem(+) ");
        query.append(" AND pnp.tpre_oid_tipo_prem = tp.oid_tipo_prem ");
        query.append(" ORDER BY numeronivel DESC ");

        UtilidadesLog.info("DAOMantenimientoRanking.recuperarResultadosRanking"
            +"(Long oidConcurso):Salida");

        return this.executeSelectQuery(query);
    }

    /**
     *
     * @fecha 21/07/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @author Mariano Rodriguez
     * @param dto
     */
    private DTOSalida executeSelectQuery(StringBuffer query)
        throws MareException {
        UtilidadesLog.info("DAOMantenimientoRanking.executeSelectQuery(String"
            +"Buffer query):Entrada");

        RecordSet rs = new RecordSet();
        BelcorpService bs;
        DTOSalida dtoSalida = new DTOSalida();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoRanking.executeSelectQuery(String"
            +"Buffer query):Salida");

        return dtoSalida;
    }
    
    /**
   * genera la query de busqueda por criterio General
   * Cambio BELC300024452 - 09/11/2006
   * @return StringBuffer con query
   * @param dto
   * @author gPineda
   */
    private StringBuffer generarQueryGen(DTOVentaRankingGerentes dto){
      UtilidadesLog.info("DAOMantenimientoRanking.generarQueryGen(DTOVentaRankingGerentes dto):Entrada");
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT ROWNUM, vrg.clie_oid_clie,  ");
      query.append("    NVL (cli.val_nom1, '')  ");
      query.append("    || DECODE (cli.val_nom1, NULL, '', ' ')  ");
      query.append("    || NVL (cli.val_nom2, '')  ");
      query.append("    || DECODE (cli.val_nom2, NULL, '', ' ')  ");
      query.append("    || NVL (cli.val_ape1, '')  ");
      query.append("    || DECODE (cli.val_ape1, NULL, '', ' ')  ");
      query.append("    || NVL (cli.val_ape2, '') AS nombre,  ");
      query.append("    (  NVL (imp_vent, 0)  ");
      query.append("    + NVL (num_acti_inic, 0)  ");
      query.append("    + NVL (num_acti_fina, 0)  ");
      query.append("    + NVL (num_pedi, 0)  ");
      query.append("    + NVL (val_porc_acti, 0)  ");
      query.append("    + NVL (val_cons, 0)  ");
      query.append("    + NVL (imp_ingr, 0)  ");
      query.append("    + NVL (imp_rein, 0)  ");
      query.append("    + NVL (imp_egre, 0)  ");
      query.append("    + NVL (val_entr, 0)  ");
      query.append("    + NVL (val_reci, 0)  ");
      query.append("    + NVL (imp_capi, 0)  ");
      query.append("    + NVL (val_ppu, 0)  ");
      query.append("    + NVL (val_pvp, 0)  ");
      query.append("    + NVL (val_pup, 0)  ");
      query.append("    + NVL (val_pop, 0)  ");
      query.append("    + NVL (imp_rete, 0)  ");
      query.append("    + NVL (imp_cobr, 0)  ");
      query.append("    + NVL (val_rota, 0)  ");
      query.append("    ) AS total,  ");
      query.append("    ( NVL (imp_vent, 0)) imp_vent,  ");
      query.append("    ( NVL (num_acti_inic, 0)) num_acti_inic,  ");
      query.append("    ( NVL (num_acti_fina, 0)) num_acti_fina,  ");
      query.append("    ( NVL (num_pedi, 0)) num_pedi,  ");
      query.append("    ( NVL (val_porc_acti, 0)) val_porc_acti,  ");
      query.append("    ( NVL (val_cons, 0)) val_cons,  ");
      query.append("    ( NVL (imp_ingr, 0)) imp_ingr,  ");
      query.append("    ( NVL (imp_rein, 0)) imp_rein,  ");
      query.append("    ( NVL (imp_egre, 0)) imp_egre,  ");
      query.append("    ( NVL (val_entr, 0)) val_entr,  ");
      query.append("    ( NVL (val_reci, 0)) val_reci,  ");
      query.append("    ( NVL (imp_capi, 0)) imp_capi,  ");
      query.append("    ( NVL (val_ppu, 0)) val_ppu,  ");
      query.append("    ( NVL (val_pvp, 0)) val_pvp,  ");
      query.append("    ( NVL (val_pup, 0)) val_pup,  ");
      query.append("    ( NVL (val_pop, 0)) val_pop,  ");
      query.append("    ( NVL (imp_rete, 0)) imp_rete,  ");
      query.append("    ( NVL (imp_cobr, 0)) imp_cobr,  ");
      query.append("    ( NVL (val_rota, 0)) val_rota   ");
      query.append("    FROM inc_concu_param_gener cpg,  ");
      query.append("    inc_venta_ranki_geren vrg,  ");
      query.append("    mae_clien cli,  ");
      query.append("    zon_sub_geren_venta sub  ");
      query.append("    WHERE vrg.copa_oid_para_gral = cpg.oid_para_gral  ");
      query.append("    AND vrg.clie_oid_clie = cli.oid_clie  ");
      query.append("    AND vrg.zsgv_oid_subg_vent = sub.oid_subg_vent ");
      
      query.append("    AND cpg.pais_oid_pais = " + dto.getOidPais() );
      query.append("    AND vrg.copa_oid_para_gral = " + dto.getOidConcurso() );
      
      UtilidadesLog.info("DAOMantenimientoRanking.generarQueryGen(DTOVentaRankingGerentes dto):Salida");
      return query;
    }
    
    /**
   *  Método auxuliar para crear un objeto AmbitoGeografico,
   *  se fija si el resultset tiene columnas con el oid de la unid adm, y los setea.
   * @return AmbitoGeografico
   * @param fila
   * @param rs
   */
    private AmbitoGeografico crearAmbitoGeografico(RecordSet rs, int fila){
      UtilidadesLog.info("DAOMantenimientoRanking.crearAmbitoGeografico(RecordSet rs, int fila):Entrada");
      Vector columns = rs.getColumnIdentifiers();
      AmbitoGeografico amb = new AmbitoGeografico();
      if( columns.contains("OID_SUBG_VENT") ){
          amb.setOidSubgerencia( rs.getValueAt(fila,"OID_SUBG_VENT")!=null?
              new Long(( (BigDecimal)rs.getValueAt(fila,"OID_SUBG_VENT") ).longValue()) : null);
      }
      if( columns.contains("OID_REGI") ){
          amb.setOidSubgerencia( rs.getValueAt(fila,"OID_REGI")!=null?
              new Long(( (BigDecimal)rs.getValueAt(fila,"OID_REGI") ).longValue()) : null);
      }
      if( columns.contains("OID_ZONA") ){
          amb.setOidSubgerencia( rs.getValueAt(fila,"OID_ZONA")!=null?
              new Long(( (BigDecimal)rs.getValueAt(fila,"OID_ZONA") ).longValue()) : null);
      }
      if( columns.contains("OID_SECC") ){
          amb.setOidSubgerencia( rs.getValueAt(fila,"OID_SECC")!=null?
              new Long(( (BigDecimal)rs.getValueAt(fila,"OID_SECC") ).longValue()) : null);
      }
      
      UtilidadesLog.debug("AmbitoGeografico creado: " + amb.toString());
      UtilidadesLog.info("DAOMantenimientoRanking.crearAmbitoGeografico(RecordSet rs, int fila):Salida");
      return amb;
    }
}
