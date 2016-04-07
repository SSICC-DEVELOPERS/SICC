package es.indra.utils;

import java.util.*;
import java.io.*;

/** 
 * Esta clase gestiona los par�metros de configuraci�n almacenados en un fichero de texto
 * Contiene una referencia hard-code al fichero de par�metros de configuraci�n
 * Esta deber�a ser la �nica referencia hard-code del proyecto
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
   * Inicializa y carga los par�metros en una cach�
   */
  public void init() 
    throws java.io.IOException
  {
    // A continuaci�n se hace una referencia al fichero que almacena los par�metros de configuraci�n
    // Deber�a cambiarse para adaptarla a cada proyecto
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
   * Devuelve el valor de un par�metro de configuraci�n
   * @param paramName El nombre del par�metro de configuraci�n
   * @return El valor del par�metro de configuraci�n
   */
  public String get(String paramName)
  {
    return (String) cache.get(paramName);
  }
}    