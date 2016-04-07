package es.indra.sicc.util.xml.filters;

import java.util.Enumeration;
import java.util.Hashtable;


/**
 * <code>class FiltersValues</code>
 * <p>
 * Clase que representa la coleccion de valores a utilizar
 * en las operacion de filtrado de documentos XML.
 * <p>
 * @author    Software Factory Argentina <strong>INDRA SI S.A</strong>
 * @version   1.0
 */
public class FiltersValues {
   private Hashtable tableValues;

   public FiltersValues() {
      super();
      tableValues = new Hashtable();
   }

   /**
   *Este contructor permite instanciar el objeto con un valor inicial de filtro
   * <p>
   * @return FiltersValues
   */
   public FiltersValues(String key, String value) {
      super();
      tableValues = new Hashtable();
      tableValues.put(key, value);
   }

   public void add(String key, String value) {
      this.tableValues.put(key, value);
   }

   /**
   *Obtiene un objeto FilterValues desde la coleccion mediante la clave del mismo
   * <p>
   * @return Object
   */
   public Object get(String key) {
      return tableValues.get(key);
   }

   /**
   * Obtiene una <code>java.util.Enumeration</code>
   * con las claves de la coleccion de fitros
   * <p>
   * @return java.util.Enumeration
   */
   public Enumeration keys() {
      return this.tableValues.keys();
   }

   /**
   * Obtiene una <code>java.util.Enumeration</code>
   * con los fitros
   * <p>
   * @return java.util.Enumeration
   */
   public Enumeration elements() {
      return this.tableValues.elements();
   }

   /**
   * metodo sobrecargado
   * <p>
   * @return java.lang.String
   */
   public String toString() {
      StringBuffer str = new StringBuffer();
      Enumeration keys = this.keys();
      String key;
      str.append("{ ");

      String comillas = new String("\"");

      while (keys.hasMoreElements()) {
         key = (String) keys.nextElement();
         str.append("[" + comillas + key + comillas + " ," + comillas +
            (String) this.tableValues.get(key) + comillas + "] ,");
      }

      str.deleteCharAt(str.length() - 1);
      str.append("}");

      return str.toString();
   }
}
