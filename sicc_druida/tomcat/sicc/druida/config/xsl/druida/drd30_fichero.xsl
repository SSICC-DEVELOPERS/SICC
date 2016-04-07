<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_fichero.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    FICHERO    -->
   <!-- ********** -->

   <!--    head    -->
   <xsl:template match="FICHERO" mode="head">
      <xsl:if test="generate-id(//FICHERO[1]) = generate-id()">
         <SCRIPT TYPE="text/javascript" SRC="{$jsDruidaPath}fichero.js">
            <!-- debe encontrar la etiqueta de cierre, y por esto se pone el text -->
            <xsl:text> </xsl:text>
         </SCRIPT>
      </xsl:if>
      <xsl:apply-templates mode="head"/>
   </xsl:template>


   <!--   estilo  -->
   <xsl:template match="FICHERO" mode="estilo">
      <xsl:if test="@x and @y">
         <xsl:text>&#xa;#</xsl:text><xsl:value-of select="@nombre"/><xsl:text>CapRecipnt {</xsl:text>
         <xsl:text>position:absolute;visibility:inherit;padding:0px;</xsl:text>
         <xsl:text>left:</xsl:text><xsl:value-of select="@x"/><xsl:text>;</xsl:text>
         <xsl:text>top:</xsl:text><xsl:value-of select="@y"/><xsl:text>;</xsl:text>
         <xsl:text>}</xsl:text>
      </xsl:if>
      <xsl:apply-templates mode="estilo"/>
   </xsl:template>



   <!--   script  -->
   <xsl:template match="FICHERO" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.',@nombre,'_form')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:text>&#10;</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>=new Fichero('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="$nsdoc-local"/>
      <xsl:text>','</xsl:text>

      <xsl:choose>
         <xsl:when test="@funcion">
            <xsl:value-of select="@funcion"/>
            <xsl:text>'); &#10;</xsl:text>
            <xsl:value-of select="@nombre"/><xsl:text>.isFunction=true;&#10;</xsl:text>

         </xsl:when>
         <xsl:otherwise>
            <xsl:value-of select="@campo"/>
            <xsl:text>'); &#10;</xsl:text>
         </xsl:otherwise>
      </xsl:choose> 


      <xsl:if test="@onsubmit">
      <xsl:value-of select="@nombre"/><xsl:text>.onSubmit="</xsl:text><xsl:value-of select="@onsubmit"/><xsl:text>";&#10;</xsl:text>
      </xsl:if>

   </xsl:template>



   <!--   body  -->

   <xsl:template match="FICHERO" mode="body">
      <xsl:choose>
         <xsl:when test="@x and @y">
            <DIV ID="{@nombre}CapRecipnt">
               <xsl:apply-templates select="." mode="elBodyNormal"/>
            </DIV>
         </xsl:when>
         <xsl:otherwise>
            <xsl:apply-templates select="." mode="elBodyNormal"/>
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <xsl:template match="FICHERO" mode="elBodyNormal">

      <xsl:variable name="vNombreBoton">
         <xsl:choose>
            <xsl:when test="@texto">
               <xsl:value-of select="@texto"/>
            </xsl:when>
            <xsl:when test="@cod">
               <xsl:call-template name="langtxt">
                  <xsl:with-param name="pCod" select="@cod"/>
               </xsl:call-template>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text>Subir</xsl:text>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:variable name="vComprimir">
         <xsl:choose>
            <xsl:when test="@comprimir">
               <xsl:value-of select="@comprimir"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text>no</xsl:text>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vRuta">
         <xsl:choose>
            <xsl:when test="@drpath">
               <xsl:value-of select="@drpath"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text></xsl:text>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vCopiar">
         <xsl:choose>
            <xsl:when test="@copiar">
               <xsl:value-of select="@copiar"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text></xsl:text>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vTarget">
         <xsl:choose>
            <xsl:when test="@target">
               <xsl:value-of select="@target"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text></xsl:text>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable>

      <xsl:variable name="vDescomprimir">
         <xsl:choose>
            <xsl:when test="@descomprimir">
               <xsl:value-of select="@descomprimir"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:text>no</xsl:text>
            </xsl:otherwise>
         </xsl:choose> 
      </xsl:variable> 

      <xsl:variable name="vON">
         <xsl:choose>
            <xsl:when test="@ON">
               <xsl:value-of select="@ON"/>
            </xsl:when>
            <xsl:otherwise>ObjetoFichero</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
      <FORM name="{@nombre}_form" ACTION="{$ProxyServlet}?ON={$vON}" METHOD="post" ENCTYPE="multipart/form-data">

         <xsl:if test="@target">
            <xsl:attribute name="TARGET">
               <xsl:value-of select="$vTarget"/>
            </xsl:attribute>
         </xsl:if>

         <INPUT TYPE="hidden" NAME="comprimir" VALUE="{$vComprimir}"/><xsl:text> </xsl:text>
	      <INPUT TYPE="hidden" NAME="copiar" VALUE="{$vCopiar}"/><xsl:text> </xsl:text>
         <INPUT TYPE="hidden" NAME="descomprimir" VALUE="{$vDescomprimir}"/><xsl:text> </xsl:text>
         <INPUT TYPE="hidden" NAME="drpath" VALUE="{$vRuta}"/><xsl:text> </xsl:text>

         <INPUT TYPE="file" NAME="archivoPrincipal" SIZE="{@size}" MAXLENGTH="{@max}" onkeydown="this.blur()">
            <xsl:if test="@id">
               <xsl:attribute name="class">
                  <xsl:value-of select="@id"/>
               </xsl:attribute>
            </xsl:if>
            <xsl:if test="@readonly or @onshtab">
               <xsl:attribute name="onkeydown">
                  <xsl:if test="@onshtab">window.event.cancelBubble=true;if (event.shiftKey &amp;&amp; event.keyCode==9){<xsl:value-of select="@onshtab"/>} </xsl:if>
                  <xsl:if test="@onshtab and @readonly"> else </xsl:if>
                  <xsl:if test="@readonly">onKeyDownFicheroReadOnly(this);</xsl:if>
               </xsl:attribute>
            </xsl:if>
         </INPUT>
         <xsl:text> </xsl:text>

       
         <INPUT TYPE="hidden" NAME="fichero_nombre" VALUE="{@nombre}"/><xsl:text> </xsl:text>

         <INPUT TYPE="button" NAME="boton_ok" VALUE="{$vNombreBoton}" ONCLICK="{@nombre}.submit();">
            <xsl:if test="@idenviar">
               <xsl:attribute name="class">
                  <xsl:value-of select="@idenviar"/>
               </xsl:attribute>
            </xsl:if>
            <xsl:if test="not(@reset or @codReset) and @ontab"><!-- si no hay reset soy el ultimo boton -->
               <xsl:attribute name="onkeydown">if (!event.shiftKey &amp;&amp; event.keyCode==9){<xsl:value-of select="@ontab"/>}</xsl:attribute>
            </xsl:if>
         </INPUT>
         <xsl:text> </xsl:text>

         <xsl:variable name="vReset">
            <xsl:choose>
               <xsl:when test="@codReset">
                  <xsl:call-template name="langtxt">
                     <xsl:with-param name="pCod" select="@codReset"/>
                  </xsl:call-template>
               </xsl:when>
               <xsl:when test="@reset">
                  <xsl:value-of select="@reset"/>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:text>Reset</xsl:text>
               </xsl:otherwise>
            </xsl:choose> 
         </xsl:variable> 

         <xsl:choose>
            <xsl:when test="@reset or @codReset">
               <INPUT TYPE="reset" NAME="boton_reset" value="{$vReset}">
                  <xsl:if test="@idenviar">
                     <xsl:attribute name="class">
                        <xsl:value-of select="@idenviar"/>
                     </xsl:attribute>
                  </xsl:if>
                  <xsl:if test="@ontab"><!-- soy el ultimo boton -->
                     <xsl:attribute name="onkeydown">if (!event.shiftKey &amp;&amp; event.keyCode==9){<xsl:value-of select="@ontab"/>}</xsl:attribute>
                  </xsl:if>
               </INPUT>
            </xsl:when>
            <xsl:otherwise>
            </xsl:otherwise>
         </xsl:choose> 
     
     </FORM>

   </xsl:template>

</xsl:stylesheet>

