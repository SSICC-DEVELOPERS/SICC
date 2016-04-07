<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
   INDRA/CAR/Druida 3.0
   $Id: drd30_labelc.xsl,v 1.1 2009/12/03 19:03:46 pecbazalar Exp $
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                version="1.0">

   <!--    LABELC    -->
   <!-- *********** -->

   <!--     head    -->
   <xsl:template match="LABELC" mode="head">
   </xsl:template>


   <!--     estilo    -->
   <xsl:template match="LABELC" mode="estilo">
      <xsl:text>&#xa;</xsl:text>

   <!-- Capas relativas -->
      <xsl:text>#</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>Div {</xsl:text>
      <xsl:text>position:relative;</xsl:text>
      <xsl:if test="@ancho and not(@ancho='') and @alto and not(@alto='')">
         <xsl:text>width:</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>;height:</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>;</xsl:text>
         <xsl:text>clip:rect(0,</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>,</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>,0);</xsl:text>
      </xsl:if>
      <xsl:text>}</xsl:text>
      <xsl:text>&#xa;</xsl:text>
      <xsl:if test="@ancho and not(@ancho='') and @alto and not(@alto='')">
         <xsl:text>#</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text> {</xsl:text>
         <xsl:text>position:absolute;</xsl:text>
         <xsl:text>width:</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>;height:</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>;clip:rect(0,</xsl:text>
         <xsl:value-of select="@ancho"/>
         <xsl:text>,</xsl:text>
         <xsl:value-of select="@alto"/>
         <xsl:text>,0);</xsl:text>
      </xsl:if>
      <xsl:text>}</xsl:text>

   </xsl:template>


   <!--     script    -->

   <xsl:template match="LABELC" mode="script">
      <xsl:param name="nsdoc"/>

      <!-- Si el ultimo elemento de nsdoc es una TABLA, para el LABELC hay que quitarlo -->
      <xsl:variable name="vNombreTabla">
         <xsl:value-of select="ancestor::TABLA/@nombre"/>
      </xsl:variable>

      <xsl:variable name="vNewNSdoc">
         <xsl:choose>
            <xsl:when test="string-length($vNombreTabla) > 0 and substring($nsdoc,string-length($nsdoc) - string-length($vNombreTabla)+1,string-length($vNombreTabla)) = $vNombreTabla">
               <xsl:value-of select="substring($nsdoc,1,string-length($nsdoc) - string-length($vNombreTabla)-1)" />
            </xsl:when> 
            <xsl:otherwise>
               <xsl:value-of select="$nsdoc" />
            </xsl:otherwise>
         </xsl:choose>
      </xsl:variable>

      <xsl:variable name="nsdoc-parte-local">
         <xsl:value-of select="concat('.', @nombre, 'Div.document.', @nombre, '.document')"/>
      </xsl:variable>
      <xsl:variable name="nsdoc-local">
         <xsl:value-of select="concat($vNewNSdoc, $nsdoc-parte-local)"/> 
