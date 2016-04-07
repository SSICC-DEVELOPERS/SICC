<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_NTscroll.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">


   <!-- seleccionamos el tipo de SCROLL según una cierta variable en el globales.xml y según el navegador -->
   <xsl:variable name="vScrollNativoIE">
      <xsl:if test="$vNavegador">
          <xsl:choose>
            <xsl:when test="$vgConfig/DATOSPROY/TIPOSCROLL = 'NATIVO'  and  $vNavegador='IE'">S</xsl:when>
            <xsl:otherwise>N</xsl:otherwise>
          </xsl:choose>
      </xsl:if>
      <xsl:if test="not($vNavegador)">N</xsl:if>
   </xsl:variable>



   <!--    SCROLL    -->
   <!-- ****** ***** -->

   

   <!--    head    -->
   <xsl:template name="SCROLLhead">
      <xsl:apply-templates mode="head"/>
   </xsl:template>

   

   <!--   estilo  -->
   <xsl:template name="SCROLLestilo">
      <xsl:param name="nombre"/>
      <xsl:param name="x">0</xsl:param>
      <xsl:param name="y">0</xsl:param>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="colorf"/>
      <xsl:param name="visibilidad"/>
      <xsl:param name="colores"/>
      <!-- seleccionamos según el tipo de scroll: nativo (solo IE) o Druida -->
      <xsl:choose>
		   <xsl:when test="$vScrollNativoIE = 'S'">
            <xsl:call-template name="SCROLLestilo_nativoIE" >
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="$x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="$y"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="$ancho"/></xsl:with-param>
               <xsl:with-param name="colorf"><xsl:value-of select="$colorf"/></xsl:with-param>
               <xsl:with-param name="visibilidad"><xsl:value-of select="$visibilidad"/></xsl:with-param>
               <xsl:with-param name="colores"><xsl:value-of select="$colores"/></xsl:with-param>
            </xsl:call-template>
		   </xsl:when>
		   <xsl:otherwise>
            <xsl:call-template name="SCROLLestilo_druida" >
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="$x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="$y"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="$ancho"/></xsl:with-param>
               <xsl:with-param name="colorf"><xsl:value-of select="$colorf"/></xsl:with-param>
               <xsl:with-param name="visibilidad"><xsl:value-of select="$visibilidad"/></xsl:with-param>
            </xsl:call-template>            
		   </xsl:otherwise>
		</xsl:choose>
   </xsl:template>

     

   <xsl:template name="SCROLLestilo_nativoIE">
      <xsl:param name="nombre"/>
      <xsl:param name="x">0</xsl:param>
      <xsl:param name="y">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="colorf"/>
      <xsl:param name="visibilidad"/>
      <xsl:param name="colores"/>

      <!-- Datos de la capa relativa al scroll -->
      <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text> {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text><xsl:value-of select="$x"/>;top:<xsl:value-of select="$y"/><xsl:text>;</xsl:text>
      <xsl:text>width:</xsl:text><xsl:value-of select="$ancho+16"/>;height:<xsl:value-of select="$alto+16"/><xsl:text>;</xsl:text>
      <xsl:text>overflow: auto;background-color:</xsl:text><xsl:value-of select="$colorf"/><xsl:text>;</xsl:text>

      <xsl:text>visibility:</xsl:text><xsl:value-of select="$visibilidad"/><xsl:text>;</xsl:text>
      <xsl:if test="not($colores = '')">
         <!-- si hay colores, los ponemos en el scroll -->
         <xsl:variable name="vCol"><xsl:value-of select="concat(normalize-space ($colores),',')"/></xsl:variable>

         <xsl:variable name="vScrf"><xsl:value-of select="substring-before($vCol,',')"/></xsl:variable><xsl:variable name="vCol2"><xsl:value-of select="substring-after($vCol,',')"/></xsl:variable>
         <xsl:variable name="vScrs"><xsl:value-of select="substring-before($vCol2,',')"/></xsl:variable><xsl:variable name="vCol3"><xsl:value-of select="substring-after($vCol2,',')"/></xsl:variable>
         <xsl:variable name="vScrh"><xsl:value-of select="substring-before($vCol3,',')"/></xsl:variable><xsl:variable name="vCol4"><xsl:value-of select="substring-after($vCol3,',')"/></xsl:variable>
         <xsl:variable name="vScr3"><xsl:value-of select="substring-before($vCol4,',')"/></xsl:variable><xsl:variable name="vCol5"><xsl:value-of select="substring-after($vCol4,',')"/></xsl:variable>
         <xsl:variable name="vScrd"><xsl:value-of select="substring-before($vCol5,',')"/></xsl:variable><xsl:variable name="vCol6"><xsl:value-of select="substring-after($vCol5,',')"/></xsl:variable>
         <xsl:variable name="vScrt"><xsl:value-of select="substring-before($vCol6,',')"/></xsl:variable><xsl:variable name="vCol7"><xsl:value-of select="substring-after($vCol6,',')"/></xsl:variable>
         <xsl:variable name="vScra"><xsl:value-of select="substring-before($vCol7,',')"/></xsl:variable>

         <xsl:if test="not($vScrf='')">scrollbar-face-color:<xsl:value-of select="$vScrf"/>;</xsl:if>
         <xsl:if test="not($vScrs='')">scrollbar-shadow-color:<xsl:value-of select="$vScrs"/>;</xsl:if>
         <xsl:if test="not($vScrh='')">scrollbar-highlight-color:<xsl:value-of select="$vScrh"/>;</xsl:if>
         <xsl:if test="not($vScr3='')">scrollbar-3dlight-color:<xsl:value-of select="$vScr3"/>;</xsl:if>
         <xsl:if test="not($vScrd='')">scrollbar-darkshadow-color:<xsl:value-of select="$vScrd"/>;</xsl:if>
         <xsl:if test="not($vScrt='')">scrollbar-track-color:<xsl:value-of select="$vScrt"/>;</xsl:if>
         <xsl:if test="not($vScra='')">scrollbar-arrow-color:<xsl:value-of select="$vScra"/>;</xsl:if>

      </xsl:if>
      <!--
      <xsl:text>#EDDCB6; white; #DEBD74;; #F6EDDA; #000000;</xsl:text>
      -->
      <xsl:text>}&#xa;</xsl:text>
   </xsl:template>



   <xsl:template name="SCROLLestilo_druida">
      <xsl:param name="nombre"/>
      <xsl:param name="x">0</xsl:param>
      <xsl:param name="y">0</xsl:param>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="colorf"/>
      <xsl:param name="visibilidad"/>


      <xsl:variable name="vIncx">
         <xsl:choose>
           <xsl:when test="$incy!='0'">16</xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vIncy">
         <xsl:choose>
           <xsl:when test="$incx!='0'">16</xsl:when>
           <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:text>
