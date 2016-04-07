<?xml version="1.0" encoding="UTF-8" ?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes" /> 
<xsl:template match="//ROWSET2">
	<ROWSET2>
		<xsl:apply-templates select="@*" /> 
		<xsl:apply-templates select="./ROWSET" /> 
	</ROWSET2>
</xsl:template>
<xsl:template match="ROWSET">
	<ROWSET>
		<xsl:apply-templates select="@*" /> 
		<xsl:apply-templates select="./ROW">
			<xsl:sort select="CAMPO[@NOMBRE='COD_EXCENCION_FLETE']" /> 
		</xsl:apply-templates>
	</ROWSET>
  </xsl:template>
  <xsl:template match="ROW">
	<ROW>
		<xsl:apply-templates select="@*" /> 
		<xsl:copy-of select="./CAMPO[position()=1]" /> 
		<xsl:copy-of select="./CAMPO[position()=2]" />
		<xsl:copy-of select="./CAMPO[position()=3]" /> 
		<xsl:copy-of select="./CAMPO[position()=4]" />	
		<xsl:choose>
			<xsl:when test="./CAMPO[position()=5]=0">
				<CAMPO NOMBRE="IND_EXEC_FLET" TIPO="STRING">No</CAMPO> 
			</xsl:when>
			<xsl:otherwise>
				<CAMPO NOMBRE="IND_EXEC_FLET" TIPO="STRING">Si</CAMPO> 
			</xsl:otherwise>
		</xsl:choose>		
	</ROW>
  </xsl:template>
  <xsl:template match="@*">
  <xsl:copy /> 
  </xsl:template>
  </xsl:stylesheet>