<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="yes"/>
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
				<xsl:sort select="CAMPO[@NOMBRE='COD_SBTI_CLIE']"></xsl:sort>
			</xsl:apply-templates>
		</ROWSET>		
	</xsl:template>
	<xsl:template match="ROW" >
		<ROW>
			<xsl:apply-templates select="@*"></xsl:apply-templates>
			<xsl:copy-of select="./CAMPO[position()=3]"></xsl:copy-of>
			<xsl:copy-of select="./CAMPO[position()=4]"></xsl:copy-of>
		</ROW>
	</xsl:template>
	
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
</xsl:stylesheet>