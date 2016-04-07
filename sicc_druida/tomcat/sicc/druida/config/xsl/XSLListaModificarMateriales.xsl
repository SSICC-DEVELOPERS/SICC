<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/> 
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
     <xsl:sort select="CAMPO[@NOMBRE='OID_PROD']"></xsl:sort>
    </xsl:apply-templates>
   </ROWSET>
 </xsl:template>
 <xsl:template match="ROW" >
  <ROW>
   <xsl:apply-templates select="@*"></xsl:apply-templates> 
   <xsl:copy-of select="./CAMPO[position()=8]"></xsl:copy-of>
   <xsl:copy-of select="./CAMPO[position()=1]"></xsl:copy-of>
   <xsl:copy-of select="./CAMPO[position()=2]"></xsl:copy-of>
   <xsl:copy-of select="./CAMPO[position()=13]"></xsl:copy-of>
   <xsl:copy-of select="./CAMPO[position()=3]"></xsl:copy-of>
   <xsl:choose>
	<xsl:when test="./CAMPO[position()=4]=0"><CAMPO NOMBRE="IND_LOTE" TIPO="STRING">No</CAMPO></xsl:when>
	<xsl:otherwise><CAMPO NOMBRE="IND_LOTE" TIPO="STRING">Si</CAMPO></xsl:otherwise>
  </xsl:choose>
  <xsl:choose>
	<xsl:when test="./CAMPO[position()=5]=1"><CAMPO NOMBRE="IND_LOTE" TIPO="STRING">Servicio</CAMPO></xsl:when>
	<xsl:otherwise><CAMPO NOMBRE="IND_PROD_SERV" TIPO="STRING">Producto</CAMPO></xsl:otherwise>
  </xsl:choose>
  <xsl:copy-of select="./CAMPO[position()=7]"></xsl:copy-of>
  <xsl:copy-of select="./CAMPO[position()=14]"></xsl:copy-of>
  <xsl:copy-of select="./CAMPO[position()=15]"></xsl:copy-of>
  <xsl:copy-of select="./CAMPO[position()=16]"></xsl:copy-of>
  <xsl:copy-of select="./CAMPO[position()=17]"></xsl:copy-of>
  
  </ROW>
 </xsl:template>
 
 <xsl:template match="@*">
  <xsl:copy></xsl:copy>
 </xsl:template>
</xsl:stylesheet>
