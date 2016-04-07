<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output version="1.0" encoding="ISO-8859-1" omit-xml-declaration="no" method="xml" indent="yes"/>
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
			<xsl:copy-of select="./CAMPO[position()=4]"/>
			<xsl:copy-of select="./CAMPO[position()=6]"/>
		</ROW>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy/>
	</xsl:template>
</xsl:stylesheet>


