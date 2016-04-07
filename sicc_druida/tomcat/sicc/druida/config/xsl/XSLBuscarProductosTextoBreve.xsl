<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/PROY
   $Id: XSLBuscarProductosTextoBreve.xsl,v 1.1 2009/12/03 19:02:36 pecbazalar Exp $
   DESC
-->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="xml" indent="yes" encoding="ISO-8859-1" omit-xml-declaration="no"/>

<xsl:template match="//ROWSET2">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="./ROWSET"/>
	</xsl:copy> 
</xsl:template> 

<xsl:template match="ROWSET">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:apply-templates select="./ROW"/>
	</xsl:copy> 
</xsl:template> 

<xsl:template match="ROW">
	<xsl:copy>
		<xsl:apply-templates select="@*"/>
		<xsl:copy-of select="./CAMPO"/>
 		<CAMPO NOMBRE="TEXTO_BREVE" TIPO="STRING"/>
   </xsl:copy>
</xsl:template>

<xsl:template match="@*">
	<xsl:copy></xsl:copy> 
</xsl:template> 


</xsl:stylesheet>

