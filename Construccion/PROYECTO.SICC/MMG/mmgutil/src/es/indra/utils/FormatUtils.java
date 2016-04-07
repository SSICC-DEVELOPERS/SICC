package es.indra.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Locale;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.ParseException;
import java.math.BigDecimal;

/**
 * Clase de parsing y formateo sensible al lenguaje y país
 * @version 2.0
 */
public class FormatUtils {

    static String language;
    static String country;

    static {
        try {
            language = Config.get("/default/language");
            country = Config.get("/default/country");
        }
        catch (Exception e) {
            e.printStackTrace();
            language = "es";
            country = "ES";
        }
    }

    /**
     * Formatea una cadena de entrada a una cadena de salida (si la cadena de entrada es null, devuelve "")
     * @param value Cadena de entrada
     * @return Cadena de salida
     */
	public static String formatString(String value) throws Exception {
		if (value == null)
			return "";
		else
			return value;
	}

    /**
     * Formatea un entero de entrada a una cadena de salida (si el entero es null, devuelve "")
     * @param value Entero de entrada
     * @return Cadena de salida
     */
    public static String formatInteger(Integer value) throws Exception {
        return formatInteger(value, language, country);
    }

    /**
     * Formatea un entero de entrada a una cadena de salida (si el entero es null, devuelve "")
     * @param value Entero de entrada
     * @param language Idioma
     * @param country País
     * @return Cadena de salida
     */
	public static String formatInteger(Integer value, String language, String country) throws Exception {

		String valueString = "";
		if (value != null) {
			DecimalFormat df =
				(DecimalFormat) NumberFormat.getInstance(
					new Locale(language, country));
			valueString = df.format(value.longValue());
		}
		return thousandRemove(valueString, language, country);
	
	}

	/**
	 * Formatea un entero de entrada a una cadena de salida (si el entero es null, devuelve "")
	 * @param value Enero de entrada
	 * @param locale El locale usado para formatear
	 * @param symbols Los simbolos usados en el formateo
	 * @return
	 */
	public static String formatInteger(Integer value, String pattern, DecimalFormatSymbols symbols){
		String valueString = "";

		if (value != null) {
			DecimalFormat df = new DecimalFormat(pattern.indexOf(".") != -1? pattern.substring(0, pattern.indexOf(".")): pattern, symbols);
			valueString = df.format(value.longValue());
		}

		return thousandRemove(valueString, symbols);
	}


    /**
     * Formatea un Long de entrada a una cadena de salida (si el entero es null, devuelve "")
     * @param value Long de entrada
     * @return Cadena de salida
     */
    public static String formatLong(Long value) throws Exception {
        return formatLong(value, language, country);
    }

    /**
     * Formatea un Long de entrada a una cadena de salida (si el entero es null, devuelve "")
     * @param value Long de entrada
     * @param language Idioma
     * @param country País
     * @return Cadena de salida
     */
	public static String formatLong(Long value, String language, String country) throws Exception {

		String valueString = "";
		if (value != null) {
			DecimalFormat df =
				(DecimalFormat) NumberFormat.getInstance(
					new Locale(language, country));
			valueString = df.format(value.longValue());
		}
		return thousandRemove(valueString, language, country);
	
	}

	/**
	 * Formatea un Long de entrada a una cadena de salida (si el entero es null, devuelve "")
	 * @param value Long de entrada
	 * @param locale El locale usado para formatear
	 * @param symbols Los simbolos usados en el formateo
	 * @return
	 */
	public static String formatLong(Long value, String pattern, DecimalFormatSymbols symbols){
		String valueString = "";

		if (value != null) {
			DecimalFormat df = new DecimalFormat(pattern.indexOf(".") != -1? pattern.substring(0, pattern.indexOf(".")): pattern, symbols);
			valueString = df.format(value.longValue());
		}

		return thousandRemove(valueString, symbols);
	}

	/**
	 * Formatea un número de entrada a una cadena de salida (si el número es null, devuelve "")
	 * @param value Número de entrada
	 * @return Cadena de salida
	 */
	public static String formatDouble(Double value) throws Exception {
	    return formatDouble(value, language, country);
	}
	
