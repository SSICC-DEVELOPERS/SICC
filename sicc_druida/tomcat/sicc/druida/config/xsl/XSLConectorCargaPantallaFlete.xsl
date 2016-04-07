<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/PED/SICC
   $Id: XSLConectorCargaPantallaFlete.xsl,v 1.1 2009/12/03 19:02:30 pecbazalar Exp $
   Mantenimiento Fletes
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:preserve-space elements="*"/>
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="yes"></xsl:output>

	<xsl:template match="//ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="ROWSET[@ID='dtoSalida.marcas_ROWSET']" mode="marcas"/>
      <xsl:apply-templates select="ROWSET[@ID='dtoSalida.canales_ROWSET']" mode="canales"/>
      <xsl:apply-templates select="ROWSET[@ID='dtoSalida.monedas_ROWSET']" mode="monedas"/>
      <xsl:apply-templates select="ROWSET[@ID='dtoSalida.tipoDespacho_ROWSET']" mode="tipoDespacho"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" mode="marcas">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_MARC']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

  <xsl:template match="ROWSET" mode="canales">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_CANA']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

  <xsl:template match="ROWSET" mode="monedas">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='NOM_MONE']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

  <xsl:template match="ROWSET" mode="tipoDespacho">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_TIPO_DESP']"/>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROW">
		<xsl:copy-of select="current()"/>
	</xsl:template>

	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>

</xsl:stylesheet>