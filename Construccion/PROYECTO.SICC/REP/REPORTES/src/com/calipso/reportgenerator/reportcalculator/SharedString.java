package com.calipso.reportgenerator.reportcalculator;

import java.util.HashMap;
import java.io.Serializable;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.Configuration;
import com.calipso.reportgenerator.common.LanguageTraslatorCustomizable;
import com.calipso.reportgenerator.common.ILanguageTraslator;
import com.calipso.reportgenerator.common.ReportManagerLogger;


/**
 * Implementación de un Flyweight de String, para hacer mejor uso de la memoria
 */

public class SharedString implements Serializable, Comparable, CubeValue {
  private final String value;
  // Se sugería un número primo para el tamaño
  static final private HashMap strings = new HashMap(5003, 0.80f);
  static final private HashMap monTraslateLanguage = new HashMap();
  static final private HashMap monthTraslateLanguage = new HashMap();
  static final private HashMap dayTraslateLanguage = new HashMap();
  static final private HashMap dyTraslateLanguage = new HashMap();
  static private String language;
  static private ILanguageTraslator currentLanguage;

  public SharedString(String aValue) {
    value = aValue;
    strings.put(aValue, this);
  }

  static public SharedString newFrom(String aValue) {
    Object string;

    string = strings.get(aValue);
    if (string == null) {
      return new SharedString(aValue);
    }
    else {
      return (SharedString) string;
    }
  }

  public String value() {
    return value;
  }

  public boolean equals(Object o) {
    final String string;
    if (this == o) return true;

    if (o instanceof String) {
      string = (String) o;
    }
    else {
      string = ((SharedString) o).value;
    }
    if (!value.equals(string)) return false;
    return true;
  }

  public int hashCode() {
    return value.hashCode();
  }

  public String toString(){
    return value;
  }

  public int compareTo(Object o) {
    if ((toString()== null )&&(o.toString()==null)){
      return 0;
    }else if (toString()== null ){
      return -1;
    }else if ((o.toString()==null)){
      return 1;
    }else {
      return toString().compareTo(o.toString());
    }
  }

  public Object getValue() {
    return value;
  }  
  
  public String format(String outputFormatPattern, String inputSeparator, Long language){
  /**
   * Recibe como parametro de entrada una fecha en formato dd/MM/yyyy
   * Devuelve formateado segun el outputFormatPattern ingresado, en el idioma language.
   * Si se trata de una concatenacion de fechas se debera indicar el separador (inputSeparator) de cada elemento a traducir.
   */
      String inputString = this.getValue().toString();
      String outputString = "";
      try {
        setLanguage(language.toString());
        if (outputFormatPattern.equalsIgnoreCase("DD-MMM")) {
             createTraslatorLanguageMon();
             outputString = createFormatDD_Mon(inputString, inputSeparator);
        } else if (outputFormatPattern.equalsIgnoreCase("MMM DD")){
             createTraslatorLanguageMon();
             outputString = createFormatMon_DD(inputString, inputSeparator);
        } else if (outputFormatPattern.equalsIgnoreCase("Month YYYY")){
             createTraslatorLanguageMonth();
             outputString = createFormatMonth_YYYY(inputString, inputSeparator);
        } else if (outputFormatPattern.equalsIgnoreCase("DD MMM")){
             createTraslatorLanguageMon();
             outputString = createFormatDD_Mon2(inputString, inputSeparator);
        } else if (outputFormatPattern.equalsIgnoreCase("DD Month YYYY")){
             createTraslatorLanguageMonth();
             outputString = createFormatDD_Month_YYYY(inputString, inputSeparator);
        } else if (outputFormatPattern.equalsIgnoreCase("DD MMM YYYY")){
             createTraslatorLanguageMonth();
             outputString = createFormatDD_Mon_YYYY(inputString, inputSeparator);
        } else if (outputFormatPattern.equalsIgnoreCase("Day")){
             createTraslatorLanguageDay();
             outputString = createFormatDay(inputString, inputSeparator);
        } else if (outputFormatPattern.equalsIgnoreCase("Dy")){
             createTraslatorLanguageDy();
             outputString = createFormatDy(inputString, inputSeparator);
        } 
        
        if (outputString.equalsIgnoreCase("")) {
            outputString = inputString;
        }    
      } catch (Exception e) {
          outputString = inputString;
          e.printStackTrace();
      }
      return outputString;
  }