	/**
	 * Formatea un número de entrada a una cadena de salida (si el número es null, devuelve "")
	 * @param value Número de entrada
	 * @param language Idioma
	 * @param country País
	 * @return Cadena de salida
	 */
	public static String formatDouble(Double value, String language, String country) throws Exception {

		String valueString = "";
		if (value != null) {
				DecimalFormat df =
					(DecimalFormat) NumberFormat.getInstance(
						new Locale(language, country));
				valueString = df.format(value.doubleValue());
			}
		return thousandRemove(valueString, language, country);
	}
	
	/**
	 * Formatea un número de entrada a una cadena de salida (si el número es null, devuelve "")
	 * @param value Numero de entrada
	 * @param locale El locale usado para formatear
	 * @param symbols Los simbolos usados a la hora de realizar el formateo
	 * @return Cadena de salida
	 */
	public static String formatDouble(Double value, String pattern, DecimalFormatSymbols symbols){
		String valueString = "";

		if (value != null) {
			DecimalFormat df = new DecimalFormat(pattern, symbols);
			valueString = df.format(value.doubleValue());
		}
		
		return thousandRemove(valueString, symbols);
	}

	/**
	 * Formatea una fecha de entrada a una cadena de salida (si la fecha es null, devuelve "")
	 * @param value Fecha de entrada (También sirve para java.sql.Date, ya que hereda de java.util.Date)
	 * @return Cadena de salida
	 */
	public static String formatDate(java.util.Date value) throws Exception {
	    return formatDate(value, language, country);
	}
	
	/**
	 * Formatea una fecha de entrada a una cadena de salida (si la fecha es null, devuelve "")
	 * @param value Fecha de entrada (También sirve para java.sql.Date, ya que hereda de java.util.Date)
	 * @param language Idioma
	 * @param country País
	 * @return Cadena de salida
	 */
	public static String formatDate(java.util.Date value, String language, String country) throws Exception {
      String valueString = "";
  
      if (value != null) {
        SimpleDateFormat df =
          (SimpleDateFormat) DateFormat.getDateInstance(
            DateFormat.SHORT,
            new Locale(language, country));
  
        String pattern = df.toPattern();
        int firstIndex = pattern.indexOf('d');
        int lastIndex = pattern.lastIndexOf('d');
        pattern =
          pattern.substring(0, firstIndex)
            + "dd"
            + pattern.substring(lastIndex + 1);
        firstIndex = pattern.indexOf('M');
        lastIndex = pattern.lastIndexOf('M');
        pattern =
          pattern.substring(0, firstIndex)
            + "MM"
            + pattern.substring(lastIndex + 1);
        firstIndex = pattern.indexOf('y');
        lastIndex = pattern.lastIndexOf('y');
        pattern =
          pattern.substring(0, firstIndex)
            + "yyyy"
            + pattern.substring(lastIndex + 1);
        df.applyPattern(pattern);
        df.setLenient(false);
        valueString = df.format(value);
      }
  
      return valueString;
      
    /*

        String valueString = "";
        if(value != null)
        {
            language = language.replace('m', 'M');
            SimpleDateFormat df = new SimpleDateFormat(language);
            String pattern = df.toPattern();
            int firstIndex = pattern.indexOf('d');
            int lastIndex = pattern.lastIndexOf('d');
            pattern = pattern.substring(0, firstIndex) + "dd" + pattern.substring(lastIndex + 1);
            firstIndex = pattern.indexOf('M');
            lastIndex = pattern.lastIndexOf('M');
            pattern = pattern.substring(0, firstIndex) + "MM" + pattern.substring(lastIndex + 1);
            firstIndex = pattern.indexOf('y');
            lastIndex = pattern.lastIndexOf('y');
            pattern = pattern.substring(0, firstIndex) + "yyyy" + pattern.substring(lastIndex + 1);
            df.applyPattern(pattern);
            df.setLenient(false);
            valueString = df.format(value);
        }
        return valueString;*/
	}
	
	/**
	 * Formatea una fecha de entrada a una cadena de salida (si la fecha es null, devuelve "")
	 * @param value La fecha de entrado
	 * @param datePattern El patron usado para formatear las fechas
	 * @return Cadena de salida
	 */	
	public static String formatDate(java.util.Date value, String datePattern){

        String valueString = "";
        if(value != null)
        {
            datePattern = datePattern.replace('m', 'M');
            SimpleDateFormat df = new SimpleDateFormat(datePattern);
            valueString = df.format(value);
        }
        return valueString;
	}
	

