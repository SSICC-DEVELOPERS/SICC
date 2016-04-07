<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/> 
	<xsl:template match="//ROWSET2">
		<ROWSET2>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROWSET"/>
		</ROWSET2>
	</xsl:template>
	<xsl:template match="ROWSET">
		<xsl:choose>
			<xsl:when test="./@ID='dtoSalida.lista1_ROWSET'">
				<xsl:copy>
					<xsl:apply-templates select="@*"/>
					<xsl:apply-templates select="./ROW"/>
				</xsl:copy>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
	<xsl:template match="ROW">
		<ROW>
			<xsl:apply-templates select="@*"/>
			<CAMPO NOMBRE="PK"  TIPO="STRING"><xsl:value-of select="./CAMPO[position()=4]"/>|<xsl:value-of select="./CAMPO[position()=5]"/>|<xsl:value-of select="./CAMPO[position()=2]"/>|<xsl:value-of select="./CAMPO[position()=3]"/></CAMPO>
			<xsl:copy-of select="./CAMPO[position()=6]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=7]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=8]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=9]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=10]"></xsl:copy-of>
		</ROW>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy/>
	</xsl:template>
</xsl:stylesheet>
