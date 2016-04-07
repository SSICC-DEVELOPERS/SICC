<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_solapa.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    SOLAPA    -->
   <!-- *********** -->


   <!--     head    -->
   <xsl:template match="SOLAPA" mode="head">
      <xsl:apply-templates mode="head"/>
   </xsl:template>

   <!--     init    -->
   <xsl:template match="SOLAPA" mode="init">
      <xsl:apply-templates mode="init"/>
   </xsl:template>


   <!--     estilo    -->
   <xsl:template match="SOLAPA" mode="estilo">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat(@nombre,'.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:apply-templates mode="estilo">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template>


   <!--     script    -->
   <xsl:template match="SOLAPA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
<!--         <xsl:value-of select="concat(@nombre,'.document')"/> -->
<!--      <xsl:text>.</xsl:text>  -->
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>
<xsl:text>
</xsl:text>


         <xsl:variable name="numero"><xsl:number/></xsl:variable>
         <xsl:variable name="vImagen">
            <xsl:value-of select="../@nombre"/> <!-- ../ siempre sera SOLAPA -->
            <xsl:value-of select="$numero - 1"/>
         </xsl:variable>

                  <!-- funciones eventos imagenes en BODY -->  

      <!-- EVENTO ONCLICK -->
        <xsl:text>function foc_</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>() { solapas_to('</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>','</xsl:text><xsl:value-of select="CAPA/@nombre"/><xsl:text>'); }</xsl:text>

      <!-- EVENTO ONMOUSEOVER -->
        <xsl:text>function fomo_</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>() { window.status='</xsl:text><xsl:value-of select="@texto"/><xsl:text>'; return true; }</xsl:text>
   
   <!--     script de IMAGEN   -->

         <xsl:value-of select="$vImagen"/>
         <xsl:text>=new Object();</xsl:text>

         <xsl:value-of select="$vImagen"/>
         <xsl:text>.off=new Image();</xsl:text>

         <xsl:value-of select="$vImagen"/>
         <xsl:text>.off.src="</xsl:text>
         <xsl:value-of select="$vgImgPath"/>
         <xsl:value-of select="@off"/>
         <xsl:text>";</xsl:text>

         <xsl:value-of select="$vImagen"/>
         <xsl:text>.chk=new Image();</xsl:text>

         <xsl:value-of select="$vImagen"/>
         <xsl:text>.chk.src="</xsl:text>
         <xsl:value-of select="$vgImgPath"/>
         <xsl:value-of select="@on"/>
         <xsl:text>";</xsl:text>

         <xsl:value-of select="$vImagen"/>
         <xsl:text>.nsdoc='</xsl:text>
         <xsl:value-of select="$nsdoc-local"/>
<!--         <xsl:value-of select="concat('.',$nsdoc)"/>  -->
         <xsl:text>.images["</xsl:text><xsl:value-of select="$vImagen"/><xsl:text>"]';</xsl:text>


      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>


   </xsl:template>




   <!--     body    -->
   <xsl:template match="SOLAPA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat(@nombre,'.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>
<xsl:text>
</xsl:text>

      <xsl:apply-templates mode="body">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>
   </xsl:template>



</xsl:stylesheet>

