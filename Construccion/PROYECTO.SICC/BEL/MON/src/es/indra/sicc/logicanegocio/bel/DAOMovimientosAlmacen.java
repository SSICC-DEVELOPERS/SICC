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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.dtos.bel.DTOReversionMovimiento;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class DAOMovimientosAlmacen  {

	/** 
     * Método para obtener las líneas a revertir
     * @param dto DTOOID 
     * @return RecordSet el resultado de la consulta
     * @exception MareException 
     */
	public RecordSet obtenerLineasReversion (DTOReversionMovimiento dto) throws MareException{
		UtilidadesLog.info("DATOMovimientosAlmacen : entrada ObtenerLineasReversion");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		//SELECT
		consulta.append("SELECT B.oid_deta as OIDLINEA, ");
		consulta.append(" B.tmal_oid_tipo_movi_alma as TIPOMOVIMIENTOALMACEN, ");
		consulta.append(" B.almc_oid_alma_entr as ALMACENENTRADA, ");
		consulta.append(" B.almc_oid_alma_sali as ALMACENSALIDA, ");
		consulta.append(" B.prod_oid_prod as PRODUCTO, ");
		consulta.append(" B.val_cant as CANTIDAD ");
		//FROM
		consulta.append(" FROM bel_movim_almac_cabec A, ");
		consulta.append(" bel_movim_almac_detal B ");
		//WHERE
		consulta.append(" WHERE A.pais_oid_pais = ? AND A.sbac_oid_sbac = ? AND ");
		parametros.add(dto.getPais());
		parametros.add(dto.getSubacceso());
		consulta.append(" B.mval_oid_movi_alma = A.oid_movi_alma AND ");
		if (dto.getNumDocumento() != null){
			consulta.append(" B.num_docu_refe = ? ");
			parametros.add(dto.getNumDocumento());
		}
		else{
			consulta.append(" B.num_docu_refe is null ");
		}
		consulta.append(" AND B.oper_oid_oper = ? ");
		parametros.add(dto.getOperacion());
		if (dto.getNumLinea() != null) {
			consulta.append(" AND B.num_line = ? ");
			parametros.add(dto.getNumLinea());
		}
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;

		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerLineasReversion:",e);
			this.logSql("obtenerLineasReversion",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		UtilidadesLog.info("DAOMovimientosAlmacen : salida obtenerLineasReversion");
		return resultado;
	}
    
    public ArrayList obtenerMovimientosDetallesAgrupados (ArrayList listaOIDs)throws MareException{
        UtilidadesLog.info("DAOMovimientosAlmace.obtenerMovimientosDetallesAgrupados: Entrada");
        
        StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
        
        consulta.append(" SELECT CAB.PAIS_OID_PAIS PAIS ");
        consulta.append(" , AC.CANA_OID_CANA OIDCANAL ");
        consulta.append(" , SA.ACCE_OID_ACCE OIDACCESO ");
        consulta.append(" , CAB.SBAC_OID_SBAC SUBACCESO ");
        consulta.append(" , CAB.PERD_OID_PERI ");
        consulta.append(" , CAB.FEC_MOVI ");
        consulta.append(" , DET.TOFE_OID_TIPO_OFER ");
        consulta.append(" , DET.TMAL_OID_TIPO_MOVI_ALMA OIDMOVIMIENTOCABECERA ");
        consulta.append(" , DET.PROD_OID_PROD ");
        consulta.append(" , CAB.ALMC_OID_ALMA_1 OIDALMACENSALIDA ");
        consulta.append(" , CAB.ALMC_OID_ALMA_2 OIDALMACENENTRADA ");
        consulta.append(" , SUM(DET.VAL_CANT) CANTIDAD ");
        consulta.append(" , SUM(DET.VAL_PREC_VENT_NETO / ABS(DET.VAL_CANT)) PRECIOVENTANETO ");
        consulta.append(" , SUM(DET.VAL_PREC_CONT / ABS(DET.VAL_CANT)) PRECIOCONTABLE ");
        
        consulta.append(" FROM BEL_MOVIM_ALMAC_CABEC CAB ");
        consulta.append(" , BEL_MOVIM_ALMAC_DETAL DET ");
        consulta.append(" , SEG_SUBAC SA ");
        consulta.append(" , SEG_ACCES AC ");
        consulta.append(" WHERE DET.OID_DETA IN ( ?");
        parametros.add((Long)listaOIDs.get(0));
        for(int i = 1; i< listaOIDs.size() ; i++){
           consulta.append(" , ? ");
           parametros.add((Long)listaOIDs.get(i));  
        }
        consulta.append(" ) ");
        consulta.append(" AND DET.MVAL_OID_MOVI_ALMA = CAB.OID_MOVI_ALMA ");
        consulta.append(" AND CAB.SBAC_OID_SBAC = SA.OID_SBAC ");
        consulta.append(" AND SA.ACCE_OID_ACCE = AC.OID_ACCE ");
        consulta.append(" GROUP BY CAB.PAIS_OID_PAIS ");
        consulta.append(" ,AC.CANA_OID_CANA ");
        consulta.append(" ,SA.ACCE_OID_ACCE ");
        consulta.append(" ,CAB.SBAC_OID_SBAC ");
        consulta.append(" ,CAB.PERD_OID_PERI ");
        consulta.append(" ,CAB.FEC_MOVI ");
        consulta.append(" ,DET.TOFE_OID_TIPO_OFER ");
        consulta.append(" ,DET.TMAL_OID_TIPO_MOVI_ALMA ");
        consulta.append(" ,DET.PROD_OID_PROD ");
        consulta.append(" ,CAB.ALMC_OID_ALMA_1 ");
        consulta.append(" ,CAB.ALMC_OID_ALMA_2 ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
        
        try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerLineasReversion:",e);
			this.logSql("obtenerLineasReversion",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        ArrayList ListaDTOMovimientoAlmacenDetalle = new ArrayList();
        for(int j= 0; j < resultado.getRowCount(); j++){
            
            DTOMovimientoAlmacenDetalle dto = new DTOMovimientoAlmacenDetalle();
            dto.setOidPais(new Long(((BigDecimal)resultado.getValueAt(j,"PAIS")).longValue()));
            dto.setOidCanal(new Long(((BigDecimal)resultado.getValueAt(j,"OIDCANAL")).longValue()));
            dto.setOidAcceso(new Long(((BigDecimal)resultado.getValueAt(j,"OIDACCESO")).longValue()));
            dto.setOidSubacceso(new Long(((BigDecimal)resultado.getValueAt(j,"SUBACCESO")).longValue()));
            
            //Falta PERD_OID_PERI
            //Falta FEC_MOVI
            if(resultado.getValueAt(j,"TOFE_OID_TIPO_OFER") != null){
                dto.setOidTipoOferta(new Long(((BigDecimal)resultado.getValueAt(j,"TOFE_OID_TIPO_OFER")).longValue()));
            }
            dto.setOidMovimientoCabecera(new Long(((BigDecimal)resultado.getValueAt(j,"OIDMOVIMIENTOCABECERA")).longValue()));
            dto.setOidProducto(new Long(((BigDecimal)resultado.getValueAt(j,"PROD_OID_PROD")).longValue()));
            if(resultado.getValueAt(j,"OIDALMACENSALIDA") != null){
                dto.setOidAlmacenSalida(new Long(((BigDecimal)resultado.getValueAt(j,"OIDALMACENSALIDA")).longValue()));
            }
            if(resultado.getValueAt(j,"OIDALMACENENTRADA") != null){
                dto.setOidAlmacenEntrada(new Long(((BigDecimal)resultado.getValueAt(j,"OIDALMACENENTRADA")).longValue()));
            }
            dto.setCantidad(new Long(((BigDecimal)resultado.getValueAt(j,"CANTIDAD")).longValue()));
            if(resultado.getValueAt(j,"PRECIOVENTANETO") != null){
                dto.setPrecioVentaNeto((BigDecimal)resultado.getValueAt(j,"PRECIOVENTANETO"));
            }
            if(resultado.getValueAt(j,"PRECIOVENTANETO") != null){
                dto.setPrecioContable((BigDecimal)resultado.getValueAt(j,"PRECIOCONTABLE"));
            }
            ListaDTOMovimientoAlmacenDetalle.add(dto);
        }
        
        UtilidadesLog.info("DAOMovimientosAlmace.obtenerMovimientosDetallesAgrupados: Salida");
        return ListaDTOMovimientoAlmacenDetalle;
    }
    
    public ArrayList obtenerMovimientosAlmacen(Long pais, Long canal, 
        Long acceso, ArrayList subaccesos, ArrayList tiposMovimientos)throws MareException {    
        
        UtilidadesLog.info("DAOMovimientosAlmace.obtenerMovimientosAlmacen: Entrada");
       
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
       
        consulta.append(" SELECT MA.OID_MOVI_ALMA OID, ");
        consulta.append("        MA.PAIS_OID_PAIS PAIS,");
        consulta.append("        MA.NUM_DOCU NUMERODOCUMENTO, ");
	      consulta.append("        MA.FEC_MOVI FECHA, ");
	      consulta.append("        MA.VAL_OBSE OBSERVACIONES, ");
        consulta.append("        MA.ALMC_OID_ALMA_1 OIDALMACENSALIDA, ");
	      consulta.append("        MA.ALMC_OID_ALMA_2 OIDALMACENENTRADA, ");
        consulta.append("        MA.TMAL_OID_TIPO_MOVI_ALMA OIDTIPOMOVIMIENTOALMACEN, ");
        consulta.append("        MA.PERD_OID_PERI OIDPERIODO, ");
	      consulta.append("        MA.N_MOVIMIENTO NUMEROMOVIMIENTO, ");
        consulta.append("        MA.SBAC_OID_SBAC OIDSUBACCESO, ");
	      consulta.append("        SA.ACCE_OID_ACCE OIDACCESO, ");
        consulta.append("        AC.CANA_OID_CANA OIDCANAL, ");
	      consulta.append("        MAD.OID_DETA, ");
	      consulta.append("        MAD.MVAL_OID_MOVI_ALMA, ");
	      consulta.append("        MAD.NUM_LINE, ");
	      consulta.append("        MAD.VAL_CANT, ");
        consulta.append("        MAD.VAL_PREC_VENT_NETO, ");
	      consulta.append("        MAD.VAL_PREC_CONT, ");
	      consulta.append("        MAD.NUM_DOCU_REFE, ");
        consulta.append("        MAD.NUM_POSI_REFE, ");
	      consulta.append("        MAD.TMAL_OID_TIPO_MOVI_ALMA, ");
	      consulta.append("        MAD.PROD_OID_PROD, ");
        consulta.append("        MAD.OPER_OID_OPER, ");
	      consulta.append("        MAD.ALMC_OID_ALMA_ENTR, ");
	      consulta.append("        MAD.ALMC_OID_ALMA_SALI, ");
        consulta.append("        MAD.N_MOVIMIENTO, ");
	      consulta.append("        MAD.TOFE_OID_TIPO_OFER, "); 
	      consulta.append("        MAD.NUM_LOTE_SAPM, ");
        consulta.append("        MAD.TPOS_OID_TIPO_POSI, ");
	      consulta.append("        MAD.STPO_OID_SUBT_POSI ");	   
        consulta.append("FROM BEL_MOVIM_ALMAC_CABEC MA, ");
  	    consulta.append("     SEG_ACCES AC, ");
	      consulta.append("     SEG_SUBAC SA, ");
	      consulta.append("     BEL_MOVIM_ALMAC_DETAL MAD ");
        consulta.append("WHERE MA.SBAC_OID_SBAC = SA.OID_SBAC ");
        consulta.append("  AND SA.ACCE_OID_ACCE = AC.OID_ACCE ");
        consulta.append("  AND MA.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append("  AND MAD.NUM_LOTE_SAPM IS NULL ");
        consulta.append("  AND MAD.MVAL_OID_MOVI_ALMA = MA.OID_MOVI_ALMA ");
        if (canal!=null){
            consulta.append(" AND AC.CANA_OID_CANA = ? ");
            parametros.add(canal);
        }
        if (acceso!=null){
            consulta.append(" AND SA.ACCE_OID_ACCE = ? ");
            parametros.add(acceso);
        }
        if (subaccesos.size()>0){
            consulta.append(" AND (");      
            String oidsSubaccesos = "";
            int j = 0;
            Iterator  it = subaccesos.iterator();
            while (it.hasNext()){
                Long oid = (Long)it.next();
                if (j == 0) {
                  oidsSubaccesos = "'" + oid.toString() + "'";
                } else {
                  oidsSubaccesos = oidsSubaccesos + ",'" + oid.toString() + "'";
                }
                if (j==999){
                    consulta.append(" SA.OID_SBA IN (" + oidsSubaccesos.toString() + ")");
                    if (it.hasNext()){
                      consulta.append(" OR ");                  
                    }                
                    j=0;
                    oidsSubaccesos = "";
                } else {
                  if (!it.hasNext()){
                    consulta.append(" SA.OID_SBA IN (" + oidsSubaccesos.toString() + ")");
                  }
                  j++;
                }        
            }
            consulta.append(")");      
        }
        consulta.append(" AND (");      
        String tipoMov = "";
        int k = 0;
        Iterator  it = tiposMovimientos.iterator();
        while (it.hasNext()){
            Long oid = (Long)it.next();
            if (k == 0) {
              tipoMov = "'" + oid.toString() + "'";
            } else {
              tipoMov = tipoMov + ",'" + oid.toString() + "'";
            }
            if (k==999){
              consulta.append(" MAD.TMAL_OID_TIPO_MOVI_ALMA IN (" + tipoMov.toString() + ")");
              if (it.hasNext()){
                  consulta.append(" OR ");                  
              }                
              k=0;
              tipoMov = "";
            } else {
               if (!it.hasNext()){
                    consulta.append(" MAD.TMAL_OID_TIPO_MOVI_ALMA IN (" + tipoMov.toString() + ")");
               }
               k++;
            }        
        }
        consulta.append(")");      
        consulta.append("ORDER BY 1   ");
  
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = null;
        String codigoError = null;
        
        try {
          resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
          this.logSql("DAOMovimientosAlmacen consulta en el try",consulta.toString(),parametros);
        } catch (Exception e) {
          UtilidadesLog.error("obtenerLineasReversion:",e);
          this.logSql("obtenerLineasReversion",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        ArrayList arrayMovimientosAlmacen = new ArrayList();                
        Long oidCabeceraAnterior = null;
        DTOMovimientoAlmacenCabecera dtoMovimientoAlmacenCab = null;
        ArrayList arrayMovimientosAlmacenDetalle = null;
        
        for(int i = 0; i < resultado.getRowCount(); i++){
            if (oidCabeceraAnterior == null || oidCabeceraAnterior != this.bigDecimalToLong(resultado.getValueAt(i,"OID"))){
                dtoMovimientoAlmacenCab = new DTOMovimientoAlmacenCabecera();    
                dtoMovimientoAlmacenCab.setOid(this.bigDecimalToLong(resultado.getValueAt(i,"OID")));
                dtoMovimientoAlmacenCab.setFecha(this.objectToDate(resultado.getValueAt(i,"FECHA")));
                dtoMovimientoAlmacenCab.setObservaciones(this.objectToString(resultado.getValueAt(i,"OBSERVACIONES")));
                dtoMovimientoAlmacenCab.setOidAlmacenSalida(this.bigDecimalToLong(resultado.getValueAt(i,"OIDALMACENSALIDA")));
                dtoMovimientoAlmacenCab.setOidAlmacenEntrada(this.bigDecimalToLong(resultado.getValueAt(i,"OIDALMACENENTRADA")));
                dtoMovimientoAlmacenCab.setOidTipoMovimientoAlmacen(this.bigDecimalToLong(resultado.getValueAt(i,"OIDTIPOMOVIMIENTOALMACEN")));
                dtoMovimientoAlmacenCab.setOidPeriodo(this.bigDecimalToLong(resultado.getValueAt(i,"OIDPERIODO")));
                dtoMovimientoAlmacenCab.setNumeroMovimiento(this.objectToString(resultado.getValueAt(i,"NUMEROMOVIMIENTO")));
                dtoMovimientoAlmacenCab.setOidSubacceso(this.bigDecimalToLong(resultado.getValueAt(i,"OIDSUBACCESO")));
                dtoMovimientoAlmacenCab.setOidAcceso(this.bigDecimalToLong(resultado.getValueAt(i,"OIDACCESO")));
                dtoMovimientoAlmacenCab.setOidCanal(this.bigDecimalToLong(resultado.getValueAt(i,"OIDCANAL")));
                dtoMovimientoAlmacenCab.setOidPais(this.bigDecimalToLong(resultado.getValueAt(i,"PAIS")));
                arrayMovimientosAlmacenDetalle = new ArrayList();
                
                oidCabeceraAnterior = this.bigDecimalToLong(resultado.getValueAt(i,"OID"));
                
            }        
            DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDet = new DTOMovimientoAlmacenDetalle();
    
            UtilidadesLog.debug("Oid Cabecera:  "+this.bigDecimalToLong(resultado.getValueAt(i,"MVAL_OID_MOVI_ALMA")).toString());
            UtilidadesLog.debug("Oid Detalle:  "+this.bigDecimalToLong(resultado.getValueAt(i,"OID_DETA")).toString());
    
            dtoMovimientoAlmacenDet.setOid(this.bigDecimalToLong(resultado.getValueAt(i,"OID_DETA")));
            dtoMovimientoAlmacenDet.setOidMovimientoCabecera(this.bigDecimalToLong(resultado.getValueAt(i,"MVAL_OID_MOVI_ALMA")));
            dtoMovimientoAlmacenDet.setNumeroLinea(this.bigDecimalToInteger(resultado.getValueAt(i,"NUM_LINE")));
            dtoMovimientoAlmacenDet.setCantidad(this.bigDecimalToLong(resultado.getValueAt(i,"VAL_CANT")));
            dtoMovimientoAlmacenDet.setPrecioVentaNeto(this.objectToBigDecimal(resultado.getValueAt(i,"VAL_PREC_VENT_NETO")));
            dtoMovimientoAlmacenDet.setPrecioContable(this.objectToBigDecimal(resultado.getValueAt(i,"VAL_PREC_CONT")));
            dtoMovimientoAlmacenDet.setNumeroDocumentoReferencia(this.bigDecimalToLong(resultado.getValueAt(i,"NUM_DOCU_REFE")));
            dtoMovimientoAlmacenDet.setNumeroPosicionReferencia(this.bigDecimalToInteger(resultado.getValueAt(i,"NUM_POSI_REFE")));
            dtoMovimientoAlmacenDet.setOidTipoMovimientoAlmacen(this.bigDecimalToLong(resultado.getValueAt(i,"TMAL_OID_TIPO_MOVI_ALMA")));
            dtoMovimientoAlmacenDet.setOidProducto(this.bigDecimalToLong(resultado.getValueAt(i,"PROD_OID_PROD")));
            dtoMovimientoAlmacenDet.setOperacion(this.objectToString(resultado.getValueAt(i,"OPER_OID_OPER")));
            dtoMovimientoAlmacenDet.setOidAlmacenSalida(this.bigDecimalToLong(resultado.getValueAt(i,"ALMC_OID_ALMA_SALI")));
            dtoMovimientoAlmacenDet.setOidAlmacenEntrada(this.bigDecimalToLong(resultado.getValueAt(i,"ALMC_OID_ALMA_ENTR")));
            dtoMovimientoAlmacenDet.setNumeroMovimiento(this.objectToString(resultado.getValueAt(i,"N_MOVIMIENTO")));
            dtoMovimientoAlmacenDet.setOidTipoOferta(this.bigDecimalToLong(resultado.getValueAt(i,"TOFE_OID_TIPO_OFER")));
            //agregado por incidencia 20123
            if(resultado.getValueAt(i,"NUM_LOTE_SAPM")!=null){
                dtoMovimientoAlmacenDet.setNumeroLoteSAP(Long.valueOf(resultado.getValueAt(i,"NUM_LOTE_SAPM").toString()));
            }
            dtoMovimientoAlmacenDet.setOidTipoPosicion(this.bigDecimalToLong(resultado.getValueAt(i,"TPOS_OID_TIPO_POSI")));            
            dtoMovimientoAlmacenDet.setOidSubtipoPosicion(this.bigDecimalToLong(resultado.getValueAt(i,"STPO_OID_SUBT_POSI")));                            
            arrayMovimientosAlmacenDetalle.add(dtoMovimientoAlmacenDet);
            
            int x=i;            
            if (oidCabeceraAnterior != this.bigDecimalToLong(resultado.getValueAt(x++,"OID"))){
                DTOMovimientoAlmacen dtoMovimientoAlmacen = new DTOMovimientoAlmacen();
                dtoMovimientoAlmacen.setCabecera(dtoMovimientoAlmacenCab);
                dtoMovimientoAlmacen.setDetalle(arrayMovimientosAlmacenDetalle);
                arrayMovimientosAlmacen.add(dtoMovimientoAlmacen);
            }
        }      
        UtilidadesLog.debug("Cantidad de Movimientos :" + arrayMovimientosAlmacen.size());
        UtilidadesLog.info("DAOMovimientosAlmace.obtenerMovimientosAlmacen: Salida");
        return arrayMovimientosAlmacen;
    }

	private void logSql(String metodo, String sql, Vector params){
		UtilidadesLog.info(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.info(metodo + sParams);
		}
	}   
     private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
    
     private Date objectToDate(Object fecha) {
        if (fecha != null) {
            return (Date)fecha;
        } else {
            return null;
        }
    }
    
     private String objectToString(Object obj) {
        if (obj != null) {
            return obj.toString();
        } else {
            return null;
        }
    }

     private Integer bigDecimalToInteger(Object numero) {
        if (numero != null) {
            return new Integer(((BigDecimal) numero).intValue());
        } else {
            return null;
        }
    }
    
    private BigDecimal objectToBigDecimal(Object numero) {
        if (numero != null) {
            return (BigDecimal) numero;
        } else {
            return null;
        }
    }

    
    
}