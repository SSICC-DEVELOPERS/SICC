package es.indra.utils;

/**
 * Este interfaz representa a una fuente de parámetros de configuración
 * Fuentes posibles podrían ser las siguientes: Un directorio LDAP, un fichero de texto, ...
 *
 * @version 1.0
 */
public interface ConfigProvider
{
  /**
   * Inicializa y carga los parámetros en una caché
   */
  public void init() 
    throws java.io.IOException;

  /**
   * Devuelve el valor de un parámetro de configuración
   * @param paramName El nombre del parámetro de configuración
   * @return El valor del parámetro de configuración
   */
  public String get(String paramName);
}