</xsl:text>
      <xsl:text>#</xsl:text>
      <xsl:value-of select="$nombre"/>
      <xsl:text>Div {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
       <xsl:value-of select="$x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="$y"/>
      <xsl:text>;</xsl:text>

      <xsl:text>width:</xsl:text>
      <xsl:value-of select="number($ancho + $vIncx)"/>
      <xsl:text>;</xsl:text>

      <xsl:text>height:</xsl:text>
      <xsl:value-of select="number($alto + $vIncy)"/>
      <xsl:text>;visibility:</xsl:text>
      <xsl:value-of select="$visibilidad"/>
      <xsl:text>;}
</xsl:text>

      <xsl:if test="$incy!='0'">
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:0;}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsa {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:16;width:16;height:</xsl:text><xsl:value-of select="number($alto - 32)"/><xsl:text>;background-image:URL(</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/</xsl:text><xsl:text>scrollg.gif);layer-background-image:URL(</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/</xsl:text><xsl:text>scrollg.gif); repeat:yes;clip:rect(0,16,</xsl:text><xsl:value-of select="number($alto - 32)"/><xsl:text>,0);}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:</xsl:text><xsl:value-of select="number($alto - 16)"/><xsl:text>;}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsv {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:16;visibility:hidden;}
</xsl:text>
      </xsl:if>

      <xsl:if test="$incx!='0'">
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi {position:absolute;left:0</xsl:text><xsl:text>;top:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsm {position:absolute;left:16</xsl:text><xsl:text>;top:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;width:</xsl:text><xsl:value-of select="number($ancho - 32)"/><xsl:text>;height:16;background-image:URL(</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/</xsl:text><xsl:text>scrollc.gif);layer-background-image:URL(</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/</xsl:text><xsl:text>scrollc.gif); repeat:yes;clip:rect(0,</xsl:text><xsl:value-of select="number($ancho - 32)"/><xsl:text>,16,0);}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd {position:absolute;left:</xsl:text><xsl:value-of select="number($ancho - 16)"/><xsl:text>;top:</xsl:text><xsl:value-of select="number($alto)"/><xsl:text>;}
</xsl:text>
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsh {position:absolute;left:16</xsl:text><xsl:text>;top:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;visibility:hidden;}
</xsl:text>
      </xsl:if>

      <xsl:if test="$incy!='0' and $incx!='0'">
         <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divse {position:absolute;left:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;top:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;}
</xsl:text>
      </xsl:if>

      <xsl:text>#</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divtv {position:absolute;left:0;top:0;width:</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;height:</xsl:text><xsl:value-of select="$alto"/><xsl:text>;clip:rect(0,</xsl:text><xsl:value-of select="$ancho"/><xsl:text>,</xsl:text><xsl:value-of select="$alto"/><xsl:text>,0);overflow:hidden;</xsl:text>
      <xsl:if test="$colorf!=''">
         <xsl:text>background-color:</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>;</xsl:text>
         <xsl:text>layer-background-color:</xsl:text>
         <xsl:value-of select="$colorf"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:text>}
