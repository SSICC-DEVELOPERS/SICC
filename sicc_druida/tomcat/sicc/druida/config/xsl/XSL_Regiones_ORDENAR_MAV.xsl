<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output indent="yes" omit-xml-declaration="no" encoding="ISO-8859-1" method="xml"/>

<xsl:key name="Subgerencias" match="ROW" use="CAMPO[@NOMBRE='ZORG_COD_REGI']"/>

<xsl:template match="//ROWSET2">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="//ROWSET"></xsl:apply-templates>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROWSET">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:for-each select="ROW[count(. | key('Subgerencias',CAMPO[@NOMBRE='ZORG_COD_REGI'])[1])=1]">
			<xsl:sort select="CAMPO[@NOMBRE='ZORG_COD_REGI']"/>
				<xsl:apply-templates select="." ></xsl:apply-templates>
		</xsl:for-each>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROW">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:copy-of select="CAMPO[@NOMBRE='ZORG_COD_REGI']"/>
		<xsl:copy-of select="CAMPO[@NOMBRE='ZORG_COD_REGI']"/>
	</xsl:copy>
</xsl:template>

<xsl:template match="@*">
	<xsl:copy></xsl:copy>
</xsl:template>

</xsl:stylesheet>