<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:preserve-space elements="*"/>
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="yes"></xsl:output>

	<xsl:param name="field">COD_SAP</xsl:param>
	<xsl:param name="values">*</xsl:param>
	<xsl:param name="include">1</xsl:param>
	
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
				<xsl:when test="not($field) or not($values)">
					<xsl:apply-templates select="./ROW"/>
				</xsl:when>
				<xsl:when test="$values='*'">
					<xsl:apply-templates select="./ROW"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:for-each select="./ROW">
						<xsl:choose>
							<xsl:when test="$include=1">
								<xsl:if test="contains($values,concat(concat('|',./CAMPO[@NOMBRE=$field]),'|'))">
									<xsl:apply-templates select="current()"/>	
								</xsl:if>
							</xsl:when>
							<xsl:otherwise>
								<xsl:if test="not(contains($values,concat(concat('|',./CAMPO[@NOMBRE=$field]),'|')))">
									<xsl:apply-templates select="current()"/>
								</xsl:if>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:for-each>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="ROW">
		<xsl:copy-of select="current()"/>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
	
</xsl:stylesheet>