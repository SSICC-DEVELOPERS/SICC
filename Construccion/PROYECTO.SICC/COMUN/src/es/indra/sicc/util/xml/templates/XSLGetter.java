package es.indra.sicc.util.xml.templates;

import es.indra.sicc.util.xml.XMLEngine;
import es.indra.sicc.util.xml.filters.Filters;
import es.indra.sicc.util.xml.filters.FiltersValues;
import es.indra.sicc.util.xml.templates.XSLFilterTemplate;
import es.indra.sicc.util.xml.templates.XSLMergeTemplate;
import es.indra.sicc.util.xml.templates.XSLReorderTemplate;
import es.indra.sicc.util.xml.templates.XSLSortTemplate;


/**
 * <code>class XSLGetter</code>
 * <p>
 * Clase Principal del Paquete, a travez de esta clase se obtienen
 * los distintos templates XSL, todas las operaciones son estáticas
 * <p>
 * @author    Software Factory Argentina <strong>INDRA SI S.A</strong>
 * @version   1.0
 */
public class XSLGetter {
   /**
    * Indica la carga del template XSL desde una unidad de disco.
    */
   public static final int XSLGETTER_GET_FROM_FILE = 0;

   /**
    * Indica la carga del template XSL desde una URI.
    */
   public static final int XSLGETTER_GET_FROM_URI = 1;

   /**
    * Indica la carga del template XSL desde una ubicacion indeterminada.
    */
   public static final int XSLGETTER_GET_FROM_OTHER = 2;

   public XSLGetter() {
      super();
   }

   /**
   * Obtiene el Template XSL necesario para la operacion de <i><b>merge</b></i> de dos documentos XML.
   *
   * @param getFrom una de las constantes de campo de la clase
   * @param strOrigin Origen de la plantilla
   * @param axisFields Lista de nodos a utilizar en la operacion
   * @param separator Separador de la lista de nodos
   * @return java.lang.String
   * @throws Exception
   */
   public static String getXSLForMerge(int getFrom, String strOrigin,
      String axisFields, String separator) throws Exception {
      switch (getFrom) {
      case XSLGETTER_GET_FROM_FILE:
      case XSLGETTER_GET_FROM_URI:
      case XSLGETTER_GET_FROM_OTHER:
         break;

      default:
         throw new java.lang.Exception(
            "el parametro getFrom debe ser una de las constantes XSLGETTER_GET_FROM");
      }

      return XSLMergeTemplate.getStringTemplate(axisFields, separator);
   }

   /**
   * Obtiene el Template XSL necesario para la operacion de <i><b>Ordenamiento</b></i> del documento XML.
   *
   * @param getFrom una de las constantes de campo de la clase
   * @param strOrigin Origen de la plantilla
   * @param axisFields Lista de nodos a utilizar en la operacion
   * @param separator Separador de la lista de nodos
   * @return java.lang.String
   * @throws Exception
   */
   public static String getXSLForSort(int getFrom, String strOrigin,
      String axisFields, String separator) throws Exception {
      switch (getFrom) {
      case XSLGETTER_GET_FROM_FILE:
      case XSLGETTER_GET_FROM_URI:
      case XSLGETTER_GET_FROM_OTHER:
         break;

      default:
         throw new java.lang.Exception(
            "el parametro getFrom debe ser una de las constantes XSLGETTER_GET_FROM");
      }

      return XSLSortTemplate.getStringTemplate(axisFields, separator);
   }

   /**
   * Obtiene el Template XSL necesario para la operacion de <i><b>Filtrado</b></i> del documento XML.
   *
   * @param getFrom una de las constantes de campo de la clase
   * @param strOrigin Origen de la plantilla
   * @param filters objeto <code>Filters</code> a utilizar en la operacion
   * @param operation una de las constantes de campo de la clase
   * @return java.lang.String
   * @throws Exception
   */
   public static String getXSLForFilter(int getFrom, String strOrigin,
      Filters filters, int operation) throws Exception {
      switch (getFrom) {
      case XSLGETTER_GET_FROM_FILE:
      case XSLGETTER_GET_FROM_URI:
      case XSLGETTER_GET_FROM_OTHER:
         break;

      default:
         throw new java.lang.Exception(
            "el parametro getFrom debe ser una de las constantes XSLGETTER_GET_FROM");
      }

      switch (operation) {
      case es.indra.sicc.util.xml.XMLEngine.XMLENGINE_FILTER_BY:
         break;

      case es.indra.sicc.util.xml.XMLEngine.XMLENGINE_EXCLUDE_FROM:
         break;

      default:
         throw new java.lang.Exception(
            "el parametro operation debe ser una de las constantes definidas en la clase XMLEngine del paquete XML, padre de este paquete.");
      }

      return XSLFilterTemplate.getStringTemplate(filters, operation);
   }

   /**
   * Obtiene el Template XSL necesario para la operacion de
   * <i><b>Reordenamiento</b></i>de nodos del documento XML.
   *
   * @param getFrom una de las constantes de campo de la clase
   * @param strOrigin Origen de la plantilla
   * @param axisFields Lista de nodos a utilizar en la operacion
   * @param separator Separador de la lista de nodos
   * @param includeAll boolean indicando si deben agregarse al resultado los nodos que
   * no se incluyen en la lista de nodos
   *
   * @return java.lang.String
   * @throws Exception
   */
   public static String getXSLForReorder(int getFrom, String strOrigin,
      String axisFields, String separator, boolean includeAll)
      throws Exception {
      switch (getFrom) {
      case XSLGETTER_GET_FROM_FILE:
      case XSLGETTER_GET_FROM_URI:
      case XSLGETTER_GET_FROM_OTHER:
         break;

      default:
         throw new java.lang.Exception(
            "el parametro getFrom debe ser una de las constantes XSLGETTER_GET_FROM");
      }

      return XSLReorderTemplate.getStringTemplate(axisFields, separator,
         includeAll);
   }
}
