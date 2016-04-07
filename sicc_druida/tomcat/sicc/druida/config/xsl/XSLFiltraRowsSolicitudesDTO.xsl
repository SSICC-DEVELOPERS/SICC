<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="values">*</xsl:param>
							     	
	<xsl:preserve-space elements="*"/>
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="yes"></xsl:output>
	<xsl:template match="//ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROWSET"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:choose>
				<xsl:when test="not($values)">
					<xsl:apply-templates select="./ROW"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:choose>
						<xsl:when test="$values='*'">
							<xsl:apply-templates select="ROW"/>	
						</xsl:when>
						<xsl:otherwise>
							<xsl:for-each select="./ROW">
								<xsl:variable name="clave">
									<xsl:value-of select="CAMPO[@NOMBRE='CLIE_COD_CLIE']"/>__<xsl:value-of select="CAMPO[@NOMBRE='ACCE_COD_ACCE']"/>__<xsl:value-of select="CAMPO[@NOMBRE='CANA_COD_CANA']"/>__<xsl:value-of select="CAMPO[@NOMBRE='NUM_SOLI']"/>__<xsl:value-of select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"/>__<xsl:value-of select="CAMPO[@NOMBRE='SBAC_COD_SBAC']"/>__<xsl:value-of select="CAMPO[@NOMBRE='TSOL_COD_TIPO_SOLI']"/>
								</xsl:variable>								
								<xsl:if test="contains($values,$clave)">
									<xsl:apply-templates select="current()"/>	
								</xsl:if>
							</xsl:for-each>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="ROW">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="CAMPO"/>
			<CAMPO NOMBRE="MONT_DESC" TIPO="STRING">0</CAMPO>
			<CAMPO NOMBRE="PREC_DESC" TIPO="STRING">0</CAMPO>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="CAMPO">
		<xsl:copy-of select="."></xsl:copy-of>
	</xsl:template>

	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
		
</xsl:stylesheet>