</xsl:text>

      <xsl:text>#</xsl:text>
      <xsl:value-of select="$nombre"/>
      <xsl:text> {</xsl:text>
      <xsl:text>position:absolute;left:0;top:0;}
</xsl:text>

   </xsl:template>







   <!--    init    -->
   <xsl:template name="SCROLLinit">
      <xsl:param name="nombre"/>
      <xsl:value-of select="$nombre"/><xsl:text>_init();</xsl:text>
   </xsl:template>



 <!--   script  -->
   <xsl:template name="SCROLLscript">
      <xsl:param name="nsdoc"/>
      <xsl:param name="nombre"/>
      <xsl:param name="x"/>
      <xsl:param name="y"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="visibilidad"/>
      <!-- seleccionamos según el tipo de scroll: nativo (solo IE) o Druida -->
      <xsl:choose>
		   <xsl:when test="$vScrollNativoIE = 'S'">
            <xsl:call-template name="SCROLLscript_nativoIE" >
               <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc"/></xsl:with-param>
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="$x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="$y"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="$ancho"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
               <xsl:with-param name="visibilidad"><xsl:value-of select="$visibilidad"/></xsl:with-param>
            </xsl:call-template>
		   </xsl:when>
		   <xsl:otherwise>
            <xsl:call-template name="SCROLLscript_druida" >
               <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc"/></xsl:with-param>
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="x"><xsl:value-of select="$x"/></xsl:with-param>
               <xsl:with-param name="y"><xsl:value-of select="$y"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="ancho"><xsl:value-of select="$ancho"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
            </xsl:call-template>            
		   </xsl:otherwise>
		</xsl:choose>
   </xsl:template>



   <xsl:template name="SCROLLscript_nativoIE">
      <xsl:param name="nsdoc"/>
      <xsl:param name="nombre"/>
      <xsl:param name="x"/>
      <xsl:param name="y"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>
      <xsl:param name="visibilidad"/>

      <xsl:value-of select="$nombre"/><xsl:text>=new Object();&#xa;</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>.TC='Scroll';&#xa;</xsl:text>

      <xsl:value-of select="$nombre"/><xsl:text>.vsb='</xsl:text>
      <xsl:choose>
        <xsl:when test="$visibilidad = 'hidden'">hidden</xsl:when>
        <xsl:otherwise>visible</xsl:otherwise>
      </xsl:choose>
      <xsl:text>';</xsl:text>

      <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>_init() {&#xa;</xsl:text>
      <xsl:text>  window.FLAG_SCR_NATIVO='S';&#xa;</xsl:text>
      <xsl:text>  }&#xa;</xsl:text>

      <!-- Lo siguiente es únicamente para solucionar problemas en el "focaliza"  -->
      <xsl:value-of select="$nombre"/><xsl:text>Div=new Object();&#xa;</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>Div.TC='DUMMY';&#xa;</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>Divtv=new Object();&#xa;</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>Divtv.TC='DUMMY';&#xa;</xsl:text>

   </xsl:template>



   <xsl:template name="SCROLLscript_druida">
      <xsl:param name="nsdoc"/>
      <xsl:param name="nombre"/>
      <xsl:param name="x"/>
      <xsl:param name="y"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="ancho"/>
      <xsl:param name="alto"/>

      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat($nombre,'Div.document.')"/>
         <xsl:value-of select="concat($nombre,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:text>
</xsl:text>

      <xsl:value-of select="$nombre"/>
      <xsl:text>=new Object();</xsl:text>

      <xsl:choose>
         <xsl:when test="$incx!='0'">
            <xsl:value-of select="$nombre"/>
            <xsl:text>.activox=0;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$nombre"/>
            <xsl:text>.activox=-1;</xsl:text>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:choose>
         <xsl:when test="$alto&lt;=48">
            <xsl:value-of select="$nombre"/>
            <xsl:text>.alto=10;</xsl:text>
         </xsl:when>
         <xsl:when test="$alto&lt;=69">
            <xsl:value-of select="$nombre"/>
            <xsl:text>.alto=16;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$nombre"/>
            <xsl:text>.alto=37;</xsl:text>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:choose>
         <xsl:when test="$incy!='0'">
            <xsl:value-of select="$nombre"/>
            <xsl:text>.activoy=0;</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="$nombre"/>
            <xsl:text>.activoy=-1;</xsl:text>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:value-of select="$nombre"/><xsl:text>.top=0;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.left=0;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.width=</xsl:text><xsl:value-of select="$ancho"/><xsl:text>;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.height=</xsl:text><xsl:value-of select="$alto"/><xsl:text>;</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>.xpos=</xsl:text><xsl:value-of select="$x"/><xsl:text>;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.ypos=</xsl:text><xsl:value-of select="$y"/><xsl:text>;
