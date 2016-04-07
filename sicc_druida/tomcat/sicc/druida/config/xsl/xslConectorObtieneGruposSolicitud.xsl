<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/PROY
   $Id: xslConectorObtieneGruposSolicitud.xsl,v 1.1 2009/12/03 19:02:37 pecbazalar Exp $
   DESC
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="yes"/>
	<xsl:template match="//ROWSET2">
		<ROWSET2>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROWSET"/>
		</ROWSET2>
	</xsl:template>
	<xsl:template match="ROWSET">
		<ROWSET>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort data-type="text" select="@ID"/>
			</xsl:apply-templates>
		</ROWSET>
	</xsl:template>
	<xsl:template match="ROW">
		<ROW>
			<xsl:apply-templates select="@*"/>
			<xsl:copy-of select="./CAMPO[position()=1]"/>
			<xsl:copy-of select="./CAMPO[position()=1]"/>
			<xsl:copy-of select="./CAMPO[position()=3]"/>
			<xsl:copy-of select="./CAMPO[position()=2]"/>
		</ROW>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy/>
	</xsl:template>
</xsl:stylesheet>