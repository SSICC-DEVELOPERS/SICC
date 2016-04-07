/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.rec;
import es.indra.sicc.dtos.rec.DTOBuscarProductosReclamados;
import es.indra.sicc.util.DTOSalida;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import es.indra.sicc.dtos.rec.DTOLineasOperacion;
import es.indra.sicc.dtos.rec.DTOMovAlmac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;


import java.math.BigDecimal;
import java.util.Vector;


public class DAORecibirProductos  {
    public DAORecibirProductos() {
    }
    
    /**
    * Sistema:     Belcorp
    * Modulo:      REC
    * Fecha:       11/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */   
    public ArrayList obtenerAlmacenDeLinea (ArrayList lineas)throws MareException{
        UtilidadesLog.info("DAORecibirProductos.obtenerAlmacenDeLinea (ArrayList lineas):Entrada");
        
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        
        //Consulta Modificada por incidencia BELC300020954
        //Cristian Valenzuela - 26/9/2005
        sql.append(" SELECT LORE.OID_LINE_OPER_RECL, ");
        sql.append(" OPER.ALMC_OID_ALMA, ");
        sql.append(" OPER.TMAL_OID_TIPO_MOVI_ALMA, ");
        sql.append(" OFDE.TOFE_OID_TIPO_OFER, ");
        sql.append(" LORE.PROD_OID_PROD, ");
		sql.append(" TIPO.OID_TIPO_POSI, ");
		sql.append(" SUBTI.OID_SUBT_POSI ");
        sql.append(" FROM ");
        sql.append(" REC_LINEA_OPERA_RECLA LORE, ");
        sql.append(" REC_OPERA_RECLA OREC, ");
        sql.append(" REC_TIPOS_OPERA TOPE, ");
        sql.append(" REC_OPERA OPER, ");
        sql.append(" PRE_MATRI_FACTU MAFA, ");
        sql.append(" PRE_OFERT_DETAL OFDE, ");
		sql.append(" PED_TIPO_POSIC TIPO, ");
		sql.append(" PED_SUBTI_POSIC SUBTI ");
        sql.append(" WHERE ");
        sql.append(" OREC.TIOP_OID_TIPO_OPER = TOPE.OID_TIPO_OPER ");
        sql.append(" AND TOPE.ROPE_OID_OPER = OPER.OID_OPER ");
        sql.append(" AND LORE.MAFA_OID_MATR_FACT = MAFA.OID_MATR_FACT (+) ");
        sql.append(" AND MAFA.OFDE_OID_DETA_OFER = OFDE.OID_DETA_OFER (+) ");
        sql.append(" AND LORE.OPRE_OID_OPER_RECL = OREC.OID_OPER_RECL ");
		sql.append(" AND OPER.COD_OPER = TIPO.COD_TIPO_POSI ");
		sql.append(" AND TOPE.VAL_TIPO_OPER = SUBTI.COD_SUBT_POSI ");       
        
        DTOLineasOperacion dtoLineas = null;
        
        if(lineas!=null && lineas.size()>0) {
            sql.append(" AND LORE.OID_LINE_OPER_RECL IN ( ? ");
            dtoLineas = (DTOLineasOperacion) lineas.get(0);
            parametros.add(dtoLineas.getOidLineaOperacion());
            
            for(int i = 1; i<lineas.size(); i++) {
                sql.append(" , ? ");
                dtoLineas = (DTOLineasOperacion) lineas.get(i);
                parametros.add(dtoLineas.getOidLineaOperacion());
            }
            
            sql.append(" ) ");
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);                                                       
        }
        catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerAlmacenDeLinea: Exception",e);            
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (resultado.esVacio()) {       
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.debug("****DAORecibirProductos.obtenerAlmacenDeLinea: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));           
        }
  
        ArrayList movimientosAlmacen = new ArrayList();
        DTOMovAlmac dtoMovAlmacen = null;
        
        for(int i = 0; i<resultado.getRowCount(); i++) {
            dtoMovAlmacen = new DTOMovAlmac();
            
            if(resultado.getValueAt(i, "OID_LINE_OPER_RECL")!=null) {
                dtoMovAlmacen.setOidLineaOperacion(
                        new Long(((BigDecimal)resultado.getValueAt(i, "OID_LINE_OPER_RECL")).longValue()));
            }
            if(resultado.getValueAt(i, "ALMC_OID_ALMA")!=null) {
                dtoMovAlmacen.setOidAlmacen(
                        new Long(((BigDecimal)resultado.getValueAt(i, "ALMC_OID_ALMA")).longValue()));
            }
            if(resultado.getValueAt(i, "TMAL_OID_TIPO_MOVI_ALMA")!=null) {
                dtoMovAlmacen.setOidTipoMovimiento(
                        new Long(((BigDecimal)resultado.getValueAt(i, "TMAL_OID_TIPO_MOVI_ALMA")).longValue()));
            }
            // Faltaba el campo del DTO. BELC300015895
            if(resultado.getValueAt(i, "TOFE_OID_TIPO_OFER")!=null) {
                dtoMovAlmacen.setOidTipoOferta(
                        new Long(((BigDecimal)resultado.getValueAt(i, "TOFE_OID_TIPO_OFER")).longValue()));
            }
            // Faltaba el campo del DTO. BELC300015895
            if(resultado.getValueAt(i, "PROD_OID_PROD")!=null) {
                dtoMovAlmacen.setOidProducto(
                        new Long(((BigDecimal)resultado.getValueAt(i, "PROD_OID_PROD")).longValue()));
            }
            
            //Agregado por Cristian Valenzuela - 26/9/0005
            //Incidencia BELC300020954
            if(resultado.getValueAt(i, "OID_TIPO_POSI")!=null) {            
                dtoMovAlmacen.setOidTipoPosicion(
                    new Long(((BigDecimal)resultado.getValueAt(i, "OID_TIPO_POSI")).longValue()));
            }
            
            if(resultado.getValueAt(i, "OID_SUBT_POSI")!=null) {
                dtoMovAlmacen.setOidSubtipoPosicion(
                    new Long(((BigDecimal)resultado.getValueAt(i, "OID_SUBT_POSI")).longValue()));
            }   
            
            //FIN - Agregado por Cristian Valenzuela - 26/9/0005
            //Incidencia BELC300020954                  
            movimientosAlmacen.add(dtoMovAlmacen);
        }

        UtilidadesLog.info("DAORecibirProductos.obtenerAlmacenDeLinea (ArrayList):Salida");
        return movimientosAlmacen;
    }
    