</xsl:text>


      <xsl:if test="$incy!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrollv=new Image();</xsl:text><xsl:value-of select="$nombre"/> <xsl:text>scrollv.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollv.gif";</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollg=new Image();</xsl:text><xsl:value-of select="$nombre"/> <xsl:text>scrollg.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollg.gif";</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolls=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolls.on=new Image();</xsl:text><xsl:value-of select="$nombre"/>scrolls.on.src="<xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolls1.gif";</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolls.off=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolls.off.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolls0.gif";
</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollb.on=new Image();</xsl:text><xsl:value-of select="$nombre"/>scrollb.on.src="<xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollb1.gif";</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollb.off=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollb.off.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollb0.gif";
</xsl:text>
      </xsl:if>

      <xsl:if test="$incx!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrollh=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollh.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollh.gif";</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollc=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollc.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollc.gif";</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolld=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.on=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.on.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolld1.gif";</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.off=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.off.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolld0.gif";
</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli.on=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli.on.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolli1.gif";</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli.off=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli.off.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolli0.gif";
</xsl:text>
      </xsl:if>


      <xsl:if test="$incy!='0' and $incx!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrolle=new Image();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolle.src="</xsl:text><xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolle.gif";
</xsl:text>
      </xsl:if>


      <xsl:value-of select="$nombre"/>
      <xsl:text>.nsdoc='</xsl:text>
      <xsl:value-of select="$nsdoc-local"/>
      <xsl:text>';</xsl:text>


      <xsl:if test="$incy!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrolls.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0,string-length($nsdoc-local) - 10)"/><xsl:text>ss.document.images["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolls"]';</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0,string-length($nsdoc-local) - 10)"/><xsl:text>sb.document.images["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrollb"]';</xsl:text>
      </xsl:if>

      <xsl:if test="$incx!='0'">
         <xsl:value-of select="$nombre"/><xsl:text>scrolld.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0,string-length($nsdoc-local) - 10)"/><xsl:text>sd.document.images["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld"]';</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0,string-length($nsdoc-local) - 10)"/><xsl:text>si.document.images["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolli"]';
</xsl:text>
     </xsl:if>

      <xsl:value-of select="$nombre"/><xsl:text>Div=new Object();</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Div.nsdoc='</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - string-length($nombre) - 14)"/><xsl:text>';</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>Div.vsb='visible';</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>.initOK=false;</xsl:text>
      <xsl:value-of select="$nombre"/><xsl:text>Div.TC='Scroll';
</xsl:text>

      <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>_init() {
</xsl:text>

    <xsl:text>if (</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.initOK==false) {
	</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.initOK=true;
</xsl:text>

      <xsl:text>var offsety=(ns?eval(</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.nsdoc+'.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.pageY'):getRealTop(document.all['</xsl:text><xsl:value-of select="$nombre"/><xsl:text>']));if (offsety!=</xsl:text><xsl:value-of select="$y"/><xsl:text>){</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.ypos=offsety;}
</xsl:text>
      <xsl:text>var offsetx=(ns?eval(</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.nsdoc+'.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.pageX'):getRealLeft(document.all['</xsl:text><xsl:value-of select="$nombre"/><xsl:text>']));if (offsetx!=</xsl:text><xsl:value-of select="$x"/><xsl:text>){</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.xpos=offsetx;}
</xsl:text>

      <xsl:text>}
</xsl:text> 
<!--      <xsl:text>offsety=</xsl:text><xsl:value-of select="$y"/><xsl:text>;
</xsl:text>
      <xsl:text>offsetx=</xsl:text><xsl:value-of select="$x"/><xsl:text>;
</xsl:text>-->


      <xsl:if test="$incy!='0'">
<!-- Paginación del scroll-->
	 <xsl:text>if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sa.document.captureEvents(Event.MOUSEDOWN);</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sa.document.onmousedown=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>py;}
</xsl:text>
         <xsl:text>else {document.all["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsa"].onmousedown=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>py;}
</xsl:text>
<!-- -->
	 
	 <xsl:text>if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sv.document.captureEvents(Event.MOUSEMOVE);</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sv.document.onmousemove=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>ay;var h=</xsl:text><xsl:value-of select="$nsdoc-local"/><xsl:text>.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.document.height;}