	/**
	 * Formatea un booleano de entrada a una cadena de salida (si el booleano es null, devuelve "")
	 * @param value Booleano de entrada
	 * @return Cadena de salida
	 */
	public static String formatBoolean(Boolean value) throws Exception {

		if (value == null)
			return "";
		else
			return value.toString();
	}


	/**
	 * Formatea un objeto de entrada a una cadena de salida (si el objeto de entrada es null, devuelve "")
	 * @param value Objeto de entrada
	 * @return Cadena de salida
	 */
	public static String formatObject(Object value) throws Exception {
	    return formatObject(value, language, country);
	}
	
	/**
	 * Formatea un objeto de entrada a una cadena de salida (si el objeto de entrada es null, devuelve "")
	 * @param value Objeto de entrada
	 * @param language Idioma
	 * @param country País
	 * @return Cadena de salida
	 */
	public static String formatObject(Object value, String language, String country) throws Exception {

		if (value == null)
			return "";

		String className = value.getClass().getName();

		if (className.equals("java.lang.String"))
			return formatString((String) value);

		if (className.equals("java.lang.Integer"))
			return formatInteger((Integer) value, language, country);

		if (className.equals("java.lang.Long"))
			return formatLong((Long) value, language, country);

		if (className.equals("java.lang.Double"))
			return formatDouble((Double) value, language, country);

		if (className.equals("java.sql.Date")
			|| className.equals("java.util.Date"))
			return formatDate((java.util.Date) value, language, country);

		if (className.equals("java.lang.Boolean"))
			return formatBoolean((Boolean) value);

		return value.toString();
	}

	/**
	 * Formatea un objeto de entrada a una cadena de salida (si el objeto de entrada es null, devuelve "")
	 * OJO. Para formatear
	 * @param value
	 * @param locale
	 * @param symbols
	 * @return
	 * @throws Exception
	 */
	public static String formatObject(Object value, String pattern, DecimalFormatSymbols symbols) throws Exception{	
		if (value == null)
			return "";

		String className = value.getClass().getName();

		if (className.equals("java.lang.String"))return formatString((String) value);
		if (className.equals("java.lang.Integer")) return formatInteger((Integer) value, pattern, symbols);
		if (className.equals("java.lang.Long")) return formatLong((Long) value, pattern, symbols);    
		if (className.equals("java.lang.Double")) return formatDouble((Double) value, pattern, symbols);
		if (className.equals("java.lang.Boolean")) return formatBoolean((Boolean) value);
		if (className.equals("java.util.Date") || className.equals("java.sql.Date")) return formatDate((java.util.Date)value, pattern);
		return value.toString();
	}
	

	/**
	 * Interpreta una cadena de entrada y genera una cadena de salida
	 * @param value Cadena de entrada
	 * @return Cadena de salida
	 */
	public static String parseString(String value) throws Exception {
		if (value.equals(""))
			return null;
		else
			return value;
	}

    /**
     * Interpreta una cadena de entrada y genera un entero de salida
     * @param value Cadena de entrada
     * @return Entero de salida
     */
    public static Integer parseInteger(String value) throws Exception {
        return parseInteger(value, language, country);
    }
    
	/**
	 * Interpreta una cadena de entrada y genera un entero de salida
	 * @param value Cadena de entrada
	 * @param language Idioma
	 * @param country País
	 * @return Entero de salida
	 */
	public static Integer parseInteger(String value, String language, String country) throws Exception {
		Integer integer = null;

		if (!value.equals("")) {
			if (language == null)
				language = Config.get("/default/language");
			if (country == null)
				country = Config.get("/default/country");

			DecimalFormat df =
				(DecimalFormat) NumberFormat.getInstance(
					new Locale(language, country));

            ParsePosition parsePosition = new ParsePosition(0);
			integer = new Integer(df.parse(value, parsePosition).intValue());

            if (parsePosition.getIndex() != value.length()) {
                throw new ParseException("Error parsing Integer", parsePosition.getIndex());
            }
		}
		return integer;
	}
	
	public static Integer parseInteger(String value, String pattern, DecimalFormatSymbols symbols) throws Exception{
		Integer integer = null;

		if (!value.equals("")) {
			DecimalFormat df = new DecimalFormat(pattern, symbols);
			ParsePosition parsePosition = new ParsePosition(0);
			integer = new Integer(df.parse(value, parsePosition).intValue());
			if (parsePosition.getIndex() != value.length()) {
				throw new ParseException("Error parsing Integer", parsePosition.getIndex());
			}
		}
		return integer;
	}
	
