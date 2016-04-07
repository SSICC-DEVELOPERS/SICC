package es.indra.sicc.comunapplet.properties;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesApplet 
{
  private static PropertiesApplet pm = null;
  private static ResourceBundle principal = null;
  private static Properties props = null;
    
  public static String getPropertie(int key) {
    if(props == null) {
      setProperties();
    }
    
    return (String)props.getProperty(String.valueOf(key));
  }

  private static void setProperties() {
    props = new Properties();
    Locale l = new Locale("", "");
    principal = ResourceBundle.getBundle("es.indra.sicc.comunapplet.properties.mensajes", l);
    Enumeration keys = principal.getKeys();

    while (keys.hasMoreElements()) {
      String key = (String) keys.nextElement();
      props.put(key, principal.getString(key));
    }
  }
}


