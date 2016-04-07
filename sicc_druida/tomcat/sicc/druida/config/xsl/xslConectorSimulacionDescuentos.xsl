<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/PROY
accion="SeleccionarSolicitud();"   $Id: xslConectorSimulacionDescuentos.xsl,v 1.1 2009/12/03 19:02:36 pecbazalar Exp $
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
			<xsl:apply-templates select="ROW" />
		</ROWSET>
	</xsl:template>
	<xsl:template match="ROW" >
		<ROW ID="{position()}">
			<xsl:copy-of select="CAMPO[1]"/>
			<xsl:copy-of select="CAMPO[2]"/>
			<xsl:copy-of select="CAMPO[3]"/>
			<xsl:copy-of select="CAMPO[4]"/>
			<xsl:copy-of select="CAMPO[5]"/>
			<xsl:copy-of select="CAMPO[6]"/>
			<xsl:variable name="aux" select="CAMPO[7]"/>
			<xsl:if test="$aux='false'">
				<CAMPO NOMBRE="APROBADO" TIPO="STRING">NO</CAMPO>
			</xsl:if>
			<xsl:if test="$aux='true'">
				<CAMPO NOMBRE="APROBADO" TIPO="STRING">SI</CAMPO>
			</xsl:if>
		</ROW>
	</xsl:template>

</xsl:stylesheet>