    /**
     * Interpreta una cadena de entrada y genera un entero de salida
     * @param value Cadena de entrada
     * @return Entero de salida
     */
    public static Long parseLong(String value) throws Exception {
        return parseLong(value, language, country);
    }
    
	/**
	 * Interpreta una cadena de entrada y genera un entero de salida
	 * @param value Cadena de entrada
	 * @param language Idioma
	 * @param country País
	 * @return Entero de salida
	 */
	public static Long parseLong(String value, String language, String country) throws Exception {
		Long aLong = null;

		if (!value.equals("")) {
			if (language == null)
				language = Config.get("/default/language");
			if (country == null)
				country = Config.get("/default/country");

			DecimalFormat df =
				(DecimalFormat) NumberFormat.getInstance(
					new Locale(language, country));

            ParsePosition parsePosition = new ParsePosition(0);
			aLong = new Long(df.parse(value, parsePosition).intValue());

            if (parsePosition.getIndex() != value.length()) {
                throw new ParseException("Error parsing Integer", parsePosition.getIndex());
            }
		}
		return aLong;
	}
	
	public static Long parseLong(String value, String pattern, DecimalFormatSymbols symbols) throws Exception{
		Long aLong = null;

		if (!value.equals("")) {
			DecimalFormat df = new DecimalFormat(pattern, symbols);
			ParsePosition parsePosition = new ParsePosition(0);
			aLong = new Long(df.parse(value, parsePosition).intValue());
			if (parsePosition.getIndex() != value.length()) {
				throw new ParseException("Error parsing Integer", parsePosition.getIndex());
			}
		}
		return aLong;
	}
  
	/**
	 * Interpreta una cadena de entrada y genera un número de salida
	 * @param value Cadena de entrada
	 * @return Número de salida
	 */
	public static Double parseDouble(String value) throws Exception {
	    return parseDouble(value, language, country);
	}
	
	/**
	 * Interpreta una cadena de entrada y genera un número de salida
	 * @param value Cadena de entrada
	 * @param language Idioma
	 * @param country País
	 * @return Número de salida
	 */
	public static Double parseDouble(String value, String language, String country) throws Exception {

		Double doubleValue = null;

		if (!value.equals("")) {
			if (language == null)
				language = Config.get("/default/language");
			if (country == null)
				country = Config.get("/default/country");

			DecimalFormat df =
				(DecimalFormat) NumberFormat.getInstance(
					new Locale(language, country));
            ParsePosition parsePosition = new ParsePosition(0);
			doubleValue = new Double(df.parse(value, parsePosition).doubleValue());

            if (parsePosition.getIndex() != value.length()) {
                throw new ParseException("Error parsing Double", parsePosition.getIndex());
            }
		}
		return doubleValue;
	}
	
	public static Double parseDouble(String value, String pattern, DecimalFormatSymbols symbols) throws Exception{
		Double doubleValue = null;

		if (!value.equals("")) {

			DecimalFormat df = new DecimalFormat(pattern, symbols);
			ParsePosition parsePosition = new ParsePosition(0);
			doubleValue = new Double(df.parse(value, parsePosition).doubleValue());
			if (parsePosition.getIndex() != value.length()) {
				throw new ParseException("Error parsing Double", parsePosition.getIndex());
			}
		}
		return doubleValue;
	}

	/**
	 * Interpreta una cadena de entrada y genera una fecha de salida
	 * @param value Cadena de entrada
	 * @return Fecha de salida
	 */
	public static java.sql.Date parseDate(String value) throws Exception {
	    return parseDate(value, language, country);
	}
	
	/**
	 * Interpreta una cadena de entrada y genera una fecha de salida
	 * @param value Cadena de entrada
	 * @param language Idioma
	 * @param country País
	 * @return Fecha de salida
	 */
	public static java.sql.Date parseDate(String value, String language, String country) throws Exception {

		java.sql.Date date = null;

		if (!value.equals("")) {
			if (language == null)
				language = Config.get("/default/language");
			if (country == null)
				country = Config.get("/default/country");

			SimpleDateFormat df =
				(SimpleDateFormat) DateFormat.getDateInstance(
					DateFormat.SHORT,
					new Locale(language, country));
			df.setLenient(false);

            ParsePosition parsePosition = new ParsePosition(0);
			date = new java.sql.Date(df.parse(value, parsePosition).getTime());

            if (parsePosition.getIndex() != value.length()) {
                throw new ParseException("Error parsing Date", parsePosition.getIndex());
            }
		}
		return date;
	}
	
