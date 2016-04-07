package es.indra.utils;

/**
 * Esta clase lee par�metros de configuraci�n de la aplicaci�n
 *
 * @version 1.0
 */
public final class Config
{
  private static ConfigProvider configProvider = null;

  /**
   * Devuelve el valor de un par�metro de configuraci�n
   * @param paramName El nombre del par�metro de configuraci�n
   * @return El valor del par�metro de configuraci�n
   */
  public static synchronized String get(String paramName) throws Exception
  {
    if (configProvider == null) 
    {
      if (System.getProperty("propertiesSide", "client").toUpperCase().equals("SERVER"))
      {
        configProvider = new ConfigFile();
      }
      else
      {
        configProvider = new ConfigResource();
      }

      configProvider.init();
    }
    return (String) configProvider.get(paramName);
  }
}
