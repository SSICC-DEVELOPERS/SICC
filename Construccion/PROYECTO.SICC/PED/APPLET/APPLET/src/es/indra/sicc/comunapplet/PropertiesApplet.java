package es.indra.sicc.comunapplet;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesApplet {
  private static PropertiesApplet pm = null;
  private static ResourceBundle principal = null;
  private static Properties props = null;
    
  public static String getPropertie(int key, String bundle) {
    //if(props == null) {
      setProperties(bundle);
    //}
    
    return (String)props.getProperty(String.valueOf(key));
  }

 /* public static void setProperties(String bundle) {
    props = new Properties();
    Locale l = new Locale("", "");
    //principal = ResourceBundle.getBundle("es.indra.sicc.comunapplet.properties.mensajes", l);
    Enumeration keys = principal.getKeys();

    while (keys.hasMoreElements()) {
      String key = (String) keys.nextElement();
      props.put(key, principal.getString(key));
    }
  }*/

  public static void setProperties(String bundle) {
    props = new Properties();
    Locale l = new Locale("", "");
    principal = ResourceBundle.getBundle(bundle, l);
    Enumeration keys = principal.getKeys();

    while (keys.hasMoreElements()) {
      String key = (String) keys.nextElement();
      props.put(key, principal.getString(key));
    }
  }
}