	/**
	 *  Interpreta una cadena de entrada y genera una fecha de salida
	 * @param value Cadena de entrada
	 * @param locale El locale
	 * @param symbols Los DecimalFormarSymbols a usar
	 * @return La Fecha de salida
	 * @throws Exception
	 */
	public static java.sql.Date parseDate(String value, String pattern) throws Exception{
		java.sql.Date date = null;

		if (!value.equals("")) {

      pattern = pattern.replace('m', 'M');
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			df.setLenient(false);
			ParsePosition parsePosition = new ParsePosition(0);
			date = new java.sql.Date(df.parse(value, parsePosition).getTime());
			if (parsePosition.getIndex() != value.length()) {
				throw new ParseException("Error parsing Date", parsePosition.getIndex());
			}
		}
		return date;
	}

	/**
	 * Interpreta una cadena de entrada y genera un booleano de salida
	 * @param value Cadena de entrada
	 * @return Booleano de salida
	 */
	public static Boolean parseBoolean(String value) throws Exception {
		if (value == null || value.equals(""))
			return null;
		else
			return new Boolean(value);
	}

    /**
     * Interpreta una cadena de entrada y genera un objeto de salida
     * @param value Cadena de entrada
     * @param className Nombre de la clase del objeto a generar
     * @return Objeto de salida
     */
    public static Object parseObject(String value, String className) throws Exception {
        return parseObject(value, className, language, country);
    }
    
    /**
     * Interpreta una cadena de entrada y genera un objeto de salida
     * @param value Cadena de entrada
     * @param className Nombre de la clase del objeto a generar
     * @param language Idioma
     * @param country País
     * @return Objeto de salida
     */
	public static Object parseObject(String value, String className, String language, String country) throws Exception {

		if (className.equals("java.lang.String"))
			return parseString(value);
		if (className.equals("java.sql.Date")
            || className.equals("java.util.Date"))
			return parseDate(value, language, country);
        if (className.equals("java.util.Date"))
            return parseDate(value, language, country);
		if (className.equals("java.lang.Boolean"))
			return parseBoolean(value);
        if (className.equals("java.lang.Integer"))
            return parseInteger(value, language, country);
        if (className.equals("java.lang.Double"))
            return parseDouble(value, language, country);
        if (className.equals("java.lang.Long"))
            return parseLong(value, language, country);            

		return null;
	}
	
	/**
	 * Interpreta una cadena de entrada y genera un objeto de salida
	 * @param value La cadena de entrada
	 * @param locale El locale a utilizar
	 * @param symbols Los DecimalFormarSymbols a usar
	 * @return
	 */
	public static Object parseObject(String value, String className, String pattern, DecimalFormatSymbols symbols)
		throws Exception{
		if (className.equals("java.lang.String")) return parseString(value);
		if (className.equals("java.sql.Date") || className.equals("java.util.Date")) return parseDate(value, pattern);
		if (className.equals("java.lang.Boolean")) return parseBoolean(value);
		if (className.equals("java.lang.Integer")) return parseInteger(value, pattern, symbols);
    if (className.equals("java.lang.Long")) return parseLong(value, pattern, symbols);    
		if (className.equals("java.lang.Double")) return parseDouble(value, pattern, symbols);
		return null;
	}

	/**
	 * Elimina los separadores de miles en los valores numéricos
     * @param value Fecha de entrada (También sirve para java.sql.Date, ya que hereda de java.util.Date)
     * @param language Idioma
     * @param country País
     * @return Cadena de salida
	 */
	public static String thousandRemove(String value, String language, String country) {

		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(new Locale(language, country));
		char groupingSeparator = df.getDecimalFormatSymbols().getGroupingSeparator();

		return replaceAll(value, String.valueOf(groupingSeparator), "");
	}
	
	/**
	 * Elimina los separadores de miles en los valores numéricos
	 * @param value El valor a limpiar de sepradores de miles
	 * @param symbols Los symbolos
	 * @return
	 */
	public static String thousandRemove(String value, DecimalFormatSymbols symbols){
		char groupingSeparator = symbols.getGroupingSeparator();
		return replaceAll(value, String.valueOf(groupingSeparator), "");
	}
	
