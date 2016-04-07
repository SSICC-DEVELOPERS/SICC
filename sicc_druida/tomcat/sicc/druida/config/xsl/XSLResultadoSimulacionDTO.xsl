<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output version="1.0" omit-xml-declaration="no" encoding="ISO-8859-1" indent="yes" method="xml"/>

<xsl:template match="//ROWSET2">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="ROWSET[position()=1]"/>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROWSET">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="ROW"/>
	</xsl:copy>
</xsl:template>

<xsl:template match="ROW">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:copy-of select="CAMPO[position()&lt;24 and @NOMBRE!='NUM_UNID_POR_ATEN']"/>
		<xsl:call-template name="valores">
			<xsl:with-param name="clave">
				<xsl:value-of select="CAMPO[@NOMBRE='NUM_SOLI']"/>__<xsl:value-of select="CAMPO[@NOMBRE='TSOL_COD_TIPO_SOLI']"/>__<xsl:value-of select="CAMPO[@NOMBRE='SBAC_COD_SBAC']"/>__<xsl:value-of select="CAMPO[@NOMBRE='ACCE_COD_ACCE']"/>__<xsl:value-of select="CAMPO[@NOMBRE='CANA_COD_CANA']"/>__<xsl:value-of select="CAMPO[@NOMBRE='PAIS_COD_PAIS']"/>__<xsl:value-of select="CAMPO[@NOMBRE='CLIE_COD_CLIE']"/>_<xsl:value-of select="CAMPO[@NOMBRE='NUM_POSI']"/>			
			</xsl:with-param>
		</xsl:call-template>
	</xsl:copy>
</xsl:template>


<xsl:template name="valores">
	<xsl:param name="clave"></xsl:param>
	<xsl:copy-of select="//ROWSET[position()=2]/ROW[concat(CAMPO[@NOMBRE='NUM_SOLI'],'__',CAMPO[@NOMBRE='TSOL_COD_TIPO_SOLI'],'__',CAMPO[@NOMBRE='SBAC_COD_SBAC'],'__',CAMPO[@NOMBRE='ACCE_COD_ACCE'],'__',CAMPO[@NOMBRE='CANA_COD_CANA'],'__',CAMPO[@NOMBRE='PAIS_COD_PAIS'],'__',CAMPO[@NOMBRE='CLIE_COD_CLIE'],'_',CAMPO[@NOMBRE='NUM_POSI'])=$clave]/CAMPO[@NOMBRE='MONT_DESC']"/>
	<xsl:copy-of select="//ROWSET[position()=2]/ROW[concat(CAMPO[@NOMBRE='NUM_SOLI'],'__',CAMPO[@NOMBRE='TSOL_COD_TIPO_SOLI'],'__',CAMPO[@NOMBRE='SBAC_COD_SBAC'],'__',CAMPO[@NOMBRE='ACCE_COD_ACCE'],'__',CAMPO[@NOMBRE='CANA_COD_CANA'],'__',CAMPO[@NOMBRE='PAIS_COD_PAIS'],'__',CAMPO[@NOMBRE='CLIE_COD_CLIE'],'_',CAMPO[@NOMBRE='NUM_POSI'])=$clave]/CAMPO[@NOMBRE='PREC_DESC']"/>
	<xsl:copy-of select="//ROWSET[position()=2]/ROW[concat(CAMPO[@NOMBRE='NUM_SOLI'],'__',CAMPO[@NOMBRE='TSOL_COD_TIPO_SOLI'],'__',CAMPO[@NOMBRE='SBAC_COD_SBAC'],'__',CAMPO[@NOMBRE='ACCE_COD_ACCE'],'__',CAMPO[@NOMBRE='CANA_COD_CANA'],'__',CAMPO[@NOMBRE='PAIS_COD_PAIS'],'__',CAMPO[@NOMBRE='CLIE_COD_CLIE'],'_',CAMPO[@NOMBRE='NUM_POSI'])=$clave]/CAMPO[@NOMBRE='NUM_UNID_POR_ATEN']"/>
</xsl:template>

<xsl:template match="@*">
	<xsl:copy></xsl:copy>
</xsl:template>


</xsl:stylesheet>
