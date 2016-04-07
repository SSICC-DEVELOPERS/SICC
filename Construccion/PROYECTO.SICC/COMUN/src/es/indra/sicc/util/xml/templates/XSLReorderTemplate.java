package es.indra.sicc.util.xml.templates;

import java.util.StringTokenizer;


class XSLReorderTemplate {
   private XSLReorderTemplate() {
      super();
   }

   public static String getStringTemplate(String axisFields, String separator,
      boolean includeAll) throws Exception {
      StringBuffer str = new StringBuffer();

      str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
      str.append(
         "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">");
      str.append(
         "<xsl:output omit-xml-declaration=\"no\" encoding=\"ISO-8859-1\" indent=\"yes\"/>");
      str.append("<xsl:param name=\"origen\"/>");
      str.append("<xsl:template match=\"//ROWSET2\">");
      str.append("<xsl:copy>");
      str.append("<xsl:apply-templates select=\"@*\"/>");
      str.append("<xsl:apply-templates select=\"./ROWSET\"/>");
      str.append("</xsl:copy>");
      str.append("</xsl:template>");
      str.append("<xsl:template match=\"ROWSET\">");
      str.append("<ROWSET>");
      str.append("<xsl:apply-templates select=\"@*\"/>");
      str.append("<xsl:apply-templates select=\"./ROW\"/>");
      str.append("</ROWSET>");
      str.append("</xsl:template>");
      str.append("<xsl:template match=\"ROW\">");
      str.append("<xsl:copy>");
      str.append("<xsl:apply-templates select=\"@*\"/>");

      StringTokenizer tokens = new StringTokenizer(axisFields, separator);

      if (tokens.countTokens() < 1) {
         throw new Exception("No se han especificado los campos a comparar");
      }

      String actual = "";
      StringBuffer segundaCondicion = new StringBuffer("");

      if (includeAll) {
         segundaCondicion.append("<xsl:copy-of select=\"CAMPO[");
      }

      while (tokens.hasMoreTokens()) {
         actual = tokens.nextToken();

         if (!actual.trim().equals("")) {
            str.append("<xsl:copy-of select=\"CAMPO[@NOMBRE='" + actual +
               "']\"/>");

            if (includeAll) {
               segundaCondicion.append("@NOMBRE!='" + actual + "' and ");
            }
         }
      }

      if (includeAll) {
         segundaCondicion.setLength(segundaCondicion.length() - 5);
         segundaCondicion.append("]\"/>");
         str.append(segundaCondicion);
      }

      str.append("</xsl:copy>");
      str.append("</xsl:template>");
      str.append("<xsl:template match=\"@*\">");
      str.append("<xsl:copy/>");
      str.append("</xsl:template>");
      str.append("</xsl:stylesheet>");

      return str.toString();
   }
}
