<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="rowset"/>
	<xsl:param name="include">1</xsl:param>
	<xsl:param name="sep"><xsl:text>|</xsl:text></xsl:param>
	
	<xsl:preserve-space elements="*"/>
	<xsl:output encoding="ISO-8859-1" method="xml" omit-xml-declaration="no" indent="yes"></xsl:output>
	<xsl:template match="//ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROWSET"/>
		</xsl:copy>
	</xsl:template>

	<xsl:template match="ROWSET">
		<xsl:choose>
			<xsl:when test="not($rowset)">
				<xsl:copy-of select="current()"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:call-template name="separador">
					<xsl:with-param name="str" select="$rowset"></xsl:with-param>
				</xsl:call-template>	
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	 <xsl:template name="separador">
	        <xsl:param name="str"/>
	        <xsl:choose>
		        <xsl:when test="contains($str,$sep)">
		        		<xsl:call-template name="selector">
		        			<xsl:with-param name="nombre">
		        				<xsl:value-of select="substring-before($str,$sep)"/>
		        			</xsl:with-param>
		        		</xsl:call-template>
		          	<xsl:call-template name="separador">
		                        <xsl:with-param name="str" select="substring-after($str,$sep)" />
		                </xsl:call-template>
		        </xsl:when>
		        <xsl:otherwise>
		        		<xsl:call-template name="selector">
		        			<xsl:with-param name="nombre">
		        				<xsl:value-of select="$str"/>
		        			</xsl:with-param>
		        		</xsl:call-template>
		        </xsl:otherwise>
	        </xsl:choose>
	</xsl:template>


	<xsl:template name="selector">
		<xsl:param name="nombre"/>
		<xsl:choose>
			<xsl:when test="$nombre">
				<xsl:choose>
					<xsl:when test="$include=1">
						<xsl:if test="current()/@ID=$nombre">
							<xsl:copy-of select="current()"/>
						</xsl:if>
					</xsl:when>
					<xsl:otherwise>
						<xsl:if test="current()/@ID!=$nombre">
							<xsl:copy-of select="current()"/>
						</xsl:if>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:copy-of select="current()"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>
	
</xsl:stylesheet>