package es.indra.utils;

/**
 * Este interfaz representa a una fuente de par�metros de configuraci�n
 * Fuentes posibles podr�an ser las siguientes: Un directorio LDAP, un fichero de texto, ...
 *
 * @version 1.0
 */
public interface ConfigProvider
{
  /**
   * Inicializa y carga los par�metros en una cach�
   */
  public void init() 
    throws java.io.IOException;

  /**
   * Devuelve el valor de un par�metro de configuraci�n
   * @param paramName El nombre del par�metro de configuraci�n
   * @return El valor del par�metro de configuraci�n
   */
  public String get(String paramName);
}
