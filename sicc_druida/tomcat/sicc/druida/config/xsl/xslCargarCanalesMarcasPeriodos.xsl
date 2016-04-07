<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/>

	<xsl:template match="//ROWSET2">
		<ROWSET2>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:call-template name="general">
				<xsl:with-param name="rowset" select="./ROWSET[@ID='dtoSalida.marcas_ROWSET']"></xsl:with-param>
			</xsl:call-template>
			<xsl:apply-templates select="./ROWSET[@ID='dtoSalida.canales_ROWSET']"></xsl:apply-templates>
			<xsl:call-template name="general">
				<xsl:with-param name="rowset" select="./ROWSET[@ID='dtoSalida.periodos_ROWSET']"></xsl:with-param>
			</xsl:call-template>
		</ROWSET2>
	</xsl:template>
	<xsl:template name="general">
		<xsl:param name="rowset"></xsl:param>
		<xsl:copy-of select="$rowset"></xsl:copy-of>
	</xsl:template>
	<xsl:template match="ROWSET" >
		<ROWSET>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROW"></xsl:apply-templates>
		</ROWSET>
	</xsl:template>

	<xsl:template match="ROW" >
		<ROW>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:copy-of select="./CAMPO[position()=1]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=2]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=3]"></xsl:copy-of>
		</ROW>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>

</xsl:stylesheet>
