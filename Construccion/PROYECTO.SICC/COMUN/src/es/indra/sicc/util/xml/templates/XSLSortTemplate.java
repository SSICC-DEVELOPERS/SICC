package es.indra.sicc.util.xml.templates;

import java.util.StringTokenizer;


class XSLSortTemplate {
   private XSLSortTemplate() {
      super();
   }

   protected static String getStringTemplate(String axisFields, String separator)
      throws Exception {
      StringBuffer str = new StringBuffer();
      str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
      str.append(
         "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
      str.append(
         "<xsl:output omit-xml-declaration=\"no\" encoding=\"ISO-8859-1\" indent=\"yes\"/>");
      str.append("<xsl:template match=\"//ROWSET2\">");
      str.append("<xsl:copy>");
      str.append("<xsl:apply-templates select=\"@*\"></xsl:apply-templates>");
      str.append(
         "<xsl:apply-templates select=\"./ROWSET\"></xsl:apply-templates>");
      str.append("</xsl:copy>");
      str.append("</xsl:template>");

      str.append("<xsl:template match=\"ROWSET\">");
      str.append("<xsl:copy>");
      str.append("<xsl:apply-templates select=\"@*\"></xsl:apply-templates>");
      str.append("<xsl:apply-templates select=\"./ROW\">");

      StringTokenizer tokens = new StringTokenizer(axisFields, separator);

      if (tokens.countTokens() < 1) {
         throw new Exception("No se han especificado los campos a comparar");
      }

      while (tokens.hasMoreTokens()) {
         str.append("<xsl:sort select=\"CAMPO[@NOMBRE='" + tokens.nextToken() +
            "']\"/>");
      }

      str.append("</xsl:apply-templates>");
      str.append("</xsl:copy>");
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
