package com.calipso.reportgenerator.reportmanager;

import com.calipso.reportgenerator.reportdefinitions.ReportSourceDefinition;
import com.calipso.reportgenerator.reportdefinitions.ReportView;
import com.calipso.reportgenerator.reportdefinitions.Localizations;
import com.calipso.reportgenerator.reportdefinitions.Localization;
import com.calipso.reportgenerator.reportdefinitions.ReportDefinition;

import java.util.Locale;
import java.util.Map;
import java.util.Hashtable;
import java.io.Serializable;

/**
 * Traduce a los distintos lenguajes los string de las definiciones
 */
public class DefinitionTraslator implements Serializable{
  private ReportDefinition reportDefinition;
  private ReportSourceDefinition reportSourceDefinition;
  private ReportView reportView;
  private Locale locale;
  private Map localizationMap;

  public DefinitionTraslator(ReportDefinition reportDefinition, Locale locale) {
    this.reportDefinition = reportDefinition;
    this.locale = locale;
  }

  public DefinitionTraslator(ReportSourceDefinition reportSourceDefinition, Locale locale) {
    this.reportSourceDefinition = reportSourceDefinition;
    this.locale = locale;
  }

  public DefinitionTraslator(ReportDefinition reportDefinition, String language, String country) {
    this.reportDefinition = reportDefinition;
    this.locale = new Locale(language,country);
  }

  public DefinitionTraslator(ReportSourceDefinition reportSourceDefinition, String language,String country) {
    this.reportSourceDefinition = reportSourceDefinition;
    this.locale = new Locale(language, country);
  }

  public String traslate(String value){
    if (isMultilanguage() && (localizationMap != null) && (value != null ) && localizationMap.containsKey(value)){
      return localizationMap.get(value).toString();
    } else {
      return value;
    }
  }

  private boolean isMultilanguage() {
    if (reportView != null){
      return reportDefinition.getMultilanguage();
    } else if (reportDefinition != null){
      return reportDefinition.getMultilanguage();
    } else if (reportSourceDefinition != null){
      return reportSourceDefinition.getMultilanguage();
    }
    return false;
  }

  private Map getLocalizacionMap() {
    if (localizationMap == null ){
      Localization localization = getLocalizationFromLocale(reportDefinition.getLocalizations());
      if (localization !=null){
        localizationMap = createMapLocazation(localization);
      }
    }
    return localizationMap;
  }

  private Map getLocalizacionMap(ReportSourceDefinition reportSourceDefinition){
    Localization localization = getLocalizationFromLocale(reportSourceDefinition.getLocalizations());
    if (localization !=null){
      return createMapLocazation(localization);
    }
    return null;
  }

  /**
   * Crea un Map con la lista de los literales para las conversiones
   * @param localization
   * @return
   */
  private Map createMapLocazation(Localization localization) {
    Map localeMap= new Hashtable();
    for (int i=0;i<localization.getLiteralsCount();i++){
      localeMap.put(localization.getLiterals()[i].getCode(),localization.getLiterals()[i].getValue());
    }
    return localeMap;
  }

  /**Obtiene el localization para el locale corespondiente
   *
   * @param localizations
   * @return
   */
  private Localization getLocalizationFromLocale(Localizations localizations) {
    Localization localization;
    if (localizations != null){
      for (int i=0;i<localizations.getLocalizationCount();i++){
        localization = localizations.getLocalization()[i];
        if (localization.getLocale().equalsIgnoreCase(locale.toString())){
          return localization;
        };
      }
    }
    return null;
  }

  public String getDescription(){
    if (reportView != null){
      return traslate(reportView.getId());
    }else if (reportDefinition != null){
      return traslate(reportDefinition.getDescription());
    } else if (reportSourceDefinition != null){
      return traslate(reportSourceDefinition.getId());
    }
    return "";
  }

  public DefinitionTraslator(ReportView reportView, ReportDefinition reportDefinition, String language, String country) {
    this.reportView = reportView;
    this.reportDefinition = reportDefinition;
    this.locale = new Locale(language,country);
  }

  public DefinitionTraslator(ReportView reportView, ReportDefinition reportDefinition, Locale locale) {
    this.reportView = reportView;
    this.reportDefinition = reportDefinition;
    this.locale = locale;
  }


}
