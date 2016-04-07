<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_lista.xsl,v 1.1 2009/12/03 19:03:44 pecbazalar Exp $
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">


   <xsl:include href="drd30_NTlista.xsl"/>
   <xsl:include href="drd30_NTlistadoa.xsl"/>

   <!--                                                          -->
   <!--                          HEAD                            -->
   <!--                                                          -->
   <xsl:template match="LISTA" mode="head">
      <xsl:if test="@seleccion='boton'">
         <SCRIPT TYPE="text/javascript">
            <xsl:attribute name="SRC">
               <xsl:value-of select="$jsDruidaPath"/>
               <xsl:text>listadoa.js</xsl:text>
            </xsl:attribute>
            <xsl:text> </xsl:text>
         </SCRIPT>
      </xsl:if>
      <xsl:apply-templates mode="head"/>

   </xsl:template>


   <!--                                                          -->
   <!--                         ESTILO                           -->
   <!--                                                          -->
   <xsl:template match="LISTA" mode="estilo">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:choose>
        <xsl:when test="@seleccion='fila'">
            <xsl:call-template name="LISTAestilo">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
            <xsl:call-template name="LISTADOAestilo">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>

      <xsl:apply-templates mode="estilo">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template>

   <!--                                                           -->
   <!--                            INIT                           -->
   <!--                                                           -->
   <xsl:template match="LISTA" mode="init">
      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/><xsl:value-of select="@seleccion"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>


      <xsl:choose>
        <xsl:when test="@seleccion='fila'">
            <xsl:call-template name="LISTAinit"/>
        </xsl:when>
        <xsl:otherwise>
            <xsl:call-template name="LISTADOAinit"/>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates mode="init"/>

   </xsl:template>


   <xsl:template match="LISTA" mode="dinamico">
      <xsl:choose>
        <xsl:when test="@seleccion='fila'">
            <!--<xsl:call-template name="LISTAdinamico"/>--><!-- no implementado -->
        </xsl:when>
        <xsl:otherwise>
            <xsl:call-template name="LISTADOAdinamico"/>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:apply-templates mode="dinamico"/>
   </xsl:template>


   <!--                                                           -->
   <!--                           SCRIPT                          -->
   <!--                                                           -->
   <xsl:template match="LISTA" mode="script">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
<!--
         <xsl:text>.</xsl:text>
      </xsl:variable> -->
      <xsl:variable name="nsdoc-local">
<!--         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/> -->
         <xsl:value-of select="concat($nsdoc,'.')"/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@seleccion='fila'">
            <xsl:call-template name="LISTAscript">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="LISTADOAscript">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc"/></xsl:with-param>
            </xsl:call-template>
         </xsl:otherwise>
      </xsl:choose>

<!--
      <xsl:variable name="nombrecapa">
         <xsl:choose>
            <xsl:when test="@seleccion='fila'">
               <xsl:value-of select="concat(@nombre,'Div','.document')"/>
            </xsl:when>
            <xsl:otherwise>
               <xsl:value-of select="concat(@nombre,'capa','.document')"/>
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
-->
      <xsl:apply-templates mode="script">
         <xsl:with-param name="nsdoc">

<!--            <xsl:value-of select="concat($nsdoc-local,$nombrecapa)"/>  -->
<!--            <xsl:value-of select="$nsdoc-local"/>  -->
            <xsl:value-of select="$nsdoc"/>  

         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template>



   <!--                                                          -->
   <!--                           BODY                           -->
   <!--                                                          -->
   <xsl:template match="LISTA" mode="body">
      <xsl:param name="nsdoc"/>
      <xsl:variable name="nsdoc-parte-local"/>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($nsdoc,$nsdoc-parte-local)"/>
      </xsl:variable>

      <xsl:choose>
        <xsl:when test="@seleccion='fila'">
            <xsl:call-template name="LISTAbody">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
        </xsl:when>
        <xsl:otherwise>
            <xsl:call-template name="LISTADOAbody">
               <xsl:with-param name="nsdoc-local"><xsl:value-of select="$nsdoc-local"/></xsl:with-param>
            </xsl:call-template>
        </xsl:otherwise>
      </xsl:choose>


      <xsl:apply-templates mode="body">
         <xsl:with-param name="nsdoc">
            <xsl:value-of select="$nsdoc-local"/>
         </xsl:with-param>
      </xsl:apply-templates>

   </xsl:template>


   <xsl:template match="CABECERA">

      <xsl:variable name="vIncY">
         <xsl:choose>
            <xsl:when test="@incy">
               <xsl:value-of select="@incy"/>
            </xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="vAncho">
         <xsl:choose>
            <xsl:when test="$vIncY != 0">16</xsl:when>
            <xsl:otherwise>0</xsl:otherwise>
         </xsl:choose>
      </xsl:variable>
        
      <TABLE BGCOLOR="" BORDER="0" CELLPADDING="0" CELLSPACING="0">
         <xsl:attribute name="WIDTH">
<!--                     <xsl:value-of select="../@ancho - 2 * ../@pixelsborde"/> -->
            <xsl:value-of select="../PRESENTACION/@ancho + $vAncho"/>
         </xsl:attribute>
         <TR>
         <xsl:for-each select="COL">
            <TD ID="{@id}" WIDTH="{@ancho}">
               <IMG src="{$imgTranspPath}"  height="1">
                  <xsl:if test="@ancho">
                     <xsl:attribute name="width">
                        <xsl:value-of select="@ancho"/>
                     </xsl:attribute> 
                  </xsl:if> 
               </IMG><br/>
               <xsl:text disable-output-escaping="yes"> </xsl:text>
               <xsl:choose>
                  <xsl:when test="@tooltip">
                     <xsl:variable name="vTxt">
                        <xsl:call-template name="langtxt">
                           <xsl:with-param name="pCod" select="@tooltip"/>
                        </xsl:call-template>
                     </xsl:variable>

                     <A id="{@id}" href="javascript:void(null)" 
                        onmouseover="tooltip(event, '{$vTxt}')" onmouseout="tooltip()">
                        <xsl:apply-templates mode="body"/>
                     </A>
                  </xsl:when>
                  <xsl:otherwise>
                     <xsl:apply-templates mode="body"/>
                  </xsl:otherwise>
               </xsl:choose> 
               <xsl:text disable-output-escaping="yes"> </xsl:text>
            </TD>
         </xsl:for-each>
         </TR>
      </TABLE>

   </xsl:template>



   <xsl:template match="LISTA" mode="form">

      <xsl:if test="@seleccion='fila'">

         <xsl:for-each select="PRESENTACION/COL[@enviar='S']">
         <xsl:text>
   </xsl:text>
         <INPUT TYPE="hidden">
            <xsl:attribute name="NAME">
               <xsl:value-of select="../../@nombre"/><xsl:text>H</xsl:text><xsl:value-of select="position()" />
            </xsl:attribute>
            <xsl:attribute name="VALUE"/>
         </INPUT>
         </xsl:for-each>

      </xsl:if>

   </xsl:template>


   <xsl:template match="COL" mode="body">
   </xsl:template>

</xsl:stylesheet>

