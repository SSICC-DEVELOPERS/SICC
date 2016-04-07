<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_btn.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    BTN    -->
   <!-- *********** -->

   <!--     head    -->

   <!--     estilo    -->
   <xsl:template match="BTN" mode="estilo">
      <xsl:text>
</xsl:text>

<!--      <xsl:call-template name="IMAGEN-ESTILO"/> -->
   </xsl:template>


   <!--                                                           -->
   <!--                          SCRIPT                           -->
   <!--                                                           -->
   <xsl:template match="BTN" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:text>.images["</xsl:text>
         <xsl:value-of select="../@nombre"/>
         <xsl:number/>
         <xsl:text>"]</xsl:text>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:variable name="vNombre">
         <xsl:value-of select="../@nombre"/> <!-- ../ siempre sera BOTONERA -->
         <xsl:number/>
      </xsl:variable>

      <xsl:variable name="vNumBtn">
         <xsl:number/>
      </xsl:variable>

      <xsl:variable name="vActivo">
         <xsl:choose>
           <xsl:when test="@estado='inactivo'">false</xsl:when>
           <xsl:otherwise>true</xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:if test="@on!=''">
         <xsl:text>&#10;</xsl:text>
         <xsl:value-of select="$vNombre"/>
         <xsl:text>=new Object();</xsl:text>

         <xsl:value-of select="$vNombre"/>
         <xsl:text>.off=new Image();</xsl:text>

         <xsl:value-of select="$vNombre"/>
         <xsl:text>.off.src='</xsl:text>
         <xsl:value-of select="$vgImgPath"/>
         <xsl:value-of select="@off"/>
         <xsl:text>';</xsl:text>

         <xsl:value-of select="$vNombre"/>
         <xsl:text>.dis=new Image();</xsl:text>

	      <xsl:if test="@disable!=''">
			 <xsl:value-of select="$vNombre"/>
			 <xsl:text>.dis.src='</xsl:text>
			 <xsl:value-of select="$vgImgPath"/>
			 <xsl:value-of select="@disable"/>
			 <xsl:text>';</xsl:text>
		</xsl:if>

         <xsl:value-of select="$vNombre"/>
         <xsl:text>.on=new Image();</xsl:text>

         <xsl:value-of select="$vNombre"/>
         <xsl:text>.on.src='</xsl:text>
         <xsl:value-of select="$vgImgPath"/>
         <xsl:value-of select="@on"/>
         <xsl:text>';</xsl:text>

         <xsl:value-of select="$vNombre"/>
         <xsl:text>.nsdoc='</xsl:text>
         <xsl:value-of select="$nsdoc-local"/>
         <xsl:text>';</xsl:text>

         <xsl:value-of select="../@nombre"/><xsl:text>.estado[</xsl:text><xsl:value-of select="$vNumBtn"/><xsl:text>]=</xsl:text><xsl:value-of select="$vActivo"/><xsl:text>;</xsl:text>

      </xsl:if>
      <xsl:text>
</xsl:text>

      <xsl:if test="@on!=''">

   <!--      <xsl:variable name="vUnSoloClick"><xsl:choose><xsl:when test="@unSoloClick and @unSoloClick='S'">true</xsl:when><xsl:otherwise>false</xsl:otherwise></xsl:choose></xsl:variable>-->


         <!-- funciones eventos de las imagenes de la Botonera -->
         <xsl:text>function foc_</xsl:text>
         <xsl:value-of select="$vNombre"/><xsl:text>() { if (</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>.estado[</xsl:text><xsl:value-of select="$vNumBtn"/><xsl:text>]) {</xsl:text>

         <xsl:if test="(@unSoloClick and @unSoloClick='S') or (../@unSoloClick and ../@unSoloClick='S')">
            <xsl:text>set_estado_botonera('</xsl:text>
            <xsl:value-of select="../@nombre"/>
            <xsl:text>', </xsl:text>
            <xsl:value-of select="$vNumBtn"/>
            <xsl:text>, 'inactivo');&#xa;</xsl:text>
         </xsl:if>

         <xsl:variable name="vTxtFunc">
            <xsl:if test="@funcion">
               <xsl:call-template name="escapa">
                   <xsl:with-param name="text" select="@funcion"/>
                   <xsl:with-param name="caracter">&quot;</xsl:with-param>
               </xsl:call-template>
            </xsl:if>
         </xsl:variable>         
         <xsl:text>DrdGuardaTraza("EV-USU, pulsado en &lt;BOTONERA nombre=\"</xsl:text>
         <xsl:value-of select="../@nombre"/>
         <xsl:text>\"/&gt; el btn en posicion </xsl:text>
         <xsl:value-of select="$vNumBtn"/>
         <xsl:text> &lt;BTN funcion=\"</xsl:text>
         <xsl:value-of select="$vTxtFunc"/>
         <xsl:text>\"/&gt;");&#xa;</xsl:text>
         
         <xsl:value-of select="@funcion"/>
         <xsl:text> }} &#xa;</xsl:text>

         <xsl:text>function fomo_</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>() { if (</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>.estado[</xsl:text><xsl:value-of select="$vNumBtn"/><xsl:text>]) { img_to('</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>','</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>.off'); }}
</xsl:text>
         <xsl:text>function fomov_</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>() { if (</xsl:text><xsl:value-of select="../@nombre"/><xsl:text>.estado[</xsl:text><xsl:value-of select="$vNumBtn"/><xsl:text>]) { img_to('</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>','</xsl:text><xsl:value-of select="$vNombre"/><xsl:text>.on'); window.status='</xsl:text><xsl:value-of select="@texto"/><xsl:text>';return true; }}
</xsl:text>
      </xsl:if>

      <xsl:apply-templates mode="script"/>

   </xsl:template>


   <!--     body    -->
   <xsl:template match="BTN" mode="body">

      <xsl:variable name="vNombre">
         <xsl:value-of select="../@nombre"/> <!-- ../ siempre sera BOTONERA -->
         <xsl:number/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@x!='' or @y!=''">
            <DIV>
               <xsl:call-template name="BTN">
                  <xsl:with-param name="nombre" select="$vNombre"/>
               </xsl:call-template>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
	         <xsl:choose>
		         <xsl:when test="../@tipo='V'">
                  <TR><TD><xsl:choose>
		                  <xsl:when test="@on">
		                     <xsl:call-template name="BTN">
		                        <xsl:with-param name="nombre" select="$vNombre"/>
		                     </xsl:call-template>
		                  </xsl:when>
		                  <xsl:otherwise>
		                     <xsl:call-template name="IMG-BTN">
		                        <xsl:with-param name="nombre" select="$vNombre"/>
		                     </xsl:call-template>
		                  </xsl:otherwise>
		               </xsl:choose></TD>
                  </TR></xsl:when>
		         <xsl:otherwise>
		            <TD>
		               <xsl:choose>
		                  <xsl:when test="@on">
		                     <xsl:call-template name="BTN">
		                        <xsl:with-param name="nombre" select="$vNombre"/>
		                     </xsl:call-template>
		                  </xsl:when>
		                  <xsl:otherwise>
		                     <xsl:call-template name="IMG-BTN">
		                        <xsl:with-param name="nombre" select="$vNombre"/>
		                     </xsl:call-template>
		                  </xsl:otherwise>
		               </xsl:choose>
		            </TD>
                     <xsl:if test="../@espaciado"><xsl:call-template name="ESPACIADO-BTNS"/></xsl:if> 
		         </xsl:otherwise>
		 </xsl:choose>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>


   <xsl:template name="BTN">
      <xsl:param name="nombre"/>
      <A HREF="javascript:void(null);">
         <xsl:attribute name="onClick">
            <xsl:text>foc_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>();return false;</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="onMouseOut">
            <xsl:text>fomo_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>();</xsl:text>
         </xsl:attribute>
         <xsl:attribute name="onMouseOver">
            <xsl:text>fomov_</xsl:text><xsl:value-of select="$nombre"/><xsl:text>();</xsl:text>
         </xsl:attribute>
         <xsl:call-template name="IMG-BTN">
            <xsl:with-param name="nombre" select="$nombre"/>
         </xsl:call-template>
      </A>
   </xsl:template>


   <xsl:template name="IMG-BTN">
      <xsl:param name="nombre"/>

      <xsl:variable name="vTxt">
         <xsl:choose>
            <xsl:when test="@cod">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="@texto"/>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>



      <IMG NAME="{$nombre}" src="{concat($vgImgPath,@off)}" BORDER="0" ALT="{$vTxt}">
         <xsl:attribute name="src">
            <xsl:choose>
               <xsl:when test="@disable!='' and @estado='inactivo'">
                  <xsl:value-of select="concat($vgImgPath,@disable)"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="concat($vgImgPath,@off)"/>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:attribute>
      </IMG>
   </xsl:template>

   <xsl:template name="ESPACIADO-BTNS">
      <TD>
      <IMG SRC="{$imgTranspPath}" BORDER="0" width="{../@espaciado}"/>
      </TD>
   </xsl:template>



</xsl:stylesheet>

