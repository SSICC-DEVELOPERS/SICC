package com.calipso.common;

import es.indra.mare.common.info.InfoException;

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.io.Serializable;
import com.calipso.reportgenerator.reportcalculator.SharedDate;
import com.calipso.reportgenerator.common.LanguageTraslator;

/**
 * Representa una fecha con sus formatos
 */
public class DateEx implements Serializable, Comparable {
  //NOTA: Es necesario hacer el new ArrayList, ya que luego se utilizara el add(index, object), no soportado por la lista de Arrays.asList()
  private static final List possiblePatterns = new ArrayList(Arrays.asList(new Object[] {"yyyyMMdd", "yyyyMMddHHmmssSSS"}));

  private Date date;

  public DateEx(Object object) throws InfoException{
    setDateFromObject(object, "");
  }

  private void setDateFromObject(Object date, String inputFormat) throws InfoException{
    Date newDate = null;
    if(date instanceof String){
      String localDate = ((String)date).trim();
      newDate = getDateFromString(localDate, inputFormat);
    }else if(date instanceof Date){
      newDate = (Date)date;
    }
    if(newDate != null){
      this.date = newDate;
    }else{
      //throw new InfoException(LanguageTraslator.traslate("77"));
    }
  }

  public DateEx(Date date) {
    this.date = date;
  }

  public DateEx(Object date, String inputFormat) throws InfoException {
    setDateFromObject(date, inputFormat);
  }

  /**
   * Este constructor genera el Date a partir de un double.
   * Primero trata de crearlo a partir de la conversion a string del numero,
   * respetando el input format del DataSourceDefinition.
   * Luego, si ese no se pudo completar intenta con el formato de fechas de Microsoft,
   * por si es un double pasado desde un data source excel.
   * @param date
   * @param inputFormat
   * @throws InfoException
   */
  public DateEx(Number date, String inputFormat) throws InfoException{
    Format numberFormat = new DecimalFormat("#####################");
    String value = numberFormat.format(date);
    try{
      setDateFromObject(value, inputFormat);
    }catch (InfoException e){
      DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
      Date expiration;
      try{
        expiration = dateFormat.parse("18991230");
      }catch (ParseException e1){
        throw new InfoException(LanguageTraslator.traslate("77"), e1);
      }
      GregorianCalendar gregorianCalendar = new GregorianCalendar();
      gregorianCalendar.setTime(expiration);
      gregorianCalendar.add(GregorianCalendar.DAY_OF_YEAR,(new Integer(value)).intValue());
      this.date = gregorianCalendar.getTime();
    }
  }

  /**
   * Este metodo trata de obtener un Date de un String realizando "parse" varias veces, con cada formato definido.
   * Los formatos estaran definidos por el parametro inputFormat, por los formatos comunes definidos en la variable local
   * possiblePatterns. Por ultimo se utiliza el formato que se obtiene del Locale, obtenido de LanguageTranslator.getLocal().
   * Si todos los parse fallan, se retornara null.
   * @param localDate El String a parsear
   * @param inputFormat El formato con el que se espera recibir la fecha. Puede ser null o ""
   * @return Una fecha si funciono algun Parse. Null en caso contrario
   */
  private Date getDateFromString(String localDate, String inputFormat) {
    Date result = null;
    if(inputFormat!=null && !inputFormat.equalsIgnoreCase("")){
      setFirst(possiblePatterns, inputFormat);
    }
    for (Iterator iterator = possiblePatterns.iterator(); result==null && iterator.hasNext();) {
      String pattern = (String)iterator.next();
      DateFormat format = new SimpleDateFormat(pattern);
      format.setLenient(false);
      try {
        result = format.parse(localDate);
      } catch (ParseException e) {
        //Continuar con el siguiente formato
      }
    }
    if(result==null){
      DateFormat format = SimpleDateFormat.getDateInstance(DateFormat.SHORT, LanguageTraslator.getLocale());
      try {
        format.parse(localDate);
      } catch (ParseException e) {
        //Retorna null
      }
    }
    return result;
  }

  private void setFirst(List posiblepatterns, String inputFormat) {
    if(posiblepatterns.contains(inputFormat)){
      posiblepatterns.remove(inputFormat);
    }
    Object tmp = posiblepatterns.get(0);
    if(!inputFormat.equals(tmp)){
      posiblepatterns.set(0, inputFormat);
      posiblepatterns.add(tmp);
    }
  }

  public String toString() {
    SimpleDateFormat dateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance(DateFormat.SHORT, LanguageTraslator.getLocale());//new SimpleDateFormat(LanguageTraslator.getLocale().getd);
    return new String(dateFormat.format((date)));
  }

  public Date getDate() {
    return date;
  }

  public int compareTo(Object o) {
    if (o instanceof DateEx) {
      return date.compareTo(((DateEx) o).getDate());
    }
    else {
      if (o instanceof SharedDate) {
        return date.compareTo(((SharedDate) o).getDateEx().getDate());
      }
      else {
        if (o instanceof Date) {
          return date.compareTo(((Date) o));
        }
        else {
          if (o instanceof String) {
            //Date localDate;
            //DateFormat dateFormat;
            //dateFormat = new SimpleDateFormat("yyyyMMdd");
            try {
              DateEx localDate = new DateEx(o, "");
              //    localDate = dateFormat.parse((String) o);
              return date.compareTo(localDate.date);
            }
            catch (Exception e) {
              return -1;
            }
          }
        }
      }
    }
    return -1;
  }

  public boolean equals(Object o){
    if (o==null)
    {
      if (date==null){
        return true;
      }else{
        return false;
      }
    }
    if (date == null) return false;
    return ((DateEx)o).getDate().equals(date);
  }

  /*public String toNumberFormat() {
    DateFormat dateFormat;
    if(inputFormat!=null && !inputFormat.equalsIgnoreCase("")){
      dateFormat = new SimpleDateFormat(inputFormat);
    } else {
      dateFormat = new SimpleDateFormat("yyyyMMdd");
    }
    return dateFormat.format(date);
  }*/

}