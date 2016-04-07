<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:preserve-space elements="*"/>
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="yes"></xsl:output>
	
	<xsl:template match="//ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROWSET[@ID='DTOSalidaMarcaCanalActividad.marca_ROWSET']" mode="marca"/>
			<xsl:apply-templates select="./ROWSET[@ID='DTOSalidaMarcaCanalActividad.canal_ROWSET']" mode="canal"/>
      <xsl:copy-of select="./CAMPO"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET" mode="marca">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_MARC']"/>
			</xsl:apply-templates>
		</xsl:copy>	
	</xsl:template>
	<xsl:template match="ROWSET" mode="canal">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROW">
				<xsl:sort select="CAMPO[@NOMBRE='DES_CANA']"/>
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