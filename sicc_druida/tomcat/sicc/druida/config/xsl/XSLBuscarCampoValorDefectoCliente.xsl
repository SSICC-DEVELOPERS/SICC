<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/PROY
   $Id: XSLBuscarCampoValorDefectoCliente.xsl,v 1.1 2009/12/03 19:02:39 pecbazalar Exp $
   DESC
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/>
	<xsl:template match="//ROWSET2">
		<ROWSET2>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROWSET"></xsl:apply-templates>
		</ROWSET2>
	</xsl:template>

	<xsl:template match="ROWSET" >		
		<ROWSET>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
				<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='campo']"></xsl:sort>
			</xsl:apply-templates>
		</ROWSET>		
	</xsl:template>
	<xsl:template match="ROW" >
		<ROW>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:copy-of select="./CAMPO[position()=1]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=4]"></xsl:copy-of>
		</ROW>
	</xsl:template>
	
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
</xsl:stylesheet>