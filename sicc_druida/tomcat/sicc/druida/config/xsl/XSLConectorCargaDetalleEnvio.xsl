<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/MAV/SICC
   $Id: XSLConectorCargaDetalleEnvio.xsl,v 1.1 2009/12/03 19:02:33 pecbazalar Exp $
   CompletarDatosBP
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
			<CAMPO NOBRE="CODIGO" TIPO="STRING">
				<xsl:value-of select="./CAMPO[position()=2]"/>--<xsl:value-of select="./CAMPO[position()=3]"/>--<xsl:value-of select="./CAMPO[position()=4]"/>--<xsl:value-of select="./CAMPO[position()=8]"/>--<xsl:value-of select="./CAMPO[position()=7]"/>--<xsl:value-of select="./CAMPO[position()=29]"/>--<xsl:value-of select="./CAMPO[position()=1]"/>
			</CAMPO>
			<xsl:copy-of select="./CAMPO[position()=34]"/>
      <xsl:copy-of select="./CAMPO[position()=35]"/>
      <xsl:copy-of select="./CAMPO[position()=36]"/>
      <xsl:copy-of select="./CAMPO[position()=40]"/>
      <xsl:copy-of select="./CAMPO[position()=37]"/>
      <xsl:copy-of select="./CAMPO[position()=32]"/>
      <xsl:copy-of select="./CAMPO[position()=45]"/>
      <xsl:copy-of select="./CAMPO[position()=44]"/>
      <xsl:copy-of select="./CAMPO[position()=42]"/>
      <xsl:copy-of select="./CAMPO[position()=43]"/>
      <xsl:copy-of select="./CAMPO[position()=18]"/>
    </xsl:copy>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
</xsl:stylesheet>