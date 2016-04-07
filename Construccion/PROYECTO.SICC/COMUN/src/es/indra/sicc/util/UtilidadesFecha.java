package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;


public class UtilidadesFecha {
   private static final int SECOND = 1000;
   private static final int MINUTE = 60 * SECOND;
   private static final int HOUR = 60 * MINUTE;
   private static final long DAY = 24 * HOUR;
   public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

   /**
    *
    * @param  String fecha
    * @param  String pattern
    * @return java.util.Date
    *
    * Ejemplos (ver doc de java.text.SimpleDateFormat):
    *
    *  pattern                                resultado
    *  --------------                         -------
    *  "yyyy-MM-dd"                      ->>  2003-02-24
    *  "yyyy.MM.dd G 'at' hh:mm:ss z"    ->>  1996.07.10 AD at 15:08:56 PDT
    *  "EEE, MMM d"                      ->>  Wed, July 10
    *  "h:mm a"                          ->>  12:08 PM
    *  "yyyyy.MMMMM.dd GGG hh:mm aaa"    ->>  1996.July.10 AD 12:08 PM
    *
    */
   public static Date convertirAFecha(String strFecha, String pattern)
      throws ParseException {
      SimpleDateFormat sdf = new SimpleDateFormat(pattern);

      Date fecha = sdf.parse(strFecha);

      return fecha;
   }

   /**
    * @param  String fecha
    * @return java.util.Date
    * @see #convertirAFecha
    *
    * Usa el pattern "yyyy-MM-dd"
    *
    * Ejemplos (ver doc de java.text.SimpleDateFormat):
    *
    *  pattern              resultado
    *  --------------       -------
    *  "yyyy-MM-dd"    ->>  2003-02-24
    *
    */
   public static Date convertirAFecha(String strFecha)
      throws ParseException {
      return convertirAFecha(strFecha, DEFAULT_DATE_PATTERN);
   }

   /**
    * Devuelve un Date que tiene la misma fecha
    * (con el siguiente pattern: )
    * que la recibida pero
    * con la hora a 00:00:00 0.00000000
    */
   public static Date normalizarHoras(Date fecha, String pattern)
      throws ParseException {
      SimpleDateFormat sdf = new SimpleDateFormat(pattern);

      String strFecha = sdf.format(fecha);

      return sdf.parse(strFecha);
   }

   /**
    *
    */
   public static Date normalizarHoras(Date fecha) throws ParseException {
      return normalizarHoras(fecha, DEFAULT_DATE_PATTERN);
   }

   /**
    *
    */
   public static String convertirAString(Date fecha, String pattern)
      throws ParseException {
      SimpleDateFormat sdf = new SimpleDateFormat(pattern);

      String strFecha = sdf.format(fecha);

      return strFecha;
   }

   /**
    *
    */
   public static String convertirAString(Date fecha) throws ParseException {
      return convertirAString(fecha, DEFAULT_DATE_PATTERN);
   }

   /**
    * @param Date aDate
    * @param int days
    * Retorna un fecha a la que se le ha sumado days dias.
    * (Otra alternativa es ver GregorianCalendar)
    */
   public static Date addDays(Date aDate, int days) {
      return new Date(aDate.getTime() + (DAY * days));
   }

   /**
    * @param Date aDate
    * @param int days
    * Retorna un fecha a la que se le ha restado days dias.
    * (Otra alternativa es ver GregorianCalendar)
    */
   public static Date minusDays(Date aDate, int days) {
      return addDays(aDate, days * -1);
   }

   /**
    *
    * @param  String fecha
    * @param  String pattern
    * @return java.sql.Timestamp
    *
    * Ejemplos (ver doc de java.text.SimpleDateFormat):
    *
    *  pattern                                resultado
    *  --------------                         -------
    *  "yyyy-MM-dd"                      ->>  2003-02-24
    *  "yyyy.MM.dd G 'at' hh:mm:ss z"    ->>  1996.07.10 AD at 15:08:56 PDT
    *  "EEE, MMM d"                      ->>  Wed, July 10
    *  "h:mm a"                          ->>  12:08 PM
    *  "yyyyy.MMMMM.dd GGG hh:mm aaa"    ->>  1996.July.10 AD 12:08 PM
    *
    */
   public static Timestamp convertirATimestamp(String strFecha, String pattern)
      throws MareException {
      Timestamp fecha;

      try {
         SimpleDateFormat sdf = new SimpleDateFormat(pattern);
         fecha = new Timestamp(sdf.parse(strFecha).getTime());
      } catch (ParseException pe) {
         throw new MareException(pe,
            UtilidadesError.armarCodigoError(
               CodigosError.ERROR_DE_FORMATO_FECHA));
      }

      return fecha;
   }
}
