<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   $Id: SICC_Validaciones.xsl,v 1.1 2009/12/03 19:02:32 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

   
   <!--    VALIDACION   -->
   <!-- ********** -->

   <xsl:template name="VALIDACION">
   	<xsl:param name="nodo"/>
   	<xsl:text>&#xa;</xsl:text>
		<SCRIPT TYPE="text/javascript">
			<xsl:attribute name="SRC">
				<xsl:value-of select="$jsPath"/><xsl:text>validaciones_sicc.js</xsl:text>
			</xsl:attribute>
	  <xsl:text>&#xa;</xsl:text>
		</SCRIPT>
   	<SCRIPT TYPE="text/javascript"><xsl:text>&#xa;</xsl:text>
   		<xsl:text>var objValidacionSICC = new Array();&#xa;</xsl:text>
   		<xsl:for-each select="$nodo/ELEMENTO">
			
			<xsl:text>objValidacionSICC[objValidacionSICC.length]=new objValidante(</xsl:text>
			<xsl:text>"</xsl:text><xsl:value-of select="@name"/><xsl:text>",</xsl:text>
   			<xsl:choose>
							<xsl:when test="@required">
								<xsl:choose>
									<xsl:when test="@required='true'"><xsl:text>true</xsl:text></xsl:when>
									<xsl:when test="@required='True'"><xsl:text>true</xsl:text></xsl:when>
									<xsl:when test="@required='TRUE'"><xsl:text>true</xsl:text></xsl:when>
									<xsl:otherwise><xsl:text>false</xsl:text></xsl:otherwise>
								</xsl:choose>
							</xsl:when>
							<xsl:otherwise><xsl:text>false</xsl:text></xsl:otherwise>
						</xsl:choose><xsl:text>,</xsl:text>
			<xsl:text>"</xsl:text><xsl:choose>
							<xsl:when test="@format and (@format='f' or @format='F')">
								<xsl:text>Fecha</xsl:text>
							</xsl:when>
							<xsl:when test="@format and (@format='n' or @format='N')">
								<xsl:text>Numerico</xsl:text>
							</xsl:when>
							<xsl:when test="@format and (@format='m' or @format='M')">
								<xsl:text>Moneda</xsl:text>
							</xsl:when>
							<xsl:when test="@format and (@format='a' or @format='A')">
								<xsl:text>MonedaAlternativa</xsl:text>
							</xsl:when>
							<xsl:when test="@format and (@format='e' or @format='E')">
								<xsl:text>Entero</xsl:text>
							</xsl:when>
							<xsl:otherwise>
								<xsl:text>Texto</xsl:text>
							</xsl:otherwise>
						</xsl:choose><xsl:text>",</xsl:text>
			<xsl:text>"</xsl:text><xsl:choose>
							<xsl:when test="@max"><xsl:value-of select="@max"/></xsl:when>
							<xsl:otherwise><xsl:text></xsl:text></xsl:otherwise>
						</xsl:choose><xsl:text>",</xsl:text>
			<xsl:text>"</xsl:text><xsl:choose>
							<xsl:when test="@min"><xsl:value-of select="@min"/></xsl:when>
							<xsl:otherwise><xsl:text></xsl:text></xsl:otherwise>
						</xsl:choose><xsl:text>",</xsl:text>
			<xsl:text>"</xsl:text><xsl:choose>
							<xsl:when test="@chars and string-length(@chars)>0"><xsl:value-of select="@chars"/></xsl:when>
							<xsl:otherwise><xsl:text></xsl:text></xsl:otherwise>
						</xsl:choose><xsl:text>",</xsl:text>
			<xsl:text>"</xsl:text>
						<xsl:choose>
							<xsl:when test="@cod and (string-length(normalize-space(@cod))>0)">
								<xsl:call-template name="langtxt.i10n">
									<xsl:with-param name="pCod" select="@cod"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:when test="@show and (string-length(normalize-space(@show))>0)"><xsl:value-of select="@show"/></xsl:when>
						</xsl:choose><xsl:text>",</xsl:text>
			<xsl:text>"</xsl:text>
						<xsl:if test="@group and (string-length(normalize-space(@group))>0)">
							<xsl:value-of select="normalize-space(@group)"/>
						</xsl:if><xsl:text>");</xsl:text>
     		</xsl:for-each>
   	</SCRIPT><xsl:text>&#xa;</xsl:text>
       </xsl:template>
</xsl:stylesheet>