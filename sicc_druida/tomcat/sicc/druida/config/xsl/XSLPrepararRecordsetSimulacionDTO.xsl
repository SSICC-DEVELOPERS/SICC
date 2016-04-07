<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" encoding="ISO-8859-1" omit-xml-declaration="no" indent="yes" version="1.0"/>
	
	<xsl:template match="//ROWSET2">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="ROWSET"/>
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="ROWSET">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:apply-templates select="ROW">
				<xsl:sort select="CAMPO[@NOMBRE='NUM_SOLI']"></xsl:sort>
				<xsl:sort select="CAMPO[@NOMBRE='TSOL_COD_TIPO_SOLI']"></xsl:sort>
				<xsl:sort select="CAMPO[@NOMBRE='SBAC_COD_SBAC']"></xsl:sort>
				<xsl:sort select="CAMPO[@NOMBRE='CANA_COD_CANA']"></xsl:sort>
				<xsl:sort select="CAMPO[@NOMBRE='ACCE_COD_ACCE']"></xsl:sort>
				<xsl:sort select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"></xsl:sort>
				<xsl:sort select="CAMPO[@NOMBRE='CLIE_COD_CLIE']"></xsl:sort>
				<xsl:sort select="CAMPO[@NOMBRE='NUM_POSI']"></xsl:sort>
			</xsl:apply-templates>
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="ROW">
		<xsl:copy>
			<xsl:apply-templates select="@*"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='TSOL_COD_TIPO_SOLI']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='SBAC_COD_SBAC']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='CANA_COD_CANA']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='ACCE_COD_ACCE']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='PREC_CATA']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='PREC_DESC']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='NUM_UNID_POR_ATEN']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='PERD_ID_PERI']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='MAFA_COD_VENT']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='MARC_COD_MARC']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='NUM_POSI']"/>

			
			<CAMPO NOMBRE="SOCA_NUM_SOLI" TIPO="STRING">
				<xsl:value-of select="CAMPO[@NOMBRE='NUM_SOLI']"/>
			</CAMPO>
			
			<CAMPO NOMBRE="CLIE_COD_CLIE" TIPO="STRING">
			          <xsl:call-template name="replaceCharsInString">
				          <xsl:with-param name="stringIn" select="CAMPO[@NOMBRE='CLIE_COD_CLIE']"/>
				          <xsl:with-param name="charsIn"><xsl:text>zzzzz</xsl:text></xsl:with-param>
				          <xsl:with-param name="charsOut"><xsl:text> </xsl:text></xsl:with-param>
			          </xsl:call-template>
			</CAMPO>
			
			
			<xsl:copy-of select="CAMPO[@NOMBRE='IMP_MONT']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='IMP_TOTA_DESC']"/>
			<xsl:copy-of select="CAMPO[@NOMBRE='FECH_FACTU']"/>
			<CAMPO NOMBRE="MONT_DESC" TIPO="STRING">0</CAMPO>
			<CAMPO NOMBRE="PREC_DESC" TIPO="STRING">0</CAMPO>
		</xsl:copy>
	</xsl:template>
	<xsl:template match="@*">
		<xsl:copy></xsl:copy>
	</xsl:template>


	<xsl:template name="replaceCharsInString">
	  <xsl:param name="stringIn"/>
	  <xsl:param name="charsIn"/>
	  <xsl:param name="charsOut"/>
	  <xsl:choose>
	   <xsl:when test="contains($stringIn,$charsIn)">
	    <xsl:value-of select="concat(substring-before($stringIn,$charsIn),$charsOut)"/>
	    <xsl:call-template name="replaceCharsInString">
	     <xsl:with-param name="stringIn" select="substring-after($stringIn,$charsIn)"/>
	     <xsl:with-param name="charsIn" select="$charsIn"/>
	     <xsl:with-param name="charsOut" select="$charsOut"/>
	    </xsl:call-template>
	   </xsl:when>
	   <xsl:otherwise>
	    <xsl:value-of select="$stringIn"/>
	   </xsl:otherwise>
	  </xsl:choose>
	 </xsl:template>

</xsl:stylesheet>
