<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_gestorv.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    GESTORVENTANAS    -->
   <!-- ********** -->


   <!--    head    -->
   <xsl:template match="GESTORVENTANAS" mode="head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>gestorventanas.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template>

   <!--   estilo  -->
   <xsl:template match="GESTORVENTANAS" mode="estilo">
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--   init  -->
   <xsl:template match="GESTORVENTANAS" mode="init">
	   <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="GESTORVENTANAS" mode="script">
	   <xsl:text>var </xsl:text><xsl:value-of select="@nombre"/><xsl:text>=new GestorVentanas("</xsl:text>
			<xsl:value-of select="@nombre"/><xsl:text>","</xsl:text>
      <xsl:choose>
         <xsl:when test="@descriptor">
            <xsl:value-of select="@descriptor"/>
         </xsl:when>
         <xsl:otherwise>
			 <xsl:text>TOP","</xsl:text>
			 <xsl:value-of select="@scroll"/>
			 <xsl:text>","</xsl:text>
			 <xsl:value-of select="@id"/>
			 <xsl:text>",</xsl:text>
			 <xsl:value-of select="@alto"/>
			 <xsl:text>,</xsl:text>
			 <xsl:value-of select="@numeracion"/>
			 <xsl:text>,"</xsl:text>
			 <xsl:value-of select="@pars"/>
         </xsl:otherwise>
      </xsl:choose>
	   <xsl:text>");
	   </xsl:text>

      <!-- EVENTO ONUNLOAD-->
        <xsl:text>window.onunload=function(){</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.finit();}</xsl:text>

   </xsl:template>

   <!--   body  -->
   <xsl:template match="GESTORVENTANAS" mode="body">
   </xsl:template>

</xsl:stylesheet>

