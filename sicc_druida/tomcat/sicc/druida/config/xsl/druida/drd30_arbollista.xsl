<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    ARBOLLISTA    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="ARBOLLISTA" mode="head">
      <SCRIPT TYPE="text/javascript">
         <xsl:attribute name="SRC">
            <xsl:value-of select="$jsDruidaPath"/>
            <xsl:text>d3arbollista.js</xsl:text>
         </xsl:attribute>
         <xsl:text> </xsl:text>
      </SCRIPT>
      <xsl:apply-templates mode="head"/>
   </xsl:template>

   <!--   estilo  -->
   <xsl:template match="ARBOLLISTA" mode="estilo">

      <xsl:call-template name="SCROLLestilo">
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
         <xsl:with-param name="colorf"><xsl:value-of select="@colorf"/></xsl:with-param>
         <xsl:with-param name="visibilidad">inherit</xsl:with-param>
      </xsl:call-template>

   </xsl:template>


   <!--   init  -->
   <xsl:template match="ARBOLLISTA" mode="init">
<!--      <xsl:value-of select="@nombre"/><xsl:text>.display();</xsl:text>-->
   </xsl:template>


   <!--   script  -->
   <xsl:template match="ARBOLLISTA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:variable name="arbolscroll">
         <xsl:value-of select="concat(@nombre,'Scroll')"/>
      </xsl:variable>


      <xsl:text>
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>=new ArbolLista();
</xsl:text>
<!--      <xsl:value-of select="@nombre"/><xsl:text>.nsdoc='</xsl:text><xsl:value-of select="$nsdoc-local"/><xsl:text>';
</xsl:text> -->
      <xsl:value-of select="@nombre"/><xsl:text>.nombre='</xsl:text><xsl:value-of select="@nombre"/><xsl:text>';
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.id=</xsl:text><xsl:value-of select="@id"/><xsl:text>;
</xsl:text>

     <xsl:value-of select="@nombre"/><xsl:text>.imgOpen='</xsl:text><xsl:value-of select="$imgPath"/><xsl:value-of select="@imgOpen"/><xsl:text>';
</xsl:text>
     <xsl:value-of select="@nombre"/><xsl:text>.imgClose='</xsl:text><xsl:value-of select="$imgPath"/><xsl:value-of select="@imgClose"/><xsl:text>';
</xsl:text>
     <xsl:value-of select="@nombre"/><xsl:text>.imgChk0='</xsl:text><xsl:value-of select="$imgPath"/><xsl:value-of select="@imgChk0"/><xsl:text>';
</xsl:text>
     <xsl:value-of select="@nombre"/><xsl:text>.imgChk1='</xsl:text><xsl:value-of select="$imgPath"/><xsl:value-of select="@imgChk1"/><xsl:text>';
</xsl:text>
     <xsl:value-of select="@nombre"/><xsl:text>.imgHueco='</xsl:text><xsl:value-of select="$imgPath"/><xsl:value-of select="@imgHueco"/><xsl:text>';
</xsl:text>
	 <xsl:value-of select="@nombre"/><xsl:text>.anchos=</xsl:text><xsl:value-of select="@anchos"/><xsl:text>;
</xsl:text>
     <xsl:value-of select="@nombre"/><xsl:text>.checkCascade=</xsl:text><xsl:value-of select="@checkCascade"/><xsl:text>;
</xsl:text>
     <xsl:value-of select="@nombre"/><xsl:text>.indent=</xsl:text><xsl:value-of select="@indent"/><xsl:text>;
</xsl:text>
      <xsl:value-of select="@nombre"/><xsl:text>.TC='ARBOLLISTA';
</xsl:text>

	  <xsl:if test="string-length(@accion) > 0">
	     <xsl:value-of select="@nombre"/><xsl:text>.accion="</xsl:text><xsl:value-of select="@accion"/><xsl:text>";
</xsl:text>
      </xsl:if> 

	  <xsl:if test="string-length(@seleccionUnica)>0 and @seleccionUnica='N'">
	     <xsl:value-of select="@nombre"/><xsl:text>.seleccionUnica=false;
</xsl:text>
      </xsl:if> 

      <xsl:apply-templates mode="script"/>


      <!-- Llamo a SCROLL -->
      <xsl:variable name="nsdocSC-parte-local">
         <xsl:value-of select="concat($arbolscroll,'Div.document.')"/>
         <xsl:value-of select="concat($arbolscroll,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdocSC-local">
         <xsl:value-of select="concat(concat($nsdoc-local,'.'),$nsdocSC-parte-local)"/>
      </xsl:variable>


      <xsl:call-template name="SCROLLscript">
         <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdocSC-local"/></xsl:with-param>
         <xsl:with-param name="nombre"><xsl:value-of select="@nombre"/>Scroll</xsl:with-param>
         <xsl:with-param name="x"><xsl:value-of select="@x"/></xsl:with-param>
         <xsl:with-param name="y"><xsl:value-of select="@y"/></xsl:with-param>
         <xsl:with-param name="incx"><xsl:value-of select="@incx"/></xsl:with-param>
         <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         <xsl:with-param name="ancho"><xsl:value-of select="@ancho"/></xsl:with-param>
         <xsl:with-param name="alto"><xsl:value-of select="@alto"/></xsl:with-param>
      </xsl:call-template>


   </xsl:template>


   <xsl:template match="ICONOS" mode="script">
      <xsl:value-of select="../@nombre"/><xsl:text>.iconos=[</xsl:text>
      <xsl:for-each select="ICONO">
         <xsl:text>'</xsl:text><xsl:value-of select="$imgPath"/><xsl:value-of select="@src"/><xsl:text>'</xsl:text>
         <xsl:if test="not(position()=last())"><xsl:text>,</xsl:text></xsl:if>
      </xsl:for-each>
      <xsl:text>];</xsl:text>
   </xsl:template>

   <!--   body  -->
   <xsl:template match="ARBOLLISTA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <!-- body de scroll -->
         <xsl:variable name="nuevonombre">
            <xsl:value-of select="@nombre"/>
            <xsl:text>Scroll</xsl:text>
         </xsl:variable>

         <xsl:call-template name="SCROLLbody">
            <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            <xsl:with-param name="nombre"><xsl:value-of select="$nuevonombre"/></xsl:with-param>
            <xsl:with-param name="incx"><xsl:value-of select="@incy"/></xsl:with-param>
            <xsl:with-param name="incy"><xsl:value-of select="@incy"/></xsl:with-param>
         </xsl:call-template>
   </xsl:template>


   <xsl:template match="ICONOS" mode="body">
   </xsl:template>


</xsl:stylesheet>