</xsl:text>
         <xsl:text>else {document.all["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsv"].onmousemove=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>ay;var h=document.all.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.scrollHeight;}
</xsl:text>
         <xsl:text>if (h></xsl:text><xsl:value-of select="$alto"/><xsl:text>) {if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 13)"/><xsl:text>Divsv.visibility="inherit";} else {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsv.style.visibility="inherit";}}
</xsl:text>
         <xsl:text>else {if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 13)"/><xsl:text>Divsv.visibility="hide";} else {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsv.style.visibility="hidden";}}
</xsl:text>

      <xsl:text>if (h&gt;=</xsl:text><xsl:value-of select="$alto"/><xsl:text>) {
	if (ie) {if (</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto==37) {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto=16;}}
	var alto=(</xsl:text><xsl:value-of select="$alto"/><xsl:text>-32)*(</xsl:text><xsl:value-of select="$alto"/><xsl:text>)/h;
	if (alto&lt;</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto) {alto=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto;}
	if (alto&gt;(</xsl:text><xsl:value-of select="$alto"/><xsl:text>-32)) alto=</xsl:text><xsl:value-of select="$alto"/><xsl:text>-32;
</xsl:text>

		 <xsl:choose>
		   <xsl:when test="$vgScrollResize='S'">
		   </xsl:when>
		   <xsl:otherwise>
				<xsl:value-of select="$nombre"/><xsl:text>.alto=37;alto=37;</xsl:text>
			 </xsl:otherwise>
		 </xsl:choose>

 <xsl:text>if (ie) {document.all['</xsl:text><xsl:value-of select="$nombre"/><xsl:text>AscensorImg'].style.pixelHeight=alto;document.all['</xsl:text><xsl:value-of select="$nombre"/><xsl:text>AscensorImg'].style.pixelWidth=16;}
}
</xsl:text>

      </xsl:if>

      <xsl:if test="$incx!='0'">
<!-- Paginación del scroll-->
         <xsl:text>if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sm.document.captureEvents(Event.MOUSEDOWN);</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sm.document.onmousedown=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>px;}
</xsl:text>
         <xsl:text>else {document.all["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsm"].onmousedown=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>px;}
</xsl:text>
<!-- -->

         <xsl:text>if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sh.document.captureEvents(Event.MOUSEMOVE);</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 10)"/><xsl:text>sh.document.onmousemove=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>ax;var w=</xsl:text><xsl:value-of select="$nsdoc-local"/><xsl:text>.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.document.width;}
</xsl:text>
         <xsl:text>else {document.all["</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsh"].onmousemove=</xsl:text><xsl:value-of select="$nombre"/><xsl:text>ax;var w=document.all.</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.scrollWidth;}
</xsl:text>
         <xsl:text>if (w></xsl:text><xsl:value-of select="$ancho"/><xsl:text>) {if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 13)"/><xsl:text>Divsh.visibility="inherit";} else {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsh.style.visibility="inherit";}}
</xsl:text>
         <xsl:text>else {if (ns) {</xsl:text><xsl:value-of select="substring($nsdoc-local,0, string-length($nsdoc-local) - 13)"/><xsl:text>Divsh.visibility="hide";} else {</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsh.style.visibility="hidden";}}
</xsl:text>
      </xsl:if>

      <xsl:text>}
</xsl:text>

<!-- Paginación del scroll-->
      <xsl:if test="$incy!='0'">
         <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>py(e) {paginadoy("</xsl:text><xsl:value-of select="$nombre"/><xsl:text>",(ns)?e.pageY:event.y+document.body.scrollTop);return false;}
</xsl:text>
      </xsl:if>
      <xsl:if test="$incx!='0'">
         <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>px(e) {paginadox("</xsl:text><xsl:value-of select="$nombre"/><xsl:text>",(ns)?e.pageX:event.x+document.body.scrollLeft);return false;}
</xsl:text>
      </xsl:if>
<!-- -->
      <xsl:if test="$incy!='0'">
         <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>ay(e) {ascensory("</xsl:text><xsl:value-of select="$nombre"/><xsl:text>",(ns)?e.pageY:event.y+document.body.scrollTop);return false;}
</xsl:text>
      </xsl:if>
      <xsl:if test="$incx!='0'">
         <xsl:text>function </xsl:text><xsl:value-of select="$nombre"/><xsl:text>ax(e) {ascensorx("</xsl:text><xsl:value-of select="$nombre"/><xsl:text>",(ns)?e.pageX:event.x+document.body.scrollLeft);return false;}
