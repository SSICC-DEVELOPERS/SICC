<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_capa.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    CAPA    -->
   <!-- ********** -->

   <xsl:include href="drd30_NTcapa.xsl"/>


   <!--    head    -->
   <xsl:template match="CAPA" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>

 <!--   dinamico  -->
   <xsl:template match="CAPA" mode="dinamico">

      <xsl:text>&#xa;DrMainEstatico.visibilidad('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:choose>
        <xsl:when test="@visibilidad and @visibilidad='hidden'">O</xsl:when>
        <xsl:otherwise>V</xsl:otherwise>
      </xsl:choose>
      <xsl:text>');</xsl:text>

      <xsl:text>&#xa;DrMainEstatico.moveTo('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>');</xsl:text>

      <xsl:apply-templates mode="dinamico"/>
   </xsl:template>

   <!--    init    -->
   <xsl:template match="CAPA" mode="init">
      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>

      <xsl:apply-templates mode="init"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="CAPA" mode="estilo">

      <xsl:call-template name="CAPAestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
         <xsl:with-param name="colborde"><xsl:value-of select="@colborde"/></xsl:with-param>
         <xsl:with-param name="padding"><xsl:value-of select="@padding"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="zindex"><xsl:value-of select="@zindex"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="imagen"><xsl:value-of select="@imagenf"/></xsl:with-param>
         <xsl:with-param name="repeat"><xsl:value-of select="@repeat"/></xsl:with-param>
      </xsl:call-template>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="CAPA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre,'.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:call-template name="CAPAscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
         <xsl:with-param name="visibilidad"><xsl:value-of select="@visibilidad"/></xsl:with-param>
         <xsl:with-param name="contravsb"><xsl:value-of select="@contravsb"/></xsl:with-param>
      </xsl:call-template>

      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template>


   <!--   body  -->
   <xsl:template match="CAPA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:call-template name="CAPAbody">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/></xsl:with-param>
      </xsl:call-template>

   </xsl:template>


</xsl:stylesheet>

