<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    CALENDARIO    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="CALENDARIO" mode="head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3calendario.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template>

   <!--   estilo  -->
   <xsl:template match="CALENDARIO" mode="estilo">
      <xsl:text>&#xa;</xsl:text>
      <xsl:text>#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>0 {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>;</xsl:text>
      <xsl:text>width:</xsl:text>
      <xsl:value-of select="@ancho"/>
      <xsl:text>;</xsl:text>
      <xsl:text>height:</xsl:text>
      <xsl:value-of select="@alto"/>
      <xsl:text>;visibility:</xsl:text>
      <xsl:choose>
         <xsl:when test="@visibilidad and @visibilidad='visible'">inherit</xsl:when>
         <xsl:otherwise>hidden</xsl:otherwise>
      </xsl:choose> 
      <xsl:text>;clip:rect(0,</xsl:text>
      <xsl:value-of select="@ancho"/><xsl:text>,</xsl:text><xsl:value-of select="@alto"/><xsl:text>,0); </xsl:text> 
      <xsl:text>layer-background-color:</xsl:text><xsl:value-of select="@colorborde"/>
      <xsl:text>; background-color:</xsl:text><xsl:value-of select="@colorborde"/><xsl:text>}&#xa;</xsl:text>
   </xsl:template>


   <!--   init  -->
   <xsl:template match="CALENDARIO" mode="init">
      <xsl:value-of select="@nombre"/><xsl:text>.init();</xsl:text>
   </xsl:template>


   <!--   script  -->
   <xsl:template match="CALENDARIO" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre, '0.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:text>&#xa;</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>=new Calendario('</xsl:text>
      <xsl:value-of select="@nombre"/>','<xsl:value-of select="$nsdoc-local"/><xsl:text>',</xsl:text>
      <xsl:value-of select="@ancho"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@alto"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@pixelsborde"/><xsl:text>,'</xsl:text>
      <xsl:value-of select="@idmesanio"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@idsemana"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@iddiaoff"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@iddiaon"/><xsl:text>','</xsl:text>
      <xsl:value-of select="$vgImgPath"/><xsl:value-of select="@ruta"/><xsl:text>/','</xsl:text>
      <xsl:value-of select="@fm"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@fM"/><xsl:text>',</xsl:text>
      <xsl:value-of select="@dia"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@mes"/><xsl:text>,</xsl:text>
      <xsl:value-of select="@anio"/><xsl:text>,'</xsl:text>
      <xsl:value-of select="@accion"/><xsl:text>','</xsl:text>
      <xsl:value-of select="@desplazamiento"/><xsl:text>',</xsl:text>

      <xsl:text>[</xsl:text>
      <xsl:for-each select="FESTIVOS/FESTIVO">
         <xsl:text>['</xsl:text><xsl:value-of select="@dia"/><xsl:text>',</xsl:text>
         <xsl:text>'</xsl:text><xsl:value-of select="@mes"/><xsl:text>',</xsl:text>
         <xsl:text>'</xsl:text><xsl:value-of select="@anio"/><xsl:text>',</xsl:text>
         <xsl:text>'</xsl:text><xsl:value-of select="@id"/><xsl:text>']</xsl:text>
         <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>],'</xsl:text>

      <xsl:choose>
        <xsl:when test="@finde and string-length(normalize-space(@finde))>0"><xsl:value-of select="@finde"/></xsl:when>
        <xsl:otherwise><xsl:value-of select="@iddiaoff"/></xsl:otherwise>
      </xsl:choose> 

      <xsl:text>');</xsl:text>

   </xsl:template>


   <xsl:template match="FESTIVOS" mode="script">
      <xsl:value-of select="../@nombre"/><xsl:text>.imgs=[</xsl:text>
      <xsl:for-each select="FESTIVO">
         <xsl:text>'</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:value-of select="@src"/><xsl:text>'</xsl:text>
         <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>];</xsl:text>
   </xsl:template>



   <!--   body  -->
   <xsl:template match="CALENDARIO" mode="body">
      <DIV ID="{concat(@nombre,'0')}">
         <xsl:text> </xsl:text>
      </DIV>
   </xsl:template>




</xsl:stylesheet>