<!--         <xsl:value-of select="concat($nsdoc, $nsdoc-parte-local)"/> -->
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
      <xsl:choose>
         <xsl:when test="@id and not(string-length(@id)=0)"><xsl:value-of select="@id"/></xsl:when> 
         <xsl:otherwise>
            <xsl:choose>
               <xsl:when test="name(..)='td' or name(..)='TD' or name(..)='Td' or name(..)='tD'">
                  <xsl:choose>
                     <xsl:when test="../@class"><xsl:value-of select="../@class"/></xsl:when>
                     <xsl:when test="../@CLASS"><xsl:value-of select="../@CLASS"/></xsl:when>
                     <xsl:otherwise/>
                  </xsl:choose>
               </xsl:when>
               <xsl:when test="name(..)='COL'">
                  <xsl:choose>
                     <xsl:when test="../@id"><xsl:value-of select="../@id"/></xsl:when>
                     <xsl:when test="../@ID"><xsl:value-of select="../@ID"/></xsl:when>
                     <xsl:otherwise/>
                  </xsl:choose>
               </xsl:when>
               <xsl:otherwise/>
            </xsl:choose>
         </xsl:otherwise>
      </xsl:choose>
      <xsl:text>'; </xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.TC='LabelR';</xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.W='</xsl:text>
      <xsl:choose>
         <xsl:when test="@ancho and not(@ancho='')"><xsl:value-of select="@ancho"/></xsl:when> 
         <xsl:otherwise>0</xsl:otherwise>
      </xsl:choose>
      <xsl:text>'; </xsl:text>

      <xsl:value-of select="@nombre"/>
      <xsl:text>.H='</xsl:text>
      <xsl:choose>
         <xsl:when test="@alto and not(@alto='')"><xsl:value-of select="@alto"/></xsl:when> 
         <xsl:otherwise>0</xsl:otherwise>
      </xsl:choose>
      <xsl:text>'; </xsl:text>

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

   <!--   dinamico  -->
   <xsl:template match="LABELC" mode="dinamico">
      <xsl:text>&#xa;DrMainEstatico.txt_to('</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>','</xsl:text>
      <xsl:call-template name="escapa">
          <xsl:with-param name="text" select="normalize-space(translate(@valor, '&#xa;',' '))"/>
          <xsl:with-param name="caracter">'</xsl:with-param>
      </xsl:call-template>
      <xsl:text>');</xsl:text>
   </xsl:template>


   <!--   init  -->
   <xsl:template match="LABELC" mode="init">
      <!-- Introduce en el array de componentes para DruidaBack sus datos -->
      <xsl:text>d3_componentes[d3_componentes.length]=['</xsl:text>
      <xsl:value-of select="name()"/>
      <xsl:text>','</xsl:text>
      <xsl:value-of select="@nombre"/>
      <xsl:text>'];</xsl:text>

<!--	      <xsl:if test="not(@enlace) or string-length(@enlace)=0">
	-->
         <xsl:variable name="vTxt">
            <xsl:call-template name="SetTxtComponente"/>
         </xsl:variable>

         <xsl:text>txt_to('</xsl:text>
         <xsl:value-of select="@nombre"/>
         <xsl:text>','</xsl:text>
         <xsl:value-of select="$vTxt"/>
         <xsl:text>');</xsl:text>
<!--	      </xsl:if>
	-->
      
   </xsl:template>


   <!--     body    -->
   <xsl:template match="LABELC" mode="body">
      <xsl:variable name="vTxt">
         <xsl:call-template name="SetTxtComponente.i10n"/>
      </xsl:variable>

      <xsl:choose>
         <xsl:when test="@enlace and string-length(@enlace)>0">
            <xsl:call-template name="LABELC-BODY-ENLACE">
               <xsl:with-param name="pTexto" select="$vTxt"/>
            </xsl:call-template>               
         </xsl:when>
         <xsl:otherwise>
            <xsl:call-template name="LABELC-BODY-NORMAL">
               <xsl:with-param name="pTexto" select="$vTxt"/>
            </xsl:call-template>               
         </xsl:otherwise>
      </xsl:choose>
   </xsl:template>

   <xsl:template name="LABELC-BODY-NORMAL">
      <xsl:param name="pTexto"/>
      <DIV ID="{concat(@nombre,'Div')}">

         <DIV ID="{@nombre}">

            <xsl:choose>
               <xsl:when test="@id!=''"> <!-- length>0 -->
                  <TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0">
                     <TR>
                        <TD ID="{@id}">
                           <xsl:if test="@ancho">
                              <xsl:attribute name="WIDTH">
                                 <xsl:value-of select="@ancho"/>
                              </xsl:attribute>
                           </xsl:if>
                           <xsl:if test="not(@ancho)">
                              <xsl:attribute name="nowrap"> </xsl:attribute>
                           </xsl:if>
                           <xsl:if test="@alto">
                              <xsl:attribute name="HEIGHT">
                                 <xsl:value-of select="@alto"/>
                              </xsl:attribute>
                           </xsl:if>
                           <xsl:value-of select="$pTexto"/>
                        </TD>
                     </TR>
                  </TABLE>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:value-of select="$pTexto"/>
               </xsl:otherwise>
            </xsl:choose>
         </DIV>
         
         <!-- plantilla recursiva para simular bucle for -->
         <xsl:variable name="vCont" select="@filas - 1"/>
         <xsl:call-template name="LABELCFILAS">
            <xsl:with-param name="vCont" select="$vCont"/>
         </xsl:call-template>

      </DIV>

   </xsl:template>

   <xsl:template name="LABELC-BODY-ENLACE">
      <xsl:param name="pTexto"/>

      <DIV ID="{concat(@nombre,'Div')}">

         <DIV ID="{@nombre}">

            <xsl:choose>
               <xsl:when test="@id!=''"> <!-- length>0 -->
                  <TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0">
                     <TR>
                        <TD ID="{@id}">
                           <xsl:if test="@ancho">
                              <xsl:attribute name="WIDTH">
                                 <xsl:value-of select="@ancho"/>
                              </xsl:attribute>
                           </xsl:if>
                           <xsl:if test="@alto">
                              <xsl:attribute name="HEIGHT">
                                 <xsl:value-of select="@alto"/>
                              </xsl:attribute>
                           </xsl:if>


                              <xsl:call-template name="LABEL.enlace">
                                 <xsl:with-param name="vTxt" select="$pTexto"/>
                              </xsl:call-template>
                        
                        
                        </TD>
                     </TR>
                  </TABLE>
               </xsl:when>
               <xsl:otherwise>
                  <xsl:call-template name="LABEL.enlace">
                     <xsl:with-param name="vTxt" select="$pTexto"/>
                  </xsl:call-template>
               </xsl:otherwise>
            </xsl:choose>
         </DIV>
         
         <!-- plantilla recursiva para simular bucle for -->
         <xsl:variable name="vCont" select="@filas - 1"/>
         <xsl:call-template name="LABELCFILAS">
            <xsl:with-param name="vCont" select="$vCont"/>
         </xsl:call-template>

      </DIV>

   </xsl:template>

   <xsl:template name="LABELCFILAS">
      <xsl:param name="vCont"/>
      <xsl:if test="$vCont > 0">
         <BR/>
         <!-- recursividad -->
         <xsl:call-template name="LABELCFILAS">
            <xsl:with-param name="vCont" select="$vCont - 1"/>
         </xsl:call-template>
      </xsl:if>
   </xsl:template>




   <xsl:template match="LABELC" mode="form">
      <xsl:variable name="vTxt">
         <xsl:call-template name="SetTxtComponente"/>
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
         <!--      <xsl:value-of select="@valor"/> -->
            </xsl:attribute>
         </INPUT>
      </xsl:if> 
   </xsl:template>

</xsl:stylesheet>

