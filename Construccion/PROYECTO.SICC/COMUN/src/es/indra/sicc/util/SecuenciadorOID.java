package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;


public class SecuenciadorOID {
   public SecuenciadorOID() {
   }

   public static Long obtenerSiguienteValor(String nombreSecuencia) throws MareException {
      Long nextOid;
      String codigoError;
      StringBuffer consultaSQL;
      RecordSet res;
      BelcorpService belcorpService;

      try {
         belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
         codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
         throw new MareException(e,
            UtilidadesError.armarCodigoError(codigoError));
      }

      try {
         consultaSQL = new StringBuffer();
         consultaSQL.append("select " + nombreSecuencia + ".nextval from dual");
         res = belcorpService.dbService.executeStaticQuery(consultaSQL.toString());
         nextOid = new Long(res.getValueAt(0, 0).toString());
      } catch (Exception e) {
         codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(e,
            UtilidadesError.armarCodigoError(codigoError));
      }

      return nextOid;
   }
}
