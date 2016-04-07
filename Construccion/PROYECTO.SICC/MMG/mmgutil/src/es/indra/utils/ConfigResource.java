package es.indra.utils;

import java.util.*;
import java.io.*;

/** 
 * Esta clase gestiona los parámetros de configuración almacenados en un fichero accesible por el classpath
 * y cargado con el ClassLoader, de forma que puede estar empaquetado en el jar de las clases
 * 
 * @version 1.0
 */
public class ConfigResource
  implements ConfigProvider
{
  private java.util.Hashtable cache;

  /**
   * Inicializa y carga los parámetros en una caché
   */
  public void init() 
    throws java.io.IOException
  {
    // A continuación se hace una referencia al fichero que almacena los parámetros de configuración
    // Debería cambiarse para adaptarla a cada proyecto
    ResourceBundle bundle = new PropertyResourceBundle(getClass().getClassLoader().getResourceAsStream("app.properties"));

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