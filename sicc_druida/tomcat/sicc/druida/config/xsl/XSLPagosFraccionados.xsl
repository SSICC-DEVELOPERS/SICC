<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/MAV/SICC
   $Id: XSLPagosFraccionados.xsl,v 1.1 2009/12/03 19:02:32 pecbazalar Exp $
   InsertarActividades
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no"/>
	<xsl:template match="//ROWSET2">
		<ROWSET2>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROWSET"></xsl:apply-templates>
		</ROWSET2>
	</xsl:template>
	<xsl:template match="ROWSET">
	  <xsl:choose>
		  <xsl:when test="./@ID='DTOCombosActividad.pagoFraccionado_ROWSET'">
			  <xsl:copy>
				  <xsl:apply-templates select="@*"></xsl:apply-templates>
          <xsl:apply-templates select="./ROW"></xsl:apply-templates>
        </xsl:copy>
      </xsl:when>
      <xsl:otherwise></xsl:otherwise>
    </xsl:choose>
	</xsl:template>
  <xsl:template match="ROW">
    <xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<CAMPO NOBRE="CODIGO" TIPO="STRING" LONGITUD="12">
				<xsl:value-of select="./CAMPO[position()=1]"/>--<xsl:value-of select="./CAMPO[position()=2]"/>--<xsl:value-of select="./CAMPO[position()=3]"/>
			</CAMPO>
			<xsl:copy-of select="./CAMPO[position()=4]"/>
    </xsl:copy>
	</xsl:template>
  <!-- OBS: parseo correspondiente al método alternativo de carga de combos
  <xsl:template match="//ROWSET">
	  <xsl:copy>
		  <xsl:apply-templates select="@*"></xsl:apply-templates>
      <xsl:apply-templates select="./ROW"></xsl:apply-templates>
    </xsl:copy>
	</xsl:template>
  <xsl:template match="ROW">
    <xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<CAMPO NOBRE="CODIGO" TIPO="STRING" LONGITUD="12"><xsl:value-of select="./CAMPO[position()=1]/@VALOR"/>- -<xsl:value-of select="./CAMPO[position()=2]/@VALOR"/>- -<xsl:value-of select="./CAMPO[position()=3]/@VALOR"/></CAMPO>
      <CAMPO NOMBRE="DESCRIPCION" TIPO="STRING" LONGITUD="200"><xsl:value-of select="./CAMPO[position()=4]/@VALOR"/></CAMPO>
    </xsl:copy>
	</xsl:template>
  -->
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
</xsl:stylesheet>