	/**
	 * Implemnetación del replace all
	 * @param source
	 * @param replace
	 * @param replacement
	 * @return
	 */
	public static String replaceAll(String source, String replace, String replacement){
		StringBuffer bf = new StringBuffer();
		
		int posAnterior = 0;
		int posActual = 0;
		while(posAnterior >= 0 && posAnterior < source.length()){
			posActual = source.indexOf(replace, posAnterior);
			if(posActual != -1){
				bf.append(source.substring(posAnterior, posActual) + replacement);
				posAnterior = posActual + replace.length();
			}else{
				bf.append(source.substring(posAnterior));
				posAnterior = posActual;
			}
		}
		
		return bf.toString();
	}
	

	/**
	 * Método de pruebas unitarias
	 */
	public static void main(String args[]) throws Exception {
		//Date
		/*System.out.println("Date");
		System.out.println(formatObject(null, "en", "US"));
		System.out.println(formatObject(new java.sql.Date(new java.util.Date().getTime()), "en", "US"));
        System.out.println(formatObject(new java.util.Date(), "en", "US"));
		System.out.println(parseDate("02/28/1901", "en", "US"));
		System.out.println(parseDate("", "en", "US"));
        System.out.println(formatObject(null));
        System.out.println(formatObject(new java.sql.Date(new java.util.Date().getTime())));
        System.out.println(formatObject(new java.util.Date()));
        System.out.println(parseDate("28/02/1901"));
        System.out.println(parseDate(""));

        try {
            System.out.println(parseDate("28/08/2004ffje"));
        }
        catch (ParseException pe) {
            System.out.println(pe.getMessage());   
            System.out.println(pe.getErrorOffset());
        }

		//Integer
		System.out.println("\nInteger");
		System.out.println(formatInteger(null, "en", "US"));
		System.out.println(formatObject(new Integer(12345), "en", "US"));
		System.out.println(parseInteger("12,334", "en", "US"));
		System.out.println(parseInteger("123,334", "en", "US"));
		System.out.println(parseInteger("12,33,34", "en", "US"));
		System.out.println(parseInteger("", "en", "US"));
        System.out.println(formatInteger(null));
        System.out.println(formatObject(new Integer(12345)));
        System.out.println(parseInteger("12.334"));
        System.out.println(parseInteger("123.334"));
        System.out.println(parseInteger("12.33.34"));
        System.out.println(parseInteger(""));

        try {
            System.out.println(parseInteger("12g"));
        }
        catch (ParseException pe) {
            System.out.println(pe.getMessage());   
            System.out.println(pe.getErrorOffset());
        }

        try {
            System.out.println(parseInteger("-12g"));
        }
        catch (ParseException pe) {
            System.out.println(pe.getMessage());   
            System.out.println(pe.getErrorOffset());
        }

        try {
            System.out.println(parseInteger("12-g23g"));
        }
        catch (ParseException pe) {
            System.out.println(pe.getMessage());   
            System.out.println(pe.getErrorOffset());
        }

		//Double
		System.out.println("\nDouble");
		System.out.println(formatDouble(null, "en", "US"));
		System.out.println(formatObject(new Double(12345.56), "en", "US"));
		System.out.println(parseDouble("12,334", "en", "US"));
		System.out.println(parseDouble("123334.12", "en", "US"));
		System.out.println(parseDouble("12,33,34.43", "en", "US"));
		System.out.println(parseDouble("", "en", "US"));
        System.out.println(formatDouble(null));
        System.out.println(formatObject(new Double(12345.56)));
        System.out.println(parseDouble("12.334"));
        System.out.println(parseDouble("123334,12"));
        System.out.println(parseDouble("12.33.34,43"));
        System.out.println(parseDouble(""));

        try {
            System.out.println(parseDouble("12,4g"));
        }
        catch (ParseException pe) {
            System.out.println(pe.getMessage());   
            System.out.println(pe.getErrorOffset());
        }

        try {
            System.out.println(parseDouble("-12,76g"));
        }
        catch (ParseException pe) {
            System.out.println(pe.getMessage());   
            System.out.println(pe.getErrorOffset());
        }

        try {
            System.out.println(parseDouble("12,23-g23g"));
        }
        catch (ParseException pe) {
            System.out.println(pe.getMessage());   
            System.out.println(pe.getErrorOffset());
        }

		//Boolean
		System.out.println("\nBoolean");
		System.out.println(formatBoolean(null));
		System.out.println(formatObject(new Boolean(true), "en", "US"));
		System.out.println(parseBoolean("true"));
		System.out.println(parseBoolean(""));
        System.out.println(formatObject(new Boolean(true)));

		// Object
        System.out.println("\nFormatObject");
		System.out.println(formatObject(null, "en", "US"));
		System.out.println(formatObject("hola", "en", "US"));
		System.out.println(formatObject(new Integer(3522), "en", "US"));
		System.out.println(formatObject(new Double(2322.45), "en", "US"));
		System.out.println(formatObject(new Date(new java.util.Date().getTime()), "en", "US"));
		System.out.println(formatObject(new Boolean(true), "en", "US"));
        System.out.println(formatObject(null));
        System.out.println(formatObject("hola"));
        System.out.println(formatObject(new Integer(3522)));
        System.out.println(formatObject(new Double(2322.45)));
        System.out.println(formatObject(new Date(new java.util.Date().getTime())));
        System.out.println(formatObject(new Boolean(true)));

		// Object
        System.out.println("\nParseObject");
		System.out.println(parseObject("hola", "java.lang.String", "en", "US"));
		System.out.println(parseObject("1,234", "java.lang.Integer", "en", "US"));
		System.out.println(parseObject("1,234.54", "java.lang.Double", "en", "US"));
		System.out.println(parseObject("12/7/2001", "java.sql.Date", "en", "US"));
		System.out.println(parseObject("true", "java.lang.Boolean", "en", "US"));
		System.out.println(parseObject("pepote", "desconocido", "en", "US"));
		System.out.println(parseObject("7/13/2001", "java.sql.Date", "en", "US"));
        System.out.println(parseObject("hola", "java.lang.String"));
        System.out.println(parseObject("1.234", "java.lang.Integer"));
        System.out.println(parseObject("1.234,54", "java.lang.Double"));
        System.out.println(parseObject("12/7/2001", "java.sql.Date"));
        System.out.println(parseObject("true", "java.lang.Boolean"));
        System.out.println(parseObject("pepote", "desconocido"));
        System.out.println(parseObject("13/7/2001", "java.sql.Date"));

		// Sin separador de miles
		System.out.println(thousandRemove("2.323", "es", "ES"));
		System.out.println(thousandRemove("2.232,3", "es", "ES"));
		System.out.println(thousandRemove("2,323", "en", "US"));
		System.out.println(thousandRemove("43,542,323.23", "en", "US"));
		*/
		
		String decimalPattern = "#,##0.##";
		String datePattern = "MM/dd/yyyy";
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		symbols.setGroupingSeparator(',');
		
		String intValueStr = "1,123,456";
		Integer intValue = new Integer(1123456);
		String doubleValueStr = "12,345.45";
		Double doubleValue = new Double(12345.45);
		String booleanValueStr = "false";
		Boolean booleanValue = new Boolean(true);
		String dateValueStr = "03/10/2004";
		java.util.Date dateValue = (new SimpleDateFormat(datePattern)).parse(dateValueStr);
		System.out.println("Format " + intValue.intValue() + ": " + formatObject(intValue, decimalPattern, symbols));
		System.out.println("Format " + doubleValue.doubleValue() + ": " + formatObject(doubleValue, decimalPattern, symbols));
		System.out.println("Format " + booleanValue.booleanValue() + ": " + formatObject(booleanValue, decimalPattern, symbols));
		System.out.println("Format " + dateValue.toString() + ": " + formatObject(dateValue, datePattern, symbols));
		System.out.println("Parse " + intValueStr + ": " + parseObject(intValueStr, Integer.class.getName(), decimalPattern, symbols));
		System.out.println("Parse " + doubleValueStr + ": " + parseObject(doubleValueStr, Double.class.getName(), decimalPattern, symbols));
		System.out.println("Parse " + booleanValueStr + ": " + parseObject(booleanValueStr, Boolean.class.getName(), decimalPattern, symbols));
		System.out.println("Format " + dateValueStr + ": " + parseObject(dateValueStr, java.util.Date.class.getName(), datePattern, symbols));
	}
}