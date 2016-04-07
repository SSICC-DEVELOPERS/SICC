<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="yes"/>
 <xsl:template match="//ROWSET2">
  <ROWSET2>
   <xsl:apply-templates select="@*"></xsl:apply-templates>
   <xsl:apply-templates select="./ROWSET"></xsl:apply-templates>
  </ROWSET2>
 </xsl:template>
 
 <xsl:template match="ROWSET" >
   <ROWSET>
    <xsl:apply-templates select="@*"></xsl:apply-templates>
     <xsl:apply-templates select="./ROW">
     <xsl:sort select="CAMPO[@NOMBRE='DES_MAE_TIPO_CLIEN']"></xsl:sort>
    </xsl:apply-templates>
   </ROWSET>
 </xsl:template>
 <xsl:template match="ROW" >
  <ROW>
   <xsl:apply-templates select="@*"></xsl:apply-templates>
   <xsl:copy-of select="./CAMPO[position()=1]"></xsl:copy-of>
   <xsl:copy-of select="./CAMPO[position()=1]"></xsl:copy-of>
   <xsl:copy-of select="./CAMPO[position()=2]"></xsl:copy-of>
   <xsl:choose>
	<xsl:when test="./CAMPO[position()=3]=0">
<CAMPO NOMBRE="IND_OBLI" TIPO="LONG" LONGITUD="50">No</CAMPO>
<CAMPO NOMBRE="IND_MODI" TIPO="LONG" LONGITUD="50">No</CAMPO>
</xsl:when>
	<xsl:otherwise>
<CAMPO NOMBRE="IND_OBLI" TIPO="LONG" LONGITUD="50">Si</CAMPO>
<CAMPO NOMBRE="IND_MODI" TIPO="LONG" LONGITUD="50">Si</CAMPO>
</xsl:otherwise>
  </xsl:choose>
  </ROW>
 </xsl:template>
 
 <xsl:template match="@*">
  <xsl:copy></xsl:copy>
 </xsl:template>
</xsl:stylesheet>
