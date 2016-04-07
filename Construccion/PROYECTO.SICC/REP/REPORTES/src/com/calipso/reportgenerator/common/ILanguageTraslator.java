package com.calipso.reportgenerator.common;

import java.util.Map;

/**
 * Interface que implementan todas las clases que traduzcan a un
 * idioma determinado. EJ: LanguageTraslatorSPANISH
 */

public interface ILanguageTraslator {
  public String getExceptionFromId(String id);
  public Map getDictionary();
}
