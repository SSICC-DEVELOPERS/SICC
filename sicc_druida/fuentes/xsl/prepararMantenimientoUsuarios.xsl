<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:param name="rowset"></xsl:param>
	
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="no"></xsl:output>

	<xsl:template match="//ROWSET2">
		<salida>
			<xsl:apply-templates select="ROWSET[@ID=$rowset]"/>
		</salida>
	</xsl:template>


		<xsl:template match="ROWSET">
			<xsl:text>[</xsl:text>				
				<xsl:apply-templates select="./ROW">
					<xsl:with-param name="filas"><xsl:value-of select="count(ROW)"/></xsl:with-param>
				</xsl:apply-templates>
			<xsl:text>]</xsl:text>
	</xsl:template>
	
	<xsl:template match="ROW">
		<xsl:param name="filas" />		
		<xsl:variable name="campos">
			<xsl:value-of select="count(CAMPO)"/>
		</xsl:variable>
		<xsl:text>[</xsl:text>
		<xsl:for-each select="CAMPO">
			<xsl:text>'</xsl:text><xsl:value-of select="."/><xsl:text>'</xsl:text>
			<xsl:if test="position() &lt; $campos">, </xsl:if>
		</xsl:for-each>
		<xsl:text>]</xsl:text>
		<xsl:if test="position() &lt; $filas">,</xsl:if>
	</xsl:template>
	
</xsl:stylesheet>