  private String createFormatDD_Mon(String inputString, String inputSeparator){
      String outputString = "";
      int index = 0;
      
        if (inputSeparator.equalsIgnoreCase("") ) {
          outputString = FormatDD_Mon(cutTags(inputString,index,inputString.length()));
        } else {
          while (index > -1) {
                int endTag = searchTag(inputString, index, inputSeparator);
                if (endTag > -1){
                    outputString = outputString + FormatDD_Mon(cutTags(inputString,index,endTag));
                } else {
                    outputString = outputString + FormatDD_Mon(cutTags(inputString,index,inputString.length()));
                    break;
                }
                index = endTag + 1;
          }
        }
      return outputString;
  }

  private String createFormatDD_Mon2(String inputString, String inputSeparator){
      String outputString = "";
      int index = 0;
      
        if (inputSeparator.equalsIgnoreCase("") ) {
          outputString = FormatDD_Mon2(cutTags(inputString,index,inputString.length()));
        } else {
          while (index > -1) {
                int endTag = searchTag(inputString, index, inputSeparator);
                if (endTag > -1){
                    outputString = outputString + FormatDD_Mon2(cutTags(inputString,index,endTag));
                } else {
                    outputString = outputString + FormatDD_Mon2(cutTags(inputString,index,inputString.length()));
                    break;
                }
                index = endTag + 1;
          }
        }
      return outputString;
  }

    private String createFormatMon_DD(String inputString, String inputSeparator){
        String outputString = "";
        int index = 0;
        if (inputSeparator.equalsIgnoreCase("") ) {
          outputString = FormatMon_DD(cutTags(inputString,index,inputString.length()));
        } else {
            while (index > -1) {
                  int endTag = searchTag(inputString, index, inputSeparator);
                  if (endTag > -1){
                      outputString = outputString + FormatMon_DD(cutTags(inputString,index,endTag));
                  } else {
                      outputString = outputString + FormatMon_DD(cutTags(inputString,index,inputString.length()));
                      break;
                  }
                  index = endTag + 1;
            }
        }
        return outputString;
    }

    private String createFormatMonth_YYYY(String inputString, String inputSeparator){
        String outputString = "";
        int index = 0;
        if (inputSeparator.equalsIgnoreCase("") ) {
          outputString = FormatMonth_YYYY(cutTags(inputString,index,inputString.length()));
        } else {
          while (index > -1) {
                int endTag = searchTag(inputString, index, inputSeparator);
                if (endTag > -1){
                    outputString = outputString + FormatMonth_YYYY(cutTags(inputString,index,endTag));
                } else {
                    outputString = outputString + FormatMonth_YYYY(cutTags(inputString,index,inputString.length()));
                    break;
                }
                index = endTag + 1;
          }
        }
        return outputString;
    }

    private String createFormatDD_Month_YYYY(String inputString, String inputSeparator){
        String outputString = "";
        int index = 0;
        if (inputSeparator.equalsIgnoreCase("") ) {
          outputString = FormatDD_Month_YYYY(cutTags(inputString,index,inputString.length()));
        } else {
          while (index > -1) {
                int endTag = searchTag(inputString, index, inputSeparator);
                if (endTag > -1){
                    outputString = outputString + FormatDD_Month_YYYY(cutTags(inputString,index,endTag));
                } else {
                    outputString = outputString + FormatDD_Month_YYYY(cutTags(inputString,index,inputString.length()));
                    break;
                }
                index = endTag + 1;
          }
        }
        return outputString;
    }

    private String createFormatDD_Mon_YYYY(String inputString, String inputSeparator){
        String outputString = "";
        int index = 0;
        if (inputSeparator.equalsIgnoreCase("") ) {
          outputString = FormatDD_Mon_YYYY(cutTags(inputString,index,inputString.length()));
        } else {
          while (index > -1) {
                int endTag = searchTag(inputString, index, inputSeparator);
                if (endTag > -1){
                    outputString = outputString + FormatDD_Mon_YYYY(cutTags(inputString,index,endTag));
                } else {
                    outputString = outputString + FormatDD_Mon_YYYY(cutTags(inputString,index,inputString.length()));
                    break;
                }
                index = endTag + 1;
          }
        }
        return outputString;
    }

    private String createFormatDay(String inputString, String inputSeparator){
        String outputString = "";
        int index = 0;
        if (inputSeparator.equalsIgnoreCase("") ) {
          outputString = FormatDay(cutTags(inputString,index,inputString.length()));
        } else {
          while (index > -1) {
                int endTag = searchTag(inputString, index, inputSeparator);
                if (endTag > -1){
                    outputString = outputString + FormatDay(cutTags(inputString,index,endTag));
                } else {
                    outputString = outputString + FormatDay(cutTags(inputString,index,inputString.length()));
                    break;
                }
                index = endTag + 1;
          }
        }
        return outputString;
    }

