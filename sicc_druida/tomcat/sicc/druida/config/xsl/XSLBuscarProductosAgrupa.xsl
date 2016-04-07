<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:preserve-space elements="*"/>
	<xsl:output indent="yes" omit-xml-declaration="no" encoding="ISO-8859-1" method="xml"/>
	
	<xsl:key name="condiciones" match="ROW" use="CAMPO[@NOMBRE='COD_SAP'][position()=1]"/>
	
	<xsl:template match="//ROWSET2">
		<xsl:apply-templates select="./ROWSET[position()=1]"></xsl:apply-templates>
	</xsl:template>
	
	<xsl:template match="ROWSET">
		<xsl:for-each select="./ROW[count(. | key('condiciones',CAMPO[@NOMBRE='COD_SAP'])[1])=1]">
			<xsl:apply-templates select=".">
				<xsl:sort select="CAMPO[@NOMBRE='COD_SAP'][position()=1]"/>
			</xsl:apply-templates>
		</xsl:for-each>
	</xsl:template>
	
	<xsl:template match="ROW">
		<xsl:copy-of select="current()"/>
	</xsl:template>

</xsl:stylesheet>