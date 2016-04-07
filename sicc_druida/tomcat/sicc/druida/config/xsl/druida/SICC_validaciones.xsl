<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   $Id: SICC_validaciones.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

   
   <!--    VALIDACION   -->
   <!-- ********** -->

   <xsl:template name="VALIDACION">
   	<xsl:text>&#xa;</xsl:text>
   	<SCRIPT TYPE="text/javascript"><xsl:text>&#xa;</xsl:text>
   		<xsl:text>var objValidacionSICC = new Array();&#xa;</xsl:text>
   		<xsl:for-each select="VALIDACION/ELEMENTO">
   			<xsl:text>objValidacionSICC[objValidacionSICC.length]=new Object();&#xa;</xsl:text>
   			<xsl:text>objValidacionSICC[objValidacionSICC.length-1].nombre='</xsl:text><xsl:value-of select="@nombre"/><xsl:text>';&#xa;</xsl:text>
   			<xsl:text>objValidacionSICC[objValidacionSICC.length-1].requerido=</xsl:text><xsl:choose>
							<xsl:when test="@requerido and (@requerido='s' or @requerido='S')">
								<xsl:text>true</xsl:text>
							</xsl:when>
							<xsl:otherwise>false</xsl:otherwise>
						</xsl:choose><xsl:text>;&#xa;</xsl:text>
			<xsl:text>objValidacionSICC[objValidacionSICC.length-1].formato='</xsl:text><xsl:choose>
							<xsl:when test="@formato and (@formato='f' or @formato='F')">
								<xsl:text>Fecha</xsl:text>
							</xsl:when>
							<xsl:when test="@formato and (@formato='n' or @formato='N')">
								<xsl:text>Numerico</xsl:text>
							</xsl:when>
							<xsl:otherwise>
								<xsl:text>Texto</xsl:text>
							</xsl:otherwise>
						</xsl:choose><xsl:text>';&#xa;</xsl:text>
			<xsl:text>objValidacionSICC[objValidacionSICC.length-1].maximo=</xsl:text><xsl:choose>
							<xsl:when test="@maximo and number(@maximo)"><xsl:value-of select="@maximo"/></xsl:when>
							<xsl:otherwise><xsl:text>0</xsl:text></xsl:otherwise>
						</xsl:choose><xsl:text>;&#xa;</xsl:text>
			<xsl:text>objValidacionSICC[objValidacionSICC.length-1].mostrar='</xsl:text><xsl:choose>
							<xsl:when test="@mostrar and (string-length(normalize-space(@mostrar))>0)"><xsl:value-of select="@mostrar"/></xsl:when>
							<xsl:otherwise><xsl:value-of select="@nombre"/></xsl:otherwise>
						</xsl:choose><xsl:text>';&#xa;</xsl:text>
     		</xsl:for-each>
   	</SCRIPT><xsl:text>&#xa;</xsl:text>
       </xsl:template>
</xsl:stylesheet>