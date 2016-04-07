package es.indra.sicc.util.xml.filters;

import es.indra.sicc.util.xml.filters.FiltersValues;

import java.util.Enumeration;
import java.util.Vector;


/**
 * <code>class Filters</code>
 * <p>
 * Clase que representa el par nodo valor a utilizar en las operacion de filtrado
 * de documentos XML.
 *
 * <p>
 * @author    Software Factory Argentina <strong>INDRA SI S.A</strong>
 * @version   1.0
 */
public class Filters {
   private Vector tableFields;

   public Filters() {
      super();
      this.tableFields = new Vector();
   }

   /**
    *Este metodo agrega un objeto <code>FiltersValues</code> a la coleccion de filtros,
    * devolviendolo para su complesion.
    * <p>
    * @return FiltersValues
    */
   public FiltersValues add() {
      FiltersValues fld = new FiltersValues();
      this.tableFields.addElement(fld);

      return fld;
   }

   /**
   *Este metodo agrega un par nombre de nodo,
   * valor para el filtro a aplicar, a la lista de filtros
   */
   public void add(FiltersValues value) {
      this.tableFields.addElement(value);
   }

   /**
   *Este metodo obtiene un objeto <code>FiltersValues</code> de la coleccion de filtros.
   * <p>
   * @param index indice del objeto a obtener
   * @return FiltersValues
   */
   public FiltersValues get(int index) {
      return (FiltersValues) this.tableFields.elementAt(index);
   }

   /**
   *Este metodo elimina un objeto <code>FiltersValues</code> de los filtros.
   * <p>
   * @param index indice del objeto a eliminar
   */
   public void remove(int index) {
      this.tableFields.remove(index);
   }

   /**
   *Este metodo obtiene una enumeracion de <code>FiltersValues</code>
   * <p>
   * @return java.util.Enumeration
   */
   public Enumeration elements() {
      return this.tableFields.elements();
   }

   /**
   *Este metodo obtiene el largo de la coleccion de filtros.
   * <p>
   * @return int
   */
   public int size() {
      return this.tableFields.size();
   }

   /**
   * metodo sobrecargado
   * <p>
   * @return java.lang.String
   */
   public String toString() {
      StringBuffer str = new StringBuffer();
      String comillas = new String("\"");
      Enumeration filters = this.tableFields.elements();
      FiltersValues key;
      str.append("{ ");

      while (filters.hasMoreElements()) {
         key = (FiltersValues) filters.nextElement();
         str.append(key.toString() + " ,");
      }

      str.deleteCharAt(str.length() - 1);
      str.append("}");

      return str.toString();
   }
}
