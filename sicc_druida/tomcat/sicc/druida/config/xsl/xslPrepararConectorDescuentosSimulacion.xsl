<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/PROY
accion="SeleccionarSolicitud();"   $Id: xslPrepararConectorDescuentosSimulacion.xsl,v 1.1 2009/12/03 19:02:36 pecbazalar Exp $
   DESC
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="ISO-8859-1" indent="yes" method="xml"
		omit-xml-declaration="no" version="1.0"/>
	<xsl:strip-space elements="*"/>
	<xsl:template match="//ROWSET2">
		<ROWSET2>
			<xsl:apply-templates select="ROWSET[@ID='dtoSalida.resultado_ROWSET']"/>
		</ROWSET2>
	</xsl:template>
	<xsl:template match="ROWSET">
		<ROWSET ID="dtoSalida.resultado_ROWSET">
			<xsl:apply-templates select="ROW"/>
		</ROWSET>
	</xsl:template>
	<xsl:template match="ROW">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<!--CAMPO>
			     <xsl:apply-templates select="CAMPO[position()=1]/@*"/>
				<xsl:call-template name="replaceCharsInString">
					<xsl:with-param name="stringIn" select="CAMPO[position()=1]"/>
					<xsl:with-param name="charsIn"><xsl:text> </xsl:text></xsl:with-param>
					<xsl:with-param name="charsOut"><xsl:text>zzzzz</xsl:text></xsl:with-param>
				</xsl:call-template>
			</CAMPO-->

			<xsl:copy-of select="CAMPO[1]"/>
			<xsl:copy-of select="CAMPO[2]"/>
			<xsl:copy-of select="CAMPO[3]"/>
			<xsl:copy-of select="CAMPO[4]"/>
			<xsl:copy-of select="CAMPO[5]"/>
			<xsl:copy-of select="CAMPO[6]"/>
			<xsl:copy-of select="CAMPO[7]"/>
			<xsl:copy-of select="CAMPO[8]"/>
			<xsl:copy-of select="CAMPO[9]"/>
			<xsl:copy-of select="CAMPO[10]"/>
			<xsl:copy-of select="CAMPO[11]"/>
			<xsl:copy-of select="CAMPO[12]"/>
			<xsl:copy-of select="CAMPO[13]"/>
			<xsl:copy-of select="CAMPO[14]"/>
			<xsl:copy-of select="CAMPO[15]"/>
			<xsl:copy-of select="CAMPO[16]"/>
			<xsl:copy-of select="CAMPO[17]"/>
			<xsl:copy-of select="CAMPO[18]"/>
			<xsl:copy-of select="CAMPO[19]"/>
			<xsl:copy-of select="CAMPO[20]"/>
			<xsl:copy-of select="CAMPO[21]"/>
			<xsl:copy-of select="CAMPO[22]"/>
			<xsl:copy-of select="CAMPO[23]"/>
			
		</xsl:copy>
	</xsl:template>
	<xsl:template match="@*"><xsl:copy/></xsl:template>
	
	<xsl:template name="replaceCharsInString">
		<xsl:param name="stringIn"/>
		<xsl:param name="charsIn"/>
		<xsl:param name="charsOut"/>
		<xsl:choose>
			<xsl:when test="contains($stringIn,$charsIn)">
				<xsl:value-of select="concat(substring-before($stringIn,$charsIn),$charsOut)"/>
				<xsl:call-template name="replaceCharsInString">
					<xsl:with-param name="stringIn" select="substring-after($stringIn,$charsIn)"/>
					<xsl:with-param name="charsIn" select="$charsIn"/>
					<xsl:with-param name="charsOut" select="$charsOut"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$stringIn"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>
