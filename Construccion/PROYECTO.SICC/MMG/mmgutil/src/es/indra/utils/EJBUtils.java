package es.indra.utils;

import javax.ejb.*;
import javax.naming.*;
import javax.sql.*;
import java.rmi.*;
import java.util.*;
import javax.rmi.PortableRemoteObject;
import java.lang.reflect.*;
import java.sql.Timestamp;
import javax.transaction.UserTransaction;
import java.security.*;
import java.io.*;

/**
 * Esta clase contiene varias utilidades generales
 *   
 * @version 1.0
 */
public final class EJBUtils
{
  static InitialContext ic;

  static
  {
    try
    {
      Hashtable ht = new Hashtable();
      ht.put("java.naming.factory.initial", Config.get("/jndi/factory/initial"));
      ht.put("java.naming.provider.url", Config.get("/jndi/provider/url"));    
      ht.put("java.naming.security.principal", Config.get("/jndi/security/principal"));
      ht.put("java.naming.security.credentials", Config.get("/jndi/security/credentials"));
  
      ic = new InitialContext(ht);
    }
    catch (Exception e)
    {
      System.out.println(e.toString());      
    }
  }

  /**
   * Crea un componente EJB y devuelve su interfaz remoto
   * @param jndiName Nombre JNDI
   */
  public static EJBObject getEJB(String jndiName) throws Exception
  {
    Object objRef = ic.lookup(jndiName);
    Method createMethod = objRef.getClass().getMethod("create", null);

    return (EJBObject) createMethod.invoke(objRef, null);
  }
}
