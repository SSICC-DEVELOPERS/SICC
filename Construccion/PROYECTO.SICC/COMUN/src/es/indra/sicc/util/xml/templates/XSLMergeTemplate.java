package es.indra.sicc.util.xml.templates;

import java.util.StringTokenizer;


/**
 * <code>class XSLMergeTemplate</code>
 * <p>
 * <b>Clase de utileria del paquete</b>, devuelve el template necesario para
 * hacer el <b>merge</b> de dos documentos xml
 * <p>
 * @author    Software Factory Argentina <strong>INDRA SI S.A</strong>
 * @version   1.0
 */
class XSLMergeTemplate {
   private XSLMergeTemplate() {
   }

   /**
    * Devuelve un String con el xsl necesario para la operacion de
    * <b>merge</b> de dos documentos xml.
    * @param axisFields <code>String</code> con los campos a utilizar como ejes en la operacion, separador por <code>separator</code>.
    * @param separator <code>String</code> con el separador a utilizar en la "<i>tokenizacion</i>" del parametro <code>axisFields</code>.
    * @return java.lang.String El xsl a utilizar en la transformacion.
    * @throws java.lang.Exception
    */
   protected static String getStringTemplate(String axisFields, String separator)
      throws Exception {
      String actual = "";
      StringBuffer str = new StringBuffer();

      str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
      str.append(
         "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
      str.append(
         "<xsl:output omit-xml-declaration=\"no\" encoding=\"ISO-8859-1\" indent=\"yes\"/>");
      str.append("<xsl:param name=\"origen\"></xsl:param>");
      str.append("<xsl:template match=\"//ROWSET2\">");
      str.append("<xsl:copy>");
      str.append("<xsl:apply-templates select=\"@*\"></xsl:apply-templates>");

      str.append("<xsl:call-template name=\"entrada\">");
      str.append("<xsl:with-param name=\"merged\" select=\"./ROWSET\">");
      str.append("</xsl:with-param>");
      str.append("</xsl:call-template>");
      str.append("</xsl:copy>");
      str.append("</xsl:template>");

      str.append("<xsl:template name=\"entrada\" >");
      str.append("<xsl:param name=\"merged\">");
      str.append("</xsl:param>");
      str.append("<ROWSET>");
      str.append(
         "<xsl:apply-templates select=\"$merged/@*\"></xsl:apply-templates>");
      str.append(
         "<xsl:apply-templates select=\"$merged/ROW\"></xsl:apply-templates>");
      str.append("<xsl:if test=\"$origen\">");
      str.append("<xsl:for-each select=\"$origen/ROWSET2/ROWSET/ROW\">");
      str.append("<xsl:choose>");
      str.append("<xsl:when test=\"");
      str.append("not($merged/ROW[");

      StringTokenizer tokens = new StringTokenizer(axisFields, separator);

      if (tokens.countTokens() < 1) {
         throw new Exception("No se han especificado los campos a comparar");
      }

      while (tokens.hasMoreTokens()) {
         actual = tokens.nextToken();

         if (!actual.trim().equals("")) {
            str.append("(CAMPO[@NOMBRE='" + actual +
               "']=current()/CAMPO[@NOMBRE='" + actual + "']) and ");
         }
      }

      str.setLength(str.length() - 5);
      str.append("])");
      str.append("\">");
      str.append("<xsl:copy-of select=\"current()\"/>");
      str.append("</xsl:when>");
      str.append("</xsl:choose>");
      str.append("</xsl:for-each>");
      str.append("</xsl:if>");
      str.append("</ROWSET>");
      str.append("</xsl:template>");

      str.append("<xsl:template match=\"ROW\">");
      str.append("<xsl:copy>");
      str.append("<xsl:apply-templates select=\"@*\"></xsl:apply-templates>");
      str.append("<xsl:copy-of select=\"CAMPO\"></xsl:copy-of>");
      str.append("</xsl:copy>");
      str.append("</xsl:template>");
      str.append("<xsl:template match=\"@*\">");
      str.append("<xsl:copy></xsl:copy>");
      str.append("</xsl:template>");
      str.append("</xsl:stylesheet>");

      return str.toString();
   }
}