</xsl:text>
      </xsl:if>

      <!-- FUNCIONES EVENTOS DESPLAZAMIENTOS DE LAS CAPAS -->

      <xsl:if test="$incy!='0'">

      <!-- EVENTO ONMOUSEDOWN -->
         <xsl:text>function fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss() { </xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy=1;img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolls','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolls.on');scrolly('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>',+</xsl:text>
         <xsl:value-of select="$incy"/>
         <xsl:text>);}
</xsl:text>

      <!-- EVENTO ONMOUSEUP -->
      <xsl:text>function fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss() { </xsl:text>
         <xsl:text>img_to('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolls','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolls.off');if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activoy=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      <!-- EVENTO ONMOUSEOUT -->
      <xsl:text>function fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss() { </xsl:text>
         <xsl:text>img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolls','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolls.off');if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','V');}}</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>.activoy=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      <!-- EVENTO ONMOUSEDOWN capa DIVSB -->
      <xsl:text>function fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb() { </xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy=1;img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb','</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb.on');scrolly('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>',-</xsl:text>
         <xsl:value-of select="$incy"/><xsl:text>);</xsl:text>
         <xsl:text>}
</xsl:text>

      <!-- EVENTO ONMOUSEUP capa DIVSB -->
      <xsl:text>function fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb() { </xsl:text>
         <xsl:text>img_to('</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>scrollb','</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>scrollb.off'); if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activoy=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      <!-- EVENTO ONMOUSEOUT capa DIVSB -->
         <xsl:text>function fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb() { </xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activoy=0;img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrollb','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrollb.off'); if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activoy==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activoy=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      </xsl:if>

      <xsl:if test="$incx!='0'">

      <!-- EVENTO ONMOUSEDOWN capa DIVSI -->
      <xsl:text>function fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi() { </xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activox=1;img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli','</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli.on');scrollx('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>',+</xsl:text>
         <xsl:value-of select="$incx"/><xsl:text>);</xsl:text>
         <xsl:text>}
</xsl:text>

      <!-- EVENTO ONMOUSEUP capa DIVSI -->
      <xsl:text>function fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi() { </xsl:text>
         <xsl:text>img_to('</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>scrolli','</xsl:text><xsl:value-of select="$nombre"/>
         <xsl:text>scrolli.off');if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activox==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activox=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      <!-- EVENTO ONMOUSEOUT capa DIVSI -->
      <xsl:text>function fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi() { </xsl:text>
         <xsl:text>img_to('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>scrolli','</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>scrolli.off');if (ns) { if (</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>.activox==1){visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/>
         <xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activox=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      <!-- EVENTO ONMOUSEDOWN capa DIVSD -->
      <xsl:text>function fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd() { </xsl:text>
         <xsl:value-of select="$nombre"/><xsl:text>.activox=1;img_to('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld','</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.on');scrollx('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>',-</xsl:text><xsl:value-of select="$incx"/><xsl:text>);</xsl:text>
         <xsl:text>}
</xsl:text>

      <!-- EVENTO ONMOUSEUP capa DIVSD -->
      <xsl:text>function fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd() { </xsl:text>
         <xsl:text>img_to('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld','</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.off');if (ns) { if (</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox==1){visibilidad('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      <!-- EVENTO ONMOUSEOUT capa DIVSD -->
      <xsl:text>function fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd() { </xsl:text>
         <xsl:text>img_to('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld','</xsl:text><xsl:value-of select="$nombre"/><xsl:text>scrolld.off');if (ns) { if (</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox==1){visibilidad('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>','O');txt_to('DRUIDA','');visibilidad('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>','V');}}</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox=0;</xsl:text>
         <xsl:text>}
</xsl:text>

      </xsl:if>

   </xsl:template>





   <xsl:template name="SCROLLbody">
      <xsl:param name="nsdoc"/>
      <xsl:param name="nombre"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="alto">0</xsl:param>
      <!-- seleccionamos el tipo de scroll: nativo (solo IE) o Druida -->
      <xsl:choose>
		   <xsl:when test="$vScrollNativoIE = 'S'">
            <xsl:call-template name="SCROLLbody_nativoIE" >
               <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc"/></xsl:with-param>
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
            </xsl:call-template>
		   </xsl:when>
		   <xsl:otherwise>
            <xsl:call-template name="SCROLLbody_druida" >
               <xsl:with-param name="nsdoc"><xsl:value-of select="$nsdoc"/></xsl:with-param>
               <xsl:with-param name="nombre"><xsl:value-of select="$nombre"/></xsl:with-param>
               <xsl:with-param name="incx"><xsl:value-of select="$incx"/></xsl:with-param>
               <xsl:with-param name="incy"><xsl:value-of select="$incy"/></xsl:with-param>
               <xsl:with-param name="alto"><xsl:value-of select="$alto"/></xsl:with-param>
            </xsl:call-template>            
		   </xsl:otherwise>
		</xsl:choose>
   </xsl:template>





   <xsl:template name="SCROLLbody_nativoIE">
      <xsl:param name="nsdoc"/>
      <xsl:param name="nombre"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="alto">0</xsl:param>

      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat($nombre,'Div.document.')"/>
         <xsl:value-of select="concat($nombre,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>
      
      <DIV onscroll="onScrollNativoIE('{$nombre}')" >
         <xsl:attribute name="ID">
            <xsl:value-of select="$nombre"/>
         </xsl:attribute>
         <xsl:apply-templates select="*[not (name()='PAGINADO') and not (name()='OCUPADO')]" mode="body">
            <xsl:with-param name="nsdoc">
               <xsl:value-of select="concat($nsdoc-local,'.document.',$nombre)"/>
            </xsl:with-param>
         </xsl:apply-templates>
      </DIV>
      <!-- Lo siguiente es para solucionar problemas en el "focaliza" sin tocar mucho el base.js -->

   </xsl:template>





   <!--   body  -->
   <xsl:template name="SCROLLbody_druida" >
      <xsl:param name="nsdoc"/>
      <xsl:param name="nombre"/>
      <xsl:param name="incx">0</xsl:param>
      <xsl:param name="incy">0</xsl:param>
      <xsl:param name="alto">0</xsl:param>
<!--      
      <xsl:param name="x"/>
      <xsl:param name="y"/>
      <xsl:param name="ancho"/>
-->
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat($nombre,'Div.document.')"/>
         <xsl:value-of select="concat($nombre,'Divtv.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>



      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="$nombre"/><xsl:text>Div</xsl:text>
         </xsl:attribute>
         <xsl:text>
</xsl:text>

         <xsl:if test="$incy!='0'">
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divss</xsl:text>
               </xsl:attribute>
               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

		 <xsl:choose>
		   <xsl:when test="@omo='S'">
			  <xsl:attribute name="onmouseover">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss();</xsl:text>
			  </xsl:attribute>
		   </xsl:when>
		   <xsl:otherwise>
			  <xsl:attribute name="onmousedown">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss();</xsl:text>
			  </xsl:attribute>
			  <xsl:attribute name="onmouseup">
			     <xsl:text>fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss();</xsl:text>
			  </xsl:attribute>
		   </xsl:otherwise>
		 </xsl:choose>
		  
                  <xsl:attribute name="onmouseout">
                     <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divss();</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="NAME">
                        <xsl:value-of select="$nombre"/><xsl:text>scrolls</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolls0.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>

               </xsl:element>

            </DIV>
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsa</xsl:text>
               </xsl:attribute>
               <xsl:text> </xsl:text>
            </DIV>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsb</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

		 <xsl:choose>
		   <xsl:when test="@omo='S'">
			  <xsl:attribute name="onmouseover">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb();</xsl:text>
			  </xsl:attribute>
		   </xsl:when>
		   <xsl:otherwise>
			  <xsl:attribute name="onmousedown">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb();</xsl:text>
			  </xsl:attribute>
			  <xsl:attribute name="onmouseup">
			     <xsl:text>fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb();</xsl:text>
			  </xsl:attribute>
		   </xsl:otherwise>
		 </xsl:choose>

		  <xsl:attribute name="onmouseout">
                     <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsb();</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="NAME">
                        <xsl:value-of select="$nombre"/><xsl:text>scrollb</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollb0.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>

               </xsl:element>
            </DIV>
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsv</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseDown">
                     <xsl:text>scrollIEname='</xsl:text><xsl:value-of select="$nombre"/><xsl:text>';</xsl:text>
                     <xsl:value-of select="$nombre"/><xsl:text>.activoy=2</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseUp">
                     <xsl:text>if (ns) { </xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy=0;} else { scrollIEup() }</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseOut">
                     <xsl:text>if (ns) { </xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy=0;}</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollv.gif</xsl:text>
                     </xsl:attribute>

			   <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>AscensorImg</xsl:text>
               </xsl:attribute>

<!-- <xsl:if test="$alto&lt;75">
                     <xsl:attribute name="HEIGHT">
                        <xsl:text>15</xsl:text>
                     </xsl:attribute>

                     <xsl:attribute name="WIDTH">
                        <xsl:text>16</xsl:text>
                     </xsl:attribute>
</xsl:if> -->

                     <xsl:attribute name="HEIGHT">
                        <xsl:text>&amp;{</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.alto};</xsl:text>
                     </xsl:attribute>

                     <xsl:attribute name="WIDTH">
                        <xsl:text>16</xsl:text>
                     </xsl:attribute>

                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>
               </xsl:element>
            </DIV>
         </xsl:if>

         <xsl:if test="$incx!='0'">
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsi</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

		 <xsl:choose>
		   <xsl:when test="@omo='S'">
			  <xsl:attribute name="onmouseover">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi();</xsl:text>
			  </xsl:attribute>
		   </xsl:when>
		   <xsl:otherwise>
			  <xsl:attribute name="onmousedown">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi();</xsl:text>
			  </xsl:attribute>
			  <xsl:attribute name="onmouseup">
			     <xsl:text>fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi();</xsl:text>
			  </xsl:attribute>
		   </xsl:otherwise>
		 </xsl:choose>

                  <xsl:attribute name="onMouseOut">
                     <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsi();</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="NAME">
                        <xsl:value-of select="$nombre"/><xsl:text>scrolli</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolli0.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>
               </xsl:element>
            </DIV>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsm</xsl:text>
               </xsl:attribute>
               <xsl:text> </xsl:text>
            </DIV>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsd</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

		 <xsl:choose>
		   <xsl:when test="@omo='S'">
			  <xsl:attribute name="onmouseover">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd();</xsl:text>
			  </xsl:attribute>
		   </xsl:when>
		   <xsl:otherwise>
			  <xsl:attribute name="onmousedown">
			     <xsl:text>fomd_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd();</xsl:text>
			  </xsl:attribute>
			  <xsl:attribute name="onmouseup">
			     <xsl:text>fomu_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd();</xsl:text>
			  </xsl:attribute>
		   </xsl:otherwise>
		 </xsl:choose>

                  <xsl:attribute name="onMouseOut">
                     <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>Divsd();</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="NAME">
                        <xsl:value-of select="$nombre"/><xsl:text>scrolld</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolld0.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>
               </xsl:element>
            </DIV>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divsh</xsl:text>
               </xsl:attribute>

               <xsl:element name="A">
                  <xsl:attribute name="href">
                     <xsl:text>javascript:void(null);</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onclick">
                     <xsl:text>return false;</xsl:text>
                  </xsl:attribute>

                  <xsl:attribute name="onMouseDown">
                     <xsl:text>scrollIEname='</xsl:text><xsl:value-of select="$nombre"/><xsl:text>';</xsl:text>
                     <xsl:value-of select="$nombre"/><xsl:text>.activox=2</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseUp">
                     <xsl:text>if (ns) { </xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox=0;} else { scrollIEup() }</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="onMouseOut">
                     <xsl:text>if (ns) { </xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activox=0;}</xsl:text>
                  </xsl:attribute>

                  <xsl:element name="IMG">
                     <xsl:attribute name="SRC">
                        <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrollh.gif</xsl:text>
                     </xsl:attribute>
                     <xsl:attribute name="BORDER">
                        <xsl:text>0</xsl:text>
                     </xsl:attribute>
                  </xsl:element>
               </xsl:element>
            </DIV>
         </xsl:if>

         <xsl:if test="$incy!='0' and $incx!='0'">
            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/><xsl:text>Divse</xsl:text>
               </xsl:attribute>

               <xsl:element name="IMG">
                  <xsl:attribute name="SRC">
                     <xsl:value-of select="$vgImgPath"/><xsl:text>scroll/scrolle.gif</xsl:text>
                  </xsl:attribute>
                  <xsl:attribute name="BORDER">
                     <xsl:text>0</xsl:text>
                  </xsl:attribute>
               </xsl:element>
            </DIV>
         </xsl:if>

         <DIV>
            <xsl:attribute name="ID">
               <xsl:value-of select="$nombre"/><xsl:text>Divtv</xsl:text>
            </xsl:attribute>

            <xsl:attribute name="onscroll">
			<xsl:text>if(</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy!=-1){</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy=1;scrolly('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>',0);</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy=0;}</xsl:text>
<!--               <xsl:value-of select="$nombre"/><xsl:text>.activoy=1;scrolly('</xsl:text><xsl:value-of select="$nombre"/><xsl:text>',0);</xsl:text><xsl:value-of select="$nombre"/><xsl:text>.activoy=0;</xsl:text> -->
            </xsl:attribute>

            <DIV>
               <xsl:attribute name="ID">
                  <xsl:value-of select="$nombre"/>
               </xsl:attribute>

               <!-- -->
               <xsl:apply-templates select="*[not (name()='PAGINADO') and not (name()='OCUPADO')]" mode="body">
                  <xsl:with-param name="nsdoc">
                     <xsl:value-of select="concat($nsdoc-local,'.document.',$nombre)"/>
                  </xsl:with-param>
               </xsl:apply-templates>

            </DIV>

         </DIV>

      </DIV>
   </xsl:template>

</xsl:stylesheet>
