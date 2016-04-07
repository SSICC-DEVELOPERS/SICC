<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/>
	<xsl:template match="//ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROWSET"></xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" >
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='descripcion']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="ROW" >
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='clave']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='descripcion']"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>

</xsl:stylesheet>