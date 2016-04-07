package es.indra.utils;

import java.util.*;
import java.io.*;

/** 
 * Esta clase gestiona los parámetros de configuración almacenados en un fichero de texto
 * Contiene una referencia hard-code al fichero de parámetros de configuración
 * Esta debería ser la única referencia hard-code del proyecto
 * 
 * @version 1.0
 */
public class ConfigFile 
  implements ConfigProvider
{
  private java.util.Hashtable cache;
  private String directorio;
  private String fichero;
  
  /**
   * Inicializa y carga los parámetros en una caché
   */
  public void init() 
    throws java.io.IOException
  {
    // A continuación se hace una referencia al fichero que almacena los parámetros de configuración
    // Debería cambiarse para adaptarla a cada proyecto
    ResourceBundle bundle = new PropertyResourceBundle(
        new FileInputStream(System.getProperty("propertiesPath", "/ipt") + "/app.properties"));

    cache = new java.util.Hashtable();

    for (Enumeration e = bundle.getKeys(); e.hasMoreElements();)
    {
      String key = (String) e.nextElement();
      cache.put(key, bundle.getString(key));
    }
  }
  
  /**
   * Devuelve el valor de un parámetro de configuración
   * @param paramName El nombre del parámetro de configuración
   * @return El valor del parámetro de configuración
   */
  public String get(String paramName)
  {
    return (String) cache.get(paramName);
  }
}    