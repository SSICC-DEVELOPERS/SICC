<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output omit-xml-declaration="no" version="1.0" encoding="ISO-8859-1" indent="yes" method="xml"/>	
<xsl:template match="//ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROWSET"></xsl:apply-templates>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" >
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:apply-templates select="./ROW"></xsl:apply-templates>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="ROW" >
		<xsl:copy>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:copy-of select="./CAMPO[position()=1]"/>
			<CAMPO NOMBRE="COD_SAP2" TIPO="STRING"><xsl:value-of select="./CAMPO[position()=2]"/></CAMPO>
			<xsl:copy-of select="./CAMPO[position()=3]"/>
			<xsl:copy-of select="./CAMPO[position()=12]"/>
			<xsl:copy-of select="./CAMPO[position()=4]"/>
			<xsl:copy-of select="./CAMPO[position()=10]"/>
			<xsl:copy-of select="./CAMPO[position()=7]"/>
			<xsl:copy-of select="./CAMPO[position()=8]"/>
			<xsl:copy-of select="./CAMPO[position()=9]"/>
			<xsl:copy-of select="./CAMPO[position()=5]"/>
			<xsl:copy-of select="./CAMPO[position()=6]"/>
			<xsl:copy-of select="./CAMPO[position()=11]"/>
			<xsl:copy-of select="./CAMPO[position()=13]"/>
			<xsl:copy-of select="./CAMPO[position()=14]"/>
			<xsl:copy-of select="./CAMPO[position()=15]"/>
			<xsl:copy-of select="./CAMPO[position()=16]"/>
			<xsl:copy-of select="./CAMPO[position()=17]"/>
			<xsl:copy-of select="./CAMPO[position()=18]"/>
			<xsl:copy-of select="./CAMPO[position()=19]"/>
			<xsl:copy-of select="./CAMPO[position()=20]"/>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
</xsl:stylesheet>