<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no"/>
	<xsl:template match="//ROWSET2">
		<ROWSET2>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROWSET"></xsl:apply-templates>
		</ROWSET2>
	</xsl:template>

	<xsl:template match="ROWSET" >
	<xsl:choose>
		<xsl:when test="./@ID='dtoSalida.controlLiquidacion_ROWSET'">
			<xsl:copy>
				<xsl:apply-templates select="@*"></xsl:apply-templates>
				<xsl:apply-templates select="./ROW"></xsl:apply-templates>
			</xsl:copy>		
		</xsl:when>
		</xsl:choose>

	</xsl:template>
	<xsl:template match="ROW" >
		<ROW>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:copy-of select="./CAMPO[position()=18]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=20]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=21]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=22]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=23]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=24]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=9]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=6]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=17]"></xsl:copy-of>
		</ROW>
	</xsl:template>
	
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
</xsl:stylesheet>