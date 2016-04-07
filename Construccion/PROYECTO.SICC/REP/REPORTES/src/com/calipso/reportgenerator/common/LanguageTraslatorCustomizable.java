package com.calipso.reportgenerator.common;

import org.apache.commons.configuration.Configuration;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

import es.indra.mare.common.info.InfoException;
import com.calipso.reportgenerator.common.LanguageTraslator;
import com.calipso.reportgenerator.common.ILanguageTraslator;

/**
 * Representa el diccionario que contiene las frases
 * que utiliza la aplicacion.
 * Dichas clases escritas en un lenguaje determinado,
 * las cuales son cargadas a la instancia de Map del
 * objeto.
 */

public class LanguageTraslatorCustomizable implements ILanguageTraslator{

  private Map values;

  /**
   * Inicializa una instancia de LanguageTraslatorCustomizable
   * @param configuration
   * @throws es.indra.mare.common.info.InfoException
   */
  public LanguageTraslatorCustomizable(Configuration configuration) throws InfoException {
    fillValues(configuration);
    validate();
  }

  /**
   * Devuelve el diccionario con las frases
   * correspondiente al idioma determinado
   * @return
   */
  public Map getValues() {
    if (values==null){
      values = new HashMap();
    }
    return values;
  }

  /**
   * Llena el diccionario con las frases correspondientes
   * @param reportGeneratorConfiguration
   */
  private void fillValues(Configuration reportGeneratorConfiguration) {
    Iterator iter = reportGeneratorConfiguration.getKeys();
    while (iter.hasNext()) {
      String key = (String) iter.next();
      String value = reportGeneratorConfiguration.getString(key);
      getValues().put(key,value);
    }
  }

  /**
   * Valida el diccionario
   * @throws es.indra.mare.common.info.InfoException
   */
  public void validate() throws InfoException {
    if (values.isEmpty()){
      throw new InfoException(LanguageTraslator.traslate("81"));
    }
  }

  /**
   * Devuelve el String en un idioma determinado
   * a partir del id.
   * @param id
   * @return
   */
  public String getExceptionFromId(String id){
    return (String) values.get(id);
  }

    public Map getDictionary() {
      return getValues();  
    }
}