    private String createFormatDy(String inputString, String inputSeparator){
        String outputString = "";
        int index = 0;
        if (inputSeparator.equalsIgnoreCase("") ) {
          outputString = FormatDy(cutTags(inputString,index,inputString.length()));
        } else {
          while (index > -1) {
                int endTag = searchTag(inputString, index, inputSeparator);
                if (endTag > -1){
                    outputString = outputString + FormatDy(cutTags(inputString,index,endTag));
                } else {
                    outputString = outputString + FormatDy(cutTags(inputString,index,inputString.length()));
                    break;
                }
                index = endTag + 1;
          }
        }
        return outputString;
    }

  private int searchTag(String string, int index, String tag){
      int first = string.indexOf(tag, index);
      return first;
  }

  private String cutTags(String string, int initTag, int endTag){
      return string.substring(initTag, endTag);
  }

  static private void createTraslatorLanguageMon(){
     if (monTraslateLanguage.isEmpty()) {
       currentLanguage = getLanguageTraslator();
        monTraslateLanguage.put("01", traslate("2555"));
        monTraslateLanguage.put("02", traslate("2556"));
        monTraslateLanguage.put("03", traslate("2557"));
        monTraslateLanguage.put("04", traslate("2558"));
        monTraslateLanguage.put("05", traslate("2559"));
        monTraslateLanguage.put("06", traslate("2560"));
        monTraslateLanguage.put("07", traslate("2561"));
        monTraslateLanguage.put("08", traslate("2562"));
        monTraslateLanguage.put("09", traslate("2563"));
        monTraslateLanguage.put("10", traslate("2564"));
        monTraslateLanguage.put("11", traslate("2565"));
        monTraslateLanguage.put("12", traslate("2566"));
     }
  }
  
  static private void createTraslatorLanguageMonth(){
     if (monthTraslateLanguage.isEmpty()) {
       currentLanguage = getLanguageTraslator();
        monthTraslateLanguage.put("01", traslate("2013"));
        monthTraslateLanguage.put("02", traslate("2014"));
        monthTraslateLanguage.put("03", traslate("2015"));
        monthTraslateLanguage.put("04", traslate("2016"));
        monthTraslateLanguage.put("05", traslate("2017"));
        monthTraslateLanguage.put("06", traslate("2018"));
        monthTraslateLanguage.put("07", traslate("2019"));
        monthTraslateLanguage.put("08", traslate("2020"));
        monthTraslateLanguage.put("09", traslate("2021"));
        monthTraslateLanguage.put("10", traslate("2022"));
        monthTraslateLanguage.put("11", traslate("2023"));
        monthTraslateLanguage.put("12", traslate("2024"));
     }
  }

  static private void createTraslatorLanguageDay(){
     if (dayTraslateLanguage.isEmpty()) {
       currentLanguage = getLanguageTraslator();
        dayTraslateLanguage.put("01", traslate("2554"));
        dayTraslateLanguage.put("02", traslate("2548"));
        dayTraslateLanguage.put("03", traslate("2549"));
        dayTraslateLanguage.put("04", traslate("2550"));
        dayTraslateLanguage.put("05", traslate("2551"));
        dayTraslateLanguage.put("06", traslate("2552"));
        dayTraslateLanguage.put("07", traslate("2553"));
     }
  }

  static private void createTraslatorLanguageDy(){
     if (dyTraslateLanguage.isEmpty()) {
       currentLanguage = getLanguageTraslator();
        dyTraslateLanguage.put("01", traslate("2547"));
        dyTraslateLanguage.put("02", traslate("2541"));
        dyTraslateLanguage.put("03", traslate("2542"));
        dyTraslateLanguage.put("04", traslate("2543"));
        dyTraslateLanguage.put("05", traslate("2544"));
        dyTraslateLanguage.put("06", traslate("2545"));
        dyTraslateLanguage.put("07", traslate("2546"));
     }
  }

    static public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    static private  ILanguageTraslator getLanguageTraslator(){
        try{
            Configuration configuration = new PropertiesConfiguration(getLanguagePath());
            currentLanguage = new LanguageTraslatorCustomizable(configuration);
        } catch (Exception e)  {
            e.printStackTrace();
        }
        return currentLanguage;
    }


    static private String getLanguagePath()
    {
        String path = "";
        String property = System.getProperty("MareConfigurationRoot");        
        if(property != null) {
           path = property + "/reportes/language_"+getLanguage()+".properties";
        } else {
          property = System.getProperty("CalipsoConfigurationRoot");
          if(property != null) {
            path = property + "/Language_"+getLanguage()+".properties";
          }else
          {
            path = "./language_"+getLanguage()+".properties";
          }
        }
        return path;
    }

  public static String traslate(String id) {
    String s = "";
    try {
      s = currentLanguage.getExceptionFromId(id);
    } catch (Exception e) {
      ReportManagerLogger.error("Traslate Error:"+id);
      s = id;
    }
    return s;
  }

