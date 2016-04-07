<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output indent="yes" omit-xml-declaration="no" encoding="ISO-8859-1" method="xml"/>

<xsl:key name="Subgerencias" match="ROW" use="CAMPO[@NOMBRE='COD_ZONA']"/>

<xsl:template match="//ROWSET2">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="//ROWSET"></xsl:apply-templates>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROWSET">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:for-each select="ROW[count(. | key('Subgerencias',CAMPO[@NOMBRE='COD_ZONA'])[1])=1]">
			<xsl:sort select="CAMPO[@NOMBRE='COD_ZONA']" />
				<xsl:apply-templates select="." ></xsl:apply-templates>
		</xsl:for-each>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROW">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:copy-of select="CAMPO[@NOMBRE='COD_ZONA']"/>
		<xsl:copy-of select="CAMPO[@NOMBRE='COD_ZONA']"/>
	</xsl:copy>
</xsl:template>

<xsl:template match="@*">
	<xsl:copy></xsl:copy>
</xsl:template>

</xsl:stylesheet>