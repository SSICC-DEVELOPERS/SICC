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
 */
package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.cob.DTOEBuscarCompromisosPago;



import java.util.Vector;
public class DAOCompromisosPago 
{
    public DAOCompromisosPago()
    {
    }

    DTOSalida buscarCompromisosPago(DTOEBuscarCompromisosPago dto) throws MareException{
    
        UtilidadesLog.info("DAOCompromisosPago.buscarCompromisosPago(DTOEBuscarCompromisosPago dto): Entrada");
    
     /*
        Proceso: 
        -> Hacer la siguiente consulta JDBC: 
        
        SELECT  COMPROMISO.OID_COMP_PAGO, 
                ACCION.COD_ACCI_COBR, 
                ACCION.VAL_DESC, 
                SUBTI_ACCIO.COD_SUBT_ACCI, 
                COMPROMISO.COD_COMP_PAGO, 
                CLIENTE.COD_CLIE, 
                COMPROMISO.FEC_PAGO, 
                COMPROMISO.IMP_PAGO, 
                COMPROMISO.FEC_SEGU_PREV, 
                BANCO.DES_BANC, 
                SUCUR.COD_SUCU, 
                COMPROMISO.VAL_OBSE         
        FROM COB_COMPR_PAGO COMPROMISO, 
                COB_ACCIO_COBRA ACCION, 
                COB_SUBTI_ACCIO SUBTI_ACCIO, 
                COB_GESTI_COBRA GESTION, 
                MAE_CLIEN CLIENTE, 
                COB_ASIGN_COBRA ASIGNACION, 
                CCC_BANCO BANCO, 
                CCC_SUCUR SUCUR 
        WHERE COMPROMISO.GECO_OID_GEST_COBR = GESTION.OID_GEST_COBR 
            AND GESTION.ACCO_OID_ACCI_COBR = ACCION.OID_ACCI_COBR 
            AND GESTION.CLIE_OID_CLIE = CLIENTE.OID_CLIE 
            AND COMPROMISO.SUCU_OID_SUCU = SUCUR.OID_SUCU 
            AND SUCUR.CBAN_OID_BANC = BANCO.OID_BANC 
            AND COMPROMISO.GECO_OID_GEST_COBR = 1 
        
        Nota: No filtrar por campos que vienen a NULL, en ese caso no hacer las join 
        
        (1) Si (dto.paginacion == true) entonces 
        -> Esta consulta es paginada, por tanto habra que tener en cuenta las siguientes consideraciones: 
        1.- oid del registro encontrado > dto.indicadorSituacion 
        2.- ROWNUM <= dto.tamañoPagina 
        (1) Fin Si 
        
        -> Devolver RecordSet obtenido encapsulado en un DTOSalida */
        
        DTOSalida dtoS = new DTOSalida();
        RecordSet resultado = null;
        String codigoError = null;        
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        
        if (dto.getPaginado().booleanValue())
        {
            query.append("SELECT * FROM (SELECT ROWNUM as linea,    XY.* FROM (  ");
        }
        
        query.append("SELECT  COMPROMISO.OID_COMP_PAGO, ");
        query.append(" ACCION.COD_ACCI_COBR,  ");
        query.append(" ACCION.VAL_DESC,  ");
        query.append(" SUBTI_ACCIO.COD_SUBT_ACCI,  ");
        query.append(" COMPROMISO.COD_COMP_PAGO,  ");
        query.append(" CLIENTE.COD_CLIE,  ");
        query.append(" COMPROMISO.FEC_PAGO,  ");
        query.append(" COMPROMISO.IMP_PAGO,  ");
        query.append(" COMPROMISO.FEC_SEGU_PREV, "); 
        query.append(" BANCO.DES_BANC,  ");
        query.append(" SUCUR.COD_SUCU,  ");
        query.append(" COMPROMISO.VAL_OBSE  ");        
        query.append(" FROM COB_COMPR_PAGO COMPROMISO,  ");
        query.append(" COB_ACCIO_COBRA ACCION,  ");
        query.append(" COB_SUBTI_ACCIO SUBTI_ACCIO, "); 
        query.append(" COB_GESTI_COBRA GESTION,  ");
        query.append(" MAE_CLIEN CLIENTE,  ");
//        query.append(" COB_ASIGN_COBRA ASIGNACION,  ");
        query.append(" CCC_BANCO BANCO,  ");
        query.append(" CCC_SUCUR SUCUR  ");
        query.append(" WHERE COMPROMISO.GECO_OID_GEST_COBR = GESTION.OID_GEST_COBR  ");
        query.append(" AND GESTION.ACCO_OID_ACCI_COBR = ACCION.OID_ACCI_COBR  ");
        query.append(" AND GESTION.CLIE_OID_CLIE = CLIENTE.OID_CLIE  ");
        //  Modificado por HRCS - fecha 10/04/2007 - Se modifico por incidencia Sicc20070179
        query.append(" AND COMPROMISO.SUCU_OID_SUCU = SUCUR.OID_SUCU(+)  ");
        query.append(" AND SUCUR.CBAN_OID_BANC = BANCO.OID_BANC(+)  ");
        //query.append(" AND COMPROMISO.GECO_OID_GEST_COBR = 1 ");
        query.append(" AND ACCION.SACC_OID_SUBT_ACCI = SUBTI_ACCIO.OID_SUBT_ACCI ");
        
        if (dto.getOidGestionCobranza()!= null)
        {
            query.append(" AND GESTION.OID_GEST_COBR = ? ");
            parametros.add(dto.getOidGestionCobranza());
        }
        
        if (dto.getPaginado().booleanValue())
        {
            query.append(") XY ) WHERE linea > " + dto.getIndicadorSituacion() + " AND ROWNUM <= " + dto.getTamanioPagina() );
        }
        
        //this.logSql("buscarCompromisosPago. SQL: ", query.toString(), parametros);
        UtilidadesLog.debug("buscarCompromisosPago. SQL: " + query.toString());
        UtilidadesLog.debug("Parametros: " + parametros);
        
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
            resultado = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("buscarCompromisosPago: Exception",e);
            //this.logSql("buscarCompromisosPago. SQL: ", query.toString(), parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        if ( resultado.esVacio() )
        {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("No hay registros", UtilidadesError.armarCodigoError(codigoError));
        }
        
       dtoS.setResultado(resultado);
       
        UtilidadesLog.debug("Observacion:  "  + resultado.getValueAt(0,"VAL_OBSE"));
        UtilidadesLog.info("DAOCompromisosPago.buscarCompromisosPago(DTOEBuscarCompromisosPago dto): Salida");
       
       return dtoS; 
    }
    
    /*private void logSql(String metodo, String sql, Vector params){
		UtilidadesLog.info(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.info(metodo + sParams);
		}
    }*/
    
}