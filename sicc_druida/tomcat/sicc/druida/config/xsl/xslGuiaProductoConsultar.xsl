<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:template match="/ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROWSET"></xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" >
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROW"></xsl:apply-templates>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="ROW" >
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:element name="CAMPO">
				<xsl:attribute name="NOMBRE">concatenados</xsl:attribute>
				<xsl:attribute name="TIPO">STRING</xsl:attribute>
				<xsl:value-of select="CAMPO[position()=1]"></xsl:value-of>--<xsl:value-of select="CAMPO[position()=2]"></xsl:value-of>
			</xsl:element>
			<xsl:apply-templates select="./CAMPO[position() >2]"></xsl:apply-templates>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="CAMPO" >
		<xsl:copy-of select="."></xsl:copy-of>
	</xsl:template>

	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>

</xsl:stylesheet>
