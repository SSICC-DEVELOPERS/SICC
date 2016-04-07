<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_matrizjs.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->


<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

   <!--<xsl:template match="MATRIZJS" mode="script">

      <xsl:text>&#xa;</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>=[</xsl:text>
      <xsl:for-each select="ROWSET/ROW">
         <xsl:text>[</xsl:text>
            <xsl:for-each select="CAMPO">

               <xsl:text>'</xsl:text>
               <xsl:call-template name="escapa">
                   <xsl:with-param name="text" select="translate(translate(concat(.,@VALOR), '&#13;',' '), '&#xa;',' ')"/>
                   <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
               <xsl:text>'</xsl:text>

               <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
            </xsl:for-each>
         <xsl:text>]</xsl:text>
         <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>];&#xa;</xsl:text>

   </xsl:template>-->

   <xsl:template match="MATRIZJS" mode="script">
      <xsl:value-of select="@nombre"/>
      <xsl:text>=</xsl:text>
      <xsl:apply-templates select="ROWSET2|ROWSET|ROW|CAMPO" mode="generandomatriz"/>
      <xsl:text>;</xsl:text>
   </xsl:template>

   <xsl:template match="ROWSET|ROWSET2|ROW" mode="generandomatriz">
      <xsl:text>[</xsl:text>
      <xsl:apply-templates select="ROWSET2|ROWSET|ROW|CAMPO" mode="generandomatriz"/>
      <xsl:text>]</xsl:text>
      <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
   </xsl:template>

   <xsl:template match="CAMPO" mode="generandomatriz">
      <xsl:text>'</xsl:text>
      <xsl:call-template name="escapaCaracterYBarra">
          <xsl:with-param name="text" select="translate(translate(concat(.,@VALOR), '&#13;',' '), '&#xa;',' ')"/>
          <xsl:with-param name="caracter">'</xsl:with-param>
      </xsl:call-template>
      <xsl:text>'</xsl:text>
      <xsl:if test="position()!=last()"><xsl:text>,</xsl:text></xsl:if>
   </xsl:template>

   <xsl:template match="text()" mode="generandomatriz">
   </xsl:template>

</xsl:stylesheet>

