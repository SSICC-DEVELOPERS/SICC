package es.indra.utils;

/**
 * Esta clase lee parámetros de configuración de la aplicación
 *
 * @version 1.0
 */
public final class Config
{
  private static ConfigProvider configProvider = null;

  /**
   * Devuelve el valor de un parámetro de configuración
   * @param paramName El nombre del parámetro de configuración
   * @return El valor del parámetro de configuración
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
