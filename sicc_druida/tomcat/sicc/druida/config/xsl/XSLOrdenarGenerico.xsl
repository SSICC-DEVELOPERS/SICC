<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:variable name="campo"/>

<xsl:output method="xml" omit-xml-declaration="no" indent="yes" encoding="ISO-8859-1"/>


<xsl:template match="//ROWSET2">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="ROWSET"/>
	</xsl:copy>
</xsl:template>


<xsl:template match="ROWSET">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="ROW">
			<xsl:sort select="CAMPO[@NOMBRE=$campo]"></xsl:sort>
		</xsl:apply-templates>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROW">
	<xsl:copy-of select="."/>
</xsl:template>


<xsl:template match="@*">
	<xsl:copy/>
</xsl:template>


</xsl:stylesheet>
