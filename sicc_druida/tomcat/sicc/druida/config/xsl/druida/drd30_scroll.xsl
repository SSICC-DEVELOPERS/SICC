<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_scroll.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    SCROLL    -->
   <!-- ****** ***** -->

   <xsl:include href="drd30_NTscroll.xsl"/>

   <!--    head    -->
   <xsl:template match="SCROLL" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="SCROLL" mode="estilo">

      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
         <xsl:with-param name="colores"><xsl:value-of select="@colores"/></xsl:with-param>
      </xsl:call-template>

      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--    init    -->
   <xsl:template match="SCROLL" mode="init">
      <xsl:value-of select="@nombre"/><xsl:text>_init();</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="SCROLL" mode="script">
      <xsl:param name="nsdoc"/>

      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat(@nombre,'Div.document.')"/>
         <xsl:value-of select="concat(@nombre,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,'.',$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:call-template name="SCROLLscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
      </xsl:call-template>

      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="concat($nsdoc-local,'.',@nombre,'.document')"/>
<!--            <xsl:value-of select="$nsdoc-local"/> -->
         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template>



   <!--   body  -->
   <xsl:template match="SCROLL" mode="body">
      <xsl:param name="nsdoc"/>

      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

         <xsl:call-template name="SCROLLbody">
            <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
            <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         </xsl:call-template>


   </xsl:template>

</xsl:stylesheet>

