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

import es.indra.sicc.util.UtilidadesError;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import java.util.Vector;

import es.indra.sicc.util.UtilidadesLog;

public class DAOChequeos  {
   public DAOChequeos() {
   }
   
   // diseño en incidencia BELC300015950
   public RecordSet obtenerTiposOrdenChequeo(DTOBelcorp dtoE) throws MareException {
		
      UtilidadesLog.info("DAOChequeos.obtenerTiposOrdenChequeo(DTOBelcorp):Entrada");
      
      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();
      
      consulta.append("SELECT OID_TIPO_ORDE_CHEQ AS VAL_OID, ");
      consulta.append("(SELECT t.VAL_I18N FROM GEN_I18N_SICC_COMUN t ");
      consulta.append("WHERE t.ATTR_ENTI = 'REC_TIPO_ORDEN_CHEQU' ");
      consulta.append("AND t.IDIO_OID_IDIO = ? ");
      parametros.add(dtoE.getOidIdioma());
      consulta.append("AND t.ATTR_NUM_ATRI = 1 ");
      consulta.append("AND t.VAL_OID = OID_TIPO_ORDE_CHEQ) as DESCRIPCION ");
      consulta.append("FROM REC_TIPO_ORDEN_CHEQU ");
      consulta.append("ORDER BY DESCRIPCION");
      
		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		
      try {
         resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
		} catch (Exception e) {
         UtilidadesLog.error("DAOChequeos.obtenerTiposOrdenChequeo: ",e);
         String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}      
      
      UtilidadesLog.info("DAOChequeos.obtenerTiposOrdenChequeo(DTOBelcorp):Salida");
      
      return resultado;
   }
      
}