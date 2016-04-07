<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_botonera.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    BOTONERA    -->
   <!-- *********** -->

   <!--                                                         -->
   <!--                       HEAD                              -->
   <!--                                                         -->
   <xsl:template match="BOTONERA" mode="head">

<!--      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsPath"/>
            <xsl:text>boton.js</xsl:text>
         </xsl:attribute>
-->
         <xsl:apply-templates mode="head"/>
<!--      </SCRIPT> -->
   </xsl:template>


   <!--                                                         -->
   <!--                            ESTILO                         -->
   <!--                                                         -->
   <xsl:template match="BOTONERA" mode="estilo">
<xsl:text>
</xsl:text>

      <xsl:text>
#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text> {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>; visibility:inherit;}</xsl:text>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>


   <!--     init    -->
   <xsl:template match="BOTONERA" mode="init">
      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>
      <xsl:apply-templates mode="init"/>
   </xsl:template>


   <!--                                                           -->
   <!--                          SCRIPT                           -->
   <!--                                                           -->
   <xsl:template match="BOTONERA" mode="script">
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
      <xsl:text>.estado=new Array();</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.nsdoc='</xsl:text>
      <xsl:value-of select="$nsdoc-local"/>
      <xsl:text>';</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.vsb='visible';</xsl:text>

      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template>


   <!--
      FALTA completar el tipo para botonera Vertical
      Ahora mismo se trata el modo Horizontal
   -->
   <!--     body    -->
   <xsl:template match="BOTONERA" mode="body">

      <xsl:choose>
         <xsl:when test="name(../.)='TD'">
            <xsl:call-template name="BOTONERA"/>
         </xsl:when>

         <xsl:when test="@x!='0' or @y!='0'">
            <DIV ID="{@nombre}">
               <xsl:call-template name="BOTONERA"/>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="BOTONERA"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <xsl:template name="BOTONERA">
      <TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0"><xsl:apply-templates mode="body"/></TABLE>
   </xsl:template>

</xsl:stylesheet>

