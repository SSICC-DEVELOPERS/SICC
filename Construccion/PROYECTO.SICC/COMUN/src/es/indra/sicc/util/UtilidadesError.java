package es.indra.sicc.util;

public class UtilidadesError {
   /**
   * PRE codigoModulo, codigoCasoDeUso y codigoError son strings que tienen el siguiente formato
    *     codigoModulo = MMM
    *     codigoCasoDeUso = CCC
    *     codigoError = EEEE
    *
    *  Devuelve un int que tiene la MMMCCCEEEE sin ceros a izquierda
    */
   public static int armarCodigoError(String codigoModulo,
      String codigoCasoDeUso, String codigoError) {
      return Integer.parseInt(codigoModulo + codigoCasoDeUso + codigoError);
   }

   public static int armarCodigoError(String codigoModulo, String codigoError) {
      return Integer.parseInt(codigoModulo + codigoError);
   }

   public static int armarCodigoError(String codigoError) {
      return Integer.parseInt(codigoError);
   }
}
