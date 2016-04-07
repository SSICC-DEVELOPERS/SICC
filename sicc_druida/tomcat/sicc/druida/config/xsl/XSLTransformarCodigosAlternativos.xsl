<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:param name="principal"></xsl:param>
<xsl:param name="descripcion"></xsl:param>
<xsl:output version="1.0" encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="yes"/>
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
			</xsl:apply-templates>
		</ROWSET>
	</xsl:template>
	<xsl:template match="ROW" >
		<!--xsl:if test="$principal!=./CAMPO[position()=1]"-->
			<ROW>
				<xsl:apply-templates select="@*"></xsl:apply-templates>
				<CAMPO NOMBRE="test" STRING="STRING"><xsl:value-of select="$principal"/>--<xsl:value-of select="./CAMPO[position()=1]"/></CAMPO>
				<CAMPO NOMBRE="codigo" TIPO="STRING"><xsl:value-of select="$principal"/></CAMPO>
				<CAMPO NOMBRE="descripcion" TIPO="STRING"><xsl:value-of select="$descripcion"/></CAMPO>
				<CAMPO NOMBRE="codigo_alternativo" TIPO="STRING"><xsl:value-of select="./CAMPO[position()=1]"/></CAMPO>
				<CAMPO NOMBRE="descripcion_alternativo" TIPO="STRING"><xsl:value-of select="./CAMPO[position()=3]"/></CAMPO>
			</ROW>
		<!--/xsl:if-->
	</xsl:template>
	
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
</xsl:stylesheet>