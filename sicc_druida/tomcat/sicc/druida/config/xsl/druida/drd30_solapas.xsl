<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_solapas.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->

 <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    SOLAPAS    -->
   <!-- *********** -->


   <!--     head    -->
   <xsl:template match="SOLAPAS" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--     estilo    -->
   <xsl:template match="SOLAPAS" mode="estilo">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat(@nombre,'.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>
<xsl:text>
</xsl:text>
      <!-- comun, sacar a plantilla general -->
      <xsl:text>#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text> {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>;visibility:hidden; }</xsl:text>

      <xsl:apply-templates mode="estilo">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template>


   <!--     script    -->
   <xsl:template match="SOLAPAS" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre,'.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>
<xsl:text>
</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>=new Object();</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.nsdoc='</xsl:text>
      <xsl:value-of select="$nsdoc-local"/>
      <xsl:text>'; </xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.i='</xsl:text>
      <xsl:value-of select="SOLAPA[@inicial='S']/CAPA/@nombre"/>
      <xsl:text>'; </xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.pestanias=[</xsl:text>
      <xsl:for-each select="SOLAPA">
         <xsl:call-template name="DELIMITA">
            <xsl:with-param name="cadena" select="CAPA/@nombre"/>
            <xsl:with-param name="sep">'</xsl:with-param>
         </xsl:call-template>
         <xsl:if test="position()!=last()">
            <xsl:text>,</xsl:text>
         </xsl:if>
      </xsl:for-each>
      <xsl:text>];</xsl:text>

        <xsl:if test="@accion">
           <xsl:value-of select="@nombre"/><xsl:text>.accion="</xsl:text><xsl:value-of select="@accion"/><xsl:text>";</xsl:text>
        </xsl:if>      

      <xsl:value-of select="@nombre"/>
      <xsl:text>.vsb='visible';</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.TC='Solapas';
</xsl:text>


      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>


   </xsl:template>


   <!--     init    -->
   <xsl:template match="SOLAPAS" mode="init">
      <xsl:text>solapas_to('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="SOLAPA[@inicial='S']/CAPA/@nombre"/><xsl:text>',true);visibilidad('</xsl:text><xsl:value-of select="@nombre"/><xsl:text>','V');</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template>


   <!--     body    -->
   <xsl:template match="SOLAPAS" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre,'.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>

         <TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0">
            <TR>
               <xsl:for-each select="SOLAPA">
                  <xsl:variable name="vImagen">
                     <xsl:value-of select="../@nombre"/> <!-- ../ siempre sera SOLAPA -->
                     <xsl:value-of select="position() - 1"/>
                  </xsl:variable>
                  <TD>

                  <xsl:variable name="vOnClick">
                     <xsl:text>img_to('</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>','</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>.chk');</xsl:text>
                      <xsl:text>solapas_to('</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="CAPA/@nombre"/><xsl:text>');return false;</xsl:text>
                  </xsl:variable>

                  <xsl:element name="A">           
                        <xsl:attribute name="HREF">javascript:void(0);</xsl:attribute>

                        <xsl:attribute name="onClick">
                           <xsl:text>foc_</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>(); return false;</xsl:text>
                        </xsl:attribute>

                        <xsl:attribute name="onMouseOver">
                           <xsl:text>fomo_</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>();</xsl:text>
                        </xsl:attribute>
                        <IMG NAME="{$vImagen}" SRC="{$vgImgPath}{@off}"
                             BORDER="0" ALT="{@texto}"/>
                  </xsl:element>          

                  </TD>

            </xsl:for-each>
            </TR>
         </TABLE>

         <xsl:apply-templates mode="body">
            <xsl:with-param name="nsdoc">
               <xsl:value-of select="$nsdoc-local"/>
            </xsl:with-param>
         </xsl:apply-templates>
      </DIV>


   </xsl:template>


</xsl:stylesheet>

