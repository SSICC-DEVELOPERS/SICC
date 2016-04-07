<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_labeltbl.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    LABELTBL    -->
   <!-- *********** -->


   <!--     head    -->
   <xsl:template match="LABELTBL" mode="head">
   </xsl:template>


   <!--     estilo    -->
   <xsl:template match="LABELTBL" mode="estilo">
<xsl:text>
</xsl:text>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--     script    -->
   <xsl:template match="LABELTBL" mode="script">
      <xsl:apply-templates mode="script"/>
   </xsl:template>


   <!--     body    -->
   <xsl:template match="LABELTBL" mode="body">

      <xsl:variable name="vTxt">
         <xsl:choose>
            <xsl:when test="@cod">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:call-template name="escapa">
                  <xsl:with-param name="text" select="translate(@valor, '&#xa;',' ')"/>
                  <xsl:with-param name="caracter">'</xsl:with-param>
               </xsl:call-template>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>


      <xsl:choose>
         <xsl:when test="enlace!=''">
            <!-- comun en label, sacar a plantilla-->
            <A>
               <xsl:attribute name="HREF">
                  <xsl:value-of select="@enlace"/>
               </xsl:attribute>
               <xsl:if test="@destino!=''">
                  <xsl:attribute name="TARGET">
                     <xsl:value-of select="@destino"/>
                  </xsl:attribute>
               </xsl:if>

               <xsl:if test="@id!=''"> <!-- length>0 -->
                  <xsl:attribute name="ID">
                     <xsl:value-of select="@id"/>
                  </xsl:attribute>
               </xsl:if>
               <xsl:value-of select="$vTxt"/>
            </A>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$vTxt"/>
         </xsl:otherwise>
      </xsl:choose>



   </xsl:template>




</xsl:stylesheet>

