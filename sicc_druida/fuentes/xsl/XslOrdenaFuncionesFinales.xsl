<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/PROY
   $Id: XslOrdenaFuncionesFinales.xsl,v 1.1 2009/12/03 19:02:42 pecbazalar Exp $
   DESC
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!--Esto define el encabezado del xml de salida-->
	<xsl:output method="xml" omit-xml-declaration="no" encoding="ISO-8859-1" ></xsl:output>
	<!--aca se hace la transformacion-->
	<xsl:template match="/">
		<ROWSET2>
			<xsl:apply-templates select="//ROWSET2"></xsl:apply-templates>
		</ROWSET2>
	</xsl:template>
	
	<xsl:template match="ROWSET2">
		<xsl:apply-templates select="@*"></xsl:apply-templates>
		<ROWSET>
			<xsl:apply-templates select="./ROWSET"/>
		</ROWSET>	
	</xsl:template>
	<xsl:template match="ROWSET">
		<xsl:apply-templates select="@*"></xsl:apply-templates>
		<xsl:apply-templates select="ROW[(CAMPO[@NOMBRE='indicadornivel'])=1]">
			<xsl:sort select="CAMPO[@NOMBRE='nombrefuncion']"></xsl:sort>
		</xsl:apply-templates>
	</xsl:template>
	<xsl:template match="ROW">
		<xsl:copy-of select="."></xsl:copy-of>
	</xsl:template>

	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>	
</xsl:stylesheet>