package es.indra.sicc.util.xml.templates;

import es.indra.sicc.util.xml.XMLEngine;
import es.indra.sicc.util.xml.filters.Filters;
import es.indra.sicc.util.xml.filters.FiltersValues;

import java.util.Enumeration;


class XSLFilterTemplate {
   private XSLFilterTemplate() {
      super();
   }

   protected static String getStringTemplate(Filters filters, int operation)
      throws Exception {
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

      str.append(
         "<xsl:apply-templates select=\"./ROWSET\"></xsl:apply-templates>");
      str.append("</xsl:copy>");
      str.append("</xsl:template>");

      str.append("<xsl:template match=\"ROWSET\">");
      str.append("<ROWSET>");
      str.append("<xsl:apply-templates select=\"@*\"></xsl:apply-templates>");
      str.append("<xsl:for-each select=\"");

      StringBuffer strFilter = new StringBuffer();

      Enumeration rows;
      Enumeration fields;
      Enumeration keys;
      String strValue;
      String strKey;

      rows = filters.elements();
      strFilter.append("./ROW[");

      FiltersValues con;

      String agregado;
      agregado = ((operation == es.indra.sicc.util.xml.XMLEngine.XMLENGINE_EXCLUDE_FROM)
         ? "!" : "");

      while (rows.hasMoreElements()) {
         con = (FiltersValues) rows.nextElement();
         fields = con.elements();
         keys = con.keys();

         while (keys.hasMoreElements()) {
            strKey = (String) keys.nextElement();
            strValue = (String) fields.nextElement();
            strFilter.append("(CAMPO[@NOMBRE='" + strKey + "']" + agregado +
               "='" + strValue + "') and ");
         }

         strFilter.setLength(strFilter.length() - 5);
         strFilter.append(" or ");
      }

      strFilter.setLength(strFilter.length() - 3);
      strFilter.append("]\">");

      str.append(strFilter);

      str.append("<xsl:apply-templates select=\".\"></xsl:apply-templates>");
      str.append("</xsl:for-each>");
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
