<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_NTcapa.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    CAPAmodo
   Es llamada desde CAPA y desde LISTA         -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template name="CAPAhead">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template name="CAPAestilo">
      <xsl:param name="nombre"/>
      <xsl:param name="x">0</xsl:param>
      <xsl:param name="y">0</xsl:param>
      <xsl:param name="visibilidad"/>
      <xsl:param name="colborde"/>
      <xsl:param name="padding"/>
      <xsl:param name="ancho"/> <!-- 0</xsl:param> -->
      <xsl:param name="alto"/>
      <xsl:param name="zindex"/>
      <xsl:param name="colorf"/>
      <xsl:param name="imagen"/>
      <xsl:param name="repeat"/>
      <xsl:param name="overflow"/>

      <xsl:text>&#xa;</xsl:text>
      <xsl:text>#</xsl:text>
      <xsl:value-of select="$nombre"/>
      <xsl:text> {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="$x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="$y"/>
      <xsl:text>;visibility:</xsl:text>
      <xsl:value-of select="$visibilidad"/>
      <xsl:text>;</xsl:text>

      <xsl:if test="$colborde!=''">
         <xsl:text>border:solid </xsl:text>
         <xsl:value-of select="$colborde"/>
         <xsl:text> 1px;</xsl:text>
      </xsl:if>

      <xsl:if test="$padding!=''">
         <xsl:text>padding:</xsl:text>
         <xsl:value-of select="$padding"/>
         <xsl:text>px;</xsl:text>
      </xsl:if>

      <xsl:if test="$ancho!=''">
         <xsl:text>width:</xsl:text>
         <xsl:value-of select="$ancho"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="$alto!=''">
         <xsl:text>height:</xsl:text>
         <xsl:value-of select="$alto"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="$zindex!=''">
         <xsl:text>z-index:</xsl:text>
         <xsl:value-of select="$zindex"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

        <xsl:if test="$overflow!=''">
         <xsl:text>overflow:</xsl:text>
         <xsl:value-of select="$overflow"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="$colorf!=''">
         <xsl:text>background-color:</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>;</xsl:text>
         <xsl:text>layer-background-color:</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="$imagen!=''">
         <xsl:text>background-image:URL(</xsl:text>
         <xsl:value-of select="$vgImgPath"/>
         <xsl:value-of select="$imagen"/>
         <xsl:text>);</xsl:text>
         <xsl:text>layer-background-image:URL(</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>);</xsl:text>
         <xsl:text>background-repeat:</xsl:text>
         <xsl:value-of select="$repeat"/>
         <xsl:text>;</xsl:text>
      </xsl:if>

      <xsl:if test="string-length($ancho)!=0 or string-length($alto)!=0">
         <xsl:text>clip:rect(0,</xsl:text>
         <xsl:value-of select="$ancho"/>
         <xsl:text>,</xsl:text>
         <xsl:value-of select="$alto"/>
         <xsl:text>,0);</xsl:text>
      </xsl:if>

      <xsl:text>}</xsl:text>

   </xsl:template>


   <!--   script  -->
   <xsl:template name="CAPAscript">
      <xsl:param name="nsdoc"/>
      <xsl:param name="nombre"/>
      <xsl:param name="visibilidad"/>
      <xsl:param name="contravsb"/>
      <xsl:text>&#xa;</xsl:text>

      <xsl:value-of select="$nombre"/>
      <xsl:text>=new Object();</xsl:text>

      <xsl:value-of select="$nombre"/>
      <xsl:text>.nsdoc='</xsl:text>
      <xsl:value-of select="$nsdoc"/>
      <xsl:text>';</xsl:text>

      <xsl:value-of select="$nombre"/>
      <xsl:text>.vsb='</xsl:text>
      <xsl:choose>
        <xsl:when test="$visibilidad = 'hidden'">hidden</xsl:when>
        <xsl:otherwise>visible</xsl:otherwise>
      </xsl:choose>
      <xsl:text>';</xsl:text>

      <xsl:value-of select="$nombre"/>
      <xsl:text>.contravsb="</xsl:text>
      <xsl:value-of select="$contravsb"/>
      <xsl:text>";</xsl:text>

      <xsl:value-of select="$nombre"/>
      <xsl:text>.TC='Capa';</xsl:text>

   </xsl:template>




   <!--   body  -->
   <xsl:template name="CAPAbody">
      <xsl:param name="nsdoc"/>
      <xsl:param name="nombre"/>

      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="$nombre"/>
         </xsl:attribute>

         <xsl:apply-templates mode="body">
            <xsl:with-param name="nsdoc">
               <xsl:value-of select="$nsdoc"/>
            </xsl:with-param>
         </xsl:apply-templates>
      </DIV>
   </xsl:template>


</xsl:stylesheet>
