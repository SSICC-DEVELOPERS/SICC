<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" version="1.0" indent="yes"/>
	<xsl:template match="//ROWSET2">
		<Table nombre="tblFunciones" width="561" cellpadding="0" cellspacing="0" align="right" border="0">
			<xsl:apply-templates select="./ROWSET"/>
		</Table>
	</xsl:template>
	<xsl:template match="ROWSET">
		<xsl:apply-templates select="./ROW">
			<xsl:sort select="CAMPO[@NOMBRE='nombre']"/>
		</xsl:apply-templates>
	</xsl:template>
	<xsl:template match="ROW">
		<Tr height="24">
			<Td width="319" id="datosCamposCenterImpar" height="24">
				<xsl:value-of disable-output-escaping="yes" select="./CAMPO[@NOMBRE='nombre']"/>
			</Td>
			<Td width="155" id="datosCamposCenterPar">
				<xsl:text>X</xsl:text>
			</Td>
			<Td width="105" id="datosCamposCenterImpar">
				<xsl:choose>
					<xsl:when test="./CAMPO[@NOMBRE='inicio']=1">
						<xsl:text>X</xsl:text>
					</xsl:when>
					<xsl:otherwise>
						<xsl:text>  </xsl:text>
					</xsl:otherwise>
				</xsl:choose>
			</Td>
		</Tr>
	</xsl:template>
</xsl:stylesheet>