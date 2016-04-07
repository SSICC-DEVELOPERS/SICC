<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output encoding="ISO-8859-1" indent="yes" method="xml"
		omit-xml-declaration="no" version="1.0"/>
	<xsl:key match="ROW" name="condiciones" use="CAMPO[2]"/>
	<xsl:template match="//ROWSET2">
		<ROWSET2>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="./ROWSET"/>
		</ROWSET2>
	</xsl:template>
	<xsl:template match="ROWSET">
		<ROWSET>
			<xsl:apply-templates select="@*"/>
			<xsl:for-each select="ROW[count(. | key('condiciones',CAMPO[2])[1])=1]">
				<ROW>
					<xsl:apply-templates select="@*"/>
				<xsl:copy-of select="./CAMPO[position()=1]"/>
				<xsl:copy-of select="./CAMPO[position()=2]"/>
				</ROW>
			</xsl:for-each>
		</ROWSET>
	</xsl:template>
	<xsl:template match="ROW">
		<ROW>
			<xsl:apply-templates select="@*"/>
			<xsl:variable name="var" select="CAMPO[position()=1]"></xsl:variable>
			<xsl:variable name="estuvo" select="'no'"/>
			<xsl:for-each select="preceding-sibling::*"> 
                   		 <xsl:if test="CAMPO[1]=$var">
                   		 	<xsl:variable name="estuvo" select="'si'"></xsl:variable>
                   		 </xsl:if>
			</xsl:for-each>
			<xsl:value-of select="$estuvo"/>		
			<xsl:if test="$estuvo='no'">
				<xsl:copy-of select="./CAMPO[position()=1]"/>
				<xsl:copy-of select="./CAMPO[position()=2]"/>
			</xsl:if>
		</ROW>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy/>
	</xsl:template>
</xsl:stylesheet>