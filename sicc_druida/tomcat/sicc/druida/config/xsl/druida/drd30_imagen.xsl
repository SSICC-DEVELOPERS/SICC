<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_imagen.xsl,v 1.1 2009/12/03 19:03:45 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

 
   <xsl:template match="IMAGEN" mode="estilo">
      <xsl:choose>
         <xsl:when test="@version and @version='3.1'"><xsl:apply-templates select="." mode="estilo_31"/></xsl:when>
         <xsl:otherwise><xsl:apply-templates select="." mode="estilo_old"/></xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <xsl:template match="IMAGEN" mode="script">
      <xsl:choose>
         <xsl:when test="@version and @version='3.1'"><xsl:apply-templates select="." mode="script_31"/></xsl:when>
         <xsl:otherwise><xsl:apply-templates select="." mode="script_old"/></xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <xsl:template match="IMAGEN" mode="body">
      <xsl:choose>
         <xsl:when test="@version and @version='3.1'"><xsl:apply-templates select="." mode="body_31"/></xsl:when>
         <xsl:otherwise><xsl:apply-templates select="." mode="body_old"/></xsl:otherwise>
      </xsl:choose>
   </xsl:template>



   <xsl:template match="IMAGEN" mode="estilo_31">

      <xsl:text>&#xa;#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>Div {position:absolute;</xsl:text>
      <xsl:if test="@ancho and not(@ancho='')">
         <xsl:text> width:</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:if test="@alto and not(@alto='')">
         <xsl:text> height:</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:if test="@x and not(@x='')">
         <xsl:text> left:</xsl:text>
         <xsl:value-of select="@x"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:if test="@y and not(@y='')">
         <xsl:text> top:</xsl:text>
         <xsl:value-of select="@y"/>
         <xsl:text>;</xsl:text>
      </xsl:if>
      <xsl:text>}</xsl:text>
   </xsl:template>

   <xsl:template match="IMAGEN" mode="script_31">
   </xsl:template>

   <xsl:template match="IMAGEN" mode="body_31">
       <div ID="{@nombre}Div">
         <img src="{$vgImgPath}{@img}">
            <xsl:if test="@ancho and not(@ancho='')">
               <xsl:attribute name="width">
                  <xsl:value-of select="@ancho"/>
               </xsl:attribute>
            </xsl:if>
            <xsl:if test="@alto and not(@alto='')">
               <xsl:attribute name="height" >
                  <xsl:value-of select="@alto"/>
               </xsl:attribute>
            </xsl:if>
         </img>
       </div>
   </xsl:template>



   <xsl:template match="IMAGEN" mode="estilo_old">
      <xsl:text>&#xa;</xsl:text>
      <xsl:text>#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>Div {</xsl:text>
      <xsl:text>position:absolute;left:</xsl:text>
      <xsl:value-of select="@x"/>
      <xsl:text>;top:</xsl:text>
      <xsl:value-of select="@y"/>
      <xsl:text>;}</xsl:text>
   </xsl:template>


   <!--     script    -->
   <xsl:template match="IMAGEN" mode="script_old">
      <xsl:text>&#xa;</xsl:text>
      <xsl:variable name="nsdoc">
         <xsl:for-each select="ancestor::*">
            <xsl:if test="name()!='PAGINA'">
               <xsl:text>document.</xsl:text><xsl:value-of select="@nombre"/><xsl:text>.</xsl:text>
            </xsl:if>
         </xsl:for-each>
         <xsl:if test="@x!='' or @y!=''"> <!-- hay capa de por medio -->
            <xsl:text>document.</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text>Div</xsl:text>
         </xsl:if>
         <xsl:text>.document.</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>I</xsl:text>
      </xsl:variable>
      <xsl:text>&#xa;</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>= new Boton('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="$nsdoc"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="@img"/>
      <xsl:text>', '</xsl:text>
      <xsl:value-of select="@tipo"/>
      <xsl:text>',</xsl:text>
      <xsl:choose>
         <xsl:when test="@tipo &lt; 1">
            <xsl:text>false</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@estado"/>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>, </xsl:text>

      <xsl:choose>
         <xsl:when test="@accion!=''">
            <xsl:text>'</xsl:text>
            <xsl:value-of select="@accion"/>
            <xsl:text>'</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:text>null</xsl:text>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:text>, </xsl:text>
      <xsl:choose>
         <xsl:when test="@alt=''">
            <xsl:text>null</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:text>'</xsl:text>
            <xsl:value-of select="@alt"/>
            <xsl:text>'</xsl:text>
         </xsl:otherwise>
      </xsl:choose>

      <xsl:text>, </xsl:text>
      <xsl:choose>
         <xsl:when test="@codigo=''">
            <xsl:text>null</xsl:text>
         </xsl:when>
         <xsl:otherwise>
            <xsl:text>'</xsl:text>
            <xsl:value-of select="@codigo"/>
            <xsl:text>'</xsl:text>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>);&#xa;</xsl:text>

      <!-- init -->
      <xsl:text>function drdOnLoad() {</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>.init();}&#xa;</xsl:text>

      <xsl:apply-templates mode="script"/>

   </xsl:template>


   <!--     body    -->
   <xsl:template match="IMAGEN" mode="body_old">
      <xsl:choose>
         <xsl:when test="@x!='' or @y!=''">
            <DIV>
               <xsl:call-template name="IMAGEN"/>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="IMAGEN"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <xsl:template name="IMAGEN">
      <xsl:attribute name="ID">
         <xsl:value-of select="@nombre"/>
         <xsl:text>Div</xsl:text>
      </xsl:attribute>

      <A HREF="javascript:void(null);">
         <xsl:attribute name="onClick">
            <xsl:value-of select="@nombre"/>
            <xsl:text>.click();return false;</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="onMouseOver">
            <xsl:value-of select="@nombre"/>
            <xsl:text>.onMouseOver();</xsl:text>

            <xsl:if test="@alt!=''">
               <xsl:text>window.status='</xsl:text>
               <xsl:value-of select="@alt"/>
               <xsl:text>';return true;</xsl:text>
            </xsl:if>
         </xsl:attribute>

         <xsl:attribute name="onMouseOut">
            <xsl:value-of select="@nombre"/>
            <xsl:text>.onMouseOut()</xsl:text>
         </xsl:attribute>


         <xsl:choose>
            <xsl:when test="@tipo=0">
               <xsl:call-template name="IMAGEN-IMAGEN">
                  <xsl:with-param name="img0" select="0"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:choose>
                  <xsl:when test="@estado=true">
                     <xsl:call-template name="IMAGEN-IMAGEN">
                        <xsl:with-param name="img0" select="3"/>
                     </xsl:call-template>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:call-template name="IMAGEN-IMAGEN">
                        <xsl:with-param name="img0" select="1"/>
                     </xsl:call-template>
                  </xsl:otherwise>
               </xsl:choose>
            </xsl:otherwise>
         </xsl:choose>
      </A>
   </xsl:template>


   <xsl:template name="IMAGEN-IMAGEN">
      <xsl:param name="img0"></xsl:param>
      <IMG BORDER="0">
         <xsl:attribute name="NAME">
            <xsl:value-of select="@nombre"/>
            <xsl:text>I</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="SRC">
            <xsl:value-of select="@img"/>
            <xsl:value-of select="$img0"/>
            <xsl:text>.gif</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="ALT">
            <xsl:value-of select="@alt"/>
         </xsl:attribute>
      </IMG>
   </xsl:template>


</xsl:stylesheet>

