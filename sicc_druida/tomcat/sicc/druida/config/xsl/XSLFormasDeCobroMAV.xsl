<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output indent="yes" omit-xml-declaration="no" encoding="ISO-8859-1" method="xml"/>
<xsl:preserve-space elements="*"/>

<xsl:template match="//ROWSET2">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="./ROWSET"/>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROWSET">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="ROW">
			<xsl:sort select="CAMPO[@NOMBRE='DES_PAGO_FRAC']"/>
		</xsl:apply-templates>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROW">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:copy-of select="CAMPO[@NOMBRE='COD_PAGO_FRAC']"/>
		<xsl:copy-of select="CAMPO[@NOMBRE='DES_PAGO_FRAC']"/>
	</xsl:copy>
</xsl:template>


<xsl:template match="@*">
	<xsl:copy></xsl:copy>
</xsl:template>

</xsl:stylesheet>