    private String FormatMon_DD(String inputString){
        String outputString = "";
        String dayValue = "";
        int index = 0;
        int endTag = searchTag(inputString, index, "/");
        if (endTag > -1) {
              dayValue = cutTags(inputString, index, endTag);
              index = endTag + 1;
              endTag = searchTag(inputString, index, "/");
              if (endTag > -1) {
                 outputString = monTraslateLanguage.get(cutTags(inputString, index, endTag)) + " " + dayValue + " ";
              } else {
                 outputString = monTraslateLanguage.get(cutTags(inputString, index, inputString.length())) + " " + dayValue + " ";
              }
        }
        return outputString;
    }

    private String FormatDD_Mon(String inputString){
      String outputString = "";
      int index = 0;
      int endTag = searchTag(inputString, index, "/");
      if (endTag > -1) {
            outputString = cutTags(inputString, index, endTag);
            index = endTag + 1;
            endTag = searchTag(inputString, index, "/");
            if (endTag > -1) {
               outputString = outputString + "-" + monTraslateLanguage.get(cutTags(inputString, index, endTag)) + " ";
            } else {
               outputString = outputString + "-" + monTraslateLanguage.get(cutTags(inputString, index, inputString.length())) + " ";
            }
      }
      return outputString;
  }

    private String FormatDD_Mon2(String inputString){
      String outputString = "";
      int index = 0;
      int endTag = searchTag(inputString, index, "/");
      if (endTag > -1) {
            outputString = cutTags(inputString, index, endTag);
            index = endTag + 1;
            endTag = searchTag(inputString, index, "/");
            if (endTag > -1) {
               outputString = outputString + " " + monTraslateLanguage.get(cutTags(inputString, index, endTag)) + " ";
            } else {
               outputString = outputString + " " + monTraslateLanguage.get(cutTags(inputString, index, inputString.length())) + " ";
            }
      }
      return outputString;
  }


    private String FormatMonth_YYYY(String inputString){
        String outputString = "";
        String dayValue = "";
        String monthValue = "";
        int index = 0;
        int endTag = searchTag(inputString, index, "/");
        if (endTag > -1) {
            dayValue = cutTags(inputString, index, endTag);
            index = endTag + 1;
            endTag = searchTag(inputString, index, "/");
            if (endTag > -1) {
                monthValue = cutTags(inputString, index, endTag);
                index = endTag + 1;
                outputString = monthTraslateLanguage.get(monthValue) + " " + cutTags(inputString, index, inputString.length()) + " ";
            }
        }
        return outputString;
    }

    private String FormatDD_Month_YYYY(String inputString){
        String outputString = "";
        String dayValue = "";
        String monthValue = "";
        int index = 0;
        int endTag = searchTag(inputString, index, "/");
        if (endTag > -1) {
            dayValue = cutTags(inputString, index, endTag);
            index = endTag + 1;
            endTag = searchTag(inputString, index, "/");
            if (endTag > -1) {
                monthValue = cutTags(inputString, index, endTag);
                index = endTag + 1;
                outputString = dayValue + " " + monthTraslateLanguage.get(monthValue) + " " + cutTags(inputString, index, inputString.length()) + " ";
            }
        }
        return outputString;
    }

    private String FormatDD_Mon_YYYY(String inputString){
        String outputString = "";
        String dayValue = "";
        String monthValue = "";
        int index = 0;
        int endTag = searchTag(inputString, index, "/");
        if (endTag > -1) {
            dayValue = cutTags(inputString, index, endTag);
            index = endTag + 1;
            endTag = searchTag(inputString, index, "/");
            if (endTag > -1) {
                monthValue = cutTags(inputString, index, endTag);
                index = endTag + 1;
                outputString = dayValue + " " + monTraslateLanguage.get(monthValue) + " " + cutTags(inputString, index, inputString.length()) + " ";
            }
        }
        return outputString;
    }

    private String FormatDay(String inputString){
        String outputString = "";
        String dayValue = "";
        int index = 0;
        dayValue = cutTags(inputString, index, inputString.length());
        outputString = dayTraslateLanguage.get(dayValue) + " ";
        if (outputString.equalsIgnoreCase("null ")) {
          outputString = "";
        }
        return outputString;
    }
    
    private String FormatDy(String inputString){
        String outputString = "";
        String dayValue = "";
        int index = 0;
        dayValue = cutTags(inputString, index, inputString.length());
        outputString = dyTraslateLanguage.get(dayValue) + " ";
        if (outputString.equalsIgnoreCase("null ")) {
          outputString = "";
        }
        return outputString;
    }
    
}