    // BELC300015902
    public DTOSalida buscarProductosReclamados (DTOBuscarProductosReclamados dto) throws MareException {
        
     UtilidadesLog.info("DAORecibirProductos.buscarProductosReclamados (DTOBuscarProductosReclamados):Salida");
        
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        
        sql.append("SELECT * FROM (SELECT ROWNUM as linea,    XY.* FROM (");		
        sql.append(" SELECT ");
        sql.append(" CARE.OID_CABE_RECL AS OID, ");
        sql.append(" OPLI.OID_LINE_OPER_RECL AS OIDLINEAOPERACION, ");
        sql.append(" CARE.NUM_RECL AS NUMERORECLAMO, ");
        sql.append(" SOCA.VAL_NUME_SOLI AS DOCUMENTOREFERENCIA, ");
        sql.append(" CLIE.COD_CLIE AS CODIGOCLIENTE, ");
        // BELC300015902
        sql.append(" OPLI.IND_ESTA AS ESTADORECLAMACION, ");
        sql.append(" OPER.COD_OPER AS CODOPERACION, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append("     WHERE idio.ATTR_ENTI = 'REC_TIPOS_OPERA' ");
        sql.append("     AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append("     AND idio.VAL_OID = TIOP.OID_TIPO_OPER) AS TIPOOPERACION, ");
        sql.append(" OPRE.NUM_SECU_OPER AS NUMEROOPERACION, ");
        sql.append(" OPLI.NUM_LINE AS NUMEROLINEA, ");
        sql.append(" OFDE.VAL_CODI_VENT AS CODIGOVENTA, ");
        sql.append(" PROD.DES_CORT AS PRODUCTO, ");
        sql.append(" OPLI.NUM_UNID_RECL AS NUMEROUNIDADESRECLAMADAS, ");
        sql.append(" OPLI.NUM_UNID_DEVU AS NUMEROUNIDADESDEVUELTAS, ");
        sql.append(" (OPLI.NUM_UNID_RECL - OPLI.NUM_UNID_DEVU) AS NUMEROUNIDADESADEVOLVER, ");
        sql.append(" (OPLI.NUM_UNID_RECL - OPLI.NUM_UNID_DEVU) AS UNIDADESADEVOLVERDEFECTO, ");
        sql.append(" CARE.SOCA_OID_SOLI_CABE AS OIDSOLICITUDCABECERA, ");
        sql.append(" PERI.MARC_OID_MARC AS OIDMARCA, ");
        sql.append(" PERI.CANA_OID_CANA AS OIDCANAL, ");
        sql.append(" SUBA.ACCE_OID_ACCE AS OIDACCESO, ");
        sql.append(" SOCA.SBAC_OID_SBAC AS OIDSUBACCESO, ");
        sql.append(" CARE.PERD_OID_PERI_RECL AS OIDPERIODORECLAMO, ");
        sql.append(" CARE.NUM_ATEN AS NUMEROATENCION, ");
        sql.append(" OPER.IND_ESPE_MERC_FISI, ");
        sql.append(" OPER.IND_DEVU_FISI_FACT, ");
        sql.append(" OPLI.VAL_PREC, ");
        sql.append(" OPRE.INEM_OID_INDI_ENTR_MERC ");
        //sql.append(" OPRE.OID_OPER_RECL ");
        sql.append(" FROM ");
        sql.append(" REC_CABEC_RECLA CARE, ");
        sql.append(" REC_OPERA_RECLA OPRE, ");
        sql.append(" REC_LINEA_OPERA_RECLA OPLI, ");
        sql.append(" MAE_CLIEN CLIE, ");
        sql.append(" REC_TIPOS_OPERA TIOP, ");
        sql.append(" REC_OPERA OPER, ");
        // BELC300015902
        // sql.append(" REC_ESTAD_RECLA ESRE, ");
        sql.append(" PRE_MATRI_FACTU MAFA, ");
        sql.append(" PRE_OFERT_DETAL OFDE, ");
        sql.append(" MAE_PRODU PROD, ");
        sql.append(" PED_SOLIC_CABEC SOCA, ");
        sql.append(" CRA_PERIO PERI, ");
        sql.append(" SEG_SUBAC SUBA ");
        sql.append(" WHERE ");
        sql.append(" OPER.OID_OPER = TIOP.ROPE_OID_OPER AND ");
        sql.append(" TIOP.OID_TIPO_OPER = OPRE.TIOP_OID_TIPO_OPER AND ");
        sql.append(" OPLI.OPRE_OID_OPER_RECL = OPRE.OID_OPER_RECL AND ");
        sql.append(" OFDE.OID_DETA_OFER (+) = MAFA.OFDE_OID_DETA_OFER AND ");   //16855
        sql.append(" OPLI.MAFA_OID_MATR_FACT = MAFA.OID_MATR_FACT (+) AND ");   //16855
        sql.append(" OPLI.PROD_OID_PROD = PROD.OID_PROD (+) AND ");
        sql.append(" OPRE.CARE_OID_CABE_RECL = CARE.OID_CABE_RECL AND ");
        // BELC300015902
        // sql.append(" CARE.ESRE_OID_ESTA_RECL = ESRE.OID_ESTA_RECL AND ");
        sql.append(" CARE.CLIE_OID_CLIE = CLIE.OID_CLIE AND "); //16855
        sql.append(" OPRE.SOCA_OID_SOLI_CABE = SOCA.OID_SOLI_CABE AND ");
        sql.append(" SOCA.SBAC_OID_SBAC = SUBA.OID_SBAC AND ");
        sql.append(" SOCA.PERD_OID_PERI = PERI.OID_PERI AND");
        sql.append(" OPLI.TIMO_OID_TIPO_MOVI = ? ");//ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE
        parametros.add(ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE);
        
        /* Los que no sean nulos de estos: */
        if(dto.getNumeroReclamo()!=null) {
            sql.append(" AND CARE.NUM_RECL = ? ");//dtoe.numeroReclamo
            parametros.add(dto.getNumeroReclamo());
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
        if(dto.getFechaReclamo()!=null) {
            String fechaReclamo = sdf.format(dto.getFechaReclamo());
            sql.append(" AND CARE.FEC_INGR = TO_DATE(?, 'yyyy-MM-dd') ");//fechaReclamo
            parametros.add(fechaReclamo);
        }
        if(dto.getOidOperacion()!=null) {
            sql.append(" AND OPER.OID_OPER = ? ");//dtoe.oidOperacion  
            parametros.add(dto.getOidOperacion());
        }
        sql.append(" ORDER BY CARE.NUM_RECL, OFDE.VAL_CODI_VENT ");
        sql.append(") XY ) WHERE linea > " + dto.getIndicadorSituacion() + " AND ROWNUM <= " + dto.getTamanioPagina() );
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        //String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dto);
        
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(), parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" buscarProductosReclamados: Exception",e);
            
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (resultado.esVacio()) {       
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.debug("****DAORecibirProductos.buscarProductosReclamados: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));           
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(resultado);
        
        UtilidadesLog.info("DAORecibirProductos.buscarProductosReclamados (DTOBuscarProductosReclamados):Salida");
        return dtoSalida;
    }
    
}