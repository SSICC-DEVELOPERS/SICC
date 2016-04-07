<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_label.xsl,v 1.1 2009/12/03 19:03:43 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    LABEL    -->
   <!-- *********** -->


   <!--     head    -->
   <xsl:template match="LABEL" mode="head">
   </xsl:template>


   <!--     estilo    -->
   <xsl:template match="LABEL" mode="estilo">
<xsl:text>
</xsl:text>
         <!-- Capas absolutas -->
            <!-- comun, sacar a plantilla general -->
            <xsl:text>#</xsl:text>
            <xsl:value-of select="@nombre"/>
            <xsl:text> {</xsl:text>
            <xsl:text>position:absolute;left:</xsl:text>
            <xsl:value-of select="@x"/>
            <xsl:text>;top:</xsl:text>
            <xsl:value-of select="@y"/>
            <xsl:text>; }</xsl:text>
   </xsl:template>


   <!--     script    -->
   <xsl:template match="LABEL" mode="script">
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
      <xsl:text>.NS='</xsl:text>
      <xsl:value-of select="$nsdoc-local"/>
      <xsl:text>'; </xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.ID='</xsl:text>
      <xsl:value-of select="@id"/>
      <xsl:text>'; </xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.TC='Label';</xsl:text>

      <xsl:call-template name="label.tooltip.script"/>
      <xsl:variable name="vLink">
         <xsl:choose>
            <xsl:when test="@enlace">
               <xsl:text>"</xsl:text><xsl:value-of select="@enlace"/><xsl:text>"</xsl:text>
            </xsl:when>
            <xsl:otherwise>null</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:value-of select="@nombre"/>
      <xsl:text>.link=</xsl:text>
      <xsl:value-of select="$vLink"/>
      <xsl:text>; </xsl:text>

      <!-- para enviar oculto -->
      <xsl:if test="@enviaroculto='S'">
         <xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>TC="Hidden";</xsl:text>
         <xsl:value-of select="@nombre"/><xsl:text>.enviar='</xsl:text><xsl:value-of select="ancestor::FORMULARIO/@nombre"/><xsl:text>.</xsl:text><xsl:value-of select="@nombre"/>';
      </xsl:if> 

   </xsl:template>



   <!--   init  -->
   <xsl:template match="LABEL" mode="init">
      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>

      <xsl:if test="not(@enlace) or string-length(@enlace)=0">
         <xsl:text>txt_to('</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>','</xsl:text>
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
         <xsl:text>');</xsl:text>
      </xsl:if>

   </xsl:template>



   <!--     body    -->
   <xsl:template match="LABEL" mode="body">
      <xsl:choose>
         <xsl:when test="@enlace!=''">
            <xsl:call-template name="LABEL-BODY-ENLACE" />
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="LABEL-BODY-NORMAL" />
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>



   <xsl:template name="LABEL-BODY-NORMAL">

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

      <DIV>
         <xsl:attribute name="ID">
            <xsl:value-of select="@nombre"/>
         </xsl:attribute>

         <xsl:choose>
            <xsl:when test="@id!=''"> <!-- length>0 -->
               <SPAN>
                  <xsl:attribute name="ID">
                     <xsl:value-of select="@id"/>
                  </xsl:attribute>

<!--                  <xsl:value-of select="@texto"/> 
                  <xsl:value-of select="@valor"/> -->
                  <xsl:value-of select="$vTxt"/>

               </SPAN>
            </xsl:when>
            <xsl:otherwise>
<!--                  <xsl:value-of select="@texto"/> 
                  <xsl:value-of select="@valor"/> -->
                  <xsl:value-of select="$vTxt"/>
            </xsl:otherwise>
         </xsl:choose>
      </DIV>
   </xsl:template>

   <xsl:template name="LABEL-BODY-ENLACE">
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

      <DIV ID="{@nombre}">

         <!-- comun en labeltbl, sacar a plantilla-->
         <A HREF="{@enlace}">
            <xsl:if test="@destino!=''">
               <xsl:attribute name="TARGET">
                  <xsl:value-of select="@destino"/>
               </xsl:attribute>
            </xsl:if>
            <xsl:choose>
               <xsl:when test="@id!=''"> 
                  <SPAN>
                     <xsl:attribute name="ID">
                        <xsl:value-of select="@id"/>
                     </xsl:attribute>
                     <xsl:value-of select="$vTxt"/>
                  </SPAN>
               </xsl:when>
               <xsl:otherwise>
                     <xsl:value-of select="$vTxt"/>
               </xsl:otherwise>
            </xsl:choose>
         </A>
      </DIV>
   </xsl:template>


   <xsl:template match="LABEL" mode="form">
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
      <!-- para enviar oculto -->
      <xsl:if test="@enviaroculto='S'">
         <xsl:value-of select="'&#xa;'"/>
         <INPUT TYPE="hidden">
            <xsl:attribute name="NAME">
               <xsl:value-of select="@nombre"/>
            </xsl:attribute>
            <xsl:attribute name="VALUE">
               <xsl:value-of select="$vTxt"/>
            </xsl:attribute>
         </INPUT>
      </xsl:if>
   </xsl:template>




   <xsl:template name="LABEL.enlace">
      <xsl:param name="vTxt"/>
      
      <A HREF="{@enlace}">
         <xsl:if test="@destino!=''">
            <xsl:attribute name="TARGET">
               <xsl:value-of select="@destino"/>
            </xsl:attribute>
         </xsl:if>
         <xsl:choose>
            <xsl:when test="@id!=''"> 
               <SPAN>
                  <xsl:attribute name="ID">
                     <xsl:value-of select="@id"/>
                  </xsl:attribute>
                  <xsl:value-of select="$vTxt"/>
               </SPAN>
            </xsl:when>
            <xsl:otherwise>
                  <xsl:value-of select="$vTxt"/>
            </xsl:otherwise>
         </xsl:choose>
      </A>
   </xsl:template> 


</xsl:stylesheet>

