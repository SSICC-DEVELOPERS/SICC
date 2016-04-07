<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/MAV/SICC
   $Id: XSLSubtiposClientesMAV.xsl,v 1.1 2009/12/03 19:02:36 pecbazalar Exp $
   InsertarActividades
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output omit-xml-declaration="no" version="1.0" encoding="ISO-8859-1" indent="yes" method="xml"/>
  <xsl:template match="/ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROWSET"></xsl:apply-templates>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="ROWSET">
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROW"></xsl:apply-templates>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="ROW">
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<CAMPO NOBRE="concatenados" TIPO="STRING">
				<xsl:value-of select="./CAMPO[position()=1]"/>--<xsl:value-of select="./CAMPO[position()=2]"/>
			</CAMPO>
			<xsl:copy-of select="./CAMPO[position()=3]"/>
    </xsl:copy>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
</xsl:stylesheet>